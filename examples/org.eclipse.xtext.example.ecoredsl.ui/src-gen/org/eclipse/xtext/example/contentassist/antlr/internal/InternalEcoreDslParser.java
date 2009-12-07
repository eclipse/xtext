package org.eclipse.xtext.example.contentassist.antlr.internal; 

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
import org.eclipse.xtext.example.services.EcoreDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalEcoreDslParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_SERIALIZABLE", "RULE_BAG", "RULE_RANDOM", "RULE_READONLY", "RULE_LOCAL", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'class'", "'ref'", "'void'", "'.'", "'$'", "'import'", "';'", "'='", "'package'", "'nsURI'", "'nsPrefix'", "'{'", "'}'", "'datatype'", "':'", "'@'", "'('", "')'", "','", "'<'", "'>'", "'extends'", "'attr'", "'['", "']'", "'..'", "'#'", "'enum'", "'?'", "'super'", "'op'", "'throws'", "'-'", "'abstract'", "'interface'", "'ID'", "'volatile'", "'transient'", "'unsettable'", "'derived'", "'val'"
    };
    public static final int RULE_ML_COMMENT=12;
    public static final int RULE_ID=5;
    public static final int RULE_WS=14;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_LOCAL=11;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=15;
    public static final int RULE_RANDOM=9;
    public static final int RULE_BAG=8;
    public static final int RULE_SERIALIZABLE=7;
    public static final int RULE_READONLY=10;
    public static final int RULE_SL_COMMENT=13;

        public InternalEcoreDslParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g"; }


     
     	private EcoreDslGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(EcoreDslGrammarAccess grammarAccess) {
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




    // $ANTLR start entryRuleEcoreDsl
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:60:1: entryRuleEcoreDsl : ruleEcoreDsl EOF ;
    public final void entryRuleEcoreDsl() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:60:19: ( ruleEcoreDsl EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:61:1: ruleEcoreDsl EOF
            {
             before(grammarAccess.getEcoreDslRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEcoreDsl_in_entryRuleEcoreDsl60);
            ruleEcoreDsl();
            _fsp--;

             after(grammarAccess.getEcoreDslRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEcoreDsl67); 

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
    // $ANTLR end entryRuleEcoreDsl


    // $ANTLR start ruleEcoreDsl
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:68:1: ruleEcoreDsl : ( ( rule__EcoreDsl__Group__0 ) ) ;
    public final void ruleEcoreDsl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:72:2: ( ( ( rule__EcoreDsl__Group__0 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:73:1: ( ( rule__EcoreDsl__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:73:1: ( ( rule__EcoreDsl__Group__0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:74:1: ( rule__EcoreDsl__Group__0 )
            {
             before(grammarAccess.getEcoreDslAccess().getGroup()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:75:1: ( rule__EcoreDsl__Group__0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:75:2: rule__EcoreDsl__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EcoreDsl__Group__0_in_ruleEcoreDsl94);
            rule__EcoreDsl__Group__0();
            _fsp--;


            }

             after(grammarAccess.getEcoreDslAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleEcoreDsl


    // $ANTLR start entryRuleReferencedMetamodel
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:87:1: entryRuleReferencedMetamodel : ruleReferencedMetamodel EOF ;
    public final void entryRuleReferencedMetamodel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:87:30: ( ruleReferencedMetamodel EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:88:1: ruleReferencedMetamodel EOF
            {
             before(grammarAccess.getReferencedMetamodelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel120);
            ruleReferencedMetamodel();
            _fsp--;

             after(grammarAccess.getReferencedMetamodelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferencedMetamodel127); 

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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:95:1: ruleReferencedMetamodel : ( ( rule__ReferencedMetamodel__Group__0 ) ) ;
    public final void ruleReferencedMetamodel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:99:2: ( ( ( rule__ReferencedMetamodel__Group__0 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:100:1: ( ( rule__ReferencedMetamodel__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:100:1: ( ( rule__ReferencedMetamodel__Group__0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:101:1: ( rule__ReferencedMetamodel__Group__0 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getGroup()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:102:1: ( rule__ReferencedMetamodel__Group__0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:102:2: rule__ReferencedMetamodel__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group__0_in_ruleReferencedMetamodel154);
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


    // $ANTLR start entryRuleEPackageDecl
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:114:1: entryRuleEPackageDecl : ruleEPackageDecl EOF ;
    public final void entryRuleEPackageDecl() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:114:23: ( ruleEPackageDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:115:1: ruleEPackageDecl EOF
            {
             before(grammarAccess.getEPackageDeclRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEPackageDecl_in_entryRuleEPackageDecl180);
            ruleEPackageDecl();
            _fsp--;

             after(grammarAccess.getEPackageDeclRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEPackageDecl187); 

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
    // $ANTLR end entryRuleEPackageDecl


    // $ANTLR start ruleEPackageDecl
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:122:1: ruleEPackageDecl : ( ( rule__EPackageDecl__Group__0 ) ) ;
    public final void ruleEPackageDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:126:2: ( ( ( rule__EPackageDecl__Group__0 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:127:1: ( ( rule__EPackageDecl__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:127:1: ( ( rule__EPackageDecl__Group__0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:128:1: ( rule__EPackageDecl__Group__0 )
            {
             before(grammarAccess.getEPackageDeclAccess().getGroup()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:129:1: ( rule__EPackageDecl__Group__0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:129:2: rule__EPackageDecl__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EPackageDecl__Group__0_in_ruleEPackageDecl214);
            rule__EPackageDecl__Group__0();
            _fsp--;


            }

             after(grammarAccess.getEPackageDeclAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleEPackageDecl


    // $ANTLR start entryRuleSubEPackageDecl
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:141:1: entryRuleSubEPackageDecl : ruleSubEPackageDecl EOF ;
    public final void entryRuleSubEPackageDecl() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:141:26: ( ruleSubEPackageDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:142:1: ruleSubEPackageDecl EOF
            {
             before(grammarAccess.getSubEPackageDeclRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSubEPackageDecl_in_entryRuleSubEPackageDecl240);
            ruleSubEPackageDecl();
            _fsp--;

             after(grammarAccess.getSubEPackageDeclRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSubEPackageDecl247); 

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
    // $ANTLR end entryRuleSubEPackageDecl


    // $ANTLR start ruleSubEPackageDecl
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:149:1: ruleSubEPackageDecl : ( ( rule__SubEPackageDecl__Group__0 ) ) ;
    public final void ruleSubEPackageDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:153:2: ( ( ( rule__SubEPackageDecl__Group__0 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:154:1: ( ( rule__SubEPackageDecl__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:154:1: ( ( rule__SubEPackageDecl__Group__0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:155:1: ( rule__SubEPackageDecl__Group__0 )
            {
             before(grammarAccess.getSubEPackageDeclAccess().getGroup()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:156:1: ( rule__SubEPackageDecl__Group__0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:156:2: rule__SubEPackageDecl__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__SubEPackageDecl__Group__0_in_ruleSubEPackageDecl274);
            rule__SubEPackageDecl__Group__0();
            _fsp--;


            }

             after(grammarAccess.getSubEPackageDeclAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleSubEPackageDecl


    // $ANTLR start entryRuleEClassifierDecl
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:168:1: entryRuleEClassifierDecl : ruleEClassifierDecl EOF ;
    public final void entryRuleEClassifierDecl() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:168:26: ( ruleEClassifierDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:169:1: ruleEClassifierDecl EOF
            {
             before(grammarAccess.getEClassifierDeclRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEClassifierDecl_in_entryRuleEClassifierDecl300);
            ruleEClassifierDecl();
            _fsp--;

             after(grammarAccess.getEClassifierDeclRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEClassifierDecl307); 

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
    // $ANTLR end entryRuleEClassifierDecl


    // $ANTLR start ruleEClassifierDecl
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:176:1: ruleEClassifierDecl : ( ( rule__EClassifierDecl__Alternatives ) ) ;
    public final void ruleEClassifierDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:180:2: ( ( ( rule__EClassifierDecl__Alternatives ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:181:1: ( ( rule__EClassifierDecl__Alternatives ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:181:1: ( ( rule__EClassifierDecl__Alternatives ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:182:1: ( rule__EClassifierDecl__Alternatives )
            {
             before(grammarAccess.getEClassifierDeclAccess().getAlternatives()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:183:1: ( rule__EClassifierDecl__Alternatives )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:183:2: rule__EClassifierDecl__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__EClassifierDecl__Alternatives_in_ruleEClassifierDecl334);
            rule__EClassifierDecl__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getEClassifierDeclAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleEClassifierDecl


    // $ANTLR start entryRuleEDataTypeDecl
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:195:1: entryRuleEDataTypeDecl : ruleEDataTypeDecl EOF ;
    public final void entryRuleEDataTypeDecl() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:195:24: ( ruleEDataTypeDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:196:1: ruleEDataTypeDecl EOF
            {
             before(grammarAccess.getEDataTypeDeclRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEDataTypeDecl_in_entryRuleEDataTypeDecl360);
            ruleEDataTypeDecl();
            _fsp--;

             after(grammarAccess.getEDataTypeDeclRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEDataTypeDecl367); 

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
    // $ANTLR end entryRuleEDataTypeDecl


    // $ANTLR start ruleEDataTypeDecl
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:203:1: ruleEDataTypeDecl : ( ( rule__EDataTypeDecl__Alternatives ) ) ;
    public final void ruleEDataTypeDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:207:2: ( ( ( rule__EDataTypeDecl__Alternatives ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:208:1: ( ( rule__EDataTypeDecl__Alternatives ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:208:1: ( ( rule__EDataTypeDecl__Alternatives ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:209:1: ( rule__EDataTypeDecl__Alternatives )
            {
             before(grammarAccess.getEDataTypeDeclAccess().getAlternatives()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:210:1: ( rule__EDataTypeDecl__Alternatives )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:210:2: rule__EDataTypeDecl__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__EDataTypeDecl__Alternatives_in_ruleEDataTypeDecl394);
            rule__EDataTypeDecl__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getEDataTypeDeclAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleEDataTypeDecl


    // $ANTLR start entryRuleEAnnotationDecl
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:222:1: entryRuleEAnnotationDecl : ruleEAnnotationDecl EOF ;
    public final void entryRuleEAnnotationDecl() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:222:26: ( ruleEAnnotationDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:223:1: ruleEAnnotationDecl EOF
            {
             before(grammarAccess.getEAnnotationDeclRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEAnnotationDecl_in_entryRuleEAnnotationDecl420);
            ruleEAnnotationDecl();
            _fsp--;

             after(grammarAccess.getEAnnotationDeclRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEAnnotationDecl427); 

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
    // $ANTLR end entryRuleEAnnotationDecl


    // $ANTLR start ruleEAnnotationDecl
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:230:1: ruleEAnnotationDecl : ( ( rule__EAnnotationDecl__Group__0 ) ) ;
    public final void ruleEAnnotationDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:234:2: ( ( ( rule__EAnnotationDecl__Group__0 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:235:1: ( ( rule__EAnnotationDecl__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:235:1: ( ( rule__EAnnotationDecl__Group__0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:236:1: ( rule__EAnnotationDecl__Group__0 )
            {
             before(grammarAccess.getEAnnotationDeclAccess().getGroup()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:237:1: ( rule__EAnnotationDecl__Group__0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:237:2: rule__EAnnotationDecl__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EAnnotationDecl__Group__0_in_ruleEAnnotationDecl454);
            rule__EAnnotationDecl__Group__0();
            _fsp--;


            }

             after(grammarAccess.getEAnnotationDeclAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleEAnnotationDecl


    // $ANTLR start entryRuleEClassDecl
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:249:1: entryRuleEClassDecl : ruleEClassDecl EOF ;
    public final void entryRuleEClassDecl() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:249:21: ( ruleEClassDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:250:1: ruleEClassDecl EOF
            {
             before(grammarAccess.getEClassDeclRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEClassDecl_in_entryRuleEClassDecl480);
            ruleEClassDecl();
            _fsp--;

             after(grammarAccess.getEClassDeclRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEClassDecl487); 

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
    // $ANTLR end entryRuleEClassDecl


    // $ANTLR start ruleEClassDecl
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:257:1: ruleEClassDecl : ( ( rule__EClassDecl__Group__0 ) ) ;
    public final void ruleEClassDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:261:2: ( ( ( rule__EClassDecl__Group__0 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:262:1: ( ( rule__EClassDecl__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:262:1: ( ( rule__EClassDecl__Group__0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:263:1: ( rule__EClassDecl__Group__0 )
            {
             before(grammarAccess.getEClassDeclAccess().getGroup()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:264:1: ( rule__EClassDecl__Group__0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:264:2: rule__EClassDecl__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EClassDecl__Group__0_in_ruleEClassDecl514);
            rule__EClassDecl__Group__0();
            _fsp--;


            }

             after(grammarAccess.getEClassDeclAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleEClassDecl


    // $ANTLR start entryRuleEStructuralFeatureDecl
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:276:1: entryRuleEStructuralFeatureDecl : ruleEStructuralFeatureDecl EOF ;
    public final void entryRuleEStructuralFeatureDecl() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:276:33: ( ruleEStructuralFeatureDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:277:1: ruleEStructuralFeatureDecl EOF
            {
             before(grammarAccess.getEStructuralFeatureDeclRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEStructuralFeatureDecl_in_entryRuleEStructuralFeatureDecl540);
            ruleEStructuralFeatureDecl();
            _fsp--;

             after(grammarAccess.getEStructuralFeatureDeclRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEStructuralFeatureDecl547); 

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
    // $ANTLR end entryRuleEStructuralFeatureDecl


    // $ANTLR start ruleEStructuralFeatureDecl
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:284:1: ruleEStructuralFeatureDecl : ( ( rule__EStructuralFeatureDecl__Alternatives ) ) ;
    public final void ruleEStructuralFeatureDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:288:2: ( ( ( rule__EStructuralFeatureDecl__Alternatives ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:289:1: ( ( rule__EStructuralFeatureDecl__Alternatives ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:289:1: ( ( rule__EStructuralFeatureDecl__Alternatives ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:290:1: ( rule__EStructuralFeatureDecl__Alternatives )
            {
             before(grammarAccess.getEStructuralFeatureDeclAccess().getAlternatives()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:291:1: ( rule__EStructuralFeatureDecl__Alternatives )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:291:2: rule__EStructuralFeatureDecl__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__EStructuralFeatureDecl__Alternatives_in_ruleEStructuralFeatureDecl574);
            rule__EStructuralFeatureDecl__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getEStructuralFeatureDeclAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleEStructuralFeatureDecl


    // $ANTLR start entryRuleEAttributeDecl
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:303:1: entryRuleEAttributeDecl : ruleEAttributeDecl EOF ;
    public final void entryRuleEAttributeDecl() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:303:25: ( ruleEAttributeDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:304:1: ruleEAttributeDecl EOF
            {
             before(grammarAccess.getEAttributeDeclRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEAttributeDecl_in_entryRuleEAttributeDecl600);
            ruleEAttributeDecl();
            _fsp--;

             after(grammarAccess.getEAttributeDeclRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEAttributeDecl607); 

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
    // $ANTLR end entryRuleEAttributeDecl


    // $ANTLR start ruleEAttributeDecl
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:311:1: ruleEAttributeDecl : ( ( rule__EAttributeDecl__Group__0 ) ) ;
    public final void ruleEAttributeDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:315:2: ( ( ( rule__EAttributeDecl__Group__0 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:316:1: ( ( rule__EAttributeDecl__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:316:1: ( ( rule__EAttributeDecl__Group__0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:317:1: ( rule__EAttributeDecl__Group__0 )
            {
             before(grammarAccess.getEAttributeDeclAccess().getGroup()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:318:1: ( rule__EAttributeDecl__Group__0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:318:2: rule__EAttributeDecl__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EAttributeDecl__Group__0_in_ruleEAttributeDecl634);
            rule__EAttributeDecl__Group__0();
            _fsp--;


            }

             after(grammarAccess.getEAttributeDeclAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleEAttributeDecl


    // $ANTLR start entryRuleEReferenceDecl
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:330:1: entryRuleEReferenceDecl : ruleEReferenceDecl EOF ;
    public final void entryRuleEReferenceDecl() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:330:25: ( ruleEReferenceDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:331:1: ruleEReferenceDecl EOF
            {
             before(grammarAccess.getEReferenceDeclRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEReferenceDecl_in_entryRuleEReferenceDecl660);
            ruleEReferenceDecl();
            _fsp--;

             after(grammarAccess.getEReferenceDeclRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEReferenceDecl667); 

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
    // $ANTLR end entryRuleEReferenceDecl


    // $ANTLR start ruleEReferenceDecl
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:338:1: ruleEReferenceDecl : ( ( rule__EReferenceDecl__Group__0 ) ) ;
    public final void ruleEReferenceDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:342:2: ( ( ( rule__EReferenceDecl__Group__0 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:343:1: ( ( rule__EReferenceDecl__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:343:1: ( ( rule__EReferenceDecl__Group__0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:344:1: ( rule__EReferenceDecl__Group__0 )
            {
             before(grammarAccess.getEReferenceDeclAccess().getGroup()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:345:1: ( rule__EReferenceDecl__Group__0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:345:2: rule__EReferenceDecl__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EReferenceDecl__Group__0_in_ruleEReferenceDecl694);
            rule__EReferenceDecl__Group__0();
            _fsp--;


            }

             after(grammarAccess.getEReferenceDeclAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleEReferenceDecl


    // $ANTLR start entryRuleEEnumDecl
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:357:1: entryRuleEEnumDecl : ruleEEnumDecl EOF ;
    public final void entryRuleEEnumDecl() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:357:20: ( ruleEEnumDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:358:1: ruleEEnumDecl EOF
            {
             before(grammarAccess.getEEnumDeclRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEEnumDecl_in_entryRuleEEnumDecl720);
            ruleEEnumDecl();
            _fsp--;

             after(grammarAccess.getEEnumDeclRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEEnumDecl727); 

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
    // $ANTLR end entryRuleEEnumDecl


    // $ANTLR start ruleEEnumDecl
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:365:1: ruleEEnumDecl : ( ( rule__EEnumDecl__Group__0 ) ) ;
    public final void ruleEEnumDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:369:2: ( ( ( rule__EEnumDecl__Group__0 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:370:1: ( ( rule__EEnumDecl__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:370:1: ( ( rule__EEnumDecl__Group__0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:371:1: ( rule__EEnumDecl__Group__0 )
            {
             before(grammarAccess.getEEnumDeclAccess().getGroup()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:372:1: ( rule__EEnumDecl__Group__0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:372:2: rule__EEnumDecl__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EEnumDecl__Group__0_in_ruleEEnumDecl754);
            rule__EEnumDecl__Group__0();
            _fsp--;


            }

             after(grammarAccess.getEEnumDeclAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleEEnumDecl


    // $ANTLR start entryRuleEEnumLiteralDecl
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:384:1: entryRuleEEnumLiteralDecl : ruleEEnumLiteralDecl EOF ;
    public final void entryRuleEEnumLiteralDecl() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:384:27: ( ruleEEnumLiteralDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:385:1: ruleEEnumLiteralDecl EOF
            {
             before(grammarAccess.getEEnumLiteralDeclRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEEnumLiteralDecl_in_entryRuleEEnumLiteralDecl780);
            ruleEEnumLiteralDecl();
            _fsp--;

             after(grammarAccess.getEEnumLiteralDeclRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEEnumLiteralDecl787); 

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
    // $ANTLR end entryRuleEEnumLiteralDecl


    // $ANTLR start ruleEEnumLiteralDecl
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:392:1: ruleEEnumLiteralDecl : ( ( rule__EEnumLiteralDecl__Group__0 ) ) ;
    public final void ruleEEnumLiteralDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:396:2: ( ( ( rule__EEnumLiteralDecl__Group__0 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:397:1: ( ( rule__EEnumLiteralDecl__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:397:1: ( ( rule__EEnumLiteralDecl__Group__0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:398:1: ( rule__EEnumLiteralDecl__Group__0 )
            {
             before(grammarAccess.getEEnumLiteralDeclAccess().getGroup()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:399:1: ( rule__EEnumLiteralDecl__Group__0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:399:2: rule__EEnumLiteralDecl__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EEnumLiteralDecl__Group__0_in_ruleEEnumLiteralDecl814);
            rule__EEnumLiteralDecl__Group__0();
            _fsp--;


            }

             after(grammarAccess.getEEnumLiteralDeclAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleEEnumLiteralDecl


    // $ANTLR start entryRuleETypeParameterDecl
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:411:1: entryRuleETypeParameterDecl : ruleETypeParameterDecl EOF ;
    public final void entryRuleETypeParameterDecl() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:411:29: ( ruleETypeParameterDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:412:1: ruleETypeParameterDecl EOF
            {
             before(grammarAccess.getETypeParameterDeclRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleETypeParameterDecl_in_entryRuleETypeParameterDecl840);
            ruleETypeParameterDecl();
            _fsp--;

             after(grammarAccess.getETypeParameterDeclRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleETypeParameterDecl847); 

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
    // $ANTLR end entryRuleETypeParameterDecl


    // $ANTLR start ruleETypeParameterDecl
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:419:1: ruleETypeParameterDecl : ( ( rule__ETypeParameterDecl__Group__0 ) ) ;
    public final void ruleETypeParameterDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:423:2: ( ( ( rule__ETypeParameterDecl__Group__0 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:424:1: ( ( rule__ETypeParameterDecl__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:424:1: ( ( rule__ETypeParameterDecl__Group__0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:425:1: ( rule__ETypeParameterDecl__Group__0 )
            {
             before(grammarAccess.getETypeParameterDeclAccess().getGroup()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:426:1: ( rule__ETypeParameterDecl__Group__0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:426:2: rule__ETypeParameterDecl__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ETypeParameterDecl__Group__0_in_ruleETypeParameterDecl874);
            rule__ETypeParameterDecl__Group__0();
            _fsp--;


            }

             after(grammarAccess.getETypeParameterDeclAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleETypeParameterDecl


    // $ANTLR start entryRuleEGenericTypeReferenceDecl
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:438:1: entryRuleEGenericTypeReferenceDecl : ruleEGenericTypeReferenceDecl EOF ;
    public final void entryRuleEGenericTypeReferenceDecl() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:438:36: ( ruleEGenericTypeReferenceDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:439:1: ruleEGenericTypeReferenceDecl EOF
            {
             before(grammarAccess.getEGenericTypeReferenceDeclRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeReferenceDecl_in_entryRuleEGenericTypeReferenceDecl900);
            ruleEGenericTypeReferenceDecl();
            _fsp--;

             after(grammarAccess.getEGenericTypeReferenceDeclRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEGenericTypeReferenceDecl907); 

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
    // $ANTLR end entryRuleEGenericTypeReferenceDecl


    // $ANTLR start ruleEGenericTypeReferenceDecl
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:446:1: ruleEGenericTypeReferenceDecl : ( ( rule__EGenericTypeReferenceDecl__Alternatives ) ) ;
    public final void ruleEGenericTypeReferenceDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:450:2: ( ( ( rule__EGenericTypeReferenceDecl__Alternatives ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:451:1: ( ( rule__EGenericTypeReferenceDecl__Alternatives ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:451:1: ( ( rule__EGenericTypeReferenceDecl__Alternatives ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:452:1: ( rule__EGenericTypeReferenceDecl__Alternatives )
            {
             before(grammarAccess.getEGenericTypeReferenceDeclAccess().getAlternatives()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:453:1: ( rule__EGenericTypeReferenceDecl__Alternatives )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:453:2: rule__EGenericTypeReferenceDecl__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeReferenceDecl__Alternatives_in_ruleEGenericTypeReferenceDecl934);
            rule__EGenericTypeReferenceDecl__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getEGenericTypeReferenceDeclAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleEGenericTypeReferenceDecl


    // $ANTLR start entryRuleEGenericTypeDecl
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:465:1: entryRuleEGenericTypeDecl : ruleEGenericTypeDecl EOF ;
    public final void entryRuleEGenericTypeDecl() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:465:27: ( ruleEGenericTypeDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:466:1: ruleEGenericTypeDecl EOF
            {
             before(grammarAccess.getEGenericTypeDeclRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeDecl_in_entryRuleEGenericTypeDecl960);
            ruleEGenericTypeDecl();
            _fsp--;

             after(grammarAccess.getEGenericTypeDeclRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEGenericTypeDecl967); 

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
    // $ANTLR end entryRuleEGenericTypeDecl


    // $ANTLR start ruleEGenericTypeDecl
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:473:1: ruleEGenericTypeDecl : ( ( rule__EGenericTypeDecl__Alternatives ) ) ;
    public final void ruleEGenericTypeDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:477:2: ( ( ( rule__EGenericTypeDecl__Alternatives ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:478:1: ( ( rule__EGenericTypeDecl__Alternatives ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:478:1: ( ( rule__EGenericTypeDecl__Alternatives ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:479:1: ( rule__EGenericTypeDecl__Alternatives )
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getAlternatives()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:480:1: ( rule__EGenericTypeDecl__Alternatives )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:480:2: rule__EGenericTypeDecl__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeDecl__Alternatives_in_ruleEGenericTypeDecl994);
            rule__EGenericTypeDecl__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getEGenericTypeDeclAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleEGenericTypeDecl


    // $ANTLR start entryRuleEOperationDecl
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:492:1: entryRuleEOperationDecl : ruleEOperationDecl EOF ;
    public final void entryRuleEOperationDecl() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:492:25: ( ruleEOperationDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:493:1: ruleEOperationDecl EOF
            {
             before(grammarAccess.getEOperationDeclRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEOperationDecl_in_entryRuleEOperationDecl1020);
            ruleEOperationDecl();
            _fsp--;

             after(grammarAccess.getEOperationDeclRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEOperationDecl1027); 

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
    // $ANTLR end entryRuleEOperationDecl


    // $ANTLR start ruleEOperationDecl
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:500:1: ruleEOperationDecl : ( ( rule__EOperationDecl__Group__0 ) ) ;
    public final void ruleEOperationDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:504:2: ( ( ( rule__EOperationDecl__Group__0 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:505:1: ( ( rule__EOperationDecl__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:505:1: ( ( rule__EOperationDecl__Group__0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:506:1: ( rule__EOperationDecl__Group__0 )
            {
             before(grammarAccess.getEOperationDeclAccess().getGroup()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:507:1: ( rule__EOperationDecl__Group__0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:507:2: rule__EOperationDecl__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__Group__0_in_ruleEOperationDecl1054);
            rule__EOperationDecl__Group__0();
            _fsp--;


            }

             after(grammarAccess.getEOperationDeclAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleEOperationDecl


    // $ANTLR start entryRuleEParameterDecl
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:519:1: entryRuleEParameterDecl : ruleEParameterDecl EOF ;
    public final void entryRuleEParameterDecl() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:519:25: ( ruleEParameterDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:520:1: ruleEParameterDecl EOF
            {
             before(grammarAccess.getEParameterDeclRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEParameterDecl_in_entryRuleEParameterDecl1080);
            ruleEParameterDecl();
            _fsp--;

             after(grammarAccess.getEParameterDeclRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEParameterDecl1087); 

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
    // $ANTLR end entryRuleEParameterDecl


    // $ANTLR start ruleEParameterDecl
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:527:1: ruleEParameterDecl : ( ( rule__EParameterDecl__Group__0 ) ) ;
    public final void ruleEParameterDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:531:2: ( ( ( rule__EParameterDecl__Group__0 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:532:1: ( ( rule__EParameterDecl__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:532:1: ( ( rule__EParameterDecl__Group__0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:533:1: ( rule__EParameterDecl__Group__0 )
            {
             before(grammarAccess.getEParameterDeclAccess().getGroup()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:534:1: ( rule__EParameterDecl__Group__0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:534:2: rule__EParameterDecl__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EParameterDecl__Group__0_in_ruleEParameterDecl1114);
            rule__EParameterDecl__Group__0();
            _fsp--;


            }

             after(grammarAccess.getEParameterDeclAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleEParameterDecl


    // $ANTLR start entryRuleMapEntry
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:546:1: entryRuleMapEntry : ruleMapEntry EOF ;
    public final void entryRuleMapEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:546:19: ( ruleMapEntry EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:547:1: ruleMapEntry EOF
            {
             before(grammarAccess.getMapEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMapEntry_in_entryRuleMapEntry1140);
            ruleMapEntry();
            _fsp--;

             after(grammarAccess.getMapEntryRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMapEntry1147); 

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
    // $ANTLR end entryRuleMapEntry


    // $ANTLR start ruleMapEntry
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:554:1: ruleMapEntry : ( ( rule__MapEntry__Group__0 ) ) ;
    public final void ruleMapEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:558:2: ( ( ( rule__MapEntry__Group__0 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:559:1: ( ( rule__MapEntry__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:559:1: ( ( rule__MapEntry__Group__0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:560:1: ( rule__MapEntry__Group__0 )
            {
             before(grammarAccess.getMapEntryAccess().getGroup()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:561:1: ( rule__MapEntry__Group__0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:561:2: rule__MapEntry__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__MapEntry__Group__0_in_ruleMapEntry1174);
            rule__MapEntry__Group__0();
            _fsp--;


            }

             after(grammarAccess.getMapEntryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleMapEntry


    // $ANTLR start entryRuleQID
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:573:1: entryRuleQID : ruleQID EOF ;
    public final void entryRuleQID() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:573:14: ( ruleQID EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:574:1: ruleQID EOF
            {
             before(grammarAccess.getQIDRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleQID_in_entryRuleQID1200);
            ruleQID();
            _fsp--;

             after(grammarAccess.getQIDRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQID1207); 

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
    // $ANTLR end entryRuleQID


    // $ANTLR start ruleQID
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:581:1: ruleQID : ( ( rule__QID__Group__0 ) ) ;
    public final void ruleQID() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:585:2: ( ( ( rule__QID__Group__0 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:586:1: ( ( rule__QID__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:586:1: ( ( rule__QID__Group__0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:587:1: ( rule__QID__Group__0 )
            {
             before(grammarAccess.getQIDAccess().getGroup()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:588:1: ( rule__QID__Group__0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:588:2: rule__QID__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__QID__Group__0_in_ruleQID1234);
            rule__QID__Group__0();
            _fsp--;


            }

             after(grammarAccess.getQIDAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleQID


    // $ANTLR start entryRuleSTRING_OR_QID
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:600:1: entryRuleSTRING_OR_QID : ruleSTRING_OR_QID EOF ;
    public final void entryRuleSTRING_OR_QID() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:600:24: ( ruleSTRING_OR_QID EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:601:1: ruleSTRING_OR_QID EOF
            {
             before(grammarAccess.getSTRING_OR_QIDRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSTRING_OR_QID_in_entryRuleSTRING_OR_QID1260);
            ruleSTRING_OR_QID();
            _fsp--;

             after(grammarAccess.getSTRING_OR_QIDRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSTRING_OR_QID1267); 

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
    // $ANTLR end entryRuleSTRING_OR_QID


    // $ANTLR start ruleSTRING_OR_QID
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:608:1: ruleSTRING_OR_QID : ( ( rule__STRING_OR_QID__Alternatives ) ) ;
    public final void ruleSTRING_OR_QID() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:612:2: ( ( ( rule__STRING_OR_QID__Alternatives ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:613:1: ( ( rule__STRING_OR_QID__Alternatives ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:613:1: ( ( rule__STRING_OR_QID__Alternatives ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:614:1: ( rule__STRING_OR_QID__Alternatives )
            {
             before(grammarAccess.getSTRING_OR_QIDAccess().getAlternatives()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:615:1: ( rule__STRING_OR_QID__Alternatives )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:615:2: rule__STRING_OR_QID__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__STRING_OR_QID__Alternatives_in_ruleSTRING_OR_QID1294);
            rule__STRING_OR_QID__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getSTRING_OR_QIDAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleSTRING_OR_QID


    // $ANTLR start entryRuleSINT
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:627:1: entryRuleSINT : ruleSINT EOF ;
    public final void entryRuleSINT() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:627:15: ( ruleSINT EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:628:1: ruleSINT EOF
            {
             before(grammarAccess.getSINTRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSINT_in_entryRuleSINT1320);
            ruleSINT();
            _fsp--;

             after(grammarAccess.getSINTRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSINT1327); 

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
    // $ANTLR end entryRuleSINT


    // $ANTLR start ruleSINT
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:635:1: ruleSINT : ( ( rule__SINT__Group__0 ) ) ;
    public final void ruleSINT() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:639:2: ( ( ( rule__SINT__Group__0 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:640:1: ( ( rule__SINT__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:640:1: ( ( rule__SINT__Group__0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:641:1: ( rule__SINT__Group__0 )
            {
             before(grammarAccess.getSINTAccess().getGroup()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:642:1: ( rule__SINT__Group__0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:642:2: rule__SINT__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__SINT__Group__0_in_ruleSINT1354);
            rule__SINT__Group__0();
            _fsp--;


            }

             after(grammarAccess.getSINTAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleSINT


    // $ANTLR start rule__EPackageDecl__Alternatives_10
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:654:1: rule__EPackageDecl__Alternatives_10 : ( ( ( rule__EPackageDecl__ESubpackagesAssignment_10_0 ) ) | ( ( rule__EPackageDecl__EClassifiersAssignment_10_1 ) ) );
    public final void rule__EPackageDecl__Alternatives_10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:658:1: ( ( ( rule__EPackageDecl__ESubpackagesAssignment_10_0 ) ) | ( ( rule__EPackageDecl__EClassifiersAssignment_10_1 ) ) )
            int alt1=2;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:659:1: ( ( rule__EPackageDecl__ESubpackagesAssignment_10_0 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:659:1: ( ( rule__EPackageDecl__ESubpackagesAssignment_10_0 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:660:1: ( rule__EPackageDecl__ESubpackagesAssignment_10_0 )
                    {
                     before(grammarAccess.getEPackageDeclAccess().getESubpackagesAssignment_10_0()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:661:1: ( rule__EPackageDecl__ESubpackagesAssignment_10_0 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:661:2: rule__EPackageDecl__ESubpackagesAssignment_10_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EPackageDecl__ESubpackagesAssignment_10_0_in_rule__EPackageDecl__Alternatives_101390);
                    rule__EPackageDecl__ESubpackagesAssignment_10_0();
                    _fsp--;


                    }

                     after(grammarAccess.getEPackageDeclAccess().getESubpackagesAssignment_10_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:665:6: ( ( rule__EPackageDecl__EClassifiersAssignment_10_1 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:665:6: ( ( rule__EPackageDecl__EClassifiersAssignment_10_1 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:666:1: ( rule__EPackageDecl__EClassifiersAssignment_10_1 )
                    {
                     before(grammarAccess.getEPackageDeclAccess().getEClassifiersAssignment_10_1()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:667:1: ( rule__EPackageDecl__EClassifiersAssignment_10_1 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:667:2: rule__EPackageDecl__EClassifiersAssignment_10_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EPackageDecl__EClassifiersAssignment_10_1_in_rule__EPackageDecl__Alternatives_101408);
                    rule__EPackageDecl__EClassifiersAssignment_10_1();
                    _fsp--;


                    }

                     after(grammarAccess.getEPackageDeclAccess().getEClassifiersAssignment_10_1()); 

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
    // $ANTLR end rule__EPackageDecl__Alternatives_10


    // $ANTLR start rule__SubEPackageDecl__Alternatives_4
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:676:1: rule__SubEPackageDecl__Alternatives_4 : ( ( ( rule__SubEPackageDecl__ESubpackagesAssignment_4_0 ) ) | ( ( rule__SubEPackageDecl__EClassifiersAssignment_4_1 ) ) );
    public final void rule__SubEPackageDecl__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:680:1: ( ( ( rule__SubEPackageDecl__ESubpackagesAssignment_4_0 ) ) | ( ( rule__SubEPackageDecl__EClassifiersAssignment_4_1 ) ) )
            int alt2=2;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:681:1: ( ( rule__SubEPackageDecl__ESubpackagesAssignment_4_0 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:681:1: ( ( rule__SubEPackageDecl__ESubpackagesAssignment_4_0 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:682:1: ( rule__SubEPackageDecl__ESubpackagesAssignment_4_0 )
                    {
                     before(grammarAccess.getSubEPackageDeclAccess().getESubpackagesAssignment_4_0()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:683:1: ( rule__SubEPackageDecl__ESubpackagesAssignment_4_0 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:683:2: rule__SubEPackageDecl__ESubpackagesAssignment_4_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SubEPackageDecl__ESubpackagesAssignment_4_0_in_rule__SubEPackageDecl__Alternatives_41441);
                    rule__SubEPackageDecl__ESubpackagesAssignment_4_0();
                    _fsp--;


                    }

                     after(grammarAccess.getSubEPackageDeclAccess().getESubpackagesAssignment_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:687:6: ( ( rule__SubEPackageDecl__EClassifiersAssignment_4_1 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:687:6: ( ( rule__SubEPackageDecl__EClassifiersAssignment_4_1 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:688:1: ( rule__SubEPackageDecl__EClassifiersAssignment_4_1 )
                    {
                     before(grammarAccess.getSubEPackageDeclAccess().getEClassifiersAssignment_4_1()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:689:1: ( rule__SubEPackageDecl__EClassifiersAssignment_4_1 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:689:2: rule__SubEPackageDecl__EClassifiersAssignment_4_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SubEPackageDecl__EClassifiersAssignment_4_1_in_rule__SubEPackageDecl__Alternatives_41459);
                    rule__SubEPackageDecl__EClassifiersAssignment_4_1();
                    _fsp--;


                    }

                     after(grammarAccess.getSubEPackageDeclAccess().getEClassifiersAssignment_4_1()); 

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
    // $ANTLR end rule__SubEPackageDecl__Alternatives_4


    // $ANTLR start rule__EClassifierDecl__Alternatives
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:698:1: rule__EClassifierDecl__Alternatives : ( ( ruleEClassDecl ) | ( ruleEDataTypeDecl ) );
    public final void rule__EClassifierDecl__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:702:1: ( ( ruleEClassDecl ) | ( ruleEDataTypeDecl ) )
            int alt3=2;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:703:1: ( ruleEClassDecl )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:703:1: ( ruleEClassDecl )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:704:1: ruleEClassDecl
                    {
                     before(grammarAccess.getEClassifierDeclAccess().getEClassDeclParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleEClassDecl_in_rule__EClassifierDecl__Alternatives1492);
                    ruleEClassDecl();
                    _fsp--;

                     after(grammarAccess.getEClassifierDeclAccess().getEClassDeclParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:709:6: ( ruleEDataTypeDecl )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:709:6: ( ruleEDataTypeDecl )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:710:1: ruleEDataTypeDecl
                    {
                     before(grammarAccess.getEClassifierDeclAccess().getEDataTypeDeclParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleEDataTypeDecl_in_rule__EClassifierDecl__Alternatives1509);
                    ruleEDataTypeDecl();
                    _fsp--;

                     after(grammarAccess.getEClassifierDeclAccess().getEDataTypeDeclParserRuleCall_1()); 

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
    // $ANTLR end rule__EClassifierDecl__Alternatives


    // $ANTLR start rule__EDataTypeDecl__Alternatives
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:720:1: rule__EDataTypeDecl__Alternatives : ( ( ( rule__EDataTypeDecl__Group_0__0 ) ) | ( ruleEEnumDecl ) );
    public final void rule__EDataTypeDecl__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:724:1: ( ( ( rule__EDataTypeDecl__Group_0__0 ) ) | ( ruleEEnumDecl ) )
            int alt4=2;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:725:1: ( ( rule__EDataTypeDecl__Group_0__0 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:725:1: ( ( rule__EDataTypeDecl__Group_0__0 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:726:1: ( rule__EDataTypeDecl__Group_0__0 )
                    {
                     before(grammarAccess.getEDataTypeDeclAccess().getGroup_0()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:727:1: ( rule__EDataTypeDecl__Group_0__0 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:727:2: rule__EDataTypeDecl__Group_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EDataTypeDecl__Group_0__0_in_rule__EDataTypeDecl__Alternatives1541);
                    rule__EDataTypeDecl__Group_0__0();
                    _fsp--;


                    }

                     after(grammarAccess.getEDataTypeDeclAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:731:6: ( ruleEEnumDecl )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:731:6: ( ruleEEnumDecl )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:732:1: ruleEEnumDecl
                    {
                     before(grammarAccess.getEDataTypeDeclAccess().getEEnumDeclParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleEEnumDecl_in_rule__EDataTypeDecl__Alternatives1559);
                    ruleEEnumDecl();
                    _fsp--;

                     after(grammarAccess.getEDataTypeDeclAccess().getEEnumDeclParserRuleCall_1()); 

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
    // $ANTLR end rule__EDataTypeDecl__Alternatives


    // $ANTLR start rule__EClassDecl__Alternatives_2
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:742:1: rule__EClassDecl__Alternatives_2 : ( ( ( rule__EClassDecl__InterfaceAssignment_2_0 ) ) | ( 'class' ) );
    public final void rule__EClassDecl__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:746:1: ( ( ( rule__EClassDecl__InterfaceAssignment_2_0 ) ) | ( 'class' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==50) ) {
                alt5=1;
            }
            else if ( (LA5_0==16) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("742:1: rule__EClassDecl__Alternatives_2 : ( ( ( rule__EClassDecl__InterfaceAssignment_2_0 ) ) | ( 'class' ) );", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:747:1: ( ( rule__EClassDecl__InterfaceAssignment_2_0 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:747:1: ( ( rule__EClassDecl__InterfaceAssignment_2_0 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:748:1: ( rule__EClassDecl__InterfaceAssignment_2_0 )
                    {
                     before(grammarAccess.getEClassDeclAccess().getInterfaceAssignment_2_0()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:749:1: ( rule__EClassDecl__InterfaceAssignment_2_0 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:749:2: rule__EClassDecl__InterfaceAssignment_2_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EClassDecl__InterfaceAssignment_2_0_in_rule__EClassDecl__Alternatives_21591);
                    rule__EClassDecl__InterfaceAssignment_2_0();
                    _fsp--;


                    }

                     after(grammarAccess.getEClassDeclAccess().getInterfaceAssignment_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:753:6: ( 'class' )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:753:6: ( 'class' )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:754:1: 'class'
                    {
                     before(grammarAccess.getEClassDeclAccess().getClassKeyword_2_1()); 
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__EClassDecl__Alternatives_21610); 
                     after(grammarAccess.getEClassDeclAccess().getClassKeyword_2_1()); 

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
    // $ANTLR end rule__EClassDecl__Alternatives_2


    // $ANTLR start rule__EClassDecl__Alternatives_8
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:766:1: rule__EClassDecl__Alternatives_8 : ( ( ( rule__EClassDecl__EStructuralFeaturesAssignment_8_0 ) ) | ( ( rule__EClassDecl__EOperationsAssignment_8_1 ) ) );
    public final void rule__EClassDecl__Alternatives_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:770:1: ( ( ( rule__EClassDecl__EStructuralFeaturesAssignment_8_0 ) ) | ( ( rule__EClassDecl__EOperationsAssignment_8_1 ) ) )
            int alt6=2;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:771:1: ( ( rule__EClassDecl__EStructuralFeaturesAssignment_8_0 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:771:1: ( ( rule__EClassDecl__EStructuralFeaturesAssignment_8_0 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:772:1: ( rule__EClassDecl__EStructuralFeaturesAssignment_8_0 )
                    {
                     before(grammarAccess.getEClassDeclAccess().getEStructuralFeaturesAssignment_8_0()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:773:1: ( rule__EClassDecl__EStructuralFeaturesAssignment_8_0 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:773:2: rule__EClassDecl__EStructuralFeaturesAssignment_8_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EClassDecl__EStructuralFeaturesAssignment_8_0_in_rule__EClassDecl__Alternatives_81644);
                    rule__EClassDecl__EStructuralFeaturesAssignment_8_0();
                    _fsp--;


                    }

                     after(grammarAccess.getEClassDeclAccess().getEStructuralFeaturesAssignment_8_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:777:6: ( ( rule__EClassDecl__EOperationsAssignment_8_1 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:777:6: ( ( rule__EClassDecl__EOperationsAssignment_8_1 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:778:1: ( rule__EClassDecl__EOperationsAssignment_8_1 )
                    {
                     before(grammarAccess.getEClassDeclAccess().getEOperationsAssignment_8_1()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:779:1: ( rule__EClassDecl__EOperationsAssignment_8_1 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:779:2: rule__EClassDecl__EOperationsAssignment_8_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EClassDecl__EOperationsAssignment_8_1_in_rule__EClassDecl__Alternatives_81662);
                    rule__EClassDecl__EOperationsAssignment_8_1();
                    _fsp--;


                    }

                     after(grammarAccess.getEClassDeclAccess().getEOperationsAssignment_8_1()); 

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
    // $ANTLR end rule__EClassDecl__Alternatives_8


    // $ANTLR start rule__EStructuralFeatureDecl__Alternatives
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:788:1: rule__EStructuralFeatureDecl__Alternatives : ( ( ruleEAttributeDecl ) | ( ruleEReferenceDecl ) );
    public final void rule__EStructuralFeatureDecl__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:792:1: ( ( ruleEAttributeDecl ) | ( ruleEReferenceDecl ) )
            int alt7=2;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:793:1: ( ruleEAttributeDecl )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:793:1: ( ruleEAttributeDecl )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:794:1: ruleEAttributeDecl
                    {
                     before(grammarAccess.getEStructuralFeatureDeclAccess().getEAttributeDeclParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleEAttributeDecl_in_rule__EStructuralFeatureDecl__Alternatives1695);
                    ruleEAttributeDecl();
                    _fsp--;

                     after(grammarAccess.getEStructuralFeatureDeclAccess().getEAttributeDeclParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:799:6: ( ruleEReferenceDecl )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:799:6: ( ruleEReferenceDecl )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:800:1: ruleEReferenceDecl
                    {
                     before(grammarAccess.getEStructuralFeatureDeclAccess().getEReferenceDeclParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleEReferenceDecl_in_rule__EStructuralFeatureDecl__Alternatives1712);
                    ruleEReferenceDecl();
                    _fsp--;

                     after(grammarAccess.getEStructuralFeatureDeclAccess().getEReferenceDeclParserRuleCall_1()); 

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
    // $ANTLR end rule__EStructuralFeatureDecl__Alternatives


    // $ANTLR start rule__EAttributeDecl__Alternatives_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:810:1: rule__EAttributeDecl__Alternatives_1 : ( ( ( rule__EAttributeDecl__IDAssignment_1_0 ) ) | ( ( rule__EAttributeDecl__UniqueAssignment_1_1 ) ) | ( ( rule__EAttributeDecl__OrderedAssignment_1_2 ) ) | ( ( rule__EAttributeDecl__ChangeableAssignment_1_3 ) ) | ( ( rule__EAttributeDecl__VolatileAssignment_1_4 ) ) | ( ( rule__EAttributeDecl__TransientAssignment_1_5 ) ) | ( ( rule__EAttributeDecl__UnsettableAssignment_1_6 ) ) | ( ( rule__EAttributeDecl__DerivedAssignment_1_7 ) ) );
    public final void rule__EAttributeDecl__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:814:1: ( ( ( rule__EAttributeDecl__IDAssignment_1_0 ) ) | ( ( rule__EAttributeDecl__UniqueAssignment_1_1 ) ) | ( ( rule__EAttributeDecl__OrderedAssignment_1_2 ) ) | ( ( rule__EAttributeDecl__ChangeableAssignment_1_3 ) ) | ( ( rule__EAttributeDecl__VolatileAssignment_1_4 ) ) | ( ( rule__EAttributeDecl__TransientAssignment_1_5 ) ) | ( ( rule__EAttributeDecl__UnsettableAssignment_1_6 ) ) | ( ( rule__EAttributeDecl__DerivedAssignment_1_7 ) ) )
            int alt8=8;
            switch ( input.LA(1) ) {
            case 51:
                {
                alt8=1;
                }
                break;
            case RULE_BAG:
                {
                alt8=2;
                }
                break;
            case RULE_RANDOM:
                {
                alt8=3;
                }
                break;
            case RULE_READONLY:
                {
                alt8=4;
                }
                break;
            case 52:
                {
                alt8=5;
                }
                break;
            case 53:
                {
                alt8=6;
                }
                break;
            case 54:
                {
                alt8=7;
                }
                break;
            case 55:
                {
                alt8=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("810:1: rule__EAttributeDecl__Alternatives_1 : ( ( ( rule__EAttributeDecl__IDAssignment_1_0 ) ) | ( ( rule__EAttributeDecl__UniqueAssignment_1_1 ) ) | ( ( rule__EAttributeDecl__OrderedAssignment_1_2 ) ) | ( ( rule__EAttributeDecl__ChangeableAssignment_1_3 ) ) | ( ( rule__EAttributeDecl__VolatileAssignment_1_4 ) ) | ( ( rule__EAttributeDecl__TransientAssignment_1_5 ) ) | ( ( rule__EAttributeDecl__UnsettableAssignment_1_6 ) ) | ( ( rule__EAttributeDecl__DerivedAssignment_1_7 ) ) );", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:815:1: ( ( rule__EAttributeDecl__IDAssignment_1_0 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:815:1: ( ( rule__EAttributeDecl__IDAssignment_1_0 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:816:1: ( rule__EAttributeDecl__IDAssignment_1_0 )
                    {
                     before(grammarAccess.getEAttributeDeclAccess().getIDAssignment_1_0()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:817:1: ( rule__EAttributeDecl__IDAssignment_1_0 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:817:2: rule__EAttributeDecl__IDAssignment_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EAttributeDecl__IDAssignment_1_0_in_rule__EAttributeDecl__Alternatives_11744);
                    rule__EAttributeDecl__IDAssignment_1_0();
                    _fsp--;


                    }

                     after(grammarAccess.getEAttributeDeclAccess().getIDAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:821:6: ( ( rule__EAttributeDecl__UniqueAssignment_1_1 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:821:6: ( ( rule__EAttributeDecl__UniqueAssignment_1_1 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:822:1: ( rule__EAttributeDecl__UniqueAssignment_1_1 )
                    {
                     before(grammarAccess.getEAttributeDeclAccess().getUniqueAssignment_1_1()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:823:1: ( rule__EAttributeDecl__UniqueAssignment_1_1 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:823:2: rule__EAttributeDecl__UniqueAssignment_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EAttributeDecl__UniqueAssignment_1_1_in_rule__EAttributeDecl__Alternatives_11762);
                    rule__EAttributeDecl__UniqueAssignment_1_1();
                    _fsp--;


                    }

                     after(grammarAccess.getEAttributeDeclAccess().getUniqueAssignment_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:827:6: ( ( rule__EAttributeDecl__OrderedAssignment_1_2 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:827:6: ( ( rule__EAttributeDecl__OrderedAssignment_1_2 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:828:1: ( rule__EAttributeDecl__OrderedAssignment_1_2 )
                    {
                     before(grammarAccess.getEAttributeDeclAccess().getOrderedAssignment_1_2()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:829:1: ( rule__EAttributeDecl__OrderedAssignment_1_2 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:829:2: rule__EAttributeDecl__OrderedAssignment_1_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EAttributeDecl__OrderedAssignment_1_2_in_rule__EAttributeDecl__Alternatives_11780);
                    rule__EAttributeDecl__OrderedAssignment_1_2();
                    _fsp--;


                    }

                     after(grammarAccess.getEAttributeDeclAccess().getOrderedAssignment_1_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:833:6: ( ( rule__EAttributeDecl__ChangeableAssignment_1_3 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:833:6: ( ( rule__EAttributeDecl__ChangeableAssignment_1_3 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:834:1: ( rule__EAttributeDecl__ChangeableAssignment_1_3 )
                    {
                     before(grammarAccess.getEAttributeDeclAccess().getChangeableAssignment_1_3()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:835:1: ( rule__EAttributeDecl__ChangeableAssignment_1_3 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:835:2: rule__EAttributeDecl__ChangeableAssignment_1_3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EAttributeDecl__ChangeableAssignment_1_3_in_rule__EAttributeDecl__Alternatives_11798);
                    rule__EAttributeDecl__ChangeableAssignment_1_3();
                    _fsp--;


                    }

                     after(grammarAccess.getEAttributeDeclAccess().getChangeableAssignment_1_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:839:6: ( ( rule__EAttributeDecl__VolatileAssignment_1_4 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:839:6: ( ( rule__EAttributeDecl__VolatileAssignment_1_4 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:840:1: ( rule__EAttributeDecl__VolatileAssignment_1_4 )
                    {
                     before(grammarAccess.getEAttributeDeclAccess().getVolatileAssignment_1_4()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:841:1: ( rule__EAttributeDecl__VolatileAssignment_1_4 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:841:2: rule__EAttributeDecl__VolatileAssignment_1_4
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EAttributeDecl__VolatileAssignment_1_4_in_rule__EAttributeDecl__Alternatives_11816);
                    rule__EAttributeDecl__VolatileAssignment_1_4();
                    _fsp--;


                    }

                     after(grammarAccess.getEAttributeDeclAccess().getVolatileAssignment_1_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:845:6: ( ( rule__EAttributeDecl__TransientAssignment_1_5 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:845:6: ( ( rule__EAttributeDecl__TransientAssignment_1_5 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:846:1: ( rule__EAttributeDecl__TransientAssignment_1_5 )
                    {
                     before(grammarAccess.getEAttributeDeclAccess().getTransientAssignment_1_5()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:847:1: ( rule__EAttributeDecl__TransientAssignment_1_5 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:847:2: rule__EAttributeDecl__TransientAssignment_1_5
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EAttributeDecl__TransientAssignment_1_5_in_rule__EAttributeDecl__Alternatives_11834);
                    rule__EAttributeDecl__TransientAssignment_1_5();
                    _fsp--;


                    }

                     after(grammarAccess.getEAttributeDeclAccess().getTransientAssignment_1_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:851:6: ( ( rule__EAttributeDecl__UnsettableAssignment_1_6 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:851:6: ( ( rule__EAttributeDecl__UnsettableAssignment_1_6 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:852:1: ( rule__EAttributeDecl__UnsettableAssignment_1_6 )
                    {
                     before(grammarAccess.getEAttributeDeclAccess().getUnsettableAssignment_1_6()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:853:1: ( rule__EAttributeDecl__UnsettableAssignment_1_6 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:853:2: rule__EAttributeDecl__UnsettableAssignment_1_6
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EAttributeDecl__UnsettableAssignment_1_6_in_rule__EAttributeDecl__Alternatives_11852);
                    rule__EAttributeDecl__UnsettableAssignment_1_6();
                    _fsp--;


                    }

                     after(grammarAccess.getEAttributeDeclAccess().getUnsettableAssignment_1_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:857:6: ( ( rule__EAttributeDecl__DerivedAssignment_1_7 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:857:6: ( ( rule__EAttributeDecl__DerivedAssignment_1_7 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:858:1: ( rule__EAttributeDecl__DerivedAssignment_1_7 )
                    {
                     before(grammarAccess.getEAttributeDeclAccess().getDerivedAssignment_1_7()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:859:1: ( rule__EAttributeDecl__DerivedAssignment_1_7 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:859:2: rule__EAttributeDecl__DerivedAssignment_1_7
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EAttributeDecl__DerivedAssignment_1_7_in_rule__EAttributeDecl__Alternatives_11870);
                    rule__EAttributeDecl__DerivedAssignment_1_7();
                    _fsp--;


                    }

                     after(grammarAccess.getEAttributeDeclAccess().getDerivedAssignment_1_7()); 

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
    // $ANTLR end rule__EAttributeDecl__Alternatives_1


    // $ANTLR start rule__EReferenceDecl__Alternatives_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:868:1: rule__EReferenceDecl__Alternatives_1 : ( ( ( rule__EReferenceDecl__ResolveProxiesAssignment_1_0 ) ) | ( ( rule__EReferenceDecl__UniqueAssignment_1_1 ) ) | ( ( rule__EReferenceDecl__OrderedAssignment_1_2 ) ) | ( ( rule__EReferenceDecl__ChangeableAssignment_1_3 ) ) | ( ( rule__EReferenceDecl__VolatileAssignment_1_4 ) ) | ( ( rule__EReferenceDecl__TransientAssignment_1_5 ) ) | ( ( rule__EReferenceDecl__UnsettableAssignment_1_6 ) ) | ( ( rule__EReferenceDecl__DerivedAssignment_1_7 ) ) );
    public final void rule__EReferenceDecl__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:872:1: ( ( ( rule__EReferenceDecl__ResolveProxiesAssignment_1_0 ) ) | ( ( rule__EReferenceDecl__UniqueAssignment_1_1 ) ) | ( ( rule__EReferenceDecl__OrderedAssignment_1_2 ) ) | ( ( rule__EReferenceDecl__ChangeableAssignment_1_3 ) ) | ( ( rule__EReferenceDecl__VolatileAssignment_1_4 ) ) | ( ( rule__EReferenceDecl__TransientAssignment_1_5 ) ) | ( ( rule__EReferenceDecl__UnsettableAssignment_1_6 ) ) | ( ( rule__EReferenceDecl__DerivedAssignment_1_7 ) ) )
            int alt9=8;
            switch ( input.LA(1) ) {
            case RULE_LOCAL:
                {
                alt9=1;
                }
                break;
            case RULE_BAG:
                {
                alt9=2;
                }
                break;
            case RULE_RANDOM:
                {
                alt9=3;
                }
                break;
            case RULE_READONLY:
                {
                alt9=4;
                }
                break;
            case 52:
                {
                alt9=5;
                }
                break;
            case 53:
                {
                alt9=6;
                }
                break;
            case 54:
                {
                alt9=7;
                }
                break;
            case 55:
                {
                alt9=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("868:1: rule__EReferenceDecl__Alternatives_1 : ( ( ( rule__EReferenceDecl__ResolveProxiesAssignment_1_0 ) ) | ( ( rule__EReferenceDecl__UniqueAssignment_1_1 ) ) | ( ( rule__EReferenceDecl__OrderedAssignment_1_2 ) ) | ( ( rule__EReferenceDecl__ChangeableAssignment_1_3 ) ) | ( ( rule__EReferenceDecl__VolatileAssignment_1_4 ) ) | ( ( rule__EReferenceDecl__TransientAssignment_1_5 ) ) | ( ( rule__EReferenceDecl__UnsettableAssignment_1_6 ) ) | ( ( rule__EReferenceDecl__DerivedAssignment_1_7 ) ) );", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:873:1: ( ( rule__EReferenceDecl__ResolveProxiesAssignment_1_0 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:873:1: ( ( rule__EReferenceDecl__ResolveProxiesAssignment_1_0 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:874:1: ( rule__EReferenceDecl__ResolveProxiesAssignment_1_0 )
                    {
                     before(grammarAccess.getEReferenceDeclAccess().getResolveProxiesAssignment_1_0()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:875:1: ( rule__EReferenceDecl__ResolveProxiesAssignment_1_0 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:875:2: rule__EReferenceDecl__ResolveProxiesAssignment_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EReferenceDecl__ResolveProxiesAssignment_1_0_in_rule__EReferenceDecl__Alternatives_11903);
                    rule__EReferenceDecl__ResolveProxiesAssignment_1_0();
                    _fsp--;


                    }

                     after(grammarAccess.getEReferenceDeclAccess().getResolveProxiesAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:879:6: ( ( rule__EReferenceDecl__UniqueAssignment_1_1 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:879:6: ( ( rule__EReferenceDecl__UniqueAssignment_1_1 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:880:1: ( rule__EReferenceDecl__UniqueAssignment_1_1 )
                    {
                     before(grammarAccess.getEReferenceDeclAccess().getUniqueAssignment_1_1()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:881:1: ( rule__EReferenceDecl__UniqueAssignment_1_1 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:881:2: rule__EReferenceDecl__UniqueAssignment_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EReferenceDecl__UniqueAssignment_1_1_in_rule__EReferenceDecl__Alternatives_11921);
                    rule__EReferenceDecl__UniqueAssignment_1_1();
                    _fsp--;


                    }

                     after(grammarAccess.getEReferenceDeclAccess().getUniqueAssignment_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:885:6: ( ( rule__EReferenceDecl__OrderedAssignment_1_2 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:885:6: ( ( rule__EReferenceDecl__OrderedAssignment_1_2 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:886:1: ( rule__EReferenceDecl__OrderedAssignment_1_2 )
                    {
                     before(grammarAccess.getEReferenceDeclAccess().getOrderedAssignment_1_2()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:887:1: ( rule__EReferenceDecl__OrderedAssignment_1_2 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:887:2: rule__EReferenceDecl__OrderedAssignment_1_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EReferenceDecl__OrderedAssignment_1_2_in_rule__EReferenceDecl__Alternatives_11939);
                    rule__EReferenceDecl__OrderedAssignment_1_2();
                    _fsp--;


                    }

                     after(grammarAccess.getEReferenceDeclAccess().getOrderedAssignment_1_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:891:6: ( ( rule__EReferenceDecl__ChangeableAssignment_1_3 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:891:6: ( ( rule__EReferenceDecl__ChangeableAssignment_1_3 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:892:1: ( rule__EReferenceDecl__ChangeableAssignment_1_3 )
                    {
                     before(grammarAccess.getEReferenceDeclAccess().getChangeableAssignment_1_3()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:893:1: ( rule__EReferenceDecl__ChangeableAssignment_1_3 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:893:2: rule__EReferenceDecl__ChangeableAssignment_1_3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EReferenceDecl__ChangeableAssignment_1_3_in_rule__EReferenceDecl__Alternatives_11957);
                    rule__EReferenceDecl__ChangeableAssignment_1_3();
                    _fsp--;


                    }

                     after(grammarAccess.getEReferenceDeclAccess().getChangeableAssignment_1_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:897:6: ( ( rule__EReferenceDecl__VolatileAssignment_1_4 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:897:6: ( ( rule__EReferenceDecl__VolatileAssignment_1_4 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:898:1: ( rule__EReferenceDecl__VolatileAssignment_1_4 )
                    {
                     before(grammarAccess.getEReferenceDeclAccess().getVolatileAssignment_1_4()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:899:1: ( rule__EReferenceDecl__VolatileAssignment_1_4 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:899:2: rule__EReferenceDecl__VolatileAssignment_1_4
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EReferenceDecl__VolatileAssignment_1_4_in_rule__EReferenceDecl__Alternatives_11975);
                    rule__EReferenceDecl__VolatileAssignment_1_4();
                    _fsp--;


                    }

                     after(grammarAccess.getEReferenceDeclAccess().getVolatileAssignment_1_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:903:6: ( ( rule__EReferenceDecl__TransientAssignment_1_5 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:903:6: ( ( rule__EReferenceDecl__TransientAssignment_1_5 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:904:1: ( rule__EReferenceDecl__TransientAssignment_1_5 )
                    {
                     before(grammarAccess.getEReferenceDeclAccess().getTransientAssignment_1_5()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:905:1: ( rule__EReferenceDecl__TransientAssignment_1_5 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:905:2: rule__EReferenceDecl__TransientAssignment_1_5
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EReferenceDecl__TransientAssignment_1_5_in_rule__EReferenceDecl__Alternatives_11993);
                    rule__EReferenceDecl__TransientAssignment_1_5();
                    _fsp--;


                    }

                     after(grammarAccess.getEReferenceDeclAccess().getTransientAssignment_1_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:909:6: ( ( rule__EReferenceDecl__UnsettableAssignment_1_6 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:909:6: ( ( rule__EReferenceDecl__UnsettableAssignment_1_6 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:910:1: ( rule__EReferenceDecl__UnsettableAssignment_1_6 )
                    {
                     before(grammarAccess.getEReferenceDeclAccess().getUnsettableAssignment_1_6()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:911:1: ( rule__EReferenceDecl__UnsettableAssignment_1_6 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:911:2: rule__EReferenceDecl__UnsettableAssignment_1_6
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EReferenceDecl__UnsettableAssignment_1_6_in_rule__EReferenceDecl__Alternatives_12011);
                    rule__EReferenceDecl__UnsettableAssignment_1_6();
                    _fsp--;


                    }

                     after(grammarAccess.getEReferenceDeclAccess().getUnsettableAssignment_1_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:915:6: ( ( rule__EReferenceDecl__DerivedAssignment_1_7 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:915:6: ( ( rule__EReferenceDecl__DerivedAssignment_1_7 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:916:1: ( rule__EReferenceDecl__DerivedAssignment_1_7 )
                    {
                     before(grammarAccess.getEReferenceDeclAccess().getDerivedAssignment_1_7()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:917:1: ( rule__EReferenceDecl__DerivedAssignment_1_7 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:917:2: rule__EReferenceDecl__DerivedAssignment_1_7
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EReferenceDecl__DerivedAssignment_1_7_in_rule__EReferenceDecl__Alternatives_12029);
                    rule__EReferenceDecl__DerivedAssignment_1_7();
                    _fsp--;


                    }

                     after(grammarAccess.getEReferenceDeclAccess().getDerivedAssignment_1_7()); 

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
    // $ANTLR end rule__EReferenceDecl__Alternatives_1


    // $ANTLR start rule__EReferenceDecl__Alternatives_2
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:926:1: rule__EReferenceDecl__Alternatives_2 : ( ( ( rule__EReferenceDecl__ContainmentAssignment_2_0 ) ) | ( 'ref' ) );
    public final void rule__EReferenceDecl__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:930:1: ( ( ( rule__EReferenceDecl__ContainmentAssignment_2_0 ) ) | ( 'ref' ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==56) ) {
                alt10=1;
            }
            else if ( (LA10_0==17) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("926:1: rule__EReferenceDecl__Alternatives_2 : ( ( ( rule__EReferenceDecl__ContainmentAssignment_2_0 ) ) | ( 'ref' ) );", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:931:1: ( ( rule__EReferenceDecl__ContainmentAssignment_2_0 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:931:1: ( ( rule__EReferenceDecl__ContainmentAssignment_2_0 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:932:1: ( rule__EReferenceDecl__ContainmentAssignment_2_0 )
                    {
                     before(grammarAccess.getEReferenceDeclAccess().getContainmentAssignment_2_0()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:933:1: ( rule__EReferenceDecl__ContainmentAssignment_2_0 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:933:2: rule__EReferenceDecl__ContainmentAssignment_2_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EReferenceDecl__ContainmentAssignment_2_0_in_rule__EReferenceDecl__Alternatives_22062);
                    rule__EReferenceDecl__ContainmentAssignment_2_0();
                    _fsp--;


                    }

                     after(grammarAccess.getEReferenceDeclAccess().getContainmentAssignment_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:937:6: ( 'ref' )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:937:6: ( 'ref' )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:938:1: 'ref'
                    {
                     before(grammarAccess.getEReferenceDeclAccess().getRefKeyword_2_1()); 
                    match(input,17,FollowSets000.FOLLOW_17_in_rule__EReferenceDecl__Alternatives_22081); 
                     after(grammarAccess.getEReferenceDeclAccess().getRefKeyword_2_1()); 

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
    // $ANTLR end rule__EReferenceDecl__Alternatives_2


    // $ANTLR start rule__EGenericTypeReferenceDecl__Alternatives
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:950:1: rule__EGenericTypeReferenceDecl__Alternatives : ( ( ( rule__EGenericTypeReferenceDecl__Group_0__0 ) ) | ( ( rule__EGenericTypeReferenceDecl__Group_1__0 ) ) );
    public final void rule__EGenericTypeReferenceDecl__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:954:1: ( ( ( rule__EGenericTypeReferenceDecl__Group_0__0 ) ) | ( ( rule__EGenericTypeReferenceDecl__Group_1__0 ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                alt11=1;
            }
            else if ( (LA11_0==42) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("950:1: rule__EGenericTypeReferenceDecl__Alternatives : ( ( ( rule__EGenericTypeReferenceDecl__Group_0__0 ) ) | ( ( rule__EGenericTypeReferenceDecl__Group_1__0 ) ) );", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:955:1: ( ( rule__EGenericTypeReferenceDecl__Group_0__0 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:955:1: ( ( rule__EGenericTypeReferenceDecl__Group_0__0 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:956:1: ( rule__EGenericTypeReferenceDecl__Group_0__0 )
                    {
                     before(grammarAccess.getEGenericTypeReferenceDeclAccess().getGroup_0()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:957:1: ( rule__EGenericTypeReferenceDecl__Group_0__0 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:957:2: rule__EGenericTypeReferenceDecl__Group_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeReferenceDecl__Group_0__0_in_rule__EGenericTypeReferenceDecl__Alternatives2115);
                    rule__EGenericTypeReferenceDecl__Group_0__0();
                    _fsp--;


                    }

                     after(grammarAccess.getEGenericTypeReferenceDeclAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:961:6: ( ( rule__EGenericTypeReferenceDecl__Group_1__0 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:961:6: ( ( rule__EGenericTypeReferenceDecl__Group_1__0 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:962:1: ( rule__EGenericTypeReferenceDecl__Group_1__0 )
                    {
                     before(grammarAccess.getEGenericTypeReferenceDeclAccess().getGroup_1()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:963:1: ( rule__EGenericTypeReferenceDecl__Group_1__0 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:963:2: rule__EGenericTypeReferenceDecl__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeReferenceDecl__Group_1__0_in_rule__EGenericTypeReferenceDecl__Alternatives2133);
                    rule__EGenericTypeReferenceDecl__Group_1__0();
                    _fsp--;


                    }

                     after(grammarAccess.getEGenericTypeReferenceDeclAccess().getGroup_1()); 

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
    // $ANTLR end rule__EGenericTypeReferenceDecl__Alternatives


    // $ANTLR start rule__EGenericTypeDecl__Alternatives
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:972:1: rule__EGenericTypeDecl__Alternatives : ( ( ( rule__EGenericTypeDecl__Group_0__0 ) ) | ( ( rule__EGenericTypeDecl__Group_1__0 ) ) | ( ( rule__EGenericTypeDecl__Group_2__0 ) ) );
    public final void rule__EGenericTypeDecl__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:976:1: ( ( ( rule__EGenericTypeDecl__Group_0__0 ) ) | ( ( rule__EGenericTypeDecl__Group_1__0 ) ) | ( ( rule__EGenericTypeDecl__Group_2__0 ) ) )
            int alt12=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt12=1;
                }
                break;
            case 42:
                {
                alt12=2;
                }
                break;
            case 44:
                {
                alt12=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("972:1: rule__EGenericTypeDecl__Alternatives : ( ( ( rule__EGenericTypeDecl__Group_0__0 ) ) | ( ( rule__EGenericTypeDecl__Group_1__0 ) ) | ( ( rule__EGenericTypeDecl__Group_2__0 ) ) );", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:977:1: ( ( rule__EGenericTypeDecl__Group_0__0 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:977:1: ( ( rule__EGenericTypeDecl__Group_0__0 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:978:1: ( rule__EGenericTypeDecl__Group_0__0 )
                    {
                     before(grammarAccess.getEGenericTypeDeclAccess().getGroup_0()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:979:1: ( rule__EGenericTypeDecl__Group_0__0 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:979:2: rule__EGenericTypeDecl__Group_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeDecl__Group_0__0_in_rule__EGenericTypeDecl__Alternatives2166);
                    rule__EGenericTypeDecl__Group_0__0();
                    _fsp--;


                    }

                     after(grammarAccess.getEGenericTypeDeclAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:983:6: ( ( rule__EGenericTypeDecl__Group_1__0 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:983:6: ( ( rule__EGenericTypeDecl__Group_1__0 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:984:1: ( rule__EGenericTypeDecl__Group_1__0 )
                    {
                     before(grammarAccess.getEGenericTypeDeclAccess().getGroup_1()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:985:1: ( rule__EGenericTypeDecl__Group_1__0 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:985:2: rule__EGenericTypeDecl__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeDecl__Group_1__0_in_rule__EGenericTypeDecl__Alternatives2184);
                    rule__EGenericTypeDecl__Group_1__0();
                    _fsp--;


                    }

                     after(grammarAccess.getEGenericTypeDeclAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:989:6: ( ( rule__EGenericTypeDecl__Group_2__0 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:989:6: ( ( rule__EGenericTypeDecl__Group_2__0 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:990:1: ( rule__EGenericTypeDecl__Group_2__0 )
                    {
                     before(grammarAccess.getEGenericTypeDeclAccess().getGroup_2()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:991:1: ( rule__EGenericTypeDecl__Group_2__0 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:991:2: rule__EGenericTypeDecl__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeDecl__Group_2__0_in_rule__EGenericTypeDecl__Alternatives2202);
                    rule__EGenericTypeDecl__Group_2__0();
                    _fsp--;


                    }

                     after(grammarAccess.getEGenericTypeDeclAccess().getGroup_2()); 

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
    // $ANTLR end rule__EGenericTypeDecl__Alternatives


    // $ANTLR start rule__EGenericTypeDecl__Alternatives_2_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1000:1: rule__EGenericTypeDecl__Alternatives_2_1 : ( ( ( rule__EGenericTypeDecl__Group_2_1_0__0 ) ) | ( ( rule__EGenericTypeDecl__Group_2_1_1__0 ) ) );
    public final void rule__EGenericTypeDecl__Alternatives_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1004:1: ( ( ( rule__EGenericTypeDecl__Group_2_1_0__0 ) ) | ( ( rule__EGenericTypeDecl__Group_2_1_1__0 ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==37) ) {
                alt13=1;
            }
            else if ( (LA13_0==45) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1000:1: rule__EGenericTypeDecl__Alternatives_2_1 : ( ( ( rule__EGenericTypeDecl__Group_2_1_0__0 ) ) | ( ( rule__EGenericTypeDecl__Group_2_1_1__0 ) ) );", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1005:1: ( ( rule__EGenericTypeDecl__Group_2_1_0__0 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1005:1: ( ( rule__EGenericTypeDecl__Group_2_1_0__0 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1006:1: ( rule__EGenericTypeDecl__Group_2_1_0__0 )
                    {
                     before(grammarAccess.getEGenericTypeDeclAccess().getGroup_2_1_0()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1007:1: ( rule__EGenericTypeDecl__Group_2_1_0__0 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1007:2: rule__EGenericTypeDecl__Group_2_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeDecl__Group_2_1_0__0_in_rule__EGenericTypeDecl__Alternatives_2_12235);
                    rule__EGenericTypeDecl__Group_2_1_0__0();
                    _fsp--;


                    }

                     after(grammarAccess.getEGenericTypeDeclAccess().getGroup_2_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1011:6: ( ( rule__EGenericTypeDecl__Group_2_1_1__0 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1011:6: ( ( rule__EGenericTypeDecl__Group_2_1_1__0 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1012:1: ( rule__EGenericTypeDecl__Group_2_1_1__0 )
                    {
                     before(grammarAccess.getEGenericTypeDeclAccess().getGroup_2_1_1()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1013:1: ( rule__EGenericTypeDecl__Group_2_1_1__0 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1013:2: rule__EGenericTypeDecl__Group_2_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeDecl__Group_2_1_1__0_in_rule__EGenericTypeDecl__Alternatives_2_12253);
                    rule__EGenericTypeDecl__Group_2_1_1__0();
                    _fsp--;


                    }

                     after(grammarAccess.getEGenericTypeDeclAccess().getGroup_2_1_1()); 

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
    // $ANTLR end rule__EGenericTypeDecl__Alternatives_2_1


    // $ANTLR start rule__EOperationDecl__Alternatives_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1022:1: rule__EOperationDecl__Alternatives_1 : ( ( ( rule__EOperationDecl__UniqueAssignment_1_0 ) ) | ( ( rule__EOperationDecl__OrderedAssignment_1_1 ) ) );
    public final void rule__EOperationDecl__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1026:1: ( ( ( rule__EOperationDecl__UniqueAssignment_1_0 ) ) | ( ( rule__EOperationDecl__OrderedAssignment_1_1 ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_BAG) ) {
                alt14=1;
            }
            else if ( (LA14_0==RULE_RANDOM) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1022:1: rule__EOperationDecl__Alternatives_1 : ( ( ( rule__EOperationDecl__UniqueAssignment_1_0 ) ) | ( ( rule__EOperationDecl__OrderedAssignment_1_1 ) ) );", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1027:1: ( ( rule__EOperationDecl__UniqueAssignment_1_0 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1027:1: ( ( rule__EOperationDecl__UniqueAssignment_1_0 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1028:1: ( rule__EOperationDecl__UniqueAssignment_1_0 )
                    {
                     before(grammarAccess.getEOperationDeclAccess().getUniqueAssignment_1_0()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1029:1: ( rule__EOperationDecl__UniqueAssignment_1_0 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1029:2: rule__EOperationDecl__UniqueAssignment_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__UniqueAssignment_1_0_in_rule__EOperationDecl__Alternatives_12286);
                    rule__EOperationDecl__UniqueAssignment_1_0();
                    _fsp--;


                    }

                     after(grammarAccess.getEOperationDeclAccess().getUniqueAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1033:6: ( ( rule__EOperationDecl__OrderedAssignment_1_1 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1033:6: ( ( rule__EOperationDecl__OrderedAssignment_1_1 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1034:1: ( rule__EOperationDecl__OrderedAssignment_1_1 )
                    {
                     before(grammarAccess.getEOperationDeclAccess().getOrderedAssignment_1_1()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1035:1: ( rule__EOperationDecl__OrderedAssignment_1_1 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1035:2: rule__EOperationDecl__OrderedAssignment_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__OrderedAssignment_1_1_in_rule__EOperationDecl__Alternatives_12304);
                    rule__EOperationDecl__OrderedAssignment_1_1();
                    _fsp--;


                    }

                     after(grammarAccess.getEOperationDeclAccess().getOrderedAssignment_1_1()); 

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
    // $ANTLR end rule__EOperationDecl__Alternatives_1


    // $ANTLR start rule__EOperationDecl__Alternatives_3
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1044:1: rule__EOperationDecl__Alternatives_3 : ( ( ( rule__EOperationDecl__EGenericTypeAssignment_3_0 ) ) | ( 'void' ) );
    public final void rule__EOperationDecl__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1048:1: ( ( ( rule__EOperationDecl__EGenericTypeAssignment_3_0 ) ) | ( 'void' ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_ID||LA15_0==42) ) {
                alt15=1;
            }
            else if ( (LA15_0==18) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1044:1: rule__EOperationDecl__Alternatives_3 : ( ( ( rule__EOperationDecl__EGenericTypeAssignment_3_0 ) ) | ( 'void' ) );", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1049:1: ( ( rule__EOperationDecl__EGenericTypeAssignment_3_0 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1049:1: ( ( rule__EOperationDecl__EGenericTypeAssignment_3_0 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1050:1: ( rule__EOperationDecl__EGenericTypeAssignment_3_0 )
                    {
                     before(grammarAccess.getEOperationDeclAccess().getEGenericTypeAssignment_3_0()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1051:1: ( rule__EOperationDecl__EGenericTypeAssignment_3_0 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1051:2: rule__EOperationDecl__EGenericTypeAssignment_3_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__EGenericTypeAssignment_3_0_in_rule__EOperationDecl__Alternatives_32337);
                    rule__EOperationDecl__EGenericTypeAssignment_3_0();
                    _fsp--;


                    }

                     after(grammarAccess.getEOperationDeclAccess().getEGenericTypeAssignment_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1055:6: ( 'void' )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1055:6: ( 'void' )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1056:1: 'void'
                    {
                     before(grammarAccess.getEOperationDeclAccess().getVoidKeyword_3_1()); 
                    match(input,18,FollowSets000.FOLLOW_18_in_rule__EOperationDecl__Alternatives_32356); 
                     after(grammarAccess.getEOperationDeclAccess().getVoidKeyword_3_1()); 

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
    // $ANTLR end rule__EOperationDecl__Alternatives_3


    // $ANTLR start rule__QID__Alternatives_1_0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1068:1: rule__QID__Alternatives_1_0 : ( ( '.' ) | ( '$' ) );
    public final void rule__QID__Alternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1072:1: ( ( '.' ) | ( '$' ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==19) ) {
                alt16=1;
            }
            else if ( (LA16_0==20) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1068:1: rule__QID__Alternatives_1_0 : ( ( '.' ) | ( '$' ) );", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1073:1: ( '.' )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1073:1: ( '.' )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1074:1: '.'
                    {
                     before(grammarAccess.getQIDAccess().getFullStopKeyword_1_0_0()); 
                    match(input,19,FollowSets000.FOLLOW_19_in_rule__QID__Alternatives_1_02391); 
                     after(grammarAccess.getQIDAccess().getFullStopKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1081:6: ( '$' )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1081:6: ( '$' )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1082:1: '$'
                    {
                     before(grammarAccess.getQIDAccess().getDollarSignKeyword_1_0_1()); 
                    match(input,20,FollowSets000.FOLLOW_20_in_rule__QID__Alternatives_1_02411); 
                     after(grammarAccess.getQIDAccess().getDollarSignKeyword_1_0_1()); 

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
    // $ANTLR end rule__QID__Alternatives_1_0


    // $ANTLR start rule__STRING_OR_QID__Alternatives
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1094:1: rule__STRING_OR_QID__Alternatives : ( ( RULE_STRING ) | ( ruleQID ) );
    public final void rule__STRING_OR_QID__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1098:1: ( ( RULE_STRING ) | ( ruleQID ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_STRING) ) {
                alt17=1;
            }
            else if ( (LA17_0==RULE_ID) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1094:1: rule__STRING_OR_QID__Alternatives : ( ( RULE_STRING ) | ( ruleQID ) );", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1099:1: ( RULE_STRING )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1099:1: ( RULE_STRING )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1100:1: RULE_STRING
                    {
                     before(grammarAccess.getSTRING_OR_QIDAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__STRING_OR_QID__Alternatives2445); 
                     after(grammarAccess.getSTRING_OR_QIDAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1105:6: ( ruleQID )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1105:6: ( ruleQID )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1106:1: ruleQID
                    {
                     before(grammarAccess.getSTRING_OR_QIDAccess().getQIDParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleQID_in_rule__STRING_OR_QID__Alternatives2462);
                    ruleQID();
                    _fsp--;

                     after(grammarAccess.getSTRING_OR_QIDAccess().getQIDParserRuleCall_1()); 

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
    // $ANTLR end rule__STRING_OR_QID__Alternatives


    // $ANTLR start rule__EcoreDsl__Group__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1118:1: rule__EcoreDsl__Group__0 : ( ( rule__EcoreDsl__MetamodelDeclarationsAssignment_0 )* ) rule__EcoreDsl__Group__1 ;
    public final void rule__EcoreDsl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1122:1: ( ( ( rule__EcoreDsl__MetamodelDeclarationsAssignment_0 )* ) rule__EcoreDsl__Group__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1123:1: ( ( rule__EcoreDsl__MetamodelDeclarationsAssignment_0 )* ) rule__EcoreDsl__Group__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1123:1: ( ( rule__EcoreDsl__MetamodelDeclarationsAssignment_0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1124:1: ( rule__EcoreDsl__MetamodelDeclarationsAssignment_0 )*
            {
             before(grammarAccess.getEcoreDslAccess().getMetamodelDeclarationsAssignment_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1125:1: ( rule__EcoreDsl__MetamodelDeclarationsAssignment_0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==21) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1125:2: rule__EcoreDsl__MetamodelDeclarationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__EcoreDsl__MetamodelDeclarationsAssignment_0_in_rule__EcoreDsl__Group__02496);
            	    rule__EcoreDsl__MetamodelDeclarationsAssignment_0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getEcoreDslAccess().getMetamodelDeclarationsAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EcoreDsl__Group__1_in_rule__EcoreDsl__Group__02506);
            rule__EcoreDsl__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EcoreDsl__Group__0


    // $ANTLR start rule__EcoreDsl__Group__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1136:1: rule__EcoreDsl__Group__1 : ( ( rule__EcoreDsl__PackageAssignment_1 ) ) ;
    public final void rule__EcoreDsl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1140:1: ( ( ( rule__EcoreDsl__PackageAssignment_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1141:1: ( ( rule__EcoreDsl__PackageAssignment_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1141:1: ( ( rule__EcoreDsl__PackageAssignment_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1142:1: ( rule__EcoreDsl__PackageAssignment_1 )
            {
             before(grammarAccess.getEcoreDslAccess().getPackageAssignment_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1143:1: ( rule__EcoreDsl__PackageAssignment_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1143:2: rule__EcoreDsl__PackageAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EcoreDsl__PackageAssignment_1_in_rule__EcoreDsl__Group__12534);
            rule__EcoreDsl__PackageAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getEcoreDslAccess().getPackageAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EcoreDsl__Group__1


    // $ANTLR start rule__ReferencedMetamodel__Group__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1157:1: rule__ReferencedMetamodel__Group__0 : ( 'import' ) rule__ReferencedMetamodel__Group__1 ;
    public final void rule__ReferencedMetamodel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1161:1: ( ( 'import' ) rule__ReferencedMetamodel__Group__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1162:1: ( 'import' ) rule__ReferencedMetamodel__Group__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1162:1: ( 'import' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1163:1: 'import'
            {
             before(grammarAccess.getReferencedMetamodelAccess().getImportKeyword_0()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__ReferencedMetamodel__Group__02573); 
             after(grammarAccess.getReferencedMetamodelAccess().getImportKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group__1_in_rule__ReferencedMetamodel__Group__02583);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1177:1: rule__ReferencedMetamodel__Group__1 : ( ( rule__ReferencedMetamodel__Group_1__0 )? ) rule__ReferencedMetamodel__Group__2 ;
    public final void rule__ReferencedMetamodel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1181:1: ( ( ( rule__ReferencedMetamodel__Group_1__0 )? ) rule__ReferencedMetamodel__Group__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1182:1: ( ( rule__ReferencedMetamodel__Group_1__0 )? ) rule__ReferencedMetamodel__Group__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1182:1: ( ( rule__ReferencedMetamodel__Group_1__0 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1183:1: ( rule__ReferencedMetamodel__Group_1__0 )?
            {
             before(grammarAccess.getReferencedMetamodelAccess().getGroup_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1184:1: ( rule__ReferencedMetamodel__Group_1__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ID) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1184:2: rule__ReferencedMetamodel__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group_1__0_in_rule__ReferencedMetamodel__Group__12611);
                    rule__ReferencedMetamodel__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getReferencedMetamodelAccess().getGroup_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group__2_in_rule__ReferencedMetamodel__Group__12621);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1195:1: rule__ReferencedMetamodel__Group__2 : ( ( rule__ReferencedMetamodel__EPackageAssignment_2 ) ) rule__ReferencedMetamodel__Group__3 ;
    public final void rule__ReferencedMetamodel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1199:1: ( ( ( rule__ReferencedMetamodel__EPackageAssignment_2 ) ) rule__ReferencedMetamodel__Group__3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1200:1: ( ( rule__ReferencedMetamodel__EPackageAssignment_2 ) ) rule__ReferencedMetamodel__Group__3
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1200:1: ( ( rule__ReferencedMetamodel__EPackageAssignment_2 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1201:1: ( rule__ReferencedMetamodel__EPackageAssignment_2 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageAssignment_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1202:1: ( rule__ReferencedMetamodel__EPackageAssignment_2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1202:2: rule__ReferencedMetamodel__EPackageAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__EPackageAssignment_2_in_rule__ReferencedMetamodel__Group__22649);
            rule__ReferencedMetamodel__EPackageAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getReferencedMetamodelAccess().getEPackageAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group__3_in_rule__ReferencedMetamodel__Group__22658);
            rule__ReferencedMetamodel__Group__3();
            _fsp--;


            }

        }
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


    // $ANTLR start rule__ReferencedMetamodel__Group__3
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1213:1: rule__ReferencedMetamodel__Group__3 : ( ';' ) ;
    public final void rule__ReferencedMetamodel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1217:1: ( ( ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1218:1: ( ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1218:1: ( ';' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1219:1: ';'
            {
             before(grammarAccess.getReferencedMetamodelAccess().getSemicolonKeyword_3()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__ReferencedMetamodel__Group__32687); 
             after(grammarAccess.getReferencedMetamodelAccess().getSemicolonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ReferencedMetamodel__Group__3


    // $ANTLR start rule__ReferencedMetamodel__Group_1__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1240:1: rule__ReferencedMetamodel__Group_1__0 : ( ( rule__ReferencedMetamodel__AliasAssignment_1_0 ) ) rule__ReferencedMetamodel__Group_1__1 ;
    public final void rule__ReferencedMetamodel__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1244:1: ( ( ( rule__ReferencedMetamodel__AliasAssignment_1_0 ) ) rule__ReferencedMetamodel__Group_1__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1245:1: ( ( rule__ReferencedMetamodel__AliasAssignment_1_0 ) ) rule__ReferencedMetamodel__Group_1__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1245:1: ( ( rule__ReferencedMetamodel__AliasAssignment_1_0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1246:1: ( rule__ReferencedMetamodel__AliasAssignment_1_0 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAliasAssignment_1_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1247:1: ( rule__ReferencedMetamodel__AliasAssignment_1_0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1247:2: rule__ReferencedMetamodel__AliasAssignment_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__AliasAssignment_1_0_in_rule__ReferencedMetamodel__Group_1__02730);
            rule__ReferencedMetamodel__AliasAssignment_1_0();
            _fsp--;


            }

             after(grammarAccess.getReferencedMetamodelAccess().getAliasAssignment_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group_1__1_in_rule__ReferencedMetamodel__Group_1__02739);
            rule__ReferencedMetamodel__Group_1__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ReferencedMetamodel__Group_1__0


    // $ANTLR start rule__ReferencedMetamodel__Group_1__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1258:1: rule__ReferencedMetamodel__Group_1__1 : ( '=' ) ;
    public final void rule__ReferencedMetamodel__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1262:1: ( ( '=' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1263:1: ( '=' )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1263:1: ( '=' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1264:1: '='
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEqualsSignKeyword_1_1()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__ReferencedMetamodel__Group_1__12768); 
             after(grammarAccess.getReferencedMetamodelAccess().getEqualsSignKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ReferencedMetamodel__Group_1__1


    // $ANTLR start rule__EPackageDecl__Group__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1281:1: rule__EPackageDecl__Group__0 : ( ( rule__EPackageDecl__EAnnotationsAssignment_0 )* ) rule__EPackageDecl__Group__1 ;
    public final void rule__EPackageDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1285:1: ( ( ( rule__EPackageDecl__EAnnotationsAssignment_0 )* ) rule__EPackageDecl__Group__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1286:1: ( ( rule__EPackageDecl__EAnnotationsAssignment_0 )* ) rule__EPackageDecl__Group__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1286:1: ( ( rule__EPackageDecl__EAnnotationsAssignment_0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1287:1: ( rule__EPackageDecl__EAnnotationsAssignment_0 )*
            {
             before(grammarAccess.getEPackageDeclAccess().getEAnnotationsAssignment_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1288:1: ( rule__EPackageDecl__EAnnotationsAssignment_0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==31) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1288:2: rule__EPackageDecl__EAnnotationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__EPackageDecl__EAnnotationsAssignment_0_in_rule__EPackageDecl__Group__02807);
            	    rule__EPackageDecl__EAnnotationsAssignment_0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getEPackageDeclAccess().getEAnnotationsAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EPackageDecl__Group__1_in_rule__EPackageDecl__Group__02817);
            rule__EPackageDecl__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EPackageDecl__Group__0


    // $ANTLR start rule__EPackageDecl__Group__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1299:1: rule__EPackageDecl__Group__1 : ( 'package' ) rule__EPackageDecl__Group__2 ;
    public final void rule__EPackageDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1303:1: ( ( 'package' ) rule__EPackageDecl__Group__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1304:1: ( 'package' ) rule__EPackageDecl__Group__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1304:1: ( 'package' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1305:1: 'package'
            {
             before(grammarAccess.getEPackageDeclAccess().getPackageKeyword_1()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__EPackageDecl__Group__12846); 
             after(grammarAccess.getEPackageDeclAccess().getPackageKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EPackageDecl__Group__2_in_rule__EPackageDecl__Group__12856);
            rule__EPackageDecl__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EPackageDecl__Group__1


    // $ANTLR start rule__EPackageDecl__Group__2
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1319:1: rule__EPackageDecl__Group__2 : ( ( rule__EPackageDecl__NameAssignment_2 ) ) rule__EPackageDecl__Group__3 ;
    public final void rule__EPackageDecl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1323:1: ( ( ( rule__EPackageDecl__NameAssignment_2 ) ) rule__EPackageDecl__Group__3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1324:1: ( ( rule__EPackageDecl__NameAssignment_2 ) ) rule__EPackageDecl__Group__3
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1324:1: ( ( rule__EPackageDecl__NameAssignment_2 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1325:1: ( rule__EPackageDecl__NameAssignment_2 )
            {
             before(grammarAccess.getEPackageDeclAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1326:1: ( rule__EPackageDecl__NameAssignment_2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1326:2: rule__EPackageDecl__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__EPackageDecl__NameAssignment_2_in_rule__EPackageDecl__Group__22884);
            rule__EPackageDecl__NameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getEPackageDeclAccess().getNameAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EPackageDecl__Group__3_in_rule__EPackageDecl__Group__22893);
            rule__EPackageDecl__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EPackageDecl__Group__2


    // $ANTLR start rule__EPackageDecl__Group__3
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1337:1: rule__EPackageDecl__Group__3 : ( 'nsURI' ) rule__EPackageDecl__Group__4 ;
    public final void rule__EPackageDecl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1341:1: ( ( 'nsURI' ) rule__EPackageDecl__Group__4 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1342:1: ( 'nsURI' ) rule__EPackageDecl__Group__4
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1342:1: ( 'nsURI' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1343:1: 'nsURI'
            {
             before(grammarAccess.getEPackageDeclAccess().getNsURIKeyword_3()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__EPackageDecl__Group__32922); 
             after(grammarAccess.getEPackageDeclAccess().getNsURIKeyword_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EPackageDecl__Group__4_in_rule__EPackageDecl__Group__32932);
            rule__EPackageDecl__Group__4();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EPackageDecl__Group__3


    // $ANTLR start rule__EPackageDecl__Group__4
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1357:1: rule__EPackageDecl__Group__4 : ( '=' ) rule__EPackageDecl__Group__5 ;
    public final void rule__EPackageDecl__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1361:1: ( ( '=' ) rule__EPackageDecl__Group__5 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1362:1: ( '=' ) rule__EPackageDecl__Group__5
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1362:1: ( '=' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1363:1: '='
            {
             before(grammarAccess.getEPackageDeclAccess().getEqualsSignKeyword_4()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__EPackageDecl__Group__42961); 
             after(grammarAccess.getEPackageDeclAccess().getEqualsSignKeyword_4()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EPackageDecl__Group__5_in_rule__EPackageDecl__Group__42971);
            rule__EPackageDecl__Group__5();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EPackageDecl__Group__4


    // $ANTLR start rule__EPackageDecl__Group__5
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1377:1: rule__EPackageDecl__Group__5 : ( ( rule__EPackageDecl__NsURIAssignment_5 ) ) rule__EPackageDecl__Group__6 ;
    public final void rule__EPackageDecl__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1381:1: ( ( ( rule__EPackageDecl__NsURIAssignment_5 ) ) rule__EPackageDecl__Group__6 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1382:1: ( ( rule__EPackageDecl__NsURIAssignment_5 ) ) rule__EPackageDecl__Group__6
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1382:1: ( ( rule__EPackageDecl__NsURIAssignment_5 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1383:1: ( rule__EPackageDecl__NsURIAssignment_5 )
            {
             before(grammarAccess.getEPackageDeclAccess().getNsURIAssignment_5()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1384:1: ( rule__EPackageDecl__NsURIAssignment_5 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1384:2: rule__EPackageDecl__NsURIAssignment_5
            {
            pushFollow(FollowSets000.FOLLOW_rule__EPackageDecl__NsURIAssignment_5_in_rule__EPackageDecl__Group__52999);
            rule__EPackageDecl__NsURIAssignment_5();
            _fsp--;


            }

             after(grammarAccess.getEPackageDeclAccess().getNsURIAssignment_5()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EPackageDecl__Group__6_in_rule__EPackageDecl__Group__53008);
            rule__EPackageDecl__Group__6();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EPackageDecl__Group__5


    // $ANTLR start rule__EPackageDecl__Group__6
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1395:1: rule__EPackageDecl__Group__6 : ( 'nsPrefix' ) rule__EPackageDecl__Group__7 ;
    public final void rule__EPackageDecl__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1399:1: ( ( 'nsPrefix' ) rule__EPackageDecl__Group__7 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1400:1: ( 'nsPrefix' ) rule__EPackageDecl__Group__7
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1400:1: ( 'nsPrefix' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1401:1: 'nsPrefix'
            {
             before(grammarAccess.getEPackageDeclAccess().getNsPrefixKeyword_6()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__EPackageDecl__Group__63037); 
             after(grammarAccess.getEPackageDeclAccess().getNsPrefixKeyword_6()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EPackageDecl__Group__7_in_rule__EPackageDecl__Group__63047);
            rule__EPackageDecl__Group__7();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EPackageDecl__Group__6


    // $ANTLR start rule__EPackageDecl__Group__7
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1415:1: rule__EPackageDecl__Group__7 : ( '=' ) rule__EPackageDecl__Group__8 ;
    public final void rule__EPackageDecl__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1419:1: ( ( '=' ) rule__EPackageDecl__Group__8 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1420:1: ( '=' ) rule__EPackageDecl__Group__8
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1420:1: ( '=' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1421:1: '='
            {
             before(grammarAccess.getEPackageDeclAccess().getEqualsSignKeyword_7()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__EPackageDecl__Group__73076); 
             after(grammarAccess.getEPackageDeclAccess().getEqualsSignKeyword_7()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EPackageDecl__Group__8_in_rule__EPackageDecl__Group__73086);
            rule__EPackageDecl__Group__8();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EPackageDecl__Group__7


    // $ANTLR start rule__EPackageDecl__Group__8
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1435:1: rule__EPackageDecl__Group__8 : ( ( rule__EPackageDecl__NsPrefixAssignment_8 ) ) rule__EPackageDecl__Group__9 ;
    public final void rule__EPackageDecl__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1439:1: ( ( ( rule__EPackageDecl__NsPrefixAssignment_8 ) ) rule__EPackageDecl__Group__9 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1440:1: ( ( rule__EPackageDecl__NsPrefixAssignment_8 ) ) rule__EPackageDecl__Group__9
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1440:1: ( ( rule__EPackageDecl__NsPrefixAssignment_8 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1441:1: ( rule__EPackageDecl__NsPrefixAssignment_8 )
            {
             before(grammarAccess.getEPackageDeclAccess().getNsPrefixAssignment_8()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1442:1: ( rule__EPackageDecl__NsPrefixAssignment_8 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1442:2: rule__EPackageDecl__NsPrefixAssignment_8
            {
            pushFollow(FollowSets000.FOLLOW_rule__EPackageDecl__NsPrefixAssignment_8_in_rule__EPackageDecl__Group__83114);
            rule__EPackageDecl__NsPrefixAssignment_8();
            _fsp--;


            }

             after(grammarAccess.getEPackageDeclAccess().getNsPrefixAssignment_8()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EPackageDecl__Group__9_in_rule__EPackageDecl__Group__83123);
            rule__EPackageDecl__Group__9();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EPackageDecl__Group__8


    // $ANTLR start rule__EPackageDecl__Group__9
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1453:1: rule__EPackageDecl__Group__9 : ( '{' ) rule__EPackageDecl__Group__10 ;
    public final void rule__EPackageDecl__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1457:1: ( ( '{' ) rule__EPackageDecl__Group__10 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1458:1: ( '{' ) rule__EPackageDecl__Group__10
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1458:1: ( '{' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1459:1: '{'
            {
             before(grammarAccess.getEPackageDeclAccess().getLeftCurlyBracketKeyword_9()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__EPackageDecl__Group__93152); 
             after(grammarAccess.getEPackageDeclAccess().getLeftCurlyBracketKeyword_9()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EPackageDecl__Group__10_in_rule__EPackageDecl__Group__93162);
            rule__EPackageDecl__Group__10();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EPackageDecl__Group__9


    // $ANTLR start rule__EPackageDecl__Group__10
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1473:1: rule__EPackageDecl__Group__10 : ( ( rule__EPackageDecl__Alternatives_10 )* ) rule__EPackageDecl__Group__11 ;
    public final void rule__EPackageDecl__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1477:1: ( ( ( rule__EPackageDecl__Alternatives_10 )* ) rule__EPackageDecl__Group__11 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1478:1: ( ( rule__EPackageDecl__Alternatives_10 )* ) rule__EPackageDecl__Group__11
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1478:1: ( ( rule__EPackageDecl__Alternatives_10 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1479:1: ( rule__EPackageDecl__Alternatives_10 )*
            {
             before(grammarAccess.getEPackageDeclAccess().getAlternatives_10()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1480:1: ( rule__EPackageDecl__Alternatives_10 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_SERIALIZABLE||LA21_0==16||LA21_0==24||LA21_0==29||LA21_0==31||LA21_0==43||(LA21_0>=49 && LA21_0<=50)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1480:2: rule__EPackageDecl__Alternatives_10
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__EPackageDecl__Alternatives_10_in_rule__EPackageDecl__Group__103190);
            	    rule__EPackageDecl__Alternatives_10();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getEPackageDeclAccess().getAlternatives_10()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EPackageDecl__Group__11_in_rule__EPackageDecl__Group__103200);
            rule__EPackageDecl__Group__11();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EPackageDecl__Group__10


    // $ANTLR start rule__EPackageDecl__Group__11
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1491:1: rule__EPackageDecl__Group__11 : ( '}' ) ;
    public final void rule__EPackageDecl__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1495:1: ( ( '}' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1496:1: ( '}' )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1496:1: ( '}' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1497:1: '}'
            {
             before(grammarAccess.getEPackageDeclAccess().getRightCurlyBracketKeyword_11()); 
            match(input,28,FollowSets000.FOLLOW_28_in_rule__EPackageDecl__Group__113229); 
             after(grammarAccess.getEPackageDeclAccess().getRightCurlyBracketKeyword_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EPackageDecl__Group__11


    // $ANTLR start rule__SubEPackageDecl__Group__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1534:1: rule__SubEPackageDecl__Group__0 : ( ( rule__SubEPackageDecl__EAnnotationsAssignment_0 )* ) rule__SubEPackageDecl__Group__1 ;
    public final void rule__SubEPackageDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1538:1: ( ( ( rule__SubEPackageDecl__EAnnotationsAssignment_0 )* ) rule__SubEPackageDecl__Group__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1539:1: ( ( rule__SubEPackageDecl__EAnnotationsAssignment_0 )* ) rule__SubEPackageDecl__Group__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1539:1: ( ( rule__SubEPackageDecl__EAnnotationsAssignment_0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1540:1: ( rule__SubEPackageDecl__EAnnotationsAssignment_0 )*
            {
             before(grammarAccess.getSubEPackageDeclAccess().getEAnnotationsAssignment_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1541:1: ( rule__SubEPackageDecl__EAnnotationsAssignment_0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==31) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1541:2: rule__SubEPackageDecl__EAnnotationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__SubEPackageDecl__EAnnotationsAssignment_0_in_rule__SubEPackageDecl__Group__03288);
            	    rule__SubEPackageDecl__EAnnotationsAssignment_0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getSubEPackageDeclAccess().getEAnnotationsAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__SubEPackageDecl__Group__1_in_rule__SubEPackageDecl__Group__03298);
            rule__SubEPackageDecl__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SubEPackageDecl__Group__0


    // $ANTLR start rule__SubEPackageDecl__Group__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1552:1: rule__SubEPackageDecl__Group__1 : ( 'package' ) rule__SubEPackageDecl__Group__2 ;
    public final void rule__SubEPackageDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1556:1: ( ( 'package' ) rule__SubEPackageDecl__Group__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1557:1: ( 'package' ) rule__SubEPackageDecl__Group__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1557:1: ( 'package' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1558:1: 'package'
            {
             before(grammarAccess.getSubEPackageDeclAccess().getPackageKeyword_1()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__SubEPackageDecl__Group__13327); 
             after(grammarAccess.getSubEPackageDeclAccess().getPackageKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__SubEPackageDecl__Group__2_in_rule__SubEPackageDecl__Group__13337);
            rule__SubEPackageDecl__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SubEPackageDecl__Group__1


    // $ANTLR start rule__SubEPackageDecl__Group__2
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1572:1: rule__SubEPackageDecl__Group__2 : ( ( rule__SubEPackageDecl__NameAssignment_2 ) ) rule__SubEPackageDecl__Group__3 ;
    public final void rule__SubEPackageDecl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1576:1: ( ( ( rule__SubEPackageDecl__NameAssignment_2 ) ) rule__SubEPackageDecl__Group__3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1577:1: ( ( rule__SubEPackageDecl__NameAssignment_2 ) ) rule__SubEPackageDecl__Group__3
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1577:1: ( ( rule__SubEPackageDecl__NameAssignment_2 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1578:1: ( rule__SubEPackageDecl__NameAssignment_2 )
            {
             before(grammarAccess.getSubEPackageDeclAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1579:1: ( rule__SubEPackageDecl__NameAssignment_2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1579:2: rule__SubEPackageDecl__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__SubEPackageDecl__NameAssignment_2_in_rule__SubEPackageDecl__Group__23365);
            rule__SubEPackageDecl__NameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getSubEPackageDeclAccess().getNameAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__SubEPackageDecl__Group__3_in_rule__SubEPackageDecl__Group__23374);
            rule__SubEPackageDecl__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SubEPackageDecl__Group__2


    // $ANTLR start rule__SubEPackageDecl__Group__3
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1590:1: rule__SubEPackageDecl__Group__3 : ( '{' ) rule__SubEPackageDecl__Group__4 ;
    public final void rule__SubEPackageDecl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1594:1: ( ( '{' ) rule__SubEPackageDecl__Group__4 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1595:1: ( '{' ) rule__SubEPackageDecl__Group__4
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1595:1: ( '{' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1596:1: '{'
            {
             before(grammarAccess.getSubEPackageDeclAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__SubEPackageDecl__Group__33403); 
             after(grammarAccess.getSubEPackageDeclAccess().getLeftCurlyBracketKeyword_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__SubEPackageDecl__Group__4_in_rule__SubEPackageDecl__Group__33413);
            rule__SubEPackageDecl__Group__4();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SubEPackageDecl__Group__3


    // $ANTLR start rule__SubEPackageDecl__Group__4
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1610:1: rule__SubEPackageDecl__Group__4 : ( ( rule__SubEPackageDecl__Alternatives_4 )* ) rule__SubEPackageDecl__Group__5 ;
    public final void rule__SubEPackageDecl__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1614:1: ( ( ( rule__SubEPackageDecl__Alternatives_4 )* ) rule__SubEPackageDecl__Group__5 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1615:1: ( ( rule__SubEPackageDecl__Alternatives_4 )* ) rule__SubEPackageDecl__Group__5
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1615:1: ( ( rule__SubEPackageDecl__Alternatives_4 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1616:1: ( rule__SubEPackageDecl__Alternatives_4 )*
            {
             before(grammarAccess.getSubEPackageDeclAccess().getAlternatives_4()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1617:1: ( rule__SubEPackageDecl__Alternatives_4 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_SERIALIZABLE||LA23_0==16||LA23_0==24||LA23_0==29||LA23_0==31||LA23_0==43||(LA23_0>=49 && LA23_0<=50)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1617:2: rule__SubEPackageDecl__Alternatives_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__SubEPackageDecl__Alternatives_4_in_rule__SubEPackageDecl__Group__43441);
            	    rule__SubEPackageDecl__Alternatives_4();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getSubEPackageDeclAccess().getAlternatives_4()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__SubEPackageDecl__Group__5_in_rule__SubEPackageDecl__Group__43451);
            rule__SubEPackageDecl__Group__5();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SubEPackageDecl__Group__4


    // $ANTLR start rule__SubEPackageDecl__Group__5
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1628:1: rule__SubEPackageDecl__Group__5 : ( '}' ) ;
    public final void rule__SubEPackageDecl__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1632:1: ( ( '}' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1633:1: ( '}' )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1633:1: ( '}' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1634:1: '}'
            {
             before(grammarAccess.getSubEPackageDeclAccess().getRightCurlyBracketKeyword_5()); 
            match(input,28,FollowSets000.FOLLOW_28_in_rule__SubEPackageDecl__Group__53480); 
             after(grammarAccess.getSubEPackageDeclAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SubEPackageDecl__Group__5


    // $ANTLR start rule__EDataTypeDecl__Group_0__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1659:1: rule__EDataTypeDecl__Group_0__0 : ( ( rule__EDataTypeDecl__EAnnotationsAssignment_0_0 )* ) rule__EDataTypeDecl__Group_0__1 ;
    public final void rule__EDataTypeDecl__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1663:1: ( ( ( rule__EDataTypeDecl__EAnnotationsAssignment_0_0 )* ) rule__EDataTypeDecl__Group_0__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1664:1: ( ( rule__EDataTypeDecl__EAnnotationsAssignment_0_0 )* ) rule__EDataTypeDecl__Group_0__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1664:1: ( ( rule__EDataTypeDecl__EAnnotationsAssignment_0_0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1665:1: ( rule__EDataTypeDecl__EAnnotationsAssignment_0_0 )*
            {
             before(grammarAccess.getEDataTypeDeclAccess().getEAnnotationsAssignment_0_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1666:1: ( rule__EDataTypeDecl__EAnnotationsAssignment_0_0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==31) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1666:2: rule__EDataTypeDecl__EAnnotationsAssignment_0_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__EDataTypeDecl__EAnnotationsAssignment_0_0_in_rule__EDataTypeDecl__Group_0__03527);
            	    rule__EDataTypeDecl__EAnnotationsAssignment_0_0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

             after(grammarAccess.getEDataTypeDeclAccess().getEAnnotationsAssignment_0_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EDataTypeDecl__Group_0__1_in_rule__EDataTypeDecl__Group_0__03537);
            rule__EDataTypeDecl__Group_0__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EDataTypeDecl__Group_0__0


    // $ANTLR start rule__EDataTypeDecl__Group_0__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1677:1: rule__EDataTypeDecl__Group_0__1 : ( ( rule__EDataTypeDecl__SerializableAssignment_0_1 )? ) rule__EDataTypeDecl__Group_0__2 ;
    public final void rule__EDataTypeDecl__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1681:1: ( ( ( rule__EDataTypeDecl__SerializableAssignment_0_1 )? ) rule__EDataTypeDecl__Group_0__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1682:1: ( ( rule__EDataTypeDecl__SerializableAssignment_0_1 )? ) rule__EDataTypeDecl__Group_0__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1682:1: ( ( rule__EDataTypeDecl__SerializableAssignment_0_1 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1683:1: ( rule__EDataTypeDecl__SerializableAssignment_0_1 )?
            {
             before(grammarAccess.getEDataTypeDeclAccess().getSerializableAssignment_0_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1684:1: ( rule__EDataTypeDecl__SerializableAssignment_0_1 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_SERIALIZABLE) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1684:2: rule__EDataTypeDecl__SerializableAssignment_0_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EDataTypeDecl__SerializableAssignment_0_1_in_rule__EDataTypeDecl__Group_0__13565);
                    rule__EDataTypeDecl__SerializableAssignment_0_1();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEDataTypeDeclAccess().getSerializableAssignment_0_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EDataTypeDecl__Group_0__2_in_rule__EDataTypeDecl__Group_0__13575);
            rule__EDataTypeDecl__Group_0__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EDataTypeDecl__Group_0__1


    // $ANTLR start rule__EDataTypeDecl__Group_0__2
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1695:1: rule__EDataTypeDecl__Group_0__2 : ( ( rule__EDataTypeDecl__Group_0_2__0 ) ) ;
    public final void rule__EDataTypeDecl__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1699:1: ( ( ( rule__EDataTypeDecl__Group_0_2__0 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1700:1: ( ( rule__EDataTypeDecl__Group_0_2__0 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1700:1: ( ( rule__EDataTypeDecl__Group_0_2__0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1701:1: ( rule__EDataTypeDecl__Group_0_2__0 )
            {
             before(grammarAccess.getEDataTypeDeclAccess().getGroup_0_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1702:1: ( rule__EDataTypeDecl__Group_0_2__0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1702:2: rule__EDataTypeDecl__Group_0_2__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EDataTypeDecl__Group_0_2__0_in_rule__EDataTypeDecl__Group_0__23603);
            rule__EDataTypeDecl__Group_0_2__0();
            _fsp--;


            }

             after(grammarAccess.getEDataTypeDeclAccess().getGroup_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EDataTypeDecl__Group_0__2


    // $ANTLR start rule__EDataTypeDecl__Group_0_2__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1718:1: rule__EDataTypeDecl__Group_0_2__0 : ( 'datatype' ) rule__EDataTypeDecl__Group_0_2__1 ;
    public final void rule__EDataTypeDecl__Group_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1722:1: ( ( 'datatype' ) rule__EDataTypeDecl__Group_0_2__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1723:1: ( 'datatype' ) rule__EDataTypeDecl__Group_0_2__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1723:1: ( 'datatype' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1724:1: 'datatype'
            {
             before(grammarAccess.getEDataTypeDeclAccess().getDatatypeKeyword_0_2_0()); 
            match(input,29,FollowSets000.FOLLOW_29_in_rule__EDataTypeDecl__Group_0_2__03644); 
             after(grammarAccess.getEDataTypeDeclAccess().getDatatypeKeyword_0_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EDataTypeDecl__Group_0_2__1_in_rule__EDataTypeDecl__Group_0_2__03654);
            rule__EDataTypeDecl__Group_0_2__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EDataTypeDecl__Group_0_2__0


    // $ANTLR start rule__EDataTypeDecl__Group_0_2__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1738:1: rule__EDataTypeDecl__Group_0_2__1 : ( ( rule__EDataTypeDecl__NameAssignment_0_2_1 ) ) rule__EDataTypeDecl__Group_0_2__2 ;
    public final void rule__EDataTypeDecl__Group_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1742:1: ( ( ( rule__EDataTypeDecl__NameAssignment_0_2_1 ) ) rule__EDataTypeDecl__Group_0_2__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1743:1: ( ( rule__EDataTypeDecl__NameAssignment_0_2_1 ) ) rule__EDataTypeDecl__Group_0_2__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1743:1: ( ( rule__EDataTypeDecl__NameAssignment_0_2_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1744:1: ( rule__EDataTypeDecl__NameAssignment_0_2_1 )
            {
             before(grammarAccess.getEDataTypeDeclAccess().getNameAssignment_0_2_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1745:1: ( rule__EDataTypeDecl__NameAssignment_0_2_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1745:2: rule__EDataTypeDecl__NameAssignment_0_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EDataTypeDecl__NameAssignment_0_2_1_in_rule__EDataTypeDecl__Group_0_2__13682);
            rule__EDataTypeDecl__NameAssignment_0_2_1();
            _fsp--;


            }

             after(grammarAccess.getEDataTypeDeclAccess().getNameAssignment_0_2_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EDataTypeDecl__Group_0_2__2_in_rule__EDataTypeDecl__Group_0_2__13691);
            rule__EDataTypeDecl__Group_0_2__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EDataTypeDecl__Group_0_2__1


    // $ANTLR start rule__EDataTypeDecl__Group_0_2__2
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1756:1: rule__EDataTypeDecl__Group_0_2__2 : ( ':' ) rule__EDataTypeDecl__Group_0_2__3 ;
    public final void rule__EDataTypeDecl__Group_0_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1760:1: ( ( ':' ) rule__EDataTypeDecl__Group_0_2__3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1761:1: ( ':' ) rule__EDataTypeDecl__Group_0_2__3
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1761:1: ( ':' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1762:1: ':'
            {
             before(grammarAccess.getEDataTypeDeclAccess().getColonKeyword_0_2_2()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__EDataTypeDecl__Group_0_2__23720); 
             after(grammarAccess.getEDataTypeDeclAccess().getColonKeyword_0_2_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EDataTypeDecl__Group_0_2__3_in_rule__EDataTypeDecl__Group_0_2__23730);
            rule__EDataTypeDecl__Group_0_2__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EDataTypeDecl__Group_0_2__2


    // $ANTLR start rule__EDataTypeDecl__Group_0_2__3
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1776:1: rule__EDataTypeDecl__Group_0_2__3 : ( ( rule__EDataTypeDecl__InstanceClassNameAssignment_0_2_3 ) ) rule__EDataTypeDecl__Group_0_2__4 ;
    public final void rule__EDataTypeDecl__Group_0_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1780:1: ( ( ( rule__EDataTypeDecl__InstanceClassNameAssignment_0_2_3 ) ) rule__EDataTypeDecl__Group_0_2__4 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1781:1: ( ( rule__EDataTypeDecl__InstanceClassNameAssignment_0_2_3 ) ) rule__EDataTypeDecl__Group_0_2__4
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1781:1: ( ( rule__EDataTypeDecl__InstanceClassNameAssignment_0_2_3 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1782:1: ( rule__EDataTypeDecl__InstanceClassNameAssignment_0_2_3 )
            {
             before(grammarAccess.getEDataTypeDeclAccess().getInstanceClassNameAssignment_0_2_3()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1783:1: ( rule__EDataTypeDecl__InstanceClassNameAssignment_0_2_3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1783:2: rule__EDataTypeDecl__InstanceClassNameAssignment_0_2_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__EDataTypeDecl__InstanceClassNameAssignment_0_2_3_in_rule__EDataTypeDecl__Group_0_2__33758);
            rule__EDataTypeDecl__InstanceClassNameAssignment_0_2_3();
            _fsp--;


            }

             after(grammarAccess.getEDataTypeDeclAccess().getInstanceClassNameAssignment_0_2_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EDataTypeDecl__Group_0_2__4_in_rule__EDataTypeDecl__Group_0_2__33767);
            rule__EDataTypeDecl__Group_0_2__4();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EDataTypeDecl__Group_0_2__3


    // $ANTLR start rule__EDataTypeDecl__Group_0_2__4
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1794:1: rule__EDataTypeDecl__Group_0_2__4 : ( ';' ) ;
    public final void rule__EDataTypeDecl__Group_0_2__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1798:1: ( ( ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1799:1: ( ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1799:1: ( ';' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1800:1: ';'
            {
             before(grammarAccess.getEDataTypeDeclAccess().getSemicolonKeyword_0_2_4()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__EDataTypeDecl__Group_0_2__43796); 
             after(grammarAccess.getEDataTypeDeclAccess().getSemicolonKeyword_0_2_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EDataTypeDecl__Group_0_2__4


    // $ANTLR start rule__EAnnotationDecl__Group__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1823:1: rule__EAnnotationDecl__Group__0 : ( '@' ) rule__EAnnotationDecl__Group__1 ;
    public final void rule__EAnnotationDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1827:1: ( ( '@' ) rule__EAnnotationDecl__Group__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1828:1: ( '@' ) rule__EAnnotationDecl__Group__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1828:1: ( '@' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1829:1: '@'
            {
             before(grammarAccess.getEAnnotationDeclAccess().getCommercialAtKeyword_0()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__EAnnotationDecl__Group__03842); 
             after(grammarAccess.getEAnnotationDeclAccess().getCommercialAtKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EAnnotationDecl__Group__1_in_rule__EAnnotationDecl__Group__03852);
            rule__EAnnotationDecl__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAnnotationDecl__Group__0


    // $ANTLR start rule__EAnnotationDecl__Group__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1843:1: rule__EAnnotationDecl__Group__1 : ( ( rule__EAnnotationDecl__SourceAssignment_1 ) ) rule__EAnnotationDecl__Group__2 ;
    public final void rule__EAnnotationDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1847:1: ( ( ( rule__EAnnotationDecl__SourceAssignment_1 ) ) rule__EAnnotationDecl__Group__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1848:1: ( ( rule__EAnnotationDecl__SourceAssignment_1 ) ) rule__EAnnotationDecl__Group__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1848:1: ( ( rule__EAnnotationDecl__SourceAssignment_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1849:1: ( rule__EAnnotationDecl__SourceAssignment_1 )
            {
             before(grammarAccess.getEAnnotationDeclAccess().getSourceAssignment_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1850:1: ( rule__EAnnotationDecl__SourceAssignment_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1850:2: rule__EAnnotationDecl__SourceAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EAnnotationDecl__SourceAssignment_1_in_rule__EAnnotationDecl__Group__13880);
            rule__EAnnotationDecl__SourceAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getEAnnotationDeclAccess().getSourceAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EAnnotationDecl__Group__2_in_rule__EAnnotationDecl__Group__13889);
            rule__EAnnotationDecl__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAnnotationDecl__Group__1


    // $ANTLR start rule__EAnnotationDecl__Group__2
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1861:1: rule__EAnnotationDecl__Group__2 : ( ( rule__EAnnotationDecl__Group_2__0 )? ) ;
    public final void rule__EAnnotationDecl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1865:1: ( ( ( rule__EAnnotationDecl__Group_2__0 )? ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1866:1: ( ( rule__EAnnotationDecl__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1866:1: ( ( rule__EAnnotationDecl__Group_2__0 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1867:1: ( rule__EAnnotationDecl__Group_2__0 )?
            {
             before(grammarAccess.getEAnnotationDeclAccess().getGroup_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1868:1: ( rule__EAnnotationDecl__Group_2__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==32) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1868:2: rule__EAnnotationDecl__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EAnnotationDecl__Group_2__0_in_rule__EAnnotationDecl__Group__23917);
                    rule__EAnnotationDecl__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEAnnotationDeclAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAnnotationDecl__Group__2


    // $ANTLR start rule__EAnnotationDecl__Group_2__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1884:1: rule__EAnnotationDecl__Group_2__0 : ( '(' ) rule__EAnnotationDecl__Group_2__1 ;
    public final void rule__EAnnotationDecl__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1888:1: ( ( '(' ) rule__EAnnotationDecl__Group_2__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1889:1: ( '(' ) rule__EAnnotationDecl__Group_2__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1889:1: ( '(' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1890:1: '('
            {
             before(grammarAccess.getEAnnotationDeclAccess().getLeftParenthesisKeyword_2_0()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__EAnnotationDecl__Group_2__03959); 
             after(grammarAccess.getEAnnotationDeclAccess().getLeftParenthesisKeyword_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EAnnotationDecl__Group_2__1_in_rule__EAnnotationDecl__Group_2__03969);
            rule__EAnnotationDecl__Group_2__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAnnotationDecl__Group_2__0


    // $ANTLR start rule__EAnnotationDecl__Group_2__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1904:1: rule__EAnnotationDecl__Group_2__1 : ( ( rule__EAnnotationDecl__DetailsAssignment_2_1 ) ) rule__EAnnotationDecl__Group_2__2 ;
    public final void rule__EAnnotationDecl__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1908:1: ( ( ( rule__EAnnotationDecl__DetailsAssignment_2_1 ) ) rule__EAnnotationDecl__Group_2__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1909:1: ( ( rule__EAnnotationDecl__DetailsAssignment_2_1 ) ) rule__EAnnotationDecl__Group_2__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1909:1: ( ( rule__EAnnotationDecl__DetailsAssignment_2_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1910:1: ( rule__EAnnotationDecl__DetailsAssignment_2_1 )
            {
             before(grammarAccess.getEAnnotationDeclAccess().getDetailsAssignment_2_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1911:1: ( rule__EAnnotationDecl__DetailsAssignment_2_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1911:2: rule__EAnnotationDecl__DetailsAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EAnnotationDecl__DetailsAssignment_2_1_in_rule__EAnnotationDecl__Group_2__13997);
            rule__EAnnotationDecl__DetailsAssignment_2_1();
            _fsp--;


            }

             after(grammarAccess.getEAnnotationDeclAccess().getDetailsAssignment_2_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EAnnotationDecl__Group_2__2_in_rule__EAnnotationDecl__Group_2__14006);
            rule__EAnnotationDecl__Group_2__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAnnotationDecl__Group_2__1


    // $ANTLR start rule__EAnnotationDecl__Group_2__2
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1922:1: rule__EAnnotationDecl__Group_2__2 : ( ( rule__EAnnotationDecl__Group_2_2__0 )* ) rule__EAnnotationDecl__Group_2__3 ;
    public final void rule__EAnnotationDecl__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1926:1: ( ( ( rule__EAnnotationDecl__Group_2_2__0 )* ) rule__EAnnotationDecl__Group_2__3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1927:1: ( ( rule__EAnnotationDecl__Group_2_2__0 )* ) rule__EAnnotationDecl__Group_2__3
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1927:1: ( ( rule__EAnnotationDecl__Group_2_2__0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1928:1: ( rule__EAnnotationDecl__Group_2_2__0 )*
            {
             before(grammarAccess.getEAnnotationDeclAccess().getGroup_2_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1929:1: ( rule__EAnnotationDecl__Group_2_2__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==34) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1929:2: rule__EAnnotationDecl__Group_2_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__EAnnotationDecl__Group_2_2__0_in_rule__EAnnotationDecl__Group_2__24034);
            	    rule__EAnnotationDecl__Group_2_2__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

             after(grammarAccess.getEAnnotationDeclAccess().getGroup_2_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EAnnotationDecl__Group_2__3_in_rule__EAnnotationDecl__Group_2__24044);
            rule__EAnnotationDecl__Group_2__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAnnotationDecl__Group_2__2


    // $ANTLR start rule__EAnnotationDecl__Group_2__3
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1940:1: rule__EAnnotationDecl__Group_2__3 : ( ')' ) ;
    public final void rule__EAnnotationDecl__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1944:1: ( ( ')' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1945:1: ( ')' )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1945:1: ( ')' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1946:1: ')'
            {
             before(grammarAccess.getEAnnotationDeclAccess().getRightParenthesisKeyword_2_3()); 
            match(input,33,FollowSets000.FOLLOW_33_in_rule__EAnnotationDecl__Group_2__34073); 
             after(grammarAccess.getEAnnotationDeclAccess().getRightParenthesisKeyword_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAnnotationDecl__Group_2__3


    // $ANTLR start rule__EAnnotationDecl__Group_2_2__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1967:1: rule__EAnnotationDecl__Group_2_2__0 : ( ',' ) rule__EAnnotationDecl__Group_2_2__1 ;
    public final void rule__EAnnotationDecl__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1971:1: ( ( ',' ) rule__EAnnotationDecl__Group_2_2__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1972:1: ( ',' ) rule__EAnnotationDecl__Group_2_2__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1972:1: ( ',' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1973:1: ','
            {
             before(grammarAccess.getEAnnotationDeclAccess().getCommaKeyword_2_2_0()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__EAnnotationDecl__Group_2_2__04117); 
             after(grammarAccess.getEAnnotationDeclAccess().getCommaKeyword_2_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EAnnotationDecl__Group_2_2__1_in_rule__EAnnotationDecl__Group_2_2__04127);
            rule__EAnnotationDecl__Group_2_2__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAnnotationDecl__Group_2_2__0


    // $ANTLR start rule__EAnnotationDecl__Group_2_2__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1987:1: rule__EAnnotationDecl__Group_2_2__1 : ( ( rule__EAnnotationDecl__DetailsAssignment_2_2_1 ) ) ;
    public final void rule__EAnnotationDecl__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1991:1: ( ( ( rule__EAnnotationDecl__DetailsAssignment_2_2_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1992:1: ( ( rule__EAnnotationDecl__DetailsAssignment_2_2_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1992:1: ( ( rule__EAnnotationDecl__DetailsAssignment_2_2_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1993:1: ( rule__EAnnotationDecl__DetailsAssignment_2_2_1 )
            {
             before(grammarAccess.getEAnnotationDeclAccess().getDetailsAssignment_2_2_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1994:1: ( rule__EAnnotationDecl__DetailsAssignment_2_2_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1994:2: rule__EAnnotationDecl__DetailsAssignment_2_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EAnnotationDecl__DetailsAssignment_2_2_1_in_rule__EAnnotationDecl__Group_2_2__14155);
            rule__EAnnotationDecl__DetailsAssignment_2_2_1();
            _fsp--;


            }

             after(grammarAccess.getEAnnotationDeclAccess().getDetailsAssignment_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAnnotationDecl__Group_2_2__1


    // $ANTLR start rule__EClassDecl__Group__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2008:1: rule__EClassDecl__Group__0 : ( ( rule__EClassDecl__EAnnotationsAssignment_0 )* ) rule__EClassDecl__Group__1 ;
    public final void rule__EClassDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2012:1: ( ( ( rule__EClassDecl__EAnnotationsAssignment_0 )* ) rule__EClassDecl__Group__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2013:1: ( ( rule__EClassDecl__EAnnotationsAssignment_0 )* ) rule__EClassDecl__Group__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2013:1: ( ( rule__EClassDecl__EAnnotationsAssignment_0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2014:1: ( rule__EClassDecl__EAnnotationsAssignment_0 )*
            {
             before(grammarAccess.getEClassDeclAccess().getEAnnotationsAssignment_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2015:1: ( rule__EClassDecl__EAnnotationsAssignment_0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==31) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2015:2: rule__EClassDecl__EAnnotationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__EClassDecl__EAnnotationsAssignment_0_in_rule__EClassDecl__Group__04193);
            	    rule__EClassDecl__EAnnotationsAssignment_0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

             after(grammarAccess.getEClassDeclAccess().getEAnnotationsAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EClassDecl__Group__1_in_rule__EClassDecl__Group__04203);
            rule__EClassDecl__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EClassDecl__Group__0


    // $ANTLR start rule__EClassDecl__Group__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2026:1: rule__EClassDecl__Group__1 : ( ( rule__EClassDecl__AbstractAssignment_1 )? ) rule__EClassDecl__Group__2 ;
    public final void rule__EClassDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2030:1: ( ( ( rule__EClassDecl__AbstractAssignment_1 )? ) rule__EClassDecl__Group__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2031:1: ( ( rule__EClassDecl__AbstractAssignment_1 )? ) rule__EClassDecl__Group__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2031:1: ( ( rule__EClassDecl__AbstractAssignment_1 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2032:1: ( rule__EClassDecl__AbstractAssignment_1 )?
            {
             before(grammarAccess.getEClassDeclAccess().getAbstractAssignment_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2033:1: ( rule__EClassDecl__AbstractAssignment_1 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==49) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2033:2: rule__EClassDecl__AbstractAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EClassDecl__AbstractAssignment_1_in_rule__EClassDecl__Group__14231);
                    rule__EClassDecl__AbstractAssignment_1();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEClassDeclAccess().getAbstractAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EClassDecl__Group__2_in_rule__EClassDecl__Group__14241);
            rule__EClassDecl__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EClassDecl__Group__1


    // $ANTLR start rule__EClassDecl__Group__2
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2044:1: rule__EClassDecl__Group__2 : ( ( rule__EClassDecl__Alternatives_2 ) ) rule__EClassDecl__Group__3 ;
    public final void rule__EClassDecl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2048:1: ( ( ( rule__EClassDecl__Alternatives_2 ) ) rule__EClassDecl__Group__3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2049:1: ( ( rule__EClassDecl__Alternatives_2 ) ) rule__EClassDecl__Group__3
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2049:1: ( ( rule__EClassDecl__Alternatives_2 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2050:1: ( rule__EClassDecl__Alternatives_2 )
            {
             before(grammarAccess.getEClassDeclAccess().getAlternatives_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2051:1: ( rule__EClassDecl__Alternatives_2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2051:2: rule__EClassDecl__Alternatives_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__EClassDecl__Alternatives_2_in_rule__EClassDecl__Group__24269);
            rule__EClassDecl__Alternatives_2();
            _fsp--;


            }

             after(grammarAccess.getEClassDeclAccess().getAlternatives_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EClassDecl__Group__3_in_rule__EClassDecl__Group__24278);
            rule__EClassDecl__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EClassDecl__Group__2


    // $ANTLR start rule__EClassDecl__Group__3
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2062:1: rule__EClassDecl__Group__3 : ( ( rule__EClassDecl__NameAssignment_3 ) ) rule__EClassDecl__Group__4 ;
    public final void rule__EClassDecl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2066:1: ( ( ( rule__EClassDecl__NameAssignment_3 ) ) rule__EClassDecl__Group__4 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2067:1: ( ( rule__EClassDecl__NameAssignment_3 ) ) rule__EClassDecl__Group__4
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2067:1: ( ( rule__EClassDecl__NameAssignment_3 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2068:1: ( rule__EClassDecl__NameAssignment_3 )
            {
             before(grammarAccess.getEClassDeclAccess().getNameAssignment_3()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2069:1: ( rule__EClassDecl__NameAssignment_3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2069:2: rule__EClassDecl__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__EClassDecl__NameAssignment_3_in_rule__EClassDecl__Group__34306);
            rule__EClassDecl__NameAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getEClassDeclAccess().getNameAssignment_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EClassDecl__Group__4_in_rule__EClassDecl__Group__34315);
            rule__EClassDecl__Group__4();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EClassDecl__Group__3


    // $ANTLR start rule__EClassDecl__Group__4
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2080:1: rule__EClassDecl__Group__4 : ( ( rule__EClassDecl__Group_4__0 )? ) rule__EClassDecl__Group__5 ;
    public final void rule__EClassDecl__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2084:1: ( ( ( rule__EClassDecl__Group_4__0 )? ) rule__EClassDecl__Group__5 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2085:1: ( ( rule__EClassDecl__Group_4__0 )? ) rule__EClassDecl__Group__5
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2085:1: ( ( rule__EClassDecl__Group_4__0 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2086:1: ( rule__EClassDecl__Group_4__0 )?
            {
             before(grammarAccess.getEClassDeclAccess().getGroup_4()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2087:1: ( rule__EClassDecl__Group_4__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==35) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2087:2: rule__EClassDecl__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EClassDecl__Group_4__0_in_rule__EClassDecl__Group__44343);
                    rule__EClassDecl__Group_4__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEClassDeclAccess().getGroup_4()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EClassDecl__Group__5_in_rule__EClassDecl__Group__44353);
            rule__EClassDecl__Group__5();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EClassDecl__Group__4


    // $ANTLR start rule__EClassDecl__Group__5
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2098:1: rule__EClassDecl__Group__5 : ( ( rule__EClassDecl__Group_5__0 )? ) rule__EClassDecl__Group__6 ;
    public final void rule__EClassDecl__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2102:1: ( ( ( rule__EClassDecl__Group_5__0 )? ) rule__EClassDecl__Group__6 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2103:1: ( ( rule__EClassDecl__Group_5__0 )? ) rule__EClassDecl__Group__6
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2103:1: ( ( rule__EClassDecl__Group_5__0 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2104:1: ( rule__EClassDecl__Group_5__0 )?
            {
             before(grammarAccess.getEClassDeclAccess().getGroup_5()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2105:1: ( rule__EClassDecl__Group_5__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==37) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2105:2: rule__EClassDecl__Group_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EClassDecl__Group_5__0_in_rule__EClassDecl__Group__54381);
                    rule__EClassDecl__Group_5__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEClassDeclAccess().getGroup_5()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EClassDecl__Group__6_in_rule__EClassDecl__Group__54391);
            rule__EClassDecl__Group__6();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EClassDecl__Group__5


    // $ANTLR start rule__EClassDecl__Group__6
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2116:1: rule__EClassDecl__Group__6 : ( ( rule__EClassDecl__Group_6__0 )? ) rule__EClassDecl__Group__7 ;
    public final void rule__EClassDecl__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2120:1: ( ( ( rule__EClassDecl__Group_6__0 )? ) rule__EClassDecl__Group__7 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2121:1: ( ( rule__EClassDecl__Group_6__0 )? ) rule__EClassDecl__Group__7
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2121:1: ( ( rule__EClassDecl__Group_6__0 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2122:1: ( rule__EClassDecl__Group_6__0 )?
            {
             before(grammarAccess.getEClassDeclAccess().getGroup_6()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2123:1: ( rule__EClassDecl__Group_6__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==30) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2123:2: rule__EClassDecl__Group_6__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EClassDecl__Group_6__0_in_rule__EClassDecl__Group__64419);
                    rule__EClassDecl__Group_6__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEClassDeclAccess().getGroup_6()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EClassDecl__Group__7_in_rule__EClassDecl__Group__64429);
            rule__EClassDecl__Group__7();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EClassDecl__Group__6


    // $ANTLR start rule__EClassDecl__Group__7
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2134:1: rule__EClassDecl__Group__7 : ( '{' ) rule__EClassDecl__Group__8 ;
    public final void rule__EClassDecl__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2138:1: ( ( '{' ) rule__EClassDecl__Group__8 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2139:1: ( '{' ) rule__EClassDecl__Group__8
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2139:1: ( '{' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2140:1: '{'
            {
             before(grammarAccess.getEClassDeclAccess().getLeftCurlyBracketKeyword_7()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__EClassDecl__Group__74458); 
             after(grammarAccess.getEClassDeclAccess().getLeftCurlyBracketKeyword_7()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EClassDecl__Group__8_in_rule__EClassDecl__Group__74468);
            rule__EClassDecl__Group__8();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EClassDecl__Group__7


    // $ANTLR start rule__EClassDecl__Group__8
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2154:1: rule__EClassDecl__Group__8 : ( ( rule__EClassDecl__Alternatives_8 )* ) rule__EClassDecl__Group__9 ;
    public final void rule__EClassDecl__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2158:1: ( ( ( rule__EClassDecl__Alternatives_8 )* ) rule__EClassDecl__Group__9 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2159:1: ( ( rule__EClassDecl__Alternatives_8 )* ) rule__EClassDecl__Group__9
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2159:1: ( ( rule__EClassDecl__Alternatives_8 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2160:1: ( rule__EClassDecl__Alternatives_8 )*
            {
             before(grammarAccess.getEClassDeclAccess().getAlternatives_8()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2161:1: ( rule__EClassDecl__Alternatives_8 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>=RULE_BAG && LA33_0<=RULE_LOCAL)||LA33_0==17||LA33_0==31||LA33_0==38||LA33_0==46||(LA33_0>=51 && LA33_0<=56)) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2161:2: rule__EClassDecl__Alternatives_8
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__EClassDecl__Alternatives_8_in_rule__EClassDecl__Group__84496);
            	    rule__EClassDecl__Alternatives_8();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

             after(grammarAccess.getEClassDeclAccess().getAlternatives_8()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EClassDecl__Group__9_in_rule__EClassDecl__Group__84506);
            rule__EClassDecl__Group__9();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EClassDecl__Group__8


    // $ANTLR start rule__EClassDecl__Group__9
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2172:1: rule__EClassDecl__Group__9 : ( '}' ) ;
    public final void rule__EClassDecl__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2176:1: ( ( '}' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2177:1: ( '}' )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2177:1: ( '}' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2178:1: '}'
            {
             before(grammarAccess.getEClassDeclAccess().getRightCurlyBracketKeyword_9()); 
            match(input,28,FollowSets000.FOLLOW_28_in_rule__EClassDecl__Group__94535); 
             after(grammarAccess.getEClassDeclAccess().getRightCurlyBracketKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EClassDecl__Group__9


    // $ANTLR start rule__EClassDecl__Group_4__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2211:1: rule__EClassDecl__Group_4__0 : ( '<' ) rule__EClassDecl__Group_4__1 ;
    public final void rule__EClassDecl__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2215:1: ( ( '<' ) rule__EClassDecl__Group_4__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2216:1: ( '<' ) rule__EClassDecl__Group_4__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2216:1: ( '<' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2217:1: '<'
            {
             before(grammarAccess.getEClassDeclAccess().getLessThanSignKeyword_4_0()); 
            match(input,35,FollowSets000.FOLLOW_35_in_rule__EClassDecl__Group_4__04591); 
             after(grammarAccess.getEClassDeclAccess().getLessThanSignKeyword_4_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EClassDecl__Group_4__1_in_rule__EClassDecl__Group_4__04601);
            rule__EClassDecl__Group_4__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EClassDecl__Group_4__0


    // $ANTLR start rule__EClassDecl__Group_4__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2231:1: rule__EClassDecl__Group_4__1 : ( ( rule__EClassDecl__ETypeParametersAssignment_4_1 ) ) rule__EClassDecl__Group_4__2 ;
    public final void rule__EClassDecl__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2235:1: ( ( ( rule__EClassDecl__ETypeParametersAssignment_4_1 ) ) rule__EClassDecl__Group_4__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2236:1: ( ( rule__EClassDecl__ETypeParametersAssignment_4_1 ) ) rule__EClassDecl__Group_4__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2236:1: ( ( rule__EClassDecl__ETypeParametersAssignment_4_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2237:1: ( rule__EClassDecl__ETypeParametersAssignment_4_1 )
            {
             before(grammarAccess.getEClassDeclAccess().getETypeParametersAssignment_4_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2238:1: ( rule__EClassDecl__ETypeParametersAssignment_4_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2238:2: rule__EClassDecl__ETypeParametersAssignment_4_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EClassDecl__ETypeParametersAssignment_4_1_in_rule__EClassDecl__Group_4__14629);
            rule__EClassDecl__ETypeParametersAssignment_4_1();
            _fsp--;


            }

             after(grammarAccess.getEClassDeclAccess().getETypeParametersAssignment_4_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EClassDecl__Group_4__2_in_rule__EClassDecl__Group_4__14638);
            rule__EClassDecl__Group_4__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EClassDecl__Group_4__1


    // $ANTLR start rule__EClassDecl__Group_4__2
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2249:1: rule__EClassDecl__Group_4__2 : ( ( rule__EClassDecl__Group_4_2__0 )* ) rule__EClassDecl__Group_4__3 ;
    public final void rule__EClassDecl__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2253:1: ( ( ( rule__EClassDecl__Group_4_2__0 )* ) rule__EClassDecl__Group_4__3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2254:1: ( ( rule__EClassDecl__Group_4_2__0 )* ) rule__EClassDecl__Group_4__3
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2254:1: ( ( rule__EClassDecl__Group_4_2__0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2255:1: ( rule__EClassDecl__Group_4_2__0 )*
            {
             before(grammarAccess.getEClassDeclAccess().getGroup_4_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2256:1: ( rule__EClassDecl__Group_4_2__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==34) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2256:2: rule__EClassDecl__Group_4_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__EClassDecl__Group_4_2__0_in_rule__EClassDecl__Group_4__24666);
            	    rule__EClassDecl__Group_4_2__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

             after(grammarAccess.getEClassDeclAccess().getGroup_4_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EClassDecl__Group_4__3_in_rule__EClassDecl__Group_4__24676);
            rule__EClassDecl__Group_4__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EClassDecl__Group_4__2


    // $ANTLR start rule__EClassDecl__Group_4__3
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2267:1: rule__EClassDecl__Group_4__3 : ( '>' ) ;
    public final void rule__EClassDecl__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2271:1: ( ( '>' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2272:1: ( '>' )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2272:1: ( '>' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2273:1: '>'
            {
             before(grammarAccess.getEClassDeclAccess().getGreaterThanSignKeyword_4_3()); 
            match(input,36,FollowSets000.FOLLOW_36_in_rule__EClassDecl__Group_4__34705); 
             after(grammarAccess.getEClassDeclAccess().getGreaterThanSignKeyword_4_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EClassDecl__Group_4__3


    // $ANTLR start rule__EClassDecl__Group_4_2__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2294:1: rule__EClassDecl__Group_4_2__0 : ( ',' ) rule__EClassDecl__Group_4_2__1 ;
    public final void rule__EClassDecl__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2298:1: ( ( ',' ) rule__EClassDecl__Group_4_2__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2299:1: ( ',' ) rule__EClassDecl__Group_4_2__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2299:1: ( ',' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2300:1: ','
            {
             before(grammarAccess.getEClassDeclAccess().getCommaKeyword_4_2_0()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__EClassDecl__Group_4_2__04749); 
             after(grammarAccess.getEClassDeclAccess().getCommaKeyword_4_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EClassDecl__Group_4_2__1_in_rule__EClassDecl__Group_4_2__04759);
            rule__EClassDecl__Group_4_2__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EClassDecl__Group_4_2__0


    // $ANTLR start rule__EClassDecl__Group_4_2__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2314:1: rule__EClassDecl__Group_4_2__1 : ( ( rule__EClassDecl__ETypeParametersAssignment_4_2_1 ) ) ;
    public final void rule__EClassDecl__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2318:1: ( ( ( rule__EClassDecl__ETypeParametersAssignment_4_2_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2319:1: ( ( rule__EClassDecl__ETypeParametersAssignment_4_2_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2319:1: ( ( rule__EClassDecl__ETypeParametersAssignment_4_2_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2320:1: ( rule__EClassDecl__ETypeParametersAssignment_4_2_1 )
            {
             before(grammarAccess.getEClassDeclAccess().getETypeParametersAssignment_4_2_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2321:1: ( rule__EClassDecl__ETypeParametersAssignment_4_2_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2321:2: rule__EClassDecl__ETypeParametersAssignment_4_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EClassDecl__ETypeParametersAssignment_4_2_1_in_rule__EClassDecl__Group_4_2__14787);
            rule__EClassDecl__ETypeParametersAssignment_4_2_1();
            _fsp--;


            }

             after(grammarAccess.getEClassDeclAccess().getETypeParametersAssignment_4_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EClassDecl__Group_4_2__1


    // $ANTLR start rule__EClassDecl__Group_5__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2335:1: rule__EClassDecl__Group_5__0 : ( 'extends' ) rule__EClassDecl__Group_5__1 ;
    public final void rule__EClassDecl__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2339:1: ( ( 'extends' ) rule__EClassDecl__Group_5__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2340:1: ( 'extends' ) rule__EClassDecl__Group_5__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2340:1: ( 'extends' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2341:1: 'extends'
            {
             before(grammarAccess.getEClassDeclAccess().getExtendsKeyword_5_0()); 
            match(input,37,FollowSets000.FOLLOW_37_in_rule__EClassDecl__Group_5__04826); 
             after(grammarAccess.getEClassDeclAccess().getExtendsKeyword_5_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EClassDecl__Group_5__1_in_rule__EClassDecl__Group_5__04836);
            rule__EClassDecl__Group_5__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EClassDecl__Group_5__0


    // $ANTLR start rule__EClassDecl__Group_5__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2355:1: rule__EClassDecl__Group_5__1 : ( ( rule__EClassDecl__EGenericSuperTypesAssignment_5_1 ) ) rule__EClassDecl__Group_5__2 ;
    public final void rule__EClassDecl__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2359:1: ( ( ( rule__EClassDecl__EGenericSuperTypesAssignment_5_1 ) ) rule__EClassDecl__Group_5__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2360:1: ( ( rule__EClassDecl__EGenericSuperTypesAssignment_5_1 ) ) rule__EClassDecl__Group_5__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2360:1: ( ( rule__EClassDecl__EGenericSuperTypesAssignment_5_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2361:1: ( rule__EClassDecl__EGenericSuperTypesAssignment_5_1 )
            {
             before(grammarAccess.getEClassDeclAccess().getEGenericSuperTypesAssignment_5_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2362:1: ( rule__EClassDecl__EGenericSuperTypesAssignment_5_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2362:2: rule__EClassDecl__EGenericSuperTypesAssignment_5_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EClassDecl__EGenericSuperTypesAssignment_5_1_in_rule__EClassDecl__Group_5__14864);
            rule__EClassDecl__EGenericSuperTypesAssignment_5_1();
            _fsp--;


            }

             after(grammarAccess.getEClassDeclAccess().getEGenericSuperTypesAssignment_5_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EClassDecl__Group_5__2_in_rule__EClassDecl__Group_5__14873);
            rule__EClassDecl__Group_5__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EClassDecl__Group_5__1


    // $ANTLR start rule__EClassDecl__Group_5__2
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2373:1: rule__EClassDecl__Group_5__2 : ( ( rule__EClassDecl__Group_5_2__0 )* ) ;
    public final void rule__EClassDecl__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2377:1: ( ( ( rule__EClassDecl__Group_5_2__0 )* ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2378:1: ( ( rule__EClassDecl__Group_5_2__0 )* )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2378:1: ( ( rule__EClassDecl__Group_5_2__0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2379:1: ( rule__EClassDecl__Group_5_2__0 )*
            {
             before(grammarAccess.getEClassDeclAccess().getGroup_5_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2380:1: ( rule__EClassDecl__Group_5_2__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==34) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2380:2: rule__EClassDecl__Group_5_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__EClassDecl__Group_5_2__0_in_rule__EClassDecl__Group_5__24901);
            	    rule__EClassDecl__Group_5_2__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

             after(grammarAccess.getEClassDeclAccess().getGroup_5_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EClassDecl__Group_5__2


    // $ANTLR start rule__EClassDecl__Group_5_2__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2396:1: rule__EClassDecl__Group_5_2__0 : ( ',' ) rule__EClassDecl__Group_5_2__1 ;
    public final void rule__EClassDecl__Group_5_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2400:1: ( ( ',' ) rule__EClassDecl__Group_5_2__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2401:1: ( ',' ) rule__EClassDecl__Group_5_2__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2401:1: ( ',' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2402:1: ','
            {
             before(grammarAccess.getEClassDeclAccess().getCommaKeyword_5_2_0()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__EClassDecl__Group_5_2__04943); 
             after(grammarAccess.getEClassDeclAccess().getCommaKeyword_5_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EClassDecl__Group_5_2__1_in_rule__EClassDecl__Group_5_2__04953);
            rule__EClassDecl__Group_5_2__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EClassDecl__Group_5_2__0


    // $ANTLR start rule__EClassDecl__Group_5_2__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2416:1: rule__EClassDecl__Group_5_2__1 : ( ( rule__EClassDecl__EGenericSuperTypesAssignment_5_2_1 ) ) ;
    public final void rule__EClassDecl__Group_5_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2420:1: ( ( ( rule__EClassDecl__EGenericSuperTypesAssignment_5_2_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2421:1: ( ( rule__EClassDecl__EGenericSuperTypesAssignment_5_2_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2421:1: ( ( rule__EClassDecl__EGenericSuperTypesAssignment_5_2_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2422:1: ( rule__EClassDecl__EGenericSuperTypesAssignment_5_2_1 )
            {
             before(grammarAccess.getEClassDeclAccess().getEGenericSuperTypesAssignment_5_2_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2423:1: ( rule__EClassDecl__EGenericSuperTypesAssignment_5_2_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2423:2: rule__EClassDecl__EGenericSuperTypesAssignment_5_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EClassDecl__EGenericSuperTypesAssignment_5_2_1_in_rule__EClassDecl__Group_5_2__14981);
            rule__EClassDecl__EGenericSuperTypesAssignment_5_2_1();
            _fsp--;


            }

             after(grammarAccess.getEClassDeclAccess().getEGenericSuperTypesAssignment_5_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EClassDecl__Group_5_2__1


    // $ANTLR start rule__EClassDecl__Group_6__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2437:1: rule__EClassDecl__Group_6__0 : ( ':' ) rule__EClassDecl__Group_6__1 ;
    public final void rule__EClassDecl__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2441:1: ( ( ':' ) rule__EClassDecl__Group_6__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2442:1: ( ':' ) rule__EClassDecl__Group_6__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2442:1: ( ':' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2443:1: ':'
            {
             before(grammarAccess.getEClassDeclAccess().getColonKeyword_6_0()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__EClassDecl__Group_6__05020); 
             after(grammarAccess.getEClassDeclAccess().getColonKeyword_6_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EClassDecl__Group_6__1_in_rule__EClassDecl__Group_6__05030);
            rule__EClassDecl__Group_6__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EClassDecl__Group_6__0


    // $ANTLR start rule__EClassDecl__Group_6__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2457:1: rule__EClassDecl__Group_6__1 : ( ( rule__EClassDecl__InstanceClassNameAssignment_6_1 ) ) ;
    public final void rule__EClassDecl__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2461:1: ( ( ( rule__EClassDecl__InstanceClassNameAssignment_6_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2462:1: ( ( rule__EClassDecl__InstanceClassNameAssignment_6_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2462:1: ( ( rule__EClassDecl__InstanceClassNameAssignment_6_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2463:1: ( rule__EClassDecl__InstanceClassNameAssignment_6_1 )
            {
             before(grammarAccess.getEClassDeclAccess().getInstanceClassNameAssignment_6_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2464:1: ( rule__EClassDecl__InstanceClassNameAssignment_6_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2464:2: rule__EClassDecl__InstanceClassNameAssignment_6_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EClassDecl__InstanceClassNameAssignment_6_1_in_rule__EClassDecl__Group_6__15058);
            rule__EClassDecl__InstanceClassNameAssignment_6_1();
            _fsp--;


            }

             after(grammarAccess.getEClassDeclAccess().getInstanceClassNameAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EClassDecl__Group_6__1


    // $ANTLR start rule__EAttributeDecl__Group__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2478:1: rule__EAttributeDecl__Group__0 : ( ( rule__EAttributeDecl__EAnnotationsAssignment_0 )* ) rule__EAttributeDecl__Group__1 ;
    public final void rule__EAttributeDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2482:1: ( ( ( rule__EAttributeDecl__EAnnotationsAssignment_0 )* ) rule__EAttributeDecl__Group__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2483:1: ( ( rule__EAttributeDecl__EAnnotationsAssignment_0 )* ) rule__EAttributeDecl__Group__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2483:1: ( ( rule__EAttributeDecl__EAnnotationsAssignment_0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2484:1: ( rule__EAttributeDecl__EAnnotationsAssignment_0 )*
            {
             before(grammarAccess.getEAttributeDeclAccess().getEAnnotationsAssignment_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2485:1: ( rule__EAttributeDecl__EAnnotationsAssignment_0 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==31) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2485:2: rule__EAttributeDecl__EAnnotationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__EAttributeDecl__EAnnotationsAssignment_0_in_rule__EAttributeDecl__Group__05096);
            	    rule__EAttributeDecl__EAnnotationsAssignment_0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

             after(grammarAccess.getEAttributeDeclAccess().getEAnnotationsAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EAttributeDecl__Group__1_in_rule__EAttributeDecl__Group__05106);
            rule__EAttributeDecl__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAttributeDecl__Group__0


    // $ANTLR start rule__EAttributeDecl__Group__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2496:1: rule__EAttributeDecl__Group__1 : ( ( rule__EAttributeDecl__Alternatives_1 )* ) rule__EAttributeDecl__Group__2 ;
    public final void rule__EAttributeDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2500:1: ( ( ( rule__EAttributeDecl__Alternatives_1 )* ) rule__EAttributeDecl__Group__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2501:1: ( ( rule__EAttributeDecl__Alternatives_1 )* ) rule__EAttributeDecl__Group__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2501:1: ( ( rule__EAttributeDecl__Alternatives_1 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2502:1: ( rule__EAttributeDecl__Alternatives_1 )*
            {
             before(grammarAccess.getEAttributeDeclAccess().getAlternatives_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2503:1: ( rule__EAttributeDecl__Alternatives_1 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( ((LA37_0>=RULE_BAG && LA37_0<=RULE_READONLY)||(LA37_0>=51 && LA37_0<=55)) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2503:2: rule__EAttributeDecl__Alternatives_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__EAttributeDecl__Alternatives_1_in_rule__EAttributeDecl__Group__15134);
            	    rule__EAttributeDecl__Alternatives_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

             after(grammarAccess.getEAttributeDeclAccess().getAlternatives_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EAttributeDecl__Group__2_in_rule__EAttributeDecl__Group__15144);
            rule__EAttributeDecl__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAttributeDecl__Group__1


    // $ANTLR start rule__EAttributeDecl__Group__2
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2514:1: rule__EAttributeDecl__Group__2 : ( 'attr' ) rule__EAttributeDecl__Group__3 ;
    public final void rule__EAttributeDecl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2518:1: ( ( 'attr' ) rule__EAttributeDecl__Group__3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2519:1: ( 'attr' ) rule__EAttributeDecl__Group__3
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2519:1: ( 'attr' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2520:1: 'attr'
            {
             before(grammarAccess.getEAttributeDeclAccess().getAttrKeyword_2()); 
            match(input,38,FollowSets000.FOLLOW_38_in_rule__EAttributeDecl__Group__25173); 
             after(grammarAccess.getEAttributeDeclAccess().getAttrKeyword_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EAttributeDecl__Group__3_in_rule__EAttributeDecl__Group__25183);
            rule__EAttributeDecl__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAttributeDecl__Group__2


    // $ANTLR start rule__EAttributeDecl__Group__3
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2534:1: rule__EAttributeDecl__Group__3 : ( ( rule__EAttributeDecl__EGenericTypeAssignment_3 ) ) rule__EAttributeDecl__Group__4 ;
    public final void rule__EAttributeDecl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2538:1: ( ( ( rule__EAttributeDecl__EGenericTypeAssignment_3 ) ) rule__EAttributeDecl__Group__4 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2539:1: ( ( rule__EAttributeDecl__EGenericTypeAssignment_3 ) ) rule__EAttributeDecl__Group__4
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2539:1: ( ( rule__EAttributeDecl__EGenericTypeAssignment_3 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2540:1: ( rule__EAttributeDecl__EGenericTypeAssignment_3 )
            {
             before(grammarAccess.getEAttributeDeclAccess().getEGenericTypeAssignment_3()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2541:1: ( rule__EAttributeDecl__EGenericTypeAssignment_3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2541:2: rule__EAttributeDecl__EGenericTypeAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__EAttributeDecl__EGenericTypeAssignment_3_in_rule__EAttributeDecl__Group__35211);
            rule__EAttributeDecl__EGenericTypeAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getEAttributeDeclAccess().getEGenericTypeAssignment_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EAttributeDecl__Group__4_in_rule__EAttributeDecl__Group__35220);
            rule__EAttributeDecl__Group__4();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAttributeDecl__Group__3


    // $ANTLR start rule__EAttributeDecl__Group__4
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2552:1: rule__EAttributeDecl__Group__4 : ( ( rule__EAttributeDecl__Group_4__0 )? ) rule__EAttributeDecl__Group__5 ;
    public final void rule__EAttributeDecl__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2556:1: ( ( ( rule__EAttributeDecl__Group_4__0 )? ) rule__EAttributeDecl__Group__5 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2557:1: ( ( rule__EAttributeDecl__Group_4__0 )? ) rule__EAttributeDecl__Group__5
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2557:1: ( ( rule__EAttributeDecl__Group_4__0 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2558:1: ( rule__EAttributeDecl__Group_4__0 )?
            {
             before(grammarAccess.getEAttributeDeclAccess().getGroup_4()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2559:1: ( rule__EAttributeDecl__Group_4__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==39) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2559:2: rule__EAttributeDecl__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EAttributeDecl__Group_4__0_in_rule__EAttributeDecl__Group__45248);
                    rule__EAttributeDecl__Group_4__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEAttributeDeclAccess().getGroup_4()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EAttributeDecl__Group__5_in_rule__EAttributeDecl__Group__45258);
            rule__EAttributeDecl__Group__5();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAttributeDecl__Group__4


    // $ANTLR start rule__EAttributeDecl__Group__5
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2570:1: rule__EAttributeDecl__Group__5 : ( ( rule__EAttributeDecl__NameAssignment_5 ) ) rule__EAttributeDecl__Group__6 ;
    public final void rule__EAttributeDecl__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2574:1: ( ( ( rule__EAttributeDecl__NameAssignment_5 ) ) rule__EAttributeDecl__Group__6 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2575:1: ( ( rule__EAttributeDecl__NameAssignment_5 ) ) rule__EAttributeDecl__Group__6
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2575:1: ( ( rule__EAttributeDecl__NameAssignment_5 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2576:1: ( rule__EAttributeDecl__NameAssignment_5 )
            {
             before(grammarAccess.getEAttributeDeclAccess().getNameAssignment_5()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2577:1: ( rule__EAttributeDecl__NameAssignment_5 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2577:2: rule__EAttributeDecl__NameAssignment_5
            {
            pushFollow(FollowSets000.FOLLOW_rule__EAttributeDecl__NameAssignment_5_in_rule__EAttributeDecl__Group__55286);
            rule__EAttributeDecl__NameAssignment_5();
            _fsp--;


            }

             after(grammarAccess.getEAttributeDeclAccess().getNameAssignment_5()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EAttributeDecl__Group__6_in_rule__EAttributeDecl__Group__55295);
            rule__EAttributeDecl__Group__6();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAttributeDecl__Group__5


    // $ANTLR start rule__EAttributeDecl__Group__6
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2588:1: rule__EAttributeDecl__Group__6 : ( ( rule__EAttributeDecl__Group_6__0 )? ) rule__EAttributeDecl__Group__7 ;
    public final void rule__EAttributeDecl__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2592:1: ( ( ( rule__EAttributeDecl__Group_6__0 )? ) rule__EAttributeDecl__Group__7 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2593:1: ( ( rule__EAttributeDecl__Group_6__0 )? ) rule__EAttributeDecl__Group__7
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2593:1: ( ( rule__EAttributeDecl__Group_6__0 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2594:1: ( rule__EAttributeDecl__Group_6__0 )?
            {
             before(grammarAccess.getEAttributeDeclAccess().getGroup_6()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2595:1: ( rule__EAttributeDecl__Group_6__0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==23) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2595:2: rule__EAttributeDecl__Group_6__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EAttributeDecl__Group_6__0_in_rule__EAttributeDecl__Group__65323);
                    rule__EAttributeDecl__Group_6__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEAttributeDeclAccess().getGroup_6()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EAttributeDecl__Group__7_in_rule__EAttributeDecl__Group__65333);
            rule__EAttributeDecl__Group__7();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAttributeDecl__Group__6


    // $ANTLR start rule__EAttributeDecl__Group__7
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2606:1: rule__EAttributeDecl__Group__7 : ( ';' ) ;
    public final void rule__EAttributeDecl__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2610:1: ( ( ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2611:1: ( ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2611:1: ( ';' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2612:1: ';'
            {
             before(grammarAccess.getEAttributeDeclAccess().getSemicolonKeyword_7()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__EAttributeDecl__Group__75362); 
             after(grammarAccess.getEAttributeDeclAccess().getSemicolonKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAttributeDecl__Group__7


    // $ANTLR start rule__EAttributeDecl__Group_4__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2641:1: rule__EAttributeDecl__Group_4__0 : ( '[' ) rule__EAttributeDecl__Group_4__1 ;
    public final void rule__EAttributeDecl__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2645:1: ( ( '[' ) rule__EAttributeDecl__Group_4__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2646:1: ( '[' ) rule__EAttributeDecl__Group_4__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2646:1: ( '[' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2647:1: '['
            {
             before(grammarAccess.getEAttributeDeclAccess().getLeftSquareBracketKeyword_4_0()); 
            match(input,39,FollowSets000.FOLLOW_39_in_rule__EAttributeDecl__Group_4__05414); 
             after(grammarAccess.getEAttributeDeclAccess().getLeftSquareBracketKeyword_4_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EAttributeDecl__Group_4__1_in_rule__EAttributeDecl__Group_4__05424);
            rule__EAttributeDecl__Group_4__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAttributeDecl__Group_4__0


    // $ANTLR start rule__EAttributeDecl__Group_4__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2661:1: rule__EAttributeDecl__Group_4__1 : ( ( rule__EAttributeDecl__LowerBoundAssignment_4_1 ) ) rule__EAttributeDecl__Group_4__2 ;
    public final void rule__EAttributeDecl__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2665:1: ( ( ( rule__EAttributeDecl__LowerBoundAssignment_4_1 ) ) rule__EAttributeDecl__Group_4__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2666:1: ( ( rule__EAttributeDecl__LowerBoundAssignment_4_1 ) ) rule__EAttributeDecl__Group_4__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2666:1: ( ( rule__EAttributeDecl__LowerBoundAssignment_4_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2667:1: ( rule__EAttributeDecl__LowerBoundAssignment_4_1 )
            {
             before(grammarAccess.getEAttributeDeclAccess().getLowerBoundAssignment_4_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2668:1: ( rule__EAttributeDecl__LowerBoundAssignment_4_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2668:2: rule__EAttributeDecl__LowerBoundAssignment_4_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EAttributeDecl__LowerBoundAssignment_4_1_in_rule__EAttributeDecl__Group_4__15452);
            rule__EAttributeDecl__LowerBoundAssignment_4_1();
            _fsp--;


            }

             after(grammarAccess.getEAttributeDeclAccess().getLowerBoundAssignment_4_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EAttributeDecl__Group_4__2_in_rule__EAttributeDecl__Group_4__15461);
            rule__EAttributeDecl__Group_4__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAttributeDecl__Group_4__1


    // $ANTLR start rule__EAttributeDecl__Group_4__2
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2679:1: rule__EAttributeDecl__Group_4__2 : ( ( rule__EAttributeDecl__Group_4_2__0 )? ) rule__EAttributeDecl__Group_4__3 ;
    public final void rule__EAttributeDecl__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2683:1: ( ( ( rule__EAttributeDecl__Group_4_2__0 )? ) rule__EAttributeDecl__Group_4__3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2684:1: ( ( rule__EAttributeDecl__Group_4_2__0 )? ) rule__EAttributeDecl__Group_4__3
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2684:1: ( ( rule__EAttributeDecl__Group_4_2__0 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2685:1: ( rule__EAttributeDecl__Group_4_2__0 )?
            {
             before(grammarAccess.getEAttributeDeclAccess().getGroup_4_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2686:1: ( rule__EAttributeDecl__Group_4_2__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==41) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2686:2: rule__EAttributeDecl__Group_4_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EAttributeDecl__Group_4_2__0_in_rule__EAttributeDecl__Group_4__25489);
                    rule__EAttributeDecl__Group_4_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEAttributeDeclAccess().getGroup_4_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EAttributeDecl__Group_4__3_in_rule__EAttributeDecl__Group_4__25499);
            rule__EAttributeDecl__Group_4__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAttributeDecl__Group_4__2


    // $ANTLR start rule__EAttributeDecl__Group_4__3
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2697:1: rule__EAttributeDecl__Group_4__3 : ( ']' ) ;
    public final void rule__EAttributeDecl__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2701:1: ( ( ']' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2702:1: ( ']' )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2702:1: ( ']' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2703:1: ']'
            {
             before(grammarAccess.getEAttributeDeclAccess().getRightSquareBracketKeyword_4_3()); 
            match(input,40,FollowSets000.FOLLOW_40_in_rule__EAttributeDecl__Group_4__35528); 
             after(grammarAccess.getEAttributeDeclAccess().getRightSquareBracketKeyword_4_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAttributeDecl__Group_4__3


    // $ANTLR start rule__EAttributeDecl__Group_4_2__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2724:1: rule__EAttributeDecl__Group_4_2__0 : ( '..' ) rule__EAttributeDecl__Group_4_2__1 ;
    public final void rule__EAttributeDecl__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2728:1: ( ( '..' ) rule__EAttributeDecl__Group_4_2__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2729:1: ( '..' ) rule__EAttributeDecl__Group_4_2__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2729:1: ( '..' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2730:1: '..'
            {
             before(grammarAccess.getEAttributeDeclAccess().getFullStopFullStopKeyword_4_2_0()); 
            match(input,41,FollowSets000.FOLLOW_41_in_rule__EAttributeDecl__Group_4_2__05572); 
             after(grammarAccess.getEAttributeDeclAccess().getFullStopFullStopKeyword_4_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EAttributeDecl__Group_4_2__1_in_rule__EAttributeDecl__Group_4_2__05582);
            rule__EAttributeDecl__Group_4_2__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAttributeDecl__Group_4_2__0


    // $ANTLR start rule__EAttributeDecl__Group_4_2__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2744:1: rule__EAttributeDecl__Group_4_2__1 : ( ( rule__EAttributeDecl__UpperBoundAssignment_4_2_1 ) ) ;
    public final void rule__EAttributeDecl__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2748:1: ( ( ( rule__EAttributeDecl__UpperBoundAssignment_4_2_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2749:1: ( ( rule__EAttributeDecl__UpperBoundAssignment_4_2_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2749:1: ( ( rule__EAttributeDecl__UpperBoundAssignment_4_2_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2750:1: ( rule__EAttributeDecl__UpperBoundAssignment_4_2_1 )
            {
             before(grammarAccess.getEAttributeDeclAccess().getUpperBoundAssignment_4_2_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2751:1: ( rule__EAttributeDecl__UpperBoundAssignment_4_2_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2751:2: rule__EAttributeDecl__UpperBoundAssignment_4_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EAttributeDecl__UpperBoundAssignment_4_2_1_in_rule__EAttributeDecl__Group_4_2__15610);
            rule__EAttributeDecl__UpperBoundAssignment_4_2_1();
            _fsp--;


            }

             after(grammarAccess.getEAttributeDeclAccess().getUpperBoundAssignment_4_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAttributeDecl__Group_4_2__1


    // $ANTLR start rule__EAttributeDecl__Group_6__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2765:1: rule__EAttributeDecl__Group_6__0 : ( '=' ) rule__EAttributeDecl__Group_6__1 ;
    public final void rule__EAttributeDecl__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2769:1: ( ( '=' ) rule__EAttributeDecl__Group_6__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2770:1: ( '=' ) rule__EAttributeDecl__Group_6__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2770:1: ( '=' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2771:1: '='
            {
             before(grammarAccess.getEAttributeDeclAccess().getEqualsSignKeyword_6_0()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__EAttributeDecl__Group_6__05649); 
             after(grammarAccess.getEAttributeDeclAccess().getEqualsSignKeyword_6_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EAttributeDecl__Group_6__1_in_rule__EAttributeDecl__Group_6__05659);
            rule__EAttributeDecl__Group_6__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAttributeDecl__Group_6__0


    // $ANTLR start rule__EAttributeDecl__Group_6__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2785:1: rule__EAttributeDecl__Group_6__1 : ( ( rule__EAttributeDecl__DefaultValueLiteralAssignment_6_1 ) ) ;
    public final void rule__EAttributeDecl__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2789:1: ( ( ( rule__EAttributeDecl__DefaultValueLiteralAssignment_6_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2790:1: ( ( rule__EAttributeDecl__DefaultValueLiteralAssignment_6_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2790:1: ( ( rule__EAttributeDecl__DefaultValueLiteralAssignment_6_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2791:1: ( rule__EAttributeDecl__DefaultValueLiteralAssignment_6_1 )
            {
             before(grammarAccess.getEAttributeDeclAccess().getDefaultValueLiteralAssignment_6_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2792:1: ( rule__EAttributeDecl__DefaultValueLiteralAssignment_6_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2792:2: rule__EAttributeDecl__DefaultValueLiteralAssignment_6_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EAttributeDecl__DefaultValueLiteralAssignment_6_1_in_rule__EAttributeDecl__Group_6__15687);
            rule__EAttributeDecl__DefaultValueLiteralAssignment_6_1();
            _fsp--;


            }

             after(grammarAccess.getEAttributeDeclAccess().getDefaultValueLiteralAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAttributeDecl__Group_6__1


    // $ANTLR start rule__EReferenceDecl__Group__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2806:1: rule__EReferenceDecl__Group__0 : ( ( rule__EReferenceDecl__EAnnotationsAssignment_0 )* ) rule__EReferenceDecl__Group__1 ;
    public final void rule__EReferenceDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2810:1: ( ( ( rule__EReferenceDecl__EAnnotationsAssignment_0 )* ) rule__EReferenceDecl__Group__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2811:1: ( ( rule__EReferenceDecl__EAnnotationsAssignment_0 )* ) rule__EReferenceDecl__Group__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2811:1: ( ( rule__EReferenceDecl__EAnnotationsAssignment_0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2812:1: ( rule__EReferenceDecl__EAnnotationsAssignment_0 )*
            {
             before(grammarAccess.getEReferenceDeclAccess().getEAnnotationsAssignment_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2813:1: ( rule__EReferenceDecl__EAnnotationsAssignment_0 )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==31) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2813:2: rule__EReferenceDecl__EAnnotationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__EReferenceDecl__EAnnotationsAssignment_0_in_rule__EReferenceDecl__Group__05725);
            	    rule__EReferenceDecl__EAnnotationsAssignment_0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

             after(grammarAccess.getEReferenceDeclAccess().getEAnnotationsAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EReferenceDecl__Group__1_in_rule__EReferenceDecl__Group__05735);
            rule__EReferenceDecl__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EReferenceDecl__Group__0


    // $ANTLR start rule__EReferenceDecl__Group__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2824:1: rule__EReferenceDecl__Group__1 : ( ( rule__EReferenceDecl__Alternatives_1 )* ) rule__EReferenceDecl__Group__2 ;
    public final void rule__EReferenceDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2828:1: ( ( ( rule__EReferenceDecl__Alternatives_1 )* ) rule__EReferenceDecl__Group__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2829:1: ( ( rule__EReferenceDecl__Alternatives_1 )* ) rule__EReferenceDecl__Group__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2829:1: ( ( rule__EReferenceDecl__Alternatives_1 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2830:1: ( rule__EReferenceDecl__Alternatives_1 )*
            {
             before(grammarAccess.getEReferenceDeclAccess().getAlternatives_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2831:1: ( rule__EReferenceDecl__Alternatives_1 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( ((LA42_0>=RULE_BAG && LA42_0<=RULE_LOCAL)||(LA42_0>=52 && LA42_0<=55)) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2831:2: rule__EReferenceDecl__Alternatives_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__EReferenceDecl__Alternatives_1_in_rule__EReferenceDecl__Group__15763);
            	    rule__EReferenceDecl__Alternatives_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

             after(grammarAccess.getEReferenceDeclAccess().getAlternatives_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EReferenceDecl__Group__2_in_rule__EReferenceDecl__Group__15773);
            rule__EReferenceDecl__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EReferenceDecl__Group__1


    // $ANTLR start rule__EReferenceDecl__Group__2
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2842:1: rule__EReferenceDecl__Group__2 : ( ( rule__EReferenceDecl__Alternatives_2 ) ) rule__EReferenceDecl__Group__3 ;
    public final void rule__EReferenceDecl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2846:1: ( ( ( rule__EReferenceDecl__Alternatives_2 ) ) rule__EReferenceDecl__Group__3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2847:1: ( ( rule__EReferenceDecl__Alternatives_2 ) ) rule__EReferenceDecl__Group__3
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2847:1: ( ( rule__EReferenceDecl__Alternatives_2 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2848:1: ( rule__EReferenceDecl__Alternatives_2 )
            {
             before(grammarAccess.getEReferenceDeclAccess().getAlternatives_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2849:1: ( rule__EReferenceDecl__Alternatives_2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2849:2: rule__EReferenceDecl__Alternatives_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__EReferenceDecl__Alternatives_2_in_rule__EReferenceDecl__Group__25801);
            rule__EReferenceDecl__Alternatives_2();
            _fsp--;


            }

             after(grammarAccess.getEReferenceDeclAccess().getAlternatives_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EReferenceDecl__Group__3_in_rule__EReferenceDecl__Group__25810);
            rule__EReferenceDecl__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EReferenceDecl__Group__2


    // $ANTLR start rule__EReferenceDecl__Group__3
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2860:1: rule__EReferenceDecl__Group__3 : ( ( rule__EReferenceDecl__EGenericTypeAssignment_3 ) ) rule__EReferenceDecl__Group__4 ;
    public final void rule__EReferenceDecl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2864:1: ( ( ( rule__EReferenceDecl__EGenericTypeAssignment_3 ) ) rule__EReferenceDecl__Group__4 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2865:1: ( ( rule__EReferenceDecl__EGenericTypeAssignment_3 ) ) rule__EReferenceDecl__Group__4
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2865:1: ( ( rule__EReferenceDecl__EGenericTypeAssignment_3 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2866:1: ( rule__EReferenceDecl__EGenericTypeAssignment_3 )
            {
             before(grammarAccess.getEReferenceDeclAccess().getEGenericTypeAssignment_3()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2867:1: ( rule__EReferenceDecl__EGenericTypeAssignment_3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2867:2: rule__EReferenceDecl__EGenericTypeAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__EReferenceDecl__EGenericTypeAssignment_3_in_rule__EReferenceDecl__Group__35838);
            rule__EReferenceDecl__EGenericTypeAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getEReferenceDeclAccess().getEGenericTypeAssignment_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EReferenceDecl__Group__4_in_rule__EReferenceDecl__Group__35847);
            rule__EReferenceDecl__Group__4();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EReferenceDecl__Group__3


    // $ANTLR start rule__EReferenceDecl__Group__4
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2878:1: rule__EReferenceDecl__Group__4 : ( ( rule__EReferenceDecl__Group_4__0 )? ) rule__EReferenceDecl__Group__5 ;
    public final void rule__EReferenceDecl__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2882:1: ( ( ( rule__EReferenceDecl__Group_4__0 )? ) rule__EReferenceDecl__Group__5 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2883:1: ( ( rule__EReferenceDecl__Group_4__0 )? ) rule__EReferenceDecl__Group__5
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2883:1: ( ( rule__EReferenceDecl__Group_4__0 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2884:1: ( rule__EReferenceDecl__Group_4__0 )?
            {
             before(grammarAccess.getEReferenceDeclAccess().getGroup_4()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2885:1: ( rule__EReferenceDecl__Group_4__0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==39) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2885:2: rule__EReferenceDecl__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EReferenceDecl__Group_4__0_in_rule__EReferenceDecl__Group__45875);
                    rule__EReferenceDecl__Group_4__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEReferenceDeclAccess().getGroup_4()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EReferenceDecl__Group__5_in_rule__EReferenceDecl__Group__45885);
            rule__EReferenceDecl__Group__5();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EReferenceDecl__Group__4


    // $ANTLR start rule__EReferenceDecl__Group__5
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2896:1: rule__EReferenceDecl__Group__5 : ( ( rule__EReferenceDecl__Group_5__0 )? ) rule__EReferenceDecl__Group__6 ;
    public final void rule__EReferenceDecl__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2900:1: ( ( ( rule__EReferenceDecl__Group_5__0 )? ) rule__EReferenceDecl__Group__6 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2901:1: ( ( rule__EReferenceDecl__Group_5__0 )? ) rule__EReferenceDecl__Group__6
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2901:1: ( ( rule__EReferenceDecl__Group_5__0 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2902:1: ( rule__EReferenceDecl__Group_5__0 )?
            {
             before(grammarAccess.getEReferenceDeclAccess().getGroup_5()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2903:1: ( rule__EReferenceDecl__Group_5__0 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==42) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2903:2: rule__EReferenceDecl__Group_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EReferenceDecl__Group_5__0_in_rule__EReferenceDecl__Group__55913);
                    rule__EReferenceDecl__Group_5__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEReferenceDeclAccess().getGroup_5()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EReferenceDecl__Group__6_in_rule__EReferenceDecl__Group__55923);
            rule__EReferenceDecl__Group__6();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EReferenceDecl__Group__5


    // $ANTLR start rule__EReferenceDecl__Group__6
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2914:1: rule__EReferenceDecl__Group__6 : ( ( rule__EReferenceDecl__NameAssignment_6 ) ) rule__EReferenceDecl__Group__7 ;
    public final void rule__EReferenceDecl__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2918:1: ( ( ( rule__EReferenceDecl__NameAssignment_6 ) ) rule__EReferenceDecl__Group__7 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2919:1: ( ( rule__EReferenceDecl__NameAssignment_6 ) ) rule__EReferenceDecl__Group__7
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2919:1: ( ( rule__EReferenceDecl__NameAssignment_6 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2920:1: ( rule__EReferenceDecl__NameAssignment_6 )
            {
             before(grammarAccess.getEReferenceDeclAccess().getNameAssignment_6()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2921:1: ( rule__EReferenceDecl__NameAssignment_6 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2921:2: rule__EReferenceDecl__NameAssignment_6
            {
            pushFollow(FollowSets000.FOLLOW_rule__EReferenceDecl__NameAssignment_6_in_rule__EReferenceDecl__Group__65951);
            rule__EReferenceDecl__NameAssignment_6();
            _fsp--;


            }

             after(grammarAccess.getEReferenceDeclAccess().getNameAssignment_6()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EReferenceDecl__Group__7_in_rule__EReferenceDecl__Group__65960);
            rule__EReferenceDecl__Group__7();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EReferenceDecl__Group__6


    // $ANTLR start rule__EReferenceDecl__Group__7
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2932:1: rule__EReferenceDecl__Group__7 : ( ';' ) ;
    public final void rule__EReferenceDecl__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2936:1: ( ( ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2937:1: ( ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2937:1: ( ';' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2938:1: ';'
            {
             before(grammarAccess.getEReferenceDeclAccess().getSemicolonKeyword_7()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__EReferenceDecl__Group__75989); 
             after(grammarAccess.getEReferenceDeclAccess().getSemicolonKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EReferenceDecl__Group__7


    // $ANTLR start rule__EReferenceDecl__Group_4__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2967:1: rule__EReferenceDecl__Group_4__0 : ( '[' ) rule__EReferenceDecl__Group_4__1 ;
    public final void rule__EReferenceDecl__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2971:1: ( ( '[' ) rule__EReferenceDecl__Group_4__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2972:1: ( '[' ) rule__EReferenceDecl__Group_4__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2972:1: ( '[' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2973:1: '['
            {
             before(grammarAccess.getEReferenceDeclAccess().getLeftSquareBracketKeyword_4_0()); 
            match(input,39,FollowSets000.FOLLOW_39_in_rule__EReferenceDecl__Group_4__06041); 
             after(grammarAccess.getEReferenceDeclAccess().getLeftSquareBracketKeyword_4_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EReferenceDecl__Group_4__1_in_rule__EReferenceDecl__Group_4__06051);
            rule__EReferenceDecl__Group_4__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EReferenceDecl__Group_4__0


    // $ANTLR start rule__EReferenceDecl__Group_4__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2987:1: rule__EReferenceDecl__Group_4__1 : ( ( rule__EReferenceDecl__LowerBoundAssignment_4_1 ) ) rule__EReferenceDecl__Group_4__2 ;
    public final void rule__EReferenceDecl__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2991:1: ( ( ( rule__EReferenceDecl__LowerBoundAssignment_4_1 ) ) rule__EReferenceDecl__Group_4__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2992:1: ( ( rule__EReferenceDecl__LowerBoundAssignment_4_1 ) ) rule__EReferenceDecl__Group_4__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2992:1: ( ( rule__EReferenceDecl__LowerBoundAssignment_4_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2993:1: ( rule__EReferenceDecl__LowerBoundAssignment_4_1 )
            {
             before(grammarAccess.getEReferenceDeclAccess().getLowerBoundAssignment_4_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2994:1: ( rule__EReferenceDecl__LowerBoundAssignment_4_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:2994:2: rule__EReferenceDecl__LowerBoundAssignment_4_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EReferenceDecl__LowerBoundAssignment_4_1_in_rule__EReferenceDecl__Group_4__16079);
            rule__EReferenceDecl__LowerBoundAssignment_4_1();
            _fsp--;


            }

             after(grammarAccess.getEReferenceDeclAccess().getLowerBoundAssignment_4_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EReferenceDecl__Group_4__2_in_rule__EReferenceDecl__Group_4__16088);
            rule__EReferenceDecl__Group_4__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EReferenceDecl__Group_4__1


    // $ANTLR start rule__EReferenceDecl__Group_4__2
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3005:1: rule__EReferenceDecl__Group_4__2 : ( ( rule__EReferenceDecl__Group_4_2__0 )? ) rule__EReferenceDecl__Group_4__3 ;
    public final void rule__EReferenceDecl__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3009:1: ( ( ( rule__EReferenceDecl__Group_4_2__0 )? ) rule__EReferenceDecl__Group_4__3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3010:1: ( ( rule__EReferenceDecl__Group_4_2__0 )? ) rule__EReferenceDecl__Group_4__3
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3010:1: ( ( rule__EReferenceDecl__Group_4_2__0 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3011:1: ( rule__EReferenceDecl__Group_4_2__0 )?
            {
             before(grammarAccess.getEReferenceDeclAccess().getGroup_4_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3012:1: ( rule__EReferenceDecl__Group_4_2__0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==41) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3012:2: rule__EReferenceDecl__Group_4_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EReferenceDecl__Group_4_2__0_in_rule__EReferenceDecl__Group_4__26116);
                    rule__EReferenceDecl__Group_4_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEReferenceDeclAccess().getGroup_4_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EReferenceDecl__Group_4__3_in_rule__EReferenceDecl__Group_4__26126);
            rule__EReferenceDecl__Group_4__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EReferenceDecl__Group_4__2


    // $ANTLR start rule__EReferenceDecl__Group_4__3
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3023:1: rule__EReferenceDecl__Group_4__3 : ( ']' ) ;
    public final void rule__EReferenceDecl__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3027:1: ( ( ']' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3028:1: ( ']' )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3028:1: ( ']' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3029:1: ']'
            {
             before(grammarAccess.getEReferenceDeclAccess().getRightSquareBracketKeyword_4_3()); 
            match(input,40,FollowSets000.FOLLOW_40_in_rule__EReferenceDecl__Group_4__36155); 
             after(grammarAccess.getEReferenceDeclAccess().getRightSquareBracketKeyword_4_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EReferenceDecl__Group_4__3


    // $ANTLR start rule__EReferenceDecl__Group_4_2__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3050:1: rule__EReferenceDecl__Group_4_2__0 : ( '..' ) rule__EReferenceDecl__Group_4_2__1 ;
    public final void rule__EReferenceDecl__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3054:1: ( ( '..' ) rule__EReferenceDecl__Group_4_2__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3055:1: ( '..' ) rule__EReferenceDecl__Group_4_2__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3055:1: ( '..' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3056:1: '..'
            {
             before(grammarAccess.getEReferenceDeclAccess().getFullStopFullStopKeyword_4_2_0()); 
            match(input,41,FollowSets000.FOLLOW_41_in_rule__EReferenceDecl__Group_4_2__06199); 
             after(grammarAccess.getEReferenceDeclAccess().getFullStopFullStopKeyword_4_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EReferenceDecl__Group_4_2__1_in_rule__EReferenceDecl__Group_4_2__06209);
            rule__EReferenceDecl__Group_4_2__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EReferenceDecl__Group_4_2__0


    // $ANTLR start rule__EReferenceDecl__Group_4_2__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3070:1: rule__EReferenceDecl__Group_4_2__1 : ( ( rule__EReferenceDecl__UpperBoundAssignment_4_2_1 ) ) ;
    public final void rule__EReferenceDecl__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3074:1: ( ( ( rule__EReferenceDecl__UpperBoundAssignment_4_2_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3075:1: ( ( rule__EReferenceDecl__UpperBoundAssignment_4_2_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3075:1: ( ( rule__EReferenceDecl__UpperBoundAssignment_4_2_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3076:1: ( rule__EReferenceDecl__UpperBoundAssignment_4_2_1 )
            {
             before(grammarAccess.getEReferenceDeclAccess().getUpperBoundAssignment_4_2_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3077:1: ( rule__EReferenceDecl__UpperBoundAssignment_4_2_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3077:2: rule__EReferenceDecl__UpperBoundAssignment_4_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EReferenceDecl__UpperBoundAssignment_4_2_1_in_rule__EReferenceDecl__Group_4_2__16237);
            rule__EReferenceDecl__UpperBoundAssignment_4_2_1();
            _fsp--;


            }

             after(grammarAccess.getEReferenceDeclAccess().getUpperBoundAssignment_4_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EReferenceDecl__Group_4_2__1


    // $ANTLR start rule__EReferenceDecl__Group_5__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3091:1: rule__EReferenceDecl__Group_5__0 : ( '#' ) rule__EReferenceDecl__Group_5__1 ;
    public final void rule__EReferenceDecl__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3095:1: ( ( '#' ) rule__EReferenceDecl__Group_5__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3096:1: ( '#' ) rule__EReferenceDecl__Group_5__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3096:1: ( '#' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3097:1: '#'
            {
             before(grammarAccess.getEReferenceDeclAccess().getNumberSignKeyword_5_0()); 
            match(input,42,FollowSets000.FOLLOW_42_in_rule__EReferenceDecl__Group_5__06276); 
             after(grammarAccess.getEReferenceDeclAccess().getNumberSignKeyword_5_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EReferenceDecl__Group_5__1_in_rule__EReferenceDecl__Group_5__06286);
            rule__EReferenceDecl__Group_5__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EReferenceDecl__Group_5__0


    // $ANTLR start rule__EReferenceDecl__Group_5__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3111:1: rule__EReferenceDecl__Group_5__1 : ( ( rule__EReferenceDecl__EOppositeAssignment_5_1 ) ) ;
    public final void rule__EReferenceDecl__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3115:1: ( ( ( rule__EReferenceDecl__EOppositeAssignment_5_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3116:1: ( ( rule__EReferenceDecl__EOppositeAssignment_5_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3116:1: ( ( rule__EReferenceDecl__EOppositeAssignment_5_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3117:1: ( rule__EReferenceDecl__EOppositeAssignment_5_1 )
            {
             before(grammarAccess.getEReferenceDeclAccess().getEOppositeAssignment_5_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3118:1: ( rule__EReferenceDecl__EOppositeAssignment_5_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3118:2: rule__EReferenceDecl__EOppositeAssignment_5_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EReferenceDecl__EOppositeAssignment_5_1_in_rule__EReferenceDecl__Group_5__16314);
            rule__EReferenceDecl__EOppositeAssignment_5_1();
            _fsp--;


            }

             after(grammarAccess.getEReferenceDeclAccess().getEOppositeAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EReferenceDecl__Group_5__1


    // $ANTLR start rule__EEnumDecl__Group__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3132:1: rule__EEnumDecl__Group__0 : ( ( rule__EEnumDecl__EAnnotationsAssignment_0 )* ) rule__EEnumDecl__Group__1 ;
    public final void rule__EEnumDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3136:1: ( ( ( rule__EEnumDecl__EAnnotationsAssignment_0 )* ) rule__EEnumDecl__Group__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3137:1: ( ( rule__EEnumDecl__EAnnotationsAssignment_0 )* ) rule__EEnumDecl__Group__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3137:1: ( ( rule__EEnumDecl__EAnnotationsAssignment_0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3138:1: ( rule__EEnumDecl__EAnnotationsAssignment_0 )*
            {
             before(grammarAccess.getEEnumDeclAccess().getEAnnotationsAssignment_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3139:1: ( rule__EEnumDecl__EAnnotationsAssignment_0 )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==31) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3139:2: rule__EEnumDecl__EAnnotationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__EEnumDecl__EAnnotationsAssignment_0_in_rule__EEnumDecl__Group__06352);
            	    rule__EEnumDecl__EAnnotationsAssignment_0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

             after(grammarAccess.getEEnumDeclAccess().getEAnnotationsAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EEnumDecl__Group__1_in_rule__EEnumDecl__Group__06362);
            rule__EEnumDecl__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EEnumDecl__Group__0


    // $ANTLR start rule__EEnumDecl__Group__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3150:1: rule__EEnumDecl__Group__1 : ( 'enum' ) rule__EEnumDecl__Group__2 ;
    public final void rule__EEnumDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3154:1: ( ( 'enum' ) rule__EEnumDecl__Group__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3155:1: ( 'enum' ) rule__EEnumDecl__Group__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3155:1: ( 'enum' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3156:1: 'enum'
            {
             before(grammarAccess.getEEnumDeclAccess().getEnumKeyword_1()); 
            match(input,43,FollowSets000.FOLLOW_43_in_rule__EEnumDecl__Group__16391); 
             after(grammarAccess.getEEnumDeclAccess().getEnumKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EEnumDecl__Group__2_in_rule__EEnumDecl__Group__16401);
            rule__EEnumDecl__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EEnumDecl__Group__1


    // $ANTLR start rule__EEnumDecl__Group__2
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3170:1: rule__EEnumDecl__Group__2 : ( ( rule__EEnumDecl__NameAssignment_2 ) ) rule__EEnumDecl__Group__3 ;
    public final void rule__EEnumDecl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3174:1: ( ( ( rule__EEnumDecl__NameAssignment_2 ) ) rule__EEnumDecl__Group__3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3175:1: ( ( rule__EEnumDecl__NameAssignment_2 ) ) rule__EEnumDecl__Group__3
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3175:1: ( ( rule__EEnumDecl__NameAssignment_2 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3176:1: ( rule__EEnumDecl__NameAssignment_2 )
            {
             before(grammarAccess.getEEnumDeclAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3177:1: ( rule__EEnumDecl__NameAssignment_2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3177:2: rule__EEnumDecl__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__EEnumDecl__NameAssignment_2_in_rule__EEnumDecl__Group__26429);
            rule__EEnumDecl__NameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getEEnumDeclAccess().getNameAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EEnumDecl__Group__3_in_rule__EEnumDecl__Group__26438);
            rule__EEnumDecl__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EEnumDecl__Group__2


    // $ANTLR start rule__EEnumDecl__Group__3
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3188:1: rule__EEnumDecl__Group__3 : ( '{' ) rule__EEnumDecl__Group__4 ;
    public final void rule__EEnumDecl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3192:1: ( ( '{' ) rule__EEnumDecl__Group__4 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3193:1: ( '{' ) rule__EEnumDecl__Group__4
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3193:1: ( '{' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3194:1: '{'
            {
             before(grammarAccess.getEEnumDeclAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__EEnumDecl__Group__36467); 
             after(grammarAccess.getEEnumDeclAccess().getLeftCurlyBracketKeyword_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EEnumDecl__Group__4_in_rule__EEnumDecl__Group__36477);
            rule__EEnumDecl__Group__4();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EEnumDecl__Group__3


    // $ANTLR start rule__EEnumDecl__Group__4
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3208:1: rule__EEnumDecl__Group__4 : ( ( ( rule__EEnumDecl__ELiteralsAssignment_4 ) ) ( ( rule__EEnumDecl__ELiteralsAssignment_4 )* ) ) rule__EEnumDecl__Group__5 ;
    public final void rule__EEnumDecl__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3212:1: ( ( ( ( rule__EEnumDecl__ELiteralsAssignment_4 ) ) ( ( rule__EEnumDecl__ELiteralsAssignment_4 )* ) ) rule__EEnumDecl__Group__5 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3213:1: ( ( ( rule__EEnumDecl__ELiteralsAssignment_4 ) ) ( ( rule__EEnumDecl__ELiteralsAssignment_4 )* ) ) rule__EEnumDecl__Group__5
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3213:1: ( ( ( rule__EEnumDecl__ELiteralsAssignment_4 ) ) ( ( rule__EEnumDecl__ELiteralsAssignment_4 )* ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3214:1: ( ( rule__EEnumDecl__ELiteralsAssignment_4 ) ) ( ( rule__EEnumDecl__ELiteralsAssignment_4 )* )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3214:1: ( ( rule__EEnumDecl__ELiteralsAssignment_4 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3215:1: ( rule__EEnumDecl__ELiteralsAssignment_4 )
            {
             before(grammarAccess.getEEnumDeclAccess().getELiteralsAssignment_4()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3216:1: ( rule__EEnumDecl__ELiteralsAssignment_4 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3216:2: rule__EEnumDecl__ELiteralsAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__EEnumDecl__ELiteralsAssignment_4_in_rule__EEnumDecl__Group__46507);
            rule__EEnumDecl__ELiteralsAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getEEnumDeclAccess().getELiteralsAssignment_4()); 

            }

            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3219:1: ( ( rule__EEnumDecl__ELiteralsAssignment_4 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3220:1: ( rule__EEnumDecl__ELiteralsAssignment_4 )*
            {
             before(grammarAccess.getEEnumDeclAccess().getELiteralsAssignment_4()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3221:1: ( rule__EEnumDecl__ELiteralsAssignment_4 )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==RULE_ID||LA47_0==31) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3221:2: rule__EEnumDecl__ELiteralsAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__EEnumDecl__ELiteralsAssignment_4_in_rule__EEnumDecl__Group__46519);
            	    rule__EEnumDecl__ELiteralsAssignment_4();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

             after(grammarAccess.getEEnumDeclAccess().getELiteralsAssignment_4()); 

            }


            }

            pushFollow(FollowSets000.FOLLOW_rule__EEnumDecl__Group__5_in_rule__EEnumDecl__Group__46531);
            rule__EEnumDecl__Group__5();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EEnumDecl__Group__4


    // $ANTLR start rule__EEnumDecl__Group__5
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3233:1: rule__EEnumDecl__Group__5 : ( '}' ) ;
    public final void rule__EEnumDecl__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3237:1: ( ( '}' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3238:1: ( '}' )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3238:1: ( '}' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3239:1: '}'
            {
             before(grammarAccess.getEEnumDeclAccess().getRightCurlyBracketKeyword_5()); 
            match(input,28,FollowSets000.FOLLOW_28_in_rule__EEnumDecl__Group__56560); 
             after(grammarAccess.getEEnumDeclAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EEnumDecl__Group__5


    // $ANTLR start rule__EEnumLiteralDecl__Group__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3264:1: rule__EEnumLiteralDecl__Group__0 : ( ( rule__EEnumLiteralDecl__EAnnotationsAssignment_0 )* ) rule__EEnumLiteralDecl__Group__1 ;
    public final void rule__EEnumLiteralDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3268:1: ( ( ( rule__EEnumLiteralDecl__EAnnotationsAssignment_0 )* ) rule__EEnumLiteralDecl__Group__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3269:1: ( ( rule__EEnumLiteralDecl__EAnnotationsAssignment_0 )* ) rule__EEnumLiteralDecl__Group__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3269:1: ( ( rule__EEnumLiteralDecl__EAnnotationsAssignment_0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3270:1: ( rule__EEnumLiteralDecl__EAnnotationsAssignment_0 )*
            {
             before(grammarAccess.getEEnumLiteralDeclAccess().getEAnnotationsAssignment_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3271:1: ( rule__EEnumLiteralDecl__EAnnotationsAssignment_0 )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==31) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3271:2: rule__EEnumLiteralDecl__EAnnotationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__EEnumLiteralDecl__EAnnotationsAssignment_0_in_rule__EEnumLiteralDecl__Group__06607);
            	    rule__EEnumLiteralDecl__EAnnotationsAssignment_0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);

             after(grammarAccess.getEEnumLiteralDeclAccess().getEAnnotationsAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EEnumLiteralDecl__Group__1_in_rule__EEnumLiteralDecl__Group__06617);
            rule__EEnumLiteralDecl__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EEnumLiteralDecl__Group__0


    // $ANTLR start rule__EEnumLiteralDecl__Group__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3282:1: rule__EEnumLiteralDecl__Group__1 : ( ( rule__EEnumLiteralDecl__NameAssignment_1 ) ) rule__EEnumLiteralDecl__Group__2 ;
    public final void rule__EEnumLiteralDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3286:1: ( ( ( rule__EEnumLiteralDecl__NameAssignment_1 ) ) rule__EEnumLiteralDecl__Group__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3287:1: ( ( rule__EEnumLiteralDecl__NameAssignment_1 ) ) rule__EEnumLiteralDecl__Group__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3287:1: ( ( rule__EEnumLiteralDecl__NameAssignment_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3288:1: ( rule__EEnumLiteralDecl__NameAssignment_1 )
            {
             before(grammarAccess.getEEnumLiteralDeclAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3289:1: ( rule__EEnumLiteralDecl__NameAssignment_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3289:2: rule__EEnumLiteralDecl__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EEnumLiteralDecl__NameAssignment_1_in_rule__EEnumLiteralDecl__Group__16645);
            rule__EEnumLiteralDecl__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getEEnumLiteralDeclAccess().getNameAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EEnumLiteralDecl__Group__2_in_rule__EEnumLiteralDecl__Group__16654);
            rule__EEnumLiteralDecl__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EEnumLiteralDecl__Group__1


    // $ANTLR start rule__EEnumLiteralDecl__Group__2
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3300:1: rule__EEnumLiteralDecl__Group__2 : ( ( rule__EEnumLiteralDecl__Group_2__0 )? ) rule__EEnumLiteralDecl__Group__3 ;
    public final void rule__EEnumLiteralDecl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3304:1: ( ( ( rule__EEnumLiteralDecl__Group_2__0 )? ) rule__EEnumLiteralDecl__Group__3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3305:1: ( ( rule__EEnumLiteralDecl__Group_2__0 )? ) rule__EEnumLiteralDecl__Group__3
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3305:1: ( ( rule__EEnumLiteralDecl__Group_2__0 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3306:1: ( rule__EEnumLiteralDecl__Group_2__0 )?
            {
             before(grammarAccess.getEEnumLiteralDeclAccess().getGroup_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3307:1: ( rule__EEnumLiteralDecl__Group_2__0 )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==23) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3307:2: rule__EEnumLiteralDecl__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EEnumLiteralDecl__Group_2__0_in_rule__EEnumLiteralDecl__Group__26682);
                    rule__EEnumLiteralDecl__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEEnumLiteralDeclAccess().getGroup_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EEnumLiteralDecl__Group__3_in_rule__EEnumLiteralDecl__Group__26692);
            rule__EEnumLiteralDecl__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EEnumLiteralDecl__Group__2


    // $ANTLR start rule__EEnumLiteralDecl__Group__3
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3318:1: rule__EEnumLiteralDecl__Group__3 : ( ( rule__EEnumLiteralDecl__LiteralAssignment_3 )? ) rule__EEnumLiteralDecl__Group__4 ;
    public final void rule__EEnumLiteralDecl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3322:1: ( ( ( rule__EEnumLiteralDecl__LiteralAssignment_3 )? ) rule__EEnumLiteralDecl__Group__4 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3323:1: ( ( rule__EEnumLiteralDecl__LiteralAssignment_3 )? ) rule__EEnumLiteralDecl__Group__4
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3323:1: ( ( rule__EEnumLiteralDecl__LiteralAssignment_3 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3324:1: ( rule__EEnumLiteralDecl__LiteralAssignment_3 )?
            {
             before(grammarAccess.getEEnumLiteralDeclAccess().getLiteralAssignment_3()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3325:1: ( rule__EEnumLiteralDecl__LiteralAssignment_3 )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==RULE_STRING) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3325:2: rule__EEnumLiteralDecl__LiteralAssignment_3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EEnumLiteralDecl__LiteralAssignment_3_in_rule__EEnumLiteralDecl__Group__36720);
                    rule__EEnumLiteralDecl__LiteralAssignment_3();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEEnumLiteralDeclAccess().getLiteralAssignment_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EEnumLiteralDecl__Group__4_in_rule__EEnumLiteralDecl__Group__36730);
            rule__EEnumLiteralDecl__Group__4();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EEnumLiteralDecl__Group__3


    // $ANTLR start rule__EEnumLiteralDecl__Group__4
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3336:1: rule__EEnumLiteralDecl__Group__4 : ( ';' ) ;
    public final void rule__EEnumLiteralDecl__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3340:1: ( ( ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3341:1: ( ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3341:1: ( ';' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3342:1: ';'
            {
             before(grammarAccess.getEEnumLiteralDeclAccess().getSemicolonKeyword_4()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__EEnumLiteralDecl__Group__46759); 
             after(grammarAccess.getEEnumLiteralDeclAccess().getSemicolonKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EEnumLiteralDecl__Group__4


    // $ANTLR start rule__EEnumLiteralDecl__Group_2__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3365:1: rule__EEnumLiteralDecl__Group_2__0 : ( '=' ) rule__EEnumLiteralDecl__Group_2__1 ;
    public final void rule__EEnumLiteralDecl__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3369:1: ( ( '=' ) rule__EEnumLiteralDecl__Group_2__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3370:1: ( '=' ) rule__EEnumLiteralDecl__Group_2__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3370:1: ( '=' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3371:1: '='
            {
             before(grammarAccess.getEEnumLiteralDeclAccess().getEqualsSignKeyword_2_0()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__EEnumLiteralDecl__Group_2__06805); 
             after(grammarAccess.getEEnumLiteralDeclAccess().getEqualsSignKeyword_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EEnumLiteralDecl__Group_2__1_in_rule__EEnumLiteralDecl__Group_2__06815);
            rule__EEnumLiteralDecl__Group_2__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EEnumLiteralDecl__Group_2__0


    // $ANTLR start rule__EEnumLiteralDecl__Group_2__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3385:1: rule__EEnumLiteralDecl__Group_2__1 : ( ( rule__EEnumLiteralDecl__ValueAssignment_2_1 ) ) ;
    public final void rule__EEnumLiteralDecl__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3389:1: ( ( ( rule__EEnumLiteralDecl__ValueAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3390:1: ( ( rule__EEnumLiteralDecl__ValueAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3390:1: ( ( rule__EEnumLiteralDecl__ValueAssignment_2_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3391:1: ( rule__EEnumLiteralDecl__ValueAssignment_2_1 )
            {
             before(grammarAccess.getEEnumLiteralDeclAccess().getValueAssignment_2_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3392:1: ( rule__EEnumLiteralDecl__ValueAssignment_2_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3392:2: rule__EEnumLiteralDecl__ValueAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EEnumLiteralDecl__ValueAssignment_2_1_in_rule__EEnumLiteralDecl__Group_2__16843);
            rule__EEnumLiteralDecl__ValueAssignment_2_1();
            _fsp--;


            }

             after(grammarAccess.getEEnumLiteralDeclAccess().getValueAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EEnumLiteralDecl__Group_2__1


    // $ANTLR start rule__ETypeParameterDecl__Group__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3406:1: rule__ETypeParameterDecl__Group__0 : ( ( rule__ETypeParameterDecl__NameAssignment_0 ) ) rule__ETypeParameterDecl__Group__1 ;
    public final void rule__ETypeParameterDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3410:1: ( ( ( rule__ETypeParameterDecl__NameAssignment_0 ) ) rule__ETypeParameterDecl__Group__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3411:1: ( ( rule__ETypeParameterDecl__NameAssignment_0 ) ) rule__ETypeParameterDecl__Group__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3411:1: ( ( rule__ETypeParameterDecl__NameAssignment_0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3412:1: ( rule__ETypeParameterDecl__NameAssignment_0 )
            {
             before(grammarAccess.getETypeParameterDeclAccess().getNameAssignment_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3413:1: ( rule__ETypeParameterDecl__NameAssignment_0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3413:2: rule__ETypeParameterDecl__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ETypeParameterDecl__NameAssignment_0_in_rule__ETypeParameterDecl__Group__06881);
            rule__ETypeParameterDecl__NameAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getETypeParameterDeclAccess().getNameAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ETypeParameterDecl__Group__1_in_rule__ETypeParameterDecl__Group__06890);
            rule__ETypeParameterDecl__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ETypeParameterDecl__Group__0


    // $ANTLR start rule__ETypeParameterDecl__Group__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3424:1: rule__ETypeParameterDecl__Group__1 : ( ( rule__ETypeParameterDecl__Group_1__0 )? ) ;
    public final void rule__ETypeParameterDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3428:1: ( ( ( rule__ETypeParameterDecl__Group_1__0 )? ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3429:1: ( ( rule__ETypeParameterDecl__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3429:1: ( ( rule__ETypeParameterDecl__Group_1__0 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3430:1: ( rule__ETypeParameterDecl__Group_1__0 )?
            {
             before(grammarAccess.getETypeParameterDeclAccess().getGroup_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3431:1: ( rule__ETypeParameterDecl__Group_1__0 )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==37) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3431:2: rule__ETypeParameterDecl__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ETypeParameterDecl__Group_1__0_in_rule__ETypeParameterDecl__Group__16918);
                    rule__ETypeParameterDecl__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getETypeParameterDeclAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ETypeParameterDecl__Group__1


    // $ANTLR start rule__ETypeParameterDecl__Group_1__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3445:1: rule__ETypeParameterDecl__Group_1__0 : ( 'extends' ) rule__ETypeParameterDecl__Group_1__1 ;
    public final void rule__ETypeParameterDecl__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3449:1: ( ( 'extends' ) rule__ETypeParameterDecl__Group_1__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3450:1: ( 'extends' ) rule__ETypeParameterDecl__Group_1__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3450:1: ( 'extends' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3451:1: 'extends'
            {
             before(grammarAccess.getETypeParameterDeclAccess().getExtendsKeyword_1_0()); 
            match(input,37,FollowSets000.FOLLOW_37_in_rule__ETypeParameterDecl__Group_1__06958); 
             after(grammarAccess.getETypeParameterDeclAccess().getExtendsKeyword_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ETypeParameterDecl__Group_1__1_in_rule__ETypeParameterDecl__Group_1__06968);
            rule__ETypeParameterDecl__Group_1__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ETypeParameterDecl__Group_1__0


    // $ANTLR start rule__ETypeParameterDecl__Group_1__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3465:1: rule__ETypeParameterDecl__Group_1__1 : ( ( rule__ETypeParameterDecl__EBoundsAssignment_1_1 ) ) ;
    public final void rule__ETypeParameterDecl__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3469:1: ( ( ( rule__ETypeParameterDecl__EBoundsAssignment_1_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3470:1: ( ( rule__ETypeParameterDecl__EBoundsAssignment_1_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3470:1: ( ( rule__ETypeParameterDecl__EBoundsAssignment_1_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3471:1: ( rule__ETypeParameterDecl__EBoundsAssignment_1_1 )
            {
             before(grammarAccess.getETypeParameterDeclAccess().getEBoundsAssignment_1_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3472:1: ( rule__ETypeParameterDecl__EBoundsAssignment_1_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3472:2: rule__ETypeParameterDecl__EBoundsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ETypeParameterDecl__EBoundsAssignment_1_1_in_rule__ETypeParameterDecl__Group_1__16996);
            rule__ETypeParameterDecl__EBoundsAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getETypeParameterDeclAccess().getEBoundsAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ETypeParameterDecl__Group_1__1


    // $ANTLR start rule__EGenericTypeReferenceDecl__Group_0__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3486:1: rule__EGenericTypeReferenceDecl__Group_0__0 : ( ( rule__EGenericTypeReferenceDecl__EClassifierAssignment_0_0 ) ) rule__EGenericTypeReferenceDecl__Group_0__1 ;
    public final void rule__EGenericTypeReferenceDecl__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3490:1: ( ( ( rule__EGenericTypeReferenceDecl__EClassifierAssignment_0_0 ) ) rule__EGenericTypeReferenceDecl__Group_0__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3491:1: ( ( rule__EGenericTypeReferenceDecl__EClassifierAssignment_0_0 ) ) rule__EGenericTypeReferenceDecl__Group_0__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3491:1: ( ( rule__EGenericTypeReferenceDecl__EClassifierAssignment_0_0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3492:1: ( rule__EGenericTypeReferenceDecl__EClassifierAssignment_0_0 )
            {
             before(grammarAccess.getEGenericTypeReferenceDeclAccess().getEClassifierAssignment_0_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3493:1: ( rule__EGenericTypeReferenceDecl__EClassifierAssignment_0_0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3493:2: rule__EGenericTypeReferenceDecl__EClassifierAssignment_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeReferenceDecl__EClassifierAssignment_0_0_in_rule__EGenericTypeReferenceDecl__Group_0__07034);
            rule__EGenericTypeReferenceDecl__EClassifierAssignment_0_0();
            _fsp--;


            }

             after(grammarAccess.getEGenericTypeReferenceDeclAccess().getEClassifierAssignment_0_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeReferenceDecl__Group_0__1_in_rule__EGenericTypeReferenceDecl__Group_0__07043);
            rule__EGenericTypeReferenceDecl__Group_0__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EGenericTypeReferenceDecl__Group_0__0


    // $ANTLR start rule__EGenericTypeReferenceDecl__Group_0__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3504:1: rule__EGenericTypeReferenceDecl__Group_0__1 : ( ( rule__EGenericTypeReferenceDecl__Group_0_1__0 )? ) ;
    public final void rule__EGenericTypeReferenceDecl__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3508:1: ( ( ( rule__EGenericTypeReferenceDecl__Group_0_1__0 )? ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3509:1: ( ( rule__EGenericTypeReferenceDecl__Group_0_1__0 )? )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3509:1: ( ( rule__EGenericTypeReferenceDecl__Group_0_1__0 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3510:1: ( rule__EGenericTypeReferenceDecl__Group_0_1__0 )?
            {
             before(grammarAccess.getEGenericTypeReferenceDeclAccess().getGroup_0_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3511:1: ( rule__EGenericTypeReferenceDecl__Group_0_1__0 )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==35) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3511:2: rule__EGenericTypeReferenceDecl__Group_0_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeReferenceDecl__Group_0_1__0_in_rule__EGenericTypeReferenceDecl__Group_0__17071);
                    rule__EGenericTypeReferenceDecl__Group_0_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEGenericTypeReferenceDeclAccess().getGroup_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EGenericTypeReferenceDecl__Group_0__1


    // $ANTLR start rule__EGenericTypeReferenceDecl__Group_0_1__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3525:1: rule__EGenericTypeReferenceDecl__Group_0_1__0 : ( '<' ) rule__EGenericTypeReferenceDecl__Group_0_1__1 ;
    public final void rule__EGenericTypeReferenceDecl__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3529:1: ( ( '<' ) rule__EGenericTypeReferenceDecl__Group_0_1__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3530:1: ( '<' ) rule__EGenericTypeReferenceDecl__Group_0_1__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3530:1: ( '<' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3531:1: '<'
            {
             before(grammarAccess.getEGenericTypeReferenceDeclAccess().getLessThanSignKeyword_0_1_0()); 
            match(input,35,FollowSets000.FOLLOW_35_in_rule__EGenericTypeReferenceDecl__Group_0_1__07111); 
             after(grammarAccess.getEGenericTypeReferenceDeclAccess().getLessThanSignKeyword_0_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeReferenceDecl__Group_0_1__1_in_rule__EGenericTypeReferenceDecl__Group_0_1__07121);
            rule__EGenericTypeReferenceDecl__Group_0_1__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EGenericTypeReferenceDecl__Group_0_1__0


    // $ANTLR start rule__EGenericTypeReferenceDecl__Group_0_1__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3545:1: rule__EGenericTypeReferenceDecl__Group_0_1__1 : ( ( rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_1 ) ) rule__EGenericTypeReferenceDecl__Group_0_1__2 ;
    public final void rule__EGenericTypeReferenceDecl__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3549:1: ( ( ( rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_1 ) ) rule__EGenericTypeReferenceDecl__Group_0_1__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3550:1: ( ( rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_1 ) ) rule__EGenericTypeReferenceDecl__Group_0_1__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3550:1: ( ( rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3551:1: ( rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_1 )
            {
             before(grammarAccess.getEGenericTypeReferenceDeclAccess().getETypeArgumentsAssignment_0_1_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3552:1: ( rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3552:2: rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_1_in_rule__EGenericTypeReferenceDecl__Group_0_1__17149);
            rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_1();
            _fsp--;


            }

             after(grammarAccess.getEGenericTypeReferenceDeclAccess().getETypeArgumentsAssignment_0_1_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeReferenceDecl__Group_0_1__2_in_rule__EGenericTypeReferenceDecl__Group_0_1__17158);
            rule__EGenericTypeReferenceDecl__Group_0_1__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EGenericTypeReferenceDecl__Group_0_1__1


    // $ANTLR start rule__EGenericTypeReferenceDecl__Group_0_1__2
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3563:1: rule__EGenericTypeReferenceDecl__Group_0_1__2 : ( ( rule__EGenericTypeReferenceDecl__Group_0_1_2__0 )* ) rule__EGenericTypeReferenceDecl__Group_0_1__3 ;
    public final void rule__EGenericTypeReferenceDecl__Group_0_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3567:1: ( ( ( rule__EGenericTypeReferenceDecl__Group_0_1_2__0 )* ) rule__EGenericTypeReferenceDecl__Group_0_1__3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3568:1: ( ( rule__EGenericTypeReferenceDecl__Group_0_1_2__0 )* ) rule__EGenericTypeReferenceDecl__Group_0_1__3
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3568:1: ( ( rule__EGenericTypeReferenceDecl__Group_0_1_2__0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3569:1: ( rule__EGenericTypeReferenceDecl__Group_0_1_2__0 )*
            {
             before(grammarAccess.getEGenericTypeReferenceDeclAccess().getGroup_0_1_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3570:1: ( rule__EGenericTypeReferenceDecl__Group_0_1_2__0 )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==34) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3570:2: rule__EGenericTypeReferenceDecl__Group_0_1_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeReferenceDecl__Group_0_1_2__0_in_rule__EGenericTypeReferenceDecl__Group_0_1__27186);
            	    rule__EGenericTypeReferenceDecl__Group_0_1_2__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

             after(grammarAccess.getEGenericTypeReferenceDeclAccess().getGroup_0_1_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeReferenceDecl__Group_0_1__3_in_rule__EGenericTypeReferenceDecl__Group_0_1__27196);
            rule__EGenericTypeReferenceDecl__Group_0_1__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EGenericTypeReferenceDecl__Group_0_1__2


    // $ANTLR start rule__EGenericTypeReferenceDecl__Group_0_1__3
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3581:1: rule__EGenericTypeReferenceDecl__Group_0_1__3 : ( '>' ) ;
    public final void rule__EGenericTypeReferenceDecl__Group_0_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3585:1: ( ( '>' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3586:1: ( '>' )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3586:1: ( '>' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3587:1: '>'
            {
             before(grammarAccess.getEGenericTypeReferenceDeclAccess().getGreaterThanSignKeyword_0_1_3()); 
            match(input,36,FollowSets000.FOLLOW_36_in_rule__EGenericTypeReferenceDecl__Group_0_1__37225); 
             after(grammarAccess.getEGenericTypeReferenceDeclAccess().getGreaterThanSignKeyword_0_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EGenericTypeReferenceDecl__Group_0_1__3


    // $ANTLR start rule__EGenericTypeReferenceDecl__Group_0_1_2__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3608:1: rule__EGenericTypeReferenceDecl__Group_0_1_2__0 : ( ',' ) rule__EGenericTypeReferenceDecl__Group_0_1_2__1 ;
    public final void rule__EGenericTypeReferenceDecl__Group_0_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3612:1: ( ( ',' ) rule__EGenericTypeReferenceDecl__Group_0_1_2__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3613:1: ( ',' ) rule__EGenericTypeReferenceDecl__Group_0_1_2__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3613:1: ( ',' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3614:1: ','
            {
             before(grammarAccess.getEGenericTypeReferenceDeclAccess().getCommaKeyword_0_1_2_0()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__EGenericTypeReferenceDecl__Group_0_1_2__07269); 
             after(grammarAccess.getEGenericTypeReferenceDeclAccess().getCommaKeyword_0_1_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeReferenceDecl__Group_0_1_2__1_in_rule__EGenericTypeReferenceDecl__Group_0_1_2__07279);
            rule__EGenericTypeReferenceDecl__Group_0_1_2__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EGenericTypeReferenceDecl__Group_0_1_2__0


    // $ANTLR start rule__EGenericTypeReferenceDecl__Group_0_1_2__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3628:1: rule__EGenericTypeReferenceDecl__Group_0_1_2__1 : ( ( rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_2_1 ) ) ;
    public final void rule__EGenericTypeReferenceDecl__Group_0_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3632:1: ( ( ( rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_2_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3633:1: ( ( rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_2_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3633:1: ( ( rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_2_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3634:1: ( rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_2_1 )
            {
             before(grammarAccess.getEGenericTypeReferenceDeclAccess().getETypeArgumentsAssignment_0_1_2_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3635:1: ( rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_2_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3635:2: rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_2_1_in_rule__EGenericTypeReferenceDecl__Group_0_1_2__17307);
            rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_2_1();
            _fsp--;


            }

             after(grammarAccess.getEGenericTypeReferenceDeclAccess().getETypeArgumentsAssignment_0_1_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EGenericTypeReferenceDecl__Group_0_1_2__1


    // $ANTLR start rule__EGenericTypeReferenceDecl__Group_1__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3649:1: rule__EGenericTypeReferenceDecl__Group_1__0 : ( '#' ) rule__EGenericTypeReferenceDecl__Group_1__1 ;
    public final void rule__EGenericTypeReferenceDecl__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3653:1: ( ( '#' ) rule__EGenericTypeReferenceDecl__Group_1__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3654:1: ( '#' ) rule__EGenericTypeReferenceDecl__Group_1__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3654:1: ( '#' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3655:1: '#'
            {
             before(grammarAccess.getEGenericTypeReferenceDeclAccess().getNumberSignKeyword_1_0()); 
            match(input,42,FollowSets000.FOLLOW_42_in_rule__EGenericTypeReferenceDecl__Group_1__07346); 
             after(grammarAccess.getEGenericTypeReferenceDeclAccess().getNumberSignKeyword_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeReferenceDecl__Group_1__1_in_rule__EGenericTypeReferenceDecl__Group_1__07356);
            rule__EGenericTypeReferenceDecl__Group_1__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EGenericTypeReferenceDecl__Group_1__0


    // $ANTLR start rule__EGenericTypeReferenceDecl__Group_1__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3669:1: rule__EGenericTypeReferenceDecl__Group_1__1 : ( ( rule__EGenericTypeReferenceDecl__ETypeParameterAssignment_1_1 ) ) ;
    public final void rule__EGenericTypeReferenceDecl__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3673:1: ( ( ( rule__EGenericTypeReferenceDecl__ETypeParameterAssignment_1_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3674:1: ( ( rule__EGenericTypeReferenceDecl__ETypeParameterAssignment_1_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3674:1: ( ( rule__EGenericTypeReferenceDecl__ETypeParameterAssignment_1_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3675:1: ( rule__EGenericTypeReferenceDecl__ETypeParameterAssignment_1_1 )
            {
             before(grammarAccess.getEGenericTypeReferenceDeclAccess().getETypeParameterAssignment_1_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3676:1: ( rule__EGenericTypeReferenceDecl__ETypeParameterAssignment_1_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3676:2: rule__EGenericTypeReferenceDecl__ETypeParameterAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeReferenceDecl__ETypeParameterAssignment_1_1_in_rule__EGenericTypeReferenceDecl__Group_1__17384);
            rule__EGenericTypeReferenceDecl__ETypeParameterAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getEGenericTypeReferenceDeclAccess().getETypeParameterAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EGenericTypeReferenceDecl__Group_1__1


    // $ANTLR start rule__EGenericTypeDecl__Group_0__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3690:1: rule__EGenericTypeDecl__Group_0__0 : ( ( rule__EGenericTypeDecl__EClassifierAssignment_0_0 ) ) rule__EGenericTypeDecl__Group_0__1 ;
    public final void rule__EGenericTypeDecl__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3694:1: ( ( ( rule__EGenericTypeDecl__EClassifierAssignment_0_0 ) ) rule__EGenericTypeDecl__Group_0__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3695:1: ( ( rule__EGenericTypeDecl__EClassifierAssignment_0_0 ) ) rule__EGenericTypeDecl__Group_0__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3695:1: ( ( rule__EGenericTypeDecl__EClassifierAssignment_0_0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3696:1: ( rule__EGenericTypeDecl__EClassifierAssignment_0_0 )
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getEClassifierAssignment_0_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3697:1: ( rule__EGenericTypeDecl__EClassifierAssignment_0_0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3697:2: rule__EGenericTypeDecl__EClassifierAssignment_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeDecl__EClassifierAssignment_0_0_in_rule__EGenericTypeDecl__Group_0__07422);
            rule__EGenericTypeDecl__EClassifierAssignment_0_0();
            _fsp--;


            }

             after(grammarAccess.getEGenericTypeDeclAccess().getEClassifierAssignment_0_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeDecl__Group_0__1_in_rule__EGenericTypeDecl__Group_0__07431);
            rule__EGenericTypeDecl__Group_0__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EGenericTypeDecl__Group_0__0


    // $ANTLR start rule__EGenericTypeDecl__Group_0__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3708:1: rule__EGenericTypeDecl__Group_0__1 : ( ( rule__EGenericTypeDecl__Group_0_1__0 )? ) ;
    public final void rule__EGenericTypeDecl__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3712:1: ( ( ( rule__EGenericTypeDecl__Group_0_1__0 )? ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3713:1: ( ( rule__EGenericTypeDecl__Group_0_1__0 )? )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3713:1: ( ( rule__EGenericTypeDecl__Group_0_1__0 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3714:1: ( rule__EGenericTypeDecl__Group_0_1__0 )?
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getGroup_0_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3715:1: ( rule__EGenericTypeDecl__Group_0_1__0 )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==35) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3715:2: rule__EGenericTypeDecl__Group_0_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeDecl__Group_0_1__0_in_rule__EGenericTypeDecl__Group_0__17459);
                    rule__EGenericTypeDecl__Group_0_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEGenericTypeDeclAccess().getGroup_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EGenericTypeDecl__Group_0__1


    // $ANTLR start rule__EGenericTypeDecl__Group_0_1__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3729:1: rule__EGenericTypeDecl__Group_0_1__0 : ( '<' ) rule__EGenericTypeDecl__Group_0_1__1 ;
    public final void rule__EGenericTypeDecl__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3733:1: ( ( '<' ) rule__EGenericTypeDecl__Group_0_1__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3734:1: ( '<' ) rule__EGenericTypeDecl__Group_0_1__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3734:1: ( '<' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3735:1: '<'
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getLessThanSignKeyword_0_1_0()); 
            match(input,35,FollowSets000.FOLLOW_35_in_rule__EGenericTypeDecl__Group_0_1__07499); 
             after(grammarAccess.getEGenericTypeDeclAccess().getLessThanSignKeyword_0_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeDecl__Group_0_1__1_in_rule__EGenericTypeDecl__Group_0_1__07509);
            rule__EGenericTypeDecl__Group_0_1__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EGenericTypeDecl__Group_0_1__0


    // $ANTLR start rule__EGenericTypeDecl__Group_0_1__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3749:1: rule__EGenericTypeDecl__Group_0_1__1 : ( ( rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_1 ) ) rule__EGenericTypeDecl__Group_0_1__2 ;
    public final void rule__EGenericTypeDecl__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3753:1: ( ( ( rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_1 ) ) rule__EGenericTypeDecl__Group_0_1__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3754:1: ( ( rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_1 ) ) rule__EGenericTypeDecl__Group_0_1__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3754:1: ( ( rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3755:1: ( rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_1 )
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getETypeArgumentsAssignment_0_1_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3756:1: ( rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3756:2: rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_1_in_rule__EGenericTypeDecl__Group_0_1__17537);
            rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_1();
            _fsp--;


            }

             after(grammarAccess.getEGenericTypeDeclAccess().getETypeArgumentsAssignment_0_1_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeDecl__Group_0_1__2_in_rule__EGenericTypeDecl__Group_0_1__17546);
            rule__EGenericTypeDecl__Group_0_1__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EGenericTypeDecl__Group_0_1__1


    // $ANTLR start rule__EGenericTypeDecl__Group_0_1__2
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3767:1: rule__EGenericTypeDecl__Group_0_1__2 : ( ( rule__EGenericTypeDecl__Group_0_1_2__0 )* ) rule__EGenericTypeDecl__Group_0_1__3 ;
    public final void rule__EGenericTypeDecl__Group_0_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3771:1: ( ( ( rule__EGenericTypeDecl__Group_0_1_2__0 )* ) rule__EGenericTypeDecl__Group_0_1__3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3772:1: ( ( rule__EGenericTypeDecl__Group_0_1_2__0 )* ) rule__EGenericTypeDecl__Group_0_1__3
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3772:1: ( ( rule__EGenericTypeDecl__Group_0_1_2__0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3773:1: ( rule__EGenericTypeDecl__Group_0_1_2__0 )*
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getGroup_0_1_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3774:1: ( rule__EGenericTypeDecl__Group_0_1_2__0 )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==34) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3774:2: rule__EGenericTypeDecl__Group_0_1_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeDecl__Group_0_1_2__0_in_rule__EGenericTypeDecl__Group_0_1__27574);
            	    rule__EGenericTypeDecl__Group_0_1_2__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);

             after(grammarAccess.getEGenericTypeDeclAccess().getGroup_0_1_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeDecl__Group_0_1__3_in_rule__EGenericTypeDecl__Group_0_1__27584);
            rule__EGenericTypeDecl__Group_0_1__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EGenericTypeDecl__Group_0_1__2


    // $ANTLR start rule__EGenericTypeDecl__Group_0_1__3
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3785:1: rule__EGenericTypeDecl__Group_0_1__3 : ( '>' ) ;
    public final void rule__EGenericTypeDecl__Group_0_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3789:1: ( ( '>' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3790:1: ( '>' )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3790:1: ( '>' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3791:1: '>'
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getGreaterThanSignKeyword_0_1_3()); 
            match(input,36,FollowSets000.FOLLOW_36_in_rule__EGenericTypeDecl__Group_0_1__37613); 
             after(grammarAccess.getEGenericTypeDeclAccess().getGreaterThanSignKeyword_0_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EGenericTypeDecl__Group_0_1__3


    // $ANTLR start rule__EGenericTypeDecl__Group_0_1_2__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3812:1: rule__EGenericTypeDecl__Group_0_1_2__0 : ( ',' ) rule__EGenericTypeDecl__Group_0_1_2__1 ;
    public final void rule__EGenericTypeDecl__Group_0_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3816:1: ( ( ',' ) rule__EGenericTypeDecl__Group_0_1_2__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3817:1: ( ',' ) rule__EGenericTypeDecl__Group_0_1_2__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3817:1: ( ',' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3818:1: ','
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getCommaKeyword_0_1_2_0()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__EGenericTypeDecl__Group_0_1_2__07657); 
             after(grammarAccess.getEGenericTypeDeclAccess().getCommaKeyword_0_1_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeDecl__Group_0_1_2__1_in_rule__EGenericTypeDecl__Group_0_1_2__07667);
            rule__EGenericTypeDecl__Group_0_1_2__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EGenericTypeDecl__Group_0_1_2__0


    // $ANTLR start rule__EGenericTypeDecl__Group_0_1_2__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3832:1: rule__EGenericTypeDecl__Group_0_1_2__1 : ( ( rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_2_1 ) ) ;
    public final void rule__EGenericTypeDecl__Group_0_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3836:1: ( ( ( rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_2_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3837:1: ( ( rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_2_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3837:1: ( ( rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_2_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3838:1: ( rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_2_1 )
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getETypeArgumentsAssignment_0_1_2_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3839:1: ( rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_2_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3839:2: rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_2_1_in_rule__EGenericTypeDecl__Group_0_1_2__17695);
            rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_2_1();
            _fsp--;


            }

             after(grammarAccess.getEGenericTypeDeclAccess().getETypeArgumentsAssignment_0_1_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EGenericTypeDecl__Group_0_1_2__1


    // $ANTLR start rule__EGenericTypeDecl__Group_1__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3853:1: rule__EGenericTypeDecl__Group_1__0 : ( '#' ) rule__EGenericTypeDecl__Group_1__1 ;
    public final void rule__EGenericTypeDecl__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3857:1: ( ( '#' ) rule__EGenericTypeDecl__Group_1__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3858:1: ( '#' ) rule__EGenericTypeDecl__Group_1__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3858:1: ( '#' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3859:1: '#'
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getNumberSignKeyword_1_0()); 
            match(input,42,FollowSets000.FOLLOW_42_in_rule__EGenericTypeDecl__Group_1__07734); 
             after(grammarAccess.getEGenericTypeDeclAccess().getNumberSignKeyword_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeDecl__Group_1__1_in_rule__EGenericTypeDecl__Group_1__07744);
            rule__EGenericTypeDecl__Group_1__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EGenericTypeDecl__Group_1__0


    // $ANTLR start rule__EGenericTypeDecl__Group_1__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3873:1: rule__EGenericTypeDecl__Group_1__1 : ( ( rule__EGenericTypeDecl__ETypeParameterAssignment_1_1 ) ) ;
    public final void rule__EGenericTypeDecl__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3877:1: ( ( ( rule__EGenericTypeDecl__ETypeParameterAssignment_1_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3878:1: ( ( rule__EGenericTypeDecl__ETypeParameterAssignment_1_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3878:1: ( ( rule__EGenericTypeDecl__ETypeParameterAssignment_1_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3879:1: ( rule__EGenericTypeDecl__ETypeParameterAssignment_1_1 )
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getETypeParameterAssignment_1_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3880:1: ( rule__EGenericTypeDecl__ETypeParameterAssignment_1_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3880:2: rule__EGenericTypeDecl__ETypeParameterAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeDecl__ETypeParameterAssignment_1_1_in_rule__EGenericTypeDecl__Group_1__17772);
            rule__EGenericTypeDecl__ETypeParameterAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getEGenericTypeDeclAccess().getETypeParameterAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EGenericTypeDecl__Group_1__1


    // $ANTLR start rule__EGenericTypeDecl__Group_2__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3894:1: rule__EGenericTypeDecl__Group_2__0 : ( '?' ) rule__EGenericTypeDecl__Group_2__1 ;
    public final void rule__EGenericTypeDecl__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3898:1: ( ( '?' ) rule__EGenericTypeDecl__Group_2__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3899:1: ( '?' ) rule__EGenericTypeDecl__Group_2__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3899:1: ( '?' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3900:1: '?'
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getQuestionMarkKeyword_2_0()); 
            match(input,44,FollowSets000.FOLLOW_44_in_rule__EGenericTypeDecl__Group_2__07811); 
             after(grammarAccess.getEGenericTypeDeclAccess().getQuestionMarkKeyword_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeDecl__Group_2__1_in_rule__EGenericTypeDecl__Group_2__07821);
            rule__EGenericTypeDecl__Group_2__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EGenericTypeDecl__Group_2__0


    // $ANTLR start rule__EGenericTypeDecl__Group_2__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3914:1: rule__EGenericTypeDecl__Group_2__1 : ( ( rule__EGenericTypeDecl__Alternatives_2_1 ) ) ;
    public final void rule__EGenericTypeDecl__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3918:1: ( ( ( rule__EGenericTypeDecl__Alternatives_2_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3919:1: ( ( rule__EGenericTypeDecl__Alternatives_2_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3919:1: ( ( rule__EGenericTypeDecl__Alternatives_2_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3920:1: ( rule__EGenericTypeDecl__Alternatives_2_1 )
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getAlternatives_2_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3921:1: ( rule__EGenericTypeDecl__Alternatives_2_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3921:2: rule__EGenericTypeDecl__Alternatives_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeDecl__Alternatives_2_1_in_rule__EGenericTypeDecl__Group_2__17849);
            rule__EGenericTypeDecl__Alternatives_2_1();
            _fsp--;


            }

             after(grammarAccess.getEGenericTypeDeclAccess().getAlternatives_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EGenericTypeDecl__Group_2__1


    // $ANTLR start rule__EGenericTypeDecl__Group_2_1_0__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3935:1: rule__EGenericTypeDecl__Group_2_1_0__0 : ( 'extends' ) rule__EGenericTypeDecl__Group_2_1_0__1 ;
    public final void rule__EGenericTypeDecl__Group_2_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3939:1: ( ( 'extends' ) rule__EGenericTypeDecl__Group_2_1_0__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3940:1: ( 'extends' ) rule__EGenericTypeDecl__Group_2_1_0__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3940:1: ( 'extends' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3941:1: 'extends'
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getExtendsKeyword_2_1_0_0()); 
            match(input,37,FollowSets000.FOLLOW_37_in_rule__EGenericTypeDecl__Group_2_1_0__07888); 
             after(grammarAccess.getEGenericTypeDeclAccess().getExtendsKeyword_2_1_0_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeDecl__Group_2_1_0__1_in_rule__EGenericTypeDecl__Group_2_1_0__07898);
            rule__EGenericTypeDecl__Group_2_1_0__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EGenericTypeDecl__Group_2_1_0__0


    // $ANTLR start rule__EGenericTypeDecl__Group_2_1_0__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3955:1: rule__EGenericTypeDecl__Group_2_1_0__1 : ( ( rule__EGenericTypeDecl__EUpperBoundAssignment_2_1_0_1 ) ) ;
    public final void rule__EGenericTypeDecl__Group_2_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3959:1: ( ( ( rule__EGenericTypeDecl__EUpperBoundAssignment_2_1_0_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3960:1: ( ( rule__EGenericTypeDecl__EUpperBoundAssignment_2_1_0_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3960:1: ( ( rule__EGenericTypeDecl__EUpperBoundAssignment_2_1_0_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3961:1: ( rule__EGenericTypeDecl__EUpperBoundAssignment_2_1_0_1 )
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getEUpperBoundAssignment_2_1_0_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3962:1: ( rule__EGenericTypeDecl__EUpperBoundAssignment_2_1_0_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3962:2: rule__EGenericTypeDecl__EUpperBoundAssignment_2_1_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeDecl__EUpperBoundAssignment_2_1_0_1_in_rule__EGenericTypeDecl__Group_2_1_0__17926);
            rule__EGenericTypeDecl__EUpperBoundAssignment_2_1_0_1();
            _fsp--;


            }

             after(grammarAccess.getEGenericTypeDeclAccess().getEUpperBoundAssignment_2_1_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EGenericTypeDecl__Group_2_1_0__1


    // $ANTLR start rule__EGenericTypeDecl__Group_2_1_1__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3976:1: rule__EGenericTypeDecl__Group_2_1_1__0 : ( 'super' ) rule__EGenericTypeDecl__Group_2_1_1__1 ;
    public final void rule__EGenericTypeDecl__Group_2_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3980:1: ( ( 'super' ) rule__EGenericTypeDecl__Group_2_1_1__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3981:1: ( 'super' ) rule__EGenericTypeDecl__Group_2_1_1__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3981:1: ( 'super' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3982:1: 'super'
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getSuperKeyword_2_1_1_0()); 
            match(input,45,FollowSets000.FOLLOW_45_in_rule__EGenericTypeDecl__Group_2_1_1__07965); 
             after(grammarAccess.getEGenericTypeDeclAccess().getSuperKeyword_2_1_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeDecl__Group_2_1_1__1_in_rule__EGenericTypeDecl__Group_2_1_1__07975);
            rule__EGenericTypeDecl__Group_2_1_1__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EGenericTypeDecl__Group_2_1_1__0


    // $ANTLR start rule__EGenericTypeDecl__Group_2_1_1__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:3996:1: rule__EGenericTypeDecl__Group_2_1_1__1 : ( ( rule__EGenericTypeDecl__ELowerBoundAssignment_2_1_1_1 ) ) ;
    public final void rule__EGenericTypeDecl__Group_2_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4000:1: ( ( ( rule__EGenericTypeDecl__ELowerBoundAssignment_2_1_1_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4001:1: ( ( rule__EGenericTypeDecl__ELowerBoundAssignment_2_1_1_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4001:1: ( ( rule__EGenericTypeDecl__ELowerBoundAssignment_2_1_1_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4002:1: ( rule__EGenericTypeDecl__ELowerBoundAssignment_2_1_1_1 )
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getELowerBoundAssignment_2_1_1_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4003:1: ( rule__EGenericTypeDecl__ELowerBoundAssignment_2_1_1_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4003:2: rule__EGenericTypeDecl__ELowerBoundAssignment_2_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EGenericTypeDecl__ELowerBoundAssignment_2_1_1_1_in_rule__EGenericTypeDecl__Group_2_1_1__18003);
            rule__EGenericTypeDecl__ELowerBoundAssignment_2_1_1_1();
            _fsp--;


            }

             after(grammarAccess.getEGenericTypeDeclAccess().getELowerBoundAssignment_2_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EGenericTypeDecl__Group_2_1_1__1


    // $ANTLR start rule__EOperationDecl__Group__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4017:1: rule__EOperationDecl__Group__0 : ( ( rule__EOperationDecl__EAnnotationsAssignment_0 )* ) rule__EOperationDecl__Group__1 ;
    public final void rule__EOperationDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4021:1: ( ( ( rule__EOperationDecl__EAnnotationsAssignment_0 )* ) rule__EOperationDecl__Group__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4022:1: ( ( rule__EOperationDecl__EAnnotationsAssignment_0 )* ) rule__EOperationDecl__Group__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4022:1: ( ( rule__EOperationDecl__EAnnotationsAssignment_0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4023:1: ( rule__EOperationDecl__EAnnotationsAssignment_0 )*
            {
             before(grammarAccess.getEOperationDeclAccess().getEAnnotationsAssignment_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4024:1: ( rule__EOperationDecl__EAnnotationsAssignment_0 )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==31) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4024:2: rule__EOperationDecl__EAnnotationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__EAnnotationsAssignment_0_in_rule__EOperationDecl__Group__08041);
            	    rule__EOperationDecl__EAnnotationsAssignment_0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);

             after(grammarAccess.getEOperationDeclAccess().getEAnnotationsAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__Group__1_in_rule__EOperationDecl__Group__08051);
            rule__EOperationDecl__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EOperationDecl__Group__0


    // $ANTLR start rule__EOperationDecl__Group__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4035:1: rule__EOperationDecl__Group__1 : ( ( rule__EOperationDecl__Alternatives_1 )* ) rule__EOperationDecl__Group__2 ;
    public final void rule__EOperationDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4039:1: ( ( ( rule__EOperationDecl__Alternatives_1 )* ) rule__EOperationDecl__Group__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4040:1: ( ( rule__EOperationDecl__Alternatives_1 )* ) rule__EOperationDecl__Group__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4040:1: ( ( rule__EOperationDecl__Alternatives_1 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4041:1: ( rule__EOperationDecl__Alternatives_1 )*
            {
             before(grammarAccess.getEOperationDeclAccess().getAlternatives_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4042:1: ( rule__EOperationDecl__Alternatives_1 )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( ((LA57_0>=RULE_BAG && LA57_0<=RULE_RANDOM)) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4042:2: rule__EOperationDecl__Alternatives_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__Alternatives_1_in_rule__EOperationDecl__Group__18079);
            	    rule__EOperationDecl__Alternatives_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);

             after(grammarAccess.getEOperationDeclAccess().getAlternatives_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__Group__2_in_rule__EOperationDecl__Group__18089);
            rule__EOperationDecl__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EOperationDecl__Group__1


    // $ANTLR start rule__EOperationDecl__Group__2
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4053:1: rule__EOperationDecl__Group__2 : ( 'op' ) rule__EOperationDecl__Group__3 ;
    public final void rule__EOperationDecl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4057:1: ( ( 'op' ) rule__EOperationDecl__Group__3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4058:1: ( 'op' ) rule__EOperationDecl__Group__3
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4058:1: ( 'op' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4059:1: 'op'
            {
             before(grammarAccess.getEOperationDeclAccess().getOpKeyword_2()); 
            match(input,46,FollowSets000.FOLLOW_46_in_rule__EOperationDecl__Group__28118); 
             after(grammarAccess.getEOperationDeclAccess().getOpKeyword_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__Group__3_in_rule__EOperationDecl__Group__28128);
            rule__EOperationDecl__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EOperationDecl__Group__2


    // $ANTLR start rule__EOperationDecl__Group__3
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4073:1: rule__EOperationDecl__Group__3 : ( ( rule__EOperationDecl__Alternatives_3 ) ) rule__EOperationDecl__Group__4 ;
    public final void rule__EOperationDecl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4077:1: ( ( ( rule__EOperationDecl__Alternatives_3 ) ) rule__EOperationDecl__Group__4 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4078:1: ( ( rule__EOperationDecl__Alternatives_3 ) ) rule__EOperationDecl__Group__4
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4078:1: ( ( rule__EOperationDecl__Alternatives_3 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4079:1: ( rule__EOperationDecl__Alternatives_3 )
            {
             before(grammarAccess.getEOperationDeclAccess().getAlternatives_3()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4080:1: ( rule__EOperationDecl__Alternatives_3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4080:2: rule__EOperationDecl__Alternatives_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__Alternatives_3_in_rule__EOperationDecl__Group__38156);
            rule__EOperationDecl__Alternatives_3();
            _fsp--;


            }

             after(grammarAccess.getEOperationDeclAccess().getAlternatives_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__Group__4_in_rule__EOperationDecl__Group__38165);
            rule__EOperationDecl__Group__4();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EOperationDecl__Group__3


    // $ANTLR start rule__EOperationDecl__Group__4
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4091:1: rule__EOperationDecl__Group__4 : ( ( rule__EOperationDecl__NameAssignment_4 ) ) rule__EOperationDecl__Group__5 ;
    public final void rule__EOperationDecl__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4095:1: ( ( ( rule__EOperationDecl__NameAssignment_4 ) ) rule__EOperationDecl__Group__5 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4096:1: ( ( rule__EOperationDecl__NameAssignment_4 ) ) rule__EOperationDecl__Group__5
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4096:1: ( ( rule__EOperationDecl__NameAssignment_4 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4097:1: ( rule__EOperationDecl__NameAssignment_4 )
            {
             before(grammarAccess.getEOperationDeclAccess().getNameAssignment_4()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4098:1: ( rule__EOperationDecl__NameAssignment_4 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4098:2: rule__EOperationDecl__NameAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__NameAssignment_4_in_rule__EOperationDecl__Group__48193);
            rule__EOperationDecl__NameAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getEOperationDeclAccess().getNameAssignment_4()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__Group__5_in_rule__EOperationDecl__Group__48202);
            rule__EOperationDecl__Group__5();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EOperationDecl__Group__4


    // $ANTLR start rule__EOperationDecl__Group__5
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4109:1: rule__EOperationDecl__Group__5 : ( ( rule__EOperationDecl__Group_5__0 )? ) rule__EOperationDecl__Group__6 ;
    public final void rule__EOperationDecl__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4113:1: ( ( ( rule__EOperationDecl__Group_5__0 )? ) rule__EOperationDecl__Group__6 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4114:1: ( ( rule__EOperationDecl__Group_5__0 )? ) rule__EOperationDecl__Group__6
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4114:1: ( ( rule__EOperationDecl__Group_5__0 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4115:1: ( rule__EOperationDecl__Group_5__0 )?
            {
             before(grammarAccess.getEOperationDeclAccess().getGroup_5()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4116:1: ( rule__EOperationDecl__Group_5__0 )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==35) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4116:2: rule__EOperationDecl__Group_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__Group_5__0_in_rule__EOperationDecl__Group__58230);
                    rule__EOperationDecl__Group_5__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEOperationDeclAccess().getGroup_5()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__Group__6_in_rule__EOperationDecl__Group__58240);
            rule__EOperationDecl__Group__6();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EOperationDecl__Group__5


    // $ANTLR start rule__EOperationDecl__Group__6
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4127:1: rule__EOperationDecl__Group__6 : ( '(' ) rule__EOperationDecl__Group__7 ;
    public final void rule__EOperationDecl__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4131:1: ( ( '(' ) rule__EOperationDecl__Group__7 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4132:1: ( '(' ) rule__EOperationDecl__Group__7
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4132:1: ( '(' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4133:1: '('
            {
             before(grammarAccess.getEOperationDeclAccess().getLeftParenthesisKeyword_6()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__EOperationDecl__Group__68269); 
             after(grammarAccess.getEOperationDeclAccess().getLeftParenthesisKeyword_6()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__Group__7_in_rule__EOperationDecl__Group__68279);
            rule__EOperationDecl__Group__7();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EOperationDecl__Group__6


    // $ANTLR start rule__EOperationDecl__Group__7
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4147:1: rule__EOperationDecl__Group__7 : ( ( rule__EOperationDecl__Group_7__0 )? ) rule__EOperationDecl__Group__8 ;
    public final void rule__EOperationDecl__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4151:1: ( ( ( rule__EOperationDecl__Group_7__0 )? ) rule__EOperationDecl__Group__8 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4152:1: ( ( rule__EOperationDecl__Group_7__0 )? ) rule__EOperationDecl__Group__8
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4152:1: ( ( rule__EOperationDecl__Group_7__0 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4153:1: ( rule__EOperationDecl__Group_7__0 )?
            {
             before(grammarAccess.getEOperationDeclAccess().getGroup_7()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4154:1: ( rule__EOperationDecl__Group_7__0 )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==RULE_ID||LA59_0==31||LA59_0==42) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4154:2: rule__EOperationDecl__Group_7__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__Group_7__0_in_rule__EOperationDecl__Group__78307);
                    rule__EOperationDecl__Group_7__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEOperationDeclAccess().getGroup_7()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__Group__8_in_rule__EOperationDecl__Group__78317);
            rule__EOperationDecl__Group__8();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EOperationDecl__Group__7


    // $ANTLR start rule__EOperationDecl__Group__8
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4165:1: rule__EOperationDecl__Group__8 : ( ')' ) rule__EOperationDecl__Group__9 ;
    public final void rule__EOperationDecl__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4169:1: ( ( ')' ) rule__EOperationDecl__Group__9 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4170:1: ( ')' ) rule__EOperationDecl__Group__9
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4170:1: ( ')' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4171:1: ')'
            {
             before(grammarAccess.getEOperationDeclAccess().getRightParenthesisKeyword_8()); 
            match(input,33,FollowSets000.FOLLOW_33_in_rule__EOperationDecl__Group__88346); 
             after(grammarAccess.getEOperationDeclAccess().getRightParenthesisKeyword_8()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__Group__9_in_rule__EOperationDecl__Group__88356);
            rule__EOperationDecl__Group__9();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EOperationDecl__Group__8


    // $ANTLR start rule__EOperationDecl__Group__9
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4185:1: rule__EOperationDecl__Group__9 : ( ( rule__EOperationDecl__Group_9__0 )? ) rule__EOperationDecl__Group__10 ;
    public final void rule__EOperationDecl__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4189:1: ( ( ( rule__EOperationDecl__Group_9__0 )? ) rule__EOperationDecl__Group__10 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4190:1: ( ( rule__EOperationDecl__Group_9__0 )? ) rule__EOperationDecl__Group__10
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4190:1: ( ( rule__EOperationDecl__Group_9__0 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4191:1: ( rule__EOperationDecl__Group_9__0 )?
            {
             before(grammarAccess.getEOperationDeclAccess().getGroup_9()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4192:1: ( rule__EOperationDecl__Group_9__0 )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==47) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4192:2: rule__EOperationDecl__Group_9__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__Group_9__0_in_rule__EOperationDecl__Group__98384);
                    rule__EOperationDecl__Group_9__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEOperationDeclAccess().getGroup_9()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__Group__10_in_rule__EOperationDecl__Group__98394);
            rule__EOperationDecl__Group__10();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EOperationDecl__Group__9


    // $ANTLR start rule__EOperationDecl__Group__10
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4203:1: rule__EOperationDecl__Group__10 : ( ';' ) ;
    public final void rule__EOperationDecl__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4207:1: ( ( ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4208:1: ( ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4208:1: ( ';' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4209:1: ';'
            {
             before(grammarAccess.getEOperationDeclAccess().getSemicolonKeyword_10()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__EOperationDecl__Group__108423); 
             after(grammarAccess.getEOperationDeclAccess().getSemicolonKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EOperationDecl__Group__10


    // $ANTLR start rule__EOperationDecl__Group_5__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4244:1: rule__EOperationDecl__Group_5__0 : ( '<' ) rule__EOperationDecl__Group_5__1 ;
    public final void rule__EOperationDecl__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4248:1: ( ( '<' ) rule__EOperationDecl__Group_5__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4249:1: ( '<' ) rule__EOperationDecl__Group_5__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4249:1: ( '<' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4250:1: '<'
            {
             before(grammarAccess.getEOperationDeclAccess().getLessThanSignKeyword_5_0()); 
            match(input,35,FollowSets000.FOLLOW_35_in_rule__EOperationDecl__Group_5__08481); 
             after(grammarAccess.getEOperationDeclAccess().getLessThanSignKeyword_5_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__Group_5__1_in_rule__EOperationDecl__Group_5__08491);
            rule__EOperationDecl__Group_5__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EOperationDecl__Group_5__0


    // $ANTLR start rule__EOperationDecl__Group_5__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4264:1: rule__EOperationDecl__Group_5__1 : ( ( rule__EOperationDecl__ETypeParametersAssignment_5_1 ) ) rule__EOperationDecl__Group_5__2 ;
    public final void rule__EOperationDecl__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4268:1: ( ( ( rule__EOperationDecl__ETypeParametersAssignment_5_1 ) ) rule__EOperationDecl__Group_5__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4269:1: ( ( rule__EOperationDecl__ETypeParametersAssignment_5_1 ) ) rule__EOperationDecl__Group_5__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4269:1: ( ( rule__EOperationDecl__ETypeParametersAssignment_5_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4270:1: ( rule__EOperationDecl__ETypeParametersAssignment_5_1 )
            {
             before(grammarAccess.getEOperationDeclAccess().getETypeParametersAssignment_5_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4271:1: ( rule__EOperationDecl__ETypeParametersAssignment_5_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4271:2: rule__EOperationDecl__ETypeParametersAssignment_5_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__ETypeParametersAssignment_5_1_in_rule__EOperationDecl__Group_5__18519);
            rule__EOperationDecl__ETypeParametersAssignment_5_1();
            _fsp--;


            }

             after(grammarAccess.getEOperationDeclAccess().getETypeParametersAssignment_5_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__Group_5__2_in_rule__EOperationDecl__Group_5__18528);
            rule__EOperationDecl__Group_5__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EOperationDecl__Group_5__1


    // $ANTLR start rule__EOperationDecl__Group_5__2
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4282:1: rule__EOperationDecl__Group_5__2 : ( ( rule__EOperationDecl__Group_5_2__0 )* ) rule__EOperationDecl__Group_5__3 ;
    public final void rule__EOperationDecl__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4286:1: ( ( ( rule__EOperationDecl__Group_5_2__0 )* ) rule__EOperationDecl__Group_5__3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4287:1: ( ( rule__EOperationDecl__Group_5_2__0 )* ) rule__EOperationDecl__Group_5__3
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4287:1: ( ( rule__EOperationDecl__Group_5_2__0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4288:1: ( rule__EOperationDecl__Group_5_2__0 )*
            {
             before(grammarAccess.getEOperationDeclAccess().getGroup_5_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4289:1: ( rule__EOperationDecl__Group_5_2__0 )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==34) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4289:2: rule__EOperationDecl__Group_5_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__Group_5_2__0_in_rule__EOperationDecl__Group_5__28556);
            	    rule__EOperationDecl__Group_5_2__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);

             after(grammarAccess.getEOperationDeclAccess().getGroup_5_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__Group_5__3_in_rule__EOperationDecl__Group_5__28566);
            rule__EOperationDecl__Group_5__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EOperationDecl__Group_5__2


    // $ANTLR start rule__EOperationDecl__Group_5__3
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4300:1: rule__EOperationDecl__Group_5__3 : ( '>' ) ;
    public final void rule__EOperationDecl__Group_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4304:1: ( ( '>' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4305:1: ( '>' )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4305:1: ( '>' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4306:1: '>'
            {
             before(grammarAccess.getEOperationDeclAccess().getGreaterThanSignKeyword_5_3()); 
            match(input,36,FollowSets000.FOLLOW_36_in_rule__EOperationDecl__Group_5__38595); 
             after(grammarAccess.getEOperationDeclAccess().getGreaterThanSignKeyword_5_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EOperationDecl__Group_5__3


    // $ANTLR start rule__EOperationDecl__Group_5_2__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4327:1: rule__EOperationDecl__Group_5_2__0 : ( ',' ) rule__EOperationDecl__Group_5_2__1 ;
    public final void rule__EOperationDecl__Group_5_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4331:1: ( ( ',' ) rule__EOperationDecl__Group_5_2__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4332:1: ( ',' ) rule__EOperationDecl__Group_5_2__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4332:1: ( ',' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4333:1: ','
            {
             before(grammarAccess.getEOperationDeclAccess().getCommaKeyword_5_2_0()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__EOperationDecl__Group_5_2__08639); 
             after(grammarAccess.getEOperationDeclAccess().getCommaKeyword_5_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__Group_5_2__1_in_rule__EOperationDecl__Group_5_2__08649);
            rule__EOperationDecl__Group_5_2__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EOperationDecl__Group_5_2__0


    // $ANTLR start rule__EOperationDecl__Group_5_2__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4347:1: rule__EOperationDecl__Group_5_2__1 : ( ( rule__EOperationDecl__ETypeParametersAssignment_5_2_1 ) ) ;
    public final void rule__EOperationDecl__Group_5_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4351:1: ( ( ( rule__EOperationDecl__ETypeParametersAssignment_5_2_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4352:1: ( ( rule__EOperationDecl__ETypeParametersAssignment_5_2_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4352:1: ( ( rule__EOperationDecl__ETypeParametersAssignment_5_2_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4353:1: ( rule__EOperationDecl__ETypeParametersAssignment_5_2_1 )
            {
             before(grammarAccess.getEOperationDeclAccess().getETypeParametersAssignment_5_2_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4354:1: ( rule__EOperationDecl__ETypeParametersAssignment_5_2_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4354:2: rule__EOperationDecl__ETypeParametersAssignment_5_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__ETypeParametersAssignment_5_2_1_in_rule__EOperationDecl__Group_5_2__18677);
            rule__EOperationDecl__ETypeParametersAssignment_5_2_1();
            _fsp--;


            }

             after(grammarAccess.getEOperationDeclAccess().getETypeParametersAssignment_5_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EOperationDecl__Group_5_2__1


    // $ANTLR start rule__EOperationDecl__Group_7__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4368:1: rule__EOperationDecl__Group_7__0 : ( ( rule__EOperationDecl__EParametersAssignment_7_0 ) ) rule__EOperationDecl__Group_7__1 ;
    public final void rule__EOperationDecl__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4372:1: ( ( ( rule__EOperationDecl__EParametersAssignment_7_0 ) ) rule__EOperationDecl__Group_7__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4373:1: ( ( rule__EOperationDecl__EParametersAssignment_7_0 ) ) rule__EOperationDecl__Group_7__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4373:1: ( ( rule__EOperationDecl__EParametersAssignment_7_0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4374:1: ( rule__EOperationDecl__EParametersAssignment_7_0 )
            {
             before(grammarAccess.getEOperationDeclAccess().getEParametersAssignment_7_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4375:1: ( rule__EOperationDecl__EParametersAssignment_7_0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4375:2: rule__EOperationDecl__EParametersAssignment_7_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__EParametersAssignment_7_0_in_rule__EOperationDecl__Group_7__08715);
            rule__EOperationDecl__EParametersAssignment_7_0();
            _fsp--;


            }

             after(grammarAccess.getEOperationDeclAccess().getEParametersAssignment_7_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__Group_7__1_in_rule__EOperationDecl__Group_7__08724);
            rule__EOperationDecl__Group_7__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EOperationDecl__Group_7__0


    // $ANTLR start rule__EOperationDecl__Group_7__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4386:1: rule__EOperationDecl__Group_7__1 : ( ( rule__EOperationDecl__Group_7_1__0 )* ) ;
    public final void rule__EOperationDecl__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4390:1: ( ( ( rule__EOperationDecl__Group_7_1__0 )* ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4391:1: ( ( rule__EOperationDecl__Group_7_1__0 )* )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4391:1: ( ( rule__EOperationDecl__Group_7_1__0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4392:1: ( rule__EOperationDecl__Group_7_1__0 )*
            {
             before(grammarAccess.getEOperationDeclAccess().getGroup_7_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4393:1: ( rule__EOperationDecl__Group_7_1__0 )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==34) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4393:2: rule__EOperationDecl__Group_7_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__Group_7_1__0_in_rule__EOperationDecl__Group_7__18752);
            	    rule__EOperationDecl__Group_7_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop62;
                }
            } while (true);

             after(grammarAccess.getEOperationDeclAccess().getGroup_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EOperationDecl__Group_7__1


    // $ANTLR start rule__EOperationDecl__Group_7_1__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4407:1: rule__EOperationDecl__Group_7_1__0 : ( ',' ) rule__EOperationDecl__Group_7_1__1 ;
    public final void rule__EOperationDecl__Group_7_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4411:1: ( ( ',' ) rule__EOperationDecl__Group_7_1__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4412:1: ( ',' ) rule__EOperationDecl__Group_7_1__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4412:1: ( ',' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4413:1: ','
            {
             before(grammarAccess.getEOperationDeclAccess().getCommaKeyword_7_1_0()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__EOperationDecl__Group_7_1__08792); 
             after(grammarAccess.getEOperationDeclAccess().getCommaKeyword_7_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__Group_7_1__1_in_rule__EOperationDecl__Group_7_1__08802);
            rule__EOperationDecl__Group_7_1__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EOperationDecl__Group_7_1__0


    // $ANTLR start rule__EOperationDecl__Group_7_1__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4427:1: rule__EOperationDecl__Group_7_1__1 : ( ( rule__EOperationDecl__EParametersAssignment_7_1_1 ) ) ;
    public final void rule__EOperationDecl__Group_7_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4431:1: ( ( ( rule__EOperationDecl__EParametersAssignment_7_1_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4432:1: ( ( rule__EOperationDecl__EParametersAssignment_7_1_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4432:1: ( ( rule__EOperationDecl__EParametersAssignment_7_1_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4433:1: ( rule__EOperationDecl__EParametersAssignment_7_1_1 )
            {
             before(grammarAccess.getEOperationDeclAccess().getEParametersAssignment_7_1_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4434:1: ( rule__EOperationDecl__EParametersAssignment_7_1_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4434:2: rule__EOperationDecl__EParametersAssignment_7_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__EParametersAssignment_7_1_1_in_rule__EOperationDecl__Group_7_1__18830);
            rule__EOperationDecl__EParametersAssignment_7_1_1();
            _fsp--;


            }

             after(grammarAccess.getEOperationDeclAccess().getEParametersAssignment_7_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EOperationDecl__Group_7_1__1


    // $ANTLR start rule__EOperationDecl__Group_9__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4448:1: rule__EOperationDecl__Group_9__0 : ( 'throws' ) rule__EOperationDecl__Group_9__1 ;
    public final void rule__EOperationDecl__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4452:1: ( ( 'throws' ) rule__EOperationDecl__Group_9__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4453:1: ( 'throws' ) rule__EOperationDecl__Group_9__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4453:1: ( 'throws' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4454:1: 'throws'
            {
             before(grammarAccess.getEOperationDeclAccess().getThrowsKeyword_9_0()); 
            match(input,47,FollowSets000.FOLLOW_47_in_rule__EOperationDecl__Group_9__08869); 
             after(grammarAccess.getEOperationDeclAccess().getThrowsKeyword_9_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__Group_9__1_in_rule__EOperationDecl__Group_9__08879);
            rule__EOperationDecl__Group_9__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EOperationDecl__Group_9__0


    // $ANTLR start rule__EOperationDecl__Group_9__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4468:1: rule__EOperationDecl__Group_9__1 : ( ( rule__EOperationDecl__EGenericExceptionsAssignment_9_1 ) ) rule__EOperationDecl__Group_9__2 ;
    public final void rule__EOperationDecl__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4472:1: ( ( ( rule__EOperationDecl__EGenericExceptionsAssignment_9_1 ) ) rule__EOperationDecl__Group_9__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4473:1: ( ( rule__EOperationDecl__EGenericExceptionsAssignment_9_1 ) ) rule__EOperationDecl__Group_9__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4473:1: ( ( rule__EOperationDecl__EGenericExceptionsAssignment_9_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4474:1: ( rule__EOperationDecl__EGenericExceptionsAssignment_9_1 )
            {
             before(grammarAccess.getEOperationDeclAccess().getEGenericExceptionsAssignment_9_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4475:1: ( rule__EOperationDecl__EGenericExceptionsAssignment_9_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4475:2: rule__EOperationDecl__EGenericExceptionsAssignment_9_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__EGenericExceptionsAssignment_9_1_in_rule__EOperationDecl__Group_9__18907);
            rule__EOperationDecl__EGenericExceptionsAssignment_9_1();
            _fsp--;


            }

             after(grammarAccess.getEOperationDeclAccess().getEGenericExceptionsAssignment_9_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__Group_9__2_in_rule__EOperationDecl__Group_9__18916);
            rule__EOperationDecl__Group_9__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EOperationDecl__Group_9__1


    // $ANTLR start rule__EOperationDecl__Group_9__2
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4486:1: rule__EOperationDecl__Group_9__2 : ( ( rule__EOperationDecl__Group_9_2__0 )* ) ;
    public final void rule__EOperationDecl__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4490:1: ( ( ( rule__EOperationDecl__Group_9_2__0 )* ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4491:1: ( ( rule__EOperationDecl__Group_9_2__0 )* )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4491:1: ( ( rule__EOperationDecl__Group_9_2__0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4492:1: ( rule__EOperationDecl__Group_9_2__0 )*
            {
             before(grammarAccess.getEOperationDeclAccess().getGroup_9_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4493:1: ( rule__EOperationDecl__Group_9_2__0 )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==34) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4493:2: rule__EOperationDecl__Group_9_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__Group_9_2__0_in_rule__EOperationDecl__Group_9__28944);
            	    rule__EOperationDecl__Group_9_2__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop63;
                }
            } while (true);

             after(grammarAccess.getEOperationDeclAccess().getGroup_9_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EOperationDecl__Group_9__2


    // $ANTLR start rule__EOperationDecl__Group_9_2__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4509:1: rule__EOperationDecl__Group_9_2__0 : ( ',' ) rule__EOperationDecl__Group_9_2__1 ;
    public final void rule__EOperationDecl__Group_9_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4513:1: ( ( ',' ) rule__EOperationDecl__Group_9_2__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4514:1: ( ',' ) rule__EOperationDecl__Group_9_2__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4514:1: ( ',' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4515:1: ','
            {
             before(grammarAccess.getEOperationDeclAccess().getCommaKeyword_9_2_0()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__EOperationDecl__Group_9_2__08986); 
             after(grammarAccess.getEOperationDeclAccess().getCommaKeyword_9_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__Group_9_2__1_in_rule__EOperationDecl__Group_9_2__08996);
            rule__EOperationDecl__Group_9_2__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EOperationDecl__Group_9_2__0


    // $ANTLR start rule__EOperationDecl__Group_9_2__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4529:1: rule__EOperationDecl__Group_9_2__1 : ( ( rule__EOperationDecl__EGenericExceptionsAssignment_9_2_1 ) ) ;
    public final void rule__EOperationDecl__Group_9_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4533:1: ( ( ( rule__EOperationDecl__EGenericExceptionsAssignment_9_2_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4534:1: ( ( rule__EOperationDecl__EGenericExceptionsAssignment_9_2_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4534:1: ( ( rule__EOperationDecl__EGenericExceptionsAssignment_9_2_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4535:1: ( rule__EOperationDecl__EGenericExceptionsAssignment_9_2_1 )
            {
             before(grammarAccess.getEOperationDeclAccess().getEGenericExceptionsAssignment_9_2_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4536:1: ( rule__EOperationDecl__EGenericExceptionsAssignment_9_2_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4536:2: rule__EOperationDecl__EGenericExceptionsAssignment_9_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EOperationDecl__EGenericExceptionsAssignment_9_2_1_in_rule__EOperationDecl__Group_9_2__19024);
            rule__EOperationDecl__EGenericExceptionsAssignment_9_2_1();
            _fsp--;


            }

             after(grammarAccess.getEOperationDeclAccess().getEGenericExceptionsAssignment_9_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EOperationDecl__Group_9_2__1


    // $ANTLR start rule__EParameterDecl__Group__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4550:1: rule__EParameterDecl__Group__0 : ( ( rule__EParameterDecl__EAnnotationsAssignment_0 )* ) rule__EParameterDecl__Group__1 ;
    public final void rule__EParameterDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4554:1: ( ( ( rule__EParameterDecl__EAnnotationsAssignment_0 )* ) rule__EParameterDecl__Group__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4555:1: ( ( rule__EParameterDecl__EAnnotationsAssignment_0 )* ) rule__EParameterDecl__Group__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4555:1: ( ( rule__EParameterDecl__EAnnotationsAssignment_0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4556:1: ( rule__EParameterDecl__EAnnotationsAssignment_0 )*
            {
             before(grammarAccess.getEParameterDeclAccess().getEAnnotationsAssignment_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4557:1: ( rule__EParameterDecl__EAnnotationsAssignment_0 )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==31) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4557:2: rule__EParameterDecl__EAnnotationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__EParameterDecl__EAnnotationsAssignment_0_in_rule__EParameterDecl__Group__09062);
            	    rule__EParameterDecl__EAnnotationsAssignment_0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop64;
                }
            } while (true);

             after(grammarAccess.getEParameterDeclAccess().getEAnnotationsAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EParameterDecl__Group__1_in_rule__EParameterDecl__Group__09072);
            rule__EParameterDecl__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EParameterDecl__Group__0


    // $ANTLR start rule__EParameterDecl__Group__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4568:1: rule__EParameterDecl__Group__1 : ( ( rule__EParameterDecl__EGenericTypeAssignment_1 ) ) rule__EParameterDecl__Group__2 ;
    public final void rule__EParameterDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4572:1: ( ( ( rule__EParameterDecl__EGenericTypeAssignment_1 ) ) rule__EParameterDecl__Group__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4573:1: ( ( rule__EParameterDecl__EGenericTypeAssignment_1 ) ) rule__EParameterDecl__Group__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4573:1: ( ( rule__EParameterDecl__EGenericTypeAssignment_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4574:1: ( rule__EParameterDecl__EGenericTypeAssignment_1 )
            {
             before(grammarAccess.getEParameterDeclAccess().getEGenericTypeAssignment_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4575:1: ( rule__EParameterDecl__EGenericTypeAssignment_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4575:2: rule__EParameterDecl__EGenericTypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EParameterDecl__EGenericTypeAssignment_1_in_rule__EParameterDecl__Group__19100);
            rule__EParameterDecl__EGenericTypeAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getEParameterDeclAccess().getEGenericTypeAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EParameterDecl__Group__2_in_rule__EParameterDecl__Group__19109);
            rule__EParameterDecl__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EParameterDecl__Group__1


    // $ANTLR start rule__EParameterDecl__Group__2
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4586:1: rule__EParameterDecl__Group__2 : ( ( rule__EParameterDecl__NameAssignment_2 ) ) ;
    public final void rule__EParameterDecl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4590:1: ( ( ( rule__EParameterDecl__NameAssignment_2 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4591:1: ( ( rule__EParameterDecl__NameAssignment_2 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4591:1: ( ( rule__EParameterDecl__NameAssignment_2 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4592:1: ( rule__EParameterDecl__NameAssignment_2 )
            {
             before(grammarAccess.getEParameterDeclAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4593:1: ( rule__EParameterDecl__NameAssignment_2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4593:2: rule__EParameterDecl__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__EParameterDecl__NameAssignment_2_in_rule__EParameterDecl__Group__29137);
            rule__EParameterDecl__NameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getEParameterDeclAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EParameterDecl__Group__2


    // $ANTLR start rule__MapEntry__Group__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4609:1: rule__MapEntry__Group__0 : ( ( rule__MapEntry__KeyAssignment_0 ) ) rule__MapEntry__Group__1 ;
    public final void rule__MapEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4613:1: ( ( ( rule__MapEntry__KeyAssignment_0 ) ) rule__MapEntry__Group__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4614:1: ( ( rule__MapEntry__KeyAssignment_0 ) ) rule__MapEntry__Group__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4614:1: ( ( rule__MapEntry__KeyAssignment_0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4615:1: ( rule__MapEntry__KeyAssignment_0 )
            {
             before(grammarAccess.getMapEntryAccess().getKeyAssignment_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4616:1: ( rule__MapEntry__KeyAssignment_0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4616:2: rule__MapEntry__KeyAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__MapEntry__KeyAssignment_0_in_rule__MapEntry__Group__09177);
            rule__MapEntry__KeyAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getMapEntryAccess().getKeyAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__MapEntry__Group__1_in_rule__MapEntry__Group__09186);
            rule__MapEntry__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MapEntry__Group__0


    // $ANTLR start rule__MapEntry__Group__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4627:1: rule__MapEntry__Group__1 : ( '=' ) rule__MapEntry__Group__2 ;
    public final void rule__MapEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4631:1: ( ( '=' ) rule__MapEntry__Group__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4632:1: ( '=' ) rule__MapEntry__Group__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4632:1: ( '=' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4633:1: '='
            {
             before(grammarAccess.getMapEntryAccess().getEqualsSignKeyword_1()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__MapEntry__Group__19215); 
             after(grammarAccess.getMapEntryAccess().getEqualsSignKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__MapEntry__Group__2_in_rule__MapEntry__Group__19225);
            rule__MapEntry__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MapEntry__Group__1


    // $ANTLR start rule__MapEntry__Group__2
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4647:1: rule__MapEntry__Group__2 : ( ( rule__MapEntry__ValueAssignment_2 ) ) ;
    public final void rule__MapEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4651:1: ( ( ( rule__MapEntry__ValueAssignment_2 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4652:1: ( ( rule__MapEntry__ValueAssignment_2 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4652:1: ( ( rule__MapEntry__ValueAssignment_2 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4653:1: ( rule__MapEntry__ValueAssignment_2 )
            {
             before(grammarAccess.getMapEntryAccess().getValueAssignment_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4654:1: ( rule__MapEntry__ValueAssignment_2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4654:2: rule__MapEntry__ValueAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__MapEntry__ValueAssignment_2_in_rule__MapEntry__Group__29253);
            rule__MapEntry__ValueAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getMapEntryAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MapEntry__Group__2


    // $ANTLR start rule__QID__Group__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4670:1: rule__QID__Group__0 : ( RULE_ID ) rule__QID__Group__1 ;
    public final void rule__QID__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4674:1: ( ( RULE_ID ) rule__QID__Group__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4675:1: ( RULE_ID ) rule__QID__Group__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4675:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4676:1: RULE_ID
            {
             before(grammarAccess.getQIDAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__QID__Group__09293); 
             after(grammarAccess.getQIDAccess().getIDTerminalRuleCall_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__QID__Group__1_in_rule__QID__Group__09301);
            rule__QID__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__QID__Group__0


    // $ANTLR start rule__QID__Group__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4688:1: rule__QID__Group__1 : ( ( rule__QID__Group_1__0 )* ) ;
    public final void rule__QID__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4692:1: ( ( ( rule__QID__Group_1__0 )* ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4693:1: ( ( rule__QID__Group_1__0 )* )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4693:1: ( ( rule__QID__Group_1__0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4694:1: ( rule__QID__Group_1__0 )*
            {
             before(grammarAccess.getQIDAccess().getGroup_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4695:1: ( rule__QID__Group_1__0 )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( ((LA65_0>=19 && LA65_0<=20)) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4695:2: rule__QID__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__QID__Group_1__0_in_rule__QID__Group__19329);
            	    rule__QID__Group_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop65;
                }
            } while (true);

             after(grammarAccess.getQIDAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__QID__Group__1


    // $ANTLR start rule__QID__Group_1__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4709:1: rule__QID__Group_1__0 : ( ( rule__QID__Alternatives_1_0 ) ) rule__QID__Group_1__1 ;
    public final void rule__QID__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4713:1: ( ( ( rule__QID__Alternatives_1_0 ) ) rule__QID__Group_1__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4714:1: ( ( rule__QID__Alternatives_1_0 ) ) rule__QID__Group_1__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4714:1: ( ( rule__QID__Alternatives_1_0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4715:1: ( rule__QID__Alternatives_1_0 )
            {
             before(grammarAccess.getQIDAccess().getAlternatives_1_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4716:1: ( rule__QID__Alternatives_1_0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4716:2: rule__QID__Alternatives_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__QID__Alternatives_1_0_in_rule__QID__Group_1__09368);
            rule__QID__Alternatives_1_0();
            _fsp--;


            }

             after(grammarAccess.getQIDAccess().getAlternatives_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__QID__Group_1__1_in_rule__QID__Group_1__09377);
            rule__QID__Group_1__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__QID__Group_1__0


    // $ANTLR start rule__QID__Group_1__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4727:1: rule__QID__Group_1__1 : ( RULE_ID ) ;
    public final void rule__QID__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4731:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4732:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4732:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4733:1: RULE_ID
            {
             before(grammarAccess.getQIDAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__QID__Group_1__19405); 
             after(grammarAccess.getQIDAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__QID__Group_1__1


    // $ANTLR start rule__SINT__Group__0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4748:1: rule__SINT__Group__0 : ( ( '-' )? ) rule__SINT__Group__1 ;
    public final void rule__SINT__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4752:1: ( ( ( '-' )? ) rule__SINT__Group__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4753:1: ( ( '-' )? ) rule__SINT__Group__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4753:1: ( ( '-' )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4754:1: ( '-' )?
            {
             before(grammarAccess.getSINTAccess().getHyphenMinusKeyword_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4755:1: ( '-' )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==48) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4756:2: '-'
                    {
                    match(input,48,FollowSets000.FOLLOW_48_in_rule__SINT__Group__09444); 

                    }
                    break;

            }

             after(grammarAccess.getSINTAccess().getHyphenMinusKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__SINT__Group__1_in_rule__SINT__Group__09456);
            rule__SINT__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SINT__Group__0


    // $ANTLR start rule__SINT__Group__1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4768:1: rule__SINT__Group__1 : ( RULE_INT ) ;
    public final void rule__SINT__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4772:1: ( ( RULE_INT ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4773:1: ( RULE_INT )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4773:1: ( RULE_INT )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4774:1: RULE_INT
            {
             before(grammarAccess.getSINTAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__SINT__Group__19484); 
             after(grammarAccess.getSINTAccess().getINTTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SINT__Group__1


    // $ANTLR start rule__EcoreDsl__MetamodelDeclarationsAssignment_0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4789:1: rule__EcoreDsl__MetamodelDeclarationsAssignment_0 : ( ruleReferencedMetamodel ) ;
    public final void rule__EcoreDsl__MetamodelDeclarationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4793:1: ( ( ruleReferencedMetamodel ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4794:1: ( ruleReferencedMetamodel )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4794:1: ( ruleReferencedMetamodel )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4795:1: ruleReferencedMetamodel
            {
             before(grammarAccess.getEcoreDslAccess().getMetamodelDeclarationsReferencedMetamodelParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferencedMetamodel_in_rule__EcoreDsl__MetamodelDeclarationsAssignment_09521);
            ruleReferencedMetamodel();
            _fsp--;

             after(grammarAccess.getEcoreDslAccess().getMetamodelDeclarationsReferencedMetamodelParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EcoreDsl__MetamodelDeclarationsAssignment_0


    // $ANTLR start rule__EcoreDsl__PackageAssignment_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4804:1: rule__EcoreDsl__PackageAssignment_1 : ( ruleEPackageDecl ) ;
    public final void rule__EcoreDsl__PackageAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4808:1: ( ( ruleEPackageDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4809:1: ( ruleEPackageDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4809:1: ( ruleEPackageDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4810:1: ruleEPackageDecl
            {
             before(grammarAccess.getEcoreDslAccess().getPackageEPackageDeclParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEPackageDecl_in_rule__EcoreDsl__PackageAssignment_19552);
            ruleEPackageDecl();
            _fsp--;

             after(grammarAccess.getEcoreDslAccess().getPackageEPackageDeclParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EcoreDsl__PackageAssignment_1


    // $ANTLR start rule__ReferencedMetamodel__AliasAssignment_1_0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4819:1: rule__ReferencedMetamodel__AliasAssignment_1_0 : ( RULE_ID ) ;
    public final void rule__ReferencedMetamodel__AliasAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4823:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4824:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4824:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4825:1: RULE_ID
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAliasIDTerminalRuleCall_1_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ReferencedMetamodel__AliasAssignment_1_09583); 
             after(grammarAccess.getReferencedMetamodelAccess().getAliasIDTerminalRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ReferencedMetamodel__AliasAssignment_1_0


    // $ANTLR start rule__ReferencedMetamodel__EPackageAssignment_2
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4834:1: rule__ReferencedMetamodel__EPackageAssignment_2 : ( ( RULE_STRING ) ) ;
    public final void rule__ReferencedMetamodel__EPackageAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4838:1: ( ( ( RULE_STRING ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4839:1: ( ( RULE_STRING ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4839:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4840:1: ( RULE_STRING )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageCrossReference_2_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4841:1: ( RULE_STRING )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4842:1: RULE_STRING
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_2_0_1()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__ReferencedMetamodel__EPackageAssignment_29618); 
             after(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ReferencedMetamodel__EPackageAssignment_2


    // $ANTLR start rule__EPackageDecl__EAnnotationsAssignment_0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4853:1: rule__EPackageDecl__EAnnotationsAssignment_0 : ( ruleEAnnotationDecl ) ;
    public final void rule__EPackageDecl__EAnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4857:1: ( ( ruleEAnnotationDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4858:1: ( ruleEAnnotationDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4858:1: ( ruleEAnnotationDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4859:1: ruleEAnnotationDecl
            {
             before(grammarAccess.getEPackageDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEAnnotationDecl_in_rule__EPackageDecl__EAnnotationsAssignment_09653);
            ruleEAnnotationDecl();
            _fsp--;

             after(grammarAccess.getEPackageDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EPackageDecl__EAnnotationsAssignment_0


    // $ANTLR start rule__EPackageDecl__NameAssignment_2
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4868:1: rule__EPackageDecl__NameAssignment_2 : ( ruleQID ) ;
    public final void rule__EPackageDecl__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4872:1: ( ( ruleQID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4873:1: ( ruleQID )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4873:1: ( ruleQID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4874:1: ruleQID
            {
             before(grammarAccess.getEPackageDeclAccess().getNameQIDParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleQID_in_rule__EPackageDecl__NameAssignment_29684);
            ruleQID();
            _fsp--;

             after(grammarAccess.getEPackageDeclAccess().getNameQIDParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EPackageDecl__NameAssignment_2


    // $ANTLR start rule__EPackageDecl__NsURIAssignment_5
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4883:1: rule__EPackageDecl__NsURIAssignment_5 : ( RULE_STRING ) ;
    public final void rule__EPackageDecl__NsURIAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4887:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4888:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4888:1: ( RULE_STRING )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4889:1: RULE_STRING
            {
             before(grammarAccess.getEPackageDeclAccess().getNsURISTRINGTerminalRuleCall_5_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__EPackageDecl__NsURIAssignment_59715); 
             after(grammarAccess.getEPackageDeclAccess().getNsURISTRINGTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EPackageDecl__NsURIAssignment_5


    // $ANTLR start rule__EPackageDecl__NsPrefixAssignment_8
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4898:1: rule__EPackageDecl__NsPrefixAssignment_8 : ( ruleQID ) ;
    public final void rule__EPackageDecl__NsPrefixAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4902:1: ( ( ruleQID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4903:1: ( ruleQID )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4903:1: ( ruleQID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4904:1: ruleQID
            {
             before(grammarAccess.getEPackageDeclAccess().getNsPrefixQIDParserRuleCall_8_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleQID_in_rule__EPackageDecl__NsPrefixAssignment_89746);
            ruleQID();
            _fsp--;

             after(grammarAccess.getEPackageDeclAccess().getNsPrefixQIDParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EPackageDecl__NsPrefixAssignment_8


    // $ANTLR start rule__EPackageDecl__ESubpackagesAssignment_10_0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4913:1: rule__EPackageDecl__ESubpackagesAssignment_10_0 : ( ruleSubEPackageDecl ) ;
    public final void rule__EPackageDecl__ESubpackagesAssignment_10_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4917:1: ( ( ruleSubEPackageDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4918:1: ( ruleSubEPackageDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4918:1: ( ruleSubEPackageDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4919:1: ruleSubEPackageDecl
            {
             before(grammarAccess.getEPackageDeclAccess().getESubpackagesSubEPackageDeclParserRuleCall_10_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSubEPackageDecl_in_rule__EPackageDecl__ESubpackagesAssignment_10_09777);
            ruleSubEPackageDecl();
            _fsp--;

             after(grammarAccess.getEPackageDeclAccess().getESubpackagesSubEPackageDeclParserRuleCall_10_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EPackageDecl__ESubpackagesAssignment_10_0


    // $ANTLR start rule__EPackageDecl__EClassifiersAssignment_10_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4928:1: rule__EPackageDecl__EClassifiersAssignment_10_1 : ( ruleEClassifierDecl ) ;
    public final void rule__EPackageDecl__EClassifiersAssignment_10_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4932:1: ( ( ruleEClassifierDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4933:1: ( ruleEClassifierDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4933:1: ( ruleEClassifierDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4934:1: ruleEClassifierDecl
            {
             before(grammarAccess.getEPackageDeclAccess().getEClassifiersEClassifierDeclParserRuleCall_10_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEClassifierDecl_in_rule__EPackageDecl__EClassifiersAssignment_10_19808);
            ruleEClassifierDecl();
            _fsp--;

             after(grammarAccess.getEPackageDeclAccess().getEClassifiersEClassifierDeclParserRuleCall_10_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EPackageDecl__EClassifiersAssignment_10_1


    // $ANTLR start rule__SubEPackageDecl__EAnnotationsAssignment_0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4943:1: rule__SubEPackageDecl__EAnnotationsAssignment_0 : ( ruleEAnnotationDecl ) ;
    public final void rule__SubEPackageDecl__EAnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4947:1: ( ( ruleEAnnotationDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4948:1: ( ruleEAnnotationDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4948:1: ( ruleEAnnotationDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4949:1: ruleEAnnotationDecl
            {
             before(grammarAccess.getSubEPackageDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEAnnotationDecl_in_rule__SubEPackageDecl__EAnnotationsAssignment_09839);
            ruleEAnnotationDecl();
            _fsp--;

             after(grammarAccess.getSubEPackageDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SubEPackageDecl__EAnnotationsAssignment_0


    // $ANTLR start rule__SubEPackageDecl__NameAssignment_2
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4958:1: rule__SubEPackageDecl__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__SubEPackageDecl__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4962:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4963:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4963:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4964:1: RULE_ID
            {
             before(grammarAccess.getSubEPackageDeclAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__SubEPackageDecl__NameAssignment_29870); 
             after(grammarAccess.getSubEPackageDeclAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SubEPackageDecl__NameAssignment_2


    // $ANTLR start rule__SubEPackageDecl__ESubpackagesAssignment_4_0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4973:1: rule__SubEPackageDecl__ESubpackagesAssignment_4_0 : ( ruleSubEPackageDecl ) ;
    public final void rule__SubEPackageDecl__ESubpackagesAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4977:1: ( ( ruleSubEPackageDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4978:1: ( ruleSubEPackageDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4978:1: ( ruleSubEPackageDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4979:1: ruleSubEPackageDecl
            {
             before(grammarAccess.getSubEPackageDeclAccess().getESubpackagesSubEPackageDeclParserRuleCall_4_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSubEPackageDecl_in_rule__SubEPackageDecl__ESubpackagesAssignment_4_09901);
            ruleSubEPackageDecl();
            _fsp--;

             after(grammarAccess.getSubEPackageDeclAccess().getESubpackagesSubEPackageDeclParserRuleCall_4_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SubEPackageDecl__ESubpackagesAssignment_4_0


    // $ANTLR start rule__SubEPackageDecl__EClassifiersAssignment_4_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4988:1: rule__SubEPackageDecl__EClassifiersAssignment_4_1 : ( ruleEClassifierDecl ) ;
    public final void rule__SubEPackageDecl__EClassifiersAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4992:1: ( ( ruleEClassifierDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4993:1: ( ruleEClassifierDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4993:1: ( ruleEClassifierDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:4994:1: ruleEClassifierDecl
            {
             before(grammarAccess.getSubEPackageDeclAccess().getEClassifiersEClassifierDeclParserRuleCall_4_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEClassifierDecl_in_rule__SubEPackageDecl__EClassifiersAssignment_4_19932);
            ruleEClassifierDecl();
            _fsp--;

             after(grammarAccess.getSubEPackageDeclAccess().getEClassifiersEClassifierDeclParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SubEPackageDecl__EClassifiersAssignment_4_1


    // $ANTLR start rule__EDataTypeDecl__EAnnotationsAssignment_0_0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5003:1: rule__EDataTypeDecl__EAnnotationsAssignment_0_0 : ( ruleEAnnotationDecl ) ;
    public final void rule__EDataTypeDecl__EAnnotationsAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5007:1: ( ( ruleEAnnotationDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5008:1: ( ruleEAnnotationDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5008:1: ( ruleEAnnotationDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5009:1: ruleEAnnotationDecl
            {
             before(grammarAccess.getEDataTypeDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEAnnotationDecl_in_rule__EDataTypeDecl__EAnnotationsAssignment_0_09963);
            ruleEAnnotationDecl();
            _fsp--;

             after(grammarAccess.getEDataTypeDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EDataTypeDecl__EAnnotationsAssignment_0_0


    // $ANTLR start rule__EDataTypeDecl__SerializableAssignment_0_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5018:1: rule__EDataTypeDecl__SerializableAssignment_0_1 : ( RULE_SERIALIZABLE ) ;
    public final void rule__EDataTypeDecl__SerializableAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5022:1: ( ( RULE_SERIALIZABLE ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5023:1: ( RULE_SERIALIZABLE )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5023:1: ( RULE_SERIALIZABLE )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5024:1: RULE_SERIALIZABLE
            {
             before(grammarAccess.getEDataTypeDeclAccess().getSerializableSerializableTerminalRuleCall_0_1_0()); 
            match(input,RULE_SERIALIZABLE,FollowSets000.FOLLOW_RULE_SERIALIZABLE_in_rule__EDataTypeDecl__SerializableAssignment_0_19994); 
             after(grammarAccess.getEDataTypeDeclAccess().getSerializableSerializableTerminalRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EDataTypeDecl__SerializableAssignment_0_1


    // $ANTLR start rule__EDataTypeDecl__NameAssignment_0_2_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5033:1: rule__EDataTypeDecl__NameAssignment_0_2_1 : ( RULE_ID ) ;
    public final void rule__EDataTypeDecl__NameAssignment_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5037:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5038:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5038:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5039:1: RULE_ID
            {
             before(grammarAccess.getEDataTypeDeclAccess().getNameIDTerminalRuleCall_0_2_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EDataTypeDecl__NameAssignment_0_2_110025); 
             after(grammarAccess.getEDataTypeDeclAccess().getNameIDTerminalRuleCall_0_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EDataTypeDecl__NameAssignment_0_2_1


    // $ANTLR start rule__EDataTypeDecl__InstanceClassNameAssignment_0_2_3
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5048:1: rule__EDataTypeDecl__InstanceClassNameAssignment_0_2_3 : ( ruleSTRING_OR_QID ) ;
    public final void rule__EDataTypeDecl__InstanceClassNameAssignment_0_2_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5052:1: ( ( ruleSTRING_OR_QID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5053:1: ( ruleSTRING_OR_QID )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5053:1: ( ruleSTRING_OR_QID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5054:1: ruleSTRING_OR_QID
            {
             before(grammarAccess.getEDataTypeDeclAccess().getInstanceClassNameSTRING_OR_QIDParserRuleCall_0_2_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSTRING_OR_QID_in_rule__EDataTypeDecl__InstanceClassNameAssignment_0_2_310056);
            ruleSTRING_OR_QID();
            _fsp--;

             after(grammarAccess.getEDataTypeDeclAccess().getInstanceClassNameSTRING_OR_QIDParserRuleCall_0_2_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EDataTypeDecl__InstanceClassNameAssignment_0_2_3


    // $ANTLR start rule__EAnnotationDecl__SourceAssignment_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5063:1: rule__EAnnotationDecl__SourceAssignment_1 : ( ruleSTRING_OR_QID ) ;
    public final void rule__EAnnotationDecl__SourceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5067:1: ( ( ruleSTRING_OR_QID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5068:1: ( ruleSTRING_OR_QID )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5068:1: ( ruleSTRING_OR_QID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5069:1: ruleSTRING_OR_QID
            {
             before(grammarAccess.getEAnnotationDeclAccess().getSourceSTRING_OR_QIDParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSTRING_OR_QID_in_rule__EAnnotationDecl__SourceAssignment_110087);
            ruleSTRING_OR_QID();
            _fsp--;

             after(grammarAccess.getEAnnotationDeclAccess().getSourceSTRING_OR_QIDParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAnnotationDecl__SourceAssignment_1


    // $ANTLR start rule__EAnnotationDecl__DetailsAssignment_2_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5078:1: rule__EAnnotationDecl__DetailsAssignment_2_1 : ( ruleMapEntry ) ;
    public final void rule__EAnnotationDecl__DetailsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5082:1: ( ( ruleMapEntry ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5083:1: ( ruleMapEntry )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5083:1: ( ruleMapEntry )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5084:1: ruleMapEntry
            {
             before(grammarAccess.getEAnnotationDeclAccess().getDetailsMapEntryParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleMapEntry_in_rule__EAnnotationDecl__DetailsAssignment_2_110118);
            ruleMapEntry();
            _fsp--;

             after(grammarAccess.getEAnnotationDeclAccess().getDetailsMapEntryParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAnnotationDecl__DetailsAssignment_2_1


    // $ANTLR start rule__EAnnotationDecl__DetailsAssignment_2_2_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5093:1: rule__EAnnotationDecl__DetailsAssignment_2_2_1 : ( ruleMapEntry ) ;
    public final void rule__EAnnotationDecl__DetailsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5097:1: ( ( ruleMapEntry ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5098:1: ( ruleMapEntry )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5098:1: ( ruleMapEntry )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5099:1: ruleMapEntry
            {
             before(grammarAccess.getEAnnotationDeclAccess().getDetailsMapEntryParserRuleCall_2_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleMapEntry_in_rule__EAnnotationDecl__DetailsAssignment_2_2_110149);
            ruleMapEntry();
            _fsp--;

             after(grammarAccess.getEAnnotationDeclAccess().getDetailsMapEntryParserRuleCall_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAnnotationDecl__DetailsAssignment_2_2_1


    // $ANTLR start rule__EClassDecl__EAnnotationsAssignment_0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5108:1: rule__EClassDecl__EAnnotationsAssignment_0 : ( ruleEAnnotationDecl ) ;
    public final void rule__EClassDecl__EAnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5112:1: ( ( ruleEAnnotationDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5113:1: ( ruleEAnnotationDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5113:1: ( ruleEAnnotationDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5114:1: ruleEAnnotationDecl
            {
             before(grammarAccess.getEClassDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEAnnotationDecl_in_rule__EClassDecl__EAnnotationsAssignment_010180);
            ruleEAnnotationDecl();
            _fsp--;

             after(grammarAccess.getEClassDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EClassDecl__EAnnotationsAssignment_0


    // $ANTLR start rule__EClassDecl__AbstractAssignment_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5123:1: rule__EClassDecl__AbstractAssignment_1 : ( ( 'abstract' ) ) ;
    public final void rule__EClassDecl__AbstractAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5127:1: ( ( ( 'abstract' ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5128:1: ( ( 'abstract' ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5128:1: ( ( 'abstract' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5129:1: ( 'abstract' )
            {
             before(grammarAccess.getEClassDeclAccess().getAbstractAbstractKeyword_1_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5130:1: ( 'abstract' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5131:1: 'abstract'
            {
             before(grammarAccess.getEClassDeclAccess().getAbstractAbstractKeyword_1_0()); 
            match(input,49,FollowSets000.FOLLOW_49_in_rule__EClassDecl__AbstractAssignment_110216); 
             after(grammarAccess.getEClassDeclAccess().getAbstractAbstractKeyword_1_0()); 

            }

             after(grammarAccess.getEClassDeclAccess().getAbstractAbstractKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EClassDecl__AbstractAssignment_1


    // $ANTLR start rule__EClassDecl__InterfaceAssignment_2_0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5146:1: rule__EClassDecl__InterfaceAssignment_2_0 : ( ( 'interface' ) ) ;
    public final void rule__EClassDecl__InterfaceAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5150:1: ( ( ( 'interface' ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5151:1: ( ( 'interface' ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5151:1: ( ( 'interface' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5152:1: ( 'interface' )
            {
             before(grammarAccess.getEClassDeclAccess().getInterfaceInterfaceKeyword_2_0_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5153:1: ( 'interface' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5154:1: 'interface'
            {
             before(grammarAccess.getEClassDeclAccess().getInterfaceInterfaceKeyword_2_0_0()); 
            match(input,50,FollowSets000.FOLLOW_50_in_rule__EClassDecl__InterfaceAssignment_2_010260); 
             after(grammarAccess.getEClassDeclAccess().getInterfaceInterfaceKeyword_2_0_0()); 

            }

             after(grammarAccess.getEClassDeclAccess().getInterfaceInterfaceKeyword_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EClassDecl__InterfaceAssignment_2_0


    // $ANTLR start rule__EClassDecl__NameAssignment_3
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5169:1: rule__EClassDecl__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__EClassDecl__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5173:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5174:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5174:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5175:1: RULE_ID
            {
             before(grammarAccess.getEClassDeclAccess().getNameIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EClassDecl__NameAssignment_310299); 
             after(grammarAccess.getEClassDeclAccess().getNameIDTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EClassDecl__NameAssignment_3


    // $ANTLR start rule__EClassDecl__ETypeParametersAssignment_4_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5184:1: rule__EClassDecl__ETypeParametersAssignment_4_1 : ( ruleETypeParameterDecl ) ;
    public final void rule__EClassDecl__ETypeParametersAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5188:1: ( ( ruleETypeParameterDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5189:1: ( ruleETypeParameterDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5189:1: ( ruleETypeParameterDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5190:1: ruleETypeParameterDecl
            {
             before(grammarAccess.getEClassDeclAccess().getETypeParametersETypeParameterDeclParserRuleCall_4_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleETypeParameterDecl_in_rule__EClassDecl__ETypeParametersAssignment_4_110330);
            ruleETypeParameterDecl();
            _fsp--;

             after(grammarAccess.getEClassDeclAccess().getETypeParametersETypeParameterDeclParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EClassDecl__ETypeParametersAssignment_4_1


    // $ANTLR start rule__EClassDecl__ETypeParametersAssignment_4_2_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5199:1: rule__EClassDecl__ETypeParametersAssignment_4_2_1 : ( ruleETypeParameterDecl ) ;
    public final void rule__EClassDecl__ETypeParametersAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5203:1: ( ( ruleETypeParameterDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5204:1: ( ruleETypeParameterDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5204:1: ( ruleETypeParameterDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5205:1: ruleETypeParameterDecl
            {
             before(grammarAccess.getEClassDeclAccess().getETypeParametersETypeParameterDeclParserRuleCall_4_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleETypeParameterDecl_in_rule__EClassDecl__ETypeParametersAssignment_4_2_110361);
            ruleETypeParameterDecl();
            _fsp--;

             after(grammarAccess.getEClassDeclAccess().getETypeParametersETypeParameterDeclParserRuleCall_4_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EClassDecl__ETypeParametersAssignment_4_2_1


    // $ANTLR start rule__EClassDecl__EGenericSuperTypesAssignment_5_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5214:1: rule__EClassDecl__EGenericSuperTypesAssignment_5_1 : ( ruleEGenericTypeReferenceDecl ) ;
    public final void rule__EClassDecl__EGenericSuperTypesAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5218:1: ( ( ruleEGenericTypeReferenceDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5219:1: ( ruleEGenericTypeReferenceDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5219:1: ( ruleEGenericTypeReferenceDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5220:1: ruleEGenericTypeReferenceDecl
            {
             before(grammarAccess.getEClassDeclAccess().getEGenericSuperTypesEGenericTypeReferenceDeclParserRuleCall_5_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeReferenceDecl_in_rule__EClassDecl__EGenericSuperTypesAssignment_5_110392);
            ruleEGenericTypeReferenceDecl();
            _fsp--;

             after(grammarAccess.getEClassDeclAccess().getEGenericSuperTypesEGenericTypeReferenceDeclParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EClassDecl__EGenericSuperTypesAssignment_5_1


    // $ANTLR start rule__EClassDecl__EGenericSuperTypesAssignment_5_2_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5229:1: rule__EClassDecl__EGenericSuperTypesAssignment_5_2_1 : ( ruleEGenericTypeReferenceDecl ) ;
    public final void rule__EClassDecl__EGenericSuperTypesAssignment_5_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5233:1: ( ( ruleEGenericTypeReferenceDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5234:1: ( ruleEGenericTypeReferenceDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5234:1: ( ruleEGenericTypeReferenceDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5235:1: ruleEGenericTypeReferenceDecl
            {
             before(grammarAccess.getEClassDeclAccess().getEGenericSuperTypesEGenericTypeReferenceDeclParserRuleCall_5_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeReferenceDecl_in_rule__EClassDecl__EGenericSuperTypesAssignment_5_2_110423);
            ruleEGenericTypeReferenceDecl();
            _fsp--;

             after(grammarAccess.getEClassDeclAccess().getEGenericSuperTypesEGenericTypeReferenceDeclParserRuleCall_5_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EClassDecl__EGenericSuperTypesAssignment_5_2_1


    // $ANTLR start rule__EClassDecl__InstanceClassNameAssignment_6_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5244:1: rule__EClassDecl__InstanceClassNameAssignment_6_1 : ( ruleSTRING_OR_QID ) ;
    public final void rule__EClassDecl__InstanceClassNameAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5248:1: ( ( ruleSTRING_OR_QID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5249:1: ( ruleSTRING_OR_QID )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5249:1: ( ruleSTRING_OR_QID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5250:1: ruleSTRING_OR_QID
            {
             before(grammarAccess.getEClassDeclAccess().getInstanceClassNameSTRING_OR_QIDParserRuleCall_6_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSTRING_OR_QID_in_rule__EClassDecl__InstanceClassNameAssignment_6_110454);
            ruleSTRING_OR_QID();
            _fsp--;

             after(grammarAccess.getEClassDeclAccess().getInstanceClassNameSTRING_OR_QIDParserRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EClassDecl__InstanceClassNameAssignment_6_1


    // $ANTLR start rule__EClassDecl__EStructuralFeaturesAssignment_8_0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5259:1: rule__EClassDecl__EStructuralFeaturesAssignment_8_0 : ( ruleEStructuralFeatureDecl ) ;
    public final void rule__EClassDecl__EStructuralFeaturesAssignment_8_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5263:1: ( ( ruleEStructuralFeatureDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5264:1: ( ruleEStructuralFeatureDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5264:1: ( ruleEStructuralFeatureDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5265:1: ruleEStructuralFeatureDecl
            {
             before(grammarAccess.getEClassDeclAccess().getEStructuralFeaturesEStructuralFeatureDeclParserRuleCall_8_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEStructuralFeatureDecl_in_rule__EClassDecl__EStructuralFeaturesAssignment_8_010485);
            ruleEStructuralFeatureDecl();
            _fsp--;

             after(grammarAccess.getEClassDeclAccess().getEStructuralFeaturesEStructuralFeatureDeclParserRuleCall_8_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EClassDecl__EStructuralFeaturesAssignment_8_0


    // $ANTLR start rule__EClassDecl__EOperationsAssignment_8_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5274:1: rule__EClassDecl__EOperationsAssignment_8_1 : ( ruleEOperationDecl ) ;
    public final void rule__EClassDecl__EOperationsAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5278:1: ( ( ruleEOperationDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5279:1: ( ruleEOperationDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5279:1: ( ruleEOperationDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5280:1: ruleEOperationDecl
            {
             before(grammarAccess.getEClassDeclAccess().getEOperationsEOperationDeclParserRuleCall_8_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEOperationDecl_in_rule__EClassDecl__EOperationsAssignment_8_110516);
            ruleEOperationDecl();
            _fsp--;

             after(grammarAccess.getEClassDeclAccess().getEOperationsEOperationDeclParserRuleCall_8_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EClassDecl__EOperationsAssignment_8_1


    // $ANTLR start rule__EAttributeDecl__EAnnotationsAssignment_0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5289:1: rule__EAttributeDecl__EAnnotationsAssignment_0 : ( ruleEAnnotationDecl ) ;
    public final void rule__EAttributeDecl__EAnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5293:1: ( ( ruleEAnnotationDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5294:1: ( ruleEAnnotationDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5294:1: ( ruleEAnnotationDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5295:1: ruleEAnnotationDecl
            {
             before(grammarAccess.getEAttributeDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEAnnotationDecl_in_rule__EAttributeDecl__EAnnotationsAssignment_010547);
            ruleEAnnotationDecl();
            _fsp--;

             after(grammarAccess.getEAttributeDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAttributeDecl__EAnnotationsAssignment_0


    // $ANTLR start rule__EAttributeDecl__IDAssignment_1_0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5304:1: rule__EAttributeDecl__IDAssignment_1_0 : ( ( 'ID' ) ) ;
    public final void rule__EAttributeDecl__IDAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5308:1: ( ( ( 'ID' ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5309:1: ( ( 'ID' ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5309:1: ( ( 'ID' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5310:1: ( 'ID' )
            {
             before(grammarAccess.getEAttributeDeclAccess().getIDIDKeyword_1_0_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5311:1: ( 'ID' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5312:1: 'ID'
            {
             before(grammarAccess.getEAttributeDeclAccess().getIDIDKeyword_1_0_0()); 
            match(input,51,FollowSets000.FOLLOW_51_in_rule__EAttributeDecl__IDAssignment_1_010583); 
             after(grammarAccess.getEAttributeDeclAccess().getIDIDKeyword_1_0_0()); 

            }

             after(grammarAccess.getEAttributeDeclAccess().getIDIDKeyword_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAttributeDecl__IDAssignment_1_0


    // $ANTLR start rule__EAttributeDecl__UniqueAssignment_1_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5327:1: rule__EAttributeDecl__UniqueAssignment_1_1 : ( RULE_BAG ) ;
    public final void rule__EAttributeDecl__UniqueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5331:1: ( ( RULE_BAG ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5332:1: ( RULE_BAG )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5332:1: ( RULE_BAG )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5333:1: RULE_BAG
            {
             before(grammarAccess.getEAttributeDeclAccess().getUniqueBagTerminalRuleCall_1_1_0()); 
            match(input,RULE_BAG,FollowSets000.FOLLOW_RULE_BAG_in_rule__EAttributeDecl__UniqueAssignment_1_110622); 
             after(grammarAccess.getEAttributeDeclAccess().getUniqueBagTerminalRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAttributeDecl__UniqueAssignment_1_1


    // $ANTLR start rule__EAttributeDecl__OrderedAssignment_1_2
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5342:1: rule__EAttributeDecl__OrderedAssignment_1_2 : ( RULE_RANDOM ) ;
    public final void rule__EAttributeDecl__OrderedAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5346:1: ( ( RULE_RANDOM ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5347:1: ( RULE_RANDOM )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5347:1: ( RULE_RANDOM )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5348:1: RULE_RANDOM
            {
             before(grammarAccess.getEAttributeDeclAccess().getOrderedRandomTerminalRuleCall_1_2_0()); 
            match(input,RULE_RANDOM,FollowSets000.FOLLOW_RULE_RANDOM_in_rule__EAttributeDecl__OrderedAssignment_1_210653); 
             after(grammarAccess.getEAttributeDeclAccess().getOrderedRandomTerminalRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAttributeDecl__OrderedAssignment_1_2


    // $ANTLR start rule__EAttributeDecl__ChangeableAssignment_1_3
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5357:1: rule__EAttributeDecl__ChangeableAssignment_1_3 : ( RULE_READONLY ) ;
    public final void rule__EAttributeDecl__ChangeableAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5361:1: ( ( RULE_READONLY ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5362:1: ( RULE_READONLY )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5362:1: ( RULE_READONLY )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5363:1: RULE_READONLY
            {
             before(grammarAccess.getEAttributeDeclAccess().getChangeableReadonlyTerminalRuleCall_1_3_0()); 
            match(input,RULE_READONLY,FollowSets000.FOLLOW_RULE_READONLY_in_rule__EAttributeDecl__ChangeableAssignment_1_310684); 
             after(grammarAccess.getEAttributeDeclAccess().getChangeableReadonlyTerminalRuleCall_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAttributeDecl__ChangeableAssignment_1_3


    // $ANTLR start rule__EAttributeDecl__VolatileAssignment_1_4
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5372:1: rule__EAttributeDecl__VolatileAssignment_1_4 : ( ( 'volatile' ) ) ;
    public final void rule__EAttributeDecl__VolatileAssignment_1_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5376:1: ( ( ( 'volatile' ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5377:1: ( ( 'volatile' ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5377:1: ( ( 'volatile' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5378:1: ( 'volatile' )
            {
             before(grammarAccess.getEAttributeDeclAccess().getVolatileVolatileKeyword_1_4_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5379:1: ( 'volatile' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5380:1: 'volatile'
            {
             before(grammarAccess.getEAttributeDeclAccess().getVolatileVolatileKeyword_1_4_0()); 
            match(input,52,FollowSets000.FOLLOW_52_in_rule__EAttributeDecl__VolatileAssignment_1_410720); 
             after(grammarAccess.getEAttributeDeclAccess().getVolatileVolatileKeyword_1_4_0()); 

            }

             after(grammarAccess.getEAttributeDeclAccess().getVolatileVolatileKeyword_1_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAttributeDecl__VolatileAssignment_1_4


    // $ANTLR start rule__EAttributeDecl__TransientAssignment_1_5
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5395:1: rule__EAttributeDecl__TransientAssignment_1_5 : ( ( 'transient' ) ) ;
    public final void rule__EAttributeDecl__TransientAssignment_1_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5399:1: ( ( ( 'transient' ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5400:1: ( ( 'transient' ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5400:1: ( ( 'transient' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5401:1: ( 'transient' )
            {
             before(grammarAccess.getEAttributeDeclAccess().getTransientTransientKeyword_1_5_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5402:1: ( 'transient' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5403:1: 'transient'
            {
             before(grammarAccess.getEAttributeDeclAccess().getTransientTransientKeyword_1_5_0()); 
            match(input,53,FollowSets000.FOLLOW_53_in_rule__EAttributeDecl__TransientAssignment_1_510764); 
             after(grammarAccess.getEAttributeDeclAccess().getTransientTransientKeyword_1_5_0()); 

            }

             after(grammarAccess.getEAttributeDeclAccess().getTransientTransientKeyword_1_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAttributeDecl__TransientAssignment_1_5


    // $ANTLR start rule__EAttributeDecl__UnsettableAssignment_1_6
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5418:1: rule__EAttributeDecl__UnsettableAssignment_1_6 : ( ( 'unsettable' ) ) ;
    public final void rule__EAttributeDecl__UnsettableAssignment_1_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5422:1: ( ( ( 'unsettable' ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5423:1: ( ( 'unsettable' ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5423:1: ( ( 'unsettable' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5424:1: ( 'unsettable' )
            {
             before(grammarAccess.getEAttributeDeclAccess().getUnsettableUnsettableKeyword_1_6_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5425:1: ( 'unsettable' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5426:1: 'unsettable'
            {
             before(grammarAccess.getEAttributeDeclAccess().getUnsettableUnsettableKeyword_1_6_0()); 
            match(input,54,FollowSets000.FOLLOW_54_in_rule__EAttributeDecl__UnsettableAssignment_1_610808); 
             after(grammarAccess.getEAttributeDeclAccess().getUnsettableUnsettableKeyword_1_6_0()); 

            }

             after(grammarAccess.getEAttributeDeclAccess().getUnsettableUnsettableKeyword_1_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAttributeDecl__UnsettableAssignment_1_6


    // $ANTLR start rule__EAttributeDecl__DerivedAssignment_1_7
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5441:1: rule__EAttributeDecl__DerivedAssignment_1_7 : ( ( 'derived' ) ) ;
    public final void rule__EAttributeDecl__DerivedAssignment_1_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5445:1: ( ( ( 'derived' ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5446:1: ( ( 'derived' ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5446:1: ( ( 'derived' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5447:1: ( 'derived' )
            {
             before(grammarAccess.getEAttributeDeclAccess().getDerivedDerivedKeyword_1_7_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5448:1: ( 'derived' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5449:1: 'derived'
            {
             before(grammarAccess.getEAttributeDeclAccess().getDerivedDerivedKeyword_1_7_0()); 
            match(input,55,FollowSets000.FOLLOW_55_in_rule__EAttributeDecl__DerivedAssignment_1_710852); 
             after(grammarAccess.getEAttributeDeclAccess().getDerivedDerivedKeyword_1_7_0()); 

            }

             after(grammarAccess.getEAttributeDeclAccess().getDerivedDerivedKeyword_1_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAttributeDecl__DerivedAssignment_1_7


    // $ANTLR start rule__EAttributeDecl__EGenericTypeAssignment_3
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5464:1: rule__EAttributeDecl__EGenericTypeAssignment_3 : ( ruleEGenericTypeReferenceDecl ) ;
    public final void rule__EAttributeDecl__EGenericTypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5468:1: ( ( ruleEGenericTypeReferenceDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5469:1: ( ruleEGenericTypeReferenceDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5469:1: ( ruleEGenericTypeReferenceDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5470:1: ruleEGenericTypeReferenceDecl
            {
             before(grammarAccess.getEAttributeDeclAccess().getEGenericTypeEGenericTypeReferenceDeclParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeReferenceDecl_in_rule__EAttributeDecl__EGenericTypeAssignment_310891);
            ruleEGenericTypeReferenceDecl();
            _fsp--;

             after(grammarAccess.getEAttributeDeclAccess().getEGenericTypeEGenericTypeReferenceDeclParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAttributeDecl__EGenericTypeAssignment_3


    // $ANTLR start rule__EAttributeDecl__LowerBoundAssignment_4_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5479:1: rule__EAttributeDecl__LowerBoundAssignment_4_1 : ( RULE_INT ) ;
    public final void rule__EAttributeDecl__LowerBoundAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5483:1: ( ( RULE_INT ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5484:1: ( RULE_INT )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5484:1: ( RULE_INT )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5485:1: RULE_INT
            {
             before(grammarAccess.getEAttributeDeclAccess().getLowerBoundINTTerminalRuleCall_4_1_0()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__EAttributeDecl__LowerBoundAssignment_4_110922); 
             after(grammarAccess.getEAttributeDeclAccess().getLowerBoundINTTerminalRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAttributeDecl__LowerBoundAssignment_4_1


    // $ANTLR start rule__EAttributeDecl__UpperBoundAssignment_4_2_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5494:1: rule__EAttributeDecl__UpperBoundAssignment_4_2_1 : ( ruleSINT ) ;
    public final void rule__EAttributeDecl__UpperBoundAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5498:1: ( ( ruleSINT ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5499:1: ( ruleSINT )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5499:1: ( ruleSINT )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5500:1: ruleSINT
            {
             before(grammarAccess.getEAttributeDeclAccess().getUpperBoundSINTParserRuleCall_4_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSINT_in_rule__EAttributeDecl__UpperBoundAssignment_4_2_110953);
            ruleSINT();
            _fsp--;

             after(grammarAccess.getEAttributeDeclAccess().getUpperBoundSINTParserRuleCall_4_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAttributeDecl__UpperBoundAssignment_4_2_1


    // $ANTLR start rule__EAttributeDecl__NameAssignment_5
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5509:1: rule__EAttributeDecl__NameAssignment_5 : ( RULE_ID ) ;
    public final void rule__EAttributeDecl__NameAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5513:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5514:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5514:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5515:1: RULE_ID
            {
             before(grammarAccess.getEAttributeDeclAccess().getNameIDTerminalRuleCall_5_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EAttributeDecl__NameAssignment_510984); 
             after(grammarAccess.getEAttributeDeclAccess().getNameIDTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAttributeDecl__NameAssignment_5


    // $ANTLR start rule__EAttributeDecl__DefaultValueLiteralAssignment_6_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5524:1: rule__EAttributeDecl__DefaultValueLiteralAssignment_6_1 : ( RULE_STRING ) ;
    public final void rule__EAttributeDecl__DefaultValueLiteralAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5528:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5529:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5529:1: ( RULE_STRING )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5530:1: RULE_STRING
            {
             before(grammarAccess.getEAttributeDeclAccess().getDefaultValueLiteralSTRINGTerminalRuleCall_6_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__EAttributeDecl__DefaultValueLiteralAssignment_6_111015); 
             after(grammarAccess.getEAttributeDeclAccess().getDefaultValueLiteralSTRINGTerminalRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EAttributeDecl__DefaultValueLiteralAssignment_6_1


    // $ANTLR start rule__EReferenceDecl__EAnnotationsAssignment_0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5539:1: rule__EReferenceDecl__EAnnotationsAssignment_0 : ( ruleEAnnotationDecl ) ;
    public final void rule__EReferenceDecl__EAnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5543:1: ( ( ruleEAnnotationDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5544:1: ( ruleEAnnotationDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5544:1: ( ruleEAnnotationDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5545:1: ruleEAnnotationDecl
            {
             before(grammarAccess.getEReferenceDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEAnnotationDecl_in_rule__EReferenceDecl__EAnnotationsAssignment_011046);
            ruleEAnnotationDecl();
            _fsp--;

             after(grammarAccess.getEReferenceDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EReferenceDecl__EAnnotationsAssignment_0


    // $ANTLR start rule__EReferenceDecl__ResolveProxiesAssignment_1_0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5554:1: rule__EReferenceDecl__ResolveProxiesAssignment_1_0 : ( RULE_LOCAL ) ;
    public final void rule__EReferenceDecl__ResolveProxiesAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5558:1: ( ( RULE_LOCAL ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5559:1: ( RULE_LOCAL )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5559:1: ( RULE_LOCAL )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5560:1: RULE_LOCAL
            {
             before(grammarAccess.getEReferenceDeclAccess().getResolveProxiesLocalTerminalRuleCall_1_0_0()); 
            match(input,RULE_LOCAL,FollowSets000.FOLLOW_RULE_LOCAL_in_rule__EReferenceDecl__ResolveProxiesAssignment_1_011077); 
             after(grammarAccess.getEReferenceDeclAccess().getResolveProxiesLocalTerminalRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EReferenceDecl__ResolveProxiesAssignment_1_0


    // $ANTLR start rule__EReferenceDecl__UniqueAssignment_1_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5569:1: rule__EReferenceDecl__UniqueAssignment_1_1 : ( RULE_BAG ) ;
    public final void rule__EReferenceDecl__UniqueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5573:1: ( ( RULE_BAG ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5574:1: ( RULE_BAG )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5574:1: ( RULE_BAG )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5575:1: RULE_BAG
            {
             before(grammarAccess.getEReferenceDeclAccess().getUniqueBagTerminalRuleCall_1_1_0()); 
            match(input,RULE_BAG,FollowSets000.FOLLOW_RULE_BAG_in_rule__EReferenceDecl__UniqueAssignment_1_111108); 
             after(grammarAccess.getEReferenceDeclAccess().getUniqueBagTerminalRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EReferenceDecl__UniqueAssignment_1_1


    // $ANTLR start rule__EReferenceDecl__OrderedAssignment_1_2
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5584:1: rule__EReferenceDecl__OrderedAssignment_1_2 : ( RULE_RANDOM ) ;
    public final void rule__EReferenceDecl__OrderedAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5588:1: ( ( RULE_RANDOM ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5589:1: ( RULE_RANDOM )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5589:1: ( RULE_RANDOM )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5590:1: RULE_RANDOM
            {
             before(grammarAccess.getEReferenceDeclAccess().getOrderedRandomTerminalRuleCall_1_2_0()); 
            match(input,RULE_RANDOM,FollowSets000.FOLLOW_RULE_RANDOM_in_rule__EReferenceDecl__OrderedAssignment_1_211139); 
             after(grammarAccess.getEReferenceDeclAccess().getOrderedRandomTerminalRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EReferenceDecl__OrderedAssignment_1_2


    // $ANTLR start rule__EReferenceDecl__ChangeableAssignment_1_3
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5599:1: rule__EReferenceDecl__ChangeableAssignment_1_3 : ( RULE_READONLY ) ;
    public final void rule__EReferenceDecl__ChangeableAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5603:1: ( ( RULE_READONLY ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5604:1: ( RULE_READONLY )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5604:1: ( RULE_READONLY )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5605:1: RULE_READONLY
            {
             before(grammarAccess.getEReferenceDeclAccess().getChangeableReadonlyTerminalRuleCall_1_3_0()); 
            match(input,RULE_READONLY,FollowSets000.FOLLOW_RULE_READONLY_in_rule__EReferenceDecl__ChangeableAssignment_1_311170); 
             after(grammarAccess.getEReferenceDeclAccess().getChangeableReadonlyTerminalRuleCall_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EReferenceDecl__ChangeableAssignment_1_3


    // $ANTLR start rule__EReferenceDecl__VolatileAssignment_1_4
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5614:1: rule__EReferenceDecl__VolatileAssignment_1_4 : ( ( 'volatile' ) ) ;
    public final void rule__EReferenceDecl__VolatileAssignment_1_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5618:1: ( ( ( 'volatile' ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5619:1: ( ( 'volatile' ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5619:1: ( ( 'volatile' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5620:1: ( 'volatile' )
            {
             before(grammarAccess.getEReferenceDeclAccess().getVolatileVolatileKeyword_1_4_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5621:1: ( 'volatile' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5622:1: 'volatile'
            {
             before(grammarAccess.getEReferenceDeclAccess().getVolatileVolatileKeyword_1_4_0()); 
            match(input,52,FollowSets000.FOLLOW_52_in_rule__EReferenceDecl__VolatileAssignment_1_411206); 
             after(grammarAccess.getEReferenceDeclAccess().getVolatileVolatileKeyword_1_4_0()); 

            }

             after(grammarAccess.getEReferenceDeclAccess().getVolatileVolatileKeyword_1_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EReferenceDecl__VolatileAssignment_1_4


    // $ANTLR start rule__EReferenceDecl__TransientAssignment_1_5
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5637:1: rule__EReferenceDecl__TransientAssignment_1_5 : ( ( 'transient' ) ) ;
    public final void rule__EReferenceDecl__TransientAssignment_1_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5641:1: ( ( ( 'transient' ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5642:1: ( ( 'transient' ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5642:1: ( ( 'transient' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5643:1: ( 'transient' )
            {
             before(grammarAccess.getEReferenceDeclAccess().getTransientTransientKeyword_1_5_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5644:1: ( 'transient' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5645:1: 'transient'
            {
             before(grammarAccess.getEReferenceDeclAccess().getTransientTransientKeyword_1_5_0()); 
            match(input,53,FollowSets000.FOLLOW_53_in_rule__EReferenceDecl__TransientAssignment_1_511250); 
             after(grammarAccess.getEReferenceDeclAccess().getTransientTransientKeyword_1_5_0()); 

            }

             after(grammarAccess.getEReferenceDeclAccess().getTransientTransientKeyword_1_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EReferenceDecl__TransientAssignment_1_5


    // $ANTLR start rule__EReferenceDecl__UnsettableAssignment_1_6
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5660:1: rule__EReferenceDecl__UnsettableAssignment_1_6 : ( ( 'unsettable' ) ) ;
    public final void rule__EReferenceDecl__UnsettableAssignment_1_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5664:1: ( ( ( 'unsettable' ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5665:1: ( ( 'unsettable' ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5665:1: ( ( 'unsettable' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5666:1: ( 'unsettable' )
            {
             before(grammarAccess.getEReferenceDeclAccess().getUnsettableUnsettableKeyword_1_6_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5667:1: ( 'unsettable' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5668:1: 'unsettable'
            {
             before(grammarAccess.getEReferenceDeclAccess().getUnsettableUnsettableKeyword_1_6_0()); 
            match(input,54,FollowSets000.FOLLOW_54_in_rule__EReferenceDecl__UnsettableAssignment_1_611294); 
             after(grammarAccess.getEReferenceDeclAccess().getUnsettableUnsettableKeyword_1_6_0()); 

            }

             after(grammarAccess.getEReferenceDeclAccess().getUnsettableUnsettableKeyword_1_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EReferenceDecl__UnsettableAssignment_1_6


    // $ANTLR start rule__EReferenceDecl__DerivedAssignment_1_7
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5683:1: rule__EReferenceDecl__DerivedAssignment_1_7 : ( ( 'derived' ) ) ;
    public final void rule__EReferenceDecl__DerivedAssignment_1_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5687:1: ( ( ( 'derived' ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5688:1: ( ( 'derived' ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5688:1: ( ( 'derived' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5689:1: ( 'derived' )
            {
             before(grammarAccess.getEReferenceDeclAccess().getDerivedDerivedKeyword_1_7_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5690:1: ( 'derived' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5691:1: 'derived'
            {
             before(grammarAccess.getEReferenceDeclAccess().getDerivedDerivedKeyword_1_7_0()); 
            match(input,55,FollowSets000.FOLLOW_55_in_rule__EReferenceDecl__DerivedAssignment_1_711338); 
             after(grammarAccess.getEReferenceDeclAccess().getDerivedDerivedKeyword_1_7_0()); 

            }

             after(grammarAccess.getEReferenceDeclAccess().getDerivedDerivedKeyword_1_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EReferenceDecl__DerivedAssignment_1_7


    // $ANTLR start rule__EReferenceDecl__ContainmentAssignment_2_0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5706:1: rule__EReferenceDecl__ContainmentAssignment_2_0 : ( ( 'val' ) ) ;
    public final void rule__EReferenceDecl__ContainmentAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5710:1: ( ( ( 'val' ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5711:1: ( ( 'val' ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5711:1: ( ( 'val' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5712:1: ( 'val' )
            {
             before(grammarAccess.getEReferenceDeclAccess().getContainmentValKeyword_2_0_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5713:1: ( 'val' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5714:1: 'val'
            {
             before(grammarAccess.getEReferenceDeclAccess().getContainmentValKeyword_2_0_0()); 
            match(input,56,FollowSets000.FOLLOW_56_in_rule__EReferenceDecl__ContainmentAssignment_2_011382); 
             after(grammarAccess.getEReferenceDeclAccess().getContainmentValKeyword_2_0_0()); 

            }

             after(grammarAccess.getEReferenceDeclAccess().getContainmentValKeyword_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EReferenceDecl__ContainmentAssignment_2_0


    // $ANTLR start rule__EReferenceDecl__EGenericTypeAssignment_3
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5729:1: rule__EReferenceDecl__EGenericTypeAssignment_3 : ( ruleEGenericTypeReferenceDecl ) ;
    public final void rule__EReferenceDecl__EGenericTypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5733:1: ( ( ruleEGenericTypeReferenceDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5734:1: ( ruleEGenericTypeReferenceDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5734:1: ( ruleEGenericTypeReferenceDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5735:1: ruleEGenericTypeReferenceDecl
            {
             before(grammarAccess.getEReferenceDeclAccess().getEGenericTypeEGenericTypeReferenceDeclParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeReferenceDecl_in_rule__EReferenceDecl__EGenericTypeAssignment_311421);
            ruleEGenericTypeReferenceDecl();
            _fsp--;

             after(grammarAccess.getEReferenceDeclAccess().getEGenericTypeEGenericTypeReferenceDeclParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EReferenceDecl__EGenericTypeAssignment_3


    // $ANTLR start rule__EReferenceDecl__LowerBoundAssignment_4_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5744:1: rule__EReferenceDecl__LowerBoundAssignment_4_1 : ( RULE_INT ) ;
    public final void rule__EReferenceDecl__LowerBoundAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5748:1: ( ( RULE_INT ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5749:1: ( RULE_INT )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5749:1: ( RULE_INT )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5750:1: RULE_INT
            {
             before(grammarAccess.getEReferenceDeclAccess().getLowerBoundINTTerminalRuleCall_4_1_0()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__EReferenceDecl__LowerBoundAssignment_4_111452); 
             after(grammarAccess.getEReferenceDeclAccess().getLowerBoundINTTerminalRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EReferenceDecl__LowerBoundAssignment_4_1


    // $ANTLR start rule__EReferenceDecl__UpperBoundAssignment_4_2_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5759:1: rule__EReferenceDecl__UpperBoundAssignment_4_2_1 : ( ruleSINT ) ;
    public final void rule__EReferenceDecl__UpperBoundAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5763:1: ( ( ruleSINT ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5764:1: ( ruleSINT )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5764:1: ( ruleSINT )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5765:1: ruleSINT
            {
             before(grammarAccess.getEReferenceDeclAccess().getUpperBoundSINTParserRuleCall_4_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSINT_in_rule__EReferenceDecl__UpperBoundAssignment_4_2_111483);
            ruleSINT();
            _fsp--;

             after(grammarAccess.getEReferenceDeclAccess().getUpperBoundSINTParserRuleCall_4_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EReferenceDecl__UpperBoundAssignment_4_2_1


    // $ANTLR start rule__EReferenceDecl__EOppositeAssignment_5_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5774:1: rule__EReferenceDecl__EOppositeAssignment_5_1 : ( ( RULE_ID ) ) ;
    public final void rule__EReferenceDecl__EOppositeAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5778:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5779:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5779:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5780:1: ( RULE_ID )
            {
             before(grammarAccess.getEReferenceDeclAccess().getEOppositeEReferenceCrossReference_5_1_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5781:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5782:1: RULE_ID
            {
             before(grammarAccess.getEReferenceDeclAccess().getEOppositeEReferenceIDTerminalRuleCall_5_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EReferenceDecl__EOppositeAssignment_5_111518); 
             after(grammarAccess.getEReferenceDeclAccess().getEOppositeEReferenceIDTerminalRuleCall_5_1_0_1()); 

            }

             after(grammarAccess.getEReferenceDeclAccess().getEOppositeEReferenceCrossReference_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EReferenceDecl__EOppositeAssignment_5_1


    // $ANTLR start rule__EReferenceDecl__NameAssignment_6
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5793:1: rule__EReferenceDecl__NameAssignment_6 : ( RULE_ID ) ;
    public final void rule__EReferenceDecl__NameAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5797:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5798:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5798:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5799:1: RULE_ID
            {
             before(grammarAccess.getEReferenceDeclAccess().getNameIDTerminalRuleCall_6_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EReferenceDecl__NameAssignment_611553); 
             after(grammarAccess.getEReferenceDeclAccess().getNameIDTerminalRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EReferenceDecl__NameAssignment_6


    // $ANTLR start rule__EEnumDecl__EAnnotationsAssignment_0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5808:1: rule__EEnumDecl__EAnnotationsAssignment_0 : ( ruleEAnnotationDecl ) ;
    public final void rule__EEnumDecl__EAnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5812:1: ( ( ruleEAnnotationDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5813:1: ( ruleEAnnotationDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5813:1: ( ruleEAnnotationDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5814:1: ruleEAnnotationDecl
            {
             before(grammarAccess.getEEnumDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEAnnotationDecl_in_rule__EEnumDecl__EAnnotationsAssignment_011584);
            ruleEAnnotationDecl();
            _fsp--;

             after(grammarAccess.getEEnumDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EEnumDecl__EAnnotationsAssignment_0


    // $ANTLR start rule__EEnumDecl__NameAssignment_2
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5823:1: rule__EEnumDecl__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__EEnumDecl__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5827:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5828:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5828:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5829:1: RULE_ID
            {
             before(grammarAccess.getEEnumDeclAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EEnumDecl__NameAssignment_211615); 
             after(grammarAccess.getEEnumDeclAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EEnumDecl__NameAssignment_2


    // $ANTLR start rule__EEnumDecl__ELiteralsAssignment_4
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5838:1: rule__EEnumDecl__ELiteralsAssignment_4 : ( ruleEEnumLiteralDecl ) ;
    public final void rule__EEnumDecl__ELiteralsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5842:1: ( ( ruleEEnumLiteralDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5843:1: ( ruleEEnumLiteralDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5843:1: ( ruleEEnumLiteralDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5844:1: ruleEEnumLiteralDecl
            {
             before(grammarAccess.getEEnumDeclAccess().getELiteralsEEnumLiteralDeclParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEEnumLiteralDecl_in_rule__EEnumDecl__ELiteralsAssignment_411646);
            ruleEEnumLiteralDecl();
            _fsp--;

             after(grammarAccess.getEEnumDeclAccess().getELiteralsEEnumLiteralDeclParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EEnumDecl__ELiteralsAssignment_4


    // $ANTLR start rule__EEnumLiteralDecl__EAnnotationsAssignment_0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5853:1: rule__EEnumLiteralDecl__EAnnotationsAssignment_0 : ( ruleEAnnotationDecl ) ;
    public final void rule__EEnumLiteralDecl__EAnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5857:1: ( ( ruleEAnnotationDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5858:1: ( ruleEAnnotationDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5858:1: ( ruleEAnnotationDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5859:1: ruleEAnnotationDecl
            {
             before(grammarAccess.getEEnumLiteralDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEAnnotationDecl_in_rule__EEnumLiteralDecl__EAnnotationsAssignment_011677);
            ruleEAnnotationDecl();
            _fsp--;

             after(grammarAccess.getEEnumLiteralDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EEnumLiteralDecl__EAnnotationsAssignment_0


    // $ANTLR start rule__EEnumLiteralDecl__NameAssignment_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5868:1: rule__EEnumLiteralDecl__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__EEnumLiteralDecl__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5872:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5873:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5873:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5874:1: RULE_ID
            {
             before(grammarAccess.getEEnumLiteralDeclAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EEnumLiteralDecl__NameAssignment_111708); 
             after(grammarAccess.getEEnumLiteralDeclAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EEnumLiteralDecl__NameAssignment_1


    // $ANTLR start rule__EEnumLiteralDecl__ValueAssignment_2_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5883:1: rule__EEnumLiteralDecl__ValueAssignment_2_1 : ( RULE_INT ) ;
    public final void rule__EEnumLiteralDecl__ValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5887:1: ( ( RULE_INT ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5888:1: ( RULE_INT )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5888:1: ( RULE_INT )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5889:1: RULE_INT
            {
             before(grammarAccess.getEEnumLiteralDeclAccess().getValueINTTerminalRuleCall_2_1_0()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__EEnumLiteralDecl__ValueAssignment_2_111739); 
             after(grammarAccess.getEEnumLiteralDeclAccess().getValueINTTerminalRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EEnumLiteralDecl__ValueAssignment_2_1


    // $ANTLR start rule__EEnumLiteralDecl__LiteralAssignment_3
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5898:1: rule__EEnumLiteralDecl__LiteralAssignment_3 : ( RULE_STRING ) ;
    public final void rule__EEnumLiteralDecl__LiteralAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5902:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5903:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5903:1: ( RULE_STRING )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5904:1: RULE_STRING
            {
             before(grammarAccess.getEEnumLiteralDeclAccess().getLiteralSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__EEnumLiteralDecl__LiteralAssignment_311770); 
             after(grammarAccess.getEEnumLiteralDeclAccess().getLiteralSTRINGTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EEnumLiteralDecl__LiteralAssignment_3


    // $ANTLR start rule__ETypeParameterDecl__NameAssignment_0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5913:1: rule__ETypeParameterDecl__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__ETypeParameterDecl__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5917:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5918:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5918:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5919:1: RULE_ID
            {
             before(grammarAccess.getETypeParameterDeclAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ETypeParameterDecl__NameAssignment_011801); 
             after(grammarAccess.getETypeParameterDeclAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ETypeParameterDecl__NameAssignment_0


    // $ANTLR start rule__ETypeParameterDecl__EBoundsAssignment_1_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5928:1: rule__ETypeParameterDecl__EBoundsAssignment_1_1 : ( ruleEGenericTypeDecl ) ;
    public final void rule__ETypeParameterDecl__EBoundsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5932:1: ( ( ruleEGenericTypeDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5933:1: ( ruleEGenericTypeDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5933:1: ( ruleEGenericTypeDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5934:1: ruleEGenericTypeDecl
            {
             before(grammarAccess.getETypeParameterDeclAccess().getEBoundsEGenericTypeDeclParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeDecl_in_rule__ETypeParameterDecl__EBoundsAssignment_1_111832);
            ruleEGenericTypeDecl();
            _fsp--;

             after(grammarAccess.getETypeParameterDeclAccess().getEBoundsEGenericTypeDeclParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ETypeParameterDecl__EBoundsAssignment_1_1


    // $ANTLR start rule__EGenericTypeReferenceDecl__EClassifierAssignment_0_0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5943:1: rule__EGenericTypeReferenceDecl__EClassifierAssignment_0_0 : ( ( RULE_ID ) ) ;
    public final void rule__EGenericTypeReferenceDecl__EClassifierAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5947:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5948:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5948:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5949:1: ( RULE_ID )
            {
             before(grammarAccess.getEGenericTypeReferenceDeclAccess().getEClassifierEClassifierCrossReference_0_0_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5950:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5951:1: RULE_ID
            {
             before(grammarAccess.getEGenericTypeReferenceDeclAccess().getEClassifierEClassifierIDTerminalRuleCall_0_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EGenericTypeReferenceDecl__EClassifierAssignment_0_011867); 
             after(grammarAccess.getEGenericTypeReferenceDeclAccess().getEClassifierEClassifierIDTerminalRuleCall_0_0_0_1()); 

            }

             after(grammarAccess.getEGenericTypeReferenceDeclAccess().getEClassifierEClassifierCrossReference_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EGenericTypeReferenceDecl__EClassifierAssignment_0_0


    // $ANTLR start rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5962:1: rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_1 : ( ruleEGenericTypeDecl ) ;
    public final void rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5966:1: ( ( ruleEGenericTypeDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5967:1: ( ruleEGenericTypeDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5967:1: ( ruleEGenericTypeDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5968:1: ruleEGenericTypeDecl
            {
             before(grammarAccess.getEGenericTypeReferenceDeclAccess().getETypeArgumentsEGenericTypeDeclParserRuleCall_0_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeDecl_in_rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_111902);
            ruleEGenericTypeDecl();
            _fsp--;

             after(grammarAccess.getEGenericTypeReferenceDeclAccess().getETypeArgumentsEGenericTypeDeclParserRuleCall_0_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_1


    // $ANTLR start rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_2_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5977:1: rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_2_1 : ( ruleEGenericTypeDecl ) ;
    public final void rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5981:1: ( ( ruleEGenericTypeDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5982:1: ( ruleEGenericTypeDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5982:1: ( ruleEGenericTypeDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5983:1: ruleEGenericTypeDecl
            {
             before(grammarAccess.getEGenericTypeReferenceDeclAccess().getETypeArgumentsEGenericTypeDeclParserRuleCall_0_1_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeDecl_in_rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_2_111933);
            ruleEGenericTypeDecl();
            _fsp--;

             after(grammarAccess.getEGenericTypeReferenceDeclAccess().getETypeArgumentsEGenericTypeDeclParserRuleCall_0_1_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_2_1


    // $ANTLR start rule__EGenericTypeReferenceDecl__ETypeParameterAssignment_1_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5992:1: rule__EGenericTypeReferenceDecl__ETypeParameterAssignment_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__EGenericTypeReferenceDecl__ETypeParameterAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5996:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5997:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5997:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5998:1: ( RULE_ID )
            {
             before(grammarAccess.getEGenericTypeReferenceDeclAccess().getETypeParameterETypeParameterCrossReference_1_1_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:5999:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6000:1: RULE_ID
            {
             before(grammarAccess.getEGenericTypeReferenceDeclAccess().getETypeParameterETypeParameterIDTerminalRuleCall_1_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EGenericTypeReferenceDecl__ETypeParameterAssignment_1_111968); 
             after(grammarAccess.getEGenericTypeReferenceDeclAccess().getETypeParameterETypeParameterIDTerminalRuleCall_1_1_0_1()); 

            }

             after(grammarAccess.getEGenericTypeReferenceDeclAccess().getETypeParameterETypeParameterCrossReference_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EGenericTypeReferenceDecl__ETypeParameterAssignment_1_1


    // $ANTLR start rule__EGenericTypeDecl__EClassifierAssignment_0_0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6011:1: rule__EGenericTypeDecl__EClassifierAssignment_0_0 : ( ( RULE_ID ) ) ;
    public final void rule__EGenericTypeDecl__EClassifierAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6015:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6016:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6016:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6017:1: ( RULE_ID )
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getEClassifierEClassifierCrossReference_0_0_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6018:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6019:1: RULE_ID
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getEClassifierEClassifierIDTerminalRuleCall_0_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EGenericTypeDecl__EClassifierAssignment_0_012007); 
             after(grammarAccess.getEGenericTypeDeclAccess().getEClassifierEClassifierIDTerminalRuleCall_0_0_0_1()); 

            }

             after(grammarAccess.getEGenericTypeDeclAccess().getEClassifierEClassifierCrossReference_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EGenericTypeDecl__EClassifierAssignment_0_0


    // $ANTLR start rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6030:1: rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_1 : ( ruleEGenericTypeDecl ) ;
    public final void rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6034:1: ( ( ruleEGenericTypeDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6035:1: ( ruleEGenericTypeDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6035:1: ( ruleEGenericTypeDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6036:1: ruleEGenericTypeDecl
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getETypeArgumentsEGenericTypeDeclParserRuleCall_0_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeDecl_in_rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_112042);
            ruleEGenericTypeDecl();
            _fsp--;

             after(grammarAccess.getEGenericTypeDeclAccess().getETypeArgumentsEGenericTypeDeclParserRuleCall_0_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_1


    // $ANTLR start rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_2_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6045:1: rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_2_1 : ( ruleEGenericTypeDecl ) ;
    public final void rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6049:1: ( ( ruleEGenericTypeDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6050:1: ( ruleEGenericTypeDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6050:1: ( ruleEGenericTypeDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6051:1: ruleEGenericTypeDecl
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getETypeArgumentsEGenericTypeDeclParserRuleCall_0_1_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeDecl_in_rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_2_112073);
            ruleEGenericTypeDecl();
            _fsp--;

             after(grammarAccess.getEGenericTypeDeclAccess().getETypeArgumentsEGenericTypeDeclParserRuleCall_0_1_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_2_1


    // $ANTLR start rule__EGenericTypeDecl__ETypeParameterAssignment_1_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6060:1: rule__EGenericTypeDecl__ETypeParameterAssignment_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__EGenericTypeDecl__ETypeParameterAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6064:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6065:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6065:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6066:1: ( RULE_ID )
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getETypeParameterETypeParameterCrossReference_1_1_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6067:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6068:1: RULE_ID
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getETypeParameterETypeParameterIDTerminalRuleCall_1_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EGenericTypeDecl__ETypeParameterAssignment_1_112108); 
             after(grammarAccess.getEGenericTypeDeclAccess().getETypeParameterETypeParameterIDTerminalRuleCall_1_1_0_1()); 

            }

             after(grammarAccess.getEGenericTypeDeclAccess().getETypeParameterETypeParameterCrossReference_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EGenericTypeDecl__ETypeParameterAssignment_1_1


    // $ANTLR start rule__EGenericTypeDecl__EUpperBoundAssignment_2_1_0_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6079:1: rule__EGenericTypeDecl__EUpperBoundAssignment_2_1_0_1 : ( ruleEGenericTypeDecl ) ;
    public final void rule__EGenericTypeDecl__EUpperBoundAssignment_2_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6083:1: ( ( ruleEGenericTypeDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6084:1: ( ruleEGenericTypeDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6084:1: ( ruleEGenericTypeDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6085:1: ruleEGenericTypeDecl
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getEUpperBoundEGenericTypeDeclParserRuleCall_2_1_0_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeDecl_in_rule__EGenericTypeDecl__EUpperBoundAssignment_2_1_0_112143);
            ruleEGenericTypeDecl();
            _fsp--;

             after(grammarAccess.getEGenericTypeDeclAccess().getEUpperBoundEGenericTypeDeclParserRuleCall_2_1_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EGenericTypeDecl__EUpperBoundAssignment_2_1_0_1


    // $ANTLR start rule__EGenericTypeDecl__ELowerBoundAssignment_2_1_1_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6094:1: rule__EGenericTypeDecl__ELowerBoundAssignment_2_1_1_1 : ( ruleEGenericTypeDecl ) ;
    public final void rule__EGenericTypeDecl__ELowerBoundAssignment_2_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6098:1: ( ( ruleEGenericTypeDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6099:1: ( ruleEGenericTypeDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6099:1: ( ruleEGenericTypeDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6100:1: ruleEGenericTypeDecl
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getELowerBoundEGenericTypeDeclParserRuleCall_2_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeDecl_in_rule__EGenericTypeDecl__ELowerBoundAssignment_2_1_1_112174);
            ruleEGenericTypeDecl();
            _fsp--;

             after(grammarAccess.getEGenericTypeDeclAccess().getELowerBoundEGenericTypeDeclParserRuleCall_2_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EGenericTypeDecl__ELowerBoundAssignment_2_1_1_1


    // $ANTLR start rule__EOperationDecl__EAnnotationsAssignment_0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6109:1: rule__EOperationDecl__EAnnotationsAssignment_0 : ( ruleEAnnotationDecl ) ;
    public final void rule__EOperationDecl__EAnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6113:1: ( ( ruleEAnnotationDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6114:1: ( ruleEAnnotationDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6114:1: ( ruleEAnnotationDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6115:1: ruleEAnnotationDecl
            {
             before(grammarAccess.getEOperationDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEAnnotationDecl_in_rule__EOperationDecl__EAnnotationsAssignment_012205);
            ruleEAnnotationDecl();
            _fsp--;

             after(grammarAccess.getEOperationDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EOperationDecl__EAnnotationsAssignment_0


    // $ANTLR start rule__EOperationDecl__UniqueAssignment_1_0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6124:1: rule__EOperationDecl__UniqueAssignment_1_0 : ( RULE_BAG ) ;
    public final void rule__EOperationDecl__UniqueAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6128:1: ( ( RULE_BAG ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6129:1: ( RULE_BAG )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6129:1: ( RULE_BAG )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6130:1: RULE_BAG
            {
             before(grammarAccess.getEOperationDeclAccess().getUniqueBagTerminalRuleCall_1_0_0()); 
            match(input,RULE_BAG,FollowSets000.FOLLOW_RULE_BAG_in_rule__EOperationDecl__UniqueAssignment_1_012236); 
             after(grammarAccess.getEOperationDeclAccess().getUniqueBagTerminalRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EOperationDecl__UniqueAssignment_1_0


    // $ANTLR start rule__EOperationDecl__OrderedAssignment_1_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6139:1: rule__EOperationDecl__OrderedAssignment_1_1 : ( RULE_RANDOM ) ;
    public final void rule__EOperationDecl__OrderedAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6143:1: ( ( RULE_RANDOM ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6144:1: ( RULE_RANDOM )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6144:1: ( RULE_RANDOM )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6145:1: RULE_RANDOM
            {
             before(grammarAccess.getEOperationDeclAccess().getOrderedRandomTerminalRuleCall_1_1_0()); 
            match(input,RULE_RANDOM,FollowSets000.FOLLOW_RULE_RANDOM_in_rule__EOperationDecl__OrderedAssignment_1_112267); 
             after(grammarAccess.getEOperationDeclAccess().getOrderedRandomTerminalRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EOperationDecl__OrderedAssignment_1_1


    // $ANTLR start rule__EOperationDecl__EGenericTypeAssignment_3_0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6154:1: rule__EOperationDecl__EGenericTypeAssignment_3_0 : ( ruleEGenericTypeReferenceDecl ) ;
    public final void rule__EOperationDecl__EGenericTypeAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6158:1: ( ( ruleEGenericTypeReferenceDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6159:1: ( ruleEGenericTypeReferenceDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6159:1: ( ruleEGenericTypeReferenceDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6160:1: ruleEGenericTypeReferenceDecl
            {
             before(grammarAccess.getEOperationDeclAccess().getEGenericTypeEGenericTypeReferenceDeclParserRuleCall_3_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeReferenceDecl_in_rule__EOperationDecl__EGenericTypeAssignment_3_012298);
            ruleEGenericTypeReferenceDecl();
            _fsp--;

             after(grammarAccess.getEOperationDeclAccess().getEGenericTypeEGenericTypeReferenceDeclParserRuleCall_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EOperationDecl__EGenericTypeAssignment_3_0


    // $ANTLR start rule__EOperationDecl__NameAssignment_4
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6169:1: rule__EOperationDecl__NameAssignment_4 : ( RULE_ID ) ;
    public final void rule__EOperationDecl__NameAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6173:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6174:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6174:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6175:1: RULE_ID
            {
             before(grammarAccess.getEOperationDeclAccess().getNameIDTerminalRuleCall_4_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EOperationDecl__NameAssignment_412329); 
             after(grammarAccess.getEOperationDeclAccess().getNameIDTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EOperationDecl__NameAssignment_4


    // $ANTLR start rule__EOperationDecl__ETypeParametersAssignment_5_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6184:1: rule__EOperationDecl__ETypeParametersAssignment_5_1 : ( ruleETypeParameterDecl ) ;
    public final void rule__EOperationDecl__ETypeParametersAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6188:1: ( ( ruleETypeParameterDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6189:1: ( ruleETypeParameterDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6189:1: ( ruleETypeParameterDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6190:1: ruleETypeParameterDecl
            {
             before(grammarAccess.getEOperationDeclAccess().getETypeParametersETypeParameterDeclParserRuleCall_5_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleETypeParameterDecl_in_rule__EOperationDecl__ETypeParametersAssignment_5_112360);
            ruleETypeParameterDecl();
            _fsp--;

             after(grammarAccess.getEOperationDeclAccess().getETypeParametersETypeParameterDeclParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EOperationDecl__ETypeParametersAssignment_5_1


    // $ANTLR start rule__EOperationDecl__ETypeParametersAssignment_5_2_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6199:1: rule__EOperationDecl__ETypeParametersAssignment_5_2_1 : ( ruleETypeParameterDecl ) ;
    public final void rule__EOperationDecl__ETypeParametersAssignment_5_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6203:1: ( ( ruleETypeParameterDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6204:1: ( ruleETypeParameterDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6204:1: ( ruleETypeParameterDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6205:1: ruleETypeParameterDecl
            {
             before(grammarAccess.getEOperationDeclAccess().getETypeParametersETypeParameterDeclParserRuleCall_5_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleETypeParameterDecl_in_rule__EOperationDecl__ETypeParametersAssignment_5_2_112391);
            ruleETypeParameterDecl();
            _fsp--;

             after(grammarAccess.getEOperationDeclAccess().getETypeParametersETypeParameterDeclParserRuleCall_5_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EOperationDecl__ETypeParametersAssignment_5_2_1


    // $ANTLR start rule__EOperationDecl__EParametersAssignment_7_0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6214:1: rule__EOperationDecl__EParametersAssignment_7_0 : ( ruleEParameterDecl ) ;
    public final void rule__EOperationDecl__EParametersAssignment_7_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6218:1: ( ( ruleEParameterDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6219:1: ( ruleEParameterDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6219:1: ( ruleEParameterDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6220:1: ruleEParameterDecl
            {
             before(grammarAccess.getEOperationDeclAccess().getEParametersEParameterDeclParserRuleCall_7_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEParameterDecl_in_rule__EOperationDecl__EParametersAssignment_7_012422);
            ruleEParameterDecl();
            _fsp--;

             after(grammarAccess.getEOperationDeclAccess().getEParametersEParameterDeclParserRuleCall_7_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EOperationDecl__EParametersAssignment_7_0


    // $ANTLR start rule__EOperationDecl__EParametersAssignment_7_1_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6229:1: rule__EOperationDecl__EParametersAssignment_7_1_1 : ( ruleEParameterDecl ) ;
    public final void rule__EOperationDecl__EParametersAssignment_7_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6233:1: ( ( ruleEParameterDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6234:1: ( ruleEParameterDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6234:1: ( ruleEParameterDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6235:1: ruleEParameterDecl
            {
             before(grammarAccess.getEOperationDeclAccess().getEParametersEParameterDeclParserRuleCall_7_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEParameterDecl_in_rule__EOperationDecl__EParametersAssignment_7_1_112453);
            ruleEParameterDecl();
            _fsp--;

             after(grammarAccess.getEOperationDeclAccess().getEParametersEParameterDeclParserRuleCall_7_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EOperationDecl__EParametersAssignment_7_1_1


    // $ANTLR start rule__EOperationDecl__EGenericExceptionsAssignment_9_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6244:1: rule__EOperationDecl__EGenericExceptionsAssignment_9_1 : ( ruleEGenericTypeReferenceDecl ) ;
    public final void rule__EOperationDecl__EGenericExceptionsAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6248:1: ( ( ruleEGenericTypeReferenceDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6249:1: ( ruleEGenericTypeReferenceDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6249:1: ( ruleEGenericTypeReferenceDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6250:1: ruleEGenericTypeReferenceDecl
            {
             before(grammarAccess.getEOperationDeclAccess().getEGenericExceptionsEGenericTypeReferenceDeclParserRuleCall_9_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeReferenceDecl_in_rule__EOperationDecl__EGenericExceptionsAssignment_9_112484);
            ruleEGenericTypeReferenceDecl();
            _fsp--;

             after(grammarAccess.getEOperationDeclAccess().getEGenericExceptionsEGenericTypeReferenceDeclParserRuleCall_9_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EOperationDecl__EGenericExceptionsAssignment_9_1


    // $ANTLR start rule__EOperationDecl__EGenericExceptionsAssignment_9_2_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6259:1: rule__EOperationDecl__EGenericExceptionsAssignment_9_2_1 : ( ruleEGenericTypeReferenceDecl ) ;
    public final void rule__EOperationDecl__EGenericExceptionsAssignment_9_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6263:1: ( ( ruleEGenericTypeReferenceDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6264:1: ( ruleEGenericTypeReferenceDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6264:1: ( ruleEGenericTypeReferenceDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6265:1: ruleEGenericTypeReferenceDecl
            {
             before(grammarAccess.getEOperationDeclAccess().getEGenericExceptionsEGenericTypeReferenceDeclParserRuleCall_9_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeReferenceDecl_in_rule__EOperationDecl__EGenericExceptionsAssignment_9_2_112515);
            ruleEGenericTypeReferenceDecl();
            _fsp--;

             after(grammarAccess.getEOperationDeclAccess().getEGenericExceptionsEGenericTypeReferenceDeclParserRuleCall_9_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EOperationDecl__EGenericExceptionsAssignment_9_2_1


    // $ANTLR start rule__EParameterDecl__EAnnotationsAssignment_0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6274:1: rule__EParameterDecl__EAnnotationsAssignment_0 : ( ruleEAnnotationDecl ) ;
    public final void rule__EParameterDecl__EAnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6278:1: ( ( ruleEAnnotationDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6279:1: ( ruleEAnnotationDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6279:1: ( ruleEAnnotationDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6280:1: ruleEAnnotationDecl
            {
             before(grammarAccess.getEParameterDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEAnnotationDecl_in_rule__EParameterDecl__EAnnotationsAssignment_012546);
            ruleEAnnotationDecl();
            _fsp--;

             after(grammarAccess.getEParameterDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EParameterDecl__EAnnotationsAssignment_0


    // $ANTLR start rule__EParameterDecl__EGenericTypeAssignment_1
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6289:1: rule__EParameterDecl__EGenericTypeAssignment_1 : ( ruleEGenericTypeReferenceDecl ) ;
    public final void rule__EParameterDecl__EGenericTypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6293:1: ( ( ruleEGenericTypeReferenceDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6294:1: ( ruleEGenericTypeReferenceDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6294:1: ( ruleEGenericTypeReferenceDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6295:1: ruleEGenericTypeReferenceDecl
            {
             before(grammarAccess.getEParameterDeclAccess().getEGenericTypeEGenericTypeReferenceDeclParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeReferenceDecl_in_rule__EParameterDecl__EGenericTypeAssignment_112577);
            ruleEGenericTypeReferenceDecl();
            _fsp--;

             after(grammarAccess.getEParameterDeclAccess().getEGenericTypeEGenericTypeReferenceDeclParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EParameterDecl__EGenericTypeAssignment_1


    // $ANTLR start rule__EParameterDecl__NameAssignment_2
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6304:1: rule__EParameterDecl__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__EParameterDecl__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6308:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6309:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6309:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6310:1: RULE_ID
            {
             before(grammarAccess.getEParameterDeclAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EParameterDecl__NameAssignment_212608); 
             after(grammarAccess.getEParameterDeclAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EParameterDecl__NameAssignment_2


    // $ANTLR start rule__MapEntry__KeyAssignment_0
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6319:1: rule__MapEntry__KeyAssignment_0 : ( RULE_ID ) ;
    public final void rule__MapEntry__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6323:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6324:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6324:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6325:1: RULE_ID
            {
             before(grammarAccess.getMapEntryAccess().getKeyIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__MapEntry__KeyAssignment_012639); 
             after(grammarAccess.getMapEntryAccess().getKeyIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MapEntry__KeyAssignment_0


    // $ANTLR start rule__MapEntry__ValueAssignment_2
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6334:1: rule__MapEntry__ValueAssignment_2 : ( RULE_STRING ) ;
    public final void rule__MapEntry__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6338:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6339:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6339:1: ( RULE_STRING )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6340:1: RULE_STRING
            {
             before(grammarAccess.getMapEntryAccess().getValueSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__MapEntry__ValueAssignment_212670); 
             after(grammarAccess.getMapEntryAccess().getValueSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MapEntry__ValueAssignment_2


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA2 dfa2 = new DFA2(this);
    protected DFA3 dfa3 = new DFA3(this);
    protected DFA4 dfa4 = new DFA4(this);
    protected DFA6 dfa6 = new DFA6(this);
    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA1_eotS =
        "\22\uffff";
    static final String DFA1_eofS =
        "\22\uffff";
    static final String DFA1_minS =
        "\1\7\1\4\2\uffff\2\7\3\5\1\27\1\7\1\4\1\41\1\5\1\7\1\27\1\4\1\41";
    static final String DFA1_maxS =
        "\1\62\1\5\2\uffff\2\62\3\5\1\27\1\62\1\4\1\42\1\5\1\62\1\27\1\4"+
        "\1\42";
    static final String DFA1_acceptS =
        "\2\uffff\1\1\1\2\16\uffff";
    static final String DFA1_specialS =
        "\22\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\3\10\uffff\1\3\7\uffff\1\2\4\uffff\1\3\1\uffff\1\1\13\uffff"+
            "\1\3\5\uffff\2\3",
            "\1\4\1\5",
            "",
            "",
            "\1\3\10\uffff\1\3\7\uffff\1\2\4\uffff\1\3\1\uffff\1\1\1\6\12"+
            "\uffff\1\3\5\uffff\2\3",
            "\1\3\10\uffff\1\3\2\uffff\1\7\1\10\3\uffff\1\2\4\uffff\1\3\1"+
            "\uffff\1\1\1\6\12\uffff\1\3\5\uffff\2\3",
            "\1\11",
            "\1\12",
            "\1\12",
            "\1\13",
            "\1\3\10\uffff\1\3\2\uffff\1\7\1\10\3\uffff\1\2\4\uffff\1\3\1"+
            "\uffff\1\1\1\6\12\uffff\1\3\5\uffff\2\3",
            "\1\14",
            "\1\16\1\15",
            "\1\17",
            "\1\3\10\uffff\1\3\7\uffff\1\2\4\uffff\1\3\1\uffff\1\1\13\uffff"+
            "\1\3\5\uffff\2\3",
            "\1\20",
            "\1\21",
            "\1\16\1\15"
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "654:1: rule__EPackageDecl__Alternatives_10 : ( ( ( rule__EPackageDecl__ESubpackagesAssignment_10_0 ) ) | ( ( rule__EPackageDecl__EClassifiersAssignment_10_1 ) ) );";
        }
    }
    static final String DFA2_eotS =
        "\22\uffff";
    static final String DFA2_eofS =
        "\22\uffff";
    static final String DFA2_minS =
        "\1\7\1\4\2\uffff\2\7\3\5\1\27\1\7\1\4\1\41\1\5\1\7\1\27\1\4\1\41";
    static final String DFA2_maxS =
        "\1\62\1\5\2\uffff\2\62\3\5\1\27\1\62\1\4\1\42\1\5\1\62\1\27\1\4"+
        "\1\42";
    static final String DFA2_acceptS =
        "\2\uffff\1\1\1\2\16\uffff";
    static final String DFA2_specialS =
        "\22\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\3\10\uffff\1\3\7\uffff\1\2\4\uffff\1\3\1\uffff\1\1\13\uffff"+
            "\1\3\5\uffff\2\3",
            "\1\4\1\5",
            "",
            "",
            "\1\3\10\uffff\1\3\7\uffff\1\2\4\uffff\1\3\1\uffff\1\1\1\6\12"+
            "\uffff\1\3\5\uffff\2\3",
            "\1\3\10\uffff\1\3\2\uffff\1\7\1\10\3\uffff\1\2\4\uffff\1\3\1"+
            "\uffff\1\1\1\6\12\uffff\1\3\5\uffff\2\3",
            "\1\11",
            "\1\12",
            "\1\12",
            "\1\13",
            "\1\3\10\uffff\1\3\2\uffff\1\7\1\10\3\uffff\1\2\4\uffff\1\3\1"+
            "\uffff\1\1\1\6\12\uffff\1\3\5\uffff\2\3",
            "\1\14",
            "\1\16\1\15",
            "\1\17",
            "\1\3\10\uffff\1\3\7\uffff\1\2\4\uffff\1\3\1\uffff\1\1\13\uffff"+
            "\1\3\5\uffff\2\3",
            "\1\20",
            "\1\21",
            "\1\16\1\15"
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "676:1: rule__SubEPackageDecl__Alternatives_4 : ( ( ( rule__SubEPackageDecl__ESubpackagesAssignment_4_0 ) ) | ( ( rule__SubEPackageDecl__EClassifiersAssignment_4_1 ) ) );";
        }
    }
    static final String DFA3_eotS =
        "\22\uffff";
    static final String DFA3_eofS =
        "\22\uffff";
    static final String DFA3_minS =
        "\1\7\1\4\2\uffff\2\7\3\5\1\27\1\7\1\4\1\41\1\5\1\7\1\27\1\4\1\41";
    static final String DFA3_maxS =
        "\1\62\1\5\2\uffff\2\62\3\5\1\27\1\62\1\4\1\42\1\5\1\62\1\27\1\4"+
        "\1\42";
    static final String DFA3_acceptS =
        "\2\uffff\1\1\1\2\16\uffff";
    static final String DFA3_specialS =
        "\22\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\3\10\uffff\1\2\14\uffff\1\3\1\uffff\1\1\13\uffff\1\3\5\uffff"+
            "\2\2",
            "\1\4\1\5",
            "",
            "",
            "\1\3\10\uffff\1\2\14\uffff\1\3\1\uffff\1\1\1\6\12\uffff\1\3"+
            "\5\uffff\2\2",
            "\1\3\10\uffff\1\2\2\uffff\1\7\1\10\10\uffff\1\3\1\uffff\1\1"+
            "\1\6\12\uffff\1\3\5\uffff\2\2",
            "\1\11",
            "\1\12",
            "\1\12",
            "\1\13",
            "\1\3\10\uffff\1\2\2\uffff\1\7\1\10\10\uffff\1\3\1\uffff\1\1"+
            "\1\6\12\uffff\1\3\5\uffff\2\2",
            "\1\14",
            "\1\16\1\15",
            "\1\17",
            "\1\3\10\uffff\1\2\14\uffff\1\3\1\uffff\1\1\13\uffff\1\3\5\uffff"+
            "\2\2",
            "\1\20",
            "\1\21",
            "\1\16\1\15"
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "698:1: rule__EClassifierDecl__Alternatives : ( ( ruleEClassDecl ) | ( ruleEDataTypeDecl ) );";
        }
    }
    static final String DFA4_eotS =
        "\22\uffff";
    static final String DFA4_eofS =
        "\22\uffff";
    static final String DFA4_minS =
        "\1\7\1\4\2\uffff\2\7\3\5\1\27\1\7\1\4\1\41\1\5\1\7\1\27\1\4\1\41";
    static final String DFA4_maxS =
        "\1\53\1\5\2\uffff\2\53\3\5\1\27\1\53\1\4\1\42\1\5\1\53\1\27\1\4"+
        "\1\42";
    static final String DFA4_acceptS =
        "\2\uffff\1\1\1\2\16\uffff";
    static final String DFA4_specialS =
        "\22\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\2\25\uffff\1\2\1\uffff\1\1\13\uffff\1\3",
            "\1\4\1\5",
            "",
            "",
            "\1\2\25\uffff\1\2\1\uffff\1\1\1\6\12\uffff\1\3",
            "\1\2\13\uffff\1\7\1\10\10\uffff\1\2\1\uffff\1\1\1\6\12\uffff"+
            "\1\3",
            "\1\11",
            "\1\12",
            "\1\12",
            "\1\13",
            "\1\2\13\uffff\1\7\1\10\10\uffff\1\2\1\uffff\1\1\1\6\12\uffff"+
            "\1\3",
            "\1\14",
            "\1\16\1\15",
            "\1\17",
            "\1\2\25\uffff\1\2\1\uffff\1\1\13\uffff\1\3",
            "\1\20",
            "\1\21",
            "\1\16\1\15"
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "720:1: rule__EDataTypeDecl__Alternatives : ( ( ( rule__EDataTypeDecl__Group_0__0 ) ) | ( ruleEEnumDecl ) );";
        }
    }
    static final String DFA6_eotS =
        "\24\uffff";
    static final String DFA6_eofS =
        "\24\uffff";
    static final String DFA6_minS =
        "\1\10\1\4\1\uffff\2\10\1\uffff\2\10\3\5\1\27\1\10\1\4\1\41\1\5\1"+
        "\10\1\27\1\4\1\41";
    static final String DFA6_maxS =
        "\1\70\1\5\1\uffff\2\70\1\uffff\2\70\3\5\1\27\1\70\1\4\1\42\1\5\1"+
        "\70\1\27\1\4\1\42";
    static final String DFA6_acceptS =
        "\2\uffff\1\1\2\uffff\1\2\16\uffff";
    static final String DFA6_specialS =
        "\24\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\3\1\4\2\2\5\uffff\1\2\15\uffff\1\1\6\uffff\1\2\7\uffff\1"+
            "\5\4\uffff\6\2",
            "\1\6\1\7",
            "",
            "\1\3\1\4\2\2\5\uffff\1\2\24\uffff\1\2\7\uffff\1\5\4\uffff\6"+
            "\2",
            "\1\3\1\4\2\2\5\uffff\1\2\24\uffff\1\2\7\uffff\1\5\4\uffff\6"+
            "\2",
            "",
            "\1\3\1\4\2\2\5\uffff\1\2\15\uffff\1\1\1\10\5\uffff\1\2\7\uffff"+
            "\1\5\4\uffff\6\2",
            "\1\3\1\4\2\2\5\uffff\1\2\1\uffff\1\11\1\12\12\uffff\1\1\1\10"+
            "\5\uffff\1\2\7\uffff\1\5\4\uffff\6\2",
            "\1\13",
            "\1\14",
            "\1\14",
            "\1\15",
            "\1\3\1\4\2\2\5\uffff\1\2\1\uffff\1\11\1\12\12\uffff\1\1\1\10"+
            "\5\uffff\1\2\7\uffff\1\5\4\uffff\6\2",
            "\1\16",
            "\1\20\1\17",
            "\1\21",
            "\1\3\1\4\2\2\5\uffff\1\2\15\uffff\1\1\6\uffff\1\2\7\uffff\1"+
            "\5\4\uffff\6\2",
            "\1\22",
            "\1\23",
            "\1\20\1\17"
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "766:1: rule__EClassDecl__Alternatives_8 : ( ( ( rule__EClassDecl__EStructuralFeaturesAssignment_8_0 ) ) | ( ( rule__EClassDecl__EOperationsAssignment_8_1 ) ) );";
        }
    }
    static final String DFA7_eotS =
        "\31\uffff";
    static final String DFA7_eofS =
        "\31\uffff";
    static final String DFA7_minS =
        "\1\10\1\4\1\uffff\7\10\1\uffff\2\10\3\5\1\27\1\10\1\4\1\41\1\5\1"+
        "\10\1\27\1\4\1\41";
    static final String DFA7_maxS =
        "\1\70\1\5\1\uffff\7\70\1\uffff\2\70\3\5\1\27\1\70\1\4\1\42\1\5\1"+
        "\70\1\27\1\4\1\42";
    static final String DFA7_acceptS =
        "\2\uffff\1\1\7\uffff\1\2\16\uffff";
    static final String DFA7_specialS =
        "\31\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\3\1\4\1\5\1\12\5\uffff\1\12\15\uffff\1\1\6\uffff\1\2\14\uffff"+
            "\1\2\1\6\1\7\1\10\1\11\1\12",
            "\1\13\1\14",
            "",
            "\1\3\1\4\1\5\1\12\5\uffff\1\12\24\uffff\1\2\14\uffff\1\2\1\6"+
            "\1\7\1\10\1\11\1\12",
            "\1\3\1\4\1\5\1\12\5\uffff\1\12\24\uffff\1\2\14\uffff\1\2\1\6"+
            "\1\7\1\10\1\11\1\12",
            "\1\3\1\4\1\5\1\12\5\uffff\1\12\24\uffff\1\2\14\uffff\1\2\1\6"+
            "\1\7\1\10\1\11\1\12",
            "\1\3\1\4\1\5\1\12\5\uffff\1\12\24\uffff\1\2\14\uffff\1\2\1\6"+
            "\1\7\1\10\1\11\1\12",
            "\1\3\1\4\1\5\1\12\5\uffff\1\12\24\uffff\1\2\14\uffff\1\2\1\6"+
            "\1\7\1\10\1\11\1\12",
            "\1\3\1\4\1\5\1\12\5\uffff\1\12\24\uffff\1\2\14\uffff\1\2\1\6"+
            "\1\7\1\10\1\11\1\12",
            "\1\3\1\4\1\5\1\12\5\uffff\1\12\24\uffff\1\2\14\uffff\1\2\1\6"+
            "\1\7\1\10\1\11\1\12",
            "",
            "\1\3\1\4\1\5\1\12\5\uffff\1\12\15\uffff\1\1\1\15\5\uffff\1\2"+
            "\14\uffff\1\2\1\6\1\7\1\10\1\11\1\12",
            "\1\3\1\4\1\5\1\12\5\uffff\1\12\1\uffff\1\16\1\17\12\uffff\1"+
            "\1\1\15\5\uffff\1\2\14\uffff\1\2\1\6\1\7\1\10\1\11\1\12",
            "\1\20",
            "\1\21",
            "\1\21",
            "\1\22",
            "\1\3\1\4\1\5\1\12\5\uffff\1\12\1\uffff\1\16\1\17\12\uffff\1"+
            "\1\1\15\5\uffff\1\2\14\uffff\1\2\1\6\1\7\1\10\1\11\1\12",
            "\1\23",
            "\1\25\1\24",
            "\1\26",
            "\1\3\1\4\1\5\1\12\5\uffff\1\12\15\uffff\1\1\6\uffff\1\2\14\uffff"+
            "\1\2\1\6\1\7\1\10\1\11\1\12",
            "\1\27",
            "\1\30",
            "\1\25\1\24"
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "788:1: rule__EStructuralFeatureDecl__Alternatives : ( ( ruleEAttributeDecl ) | ( ruleEReferenceDecl ) );";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleEcoreDsl_in_entryRuleEcoreDsl60 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEcoreDsl67 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EcoreDsl__Group__0_in_ruleEcoreDsl94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel120 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferencedMetamodel127 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group__0_in_ruleReferencedMetamodel154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEPackageDecl_in_entryRuleEPackageDecl180 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEPackageDecl187 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EPackageDecl__Group__0_in_ruleEPackageDecl214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubEPackageDecl_in_entryRuleSubEPackageDecl240 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSubEPackageDecl247 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SubEPackageDecl__Group__0_in_ruleSubEPackageDecl274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEClassifierDecl_in_entryRuleEClassifierDecl300 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEClassifierDecl307 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EClassifierDecl__Alternatives_in_ruleEClassifierDecl334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEDataTypeDecl_in_entryRuleEDataTypeDecl360 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEDataTypeDecl367 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EDataTypeDecl__Alternatives_in_ruleEDataTypeDecl394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAnnotationDecl_in_entryRuleEAnnotationDecl420 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEAnnotationDecl427 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EAnnotationDecl__Group__0_in_ruleEAnnotationDecl454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEClassDecl_in_entryRuleEClassDecl480 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEClassDecl487 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EClassDecl__Group__0_in_ruleEClassDecl514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEStructuralFeatureDecl_in_entryRuleEStructuralFeatureDecl540 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEStructuralFeatureDecl547 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EStructuralFeatureDecl__Alternatives_in_ruleEStructuralFeatureDecl574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAttributeDecl_in_entryRuleEAttributeDecl600 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEAttributeDecl607 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EAttributeDecl__Group__0_in_ruleEAttributeDecl634 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEReferenceDecl_in_entryRuleEReferenceDecl660 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEReferenceDecl667 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EReferenceDecl__Group__0_in_ruleEReferenceDecl694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEEnumDecl_in_entryRuleEEnumDecl720 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEEnumDecl727 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EEnumDecl__Group__0_in_ruleEEnumDecl754 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEEnumLiteralDecl_in_entryRuleEEnumLiteralDecl780 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEEnumLiteralDecl787 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EEnumLiteralDecl__Group__0_in_ruleEEnumLiteralDecl814 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleETypeParameterDecl_in_entryRuleETypeParameterDecl840 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleETypeParameterDecl847 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ETypeParameterDecl__Group__0_in_ruleETypeParameterDecl874 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_entryRuleEGenericTypeReferenceDecl900 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEGenericTypeReferenceDecl907 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EGenericTypeReferenceDecl__Alternatives_in_ruleEGenericTypeReferenceDecl934 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_entryRuleEGenericTypeDecl960 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEGenericTypeDecl967 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EGenericTypeDecl__Alternatives_in_ruleEGenericTypeDecl994 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEOperationDecl_in_entryRuleEOperationDecl1020 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEOperationDecl1027 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EOperationDecl__Group__0_in_ruleEOperationDecl1054 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEParameterDecl_in_entryRuleEParameterDecl1080 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEParameterDecl1087 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EParameterDecl__Group__0_in_ruleEParameterDecl1114 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapEntry_in_entryRuleMapEntry1140 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMapEntry1147 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MapEntry__Group__0_in_ruleMapEntry1174 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQID_in_entryRuleQID1200 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQID1207 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QID__Group__0_in_ruleQID1234 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSTRING_OR_QID_in_entryRuleSTRING_OR_QID1260 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSTRING_OR_QID1267 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__STRING_OR_QID__Alternatives_in_ruleSTRING_OR_QID1294 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSINT_in_entryRuleSINT1320 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSINT1327 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SINT__Group__0_in_ruleSINT1354 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EPackageDecl__ESubpackagesAssignment_10_0_in_rule__EPackageDecl__Alternatives_101390 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EPackageDecl__EClassifiersAssignment_10_1_in_rule__EPackageDecl__Alternatives_101408 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SubEPackageDecl__ESubpackagesAssignment_4_0_in_rule__SubEPackageDecl__Alternatives_41441 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SubEPackageDecl__EClassifiersAssignment_4_1_in_rule__SubEPackageDecl__Alternatives_41459 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEClassDecl_in_rule__EClassifierDecl__Alternatives1492 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEDataTypeDecl_in_rule__EClassifierDecl__Alternatives1509 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EDataTypeDecl__Group_0__0_in_rule__EDataTypeDecl__Alternatives1541 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEEnumDecl_in_rule__EDataTypeDecl__Alternatives1559 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EClassDecl__InterfaceAssignment_2_0_in_rule__EClassDecl__Alternatives_21591 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__EClassDecl__Alternatives_21610 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EClassDecl__EStructuralFeaturesAssignment_8_0_in_rule__EClassDecl__Alternatives_81644 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EClassDecl__EOperationsAssignment_8_1_in_rule__EClassDecl__Alternatives_81662 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAttributeDecl_in_rule__EStructuralFeatureDecl__Alternatives1695 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEReferenceDecl_in_rule__EStructuralFeatureDecl__Alternatives1712 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EAttributeDecl__IDAssignment_1_0_in_rule__EAttributeDecl__Alternatives_11744 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EAttributeDecl__UniqueAssignment_1_1_in_rule__EAttributeDecl__Alternatives_11762 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EAttributeDecl__OrderedAssignment_1_2_in_rule__EAttributeDecl__Alternatives_11780 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EAttributeDecl__ChangeableAssignment_1_3_in_rule__EAttributeDecl__Alternatives_11798 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EAttributeDecl__VolatileAssignment_1_4_in_rule__EAttributeDecl__Alternatives_11816 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EAttributeDecl__TransientAssignment_1_5_in_rule__EAttributeDecl__Alternatives_11834 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EAttributeDecl__UnsettableAssignment_1_6_in_rule__EAttributeDecl__Alternatives_11852 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EAttributeDecl__DerivedAssignment_1_7_in_rule__EAttributeDecl__Alternatives_11870 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EReferenceDecl__ResolveProxiesAssignment_1_0_in_rule__EReferenceDecl__Alternatives_11903 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EReferenceDecl__UniqueAssignment_1_1_in_rule__EReferenceDecl__Alternatives_11921 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EReferenceDecl__OrderedAssignment_1_2_in_rule__EReferenceDecl__Alternatives_11939 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EReferenceDecl__ChangeableAssignment_1_3_in_rule__EReferenceDecl__Alternatives_11957 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EReferenceDecl__VolatileAssignment_1_4_in_rule__EReferenceDecl__Alternatives_11975 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EReferenceDecl__TransientAssignment_1_5_in_rule__EReferenceDecl__Alternatives_11993 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EReferenceDecl__UnsettableAssignment_1_6_in_rule__EReferenceDecl__Alternatives_12011 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EReferenceDecl__DerivedAssignment_1_7_in_rule__EReferenceDecl__Alternatives_12029 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EReferenceDecl__ContainmentAssignment_2_0_in_rule__EReferenceDecl__Alternatives_22062 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__EReferenceDecl__Alternatives_22081 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EGenericTypeReferenceDecl__Group_0__0_in_rule__EGenericTypeReferenceDecl__Alternatives2115 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EGenericTypeReferenceDecl__Group_1__0_in_rule__EGenericTypeReferenceDecl__Alternatives2133 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EGenericTypeDecl__Group_0__0_in_rule__EGenericTypeDecl__Alternatives2166 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EGenericTypeDecl__Group_1__0_in_rule__EGenericTypeDecl__Alternatives2184 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EGenericTypeDecl__Group_2__0_in_rule__EGenericTypeDecl__Alternatives2202 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EGenericTypeDecl__Group_2_1_0__0_in_rule__EGenericTypeDecl__Alternatives_2_12235 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EGenericTypeDecl__Group_2_1_1__0_in_rule__EGenericTypeDecl__Alternatives_2_12253 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EOperationDecl__UniqueAssignment_1_0_in_rule__EOperationDecl__Alternatives_12286 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EOperationDecl__OrderedAssignment_1_1_in_rule__EOperationDecl__Alternatives_12304 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EOperationDecl__EGenericTypeAssignment_3_0_in_rule__EOperationDecl__Alternatives_32337 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__EOperationDecl__Alternatives_32356 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__QID__Alternatives_1_02391 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__QID__Alternatives_1_02411 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__STRING_OR_QID__Alternatives2445 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQID_in_rule__STRING_OR_QID__Alternatives2462 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EcoreDsl__MetamodelDeclarationsAssignment_0_in_rule__EcoreDsl__Group__02496 = new BitSet(new long[]{0x0000000081200000L});
        public static final BitSet FOLLOW_rule__EcoreDsl__Group__1_in_rule__EcoreDsl__Group__02506 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EcoreDsl__PackageAssignment_1_in_rule__EcoreDsl__Group__12534 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__ReferencedMetamodel__Group__02573 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group__1_in_rule__ReferencedMetamodel__Group__02583 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group_1__0_in_rule__ReferencedMetamodel__Group__12611 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group__2_in_rule__ReferencedMetamodel__Group__12621 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__EPackageAssignment_2_in_rule__ReferencedMetamodel__Group__22649 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group__3_in_rule__ReferencedMetamodel__Group__22658 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__ReferencedMetamodel__Group__32687 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__AliasAssignment_1_0_in_rule__ReferencedMetamodel__Group_1__02730 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group_1__1_in_rule__ReferencedMetamodel__Group_1__02739 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__ReferencedMetamodel__Group_1__12768 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EPackageDecl__EAnnotationsAssignment_0_in_rule__EPackageDecl__Group__02807 = new BitSet(new long[]{0x0000000081000000L});
        public static final BitSet FOLLOW_rule__EPackageDecl__Group__1_in_rule__EPackageDecl__Group__02817 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__EPackageDecl__Group__12846 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__EPackageDecl__Group__2_in_rule__EPackageDecl__Group__12856 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EPackageDecl__NameAssignment_2_in_rule__EPackageDecl__Group__22884 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__EPackageDecl__Group__3_in_rule__EPackageDecl__Group__22893 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__EPackageDecl__Group__32922 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__EPackageDecl__Group__4_in_rule__EPackageDecl__Group__32932 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__EPackageDecl__Group__42961 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__EPackageDecl__Group__5_in_rule__EPackageDecl__Group__42971 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EPackageDecl__NsURIAssignment_5_in_rule__EPackageDecl__Group__52999 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__EPackageDecl__Group__6_in_rule__EPackageDecl__Group__53008 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__EPackageDecl__Group__63037 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__EPackageDecl__Group__7_in_rule__EPackageDecl__Group__63047 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__EPackageDecl__Group__73076 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__EPackageDecl__Group__8_in_rule__EPackageDecl__Group__73086 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EPackageDecl__NsPrefixAssignment_8_in_rule__EPackageDecl__Group__83114 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_rule__EPackageDecl__Group__9_in_rule__EPackageDecl__Group__83123 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__EPackageDecl__Group__93152 = new BitSet(new long[]{0x00060800B1010080L});
        public static final BitSet FOLLOW_rule__EPackageDecl__Group__10_in_rule__EPackageDecl__Group__93162 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EPackageDecl__Alternatives_10_in_rule__EPackageDecl__Group__103190 = new BitSet(new long[]{0x00060800B1010080L});
        public static final BitSet FOLLOW_rule__EPackageDecl__Group__11_in_rule__EPackageDecl__Group__103200 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__EPackageDecl__Group__113229 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SubEPackageDecl__EAnnotationsAssignment_0_in_rule__SubEPackageDecl__Group__03288 = new BitSet(new long[]{0x0000000081000000L});
        public static final BitSet FOLLOW_rule__SubEPackageDecl__Group__1_in_rule__SubEPackageDecl__Group__03298 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__SubEPackageDecl__Group__13327 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__SubEPackageDecl__Group__2_in_rule__SubEPackageDecl__Group__13337 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SubEPackageDecl__NameAssignment_2_in_rule__SubEPackageDecl__Group__23365 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_rule__SubEPackageDecl__Group__3_in_rule__SubEPackageDecl__Group__23374 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__SubEPackageDecl__Group__33403 = new BitSet(new long[]{0x00060800B1010080L});
        public static final BitSet FOLLOW_rule__SubEPackageDecl__Group__4_in_rule__SubEPackageDecl__Group__33413 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SubEPackageDecl__Alternatives_4_in_rule__SubEPackageDecl__Group__43441 = new BitSet(new long[]{0x00060800B1010080L});
        public static final BitSet FOLLOW_rule__SubEPackageDecl__Group__5_in_rule__SubEPackageDecl__Group__43451 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__SubEPackageDecl__Group__53480 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EDataTypeDecl__EAnnotationsAssignment_0_0_in_rule__EDataTypeDecl__Group_0__03527 = new BitSet(new long[]{0x00000000A0000080L});
        public static final BitSet FOLLOW_rule__EDataTypeDecl__Group_0__1_in_rule__EDataTypeDecl__Group_0__03537 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EDataTypeDecl__SerializableAssignment_0_1_in_rule__EDataTypeDecl__Group_0__13565 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_rule__EDataTypeDecl__Group_0__2_in_rule__EDataTypeDecl__Group_0__13575 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EDataTypeDecl__Group_0_2__0_in_rule__EDataTypeDecl__Group_0__23603 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__EDataTypeDecl__Group_0_2__03644 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__EDataTypeDecl__Group_0_2__1_in_rule__EDataTypeDecl__Group_0_2__03654 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EDataTypeDecl__NameAssignment_0_2_1_in_rule__EDataTypeDecl__Group_0_2__13682 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__EDataTypeDecl__Group_0_2__2_in_rule__EDataTypeDecl__Group_0_2__13691 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__EDataTypeDecl__Group_0_2__23720 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__EDataTypeDecl__Group_0_2__3_in_rule__EDataTypeDecl__Group_0_2__23730 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EDataTypeDecl__InstanceClassNameAssignment_0_2_3_in_rule__EDataTypeDecl__Group_0_2__33758 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__EDataTypeDecl__Group_0_2__4_in_rule__EDataTypeDecl__Group_0_2__33767 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__EDataTypeDecl__Group_0_2__43796 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__EAnnotationDecl__Group__03842 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__EAnnotationDecl__Group__1_in_rule__EAnnotationDecl__Group__03852 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EAnnotationDecl__SourceAssignment_1_in_rule__EAnnotationDecl__Group__13880 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_rule__EAnnotationDecl__Group__2_in_rule__EAnnotationDecl__Group__13889 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EAnnotationDecl__Group_2__0_in_rule__EAnnotationDecl__Group__23917 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__EAnnotationDecl__Group_2__03959 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__EAnnotationDecl__Group_2__1_in_rule__EAnnotationDecl__Group_2__03969 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EAnnotationDecl__DetailsAssignment_2_1_in_rule__EAnnotationDecl__Group_2__13997 = new BitSet(new long[]{0x0000000600000000L});
        public static final BitSet FOLLOW_rule__EAnnotationDecl__Group_2__2_in_rule__EAnnotationDecl__Group_2__14006 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EAnnotationDecl__Group_2_2__0_in_rule__EAnnotationDecl__Group_2__24034 = new BitSet(new long[]{0x0000000600000000L});
        public static final BitSet FOLLOW_rule__EAnnotationDecl__Group_2__3_in_rule__EAnnotationDecl__Group_2__24044 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__EAnnotationDecl__Group_2__34073 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__EAnnotationDecl__Group_2_2__04117 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__EAnnotationDecl__Group_2_2__1_in_rule__EAnnotationDecl__Group_2_2__04127 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EAnnotationDecl__DetailsAssignment_2_2_1_in_rule__EAnnotationDecl__Group_2_2__14155 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EClassDecl__EAnnotationsAssignment_0_in_rule__EClassDecl__Group__04193 = new BitSet(new long[]{0x0006000080010000L});
        public static final BitSet FOLLOW_rule__EClassDecl__Group__1_in_rule__EClassDecl__Group__04203 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EClassDecl__AbstractAssignment_1_in_rule__EClassDecl__Group__14231 = new BitSet(new long[]{0x0004000000010000L});
        public static final BitSet FOLLOW_rule__EClassDecl__Group__2_in_rule__EClassDecl__Group__14241 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EClassDecl__Alternatives_2_in_rule__EClassDecl__Group__24269 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__EClassDecl__Group__3_in_rule__EClassDecl__Group__24278 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EClassDecl__NameAssignment_3_in_rule__EClassDecl__Group__34306 = new BitSet(new long[]{0x0000002848000000L});
        public static final BitSet FOLLOW_rule__EClassDecl__Group__4_in_rule__EClassDecl__Group__34315 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EClassDecl__Group_4__0_in_rule__EClassDecl__Group__44343 = new BitSet(new long[]{0x0000002048000000L});
        public static final BitSet FOLLOW_rule__EClassDecl__Group__5_in_rule__EClassDecl__Group__44353 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EClassDecl__Group_5__0_in_rule__EClassDecl__Group__54381 = new BitSet(new long[]{0x0000000048000000L});
        public static final BitSet FOLLOW_rule__EClassDecl__Group__6_in_rule__EClassDecl__Group__54391 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EClassDecl__Group_6__0_in_rule__EClassDecl__Group__64419 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_rule__EClassDecl__Group__7_in_rule__EClassDecl__Group__64429 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__EClassDecl__Group__74458 = new BitSet(new long[]{0x01F8404090020F00L});
        public static final BitSet FOLLOW_rule__EClassDecl__Group__8_in_rule__EClassDecl__Group__74468 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EClassDecl__Alternatives_8_in_rule__EClassDecl__Group__84496 = new BitSet(new long[]{0x01F8404090020F00L});
        public static final BitSet FOLLOW_rule__EClassDecl__Group__9_in_rule__EClassDecl__Group__84506 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__EClassDecl__Group__94535 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__EClassDecl__Group_4__04591 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__EClassDecl__Group_4__1_in_rule__EClassDecl__Group_4__04601 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EClassDecl__ETypeParametersAssignment_4_1_in_rule__EClassDecl__Group_4__14629 = new BitSet(new long[]{0x0000001400000000L});
        public static final BitSet FOLLOW_rule__EClassDecl__Group_4__2_in_rule__EClassDecl__Group_4__14638 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EClassDecl__Group_4_2__0_in_rule__EClassDecl__Group_4__24666 = new BitSet(new long[]{0x0000001400000000L});
        public static final BitSet FOLLOW_rule__EClassDecl__Group_4__3_in_rule__EClassDecl__Group_4__24676 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_rule__EClassDecl__Group_4__34705 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__EClassDecl__Group_4_2__04749 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__EClassDecl__Group_4_2__1_in_rule__EClassDecl__Group_4_2__04759 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EClassDecl__ETypeParametersAssignment_4_2_1_in_rule__EClassDecl__Group_4_2__14787 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_rule__EClassDecl__Group_5__04826 = new BitSet(new long[]{0x0000040000000020L});
        public static final BitSet FOLLOW_rule__EClassDecl__Group_5__1_in_rule__EClassDecl__Group_5__04836 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EClassDecl__EGenericSuperTypesAssignment_5_1_in_rule__EClassDecl__Group_5__14864 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_rule__EClassDecl__Group_5__2_in_rule__EClassDecl__Group_5__14873 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EClassDecl__Group_5_2__0_in_rule__EClassDecl__Group_5__24901 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_34_in_rule__EClassDecl__Group_5_2__04943 = new BitSet(new long[]{0x0000040000000020L});
        public static final BitSet FOLLOW_rule__EClassDecl__Group_5_2__1_in_rule__EClassDecl__Group_5_2__04953 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EClassDecl__EGenericSuperTypesAssignment_5_2_1_in_rule__EClassDecl__Group_5_2__14981 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__EClassDecl__Group_6__05020 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__EClassDecl__Group_6__1_in_rule__EClassDecl__Group_6__05030 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EClassDecl__InstanceClassNameAssignment_6_1_in_rule__EClassDecl__Group_6__15058 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EAttributeDecl__EAnnotationsAssignment_0_in_rule__EAttributeDecl__Group__05096 = new BitSet(new long[]{0x00F8004080000700L});
        public static final BitSet FOLLOW_rule__EAttributeDecl__Group__1_in_rule__EAttributeDecl__Group__05106 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EAttributeDecl__Alternatives_1_in_rule__EAttributeDecl__Group__15134 = new BitSet(new long[]{0x00F8004000000700L});
        public static final BitSet FOLLOW_rule__EAttributeDecl__Group__2_in_rule__EAttributeDecl__Group__15144 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_rule__EAttributeDecl__Group__25173 = new BitSet(new long[]{0x0000040000000020L});
        public static final BitSet FOLLOW_rule__EAttributeDecl__Group__3_in_rule__EAttributeDecl__Group__25183 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EAttributeDecl__EGenericTypeAssignment_3_in_rule__EAttributeDecl__Group__35211 = new BitSet(new long[]{0x0000008000000020L});
        public static final BitSet FOLLOW_rule__EAttributeDecl__Group__4_in_rule__EAttributeDecl__Group__35220 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EAttributeDecl__Group_4__0_in_rule__EAttributeDecl__Group__45248 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__EAttributeDecl__Group__5_in_rule__EAttributeDecl__Group__45258 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EAttributeDecl__NameAssignment_5_in_rule__EAttributeDecl__Group__55286 = new BitSet(new long[]{0x0000000000C00000L});
        public static final BitSet FOLLOW_rule__EAttributeDecl__Group__6_in_rule__EAttributeDecl__Group__55295 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EAttributeDecl__Group_6__0_in_rule__EAttributeDecl__Group__65323 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__EAttributeDecl__Group__7_in_rule__EAttributeDecl__Group__65333 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__EAttributeDecl__Group__75362 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_rule__EAttributeDecl__Group_4__05414 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rule__EAttributeDecl__Group_4__1_in_rule__EAttributeDecl__Group_4__05424 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EAttributeDecl__LowerBoundAssignment_4_1_in_rule__EAttributeDecl__Group_4__15452 = new BitSet(new long[]{0x0000030000000000L});
        public static final BitSet FOLLOW_rule__EAttributeDecl__Group_4__2_in_rule__EAttributeDecl__Group_4__15461 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EAttributeDecl__Group_4_2__0_in_rule__EAttributeDecl__Group_4__25489 = new BitSet(new long[]{0x0000010000000000L});
        public static final BitSet FOLLOW_rule__EAttributeDecl__Group_4__3_in_rule__EAttributeDecl__Group_4__25499 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_rule__EAttributeDecl__Group_4__35528 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_rule__EAttributeDecl__Group_4_2__05572 = new BitSet(new long[]{0x0001000000000040L});
        public static final BitSet FOLLOW_rule__EAttributeDecl__Group_4_2__1_in_rule__EAttributeDecl__Group_4_2__05582 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EAttributeDecl__UpperBoundAssignment_4_2_1_in_rule__EAttributeDecl__Group_4_2__15610 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__EAttributeDecl__Group_6__05649 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__EAttributeDecl__Group_6__1_in_rule__EAttributeDecl__Group_6__05659 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EAttributeDecl__DefaultValueLiteralAssignment_6_1_in_rule__EAttributeDecl__Group_6__15687 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EReferenceDecl__EAnnotationsAssignment_0_in_rule__EReferenceDecl__Group__05725 = new BitSet(new long[]{0x01F0000080020F00L});
        public static final BitSet FOLLOW_rule__EReferenceDecl__Group__1_in_rule__EReferenceDecl__Group__05735 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EReferenceDecl__Alternatives_1_in_rule__EReferenceDecl__Group__15763 = new BitSet(new long[]{0x01F0000000020F00L});
        public static final BitSet FOLLOW_rule__EReferenceDecl__Group__2_in_rule__EReferenceDecl__Group__15773 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EReferenceDecl__Alternatives_2_in_rule__EReferenceDecl__Group__25801 = new BitSet(new long[]{0x0000040000000020L});
        public static final BitSet FOLLOW_rule__EReferenceDecl__Group__3_in_rule__EReferenceDecl__Group__25810 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EReferenceDecl__EGenericTypeAssignment_3_in_rule__EReferenceDecl__Group__35838 = new BitSet(new long[]{0x0000048000000020L});
        public static final BitSet FOLLOW_rule__EReferenceDecl__Group__4_in_rule__EReferenceDecl__Group__35847 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EReferenceDecl__Group_4__0_in_rule__EReferenceDecl__Group__45875 = new BitSet(new long[]{0x0000040000000020L});
        public static final BitSet FOLLOW_rule__EReferenceDecl__Group__5_in_rule__EReferenceDecl__Group__45885 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EReferenceDecl__Group_5__0_in_rule__EReferenceDecl__Group__55913 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__EReferenceDecl__Group__6_in_rule__EReferenceDecl__Group__55923 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EReferenceDecl__NameAssignment_6_in_rule__EReferenceDecl__Group__65951 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__EReferenceDecl__Group__7_in_rule__EReferenceDecl__Group__65960 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__EReferenceDecl__Group__75989 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_rule__EReferenceDecl__Group_4__06041 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rule__EReferenceDecl__Group_4__1_in_rule__EReferenceDecl__Group_4__06051 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EReferenceDecl__LowerBoundAssignment_4_1_in_rule__EReferenceDecl__Group_4__16079 = new BitSet(new long[]{0x0000030000000000L});
        public static final BitSet FOLLOW_rule__EReferenceDecl__Group_4__2_in_rule__EReferenceDecl__Group_4__16088 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EReferenceDecl__Group_4_2__0_in_rule__EReferenceDecl__Group_4__26116 = new BitSet(new long[]{0x0000010000000000L});
        public static final BitSet FOLLOW_rule__EReferenceDecl__Group_4__3_in_rule__EReferenceDecl__Group_4__26126 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_rule__EReferenceDecl__Group_4__36155 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_rule__EReferenceDecl__Group_4_2__06199 = new BitSet(new long[]{0x0001000000000040L});
        public static final BitSet FOLLOW_rule__EReferenceDecl__Group_4_2__1_in_rule__EReferenceDecl__Group_4_2__06209 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EReferenceDecl__UpperBoundAssignment_4_2_1_in_rule__EReferenceDecl__Group_4_2__16237 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_rule__EReferenceDecl__Group_5__06276 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__EReferenceDecl__Group_5__1_in_rule__EReferenceDecl__Group_5__06286 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EReferenceDecl__EOppositeAssignment_5_1_in_rule__EReferenceDecl__Group_5__16314 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EEnumDecl__EAnnotationsAssignment_0_in_rule__EEnumDecl__Group__06352 = new BitSet(new long[]{0x0000080080000000L});
        public static final BitSet FOLLOW_rule__EEnumDecl__Group__1_in_rule__EEnumDecl__Group__06362 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_rule__EEnumDecl__Group__16391 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__EEnumDecl__Group__2_in_rule__EEnumDecl__Group__16401 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EEnumDecl__NameAssignment_2_in_rule__EEnumDecl__Group__26429 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_rule__EEnumDecl__Group__3_in_rule__EEnumDecl__Group__26438 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__EEnumDecl__Group__36467 = new BitSet(new long[]{0x0000000080000020L});
        public static final BitSet FOLLOW_rule__EEnumDecl__Group__4_in_rule__EEnumDecl__Group__36477 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EEnumDecl__ELiteralsAssignment_4_in_rule__EEnumDecl__Group__46507 = new BitSet(new long[]{0x0000000090000020L});
        public static final BitSet FOLLOW_rule__EEnumDecl__ELiteralsAssignment_4_in_rule__EEnumDecl__Group__46519 = new BitSet(new long[]{0x0000000090000020L});
        public static final BitSet FOLLOW_rule__EEnumDecl__Group__5_in_rule__EEnumDecl__Group__46531 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__EEnumDecl__Group__56560 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EEnumLiteralDecl__EAnnotationsAssignment_0_in_rule__EEnumLiteralDecl__Group__06607 = new BitSet(new long[]{0x0000000080000020L});
        public static final BitSet FOLLOW_rule__EEnumLiteralDecl__Group__1_in_rule__EEnumLiteralDecl__Group__06617 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EEnumLiteralDecl__NameAssignment_1_in_rule__EEnumLiteralDecl__Group__16645 = new BitSet(new long[]{0x0000000000C00010L});
        public static final BitSet FOLLOW_rule__EEnumLiteralDecl__Group__2_in_rule__EEnumLiteralDecl__Group__16654 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EEnumLiteralDecl__Group_2__0_in_rule__EEnumLiteralDecl__Group__26682 = new BitSet(new long[]{0x0000000000400010L});
        public static final BitSet FOLLOW_rule__EEnumLiteralDecl__Group__3_in_rule__EEnumLiteralDecl__Group__26692 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EEnumLiteralDecl__LiteralAssignment_3_in_rule__EEnumLiteralDecl__Group__36720 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__EEnumLiteralDecl__Group__4_in_rule__EEnumLiteralDecl__Group__36730 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__EEnumLiteralDecl__Group__46759 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__EEnumLiteralDecl__Group_2__06805 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rule__EEnumLiteralDecl__Group_2__1_in_rule__EEnumLiteralDecl__Group_2__06815 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EEnumLiteralDecl__ValueAssignment_2_1_in_rule__EEnumLiteralDecl__Group_2__16843 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ETypeParameterDecl__NameAssignment_0_in_rule__ETypeParameterDecl__Group__06881 = new BitSet(new long[]{0x0000002000000002L});
        public static final BitSet FOLLOW_rule__ETypeParameterDecl__Group__1_in_rule__ETypeParameterDecl__Group__06890 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ETypeParameterDecl__Group_1__0_in_rule__ETypeParameterDecl__Group__16918 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_rule__ETypeParameterDecl__Group_1__06958 = new BitSet(new long[]{0x0000140000000020L});
        public static final BitSet FOLLOW_rule__ETypeParameterDecl__Group_1__1_in_rule__ETypeParameterDecl__Group_1__06968 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ETypeParameterDecl__EBoundsAssignment_1_1_in_rule__ETypeParameterDecl__Group_1__16996 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EGenericTypeReferenceDecl__EClassifierAssignment_0_0_in_rule__EGenericTypeReferenceDecl__Group_0__07034 = new BitSet(new long[]{0x0000000800000002L});
        public static final BitSet FOLLOW_rule__EGenericTypeReferenceDecl__Group_0__1_in_rule__EGenericTypeReferenceDecl__Group_0__07043 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EGenericTypeReferenceDecl__Group_0_1__0_in_rule__EGenericTypeReferenceDecl__Group_0__17071 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__EGenericTypeReferenceDecl__Group_0_1__07111 = new BitSet(new long[]{0x0000140000000020L});
        public static final BitSet FOLLOW_rule__EGenericTypeReferenceDecl__Group_0_1__1_in_rule__EGenericTypeReferenceDecl__Group_0_1__07121 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_1_in_rule__EGenericTypeReferenceDecl__Group_0_1__17149 = new BitSet(new long[]{0x0000001400000000L});
        public static final BitSet FOLLOW_rule__EGenericTypeReferenceDecl__Group_0_1__2_in_rule__EGenericTypeReferenceDecl__Group_0_1__17158 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EGenericTypeReferenceDecl__Group_0_1_2__0_in_rule__EGenericTypeReferenceDecl__Group_0_1__27186 = new BitSet(new long[]{0x0000001400000000L});
        public static final BitSet FOLLOW_rule__EGenericTypeReferenceDecl__Group_0_1__3_in_rule__EGenericTypeReferenceDecl__Group_0_1__27196 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_rule__EGenericTypeReferenceDecl__Group_0_1__37225 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__EGenericTypeReferenceDecl__Group_0_1_2__07269 = new BitSet(new long[]{0x0000140000000020L});
        public static final BitSet FOLLOW_rule__EGenericTypeReferenceDecl__Group_0_1_2__1_in_rule__EGenericTypeReferenceDecl__Group_0_1_2__07279 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_2_1_in_rule__EGenericTypeReferenceDecl__Group_0_1_2__17307 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_rule__EGenericTypeReferenceDecl__Group_1__07346 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__EGenericTypeReferenceDecl__Group_1__1_in_rule__EGenericTypeReferenceDecl__Group_1__07356 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EGenericTypeReferenceDecl__ETypeParameterAssignment_1_1_in_rule__EGenericTypeReferenceDecl__Group_1__17384 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EGenericTypeDecl__EClassifierAssignment_0_0_in_rule__EGenericTypeDecl__Group_0__07422 = new BitSet(new long[]{0x0000000800000002L});
        public static final BitSet FOLLOW_rule__EGenericTypeDecl__Group_0__1_in_rule__EGenericTypeDecl__Group_0__07431 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EGenericTypeDecl__Group_0_1__0_in_rule__EGenericTypeDecl__Group_0__17459 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__EGenericTypeDecl__Group_0_1__07499 = new BitSet(new long[]{0x0000140000000020L});
        public static final BitSet FOLLOW_rule__EGenericTypeDecl__Group_0_1__1_in_rule__EGenericTypeDecl__Group_0_1__07509 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_1_in_rule__EGenericTypeDecl__Group_0_1__17537 = new BitSet(new long[]{0x0000001400000000L});
        public static final BitSet FOLLOW_rule__EGenericTypeDecl__Group_0_1__2_in_rule__EGenericTypeDecl__Group_0_1__17546 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EGenericTypeDecl__Group_0_1_2__0_in_rule__EGenericTypeDecl__Group_0_1__27574 = new BitSet(new long[]{0x0000001400000000L});
        public static final BitSet FOLLOW_rule__EGenericTypeDecl__Group_0_1__3_in_rule__EGenericTypeDecl__Group_0_1__27584 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_rule__EGenericTypeDecl__Group_0_1__37613 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__EGenericTypeDecl__Group_0_1_2__07657 = new BitSet(new long[]{0x0000140000000020L});
        public static final BitSet FOLLOW_rule__EGenericTypeDecl__Group_0_1_2__1_in_rule__EGenericTypeDecl__Group_0_1_2__07667 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_2_1_in_rule__EGenericTypeDecl__Group_0_1_2__17695 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_rule__EGenericTypeDecl__Group_1__07734 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__EGenericTypeDecl__Group_1__1_in_rule__EGenericTypeDecl__Group_1__07744 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EGenericTypeDecl__ETypeParameterAssignment_1_1_in_rule__EGenericTypeDecl__Group_1__17772 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_rule__EGenericTypeDecl__Group_2__07811 = new BitSet(new long[]{0x0000202000000000L});
        public static final BitSet FOLLOW_rule__EGenericTypeDecl__Group_2__1_in_rule__EGenericTypeDecl__Group_2__07821 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EGenericTypeDecl__Alternatives_2_1_in_rule__EGenericTypeDecl__Group_2__17849 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_rule__EGenericTypeDecl__Group_2_1_0__07888 = new BitSet(new long[]{0x0000140000000020L});
        public static final BitSet FOLLOW_rule__EGenericTypeDecl__Group_2_1_0__1_in_rule__EGenericTypeDecl__Group_2_1_0__07898 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EGenericTypeDecl__EUpperBoundAssignment_2_1_0_1_in_rule__EGenericTypeDecl__Group_2_1_0__17926 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_rule__EGenericTypeDecl__Group_2_1_1__07965 = new BitSet(new long[]{0x0000140000000020L});
        public static final BitSet FOLLOW_rule__EGenericTypeDecl__Group_2_1_1__1_in_rule__EGenericTypeDecl__Group_2_1_1__07975 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EGenericTypeDecl__ELowerBoundAssignment_2_1_1_1_in_rule__EGenericTypeDecl__Group_2_1_1__18003 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EOperationDecl__EAnnotationsAssignment_0_in_rule__EOperationDecl__Group__08041 = new BitSet(new long[]{0x0000400080000300L});
        public static final BitSet FOLLOW_rule__EOperationDecl__Group__1_in_rule__EOperationDecl__Group__08051 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EOperationDecl__Alternatives_1_in_rule__EOperationDecl__Group__18079 = new BitSet(new long[]{0x0000400000000300L});
        public static final BitSet FOLLOW_rule__EOperationDecl__Group__2_in_rule__EOperationDecl__Group__18089 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_rule__EOperationDecl__Group__28118 = new BitSet(new long[]{0x0000040000040020L});
        public static final BitSet FOLLOW_rule__EOperationDecl__Group__3_in_rule__EOperationDecl__Group__28128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EOperationDecl__Alternatives_3_in_rule__EOperationDecl__Group__38156 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__EOperationDecl__Group__4_in_rule__EOperationDecl__Group__38165 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EOperationDecl__NameAssignment_4_in_rule__EOperationDecl__Group__48193 = new BitSet(new long[]{0x0000000900000000L});
        public static final BitSet FOLLOW_rule__EOperationDecl__Group__5_in_rule__EOperationDecl__Group__48202 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EOperationDecl__Group_5__0_in_rule__EOperationDecl__Group__58230 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_rule__EOperationDecl__Group__6_in_rule__EOperationDecl__Group__58240 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__EOperationDecl__Group__68269 = new BitSet(new long[]{0x0000040280000020L});
        public static final BitSet FOLLOW_rule__EOperationDecl__Group__7_in_rule__EOperationDecl__Group__68279 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EOperationDecl__Group_7__0_in_rule__EOperationDecl__Group__78307 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_rule__EOperationDecl__Group__8_in_rule__EOperationDecl__Group__78317 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__EOperationDecl__Group__88346 = new BitSet(new long[]{0x0000800000400000L});
        public static final BitSet FOLLOW_rule__EOperationDecl__Group__9_in_rule__EOperationDecl__Group__88356 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EOperationDecl__Group_9__0_in_rule__EOperationDecl__Group__98384 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__EOperationDecl__Group__10_in_rule__EOperationDecl__Group__98394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__EOperationDecl__Group__108423 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__EOperationDecl__Group_5__08481 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__EOperationDecl__Group_5__1_in_rule__EOperationDecl__Group_5__08491 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EOperationDecl__ETypeParametersAssignment_5_1_in_rule__EOperationDecl__Group_5__18519 = new BitSet(new long[]{0x0000001400000000L});
        public static final BitSet FOLLOW_rule__EOperationDecl__Group_5__2_in_rule__EOperationDecl__Group_5__18528 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EOperationDecl__Group_5_2__0_in_rule__EOperationDecl__Group_5__28556 = new BitSet(new long[]{0x0000001400000000L});
        public static final BitSet FOLLOW_rule__EOperationDecl__Group_5__3_in_rule__EOperationDecl__Group_5__28566 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_rule__EOperationDecl__Group_5__38595 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__EOperationDecl__Group_5_2__08639 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__EOperationDecl__Group_5_2__1_in_rule__EOperationDecl__Group_5_2__08649 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EOperationDecl__ETypeParametersAssignment_5_2_1_in_rule__EOperationDecl__Group_5_2__18677 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EOperationDecl__EParametersAssignment_7_0_in_rule__EOperationDecl__Group_7__08715 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_rule__EOperationDecl__Group_7__1_in_rule__EOperationDecl__Group_7__08724 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EOperationDecl__Group_7_1__0_in_rule__EOperationDecl__Group_7__18752 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_34_in_rule__EOperationDecl__Group_7_1__08792 = new BitSet(new long[]{0x0000040080000020L});
        public static final BitSet FOLLOW_rule__EOperationDecl__Group_7_1__1_in_rule__EOperationDecl__Group_7_1__08802 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EOperationDecl__EParametersAssignment_7_1_1_in_rule__EOperationDecl__Group_7_1__18830 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_rule__EOperationDecl__Group_9__08869 = new BitSet(new long[]{0x0000040000000020L});
        public static final BitSet FOLLOW_rule__EOperationDecl__Group_9__1_in_rule__EOperationDecl__Group_9__08879 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EOperationDecl__EGenericExceptionsAssignment_9_1_in_rule__EOperationDecl__Group_9__18907 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_rule__EOperationDecl__Group_9__2_in_rule__EOperationDecl__Group_9__18916 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EOperationDecl__Group_9_2__0_in_rule__EOperationDecl__Group_9__28944 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_34_in_rule__EOperationDecl__Group_9_2__08986 = new BitSet(new long[]{0x0000040000000020L});
        public static final BitSet FOLLOW_rule__EOperationDecl__Group_9_2__1_in_rule__EOperationDecl__Group_9_2__08996 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EOperationDecl__EGenericExceptionsAssignment_9_2_1_in_rule__EOperationDecl__Group_9_2__19024 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EParameterDecl__EAnnotationsAssignment_0_in_rule__EParameterDecl__Group__09062 = new BitSet(new long[]{0x0000040080000020L});
        public static final BitSet FOLLOW_rule__EParameterDecl__Group__1_in_rule__EParameterDecl__Group__09072 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EParameterDecl__EGenericTypeAssignment_1_in_rule__EParameterDecl__Group__19100 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__EParameterDecl__Group__2_in_rule__EParameterDecl__Group__19109 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EParameterDecl__NameAssignment_2_in_rule__EParameterDecl__Group__29137 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MapEntry__KeyAssignment_0_in_rule__MapEntry__Group__09177 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__MapEntry__Group__1_in_rule__MapEntry__Group__09186 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__MapEntry__Group__19215 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__MapEntry__Group__2_in_rule__MapEntry__Group__19225 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MapEntry__ValueAssignment_2_in_rule__MapEntry__Group__29253 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__QID__Group__09293 = new BitSet(new long[]{0x0000000000180002L});
        public static final BitSet FOLLOW_rule__QID__Group__1_in_rule__QID__Group__09301 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QID__Group_1__0_in_rule__QID__Group__19329 = new BitSet(new long[]{0x0000000000180002L});
        public static final BitSet FOLLOW_rule__QID__Alternatives_1_0_in_rule__QID__Group_1__09368 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__QID__Group_1__1_in_rule__QID__Group_1__09377 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__QID__Group_1__19405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_rule__SINT__Group__09444 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rule__SINT__Group__1_in_rule__SINT__Group__09456 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__SINT__Group__19484 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferencedMetamodel_in_rule__EcoreDsl__MetamodelDeclarationsAssignment_09521 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEPackageDecl_in_rule__EcoreDsl__PackageAssignment_19552 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ReferencedMetamodel__AliasAssignment_1_09583 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__ReferencedMetamodel__EPackageAssignment_29618 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAnnotationDecl_in_rule__EPackageDecl__EAnnotationsAssignment_09653 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQID_in_rule__EPackageDecl__NameAssignment_29684 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__EPackageDecl__NsURIAssignment_59715 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQID_in_rule__EPackageDecl__NsPrefixAssignment_89746 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubEPackageDecl_in_rule__EPackageDecl__ESubpackagesAssignment_10_09777 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEClassifierDecl_in_rule__EPackageDecl__EClassifiersAssignment_10_19808 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAnnotationDecl_in_rule__SubEPackageDecl__EAnnotationsAssignment_09839 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__SubEPackageDecl__NameAssignment_29870 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubEPackageDecl_in_rule__SubEPackageDecl__ESubpackagesAssignment_4_09901 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEClassifierDecl_in_rule__SubEPackageDecl__EClassifiersAssignment_4_19932 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAnnotationDecl_in_rule__EDataTypeDecl__EAnnotationsAssignment_0_09963 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SERIALIZABLE_in_rule__EDataTypeDecl__SerializableAssignment_0_19994 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EDataTypeDecl__NameAssignment_0_2_110025 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSTRING_OR_QID_in_rule__EDataTypeDecl__InstanceClassNameAssignment_0_2_310056 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSTRING_OR_QID_in_rule__EAnnotationDecl__SourceAssignment_110087 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapEntry_in_rule__EAnnotationDecl__DetailsAssignment_2_110118 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapEntry_in_rule__EAnnotationDecl__DetailsAssignment_2_2_110149 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAnnotationDecl_in_rule__EClassDecl__EAnnotationsAssignment_010180 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_rule__EClassDecl__AbstractAssignment_110216 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_rule__EClassDecl__InterfaceAssignment_2_010260 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EClassDecl__NameAssignment_310299 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleETypeParameterDecl_in_rule__EClassDecl__ETypeParametersAssignment_4_110330 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleETypeParameterDecl_in_rule__EClassDecl__ETypeParametersAssignment_4_2_110361 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_rule__EClassDecl__EGenericSuperTypesAssignment_5_110392 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_rule__EClassDecl__EGenericSuperTypesAssignment_5_2_110423 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSTRING_OR_QID_in_rule__EClassDecl__InstanceClassNameAssignment_6_110454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEStructuralFeatureDecl_in_rule__EClassDecl__EStructuralFeaturesAssignment_8_010485 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEOperationDecl_in_rule__EClassDecl__EOperationsAssignment_8_110516 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAnnotationDecl_in_rule__EAttributeDecl__EAnnotationsAssignment_010547 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_rule__EAttributeDecl__IDAssignment_1_010583 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_BAG_in_rule__EAttributeDecl__UniqueAssignment_1_110622 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_RANDOM_in_rule__EAttributeDecl__OrderedAssignment_1_210653 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_READONLY_in_rule__EAttributeDecl__ChangeableAssignment_1_310684 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_rule__EAttributeDecl__VolatileAssignment_1_410720 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_rule__EAttributeDecl__TransientAssignment_1_510764 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_rule__EAttributeDecl__UnsettableAssignment_1_610808 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_rule__EAttributeDecl__DerivedAssignment_1_710852 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_rule__EAttributeDecl__EGenericTypeAssignment_310891 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__EAttributeDecl__LowerBoundAssignment_4_110922 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSINT_in_rule__EAttributeDecl__UpperBoundAssignment_4_2_110953 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EAttributeDecl__NameAssignment_510984 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__EAttributeDecl__DefaultValueLiteralAssignment_6_111015 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAnnotationDecl_in_rule__EReferenceDecl__EAnnotationsAssignment_011046 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LOCAL_in_rule__EReferenceDecl__ResolveProxiesAssignment_1_011077 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_BAG_in_rule__EReferenceDecl__UniqueAssignment_1_111108 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_RANDOM_in_rule__EReferenceDecl__OrderedAssignment_1_211139 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_READONLY_in_rule__EReferenceDecl__ChangeableAssignment_1_311170 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_rule__EReferenceDecl__VolatileAssignment_1_411206 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_rule__EReferenceDecl__TransientAssignment_1_511250 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_rule__EReferenceDecl__UnsettableAssignment_1_611294 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_rule__EReferenceDecl__DerivedAssignment_1_711338 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_rule__EReferenceDecl__ContainmentAssignment_2_011382 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_rule__EReferenceDecl__EGenericTypeAssignment_311421 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__EReferenceDecl__LowerBoundAssignment_4_111452 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSINT_in_rule__EReferenceDecl__UpperBoundAssignment_4_2_111483 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EReferenceDecl__EOppositeAssignment_5_111518 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EReferenceDecl__NameAssignment_611553 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAnnotationDecl_in_rule__EEnumDecl__EAnnotationsAssignment_011584 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EEnumDecl__NameAssignment_211615 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEEnumLiteralDecl_in_rule__EEnumDecl__ELiteralsAssignment_411646 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAnnotationDecl_in_rule__EEnumLiteralDecl__EAnnotationsAssignment_011677 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EEnumLiteralDecl__NameAssignment_111708 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__EEnumLiteralDecl__ValueAssignment_2_111739 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__EEnumLiteralDecl__LiteralAssignment_311770 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ETypeParameterDecl__NameAssignment_011801 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_rule__ETypeParameterDecl__EBoundsAssignment_1_111832 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EGenericTypeReferenceDecl__EClassifierAssignment_0_011867 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_111902 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_2_111933 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EGenericTypeReferenceDecl__ETypeParameterAssignment_1_111968 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EGenericTypeDecl__EClassifierAssignment_0_012007 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_112042 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_2_112073 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EGenericTypeDecl__ETypeParameterAssignment_1_112108 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_rule__EGenericTypeDecl__EUpperBoundAssignment_2_1_0_112143 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_rule__EGenericTypeDecl__ELowerBoundAssignment_2_1_1_112174 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAnnotationDecl_in_rule__EOperationDecl__EAnnotationsAssignment_012205 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_BAG_in_rule__EOperationDecl__UniqueAssignment_1_012236 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_RANDOM_in_rule__EOperationDecl__OrderedAssignment_1_112267 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_rule__EOperationDecl__EGenericTypeAssignment_3_012298 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EOperationDecl__NameAssignment_412329 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleETypeParameterDecl_in_rule__EOperationDecl__ETypeParametersAssignment_5_112360 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleETypeParameterDecl_in_rule__EOperationDecl__ETypeParametersAssignment_5_2_112391 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEParameterDecl_in_rule__EOperationDecl__EParametersAssignment_7_012422 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEParameterDecl_in_rule__EOperationDecl__EParametersAssignment_7_1_112453 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_rule__EOperationDecl__EGenericExceptionsAssignment_9_112484 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_rule__EOperationDecl__EGenericExceptionsAssignment_9_2_112515 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAnnotationDecl_in_rule__EParameterDecl__EAnnotationsAssignment_012546 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_rule__EParameterDecl__EGenericTypeAssignment_112577 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EParameterDecl__NameAssignment_212608 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__MapEntry__KeyAssignment_012639 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__MapEntry__ValueAssignment_212670 = new BitSet(new long[]{0x0000000000000002L});
    }


}
package org.eclipse.xtext.example.ui.contentassist.antlr.internal; 

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
    public String getGrammarFileName() { return "../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g"; }


     
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:60:1: entryRuleEcoreDsl : ruleEcoreDsl EOF ;
    public final void entryRuleEcoreDsl() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:61:1: ( ruleEcoreDsl EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:62:1: ruleEcoreDsl EOF
            {
             before(grammarAccess.getEcoreDslRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEcoreDsl_in_entryRuleEcoreDsl61);
            ruleEcoreDsl();
            _fsp--;

             after(grammarAccess.getEcoreDslRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEcoreDsl68); 

            }

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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:69:1: ruleEcoreDsl : ( ( rule__EcoreDsl__Group__0 ) ) ;
    public final void ruleEcoreDsl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:73:2: ( ( ( rule__EcoreDsl__Group__0 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:74:1: ( ( rule__EcoreDsl__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:74:1: ( ( rule__EcoreDsl__Group__0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:75:1: ( rule__EcoreDsl__Group__0 )
            {
             before(grammarAccess.getEcoreDslAccess().getGroup()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:76:1: ( rule__EcoreDsl__Group__0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:76:2: rule__EcoreDsl__Group__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:88:1: entryRuleReferencedMetamodel : ruleReferencedMetamodel EOF ;
    public final void entryRuleReferencedMetamodel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:89:1: ( ruleReferencedMetamodel EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:90:1: ruleReferencedMetamodel EOF
            {
             before(grammarAccess.getReferencedMetamodelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel121);
            ruleReferencedMetamodel();
            _fsp--;

             after(grammarAccess.getReferencedMetamodelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferencedMetamodel128); 

            }

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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:97:1: ruleReferencedMetamodel : ( ( rule__ReferencedMetamodel__Group__0 ) ) ;
    public final void ruleReferencedMetamodel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:101:2: ( ( ( rule__ReferencedMetamodel__Group__0 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:102:1: ( ( rule__ReferencedMetamodel__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:102:1: ( ( rule__ReferencedMetamodel__Group__0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:103:1: ( rule__ReferencedMetamodel__Group__0 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getGroup()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:104:1: ( rule__ReferencedMetamodel__Group__0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:104:2: rule__ReferencedMetamodel__Group__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:116:1: entryRuleEPackageDecl : ruleEPackageDecl EOF ;
    public final void entryRuleEPackageDecl() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:117:1: ( ruleEPackageDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:118:1: ruleEPackageDecl EOF
            {
             before(grammarAccess.getEPackageDeclRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEPackageDecl_in_entryRuleEPackageDecl181);
            ruleEPackageDecl();
            _fsp--;

             after(grammarAccess.getEPackageDeclRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEPackageDecl188); 

            }

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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:125:1: ruleEPackageDecl : ( ( rule__EPackageDecl__Group__0 ) ) ;
    public final void ruleEPackageDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:129:2: ( ( ( rule__EPackageDecl__Group__0 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:130:1: ( ( rule__EPackageDecl__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:130:1: ( ( rule__EPackageDecl__Group__0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:131:1: ( rule__EPackageDecl__Group__0 )
            {
             before(grammarAccess.getEPackageDeclAccess().getGroup()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:132:1: ( rule__EPackageDecl__Group__0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:132:2: rule__EPackageDecl__Group__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:144:1: entryRuleSubEPackageDecl : ruleSubEPackageDecl EOF ;
    public final void entryRuleSubEPackageDecl() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:145:1: ( ruleSubEPackageDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:146:1: ruleSubEPackageDecl EOF
            {
             before(grammarAccess.getSubEPackageDeclRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSubEPackageDecl_in_entryRuleSubEPackageDecl241);
            ruleSubEPackageDecl();
            _fsp--;

             after(grammarAccess.getSubEPackageDeclRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSubEPackageDecl248); 

            }

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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:153:1: ruleSubEPackageDecl : ( ( rule__SubEPackageDecl__Group__0 ) ) ;
    public final void ruleSubEPackageDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:157:2: ( ( ( rule__SubEPackageDecl__Group__0 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:158:1: ( ( rule__SubEPackageDecl__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:158:1: ( ( rule__SubEPackageDecl__Group__0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:159:1: ( rule__SubEPackageDecl__Group__0 )
            {
             before(grammarAccess.getSubEPackageDeclAccess().getGroup()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:160:1: ( rule__SubEPackageDecl__Group__0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:160:2: rule__SubEPackageDecl__Group__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:172:1: entryRuleEClassifierDecl : ruleEClassifierDecl EOF ;
    public final void entryRuleEClassifierDecl() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:173:1: ( ruleEClassifierDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:174:1: ruleEClassifierDecl EOF
            {
             before(grammarAccess.getEClassifierDeclRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEClassifierDecl_in_entryRuleEClassifierDecl301);
            ruleEClassifierDecl();
            _fsp--;

             after(grammarAccess.getEClassifierDeclRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEClassifierDecl308); 

            }

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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:181:1: ruleEClassifierDecl : ( ( rule__EClassifierDecl__Alternatives ) ) ;
    public final void ruleEClassifierDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:185:2: ( ( ( rule__EClassifierDecl__Alternatives ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:186:1: ( ( rule__EClassifierDecl__Alternatives ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:186:1: ( ( rule__EClassifierDecl__Alternatives ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:187:1: ( rule__EClassifierDecl__Alternatives )
            {
             before(grammarAccess.getEClassifierDeclAccess().getAlternatives()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:188:1: ( rule__EClassifierDecl__Alternatives )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:188:2: rule__EClassifierDecl__Alternatives
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:200:1: entryRuleEDataTypeDecl : ruleEDataTypeDecl EOF ;
    public final void entryRuleEDataTypeDecl() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:201:1: ( ruleEDataTypeDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:202:1: ruleEDataTypeDecl EOF
            {
             before(grammarAccess.getEDataTypeDeclRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEDataTypeDecl_in_entryRuleEDataTypeDecl361);
            ruleEDataTypeDecl();
            _fsp--;

             after(grammarAccess.getEDataTypeDeclRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEDataTypeDecl368); 

            }

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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:209:1: ruleEDataTypeDecl : ( ( rule__EDataTypeDecl__Alternatives ) ) ;
    public final void ruleEDataTypeDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:213:2: ( ( ( rule__EDataTypeDecl__Alternatives ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:214:1: ( ( rule__EDataTypeDecl__Alternatives ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:214:1: ( ( rule__EDataTypeDecl__Alternatives ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:215:1: ( rule__EDataTypeDecl__Alternatives )
            {
             before(grammarAccess.getEDataTypeDeclAccess().getAlternatives()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:216:1: ( rule__EDataTypeDecl__Alternatives )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:216:2: rule__EDataTypeDecl__Alternatives
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:228:1: entryRuleEAnnotationDecl : ruleEAnnotationDecl EOF ;
    public final void entryRuleEAnnotationDecl() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:229:1: ( ruleEAnnotationDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:230:1: ruleEAnnotationDecl EOF
            {
             before(grammarAccess.getEAnnotationDeclRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEAnnotationDecl_in_entryRuleEAnnotationDecl421);
            ruleEAnnotationDecl();
            _fsp--;

             after(grammarAccess.getEAnnotationDeclRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEAnnotationDecl428); 

            }

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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:237:1: ruleEAnnotationDecl : ( ( rule__EAnnotationDecl__Group__0 ) ) ;
    public final void ruleEAnnotationDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:241:2: ( ( ( rule__EAnnotationDecl__Group__0 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:242:1: ( ( rule__EAnnotationDecl__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:242:1: ( ( rule__EAnnotationDecl__Group__0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:243:1: ( rule__EAnnotationDecl__Group__0 )
            {
             before(grammarAccess.getEAnnotationDeclAccess().getGroup()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:244:1: ( rule__EAnnotationDecl__Group__0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:244:2: rule__EAnnotationDecl__Group__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:256:1: entryRuleEClassDecl : ruleEClassDecl EOF ;
    public final void entryRuleEClassDecl() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:257:1: ( ruleEClassDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:258:1: ruleEClassDecl EOF
            {
             before(grammarAccess.getEClassDeclRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEClassDecl_in_entryRuleEClassDecl481);
            ruleEClassDecl();
            _fsp--;

             after(grammarAccess.getEClassDeclRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEClassDecl488); 

            }

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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:265:1: ruleEClassDecl : ( ( rule__EClassDecl__Group__0 ) ) ;
    public final void ruleEClassDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:269:2: ( ( ( rule__EClassDecl__Group__0 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:270:1: ( ( rule__EClassDecl__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:270:1: ( ( rule__EClassDecl__Group__0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:271:1: ( rule__EClassDecl__Group__0 )
            {
             before(grammarAccess.getEClassDeclAccess().getGroup()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:272:1: ( rule__EClassDecl__Group__0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:272:2: rule__EClassDecl__Group__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:284:1: entryRuleEStructuralFeatureDecl : ruleEStructuralFeatureDecl EOF ;
    public final void entryRuleEStructuralFeatureDecl() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:285:1: ( ruleEStructuralFeatureDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:286:1: ruleEStructuralFeatureDecl EOF
            {
             before(grammarAccess.getEStructuralFeatureDeclRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEStructuralFeatureDecl_in_entryRuleEStructuralFeatureDecl541);
            ruleEStructuralFeatureDecl();
            _fsp--;

             after(grammarAccess.getEStructuralFeatureDeclRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEStructuralFeatureDecl548); 

            }

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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:293:1: ruleEStructuralFeatureDecl : ( ( rule__EStructuralFeatureDecl__Alternatives ) ) ;
    public final void ruleEStructuralFeatureDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:297:2: ( ( ( rule__EStructuralFeatureDecl__Alternatives ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:298:1: ( ( rule__EStructuralFeatureDecl__Alternatives ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:298:1: ( ( rule__EStructuralFeatureDecl__Alternatives ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:299:1: ( rule__EStructuralFeatureDecl__Alternatives )
            {
             before(grammarAccess.getEStructuralFeatureDeclAccess().getAlternatives()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:300:1: ( rule__EStructuralFeatureDecl__Alternatives )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:300:2: rule__EStructuralFeatureDecl__Alternatives
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:312:1: entryRuleEAttributeDecl : ruleEAttributeDecl EOF ;
    public final void entryRuleEAttributeDecl() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:313:1: ( ruleEAttributeDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:314:1: ruleEAttributeDecl EOF
            {
             before(grammarAccess.getEAttributeDeclRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEAttributeDecl_in_entryRuleEAttributeDecl601);
            ruleEAttributeDecl();
            _fsp--;

             after(grammarAccess.getEAttributeDeclRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEAttributeDecl608); 

            }

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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:321:1: ruleEAttributeDecl : ( ( rule__EAttributeDecl__Group__0 ) ) ;
    public final void ruleEAttributeDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:325:2: ( ( ( rule__EAttributeDecl__Group__0 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:326:1: ( ( rule__EAttributeDecl__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:326:1: ( ( rule__EAttributeDecl__Group__0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:327:1: ( rule__EAttributeDecl__Group__0 )
            {
             before(grammarAccess.getEAttributeDeclAccess().getGroup()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:328:1: ( rule__EAttributeDecl__Group__0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:328:2: rule__EAttributeDecl__Group__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:340:1: entryRuleEReferenceDecl : ruleEReferenceDecl EOF ;
    public final void entryRuleEReferenceDecl() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:341:1: ( ruleEReferenceDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:342:1: ruleEReferenceDecl EOF
            {
             before(grammarAccess.getEReferenceDeclRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEReferenceDecl_in_entryRuleEReferenceDecl661);
            ruleEReferenceDecl();
            _fsp--;

             after(grammarAccess.getEReferenceDeclRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEReferenceDecl668); 

            }

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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:349:1: ruleEReferenceDecl : ( ( rule__EReferenceDecl__Group__0 ) ) ;
    public final void ruleEReferenceDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:353:2: ( ( ( rule__EReferenceDecl__Group__0 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:354:1: ( ( rule__EReferenceDecl__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:354:1: ( ( rule__EReferenceDecl__Group__0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:355:1: ( rule__EReferenceDecl__Group__0 )
            {
             before(grammarAccess.getEReferenceDeclAccess().getGroup()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:356:1: ( rule__EReferenceDecl__Group__0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:356:2: rule__EReferenceDecl__Group__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:368:1: entryRuleEEnumDecl : ruleEEnumDecl EOF ;
    public final void entryRuleEEnumDecl() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:369:1: ( ruleEEnumDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:370:1: ruleEEnumDecl EOF
            {
             before(grammarAccess.getEEnumDeclRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEEnumDecl_in_entryRuleEEnumDecl721);
            ruleEEnumDecl();
            _fsp--;

             after(grammarAccess.getEEnumDeclRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEEnumDecl728); 

            }

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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:377:1: ruleEEnumDecl : ( ( rule__EEnumDecl__Group__0 ) ) ;
    public final void ruleEEnumDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:381:2: ( ( ( rule__EEnumDecl__Group__0 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:382:1: ( ( rule__EEnumDecl__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:382:1: ( ( rule__EEnumDecl__Group__0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:383:1: ( rule__EEnumDecl__Group__0 )
            {
             before(grammarAccess.getEEnumDeclAccess().getGroup()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:384:1: ( rule__EEnumDecl__Group__0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:384:2: rule__EEnumDecl__Group__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:396:1: entryRuleEEnumLiteralDecl : ruleEEnumLiteralDecl EOF ;
    public final void entryRuleEEnumLiteralDecl() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:397:1: ( ruleEEnumLiteralDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:398:1: ruleEEnumLiteralDecl EOF
            {
             before(grammarAccess.getEEnumLiteralDeclRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEEnumLiteralDecl_in_entryRuleEEnumLiteralDecl781);
            ruleEEnumLiteralDecl();
            _fsp--;

             after(grammarAccess.getEEnumLiteralDeclRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEEnumLiteralDecl788); 

            }

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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:405:1: ruleEEnumLiteralDecl : ( ( rule__EEnumLiteralDecl__Group__0 ) ) ;
    public final void ruleEEnumLiteralDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:409:2: ( ( ( rule__EEnumLiteralDecl__Group__0 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:410:1: ( ( rule__EEnumLiteralDecl__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:410:1: ( ( rule__EEnumLiteralDecl__Group__0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:411:1: ( rule__EEnumLiteralDecl__Group__0 )
            {
             before(grammarAccess.getEEnumLiteralDeclAccess().getGroup()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:412:1: ( rule__EEnumLiteralDecl__Group__0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:412:2: rule__EEnumLiteralDecl__Group__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:424:1: entryRuleETypeParameterDecl : ruleETypeParameterDecl EOF ;
    public final void entryRuleETypeParameterDecl() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:425:1: ( ruleETypeParameterDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:426:1: ruleETypeParameterDecl EOF
            {
             before(grammarAccess.getETypeParameterDeclRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleETypeParameterDecl_in_entryRuleETypeParameterDecl841);
            ruleETypeParameterDecl();
            _fsp--;

             after(grammarAccess.getETypeParameterDeclRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleETypeParameterDecl848); 

            }

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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:433:1: ruleETypeParameterDecl : ( ( rule__ETypeParameterDecl__Group__0 ) ) ;
    public final void ruleETypeParameterDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:437:2: ( ( ( rule__ETypeParameterDecl__Group__0 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:438:1: ( ( rule__ETypeParameterDecl__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:438:1: ( ( rule__ETypeParameterDecl__Group__0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:439:1: ( rule__ETypeParameterDecl__Group__0 )
            {
             before(grammarAccess.getETypeParameterDeclAccess().getGroup()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:440:1: ( rule__ETypeParameterDecl__Group__0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:440:2: rule__ETypeParameterDecl__Group__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:452:1: entryRuleEGenericTypeReferenceDecl : ruleEGenericTypeReferenceDecl EOF ;
    public final void entryRuleEGenericTypeReferenceDecl() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:453:1: ( ruleEGenericTypeReferenceDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:454:1: ruleEGenericTypeReferenceDecl EOF
            {
             before(grammarAccess.getEGenericTypeReferenceDeclRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeReferenceDecl_in_entryRuleEGenericTypeReferenceDecl901);
            ruleEGenericTypeReferenceDecl();
            _fsp--;

             after(grammarAccess.getEGenericTypeReferenceDeclRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEGenericTypeReferenceDecl908); 

            }

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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:461:1: ruleEGenericTypeReferenceDecl : ( ( rule__EGenericTypeReferenceDecl__Alternatives ) ) ;
    public final void ruleEGenericTypeReferenceDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:465:2: ( ( ( rule__EGenericTypeReferenceDecl__Alternatives ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:466:1: ( ( rule__EGenericTypeReferenceDecl__Alternatives ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:466:1: ( ( rule__EGenericTypeReferenceDecl__Alternatives ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:467:1: ( rule__EGenericTypeReferenceDecl__Alternatives )
            {
             before(grammarAccess.getEGenericTypeReferenceDeclAccess().getAlternatives()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:468:1: ( rule__EGenericTypeReferenceDecl__Alternatives )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:468:2: rule__EGenericTypeReferenceDecl__Alternatives
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:480:1: entryRuleEGenericTypeDecl : ruleEGenericTypeDecl EOF ;
    public final void entryRuleEGenericTypeDecl() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:481:1: ( ruleEGenericTypeDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:482:1: ruleEGenericTypeDecl EOF
            {
             before(grammarAccess.getEGenericTypeDeclRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeDecl_in_entryRuleEGenericTypeDecl961);
            ruleEGenericTypeDecl();
            _fsp--;

             after(grammarAccess.getEGenericTypeDeclRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEGenericTypeDecl968); 

            }

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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:489:1: ruleEGenericTypeDecl : ( ( rule__EGenericTypeDecl__Alternatives ) ) ;
    public final void ruleEGenericTypeDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:493:2: ( ( ( rule__EGenericTypeDecl__Alternatives ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:494:1: ( ( rule__EGenericTypeDecl__Alternatives ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:494:1: ( ( rule__EGenericTypeDecl__Alternatives ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:495:1: ( rule__EGenericTypeDecl__Alternatives )
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getAlternatives()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:496:1: ( rule__EGenericTypeDecl__Alternatives )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:496:2: rule__EGenericTypeDecl__Alternatives
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:508:1: entryRuleEOperationDecl : ruleEOperationDecl EOF ;
    public final void entryRuleEOperationDecl() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:509:1: ( ruleEOperationDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:510:1: ruleEOperationDecl EOF
            {
             before(grammarAccess.getEOperationDeclRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEOperationDecl_in_entryRuleEOperationDecl1021);
            ruleEOperationDecl();
            _fsp--;

             after(grammarAccess.getEOperationDeclRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEOperationDecl1028); 

            }

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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:517:1: ruleEOperationDecl : ( ( rule__EOperationDecl__Group__0 ) ) ;
    public final void ruleEOperationDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:521:2: ( ( ( rule__EOperationDecl__Group__0 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:522:1: ( ( rule__EOperationDecl__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:522:1: ( ( rule__EOperationDecl__Group__0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:523:1: ( rule__EOperationDecl__Group__0 )
            {
             before(grammarAccess.getEOperationDeclAccess().getGroup()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:524:1: ( rule__EOperationDecl__Group__0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:524:2: rule__EOperationDecl__Group__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:536:1: entryRuleEParameterDecl : ruleEParameterDecl EOF ;
    public final void entryRuleEParameterDecl() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:537:1: ( ruleEParameterDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:538:1: ruleEParameterDecl EOF
            {
             before(grammarAccess.getEParameterDeclRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEParameterDecl_in_entryRuleEParameterDecl1081);
            ruleEParameterDecl();
            _fsp--;

             after(grammarAccess.getEParameterDeclRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEParameterDecl1088); 

            }

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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:545:1: ruleEParameterDecl : ( ( rule__EParameterDecl__Group__0 ) ) ;
    public final void ruleEParameterDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:549:2: ( ( ( rule__EParameterDecl__Group__0 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:550:1: ( ( rule__EParameterDecl__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:550:1: ( ( rule__EParameterDecl__Group__0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:551:1: ( rule__EParameterDecl__Group__0 )
            {
             before(grammarAccess.getEParameterDeclAccess().getGroup()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:552:1: ( rule__EParameterDecl__Group__0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:552:2: rule__EParameterDecl__Group__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:564:1: entryRuleMapEntry : ruleMapEntry EOF ;
    public final void entryRuleMapEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:565:1: ( ruleMapEntry EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:566:1: ruleMapEntry EOF
            {
             before(grammarAccess.getMapEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMapEntry_in_entryRuleMapEntry1141);
            ruleMapEntry();
            _fsp--;

             after(grammarAccess.getMapEntryRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMapEntry1148); 

            }

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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:573:1: ruleMapEntry : ( ( rule__MapEntry__Group__0 ) ) ;
    public final void ruleMapEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:577:2: ( ( ( rule__MapEntry__Group__0 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:578:1: ( ( rule__MapEntry__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:578:1: ( ( rule__MapEntry__Group__0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:579:1: ( rule__MapEntry__Group__0 )
            {
             before(grammarAccess.getMapEntryAccess().getGroup()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:580:1: ( rule__MapEntry__Group__0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:580:2: rule__MapEntry__Group__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:592:1: entryRuleQID : ruleQID EOF ;
    public final void entryRuleQID() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:593:1: ( ruleQID EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:594:1: ruleQID EOF
            {
             before(grammarAccess.getQIDRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleQID_in_entryRuleQID1201);
            ruleQID();
            _fsp--;

             after(grammarAccess.getQIDRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQID1208); 

            }

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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:601:1: ruleQID : ( ( rule__QID__Group__0 ) ) ;
    public final void ruleQID() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:605:2: ( ( ( rule__QID__Group__0 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:606:1: ( ( rule__QID__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:606:1: ( ( rule__QID__Group__0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:607:1: ( rule__QID__Group__0 )
            {
             before(grammarAccess.getQIDAccess().getGroup()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:608:1: ( rule__QID__Group__0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:608:2: rule__QID__Group__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:620:1: entryRuleSTRING_OR_QID : ruleSTRING_OR_QID EOF ;
    public final void entryRuleSTRING_OR_QID() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:621:1: ( ruleSTRING_OR_QID EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:622:1: ruleSTRING_OR_QID EOF
            {
             before(grammarAccess.getSTRING_OR_QIDRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSTRING_OR_QID_in_entryRuleSTRING_OR_QID1261);
            ruleSTRING_OR_QID();
            _fsp--;

             after(grammarAccess.getSTRING_OR_QIDRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSTRING_OR_QID1268); 

            }

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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:629:1: ruleSTRING_OR_QID : ( ( rule__STRING_OR_QID__Alternatives ) ) ;
    public final void ruleSTRING_OR_QID() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:633:2: ( ( ( rule__STRING_OR_QID__Alternatives ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:634:1: ( ( rule__STRING_OR_QID__Alternatives ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:634:1: ( ( rule__STRING_OR_QID__Alternatives ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:635:1: ( rule__STRING_OR_QID__Alternatives )
            {
             before(grammarAccess.getSTRING_OR_QIDAccess().getAlternatives()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:636:1: ( rule__STRING_OR_QID__Alternatives )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:636:2: rule__STRING_OR_QID__Alternatives
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:648:1: entryRuleSINT : ruleSINT EOF ;
    public final void entryRuleSINT() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:649:1: ( ruleSINT EOF )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:650:1: ruleSINT EOF
            {
             before(grammarAccess.getSINTRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSINT_in_entryRuleSINT1321);
            ruleSINT();
            _fsp--;

             after(grammarAccess.getSINTRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSINT1328); 

            }

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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:657:1: ruleSINT : ( ( rule__SINT__Group__0 ) ) ;
    public final void ruleSINT() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:661:2: ( ( ( rule__SINT__Group__0 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:662:1: ( ( rule__SINT__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:662:1: ( ( rule__SINT__Group__0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:663:1: ( rule__SINT__Group__0 )
            {
             before(grammarAccess.getSINTAccess().getGroup()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:664:1: ( rule__SINT__Group__0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:664:2: rule__SINT__Group__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:676:1: rule__EPackageDecl__Alternatives_10 : ( ( ( rule__EPackageDecl__ESubpackagesAssignment_10_0 ) ) | ( ( rule__EPackageDecl__EClassifiersAssignment_10_1 ) ) );
    public final void rule__EPackageDecl__Alternatives_10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:680:1: ( ( ( rule__EPackageDecl__ESubpackagesAssignment_10_0 ) ) | ( ( rule__EPackageDecl__EClassifiersAssignment_10_1 ) ) )
            int alt1=2;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:681:1: ( ( rule__EPackageDecl__ESubpackagesAssignment_10_0 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:681:1: ( ( rule__EPackageDecl__ESubpackagesAssignment_10_0 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:682:1: ( rule__EPackageDecl__ESubpackagesAssignment_10_0 )
                    {
                     before(grammarAccess.getEPackageDeclAccess().getESubpackagesAssignment_10_0()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:683:1: ( rule__EPackageDecl__ESubpackagesAssignment_10_0 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:683:2: rule__EPackageDecl__ESubpackagesAssignment_10_0
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
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:687:6: ( ( rule__EPackageDecl__EClassifiersAssignment_10_1 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:687:6: ( ( rule__EPackageDecl__EClassifiersAssignment_10_1 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:688:1: ( rule__EPackageDecl__EClassifiersAssignment_10_1 )
                    {
                     before(grammarAccess.getEPackageDeclAccess().getEClassifiersAssignment_10_1()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:689:1: ( rule__EPackageDecl__EClassifiersAssignment_10_1 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:689:2: rule__EPackageDecl__EClassifiersAssignment_10_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:698:1: rule__SubEPackageDecl__Alternatives_4 : ( ( ( rule__SubEPackageDecl__ESubpackagesAssignment_4_0 ) ) | ( ( rule__SubEPackageDecl__EClassifiersAssignment_4_1 ) ) );
    public final void rule__SubEPackageDecl__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:702:1: ( ( ( rule__SubEPackageDecl__ESubpackagesAssignment_4_0 ) ) | ( ( rule__SubEPackageDecl__EClassifiersAssignment_4_1 ) ) )
            int alt2=2;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:703:1: ( ( rule__SubEPackageDecl__ESubpackagesAssignment_4_0 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:703:1: ( ( rule__SubEPackageDecl__ESubpackagesAssignment_4_0 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:704:1: ( rule__SubEPackageDecl__ESubpackagesAssignment_4_0 )
                    {
                     before(grammarAccess.getSubEPackageDeclAccess().getESubpackagesAssignment_4_0()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:705:1: ( rule__SubEPackageDecl__ESubpackagesAssignment_4_0 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:705:2: rule__SubEPackageDecl__ESubpackagesAssignment_4_0
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
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:709:6: ( ( rule__SubEPackageDecl__EClassifiersAssignment_4_1 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:709:6: ( ( rule__SubEPackageDecl__EClassifiersAssignment_4_1 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:710:1: ( rule__SubEPackageDecl__EClassifiersAssignment_4_1 )
                    {
                     before(grammarAccess.getSubEPackageDeclAccess().getEClassifiersAssignment_4_1()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:711:1: ( rule__SubEPackageDecl__EClassifiersAssignment_4_1 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:711:2: rule__SubEPackageDecl__EClassifiersAssignment_4_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:720:1: rule__EClassifierDecl__Alternatives : ( ( ruleEClassDecl ) | ( ruleEDataTypeDecl ) );
    public final void rule__EClassifierDecl__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:724:1: ( ( ruleEClassDecl ) | ( ruleEDataTypeDecl ) )
            int alt3=2;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:725:1: ( ruleEClassDecl )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:725:1: ( ruleEClassDecl )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:726:1: ruleEClassDecl
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
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:731:6: ( ruleEDataTypeDecl )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:731:6: ( ruleEDataTypeDecl )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:732:1: ruleEDataTypeDecl
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:742:1: rule__EDataTypeDecl__Alternatives : ( ( ( rule__EDataTypeDecl__Group_0__0 ) ) | ( ruleEEnumDecl ) );
    public final void rule__EDataTypeDecl__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:746:1: ( ( ( rule__EDataTypeDecl__Group_0__0 ) ) | ( ruleEEnumDecl ) )
            int alt4=2;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:747:1: ( ( rule__EDataTypeDecl__Group_0__0 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:747:1: ( ( rule__EDataTypeDecl__Group_0__0 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:748:1: ( rule__EDataTypeDecl__Group_0__0 )
                    {
                     before(grammarAccess.getEDataTypeDeclAccess().getGroup_0()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:749:1: ( rule__EDataTypeDecl__Group_0__0 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:749:2: rule__EDataTypeDecl__Group_0__0
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
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:753:6: ( ruleEEnumDecl )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:753:6: ( ruleEEnumDecl )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:754:1: ruleEEnumDecl
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:764:1: rule__EClassDecl__Alternatives_2 : ( ( ( rule__EClassDecl__InterfaceAssignment_2_0 ) ) | ( 'class' ) );
    public final void rule__EClassDecl__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:768:1: ( ( ( rule__EClassDecl__InterfaceAssignment_2_0 ) ) | ( 'class' ) )
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
                    new NoViableAltException("764:1: rule__EClassDecl__Alternatives_2 : ( ( ( rule__EClassDecl__InterfaceAssignment_2_0 ) ) | ( 'class' ) );", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:769:1: ( ( rule__EClassDecl__InterfaceAssignment_2_0 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:769:1: ( ( rule__EClassDecl__InterfaceAssignment_2_0 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:770:1: ( rule__EClassDecl__InterfaceAssignment_2_0 )
                    {
                     before(grammarAccess.getEClassDeclAccess().getInterfaceAssignment_2_0()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:771:1: ( rule__EClassDecl__InterfaceAssignment_2_0 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:771:2: rule__EClassDecl__InterfaceAssignment_2_0
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
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:775:6: ( 'class' )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:775:6: ( 'class' )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:776:1: 'class'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:788:1: rule__EClassDecl__Alternatives_8 : ( ( ( rule__EClassDecl__EStructuralFeaturesAssignment_8_0 ) ) | ( ( rule__EClassDecl__EOperationsAssignment_8_1 ) ) );
    public final void rule__EClassDecl__Alternatives_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:792:1: ( ( ( rule__EClassDecl__EStructuralFeaturesAssignment_8_0 ) ) | ( ( rule__EClassDecl__EOperationsAssignment_8_1 ) ) )
            int alt6=2;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:793:1: ( ( rule__EClassDecl__EStructuralFeaturesAssignment_8_0 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:793:1: ( ( rule__EClassDecl__EStructuralFeaturesAssignment_8_0 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:794:1: ( rule__EClassDecl__EStructuralFeaturesAssignment_8_0 )
                    {
                     before(grammarAccess.getEClassDeclAccess().getEStructuralFeaturesAssignment_8_0()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:795:1: ( rule__EClassDecl__EStructuralFeaturesAssignment_8_0 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:795:2: rule__EClassDecl__EStructuralFeaturesAssignment_8_0
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
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:799:6: ( ( rule__EClassDecl__EOperationsAssignment_8_1 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:799:6: ( ( rule__EClassDecl__EOperationsAssignment_8_1 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:800:1: ( rule__EClassDecl__EOperationsAssignment_8_1 )
                    {
                     before(grammarAccess.getEClassDeclAccess().getEOperationsAssignment_8_1()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:801:1: ( rule__EClassDecl__EOperationsAssignment_8_1 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:801:2: rule__EClassDecl__EOperationsAssignment_8_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:810:1: rule__EStructuralFeatureDecl__Alternatives : ( ( ruleEAttributeDecl ) | ( ruleEReferenceDecl ) );
    public final void rule__EStructuralFeatureDecl__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:814:1: ( ( ruleEAttributeDecl ) | ( ruleEReferenceDecl ) )
            int alt7=2;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:815:1: ( ruleEAttributeDecl )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:815:1: ( ruleEAttributeDecl )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:816:1: ruleEAttributeDecl
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
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:821:6: ( ruleEReferenceDecl )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:821:6: ( ruleEReferenceDecl )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:822:1: ruleEReferenceDecl
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:832:1: rule__EAttributeDecl__Alternatives_1 : ( ( ( rule__EAttributeDecl__IDAssignment_1_0 ) ) | ( ( rule__EAttributeDecl__UniqueAssignment_1_1 ) ) | ( ( rule__EAttributeDecl__OrderedAssignment_1_2 ) ) | ( ( rule__EAttributeDecl__ChangeableAssignment_1_3 ) ) | ( ( rule__EAttributeDecl__VolatileAssignment_1_4 ) ) | ( ( rule__EAttributeDecl__TransientAssignment_1_5 ) ) | ( ( rule__EAttributeDecl__UnsettableAssignment_1_6 ) ) | ( ( rule__EAttributeDecl__DerivedAssignment_1_7 ) ) );
    public final void rule__EAttributeDecl__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:836:1: ( ( ( rule__EAttributeDecl__IDAssignment_1_0 ) ) | ( ( rule__EAttributeDecl__UniqueAssignment_1_1 ) ) | ( ( rule__EAttributeDecl__OrderedAssignment_1_2 ) ) | ( ( rule__EAttributeDecl__ChangeableAssignment_1_3 ) ) | ( ( rule__EAttributeDecl__VolatileAssignment_1_4 ) ) | ( ( rule__EAttributeDecl__TransientAssignment_1_5 ) ) | ( ( rule__EAttributeDecl__UnsettableAssignment_1_6 ) ) | ( ( rule__EAttributeDecl__DerivedAssignment_1_7 ) ) )
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
                    new NoViableAltException("832:1: rule__EAttributeDecl__Alternatives_1 : ( ( ( rule__EAttributeDecl__IDAssignment_1_0 ) ) | ( ( rule__EAttributeDecl__UniqueAssignment_1_1 ) ) | ( ( rule__EAttributeDecl__OrderedAssignment_1_2 ) ) | ( ( rule__EAttributeDecl__ChangeableAssignment_1_3 ) ) | ( ( rule__EAttributeDecl__VolatileAssignment_1_4 ) ) | ( ( rule__EAttributeDecl__TransientAssignment_1_5 ) ) | ( ( rule__EAttributeDecl__UnsettableAssignment_1_6 ) ) | ( ( rule__EAttributeDecl__DerivedAssignment_1_7 ) ) );", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:837:1: ( ( rule__EAttributeDecl__IDAssignment_1_0 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:837:1: ( ( rule__EAttributeDecl__IDAssignment_1_0 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:838:1: ( rule__EAttributeDecl__IDAssignment_1_0 )
                    {
                     before(grammarAccess.getEAttributeDeclAccess().getIDAssignment_1_0()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:839:1: ( rule__EAttributeDecl__IDAssignment_1_0 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:839:2: rule__EAttributeDecl__IDAssignment_1_0
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
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:843:6: ( ( rule__EAttributeDecl__UniqueAssignment_1_1 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:843:6: ( ( rule__EAttributeDecl__UniqueAssignment_1_1 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:844:1: ( rule__EAttributeDecl__UniqueAssignment_1_1 )
                    {
                     before(grammarAccess.getEAttributeDeclAccess().getUniqueAssignment_1_1()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:845:1: ( rule__EAttributeDecl__UniqueAssignment_1_1 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:845:2: rule__EAttributeDecl__UniqueAssignment_1_1
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
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:849:6: ( ( rule__EAttributeDecl__OrderedAssignment_1_2 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:849:6: ( ( rule__EAttributeDecl__OrderedAssignment_1_2 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:850:1: ( rule__EAttributeDecl__OrderedAssignment_1_2 )
                    {
                     before(grammarAccess.getEAttributeDeclAccess().getOrderedAssignment_1_2()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:851:1: ( rule__EAttributeDecl__OrderedAssignment_1_2 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:851:2: rule__EAttributeDecl__OrderedAssignment_1_2
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
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:855:6: ( ( rule__EAttributeDecl__ChangeableAssignment_1_3 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:855:6: ( ( rule__EAttributeDecl__ChangeableAssignment_1_3 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:856:1: ( rule__EAttributeDecl__ChangeableAssignment_1_3 )
                    {
                     before(grammarAccess.getEAttributeDeclAccess().getChangeableAssignment_1_3()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:857:1: ( rule__EAttributeDecl__ChangeableAssignment_1_3 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:857:2: rule__EAttributeDecl__ChangeableAssignment_1_3
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
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:861:6: ( ( rule__EAttributeDecl__VolatileAssignment_1_4 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:861:6: ( ( rule__EAttributeDecl__VolatileAssignment_1_4 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:862:1: ( rule__EAttributeDecl__VolatileAssignment_1_4 )
                    {
                     before(grammarAccess.getEAttributeDeclAccess().getVolatileAssignment_1_4()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:863:1: ( rule__EAttributeDecl__VolatileAssignment_1_4 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:863:2: rule__EAttributeDecl__VolatileAssignment_1_4
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
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:867:6: ( ( rule__EAttributeDecl__TransientAssignment_1_5 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:867:6: ( ( rule__EAttributeDecl__TransientAssignment_1_5 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:868:1: ( rule__EAttributeDecl__TransientAssignment_1_5 )
                    {
                     before(grammarAccess.getEAttributeDeclAccess().getTransientAssignment_1_5()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:869:1: ( rule__EAttributeDecl__TransientAssignment_1_5 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:869:2: rule__EAttributeDecl__TransientAssignment_1_5
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
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:873:6: ( ( rule__EAttributeDecl__UnsettableAssignment_1_6 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:873:6: ( ( rule__EAttributeDecl__UnsettableAssignment_1_6 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:874:1: ( rule__EAttributeDecl__UnsettableAssignment_1_6 )
                    {
                     before(grammarAccess.getEAttributeDeclAccess().getUnsettableAssignment_1_6()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:875:1: ( rule__EAttributeDecl__UnsettableAssignment_1_6 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:875:2: rule__EAttributeDecl__UnsettableAssignment_1_6
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
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:879:6: ( ( rule__EAttributeDecl__DerivedAssignment_1_7 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:879:6: ( ( rule__EAttributeDecl__DerivedAssignment_1_7 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:880:1: ( rule__EAttributeDecl__DerivedAssignment_1_7 )
                    {
                     before(grammarAccess.getEAttributeDeclAccess().getDerivedAssignment_1_7()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:881:1: ( rule__EAttributeDecl__DerivedAssignment_1_7 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:881:2: rule__EAttributeDecl__DerivedAssignment_1_7
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:890:1: rule__EReferenceDecl__Alternatives_1 : ( ( ( rule__EReferenceDecl__ResolveProxiesAssignment_1_0 ) ) | ( ( rule__EReferenceDecl__UniqueAssignment_1_1 ) ) | ( ( rule__EReferenceDecl__OrderedAssignment_1_2 ) ) | ( ( rule__EReferenceDecl__ChangeableAssignment_1_3 ) ) | ( ( rule__EReferenceDecl__VolatileAssignment_1_4 ) ) | ( ( rule__EReferenceDecl__TransientAssignment_1_5 ) ) | ( ( rule__EReferenceDecl__UnsettableAssignment_1_6 ) ) | ( ( rule__EReferenceDecl__DerivedAssignment_1_7 ) ) );
    public final void rule__EReferenceDecl__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:894:1: ( ( ( rule__EReferenceDecl__ResolveProxiesAssignment_1_0 ) ) | ( ( rule__EReferenceDecl__UniqueAssignment_1_1 ) ) | ( ( rule__EReferenceDecl__OrderedAssignment_1_2 ) ) | ( ( rule__EReferenceDecl__ChangeableAssignment_1_3 ) ) | ( ( rule__EReferenceDecl__VolatileAssignment_1_4 ) ) | ( ( rule__EReferenceDecl__TransientAssignment_1_5 ) ) | ( ( rule__EReferenceDecl__UnsettableAssignment_1_6 ) ) | ( ( rule__EReferenceDecl__DerivedAssignment_1_7 ) ) )
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
                    new NoViableAltException("890:1: rule__EReferenceDecl__Alternatives_1 : ( ( ( rule__EReferenceDecl__ResolveProxiesAssignment_1_0 ) ) | ( ( rule__EReferenceDecl__UniqueAssignment_1_1 ) ) | ( ( rule__EReferenceDecl__OrderedAssignment_1_2 ) ) | ( ( rule__EReferenceDecl__ChangeableAssignment_1_3 ) ) | ( ( rule__EReferenceDecl__VolatileAssignment_1_4 ) ) | ( ( rule__EReferenceDecl__TransientAssignment_1_5 ) ) | ( ( rule__EReferenceDecl__UnsettableAssignment_1_6 ) ) | ( ( rule__EReferenceDecl__DerivedAssignment_1_7 ) ) );", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:895:1: ( ( rule__EReferenceDecl__ResolveProxiesAssignment_1_0 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:895:1: ( ( rule__EReferenceDecl__ResolveProxiesAssignment_1_0 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:896:1: ( rule__EReferenceDecl__ResolveProxiesAssignment_1_0 )
                    {
                     before(grammarAccess.getEReferenceDeclAccess().getResolveProxiesAssignment_1_0()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:897:1: ( rule__EReferenceDecl__ResolveProxiesAssignment_1_0 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:897:2: rule__EReferenceDecl__ResolveProxiesAssignment_1_0
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
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:901:6: ( ( rule__EReferenceDecl__UniqueAssignment_1_1 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:901:6: ( ( rule__EReferenceDecl__UniqueAssignment_1_1 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:902:1: ( rule__EReferenceDecl__UniqueAssignment_1_1 )
                    {
                     before(grammarAccess.getEReferenceDeclAccess().getUniqueAssignment_1_1()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:903:1: ( rule__EReferenceDecl__UniqueAssignment_1_1 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:903:2: rule__EReferenceDecl__UniqueAssignment_1_1
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
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:907:6: ( ( rule__EReferenceDecl__OrderedAssignment_1_2 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:907:6: ( ( rule__EReferenceDecl__OrderedAssignment_1_2 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:908:1: ( rule__EReferenceDecl__OrderedAssignment_1_2 )
                    {
                     before(grammarAccess.getEReferenceDeclAccess().getOrderedAssignment_1_2()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:909:1: ( rule__EReferenceDecl__OrderedAssignment_1_2 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:909:2: rule__EReferenceDecl__OrderedAssignment_1_2
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
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:913:6: ( ( rule__EReferenceDecl__ChangeableAssignment_1_3 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:913:6: ( ( rule__EReferenceDecl__ChangeableAssignment_1_3 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:914:1: ( rule__EReferenceDecl__ChangeableAssignment_1_3 )
                    {
                     before(grammarAccess.getEReferenceDeclAccess().getChangeableAssignment_1_3()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:915:1: ( rule__EReferenceDecl__ChangeableAssignment_1_3 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:915:2: rule__EReferenceDecl__ChangeableAssignment_1_3
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
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:919:6: ( ( rule__EReferenceDecl__VolatileAssignment_1_4 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:919:6: ( ( rule__EReferenceDecl__VolatileAssignment_1_4 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:920:1: ( rule__EReferenceDecl__VolatileAssignment_1_4 )
                    {
                     before(grammarAccess.getEReferenceDeclAccess().getVolatileAssignment_1_4()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:921:1: ( rule__EReferenceDecl__VolatileAssignment_1_4 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:921:2: rule__EReferenceDecl__VolatileAssignment_1_4
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
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:925:6: ( ( rule__EReferenceDecl__TransientAssignment_1_5 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:925:6: ( ( rule__EReferenceDecl__TransientAssignment_1_5 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:926:1: ( rule__EReferenceDecl__TransientAssignment_1_5 )
                    {
                     before(grammarAccess.getEReferenceDeclAccess().getTransientAssignment_1_5()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:927:1: ( rule__EReferenceDecl__TransientAssignment_1_5 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:927:2: rule__EReferenceDecl__TransientAssignment_1_5
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
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:931:6: ( ( rule__EReferenceDecl__UnsettableAssignment_1_6 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:931:6: ( ( rule__EReferenceDecl__UnsettableAssignment_1_6 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:932:1: ( rule__EReferenceDecl__UnsettableAssignment_1_6 )
                    {
                     before(grammarAccess.getEReferenceDeclAccess().getUnsettableAssignment_1_6()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:933:1: ( rule__EReferenceDecl__UnsettableAssignment_1_6 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:933:2: rule__EReferenceDecl__UnsettableAssignment_1_6
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
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:937:6: ( ( rule__EReferenceDecl__DerivedAssignment_1_7 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:937:6: ( ( rule__EReferenceDecl__DerivedAssignment_1_7 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:938:1: ( rule__EReferenceDecl__DerivedAssignment_1_7 )
                    {
                     before(grammarAccess.getEReferenceDeclAccess().getDerivedAssignment_1_7()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:939:1: ( rule__EReferenceDecl__DerivedAssignment_1_7 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:939:2: rule__EReferenceDecl__DerivedAssignment_1_7
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:948:1: rule__EReferenceDecl__Alternatives_2 : ( ( ( rule__EReferenceDecl__ContainmentAssignment_2_0 ) ) | ( 'ref' ) );
    public final void rule__EReferenceDecl__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:952:1: ( ( ( rule__EReferenceDecl__ContainmentAssignment_2_0 ) ) | ( 'ref' ) )
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
                    new NoViableAltException("948:1: rule__EReferenceDecl__Alternatives_2 : ( ( ( rule__EReferenceDecl__ContainmentAssignment_2_0 ) ) | ( 'ref' ) );", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:953:1: ( ( rule__EReferenceDecl__ContainmentAssignment_2_0 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:953:1: ( ( rule__EReferenceDecl__ContainmentAssignment_2_0 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:954:1: ( rule__EReferenceDecl__ContainmentAssignment_2_0 )
                    {
                     before(grammarAccess.getEReferenceDeclAccess().getContainmentAssignment_2_0()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:955:1: ( rule__EReferenceDecl__ContainmentAssignment_2_0 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:955:2: rule__EReferenceDecl__ContainmentAssignment_2_0
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
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:959:6: ( 'ref' )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:959:6: ( 'ref' )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:960:1: 'ref'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:972:1: rule__EGenericTypeReferenceDecl__Alternatives : ( ( ( rule__EGenericTypeReferenceDecl__Group_0__0 ) ) | ( ( rule__EGenericTypeReferenceDecl__Group_1__0 ) ) );
    public final void rule__EGenericTypeReferenceDecl__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:976:1: ( ( ( rule__EGenericTypeReferenceDecl__Group_0__0 ) ) | ( ( rule__EGenericTypeReferenceDecl__Group_1__0 ) ) )
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
                    new NoViableAltException("972:1: rule__EGenericTypeReferenceDecl__Alternatives : ( ( ( rule__EGenericTypeReferenceDecl__Group_0__0 ) ) | ( ( rule__EGenericTypeReferenceDecl__Group_1__0 ) ) );", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:977:1: ( ( rule__EGenericTypeReferenceDecl__Group_0__0 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:977:1: ( ( rule__EGenericTypeReferenceDecl__Group_0__0 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:978:1: ( rule__EGenericTypeReferenceDecl__Group_0__0 )
                    {
                     before(grammarAccess.getEGenericTypeReferenceDeclAccess().getGroup_0()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:979:1: ( rule__EGenericTypeReferenceDecl__Group_0__0 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:979:2: rule__EGenericTypeReferenceDecl__Group_0__0
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
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:983:6: ( ( rule__EGenericTypeReferenceDecl__Group_1__0 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:983:6: ( ( rule__EGenericTypeReferenceDecl__Group_1__0 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:984:1: ( rule__EGenericTypeReferenceDecl__Group_1__0 )
                    {
                     before(grammarAccess.getEGenericTypeReferenceDeclAccess().getGroup_1()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:985:1: ( rule__EGenericTypeReferenceDecl__Group_1__0 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:985:2: rule__EGenericTypeReferenceDecl__Group_1__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:994:1: rule__EGenericTypeDecl__Alternatives : ( ( ( rule__EGenericTypeDecl__Group_0__0 ) ) | ( ( rule__EGenericTypeDecl__Group_1__0 ) ) | ( ( rule__EGenericTypeDecl__Group_2__0 ) ) );
    public final void rule__EGenericTypeDecl__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:998:1: ( ( ( rule__EGenericTypeDecl__Group_0__0 ) ) | ( ( rule__EGenericTypeDecl__Group_1__0 ) ) | ( ( rule__EGenericTypeDecl__Group_2__0 ) ) )
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
                    new NoViableAltException("994:1: rule__EGenericTypeDecl__Alternatives : ( ( ( rule__EGenericTypeDecl__Group_0__0 ) ) | ( ( rule__EGenericTypeDecl__Group_1__0 ) ) | ( ( rule__EGenericTypeDecl__Group_2__0 ) ) );", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:999:1: ( ( rule__EGenericTypeDecl__Group_0__0 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:999:1: ( ( rule__EGenericTypeDecl__Group_0__0 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1000:1: ( rule__EGenericTypeDecl__Group_0__0 )
                    {
                     before(grammarAccess.getEGenericTypeDeclAccess().getGroup_0()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1001:1: ( rule__EGenericTypeDecl__Group_0__0 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1001:2: rule__EGenericTypeDecl__Group_0__0
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
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1005:6: ( ( rule__EGenericTypeDecl__Group_1__0 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1005:6: ( ( rule__EGenericTypeDecl__Group_1__0 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1006:1: ( rule__EGenericTypeDecl__Group_1__0 )
                    {
                     before(grammarAccess.getEGenericTypeDeclAccess().getGroup_1()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1007:1: ( rule__EGenericTypeDecl__Group_1__0 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1007:2: rule__EGenericTypeDecl__Group_1__0
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
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1011:6: ( ( rule__EGenericTypeDecl__Group_2__0 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1011:6: ( ( rule__EGenericTypeDecl__Group_2__0 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1012:1: ( rule__EGenericTypeDecl__Group_2__0 )
                    {
                     before(grammarAccess.getEGenericTypeDeclAccess().getGroup_2()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1013:1: ( rule__EGenericTypeDecl__Group_2__0 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1013:2: rule__EGenericTypeDecl__Group_2__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1022:1: rule__EGenericTypeDecl__Alternatives_2_1 : ( ( ( rule__EGenericTypeDecl__Group_2_1_0__0 ) ) | ( ( rule__EGenericTypeDecl__Group_2_1_1__0 ) ) );
    public final void rule__EGenericTypeDecl__Alternatives_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1026:1: ( ( ( rule__EGenericTypeDecl__Group_2_1_0__0 ) ) | ( ( rule__EGenericTypeDecl__Group_2_1_1__0 ) ) )
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
                    new NoViableAltException("1022:1: rule__EGenericTypeDecl__Alternatives_2_1 : ( ( ( rule__EGenericTypeDecl__Group_2_1_0__0 ) ) | ( ( rule__EGenericTypeDecl__Group_2_1_1__0 ) ) );", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1027:1: ( ( rule__EGenericTypeDecl__Group_2_1_0__0 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1027:1: ( ( rule__EGenericTypeDecl__Group_2_1_0__0 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1028:1: ( rule__EGenericTypeDecl__Group_2_1_0__0 )
                    {
                     before(grammarAccess.getEGenericTypeDeclAccess().getGroup_2_1_0()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1029:1: ( rule__EGenericTypeDecl__Group_2_1_0__0 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1029:2: rule__EGenericTypeDecl__Group_2_1_0__0
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
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1033:6: ( ( rule__EGenericTypeDecl__Group_2_1_1__0 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1033:6: ( ( rule__EGenericTypeDecl__Group_2_1_1__0 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1034:1: ( rule__EGenericTypeDecl__Group_2_1_1__0 )
                    {
                     before(grammarAccess.getEGenericTypeDeclAccess().getGroup_2_1_1()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1035:1: ( rule__EGenericTypeDecl__Group_2_1_1__0 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1035:2: rule__EGenericTypeDecl__Group_2_1_1__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1044:1: rule__EOperationDecl__Alternatives_1 : ( ( ( rule__EOperationDecl__UniqueAssignment_1_0 ) ) | ( ( rule__EOperationDecl__OrderedAssignment_1_1 ) ) );
    public final void rule__EOperationDecl__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1048:1: ( ( ( rule__EOperationDecl__UniqueAssignment_1_0 ) ) | ( ( rule__EOperationDecl__OrderedAssignment_1_1 ) ) )
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
                    new NoViableAltException("1044:1: rule__EOperationDecl__Alternatives_1 : ( ( ( rule__EOperationDecl__UniqueAssignment_1_0 ) ) | ( ( rule__EOperationDecl__OrderedAssignment_1_1 ) ) );", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1049:1: ( ( rule__EOperationDecl__UniqueAssignment_1_0 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1049:1: ( ( rule__EOperationDecl__UniqueAssignment_1_0 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1050:1: ( rule__EOperationDecl__UniqueAssignment_1_0 )
                    {
                     before(grammarAccess.getEOperationDeclAccess().getUniqueAssignment_1_0()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1051:1: ( rule__EOperationDecl__UniqueAssignment_1_0 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1051:2: rule__EOperationDecl__UniqueAssignment_1_0
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
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1055:6: ( ( rule__EOperationDecl__OrderedAssignment_1_1 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1055:6: ( ( rule__EOperationDecl__OrderedAssignment_1_1 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1056:1: ( rule__EOperationDecl__OrderedAssignment_1_1 )
                    {
                     before(grammarAccess.getEOperationDeclAccess().getOrderedAssignment_1_1()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1057:1: ( rule__EOperationDecl__OrderedAssignment_1_1 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1057:2: rule__EOperationDecl__OrderedAssignment_1_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1066:1: rule__EOperationDecl__Alternatives_3 : ( ( ( rule__EOperationDecl__EGenericTypeAssignment_3_0 ) ) | ( 'void' ) );
    public final void rule__EOperationDecl__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1070:1: ( ( ( rule__EOperationDecl__EGenericTypeAssignment_3_0 ) ) | ( 'void' ) )
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
                    new NoViableAltException("1066:1: rule__EOperationDecl__Alternatives_3 : ( ( ( rule__EOperationDecl__EGenericTypeAssignment_3_0 ) ) | ( 'void' ) );", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1071:1: ( ( rule__EOperationDecl__EGenericTypeAssignment_3_0 ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1071:1: ( ( rule__EOperationDecl__EGenericTypeAssignment_3_0 ) )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1072:1: ( rule__EOperationDecl__EGenericTypeAssignment_3_0 )
                    {
                     before(grammarAccess.getEOperationDeclAccess().getEGenericTypeAssignment_3_0()); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1073:1: ( rule__EOperationDecl__EGenericTypeAssignment_3_0 )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1073:2: rule__EOperationDecl__EGenericTypeAssignment_3_0
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
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1077:6: ( 'void' )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1077:6: ( 'void' )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1078:1: 'void'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1090:1: rule__QID__Alternatives_1_0 : ( ( '.' ) | ( '$' ) );
    public final void rule__QID__Alternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1094:1: ( ( '.' ) | ( '$' ) )
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
                    new NoViableAltException("1090:1: rule__QID__Alternatives_1_0 : ( ( '.' ) | ( '$' ) );", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1095:1: ( '.' )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1095:1: ( '.' )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1096:1: '.'
                    {
                     before(grammarAccess.getQIDAccess().getFullStopKeyword_1_0_0()); 
                    match(input,19,FollowSets000.FOLLOW_19_in_rule__QID__Alternatives_1_02391); 
                     after(grammarAccess.getQIDAccess().getFullStopKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1103:6: ( '$' )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1103:6: ( '$' )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1104:1: '$'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1116:1: rule__STRING_OR_QID__Alternatives : ( ( RULE_STRING ) | ( ruleQID ) );
    public final void rule__STRING_OR_QID__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1120:1: ( ( RULE_STRING ) | ( ruleQID ) )
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
                    new NoViableAltException("1116:1: rule__STRING_OR_QID__Alternatives : ( ( RULE_STRING ) | ( ruleQID ) );", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1121:1: ( RULE_STRING )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1121:1: ( RULE_STRING )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1122:1: RULE_STRING
                    {
                     before(grammarAccess.getSTRING_OR_QIDAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__STRING_OR_QID__Alternatives2445); 
                     after(grammarAccess.getSTRING_OR_QIDAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1127:6: ( ruleQID )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1127:6: ( ruleQID )
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1128:1: ruleQID
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1140:1: rule__EcoreDsl__Group__0 : ( ( rule__EcoreDsl__MetamodelDeclarationsAssignment_0 )* ) rule__EcoreDsl__Group__1 ;
    public final void rule__EcoreDsl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1144:1: ( ( ( rule__EcoreDsl__MetamodelDeclarationsAssignment_0 )* ) rule__EcoreDsl__Group__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1145:1: ( ( rule__EcoreDsl__MetamodelDeclarationsAssignment_0 )* ) rule__EcoreDsl__Group__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1145:1: ( ( rule__EcoreDsl__MetamodelDeclarationsAssignment_0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1146:1: ( rule__EcoreDsl__MetamodelDeclarationsAssignment_0 )*
            {
             before(grammarAccess.getEcoreDslAccess().getMetamodelDeclarationsAssignment_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1147:1: ( rule__EcoreDsl__MetamodelDeclarationsAssignment_0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==21) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1147:2: rule__EcoreDsl__MetamodelDeclarationsAssignment_0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1158:1: rule__EcoreDsl__Group__1 : ( ( rule__EcoreDsl__PackageAssignment_1 ) ) ;
    public final void rule__EcoreDsl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1162:1: ( ( ( rule__EcoreDsl__PackageAssignment_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1163:1: ( ( rule__EcoreDsl__PackageAssignment_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1163:1: ( ( rule__EcoreDsl__PackageAssignment_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1164:1: ( rule__EcoreDsl__PackageAssignment_1 )
            {
             before(grammarAccess.getEcoreDslAccess().getPackageAssignment_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1165:1: ( rule__EcoreDsl__PackageAssignment_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1165:2: rule__EcoreDsl__PackageAssignment_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1179:1: rule__ReferencedMetamodel__Group__0 : ( 'import' ) rule__ReferencedMetamodel__Group__1 ;
    public final void rule__ReferencedMetamodel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1183:1: ( ( 'import' ) rule__ReferencedMetamodel__Group__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1184:1: ( 'import' ) rule__ReferencedMetamodel__Group__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1184:1: ( 'import' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1185:1: 'import'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1199:1: rule__ReferencedMetamodel__Group__1 : ( ( rule__ReferencedMetamodel__Group_1__0 )? ) rule__ReferencedMetamodel__Group__2 ;
    public final void rule__ReferencedMetamodel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1203:1: ( ( ( rule__ReferencedMetamodel__Group_1__0 )? ) rule__ReferencedMetamodel__Group__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1204:1: ( ( rule__ReferencedMetamodel__Group_1__0 )? ) rule__ReferencedMetamodel__Group__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1204:1: ( ( rule__ReferencedMetamodel__Group_1__0 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1205:1: ( rule__ReferencedMetamodel__Group_1__0 )?
            {
             before(grammarAccess.getReferencedMetamodelAccess().getGroup_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1206:1: ( rule__ReferencedMetamodel__Group_1__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ID) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1206:2: rule__ReferencedMetamodel__Group_1__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1217:1: rule__ReferencedMetamodel__Group__2 : ( ( rule__ReferencedMetamodel__EPackageAssignment_2 ) ) rule__ReferencedMetamodel__Group__3 ;
    public final void rule__ReferencedMetamodel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1221:1: ( ( ( rule__ReferencedMetamodel__EPackageAssignment_2 ) ) rule__ReferencedMetamodel__Group__3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1222:1: ( ( rule__ReferencedMetamodel__EPackageAssignment_2 ) ) rule__ReferencedMetamodel__Group__3
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1222:1: ( ( rule__ReferencedMetamodel__EPackageAssignment_2 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1223:1: ( rule__ReferencedMetamodel__EPackageAssignment_2 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageAssignment_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1224:1: ( rule__ReferencedMetamodel__EPackageAssignment_2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1224:2: rule__ReferencedMetamodel__EPackageAssignment_2
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1235:1: rule__ReferencedMetamodel__Group__3 : ( ';' ) ;
    public final void rule__ReferencedMetamodel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1239:1: ( ( ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1240:1: ( ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1240:1: ( ';' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1241:1: ';'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1262:1: rule__ReferencedMetamodel__Group_1__0 : ( ( rule__ReferencedMetamodel__AliasAssignment_1_0 ) ) rule__ReferencedMetamodel__Group_1__1 ;
    public final void rule__ReferencedMetamodel__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1266:1: ( ( ( rule__ReferencedMetamodel__AliasAssignment_1_0 ) ) rule__ReferencedMetamodel__Group_1__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1267:1: ( ( rule__ReferencedMetamodel__AliasAssignment_1_0 ) ) rule__ReferencedMetamodel__Group_1__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1267:1: ( ( rule__ReferencedMetamodel__AliasAssignment_1_0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1268:1: ( rule__ReferencedMetamodel__AliasAssignment_1_0 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAliasAssignment_1_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1269:1: ( rule__ReferencedMetamodel__AliasAssignment_1_0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1269:2: rule__ReferencedMetamodel__AliasAssignment_1_0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1280:1: rule__ReferencedMetamodel__Group_1__1 : ( '=' ) ;
    public final void rule__ReferencedMetamodel__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1284:1: ( ( '=' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1285:1: ( '=' )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1285:1: ( '=' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1286:1: '='
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1303:1: rule__EPackageDecl__Group__0 : ( ( rule__EPackageDecl__EAnnotationsAssignment_0 )* ) rule__EPackageDecl__Group__1 ;
    public final void rule__EPackageDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1307:1: ( ( ( rule__EPackageDecl__EAnnotationsAssignment_0 )* ) rule__EPackageDecl__Group__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1308:1: ( ( rule__EPackageDecl__EAnnotationsAssignment_0 )* ) rule__EPackageDecl__Group__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1308:1: ( ( rule__EPackageDecl__EAnnotationsAssignment_0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1309:1: ( rule__EPackageDecl__EAnnotationsAssignment_0 )*
            {
             before(grammarAccess.getEPackageDeclAccess().getEAnnotationsAssignment_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1310:1: ( rule__EPackageDecl__EAnnotationsAssignment_0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==31) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1310:2: rule__EPackageDecl__EAnnotationsAssignment_0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1321:1: rule__EPackageDecl__Group__1 : ( 'package' ) rule__EPackageDecl__Group__2 ;
    public final void rule__EPackageDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1325:1: ( ( 'package' ) rule__EPackageDecl__Group__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1326:1: ( 'package' ) rule__EPackageDecl__Group__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1326:1: ( 'package' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1327:1: 'package'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1341:1: rule__EPackageDecl__Group__2 : ( ( rule__EPackageDecl__NameAssignment_2 ) ) rule__EPackageDecl__Group__3 ;
    public final void rule__EPackageDecl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1345:1: ( ( ( rule__EPackageDecl__NameAssignment_2 ) ) rule__EPackageDecl__Group__3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1346:1: ( ( rule__EPackageDecl__NameAssignment_2 ) ) rule__EPackageDecl__Group__3
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1346:1: ( ( rule__EPackageDecl__NameAssignment_2 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1347:1: ( rule__EPackageDecl__NameAssignment_2 )
            {
             before(grammarAccess.getEPackageDeclAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1348:1: ( rule__EPackageDecl__NameAssignment_2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1348:2: rule__EPackageDecl__NameAssignment_2
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1359:1: rule__EPackageDecl__Group__3 : ( 'nsURI' ) rule__EPackageDecl__Group__4 ;
    public final void rule__EPackageDecl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1363:1: ( ( 'nsURI' ) rule__EPackageDecl__Group__4 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1364:1: ( 'nsURI' ) rule__EPackageDecl__Group__4
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1364:1: ( 'nsURI' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1365:1: 'nsURI'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1379:1: rule__EPackageDecl__Group__4 : ( '=' ) rule__EPackageDecl__Group__5 ;
    public final void rule__EPackageDecl__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1383:1: ( ( '=' ) rule__EPackageDecl__Group__5 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1384:1: ( '=' ) rule__EPackageDecl__Group__5
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1384:1: ( '=' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1385:1: '='
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1399:1: rule__EPackageDecl__Group__5 : ( ( rule__EPackageDecl__NsURIAssignment_5 ) ) rule__EPackageDecl__Group__6 ;
    public final void rule__EPackageDecl__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1403:1: ( ( ( rule__EPackageDecl__NsURIAssignment_5 ) ) rule__EPackageDecl__Group__6 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1404:1: ( ( rule__EPackageDecl__NsURIAssignment_5 ) ) rule__EPackageDecl__Group__6
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1404:1: ( ( rule__EPackageDecl__NsURIAssignment_5 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1405:1: ( rule__EPackageDecl__NsURIAssignment_5 )
            {
             before(grammarAccess.getEPackageDeclAccess().getNsURIAssignment_5()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1406:1: ( rule__EPackageDecl__NsURIAssignment_5 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1406:2: rule__EPackageDecl__NsURIAssignment_5
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1417:1: rule__EPackageDecl__Group__6 : ( 'nsPrefix' ) rule__EPackageDecl__Group__7 ;
    public final void rule__EPackageDecl__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1421:1: ( ( 'nsPrefix' ) rule__EPackageDecl__Group__7 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1422:1: ( 'nsPrefix' ) rule__EPackageDecl__Group__7
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1422:1: ( 'nsPrefix' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1423:1: 'nsPrefix'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1437:1: rule__EPackageDecl__Group__7 : ( '=' ) rule__EPackageDecl__Group__8 ;
    public final void rule__EPackageDecl__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1441:1: ( ( '=' ) rule__EPackageDecl__Group__8 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1442:1: ( '=' ) rule__EPackageDecl__Group__8
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1442:1: ( '=' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1443:1: '='
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1457:1: rule__EPackageDecl__Group__8 : ( ( rule__EPackageDecl__NsPrefixAssignment_8 ) ) rule__EPackageDecl__Group__9 ;
    public final void rule__EPackageDecl__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1461:1: ( ( ( rule__EPackageDecl__NsPrefixAssignment_8 ) ) rule__EPackageDecl__Group__9 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1462:1: ( ( rule__EPackageDecl__NsPrefixAssignment_8 ) ) rule__EPackageDecl__Group__9
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1462:1: ( ( rule__EPackageDecl__NsPrefixAssignment_8 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1463:1: ( rule__EPackageDecl__NsPrefixAssignment_8 )
            {
             before(grammarAccess.getEPackageDeclAccess().getNsPrefixAssignment_8()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1464:1: ( rule__EPackageDecl__NsPrefixAssignment_8 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1464:2: rule__EPackageDecl__NsPrefixAssignment_8
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1475:1: rule__EPackageDecl__Group__9 : ( '{' ) rule__EPackageDecl__Group__10 ;
    public final void rule__EPackageDecl__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1479:1: ( ( '{' ) rule__EPackageDecl__Group__10 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1480:1: ( '{' ) rule__EPackageDecl__Group__10
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1480:1: ( '{' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1481:1: '{'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1495:1: rule__EPackageDecl__Group__10 : ( ( rule__EPackageDecl__Alternatives_10 )* ) rule__EPackageDecl__Group__11 ;
    public final void rule__EPackageDecl__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1499:1: ( ( ( rule__EPackageDecl__Alternatives_10 )* ) rule__EPackageDecl__Group__11 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1500:1: ( ( rule__EPackageDecl__Alternatives_10 )* ) rule__EPackageDecl__Group__11
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1500:1: ( ( rule__EPackageDecl__Alternatives_10 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1501:1: ( rule__EPackageDecl__Alternatives_10 )*
            {
             before(grammarAccess.getEPackageDeclAccess().getAlternatives_10()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1502:1: ( rule__EPackageDecl__Alternatives_10 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_SERIALIZABLE||LA21_0==16||LA21_0==24||LA21_0==29||LA21_0==31||LA21_0==43||(LA21_0>=49 && LA21_0<=50)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1502:2: rule__EPackageDecl__Alternatives_10
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1513:1: rule__EPackageDecl__Group__11 : ( '}' ) ;
    public final void rule__EPackageDecl__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1517:1: ( ( '}' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1518:1: ( '}' )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1518:1: ( '}' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1519:1: '}'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1556:1: rule__SubEPackageDecl__Group__0 : ( ( rule__SubEPackageDecl__EAnnotationsAssignment_0 )* ) rule__SubEPackageDecl__Group__1 ;
    public final void rule__SubEPackageDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1560:1: ( ( ( rule__SubEPackageDecl__EAnnotationsAssignment_0 )* ) rule__SubEPackageDecl__Group__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1561:1: ( ( rule__SubEPackageDecl__EAnnotationsAssignment_0 )* ) rule__SubEPackageDecl__Group__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1561:1: ( ( rule__SubEPackageDecl__EAnnotationsAssignment_0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1562:1: ( rule__SubEPackageDecl__EAnnotationsAssignment_0 )*
            {
             before(grammarAccess.getSubEPackageDeclAccess().getEAnnotationsAssignment_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1563:1: ( rule__SubEPackageDecl__EAnnotationsAssignment_0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==31) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1563:2: rule__SubEPackageDecl__EAnnotationsAssignment_0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1574:1: rule__SubEPackageDecl__Group__1 : ( 'package' ) rule__SubEPackageDecl__Group__2 ;
    public final void rule__SubEPackageDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1578:1: ( ( 'package' ) rule__SubEPackageDecl__Group__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1579:1: ( 'package' ) rule__SubEPackageDecl__Group__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1579:1: ( 'package' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1580:1: 'package'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1594:1: rule__SubEPackageDecl__Group__2 : ( ( rule__SubEPackageDecl__NameAssignment_2 ) ) rule__SubEPackageDecl__Group__3 ;
    public final void rule__SubEPackageDecl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1598:1: ( ( ( rule__SubEPackageDecl__NameAssignment_2 ) ) rule__SubEPackageDecl__Group__3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1599:1: ( ( rule__SubEPackageDecl__NameAssignment_2 ) ) rule__SubEPackageDecl__Group__3
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1599:1: ( ( rule__SubEPackageDecl__NameAssignment_2 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1600:1: ( rule__SubEPackageDecl__NameAssignment_2 )
            {
             before(grammarAccess.getSubEPackageDeclAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1601:1: ( rule__SubEPackageDecl__NameAssignment_2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1601:2: rule__SubEPackageDecl__NameAssignment_2
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1612:1: rule__SubEPackageDecl__Group__3 : ( '{' ) rule__SubEPackageDecl__Group__4 ;
    public final void rule__SubEPackageDecl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1616:1: ( ( '{' ) rule__SubEPackageDecl__Group__4 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1617:1: ( '{' ) rule__SubEPackageDecl__Group__4
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1617:1: ( '{' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1618:1: '{'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1632:1: rule__SubEPackageDecl__Group__4 : ( ( rule__SubEPackageDecl__Alternatives_4 )* ) rule__SubEPackageDecl__Group__5 ;
    public final void rule__SubEPackageDecl__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1636:1: ( ( ( rule__SubEPackageDecl__Alternatives_4 )* ) rule__SubEPackageDecl__Group__5 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1637:1: ( ( rule__SubEPackageDecl__Alternatives_4 )* ) rule__SubEPackageDecl__Group__5
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1637:1: ( ( rule__SubEPackageDecl__Alternatives_4 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1638:1: ( rule__SubEPackageDecl__Alternatives_4 )*
            {
             before(grammarAccess.getSubEPackageDeclAccess().getAlternatives_4()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1639:1: ( rule__SubEPackageDecl__Alternatives_4 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_SERIALIZABLE||LA23_0==16||LA23_0==24||LA23_0==29||LA23_0==31||LA23_0==43||(LA23_0>=49 && LA23_0<=50)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1639:2: rule__SubEPackageDecl__Alternatives_4
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1650:1: rule__SubEPackageDecl__Group__5 : ( '}' ) ;
    public final void rule__SubEPackageDecl__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1654:1: ( ( '}' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1655:1: ( '}' )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1655:1: ( '}' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1656:1: '}'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1681:1: rule__EDataTypeDecl__Group_0__0 : ( ( rule__EDataTypeDecl__EAnnotationsAssignment_0_0 )* ) rule__EDataTypeDecl__Group_0__1 ;
    public final void rule__EDataTypeDecl__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1685:1: ( ( ( rule__EDataTypeDecl__EAnnotationsAssignment_0_0 )* ) rule__EDataTypeDecl__Group_0__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1686:1: ( ( rule__EDataTypeDecl__EAnnotationsAssignment_0_0 )* ) rule__EDataTypeDecl__Group_0__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1686:1: ( ( rule__EDataTypeDecl__EAnnotationsAssignment_0_0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1687:1: ( rule__EDataTypeDecl__EAnnotationsAssignment_0_0 )*
            {
             before(grammarAccess.getEDataTypeDeclAccess().getEAnnotationsAssignment_0_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1688:1: ( rule__EDataTypeDecl__EAnnotationsAssignment_0_0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==31) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1688:2: rule__EDataTypeDecl__EAnnotationsAssignment_0_0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1699:1: rule__EDataTypeDecl__Group_0__1 : ( ( rule__EDataTypeDecl__SerializableAssignment_0_1 )? ) rule__EDataTypeDecl__Group_0__2 ;
    public final void rule__EDataTypeDecl__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1703:1: ( ( ( rule__EDataTypeDecl__SerializableAssignment_0_1 )? ) rule__EDataTypeDecl__Group_0__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1704:1: ( ( rule__EDataTypeDecl__SerializableAssignment_0_1 )? ) rule__EDataTypeDecl__Group_0__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1704:1: ( ( rule__EDataTypeDecl__SerializableAssignment_0_1 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1705:1: ( rule__EDataTypeDecl__SerializableAssignment_0_1 )?
            {
             before(grammarAccess.getEDataTypeDeclAccess().getSerializableAssignment_0_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1706:1: ( rule__EDataTypeDecl__SerializableAssignment_0_1 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_SERIALIZABLE) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1706:2: rule__EDataTypeDecl__SerializableAssignment_0_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1717:1: rule__EDataTypeDecl__Group_0__2 : ( ( rule__EDataTypeDecl__Group_0_2__0 ) ) ;
    public final void rule__EDataTypeDecl__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1721:1: ( ( ( rule__EDataTypeDecl__Group_0_2__0 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1722:1: ( ( rule__EDataTypeDecl__Group_0_2__0 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1722:1: ( ( rule__EDataTypeDecl__Group_0_2__0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1723:1: ( rule__EDataTypeDecl__Group_0_2__0 )
            {
             before(grammarAccess.getEDataTypeDeclAccess().getGroup_0_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1724:1: ( rule__EDataTypeDecl__Group_0_2__0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1724:2: rule__EDataTypeDecl__Group_0_2__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1740:1: rule__EDataTypeDecl__Group_0_2__0 : ( 'datatype' ) rule__EDataTypeDecl__Group_0_2__1 ;
    public final void rule__EDataTypeDecl__Group_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1744:1: ( ( 'datatype' ) rule__EDataTypeDecl__Group_0_2__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1745:1: ( 'datatype' ) rule__EDataTypeDecl__Group_0_2__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1745:1: ( 'datatype' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1746:1: 'datatype'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1760:1: rule__EDataTypeDecl__Group_0_2__1 : ( ( rule__EDataTypeDecl__NameAssignment_0_2_1 ) ) rule__EDataTypeDecl__Group_0_2__2 ;
    public final void rule__EDataTypeDecl__Group_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1764:1: ( ( ( rule__EDataTypeDecl__NameAssignment_0_2_1 ) ) rule__EDataTypeDecl__Group_0_2__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1765:1: ( ( rule__EDataTypeDecl__NameAssignment_0_2_1 ) ) rule__EDataTypeDecl__Group_0_2__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1765:1: ( ( rule__EDataTypeDecl__NameAssignment_0_2_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1766:1: ( rule__EDataTypeDecl__NameAssignment_0_2_1 )
            {
             before(grammarAccess.getEDataTypeDeclAccess().getNameAssignment_0_2_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1767:1: ( rule__EDataTypeDecl__NameAssignment_0_2_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1767:2: rule__EDataTypeDecl__NameAssignment_0_2_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1778:1: rule__EDataTypeDecl__Group_0_2__2 : ( ':' ) rule__EDataTypeDecl__Group_0_2__3 ;
    public final void rule__EDataTypeDecl__Group_0_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1782:1: ( ( ':' ) rule__EDataTypeDecl__Group_0_2__3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1783:1: ( ':' ) rule__EDataTypeDecl__Group_0_2__3
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1783:1: ( ':' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1784:1: ':'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1798:1: rule__EDataTypeDecl__Group_0_2__3 : ( ( rule__EDataTypeDecl__InstanceClassNameAssignment_0_2_3 ) ) rule__EDataTypeDecl__Group_0_2__4 ;
    public final void rule__EDataTypeDecl__Group_0_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1802:1: ( ( ( rule__EDataTypeDecl__InstanceClassNameAssignment_0_2_3 ) ) rule__EDataTypeDecl__Group_0_2__4 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1803:1: ( ( rule__EDataTypeDecl__InstanceClassNameAssignment_0_2_3 ) ) rule__EDataTypeDecl__Group_0_2__4
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1803:1: ( ( rule__EDataTypeDecl__InstanceClassNameAssignment_0_2_3 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1804:1: ( rule__EDataTypeDecl__InstanceClassNameAssignment_0_2_3 )
            {
             before(grammarAccess.getEDataTypeDeclAccess().getInstanceClassNameAssignment_0_2_3()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1805:1: ( rule__EDataTypeDecl__InstanceClassNameAssignment_0_2_3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1805:2: rule__EDataTypeDecl__InstanceClassNameAssignment_0_2_3
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1816:1: rule__EDataTypeDecl__Group_0_2__4 : ( ';' ) ;
    public final void rule__EDataTypeDecl__Group_0_2__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1820:1: ( ( ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1821:1: ( ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1821:1: ( ';' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1822:1: ';'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1845:1: rule__EAnnotationDecl__Group__0 : ( '@' ) rule__EAnnotationDecl__Group__1 ;
    public final void rule__EAnnotationDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1849:1: ( ( '@' ) rule__EAnnotationDecl__Group__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1850:1: ( '@' ) rule__EAnnotationDecl__Group__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1850:1: ( '@' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1851:1: '@'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1865:1: rule__EAnnotationDecl__Group__1 : ( ( rule__EAnnotationDecl__SourceAssignment_1 ) ) rule__EAnnotationDecl__Group__2 ;
    public final void rule__EAnnotationDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1869:1: ( ( ( rule__EAnnotationDecl__SourceAssignment_1 ) ) rule__EAnnotationDecl__Group__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1870:1: ( ( rule__EAnnotationDecl__SourceAssignment_1 ) ) rule__EAnnotationDecl__Group__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1870:1: ( ( rule__EAnnotationDecl__SourceAssignment_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1871:1: ( rule__EAnnotationDecl__SourceAssignment_1 )
            {
             before(grammarAccess.getEAnnotationDeclAccess().getSourceAssignment_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1872:1: ( rule__EAnnotationDecl__SourceAssignment_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1872:2: rule__EAnnotationDecl__SourceAssignment_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1883:1: rule__EAnnotationDecl__Group__2 : ( ( rule__EAnnotationDecl__Group_2__0 )? ) ;
    public final void rule__EAnnotationDecl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1887:1: ( ( ( rule__EAnnotationDecl__Group_2__0 )? ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1888:1: ( ( rule__EAnnotationDecl__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1888:1: ( ( rule__EAnnotationDecl__Group_2__0 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1889:1: ( rule__EAnnotationDecl__Group_2__0 )?
            {
             before(grammarAccess.getEAnnotationDeclAccess().getGroup_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1890:1: ( rule__EAnnotationDecl__Group_2__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==32) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1890:2: rule__EAnnotationDecl__Group_2__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1906:1: rule__EAnnotationDecl__Group_2__0 : ( '(' ) rule__EAnnotationDecl__Group_2__1 ;
    public final void rule__EAnnotationDecl__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1910:1: ( ( '(' ) rule__EAnnotationDecl__Group_2__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1911:1: ( '(' ) rule__EAnnotationDecl__Group_2__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1911:1: ( '(' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1912:1: '('
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1926:1: rule__EAnnotationDecl__Group_2__1 : ( ( rule__EAnnotationDecl__DetailsAssignment_2_1 ) ) rule__EAnnotationDecl__Group_2__2 ;
    public final void rule__EAnnotationDecl__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1930:1: ( ( ( rule__EAnnotationDecl__DetailsAssignment_2_1 ) ) rule__EAnnotationDecl__Group_2__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1931:1: ( ( rule__EAnnotationDecl__DetailsAssignment_2_1 ) ) rule__EAnnotationDecl__Group_2__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1931:1: ( ( rule__EAnnotationDecl__DetailsAssignment_2_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1932:1: ( rule__EAnnotationDecl__DetailsAssignment_2_1 )
            {
             before(grammarAccess.getEAnnotationDeclAccess().getDetailsAssignment_2_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1933:1: ( rule__EAnnotationDecl__DetailsAssignment_2_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1933:2: rule__EAnnotationDecl__DetailsAssignment_2_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1944:1: rule__EAnnotationDecl__Group_2__2 : ( ( rule__EAnnotationDecl__Group_2_2__0 )* ) rule__EAnnotationDecl__Group_2__3 ;
    public final void rule__EAnnotationDecl__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1948:1: ( ( ( rule__EAnnotationDecl__Group_2_2__0 )* ) rule__EAnnotationDecl__Group_2__3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1949:1: ( ( rule__EAnnotationDecl__Group_2_2__0 )* ) rule__EAnnotationDecl__Group_2__3
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1949:1: ( ( rule__EAnnotationDecl__Group_2_2__0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1950:1: ( rule__EAnnotationDecl__Group_2_2__0 )*
            {
             before(grammarAccess.getEAnnotationDeclAccess().getGroup_2_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1951:1: ( rule__EAnnotationDecl__Group_2_2__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==34) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1951:2: rule__EAnnotationDecl__Group_2_2__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1962:1: rule__EAnnotationDecl__Group_2__3 : ( ')' ) ;
    public final void rule__EAnnotationDecl__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1966:1: ( ( ')' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1967:1: ( ')' )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1967:1: ( ')' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1968:1: ')'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1989:1: rule__EAnnotationDecl__Group_2_2__0 : ( ',' ) rule__EAnnotationDecl__Group_2_2__1 ;
    public final void rule__EAnnotationDecl__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1993:1: ( ( ',' ) rule__EAnnotationDecl__Group_2_2__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1994:1: ( ',' ) rule__EAnnotationDecl__Group_2_2__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1994:1: ( ',' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:1995:1: ','
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2009:1: rule__EAnnotationDecl__Group_2_2__1 : ( ( rule__EAnnotationDecl__DetailsAssignment_2_2_1 ) ) ;
    public final void rule__EAnnotationDecl__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2013:1: ( ( ( rule__EAnnotationDecl__DetailsAssignment_2_2_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2014:1: ( ( rule__EAnnotationDecl__DetailsAssignment_2_2_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2014:1: ( ( rule__EAnnotationDecl__DetailsAssignment_2_2_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2015:1: ( rule__EAnnotationDecl__DetailsAssignment_2_2_1 )
            {
             before(grammarAccess.getEAnnotationDeclAccess().getDetailsAssignment_2_2_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2016:1: ( rule__EAnnotationDecl__DetailsAssignment_2_2_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2016:2: rule__EAnnotationDecl__DetailsAssignment_2_2_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2030:1: rule__EClassDecl__Group__0 : ( ( rule__EClassDecl__EAnnotationsAssignment_0 )* ) rule__EClassDecl__Group__1 ;
    public final void rule__EClassDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2034:1: ( ( ( rule__EClassDecl__EAnnotationsAssignment_0 )* ) rule__EClassDecl__Group__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2035:1: ( ( rule__EClassDecl__EAnnotationsAssignment_0 )* ) rule__EClassDecl__Group__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2035:1: ( ( rule__EClassDecl__EAnnotationsAssignment_0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2036:1: ( rule__EClassDecl__EAnnotationsAssignment_0 )*
            {
             before(grammarAccess.getEClassDeclAccess().getEAnnotationsAssignment_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2037:1: ( rule__EClassDecl__EAnnotationsAssignment_0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==31) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2037:2: rule__EClassDecl__EAnnotationsAssignment_0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2048:1: rule__EClassDecl__Group__1 : ( ( rule__EClassDecl__AbstractAssignment_1 )? ) rule__EClassDecl__Group__2 ;
    public final void rule__EClassDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2052:1: ( ( ( rule__EClassDecl__AbstractAssignment_1 )? ) rule__EClassDecl__Group__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2053:1: ( ( rule__EClassDecl__AbstractAssignment_1 )? ) rule__EClassDecl__Group__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2053:1: ( ( rule__EClassDecl__AbstractAssignment_1 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2054:1: ( rule__EClassDecl__AbstractAssignment_1 )?
            {
             before(grammarAccess.getEClassDeclAccess().getAbstractAssignment_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2055:1: ( rule__EClassDecl__AbstractAssignment_1 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==49) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2055:2: rule__EClassDecl__AbstractAssignment_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2066:1: rule__EClassDecl__Group__2 : ( ( rule__EClassDecl__Alternatives_2 ) ) rule__EClassDecl__Group__3 ;
    public final void rule__EClassDecl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2070:1: ( ( ( rule__EClassDecl__Alternatives_2 ) ) rule__EClassDecl__Group__3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2071:1: ( ( rule__EClassDecl__Alternatives_2 ) ) rule__EClassDecl__Group__3
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2071:1: ( ( rule__EClassDecl__Alternatives_2 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2072:1: ( rule__EClassDecl__Alternatives_2 )
            {
             before(grammarAccess.getEClassDeclAccess().getAlternatives_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2073:1: ( rule__EClassDecl__Alternatives_2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2073:2: rule__EClassDecl__Alternatives_2
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2084:1: rule__EClassDecl__Group__3 : ( ( rule__EClassDecl__NameAssignment_3 ) ) rule__EClassDecl__Group__4 ;
    public final void rule__EClassDecl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2088:1: ( ( ( rule__EClassDecl__NameAssignment_3 ) ) rule__EClassDecl__Group__4 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2089:1: ( ( rule__EClassDecl__NameAssignment_3 ) ) rule__EClassDecl__Group__4
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2089:1: ( ( rule__EClassDecl__NameAssignment_3 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2090:1: ( rule__EClassDecl__NameAssignment_3 )
            {
             before(grammarAccess.getEClassDeclAccess().getNameAssignment_3()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2091:1: ( rule__EClassDecl__NameAssignment_3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2091:2: rule__EClassDecl__NameAssignment_3
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2102:1: rule__EClassDecl__Group__4 : ( ( rule__EClassDecl__Group_4__0 )? ) rule__EClassDecl__Group__5 ;
    public final void rule__EClassDecl__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2106:1: ( ( ( rule__EClassDecl__Group_4__0 )? ) rule__EClassDecl__Group__5 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2107:1: ( ( rule__EClassDecl__Group_4__0 )? ) rule__EClassDecl__Group__5
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2107:1: ( ( rule__EClassDecl__Group_4__0 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2108:1: ( rule__EClassDecl__Group_4__0 )?
            {
             before(grammarAccess.getEClassDeclAccess().getGroup_4()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2109:1: ( rule__EClassDecl__Group_4__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==35) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2109:2: rule__EClassDecl__Group_4__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2120:1: rule__EClassDecl__Group__5 : ( ( rule__EClassDecl__Group_5__0 )? ) rule__EClassDecl__Group__6 ;
    public final void rule__EClassDecl__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2124:1: ( ( ( rule__EClassDecl__Group_5__0 )? ) rule__EClassDecl__Group__6 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2125:1: ( ( rule__EClassDecl__Group_5__0 )? ) rule__EClassDecl__Group__6
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2125:1: ( ( rule__EClassDecl__Group_5__0 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2126:1: ( rule__EClassDecl__Group_5__0 )?
            {
             before(grammarAccess.getEClassDeclAccess().getGroup_5()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2127:1: ( rule__EClassDecl__Group_5__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==37) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2127:2: rule__EClassDecl__Group_5__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2138:1: rule__EClassDecl__Group__6 : ( ( rule__EClassDecl__Group_6__0 )? ) rule__EClassDecl__Group__7 ;
    public final void rule__EClassDecl__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2142:1: ( ( ( rule__EClassDecl__Group_6__0 )? ) rule__EClassDecl__Group__7 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2143:1: ( ( rule__EClassDecl__Group_6__0 )? ) rule__EClassDecl__Group__7
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2143:1: ( ( rule__EClassDecl__Group_6__0 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2144:1: ( rule__EClassDecl__Group_6__0 )?
            {
             before(grammarAccess.getEClassDeclAccess().getGroup_6()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2145:1: ( rule__EClassDecl__Group_6__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==30) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2145:2: rule__EClassDecl__Group_6__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2156:1: rule__EClassDecl__Group__7 : ( '{' ) rule__EClassDecl__Group__8 ;
    public final void rule__EClassDecl__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2160:1: ( ( '{' ) rule__EClassDecl__Group__8 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2161:1: ( '{' ) rule__EClassDecl__Group__8
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2161:1: ( '{' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2162:1: '{'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2176:1: rule__EClassDecl__Group__8 : ( ( rule__EClassDecl__Alternatives_8 )* ) rule__EClassDecl__Group__9 ;
    public final void rule__EClassDecl__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2180:1: ( ( ( rule__EClassDecl__Alternatives_8 )* ) rule__EClassDecl__Group__9 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2181:1: ( ( rule__EClassDecl__Alternatives_8 )* ) rule__EClassDecl__Group__9
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2181:1: ( ( rule__EClassDecl__Alternatives_8 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2182:1: ( rule__EClassDecl__Alternatives_8 )*
            {
             before(grammarAccess.getEClassDeclAccess().getAlternatives_8()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2183:1: ( rule__EClassDecl__Alternatives_8 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>=RULE_BAG && LA33_0<=RULE_LOCAL)||LA33_0==17||LA33_0==31||LA33_0==38||LA33_0==46||(LA33_0>=51 && LA33_0<=56)) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2183:2: rule__EClassDecl__Alternatives_8
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2194:1: rule__EClassDecl__Group__9 : ( '}' ) ;
    public final void rule__EClassDecl__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2198:1: ( ( '}' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2199:1: ( '}' )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2199:1: ( '}' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2200:1: '}'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2233:1: rule__EClassDecl__Group_4__0 : ( '<' ) rule__EClassDecl__Group_4__1 ;
    public final void rule__EClassDecl__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2237:1: ( ( '<' ) rule__EClassDecl__Group_4__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2238:1: ( '<' ) rule__EClassDecl__Group_4__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2238:1: ( '<' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2239:1: '<'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2253:1: rule__EClassDecl__Group_4__1 : ( ( rule__EClassDecl__ETypeParametersAssignment_4_1 ) ) rule__EClassDecl__Group_4__2 ;
    public final void rule__EClassDecl__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2257:1: ( ( ( rule__EClassDecl__ETypeParametersAssignment_4_1 ) ) rule__EClassDecl__Group_4__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2258:1: ( ( rule__EClassDecl__ETypeParametersAssignment_4_1 ) ) rule__EClassDecl__Group_4__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2258:1: ( ( rule__EClassDecl__ETypeParametersAssignment_4_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2259:1: ( rule__EClassDecl__ETypeParametersAssignment_4_1 )
            {
             before(grammarAccess.getEClassDeclAccess().getETypeParametersAssignment_4_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2260:1: ( rule__EClassDecl__ETypeParametersAssignment_4_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2260:2: rule__EClassDecl__ETypeParametersAssignment_4_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2271:1: rule__EClassDecl__Group_4__2 : ( ( rule__EClassDecl__Group_4_2__0 )* ) rule__EClassDecl__Group_4__3 ;
    public final void rule__EClassDecl__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2275:1: ( ( ( rule__EClassDecl__Group_4_2__0 )* ) rule__EClassDecl__Group_4__3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2276:1: ( ( rule__EClassDecl__Group_4_2__0 )* ) rule__EClassDecl__Group_4__3
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2276:1: ( ( rule__EClassDecl__Group_4_2__0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2277:1: ( rule__EClassDecl__Group_4_2__0 )*
            {
             before(grammarAccess.getEClassDeclAccess().getGroup_4_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2278:1: ( rule__EClassDecl__Group_4_2__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==34) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2278:2: rule__EClassDecl__Group_4_2__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2289:1: rule__EClassDecl__Group_4__3 : ( '>' ) ;
    public final void rule__EClassDecl__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2293:1: ( ( '>' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2294:1: ( '>' )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2294:1: ( '>' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2295:1: '>'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2316:1: rule__EClassDecl__Group_4_2__0 : ( ',' ) rule__EClassDecl__Group_4_2__1 ;
    public final void rule__EClassDecl__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2320:1: ( ( ',' ) rule__EClassDecl__Group_4_2__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2321:1: ( ',' ) rule__EClassDecl__Group_4_2__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2321:1: ( ',' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2322:1: ','
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2336:1: rule__EClassDecl__Group_4_2__1 : ( ( rule__EClassDecl__ETypeParametersAssignment_4_2_1 ) ) ;
    public final void rule__EClassDecl__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2340:1: ( ( ( rule__EClassDecl__ETypeParametersAssignment_4_2_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2341:1: ( ( rule__EClassDecl__ETypeParametersAssignment_4_2_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2341:1: ( ( rule__EClassDecl__ETypeParametersAssignment_4_2_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2342:1: ( rule__EClassDecl__ETypeParametersAssignment_4_2_1 )
            {
             before(grammarAccess.getEClassDeclAccess().getETypeParametersAssignment_4_2_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2343:1: ( rule__EClassDecl__ETypeParametersAssignment_4_2_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2343:2: rule__EClassDecl__ETypeParametersAssignment_4_2_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2357:1: rule__EClassDecl__Group_5__0 : ( 'extends' ) rule__EClassDecl__Group_5__1 ;
    public final void rule__EClassDecl__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2361:1: ( ( 'extends' ) rule__EClassDecl__Group_5__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2362:1: ( 'extends' ) rule__EClassDecl__Group_5__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2362:1: ( 'extends' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2363:1: 'extends'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2377:1: rule__EClassDecl__Group_5__1 : ( ( rule__EClassDecl__EGenericSuperTypesAssignment_5_1 ) ) rule__EClassDecl__Group_5__2 ;
    public final void rule__EClassDecl__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2381:1: ( ( ( rule__EClassDecl__EGenericSuperTypesAssignment_5_1 ) ) rule__EClassDecl__Group_5__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2382:1: ( ( rule__EClassDecl__EGenericSuperTypesAssignment_5_1 ) ) rule__EClassDecl__Group_5__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2382:1: ( ( rule__EClassDecl__EGenericSuperTypesAssignment_5_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2383:1: ( rule__EClassDecl__EGenericSuperTypesAssignment_5_1 )
            {
             before(grammarAccess.getEClassDeclAccess().getEGenericSuperTypesAssignment_5_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2384:1: ( rule__EClassDecl__EGenericSuperTypesAssignment_5_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2384:2: rule__EClassDecl__EGenericSuperTypesAssignment_5_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2395:1: rule__EClassDecl__Group_5__2 : ( ( rule__EClassDecl__Group_5_2__0 )* ) ;
    public final void rule__EClassDecl__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2399:1: ( ( ( rule__EClassDecl__Group_5_2__0 )* ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2400:1: ( ( rule__EClassDecl__Group_5_2__0 )* )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2400:1: ( ( rule__EClassDecl__Group_5_2__0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2401:1: ( rule__EClassDecl__Group_5_2__0 )*
            {
             before(grammarAccess.getEClassDeclAccess().getGroup_5_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2402:1: ( rule__EClassDecl__Group_5_2__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==34) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2402:2: rule__EClassDecl__Group_5_2__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2418:1: rule__EClassDecl__Group_5_2__0 : ( ',' ) rule__EClassDecl__Group_5_2__1 ;
    public final void rule__EClassDecl__Group_5_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2422:1: ( ( ',' ) rule__EClassDecl__Group_5_2__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2423:1: ( ',' ) rule__EClassDecl__Group_5_2__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2423:1: ( ',' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2424:1: ','
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2438:1: rule__EClassDecl__Group_5_2__1 : ( ( rule__EClassDecl__EGenericSuperTypesAssignment_5_2_1 ) ) ;
    public final void rule__EClassDecl__Group_5_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2442:1: ( ( ( rule__EClassDecl__EGenericSuperTypesAssignment_5_2_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2443:1: ( ( rule__EClassDecl__EGenericSuperTypesAssignment_5_2_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2443:1: ( ( rule__EClassDecl__EGenericSuperTypesAssignment_5_2_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2444:1: ( rule__EClassDecl__EGenericSuperTypesAssignment_5_2_1 )
            {
             before(grammarAccess.getEClassDeclAccess().getEGenericSuperTypesAssignment_5_2_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2445:1: ( rule__EClassDecl__EGenericSuperTypesAssignment_5_2_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2445:2: rule__EClassDecl__EGenericSuperTypesAssignment_5_2_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2459:1: rule__EClassDecl__Group_6__0 : ( ':' ) rule__EClassDecl__Group_6__1 ;
    public final void rule__EClassDecl__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2463:1: ( ( ':' ) rule__EClassDecl__Group_6__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2464:1: ( ':' ) rule__EClassDecl__Group_6__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2464:1: ( ':' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2465:1: ':'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2479:1: rule__EClassDecl__Group_6__1 : ( ( rule__EClassDecl__InstanceClassNameAssignment_6_1 ) ) ;
    public final void rule__EClassDecl__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2483:1: ( ( ( rule__EClassDecl__InstanceClassNameAssignment_6_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2484:1: ( ( rule__EClassDecl__InstanceClassNameAssignment_6_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2484:1: ( ( rule__EClassDecl__InstanceClassNameAssignment_6_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2485:1: ( rule__EClassDecl__InstanceClassNameAssignment_6_1 )
            {
             before(grammarAccess.getEClassDeclAccess().getInstanceClassNameAssignment_6_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2486:1: ( rule__EClassDecl__InstanceClassNameAssignment_6_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2486:2: rule__EClassDecl__InstanceClassNameAssignment_6_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2500:1: rule__EAttributeDecl__Group__0 : ( ( rule__EAttributeDecl__EAnnotationsAssignment_0 )* ) rule__EAttributeDecl__Group__1 ;
    public final void rule__EAttributeDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2504:1: ( ( ( rule__EAttributeDecl__EAnnotationsAssignment_0 )* ) rule__EAttributeDecl__Group__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2505:1: ( ( rule__EAttributeDecl__EAnnotationsAssignment_0 )* ) rule__EAttributeDecl__Group__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2505:1: ( ( rule__EAttributeDecl__EAnnotationsAssignment_0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2506:1: ( rule__EAttributeDecl__EAnnotationsAssignment_0 )*
            {
             before(grammarAccess.getEAttributeDeclAccess().getEAnnotationsAssignment_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2507:1: ( rule__EAttributeDecl__EAnnotationsAssignment_0 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==31) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2507:2: rule__EAttributeDecl__EAnnotationsAssignment_0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2518:1: rule__EAttributeDecl__Group__1 : ( ( rule__EAttributeDecl__Alternatives_1 )* ) rule__EAttributeDecl__Group__2 ;
    public final void rule__EAttributeDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2522:1: ( ( ( rule__EAttributeDecl__Alternatives_1 )* ) rule__EAttributeDecl__Group__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2523:1: ( ( rule__EAttributeDecl__Alternatives_1 )* ) rule__EAttributeDecl__Group__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2523:1: ( ( rule__EAttributeDecl__Alternatives_1 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2524:1: ( rule__EAttributeDecl__Alternatives_1 )*
            {
             before(grammarAccess.getEAttributeDeclAccess().getAlternatives_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2525:1: ( rule__EAttributeDecl__Alternatives_1 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( ((LA37_0>=RULE_BAG && LA37_0<=RULE_READONLY)||(LA37_0>=51 && LA37_0<=55)) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2525:2: rule__EAttributeDecl__Alternatives_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2536:1: rule__EAttributeDecl__Group__2 : ( 'attr' ) rule__EAttributeDecl__Group__3 ;
    public final void rule__EAttributeDecl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2540:1: ( ( 'attr' ) rule__EAttributeDecl__Group__3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2541:1: ( 'attr' ) rule__EAttributeDecl__Group__3
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2541:1: ( 'attr' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2542:1: 'attr'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2556:1: rule__EAttributeDecl__Group__3 : ( ( rule__EAttributeDecl__EGenericTypeAssignment_3 ) ) rule__EAttributeDecl__Group__4 ;
    public final void rule__EAttributeDecl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2560:1: ( ( ( rule__EAttributeDecl__EGenericTypeAssignment_3 ) ) rule__EAttributeDecl__Group__4 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2561:1: ( ( rule__EAttributeDecl__EGenericTypeAssignment_3 ) ) rule__EAttributeDecl__Group__4
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2561:1: ( ( rule__EAttributeDecl__EGenericTypeAssignment_3 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2562:1: ( rule__EAttributeDecl__EGenericTypeAssignment_3 )
            {
             before(grammarAccess.getEAttributeDeclAccess().getEGenericTypeAssignment_3()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2563:1: ( rule__EAttributeDecl__EGenericTypeAssignment_3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2563:2: rule__EAttributeDecl__EGenericTypeAssignment_3
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2574:1: rule__EAttributeDecl__Group__4 : ( ( rule__EAttributeDecl__Group_4__0 )? ) rule__EAttributeDecl__Group__5 ;
    public final void rule__EAttributeDecl__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2578:1: ( ( ( rule__EAttributeDecl__Group_4__0 )? ) rule__EAttributeDecl__Group__5 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2579:1: ( ( rule__EAttributeDecl__Group_4__0 )? ) rule__EAttributeDecl__Group__5
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2579:1: ( ( rule__EAttributeDecl__Group_4__0 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2580:1: ( rule__EAttributeDecl__Group_4__0 )?
            {
             before(grammarAccess.getEAttributeDeclAccess().getGroup_4()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2581:1: ( rule__EAttributeDecl__Group_4__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==39) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2581:2: rule__EAttributeDecl__Group_4__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2592:1: rule__EAttributeDecl__Group__5 : ( ( rule__EAttributeDecl__NameAssignment_5 ) ) rule__EAttributeDecl__Group__6 ;
    public final void rule__EAttributeDecl__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2596:1: ( ( ( rule__EAttributeDecl__NameAssignment_5 ) ) rule__EAttributeDecl__Group__6 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2597:1: ( ( rule__EAttributeDecl__NameAssignment_5 ) ) rule__EAttributeDecl__Group__6
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2597:1: ( ( rule__EAttributeDecl__NameAssignment_5 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2598:1: ( rule__EAttributeDecl__NameAssignment_5 )
            {
             before(grammarAccess.getEAttributeDeclAccess().getNameAssignment_5()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2599:1: ( rule__EAttributeDecl__NameAssignment_5 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2599:2: rule__EAttributeDecl__NameAssignment_5
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2610:1: rule__EAttributeDecl__Group__6 : ( ( rule__EAttributeDecl__Group_6__0 )? ) rule__EAttributeDecl__Group__7 ;
    public final void rule__EAttributeDecl__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2614:1: ( ( ( rule__EAttributeDecl__Group_6__0 )? ) rule__EAttributeDecl__Group__7 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2615:1: ( ( rule__EAttributeDecl__Group_6__0 )? ) rule__EAttributeDecl__Group__7
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2615:1: ( ( rule__EAttributeDecl__Group_6__0 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2616:1: ( rule__EAttributeDecl__Group_6__0 )?
            {
             before(grammarAccess.getEAttributeDeclAccess().getGroup_6()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2617:1: ( rule__EAttributeDecl__Group_6__0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==23) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2617:2: rule__EAttributeDecl__Group_6__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2628:1: rule__EAttributeDecl__Group__7 : ( ';' ) ;
    public final void rule__EAttributeDecl__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2632:1: ( ( ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2633:1: ( ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2633:1: ( ';' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2634:1: ';'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2663:1: rule__EAttributeDecl__Group_4__0 : ( '[' ) rule__EAttributeDecl__Group_4__1 ;
    public final void rule__EAttributeDecl__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2667:1: ( ( '[' ) rule__EAttributeDecl__Group_4__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2668:1: ( '[' ) rule__EAttributeDecl__Group_4__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2668:1: ( '[' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2669:1: '['
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2683:1: rule__EAttributeDecl__Group_4__1 : ( ( rule__EAttributeDecl__LowerBoundAssignment_4_1 ) ) rule__EAttributeDecl__Group_4__2 ;
    public final void rule__EAttributeDecl__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2687:1: ( ( ( rule__EAttributeDecl__LowerBoundAssignment_4_1 ) ) rule__EAttributeDecl__Group_4__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2688:1: ( ( rule__EAttributeDecl__LowerBoundAssignment_4_1 ) ) rule__EAttributeDecl__Group_4__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2688:1: ( ( rule__EAttributeDecl__LowerBoundAssignment_4_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2689:1: ( rule__EAttributeDecl__LowerBoundAssignment_4_1 )
            {
             before(grammarAccess.getEAttributeDeclAccess().getLowerBoundAssignment_4_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2690:1: ( rule__EAttributeDecl__LowerBoundAssignment_4_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2690:2: rule__EAttributeDecl__LowerBoundAssignment_4_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2701:1: rule__EAttributeDecl__Group_4__2 : ( ( rule__EAttributeDecl__Group_4_2__0 )? ) rule__EAttributeDecl__Group_4__3 ;
    public final void rule__EAttributeDecl__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2705:1: ( ( ( rule__EAttributeDecl__Group_4_2__0 )? ) rule__EAttributeDecl__Group_4__3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2706:1: ( ( rule__EAttributeDecl__Group_4_2__0 )? ) rule__EAttributeDecl__Group_4__3
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2706:1: ( ( rule__EAttributeDecl__Group_4_2__0 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2707:1: ( rule__EAttributeDecl__Group_4_2__0 )?
            {
             before(grammarAccess.getEAttributeDeclAccess().getGroup_4_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2708:1: ( rule__EAttributeDecl__Group_4_2__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==41) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2708:2: rule__EAttributeDecl__Group_4_2__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2719:1: rule__EAttributeDecl__Group_4__3 : ( ']' ) ;
    public final void rule__EAttributeDecl__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2723:1: ( ( ']' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2724:1: ( ']' )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2724:1: ( ']' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2725:1: ']'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2746:1: rule__EAttributeDecl__Group_4_2__0 : ( '..' ) rule__EAttributeDecl__Group_4_2__1 ;
    public final void rule__EAttributeDecl__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2750:1: ( ( '..' ) rule__EAttributeDecl__Group_4_2__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2751:1: ( '..' ) rule__EAttributeDecl__Group_4_2__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2751:1: ( '..' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2752:1: '..'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2766:1: rule__EAttributeDecl__Group_4_2__1 : ( ( rule__EAttributeDecl__UpperBoundAssignment_4_2_1 ) ) ;
    public final void rule__EAttributeDecl__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2770:1: ( ( ( rule__EAttributeDecl__UpperBoundAssignment_4_2_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2771:1: ( ( rule__EAttributeDecl__UpperBoundAssignment_4_2_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2771:1: ( ( rule__EAttributeDecl__UpperBoundAssignment_4_2_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2772:1: ( rule__EAttributeDecl__UpperBoundAssignment_4_2_1 )
            {
             before(grammarAccess.getEAttributeDeclAccess().getUpperBoundAssignment_4_2_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2773:1: ( rule__EAttributeDecl__UpperBoundAssignment_4_2_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2773:2: rule__EAttributeDecl__UpperBoundAssignment_4_2_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2787:1: rule__EAttributeDecl__Group_6__0 : ( '=' ) rule__EAttributeDecl__Group_6__1 ;
    public final void rule__EAttributeDecl__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2791:1: ( ( '=' ) rule__EAttributeDecl__Group_6__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2792:1: ( '=' ) rule__EAttributeDecl__Group_6__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2792:1: ( '=' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2793:1: '='
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2807:1: rule__EAttributeDecl__Group_6__1 : ( ( rule__EAttributeDecl__DefaultValueLiteralAssignment_6_1 ) ) ;
    public final void rule__EAttributeDecl__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2811:1: ( ( ( rule__EAttributeDecl__DefaultValueLiteralAssignment_6_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2812:1: ( ( rule__EAttributeDecl__DefaultValueLiteralAssignment_6_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2812:1: ( ( rule__EAttributeDecl__DefaultValueLiteralAssignment_6_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2813:1: ( rule__EAttributeDecl__DefaultValueLiteralAssignment_6_1 )
            {
             before(grammarAccess.getEAttributeDeclAccess().getDefaultValueLiteralAssignment_6_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2814:1: ( rule__EAttributeDecl__DefaultValueLiteralAssignment_6_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2814:2: rule__EAttributeDecl__DefaultValueLiteralAssignment_6_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2828:1: rule__EReferenceDecl__Group__0 : ( ( rule__EReferenceDecl__EAnnotationsAssignment_0 )* ) rule__EReferenceDecl__Group__1 ;
    public final void rule__EReferenceDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2832:1: ( ( ( rule__EReferenceDecl__EAnnotationsAssignment_0 )* ) rule__EReferenceDecl__Group__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2833:1: ( ( rule__EReferenceDecl__EAnnotationsAssignment_0 )* ) rule__EReferenceDecl__Group__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2833:1: ( ( rule__EReferenceDecl__EAnnotationsAssignment_0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2834:1: ( rule__EReferenceDecl__EAnnotationsAssignment_0 )*
            {
             before(grammarAccess.getEReferenceDeclAccess().getEAnnotationsAssignment_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2835:1: ( rule__EReferenceDecl__EAnnotationsAssignment_0 )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==31) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2835:2: rule__EReferenceDecl__EAnnotationsAssignment_0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2846:1: rule__EReferenceDecl__Group__1 : ( ( rule__EReferenceDecl__Alternatives_1 )* ) rule__EReferenceDecl__Group__2 ;
    public final void rule__EReferenceDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2850:1: ( ( ( rule__EReferenceDecl__Alternatives_1 )* ) rule__EReferenceDecl__Group__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2851:1: ( ( rule__EReferenceDecl__Alternatives_1 )* ) rule__EReferenceDecl__Group__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2851:1: ( ( rule__EReferenceDecl__Alternatives_1 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2852:1: ( rule__EReferenceDecl__Alternatives_1 )*
            {
             before(grammarAccess.getEReferenceDeclAccess().getAlternatives_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2853:1: ( rule__EReferenceDecl__Alternatives_1 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( ((LA42_0>=RULE_BAG && LA42_0<=RULE_LOCAL)||(LA42_0>=52 && LA42_0<=55)) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2853:2: rule__EReferenceDecl__Alternatives_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2864:1: rule__EReferenceDecl__Group__2 : ( ( rule__EReferenceDecl__Alternatives_2 ) ) rule__EReferenceDecl__Group__3 ;
    public final void rule__EReferenceDecl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2868:1: ( ( ( rule__EReferenceDecl__Alternatives_2 ) ) rule__EReferenceDecl__Group__3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2869:1: ( ( rule__EReferenceDecl__Alternatives_2 ) ) rule__EReferenceDecl__Group__3
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2869:1: ( ( rule__EReferenceDecl__Alternatives_2 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2870:1: ( rule__EReferenceDecl__Alternatives_2 )
            {
             before(grammarAccess.getEReferenceDeclAccess().getAlternatives_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2871:1: ( rule__EReferenceDecl__Alternatives_2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2871:2: rule__EReferenceDecl__Alternatives_2
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2882:1: rule__EReferenceDecl__Group__3 : ( ( rule__EReferenceDecl__EGenericTypeAssignment_3 ) ) rule__EReferenceDecl__Group__4 ;
    public final void rule__EReferenceDecl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2886:1: ( ( ( rule__EReferenceDecl__EGenericTypeAssignment_3 ) ) rule__EReferenceDecl__Group__4 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2887:1: ( ( rule__EReferenceDecl__EGenericTypeAssignment_3 ) ) rule__EReferenceDecl__Group__4
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2887:1: ( ( rule__EReferenceDecl__EGenericTypeAssignment_3 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2888:1: ( rule__EReferenceDecl__EGenericTypeAssignment_3 )
            {
             before(grammarAccess.getEReferenceDeclAccess().getEGenericTypeAssignment_3()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2889:1: ( rule__EReferenceDecl__EGenericTypeAssignment_3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2889:2: rule__EReferenceDecl__EGenericTypeAssignment_3
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2900:1: rule__EReferenceDecl__Group__4 : ( ( rule__EReferenceDecl__Group_4__0 )? ) rule__EReferenceDecl__Group__5 ;
    public final void rule__EReferenceDecl__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2904:1: ( ( ( rule__EReferenceDecl__Group_4__0 )? ) rule__EReferenceDecl__Group__5 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2905:1: ( ( rule__EReferenceDecl__Group_4__0 )? ) rule__EReferenceDecl__Group__5
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2905:1: ( ( rule__EReferenceDecl__Group_4__0 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2906:1: ( rule__EReferenceDecl__Group_4__0 )?
            {
             before(grammarAccess.getEReferenceDeclAccess().getGroup_4()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2907:1: ( rule__EReferenceDecl__Group_4__0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==39) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2907:2: rule__EReferenceDecl__Group_4__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2918:1: rule__EReferenceDecl__Group__5 : ( ( rule__EReferenceDecl__Group_5__0 )? ) rule__EReferenceDecl__Group__6 ;
    public final void rule__EReferenceDecl__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2922:1: ( ( ( rule__EReferenceDecl__Group_5__0 )? ) rule__EReferenceDecl__Group__6 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2923:1: ( ( rule__EReferenceDecl__Group_5__0 )? ) rule__EReferenceDecl__Group__6
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2923:1: ( ( rule__EReferenceDecl__Group_5__0 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2924:1: ( rule__EReferenceDecl__Group_5__0 )?
            {
             before(grammarAccess.getEReferenceDeclAccess().getGroup_5()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2925:1: ( rule__EReferenceDecl__Group_5__0 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==42) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2925:2: rule__EReferenceDecl__Group_5__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2936:1: rule__EReferenceDecl__Group__6 : ( ( rule__EReferenceDecl__NameAssignment_6 ) ) rule__EReferenceDecl__Group__7 ;
    public final void rule__EReferenceDecl__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2940:1: ( ( ( rule__EReferenceDecl__NameAssignment_6 ) ) rule__EReferenceDecl__Group__7 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2941:1: ( ( rule__EReferenceDecl__NameAssignment_6 ) ) rule__EReferenceDecl__Group__7
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2941:1: ( ( rule__EReferenceDecl__NameAssignment_6 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2942:1: ( rule__EReferenceDecl__NameAssignment_6 )
            {
             before(grammarAccess.getEReferenceDeclAccess().getNameAssignment_6()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2943:1: ( rule__EReferenceDecl__NameAssignment_6 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2943:2: rule__EReferenceDecl__NameAssignment_6
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2954:1: rule__EReferenceDecl__Group__7 : ( ';' ) ;
    public final void rule__EReferenceDecl__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2958:1: ( ( ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2959:1: ( ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2959:1: ( ';' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2960:1: ';'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2989:1: rule__EReferenceDecl__Group_4__0 : ( '[' ) rule__EReferenceDecl__Group_4__1 ;
    public final void rule__EReferenceDecl__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2993:1: ( ( '[' ) rule__EReferenceDecl__Group_4__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2994:1: ( '[' ) rule__EReferenceDecl__Group_4__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2994:1: ( '[' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:2995:1: '['
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3009:1: rule__EReferenceDecl__Group_4__1 : ( ( rule__EReferenceDecl__LowerBoundAssignment_4_1 ) ) rule__EReferenceDecl__Group_4__2 ;
    public final void rule__EReferenceDecl__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3013:1: ( ( ( rule__EReferenceDecl__LowerBoundAssignment_4_1 ) ) rule__EReferenceDecl__Group_4__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3014:1: ( ( rule__EReferenceDecl__LowerBoundAssignment_4_1 ) ) rule__EReferenceDecl__Group_4__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3014:1: ( ( rule__EReferenceDecl__LowerBoundAssignment_4_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3015:1: ( rule__EReferenceDecl__LowerBoundAssignment_4_1 )
            {
             before(grammarAccess.getEReferenceDeclAccess().getLowerBoundAssignment_4_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3016:1: ( rule__EReferenceDecl__LowerBoundAssignment_4_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3016:2: rule__EReferenceDecl__LowerBoundAssignment_4_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3027:1: rule__EReferenceDecl__Group_4__2 : ( ( rule__EReferenceDecl__Group_4_2__0 )? ) rule__EReferenceDecl__Group_4__3 ;
    public final void rule__EReferenceDecl__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3031:1: ( ( ( rule__EReferenceDecl__Group_4_2__0 )? ) rule__EReferenceDecl__Group_4__3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3032:1: ( ( rule__EReferenceDecl__Group_4_2__0 )? ) rule__EReferenceDecl__Group_4__3
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3032:1: ( ( rule__EReferenceDecl__Group_4_2__0 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3033:1: ( rule__EReferenceDecl__Group_4_2__0 )?
            {
             before(grammarAccess.getEReferenceDeclAccess().getGroup_4_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3034:1: ( rule__EReferenceDecl__Group_4_2__0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==41) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3034:2: rule__EReferenceDecl__Group_4_2__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3045:1: rule__EReferenceDecl__Group_4__3 : ( ']' ) ;
    public final void rule__EReferenceDecl__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3049:1: ( ( ']' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3050:1: ( ']' )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3050:1: ( ']' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3051:1: ']'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3072:1: rule__EReferenceDecl__Group_4_2__0 : ( '..' ) rule__EReferenceDecl__Group_4_2__1 ;
    public final void rule__EReferenceDecl__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3076:1: ( ( '..' ) rule__EReferenceDecl__Group_4_2__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3077:1: ( '..' ) rule__EReferenceDecl__Group_4_2__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3077:1: ( '..' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3078:1: '..'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3092:1: rule__EReferenceDecl__Group_4_2__1 : ( ( rule__EReferenceDecl__UpperBoundAssignment_4_2_1 ) ) ;
    public final void rule__EReferenceDecl__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3096:1: ( ( ( rule__EReferenceDecl__UpperBoundAssignment_4_2_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3097:1: ( ( rule__EReferenceDecl__UpperBoundAssignment_4_2_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3097:1: ( ( rule__EReferenceDecl__UpperBoundAssignment_4_2_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3098:1: ( rule__EReferenceDecl__UpperBoundAssignment_4_2_1 )
            {
             before(grammarAccess.getEReferenceDeclAccess().getUpperBoundAssignment_4_2_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3099:1: ( rule__EReferenceDecl__UpperBoundAssignment_4_2_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3099:2: rule__EReferenceDecl__UpperBoundAssignment_4_2_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3113:1: rule__EReferenceDecl__Group_5__0 : ( '#' ) rule__EReferenceDecl__Group_5__1 ;
    public final void rule__EReferenceDecl__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3117:1: ( ( '#' ) rule__EReferenceDecl__Group_5__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3118:1: ( '#' ) rule__EReferenceDecl__Group_5__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3118:1: ( '#' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3119:1: '#'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3133:1: rule__EReferenceDecl__Group_5__1 : ( ( rule__EReferenceDecl__EOppositeAssignment_5_1 ) ) ;
    public final void rule__EReferenceDecl__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3137:1: ( ( ( rule__EReferenceDecl__EOppositeAssignment_5_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3138:1: ( ( rule__EReferenceDecl__EOppositeAssignment_5_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3138:1: ( ( rule__EReferenceDecl__EOppositeAssignment_5_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3139:1: ( rule__EReferenceDecl__EOppositeAssignment_5_1 )
            {
             before(grammarAccess.getEReferenceDeclAccess().getEOppositeAssignment_5_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3140:1: ( rule__EReferenceDecl__EOppositeAssignment_5_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3140:2: rule__EReferenceDecl__EOppositeAssignment_5_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3154:1: rule__EEnumDecl__Group__0 : ( ( rule__EEnumDecl__EAnnotationsAssignment_0 )* ) rule__EEnumDecl__Group__1 ;
    public final void rule__EEnumDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3158:1: ( ( ( rule__EEnumDecl__EAnnotationsAssignment_0 )* ) rule__EEnumDecl__Group__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3159:1: ( ( rule__EEnumDecl__EAnnotationsAssignment_0 )* ) rule__EEnumDecl__Group__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3159:1: ( ( rule__EEnumDecl__EAnnotationsAssignment_0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3160:1: ( rule__EEnumDecl__EAnnotationsAssignment_0 )*
            {
             before(grammarAccess.getEEnumDeclAccess().getEAnnotationsAssignment_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3161:1: ( rule__EEnumDecl__EAnnotationsAssignment_0 )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==31) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3161:2: rule__EEnumDecl__EAnnotationsAssignment_0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3172:1: rule__EEnumDecl__Group__1 : ( 'enum' ) rule__EEnumDecl__Group__2 ;
    public final void rule__EEnumDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3176:1: ( ( 'enum' ) rule__EEnumDecl__Group__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3177:1: ( 'enum' ) rule__EEnumDecl__Group__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3177:1: ( 'enum' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3178:1: 'enum'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3192:1: rule__EEnumDecl__Group__2 : ( ( rule__EEnumDecl__NameAssignment_2 ) ) rule__EEnumDecl__Group__3 ;
    public final void rule__EEnumDecl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3196:1: ( ( ( rule__EEnumDecl__NameAssignment_2 ) ) rule__EEnumDecl__Group__3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3197:1: ( ( rule__EEnumDecl__NameAssignment_2 ) ) rule__EEnumDecl__Group__3
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3197:1: ( ( rule__EEnumDecl__NameAssignment_2 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3198:1: ( rule__EEnumDecl__NameAssignment_2 )
            {
             before(grammarAccess.getEEnumDeclAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3199:1: ( rule__EEnumDecl__NameAssignment_2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3199:2: rule__EEnumDecl__NameAssignment_2
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3210:1: rule__EEnumDecl__Group__3 : ( '{' ) rule__EEnumDecl__Group__4 ;
    public final void rule__EEnumDecl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3214:1: ( ( '{' ) rule__EEnumDecl__Group__4 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3215:1: ( '{' ) rule__EEnumDecl__Group__4
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3215:1: ( '{' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3216:1: '{'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3230:1: rule__EEnumDecl__Group__4 : ( ( ( rule__EEnumDecl__ELiteralsAssignment_4 ) ) ( ( rule__EEnumDecl__ELiteralsAssignment_4 )* ) ) rule__EEnumDecl__Group__5 ;
    public final void rule__EEnumDecl__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3234:1: ( ( ( ( rule__EEnumDecl__ELiteralsAssignment_4 ) ) ( ( rule__EEnumDecl__ELiteralsAssignment_4 )* ) ) rule__EEnumDecl__Group__5 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3235:1: ( ( ( rule__EEnumDecl__ELiteralsAssignment_4 ) ) ( ( rule__EEnumDecl__ELiteralsAssignment_4 )* ) ) rule__EEnumDecl__Group__5
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3235:1: ( ( ( rule__EEnumDecl__ELiteralsAssignment_4 ) ) ( ( rule__EEnumDecl__ELiteralsAssignment_4 )* ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3236:1: ( ( rule__EEnumDecl__ELiteralsAssignment_4 ) ) ( ( rule__EEnumDecl__ELiteralsAssignment_4 )* )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3236:1: ( ( rule__EEnumDecl__ELiteralsAssignment_4 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3237:1: ( rule__EEnumDecl__ELiteralsAssignment_4 )
            {
             before(grammarAccess.getEEnumDeclAccess().getELiteralsAssignment_4()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3238:1: ( rule__EEnumDecl__ELiteralsAssignment_4 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3238:2: rule__EEnumDecl__ELiteralsAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__EEnumDecl__ELiteralsAssignment_4_in_rule__EEnumDecl__Group__46507);
            rule__EEnumDecl__ELiteralsAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getEEnumDeclAccess().getELiteralsAssignment_4()); 

            }

            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3241:1: ( ( rule__EEnumDecl__ELiteralsAssignment_4 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3242:1: ( rule__EEnumDecl__ELiteralsAssignment_4 )*
            {
             before(grammarAccess.getEEnumDeclAccess().getELiteralsAssignment_4()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3243:1: ( rule__EEnumDecl__ELiteralsAssignment_4 )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==RULE_ID||LA47_0==31) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3243:2: rule__EEnumDecl__ELiteralsAssignment_4
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3255:1: rule__EEnumDecl__Group__5 : ( '}' ) ;
    public final void rule__EEnumDecl__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3259:1: ( ( '}' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3260:1: ( '}' )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3260:1: ( '}' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3261:1: '}'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3286:1: rule__EEnumLiteralDecl__Group__0 : ( ( rule__EEnumLiteralDecl__EAnnotationsAssignment_0 )* ) rule__EEnumLiteralDecl__Group__1 ;
    public final void rule__EEnumLiteralDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3290:1: ( ( ( rule__EEnumLiteralDecl__EAnnotationsAssignment_0 )* ) rule__EEnumLiteralDecl__Group__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3291:1: ( ( rule__EEnumLiteralDecl__EAnnotationsAssignment_0 )* ) rule__EEnumLiteralDecl__Group__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3291:1: ( ( rule__EEnumLiteralDecl__EAnnotationsAssignment_0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3292:1: ( rule__EEnumLiteralDecl__EAnnotationsAssignment_0 )*
            {
             before(grammarAccess.getEEnumLiteralDeclAccess().getEAnnotationsAssignment_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3293:1: ( rule__EEnumLiteralDecl__EAnnotationsAssignment_0 )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==31) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3293:2: rule__EEnumLiteralDecl__EAnnotationsAssignment_0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3304:1: rule__EEnumLiteralDecl__Group__1 : ( ( rule__EEnumLiteralDecl__NameAssignment_1 ) ) rule__EEnumLiteralDecl__Group__2 ;
    public final void rule__EEnumLiteralDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3308:1: ( ( ( rule__EEnumLiteralDecl__NameAssignment_1 ) ) rule__EEnumLiteralDecl__Group__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3309:1: ( ( rule__EEnumLiteralDecl__NameAssignment_1 ) ) rule__EEnumLiteralDecl__Group__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3309:1: ( ( rule__EEnumLiteralDecl__NameAssignment_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3310:1: ( rule__EEnumLiteralDecl__NameAssignment_1 )
            {
             before(grammarAccess.getEEnumLiteralDeclAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3311:1: ( rule__EEnumLiteralDecl__NameAssignment_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3311:2: rule__EEnumLiteralDecl__NameAssignment_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3322:1: rule__EEnumLiteralDecl__Group__2 : ( ( rule__EEnumLiteralDecl__Group_2__0 )? ) rule__EEnumLiteralDecl__Group__3 ;
    public final void rule__EEnumLiteralDecl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3326:1: ( ( ( rule__EEnumLiteralDecl__Group_2__0 )? ) rule__EEnumLiteralDecl__Group__3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3327:1: ( ( rule__EEnumLiteralDecl__Group_2__0 )? ) rule__EEnumLiteralDecl__Group__3
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3327:1: ( ( rule__EEnumLiteralDecl__Group_2__0 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3328:1: ( rule__EEnumLiteralDecl__Group_2__0 )?
            {
             before(grammarAccess.getEEnumLiteralDeclAccess().getGroup_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3329:1: ( rule__EEnumLiteralDecl__Group_2__0 )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==23) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3329:2: rule__EEnumLiteralDecl__Group_2__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3340:1: rule__EEnumLiteralDecl__Group__3 : ( ( rule__EEnumLiteralDecl__LiteralAssignment_3 )? ) rule__EEnumLiteralDecl__Group__4 ;
    public final void rule__EEnumLiteralDecl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3344:1: ( ( ( rule__EEnumLiteralDecl__LiteralAssignment_3 )? ) rule__EEnumLiteralDecl__Group__4 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3345:1: ( ( rule__EEnumLiteralDecl__LiteralAssignment_3 )? ) rule__EEnumLiteralDecl__Group__4
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3345:1: ( ( rule__EEnumLiteralDecl__LiteralAssignment_3 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3346:1: ( rule__EEnumLiteralDecl__LiteralAssignment_3 )?
            {
             before(grammarAccess.getEEnumLiteralDeclAccess().getLiteralAssignment_3()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3347:1: ( rule__EEnumLiteralDecl__LiteralAssignment_3 )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==RULE_STRING) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3347:2: rule__EEnumLiteralDecl__LiteralAssignment_3
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3358:1: rule__EEnumLiteralDecl__Group__4 : ( ';' ) ;
    public final void rule__EEnumLiteralDecl__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3362:1: ( ( ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3363:1: ( ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3363:1: ( ';' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3364:1: ';'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3387:1: rule__EEnumLiteralDecl__Group_2__0 : ( '=' ) rule__EEnumLiteralDecl__Group_2__1 ;
    public final void rule__EEnumLiteralDecl__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3391:1: ( ( '=' ) rule__EEnumLiteralDecl__Group_2__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3392:1: ( '=' ) rule__EEnumLiteralDecl__Group_2__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3392:1: ( '=' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3393:1: '='
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3407:1: rule__EEnumLiteralDecl__Group_2__1 : ( ( rule__EEnumLiteralDecl__ValueAssignment_2_1 ) ) ;
    public final void rule__EEnumLiteralDecl__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3411:1: ( ( ( rule__EEnumLiteralDecl__ValueAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3412:1: ( ( rule__EEnumLiteralDecl__ValueAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3412:1: ( ( rule__EEnumLiteralDecl__ValueAssignment_2_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3413:1: ( rule__EEnumLiteralDecl__ValueAssignment_2_1 )
            {
             before(grammarAccess.getEEnumLiteralDeclAccess().getValueAssignment_2_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3414:1: ( rule__EEnumLiteralDecl__ValueAssignment_2_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3414:2: rule__EEnumLiteralDecl__ValueAssignment_2_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3428:1: rule__ETypeParameterDecl__Group__0 : ( ( rule__ETypeParameterDecl__NameAssignment_0 ) ) rule__ETypeParameterDecl__Group__1 ;
    public final void rule__ETypeParameterDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3432:1: ( ( ( rule__ETypeParameterDecl__NameAssignment_0 ) ) rule__ETypeParameterDecl__Group__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3433:1: ( ( rule__ETypeParameterDecl__NameAssignment_0 ) ) rule__ETypeParameterDecl__Group__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3433:1: ( ( rule__ETypeParameterDecl__NameAssignment_0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3434:1: ( rule__ETypeParameterDecl__NameAssignment_0 )
            {
             before(grammarAccess.getETypeParameterDeclAccess().getNameAssignment_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3435:1: ( rule__ETypeParameterDecl__NameAssignment_0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3435:2: rule__ETypeParameterDecl__NameAssignment_0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3446:1: rule__ETypeParameterDecl__Group__1 : ( ( rule__ETypeParameterDecl__Group_1__0 )? ) ;
    public final void rule__ETypeParameterDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3450:1: ( ( ( rule__ETypeParameterDecl__Group_1__0 )? ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3451:1: ( ( rule__ETypeParameterDecl__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3451:1: ( ( rule__ETypeParameterDecl__Group_1__0 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3452:1: ( rule__ETypeParameterDecl__Group_1__0 )?
            {
             before(grammarAccess.getETypeParameterDeclAccess().getGroup_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3453:1: ( rule__ETypeParameterDecl__Group_1__0 )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==37) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3453:2: rule__ETypeParameterDecl__Group_1__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3467:1: rule__ETypeParameterDecl__Group_1__0 : ( 'extends' ) rule__ETypeParameterDecl__Group_1__1 ;
    public final void rule__ETypeParameterDecl__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3471:1: ( ( 'extends' ) rule__ETypeParameterDecl__Group_1__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3472:1: ( 'extends' ) rule__ETypeParameterDecl__Group_1__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3472:1: ( 'extends' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3473:1: 'extends'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3487:1: rule__ETypeParameterDecl__Group_1__1 : ( ( rule__ETypeParameterDecl__EBoundsAssignment_1_1 ) ) ;
    public final void rule__ETypeParameterDecl__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3491:1: ( ( ( rule__ETypeParameterDecl__EBoundsAssignment_1_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3492:1: ( ( rule__ETypeParameterDecl__EBoundsAssignment_1_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3492:1: ( ( rule__ETypeParameterDecl__EBoundsAssignment_1_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3493:1: ( rule__ETypeParameterDecl__EBoundsAssignment_1_1 )
            {
             before(grammarAccess.getETypeParameterDeclAccess().getEBoundsAssignment_1_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3494:1: ( rule__ETypeParameterDecl__EBoundsAssignment_1_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3494:2: rule__ETypeParameterDecl__EBoundsAssignment_1_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3508:1: rule__EGenericTypeReferenceDecl__Group_0__0 : ( ( rule__EGenericTypeReferenceDecl__EClassifierAssignment_0_0 ) ) rule__EGenericTypeReferenceDecl__Group_0__1 ;
    public final void rule__EGenericTypeReferenceDecl__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3512:1: ( ( ( rule__EGenericTypeReferenceDecl__EClassifierAssignment_0_0 ) ) rule__EGenericTypeReferenceDecl__Group_0__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3513:1: ( ( rule__EGenericTypeReferenceDecl__EClassifierAssignment_0_0 ) ) rule__EGenericTypeReferenceDecl__Group_0__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3513:1: ( ( rule__EGenericTypeReferenceDecl__EClassifierAssignment_0_0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3514:1: ( rule__EGenericTypeReferenceDecl__EClassifierAssignment_0_0 )
            {
             before(grammarAccess.getEGenericTypeReferenceDeclAccess().getEClassifierAssignment_0_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3515:1: ( rule__EGenericTypeReferenceDecl__EClassifierAssignment_0_0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3515:2: rule__EGenericTypeReferenceDecl__EClassifierAssignment_0_0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3526:1: rule__EGenericTypeReferenceDecl__Group_0__1 : ( ( rule__EGenericTypeReferenceDecl__Group_0_1__0 )? ) ;
    public final void rule__EGenericTypeReferenceDecl__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3530:1: ( ( ( rule__EGenericTypeReferenceDecl__Group_0_1__0 )? ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3531:1: ( ( rule__EGenericTypeReferenceDecl__Group_0_1__0 )? )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3531:1: ( ( rule__EGenericTypeReferenceDecl__Group_0_1__0 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3532:1: ( rule__EGenericTypeReferenceDecl__Group_0_1__0 )?
            {
             before(grammarAccess.getEGenericTypeReferenceDeclAccess().getGroup_0_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3533:1: ( rule__EGenericTypeReferenceDecl__Group_0_1__0 )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==35) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3533:2: rule__EGenericTypeReferenceDecl__Group_0_1__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3547:1: rule__EGenericTypeReferenceDecl__Group_0_1__0 : ( '<' ) rule__EGenericTypeReferenceDecl__Group_0_1__1 ;
    public final void rule__EGenericTypeReferenceDecl__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3551:1: ( ( '<' ) rule__EGenericTypeReferenceDecl__Group_0_1__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3552:1: ( '<' ) rule__EGenericTypeReferenceDecl__Group_0_1__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3552:1: ( '<' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3553:1: '<'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3567:1: rule__EGenericTypeReferenceDecl__Group_0_1__1 : ( ( rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_1 ) ) rule__EGenericTypeReferenceDecl__Group_0_1__2 ;
    public final void rule__EGenericTypeReferenceDecl__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3571:1: ( ( ( rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_1 ) ) rule__EGenericTypeReferenceDecl__Group_0_1__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3572:1: ( ( rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_1 ) ) rule__EGenericTypeReferenceDecl__Group_0_1__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3572:1: ( ( rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3573:1: ( rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_1 )
            {
             before(grammarAccess.getEGenericTypeReferenceDeclAccess().getETypeArgumentsAssignment_0_1_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3574:1: ( rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3574:2: rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3585:1: rule__EGenericTypeReferenceDecl__Group_0_1__2 : ( ( rule__EGenericTypeReferenceDecl__Group_0_1_2__0 )* ) rule__EGenericTypeReferenceDecl__Group_0_1__3 ;
    public final void rule__EGenericTypeReferenceDecl__Group_0_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3589:1: ( ( ( rule__EGenericTypeReferenceDecl__Group_0_1_2__0 )* ) rule__EGenericTypeReferenceDecl__Group_0_1__3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3590:1: ( ( rule__EGenericTypeReferenceDecl__Group_0_1_2__0 )* ) rule__EGenericTypeReferenceDecl__Group_0_1__3
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3590:1: ( ( rule__EGenericTypeReferenceDecl__Group_0_1_2__0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3591:1: ( rule__EGenericTypeReferenceDecl__Group_0_1_2__0 )*
            {
             before(grammarAccess.getEGenericTypeReferenceDeclAccess().getGroup_0_1_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3592:1: ( rule__EGenericTypeReferenceDecl__Group_0_1_2__0 )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==34) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3592:2: rule__EGenericTypeReferenceDecl__Group_0_1_2__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3603:1: rule__EGenericTypeReferenceDecl__Group_0_1__3 : ( '>' ) ;
    public final void rule__EGenericTypeReferenceDecl__Group_0_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3607:1: ( ( '>' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3608:1: ( '>' )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3608:1: ( '>' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3609:1: '>'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3630:1: rule__EGenericTypeReferenceDecl__Group_0_1_2__0 : ( ',' ) rule__EGenericTypeReferenceDecl__Group_0_1_2__1 ;
    public final void rule__EGenericTypeReferenceDecl__Group_0_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3634:1: ( ( ',' ) rule__EGenericTypeReferenceDecl__Group_0_1_2__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3635:1: ( ',' ) rule__EGenericTypeReferenceDecl__Group_0_1_2__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3635:1: ( ',' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3636:1: ','
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3650:1: rule__EGenericTypeReferenceDecl__Group_0_1_2__1 : ( ( rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_2_1 ) ) ;
    public final void rule__EGenericTypeReferenceDecl__Group_0_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3654:1: ( ( ( rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_2_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3655:1: ( ( rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_2_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3655:1: ( ( rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_2_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3656:1: ( rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_2_1 )
            {
             before(grammarAccess.getEGenericTypeReferenceDeclAccess().getETypeArgumentsAssignment_0_1_2_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3657:1: ( rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_2_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3657:2: rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_2_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3671:1: rule__EGenericTypeReferenceDecl__Group_1__0 : ( '#' ) rule__EGenericTypeReferenceDecl__Group_1__1 ;
    public final void rule__EGenericTypeReferenceDecl__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3675:1: ( ( '#' ) rule__EGenericTypeReferenceDecl__Group_1__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3676:1: ( '#' ) rule__EGenericTypeReferenceDecl__Group_1__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3676:1: ( '#' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3677:1: '#'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3691:1: rule__EGenericTypeReferenceDecl__Group_1__1 : ( ( rule__EGenericTypeReferenceDecl__ETypeParameterAssignment_1_1 ) ) ;
    public final void rule__EGenericTypeReferenceDecl__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3695:1: ( ( ( rule__EGenericTypeReferenceDecl__ETypeParameterAssignment_1_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3696:1: ( ( rule__EGenericTypeReferenceDecl__ETypeParameterAssignment_1_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3696:1: ( ( rule__EGenericTypeReferenceDecl__ETypeParameterAssignment_1_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3697:1: ( rule__EGenericTypeReferenceDecl__ETypeParameterAssignment_1_1 )
            {
             before(grammarAccess.getEGenericTypeReferenceDeclAccess().getETypeParameterAssignment_1_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3698:1: ( rule__EGenericTypeReferenceDecl__ETypeParameterAssignment_1_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3698:2: rule__EGenericTypeReferenceDecl__ETypeParameterAssignment_1_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3712:1: rule__EGenericTypeDecl__Group_0__0 : ( ( rule__EGenericTypeDecl__EClassifierAssignment_0_0 ) ) rule__EGenericTypeDecl__Group_0__1 ;
    public final void rule__EGenericTypeDecl__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3716:1: ( ( ( rule__EGenericTypeDecl__EClassifierAssignment_0_0 ) ) rule__EGenericTypeDecl__Group_0__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3717:1: ( ( rule__EGenericTypeDecl__EClassifierAssignment_0_0 ) ) rule__EGenericTypeDecl__Group_0__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3717:1: ( ( rule__EGenericTypeDecl__EClassifierAssignment_0_0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3718:1: ( rule__EGenericTypeDecl__EClassifierAssignment_0_0 )
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getEClassifierAssignment_0_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3719:1: ( rule__EGenericTypeDecl__EClassifierAssignment_0_0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3719:2: rule__EGenericTypeDecl__EClassifierAssignment_0_0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3730:1: rule__EGenericTypeDecl__Group_0__1 : ( ( rule__EGenericTypeDecl__Group_0_1__0 )? ) ;
    public final void rule__EGenericTypeDecl__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3734:1: ( ( ( rule__EGenericTypeDecl__Group_0_1__0 )? ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3735:1: ( ( rule__EGenericTypeDecl__Group_0_1__0 )? )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3735:1: ( ( rule__EGenericTypeDecl__Group_0_1__0 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3736:1: ( rule__EGenericTypeDecl__Group_0_1__0 )?
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getGroup_0_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3737:1: ( rule__EGenericTypeDecl__Group_0_1__0 )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==35) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3737:2: rule__EGenericTypeDecl__Group_0_1__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3751:1: rule__EGenericTypeDecl__Group_0_1__0 : ( '<' ) rule__EGenericTypeDecl__Group_0_1__1 ;
    public final void rule__EGenericTypeDecl__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3755:1: ( ( '<' ) rule__EGenericTypeDecl__Group_0_1__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3756:1: ( '<' ) rule__EGenericTypeDecl__Group_0_1__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3756:1: ( '<' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3757:1: '<'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3771:1: rule__EGenericTypeDecl__Group_0_1__1 : ( ( rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_1 ) ) rule__EGenericTypeDecl__Group_0_1__2 ;
    public final void rule__EGenericTypeDecl__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3775:1: ( ( ( rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_1 ) ) rule__EGenericTypeDecl__Group_0_1__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3776:1: ( ( rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_1 ) ) rule__EGenericTypeDecl__Group_0_1__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3776:1: ( ( rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3777:1: ( rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_1 )
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getETypeArgumentsAssignment_0_1_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3778:1: ( rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3778:2: rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3789:1: rule__EGenericTypeDecl__Group_0_1__2 : ( ( rule__EGenericTypeDecl__Group_0_1_2__0 )* ) rule__EGenericTypeDecl__Group_0_1__3 ;
    public final void rule__EGenericTypeDecl__Group_0_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3793:1: ( ( ( rule__EGenericTypeDecl__Group_0_1_2__0 )* ) rule__EGenericTypeDecl__Group_0_1__3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3794:1: ( ( rule__EGenericTypeDecl__Group_0_1_2__0 )* ) rule__EGenericTypeDecl__Group_0_1__3
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3794:1: ( ( rule__EGenericTypeDecl__Group_0_1_2__0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3795:1: ( rule__EGenericTypeDecl__Group_0_1_2__0 )*
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getGroup_0_1_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3796:1: ( rule__EGenericTypeDecl__Group_0_1_2__0 )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==34) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3796:2: rule__EGenericTypeDecl__Group_0_1_2__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3807:1: rule__EGenericTypeDecl__Group_0_1__3 : ( '>' ) ;
    public final void rule__EGenericTypeDecl__Group_0_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3811:1: ( ( '>' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3812:1: ( '>' )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3812:1: ( '>' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3813:1: '>'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3834:1: rule__EGenericTypeDecl__Group_0_1_2__0 : ( ',' ) rule__EGenericTypeDecl__Group_0_1_2__1 ;
    public final void rule__EGenericTypeDecl__Group_0_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3838:1: ( ( ',' ) rule__EGenericTypeDecl__Group_0_1_2__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3839:1: ( ',' ) rule__EGenericTypeDecl__Group_0_1_2__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3839:1: ( ',' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3840:1: ','
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3854:1: rule__EGenericTypeDecl__Group_0_1_2__1 : ( ( rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_2_1 ) ) ;
    public final void rule__EGenericTypeDecl__Group_0_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3858:1: ( ( ( rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_2_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3859:1: ( ( rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_2_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3859:1: ( ( rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_2_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3860:1: ( rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_2_1 )
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getETypeArgumentsAssignment_0_1_2_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3861:1: ( rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_2_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3861:2: rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_2_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3875:1: rule__EGenericTypeDecl__Group_1__0 : ( '#' ) rule__EGenericTypeDecl__Group_1__1 ;
    public final void rule__EGenericTypeDecl__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3879:1: ( ( '#' ) rule__EGenericTypeDecl__Group_1__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3880:1: ( '#' ) rule__EGenericTypeDecl__Group_1__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3880:1: ( '#' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3881:1: '#'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3895:1: rule__EGenericTypeDecl__Group_1__1 : ( ( rule__EGenericTypeDecl__ETypeParameterAssignment_1_1 ) ) ;
    public final void rule__EGenericTypeDecl__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3899:1: ( ( ( rule__EGenericTypeDecl__ETypeParameterAssignment_1_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3900:1: ( ( rule__EGenericTypeDecl__ETypeParameterAssignment_1_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3900:1: ( ( rule__EGenericTypeDecl__ETypeParameterAssignment_1_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3901:1: ( rule__EGenericTypeDecl__ETypeParameterAssignment_1_1 )
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getETypeParameterAssignment_1_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3902:1: ( rule__EGenericTypeDecl__ETypeParameterAssignment_1_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3902:2: rule__EGenericTypeDecl__ETypeParameterAssignment_1_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3916:1: rule__EGenericTypeDecl__Group_2__0 : ( '?' ) rule__EGenericTypeDecl__Group_2__1 ;
    public final void rule__EGenericTypeDecl__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3920:1: ( ( '?' ) rule__EGenericTypeDecl__Group_2__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3921:1: ( '?' ) rule__EGenericTypeDecl__Group_2__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3921:1: ( '?' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3922:1: '?'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3936:1: rule__EGenericTypeDecl__Group_2__1 : ( ( rule__EGenericTypeDecl__Alternatives_2_1 ) ) ;
    public final void rule__EGenericTypeDecl__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3940:1: ( ( ( rule__EGenericTypeDecl__Alternatives_2_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3941:1: ( ( rule__EGenericTypeDecl__Alternatives_2_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3941:1: ( ( rule__EGenericTypeDecl__Alternatives_2_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3942:1: ( rule__EGenericTypeDecl__Alternatives_2_1 )
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getAlternatives_2_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3943:1: ( rule__EGenericTypeDecl__Alternatives_2_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3943:2: rule__EGenericTypeDecl__Alternatives_2_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3957:1: rule__EGenericTypeDecl__Group_2_1_0__0 : ( 'extends' ) rule__EGenericTypeDecl__Group_2_1_0__1 ;
    public final void rule__EGenericTypeDecl__Group_2_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3961:1: ( ( 'extends' ) rule__EGenericTypeDecl__Group_2_1_0__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3962:1: ( 'extends' ) rule__EGenericTypeDecl__Group_2_1_0__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3962:1: ( 'extends' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3963:1: 'extends'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3977:1: rule__EGenericTypeDecl__Group_2_1_0__1 : ( ( rule__EGenericTypeDecl__EUpperBoundAssignment_2_1_0_1 ) ) ;
    public final void rule__EGenericTypeDecl__Group_2_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3981:1: ( ( ( rule__EGenericTypeDecl__EUpperBoundAssignment_2_1_0_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3982:1: ( ( rule__EGenericTypeDecl__EUpperBoundAssignment_2_1_0_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3982:1: ( ( rule__EGenericTypeDecl__EUpperBoundAssignment_2_1_0_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3983:1: ( rule__EGenericTypeDecl__EUpperBoundAssignment_2_1_0_1 )
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getEUpperBoundAssignment_2_1_0_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3984:1: ( rule__EGenericTypeDecl__EUpperBoundAssignment_2_1_0_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3984:2: rule__EGenericTypeDecl__EUpperBoundAssignment_2_1_0_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:3998:1: rule__EGenericTypeDecl__Group_2_1_1__0 : ( 'super' ) rule__EGenericTypeDecl__Group_2_1_1__1 ;
    public final void rule__EGenericTypeDecl__Group_2_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4002:1: ( ( 'super' ) rule__EGenericTypeDecl__Group_2_1_1__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4003:1: ( 'super' ) rule__EGenericTypeDecl__Group_2_1_1__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4003:1: ( 'super' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4004:1: 'super'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4018:1: rule__EGenericTypeDecl__Group_2_1_1__1 : ( ( rule__EGenericTypeDecl__ELowerBoundAssignment_2_1_1_1 ) ) ;
    public final void rule__EGenericTypeDecl__Group_2_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4022:1: ( ( ( rule__EGenericTypeDecl__ELowerBoundAssignment_2_1_1_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4023:1: ( ( rule__EGenericTypeDecl__ELowerBoundAssignment_2_1_1_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4023:1: ( ( rule__EGenericTypeDecl__ELowerBoundAssignment_2_1_1_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4024:1: ( rule__EGenericTypeDecl__ELowerBoundAssignment_2_1_1_1 )
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getELowerBoundAssignment_2_1_1_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4025:1: ( rule__EGenericTypeDecl__ELowerBoundAssignment_2_1_1_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4025:2: rule__EGenericTypeDecl__ELowerBoundAssignment_2_1_1_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4039:1: rule__EOperationDecl__Group__0 : ( ( rule__EOperationDecl__EAnnotationsAssignment_0 )* ) rule__EOperationDecl__Group__1 ;
    public final void rule__EOperationDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4043:1: ( ( ( rule__EOperationDecl__EAnnotationsAssignment_0 )* ) rule__EOperationDecl__Group__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4044:1: ( ( rule__EOperationDecl__EAnnotationsAssignment_0 )* ) rule__EOperationDecl__Group__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4044:1: ( ( rule__EOperationDecl__EAnnotationsAssignment_0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4045:1: ( rule__EOperationDecl__EAnnotationsAssignment_0 )*
            {
             before(grammarAccess.getEOperationDeclAccess().getEAnnotationsAssignment_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4046:1: ( rule__EOperationDecl__EAnnotationsAssignment_0 )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==31) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4046:2: rule__EOperationDecl__EAnnotationsAssignment_0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4057:1: rule__EOperationDecl__Group__1 : ( ( rule__EOperationDecl__Alternatives_1 )* ) rule__EOperationDecl__Group__2 ;
    public final void rule__EOperationDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4061:1: ( ( ( rule__EOperationDecl__Alternatives_1 )* ) rule__EOperationDecl__Group__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4062:1: ( ( rule__EOperationDecl__Alternatives_1 )* ) rule__EOperationDecl__Group__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4062:1: ( ( rule__EOperationDecl__Alternatives_1 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4063:1: ( rule__EOperationDecl__Alternatives_1 )*
            {
             before(grammarAccess.getEOperationDeclAccess().getAlternatives_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4064:1: ( rule__EOperationDecl__Alternatives_1 )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( ((LA57_0>=RULE_BAG && LA57_0<=RULE_RANDOM)) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4064:2: rule__EOperationDecl__Alternatives_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4075:1: rule__EOperationDecl__Group__2 : ( 'op' ) rule__EOperationDecl__Group__3 ;
    public final void rule__EOperationDecl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4079:1: ( ( 'op' ) rule__EOperationDecl__Group__3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4080:1: ( 'op' ) rule__EOperationDecl__Group__3
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4080:1: ( 'op' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4081:1: 'op'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4095:1: rule__EOperationDecl__Group__3 : ( ( rule__EOperationDecl__Alternatives_3 ) ) rule__EOperationDecl__Group__4 ;
    public final void rule__EOperationDecl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4099:1: ( ( ( rule__EOperationDecl__Alternatives_3 ) ) rule__EOperationDecl__Group__4 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4100:1: ( ( rule__EOperationDecl__Alternatives_3 ) ) rule__EOperationDecl__Group__4
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4100:1: ( ( rule__EOperationDecl__Alternatives_3 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4101:1: ( rule__EOperationDecl__Alternatives_3 )
            {
             before(grammarAccess.getEOperationDeclAccess().getAlternatives_3()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4102:1: ( rule__EOperationDecl__Alternatives_3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4102:2: rule__EOperationDecl__Alternatives_3
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4113:1: rule__EOperationDecl__Group__4 : ( ( rule__EOperationDecl__NameAssignment_4 ) ) rule__EOperationDecl__Group__5 ;
    public final void rule__EOperationDecl__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4117:1: ( ( ( rule__EOperationDecl__NameAssignment_4 ) ) rule__EOperationDecl__Group__5 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4118:1: ( ( rule__EOperationDecl__NameAssignment_4 ) ) rule__EOperationDecl__Group__5
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4118:1: ( ( rule__EOperationDecl__NameAssignment_4 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4119:1: ( rule__EOperationDecl__NameAssignment_4 )
            {
             before(grammarAccess.getEOperationDeclAccess().getNameAssignment_4()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4120:1: ( rule__EOperationDecl__NameAssignment_4 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4120:2: rule__EOperationDecl__NameAssignment_4
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4131:1: rule__EOperationDecl__Group__5 : ( ( rule__EOperationDecl__Group_5__0 )? ) rule__EOperationDecl__Group__6 ;
    public final void rule__EOperationDecl__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4135:1: ( ( ( rule__EOperationDecl__Group_5__0 )? ) rule__EOperationDecl__Group__6 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4136:1: ( ( rule__EOperationDecl__Group_5__0 )? ) rule__EOperationDecl__Group__6
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4136:1: ( ( rule__EOperationDecl__Group_5__0 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4137:1: ( rule__EOperationDecl__Group_5__0 )?
            {
             before(grammarAccess.getEOperationDeclAccess().getGroup_5()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4138:1: ( rule__EOperationDecl__Group_5__0 )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==35) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4138:2: rule__EOperationDecl__Group_5__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4149:1: rule__EOperationDecl__Group__6 : ( '(' ) rule__EOperationDecl__Group__7 ;
    public final void rule__EOperationDecl__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4153:1: ( ( '(' ) rule__EOperationDecl__Group__7 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4154:1: ( '(' ) rule__EOperationDecl__Group__7
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4154:1: ( '(' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4155:1: '('
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4169:1: rule__EOperationDecl__Group__7 : ( ( rule__EOperationDecl__Group_7__0 )? ) rule__EOperationDecl__Group__8 ;
    public final void rule__EOperationDecl__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4173:1: ( ( ( rule__EOperationDecl__Group_7__0 )? ) rule__EOperationDecl__Group__8 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4174:1: ( ( rule__EOperationDecl__Group_7__0 )? ) rule__EOperationDecl__Group__8
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4174:1: ( ( rule__EOperationDecl__Group_7__0 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4175:1: ( rule__EOperationDecl__Group_7__0 )?
            {
             before(grammarAccess.getEOperationDeclAccess().getGroup_7()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4176:1: ( rule__EOperationDecl__Group_7__0 )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==RULE_ID||LA59_0==31||LA59_0==42) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4176:2: rule__EOperationDecl__Group_7__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4187:1: rule__EOperationDecl__Group__8 : ( ')' ) rule__EOperationDecl__Group__9 ;
    public final void rule__EOperationDecl__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4191:1: ( ( ')' ) rule__EOperationDecl__Group__9 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4192:1: ( ')' ) rule__EOperationDecl__Group__9
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4192:1: ( ')' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4193:1: ')'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4207:1: rule__EOperationDecl__Group__9 : ( ( rule__EOperationDecl__Group_9__0 )? ) rule__EOperationDecl__Group__10 ;
    public final void rule__EOperationDecl__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4211:1: ( ( ( rule__EOperationDecl__Group_9__0 )? ) rule__EOperationDecl__Group__10 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4212:1: ( ( rule__EOperationDecl__Group_9__0 )? ) rule__EOperationDecl__Group__10
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4212:1: ( ( rule__EOperationDecl__Group_9__0 )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4213:1: ( rule__EOperationDecl__Group_9__0 )?
            {
             before(grammarAccess.getEOperationDeclAccess().getGroup_9()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4214:1: ( rule__EOperationDecl__Group_9__0 )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==47) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4214:2: rule__EOperationDecl__Group_9__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4225:1: rule__EOperationDecl__Group__10 : ( ';' ) ;
    public final void rule__EOperationDecl__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4229:1: ( ( ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4230:1: ( ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4230:1: ( ';' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4231:1: ';'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4266:1: rule__EOperationDecl__Group_5__0 : ( '<' ) rule__EOperationDecl__Group_5__1 ;
    public final void rule__EOperationDecl__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4270:1: ( ( '<' ) rule__EOperationDecl__Group_5__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4271:1: ( '<' ) rule__EOperationDecl__Group_5__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4271:1: ( '<' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4272:1: '<'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4286:1: rule__EOperationDecl__Group_5__1 : ( ( rule__EOperationDecl__ETypeParametersAssignment_5_1 ) ) rule__EOperationDecl__Group_5__2 ;
    public final void rule__EOperationDecl__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4290:1: ( ( ( rule__EOperationDecl__ETypeParametersAssignment_5_1 ) ) rule__EOperationDecl__Group_5__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4291:1: ( ( rule__EOperationDecl__ETypeParametersAssignment_5_1 ) ) rule__EOperationDecl__Group_5__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4291:1: ( ( rule__EOperationDecl__ETypeParametersAssignment_5_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4292:1: ( rule__EOperationDecl__ETypeParametersAssignment_5_1 )
            {
             before(grammarAccess.getEOperationDeclAccess().getETypeParametersAssignment_5_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4293:1: ( rule__EOperationDecl__ETypeParametersAssignment_5_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4293:2: rule__EOperationDecl__ETypeParametersAssignment_5_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4304:1: rule__EOperationDecl__Group_5__2 : ( ( rule__EOperationDecl__Group_5_2__0 )* ) rule__EOperationDecl__Group_5__3 ;
    public final void rule__EOperationDecl__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4308:1: ( ( ( rule__EOperationDecl__Group_5_2__0 )* ) rule__EOperationDecl__Group_5__3 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4309:1: ( ( rule__EOperationDecl__Group_5_2__0 )* ) rule__EOperationDecl__Group_5__3
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4309:1: ( ( rule__EOperationDecl__Group_5_2__0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4310:1: ( rule__EOperationDecl__Group_5_2__0 )*
            {
             before(grammarAccess.getEOperationDeclAccess().getGroup_5_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4311:1: ( rule__EOperationDecl__Group_5_2__0 )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==34) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4311:2: rule__EOperationDecl__Group_5_2__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4322:1: rule__EOperationDecl__Group_5__3 : ( '>' ) ;
    public final void rule__EOperationDecl__Group_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4326:1: ( ( '>' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4327:1: ( '>' )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4327:1: ( '>' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4328:1: '>'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4349:1: rule__EOperationDecl__Group_5_2__0 : ( ',' ) rule__EOperationDecl__Group_5_2__1 ;
    public final void rule__EOperationDecl__Group_5_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4353:1: ( ( ',' ) rule__EOperationDecl__Group_5_2__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4354:1: ( ',' ) rule__EOperationDecl__Group_5_2__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4354:1: ( ',' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4355:1: ','
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4369:1: rule__EOperationDecl__Group_5_2__1 : ( ( rule__EOperationDecl__ETypeParametersAssignment_5_2_1 ) ) ;
    public final void rule__EOperationDecl__Group_5_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4373:1: ( ( ( rule__EOperationDecl__ETypeParametersAssignment_5_2_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4374:1: ( ( rule__EOperationDecl__ETypeParametersAssignment_5_2_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4374:1: ( ( rule__EOperationDecl__ETypeParametersAssignment_5_2_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4375:1: ( rule__EOperationDecl__ETypeParametersAssignment_5_2_1 )
            {
             before(grammarAccess.getEOperationDeclAccess().getETypeParametersAssignment_5_2_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4376:1: ( rule__EOperationDecl__ETypeParametersAssignment_5_2_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4376:2: rule__EOperationDecl__ETypeParametersAssignment_5_2_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4390:1: rule__EOperationDecl__Group_7__0 : ( ( rule__EOperationDecl__EParametersAssignment_7_0 ) ) rule__EOperationDecl__Group_7__1 ;
    public final void rule__EOperationDecl__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4394:1: ( ( ( rule__EOperationDecl__EParametersAssignment_7_0 ) ) rule__EOperationDecl__Group_7__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4395:1: ( ( rule__EOperationDecl__EParametersAssignment_7_0 ) ) rule__EOperationDecl__Group_7__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4395:1: ( ( rule__EOperationDecl__EParametersAssignment_7_0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4396:1: ( rule__EOperationDecl__EParametersAssignment_7_0 )
            {
             before(grammarAccess.getEOperationDeclAccess().getEParametersAssignment_7_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4397:1: ( rule__EOperationDecl__EParametersAssignment_7_0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4397:2: rule__EOperationDecl__EParametersAssignment_7_0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4408:1: rule__EOperationDecl__Group_7__1 : ( ( rule__EOperationDecl__Group_7_1__0 )* ) ;
    public final void rule__EOperationDecl__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4412:1: ( ( ( rule__EOperationDecl__Group_7_1__0 )* ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4413:1: ( ( rule__EOperationDecl__Group_7_1__0 )* )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4413:1: ( ( rule__EOperationDecl__Group_7_1__0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4414:1: ( rule__EOperationDecl__Group_7_1__0 )*
            {
             before(grammarAccess.getEOperationDeclAccess().getGroup_7_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4415:1: ( rule__EOperationDecl__Group_7_1__0 )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==34) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4415:2: rule__EOperationDecl__Group_7_1__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4429:1: rule__EOperationDecl__Group_7_1__0 : ( ',' ) rule__EOperationDecl__Group_7_1__1 ;
    public final void rule__EOperationDecl__Group_7_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4433:1: ( ( ',' ) rule__EOperationDecl__Group_7_1__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4434:1: ( ',' ) rule__EOperationDecl__Group_7_1__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4434:1: ( ',' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4435:1: ','
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4449:1: rule__EOperationDecl__Group_7_1__1 : ( ( rule__EOperationDecl__EParametersAssignment_7_1_1 ) ) ;
    public final void rule__EOperationDecl__Group_7_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4453:1: ( ( ( rule__EOperationDecl__EParametersAssignment_7_1_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4454:1: ( ( rule__EOperationDecl__EParametersAssignment_7_1_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4454:1: ( ( rule__EOperationDecl__EParametersAssignment_7_1_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4455:1: ( rule__EOperationDecl__EParametersAssignment_7_1_1 )
            {
             before(grammarAccess.getEOperationDeclAccess().getEParametersAssignment_7_1_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4456:1: ( rule__EOperationDecl__EParametersAssignment_7_1_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4456:2: rule__EOperationDecl__EParametersAssignment_7_1_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4470:1: rule__EOperationDecl__Group_9__0 : ( 'throws' ) rule__EOperationDecl__Group_9__1 ;
    public final void rule__EOperationDecl__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4474:1: ( ( 'throws' ) rule__EOperationDecl__Group_9__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4475:1: ( 'throws' ) rule__EOperationDecl__Group_9__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4475:1: ( 'throws' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4476:1: 'throws'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4490:1: rule__EOperationDecl__Group_9__1 : ( ( rule__EOperationDecl__EGenericExceptionsAssignment_9_1 ) ) rule__EOperationDecl__Group_9__2 ;
    public final void rule__EOperationDecl__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4494:1: ( ( ( rule__EOperationDecl__EGenericExceptionsAssignment_9_1 ) ) rule__EOperationDecl__Group_9__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4495:1: ( ( rule__EOperationDecl__EGenericExceptionsAssignment_9_1 ) ) rule__EOperationDecl__Group_9__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4495:1: ( ( rule__EOperationDecl__EGenericExceptionsAssignment_9_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4496:1: ( rule__EOperationDecl__EGenericExceptionsAssignment_9_1 )
            {
             before(grammarAccess.getEOperationDeclAccess().getEGenericExceptionsAssignment_9_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4497:1: ( rule__EOperationDecl__EGenericExceptionsAssignment_9_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4497:2: rule__EOperationDecl__EGenericExceptionsAssignment_9_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4508:1: rule__EOperationDecl__Group_9__2 : ( ( rule__EOperationDecl__Group_9_2__0 )* ) ;
    public final void rule__EOperationDecl__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4512:1: ( ( ( rule__EOperationDecl__Group_9_2__0 )* ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4513:1: ( ( rule__EOperationDecl__Group_9_2__0 )* )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4513:1: ( ( rule__EOperationDecl__Group_9_2__0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4514:1: ( rule__EOperationDecl__Group_9_2__0 )*
            {
             before(grammarAccess.getEOperationDeclAccess().getGroup_9_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4515:1: ( rule__EOperationDecl__Group_9_2__0 )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==34) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4515:2: rule__EOperationDecl__Group_9_2__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4531:1: rule__EOperationDecl__Group_9_2__0 : ( ',' ) rule__EOperationDecl__Group_9_2__1 ;
    public final void rule__EOperationDecl__Group_9_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4535:1: ( ( ',' ) rule__EOperationDecl__Group_9_2__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4536:1: ( ',' ) rule__EOperationDecl__Group_9_2__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4536:1: ( ',' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4537:1: ','
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4551:1: rule__EOperationDecl__Group_9_2__1 : ( ( rule__EOperationDecl__EGenericExceptionsAssignment_9_2_1 ) ) ;
    public final void rule__EOperationDecl__Group_9_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4555:1: ( ( ( rule__EOperationDecl__EGenericExceptionsAssignment_9_2_1 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4556:1: ( ( rule__EOperationDecl__EGenericExceptionsAssignment_9_2_1 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4556:1: ( ( rule__EOperationDecl__EGenericExceptionsAssignment_9_2_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4557:1: ( rule__EOperationDecl__EGenericExceptionsAssignment_9_2_1 )
            {
             before(grammarAccess.getEOperationDeclAccess().getEGenericExceptionsAssignment_9_2_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4558:1: ( rule__EOperationDecl__EGenericExceptionsAssignment_9_2_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4558:2: rule__EOperationDecl__EGenericExceptionsAssignment_9_2_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4572:1: rule__EParameterDecl__Group__0 : ( ( rule__EParameterDecl__EAnnotationsAssignment_0 )* ) rule__EParameterDecl__Group__1 ;
    public final void rule__EParameterDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4576:1: ( ( ( rule__EParameterDecl__EAnnotationsAssignment_0 )* ) rule__EParameterDecl__Group__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4577:1: ( ( rule__EParameterDecl__EAnnotationsAssignment_0 )* ) rule__EParameterDecl__Group__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4577:1: ( ( rule__EParameterDecl__EAnnotationsAssignment_0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4578:1: ( rule__EParameterDecl__EAnnotationsAssignment_0 )*
            {
             before(grammarAccess.getEParameterDeclAccess().getEAnnotationsAssignment_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4579:1: ( rule__EParameterDecl__EAnnotationsAssignment_0 )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==31) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4579:2: rule__EParameterDecl__EAnnotationsAssignment_0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4590:1: rule__EParameterDecl__Group__1 : ( ( rule__EParameterDecl__EGenericTypeAssignment_1 ) ) rule__EParameterDecl__Group__2 ;
    public final void rule__EParameterDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4594:1: ( ( ( rule__EParameterDecl__EGenericTypeAssignment_1 ) ) rule__EParameterDecl__Group__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4595:1: ( ( rule__EParameterDecl__EGenericTypeAssignment_1 ) ) rule__EParameterDecl__Group__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4595:1: ( ( rule__EParameterDecl__EGenericTypeAssignment_1 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4596:1: ( rule__EParameterDecl__EGenericTypeAssignment_1 )
            {
             before(grammarAccess.getEParameterDeclAccess().getEGenericTypeAssignment_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4597:1: ( rule__EParameterDecl__EGenericTypeAssignment_1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4597:2: rule__EParameterDecl__EGenericTypeAssignment_1
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4608:1: rule__EParameterDecl__Group__2 : ( ( rule__EParameterDecl__NameAssignment_2 ) ) ;
    public final void rule__EParameterDecl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4612:1: ( ( ( rule__EParameterDecl__NameAssignment_2 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4613:1: ( ( rule__EParameterDecl__NameAssignment_2 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4613:1: ( ( rule__EParameterDecl__NameAssignment_2 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4614:1: ( rule__EParameterDecl__NameAssignment_2 )
            {
             before(grammarAccess.getEParameterDeclAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4615:1: ( rule__EParameterDecl__NameAssignment_2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4615:2: rule__EParameterDecl__NameAssignment_2
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4631:1: rule__MapEntry__Group__0 : ( ( rule__MapEntry__KeyAssignment_0 ) ) rule__MapEntry__Group__1 ;
    public final void rule__MapEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4635:1: ( ( ( rule__MapEntry__KeyAssignment_0 ) ) rule__MapEntry__Group__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4636:1: ( ( rule__MapEntry__KeyAssignment_0 ) ) rule__MapEntry__Group__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4636:1: ( ( rule__MapEntry__KeyAssignment_0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4637:1: ( rule__MapEntry__KeyAssignment_0 )
            {
             before(grammarAccess.getMapEntryAccess().getKeyAssignment_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4638:1: ( rule__MapEntry__KeyAssignment_0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4638:2: rule__MapEntry__KeyAssignment_0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4649:1: rule__MapEntry__Group__1 : ( '=' ) rule__MapEntry__Group__2 ;
    public final void rule__MapEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4653:1: ( ( '=' ) rule__MapEntry__Group__2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4654:1: ( '=' ) rule__MapEntry__Group__2
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4654:1: ( '=' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4655:1: '='
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4669:1: rule__MapEntry__Group__2 : ( ( rule__MapEntry__ValueAssignment_2 ) ) ;
    public final void rule__MapEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4673:1: ( ( ( rule__MapEntry__ValueAssignment_2 ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4674:1: ( ( rule__MapEntry__ValueAssignment_2 ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4674:1: ( ( rule__MapEntry__ValueAssignment_2 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4675:1: ( rule__MapEntry__ValueAssignment_2 )
            {
             before(grammarAccess.getMapEntryAccess().getValueAssignment_2()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4676:1: ( rule__MapEntry__ValueAssignment_2 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4676:2: rule__MapEntry__ValueAssignment_2
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4692:1: rule__QID__Group__0 : ( RULE_ID ) rule__QID__Group__1 ;
    public final void rule__QID__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4696:1: ( ( RULE_ID ) rule__QID__Group__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4697:1: ( RULE_ID ) rule__QID__Group__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4697:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4698:1: RULE_ID
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4710:1: rule__QID__Group__1 : ( ( rule__QID__Group_1__0 )* ) ;
    public final void rule__QID__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4714:1: ( ( ( rule__QID__Group_1__0 )* ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4715:1: ( ( rule__QID__Group_1__0 )* )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4715:1: ( ( rule__QID__Group_1__0 )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4716:1: ( rule__QID__Group_1__0 )*
            {
             before(grammarAccess.getQIDAccess().getGroup_1()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4717:1: ( rule__QID__Group_1__0 )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( ((LA65_0>=19 && LA65_0<=20)) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4717:2: rule__QID__Group_1__0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4731:1: rule__QID__Group_1__0 : ( ( rule__QID__Alternatives_1_0 ) ) rule__QID__Group_1__1 ;
    public final void rule__QID__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4735:1: ( ( ( rule__QID__Alternatives_1_0 ) ) rule__QID__Group_1__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4736:1: ( ( rule__QID__Alternatives_1_0 ) ) rule__QID__Group_1__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4736:1: ( ( rule__QID__Alternatives_1_0 ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4737:1: ( rule__QID__Alternatives_1_0 )
            {
             before(grammarAccess.getQIDAccess().getAlternatives_1_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4738:1: ( rule__QID__Alternatives_1_0 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4738:2: rule__QID__Alternatives_1_0
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4749:1: rule__QID__Group_1__1 : ( RULE_ID ) ;
    public final void rule__QID__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4753:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4754:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4754:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4755:1: RULE_ID
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4770:1: rule__SINT__Group__0 : ( ( '-' )? ) rule__SINT__Group__1 ;
    public final void rule__SINT__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4774:1: ( ( ( '-' )? ) rule__SINT__Group__1 )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4775:1: ( ( '-' )? ) rule__SINT__Group__1
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4775:1: ( ( '-' )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4776:1: ( '-' )?
            {
             before(grammarAccess.getSINTAccess().getHyphenMinusKeyword_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4777:1: ( '-' )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==48) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4778:2: '-'
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4790:1: rule__SINT__Group__1 : ( RULE_INT ) ;
    public final void rule__SINT__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4794:1: ( ( RULE_INT ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4795:1: ( RULE_INT )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4795:1: ( RULE_INT )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4796:1: RULE_INT
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4812:1: rule__EcoreDsl__MetamodelDeclarationsAssignment_0 : ( ruleReferencedMetamodel ) ;
    public final void rule__EcoreDsl__MetamodelDeclarationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4816:1: ( ( ruleReferencedMetamodel ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4817:1: ( ruleReferencedMetamodel )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4817:1: ( ruleReferencedMetamodel )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4818:1: ruleReferencedMetamodel
            {
             before(grammarAccess.getEcoreDslAccess().getMetamodelDeclarationsReferencedMetamodelParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferencedMetamodel_in_rule__EcoreDsl__MetamodelDeclarationsAssignment_09522);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4827:1: rule__EcoreDsl__PackageAssignment_1 : ( ruleEPackageDecl ) ;
    public final void rule__EcoreDsl__PackageAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4831:1: ( ( ruleEPackageDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4832:1: ( ruleEPackageDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4832:1: ( ruleEPackageDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4833:1: ruleEPackageDecl
            {
             before(grammarAccess.getEcoreDslAccess().getPackageEPackageDeclParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEPackageDecl_in_rule__EcoreDsl__PackageAssignment_19553);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4842:1: rule__ReferencedMetamodel__AliasAssignment_1_0 : ( RULE_ID ) ;
    public final void rule__ReferencedMetamodel__AliasAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4846:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4847:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4847:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4848:1: RULE_ID
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAliasIDTerminalRuleCall_1_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ReferencedMetamodel__AliasAssignment_1_09584); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4857:1: rule__ReferencedMetamodel__EPackageAssignment_2 : ( ( RULE_STRING ) ) ;
    public final void rule__ReferencedMetamodel__EPackageAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4861:1: ( ( ( RULE_STRING ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4862:1: ( ( RULE_STRING ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4862:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4863:1: ( RULE_STRING )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageCrossReference_2_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4864:1: ( RULE_STRING )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4865:1: RULE_STRING
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_2_0_1()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__ReferencedMetamodel__EPackageAssignment_29619); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4876:1: rule__EPackageDecl__EAnnotationsAssignment_0 : ( ruleEAnnotationDecl ) ;
    public final void rule__EPackageDecl__EAnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4880:1: ( ( ruleEAnnotationDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4881:1: ( ruleEAnnotationDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4881:1: ( ruleEAnnotationDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4882:1: ruleEAnnotationDecl
            {
             before(grammarAccess.getEPackageDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEAnnotationDecl_in_rule__EPackageDecl__EAnnotationsAssignment_09654);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4891:1: rule__EPackageDecl__NameAssignment_2 : ( ruleQID ) ;
    public final void rule__EPackageDecl__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4895:1: ( ( ruleQID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4896:1: ( ruleQID )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4896:1: ( ruleQID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4897:1: ruleQID
            {
             before(grammarAccess.getEPackageDeclAccess().getNameQIDParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleQID_in_rule__EPackageDecl__NameAssignment_29685);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4906:1: rule__EPackageDecl__NsURIAssignment_5 : ( RULE_STRING ) ;
    public final void rule__EPackageDecl__NsURIAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4910:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4911:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4911:1: ( RULE_STRING )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4912:1: RULE_STRING
            {
             before(grammarAccess.getEPackageDeclAccess().getNsURISTRINGTerminalRuleCall_5_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__EPackageDecl__NsURIAssignment_59716); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4921:1: rule__EPackageDecl__NsPrefixAssignment_8 : ( ruleQID ) ;
    public final void rule__EPackageDecl__NsPrefixAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4925:1: ( ( ruleQID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4926:1: ( ruleQID )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4926:1: ( ruleQID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4927:1: ruleQID
            {
             before(grammarAccess.getEPackageDeclAccess().getNsPrefixQIDParserRuleCall_8_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleQID_in_rule__EPackageDecl__NsPrefixAssignment_89747);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4936:1: rule__EPackageDecl__ESubpackagesAssignment_10_0 : ( ruleSubEPackageDecl ) ;
    public final void rule__EPackageDecl__ESubpackagesAssignment_10_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4940:1: ( ( ruleSubEPackageDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4941:1: ( ruleSubEPackageDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4941:1: ( ruleSubEPackageDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4942:1: ruleSubEPackageDecl
            {
             before(grammarAccess.getEPackageDeclAccess().getESubpackagesSubEPackageDeclParserRuleCall_10_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSubEPackageDecl_in_rule__EPackageDecl__ESubpackagesAssignment_10_09778);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4951:1: rule__EPackageDecl__EClassifiersAssignment_10_1 : ( ruleEClassifierDecl ) ;
    public final void rule__EPackageDecl__EClassifiersAssignment_10_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4955:1: ( ( ruleEClassifierDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4956:1: ( ruleEClassifierDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4956:1: ( ruleEClassifierDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4957:1: ruleEClassifierDecl
            {
             before(grammarAccess.getEPackageDeclAccess().getEClassifiersEClassifierDeclParserRuleCall_10_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEClassifierDecl_in_rule__EPackageDecl__EClassifiersAssignment_10_19809);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4966:1: rule__SubEPackageDecl__EAnnotationsAssignment_0 : ( ruleEAnnotationDecl ) ;
    public final void rule__SubEPackageDecl__EAnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4970:1: ( ( ruleEAnnotationDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4971:1: ( ruleEAnnotationDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4971:1: ( ruleEAnnotationDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4972:1: ruleEAnnotationDecl
            {
             before(grammarAccess.getSubEPackageDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEAnnotationDecl_in_rule__SubEPackageDecl__EAnnotationsAssignment_09840);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4981:1: rule__SubEPackageDecl__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__SubEPackageDecl__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4985:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4986:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4986:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4987:1: RULE_ID
            {
             before(grammarAccess.getSubEPackageDeclAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__SubEPackageDecl__NameAssignment_29871); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:4996:1: rule__SubEPackageDecl__ESubpackagesAssignment_4_0 : ( ruleSubEPackageDecl ) ;
    public final void rule__SubEPackageDecl__ESubpackagesAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5000:1: ( ( ruleSubEPackageDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5001:1: ( ruleSubEPackageDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5001:1: ( ruleSubEPackageDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5002:1: ruleSubEPackageDecl
            {
             before(grammarAccess.getSubEPackageDeclAccess().getESubpackagesSubEPackageDeclParserRuleCall_4_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSubEPackageDecl_in_rule__SubEPackageDecl__ESubpackagesAssignment_4_09902);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5011:1: rule__SubEPackageDecl__EClassifiersAssignment_4_1 : ( ruleEClassifierDecl ) ;
    public final void rule__SubEPackageDecl__EClassifiersAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5015:1: ( ( ruleEClassifierDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5016:1: ( ruleEClassifierDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5016:1: ( ruleEClassifierDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5017:1: ruleEClassifierDecl
            {
             before(grammarAccess.getSubEPackageDeclAccess().getEClassifiersEClassifierDeclParserRuleCall_4_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEClassifierDecl_in_rule__SubEPackageDecl__EClassifiersAssignment_4_19933);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5026:1: rule__EDataTypeDecl__EAnnotationsAssignment_0_0 : ( ruleEAnnotationDecl ) ;
    public final void rule__EDataTypeDecl__EAnnotationsAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5030:1: ( ( ruleEAnnotationDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5031:1: ( ruleEAnnotationDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5031:1: ( ruleEAnnotationDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5032:1: ruleEAnnotationDecl
            {
             before(grammarAccess.getEDataTypeDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEAnnotationDecl_in_rule__EDataTypeDecl__EAnnotationsAssignment_0_09964);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5041:1: rule__EDataTypeDecl__SerializableAssignment_0_1 : ( RULE_SERIALIZABLE ) ;
    public final void rule__EDataTypeDecl__SerializableAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5045:1: ( ( RULE_SERIALIZABLE ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5046:1: ( RULE_SERIALIZABLE )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5046:1: ( RULE_SERIALIZABLE )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5047:1: RULE_SERIALIZABLE
            {
             before(grammarAccess.getEDataTypeDeclAccess().getSerializableSerializableTerminalRuleCall_0_1_0()); 
            match(input,RULE_SERIALIZABLE,FollowSets000.FOLLOW_RULE_SERIALIZABLE_in_rule__EDataTypeDecl__SerializableAssignment_0_19995); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5056:1: rule__EDataTypeDecl__NameAssignment_0_2_1 : ( RULE_ID ) ;
    public final void rule__EDataTypeDecl__NameAssignment_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5060:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5061:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5061:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5062:1: RULE_ID
            {
             before(grammarAccess.getEDataTypeDeclAccess().getNameIDTerminalRuleCall_0_2_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EDataTypeDecl__NameAssignment_0_2_110026); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5071:1: rule__EDataTypeDecl__InstanceClassNameAssignment_0_2_3 : ( ruleSTRING_OR_QID ) ;
    public final void rule__EDataTypeDecl__InstanceClassNameAssignment_0_2_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5075:1: ( ( ruleSTRING_OR_QID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5076:1: ( ruleSTRING_OR_QID )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5076:1: ( ruleSTRING_OR_QID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5077:1: ruleSTRING_OR_QID
            {
             before(grammarAccess.getEDataTypeDeclAccess().getInstanceClassNameSTRING_OR_QIDParserRuleCall_0_2_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSTRING_OR_QID_in_rule__EDataTypeDecl__InstanceClassNameAssignment_0_2_310057);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5086:1: rule__EAnnotationDecl__SourceAssignment_1 : ( ruleSTRING_OR_QID ) ;
    public final void rule__EAnnotationDecl__SourceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5090:1: ( ( ruleSTRING_OR_QID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5091:1: ( ruleSTRING_OR_QID )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5091:1: ( ruleSTRING_OR_QID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5092:1: ruleSTRING_OR_QID
            {
             before(grammarAccess.getEAnnotationDeclAccess().getSourceSTRING_OR_QIDParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSTRING_OR_QID_in_rule__EAnnotationDecl__SourceAssignment_110088);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5101:1: rule__EAnnotationDecl__DetailsAssignment_2_1 : ( ruleMapEntry ) ;
    public final void rule__EAnnotationDecl__DetailsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5105:1: ( ( ruleMapEntry ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5106:1: ( ruleMapEntry )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5106:1: ( ruleMapEntry )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5107:1: ruleMapEntry
            {
             before(grammarAccess.getEAnnotationDeclAccess().getDetailsMapEntryParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleMapEntry_in_rule__EAnnotationDecl__DetailsAssignment_2_110119);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5116:1: rule__EAnnotationDecl__DetailsAssignment_2_2_1 : ( ruleMapEntry ) ;
    public final void rule__EAnnotationDecl__DetailsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5120:1: ( ( ruleMapEntry ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5121:1: ( ruleMapEntry )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5121:1: ( ruleMapEntry )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5122:1: ruleMapEntry
            {
             before(grammarAccess.getEAnnotationDeclAccess().getDetailsMapEntryParserRuleCall_2_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleMapEntry_in_rule__EAnnotationDecl__DetailsAssignment_2_2_110150);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5131:1: rule__EClassDecl__EAnnotationsAssignment_0 : ( ruleEAnnotationDecl ) ;
    public final void rule__EClassDecl__EAnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5135:1: ( ( ruleEAnnotationDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5136:1: ( ruleEAnnotationDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5136:1: ( ruleEAnnotationDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5137:1: ruleEAnnotationDecl
            {
             before(grammarAccess.getEClassDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEAnnotationDecl_in_rule__EClassDecl__EAnnotationsAssignment_010181);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5146:1: rule__EClassDecl__AbstractAssignment_1 : ( ( 'abstract' ) ) ;
    public final void rule__EClassDecl__AbstractAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5150:1: ( ( ( 'abstract' ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5151:1: ( ( 'abstract' ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5151:1: ( ( 'abstract' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5152:1: ( 'abstract' )
            {
             before(grammarAccess.getEClassDeclAccess().getAbstractAbstractKeyword_1_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5153:1: ( 'abstract' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5154:1: 'abstract'
            {
             before(grammarAccess.getEClassDeclAccess().getAbstractAbstractKeyword_1_0()); 
            match(input,49,FollowSets000.FOLLOW_49_in_rule__EClassDecl__AbstractAssignment_110217); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5169:1: rule__EClassDecl__InterfaceAssignment_2_0 : ( ( 'interface' ) ) ;
    public final void rule__EClassDecl__InterfaceAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5173:1: ( ( ( 'interface' ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5174:1: ( ( 'interface' ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5174:1: ( ( 'interface' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5175:1: ( 'interface' )
            {
             before(grammarAccess.getEClassDeclAccess().getInterfaceInterfaceKeyword_2_0_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5176:1: ( 'interface' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5177:1: 'interface'
            {
             before(grammarAccess.getEClassDeclAccess().getInterfaceInterfaceKeyword_2_0_0()); 
            match(input,50,FollowSets000.FOLLOW_50_in_rule__EClassDecl__InterfaceAssignment_2_010261); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5192:1: rule__EClassDecl__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__EClassDecl__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5196:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5197:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5197:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5198:1: RULE_ID
            {
             before(grammarAccess.getEClassDeclAccess().getNameIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EClassDecl__NameAssignment_310300); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5207:1: rule__EClassDecl__ETypeParametersAssignment_4_1 : ( ruleETypeParameterDecl ) ;
    public final void rule__EClassDecl__ETypeParametersAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5211:1: ( ( ruleETypeParameterDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5212:1: ( ruleETypeParameterDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5212:1: ( ruleETypeParameterDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5213:1: ruleETypeParameterDecl
            {
             before(grammarAccess.getEClassDeclAccess().getETypeParametersETypeParameterDeclParserRuleCall_4_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleETypeParameterDecl_in_rule__EClassDecl__ETypeParametersAssignment_4_110331);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5222:1: rule__EClassDecl__ETypeParametersAssignment_4_2_1 : ( ruleETypeParameterDecl ) ;
    public final void rule__EClassDecl__ETypeParametersAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5226:1: ( ( ruleETypeParameterDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5227:1: ( ruleETypeParameterDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5227:1: ( ruleETypeParameterDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5228:1: ruleETypeParameterDecl
            {
             before(grammarAccess.getEClassDeclAccess().getETypeParametersETypeParameterDeclParserRuleCall_4_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleETypeParameterDecl_in_rule__EClassDecl__ETypeParametersAssignment_4_2_110362);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5237:1: rule__EClassDecl__EGenericSuperTypesAssignment_5_1 : ( ruleEGenericTypeReferenceDecl ) ;
    public final void rule__EClassDecl__EGenericSuperTypesAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5241:1: ( ( ruleEGenericTypeReferenceDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5242:1: ( ruleEGenericTypeReferenceDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5242:1: ( ruleEGenericTypeReferenceDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5243:1: ruleEGenericTypeReferenceDecl
            {
             before(grammarAccess.getEClassDeclAccess().getEGenericSuperTypesEGenericTypeReferenceDeclParserRuleCall_5_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeReferenceDecl_in_rule__EClassDecl__EGenericSuperTypesAssignment_5_110393);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5252:1: rule__EClassDecl__EGenericSuperTypesAssignment_5_2_1 : ( ruleEGenericTypeReferenceDecl ) ;
    public final void rule__EClassDecl__EGenericSuperTypesAssignment_5_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5256:1: ( ( ruleEGenericTypeReferenceDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5257:1: ( ruleEGenericTypeReferenceDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5257:1: ( ruleEGenericTypeReferenceDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5258:1: ruleEGenericTypeReferenceDecl
            {
             before(grammarAccess.getEClassDeclAccess().getEGenericSuperTypesEGenericTypeReferenceDeclParserRuleCall_5_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeReferenceDecl_in_rule__EClassDecl__EGenericSuperTypesAssignment_5_2_110424);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5267:1: rule__EClassDecl__InstanceClassNameAssignment_6_1 : ( ruleSTRING_OR_QID ) ;
    public final void rule__EClassDecl__InstanceClassNameAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5271:1: ( ( ruleSTRING_OR_QID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5272:1: ( ruleSTRING_OR_QID )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5272:1: ( ruleSTRING_OR_QID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5273:1: ruleSTRING_OR_QID
            {
             before(grammarAccess.getEClassDeclAccess().getInstanceClassNameSTRING_OR_QIDParserRuleCall_6_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSTRING_OR_QID_in_rule__EClassDecl__InstanceClassNameAssignment_6_110455);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5282:1: rule__EClassDecl__EStructuralFeaturesAssignment_8_0 : ( ruleEStructuralFeatureDecl ) ;
    public final void rule__EClassDecl__EStructuralFeaturesAssignment_8_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5286:1: ( ( ruleEStructuralFeatureDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5287:1: ( ruleEStructuralFeatureDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5287:1: ( ruleEStructuralFeatureDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5288:1: ruleEStructuralFeatureDecl
            {
             before(grammarAccess.getEClassDeclAccess().getEStructuralFeaturesEStructuralFeatureDeclParserRuleCall_8_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEStructuralFeatureDecl_in_rule__EClassDecl__EStructuralFeaturesAssignment_8_010486);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5297:1: rule__EClassDecl__EOperationsAssignment_8_1 : ( ruleEOperationDecl ) ;
    public final void rule__EClassDecl__EOperationsAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5301:1: ( ( ruleEOperationDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5302:1: ( ruleEOperationDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5302:1: ( ruleEOperationDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5303:1: ruleEOperationDecl
            {
             before(grammarAccess.getEClassDeclAccess().getEOperationsEOperationDeclParserRuleCall_8_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEOperationDecl_in_rule__EClassDecl__EOperationsAssignment_8_110517);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5312:1: rule__EAttributeDecl__EAnnotationsAssignment_0 : ( ruleEAnnotationDecl ) ;
    public final void rule__EAttributeDecl__EAnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5316:1: ( ( ruleEAnnotationDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5317:1: ( ruleEAnnotationDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5317:1: ( ruleEAnnotationDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5318:1: ruleEAnnotationDecl
            {
             before(grammarAccess.getEAttributeDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEAnnotationDecl_in_rule__EAttributeDecl__EAnnotationsAssignment_010548);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5327:1: rule__EAttributeDecl__IDAssignment_1_0 : ( ( 'ID' ) ) ;
    public final void rule__EAttributeDecl__IDAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5331:1: ( ( ( 'ID' ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5332:1: ( ( 'ID' ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5332:1: ( ( 'ID' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5333:1: ( 'ID' )
            {
             before(grammarAccess.getEAttributeDeclAccess().getIDIDKeyword_1_0_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5334:1: ( 'ID' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5335:1: 'ID'
            {
             before(grammarAccess.getEAttributeDeclAccess().getIDIDKeyword_1_0_0()); 
            match(input,51,FollowSets000.FOLLOW_51_in_rule__EAttributeDecl__IDAssignment_1_010584); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5350:1: rule__EAttributeDecl__UniqueAssignment_1_1 : ( RULE_BAG ) ;
    public final void rule__EAttributeDecl__UniqueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5354:1: ( ( RULE_BAG ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5355:1: ( RULE_BAG )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5355:1: ( RULE_BAG )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5356:1: RULE_BAG
            {
             before(grammarAccess.getEAttributeDeclAccess().getUniqueBagTerminalRuleCall_1_1_0()); 
            match(input,RULE_BAG,FollowSets000.FOLLOW_RULE_BAG_in_rule__EAttributeDecl__UniqueAssignment_1_110623); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5365:1: rule__EAttributeDecl__OrderedAssignment_1_2 : ( RULE_RANDOM ) ;
    public final void rule__EAttributeDecl__OrderedAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5369:1: ( ( RULE_RANDOM ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5370:1: ( RULE_RANDOM )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5370:1: ( RULE_RANDOM )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5371:1: RULE_RANDOM
            {
             before(grammarAccess.getEAttributeDeclAccess().getOrderedRandomTerminalRuleCall_1_2_0()); 
            match(input,RULE_RANDOM,FollowSets000.FOLLOW_RULE_RANDOM_in_rule__EAttributeDecl__OrderedAssignment_1_210654); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5380:1: rule__EAttributeDecl__ChangeableAssignment_1_3 : ( RULE_READONLY ) ;
    public final void rule__EAttributeDecl__ChangeableAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5384:1: ( ( RULE_READONLY ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5385:1: ( RULE_READONLY )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5385:1: ( RULE_READONLY )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5386:1: RULE_READONLY
            {
             before(grammarAccess.getEAttributeDeclAccess().getChangeableReadonlyTerminalRuleCall_1_3_0()); 
            match(input,RULE_READONLY,FollowSets000.FOLLOW_RULE_READONLY_in_rule__EAttributeDecl__ChangeableAssignment_1_310685); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5395:1: rule__EAttributeDecl__VolatileAssignment_1_4 : ( ( 'volatile' ) ) ;
    public final void rule__EAttributeDecl__VolatileAssignment_1_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5399:1: ( ( ( 'volatile' ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5400:1: ( ( 'volatile' ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5400:1: ( ( 'volatile' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5401:1: ( 'volatile' )
            {
             before(grammarAccess.getEAttributeDeclAccess().getVolatileVolatileKeyword_1_4_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5402:1: ( 'volatile' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5403:1: 'volatile'
            {
             before(grammarAccess.getEAttributeDeclAccess().getVolatileVolatileKeyword_1_4_0()); 
            match(input,52,FollowSets000.FOLLOW_52_in_rule__EAttributeDecl__VolatileAssignment_1_410721); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5418:1: rule__EAttributeDecl__TransientAssignment_1_5 : ( ( 'transient' ) ) ;
    public final void rule__EAttributeDecl__TransientAssignment_1_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5422:1: ( ( ( 'transient' ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5423:1: ( ( 'transient' ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5423:1: ( ( 'transient' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5424:1: ( 'transient' )
            {
             before(grammarAccess.getEAttributeDeclAccess().getTransientTransientKeyword_1_5_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5425:1: ( 'transient' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5426:1: 'transient'
            {
             before(grammarAccess.getEAttributeDeclAccess().getTransientTransientKeyword_1_5_0()); 
            match(input,53,FollowSets000.FOLLOW_53_in_rule__EAttributeDecl__TransientAssignment_1_510765); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5441:1: rule__EAttributeDecl__UnsettableAssignment_1_6 : ( ( 'unsettable' ) ) ;
    public final void rule__EAttributeDecl__UnsettableAssignment_1_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5445:1: ( ( ( 'unsettable' ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5446:1: ( ( 'unsettable' ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5446:1: ( ( 'unsettable' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5447:1: ( 'unsettable' )
            {
             before(grammarAccess.getEAttributeDeclAccess().getUnsettableUnsettableKeyword_1_6_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5448:1: ( 'unsettable' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5449:1: 'unsettable'
            {
             before(grammarAccess.getEAttributeDeclAccess().getUnsettableUnsettableKeyword_1_6_0()); 
            match(input,54,FollowSets000.FOLLOW_54_in_rule__EAttributeDecl__UnsettableAssignment_1_610809); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5464:1: rule__EAttributeDecl__DerivedAssignment_1_7 : ( ( 'derived' ) ) ;
    public final void rule__EAttributeDecl__DerivedAssignment_1_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5468:1: ( ( ( 'derived' ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5469:1: ( ( 'derived' ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5469:1: ( ( 'derived' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5470:1: ( 'derived' )
            {
             before(grammarAccess.getEAttributeDeclAccess().getDerivedDerivedKeyword_1_7_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5471:1: ( 'derived' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5472:1: 'derived'
            {
             before(grammarAccess.getEAttributeDeclAccess().getDerivedDerivedKeyword_1_7_0()); 
            match(input,55,FollowSets000.FOLLOW_55_in_rule__EAttributeDecl__DerivedAssignment_1_710853); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5487:1: rule__EAttributeDecl__EGenericTypeAssignment_3 : ( ruleEGenericTypeReferenceDecl ) ;
    public final void rule__EAttributeDecl__EGenericTypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5491:1: ( ( ruleEGenericTypeReferenceDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5492:1: ( ruleEGenericTypeReferenceDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5492:1: ( ruleEGenericTypeReferenceDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5493:1: ruleEGenericTypeReferenceDecl
            {
             before(grammarAccess.getEAttributeDeclAccess().getEGenericTypeEGenericTypeReferenceDeclParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeReferenceDecl_in_rule__EAttributeDecl__EGenericTypeAssignment_310892);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5502:1: rule__EAttributeDecl__LowerBoundAssignment_4_1 : ( RULE_INT ) ;
    public final void rule__EAttributeDecl__LowerBoundAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5506:1: ( ( RULE_INT ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5507:1: ( RULE_INT )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5507:1: ( RULE_INT )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5508:1: RULE_INT
            {
             before(grammarAccess.getEAttributeDeclAccess().getLowerBoundINTTerminalRuleCall_4_1_0()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__EAttributeDecl__LowerBoundAssignment_4_110923); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5517:1: rule__EAttributeDecl__UpperBoundAssignment_4_2_1 : ( ruleSINT ) ;
    public final void rule__EAttributeDecl__UpperBoundAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5521:1: ( ( ruleSINT ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5522:1: ( ruleSINT )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5522:1: ( ruleSINT )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5523:1: ruleSINT
            {
             before(grammarAccess.getEAttributeDeclAccess().getUpperBoundSINTParserRuleCall_4_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSINT_in_rule__EAttributeDecl__UpperBoundAssignment_4_2_110954);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5532:1: rule__EAttributeDecl__NameAssignment_5 : ( RULE_ID ) ;
    public final void rule__EAttributeDecl__NameAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5536:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5537:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5537:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5538:1: RULE_ID
            {
             before(grammarAccess.getEAttributeDeclAccess().getNameIDTerminalRuleCall_5_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EAttributeDecl__NameAssignment_510985); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5547:1: rule__EAttributeDecl__DefaultValueLiteralAssignment_6_1 : ( RULE_STRING ) ;
    public final void rule__EAttributeDecl__DefaultValueLiteralAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5551:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5552:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5552:1: ( RULE_STRING )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5553:1: RULE_STRING
            {
             before(grammarAccess.getEAttributeDeclAccess().getDefaultValueLiteralSTRINGTerminalRuleCall_6_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__EAttributeDecl__DefaultValueLiteralAssignment_6_111016); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5562:1: rule__EReferenceDecl__EAnnotationsAssignment_0 : ( ruleEAnnotationDecl ) ;
    public final void rule__EReferenceDecl__EAnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5566:1: ( ( ruleEAnnotationDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5567:1: ( ruleEAnnotationDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5567:1: ( ruleEAnnotationDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5568:1: ruleEAnnotationDecl
            {
             before(grammarAccess.getEReferenceDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEAnnotationDecl_in_rule__EReferenceDecl__EAnnotationsAssignment_011047);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5577:1: rule__EReferenceDecl__ResolveProxiesAssignment_1_0 : ( RULE_LOCAL ) ;
    public final void rule__EReferenceDecl__ResolveProxiesAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5581:1: ( ( RULE_LOCAL ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5582:1: ( RULE_LOCAL )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5582:1: ( RULE_LOCAL )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5583:1: RULE_LOCAL
            {
             before(grammarAccess.getEReferenceDeclAccess().getResolveProxiesLocalTerminalRuleCall_1_0_0()); 
            match(input,RULE_LOCAL,FollowSets000.FOLLOW_RULE_LOCAL_in_rule__EReferenceDecl__ResolveProxiesAssignment_1_011078); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5592:1: rule__EReferenceDecl__UniqueAssignment_1_1 : ( RULE_BAG ) ;
    public final void rule__EReferenceDecl__UniqueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5596:1: ( ( RULE_BAG ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5597:1: ( RULE_BAG )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5597:1: ( RULE_BAG )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5598:1: RULE_BAG
            {
             before(grammarAccess.getEReferenceDeclAccess().getUniqueBagTerminalRuleCall_1_1_0()); 
            match(input,RULE_BAG,FollowSets000.FOLLOW_RULE_BAG_in_rule__EReferenceDecl__UniqueAssignment_1_111109); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5607:1: rule__EReferenceDecl__OrderedAssignment_1_2 : ( RULE_RANDOM ) ;
    public final void rule__EReferenceDecl__OrderedAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5611:1: ( ( RULE_RANDOM ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5612:1: ( RULE_RANDOM )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5612:1: ( RULE_RANDOM )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5613:1: RULE_RANDOM
            {
             before(grammarAccess.getEReferenceDeclAccess().getOrderedRandomTerminalRuleCall_1_2_0()); 
            match(input,RULE_RANDOM,FollowSets000.FOLLOW_RULE_RANDOM_in_rule__EReferenceDecl__OrderedAssignment_1_211140); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5622:1: rule__EReferenceDecl__ChangeableAssignment_1_3 : ( RULE_READONLY ) ;
    public final void rule__EReferenceDecl__ChangeableAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5626:1: ( ( RULE_READONLY ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5627:1: ( RULE_READONLY )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5627:1: ( RULE_READONLY )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5628:1: RULE_READONLY
            {
             before(grammarAccess.getEReferenceDeclAccess().getChangeableReadonlyTerminalRuleCall_1_3_0()); 
            match(input,RULE_READONLY,FollowSets000.FOLLOW_RULE_READONLY_in_rule__EReferenceDecl__ChangeableAssignment_1_311171); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5637:1: rule__EReferenceDecl__VolatileAssignment_1_4 : ( ( 'volatile' ) ) ;
    public final void rule__EReferenceDecl__VolatileAssignment_1_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5641:1: ( ( ( 'volatile' ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5642:1: ( ( 'volatile' ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5642:1: ( ( 'volatile' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5643:1: ( 'volatile' )
            {
             before(grammarAccess.getEReferenceDeclAccess().getVolatileVolatileKeyword_1_4_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5644:1: ( 'volatile' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5645:1: 'volatile'
            {
             before(grammarAccess.getEReferenceDeclAccess().getVolatileVolatileKeyword_1_4_0()); 
            match(input,52,FollowSets000.FOLLOW_52_in_rule__EReferenceDecl__VolatileAssignment_1_411207); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5660:1: rule__EReferenceDecl__TransientAssignment_1_5 : ( ( 'transient' ) ) ;
    public final void rule__EReferenceDecl__TransientAssignment_1_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5664:1: ( ( ( 'transient' ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5665:1: ( ( 'transient' ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5665:1: ( ( 'transient' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5666:1: ( 'transient' )
            {
             before(grammarAccess.getEReferenceDeclAccess().getTransientTransientKeyword_1_5_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5667:1: ( 'transient' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5668:1: 'transient'
            {
             before(grammarAccess.getEReferenceDeclAccess().getTransientTransientKeyword_1_5_0()); 
            match(input,53,FollowSets000.FOLLOW_53_in_rule__EReferenceDecl__TransientAssignment_1_511251); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5683:1: rule__EReferenceDecl__UnsettableAssignment_1_6 : ( ( 'unsettable' ) ) ;
    public final void rule__EReferenceDecl__UnsettableAssignment_1_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5687:1: ( ( ( 'unsettable' ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5688:1: ( ( 'unsettable' ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5688:1: ( ( 'unsettable' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5689:1: ( 'unsettable' )
            {
             before(grammarAccess.getEReferenceDeclAccess().getUnsettableUnsettableKeyword_1_6_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5690:1: ( 'unsettable' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5691:1: 'unsettable'
            {
             before(grammarAccess.getEReferenceDeclAccess().getUnsettableUnsettableKeyword_1_6_0()); 
            match(input,54,FollowSets000.FOLLOW_54_in_rule__EReferenceDecl__UnsettableAssignment_1_611295); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5706:1: rule__EReferenceDecl__DerivedAssignment_1_7 : ( ( 'derived' ) ) ;
    public final void rule__EReferenceDecl__DerivedAssignment_1_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5710:1: ( ( ( 'derived' ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5711:1: ( ( 'derived' ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5711:1: ( ( 'derived' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5712:1: ( 'derived' )
            {
             before(grammarAccess.getEReferenceDeclAccess().getDerivedDerivedKeyword_1_7_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5713:1: ( 'derived' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5714:1: 'derived'
            {
             before(grammarAccess.getEReferenceDeclAccess().getDerivedDerivedKeyword_1_7_0()); 
            match(input,55,FollowSets000.FOLLOW_55_in_rule__EReferenceDecl__DerivedAssignment_1_711339); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5729:1: rule__EReferenceDecl__ContainmentAssignment_2_0 : ( ( 'val' ) ) ;
    public final void rule__EReferenceDecl__ContainmentAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5733:1: ( ( ( 'val' ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5734:1: ( ( 'val' ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5734:1: ( ( 'val' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5735:1: ( 'val' )
            {
             before(grammarAccess.getEReferenceDeclAccess().getContainmentValKeyword_2_0_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5736:1: ( 'val' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5737:1: 'val'
            {
             before(grammarAccess.getEReferenceDeclAccess().getContainmentValKeyword_2_0_0()); 
            match(input,56,FollowSets000.FOLLOW_56_in_rule__EReferenceDecl__ContainmentAssignment_2_011383); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5752:1: rule__EReferenceDecl__EGenericTypeAssignment_3 : ( ruleEGenericTypeReferenceDecl ) ;
    public final void rule__EReferenceDecl__EGenericTypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5756:1: ( ( ruleEGenericTypeReferenceDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5757:1: ( ruleEGenericTypeReferenceDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5757:1: ( ruleEGenericTypeReferenceDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5758:1: ruleEGenericTypeReferenceDecl
            {
             before(grammarAccess.getEReferenceDeclAccess().getEGenericTypeEGenericTypeReferenceDeclParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeReferenceDecl_in_rule__EReferenceDecl__EGenericTypeAssignment_311422);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5767:1: rule__EReferenceDecl__LowerBoundAssignment_4_1 : ( RULE_INT ) ;
    public final void rule__EReferenceDecl__LowerBoundAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5771:1: ( ( RULE_INT ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5772:1: ( RULE_INT )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5772:1: ( RULE_INT )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5773:1: RULE_INT
            {
             before(grammarAccess.getEReferenceDeclAccess().getLowerBoundINTTerminalRuleCall_4_1_0()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__EReferenceDecl__LowerBoundAssignment_4_111453); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5782:1: rule__EReferenceDecl__UpperBoundAssignment_4_2_1 : ( ruleSINT ) ;
    public final void rule__EReferenceDecl__UpperBoundAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5786:1: ( ( ruleSINT ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5787:1: ( ruleSINT )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5787:1: ( ruleSINT )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5788:1: ruleSINT
            {
             before(grammarAccess.getEReferenceDeclAccess().getUpperBoundSINTParserRuleCall_4_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSINT_in_rule__EReferenceDecl__UpperBoundAssignment_4_2_111484);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5797:1: rule__EReferenceDecl__EOppositeAssignment_5_1 : ( ( RULE_ID ) ) ;
    public final void rule__EReferenceDecl__EOppositeAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5801:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5802:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5802:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5803:1: ( RULE_ID )
            {
             before(grammarAccess.getEReferenceDeclAccess().getEOppositeEReferenceCrossReference_5_1_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5804:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5805:1: RULE_ID
            {
             before(grammarAccess.getEReferenceDeclAccess().getEOppositeEReferenceIDTerminalRuleCall_5_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EReferenceDecl__EOppositeAssignment_5_111519); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5816:1: rule__EReferenceDecl__NameAssignment_6 : ( RULE_ID ) ;
    public final void rule__EReferenceDecl__NameAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5820:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5821:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5821:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5822:1: RULE_ID
            {
             before(grammarAccess.getEReferenceDeclAccess().getNameIDTerminalRuleCall_6_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EReferenceDecl__NameAssignment_611554); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5831:1: rule__EEnumDecl__EAnnotationsAssignment_0 : ( ruleEAnnotationDecl ) ;
    public final void rule__EEnumDecl__EAnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5835:1: ( ( ruleEAnnotationDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5836:1: ( ruleEAnnotationDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5836:1: ( ruleEAnnotationDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5837:1: ruleEAnnotationDecl
            {
             before(grammarAccess.getEEnumDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEAnnotationDecl_in_rule__EEnumDecl__EAnnotationsAssignment_011585);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5846:1: rule__EEnumDecl__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__EEnumDecl__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5850:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5851:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5851:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5852:1: RULE_ID
            {
             before(grammarAccess.getEEnumDeclAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EEnumDecl__NameAssignment_211616); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5861:1: rule__EEnumDecl__ELiteralsAssignment_4 : ( ruleEEnumLiteralDecl ) ;
    public final void rule__EEnumDecl__ELiteralsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5865:1: ( ( ruleEEnumLiteralDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5866:1: ( ruleEEnumLiteralDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5866:1: ( ruleEEnumLiteralDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5867:1: ruleEEnumLiteralDecl
            {
             before(grammarAccess.getEEnumDeclAccess().getELiteralsEEnumLiteralDeclParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEEnumLiteralDecl_in_rule__EEnumDecl__ELiteralsAssignment_411647);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5876:1: rule__EEnumLiteralDecl__EAnnotationsAssignment_0 : ( ruleEAnnotationDecl ) ;
    public final void rule__EEnumLiteralDecl__EAnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5880:1: ( ( ruleEAnnotationDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5881:1: ( ruleEAnnotationDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5881:1: ( ruleEAnnotationDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5882:1: ruleEAnnotationDecl
            {
             before(grammarAccess.getEEnumLiteralDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEAnnotationDecl_in_rule__EEnumLiteralDecl__EAnnotationsAssignment_011678);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5891:1: rule__EEnumLiteralDecl__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__EEnumLiteralDecl__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5895:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5896:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5896:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5897:1: RULE_ID
            {
             before(grammarAccess.getEEnumLiteralDeclAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EEnumLiteralDecl__NameAssignment_111709); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5906:1: rule__EEnumLiteralDecl__ValueAssignment_2_1 : ( RULE_INT ) ;
    public final void rule__EEnumLiteralDecl__ValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5910:1: ( ( RULE_INT ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5911:1: ( RULE_INT )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5911:1: ( RULE_INT )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5912:1: RULE_INT
            {
             before(grammarAccess.getEEnumLiteralDeclAccess().getValueINTTerminalRuleCall_2_1_0()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__EEnumLiteralDecl__ValueAssignment_2_111740); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5921:1: rule__EEnumLiteralDecl__LiteralAssignment_3 : ( RULE_STRING ) ;
    public final void rule__EEnumLiteralDecl__LiteralAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5925:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5926:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5926:1: ( RULE_STRING )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5927:1: RULE_STRING
            {
             before(grammarAccess.getEEnumLiteralDeclAccess().getLiteralSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__EEnumLiteralDecl__LiteralAssignment_311771); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5936:1: rule__ETypeParameterDecl__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__ETypeParameterDecl__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5940:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5941:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5941:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5942:1: RULE_ID
            {
             before(grammarAccess.getETypeParameterDeclAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ETypeParameterDecl__NameAssignment_011802); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5951:1: rule__ETypeParameterDecl__EBoundsAssignment_1_1 : ( ruleEGenericTypeDecl ) ;
    public final void rule__ETypeParameterDecl__EBoundsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5955:1: ( ( ruleEGenericTypeDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5956:1: ( ruleEGenericTypeDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5956:1: ( ruleEGenericTypeDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5957:1: ruleEGenericTypeDecl
            {
             before(grammarAccess.getETypeParameterDeclAccess().getEBoundsEGenericTypeDeclParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeDecl_in_rule__ETypeParameterDecl__EBoundsAssignment_1_111833);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5966:1: rule__EGenericTypeReferenceDecl__EClassifierAssignment_0_0 : ( ( RULE_ID ) ) ;
    public final void rule__EGenericTypeReferenceDecl__EClassifierAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5970:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5971:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5971:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5972:1: ( RULE_ID )
            {
             before(grammarAccess.getEGenericTypeReferenceDeclAccess().getEClassifierEClassifierCrossReference_0_0_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5973:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5974:1: RULE_ID
            {
             before(grammarAccess.getEGenericTypeReferenceDeclAccess().getEClassifierEClassifierIDTerminalRuleCall_0_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EGenericTypeReferenceDecl__EClassifierAssignment_0_011868); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5985:1: rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_1 : ( ruleEGenericTypeDecl ) ;
    public final void rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5989:1: ( ( ruleEGenericTypeDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5990:1: ( ruleEGenericTypeDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5990:1: ( ruleEGenericTypeDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:5991:1: ruleEGenericTypeDecl
            {
             before(grammarAccess.getEGenericTypeReferenceDeclAccess().getETypeArgumentsEGenericTypeDeclParserRuleCall_0_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeDecl_in_rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_111903);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6000:1: rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_2_1 : ( ruleEGenericTypeDecl ) ;
    public final void rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6004:1: ( ( ruleEGenericTypeDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6005:1: ( ruleEGenericTypeDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6005:1: ( ruleEGenericTypeDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6006:1: ruleEGenericTypeDecl
            {
             before(grammarAccess.getEGenericTypeReferenceDeclAccess().getETypeArgumentsEGenericTypeDeclParserRuleCall_0_1_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeDecl_in_rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_2_111934);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6015:1: rule__EGenericTypeReferenceDecl__ETypeParameterAssignment_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__EGenericTypeReferenceDecl__ETypeParameterAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6019:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6020:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6020:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6021:1: ( RULE_ID )
            {
             before(grammarAccess.getEGenericTypeReferenceDeclAccess().getETypeParameterETypeParameterCrossReference_1_1_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6022:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6023:1: RULE_ID
            {
             before(grammarAccess.getEGenericTypeReferenceDeclAccess().getETypeParameterETypeParameterIDTerminalRuleCall_1_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EGenericTypeReferenceDecl__ETypeParameterAssignment_1_111969); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6034:1: rule__EGenericTypeDecl__EClassifierAssignment_0_0 : ( ( RULE_ID ) ) ;
    public final void rule__EGenericTypeDecl__EClassifierAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6038:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6039:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6039:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6040:1: ( RULE_ID )
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getEClassifierEClassifierCrossReference_0_0_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6041:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6042:1: RULE_ID
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getEClassifierEClassifierIDTerminalRuleCall_0_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EGenericTypeDecl__EClassifierAssignment_0_012008); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6053:1: rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_1 : ( ruleEGenericTypeDecl ) ;
    public final void rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6057:1: ( ( ruleEGenericTypeDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6058:1: ( ruleEGenericTypeDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6058:1: ( ruleEGenericTypeDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6059:1: ruleEGenericTypeDecl
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getETypeArgumentsEGenericTypeDeclParserRuleCall_0_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeDecl_in_rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_112043);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6068:1: rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_2_1 : ( ruleEGenericTypeDecl ) ;
    public final void rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6072:1: ( ( ruleEGenericTypeDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6073:1: ( ruleEGenericTypeDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6073:1: ( ruleEGenericTypeDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6074:1: ruleEGenericTypeDecl
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getETypeArgumentsEGenericTypeDeclParserRuleCall_0_1_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeDecl_in_rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_2_112074);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6083:1: rule__EGenericTypeDecl__ETypeParameterAssignment_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__EGenericTypeDecl__ETypeParameterAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6087:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6088:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6088:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6089:1: ( RULE_ID )
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getETypeParameterETypeParameterCrossReference_1_1_0()); 
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6090:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6091:1: RULE_ID
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getETypeParameterETypeParameterIDTerminalRuleCall_1_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EGenericTypeDecl__ETypeParameterAssignment_1_112109); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6102:1: rule__EGenericTypeDecl__EUpperBoundAssignment_2_1_0_1 : ( ruleEGenericTypeDecl ) ;
    public final void rule__EGenericTypeDecl__EUpperBoundAssignment_2_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6106:1: ( ( ruleEGenericTypeDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6107:1: ( ruleEGenericTypeDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6107:1: ( ruleEGenericTypeDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6108:1: ruleEGenericTypeDecl
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getEUpperBoundEGenericTypeDeclParserRuleCall_2_1_0_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeDecl_in_rule__EGenericTypeDecl__EUpperBoundAssignment_2_1_0_112144);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6117:1: rule__EGenericTypeDecl__ELowerBoundAssignment_2_1_1_1 : ( ruleEGenericTypeDecl ) ;
    public final void rule__EGenericTypeDecl__ELowerBoundAssignment_2_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6121:1: ( ( ruleEGenericTypeDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6122:1: ( ruleEGenericTypeDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6122:1: ( ruleEGenericTypeDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6123:1: ruleEGenericTypeDecl
            {
             before(grammarAccess.getEGenericTypeDeclAccess().getELowerBoundEGenericTypeDeclParserRuleCall_2_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeDecl_in_rule__EGenericTypeDecl__ELowerBoundAssignment_2_1_1_112175);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6132:1: rule__EOperationDecl__EAnnotationsAssignment_0 : ( ruleEAnnotationDecl ) ;
    public final void rule__EOperationDecl__EAnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6136:1: ( ( ruleEAnnotationDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6137:1: ( ruleEAnnotationDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6137:1: ( ruleEAnnotationDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6138:1: ruleEAnnotationDecl
            {
             before(grammarAccess.getEOperationDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEAnnotationDecl_in_rule__EOperationDecl__EAnnotationsAssignment_012206);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6147:1: rule__EOperationDecl__UniqueAssignment_1_0 : ( RULE_BAG ) ;
    public final void rule__EOperationDecl__UniqueAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6151:1: ( ( RULE_BAG ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6152:1: ( RULE_BAG )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6152:1: ( RULE_BAG )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6153:1: RULE_BAG
            {
             before(grammarAccess.getEOperationDeclAccess().getUniqueBagTerminalRuleCall_1_0_0()); 
            match(input,RULE_BAG,FollowSets000.FOLLOW_RULE_BAG_in_rule__EOperationDecl__UniqueAssignment_1_012237); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6162:1: rule__EOperationDecl__OrderedAssignment_1_1 : ( RULE_RANDOM ) ;
    public final void rule__EOperationDecl__OrderedAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6166:1: ( ( RULE_RANDOM ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6167:1: ( RULE_RANDOM )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6167:1: ( RULE_RANDOM )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6168:1: RULE_RANDOM
            {
             before(grammarAccess.getEOperationDeclAccess().getOrderedRandomTerminalRuleCall_1_1_0()); 
            match(input,RULE_RANDOM,FollowSets000.FOLLOW_RULE_RANDOM_in_rule__EOperationDecl__OrderedAssignment_1_112268); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6177:1: rule__EOperationDecl__EGenericTypeAssignment_3_0 : ( ruleEGenericTypeReferenceDecl ) ;
    public final void rule__EOperationDecl__EGenericTypeAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6181:1: ( ( ruleEGenericTypeReferenceDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6182:1: ( ruleEGenericTypeReferenceDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6182:1: ( ruleEGenericTypeReferenceDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6183:1: ruleEGenericTypeReferenceDecl
            {
             before(grammarAccess.getEOperationDeclAccess().getEGenericTypeEGenericTypeReferenceDeclParserRuleCall_3_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeReferenceDecl_in_rule__EOperationDecl__EGenericTypeAssignment_3_012299);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6192:1: rule__EOperationDecl__NameAssignment_4 : ( RULE_ID ) ;
    public final void rule__EOperationDecl__NameAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6196:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6197:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6197:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6198:1: RULE_ID
            {
             before(grammarAccess.getEOperationDeclAccess().getNameIDTerminalRuleCall_4_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EOperationDecl__NameAssignment_412330); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6207:1: rule__EOperationDecl__ETypeParametersAssignment_5_1 : ( ruleETypeParameterDecl ) ;
    public final void rule__EOperationDecl__ETypeParametersAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6211:1: ( ( ruleETypeParameterDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6212:1: ( ruleETypeParameterDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6212:1: ( ruleETypeParameterDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6213:1: ruleETypeParameterDecl
            {
             before(grammarAccess.getEOperationDeclAccess().getETypeParametersETypeParameterDeclParserRuleCall_5_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleETypeParameterDecl_in_rule__EOperationDecl__ETypeParametersAssignment_5_112361);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6222:1: rule__EOperationDecl__ETypeParametersAssignment_5_2_1 : ( ruleETypeParameterDecl ) ;
    public final void rule__EOperationDecl__ETypeParametersAssignment_5_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6226:1: ( ( ruleETypeParameterDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6227:1: ( ruleETypeParameterDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6227:1: ( ruleETypeParameterDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6228:1: ruleETypeParameterDecl
            {
             before(grammarAccess.getEOperationDeclAccess().getETypeParametersETypeParameterDeclParserRuleCall_5_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleETypeParameterDecl_in_rule__EOperationDecl__ETypeParametersAssignment_5_2_112392);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6237:1: rule__EOperationDecl__EParametersAssignment_7_0 : ( ruleEParameterDecl ) ;
    public final void rule__EOperationDecl__EParametersAssignment_7_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6241:1: ( ( ruleEParameterDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6242:1: ( ruleEParameterDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6242:1: ( ruleEParameterDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6243:1: ruleEParameterDecl
            {
             before(grammarAccess.getEOperationDeclAccess().getEParametersEParameterDeclParserRuleCall_7_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEParameterDecl_in_rule__EOperationDecl__EParametersAssignment_7_012423);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6252:1: rule__EOperationDecl__EParametersAssignment_7_1_1 : ( ruleEParameterDecl ) ;
    public final void rule__EOperationDecl__EParametersAssignment_7_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6256:1: ( ( ruleEParameterDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6257:1: ( ruleEParameterDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6257:1: ( ruleEParameterDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6258:1: ruleEParameterDecl
            {
             before(grammarAccess.getEOperationDeclAccess().getEParametersEParameterDeclParserRuleCall_7_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEParameterDecl_in_rule__EOperationDecl__EParametersAssignment_7_1_112454);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6267:1: rule__EOperationDecl__EGenericExceptionsAssignment_9_1 : ( ruleEGenericTypeReferenceDecl ) ;
    public final void rule__EOperationDecl__EGenericExceptionsAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6271:1: ( ( ruleEGenericTypeReferenceDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6272:1: ( ruleEGenericTypeReferenceDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6272:1: ( ruleEGenericTypeReferenceDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6273:1: ruleEGenericTypeReferenceDecl
            {
             before(grammarAccess.getEOperationDeclAccess().getEGenericExceptionsEGenericTypeReferenceDeclParserRuleCall_9_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeReferenceDecl_in_rule__EOperationDecl__EGenericExceptionsAssignment_9_112485);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6282:1: rule__EOperationDecl__EGenericExceptionsAssignment_9_2_1 : ( ruleEGenericTypeReferenceDecl ) ;
    public final void rule__EOperationDecl__EGenericExceptionsAssignment_9_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6286:1: ( ( ruleEGenericTypeReferenceDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6287:1: ( ruleEGenericTypeReferenceDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6287:1: ( ruleEGenericTypeReferenceDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6288:1: ruleEGenericTypeReferenceDecl
            {
             before(grammarAccess.getEOperationDeclAccess().getEGenericExceptionsEGenericTypeReferenceDeclParserRuleCall_9_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeReferenceDecl_in_rule__EOperationDecl__EGenericExceptionsAssignment_9_2_112516);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6297:1: rule__EParameterDecl__EAnnotationsAssignment_0 : ( ruleEAnnotationDecl ) ;
    public final void rule__EParameterDecl__EAnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6301:1: ( ( ruleEAnnotationDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6302:1: ( ruleEAnnotationDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6302:1: ( ruleEAnnotationDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6303:1: ruleEAnnotationDecl
            {
             before(grammarAccess.getEParameterDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEAnnotationDecl_in_rule__EParameterDecl__EAnnotationsAssignment_012547);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6312:1: rule__EParameterDecl__EGenericTypeAssignment_1 : ( ruleEGenericTypeReferenceDecl ) ;
    public final void rule__EParameterDecl__EGenericTypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6316:1: ( ( ruleEGenericTypeReferenceDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6317:1: ( ruleEGenericTypeReferenceDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6317:1: ( ruleEGenericTypeReferenceDecl )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6318:1: ruleEGenericTypeReferenceDecl
            {
             before(grammarAccess.getEParameterDeclAccess().getEGenericTypeEGenericTypeReferenceDeclParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeReferenceDecl_in_rule__EParameterDecl__EGenericTypeAssignment_112578);
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6327:1: rule__EParameterDecl__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__EParameterDecl__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6331:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6332:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6332:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6333:1: RULE_ID
            {
             before(grammarAccess.getEParameterDeclAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EParameterDecl__NameAssignment_212609); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6342:1: rule__MapEntry__KeyAssignment_0 : ( RULE_ID ) ;
    public final void rule__MapEntry__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6346:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6347:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6347:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6348:1: RULE_ID
            {
             before(grammarAccess.getMapEntryAccess().getKeyIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__MapEntry__KeyAssignment_012640); 
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
    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6357:1: rule__MapEntry__ValueAssignment_2 : ( RULE_STRING ) ;
    public final void rule__MapEntry__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6361:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6362:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6362:1: ( RULE_STRING )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalEcoreDsl.g:6363:1: RULE_STRING
            {
             before(grammarAccess.getMapEntryAccess().getValueSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__MapEntry__ValueAssignment_212671); 
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
            return "676:1: rule__EPackageDecl__Alternatives_10 : ( ( ( rule__EPackageDecl__ESubpackagesAssignment_10_0 ) ) | ( ( rule__EPackageDecl__EClassifiersAssignment_10_1 ) ) );";
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
            return "698:1: rule__SubEPackageDecl__Alternatives_4 : ( ( ( rule__SubEPackageDecl__ESubpackagesAssignment_4_0 ) ) | ( ( rule__SubEPackageDecl__EClassifiersAssignment_4_1 ) ) );";
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
            return "720:1: rule__EClassifierDecl__Alternatives : ( ( ruleEClassDecl ) | ( ruleEDataTypeDecl ) );";
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
            return "742:1: rule__EDataTypeDecl__Alternatives : ( ( ( rule__EDataTypeDecl__Group_0__0 ) ) | ( ruleEEnumDecl ) );";
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
            return "788:1: rule__EClassDecl__Alternatives_8 : ( ( ( rule__EClassDecl__EStructuralFeaturesAssignment_8_0 ) ) | ( ( rule__EClassDecl__EOperationsAssignment_8_1 ) ) );";
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
            return "810:1: rule__EStructuralFeatureDecl__Alternatives : ( ( ruleEAttributeDecl ) | ( ruleEReferenceDecl ) );";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleEcoreDsl_in_entryRuleEcoreDsl61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEcoreDsl68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EcoreDsl__Group__0_in_ruleEcoreDsl94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferencedMetamodel128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group__0_in_ruleReferencedMetamodel154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEPackageDecl_in_entryRuleEPackageDecl181 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEPackageDecl188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EPackageDecl__Group__0_in_ruleEPackageDecl214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubEPackageDecl_in_entryRuleSubEPackageDecl241 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSubEPackageDecl248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SubEPackageDecl__Group__0_in_ruleSubEPackageDecl274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEClassifierDecl_in_entryRuleEClassifierDecl301 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEClassifierDecl308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EClassifierDecl__Alternatives_in_ruleEClassifierDecl334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEDataTypeDecl_in_entryRuleEDataTypeDecl361 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEDataTypeDecl368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EDataTypeDecl__Alternatives_in_ruleEDataTypeDecl394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAnnotationDecl_in_entryRuleEAnnotationDecl421 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEAnnotationDecl428 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EAnnotationDecl__Group__0_in_ruleEAnnotationDecl454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEClassDecl_in_entryRuleEClassDecl481 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEClassDecl488 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EClassDecl__Group__0_in_ruleEClassDecl514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEStructuralFeatureDecl_in_entryRuleEStructuralFeatureDecl541 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEStructuralFeatureDecl548 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EStructuralFeatureDecl__Alternatives_in_ruleEStructuralFeatureDecl574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAttributeDecl_in_entryRuleEAttributeDecl601 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEAttributeDecl608 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EAttributeDecl__Group__0_in_ruleEAttributeDecl634 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEReferenceDecl_in_entryRuleEReferenceDecl661 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEReferenceDecl668 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EReferenceDecl__Group__0_in_ruleEReferenceDecl694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEEnumDecl_in_entryRuleEEnumDecl721 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEEnumDecl728 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EEnumDecl__Group__0_in_ruleEEnumDecl754 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEEnumLiteralDecl_in_entryRuleEEnumLiteralDecl781 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEEnumLiteralDecl788 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EEnumLiteralDecl__Group__0_in_ruleEEnumLiteralDecl814 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleETypeParameterDecl_in_entryRuleETypeParameterDecl841 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleETypeParameterDecl848 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ETypeParameterDecl__Group__0_in_ruleETypeParameterDecl874 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_entryRuleEGenericTypeReferenceDecl901 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEGenericTypeReferenceDecl908 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EGenericTypeReferenceDecl__Alternatives_in_ruleEGenericTypeReferenceDecl934 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_entryRuleEGenericTypeDecl961 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEGenericTypeDecl968 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EGenericTypeDecl__Alternatives_in_ruleEGenericTypeDecl994 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEOperationDecl_in_entryRuleEOperationDecl1021 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEOperationDecl1028 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EOperationDecl__Group__0_in_ruleEOperationDecl1054 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEParameterDecl_in_entryRuleEParameterDecl1081 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEParameterDecl1088 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EParameterDecl__Group__0_in_ruleEParameterDecl1114 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapEntry_in_entryRuleMapEntry1141 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMapEntry1148 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MapEntry__Group__0_in_ruleMapEntry1174 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQID_in_entryRuleQID1201 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQID1208 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QID__Group__0_in_ruleQID1234 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSTRING_OR_QID_in_entryRuleSTRING_OR_QID1261 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSTRING_OR_QID1268 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__STRING_OR_QID__Alternatives_in_ruleSTRING_OR_QID1294 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSINT_in_entryRuleSINT1321 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSINT1328 = new BitSet(new long[]{0x0000000000000002L});
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
        public static final BitSet FOLLOW_ruleReferencedMetamodel_in_rule__EcoreDsl__MetamodelDeclarationsAssignment_09522 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEPackageDecl_in_rule__EcoreDsl__PackageAssignment_19553 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ReferencedMetamodel__AliasAssignment_1_09584 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__ReferencedMetamodel__EPackageAssignment_29619 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAnnotationDecl_in_rule__EPackageDecl__EAnnotationsAssignment_09654 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQID_in_rule__EPackageDecl__NameAssignment_29685 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__EPackageDecl__NsURIAssignment_59716 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQID_in_rule__EPackageDecl__NsPrefixAssignment_89747 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubEPackageDecl_in_rule__EPackageDecl__ESubpackagesAssignment_10_09778 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEClassifierDecl_in_rule__EPackageDecl__EClassifiersAssignment_10_19809 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAnnotationDecl_in_rule__SubEPackageDecl__EAnnotationsAssignment_09840 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__SubEPackageDecl__NameAssignment_29871 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubEPackageDecl_in_rule__SubEPackageDecl__ESubpackagesAssignment_4_09902 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEClassifierDecl_in_rule__SubEPackageDecl__EClassifiersAssignment_4_19933 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAnnotationDecl_in_rule__EDataTypeDecl__EAnnotationsAssignment_0_09964 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SERIALIZABLE_in_rule__EDataTypeDecl__SerializableAssignment_0_19995 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EDataTypeDecl__NameAssignment_0_2_110026 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSTRING_OR_QID_in_rule__EDataTypeDecl__InstanceClassNameAssignment_0_2_310057 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSTRING_OR_QID_in_rule__EAnnotationDecl__SourceAssignment_110088 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapEntry_in_rule__EAnnotationDecl__DetailsAssignment_2_110119 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapEntry_in_rule__EAnnotationDecl__DetailsAssignment_2_2_110150 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAnnotationDecl_in_rule__EClassDecl__EAnnotationsAssignment_010181 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_rule__EClassDecl__AbstractAssignment_110217 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_rule__EClassDecl__InterfaceAssignment_2_010261 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EClassDecl__NameAssignment_310300 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleETypeParameterDecl_in_rule__EClassDecl__ETypeParametersAssignment_4_110331 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleETypeParameterDecl_in_rule__EClassDecl__ETypeParametersAssignment_4_2_110362 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_rule__EClassDecl__EGenericSuperTypesAssignment_5_110393 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_rule__EClassDecl__EGenericSuperTypesAssignment_5_2_110424 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSTRING_OR_QID_in_rule__EClassDecl__InstanceClassNameAssignment_6_110455 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEStructuralFeatureDecl_in_rule__EClassDecl__EStructuralFeaturesAssignment_8_010486 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEOperationDecl_in_rule__EClassDecl__EOperationsAssignment_8_110517 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAnnotationDecl_in_rule__EAttributeDecl__EAnnotationsAssignment_010548 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_rule__EAttributeDecl__IDAssignment_1_010584 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_BAG_in_rule__EAttributeDecl__UniqueAssignment_1_110623 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_RANDOM_in_rule__EAttributeDecl__OrderedAssignment_1_210654 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_READONLY_in_rule__EAttributeDecl__ChangeableAssignment_1_310685 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_rule__EAttributeDecl__VolatileAssignment_1_410721 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_rule__EAttributeDecl__TransientAssignment_1_510765 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_rule__EAttributeDecl__UnsettableAssignment_1_610809 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_rule__EAttributeDecl__DerivedAssignment_1_710853 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_rule__EAttributeDecl__EGenericTypeAssignment_310892 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__EAttributeDecl__LowerBoundAssignment_4_110923 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSINT_in_rule__EAttributeDecl__UpperBoundAssignment_4_2_110954 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EAttributeDecl__NameAssignment_510985 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__EAttributeDecl__DefaultValueLiteralAssignment_6_111016 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAnnotationDecl_in_rule__EReferenceDecl__EAnnotationsAssignment_011047 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LOCAL_in_rule__EReferenceDecl__ResolveProxiesAssignment_1_011078 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_BAG_in_rule__EReferenceDecl__UniqueAssignment_1_111109 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_RANDOM_in_rule__EReferenceDecl__OrderedAssignment_1_211140 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_READONLY_in_rule__EReferenceDecl__ChangeableAssignment_1_311171 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_rule__EReferenceDecl__VolatileAssignment_1_411207 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_rule__EReferenceDecl__TransientAssignment_1_511251 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_rule__EReferenceDecl__UnsettableAssignment_1_611295 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_rule__EReferenceDecl__DerivedAssignment_1_711339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_rule__EReferenceDecl__ContainmentAssignment_2_011383 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_rule__EReferenceDecl__EGenericTypeAssignment_311422 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__EReferenceDecl__LowerBoundAssignment_4_111453 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSINT_in_rule__EReferenceDecl__UpperBoundAssignment_4_2_111484 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EReferenceDecl__EOppositeAssignment_5_111519 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EReferenceDecl__NameAssignment_611554 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAnnotationDecl_in_rule__EEnumDecl__EAnnotationsAssignment_011585 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EEnumDecl__NameAssignment_211616 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEEnumLiteralDecl_in_rule__EEnumDecl__ELiteralsAssignment_411647 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAnnotationDecl_in_rule__EEnumLiteralDecl__EAnnotationsAssignment_011678 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EEnumLiteralDecl__NameAssignment_111709 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__EEnumLiteralDecl__ValueAssignment_2_111740 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__EEnumLiteralDecl__LiteralAssignment_311771 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ETypeParameterDecl__NameAssignment_011802 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_rule__ETypeParameterDecl__EBoundsAssignment_1_111833 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EGenericTypeReferenceDecl__EClassifierAssignment_0_011868 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_111903 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_rule__EGenericTypeReferenceDecl__ETypeArgumentsAssignment_0_1_2_111934 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EGenericTypeReferenceDecl__ETypeParameterAssignment_1_111969 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EGenericTypeDecl__EClassifierAssignment_0_012008 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_112043 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_rule__EGenericTypeDecl__ETypeArgumentsAssignment_0_1_2_112074 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EGenericTypeDecl__ETypeParameterAssignment_1_112109 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_rule__EGenericTypeDecl__EUpperBoundAssignment_2_1_0_112144 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_rule__EGenericTypeDecl__ELowerBoundAssignment_2_1_1_112175 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAnnotationDecl_in_rule__EOperationDecl__EAnnotationsAssignment_012206 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_BAG_in_rule__EOperationDecl__UniqueAssignment_1_012237 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_RANDOM_in_rule__EOperationDecl__OrderedAssignment_1_112268 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_rule__EOperationDecl__EGenericTypeAssignment_3_012299 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EOperationDecl__NameAssignment_412330 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleETypeParameterDecl_in_rule__EOperationDecl__ETypeParametersAssignment_5_112361 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleETypeParameterDecl_in_rule__EOperationDecl__ETypeParametersAssignment_5_2_112392 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEParameterDecl_in_rule__EOperationDecl__EParametersAssignment_7_012423 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEParameterDecl_in_rule__EOperationDecl__EParametersAssignment_7_1_112454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_rule__EOperationDecl__EGenericExceptionsAssignment_9_112485 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_rule__EOperationDecl__EGenericExceptionsAssignment_9_2_112516 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAnnotationDecl_in_rule__EParameterDecl__EAnnotationsAssignment_012547 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_rule__EParameterDecl__EGenericTypeAssignment_112578 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EParameterDecl__NameAssignment_212609 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__MapEntry__KeyAssignment_012640 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__MapEntry__ValueAssignment_212671 = new BitSet(new long[]{0x0000000000000002L});
    }


}
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'?'", "'*'", "'+'", "'='", "'+='", "'?='", "'grammar'", "'with'", "','", "'('", "')'", "'.'", "'generate'", "'as'", "'import'", "':'", "';'", "'returns'", "'::'", "'|'", "'&'", "'{'", "'}'", "'current'", "'['", "']'", "'terminal'", "'!'", "'->'", "'..'", "'enum'", "'hidden'", "'fragment'"
    };
    public static final int T__42=42;
    public static final int T__12=12;
    public static final int T__28=28;
    public static final int T__23=23;
    public static final int T__13=13;
    public static final int RULE_STRING=5;
    public static final int T__21=21;
    public static final int T__19=19;
    public static final int T__39=39;
    public static final int T__30=30;
    public static final int T__17=17;
    public static final int RULE_INT=6;
    public static final int T__27=27;
    public static final int T__24=24;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__35=35;
    public static final int RULE_ID=4;
    public static final int T__36=36;
    public static final int T__20=20;
    public static final int T__14=14;
    public static final int T__33=33;
    public static final int T__22=22;
    public static final int T__11=11;
    public static final int T__29=29;
    public static final int RULE_WS=9;
    public static final int T__43=43;
    public static final int T__31=31;
    public static final int T__40=40;
    public static final int EOF=-1;
    public static final int T__16=16;
    public static final int T__32=32;
    public static final int T__38=38;
    public static final int T__37=37;
    public static final int T__26=26;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__25=25;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__41=41;
    public static final int T__18=18;

    // delegates
    // delegators


        public InternalXtextParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalXtextParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalXtextParser.tokenNames; }
    public String getGrammarFileName() { return "../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g"; }


     
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




    // $ANTLR start "entryRuleGrammar"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:61:1: entryRuleGrammar : ruleGrammar EOF ;
    public final void entryRuleGrammar() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:62:1: ( ruleGrammar EOF )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:63:1: ruleGrammar EOF
            {
             before(grammarAccess.getGrammarRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleGrammar_in_entryRuleGrammar61);
            ruleGrammar();

            state._fsp--;

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
    // $ANTLR end "entryRuleGrammar"


    // $ANTLR start "ruleGrammar"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:70:1: ruleGrammar : ( ( rule__Grammar__Group__0 ) ) ;
    public final void ruleGrammar() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:74:2: ( ( ( rule__Grammar__Group__0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:75:1: ( ( rule__Grammar__Group__0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:75:1: ( ( rule__Grammar__Group__0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:76:1: ( rule__Grammar__Group__0 )
            {
             before(grammarAccess.getGrammarAccess().getGroup()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:77:1: ( rule__Grammar__Group__0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:77:2: rule__Grammar__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__0_in_ruleGrammar94);
            rule__Grammar__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleGrammar"


    // $ANTLR start "entryRuleGrammarID"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:89:1: entryRuleGrammarID : ruleGrammarID EOF ;
    public final void entryRuleGrammarID() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:90:1: ( ruleGrammarID EOF )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:91:1: ruleGrammarID EOF
            {
             before(grammarAccess.getGrammarIDRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_entryRuleGrammarID121);
            ruleGrammarID();

            state._fsp--;

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
    // $ANTLR end "entryRuleGrammarID"


    // $ANTLR start "ruleGrammarID"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:98:1: ruleGrammarID : ( ( rule__GrammarID__Group__0 ) ) ;
    public final void ruleGrammarID() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:102:2: ( ( ( rule__GrammarID__Group__0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:103:1: ( ( rule__GrammarID__Group__0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:103:1: ( ( rule__GrammarID__Group__0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:104:1: ( rule__GrammarID__Group__0 )
            {
             before(grammarAccess.getGrammarIDAccess().getGroup()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:105:1: ( rule__GrammarID__Group__0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:105:2: rule__GrammarID__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__GrammarID__Group__0_in_ruleGrammarID154);
            rule__GrammarID__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleGrammarID"


    // $ANTLR start "entryRuleAbstractRule"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:117:1: entryRuleAbstractRule : ruleAbstractRule EOF ;
    public final void entryRuleAbstractRule() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:118:1: ( ruleAbstractRule EOF )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:119:1: ruleAbstractRule EOF
            {
             before(grammarAccess.getAbstractRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule181);
            ruleAbstractRule();

            state._fsp--;

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
    // $ANTLR end "entryRuleAbstractRule"


    // $ANTLR start "ruleAbstractRule"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:126:1: ruleAbstractRule : ( ( rule__AbstractRule__Alternatives ) ) ;
    public final void ruleAbstractRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:130:2: ( ( ( rule__AbstractRule__Alternatives ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:131:1: ( ( rule__AbstractRule__Alternatives ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:131:1: ( ( rule__AbstractRule__Alternatives ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:132:1: ( rule__AbstractRule__Alternatives )
            {
             before(grammarAccess.getAbstractRuleAccess().getAlternatives()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:133:1: ( rule__AbstractRule__Alternatives )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:133:2: rule__AbstractRule__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractRule__Alternatives_in_ruleAbstractRule214);
            rule__AbstractRule__Alternatives();

            state._fsp--;


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
    // $ANTLR end "ruleAbstractRule"


    // $ANTLR start "entryRuleAbstractMetamodelDeclaration"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:145:1: entryRuleAbstractMetamodelDeclaration : ruleAbstractMetamodelDeclaration EOF ;
    public final void entryRuleAbstractMetamodelDeclaration() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:146:1: ( ruleAbstractMetamodelDeclaration EOF )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:147:1: ruleAbstractMetamodelDeclaration EOF
            {
             before(grammarAccess.getAbstractMetamodelDeclarationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration241);
            ruleAbstractMetamodelDeclaration();

            state._fsp--;

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
    // $ANTLR end "entryRuleAbstractMetamodelDeclaration"


    // $ANTLR start "ruleAbstractMetamodelDeclaration"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:154:1: ruleAbstractMetamodelDeclaration : ( ( rule__AbstractMetamodelDeclaration__Alternatives ) ) ;
    public final void ruleAbstractMetamodelDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:158:2: ( ( ( rule__AbstractMetamodelDeclaration__Alternatives ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:159:1: ( ( rule__AbstractMetamodelDeclaration__Alternatives ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:159:1: ( ( rule__AbstractMetamodelDeclaration__Alternatives ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:160:1: ( rule__AbstractMetamodelDeclaration__Alternatives )
            {
             before(grammarAccess.getAbstractMetamodelDeclarationAccess().getAlternatives()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:161:1: ( rule__AbstractMetamodelDeclaration__Alternatives )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:161:2: rule__AbstractMetamodelDeclaration__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractMetamodelDeclaration__Alternatives_in_ruleAbstractMetamodelDeclaration274);
            rule__AbstractMetamodelDeclaration__Alternatives();

            state._fsp--;


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
    // $ANTLR end "ruleAbstractMetamodelDeclaration"


    // $ANTLR start "entryRuleGeneratedMetamodel"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:173:1: entryRuleGeneratedMetamodel : ruleGeneratedMetamodel EOF ;
    public final void entryRuleGeneratedMetamodel() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:174:1: ( ruleGeneratedMetamodel EOF )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:175:1: ruleGeneratedMetamodel EOF
            {
             before(grammarAccess.getGeneratedMetamodelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel301);
            ruleGeneratedMetamodel();

            state._fsp--;

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
    // $ANTLR end "entryRuleGeneratedMetamodel"


    // $ANTLR start "ruleGeneratedMetamodel"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:182:1: ruleGeneratedMetamodel : ( ( rule__GeneratedMetamodel__Group__0 ) ) ;
    public final void ruleGeneratedMetamodel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:186:2: ( ( ( rule__GeneratedMetamodel__Group__0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:187:1: ( ( rule__GeneratedMetamodel__Group__0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:187:1: ( ( rule__GeneratedMetamodel__Group__0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:188:1: ( rule__GeneratedMetamodel__Group__0 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getGroup()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:189:1: ( rule__GeneratedMetamodel__Group__0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:189:2: rule__GeneratedMetamodel__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group__0_in_ruleGeneratedMetamodel334);
            rule__GeneratedMetamodel__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleGeneratedMetamodel"


    // $ANTLR start "entryRuleReferencedMetamodel"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:201:1: entryRuleReferencedMetamodel : ruleReferencedMetamodel EOF ;
    public final void entryRuleReferencedMetamodel() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:202:1: ( ruleReferencedMetamodel EOF )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:203:1: ruleReferencedMetamodel EOF
            {
             before(grammarAccess.getReferencedMetamodelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel361);
            ruleReferencedMetamodel();

            state._fsp--;

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
    // $ANTLR end "entryRuleReferencedMetamodel"


    // $ANTLR start "ruleReferencedMetamodel"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:210:1: ruleReferencedMetamodel : ( ( rule__ReferencedMetamodel__Group__0 ) ) ;
    public final void ruleReferencedMetamodel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:214:2: ( ( ( rule__ReferencedMetamodel__Group__0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:215:1: ( ( rule__ReferencedMetamodel__Group__0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:215:1: ( ( rule__ReferencedMetamodel__Group__0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:216:1: ( rule__ReferencedMetamodel__Group__0 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getGroup()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:217:1: ( rule__ReferencedMetamodel__Group__0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:217:2: rule__ReferencedMetamodel__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group__0_in_ruleReferencedMetamodel394);
            rule__ReferencedMetamodel__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleReferencedMetamodel"


    // $ANTLR start "entryRuleParserRule"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:229:1: entryRuleParserRule : ruleParserRule EOF ;
    public final void entryRuleParserRule() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:230:1: ( ruleParserRule EOF )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:231:1: ruleParserRule EOF
            {
             before(grammarAccess.getParserRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParserRule_in_entryRuleParserRule421);
            ruleParserRule();

            state._fsp--;

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
    // $ANTLR end "entryRuleParserRule"


    // $ANTLR start "ruleParserRule"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:238:1: ruleParserRule : ( ( rule__ParserRule__Group__0 ) ) ;
    public final void ruleParserRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:242:2: ( ( ( rule__ParserRule__Group__0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:243:1: ( ( rule__ParserRule__Group__0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:243:1: ( ( rule__ParserRule__Group__0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:244:1: ( rule__ParserRule__Group__0 )
            {
             before(grammarAccess.getParserRuleAccess().getGroup()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:245:1: ( rule__ParserRule__Group__0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:245:2: rule__ParserRule__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__0_in_ruleParserRule454);
            rule__ParserRule__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleParserRule"


    // $ANTLR start "entryRuleTypeRef"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:257:1: entryRuleTypeRef : ruleTypeRef EOF ;
    public final void entryRuleTypeRef() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:258:1: ( ruleTypeRef EOF )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:259:1: ruleTypeRef EOF
            {
             before(grammarAccess.getTypeRefRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_entryRuleTypeRef481);
            ruleTypeRef();

            state._fsp--;

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
    // $ANTLR end "entryRuleTypeRef"


    // $ANTLR start "ruleTypeRef"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:266:1: ruleTypeRef : ( ( rule__TypeRef__Group__0 ) ) ;
    public final void ruleTypeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:270:2: ( ( ( rule__TypeRef__Group__0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:271:1: ( ( rule__TypeRef__Group__0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:271:1: ( ( rule__TypeRef__Group__0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:272:1: ( rule__TypeRef__Group__0 )
            {
             before(grammarAccess.getTypeRefAccess().getGroup()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:273:1: ( rule__TypeRef__Group__0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:273:2: rule__TypeRef__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeRef__Group__0_in_ruleTypeRef514);
            rule__TypeRef__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleTypeRef"


    // $ANTLR start "entryRuleAlternatives"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:285:1: entryRuleAlternatives : ruleAlternatives EOF ;
    public final void entryRuleAlternatives() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:286:1: ( ruleAlternatives EOF )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:287:1: ruleAlternatives EOF
            {
             before(grammarAccess.getAlternativesRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAlternatives_in_entryRuleAlternatives541);
            ruleAlternatives();

            state._fsp--;

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
    // $ANTLR end "entryRuleAlternatives"


    // $ANTLR start "ruleAlternatives"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:294:1: ruleAlternatives : ( ( rule__Alternatives__Group__0 ) ) ;
    public final void ruleAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:298:2: ( ( ( rule__Alternatives__Group__0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:299:1: ( ( rule__Alternatives__Group__0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:299:1: ( ( rule__Alternatives__Group__0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:300:1: ( rule__Alternatives__Group__0 )
            {
             before(grammarAccess.getAlternativesAccess().getGroup()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:301:1: ( rule__Alternatives__Group__0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:301:2: rule__Alternatives__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group__0_in_ruleAlternatives574);
            rule__Alternatives__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleAlternatives"


    // $ANTLR start "entryRuleUnorderedGroup"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:313:1: entryRuleUnorderedGroup : ruleUnorderedGroup EOF ;
    public final void entryRuleUnorderedGroup() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:314:1: ( ruleUnorderedGroup EOF )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:315:1: ruleUnorderedGroup EOF
            {
             before(grammarAccess.getUnorderedGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnorderedGroup_in_entryRuleUnorderedGroup601);
            ruleUnorderedGroup();

            state._fsp--;

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
    // $ANTLR end "entryRuleUnorderedGroup"


    // $ANTLR start "ruleUnorderedGroup"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:322:1: ruleUnorderedGroup : ( ( rule__UnorderedGroup__Group__0 ) ) ;
    public final void ruleUnorderedGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:326:2: ( ( ( rule__UnorderedGroup__Group__0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:327:1: ( ( rule__UnorderedGroup__Group__0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:327:1: ( ( rule__UnorderedGroup__Group__0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:328:1: ( rule__UnorderedGroup__Group__0 )
            {
             before(grammarAccess.getUnorderedGroupAccess().getGroup()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:329:1: ( rule__UnorderedGroup__Group__0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:329:2: rule__UnorderedGroup__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__UnorderedGroup__Group__0_in_ruleUnorderedGroup634);
            rule__UnorderedGroup__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleUnorderedGroup"


    // $ANTLR start "entryRuleGroup"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:341:1: entryRuleGroup : ruleGroup EOF ;
    public final void entryRuleGroup() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:342:1: ( ruleGroup EOF )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:343:1: ruleGroup EOF
            {
             before(grammarAccess.getGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleGroup_in_entryRuleGroup661);
            ruleGroup();

            state._fsp--;

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
    // $ANTLR end "entryRuleGroup"


    // $ANTLR start "ruleGroup"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:350:1: ruleGroup : ( ( rule__Group__Group__0 ) ) ;
    public final void ruleGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:354:2: ( ( ( rule__Group__Group__0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:355:1: ( ( rule__Group__Group__0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:355:1: ( ( rule__Group__Group__0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:356:1: ( rule__Group__Group__0 )
            {
             before(grammarAccess.getGroupAccess().getGroup()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:357:1: ( rule__Group__Group__0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:357:2: rule__Group__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Group__Group__0_in_ruleGroup694);
            rule__Group__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleGroup"


    // $ANTLR start "entryRuleAbstractToken"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:369:1: entryRuleAbstractToken : ruleAbstractToken EOF ;
    public final void entryRuleAbstractToken() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:370:1: ( ruleAbstractToken EOF )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:371:1: ruleAbstractToken EOF
            {
             before(grammarAccess.getAbstractTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken721);
            ruleAbstractToken();

            state._fsp--;

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
    // $ANTLR end "entryRuleAbstractToken"


    // $ANTLR start "ruleAbstractToken"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:378:1: ruleAbstractToken : ( ( rule__AbstractToken__Alternatives ) ) ;
    public final void ruleAbstractToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:382:2: ( ( ( rule__AbstractToken__Alternatives ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:383:1: ( ( rule__AbstractToken__Alternatives ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:383:1: ( ( rule__AbstractToken__Alternatives ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:384:1: ( rule__AbstractToken__Alternatives )
            {
             before(grammarAccess.getAbstractTokenAccess().getAlternatives()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:385:1: ( rule__AbstractToken__Alternatives )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:385:2: rule__AbstractToken__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractToken__Alternatives_in_ruleAbstractToken754);
            rule__AbstractToken__Alternatives();

            state._fsp--;


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
    // $ANTLR end "ruleAbstractToken"


    // $ANTLR start "entryRuleAbstractTokenWithCardinality"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:397:1: entryRuleAbstractTokenWithCardinality : ruleAbstractTokenWithCardinality EOF ;
    public final void entryRuleAbstractTokenWithCardinality() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:398:1: ( ruleAbstractTokenWithCardinality EOF )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:399:1: ruleAbstractTokenWithCardinality EOF
            {
             before(grammarAccess.getAbstractTokenWithCardinalityRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractTokenWithCardinality_in_entryRuleAbstractTokenWithCardinality781);
            ruleAbstractTokenWithCardinality();

            state._fsp--;

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
    // $ANTLR end "entryRuleAbstractTokenWithCardinality"


    // $ANTLR start "ruleAbstractTokenWithCardinality"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:406:1: ruleAbstractTokenWithCardinality : ( ( rule__AbstractTokenWithCardinality__Group__0 ) ) ;
    public final void ruleAbstractTokenWithCardinality() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:410:2: ( ( ( rule__AbstractTokenWithCardinality__Group__0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:411:1: ( ( rule__AbstractTokenWithCardinality__Group__0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:411:1: ( ( rule__AbstractTokenWithCardinality__Group__0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:412:1: ( rule__AbstractTokenWithCardinality__Group__0 )
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getGroup()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:413:1: ( rule__AbstractTokenWithCardinality__Group__0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:413:2: rule__AbstractTokenWithCardinality__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractTokenWithCardinality__Group__0_in_ruleAbstractTokenWithCardinality814);
            rule__AbstractTokenWithCardinality__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleAbstractTokenWithCardinality"


    // $ANTLR start "entryRuleAction"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:425:1: entryRuleAction : ruleAction EOF ;
    public final void entryRuleAction() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:426:1: ( ruleAction EOF )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:427:1: ruleAction EOF
            {
             before(grammarAccess.getActionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAction_in_entryRuleAction841);
            ruleAction();

            state._fsp--;

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
    // $ANTLR end "entryRuleAction"


    // $ANTLR start "ruleAction"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:434:1: ruleAction : ( ( rule__Action__Group__0 ) ) ;
    public final void ruleAction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:438:2: ( ( ( rule__Action__Group__0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:439:1: ( ( rule__Action__Group__0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:439:1: ( ( rule__Action__Group__0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:440:1: ( rule__Action__Group__0 )
            {
             before(grammarAccess.getActionAccess().getGroup()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:441:1: ( rule__Action__Group__0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:441:2: rule__Action__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__Group__0_in_ruleAction874);
            rule__Action__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRuleAbstractTerminal"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:453:1: entryRuleAbstractTerminal : ruleAbstractTerminal EOF ;
    public final void entryRuleAbstractTerminal() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:454:1: ( ruleAbstractTerminal EOF )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:455:1: ruleAbstractTerminal EOF
            {
             before(grammarAccess.getAbstractTerminalRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal901);
            ruleAbstractTerminal();

            state._fsp--;

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
    // $ANTLR end "entryRuleAbstractTerminal"


    // $ANTLR start "ruleAbstractTerminal"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:462:1: ruleAbstractTerminal : ( ( rule__AbstractTerminal__Alternatives ) ) ;
    public final void ruleAbstractTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:466:2: ( ( ( rule__AbstractTerminal__Alternatives ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:467:1: ( ( rule__AbstractTerminal__Alternatives ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:467:1: ( ( rule__AbstractTerminal__Alternatives ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:468:1: ( rule__AbstractTerminal__Alternatives )
            {
             before(grammarAccess.getAbstractTerminalAccess().getAlternatives()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:469:1: ( rule__AbstractTerminal__Alternatives )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:469:2: rule__AbstractTerminal__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractTerminal__Alternatives_in_ruleAbstractTerminal934);
            rule__AbstractTerminal__Alternatives();

            state._fsp--;


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
    // $ANTLR end "ruleAbstractTerminal"


    // $ANTLR start "entryRuleKeyword"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:481:1: entryRuleKeyword : ruleKeyword EOF ;
    public final void entryRuleKeyword() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:482:1: ( ruleKeyword EOF )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:483:1: ruleKeyword EOF
            {
             before(grammarAccess.getKeywordRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_entryRuleKeyword961);
            ruleKeyword();

            state._fsp--;

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
    // $ANTLR end "entryRuleKeyword"


    // $ANTLR start "ruleKeyword"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:490:1: ruleKeyword : ( ( rule__Keyword__ValueAssignment ) ) ;
    public final void ruleKeyword() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:494:2: ( ( ( rule__Keyword__ValueAssignment ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:495:1: ( ( rule__Keyword__ValueAssignment ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:495:1: ( ( rule__Keyword__ValueAssignment ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:496:1: ( rule__Keyword__ValueAssignment )
            {
             before(grammarAccess.getKeywordAccess().getValueAssignment()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:497:1: ( rule__Keyword__ValueAssignment )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:497:2: rule__Keyword__ValueAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__Keyword__ValueAssignment_in_ruleKeyword994);
            rule__Keyword__ValueAssignment();

            state._fsp--;


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
    // $ANTLR end "ruleKeyword"


    // $ANTLR start "entryRuleRuleCall"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:509:1: entryRuleRuleCall : ruleRuleCall EOF ;
    public final void entryRuleRuleCall() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:510:1: ( ruleRuleCall EOF )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:511:1: ruleRuleCall EOF
            {
             before(grammarAccess.getRuleCallRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_entryRuleRuleCall1021);
            ruleRuleCall();

            state._fsp--;

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
    // $ANTLR end "entryRuleRuleCall"


    // $ANTLR start "ruleRuleCall"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:518:1: ruleRuleCall : ( ( rule__RuleCall__RuleAssignment ) ) ;
    public final void ruleRuleCall() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:522:2: ( ( ( rule__RuleCall__RuleAssignment ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:523:1: ( ( rule__RuleCall__RuleAssignment ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:523:1: ( ( rule__RuleCall__RuleAssignment ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:524:1: ( rule__RuleCall__RuleAssignment )
            {
             before(grammarAccess.getRuleCallAccess().getRuleAssignment()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:525:1: ( rule__RuleCall__RuleAssignment )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:525:2: rule__RuleCall__RuleAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__RuleCall__RuleAssignment_in_ruleRuleCall1054);
            rule__RuleCall__RuleAssignment();

            state._fsp--;


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
    // $ANTLR end "ruleRuleCall"


    // $ANTLR start "entryRuleAssignment"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:537:1: entryRuleAssignment : ruleAssignment EOF ;
    public final void entryRuleAssignment() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:538:1: ( ruleAssignment EOF )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:539:1: ruleAssignment EOF
            {
             before(grammarAccess.getAssignmentRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignment_in_entryRuleAssignment1081);
            ruleAssignment();

            state._fsp--;

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
    // $ANTLR end "entryRuleAssignment"


    // $ANTLR start "ruleAssignment"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:546:1: ruleAssignment : ( ( rule__Assignment__Group__0 ) ) ;
    public final void ruleAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:550:2: ( ( ( rule__Assignment__Group__0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:551:1: ( ( rule__Assignment__Group__0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:551:1: ( ( rule__Assignment__Group__0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:552:1: ( rule__Assignment__Group__0 )
            {
             before(grammarAccess.getAssignmentAccess().getGroup()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:553:1: ( rule__Assignment__Group__0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:553:2: rule__Assignment__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Assignment__Group__0_in_ruleAssignment1114);
            rule__Assignment__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleAssignment"


    // $ANTLR start "entryRuleAssignableTerminal"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:565:1: entryRuleAssignableTerminal : ruleAssignableTerminal EOF ;
    public final void entryRuleAssignableTerminal() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:566:1: ( ruleAssignableTerminal EOF )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:567:1: ruleAssignableTerminal EOF
            {
             before(grammarAccess.getAssignableTerminalRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_entryRuleAssignableTerminal1141);
            ruleAssignableTerminal();

            state._fsp--;

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
    // $ANTLR end "entryRuleAssignableTerminal"


    // $ANTLR start "ruleAssignableTerminal"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:574:1: ruleAssignableTerminal : ( ( rule__AssignableTerminal__Alternatives ) ) ;
    public final void ruleAssignableTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:578:2: ( ( ( rule__AssignableTerminal__Alternatives ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:579:1: ( ( rule__AssignableTerminal__Alternatives ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:579:1: ( ( rule__AssignableTerminal__Alternatives ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:580:1: ( rule__AssignableTerminal__Alternatives )
            {
             before(grammarAccess.getAssignableTerminalAccess().getAlternatives()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:581:1: ( rule__AssignableTerminal__Alternatives )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:581:2: rule__AssignableTerminal__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__AssignableTerminal__Alternatives_in_ruleAssignableTerminal1174);
            rule__AssignableTerminal__Alternatives();

            state._fsp--;


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
    // $ANTLR end "ruleAssignableTerminal"


    // $ANTLR start "entryRuleParenthesizedAssignableElement"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:593:1: entryRuleParenthesizedAssignableElement : ruleParenthesizedAssignableElement EOF ;
    public final void entryRuleParenthesizedAssignableElement() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:594:1: ( ruleParenthesizedAssignableElement EOF )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:595:1: ruleParenthesizedAssignableElement EOF
            {
             before(grammarAccess.getParenthesizedAssignableElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesizedAssignableElement_in_entryRuleParenthesizedAssignableElement1201);
            ruleParenthesizedAssignableElement();

            state._fsp--;

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
    // $ANTLR end "entryRuleParenthesizedAssignableElement"


    // $ANTLR start "ruleParenthesizedAssignableElement"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:602:1: ruleParenthesizedAssignableElement : ( ( rule__ParenthesizedAssignableElement__Group__0 ) ) ;
    public final void ruleParenthesizedAssignableElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:606:2: ( ( ( rule__ParenthesizedAssignableElement__Group__0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:607:1: ( ( rule__ParenthesizedAssignableElement__Group__0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:607:1: ( ( rule__ParenthesizedAssignableElement__Group__0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:608:1: ( rule__ParenthesizedAssignableElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getGroup()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:609:1: ( rule__ParenthesizedAssignableElement__Group__0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:609:2: rule__ParenthesizedAssignableElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedAssignableElement__Group__0_in_ruleParenthesizedAssignableElement1234);
            rule__ParenthesizedAssignableElement__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleParenthesizedAssignableElement"


    // $ANTLR start "entryRuleAssignableAlternatives"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:621:1: entryRuleAssignableAlternatives : ruleAssignableAlternatives EOF ;
    public final void entryRuleAssignableAlternatives() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:622:1: ( ruleAssignableAlternatives EOF )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:623:1: ruleAssignableAlternatives EOF
            {
             before(grammarAccess.getAssignableAlternativesRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableAlternatives_in_entryRuleAssignableAlternatives1261);
            ruleAssignableAlternatives();

            state._fsp--;

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
    // $ANTLR end "entryRuleAssignableAlternatives"


    // $ANTLR start "ruleAssignableAlternatives"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:630:1: ruleAssignableAlternatives : ( ( rule__AssignableAlternatives__Group__0 ) ) ;
    public final void ruleAssignableAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:634:2: ( ( ( rule__AssignableAlternatives__Group__0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:635:1: ( ( rule__AssignableAlternatives__Group__0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:635:1: ( ( rule__AssignableAlternatives__Group__0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:636:1: ( rule__AssignableAlternatives__Group__0 )
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:637:1: ( rule__AssignableAlternatives__Group__0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:637:2: rule__AssignableAlternatives__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group__0_in_ruleAssignableAlternatives1294);
            rule__AssignableAlternatives__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleAssignableAlternatives"


    // $ANTLR start "entryRuleCrossReference"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:649:1: entryRuleCrossReference : ruleCrossReference EOF ;
    public final void entryRuleCrossReference() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:650:1: ( ruleCrossReference EOF )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:651:1: ruleCrossReference EOF
            {
             before(grammarAccess.getCrossReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCrossReference_in_entryRuleCrossReference1321);
            ruleCrossReference();

            state._fsp--;

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
    // $ANTLR end "entryRuleCrossReference"


    // $ANTLR start "ruleCrossReference"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:658:1: ruleCrossReference : ( ( rule__CrossReference__Group__0 ) ) ;
    public final void ruleCrossReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:662:2: ( ( ( rule__CrossReference__Group__0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:663:1: ( ( rule__CrossReference__Group__0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:663:1: ( ( rule__CrossReference__Group__0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:664:1: ( rule__CrossReference__Group__0 )
            {
             before(grammarAccess.getCrossReferenceAccess().getGroup()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:665:1: ( rule__CrossReference__Group__0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:665:2: rule__CrossReference__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group__0_in_ruleCrossReference1354);
            rule__CrossReference__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleCrossReference"


    // $ANTLR start "entryRuleCrossReferenceableTerminal"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:677:1: entryRuleCrossReferenceableTerminal : ruleCrossReferenceableTerminal EOF ;
    public final void entryRuleCrossReferenceableTerminal() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:678:1: ( ruleCrossReferenceableTerminal EOF )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:679:1: ruleCrossReferenceableTerminal EOF
            {
             before(grammarAccess.getCrossReferenceableTerminalRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCrossReferenceableTerminal_in_entryRuleCrossReferenceableTerminal1381);
            ruleCrossReferenceableTerminal();

            state._fsp--;

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
    // $ANTLR end "entryRuleCrossReferenceableTerminal"


    // $ANTLR start "ruleCrossReferenceableTerminal"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:686:1: ruleCrossReferenceableTerminal : ( ( rule__CrossReferenceableTerminal__Alternatives ) ) ;
    public final void ruleCrossReferenceableTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:690:2: ( ( ( rule__CrossReferenceableTerminal__Alternatives ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:691:1: ( ( rule__CrossReferenceableTerminal__Alternatives ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:691:1: ( ( rule__CrossReferenceableTerminal__Alternatives ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:692:1: ( rule__CrossReferenceableTerminal__Alternatives )
            {
             before(grammarAccess.getCrossReferenceableTerminalAccess().getAlternatives()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:693:1: ( rule__CrossReferenceableTerminal__Alternatives )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:693:2: rule__CrossReferenceableTerminal__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReferenceableTerminal__Alternatives_in_ruleCrossReferenceableTerminal1414);
            rule__CrossReferenceableTerminal__Alternatives();

            state._fsp--;


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
    // $ANTLR end "ruleCrossReferenceableTerminal"


    // $ANTLR start "entryRuleParenthesizedElement"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:705:1: entryRuleParenthesizedElement : ruleParenthesizedElement EOF ;
    public final void entryRuleParenthesizedElement() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:706:1: ( ruleParenthesizedElement EOF )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:707:1: ruleParenthesizedElement EOF
            {
             before(grammarAccess.getParenthesizedElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement1441);
            ruleParenthesizedElement();

            state._fsp--;

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
    // $ANTLR end "entryRuleParenthesizedElement"


    // $ANTLR start "ruleParenthesizedElement"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:714:1: ruleParenthesizedElement : ( ( rule__ParenthesizedElement__Group__0 ) ) ;
    public final void ruleParenthesizedElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:718:2: ( ( ( rule__ParenthesizedElement__Group__0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:719:1: ( ( rule__ParenthesizedElement__Group__0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:719:1: ( ( rule__ParenthesizedElement__Group__0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:720:1: ( rule__ParenthesizedElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedElementAccess().getGroup()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:721:1: ( rule__ParenthesizedElement__Group__0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:721:2: rule__ParenthesizedElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedElement__Group__0_in_ruleParenthesizedElement1474);
            rule__ParenthesizedElement__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleParenthesizedElement"


    // $ANTLR start "entryRuleTerminalRule"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:733:1: entryRuleTerminalRule : ruleTerminalRule EOF ;
    public final void entryRuleTerminalRule() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:734:1: ( ruleTerminalRule EOF )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:735:1: ruleTerminalRule EOF
            {
             before(grammarAccess.getTerminalRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule1501);
            ruleTerminalRule();

            state._fsp--;

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
    // $ANTLR end "entryRuleTerminalRule"


    // $ANTLR start "ruleTerminalRule"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:742:1: ruleTerminalRule : ( ( rule__TerminalRule__Group__0 ) ) ;
    public final void ruleTerminalRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:746:2: ( ( ( rule__TerminalRule__Group__0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:747:1: ( ( rule__TerminalRule__Group__0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:747:1: ( ( rule__TerminalRule__Group__0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:748:1: ( rule__TerminalRule__Group__0 )
            {
             before(grammarAccess.getTerminalRuleAccess().getGroup()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:749:1: ( rule__TerminalRule__Group__0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:749:2: rule__TerminalRule__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__0_in_ruleTerminalRule1534);
            rule__TerminalRule__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleTerminalRule"


    // $ANTLR start "entryRuleTerminalAlternatives"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:761:1: entryRuleTerminalAlternatives : ruleTerminalAlternatives EOF ;
    public final void entryRuleTerminalAlternatives() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:762:1: ( ruleTerminalAlternatives EOF )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:763:1: ruleTerminalAlternatives EOF
            {
             before(grammarAccess.getTerminalAlternativesRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives1561);
            ruleTerminalAlternatives();

            state._fsp--;

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
    // $ANTLR end "entryRuleTerminalAlternatives"


    // $ANTLR start "ruleTerminalAlternatives"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:770:1: ruleTerminalAlternatives : ( ( rule__TerminalAlternatives__Group__0 ) ) ;
    public final void ruleTerminalAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:774:2: ( ( ( rule__TerminalAlternatives__Group__0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:775:1: ( ( rule__TerminalAlternatives__Group__0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:775:1: ( ( rule__TerminalAlternatives__Group__0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:776:1: ( rule__TerminalAlternatives__Group__0 )
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:777:1: ( rule__TerminalAlternatives__Group__0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:777:2: rule__TerminalAlternatives__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group__0_in_ruleTerminalAlternatives1594);
            rule__TerminalAlternatives__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleTerminalAlternatives"


    // $ANTLR start "entryRuleTerminalGroup"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:789:1: entryRuleTerminalGroup : ruleTerminalGroup EOF ;
    public final void entryRuleTerminalGroup() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:790:1: ( ruleTerminalGroup EOF )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:791:1: ruleTerminalGroup EOF
            {
             before(grammarAccess.getTerminalGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup1621);
            ruleTerminalGroup();

            state._fsp--;

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
    // $ANTLR end "entryRuleTerminalGroup"


    // $ANTLR start "ruleTerminalGroup"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:798:1: ruleTerminalGroup : ( ( rule__TerminalGroup__Group__0 ) ) ;
    public final void ruleTerminalGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:802:2: ( ( ( rule__TerminalGroup__Group__0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:803:1: ( ( rule__TerminalGroup__Group__0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:803:1: ( ( rule__TerminalGroup__Group__0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:804:1: ( rule__TerminalGroup__Group__0 )
            {
             before(grammarAccess.getTerminalGroupAccess().getGroup()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:805:1: ( rule__TerminalGroup__Group__0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:805:2: rule__TerminalGroup__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__Group__0_in_ruleTerminalGroup1654);
            rule__TerminalGroup__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleTerminalGroup"


    // $ANTLR start "entryRuleTerminalToken"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:817:1: entryRuleTerminalToken : ruleTerminalToken EOF ;
    public final void entryRuleTerminalToken() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:818:1: ( ruleTerminalToken EOF )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:819:1: ruleTerminalToken EOF
            {
             before(grammarAccess.getTerminalTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken1681);
            ruleTerminalToken();

            state._fsp--;

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
    // $ANTLR end "entryRuleTerminalToken"


    // $ANTLR start "ruleTerminalToken"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:826:1: ruleTerminalToken : ( ( rule__TerminalToken__Group__0 ) ) ;
    public final void ruleTerminalToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:830:2: ( ( ( rule__TerminalToken__Group__0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:831:1: ( ( rule__TerminalToken__Group__0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:831:1: ( ( rule__TerminalToken__Group__0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:832:1: ( rule__TerminalToken__Group__0 )
            {
             before(grammarAccess.getTerminalTokenAccess().getGroup()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:833:1: ( rule__TerminalToken__Group__0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:833:2: rule__TerminalToken__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalToken__Group__0_in_ruleTerminalToken1714);
            rule__TerminalToken__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleTerminalToken"


    // $ANTLR start "entryRuleTerminalTokenElement"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:845:1: entryRuleTerminalTokenElement : ruleTerminalTokenElement EOF ;
    public final void entryRuleTerminalTokenElement() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:846:1: ( ruleTerminalTokenElement EOF )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:847:1: ruleTerminalTokenElement EOF
            {
             before(grammarAccess.getTerminalTokenElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement1741);
            ruleTerminalTokenElement();

            state._fsp--;

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
    // $ANTLR end "entryRuleTerminalTokenElement"


    // $ANTLR start "ruleTerminalTokenElement"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:854:1: ruleTerminalTokenElement : ( ( rule__TerminalTokenElement__Alternatives ) ) ;
    public final void ruleTerminalTokenElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:858:2: ( ( ( rule__TerminalTokenElement__Alternatives ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:859:1: ( ( rule__TerminalTokenElement__Alternatives ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:859:1: ( ( rule__TerminalTokenElement__Alternatives ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:860:1: ( rule__TerminalTokenElement__Alternatives )
            {
             before(grammarAccess.getTerminalTokenElementAccess().getAlternatives()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:861:1: ( rule__TerminalTokenElement__Alternatives )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:861:2: rule__TerminalTokenElement__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalTokenElement__Alternatives_in_ruleTerminalTokenElement1774);
            rule__TerminalTokenElement__Alternatives();

            state._fsp--;


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
    // $ANTLR end "ruleTerminalTokenElement"


    // $ANTLR start "entryRuleParenthesizedTerminalElement"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:873:1: entryRuleParenthesizedTerminalElement : ruleParenthesizedTerminalElement EOF ;
    public final void entryRuleParenthesizedTerminalElement() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:874:1: ( ruleParenthesizedTerminalElement EOF )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:875:1: ruleParenthesizedTerminalElement EOF
            {
             before(grammarAccess.getParenthesizedTerminalElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement1801);
            ruleParenthesizedTerminalElement();

            state._fsp--;

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
    // $ANTLR end "entryRuleParenthesizedTerminalElement"


    // $ANTLR start "ruleParenthesizedTerminalElement"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:882:1: ruleParenthesizedTerminalElement : ( ( rule__ParenthesizedTerminalElement__Group__0 ) ) ;
    public final void ruleParenthesizedTerminalElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:886:2: ( ( ( rule__ParenthesizedTerminalElement__Group__0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:887:1: ( ( rule__ParenthesizedTerminalElement__Group__0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:887:1: ( ( rule__ParenthesizedTerminalElement__Group__0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:888:1: ( rule__ParenthesizedTerminalElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getGroup()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:889:1: ( rule__ParenthesizedTerminalElement__Group__0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:889:2: rule__ParenthesizedTerminalElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedTerminalElement__Group__0_in_ruleParenthesizedTerminalElement1834);
            rule__ParenthesizedTerminalElement__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleParenthesizedTerminalElement"


    // $ANTLR start "entryRuleAbstractNegatedToken"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:901:1: entryRuleAbstractNegatedToken : ruleAbstractNegatedToken EOF ;
    public final void entryRuleAbstractNegatedToken() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:902:1: ( ruleAbstractNegatedToken EOF )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:903:1: ruleAbstractNegatedToken EOF
            {
             before(grammarAccess.getAbstractNegatedTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken1861);
            ruleAbstractNegatedToken();

            state._fsp--;

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
    // $ANTLR end "entryRuleAbstractNegatedToken"


    // $ANTLR start "ruleAbstractNegatedToken"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:910:1: ruleAbstractNegatedToken : ( ( rule__AbstractNegatedToken__Alternatives ) ) ;
    public final void ruleAbstractNegatedToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:914:2: ( ( ( rule__AbstractNegatedToken__Alternatives ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:915:1: ( ( rule__AbstractNegatedToken__Alternatives ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:915:1: ( ( rule__AbstractNegatedToken__Alternatives ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:916:1: ( rule__AbstractNegatedToken__Alternatives )
            {
             before(grammarAccess.getAbstractNegatedTokenAccess().getAlternatives()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:917:1: ( rule__AbstractNegatedToken__Alternatives )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:917:2: rule__AbstractNegatedToken__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractNegatedToken__Alternatives_in_ruleAbstractNegatedToken1894);
            rule__AbstractNegatedToken__Alternatives();

            state._fsp--;


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
    // $ANTLR end "ruleAbstractNegatedToken"


    // $ANTLR start "entryRuleNegatedToken"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:929:1: entryRuleNegatedToken : ruleNegatedToken EOF ;
    public final void entryRuleNegatedToken() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:930:1: ( ruleNegatedToken EOF )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:931:1: ruleNegatedToken EOF
            {
             before(grammarAccess.getNegatedTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken1921);
            ruleNegatedToken();

            state._fsp--;

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
    // $ANTLR end "entryRuleNegatedToken"


    // $ANTLR start "ruleNegatedToken"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:938:1: ruleNegatedToken : ( ( rule__NegatedToken__Group__0 ) ) ;
    public final void ruleNegatedToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:942:2: ( ( ( rule__NegatedToken__Group__0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:943:1: ( ( rule__NegatedToken__Group__0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:943:1: ( ( rule__NegatedToken__Group__0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:944:1: ( rule__NegatedToken__Group__0 )
            {
             before(grammarAccess.getNegatedTokenAccess().getGroup()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:945:1: ( rule__NegatedToken__Group__0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:945:2: rule__NegatedToken__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__NegatedToken__Group__0_in_ruleNegatedToken1954);
            rule__NegatedToken__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleNegatedToken"


    // $ANTLR start "entryRuleUntilToken"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:957:1: entryRuleUntilToken : ruleUntilToken EOF ;
    public final void entryRuleUntilToken() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:958:1: ( ruleUntilToken EOF )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:959:1: ruleUntilToken EOF
            {
             before(grammarAccess.getUntilTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUntilToken_in_entryRuleUntilToken1981);
            ruleUntilToken();

            state._fsp--;

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
    // $ANTLR end "entryRuleUntilToken"


    // $ANTLR start "ruleUntilToken"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:966:1: ruleUntilToken : ( ( rule__UntilToken__Group__0 ) ) ;
    public final void ruleUntilToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:970:2: ( ( ( rule__UntilToken__Group__0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:971:1: ( ( rule__UntilToken__Group__0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:971:1: ( ( rule__UntilToken__Group__0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:972:1: ( rule__UntilToken__Group__0 )
            {
             before(grammarAccess.getUntilTokenAccess().getGroup()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:973:1: ( rule__UntilToken__Group__0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:973:2: rule__UntilToken__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__UntilToken__Group__0_in_ruleUntilToken2014);
            rule__UntilToken__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleUntilToken"


    // $ANTLR start "entryRuleWildcard"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:985:1: entryRuleWildcard : ruleWildcard EOF ;
    public final void entryRuleWildcard() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:986:1: ( ruleWildcard EOF )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:987:1: ruleWildcard EOF
            {
             before(grammarAccess.getWildcardRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleWildcard_in_entryRuleWildcard2041);
            ruleWildcard();

            state._fsp--;

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
    // $ANTLR end "entryRuleWildcard"


    // $ANTLR start "ruleWildcard"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:994:1: ruleWildcard : ( ( rule__Wildcard__Group__0 ) ) ;
    public final void ruleWildcard() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:998:2: ( ( ( rule__Wildcard__Group__0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:999:1: ( ( rule__Wildcard__Group__0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:999:1: ( ( rule__Wildcard__Group__0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1000:1: ( rule__Wildcard__Group__0 )
            {
             before(grammarAccess.getWildcardAccess().getGroup()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1001:1: ( rule__Wildcard__Group__0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1001:2: rule__Wildcard__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Wildcard__Group__0_in_ruleWildcard2074);
            rule__Wildcard__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleWildcard"


    // $ANTLR start "entryRuleCharacterRange"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1013:1: entryRuleCharacterRange : ruleCharacterRange EOF ;
    public final void entryRuleCharacterRange() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1014:1: ( ruleCharacterRange EOF )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1015:1: ruleCharacterRange EOF
            {
             before(grammarAccess.getCharacterRangeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange2101);
            ruleCharacterRange();

            state._fsp--;

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
    // $ANTLR end "entryRuleCharacterRange"


    // $ANTLR start "ruleCharacterRange"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1022:1: ruleCharacterRange : ( ( rule__CharacterRange__Group__0 ) ) ;
    public final void ruleCharacterRange() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1026:2: ( ( ( rule__CharacterRange__Group__0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1027:1: ( ( rule__CharacterRange__Group__0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1027:1: ( ( rule__CharacterRange__Group__0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1028:1: ( rule__CharacterRange__Group__0 )
            {
             before(grammarAccess.getCharacterRangeAccess().getGroup()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1029:1: ( rule__CharacterRange__Group__0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1029:2: rule__CharacterRange__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group__0_in_ruleCharacterRange2134);
            rule__CharacterRange__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleCharacterRange"


    // $ANTLR start "entryRuleEnumRule"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1041:1: entryRuleEnumRule : ruleEnumRule EOF ;
    public final void entryRuleEnumRule() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1042:1: ( ruleEnumRule EOF )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1043:1: ruleEnumRule EOF
            {
             before(grammarAccess.getEnumRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumRule_in_entryRuleEnumRule2161);
            ruleEnumRule();

            state._fsp--;

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
    // $ANTLR end "entryRuleEnumRule"


    // $ANTLR start "ruleEnumRule"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1050:1: ruleEnumRule : ( ( rule__EnumRule__Group__0 ) ) ;
    public final void ruleEnumRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1054:2: ( ( ( rule__EnumRule__Group__0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1055:1: ( ( rule__EnumRule__Group__0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1055:1: ( ( rule__EnumRule__Group__0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1056:1: ( rule__EnumRule__Group__0 )
            {
             before(grammarAccess.getEnumRuleAccess().getGroup()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1057:1: ( rule__EnumRule__Group__0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1057:2: rule__EnumRule__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__0_in_ruleEnumRule2194);
            rule__EnumRule__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleEnumRule"


    // $ANTLR start "entryRuleEnumLiterals"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1069:1: entryRuleEnumLiterals : ruleEnumLiterals EOF ;
    public final void entryRuleEnumLiterals() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1070:1: ( ruleEnumLiterals EOF )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1071:1: ruleEnumLiterals EOF
            {
             before(grammarAccess.getEnumLiteralsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiterals_in_entryRuleEnumLiterals2221);
            ruleEnumLiterals();

            state._fsp--;

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
    // $ANTLR end "entryRuleEnumLiterals"


    // $ANTLR start "ruleEnumLiterals"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1078:1: ruleEnumLiterals : ( ( rule__EnumLiterals__Group__0 ) ) ;
    public final void ruleEnumLiterals() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1082:2: ( ( ( rule__EnumLiterals__Group__0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1083:1: ( ( rule__EnumLiterals__Group__0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1083:1: ( ( rule__EnumLiterals__Group__0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1084:1: ( rule__EnumLiterals__Group__0 )
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1085:1: ( rule__EnumLiterals__Group__0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1085:2: rule__EnumLiterals__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group__0_in_ruleEnumLiterals2254);
            rule__EnumLiterals__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleEnumLiterals"


    // $ANTLR start "entryRuleEnumLiteralDeclaration"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1097:1: entryRuleEnumLiteralDeclaration : ruleEnumLiteralDeclaration EOF ;
    public final void entryRuleEnumLiteralDeclaration() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1098:1: ( ruleEnumLiteralDeclaration EOF )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1099:1: ruleEnumLiteralDeclaration EOF
            {
             before(grammarAccess.getEnumLiteralDeclarationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiteralDeclaration_in_entryRuleEnumLiteralDeclaration2281);
            ruleEnumLiteralDeclaration();

            state._fsp--;

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
    // $ANTLR end "entryRuleEnumLiteralDeclaration"


    // $ANTLR start "ruleEnumLiteralDeclaration"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1106:1: ruleEnumLiteralDeclaration : ( ( rule__EnumLiteralDeclaration__Group__0 ) ) ;
    public final void ruleEnumLiteralDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1110:2: ( ( ( rule__EnumLiteralDeclaration__Group__0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1111:1: ( ( rule__EnumLiteralDeclaration__Group__0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1111:1: ( ( rule__EnumLiteralDeclaration__Group__0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1112:1: ( rule__EnumLiteralDeclaration__Group__0 )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getGroup()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1113:1: ( rule__EnumLiteralDeclaration__Group__0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1113:2: rule__EnumLiteralDeclaration__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__Group__0_in_ruleEnumLiteralDeclaration2314);
            rule__EnumLiteralDeclaration__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleEnumLiteralDeclaration"


    // $ANTLR start "rule__AbstractRule__Alternatives"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1125:1: rule__AbstractRule__Alternatives : ( ( ruleParserRule ) | ( ruleTerminalRule ) | ( ruleEnumRule ) );
    public final void rule__AbstractRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1129:1: ( ( ruleParserRule ) | ( ruleTerminalRule ) | ( ruleEnumRule ) )
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
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1130:1: ( ruleParserRule )
                    {
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1130:1: ( ruleParserRule )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1131:1: ruleParserRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getParserRuleParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleParserRule_in_rule__AbstractRule__Alternatives2350);
                    ruleParserRule();

                    state._fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getParserRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1136:6: ( ruleTerminalRule )
                    {
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1136:6: ( ruleTerminalRule )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1137:1: ruleTerminalRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getTerminalRuleParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleTerminalRule_in_rule__AbstractRule__Alternatives2367);
                    ruleTerminalRule();

                    state._fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getTerminalRuleParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1142:6: ( ruleEnumRule )
                    {
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1142:6: ( ruleEnumRule )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1143:1: ruleEnumRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getEnumRuleParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_ruleEnumRule_in_rule__AbstractRule__Alternatives2384);
                    ruleEnumRule();

                    state._fsp--;

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
    // $ANTLR end "rule__AbstractRule__Alternatives"


    // $ANTLR start "rule__AbstractMetamodelDeclaration__Alternatives"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1153:1: rule__AbstractMetamodelDeclaration__Alternatives : ( ( ruleGeneratedMetamodel ) | ( ruleReferencedMetamodel ) );
    public final void rule__AbstractMetamodelDeclaration__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1157:1: ( ( ruleGeneratedMetamodel ) | ( ruleReferencedMetamodel ) )
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
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1158:1: ( ruleGeneratedMetamodel )
                    {
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1158:1: ( ruleGeneratedMetamodel )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1159:1: ruleGeneratedMetamodel
                    {
                     before(grammarAccess.getAbstractMetamodelDeclarationAccess().getGeneratedMetamodelParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleGeneratedMetamodel_in_rule__AbstractMetamodelDeclaration__Alternatives2416);
                    ruleGeneratedMetamodel();

                    state._fsp--;

                     after(grammarAccess.getAbstractMetamodelDeclarationAccess().getGeneratedMetamodelParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1164:6: ( ruleReferencedMetamodel )
                    {
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1164:6: ( ruleReferencedMetamodel )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1165:1: ruleReferencedMetamodel
                    {
                     before(grammarAccess.getAbstractMetamodelDeclarationAccess().getReferencedMetamodelParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleReferencedMetamodel_in_rule__AbstractMetamodelDeclaration__Alternatives2433);
                    ruleReferencedMetamodel();

                    state._fsp--;

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
    // $ANTLR end "rule__AbstractMetamodelDeclaration__Alternatives"


    // $ANTLR start "rule__AbstractToken__Alternatives"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1175:1: rule__AbstractToken__Alternatives : ( ( ruleAbstractTokenWithCardinality ) | ( ruleAction ) );
    public final void rule__AbstractToken__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1179:1: ( ( ruleAbstractTokenWithCardinality ) | ( ruleAction ) )
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
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1180:1: ( ruleAbstractTokenWithCardinality )
                    {
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1180:1: ( ruleAbstractTokenWithCardinality )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1181:1: ruleAbstractTokenWithCardinality
                    {
                     before(grammarAccess.getAbstractTokenAccess().getAbstractTokenWithCardinalityParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractTokenWithCardinality_in_rule__AbstractToken__Alternatives2465);
                    ruleAbstractTokenWithCardinality();

                    state._fsp--;

                     after(grammarAccess.getAbstractTokenAccess().getAbstractTokenWithCardinalityParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1186:6: ( ruleAction )
                    {
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1186:6: ( ruleAction )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1187:1: ruleAction
                    {
                     before(grammarAccess.getAbstractTokenAccess().getActionParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAction_in_rule__AbstractToken__Alternatives2482);
                    ruleAction();

                    state._fsp--;

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
    // $ANTLR end "rule__AbstractToken__Alternatives"


    // $ANTLR start "rule__AbstractTokenWithCardinality__Alternatives_0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1197:1: rule__AbstractTokenWithCardinality__Alternatives_0 : ( ( ruleAssignment ) | ( ruleAbstractTerminal ) );
    public final void rule__AbstractTokenWithCardinality__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1201:1: ( ( ruleAssignment ) | ( ruleAbstractTerminal ) )
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
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA4_0==RULE_STRING||LA4_0==20) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1202:1: ( ruleAssignment )
                    {
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1202:1: ( ruleAssignment )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1203:1: ruleAssignment
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getAssignmentParserRuleCall_0_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAssignment_in_rule__AbstractTokenWithCardinality__Alternatives_02514);
                    ruleAssignment();

                    state._fsp--;

                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getAssignmentParserRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1208:6: ( ruleAbstractTerminal )
                    {
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1208:6: ( ruleAbstractTerminal )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1209:1: ruleAbstractTerminal
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getAbstractTerminalParserRuleCall_0_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractTerminal_in_rule__AbstractTokenWithCardinality__Alternatives_02531);
                    ruleAbstractTerminal();

                    state._fsp--;

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
    // $ANTLR end "rule__AbstractTokenWithCardinality__Alternatives_0"


    // $ANTLR start "rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1219:1: rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 : ( ( '?' ) | ( '*' ) | ( '+' ) );
    public final void rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1223:1: ( ( '?' ) | ( '*' ) | ( '+' ) )
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
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1224:1: ( '?' )
                    {
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1224:1: ( '?' )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1225:1: '?'
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_02564); 
                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1232:6: ( '*' )
                    {
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1232:6: ( '*' )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1233:1: '*'
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAsteriskKeyword_1_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_02584); 
                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAsteriskKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1240:6: ( '+' )
                    {
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1240:6: ( '+' )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1241:1: '+'
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
    // $ANTLR end "rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0"


    // $ANTLR start "rule__Action__OperatorAlternatives_2_2_0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1253:1: rule__Action__OperatorAlternatives_2_2_0 : ( ( '=' ) | ( '+=' ) );
    public final void rule__Action__OperatorAlternatives_2_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1257:1: ( ( '=' ) | ( '+=' ) )
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
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1258:1: ( '=' )
                    {
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1258:1: ( '=' )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1259:1: '='
                    {
                     before(grammarAccess.getActionAccess().getOperatorEqualsSignKeyword_2_2_0_0()); 
                    match(input,14,FollowSets000.FOLLOW_14_in_rule__Action__OperatorAlternatives_2_2_02639); 
                     after(grammarAccess.getActionAccess().getOperatorEqualsSignKeyword_2_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1266:6: ( '+=' )
                    {
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1266:6: ( '+=' )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1267:1: '+='
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
    // $ANTLR end "rule__Action__OperatorAlternatives_2_2_0"


    // $ANTLR start "rule__AbstractTerminal__Alternatives"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1279:1: rule__AbstractTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedElement ) );
    public final void rule__AbstractTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1283:1: ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedElement ) )
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
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1284:1: ( ruleKeyword )
                    {
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1284:1: ( ruleKeyword )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1285:1: ruleKeyword
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getKeywordParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_rule__AbstractTerminal__Alternatives2693);
                    ruleKeyword();

                    state._fsp--;

                     after(grammarAccess.getAbstractTerminalAccess().getKeywordParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1290:6: ( ruleRuleCall )
                    {
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1290:6: ( ruleRuleCall )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1291:1: ruleRuleCall
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_rule__AbstractTerminal__Alternatives2710);
                    ruleRuleCall();

                    state._fsp--;

                     after(grammarAccess.getAbstractTerminalAccess().getRuleCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1296:6: ( ruleParenthesizedElement )
                    {
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1296:6: ( ruleParenthesizedElement )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1297:1: ruleParenthesizedElement
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getParenthesizedElementParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedElement_in_rule__AbstractTerminal__Alternatives2727);
                    ruleParenthesizedElement();

                    state._fsp--;

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
    // $ANTLR end "rule__AbstractTerminal__Alternatives"


    // $ANTLR start "rule__Assignment__OperatorAlternatives_1_0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1307:1: rule__Assignment__OperatorAlternatives_1_0 : ( ( '+=' ) | ( '=' ) | ( '?=' ) );
    public final void rule__Assignment__OperatorAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1311:1: ( ( '+=' ) | ( '=' ) | ( '?=' ) )
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
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1312:1: ( '+=' )
                    {
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1312:1: ( '+=' )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1313:1: '+='
                    {
                     before(grammarAccess.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_1_0_0()); 
                    match(input,15,FollowSets000.FOLLOW_15_in_rule__Assignment__OperatorAlternatives_1_02760); 
                     after(grammarAccess.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1320:6: ( '=' )
                    {
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1320:6: ( '=' )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1321:1: '='
                    {
                     before(grammarAccess.getAssignmentAccess().getOperatorEqualsSignKeyword_1_0_1()); 
                    match(input,14,FollowSets000.FOLLOW_14_in_rule__Assignment__OperatorAlternatives_1_02780); 
                     after(grammarAccess.getAssignmentAccess().getOperatorEqualsSignKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1328:6: ( '?=' )
                    {
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1328:6: ( '?=' )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1329:1: '?='
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
    // $ANTLR end "rule__Assignment__OperatorAlternatives_1_0"


    // $ANTLR start "rule__AssignableTerminal__Alternatives"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1341:1: rule__AssignableTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedAssignableElement ) | ( ruleCrossReference ) );
    public final void rule__AssignableTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1345:1: ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedAssignableElement ) | ( ruleCrossReference ) )
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
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1346:1: ( ruleKeyword )
                    {
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1346:1: ( ruleKeyword )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1347:1: ruleKeyword
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getKeywordParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_rule__AssignableTerminal__Alternatives2834);
                    ruleKeyword();

                    state._fsp--;

                     after(grammarAccess.getAssignableTerminalAccess().getKeywordParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1352:6: ( ruleRuleCall )
                    {
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1352:6: ( ruleRuleCall )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1353:1: ruleRuleCall
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_rule__AssignableTerminal__Alternatives2851);
                    ruleRuleCall();

                    state._fsp--;

                     after(grammarAccess.getAssignableTerminalAccess().getRuleCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1358:6: ( ruleParenthesizedAssignableElement )
                    {
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1358:6: ( ruleParenthesizedAssignableElement )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1359:1: ruleParenthesizedAssignableElement
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getParenthesizedAssignableElementParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedAssignableElement_in_rule__AssignableTerminal__Alternatives2868);
                    ruleParenthesizedAssignableElement();

                    state._fsp--;

                     after(grammarAccess.getAssignableTerminalAccess().getParenthesizedAssignableElementParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1364:6: ( ruleCrossReference )
                    {
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1364:6: ( ruleCrossReference )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1365:1: ruleCrossReference
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getCrossReferenceParserRuleCall_3()); 
                    pushFollow(FollowSets000.FOLLOW_ruleCrossReference_in_rule__AssignableTerminal__Alternatives2885);
                    ruleCrossReference();

                    state._fsp--;

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
    // $ANTLR end "rule__AssignableTerminal__Alternatives"


    // $ANTLR start "rule__CrossReferenceableTerminal__Alternatives"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1375:1: rule__CrossReferenceableTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) );
    public final void rule__CrossReferenceableTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1379:1: ( ( ruleKeyword ) | ( ruleRuleCall ) )
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
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1380:1: ( ruleKeyword )
                    {
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1380:1: ( ruleKeyword )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1381:1: ruleKeyword
                    {
                     before(grammarAccess.getCrossReferenceableTerminalAccess().getKeywordParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_rule__CrossReferenceableTerminal__Alternatives2917);
                    ruleKeyword();

                    state._fsp--;

                     after(grammarAccess.getCrossReferenceableTerminalAccess().getKeywordParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1386:6: ( ruleRuleCall )
                    {
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1386:6: ( ruleRuleCall )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1387:1: ruleRuleCall
                    {
                     before(grammarAccess.getCrossReferenceableTerminalAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_rule__CrossReferenceableTerminal__Alternatives2934);
                    ruleRuleCall();

                    state._fsp--;

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
    // $ANTLR end "rule__CrossReferenceableTerminal__Alternatives"


    // $ANTLR start "rule__TerminalRule__Alternatives_1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1397:1: rule__TerminalRule__Alternatives_1 : ( ( ( rule__TerminalRule__Group_1_0__0 ) ) | ( ( rule__TerminalRule__Group_1_1__0 ) ) );
    public final void rule__TerminalRule__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1401:1: ( ( ( rule__TerminalRule__Group_1_0__0 ) ) | ( ( rule__TerminalRule__Group_1_1__0 ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==43) ) {
                alt11=1;
            }
            else if ( (LA11_0==RULE_ID) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1402:1: ( ( rule__TerminalRule__Group_1_0__0 ) )
                    {
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1402:1: ( ( rule__TerminalRule__Group_1_0__0 ) )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1403:1: ( rule__TerminalRule__Group_1_0__0 )
                    {
                     before(grammarAccess.getTerminalRuleAccess().getGroup_1_0()); 
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1404:1: ( rule__TerminalRule__Group_1_0__0 )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1404:2: rule__TerminalRule__Group_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group_1_0__0_in_rule__TerminalRule__Alternatives_12966);
                    rule__TerminalRule__Group_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTerminalRuleAccess().getGroup_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1408:6: ( ( rule__TerminalRule__Group_1_1__0 ) )
                    {
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1408:6: ( ( rule__TerminalRule__Group_1_1__0 ) )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1409:1: ( rule__TerminalRule__Group_1_1__0 )
                    {
                     before(grammarAccess.getTerminalRuleAccess().getGroup_1_1()); 
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1410:1: ( rule__TerminalRule__Group_1_1__0 )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1410:2: rule__TerminalRule__Group_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group_1_1__0_in_rule__TerminalRule__Alternatives_12984);
                    rule__TerminalRule__Group_1_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTerminalRuleAccess().getGroup_1_1()); 

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
    // $ANTLR end "rule__TerminalRule__Alternatives_1"


    // $ANTLR start "rule__TerminalToken__CardinalityAlternatives_1_0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1419:1: rule__TerminalToken__CardinalityAlternatives_1_0 : ( ( '?' ) | ( '*' ) | ( '+' ) );
    public final void rule__TerminalToken__CardinalityAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1423:1: ( ( '?' ) | ( '*' ) | ( '+' ) )
            int alt12=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt12=1;
                }
                break;
            case 12:
                {
                alt12=2;
                }
                break;
            case 13:
                {
                alt12=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1424:1: ( '?' )
                    {
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1424:1: ( '?' )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1425:1: '?'
                    {
                     before(grammarAccess.getTerminalTokenAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__TerminalToken__CardinalityAlternatives_1_03018); 
                     after(grammarAccess.getTerminalTokenAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1432:6: ( '*' )
                    {
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1432:6: ( '*' )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1433:1: '*'
                    {
                     before(grammarAccess.getTerminalTokenAccess().getCardinalityAsteriskKeyword_1_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__TerminalToken__CardinalityAlternatives_1_03038); 
                     after(grammarAccess.getTerminalTokenAccess().getCardinalityAsteriskKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1440:6: ( '+' )
                    {
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1440:6: ( '+' )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1441:1: '+'
                    {
                     before(grammarAccess.getTerminalTokenAccess().getCardinalityPlusSignKeyword_1_0_2()); 
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__TerminalToken__CardinalityAlternatives_1_03058); 
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
    // $ANTLR end "rule__TerminalToken__CardinalityAlternatives_1_0"


    // $ANTLR start "rule__TerminalTokenElement__Alternatives"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1453:1: rule__TerminalTokenElement__Alternatives : ( ( ruleCharacterRange ) | ( ruleRuleCall ) | ( ruleParenthesizedTerminalElement ) | ( ruleAbstractNegatedToken ) | ( ruleWildcard ) );
    public final void rule__TerminalTokenElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1457:1: ( ( ruleCharacterRange ) | ( ruleRuleCall ) | ( ruleParenthesizedTerminalElement ) | ( ruleAbstractNegatedToken ) | ( ruleWildcard ) )
            int alt13=5;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt13=1;
                }
                break;
            case RULE_ID:
                {
                alt13=2;
                }
                break;
            case 20:
                {
                alt13=3;
                }
                break;
            case 38:
            case 39:
                {
                alt13=4;
                }
                break;
            case 22:
                {
                alt13=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1458:1: ( ruleCharacterRange )
                    {
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1458:1: ( ruleCharacterRange )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1459:1: ruleCharacterRange
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getCharacterRangeParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleCharacterRange_in_rule__TerminalTokenElement__Alternatives3092);
                    ruleCharacterRange();

                    state._fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getCharacterRangeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1464:6: ( ruleRuleCall )
                    {
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1464:6: ( ruleRuleCall )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1465:1: ruleRuleCall
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_rule__TerminalTokenElement__Alternatives3109);
                    ruleRuleCall();

                    state._fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getRuleCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1470:6: ( ruleParenthesizedTerminalElement )
                    {
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1470:6: ( ruleParenthesizedTerminalElement )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1471:1: ruleParenthesizedTerminalElement
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getParenthesizedTerminalElementParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedTerminalElement_in_rule__TerminalTokenElement__Alternatives3126);
                    ruleParenthesizedTerminalElement();

                    state._fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getParenthesizedTerminalElementParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1476:6: ( ruleAbstractNegatedToken )
                    {
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1476:6: ( ruleAbstractNegatedToken )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1477:1: ruleAbstractNegatedToken
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getAbstractNegatedTokenParserRuleCall_3()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractNegatedToken_in_rule__TerminalTokenElement__Alternatives3143);
                    ruleAbstractNegatedToken();

                    state._fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getAbstractNegatedTokenParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1482:6: ( ruleWildcard )
                    {
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1482:6: ( ruleWildcard )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1483:1: ruleWildcard
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getWildcardParserRuleCall_4()); 
                    pushFollow(FollowSets000.FOLLOW_ruleWildcard_in_rule__TerminalTokenElement__Alternatives3160);
                    ruleWildcard();

                    state._fsp--;

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
    // $ANTLR end "rule__TerminalTokenElement__Alternatives"


    // $ANTLR start "rule__AbstractNegatedToken__Alternatives"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1493:1: rule__AbstractNegatedToken__Alternatives : ( ( ruleNegatedToken ) | ( ruleUntilToken ) );
    public final void rule__AbstractNegatedToken__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1497:1: ( ( ruleNegatedToken ) | ( ruleUntilToken ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==38) ) {
                alt14=1;
            }
            else if ( (LA14_0==39) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1498:1: ( ruleNegatedToken )
                    {
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1498:1: ( ruleNegatedToken )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1499:1: ruleNegatedToken
                    {
                     before(grammarAccess.getAbstractNegatedTokenAccess().getNegatedTokenParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleNegatedToken_in_rule__AbstractNegatedToken__Alternatives3192);
                    ruleNegatedToken();

                    state._fsp--;

                     after(grammarAccess.getAbstractNegatedTokenAccess().getNegatedTokenParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1504:6: ( ruleUntilToken )
                    {
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1504:6: ( ruleUntilToken )
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1505:1: ruleUntilToken
                    {
                     before(grammarAccess.getAbstractNegatedTokenAccess().getUntilTokenParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleUntilToken_in_rule__AbstractNegatedToken__Alternatives3209);
                    ruleUntilToken();

                    state._fsp--;

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
    // $ANTLR end "rule__AbstractNegatedToken__Alternatives"


    // $ANTLR start "rule__Grammar__Group__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1517:1: rule__Grammar__Group__0 : rule__Grammar__Group__0__Impl rule__Grammar__Group__1 ;
    public final void rule__Grammar__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1521:1: ( rule__Grammar__Group__0__Impl rule__Grammar__Group__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1522:2: rule__Grammar__Group__0__Impl rule__Grammar__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__0__Impl_in_rule__Grammar__Group__03239);
            rule__Grammar__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__1_in_rule__Grammar__Group__03242);
            rule__Grammar__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group__0"


    // $ANTLR start "rule__Grammar__Group__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1529:1: rule__Grammar__Group__0__Impl : ( 'grammar' ) ;
    public final void rule__Grammar__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1533:1: ( ( 'grammar' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1534:1: ( 'grammar' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1534:1: ( 'grammar' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1535:1: 'grammar'
            {
             before(grammarAccess.getGrammarAccess().getGrammarKeyword_0()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__Grammar__Group__0__Impl3270); 
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
    // $ANTLR end "rule__Grammar__Group__0__Impl"


    // $ANTLR start "rule__Grammar__Group__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1548:1: rule__Grammar__Group__1 : rule__Grammar__Group__1__Impl rule__Grammar__Group__2 ;
    public final void rule__Grammar__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1552:1: ( rule__Grammar__Group__1__Impl rule__Grammar__Group__2 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1553:2: rule__Grammar__Group__1__Impl rule__Grammar__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__1__Impl_in_rule__Grammar__Group__13301);
            rule__Grammar__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__2_in_rule__Grammar__Group__13304);
            rule__Grammar__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group__1"


    // $ANTLR start "rule__Grammar__Group__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1560:1: rule__Grammar__Group__1__Impl : ( ( rule__Grammar__NameAssignment_1 ) ) ;
    public final void rule__Grammar__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1564:1: ( ( ( rule__Grammar__NameAssignment_1 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1565:1: ( ( rule__Grammar__NameAssignment_1 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1565:1: ( ( rule__Grammar__NameAssignment_1 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1566:1: ( rule__Grammar__NameAssignment_1 )
            {
             before(grammarAccess.getGrammarAccess().getNameAssignment_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1567:1: ( rule__Grammar__NameAssignment_1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1567:2: rule__Grammar__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__NameAssignment_1_in_rule__Grammar__Group__1__Impl3331);
            rule__Grammar__NameAssignment_1();

            state._fsp--;


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
    // $ANTLR end "rule__Grammar__Group__1__Impl"


    // $ANTLR start "rule__Grammar__Group__2"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1577:1: rule__Grammar__Group__2 : rule__Grammar__Group__2__Impl rule__Grammar__Group__3 ;
    public final void rule__Grammar__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1581:1: ( rule__Grammar__Group__2__Impl rule__Grammar__Group__3 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1582:2: rule__Grammar__Group__2__Impl rule__Grammar__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__2__Impl_in_rule__Grammar__Group__23361);
            rule__Grammar__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__3_in_rule__Grammar__Group__23364);
            rule__Grammar__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group__2"


    // $ANTLR start "rule__Grammar__Group__2__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1589:1: rule__Grammar__Group__2__Impl : ( ( rule__Grammar__Group_2__0 )? ) ;
    public final void rule__Grammar__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1593:1: ( ( ( rule__Grammar__Group_2__0 )? ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1594:1: ( ( rule__Grammar__Group_2__0 )? )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1594:1: ( ( rule__Grammar__Group_2__0 )? )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1595:1: ( rule__Grammar__Group_2__0 )?
            {
             before(grammarAccess.getGrammarAccess().getGroup_2()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1596:1: ( rule__Grammar__Group_2__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==18) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1596:2: rule__Grammar__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2__0_in_rule__Grammar__Group__2__Impl3391);
                    rule__Grammar__Group_2__0();

                    state._fsp--;


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
    // $ANTLR end "rule__Grammar__Group__2__Impl"


    // $ANTLR start "rule__Grammar__Group__3"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1606:1: rule__Grammar__Group__3 : rule__Grammar__Group__3__Impl rule__Grammar__Group__4 ;
    public final void rule__Grammar__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1610:1: ( rule__Grammar__Group__3__Impl rule__Grammar__Group__4 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1611:2: rule__Grammar__Group__3__Impl rule__Grammar__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__3__Impl_in_rule__Grammar__Group__33422);
            rule__Grammar__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__4_in_rule__Grammar__Group__33425);
            rule__Grammar__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group__3"


    // $ANTLR start "rule__Grammar__Group__3__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1618:1: rule__Grammar__Group__3__Impl : ( ( rule__Grammar__Group_3__0 )? ) ;
    public final void rule__Grammar__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1622:1: ( ( ( rule__Grammar__Group_3__0 )? ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1623:1: ( ( rule__Grammar__Group_3__0 )? )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1623:1: ( ( rule__Grammar__Group_3__0 )? )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1624:1: ( rule__Grammar__Group_3__0 )?
            {
             before(grammarAccess.getGrammarAccess().getGroup_3()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1625:1: ( rule__Grammar__Group_3__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==42) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1625:2: rule__Grammar__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3__0_in_rule__Grammar__Group__3__Impl3452);
                    rule__Grammar__Group_3__0();

                    state._fsp--;


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
    // $ANTLR end "rule__Grammar__Group__3__Impl"


    // $ANTLR start "rule__Grammar__Group__4"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1635:1: rule__Grammar__Group__4 : rule__Grammar__Group__4__Impl rule__Grammar__Group__5 ;
    public final void rule__Grammar__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1639:1: ( rule__Grammar__Group__4__Impl rule__Grammar__Group__5 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1640:2: rule__Grammar__Group__4__Impl rule__Grammar__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__4__Impl_in_rule__Grammar__Group__43483);
            rule__Grammar__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__5_in_rule__Grammar__Group__43486);
            rule__Grammar__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group__4"


    // $ANTLR start "rule__Grammar__Group__4__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1647:1: rule__Grammar__Group__4__Impl : ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* ) ;
    public final void rule__Grammar__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1651:1: ( ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1652:1: ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1652:1: ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1653:1: ( rule__Grammar__MetamodelDeclarationsAssignment_4 )*
            {
             before(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAssignment_4()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1654:1: ( rule__Grammar__MetamodelDeclarationsAssignment_4 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==23||LA17_0==25) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1654:2: rule__Grammar__MetamodelDeclarationsAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Grammar__MetamodelDeclarationsAssignment_4_in_rule__Grammar__Group__4__Impl3513);
            	    rule__Grammar__MetamodelDeclarationsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
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
    // $ANTLR end "rule__Grammar__Group__4__Impl"


    // $ANTLR start "rule__Grammar__Group__5"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1664:1: rule__Grammar__Group__5 : rule__Grammar__Group__5__Impl ;
    public final void rule__Grammar__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1668:1: ( rule__Grammar__Group__5__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1669:2: rule__Grammar__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__5__Impl_in_rule__Grammar__Group__53544);
            rule__Grammar__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group__5"


    // $ANTLR start "rule__Grammar__Group__5__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1675:1: rule__Grammar__Group__5__Impl : ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) ) ;
    public final void rule__Grammar__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1679:1: ( ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1680:1: ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1680:1: ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1681:1: ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1681:1: ( ( rule__Grammar__RulesAssignment_5 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1682:1: ( rule__Grammar__RulesAssignment_5 )
            {
             before(grammarAccess.getGrammarAccess().getRulesAssignment_5()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1683:1: ( rule__Grammar__RulesAssignment_5 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1683:2: rule__Grammar__RulesAssignment_5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__RulesAssignment_5_in_rule__Grammar__Group__5__Impl3573);
            rule__Grammar__RulesAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getGrammarAccess().getRulesAssignment_5()); 

            }

            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1686:1: ( ( rule__Grammar__RulesAssignment_5 )* )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1687:1: ( rule__Grammar__RulesAssignment_5 )*
            {
             before(grammarAccess.getGrammarAccess().getRulesAssignment_5()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1688:1: ( rule__Grammar__RulesAssignment_5 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_ID||LA18_0==37||LA18_0==41) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1688:2: rule__Grammar__RulesAssignment_5
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Grammar__RulesAssignment_5_in_rule__Grammar__Group__5__Impl3585);
            	    rule__Grammar__RulesAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
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
    // $ANTLR end "rule__Grammar__Group__5__Impl"


    // $ANTLR start "rule__Grammar__Group_2__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1711:1: rule__Grammar__Group_2__0 : rule__Grammar__Group_2__0__Impl rule__Grammar__Group_2__1 ;
    public final void rule__Grammar__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1715:1: ( rule__Grammar__Group_2__0__Impl rule__Grammar__Group_2__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1716:2: rule__Grammar__Group_2__0__Impl rule__Grammar__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2__0__Impl_in_rule__Grammar__Group_2__03630);
            rule__Grammar__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2__1_in_rule__Grammar__Group_2__03633);
            rule__Grammar__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_2__0"


    // $ANTLR start "rule__Grammar__Group_2__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1723:1: rule__Grammar__Group_2__0__Impl : ( 'with' ) ;
    public final void rule__Grammar__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1727:1: ( ( 'with' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1728:1: ( 'with' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1728:1: ( 'with' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1729:1: 'with'
            {
             before(grammarAccess.getGrammarAccess().getWithKeyword_2_0()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Grammar__Group_2__0__Impl3661); 
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
    // $ANTLR end "rule__Grammar__Group_2__0__Impl"


    // $ANTLR start "rule__Grammar__Group_2__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1742:1: rule__Grammar__Group_2__1 : rule__Grammar__Group_2__1__Impl rule__Grammar__Group_2__2 ;
    public final void rule__Grammar__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1746:1: ( rule__Grammar__Group_2__1__Impl rule__Grammar__Group_2__2 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1747:2: rule__Grammar__Group_2__1__Impl rule__Grammar__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2__1__Impl_in_rule__Grammar__Group_2__13692);
            rule__Grammar__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2__2_in_rule__Grammar__Group_2__13695);
            rule__Grammar__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_2__1"


    // $ANTLR start "rule__Grammar__Group_2__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1754:1: rule__Grammar__Group_2__1__Impl : ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) ) ;
    public final void rule__Grammar__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1758:1: ( ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1759:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1759:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1760:1: ( rule__Grammar__UsedGrammarsAssignment_2_1 )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1761:1: ( rule__Grammar__UsedGrammarsAssignment_2_1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1761:2: rule__Grammar__UsedGrammarsAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__UsedGrammarsAssignment_2_1_in_rule__Grammar__Group_2__1__Impl3722);
            rule__Grammar__UsedGrammarsAssignment_2_1();

            state._fsp--;


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
    // $ANTLR end "rule__Grammar__Group_2__1__Impl"


    // $ANTLR start "rule__Grammar__Group_2__2"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1771:1: rule__Grammar__Group_2__2 : rule__Grammar__Group_2__2__Impl ;
    public final void rule__Grammar__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1775:1: ( rule__Grammar__Group_2__2__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1776:2: rule__Grammar__Group_2__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2__2__Impl_in_rule__Grammar__Group_2__23752);
            rule__Grammar__Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_2__2"


    // $ANTLR start "rule__Grammar__Group_2__2__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1782:1: rule__Grammar__Group_2__2__Impl : ( ( rule__Grammar__Group_2_2__0 )* ) ;
    public final void rule__Grammar__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1786:1: ( ( ( rule__Grammar__Group_2_2__0 )* ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1787:1: ( ( rule__Grammar__Group_2_2__0 )* )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1787:1: ( ( rule__Grammar__Group_2_2__0 )* )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1788:1: ( rule__Grammar__Group_2_2__0 )*
            {
             before(grammarAccess.getGrammarAccess().getGroup_2_2()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1789:1: ( rule__Grammar__Group_2_2__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==19) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1789:2: rule__Grammar__Group_2_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2_2__0_in_rule__Grammar__Group_2__2__Impl3779);
            	    rule__Grammar__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
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
    // $ANTLR end "rule__Grammar__Group_2__2__Impl"


    // $ANTLR start "rule__Grammar__Group_2_2__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1805:1: rule__Grammar__Group_2_2__0 : rule__Grammar__Group_2_2__0__Impl rule__Grammar__Group_2_2__1 ;
    public final void rule__Grammar__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1809:1: ( rule__Grammar__Group_2_2__0__Impl rule__Grammar__Group_2_2__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1810:2: rule__Grammar__Group_2_2__0__Impl rule__Grammar__Group_2_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2_2__0__Impl_in_rule__Grammar__Group_2_2__03816);
            rule__Grammar__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2_2__1_in_rule__Grammar__Group_2_2__03819);
            rule__Grammar__Group_2_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_2_2__0"


    // $ANTLR start "rule__Grammar__Group_2_2__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1817:1: rule__Grammar__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__Grammar__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1821:1: ( ( ',' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1822:1: ( ',' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1822:1: ( ',' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1823:1: ','
            {
             before(grammarAccess.getGrammarAccess().getCommaKeyword_2_2_0()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Grammar__Group_2_2__0__Impl3847); 
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
    // $ANTLR end "rule__Grammar__Group_2_2__0__Impl"


    // $ANTLR start "rule__Grammar__Group_2_2__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1836:1: rule__Grammar__Group_2_2__1 : rule__Grammar__Group_2_2__1__Impl ;
    public final void rule__Grammar__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1840:1: ( rule__Grammar__Group_2_2__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1841:2: rule__Grammar__Group_2_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2_2__1__Impl_in_rule__Grammar__Group_2_2__13878);
            rule__Grammar__Group_2_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_2_2__1"


    // $ANTLR start "rule__Grammar__Group_2_2__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1847:1: rule__Grammar__Group_2_2__1__Impl : ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) ) ;
    public final void rule__Grammar__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1851:1: ( ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1852:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1852:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1853:1: ( rule__Grammar__UsedGrammarsAssignment_2_2_1 )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_2_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1854:1: ( rule__Grammar__UsedGrammarsAssignment_2_2_1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1854:2: rule__Grammar__UsedGrammarsAssignment_2_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__UsedGrammarsAssignment_2_2_1_in_rule__Grammar__Group_2_2__1__Impl3905);
            rule__Grammar__UsedGrammarsAssignment_2_2_1();

            state._fsp--;


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
    // $ANTLR end "rule__Grammar__Group_2_2__1__Impl"


    // $ANTLR start "rule__Grammar__Group_3__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1868:1: rule__Grammar__Group_3__0 : rule__Grammar__Group_3__0__Impl rule__Grammar__Group_3__1 ;
    public final void rule__Grammar__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1872:1: ( rule__Grammar__Group_3__0__Impl rule__Grammar__Group_3__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1873:2: rule__Grammar__Group_3__0__Impl rule__Grammar__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3__0__Impl_in_rule__Grammar__Group_3__03939);
            rule__Grammar__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3__1_in_rule__Grammar__Group_3__03942);
            rule__Grammar__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_3__0"


    // $ANTLR start "rule__Grammar__Group_3__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1880:1: rule__Grammar__Group_3__0__Impl : ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) ) ;
    public final void rule__Grammar__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1884:1: ( ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1885:1: ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1885:1: ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1886:1: ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 )
            {
             before(grammarAccess.getGrammarAccess().getDefinesHiddenTokensAssignment_3_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1887:1: ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1887:2: rule__Grammar__DefinesHiddenTokensAssignment_3_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__DefinesHiddenTokensAssignment_3_0_in_rule__Grammar__Group_3__0__Impl3969);
            rule__Grammar__DefinesHiddenTokensAssignment_3_0();

            state._fsp--;


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
    // $ANTLR end "rule__Grammar__Group_3__0__Impl"


    // $ANTLR start "rule__Grammar__Group_3__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1897:1: rule__Grammar__Group_3__1 : rule__Grammar__Group_3__1__Impl rule__Grammar__Group_3__2 ;
    public final void rule__Grammar__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1901:1: ( rule__Grammar__Group_3__1__Impl rule__Grammar__Group_3__2 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1902:2: rule__Grammar__Group_3__1__Impl rule__Grammar__Group_3__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3__1__Impl_in_rule__Grammar__Group_3__13999);
            rule__Grammar__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3__2_in_rule__Grammar__Group_3__14002);
            rule__Grammar__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_3__1"


    // $ANTLR start "rule__Grammar__Group_3__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1909:1: rule__Grammar__Group_3__1__Impl : ( '(' ) ;
    public final void rule__Grammar__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1913:1: ( ( '(' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1914:1: ( '(' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1914:1: ( '(' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1915:1: '('
            {
             before(grammarAccess.getGrammarAccess().getLeftParenthesisKeyword_3_1()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Grammar__Group_3__1__Impl4030); 
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
    // $ANTLR end "rule__Grammar__Group_3__1__Impl"


    // $ANTLR start "rule__Grammar__Group_3__2"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1928:1: rule__Grammar__Group_3__2 : rule__Grammar__Group_3__2__Impl rule__Grammar__Group_3__3 ;
    public final void rule__Grammar__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1932:1: ( rule__Grammar__Group_3__2__Impl rule__Grammar__Group_3__3 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1933:2: rule__Grammar__Group_3__2__Impl rule__Grammar__Group_3__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3__2__Impl_in_rule__Grammar__Group_3__24061);
            rule__Grammar__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3__3_in_rule__Grammar__Group_3__24064);
            rule__Grammar__Group_3__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_3__2"


    // $ANTLR start "rule__Grammar__Group_3__2__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1940:1: rule__Grammar__Group_3__2__Impl : ( ( rule__Grammar__Group_3_2__0 )? ) ;
    public final void rule__Grammar__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1944:1: ( ( ( rule__Grammar__Group_3_2__0 )? ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1945:1: ( ( rule__Grammar__Group_3_2__0 )? )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1945:1: ( ( rule__Grammar__Group_3_2__0 )? )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1946:1: ( rule__Grammar__Group_3_2__0 )?
            {
             before(grammarAccess.getGrammarAccess().getGroup_3_2()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1947:1: ( rule__Grammar__Group_3_2__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1947:2: rule__Grammar__Group_3_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3_2__0_in_rule__Grammar__Group_3__2__Impl4091);
                    rule__Grammar__Group_3_2__0();

                    state._fsp--;


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
    // $ANTLR end "rule__Grammar__Group_3__2__Impl"


    // $ANTLR start "rule__Grammar__Group_3__3"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1957:1: rule__Grammar__Group_3__3 : rule__Grammar__Group_3__3__Impl ;
    public final void rule__Grammar__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1961:1: ( rule__Grammar__Group_3__3__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1962:2: rule__Grammar__Group_3__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3__3__Impl_in_rule__Grammar__Group_3__34122);
            rule__Grammar__Group_3__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_3__3"


    // $ANTLR start "rule__Grammar__Group_3__3__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1968:1: rule__Grammar__Group_3__3__Impl : ( ')' ) ;
    public final void rule__Grammar__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1972:1: ( ( ')' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1973:1: ( ')' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1973:1: ( ')' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1974:1: ')'
            {
             before(grammarAccess.getGrammarAccess().getRightParenthesisKeyword_3_3()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__Grammar__Group_3__3__Impl4150); 
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
    // $ANTLR end "rule__Grammar__Group_3__3__Impl"


    // $ANTLR start "rule__Grammar__Group_3_2__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1995:1: rule__Grammar__Group_3_2__0 : rule__Grammar__Group_3_2__0__Impl rule__Grammar__Group_3_2__1 ;
    public final void rule__Grammar__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1999:1: ( rule__Grammar__Group_3_2__0__Impl rule__Grammar__Group_3_2__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2000:2: rule__Grammar__Group_3_2__0__Impl rule__Grammar__Group_3_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3_2__0__Impl_in_rule__Grammar__Group_3_2__04189);
            rule__Grammar__Group_3_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3_2__1_in_rule__Grammar__Group_3_2__04192);
            rule__Grammar__Group_3_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_3_2__0"


    // $ANTLR start "rule__Grammar__Group_3_2__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2007:1: rule__Grammar__Group_3_2__0__Impl : ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) ) ;
    public final void rule__Grammar__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2011:1: ( ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2012:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2012:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2013:1: ( rule__Grammar__HiddenTokensAssignment_3_2_0 )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAssignment_3_2_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2014:1: ( rule__Grammar__HiddenTokensAssignment_3_2_0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2014:2: rule__Grammar__HiddenTokensAssignment_3_2_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__HiddenTokensAssignment_3_2_0_in_rule__Grammar__Group_3_2__0__Impl4219);
            rule__Grammar__HiddenTokensAssignment_3_2_0();

            state._fsp--;


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
    // $ANTLR end "rule__Grammar__Group_3_2__0__Impl"


    // $ANTLR start "rule__Grammar__Group_3_2__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2024:1: rule__Grammar__Group_3_2__1 : rule__Grammar__Group_3_2__1__Impl ;
    public final void rule__Grammar__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2028:1: ( rule__Grammar__Group_3_2__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2029:2: rule__Grammar__Group_3_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3_2__1__Impl_in_rule__Grammar__Group_3_2__14249);
            rule__Grammar__Group_3_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_3_2__1"


    // $ANTLR start "rule__Grammar__Group_3_2__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2035:1: rule__Grammar__Group_3_2__1__Impl : ( ( rule__Grammar__Group_3_2_1__0 )* ) ;
    public final void rule__Grammar__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2039:1: ( ( ( rule__Grammar__Group_3_2_1__0 )* ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2040:1: ( ( rule__Grammar__Group_3_2_1__0 )* )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2040:1: ( ( rule__Grammar__Group_3_2_1__0 )* )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2041:1: ( rule__Grammar__Group_3_2_1__0 )*
            {
             before(grammarAccess.getGrammarAccess().getGroup_3_2_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2042:1: ( rule__Grammar__Group_3_2_1__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==19) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2042:2: rule__Grammar__Group_3_2_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3_2_1__0_in_rule__Grammar__Group_3_2__1__Impl4276);
            	    rule__Grammar__Group_3_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
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
    // $ANTLR end "rule__Grammar__Group_3_2__1__Impl"


    // $ANTLR start "rule__Grammar__Group_3_2_1__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2056:1: rule__Grammar__Group_3_2_1__0 : rule__Grammar__Group_3_2_1__0__Impl rule__Grammar__Group_3_2_1__1 ;
    public final void rule__Grammar__Group_3_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2060:1: ( rule__Grammar__Group_3_2_1__0__Impl rule__Grammar__Group_3_2_1__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2061:2: rule__Grammar__Group_3_2_1__0__Impl rule__Grammar__Group_3_2_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3_2_1__0__Impl_in_rule__Grammar__Group_3_2_1__04311);
            rule__Grammar__Group_3_2_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3_2_1__1_in_rule__Grammar__Group_3_2_1__04314);
            rule__Grammar__Group_3_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_3_2_1__0"


    // $ANTLR start "rule__Grammar__Group_3_2_1__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2068:1: rule__Grammar__Group_3_2_1__0__Impl : ( ',' ) ;
    public final void rule__Grammar__Group_3_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2072:1: ( ( ',' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2073:1: ( ',' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2073:1: ( ',' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2074:1: ','
            {
             before(grammarAccess.getGrammarAccess().getCommaKeyword_3_2_1_0()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Grammar__Group_3_2_1__0__Impl4342); 
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
    // $ANTLR end "rule__Grammar__Group_3_2_1__0__Impl"


    // $ANTLR start "rule__Grammar__Group_3_2_1__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2087:1: rule__Grammar__Group_3_2_1__1 : rule__Grammar__Group_3_2_1__1__Impl ;
    public final void rule__Grammar__Group_3_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2091:1: ( rule__Grammar__Group_3_2_1__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2092:2: rule__Grammar__Group_3_2_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3_2_1__1__Impl_in_rule__Grammar__Group_3_2_1__14373);
            rule__Grammar__Group_3_2_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_3_2_1__1"


    // $ANTLR start "rule__Grammar__Group_3_2_1__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2098:1: rule__Grammar__Group_3_2_1__1__Impl : ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) ) ;
    public final void rule__Grammar__Group_3_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2102:1: ( ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2103:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2103:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2104:1: ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAssignment_3_2_1_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2105:1: ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2105:2: rule__Grammar__HiddenTokensAssignment_3_2_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__HiddenTokensAssignment_3_2_1_1_in_rule__Grammar__Group_3_2_1__1__Impl4400);
            rule__Grammar__HiddenTokensAssignment_3_2_1_1();

            state._fsp--;


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
    // $ANTLR end "rule__Grammar__Group_3_2_1__1__Impl"


    // $ANTLR start "rule__GrammarID__Group__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2119:1: rule__GrammarID__Group__0 : rule__GrammarID__Group__0__Impl rule__GrammarID__Group__1 ;
    public final void rule__GrammarID__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2123:1: ( rule__GrammarID__Group__0__Impl rule__GrammarID__Group__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2124:2: rule__GrammarID__Group__0__Impl rule__GrammarID__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__GrammarID__Group__0__Impl_in_rule__GrammarID__Group__04434);
            rule__GrammarID__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__GrammarID__Group__1_in_rule__GrammarID__Group__04437);
            rule__GrammarID__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GrammarID__Group__0"


    // $ANTLR start "rule__GrammarID__Group__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2131:1: rule__GrammarID__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__GrammarID__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2135:1: ( ( RULE_ID ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2136:1: ( RULE_ID )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2136:1: ( RULE_ID )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2137:1: RULE_ID
            {
             before(grammarAccess.getGrammarIDAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__GrammarID__Group__0__Impl4464); 
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
    // $ANTLR end "rule__GrammarID__Group__0__Impl"


    // $ANTLR start "rule__GrammarID__Group__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2148:1: rule__GrammarID__Group__1 : rule__GrammarID__Group__1__Impl ;
    public final void rule__GrammarID__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2152:1: ( rule__GrammarID__Group__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2153:2: rule__GrammarID__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__GrammarID__Group__1__Impl_in_rule__GrammarID__Group__14493);
            rule__GrammarID__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GrammarID__Group__1"


    // $ANTLR start "rule__GrammarID__Group__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2159:1: rule__GrammarID__Group__1__Impl : ( ( rule__GrammarID__Group_1__0 )* ) ;
    public final void rule__GrammarID__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2163:1: ( ( ( rule__GrammarID__Group_1__0 )* ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2164:1: ( ( rule__GrammarID__Group_1__0 )* )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2164:1: ( ( rule__GrammarID__Group_1__0 )* )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2165:1: ( rule__GrammarID__Group_1__0 )*
            {
             before(grammarAccess.getGrammarIDAccess().getGroup_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2166:1: ( rule__GrammarID__Group_1__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==22) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2166:2: rule__GrammarID__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__GrammarID__Group_1__0_in_rule__GrammarID__Group__1__Impl4520);
            	    rule__GrammarID__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
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
    // $ANTLR end "rule__GrammarID__Group__1__Impl"


    // $ANTLR start "rule__GrammarID__Group_1__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2180:1: rule__GrammarID__Group_1__0 : rule__GrammarID__Group_1__0__Impl rule__GrammarID__Group_1__1 ;
    public final void rule__GrammarID__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2184:1: ( rule__GrammarID__Group_1__0__Impl rule__GrammarID__Group_1__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2185:2: rule__GrammarID__Group_1__0__Impl rule__GrammarID__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__GrammarID__Group_1__0__Impl_in_rule__GrammarID__Group_1__04555);
            rule__GrammarID__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__GrammarID__Group_1__1_in_rule__GrammarID__Group_1__04558);
            rule__GrammarID__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GrammarID__Group_1__0"


    // $ANTLR start "rule__GrammarID__Group_1__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2192:1: rule__GrammarID__Group_1__0__Impl : ( '.' ) ;
    public final void rule__GrammarID__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2196:1: ( ( '.' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2197:1: ( '.' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2197:1: ( '.' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2198:1: '.'
            {
             before(grammarAccess.getGrammarIDAccess().getFullStopKeyword_1_0()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__GrammarID__Group_1__0__Impl4586); 
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
    // $ANTLR end "rule__GrammarID__Group_1__0__Impl"


    // $ANTLR start "rule__GrammarID__Group_1__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2211:1: rule__GrammarID__Group_1__1 : rule__GrammarID__Group_1__1__Impl ;
    public final void rule__GrammarID__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2215:1: ( rule__GrammarID__Group_1__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2216:2: rule__GrammarID__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__GrammarID__Group_1__1__Impl_in_rule__GrammarID__Group_1__14617);
            rule__GrammarID__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GrammarID__Group_1__1"


    // $ANTLR start "rule__GrammarID__Group_1__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2222:1: rule__GrammarID__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__GrammarID__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2226:1: ( ( RULE_ID ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2227:1: ( RULE_ID )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2227:1: ( RULE_ID )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2228:1: RULE_ID
            {
             before(grammarAccess.getGrammarIDAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__GrammarID__Group_1__1__Impl4644); 
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
    // $ANTLR end "rule__GrammarID__Group_1__1__Impl"


    // $ANTLR start "rule__GeneratedMetamodel__Group__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2243:1: rule__GeneratedMetamodel__Group__0 : rule__GeneratedMetamodel__Group__0__Impl rule__GeneratedMetamodel__Group__1 ;
    public final void rule__GeneratedMetamodel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2247:1: ( rule__GeneratedMetamodel__Group__0__Impl rule__GeneratedMetamodel__Group__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2248:2: rule__GeneratedMetamodel__Group__0__Impl rule__GeneratedMetamodel__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group__0__Impl_in_rule__GeneratedMetamodel__Group__04677);
            rule__GeneratedMetamodel__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group__1_in_rule__GeneratedMetamodel__Group__04680);
            rule__GeneratedMetamodel__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneratedMetamodel__Group__0"


    // $ANTLR start "rule__GeneratedMetamodel__Group__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2255:1: rule__GeneratedMetamodel__Group__0__Impl : ( 'generate' ) ;
    public final void rule__GeneratedMetamodel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2259:1: ( ( 'generate' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2260:1: ( 'generate' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2260:1: ( 'generate' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2261:1: 'generate'
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getGenerateKeyword_0()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__GeneratedMetamodel__Group__0__Impl4708); 
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
    // $ANTLR end "rule__GeneratedMetamodel__Group__0__Impl"


    // $ANTLR start "rule__GeneratedMetamodel__Group__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2274:1: rule__GeneratedMetamodel__Group__1 : rule__GeneratedMetamodel__Group__1__Impl rule__GeneratedMetamodel__Group__2 ;
    public final void rule__GeneratedMetamodel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2278:1: ( rule__GeneratedMetamodel__Group__1__Impl rule__GeneratedMetamodel__Group__2 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2279:2: rule__GeneratedMetamodel__Group__1__Impl rule__GeneratedMetamodel__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group__1__Impl_in_rule__GeneratedMetamodel__Group__14739);
            rule__GeneratedMetamodel__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group__2_in_rule__GeneratedMetamodel__Group__14742);
            rule__GeneratedMetamodel__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneratedMetamodel__Group__1"


    // $ANTLR start "rule__GeneratedMetamodel__Group__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2286:1: rule__GeneratedMetamodel__Group__1__Impl : ( ( rule__GeneratedMetamodel__NameAssignment_1 ) ) ;
    public final void rule__GeneratedMetamodel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2290:1: ( ( ( rule__GeneratedMetamodel__NameAssignment_1 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2291:1: ( ( rule__GeneratedMetamodel__NameAssignment_1 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2291:1: ( ( rule__GeneratedMetamodel__NameAssignment_1 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2292:1: ( rule__GeneratedMetamodel__NameAssignment_1 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getNameAssignment_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2293:1: ( rule__GeneratedMetamodel__NameAssignment_1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2293:2: rule__GeneratedMetamodel__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__NameAssignment_1_in_rule__GeneratedMetamodel__Group__1__Impl4769);
            rule__GeneratedMetamodel__NameAssignment_1();

            state._fsp--;


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
    // $ANTLR end "rule__GeneratedMetamodel__Group__1__Impl"


    // $ANTLR start "rule__GeneratedMetamodel__Group__2"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2303:1: rule__GeneratedMetamodel__Group__2 : rule__GeneratedMetamodel__Group__2__Impl rule__GeneratedMetamodel__Group__3 ;
    public final void rule__GeneratedMetamodel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2307:1: ( rule__GeneratedMetamodel__Group__2__Impl rule__GeneratedMetamodel__Group__3 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2308:2: rule__GeneratedMetamodel__Group__2__Impl rule__GeneratedMetamodel__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group__2__Impl_in_rule__GeneratedMetamodel__Group__24799);
            rule__GeneratedMetamodel__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group__3_in_rule__GeneratedMetamodel__Group__24802);
            rule__GeneratedMetamodel__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneratedMetamodel__Group__2"


    // $ANTLR start "rule__GeneratedMetamodel__Group__2__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2315:1: rule__GeneratedMetamodel__Group__2__Impl : ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) ) ;
    public final void rule__GeneratedMetamodel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2319:1: ( ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2320:1: ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2320:1: ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2321:1: ( rule__GeneratedMetamodel__EPackageAssignment_2 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getEPackageAssignment_2()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2322:1: ( rule__GeneratedMetamodel__EPackageAssignment_2 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2322:2: rule__GeneratedMetamodel__EPackageAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__EPackageAssignment_2_in_rule__GeneratedMetamodel__Group__2__Impl4829);
            rule__GeneratedMetamodel__EPackageAssignment_2();

            state._fsp--;


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
    // $ANTLR end "rule__GeneratedMetamodel__Group__2__Impl"


    // $ANTLR start "rule__GeneratedMetamodel__Group__3"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2332:1: rule__GeneratedMetamodel__Group__3 : rule__GeneratedMetamodel__Group__3__Impl ;
    public final void rule__GeneratedMetamodel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2336:1: ( rule__GeneratedMetamodel__Group__3__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2337:2: rule__GeneratedMetamodel__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group__3__Impl_in_rule__GeneratedMetamodel__Group__34859);
            rule__GeneratedMetamodel__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneratedMetamodel__Group__3"


    // $ANTLR start "rule__GeneratedMetamodel__Group__3__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2343:1: rule__GeneratedMetamodel__Group__3__Impl : ( ( rule__GeneratedMetamodel__Group_3__0 )? ) ;
    public final void rule__GeneratedMetamodel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2347:1: ( ( ( rule__GeneratedMetamodel__Group_3__0 )? ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2348:1: ( ( rule__GeneratedMetamodel__Group_3__0 )? )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2348:1: ( ( rule__GeneratedMetamodel__Group_3__0 )? )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2349:1: ( rule__GeneratedMetamodel__Group_3__0 )?
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getGroup_3()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2350:1: ( rule__GeneratedMetamodel__Group_3__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==24) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2350:2: rule__GeneratedMetamodel__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group_3__0_in_rule__GeneratedMetamodel__Group__3__Impl4886);
                    rule__GeneratedMetamodel__Group_3__0();

                    state._fsp--;


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
    // $ANTLR end "rule__GeneratedMetamodel__Group__3__Impl"


    // $ANTLR start "rule__GeneratedMetamodel__Group_3__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2368:1: rule__GeneratedMetamodel__Group_3__0 : rule__GeneratedMetamodel__Group_3__0__Impl rule__GeneratedMetamodel__Group_3__1 ;
    public final void rule__GeneratedMetamodel__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2372:1: ( rule__GeneratedMetamodel__Group_3__0__Impl rule__GeneratedMetamodel__Group_3__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2373:2: rule__GeneratedMetamodel__Group_3__0__Impl rule__GeneratedMetamodel__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group_3__0__Impl_in_rule__GeneratedMetamodel__Group_3__04925);
            rule__GeneratedMetamodel__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group_3__1_in_rule__GeneratedMetamodel__Group_3__04928);
            rule__GeneratedMetamodel__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneratedMetamodel__Group_3__0"


    // $ANTLR start "rule__GeneratedMetamodel__Group_3__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2380:1: rule__GeneratedMetamodel__Group_3__0__Impl : ( 'as' ) ;
    public final void rule__GeneratedMetamodel__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2384:1: ( ( 'as' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2385:1: ( 'as' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2385:1: ( 'as' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2386:1: 'as'
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getAsKeyword_3_0()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__GeneratedMetamodel__Group_3__0__Impl4956); 
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
    // $ANTLR end "rule__GeneratedMetamodel__Group_3__0__Impl"


    // $ANTLR start "rule__GeneratedMetamodel__Group_3__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2399:1: rule__GeneratedMetamodel__Group_3__1 : rule__GeneratedMetamodel__Group_3__1__Impl ;
    public final void rule__GeneratedMetamodel__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2403:1: ( rule__GeneratedMetamodel__Group_3__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2404:2: rule__GeneratedMetamodel__Group_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group_3__1__Impl_in_rule__GeneratedMetamodel__Group_3__14987);
            rule__GeneratedMetamodel__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneratedMetamodel__Group_3__1"


    // $ANTLR start "rule__GeneratedMetamodel__Group_3__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2410:1: rule__GeneratedMetamodel__Group_3__1__Impl : ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) ) ;
    public final void rule__GeneratedMetamodel__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2414:1: ( ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2415:1: ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2415:1: ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2416:1: ( rule__GeneratedMetamodel__AliasAssignment_3_1 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getAliasAssignment_3_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2417:1: ( rule__GeneratedMetamodel__AliasAssignment_3_1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2417:2: rule__GeneratedMetamodel__AliasAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__AliasAssignment_3_1_in_rule__GeneratedMetamodel__Group_3__1__Impl5014);
            rule__GeneratedMetamodel__AliasAssignment_3_1();

            state._fsp--;


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
    // $ANTLR end "rule__GeneratedMetamodel__Group_3__1__Impl"


    // $ANTLR start "rule__ReferencedMetamodel__Group__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2431:1: rule__ReferencedMetamodel__Group__0 : rule__ReferencedMetamodel__Group__0__Impl rule__ReferencedMetamodel__Group__1 ;
    public final void rule__ReferencedMetamodel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2435:1: ( rule__ReferencedMetamodel__Group__0__Impl rule__ReferencedMetamodel__Group__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2436:2: rule__ReferencedMetamodel__Group__0__Impl rule__ReferencedMetamodel__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group__0__Impl_in_rule__ReferencedMetamodel__Group__05048);
            rule__ReferencedMetamodel__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group__1_in_rule__ReferencedMetamodel__Group__05051);
            rule__ReferencedMetamodel__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencedMetamodel__Group__0"


    // $ANTLR start "rule__ReferencedMetamodel__Group__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2443:1: rule__ReferencedMetamodel__Group__0__Impl : ( 'import' ) ;
    public final void rule__ReferencedMetamodel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2447:1: ( ( 'import' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2448:1: ( 'import' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2448:1: ( 'import' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2449:1: 'import'
            {
             before(grammarAccess.getReferencedMetamodelAccess().getImportKeyword_0()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__ReferencedMetamodel__Group__0__Impl5079); 
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
    // $ANTLR end "rule__ReferencedMetamodel__Group__0__Impl"


    // $ANTLR start "rule__ReferencedMetamodel__Group__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2462:1: rule__ReferencedMetamodel__Group__1 : rule__ReferencedMetamodel__Group__1__Impl rule__ReferencedMetamodel__Group__2 ;
    public final void rule__ReferencedMetamodel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2466:1: ( rule__ReferencedMetamodel__Group__1__Impl rule__ReferencedMetamodel__Group__2 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2467:2: rule__ReferencedMetamodel__Group__1__Impl rule__ReferencedMetamodel__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group__1__Impl_in_rule__ReferencedMetamodel__Group__15110);
            rule__ReferencedMetamodel__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group__2_in_rule__ReferencedMetamodel__Group__15113);
            rule__ReferencedMetamodel__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencedMetamodel__Group__1"


    // $ANTLR start "rule__ReferencedMetamodel__Group__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2474:1: rule__ReferencedMetamodel__Group__1__Impl : ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) ) ;
    public final void rule__ReferencedMetamodel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2478:1: ( ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2479:1: ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2479:1: ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2480:1: ( rule__ReferencedMetamodel__EPackageAssignment_1 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageAssignment_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2481:1: ( rule__ReferencedMetamodel__EPackageAssignment_1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2481:2: rule__ReferencedMetamodel__EPackageAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__EPackageAssignment_1_in_rule__ReferencedMetamodel__Group__1__Impl5140);
            rule__ReferencedMetamodel__EPackageAssignment_1();

            state._fsp--;


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
    // $ANTLR end "rule__ReferencedMetamodel__Group__1__Impl"


    // $ANTLR start "rule__ReferencedMetamodel__Group__2"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2491:1: rule__ReferencedMetamodel__Group__2 : rule__ReferencedMetamodel__Group__2__Impl ;
    public final void rule__ReferencedMetamodel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2495:1: ( rule__ReferencedMetamodel__Group__2__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2496:2: rule__ReferencedMetamodel__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group__2__Impl_in_rule__ReferencedMetamodel__Group__25170);
            rule__ReferencedMetamodel__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencedMetamodel__Group__2"


    // $ANTLR start "rule__ReferencedMetamodel__Group__2__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2502:1: rule__ReferencedMetamodel__Group__2__Impl : ( ( rule__ReferencedMetamodel__Group_2__0 )? ) ;
    public final void rule__ReferencedMetamodel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2506:1: ( ( ( rule__ReferencedMetamodel__Group_2__0 )? ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2507:1: ( ( rule__ReferencedMetamodel__Group_2__0 )? )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2507:1: ( ( rule__ReferencedMetamodel__Group_2__0 )? )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2508:1: ( rule__ReferencedMetamodel__Group_2__0 )?
            {
             before(grammarAccess.getReferencedMetamodelAccess().getGroup_2()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2509:1: ( rule__ReferencedMetamodel__Group_2__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==24) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2509:2: rule__ReferencedMetamodel__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group_2__0_in_rule__ReferencedMetamodel__Group__2__Impl5197);
                    rule__ReferencedMetamodel__Group_2__0();

                    state._fsp--;


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
    // $ANTLR end "rule__ReferencedMetamodel__Group__2__Impl"


    // $ANTLR start "rule__ReferencedMetamodel__Group_2__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2525:1: rule__ReferencedMetamodel__Group_2__0 : rule__ReferencedMetamodel__Group_2__0__Impl rule__ReferencedMetamodel__Group_2__1 ;
    public final void rule__ReferencedMetamodel__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2529:1: ( rule__ReferencedMetamodel__Group_2__0__Impl rule__ReferencedMetamodel__Group_2__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2530:2: rule__ReferencedMetamodel__Group_2__0__Impl rule__ReferencedMetamodel__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group_2__0__Impl_in_rule__ReferencedMetamodel__Group_2__05234);
            rule__ReferencedMetamodel__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group_2__1_in_rule__ReferencedMetamodel__Group_2__05237);
            rule__ReferencedMetamodel__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencedMetamodel__Group_2__0"


    // $ANTLR start "rule__ReferencedMetamodel__Group_2__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2537:1: rule__ReferencedMetamodel__Group_2__0__Impl : ( 'as' ) ;
    public final void rule__ReferencedMetamodel__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2541:1: ( ( 'as' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2542:1: ( 'as' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2542:1: ( 'as' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2543:1: 'as'
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAsKeyword_2_0()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__ReferencedMetamodel__Group_2__0__Impl5265); 
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
    // $ANTLR end "rule__ReferencedMetamodel__Group_2__0__Impl"


    // $ANTLR start "rule__ReferencedMetamodel__Group_2__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2556:1: rule__ReferencedMetamodel__Group_2__1 : rule__ReferencedMetamodel__Group_2__1__Impl ;
    public final void rule__ReferencedMetamodel__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2560:1: ( rule__ReferencedMetamodel__Group_2__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2561:2: rule__ReferencedMetamodel__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group_2__1__Impl_in_rule__ReferencedMetamodel__Group_2__15296);
            rule__ReferencedMetamodel__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencedMetamodel__Group_2__1"


    // $ANTLR start "rule__ReferencedMetamodel__Group_2__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2567:1: rule__ReferencedMetamodel__Group_2__1__Impl : ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) ) ;
    public final void rule__ReferencedMetamodel__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2571:1: ( ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2572:1: ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2572:1: ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2573:1: ( rule__ReferencedMetamodel__AliasAssignment_2_1 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAliasAssignment_2_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2574:1: ( rule__ReferencedMetamodel__AliasAssignment_2_1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2574:2: rule__ReferencedMetamodel__AliasAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__AliasAssignment_2_1_in_rule__ReferencedMetamodel__Group_2__1__Impl5323);
            rule__ReferencedMetamodel__AliasAssignment_2_1();

            state._fsp--;


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
    // $ANTLR end "rule__ReferencedMetamodel__Group_2__1__Impl"


    // $ANTLR start "rule__ParserRule__Group__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2588:1: rule__ParserRule__Group__0 : rule__ParserRule__Group__0__Impl rule__ParserRule__Group__1 ;
    public final void rule__ParserRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2592:1: ( rule__ParserRule__Group__0__Impl rule__ParserRule__Group__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2593:2: rule__ParserRule__Group__0__Impl rule__ParserRule__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__0__Impl_in_rule__ParserRule__Group__05357);
            rule__ParserRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__1_in_rule__ParserRule__Group__05360);
            rule__ParserRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group__0"


    // $ANTLR start "rule__ParserRule__Group__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2600:1: rule__ParserRule__Group__0__Impl : ( ( rule__ParserRule__NameAssignment_0 ) ) ;
    public final void rule__ParserRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2604:1: ( ( ( rule__ParserRule__NameAssignment_0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2605:1: ( ( rule__ParserRule__NameAssignment_0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2605:1: ( ( rule__ParserRule__NameAssignment_0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2606:1: ( rule__ParserRule__NameAssignment_0 )
            {
             before(grammarAccess.getParserRuleAccess().getNameAssignment_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2607:1: ( rule__ParserRule__NameAssignment_0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2607:2: rule__ParserRule__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__NameAssignment_0_in_rule__ParserRule__Group__0__Impl5387);
            rule__ParserRule__NameAssignment_0();

            state._fsp--;


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
    // $ANTLR end "rule__ParserRule__Group__0__Impl"


    // $ANTLR start "rule__ParserRule__Group__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2617:1: rule__ParserRule__Group__1 : rule__ParserRule__Group__1__Impl rule__ParserRule__Group__2 ;
    public final void rule__ParserRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2621:1: ( rule__ParserRule__Group__1__Impl rule__ParserRule__Group__2 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2622:2: rule__ParserRule__Group__1__Impl rule__ParserRule__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__1__Impl_in_rule__ParserRule__Group__15417);
            rule__ParserRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__2_in_rule__ParserRule__Group__15420);
            rule__ParserRule__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group__1"


    // $ANTLR start "rule__ParserRule__Group__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2629:1: rule__ParserRule__Group__1__Impl : ( ( rule__ParserRule__Group_1__0 )? ) ;
    public final void rule__ParserRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2633:1: ( ( ( rule__ParserRule__Group_1__0 )? ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2634:1: ( ( rule__ParserRule__Group_1__0 )? )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2634:1: ( ( rule__ParserRule__Group_1__0 )? )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2635:1: ( rule__ParserRule__Group_1__0 )?
            {
             before(grammarAccess.getParserRuleAccess().getGroup_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2636:1: ( rule__ParserRule__Group_1__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==28) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2636:2: rule__ParserRule__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_1__0_in_rule__ParserRule__Group__1__Impl5447);
                    rule__ParserRule__Group_1__0();

                    state._fsp--;


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
    // $ANTLR end "rule__ParserRule__Group__1__Impl"


    // $ANTLR start "rule__ParserRule__Group__2"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2646:1: rule__ParserRule__Group__2 : rule__ParserRule__Group__2__Impl rule__ParserRule__Group__3 ;
    public final void rule__ParserRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2650:1: ( rule__ParserRule__Group__2__Impl rule__ParserRule__Group__3 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2651:2: rule__ParserRule__Group__2__Impl rule__ParserRule__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__2__Impl_in_rule__ParserRule__Group__25478);
            rule__ParserRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__3_in_rule__ParserRule__Group__25481);
            rule__ParserRule__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group__2"


    // $ANTLR start "rule__ParserRule__Group__2__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2658:1: rule__ParserRule__Group__2__Impl : ( ( rule__ParserRule__Group_2__0 )? ) ;
    public final void rule__ParserRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2662:1: ( ( ( rule__ParserRule__Group_2__0 )? ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2663:1: ( ( rule__ParserRule__Group_2__0 )? )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2663:1: ( ( rule__ParserRule__Group_2__0 )? )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2664:1: ( rule__ParserRule__Group_2__0 )?
            {
             before(grammarAccess.getParserRuleAccess().getGroup_2()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2665:1: ( rule__ParserRule__Group_2__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==42) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2665:2: rule__ParserRule__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2__0_in_rule__ParserRule__Group__2__Impl5508);
                    rule__ParserRule__Group_2__0();

                    state._fsp--;


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
    // $ANTLR end "rule__ParserRule__Group__2__Impl"


    // $ANTLR start "rule__ParserRule__Group__3"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2675:1: rule__ParserRule__Group__3 : rule__ParserRule__Group__3__Impl rule__ParserRule__Group__4 ;
    public final void rule__ParserRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2679:1: ( rule__ParserRule__Group__3__Impl rule__ParserRule__Group__4 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2680:2: rule__ParserRule__Group__3__Impl rule__ParserRule__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__3__Impl_in_rule__ParserRule__Group__35539);
            rule__ParserRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__4_in_rule__ParserRule__Group__35542);
            rule__ParserRule__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group__3"


    // $ANTLR start "rule__ParserRule__Group__3__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2687:1: rule__ParserRule__Group__3__Impl : ( ':' ) ;
    public final void rule__ParserRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2691:1: ( ( ':' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2692:1: ( ':' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2692:1: ( ':' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2693:1: ':'
            {
             before(grammarAccess.getParserRuleAccess().getColonKeyword_3()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__ParserRule__Group__3__Impl5570); 
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
    // $ANTLR end "rule__ParserRule__Group__3__Impl"


    // $ANTLR start "rule__ParserRule__Group__4"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2706:1: rule__ParserRule__Group__4 : rule__ParserRule__Group__4__Impl rule__ParserRule__Group__5 ;
    public final void rule__ParserRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2710:1: ( rule__ParserRule__Group__4__Impl rule__ParserRule__Group__5 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2711:2: rule__ParserRule__Group__4__Impl rule__ParserRule__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__4__Impl_in_rule__ParserRule__Group__45601);
            rule__ParserRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__5_in_rule__ParserRule__Group__45604);
            rule__ParserRule__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group__4"


    // $ANTLR start "rule__ParserRule__Group__4__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2718:1: rule__ParserRule__Group__4__Impl : ( ( rule__ParserRule__AlternativesAssignment_4 ) ) ;
    public final void rule__ParserRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2722:1: ( ( ( rule__ParserRule__AlternativesAssignment_4 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2723:1: ( ( rule__ParserRule__AlternativesAssignment_4 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2723:1: ( ( rule__ParserRule__AlternativesAssignment_4 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2724:1: ( rule__ParserRule__AlternativesAssignment_4 )
            {
             before(grammarAccess.getParserRuleAccess().getAlternativesAssignment_4()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2725:1: ( rule__ParserRule__AlternativesAssignment_4 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2725:2: rule__ParserRule__AlternativesAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__AlternativesAssignment_4_in_rule__ParserRule__Group__4__Impl5631);
            rule__ParserRule__AlternativesAssignment_4();

            state._fsp--;


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
    // $ANTLR end "rule__ParserRule__Group__4__Impl"


    // $ANTLR start "rule__ParserRule__Group__5"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2735:1: rule__ParserRule__Group__5 : rule__ParserRule__Group__5__Impl ;
    public final void rule__ParserRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2739:1: ( rule__ParserRule__Group__5__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2740:2: rule__ParserRule__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__5__Impl_in_rule__ParserRule__Group__55661);
            rule__ParserRule__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group__5"


    // $ANTLR start "rule__ParserRule__Group__5__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2746:1: rule__ParserRule__Group__5__Impl : ( ';' ) ;
    public final void rule__ParserRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2750:1: ( ( ';' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2751:1: ( ';' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2751:1: ( ';' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2752:1: ';'
            {
             before(grammarAccess.getParserRuleAccess().getSemicolonKeyword_5()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__ParserRule__Group__5__Impl5689); 
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
    // $ANTLR end "rule__ParserRule__Group__5__Impl"


    // $ANTLR start "rule__ParserRule__Group_1__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2777:1: rule__ParserRule__Group_1__0 : rule__ParserRule__Group_1__0__Impl rule__ParserRule__Group_1__1 ;
    public final void rule__ParserRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2781:1: ( rule__ParserRule__Group_1__0__Impl rule__ParserRule__Group_1__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2782:2: rule__ParserRule__Group_1__0__Impl rule__ParserRule__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_1__0__Impl_in_rule__ParserRule__Group_1__05732);
            rule__ParserRule__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_1__1_in_rule__ParserRule__Group_1__05735);
            rule__ParserRule__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1__0"


    // $ANTLR start "rule__ParserRule__Group_1__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2789:1: rule__ParserRule__Group_1__0__Impl : ( 'returns' ) ;
    public final void rule__ParserRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2793:1: ( ( 'returns' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2794:1: ( 'returns' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2794:1: ( 'returns' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2795:1: 'returns'
            {
             before(grammarAccess.getParserRuleAccess().getReturnsKeyword_1_0()); 
            match(input,28,FollowSets000.FOLLOW_28_in_rule__ParserRule__Group_1__0__Impl5763); 
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
    // $ANTLR end "rule__ParserRule__Group_1__0__Impl"


    // $ANTLR start "rule__ParserRule__Group_1__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2808:1: rule__ParserRule__Group_1__1 : rule__ParserRule__Group_1__1__Impl ;
    public final void rule__ParserRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2812:1: ( rule__ParserRule__Group_1__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2813:2: rule__ParserRule__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_1__1__Impl_in_rule__ParserRule__Group_1__15794);
            rule__ParserRule__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1__1"


    // $ANTLR start "rule__ParserRule__Group_1__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2819:1: rule__ParserRule__Group_1__1__Impl : ( ( rule__ParserRule__TypeAssignment_1_1 ) ) ;
    public final void rule__ParserRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2823:1: ( ( ( rule__ParserRule__TypeAssignment_1_1 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2824:1: ( ( rule__ParserRule__TypeAssignment_1_1 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2824:1: ( ( rule__ParserRule__TypeAssignment_1_1 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2825:1: ( rule__ParserRule__TypeAssignment_1_1 )
            {
             before(grammarAccess.getParserRuleAccess().getTypeAssignment_1_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2826:1: ( rule__ParserRule__TypeAssignment_1_1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2826:2: rule__ParserRule__TypeAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__TypeAssignment_1_1_in_rule__ParserRule__Group_1__1__Impl5821);
            rule__ParserRule__TypeAssignment_1_1();

            state._fsp--;


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
    // $ANTLR end "rule__ParserRule__Group_1__1__Impl"


    // $ANTLR start "rule__ParserRule__Group_2__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2840:1: rule__ParserRule__Group_2__0 : rule__ParserRule__Group_2__0__Impl rule__ParserRule__Group_2__1 ;
    public final void rule__ParserRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2844:1: ( rule__ParserRule__Group_2__0__Impl rule__ParserRule__Group_2__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2845:2: rule__ParserRule__Group_2__0__Impl rule__ParserRule__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2__0__Impl_in_rule__ParserRule__Group_2__05855);
            rule__ParserRule__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2__1_in_rule__ParserRule__Group_2__05858);
            rule__ParserRule__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_2__0"


    // $ANTLR start "rule__ParserRule__Group_2__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2852:1: rule__ParserRule__Group_2__0__Impl : ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) ) ;
    public final void rule__ParserRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2856:1: ( ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2857:1: ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2857:1: ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2858:1: ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 )
            {
             before(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensAssignment_2_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2859:1: ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2859:2: rule__ParserRule__DefinesHiddenTokensAssignment_2_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__DefinesHiddenTokensAssignment_2_0_in_rule__ParserRule__Group_2__0__Impl5885);
            rule__ParserRule__DefinesHiddenTokensAssignment_2_0();

            state._fsp--;


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
    // $ANTLR end "rule__ParserRule__Group_2__0__Impl"


    // $ANTLR start "rule__ParserRule__Group_2__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2869:1: rule__ParserRule__Group_2__1 : rule__ParserRule__Group_2__1__Impl rule__ParserRule__Group_2__2 ;
    public final void rule__ParserRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2873:1: ( rule__ParserRule__Group_2__1__Impl rule__ParserRule__Group_2__2 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2874:2: rule__ParserRule__Group_2__1__Impl rule__ParserRule__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2__1__Impl_in_rule__ParserRule__Group_2__15915);
            rule__ParserRule__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2__2_in_rule__ParserRule__Group_2__15918);
            rule__ParserRule__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_2__1"


    // $ANTLR start "rule__ParserRule__Group_2__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2881:1: rule__ParserRule__Group_2__1__Impl : ( '(' ) ;
    public final void rule__ParserRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2885:1: ( ( '(' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2886:1: ( '(' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2886:1: ( '(' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2887:1: '('
            {
             before(grammarAccess.getParserRuleAccess().getLeftParenthesisKeyword_2_1()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__ParserRule__Group_2__1__Impl5946); 
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
    // $ANTLR end "rule__ParserRule__Group_2__1__Impl"


    // $ANTLR start "rule__ParserRule__Group_2__2"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2900:1: rule__ParserRule__Group_2__2 : rule__ParserRule__Group_2__2__Impl rule__ParserRule__Group_2__3 ;
    public final void rule__ParserRule__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2904:1: ( rule__ParserRule__Group_2__2__Impl rule__ParserRule__Group_2__3 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2905:2: rule__ParserRule__Group_2__2__Impl rule__ParserRule__Group_2__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2__2__Impl_in_rule__ParserRule__Group_2__25977);
            rule__ParserRule__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2__3_in_rule__ParserRule__Group_2__25980);
            rule__ParserRule__Group_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_2__2"


    // $ANTLR start "rule__ParserRule__Group_2__2__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2912:1: rule__ParserRule__Group_2__2__Impl : ( ( rule__ParserRule__Group_2_2__0 )? ) ;
    public final void rule__ParserRule__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2916:1: ( ( ( rule__ParserRule__Group_2_2__0 )? ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2917:1: ( ( rule__ParserRule__Group_2_2__0 )? )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2917:1: ( ( rule__ParserRule__Group_2_2__0 )? )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2918:1: ( rule__ParserRule__Group_2_2__0 )?
            {
             before(grammarAccess.getParserRuleAccess().getGroup_2_2()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2919:1: ( rule__ParserRule__Group_2_2__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_ID) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2919:2: rule__ParserRule__Group_2_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2_2__0_in_rule__ParserRule__Group_2__2__Impl6007);
                    rule__ParserRule__Group_2_2__0();

                    state._fsp--;


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
    // $ANTLR end "rule__ParserRule__Group_2__2__Impl"


    // $ANTLR start "rule__ParserRule__Group_2__3"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2929:1: rule__ParserRule__Group_2__3 : rule__ParserRule__Group_2__3__Impl ;
    public final void rule__ParserRule__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2933:1: ( rule__ParserRule__Group_2__3__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2934:2: rule__ParserRule__Group_2__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2__3__Impl_in_rule__ParserRule__Group_2__36038);
            rule__ParserRule__Group_2__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_2__3"


    // $ANTLR start "rule__ParserRule__Group_2__3__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2940:1: rule__ParserRule__Group_2__3__Impl : ( ')' ) ;
    public final void rule__ParserRule__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2944:1: ( ( ')' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2945:1: ( ')' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2945:1: ( ')' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2946:1: ')'
            {
             before(grammarAccess.getParserRuleAccess().getRightParenthesisKeyword_2_3()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__ParserRule__Group_2__3__Impl6066); 
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
    // $ANTLR end "rule__ParserRule__Group_2__3__Impl"


    // $ANTLR start "rule__ParserRule__Group_2_2__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2967:1: rule__ParserRule__Group_2_2__0 : rule__ParserRule__Group_2_2__0__Impl rule__ParserRule__Group_2_2__1 ;
    public final void rule__ParserRule__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2971:1: ( rule__ParserRule__Group_2_2__0__Impl rule__ParserRule__Group_2_2__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2972:2: rule__ParserRule__Group_2_2__0__Impl rule__ParserRule__Group_2_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2_2__0__Impl_in_rule__ParserRule__Group_2_2__06105);
            rule__ParserRule__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2_2__1_in_rule__ParserRule__Group_2_2__06108);
            rule__ParserRule__Group_2_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_2_2__0"


    // $ANTLR start "rule__ParserRule__Group_2_2__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2979:1: rule__ParserRule__Group_2_2__0__Impl : ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) ) ;
    public final void rule__ParserRule__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2983:1: ( ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2984:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2984:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2985:1: ( rule__ParserRule__HiddenTokensAssignment_2_2_0 )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_2_2_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2986:1: ( rule__ParserRule__HiddenTokensAssignment_2_2_0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2986:2: rule__ParserRule__HiddenTokensAssignment_2_2_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__HiddenTokensAssignment_2_2_0_in_rule__ParserRule__Group_2_2__0__Impl6135);
            rule__ParserRule__HiddenTokensAssignment_2_2_0();

            state._fsp--;


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
    // $ANTLR end "rule__ParserRule__Group_2_2__0__Impl"


    // $ANTLR start "rule__ParserRule__Group_2_2__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2996:1: rule__ParserRule__Group_2_2__1 : rule__ParserRule__Group_2_2__1__Impl ;
    public final void rule__ParserRule__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3000:1: ( rule__ParserRule__Group_2_2__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3001:2: rule__ParserRule__Group_2_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2_2__1__Impl_in_rule__ParserRule__Group_2_2__16165);
            rule__ParserRule__Group_2_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_2_2__1"


    // $ANTLR start "rule__ParserRule__Group_2_2__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3007:1: rule__ParserRule__Group_2_2__1__Impl : ( ( rule__ParserRule__Group_2_2_1__0 )* ) ;
    public final void rule__ParserRule__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3011:1: ( ( ( rule__ParserRule__Group_2_2_1__0 )* ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3012:1: ( ( rule__ParserRule__Group_2_2_1__0 )* )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3012:1: ( ( rule__ParserRule__Group_2_2_1__0 )* )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3013:1: ( rule__ParserRule__Group_2_2_1__0 )*
            {
             before(grammarAccess.getParserRuleAccess().getGroup_2_2_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3014:1: ( rule__ParserRule__Group_2_2_1__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==19) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3014:2: rule__ParserRule__Group_2_2_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2_2_1__0_in_rule__ParserRule__Group_2_2__1__Impl6192);
            	    rule__ParserRule__Group_2_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
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
    // $ANTLR end "rule__ParserRule__Group_2_2__1__Impl"


    // $ANTLR start "rule__ParserRule__Group_2_2_1__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3028:1: rule__ParserRule__Group_2_2_1__0 : rule__ParserRule__Group_2_2_1__0__Impl rule__ParserRule__Group_2_2_1__1 ;
    public final void rule__ParserRule__Group_2_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3032:1: ( rule__ParserRule__Group_2_2_1__0__Impl rule__ParserRule__Group_2_2_1__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3033:2: rule__ParserRule__Group_2_2_1__0__Impl rule__ParserRule__Group_2_2_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2_2_1__0__Impl_in_rule__ParserRule__Group_2_2_1__06227);
            rule__ParserRule__Group_2_2_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2_2_1__1_in_rule__ParserRule__Group_2_2_1__06230);
            rule__ParserRule__Group_2_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_2_2_1__0"


    // $ANTLR start "rule__ParserRule__Group_2_2_1__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3040:1: rule__ParserRule__Group_2_2_1__0__Impl : ( ',' ) ;
    public final void rule__ParserRule__Group_2_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3044:1: ( ( ',' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3045:1: ( ',' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3045:1: ( ',' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3046:1: ','
            {
             before(grammarAccess.getParserRuleAccess().getCommaKeyword_2_2_1_0()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__ParserRule__Group_2_2_1__0__Impl6258); 
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
    // $ANTLR end "rule__ParserRule__Group_2_2_1__0__Impl"


    // $ANTLR start "rule__ParserRule__Group_2_2_1__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3059:1: rule__ParserRule__Group_2_2_1__1 : rule__ParserRule__Group_2_2_1__1__Impl ;
    public final void rule__ParserRule__Group_2_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3063:1: ( rule__ParserRule__Group_2_2_1__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3064:2: rule__ParserRule__Group_2_2_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2_2_1__1__Impl_in_rule__ParserRule__Group_2_2_1__16289);
            rule__ParserRule__Group_2_2_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_2_2_1__1"


    // $ANTLR start "rule__ParserRule__Group_2_2_1__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3070:1: rule__ParserRule__Group_2_2_1__1__Impl : ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) ) ;
    public final void rule__ParserRule__Group_2_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3074:1: ( ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3075:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3075:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3076:1: ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_2_2_1_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3077:1: ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3077:2: rule__ParserRule__HiddenTokensAssignment_2_2_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__HiddenTokensAssignment_2_2_1_1_in_rule__ParserRule__Group_2_2_1__1__Impl6316);
            rule__ParserRule__HiddenTokensAssignment_2_2_1_1();

            state._fsp--;


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
    // $ANTLR end "rule__ParserRule__Group_2_2_1__1__Impl"


    // $ANTLR start "rule__TypeRef__Group__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3091:1: rule__TypeRef__Group__0 : rule__TypeRef__Group__0__Impl rule__TypeRef__Group__1 ;
    public final void rule__TypeRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3095:1: ( rule__TypeRef__Group__0__Impl rule__TypeRef__Group__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3096:2: rule__TypeRef__Group__0__Impl rule__TypeRef__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeRef__Group__0__Impl_in_rule__TypeRef__Group__06350);
            rule__TypeRef__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TypeRef__Group__1_in_rule__TypeRef__Group__06353);
            rule__TypeRef__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRef__Group__0"


    // $ANTLR start "rule__TypeRef__Group__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3103:1: rule__TypeRef__Group__0__Impl : ( ( rule__TypeRef__Group_0__0 )? ) ;
    public final void rule__TypeRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3107:1: ( ( ( rule__TypeRef__Group_0__0 )? ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3108:1: ( ( rule__TypeRef__Group_0__0 )? )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3108:1: ( ( rule__TypeRef__Group_0__0 )? )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3109:1: ( rule__TypeRef__Group_0__0 )?
            {
             before(grammarAccess.getTypeRefAccess().getGroup_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3110:1: ( rule__TypeRef__Group_0__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_ID) ) {
                int LA29_1 = input.LA(2);

                if ( (LA29_1==29) ) {
                    alt29=1;
                }
            }
            switch (alt29) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3110:2: rule__TypeRef__Group_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TypeRef__Group_0__0_in_rule__TypeRef__Group__0__Impl6380);
                    rule__TypeRef__Group_0__0();

                    state._fsp--;


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
    // $ANTLR end "rule__TypeRef__Group__0__Impl"


    // $ANTLR start "rule__TypeRef__Group__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3120:1: rule__TypeRef__Group__1 : rule__TypeRef__Group__1__Impl ;
    public final void rule__TypeRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3124:1: ( rule__TypeRef__Group__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3125:2: rule__TypeRef__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeRef__Group__1__Impl_in_rule__TypeRef__Group__16411);
            rule__TypeRef__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRef__Group__1"


    // $ANTLR start "rule__TypeRef__Group__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3131:1: rule__TypeRef__Group__1__Impl : ( ( rule__TypeRef__ClassifierAssignment_1 ) ) ;
    public final void rule__TypeRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3135:1: ( ( ( rule__TypeRef__ClassifierAssignment_1 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3136:1: ( ( rule__TypeRef__ClassifierAssignment_1 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3136:1: ( ( rule__TypeRef__ClassifierAssignment_1 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3137:1: ( rule__TypeRef__ClassifierAssignment_1 )
            {
             before(grammarAccess.getTypeRefAccess().getClassifierAssignment_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3138:1: ( rule__TypeRef__ClassifierAssignment_1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3138:2: rule__TypeRef__ClassifierAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeRef__ClassifierAssignment_1_in_rule__TypeRef__Group__1__Impl6438);
            rule__TypeRef__ClassifierAssignment_1();

            state._fsp--;


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
    // $ANTLR end "rule__TypeRef__Group__1__Impl"


    // $ANTLR start "rule__TypeRef__Group_0__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3152:1: rule__TypeRef__Group_0__0 : rule__TypeRef__Group_0__0__Impl rule__TypeRef__Group_0__1 ;
    public final void rule__TypeRef__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3156:1: ( rule__TypeRef__Group_0__0__Impl rule__TypeRef__Group_0__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3157:2: rule__TypeRef__Group_0__0__Impl rule__TypeRef__Group_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeRef__Group_0__0__Impl_in_rule__TypeRef__Group_0__06472);
            rule__TypeRef__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TypeRef__Group_0__1_in_rule__TypeRef__Group_0__06475);
            rule__TypeRef__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRef__Group_0__0"


    // $ANTLR start "rule__TypeRef__Group_0__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3164:1: rule__TypeRef__Group_0__0__Impl : ( ( rule__TypeRef__MetamodelAssignment_0_0 ) ) ;
    public final void rule__TypeRef__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3168:1: ( ( ( rule__TypeRef__MetamodelAssignment_0_0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3169:1: ( ( rule__TypeRef__MetamodelAssignment_0_0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3169:1: ( ( rule__TypeRef__MetamodelAssignment_0_0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3170:1: ( rule__TypeRef__MetamodelAssignment_0_0 )
            {
             before(grammarAccess.getTypeRefAccess().getMetamodelAssignment_0_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3171:1: ( rule__TypeRef__MetamodelAssignment_0_0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3171:2: rule__TypeRef__MetamodelAssignment_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeRef__MetamodelAssignment_0_0_in_rule__TypeRef__Group_0__0__Impl6502);
            rule__TypeRef__MetamodelAssignment_0_0();

            state._fsp--;


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
    // $ANTLR end "rule__TypeRef__Group_0__0__Impl"


    // $ANTLR start "rule__TypeRef__Group_0__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3181:1: rule__TypeRef__Group_0__1 : rule__TypeRef__Group_0__1__Impl ;
    public final void rule__TypeRef__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3185:1: ( rule__TypeRef__Group_0__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3186:2: rule__TypeRef__Group_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeRef__Group_0__1__Impl_in_rule__TypeRef__Group_0__16532);
            rule__TypeRef__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRef__Group_0__1"


    // $ANTLR start "rule__TypeRef__Group_0__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3192:1: rule__TypeRef__Group_0__1__Impl : ( '::' ) ;
    public final void rule__TypeRef__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3196:1: ( ( '::' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3197:1: ( '::' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3197:1: ( '::' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3198:1: '::'
            {
             before(grammarAccess.getTypeRefAccess().getColonColonKeyword_0_1()); 
            match(input,29,FollowSets000.FOLLOW_29_in_rule__TypeRef__Group_0__1__Impl6560); 
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
    // $ANTLR end "rule__TypeRef__Group_0__1__Impl"


    // $ANTLR start "rule__Alternatives__Group__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3215:1: rule__Alternatives__Group__0 : rule__Alternatives__Group__0__Impl rule__Alternatives__Group__1 ;
    public final void rule__Alternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3219:1: ( rule__Alternatives__Group__0__Impl rule__Alternatives__Group__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3220:2: rule__Alternatives__Group__0__Impl rule__Alternatives__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group__0__Impl_in_rule__Alternatives__Group__06595);
            rule__Alternatives__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group__1_in_rule__Alternatives__Group__06598);
            rule__Alternatives__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternatives__Group__0"


    // $ANTLR start "rule__Alternatives__Group__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3227:1: rule__Alternatives__Group__0__Impl : ( ruleUnorderedGroup ) ;
    public final void rule__Alternatives__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3231:1: ( ( ruleUnorderedGroup ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3232:1: ( ruleUnorderedGroup )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3232:1: ( ruleUnorderedGroup )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3233:1: ruleUnorderedGroup
            {
             before(grammarAccess.getAlternativesAccess().getUnorderedGroupParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnorderedGroup_in_rule__Alternatives__Group__0__Impl6625);
            ruleUnorderedGroup();

            state._fsp--;

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
    // $ANTLR end "rule__Alternatives__Group__0__Impl"


    // $ANTLR start "rule__Alternatives__Group__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3244:1: rule__Alternatives__Group__1 : rule__Alternatives__Group__1__Impl ;
    public final void rule__Alternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3248:1: ( rule__Alternatives__Group__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3249:2: rule__Alternatives__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group__1__Impl_in_rule__Alternatives__Group__16654);
            rule__Alternatives__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternatives__Group__1"


    // $ANTLR start "rule__Alternatives__Group__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3255:1: rule__Alternatives__Group__1__Impl : ( ( rule__Alternatives__Group_1__0 )? ) ;
    public final void rule__Alternatives__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3259:1: ( ( ( rule__Alternatives__Group_1__0 )? ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3260:1: ( ( rule__Alternatives__Group_1__0 )? )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3260:1: ( ( rule__Alternatives__Group_1__0 )? )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3261:1: ( rule__Alternatives__Group_1__0 )?
            {
             before(grammarAccess.getAlternativesAccess().getGroup_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3262:1: ( rule__Alternatives__Group_1__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==30) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3262:2: rule__Alternatives__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group_1__0_in_rule__Alternatives__Group__1__Impl6681);
                    rule__Alternatives__Group_1__0();

                    state._fsp--;


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
    // $ANTLR end "rule__Alternatives__Group__1__Impl"


    // $ANTLR start "rule__Alternatives__Group_1__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3276:1: rule__Alternatives__Group_1__0 : rule__Alternatives__Group_1__0__Impl rule__Alternatives__Group_1__1 ;
    public final void rule__Alternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3280:1: ( rule__Alternatives__Group_1__0__Impl rule__Alternatives__Group_1__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3281:2: rule__Alternatives__Group_1__0__Impl rule__Alternatives__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group_1__0__Impl_in_rule__Alternatives__Group_1__06716);
            rule__Alternatives__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group_1__1_in_rule__Alternatives__Group_1__06719);
            rule__Alternatives__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternatives__Group_1__0"


    // $ANTLR start "rule__Alternatives__Group_1__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3288:1: rule__Alternatives__Group_1__0__Impl : ( () ) ;
    public final void rule__Alternatives__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3292:1: ( ( () ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3293:1: ( () )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3293:1: ( () )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3294:1: ()
            {
             before(grammarAccess.getAlternativesAccess().getAlternativesElementsAction_1_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3295:1: ()
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3297:1: 
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
    // $ANTLR end "rule__Alternatives__Group_1__0__Impl"


    // $ANTLR start "rule__Alternatives__Group_1__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3307:1: rule__Alternatives__Group_1__1 : rule__Alternatives__Group_1__1__Impl ;
    public final void rule__Alternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3311:1: ( rule__Alternatives__Group_1__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3312:2: rule__Alternatives__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group_1__1__Impl_in_rule__Alternatives__Group_1__16777);
            rule__Alternatives__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternatives__Group_1__1"


    // $ANTLR start "rule__Alternatives__Group_1__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3318:1: rule__Alternatives__Group_1__1__Impl : ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) ) ;
    public final void rule__Alternatives__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3322:1: ( ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3323:1: ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3323:1: ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3324:1: ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3324:1: ( ( rule__Alternatives__Group_1_1__0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3325:1: ( rule__Alternatives__Group_1_1__0 )
            {
             before(grammarAccess.getAlternativesAccess().getGroup_1_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3326:1: ( rule__Alternatives__Group_1_1__0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3326:2: rule__Alternatives__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group_1_1__0_in_rule__Alternatives__Group_1__1__Impl6806);
            rule__Alternatives__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getAlternativesAccess().getGroup_1_1()); 

            }

            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3329:1: ( ( rule__Alternatives__Group_1_1__0 )* )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3330:1: ( rule__Alternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getAlternativesAccess().getGroup_1_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3331:1: ( rule__Alternatives__Group_1_1__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==30) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3331:2: rule__Alternatives__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group_1_1__0_in_rule__Alternatives__Group_1__1__Impl6818);
            	    rule__Alternatives__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
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
    // $ANTLR end "rule__Alternatives__Group_1__1__Impl"


    // $ANTLR start "rule__Alternatives__Group_1_1__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3346:1: rule__Alternatives__Group_1_1__0 : rule__Alternatives__Group_1_1__0__Impl rule__Alternatives__Group_1_1__1 ;
    public final void rule__Alternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3350:1: ( rule__Alternatives__Group_1_1__0__Impl rule__Alternatives__Group_1_1__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3351:2: rule__Alternatives__Group_1_1__0__Impl rule__Alternatives__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group_1_1__0__Impl_in_rule__Alternatives__Group_1_1__06855);
            rule__Alternatives__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group_1_1__1_in_rule__Alternatives__Group_1_1__06858);
            rule__Alternatives__Group_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternatives__Group_1_1__0"


    // $ANTLR start "rule__Alternatives__Group_1_1__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3358:1: rule__Alternatives__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__Alternatives__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3362:1: ( ( '|' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3363:1: ( '|' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3363:1: ( '|' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3364:1: '|'
            {
             before(grammarAccess.getAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__Alternatives__Group_1_1__0__Impl6886); 
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
    // $ANTLR end "rule__Alternatives__Group_1_1__0__Impl"


    // $ANTLR start "rule__Alternatives__Group_1_1__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3377:1: rule__Alternatives__Group_1_1__1 : rule__Alternatives__Group_1_1__1__Impl ;
    public final void rule__Alternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3381:1: ( rule__Alternatives__Group_1_1__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3382:2: rule__Alternatives__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group_1_1__1__Impl_in_rule__Alternatives__Group_1_1__16917);
            rule__Alternatives__Group_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternatives__Group_1_1__1"


    // $ANTLR start "rule__Alternatives__Group_1_1__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3388:1: rule__Alternatives__Group_1_1__1__Impl : ( ( rule__Alternatives__ElementsAssignment_1_1_1 ) ) ;
    public final void rule__Alternatives__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3392:1: ( ( ( rule__Alternatives__ElementsAssignment_1_1_1 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3393:1: ( ( rule__Alternatives__ElementsAssignment_1_1_1 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3393:1: ( ( rule__Alternatives__ElementsAssignment_1_1_1 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3394:1: ( rule__Alternatives__ElementsAssignment_1_1_1 )
            {
             before(grammarAccess.getAlternativesAccess().getElementsAssignment_1_1_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3395:1: ( rule__Alternatives__ElementsAssignment_1_1_1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3395:2: rule__Alternatives__ElementsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__ElementsAssignment_1_1_1_in_rule__Alternatives__Group_1_1__1__Impl6944);
            rule__Alternatives__ElementsAssignment_1_1_1();

            state._fsp--;


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
    // $ANTLR end "rule__Alternatives__Group_1_1__1__Impl"


    // $ANTLR start "rule__UnorderedGroup__Group__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3409:1: rule__UnorderedGroup__Group__0 : rule__UnorderedGroup__Group__0__Impl rule__UnorderedGroup__Group__1 ;
    public final void rule__UnorderedGroup__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3413:1: ( rule__UnorderedGroup__Group__0__Impl rule__UnorderedGroup__Group__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3414:2: rule__UnorderedGroup__Group__0__Impl rule__UnorderedGroup__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__UnorderedGroup__Group__0__Impl_in_rule__UnorderedGroup__Group__06978);
            rule__UnorderedGroup__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__UnorderedGroup__Group__1_in_rule__UnorderedGroup__Group__06981);
            rule__UnorderedGroup__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedGroup__Group__0"


    // $ANTLR start "rule__UnorderedGroup__Group__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3421:1: rule__UnorderedGroup__Group__0__Impl : ( ruleGroup ) ;
    public final void rule__UnorderedGroup__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3425:1: ( ( ruleGroup ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3426:1: ( ruleGroup )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3426:1: ( ruleGroup )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3427:1: ruleGroup
            {
             before(grammarAccess.getUnorderedGroupAccess().getGroupParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleGroup_in_rule__UnorderedGroup__Group__0__Impl7008);
            ruleGroup();

            state._fsp--;

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
    // $ANTLR end "rule__UnorderedGroup__Group__0__Impl"


    // $ANTLR start "rule__UnorderedGroup__Group__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3438:1: rule__UnorderedGroup__Group__1 : rule__UnorderedGroup__Group__1__Impl ;
    public final void rule__UnorderedGroup__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3442:1: ( rule__UnorderedGroup__Group__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3443:2: rule__UnorderedGroup__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__UnorderedGroup__Group__1__Impl_in_rule__UnorderedGroup__Group__17037);
            rule__UnorderedGroup__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedGroup__Group__1"


    // $ANTLR start "rule__UnorderedGroup__Group__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3449:1: rule__UnorderedGroup__Group__1__Impl : ( ( rule__UnorderedGroup__Group_1__0 )? ) ;
    public final void rule__UnorderedGroup__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3453:1: ( ( ( rule__UnorderedGroup__Group_1__0 )? ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3454:1: ( ( rule__UnorderedGroup__Group_1__0 )? )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3454:1: ( ( rule__UnorderedGroup__Group_1__0 )? )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3455:1: ( rule__UnorderedGroup__Group_1__0 )?
            {
             before(grammarAccess.getUnorderedGroupAccess().getGroup_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3456:1: ( rule__UnorderedGroup__Group_1__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==31) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3456:2: rule__UnorderedGroup__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__UnorderedGroup__Group_1__0_in_rule__UnorderedGroup__Group__1__Impl7064);
                    rule__UnorderedGroup__Group_1__0();

                    state._fsp--;


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
    // $ANTLR end "rule__UnorderedGroup__Group__1__Impl"


    // $ANTLR start "rule__UnorderedGroup__Group_1__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3470:1: rule__UnorderedGroup__Group_1__0 : rule__UnorderedGroup__Group_1__0__Impl rule__UnorderedGroup__Group_1__1 ;
    public final void rule__UnorderedGroup__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3474:1: ( rule__UnorderedGroup__Group_1__0__Impl rule__UnorderedGroup__Group_1__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3475:2: rule__UnorderedGroup__Group_1__0__Impl rule__UnorderedGroup__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__UnorderedGroup__Group_1__0__Impl_in_rule__UnorderedGroup__Group_1__07099);
            rule__UnorderedGroup__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__UnorderedGroup__Group_1__1_in_rule__UnorderedGroup__Group_1__07102);
            rule__UnorderedGroup__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedGroup__Group_1__0"


    // $ANTLR start "rule__UnorderedGroup__Group_1__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3482:1: rule__UnorderedGroup__Group_1__0__Impl : ( () ) ;
    public final void rule__UnorderedGroup__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3486:1: ( ( () ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3487:1: ( () )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3487:1: ( () )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3488:1: ()
            {
             before(grammarAccess.getUnorderedGroupAccess().getUnorderedGroupElementsAction_1_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3489:1: ()
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3491:1: 
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
    // $ANTLR end "rule__UnorderedGroup__Group_1__0__Impl"


    // $ANTLR start "rule__UnorderedGroup__Group_1__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3501:1: rule__UnorderedGroup__Group_1__1 : rule__UnorderedGroup__Group_1__1__Impl ;
    public final void rule__UnorderedGroup__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3505:1: ( rule__UnorderedGroup__Group_1__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3506:2: rule__UnorderedGroup__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__UnorderedGroup__Group_1__1__Impl_in_rule__UnorderedGroup__Group_1__17160);
            rule__UnorderedGroup__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedGroup__Group_1__1"


    // $ANTLR start "rule__UnorderedGroup__Group_1__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3512:1: rule__UnorderedGroup__Group_1__1__Impl : ( ( ( rule__UnorderedGroup__Group_1_1__0 ) ) ( ( rule__UnorderedGroup__Group_1_1__0 )* ) ) ;
    public final void rule__UnorderedGroup__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3516:1: ( ( ( ( rule__UnorderedGroup__Group_1_1__0 ) ) ( ( rule__UnorderedGroup__Group_1_1__0 )* ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3517:1: ( ( ( rule__UnorderedGroup__Group_1_1__0 ) ) ( ( rule__UnorderedGroup__Group_1_1__0 )* ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3517:1: ( ( ( rule__UnorderedGroup__Group_1_1__0 ) ) ( ( rule__UnorderedGroup__Group_1_1__0 )* ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3518:1: ( ( rule__UnorderedGroup__Group_1_1__0 ) ) ( ( rule__UnorderedGroup__Group_1_1__0 )* )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3518:1: ( ( rule__UnorderedGroup__Group_1_1__0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3519:1: ( rule__UnorderedGroup__Group_1_1__0 )
            {
             before(grammarAccess.getUnorderedGroupAccess().getGroup_1_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3520:1: ( rule__UnorderedGroup__Group_1_1__0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3520:2: rule__UnorderedGroup__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__UnorderedGroup__Group_1_1__0_in_rule__UnorderedGroup__Group_1__1__Impl7189);
            rule__UnorderedGroup__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getUnorderedGroupAccess().getGroup_1_1()); 

            }

            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3523:1: ( ( rule__UnorderedGroup__Group_1_1__0 )* )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3524:1: ( rule__UnorderedGroup__Group_1_1__0 )*
            {
             before(grammarAccess.getUnorderedGroupAccess().getGroup_1_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3525:1: ( rule__UnorderedGroup__Group_1_1__0 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==31) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3525:2: rule__UnorderedGroup__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__UnorderedGroup__Group_1_1__0_in_rule__UnorderedGroup__Group_1__1__Impl7201);
            	    rule__UnorderedGroup__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop33;
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
    // $ANTLR end "rule__UnorderedGroup__Group_1__1__Impl"


    // $ANTLR start "rule__UnorderedGroup__Group_1_1__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3540:1: rule__UnorderedGroup__Group_1_1__0 : rule__UnorderedGroup__Group_1_1__0__Impl rule__UnorderedGroup__Group_1_1__1 ;
    public final void rule__UnorderedGroup__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3544:1: ( rule__UnorderedGroup__Group_1_1__0__Impl rule__UnorderedGroup__Group_1_1__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3545:2: rule__UnorderedGroup__Group_1_1__0__Impl rule__UnorderedGroup__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__UnorderedGroup__Group_1_1__0__Impl_in_rule__UnorderedGroup__Group_1_1__07238);
            rule__UnorderedGroup__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__UnorderedGroup__Group_1_1__1_in_rule__UnorderedGroup__Group_1_1__07241);
            rule__UnorderedGroup__Group_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedGroup__Group_1_1__0"


    // $ANTLR start "rule__UnorderedGroup__Group_1_1__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3552:1: rule__UnorderedGroup__Group_1_1__0__Impl : ( '&' ) ;
    public final void rule__UnorderedGroup__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3556:1: ( ( '&' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3557:1: ( '&' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3557:1: ( '&' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3558:1: '&'
            {
             before(grammarAccess.getUnorderedGroupAccess().getAmpersandKeyword_1_1_0()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__UnorderedGroup__Group_1_1__0__Impl7269); 
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
    // $ANTLR end "rule__UnorderedGroup__Group_1_1__0__Impl"


    // $ANTLR start "rule__UnorderedGroup__Group_1_1__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3571:1: rule__UnorderedGroup__Group_1_1__1 : rule__UnorderedGroup__Group_1_1__1__Impl ;
    public final void rule__UnorderedGroup__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3575:1: ( rule__UnorderedGroup__Group_1_1__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3576:2: rule__UnorderedGroup__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__UnorderedGroup__Group_1_1__1__Impl_in_rule__UnorderedGroup__Group_1_1__17300);
            rule__UnorderedGroup__Group_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedGroup__Group_1_1__1"


    // $ANTLR start "rule__UnorderedGroup__Group_1_1__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3582:1: rule__UnorderedGroup__Group_1_1__1__Impl : ( ( rule__UnorderedGroup__ElementsAssignment_1_1_1 ) ) ;
    public final void rule__UnorderedGroup__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3586:1: ( ( ( rule__UnorderedGroup__ElementsAssignment_1_1_1 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3587:1: ( ( rule__UnorderedGroup__ElementsAssignment_1_1_1 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3587:1: ( ( rule__UnorderedGroup__ElementsAssignment_1_1_1 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3588:1: ( rule__UnorderedGroup__ElementsAssignment_1_1_1 )
            {
             before(grammarAccess.getUnorderedGroupAccess().getElementsAssignment_1_1_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3589:1: ( rule__UnorderedGroup__ElementsAssignment_1_1_1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3589:2: rule__UnorderedGroup__ElementsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__UnorderedGroup__ElementsAssignment_1_1_1_in_rule__UnorderedGroup__Group_1_1__1__Impl7327);
            rule__UnorderedGroup__ElementsAssignment_1_1_1();

            state._fsp--;


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
    // $ANTLR end "rule__UnorderedGroup__Group_1_1__1__Impl"


    // $ANTLR start "rule__Group__Group__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3603:1: rule__Group__Group__0 : rule__Group__Group__0__Impl rule__Group__Group__1 ;
    public final void rule__Group__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3607:1: ( rule__Group__Group__0__Impl rule__Group__Group__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3608:2: rule__Group__Group__0__Impl rule__Group__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Group__Group__0__Impl_in_rule__Group__Group__07361);
            rule__Group__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Group__Group__1_in_rule__Group__Group__07364);
            rule__Group__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__0"


    // $ANTLR start "rule__Group__Group__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3615:1: rule__Group__Group__0__Impl : ( ruleAbstractToken ) ;
    public final void rule__Group__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3619:1: ( ( ruleAbstractToken ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3620:1: ( ruleAbstractToken )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3620:1: ( ruleAbstractToken )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3621:1: ruleAbstractToken
            {
             before(grammarAccess.getGroupAccess().getAbstractTokenParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractToken_in_rule__Group__Group__0__Impl7391);
            ruleAbstractToken();

            state._fsp--;

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
    // $ANTLR end "rule__Group__Group__0__Impl"


    // $ANTLR start "rule__Group__Group__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3632:1: rule__Group__Group__1 : rule__Group__Group__1__Impl ;
    public final void rule__Group__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3636:1: ( rule__Group__Group__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3637:2: rule__Group__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Group__Group__1__Impl_in_rule__Group__Group__17420);
            rule__Group__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__1"


    // $ANTLR start "rule__Group__Group__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3643:1: rule__Group__Group__1__Impl : ( ( rule__Group__Group_1__0 )? ) ;
    public final void rule__Group__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3647:1: ( ( ( rule__Group__Group_1__0 )? ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3648:1: ( ( rule__Group__Group_1__0 )? )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3648:1: ( ( rule__Group__Group_1__0 )? )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3649:1: ( rule__Group__Group_1__0 )?
            {
             before(grammarAccess.getGroupAccess().getGroup_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3650:1: ( rule__Group__Group_1__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0>=RULE_ID && LA34_0<=RULE_STRING)||LA34_0==20||LA34_0==32) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3650:2: rule__Group__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Group__Group_1__0_in_rule__Group__Group__1__Impl7447);
                    rule__Group__Group_1__0();

                    state._fsp--;


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
    // $ANTLR end "rule__Group__Group__1__Impl"


    // $ANTLR start "rule__Group__Group_1__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3664:1: rule__Group__Group_1__0 : rule__Group__Group_1__0__Impl rule__Group__Group_1__1 ;
    public final void rule__Group__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3668:1: ( rule__Group__Group_1__0__Impl rule__Group__Group_1__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3669:2: rule__Group__Group_1__0__Impl rule__Group__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Group__Group_1__0__Impl_in_rule__Group__Group_1__07482);
            rule__Group__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Group__Group_1__1_in_rule__Group__Group_1__07485);
            rule__Group__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group_1__0"


    // $ANTLR start "rule__Group__Group_1__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3676:1: rule__Group__Group_1__0__Impl : ( () ) ;
    public final void rule__Group__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3680:1: ( ( () ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3681:1: ( () )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3681:1: ( () )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3682:1: ()
            {
             before(grammarAccess.getGroupAccess().getGroupElementsAction_1_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3683:1: ()
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3685:1: 
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
    // $ANTLR end "rule__Group__Group_1__0__Impl"


    // $ANTLR start "rule__Group__Group_1__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3695:1: rule__Group__Group_1__1 : rule__Group__Group_1__1__Impl ;
    public final void rule__Group__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3699:1: ( rule__Group__Group_1__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3700:2: rule__Group__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Group__Group_1__1__Impl_in_rule__Group__Group_1__17543);
            rule__Group__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group_1__1"


    // $ANTLR start "rule__Group__Group_1__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3706:1: rule__Group__Group_1__1__Impl : ( ( ( rule__Group__ElementsAssignment_1_1 ) ) ( ( rule__Group__ElementsAssignment_1_1 )* ) ) ;
    public final void rule__Group__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3710:1: ( ( ( ( rule__Group__ElementsAssignment_1_1 ) ) ( ( rule__Group__ElementsAssignment_1_1 )* ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3711:1: ( ( ( rule__Group__ElementsAssignment_1_1 ) ) ( ( rule__Group__ElementsAssignment_1_1 )* ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3711:1: ( ( ( rule__Group__ElementsAssignment_1_1 ) ) ( ( rule__Group__ElementsAssignment_1_1 )* ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3712:1: ( ( rule__Group__ElementsAssignment_1_1 ) ) ( ( rule__Group__ElementsAssignment_1_1 )* )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3712:1: ( ( rule__Group__ElementsAssignment_1_1 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3713:1: ( rule__Group__ElementsAssignment_1_1 )
            {
             before(grammarAccess.getGroupAccess().getElementsAssignment_1_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3714:1: ( rule__Group__ElementsAssignment_1_1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3714:2: rule__Group__ElementsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Group__ElementsAssignment_1_1_in_rule__Group__Group_1__1__Impl7572);
            rule__Group__ElementsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getGroupAccess().getElementsAssignment_1_1()); 

            }

            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3717:1: ( ( rule__Group__ElementsAssignment_1_1 )* )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3718:1: ( rule__Group__ElementsAssignment_1_1 )*
            {
             before(grammarAccess.getGroupAccess().getElementsAssignment_1_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3719:1: ( rule__Group__ElementsAssignment_1_1 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( ((LA35_0>=RULE_ID && LA35_0<=RULE_STRING)||LA35_0==20||LA35_0==32) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3719:2: rule__Group__ElementsAssignment_1_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Group__ElementsAssignment_1_1_in_rule__Group__Group_1__1__Impl7584);
            	    rule__Group__ElementsAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop35;
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
    // $ANTLR end "rule__Group__Group_1__1__Impl"


    // $ANTLR start "rule__AbstractTokenWithCardinality__Group__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3734:1: rule__AbstractTokenWithCardinality__Group__0 : rule__AbstractTokenWithCardinality__Group__0__Impl rule__AbstractTokenWithCardinality__Group__1 ;
    public final void rule__AbstractTokenWithCardinality__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3738:1: ( rule__AbstractTokenWithCardinality__Group__0__Impl rule__AbstractTokenWithCardinality__Group__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3739:2: rule__AbstractTokenWithCardinality__Group__0__Impl rule__AbstractTokenWithCardinality__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractTokenWithCardinality__Group__0__Impl_in_rule__AbstractTokenWithCardinality__Group__07621);
            rule__AbstractTokenWithCardinality__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AbstractTokenWithCardinality__Group__1_in_rule__AbstractTokenWithCardinality__Group__07624);
            rule__AbstractTokenWithCardinality__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractTokenWithCardinality__Group__0"


    // $ANTLR start "rule__AbstractTokenWithCardinality__Group__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3746:1: rule__AbstractTokenWithCardinality__Group__0__Impl : ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) ) ;
    public final void rule__AbstractTokenWithCardinality__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3750:1: ( ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3751:1: ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3751:1: ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3752:1: ( rule__AbstractTokenWithCardinality__Alternatives_0 )
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getAlternatives_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3753:1: ( rule__AbstractTokenWithCardinality__Alternatives_0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3753:2: rule__AbstractTokenWithCardinality__Alternatives_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractTokenWithCardinality__Alternatives_0_in_rule__AbstractTokenWithCardinality__Group__0__Impl7651);
            rule__AbstractTokenWithCardinality__Alternatives_0();

            state._fsp--;


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
    // $ANTLR end "rule__AbstractTokenWithCardinality__Group__0__Impl"


    // $ANTLR start "rule__AbstractTokenWithCardinality__Group__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3763:1: rule__AbstractTokenWithCardinality__Group__1 : rule__AbstractTokenWithCardinality__Group__1__Impl ;
    public final void rule__AbstractTokenWithCardinality__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3767:1: ( rule__AbstractTokenWithCardinality__Group__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3768:2: rule__AbstractTokenWithCardinality__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractTokenWithCardinality__Group__1__Impl_in_rule__AbstractTokenWithCardinality__Group__17681);
            rule__AbstractTokenWithCardinality__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractTokenWithCardinality__Group__1"


    // $ANTLR start "rule__AbstractTokenWithCardinality__Group__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3774:1: rule__AbstractTokenWithCardinality__Group__1__Impl : ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? ) ;
    public final void rule__AbstractTokenWithCardinality__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3778:1: ( ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3779:1: ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3779:1: ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3780:1: ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )?
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAssignment_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3781:1: ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( ((LA36_0>=11 && LA36_0<=13)) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3781:2: rule__AbstractTokenWithCardinality__CardinalityAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__AbstractTokenWithCardinality__CardinalityAssignment_1_in_rule__AbstractTokenWithCardinality__Group__1__Impl7708);
                    rule__AbstractTokenWithCardinality__CardinalityAssignment_1();

                    state._fsp--;


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
    // $ANTLR end "rule__AbstractTokenWithCardinality__Group__1__Impl"


    // $ANTLR start "rule__Action__Group__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3795:1: rule__Action__Group__0 : rule__Action__Group__0__Impl rule__Action__Group__1 ;
    public final void rule__Action__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3799:1: ( rule__Action__Group__0__Impl rule__Action__Group__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3800:2: rule__Action__Group__0__Impl rule__Action__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__Group__0__Impl_in_rule__Action__Group__07743);
            rule__Action__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Action__Group__1_in_rule__Action__Group__07746);
            rule__Action__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__0"


    // $ANTLR start "rule__Action__Group__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3807:1: rule__Action__Group__0__Impl : ( '{' ) ;
    public final void rule__Action__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3811:1: ( ( '{' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3812:1: ( '{' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3812:1: ( '{' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3813:1: '{'
            {
             before(grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__Action__Group__0__Impl7774); 
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
    // $ANTLR end "rule__Action__Group__0__Impl"


    // $ANTLR start "rule__Action__Group__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3826:1: rule__Action__Group__1 : rule__Action__Group__1__Impl rule__Action__Group__2 ;
    public final void rule__Action__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3830:1: ( rule__Action__Group__1__Impl rule__Action__Group__2 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3831:2: rule__Action__Group__1__Impl rule__Action__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__Group__1__Impl_in_rule__Action__Group__17805);
            rule__Action__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Action__Group__2_in_rule__Action__Group__17808);
            rule__Action__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__1"


    // $ANTLR start "rule__Action__Group__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3838:1: rule__Action__Group__1__Impl : ( ( rule__Action__TypeAssignment_1 ) ) ;
    public final void rule__Action__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3842:1: ( ( ( rule__Action__TypeAssignment_1 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3843:1: ( ( rule__Action__TypeAssignment_1 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3843:1: ( ( rule__Action__TypeAssignment_1 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3844:1: ( rule__Action__TypeAssignment_1 )
            {
             before(grammarAccess.getActionAccess().getTypeAssignment_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3845:1: ( rule__Action__TypeAssignment_1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3845:2: rule__Action__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__TypeAssignment_1_in_rule__Action__Group__1__Impl7835);
            rule__Action__TypeAssignment_1();

            state._fsp--;


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
    // $ANTLR end "rule__Action__Group__1__Impl"


    // $ANTLR start "rule__Action__Group__2"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3855:1: rule__Action__Group__2 : rule__Action__Group__2__Impl rule__Action__Group__3 ;
    public final void rule__Action__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3859:1: ( rule__Action__Group__2__Impl rule__Action__Group__3 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3860:2: rule__Action__Group__2__Impl rule__Action__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__Group__2__Impl_in_rule__Action__Group__27865);
            rule__Action__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Action__Group__3_in_rule__Action__Group__27868);
            rule__Action__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__2"


    // $ANTLR start "rule__Action__Group__2__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3867:1: rule__Action__Group__2__Impl : ( ( rule__Action__Group_2__0 )? ) ;
    public final void rule__Action__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3871:1: ( ( ( rule__Action__Group_2__0 )? ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3872:1: ( ( rule__Action__Group_2__0 )? )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3872:1: ( ( rule__Action__Group_2__0 )? )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3873:1: ( rule__Action__Group_2__0 )?
            {
             before(grammarAccess.getActionAccess().getGroup_2()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3874:1: ( rule__Action__Group_2__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==22) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3874:2: rule__Action__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Action__Group_2__0_in_rule__Action__Group__2__Impl7895);
                    rule__Action__Group_2__0();

                    state._fsp--;


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
    // $ANTLR end "rule__Action__Group__2__Impl"


    // $ANTLR start "rule__Action__Group__3"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3884:1: rule__Action__Group__3 : rule__Action__Group__3__Impl ;
    public final void rule__Action__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3888:1: ( rule__Action__Group__3__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3889:2: rule__Action__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__Group__3__Impl_in_rule__Action__Group__37926);
            rule__Action__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__3"


    // $ANTLR start "rule__Action__Group__3__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3895:1: rule__Action__Group__3__Impl : ( '}' ) ;
    public final void rule__Action__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3899:1: ( ( '}' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3900:1: ( '}' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3900:1: ( '}' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3901:1: '}'
            {
             before(grammarAccess.getActionAccess().getRightCurlyBracketKeyword_3()); 
            match(input,33,FollowSets000.FOLLOW_33_in_rule__Action__Group__3__Impl7954); 
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
    // $ANTLR end "rule__Action__Group__3__Impl"


    // $ANTLR start "rule__Action__Group_2__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3922:1: rule__Action__Group_2__0 : rule__Action__Group_2__0__Impl rule__Action__Group_2__1 ;
    public final void rule__Action__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3926:1: ( rule__Action__Group_2__0__Impl rule__Action__Group_2__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3927:2: rule__Action__Group_2__0__Impl rule__Action__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__Group_2__0__Impl_in_rule__Action__Group_2__07993);
            rule__Action__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Action__Group_2__1_in_rule__Action__Group_2__07996);
            rule__Action__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_2__0"


    // $ANTLR start "rule__Action__Group_2__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3934:1: rule__Action__Group_2__0__Impl : ( '.' ) ;
    public final void rule__Action__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3938:1: ( ( '.' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3939:1: ( '.' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3939:1: ( '.' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3940:1: '.'
            {
             before(grammarAccess.getActionAccess().getFullStopKeyword_2_0()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__Action__Group_2__0__Impl8024); 
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
    // $ANTLR end "rule__Action__Group_2__0__Impl"


    // $ANTLR start "rule__Action__Group_2__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3953:1: rule__Action__Group_2__1 : rule__Action__Group_2__1__Impl rule__Action__Group_2__2 ;
    public final void rule__Action__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3957:1: ( rule__Action__Group_2__1__Impl rule__Action__Group_2__2 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3958:2: rule__Action__Group_2__1__Impl rule__Action__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__Group_2__1__Impl_in_rule__Action__Group_2__18055);
            rule__Action__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Action__Group_2__2_in_rule__Action__Group_2__18058);
            rule__Action__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_2__1"


    // $ANTLR start "rule__Action__Group_2__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3965:1: rule__Action__Group_2__1__Impl : ( ( rule__Action__FeatureAssignment_2_1 ) ) ;
    public final void rule__Action__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3969:1: ( ( ( rule__Action__FeatureAssignment_2_1 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3970:1: ( ( rule__Action__FeatureAssignment_2_1 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3970:1: ( ( rule__Action__FeatureAssignment_2_1 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3971:1: ( rule__Action__FeatureAssignment_2_1 )
            {
             before(grammarAccess.getActionAccess().getFeatureAssignment_2_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3972:1: ( rule__Action__FeatureAssignment_2_1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3972:2: rule__Action__FeatureAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__FeatureAssignment_2_1_in_rule__Action__Group_2__1__Impl8085);
            rule__Action__FeatureAssignment_2_1();

            state._fsp--;


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
    // $ANTLR end "rule__Action__Group_2__1__Impl"


    // $ANTLR start "rule__Action__Group_2__2"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3982:1: rule__Action__Group_2__2 : rule__Action__Group_2__2__Impl rule__Action__Group_2__3 ;
    public final void rule__Action__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3986:1: ( rule__Action__Group_2__2__Impl rule__Action__Group_2__3 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3987:2: rule__Action__Group_2__2__Impl rule__Action__Group_2__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__Group_2__2__Impl_in_rule__Action__Group_2__28115);
            rule__Action__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Action__Group_2__3_in_rule__Action__Group_2__28118);
            rule__Action__Group_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_2__2"


    // $ANTLR start "rule__Action__Group_2__2__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3994:1: rule__Action__Group_2__2__Impl : ( ( rule__Action__OperatorAssignment_2_2 ) ) ;
    public final void rule__Action__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3998:1: ( ( ( rule__Action__OperatorAssignment_2_2 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3999:1: ( ( rule__Action__OperatorAssignment_2_2 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3999:1: ( ( rule__Action__OperatorAssignment_2_2 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4000:1: ( rule__Action__OperatorAssignment_2_2 )
            {
             before(grammarAccess.getActionAccess().getOperatorAssignment_2_2()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4001:1: ( rule__Action__OperatorAssignment_2_2 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4001:2: rule__Action__OperatorAssignment_2_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__OperatorAssignment_2_2_in_rule__Action__Group_2__2__Impl8145);
            rule__Action__OperatorAssignment_2_2();

            state._fsp--;


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
    // $ANTLR end "rule__Action__Group_2__2__Impl"


    // $ANTLR start "rule__Action__Group_2__3"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4011:1: rule__Action__Group_2__3 : rule__Action__Group_2__3__Impl ;
    public final void rule__Action__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4015:1: ( rule__Action__Group_2__3__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4016:2: rule__Action__Group_2__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__Group_2__3__Impl_in_rule__Action__Group_2__38175);
            rule__Action__Group_2__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_2__3"


    // $ANTLR start "rule__Action__Group_2__3__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4022:1: rule__Action__Group_2__3__Impl : ( 'current' ) ;
    public final void rule__Action__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4026:1: ( ( 'current' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4027:1: ( 'current' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4027:1: ( 'current' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4028:1: 'current'
            {
             before(grammarAccess.getActionAccess().getCurrentKeyword_2_3()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__Action__Group_2__3__Impl8203); 
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
    // $ANTLR end "rule__Action__Group_2__3__Impl"


    // $ANTLR start "rule__Assignment__Group__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4049:1: rule__Assignment__Group__0 : rule__Assignment__Group__0__Impl rule__Assignment__Group__1 ;
    public final void rule__Assignment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4053:1: ( rule__Assignment__Group__0__Impl rule__Assignment__Group__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4054:2: rule__Assignment__Group__0__Impl rule__Assignment__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Assignment__Group__0__Impl_in_rule__Assignment__Group__08242);
            rule__Assignment__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Assignment__Group__1_in_rule__Assignment__Group__08245);
            rule__Assignment__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__0"


    // $ANTLR start "rule__Assignment__Group__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4061:1: rule__Assignment__Group__0__Impl : ( ( rule__Assignment__FeatureAssignment_0 ) ) ;
    public final void rule__Assignment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4065:1: ( ( ( rule__Assignment__FeatureAssignment_0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4066:1: ( ( rule__Assignment__FeatureAssignment_0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4066:1: ( ( rule__Assignment__FeatureAssignment_0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4067:1: ( rule__Assignment__FeatureAssignment_0 )
            {
             before(grammarAccess.getAssignmentAccess().getFeatureAssignment_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4068:1: ( rule__Assignment__FeatureAssignment_0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4068:2: rule__Assignment__FeatureAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Assignment__FeatureAssignment_0_in_rule__Assignment__Group__0__Impl8272);
            rule__Assignment__FeatureAssignment_0();

            state._fsp--;


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
    // $ANTLR end "rule__Assignment__Group__0__Impl"


    // $ANTLR start "rule__Assignment__Group__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4078:1: rule__Assignment__Group__1 : rule__Assignment__Group__1__Impl rule__Assignment__Group__2 ;
    public final void rule__Assignment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4082:1: ( rule__Assignment__Group__1__Impl rule__Assignment__Group__2 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4083:2: rule__Assignment__Group__1__Impl rule__Assignment__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Assignment__Group__1__Impl_in_rule__Assignment__Group__18302);
            rule__Assignment__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Assignment__Group__2_in_rule__Assignment__Group__18305);
            rule__Assignment__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__1"


    // $ANTLR start "rule__Assignment__Group__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4090:1: rule__Assignment__Group__1__Impl : ( ( rule__Assignment__OperatorAssignment_1 ) ) ;
    public final void rule__Assignment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4094:1: ( ( ( rule__Assignment__OperatorAssignment_1 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4095:1: ( ( rule__Assignment__OperatorAssignment_1 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4095:1: ( ( rule__Assignment__OperatorAssignment_1 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4096:1: ( rule__Assignment__OperatorAssignment_1 )
            {
             before(grammarAccess.getAssignmentAccess().getOperatorAssignment_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4097:1: ( rule__Assignment__OperatorAssignment_1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4097:2: rule__Assignment__OperatorAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Assignment__OperatorAssignment_1_in_rule__Assignment__Group__1__Impl8332);
            rule__Assignment__OperatorAssignment_1();

            state._fsp--;


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
    // $ANTLR end "rule__Assignment__Group__1__Impl"


    // $ANTLR start "rule__Assignment__Group__2"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4107:1: rule__Assignment__Group__2 : rule__Assignment__Group__2__Impl ;
    public final void rule__Assignment__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4111:1: ( rule__Assignment__Group__2__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4112:2: rule__Assignment__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Assignment__Group__2__Impl_in_rule__Assignment__Group__28362);
            rule__Assignment__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__2"


    // $ANTLR start "rule__Assignment__Group__2__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4118:1: rule__Assignment__Group__2__Impl : ( ( rule__Assignment__TerminalAssignment_2 ) ) ;
    public final void rule__Assignment__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4122:1: ( ( ( rule__Assignment__TerminalAssignment_2 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4123:1: ( ( rule__Assignment__TerminalAssignment_2 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4123:1: ( ( rule__Assignment__TerminalAssignment_2 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4124:1: ( rule__Assignment__TerminalAssignment_2 )
            {
             before(grammarAccess.getAssignmentAccess().getTerminalAssignment_2()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4125:1: ( rule__Assignment__TerminalAssignment_2 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4125:2: rule__Assignment__TerminalAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Assignment__TerminalAssignment_2_in_rule__Assignment__Group__2__Impl8389);
            rule__Assignment__TerminalAssignment_2();

            state._fsp--;


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
    // $ANTLR end "rule__Assignment__Group__2__Impl"


    // $ANTLR start "rule__ParenthesizedAssignableElement__Group__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4141:1: rule__ParenthesizedAssignableElement__Group__0 : rule__ParenthesizedAssignableElement__Group__0__Impl rule__ParenthesizedAssignableElement__Group__1 ;
    public final void rule__ParenthesizedAssignableElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4145:1: ( rule__ParenthesizedAssignableElement__Group__0__Impl rule__ParenthesizedAssignableElement__Group__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4146:2: rule__ParenthesizedAssignableElement__Group__0__Impl rule__ParenthesizedAssignableElement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedAssignableElement__Group__0__Impl_in_rule__ParenthesizedAssignableElement__Group__08425);
            rule__ParenthesizedAssignableElement__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedAssignableElement__Group__1_in_rule__ParenthesizedAssignableElement__Group__08428);
            rule__ParenthesizedAssignableElement__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedAssignableElement__Group__0"


    // $ANTLR start "rule__ParenthesizedAssignableElement__Group__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4153:1: rule__ParenthesizedAssignableElement__Group__0__Impl : ( '(' ) ;
    public final void rule__ParenthesizedAssignableElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4157:1: ( ( '(' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4158:1: ( '(' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4158:1: ( '(' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4159:1: '('
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getLeftParenthesisKeyword_0()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__ParenthesizedAssignableElement__Group__0__Impl8456); 
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
    // $ANTLR end "rule__ParenthesizedAssignableElement__Group__0__Impl"


    // $ANTLR start "rule__ParenthesizedAssignableElement__Group__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4172:1: rule__ParenthesizedAssignableElement__Group__1 : rule__ParenthesizedAssignableElement__Group__1__Impl rule__ParenthesizedAssignableElement__Group__2 ;
    public final void rule__ParenthesizedAssignableElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4176:1: ( rule__ParenthesizedAssignableElement__Group__1__Impl rule__ParenthesizedAssignableElement__Group__2 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4177:2: rule__ParenthesizedAssignableElement__Group__1__Impl rule__ParenthesizedAssignableElement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedAssignableElement__Group__1__Impl_in_rule__ParenthesizedAssignableElement__Group__18487);
            rule__ParenthesizedAssignableElement__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedAssignableElement__Group__2_in_rule__ParenthesizedAssignableElement__Group__18490);
            rule__ParenthesizedAssignableElement__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedAssignableElement__Group__1"


    // $ANTLR start "rule__ParenthesizedAssignableElement__Group__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4184:1: rule__ParenthesizedAssignableElement__Group__1__Impl : ( ruleAssignableAlternatives ) ;
    public final void rule__ParenthesizedAssignableElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4188:1: ( ( ruleAssignableAlternatives ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4189:1: ( ruleAssignableAlternatives )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4189:1: ( ruleAssignableAlternatives )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4190:1: ruleAssignableAlternatives
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getAssignableAlternativesParserRuleCall_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableAlternatives_in_rule__ParenthesizedAssignableElement__Group__1__Impl8517);
            ruleAssignableAlternatives();

            state._fsp--;

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
    // $ANTLR end "rule__ParenthesizedAssignableElement__Group__1__Impl"


    // $ANTLR start "rule__ParenthesizedAssignableElement__Group__2"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4201:1: rule__ParenthesizedAssignableElement__Group__2 : rule__ParenthesizedAssignableElement__Group__2__Impl ;
    public final void rule__ParenthesizedAssignableElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4205:1: ( rule__ParenthesizedAssignableElement__Group__2__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4206:2: rule__ParenthesizedAssignableElement__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedAssignableElement__Group__2__Impl_in_rule__ParenthesizedAssignableElement__Group__28546);
            rule__ParenthesizedAssignableElement__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedAssignableElement__Group__2"


    // $ANTLR start "rule__ParenthesizedAssignableElement__Group__2__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4212:1: rule__ParenthesizedAssignableElement__Group__2__Impl : ( ')' ) ;
    public final void rule__ParenthesizedAssignableElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4216:1: ( ( ')' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4217:1: ( ')' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4217:1: ( ')' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4218:1: ')'
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getRightParenthesisKeyword_2()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__ParenthesizedAssignableElement__Group__2__Impl8574); 
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
    // $ANTLR end "rule__ParenthesizedAssignableElement__Group__2__Impl"


    // $ANTLR start "rule__AssignableAlternatives__Group__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4237:1: rule__AssignableAlternatives__Group__0 : rule__AssignableAlternatives__Group__0__Impl rule__AssignableAlternatives__Group__1 ;
    public final void rule__AssignableAlternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4241:1: ( rule__AssignableAlternatives__Group__0__Impl rule__AssignableAlternatives__Group__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4242:2: rule__AssignableAlternatives__Group__0__Impl rule__AssignableAlternatives__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group__0__Impl_in_rule__AssignableAlternatives__Group__08611);
            rule__AssignableAlternatives__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group__1_in_rule__AssignableAlternatives__Group__08614);
            rule__AssignableAlternatives__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignableAlternatives__Group__0"


    // $ANTLR start "rule__AssignableAlternatives__Group__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4249:1: rule__AssignableAlternatives__Group__0__Impl : ( ruleAssignableTerminal ) ;
    public final void rule__AssignableAlternatives__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4253:1: ( ( ruleAssignableTerminal ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4254:1: ( ruleAssignableTerminal )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4254:1: ( ruleAssignableTerminal )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4255:1: ruleAssignableTerminal
            {
             before(grammarAccess.getAssignableAlternativesAccess().getAssignableTerminalParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_rule__AssignableAlternatives__Group__0__Impl8641);
            ruleAssignableTerminal();

            state._fsp--;

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
    // $ANTLR end "rule__AssignableAlternatives__Group__0__Impl"


    // $ANTLR start "rule__AssignableAlternatives__Group__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4266:1: rule__AssignableAlternatives__Group__1 : rule__AssignableAlternatives__Group__1__Impl ;
    public final void rule__AssignableAlternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4270:1: ( rule__AssignableAlternatives__Group__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4271:2: rule__AssignableAlternatives__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group__1__Impl_in_rule__AssignableAlternatives__Group__18670);
            rule__AssignableAlternatives__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignableAlternatives__Group__1"


    // $ANTLR start "rule__AssignableAlternatives__Group__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4277:1: rule__AssignableAlternatives__Group__1__Impl : ( ( rule__AssignableAlternatives__Group_1__0 )? ) ;
    public final void rule__AssignableAlternatives__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4281:1: ( ( ( rule__AssignableAlternatives__Group_1__0 )? ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4282:1: ( ( rule__AssignableAlternatives__Group_1__0 )? )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4282:1: ( ( rule__AssignableAlternatives__Group_1__0 )? )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4283:1: ( rule__AssignableAlternatives__Group_1__0 )?
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4284:1: ( rule__AssignableAlternatives__Group_1__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==30) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4284:2: rule__AssignableAlternatives__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group_1__0_in_rule__AssignableAlternatives__Group__1__Impl8697);
                    rule__AssignableAlternatives__Group_1__0();

                    state._fsp--;


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
    // $ANTLR end "rule__AssignableAlternatives__Group__1__Impl"


    // $ANTLR start "rule__AssignableAlternatives__Group_1__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4298:1: rule__AssignableAlternatives__Group_1__0 : rule__AssignableAlternatives__Group_1__0__Impl rule__AssignableAlternatives__Group_1__1 ;
    public final void rule__AssignableAlternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4302:1: ( rule__AssignableAlternatives__Group_1__0__Impl rule__AssignableAlternatives__Group_1__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4303:2: rule__AssignableAlternatives__Group_1__0__Impl rule__AssignableAlternatives__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group_1__0__Impl_in_rule__AssignableAlternatives__Group_1__08732);
            rule__AssignableAlternatives__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group_1__1_in_rule__AssignableAlternatives__Group_1__08735);
            rule__AssignableAlternatives__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignableAlternatives__Group_1__0"


    // $ANTLR start "rule__AssignableAlternatives__Group_1__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4310:1: rule__AssignableAlternatives__Group_1__0__Impl : ( () ) ;
    public final void rule__AssignableAlternatives__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4314:1: ( ( () ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4315:1: ( () )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4315:1: ( () )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4316:1: ()
            {
             before(grammarAccess.getAssignableAlternativesAccess().getAlternativesElementsAction_1_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4317:1: ()
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4319:1: 
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
    // $ANTLR end "rule__AssignableAlternatives__Group_1__0__Impl"


    // $ANTLR start "rule__AssignableAlternatives__Group_1__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4329:1: rule__AssignableAlternatives__Group_1__1 : rule__AssignableAlternatives__Group_1__1__Impl ;
    public final void rule__AssignableAlternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4333:1: ( rule__AssignableAlternatives__Group_1__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4334:2: rule__AssignableAlternatives__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group_1__1__Impl_in_rule__AssignableAlternatives__Group_1__18793);
            rule__AssignableAlternatives__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignableAlternatives__Group_1__1"


    // $ANTLR start "rule__AssignableAlternatives__Group_1__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4340:1: rule__AssignableAlternatives__Group_1__1__Impl : ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) ) ;
    public final void rule__AssignableAlternatives__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4344:1: ( ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4345:1: ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4345:1: ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4346:1: ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4346:1: ( ( rule__AssignableAlternatives__Group_1_1__0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4347:1: ( rule__AssignableAlternatives__Group_1_1__0 )
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4348:1: ( rule__AssignableAlternatives__Group_1_1__0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4348:2: rule__AssignableAlternatives__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group_1_1__0_in_rule__AssignableAlternatives__Group_1__1__Impl8822);
            rule__AssignableAlternatives__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 

            }

            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4351:1: ( ( rule__AssignableAlternatives__Group_1_1__0 )* )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4352:1: ( rule__AssignableAlternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4353:1: ( rule__AssignableAlternatives__Group_1_1__0 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==30) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4353:2: rule__AssignableAlternatives__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group_1_1__0_in_rule__AssignableAlternatives__Group_1__1__Impl8834);
            	    rule__AssignableAlternatives__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop39;
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
    // $ANTLR end "rule__AssignableAlternatives__Group_1__1__Impl"


    // $ANTLR start "rule__AssignableAlternatives__Group_1_1__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4368:1: rule__AssignableAlternatives__Group_1_1__0 : rule__AssignableAlternatives__Group_1_1__0__Impl rule__AssignableAlternatives__Group_1_1__1 ;
    public final void rule__AssignableAlternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4372:1: ( rule__AssignableAlternatives__Group_1_1__0__Impl rule__AssignableAlternatives__Group_1_1__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4373:2: rule__AssignableAlternatives__Group_1_1__0__Impl rule__AssignableAlternatives__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group_1_1__0__Impl_in_rule__AssignableAlternatives__Group_1_1__08871);
            rule__AssignableAlternatives__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group_1_1__1_in_rule__AssignableAlternatives__Group_1_1__08874);
            rule__AssignableAlternatives__Group_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignableAlternatives__Group_1_1__0"


    // $ANTLR start "rule__AssignableAlternatives__Group_1_1__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4380:1: rule__AssignableAlternatives__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__AssignableAlternatives__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4384:1: ( ( '|' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4385:1: ( '|' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4385:1: ( '|' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4386:1: '|'
            {
             before(grammarAccess.getAssignableAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__AssignableAlternatives__Group_1_1__0__Impl8902); 
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
    // $ANTLR end "rule__AssignableAlternatives__Group_1_1__0__Impl"


    // $ANTLR start "rule__AssignableAlternatives__Group_1_1__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4399:1: rule__AssignableAlternatives__Group_1_1__1 : rule__AssignableAlternatives__Group_1_1__1__Impl ;
    public final void rule__AssignableAlternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4403:1: ( rule__AssignableAlternatives__Group_1_1__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4404:2: rule__AssignableAlternatives__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group_1_1__1__Impl_in_rule__AssignableAlternatives__Group_1_1__18933);
            rule__AssignableAlternatives__Group_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignableAlternatives__Group_1_1__1"


    // $ANTLR start "rule__AssignableAlternatives__Group_1_1__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4410:1: rule__AssignableAlternatives__Group_1_1__1__Impl : ( ( rule__AssignableAlternatives__ElementsAssignment_1_1_1 ) ) ;
    public final void rule__AssignableAlternatives__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4414:1: ( ( ( rule__AssignableAlternatives__ElementsAssignment_1_1_1 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4415:1: ( ( rule__AssignableAlternatives__ElementsAssignment_1_1_1 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4415:1: ( ( rule__AssignableAlternatives__ElementsAssignment_1_1_1 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4416:1: ( rule__AssignableAlternatives__ElementsAssignment_1_1_1 )
            {
             before(grammarAccess.getAssignableAlternativesAccess().getElementsAssignment_1_1_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4417:1: ( rule__AssignableAlternatives__ElementsAssignment_1_1_1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4417:2: rule__AssignableAlternatives__ElementsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__ElementsAssignment_1_1_1_in_rule__AssignableAlternatives__Group_1_1__1__Impl8960);
            rule__AssignableAlternatives__ElementsAssignment_1_1_1();

            state._fsp--;


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
    // $ANTLR end "rule__AssignableAlternatives__Group_1_1__1__Impl"


    // $ANTLR start "rule__CrossReference__Group__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4431:1: rule__CrossReference__Group__0 : rule__CrossReference__Group__0__Impl rule__CrossReference__Group__1 ;
    public final void rule__CrossReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4435:1: ( rule__CrossReference__Group__0__Impl rule__CrossReference__Group__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4436:2: rule__CrossReference__Group__0__Impl rule__CrossReference__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group__0__Impl_in_rule__CrossReference__Group__08994);
            rule__CrossReference__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group__1_in_rule__CrossReference__Group__08997);
            rule__CrossReference__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossReference__Group__0"


    // $ANTLR start "rule__CrossReference__Group__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4443:1: rule__CrossReference__Group__0__Impl : ( '[' ) ;
    public final void rule__CrossReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4447:1: ( ( '[' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4448:1: ( '[' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4448:1: ( '[' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4449:1: '['
            {
             before(grammarAccess.getCrossReferenceAccess().getLeftSquareBracketKeyword_0()); 
            match(input,35,FollowSets000.FOLLOW_35_in_rule__CrossReference__Group__0__Impl9025); 
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
    // $ANTLR end "rule__CrossReference__Group__0__Impl"


    // $ANTLR start "rule__CrossReference__Group__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4462:1: rule__CrossReference__Group__1 : rule__CrossReference__Group__1__Impl rule__CrossReference__Group__2 ;
    public final void rule__CrossReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4466:1: ( rule__CrossReference__Group__1__Impl rule__CrossReference__Group__2 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4467:2: rule__CrossReference__Group__1__Impl rule__CrossReference__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group__1__Impl_in_rule__CrossReference__Group__19056);
            rule__CrossReference__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group__2_in_rule__CrossReference__Group__19059);
            rule__CrossReference__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossReference__Group__1"


    // $ANTLR start "rule__CrossReference__Group__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4474:1: rule__CrossReference__Group__1__Impl : ( ( rule__CrossReference__TypeAssignment_1 ) ) ;
    public final void rule__CrossReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4478:1: ( ( ( rule__CrossReference__TypeAssignment_1 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4479:1: ( ( rule__CrossReference__TypeAssignment_1 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4479:1: ( ( rule__CrossReference__TypeAssignment_1 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4480:1: ( rule__CrossReference__TypeAssignment_1 )
            {
             before(grammarAccess.getCrossReferenceAccess().getTypeAssignment_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4481:1: ( rule__CrossReference__TypeAssignment_1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4481:2: rule__CrossReference__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__TypeAssignment_1_in_rule__CrossReference__Group__1__Impl9086);
            rule__CrossReference__TypeAssignment_1();

            state._fsp--;


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
    // $ANTLR end "rule__CrossReference__Group__1__Impl"


    // $ANTLR start "rule__CrossReference__Group__2"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4491:1: rule__CrossReference__Group__2 : rule__CrossReference__Group__2__Impl rule__CrossReference__Group__3 ;
    public final void rule__CrossReference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4495:1: ( rule__CrossReference__Group__2__Impl rule__CrossReference__Group__3 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4496:2: rule__CrossReference__Group__2__Impl rule__CrossReference__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group__2__Impl_in_rule__CrossReference__Group__29116);
            rule__CrossReference__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group__3_in_rule__CrossReference__Group__29119);
            rule__CrossReference__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossReference__Group__2"


    // $ANTLR start "rule__CrossReference__Group__2__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4503:1: rule__CrossReference__Group__2__Impl : ( ( rule__CrossReference__Group_2__0 )? ) ;
    public final void rule__CrossReference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4507:1: ( ( ( rule__CrossReference__Group_2__0 )? ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4508:1: ( ( rule__CrossReference__Group_2__0 )? )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4508:1: ( ( rule__CrossReference__Group_2__0 )? )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4509:1: ( rule__CrossReference__Group_2__0 )?
            {
             before(grammarAccess.getCrossReferenceAccess().getGroup_2()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4510:1: ( rule__CrossReference__Group_2__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==30) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4510:2: rule__CrossReference__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group_2__0_in_rule__CrossReference__Group__2__Impl9146);
                    rule__CrossReference__Group_2__0();

                    state._fsp--;


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
    // $ANTLR end "rule__CrossReference__Group__2__Impl"


    // $ANTLR start "rule__CrossReference__Group__3"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4520:1: rule__CrossReference__Group__3 : rule__CrossReference__Group__3__Impl ;
    public final void rule__CrossReference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4524:1: ( rule__CrossReference__Group__3__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4525:2: rule__CrossReference__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group__3__Impl_in_rule__CrossReference__Group__39177);
            rule__CrossReference__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossReference__Group__3"


    // $ANTLR start "rule__CrossReference__Group__3__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4531:1: rule__CrossReference__Group__3__Impl : ( ']' ) ;
    public final void rule__CrossReference__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4535:1: ( ( ']' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4536:1: ( ']' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4536:1: ( ']' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4537:1: ']'
            {
             before(grammarAccess.getCrossReferenceAccess().getRightSquareBracketKeyword_3()); 
            match(input,36,FollowSets000.FOLLOW_36_in_rule__CrossReference__Group__3__Impl9205); 
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
    // $ANTLR end "rule__CrossReference__Group__3__Impl"


    // $ANTLR start "rule__CrossReference__Group_2__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4558:1: rule__CrossReference__Group_2__0 : rule__CrossReference__Group_2__0__Impl rule__CrossReference__Group_2__1 ;
    public final void rule__CrossReference__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4562:1: ( rule__CrossReference__Group_2__0__Impl rule__CrossReference__Group_2__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4563:2: rule__CrossReference__Group_2__0__Impl rule__CrossReference__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group_2__0__Impl_in_rule__CrossReference__Group_2__09244);
            rule__CrossReference__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group_2__1_in_rule__CrossReference__Group_2__09247);
            rule__CrossReference__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossReference__Group_2__0"


    // $ANTLR start "rule__CrossReference__Group_2__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4570:1: rule__CrossReference__Group_2__0__Impl : ( '|' ) ;
    public final void rule__CrossReference__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4574:1: ( ( '|' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4575:1: ( '|' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4575:1: ( '|' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4576:1: '|'
            {
             before(grammarAccess.getCrossReferenceAccess().getVerticalLineKeyword_2_0()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__CrossReference__Group_2__0__Impl9275); 
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
    // $ANTLR end "rule__CrossReference__Group_2__0__Impl"


    // $ANTLR start "rule__CrossReference__Group_2__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4589:1: rule__CrossReference__Group_2__1 : rule__CrossReference__Group_2__1__Impl ;
    public final void rule__CrossReference__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4593:1: ( rule__CrossReference__Group_2__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4594:2: rule__CrossReference__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group_2__1__Impl_in_rule__CrossReference__Group_2__19306);
            rule__CrossReference__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossReference__Group_2__1"


    // $ANTLR start "rule__CrossReference__Group_2__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4600:1: rule__CrossReference__Group_2__1__Impl : ( ( rule__CrossReference__TerminalAssignment_2_1 ) ) ;
    public final void rule__CrossReference__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4604:1: ( ( ( rule__CrossReference__TerminalAssignment_2_1 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4605:1: ( ( rule__CrossReference__TerminalAssignment_2_1 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4605:1: ( ( rule__CrossReference__TerminalAssignment_2_1 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4606:1: ( rule__CrossReference__TerminalAssignment_2_1 )
            {
             before(grammarAccess.getCrossReferenceAccess().getTerminalAssignment_2_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4607:1: ( rule__CrossReference__TerminalAssignment_2_1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4607:2: rule__CrossReference__TerminalAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__TerminalAssignment_2_1_in_rule__CrossReference__Group_2__1__Impl9333);
            rule__CrossReference__TerminalAssignment_2_1();

            state._fsp--;


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
    // $ANTLR end "rule__CrossReference__Group_2__1__Impl"


    // $ANTLR start "rule__ParenthesizedElement__Group__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4621:1: rule__ParenthesizedElement__Group__0 : rule__ParenthesizedElement__Group__0__Impl rule__ParenthesizedElement__Group__1 ;
    public final void rule__ParenthesizedElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4625:1: ( rule__ParenthesizedElement__Group__0__Impl rule__ParenthesizedElement__Group__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4626:2: rule__ParenthesizedElement__Group__0__Impl rule__ParenthesizedElement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedElement__Group__0__Impl_in_rule__ParenthesizedElement__Group__09367);
            rule__ParenthesizedElement__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedElement__Group__1_in_rule__ParenthesizedElement__Group__09370);
            rule__ParenthesizedElement__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedElement__Group__0"


    // $ANTLR start "rule__ParenthesizedElement__Group__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4633:1: rule__ParenthesizedElement__Group__0__Impl : ( '(' ) ;
    public final void rule__ParenthesizedElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4637:1: ( ( '(' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4638:1: ( '(' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4638:1: ( '(' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4639:1: '('
            {
             before(grammarAccess.getParenthesizedElementAccess().getLeftParenthesisKeyword_0()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__ParenthesizedElement__Group__0__Impl9398); 
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
    // $ANTLR end "rule__ParenthesizedElement__Group__0__Impl"


    // $ANTLR start "rule__ParenthesizedElement__Group__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4652:1: rule__ParenthesizedElement__Group__1 : rule__ParenthesizedElement__Group__1__Impl rule__ParenthesizedElement__Group__2 ;
    public final void rule__ParenthesizedElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4656:1: ( rule__ParenthesizedElement__Group__1__Impl rule__ParenthesizedElement__Group__2 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4657:2: rule__ParenthesizedElement__Group__1__Impl rule__ParenthesizedElement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedElement__Group__1__Impl_in_rule__ParenthesizedElement__Group__19429);
            rule__ParenthesizedElement__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedElement__Group__2_in_rule__ParenthesizedElement__Group__19432);
            rule__ParenthesizedElement__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedElement__Group__1"


    // $ANTLR start "rule__ParenthesizedElement__Group__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4664:1: rule__ParenthesizedElement__Group__1__Impl : ( ruleAlternatives ) ;
    public final void rule__ParenthesizedElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4668:1: ( ( ruleAlternatives ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4669:1: ( ruleAlternatives )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4669:1: ( ruleAlternatives )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4670:1: ruleAlternatives
            {
             before(grammarAccess.getParenthesizedElementAccess().getAlternativesParserRuleCall_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleAlternatives_in_rule__ParenthesizedElement__Group__1__Impl9459);
            ruleAlternatives();

            state._fsp--;

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
    // $ANTLR end "rule__ParenthesizedElement__Group__1__Impl"


    // $ANTLR start "rule__ParenthesizedElement__Group__2"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4681:1: rule__ParenthesizedElement__Group__2 : rule__ParenthesizedElement__Group__2__Impl ;
    public final void rule__ParenthesizedElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4685:1: ( rule__ParenthesizedElement__Group__2__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4686:2: rule__ParenthesizedElement__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedElement__Group__2__Impl_in_rule__ParenthesizedElement__Group__29488);
            rule__ParenthesizedElement__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedElement__Group__2"


    // $ANTLR start "rule__ParenthesizedElement__Group__2__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4692:1: rule__ParenthesizedElement__Group__2__Impl : ( ')' ) ;
    public final void rule__ParenthesizedElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4696:1: ( ( ')' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4697:1: ( ')' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4697:1: ( ')' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4698:1: ')'
            {
             before(grammarAccess.getParenthesizedElementAccess().getRightParenthesisKeyword_2()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__ParenthesizedElement__Group__2__Impl9516); 
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
    // $ANTLR end "rule__ParenthesizedElement__Group__2__Impl"


    // $ANTLR start "rule__TerminalRule__Group__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4717:1: rule__TerminalRule__Group__0 : rule__TerminalRule__Group__0__Impl rule__TerminalRule__Group__1 ;
    public final void rule__TerminalRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4721:1: ( rule__TerminalRule__Group__0__Impl rule__TerminalRule__Group__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4722:2: rule__TerminalRule__Group__0__Impl rule__TerminalRule__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__0__Impl_in_rule__TerminalRule__Group__09553);
            rule__TerminalRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__1_in_rule__TerminalRule__Group__09556);
            rule__TerminalRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group__0"


    // $ANTLR start "rule__TerminalRule__Group__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4729:1: rule__TerminalRule__Group__0__Impl : ( 'terminal' ) ;
    public final void rule__TerminalRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4733:1: ( ( 'terminal' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4734:1: ( 'terminal' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4734:1: ( 'terminal' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4735:1: 'terminal'
            {
             before(grammarAccess.getTerminalRuleAccess().getTerminalKeyword_0()); 
            match(input,37,FollowSets000.FOLLOW_37_in_rule__TerminalRule__Group__0__Impl9584); 
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
    // $ANTLR end "rule__TerminalRule__Group__0__Impl"


    // $ANTLR start "rule__TerminalRule__Group__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4748:1: rule__TerminalRule__Group__1 : rule__TerminalRule__Group__1__Impl rule__TerminalRule__Group__2 ;
    public final void rule__TerminalRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4752:1: ( rule__TerminalRule__Group__1__Impl rule__TerminalRule__Group__2 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4753:2: rule__TerminalRule__Group__1__Impl rule__TerminalRule__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__1__Impl_in_rule__TerminalRule__Group__19615);
            rule__TerminalRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__2_in_rule__TerminalRule__Group__19618);
            rule__TerminalRule__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group__1"


    // $ANTLR start "rule__TerminalRule__Group__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4760:1: rule__TerminalRule__Group__1__Impl : ( ( rule__TerminalRule__Alternatives_1 ) ) ;
    public final void rule__TerminalRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4764:1: ( ( ( rule__TerminalRule__Alternatives_1 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4765:1: ( ( rule__TerminalRule__Alternatives_1 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4765:1: ( ( rule__TerminalRule__Alternatives_1 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4766:1: ( rule__TerminalRule__Alternatives_1 )
            {
             before(grammarAccess.getTerminalRuleAccess().getAlternatives_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4767:1: ( rule__TerminalRule__Alternatives_1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4767:2: rule__TerminalRule__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Alternatives_1_in_rule__TerminalRule__Group__1__Impl9645);
            rule__TerminalRule__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getTerminalRuleAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group__1__Impl"


    // $ANTLR start "rule__TerminalRule__Group__2"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4777:1: rule__TerminalRule__Group__2 : rule__TerminalRule__Group__2__Impl rule__TerminalRule__Group__3 ;
    public final void rule__TerminalRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4781:1: ( rule__TerminalRule__Group__2__Impl rule__TerminalRule__Group__3 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4782:2: rule__TerminalRule__Group__2__Impl rule__TerminalRule__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__2__Impl_in_rule__TerminalRule__Group__29675);
            rule__TerminalRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__3_in_rule__TerminalRule__Group__29678);
            rule__TerminalRule__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group__2"


    // $ANTLR start "rule__TerminalRule__Group__2__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4789:1: rule__TerminalRule__Group__2__Impl : ( ':' ) ;
    public final void rule__TerminalRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4793:1: ( ( ':' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4794:1: ( ':' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4794:1: ( ':' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4795:1: ':'
            {
             before(grammarAccess.getTerminalRuleAccess().getColonKeyword_2()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__TerminalRule__Group__2__Impl9706); 
             after(grammarAccess.getTerminalRuleAccess().getColonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group__2__Impl"


    // $ANTLR start "rule__TerminalRule__Group__3"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4808:1: rule__TerminalRule__Group__3 : rule__TerminalRule__Group__3__Impl rule__TerminalRule__Group__4 ;
    public final void rule__TerminalRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4812:1: ( rule__TerminalRule__Group__3__Impl rule__TerminalRule__Group__4 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4813:2: rule__TerminalRule__Group__3__Impl rule__TerminalRule__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__3__Impl_in_rule__TerminalRule__Group__39737);
            rule__TerminalRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__4_in_rule__TerminalRule__Group__39740);
            rule__TerminalRule__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group__3"


    // $ANTLR start "rule__TerminalRule__Group__3__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4820:1: rule__TerminalRule__Group__3__Impl : ( ( rule__TerminalRule__AlternativesAssignment_3 ) ) ;
    public final void rule__TerminalRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4824:1: ( ( ( rule__TerminalRule__AlternativesAssignment_3 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4825:1: ( ( rule__TerminalRule__AlternativesAssignment_3 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4825:1: ( ( rule__TerminalRule__AlternativesAssignment_3 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4826:1: ( rule__TerminalRule__AlternativesAssignment_3 )
            {
             before(grammarAccess.getTerminalRuleAccess().getAlternativesAssignment_3()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4827:1: ( rule__TerminalRule__AlternativesAssignment_3 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4827:2: rule__TerminalRule__AlternativesAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__AlternativesAssignment_3_in_rule__TerminalRule__Group__3__Impl9767);
            rule__TerminalRule__AlternativesAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getTerminalRuleAccess().getAlternativesAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group__3__Impl"


    // $ANTLR start "rule__TerminalRule__Group__4"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4837:1: rule__TerminalRule__Group__4 : rule__TerminalRule__Group__4__Impl ;
    public final void rule__TerminalRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4841:1: ( rule__TerminalRule__Group__4__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4842:2: rule__TerminalRule__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__4__Impl_in_rule__TerminalRule__Group__49797);
            rule__TerminalRule__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group__4"


    // $ANTLR start "rule__TerminalRule__Group__4__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4848:1: rule__TerminalRule__Group__4__Impl : ( ';' ) ;
    public final void rule__TerminalRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4852:1: ( ( ';' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4853:1: ( ';' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4853:1: ( ';' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4854:1: ';'
            {
             before(grammarAccess.getTerminalRuleAccess().getSemicolonKeyword_4()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__TerminalRule__Group__4__Impl9825); 
             after(grammarAccess.getTerminalRuleAccess().getSemicolonKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group__4__Impl"


    // $ANTLR start "rule__TerminalRule__Group_1_0__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4877:1: rule__TerminalRule__Group_1_0__0 : rule__TerminalRule__Group_1_0__0__Impl rule__TerminalRule__Group_1_0__1 ;
    public final void rule__TerminalRule__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4881:1: ( rule__TerminalRule__Group_1_0__0__Impl rule__TerminalRule__Group_1_0__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4882:2: rule__TerminalRule__Group_1_0__0__Impl rule__TerminalRule__Group_1_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group_1_0__0__Impl_in_rule__TerminalRule__Group_1_0__09866);
            rule__TerminalRule__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group_1_0__1_in_rule__TerminalRule__Group_1_0__09869);
            rule__TerminalRule__Group_1_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_1_0__0"


    // $ANTLR start "rule__TerminalRule__Group_1_0__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4889:1: rule__TerminalRule__Group_1_0__0__Impl : ( ( rule__TerminalRule__FragmentAssignment_1_0_0 ) ) ;
    public final void rule__TerminalRule__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4893:1: ( ( ( rule__TerminalRule__FragmentAssignment_1_0_0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4894:1: ( ( rule__TerminalRule__FragmentAssignment_1_0_0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4894:1: ( ( rule__TerminalRule__FragmentAssignment_1_0_0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4895:1: ( rule__TerminalRule__FragmentAssignment_1_0_0 )
            {
             before(grammarAccess.getTerminalRuleAccess().getFragmentAssignment_1_0_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4896:1: ( rule__TerminalRule__FragmentAssignment_1_0_0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4896:2: rule__TerminalRule__FragmentAssignment_1_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__FragmentAssignment_1_0_0_in_rule__TerminalRule__Group_1_0__0__Impl9896);
            rule__TerminalRule__FragmentAssignment_1_0_0();

            state._fsp--;


            }

             after(grammarAccess.getTerminalRuleAccess().getFragmentAssignment_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_1_0__0__Impl"


    // $ANTLR start "rule__TerminalRule__Group_1_0__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4906:1: rule__TerminalRule__Group_1_0__1 : rule__TerminalRule__Group_1_0__1__Impl ;
    public final void rule__TerminalRule__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4910:1: ( rule__TerminalRule__Group_1_0__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4911:2: rule__TerminalRule__Group_1_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group_1_0__1__Impl_in_rule__TerminalRule__Group_1_0__19926);
            rule__TerminalRule__Group_1_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_1_0__1"


    // $ANTLR start "rule__TerminalRule__Group_1_0__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4917:1: rule__TerminalRule__Group_1_0__1__Impl : ( ( rule__TerminalRule__NameAssignment_1_0_1 ) ) ;
    public final void rule__TerminalRule__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4921:1: ( ( ( rule__TerminalRule__NameAssignment_1_0_1 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4922:1: ( ( rule__TerminalRule__NameAssignment_1_0_1 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4922:1: ( ( rule__TerminalRule__NameAssignment_1_0_1 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4923:1: ( rule__TerminalRule__NameAssignment_1_0_1 )
            {
             before(grammarAccess.getTerminalRuleAccess().getNameAssignment_1_0_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4924:1: ( rule__TerminalRule__NameAssignment_1_0_1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4924:2: rule__TerminalRule__NameAssignment_1_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__NameAssignment_1_0_1_in_rule__TerminalRule__Group_1_0__1__Impl9953);
            rule__TerminalRule__NameAssignment_1_0_1();

            state._fsp--;


            }

             after(grammarAccess.getTerminalRuleAccess().getNameAssignment_1_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_1_0__1__Impl"


    // $ANTLR start "rule__TerminalRule__Group_1_1__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4938:1: rule__TerminalRule__Group_1_1__0 : rule__TerminalRule__Group_1_1__0__Impl rule__TerminalRule__Group_1_1__1 ;
    public final void rule__TerminalRule__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4942:1: ( rule__TerminalRule__Group_1_1__0__Impl rule__TerminalRule__Group_1_1__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4943:2: rule__TerminalRule__Group_1_1__0__Impl rule__TerminalRule__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group_1_1__0__Impl_in_rule__TerminalRule__Group_1_1__09987);
            rule__TerminalRule__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group_1_1__1_in_rule__TerminalRule__Group_1_1__09990);
            rule__TerminalRule__Group_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_1_1__0"


    // $ANTLR start "rule__TerminalRule__Group_1_1__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4950:1: rule__TerminalRule__Group_1_1__0__Impl : ( ( rule__TerminalRule__NameAssignment_1_1_0 ) ) ;
    public final void rule__TerminalRule__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4954:1: ( ( ( rule__TerminalRule__NameAssignment_1_1_0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4955:1: ( ( rule__TerminalRule__NameAssignment_1_1_0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4955:1: ( ( rule__TerminalRule__NameAssignment_1_1_0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4956:1: ( rule__TerminalRule__NameAssignment_1_1_0 )
            {
             before(grammarAccess.getTerminalRuleAccess().getNameAssignment_1_1_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4957:1: ( rule__TerminalRule__NameAssignment_1_1_0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4957:2: rule__TerminalRule__NameAssignment_1_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__NameAssignment_1_1_0_in_rule__TerminalRule__Group_1_1__0__Impl10017);
            rule__TerminalRule__NameAssignment_1_1_0();

            state._fsp--;


            }

             after(grammarAccess.getTerminalRuleAccess().getNameAssignment_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_1_1__0__Impl"


    // $ANTLR start "rule__TerminalRule__Group_1_1__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4967:1: rule__TerminalRule__Group_1_1__1 : rule__TerminalRule__Group_1_1__1__Impl ;
    public final void rule__TerminalRule__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4971:1: ( rule__TerminalRule__Group_1_1__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4972:2: rule__TerminalRule__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group_1_1__1__Impl_in_rule__TerminalRule__Group_1_1__110047);
            rule__TerminalRule__Group_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_1_1__1"


    // $ANTLR start "rule__TerminalRule__Group_1_1__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4978:1: rule__TerminalRule__Group_1_1__1__Impl : ( ( rule__TerminalRule__Group_1_1_1__0 )? ) ;
    public final void rule__TerminalRule__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4982:1: ( ( ( rule__TerminalRule__Group_1_1_1__0 )? ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4983:1: ( ( rule__TerminalRule__Group_1_1_1__0 )? )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4983:1: ( ( rule__TerminalRule__Group_1_1_1__0 )? )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4984:1: ( rule__TerminalRule__Group_1_1_1__0 )?
            {
             before(grammarAccess.getTerminalRuleAccess().getGroup_1_1_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4985:1: ( rule__TerminalRule__Group_1_1_1__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==28) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4985:2: rule__TerminalRule__Group_1_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group_1_1_1__0_in_rule__TerminalRule__Group_1_1__1__Impl10074);
                    rule__TerminalRule__Group_1_1_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTerminalRuleAccess().getGroup_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_1_1__1__Impl"


    // $ANTLR start "rule__TerminalRule__Group_1_1_1__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4999:1: rule__TerminalRule__Group_1_1_1__0 : rule__TerminalRule__Group_1_1_1__0__Impl rule__TerminalRule__Group_1_1_1__1 ;
    public final void rule__TerminalRule__Group_1_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5003:1: ( rule__TerminalRule__Group_1_1_1__0__Impl rule__TerminalRule__Group_1_1_1__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5004:2: rule__TerminalRule__Group_1_1_1__0__Impl rule__TerminalRule__Group_1_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group_1_1_1__0__Impl_in_rule__TerminalRule__Group_1_1_1__010109);
            rule__TerminalRule__Group_1_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group_1_1_1__1_in_rule__TerminalRule__Group_1_1_1__010112);
            rule__TerminalRule__Group_1_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_1_1_1__0"


    // $ANTLR start "rule__TerminalRule__Group_1_1_1__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5011:1: rule__TerminalRule__Group_1_1_1__0__Impl : ( 'returns' ) ;
    public final void rule__TerminalRule__Group_1_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5015:1: ( ( 'returns' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5016:1: ( 'returns' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5016:1: ( 'returns' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5017:1: 'returns'
            {
             before(grammarAccess.getTerminalRuleAccess().getReturnsKeyword_1_1_1_0()); 
            match(input,28,FollowSets000.FOLLOW_28_in_rule__TerminalRule__Group_1_1_1__0__Impl10140); 
             after(grammarAccess.getTerminalRuleAccess().getReturnsKeyword_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_1_1_1__0__Impl"


    // $ANTLR start "rule__TerminalRule__Group_1_1_1__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5030:1: rule__TerminalRule__Group_1_1_1__1 : rule__TerminalRule__Group_1_1_1__1__Impl ;
    public final void rule__TerminalRule__Group_1_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5034:1: ( rule__TerminalRule__Group_1_1_1__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5035:2: rule__TerminalRule__Group_1_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group_1_1_1__1__Impl_in_rule__TerminalRule__Group_1_1_1__110171);
            rule__TerminalRule__Group_1_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_1_1_1__1"


    // $ANTLR start "rule__TerminalRule__Group_1_1_1__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5041:1: rule__TerminalRule__Group_1_1_1__1__Impl : ( ( rule__TerminalRule__TypeAssignment_1_1_1_1 ) ) ;
    public final void rule__TerminalRule__Group_1_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5045:1: ( ( ( rule__TerminalRule__TypeAssignment_1_1_1_1 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5046:1: ( ( rule__TerminalRule__TypeAssignment_1_1_1_1 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5046:1: ( ( rule__TerminalRule__TypeAssignment_1_1_1_1 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5047:1: ( rule__TerminalRule__TypeAssignment_1_1_1_1 )
            {
             before(grammarAccess.getTerminalRuleAccess().getTypeAssignment_1_1_1_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5048:1: ( rule__TerminalRule__TypeAssignment_1_1_1_1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5048:2: rule__TerminalRule__TypeAssignment_1_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__TypeAssignment_1_1_1_1_in_rule__TerminalRule__Group_1_1_1__1__Impl10198);
            rule__TerminalRule__TypeAssignment_1_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getTerminalRuleAccess().getTypeAssignment_1_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_1_1_1__1__Impl"


    // $ANTLR start "rule__TerminalAlternatives__Group__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5062:1: rule__TerminalAlternatives__Group__0 : rule__TerminalAlternatives__Group__0__Impl rule__TerminalAlternatives__Group__1 ;
    public final void rule__TerminalAlternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5066:1: ( rule__TerminalAlternatives__Group__0__Impl rule__TerminalAlternatives__Group__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5067:2: rule__TerminalAlternatives__Group__0__Impl rule__TerminalAlternatives__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group__0__Impl_in_rule__TerminalAlternatives__Group__010232);
            rule__TerminalAlternatives__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group__1_in_rule__TerminalAlternatives__Group__010235);
            rule__TerminalAlternatives__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalAlternatives__Group__0"


    // $ANTLR start "rule__TerminalAlternatives__Group__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5074:1: rule__TerminalAlternatives__Group__0__Impl : ( ruleTerminalGroup ) ;
    public final void rule__TerminalAlternatives__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5078:1: ( ( ruleTerminalGroup ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5079:1: ( ruleTerminalGroup )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5079:1: ( ruleTerminalGroup )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5080:1: ruleTerminalGroup
            {
             before(grammarAccess.getTerminalAlternativesAccess().getTerminalGroupParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalGroup_in_rule__TerminalAlternatives__Group__0__Impl10262);
            ruleTerminalGroup();

            state._fsp--;

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
    // $ANTLR end "rule__TerminalAlternatives__Group__0__Impl"


    // $ANTLR start "rule__TerminalAlternatives__Group__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5091:1: rule__TerminalAlternatives__Group__1 : rule__TerminalAlternatives__Group__1__Impl ;
    public final void rule__TerminalAlternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5095:1: ( rule__TerminalAlternatives__Group__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5096:2: rule__TerminalAlternatives__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group__1__Impl_in_rule__TerminalAlternatives__Group__110291);
            rule__TerminalAlternatives__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalAlternatives__Group__1"


    // $ANTLR start "rule__TerminalAlternatives__Group__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5102:1: rule__TerminalAlternatives__Group__1__Impl : ( ( rule__TerminalAlternatives__Group_1__0 )? ) ;
    public final void rule__TerminalAlternatives__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5106:1: ( ( ( rule__TerminalAlternatives__Group_1__0 )? ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5107:1: ( ( rule__TerminalAlternatives__Group_1__0 )? )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5107:1: ( ( rule__TerminalAlternatives__Group_1__0 )? )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5108:1: ( rule__TerminalAlternatives__Group_1__0 )?
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5109:1: ( rule__TerminalAlternatives__Group_1__0 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==30) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5109:2: rule__TerminalAlternatives__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group_1__0_in_rule__TerminalAlternatives__Group__1__Impl10318);
                    rule__TerminalAlternatives__Group_1__0();

                    state._fsp--;


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
    // $ANTLR end "rule__TerminalAlternatives__Group__1__Impl"


    // $ANTLR start "rule__TerminalAlternatives__Group_1__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5123:1: rule__TerminalAlternatives__Group_1__0 : rule__TerminalAlternatives__Group_1__0__Impl rule__TerminalAlternatives__Group_1__1 ;
    public final void rule__TerminalAlternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5127:1: ( rule__TerminalAlternatives__Group_1__0__Impl rule__TerminalAlternatives__Group_1__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5128:2: rule__TerminalAlternatives__Group_1__0__Impl rule__TerminalAlternatives__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group_1__0__Impl_in_rule__TerminalAlternatives__Group_1__010353);
            rule__TerminalAlternatives__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group_1__1_in_rule__TerminalAlternatives__Group_1__010356);
            rule__TerminalAlternatives__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalAlternatives__Group_1__0"


    // $ANTLR start "rule__TerminalAlternatives__Group_1__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5135:1: rule__TerminalAlternatives__Group_1__0__Impl : ( () ) ;
    public final void rule__TerminalAlternatives__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5139:1: ( ( () ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5140:1: ( () )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5140:1: ( () )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5141:1: ()
            {
             before(grammarAccess.getTerminalAlternativesAccess().getAlternativesElementsAction_1_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5142:1: ()
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5144:1: 
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
    // $ANTLR end "rule__TerminalAlternatives__Group_1__0__Impl"


    // $ANTLR start "rule__TerminalAlternatives__Group_1__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5154:1: rule__TerminalAlternatives__Group_1__1 : rule__TerminalAlternatives__Group_1__1__Impl ;
    public final void rule__TerminalAlternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5158:1: ( rule__TerminalAlternatives__Group_1__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5159:2: rule__TerminalAlternatives__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group_1__1__Impl_in_rule__TerminalAlternatives__Group_1__110414);
            rule__TerminalAlternatives__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalAlternatives__Group_1__1"


    // $ANTLR start "rule__TerminalAlternatives__Group_1__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5165:1: rule__TerminalAlternatives__Group_1__1__Impl : ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) ) ;
    public final void rule__TerminalAlternatives__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5169:1: ( ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5170:1: ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5170:1: ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5171:1: ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5171:1: ( ( rule__TerminalAlternatives__Group_1_1__0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5172:1: ( rule__TerminalAlternatives__Group_1_1__0 )
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5173:1: ( rule__TerminalAlternatives__Group_1_1__0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5173:2: rule__TerminalAlternatives__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group_1_1__0_in_rule__TerminalAlternatives__Group_1__1__Impl10443);
            rule__TerminalAlternatives__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 

            }

            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5176:1: ( ( rule__TerminalAlternatives__Group_1_1__0 )* )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5177:1: ( rule__TerminalAlternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5178:1: ( rule__TerminalAlternatives__Group_1_1__0 )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==30) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5178:2: rule__TerminalAlternatives__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group_1_1__0_in_rule__TerminalAlternatives__Group_1__1__Impl10455);
            	    rule__TerminalAlternatives__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop43;
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
    // $ANTLR end "rule__TerminalAlternatives__Group_1__1__Impl"


    // $ANTLR start "rule__TerminalAlternatives__Group_1_1__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5193:1: rule__TerminalAlternatives__Group_1_1__0 : rule__TerminalAlternatives__Group_1_1__0__Impl rule__TerminalAlternatives__Group_1_1__1 ;
    public final void rule__TerminalAlternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5197:1: ( rule__TerminalAlternatives__Group_1_1__0__Impl rule__TerminalAlternatives__Group_1_1__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5198:2: rule__TerminalAlternatives__Group_1_1__0__Impl rule__TerminalAlternatives__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group_1_1__0__Impl_in_rule__TerminalAlternatives__Group_1_1__010492);
            rule__TerminalAlternatives__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group_1_1__1_in_rule__TerminalAlternatives__Group_1_1__010495);
            rule__TerminalAlternatives__Group_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalAlternatives__Group_1_1__0"


    // $ANTLR start "rule__TerminalAlternatives__Group_1_1__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5205:1: rule__TerminalAlternatives__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__TerminalAlternatives__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5209:1: ( ( '|' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5210:1: ( '|' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5210:1: ( '|' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5211:1: '|'
            {
             before(grammarAccess.getTerminalAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__TerminalAlternatives__Group_1_1__0__Impl10523); 
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
    // $ANTLR end "rule__TerminalAlternatives__Group_1_1__0__Impl"


    // $ANTLR start "rule__TerminalAlternatives__Group_1_1__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5224:1: rule__TerminalAlternatives__Group_1_1__1 : rule__TerminalAlternatives__Group_1_1__1__Impl ;
    public final void rule__TerminalAlternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5228:1: ( rule__TerminalAlternatives__Group_1_1__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5229:2: rule__TerminalAlternatives__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group_1_1__1__Impl_in_rule__TerminalAlternatives__Group_1_1__110554);
            rule__TerminalAlternatives__Group_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalAlternatives__Group_1_1__1"


    // $ANTLR start "rule__TerminalAlternatives__Group_1_1__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5235:1: rule__TerminalAlternatives__Group_1_1__1__Impl : ( ( rule__TerminalAlternatives__ElementsAssignment_1_1_1 ) ) ;
    public final void rule__TerminalAlternatives__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5239:1: ( ( ( rule__TerminalAlternatives__ElementsAssignment_1_1_1 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5240:1: ( ( rule__TerminalAlternatives__ElementsAssignment_1_1_1 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5240:1: ( ( rule__TerminalAlternatives__ElementsAssignment_1_1_1 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5241:1: ( rule__TerminalAlternatives__ElementsAssignment_1_1_1 )
            {
             before(grammarAccess.getTerminalAlternativesAccess().getElementsAssignment_1_1_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5242:1: ( rule__TerminalAlternatives__ElementsAssignment_1_1_1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5242:2: rule__TerminalAlternatives__ElementsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__ElementsAssignment_1_1_1_in_rule__TerminalAlternatives__Group_1_1__1__Impl10581);
            rule__TerminalAlternatives__ElementsAssignment_1_1_1();

            state._fsp--;


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
    // $ANTLR end "rule__TerminalAlternatives__Group_1_1__1__Impl"


    // $ANTLR start "rule__TerminalGroup__Group__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5256:1: rule__TerminalGroup__Group__0 : rule__TerminalGroup__Group__0__Impl rule__TerminalGroup__Group__1 ;
    public final void rule__TerminalGroup__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5260:1: ( rule__TerminalGroup__Group__0__Impl rule__TerminalGroup__Group__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5261:2: rule__TerminalGroup__Group__0__Impl rule__TerminalGroup__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__Group__0__Impl_in_rule__TerminalGroup__Group__010615);
            rule__TerminalGroup__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__Group__1_in_rule__TerminalGroup__Group__010618);
            rule__TerminalGroup__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalGroup__Group__0"


    // $ANTLR start "rule__TerminalGroup__Group__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5268:1: rule__TerminalGroup__Group__0__Impl : ( ruleTerminalToken ) ;
    public final void rule__TerminalGroup__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5272:1: ( ( ruleTerminalToken ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5273:1: ( ruleTerminalToken )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5273:1: ( ruleTerminalToken )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5274:1: ruleTerminalToken
            {
             before(grammarAccess.getTerminalGroupAccess().getTerminalTokenParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalToken_in_rule__TerminalGroup__Group__0__Impl10645);
            ruleTerminalToken();

            state._fsp--;

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
    // $ANTLR end "rule__TerminalGroup__Group__0__Impl"


    // $ANTLR start "rule__TerminalGroup__Group__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5285:1: rule__TerminalGroup__Group__1 : rule__TerminalGroup__Group__1__Impl ;
    public final void rule__TerminalGroup__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5289:1: ( rule__TerminalGroup__Group__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5290:2: rule__TerminalGroup__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__Group__1__Impl_in_rule__TerminalGroup__Group__110674);
            rule__TerminalGroup__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalGroup__Group__1"


    // $ANTLR start "rule__TerminalGroup__Group__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5296:1: rule__TerminalGroup__Group__1__Impl : ( ( rule__TerminalGroup__Group_1__0 )? ) ;
    public final void rule__TerminalGroup__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5300:1: ( ( ( rule__TerminalGroup__Group_1__0 )? ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5301:1: ( ( rule__TerminalGroup__Group_1__0 )? )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5301:1: ( ( rule__TerminalGroup__Group_1__0 )? )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5302:1: ( rule__TerminalGroup__Group_1__0 )?
            {
             before(grammarAccess.getTerminalGroupAccess().getGroup_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5303:1: ( rule__TerminalGroup__Group_1__0 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( ((LA44_0>=RULE_ID && LA44_0<=RULE_STRING)||LA44_0==20||LA44_0==22||(LA44_0>=38 && LA44_0<=39)) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5303:2: rule__TerminalGroup__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__Group_1__0_in_rule__TerminalGroup__Group__1__Impl10701);
                    rule__TerminalGroup__Group_1__0();

                    state._fsp--;


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
    // $ANTLR end "rule__TerminalGroup__Group__1__Impl"


    // $ANTLR start "rule__TerminalGroup__Group_1__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5317:1: rule__TerminalGroup__Group_1__0 : rule__TerminalGroup__Group_1__0__Impl rule__TerminalGroup__Group_1__1 ;
    public final void rule__TerminalGroup__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5321:1: ( rule__TerminalGroup__Group_1__0__Impl rule__TerminalGroup__Group_1__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5322:2: rule__TerminalGroup__Group_1__0__Impl rule__TerminalGroup__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__Group_1__0__Impl_in_rule__TerminalGroup__Group_1__010736);
            rule__TerminalGroup__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__Group_1__1_in_rule__TerminalGroup__Group_1__010739);
            rule__TerminalGroup__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalGroup__Group_1__0"


    // $ANTLR start "rule__TerminalGroup__Group_1__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5329:1: rule__TerminalGroup__Group_1__0__Impl : ( () ) ;
    public final void rule__TerminalGroup__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5333:1: ( ( () ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5334:1: ( () )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5334:1: ( () )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5335:1: ()
            {
             before(grammarAccess.getTerminalGroupAccess().getGroupElementsAction_1_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5336:1: ()
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5338:1: 
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
    // $ANTLR end "rule__TerminalGroup__Group_1__0__Impl"


    // $ANTLR start "rule__TerminalGroup__Group_1__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5348:1: rule__TerminalGroup__Group_1__1 : rule__TerminalGroup__Group_1__1__Impl ;
    public final void rule__TerminalGroup__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5352:1: ( rule__TerminalGroup__Group_1__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5353:2: rule__TerminalGroup__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__Group_1__1__Impl_in_rule__TerminalGroup__Group_1__110797);
            rule__TerminalGroup__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalGroup__Group_1__1"


    // $ANTLR start "rule__TerminalGroup__Group_1__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5359:1: rule__TerminalGroup__Group_1__1__Impl : ( ( ( rule__TerminalGroup__ElementsAssignment_1_1 ) ) ( ( rule__TerminalGroup__ElementsAssignment_1_1 )* ) ) ;
    public final void rule__TerminalGroup__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5363:1: ( ( ( ( rule__TerminalGroup__ElementsAssignment_1_1 ) ) ( ( rule__TerminalGroup__ElementsAssignment_1_1 )* ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5364:1: ( ( ( rule__TerminalGroup__ElementsAssignment_1_1 ) ) ( ( rule__TerminalGroup__ElementsAssignment_1_1 )* ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5364:1: ( ( ( rule__TerminalGroup__ElementsAssignment_1_1 ) ) ( ( rule__TerminalGroup__ElementsAssignment_1_1 )* ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5365:1: ( ( rule__TerminalGroup__ElementsAssignment_1_1 ) ) ( ( rule__TerminalGroup__ElementsAssignment_1_1 )* )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5365:1: ( ( rule__TerminalGroup__ElementsAssignment_1_1 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5366:1: ( rule__TerminalGroup__ElementsAssignment_1_1 )
            {
             before(grammarAccess.getTerminalGroupAccess().getElementsAssignment_1_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5367:1: ( rule__TerminalGroup__ElementsAssignment_1_1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5367:2: rule__TerminalGroup__ElementsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__ElementsAssignment_1_1_in_rule__TerminalGroup__Group_1__1__Impl10826);
            rule__TerminalGroup__ElementsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getTerminalGroupAccess().getElementsAssignment_1_1()); 

            }

            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5370:1: ( ( rule__TerminalGroup__ElementsAssignment_1_1 )* )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5371:1: ( rule__TerminalGroup__ElementsAssignment_1_1 )*
            {
             before(grammarAccess.getTerminalGroupAccess().getElementsAssignment_1_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5372:1: ( rule__TerminalGroup__ElementsAssignment_1_1 )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( ((LA45_0>=RULE_ID && LA45_0<=RULE_STRING)||LA45_0==20||LA45_0==22||(LA45_0>=38 && LA45_0<=39)) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5372:2: rule__TerminalGroup__ElementsAssignment_1_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__ElementsAssignment_1_1_in_rule__TerminalGroup__Group_1__1__Impl10838);
            	    rule__TerminalGroup__ElementsAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop45;
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
    // $ANTLR end "rule__TerminalGroup__Group_1__1__Impl"


    // $ANTLR start "rule__TerminalToken__Group__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5387:1: rule__TerminalToken__Group__0 : rule__TerminalToken__Group__0__Impl rule__TerminalToken__Group__1 ;
    public final void rule__TerminalToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5391:1: ( rule__TerminalToken__Group__0__Impl rule__TerminalToken__Group__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5392:2: rule__TerminalToken__Group__0__Impl rule__TerminalToken__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalToken__Group__0__Impl_in_rule__TerminalToken__Group__010875);
            rule__TerminalToken__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TerminalToken__Group__1_in_rule__TerminalToken__Group__010878);
            rule__TerminalToken__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalToken__Group__0"


    // $ANTLR start "rule__TerminalToken__Group__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5399:1: rule__TerminalToken__Group__0__Impl : ( ruleTerminalTokenElement ) ;
    public final void rule__TerminalToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5403:1: ( ( ruleTerminalTokenElement ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5404:1: ( ruleTerminalTokenElement )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5404:1: ( ruleTerminalTokenElement )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5405:1: ruleTerminalTokenElement
            {
             before(grammarAccess.getTerminalTokenAccess().getTerminalTokenElementParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_rule__TerminalToken__Group__0__Impl10905);
            ruleTerminalTokenElement();

            state._fsp--;

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
    // $ANTLR end "rule__TerminalToken__Group__0__Impl"


    // $ANTLR start "rule__TerminalToken__Group__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5416:1: rule__TerminalToken__Group__1 : rule__TerminalToken__Group__1__Impl ;
    public final void rule__TerminalToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5420:1: ( rule__TerminalToken__Group__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5421:2: rule__TerminalToken__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalToken__Group__1__Impl_in_rule__TerminalToken__Group__110934);
            rule__TerminalToken__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalToken__Group__1"


    // $ANTLR start "rule__TerminalToken__Group__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5427:1: rule__TerminalToken__Group__1__Impl : ( ( rule__TerminalToken__CardinalityAssignment_1 )? ) ;
    public final void rule__TerminalToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5431:1: ( ( ( rule__TerminalToken__CardinalityAssignment_1 )? ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5432:1: ( ( rule__TerminalToken__CardinalityAssignment_1 )? )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5432:1: ( ( rule__TerminalToken__CardinalityAssignment_1 )? )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5433:1: ( rule__TerminalToken__CardinalityAssignment_1 )?
            {
             before(grammarAccess.getTerminalTokenAccess().getCardinalityAssignment_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5434:1: ( rule__TerminalToken__CardinalityAssignment_1 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( ((LA46_0>=11 && LA46_0<=13)) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5434:2: rule__TerminalToken__CardinalityAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TerminalToken__CardinalityAssignment_1_in_rule__TerminalToken__Group__1__Impl10961);
                    rule__TerminalToken__CardinalityAssignment_1();

                    state._fsp--;


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
    // $ANTLR end "rule__TerminalToken__Group__1__Impl"


    // $ANTLR start "rule__ParenthesizedTerminalElement__Group__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5448:1: rule__ParenthesizedTerminalElement__Group__0 : rule__ParenthesizedTerminalElement__Group__0__Impl rule__ParenthesizedTerminalElement__Group__1 ;
    public final void rule__ParenthesizedTerminalElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5452:1: ( rule__ParenthesizedTerminalElement__Group__0__Impl rule__ParenthesizedTerminalElement__Group__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5453:2: rule__ParenthesizedTerminalElement__Group__0__Impl rule__ParenthesizedTerminalElement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedTerminalElement__Group__0__Impl_in_rule__ParenthesizedTerminalElement__Group__010996);
            rule__ParenthesizedTerminalElement__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedTerminalElement__Group__1_in_rule__ParenthesizedTerminalElement__Group__010999);
            rule__ParenthesizedTerminalElement__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedTerminalElement__Group__0"


    // $ANTLR start "rule__ParenthesizedTerminalElement__Group__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5460:1: rule__ParenthesizedTerminalElement__Group__0__Impl : ( '(' ) ;
    public final void rule__ParenthesizedTerminalElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5464:1: ( ( '(' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5465:1: ( '(' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5465:1: ( '(' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5466:1: '('
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getLeftParenthesisKeyword_0()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__ParenthesizedTerminalElement__Group__0__Impl11027); 
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
    // $ANTLR end "rule__ParenthesizedTerminalElement__Group__0__Impl"


    // $ANTLR start "rule__ParenthesizedTerminalElement__Group__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5479:1: rule__ParenthesizedTerminalElement__Group__1 : rule__ParenthesizedTerminalElement__Group__1__Impl rule__ParenthesizedTerminalElement__Group__2 ;
    public final void rule__ParenthesizedTerminalElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5483:1: ( rule__ParenthesizedTerminalElement__Group__1__Impl rule__ParenthesizedTerminalElement__Group__2 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5484:2: rule__ParenthesizedTerminalElement__Group__1__Impl rule__ParenthesizedTerminalElement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedTerminalElement__Group__1__Impl_in_rule__ParenthesizedTerminalElement__Group__111058);
            rule__ParenthesizedTerminalElement__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedTerminalElement__Group__2_in_rule__ParenthesizedTerminalElement__Group__111061);
            rule__ParenthesizedTerminalElement__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedTerminalElement__Group__1"


    // $ANTLR start "rule__ParenthesizedTerminalElement__Group__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5491:1: rule__ParenthesizedTerminalElement__Group__1__Impl : ( ruleTerminalAlternatives ) ;
    public final void rule__ParenthesizedTerminalElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5495:1: ( ( ruleTerminalAlternatives ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5496:1: ( ruleTerminalAlternatives )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5496:1: ( ruleTerminalAlternatives )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5497:1: ruleTerminalAlternatives
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getTerminalAlternativesParserRuleCall_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalAlternatives_in_rule__ParenthesizedTerminalElement__Group__1__Impl11088);
            ruleTerminalAlternatives();

            state._fsp--;

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
    // $ANTLR end "rule__ParenthesizedTerminalElement__Group__1__Impl"


    // $ANTLR start "rule__ParenthesizedTerminalElement__Group__2"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5508:1: rule__ParenthesizedTerminalElement__Group__2 : rule__ParenthesizedTerminalElement__Group__2__Impl ;
    public final void rule__ParenthesizedTerminalElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5512:1: ( rule__ParenthesizedTerminalElement__Group__2__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5513:2: rule__ParenthesizedTerminalElement__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedTerminalElement__Group__2__Impl_in_rule__ParenthesizedTerminalElement__Group__211117);
            rule__ParenthesizedTerminalElement__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedTerminalElement__Group__2"


    // $ANTLR start "rule__ParenthesizedTerminalElement__Group__2__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5519:1: rule__ParenthesizedTerminalElement__Group__2__Impl : ( ')' ) ;
    public final void rule__ParenthesizedTerminalElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5523:1: ( ( ')' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5524:1: ( ')' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5524:1: ( ')' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5525:1: ')'
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getRightParenthesisKeyword_2()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__ParenthesizedTerminalElement__Group__2__Impl11145); 
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
    // $ANTLR end "rule__ParenthesizedTerminalElement__Group__2__Impl"


    // $ANTLR start "rule__NegatedToken__Group__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5544:1: rule__NegatedToken__Group__0 : rule__NegatedToken__Group__0__Impl rule__NegatedToken__Group__1 ;
    public final void rule__NegatedToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5548:1: ( rule__NegatedToken__Group__0__Impl rule__NegatedToken__Group__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5549:2: rule__NegatedToken__Group__0__Impl rule__NegatedToken__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__NegatedToken__Group__0__Impl_in_rule__NegatedToken__Group__011182);
            rule__NegatedToken__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__NegatedToken__Group__1_in_rule__NegatedToken__Group__011185);
            rule__NegatedToken__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NegatedToken__Group__0"


    // $ANTLR start "rule__NegatedToken__Group__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5556:1: rule__NegatedToken__Group__0__Impl : ( '!' ) ;
    public final void rule__NegatedToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5560:1: ( ( '!' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5561:1: ( '!' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5561:1: ( '!' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5562:1: '!'
            {
             before(grammarAccess.getNegatedTokenAccess().getExclamationMarkKeyword_0()); 
            match(input,38,FollowSets000.FOLLOW_38_in_rule__NegatedToken__Group__0__Impl11213); 
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
    // $ANTLR end "rule__NegatedToken__Group__0__Impl"


    // $ANTLR start "rule__NegatedToken__Group__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5575:1: rule__NegatedToken__Group__1 : rule__NegatedToken__Group__1__Impl ;
    public final void rule__NegatedToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5579:1: ( rule__NegatedToken__Group__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5580:2: rule__NegatedToken__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__NegatedToken__Group__1__Impl_in_rule__NegatedToken__Group__111244);
            rule__NegatedToken__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NegatedToken__Group__1"


    // $ANTLR start "rule__NegatedToken__Group__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5586:1: rule__NegatedToken__Group__1__Impl : ( ( rule__NegatedToken__TerminalAssignment_1 ) ) ;
    public final void rule__NegatedToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5590:1: ( ( ( rule__NegatedToken__TerminalAssignment_1 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5591:1: ( ( rule__NegatedToken__TerminalAssignment_1 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5591:1: ( ( rule__NegatedToken__TerminalAssignment_1 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5592:1: ( rule__NegatedToken__TerminalAssignment_1 )
            {
             before(grammarAccess.getNegatedTokenAccess().getTerminalAssignment_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5593:1: ( rule__NegatedToken__TerminalAssignment_1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5593:2: rule__NegatedToken__TerminalAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__NegatedToken__TerminalAssignment_1_in_rule__NegatedToken__Group__1__Impl11271);
            rule__NegatedToken__TerminalAssignment_1();

            state._fsp--;


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
    // $ANTLR end "rule__NegatedToken__Group__1__Impl"


    // $ANTLR start "rule__UntilToken__Group__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5607:1: rule__UntilToken__Group__0 : rule__UntilToken__Group__0__Impl rule__UntilToken__Group__1 ;
    public final void rule__UntilToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5611:1: ( rule__UntilToken__Group__0__Impl rule__UntilToken__Group__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5612:2: rule__UntilToken__Group__0__Impl rule__UntilToken__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__UntilToken__Group__0__Impl_in_rule__UntilToken__Group__011305);
            rule__UntilToken__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__UntilToken__Group__1_in_rule__UntilToken__Group__011308);
            rule__UntilToken__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntilToken__Group__0"


    // $ANTLR start "rule__UntilToken__Group__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5619:1: rule__UntilToken__Group__0__Impl : ( '->' ) ;
    public final void rule__UntilToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5623:1: ( ( '->' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5624:1: ( '->' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5624:1: ( '->' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5625:1: '->'
            {
             before(grammarAccess.getUntilTokenAccess().getHyphenMinusGreaterThanSignKeyword_0()); 
            match(input,39,FollowSets000.FOLLOW_39_in_rule__UntilToken__Group__0__Impl11336); 
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
    // $ANTLR end "rule__UntilToken__Group__0__Impl"


    // $ANTLR start "rule__UntilToken__Group__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5638:1: rule__UntilToken__Group__1 : rule__UntilToken__Group__1__Impl ;
    public final void rule__UntilToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5642:1: ( rule__UntilToken__Group__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5643:2: rule__UntilToken__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__UntilToken__Group__1__Impl_in_rule__UntilToken__Group__111367);
            rule__UntilToken__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntilToken__Group__1"


    // $ANTLR start "rule__UntilToken__Group__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5649:1: rule__UntilToken__Group__1__Impl : ( ( rule__UntilToken__TerminalAssignment_1 ) ) ;
    public final void rule__UntilToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5653:1: ( ( ( rule__UntilToken__TerminalAssignment_1 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5654:1: ( ( rule__UntilToken__TerminalAssignment_1 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5654:1: ( ( rule__UntilToken__TerminalAssignment_1 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5655:1: ( rule__UntilToken__TerminalAssignment_1 )
            {
             before(grammarAccess.getUntilTokenAccess().getTerminalAssignment_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5656:1: ( rule__UntilToken__TerminalAssignment_1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5656:2: rule__UntilToken__TerminalAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__UntilToken__TerminalAssignment_1_in_rule__UntilToken__Group__1__Impl11394);
            rule__UntilToken__TerminalAssignment_1();

            state._fsp--;


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
    // $ANTLR end "rule__UntilToken__Group__1__Impl"


    // $ANTLR start "rule__Wildcard__Group__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5670:1: rule__Wildcard__Group__0 : rule__Wildcard__Group__0__Impl rule__Wildcard__Group__1 ;
    public final void rule__Wildcard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5674:1: ( rule__Wildcard__Group__0__Impl rule__Wildcard__Group__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5675:2: rule__Wildcard__Group__0__Impl rule__Wildcard__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Wildcard__Group__0__Impl_in_rule__Wildcard__Group__011428);
            rule__Wildcard__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Wildcard__Group__1_in_rule__Wildcard__Group__011431);
            rule__Wildcard__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wildcard__Group__0"


    // $ANTLR start "rule__Wildcard__Group__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5682:1: rule__Wildcard__Group__0__Impl : ( () ) ;
    public final void rule__Wildcard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5686:1: ( ( () ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5687:1: ( () )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5687:1: ( () )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5688:1: ()
            {
             before(grammarAccess.getWildcardAccess().getWildcardAction_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5689:1: ()
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5691:1: 
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
    // $ANTLR end "rule__Wildcard__Group__0__Impl"


    // $ANTLR start "rule__Wildcard__Group__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5701:1: rule__Wildcard__Group__1 : rule__Wildcard__Group__1__Impl ;
    public final void rule__Wildcard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5705:1: ( rule__Wildcard__Group__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5706:2: rule__Wildcard__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Wildcard__Group__1__Impl_in_rule__Wildcard__Group__111489);
            rule__Wildcard__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wildcard__Group__1"


    // $ANTLR start "rule__Wildcard__Group__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5712:1: rule__Wildcard__Group__1__Impl : ( '.' ) ;
    public final void rule__Wildcard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5716:1: ( ( '.' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5717:1: ( '.' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5717:1: ( '.' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5718:1: '.'
            {
             before(grammarAccess.getWildcardAccess().getFullStopKeyword_1()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__Wildcard__Group__1__Impl11517); 
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
    // $ANTLR end "rule__Wildcard__Group__1__Impl"


    // $ANTLR start "rule__CharacterRange__Group__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5735:1: rule__CharacterRange__Group__0 : rule__CharacterRange__Group__0__Impl rule__CharacterRange__Group__1 ;
    public final void rule__CharacterRange__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5739:1: ( rule__CharacterRange__Group__0__Impl rule__CharacterRange__Group__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5740:2: rule__CharacterRange__Group__0__Impl rule__CharacterRange__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group__0__Impl_in_rule__CharacterRange__Group__011552);
            rule__CharacterRange__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group__1_in_rule__CharacterRange__Group__011555);
            rule__CharacterRange__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterRange__Group__0"


    // $ANTLR start "rule__CharacterRange__Group__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5747:1: rule__CharacterRange__Group__0__Impl : ( ruleKeyword ) ;
    public final void rule__CharacterRange__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5751:1: ( ( ruleKeyword ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5752:1: ( ruleKeyword )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5752:1: ( ruleKeyword )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5753:1: ruleKeyword
            {
             before(grammarAccess.getCharacterRangeAccess().getKeywordParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_rule__CharacterRange__Group__0__Impl11582);
            ruleKeyword();

            state._fsp--;

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
    // $ANTLR end "rule__CharacterRange__Group__0__Impl"


    // $ANTLR start "rule__CharacterRange__Group__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5764:1: rule__CharacterRange__Group__1 : rule__CharacterRange__Group__1__Impl ;
    public final void rule__CharacterRange__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5768:1: ( rule__CharacterRange__Group__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5769:2: rule__CharacterRange__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group__1__Impl_in_rule__CharacterRange__Group__111611);
            rule__CharacterRange__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterRange__Group__1"


    // $ANTLR start "rule__CharacterRange__Group__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5775:1: rule__CharacterRange__Group__1__Impl : ( ( rule__CharacterRange__Group_1__0 )? ) ;
    public final void rule__CharacterRange__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5779:1: ( ( ( rule__CharacterRange__Group_1__0 )? ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5780:1: ( ( rule__CharacterRange__Group_1__0 )? )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5780:1: ( ( rule__CharacterRange__Group_1__0 )? )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5781:1: ( rule__CharacterRange__Group_1__0 )?
            {
             before(grammarAccess.getCharacterRangeAccess().getGroup_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5782:1: ( rule__CharacterRange__Group_1__0 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==40) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5782:2: rule__CharacterRange__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group_1__0_in_rule__CharacterRange__Group__1__Impl11638);
                    rule__CharacterRange__Group_1__0();

                    state._fsp--;


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
    // $ANTLR end "rule__CharacterRange__Group__1__Impl"


    // $ANTLR start "rule__CharacterRange__Group_1__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5796:1: rule__CharacterRange__Group_1__0 : rule__CharacterRange__Group_1__0__Impl rule__CharacterRange__Group_1__1 ;
    public final void rule__CharacterRange__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5800:1: ( rule__CharacterRange__Group_1__0__Impl rule__CharacterRange__Group_1__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5801:2: rule__CharacterRange__Group_1__0__Impl rule__CharacterRange__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group_1__0__Impl_in_rule__CharacterRange__Group_1__011673);
            rule__CharacterRange__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group_1__1_in_rule__CharacterRange__Group_1__011676);
            rule__CharacterRange__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterRange__Group_1__0"


    // $ANTLR start "rule__CharacterRange__Group_1__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5808:1: rule__CharacterRange__Group_1__0__Impl : ( () ) ;
    public final void rule__CharacterRange__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5812:1: ( ( () ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5813:1: ( () )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5813:1: ( () )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5814:1: ()
            {
             before(grammarAccess.getCharacterRangeAccess().getCharacterRangeLeftAction_1_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5815:1: ()
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5817:1: 
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
    // $ANTLR end "rule__CharacterRange__Group_1__0__Impl"


    // $ANTLR start "rule__CharacterRange__Group_1__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5827:1: rule__CharacterRange__Group_1__1 : rule__CharacterRange__Group_1__1__Impl rule__CharacterRange__Group_1__2 ;
    public final void rule__CharacterRange__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5831:1: ( rule__CharacterRange__Group_1__1__Impl rule__CharacterRange__Group_1__2 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5832:2: rule__CharacterRange__Group_1__1__Impl rule__CharacterRange__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group_1__1__Impl_in_rule__CharacterRange__Group_1__111734);
            rule__CharacterRange__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group_1__2_in_rule__CharacterRange__Group_1__111737);
            rule__CharacterRange__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterRange__Group_1__1"


    // $ANTLR start "rule__CharacterRange__Group_1__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5839:1: rule__CharacterRange__Group_1__1__Impl : ( '..' ) ;
    public final void rule__CharacterRange__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5843:1: ( ( '..' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5844:1: ( '..' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5844:1: ( '..' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5845:1: '..'
            {
             before(grammarAccess.getCharacterRangeAccess().getFullStopFullStopKeyword_1_1()); 
            match(input,40,FollowSets000.FOLLOW_40_in_rule__CharacterRange__Group_1__1__Impl11765); 
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
    // $ANTLR end "rule__CharacterRange__Group_1__1__Impl"


    // $ANTLR start "rule__CharacterRange__Group_1__2"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5858:1: rule__CharacterRange__Group_1__2 : rule__CharacterRange__Group_1__2__Impl ;
    public final void rule__CharacterRange__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5862:1: ( rule__CharacterRange__Group_1__2__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5863:2: rule__CharacterRange__Group_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group_1__2__Impl_in_rule__CharacterRange__Group_1__211796);
            rule__CharacterRange__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterRange__Group_1__2"


    // $ANTLR start "rule__CharacterRange__Group_1__2__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5869:1: rule__CharacterRange__Group_1__2__Impl : ( ( rule__CharacterRange__RightAssignment_1_2 ) ) ;
    public final void rule__CharacterRange__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5873:1: ( ( ( rule__CharacterRange__RightAssignment_1_2 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5874:1: ( ( rule__CharacterRange__RightAssignment_1_2 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5874:1: ( ( rule__CharacterRange__RightAssignment_1_2 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5875:1: ( rule__CharacterRange__RightAssignment_1_2 )
            {
             before(grammarAccess.getCharacterRangeAccess().getRightAssignment_1_2()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5876:1: ( rule__CharacterRange__RightAssignment_1_2 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5876:2: rule__CharacterRange__RightAssignment_1_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__RightAssignment_1_2_in_rule__CharacterRange__Group_1__2__Impl11823);
            rule__CharacterRange__RightAssignment_1_2();

            state._fsp--;


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
    // $ANTLR end "rule__CharacterRange__Group_1__2__Impl"


    // $ANTLR start "rule__EnumRule__Group__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5892:1: rule__EnumRule__Group__0 : rule__EnumRule__Group__0__Impl rule__EnumRule__Group__1 ;
    public final void rule__EnumRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5896:1: ( rule__EnumRule__Group__0__Impl rule__EnumRule__Group__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5897:2: rule__EnumRule__Group__0__Impl rule__EnumRule__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__0__Impl_in_rule__EnumRule__Group__011859);
            rule__EnumRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__1_in_rule__EnumRule__Group__011862);
            rule__EnumRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__Group__0"


    // $ANTLR start "rule__EnumRule__Group__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5904:1: rule__EnumRule__Group__0__Impl : ( 'enum' ) ;
    public final void rule__EnumRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5908:1: ( ( 'enum' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5909:1: ( 'enum' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5909:1: ( 'enum' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5910:1: 'enum'
            {
             before(grammarAccess.getEnumRuleAccess().getEnumKeyword_0()); 
            match(input,41,FollowSets000.FOLLOW_41_in_rule__EnumRule__Group__0__Impl11890); 
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
    // $ANTLR end "rule__EnumRule__Group__0__Impl"


    // $ANTLR start "rule__EnumRule__Group__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5923:1: rule__EnumRule__Group__1 : rule__EnumRule__Group__1__Impl rule__EnumRule__Group__2 ;
    public final void rule__EnumRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5927:1: ( rule__EnumRule__Group__1__Impl rule__EnumRule__Group__2 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5928:2: rule__EnumRule__Group__1__Impl rule__EnumRule__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__1__Impl_in_rule__EnumRule__Group__111921);
            rule__EnumRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__2_in_rule__EnumRule__Group__111924);
            rule__EnumRule__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__Group__1"


    // $ANTLR start "rule__EnumRule__Group__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5935:1: rule__EnumRule__Group__1__Impl : ( ( rule__EnumRule__NameAssignment_1 ) ) ;
    public final void rule__EnumRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5939:1: ( ( ( rule__EnumRule__NameAssignment_1 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5940:1: ( ( rule__EnumRule__NameAssignment_1 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5940:1: ( ( rule__EnumRule__NameAssignment_1 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5941:1: ( rule__EnumRule__NameAssignment_1 )
            {
             before(grammarAccess.getEnumRuleAccess().getNameAssignment_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5942:1: ( rule__EnumRule__NameAssignment_1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5942:2: rule__EnumRule__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__NameAssignment_1_in_rule__EnumRule__Group__1__Impl11951);
            rule__EnumRule__NameAssignment_1();

            state._fsp--;


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
    // $ANTLR end "rule__EnumRule__Group__1__Impl"


    // $ANTLR start "rule__EnumRule__Group__2"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5952:1: rule__EnumRule__Group__2 : rule__EnumRule__Group__2__Impl rule__EnumRule__Group__3 ;
    public final void rule__EnumRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5956:1: ( rule__EnumRule__Group__2__Impl rule__EnumRule__Group__3 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5957:2: rule__EnumRule__Group__2__Impl rule__EnumRule__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__2__Impl_in_rule__EnumRule__Group__211981);
            rule__EnumRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__3_in_rule__EnumRule__Group__211984);
            rule__EnumRule__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__Group__2"


    // $ANTLR start "rule__EnumRule__Group__2__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5964:1: rule__EnumRule__Group__2__Impl : ( ( rule__EnumRule__Group_2__0 )? ) ;
    public final void rule__EnumRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5968:1: ( ( ( rule__EnumRule__Group_2__0 )? ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5969:1: ( ( rule__EnumRule__Group_2__0 )? )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5969:1: ( ( rule__EnumRule__Group_2__0 )? )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5970:1: ( rule__EnumRule__Group_2__0 )?
            {
             before(grammarAccess.getEnumRuleAccess().getGroup_2()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5971:1: ( rule__EnumRule__Group_2__0 )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==28) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5971:2: rule__EnumRule__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group_2__0_in_rule__EnumRule__Group__2__Impl12011);
                    rule__EnumRule__Group_2__0();

                    state._fsp--;


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
    // $ANTLR end "rule__EnumRule__Group__2__Impl"


    // $ANTLR start "rule__EnumRule__Group__3"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5981:1: rule__EnumRule__Group__3 : rule__EnumRule__Group__3__Impl rule__EnumRule__Group__4 ;
    public final void rule__EnumRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5985:1: ( rule__EnumRule__Group__3__Impl rule__EnumRule__Group__4 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5986:2: rule__EnumRule__Group__3__Impl rule__EnumRule__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__3__Impl_in_rule__EnumRule__Group__312042);
            rule__EnumRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__4_in_rule__EnumRule__Group__312045);
            rule__EnumRule__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__Group__3"


    // $ANTLR start "rule__EnumRule__Group__3__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5993:1: rule__EnumRule__Group__3__Impl : ( ':' ) ;
    public final void rule__EnumRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5997:1: ( ( ':' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5998:1: ( ':' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5998:1: ( ':' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5999:1: ':'
            {
             before(grammarAccess.getEnumRuleAccess().getColonKeyword_3()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__EnumRule__Group__3__Impl12073); 
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
    // $ANTLR end "rule__EnumRule__Group__3__Impl"


    // $ANTLR start "rule__EnumRule__Group__4"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6012:1: rule__EnumRule__Group__4 : rule__EnumRule__Group__4__Impl rule__EnumRule__Group__5 ;
    public final void rule__EnumRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6016:1: ( rule__EnumRule__Group__4__Impl rule__EnumRule__Group__5 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6017:2: rule__EnumRule__Group__4__Impl rule__EnumRule__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__4__Impl_in_rule__EnumRule__Group__412104);
            rule__EnumRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__5_in_rule__EnumRule__Group__412107);
            rule__EnumRule__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__Group__4"


    // $ANTLR start "rule__EnumRule__Group__4__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6024:1: rule__EnumRule__Group__4__Impl : ( ( rule__EnumRule__AlternativesAssignment_4 ) ) ;
    public final void rule__EnumRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6028:1: ( ( ( rule__EnumRule__AlternativesAssignment_4 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6029:1: ( ( rule__EnumRule__AlternativesAssignment_4 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6029:1: ( ( rule__EnumRule__AlternativesAssignment_4 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6030:1: ( rule__EnumRule__AlternativesAssignment_4 )
            {
             before(grammarAccess.getEnumRuleAccess().getAlternativesAssignment_4()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6031:1: ( rule__EnumRule__AlternativesAssignment_4 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6031:2: rule__EnumRule__AlternativesAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__AlternativesAssignment_4_in_rule__EnumRule__Group__4__Impl12134);
            rule__EnumRule__AlternativesAssignment_4();

            state._fsp--;


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
    // $ANTLR end "rule__EnumRule__Group__4__Impl"


    // $ANTLR start "rule__EnumRule__Group__5"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6041:1: rule__EnumRule__Group__5 : rule__EnumRule__Group__5__Impl ;
    public final void rule__EnumRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6045:1: ( rule__EnumRule__Group__5__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6046:2: rule__EnumRule__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__5__Impl_in_rule__EnumRule__Group__512164);
            rule__EnumRule__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__Group__5"


    // $ANTLR start "rule__EnumRule__Group__5__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6052:1: rule__EnumRule__Group__5__Impl : ( ';' ) ;
    public final void rule__EnumRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6056:1: ( ( ';' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6057:1: ( ';' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6057:1: ( ';' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6058:1: ';'
            {
             before(grammarAccess.getEnumRuleAccess().getSemicolonKeyword_5()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__EnumRule__Group__5__Impl12192); 
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
    // $ANTLR end "rule__EnumRule__Group__5__Impl"


    // $ANTLR start "rule__EnumRule__Group_2__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6083:1: rule__EnumRule__Group_2__0 : rule__EnumRule__Group_2__0__Impl rule__EnumRule__Group_2__1 ;
    public final void rule__EnumRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6087:1: ( rule__EnumRule__Group_2__0__Impl rule__EnumRule__Group_2__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6088:2: rule__EnumRule__Group_2__0__Impl rule__EnumRule__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group_2__0__Impl_in_rule__EnumRule__Group_2__012235);
            rule__EnumRule__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group_2__1_in_rule__EnumRule__Group_2__012238);
            rule__EnumRule__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__Group_2__0"


    // $ANTLR start "rule__EnumRule__Group_2__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6095:1: rule__EnumRule__Group_2__0__Impl : ( 'returns' ) ;
    public final void rule__EnumRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6099:1: ( ( 'returns' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6100:1: ( 'returns' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6100:1: ( 'returns' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6101:1: 'returns'
            {
             before(grammarAccess.getEnumRuleAccess().getReturnsKeyword_2_0()); 
            match(input,28,FollowSets000.FOLLOW_28_in_rule__EnumRule__Group_2__0__Impl12266); 
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
    // $ANTLR end "rule__EnumRule__Group_2__0__Impl"


    // $ANTLR start "rule__EnumRule__Group_2__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6114:1: rule__EnumRule__Group_2__1 : rule__EnumRule__Group_2__1__Impl ;
    public final void rule__EnumRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6118:1: ( rule__EnumRule__Group_2__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6119:2: rule__EnumRule__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group_2__1__Impl_in_rule__EnumRule__Group_2__112297);
            rule__EnumRule__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__Group_2__1"


    // $ANTLR start "rule__EnumRule__Group_2__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6125:1: rule__EnumRule__Group_2__1__Impl : ( ( rule__EnumRule__TypeAssignment_2_1 ) ) ;
    public final void rule__EnumRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6129:1: ( ( ( rule__EnumRule__TypeAssignment_2_1 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6130:1: ( ( rule__EnumRule__TypeAssignment_2_1 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6130:1: ( ( rule__EnumRule__TypeAssignment_2_1 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6131:1: ( rule__EnumRule__TypeAssignment_2_1 )
            {
             before(grammarAccess.getEnumRuleAccess().getTypeAssignment_2_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6132:1: ( rule__EnumRule__TypeAssignment_2_1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6132:2: rule__EnumRule__TypeAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__TypeAssignment_2_1_in_rule__EnumRule__Group_2__1__Impl12324);
            rule__EnumRule__TypeAssignment_2_1();

            state._fsp--;


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
    // $ANTLR end "rule__EnumRule__Group_2__1__Impl"


    // $ANTLR start "rule__EnumLiterals__Group__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6146:1: rule__EnumLiterals__Group__0 : rule__EnumLiterals__Group__0__Impl rule__EnumLiterals__Group__1 ;
    public final void rule__EnumLiterals__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6150:1: ( rule__EnumLiterals__Group__0__Impl rule__EnumLiterals__Group__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6151:2: rule__EnumLiterals__Group__0__Impl rule__EnumLiterals__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group__0__Impl_in_rule__EnumLiterals__Group__012358);
            rule__EnumLiterals__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group__1_in_rule__EnumLiterals__Group__012361);
            rule__EnumLiterals__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiterals__Group__0"


    // $ANTLR start "rule__EnumLiterals__Group__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6158:1: rule__EnumLiterals__Group__0__Impl : ( ruleEnumLiteralDeclaration ) ;
    public final void rule__EnumLiterals__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6162:1: ( ( ruleEnumLiteralDeclaration ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6163:1: ( ruleEnumLiteralDeclaration )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6163:1: ( ruleEnumLiteralDeclaration )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6164:1: ruleEnumLiteralDeclaration
            {
             before(grammarAccess.getEnumLiteralsAccess().getEnumLiteralDeclarationParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiteralDeclaration_in_rule__EnumLiterals__Group__0__Impl12388);
            ruleEnumLiteralDeclaration();

            state._fsp--;

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
    // $ANTLR end "rule__EnumLiterals__Group__0__Impl"


    // $ANTLR start "rule__EnumLiterals__Group__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6175:1: rule__EnumLiterals__Group__1 : rule__EnumLiterals__Group__1__Impl ;
    public final void rule__EnumLiterals__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6179:1: ( rule__EnumLiterals__Group__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6180:2: rule__EnumLiterals__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group__1__Impl_in_rule__EnumLiterals__Group__112417);
            rule__EnumLiterals__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiterals__Group__1"


    // $ANTLR start "rule__EnumLiterals__Group__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6186:1: rule__EnumLiterals__Group__1__Impl : ( ( rule__EnumLiterals__Group_1__0 )? ) ;
    public final void rule__EnumLiterals__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6190:1: ( ( ( rule__EnumLiterals__Group_1__0 )? ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6191:1: ( ( rule__EnumLiterals__Group_1__0 )? )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6191:1: ( ( rule__EnumLiterals__Group_1__0 )? )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6192:1: ( rule__EnumLiterals__Group_1__0 )?
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6193:1: ( rule__EnumLiterals__Group_1__0 )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==30) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6193:2: rule__EnumLiterals__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group_1__0_in_rule__EnumLiterals__Group__1__Impl12444);
                    rule__EnumLiterals__Group_1__0();

                    state._fsp--;


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
    // $ANTLR end "rule__EnumLiterals__Group__1__Impl"


    // $ANTLR start "rule__EnumLiterals__Group_1__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6207:1: rule__EnumLiterals__Group_1__0 : rule__EnumLiterals__Group_1__0__Impl rule__EnumLiterals__Group_1__1 ;
    public final void rule__EnumLiterals__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6211:1: ( rule__EnumLiterals__Group_1__0__Impl rule__EnumLiterals__Group_1__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6212:2: rule__EnumLiterals__Group_1__0__Impl rule__EnumLiterals__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group_1__0__Impl_in_rule__EnumLiterals__Group_1__012479);
            rule__EnumLiterals__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group_1__1_in_rule__EnumLiterals__Group_1__012482);
            rule__EnumLiterals__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiterals__Group_1__0"


    // $ANTLR start "rule__EnumLiterals__Group_1__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6219:1: rule__EnumLiterals__Group_1__0__Impl : ( () ) ;
    public final void rule__EnumLiterals__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6223:1: ( ( () ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6224:1: ( () )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6224:1: ( () )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6225:1: ()
            {
             before(grammarAccess.getEnumLiteralsAccess().getAlternativesElementsAction_1_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6226:1: ()
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6228:1: 
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
    // $ANTLR end "rule__EnumLiterals__Group_1__0__Impl"


    // $ANTLR start "rule__EnumLiterals__Group_1__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6238:1: rule__EnumLiterals__Group_1__1 : rule__EnumLiterals__Group_1__1__Impl ;
    public final void rule__EnumLiterals__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6242:1: ( rule__EnumLiterals__Group_1__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6243:2: rule__EnumLiterals__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group_1__1__Impl_in_rule__EnumLiterals__Group_1__112540);
            rule__EnumLiterals__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiterals__Group_1__1"


    // $ANTLR start "rule__EnumLiterals__Group_1__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6249:1: rule__EnumLiterals__Group_1__1__Impl : ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) ) ;
    public final void rule__EnumLiterals__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6253:1: ( ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6254:1: ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6254:1: ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6255:1: ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6255:1: ( ( rule__EnumLiterals__Group_1_1__0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6256:1: ( rule__EnumLiterals__Group_1_1__0 )
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6257:1: ( rule__EnumLiterals__Group_1_1__0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6257:2: rule__EnumLiterals__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group_1_1__0_in_rule__EnumLiterals__Group_1__1__Impl12569);
            rule__EnumLiterals__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 

            }

            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6260:1: ( ( rule__EnumLiterals__Group_1_1__0 )* )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6261:1: ( rule__EnumLiterals__Group_1_1__0 )*
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6262:1: ( rule__EnumLiterals__Group_1_1__0 )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==30) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6262:2: rule__EnumLiterals__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group_1_1__0_in_rule__EnumLiterals__Group_1__1__Impl12581);
            	    rule__EnumLiterals__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop50;
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
    // $ANTLR end "rule__EnumLiterals__Group_1__1__Impl"


    // $ANTLR start "rule__EnumLiterals__Group_1_1__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6277:1: rule__EnumLiterals__Group_1_1__0 : rule__EnumLiterals__Group_1_1__0__Impl rule__EnumLiterals__Group_1_1__1 ;
    public final void rule__EnumLiterals__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6281:1: ( rule__EnumLiterals__Group_1_1__0__Impl rule__EnumLiterals__Group_1_1__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6282:2: rule__EnumLiterals__Group_1_1__0__Impl rule__EnumLiterals__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group_1_1__0__Impl_in_rule__EnumLiterals__Group_1_1__012618);
            rule__EnumLiterals__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group_1_1__1_in_rule__EnumLiterals__Group_1_1__012621);
            rule__EnumLiterals__Group_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiterals__Group_1_1__0"


    // $ANTLR start "rule__EnumLiterals__Group_1_1__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6289:1: rule__EnumLiterals__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__EnumLiterals__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6293:1: ( ( '|' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6294:1: ( '|' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6294:1: ( '|' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6295:1: '|'
            {
             before(grammarAccess.getEnumLiteralsAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__EnumLiterals__Group_1_1__0__Impl12649); 
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
    // $ANTLR end "rule__EnumLiterals__Group_1_1__0__Impl"


    // $ANTLR start "rule__EnumLiterals__Group_1_1__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6308:1: rule__EnumLiterals__Group_1_1__1 : rule__EnumLiterals__Group_1_1__1__Impl ;
    public final void rule__EnumLiterals__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6312:1: ( rule__EnumLiterals__Group_1_1__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6313:2: rule__EnumLiterals__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group_1_1__1__Impl_in_rule__EnumLiterals__Group_1_1__112680);
            rule__EnumLiterals__Group_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiterals__Group_1_1__1"


    // $ANTLR start "rule__EnumLiterals__Group_1_1__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6319:1: rule__EnumLiterals__Group_1_1__1__Impl : ( ( rule__EnumLiterals__ElementsAssignment_1_1_1 ) ) ;
    public final void rule__EnumLiterals__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6323:1: ( ( ( rule__EnumLiterals__ElementsAssignment_1_1_1 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6324:1: ( ( rule__EnumLiterals__ElementsAssignment_1_1_1 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6324:1: ( ( rule__EnumLiterals__ElementsAssignment_1_1_1 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6325:1: ( rule__EnumLiterals__ElementsAssignment_1_1_1 )
            {
             before(grammarAccess.getEnumLiteralsAccess().getElementsAssignment_1_1_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6326:1: ( rule__EnumLiterals__ElementsAssignment_1_1_1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6326:2: rule__EnumLiterals__ElementsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__ElementsAssignment_1_1_1_in_rule__EnumLiterals__Group_1_1__1__Impl12707);
            rule__EnumLiterals__ElementsAssignment_1_1_1();

            state._fsp--;


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
    // $ANTLR end "rule__EnumLiterals__Group_1_1__1__Impl"


    // $ANTLR start "rule__EnumLiteralDeclaration__Group__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6340:1: rule__EnumLiteralDeclaration__Group__0 : rule__EnumLiteralDeclaration__Group__0__Impl rule__EnumLiteralDeclaration__Group__1 ;
    public final void rule__EnumLiteralDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6344:1: ( rule__EnumLiteralDeclaration__Group__0__Impl rule__EnumLiteralDeclaration__Group__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6345:2: rule__EnumLiteralDeclaration__Group__0__Impl rule__EnumLiteralDeclaration__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__Group__0__Impl_in_rule__EnumLiteralDeclaration__Group__012741);
            rule__EnumLiteralDeclaration__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__Group__1_in_rule__EnumLiteralDeclaration__Group__012744);
            rule__EnumLiteralDeclaration__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiteralDeclaration__Group__0"


    // $ANTLR start "rule__EnumLiteralDeclaration__Group__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6352:1: rule__EnumLiteralDeclaration__Group__0__Impl : ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) ) ;
    public final void rule__EnumLiteralDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6356:1: ( ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6357:1: ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6357:1: ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6358:1: ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralAssignment_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6359:1: ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6359:2: rule__EnumLiteralDeclaration__EnumLiteralAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__EnumLiteralAssignment_0_in_rule__EnumLiteralDeclaration__Group__0__Impl12771);
            rule__EnumLiteralDeclaration__EnumLiteralAssignment_0();

            state._fsp--;


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
    // $ANTLR end "rule__EnumLiteralDeclaration__Group__0__Impl"


    // $ANTLR start "rule__EnumLiteralDeclaration__Group__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6369:1: rule__EnumLiteralDeclaration__Group__1 : rule__EnumLiteralDeclaration__Group__1__Impl ;
    public final void rule__EnumLiteralDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6373:1: ( rule__EnumLiteralDeclaration__Group__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6374:2: rule__EnumLiteralDeclaration__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__Group__1__Impl_in_rule__EnumLiteralDeclaration__Group__112801);
            rule__EnumLiteralDeclaration__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiteralDeclaration__Group__1"


    // $ANTLR start "rule__EnumLiteralDeclaration__Group__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6380:1: rule__EnumLiteralDeclaration__Group__1__Impl : ( ( rule__EnumLiteralDeclaration__Group_1__0 )? ) ;
    public final void rule__EnumLiteralDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6384:1: ( ( ( rule__EnumLiteralDeclaration__Group_1__0 )? ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6385:1: ( ( rule__EnumLiteralDeclaration__Group_1__0 )? )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6385:1: ( ( rule__EnumLiteralDeclaration__Group_1__0 )? )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6386:1: ( rule__EnumLiteralDeclaration__Group_1__0 )?
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getGroup_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6387:1: ( rule__EnumLiteralDeclaration__Group_1__0 )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==14) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6387:2: rule__EnumLiteralDeclaration__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__Group_1__0_in_rule__EnumLiteralDeclaration__Group__1__Impl12828);
                    rule__EnumLiteralDeclaration__Group_1__0();

                    state._fsp--;


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
    // $ANTLR end "rule__EnumLiteralDeclaration__Group__1__Impl"


    // $ANTLR start "rule__EnumLiteralDeclaration__Group_1__0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6401:1: rule__EnumLiteralDeclaration__Group_1__0 : rule__EnumLiteralDeclaration__Group_1__0__Impl rule__EnumLiteralDeclaration__Group_1__1 ;
    public final void rule__EnumLiteralDeclaration__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6405:1: ( rule__EnumLiteralDeclaration__Group_1__0__Impl rule__EnumLiteralDeclaration__Group_1__1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6406:2: rule__EnumLiteralDeclaration__Group_1__0__Impl rule__EnumLiteralDeclaration__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__Group_1__0__Impl_in_rule__EnumLiteralDeclaration__Group_1__012863);
            rule__EnumLiteralDeclaration__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__Group_1__1_in_rule__EnumLiteralDeclaration__Group_1__012866);
            rule__EnumLiteralDeclaration__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiteralDeclaration__Group_1__0"


    // $ANTLR start "rule__EnumLiteralDeclaration__Group_1__0__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6413:1: rule__EnumLiteralDeclaration__Group_1__0__Impl : ( '=' ) ;
    public final void rule__EnumLiteralDeclaration__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6417:1: ( ( '=' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6418:1: ( '=' )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6418:1: ( '=' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6419:1: '='
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEqualsSignKeyword_1_0()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__EnumLiteralDeclaration__Group_1__0__Impl12894); 
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
    // $ANTLR end "rule__EnumLiteralDeclaration__Group_1__0__Impl"


    // $ANTLR start "rule__EnumLiteralDeclaration__Group_1__1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6432:1: rule__EnumLiteralDeclaration__Group_1__1 : rule__EnumLiteralDeclaration__Group_1__1__Impl ;
    public final void rule__EnumLiteralDeclaration__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6436:1: ( rule__EnumLiteralDeclaration__Group_1__1__Impl )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6437:2: rule__EnumLiteralDeclaration__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__Group_1__1__Impl_in_rule__EnumLiteralDeclaration__Group_1__112925);
            rule__EnumLiteralDeclaration__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiteralDeclaration__Group_1__1"


    // $ANTLR start "rule__EnumLiteralDeclaration__Group_1__1__Impl"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6443:1: rule__EnumLiteralDeclaration__Group_1__1__Impl : ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) ) ;
    public final void rule__EnumLiteralDeclaration__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6447:1: ( ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6448:1: ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6448:1: ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6449:1: ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralAssignment_1_1()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6450:1: ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6450:2: rule__EnumLiteralDeclaration__LiteralAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__LiteralAssignment_1_1_in_rule__EnumLiteralDeclaration__Group_1__1__Impl12952);
            rule__EnumLiteralDeclaration__LiteralAssignment_1_1();

            state._fsp--;


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
    // $ANTLR end "rule__EnumLiteralDeclaration__Group_1__1__Impl"


    // $ANTLR start "rule__Grammar__NameAssignment_1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6465:1: rule__Grammar__NameAssignment_1 : ( ruleGrammarID ) ;
    public final void rule__Grammar__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6469:1: ( ( ruleGrammarID ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6470:1: ( ruleGrammarID )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6470:1: ( ruleGrammarID )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6471:1: ruleGrammarID
            {
             before(grammarAccess.getGrammarAccess().getNameGrammarIDParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_rule__Grammar__NameAssignment_112991);
            ruleGrammarID();

            state._fsp--;

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
    // $ANTLR end "rule__Grammar__NameAssignment_1"


    // $ANTLR start "rule__Grammar__UsedGrammarsAssignment_2_1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6480:1: rule__Grammar__UsedGrammarsAssignment_2_1 : ( ( ruleGrammarID ) ) ;
    public final void rule__Grammar__UsedGrammarsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6484:1: ( ( ( ruleGrammarID ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6485:1: ( ( ruleGrammarID ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6485:1: ( ( ruleGrammarID ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6486:1: ( ruleGrammarID )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_1_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6487:1: ( ruleGrammarID )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6488:1: ruleGrammarID
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarGrammarIDParserRuleCall_2_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_rule__Grammar__UsedGrammarsAssignment_2_113026);
            ruleGrammarID();

            state._fsp--;

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
    // $ANTLR end "rule__Grammar__UsedGrammarsAssignment_2_1"


    // $ANTLR start "rule__Grammar__UsedGrammarsAssignment_2_2_1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6499:1: rule__Grammar__UsedGrammarsAssignment_2_2_1 : ( ( ruleGrammarID ) ) ;
    public final void rule__Grammar__UsedGrammarsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6503:1: ( ( ( ruleGrammarID ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6504:1: ( ( ruleGrammarID ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6504:1: ( ( ruleGrammarID ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6505:1: ( ruleGrammarID )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_2_1_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6506:1: ( ruleGrammarID )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6507:1: ruleGrammarID
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarGrammarIDParserRuleCall_2_2_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_rule__Grammar__UsedGrammarsAssignment_2_2_113065);
            ruleGrammarID();

            state._fsp--;

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
    // $ANTLR end "rule__Grammar__UsedGrammarsAssignment_2_2_1"


    // $ANTLR start "rule__Grammar__DefinesHiddenTokensAssignment_3_0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6518:1: rule__Grammar__DefinesHiddenTokensAssignment_3_0 : ( ( 'hidden' ) ) ;
    public final void rule__Grammar__DefinesHiddenTokensAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6522:1: ( ( ( 'hidden' ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6523:1: ( ( 'hidden' ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6523:1: ( ( 'hidden' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6524:1: ( 'hidden' )
            {
             before(grammarAccess.getGrammarAccess().getDefinesHiddenTokensHiddenKeyword_3_0_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6525:1: ( 'hidden' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6526:1: 'hidden'
            {
             before(grammarAccess.getGrammarAccess().getDefinesHiddenTokensHiddenKeyword_3_0_0()); 
            match(input,42,FollowSets000.FOLLOW_42_in_rule__Grammar__DefinesHiddenTokensAssignment_3_013105); 
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
    // $ANTLR end "rule__Grammar__DefinesHiddenTokensAssignment_3_0"


    // $ANTLR start "rule__Grammar__HiddenTokensAssignment_3_2_0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6541:1: rule__Grammar__HiddenTokensAssignment_3_2_0 : ( ( RULE_ID ) ) ;
    public final void rule__Grammar__HiddenTokensAssignment_3_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6545:1: ( ( ( RULE_ID ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6546:1: ( ( RULE_ID ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6546:1: ( ( RULE_ID ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6547:1: ( RULE_ID )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_0_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6548:1: ( RULE_ID )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6549:1: RULE_ID
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_3_2_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Grammar__HiddenTokensAssignment_3_2_013148); 
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
    // $ANTLR end "rule__Grammar__HiddenTokensAssignment_3_2_0"


    // $ANTLR start "rule__Grammar__HiddenTokensAssignment_3_2_1_1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6560:1: rule__Grammar__HiddenTokensAssignment_3_2_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Grammar__HiddenTokensAssignment_3_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6564:1: ( ( ( RULE_ID ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6565:1: ( ( RULE_ID ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6565:1: ( ( RULE_ID ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6566:1: ( RULE_ID )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_1_1_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6567:1: ( RULE_ID )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6568:1: RULE_ID
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_3_2_1_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Grammar__HiddenTokensAssignment_3_2_1_113187); 
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
    // $ANTLR end "rule__Grammar__HiddenTokensAssignment_3_2_1_1"


    // $ANTLR start "rule__Grammar__MetamodelDeclarationsAssignment_4"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6579:1: rule__Grammar__MetamodelDeclarationsAssignment_4 : ( ruleAbstractMetamodelDeclaration ) ;
    public final void rule__Grammar__MetamodelDeclarationsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6583:1: ( ( ruleAbstractMetamodelDeclaration ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6584:1: ( ruleAbstractMetamodelDeclaration )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6584:1: ( ruleAbstractMetamodelDeclaration )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6585:1: ruleAbstractMetamodelDeclaration
            {
             before(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractMetamodelDeclaration_in_rule__Grammar__MetamodelDeclarationsAssignment_413222);
            ruleAbstractMetamodelDeclaration();

            state._fsp--;

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
    // $ANTLR end "rule__Grammar__MetamodelDeclarationsAssignment_4"


    // $ANTLR start "rule__Grammar__RulesAssignment_5"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6594:1: rule__Grammar__RulesAssignment_5 : ( ruleAbstractRule ) ;
    public final void rule__Grammar__RulesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6598:1: ( ( ruleAbstractRule ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6599:1: ( ruleAbstractRule )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6599:1: ( ruleAbstractRule )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6600:1: ruleAbstractRule
            {
             before(grammarAccess.getGrammarAccess().getRulesAbstractRuleParserRuleCall_5_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractRule_in_rule__Grammar__RulesAssignment_513253);
            ruleAbstractRule();

            state._fsp--;

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
    // $ANTLR end "rule__Grammar__RulesAssignment_5"


    // $ANTLR start "rule__GeneratedMetamodel__NameAssignment_1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6609:1: rule__GeneratedMetamodel__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__GeneratedMetamodel__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6613:1: ( ( RULE_ID ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6614:1: ( RULE_ID )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6614:1: ( RULE_ID )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6615:1: RULE_ID
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__GeneratedMetamodel__NameAssignment_113284); 
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
    // $ANTLR end "rule__GeneratedMetamodel__NameAssignment_1"


    // $ANTLR start "rule__GeneratedMetamodel__EPackageAssignment_2"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6624:1: rule__GeneratedMetamodel__EPackageAssignment_2 : ( ( RULE_STRING ) ) ;
    public final void rule__GeneratedMetamodel__EPackageAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6628:1: ( ( ( RULE_STRING ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6629:1: ( ( RULE_STRING ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6629:1: ( ( RULE_STRING ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6630:1: ( RULE_STRING )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageCrossReference_2_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6631:1: ( RULE_STRING )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6632:1: RULE_STRING
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_2_0_1()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__GeneratedMetamodel__EPackageAssignment_213319); 
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
    // $ANTLR end "rule__GeneratedMetamodel__EPackageAssignment_2"


    // $ANTLR start "rule__GeneratedMetamodel__AliasAssignment_3_1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6643:1: rule__GeneratedMetamodel__AliasAssignment_3_1 : ( RULE_ID ) ;
    public final void rule__GeneratedMetamodel__AliasAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6647:1: ( ( RULE_ID ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6648:1: ( RULE_ID )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6648:1: ( RULE_ID )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6649:1: RULE_ID
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getAliasIDTerminalRuleCall_3_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__GeneratedMetamodel__AliasAssignment_3_113354); 
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
    // $ANTLR end "rule__GeneratedMetamodel__AliasAssignment_3_1"


    // $ANTLR start "rule__ReferencedMetamodel__EPackageAssignment_1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6658:1: rule__ReferencedMetamodel__EPackageAssignment_1 : ( ( RULE_STRING ) ) ;
    public final void rule__ReferencedMetamodel__EPackageAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6662:1: ( ( ( RULE_STRING ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6663:1: ( ( RULE_STRING ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6663:1: ( ( RULE_STRING ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6664:1: ( RULE_STRING )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageCrossReference_1_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6665:1: ( RULE_STRING )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6666:1: RULE_STRING
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_1_0_1()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__ReferencedMetamodel__EPackageAssignment_113389); 
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
    // $ANTLR end "rule__ReferencedMetamodel__EPackageAssignment_1"


    // $ANTLR start "rule__ReferencedMetamodel__AliasAssignment_2_1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6677:1: rule__ReferencedMetamodel__AliasAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__ReferencedMetamodel__AliasAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6681:1: ( ( RULE_ID ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6682:1: ( RULE_ID )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6682:1: ( RULE_ID )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6683:1: RULE_ID
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAliasIDTerminalRuleCall_2_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ReferencedMetamodel__AliasAssignment_2_113424); 
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
    // $ANTLR end "rule__ReferencedMetamodel__AliasAssignment_2_1"


    // $ANTLR start "rule__ParserRule__NameAssignment_0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6692:1: rule__ParserRule__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__ParserRule__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6696:1: ( ( RULE_ID ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6697:1: ( RULE_ID )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6697:1: ( RULE_ID )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6698:1: RULE_ID
            {
             before(grammarAccess.getParserRuleAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ParserRule__NameAssignment_013455); 
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
    // $ANTLR end "rule__ParserRule__NameAssignment_0"


    // $ANTLR start "rule__ParserRule__TypeAssignment_1_1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6707:1: rule__ParserRule__TypeAssignment_1_1 : ( ruleTypeRef ) ;
    public final void rule__ParserRule__TypeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6711:1: ( ( ruleTypeRef ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6712:1: ( ruleTypeRef )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6712:1: ( ruleTypeRef )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6713:1: ruleTypeRef
            {
             before(grammarAccess.getParserRuleAccess().getTypeTypeRefParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_rule__ParserRule__TypeAssignment_1_113486);
            ruleTypeRef();

            state._fsp--;

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
    // $ANTLR end "rule__ParserRule__TypeAssignment_1_1"


    // $ANTLR start "rule__ParserRule__DefinesHiddenTokensAssignment_2_0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6722:1: rule__ParserRule__DefinesHiddenTokensAssignment_2_0 : ( ( 'hidden' ) ) ;
    public final void rule__ParserRule__DefinesHiddenTokensAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6726:1: ( ( ( 'hidden' ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6727:1: ( ( 'hidden' ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6727:1: ( ( 'hidden' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6728:1: ( 'hidden' )
            {
             before(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_2_0_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6729:1: ( 'hidden' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6730:1: 'hidden'
            {
             before(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_2_0_0()); 
            match(input,42,FollowSets000.FOLLOW_42_in_rule__ParserRule__DefinesHiddenTokensAssignment_2_013522); 
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
    // $ANTLR end "rule__ParserRule__DefinesHiddenTokensAssignment_2_0"


    // $ANTLR start "rule__ParserRule__HiddenTokensAssignment_2_2_0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6745:1: rule__ParserRule__HiddenTokensAssignment_2_2_0 : ( ( RULE_ID ) ) ;
    public final void rule__ParserRule__HiddenTokensAssignment_2_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6749:1: ( ( ( RULE_ID ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6750:1: ( ( RULE_ID ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6750:1: ( ( RULE_ID ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6751:1: ( RULE_ID )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_0_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6752:1: ( RULE_ID )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6753:1: RULE_ID
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_2_2_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ParserRule__HiddenTokensAssignment_2_2_013565); 
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
    // $ANTLR end "rule__ParserRule__HiddenTokensAssignment_2_2_0"


    // $ANTLR start "rule__ParserRule__HiddenTokensAssignment_2_2_1_1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6764:1: rule__ParserRule__HiddenTokensAssignment_2_2_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__ParserRule__HiddenTokensAssignment_2_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6768:1: ( ( ( RULE_ID ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6769:1: ( ( RULE_ID ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6769:1: ( ( RULE_ID ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6770:1: ( RULE_ID )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_1_1_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6771:1: ( RULE_ID )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6772:1: RULE_ID
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_2_2_1_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ParserRule__HiddenTokensAssignment_2_2_1_113604); 
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
    // $ANTLR end "rule__ParserRule__HiddenTokensAssignment_2_2_1_1"


    // $ANTLR start "rule__ParserRule__AlternativesAssignment_4"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6783:1: rule__ParserRule__AlternativesAssignment_4 : ( ruleAlternatives ) ;
    public final void rule__ParserRule__AlternativesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6787:1: ( ( ruleAlternatives ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6788:1: ( ruleAlternatives )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6788:1: ( ruleAlternatives )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6789:1: ruleAlternatives
            {
             before(grammarAccess.getParserRuleAccess().getAlternativesAlternativesParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAlternatives_in_rule__ParserRule__AlternativesAssignment_413639);
            ruleAlternatives();

            state._fsp--;

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
    // $ANTLR end "rule__ParserRule__AlternativesAssignment_4"


    // $ANTLR start "rule__TypeRef__MetamodelAssignment_0_0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6798:1: rule__TypeRef__MetamodelAssignment_0_0 : ( ( RULE_ID ) ) ;
    public final void rule__TypeRef__MetamodelAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6802:1: ( ( ( RULE_ID ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6803:1: ( ( RULE_ID ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6803:1: ( ( RULE_ID ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6804:1: ( RULE_ID )
            {
             before(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationCrossReference_0_0_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6805:1: ( RULE_ID )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6806:1: RULE_ID
            {
             before(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationIDTerminalRuleCall_0_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__TypeRef__MetamodelAssignment_0_013674); 
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
    // $ANTLR end "rule__TypeRef__MetamodelAssignment_0_0"


    // $ANTLR start "rule__TypeRef__ClassifierAssignment_1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6817:1: rule__TypeRef__ClassifierAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__TypeRef__ClassifierAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6821:1: ( ( ( RULE_ID ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6822:1: ( ( RULE_ID ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6822:1: ( ( RULE_ID ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6823:1: ( RULE_ID )
            {
             before(grammarAccess.getTypeRefAccess().getClassifierEClassifierCrossReference_1_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6824:1: ( RULE_ID )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6825:1: RULE_ID
            {
             before(grammarAccess.getTypeRefAccess().getClassifierEClassifierIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__TypeRef__ClassifierAssignment_113713); 
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
    // $ANTLR end "rule__TypeRef__ClassifierAssignment_1"


    // $ANTLR start "rule__Alternatives__ElementsAssignment_1_1_1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6836:1: rule__Alternatives__ElementsAssignment_1_1_1 : ( ruleUnorderedGroup ) ;
    public final void rule__Alternatives__ElementsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6840:1: ( ( ruleUnorderedGroup ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6841:1: ( ruleUnorderedGroup )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6841:1: ( ruleUnorderedGroup )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6842:1: ruleUnorderedGroup
            {
             before(grammarAccess.getAlternativesAccess().getElementsUnorderedGroupParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnorderedGroup_in_rule__Alternatives__ElementsAssignment_1_1_113748);
            ruleUnorderedGroup();

            state._fsp--;

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
    // $ANTLR end "rule__Alternatives__ElementsAssignment_1_1_1"


    // $ANTLR start "rule__UnorderedGroup__ElementsAssignment_1_1_1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6851:1: rule__UnorderedGroup__ElementsAssignment_1_1_1 : ( ruleGroup ) ;
    public final void rule__UnorderedGroup__ElementsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6855:1: ( ( ruleGroup ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6856:1: ( ruleGroup )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6856:1: ( ruleGroup )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6857:1: ruleGroup
            {
             before(grammarAccess.getUnorderedGroupAccess().getElementsGroupParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleGroup_in_rule__UnorderedGroup__ElementsAssignment_1_1_113779);
            ruleGroup();

            state._fsp--;

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
    // $ANTLR end "rule__UnorderedGroup__ElementsAssignment_1_1_1"


    // $ANTLR start "rule__Group__ElementsAssignment_1_1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6866:1: rule__Group__ElementsAssignment_1_1 : ( ruleAbstractToken ) ;
    public final void rule__Group__ElementsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6870:1: ( ( ruleAbstractToken ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6871:1: ( ruleAbstractToken )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6871:1: ( ruleAbstractToken )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6872:1: ruleAbstractToken
            {
             before(grammarAccess.getGroupAccess().getElementsAbstractTokenParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractToken_in_rule__Group__ElementsAssignment_1_113810);
            ruleAbstractToken();

            state._fsp--;

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
    // $ANTLR end "rule__Group__ElementsAssignment_1_1"


    // $ANTLR start "rule__AbstractTokenWithCardinality__CardinalityAssignment_1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6881:1: rule__AbstractTokenWithCardinality__CardinalityAssignment_1 : ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) ) ;
    public final void rule__AbstractTokenWithCardinality__CardinalityAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6885:1: ( ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6886:1: ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6886:1: ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6887:1: ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 )
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAlternatives_1_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6888:1: ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6888:2: rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0_in_rule__AbstractTokenWithCardinality__CardinalityAssignment_113841);
            rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0();

            state._fsp--;


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
    // $ANTLR end "rule__AbstractTokenWithCardinality__CardinalityAssignment_1"


    // $ANTLR start "rule__Action__TypeAssignment_1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6897:1: rule__Action__TypeAssignment_1 : ( ruleTypeRef ) ;
    public final void rule__Action__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6901:1: ( ( ruleTypeRef ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6902:1: ( ruleTypeRef )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6902:1: ( ruleTypeRef )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6903:1: ruleTypeRef
            {
             before(grammarAccess.getActionAccess().getTypeTypeRefParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_rule__Action__TypeAssignment_113874);
            ruleTypeRef();

            state._fsp--;

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
    // $ANTLR end "rule__Action__TypeAssignment_1"


    // $ANTLR start "rule__Action__FeatureAssignment_2_1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6912:1: rule__Action__FeatureAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__Action__FeatureAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6916:1: ( ( RULE_ID ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6917:1: ( RULE_ID )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6917:1: ( RULE_ID )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6918:1: RULE_ID
            {
             before(grammarAccess.getActionAccess().getFeatureIDTerminalRuleCall_2_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Action__FeatureAssignment_2_113905); 
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
    // $ANTLR end "rule__Action__FeatureAssignment_2_1"


    // $ANTLR start "rule__Action__OperatorAssignment_2_2"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6927:1: rule__Action__OperatorAssignment_2_2 : ( ( rule__Action__OperatorAlternatives_2_2_0 ) ) ;
    public final void rule__Action__OperatorAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6931:1: ( ( ( rule__Action__OperatorAlternatives_2_2_0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6932:1: ( ( rule__Action__OperatorAlternatives_2_2_0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6932:1: ( ( rule__Action__OperatorAlternatives_2_2_0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6933:1: ( rule__Action__OperatorAlternatives_2_2_0 )
            {
             before(grammarAccess.getActionAccess().getOperatorAlternatives_2_2_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6934:1: ( rule__Action__OperatorAlternatives_2_2_0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6934:2: rule__Action__OperatorAlternatives_2_2_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__OperatorAlternatives_2_2_0_in_rule__Action__OperatorAssignment_2_213936);
            rule__Action__OperatorAlternatives_2_2_0();

            state._fsp--;


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
    // $ANTLR end "rule__Action__OperatorAssignment_2_2"


    // $ANTLR start "rule__Keyword__ValueAssignment"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6943:1: rule__Keyword__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__Keyword__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6947:1: ( ( RULE_STRING ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6948:1: ( RULE_STRING )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6948:1: ( RULE_STRING )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6949:1: RULE_STRING
            {
             before(grammarAccess.getKeywordAccess().getValueSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Keyword__ValueAssignment13969); 
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
    // $ANTLR end "rule__Keyword__ValueAssignment"


    // $ANTLR start "rule__RuleCall__RuleAssignment"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6958:1: rule__RuleCall__RuleAssignment : ( ( RULE_ID ) ) ;
    public final void rule__RuleCall__RuleAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6962:1: ( ( ( RULE_ID ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6963:1: ( ( RULE_ID ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6963:1: ( ( RULE_ID ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6964:1: ( RULE_ID )
            {
             before(grammarAccess.getRuleCallAccess().getRuleAbstractRuleCrossReference_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6965:1: ( RULE_ID )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6966:1: RULE_ID
            {
             before(grammarAccess.getRuleCallAccess().getRuleAbstractRuleIDTerminalRuleCall_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__RuleCall__RuleAssignment14004); 
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
    // $ANTLR end "rule__RuleCall__RuleAssignment"


    // $ANTLR start "rule__Assignment__FeatureAssignment_0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6977:1: rule__Assignment__FeatureAssignment_0 : ( RULE_ID ) ;
    public final void rule__Assignment__FeatureAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6981:1: ( ( RULE_ID ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6982:1: ( RULE_ID )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6982:1: ( RULE_ID )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6983:1: RULE_ID
            {
             before(grammarAccess.getAssignmentAccess().getFeatureIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Assignment__FeatureAssignment_014039); 
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
    // $ANTLR end "rule__Assignment__FeatureAssignment_0"


    // $ANTLR start "rule__Assignment__OperatorAssignment_1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6992:1: rule__Assignment__OperatorAssignment_1 : ( ( rule__Assignment__OperatorAlternatives_1_0 ) ) ;
    public final void rule__Assignment__OperatorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6996:1: ( ( ( rule__Assignment__OperatorAlternatives_1_0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6997:1: ( ( rule__Assignment__OperatorAlternatives_1_0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6997:1: ( ( rule__Assignment__OperatorAlternatives_1_0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6998:1: ( rule__Assignment__OperatorAlternatives_1_0 )
            {
             before(grammarAccess.getAssignmentAccess().getOperatorAlternatives_1_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6999:1: ( rule__Assignment__OperatorAlternatives_1_0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6999:2: rule__Assignment__OperatorAlternatives_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Assignment__OperatorAlternatives_1_0_in_rule__Assignment__OperatorAssignment_114070);
            rule__Assignment__OperatorAlternatives_1_0();

            state._fsp--;


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
    // $ANTLR end "rule__Assignment__OperatorAssignment_1"


    // $ANTLR start "rule__Assignment__TerminalAssignment_2"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7008:1: rule__Assignment__TerminalAssignment_2 : ( ruleAssignableTerminal ) ;
    public final void rule__Assignment__TerminalAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7012:1: ( ( ruleAssignableTerminal ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7013:1: ( ruleAssignableTerminal )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7013:1: ( ruleAssignableTerminal )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7014:1: ruleAssignableTerminal
            {
             before(grammarAccess.getAssignmentAccess().getTerminalAssignableTerminalParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_rule__Assignment__TerminalAssignment_214103);
            ruleAssignableTerminal();

            state._fsp--;

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
    // $ANTLR end "rule__Assignment__TerminalAssignment_2"


    // $ANTLR start "rule__AssignableAlternatives__ElementsAssignment_1_1_1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7023:1: rule__AssignableAlternatives__ElementsAssignment_1_1_1 : ( ruleAssignableTerminal ) ;
    public final void rule__AssignableAlternatives__ElementsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7027:1: ( ( ruleAssignableTerminal ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7028:1: ( ruleAssignableTerminal )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7028:1: ( ruleAssignableTerminal )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7029:1: ruleAssignableTerminal
            {
             before(grammarAccess.getAssignableAlternativesAccess().getElementsAssignableTerminalParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_rule__AssignableAlternatives__ElementsAssignment_1_1_114134);
            ruleAssignableTerminal();

            state._fsp--;

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
    // $ANTLR end "rule__AssignableAlternatives__ElementsAssignment_1_1_1"


    // $ANTLR start "rule__CrossReference__TypeAssignment_1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7038:1: rule__CrossReference__TypeAssignment_1 : ( ruleTypeRef ) ;
    public final void rule__CrossReference__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7042:1: ( ( ruleTypeRef ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7043:1: ( ruleTypeRef )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7043:1: ( ruleTypeRef )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7044:1: ruleTypeRef
            {
             before(grammarAccess.getCrossReferenceAccess().getTypeTypeRefParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_rule__CrossReference__TypeAssignment_114165);
            ruleTypeRef();

            state._fsp--;

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
    // $ANTLR end "rule__CrossReference__TypeAssignment_1"


    // $ANTLR start "rule__CrossReference__TerminalAssignment_2_1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7053:1: rule__CrossReference__TerminalAssignment_2_1 : ( ruleCrossReferenceableTerminal ) ;
    public final void rule__CrossReference__TerminalAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7057:1: ( ( ruleCrossReferenceableTerminal ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7058:1: ( ruleCrossReferenceableTerminal )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7058:1: ( ruleCrossReferenceableTerminal )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7059:1: ruleCrossReferenceableTerminal
            {
             before(grammarAccess.getCrossReferenceAccess().getTerminalCrossReferenceableTerminalParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleCrossReferenceableTerminal_in_rule__CrossReference__TerminalAssignment_2_114196);
            ruleCrossReferenceableTerminal();

            state._fsp--;

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
    // $ANTLR end "rule__CrossReference__TerminalAssignment_2_1"


    // $ANTLR start "rule__TerminalRule__FragmentAssignment_1_0_0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7068:1: rule__TerminalRule__FragmentAssignment_1_0_0 : ( ( 'fragment' ) ) ;
    public final void rule__TerminalRule__FragmentAssignment_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7072:1: ( ( ( 'fragment' ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7073:1: ( ( 'fragment' ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7073:1: ( ( 'fragment' ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7074:1: ( 'fragment' )
            {
             before(grammarAccess.getTerminalRuleAccess().getFragmentFragmentKeyword_1_0_0_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7075:1: ( 'fragment' )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7076:1: 'fragment'
            {
             before(grammarAccess.getTerminalRuleAccess().getFragmentFragmentKeyword_1_0_0_0()); 
            match(input,43,FollowSets000.FOLLOW_43_in_rule__TerminalRule__FragmentAssignment_1_0_014232); 
             after(grammarAccess.getTerminalRuleAccess().getFragmentFragmentKeyword_1_0_0_0()); 

            }

             after(grammarAccess.getTerminalRuleAccess().getFragmentFragmentKeyword_1_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__FragmentAssignment_1_0_0"


    // $ANTLR start "rule__TerminalRule__NameAssignment_1_0_1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7091:1: rule__TerminalRule__NameAssignment_1_0_1 : ( RULE_ID ) ;
    public final void rule__TerminalRule__NameAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7095:1: ( ( RULE_ID ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7096:1: ( RULE_ID )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7096:1: ( RULE_ID )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7097:1: RULE_ID
            {
             before(grammarAccess.getTerminalRuleAccess().getNameIDTerminalRuleCall_1_0_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__TerminalRule__NameAssignment_1_0_114271); 
             after(grammarAccess.getTerminalRuleAccess().getNameIDTerminalRuleCall_1_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__NameAssignment_1_0_1"


    // $ANTLR start "rule__TerminalRule__NameAssignment_1_1_0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7106:1: rule__TerminalRule__NameAssignment_1_1_0 : ( RULE_ID ) ;
    public final void rule__TerminalRule__NameAssignment_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7110:1: ( ( RULE_ID ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7111:1: ( RULE_ID )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7111:1: ( RULE_ID )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7112:1: RULE_ID
            {
             before(grammarAccess.getTerminalRuleAccess().getNameIDTerminalRuleCall_1_1_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__TerminalRule__NameAssignment_1_1_014302); 
             after(grammarAccess.getTerminalRuleAccess().getNameIDTerminalRuleCall_1_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__NameAssignment_1_1_0"


    // $ANTLR start "rule__TerminalRule__TypeAssignment_1_1_1_1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7121:1: rule__TerminalRule__TypeAssignment_1_1_1_1 : ( ruleTypeRef ) ;
    public final void rule__TerminalRule__TypeAssignment_1_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7125:1: ( ( ruleTypeRef ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7126:1: ( ruleTypeRef )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7126:1: ( ruleTypeRef )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7127:1: ruleTypeRef
            {
             before(grammarAccess.getTerminalRuleAccess().getTypeTypeRefParserRuleCall_1_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_rule__TerminalRule__TypeAssignment_1_1_1_114333);
            ruleTypeRef();

            state._fsp--;

             after(grammarAccess.getTerminalRuleAccess().getTypeTypeRefParserRuleCall_1_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__TypeAssignment_1_1_1_1"


    // $ANTLR start "rule__TerminalRule__AlternativesAssignment_3"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7136:1: rule__TerminalRule__AlternativesAssignment_3 : ( ruleTerminalAlternatives ) ;
    public final void rule__TerminalRule__AlternativesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7140:1: ( ( ruleTerminalAlternatives ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7141:1: ( ruleTerminalAlternatives )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7141:1: ( ruleTerminalAlternatives )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7142:1: ruleTerminalAlternatives
            {
             before(grammarAccess.getTerminalRuleAccess().getAlternativesTerminalAlternativesParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalAlternatives_in_rule__TerminalRule__AlternativesAssignment_314364);
            ruleTerminalAlternatives();

            state._fsp--;

             after(grammarAccess.getTerminalRuleAccess().getAlternativesTerminalAlternativesParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__AlternativesAssignment_3"


    // $ANTLR start "rule__TerminalAlternatives__ElementsAssignment_1_1_1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7151:1: rule__TerminalAlternatives__ElementsAssignment_1_1_1 : ( ruleTerminalGroup ) ;
    public final void rule__TerminalAlternatives__ElementsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7155:1: ( ( ruleTerminalGroup ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7156:1: ( ruleTerminalGroup )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7156:1: ( ruleTerminalGroup )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7157:1: ruleTerminalGroup
            {
             before(grammarAccess.getTerminalAlternativesAccess().getElementsTerminalGroupParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalGroup_in_rule__TerminalAlternatives__ElementsAssignment_1_1_114395);
            ruleTerminalGroup();

            state._fsp--;

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
    // $ANTLR end "rule__TerminalAlternatives__ElementsAssignment_1_1_1"


    // $ANTLR start "rule__TerminalGroup__ElementsAssignment_1_1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7166:1: rule__TerminalGroup__ElementsAssignment_1_1 : ( ruleTerminalToken ) ;
    public final void rule__TerminalGroup__ElementsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7170:1: ( ( ruleTerminalToken ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7171:1: ( ruleTerminalToken )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7171:1: ( ruleTerminalToken )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7172:1: ruleTerminalToken
            {
             before(grammarAccess.getTerminalGroupAccess().getElementsTerminalTokenParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalToken_in_rule__TerminalGroup__ElementsAssignment_1_114426);
            ruleTerminalToken();

            state._fsp--;

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
    // $ANTLR end "rule__TerminalGroup__ElementsAssignment_1_1"


    // $ANTLR start "rule__TerminalToken__CardinalityAssignment_1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7181:1: rule__TerminalToken__CardinalityAssignment_1 : ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) ) ;
    public final void rule__TerminalToken__CardinalityAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7185:1: ( ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7186:1: ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7186:1: ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7187:1: ( rule__TerminalToken__CardinalityAlternatives_1_0 )
            {
             before(grammarAccess.getTerminalTokenAccess().getCardinalityAlternatives_1_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7188:1: ( rule__TerminalToken__CardinalityAlternatives_1_0 )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7188:2: rule__TerminalToken__CardinalityAlternatives_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalToken__CardinalityAlternatives_1_0_in_rule__TerminalToken__CardinalityAssignment_114457);
            rule__TerminalToken__CardinalityAlternatives_1_0();

            state._fsp--;


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
    // $ANTLR end "rule__TerminalToken__CardinalityAssignment_1"


    // $ANTLR start "rule__NegatedToken__TerminalAssignment_1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7197:1: rule__NegatedToken__TerminalAssignment_1 : ( ruleTerminalTokenElement ) ;
    public final void rule__NegatedToken__TerminalAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7201:1: ( ( ruleTerminalTokenElement ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7202:1: ( ruleTerminalTokenElement )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7202:1: ( ruleTerminalTokenElement )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7203:1: ruleTerminalTokenElement
            {
             before(grammarAccess.getNegatedTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_rule__NegatedToken__TerminalAssignment_114490);
            ruleTerminalTokenElement();

            state._fsp--;

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
    // $ANTLR end "rule__NegatedToken__TerminalAssignment_1"


    // $ANTLR start "rule__UntilToken__TerminalAssignment_1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7212:1: rule__UntilToken__TerminalAssignment_1 : ( ruleTerminalTokenElement ) ;
    public final void rule__UntilToken__TerminalAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7216:1: ( ( ruleTerminalTokenElement ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7217:1: ( ruleTerminalTokenElement )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7217:1: ( ruleTerminalTokenElement )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7218:1: ruleTerminalTokenElement
            {
             before(grammarAccess.getUntilTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_rule__UntilToken__TerminalAssignment_114521);
            ruleTerminalTokenElement();

            state._fsp--;

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
    // $ANTLR end "rule__UntilToken__TerminalAssignment_1"


    // $ANTLR start "rule__CharacterRange__RightAssignment_1_2"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7227:1: rule__CharacterRange__RightAssignment_1_2 : ( ruleKeyword ) ;
    public final void rule__CharacterRange__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7231:1: ( ( ruleKeyword ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7232:1: ( ruleKeyword )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7232:1: ( ruleKeyword )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7233:1: ruleKeyword
            {
             before(grammarAccess.getCharacterRangeAccess().getRightKeywordParserRuleCall_1_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_rule__CharacterRange__RightAssignment_1_214552);
            ruleKeyword();

            state._fsp--;

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
    // $ANTLR end "rule__CharacterRange__RightAssignment_1_2"


    // $ANTLR start "rule__EnumRule__NameAssignment_1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7242:1: rule__EnumRule__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__EnumRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7246:1: ( ( RULE_ID ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7247:1: ( RULE_ID )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7247:1: ( RULE_ID )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7248:1: RULE_ID
            {
             before(grammarAccess.getEnumRuleAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EnumRule__NameAssignment_114583); 
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
    // $ANTLR end "rule__EnumRule__NameAssignment_1"


    // $ANTLR start "rule__EnumRule__TypeAssignment_2_1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7257:1: rule__EnumRule__TypeAssignment_2_1 : ( ruleTypeRef ) ;
    public final void rule__EnumRule__TypeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7261:1: ( ( ruleTypeRef ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7262:1: ( ruleTypeRef )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7262:1: ( ruleTypeRef )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7263:1: ruleTypeRef
            {
             before(grammarAccess.getEnumRuleAccess().getTypeTypeRefParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_rule__EnumRule__TypeAssignment_2_114614);
            ruleTypeRef();

            state._fsp--;

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
    // $ANTLR end "rule__EnumRule__TypeAssignment_2_1"


    // $ANTLR start "rule__EnumRule__AlternativesAssignment_4"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7272:1: rule__EnumRule__AlternativesAssignment_4 : ( ruleEnumLiterals ) ;
    public final void rule__EnumRule__AlternativesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7276:1: ( ( ruleEnumLiterals ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7277:1: ( ruleEnumLiterals )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7277:1: ( ruleEnumLiterals )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7278:1: ruleEnumLiterals
            {
             before(grammarAccess.getEnumRuleAccess().getAlternativesEnumLiteralsParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiterals_in_rule__EnumRule__AlternativesAssignment_414645);
            ruleEnumLiterals();

            state._fsp--;

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
    // $ANTLR end "rule__EnumRule__AlternativesAssignment_4"


    // $ANTLR start "rule__EnumLiterals__ElementsAssignment_1_1_1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7287:1: rule__EnumLiterals__ElementsAssignment_1_1_1 : ( ruleEnumLiteralDeclaration ) ;
    public final void rule__EnumLiterals__ElementsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7291:1: ( ( ruleEnumLiteralDeclaration ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7292:1: ( ruleEnumLiteralDeclaration )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7292:1: ( ruleEnumLiteralDeclaration )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7293:1: ruleEnumLiteralDeclaration
            {
             before(grammarAccess.getEnumLiteralsAccess().getElementsEnumLiteralDeclarationParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiteralDeclaration_in_rule__EnumLiterals__ElementsAssignment_1_1_114676);
            ruleEnumLiteralDeclaration();

            state._fsp--;

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
    // $ANTLR end "rule__EnumLiterals__ElementsAssignment_1_1_1"


    // $ANTLR start "rule__EnumLiteralDeclaration__EnumLiteralAssignment_0"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7302:1: rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__EnumLiteralDeclaration__EnumLiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7306:1: ( ( ( RULE_ID ) ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7307:1: ( ( RULE_ID ) )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7307:1: ( ( RULE_ID ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7308:1: ( RULE_ID )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralCrossReference_0_0()); 
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7309:1: ( RULE_ID )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7310:1: RULE_ID
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EnumLiteralDeclaration__EnumLiteralAssignment_014711); 
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
    // $ANTLR end "rule__EnumLiteralDeclaration__EnumLiteralAssignment_0"


    // $ANTLR start "rule__EnumLiteralDeclaration__LiteralAssignment_1_1"
    // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7321:1: rule__EnumLiteralDeclaration__LiteralAssignment_1_1 : ( ruleKeyword ) ;
    public final void rule__EnumLiteralDeclaration__LiteralAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7325:1: ( ( ruleKeyword ) )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7326:1: ( ruleKeyword )
            {
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7326:1: ( ruleKeyword )
            // ../../plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7327:1: ruleKeyword
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralKeywordParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_rule__EnumLiteralDeclaration__LiteralAssignment_1_114746);
            ruleKeyword();

            state._fsp--;

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
    // $ANTLR end "rule__EnumLiteralDeclaration__LiteralAssignment_1_1"

    // Delegated rules


 

    
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
        public static final BitSet FOLLOW_rule__TerminalRule__Group_1_0__0_in_rule__TerminalRule__Alternatives_12966 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group_1_1__0_in_rule__TerminalRule__Alternatives_12984 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__TerminalToken__CardinalityAlternatives_1_03018 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__TerminalToken__CardinalityAlternatives_1_03038 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__TerminalToken__CardinalityAlternatives_1_03058 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCharacterRange_in_rule__TerminalTokenElement__Alternatives3092 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_rule__TerminalTokenElement__Alternatives3109 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_rule__TerminalTokenElement__Alternatives3126 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_rule__TerminalTokenElement__Alternatives3143 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcard_in_rule__TerminalTokenElement__Alternatives3160 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNegatedToken_in_rule__AbstractNegatedToken__Alternatives3192 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUntilToken_in_rule__AbstractNegatedToken__Alternatives3209 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group__0__Impl_in_rule__Grammar__Group__03239 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Grammar__Group__1_in_rule__Grammar__Group__03242 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Grammar__Group__0__Impl3270 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group__1__Impl_in_rule__Grammar__Group__13301 = new BitSet(new long[]{0x0000062002840010L});
        public static final BitSet FOLLOW_rule__Grammar__Group__2_in_rule__Grammar__Group__13304 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__NameAssignment_1_in_rule__Grammar__Group__1__Impl3331 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group__2__Impl_in_rule__Grammar__Group__23361 = new BitSet(new long[]{0x0000062002840010L});
        public static final BitSet FOLLOW_rule__Grammar__Group__3_in_rule__Grammar__Group__23364 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2__0_in_rule__Grammar__Group__2__Impl3391 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group__3__Impl_in_rule__Grammar__Group__33422 = new BitSet(new long[]{0x0000062002840010L});
        public static final BitSet FOLLOW_rule__Grammar__Group__4_in_rule__Grammar__Group__33425 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3__0_in_rule__Grammar__Group__3__Impl3452 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group__4__Impl_in_rule__Grammar__Group__43483 = new BitSet(new long[]{0x0000062002840010L});
        public static final BitSet FOLLOW_rule__Grammar__Group__5_in_rule__Grammar__Group__43486 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__MetamodelDeclarationsAssignment_4_in_rule__Grammar__Group__4__Impl3513 = new BitSet(new long[]{0x0000000002800002L});
        public static final BitSet FOLLOW_rule__Grammar__Group__5__Impl_in_rule__Grammar__Group__53544 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__RulesAssignment_5_in_rule__Grammar__Group__5__Impl3573 = new BitSet(new long[]{0x0000062002840012L});
        public static final BitSet FOLLOW_rule__Grammar__RulesAssignment_5_in_rule__Grammar__Group__5__Impl3585 = new BitSet(new long[]{0x0000062002840012L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2__0__Impl_in_rule__Grammar__Group_2__03630 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2__1_in_rule__Grammar__Group_2__03633 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Grammar__Group_2__0__Impl3661 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2__1__Impl_in_rule__Grammar__Group_2__13692 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2__2_in_rule__Grammar__Group_2__13695 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__UsedGrammarsAssignment_2_1_in_rule__Grammar__Group_2__1__Impl3722 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2__2__Impl_in_rule__Grammar__Group_2__23752 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2_2__0_in_rule__Grammar__Group_2__2__Impl3779 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2_2__0__Impl_in_rule__Grammar__Group_2_2__03816 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2_2__1_in_rule__Grammar__Group_2_2__03819 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Grammar__Group_2_2__0__Impl3847 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2_2__1__Impl_in_rule__Grammar__Group_2_2__13878 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__UsedGrammarsAssignment_2_2_1_in_rule__Grammar__Group_2_2__1__Impl3905 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3__0__Impl_in_rule__Grammar__Group_3__03939 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3__1_in_rule__Grammar__Group_3__03942 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__DefinesHiddenTokensAssignment_3_0_in_rule__Grammar__Group_3__0__Impl3969 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3__1__Impl_in_rule__Grammar__Group_3__13999 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3__2_in_rule__Grammar__Group_3__14002 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Grammar__Group_3__1__Impl4030 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3__2__Impl_in_rule__Grammar__Group_3__24061 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3__3_in_rule__Grammar__Group_3__24064 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3_2__0_in_rule__Grammar__Group_3__2__Impl4091 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3__3__Impl_in_rule__Grammar__Group_3__34122 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__Grammar__Group_3__3__Impl4150 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3_2__0__Impl_in_rule__Grammar__Group_3_2__04189 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3_2__1_in_rule__Grammar__Group_3_2__04192 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__HiddenTokensAssignment_3_2_0_in_rule__Grammar__Group_3_2__0__Impl4219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3_2__1__Impl_in_rule__Grammar__Group_3_2__14249 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3_2_1__0_in_rule__Grammar__Group_3_2__1__Impl4276 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3_2_1__0__Impl_in_rule__Grammar__Group_3_2_1__04311 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3_2_1__1_in_rule__Grammar__Group_3_2_1__04314 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Grammar__Group_3_2_1__0__Impl4342 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3_2_1__1__Impl_in_rule__Grammar__Group_3_2_1__14373 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__HiddenTokensAssignment_3_2_1_1_in_rule__Grammar__Group_3_2_1__1__Impl4400 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GrammarID__Group__0__Impl_in_rule__GrammarID__Group__04434 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__GrammarID__Group__1_in_rule__GrammarID__Group__04437 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__GrammarID__Group__0__Impl4464 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GrammarID__Group__1__Impl_in_rule__GrammarID__Group__14493 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GrammarID__Group_1__0_in_rule__GrammarID__Group__1__Impl4520 = new BitSet(new long[]{0x0000000000400002L});
        public static final BitSet FOLLOW_rule__GrammarID__Group_1__0__Impl_in_rule__GrammarID__Group_1__04555 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__GrammarID__Group_1__1_in_rule__GrammarID__Group_1__04558 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__GrammarID__Group_1__0__Impl4586 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GrammarID__Group_1__1__Impl_in_rule__GrammarID__Group_1__14617 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__GrammarID__Group_1__1__Impl4644 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group__0__Impl_in_rule__GeneratedMetamodel__Group__04677 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group__1_in_rule__GeneratedMetamodel__Group__04680 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__GeneratedMetamodel__Group__0__Impl4708 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group__1__Impl_in_rule__GeneratedMetamodel__Group__14739 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group__2_in_rule__GeneratedMetamodel__Group__14742 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__NameAssignment_1_in_rule__GeneratedMetamodel__Group__1__Impl4769 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group__2__Impl_in_rule__GeneratedMetamodel__Group__24799 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group__3_in_rule__GeneratedMetamodel__Group__24802 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__EPackageAssignment_2_in_rule__GeneratedMetamodel__Group__2__Impl4829 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group__3__Impl_in_rule__GeneratedMetamodel__Group__34859 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group_3__0_in_rule__GeneratedMetamodel__Group__3__Impl4886 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group_3__0__Impl_in_rule__GeneratedMetamodel__Group_3__04925 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group_3__1_in_rule__GeneratedMetamodel__Group_3__04928 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__GeneratedMetamodel__Group_3__0__Impl4956 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group_3__1__Impl_in_rule__GeneratedMetamodel__Group_3__14987 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__AliasAssignment_3_1_in_rule__GeneratedMetamodel__Group_3__1__Impl5014 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group__0__Impl_in_rule__ReferencedMetamodel__Group__05048 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group__1_in_rule__ReferencedMetamodel__Group__05051 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__ReferencedMetamodel__Group__0__Impl5079 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group__1__Impl_in_rule__ReferencedMetamodel__Group__15110 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group__2_in_rule__ReferencedMetamodel__Group__15113 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__EPackageAssignment_1_in_rule__ReferencedMetamodel__Group__1__Impl5140 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group__2__Impl_in_rule__ReferencedMetamodel__Group__25170 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group_2__0_in_rule__ReferencedMetamodel__Group__2__Impl5197 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group_2__0__Impl_in_rule__ReferencedMetamodel__Group_2__05234 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group_2__1_in_rule__ReferencedMetamodel__Group_2__05237 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__ReferencedMetamodel__Group_2__0__Impl5265 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group_2__1__Impl_in_rule__ReferencedMetamodel__Group_2__15296 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__AliasAssignment_2_1_in_rule__ReferencedMetamodel__Group_2__1__Impl5323 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__0__Impl_in_rule__ParserRule__Group__05357 = new BitSet(new long[]{0x0000040014000000L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__1_in_rule__ParserRule__Group__05360 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__NameAssignment_0_in_rule__ParserRule__Group__0__Impl5387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__1__Impl_in_rule__ParserRule__Group__15417 = new BitSet(new long[]{0x0000040014000000L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__2_in_rule__ParserRule__Group__15420 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_1__0_in_rule__ParserRule__Group__1__Impl5447 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__2__Impl_in_rule__ParserRule__Group__25478 = new BitSet(new long[]{0x0000040014000000L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__3_in_rule__ParserRule__Group__25481 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2__0_in_rule__ParserRule__Group__2__Impl5508 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__3__Impl_in_rule__ParserRule__Group__35539 = new BitSet(new long[]{0x0000000100100030L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__4_in_rule__ParserRule__Group__35542 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__ParserRule__Group__3__Impl5570 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__4__Impl_in_rule__ParserRule__Group__45601 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__5_in_rule__ParserRule__Group__45604 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__AlternativesAssignment_4_in_rule__ParserRule__Group__4__Impl5631 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__5__Impl_in_rule__ParserRule__Group__55661 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__ParserRule__Group__5__Impl5689 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_1__0__Impl_in_rule__ParserRule__Group_1__05732 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_1__1_in_rule__ParserRule__Group_1__05735 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__ParserRule__Group_1__0__Impl5763 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_1__1__Impl_in_rule__ParserRule__Group_1__15794 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__TypeAssignment_1_1_in_rule__ParserRule__Group_1__1__Impl5821 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2__0__Impl_in_rule__ParserRule__Group_2__05855 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2__1_in_rule__ParserRule__Group_2__05858 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__DefinesHiddenTokensAssignment_2_0_in_rule__ParserRule__Group_2__0__Impl5885 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2__1__Impl_in_rule__ParserRule__Group_2__15915 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2__2_in_rule__ParserRule__Group_2__15918 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__ParserRule__Group_2__1__Impl5946 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2__2__Impl_in_rule__ParserRule__Group_2__25977 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2__3_in_rule__ParserRule__Group_2__25980 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2_2__0_in_rule__ParserRule__Group_2__2__Impl6007 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2__3__Impl_in_rule__ParserRule__Group_2__36038 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__ParserRule__Group_2__3__Impl6066 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2_2__0__Impl_in_rule__ParserRule__Group_2_2__06105 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2_2__1_in_rule__ParserRule__Group_2_2__06108 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__HiddenTokensAssignment_2_2_0_in_rule__ParserRule__Group_2_2__0__Impl6135 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2_2__1__Impl_in_rule__ParserRule__Group_2_2__16165 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2_2_1__0_in_rule__ParserRule__Group_2_2__1__Impl6192 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2_2_1__0__Impl_in_rule__ParserRule__Group_2_2_1__06227 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2_2_1__1_in_rule__ParserRule__Group_2_2_1__06230 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__ParserRule__Group_2_2_1__0__Impl6258 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2_2_1__1__Impl_in_rule__ParserRule__Group_2_2_1__16289 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__HiddenTokensAssignment_2_2_1_1_in_rule__ParserRule__Group_2_2_1__1__Impl6316 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeRef__Group__0__Impl_in_rule__TypeRef__Group__06350 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__TypeRef__Group__1_in_rule__TypeRef__Group__06353 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeRef__Group_0__0_in_rule__TypeRef__Group__0__Impl6380 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeRef__Group__1__Impl_in_rule__TypeRef__Group__16411 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeRef__ClassifierAssignment_1_in_rule__TypeRef__Group__1__Impl6438 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeRef__Group_0__0__Impl_in_rule__TypeRef__Group_0__06472 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_rule__TypeRef__Group_0__1_in_rule__TypeRef__Group_0__06475 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeRef__MetamodelAssignment_0_0_in_rule__TypeRef__Group_0__0__Impl6502 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeRef__Group_0__1__Impl_in_rule__TypeRef__Group_0__16532 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__TypeRef__Group_0__1__Impl6560 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group__0__Impl_in_rule__Alternatives__Group__06595 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__Alternatives__Group__1_in_rule__Alternatives__Group__06598 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnorderedGroup_in_rule__Alternatives__Group__0__Impl6625 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group__1__Impl_in_rule__Alternatives__Group__16654 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group_1__0_in_rule__Alternatives__Group__1__Impl6681 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group_1__0__Impl_in_rule__Alternatives__Group_1__06716 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__Alternatives__Group_1__1_in_rule__Alternatives__Group_1__06719 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group_1__1__Impl_in_rule__Alternatives__Group_1__16777 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group_1_1__0_in_rule__Alternatives__Group_1__1__Impl6806 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group_1_1__0_in_rule__Alternatives__Group_1__1__Impl6818 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group_1_1__0__Impl_in_rule__Alternatives__Group_1_1__06855 = new BitSet(new long[]{0x0000000100100030L});
        public static final BitSet FOLLOW_rule__Alternatives__Group_1_1__1_in_rule__Alternatives__Group_1_1__06858 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__Alternatives__Group_1_1__0__Impl6886 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group_1_1__1__Impl_in_rule__Alternatives__Group_1_1__16917 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternatives__ElementsAssignment_1_1_1_in_rule__Alternatives__Group_1_1__1__Impl6944 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UnorderedGroup__Group__0__Impl_in_rule__UnorderedGroup__Group__06978 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_rule__UnorderedGroup__Group__1_in_rule__UnorderedGroup__Group__06981 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGroup_in_rule__UnorderedGroup__Group__0__Impl7008 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UnorderedGroup__Group__1__Impl_in_rule__UnorderedGroup__Group__17037 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UnorderedGroup__Group_1__0_in_rule__UnorderedGroup__Group__1__Impl7064 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UnorderedGroup__Group_1__0__Impl_in_rule__UnorderedGroup__Group_1__07099 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_rule__UnorderedGroup__Group_1__1_in_rule__UnorderedGroup__Group_1__07102 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UnorderedGroup__Group_1__1__Impl_in_rule__UnorderedGroup__Group_1__17160 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UnorderedGroup__Group_1_1__0_in_rule__UnorderedGroup__Group_1__1__Impl7189 = new BitSet(new long[]{0x0000000080000002L});
        public static final BitSet FOLLOW_rule__UnorderedGroup__Group_1_1__0_in_rule__UnorderedGroup__Group_1__1__Impl7201 = new BitSet(new long[]{0x0000000080000002L});
        public static final BitSet FOLLOW_rule__UnorderedGroup__Group_1_1__0__Impl_in_rule__UnorderedGroup__Group_1_1__07238 = new BitSet(new long[]{0x0000000100100030L});
        public static final BitSet FOLLOW_rule__UnorderedGroup__Group_1_1__1_in_rule__UnorderedGroup__Group_1_1__07241 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__UnorderedGroup__Group_1_1__0__Impl7269 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UnorderedGroup__Group_1_1__1__Impl_in_rule__UnorderedGroup__Group_1_1__17300 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UnorderedGroup__ElementsAssignment_1_1_1_in_rule__UnorderedGroup__Group_1_1__1__Impl7327 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Group__Group__0__Impl_in_rule__Group__Group__07361 = new BitSet(new long[]{0x0000000100100030L});
        public static final BitSet FOLLOW_rule__Group__Group__1_in_rule__Group__Group__07364 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractToken_in_rule__Group__Group__0__Impl7391 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Group__Group__1__Impl_in_rule__Group__Group__17420 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Group__Group_1__0_in_rule__Group__Group__1__Impl7447 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Group__Group_1__0__Impl_in_rule__Group__Group_1__07482 = new BitSet(new long[]{0x0000000100100030L});
        public static final BitSet FOLLOW_rule__Group__Group_1__1_in_rule__Group__Group_1__07485 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Group__Group_1__1__Impl_in_rule__Group__Group_1__17543 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Group__ElementsAssignment_1_1_in_rule__Group__Group_1__1__Impl7572 = new BitSet(new long[]{0x0000000100100032L});
        public static final BitSet FOLLOW_rule__Group__ElementsAssignment_1_1_in_rule__Group__Group_1__1__Impl7584 = new BitSet(new long[]{0x0000000100100032L});
        public static final BitSet FOLLOW_rule__AbstractTokenWithCardinality__Group__0__Impl_in_rule__AbstractTokenWithCardinality__Group__07621 = new BitSet(new long[]{0x0000000000003800L});
        public static final BitSet FOLLOW_rule__AbstractTokenWithCardinality__Group__1_in_rule__AbstractTokenWithCardinality__Group__07624 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractTokenWithCardinality__Alternatives_0_in_rule__AbstractTokenWithCardinality__Group__0__Impl7651 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractTokenWithCardinality__Group__1__Impl_in_rule__AbstractTokenWithCardinality__Group__17681 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractTokenWithCardinality__CardinalityAssignment_1_in_rule__AbstractTokenWithCardinality__Group__1__Impl7708 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__Group__0__Impl_in_rule__Action__Group__07743 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Action__Group__1_in_rule__Action__Group__07746 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__Action__Group__0__Impl7774 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__Group__1__Impl_in_rule__Action__Group__17805 = new BitSet(new long[]{0x0000000200400000L});
        public static final BitSet FOLLOW_rule__Action__Group__2_in_rule__Action__Group__17808 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__TypeAssignment_1_in_rule__Action__Group__1__Impl7835 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__Group__2__Impl_in_rule__Action__Group__27865 = new BitSet(new long[]{0x0000000200400000L});
        public static final BitSet FOLLOW_rule__Action__Group__3_in_rule__Action__Group__27868 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__Group_2__0_in_rule__Action__Group__2__Impl7895 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__Group__3__Impl_in_rule__Action__Group__37926 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__Action__Group__3__Impl7954 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__Group_2__0__Impl_in_rule__Action__Group_2__07993 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Action__Group_2__1_in_rule__Action__Group_2__07996 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__Action__Group_2__0__Impl8024 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__Group_2__1__Impl_in_rule__Action__Group_2__18055 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_rule__Action__Group_2__2_in_rule__Action__Group_2__18058 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__FeatureAssignment_2_1_in_rule__Action__Group_2__1__Impl8085 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__Group_2__2__Impl_in_rule__Action__Group_2__28115 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_rule__Action__Group_2__3_in_rule__Action__Group_2__28118 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__OperatorAssignment_2_2_in_rule__Action__Group_2__2__Impl8145 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__Group_2__3__Impl_in_rule__Action__Group_2__38175 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__Action__Group_2__3__Impl8203 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Assignment__Group__0__Impl_in_rule__Assignment__Group__08242 = new BitSet(new long[]{0x000000000001C000L});
        public static final BitSet FOLLOW_rule__Assignment__Group__1_in_rule__Assignment__Group__08245 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Assignment__FeatureAssignment_0_in_rule__Assignment__Group__0__Impl8272 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Assignment__Group__1__Impl_in_rule__Assignment__Group__18302 = new BitSet(new long[]{0x0000000800100030L});
        public static final BitSet FOLLOW_rule__Assignment__Group__2_in_rule__Assignment__Group__18305 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Assignment__OperatorAssignment_1_in_rule__Assignment__Group__1__Impl8332 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Assignment__Group__2__Impl_in_rule__Assignment__Group__28362 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Assignment__TerminalAssignment_2_in_rule__Assignment__Group__2__Impl8389 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedAssignableElement__Group__0__Impl_in_rule__ParenthesizedAssignableElement__Group__08425 = new BitSet(new long[]{0x0000000800100030L});
        public static final BitSet FOLLOW_rule__ParenthesizedAssignableElement__Group__1_in_rule__ParenthesizedAssignableElement__Group__08428 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__ParenthesizedAssignableElement__Group__0__Impl8456 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedAssignableElement__Group__1__Impl_in_rule__ParenthesizedAssignableElement__Group__18487 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__ParenthesizedAssignableElement__Group__2_in_rule__ParenthesizedAssignableElement__Group__18490 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableAlternatives_in_rule__ParenthesizedAssignableElement__Group__1__Impl8517 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedAssignableElement__Group__2__Impl_in_rule__ParenthesizedAssignableElement__Group__28546 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__ParenthesizedAssignableElement__Group__2__Impl8574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group__0__Impl_in_rule__AssignableAlternatives__Group__08611 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group__1_in_rule__AssignableAlternatives__Group__08614 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_rule__AssignableAlternatives__Group__0__Impl8641 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group__1__Impl_in_rule__AssignableAlternatives__Group__18670 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1__0_in_rule__AssignableAlternatives__Group__1__Impl8697 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1__0__Impl_in_rule__AssignableAlternatives__Group_1__08732 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1__1_in_rule__AssignableAlternatives__Group_1__08735 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1__1__Impl_in_rule__AssignableAlternatives__Group_1__18793 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1_1__0_in_rule__AssignableAlternatives__Group_1__1__Impl8822 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1_1__0_in_rule__AssignableAlternatives__Group_1__1__Impl8834 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1_1__0__Impl_in_rule__AssignableAlternatives__Group_1_1__08871 = new BitSet(new long[]{0x0000000800100030L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1_1__1_in_rule__AssignableAlternatives__Group_1_1__08874 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__AssignableAlternatives__Group_1_1__0__Impl8902 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1_1__1__Impl_in_rule__AssignableAlternatives__Group_1_1__18933 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__ElementsAssignment_1_1_1_in_rule__AssignableAlternatives__Group_1_1__1__Impl8960 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReference__Group__0__Impl_in_rule__CrossReference__Group__08994 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__CrossReference__Group__1_in_rule__CrossReference__Group__08997 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__CrossReference__Group__0__Impl9025 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReference__Group__1__Impl_in_rule__CrossReference__Group__19056 = new BitSet(new long[]{0x0000001040000000L});
        public static final BitSet FOLLOW_rule__CrossReference__Group__2_in_rule__CrossReference__Group__19059 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReference__TypeAssignment_1_in_rule__CrossReference__Group__1__Impl9086 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReference__Group__2__Impl_in_rule__CrossReference__Group__29116 = new BitSet(new long[]{0x0000001040000000L});
        public static final BitSet FOLLOW_rule__CrossReference__Group__3_in_rule__CrossReference__Group__29119 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReference__Group_2__0_in_rule__CrossReference__Group__2__Impl9146 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReference__Group__3__Impl_in_rule__CrossReference__Group__39177 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_rule__CrossReference__Group__3__Impl9205 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReference__Group_2__0__Impl_in_rule__CrossReference__Group_2__09244 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__CrossReference__Group_2__1_in_rule__CrossReference__Group_2__09247 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__CrossReference__Group_2__0__Impl9275 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReference__Group_2__1__Impl_in_rule__CrossReference__Group_2__19306 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReference__TerminalAssignment_2_1_in_rule__CrossReference__Group_2__1__Impl9333 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedElement__Group__0__Impl_in_rule__ParenthesizedElement__Group__09367 = new BitSet(new long[]{0x0000000100100030L});
        public static final BitSet FOLLOW_rule__ParenthesizedElement__Group__1_in_rule__ParenthesizedElement__Group__09370 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__ParenthesizedElement__Group__0__Impl9398 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedElement__Group__1__Impl_in_rule__ParenthesizedElement__Group__19429 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__ParenthesizedElement__Group__2_in_rule__ParenthesizedElement__Group__19432 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAlternatives_in_rule__ParenthesizedElement__Group__1__Impl9459 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedElement__Group__2__Impl_in_rule__ParenthesizedElement__Group__29488 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__ParenthesizedElement__Group__2__Impl9516 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__0__Impl_in_rule__TerminalRule__Group__09553 = new BitSet(new long[]{0x0000080000000010L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__1_in_rule__TerminalRule__Group__09556 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_rule__TerminalRule__Group__0__Impl9584 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__1__Impl_in_rule__TerminalRule__Group__19615 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__2_in_rule__TerminalRule__Group__19618 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__Alternatives_1_in_rule__TerminalRule__Group__1__Impl9645 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__2__Impl_in_rule__TerminalRule__Group__29675 = new BitSet(new long[]{0x000000C000500030L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__3_in_rule__TerminalRule__Group__29678 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__TerminalRule__Group__2__Impl9706 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__3__Impl_in_rule__TerminalRule__Group__39737 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__4_in_rule__TerminalRule__Group__39740 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__AlternativesAssignment_3_in_rule__TerminalRule__Group__3__Impl9767 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__4__Impl_in_rule__TerminalRule__Group__49797 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__TerminalRule__Group__4__Impl9825 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group_1_0__0__Impl_in_rule__TerminalRule__Group_1_0__09866 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group_1_0__1_in_rule__TerminalRule__Group_1_0__09869 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__FragmentAssignment_1_0_0_in_rule__TerminalRule__Group_1_0__0__Impl9896 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group_1_0__1__Impl_in_rule__TerminalRule__Group_1_0__19926 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__NameAssignment_1_0_1_in_rule__TerminalRule__Group_1_0__1__Impl9953 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group_1_1__0__Impl_in_rule__TerminalRule__Group_1_1__09987 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group_1_1__1_in_rule__TerminalRule__Group_1_1__09990 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__NameAssignment_1_1_0_in_rule__TerminalRule__Group_1_1__0__Impl10017 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group_1_1__1__Impl_in_rule__TerminalRule__Group_1_1__110047 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group_1_1_1__0_in_rule__TerminalRule__Group_1_1__1__Impl10074 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group_1_1_1__0__Impl_in_rule__TerminalRule__Group_1_1_1__010109 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group_1_1_1__1_in_rule__TerminalRule__Group_1_1_1__010112 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__TerminalRule__Group_1_1_1__0__Impl10140 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group_1_1_1__1__Impl_in_rule__TerminalRule__Group_1_1_1__110171 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__TypeAssignment_1_1_1_1_in_rule__TerminalRule__Group_1_1_1__1__Impl10198 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group__0__Impl_in_rule__TerminalAlternatives__Group__010232 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group__1_in_rule__TerminalAlternatives__Group__010235 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalGroup_in_rule__TerminalAlternatives__Group__0__Impl10262 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group__1__Impl_in_rule__TerminalAlternatives__Group__110291 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1__0_in_rule__TerminalAlternatives__Group__1__Impl10318 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1__0__Impl_in_rule__TerminalAlternatives__Group_1__010353 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1__1_in_rule__TerminalAlternatives__Group_1__010356 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1__1__Impl_in_rule__TerminalAlternatives__Group_1__110414 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1_1__0_in_rule__TerminalAlternatives__Group_1__1__Impl10443 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1_1__0_in_rule__TerminalAlternatives__Group_1__1__Impl10455 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1_1__0__Impl_in_rule__TerminalAlternatives__Group_1_1__010492 = new BitSet(new long[]{0x000000C000500030L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1_1__1_in_rule__TerminalAlternatives__Group_1_1__010495 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__TerminalAlternatives__Group_1_1__0__Impl10523 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1_1__1__Impl_in_rule__TerminalAlternatives__Group_1_1__110554 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__ElementsAssignment_1_1_1_in_rule__TerminalAlternatives__Group_1_1__1__Impl10581 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalGroup__Group__0__Impl_in_rule__TerminalGroup__Group__010615 = new BitSet(new long[]{0x000000C000500030L});
        public static final BitSet FOLLOW_rule__TerminalGroup__Group__1_in_rule__TerminalGroup__Group__010618 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalToken_in_rule__TerminalGroup__Group__0__Impl10645 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalGroup__Group__1__Impl_in_rule__TerminalGroup__Group__110674 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalGroup__Group_1__0_in_rule__TerminalGroup__Group__1__Impl10701 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalGroup__Group_1__0__Impl_in_rule__TerminalGroup__Group_1__010736 = new BitSet(new long[]{0x000000C000500030L});
        public static final BitSet FOLLOW_rule__TerminalGroup__Group_1__1_in_rule__TerminalGroup__Group_1__010739 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalGroup__Group_1__1__Impl_in_rule__TerminalGroup__Group_1__110797 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalGroup__ElementsAssignment_1_1_in_rule__TerminalGroup__Group_1__1__Impl10826 = new BitSet(new long[]{0x000000C000500032L});
        public static final BitSet FOLLOW_rule__TerminalGroup__ElementsAssignment_1_1_in_rule__TerminalGroup__Group_1__1__Impl10838 = new BitSet(new long[]{0x000000C000500032L});
        public static final BitSet FOLLOW_rule__TerminalToken__Group__0__Impl_in_rule__TerminalToken__Group__010875 = new BitSet(new long[]{0x0000000000003800L});
        public static final BitSet FOLLOW_rule__TerminalToken__Group__1_in_rule__TerminalToken__Group__010878 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_rule__TerminalToken__Group__0__Impl10905 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalToken__Group__1__Impl_in_rule__TerminalToken__Group__110934 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalToken__CardinalityAssignment_1_in_rule__TerminalToken__Group__1__Impl10961 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedTerminalElement__Group__0__Impl_in_rule__ParenthesizedTerminalElement__Group__010996 = new BitSet(new long[]{0x000000C000500030L});
        public static final BitSet FOLLOW_rule__ParenthesizedTerminalElement__Group__1_in_rule__ParenthesizedTerminalElement__Group__010999 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__ParenthesizedTerminalElement__Group__0__Impl11027 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedTerminalElement__Group__1__Impl_in_rule__ParenthesizedTerminalElement__Group__111058 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__ParenthesizedTerminalElement__Group__2_in_rule__ParenthesizedTerminalElement__Group__111061 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalAlternatives_in_rule__ParenthesizedTerminalElement__Group__1__Impl11088 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedTerminalElement__Group__2__Impl_in_rule__ParenthesizedTerminalElement__Group__211117 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__ParenthesizedTerminalElement__Group__2__Impl11145 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NegatedToken__Group__0__Impl_in_rule__NegatedToken__Group__011182 = new BitSet(new long[]{0x000000C000500030L});
        public static final BitSet FOLLOW_rule__NegatedToken__Group__1_in_rule__NegatedToken__Group__011185 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_rule__NegatedToken__Group__0__Impl11213 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NegatedToken__Group__1__Impl_in_rule__NegatedToken__Group__111244 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NegatedToken__TerminalAssignment_1_in_rule__NegatedToken__Group__1__Impl11271 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UntilToken__Group__0__Impl_in_rule__UntilToken__Group__011305 = new BitSet(new long[]{0x000000C000500030L});
        public static final BitSet FOLLOW_rule__UntilToken__Group__1_in_rule__UntilToken__Group__011308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_rule__UntilToken__Group__0__Impl11336 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UntilToken__Group__1__Impl_in_rule__UntilToken__Group__111367 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UntilToken__TerminalAssignment_1_in_rule__UntilToken__Group__1__Impl11394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Wildcard__Group__0__Impl_in_rule__Wildcard__Group__011428 = new BitSet(new long[]{0x000000C000500030L});
        public static final BitSet FOLLOW_rule__Wildcard__Group__1_in_rule__Wildcard__Group__011431 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Wildcard__Group__1__Impl_in_rule__Wildcard__Group__111489 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__Wildcard__Group__1__Impl11517 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group__0__Impl_in_rule__CharacterRange__Group__011552 = new BitSet(new long[]{0x0000010000000000L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group__1_in_rule__CharacterRange__Group__011555 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_rule__CharacterRange__Group__0__Impl11582 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group__1__Impl_in_rule__CharacterRange__Group__111611 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group_1__0_in_rule__CharacterRange__Group__1__Impl11638 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group_1__0__Impl_in_rule__CharacterRange__Group_1__011673 = new BitSet(new long[]{0x0000010000000000L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group_1__1_in_rule__CharacterRange__Group_1__011676 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group_1__1__Impl_in_rule__CharacterRange__Group_1__111734 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group_1__2_in_rule__CharacterRange__Group_1__111737 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_rule__CharacterRange__Group_1__1__Impl11765 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group_1__2__Impl_in_rule__CharacterRange__Group_1__211796 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CharacterRange__RightAssignment_1_2_in_rule__CharacterRange__Group_1__2__Impl11823 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__0__Impl_in_rule__EnumRule__Group__011859 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__1_in_rule__EnumRule__Group__011862 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_rule__EnumRule__Group__0__Impl11890 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__1__Impl_in_rule__EnumRule__Group__111921 = new BitSet(new long[]{0x0000000014000000L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__2_in_rule__EnumRule__Group__111924 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__NameAssignment_1_in_rule__EnumRule__Group__1__Impl11951 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__2__Impl_in_rule__EnumRule__Group__211981 = new BitSet(new long[]{0x0000000014000000L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__3_in_rule__EnumRule__Group__211984 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__Group_2__0_in_rule__EnumRule__Group__2__Impl12011 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__3__Impl_in_rule__EnumRule__Group__312042 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__4_in_rule__EnumRule__Group__312045 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__EnumRule__Group__3__Impl12073 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__4__Impl_in_rule__EnumRule__Group__412104 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__5_in_rule__EnumRule__Group__412107 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__AlternativesAssignment_4_in_rule__EnumRule__Group__4__Impl12134 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__5__Impl_in_rule__EnumRule__Group__512164 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__EnumRule__Group__5__Impl12192 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__Group_2__0__Impl_in_rule__EnumRule__Group_2__012235 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__EnumRule__Group_2__1_in_rule__EnumRule__Group_2__012238 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__EnumRule__Group_2__0__Impl12266 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__Group_2__1__Impl_in_rule__EnumRule__Group_2__112297 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__TypeAssignment_2_1_in_rule__EnumRule__Group_2__1__Impl12324 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group__0__Impl_in_rule__EnumLiterals__Group__012358 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group__1_in_rule__EnumLiterals__Group__012361 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_rule__EnumLiterals__Group__0__Impl12388 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group__1__Impl_in_rule__EnumLiterals__Group__112417 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group_1__0_in_rule__EnumLiterals__Group__1__Impl12444 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group_1__0__Impl_in_rule__EnumLiterals__Group_1__012479 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group_1__1_in_rule__EnumLiterals__Group_1__012482 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group_1__1__Impl_in_rule__EnumLiterals__Group_1__112540 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group_1_1__0_in_rule__EnumLiterals__Group_1__1__Impl12569 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group_1_1__0_in_rule__EnumLiterals__Group_1__1__Impl12581 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group_1_1__0__Impl_in_rule__EnumLiterals__Group_1_1__012618 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group_1_1__1_in_rule__EnumLiterals__Group_1_1__012621 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__EnumLiterals__Group_1_1__0__Impl12649 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group_1_1__1__Impl_in_rule__EnumLiterals__Group_1_1__112680 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__ElementsAssignment_1_1_1_in_rule__EnumLiterals__Group_1_1__1__Impl12707 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__Group__0__Impl_in_rule__EnumLiteralDeclaration__Group__012741 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__Group__1_in_rule__EnumLiteralDeclaration__Group__012744 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__EnumLiteralAssignment_0_in_rule__EnumLiteralDeclaration__Group__0__Impl12771 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__Group__1__Impl_in_rule__EnumLiteralDeclaration__Group__112801 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__Group_1__0_in_rule__EnumLiteralDeclaration__Group__1__Impl12828 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__Group_1__0__Impl_in_rule__EnumLiteralDeclaration__Group_1__012863 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__Group_1__1_in_rule__EnumLiteralDeclaration__Group_1__012866 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__EnumLiteralDeclaration__Group_1__0__Impl12894 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__Group_1__1__Impl_in_rule__EnumLiteralDeclaration__Group_1__112925 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__LiteralAssignment_1_1_in_rule__EnumLiteralDeclaration__Group_1__1__Impl12952 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGrammarID_in_rule__Grammar__NameAssignment_112991 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGrammarID_in_rule__Grammar__UsedGrammarsAssignment_2_113026 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGrammarID_in_rule__Grammar__UsedGrammarsAssignment_2_2_113065 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_rule__Grammar__DefinesHiddenTokensAssignment_3_013105 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Grammar__HiddenTokensAssignment_3_2_013148 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Grammar__HiddenTokensAssignment_3_2_1_113187 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_rule__Grammar__MetamodelDeclarationsAssignment_413222 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractRule_in_rule__Grammar__RulesAssignment_513253 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__GeneratedMetamodel__NameAssignment_113284 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__GeneratedMetamodel__EPackageAssignment_213319 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__GeneratedMetamodel__AliasAssignment_3_113354 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__ReferencedMetamodel__EPackageAssignment_113389 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ReferencedMetamodel__AliasAssignment_2_113424 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ParserRule__NameAssignment_013455 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_rule__ParserRule__TypeAssignment_1_113486 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_rule__ParserRule__DefinesHiddenTokensAssignment_2_013522 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ParserRule__HiddenTokensAssignment_2_2_013565 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ParserRule__HiddenTokensAssignment_2_2_1_113604 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAlternatives_in_rule__ParserRule__AlternativesAssignment_413639 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__TypeRef__MetamodelAssignment_0_013674 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__TypeRef__ClassifierAssignment_113713 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnorderedGroup_in_rule__Alternatives__ElementsAssignment_1_1_113748 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGroup_in_rule__UnorderedGroup__ElementsAssignment_1_1_113779 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractToken_in_rule__Group__ElementsAssignment_1_113810 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0_in_rule__AbstractTokenWithCardinality__CardinalityAssignment_113841 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_rule__Action__TypeAssignment_113874 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Action__FeatureAssignment_2_113905 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__OperatorAlternatives_2_2_0_in_rule__Action__OperatorAssignment_2_213936 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Keyword__ValueAssignment13969 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__RuleCall__RuleAssignment14004 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Assignment__FeatureAssignment_014039 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Assignment__OperatorAlternatives_1_0_in_rule__Assignment__OperatorAssignment_114070 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_rule__Assignment__TerminalAssignment_214103 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_rule__AssignableAlternatives__ElementsAssignment_1_1_114134 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_rule__CrossReference__TypeAssignment_114165 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_rule__CrossReference__TerminalAssignment_2_114196 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_rule__TerminalRule__FragmentAssignment_1_0_014232 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__TerminalRule__NameAssignment_1_0_114271 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__TerminalRule__NameAssignment_1_1_014302 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_rule__TerminalRule__TypeAssignment_1_1_1_114333 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalAlternatives_in_rule__TerminalRule__AlternativesAssignment_314364 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalGroup_in_rule__TerminalAlternatives__ElementsAssignment_1_1_114395 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalToken_in_rule__TerminalGroup__ElementsAssignment_1_114426 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalToken__CardinalityAlternatives_1_0_in_rule__TerminalToken__CardinalityAssignment_114457 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_rule__NegatedToken__TerminalAssignment_114490 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_rule__UntilToken__TerminalAssignment_114521 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_rule__CharacterRange__RightAssignment_1_214552 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EnumRule__NameAssignment_114583 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_rule__EnumRule__TypeAssignment_2_114614 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumLiterals_in_rule__EnumRule__AlternativesAssignment_414645 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_rule__EnumLiterals__ElementsAssignment_1_1_114676 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EnumLiteralDeclaration__EnumLiteralAssignment_014711 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_rule__EnumLiteralDeclaration__LiteralAssignment_1_114746 = new BitSet(new long[]{0x0000000000000002L});
    }


}
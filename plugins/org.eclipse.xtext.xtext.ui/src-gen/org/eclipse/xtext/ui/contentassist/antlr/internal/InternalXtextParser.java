package org.eclipse.xtext.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'?'", "'*'", "'+'", "'='", "'+='", "'false'", "'true'", "'?='", "'grammar'", "'with'", "','", "'('", "')'", "'.'", "'generate'", "'as'", "'import'", "':'", "';'", "'returns'", "'<'", "'>'", "'::'", "'|'", "'&'", "'{'", "'}'", "'current'", "'!'", "'['", "']'", "'terminal'", "'->'", "'EOF'", "'..'", "'enum'", "'hidden'", "'fragment'", "'=>'"
    };
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=5;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalXtextParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalXtextParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalXtextParser.tokenNames; }
    public String getGrammarFileName() { return "InternalXtext.g"; }


     
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
    // InternalXtext.g:60:1: entryRuleGrammar : ruleGrammar EOF ;
    public final void entryRuleGrammar() throws RecognitionException {
        try {
            // InternalXtext.g:61:1: ( ruleGrammar EOF )
            // InternalXtext.g:62:1: ruleGrammar EOF
            {
             before(grammarAccess.getGrammarRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleGrammar();

            state._fsp--;

             after(grammarAccess.getGrammarRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalXtext.g:69:1: ruleGrammar : ( ( rule__Grammar__Group__0 ) ) ;
    public final void ruleGrammar() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:73:2: ( ( ( rule__Grammar__Group__0 ) ) )
            // InternalXtext.g:74:1: ( ( rule__Grammar__Group__0 ) )
            {
            // InternalXtext.g:74:1: ( ( rule__Grammar__Group__0 ) )
            // InternalXtext.g:75:1: ( rule__Grammar__Group__0 )
            {
             before(grammarAccess.getGrammarAccess().getGroup()); 
            // InternalXtext.g:76:1: ( rule__Grammar__Group__0 )
            // InternalXtext.g:76:2: rule__Grammar__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:88:1: entryRuleGrammarID : ruleGrammarID EOF ;
    public final void entryRuleGrammarID() throws RecognitionException {
        try {
            // InternalXtext.g:89:1: ( ruleGrammarID EOF )
            // InternalXtext.g:90:1: ruleGrammarID EOF
            {
             before(grammarAccess.getGrammarIDRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleGrammarID();

            state._fsp--;

             after(grammarAccess.getGrammarIDRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalXtext.g:97:1: ruleGrammarID : ( ( rule__GrammarID__Group__0 ) ) ;
    public final void ruleGrammarID() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:101:2: ( ( ( rule__GrammarID__Group__0 ) ) )
            // InternalXtext.g:102:1: ( ( rule__GrammarID__Group__0 ) )
            {
            // InternalXtext.g:102:1: ( ( rule__GrammarID__Group__0 ) )
            // InternalXtext.g:103:1: ( rule__GrammarID__Group__0 )
            {
             before(grammarAccess.getGrammarIDAccess().getGroup()); 
            // InternalXtext.g:104:1: ( rule__GrammarID__Group__0 )
            // InternalXtext.g:104:2: rule__GrammarID__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:116:1: entryRuleAbstractRule : ruleAbstractRule EOF ;
    public final void entryRuleAbstractRule() throws RecognitionException {
        try {
            // InternalXtext.g:117:1: ( ruleAbstractRule EOF )
            // InternalXtext.g:118:1: ruleAbstractRule EOF
            {
             before(grammarAccess.getAbstractRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAbstractRule();

            state._fsp--;

             after(grammarAccess.getAbstractRuleRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalXtext.g:125:1: ruleAbstractRule : ( ( rule__AbstractRule__Alternatives ) ) ;
    public final void ruleAbstractRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:129:2: ( ( ( rule__AbstractRule__Alternatives ) ) )
            // InternalXtext.g:130:1: ( ( rule__AbstractRule__Alternatives ) )
            {
            // InternalXtext.g:130:1: ( ( rule__AbstractRule__Alternatives ) )
            // InternalXtext.g:131:1: ( rule__AbstractRule__Alternatives )
            {
             before(grammarAccess.getAbstractRuleAccess().getAlternatives()); 
            // InternalXtext.g:132:1: ( rule__AbstractRule__Alternatives )
            // InternalXtext.g:132:2: rule__AbstractRule__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:144:1: entryRuleAbstractMetamodelDeclaration : ruleAbstractMetamodelDeclaration EOF ;
    public final void entryRuleAbstractMetamodelDeclaration() throws RecognitionException {
        try {
            // InternalXtext.g:145:1: ( ruleAbstractMetamodelDeclaration EOF )
            // InternalXtext.g:146:1: ruleAbstractMetamodelDeclaration EOF
            {
             before(grammarAccess.getAbstractMetamodelDeclarationRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAbstractMetamodelDeclaration();

            state._fsp--;

             after(grammarAccess.getAbstractMetamodelDeclarationRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalXtext.g:153:1: ruleAbstractMetamodelDeclaration : ( ( rule__AbstractMetamodelDeclaration__Alternatives ) ) ;
    public final void ruleAbstractMetamodelDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:157:2: ( ( ( rule__AbstractMetamodelDeclaration__Alternatives ) ) )
            // InternalXtext.g:158:1: ( ( rule__AbstractMetamodelDeclaration__Alternatives ) )
            {
            // InternalXtext.g:158:1: ( ( rule__AbstractMetamodelDeclaration__Alternatives ) )
            // InternalXtext.g:159:1: ( rule__AbstractMetamodelDeclaration__Alternatives )
            {
             before(grammarAccess.getAbstractMetamodelDeclarationAccess().getAlternatives()); 
            // InternalXtext.g:160:1: ( rule__AbstractMetamodelDeclaration__Alternatives )
            // InternalXtext.g:160:2: rule__AbstractMetamodelDeclaration__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:172:1: entryRuleGeneratedMetamodel : ruleGeneratedMetamodel EOF ;
    public final void entryRuleGeneratedMetamodel() throws RecognitionException {
        try {
            // InternalXtext.g:173:1: ( ruleGeneratedMetamodel EOF )
            // InternalXtext.g:174:1: ruleGeneratedMetamodel EOF
            {
             before(grammarAccess.getGeneratedMetamodelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleGeneratedMetamodel();

            state._fsp--;

             after(grammarAccess.getGeneratedMetamodelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalXtext.g:181:1: ruleGeneratedMetamodel : ( ( rule__GeneratedMetamodel__Group__0 ) ) ;
    public final void ruleGeneratedMetamodel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:185:2: ( ( ( rule__GeneratedMetamodel__Group__0 ) ) )
            // InternalXtext.g:186:1: ( ( rule__GeneratedMetamodel__Group__0 ) )
            {
            // InternalXtext.g:186:1: ( ( rule__GeneratedMetamodel__Group__0 ) )
            // InternalXtext.g:187:1: ( rule__GeneratedMetamodel__Group__0 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getGroup()); 
            // InternalXtext.g:188:1: ( rule__GeneratedMetamodel__Group__0 )
            // InternalXtext.g:188:2: rule__GeneratedMetamodel__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:200:1: entryRuleReferencedMetamodel : ruleReferencedMetamodel EOF ;
    public final void entryRuleReferencedMetamodel() throws RecognitionException {
        try {
            // InternalXtext.g:201:1: ( ruleReferencedMetamodel EOF )
            // InternalXtext.g:202:1: ruleReferencedMetamodel EOF
            {
             before(grammarAccess.getReferencedMetamodelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleReferencedMetamodel();

            state._fsp--;

             after(grammarAccess.getReferencedMetamodelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalXtext.g:209:1: ruleReferencedMetamodel : ( ( rule__ReferencedMetamodel__Group__0 ) ) ;
    public final void ruleReferencedMetamodel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:213:2: ( ( ( rule__ReferencedMetamodel__Group__0 ) ) )
            // InternalXtext.g:214:1: ( ( rule__ReferencedMetamodel__Group__0 ) )
            {
            // InternalXtext.g:214:1: ( ( rule__ReferencedMetamodel__Group__0 ) )
            // InternalXtext.g:215:1: ( rule__ReferencedMetamodel__Group__0 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getGroup()); 
            // InternalXtext.g:216:1: ( rule__ReferencedMetamodel__Group__0 )
            // InternalXtext.g:216:2: rule__ReferencedMetamodel__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:228:1: entryRuleParserRule : ruleParserRule EOF ;
    public final void entryRuleParserRule() throws RecognitionException {
        try {
            // InternalXtext.g:229:1: ( ruleParserRule EOF )
            // InternalXtext.g:230:1: ruleParserRule EOF
            {
             before(grammarAccess.getParserRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleParserRule();

            state._fsp--;

             after(grammarAccess.getParserRuleRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalXtext.g:237:1: ruleParserRule : ( ( rule__ParserRule__Group__0 ) ) ;
    public final void ruleParserRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:241:2: ( ( ( rule__ParserRule__Group__0 ) ) )
            // InternalXtext.g:242:1: ( ( rule__ParserRule__Group__0 ) )
            {
            // InternalXtext.g:242:1: ( ( rule__ParserRule__Group__0 ) )
            // InternalXtext.g:243:1: ( rule__ParserRule__Group__0 )
            {
             before(grammarAccess.getParserRuleAccess().getGroup()); 
            // InternalXtext.g:244:1: ( rule__ParserRule__Group__0 )
            // InternalXtext.g:244:2: rule__ParserRule__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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


    // $ANTLR start "entryRuleRuleNameAndParams"
    // InternalXtext.g:256:1: entryRuleRuleNameAndParams : ruleRuleNameAndParams EOF ;
    public final void entryRuleRuleNameAndParams() throws RecognitionException {
        try {
            // InternalXtext.g:257:1: ( ruleRuleNameAndParams EOF )
            // InternalXtext.g:258:1: ruleRuleNameAndParams EOF
            {
             before(grammarAccess.getRuleNameAndParamsRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleRuleNameAndParams();

            state._fsp--;

             after(grammarAccess.getRuleNameAndParamsRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRuleNameAndParams"


    // $ANTLR start "ruleRuleNameAndParams"
    // InternalXtext.g:265:1: ruleRuleNameAndParams : ( ( rule__RuleNameAndParams__Group__0 ) ) ;
    public final void ruleRuleNameAndParams() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:269:2: ( ( ( rule__RuleNameAndParams__Group__0 ) ) )
            // InternalXtext.g:270:1: ( ( rule__RuleNameAndParams__Group__0 ) )
            {
            // InternalXtext.g:270:1: ( ( rule__RuleNameAndParams__Group__0 ) )
            // InternalXtext.g:271:1: ( rule__RuleNameAndParams__Group__0 )
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getGroup()); 
            // InternalXtext.g:272:1: ( rule__RuleNameAndParams__Group__0 )
            // InternalXtext.g:272:2: rule__RuleNameAndParams__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRuleNameAndParamsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRuleNameAndParams"


    // $ANTLR start "entryRuleParameter"
    // InternalXtext.g:284:1: entryRuleParameter : ruleParameter EOF ;
    public final void entryRuleParameter() throws RecognitionException {
        try {
            // InternalXtext.g:285:1: ( ruleParameter EOF )
            // InternalXtext.g:286:1: ruleParameter EOF
            {
             before(grammarAccess.getParameterRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getParameterRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalXtext.g:293:1: ruleParameter : ( ( rule__Parameter__NameAssignment ) ) ;
    public final void ruleParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:297:2: ( ( ( rule__Parameter__NameAssignment ) ) )
            // InternalXtext.g:298:1: ( ( rule__Parameter__NameAssignment ) )
            {
            // InternalXtext.g:298:1: ( ( rule__Parameter__NameAssignment ) )
            // InternalXtext.g:299:1: ( rule__Parameter__NameAssignment )
            {
             before(grammarAccess.getParameterAccess().getNameAssignment()); 
            // InternalXtext.g:300:1: ( rule__Parameter__NameAssignment )
            // InternalXtext.g:300:2: rule__Parameter__NameAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Parameter__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleTypeRef"
    // InternalXtext.g:312:1: entryRuleTypeRef : ruleTypeRef EOF ;
    public final void entryRuleTypeRef() throws RecognitionException {
        try {
            // InternalXtext.g:313:1: ( ruleTypeRef EOF )
            // InternalXtext.g:314:1: ruleTypeRef EOF
            {
             before(grammarAccess.getTypeRefRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTypeRef();

            state._fsp--;

             after(grammarAccess.getTypeRefRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalXtext.g:321:1: ruleTypeRef : ( ( rule__TypeRef__Group__0 ) ) ;
    public final void ruleTypeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:325:2: ( ( ( rule__TypeRef__Group__0 ) ) )
            // InternalXtext.g:326:1: ( ( rule__TypeRef__Group__0 ) )
            {
            // InternalXtext.g:326:1: ( ( rule__TypeRef__Group__0 ) )
            // InternalXtext.g:327:1: ( rule__TypeRef__Group__0 )
            {
             before(grammarAccess.getTypeRefAccess().getGroup()); 
            // InternalXtext.g:328:1: ( rule__TypeRef__Group__0 )
            // InternalXtext.g:328:2: rule__TypeRef__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:340:1: entryRuleAlternatives : ruleAlternatives EOF ;
    public final void entryRuleAlternatives() throws RecognitionException {
        try {
            // InternalXtext.g:341:1: ( ruleAlternatives EOF )
            // InternalXtext.g:342:1: ruleAlternatives EOF
            {
             before(grammarAccess.getAlternativesRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAlternatives();

            state._fsp--;

             after(grammarAccess.getAlternativesRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalXtext.g:349:1: ruleAlternatives : ( ( rule__Alternatives__Group__0 ) ) ;
    public final void ruleAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:353:2: ( ( ( rule__Alternatives__Group__0 ) ) )
            // InternalXtext.g:354:1: ( ( rule__Alternatives__Group__0 ) )
            {
            // InternalXtext.g:354:1: ( ( rule__Alternatives__Group__0 ) )
            // InternalXtext.g:355:1: ( rule__Alternatives__Group__0 )
            {
             before(grammarAccess.getAlternativesAccess().getGroup()); 
            // InternalXtext.g:356:1: ( rule__Alternatives__Group__0 )
            // InternalXtext.g:356:2: rule__Alternatives__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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


    // $ANTLR start "entryRuleConditionalBranch"
    // InternalXtext.g:368:1: entryRuleConditionalBranch : ruleConditionalBranch EOF ;
    public final void entryRuleConditionalBranch() throws RecognitionException {
        try {
            // InternalXtext.g:369:1: ( ruleConditionalBranch EOF )
            // InternalXtext.g:370:1: ruleConditionalBranch EOF
            {
             before(grammarAccess.getConditionalBranchRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleConditionalBranch();

            state._fsp--;

             after(grammarAccess.getConditionalBranchRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConditionalBranch"


    // $ANTLR start "ruleConditionalBranch"
    // InternalXtext.g:377:1: ruleConditionalBranch : ( ( rule__ConditionalBranch__Alternatives ) ) ;
    public final void ruleConditionalBranch() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:381:2: ( ( ( rule__ConditionalBranch__Alternatives ) ) )
            // InternalXtext.g:382:1: ( ( rule__ConditionalBranch__Alternatives ) )
            {
            // InternalXtext.g:382:1: ( ( rule__ConditionalBranch__Alternatives ) )
            // InternalXtext.g:383:1: ( rule__ConditionalBranch__Alternatives )
            {
             before(grammarAccess.getConditionalBranchAccess().getAlternatives()); 
            // InternalXtext.g:384:1: ( rule__ConditionalBranch__Alternatives )
            // InternalXtext.g:384:2: rule__ConditionalBranch__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConditionalBranch__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getConditionalBranchAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConditionalBranch"


    // $ANTLR start "entryRuleUnorderedGroup"
    // InternalXtext.g:396:1: entryRuleUnorderedGroup : ruleUnorderedGroup EOF ;
    public final void entryRuleUnorderedGroup() throws RecognitionException {
        try {
            // InternalXtext.g:397:1: ( ruleUnorderedGroup EOF )
            // InternalXtext.g:398:1: ruleUnorderedGroup EOF
            {
             before(grammarAccess.getUnorderedGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleUnorderedGroup();

            state._fsp--;

             after(grammarAccess.getUnorderedGroupRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalXtext.g:405:1: ruleUnorderedGroup : ( ( rule__UnorderedGroup__Group__0 ) ) ;
    public final void ruleUnorderedGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:409:2: ( ( ( rule__UnorderedGroup__Group__0 ) ) )
            // InternalXtext.g:410:1: ( ( rule__UnorderedGroup__Group__0 ) )
            {
            // InternalXtext.g:410:1: ( ( rule__UnorderedGroup__Group__0 ) )
            // InternalXtext.g:411:1: ( rule__UnorderedGroup__Group__0 )
            {
             before(grammarAccess.getUnorderedGroupAccess().getGroup()); 
            // InternalXtext.g:412:1: ( rule__UnorderedGroup__Group__0 )
            // InternalXtext.g:412:2: rule__UnorderedGroup__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:424:1: entryRuleGroup : ruleGroup EOF ;
    public final void entryRuleGroup() throws RecognitionException {
        try {
            // InternalXtext.g:425:1: ( ruleGroup EOF )
            // InternalXtext.g:426:1: ruleGroup EOF
            {
             before(grammarAccess.getGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleGroup();

            state._fsp--;

             after(grammarAccess.getGroupRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalXtext.g:433:1: ruleGroup : ( ( rule__Group__Group__0 ) ) ;
    public final void ruleGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:437:2: ( ( ( rule__Group__Group__0 ) ) )
            // InternalXtext.g:438:1: ( ( rule__Group__Group__0 ) )
            {
            // InternalXtext.g:438:1: ( ( rule__Group__Group__0 ) )
            // InternalXtext.g:439:1: ( rule__Group__Group__0 )
            {
             before(grammarAccess.getGroupAccess().getGroup()); 
            // InternalXtext.g:440:1: ( rule__Group__Group__0 )
            // InternalXtext.g:440:2: rule__Group__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:452:1: entryRuleAbstractToken : ruleAbstractToken EOF ;
    public final void entryRuleAbstractToken() throws RecognitionException {
        try {
            // InternalXtext.g:453:1: ( ruleAbstractToken EOF )
            // InternalXtext.g:454:1: ruleAbstractToken EOF
            {
             before(grammarAccess.getAbstractTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAbstractToken();

            state._fsp--;

             after(grammarAccess.getAbstractTokenRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalXtext.g:461:1: ruleAbstractToken : ( ( rule__AbstractToken__Alternatives ) ) ;
    public final void ruleAbstractToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:465:2: ( ( ( rule__AbstractToken__Alternatives ) ) )
            // InternalXtext.g:466:1: ( ( rule__AbstractToken__Alternatives ) )
            {
            // InternalXtext.g:466:1: ( ( rule__AbstractToken__Alternatives ) )
            // InternalXtext.g:467:1: ( rule__AbstractToken__Alternatives )
            {
             before(grammarAccess.getAbstractTokenAccess().getAlternatives()); 
            // InternalXtext.g:468:1: ( rule__AbstractToken__Alternatives )
            // InternalXtext.g:468:2: rule__AbstractToken__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:480:1: entryRuleAbstractTokenWithCardinality : ruleAbstractTokenWithCardinality EOF ;
    public final void entryRuleAbstractTokenWithCardinality() throws RecognitionException {
        try {
            // InternalXtext.g:481:1: ( ruleAbstractTokenWithCardinality EOF )
            // InternalXtext.g:482:1: ruleAbstractTokenWithCardinality EOF
            {
             before(grammarAccess.getAbstractTokenWithCardinalityRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAbstractTokenWithCardinality();

            state._fsp--;

             after(grammarAccess.getAbstractTokenWithCardinalityRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalXtext.g:489:1: ruleAbstractTokenWithCardinality : ( ( rule__AbstractTokenWithCardinality__Group__0 ) ) ;
    public final void ruleAbstractTokenWithCardinality() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:493:2: ( ( ( rule__AbstractTokenWithCardinality__Group__0 ) ) )
            // InternalXtext.g:494:1: ( ( rule__AbstractTokenWithCardinality__Group__0 ) )
            {
            // InternalXtext.g:494:1: ( ( rule__AbstractTokenWithCardinality__Group__0 ) )
            // InternalXtext.g:495:1: ( rule__AbstractTokenWithCardinality__Group__0 )
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getGroup()); 
            // InternalXtext.g:496:1: ( rule__AbstractTokenWithCardinality__Group__0 )
            // InternalXtext.g:496:2: rule__AbstractTokenWithCardinality__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:508:1: entryRuleAction : ruleAction EOF ;
    public final void entryRuleAction() throws RecognitionException {
        try {
            // InternalXtext.g:509:1: ( ruleAction EOF )
            // InternalXtext.g:510:1: ruleAction EOF
            {
             before(grammarAccess.getActionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAction();

            state._fsp--;

             after(grammarAccess.getActionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalXtext.g:517:1: ruleAction : ( ( rule__Action__Group__0 ) ) ;
    public final void ruleAction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:521:2: ( ( ( rule__Action__Group__0 ) ) )
            // InternalXtext.g:522:1: ( ( rule__Action__Group__0 ) )
            {
            // InternalXtext.g:522:1: ( ( rule__Action__Group__0 ) )
            // InternalXtext.g:523:1: ( rule__Action__Group__0 )
            {
             before(grammarAccess.getActionAccess().getGroup()); 
            // InternalXtext.g:524:1: ( rule__Action__Group__0 )
            // InternalXtext.g:524:2: rule__Action__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:536:1: entryRuleAbstractTerminal : ruleAbstractTerminal EOF ;
    public final void entryRuleAbstractTerminal() throws RecognitionException {
        try {
            // InternalXtext.g:537:1: ( ruleAbstractTerminal EOF )
            // InternalXtext.g:538:1: ruleAbstractTerminal EOF
            {
             before(grammarAccess.getAbstractTerminalRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAbstractTerminal();

            state._fsp--;

             after(grammarAccess.getAbstractTerminalRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalXtext.g:545:1: ruleAbstractTerminal : ( ( rule__AbstractTerminal__Alternatives ) ) ;
    public final void ruleAbstractTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:549:2: ( ( ( rule__AbstractTerminal__Alternatives ) ) )
            // InternalXtext.g:550:1: ( ( rule__AbstractTerminal__Alternatives ) )
            {
            // InternalXtext.g:550:1: ( ( rule__AbstractTerminal__Alternatives ) )
            // InternalXtext.g:551:1: ( rule__AbstractTerminal__Alternatives )
            {
             before(grammarAccess.getAbstractTerminalAccess().getAlternatives()); 
            // InternalXtext.g:552:1: ( rule__AbstractTerminal__Alternatives )
            // InternalXtext.g:552:2: rule__AbstractTerminal__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:564:1: entryRuleKeyword : ruleKeyword EOF ;
    public final void entryRuleKeyword() throws RecognitionException {
        try {
            // InternalXtext.g:565:1: ( ruleKeyword EOF )
            // InternalXtext.g:566:1: ruleKeyword EOF
            {
             before(grammarAccess.getKeywordRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleKeyword();

            state._fsp--;

             after(grammarAccess.getKeywordRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalXtext.g:573:1: ruleKeyword : ( ( rule__Keyword__ValueAssignment ) ) ;
    public final void ruleKeyword() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:577:2: ( ( ( rule__Keyword__ValueAssignment ) ) )
            // InternalXtext.g:578:1: ( ( rule__Keyword__ValueAssignment ) )
            {
            // InternalXtext.g:578:1: ( ( rule__Keyword__ValueAssignment ) )
            // InternalXtext.g:579:1: ( rule__Keyword__ValueAssignment )
            {
             before(grammarAccess.getKeywordAccess().getValueAssignment()); 
            // InternalXtext.g:580:1: ( rule__Keyword__ValueAssignment )
            // InternalXtext.g:580:2: rule__Keyword__ValueAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:592:1: entryRuleRuleCall : ruleRuleCall EOF ;
    public final void entryRuleRuleCall() throws RecognitionException {
        try {
            // InternalXtext.g:593:1: ( ruleRuleCall EOF )
            // InternalXtext.g:594:1: ruleRuleCall EOF
            {
             before(grammarAccess.getRuleCallRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleRuleCall();

            state._fsp--;

             after(grammarAccess.getRuleCallRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalXtext.g:601:1: ruleRuleCall : ( ( rule__RuleCall__Group__0 ) ) ;
    public final void ruleRuleCall() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:605:2: ( ( ( rule__RuleCall__Group__0 ) ) )
            // InternalXtext.g:606:1: ( ( rule__RuleCall__Group__0 ) )
            {
            // InternalXtext.g:606:1: ( ( rule__RuleCall__Group__0 ) )
            // InternalXtext.g:607:1: ( rule__RuleCall__Group__0 )
            {
             before(grammarAccess.getRuleCallAccess().getGroup()); 
            // InternalXtext.g:608:1: ( rule__RuleCall__Group__0 )
            // InternalXtext.g:608:2: rule__RuleCall__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleCall__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRuleCallAccess().getGroup()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleNamedArgument"
    // InternalXtext.g:620:1: entryRuleNamedArgument : ruleNamedArgument EOF ;
    public final void entryRuleNamedArgument() throws RecognitionException {
        try {
            // InternalXtext.g:621:1: ( ruleNamedArgument EOF )
            // InternalXtext.g:622:1: ruleNamedArgument EOF
            {
             before(grammarAccess.getNamedArgumentRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleNamedArgument();

            state._fsp--;

             after(grammarAccess.getNamedArgumentRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNamedArgument"


    // $ANTLR start "ruleNamedArgument"
    // InternalXtext.g:629:1: ruleNamedArgument : ( ( rule__NamedArgument__Group__0 ) ) ;
    public final void ruleNamedArgument() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:633:2: ( ( ( rule__NamedArgument__Group__0 ) ) )
            // InternalXtext.g:634:1: ( ( rule__NamedArgument__Group__0 ) )
            {
            // InternalXtext.g:634:1: ( ( rule__NamedArgument__Group__0 ) )
            // InternalXtext.g:635:1: ( rule__NamedArgument__Group__0 )
            {
             before(grammarAccess.getNamedArgumentAccess().getGroup()); 
            // InternalXtext.g:636:1: ( rule__NamedArgument__Group__0 )
            // InternalXtext.g:636:2: rule__NamedArgument__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__NamedArgument__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNamedArgumentAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNamedArgument"


    // $ANTLR start "entryRuleLiteralCondition"
    // InternalXtext.g:648:1: entryRuleLiteralCondition : ruleLiteralCondition EOF ;
    public final void entryRuleLiteralCondition() throws RecognitionException {
        try {
            // InternalXtext.g:649:1: ( ruleLiteralCondition EOF )
            // InternalXtext.g:650:1: ruleLiteralCondition EOF
            {
             before(grammarAccess.getLiteralConditionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleLiteralCondition();

            state._fsp--;

             after(grammarAccess.getLiteralConditionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLiteralCondition"


    // $ANTLR start "ruleLiteralCondition"
    // InternalXtext.g:657:1: ruleLiteralCondition : ( ( rule__LiteralCondition__Group__0 ) ) ;
    public final void ruleLiteralCondition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:661:2: ( ( ( rule__LiteralCondition__Group__0 ) ) )
            // InternalXtext.g:662:1: ( ( rule__LiteralCondition__Group__0 ) )
            {
            // InternalXtext.g:662:1: ( ( rule__LiteralCondition__Group__0 ) )
            // InternalXtext.g:663:1: ( rule__LiteralCondition__Group__0 )
            {
             before(grammarAccess.getLiteralConditionAccess().getGroup()); 
            // InternalXtext.g:664:1: ( rule__LiteralCondition__Group__0 )
            // InternalXtext.g:664:2: rule__LiteralCondition__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__LiteralCondition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLiteralConditionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLiteralCondition"


    // $ANTLR start "entryRuleDisjunction"
    // InternalXtext.g:676:1: entryRuleDisjunction : ruleDisjunction EOF ;
    public final void entryRuleDisjunction() throws RecognitionException {
        try {
            // InternalXtext.g:677:1: ( ruleDisjunction EOF )
            // InternalXtext.g:678:1: ruleDisjunction EOF
            {
             before(grammarAccess.getDisjunctionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleDisjunction();

            state._fsp--;

             after(grammarAccess.getDisjunctionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDisjunction"


    // $ANTLR start "ruleDisjunction"
    // InternalXtext.g:685:1: ruleDisjunction : ( ( rule__Disjunction__Group__0 ) ) ;
    public final void ruleDisjunction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:689:2: ( ( ( rule__Disjunction__Group__0 ) ) )
            // InternalXtext.g:690:1: ( ( rule__Disjunction__Group__0 ) )
            {
            // InternalXtext.g:690:1: ( ( rule__Disjunction__Group__0 ) )
            // InternalXtext.g:691:1: ( rule__Disjunction__Group__0 )
            {
             before(grammarAccess.getDisjunctionAccess().getGroup()); 
            // InternalXtext.g:692:1: ( rule__Disjunction__Group__0 )
            // InternalXtext.g:692:2: rule__Disjunction__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Disjunction__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDisjunctionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDisjunction"


    // $ANTLR start "entryRuleConjunction"
    // InternalXtext.g:704:1: entryRuleConjunction : ruleConjunction EOF ;
    public final void entryRuleConjunction() throws RecognitionException {
        try {
            // InternalXtext.g:705:1: ( ruleConjunction EOF )
            // InternalXtext.g:706:1: ruleConjunction EOF
            {
             before(grammarAccess.getConjunctionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleConjunction();

            state._fsp--;

             after(grammarAccess.getConjunctionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConjunction"


    // $ANTLR start "ruleConjunction"
    // InternalXtext.g:713:1: ruleConjunction : ( ( rule__Conjunction__Group__0 ) ) ;
    public final void ruleConjunction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:717:2: ( ( ( rule__Conjunction__Group__0 ) ) )
            // InternalXtext.g:718:1: ( ( rule__Conjunction__Group__0 ) )
            {
            // InternalXtext.g:718:1: ( ( rule__Conjunction__Group__0 ) )
            // InternalXtext.g:719:1: ( rule__Conjunction__Group__0 )
            {
             before(grammarAccess.getConjunctionAccess().getGroup()); 
            // InternalXtext.g:720:1: ( rule__Conjunction__Group__0 )
            // InternalXtext.g:720:2: rule__Conjunction__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Conjunction__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConjunctionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConjunction"


    // $ANTLR start "entryRuleNegation"
    // InternalXtext.g:732:1: entryRuleNegation : ruleNegation EOF ;
    public final void entryRuleNegation() throws RecognitionException {
        try {
            // InternalXtext.g:733:1: ( ruleNegation EOF )
            // InternalXtext.g:734:1: ruleNegation EOF
            {
             before(grammarAccess.getNegationRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleNegation();

            state._fsp--;

             after(grammarAccess.getNegationRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNegation"


    // $ANTLR start "ruleNegation"
    // InternalXtext.g:741:1: ruleNegation : ( ( rule__Negation__Alternatives ) ) ;
    public final void ruleNegation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:745:2: ( ( ( rule__Negation__Alternatives ) ) )
            // InternalXtext.g:746:1: ( ( rule__Negation__Alternatives ) )
            {
            // InternalXtext.g:746:1: ( ( rule__Negation__Alternatives ) )
            // InternalXtext.g:747:1: ( rule__Negation__Alternatives )
            {
             before(grammarAccess.getNegationAccess().getAlternatives()); 
            // InternalXtext.g:748:1: ( rule__Negation__Alternatives )
            // InternalXtext.g:748:2: rule__Negation__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Negation__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getNegationAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNegation"


    // $ANTLR start "entryRuleAtom"
    // InternalXtext.g:760:1: entryRuleAtom : ruleAtom EOF ;
    public final void entryRuleAtom() throws RecognitionException {
        try {
            // InternalXtext.g:761:1: ( ruleAtom EOF )
            // InternalXtext.g:762:1: ruleAtom EOF
            {
             before(grammarAccess.getAtomRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAtom();

            state._fsp--;

             after(grammarAccess.getAtomRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAtom"


    // $ANTLR start "ruleAtom"
    // InternalXtext.g:769:1: ruleAtom : ( ( rule__Atom__Alternatives ) ) ;
    public final void ruleAtom() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:773:2: ( ( ( rule__Atom__Alternatives ) ) )
            // InternalXtext.g:774:1: ( ( rule__Atom__Alternatives ) )
            {
            // InternalXtext.g:774:1: ( ( rule__Atom__Alternatives ) )
            // InternalXtext.g:775:1: ( rule__Atom__Alternatives )
            {
             before(grammarAccess.getAtomAccess().getAlternatives()); 
            // InternalXtext.g:776:1: ( rule__Atom__Alternatives )
            // InternalXtext.g:776:2: rule__Atom__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Atom__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAtomAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAtom"


    // $ANTLR start "entryRuleParenthesizedCondition"
    // InternalXtext.g:788:1: entryRuleParenthesizedCondition : ruleParenthesizedCondition EOF ;
    public final void entryRuleParenthesizedCondition() throws RecognitionException {
        try {
            // InternalXtext.g:789:1: ( ruleParenthesizedCondition EOF )
            // InternalXtext.g:790:1: ruleParenthesizedCondition EOF
            {
             before(grammarAccess.getParenthesizedConditionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleParenthesizedCondition();

            state._fsp--;

             after(grammarAccess.getParenthesizedConditionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParenthesizedCondition"


    // $ANTLR start "ruleParenthesizedCondition"
    // InternalXtext.g:797:1: ruleParenthesizedCondition : ( ( rule__ParenthesizedCondition__Group__0 ) ) ;
    public final void ruleParenthesizedCondition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:801:2: ( ( ( rule__ParenthesizedCondition__Group__0 ) ) )
            // InternalXtext.g:802:1: ( ( rule__ParenthesizedCondition__Group__0 ) )
            {
            // InternalXtext.g:802:1: ( ( rule__ParenthesizedCondition__Group__0 ) )
            // InternalXtext.g:803:1: ( rule__ParenthesizedCondition__Group__0 )
            {
             before(grammarAccess.getParenthesizedConditionAccess().getGroup()); 
            // InternalXtext.g:804:1: ( rule__ParenthesizedCondition__Group__0 )
            // InternalXtext.g:804:2: rule__ParenthesizedCondition__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParenthesizedCondition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParenthesizedConditionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParenthesizedCondition"


    // $ANTLR start "entryRuleParameterReference"
    // InternalXtext.g:816:1: entryRuleParameterReference : ruleParameterReference EOF ;
    public final void entryRuleParameterReference() throws RecognitionException {
        try {
            // InternalXtext.g:817:1: ( ruleParameterReference EOF )
            // InternalXtext.g:818:1: ruleParameterReference EOF
            {
             before(grammarAccess.getParameterReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleParameterReference();

            state._fsp--;

             after(grammarAccess.getParameterReferenceRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterReference"


    // $ANTLR start "ruleParameterReference"
    // InternalXtext.g:825:1: ruleParameterReference : ( ( rule__ParameterReference__ParameterAssignment ) ) ;
    public final void ruleParameterReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:829:2: ( ( ( rule__ParameterReference__ParameterAssignment ) ) )
            // InternalXtext.g:830:1: ( ( rule__ParameterReference__ParameterAssignment ) )
            {
            // InternalXtext.g:830:1: ( ( rule__ParameterReference__ParameterAssignment ) )
            // InternalXtext.g:831:1: ( rule__ParameterReference__ParameterAssignment )
            {
             before(grammarAccess.getParameterReferenceAccess().getParameterAssignment()); 
            // InternalXtext.g:832:1: ( rule__ParameterReference__ParameterAssignment )
            // InternalXtext.g:832:2: rule__ParameterReference__ParameterAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParameterReference__ParameterAssignment();

            state._fsp--;


            }

             after(grammarAccess.getParameterReferenceAccess().getParameterAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameterReference"


    // $ANTLR start "entryRuleTerminalRuleCall"
    // InternalXtext.g:844:1: entryRuleTerminalRuleCall : ruleTerminalRuleCall EOF ;
    public final void entryRuleTerminalRuleCall() throws RecognitionException {
        try {
            // InternalXtext.g:845:1: ( ruleTerminalRuleCall EOF )
            // InternalXtext.g:846:1: ruleTerminalRuleCall EOF
            {
             before(grammarAccess.getTerminalRuleCallRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTerminalRuleCall();

            state._fsp--;

             after(grammarAccess.getTerminalRuleCallRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTerminalRuleCall"


    // $ANTLR start "ruleTerminalRuleCall"
    // InternalXtext.g:853:1: ruleTerminalRuleCall : ( ( rule__TerminalRuleCall__RuleAssignment ) ) ;
    public final void ruleTerminalRuleCall() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:857:2: ( ( ( rule__TerminalRuleCall__RuleAssignment ) ) )
            // InternalXtext.g:858:1: ( ( rule__TerminalRuleCall__RuleAssignment ) )
            {
            // InternalXtext.g:858:1: ( ( rule__TerminalRuleCall__RuleAssignment ) )
            // InternalXtext.g:859:1: ( rule__TerminalRuleCall__RuleAssignment )
            {
             before(grammarAccess.getTerminalRuleCallAccess().getRuleAssignment()); 
            // InternalXtext.g:860:1: ( rule__TerminalRuleCall__RuleAssignment )
            // InternalXtext.g:860:2: rule__TerminalRuleCall__RuleAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRuleCall__RuleAssignment();

            state._fsp--;


            }

             after(grammarAccess.getTerminalRuleCallAccess().getRuleAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTerminalRuleCall"


    // $ANTLR start "entryRuleRuleID"
    // InternalXtext.g:872:1: entryRuleRuleID : ruleRuleID EOF ;
    public final void entryRuleRuleID() throws RecognitionException {
        try {
            // InternalXtext.g:873:1: ( ruleRuleID EOF )
            // InternalXtext.g:874:1: ruleRuleID EOF
            {
             before(grammarAccess.getRuleIDRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleRuleID();

            state._fsp--;

             after(grammarAccess.getRuleIDRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRuleID"


    // $ANTLR start "ruleRuleID"
    // InternalXtext.g:881:1: ruleRuleID : ( ( rule__RuleID__Group__0 ) ) ;
    public final void ruleRuleID() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:885:2: ( ( ( rule__RuleID__Group__0 ) ) )
            // InternalXtext.g:886:1: ( ( rule__RuleID__Group__0 ) )
            {
            // InternalXtext.g:886:1: ( ( rule__RuleID__Group__0 ) )
            // InternalXtext.g:887:1: ( rule__RuleID__Group__0 )
            {
             before(grammarAccess.getRuleIDAccess().getGroup()); 
            // InternalXtext.g:888:1: ( rule__RuleID__Group__0 )
            // InternalXtext.g:888:2: rule__RuleID__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleID__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRuleIDAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRuleID"


    // $ANTLR start "entryRuleValidID"
    // InternalXtext.g:900:1: entryRuleValidID : ruleValidID EOF ;
    public final void entryRuleValidID() throws RecognitionException {
        try {
            // InternalXtext.g:901:1: ( ruleValidID EOF )
            // InternalXtext.g:902:1: ruleValidID EOF
            {
             before(grammarAccess.getValidIDRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getValidIDRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleValidID"


    // $ANTLR start "ruleValidID"
    // InternalXtext.g:909:1: ruleValidID : ( ( rule__ValidID__Alternatives ) ) ;
    public final void ruleValidID() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:913:2: ( ( ( rule__ValidID__Alternatives ) ) )
            // InternalXtext.g:914:1: ( ( rule__ValidID__Alternatives ) )
            {
            // InternalXtext.g:914:1: ( ( rule__ValidID__Alternatives ) )
            // InternalXtext.g:915:1: ( rule__ValidID__Alternatives )
            {
             before(grammarAccess.getValidIDAccess().getAlternatives()); 
            // InternalXtext.g:916:1: ( rule__ValidID__Alternatives )
            // InternalXtext.g:916:2: rule__ValidID__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ValidID__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getValidIDAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleValidID"


    // $ANTLR start "entryRulePredicatedKeyword"
    // InternalXtext.g:928:1: entryRulePredicatedKeyword : rulePredicatedKeyword EOF ;
    public final void entryRulePredicatedKeyword() throws RecognitionException {
        try {
            // InternalXtext.g:929:1: ( rulePredicatedKeyword EOF )
            // InternalXtext.g:930:1: rulePredicatedKeyword EOF
            {
             before(grammarAccess.getPredicatedKeywordRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            rulePredicatedKeyword();

            state._fsp--;

             after(grammarAccess.getPredicatedKeywordRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePredicatedKeyword"


    // $ANTLR start "rulePredicatedKeyword"
    // InternalXtext.g:937:1: rulePredicatedKeyword : ( ( rule__PredicatedKeyword__Group__0 ) ) ;
    public final void rulePredicatedKeyword() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:941:2: ( ( ( rule__PredicatedKeyword__Group__0 ) ) )
            // InternalXtext.g:942:1: ( ( rule__PredicatedKeyword__Group__0 ) )
            {
            // InternalXtext.g:942:1: ( ( rule__PredicatedKeyword__Group__0 ) )
            // InternalXtext.g:943:1: ( rule__PredicatedKeyword__Group__0 )
            {
             before(grammarAccess.getPredicatedKeywordAccess().getGroup()); 
            // InternalXtext.g:944:1: ( rule__PredicatedKeyword__Group__0 )
            // InternalXtext.g:944:2: rule__PredicatedKeyword__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedKeyword__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPredicatedKeywordAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePredicatedKeyword"


    // $ANTLR start "entryRulePredicatedRuleCall"
    // InternalXtext.g:956:1: entryRulePredicatedRuleCall : rulePredicatedRuleCall EOF ;
    public final void entryRulePredicatedRuleCall() throws RecognitionException {
        try {
            // InternalXtext.g:957:1: ( rulePredicatedRuleCall EOF )
            // InternalXtext.g:958:1: rulePredicatedRuleCall EOF
            {
             before(grammarAccess.getPredicatedRuleCallRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            rulePredicatedRuleCall();

            state._fsp--;

             after(grammarAccess.getPredicatedRuleCallRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePredicatedRuleCall"


    // $ANTLR start "rulePredicatedRuleCall"
    // InternalXtext.g:965:1: rulePredicatedRuleCall : ( ( rule__PredicatedRuleCall__Group__0 ) ) ;
    public final void rulePredicatedRuleCall() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:969:2: ( ( ( rule__PredicatedRuleCall__Group__0 ) ) )
            // InternalXtext.g:970:1: ( ( rule__PredicatedRuleCall__Group__0 ) )
            {
            // InternalXtext.g:970:1: ( ( rule__PredicatedRuleCall__Group__0 ) )
            // InternalXtext.g:971:1: ( rule__PredicatedRuleCall__Group__0 )
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getGroup()); 
            // InternalXtext.g:972:1: ( rule__PredicatedRuleCall__Group__0 )
            // InternalXtext.g:972:2: rule__PredicatedRuleCall__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedRuleCall__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPredicatedRuleCallAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePredicatedRuleCall"


    // $ANTLR start "entryRuleAssignment"
    // InternalXtext.g:984:1: entryRuleAssignment : ruleAssignment EOF ;
    public final void entryRuleAssignment() throws RecognitionException {
        try {
            // InternalXtext.g:985:1: ( ruleAssignment EOF )
            // InternalXtext.g:986:1: ruleAssignment EOF
            {
             before(grammarAccess.getAssignmentRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAssignment();

            state._fsp--;

             after(grammarAccess.getAssignmentRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalXtext.g:993:1: ruleAssignment : ( ( rule__Assignment__Group__0 ) ) ;
    public final void ruleAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:997:2: ( ( ( rule__Assignment__Group__0 ) ) )
            // InternalXtext.g:998:1: ( ( rule__Assignment__Group__0 ) )
            {
            // InternalXtext.g:998:1: ( ( rule__Assignment__Group__0 ) )
            // InternalXtext.g:999:1: ( rule__Assignment__Group__0 )
            {
             before(grammarAccess.getAssignmentAccess().getGroup()); 
            // InternalXtext.g:1000:1: ( rule__Assignment__Group__0 )
            // InternalXtext.g:1000:2: rule__Assignment__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:1012:1: entryRuleAssignableTerminal : ruleAssignableTerminal EOF ;
    public final void entryRuleAssignableTerminal() throws RecognitionException {
        try {
            // InternalXtext.g:1013:1: ( ruleAssignableTerminal EOF )
            // InternalXtext.g:1014:1: ruleAssignableTerminal EOF
            {
             before(grammarAccess.getAssignableTerminalRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAssignableTerminal();

            state._fsp--;

             after(grammarAccess.getAssignableTerminalRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalXtext.g:1021:1: ruleAssignableTerminal : ( ( rule__AssignableTerminal__Alternatives ) ) ;
    public final void ruleAssignableTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:1025:2: ( ( ( rule__AssignableTerminal__Alternatives ) ) )
            // InternalXtext.g:1026:1: ( ( rule__AssignableTerminal__Alternatives ) )
            {
            // InternalXtext.g:1026:1: ( ( rule__AssignableTerminal__Alternatives ) )
            // InternalXtext.g:1027:1: ( rule__AssignableTerminal__Alternatives )
            {
             before(grammarAccess.getAssignableTerminalAccess().getAlternatives()); 
            // InternalXtext.g:1028:1: ( rule__AssignableTerminal__Alternatives )
            // InternalXtext.g:1028:2: rule__AssignableTerminal__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:1040:1: entryRuleParenthesizedAssignableElement : ruleParenthesizedAssignableElement EOF ;
    public final void entryRuleParenthesizedAssignableElement() throws RecognitionException {
        try {
            // InternalXtext.g:1041:1: ( ruleParenthesizedAssignableElement EOF )
            // InternalXtext.g:1042:1: ruleParenthesizedAssignableElement EOF
            {
             before(grammarAccess.getParenthesizedAssignableElementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleParenthesizedAssignableElement();

            state._fsp--;

             after(grammarAccess.getParenthesizedAssignableElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalXtext.g:1049:1: ruleParenthesizedAssignableElement : ( ( rule__ParenthesizedAssignableElement__Group__0 ) ) ;
    public final void ruleParenthesizedAssignableElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:1053:2: ( ( ( rule__ParenthesizedAssignableElement__Group__0 ) ) )
            // InternalXtext.g:1054:1: ( ( rule__ParenthesizedAssignableElement__Group__0 ) )
            {
            // InternalXtext.g:1054:1: ( ( rule__ParenthesizedAssignableElement__Group__0 ) )
            // InternalXtext.g:1055:1: ( rule__ParenthesizedAssignableElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getGroup()); 
            // InternalXtext.g:1056:1: ( rule__ParenthesizedAssignableElement__Group__0 )
            // InternalXtext.g:1056:2: rule__ParenthesizedAssignableElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:1068:1: entryRuleAssignableAlternatives : ruleAssignableAlternatives EOF ;
    public final void entryRuleAssignableAlternatives() throws RecognitionException {
        try {
            // InternalXtext.g:1069:1: ( ruleAssignableAlternatives EOF )
            // InternalXtext.g:1070:1: ruleAssignableAlternatives EOF
            {
             before(grammarAccess.getAssignableAlternativesRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAssignableAlternatives();

            state._fsp--;

             after(grammarAccess.getAssignableAlternativesRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalXtext.g:1077:1: ruleAssignableAlternatives : ( ( rule__AssignableAlternatives__Group__0 ) ) ;
    public final void ruleAssignableAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:1081:2: ( ( ( rule__AssignableAlternatives__Group__0 ) ) )
            // InternalXtext.g:1082:1: ( ( rule__AssignableAlternatives__Group__0 ) )
            {
            // InternalXtext.g:1082:1: ( ( rule__AssignableAlternatives__Group__0 ) )
            // InternalXtext.g:1083:1: ( rule__AssignableAlternatives__Group__0 )
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup()); 
            // InternalXtext.g:1084:1: ( rule__AssignableAlternatives__Group__0 )
            // InternalXtext.g:1084:2: rule__AssignableAlternatives__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:1096:1: entryRuleCrossReference : ruleCrossReference EOF ;
    public final void entryRuleCrossReference() throws RecognitionException {
        try {
            // InternalXtext.g:1097:1: ( ruleCrossReference EOF )
            // InternalXtext.g:1098:1: ruleCrossReference EOF
            {
             before(grammarAccess.getCrossReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleCrossReference();

            state._fsp--;

             after(grammarAccess.getCrossReferenceRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalXtext.g:1105:1: ruleCrossReference : ( ( rule__CrossReference__Group__0 ) ) ;
    public final void ruleCrossReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:1109:2: ( ( ( rule__CrossReference__Group__0 ) ) )
            // InternalXtext.g:1110:1: ( ( rule__CrossReference__Group__0 ) )
            {
            // InternalXtext.g:1110:1: ( ( rule__CrossReference__Group__0 ) )
            // InternalXtext.g:1111:1: ( rule__CrossReference__Group__0 )
            {
             before(grammarAccess.getCrossReferenceAccess().getGroup()); 
            // InternalXtext.g:1112:1: ( rule__CrossReference__Group__0 )
            // InternalXtext.g:1112:2: rule__CrossReference__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:1124:1: entryRuleCrossReferenceableTerminal : ruleCrossReferenceableTerminal EOF ;
    public final void entryRuleCrossReferenceableTerminal() throws RecognitionException {
        try {
            // InternalXtext.g:1125:1: ( ruleCrossReferenceableTerminal EOF )
            // InternalXtext.g:1126:1: ruleCrossReferenceableTerminal EOF
            {
             before(grammarAccess.getCrossReferenceableTerminalRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleCrossReferenceableTerminal();

            state._fsp--;

             after(grammarAccess.getCrossReferenceableTerminalRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalXtext.g:1133:1: ruleCrossReferenceableTerminal : ( ( rule__CrossReferenceableTerminal__Alternatives ) ) ;
    public final void ruleCrossReferenceableTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:1137:2: ( ( ( rule__CrossReferenceableTerminal__Alternatives ) ) )
            // InternalXtext.g:1138:1: ( ( rule__CrossReferenceableTerminal__Alternatives ) )
            {
            // InternalXtext.g:1138:1: ( ( rule__CrossReferenceableTerminal__Alternatives ) )
            // InternalXtext.g:1139:1: ( rule__CrossReferenceableTerminal__Alternatives )
            {
             before(grammarAccess.getCrossReferenceableTerminalAccess().getAlternatives()); 
            // InternalXtext.g:1140:1: ( rule__CrossReferenceableTerminal__Alternatives )
            // InternalXtext.g:1140:2: rule__CrossReferenceableTerminal__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:1152:1: entryRuleParenthesizedElement : ruleParenthesizedElement EOF ;
    public final void entryRuleParenthesizedElement() throws RecognitionException {
        try {
            // InternalXtext.g:1153:1: ( ruleParenthesizedElement EOF )
            // InternalXtext.g:1154:1: ruleParenthesizedElement EOF
            {
             before(grammarAccess.getParenthesizedElementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleParenthesizedElement();

            state._fsp--;

             after(grammarAccess.getParenthesizedElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalXtext.g:1161:1: ruleParenthesizedElement : ( ( rule__ParenthesizedElement__Group__0 ) ) ;
    public final void ruleParenthesizedElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:1165:2: ( ( ( rule__ParenthesizedElement__Group__0 ) ) )
            // InternalXtext.g:1166:1: ( ( rule__ParenthesizedElement__Group__0 ) )
            {
            // InternalXtext.g:1166:1: ( ( rule__ParenthesizedElement__Group__0 ) )
            // InternalXtext.g:1167:1: ( rule__ParenthesizedElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedElementAccess().getGroup()); 
            // InternalXtext.g:1168:1: ( rule__ParenthesizedElement__Group__0 )
            // InternalXtext.g:1168:2: rule__ParenthesizedElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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


    // $ANTLR start "entryRulePredicatedGroup"
    // InternalXtext.g:1180:1: entryRulePredicatedGroup : rulePredicatedGroup EOF ;
    public final void entryRulePredicatedGroup() throws RecognitionException {
        try {
            // InternalXtext.g:1181:1: ( rulePredicatedGroup EOF )
            // InternalXtext.g:1182:1: rulePredicatedGroup EOF
            {
             before(grammarAccess.getPredicatedGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            rulePredicatedGroup();

            state._fsp--;

             after(grammarAccess.getPredicatedGroupRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePredicatedGroup"


    // $ANTLR start "rulePredicatedGroup"
    // InternalXtext.g:1189:1: rulePredicatedGroup : ( ( rule__PredicatedGroup__Group__0 ) ) ;
    public final void rulePredicatedGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:1193:2: ( ( ( rule__PredicatedGroup__Group__0 ) ) )
            // InternalXtext.g:1194:1: ( ( rule__PredicatedGroup__Group__0 ) )
            {
            // InternalXtext.g:1194:1: ( ( rule__PredicatedGroup__Group__0 ) )
            // InternalXtext.g:1195:1: ( rule__PredicatedGroup__Group__0 )
            {
             before(grammarAccess.getPredicatedGroupAccess().getGroup()); 
            // InternalXtext.g:1196:1: ( rule__PredicatedGroup__Group__0 )
            // InternalXtext.g:1196:2: rule__PredicatedGroup__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedGroup__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPredicatedGroupAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePredicatedGroup"


    // $ANTLR start "entryRuleTerminalRule"
    // InternalXtext.g:1208:1: entryRuleTerminalRule : ruleTerminalRule EOF ;
    public final void entryRuleTerminalRule() throws RecognitionException {
        try {
            // InternalXtext.g:1209:1: ( ruleTerminalRule EOF )
            // InternalXtext.g:1210:1: ruleTerminalRule EOF
            {
             before(grammarAccess.getTerminalRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTerminalRule();

            state._fsp--;

             after(grammarAccess.getTerminalRuleRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalXtext.g:1217:1: ruleTerminalRule : ( ( rule__TerminalRule__Group__0 ) ) ;
    public final void ruleTerminalRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:1221:2: ( ( ( rule__TerminalRule__Group__0 ) ) )
            // InternalXtext.g:1222:1: ( ( rule__TerminalRule__Group__0 ) )
            {
            // InternalXtext.g:1222:1: ( ( rule__TerminalRule__Group__0 ) )
            // InternalXtext.g:1223:1: ( rule__TerminalRule__Group__0 )
            {
             before(grammarAccess.getTerminalRuleAccess().getGroup()); 
            // InternalXtext.g:1224:1: ( rule__TerminalRule__Group__0 )
            // InternalXtext.g:1224:2: rule__TerminalRule__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:1236:1: entryRuleTerminalAlternatives : ruleTerminalAlternatives EOF ;
    public final void entryRuleTerminalAlternatives() throws RecognitionException {
        try {
            // InternalXtext.g:1237:1: ( ruleTerminalAlternatives EOF )
            // InternalXtext.g:1238:1: ruleTerminalAlternatives EOF
            {
             before(grammarAccess.getTerminalAlternativesRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTerminalAlternatives();

            state._fsp--;

             after(grammarAccess.getTerminalAlternativesRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalXtext.g:1245:1: ruleTerminalAlternatives : ( ( rule__TerminalAlternatives__Group__0 ) ) ;
    public final void ruleTerminalAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:1249:2: ( ( ( rule__TerminalAlternatives__Group__0 ) ) )
            // InternalXtext.g:1250:1: ( ( rule__TerminalAlternatives__Group__0 ) )
            {
            // InternalXtext.g:1250:1: ( ( rule__TerminalAlternatives__Group__0 ) )
            // InternalXtext.g:1251:1: ( rule__TerminalAlternatives__Group__0 )
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup()); 
            // InternalXtext.g:1252:1: ( rule__TerminalAlternatives__Group__0 )
            // InternalXtext.g:1252:2: rule__TerminalAlternatives__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:1264:1: entryRuleTerminalGroup : ruleTerminalGroup EOF ;
    public final void entryRuleTerminalGroup() throws RecognitionException {
        try {
            // InternalXtext.g:1265:1: ( ruleTerminalGroup EOF )
            // InternalXtext.g:1266:1: ruleTerminalGroup EOF
            {
             before(grammarAccess.getTerminalGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTerminalGroup();

            state._fsp--;

             after(grammarAccess.getTerminalGroupRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalXtext.g:1273:1: ruleTerminalGroup : ( ( rule__TerminalGroup__Group__0 ) ) ;
    public final void ruleTerminalGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:1277:2: ( ( ( rule__TerminalGroup__Group__0 ) ) )
            // InternalXtext.g:1278:1: ( ( rule__TerminalGroup__Group__0 ) )
            {
            // InternalXtext.g:1278:1: ( ( rule__TerminalGroup__Group__0 ) )
            // InternalXtext.g:1279:1: ( rule__TerminalGroup__Group__0 )
            {
             before(grammarAccess.getTerminalGroupAccess().getGroup()); 
            // InternalXtext.g:1280:1: ( rule__TerminalGroup__Group__0 )
            // InternalXtext.g:1280:2: rule__TerminalGroup__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:1292:1: entryRuleTerminalToken : ruleTerminalToken EOF ;
    public final void entryRuleTerminalToken() throws RecognitionException {
        try {
            // InternalXtext.g:1293:1: ( ruleTerminalToken EOF )
            // InternalXtext.g:1294:1: ruleTerminalToken EOF
            {
             before(grammarAccess.getTerminalTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTerminalToken();

            state._fsp--;

             after(grammarAccess.getTerminalTokenRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalXtext.g:1301:1: ruleTerminalToken : ( ( rule__TerminalToken__Group__0 ) ) ;
    public final void ruleTerminalToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:1305:2: ( ( ( rule__TerminalToken__Group__0 ) ) )
            // InternalXtext.g:1306:1: ( ( rule__TerminalToken__Group__0 ) )
            {
            // InternalXtext.g:1306:1: ( ( rule__TerminalToken__Group__0 ) )
            // InternalXtext.g:1307:1: ( rule__TerminalToken__Group__0 )
            {
             before(grammarAccess.getTerminalTokenAccess().getGroup()); 
            // InternalXtext.g:1308:1: ( rule__TerminalToken__Group__0 )
            // InternalXtext.g:1308:2: rule__TerminalToken__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:1320:1: entryRuleTerminalTokenElement : ruleTerminalTokenElement EOF ;
    public final void entryRuleTerminalTokenElement() throws RecognitionException {
        try {
            // InternalXtext.g:1321:1: ( ruleTerminalTokenElement EOF )
            // InternalXtext.g:1322:1: ruleTerminalTokenElement EOF
            {
             before(grammarAccess.getTerminalTokenElementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTerminalTokenElement();

            state._fsp--;

             after(grammarAccess.getTerminalTokenElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalXtext.g:1329:1: ruleTerminalTokenElement : ( ( rule__TerminalTokenElement__Alternatives ) ) ;
    public final void ruleTerminalTokenElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:1333:2: ( ( ( rule__TerminalTokenElement__Alternatives ) ) )
            // InternalXtext.g:1334:1: ( ( rule__TerminalTokenElement__Alternatives ) )
            {
            // InternalXtext.g:1334:1: ( ( rule__TerminalTokenElement__Alternatives ) )
            // InternalXtext.g:1335:1: ( rule__TerminalTokenElement__Alternatives )
            {
             before(grammarAccess.getTerminalTokenElementAccess().getAlternatives()); 
            // InternalXtext.g:1336:1: ( rule__TerminalTokenElement__Alternatives )
            // InternalXtext.g:1336:2: rule__TerminalTokenElement__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:1348:1: entryRuleParenthesizedTerminalElement : ruleParenthesizedTerminalElement EOF ;
    public final void entryRuleParenthesizedTerminalElement() throws RecognitionException {
        try {
            // InternalXtext.g:1349:1: ( ruleParenthesizedTerminalElement EOF )
            // InternalXtext.g:1350:1: ruleParenthesizedTerminalElement EOF
            {
             before(grammarAccess.getParenthesizedTerminalElementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleParenthesizedTerminalElement();

            state._fsp--;

             after(grammarAccess.getParenthesizedTerminalElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalXtext.g:1357:1: ruleParenthesizedTerminalElement : ( ( rule__ParenthesizedTerminalElement__Group__0 ) ) ;
    public final void ruleParenthesizedTerminalElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:1361:2: ( ( ( rule__ParenthesizedTerminalElement__Group__0 ) ) )
            // InternalXtext.g:1362:1: ( ( rule__ParenthesizedTerminalElement__Group__0 ) )
            {
            // InternalXtext.g:1362:1: ( ( rule__ParenthesizedTerminalElement__Group__0 ) )
            // InternalXtext.g:1363:1: ( rule__ParenthesizedTerminalElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getGroup()); 
            // InternalXtext.g:1364:1: ( rule__ParenthesizedTerminalElement__Group__0 )
            // InternalXtext.g:1364:2: rule__ParenthesizedTerminalElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:1376:1: entryRuleAbstractNegatedToken : ruleAbstractNegatedToken EOF ;
    public final void entryRuleAbstractNegatedToken() throws RecognitionException {
        try {
            // InternalXtext.g:1377:1: ( ruleAbstractNegatedToken EOF )
            // InternalXtext.g:1378:1: ruleAbstractNegatedToken EOF
            {
             before(grammarAccess.getAbstractNegatedTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAbstractNegatedToken();

            state._fsp--;

             after(grammarAccess.getAbstractNegatedTokenRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalXtext.g:1385:1: ruleAbstractNegatedToken : ( ( rule__AbstractNegatedToken__Alternatives ) ) ;
    public final void ruleAbstractNegatedToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:1389:2: ( ( ( rule__AbstractNegatedToken__Alternatives ) ) )
            // InternalXtext.g:1390:1: ( ( rule__AbstractNegatedToken__Alternatives ) )
            {
            // InternalXtext.g:1390:1: ( ( rule__AbstractNegatedToken__Alternatives ) )
            // InternalXtext.g:1391:1: ( rule__AbstractNegatedToken__Alternatives )
            {
             before(grammarAccess.getAbstractNegatedTokenAccess().getAlternatives()); 
            // InternalXtext.g:1392:1: ( rule__AbstractNegatedToken__Alternatives )
            // InternalXtext.g:1392:2: rule__AbstractNegatedToken__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:1404:1: entryRuleNegatedToken : ruleNegatedToken EOF ;
    public final void entryRuleNegatedToken() throws RecognitionException {
        try {
            // InternalXtext.g:1405:1: ( ruleNegatedToken EOF )
            // InternalXtext.g:1406:1: ruleNegatedToken EOF
            {
             before(grammarAccess.getNegatedTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleNegatedToken();

            state._fsp--;

             after(grammarAccess.getNegatedTokenRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalXtext.g:1413:1: ruleNegatedToken : ( ( rule__NegatedToken__Group__0 ) ) ;
    public final void ruleNegatedToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:1417:2: ( ( ( rule__NegatedToken__Group__0 ) ) )
            // InternalXtext.g:1418:1: ( ( rule__NegatedToken__Group__0 ) )
            {
            // InternalXtext.g:1418:1: ( ( rule__NegatedToken__Group__0 ) )
            // InternalXtext.g:1419:1: ( rule__NegatedToken__Group__0 )
            {
             before(grammarAccess.getNegatedTokenAccess().getGroup()); 
            // InternalXtext.g:1420:1: ( rule__NegatedToken__Group__0 )
            // InternalXtext.g:1420:2: rule__NegatedToken__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:1432:1: entryRuleUntilToken : ruleUntilToken EOF ;
    public final void entryRuleUntilToken() throws RecognitionException {
        try {
            // InternalXtext.g:1433:1: ( ruleUntilToken EOF )
            // InternalXtext.g:1434:1: ruleUntilToken EOF
            {
             before(grammarAccess.getUntilTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleUntilToken();

            state._fsp--;

             after(grammarAccess.getUntilTokenRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalXtext.g:1441:1: ruleUntilToken : ( ( rule__UntilToken__Group__0 ) ) ;
    public final void ruleUntilToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:1445:2: ( ( ( rule__UntilToken__Group__0 ) ) )
            // InternalXtext.g:1446:1: ( ( rule__UntilToken__Group__0 ) )
            {
            // InternalXtext.g:1446:1: ( ( rule__UntilToken__Group__0 ) )
            // InternalXtext.g:1447:1: ( rule__UntilToken__Group__0 )
            {
             before(grammarAccess.getUntilTokenAccess().getGroup()); 
            // InternalXtext.g:1448:1: ( rule__UntilToken__Group__0 )
            // InternalXtext.g:1448:2: rule__UntilToken__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:1460:1: entryRuleWildcard : ruleWildcard EOF ;
    public final void entryRuleWildcard() throws RecognitionException {
        try {
            // InternalXtext.g:1461:1: ( ruleWildcard EOF )
            // InternalXtext.g:1462:1: ruleWildcard EOF
            {
             before(grammarAccess.getWildcardRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleWildcard();

            state._fsp--;

             after(grammarAccess.getWildcardRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalXtext.g:1469:1: ruleWildcard : ( ( rule__Wildcard__Group__0 ) ) ;
    public final void ruleWildcard() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:1473:2: ( ( ( rule__Wildcard__Group__0 ) ) )
            // InternalXtext.g:1474:1: ( ( rule__Wildcard__Group__0 ) )
            {
            // InternalXtext.g:1474:1: ( ( rule__Wildcard__Group__0 ) )
            // InternalXtext.g:1475:1: ( rule__Wildcard__Group__0 )
            {
             before(grammarAccess.getWildcardAccess().getGroup()); 
            // InternalXtext.g:1476:1: ( rule__Wildcard__Group__0 )
            // InternalXtext.g:1476:2: rule__Wildcard__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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


    // $ANTLR start "entryRuleEOF"
    // InternalXtext.g:1488:1: entryRuleEOF : ruleEOF EOF ;
    public final void entryRuleEOF() throws RecognitionException {
        try {
            // InternalXtext.g:1489:1: ( ruleEOF EOF )
            // InternalXtext.g:1490:1: ruleEOF EOF
            {
             before(grammarAccess.getEOFRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleEOF();

            state._fsp--;

             after(grammarAccess.getEOFRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEOF"


    // $ANTLR start "ruleEOF"
    // InternalXtext.g:1497:1: ruleEOF : ( ( rule__EOF__Group__0 ) ) ;
    public final void ruleEOF() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:1501:2: ( ( ( rule__EOF__Group__0 ) ) )
            // InternalXtext.g:1502:1: ( ( rule__EOF__Group__0 ) )
            {
            // InternalXtext.g:1502:1: ( ( rule__EOF__Group__0 ) )
            // InternalXtext.g:1503:1: ( rule__EOF__Group__0 )
            {
             before(grammarAccess.getEOFAccess().getGroup()); 
            // InternalXtext.g:1504:1: ( rule__EOF__Group__0 )
            // InternalXtext.g:1504:2: rule__EOF__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EOF__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEOFAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEOF"


    // $ANTLR start "entryRuleCharacterRange"
    // InternalXtext.g:1516:1: entryRuleCharacterRange : ruleCharacterRange EOF ;
    public final void entryRuleCharacterRange() throws RecognitionException {
        try {
            // InternalXtext.g:1517:1: ( ruleCharacterRange EOF )
            // InternalXtext.g:1518:1: ruleCharacterRange EOF
            {
             before(grammarAccess.getCharacterRangeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleCharacterRange();

            state._fsp--;

             after(grammarAccess.getCharacterRangeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalXtext.g:1525:1: ruleCharacterRange : ( ( rule__CharacterRange__Group__0 ) ) ;
    public final void ruleCharacterRange() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:1529:2: ( ( ( rule__CharacterRange__Group__0 ) ) )
            // InternalXtext.g:1530:1: ( ( rule__CharacterRange__Group__0 ) )
            {
            // InternalXtext.g:1530:1: ( ( rule__CharacterRange__Group__0 ) )
            // InternalXtext.g:1531:1: ( rule__CharacterRange__Group__0 )
            {
             before(grammarAccess.getCharacterRangeAccess().getGroup()); 
            // InternalXtext.g:1532:1: ( rule__CharacterRange__Group__0 )
            // InternalXtext.g:1532:2: rule__CharacterRange__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:1544:1: entryRuleEnumRule : ruleEnumRule EOF ;
    public final void entryRuleEnumRule() throws RecognitionException {
        try {
            // InternalXtext.g:1545:1: ( ruleEnumRule EOF )
            // InternalXtext.g:1546:1: ruleEnumRule EOF
            {
             before(grammarAccess.getEnumRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleEnumRule();

            state._fsp--;

             after(grammarAccess.getEnumRuleRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalXtext.g:1553:1: ruleEnumRule : ( ( rule__EnumRule__Group__0 ) ) ;
    public final void ruleEnumRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:1557:2: ( ( ( rule__EnumRule__Group__0 ) ) )
            // InternalXtext.g:1558:1: ( ( rule__EnumRule__Group__0 ) )
            {
            // InternalXtext.g:1558:1: ( ( rule__EnumRule__Group__0 ) )
            // InternalXtext.g:1559:1: ( rule__EnumRule__Group__0 )
            {
             before(grammarAccess.getEnumRuleAccess().getGroup()); 
            // InternalXtext.g:1560:1: ( rule__EnumRule__Group__0 )
            // InternalXtext.g:1560:2: rule__EnumRule__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:1572:1: entryRuleEnumLiterals : ruleEnumLiterals EOF ;
    public final void entryRuleEnumLiterals() throws RecognitionException {
        try {
            // InternalXtext.g:1573:1: ( ruleEnumLiterals EOF )
            // InternalXtext.g:1574:1: ruleEnumLiterals EOF
            {
             before(grammarAccess.getEnumLiteralsRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleEnumLiterals();

            state._fsp--;

             after(grammarAccess.getEnumLiteralsRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalXtext.g:1581:1: ruleEnumLiterals : ( ( rule__EnumLiterals__Group__0 ) ) ;
    public final void ruleEnumLiterals() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:1585:2: ( ( ( rule__EnumLiterals__Group__0 ) ) )
            // InternalXtext.g:1586:1: ( ( rule__EnumLiterals__Group__0 ) )
            {
            // InternalXtext.g:1586:1: ( ( rule__EnumLiterals__Group__0 ) )
            // InternalXtext.g:1587:1: ( rule__EnumLiterals__Group__0 )
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup()); 
            // InternalXtext.g:1588:1: ( rule__EnumLiterals__Group__0 )
            // InternalXtext.g:1588:2: rule__EnumLiterals__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:1600:1: entryRuleEnumLiteralDeclaration : ruleEnumLiteralDeclaration EOF ;
    public final void entryRuleEnumLiteralDeclaration() throws RecognitionException {
        try {
            // InternalXtext.g:1601:1: ( ruleEnumLiteralDeclaration EOF )
            // InternalXtext.g:1602:1: ruleEnumLiteralDeclaration EOF
            {
             before(grammarAccess.getEnumLiteralDeclarationRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleEnumLiteralDeclaration();

            state._fsp--;

             after(grammarAccess.getEnumLiteralDeclarationRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalXtext.g:1609:1: ruleEnumLiteralDeclaration : ( ( rule__EnumLiteralDeclaration__Group__0 ) ) ;
    public final void ruleEnumLiteralDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:1613:2: ( ( ( rule__EnumLiteralDeclaration__Group__0 ) ) )
            // InternalXtext.g:1614:1: ( ( rule__EnumLiteralDeclaration__Group__0 ) )
            {
            // InternalXtext.g:1614:1: ( ( rule__EnumLiteralDeclaration__Group__0 ) )
            // InternalXtext.g:1615:1: ( rule__EnumLiteralDeclaration__Group__0 )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getGroup()); 
            // InternalXtext.g:1616:1: ( rule__EnumLiteralDeclaration__Group__0 )
            // InternalXtext.g:1616:2: rule__EnumLiteralDeclaration__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:1628:1: rule__AbstractRule__Alternatives : ( ( ruleParserRule ) | ( ruleTerminalRule ) | ( ruleEnumRule ) );
    public final void rule__AbstractRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:1632:1: ( ( ruleParserRule ) | ( ruleTerminalRule ) | ( ruleEnumRule ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case 16:
            case 17:
            case 48:
                {
                alt1=1;
                }
                break;
            case 42:
                {
                alt1=2;
                }
                break;
            case 46:
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
                    // InternalXtext.g:1633:1: ( ruleParserRule )
                    {
                    // InternalXtext.g:1633:1: ( ruleParserRule )
                    // InternalXtext.g:1634:1: ruleParserRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getParserRuleParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleParserRule();

                    state._fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getParserRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:1639:6: ( ruleTerminalRule )
                    {
                    // InternalXtext.g:1639:6: ( ruleTerminalRule )
                    // InternalXtext.g:1640:1: ruleTerminalRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getTerminalRuleParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleTerminalRule();

                    state._fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getTerminalRuleParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtext.g:1645:6: ( ruleEnumRule )
                    {
                    // InternalXtext.g:1645:6: ( ruleEnumRule )
                    // InternalXtext.g:1646:1: ruleEnumRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getEnumRuleParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:1656:1: rule__AbstractMetamodelDeclaration__Alternatives : ( ( ruleGeneratedMetamodel ) | ( ruleReferencedMetamodel ) );
    public final void rule__AbstractMetamodelDeclaration__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:1660:1: ( ( ruleGeneratedMetamodel ) | ( ruleReferencedMetamodel ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==25) ) {
                alt2=1;
            }
            else if ( (LA2_0==27) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalXtext.g:1661:1: ( ruleGeneratedMetamodel )
                    {
                    // InternalXtext.g:1661:1: ( ruleGeneratedMetamodel )
                    // InternalXtext.g:1662:1: ruleGeneratedMetamodel
                    {
                     before(grammarAccess.getAbstractMetamodelDeclarationAccess().getGeneratedMetamodelParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleGeneratedMetamodel();

                    state._fsp--;

                     after(grammarAccess.getAbstractMetamodelDeclarationAccess().getGeneratedMetamodelParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:1667:6: ( ruleReferencedMetamodel )
                    {
                    // InternalXtext.g:1667:6: ( ruleReferencedMetamodel )
                    // InternalXtext.g:1668:1: ruleReferencedMetamodel
                    {
                     before(grammarAccess.getAbstractMetamodelDeclarationAccess().getReferencedMetamodelParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
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


    // $ANTLR start "rule__ParserRule__Alternatives_0"
    // InternalXtext.g:1678:1: rule__ParserRule__Alternatives_0 : ( ( ( rule__ParserRule__Group_0_0__0 ) ) | ( ( rule__ParserRule__Group_0_1__0 ) ) );
    public final void rule__ParserRule__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:1682:1: ( ( ( rule__ParserRule__Group_0_0__0 ) ) | ( ( rule__ParserRule__Group_0_1__0 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==48) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_ID||(LA3_0>=16 && LA3_0<=17)) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalXtext.g:1683:1: ( ( rule__ParserRule__Group_0_0__0 ) )
                    {
                    // InternalXtext.g:1683:1: ( ( rule__ParserRule__Group_0_0__0 ) )
                    // InternalXtext.g:1684:1: ( rule__ParserRule__Group_0_0__0 )
                    {
                     before(grammarAccess.getParserRuleAccess().getGroup_0_0()); 
                    // InternalXtext.g:1685:1: ( rule__ParserRule__Group_0_0__0 )
                    // InternalXtext.g:1685:2: rule__ParserRule__Group_0_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ParserRule__Group_0_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getParserRuleAccess().getGroup_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:1689:6: ( ( rule__ParserRule__Group_0_1__0 ) )
                    {
                    // InternalXtext.g:1689:6: ( ( rule__ParserRule__Group_0_1__0 ) )
                    // InternalXtext.g:1690:1: ( rule__ParserRule__Group_0_1__0 )
                    {
                     before(grammarAccess.getParserRuleAccess().getGroup_0_1()); 
                    // InternalXtext.g:1691:1: ( rule__ParserRule__Group_0_1__0 )
                    // InternalXtext.g:1691:2: rule__ParserRule__Group_0_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ParserRule__Group_0_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getParserRuleAccess().getGroup_0_1()); 

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
    // $ANTLR end "rule__ParserRule__Alternatives_0"


    // $ANTLR start "rule__ParserRule__Alternatives_0_0_2"
    // InternalXtext.g:1700:1: rule__ParserRule__Alternatives_0_0_2 : ( ( ( rule__ParserRule__WildcardAssignment_0_0_2_0 ) ) | ( ( rule__ParserRule__Group_0_0_2_1__0 )? ) );
    public final void rule__ParserRule__Alternatives_0_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:1704:1: ( ( ( rule__ParserRule__WildcardAssignment_0_0_2_0 ) ) | ( ( rule__ParserRule__Group_0_0_2_1__0 )? ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==12) ) {
                alt5=1;
            }
            else if ( (LA5_0==28||LA5_0==30||LA5_0==47) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalXtext.g:1705:1: ( ( rule__ParserRule__WildcardAssignment_0_0_2_0 ) )
                    {
                    // InternalXtext.g:1705:1: ( ( rule__ParserRule__WildcardAssignment_0_0_2_0 ) )
                    // InternalXtext.g:1706:1: ( rule__ParserRule__WildcardAssignment_0_0_2_0 )
                    {
                     before(grammarAccess.getParserRuleAccess().getWildcardAssignment_0_0_2_0()); 
                    // InternalXtext.g:1707:1: ( rule__ParserRule__WildcardAssignment_0_0_2_0 )
                    // InternalXtext.g:1707:2: rule__ParserRule__WildcardAssignment_0_0_2_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ParserRule__WildcardAssignment_0_0_2_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getParserRuleAccess().getWildcardAssignment_0_0_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:1711:6: ( ( rule__ParserRule__Group_0_0_2_1__0 )? )
                    {
                    // InternalXtext.g:1711:6: ( ( rule__ParserRule__Group_0_0_2_1__0 )? )
                    // InternalXtext.g:1712:1: ( rule__ParserRule__Group_0_0_2_1__0 )?
                    {
                     before(grammarAccess.getParserRuleAccess().getGroup_0_0_2_1()); 
                    // InternalXtext.g:1713:1: ( rule__ParserRule__Group_0_0_2_1__0 )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==30) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // InternalXtext.g:1713:2: rule__ParserRule__Group_0_0_2_1__0
                            {
                            pushFollow(FollowSets000.FOLLOW_2);
                            rule__ParserRule__Group_0_0_2_1__0();

                            state._fsp--;


                            }
                            break;

                    }

                     after(grammarAccess.getParserRuleAccess().getGroup_0_0_2_1()); 

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
    // $ANTLR end "rule__ParserRule__Alternatives_0_0_2"


    // $ANTLR start "rule__ConditionalBranch__Alternatives"
    // InternalXtext.g:1722:1: rule__ConditionalBranch__Alternatives : ( ( ruleUnorderedGroup ) | ( ( rule__ConditionalBranch__Group_1__0 ) ) );
    public final void rule__ConditionalBranch__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:1726:1: ( ( ruleUnorderedGroup ) | ( ( rule__ConditionalBranch__Group_1__0 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=RULE_ID && LA6_0<=RULE_STRING)||(LA6_0>=16 && LA6_0<=17)||LA6_0==22||LA6_0==36||LA6_0==43||LA6_0==49) ) {
                alt6=1;
            }
            else if ( (LA6_0==31) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalXtext.g:1727:1: ( ruleUnorderedGroup )
                    {
                    // InternalXtext.g:1727:1: ( ruleUnorderedGroup )
                    // InternalXtext.g:1728:1: ruleUnorderedGroup
                    {
                     before(grammarAccess.getConditionalBranchAccess().getUnorderedGroupParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleUnorderedGroup();

                    state._fsp--;

                     after(grammarAccess.getConditionalBranchAccess().getUnorderedGroupParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:1733:6: ( ( rule__ConditionalBranch__Group_1__0 ) )
                    {
                    // InternalXtext.g:1733:6: ( ( rule__ConditionalBranch__Group_1__0 ) )
                    // InternalXtext.g:1734:1: ( rule__ConditionalBranch__Group_1__0 )
                    {
                     before(grammarAccess.getConditionalBranchAccess().getGroup_1()); 
                    // InternalXtext.g:1735:1: ( rule__ConditionalBranch__Group_1__0 )
                    // InternalXtext.g:1735:2: rule__ConditionalBranch__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ConditionalBranch__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getConditionalBranchAccess().getGroup_1()); 

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
    // $ANTLR end "rule__ConditionalBranch__Alternatives"


    // $ANTLR start "rule__AbstractToken__Alternatives"
    // InternalXtext.g:1744:1: rule__AbstractToken__Alternatives : ( ( ruleAbstractTokenWithCardinality ) | ( ruleAction ) );
    public final void rule__AbstractToken__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:1748:1: ( ( ruleAbstractTokenWithCardinality ) | ( ruleAction ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=RULE_ID && LA7_0<=RULE_STRING)||(LA7_0>=16 && LA7_0<=17)||LA7_0==22||LA7_0==43||LA7_0==49) ) {
                alt7=1;
            }
            else if ( (LA7_0==36) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalXtext.g:1749:1: ( ruleAbstractTokenWithCardinality )
                    {
                    // InternalXtext.g:1749:1: ( ruleAbstractTokenWithCardinality )
                    // InternalXtext.g:1750:1: ruleAbstractTokenWithCardinality
                    {
                     before(grammarAccess.getAbstractTokenAccess().getAbstractTokenWithCardinalityParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAbstractTokenWithCardinality();

                    state._fsp--;

                     after(grammarAccess.getAbstractTokenAccess().getAbstractTokenWithCardinalityParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:1755:6: ( ruleAction )
                    {
                    // InternalXtext.g:1755:6: ( ruleAction )
                    // InternalXtext.g:1756:1: ruleAction
                    {
                     before(grammarAccess.getAbstractTokenAccess().getActionParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:1766:1: rule__AbstractTokenWithCardinality__Alternatives_0 : ( ( ruleAssignment ) | ( ruleAbstractTerminal ) );
    public final void rule__AbstractTokenWithCardinality__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:1770:1: ( ( ruleAssignment ) | ( ruleAbstractTerminal ) )
            int alt8=2;
            switch ( input.LA(1) ) {
            case 49:
                {
                switch ( input.LA(2) ) {
                case RULE_ID:
                    {
                    int LA8_7 = input.LA(3);

                    if ( ((LA8_7>=14 && LA8_7<=15)||LA8_7==18) ) {
                        alt8=1;
                    }
                    else if ( (LA8_7==EOF||(LA8_7>=RULE_ID && LA8_7<=RULE_STRING)||(LA8_7>=11 && LA8_7<=13)||(LA8_7>=16 && LA8_7<=17)||(LA8_7>=22 && LA8_7<=23)||LA8_7==29||LA8_7==31||(LA8_7>=34 && LA8_7<=36)||LA8_7==43||LA8_7==49) ) {
                        alt8=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 7, input);

                        throw nvae;
                    }
                    }
                    break;
                case RULE_STRING:
                case 22:
                    {
                    alt8=2;
                    }
                    break;
                case 16:
                case 17:
                    {
                    alt8=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;
                }

                }
                break;
            case 43:
                {
                switch ( input.LA(2) ) {
                case RULE_ID:
                    {
                    int LA8_7 = input.LA(3);

                    if ( ((LA8_7>=14 && LA8_7<=15)||LA8_7==18) ) {
                        alt8=1;
                    }
                    else if ( (LA8_7==EOF||(LA8_7>=RULE_ID && LA8_7<=RULE_STRING)||(LA8_7>=11 && LA8_7<=13)||(LA8_7>=16 && LA8_7<=17)||(LA8_7>=22 && LA8_7<=23)||LA8_7==29||LA8_7==31||(LA8_7>=34 && LA8_7<=36)||LA8_7==43||LA8_7==49) ) {
                        alt8=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 7, input);

                        throw nvae;
                    }
                    }
                    break;
                case RULE_STRING:
                case 22:
                    {
                    alt8=2;
                    }
                    break;
                case 16:
                case 17:
                    {
                    alt8=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 2, input);

                    throw nvae;
                }

                }
                break;
            case RULE_ID:
                {
                int LA8_3 = input.LA(2);

                if ( ((LA8_3>=14 && LA8_3<=15)||LA8_3==18) ) {
                    alt8=1;
                }
                else if ( (LA8_3==EOF||(LA8_3>=RULE_ID && LA8_3<=RULE_STRING)||(LA8_3>=11 && LA8_3<=13)||(LA8_3>=16 && LA8_3<=17)||(LA8_3>=22 && LA8_3<=23)||LA8_3==29||LA8_3==31||(LA8_3>=33 && LA8_3<=36)||LA8_3==43||LA8_3==49) ) {
                    alt8=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 3, input);

                    throw nvae;
                }
                }
                break;
            case 17:
                {
                int LA8_4 = input.LA(2);

                if ( ((LA8_4>=14 && LA8_4<=15)||LA8_4==18) ) {
                    alt8=1;
                }
                else if ( (LA8_4==EOF||(LA8_4>=RULE_ID && LA8_4<=RULE_STRING)||(LA8_4>=11 && LA8_4<=13)||(LA8_4>=16 && LA8_4<=17)||(LA8_4>=22 && LA8_4<=23)||LA8_4==29||LA8_4==31||(LA8_4>=33 && LA8_4<=36)||LA8_4==43||LA8_4==49) ) {
                    alt8=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 4, input);

                    throw nvae;
                }
                }
                break;
            case 16:
                {
                int LA8_5 = input.LA(2);

                if ( (LA8_5==EOF||(LA8_5>=RULE_ID && LA8_5<=RULE_STRING)||(LA8_5>=11 && LA8_5<=13)||(LA8_5>=16 && LA8_5<=17)||(LA8_5>=22 && LA8_5<=23)||LA8_5==29||LA8_5==31||(LA8_5>=33 && LA8_5<=36)||LA8_5==43||LA8_5==49) ) {
                    alt8=2;
                }
                else if ( ((LA8_5>=14 && LA8_5<=15)||LA8_5==18) ) {
                    alt8=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 5, input);

                    throw nvae;
                }
                }
                break;
            case RULE_STRING:
            case 22:
                {
                alt8=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalXtext.g:1771:1: ( ruleAssignment )
                    {
                    // InternalXtext.g:1771:1: ( ruleAssignment )
                    // InternalXtext.g:1772:1: ruleAssignment
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getAssignmentParserRuleCall_0_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAssignment();

                    state._fsp--;

                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getAssignmentParserRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:1777:6: ( ruleAbstractTerminal )
                    {
                    // InternalXtext.g:1777:6: ( ruleAbstractTerminal )
                    // InternalXtext.g:1778:1: ruleAbstractTerminal
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getAbstractTerminalParserRuleCall_0_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:1788:1: rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 : ( ( '?' ) | ( '*' ) | ( '+' ) );
    public final void rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:1792:1: ( ( '?' ) | ( '*' ) | ( '+' ) )
            int alt9=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt9=1;
                }
                break;
            case 12:
                {
                alt9=2;
                }
                break;
            case 13:
                {
                alt9=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalXtext.g:1793:1: ( '?' )
                    {
                    // InternalXtext.g:1793:1: ( '?' )
                    // InternalXtext.g:1794:1: '?'
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:1801:6: ( '*' )
                    {
                    // InternalXtext.g:1801:6: ( '*' )
                    // InternalXtext.g:1802:1: '*'
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAsteriskKeyword_1_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAsteriskKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtext.g:1809:6: ( '+' )
                    {
                    // InternalXtext.g:1809:6: ( '+' )
                    // InternalXtext.g:1810:1: '+'
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityPlusSignKeyword_1_0_2()); 
                    match(input,13,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:1822:1: rule__Action__OperatorAlternatives_2_2_0 : ( ( '=' ) | ( '+=' ) );
    public final void rule__Action__OperatorAlternatives_2_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:1826:1: ( ( '=' ) | ( '+=' ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==14) ) {
                alt10=1;
            }
            else if ( (LA10_0==15) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalXtext.g:1827:1: ( '=' )
                    {
                    // InternalXtext.g:1827:1: ( '=' )
                    // InternalXtext.g:1828:1: '='
                    {
                     before(grammarAccess.getActionAccess().getOperatorEqualsSignKeyword_2_2_0_0()); 
                    match(input,14,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getActionAccess().getOperatorEqualsSignKeyword_2_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:1835:6: ( '+=' )
                    {
                    // InternalXtext.g:1835:6: ( '+=' )
                    // InternalXtext.g:1836:1: '+='
                    {
                     before(grammarAccess.getActionAccess().getOperatorPlusSignEqualsSignKeyword_2_2_0_1()); 
                    match(input,15,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:1848:1: rule__AbstractTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedElement ) | ( rulePredicatedKeyword ) | ( rulePredicatedRuleCall ) | ( rulePredicatedGroup ) );
    public final void rule__AbstractTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:1852:1: ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedElement ) | ( rulePredicatedKeyword ) | ( rulePredicatedRuleCall ) | ( rulePredicatedGroup ) )
            int alt11=6;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt11=1;
                }
                break;
            case RULE_ID:
            case 16:
            case 17:
                {
                alt11=2;
                }
                break;
            case 22:
                {
                alt11=3;
                }
                break;
            case 49:
                {
                switch ( input.LA(2) ) {
                case RULE_STRING:
                    {
                    alt11=4;
                    }
                    break;
                case RULE_ID:
                    {
                    alt11=5;
                    }
                    break;
                case 22:
                    {
                    alt11=6;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 4, input);

                    throw nvae;
                }

                }
                break;
            case 43:
                {
                switch ( input.LA(2) ) {
                case RULE_STRING:
                    {
                    alt11=4;
                    }
                    break;
                case RULE_ID:
                    {
                    alt11=5;
                    }
                    break;
                case 22:
                    {
                    alt11=6;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 5, input);

                    throw nvae;
                }

                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalXtext.g:1853:1: ( ruleKeyword )
                    {
                    // InternalXtext.g:1853:1: ( ruleKeyword )
                    // InternalXtext.g:1854:1: ruleKeyword
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getKeywordParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleKeyword();

                    state._fsp--;

                     after(grammarAccess.getAbstractTerminalAccess().getKeywordParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:1859:6: ( ruleRuleCall )
                    {
                    // InternalXtext.g:1859:6: ( ruleRuleCall )
                    // InternalXtext.g:1860:1: ruleRuleCall
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleRuleCall();

                    state._fsp--;

                     after(grammarAccess.getAbstractTerminalAccess().getRuleCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtext.g:1865:6: ( ruleParenthesizedElement )
                    {
                    // InternalXtext.g:1865:6: ( ruleParenthesizedElement )
                    // InternalXtext.g:1866:1: ruleParenthesizedElement
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getParenthesizedElementParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleParenthesizedElement();

                    state._fsp--;

                     after(grammarAccess.getAbstractTerminalAccess().getParenthesizedElementParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalXtext.g:1871:6: ( rulePredicatedKeyword )
                    {
                    // InternalXtext.g:1871:6: ( rulePredicatedKeyword )
                    // InternalXtext.g:1872:1: rulePredicatedKeyword
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getPredicatedKeywordParserRuleCall_3()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    rulePredicatedKeyword();

                    state._fsp--;

                     after(grammarAccess.getAbstractTerminalAccess().getPredicatedKeywordParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalXtext.g:1877:6: ( rulePredicatedRuleCall )
                    {
                    // InternalXtext.g:1877:6: ( rulePredicatedRuleCall )
                    // InternalXtext.g:1878:1: rulePredicatedRuleCall
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getPredicatedRuleCallParserRuleCall_4()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    rulePredicatedRuleCall();

                    state._fsp--;

                     after(grammarAccess.getAbstractTerminalAccess().getPredicatedRuleCallParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalXtext.g:1883:6: ( rulePredicatedGroup )
                    {
                    // InternalXtext.g:1883:6: ( rulePredicatedGroup )
                    // InternalXtext.g:1884:1: rulePredicatedGroup
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getPredicatedGroupParserRuleCall_5()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    rulePredicatedGroup();

                    state._fsp--;

                     after(grammarAccess.getAbstractTerminalAccess().getPredicatedGroupParserRuleCall_5()); 

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


    // $ANTLR start "rule__LiteralCondition__Alternatives_1"
    // InternalXtext.g:1894:1: rule__LiteralCondition__Alternatives_1 : ( ( ( rule__LiteralCondition__TrueAssignment_1_0 ) ) | ( 'false' ) );
    public final void rule__LiteralCondition__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:1898:1: ( ( ( rule__LiteralCondition__TrueAssignment_1_0 ) ) | ( 'false' ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==17) ) {
                alt12=1;
            }
            else if ( (LA12_0==16) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalXtext.g:1899:1: ( ( rule__LiteralCondition__TrueAssignment_1_0 ) )
                    {
                    // InternalXtext.g:1899:1: ( ( rule__LiteralCondition__TrueAssignment_1_0 ) )
                    // InternalXtext.g:1900:1: ( rule__LiteralCondition__TrueAssignment_1_0 )
                    {
                     before(grammarAccess.getLiteralConditionAccess().getTrueAssignment_1_0()); 
                    // InternalXtext.g:1901:1: ( rule__LiteralCondition__TrueAssignment_1_0 )
                    // InternalXtext.g:1901:2: rule__LiteralCondition__TrueAssignment_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__LiteralCondition__TrueAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getLiteralConditionAccess().getTrueAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:1905:6: ( 'false' )
                    {
                    // InternalXtext.g:1905:6: ( 'false' )
                    // InternalXtext.g:1906:1: 'false'
                    {
                     before(grammarAccess.getLiteralConditionAccess().getFalseKeyword_1_1()); 
                    match(input,16,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getLiteralConditionAccess().getFalseKeyword_1_1()); 

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
    // $ANTLR end "rule__LiteralCondition__Alternatives_1"


    // $ANTLR start "rule__Negation__Alternatives"
    // InternalXtext.g:1918:1: rule__Negation__Alternatives : ( ( ruleAtom ) | ( ( rule__Negation__Group_1__0 ) ) );
    public final void rule__Negation__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:1922:1: ( ( ruleAtom ) | ( ( rule__Negation__Group_1__0 ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID||(LA13_0>=16 && LA13_0<=17)||LA13_0==22) ) {
                alt13=1;
            }
            else if ( (LA13_0==39) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalXtext.g:1923:1: ( ruleAtom )
                    {
                    // InternalXtext.g:1923:1: ( ruleAtom )
                    // InternalXtext.g:1924:1: ruleAtom
                    {
                     before(grammarAccess.getNegationAccess().getAtomParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAtom();

                    state._fsp--;

                     after(grammarAccess.getNegationAccess().getAtomParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:1929:6: ( ( rule__Negation__Group_1__0 ) )
                    {
                    // InternalXtext.g:1929:6: ( ( rule__Negation__Group_1__0 ) )
                    // InternalXtext.g:1930:1: ( rule__Negation__Group_1__0 )
                    {
                     before(grammarAccess.getNegationAccess().getGroup_1()); 
                    // InternalXtext.g:1931:1: ( rule__Negation__Group_1__0 )
                    // InternalXtext.g:1931:2: rule__Negation__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Negation__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNegationAccess().getGroup_1()); 

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
    // $ANTLR end "rule__Negation__Alternatives"


    // $ANTLR start "rule__Atom__Alternatives"
    // InternalXtext.g:1940:1: rule__Atom__Alternatives : ( ( ruleParameterReference ) | ( ruleParenthesizedCondition ) | ( ruleLiteralCondition ) );
    public final void rule__Atom__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:1944:1: ( ( ruleParameterReference ) | ( ruleParenthesizedCondition ) | ( ruleLiteralCondition ) )
            int alt14=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt14=1;
                }
                break;
            case 22:
                {
                alt14=2;
                }
                break;
            case 16:
            case 17:
                {
                alt14=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalXtext.g:1945:1: ( ruleParameterReference )
                    {
                    // InternalXtext.g:1945:1: ( ruleParameterReference )
                    // InternalXtext.g:1946:1: ruleParameterReference
                    {
                     before(grammarAccess.getAtomAccess().getParameterReferenceParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleParameterReference();

                    state._fsp--;

                     after(grammarAccess.getAtomAccess().getParameterReferenceParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:1951:6: ( ruleParenthesizedCondition )
                    {
                    // InternalXtext.g:1951:6: ( ruleParenthesizedCondition )
                    // InternalXtext.g:1952:1: ruleParenthesizedCondition
                    {
                     before(grammarAccess.getAtomAccess().getParenthesizedConditionParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleParenthesizedCondition();

                    state._fsp--;

                     after(grammarAccess.getAtomAccess().getParenthesizedConditionParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtext.g:1957:6: ( ruleLiteralCondition )
                    {
                    // InternalXtext.g:1957:6: ( ruleLiteralCondition )
                    // InternalXtext.g:1958:1: ruleLiteralCondition
                    {
                     before(grammarAccess.getAtomAccess().getLiteralConditionParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleLiteralCondition();

                    state._fsp--;

                     after(grammarAccess.getAtomAccess().getLiteralConditionParserRuleCall_2()); 

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
    // $ANTLR end "rule__Atom__Alternatives"


    // $ANTLR start "rule__ValidID__Alternatives"
    // InternalXtext.g:1968:1: rule__ValidID__Alternatives : ( ( RULE_ID ) | ( 'true' ) | ( 'false' ) );
    public final void rule__ValidID__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:1972:1: ( ( RULE_ID ) | ( 'true' ) | ( 'false' ) )
            int alt15=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt15=1;
                }
                break;
            case 17:
                {
                alt15=2;
                }
                break;
            case 16:
                {
                alt15=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalXtext.g:1973:1: ( RULE_ID )
                    {
                    // InternalXtext.g:1973:1: ( RULE_ID )
                    // InternalXtext.g:1974:1: RULE_ID
                    {
                     before(grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0()); 
                    match(input,RULE_ID,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:1979:6: ( 'true' )
                    {
                    // InternalXtext.g:1979:6: ( 'true' )
                    // InternalXtext.g:1980:1: 'true'
                    {
                     before(grammarAccess.getValidIDAccess().getTrueKeyword_1()); 
                    match(input,17,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getValidIDAccess().getTrueKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtext.g:1987:6: ( 'false' )
                    {
                    // InternalXtext.g:1987:6: ( 'false' )
                    // InternalXtext.g:1988:1: 'false'
                    {
                     before(grammarAccess.getValidIDAccess().getFalseKeyword_2()); 
                    match(input,16,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getValidIDAccess().getFalseKeyword_2()); 

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
    // $ANTLR end "rule__ValidID__Alternatives"


    // $ANTLR start "rule__PredicatedKeyword__Alternatives_0"
    // InternalXtext.g:2000:1: rule__PredicatedKeyword__Alternatives_0 : ( ( ( rule__PredicatedKeyword__PredicatedAssignment_0_0 ) ) | ( ( rule__PredicatedKeyword__FirstSetPredicatedAssignment_0_1 ) ) );
    public final void rule__PredicatedKeyword__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2004:1: ( ( ( rule__PredicatedKeyword__PredicatedAssignment_0_0 ) ) | ( ( rule__PredicatedKeyword__FirstSetPredicatedAssignment_0_1 ) ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==49) ) {
                alt16=1;
            }
            else if ( (LA16_0==43) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalXtext.g:2005:1: ( ( rule__PredicatedKeyword__PredicatedAssignment_0_0 ) )
                    {
                    // InternalXtext.g:2005:1: ( ( rule__PredicatedKeyword__PredicatedAssignment_0_0 ) )
                    // InternalXtext.g:2006:1: ( rule__PredicatedKeyword__PredicatedAssignment_0_0 )
                    {
                     before(grammarAccess.getPredicatedKeywordAccess().getPredicatedAssignment_0_0()); 
                    // InternalXtext.g:2007:1: ( rule__PredicatedKeyword__PredicatedAssignment_0_0 )
                    // InternalXtext.g:2007:2: rule__PredicatedKeyword__PredicatedAssignment_0_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__PredicatedKeyword__PredicatedAssignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPredicatedKeywordAccess().getPredicatedAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:2011:6: ( ( rule__PredicatedKeyword__FirstSetPredicatedAssignment_0_1 ) )
                    {
                    // InternalXtext.g:2011:6: ( ( rule__PredicatedKeyword__FirstSetPredicatedAssignment_0_1 ) )
                    // InternalXtext.g:2012:1: ( rule__PredicatedKeyword__FirstSetPredicatedAssignment_0_1 )
                    {
                     before(grammarAccess.getPredicatedKeywordAccess().getFirstSetPredicatedAssignment_0_1()); 
                    // InternalXtext.g:2013:1: ( rule__PredicatedKeyword__FirstSetPredicatedAssignment_0_1 )
                    // InternalXtext.g:2013:2: rule__PredicatedKeyword__FirstSetPredicatedAssignment_0_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__PredicatedKeyword__FirstSetPredicatedAssignment_0_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getPredicatedKeywordAccess().getFirstSetPredicatedAssignment_0_1()); 

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
    // $ANTLR end "rule__PredicatedKeyword__Alternatives_0"


    // $ANTLR start "rule__PredicatedRuleCall__Alternatives_0"
    // InternalXtext.g:2022:1: rule__PredicatedRuleCall__Alternatives_0 : ( ( ( rule__PredicatedRuleCall__PredicatedAssignment_0_0 ) ) | ( ( rule__PredicatedRuleCall__FirstSetPredicatedAssignment_0_1 ) ) );
    public final void rule__PredicatedRuleCall__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2026:1: ( ( ( rule__PredicatedRuleCall__PredicatedAssignment_0_0 ) ) | ( ( rule__PredicatedRuleCall__FirstSetPredicatedAssignment_0_1 ) ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==49) ) {
                alt17=1;
            }
            else if ( (LA17_0==43) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalXtext.g:2027:1: ( ( rule__PredicatedRuleCall__PredicatedAssignment_0_0 ) )
                    {
                    // InternalXtext.g:2027:1: ( ( rule__PredicatedRuleCall__PredicatedAssignment_0_0 ) )
                    // InternalXtext.g:2028:1: ( rule__PredicatedRuleCall__PredicatedAssignment_0_0 )
                    {
                     before(grammarAccess.getPredicatedRuleCallAccess().getPredicatedAssignment_0_0()); 
                    // InternalXtext.g:2029:1: ( rule__PredicatedRuleCall__PredicatedAssignment_0_0 )
                    // InternalXtext.g:2029:2: rule__PredicatedRuleCall__PredicatedAssignment_0_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__PredicatedRuleCall__PredicatedAssignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPredicatedRuleCallAccess().getPredicatedAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:2033:6: ( ( rule__PredicatedRuleCall__FirstSetPredicatedAssignment_0_1 ) )
                    {
                    // InternalXtext.g:2033:6: ( ( rule__PredicatedRuleCall__FirstSetPredicatedAssignment_0_1 ) )
                    // InternalXtext.g:2034:1: ( rule__PredicatedRuleCall__FirstSetPredicatedAssignment_0_1 )
                    {
                     before(grammarAccess.getPredicatedRuleCallAccess().getFirstSetPredicatedAssignment_0_1()); 
                    // InternalXtext.g:2035:1: ( rule__PredicatedRuleCall__FirstSetPredicatedAssignment_0_1 )
                    // InternalXtext.g:2035:2: rule__PredicatedRuleCall__FirstSetPredicatedAssignment_0_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__PredicatedRuleCall__FirstSetPredicatedAssignment_0_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getPredicatedRuleCallAccess().getFirstSetPredicatedAssignment_0_1()); 

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
    // $ANTLR end "rule__PredicatedRuleCall__Alternatives_0"


    // $ANTLR start "rule__Assignment__Alternatives_0"
    // InternalXtext.g:2044:1: rule__Assignment__Alternatives_0 : ( ( ( rule__Assignment__PredicatedAssignment_0_0 ) ) | ( ( rule__Assignment__FirstSetPredicatedAssignment_0_1 ) ) );
    public final void rule__Assignment__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2048:1: ( ( ( rule__Assignment__PredicatedAssignment_0_0 ) ) | ( ( rule__Assignment__FirstSetPredicatedAssignment_0_1 ) ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==49) ) {
                alt18=1;
            }
            else if ( (LA18_0==43) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalXtext.g:2049:1: ( ( rule__Assignment__PredicatedAssignment_0_0 ) )
                    {
                    // InternalXtext.g:2049:1: ( ( rule__Assignment__PredicatedAssignment_0_0 ) )
                    // InternalXtext.g:2050:1: ( rule__Assignment__PredicatedAssignment_0_0 )
                    {
                     before(grammarAccess.getAssignmentAccess().getPredicatedAssignment_0_0()); 
                    // InternalXtext.g:2051:1: ( rule__Assignment__PredicatedAssignment_0_0 )
                    // InternalXtext.g:2051:2: rule__Assignment__PredicatedAssignment_0_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Assignment__PredicatedAssignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getAssignmentAccess().getPredicatedAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:2055:6: ( ( rule__Assignment__FirstSetPredicatedAssignment_0_1 ) )
                    {
                    // InternalXtext.g:2055:6: ( ( rule__Assignment__FirstSetPredicatedAssignment_0_1 ) )
                    // InternalXtext.g:2056:1: ( rule__Assignment__FirstSetPredicatedAssignment_0_1 )
                    {
                     before(grammarAccess.getAssignmentAccess().getFirstSetPredicatedAssignment_0_1()); 
                    // InternalXtext.g:2057:1: ( rule__Assignment__FirstSetPredicatedAssignment_0_1 )
                    // InternalXtext.g:2057:2: rule__Assignment__FirstSetPredicatedAssignment_0_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Assignment__FirstSetPredicatedAssignment_0_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getAssignmentAccess().getFirstSetPredicatedAssignment_0_1()); 

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
    // $ANTLR end "rule__Assignment__Alternatives_0"


    // $ANTLR start "rule__Assignment__OperatorAlternatives_2_0"
    // InternalXtext.g:2066:1: rule__Assignment__OperatorAlternatives_2_0 : ( ( '+=' ) | ( '=' ) | ( '?=' ) );
    public final void rule__Assignment__OperatorAlternatives_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2070:1: ( ( '+=' ) | ( '=' ) | ( '?=' ) )
            int alt19=3;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt19=1;
                }
                break;
            case 14:
                {
                alt19=2;
                }
                break;
            case 18:
                {
                alt19=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // InternalXtext.g:2071:1: ( '+=' )
                    {
                    // InternalXtext.g:2071:1: ( '+=' )
                    // InternalXtext.g:2072:1: '+='
                    {
                     before(grammarAccess.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_2_0_0()); 
                    match(input,15,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:2079:6: ( '=' )
                    {
                    // InternalXtext.g:2079:6: ( '=' )
                    // InternalXtext.g:2080:1: '='
                    {
                     before(grammarAccess.getAssignmentAccess().getOperatorEqualsSignKeyword_2_0_1()); 
                    match(input,14,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getAssignmentAccess().getOperatorEqualsSignKeyword_2_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtext.g:2087:6: ( '?=' )
                    {
                    // InternalXtext.g:2087:6: ( '?=' )
                    // InternalXtext.g:2088:1: '?='
                    {
                     before(grammarAccess.getAssignmentAccess().getOperatorQuestionMarkEqualsSignKeyword_2_0_2()); 
                    match(input,18,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getAssignmentAccess().getOperatorQuestionMarkEqualsSignKeyword_2_0_2()); 

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
    // $ANTLR end "rule__Assignment__OperatorAlternatives_2_0"


    // $ANTLR start "rule__AssignableTerminal__Alternatives"
    // InternalXtext.g:2100:1: rule__AssignableTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedAssignableElement ) | ( ruleCrossReference ) );
    public final void rule__AssignableTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2104:1: ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedAssignableElement ) | ( ruleCrossReference ) )
            int alt20=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt20=1;
                }
                break;
            case RULE_ID:
            case 16:
            case 17:
                {
                alt20=2;
                }
                break;
            case 22:
                {
                alt20=3;
                }
                break;
            case 40:
                {
                alt20=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // InternalXtext.g:2105:1: ( ruleKeyword )
                    {
                    // InternalXtext.g:2105:1: ( ruleKeyword )
                    // InternalXtext.g:2106:1: ruleKeyword
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getKeywordParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleKeyword();

                    state._fsp--;

                     after(grammarAccess.getAssignableTerminalAccess().getKeywordParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:2111:6: ( ruleRuleCall )
                    {
                    // InternalXtext.g:2111:6: ( ruleRuleCall )
                    // InternalXtext.g:2112:1: ruleRuleCall
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleRuleCall();

                    state._fsp--;

                     after(grammarAccess.getAssignableTerminalAccess().getRuleCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtext.g:2117:6: ( ruleParenthesizedAssignableElement )
                    {
                    // InternalXtext.g:2117:6: ( ruleParenthesizedAssignableElement )
                    // InternalXtext.g:2118:1: ruleParenthesizedAssignableElement
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getParenthesizedAssignableElementParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleParenthesizedAssignableElement();

                    state._fsp--;

                     after(grammarAccess.getAssignableTerminalAccess().getParenthesizedAssignableElementParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalXtext.g:2123:6: ( ruleCrossReference )
                    {
                    // InternalXtext.g:2123:6: ( ruleCrossReference )
                    // InternalXtext.g:2124:1: ruleCrossReference
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getCrossReferenceParserRuleCall_3()); 
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:2134:1: rule__CrossReferenceableTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) );
    public final void rule__CrossReferenceableTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2138:1: ( ( ruleKeyword ) | ( ruleRuleCall ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_STRING) ) {
                alt21=1;
            }
            else if ( (LA21_0==RULE_ID||(LA21_0>=16 && LA21_0<=17)) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalXtext.g:2139:1: ( ruleKeyword )
                    {
                    // InternalXtext.g:2139:1: ( ruleKeyword )
                    // InternalXtext.g:2140:1: ruleKeyword
                    {
                     before(grammarAccess.getCrossReferenceableTerminalAccess().getKeywordParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleKeyword();

                    state._fsp--;

                     after(grammarAccess.getCrossReferenceableTerminalAccess().getKeywordParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:2145:6: ( ruleRuleCall )
                    {
                    // InternalXtext.g:2145:6: ( ruleRuleCall )
                    // InternalXtext.g:2146:1: ruleRuleCall
                    {
                     before(grammarAccess.getCrossReferenceableTerminalAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
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


    // $ANTLR start "rule__PredicatedGroup__Alternatives_0"
    // InternalXtext.g:2156:1: rule__PredicatedGroup__Alternatives_0 : ( ( ( rule__PredicatedGroup__PredicatedAssignment_0_0 ) ) | ( ( rule__PredicatedGroup__FirstSetPredicatedAssignment_0_1 ) ) );
    public final void rule__PredicatedGroup__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2160:1: ( ( ( rule__PredicatedGroup__PredicatedAssignment_0_0 ) ) | ( ( rule__PredicatedGroup__FirstSetPredicatedAssignment_0_1 ) ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==49) ) {
                alt22=1;
            }
            else if ( (LA22_0==43) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalXtext.g:2161:1: ( ( rule__PredicatedGroup__PredicatedAssignment_0_0 ) )
                    {
                    // InternalXtext.g:2161:1: ( ( rule__PredicatedGroup__PredicatedAssignment_0_0 ) )
                    // InternalXtext.g:2162:1: ( rule__PredicatedGroup__PredicatedAssignment_0_0 )
                    {
                     before(grammarAccess.getPredicatedGroupAccess().getPredicatedAssignment_0_0()); 
                    // InternalXtext.g:2163:1: ( rule__PredicatedGroup__PredicatedAssignment_0_0 )
                    // InternalXtext.g:2163:2: rule__PredicatedGroup__PredicatedAssignment_0_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__PredicatedGroup__PredicatedAssignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPredicatedGroupAccess().getPredicatedAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:2167:6: ( ( rule__PredicatedGroup__FirstSetPredicatedAssignment_0_1 ) )
                    {
                    // InternalXtext.g:2167:6: ( ( rule__PredicatedGroup__FirstSetPredicatedAssignment_0_1 ) )
                    // InternalXtext.g:2168:1: ( rule__PredicatedGroup__FirstSetPredicatedAssignment_0_1 )
                    {
                     before(grammarAccess.getPredicatedGroupAccess().getFirstSetPredicatedAssignment_0_1()); 
                    // InternalXtext.g:2169:1: ( rule__PredicatedGroup__FirstSetPredicatedAssignment_0_1 )
                    // InternalXtext.g:2169:2: rule__PredicatedGroup__FirstSetPredicatedAssignment_0_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__PredicatedGroup__FirstSetPredicatedAssignment_0_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getPredicatedGroupAccess().getFirstSetPredicatedAssignment_0_1()); 

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
    // $ANTLR end "rule__PredicatedGroup__Alternatives_0"


    // $ANTLR start "rule__TerminalRule__Alternatives_1"
    // InternalXtext.g:2178:1: rule__TerminalRule__Alternatives_1 : ( ( ( rule__TerminalRule__Group_1_0__0 ) ) | ( ( rule__TerminalRule__Group_1_1__0 ) ) );
    public final void rule__TerminalRule__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2182:1: ( ( ( rule__TerminalRule__Group_1_0__0 ) ) | ( ( rule__TerminalRule__Group_1_1__0 ) ) )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==48) ) {
                alt23=1;
            }
            else if ( (LA23_0==RULE_ID||(LA23_0>=16 && LA23_0<=17)) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // InternalXtext.g:2183:1: ( ( rule__TerminalRule__Group_1_0__0 ) )
                    {
                    // InternalXtext.g:2183:1: ( ( rule__TerminalRule__Group_1_0__0 ) )
                    // InternalXtext.g:2184:1: ( rule__TerminalRule__Group_1_0__0 )
                    {
                     before(grammarAccess.getTerminalRuleAccess().getGroup_1_0()); 
                    // InternalXtext.g:2185:1: ( rule__TerminalRule__Group_1_0__0 )
                    // InternalXtext.g:2185:2: rule__TerminalRule__Group_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__TerminalRule__Group_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTerminalRuleAccess().getGroup_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:2189:6: ( ( rule__TerminalRule__Group_1_1__0 ) )
                    {
                    // InternalXtext.g:2189:6: ( ( rule__TerminalRule__Group_1_1__0 ) )
                    // InternalXtext.g:2190:1: ( rule__TerminalRule__Group_1_1__0 )
                    {
                     before(grammarAccess.getTerminalRuleAccess().getGroup_1_1()); 
                    // InternalXtext.g:2191:1: ( rule__TerminalRule__Group_1_1__0 )
                    // InternalXtext.g:2191:2: rule__TerminalRule__Group_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:2200:1: rule__TerminalToken__CardinalityAlternatives_1_0 : ( ( '?' ) | ( '*' ) | ( '+' ) );
    public final void rule__TerminalToken__CardinalityAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2204:1: ( ( '?' ) | ( '*' ) | ( '+' ) )
            int alt24=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt24=1;
                }
                break;
            case 12:
                {
                alt24=2;
                }
                break;
            case 13:
                {
                alt24=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // InternalXtext.g:2205:1: ( '?' )
                    {
                    // InternalXtext.g:2205:1: ( '?' )
                    // InternalXtext.g:2206:1: '?'
                    {
                     before(grammarAccess.getTerminalTokenAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getTerminalTokenAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:2213:6: ( '*' )
                    {
                    // InternalXtext.g:2213:6: ( '*' )
                    // InternalXtext.g:2214:1: '*'
                    {
                     before(grammarAccess.getTerminalTokenAccess().getCardinalityAsteriskKeyword_1_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getTerminalTokenAccess().getCardinalityAsteriskKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtext.g:2221:6: ( '+' )
                    {
                    // InternalXtext.g:2221:6: ( '+' )
                    // InternalXtext.g:2222:1: '+'
                    {
                     before(grammarAccess.getTerminalTokenAccess().getCardinalityPlusSignKeyword_1_0_2()); 
                    match(input,13,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:2234:1: rule__TerminalTokenElement__Alternatives : ( ( ruleCharacterRange ) | ( ruleTerminalRuleCall ) | ( ruleParenthesizedTerminalElement ) | ( ruleAbstractNegatedToken ) | ( ruleWildcard ) | ( ruleEOF ) );
    public final void rule__TerminalTokenElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2238:1: ( ( ruleCharacterRange ) | ( ruleTerminalRuleCall ) | ( ruleParenthesizedTerminalElement ) | ( ruleAbstractNegatedToken ) | ( ruleWildcard ) | ( ruleEOF ) )
            int alt25=6;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt25=1;
                }
                break;
            case RULE_ID:
            case 16:
            case 17:
                {
                alt25=2;
                }
                break;
            case 22:
                {
                alt25=3;
                }
                break;
            case 39:
            case 43:
                {
                alt25=4;
                }
                break;
            case 24:
                {
                alt25=5;
                }
                break;
            case 44:
                {
                alt25=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // InternalXtext.g:2239:1: ( ruleCharacterRange )
                    {
                    // InternalXtext.g:2239:1: ( ruleCharacterRange )
                    // InternalXtext.g:2240:1: ruleCharacterRange
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getCharacterRangeParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleCharacterRange();

                    state._fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getCharacterRangeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:2245:6: ( ruleTerminalRuleCall )
                    {
                    // InternalXtext.g:2245:6: ( ruleTerminalRuleCall )
                    // InternalXtext.g:2246:1: ruleTerminalRuleCall
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getTerminalRuleCallParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleTerminalRuleCall();

                    state._fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getTerminalRuleCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtext.g:2251:6: ( ruleParenthesizedTerminalElement )
                    {
                    // InternalXtext.g:2251:6: ( ruleParenthesizedTerminalElement )
                    // InternalXtext.g:2252:1: ruleParenthesizedTerminalElement
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getParenthesizedTerminalElementParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleParenthesizedTerminalElement();

                    state._fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getParenthesizedTerminalElementParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalXtext.g:2257:6: ( ruleAbstractNegatedToken )
                    {
                    // InternalXtext.g:2257:6: ( ruleAbstractNegatedToken )
                    // InternalXtext.g:2258:1: ruleAbstractNegatedToken
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getAbstractNegatedTokenParserRuleCall_3()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAbstractNegatedToken();

                    state._fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getAbstractNegatedTokenParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalXtext.g:2263:6: ( ruleWildcard )
                    {
                    // InternalXtext.g:2263:6: ( ruleWildcard )
                    // InternalXtext.g:2264:1: ruleWildcard
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getWildcardParserRuleCall_4()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleWildcard();

                    state._fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getWildcardParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalXtext.g:2269:6: ( ruleEOF )
                    {
                    // InternalXtext.g:2269:6: ( ruleEOF )
                    // InternalXtext.g:2270:1: ruleEOF
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getEOFParserRuleCall_5()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleEOF();

                    state._fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getEOFParserRuleCall_5()); 

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
    // InternalXtext.g:2280:1: rule__AbstractNegatedToken__Alternatives : ( ( ruleNegatedToken ) | ( ruleUntilToken ) );
    public final void rule__AbstractNegatedToken__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2284:1: ( ( ruleNegatedToken ) | ( ruleUntilToken ) )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==39) ) {
                alt26=1;
            }
            else if ( (LA26_0==43) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // InternalXtext.g:2285:1: ( ruleNegatedToken )
                    {
                    // InternalXtext.g:2285:1: ( ruleNegatedToken )
                    // InternalXtext.g:2286:1: ruleNegatedToken
                    {
                     before(grammarAccess.getAbstractNegatedTokenAccess().getNegatedTokenParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleNegatedToken();

                    state._fsp--;

                     after(grammarAccess.getAbstractNegatedTokenAccess().getNegatedTokenParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:2291:6: ( ruleUntilToken )
                    {
                    // InternalXtext.g:2291:6: ( ruleUntilToken )
                    // InternalXtext.g:2292:1: ruleUntilToken
                    {
                     before(grammarAccess.getAbstractNegatedTokenAccess().getUntilTokenParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:2304:1: rule__Grammar__Group__0 : rule__Grammar__Group__0__Impl rule__Grammar__Group__1 ;
    public final void rule__Grammar__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2308:1: ( rule__Grammar__Group__0__Impl rule__Grammar__Group__1 )
            // InternalXtext.g:2309:2: rule__Grammar__Group__0__Impl rule__Grammar__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Grammar__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:2316:1: rule__Grammar__Group__0__Impl : ( 'grammar' ) ;
    public final void rule__Grammar__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2320:1: ( ( 'grammar' ) )
            // InternalXtext.g:2321:1: ( 'grammar' )
            {
            // InternalXtext.g:2321:1: ( 'grammar' )
            // InternalXtext.g:2322:1: 'grammar'
            {
             before(grammarAccess.getGrammarAccess().getGrammarKeyword_0()); 
            match(input,19,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:2335:1: rule__Grammar__Group__1 : rule__Grammar__Group__1__Impl rule__Grammar__Group__2 ;
    public final void rule__Grammar__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2339:1: ( rule__Grammar__Group__1__Impl rule__Grammar__Group__2 )
            // InternalXtext.g:2340:2: rule__Grammar__Group__1__Impl rule__Grammar__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Grammar__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:2347:1: rule__Grammar__Group__1__Impl : ( ( rule__Grammar__NameAssignment_1 ) ) ;
    public final void rule__Grammar__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2351:1: ( ( ( rule__Grammar__NameAssignment_1 ) ) )
            // InternalXtext.g:2352:1: ( ( rule__Grammar__NameAssignment_1 ) )
            {
            // InternalXtext.g:2352:1: ( ( rule__Grammar__NameAssignment_1 ) )
            // InternalXtext.g:2353:1: ( rule__Grammar__NameAssignment_1 )
            {
             before(grammarAccess.getGrammarAccess().getNameAssignment_1()); 
            // InternalXtext.g:2354:1: ( rule__Grammar__NameAssignment_1 )
            // InternalXtext.g:2354:2: rule__Grammar__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:2364:1: rule__Grammar__Group__2 : rule__Grammar__Group__2__Impl rule__Grammar__Group__3 ;
    public final void rule__Grammar__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2368:1: ( rule__Grammar__Group__2__Impl rule__Grammar__Group__3 )
            // InternalXtext.g:2369:2: rule__Grammar__Group__2__Impl rule__Grammar__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Grammar__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:2376:1: rule__Grammar__Group__2__Impl : ( ( rule__Grammar__Group_2__0 )? ) ;
    public final void rule__Grammar__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2380:1: ( ( ( rule__Grammar__Group_2__0 )? ) )
            // InternalXtext.g:2381:1: ( ( rule__Grammar__Group_2__0 )? )
            {
            // InternalXtext.g:2381:1: ( ( rule__Grammar__Group_2__0 )? )
            // InternalXtext.g:2382:1: ( rule__Grammar__Group_2__0 )?
            {
             before(grammarAccess.getGrammarAccess().getGroup_2()); 
            // InternalXtext.g:2383:1: ( rule__Grammar__Group_2__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==20) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalXtext.g:2383:2: rule__Grammar__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:2393:1: rule__Grammar__Group__3 : rule__Grammar__Group__3__Impl rule__Grammar__Group__4 ;
    public final void rule__Grammar__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2397:1: ( rule__Grammar__Group__3__Impl rule__Grammar__Group__4 )
            // InternalXtext.g:2398:2: rule__Grammar__Group__3__Impl rule__Grammar__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Grammar__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:2405:1: rule__Grammar__Group__3__Impl : ( ( rule__Grammar__Group_3__0 )? ) ;
    public final void rule__Grammar__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2409:1: ( ( ( rule__Grammar__Group_3__0 )? ) )
            // InternalXtext.g:2410:1: ( ( rule__Grammar__Group_3__0 )? )
            {
            // InternalXtext.g:2410:1: ( ( rule__Grammar__Group_3__0 )? )
            // InternalXtext.g:2411:1: ( rule__Grammar__Group_3__0 )?
            {
             before(grammarAccess.getGrammarAccess().getGroup_3()); 
            // InternalXtext.g:2412:1: ( rule__Grammar__Group_3__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==47) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalXtext.g:2412:2: rule__Grammar__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:2422:1: rule__Grammar__Group__4 : rule__Grammar__Group__4__Impl rule__Grammar__Group__5 ;
    public final void rule__Grammar__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2426:1: ( rule__Grammar__Group__4__Impl rule__Grammar__Group__5 )
            // InternalXtext.g:2427:2: rule__Grammar__Group__4__Impl rule__Grammar__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Grammar__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:2434:1: rule__Grammar__Group__4__Impl : ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* ) ;
    public final void rule__Grammar__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2438:1: ( ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* ) )
            // InternalXtext.g:2439:1: ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* )
            {
            // InternalXtext.g:2439:1: ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* )
            // InternalXtext.g:2440:1: ( rule__Grammar__MetamodelDeclarationsAssignment_4 )*
            {
             before(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAssignment_4()); 
            // InternalXtext.g:2441:1: ( rule__Grammar__MetamodelDeclarationsAssignment_4 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==25||LA29_0==27) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalXtext.g:2441:2: rule__Grammar__MetamodelDeclarationsAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    rule__Grammar__MetamodelDeclarationsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
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
    // InternalXtext.g:2451:1: rule__Grammar__Group__5 : rule__Grammar__Group__5__Impl ;
    public final void rule__Grammar__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2455:1: ( rule__Grammar__Group__5__Impl )
            // InternalXtext.g:2456:2: rule__Grammar__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:2462:1: rule__Grammar__Group__5__Impl : ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) ) ;
    public final void rule__Grammar__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2466:1: ( ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) ) )
            // InternalXtext.g:2467:1: ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) )
            {
            // InternalXtext.g:2467:1: ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) )
            // InternalXtext.g:2468:1: ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* )
            {
            // InternalXtext.g:2468:1: ( ( rule__Grammar__RulesAssignment_5 ) )
            // InternalXtext.g:2469:1: ( rule__Grammar__RulesAssignment_5 )
            {
             before(grammarAccess.getGrammarAccess().getRulesAssignment_5()); 
            // InternalXtext.g:2470:1: ( rule__Grammar__RulesAssignment_5 )
            // InternalXtext.g:2470:2: rule__Grammar__RulesAssignment_5
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Grammar__RulesAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getGrammarAccess().getRulesAssignment_5()); 

            }

            // InternalXtext.g:2473:1: ( ( rule__Grammar__RulesAssignment_5 )* )
            // InternalXtext.g:2474:1: ( rule__Grammar__RulesAssignment_5 )*
            {
             before(grammarAccess.getGrammarAccess().getRulesAssignment_5()); 
            // InternalXtext.g:2475:1: ( rule__Grammar__RulesAssignment_5 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_ID||(LA30_0>=16 && LA30_0<=17)||LA30_0==42||LA30_0==46||LA30_0==48) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalXtext.g:2475:2: rule__Grammar__RulesAssignment_5
            	    {
            	    pushFollow(FollowSets000.FOLLOW_6);
            	    rule__Grammar__RulesAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
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
    // InternalXtext.g:2498:1: rule__Grammar__Group_2__0 : rule__Grammar__Group_2__0__Impl rule__Grammar__Group_2__1 ;
    public final void rule__Grammar__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2502:1: ( rule__Grammar__Group_2__0__Impl rule__Grammar__Group_2__1 )
            // InternalXtext.g:2503:2: rule__Grammar__Group_2__0__Impl rule__Grammar__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Grammar__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:2510:1: rule__Grammar__Group_2__0__Impl : ( 'with' ) ;
    public final void rule__Grammar__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2514:1: ( ( 'with' ) )
            // InternalXtext.g:2515:1: ( 'with' )
            {
            // InternalXtext.g:2515:1: ( 'with' )
            // InternalXtext.g:2516:1: 'with'
            {
             before(grammarAccess.getGrammarAccess().getWithKeyword_2_0()); 
            match(input,20,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:2529:1: rule__Grammar__Group_2__1 : rule__Grammar__Group_2__1__Impl rule__Grammar__Group_2__2 ;
    public final void rule__Grammar__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2533:1: ( rule__Grammar__Group_2__1__Impl rule__Grammar__Group_2__2 )
            // InternalXtext.g:2534:2: rule__Grammar__Group_2__1__Impl rule__Grammar__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Grammar__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:2541:1: rule__Grammar__Group_2__1__Impl : ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) ) ;
    public final void rule__Grammar__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2545:1: ( ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) ) )
            // InternalXtext.g:2546:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) )
            {
            // InternalXtext.g:2546:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) )
            // InternalXtext.g:2547:1: ( rule__Grammar__UsedGrammarsAssignment_2_1 )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_1()); 
            // InternalXtext.g:2548:1: ( rule__Grammar__UsedGrammarsAssignment_2_1 )
            // InternalXtext.g:2548:2: rule__Grammar__UsedGrammarsAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:2558:1: rule__Grammar__Group_2__2 : rule__Grammar__Group_2__2__Impl ;
    public final void rule__Grammar__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2562:1: ( rule__Grammar__Group_2__2__Impl )
            // InternalXtext.g:2563:2: rule__Grammar__Group_2__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:2569:1: rule__Grammar__Group_2__2__Impl : ( ( rule__Grammar__Group_2_2__0 )* ) ;
    public final void rule__Grammar__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2573:1: ( ( ( rule__Grammar__Group_2_2__0 )* ) )
            // InternalXtext.g:2574:1: ( ( rule__Grammar__Group_2_2__0 )* )
            {
            // InternalXtext.g:2574:1: ( ( rule__Grammar__Group_2_2__0 )* )
            // InternalXtext.g:2575:1: ( rule__Grammar__Group_2_2__0 )*
            {
             before(grammarAccess.getGrammarAccess().getGroup_2_2()); 
            // InternalXtext.g:2576:1: ( rule__Grammar__Group_2_2__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==21) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalXtext.g:2576:2: rule__Grammar__Group_2_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    rule__Grammar__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
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
    // InternalXtext.g:2592:1: rule__Grammar__Group_2_2__0 : rule__Grammar__Group_2_2__0__Impl rule__Grammar__Group_2_2__1 ;
    public final void rule__Grammar__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2596:1: ( rule__Grammar__Group_2_2__0__Impl rule__Grammar__Group_2_2__1 )
            // InternalXtext.g:2597:2: rule__Grammar__Group_2_2__0__Impl rule__Grammar__Group_2_2__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Grammar__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:2604:1: rule__Grammar__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__Grammar__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2608:1: ( ( ',' ) )
            // InternalXtext.g:2609:1: ( ',' )
            {
            // InternalXtext.g:2609:1: ( ',' )
            // InternalXtext.g:2610:1: ','
            {
             before(grammarAccess.getGrammarAccess().getCommaKeyword_2_2_0()); 
            match(input,21,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:2623:1: rule__Grammar__Group_2_2__1 : rule__Grammar__Group_2_2__1__Impl ;
    public final void rule__Grammar__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2627:1: ( rule__Grammar__Group_2_2__1__Impl )
            // InternalXtext.g:2628:2: rule__Grammar__Group_2_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:2634:1: rule__Grammar__Group_2_2__1__Impl : ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) ) ;
    public final void rule__Grammar__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2638:1: ( ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) ) )
            // InternalXtext.g:2639:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) )
            {
            // InternalXtext.g:2639:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) )
            // InternalXtext.g:2640:1: ( rule__Grammar__UsedGrammarsAssignment_2_2_1 )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_2_1()); 
            // InternalXtext.g:2641:1: ( rule__Grammar__UsedGrammarsAssignment_2_2_1 )
            // InternalXtext.g:2641:2: rule__Grammar__UsedGrammarsAssignment_2_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:2655:1: rule__Grammar__Group_3__0 : rule__Grammar__Group_3__0__Impl rule__Grammar__Group_3__1 ;
    public final void rule__Grammar__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2659:1: ( rule__Grammar__Group_3__0__Impl rule__Grammar__Group_3__1 )
            // InternalXtext.g:2660:2: rule__Grammar__Group_3__0__Impl rule__Grammar__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__Grammar__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:2667:1: rule__Grammar__Group_3__0__Impl : ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) ) ;
    public final void rule__Grammar__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2671:1: ( ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) ) )
            // InternalXtext.g:2672:1: ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) )
            {
            // InternalXtext.g:2672:1: ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) )
            // InternalXtext.g:2673:1: ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 )
            {
             before(grammarAccess.getGrammarAccess().getDefinesHiddenTokensAssignment_3_0()); 
            // InternalXtext.g:2674:1: ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 )
            // InternalXtext.g:2674:2: rule__Grammar__DefinesHiddenTokensAssignment_3_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:2684:1: rule__Grammar__Group_3__1 : rule__Grammar__Group_3__1__Impl rule__Grammar__Group_3__2 ;
    public final void rule__Grammar__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2688:1: ( rule__Grammar__Group_3__1__Impl rule__Grammar__Group_3__2 )
            // InternalXtext.g:2689:2: rule__Grammar__Group_3__1__Impl rule__Grammar__Group_3__2
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Grammar__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:2696:1: rule__Grammar__Group_3__1__Impl : ( '(' ) ;
    public final void rule__Grammar__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2700:1: ( ( '(' ) )
            // InternalXtext.g:2701:1: ( '(' )
            {
            // InternalXtext.g:2701:1: ( '(' )
            // InternalXtext.g:2702:1: '('
            {
             before(grammarAccess.getGrammarAccess().getLeftParenthesisKeyword_3_1()); 
            match(input,22,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:2715:1: rule__Grammar__Group_3__2 : rule__Grammar__Group_3__2__Impl rule__Grammar__Group_3__3 ;
    public final void rule__Grammar__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2719:1: ( rule__Grammar__Group_3__2__Impl rule__Grammar__Group_3__3 )
            // InternalXtext.g:2720:2: rule__Grammar__Group_3__2__Impl rule__Grammar__Group_3__3
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Grammar__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:2727:1: rule__Grammar__Group_3__2__Impl : ( ( rule__Grammar__Group_3_2__0 )? ) ;
    public final void rule__Grammar__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2731:1: ( ( ( rule__Grammar__Group_3_2__0 )? ) )
            // InternalXtext.g:2732:1: ( ( rule__Grammar__Group_3_2__0 )? )
            {
            // InternalXtext.g:2732:1: ( ( rule__Grammar__Group_3_2__0 )? )
            // InternalXtext.g:2733:1: ( rule__Grammar__Group_3_2__0 )?
            {
             before(grammarAccess.getGrammarAccess().getGroup_3_2()); 
            // InternalXtext.g:2734:1: ( rule__Grammar__Group_3_2__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_ID||(LA32_0>=16 && LA32_0<=17)) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalXtext.g:2734:2: rule__Grammar__Group_3_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:2744:1: rule__Grammar__Group_3__3 : rule__Grammar__Group_3__3__Impl ;
    public final void rule__Grammar__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2748:1: ( rule__Grammar__Group_3__3__Impl )
            // InternalXtext.g:2749:2: rule__Grammar__Group_3__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:2755:1: rule__Grammar__Group_3__3__Impl : ( ')' ) ;
    public final void rule__Grammar__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2759:1: ( ( ')' ) )
            // InternalXtext.g:2760:1: ( ')' )
            {
            // InternalXtext.g:2760:1: ( ')' )
            // InternalXtext.g:2761:1: ')'
            {
             before(grammarAccess.getGrammarAccess().getRightParenthesisKeyword_3_3()); 
            match(input,23,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:2782:1: rule__Grammar__Group_3_2__0 : rule__Grammar__Group_3_2__0__Impl rule__Grammar__Group_3_2__1 ;
    public final void rule__Grammar__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2786:1: ( rule__Grammar__Group_3_2__0__Impl rule__Grammar__Group_3_2__1 )
            // InternalXtext.g:2787:2: rule__Grammar__Group_3_2__0__Impl rule__Grammar__Group_3_2__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Grammar__Group_3_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:2794:1: rule__Grammar__Group_3_2__0__Impl : ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) ) ;
    public final void rule__Grammar__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2798:1: ( ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) ) )
            // InternalXtext.g:2799:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) )
            {
            // InternalXtext.g:2799:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) )
            // InternalXtext.g:2800:1: ( rule__Grammar__HiddenTokensAssignment_3_2_0 )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAssignment_3_2_0()); 
            // InternalXtext.g:2801:1: ( rule__Grammar__HiddenTokensAssignment_3_2_0 )
            // InternalXtext.g:2801:2: rule__Grammar__HiddenTokensAssignment_3_2_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:2811:1: rule__Grammar__Group_3_2__1 : rule__Grammar__Group_3_2__1__Impl ;
    public final void rule__Grammar__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2815:1: ( rule__Grammar__Group_3_2__1__Impl )
            // InternalXtext.g:2816:2: rule__Grammar__Group_3_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:2822:1: rule__Grammar__Group_3_2__1__Impl : ( ( rule__Grammar__Group_3_2_1__0 )* ) ;
    public final void rule__Grammar__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2826:1: ( ( ( rule__Grammar__Group_3_2_1__0 )* ) )
            // InternalXtext.g:2827:1: ( ( rule__Grammar__Group_3_2_1__0 )* )
            {
            // InternalXtext.g:2827:1: ( ( rule__Grammar__Group_3_2_1__0 )* )
            // InternalXtext.g:2828:1: ( rule__Grammar__Group_3_2_1__0 )*
            {
             before(grammarAccess.getGrammarAccess().getGroup_3_2_1()); 
            // InternalXtext.g:2829:1: ( rule__Grammar__Group_3_2_1__0 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==21) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalXtext.g:2829:2: rule__Grammar__Group_3_2_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    rule__Grammar__Group_3_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop33;
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
    // InternalXtext.g:2843:1: rule__Grammar__Group_3_2_1__0 : rule__Grammar__Group_3_2_1__0__Impl rule__Grammar__Group_3_2_1__1 ;
    public final void rule__Grammar__Group_3_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2847:1: ( rule__Grammar__Group_3_2_1__0__Impl rule__Grammar__Group_3_2_1__1 )
            // InternalXtext.g:2848:2: rule__Grammar__Group_3_2_1__0__Impl rule__Grammar__Group_3_2_1__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Grammar__Group_3_2_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:2855:1: rule__Grammar__Group_3_2_1__0__Impl : ( ',' ) ;
    public final void rule__Grammar__Group_3_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2859:1: ( ( ',' ) )
            // InternalXtext.g:2860:1: ( ',' )
            {
            // InternalXtext.g:2860:1: ( ',' )
            // InternalXtext.g:2861:1: ','
            {
             before(grammarAccess.getGrammarAccess().getCommaKeyword_3_2_1_0()); 
            match(input,21,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:2874:1: rule__Grammar__Group_3_2_1__1 : rule__Grammar__Group_3_2_1__1__Impl ;
    public final void rule__Grammar__Group_3_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2878:1: ( rule__Grammar__Group_3_2_1__1__Impl )
            // InternalXtext.g:2879:2: rule__Grammar__Group_3_2_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:2885:1: rule__Grammar__Group_3_2_1__1__Impl : ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) ) ;
    public final void rule__Grammar__Group_3_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2889:1: ( ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) ) )
            // InternalXtext.g:2890:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) )
            {
            // InternalXtext.g:2890:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) )
            // InternalXtext.g:2891:1: ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAssignment_3_2_1_1()); 
            // InternalXtext.g:2892:1: ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 )
            // InternalXtext.g:2892:2: rule__Grammar__HiddenTokensAssignment_3_2_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:2906:1: rule__GrammarID__Group__0 : rule__GrammarID__Group__0__Impl rule__GrammarID__Group__1 ;
    public final void rule__GrammarID__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2910:1: ( rule__GrammarID__Group__0__Impl rule__GrammarID__Group__1 )
            // InternalXtext.g:2911:2: rule__GrammarID__Group__0__Impl rule__GrammarID__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__GrammarID__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:2918:1: rule__GrammarID__Group__0__Impl : ( ruleValidID ) ;
    public final void rule__GrammarID__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2922:1: ( ( ruleValidID ) )
            // InternalXtext.g:2923:1: ( ruleValidID )
            {
            // InternalXtext.g:2923:1: ( ruleValidID )
            // InternalXtext.g:2924:1: ruleValidID
            {
             before(grammarAccess.getGrammarIDAccess().getValidIDParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getGrammarIDAccess().getValidIDParserRuleCall_0()); 

            }


            }

        }
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
    // InternalXtext.g:2935:1: rule__GrammarID__Group__1 : rule__GrammarID__Group__1__Impl ;
    public final void rule__GrammarID__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2939:1: ( rule__GrammarID__Group__1__Impl )
            // InternalXtext.g:2940:2: rule__GrammarID__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:2946:1: rule__GrammarID__Group__1__Impl : ( ( rule__GrammarID__Group_1__0 )* ) ;
    public final void rule__GrammarID__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2950:1: ( ( ( rule__GrammarID__Group_1__0 )* ) )
            // InternalXtext.g:2951:1: ( ( rule__GrammarID__Group_1__0 )* )
            {
            // InternalXtext.g:2951:1: ( ( rule__GrammarID__Group_1__0 )* )
            // InternalXtext.g:2952:1: ( rule__GrammarID__Group_1__0 )*
            {
             before(grammarAccess.getGrammarIDAccess().getGroup_1()); 
            // InternalXtext.g:2953:1: ( rule__GrammarID__Group_1__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==24) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalXtext.g:2953:2: rule__GrammarID__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_12);
            	    rule__GrammarID__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop34;
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
    // InternalXtext.g:2967:1: rule__GrammarID__Group_1__0 : rule__GrammarID__Group_1__0__Impl rule__GrammarID__Group_1__1 ;
    public final void rule__GrammarID__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2971:1: ( rule__GrammarID__Group_1__0__Impl rule__GrammarID__Group_1__1 )
            // InternalXtext.g:2972:2: rule__GrammarID__Group_1__0__Impl rule__GrammarID__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__GrammarID__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:2979:1: rule__GrammarID__Group_1__0__Impl : ( '.' ) ;
    public final void rule__GrammarID__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:2983:1: ( ( '.' ) )
            // InternalXtext.g:2984:1: ( '.' )
            {
            // InternalXtext.g:2984:1: ( '.' )
            // InternalXtext.g:2985:1: '.'
            {
             before(grammarAccess.getGrammarIDAccess().getFullStopKeyword_1_0()); 
            match(input,24,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:2998:1: rule__GrammarID__Group_1__1 : rule__GrammarID__Group_1__1__Impl ;
    public final void rule__GrammarID__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3002:1: ( rule__GrammarID__Group_1__1__Impl )
            // InternalXtext.g:3003:2: rule__GrammarID__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3009:1: rule__GrammarID__Group_1__1__Impl : ( ruleValidID ) ;
    public final void rule__GrammarID__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3013:1: ( ( ruleValidID ) )
            // InternalXtext.g:3014:1: ( ruleValidID )
            {
            // InternalXtext.g:3014:1: ( ruleValidID )
            // InternalXtext.g:3015:1: ruleValidID
            {
             before(grammarAccess.getGrammarIDAccess().getValidIDParserRuleCall_1_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getGrammarIDAccess().getValidIDParserRuleCall_1_1()); 

            }


            }

        }
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
    // InternalXtext.g:3030:1: rule__GeneratedMetamodel__Group__0 : rule__GeneratedMetamodel__Group__0__Impl rule__GeneratedMetamodel__Group__1 ;
    public final void rule__GeneratedMetamodel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3034:1: ( rule__GeneratedMetamodel__Group__0__Impl rule__GeneratedMetamodel__Group__1 )
            // InternalXtext.g:3035:2: rule__GeneratedMetamodel__Group__0__Impl rule__GeneratedMetamodel__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__GeneratedMetamodel__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3042:1: rule__GeneratedMetamodel__Group__0__Impl : ( 'generate' ) ;
    public final void rule__GeneratedMetamodel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3046:1: ( ( 'generate' ) )
            // InternalXtext.g:3047:1: ( 'generate' )
            {
            // InternalXtext.g:3047:1: ( 'generate' )
            // InternalXtext.g:3048:1: 'generate'
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getGenerateKeyword_0()); 
            match(input,25,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:3061:1: rule__GeneratedMetamodel__Group__1 : rule__GeneratedMetamodel__Group__1__Impl rule__GeneratedMetamodel__Group__2 ;
    public final void rule__GeneratedMetamodel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3065:1: ( rule__GeneratedMetamodel__Group__1__Impl rule__GeneratedMetamodel__Group__2 )
            // InternalXtext.g:3066:2: rule__GeneratedMetamodel__Group__1__Impl rule__GeneratedMetamodel__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__GeneratedMetamodel__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3073:1: rule__GeneratedMetamodel__Group__1__Impl : ( ( rule__GeneratedMetamodel__NameAssignment_1 ) ) ;
    public final void rule__GeneratedMetamodel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3077:1: ( ( ( rule__GeneratedMetamodel__NameAssignment_1 ) ) )
            // InternalXtext.g:3078:1: ( ( rule__GeneratedMetamodel__NameAssignment_1 ) )
            {
            // InternalXtext.g:3078:1: ( ( rule__GeneratedMetamodel__NameAssignment_1 ) )
            // InternalXtext.g:3079:1: ( rule__GeneratedMetamodel__NameAssignment_1 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getNameAssignment_1()); 
            // InternalXtext.g:3080:1: ( rule__GeneratedMetamodel__NameAssignment_1 )
            // InternalXtext.g:3080:2: rule__GeneratedMetamodel__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3090:1: rule__GeneratedMetamodel__Group__2 : rule__GeneratedMetamodel__Group__2__Impl rule__GeneratedMetamodel__Group__3 ;
    public final void rule__GeneratedMetamodel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3094:1: ( rule__GeneratedMetamodel__Group__2__Impl rule__GeneratedMetamodel__Group__3 )
            // InternalXtext.g:3095:2: rule__GeneratedMetamodel__Group__2__Impl rule__GeneratedMetamodel__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_14);
            rule__GeneratedMetamodel__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3102:1: rule__GeneratedMetamodel__Group__2__Impl : ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) ) ;
    public final void rule__GeneratedMetamodel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3106:1: ( ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) ) )
            // InternalXtext.g:3107:1: ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) )
            {
            // InternalXtext.g:3107:1: ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) )
            // InternalXtext.g:3108:1: ( rule__GeneratedMetamodel__EPackageAssignment_2 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getEPackageAssignment_2()); 
            // InternalXtext.g:3109:1: ( rule__GeneratedMetamodel__EPackageAssignment_2 )
            // InternalXtext.g:3109:2: rule__GeneratedMetamodel__EPackageAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3119:1: rule__GeneratedMetamodel__Group__3 : rule__GeneratedMetamodel__Group__3__Impl ;
    public final void rule__GeneratedMetamodel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3123:1: ( rule__GeneratedMetamodel__Group__3__Impl )
            // InternalXtext.g:3124:2: rule__GeneratedMetamodel__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3130:1: rule__GeneratedMetamodel__Group__3__Impl : ( ( rule__GeneratedMetamodel__Group_3__0 )? ) ;
    public final void rule__GeneratedMetamodel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3134:1: ( ( ( rule__GeneratedMetamodel__Group_3__0 )? ) )
            // InternalXtext.g:3135:1: ( ( rule__GeneratedMetamodel__Group_3__0 )? )
            {
            // InternalXtext.g:3135:1: ( ( rule__GeneratedMetamodel__Group_3__0 )? )
            // InternalXtext.g:3136:1: ( rule__GeneratedMetamodel__Group_3__0 )?
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getGroup_3()); 
            // InternalXtext.g:3137:1: ( rule__GeneratedMetamodel__Group_3__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==26) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalXtext.g:3137:2: rule__GeneratedMetamodel__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3155:1: rule__GeneratedMetamodel__Group_3__0 : rule__GeneratedMetamodel__Group_3__0__Impl rule__GeneratedMetamodel__Group_3__1 ;
    public final void rule__GeneratedMetamodel__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3159:1: ( rule__GeneratedMetamodel__Group_3__0__Impl rule__GeneratedMetamodel__Group_3__1 )
            // InternalXtext.g:3160:2: rule__GeneratedMetamodel__Group_3__0__Impl rule__GeneratedMetamodel__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__GeneratedMetamodel__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3167:1: rule__GeneratedMetamodel__Group_3__0__Impl : ( 'as' ) ;
    public final void rule__GeneratedMetamodel__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3171:1: ( ( 'as' ) )
            // InternalXtext.g:3172:1: ( 'as' )
            {
            // InternalXtext.g:3172:1: ( 'as' )
            // InternalXtext.g:3173:1: 'as'
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getAsKeyword_3_0()); 
            match(input,26,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:3186:1: rule__GeneratedMetamodel__Group_3__1 : rule__GeneratedMetamodel__Group_3__1__Impl ;
    public final void rule__GeneratedMetamodel__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3190:1: ( rule__GeneratedMetamodel__Group_3__1__Impl )
            // InternalXtext.g:3191:2: rule__GeneratedMetamodel__Group_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3197:1: rule__GeneratedMetamodel__Group_3__1__Impl : ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) ) ;
    public final void rule__GeneratedMetamodel__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3201:1: ( ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) ) )
            // InternalXtext.g:3202:1: ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) )
            {
            // InternalXtext.g:3202:1: ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) )
            // InternalXtext.g:3203:1: ( rule__GeneratedMetamodel__AliasAssignment_3_1 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getAliasAssignment_3_1()); 
            // InternalXtext.g:3204:1: ( rule__GeneratedMetamodel__AliasAssignment_3_1 )
            // InternalXtext.g:3204:2: rule__GeneratedMetamodel__AliasAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3218:1: rule__ReferencedMetamodel__Group__0 : rule__ReferencedMetamodel__Group__0__Impl rule__ReferencedMetamodel__Group__1 ;
    public final void rule__ReferencedMetamodel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3222:1: ( rule__ReferencedMetamodel__Group__0__Impl rule__ReferencedMetamodel__Group__1 )
            // InternalXtext.g:3223:2: rule__ReferencedMetamodel__Group__0__Impl rule__ReferencedMetamodel__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__ReferencedMetamodel__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3230:1: rule__ReferencedMetamodel__Group__0__Impl : ( 'import' ) ;
    public final void rule__ReferencedMetamodel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3234:1: ( ( 'import' ) )
            // InternalXtext.g:3235:1: ( 'import' )
            {
            // InternalXtext.g:3235:1: ( 'import' )
            // InternalXtext.g:3236:1: 'import'
            {
             before(grammarAccess.getReferencedMetamodelAccess().getImportKeyword_0()); 
            match(input,27,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:3249:1: rule__ReferencedMetamodel__Group__1 : rule__ReferencedMetamodel__Group__1__Impl rule__ReferencedMetamodel__Group__2 ;
    public final void rule__ReferencedMetamodel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3253:1: ( rule__ReferencedMetamodel__Group__1__Impl rule__ReferencedMetamodel__Group__2 )
            // InternalXtext.g:3254:2: rule__ReferencedMetamodel__Group__1__Impl rule__ReferencedMetamodel__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_14);
            rule__ReferencedMetamodel__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3261:1: rule__ReferencedMetamodel__Group__1__Impl : ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) ) ;
    public final void rule__ReferencedMetamodel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3265:1: ( ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) ) )
            // InternalXtext.g:3266:1: ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) )
            {
            // InternalXtext.g:3266:1: ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) )
            // InternalXtext.g:3267:1: ( rule__ReferencedMetamodel__EPackageAssignment_1 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageAssignment_1()); 
            // InternalXtext.g:3268:1: ( rule__ReferencedMetamodel__EPackageAssignment_1 )
            // InternalXtext.g:3268:2: rule__ReferencedMetamodel__EPackageAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3278:1: rule__ReferencedMetamodel__Group__2 : rule__ReferencedMetamodel__Group__2__Impl ;
    public final void rule__ReferencedMetamodel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3282:1: ( rule__ReferencedMetamodel__Group__2__Impl )
            // InternalXtext.g:3283:2: rule__ReferencedMetamodel__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3289:1: rule__ReferencedMetamodel__Group__2__Impl : ( ( rule__ReferencedMetamodel__Group_2__0 )? ) ;
    public final void rule__ReferencedMetamodel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3293:1: ( ( ( rule__ReferencedMetamodel__Group_2__0 )? ) )
            // InternalXtext.g:3294:1: ( ( rule__ReferencedMetamodel__Group_2__0 )? )
            {
            // InternalXtext.g:3294:1: ( ( rule__ReferencedMetamodel__Group_2__0 )? )
            // InternalXtext.g:3295:1: ( rule__ReferencedMetamodel__Group_2__0 )?
            {
             before(grammarAccess.getReferencedMetamodelAccess().getGroup_2()); 
            // InternalXtext.g:3296:1: ( rule__ReferencedMetamodel__Group_2__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==26) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalXtext.g:3296:2: rule__ReferencedMetamodel__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3312:1: rule__ReferencedMetamodel__Group_2__0 : rule__ReferencedMetamodel__Group_2__0__Impl rule__ReferencedMetamodel__Group_2__1 ;
    public final void rule__ReferencedMetamodel__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3316:1: ( rule__ReferencedMetamodel__Group_2__0__Impl rule__ReferencedMetamodel__Group_2__1 )
            // InternalXtext.g:3317:2: rule__ReferencedMetamodel__Group_2__0__Impl rule__ReferencedMetamodel__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__ReferencedMetamodel__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3324:1: rule__ReferencedMetamodel__Group_2__0__Impl : ( 'as' ) ;
    public final void rule__ReferencedMetamodel__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3328:1: ( ( 'as' ) )
            // InternalXtext.g:3329:1: ( 'as' )
            {
            // InternalXtext.g:3329:1: ( 'as' )
            // InternalXtext.g:3330:1: 'as'
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAsKeyword_2_0()); 
            match(input,26,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:3343:1: rule__ReferencedMetamodel__Group_2__1 : rule__ReferencedMetamodel__Group_2__1__Impl ;
    public final void rule__ReferencedMetamodel__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3347:1: ( rule__ReferencedMetamodel__Group_2__1__Impl )
            // InternalXtext.g:3348:2: rule__ReferencedMetamodel__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3354:1: rule__ReferencedMetamodel__Group_2__1__Impl : ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) ) ;
    public final void rule__ReferencedMetamodel__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3358:1: ( ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) ) )
            // InternalXtext.g:3359:1: ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) )
            {
            // InternalXtext.g:3359:1: ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) )
            // InternalXtext.g:3360:1: ( rule__ReferencedMetamodel__AliasAssignment_2_1 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAliasAssignment_2_1()); 
            // InternalXtext.g:3361:1: ( rule__ReferencedMetamodel__AliasAssignment_2_1 )
            // InternalXtext.g:3361:2: rule__ReferencedMetamodel__AliasAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3375:1: rule__ParserRule__Group__0 : rule__ParserRule__Group__0__Impl rule__ParserRule__Group__1 ;
    public final void rule__ParserRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3379:1: ( rule__ParserRule__Group__0__Impl rule__ParserRule__Group__1 )
            // InternalXtext.g:3380:2: rule__ParserRule__Group__0__Impl rule__ParserRule__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_15);
            rule__ParserRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3387:1: rule__ParserRule__Group__0__Impl : ( ( rule__ParserRule__Alternatives_0 ) ) ;
    public final void rule__ParserRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3391:1: ( ( ( rule__ParserRule__Alternatives_0 ) ) )
            // InternalXtext.g:3392:1: ( ( rule__ParserRule__Alternatives_0 ) )
            {
            // InternalXtext.g:3392:1: ( ( rule__ParserRule__Alternatives_0 ) )
            // InternalXtext.g:3393:1: ( rule__ParserRule__Alternatives_0 )
            {
             before(grammarAccess.getParserRuleAccess().getAlternatives_0()); 
            // InternalXtext.g:3394:1: ( rule__ParserRule__Alternatives_0 )
            // InternalXtext.g:3394:2: rule__ParserRule__Alternatives_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getAlternatives_0()); 

            }


            }

        }
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
    // InternalXtext.g:3404:1: rule__ParserRule__Group__1 : rule__ParserRule__Group__1__Impl rule__ParserRule__Group__2 ;
    public final void rule__ParserRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3408:1: ( rule__ParserRule__Group__1__Impl rule__ParserRule__Group__2 )
            // InternalXtext.g:3409:2: rule__ParserRule__Group__1__Impl rule__ParserRule__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_15);
            rule__ParserRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3416:1: rule__ParserRule__Group__1__Impl : ( ( rule__ParserRule__Group_1__0 )? ) ;
    public final void rule__ParserRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3420:1: ( ( ( rule__ParserRule__Group_1__0 )? ) )
            // InternalXtext.g:3421:1: ( ( rule__ParserRule__Group_1__0 )? )
            {
            // InternalXtext.g:3421:1: ( ( rule__ParserRule__Group_1__0 )? )
            // InternalXtext.g:3422:1: ( rule__ParserRule__Group_1__0 )?
            {
             before(grammarAccess.getParserRuleAccess().getGroup_1()); 
            // InternalXtext.g:3423:1: ( rule__ParserRule__Group_1__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==47) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalXtext.g:3423:2: rule__ParserRule__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3433:1: rule__ParserRule__Group__2 : rule__ParserRule__Group__2__Impl rule__ParserRule__Group__3 ;
    public final void rule__ParserRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3437:1: ( rule__ParserRule__Group__2__Impl rule__ParserRule__Group__3 )
            // InternalXtext.g:3438:2: rule__ParserRule__Group__2__Impl rule__ParserRule__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__ParserRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3445:1: rule__ParserRule__Group__2__Impl : ( ':' ) ;
    public final void rule__ParserRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3449:1: ( ( ':' ) )
            // InternalXtext.g:3450:1: ( ':' )
            {
            // InternalXtext.g:3450:1: ( ':' )
            // InternalXtext.g:3451:1: ':'
            {
             before(grammarAccess.getParserRuleAccess().getColonKeyword_2()); 
            match(input,28,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParserRuleAccess().getColonKeyword_2()); 

            }


            }

        }
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
    // InternalXtext.g:3464:1: rule__ParserRule__Group__3 : rule__ParserRule__Group__3__Impl rule__ParserRule__Group__4 ;
    public final void rule__ParserRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3468:1: ( rule__ParserRule__Group__3__Impl rule__ParserRule__Group__4 )
            // InternalXtext.g:3469:2: rule__ParserRule__Group__3__Impl rule__ParserRule__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_17);
            rule__ParserRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3476:1: rule__ParserRule__Group__3__Impl : ( ( rule__ParserRule__AlternativesAssignment_3 ) ) ;
    public final void rule__ParserRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3480:1: ( ( ( rule__ParserRule__AlternativesAssignment_3 ) ) )
            // InternalXtext.g:3481:1: ( ( rule__ParserRule__AlternativesAssignment_3 ) )
            {
            // InternalXtext.g:3481:1: ( ( rule__ParserRule__AlternativesAssignment_3 ) )
            // InternalXtext.g:3482:1: ( rule__ParserRule__AlternativesAssignment_3 )
            {
             before(grammarAccess.getParserRuleAccess().getAlternativesAssignment_3()); 
            // InternalXtext.g:3483:1: ( rule__ParserRule__AlternativesAssignment_3 )
            // InternalXtext.g:3483:2: rule__ParserRule__AlternativesAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__AlternativesAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getAlternativesAssignment_3()); 

            }


            }

        }
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
    // InternalXtext.g:3493:1: rule__ParserRule__Group__4 : rule__ParserRule__Group__4__Impl ;
    public final void rule__ParserRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3497:1: ( rule__ParserRule__Group__4__Impl )
            // InternalXtext.g:3498:2: rule__ParserRule__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group__4__Impl();

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
    // InternalXtext.g:3504:1: rule__ParserRule__Group__4__Impl : ( ';' ) ;
    public final void rule__ParserRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3508:1: ( ( ';' ) )
            // InternalXtext.g:3509:1: ( ';' )
            {
            // InternalXtext.g:3509:1: ( ';' )
            // InternalXtext.g:3510:1: ';'
            {
             before(grammarAccess.getParserRuleAccess().getSemicolonKeyword_4()); 
            match(input,29,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParserRuleAccess().getSemicolonKeyword_4()); 

            }


            }

        }
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


    // $ANTLR start "rule__ParserRule__Group_0_0__0"
    // InternalXtext.g:3533:1: rule__ParserRule__Group_0_0__0 : rule__ParserRule__Group_0_0__0__Impl rule__ParserRule__Group_0_0__1 ;
    public final void rule__ParserRule__Group_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3537:1: ( rule__ParserRule__Group_0_0__0__Impl rule__ParserRule__Group_0_0__1 )
            // InternalXtext.g:3538:2: rule__ParserRule__Group_0_0__0__Impl rule__ParserRule__Group_0_0__1
            {
            pushFollow(FollowSets000.FOLLOW_18);
            rule__ParserRule__Group_0_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_0_0__1();

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
    // $ANTLR end "rule__ParserRule__Group_0_0__0"


    // $ANTLR start "rule__ParserRule__Group_0_0__0__Impl"
    // InternalXtext.g:3545:1: rule__ParserRule__Group_0_0__0__Impl : ( ( rule__ParserRule__FragmentAssignment_0_0_0 ) ) ;
    public final void rule__ParserRule__Group_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3549:1: ( ( ( rule__ParserRule__FragmentAssignment_0_0_0 ) ) )
            // InternalXtext.g:3550:1: ( ( rule__ParserRule__FragmentAssignment_0_0_0 ) )
            {
            // InternalXtext.g:3550:1: ( ( rule__ParserRule__FragmentAssignment_0_0_0 ) )
            // InternalXtext.g:3551:1: ( rule__ParserRule__FragmentAssignment_0_0_0 )
            {
             before(grammarAccess.getParserRuleAccess().getFragmentAssignment_0_0_0()); 
            // InternalXtext.g:3552:1: ( rule__ParserRule__FragmentAssignment_0_0_0 )
            // InternalXtext.g:3552:2: rule__ParserRule__FragmentAssignment_0_0_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__FragmentAssignment_0_0_0();

            state._fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getFragmentAssignment_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_0_0__0__Impl"


    // $ANTLR start "rule__ParserRule__Group_0_0__1"
    // InternalXtext.g:3562:1: rule__ParserRule__Group_0_0__1 : rule__ParserRule__Group_0_0__1__Impl rule__ParserRule__Group_0_0__2 ;
    public final void rule__ParserRule__Group_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3566:1: ( rule__ParserRule__Group_0_0__1__Impl rule__ParserRule__Group_0_0__2 )
            // InternalXtext.g:3567:2: rule__ParserRule__Group_0_0__1__Impl rule__ParserRule__Group_0_0__2
            {
            pushFollow(FollowSets000.FOLLOW_19);
            rule__ParserRule__Group_0_0__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_0_0__2();

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
    // $ANTLR end "rule__ParserRule__Group_0_0__1"


    // $ANTLR start "rule__ParserRule__Group_0_0__1__Impl"
    // InternalXtext.g:3574:1: rule__ParserRule__Group_0_0__1__Impl : ( ruleRuleNameAndParams ) ;
    public final void rule__ParserRule__Group_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3578:1: ( ( ruleRuleNameAndParams ) )
            // InternalXtext.g:3579:1: ( ruleRuleNameAndParams )
            {
            // InternalXtext.g:3579:1: ( ruleRuleNameAndParams )
            // InternalXtext.g:3580:1: ruleRuleNameAndParams
            {
             before(grammarAccess.getParserRuleAccess().getRuleNameAndParamsParserRuleCall_0_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleRuleNameAndParams();

            state._fsp--;

             after(grammarAccess.getParserRuleAccess().getRuleNameAndParamsParserRuleCall_0_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_0_0__1__Impl"


    // $ANTLR start "rule__ParserRule__Group_0_0__2"
    // InternalXtext.g:3591:1: rule__ParserRule__Group_0_0__2 : rule__ParserRule__Group_0_0__2__Impl ;
    public final void rule__ParserRule__Group_0_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3595:1: ( rule__ParserRule__Group_0_0__2__Impl )
            // InternalXtext.g:3596:2: rule__ParserRule__Group_0_0__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_0_0__2__Impl();

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
    // $ANTLR end "rule__ParserRule__Group_0_0__2"


    // $ANTLR start "rule__ParserRule__Group_0_0__2__Impl"
    // InternalXtext.g:3602:1: rule__ParserRule__Group_0_0__2__Impl : ( ( rule__ParserRule__Alternatives_0_0_2 ) ) ;
    public final void rule__ParserRule__Group_0_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3606:1: ( ( ( rule__ParserRule__Alternatives_0_0_2 ) ) )
            // InternalXtext.g:3607:1: ( ( rule__ParserRule__Alternatives_0_0_2 ) )
            {
            // InternalXtext.g:3607:1: ( ( rule__ParserRule__Alternatives_0_0_2 ) )
            // InternalXtext.g:3608:1: ( rule__ParserRule__Alternatives_0_0_2 )
            {
             before(grammarAccess.getParserRuleAccess().getAlternatives_0_0_2()); 
            // InternalXtext.g:3609:1: ( rule__ParserRule__Alternatives_0_0_2 )
            // InternalXtext.g:3609:2: rule__ParserRule__Alternatives_0_0_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Alternatives_0_0_2();

            state._fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getAlternatives_0_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_0_0__2__Impl"


    // $ANTLR start "rule__ParserRule__Group_0_0_2_1__0"
    // InternalXtext.g:3625:1: rule__ParserRule__Group_0_0_2_1__0 : rule__ParserRule__Group_0_0_2_1__0__Impl rule__ParserRule__Group_0_0_2_1__1 ;
    public final void rule__ParserRule__Group_0_0_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3629:1: ( rule__ParserRule__Group_0_0_2_1__0__Impl rule__ParserRule__Group_0_0_2_1__1 )
            // InternalXtext.g:3630:2: rule__ParserRule__Group_0_0_2_1__0__Impl rule__ParserRule__Group_0_0_2_1__1
            {
            pushFollow(FollowSets000.FOLLOW_20);
            rule__ParserRule__Group_0_0_2_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_0_0_2_1__1();

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
    // $ANTLR end "rule__ParserRule__Group_0_0_2_1__0"


    // $ANTLR start "rule__ParserRule__Group_0_0_2_1__0__Impl"
    // InternalXtext.g:3637:1: rule__ParserRule__Group_0_0_2_1__0__Impl : ( 'returns' ) ;
    public final void rule__ParserRule__Group_0_0_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3641:1: ( ( 'returns' ) )
            // InternalXtext.g:3642:1: ( 'returns' )
            {
            // InternalXtext.g:3642:1: ( 'returns' )
            // InternalXtext.g:3643:1: 'returns'
            {
             before(grammarAccess.getParserRuleAccess().getReturnsKeyword_0_0_2_1_0()); 
            match(input,30,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParserRuleAccess().getReturnsKeyword_0_0_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_0_0_2_1__0__Impl"


    // $ANTLR start "rule__ParserRule__Group_0_0_2_1__1"
    // InternalXtext.g:3656:1: rule__ParserRule__Group_0_0_2_1__1 : rule__ParserRule__Group_0_0_2_1__1__Impl ;
    public final void rule__ParserRule__Group_0_0_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3660:1: ( rule__ParserRule__Group_0_0_2_1__1__Impl )
            // InternalXtext.g:3661:2: rule__ParserRule__Group_0_0_2_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_0_0_2_1__1__Impl();

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
    // $ANTLR end "rule__ParserRule__Group_0_0_2_1__1"


    // $ANTLR start "rule__ParserRule__Group_0_0_2_1__1__Impl"
    // InternalXtext.g:3667:1: rule__ParserRule__Group_0_0_2_1__1__Impl : ( ( rule__ParserRule__TypeAssignment_0_0_2_1_1 ) ) ;
    public final void rule__ParserRule__Group_0_0_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3671:1: ( ( ( rule__ParserRule__TypeAssignment_0_0_2_1_1 ) ) )
            // InternalXtext.g:3672:1: ( ( rule__ParserRule__TypeAssignment_0_0_2_1_1 ) )
            {
            // InternalXtext.g:3672:1: ( ( rule__ParserRule__TypeAssignment_0_0_2_1_1 ) )
            // InternalXtext.g:3673:1: ( rule__ParserRule__TypeAssignment_0_0_2_1_1 )
            {
             before(grammarAccess.getParserRuleAccess().getTypeAssignment_0_0_2_1_1()); 
            // InternalXtext.g:3674:1: ( rule__ParserRule__TypeAssignment_0_0_2_1_1 )
            // InternalXtext.g:3674:2: rule__ParserRule__TypeAssignment_0_0_2_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__TypeAssignment_0_0_2_1_1();

            state._fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getTypeAssignment_0_0_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_0_0_2_1__1__Impl"


    // $ANTLR start "rule__ParserRule__Group_0_1__0"
    // InternalXtext.g:3688:1: rule__ParserRule__Group_0_1__0 : rule__ParserRule__Group_0_1__0__Impl rule__ParserRule__Group_0_1__1 ;
    public final void rule__ParserRule__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3692:1: ( rule__ParserRule__Group_0_1__0__Impl rule__ParserRule__Group_0_1__1 )
            // InternalXtext.g:3693:2: rule__ParserRule__Group_0_1__0__Impl rule__ParserRule__Group_0_1__1
            {
            pushFollow(FollowSets000.FOLLOW_21);
            rule__ParserRule__Group_0_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_0_1__1();

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
    // $ANTLR end "rule__ParserRule__Group_0_1__0"


    // $ANTLR start "rule__ParserRule__Group_0_1__0__Impl"
    // InternalXtext.g:3700:1: rule__ParserRule__Group_0_1__0__Impl : ( ruleRuleNameAndParams ) ;
    public final void rule__ParserRule__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3704:1: ( ( ruleRuleNameAndParams ) )
            // InternalXtext.g:3705:1: ( ruleRuleNameAndParams )
            {
            // InternalXtext.g:3705:1: ( ruleRuleNameAndParams )
            // InternalXtext.g:3706:1: ruleRuleNameAndParams
            {
             before(grammarAccess.getParserRuleAccess().getRuleNameAndParamsParserRuleCall_0_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleRuleNameAndParams();

            state._fsp--;

             after(grammarAccess.getParserRuleAccess().getRuleNameAndParamsParserRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_0_1__0__Impl"


    // $ANTLR start "rule__ParserRule__Group_0_1__1"
    // InternalXtext.g:3717:1: rule__ParserRule__Group_0_1__1 : rule__ParserRule__Group_0_1__1__Impl ;
    public final void rule__ParserRule__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3721:1: ( rule__ParserRule__Group_0_1__1__Impl )
            // InternalXtext.g:3722:2: rule__ParserRule__Group_0_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_0_1__1__Impl();

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
    // $ANTLR end "rule__ParserRule__Group_0_1__1"


    // $ANTLR start "rule__ParserRule__Group_0_1__1__Impl"
    // InternalXtext.g:3728:1: rule__ParserRule__Group_0_1__1__Impl : ( ( rule__ParserRule__Group_0_1_1__0 )? ) ;
    public final void rule__ParserRule__Group_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3732:1: ( ( ( rule__ParserRule__Group_0_1_1__0 )? ) )
            // InternalXtext.g:3733:1: ( ( rule__ParserRule__Group_0_1_1__0 )? )
            {
            // InternalXtext.g:3733:1: ( ( rule__ParserRule__Group_0_1_1__0 )? )
            // InternalXtext.g:3734:1: ( rule__ParserRule__Group_0_1_1__0 )?
            {
             before(grammarAccess.getParserRuleAccess().getGroup_0_1_1()); 
            // InternalXtext.g:3735:1: ( rule__ParserRule__Group_0_1_1__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==30) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalXtext.g:3735:2: rule__ParserRule__Group_0_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ParserRule__Group_0_1_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParserRuleAccess().getGroup_0_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_0_1__1__Impl"


    // $ANTLR start "rule__ParserRule__Group_0_1_1__0"
    // InternalXtext.g:3749:1: rule__ParserRule__Group_0_1_1__0 : rule__ParserRule__Group_0_1_1__0__Impl rule__ParserRule__Group_0_1_1__1 ;
    public final void rule__ParserRule__Group_0_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3753:1: ( rule__ParserRule__Group_0_1_1__0__Impl rule__ParserRule__Group_0_1_1__1 )
            // InternalXtext.g:3754:2: rule__ParserRule__Group_0_1_1__0__Impl rule__ParserRule__Group_0_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_20);
            rule__ParserRule__Group_0_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_0_1_1__1();

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
    // $ANTLR end "rule__ParserRule__Group_0_1_1__0"


    // $ANTLR start "rule__ParserRule__Group_0_1_1__0__Impl"
    // InternalXtext.g:3761:1: rule__ParserRule__Group_0_1_1__0__Impl : ( 'returns' ) ;
    public final void rule__ParserRule__Group_0_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3765:1: ( ( 'returns' ) )
            // InternalXtext.g:3766:1: ( 'returns' )
            {
            // InternalXtext.g:3766:1: ( 'returns' )
            // InternalXtext.g:3767:1: 'returns'
            {
             before(grammarAccess.getParserRuleAccess().getReturnsKeyword_0_1_1_0()); 
            match(input,30,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParserRuleAccess().getReturnsKeyword_0_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_0_1_1__0__Impl"


    // $ANTLR start "rule__ParserRule__Group_0_1_1__1"
    // InternalXtext.g:3780:1: rule__ParserRule__Group_0_1_1__1 : rule__ParserRule__Group_0_1_1__1__Impl ;
    public final void rule__ParserRule__Group_0_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3784:1: ( rule__ParserRule__Group_0_1_1__1__Impl )
            // InternalXtext.g:3785:2: rule__ParserRule__Group_0_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_0_1_1__1__Impl();

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
    // $ANTLR end "rule__ParserRule__Group_0_1_1__1"


    // $ANTLR start "rule__ParserRule__Group_0_1_1__1__Impl"
    // InternalXtext.g:3791:1: rule__ParserRule__Group_0_1_1__1__Impl : ( ( rule__ParserRule__TypeAssignment_0_1_1_1 ) ) ;
    public final void rule__ParserRule__Group_0_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3795:1: ( ( ( rule__ParserRule__TypeAssignment_0_1_1_1 ) ) )
            // InternalXtext.g:3796:1: ( ( rule__ParserRule__TypeAssignment_0_1_1_1 ) )
            {
            // InternalXtext.g:3796:1: ( ( rule__ParserRule__TypeAssignment_0_1_1_1 ) )
            // InternalXtext.g:3797:1: ( rule__ParserRule__TypeAssignment_0_1_1_1 )
            {
             before(grammarAccess.getParserRuleAccess().getTypeAssignment_0_1_1_1()); 
            // InternalXtext.g:3798:1: ( rule__ParserRule__TypeAssignment_0_1_1_1 )
            // InternalXtext.g:3798:2: rule__ParserRule__TypeAssignment_0_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__TypeAssignment_0_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getTypeAssignment_0_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_0_1_1__1__Impl"


    // $ANTLR start "rule__ParserRule__Group_1__0"
    // InternalXtext.g:3812:1: rule__ParserRule__Group_1__0 : rule__ParserRule__Group_1__0__Impl rule__ParserRule__Group_1__1 ;
    public final void rule__ParserRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3816:1: ( rule__ParserRule__Group_1__0__Impl rule__ParserRule__Group_1__1 )
            // InternalXtext.g:3817:2: rule__ParserRule__Group_1__0__Impl rule__ParserRule__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__ParserRule__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3824:1: rule__ParserRule__Group_1__0__Impl : ( ( rule__ParserRule__DefinesHiddenTokensAssignment_1_0 ) ) ;
    public final void rule__ParserRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3828:1: ( ( ( rule__ParserRule__DefinesHiddenTokensAssignment_1_0 ) ) )
            // InternalXtext.g:3829:1: ( ( rule__ParserRule__DefinesHiddenTokensAssignment_1_0 ) )
            {
            // InternalXtext.g:3829:1: ( ( rule__ParserRule__DefinesHiddenTokensAssignment_1_0 ) )
            // InternalXtext.g:3830:1: ( rule__ParserRule__DefinesHiddenTokensAssignment_1_0 )
            {
             before(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensAssignment_1_0()); 
            // InternalXtext.g:3831:1: ( rule__ParserRule__DefinesHiddenTokensAssignment_1_0 )
            // InternalXtext.g:3831:2: rule__ParserRule__DefinesHiddenTokensAssignment_1_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__DefinesHiddenTokensAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensAssignment_1_0()); 

            }


            }

        }
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
    // InternalXtext.g:3841:1: rule__ParserRule__Group_1__1 : rule__ParserRule__Group_1__1__Impl rule__ParserRule__Group_1__2 ;
    public final void rule__ParserRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3845:1: ( rule__ParserRule__Group_1__1__Impl rule__ParserRule__Group_1__2 )
            // InternalXtext.g:3846:2: rule__ParserRule__Group_1__1__Impl rule__ParserRule__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__ParserRule__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_1__2();

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
    // InternalXtext.g:3853:1: rule__ParserRule__Group_1__1__Impl : ( '(' ) ;
    public final void rule__ParserRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3857:1: ( ( '(' ) )
            // InternalXtext.g:3858:1: ( '(' )
            {
            // InternalXtext.g:3858:1: ( '(' )
            // InternalXtext.g:3859:1: '('
            {
             before(grammarAccess.getParserRuleAccess().getLeftParenthesisKeyword_1_1()); 
            match(input,22,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParserRuleAccess().getLeftParenthesisKeyword_1_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__ParserRule__Group_1__2"
    // InternalXtext.g:3872:1: rule__ParserRule__Group_1__2 : rule__ParserRule__Group_1__2__Impl rule__ParserRule__Group_1__3 ;
    public final void rule__ParserRule__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3876:1: ( rule__ParserRule__Group_1__2__Impl rule__ParserRule__Group_1__3 )
            // InternalXtext.g:3877:2: rule__ParserRule__Group_1__2__Impl rule__ParserRule__Group_1__3
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__ParserRule__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_1__3();

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
    // $ANTLR end "rule__ParserRule__Group_1__2"


    // $ANTLR start "rule__ParserRule__Group_1__2__Impl"
    // InternalXtext.g:3884:1: rule__ParserRule__Group_1__2__Impl : ( ( rule__ParserRule__Group_1_2__0 )? ) ;
    public final void rule__ParserRule__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3888:1: ( ( ( rule__ParserRule__Group_1_2__0 )? ) )
            // InternalXtext.g:3889:1: ( ( rule__ParserRule__Group_1_2__0 )? )
            {
            // InternalXtext.g:3889:1: ( ( rule__ParserRule__Group_1_2__0 )? )
            // InternalXtext.g:3890:1: ( rule__ParserRule__Group_1_2__0 )?
            {
             before(grammarAccess.getParserRuleAccess().getGroup_1_2()); 
            // InternalXtext.g:3891:1: ( rule__ParserRule__Group_1_2__0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==RULE_ID||(LA39_0>=16 && LA39_0<=17)) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalXtext.g:3891:2: rule__ParserRule__Group_1_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ParserRule__Group_1_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParserRuleAccess().getGroup_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1__2__Impl"


    // $ANTLR start "rule__ParserRule__Group_1__3"
    // InternalXtext.g:3901:1: rule__ParserRule__Group_1__3 : rule__ParserRule__Group_1__3__Impl ;
    public final void rule__ParserRule__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3905:1: ( rule__ParserRule__Group_1__3__Impl )
            // InternalXtext.g:3906:2: rule__ParserRule__Group_1__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_1__3__Impl();

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
    // $ANTLR end "rule__ParserRule__Group_1__3"


    // $ANTLR start "rule__ParserRule__Group_1__3__Impl"
    // InternalXtext.g:3912:1: rule__ParserRule__Group_1__3__Impl : ( ')' ) ;
    public final void rule__ParserRule__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3916:1: ( ( ')' ) )
            // InternalXtext.g:3917:1: ( ')' )
            {
            // InternalXtext.g:3917:1: ( ')' )
            // InternalXtext.g:3918:1: ')'
            {
             before(grammarAccess.getParserRuleAccess().getRightParenthesisKeyword_1_3()); 
            match(input,23,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParserRuleAccess().getRightParenthesisKeyword_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1__3__Impl"


    // $ANTLR start "rule__ParserRule__Group_1_2__0"
    // InternalXtext.g:3939:1: rule__ParserRule__Group_1_2__0 : rule__ParserRule__Group_1_2__0__Impl rule__ParserRule__Group_1_2__1 ;
    public final void rule__ParserRule__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3943:1: ( rule__ParserRule__Group_1_2__0__Impl rule__ParserRule__Group_1_2__1 )
            // InternalXtext.g:3944:2: rule__ParserRule__Group_1_2__0__Impl rule__ParserRule__Group_1_2__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__ParserRule__Group_1_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_1_2__1();

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
    // $ANTLR end "rule__ParserRule__Group_1_2__0"


    // $ANTLR start "rule__ParserRule__Group_1_2__0__Impl"
    // InternalXtext.g:3951:1: rule__ParserRule__Group_1_2__0__Impl : ( ( rule__ParserRule__HiddenTokensAssignment_1_2_0 ) ) ;
    public final void rule__ParserRule__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3955:1: ( ( ( rule__ParserRule__HiddenTokensAssignment_1_2_0 ) ) )
            // InternalXtext.g:3956:1: ( ( rule__ParserRule__HiddenTokensAssignment_1_2_0 ) )
            {
            // InternalXtext.g:3956:1: ( ( rule__ParserRule__HiddenTokensAssignment_1_2_0 ) )
            // InternalXtext.g:3957:1: ( rule__ParserRule__HiddenTokensAssignment_1_2_0 )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_1_2_0()); 
            // InternalXtext.g:3958:1: ( rule__ParserRule__HiddenTokensAssignment_1_2_0 )
            // InternalXtext.g:3958:2: rule__ParserRule__HiddenTokensAssignment_1_2_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__HiddenTokensAssignment_1_2_0();

            state._fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_2__0__Impl"


    // $ANTLR start "rule__ParserRule__Group_1_2__1"
    // InternalXtext.g:3968:1: rule__ParserRule__Group_1_2__1 : rule__ParserRule__Group_1_2__1__Impl ;
    public final void rule__ParserRule__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3972:1: ( rule__ParserRule__Group_1_2__1__Impl )
            // InternalXtext.g:3973:2: rule__ParserRule__Group_1_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_1_2__1__Impl();

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
    // $ANTLR end "rule__ParserRule__Group_1_2__1"


    // $ANTLR start "rule__ParserRule__Group_1_2__1__Impl"
    // InternalXtext.g:3979:1: rule__ParserRule__Group_1_2__1__Impl : ( ( rule__ParserRule__Group_1_2_1__0 )* ) ;
    public final void rule__ParserRule__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:3983:1: ( ( ( rule__ParserRule__Group_1_2_1__0 )* ) )
            // InternalXtext.g:3984:1: ( ( rule__ParserRule__Group_1_2_1__0 )* )
            {
            // InternalXtext.g:3984:1: ( ( rule__ParserRule__Group_1_2_1__0 )* )
            // InternalXtext.g:3985:1: ( rule__ParserRule__Group_1_2_1__0 )*
            {
             before(grammarAccess.getParserRuleAccess().getGroup_1_2_1()); 
            // InternalXtext.g:3986:1: ( rule__ParserRule__Group_1_2_1__0 )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==21) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalXtext.g:3986:2: rule__ParserRule__Group_1_2_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    rule__ParserRule__Group_1_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

             after(grammarAccess.getParserRuleAccess().getGroup_1_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_2__1__Impl"


    // $ANTLR start "rule__ParserRule__Group_1_2_1__0"
    // InternalXtext.g:4000:1: rule__ParserRule__Group_1_2_1__0 : rule__ParserRule__Group_1_2_1__0__Impl rule__ParserRule__Group_1_2_1__1 ;
    public final void rule__ParserRule__Group_1_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4004:1: ( rule__ParserRule__Group_1_2_1__0__Impl rule__ParserRule__Group_1_2_1__1 )
            // InternalXtext.g:4005:2: rule__ParserRule__Group_1_2_1__0__Impl rule__ParserRule__Group_1_2_1__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__ParserRule__Group_1_2_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_1_2_1__1();

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
    // $ANTLR end "rule__ParserRule__Group_1_2_1__0"


    // $ANTLR start "rule__ParserRule__Group_1_2_1__0__Impl"
    // InternalXtext.g:4012:1: rule__ParserRule__Group_1_2_1__0__Impl : ( ',' ) ;
    public final void rule__ParserRule__Group_1_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4016:1: ( ( ',' ) )
            // InternalXtext.g:4017:1: ( ',' )
            {
            // InternalXtext.g:4017:1: ( ',' )
            // InternalXtext.g:4018:1: ','
            {
             before(grammarAccess.getParserRuleAccess().getCommaKeyword_1_2_1_0()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParserRuleAccess().getCommaKeyword_1_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_2_1__0__Impl"


    // $ANTLR start "rule__ParserRule__Group_1_2_1__1"
    // InternalXtext.g:4031:1: rule__ParserRule__Group_1_2_1__1 : rule__ParserRule__Group_1_2_1__1__Impl ;
    public final void rule__ParserRule__Group_1_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4035:1: ( rule__ParserRule__Group_1_2_1__1__Impl )
            // InternalXtext.g:4036:2: rule__ParserRule__Group_1_2_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_1_2_1__1__Impl();

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
    // $ANTLR end "rule__ParserRule__Group_1_2_1__1"


    // $ANTLR start "rule__ParserRule__Group_1_2_1__1__Impl"
    // InternalXtext.g:4042:1: rule__ParserRule__Group_1_2_1__1__Impl : ( ( rule__ParserRule__HiddenTokensAssignment_1_2_1_1 ) ) ;
    public final void rule__ParserRule__Group_1_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4046:1: ( ( ( rule__ParserRule__HiddenTokensAssignment_1_2_1_1 ) ) )
            // InternalXtext.g:4047:1: ( ( rule__ParserRule__HiddenTokensAssignment_1_2_1_1 ) )
            {
            // InternalXtext.g:4047:1: ( ( rule__ParserRule__HiddenTokensAssignment_1_2_1_1 ) )
            // InternalXtext.g:4048:1: ( rule__ParserRule__HiddenTokensAssignment_1_2_1_1 )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_1_2_1_1()); 
            // InternalXtext.g:4049:1: ( rule__ParserRule__HiddenTokensAssignment_1_2_1_1 )
            // InternalXtext.g:4049:2: rule__ParserRule__HiddenTokensAssignment_1_2_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__HiddenTokensAssignment_1_2_1_1();

            state._fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_1_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_2_1__1__Impl"


    // $ANTLR start "rule__RuleNameAndParams__Group__0"
    // InternalXtext.g:4063:1: rule__RuleNameAndParams__Group__0 : rule__RuleNameAndParams__Group__0__Impl rule__RuleNameAndParams__Group__1 ;
    public final void rule__RuleNameAndParams__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4067:1: ( rule__RuleNameAndParams__Group__0__Impl rule__RuleNameAndParams__Group__1 )
            // InternalXtext.g:4068:2: rule__RuleNameAndParams__Group__0__Impl rule__RuleNameAndParams__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_22);
            rule__RuleNameAndParams__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__Group__1();

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
    // $ANTLR end "rule__RuleNameAndParams__Group__0"


    // $ANTLR start "rule__RuleNameAndParams__Group__0__Impl"
    // InternalXtext.g:4075:1: rule__RuleNameAndParams__Group__0__Impl : ( ( rule__RuleNameAndParams__NameAssignment_0 ) ) ;
    public final void rule__RuleNameAndParams__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4079:1: ( ( ( rule__RuleNameAndParams__NameAssignment_0 ) ) )
            // InternalXtext.g:4080:1: ( ( rule__RuleNameAndParams__NameAssignment_0 ) )
            {
            // InternalXtext.g:4080:1: ( ( rule__RuleNameAndParams__NameAssignment_0 ) )
            // InternalXtext.g:4081:1: ( rule__RuleNameAndParams__NameAssignment_0 )
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getNameAssignment_0()); 
            // InternalXtext.g:4082:1: ( rule__RuleNameAndParams__NameAssignment_0 )
            // InternalXtext.g:4082:2: rule__RuleNameAndParams__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getRuleNameAndParamsAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__Group__0__Impl"


    // $ANTLR start "rule__RuleNameAndParams__Group__1"
    // InternalXtext.g:4092:1: rule__RuleNameAndParams__Group__1 : rule__RuleNameAndParams__Group__1__Impl ;
    public final void rule__RuleNameAndParams__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4096:1: ( rule__RuleNameAndParams__Group__1__Impl )
            // InternalXtext.g:4097:2: rule__RuleNameAndParams__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__Group__1__Impl();

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
    // $ANTLR end "rule__RuleNameAndParams__Group__1"


    // $ANTLR start "rule__RuleNameAndParams__Group__1__Impl"
    // InternalXtext.g:4103:1: rule__RuleNameAndParams__Group__1__Impl : ( ( rule__RuleNameAndParams__Group_1__0 )? ) ;
    public final void rule__RuleNameAndParams__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4107:1: ( ( ( rule__RuleNameAndParams__Group_1__0 )? ) )
            // InternalXtext.g:4108:1: ( ( rule__RuleNameAndParams__Group_1__0 )? )
            {
            // InternalXtext.g:4108:1: ( ( rule__RuleNameAndParams__Group_1__0 )? )
            // InternalXtext.g:4109:1: ( rule__RuleNameAndParams__Group_1__0 )?
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getGroup_1()); 
            // InternalXtext.g:4110:1: ( rule__RuleNameAndParams__Group_1__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==31) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalXtext.g:4110:2: rule__RuleNameAndParams__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__RuleNameAndParams__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRuleNameAndParamsAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__Group__1__Impl"


    // $ANTLR start "rule__RuleNameAndParams__Group_1__0"
    // InternalXtext.g:4124:1: rule__RuleNameAndParams__Group_1__0 : rule__RuleNameAndParams__Group_1__0__Impl rule__RuleNameAndParams__Group_1__1 ;
    public final void rule__RuleNameAndParams__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4128:1: ( rule__RuleNameAndParams__Group_1__0__Impl rule__RuleNameAndParams__Group_1__1 )
            // InternalXtext.g:4129:2: rule__RuleNameAndParams__Group_1__0__Impl rule__RuleNameAndParams__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_23);
            rule__RuleNameAndParams__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__Group_1__1();

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
    // $ANTLR end "rule__RuleNameAndParams__Group_1__0"


    // $ANTLR start "rule__RuleNameAndParams__Group_1__0__Impl"
    // InternalXtext.g:4136:1: rule__RuleNameAndParams__Group_1__0__Impl : ( '<' ) ;
    public final void rule__RuleNameAndParams__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4140:1: ( ( '<' ) )
            // InternalXtext.g:4141:1: ( '<' )
            {
            // InternalXtext.g:4141:1: ( '<' )
            // InternalXtext.g:4142:1: '<'
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getLessThanSignKeyword_1_0()); 
            match(input,31,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRuleNameAndParamsAccess().getLessThanSignKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__Group_1__0__Impl"


    // $ANTLR start "rule__RuleNameAndParams__Group_1__1"
    // InternalXtext.g:4155:1: rule__RuleNameAndParams__Group_1__1 : rule__RuleNameAndParams__Group_1__1__Impl rule__RuleNameAndParams__Group_1__2 ;
    public final void rule__RuleNameAndParams__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4159:1: ( rule__RuleNameAndParams__Group_1__1__Impl rule__RuleNameAndParams__Group_1__2 )
            // InternalXtext.g:4160:2: rule__RuleNameAndParams__Group_1__1__Impl rule__RuleNameAndParams__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_23);
            rule__RuleNameAndParams__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__Group_1__2();

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
    // $ANTLR end "rule__RuleNameAndParams__Group_1__1"


    // $ANTLR start "rule__RuleNameAndParams__Group_1__1__Impl"
    // InternalXtext.g:4167:1: rule__RuleNameAndParams__Group_1__1__Impl : ( ( rule__RuleNameAndParams__Group_1_1__0 )? ) ;
    public final void rule__RuleNameAndParams__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4171:1: ( ( ( rule__RuleNameAndParams__Group_1_1__0 )? ) )
            // InternalXtext.g:4172:1: ( ( rule__RuleNameAndParams__Group_1_1__0 )? )
            {
            // InternalXtext.g:4172:1: ( ( rule__RuleNameAndParams__Group_1_1__0 )? )
            // InternalXtext.g:4173:1: ( rule__RuleNameAndParams__Group_1_1__0 )?
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getGroup_1_1()); 
            // InternalXtext.g:4174:1: ( rule__RuleNameAndParams__Group_1_1__0 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==RULE_ID) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalXtext.g:4174:2: rule__RuleNameAndParams__Group_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__RuleNameAndParams__Group_1_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRuleNameAndParamsAccess().getGroup_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__Group_1__1__Impl"


    // $ANTLR start "rule__RuleNameAndParams__Group_1__2"
    // InternalXtext.g:4184:1: rule__RuleNameAndParams__Group_1__2 : rule__RuleNameAndParams__Group_1__2__Impl ;
    public final void rule__RuleNameAndParams__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4188:1: ( rule__RuleNameAndParams__Group_1__2__Impl )
            // InternalXtext.g:4189:2: rule__RuleNameAndParams__Group_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__Group_1__2__Impl();

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
    // $ANTLR end "rule__RuleNameAndParams__Group_1__2"


    // $ANTLR start "rule__RuleNameAndParams__Group_1__2__Impl"
    // InternalXtext.g:4195:1: rule__RuleNameAndParams__Group_1__2__Impl : ( '>' ) ;
    public final void rule__RuleNameAndParams__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4199:1: ( ( '>' ) )
            // InternalXtext.g:4200:1: ( '>' )
            {
            // InternalXtext.g:4200:1: ( '>' )
            // InternalXtext.g:4201:1: '>'
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getGreaterThanSignKeyword_1_2()); 
            match(input,32,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRuleNameAndParamsAccess().getGreaterThanSignKeyword_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__Group_1__2__Impl"


    // $ANTLR start "rule__RuleNameAndParams__Group_1_1__0"
    // InternalXtext.g:4220:1: rule__RuleNameAndParams__Group_1_1__0 : rule__RuleNameAndParams__Group_1_1__0__Impl rule__RuleNameAndParams__Group_1_1__1 ;
    public final void rule__RuleNameAndParams__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4224:1: ( rule__RuleNameAndParams__Group_1_1__0__Impl rule__RuleNameAndParams__Group_1_1__1 )
            // InternalXtext.g:4225:2: rule__RuleNameAndParams__Group_1_1__0__Impl rule__RuleNameAndParams__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__RuleNameAndParams__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__Group_1_1__1();

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
    // $ANTLR end "rule__RuleNameAndParams__Group_1_1__0"


    // $ANTLR start "rule__RuleNameAndParams__Group_1_1__0__Impl"
    // InternalXtext.g:4232:1: rule__RuleNameAndParams__Group_1_1__0__Impl : ( ( rule__RuleNameAndParams__ParametersAssignment_1_1_0 ) ) ;
    public final void rule__RuleNameAndParams__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4236:1: ( ( ( rule__RuleNameAndParams__ParametersAssignment_1_1_0 ) ) )
            // InternalXtext.g:4237:1: ( ( rule__RuleNameAndParams__ParametersAssignment_1_1_0 ) )
            {
            // InternalXtext.g:4237:1: ( ( rule__RuleNameAndParams__ParametersAssignment_1_1_0 ) )
            // InternalXtext.g:4238:1: ( rule__RuleNameAndParams__ParametersAssignment_1_1_0 )
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getParametersAssignment_1_1_0()); 
            // InternalXtext.g:4239:1: ( rule__RuleNameAndParams__ParametersAssignment_1_1_0 )
            // InternalXtext.g:4239:2: rule__RuleNameAndParams__ParametersAssignment_1_1_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__ParametersAssignment_1_1_0();

            state._fsp--;


            }

             after(grammarAccess.getRuleNameAndParamsAccess().getParametersAssignment_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__Group_1_1__0__Impl"


    // $ANTLR start "rule__RuleNameAndParams__Group_1_1__1"
    // InternalXtext.g:4249:1: rule__RuleNameAndParams__Group_1_1__1 : rule__RuleNameAndParams__Group_1_1__1__Impl ;
    public final void rule__RuleNameAndParams__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4253:1: ( rule__RuleNameAndParams__Group_1_1__1__Impl )
            // InternalXtext.g:4254:2: rule__RuleNameAndParams__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__Group_1_1__1__Impl();

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
    // $ANTLR end "rule__RuleNameAndParams__Group_1_1__1"


    // $ANTLR start "rule__RuleNameAndParams__Group_1_1__1__Impl"
    // InternalXtext.g:4260:1: rule__RuleNameAndParams__Group_1_1__1__Impl : ( ( rule__RuleNameAndParams__Group_1_1_1__0 )* ) ;
    public final void rule__RuleNameAndParams__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4264:1: ( ( ( rule__RuleNameAndParams__Group_1_1_1__0 )* ) )
            // InternalXtext.g:4265:1: ( ( rule__RuleNameAndParams__Group_1_1_1__0 )* )
            {
            // InternalXtext.g:4265:1: ( ( rule__RuleNameAndParams__Group_1_1_1__0 )* )
            // InternalXtext.g:4266:1: ( rule__RuleNameAndParams__Group_1_1_1__0 )*
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getGroup_1_1_1()); 
            // InternalXtext.g:4267:1: ( rule__RuleNameAndParams__Group_1_1_1__0 )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==21) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalXtext.g:4267:2: rule__RuleNameAndParams__Group_1_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    rule__RuleNameAndParams__Group_1_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

             after(grammarAccess.getRuleNameAndParamsAccess().getGroup_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__Group_1_1__1__Impl"


    // $ANTLR start "rule__RuleNameAndParams__Group_1_1_1__0"
    // InternalXtext.g:4281:1: rule__RuleNameAndParams__Group_1_1_1__0 : rule__RuleNameAndParams__Group_1_1_1__0__Impl rule__RuleNameAndParams__Group_1_1_1__1 ;
    public final void rule__RuleNameAndParams__Group_1_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4285:1: ( rule__RuleNameAndParams__Group_1_1_1__0__Impl rule__RuleNameAndParams__Group_1_1_1__1 )
            // InternalXtext.g:4286:2: rule__RuleNameAndParams__Group_1_1_1__0__Impl rule__RuleNameAndParams__Group_1_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_20);
            rule__RuleNameAndParams__Group_1_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__Group_1_1_1__1();

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
    // $ANTLR end "rule__RuleNameAndParams__Group_1_1_1__0"


    // $ANTLR start "rule__RuleNameAndParams__Group_1_1_1__0__Impl"
    // InternalXtext.g:4293:1: rule__RuleNameAndParams__Group_1_1_1__0__Impl : ( ',' ) ;
    public final void rule__RuleNameAndParams__Group_1_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4297:1: ( ( ',' ) )
            // InternalXtext.g:4298:1: ( ',' )
            {
            // InternalXtext.g:4298:1: ( ',' )
            // InternalXtext.g:4299:1: ','
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getCommaKeyword_1_1_1_0()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRuleNameAndParamsAccess().getCommaKeyword_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__Group_1_1_1__0__Impl"


    // $ANTLR start "rule__RuleNameAndParams__Group_1_1_1__1"
    // InternalXtext.g:4312:1: rule__RuleNameAndParams__Group_1_1_1__1 : rule__RuleNameAndParams__Group_1_1_1__1__Impl ;
    public final void rule__RuleNameAndParams__Group_1_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4316:1: ( rule__RuleNameAndParams__Group_1_1_1__1__Impl )
            // InternalXtext.g:4317:2: rule__RuleNameAndParams__Group_1_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__Group_1_1_1__1__Impl();

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
    // $ANTLR end "rule__RuleNameAndParams__Group_1_1_1__1"


    // $ANTLR start "rule__RuleNameAndParams__Group_1_1_1__1__Impl"
    // InternalXtext.g:4323:1: rule__RuleNameAndParams__Group_1_1_1__1__Impl : ( ( rule__RuleNameAndParams__ParametersAssignment_1_1_1_1 ) ) ;
    public final void rule__RuleNameAndParams__Group_1_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4327:1: ( ( ( rule__RuleNameAndParams__ParametersAssignment_1_1_1_1 ) ) )
            // InternalXtext.g:4328:1: ( ( rule__RuleNameAndParams__ParametersAssignment_1_1_1_1 ) )
            {
            // InternalXtext.g:4328:1: ( ( rule__RuleNameAndParams__ParametersAssignment_1_1_1_1 ) )
            // InternalXtext.g:4329:1: ( rule__RuleNameAndParams__ParametersAssignment_1_1_1_1 )
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getParametersAssignment_1_1_1_1()); 
            // InternalXtext.g:4330:1: ( rule__RuleNameAndParams__ParametersAssignment_1_1_1_1 )
            // InternalXtext.g:4330:2: rule__RuleNameAndParams__ParametersAssignment_1_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__ParametersAssignment_1_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getRuleNameAndParamsAccess().getParametersAssignment_1_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__Group_1_1_1__1__Impl"


    // $ANTLR start "rule__TypeRef__Group__0"
    // InternalXtext.g:4344:1: rule__TypeRef__Group__0 : rule__TypeRef__Group__0__Impl rule__TypeRef__Group__1 ;
    public final void rule__TypeRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4348:1: ( rule__TypeRef__Group__0__Impl rule__TypeRef__Group__1 )
            // InternalXtext.g:4349:2: rule__TypeRef__Group__0__Impl rule__TypeRef__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_20);
            rule__TypeRef__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:4356:1: rule__TypeRef__Group__0__Impl : ( ( rule__TypeRef__Group_0__0 )? ) ;
    public final void rule__TypeRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4360:1: ( ( ( rule__TypeRef__Group_0__0 )? ) )
            // InternalXtext.g:4361:1: ( ( rule__TypeRef__Group_0__0 )? )
            {
            // InternalXtext.g:4361:1: ( ( rule__TypeRef__Group_0__0 )? )
            // InternalXtext.g:4362:1: ( rule__TypeRef__Group_0__0 )?
            {
             before(grammarAccess.getTypeRefAccess().getGroup_0()); 
            // InternalXtext.g:4363:1: ( rule__TypeRef__Group_0__0 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==RULE_ID) ) {
                int LA44_1 = input.LA(2);

                if ( (LA44_1==33) ) {
                    alt44=1;
                }
            }
            switch (alt44) {
                case 1 :
                    // InternalXtext.g:4363:2: rule__TypeRef__Group_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:4373:1: rule__TypeRef__Group__1 : rule__TypeRef__Group__1__Impl ;
    public final void rule__TypeRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4377:1: ( rule__TypeRef__Group__1__Impl )
            // InternalXtext.g:4378:2: rule__TypeRef__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:4384:1: rule__TypeRef__Group__1__Impl : ( ( rule__TypeRef__ClassifierAssignment_1 ) ) ;
    public final void rule__TypeRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4388:1: ( ( ( rule__TypeRef__ClassifierAssignment_1 ) ) )
            // InternalXtext.g:4389:1: ( ( rule__TypeRef__ClassifierAssignment_1 ) )
            {
            // InternalXtext.g:4389:1: ( ( rule__TypeRef__ClassifierAssignment_1 ) )
            // InternalXtext.g:4390:1: ( rule__TypeRef__ClassifierAssignment_1 )
            {
             before(grammarAccess.getTypeRefAccess().getClassifierAssignment_1()); 
            // InternalXtext.g:4391:1: ( rule__TypeRef__ClassifierAssignment_1 )
            // InternalXtext.g:4391:2: rule__TypeRef__ClassifierAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:4405:1: rule__TypeRef__Group_0__0 : rule__TypeRef__Group_0__0__Impl rule__TypeRef__Group_0__1 ;
    public final void rule__TypeRef__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4409:1: ( rule__TypeRef__Group_0__0__Impl rule__TypeRef__Group_0__1 )
            // InternalXtext.g:4410:2: rule__TypeRef__Group_0__0__Impl rule__TypeRef__Group_0__1
            {
            pushFollow(FollowSets000.FOLLOW_24);
            rule__TypeRef__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:4417:1: rule__TypeRef__Group_0__0__Impl : ( ( rule__TypeRef__MetamodelAssignment_0_0 ) ) ;
    public final void rule__TypeRef__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4421:1: ( ( ( rule__TypeRef__MetamodelAssignment_0_0 ) ) )
            // InternalXtext.g:4422:1: ( ( rule__TypeRef__MetamodelAssignment_0_0 ) )
            {
            // InternalXtext.g:4422:1: ( ( rule__TypeRef__MetamodelAssignment_0_0 ) )
            // InternalXtext.g:4423:1: ( rule__TypeRef__MetamodelAssignment_0_0 )
            {
             before(grammarAccess.getTypeRefAccess().getMetamodelAssignment_0_0()); 
            // InternalXtext.g:4424:1: ( rule__TypeRef__MetamodelAssignment_0_0 )
            // InternalXtext.g:4424:2: rule__TypeRef__MetamodelAssignment_0_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:4434:1: rule__TypeRef__Group_0__1 : rule__TypeRef__Group_0__1__Impl ;
    public final void rule__TypeRef__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4438:1: ( rule__TypeRef__Group_0__1__Impl )
            // InternalXtext.g:4439:2: rule__TypeRef__Group_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:4445:1: rule__TypeRef__Group_0__1__Impl : ( '::' ) ;
    public final void rule__TypeRef__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4449:1: ( ( '::' ) )
            // InternalXtext.g:4450:1: ( '::' )
            {
            // InternalXtext.g:4450:1: ( '::' )
            // InternalXtext.g:4451:1: '::'
            {
             before(grammarAccess.getTypeRefAccess().getColonColonKeyword_0_1()); 
            match(input,33,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:4468:1: rule__Alternatives__Group__0 : rule__Alternatives__Group__0__Impl rule__Alternatives__Group__1 ;
    public final void rule__Alternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4472:1: ( rule__Alternatives__Group__0__Impl rule__Alternatives__Group__1 )
            // InternalXtext.g:4473:2: rule__Alternatives__Group__0__Impl rule__Alternatives__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_25);
            rule__Alternatives__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:4480:1: rule__Alternatives__Group__0__Impl : ( ruleConditionalBranch ) ;
    public final void rule__Alternatives__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4484:1: ( ( ruleConditionalBranch ) )
            // InternalXtext.g:4485:1: ( ruleConditionalBranch )
            {
            // InternalXtext.g:4485:1: ( ruleConditionalBranch )
            // InternalXtext.g:4486:1: ruleConditionalBranch
            {
             before(grammarAccess.getAlternativesAccess().getConditionalBranchParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleConditionalBranch();

            state._fsp--;

             after(grammarAccess.getAlternativesAccess().getConditionalBranchParserRuleCall_0()); 

            }


            }

        }
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
    // InternalXtext.g:4497:1: rule__Alternatives__Group__1 : rule__Alternatives__Group__1__Impl ;
    public final void rule__Alternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4501:1: ( rule__Alternatives__Group__1__Impl )
            // InternalXtext.g:4502:2: rule__Alternatives__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:4508:1: rule__Alternatives__Group__1__Impl : ( ( rule__Alternatives__Group_1__0 )? ) ;
    public final void rule__Alternatives__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4512:1: ( ( ( rule__Alternatives__Group_1__0 )? ) )
            // InternalXtext.g:4513:1: ( ( rule__Alternatives__Group_1__0 )? )
            {
            // InternalXtext.g:4513:1: ( ( rule__Alternatives__Group_1__0 )? )
            // InternalXtext.g:4514:1: ( rule__Alternatives__Group_1__0 )?
            {
             before(grammarAccess.getAlternativesAccess().getGroup_1()); 
            // InternalXtext.g:4515:1: ( rule__Alternatives__Group_1__0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==34) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalXtext.g:4515:2: rule__Alternatives__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:4529:1: rule__Alternatives__Group_1__0 : rule__Alternatives__Group_1__0__Impl rule__Alternatives__Group_1__1 ;
    public final void rule__Alternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4533:1: ( rule__Alternatives__Group_1__0__Impl rule__Alternatives__Group_1__1 )
            // InternalXtext.g:4534:2: rule__Alternatives__Group_1__0__Impl rule__Alternatives__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_25);
            rule__Alternatives__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:4541:1: rule__Alternatives__Group_1__0__Impl : ( () ) ;
    public final void rule__Alternatives__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4545:1: ( ( () ) )
            // InternalXtext.g:4546:1: ( () )
            {
            // InternalXtext.g:4546:1: ( () )
            // InternalXtext.g:4547:1: ()
            {
             before(grammarAccess.getAlternativesAccess().getAlternativesElementsAction_1_0()); 
            // InternalXtext.g:4548:1: ()
            // InternalXtext.g:4550:1: 
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
    // InternalXtext.g:4560:1: rule__Alternatives__Group_1__1 : rule__Alternatives__Group_1__1__Impl ;
    public final void rule__Alternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4564:1: ( rule__Alternatives__Group_1__1__Impl )
            // InternalXtext.g:4565:2: rule__Alternatives__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:4571:1: rule__Alternatives__Group_1__1__Impl : ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) ) ;
    public final void rule__Alternatives__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4575:1: ( ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) ) )
            // InternalXtext.g:4576:1: ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) )
            {
            // InternalXtext.g:4576:1: ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) )
            // InternalXtext.g:4577:1: ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* )
            {
            // InternalXtext.g:4577:1: ( ( rule__Alternatives__Group_1_1__0 ) )
            // InternalXtext.g:4578:1: ( rule__Alternatives__Group_1_1__0 )
            {
             before(grammarAccess.getAlternativesAccess().getGroup_1_1()); 
            // InternalXtext.g:4579:1: ( rule__Alternatives__Group_1_1__0 )
            // InternalXtext.g:4579:2: rule__Alternatives__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_26);
            rule__Alternatives__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getAlternativesAccess().getGroup_1_1()); 

            }

            // InternalXtext.g:4582:1: ( ( rule__Alternatives__Group_1_1__0 )* )
            // InternalXtext.g:4583:1: ( rule__Alternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getAlternativesAccess().getGroup_1_1()); 
            // InternalXtext.g:4584:1: ( rule__Alternatives__Group_1_1__0 )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==34) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalXtext.g:4584:2: rule__Alternatives__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_26);
            	    rule__Alternatives__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop46;
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
    // InternalXtext.g:4599:1: rule__Alternatives__Group_1_1__0 : rule__Alternatives__Group_1_1__0__Impl rule__Alternatives__Group_1_1__1 ;
    public final void rule__Alternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4603:1: ( rule__Alternatives__Group_1_1__0__Impl rule__Alternatives__Group_1_1__1 )
            // InternalXtext.g:4604:2: rule__Alternatives__Group_1_1__0__Impl rule__Alternatives__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__Alternatives__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:4611:1: rule__Alternatives__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__Alternatives__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4615:1: ( ( '|' ) )
            // InternalXtext.g:4616:1: ( '|' )
            {
            // InternalXtext.g:4616:1: ( '|' )
            // InternalXtext.g:4617:1: '|'
            {
             before(grammarAccess.getAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,34,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:4630:1: rule__Alternatives__Group_1_1__1 : rule__Alternatives__Group_1_1__1__Impl ;
    public final void rule__Alternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4634:1: ( rule__Alternatives__Group_1_1__1__Impl )
            // InternalXtext.g:4635:2: rule__Alternatives__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:4641:1: rule__Alternatives__Group_1_1__1__Impl : ( ( rule__Alternatives__ElementsAssignment_1_1_1 ) ) ;
    public final void rule__Alternatives__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4645:1: ( ( ( rule__Alternatives__ElementsAssignment_1_1_1 ) ) )
            // InternalXtext.g:4646:1: ( ( rule__Alternatives__ElementsAssignment_1_1_1 ) )
            {
            // InternalXtext.g:4646:1: ( ( rule__Alternatives__ElementsAssignment_1_1_1 ) )
            // InternalXtext.g:4647:1: ( rule__Alternatives__ElementsAssignment_1_1_1 )
            {
             before(grammarAccess.getAlternativesAccess().getElementsAssignment_1_1_1()); 
            // InternalXtext.g:4648:1: ( rule__Alternatives__ElementsAssignment_1_1_1 )
            // InternalXtext.g:4648:2: rule__Alternatives__ElementsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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


    // $ANTLR start "rule__ConditionalBranch__Group_1__0"
    // InternalXtext.g:4662:1: rule__ConditionalBranch__Group_1__0 : rule__ConditionalBranch__Group_1__0__Impl rule__ConditionalBranch__Group_1__1 ;
    public final void rule__ConditionalBranch__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4666:1: ( rule__ConditionalBranch__Group_1__0__Impl rule__ConditionalBranch__Group_1__1 )
            // InternalXtext.g:4667:2: rule__ConditionalBranch__Group_1__0__Impl rule__ConditionalBranch__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__ConditionalBranch__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConditionalBranch__Group_1__1();

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
    // $ANTLR end "rule__ConditionalBranch__Group_1__0"


    // $ANTLR start "rule__ConditionalBranch__Group_1__0__Impl"
    // InternalXtext.g:4674:1: rule__ConditionalBranch__Group_1__0__Impl : ( () ) ;
    public final void rule__ConditionalBranch__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4678:1: ( ( () ) )
            // InternalXtext.g:4679:1: ( () )
            {
            // InternalXtext.g:4679:1: ( () )
            // InternalXtext.g:4680:1: ()
            {
             before(grammarAccess.getConditionalBranchAccess().getGroupAction_1_0()); 
            // InternalXtext.g:4681:1: ()
            // InternalXtext.g:4683:1: 
            {
            }

             after(grammarAccess.getConditionalBranchAccess().getGroupAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalBranch__Group_1__0__Impl"


    // $ANTLR start "rule__ConditionalBranch__Group_1__1"
    // InternalXtext.g:4693:1: rule__ConditionalBranch__Group_1__1 : rule__ConditionalBranch__Group_1__1__Impl rule__ConditionalBranch__Group_1__2 ;
    public final void rule__ConditionalBranch__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4697:1: ( rule__ConditionalBranch__Group_1__1__Impl rule__ConditionalBranch__Group_1__2 )
            // InternalXtext.g:4698:2: rule__ConditionalBranch__Group_1__1__Impl rule__ConditionalBranch__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_27);
            rule__ConditionalBranch__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConditionalBranch__Group_1__2();

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
    // $ANTLR end "rule__ConditionalBranch__Group_1__1"


    // $ANTLR start "rule__ConditionalBranch__Group_1__1__Impl"
    // InternalXtext.g:4705:1: rule__ConditionalBranch__Group_1__1__Impl : ( '<' ) ;
    public final void rule__ConditionalBranch__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4709:1: ( ( '<' ) )
            // InternalXtext.g:4710:1: ( '<' )
            {
            // InternalXtext.g:4710:1: ( '<' )
            // InternalXtext.g:4711:1: '<'
            {
             before(grammarAccess.getConditionalBranchAccess().getLessThanSignKeyword_1_1()); 
            match(input,31,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getConditionalBranchAccess().getLessThanSignKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalBranch__Group_1__1__Impl"


    // $ANTLR start "rule__ConditionalBranch__Group_1__2"
    // InternalXtext.g:4724:1: rule__ConditionalBranch__Group_1__2 : rule__ConditionalBranch__Group_1__2__Impl rule__ConditionalBranch__Group_1__3 ;
    public final void rule__ConditionalBranch__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4728:1: ( rule__ConditionalBranch__Group_1__2__Impl rule__ConditionalBranch__Group_1__3 )
            // InternalXtext.g:4729:2: rule__ConditionalBranch__Group_1__2__Impl rule__ConditionalBranch__Group_1__3
            {
            pushFollow(FollowSets000.FOLLOW_28);
            rule__ConditionalBranch__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConditionalBranch__Group_1__3();

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
    // $ANTLR end "rule__ConditionalBranch__Group_1__2"


    // $ANTLR start "rule__ConditionalBranch__Group_1__2__Impl"
    // InternalXtext.g:4736:1: rule__ConditionalBranch__Group_1__2__Impl : ( ( rule__ConditionalBranch__GuardConditionAssignment_1_2 ) ) ;
    public final void rule__ConditionalBranch__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4740:1: ( ( ( rule__ConditionalBranch__GuardConditionAssignment_1_2 ) ) )
            // InternalXtext.g:4741:1: ( ( rule__ConditionalBranch__GuardConditionAssignment_1_2 ) )
            {
            // InternalXtext.g:4741:1: ( ( rule__ConditionalBranch__GuardConditionAssignment_1_2 ) )
            // InternalXtext.g:4742:1: ( rule__ConditionalBranch__GuardConditionAssignment_1_2 )
            {
             before(grammarAccess.getConditionalBranchAccess().getGuardConditionAssignment_1_2()); 
            // InternalXtext.g:4743:1: ( rule__ConditionalBranch__GuardConditionAssignment_1_2 )
            // InternalXtext.g:4743:2: rule__ConditionalBranch__GuardConditionAssignment_1_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConditionalBranch__GuardConditionAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getConditionalBranchAccess().getGuardConditionAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalBranch__Group_1__2__Impl"


    // $ANTLR start "rule__ConditionalBranch__Group_1__3"
    // InternalXtext.g:4753:1: rule__ConditionalBranch__Group_1__3 : rule__ConditionalBranch__Group_1__3__Impl rule__ConditionalBranch__Group_1__4 ;
    public final void rule__ConditionalBranch__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4757:1: ( rule__ConditionalBranch__Group_1__3__Impl rule__ConditionalBranch__Group_1__4 )
            // InternalXtext.g:4758:2: rule__ConditionalBranch__Group_1__3__Impl rule__ConditionalBranch__Group_1__4
            {
            pushFollow(FollowSets000.FOLLOW_29);
            rule__ConditionalBranch__Group_1__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConditionalBranch__Group_1__4();

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
    // $ANTLR end "rule__ConditionalBranch__Group_1__3"


    // $ANTLR start "rule__ConditionalBranch__Group_1__3__Impl"
    // InternalXtext.g:4765:1: rule__ConditionalBranch__Group_1__3__Impl : ( '>' ) ;
    public final void rule__ConditionalBranch__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4769:1: ( ( '>' ) )
            // InternalXtext.g:4770:1: ( '>' )
            {
            // InternalXtext.g:4770:1: ( '>' )
            // InternalXtext.g:4771:1: '>'
            {
             before(grammarAccess.getConditionalBranchAccess().getGreaterThanSignKeyword_1_3()); 
            match(input,32,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getConditionalBranchAccess().getGreaterThanSignKeyword_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalBranch__Group_1__3__Impl"


    // $ANTLR start "rule__ConditionalBranch__Group_1__4"
    // InternalXtext.g:4784:1: rule__ConditionalBranch__Group_1__4 : rule__ConditionalBranch__Group_1__4__Impl ;
    public final void rule__ConditionalBranch__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4788:1: ( rule__ConditionalBranch__Group_1__4__Impl )
            // InternalXtext.g:4789:2: rule__ConditionalBranch__Group_1__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConditionalBranch__Group_1__4__Impl();

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
    // $ANTLR end "rule__ConditionalBranch__Group_1__4"


    // $ANTLR start "rule__ConditionalBranch__Group_1__4__Impl"
    // InternalXtext.g:4795:1: rule__ConditionalBranch__Group_1__4__Impl : ( ( ( rule__ConditionalBranch__ElementsAssignment_1_4 ) ) ( ( rule__ConditionalBranch__ElementsAssignment_1_4 )* ) ) ;
    public final void rule__ConditionalBranch__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4799:1: ( ( ( ( rule__ConditionalBranch__ElementsAssignment_1_4 ) ) ( ( rule__ConditionalBranch__ElementsAssignment_1_4 )* ) ) )
            // InternalXtext.g:4800:1: ( ( ( rule__ConditionalBranch__ElementsAssignment_1_4 ) ) ( ( rule__ConditionalBranch__ElementsAssignment_1_4 )* ) )
            {
            // InternalXtext.g:4800:1: ( ( ( rule__ConditionalBranch__ElementsAssignment_1_4 ) ) ( ( rule__ConditionalBranch__ElementsAssignment_1_4 )* ) )
            // InternalXtext.g:4801:1: ( ( rule__ConditionalBranch__ElementsAssignment_1_4 ) ) ( ( rule__ConditionalBranch__ElementsAssignment_1_4 )* )
            {
            // InternalXtext.g:4801:1: ( ( rule__ConditionalBranch__ElementsAssignment_1_4 ) )
            // InternalXtext.g:4802:1: ( rule__ConditionalBranch__ElementsAssignment_1_4 )
            {
             before(grammarAccess.getConditionalBranchAccess().getElementsAssignment_1_4()); 
            // InternalXtext.g:4803:1: ( rule__ConditionalBranch__ElementsAssignment_1_4 )
            // InternalXtext.g:4803:2: rule__ConditionalBranch__ElementsAssignment_1_4
            {
            pushFollow(FollowSets000.FOLLOW_30);
            rule__ConditionalBranch__ElementsAssignment_1_4();

            state._fsp--;


            }

             after(grammarAccess.getConditionalBranchAccess().getElementsAssignment_1_4()); 

            }

            // InternalXtext.g:4806:1: ( ( rule__ConditionalBranch__ElementsAssignment_1_4 )* )
            // InternalXtext.g:4807:1: ( rule__ConditionalBranch__ElementsAssignment_1_4 )*
            {
             before(grammarAccess.getConditionalBranchAccess().getElementsAssignment_1_4()); 
            // InternalXtext.g:4808:1: ( rule__ConditionalBranch__ElementsAssignment_1_4 )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( ((LA47_0>=RULE_ID && LA47_0<=RULE_STRING)||(LA47_0>=16 && LA47_0<=17)||LA47_0==22||LA47_0==36||LA47_0==43||LA47_0==49) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalXtext.g:4808:2: rule__ConditionalBranch__ElementsAssignment_1_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_30);
            	    rule__ConditionalBranch__ElementsAssignment_1_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

             after(grammarAccess.getConditionalBranchAccess().getElementsAssignment_1_4()); 

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
    // $ANTLR end "rule__ConditionalBranch__Group_1__4__Impl"


    // $ANTLR start "rule__UnorderedGroup__Group__0"
    // InternalXtext.g:4829:1: rule__UnorderedGroup__Group__0 : rule__UnorderedGroup__Group__0__Impl rule__UnorderedGroup__Group__1 ;
    public final void rule__UnorderedGroup__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4833:1: ( rule__UnorderedGroup__Group__0__Impl rule__UnorderedGroup__Group__1 )
            // InternalXtext.g:4834:2: rule__UnorderedGroup__Group__0__Impl rule__UnorderedGroup__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_31);
            rule__UnorderedGroup__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:4841:1: rule__UnorderedGroup__Group__0__Impl : ( ruleGroup ) ;
    public final void rule__UnorderedGroup__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4845:1: ( ( ruleGroup ) )
            // InternalXtext.g:4846:1: ( ruleGroup )
            {
            // InternalXtext.g:4846:1: ( ruleGroup )
            // InternalXtext.g:4847:1: ruleGroup
            {
             before(grammarAccess.getUnorderedGroupAccess().getGroupParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:4858:1: rule__UnorderedGroup__Group__1 : rule__UnorderedGroup__Group__1__Impl ;
    public final void rule__UnorderedGroup__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4862:1: ( rule__UnorderedGroup__Group__1__Impl )
            // InternalXtext.g:4863:2: rule__UnorderedGroup__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:4869:1: rule__UnorderedGroup__Group__1__Impl : ( ( rule__UnorderedGroup__Group_1__0 )? ) ;
    public final void rule__UnorderedGroup__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4873:1: ( ( ( rule__UnorderedGroup__Group_1__0 )? ) )
            // InternalXtext.g:4874:1: ( ( rule__UnorderedGroup__Group_1__0 )? )
            {
            // InternalXtext.g:4874:1: ( ( rule__UnorderedGroup__Group_1__0 )? )
            // InternalXtext.g:4875:1: ( rule__UnorderedGroup__Group_1__0 )?
            {
             before(grammarAccess.getUnorderedGroupAccess().getGroup_1()); 
            // InternalXtext.g:4876:1: ( rule__UnorderedGroup__Group_1__0 )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==35) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalXtext.g:4876:2: rule__UnorderedGroup__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:4890:1: rule__UnorderedGroup__Group_1__0 : rule__UnorderedGroup__Group_1__0__Impl rule__UnorderedGroup__Group_1__1 ;
    public final void rule__UnorderedGroup__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4894:1: ( rule__UnorderedGroup__Group_1__0__Impl rule__UnorderedGroup__Group_1__1 )
            // InternalXtext.g:4895:2: rule__UnorderedGroup__Group_1__0__Impl rule__UnorderedGroup__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_31);
            rule__UnorderedGroup__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:4902:1: rule__UnorderedGroup__Group_1__0__Impl : ( () ) ;
    public final void rule__UnorderedGroup__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4906:1: ( ( () ) )
            // InternalXtext.g:4907:1: ( () )
            {
            // InternalXtext.g:4907:1: ( () )
            // InternalXtext.g:4908:1: ()
            {
             before(grammarAccess.getUnorderedGroupAccess().getUnorderedGroupElementsAction_1_0()); 
            // InternalXtext.g:4909:1: ()
            // InternalXtext.g:4911:1: 
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
    // InternalXtext.g:4921:1: rule__UnorderedGroup__Group_1__1 : rule__UnorderedGroup__Group_1__1__Impl ;
    public final void rule__UnorderedGroup__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4925:1: ( rule__UnorderedGroup__Group_1__1__Impl )
            // InternalXtext.g:4926:2: rule__UnorderedGroup__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:4932:1: rule__UnorderedGroup__Group_1__1__Impl : ( ( ( rule__UnorderedGroup__Group_1_1__0 ) ) ( ( rule__UnorderedGroup__Group_1_1__0 )* ) ) ;
    public final void rule__UnorderedGroup__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4936:1: ( ( ( ( rule__UnorderedGroup__Group_1_1__0 ) ) ( ( rule__UnorderedGroup__Group_1_1__0 )* ) ) )
            // InternalXtext.g:4937:1: ( ( ( rule__UnorderedGroup__Group_1_1__0 ) ) ( ( rule__UnorderedGroup__Group_1_1__0 )* ) )
            {
            // InternalXtext.g:4937:1: ( ( ( rule__UnorderedGroup__Group_1_1__0 ) ) ( ( rule__UnorderedGroup__Group_1_1__0 )* ) )
            // InternalXtext.g:4938:1: ( ( rule__UnorderedGroup__Group_1_1__0 ) ) ( ( rule__UnorderedGroup__Group_1_1__0 )* )
            {
            // InternalXtext.g:4938:1: ( ( rule__UnorderedGroup__Group_1_1__0 ) )
            // InternalXtext.g:4939:1: ( rule__UnorderedGroup__Group_1_1__0 )
            {
             before(grammarAccess.getUnorderedGroupAccess().getGroup_1_1()); 
            // InternalXtext.g:4940:1: ( rule__UnorderedGroup__Group_1_1__0 )
            // InternalXtext.g:4940:2: rule__UnorderedGroup__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_32);
            rule__UnorderedGroup__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getUnorderedGroupAccess().getGroup_1_1()); 

            }

            // InternalXtext.g:4943:1: ( ( rule__UnorderedGroup__Group_1_1__0 )* )
            // InternalXtext.g:4944:1: ( rule__UnorderedGroup__Group_1_1__0 )*
            {
             before(grammarAccess.getUnorderedGroupAccess().getGroup_1_1()); 
            // InternalXtext.g:4945:1: ( rule__UnorderedGroup__Group_1_1__0 )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==35) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalXtext.g:4945:2: rule__UnorderedGroup__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_32);
            	    rule__UnorderedGroup__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop49;
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
    // InternalXtext.g:4960:1: rule__UnorderedGroup__Group_1_1__0 : rule__UnorderedGroup__Group_1_1__0__Impl rule__UnorderedGroup__Group_1_1__1 ;
    public final void rule__UnorderedGroup__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4964:1: ( rule__UnorderedGroup__Group_1_1__0__Impl rule__UnorderedGroup__Group_1_1__1 )
            // InternalXtext.g:4965:2: rule__UnorderedGroup__Group_1_1__0__Impl rule__UnorderedGroup__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_29);
            rule__UnorderedGroup__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:4972:1: rule__UnorderedGroup__Group_1_1__0__Impl : ( '&' ) ;
    public final void rule__UnorderedGroup__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4976:1: ( ( '&' ) )
            // InternalXtext.g:4977:1: ( '&' )
            {
            // InternalXtext.g:4977:1: ( '&' )
            // InternalXtext.g:4978:1: '&'
            {
             before(grammarAccess.getUnorderedGroupAccess().getAmpersandKeyword_1_1_0()); 
            match(input,35,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:4991:1: rule__UnorderedGroup__Group_1_1__1 : rule__UnorderedGroup__Group_1_1__1__Impl ;
    public final void rule__UnorderedGroup__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:4995:1: ( rule__UnorderedGroup__Group_1_1__1__Impl )
            // InternalXtext.g:4996:2: rule__UnorderedGroup__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:5002:1: rule__UnorderedGroup__Group_1_1__1__Impl : ( ( rule__UnorderedGroup__ElementsAssignment_1_1_1 ) ) ;
    public final void rule__UnorderedGroup__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5006:1: ( ( ( rule__UnorderedGroup__ElementsAssignment_1_1_1 ) ) )
            // InternalXtext.g:5007:1: ( ( rule__UnorderedGroup__ElementsAssignment_1_1_1 ) )
            {
            // InternalXtext.g:5007:1: ( ( rule__UnorderedGroup__ElementsAssignment_1_1_1 ) )
            // InternalXtext.g:5008:1: ( rule__UnorderedGroup__ElementsAssignment_1_1_1 )
            {
             before(grammarAccess.getUnorderedGroupAccess().getElementsAssignment_1_1_1()); 
            // InternalXtext.g:5009:1: ( rule__UnorderedGroup__ElementsAssignment_1_1_1 )
            // InternalXtext.g:5009:2: rule__UnorderedGroup__ElementsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:5023:1: rule__Group__Group__0 : rule__Group__Group__0__Impl rule__Group__Group__1 ;
    public final void rule__Group__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5027:1: ( rule__Group__Group__0__Impl rule__Group__Group__1 )
            // InternalXtext.g:5028:2: rule__Group__Group__0__Impl rule__Group__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_29);
            rule__Group__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:5035:1: rule__Group__Group__0__Impl : ( ruleAbstractToken ) ;
    public final void rule__Group__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5039:1: ( ( ruleAbstractToken ) )
            // InternalXtext.g:5040:1: ( ruleAbstractToken )
            {
            // InternalXtext.g:5040:1: ( ruleAbstractToken )
            // InternalXtext.g:5041:1: ruleAbstractToken
            {
             before(grammarAccess.getGroupAccess().getAbstractTokenParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:5052:1: rule__Group__Group__1 : rule__Group__Group__1__Impl ;
    public final void rule__Group__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5056:1: ( rule__Group__Group__1__Impl )
            // InternalXtext.g:5057:2: rule__Group__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:5063:1: rule__Group__Group__1__Impl : ( ( rule__Group__Group_1__0 )? ) ;
    public final void rule__Group__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5067:1: ( ( ( rule__Group__Group_1__0 )? ) )
            // InternalXtext.g:5068:1: ( ( rule__Group__Group_1__0 )? )
            {
            // InternalXtext.g:5068:1: ( ( rule__Group__Group_1__0 )? )
            // InternalXtext.g:5069:1: ( rule__Group__Group_1__0 )?
            {
             before(grammarAccess.getGroupAccess().getGroup_1()); 
            // InternalXtext.g:5070:1: ( rule__Group__Group_1__0 )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( ((LA50_0>=RULE_ID && LA50_0<=RULE_STRING)||(LA50_0>=16 && LA50_0<=17)||LA50_0==22||LA50_0==36||LA50_0==43||LA50_0==49) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalXtext.g:5070:2: rule__Group__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:5084:1: rule__Group__Group_1__0 : rule__Group__Group_1__0__Impl rule__Group__Group_1__1 ;
    public final void rule__Group__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5088:1: ( rule__Group__Group_1__0__Impl rule__Group__Group_1__1 )
            // InternalXtext.g:5089:2: rule__Group__Group_1__0__Impl rule__Group__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_29);
            rule__Group__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:5096:1: rule__Group__Group_1__0__Impl : ( () ) ;
    public final void rule__Group__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5100:1: ( ( () ) )
            // InternalXtext.g:5101:1: ( () )
            {
            // InternalXtext.g:5101:1: ( () )
            // InternalXtext.g:5102:1: ()
            {
             before(grammarAccess.getGroupAccess().getGroupElementsAction_1_0()); 
            // InternalXtext.g:5103:1: ()
            // InternalXtext.g:5105:1: 
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
    // InternalXtext.g:5115:1: rule__Group__Group_1__1 : rule__Group__Group_1__1__Impl ;
    public final void rule__Group__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5119:1: ( rule__Group__Group_1__1__Impl )
            // InternalXtext.g:5120:2: rule__Group__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:5126:1: rule__Group__Group_1__1__Impl : ( ( ( rule__Group__ElementsAssignment_1_1 ) ) ( ( rule__Group__ElementsAssignment_1_1 )* ) ) ;
    public final void rule__Group__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5130:1: ( ( ( ( rule__Group__ElementsAssignment_1_1 ) ) ( ( rule__Group__ElementsAssignment_1_1 )* ) ) )
            // InternalXtext.g:5131:1: ( ( ( rule__Group__ElementsAssignment_1_1 ) ) ( ( rule__Group__ElementsAssignment_1_1 )* ) )
            {
            // InternalXtext.g:5131:1: ( ( ( rule__Group__ElementsAssignment_1_1 ) ) ( ( rule__Group__ElementsAssignment_1_1 )* ) )
            // InternalXtext.g:5132:1: ( ( rule__Group__ElementsAssignment_1_1 ) ) ( ( rule__Group__ElementsAssignment_1_1 )* )
            {
            // InternalXtext.g:5132:1: ( ( rule__Group__ElementsAssignment_1_1 ) )
            // InternalXtext.g:5133:1: ( rule__Group__ElementsAssignment_1_1 )
            {
             before(grammarAccess.getGroupAccess().getElementsAssignment_1_1()); 
            // InternalXtext.g:5134:1: ( rule__Group__ElementsAssignment_1_1 )
            // InternalXtext.g:5134:2: rule__Group__ElementsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_30);
            rule__Group__ElementsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getGroupAccess().getElementsAssignment_1_1()); 

            }

            // InternalXtext.g:5137:1: ( ( rule__Group__ElementsAssignment_1_1 )* )
            // InternalXtext.g:5138:1: ( rule__Group__ElementsAssignment_1_1 )*
            {
             before(grammarAccess.getGroupAccess().getElementsAssignment_1_1()); 
            // InternalXtext.g:5139:1: ( rule__Group__ElementsAssignment_1_1 )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( ((LA51_0>=RULE_ID && LA51_0<=RULE_STRING)||(LA51_0>=16 && LA51_0<=17)||LA51_0==22||LA51_0==36||LA51_0==43||LA51_0==49) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalXtext.g:5139:2: rule__Group__ElementsAssignment_1_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_30);
            	    rule__Group__ElementsAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop51;
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
    // InternalXtext.g:5154:1: rule__AbstractTokenWithCardinality__Group__0 : rule__AbstractTokenWithCardinality__Group__0__Impl rule__AbstractTokenWithCardinality__Group__1 ;
    public final void rule__AbstractTokenWithCardinality__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5158:1: ( rule__AbstractTokenWithCardinality__Group__0__Impl rule__AbstractTokenWithCardinality__Group__1 )
            // InternalXtext.g:5159:2: rule__AbstractTokenWithCardinality__Group__0__Impl rule__AbstractTokenWithCardinality__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_33);
            rule__AbstractTokenWithCardinality__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:5166:1: rule__AbstractTokenWithCardinality__Group__0__Impl : ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) ) ;
    public final void rule__AbstractTokenWithCardinality__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5170:1: ( ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) ) )
            // InternalXtext.g:5171:1: ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) )
            {
            // InternalXtext.g:5171:1: ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) )
            // InternalXtext.g:5172:1: ( rule__AbstractTokenWithCardinality__Alternatives_0 )
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getAlternatives_0()); 
            // InternalXtext.g:5173:1: ( rule__AbstractTokenWithCardinality__Alternatives_0 )
            // InternalXtext.g:5173:2: rule__AbstractTokenWithCardinality__Alternatives_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:5183:1: rule__AbstractTokenWithCardinality__Group__1 : rule__AbstractTokenWithCardinality__Group__1__Impl ;
    public final void rule__AbstractTokenWithCardinality__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5187:1: ( rule__AbstractTokenWithCardinality__Group__1__Impl )
            // InternalXtext.g:5188:2: rule__AbstractTokenWithCardinality__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:5194:1: rule__AbstractTokenWithCardinality__Group__1__Impl : ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? ) ;
    public final void rule__AbstractTokenWithCardinality__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5198:1: ( ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? ) )
            // InternalXtext.g:5199:1: ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? )
            {
            // InternalXtext.g:5199:1: ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? )
            // InternalXtext.g:5200:1: ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )?
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAssignment_1()); 
            // InternalXtext.g:5201:1: ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( ((LA52_0>=11 && LA52_0<=13)) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalXtext.g:5201:2: rule__AbstractTokenWithCardinality__CardinalityAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:5215:1: rule__Action__Group__0 : rule__Action__Group__0__Impl rule__Action__Group__1 ;
    public final void rule__Action__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5219:1: ( rule__Action__Group__0__Impl rule__Action__Group__1 )
            // InternalXtext.g:5220:2: rule__Action__Group__0__Impl rule__Action__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_20);
            rule__Action__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:5227:1: rule__Action__Group__0__Impl : ( '{' ) ;
    public final void rule__Action__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5231:1: ( ( '{' ) )
            // InternalXtext.g:5232:1: ( '{' )
            {
            // InternalXtext.g:5232:1: ( '{' )
            // InternalXtext.g:5233:1: '{'
            {
             before(grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,36,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:5246:1: rule__Action__Group__1 : rule__Action__Group__1__Impl rule__Action__Group__2 ;
    public final void rule__Action__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5250:1: ( rule__Action__Group__1__Impl rule__Action__Group__2 )
            // InternalXtext.g:5251:2: rule__Action__Group__1__Impl rule__Action__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_34);
            rule__Action__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:5258:1: rule__Action__Group__1__Impl : ( ( rule__Action__TypeAssignment_1 ) ) ;
    public final void rule__Action__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5262:1: ( ( ( rule__Action__TypeAssignment_1 ) ) )
            // InternalXtext.g:5263:1: ( ( rule__Action__TypeAssignment_1 ) )
            {
            // InternalXtext.g:5263:1: ( ( rule__Action__TypeAssignment_1 ) )
            // InternalXtext.g:5264:1: ( rule__Action__TypeAssignment_1 )
            {
             before(grammarAccess.getActionAccess().getTypeAssignment_1()); 
            // InternalXtext.g:5265:1: ( rule__Action__TypeAssignment_1 )
            // InternalXtext.g:5265:2: rule__Action__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:5275:1: rule__Action__Group__2 : rule__Action__Group__2__Impl rule__Action__Group__3 ;
    public final void rule__Action__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5279:1: ( rule__Action__Group__2__Impl rule__Action__Group__3 )
            // InternalXtext.g:5280:2: rule__Action__Group__2__Impl rule__Action__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_34);
            rule__Action__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:5287:1: rule__Action__Group__2__Impl : ( ( rule__Action__Group_2__0 )? ) ;
    public final void rule__Action__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5291:1: ( ( ( rule__Action__Group_2__0 )? ) )
            // InternalXtext.g:5292:1: ( ( rule__Action__Group_2__0 )? )
            {
            // InternalXtext.g:5292:1: ( ( rule__Action__Group_2__0 )? )
            // InternalXtext.g:5293:1: ( rule__Action__Group_2__0 )?
            {
             before(grammarAccess.getActionAccess().getGroup_2()); 
            // InternalXtext.g:5294:1: ( rule__Action__Group_2__0 )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==24) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalXtext.g:5294:2: rule__Action__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:5304:1: rule__Action__Group__3 : rule__Action__Group__3__Impl ;
    public final void rule__Action__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5308:1: ( rule__Action__Group__3__Impl )
            // InternalXtext.g:5309:2: rule__Action__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:5315:1: rule__Action__Group__3__Impl : ( '}' ) ;
    public final void rule__Action__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5319:1: ( ( '}' ) )
            // InternalXtext.g:5320:1: ( '}' )
            {
            // InternalXtext.g:5320:1: ( '}' )
            // InternalXtext.g:5321:1: '}'
            {
             before(grammarAccess.getActionAccess().getRightCurlyBracketKeyword_3()); 
            match(input,37,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:5342:1: rule__Action__Group_2__0 : rule__Action__Group_2__0__Impl rule__Action__Group_2__1 ;
    public final void rule__Action__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5346:1: ( rule__Action__Group_2__0__Impl rule__Action__Group_2__1 )
            // InternalXtext.g:5347:2: rule__Action__Group_2__0__Impl rule__Action__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Action__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:5354:1: rule__Action__Group_2__0__Impl : ( '.' ) ;
    public final void rule__Action__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5358:1: ( ( '.' ) )
            // InternalXtext.g:5359:1: ( '.' )
            {
            // InternalXtext.g:5359:1: ( '.' )
            // InternalXtext.g:5360:1: '.'
            {
             before(grammarAccess.getActionAccess().getFullStopKeyword_2_0()); 
            match(input,24,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:5373:1: rule__Action__Group_2__1 : rule__Action__Group_2__1__Impl rule__Action__Group_2__2 ;
    public final void rule__Action__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5377:1: ( rule__Action__Group_2__1__Impl rule__Action__Group_2__2 )
            // InternalXtext.g:5378:2: rule__Action__Group_2__1__Impl rule__Action__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_35);
            rule__Action__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:5385:1: rule__Action__Group_2__1__Impl : ( ( rule__Action__FeatureAssignment_2_1 ) ) ;
    public final void rule__Action__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5389:1: ( ( ( rule__Action__FeatureAssignment_2_1 ) ) )
            // InternalXtext.g:5390:1: ( ( rule__Action__FeatureAssignment_2_1 ) )
            {
            // InternalXtext.g:5390:1: ( ( rule__Action__FeatureAssignment_2_1 ) )
            // InternalXtext.g:5391:1: ( rule__Action__FeatureAssignment_2_1 )
            {
             before(grammarAccess.getActionAccess().getFeatureAssignment_2_1()); 
            // InternalXtext.g:5392:1: ( rule__Action__FeatureAssignment_2_1 )
            // InternalXtext.g:5392:2: rule__Action__FeatureAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:5402:1: rule__Action__Group_2__2 : rule__Action__Group_2__2__Impl rule__Action__Group_2__3 ;
    public final void rule__Action__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5406:1: ( rule__Action__Group_2__2__Impl rule__Action__Group_2__3 )
            // InternalXtext.g:5407:2: rule__Action__Group_2__2__Impl rule__Action__Group_2__3
            {
            pushFollow(FollowSets000.FOLLOW_36);
            rule__Action__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:5414:1: rule__Action__Group_2__2__Impl : ( ( rule__Action__OperatorAssignment_2_2 ) ) ;
    public final void rule__Action__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5418:1: ( ( ( rule__Action__OperatorAssignment_2_2 ) ) )
            // InternalXtext.g:5419:1: ( ( rule__Action__OperatorAssignment_2_2 ) )
            {
            // InternalXtext.g:5419:1: ( ( rule__Action__OperatorAssignment_2_2 ) )
            // InternalXtext.g:5420:1: ( rule__Action__OperatorAssignment_2_2 )
            {
             before(grammarAccess.getActionAccess().getOperatorAssignment_2_2()); 
            // InternalXtext.g:5421:1: ( rule__Action__OperatorAssignment_2_2 )
            // InternalXtext.g:5421:2: rule__Action__OperatorAssignment_2_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:5431:1: rule__Action__Group_2__3 : rule__Action__Group_2__3__Impl ;
    public final void rule__Action__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5435:1: ( rule__Action__Group_2__3__Impl )
            // InternalXtext.g:5436:2: rule__Action__Group_2__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:5442:1: rule__Action__Group_2__3__Impl : ( 'current' ) ;
    public final void rule__Action__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5446:1: ( ( 'current' ) )
            // InternalXtext.g:5447:1: ( 'current' )
            {
            // InternalXtext.g:5447:1: ( 'current' )
            // InternalXtext.g:5448:1: 'current'
            {
             before(grammarAccess.getActionAccess().getCurrentKeyword_2_3()); 
            match(input,38,FollowSets000.FOLLOW_2); 
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


    // $ANTLR start "rule__RuleCall__Group__0"
    // InternalXtext.g:5469:1: rule__RuleCall__Group__0 : rule__RuleCall__Group__0__Impl rule__RuleCall__Group__1 ;
    public final void rule__RuleCall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5473:1: ( rule__RuleCall__Group__0__Impl rule__RuleCall__Group__1 )
            // InternalXtext.g:5474:2: rule__RuleCall__Group__0__Impl rule__RuleCall__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_22);
            rule__RuleCall__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleCall__Group__1();

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
    // $ANTLR end "rule__RuleCall__Group__0"


    // $ANTLR start "rule__RuleCall__Group__0__Impl"
    // InternalXtext.g:5481:1: rule__RuleCall__Group__0__Impl : ( ( rule__RuleCall__RuleAssignment_0 ) ) ;
    public final void rule__RuleCall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5485:1: ( ( ( rule__RuleCall__RuleAssignment_0 ) ) )
            // InternalXtext.g:5486:1: ( ( rule__RuleCall__RuleAssignment_0 ) )
            {
            // InternalXtext.g:5486:1: ( ( rule__RuleCall__RuleAssignment_0 ) )
            // InternalXtext.g:5487:1: ( rule__RuleCall__RuleAssignment_0 )
            {
             before(grammarAccess.getRuleCallAccess().getRuleAssignment_0()); 
            // InternalXtext.g:5488:1: ( rule__RuleCall__RuleAssignment_0 )
            // InternalXtext.g:5488:2: rule__RuleCall__RuleAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleCall__RuleAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getRuleCallAccess().getRuleAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__Group__0__Impl"


    // $ANTLR start "rule__RuleCall__Group__1"
    // InternalXtext.g:5498:1: rule__RuleCall__Group__1 : rule__RuleCall__Group__1__Impl ;
    public final void rule__RuleCall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5502:1: ( rule__RuleCall__Group__1__Impl )
            // InternalXtext.g:5503:2: rule__RuleCall__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleCall__Group__1__Impl();

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
    // $ANTLR end "rule__RuleCall__Group__1"


    // $ANTLR start "rule__RuleCall__Group__1__Impl"
    // InternalXtext.g:5509:1: rule__RuleCall__Group__1__Impl : ( ( rule__RuleCall__Group_1__0 )? ) ;
    public final void rule__RuleCall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5513:1: ( ( ( rule__RuleCall__Group_1__0 )? ) )
            // InternalXtext.g:5514:1: ( ( rule__RuleCall__Group_1__0 )? )
            {
            // InternalXtext.g:5514:1: ( ( rule__RuleCall__Group_1__0 )? )
            // InternalXtext.g:5515:1: ( rule__RuleCall__Group_1__0 )?
            {
             before(grammarAccess.getRuleCallAccess().getGroup_1()); 
            // InternalXtext.g:5516:1: ( rule__RuleCall__Group_1__0 )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==31) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalXtext.g:5516:2: rule__RuleCall__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__RuleCall__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRuleCallAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__Group__1__Impl"


    // $ANTLR start "rule__RuleCall__Group_1__0"
    // InternalXtext.g:5530:1: rule__RuleCall__Group_1__0 : rule__RuleCall__Group_1__0__Impl rule__RuleCall__Group_1__1 ;
    public final void rule__RuleCall__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5534:1: ( rule__RuleCall__Group_1__0__Impl rule__RuleCall__Group_1__1 )
            // InternalXtext.g:5535:2: rule__RuleCall__Group_1__0__Impl rule__RuleCall__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_27);
            rule__RuleCall__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleCall__Group_1__1();

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
    // $ANTLR end "rule__RuleCall__Group_1__0"


    // $ANTLR start "rule__RuleCall__Group_1__0__Impl"
    // InternalXtext.g:5542:1: rule__RuleCall__Group_1__0__Impl : ( '<' ) ;
    public final void rule__RuleCall__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5546:1: ( ( '<' ) )
            // InternalXtext.g:5547:1: ( '<' )
            {
            // InternalXtext.g:5547:1: ( '<' )
            // InternalXtext.g:5548:1: '<'
            {
             before(grammarAccess.getRuleCallAccess().getLessThanSignKeyword_1_0()); 
            match(input,31,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRuleCallAccess().getLessThanSignKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__Group_1__0__Impl"


    // $ANTLR start "rule__RuleCall__Group_1__1"
    // InternalXtext.g:5561:1: rule__RuleCall__Group_1__1 : rule__RuleCall__Group_1__1__Impl rule__RuleCall__Group_1__2 ;
    public final void rule__RuleCall__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5565:1: ( rule__RuleCall__Group_1__1__Impl rule__RuleCall__Group_1__2 )
            // InternalXtext.g:5566:2: rule__RuleCall__Group_1__1__Impl rule__RuleCall__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_37);
            rule__RuleCall__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleCall__Group_1__2();

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
    // $ANTLR end "rule__RuleCall__Group_1__1"


    // $ANTLR start "rule__RuleCall__Group_1__1__Impl"
    // InternalXtext.g:5573:1: rule__RuleCall__Group_1__1__Impl : ( ( rule__RuleCall__ArgumentsAssignment_1_1 ) ) ;
    public final void rule__RuleCall__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5577:1: ( ( ( rule__RuleCall__ArgumentsAssignment_1_1 ) ) )
            // InternalXtext.g:5578:1: ( ( rule__RuleCall__ArgumentsAssignment_1_1 ) )
            {
            // InternalXtext.g:5578:1: ( ( rule__RuleCall__ArgumentsAssignment_1_1 ) )
            // InternalXtext.g:5579:1: ( rule__RuleCall__ArgumentsAssignment_1_1 )
            {
             before(grammarAccess.getRuleCallAccess().getArgumentsAssignment_1_1()); 
            // InternalXtext.g:5580:1: ( rule__RuleCall__ArgumentsAssignment_1_1 )
            // InternalXtext.g:5580:2: rule__RuleCall__ArgumentsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleCall__ArgumentsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getRuleCallAccess().getArgumentsAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__Group_1__1__Impl"


    // $ANTLR start "rule__RuleCall__Group_1__2"
    // InternalXtext.g:5590:1: rule__RuleCall__Group_1__2 : rule__RuleCall__Group_1__2__Impl rule__RuleCall__Group_1__3 ;
    public final void rule__RuleCall__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5594:1: ( rule__RuleCall__Group_1__2__Impl rule__RuleCall__Group_1__3 )
            // InternalXtext.g:5595:2: rule__RuleCall__Group_1__2__Impl rule__RuleCall__Group_1__3
            {
            pushFollow(FollowSets000.FOLLOW_37);
            rule__RuleCall__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleCall__Group_1__3();

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
    // $ANTLR end "rule__RuleCall__Group_1__2"


    // $ANTLR start "rule__RuleCall__Group_1__2__Impl"
    // InternalXtext.g:5602:1: rule__RuleCall__Group_1__2__Impl : ( ( rule__RuleCall__Group_1_2__0 )* ) ;
    public final void rule__RuleCall__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5606:1: ( ( ( rule__RuleCall__Group_1_2__0 )* ) )
            // InternalXtext.g:5607:1: ( ( rule__RuleCall__Group_1_2__0 )* )
            {
            // InternalXtext.g:5607:1: ( ( rule__RuleCall__Group_1_2__0 )* )
            // InternalXtext.g:5608:1: ( rule__RuleCall__Group_1_2__0 )*
            {
             before(grammarAccess.getRuleCallAccess().getGroup_1_2()); 
            // InternalXtext.g:5609:1: ( rule__RuleCall__Group_1_2__0 )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==21) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalXtext.g:5609:2: rule__RuleCall__Group_1_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    rule__RuleCall__Group_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);

             after(grammarAccess.getRuleCallAccess().getGroup_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__Group_1__2__Impl"


    // $ANTLR start "rule__RuleCall__Group_1__3"
    // InternalXtext.g:5619:1: rule__RuleCall__Group_1__3 : rule__RuleCall__Group_1__3__Impl ;
    public final void rule__RuleCall__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5623:1: ( rule__RuleCall__Group_1__3__Impl )
            // InternalXtext.g:5624:2: rule__RuleCall__Group_1__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleCall__Group_1__3__Impl();

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
    // $ANTLR end "rule__RuleCall__Group_1__3"


    // $ANTLR start "rule__RuleCall__Group_1__3__Impl"
    // InternalXtext.g:5630:1: rule__RuleCall__Group_1__3__Impl : ( '>' ) ;
    public final void rule__RuleCall__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5634:1: ( ( '>' ) )
            // InternalXtext.g:5635:1: ( '>' )
            {
            // InternalXtext.g:5635:1: ( '>' )
            // InternalXtext.g:5636:1: '>'
            {
             before(grammarAccess.getRuleCallAccess().getGreaterThanSignKeyword_1_3()); 
            match(input,32,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRuleCallAccess().getGreaterThanSignKeyword_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__Group_1__3__Impl"


    // $ANTLR start "rule__RuleCall__Group_1_2__0"
    // InternalXtext.g:5657:1: rule__RuleCall__Group_1_2__0 : rule__RuleCall__Group_1_2__0__Impl rule__RuleCall__Group_1_2__1 ;
    public final void rule__RuleCall__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5661:1: ( rule__RuleCall__Group_1_2__0__Impl rule__RuleCall__Group_1_2__1 )
            // InternalXtext.g:5662:2: rule__RuleCall__Group_1_2__0__Impl rule__RuleCall__Group_1_2__1
            {
            pushFollow(FollowSets000.FOLLOW_27);
            rule__RuleCall__Group_1_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleCall__Group_1_2__1();

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
    // $ANTLR end "rule__RuleCall__Group_1_2__0"


    // $ANTLR start "rule__RuleCall__Group_1_2__0__Impl"
    // InternalXtext.g:5669:1: rule__RuleCall__Group_1_2__0__Impl : ( ',' ) ;
    public final void rule__RuleCall__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5673:1: ( ( ',' ) )
            // InternalXtext.g:5674:1: ( ',' )
            {
            // InternalXtext.g:5674:1: ( ',' )
            // InternalXtext.g:5675:1: ','
            {
             before(grammarAccess.getRuleCallAccess().getCommaKeyword_1_2_0()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRuleCallAccess().getCommaKeyword_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__Group_1_2__0__Impl"


    // $ANTLR start "rule__RuleCall__Group_1_2__1"
    // InternalXtext.g:5688:1: rule__RuleCall__Group_1_2__1 : rule__RuleCall__Group_1_2__1__Impl ;
    public final void rule__RuleCall__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5692:1: ( rule__RuleCall__Group_1_2__1__Impl )
            // InternalXtext.g:5693:2: rule__RuleCall__Group_1_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleCall__Group_1_2__1__Impl();

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
    // $ANTLR end "rule__RuleCall__Group_1_2__1"


    // $ANTLR start "rule__RuleCall__Group_1_2__1__Impl"
    // InternalXtext.g:5699:1: rule__RuleCall__Group_1_2__1__Impl : ( ( rule__RuleCall__ArgumentsAssignment_1_2_1 ) ) ;
    public final void rule__RuleCall__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5703:1: ( ( ( rule__RuleCall__ArgumentsAssignment_1_2_1 ) ) )
            // InternalXtext.g:5704:1: ( ( rule__RuleCall__ArgumentsAssignment_1_2_1 ) )
            {
            // InternalXtext.g:5704:1: ( ( rule__RuleCall__ArgumentsAssignment_1_2_1 ) )
            // InternalXtext.g:5705:1: ( rule__RuleCall__ArgumentsAssignment_1_2_1 )
            {
             before(grammarAccess.getRuleCallAccess().getArgumentsAssignment_1_2_1()); 
            // InternalXtext.g:5706:1: ( rule__RuleCall__ArgumentsAssignment_1_2_1 )
            // InternalXtext.g:5706:2: rule__RuleCall__ArgumentsAssignment_1_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleCall__ArgumentsAssignment_1_2_1();

            state._fsp--;


            }

             after(grammarAccess.getRuleCallAccess().getArgumentsAssignment_1_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__Group_1_2__1__Impl"


    // $ANTLR start "rule__NamedArgument__Group__0"
    // InternalXtext.g:5720:1: rule__NamedArgument__Group__0 : rule__NamedArgument__Group__0__Impl rule__NamedArgument__Group__1 ;
    public final void rule__NamedArgument__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5724:1: ( rule__NamedArgument__Group__0__Impl rule__NamedArgument__Group__1 )
            // InternalXtext.g:5725:2: rule__NamedArgument__Group__0__Impl rule__NamedArgument__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_27);
            rule__NamedArgument__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__NamedArgument__Group__1();

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
    // $ANTLR end "rule__NamedArgument__Group__0"


    // $ANTLR start "rule__NamedArgument__Group__0__Impl"
    // InternalXtext.g:5732:1: rule__NamedArgument__Group__0__Impl : ( ( rule__NamedArgument__Group_0__0 )? ) ;
    public final void rule__NamedArgument__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5736:1: ( ( ( rule__NamedArgument__Group_0__0 )? ) )
            // InternalXtext.g:5737:1: ( ( rule__NamedArgument__Group_0__0 )? )
            {
            // InternalXtext.g:5737:1: ( ( rule__NamedArgument__Group_0__0 )? )
            // InternalXtext.g:5738:1: ( rule__NamedArgument__Group_0__0 )?
            {
             before(grammarAccess.getNamedArgumentAccess().getGroup_0()); 
            // InternalXtext.g:5739:1: ( rule__NamedArgument__Group_0__0 )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==RULE_ID) ) {
                int LA56_1 = input.LA(2);

                if ( (LA56_1==14) ) {
                    alt56=1;
                }
            }
            switch (alt56) {
                case 1 :
                    // InternalXtext.g:5739:2: rule__NamedArgument__Group_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__NamedArgument__Group_0__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNamedArgumentAccess().getGroup_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__Group__0__Impl"


    // $ANTLR start "rule__NamedArgument__Group__1"
    // InternalXtext.g:5749:1: rule__NamedArgument__Group__1 : rule__NamedArgument__Group__1__Impl ;
    public final void rule__NamedArgument__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5753:1: ( rule__NamedArgument__Group__1__Impl )
            // InternalXtext.g:5754:2: rule__NamedArgument__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__NamedArgument__Group__1__Impl();

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
    // $ANTLR end "rule__NamedArgument__Group__1"


    // $ANTLR start "rule__NamedArgument__Group__1__Impl"
    // InternalXtext.g:5760:1: rule__NamedArgument__Group__1__Impl : ( ( rule__NamedArgument__ValueAssignment_1 ) ) ;
    public final void rule__NamedArgument__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5764:1: ( ( ( rule__NamedArgument__ValueAssignment_1 ) ) )
            // InternalXtext.g:5765:1: ( ( rule__NamedArgument__ValueAssignment_1 ) )
            {
            // InternalXtext.g:5765:1: ( ( rule__NamedArgument__ValueAssignment_1 ) )
            // InternalXtext.g:5766:1: ( rule__NamedArgument__ValueAssignment_1 )
            {
             before(grammarAccess.getNamedArgumentAccess().getValueAssignment_1()); 
            // InternalXtext.g:5767:1: ( rule__NamedArgument__ValueAssignment_1 )
            // InternalXtext.g:5767:2: rule__NamedArgument__ValueAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__NamedArgument__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getNamedArgumentAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__Group__1__Impl"


    // $ANTLR start "rule__NamedArgument__Group_0__0"
    // InternalXtext.g:5781:1: rule__NamedArgument__Group_0__0 : rule__NamedArgument__Group_0__0__Impl rule__NamedArgument__Group_0__1 ;
    public final void rule__NamedArgument__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5785:1: ( rule__NamedArgument__Group_0__0__Impl rule__NamedArgument__Group_0__1 )
            // InternalXtext.g:5786:2: rule__NamedArgument__Group_0__0__Impl rule__NamedArgument__Group_0__1
            {
            pushFollow(FollowSets000.FOLLOW_38);
            rule__NamedArgument__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__NamedArgument__Group_0__1();

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
    // $ANTLR end "rule__NamedArgument__Group_0__0"


    // $ANTLR start "rule__NamedArgument__Group_0__0__Impl"
    // InternalXtext.g:5793:1: rule__NamedArgument__Group_0__0__Impl : ( ( rule__NamedArgument__ParameterAssignment_0_0 ) ) ;
    public final void rule__NamedArgument__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5797:1: ( ( ( rule__NamedArgument__ParameterAssignment_0_0 ) ) )
            // InternalXtext.g:5798:1: ( ( rule__NamedArgument__ParameterAssignment_0_0 ) )
            {
            // InternalXtext.g:5798:1: ( ( rule__NamedArgument__ParameterAssignment_0_0 ) )
            // InternalXtext.g:5799:1: ( rule__NamedArgument__ParameterAssignment_0_0 )
            {
             before(grammarAccess.getNamedArgumentAccess().getParameterAssignment_0_0()); 
            // InternalXtext.g:5800:1: ( rule__NamedArgument__ParameterAssignment_0_0 )
            // InternalXtext.g:5800:2: rule__NamedArgument__ParameterAssignment_0_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__NamedArgument__ParameterAssignment_0_0();

            state._fsp--;


            }

             after(grammarAccess.getNamedArgumentAccess().getParameterAssignment_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__Group_0__0__Impl"


    // $ANTLR start "rule__NamedArgument__Group_0__1"
    // InternalXtext.g:5810:1: rule__NamedArgument__Group_0__1 : rule__NamedArgument__Group_0__1__Impl ;
    public final void rule__NamedArgument__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5814:1: ( rule__NamedArgument__Group_0__1__Impl )
            // InternalXtext.g:5815:2: rule__NamedArgument__Group_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__NamedArgument__Group_0__1__Impl();

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
    // $ANTLR end "rule__NamedArgument__Group_0__1"


    // $ANTLR start "rule__NamedArgument__Group_0__1__Impl"
    // InternalXtext.g:5821:1: rule__NamedArgument__Group_0__1__Impl : ( ( rule__NamedArgument__CalledByNameAssignment_0_1 ) ) ;
    public final void rule__NamedArgument__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5825:1: ( ( ( rule__NamedArgument__CalledByNameAssignment_0_1 ) ) )
            // InternalXtext.g:5826:1: ( ( rule__NamedArgument__CalledByNameAssignment_0_1 ) )
            {
            // InternalXtext.g:5826:1: ( ( rule__NamedArgument__CalledByNameAssignment_0_1 ) )
            // InternalXtext.g:5827:1: ( rule__NamedArgument__CalledByNameAssignment_0_1 )
            {
             before(grammarAccess.getNamedArgumentAccess().getCalledByNameAssignment_0_1()); 
            // InternalXtext.g:5828:1: ( rule__NamedArgument__CalledByNameAssignment_0_1 )
            // InternalXtext.g:5828:2: rule__NamedArgument__CalledByNameAssignment_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__NamedArgument__CalledByNameAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getNamedArgumentAccess().getCalledByNameAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__Group_0__1__Impl"


    // $ANTLR start "rule__LiteralCondition__Group__0"
    // InternalXtext.g:5842:1: rule__LiteralCondition__Group__0 : rule__LiteralCondition__Group__0__Impl rule__LiteralCondition__Group__1 ;
    public final void rule__LiteralCondition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5846:1: ( rule__LiteralCondition__Group__0__Impl rule__LiteralCondition__Group__1 )
            // InternalXtext.g:5847:2: rule__LiteralCondition__Group__0__Impl rule__LiteralCondition__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_39);
            rule__LiteralCondition__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__LiteralCondition__Group__1();

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
    // $ANTLR end "rule__LiteralCondition__Group__0"


    // $ANTLR start "rule__LiteralCondition__Group__0__Impl"
    // InternalXtext.g:5854:1: rule__LiteralCondition__Group__0__Impl : ( () ) ;
    public final void rule__LiteralCondition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5858:1: ( ( () ) )
            // InternalXtext.g:5859:1: ( () )
            {
            // InternalXtext.g:5859:1: ( () )
            // InternalXtext.g:5860:1: ()
            {
             before(grammarAccess.getLiteralConditionAccess().getLiteralConditionAction_0()); 
            // InternalXtext.g:5861:1: ()
            // InternalXtext.g:5863:1: 
            {
            }

             after(grammarAccess.getLiteralConditionAccess().getLiteralConditionAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralCondition__Group__0__Impl"


    // $ANTLR start "rule__LiteralCondition__Group__1"
    // InternalXtext.g:5873:1: rule__LiteralCondition__Group__1 : rule__LiteralCondition__Group__1__Impl ;
    public final void rule__LiteralCondition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5877:1: ( rule__LiteralCondition__Group__1__Impl )
            // InternalXtext.g:5878:2: rule__LiteralCondition__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__LiteralCondition__Group__1__Impl();

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
    // $ANTLR end "rule__LiteralCondition__Group__1"


    // $ANTLR start "rule__LiteralCondition__Group__1__Impl"
    // InternalXtext.g:5884:1: rule__LiteralCondition__Group__1__Impl : ( ( rule__LiteralCondition__Alternatives_1 ) ) ;
    public final void rule__LiteralCondition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5888:1: ( ( ( rule__LiteralCondition__Alternatives_1 ) ) )
            // InternalXtext.g:5889:1: ( ( rule__LiteralCondition__Alternatives_1 ) )
            {
            // InternalXtext.g:5889:1: ( ( rule__LiteralCondition__Alternatives_1 ) )
            // InternalXtext.g:5890:1: ( rule__LiteralCondition__Alternatives_1 )
            {
             before(grammarAccess.getLiteralConditionAccess().getAlternatives_1()); 
            // InternalXtext.g:5891:1: ( rule__LiteralCondition__Alternatives_1 )
            // InternalXtext.g:5891:2: rule__LiteralCondition__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__LiteralCondition__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getLiteralConditionAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralCondition__Group__1__Impl"


    // $ANTLR start "rule__Disjunction__Group__0"
    // InternalXtext.g:5905:1: rule__Disjunction__Group__0 : rule__Disjunction__Group__0__Impl rule__Disjunction__Group__1 ;
    public final void rule__Disjunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5909:1: ( rule__Disjunction__Group__0__Impl rule__Disjunction__Group__1 )
            // InternalXtext.g:5910:2: rule__Disjunction__Group__0__Impl rule__Disjunction__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_25);
            rule__Disjunction__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Disjunction__Group__1();

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
    // $ANTLR end "rule__Disjunction__Group__0"


    // $ANTLR start "rule__Disjunction__Group__0__Impl"
    // InternalXtext.g:5917:1: rule__Disjunction__Group__0__Impl : ( ruleConjunction ) ;
    public final void rule__Disjunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5921:1: ( ( ruleConjunction ) )
            // InternalXtext.g:5922:1: ( ruleConjunction )
            {
            // InternalXtext.g:5922:1: ( ruleConjunction )
            // InternalXtext.g:5923:1: ruleConjunction
            {
             before(grammarAccess.getDisjunctionAccess().getConjunctionParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleConjunction();

            state._fsp--;

             after(grammarAccess.getDisjunctionAccess().getConjunctionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group__0__Impl"


    // $ANTLR start "rule__Disjunction__Group__1"
    // InternalXtext.g:5934:1: rule__Disjunction__Group__1 : rule__Disjunction__Group__1__Impl ;
    public final void rule__Disjunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5938:1: ( rule__Disjunction__Group__1__Impl )
            // InternalXtext.g:5939:2: rule__Disjunction__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Disjunction__Group__1__Impl();

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
    // $ANTLR end "rule__Disjunction__Group__1"


    // $ANTLR start "rule__Disjunction__Group__1__Impl"
    // InternalXtext.g:5945:1: rule__Disjunction__Group__1__Impl : ( ( rule__Disjunction__Group_1__0 )* ) ;
    public final void rule__Disjunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5949:1: ( ( ( rule__Disjunction__Group_1__0 )* ) )
            // InternalXtext.g:5950:1: ( ( rule__Disjunction__Group_1__0 )* )
            {
            // InternalXtext.g:5950:1: ( ( rule__Disjunction__Group_1__0 )* )
            // InternalXtext.g:5951:1: ( rule__Disjunction__Group_1__0 )*
            {
             before(grammarAccess.getDisjunctionAccess().getGroup_1()); 
            // InternalXtext.g:5952:1: ( rule__Disjunction__Group_1__0 )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==34) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalXtext.g:5952:2: rule__Disjunction__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_26);
            	    rule__Disjunction__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);

             after(grammarAccess.getDisjunctionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group__1__Impl"


    // $ANTLR start "rule__Disjunction__Group_1__0"
    // InternalXtext.g:5966:1: rule__Disjunction__Group_1__0 : rule__Disjunction__Group_1__0__Impl rule__Disjunction__Group_1__1 ;
    public final void rule__Disjunction__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5970:1: ( rule__Disjunction__Group_1__0__Impl rule__Disjunction__Group_1__1 )
            // InternalXtext.g:5971:2: rule__Disjunction__Group_1__0__Impl rule__Disjunction__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_25);
            rule__Disjunction__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Disjunction__Group_1__1();

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
    // $ANTLR end "rule__Disjunction__Group_1__0"


    // $ANTLR start "rule__Disjunction__Group_1__0__Impl"
    // InternalXtext.g:5978:1: rule__Disjunction__Group_1__0__Impl : ( () ) ;
    public final void rule__Disjunction__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:5982:1: ( ( () ) )
            // InternalXtext.g:5983:1: ( () )
            {
            // InternalXtext.g:5983:1: ( () )
            // InternalXtext.g:5984:1: ()
            {
             before(grammarAccess.getDisjunctionAccess().getDisjunctionLeftAction_1_0()); 
            // InternalXtext.g:5985:1: ()
            // InternalXtext.g:5987:1: 
            {
            }

             after(grammarAccess.getDisjunctionAccess().getDisjunctionLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_1__0__Impl"


    // $ANTLR start "rule__Disjunction__Group_1__1"
    // InternalXtext.g:5997:1: rule__Disjunction__Group_1__1 : rule__Disjunction__Group_1__1__Impl rule__Disjunction__Group_1__2 ;
    public final void rule__Disjunction__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6001:1: ( rule__Disjunction__Group_1__1__Impl rule__Disjunction__Group_1__2 )
            // InternalXtext.g:6002:2: rule__Disjunction__Group_1__1__Impl rule__Disjunction__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_27);
            rule__Disjunction__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Disjunction__Group_1__2();

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
    // $ANTLR end "rule__Disjunction__Group_1__1"


    // $ANTLR start "rule__Disjunction__Group_1__1__Impl"
    // InternalXtext.g:6009:1: rule__Disjunction__Group_1__1__Impl : ( '|' ) ;
    public final void rule__Disjunction__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6013:1: ( ( '|' ) )
            // InternalXtext.g:6014:1: ( '|' )
            {
            // InternalXtext.g:6014:1: ( '|' )
            // InternalXtext.g:6015:1: '|'
            {
             before(grammarAccess.getDisjunctionAccess().getVerticalLineKeyword_1_1()); 
            match(input,34,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getDisjunctionAccess().getVerticalLineKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_1__1__Impl"


    // $ANTLR start "rule__Disjunction__Group_1__2"
    // InternalXtext.g:6028:1: rule__Disjunction__Group_1__2 : rule__Disjunction__Group_1__2__Impl ;
    public final void rule__Disjunction__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6032:1: ( rule__Disjunction__Group_1__2__Impl )
            // InternalXtext.g:6033:2: rule__Disjunction__Group_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Disjunction__Group_1__2__Impl();

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
    // $ANTLR end "rule__Disjunction__Group_1__2"


    // $ANTLR start "rule__Disjunction__Group_1__2__Impl"
    // InternalXtext.g:6039:1: rule__Disjunction__Group_1__2__Impl : ( ( rule__Disjunction__RightAssignment_1_2 ) ) ;
    public final void rule__Disjunction__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6043:1: ( ( ( rule__Disjunction__RightAssignment_1_2 ) ) )
            // InternalXtext.g:6044:1: ( ( rule__Disjunction__RightAssignment_1_2 ) )
            {
            // InternalXtext.g:6044:1: ( ( rule__Disjunction__RightAssignment_1_2 ) )
            // InternalXtext.g:6045:1: ( rule__Disjunction__RightAssignment_1_2 )
            {
             before(grammarAccess.getDisjunctionAccess().getRightAssignment_1_2()); 
            // InternalXtext.g:6046:1: ( rule__Disjunction__RightAssignment_1_2 )
            // InternalXtext.g:6046:2: rule__Disjunction__RightAssignment_1_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Disjunction__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getDisjunctionAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_1__2__Impl"


    // $ANTLR start "rule__Conjunction__Group__0"
    // InternalXtext.g:6062:1: rule__Conjunction__Group__0 : rule__Conjunction__Group__0__Impl rule__Conjunction__Group__1 ;
    public final void rule__Conjunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6066:1: ( rule__Conjunction__Group__0__Impl rule__Conjunction__Group__1 )
            // InternalXtext.g:6067:2: rule__Conjunction__Group__0__Impl rule__Conjunction__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_31);
            rule__Conjunction__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Conjunction__Group__1();

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
    // $ANTLR end "rule__Conjunction__Group__0"


    // $ANTLR start "rule__Conjunction__Group__0__Impl"
    // InternalXtext.g:6074:1: rule__Conjunction__Group__0__Impl : ( ruleNegation ) ;
    public final void rule__Conjunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6078:1: ( ( ruleNegation ) )
            // InternalXtext.g:6079:1: ( ruleNegation )
            {
            // InternalXtext.g:6079:1: ( ruleNegation )
            // InternalXtext.g:6080:1: ruleNegation
            {
             before(grammarAccess.getConjunctionAccess().getNegationParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleNegation();

            state._fsp--;

             after(grammarAccess.getConjunctionAccess().getNegationParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group__0__Impl"


    // $ANTLR start "rule__Conjunction__Group__1"
    // InternalXtext.g:6091:1: rule__Conjunction__Group__1 : rule__Conjunction__Group__1__Impl ;
    public final void rule__Conjunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6095:1: ( rule__Conjunction__Group__1__Impl )
            // InternalXtext.g:6096:2: rule__Conjunction__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Conjunction__Group__1__Impl();

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
    // $ANTLR end "rule__Conjunction__Group__1"


    // $ANTLR start "rule__Conjunction__Group__1__Impl"
    // InternalXtext.g:6102:1: rule__Conjunction__Group__1__Impl : ( ( rule__Conjunction__Group_1__0 )* ) ;
    public final void rule__Conjunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6106:1: ( ( ( rule__Conjunction__Group_1__0 )* ) )
            // InternalXtext.g:6107:1: ( ( rule__Conjunction__Group_1__0 )* )
            {
            // InternalXtext.g:6107:1: ( ( rule__Conjunction__Group_1__0 )* )
            // InternalXtext.g:6108:1: ( rule__Conjunction__Group_1__0 )*
            {
             before(grammarAccess.getConjunctionAccess().getGroup_1()); 
            // InternalXtext.g:6109:1: ( rule__Conjunction__Group_1__0 )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==35) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // InternalXtext.g:6109:2: rule__Conjunction__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_32);
            	    rule__Conjunction__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);

             after(grammarAccess.getConjunctionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group__1__Impl"


    // $ANTLR start "rule__Conjunction__Group_1__0"
    // InternalXtext.g:6123:1: rule__Conjunction__Group_1__0 : rule__Conjunction__Group_1__0__Impl rule__Conjunction__Group_1__1 ;
    public final void rule__Conjunction__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6127:1: ( rule__Conjunction__Group_1__0__Impl rule__Conjunction__Group_1__1 )
            // InternalXtext.g:6128:2: rule__Conjunction__Group_1__0__Impl rule__Conjunction__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_31);
            rule__Conjunction__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Conjunction__Group_1__1();

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
    // $ANTLR end "rule__Conjunction__Group_1__0"


    // $ANTLR start "rule__Conjunction__Group_1__0__Impl"
    // InternalXtext.g:6135:1: rule__Conjunction__Group_1__0__Impl : ( () ) ;
    public final void rule__Conjunction__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6139:1: ( ( () ) )
            // InternalXtext.g:6140:1: ( () )
            {
            // InternalXtext.g:6140:1: ( () )
            // InternalXtext.g:6141:1: ()
            {
             before(grammarAccess.getConjunctionAccess().getConjunctionLeftAction_1_0()); 
            // InternalXtext.g:6142:1: ()
            // InternalXtext.g:6144:1: 
            {
            }

             after(grammarAccess.getConjunctionAccess().getConjunctionLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group_1__0__Impl"


    // $ANTLR start "rule__Conjunction__Group_1__1"
    // InternalXtext.g:6154:1: rule__Conjunction__Group_1__1 : rule__Conjunction__Group_1__1__Impl rule__Conjunction__Group_1__2 ;
    public final void rule__Conjunction__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6158:1: ( rule__Conjunction__Group_1__1__Impl rule__Conjunction__Group_1__2 )
            // InternalXtext.g:6159:2: rule__Conjunction__Group_1__1__Impl rule__Conjunction__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_27);
            rule__Conjunction__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Conjunction__Group_1__2();

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
    // $ANTLR end "rule__Conjunction__Group_1__1"


    // $ANTLR start "rule__Conjunction__Group_1__1__Impl"
    // InternalXtext.g:6166:1: rule__Conjunction__Group_1__1__Impl : ( '&' ) ;
    public final void rule__Conjunction__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6170:1: ( ( '&' ) )
            // InternalXtext.g:6171:1: ( '&' )
            {
            // InternalXtext.g:6171:1: ( '&' )
            // InternalXtext.g:6172:1: '&'
            {
             before(grammarAccess.getConjunctionAccess().getAmpersandKeyword_1_1()); 
            match(input,35,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getConjunctionAccess().getAmpersandKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group_1__1__Impl"


    // $ANTLR start "rule__Conjunction__Group_1__2"
    // InternalXtext.g:6185:1: rule__Conjunction__Group_1__2 : rule__Conjunction__Group_1__2__Impl ;
    public final void rule__Conjunction__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6189:1: ( rule__Conjunction__Group_1__2__Impl )
            // InternalXtext.g:6190:2: rule__Conjunction__Group_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Conjunction__Group_1__2__Impl();

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
    // $ANTLR end "rule__Conjunction__Group_1__2"


    // $ANTLR start "rule__Conjunction__Group_1__2__Impl"
    // InternalXtext.g:6196:1: rule__Conjunction__Group_1__2__Impl : ( ( rule__Conjunction__RightAssignment_1_2 ) ) ;
    public final void rule__Conjunction__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6200:1: ( ( ( rule__Conjunction__RightAssignment_1_2 ) ) )
            // InternalXtext.g:6201:1: ( ( rule__Conjunction__RightAssignment_1_2 ) )
            {
            // InternalXtext.g:6201:1: ( ( rule__Conjunction__RightAssignment_1_2 ) )
            // InternalXtext.g:6202:1: ( rule__Conjunction__RightAssignment_1_2 )
            {
             before(grammarAccess.getConjunctionAccess().getRightAssignment_1_2()); 
            // InternalXtext.g:6203:1: ( rule__Conjunction__RightAssignment_1_2 )
            // InternalXtext.g:6203:2: rule__Conjunction__RightAssignment_1_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Conjunction__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getConjunctionAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group_1__2__Impl"


    // $ANTLR start "rule__Negation__Group_1__0"
    // InternalXtext.g:6219:1: rule__Negation__Group_1__0 : rule__Negation__Group_1__0__Impl rule__Negation__Group_1__1 ;
    public final void rule__Negation__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6223:1: ( rule__Negation__Group_1__0__Impl rule__Negation__Group_1__1 )
            // InternalXtext.g:6224:2: rule__Negation__Group_1__0__Impl rule__Negation__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_27);
            rule__Negation__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Negation__Group_1__1();

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
    // $ANTLR end "rule__Negation__Group_1__0"


    // $ANTLR start "rule__Negation__Group_1__0__Impl"
    // InternalXtext.g:6231:1: rule__Negation__Group_1__0__Impl : ( () ) ;
    public final void rule__Negation__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6235:1: ( ( () ) )
            // InternalXtext.g:6236:1: ( () )
            {
            // InternalXtext.g:6236:1: ( () )
            // InternalXtext.g:6237:1: ()
            {
             before(grammarAccess.getNegationAccess().getNegationAction_1_0()); 
            // InternalXtext.g:6238:1: ()
            // InternalXtext.g:6240:1: 
            {
            }

             after(grammarAccess.getNegationAccess().getNegationAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negation__Group_1__0__Impl"


    // $ANTLR start "rule__Negation__Group_1__1"
    // InternalXtext.g:6250:1: rule__Negation__Group_1__1 : rule__Negation__Group_1__1__Impl rule__Negation__Group_1__2 ;
    public final void rule__Negation__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6254:1: ( rule__Negation__Group_1__1__Impl rule__Negation__Group_1__2 )
            // InternalXtext.g:6255:2: rule__Negation__Group_1__1__Impl rule__Negation__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_27);
            rule__Negation__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Negation__Group_1__2();

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
    // $ANTLR end "rule__Negation__Group_1__1"


    // $ANTLR start "rule__Negation__Group_1__1__Impl"
    // InternalXtext.g:6262:1: rule__Negation__Group_1__1__Impl : ( '!' ) ;
    public final void rule__Negation__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6266:1: ( ( '!' ) )
            // InternalXtext.g:6267:1: ( '!' )
            {
            // InternalXtext.g:6267:1: ( '!' )
            // InternalXtext.g:6268:1: '!'
            {
             before(grammarAccess.getNegationAccess().getExclamationMarkKeyword_1_1()); 
            match(input,39,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getNegationAccess().getExclamationMarkKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negation__Group_1__1__Impl"


    // $ANTLR start "rule__Negation__Group_1__2"
    // InternalXtext.g:6281:1: rule__Negation__Group_1__2 : rule__Negation__Group_1__2__Impl ;
    public final void rule__Negation__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6285:1: ( rule__Negation__Group_1__2__Impl )
            // InternalXtext.g:6286:2: rule__Negation__Group_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Negation__Group_1__2__Impl();

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
    // $ANTLR end "rule__Negation__Group_1__2"


    // $ANTLR start "rule__Negation__Group_1__2__Impl"
    // InternalXtext.g:6292:1: rule__Negation__Group_1__2__Impl : ( ( rule__Negation__ValueAssignment_1_2 ) ) ;
    public final void rule__Negation__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6296:1: ( ( ( rule__Negation__ValueAssignment_1_2 ) ) )
            // InternalXtext.g:6297:1: ( ( rule__Negation__ValueAssignment_1_2 ) )
            {
            // InternalXtext.g:6297:1: ( ( rule__Negation__ValueAssignment_1_2 ) )
            // InternalXtext.g:6298:1: ( rule__Negation__ValueAssignment_1_2 )
            {
             before(grammarAccess.getNegationAccess().getValueAssignment_1_2()); 
            // InternalXtext.g:6299:1: ( rule__Negation__ValueAssignment_1_2 )
            // InternalXtext.g:6299:2: rule__Negation__ValueAssignment_1_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Negation__ValueAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getNegationAccess().getValueAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negation__Group_1__2__Impl"


    // $ANTLR start "rule__ParenthesizedCondition__Group__0"
    // InternalXtext.g:6315:1: rule__ParenthesizedCondition__Group__0 : rule__ParenthesizedCondition__Group__0__Impl rule__ParenthesizedCondition__Group__1 ;
    public final void rule__ParenthesizedCondition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6319:1: ( rule__ParenthesizedCondition__Group__0__Impl rule__ParenthesizedCondition__Group__1 )
            // InternalXtext.g:6320:2: rule__ParenthesizedCondition__Group__0__Impl rule__ParenthesizedCondition__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_27);
            rule__ParenthesizedCondition__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParenthesizedCondition__Group__1();

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
    // $ANTLR end "rule__ParenthesizedCondition__Group__0"


    // $ANTLR start "rule__ParenthesizedCondition__Group__0__Impl"
    // InternalXtext.g:6327:1: rule__ParenthesizedCondition__Group__0__Impl : ( '(' ) ;
    public final void rule__ParenthesizedCondition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6331:1: ( ( '(' ) )
            // InternalXtext.g:6332:1: ( '(' )
            {
            // InternalXtext.g:6332:1: ( '(' )
            // InternalXtext.g:6333:1: '('
            {
             before(grammarAccess.getParenthesizedConditionAccess().getLeftParenthesisKeyword_0()); 
            match(input,22,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParenthesizedConditionAccess().getLeftParenthesisKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedCondition__Group__0__Impl"


    // $ANTLR start "rule__ParenthesizedCondition__Group__1"
    // InternalXtext.g:6346:1: rule__ParenthesizedCondition__Group__1 : rule__ParenthesizedCondition__Group__1__Impl rule__ParenthesizedCondition__Group__2 ;
    public final void rule__ParenthesizedCondition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6350:1: ( rule__ParenthesizedCondition__Group__1__Impl rule__ParenthesizedCondition__Group__2 )
            // InternalXtext.g:6351:2: rule__ParenthesizedCondition__Group__1__Impl rule__ParenthesizedCondition__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_40);
            rule__ParenthesizedCondition__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParenthesizedCondition__Group__2();

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
    // $ANTLR end "rule__ParenthesizedCondition__Group__1"


    // $ANTLR start "rule__ParenthesizedCondition__Group__1__Impl"
    // InternalXtext.g:6358:1: rule__ParenthesizedCondition__Group__1__Impl : ( ruleDisjunction ) ;
    public final void rule__ParenthesizedCondition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6362:1: ( ( ruleDisjunction ) )
            // InternalXtext.g:6363:1: ( ruleDisjunction )
            {
            // InternalXtext.g:6363:1: ( ruleDisjunction )
            // InternalXtext.g:6364:1: ruleDisjunction
            {
             before(grammarAccess.getParenthesizedConditionAccess().getDisjunctionParserRuleCall_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleDisjunction();

            state._fsp--;

             after(grammarAccess.getParenthesizedConditionAccess().getDisjunctionParserRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedCondition__Group__1__Impl"


    // $ANTLR start "rule__ParenthesizedCondition__Group__2"
    // InternalXtext.g:6375:1: rule__ParenthesizedCondition__Group__2 : rule__ParenthesizedCondition__Group__2__Impl ;
    public final void rule__ParenthesizedCondition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6379:1: ( rule__ParenthesizedCondition__Group__2__Impl )
            // InternalXtext.g:6380:2: rule__ParenthesizedCondition__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParenthesizedCondition__Group__2__Impl();

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
    // $ANTLR end "rule__ParenthesizedCondition__Group__2"


    // $ANTLR start "rule__ParenthesizedCondition__Group__2__Impl"
    // InternalXtext.g:6386:1: rule__ParenthesizedCondition__Group__2__Impl : ( ')' ) ;
    public final void rule__ParenthesizedCondition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6390:1: ( ( ')' ) )
            // InternalXtext.g:6391:1: ( ')' )
            {
            // InternalXtext.g:6391:1: ( ')' )
            // InternalXtext.g:6392:1: ')'
            {
             before(grammarAccess.getParenthesizedConditionAccess().getRightParenthesisKeyword_2()); 
            match(input,23,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParenthesizedConditionAccess().getRightParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedCondition__Group__2__Impl"


    // $ANTLR start "rule__RuleID__Group__0"
    // InternalXtext.g:6411:1: rule__RuleID__Group__0 : rule__RuleID__Group__0__Impl rule__RuleID__Group__1 ;
    public final void rule__RuleID__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6415:1: ( rule__RuleID__Group__0__Impl rule__RuleID__Group__1 )
            // InternalXtext.g:6416:2: rule__RuleID__Group__0__Impl rule__RuleID__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_24);
            rule__RuleID__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleID__Group__1();

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
    // $ANTLR end "rule__RuleID__Group__0"


    // $ANTLR start "rule__RuleID__Group__0__Impl"
    // InternalXtext.g:6423:1: rule__RuleID__Group__0__Impl : ( ruleValidID ) ;
    public final void rule__RuleID__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6427:1: ( ( ruleValidID ) )
            // InternalXtext.g:6428:1: ( ruleValidID )
            {
            // InternalXtext.g:6428:1: ( ruleValidID )
            // InternalXtext.g:6429:1: ruleValidID
            {
             before(grammarAccess.getRuleIDAccess().getValidIDParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getRuleIDAccess().getValidIDParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleID__Group__0__Impl"


    // $ANTLR start "rule__RuleID__Group__1"
    // InternalXtext.g:6440:1: rule__RuleID__Group__1 : rule__RuleID__Group__1__Impl ;
    public final void rule__RuleID__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6444:1: ( rule__RuleID__Group__1__Impl )
            // InternalXtext.g:6445:2: rule__RuleID__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleID__Group__1__Impl();

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
    // $ANTLR end "rule__RuleID__Group__1"


    // $ANTLR start "rule__RuleID__Group__1__Impl"
    // InternalXtext.g:6451:1: rule__RuleID__Group__1__Impl : ( ( rule__RuleID__Group_1__0 )* ) ;
    public final void rule__RuleID__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6455:1: ( ( ( rule__RuleID__Group_1__0 )* ) )
            // InternalXtext.g:6456:1: ( ( rule__RuleID__Group_1__0 )* )
            {
            // InternalXtext.g:6456:1: ( ( rule__RuleID__Group_1__0 )* )
            // InternalXtext.g:6457:1: ( rule__RuleID__Group_1__0 )*
            {
             before(grammarAccess.getRuleIDAccess().getGroup_1()); 
            // InternalXtext.g:6458:1: ( rule__RuleID__Group_1__0 )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==33) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // InternalXtext.g:6458:2: rule__RuleID__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_41);
            	    rule__RuleID__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop59;
                }
            } while (true);

             after(grammarAccess.getRuleIDAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleID__Group__1__Impl"


    // $ANTLR start "rule__RuleID__Group_1__0"
    // InternalXtext.g:6472:1: rule__RuleID__Group_1__0 : rule__RuleID__Group_1__0__Impl rule__RuleID__Group_1__1 ;
    public final void rule__RuleID__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6476:1: ( rule__RuleID__Group_1__0__Impl rule__RuleID__Group_1__1 )
            // InternalXtext.g:6477:2: rule__RuleID__Group_1__0__Impl rule__RuleID__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__RuleID__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleID__Group_1__1();

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
    // $ANTLR end "rule__RuleID__Group_1__0"


    // $ANTLR start "rule__RuleID__Group_1__0__Impl"
    // InternalXtext.g:6484:1: rule__RuleID__Group_1__0__Impl : ( '::' ) ;
    public final void rule__RuleID__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6488:1: ( ( '::' ) )
            // InternalXtext.g:6489:1: ( '::' )
            {
            // InternalXtext.g:6489:1: ( '::' )
            // InternalXtext.g:6490:1: '::'
            {
             before(grammarAccess.getRuleIDAccess().getColonColonKeyword_1_0()); 
            match(input,33,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRuleIDAccess().getColonColonKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleID__Group_1__0__Impl"


    // $ANTLR start "rule__RuleID__Group_1__1"
    // InternalXtext.g:6503:1: rule__RuleID__Group_1__1 : rule__RuleID__Group_1__1__Impl ;
    public final void rule__RuleID__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6507:1: ( rule__RuleID__Group_1__1__Impl )
            // InternalXtext.g:6508:2: rule__RuleID__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleID__Group_1__1__Impl();

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
    // $ANTLR end "rule__RuleID__Group_1__1"


    // $ANTLR start "rule__RuleID__Group_1__1__Impl"
    // InternalXtext.g:6514:1: rule__RuleID__Group_1__1__Impl : ( ruleValidID ) ;
    public final void rule__RuleID__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6518:1: ( ( ruleValidID ) )
            // InternalXtext.g:6519:1: ( ruleValidID )
            {
            // InternalXtext.g:6519:1: ( ruleValidID )
            // InternalXtext.g:6520:1: ruleValidID
            {
             before(grammarAccess.getRuleIDAccess().getValidIDParserRuleCall_1_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getRuleIDAccess().getValidIDParserRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleID__Group_1__1__Impl"


    // $ANTLR start "rule__PredicatedKeyword__Group__0"
    // InternalXtext.g:6535:1: rule__PredicatedKeyword__Group__0 : rule__PredicatedKeyword__Group__0__Impl rule__PredicatedKeyword__Group__1 ;
    public final void rule__PredicatedKeyword__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6539:1: ( rule__PredicatedKeyword__Group__0__Impl rule__PredicatedKeyword__Group__1 )
            // InternalXtext.g:6540:2: rule__PredicatedKeyword__Group__0__Impl rule__PredicatedKeyword__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__PredicatedKeyword__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedKeyword__Group__1();

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
    // $ANTLR end "rule__PredicatedKeyword__Group__0"


    // $ANTLR start "rule__PredicatedKeyword__Group__0__Impl"
    // InternalXtext.g:6547:1: rule__PredicatedKeyword__Group__0__Impl : ( ( rule__PredicatedKeyword__Alternatives_0 ) ) ;
    public final void rule__PredicatedKeyword__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6551:1: ( ( ( rule__PredicatedKeyword__Alternatives_0 ) ) )
            // InternalXtext.g:6552:1: ( ( rule__PredicatedKeyword__Alternatives_0 ) )
            {
            // InternalXtext.g:6552:1: ( ( rule__PredicatedKeyword__Alternatives_0 ) )
            // InternalXtext.g:6553:1: ( rule__PredicatedKeyword__Alternatives_0 )
            {
             before(grammarAccess.getPredicatedKeywordAccess().getAlternatives_0()); 
            // InternalXtext.g:6554:1: ( rule__PredicatedKeyword__Alternatives_0 )
            // InternalXtext.g:6554:2: rule__PredicatedKeyword__Alternatives_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedKeyword__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getPredicatedKeywordAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedKeyword__Group__0__Impl"


    // $ANTLR start "rule__PredicatedKeyword__Group__1"
    // InternalXtext.g:6564:1: rule__PredicatedKeyword__Group__1 : rule__PredicatedKeyword__Group__1__Impl ;
    public final void rule__PredicatedKeyword__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6568:1: ( rule__PredicatedKeyword__Group__1__Impl )
            // InternalXtext.g:6569:2: rule__PredicatedKeyword__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedKeyword__Group__1__Impl();

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
    // $ANTLR end "rule__PredicatedKeyword__Group__1"


    // $ANTLR start "rule__PredicatedKeyword__Group__1__Impl"
    // InternalXtext.g:6575:1: rule__PredicatedKeyword__Group__1__Impl : ( ( rule__PredicatedKeyword__ValueAssignment_1 ) ) ;
    public final void rule__PredicatedKeyword__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6579:1: ( ( ( rule__PredicatedKeyword__ValueAssignment_1 ) ) )
            // InternalXtext.g:6580:1: ( ( rule__PredicatedKeyword__ValueAssignment_1 ) )
            {
            // InternalXtext.g:6580:1: ( ( rule__PredicatedKeyword__ValueAssignment_1 ) )
            // InternalXtext.g:6581:1: ( rule__PredicatedKeyword__ValueAssignment_1 )
            {
             before(grammarAccess.getPredicatedKeywordAccess().getValueAssignment_1()); 
            // InternalXtext.g:6582:1: ( rule__PredicatedKeyword__ValueAssignment_1 )
            // InternalXtext.g:6582:2: rule__PredicatedKeyword__ValueAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedKeyword__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPredicatedKeywordAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedKeyword__Group__1__Impl"


    // $ANTLR start "rule__PredicatedRuleCall__Group__0"
    // InternalXtext.g:6596:1: rule__PredicatedRuleCall__Group__0 : rule__PredicatedRuleCall__Group__0__Impl rule__PredicatedRuleCall__Group__1 ;
    public final void rule__PredicatedRuleCall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6600:1: ( rule__PredicatedRuleCall__Group__0__Impl rule__PredicatedRuleCall__Group__1 )
            // InternalXtext.g:6601:2: rule__PredicatedRuleCall__Group__0__Impl rule__PredicatedRuleCall__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_20);
            rule__PredicatedRuleCall__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedRuleCall__Group__1();

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
    // $ANTLR end "rule__PredicatedRuleCall__Group__0"


    // $ANTLR start "rule__PredicatedRuleCall__Group__0__Impl"
    // InternalXtext.g:6608:1: rule__PredicatedRuleCall__Group__0__Impl : ( ( rule__PredicatedRuleCall__Alternatives_0 ) ) ;
    public final void rule__PredicatedRuleCall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6612:1: ( ( ( rule__PredicatedRuleCall__Alternatives_0 ) ) )
            // InternalXtext.g:6613:1: ( ( rule__PredicatedRuleCall__Alternatives_0 ) )
            {
            // InternalXtext.g:6613:1: ( ( rule__PredicatedRuleCall__Alternatives_0 ) )
            // InternalXtext.g:6614:1: ( rule__PredicatedRuleCall__Alternatives_0 )
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getAlternatives_0()); 
            // InternalXtext.g:6615:1: ( rule__PredicatedRuleCall__Alternatives_0 )
            // InternalXtext.g:6615:2: rule__PredicatedRuleCall__Alternatives_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedRuleCall__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getPredicatedRuleCallAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__Group__0__Impl"


    // $ANTLR start "rule__PredicatedRuleCall__Group__1"
    // InternalXtext.g:6625:1: rule__PredicatedRuleCall__Group__1 : rule__PredicatedRuleCall__Group__1__Impl rule__PredicatedRuleCall__Group__2 ;
    public final void rule__PredicatedRuleCall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6629:1: ( rule__PredicatedRuleCall__Group__1__Impl rule__PredicatedRuleCall__Group__2 )
            // InternalXtext.g:6630:2: rule__PredicatedRuleCall__Group__1__Impl rule__PredicatedRuleCall__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_22);
            rule__PredicatedRuleCall__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedRuleCall__Group__2();

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
    // $ANTLR end "rule__PredicatedRuleCall__Group__1"


    // $ANTLR start "rule__PredicatedRuleCall__Group__1__Impl"
    // InternalXtext.g:6637:1: rule__PredicatedRuleCall__Group__1__Impl : ( ( rule__PredicatedRuleCall__RuleAssignment_1 ) ) ;
    public final void rule__PredicatedRuleCall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6641:1: ( ( ( rule__PredicatedRuleCall__RuleAssignment_1 ) ) )
            // InternalXtext.g:6642:1: ( ( rule__PredicatedRuleCall__RuleAssignment_1 ) )
            {
            // InternalXtext.g:6642:1: ( ( rule__PredicatedRuleCall__RuleAssignment_1 ) )
            // InternalXtext.g:6643:1: ( rule__PredicatedRuleCall__RuleAssignment_1 )
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getRuleAssignment_1()); 
            // InternalXtext.g:6644:1: ( rule__PredicatedRuleCall__RuleAssignment_1 )
            // InternalXtext.g:6644:2: rule__PredicatedRuleCall__RuleAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedRuleCall__RuleAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPredicatedRuleCallAccess().getRuleAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__Group__1__Impl"


    // $ANTLR start "rule__PredicatedRuleCall__Group__2"
    // InternalXtext.g:6654:1: rule__PredicatedRuleCall__Group__2 : rule__PredicatedRuleCall__Group__2__Impl ;
    public final void rule__PredicatedRuleCall__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6658:1: ( rule__PredicatedRuleCall__Group__2__Impl )
            // InternalXtext.g:6659:2: rule__PredicatedRuleCall__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedRuleCall__Group__2__Impl();

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
    // $ANTLR end "rule__PredicatedRuleCall__Group__2"


    // $ANTLR start "rule__PredicatedRuleCall__Group__2__Impl"
    // InternalXtext.g:6665:1: rule__PredicatedRuleCall__Group__2__Impl : ( ( rule__PredicatedRuleCall__Group_2__0 )? ) ;
    public final void rule__PredicatedRuleCall__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6669:1: ( ( ( rule__PredicatedRuleCall__Group_2__0 )? ) )
            // InternalXtext.g:6670:1: ( ( rule__PredicatedRuleCall__Group_2__0 )? )
            {
            // InternalXtext.g:6670:1: ( ( rule__PredicatedRuleCall__Group_2__0 )? )
            // InternalXtext.g:6671:1: ( rule__PredicatedRuleCall__Group_2__0 )?
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getGroup_2()); 
            // InternalXtext.g:6672:1: ( rule__PredicatedRuleCall__Group_2__0 )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==31) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalXtext.g:6672:2: rule__PredicatedRuleCall__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__PredicatedRuleCall__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPredicatedRuleCallAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__Group__2__Impl"


    // $ANTLR start "rule__PredicatedRuleCall__Group_2__0"
    // InternalXtext.g:6688:1: rule__PredicatedRuleCall__Group_2__0 : rule__PredicatedRuleCall__Group_2__0__Impl rule__PredicatedRuleCall__Group_2__1 ;
    public final void rule__PredicatedRuleCall__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6692:1: ( rule__PredicatedRuleCall__Group_2__0__Impl rule__PredicatedRuleCall__Group_2__1 )
            // InternalXtext.g:6693:2: rule__PredicatedRuleCall__Group_2__0__Impl rule__PredicatedRuleCall__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_27);
            rule__PredicatedRuleCall__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedRuleCall__Group_2__1();

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
    // $ANTLR end "rule__PredicatedRuleCall__Group_2__0"


    // $ANTLR start "rule__PredicatedRuleCall__Group_2__0__Impl"
    // InternalXtext.g:6700:1: rule__PredicatedRuleCall__Group_2__0__Impl : ( '<' ) ;
    public final void rule__PredicatedRuleCall__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6704:1: ( ( '<' ) )
            // InternalXtext.g:6705:1: ( '<' )
            {
            // InternalXtext.g:6705:1: ( '<' )
            // InternalXtext.g:6706:1: '<'
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getLessThanSignKeyword_2_0()); 
            match(input,31,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getPredicatedRuleCallAccess().getLessThanSignKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__Group_2__0__Impl"


    // $ANTLR start "rule__PredicatedRuleCall__Group_2__1"
    // InternalXtext.g:6719:1: rule__PredicatedRuleCall__Group_2__1 : rule__PredicatedRuleCall__Group_2__1__Impl rule__PredicatedRuleCall__Group_2__2 ;
    public final void rule__PredicatedRuleCall__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6723:1: ( rule__PredicatedRuleCall__Group_2__1__Impl rule__PredicatedRuleCall__Group_2__2 )
            // InternalXtext.g:6724:2: rule__PredicatedRuleCall__Group_2__1__Impl rule__PredicatedRuleCall__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_37);
            rule__PredicatedRuleCall__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedRuleCall__Group_2__2();

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
    // $ANTLR end "rule__PredicatedRuleCall__Group_2__1"


    // $ANTLR start "rule__PredicatedRuleCall__Group_2__1__Impl"
    // InternalXtext.g:6731:1: rule__PredicatedRuleCall__Group_2__1__Impl : ( ( rule__PredicatedRuleCall__ArgumentsAssignment_2_1 ) ) ;
    public final void rule__PredicatedRuleCall__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6735:1: ( ( ( rule__PredicatedRuleCall__ArgumentsAssignment_2_1 ) ) )
            // InternalXtext.g:6736:1: ( ( rule__PredicatedRuleCall__ArgumentsAssignment_2_1 ) )
            {
            // InternalXtext.g:6736:1: ( ( rule__PredicatedRuleCall__ArgumentsAssignment_2_1 ) )
            // InternalXtext.g:6737:1: ( rule__PredicatedRuleCall__ArgumentsAssignment_2_1 )
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getArgumentsAssignment_2_1()); 
            // InternalXtext.g:6738:1: ( rule__PredicatedRuleCall__ArgumentsAssignment_2_1 )
            // InternalXtext.g:6738:2: rule__PredicatedRuleCall__ArgumentsAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedRuleCall__ArgumentsAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getPredicatedRuleCallAccess().getArgumentsAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__Group_2__1__Impl"


    // $ANTLR start "rule__PredicatedRuleCall__Group_2__2"
    // InternalXtext.g:6748:1: rule__PredicatedRuleCall__Group_2__2 : rule__PredicatedRuleCall__Group_2__2__Impl rule__PredicatedRuleCall__Group_2__3 ;
    public final void rule__PredicatedRuleCall__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6752:1: ( rule__PredicatedRuleCall__Group_2__2__Impl rule__PredicatedRuleCall__Group_2__3 )
            // InternalXtext.g:6753:2: rule__PredicatedRuleCall__Group_2__2__Impl rule__PredicatedRuleCall__Group_2__3
            {
            pushFollow(FollowSets000.FOLLOW_37);
            rule__PredicatedRuleCall__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedRuleCall__Group_2__3();

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
    // $ANTLR end "rule__PredicatedRuleCall__Group_2__2"


    // $ANTLR start "rule__PredicatedRuleCall__Group_2__2__Impl"
    // InternalXtext.g:6760:1: rule__PredicatedRuleCall__Group_2__2__Impl : ( ( rule__PredicatedRuleCall__Group_2_2__0 )* ) ;
    public final void rule__PredicatedRuleCall__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6764:1: ( ( ( rule__PredicatedRuleCall__Group_2_2__0 )* ) )
            // InternalXtext.g:6765:1: ( ( rule__PredicatedRuleCall__Group_2_2__0 )* )
            {
            // InternalXtext.g:6765:1: ( ( rule__PredicatedRuleCall__Group_2_2__0 )* )
            // InternalXtext.g:6766:1: ( rule__PredicatedRuleCall__Group_2_2__0 )*
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getGroup_2_2()); 
            // InternalXtext.g:6767:1: ( rule__PredicatedRuleCall__Group_2_2__0 )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==21) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // InternalXtext.g:6767:2: rule__PredicatedRuleCall__Group_2_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    rule__PredicatedRuleCall__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);

             after(grammarAccess.getPredicatedRuleCallAccess().getGroup_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__Group_2__2__Impl"


    // $ANTLR start "rule__PredicatedRuleCall__Group_2__3"
    // InternalXtext.g:6777:1: rule__PredicatedRuleCall__Group_2__3 : rule__PredicatedRuleCall__Group_2__3__Impl ;
    public final void rule__PredicatedRuleCall__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6781:1: ( rule__PredicatedRuleCall__Group_2__3__Impl )
            // InternalXtext.g:6782:2: rule__PredicatedRuleCall__Group_2__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedRuleCall__Group_2__3__Impl();

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
    // $ANTLR end "rule__PredicatedRuleCall__Group_2__3"


    // $ANTLR start "rule__PredicatedRuleCall__Group_2__3__Impl"
    // InternalXtext.g:6788:1: rule__PredicatedRuleCall__Group_2__3__Impl : ( '>' ) ;
    public final void rule__PredicatedRuleCall__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6792:1: ( ( '>' ) )
            // InternalXtext.g:6793:1: ( '>' )
            {
            // InternalXtext.g:6793:1: ( '>' )
            // InternalXtext.g:6794:1: '>'
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getGreaterThanSignKeyword_2_3()); 
            match(input,32,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getPredicatedRuleCallAccess().getGreaterThanSignKeyword_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__Group_2__3__Impl"


    // $ANTLR start "rule__PredicatedRuleCall__Group_2_2__0"
    // InternalXtext.g:6815:1: rule__PredicatedRuleCall__Group_2_2__0 : rule__PredicatedRuleCall__Group_2_2__0__Impl rule__PredicatedRuleCall__Group_2_2__1 ;
    public final void rule__PredicatedRuleCall__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6819:1: ( rule__PredicatedRuleCall__Group_2_2__0__Impl rule__PredicatedRuleCall__Group_2_2__1 )
            // InternalXtext.g:6820:2: rule__PredicatedRuleCall__Group_2_2__0__Impl rule__PredicatedRuleCall__Group_2_2__1
            {
            pushFollow(FollowSets000.FOLLOW_27);
            rule__PredicatedRuleCall__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedRuleCall__Group_2_2__1();

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
    // $ANTLR end "rule__PredicatedRuleCall__Group_2_2__0"


    // $ANTLR start "rule__PredicatedRuleCall__Group_2_2__0__Impl"
    // InternalXtext.g:6827:1: rule__PredicatedRuleCall__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__PredicatedRuleCall__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6831:1: ( ( ',' ) )
            // InternalXtext.g:6832:1: ( ',' )
            {
            // InternalXtext.g:6832:1: ( ',' )
            // InternalXtext.g:6833:1: ','
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getCommaKeyword_2_2_0()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getPredicatedRuleCallAccess().getCommaKeyword_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__Group_2_2__0__Impl"


    // $ANTLR start "rule__PredicatedRuleCall__Group_2_2__1"
    // InternalXtext.g:6846:1: rule__PredicatedRuleCall__Group_2_2__1 : rule__PredicatedRuleCall__Group_2_2__1__Impl ;
    public final void rule__PredicatedRuleCall__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6850:1: ( rule__PredicatedRuleCall__Group_2_2__1__Impl )
            // InternalXtext.g:6851:2: rule__PredicatedRuleCall__Group_2_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedRuleCall__Group_2_2__1__Impl();

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
    // $ANTLR end "rule__PredicatedRuleCall__Group_2_2__1"


    // $ANTLR start "rule__PredicatedRuleCall__Group_2_2__1__Impl"
    // InternalXtext.g:6857:1: rule__PredicatedRuleCall__Group_2_2__1__Impl : ( ( rule__PredicatedRuleCall__ArgumentsAssignment_2_2_1 ) ) ;
    public final void rule__PredicatedRuleCall__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6861:1: ( ( ( rule__PredicatedRuleCall__ArgumentsAssignment_2_2_1 ) ) )
            // InternalXtext.g:6862:1: ( ( rule__PredicatedRuleCall__ArgumentsAssignment_2_2_1 ) )
            {
            // InternalXtext.g:6862:1: ( ( rule__PredicatedRuleCall__ArgumentsAssignment_2_2_1 ) )
            // InternalXtext.g:6863:1: ( rule__PredicatedRuleCall__ArgumentsAssignment_2_2_1 )
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getArgumentsAssignment_2_2_1()); 
            // InternalXtext.g:6864:1: ( rule__PredicatedRuleCall__ArgumentsAssignment_2_2_1 )
            // InternalXtext.g:6864:2: rule__PredicatedRuleCall__ArgumentsAssignment_2_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedRuleCall__ArgumentsAssignment_2_2_1();

            state._fsp--;


            }

             after(grammarAccess.getPredicatedRuleCallAccess().getArgumentsAssignment_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__Group_2_2__1__Impl"


    // $ANTLR start "rule__Assignment__Group__0"
    // InternalXtext.g:6878:1: rule__Assignment__Group__0 : rule__Assignment__Group__0__Impl rule__Assignment__Group__1 ;
    public final void rule__Assignment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6882:1: ( rule__Assignment__Group__0__Impl rule__Assignment__Group__1 )
            // InternalXtext.g:6883:2: rule__Assignment__Group__0__Impl rule__Assignment__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_42);
            rule__Assignment__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:6890:1: rule__Assignment__Group__0__Impl : ( ( rule__Assignment__Alternatives_0 )? ) ;
    public final void rule__Assignment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6894:1: ( ( ( rule__Assignment__Alternatives_0 )? ) )
            // InternalXtext.g:6895:1: ( ( rule__Assignment__Alternatives_0 )? )
            {
            // InternalXtext.g:6895:1: ( ( rule__Assignment__Alternatives_0 )? )
            // InternalXtext.g:6896:1: ( rule__Assignment__Alternatives_0 )?
            {
             before(grammarAccess.getAssignmentAccess().getAlternatives_0()); 
            // InternalXtext.g:6897:1: ( rule__Assignment__Alternatives_0 )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==43||LA62_0==49) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalXtext.g:6897:2: rule__Assignment__Alternatives_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Assignment__Alternatives_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAssignmentAccess().getAlternatives_0()); 

            }


            }

        }
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
    // InternalXtext.g:6907:1: rule__Assignment__Group__1 : rule__Assignment__Group__1__Impl rule__Assignment__Group__2 ;
    public final void rule__Assignment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6911:1: ( rule__Assignment__Group__1__Impl rule__Assignment__Group__2 )
            // InternalXtext.g:6912:2: rule__Assignment__Group__1__Impl rule__Assignment__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_43);
            rule__Assignment__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:6919:1: rule__Assignment__Group__1__Impl : ( ( rule__Assignment__FeatureAssignment_1 ) ) ;
    public final void rule__Assignment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6923:1: ( ( ( rule__Assignment__FeatureAssignment_1 ) ) )
            // InternalXtext.g:6924:1: ( ( rule__Assignment__FeatureAssignment_1 ) )
            {
            // InternalXtext.g:6924:1: ( ( rule__Assignment__FeatureAssignment_1 ) )
            // InternalXtext.g:6925:1: ( rule__Assignment__FeatureAssignment_1 )
            {
             before(grammarAccess.getAssignmentAccess().getFeatureAssignment_1()); 
            // InternalXtext.g:6926:1: ( rule__Assignment__FeatureAssignment_1 )
            // InternalXtext.g:6926:2: rule__Assignment__FeatureAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Assignment__FeatureAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getAssignmentAccess().getFeatureAssignment_1()); 

            }


            }

        }
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
    // InternalXtext.g:6936:1: rule__Assignment__Group__2 : rule__Assignment__Group__2__Impl rule__Assignment__Group__3 ;
    public final void rule__Assignment__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6940:1: ( rule__Assignment__Group__2__Impl rule__Assignment__Group__3 )
            // InternalXtext.g:6941:2: rule__Assignment__Group__2__Impl rule__Assignment__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_44);
            rule__Assignment__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Assignment__Group__3();

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
    // InternalXtext.g:6948:1: rule__Assignment__Group__2__Impl : ( ( rule__Assignment__OperatorAssignment_2 ) ) ;
    public final void rule__Assignment__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6952:1: ( ( ( rule__Assignment__OperatorAssignment_2 ) ) )
            // InternalXtext.g:6953:1: ( ( rule__Assignment__OperatorAssignment_2 ) )
            {
            // InternalXtext.g:6953:1: ( ( rule__Assignment__OperatorAssignment_2 ) )
            // InternalXtext.g:6954:1: ( rule__Assignment__OperatorAssignment_2 )
            {
             before(grammarAccess.getAssignmentAccess().getOperatorAssignment_2()); 
            // InternalXtext.g:6955:1: ( rule__Assignment__OperatorAssignment_2 )
            // InternalXtext.g:6955:2: rule__Assignment__OperatorAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Assignment__OperatorAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getAssignmentAccess().getOperatorAssignment_2()); 

            }


            }

        }
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


    // $ANTLR start "rule__Assignment__Group__3"
    // InternalXtext.g:6965:1: rule__Assignment__Group__3 : rule__Assignment__Group__3__Impl ;
    public final void rule__Assignment__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6969:1: ( rule__Assignment__Group__3__Impl )
            // InternalXtext.g:6970:2: rule__Assignment__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Assignment__Group__3__Impl();

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
    // $ANTLR end "rule__Assignment__Group__3"


    // $ANTLR start "rule__Assignment__Group__3__Impl"
    // InternalXtext.g:6976:1: rule__Assignment__Group__3__Impl : ( ( rule__Assignment__TerminalAssignment_3 ) ) ;
    public final void rule__Assignment__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:6980:1: ( ( ( rule__Assignment__TerminalAssignment_3 ) ) )
            // InternalXtext.g:6981:1: ( ( rule__Assignment__TerminalAssignment_3 ) )
            {
            // InternalXtext.g:6981:1: ( ( rule__Assignment__TerminalAssignment_3 ) )
            // InternalXtext.g:6982:1: ( rule__Assignment__TerminalAssignment_3 )
            {
             before(grammarAccess.getAssignmentAccess().getTerminalAssignment_3()); 
            // InternalXtext.g:6983:1: ( rule__Assignment__TerminalAssignment_3 )
            // InternalXtext.g:6983:2: rule__Assignment__TerminalAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Assignment__TerminalAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getAssignmentAccess().getTerminalAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__3__Impl"


    // $ANTLR start "rule__ParenthesizedAssignableElement__Group__0"
    // InternalXtext.g:7001:1: rule__ParenthesizedAssignableElement__Group__0 : rule__ParenthesizedAssignableElement__Group__0__Impl rule__ParenthesizedAssignableElement__Group__1 ;
    public final void rule__ParenthesizedAssignableElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7005:1: ( rule__ParenthesizedAssignableElement__Group__0__Impl rule__ParenthesizedAssignableElement__Group__1 )
            // InternalXtext.g:7006:2: rule__ParenthesizedAssignableElement__Group__0__Impl rule__ParenthesizedAssignableElement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_44);
            rule__ParenthesizedAssignableElement__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7013:1: rule__ParenthesizedAssignableElement__Group__0__Impl : ( '(' ) ;
    public final void rule__ParenthesizedAssignableElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7017:1: ( ( '(' ) )
            // InternalXtext.g:7018:1: ( '(' )
            {
            // InternalXtext.g:7018:1: ( '(' )
            // InternalXtext.g:7019:1: '('
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getLeftParenthesisKeyword_0()); 
            match(input,22,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:7032:1: rule__ParenthesizedAssignableElement__Group__1 : rule__ParenthesizedAssignableElement__Group__1__Impl rule__ParenthesizedAssignableElement__Group__2 ;
    public final void rule__ParenthesizedAssignableElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7036:1: ( rule__ParenthesizedAssignableElement__Group__1__Impl rule__ParenthesizedAssignableElement__Group__2 )
            // InternalXtext.g:7037:2: rule__ParenthesizedAssignableElement__Group__1__Impl rule__ParenthesizedAssignableElement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_40);
            rule__ParenthesizedAssignableElement__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7044:1: rule__ParenthesizedAssignableElement__Group__1__Impl : ( ruleAssignableAlternatives ) ;
    public final void rule__ParenthesizedAssignableElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7048:1: ( ( ruleAssignableAlternatives ) )
            // InternalXtext.g:7049:1: ( ruleAssignableAlternatives )
            {
            // InternalXtext.g:7049:1: ( ruleAssignableAlternatives )
            // InternalXtext.g:7050:1: ruleAssignableAlternatives
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getAssignableAlternativesParserRuleCall_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7061:1: rule__ParenthesizedAssignableElement__Group__2 : rule__ParenthesizedAssignableElement__Group__2__Impl ;
    public final void rule__ParenthesizedAssignableElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7065:1: ( rule__ParenthesizedAssignableElement__Group__2__Impl )
            // InternalXtext.g:7066:2: rule__ParenthesizedAssignableElement__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7072:1: rule__ParenthesizedAssignableElement__Group__2__Impl : ( ')' ) ;
    public final void rule__ParenthesizedAssignableElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7076:1: ( ( ')' ) )
            // InternalXtext.g:7077:1: ( ')' )
            {
            // InternalXtext.g:7077:1: ( ')' )
            // InternalXtext.g:7078:1: ')'
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getRightParenthesisKeyword_2()); 
            match(input,23,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:7097:1: rule__AssignableAlternatives__Group__0 : rule__AssignableAlternatives__Group__0__Impl rule__AssignableAlternatives__Group__1 ;
    public final void rule__AssignableAlternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7101:1: ( rule__AssignableAlternatives__Group__0__Impl rule__AssignableAlternatives__Group__1 )
            // InternalXtext.g:7102:2: rule__AssignableAlternatives__Group__0__Impl rule__AssignableAlternatives__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_25);
            rule__AssignableAlternatives__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7109:1: rule__AssignableAlternatives__Group__0__Impl : ( ruleAssignableTerminal ) ;
    public final void rule__AssignableAlternatives__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7113:1: ( ( ruleAssignableTerminal ) )
            // InternalXtext.g:7114:1: ( ruleAssignableTerminal )
            {
            // InternalXtext.g:7114:1: ( ruleAssignableTerminal )
            // InternalXtext.g:7115:1: ruleAssignableTerminal
            {
             before(grammarAccess.getAssignableAlternativesAccess().getAssignableTerminalParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7126:1: rule__AssignableAlternatives__Group__1 : rule__AssignableAlternatives__Group__1__Impl ;
    public final void rule__AssignableAlternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7130:1: ( rule__AssignableAlternatives__Group__1__Impl )
            // InternalXtext.g:7131:2: rule__AssignableAlternatives__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7137:1: rule__AssignableAlternatives__Group__1__Impl : ( ( rule__AssignableAlternatives__Group_1__0 )? ) ;
    public final void rule__AssignableAlternatives__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7141:1: ( ( ( rule__AssignableAlternatives__Group_1__0 )? ) )
            // InternalXtext.g:7142:1: ( ( rule__AssignableAlternatives__Group_1__0 )? )
            {
            // InternalXtext.g:7142:1: ( ( rule__AssignableAlternatives__Group_1__0 )? )
            // InternalXtext.g:7143:1: ( rule__AssignableAlternatives__Group_1__0 )?
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup_1()); 
            // InternalXtext.g:7144:1: ( rule__AssignableAlternatives__Group_1__0 )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==34) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalXtext.g:7144:2: rule__AssignableAlternatives__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7158:1: rule__AssignableAlternatives__Group_1__0 : rule__AssignableAlternatives__Group_1__0__Impl rule__AssignableAlternatives__Group_1__1 ;
    public final void rule__AssignableAlternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7162:1: ( rule__AssignableAlternatives__Group_1__0__Impl rule__AssignableAlternatives__Group_1__1 )
            // InternalXtext.g:7163:2: rule__AssignableAlternatives__Group_1__0__Impl rule__AssignableAlternatives__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_25);
            rule__AssignableAlternatives__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7170:1: rule__AssignableAlternatives__Group_1__0__Impl : ( () ) ;
    public final void rule__AssignableAlternatives__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7174:1: ( ( () ) )
            // InternalXtext.g:7175:1: ( () )
            {
            // InternalXtext.g:7175:1: ( () )
            // InternalXtext.g:7176:1: ()
            {
             before(grammarAccess.getAssignableAlternativesAccess().getAlternativesElementsAction_1_0()); 
            // InternalXtext.g:7177:1: ()
            // InternalXtext.g:7179:1: 
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
    // InternalXtext.g:7189:1: rule__AssignableAlternatives__Group_1__1 : rule__AssignableAlternatives__Group_1__1__Impl ;
    public final void rule__AssignableAlternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7193:1: ( rule__AssignableAlternatives__Group_1__1__Impl )
            // InternalXtext.g:7194:2: rule__AssignableAlternatives__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7200:1: rule__AssignableAlternatives__Group_1__1__Impl : ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) ) ;
    public final void rule__AssignableAlternatives__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7204:1: ( ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) ) )
            // InternalXtext.g:7205:1: ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) )
            {
            // InternalXtext.g:7205:1: ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) )
            // InternalXtext.g:7206:1: ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* )
            {
            // InternalXtext.g:7206:1: ( ( rule__AssignableAlternatives__Group_1_1__0 ) )
            // InternalXtext.g:7207:1: ( rule__AssignableAlternatives__Group_1_1__0 )
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 
            // InternalXtext.g:7208:1: ( rule__AssignableAlternatives__Group_1_1__0 )
            // InternalXtext.g:7208:2: rule__AssignableAlternatives__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_26);
            rule__AssignableAlternatives__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 

            }

            // InternalXtext.g:7211:1: ( ( rule__AssignableAlternatives__Group_1_1__0 )* )
            // InternalXtext.g:7212:1: ( rule__AssignableAlternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 
            // InternalXtext.g:7213:1: ( rule__AssignableAlternatives__Group_1_1__0 )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==34) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalXtext.g:7213:2: rule__AssignableAlternatives__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_26);
            	    rule__AssignableAlternatives__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop64;
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
    // InternalXtext.g:7228:1: rule__AssignableAlternatives__Group_1_1__0 : rule__AssignableAlternatives__Group_1_1__0__Impl rule__AssignableAlternatives__Group_1_1__1 ;
    public final void rule__AssignableAlternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7232:1: ( rule__AssignableAlternatives__Group_1_1__0__Impl rule__AssignableAlternatives__Group_1_1__1 )
            // InternalXtext.g:7233:2: rule__AssignableAlternatives__Group_1_1__0__Impl rule__AssignableAlternatives__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_44);
            rule__AssignableAlternatives__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7240:1: rule__AssignableAlternatives__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__AssignableAlternatives__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7244:1: ( ( '|' ) )
            // InternalXtext.g:7245:1: ( '|' )
            {
            // InternalXtext.g:7245:1: ( '|' )
            // InternalXtext.g:7246:1: '|'
            {
             before(grammarAccess.getAssignableAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,34,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:7259:1: rule__AssignableAlternatives__Group_1_1__1 : rule__AssignableAlternatives__Group_1_1__1__Impl ;
    public final void rule__AssignableAlternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7263:1: ( rule__AssignableAlternatives__Group_1_1__1__Impl )
            // InternalXtext.g:7264:2: rule__AssignableAlternatives__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7270:1: rule__AssignableAlternatives__Group_1_1__1__Impl : ( ( rule__AssignableAlternatives__ElementsAssignment_1_1_1 ) ) ;
    public final void rule__AssignableAlternatives__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7274:1: ( ( ( rule__AssignableAlternatives__ElementsAssignment_1_1_1 ) ) )
            // InternalXtext.g:7275:1: ( ( rule__AssignableAlternatives__ElementsAssignment_1_1_1 ) )
            {
            // InternalXtext.g:7275:1: ( ( rule__AssignableAlternatives__ElementsAssignment_1_1_1 ) )
            // InternalXtext.g:7276:1: ( rule__AssignableAlternatives__ElementsAssignment_1_1_1 )
            {
             before(grammarAccess.getAssignableAlternativesAccess().getElementsAssignment_1_1_1()); 
            // InternalXtext.g:7277:1: ( rule__AssignableAlternatives__ElementsAssignment_1_1_1 )
            // InternalXtext.g:7277:2: rule__AssignableAlternatives__ElementsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7291:1: rule__CrossReference__Group__0 : rule__CrossReference__Group__0__Impl rule__CrossReference__Group__1 ;
    public final void rule__CrossReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7295:1: ( rule__CrossReference__Group__0__Impl rule__CrossReference__Group__1 )
            // InternalXtext.g:7296:2: rule__CrossReference__Group__0__Impl rule__CrossReference__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_20);
            rule__CrossReference__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7303:1: rule__CrossReference__Group__0__Impl : ( '[' ) ;
    public final void rule__CrossReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7307:1: ( ( '[' ) )
            // InternalXtext.g:7308:1: ( '[' )
            {
            // InternalXtext.g:7308:1: ( '[' )
            // InternalXtext.g:7309:1: '['
            {
             before(grammarAccess.getCrossReferenceAccess().getLeftSquareBracketKeyword_0()); 
            match(input,40,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:7322:1: rule__CrossReference__Group__1 : rule__CrossReference__Group__1__Impl rule__CrossReference__Group__2 ;
    public final void rule__CrossReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7326:1: ( rule__CrossReference__Group__1__Impl rule__CrossReference__Group__2 )
            // InternalXtext.g:7327:2: rule__CrossReference__Group__1__Impl rule__CrossReference__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_45);
            rule__CrossReference__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7334:1: rule__CrossReference__Group__1__Impl : ( ( rule__CrossReference__TypeAssignment_1 ) ) ;
    public final void rule__CrossReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7338:1: ( ( ( rule__CrossReference__TypeAssignment_1 ) ) )
            // InternalXtext.g:7339:1: ( ( rule__CrossReference__TypeAssignment_1 ) )
            {
            // InternalXtext.g:7339:1: ( ( rule__CrossReference__TypeAssignment_1 ) )
            // InternalXtext.g:7340:1: ( rule__CrossReference__TypeAssignment_1 )
            {
             before(grammarAccess.getCrossReferenceAccess().getTypeAssignment_1()); 
            // InternalXtext.g:7341:1: ( rule__CrossReference__TypeAssignment_1 )
            // InternalXtext.g:7341:2: rule__CrossReference__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7351:1: rule__CrossReference__Group__2 : rule__CrossReference__Group__2__Impl rule__CrossReference__Group__3 ;
    public final void rule__CrossReference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7355:1: ( rule__CrossReference__Group__2__Impl rule__CrossReference__Group__3 )
            // InternalXtext.g:7356:2: rule__CrossReference__Group__2__Impl rule__CrossReference__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_45);
            rule__CrossReference__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7363:1: rule__CrossReference__Group__2__Impl : ( ( rule__CrossReference__Group_2__0 )? ) ;
    public final void rule__CrossReference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7367:1: ( ( ( rule__CrossReference__Group_2__0 )? ) )
            // InternalXtext.g:7368:1: ( ( rule__CrossReference__Group_2__0 )? )
            {
            // InternalXtext.g:7368:1: ( ( rule__CrossReference__Group_2__0 )? )
            // InternalXtext.g:7369:1: ( rule__CrossReference__Group_2__0 )?
            {
             before(grammarAccess.getCrossReferenceAccess().getGroup_2()); 
            // InternalXtext.g:7370:1: ( rule__CrossReference__Group_2__0 )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==34) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalXtext.g:7370:2: rule__CrossReference__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7380:1: rule__CrossReference__Group__3 : rule__CrossReference__Group__3__Impl ;
    public final void rule__CrossReference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7384:1: ( rule__CrossReference__Group__3__Impl )
            // InternalXtext.g:7385:2: rule__CrossReference__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7391:1: rule__CrossReference__Group__3__Impl : ( ']' ) ;
    public final void rule__CrossReference__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7395:1: ( ( ']' ) )
            // InternalXtext.g:7396:1: ( ']' )
            {
            // InternalXtext.g:7396:1: ( ']' )
            // InternalXtext.g:7397:1: ']'
            {
             before(grammarAccess.getCrossReferenceAccess().getRightSquareBracketKeyword_3()); 
            match(input,41,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:7418:1: rule__CrossReference__Group_2__0 : rule__CrossReference__Group_2__0__Impl rule__CrossReference__Group_2__1 ;
    public final void rule__CrossReference__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7422:1: ( rule__CrossReference__Group_2__0__Impl rule__CrossReference__Group_2__1 )
            // InternalXtext.g:7423:2: rule__CrossReference__Group_2__0__Impl rule__CrossReference__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_46);
            rule__CrossReference__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7430:1: rule__CrossReference__Group_2__0__Impl : ( '|' ) ;
    public final void rule__CrossReference__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7434:1: ( ( '|' ) )
            // InternalXtext.g:7435:1: ( '|' )
            {
            // InternalXtext.g:7435:1: ( '|' )
            // InternalXtext.g:7436:1: '|'
            {
             before(grammarAccess.getCrossReferenceAccess().getVerticalLineKeyword_2_0()); 
            match(input,34,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:7449:1: rule__CrossReference__Group_2__1 : rule__CrossReference__Group_2__1__Impl ;
    public final void rule__CrossReference__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7453:1: ( rule__CrossReference__Group_2__1__Impl )
            // InternalXtext.g:7454:2: rule__CrossReference__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7460:1: rule__CrossReference__Group_2__1__Impl : ( ( rule__CrossReference__TerminalAssignment_2_1 ) ) ;
    public final void rule__CrossReference__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7464:1: ( ( ( rule__CrossReference__TerminalAssignment_2_1 ) ) )
            // InternalXtext.g:7465:1: ( ( rule__CrossReference__TerminalAssignment_2_1 ) )
            {
            // InternalXtext.g:7465:1: ( ( rule__CrossReference__TerminalAssignment_2_1 ) )
            // InternalXtext.g:7466:1: ( rule__CrossReference__TerminalAssignment_2_1 )
            {
             before(grammarAccess.getCrossReferenceAccess().getTerminalAssignment_2_1()); 
            // InternalXtext.g:7467:1: ( rule__CrossReference__TerminalAssignment_2_1 )
            // InternalXtext.g:7467:2: rule__CrossReference__TerminalAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7481:1: rule__ParenthesizedElement__Group__0 : rule__ParenthesizedElement__Group__0__Impl rule__ParenthesizedElement__Group__1 ;
    public final void rule__ParenthesizedElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7485:1: ( rule__ParenthesizedElement__Group__0__Impl rule__ParenthesizedElement__Group__1 )
            // InternalXtext.g:7486:2: rule__ParenthesizedElement__Group__0__Impl rule__ParenthesizedElement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__ParenthesizedElement__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7493:1: rule__ParenthesizedElement__Group__0__Impl : ( '(' ) ;
    public final void rule__ParenthesizedElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7497:1: ( ( '(' ) )
            // InternalXtext.g:7498:1: ( '(' )
            {
            // InternalXtext.g:7498:1: ( '(' )
            // InternalXtext.g:7499:1: '('
            {
             before(grammarAccess.getParenthesizedElementAccess().getLeftParenthesisKeyword_0()); 
            match(input,22,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:7512:1: rule__ParenthesizedElement__Group__1 : rule__ParenthesizedElement__Group__1__Impl rule__ParenthesizedElement__Group__2 ;
    public final void rule__ParenthesizedElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7516:1: ( rule__ParenthesizedElement__Group__1__Impl rule__ParenthesizedElement__Group__2 )
            // InternalXtext.g:7517:2: rule__ParenthesizedElement__Group__1__Impl rule__ParenthesizedElement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_40);
            rule__ParenthesizedElement__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7524:1: rule__ParenthesizedElement__Group__1__Impl : ( ruleAlternatives ) ;
    public final void rule__ParenthesizedElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7528:1: ( ( ruleAlternatives ) )
            // InternalXtext.g:7529:1: ( ruleAlternatives )
            {
            // InternalXtext.g:7529:1: ( ruleAlternatives )
            // InternalXtext.g:7530:1: ruleAlternatives
            {
             before(grammarAccess.getParenthesizedElementAccess().getAlternativesParserRuleCall_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7541:1: rule__ParenthesizedElement__Group__2 : rule__ParenthesizedElement__Group__2__Impl ;
    public final void rule__ParenthesizedElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7545:1: ( rule__ParenthesizedElement__Group__2__Impl )
            // InternalXtext.g:7546:2: rule__ParenthesizedElement__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7552:1: rule__ParenthesizedElement__Group__2__Impl : ( ')' ) ;
    public final void rule__ParenthesizedElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7556:1: ( ( ')' ) )
            // InternalXtext.g:7557:1: ( ')' )
            {
            // InternalXtext.g:7557:1: ( ')' )
            // InternalXtext.g:7558:1: ')'
            {
             before(grammarAccess.getParenthesizedElementAccess().getRightParenthesisKeyword_2()); 
            match(input,23,FollowSets000.FOLLOW_2); 
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


    // $ANTLR start "rule__PredicatedGroup__Group__0"
    // InternalXtext.g:7577:1: rule__PredicatedGroup__Group__0 : rule__PredicatedGroup__Group__0__Impl rule__PredicatedGroup__Group__1 ;
    public final void rule__PredicatedGroup__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7581:1: ( rule__PredicatedGroup__Group__0__Impl rule__PredicatedGroup__Group__1 )
            // InternalXtext.g:7582:2: rule__PredicatedGroup__Group__0__Impl rule__PredicatedGroup__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__PredicatedGroup__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedGroup__Group__1();

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
    // $ANTLR end "rule__PredicatedGroup__Group__0"


    // $ANTLR start "rule__PredicatedGroup__Group__0__Impl"
    // InternalXtext.g:7589:1: rule__PredicatedGroup__Group__0__Impl : ( ( rule__PredicatedGroup__Alternatives_0 ) ) ;
    public final void rule__PredicatedGroup__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7593:1: ( ( ( rule__PredicatedGroup__Alternatives_0 ) ) )
            // InternalXtext.g:7594:1: ( ( rule__PredicatedGroup__Alternatives_0 ) )
            {
            // InternalXtext.g:7594:1: ( ( rule__PredicatedGroup__Alternatives_0 ) )
            // InternalXtext.g:7595:1: ( rule__PredicatedGroup__Alternatives_0 )
            {
             before(grammarAccess.getPredicatedGroupAccess().getAlternatives_0()); 
            // InternalXtext.g:7596:1: ( rule__PredicatedGroup__Alternatives_0 )
            // InternalXtext.g:7596:2: rule__PredicatedGroup__Alternatives_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedGroup__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getPredicatedGroupAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedGroup__Group__0__Impl"


    // $ANTLR start "rule__PredicatedGroup__Group__1"
    // InternalXtext.g:7606:1: rule__PredicatedGroup__Group__1 : rule__PredicatedGroup__Group__1__Impl rule__PredicatedGroup__Group__2 ;
    public final void rule__PredicatedGroup__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7610:1: ( rule__PredicatedGroup__Group__1__Impl rule__PredicatedGroup__Group__2 )
            // InternalXtext.g:7611:2: rule__PredicatedGroup__Group__1__Impl rule__PredicatedGroup__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__PredicatedGroup__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedGroup__Group__2();

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
    // $ANTLR end "rule__PredicatedGroup__Group__1"


    // $ANTLR start "rule__PredicatedGroup__Group__1__Impl"
    // InternalXtext.g:7618:1: rule__PredicatedGroup__Group__1__Impl : ( '(' ) ;
    public final void rule__PredicatedGroup__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7622:1: ( ( '(' ) )
            // InternalXtext.g:7623:1: ( '(' )
            {
            // InternalXtext.g:7623:1: ( '(' )
            // InternalXtext.g:7624:1: '('
            {
             before(grammarAccess.getPredicatedGroupAccess().getLeftParenthesisKeyword_1()); 
            match(input,22,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getPredicatedGroupAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedGroup__Group__1__Impl"


    // $ANTLR start "rule__PredicatedGroup__Group__2"
    // InternalXtext.g:7637:1: rule__PredicatedGroup__Group__2 : rule__PredicatedGroup__Group__2__Impl rule__PredicatedGroup__Group__3 ;
    public final void rule__PredicatedGroup__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7641:1: ( rule__PredicatedGroup__Group__2__Impl rule__PredicatedGroup__Group__3 )
            // InternalXtext.g:7642:2: rule__PredicatedGroup__Group__2__Impl rule__PredicatedGroup__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_40);
            rule__PredicatedGroup__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedGroup__Group__3();

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
    // $ANTLR end "rule__PredicatedGroup__Group__2"


    // $ANTLR start "rule__PredicatedGroup__Group__2__Impl"
    // InternalXtext.g:7649:1: rule__PredicatedGroup__Group__2__Impl : ( ( rule__PredicatedGroup__ElementsAssignment_2 ) ) ;
    public final void rule__PredicatedGroup__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7653:1: ( ( ( rule__PredicatedGroup__ElementsAssignment_2 ) ) )
            // InternalXtext.g:7654:1: ( ( rule__PredicatedGroup__ElementsAssignment_2 ) )
            {
            // InternalXtext.g:7654:1: ( ( rule__PredicatedGroup__ElementsAssignment_2 ) )
            // InternalXtext.g:7655:1: ( rule__PredicatedGroup__ElementsAssignment_2 )
            {
             before(grammarAccess.getPredicatedGroupAccess().getElementsAssignment_2()); 
            // InternalXtext.g:7656:1: ( rule__PredicatedGroup__ElementsAssignment_2 )
            // InternalXtext.g:7656:2: rule__PredicatedGroup__ElementsAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedGroup__ElementsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getPredicatedGroupAccess().getElementsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedGroup__Group__2__Impl"


    // $ANTLR start "rule__PredicatedGroup__Group__3"
    // InternalXtext.g:7666:1: rule__PredicatedGroup__Group__3 : rule__PredicatedGroup__Group__3__Impl ;
    public final void rule__PredicatedGroup__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7670:1: ( rule__PredicatedGroup__Group__3__Impl )
            // InternalXtext.g:7671:2: rule__PredicatedGroup__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedGroup__Group__3__Impl();

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
    // $ANTLR end "rule__PredicatedGroup__Group__3"


    // $ANTLR start "rule__PredicatedGroup__Group__3__Impl"
    // InternalXtext.g:7677:1: rule__PredicatedGroup__Group__3__Impl : ( ')' ) ;
    public final void rule__PredicatedGroup__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7681:1: ( ( ')' ) )
            // InternalXtext.g:7682:1: ( ')' )
            {
            // InternalXtext.g:7682:1: ( ')' )
            // InternalXtext.g:7683:1: ')'
            {
             before(grammarAccess.getPredicatedGroupAccess().getRightParenthesisKeyword_3()); 
            match(input,23,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getPredicatedGroupAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedGroup__Group__3__Impl"


    // $ANTLR start "rule__TerminalRule__Group__0"
    // InternalXtext.g:7704:1: rule__TerminalRule__Group__0 : rule__TerminalRule__Group__0__Impl rule__TerminalRule__Group__1 ;
    public final void rule__TerminalRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7708:1: ( rule__TerminalRule__Group__0__Impl rule__TerminalRule__Group__1 )
            // InternalXtext.g:7709:2: rule__TerminalRule__Group__0__Impl rule__TerminalRule__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_18);
            rule__TerminalRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7716:1: rule__TerminalRule__Group__0__Impl : ( 'terminal' ) ;
    public final void rule__TerminalRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7720:1: ( ( 'terminal' ) )
            // InternalXtext.g:7721:1: ( 'terminal' )
            {
            // InternalXtext.g:7721:1: ( 'terminal' )
            // InternalXtext.g:7722:1: 'terminal'
            {
             before(grammarAccess.getTerminalRuleAccess().getTerminalKeyword_0()); 
            match(input,42,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:7735:1: rule__TerminalRule__Group__1 : rule__TerminalRule__Group__1__Impl rule__TerminalRule__Group__2 ;
    public final void rule__TerminalRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7739:1: ( rule__TerminalRule__Group__1__Impl rule__TerminalRule__Group__2 )
            // InternalXtext.g:7740:2: rule__TerminalRule__Group__1__Impl rule__TerminalRule__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_47);
            rule__TerminalRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7747:1: rule__TerminalRule__Group__1__Impl : ( ( rule__TerminalRule__Alternatives_1 ) ) ;
    public final void rule__TerminalRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7751:1: ( ( ( rule__TerminalRule__Alternatives_1 ) ) )
            // InternalXtext.g:7752:1: ( ( rule__TerminalRule__Alternatives_1 ) )
            {
            // InternalXtext.g:7752:1: ( ( rule__TerminalRule__Alternatives_1 ) )
            // InternalXtext.g:7753:1: ( rule__TerminalRule__Alternatives_1 )
            {
             before(grammarAccess.getTerminalRuleAccess().getAlternatives_1()); 
            // InternalXtext.g:7754:1: ( rule__TerminalRule__Alternatives_1 )
            // InternalXtext.g:7754:2: rule__TerminalRule__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7764:1: rule__TerminalRule__Group__2 : rule__TerminalRule__Group__2__Impl rule__TerminalRule__Group__3 ;
    public final void rule__TerminalRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7768:1: ( rule__TerminalRule__Group__2__Impl rule__TerminalRule__Group__3 )
            // InternalXtext.g:7769:2: rule__TerminalRule__Group__2__Impl rule__TerminalRule__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_48);
            rule__TerminalRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7776:1: rule__TerminalRule__Group__2__Impl : ( ':' ) ;
    public final void rule__TerminalRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7780:1: ( ( ':' ) )
            // InternalXtext.g:7781:1: ( ':' )
            {
            // InternalXtext.g:7781:1: ( ':' )
            // InternalXtext.g:7782:1: ':'
            {
             before(grammarAccess.getTerminalRuleAccess().getColonKeyword_2()); 
            match(input,28,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:7795:1: rule__TerminalRule__Group__3 : rule__TerminalRule__Group__3__Impl rule__TerminalRule__Group__4 ;
    public final void rule__TerminalRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7799:1: ( rule__TerminalRule__Group__3__Impl rule__TerminalRule__Group__4 )
            // InternalXtext.g:7800:2: rule__TerminalRule__Group__3__Impl rule__TerminalRule__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_17);
            rule__TerminalRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7807:1: rule__TerminalRule__Group__3__Impl : ( ( rule__TerminalRule__AlternativesAssignment_3 ) ) ;
    public final void rule__TerminalRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7811:1: ( ( ( rule__TerminalRule__AlternativesAssignment_3 ) ) )
            // InternalXtext.g:7812:1: ( ( rule__TerminalRule__AlternativesAssignment_3 ) )
            {
            // InternalXtext.g:7812:1: ( ( rule__TerminalRule__AlternativesAssignment_3 ) )
            // InternalXtext.g:7813:1: ( rule__TerminalRule__AlternativesAssignment_3 )
            {
             before(grammarAccess.getTerminalRuleAccess().getAlternativesAssignment_3()); 
            // InternalXtext.g:7814:1: ( rule__TerminalRule__AlternativesAssignment_3 )
            // InternalXtext.g:7814:2: rule__TerminalRule__AlternativesAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7824:1: rule__TerminalRule__Group__4 : rule__TerminalRule__Group__4__Impl ;
    public final void rule__TerminalRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7828:1: ( rule__TerminalRule__Group__4__Impl )
            // InternalXtext.g:7829:2: rule__TerminalRule__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7835:1: rule__TerminalRule__Group__4__Impl : ( ';' ) ;
    public final void rule__TerminalRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7839:1: ( ( ';' ) )
            // InternalXtext.g:7840:1: ( ';' )
            {
            // InternalXtext.g:7840:1: ( ';' )
            // InternalXtext.g:7841:1: ';'
            {
             before(grammarAccess.getTerminalRuleAccess().getSemicolonKeyword_4()); 
            match(input,29,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:7864:1: rule__TerminalRule__Group_1_0__0 : rule__TerminalRule__Group_1_0__0__Impl rule__TerminalRule__Group_1_0__1 ;
    public final void rule__TerminalRule__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7868:1: ( rule__TerminalRule__Group_1_0__0__Impl rule__TerminalRule__Group_1_0__1 )
            // InternalXtext.g:7869:2: rule__TerminalRule__Group_1_0__0__Impl rule__TerminalRule__Group_1_0__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__TerminalRule__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7876:1: rule__TerminalRule__Group_1_0__0__Impl : ( ( rule__TerminalRule__FragmentAssignment_1_0_0 ) ) ;
    public final void rule__TerminalRule__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7880:1: ( ( ( rule__TerminalRule__FragmentAssignment_1_0_0 ) ) )
            // InternalXtext.g:7881:1: ( ( rule__TerminalRule__FragmentAssignment_1_0_0 ) )
            {
            // InternalXtext.g:7881:1: ( ( rule__TerminalRule__FragmentAssignment_1_0_0 ) )
            // InternalXtext.g:7882:1: ( rule__TerminalRule__FragmentAssignment_1_0_0 )
            {
             before(grammarAccess.getTerminalRuleAccess().getFragmentAssignment_1_0_0()); 
            // InternalXtext.g:7883:1: ( rule__TerminalRule__FragmentAssignment_1_0_0 )
            // InternalXtext.g:7883:2: rule__TerminalRule__FragmentAssignment_1_0_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7893:1: rule__TerminalRule__Group_1_0__1 : rule__TerminalRule__Group_1_0__1__Impl ;
    public final void rule__TerminalRule__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7897:1: ( rule__TerminalRule__Group_1_0__1__Impl )
            // InternalXtext.g:7898:2: rule__TerminalRule__Group_1_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7904:1: rule__TerminalRule__Group_1_0__1__Impl : ( ( rule__TerminalRule__NameAssignment_1_0_1 ) ) ;
    public final void rule__TerminalRule__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7908:1: ( ( ( rule__TerminalRule__NameAssignment_1_0_1 ) ) )
            // InternalXtext.g:7909:1: ( ( rule__TerminalRule__NameAssignment_1_0_1 ) )
            {
            // InternalXtext.g:7909:1: ( ( rule__TerminalRule__NameAssignment_1_0_1 ) )
            // InternalXtext.g:7910:1: ( rule__TerminalRule__NameAssignment_1_0_1 )
            {
             before(grammarAccess.getTerminalRuleAccess().getNameAssignment_1_0_1()); 
            // InternalXtext.g:7911:1: ( rule__TerminalRule__NameAssignment_1_0_1 )
            // InternalXtext.g:7911:2: rule__TerminalRule__NameAssignment_1_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7925:1: rule__TerminalRule__Group_1_1__0 : rule__TerminalRule__Group_1_1__0__Impl rule__TerminalRule__Group_1_1__1 ;
    public final void rule__TerminalRule__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7929:1: ( rule__TerminalRule__Group_1_1__0__Impl rule__TerminalRule__Group_1_1__1 )
            // InternalXtext.g:7930:2: rule__TerminalRule__Group_1_1__0__Impl rule__TerminalRule__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_21);
            rule__TerminalRule__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7937:1: rule__TerminalRule__Group_1_1__0__Impl : ( ( rule__TerminalRule__NameAssignment_1_1_0 ) ) ;
    public final void rule__TerminalRule__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7941:1: ( ( ( rule__TerminalRule__NameAssignment_1_1_0 ) ) )
            // InternalXtext.g:7942:1: ( ( rule__TerminalRule__NameAssignment_1_1_0 ) )
            {
            // InternalXtext.g:7942:1: ( ( rule__TerminalRule__NameAssignment_1_1_0 ) )
            // InternalXtext.g:7943:1: ( rule__TerminalRule__NameAssignment_1_1_0 )
            {
             before(grammarAccess.getTerminalRuleAccess().getNameAssignment_1_1_0()); 
            // InternalXtext.g:7944:1: ( rule__TerminalRule__NameAssignment_1_1_0 )
            // InternalXtext.g:7944:2: rule__TerminalRule__NameAssignment_1_1_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7954:1: rule__TerminalRule__Group_1_1__1 : rule__TerminalRule__Group_1_1__1__Impl ;
    public final void rule__TerminalRule__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7958:1: ( rule__TerminalRule__Group_1_1__1__Impl )
            // InternalXtext.g:7959:2: rule__TerminalRule__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7965:1: rule__TerminalRule__Group_1_1__1__Impl : ( ( rule__TerminalRule__Group_1_1_1__0 )? ) ;
    public final void rule__TerminalRule__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7969:1: ( ( ( rule__TerminalRule__Group_1_1_1__0 )? ) )
            // InternalXtext.g:7970:1: ( ( rule__TerminalRule__Group_1_1_1__0 )? )
            {
            // InternalXtext.g:7970:1: ( ( rule__TerminalRule__Group_1_1_1__0 )? )
            // InternalXtext.g:7971:1: ( rule__TerminalRule__Group_1_1_1__0 )?
            {
             before(grammarAccess.getTerminalRuleAccess().getGroup_1_1_1()); 
            // InternalXtext.g:7972:1: ( rule__TerminalRule__Group_1_1_1__0 )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==30) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalXtext.g:7972:2: rule__TerminalRule__Group_1_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7986:1: rule__TerminalRule__Group_1_1_1__0 : rule__TerminalRule__Group_1_1_1__0__Impl rule__TerminalRule__Group_1_1_1__1 ;
    public final void rule__TerminalRule__Group_1_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:7990:1: ( rule__TerminalRule__Group_1_1_1__0__Impl rule__TerminalRule__Group_1_1_1__1 )
            // InternalXtext.g:7991:2: rule__TerminalRule__Group_1_1_1__0__Impl rule__TerminalRule__Group_1_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_20);
            rule__TerminalRule__Group_1_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:7998:1: rule__TerminalRule__Group_1_1_1__0__Impl : ( 'returns' ) ;
    public final void rule__TerminalRule__Group_1_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8002:1: ( ( 'returns' ) )
            // InternalXtext.g:8003:1: ( 'returns' )
            {
            // InternalXtext.g:8003:1: ( 'returns' )
            // InternalXtext.g:8004:1: 'returns'
            {
             before(grammarAccess.getTerminalRuleAccess().getReturnsKeyword_1_1_1_0()); 
            match(input,30,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:8017:1: rule__TerminalRule__Group_1_1_1__1 : rule__TerminalRule__Group_1_1_1__1__Impl ;
    public final void rule__TerminalRule__Group_1_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8021:1: ( rule__TerminalRule__Group_1_1_1__1__Impl )
            // InternalXtext.g:8022:2: rule__TerminalRule__Group_1_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8028:1: rule__TerminalRule__Group_1_1_1__1__Impl : ( ( rule__TerminalRule__TypeAssignment_1_1_1_1 ) ) ;
    public final void rule__TerminalRule__Group_1_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8032:1: ( ( ( rule__TerminalRule__TypeAssignment_1_1_1_1 ) ) )
            // InternalXtext.g:8033:1: ( ( rule__TerminalRule__TypeAssignment_1_1_1_1 ) )
            {
            // InternalXtext.g:8033:1: ( ( rule__TerminalRule__TypeAssignment_1_1_1_1 ) )
            // InternalXtext.g:8034:1: ( rule__TerminalRule__TypeAssignment_1_1_1_1 )
            {
             before(grammarAccess.getTerminalRuleAccess().getTypeAssignment_1_1_1_1()); 
            // InternalXtext.g:8035:1: ( rule__TerminalRule__TypeAssignment_1_1_1_1 )
            // InternalXtext.g:8035:2: rule__TerminalRule__TypeAssignment_1_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8049:1: rule__TerminalAlternatives__Group__0 : rule__TerminalAlternatives__Group__0__Impl rule__TerminalAlternatives__Group__1 ;
    public final void rule__TerminalAlternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8053:1: ( rule__TerminalAlternatives__Group__0__Impl rule__TerminalAlternatives__Group__1 )
            // InternalXtext.g:8054:2: rule__TerminalAlternatives__Group__0__Impl rule__TerminalAlternatives__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_25);
            rule__TerminalAlternatives__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8061:1: rule__TerminalAlternatives__Group__0__Impl : ( ruleTerminalGroup ) ;
    public final void rule__TerminalAlternatives__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8065:1: ( ( ruleTerminalGroup ) )
            // InternalXtext.g:8066:1: ( ruleTerminalGroup )
            {
            // InternalXtext.g:8066:1: ( ruleTerminalGroup )
            // InternalXtext.g:8067:1: ruleTerminalGroup
            {
             before(grammarAccess.getTerminalAlternativesAccess().getTerminalGroupParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8078:1: rule__TerminalAlternatives__Group__1 : rule__TerminalAlternatives__Group__1__Impl ;
    public final void rule__TerminalAlternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8082:1: ( rule__TerminalAlternatives__Group__1__Impl )
            // InternalXtext.g:8083:2: rule__TerminalAlternatives__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8089:1: rule__TerminalAlternatives__Group__1__Impl : ( ( rule__TerminalAlternatives__Group_1__0 )? ) ;
    public final void rule__TerminalAlternatives__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8093:1: ( ( ( rule__TerminalAlternatives__Group_1__0 )? ) )
            // InternalXtext.g:8094:1: ( ( rule__TerminalAlternatives__Group_1__0 )? )
            {
            // InternalXtext.g:8094:1: ( ( rule__TerminalAlternatives__Group_1__0 )? )
            // InternalXtext.g:8095:1: ( rule__TerminalAlternatives__Group_1__0 )?
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup_1()); 
            // InternalXtext.g:8096:1: ( rule__TerminalAlternatives__Group_1__0 )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==34) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalXtext.g:8096:2: rule__TerminalAlternatives__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8110:1: rule__TerminalAlternatives__Group_1__0 : rule__TerminalAlternatives__Group_1__0__Impl rule__TerminalAlternatives__Group_1__1 ;
    public final void rule__TerminalAlternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8114:1: ( rule__TerminalAlternatives__Group_1__0__Impl rule__TerminalAlternatives__Group_1__1 )
            // InternalXtext.g:8115:2: rule__TerminalAlternatives__Group_1__0__Impl rule__TerminalAlternatives__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_25);
            rule__TerminalAlternatives__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8122:1: rule__TerminalAlternatives__Group_1__0__Impl : ( () ) ;
    public final void rule__TerminalAlternatives__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8126:1: ( ( () ) )
            // InternalXtext.g:8127:1: ( () )
            {
            // InternalXtext.g:8127:1: ( () )
            // InternalXtext.g:8128:1: ()
            {
             before(grammarAccess.getTerminalAlternativesAccess().getAlternativesElementsAction_1_0()); 
            // InternalXtext.g:8129:1: ()
            // InternalXtext.g:8131:1: 
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
    // InternalXtext.g:8141:1: rule__TerminalAlternatives__Group_1__1 : rule__TerminalAlternatives__Group_1__1__Impl ;
    public final void rule__TerminalAlternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8145:1: ( rule__TerminalAlternatives__Group_1__1__Impl )
            // InternalXtext.g:8146:2: rule__TerminalAlternatives__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8152:1: rule__TerminalAlternatives__Group_1__1__Impl : ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) ) ;
    public final void rule__TerminalAlternatives__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8156:1: ( ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) ) )
            // InternalXtext.g:8157:1: ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) )
            {
            // InternalXtext.g:8157:1: ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) )
            // InternalXtext.g:8158:1: ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* )
            {
            // InternalXtext.g:8158:1: ( ( rule__TerminalAlternatives__Group_1_1__0 ) )
            // InternalXtext.g:8159:1: ( rule__TerminalAlternatives__Group_1_1__0 )
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 
            // InternalXtext.g:8160:1: ( rule__TerminalAlternatives__Group_1_1__0 )
            // InternalXtext.g:8160:2: rule__TerminalAlternatives__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_26);
            rule__TerminalAlternatives__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 

            }

            // InternalXtext.g:8163:1: ( ( rule__TerminalAlternatives__Group_1_1__0 )* )
            // InternalXtext.g:8164:1: ( rule__TerminalAlternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 
            // InternalXtext.g:8165:1: ( rule__TerminalAlternatives__Group_1_1__0 )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==34) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // InternalXtext.g:8165:2: rule__TerminalAlternatives__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_26);
            	    rule__TerminalAlternatives__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop68;
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
    // InternalXtext.g:8180:1: rule__TerminalAlternatives__Group_1_1__0 : rule__TerminalAlternatives__Group_1_1__0__Impl rule__TerminalAlternatives__Group_1_1__1 ;
    public final void rule__TerminalAlternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8184:1: ( rule__TerminalAlternatives__Group_1_1__0__Impl rule__TerminalAlternatives__Group_1_1__1 )
            // InternalXtext.g:8185:2: rule__TerminalAlternatives__Group_1_1__0__Impl rule__TerminalAlternatives__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_48);
            rule__TerminalAlternatives__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8192:1: rule__TerminalAlternatives__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__TerminalAlternatives__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8196:1: ( ( '|' ) )
            // InternalXtext.g:8197:1: ( '|' )
            {
            // InternalXtext.g:8197:1: ( '|' )
            // InternalXtext.g:8198:1: '|'
            {
             before(grammarAccess.getTerminalAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,34,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:8211:1: rule__TerminalAlternatives__Group_1_1__1 : rule__TerminalAlternatives__Group_1_1__1__Impl ;
    public final void rule__TerminalAlternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8215:1: ( rule__TerminalAlternatives__Group_1_1__1__Impl )
            // InternalXtext.g:8216:2: rule__TerminalAlternatives__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8222:1: rule__TerminalAlternatives__Group_1_1__1__Impl : ( ( rule__TerminalAlternatives__ElementsAssignment_1_1_1 ) ) ;
    public final void rule__TerminalAlternatives__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8226:1: ( ( ( rule__TerminalAlternatives__ElementsAssignment_1_1_1 ) ) )
            // InternalXtext.g:8227:1: ( ( rule__TerminalAlternatives__ElementsAssignment_1_1_1 ) )
            {
            // InternalXtext.g:8227:1: ( ( rule__TerminalAlternatives__ElementsAssignment_1_1_1 ) )
            // InternalXtext.g:8228:1: ( rule__TerminalAlternatives__ElementsAssignment_1_1_1 )
            {
             before(grammarAccess.getTerminalAlternativesAccess().getElementsAssignment_1_1_1()); 
            // InternalXtext.g:8229:1: ( rule__TerminalAlternatives__ElementsAssignment_1_1_1 )
            // InternalXtext.g:8229:2: rule__TerminalAlternatives__ElementsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8243:1: rule__TerminalGroup__Group__0 : rule__TerminalGroup__Group__0__Impl rule__TerminalGroup__Group__1 ;
    public final void rule__TerminalGroup__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8247:1: ( rule__TerminalGroup__Group__0__Impl rule__TerminalGroup__Group__1 )
            // InternalXtext.g:8248:2: rule__TerminalGroup__Group__0__Impl rule__TerminalGroup__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_48);
            rule__TerminalGroup__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8255:1: rule__TerminalGroup__Group__0__Impl : ( ruleTerminalToken ) ;
    public final void rule__TerminalGroup__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8259:1: ( ( ruleTerminalToken ) )
            // InternalXtext.g:8260:1: ( ruleTerminalToken )
            {
            // InternalXtext.g:8260:1: ( ruleTerminalToken )
            // InternalXtext.g:8261:1: ruleTerminalToken
            {
             before(grammarAccess.getTerminalGroupAccess().getTerminalTokenParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8272:1: rule__TerminalGroup__Group__1 : rule__TerminalGroup__Group__1__Impl ;
    public final void rule__TerminalGroup__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8276:1: ( rule__TerminalGroup__Group__1__Impl )
            // InternalXtext.g:8277:2: rule__TerminalGroup__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8283:1: rule__TerminalGroup__Group__1__Impl : ( ( rule__TerminalGroup__Group_1__0 )? ) ;
    public final void rule__TerminalGroup__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8287:1: ( ( ( rule__TerminalGroup__Group_1__0 )? ) )
            // InternalXtext.g:8288:1: ( ( rule__TerminalGroup__Group_1__0 )? )
            {
            // InternalXtext.g:8288:1: ( ( rule__TerminalGroup__Group_1__0 )? )
            // InternalXtext.g:8289:1: ( rule__TerminalGroup__Group_1__0 )?
            {
             before(grammarAccess.getTerminalGroupAccess().getGroup_1()); 
            // InternalXtext.g:8290:1: ( rule__TerminalGroup__Group_1__0 )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( ((LA69_0>=RULE_ID && LA69_0<=RULE_STRING)||(LA69_0>=16 && LA69_0<=17)||LA69_0==22||LA69_0==24||LA69_0==39||(LA69_0>=43 && LA69_0<=44)) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalXtext.g:8290:2: rule__TerminalGroup__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8304:1: rule__TerminalGroup__Group_1__0 : rule__TerminalGroup__Group_1__0__Impl rule__TerminalGroup__Group_1__1 ;
    public final void rule__TerminalGroup__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8308:1: ( rule__TerminalGroup__Group_1__0__Impl rule__TerminalGroup__Group_1__1 )
            // InternalXtext.g:8309:2: rule__TerminalGroup__Group_1__0__Impl rule__TerminalGroup__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_48);
            rule__TerminalGroup__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8316:1: rule__TerminalGroup__Group_1__0__Impl : ( () ) ;
    public final void rule__TerminalGroup__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8320:1: ( ( () ) )
            // InternalXtext.g:8321:1: ( () )
            {
            // InternalXtext.g:8321:1: ( () )
            // InternalXtext.g:8322:1: ()
            {
             before(grammarAccess.getTerminalGroupAccess().getGroupElementsAction_1_0()); 
            // InternalXtext.g:8323:1: ()
            // InternalXtext.g:8325:1: 
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
    // InternalXtext.g:8335:1: rule__TerminalGroup__Group_1__1 : rule__TerminalGroup__Group_1__1__Impl ;
    public final void rule__TerminalGroup__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8339:1: ( rule__TerminalGroup__Group_1__1__Impl )
            // InternalXtext.g:8340:2: rule__TerminalGroup__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8346:1: rule__TerminalGroup__Group_1__1__Impl : ( ( ( rule__TerminalGroup__ElementsAssignment_1_1 ) ) ( ( rule__TerminalGroup__ElementsAssignment_1_1 )* ) ) ;
    public final void rule__TerminalGroup__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8350:1: ( ( ( ( rule__TerminalGroup__ElementsAssignment_1_1 ) ) ( ( rule__TerminalGroup__ElementsAssignment_1_1 )* ) ) )
            // InternalXtext.g:8351:1: ( ( ( rule__TerminalGroup__ElementsAssignment_1_1 ) ) ( ( rule__TerminalGroup__ElementsAssignment_1_1 )* ) )
            {
            // InternalXtext.g:8351:1: ( ( ( rule__TerminalGroup__ElementsAssignment_1_1 ) ) ( ( rule__TerminalGroup__ElementsAssignment_1_1 )* ) )
            // InternalXtext.g:8352:1: ( ( rule__TerminalGroup__ElementsAssignment_1_1 ) ) ( ( rule__TerminalGroup__ElementsAssignment_1_1 )* )
            {
            // InternalXtext.g:8352:1: ( ( rule__TerminalGroup__ElementsAssignment_1_1 ) )
            // InternalXtext.g:8353:1: ( rule__TerminalGroup__ElementsAssignment_1_1 )
            {
             before(grammarAccess.getTerminalGroupAccess().getElementsAssignment_1_1()); 
            // InternalXtext.g:8354:1: ( rule__TerminalGroup__ElementsAssignment_1_1 )
            // InternalXtext.g:8354:2: rule__TerminalGroup__ElementsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_49);
            rule__TerminalGroup__ElementsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getTerminalGroupAccess().getElementsAssignment_1_1()); 

            }

            // InternalXtext.g:8357:1: ( ( rule__TerminalGroup__ElementsAssignment_1_1 )* )
            // InternalXtext.g:8358:1: ( rule__TerminalGroup__ElementsAssignment_1_1 )*
            {
             before(grammarAccess.getTerminalGroupAccess().getElementsAssignment_1_1()); 
            // InternalXtext.g:8359:1: ( rule__TerminalGroup__ElementsAssignment_1_1 )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( ((LA70_0>=RULE_ID && LA70_0<=RULE_STRING)||(LA70_0>=16 && LA70_0<=17)||LA70_0==22||LA70_0==24||LA70_0==39||(LA70_0>=43 && LA70_0<=44)) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // InternalXtext.g:8359:2: rule__TerminalGroup__ElementsAssignment_1_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_49);
            	    rule__TerminalGroup__ElementsAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop70;
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
    // InternalXtext.g:8374:1: rule__TerminalToken__Group__0 : rule__TerminalToken__Group__0__Impl rule__TerminalToken__Group__1 ;
    public final void rule__TerminalToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8378:1: ( rule__TerminalToken__Group__0__Impl rule__TerminalToken__Group__1 )
            // InternalXtext.g:8379:2: rule__TerminalToken__Group__0__Impl rule__TerminalToken__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_33);
            rule__TerminalToken__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8386:1: rule__TerminalToken__Group__0__Impl : ( ruleTerminalTokenElement ) ;
    public final void rule__TerminalToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8390:1: ( ( ruleTerminalTokenElement ) )
            // InternalXtext.g:8391:1: ( ruleTerminalTokenElement )
            {
            // InternalXtext.g:8391:1: ( ruleTerminalTokenElement )
            // InternalXtext.g:8392:1: ruleTerminalTokenElement
            {
             before(grammarAccess.getTerminalTokenAccess().getTerminalTokenElementParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8403:1: rule__TerminalToken__Group__1 : rule__TerminalToken__Group__1__Impl ;
    public final void rule__TerminalToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8407:1: ( rule__TerminalToken__Group__1__Impl )
            // InternalXtext.g:8408:2: rule__TerminalToken__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8414:1: rule__TerminalToken__Group__1__Impl : ( ( rule__TerminalToken__CardinalityAssignment_1 )? ) ;
    public final void rule__TerminalToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8418:1: ( ( ( rule__TerminalToken__CardinalityAssignment_1 )? ) )
            // InternalXtext.g:8419:1: ( ( rule__TerminalToken__CardinalityAssignment_1 )? )
            {
            // InternalXtext.g:8419:1: ( ( rule__TerminalToken__CardinalityAssignment_1 )? )
            // InternalXtext.g:8420:1: ( rule__TerminalToken__CardinalityAssignment_1 )?
            {
             before(grammarAccess.getTerminalTokenAccess().getCardinalityAssignment_1()); 
            // InternalXtext.g:8421:1: ( rule__TerminalToken__CardinalityAssignment_1 )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( ((LA71_0>=11 && LA71_0<=13)) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalXtext.g:8421:2: rule__TerminalToken__CardinalityAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8435:1: rule__ParenthesizedTerminalElement__Group__0 : rule__ParenthesizedTerminalElement__Group__0__Impl rule__ParenthesizedTerminalElement__Group__1 ;
    public final void rule__ParenthesizedTerminalElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8439:1: ( rule__ParenthesizedTerminalElement__Group__0__Impl rule__ParenthesizedTerminalElement__Group__1 )
            // InternalXtext.g:8440:2: rule__ParenthesizedTerminalElement__Group__0__Impl rule__ParenthesizedTerminalElement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_48);
            rule__ParenthesizedTerminalElement__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8447:1: rule__ParenthesizedTerminalElement__Group__0__Impl : ( '(' ) ;
    public final void rule__ParenthesizedTerminalElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8451:1: ( ( '(' ) )
            // InternalXtext.g:8452:1: ( '(' )
            {
            // InternalXtext.g:8452:1: ( '(' )
            // InternalXtext.g:8453:1: '('
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getLeftParenthesisKeyword_0()); 
            match(input,22,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:8466:1: rule__ParenthesizedTerminalElement__Group__1 : rule__ParenthesizedTerminalElement__Group__1__Impl rule__ParenthesizedTerminalElement__Group__2 ;
    public final void rule__ParenthesizedTerminalElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8470:1: ( rule__ParenthesizedTerminalElement__Group__1__Impl rule__ParenthesizedTerminalElement__Group__2 )
            // InternalXtext.g:8471:2: rule__ParenthesizedTerminalElement__Group__1__Impl rule__ParenthesizedTerminalElement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_40);
            rule__ParenthesizedTerminalElement__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8478:1: rule__ParenthesizedTerminalElement__Group__1__Impl : ( ruleTerminalAlternatives ) ;
    public final void rule__ParenthesizedTerminalElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8482:1: ( ( ruleTerminalAlternatives ) )
            // InternalXtext.g:8483:1: ( ruleTerminalAlternatives )
            {
            // InternalXtext.g:8483:1: ( ruleTerminalAlternatives )
            // InternalXtext.g:8484:1: ruleTerminalAlternatives
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getTerminalAlternativesParserRuleCall_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8495:1: rule__ParenthesizedTerminalElement__Group__2 : rule__ParenthesizedTerminalElement__Group__2__Impl ;
    public final void rule__ParenthesizedTerminalElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8499:1: ( rule__ParenthesizedTerminalElement__Group__2__Impl )
            // InternalXtext.g:8500:2: rule__ParenthesizedTerminalElement__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8506:1: rule__ParenthesizedTerminalElement__Group__2__Impl : ( ')' ) ;
    public final void rule__ParenthesizedTerminalElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8510:1: ( ( ')' ) )
            // InternalXtext.g:8511:1: ( ')' )
            {
            // InternalXtext.g:8511:1: ( ')' )
            // InternalXtext.g:8512:1: ')'
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getRightParenthesisKeyword_2()); 
            match(input,23,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:8531:1: rule__NegatedToken__Group__0 : rule__NegatedToken__Group__0__Impl rule__NegatedToken__Group__1 ;
    public final void rule__NegatedToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8535:1: ( rule__NegatedToken__Group__0__Impl rule__NegatedToken__Group__1 )
            // InternalXtext.g:8536:2: rule__NegatedToken__Group__0__Impl rule__NegatedToken__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_48);
            rule__NegatedToken__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8543:1: rule__NegatedToken__Group__0__Impl : ( '!' ) ;
    public final void rule__NegatedToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8547:1: ( ( '!' ) )
            // InternalXtext.g:8548:1: ( '!' )
            {
            // InternalXtext.g:8548:1: ( '!' )
            // InternalXtext.g:8549:1: '!'
            {
             before(grammarAccess.getNegatedTokenAccess().getExclamationMarkKeyword_0()); 
            match(input,39,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:8562:1: rule__NegatedToken__Group__1 : rule__NegatedToken__Group__1__Impl ;
    public final void rule__NegatedToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8566:1: ( rule__NegatedToken__Group__1__Impl )
            // InternalXtext.g:8567:2: rule__NegatedToken__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8573:1: rule__NegatedToken__Group__1__Impl : ( ( rule__NegatedToken__TerminalAssignment_1 ) ) ;
    public final void rule__NegatedToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8577:1: ( ( ( rule__NegatedToken__TerminalAssignment_1 ) ) )
            // InternalXtext.g:8578:1: ( ( rule__NegatedToken__TerminalAssignment_1 ) )
            {
            // InternalXtext.g:8578:1: ( ( rule__NegatedToken__TerminalAssignment_1 ) )
            // InternalXtext.g:8579:1: ( rule__NegatedToken__TerminalAssignment_1 )
            {
             before(grammarAccess.getNegatedTokenAccess().getTerminalAssignment_1()); 
            // InternalXtext.g:8580:1: ( rule__NegatedToken__TerminalAssignment_1 )
            // InternalXtext.g:8580:2: rule__NegatedToken__TerminalAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8594:1: rule__UntilToken__Group__0 : rule__UntilToken__Group__0__Impl rule__UntilToken__Group__1 ;
    public final void rule__UntilToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8598:1: ( rule__UntilToken__Group__0__Impl rule__UntilToken__Group__1 )
            // InternalXtext.g:8599:2: rule__UntilToken__Group__0__Impl rule__UntilToken__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_48);
            rule__UntilToken__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8606:1: rule__UntilToken__Group__0__Impl : ( '->' ) ;
    public final void rule__UntilToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8610:1: ( ( '->' ) )
            // InternalXtext.g:8611:1: ( '->' )
            {
            // InternalXtext.g:8611:1: ( '->' )
            // InternalXtext.g:8612:1: '->'
            {
             before(grammarAccess.getUntilTokenAccess().getHyphenMinusGreaterThanSignKeyword_0()); 
            match(input,43,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:8625:1: rule__UntilToken__Group__1 : rule__UntilToken__Group__1__Impl ;
    public final void rule__UntilToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8629:1: ( rule__UntilToken__Group__1__Impl )
            // InternalXtext.g:8630:2: rule__UntilToken__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8636:1: rule__UntilToken__Group__1__Impl : ( ( rule__UntilToken__TerminalAssignment_1 ) ) ;
    public final void rule__UntilToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8640:1: ( ( ( rule__UntilToken__TerminalAssignment_1 ) ) )
            // InternalXtext.g:8641:1: ( ( rule__UntilToken__TerminalAssignment_1 ) )
            {
            // InternalXtext.g:8641:1: ( ( rule__UntilToken__TerminalAssignment_1 ) )
            // InternalXtext.g:8642:1: ( rule__UntilToken__TerminalAssignment_1 )
            {
             before(grammarAccess.getUntilTokenAccess().getTerminalAssignment_1()); 
            // InternalXtext.g:8643:1: ( rule__UntilToken__TerminalAssignment_1 )
            // InternalXtext.g:8643:2: rule__UntilToken__TerminalAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8657:1: rule__Wildcard__Group__0 : rule__Wildcard__Group__0__Impl rule__Wildcard__Group__1 ;
    public final void rule__Wildcard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8661:1: ( rule__Wildcard__Group__0__Impl rule__Wildcard__Group__1 )
            // InternalXtext.g:8662:2: rule__Wildcard__Group__0__Impl rule__Wildcard__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__Wildcard__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8669:1: rule__Wildcard__Group__0__Impl : ( () ) ;
    public final void rule__Wildcard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8673:1: ( ( () ) )
            // InternalXtext.g:8674:1: ( () )
            {
            // InternalXtext.g:8674:1: ( () )
            // InternalXtext.g:8675:1: ()
            {
             before(grammarAccess.getWildcardAccess().getWildcardAction_0()); 
            // InternalXtext.g:8676:1: ()
            // InternalXtext.g:8678:1: 
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
    // InternalXtext.g:8688:1: rule__Wildcard__Group__1 : rule__Wildcard__Group__1__Impl ;
    public final void rule__Wildcard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8692:1: ( rule__Wildcard__Group__1__Impl )
            // InternalXtext.g:8693:2: rule__Wildcard__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8699:1: rule__Wildcard__Group__1__Impl : ( '.' ) ;
    public final void rule__Wildcard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8703:1: ( ( '.' ) )
            // InternalXtext.g:8704:1: ( '.' )
            {
            // InternalXtext.g:8704:1: ( '.' )
            // InternalXtext.g:8705:1: '.'
            {
             before(grammarAccess.getWildcardAccess().getFullStopKeyword_1()); 
            match(input,24,FollowSets000.FOLLOW_2); 
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


    // $ANTLR start "rule__EOF__Group__0"
    // InternalXtext.g:8722:1: rule__EOF__Group__0 : rule__EOF__Group__0__Impl rule__EOF__Group__1 ;
    public final void rule__EOF__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8726:1: ( rule__EOF__Group__0__Impl rule__EOF__Group__1 )
            // InternalXtext.g:8727:2: rule__EOF__Group__0__Impl rule__EOF__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_48);
            rule__EOF__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__EOF__Group__1();

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
    // $ANTLR end "rule__EOF__Group__0"


    // $ANTLR start "rule__EOF__Group__0__Impl"
    // InternalXtext.g:8734:1: rule__EOF__Group__0__Impl : ( () ) ;
    public final void rule__EOF__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8738:1: ( ( () ) )
            // InternalXtext.g:8739:1: ( () )
            {
            // InternalXtext.g:8739:1: ( () )
            // InternalXtext.g:8740:1: ()
            {
             before(grammarAccess.getEOFAccess().getEOFAction_0()); 
            // InternalXtext.g:8741:1: ()
            // InternalXtext.g:8743:1: 
            {
            }

             after(grammarAccess.getEOFAccess().getEOFAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EOF__Group__0__Impl"


    // $ANTLR start "rule__EOF__Group__1"
    // InternalXtext.g:8753:1: rule__EOF__Group__1 : rule__EOF__Group__1__Impl ;
    public final void rule__EOF__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8757:1: ( rule__EOF__Group__1__Impl )
            // InternalXtext.g:8758:2: rule__EOF__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EOF__Group__1__Impl();

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
    // $ANTLR end "rule__EOF__Group__1"


    // $ANTLR start "rule__EOF__Group__1__Impl"
    // InternalXtext.g:8764:1: rule__EOF__Group__1__Impl : ( 'EOF' ) ;
    public final void rule__EOF__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8768:1: ( ( 'EOF' ) )
            // InternalXtext.g:8769:1: ( 'EOF' )
            {
            // InternalXtext.g:8769:1: ( 'EOF' )
            // InternalXtext.g:8770:1: 'EOF'
            {
             before(grammarAccess.getEOFAccess().getEOFKeyword_1()); 
            match(input,44,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getEOFAccess().getEOFKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EOF__Group__1__Impl"


    // $ANTLR start "rule__CharacterRange__Group__0"
    // InternalXtext.g:8787:1: rule__CharacterRange__Group__0 : rule__CharacterRange__Group__0__Impl rule__CharacterRange__Group__1 ;
    public final void rule__CharacterRange__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8791:1: ( rule__CharacterRange__Group__0__Impl rule__CharacterRange__Group__1 )
            // InternalXtext.g:8792:2: rule__CharacterRange__Group__0__Impl rule__CharacterRange__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_50);
            rule__CharacterRange__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8799:1: rule__CharacterRange__Group__0__Impl : ( ruleKeyword ) ;
    public final void rule__CharacterRange__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8803:1: ( ( ruleKeyword ) )
            // InternalXtext.g:8804:1: ( ruleKeyword )
            {
            // InternalXtext.g:8804:1: ( ruleKeyword )
            // InternalXtext.g:8805:1: ruleKeyword
            {
             before(grammarAccess.getCharacterRangeAccess().getKeywordParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8816:1: rule__CharacterRange__Group__1 : rule__CharacterRange__Group__1__Impl ;
    public final void rule__CharacterRange__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8820:1: ( rule__CharacterRange__Group__1__Impl )
            // InternalXtext.g:8821:2: rule__CharacterRange__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8827:1: rule__CharacterRange__Group__1__Impl : ( ( rule__CharacterRange__Group_1__0 )? ) ;
    public final void rule__CharacterRange__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8831:1: ( ( ( rule__CharacterRange__Group_1__0 )? ) )
            // InternalXtext.g:8832:1: ( ( rule__CharacterRange__Group_1__0 )? )
            {
            // InternalXtext.g:8832:1: ( ( rule__CharacterRange__Group_1__0 )? )
            // InternalXtext.g:8833:1: ( rule__CharacterRange__Group_1__0 )?
            {
             before(grammarAccess.getCharacterRangeAccess().getGroup_1()); 
            // InternalXtext.g:8834:1: ( rule__CharacterRange__Group_1__0 )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==45) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalXtext.g:8834:2: rule__CharacterRange__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8848:1: rule__CharacterRange__Group_1__0 : rule__CharacterRange__Group_1__0__Impl rule__CharacterRange__Group_1__1 ;
    public final void rule__CharacterRange__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8852:1: ( rule__CharacterRange__Group_1__0__Impl rule__CharacterRange__Group_1__1 )
            // InternalXtext.g:8853:2: rule__CharacterRange__Group_1__0__Impl rule__CharacterRange__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_50);
            rule__CharacterRange__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8860:1: rule__CharacterRange__Group_1__0__Impl : ( () ) ;
    public final void rule__CharacterRange__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8864:1: ( ( () ) )
            // InternalXtext.g:8865:1: ( () )
            {
            // InternalXtext.g:8865:1: ( () )
            // InternalXtext.g:8866:1: ()
            {
             before(grammarAccess.getCharacterRangeAccess().getCharacterRangeLeftAction_1_0()); 
            // InternalXtext.g:8867:1: ()
            // InternalXtext.g:8869:1: 
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
    // InternalXtext.g:8879:1: rule__CharacterRange__Group_1__1 : rule__CharacterRange__Group_1__1__Impl rule__CharacterRange__Group_1__2 ;
    public final void rule__CharacterRange__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8883:1: ( rule__CharacterRange__Group_1__1__Impl rule__CharacterRange__Group_1__2 )
            // InternalXtext.g:8884:2: rule__CharacterRange__Group_1__1__Impl rule__CharacterRange__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__CharacterRange__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8891:1: rule__CharacterRange__Group_1__1__Impl : ( '..' ) ;
    public final void rule__CharacterRange__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8895:1: ( ( '..' ) )
            // InternalXtext.g:8896:1: ( '..' )
            {
            // InternalXtext.g:8896:1: ( '..' )
            // InternalXtext.g:8897:1: '..'
            {
             before(grammarAccess.getCharacterRangeAccess().getFullStopFullStopKeyword_1_1()); 
            match(input,45,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:8910:1: rule__CharacterRange__Group_1__2 : rule__CharacterRange__Group_1__2__Impl ;
    public final void rule__CharacterRange__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8914:1: ( rule__CharacterRange__Group_1__2__Impl )
            // InternalXtext.g:8915:2: rule__CharacterRange__Group_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8921:1: rule__CharacterRange__Group_1__2__Impl : ( ( rule__CharacterRange__RightAssignment_1_2 ) ) ;
    public final void rule__CharacterRange__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8925:1: ( ( ( rule__CharacterRange__RightAssignment_1_2 ) ) )
            // InternalXtext.g:8926:1: ( ( rule__CharacterRange__RightAssignment_1_2 ) )
            {
            // InternalXtext.g:8926:1: ( ( rule__CharacterRange__RightAssignment_1_2 ) )
            // InternalXtext.g:8927:1: ( rule__CharacterRange__RightAssignment_1_2 )
            {
             before(grammarAccess.getCharacterRangeAccess().getRightAssignment_1_2()); 
            // InternalXtext.g:8928:1: ( rule__CharacterRange__RightAssignment_1_2 )
            // InternalXtext.g:8928:2: rule__CharacterRange__RightAssignment_1_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8944:1: rule__EnumRule__Group__0 : rule__EnumRule__Group__0__Impl rule__EnumRule__Group__1 ;
    public final void rule__EnumRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8948:1: ( rule__EnumRule__Group__0__Impl rule__EnumRule__Group__1 )
            // InternalXtext.g:8949:2: rule__EnumRule__Group__0__Impl rule__EnumRule__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__EnumRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8956:1: rule__EnumRule__Group__0__Impl : ( 'enum' ) ;
    public final void rule__EnumRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8960:1: ( ( 'enum' ) )
            // InternalXtext.g:8961:1: ( 'enum' )
            {
            // InternalXtext.g:8961:1: ( 'enum' )
            // InternalXtext.g:8962:1: 'enum'
            {
             before(grammarAccess.getEnumRuleAccess().getEnumKeyword_0()); 
            match(input,46,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:8975:1: rule__EnumRule__Group__1 : rule__EnumRule__Group__1__Impl rule__EnumRule__Group__2 ;
    public final void rule__EnumRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8979:1: ( rule__EnumRule__Group__1__Impl rule__EnumRule__Group__2 )
            // InternalXtext.g:8980:2: rule__EnumRule__Group__1__Impl rule__EnumRule__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_51);
            rule__EnumRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:8987:1: rule__EnumRule__Group__1__Impl : ( ( rule__EnumRule__NameAssignment_1 ) ) ;
    public final void rule__EnumRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:8991:1: ( ( ( rule__EnumRule__NameAssignment_1 ) ) )
            // InternalXtext.g:8992:1: ( ( rule__EnumRule__NameAssignment_1 ) )
            {
            // InternalXtext.g:8992:1: ( ( rule__EnumRule__NameAssignment_1 ) )
            // InternalXtext.g:8993:1: ( rule__EnumRule__NameAssignment_1 )
            {
             before(grammarAccess.getEnumRuleAccess().getNameAssignment_1()); 
            // InternalXtext.g:8994:1: ( rule__EnumRule__NameAssignment_1 )
            // InternalXtext.g:8994:2: rule__EnumRule__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:9004:1: rule__EnumRule__Group__2 : rule__EnumRule__Group__2__Impl rule__EnumRule__Group__3 ;
    public final void rule__EnumRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9008:1: ( rule__EnumRule__Group__2__Impl rule__EnumRule__Group__3 )
            // InternalXtext.g:9009:2: rule__EnumRule__Group__2__Impl rule__EnumRule__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_51);
            rule__EnumRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:9016:1: rule__EnumRule__Group__2__Impl : ( ( rule__EnumRule__Group_2__0 )? ) ;
    public final void rule__EnumRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9020:1: ( ( ( rule__EnumRule__Group_2__0 )? ) )
            // InternalXtext.g:9021:1: ( ( rule__EnumRule__Group_2__0 )? )
            {
            // InternalXtext.g:9021:1: ( ( rule__EnumRule__Group_2__0 )? )
            // InternalXtext.g:9022:1: ( rule__EnumRule__Group_2__0 )?
            {
             before(grammarAccess.getEnumRuleAccess().getGroup_2()); 
            // InternalXtext.g:9023:1: ( rule__EnumRule__Group_2__0 )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==30) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalXtext.g:9023:2: rule__EnumRule__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:9033:1: rule__EnumRule__Group__3 : rule__EnumRule__Group__3__Impl rule__EnumRule__Group__4 ;
    public final void rule__EnumRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9037:1: ( rule__EnumRule__Group__3__Impl rule__EnumRule__Group__4 )
            // InternalXtext.g:9038:2: rule__EnumRule__Group__3__Impl rule__EnumRule__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_20);
            rule__EnumRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:9045:1: rule__EnumRule__Group__3__Impl : ( ':' ) ;
    public final void rule__EnumRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9049:1: ( ( ':' ) )
            // InternalXtext.g:9050:1: ( ':' )
            {
            // InternalXtext.g:9050:1: ( ':' )
            // InternalXtext.g:9051:1: ':'
            {
             before(grammarAccess.getEnumRuleAccess().getColonKeyword_3()); 
            match(input,28,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:9064:1: rule__EnumRule__Group__4 : rule__EnumRule__Group__4__Impl rule__EnumRule__Group__5 ;
    public final void rule__EnumRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9068:1: ( rule__EnumRule__Group__4__Impl rule__EnumRule__Group__5 )
            // InternalXtext.g:9069:2: rule__EnumRule__Group__4__Impl rule__EnumRule__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_17);
            rule__EnumRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:9076:1: rule__EnumRule__Group__4__Impl : ( ( rule__EnumRule__AlternativesAssignment_4 ) ) ;
    public final void rule__EnumRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9080:1: ( ( ( rule__EnumRule__AlternativesAssignment_4 ) ) )
            // InternalXtext.g:9081:1: ( ( rule__EnumRule__AlternativesAssignment_4 ) )
            {
            // InternalXtext.g:9081:1: ( ( rule__EnumRule__AlternativesAssignment_4 ) )
            // InternalXtext.g:9082:1: ( rule__EnumRule__AlternativesAssignment_4 )
            {
             before(grammarAccess.getEnumRuleAccess().getAlternativesAssignment_4()); 
            // InternalXtext.g:9083:1: ( rule__EnumRule__AlternativesAssignment_4 )
            // InternalXtext.g:9083:2: rule__EnumRule__AlternativesAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:9093:1: rule__EnumRule__Group__5 : rule__EnumRule__Group__5__Impl ;
    public final void rule__EnumRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9097:1: ( rule__EnumRule__Group__5__Impl )
            // InternalXtext.g:9098:2: rule__EnumRule__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:9104:1: rule__EnumRule__Group__5__Impl : ( ';' ) ;
    public final void rule__EnumRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9108:1: ( ( ';' ) )
            // InternalXtext.g:9109:1: ( ';' )
            {
            // InternalXtext.g:9109:1: ( ';' )
            // InternalXtext.g:9110:1: ';'
            {
             before(grammarAccess.getEnumRuleAccess().getSemicolonKeyword_5()); 
            match(input,29,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:9135:1: rule__EnumRule__Group_2__0 : rule__EnumRule__Group_2__0__Impl rule__EnumRule__Group_2__1 ;
    public final void rule__EnumRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9139:1: ( rule__EnumRule__Group_2__0__Impl rule__EnumRule__Group_2__1 )
            // InternalXtext.g:9140:2: rule__EnumRule__Group_2__0__Impl rule__EnumRule__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_20);
            rule__EnumRule__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:9147:1: rule__EnumRule__Group_2__0__Impl : ( 'returns' ) ;
    public final void rule__EnumRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9151:1: ( ( 'returns' ) )
            // InternalXtext.g:9152:1: ( 'returns' )
            {
            // InternalXtext.g:9152:1: ( 'returns' )
            // InternalXtext.g:9153:1: 'returns'
            {
             before(grammarAccess.getEnumRuleAccess().getReturnsKeyword_2_0()); 
            match(input,30,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:9166:1: rule__EnumRule__Group_2__1 : rule__EnumRule__Group_2__1__Impl ;
    public final void rule__EnumRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9170:1: ( rule__EnumRule__Group_2__1__Impl )
            // InternalXtext.g:9171:2: rule__EnumRule__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:9177:1: rule__EnumRule__Group_2__1__Impl : ( ( rule__EnumRule__TypeAssignment_2_1 ) ) ;
    public final void rule__EnumRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9181:1: ( ( ( rule__EnumRule__TypeAssignment_2_1 ) ) )
            // InternalXtext.g:9182:1: ( ( rule__EnumRule__TypeAssignment_2_1 ) )
            {
            // InternalXtext.g:9182:1: ( ( rule__EnumRule__TypeAssignment_2_1 ) )
            // InternalXtext.g:9183:1: ( rule__EnumRule__TypeAssignment_2_1 )
            {
             before(grammarAccess.getEnumRuleAccess().getTypeAssignment_2_1()); 
            // InternalXtext.g:9184:1: ( rule__EnumRule__TypeAssignment_2_1 )
            // InternalXtext.g:9184:2: rule__EnumRule__TypeAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:9198:1: rule__EnumLiterals__Group__0 : rule__EnumLiterals__Group__0__Impl rule__EnumLiterals__Group__1 ;
    public final void rule__EnumLiterals__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9202:1: ( rule__EnumLiterals__Group__0__Impl rule__EnumLiterals__Group__1 )
            // InternalXtext.g:9203:2: rule__EnumLiterals__Group__0__Impl rule__EnumLiterals__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_25);
            rule__EnumLiterals__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:9210:1: rule__EnumLiterals__Group__0__Impl : ( ruleEnumLiteralDeclaration ) ;
    public final void rule__EnumLiterals__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9214:1: ( ( ruleEnumLiteralDeclaration ) )
            // InternalXtext.g:9215:1: ( ruleEnumLiteralDeclaration )
            {
            // InternalXtext.g:9215:1: ( ruleEnumLiteralDeclaration )
            // InternalXtext.g:9216:1: ruleEnumLiteralDeclaration
            {
             before(grammarAccess.getEnumLiteralsAccess().getEnumLiteralDeclarationParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:9227:1: rule__EnumLiterals__Group__1 : rule__EnumLiterals__Group__1__Impl ;
    public final void rule__EnumLiterals__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9231:1: ( rule__EnumLiterals__Group__1__Impl )
            // InternalXtext.g:9232:2: rule__EnumLiterals__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:9238:1: rule__EnumLiterals__Group__1__Impl : ( ( rule__EnumLiterals__Group_1__0 )? ) ;
    public final void rule__EnumLiterals__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9242:1: ( ( ( rule__EnumLiterals__Group_1__0 )? ) )
            // InternalXtext.g:9243:1: ( ( rule__EnumLiterals__Group_1__0 )? )
            {
            // InternalXtext.g:9243:1: ( ( rule__EnumLiterals__Group_1__0 )? )
            // InternalXtext.g:9244:1: ( rule__EnumLiterals__Group_1__0 )?
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup_1()); 
            // InternalXtext.g:9245:1: ( rule__EnumLiterals__Group_1__0 )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==34) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalXtext.g:9245:2: rule__EnumLiterals__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:9259:1: rule__EnumLiterals__Group_1__0 : rule__EnumLiterals__Group_1__0__Impl rule__EnumLiterals__Group_1__1 ;
    public final void rule__EnumLiterals__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9263:1: ( rule__EnumLiterals__Group_1__0__Impl rule__EnumLiterals__Group_1__1 )
            // InternalXtext.g:9264:2: rule__EnumLiterals__Group_1__0__Impl rule__EnumLiterals__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_25);
            rule__EnumLiterals__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:9271:1: rule__EnumLiterals__Group_1__0__Impl : ( () ) ;
    public final void rule__EnumLiterals__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9275:1: ( ( () ) )
            // InternalXtext.g:9276:1: ( () )
            {
            // InternalXtext.g:9276:1: ( () )
            // InternalXtext.g:9277:1: ()
            {
             before(grammarAccess.getEnumLiteralsAccess().getAlternativesElementsAction_1_0()); 
            // InternalXtext.g:9278:1: ()
            // InternalXtext.g:9280:1: 
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
    // InternalXtext.g:9290:1: rule__EnumLiterals__Group_1__1 : rule__EnumLiterals__Group_1__1__Impl ;
    public final void rule__EnumLiterals__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9294:1: ( rule__EnumLiterals__Group_1__1__Impl )
            // InternalXtext.g:9295:2: rule__EnumLiterals__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:9301:1: rule__EnumLiterals__Group_1__1__Impl : ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) ) ;
    public final void rule__EnumLiterals__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9305:1: ( ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) ) )
            // InternalXtext.g:9306:1: ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) )
            {
            // InternalXtext.g:9306:1: ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) )
            // InternalXtext.g:9307:1: ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* )
            {
            // InternalXtext.g:9307:1: ( ( rule__EnumLiterals__Group_1_1__0 ) )
            // InternalXtext.g:9308:1: ( rule__EnumLiterals__Group_1_1__0 )
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 
            // InternalXtext.g:9309:1: ( rule__EnumLiterals__Group_1_1__0 )
            // InternalXtext.g:9309:2: rule__EnumLiterals__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_26);
            rule__EnumLiterals__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 

            }

            // InternalXtext.g:9312:1: ( ( rule__EnumLiterals__Group_1_1__0 )* )
            // InternalXtext.g:9313:1: ( rule__EnumLiterals__Group_1_1__0 )*
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 
            // InternalXtext.g:9314:1: ( rule__EnumLiterals__Group_1_1__0 )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==34) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // InternalXtext.g:9314:2: rule__EnumLiterals__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_26);
            	    rule__EnumLiterals__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop75;
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
    // InternalXtext.g:9329:1: rule__EnumLiterals__Group_1_1__0 : rule__EnumLiterals__Group_1_1__0__Impl rule__EnumLiterals__Group_1_1__1 ;
    public final void rule__EnumLiterals__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9333:1: ( rule__EnumLiterals__Group_1_1__0__Impl rule__EnumLiterals__Group_1_1__1 )
            // InternalXtext.g:9334:2: rule__EnumLiterals__Group_1_1__0__Impl rule__EnumLiterals__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_20);
            rule__EnumLiterals__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:9341:1: rule__EnumLiterals__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__EnumLiterals__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9345:1: ( ( '|' ) )
            // InternalXtext.g:9346:1: ( '|' )
            {
            // InternalXtext.g:9346:1: ( '|' )
            // InternalXtext.g:9347:1: '|'
            {
             before(grammarAccess.getEnumLiteralsAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,34,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:9360:1: rule__EnumLiterals__Group_1_1__1 : rule__EnumLiterals__Group_1_1__1__Impl ;
    public final void rule__EnumLiterals__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9364:1: ( rule__EnumLiterals__Group_1_1__1__Impl )
            // InternalXtext.g:9365:2: rule__EnumLiterals__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:9371:1: rule__EnumLiterals__Group_1_1__1__Impl : ( ( rule__EnumLiterals__ElementsAssignment_1_1_1 ) ) ;
    public final void rule__EnumLiterals__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9375:1: ( ( ( rule__EnumLiterals__ElementsAssignment_1_1_1 ) ) )
            // InternalXtext.g:9376:1: ( ( rule__EnumLiterals__ElementsAssignment_1_1_1 ) )
            {
            // InternalXtext.g:9376:1: ( ( rule__EnumLiterals__ElementsAssignment_1_1_1 ) )
            // InternalXtext.g:9377:1: ( rule__EnumLiterals__ElementsAssignment_1_1_1 )
            {
             before(grammarAccess.getEnumLiteralsAccess().getElementsAssignment_1_1_1()); 
            // InternalXtext.g:9378:1: ( rule__EnumLiterals__ElementsAssignment_1_1_1 )
            // InternalXtext.g:9378:2: rule__EnumLiterals__ElementsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:9392:1: rule__EnumLiteralDeclaration__Group__0 : rule__EnumLiteralDeclaration__Group__0__Impl rule__EnumLiteralDeclaration__Group__1 ;
    public final void rule__EnumLiteralDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9396:1: ( rule__EnumLiteralDeclaration__Group__0__Impl rule__EnumLiteralDeclaration__Group__1 )
            // InternalXtext.g:9397:2: rule__EnumLiteralDeclaration__Group__0__Impl rule__EnumLiteralDeclaration__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_38);
            rule__EnumLiteralDeclaration__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:9404:1: rule__EnumLiteralDeclaration__Group__0__Impl : ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) ) ;
    public final void rule__EnumLiteralDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9408:1: ( ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) ) )
            // InternalXtext.g:9409:1: ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) )
            {
            // InternalXtext.g:9409:1: ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) )
            // InternalXtext.g:9410:1: ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralAssignment_0()); 
            // InternalXtext.g:9411:1: ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 )
            // InternalXtext.g:9411:2: rule__EnumLiteralDeclaration__EnumLiteralAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:9421:1: rule__EnumLiteralDeclaration__Group__1 : rule__EnumLiteralDeclaration__Group__1__Impl ;
    public final void rule__EnumLiteralDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9425:1: ( rule__EnumLiteralDeclaration__Group__1__Impl )
            // InternalXtext.g:9426:2: rule__EnumLiteralDeclaration__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:9432:1: rule__EnumLiteralDeclaration__Group__1__Impl : ( ( rule__EnumLiteralDeclaration__Group_1__0 )? ) ;
    public final void rule__EnumLiteralDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9436:1: ( ( ( rule__EnumLiteralDeclaration__Group_1__0 )? ) )
            // InternalXtext.g:9437:1: ( ( rule__EnumLiteralDeclaration__Group_1__0 )? )
            {
            // InternalXtext.g:9437:1: ( ( rule__EnumLiteralDeclaration__Group_1__0 )? )
            // InternalXtext.g:9438:1: ( rule__EnumLiteralDeclaration__Group_1__0 )?
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getGroup_1()); 
            // InternalXtext.g:9439:1: ( rule__EnumLiteralDeclaration__Group_1__0 )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==14) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalXtext.g:9439:2: rule__EnumLiteralDeclaration__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:9453:1: rule__EnumLiteralDeclaration__Group_1__0 : rule__EnumLiteralDeclaration__Group_1__0__Impl rule__EnumLiteralDeclaration__Group_1__1 ;
    public final void rule__EnumLiteralDeclaration__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9457:1: ( rule__EnumLiteralDeclaration__Group_1__0__Impl rule__EnumLiteralDeclaration__Group_1__1 )
            // InternalXtext.g:9458:2: rule__EnumLiteralDeclaration__Group_1__0__Impl rule__EnumLiteralDeclaration__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__EnumLiteralDeclaration__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:9465:1: rule__EnumLiteralDeclaration__Group_1__0__Impl : ( '=' ) ;
    public final void rule__EnumLiteralDeclaration__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9469:1: ( ( '=' ) )
            // InternalXtext.g:9470:1: ( '=' )
            {
            // InternalXtext.g:9470:1: ( '=' )
            // InternalXtext.g:9471:1: '='
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEqualsSignKeyword_1_0()); 
            match(input,14,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:9484:1: rule__EnumLiteralDeclaration__Group_1__1 : rule__EnumLiteralDeclaration__Group_1__1__Impl ;
    public final void rule__EnumLiteralDeclaration__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9488:1: ( rule__EnumLiteralDeclaration__Group_1__1__Impl )
            // InternalXtext.g:9489:2: rule__EnumLiteralDeclaration__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:9495:1: rule__EnumLiteralDeclaration__Group_1__1__Impl : ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) ) ;
    public final void rule__EnumLiteralDeclaration__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9499:1: ( ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) ) )
            // InternalXtext.g:9500:1: ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) )
            {
            // InternalXtext.g:9500:1: ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) )
            // InternalXtext.g:9501:1: ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralAssignment_1_1()); 
            // InternalXtext.g:9502:1: ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 )
            // InternalXtext.g:9502:2: rule__EnumLiteralDeclaration__LiteralAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:9517:1: rule__Grammar__NameAssignment_1 : ( ruleGrammarID ) ;
    public final void rule__Grammar__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9521:1: ( ( ruleGrammarID ) )
            // InternalXtext.g:9522:1: ( ruleGrammarID )
            {
            // InternalXtext.g:9522:1: ( ruleGrammarID )
            // InternalXtext.g:9523:1: ruleGrammarID
            {
             before(grammarAccess.getGrammarAccess().getNameGrammarIDParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:9532:1: rule__Grammar__UsedGrammarsAssignment_2_1 : ( ( ruleGrammarID ) ) ;
    public final void rule__Grammar__UsedGrammarsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9536:1: ( ( ( ruleGrammarID ) ) )
            // InternalXtext.g:9537:1: ( ( ruleGrammarID ) )
            {
            // InternalXtext.g:9537:1: ( ( ruleGrammarID ) )
            // InternalXtext.g:9538:1: ( ruleGrammarID )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_1_0()); 
            // InternalXtext.g:9539:1: ( ruleGrammarID )
            // InternalXtext.g:9540:1: ruleGrammarID
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarGrammarIDParserRuleCall_2_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:9551:1: rule__Grammar__UsedGrammarsAssignment_2_2_1 : ( ( ruleGrammarID ) ) ;
    public final void rule__Grammar__UsedGrammarsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9555:1: ( ( ( ruleGrammarID ) ) )
            // InternalXtext.g:9556:1: ( ( ruleGrammarID ) )
            {
            // InternalXtext.g:9556:1: ( ( ruleGrammarID ) )
            // InternalXtext.g:9557:1: ( ruleGrammarID )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_2_1_0()); 
            // InternalXtext.g:9558:1: ( ruleGrammarID )
            // InternalXtext.g:9559:1: ruleGrammarID
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarGrammarIDParserRuleCall_2_2_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:9570:1: rule__Grammar__DefinesHiddenTokensAssignment_3_0 : ( ( 'hidden' ) ) ;
    public final void rule__Grammar__DefinesHiddenTokensAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9574:1: ( ( ( 'hidden' ) ) )
            // InternalXtext.g:9575:1: ( ( 'hidden' ) )
            {
            // InternalXtext.g:9575:1: ( ( 'hidden' ) )
            // InternalXtext.g:9576:1: ( 'hidden' )
            {
             before(grammarAccess.getGrammarAccess().getDefinesHiddenTokensHiddenKeyword_3_0_0()); 
            // InternalXtext.g:9577:1: ( 'hidden' )
            // InternalXtext.g:9578:1: 'hidden'
            {
             before(grammarAccess.getGrammarAccess().getDefinesHiddenTokensHiddenKeyword_3_0_0()); 
            match(input,47,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:9593:1: rule__Grammar__HiddenTokensAssignment_3_2_0 : ( ( ruleRuleID ) ) ;
    public final void rule__Grammar__HiddenTokensAssignment_3_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9597:1: ( ( ( ruleRuleID ) ) )
            // InternalXtext.g:9598:1: ( ( ruleRuleID ) )
            {
            // InternalXtext.g:9598:1: ( ( ruleRuleID ) )
            // InternalXtext.g:9599:1: ( ruleRuleID )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_0_0()); 
            // InternalXtext.g:9600:1: ( ruleRuleID )
            // InternalXtext.g:9601:1: ruleRuleID
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleRuleIDParserRuleCall_3_2_0_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleRuleID();

            state._fsp--;

             after(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleRuleIDParserRuleCall_3_2_0_0_1()); 

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
    // InternalXtext.g:9612:1: rule__Grammar__HiddenTokensAssignment_3_2_1_1 : ( ( ruleRuleID ) ) ;
    public final void rule__Grammar__HiddenTokensAssignment_3_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9616:1: ( ( ( ruleRuleID ) ) )
            // InternalXtext.g:9617:1: ( ( ruleRuleID ) )
            {
            // InternalXtext.g:9617:1: ( ( ruleRuleID ) )
            // InternalXtext.g:9618:1: ( ruleRuleID )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_1_1_0()); 
            // InternalXtext.g:9619:1: ( ruleRuleID )
            // InternalXtext.g:9620:1: ruleRuleID
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleRuleIDParserRuleCall_3_2_1_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleRuleID();

            state._fsp--;

             after(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleRuleIDParserRuleCall_3_2_1_1_0_1()); 

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
    // InternalXtext.g:9631:1: rule__Grammar__MetamodelDeclarationsAssignment_4 : ( ruleAbstractMetamodelDeclaration ) ;
    public final void rule__Grammar__MetamodelDeclarationsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9635:1: ( ( ruleAbstractMetamodelDeclaration ) )
            // InternalXtext.g:9636:1: ( ruleAbstractMetamodelDeclaration )
            {
            // InternalXtext.g:9636:1: ( ruleAbstractMetamodelDeclaration )
            // InternalXtext.g:9637:1: ruleAbstractMetamodelDeclaration
            {
             before(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:9646:1: rule__Grammar__RulesAssignment_5 : ( ruleAbstractRule ) ;
    public final void rule__Grammar__RulesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9650:1: ( ( ruleAbstractRule ) )
            // InternalXtext.g:9651:1: ( ruleAbstractRule )
            {
            // InternalXtext.g:9651:1: ( ruleAbstractRule )
            // InternalXtext.g:9652:1: ruleAbstractRule
            {
             before(grammarAccess.getGrammarAccess().getRulesAbstractRuleParserRuleCall_5_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:9661:1: rule__GeneratedMetamodel__NameAssignment_1 : ( ruleValidID ) ;
    public final void rule__GeneratedMetamodel__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9665:1: ( ( ruleValidID ) )
            // InternalXtext.g:9666:1: ( ruleValidID )
            {
            // InternalXtext.g:9666:1: ( ruleValidID )
            // InternalXtext.g:9667:1: ruleValidID
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getNameValidIDParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getGeneratedMetamodelAccess().getNameValidIDParserRuleCall_1_0()); 

            }


            }

        }
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
    // InternalXtext.g:9676:1: rule__GeneratedMetamodel__EPackageAssignment_2 : ( ( RULE_STRING ) ) ;
    public final void rule__GeneratedMetamodel__EPackageAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9680:1: ( ( ( RULE_STRING ) ) )
            // InternalXtext.g:9681:1: ( ( RULE_STRING ) )
            {
            // InternalXtext.g:9681:1: ( ( RULE_STRING ) )
            // InternalXtext.g:9682:1: ( RULE_STRING )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageCrossReference_2_0()); 
            // InternalXtext.g:9683:1: ( RULE_STRING )
            // InternalXtext.g:9684:1: RULE_STRING
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_2_0_1()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:9695:1: rule__GeneratedMetamodel__AliasAssignment_3_1 : ( ruleValidID ) ;
    public final void rule__GeneratedMetamodel__AliasAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9699:1: ( ( ruleValidID ) )
            // InternalXtext.g:9700:1: ( ruleValidID )
            {
            // InternalXtext.g:9700:1: ( ruleValidID )
            // InternalXtext.g:9701:1: ruleValidID
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getAliasValidIDParserRuleCall_3_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getGeneratedMetamodelAccess().getAliasValidIDParserRuleCall_3_1_0()); 

            }


            }

        }
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
    // InternalXtext.g:9710:1: rule__ReferencedMetamodel__EPackageAssignment_1 : ( ( RULE_STRING ) ) ;
    public final void rule__ReferencedMetamodel__EPackageAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9714:1: ( ( ( RULE_STRING ) ) )
            // InternalXtext.g:9715:1: ( ( RULE_STRING ) )
            {
            // InternalXtext.g:9715:1: ( ( RULE_STRING ) )
            // InternalXtext.g:9716:1: ( RULE_STRING )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageCrossReference_1_0()); 
            // InternalXtext.g:9717:1: ( RULE_STRING )
            // InternalXtext.g:9718:1: RULE_STRING
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_1_0_1()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:9729:1: rule__ReferencedMetamodel__AliasAssignment_2_1 : ( ruleValidID ) ;
    public final void rule__ReferencedMetamodel__AliasAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9733:1: ( ( ruleValidID ) )
            // InternalXtext.g:9734:1: ( ruleValidID )
            {
            // InternalXtext.g:9734:1: ( ruleValidID )
            // InternalXtext.g:9735:1: ruleValidID
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAliasValidIDParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getReferencedMetamodelAccess().getAliasValidIDParserRuleCall_2_1_0()); 

            }


            }

        }
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


    // $ANTLR start "rule__ParserRule__FragmentAssignment_0_0_0"
    // InternalXtext.g:9744:1: rule__ParserRule__FragmentAssignment_0_0_0 : ( ( 'fragment' ) ) ;
    public final void rule__ParserRule__FragmentAssignment_0_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9748:1: ( ( ( 'fragment' ) ) )
            // InternalXtext.g:9749:1: ( ( 'fragment' ) )
            {
            // InternalXtext.g:9749:1: ( ( 'fragment' ) )
            // InternalXtext.g:9750:1: ( 'fragment' )
            {
             before(grammarAccess.getParserRuleAccess().getFragmentFragmentKeyword_0_0_0_0()); 
            // InternalXtext.g:9751:1: ( 'fragment' )
            // InternalXtext.g:9752:1: 'fragment'
            {
             before(grammarAccess.getParserRuleAccess().getFragmentFragmentKeyword_0_0_0_0()); 
            match(input,48,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParserRuleAccess().getFragmentFragmentKeyword_0_0_0_0()); 

            }

             after(grammarAccess.getParserRuleAccess().getFragmentFragmentKeyword_0_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__FragmentAssignment_0_0_0"


    // $ANTLR start "rule__ParserRule__WildcardAssignment_0_0_2_0"
    // InternalXtext.g:9767:1: rule__ParserRule__WildcardAssignment_0_0_2_0 : ( ( '*' ) ) ;
    public final void rule__ParserRule__WildcardAssignment_0_0_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9771:1: ( ( ( '*' ) ) )
            // InternalXtext.g:9772:1: ( ( '*' ) )
            {
            // InternalXtext.g:9772:1: ( ( '*' ) )
            // InternalXtext.g:9773:1: ( '*' )
            {
             before(grammarAccess.getParserRuleAccess().getWildcardAsteriskKeyword_0_0_2_0_0()); 
            // InternalXtext.g:9774:1: ( '*' )
            // InternalXtext.g:9775:1: '*'
            {
             before(grammarAccess.getParserRuleAccess().getWildcardAsteriskKeyword_0_0_2_0_0()); 
            match(input,12,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParserRuleAccess().getWildcardAsteriskKeyword_0_0_2_0_0()); 

            }

             after(grammarAccess.getParserRuleAccess().getWildcardAsteriskKeyword_0_0_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__WildcardAssignment_0_0_2_0"


    // $ANTLR start "rule__ParserRule__TypeAssignment_0_0_2_1_1"
    // InternalXtext.g:9790:1: rule__ParserRule__TypeAssignment_0_0_2_1_1 : ( ruleTypeRef ) ;
    public final void rule__ParserRule__TypeAssignment_0_0_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9794:1: ( ( ruleTypeRef ) )
            // InternalXtext.g:9795:1: ( ruleTypeRef )
            {
            // InternalXtext.g:9795:1: ( ruleTypeRef )
            // InternalXtext.g:9796:1: ruleTypeRef
            {
             before(grammarAccess.getParserRuleAccess().getTypeTypeRefParserRuleCall_0_0_2_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTypeRef();

            state._fsp--;

             after(grammarAccess.getParserRuleAccess().getTypeTypeRefParserRuleCall_0_0_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__TypeAssignment_0_0_2_1_1"


    // $ANTLR start "rule__ParserRule__TypeAssignment_0_1_1_1"
    // InternalXtext.g:9805:1: rule__ParserRule__TypeAssignment_0_1_1_1 : ( ruleTypeRef ) ;
    public final void rule__ParserRule__TypeAssignment_0_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9809:1: ( ( ruleTypeRef ) )
            // InternalXtext.g:9810:1: ( ruleTypeRef )
            {
            // InternalXtext.g:9810:1: ( ruleTypeRef )
            // InternalXtext.g:9811:1: ruleTypeRef
            {
             before(grammarAccess.getParserRuleAccess().getTypeTypeRefParserRuleCall_0_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTypeRef();

            state._fsp--;

             after(grammarAccess.getParserRuleAccess().getTypeTypeRefParserRuleCall_0_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__TypeAssignment_0_1_1_1"


    // $ANTLR start "rule__ParserRule__DefinesHiddenTokensAssignment_1_0"
    // InternalXtext.g:9820:1: rule__ParserRule__DefinesHiddenTokensAssignment_1_0 : ( ( 'hidden' ) ) ;
    public final void rule__ParserRule__DefinesHiddenTokensAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9824:1: ( ( ( 'hidden' ) ) )
            // InternalXtext.g:9825:1: ( ( 'hidden' ) )
            {
            // InternalXtext.g:9825:1: ( ( 'hidden' ) )
            // InternalXtext.g:9826:1: ( 'hidden' )
            {
             before(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_1_0_0()); 
            // InternalXtext.g:9827:1: ( 'hidden' )
            // InternalXtext.g:9828:1: 'hidden'
            {
             before(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_1_0_0()); 
            match(input,47,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_1_0_0()); 

            }

             after(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__DefinesHiddenTokensAssignment_1_0"


    // $ANTLR start "rule__ParserRule__HiddenTokensAssignment_1_2_0"
    // InternalXtext.g:9843:1: rule__ParserRule__HiddenTokensAssignment_1_2_0 : ( ( ruleRuleID ) ) ;
    public final void rule__ParserRule__HiddenTokensAssignment_1_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9847:1: ( ( ( ruleRuleID ) ) )
            // InternalXtext.g:9848:1: ( ( ruleRuleID ) )
            {
            // InternalXtext.g:9848:1: ( ( ruleRuleID ) )
            // InternalXtext.g:9849:1: ( ruleRuleID )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_1_2_0_0()); 
            // InternalXtext.g:9850:1: ( ruleRuleID )
            // InternalXtext.g:9851:1: ruleRuleID
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleRuleIDParserRuleCall_1_2_0_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleRuleID();

            state._fsp--;

             after(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleRuleIDParserRuleCall_1_2_0_0_1()); 

            }

             after(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_1_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__HiddenTokensAssignment_1_2_0"


    // $ANTLR start "rule__ParserRule__HiddenTokensAssignment_1_2_1_1"
    // InternalXtext.g:9862:1: rule__ParserRule__HiddenTokensAssignment_1_2_1_1 : ( ( ruleRuleID ) ) ;
    public final void rule__ParserRule__HiddenTokensAssignment_1_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9866:1: ( ( ( ruleRuleID ) ) )
            // InternalXtext.g:9867:1: ( ( ruleRuleID ) )
            {
            // InternalXtext.g:9867:1: ( ( ruleRuleID ) )
            // InternalXtext.g:9868:1: ( ruleRuleID )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_1_2_1_1_0()); 
            // InternalXtext.g:9869:1: ( ruleRuleID )
            // InternalXtext.g:9870:1: ruleRuleID
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleRuleIDParserRuleCall_1_2_1_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleRuleID();

            state._fsp--;

             after(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleRuleIDParserRuleCall_1_2_1_1_0_1()); 

            }

             after(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_1_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__HiddenTokensAssignment_1_2_1_1"


    // $ANTLR start "rule__ParserRule__AlternativesAssignment_3"
    // InternalXtext.g:9881:1: rule__ParserRule__AlternativesAssignment_3 : ( ruleAlternatives ) ;
    public final void rule__ParserRule__AlternativesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9885:1: ( ( ruleAlternatives ) )
            // InternalXtext.g:9886:1: ( ruleAlternatives )
            {
            // InternalXtext.g:9886:1: ( ruleAlternatives )
            // InternalXtext.g:9887:1: ruleAlternatives
            {
             before(grammarAccess.getParserRuleAccess().getAlternativesAlternativesParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAlternatives();

            state._fsp--;

             after(grammarAccess.getParserRuleAccess().getAlternativesAlternativesParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__AlternativesAssignment_3"


    // $ANTLR start "rule__RuleNameAndParams__NameAssignment_0"
    // InternalXtext.g:9896:1: rule__RuleNameAndParams__NameAssignment_0 : ( ruleValidID ) ;
    public final void rule__RuleNameAndParams__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9900:1: ( ( ruleValidID ) )
            // InternalXtext.g:9901:1: ( ruleValidID )
            {
            // InternalXtext.g:9901:1: ( ruleValidID )
            // InternalXtext.g:9902:1: ruleValidID
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getNameValidIDParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getRuleNameAndParamsAccess().getNameValidIDParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__NameAssignment_0"


    // $ANTLR start "rule__RuleNameAndParams__ParametersAssignment_1_1_0"
    // InternalXtext.g:9911:1: rule__RuleNameAndParams__ParametersAssignment_1_1_0 : ( ruleParameter ) ;
    public final void rule__RuleNameAndParams__ParametersAssignment_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9915:1: ( ( ruleParameter ) )
            // InternalXtext.g:9916:1: ( ruleParameter )
            {
            // InternalXtext.g:9916:1: ( ruleParameter )
            // InternalXtext.g:9917:1: ruleParameter
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getParametersParameterParserRuleCall_1_1_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getRuleNameAndParamsAccess().getParametersParameterParserRuleCall_1_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__ParametersAssignment_1_1_0"


    // $ANTLR start "rule__RuleNameAndParams__ParametersAssignment_1_1_1_1"
    // InternalXtext.g:9926:1: rule__RuleNameAndParams__ParametersAssignment_1_1_1_1 : ( ruleParameter ) ;
    public final void rule__RuleNameAndParams__ParametersAssignment_1_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9930:1: ( ( ruleParameter ) )
            // InternalXtext.g:9931:1: ( ruleParameter )
            {
            // InternalXtext.g:9931:1: ( ruleParameter )
            // InternalXtext.g:9932:1: ruleParameter
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getParametersParameterParserRuleCall_1_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getRuleNameAndParamsAccess().getParametersParameterParserRuleCall_1_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__ParametersAssignment_1_1_1_1"


    // $ANTLR start "rule__Parameter__NameAssignment"
    // InternalXtext.g:9941:1: rule__Parameter__NameAssignment : ( RULE_ID ) ;
    public final void rule__Parameter__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9945:1: ( ( RULE_ID ) )
            // InternalXtext.g:9946:1: ( RULE_ID )
            {
            // InternalXtext.g:9946:1: ( RULE_ID )
            // InternalXtext.g:9947:1: RULE_ID
            {
             before(grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__NameAssignment"


    // $ANTLR start "rule__TypeRef__MetamodelAssignment_0_0"
    // InternalXtext.g:9956:1: rule__TypeRef__MetamodelAssignment_0_0 : ( ( RULE_ID ) ) ;
    public final void rule__TypeRef__MetamodelAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9960:1: ( ( ( RULE_ID ) ) )
            // InternalXtext.g:9961:1: ( ( RULE_ID ) )
            {
            // InternalXtext.g:9961:1: ( ( RULE_ID ) )
            // InternalXtext.g:9962:1: ( RULE_ID )
            {
             before(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationCrossReference_0_0_0()); 
            // InternalXtext.g:9963:1: ( RULE_ID )
            // InternalXtext.g:9964:1: RULE_ID
            {
             before(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationIDTerminalRuleCall_0_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:9975:1: rule__TypeRef__ClassifierAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__TypeRef__ClassifierAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9979:1: ( ( ( RULE_ID ) ) )
            // InternalXtext.g:9980:1: ( ( RULE_ID ) )
            {
            // InternalXtext.g:9980:1: ( ( RULE_ID ) )
            // InternalXtext.g:9981:1: ( RULE_ID )
            {
             before(grammarAccess.getTypeRefAccess().getClassifierEClassifierCrossReference_1_0()); 
            // InternalXtext.g:9982:1: ( RULE_ID )
            // InternalXtext.g:9983:1: RULE_ID
            {
             before(grammarAccess.getTypeRefAccess().getClassifierEClassifierIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:9994:1: rule__Alternatives__ElementsAssignment_1_1_1 : ( ruleConditionalBranch ) ;
    public final void rule__Alternatives__ElementsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:9998:1: ( ( ruleConditionalBranch ) )
            // InternalXtext.g:9999:1: ( ruleConditionalBranch )
            {
            // InternalXtext.g:9999:1: ( ruleConditionalBranch )
            // InternalXtext.g:10000:1: ruleConditionalBranch
            {
             before(grammarAccess.getAlternativesAccess().getElementsConditionalBranchParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleConditionalBranch();

            state._fsp--;

             after(grammarAccess.getAlternativesAccess().getElementsConditionalBranchParserRuleCall_1_1_1_0()); 

            }


            }

        }
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


    // $ANTLR start "rule__ConditionalBranch__GuardConditionAssignment_1_2"
    // InternalXtext.g:10009:1: rule__ConditionalBranch__GuardConditionAssignment_1_2 : ( ruleDisjunction ) ;
    public final void rule__ConditionalBranch__GuardConditionAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10013:1: ( ( ruleDisjunction ) )
            // InternalXtext.g:10014:1: ( ruleDisjunction )
            {
            // InternalXtext.g:10014:1: ( ruleDisjunction )
            // InternalXtext.g:10015:1: ruleDisjunction
            {
             before(grammarAccess.getConditionalBranchAccess().getGuardConditionDisjunctionParserRuleCall_1_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleDisjunction();

            state._fsp--;

             after(grammarAccess.getConditionalBranchAccess().getGuardConditionDisjunctionParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalBranch__GuardConditionAssignment_1_2"


    // $ANTLR start "rule__ConditionalBranch__ElementsAssignment_1_4"
    // InternalXtext.g:10024:1: rule__ConditionalBranch__ElementsAssignment_1_4 : ( ruleAbstractToken ) ;
    public final void rule__ConditionalBranch__ElementsAssignment_1_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10028:1: ( ( ruleAbstractToken ) )
            // InternalXtext.g:10029:1: ( ruleAbstractToken )
            {
            // InternalXtext.g:10029:1: ( ruleAbstractToken )
            // InternalXtext.g:10030:1: ruleAbstractToken
            {
             before(grammarAccess.getConditionalBranchAccess().getElementsAbstractTokenParserRuleCall_1_4_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAbstractToken();

            state._fsp--;

             after(grammarAccess.getConditionalBranchAccess().getElementsAbstractTokenParserRuleCall_1_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalBranch__ElementsAssignment_1_4"


    // $ANTLR start "rule__UnorderedGroup__ElementsAssignment_1_1_1"
    // InternalXtext.g:10039:1: rule__UnorderedGroup__ElementsAssignment_1_1_1 : ( ruleGroup ) ;
    public final void rule__UnorderedGroup__ElementsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10043:1: ( ( ruleGroup ) )
            // InternalXtext.g:10044:1: ( ruleGroup )
            {
            // InternalXtext.g:10044:1: ( ruleGroup )
            // InternalXtext.g:10045:1: ruleGroup
            {
             before(grammarAccess.getUnorderedGroupAccess().getElementsGroupParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:10054:1: rule__Group__ElementsAssignment_1_1 : ( ruleAbstractToken ) ;
    public final void rule__Group__ElementsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10058:1: ( ( ruleAbstractToken ) )
            // InternalXtext.g:10059:1: ( ruleAbstractToken )
            {
            // InternalXtext.g:10059:1: ( ruleAbstractToken )
            // InternalXtext.g:10060:1: ruleAbstractToken
            {
             before(grammarAccess.getGroupAccess().getElementsAbstractTokenParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:10069:1: rule__AbstractTokenWithCardinality__CardinalityAssignment_1 : ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) ) ;
    public final void rule__AbstractTokenWithCardinality__CardinalityAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10073:1: ( ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) ) )
            // InternalXtext.g:10074:1: ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) )
            {
            // InternalXtext.g:10074:1: ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) )
            // InternalXtext.g:10075:1: ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 )
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAlternatives_1_0()); 
            // InternalXtext.g:10076:1: ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 )
            // InternalXtext.g:10076:2: rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:10085:1: rule__Action__TypeAssignment_1 : ( ruleTypeRef ) ;
    public final void rule__Action__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10089:1: ( ( ruleTypeRef ) )
            // InternalXtext.g:10090:1: ( ruleTypeRef )
            {
            // InternalXtext.g:10090:1: ( ruleTypeRef )
            // InternalXtext.g:10091:1: ruleTypeRef
            {
             before(grammarAccess.getActionAccess().getTypeTypeRefParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:10100:1: rule__Action__FeatureAssignment_2_1 : ( ruleValidID ) ;
    public final void rule__Action__FeatureAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10104:1: ( ( ruleValidID ) )
            // InternalXtext.g:10105:1: ( ruleValidID )
            {
            // InternalXtext.g:10105:1: ( ruleValidID )
            // InternalXtext.g:10106:1: ruleValidID
            {
             before(grammarAccess.getActionAccess().getFeatureValidIDParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getActionAccess().getFeatureValidIDParserRuleCall_2_1_0()); 

            }


            }

        }
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
    // InternalXtext.g:10115:1: rule__Action__OperatorAssignment_2_2 : ( ( rule__Action__OperatorAlternatives_2_2_0 ) ) ;
    public final void rule__Action__OperatorAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10119:1: ( ( ( rule__Action__OperatorAlternatives_2_2_0 ) ) )
            // InternalXtext.g:10120:1: ( ( rule__Action__OperatorAlternatives_2_2_0 ) )
            {
            // InternalXtext.g:10120:1: ( ( rule__Action__OperatorAlternatives_2_2_0 ) )
            // InternalXtext.g:10121:1: ( rule__Action__OperatorAlternatives_2_2_0 )
            {
             before(grammarAccess.getActionAccess().getOperatorAlternatives_2_2_0()); 
            // InternalXtext.g:10122:1: ( rule__Action__OperatorAlternatives_2_2_0 )
            // InternalXtext.g:10122:2: rule__Action__OperatorAlternatives_2_2_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:10131:1: rule__Keyword__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__Keyword__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10135:1: ( ( RULE_STRING ) )
            // InternalXtext.g:10136:1: ( RULE_STRING )
            {
            // InternalXtext.g:10136:1: ( RULE_STRING )
            // InternalXtext.g:10137:1: RULE_STRING
            {
             before(grammarAccess.getKeywordAccess().getValueSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
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


    // $ANTLR start "rule__RuleCall__RuleAssignment_0"
    // InternalXtext.g:10146:1: rule__RuleCall__RuleAssignment_0 : ( ( ruleRuleID ) ) ;
    public final void rule__RuleCall__RuleAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10150:1: ( ( ( ruleRuleID ) ) )
            // InternalXtext.g:10151:1: ( ( ruleRuleID ) )
            {
            // InternalXtext.g:10151:1: ( ( ruleRuleID ) )
            // InternalXtext.g:10152:1: ( ruleRuleID )
            {
             before(grammarAccess.getRuleCallAccess().getRuleAbstractRuleCrossReference_0_0()); 
            // InternalXtext.g:10153:1: ( ruleRuleID )
            // InternalXtext.g:10154:1: ruleRuleID
            {
             before(grammarAccess.getRuleCallAccess().getRuleAbstractRuleRuleIDParserRuleCall_0_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleRuleID();

            state._fsp--;

             after(grammarAccess.getRuleCallAccess().getRuleAbstractRuleRuleIDParserRuleCall_0_0_1()); 

            }

             after(grammarAccess.getRuleCallAccess().getRuleAbstractRuleCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__RuleAssignment_0"


    // $ANTLR start "rule__RuleCall__ArgumentsAssignment_1_1"
    // InternalXtext.g:10165:1: rule__RuleCall__ArgumentsAssignment_1_1 : ( ruleNamedArgument ) ;
    public final void rule__RuleCall__ArgumentsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10169:1: ( ( ruleNamedArgument ) )
            // InternalXtext.g:10170:1: ( ruleNamedArgument )
            {
            // InternalXtext.g:10170:1: ( ruleNamedArgument )
            // InternalXtext.g:10171:1: ruleNamedArgument
            {
             before(grammarAccess.getRuleCallAccess().getArgumentsNamedArgumentParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleNamedArgument();

            state._fsp--;

             after(grammarAccess.getRuleCallAccess().getArgumentsNamedArgumentParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__ArgumentsAssignment_1_1"


    // $ANTLR start "rule__RuleCall__ArgumentsAssignment_1_2_1"
    // InternalXtext.g:10180:1: rule__RuleCall__ArgumentsAssignment_1_2_1 : ( ruleNamedArgument ) ;
    public final void rule__RuleCall__ArgumentsAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10184:1: ( ( ruleNamedArgument ) )
            // InternalXtext.g:10185:1: ( ruleNamedArgument )
            {
            // InternalXtext.g:10185:1: ( ruleNamedArgument )
            // InternalXtext.g:10186:1: ruleNamedArgument
            {
             before(grammarAccess.getRuleCallAccess().getArgumentsNamedArgumentParserRuleCall_1_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleNamedArgument();

            state._fsp--;

             after(grammarAccess.getRuleCallAccess().getArgumentsNamedArgumentParserRuleCall_1_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__ArgumentsAssignment_1_2_1"


    // $ANTLR start "rule__NamedArgument__ParameterAssignment_0_0"
    // InternalXtext.g:10195:1: rule__NamedArgument__ParameterAssignment_0_0 : ( ( RULE_ID ) ) ;
    public final void rule__NamedArgument__ParameterAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10199:1: ( ( ( RULE_ID ) ) )
            // InternalXtext.g:10200:1: ( ( RULE_ID ) )
            {
            // InternalXtext.g:10200:1: ( ( RULE_ID ) )
            // InternalXtext.g:10201:1: ( RULE_ID )
            {
             before(grammarAccess.getNamedArgumentAccess().getParameterParameterCrossReference_0_0_0()); 
            // InternalXtext.g:10202:1: ( RULE_ID )
            // InternalXtext.g:10203:1: RULE_ID
            {
             before(grammarAccess.getNamedArgumentAccess().getParameterParameterIDTerminalRuleCall_0_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getNamedArgumentAccess().getParameterParameterIDTerminalRuleCall_0_0_0_1()); 

            }

             after(grammarAccess.getNamedArgumentAccess().getParameterParameterCrossReference_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__ParameterAssignment_0_0"


    // $ANTLR start "rule__NamedArgument__CalledByNameAssignment_0_1"
    // InternalXtext.g:10214:1: rule__NamedArgument__CalledByNameAssignment_0_1 : ( ( '=' ) ) ;
    public final void rule__NamedArgument__CalledByNameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10218:1: ( ( ( '=' ) ) )
            // InternalXtext.g:10219:1: ( ( '=' ) )
            {
            // InternalXtext.g:10219:1: ( ( '=' ) )
            // InternalXtext.g:10220:1: ( '=' )
            {
             before(grammarAccess.getNamedArgumentAccess().getCalledByNameEqualsSignKeyword_0_1_0()); 
            // InternalXtext.g:10221:1: ( '=' )
            // InternalXtext.g:10222:1: '='
            {
             before(grammarAccess.getNamedArgumentAccess().getCalledByNameEqualsSignKeyword_0_1_0()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getNamedArgumentAccess().getCalledByNameEqualsSignKeyword_0_1_0()); 

            }

             after(grammarAccess.getNamedArgumentAccess().getCalledByNameEqualsSignKeyword_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__CalledByNameAssignment_0_1"


    // $ANTLR start "rule__NamedArgument__ValueAssignment_1"
    // InternalXtext.g:10237:1: rule__NamedArgument__ValueAssignment_1 : ( ruleDisjunction ) ;
    public final void rule__NamedArgument__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10241:1: ( ( ruleDisjunction ) )
            // InternalXtext.g:10242:1: ( ruleDisjunction )
            {
            // InternalXtext.g:10242:1: ( ruleDisjunction )
            // InternalXtext.g:10243:1: ruleDisjunction
            {
             before(grammarAccess.getNamedArgumentAccess().getValueDisjunctionParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleDisjunction();

            state._fsp--;

             after(grammarAccess.getNamedArgumentAccess().getValueDisjunctionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__ValueAssignment_1"


    // $ANTLR start "rule__LiteralCondition__TrueAssignment_1_0"
    // InternalXtext.g:10252:1: rule__LiteralCondition__TrueAssignment_1_0 : ( ( 'true' ) ) ;
    public final void rule__LiteralCondition__TrueAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10256:1: ( ( ( 'true' ) ) )
            // InternalXtext.g:10257:1: ( ( 'true' ) )
            {
            // InternalXtext.g:10257:1: ( ( 'true' ) )
            // InternalXtext.g:10258:1: ( 'true' )
            {
             before(grammarAccess.getLiteralConditionAccess().getTrueTrueKeyword_1_0_0()); 
            // InternalXtext.g:10259:1: ( 'true' )
            // InternalXtext.g:10260:1: 'true'
            {
             before(grammarAccess.getLiteralConditionAccess().getTrueTrueKeyword_1_0_0()); 
            match(input,17,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getLiteralConditionAccess().getTrueTrueKeyword_1_0_0()); 

            }

             after(grammarAccess.getLiteralConditionAccess().getTrueTrueKeyword_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralCondition__TrueAssignment_1_0"


    // $ANTLR start "rule__Disjunction__RightAssignment_1_2"
    // InternalXtext.g:10275:1: rule__Disjunction__RightAssignment_1_2 : ( ruleConjunction ) ;
    public final void rule__Disjunction__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10279:1: ( ( ruleConjunction ) )
            // InternalXtext.g:10280:1: ( ruleConjunction )
            {
            // InternalXtext.g:10280:1: ( ruleConjunction )
            // InternalXtext.g:10281:1: ruleConjunction
            {
             before(grammarAccess.getDisjunctionAccess().getRightConjunctionParserRuleCall_1_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleConjunction();

            state._fsp--;

             after(grammarAccess.getDisjunctionAccess().getRightConjunctionParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__RightAssignment_1_2"


    // $ANTLR start "rule__Conjunction__RightAssignment_1_2"
    // InternalXtext.g:10290:1: rule__Conjunction__RightAssignment_1_2 : ( ruleNegation ) ;
    public final void rule__Conjunction__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10294:1: ( ( ruleNegation ) )
            // InternalXtext.g:10295:1: ( ruleNegation )
            {
            // InternalXtext.g:10295:1: ( ruleNegation )
            // InternalXtext.g:10296:1: ruleNegation
            {
             before(grammarAccess.getConjunctionAccess().getRightNegationParserRuleCall_1_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleNegation();

            state._fsp--;

             after(grammarAccess.getConjunctionAccess().getRightNegationParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__RightAssignment_1_2"


    // $ANTLR start "rule__Negation__ValueAssignment_1_2"
    // InternalXtext.g:10305:1: rule__Negation__ValueAssignment_1_2 : ( ruleNegation ) ;
    public final void rule__Negation__ValueAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10309:1: ( ( ruleNegation ) )
            // InternalXtext.g:10310:1: ( ruleNegation )
            {
            // InternalXtext.g:10310:1: ( ruleNegation )
            // InternalXtext.g:10311:1: ruleNegation
            {
             before(grammarAccess.getNegationAccess().getValueNegationParserRuleCall_1_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleNegation();

            state._fsp--;

             after(grammarAccess.getNegationAccess().getValueNegationParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negation__ValueAssignment_1_2"


    // $ANTLR start "rule__ParameterReference__ParameterAssignment"
    // InternalXtext.g:10320:1: rule__ParameterReference__ParameterAssignment : ( ( RULE_ID ) ) ;
    public final void rule__ParameterReference__ParameterAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10324:1: ( ( ( RULE_ID ) ) )
            // InternalXtext.g:10325:1: ( ( RULE_ID ) )
            {
            // InternalXtext.g:10325:1: ( ( RULE_ID ) )
            // InternalXtext.g:10326:1: ( RULE_ID )
            {
             before(grammarAccess.getParameterReferenceAccess().getParameterParameterCrossReference_0()); 
            // InternalXtext.g:10327:1: ( RULE_ID )
            // InternalXtext.g:10328:1: RULE_ID
            {
             before(grammarAccess.getParameterReferenceAccess().getParameterParameterIDTerminalRuleCall_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParameterReferenceAccess().getParameterParameterIDTerminalRuleCall_0_1()); 

            }

             after(grammarAccess.getParameterReferenceAccess().getParameterParameterCrossReference_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterReference__ParameterAssignment"


    // $ANTLR start "rule__TerminalRuleCall__RuleAssignment"
    // InternalXtext.g:10339:1: rule__TerminalRuleCall__RuleAssignment : ( ( ruleRuleID ) ) ;
    public final void rule__TerminalRuleCall__RuleAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10343:1: ( ( ( ruleRuleID ) ) )
            // InternalXtext.g:10344:1: ( ( ruleRuleID ) )
            {
            // InternalXtext.g:10344:1: ( ( ruleRuleID ) )
            // InternalXtext.g:10345:1: ( ruleRuleID )
            {
             before(grammarAccess.getTerminalRuleCallAccess().getRuleAbstractRuleCrossReference_0()); 
            // InternalXtext.g:10346:1: ( ruleRuleID )
            // InternalXtext.g:10347:1: ruleRuleID
            {
             before(grammarAccess.getTerminalRuleCallAccess().getRuleAbstractRuleRuleIDParserRuleCall_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleRuleID();

            state._fsp--;

             after(grammarAccess.getTerminalRuleCallAccess().getRuleAbstractRuleRuleIDParserRuleCall_0_1()); 

            }

             after(grammarAccess.getTerminalRuleCallAccess().getRuleAbstractRuleCrossReference_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRuleCall__RuleAssignment"


    // $ANTLR start "rule__PredicatedKeyword__PredicatedAssignment_0_0"
    // InternalXtext.g:10358:1: rule__PredicatedKeyword__PredicatedAssignment_0_0 : ( ( '=>' ) ) ;
    public final void rule__PredicatedKeyword__PredicatedAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10362:1: ( ( ( '=>' ) ) )
            // InternalXtext.g:10363:1: ( ( '=>' ) )
            {
            // InternalXtext.g:10363:1: ( ( '=>' ) )
            // InternalXtext.g:10364:1: ( '=>' )
            {
             before(grammarAccess.getPredicatedKeywordAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 
            // InternalXtext.g:10365:1: ( '=>' )
            // InternalXtext.g:10366:1: '=>'
            {
             before(grammarAccess.getPredicatedKeywordAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 
            match(input,49,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getPredicatedKeywordAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 

            }

             after(grammarAccess.getPredicatedKeywordAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedKeyword__PredicatedAssignment_0_0"


    // $ANTLR start "rule__PredicatedKeyword__FirstSetPredicatedAssignment_0_1"
    // InternalXtext.g:10381:1: rule__PredicatedKeyword__FirstSetPredicatedAssignment_0_1 : ( ( '->' ) ) ;
    public final void rule__PredicatedKeyword__FirstSetPredicatedAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10385:1: ( ( ( '->' ) ) )
            // InternalXtext.g:10386:1: ( ( '->' ) )
            {
            // InternalXtext.g:10386:1: ( ( '->' ) )
            // InternalXtext.g:10387:1: ( '->' )
            {
             before(grammarAccess.getPredicatedKeywordAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 
            // InternalXtext.g:10388:1: ( '->' )
            // InternalXtext.g:10389:1: '->'
            {
             before(grammarAccess.getPredicatedKeywordAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 
            match(input,43,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getPredicatedKeywordAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 

            }

             after(grammarAccess.getPredicatedKeywordAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedKeyword__FirstSetPredicatedAssignment_0_1"


    // $ANTLR start "rule__PredicatedKeyword__ValueAssignment_1"
    // InternalXtext.g:10404:1: rule__PredicatedKeyword__ValueAssignment_1 : ( RULE_STRING ) ;
    public final void rule__PredicatedKeyword__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10408:1: ( ( RULE_STRING ) )
            // InternalXtext.g:10409:1: ( RULE_STRING )
            {
            // InternalXtext.g:10409:1: ( RULE_STRING )
            // InternalXtext.g:10410:1: RULE_STRING
            {
             before(grammarAccess.getPredicatedKeywordAccess().getValueSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getPredicatedKeywordAccess().getValueSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedKeyword__ValueAssignment_1"


    // $ANTLR start "rule__PredicatedRuleCall__PredicatedAssignment_0_0"
    // InternalXtext.g:10419:1: rule__PredicatedRuleCall__PredicatedAssignment_0_0 : ( ( '=>' ) ) ;
    public final void rule__PredicatedRuleCall__PredicatedAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10423:1: ( ( ( '=>' ) ) )
            // InternalXtext.g:10424:1: ( ( '=>' ) )
            {
            // InternalXtext.g:10424:1: ( ( '=>' ) )
            // InternalXtext.g:10425:1: ( '=>' )
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 
            // InternalXtext.g:10426:1: ( '=>' )
            // InternalXtext.g:10427:1: '=>'
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 
            match(input,49,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getPredicatedRuleCallAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 

            }

             after(grammarAccess.getPredicatedRuleCallAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__PredicatedAssignment_0_0"


    // $ANTLR start "rule__PredicatedRuleCall__FirstSetPredicatedAssignment_0_1"
    // InternalXtext.g:10442:1: rule__PredicatedRuleCall__FirstSetPredicatedAssignment_0_1 : ( ( '->' ) ) ;
    public final void rule__PredicatedRuleCall__FirstSetPredicatedAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10446:1: ( ( ( '->' ) ) )
            // InternalXtext.g:10447:1: ( ( '->' ) )
            {
            // InternalXtext.g:10447:1: ( ( '->' ) )
            // InternalXtext.g:10448:1: ( '->' )
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 
            // InternalXtext.g:10449:1: ( '->' )
            // InternalXtext.g:10450:1: '->'
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 
            match(input,43,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getPredicatedRuleCallAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 

            }

             after(grammarAccess.getPredicatedRuleCallAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__FirstSetPredicatedAssignment_0_1"


    // $ANTLR start "rule__PredicatedRuleCall__RuleAssignment_1"
    // InternalXtext.g:10465:1: rule__PredicatedRuleCall__RuleAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__PredicatedRuleCall__RuleAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10469:1: ( ( ( RULE_ID ) ) )
            // InternalXtext.g:10470:1: ( ( RULE_ID ) )
            {
            // InternalXtext.g:10470:1: ( ( RULE_ID ) )
            // InternalXtext.g:10471:1: ( RULE_ID )
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getRuleAbstractRuleCrossReference_1_0()); 
            // InternalXtext.g:10472:1: ( RULE_ID )
            // InternalXtext.g:10473:1: RULE_ID
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getRuleAbstractRuleIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getPredicatedRuleCallAccess().getRuleAbstractRuleIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getPredicatedRuleCallAccess().getRuleAbstractRuleCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__RuleAssignment_1"


    // $ANTLR start "rule__PredicatedRuleCall__ArgumentsAssignment_2_1"
    // InternalXtext.g:10484:1: rule__PredicatedRuleCall__ArgumentsAssignment_2_1 : ( ruleNamedArgument ) ;
    public final void rule__PredicatedRuleCall__ArgumentsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10488:1: ( ( ruleNamedArgument ) )
            // InternalXtext.g:10489:1: ( ruleNamedArgument )
            {
            // InternalXtext.g:10489:1: ( ruleNamedArgument )
            // InternalXtext.g:10490:1: ruleNamedArgument
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getArgumentsNamedArgumentParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleNamedArgument();

            state._fsp--;

             after(grammarAccess.getPredicatedRuleCallAccess().getArgumentsNamedArgumentParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__ArgumentsAssignment_2_1"


    // $ANTLR start "rule__PredicatedRuleCall__ArgumentsAssignment_2_2_1"
    // InternalXtext.g:10499:1: rule__PredicatedRuleCall__ArgumentsAssignment_2_2_1 : ( ruleNamedArgument ) ;
    public final void rule__PredicatedRuleCall__ArgumentsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10503:1: ( ( ruleNamedArgument ) )
            // InternalXtext.g:10504:1: ( ruleNamedArgument )
            {
            // InternalXtext.g:10504:1: ( ruleNamedArgument )
            // InternalXtext.g:10505:1: ruleNamedArgument
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getArgumentsNamedArgumentParserRuleCall_2_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleNamedArgument();

            state._fsp--;

             after(grammarAccess.getPredicatedRuleCallAccess().getArgumentsNamedArgumentParserRuleCall_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__ArgumentsAssignment_2_2_1"


    // $ANTLR start "rule__Assignment__PredicatedAssignment_0_0"
    // InternalXtext.g:10514:1: rule__Assignment__PredicatedAssignment_0_0 : ( ( '=>' ) ) ;
    public final void rule__Assignment__PredicatedAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10518:1: ( ( ( '=>' ) ) )
            // InternalXtext.g:10519:1: ( ( '=>' ) )
            {
            // InternalXtext.g:10519:1: ( ( '=>' ) )
            // InternalXtext.g:10520:1: ( '=>' )
            {
             before(grammarAccess.getAssignmentAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 
            // InternalXtext.g:10521:1: ( '=>' )
            // InternalXtext.g:10522:1: '=>'
            {
             before(grammarAccess.getAssignmentAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 
            match(input,49,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAssignmentAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 

            }

             after(grammarAccess.getAssignmentAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__PredicatedAssignment_0_0"


    // $ANTLR start "rule__Assignment__FirstSetPredicatedAssignment_0_1"
    // InternalXtext.g:10537:1: rule__Assignment__FirstSetPredicatedAssignment_0_1 : ( ( '->' ) ) ;
    public final void rule__Assignment__FirstSetPredicatedAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10541:1: ( ( ( '->' ) ) )
            // InternalXtext.g:10542:1: ( ( '->' ) )
            {
            // InternalXtext.g:10542:1: ( ( '->' ) )
            // InternalXtext.g:10543:1: ( '->' )
            {
             before(grammarAccess.getAssignmentAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 
            // InternalXtext.g:10544:1: ( '->' )
            // InternalXtext.g:10545:1: '->'
            {
             before(grammarAccess.getAssignmentAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 
            match(input,43,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAssignmentAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 

            }

             after(grammarAccess.getAssignmentAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__FirstSetPredicatedAssignment_0_1"


    // $ANTLR start "rule__Assignment__FeatureAssignment_1"
    // InternalXtext.g:10560:1: rule__Assignment__FeatureAssignment_1 : ( ruleValidID ) ;
    public final void rule__Assignment__FeatureAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10564:1: ( ( ruleValidID ) )
            // InternalXtext.g:10565:1: ( ruleValidID )
            {
            // InternalXtext.g:10565:1: ( ruleValidID )
            // InternalXtext.g:10566:1: ruleValidID
            {
             before(grammarAccess.getAssignmentAccess().getFeatureValidIDParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getAssignmentAccess().getFeatureValidIDParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__FeatureAssignment_1"


    // $ANTLR start "rule__Assignment__OperatorAssignment_2"
    // InternalXtext.g:10575:1: rule__Assignment__OperatorAssignment_2 : ( ( rule__Assignment__OperatorAlternatives_2_0 ) ) ;
    public final void rule__Assignment__OperatorAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10579:1: ( ( ( rule__Assignment__OperatorAlternatives_2_0 ) ) )
            // InternalXtext.g:10580:1: ( ( rule__Assignment__OperatorAlternatives_2_0 ) )
            {
            // InternalXtext.g:10580:1: ( ( rule__Assignment__OperatorAlternatives_2_0 ) )
            // InternalXtext.g:10581:1: ( rule__Assignment__OperatorAlternatives_2_0 )
            {
             before(grammarAccess.getAssignmentAccess().getOperatorAlternatives_2_0()); 
            // InternalXtext.g:10582:1: ( rule__Assignment__OperatorAlternatives_2_0 )
            // InternalXtext.g:10582:2: rule__Assignment__OperatorAlternatives_2_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Assignment__OperatorAlternatives_2_0();

            state._fsp--;


            }

             after(grammarAccess.getAssignmentAccess().getOperatorAlternatives_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__OperatorAssignment_2"


    // $ANTLR start "rule__Assignment__TerminalAssignment_3"
    // InternalXtext.g:10591:1: rule__Assignment__TerminalAssignment_3 : ( ruleAssignableTerminal ) ;
    public final void rule__Assignment__TerminalAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10595:1: ( ( ruleAssignableTerminal ) )
            // InternalXtext.g:10596:1: ( ruleAssignableTerminal )
            {
            // InternalXtext.g:10596:1: ( ruleAssignableTerminal )
            // InternalXtext.g:10597:1: ruleAssignableTerminal
            {
             before(grammarAccess.getAssignmentAccess().getTerminalAssignableTerminalParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAssignableTerminal();

            state._fsp--;

             after(grammarAccess.getAssignmentAccess().getTerminalAssignableTerminalParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__TerminalAssignment_3"


    // $ANTLR start "rule__AssignableAlternatives__ElementsAssignment_1_1_1"
    // InternalXtext.g:10606:1: rule__AssignableAlternatives__ElementsAssignment_1_1_1 : ( ruleAssignableTerminal ) ;
    public final void rule__AssignableAlternatives__ElementsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10610:1: ( ( ruleAssignableTerminal ) )
            // InternalXtext.g:10611:1: ( ruleAssignableTerminal )
            {
            // InternalXtext.g:10611:1: ( ruleAssignableTerminal )
            // InternalXtext.g:10612:1: ruleAssignableTerminal
            {
             before(grammarAccess.getAssignableAlternativesAccess().getElementsAssignableTerminalParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:10621:1: rule__CrossReference__TypeAssignment_1 : ( ruleTypeRef ) ;
    public final void rule__CrossReference__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10625:1: ( ( ruleTypeRef ) )
            // InternalXtext.g:10626:1: ( ruleTypeRef )
            {
            // InternalXtext.g:10626:1: ( ruleTypeRef )
            // InternalXtext.g:10627:1: ruleTypeRef
            {
             before(grammarAccess.getCrossReferenceAccess().getTypeTypeRefParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:10636:1: rule__CrossReference__TerminalAssignment_2_1 : ( ruleCrossReferenceableTerminal ) ;
    public final void rule__CrossReference__TerminalAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10640:1: ( ( ruleCrossReferenceableTerminal ) )
            // InternalXtext.g:10641:1: ( ruleCrossReferenceableTerminal )
            {
            // InternalXtext.g:10641:1: ( ruleCrossReferenceableTerminal )
            // InternalXtext.g:10642:1: ruleCrossReferenceableTerminal
            {
             before(grammarAccess.getCrossReferenceAccess().getTerminalCrossReferenceableTerminalParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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


    // $ANTLR start "rule__PredicatedGroup__PredicatedAssignment_0_0"
    // InternalXtext.g:10651:1: rule__PredicatedGroup__PredicatedAssignment_0_0 : ( ( '=>' ) ) ;
    public final void rule__PredicatedGroup__PredicatedAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10655:1: ( ( ( '=>' ) ) )
            // InternalXtext.g:10656:1: ( ( '=>' ) )
            {
            // InternalXtext.g:10656:1: ( ( '=>' ) )
            // InternalXtext.g:10657:1: ( '=>' )
            {
             before(grammarAccess.getPredicatedGroupAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 
            // InternalXtext.g:10658:1: ( '=>' )
            // InternalXtext.g:10659:1: '=>'
            {
             before(grammarAccess.getPredicatedGroupAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 
            match(input,49,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getPredicatedGroupAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 

            }

             after(grammarAccess.getPredicatedGroupAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedGroup__PredicatedAssignment_0_0"


    // $ANTLR start "rule__PredicatedGroup__FirstSetPredicatedAssignment_0_1"
    // InternalXtext.g:10674:1: rule__PredicatedGroup__FirstSetPredicatedAssignment_0_1 : ( ( '->' ) ) ;
    public final void rule__PredicatedGroup__FirstSetPredicatedAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10678:1: ( ( ( '->' ) ) )
            // InternalXtext.g:10679:1: ( ( '->' ) )
            {
            // InternalXtext.g:10679:1: ( ( '->' ) )
            // InternalXtext.g:10680:1: ( '->' )
            {
             before(grammarAccess.getPredicatedGroupAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 
            // InternalXtext.g:10681:1: ( '->' )
            // InternalXtext.g:10682:1: '->'
            {
             before(grammarAccess.getPredicatedGroupAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 
            match(input,43,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getPredicatedGroupAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 

            }

             after(grammarAccess.getPredicatedGroupAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedGroup__FirstSetPredicatedAssignment_0_1"


    // $ANTLR start "rule__PredicatedGroup__ElementsAssignment_2"
    // InternalXtext.g:10697:1: rule__PredicatedGroup__ElementsAssignment_2 : ( ruleAlternatives ) ;
    public final void rule__PredicatedGroup__ElementsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10701:1: ( ( ruleAlternatives ) )
            // InternalXtext.g:10702:1: ( ruleAlternatives )
            {
            // InternalXtext.g:10702:1: ( ruleAlternatives )
            // InternalXtext.g:10703:1: ruleAlternatives
            {
             before(grammarAccess.getPredicatedGroupAccess().getElementsAlternativesParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAlternatives();

            state._fsp--;

             after(grammarAccess.getPredicatedGroupAccess().getElementsAlternativesParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedGroup__ElementsAssignment_2"


    // $ANTLR start "rule__TerminalRule__FragmentAssignment_1_0_0"
    // InternalXtext.g:10712:1: rule__TerminalRule__FragmentAssignment_1_0_0 : ( ( 'fragment' ) ) ;
    public final void rule__TerminalRule__FragmentAssignment_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10716:1: ( ( ( 'fragment' ) ) )
            // InternalXtext.g:10717:1: ( ( 'fragment' ) )
            {
            // InternalXtext.g:10717:1: ( ( 'fragment' ) )
            // InternalXtext.g:10718:1: ( 'fragment' )
            {
             before(grammarAccess.getTerminalRuleAccess().getFragmentFragmentKeyword_1_0_0_0()); 
            // InternalXtext.g:10719:1: ( 'fragment' )
            // InternalXtext.g:10720:1: 'fragment'
            {
             before(grammarAccess.getTerminalRuleAccess().getFragmentFragmentKeyword_1_0_0_0()); 
            match(input,48,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:10735:1: rule__TerminalRule__NameAssignment_1_0_1 : ( ruleValidID ) ;
    public final void rule__TerminalRule__NameAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10739:1: ( ( ruleValidID ) )
            // InternalXtext.g:10740:1: ( ruleValidID )
            {
            // InternalXtext.g:10740:1: ( ruleValidID )
            // InternalXtext.g:10741:1: ruleValidID
            {
             before(grammarAccess.getTerminalRuleAccess().getNameValidIDParserRuleCall_1_0_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getTerminalRuleAccess().getNameValidIDParserRuleCall_1_0_1_0()); 

            }


            }

        }
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
    // InternalXtext.g:10750:1: rule__TerminalRule__NameAssignment_1_1_0 : ( ruleValidID ) ;
    public final void rule__TerminalRule__NameAssignment_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10754:1: ( ( ruleValidID ) )
            // InternalXtext.g:10755:1: ( ruleValidID )
            {
            // InternalXtext.g:10755:1: ( ruleValidID )
            // InternalXtext.g:10756:1: ruleValidID
            {
             before(grammarAccess.getTerminalRuleAccess().getNameValidIDParserRuleCall_1_1_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getTerminalRuleAccess().getNameValidIDParserRuleCall_1_1_0_0()); 

            }


            }

        }
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
    // InternalXtext.g:10765:1: rule__TerminalRule__TypeAssignment_1_1_1_1 : ( ruleTypeRef ) ;
    public final void rule__TerminalRule__TypeAssignment_1_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10769:1: ( ( ruleTypeRef ) )
            // InternalXtext.g:10770:1: ( ruleTypeRef )
            {
            // InternalXtext.g:10770:1: ( ruleTypeRef )
            // InternalXtext.g:10771:1: ruleTypeRef
            {
             before(grammarAccess.getTerminalRuleAccess().getTypeTypeRefParserRuleCall_1_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:10780:1: rule__TerminalRule__AlternativesAssignment_3 : ( ruleTerminalAlternatives ) ;
    public final void rule__TerminalRule__AlternativesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10784:1: ( ( ruleTerminalAlternatives ) )
            // InternalXtext.g:10785:1: ( ruleTerminalAlternatives )
            {
            // InternalXtext.g:10785:1: ( ruleTerminalAlternatives )
            // InternalXtext.g:10786:1: ruleTerminalAlternatives
            {
             before(grammarAccess.getTerminalRuleAccess().getAlternativesTerminalAlternativesParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:10795:1: rule__TerminalAlternatives__ElementsAssignment_1_1_1 : ( ruleTerminalGroup ) ;
    public final void rule__TerminalAlternatives__ElementsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10799:1: ( ( ruleTerminalGroup ) )
            // InternalXtext.g:10800:1: ( ruleTerminalGroup )
            {
            // InternalXtext.g:10800:1: ( ruleTerminalGroup )
            // InternalXtext.g:10801:1: ruleTerminalGroup
            {
             before(grammarAccess.getTerminalAlternativesAccess().getElementsTerminalGroupParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:10810:1: rule__TerminalGroup__ElementsAssignment_1_1 : ( ruleTerminalToken ) ;
    public final void rule__TerminalGroup__ElementsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10814:1: ( ( ruleTerminalToken ) )
            // InternalXtext.g:10815:1: ( ruleTerminalToken )
            {
            // InternalXtext.g:10815:1: ( ruleTerminalToken )
            // InternalXtext.g:10816:1: ruleTerminalToken
            {
             before(grammarAccess.getTerminalGroupAccess().getElementsTerminalTokenParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:10825:1: rule__TerminalToken__CardinalityAssignment_1 : ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) ) ;
    public final void rule__TerminalToken__CardinalityAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10829:1: ( ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) ) )
            // InternalXtext.g:10830:1: ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) )
            {
            // InternalXtext.g:10830:1: ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) )
            // InternalXtext.g:10831:1: ( rule__TerminalToken__CardinalityAlternatives_1_0 )
            {
             before(grammarAccess.getTerminalTokenAccess().getCardinalityAlternatives_1_0()); 
            // InternalXtext.g:10832:1: ( rule__TerminalToken__CardinalityAlternatives_1_0 )
            // InternalXtext.g:10832:2: rule__TerminalToken__CardinalityAlternatives_1_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:10841:1: rule__NegatedToken__TerminalAssignment_1 : ( ruleTerminalTokenElement ) ;
    public final void rule__NegatedToken__TerminalAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10845:1: ( ( ruleTerminalTokenElement ) )
            // InternalXtext.g:10846:1: ( ruleTerminalTokenElement )
            {
            // InternalXtext.g:10846:1: ( ruleTerminalTokenElement )
            // InternalXtext.g:10847:1: ruleTerminalTokenElement
            {
             before(grammarAccess.getNegatedTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:10856:1: rule__UntilToken__TerminalAssignment_1 : ( ruleTerminalTokenElement ) ;
    public final void rule__UntilToken__TerminalAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10860:1: ( ( ruleTerminalTokenElement ) )
            // InternalXtext.g:10861:1: ( ruleTerminalTokenElement )
            {
            // InternalXtext.g:10861:1: ( ruleTerminalTokenElement )
            // InternalXtext.g:10862:1: ruleTerminalTokenElement
            {
             before(grammarAccess.getUntilTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:10871:1: rule__CharacterRange__RightAssignment_1_2 : ( ruleKeyword ) ;
    public final void rule__CharacterRange__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10875:1: ( ( ruleKeyword ) )
            // InternalXtext.g:10876:1: ( ruleKeyword )
            {
            // InternalXtext.g:10876:1: ( ruleKeyword )
            // InternalXtext.g:10877:1: ruleKeyword
            {
             before(grammarAccess.getCharacterRangeAccess().getRightKeywordParserRuleCall_1_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:10886:1: rule__EnumRule__NameAssignment_1 : ( ruleValidID ) ;
    public final void rule__EnumRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10890:1: ( ( ruleValidID ) )
            // InternalXtext.g:10891:1: ( ruleValidID )
            {
            // InternalXtext.g:10891:1: ( ruleValidID )
            // InternalXtext.g:10892:1: ruleValidID
            {
             before(grammarAccess.getEnumRuleAccess().getNameValidIDParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getEnumRuleAccess().getNameValidIDParserRuleCall_1_0()); 

            }


            }

        }
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
    // InternalXtext.g:10901:1: rule__EnumRule__TypeAssignment_2_1 : ( ruleTypeRef ) ;
    public final void rule__EnumRule__TypeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10905:1: ( ( ruleTypeRef ) )
            // InternalXtext.g:10906:1: ( ruleTypeRef )
            {
            // InternalXtext.g:10906:1: ( ruleTypeRef )
            // InternalXtext.g:10907:1: ruleTypeRef
            {
             before(grammarAccess.getEnumRuleAccess().getTypeTypeRefParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:10916:1: rule__EnumRule__AlternativesAssignment_4 : ( ruleEnumLiterals ) ;
    public final void rule__EnumRule__AlternativesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10920:1: ( ( ruleEnumLiterals ) )
            // InternalXtext.g:10921:1: ( ruleEnumLiterals )
            {
            // InternalXtext.g:10921:1: ( ruleEnumLiterals )
            // InternalXtext.g:10922:1: ruleEnumLiterals
            {
             before(grammarAccess.getEnumRuleAccess().getAlternativesEnumLiteralsParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:10931:1: rule__EnumLiterals__ElementsAssignment_1_1_1 : ( ruleEnumLiteralDeclaration ) ;
    public final void rule__EnumLiterals__ElementsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10935:1: ( ( ruleEnumLiteralDeclaration ) )
            // InternalXtext.g:10936:1: ( ruleEnumLiteralDeclaration )
            {
            // InternalXtext.g:10936:1: ( ruleEnumLiteralDeclaration )
            // InternalXtext.g:10937:1: ruleEnumLiteralDeclaration
            {
             before(grammarAccess.getEnumLiteralsAccess().getElementsEnumLiteralDeclarationParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:10946:1: rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__EnumLiteralDeclaration__EnumLiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10950:1: ( ( ( RULE_ID ) ) )
            // InternalXtext.g:10951:1: ( ( RULE_ID ) )
            {
            // InternalXtext.g:10951:1: ( ( RULE_ID ) )
            // InternalXtext.g:10952:1: ( RULE_ID )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralCrossReference_0_0()); 
            // InternalXtext.g:10953:1: ( RULE_ID )
            // InternalXtext.g:10954:1: RULE_ID
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:10965:1: rule__EnumLiteralDeclaration__LiteralAssignment_1_1 : ( ruleKeyword ) ;
    public final void rule__EnumLiteralDeclaration__LiteralAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtext.g:10969:1: ( ( ruleKeyword ) )
            // InternalXtext.g:10970:1: ( ruleKeyword )
            {
            // InternalXtext.g:10970:1: ( ruleKeyword )
            // InternalXtext.g:10971:1: ruleKeyword
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralKeywordParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000030010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0001C4000A130010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000000000A000002L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0001C4000A130012L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000830010L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000800010000000L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0002081080430030L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0001000000030010L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000040001000L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000100000010L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000008000430010L});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0002081000430030L});
        public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0002081000430032L});
        public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000800000002L});
        public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000003800L});
        public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000002001000000L});
        public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000004000000000L});
        public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000100200000L});
        public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000430010L});
        public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0002080000030010L});
        public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x000000000004C000L});
        public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000010000430030L});
        public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000020400000000L});
        public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000030030L});
        public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000188001430030L});
        public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000188001430032L});
        public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000050000000L});
    }


}
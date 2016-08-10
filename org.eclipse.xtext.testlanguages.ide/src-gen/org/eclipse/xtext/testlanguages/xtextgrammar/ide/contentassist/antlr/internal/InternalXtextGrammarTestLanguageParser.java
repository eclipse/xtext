package org.eclipse.xtext.testlanguages.xtextgrammar.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.eclipse.xtext.testlanguages.xtextgrammar.services.XtextGrammarTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalXtextGrammarTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'?'", "'*'", "'+'", "'='", "'+='", "'?='", "'grammar'", "'with'", "','", "'('", "')'", "'.'", "'generate'", "'as'", "'import'", "':'", "';'", "'returns'", "'::'", "'|'", "'{'", "'}'", "'current'", "'['", "']'", "'terminal'", "'!'", "'->'", "'..'", "'enum'", "'hidden'"
    };
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__17=17;
    public static final int T__39=39;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__35=35;
    public static final int T__14=14;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalXtextGrammarTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalXtextGrammarTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalXtextGrammarTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalXtextGrammarTestLanguage.g"; }


    	private XtextGrammarTestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(XtextGrammarTestLanguageGrammarAccess grammarAccess) {
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
    // InternalXtextGrammarTestLanguage.g:53:1: entryRuleGrammar : ruleGrammar EOF ;
    public final void entryRuleGrammar() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:54:1: ( ruleGrammar EOF )
            // InternalXtextGrammarTestLanguage.g:55:1: ruleGrammar EOF
            {
             before(grammarAccess.getGrammarRule()); 
            pushFollow(FOLLOW_1);
            ruleGrammar();

            state._fsp--;

             after(grammarAccess.getGrammarRule()); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalXtextGrammarTestLanguage.g:62:1: ruleGrammar : ( ( rule__Grammar__Group__0 ) ) ;
    public final void ruleGrammar() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:66:2: ( ( ( rule__Grammar__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:67:2: ( ( rule__Grammar__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:67:2: ( ( rule__Grammar__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:68:3: ( rule__Grammar__Group__0 )
            {
             before(grammarAccess.getGrammarAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:69:3: ( rule__Grammar__Group__0 )
            // InternalXtextGrammarTestLanguage.g:69:4: rule__Grammar__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:78:1: entryRuleGrammarID : ruleGrammarID EOF ;
    public final void entryRuleGrammarID() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:79:1: ( ruleGrammarID EOF )
            // InternalXtextGrammarTestLanguage.g:80:1: ruleGrammarID EOF
            {
             before(grammarAccess.getGrammarIDRule()); 
            pushFollow(FOLLOW_1);
            ruleGrammarID();

            state._fsp--;

             after(grammarAccess.getGrammarIDRule()); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalXtextGrammarTestLanguage.g:87:1: ruleGrammarID : ( ( rule__GrammarID__Group__0 ) ) ;
    public final void ruleGrammarID() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:91:2: ( ( ( rule__GrammarID__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:92:2: ( ( rule__GrammarID__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:92:2: ( ( rule__GrammarID__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:93:3: ( rule__GrammarID__Group__0 )
            {
             before(grammarAccess.getGrammarIDAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:94:3: ( rule__GrammarID__Group__0 )
            // InternalXtextGrammarTestLanguage.g:94:4: rule__GrammarID__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:103:1: entryRuleAbstractRule : ruleAbstractRule EOF ;
    public final void entryRuleAbstractRule() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:104:1: ( ruleAbstractRule EOF )
            // InternalXtextGrammarTestLanguage.g:105:1: ruleAbstractRule EOF
            {
             before(grammarAccess.getAbstractRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleAbstractRule();

            state._fsp--;

             after(grammarAccess.getAbstractRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalXtextGrammarTestLanguage.g:112:1: ruleAbstractRule : ( ( rule__AbstractRule__Alternatives ) ) ;
    public final void ruleAbstractRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:116:2: ( ( ( rule__AbstractRule__Alternatives ) ) )
            // InternalXtextGrammarTestLanguage.g:117:2: ( ( rule__AbstractRule__Alternatives ) )
            {
            // InternalXtextGrammarTestLanguage.g:117:2: ( ( rule__AbstractRule__Alternatives ) )
            // InternalXtextGrammarTestLanguage.g:118:3: ( rule__AbstractRule__Alternatives )
            {
             before(grammarAccess.getAbstractRuleAccess().getAlternatives()); 
            // InternalXtextGrammarTestLanguage.g:119:3: ( rule__AbstractRule__Alternatives )
            // InternalXtextGrammarTestLanguage.g:119:4: rule__AbstractRule__Alternatives
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:128:1: entryRuleAbstractMetamodelDeclaration : ruleAbstractMetamodelDeclaration EOF ;
    public final void entryRuleAbstractMetamodelDeclaration() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:129:1: ( ruleAbstractMetamodelDeclaration EOF )
            // InternalXtextGrammarTestLanguage.g:130:1: ruleAbstractMetamodelDeclaration EOF
            {
             before(grammarAccess.getAbstractMetamodelDeclarationRule()); 
            pushFollow(FOLLOW_1);
            ruleAbstractMetamodelDeclaration();

            state._fsp--;

             after(grammarAccess.getAbstractMetamodelDeclarationRule()); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalXtextGrammarTestLanguage.g:137:1: ruleAbstractMetamodelDeclaration : ( ( rule__AbstractMetamodelDeclaration__Alternatives ) ) ;
    public final void ruleAbstractMetamodelDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:141:2: ( ( ( rule__AbstractMetamodelDeclaration__Alternatives ) ) )
            // InternalXtextGrammarTestLanguage.g:142:2: ( ( rule__AbstractMetamodelDeclaration__Alternatives ) )
            {
            // InternalXtextGrammarTestLanguage.g:142:2: ( ( rule__AbstractMetamodelDeclaration__Alternatives ) )
            // InternalXtextGrammarTestLanguage.g:143:3: ( rule__AbstractMetamodelDeclaration__Alternatives )
            {
             before(grammarAccess.getAbstractMetamodelDeclarationAccess().getAlternatives()); 
            // InternalXtextGrammarTestLanguage.g:144:3: ( rule__AbstractMetamodelDeclaration__Alternatives )
            // InternalXtextGrammarTestLanguage.g:144:4: rule__AbstractMetamodelDeclaration__Alternatives
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:153:1: entryRuleGeneratedMetamodel : ruleGeneratedMetamodel EOF ;
    public final void entryRuleGeneratedMetamodel() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:154:1: ( ruleGeneratedMetamodel EOF )
            // InternalXtextGrammarTestLanguage.g:155:1: ruleGeneratedMetamodel EOF
            {
             before(grammarAccess.getGeneratedMetamodelRule()); 
            pushFollow(FOLLOW_1);
            ruleGeneratedMetamodel();

            state._fsp--;

             after(grammarAccess.getGeneratedMetamodelRule()); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalXtextGrammarTestLanguage.g:162:1: ruleGeneratedMetamodel : ( ( rule__GeneratedMetamodel__Group__0 ) ) ;
    public final void ruleGeneratedMetamodel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:166:2: ( ( ( rule__GeneratedMetamodel__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:167:2: ( ( rule__GeneratedMetamodel__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:167:2: ( ( rule__GeneratedMetamodel__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:168:3: ( rule__GeneratedMetamodel__Group__0 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:169:3: ( rule__GeneratedMetamodel__Group__0 )
            // InternalXtextGrammarTestLanguage.g:169:4: rule__GeneratedMetamodel__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:178:1: entryRuleReferencedMetamodel : ruleReferencedMetamodel EOF ;
    public final void entryRuleReferencedMetamodel() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:179:1: ( ruleReferencedMetamodel EOF )
            // InternalXtextGrammarTestLanguage.g:180:1: ruleReferencedMetamodel EOF
            {
             before(grammarAccess.getReferencedMetamodelRule()); 
            pushFollow(FOLLOW_1);
            ruleReferencedMetamodel();

            state._fsp--;

             after(grammarAccess.getReferencedMetamodelRule()); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalXtextGrammarTestLanguage.g:187:1: ruleReferencedMetamodel : ( ( rule__ReferencedMetamodel__Group__0 ) ) ;
    public final void ruleReferencedMetamodel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:191:2: ( ( ( rule__ReferencedMetamodel__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:192:2: ( ( rule__ReferencedMetamodel__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:192:2: ( ( rule__ReferencedMetamodel__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:193:3: ( rule__ReferencedMetamodel__Group__0 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:194:3: ( rule__ReferencedMetamodel__Group__0 )
            // InternalXtextGrammarTestLanguage.g:194:4: rule__ReferencedMetamodel__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:203:1: entryRuleParserRule : ruleParserRule EOF ;
    public final void entryRuleParserRule() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:204:1: ( ruleParserRule EOF )
            // InternalXtextGrammarTestLanguage.g:205:1: ruleParserRule EOF
            {
             before(grammarAccess.getParserRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleParserRule();

            state._fsp--;

             after(grammarAccess.getParserRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalXtextGrammarTestLanguage.g:212:1: ruleParserRule : ( ( rule__ParserRule__Group__0 ) ) ;
    public final void ruleParserRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:216:2: ( ( ( rule__ParserRule__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:217:2: ( ( rule__ParserRule__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:217:2: ( ( rule__ParserRule__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:218:3: ( rule__ParserRule__Group__0 )
            {
             before(grammarAccess.getParserRuleAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:219:3: ( rule__ParserRule__Group__0 )
            // InternalXtextGrammarTestLanguage.g:219:4: rule__ParserRule__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:228:1: entryRuleTypeRef : ruleTypeRef EOF ;
    public final void entryRuleTypeRef() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:229:1: ( ruleTypeRef EOF )
            // InternalXtextGrammarTestLanguage.g:230:1: ruleTypeRef EOF
            {
             before(grammarAccess.getTypeRefRule()); 
            pushFollow(FOLLOW_1);
            ruleTypeRef();

            state._fsp--;

             after(grammarAccess.getTypeRefRule()); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalXtextGrammarTestLanguage.g:237:1: ruleTypeRef : ( ( rule__TypeRef__Group__0 ) ) ;
    public final void ruleTypeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:241:2: ( ( ( rule__TypeRef__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:242:2: ( ( rule__TypeRef__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:242:2: ( ( rule__TypeRef__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:243:3: ( rule__TypeRef__Group__0 )
            {
             before(grammarAccess.getTypeRefAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:244:3: ( rule__TypeRef__Group__0 )
            // InternalXtextGrammarTestLanguage.g:244:4: rule__TypeRef__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:253:1: entryRuleAlternatives : ruleAlternatives EOF ;
    public final void entryRuleAlternatives() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:254:1: ( ruleAlternatives EOF )
            // InternalXtextGrammarTestLanguage.g:255:1: ruleAlternatives EOF
            {
             before(grammarAccess.getAlternativesRule()); 
            pushFollow(FOLLOW_1);
            ruleAlternatives();

            state._fsp--;

             after(grammarAccess.getAlternativesRule()); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalXtextGrammarTestLanguage.g:262:1: ruleAlternatives : ( ( rule__Alternatives__Group__0 ) ) ;
    public final void ruleAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:266:2: ( ( ( rule__Alternatives__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:267:2: ( ( rule__Alternatives__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:267:2: ( ( rule__Alternatives__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:268:3: ( rule__Alternatives__Group__0 )
            {
             before(grammarAccess.getAlternativesAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:269:3: ( rule__Alternatives__Group__0 )
            // InternalXtextGrammarTestLanguage.g:269:4: rule__Alternatives__Group__0
            {
            pushFollow(FOLLOW_2);
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


    // $ANTLR start "entryRuleGroup"
    // InternalXtextGrammarTestLanguage.g:278:1: entryRuleGroup : ruleGroup EOF ;
    public final void entryRuleGroup() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:279:1: ( ruleGroup EOF )
            // InternalXtextGrammarTestLanguage.g:280:1: ruleGroup EOF
            {
             before(grammarAccess.getGroupRule()); 
            pushFollow(FOLLOW_1);
            ruleGroup();

            state._fsp--;

             after(grammarAccess.getGroupRule()); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalXtextGrammarTestLanguage.g:287:1: ruleGroup : ( ( rule__Group__Group__0 ) ) ;
    public final void ruleGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:291:2: ( ( ( rule__Group__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:292:2: ( ( rule__Group__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:292:2: ( ( rule__Group__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:293:3: ( rule__Group__Group__0 )
            {
             before(grammarAccess.getGroupAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:294:3: ( rule__Group__Group__0 )
            // InternalXtextGrammarTestLanguage.g:294:4: rule__Group__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:303:1: entryRuleAbstractToken : ruleAbstractToken EOF ;
    public final void entryRuleAbstractToken() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:304:1: ( ruleAbstractToken EOF )
            // InternalXtextGrammarTestLanguage.g:305:1: ruleAbstractToken EOF
            {
             before(grammarAccess.getAbstractTokenRule()); 
            pushFollow(FOLLOW_1);
            ruleAbstractToken();

            state._fsp--;

             after(grammarAccess.getAbstractTokenRule()); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalXtextGrammarTestLanguage.g:312:1: ruleAbstractToken : ( ( rule__AbstractToken__Alternatives ) ) ;
    public final void ruleAbstractToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:316:2: ( ( ( rule__AbstractToken__Alternatives ) ) )
            // InternalXtextGrammarTestLanguage.g:317:2: ( ( rule__AbstractToken__Alternatives ) )
            {
            // InternalXtextGrammarTestLanguage.g:317:2: ( ( rule__AbstractToken__Alternatives ) )
            // InternalXtextGrammarTestLanguage.g:318:3: ( rule__AbstractToken__Alternatives )
            {
             before(grammarAccess.getAbstractTokenAccess().getAlternatives()); 
            // InternalXtextGrammarTestLanguage.g:319:3: ( rule__AbstractToken__Alternatives )
            // InternalXtextGrammarTestLanguage.g:319:4: rule__AbstractToken__Alternatives
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:328:1: entryRuleAbstractTokenWithCardinality : ruleAbstractTokenWithCardinality EOF ;
    public final void entryRuleAbstractTokenWithCardinality() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:329:1: ( ruleAbstractTokenWithCardinality EOF )
            // InternalXtextGrammarTestLanguage.g:330:1: ruleAbstractTokenWithCardinality EOF
            {
             before(grammarAccess.getAbstractTokenWithCardinalityRule()); 
            pushFollow(FOLLOW_1);
            ruleAbstractTokenWithCardinality();

            state._fsp--;

             after(grammarAccess.getAbstractTokenWithCardinalityRule()); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalXtextGrammarTestLanguage.g:337:1: ruleAbstractTokenWithCardinality : ( ( rule__AbstractTokenWithCardinality__Group__0 ) ) ;
    public final void ruleAbstractTokenWithCardinality() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:341:2: ( ( ( rule__AbstractTokenWithCardinality__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:342:2: ( ( rule__AbstractTokenWithCardinality__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:342:2: ( ( rule__AbstractTokenWithCardinality__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:343:3: ( rule__AbstractTokenWithCardinality__Group__0 )
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:344:3: ( rule__AbstractTokenWithCardinality__Group__0 )
            // InternalXtextGrammarTestLanguage.g:344:4: rule__AbstractTokenWithCardinality__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:353:1: entryRuleAction : ruleAction EOF ;
    public final void entryRuleAction() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:354:1: ( ruleAction EOF )
            // InternalXtextGrammarTestLanguage.g:355:1: ruleAction EOF
            {
             before(grammarAccess.getActionRule()); 
            pushFollow(FOLLOW_1);
            ruleAction();

            state._fsp--;

             after(grammarAccess.getActionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalXtextGrammarTestLanguage.g:362:1: ruleAction : ( ( rule__Action__Group__0 ) ) ;
    public final void ruleAction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:366:2: ( ( ( rule__Action__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:367:2: ( ( rule__Action__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:367:2: ( ( rule__Action__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:368:3: ( rule__Action__Group__0 )
            {
             before(grammarAccess.getActionAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:369:3: ( rule__Action__Group__0 )
            // InternalXtextGrammarTestLanguage.g:369:4: rule__Action__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:378:1: entryRuleAbstractTerminal : ruleAbstractTerminal EOF ;
    public final void entryRuleAbstractTerminal() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:379:1: ( ruleAbstractTerminal EOF )
            // InternalXtextGrammarTestLanguage.g:380:1: ruleAbstractTerminal EOF
            {
             before(grammarAccess.getAbstractTerminalRule()); 
            pushFollow(FOLLOW_1);
            ruleAbstractTerminal();

            state._fsp--;

             after(grammarAccess.getAbstractTerminalRule()); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalXtextGrammarTestLanguage.g:387:1: ruleAbstractTerminal : ( ( rule__AbstractTerminal__Alternatives ) ) ;
    public final void ruleAbstractTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:391:2: ( ( ( rule__AbstractTerminal__Alternatives ) ) )
            // InternalXtextGrammarTestLanguage.g:392:2: ( ( rule__AbstractTerminal__Alternatives ) )
            {
            // InternalXtextGrammarTestLanguage.g:392:2: ( ( rule__AbstractTerminal__Alternatives ) )
            // InternalXtextGrammarTestLanguage.g:393:3: ( rule__AbstractTerminal__Alternatives )
            {
             before(grammarAccess.getAbstractTerminalAccess().getAlternatives()); 
            // InternalXtextGrammarTestLanguage.g:394:3: ( rule__AbstractTerminal__Alternatives )
            // InternalXtextGrammarTestLanguage.g:394:4: rule__AbstractTerminal__Alternatives
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:403:1: entryRuleKeyword : ruleKeyword EOF ;
    public final void entryRuleKeyword() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:404:1: ( ruleKeyword EOF )
            // InternalXtextGrammarTestLanguage.g:405:1: ruleKeyword EOF
            {
             before(grammarAccess.getKeywordRule()); 
            pushFollow(FOLLOW_1);
            ruleKeyword();

            state._fsp--;

             after(grammarAccess.getKeywordRule()); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalXtextGrammarTestLanguage.g:412:1: ruleKeyword : ( ( rule__Keyword__ValueAssignment ) ) ;
    public final void ruleKeyword() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:416:2: ( ( ( rule__Keyword__ValueAssignment ) ) )
            // InternalXtextGrammarTestLanguage.g:417:2: ( ( rule__Keyword__ValueAssignment ) )
            {
            // InternalXtextGrammarTestLanguage.g:417:2: ( ( rule__Keyword__ValueAssignment ) )
            // InternalXtextGrammarTestLanguage.g:418:3: ( rule__Keyword__ValueAssignment )
            {
             before(grammarAccess.getKeywordAccess().getValueAssignment()); 
            // InternalXtextGrammarTestLanguage.g:419:3: ( rule__Keyword__ValueAssignment )
            // InternalXtextGrammarTestLanguage.g:419:4: rule__Keyword__ValueAssignment
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:428:1: entryRuleRuleCall : ruleRuleCall EOF ;
    public final void entryRuleRuleCall() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:429:1: ( ruleRuleCall EOF )
            // InternalXtextGrammarTestLanguage.g:430:1: ruleRuleCall EOF
            {
             before(grammarAccess.getRuleCallRule()); 
            pushFollow(FOLLOW_1);
            ruleRuleCall();

            state._fsp--;

             after(grammarAccess.getRuleCallRule()); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalXtextGrammarTestLanguage.g:437:1: ruleRuleCall : ( ( rule__RuleCall__RuleAssignment ) ) ;
    public final void ruleRuleCall() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:441:2: ( ( ( rule__RuleCall__RuleAssignment ) ) )
            // InternalXtextGrammarTestLanguage.g:442:2: ( ( rule__RuleCall__RuleAssignment ) )
            {
            // InternalXtextGrammarTestLanguage.g:442:2: ( ( rule__RuleCall__RuleAssignment ) )
            // InternalXtextGrammarTestLanguage.g:443:3: ( rule__RuleCall__RuleAssignment )
            {
             before(grammarAccess.getRuleCallAccess().getRuleAssignment()); 
            // InternalXtextGrammarTestLanguage.g:444:3: ( rule__RuleCall__RuleAssignment )
            // InternalXtextGrammarTestLanguage.g:444:4: rule__RuleCall__RuleAssignment
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:453:1: entryRuleAssignment : ruleAssignment EOF ;
    public final void entryRuleAssignment() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:454:1: ( ruleAssignment EOF )
            // InternalXtextGrammarTestLanguage.g:455:1: ruleAssignment EOF
            {
             before(grammarAccess.getAssignmentRule()); 
            pushFollow(FOLLOW_1);
            ruleAssignment();

            state._fsp--;

             after(grammarAccess.getAssignmentRule()); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalXtextGrammarTestLanguage.g:462:1: ruleAssignment : ( ( rule__Assignment__Group__0 ) ) ;
    public final void ruleAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:466:2: ( ( ( rule__Assignment__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:467:2: ( ( rule__Assignment__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:467:2: ( ( rule__Assignment__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:468:3: ( rule__Assignment__Group__0 )
            {
             before(grammarAccess.getAssignmentAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:469:3: ( rule__Assignment__Group__0 )
            // InternalXtextGrammarTestLanguage.g:469:4: rule__Assignment__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:478:1: entryRuleAssignableTerminal : ruleAssignableTerminal EOF ;
    public final void entryRuleAssignableTerminal() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:479:1: ( ruleAssignableTerminal EOF )
            // InternalXtextGrammarTestLanguage.g:480:1: ruleAssignableTerminal EOF
            {
             before(grammarAccess.getAssignableTerminalRule()); 
            pushFollow(FOLLOW_1);
            ruleAssignableTerminal();

            state._fsp--;

             after(grammarAccess.getAssignableTerminalRule()); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalXtextGrammarTestLanguage.g:487:1: ruleAssignableTerminal : ( ( rule__AssignableTerminal__Alternatives ) ) ;
    public final void ruleAssignableTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:491:2: ( ( ( rule__AssignableTerminal__Alternatives ) ) )
            // InternalXtextGrammarTestLanguage.g:492:2: ( ( rule__AssignableTerminal__Alternatives ) )
            {
            // InternalXtextGrammarTestLanguage.g:492:2: ( ( rule__AssignableTerminal__Alternatives ) )
            // InternalXtextGrammarTestLanguage.g:493:3: ( rule__AssignableTerminal__Alternatives )
            {
             before(grammarAccess.getAssignableTerminalAccess().getAlternatives()); 
            // InternalXtextGrammarTestLanguage.g:494:3: ( rule__AssignableTerminal__Alternatives )
            // InternalXtextGrammarTestLanguage.g:494:4: rule__AssignableTerminal__Alternatives
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:503:1: entryRuleParenthesizedAssignableElement : ruleParenthesizedAssignableElement EOF ;
    public final void entryRuleParenthesizedAssignableElement() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:504:1: ( ruleParenthesizedAssignableElement EOF )
            // InternalXtextGrammarTestLanguage.g:505:1: ruleParenthesizedAssignableElement EOF
            {
             before(grammarAccess.getParenthesizedAssignableElementRule()); 
            pushFollow(FOLLOW_1);
            ruleParenthesizedAssignableElement();

            state._fsp--;

             after(grammarAccess.getParenthesizedAssignableElementRule()); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalXtextGrammarTestLanguage.g:512:1: ruleParenthesizedAssignableElement : ( ( rule__ParenthesizedAssignableElement__Group__0 ) ) ;
    public final void ruleParenthesizedAssignableElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:516:2: ( ( ( rule__ParenthesizedAssignableElement__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:517:2: ( ( rule__ParenthesizedAssignableElement__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:517:2: ( ( rule__ParenthesizedAssignableElement__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:518:3: ( rule__ParenthesizedAssignableElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:519:3: ( rule__ParenthesizedAssignableElement__Group__0 )
            // InternalXtextGrammarTestLanguage.g:519:4: rule__ParenthesizedAssignableElement__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:528:1: entryRuleAssignableAlternatives : ruleAssignableAlternatives EOF ;
    public final void entryRuleAssignableAlternatives() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:529:1: ( ruleAssignableAlternatives EOF )
            // InternalXtextGrammarTestLanguage.g:530:1: ruleAssignableAlternatives EOF
            {
             before(grammarAccess.getAssignableAlternativesRule()); 
            pushFollow(FOLLOW_1);
            ruleAssignableAlternatives();

            state._fsp--;

             after(grammarAccess.getAssignableAlternativesRule()); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalXtextGrammarTestLanguage.g:537:1: ruleAssignableAlternatives : ( ( rule__AssignableAlternatives__Group__0 ) ) ;
    public final void ruleAssignableAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:541:2: ( ( ( rule__AssignableAlternatives__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:542:2: ( ( rule__AssignableAlternatives__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:542:2: ( ( rule__AssignableAlternatives__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:543:3: ( rule__AssignableAlternatives__Group__0 )
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:544:3: ( rule__AssignableAlternatives__Group__0 )
            // InternalXtextGrammarTestLanguage.g:544:4: rule__AssignableAlternatives__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:553:1: entryRuleCrossReference : ruleCrossReference EOF ;
    public final void entryRuleCrossReference() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:554:1: ( ruleCrossReference EOF )
            // InternalXtextGrammarTestLanguage.g:555:1: ruleCrossReference EOF
            {
             before(grammarAccess.getCrossReferenceRule()); 
            pushFollow(FOLLOW_1);
            ruleCrossReference();

            state._fsp--;

             after(grammarAccess.getCrossReferenceRule()); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalXtextGrammarTestLanguage.g:562:1: ruleCrossReference : ( ( rule__CrossReference__Group__0 ) ) ;
    public final void ruleCrossReference() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:566:2: ( ( ( rule__CrossReference__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:567:2: ( ( rule__CrossReference__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:567:2: ( ( rule__CrossReference__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:568:3: ( rule__CrossReference__Group__0 )
            {
             before(grammarAccess.getCrossReferenceAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:569:3: ( rule__CrossReference__Group__0 )
            // InternalXtextGrammarTestLanguage.g:569:4: rule__CrossReference__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:578:1: entryRuleCrossReferenceableTerminal : ruleCrossReferenceableTerminal EOF ;
    public final void entryRuleCrossReferenceableTerminal() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:579:1: ( ruleCrossReferenceableTerminal EOF )
            // InternalXtextGrammarTestLanguage.g:580:1: ruleCrossReferenceableTerminal EOF
            {
             before(grammarAccess.getCrossReferenceableTerminalRule()); 
            pushFollow(FOLLOW_1);
            ruleCrossReferenceableTerminal();

            state._fsp--;

             after(grammarAccess.getCrossReferenceableTerminalRule()); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalXtextGrammarTestLanguage.g:587:1: ruleCrossReferenceableTerminal : ( ( rule__CrossReferenceableTerminal__Alternatives ) ) ;
    public final void ruleCrossReferenceableTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:591:2: ( ( ( rule__CrossReferenceableTerminal__Alternatives ) ) )
            // InternalXtextGrammarTestLanguage.g:592:2: ( ( rule__CrossReferenceableTerminal__Alternatives ) )
            {
            // InternalXtextGrammarTestLanguage.g:592:2: ( ( rule__CrossReferenceableTerminal__Alternatives ) )
            // InternalXtextGrammarTestLanguage.g:593:3: ( rule__CrossReferenceableTerminal__Alternatives )
            {
             before(grammarAccess.getCrossReferenceableTerminalAccess().getAlternatives()); 
            // InternalXtextGrammarTestLanguage.g:594:3: ( rule__CrossReferenceableTerminal__Alternatives )
            // InternalXtextGrammarTestLanguage.g:594:4: rule__CrossReferenceableTerminal__Alternatives
            {
            pushFollow(FOLLOW_2);
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


    // $ANTLR start "entryRuleParenthesizedCrossReferenceableElement"
    // InternalXtextGrammarTestLanguage.g:603:1: entryRuleParenthesizedCrossReferenceableElement : ruleParenthesizedCrossReferenceableElement EOF ;
    public final void entryRuleParenthesizedCrossReferenceableElement() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:604:1: ( ruleParenthesizedCrossReferenceableElement EOF )
            // InternalXtextGrammarTestLanguage.g:605:1: ruleParenthesizedCrossReferenceableElement EOF
            {
             before(grammarAccess.getParenthesizedCrossReferenceableElementRule()); 
            pushFollow(FOLLOW_1);
            ruleParenthesizedCrossReferenceableElement();

            state._fsp--;

             after(grammarAccess.getParenthesizedCrossReferenceableElementRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParenthesizedCrossReferenceableElement"


    // $ANTLR start "ruleParenthesizedCrossReferenceableElement"
    // InternalXtextGrammarTestLanguage.g:612:1: ruleParenthesizedCrossReferenceableElement : ( ( rule__ParenthesizedCrossReferenceableElement__Group__0 ) ) ;
    public final void ruleParenthesizedCrossReferenceableElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:616:2: ( ( ( rule__ParenthesizedCrossReferenceableElement__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:617:2: ( ( rule__ParenthesizedCrossReferenceableElement__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:617:2: ( ( rule__ParenthesizedCrossReferenceableElement__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:618:3: ( rule__ParenthesizedCrossReferenceableElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedCrossReferenceableElementAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:619:3: ( rule__ParenthesizedCrossReferenceableElement__Group__0 )
            // InternalXtextGrammarTestLanguage.g:619:4: rule__ParenthesizedCrossReferenceableElement__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ParenthesizedCrossReferenceableElement__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleParenthesizedCrossReferenceableElement"


    // $ANTLR start "entryRuleCrossReferenceableAlternatives"
    // InternalXtextGrammarTestLanguage.g:628:1: entryRuleCrossReferenceableAlternatives : ruleCrossReferenceableAlternatives EOF ;
    public final void entryRuleCrossReferenceableAlternatives() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:629:1: ( ruleCrossReferenceableAlternatives EOF )
            // InternalXtextGrammarTestLanguage.g:630:1: ruleCrossReferenceableAlternatives EOF
            {
             before(grammarAccess.getCrossReferenceableAlternativesRule()); 
            pushFollow(FOLLOW_1);
            ruleCrossReferenceableAlternatives();

            state._fsp--;

             after(grammarAccess.getCrossReferenceableAlternativesRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCrossReferenceableAlternatives"


    // $ANTLR start "ruleCrossReferenceableAlternatives"
    // InternalXtextGrammarTestLanguage.g:637:1: ruleCrossReferenceableAlternatives : ( ( rule__CrossReferenceableAlternatives__Group__0 ) ) ;
    public final void ruleCrossReferenceableAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:641:2: ( ( ( rule__CrossReferenceableAlternatives__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:642:2: ( ( rule__CrossReferenceableAlternatives__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:642:2: ( ( rule__CrossReferenceableAlternatives__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:643:3: ( rule__CrossReferenceableAlternatives__Group__0 )
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:644:3: ( rule__CrossReferenceableAlternatives__Group__0 )
            // InternalXtextGrammarTestLanguage.g:644:4: rule__CrossReferenceableAlternatives__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__CrossReferenceableAlternatives__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleCrossReferenceableAlternatives"


    // $ANTLR start "entryRuleParenthesizedElement"
    // InternalXtextGrammarTestLanguage.g:653:1: entryRuleParenthesizedElement : ruleParenthesizedElement EOF ;
    public final void entryRuleParenthesizedElement() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:654:1: ( ruleParenthesizedElement EOF )
            // InternalXtextGrammarTestLanguage.g:655:1: ruleParenthesizedElement EOF
            {
             before(grammarAccess.getParenthesizedElementRule()); 
            pushFollow(FOLLOW_1);
            ruleParenthesizedElement();

            state._fsp--;

             after(grammarAccess.getParenthesizedElementRule()); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalXtextGrammarTestLanguage.g:662:1: ruleParenthesizedElement : ( ( rule__ParenthesizedElement__Group__0 ) ) ;
    public final void ruleParenthesizedElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:666:2: ( ( ( rule__ParenthesizedElement__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:667:2: ( ( rule__ParenthesizedElement__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:667:2: ( ( rule__ParenthesizedElement__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:668:3: ( rule__ParenthesizedElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedElementAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:669:3: ( rule__ParenthesizedElement__Group__0 )
            // InternalXtextGrammarTestLanguage.g:669:4: rule__ParenthesizedElement__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:678:1: entryRuleTerminalRule : ruleTerminalRule EOF ;
    public final void entryRuleTerminalRule() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:679:1: ( ruleTerminalRule EOF )
            // InternalXtextGrammarTestLanguage.g:680:1: ruleTerminalRule EOF
            {
             before(grammarAccess.getTerminalRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleTerminalRule();

            state._fsp--;

             after(grammarAccess.getTerminalRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalXtextGrammarTestLanguage.g:687:1: ruleTerminalRule : ( ( rule__TerminalRule__Group__0 ) ) ;
    public final void ruleTerminalRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:691:2: ( ( ( rule__TerminalRule__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:692:2: ( ( rule__TerminalRule__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:692:2: ( ( rule__TerminalRule__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:693:3: ( rule__TerminalRule__Group__0 )
            {
             before(grammarAccess.getTerminalRuleAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:694:3: ( rule__TerminalRule__Group__0 )
            // InternalXtextGrammarTestLanguage.g:694:4: rule__TerminalRule__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:703:1: entryRuleTerminalAlternatives : ruleTerminalAlternatives EOF ;
    public final void entryRuleTerminalAlternatives() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:704:1: ( ruleTerminalAlternatives EOF )
            // InternalXtextGrammarTestLanguage.g:705:1: ruleTerminalAlternatives EOF
            {
             before(grammarAccess.getTerminalAlternativesRule()); 
            pushFollow(FOLLOW_1);
            ruleTerminalAlternatives();

            state._fsp--;

             after(grammarAccess.getTerminalAlternativesRule()); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalXtextGrammarTestLanguage.g:712:1: ruleTerminalAlternatives : ( ( rule__TerminalAlternatives__Group__0 ) ) ;
    public final void ruleTerminalAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:716:2: ( ( ( rule__TerminalAlternatives__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:717:2: ( ( rule__TerminalAlternatives__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:717:2: ( ( rule__TerminalAlternatives__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:718:3: ( rule__TerminalAlternatives__Group__0 )
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:719:3: ( rule__TerminalAlternatives__Group__0 )
            // InternalXtextGrammarTestLanguage.g:719:4: rule__TerminalAlternatives__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:728:1: entryRuleTerminalGroup : ruleTerminalGroup EOF ;
    public final void entryRuleTerminalGroup() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:729:1: ( ruleTerminalGroup EOF )
            // InternalXtextGrammarTestLanguage.g:730:1: ruleTerminalGroup EOF
            {
             before(grammarAccess.getTerminalGroupRule()); 
            pushFollow(FOLLOW_1);
            ruleTerminalGroup();

            state._fsp--;

             after(grammarAccess.getTerminalGroupRule()); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalXtextGrammarTestLanguage.g:737:1: ruleTerminalGroup : ( ( rule__TerminalGroup__Group__0 ) ) ;
    public final void ruleTerminalGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:741:2: ( ( ( rule__TerminalGroup__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:742:2: ( ( rule__TerminalGroup__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:742:2: ( ( rule__TerminalGroup__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:743:3: ( rule__TerminalGroup__Group__0 )
            {
             before(grammarAccess.getTerminalGroupAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:744:3: ( rule__TerminalGroup__Group__0 )
            // InternalXtextGrammarTestLanguage.g:744:4: rule__TerminalGroup__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:753:1: entryRuleTerminalToken : ruleTerminalToken EOF ;
    public final void entryRuleTerminalToken() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:754:1: ( ruleTerminalToken EOF )
            // InternalXtextGrammarTestLanguage.g:755:1: ruleTerminalToken EOF
            {
             before(grammarAccess.getTerminalTokenRule()); 
            pushFollow(FOLLOW_1);
            ruleTerminalToken();

            state._fsp--;

             after(grammarAccess.getTerminalTokenRule()); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalXtextGrammarTestLanguage.g:762:1: ruleTerminalToken : ( ( rule__TerminalToken__Group__0 ) ) ;
    public final void ruleTerminalToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:766:2: ( ( ( rule__TerminalToken__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:767:2: ( ( rule__TerminalToken__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:767:2: ( ( rule__TerminalToken__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:768:3: ( rule__TerminalToken__Group__0 )
            {
             before(grammarAccess.getTerminalTokenAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:769:3: ( rule__TerminalToken__Group__0 )
            // InternalXtextGrammarTestLanguage.g:769:4: rule__TerminalToken__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:778:1: entryRuleTerminalTokenElement : ruleTerminalTokenElement EOF ;
    public final void entryRuleTerminalTokenElement() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:779:1: ( ruleTerminalTokenElement EOF )
            // InternalXtextGrammarTestLanguage.g:780:1: ruleTerminalTokenElement EOF
            {
             before(grammarAccess.getTerminalTokenElementRule()); 
            pushFollow(FOLLOW_1);
            ruleTerminalTokenElement();

            state._fsp--;

             after(grammarAccess.getTerminalTokenElementRule()); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalXtextGrammarTestLanguage.g:787:1: ruleTerminalTokenElement : ( ( rule__TerminalTokenElement__Alternatives ) ) ;
    public final void ruleTerminalTokenElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:791:2: ( ( ( rule__TerminalTokenElement__Alternatives ) ) )
            // InternalXtextGrammarTestLanguage.g:792:2: ( ( rule__TerminalTokenElement__Alternatives ) )
            {
            // InternalXtextGrammarTestLanguage.g:792:2: ( ( rule__TerminalTokenElement__Alternatives ) )
            // InternalXtextGrammarTestLanguage.g:793:3: ( rule__TerminalTokenElement__Alternatives )
            {
             before(grammarAccess.getTerminalTokenElementAccess().getAlternatives()); 
            // InternalXtextGrammarTestLanguage.g:794:3: ( rule__TerminalTokenElement__Alternatives )
            // InternalXtextGrammarTestLanguage.g:794:4: rule__TerminalTokenElement__Alternatives
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:803:1: entryRuleParenthesizedTerminalElement : ruleParenthesizedTerminalElement EOF ;
    public final void entryRuleParenthesizedTerminalElement() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:804:1: ( ruleParenthesizedTerminalElement EOF )
            // InternalXtextGrammarTestLanguage.g:805:1: ruleParenthesizedTerminalElement EOF
            {
             before(grammarAccess.getParenthesizedTerminalElementRule()); 
            pushFollow(FOLLOW_1);
            ruleParenthesizedTerminalElement();

            state._fsp--;

             after(grammarAccess.getParenthesizedTerminalElementRule()); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalXtextGrammarTestLanguage.g:812:1: ruleParenthesizedTerminalElement : ( ( rule__ParenthesizedTerminalElement__Group__0 ) ) ;
    public final void ruleParenthesizedTerminalElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:816:2: ( ( ( rule__ParenthesizedTerminalElement__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:817:2: ( ( rule__ParenthesizedTerminalElement__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:817:2: ( ( rule__ParenthesizedTerminalElement__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:818:3: ( rule__ParenthesizedTerminalElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:819:3: ( rule__ParenthesizedTerminalElement__Group__0 )
            // InternalXtextGrammarTestLanguage.g:819:4: rule__ParenthesizedTerminalElement__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:828:1: entryRuleAbstractNegatedToken : ruleAbstractNegatedToken EOF ;
    public final void entryRuleAbstractNegatedToken() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:829:1: ( ruleAbstractNegatedToken EOF )
            // InternalXtextGrammarTestLanguage.g:830:1: ruleAbstractNegatedToken EOF
            {
             before(grammarAccess.getAbstractNegatedTokenRule()); 
            pushFollow(FOLLOW_1);
            ruleAbstractNegatedToken();

            state._fsp--;

             after(grammarAccess.getAbstractNegatedTokenRule()); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalXtextGrammarTestLanguage.g:837:1: ruleAbstractNegatedToken : ( ( rule__AbstractNegatedToken__Alternatives ) ) ;
    public final void ruleAbstractNegatedToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:841:2: ( ( ( rule__AbstractNegatedToken__Alternatives ) ) )
            // InternalXtextGrammarTestLanguage.g:842:2: ( ( rule__AbstractNegatedToken__Alternatives ) )
            {
            // InternalXtextGrammarTestLanguage.g:842:2: ( ( rule__AbstractNegatedToken__Alternatives ) )
            // InternalXtextGrammarTestLanguage.g:843:3: ( rule__AbstractNegatedToken__Alternatives )
            {
             before(grammarAccess.getAbstractNegatedTokenAccess().getAlternatives()); 
            // InternalXtextGrammarTestLanguage.g:844:3: ( rule__AbstractNegatedToken__Alternatives )
            // InternalXtextGrammarTestLanguage.g:844:4: rule__AbstractNegatedToken__Alternatives
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:853:1: entryRuleNegatedToken : ruleNegatedToken EOF ;
    public final void entryRuleNegatedToken() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:854:1: ( ruleNegatedToken EOF )
            // InternalXtextGrammarTestLanguage.g:855:1: ruleNegatedToken EOF
            {
             before(grammarAccess.getNegatedTokenRule()); 
            pushFollow(FOLLOW_1);
            ruleNegatedToken();

            state._fsp--;

             after(grammarAccess.getNegatedTokenRule()); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalXtextGrammarTestLanguage.g:862:1: ruleNegatedToken : ( ( rule__NegatedToken__Group__0 ) ) ;
    public final void ruleNegatedToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:866:2: ( ( ( rule__NegatedToken__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:867:2: ( ( rule__NegatedToken__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:867:2: ( ( rule__NegatedToken__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:868:3: ( rule__NegatedToken__Group__0 )
            {
             before(grammarAccess.getNegatedTokenAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:869:3: ( rule__NegatedToken__Group__0 )
            // InternalXtextGrammarTestLanguage.g:869:4: rule__NegatedToken__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:878:1: entryRuleUntilToken : ruleUntilToken EOF ;
    public final void entryRuleUntilToken() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:879:1: ( ruleUntilToken EOF )
            // InternalXtextGrammarTestLanguage.g:880:1: ruleUntilToken EOF
            {
             before(grammarAccess.getUntilTokenRule()); 
            pushFollow(FOLLOW_1);
            ruleUntilToken();

            state._fsp--;

             after(grammarAccess.getUntilTokenRule()); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalXtextGrammarTestLanguage.g:887:1: ruleUntilToken : ( ( rule__UntilToken__Group__0 ) ) ;
    public final void ruleUntilToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:891:2: ( ( ( rule__UntilToken__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:892:2: ( ( rule__UntilToken__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:892:2: ( ( rule__UntilToken__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:893:3: ( rule__UntilToken__Group__0 )
            {
             before(grammarAccess.getUntilTokenAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:894:3: ( rule__UntilToken__Group__0 )
            // InternalXtextGrammarTestLanguage.g:894:4: rule__UntilToken__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:903:1: entryRuleWildcard : ruleWildcard EOF ;
    public final void entryRuleWildcard() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:904:1: ( ruleWildcard EOF )
            // InternalXtextGrammarTestLanguage.g:905:1: ruleWildcard EOF
            {
             before(grammarAccess.getWildcardRule()); 
            pushFollow(FOLLOW_1);
            ruleWildcard();

            state._fsp--;

             after(grammarAccess.getWildcardRule()); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalXtextGrammarTestLanguage.g:912:1: ruleWildcard : ( ( rule__Wildcard__Group__0 ) ) ;
    public final void ruleWildcard() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:916:2: ( ( ( rule__Wildcard__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:917:2: ( ( rule__Wildcard__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:917:2: ( ( rule__Wildcard__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:918:3: ( rule__Wildcard__Group__0 )
            {
             before(grammarAccess.getWildcardAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:919:3: ( rule__Wildcard__Group__0 )
            // InternalXtextGrammarTestLanguage.g:919:4: rule__Wildcard__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:928:1: entryRuleCharacterRange : ruleCharacterRange EOF ;
    public final void entryRuleCharacterRange() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:929:1: ( ruleCharacterRange EOF )
            // InternalXtextGrammarTestLanguage.g:930:1: ruleCharacterRange EOF
            {
             before(grammarAccess.getCharacterRangeRule()); 
            pushFollow(FOLLOW_1);
            ruleCharacterRange();

            state._fsp--;

             after(grammarAccess.getCharacterRangeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalXtextGrammarTestLanguage.g:937:1: ruleCharacterRange : ( ( rule__CharacterRange__Group__0 ) ) ;
    public final void ruleCharacterRange() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:941:2: ( ( ( rule__CharacterRange__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:942:2: ( ( rule__CharacterRange__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:942:2: ( ( rule__CharacterRange__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:943:3: ( rule__CharacterRange__Group__0 )
            {
             before(grammarAccess.getCharacterRangeAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:944:3: ( rule__CharacterRange__Group__0 )
            // InternalXtextGrammarTestLanguage.g:944:4: rule__CharacterRange__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:953:1: entryRuleEnumRule : ruleEnumRule EOF ;
    public final void entryRuleEnumRule() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:954:1: ( ruleEnumRule EOF )
            // InternalXtextGrammarTestLanguage.g:955:1: ruleEnumRule EOF
            {
             before(grammarAccess.getEnumRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleEnumRule();

            state._fsp--;

             after(grammarAccess.getEnumRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalXtextGrammarTestLanguage.g:962:1: ruleEnumRule : ( ( rule__EnumRule__Group__0 ) ) ;
    public final void ruleEnumRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:966:2: ( ( ( rule__EnumRule__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:967:2: ( ( rule__EnumRule__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:967:2: ( ( rule__EnumRule__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:968:3: ( rule__EnumRule__Group__0 )
            {
             before(grammarAccess.getEnumRuleAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:969:3: ( rule__EnumRule__Group__0 )
            // InternalXtextGrammarTestLanguage.g:969:4: rule__EnumRule__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:978:1: entryRuleEnumLiterals : ruleEnumLiterals EOF ;
    public final void entryRuleEnumLiterals() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:979:1: ( ruleEnumLiterals EOF )
            // InternalXtextGrammarTestLanguage.g:980:1: ruleEnumLiterals EOF
            {
             before(grammarAccess.getEnumLiteralsRule()); 
            pushFollow(FOLLOW_1);
            ruleEnumLiterals();

            state._fsp--;

             after(grammarAccess.getEnumLiteralsRule()); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalXtextGrammarTestLanguage.g:987:1: ruleEnumLiterals : ( ( rule__EnumLiterals__Group__0 ) ) ;
    public final void ruleEnumLiterals() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:991:2: ( ( ( rule__EnumLiterals__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:992:2: ( ( rule__EnumLiterals__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:992:2: ( ( rule__EnumLiterals__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:993:3: ( rule__EnumLiterals__Group__0 )
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:994:3: ( rule__EnumLiterals__Group__0 )
            // InternalXtextGrammarTestLanguage.g:994:4: rule__EnumLiterals__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1003:1: entryRuleEnumLiteralDeclaration : ruleEnumLiteralDeclaration EOF ;
    public final void entryRuleEnumLiteralDeclaration() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:1004:1: ( ruleEnumLiteralDeclaration EOF )
            // InternalXtextGrammarTestLanguage.g:1005:1: ruleEnumLiteralDeclaration EOF
            {
             before(grammarAccess.getEnumLiteralDeclarationRule()); 
            pushFollow(FOLLOW_1);
            ruleEnumLiteralDeclaration();

            state._fsp--;

             after(grammarAccess.getEnumLiteralDeclarationRule()); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalXtextGrammarTestLanguage.g:1012:1: ruleEnumLiteralDeclaration : ( ( rule__EnumLiteralDeclaration__Group__0 ) ) ;
    public final void ruleEnumLiteralDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1016:2: ( ( ( rule__EnumLiteralDeclaration__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:1017:2: ( ( rule__EnumLiteralDeclaration__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:1017:2: ( ( rule__EnumLiteralDeclaration__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:1018:3: ( rule__EnumLiteralDeclaration__Group__0 )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:1019:3: ( rule__EnumLiteralDeclaration__Group__0 )
            // InternalXtextGrammarTestLanguage.g:1019:4: rule__EnumLiteralDeclaration__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1027:1: rule__AbstractRule__Alternatives : ( ( ruleParserRule ) | ( ruleTerminalRule ) | ( ruleEnumRule ) );
    public final void rule__AbstractRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1031:1: ( ( ruleParserRule ) | ( ruleTerminalRule ) | ( ruleEnumRule ) )
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
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1032:2: ( ruleParserRule )
                    {
                    // InternalXtextGrammarTestLanguage.g:1032:2: ( ruleParserRule )
                    // InternalXtextGrammarTestLanguage.g:1033:3: ruleParserRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getParserRuleParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleParserRule();

                    state._fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getParserRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1038:2: ( ruleTerminalRule )
                    {
                    // InternalXtextGrammarTestLanguage.g:1038:2: ( ruleTerminalRule )
                    // InternalXtextGrammarTestLanguage.g:1039:3: ruleTerminalRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getTerminalRuleParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleTerminalRule();

                    state._fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getTerminalRuleParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtextGrammarTestLanguage.g:1044:2: ( ruleEnumRule )
                    {
                    // InternalXtextGrammarTestLanguage.g:1044:2: ( ruleEnumRule )
                    // InternalXtextGrammarTestLanguage.g:1045:3: ruleEnumRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getEnumRuleParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1054:1: rule__AbstractMetamodelDeclaration__Alternatives : ( ( ruleGeneratedMetamodel ) | ( ruleReferencedMetamodel ) );
    public final void rule__AbstractMetamodelDeclaration__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1058:1: ( ( ruleGeneratedMetamodel ) | ( ruleReferencedMetamodel ) )
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
                    // InternalXtextGrammarTestLanguage.g:1059:2: ( ruleGeneratedMetamodel )
                    {
                    // InternalXtextGrammarTestLanguage.g:1059:2: ( ruleGeneratedMetamodel )
                    // InternalXtextGrammarTestLanguage.g:1060:3: ruleGeneratedMetamodel
                    {
                     before(grammarAccess.getAbstractMetamodelDeclarationAccess().getGeneratedMetamodelParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleGeneratedMetamodel();

                    state._fsp--;

                     after(grammarAccess.getAbstractMetamodelDeclarationAccess().getGeneratedMetamodelParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1065:2: ( ruleReferencedMetamodel )
                    {
                    // InternalXtextGrammarTestLanguage.g:1065:2: ( ruleReferencedMetamodel )
                    // InternalXtextGrammarTestLanguage.g:1066:3: ruleReferencedMetamodel
                    {
                     before(grammarAccess.getAbstractMetamodelDeclarationAccess().getReferencedMetamodelParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1075:1: rule__AbstractToken__Alternatives : ( ( ruleAbstractTokenWithCardinality ) | ( ruleAction ) );
    public final void rule__AbstractToken__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1079:1: ( ( ruleAbstractTokenWithCardinality ) | ( ruleAction ) )
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
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1080:2: ( ruleAbstractTokenWithCardinality )
                    {
                    // InternalXtextGrammarTestLanguage.g:1080:2: ( ruleAbstractTokenWithCardinality )
                    // InternalXtextGrammarTestLanguage.g:1081:3: ruleAbstractTokenWithCardinality
                    {
                     before(grammarAccess.getAbstractTokenAccess().getAbstractTokenWithCardinalityParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleAbstractTokenWithCardinality();

                    state._fsp--;

                     after(grammarAccess.getAbstractTokenAccess().getAbstractTokenWithCardinalityParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1086:2: ( ruleAction )
                    {
                    // InternalXtextGrammarTestLanguage.g:1086:2: ( ruleAction )
                    // InternalXtextGrammarTestLanguage.g:1087:3: ruleAction
                    {
                     before(grammarAccess.getAbstractTokenAccess().getActionParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1096:1: rule__AbstractTokenWithCardinality__Alternatives_0 : ( ( ruleAssignment ) | ( ruleAbstractTerminal ) );
    public final void rule__AbstractTokenWithCardinality__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1100:1: ( ( ruleAssignment ) | ( ruleAbstractTerminal ) )
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
                    // InternalXtextGrammarTestLanguage.g:1101:2: ( ruleAssignment )
                    {
                    // InternalXtextGrammarTestLanguage.g:1101:2: ( ruleAssignment )
                    // InternalXtextGrammarTestLanguage.g:1102:3: ruleAssignment
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getAssignmentParserRuleCall_0_0()); 
                    pushFollow(FOLLOW_2);
                    ruleAssignment();

                    state._fsp--;

                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getAssignmentParserRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1107:2: ( ruleAbstractTerminal )
                    {
                    // InternalXtextGrammarTestLanguage.g:1107:2: ( ruleAbstractTerminal )
                    // InternalXtextGrammarTestLanguage.g:1108:3: ruleAbstractTerminal
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getAbstractTerminalParserRuleCall_0_1()); 
                    pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1117:1: rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 : ( ( '?' ) | ( '*' ) | ( '+' ) );
    public final void rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1121:1: ( ( '?' ) | ( '*' ) | ( '+' ) )
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
                    // InternalXtextGrammarTestLanguage.g:1122:2: ( '?' )
                    {
                    // InternalXtextGrammarTestLanguage.g:1122:2: ( '?' )
                    // InternalXtextGrammarTestLanguage.g:1123:3: '?'
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1128:2: ( '*' )
                    {
                    // InternalXtextGrammarTestLanguage.g:1128:2: ( '*' )
                    // InternalXtextGrammarTestLanguage.g:1129:3: '*'
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAsteriskKeyword_1_0_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAsteriskKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtextGrammarTestLanguage.g:1134:2: ( '+' )
                    {
                    // InternalXtextGrammarTestLanguage.g:1134:2: ( '+' )
                    // InternalXtextGrammarTestLanguage.g:1135:3: '+'
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityPlusSignKeyword_1_0_2()); 
                    match(input,13,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:1144:1: rule__Action__OperatorAlternatives_2_2_0 : ( ( '=' ) | ( '+=' ) );
    public final void rule__Action__OperatorAlternatives_2_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1148:1: ( ( '=' ) | ( '+=' ) )
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
                    // InternalXtextGrammarTestLanguage.g:1149:2: ( '=' )
                    {
                    // InternalXtextGrammarTestLanguage.g:1149:2: ( '=' )
                    // InternalXtextGrammarTestLanguage.g:1150:3: '='
                    {
                     before(grammarAccess.getActionAccess().getOperatorEqualsSignKeyword_2_2_0_0()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getActionAccess().getOperatorEqualsSignKeyword_2_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1155:2: ( '+=' )
                    {
                    // InternalXtextGrammarTestLanguage.g:1155:2: ( '+=' )
                    // InternalXtextGrammarTestLanguage.g:1156:3: '+='
                    {
                     before(grammarAccess.getActionAccess().getOperatorPlusSignEqualsSignKeyword_2_2_0_1()); 
                    match(input,15,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:1165:1: rule__AbstractTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedElement ) );
    public final void rule__AbstractTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1169:1: ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedElement ) )
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
                    // InternalXtextGrammarTestLanguage.g:1170:2: ( ruleKeyword )
                    {
                    // InternalXtextGrammarTestLanguage.g:1170:2: ( ruleKeyword )
                    // InternalXtextGrammarTestLanguage.g:1171:3: ruleKeyword
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getKeywordParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleKeyword();

                    state._fsp--;

                     after(grammarAccess.getAbstractTerminalAccess().getKeywordParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1176:2: ( ruleRuleCall )
                    {
                    // InternalXtextGrammarTestLanguage.g:1176:2: ( ruleRuleCall )
                    // InternalXtextGrammarTestLanguage.g:1177:3: ruleRuleCall
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleRuleCall();

                    state._fsp--;

                     after(grammarAccess.getAbstractTerminalAccess().getRuleCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtextGrammarTestLanguage.g:1182:2: ( ruleParenthesizedElement )
                    {
                    // InternalXtextGrammarTestLanguage.g:1182:2: ( ruleParenthesizedElement )
                    // InternalXtextGrammarTestLanguage.g:1183:3: ruleParenthesizedElement
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getParenthesizedElementParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1192:1: rule__Assignment__OperatorAlternatives_1_0 : ( ( '+=' ) | ( '=' ) | ( '?=' ) );
    public final void rule__Assignment__OperatorAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1196:1: ( ( '+=' ) | ( '=' ) | ( '?=' ) )
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
                    // InternalXtextGrammarTestLanguage.g:1197:2: ( '+=' )
                    {
                    // InternalXtextGrammarTestLanguage.g:1197:2: ( '+=' )
                    // InternalXtextGrammarTestLanguage.g:1198:3: '+='
                    {
                     before(grammarAccess.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_1_0_0()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1203:2: ( '=' )
                    {
                    // InternalXtextGrammarTestLanguage.g:1203:2: ( '=' )
                    // InternalXtextGrammarTestLanguage.g:1204:3: '='
                    {
                     before(grammarAccess.getAssignmentAccess().getOperatorEqualsSignKeyword_1_0_1()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getAssignmentAccess().getOperatorEqualsSignKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtextGrammarTestLanguage.g:1209:2: ( '?=' )
                    {
                    // InternalXtextGrammarTestLanguage.g:1209:2: ( '?=' )
                    // InternalXtextGrammarTestLanguage.g:1210:3: '?='
                    {
                     before(grammarAccess.getAssignmentAccess().getOperatorQuestionMarkEqualsSignKeyword_1_0_2()); 
                    match(input,16,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:1219:1: rule__AssignableTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedAssignableElement ) | ( ruleCrossReference ) );
    public final void rule__AssignableTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1223:1: ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedAssignableElement ) | ( ruleCrossReference ) )
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
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1224:2: ( ruleKeyword )
                    {
                    // InternalXtextGrammarTestLanguage.g:1224:2: ( ruleKeyword )
                    // InternalXtextGrammarTestLanguage.g:1225:3: ruleKeyword
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getKeywordParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleKeyword();

                    state._fsp--;

                     after(grammarAccess.getAssignableTerminalAccess().getKeywordParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1230:2: ( ruleRuleCall )
                    {
                    // InternalXtextGrammarTestLanguage.g:1230:2: ( ruleRuleCall )
                    // InternalXtextGrammarTestLanguage.g:1231:3: ruleRuleCall
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleRuleCall();

                    state._fsp--;

                     after(grammarAccess.getAssignableTerminalAccess().getRuleCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtextGrammarTestLanguage.g:1236:2: ( ruleParenthesizedAssignableElement )
                    {
                    // InternalXtextGrammarTestLanguage.g:1236:2: ( ruleParenthesizedAssignableElement )
                    // InternalXtextGrammarTestLanguage.g:1237:3: ruleParenthesizedAssignableElement
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getParenthesizedAssignableElementParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleParenthesizedAssignableElement();

                    state._fsp--;

                     after(grammarAccess.getAssignableTerminalAccess().getParenthesizedAssignableElementParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalXtextGrammarTestLanguage.g:1242:2: ( ruleCrossReference )
                    {
                    // InternalXtextGrammarTestLanguage.g:1242:2: ( ruleCrossReference )
                    // InternalXtextGrammarTestLanguage.g:1243:3: ruleCrossReference
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getCrossReferenceParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1252:1: rule__CrossReferenceableTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedCrossReferenceableElement ) );
    public final void rule__CrossReferenceableTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1256:1: ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedCrossReferenceableElement ) )
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
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1257:2: ( ruleKeyword )
                    {
                    // InternalXtextGrammarTestLanguage.g:1257:2: ( ruleKeyword )
                    // InternalXtextGrammarTestLanguage.g:1258:3: ruleKeyword
                    {
                     before(grammarAccess.getCrossReferenceableTerminalAccess().getKeywordParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleKeyword();

                    state._fsp--;

                     after(grammarAccess.getCrossReferenceableTerminalAccess().getKeywordParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1263:2: ( ruleRuleCall )
                    {
                    // InternalXtextGrammarTestLanguage.g:1263:2: ( ruleRuleCall )
                    // InternalXtextGrammarTestLanguage.g:1264:3: ruleRuleCall
                    {
                     before(grammarAccess.getCrossReferenceableTerminalAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleRuleCall();

                    state._fsp--;

                     after(grammarAccess.getCrossReferenceableTerminalAccess().getRuleCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtextGrammarTestLanguage.g:1269:2: ( ruleParenthesizedCrossReferenceableElement )
                    {
                    // InternalXtextGrammarTestLanguage.g:1269:2: ( ruleParenthesizedCrossReferenceableElement )
                    // InternalXtextGrammarTestLanguage.g:1270:3: ruleParenthesizedCrossReferenceableElement
                    {
                     before(grammarAccess.getCrossReferenceableTerminalAccess().getParenthesizedCrossReferenceableElementParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleParenthesizedCrossReferenceableElement();

                    state._fsp--;

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
    // $ANTLR end "rule__CrossReferenceableTerminal__Alternatives"


    // $ANTLR start "rule__TerminalToken__CardinalityAlternatives_1_0"
    // InternalXtextGrammarTestLanguage.g:1279:1: rule__TerminalToken__CardinalityAlternatives_1_0 : ( ( '?' ) | ( '*' ) | ( '+' ) );
    public final void rule__TerminalToken__CardinalityAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1283:1: ( ( '?' ) | ( '*' ) | ( '+' ) )
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
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1284:2: ( '?' )
                    {
                    // InternalXtextGrammarTestLanguage.g:1284:2: ( '?' )
                    // InternalXtextGrammarTestLanguage.g:1285:3: '?'
                    {
                     before(grammarAccess.getTerminalTokenAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getTerminalTokenAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1290:2: ( '*' )
                    {
                    // InternalXtextGrammarTestLanguage.g:1290:2: ( '*' )
                    // InternalXtextGrammarTestLanguage.g:1291:3: '*'
                    {
                     before(grammarAccess.getTerminalTokenAccess().getCardinalityAsteriskKeyword_1_0_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getTerminalTokenAccess().getCardinalityAsteriskKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtextGrammarTestLanguage.g:1296:2: ( '+' )
                    {
                    // InternalXtextGrammarTestLanguage.g:1296:2: ( '+' )
                    // InternalXtextGrammarTestLanguage.g:1297:3: '+'
                    {
                     before(grammarAccess.getTerminalTokenAccess().getCardinalityPlusSignKeyword_1_0_2()); 
                    match(input,13,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:1306:1: rule__TerminalTokenElement__Alternatives : ( ( ruleCharacterRange ) | ( ruleRuleCall ) | ( ruleParenthesizedTerminalElement ) | ( ruleAbstractNegatedToken ) | ( ruleWildcard ) );
    public final void rule__TerminalTokenElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1310:1: ( ( ruleCharacterRange ) | ( ruleRuleCall ) | ( ruleParenthesizedTerminalElement ) | ( ruleAbstractNegatedToken ) | ( ruleWildcard ) )
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
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1311:2: ( ruleCharacterRange )
                    {
                    // InternalXtextGrammarTestLanguage.g:1311:2: ( ruleCharacterRange )
                    // InternalXtextGrammarTestLanguage.g:1312:3: ruleCharacterRange
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getCharacterRangeParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleCharacterRange();

                    state._fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getCharacterRangeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1317:2: ( ruleRuleCall )
                    {
                    // InternalXtextGrammarTestLanguage.g:1317:2: ( ruleRuleCall )
                    // InternalXtextGrammarTestLanguage.g:1318:3: ruleRuleCall
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleRuleCall();

                    state._fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getRuleCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtextGrammarTestLanguage.g:1323:2: ( ruleParenthesizedTerminalElement )
                    {
                    // InternalXtextGrammarTestLanguage.g:1323:2: ( ruleParenthesizedTerminalElement )
                    // InternalXtextGrammarTestLanguage.g:1324:3: ruleParenthesizedTerminalElement
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getParenthesizedTerminalElementParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleParenthesizedTerminalElement();

                    state._fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getParenthesizedTerminalElementParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalXtextGrammarTestLanguage.g:1329:2: ( ruleAbstractNegatedToken )
                    {
                    // InternalXtextGrammarTestLanguage.g:1329:2: ( ruleAbstractNegatedToken )
                    // InternalXtextGrammarTestLanguage.g:1330:3: ruleAbstractNegatedToken
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getAbstractNegatedTokenParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleAbstractNegatedToken();

                    state._fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getAbstractNegatedTokenParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalXtextGrammarTestLanguage.g:1335:2: ( ruleWildcard )
                    {
                    // InternalXtextGrammarTestLanguage.g:1335:2: ( ruleWildcard )
                    // InternalXtextGrammarTestLanguage.g:1336:3: ruleWildcard
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getWildcardParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1345:1: rule__AbstractNegatedToken__Alternatives : ( ( ruleNegatedToken ) | ( ruleUntilToken ) );
    public final void rule__AbstractNegatedToken__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1349:1: ( ( ruleNegatedToken ) | ( ruleUntilToken ) )
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
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1350:2: ( ruleNegatedToken )
                    {
                    // InternalXtextGrammarTestLanguage.g:1350:2: ( ruleNegatedToken )
                    // InternalXtextGrammarTestLanguage.g:1351:3: ruleNegatedToken
                    {
                     before(grammarAccess.getAbstractNegatedTokenAccess().getNegatedTokenParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleNegatedToken();

                    state._fsp--;

                     after(grammarAccess.getAbstractNegatedTokenAccess().getNegatedTokenParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1356:2: ( ruleUntilToken )
                    {
                    // InternalXtextGrammarTestLanguage.g:1356:2: ( ruleUntilToken )
                    // InternalXtextGrammarTestLanguage.g:1357:3: ruleUntilToken
                    {
                     before(grammarAccess.getAbstractNegatedTokenAccess().getUntilTokenParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1366:1: rule__Grammar__Group__0 : rule__Grammar__Group__0__Impl rule__Grammar__Group__1 ;
    public final void rule__Grammar__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1370:1: ( rule__Grammar__Group__0__Impl rule__Grammar__Group__1 )
            // InternalXtextGrammarTestLanguage.g:1371:2: rule__Grammar__Group__0__Impl rule__Grammar__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Grammar__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1378:1: rule__Grammar__Group__0__Impl : ( 'grammar' ) ;
    public final void rule__Grammar__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1382:1: ( ( 'grammar' ) )
            // InternalXtextGrammarTestLanguage.g:1383:1: ( 'grammar' )
            {
            // InternalXtextGrammarTestLanguage.g:1383:1: ( 'grammar' )
            // InternalXtextGrammarTestLanguage.g:1384:2: 'grammar'
            {
             before(grammarAccess.getGrammarAccess().getGrammarKeyword_0()); 
            match(input,17,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:1393:1: rule__Grammar__Group__1 : rule__Grammar__Group__1__Impl rule__Grammar__Group__2 ;
    public final void rule__Grammar__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1397:1: ( rule__Grammar__Group__1__Impl rule__Grammar__Group__2 )
            // InternalXtextGrammarTestLanguage.g:1398:2: rule__Grammar__Group__1__Impl rule__Grammar__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Grammar__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1405:1: rule__Grammar__Group__1__Impl : ( ( rule__Grammar__NameAssignment_1 ) ) ;
    public final void rule__Grammar__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1409:1: ( ( ( rule__Grammar__NameAssignment_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:1410:1: ( ( rule__Grammar__NameAssignment_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:1410:1: ( ( rule__Grammar__NameAssignment_1 ) )
            // InternalXtextGrammarTestLanguage.g:1411:2: ( rule__Grammar__NameAssignment_1 )
            {
             before(grammarAccess.getGrammarAccess().getNameAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:1412:2: ( rule__Grammar__NameAssignment_1 )
            // InternalXtextGrammarTestLanguage.g:1412:3: rule__Grammar__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1420:1: rule__Grammar__Group__2 : rule__Grammar__Group__2__Impl rule__Grammar__Group__3 ;
    public final void rule__Grammar__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1424:1: ( rule__Grammar__Group__2__Impl rule__Grammar__Group__3 )
            // InternalXtextGrammarTestLanguage.g:1425:2: rule__Grammar__Group__2__Impl rule__Grammar__Group__3
            {
            pushFollow(FOLLOW_4);
            rule__Grammar__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1432:1: rule__Grammar__Group__2__Impl : ( ( rule__Grammar__Group_2__0 )? ) ;
    public final void rule__Grammar__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1436:1: ( ( ( rule__Grammar__Group_2__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:1437:1: ( ( rule__Grammar__Group_2__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:1437:1: ( ( rule__Grammar__Group_2__0 )? )
            // InternalXtextGrammarTestLanguage.g:1438:2: ( rule__Grammar__Group_2__0 )?
            {
             before(grammarAccess.getGrammarAccess().getGroup_2()); 
            // InternalXtextGrammarTestLanguage.g:1439:2: ( rule__Grammar__Group_2__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==18) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1439:3: rule__Grammar__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1447:1: rule__Grammar__Group__3 : rule__Grammar__Group__3__Impl rule__Grammar__Group__4 ;
    public final void rule__Grammar__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1451:1: ( rule__Grammar__Group__3__Impl rule__Grammar__Group__4 )
            // InternalXtextGrammarTestLanguage.g:1452:2: rule__Grammar__Group__3__Impl rule__Grammar__Group__4
            {
            pushFollow(FOLLOW_4);
            rule__Grammar__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1459:1: rule__Grammar__Group__3__Impl : ( ( rule__Grammar__Group_3__0 )? ) ;
    public final void rule__Grammar__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1463:1: ( ( ( rule__Grammar__Group_3__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:1464:1: ( ( rule__Grammar__Group_3__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:1464:1: ( ( rule__Grammar__Group_3__0 )? )
            // InternalXtextGrammarTestLanguage.g:1465:2: ( rule__Grammar__Group_3__0 )?
            {
             before(grammarAccess.getGrammarAccess().getGroup_3()); 
            // InternalXtextGrammarTestLanguage.g:1466:2: ( rule__Grammar__Group_3__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==41) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1466:3: rule__Grammar__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1474:1: rule__Grammar__Group__4 : rule__Grammar__Group__4__Impl rule__Grammar__Group__5 ;
    public final void rule__Grammar__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1478:1: ( rule__Grammar__Group__4__Impl rule__Grammar__Group__5 )
            // InternalXtextGrammarTestLanguage.g:1479:2: rule__Grammar__Group__4__Impl rule__Grammar__Group__5
            {
            pushFollow(FOLLOW_4);
            rule__Grammar__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1486:1: rule__Grammar__Group__4__Impl : ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* ) ;
    public final void rule__Grammar__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1490:1: ( ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* ) )
            // InternalXtextGrammarTestLanguage.g:1491:1: ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* )
            {
            // InternalXtextGrammarTestLanguage.g:1491:1: ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* )
            // InternalXtextGrammarTestLanguage.g:1492:2: ( rule__Grammar__MetamodelDeclarationsAssignment_4 )*
            {
             before(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAssignment_4()); 
            // InternalXtextGrammarTestLanguage.g:1493:2: ( rule__Grammar__MetamodelDeclarationsAssignment_4 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==23||LA16_0==25) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:1493:3: rule__Grammar__MetamodelDeclarationsAssignment_4
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__Grammar__MetamodelDeclarationsAssignment_4();

            	    state._fsp--;


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
    // $ANTLR end "rule__Grammar__Group__4__Impl"


    // $ANTLR start "rule__Grammar__Group__5"
    // InternalXtextGrammarTestLanguage.g:1501:1: rule__Grammar__Group__5 : rule__Grammar__Group__5__Impl ;
    public final void rule__Grammar__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1505:1: ( rule__Grammar__Group__5__Impl )
            // InternalXtextGrammarTestLanguage.g:1506:2: rule__Grammar__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1512:1: rule__Grammar__Group__5__Impl : ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) ) ;
    public final void rule__Grammar__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1516:1: ( ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) ) )
            // InternalXtextGrammarTestLanguage.g:1517:1: ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) )
            {
            // InternalXtextGrammarTestLanguage.g:1517:1: ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) )
            // InternalXtextGrammarTestLanguage.g:1518:2: ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* )
            {
            // InternalXtextGrammarTestLanguage.g:1518:2: ( ( rule__Grammar__RulesAssignment_5 ) )
            // InternalXtextGrammarTestLanguage.g:1519:3: ( rule__Grammar__RulesAssignment_5 )
            {
             before(grammarAccess.getGrammarAccess().getRulesAssignment_5()); 
            // InternalXtextGrammarTestLanguage.g:1520:3: ( rule__Grammar__RulesAssignment_5 )
            // InternalXtextGrammarTestLanguage.g:1520:4: rule__Grammar__RulesAssignment_5
            {
            pushFollow(FOLLOW_6);
            rule__Grammar__RulesAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getGrammarAccess().getRulesAssignment_5()); 

            }

            // InternalXtextGrammarTestLanguage.g:1523:2: ( ( rule__Grammar__RulesAssignment_5 )* )
            // InternalXtextGrammarTestLanguage.g:1524:3: ( rule__Grammar__RulesAssignment_5 )*
            {
             before(grammarAccess.getGrammarAccess().getRulesAssignment_5()); 
            // InternalXtextGrammarTestLanguage.g:1525:3: ( rule__Grammar__RulesAssignment_5 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_ID||LA17_0==36||LA17_0==40) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:1525:4: rule__Grammar__RulesAssignment_5
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Grammar__RulesAssignment_5();

            	    state._fsp--;


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
    // $ANTLR end "rule__Grammar__Group__5__Impl"


    // $ANTLR start "rule__Grammar__Group_2__0"
    // InternalXtextGrammarTestLanguage.g:1535:1: rule__Grammar__Group_2__0 : rule__Grammar__Group_2__0__Impl rule__Grammar__Group_2__1 ;
    public final void rule__Grammar__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1539:1: ( rule__Grammar__Group_2__0__Impl rule__Grammar__Group_2__1 )
            // InternalXtextGrammarTestLanguage.g:1540:2: rule__Grammar__Group_2__0__Impl rule__Grammar__Group_2__1
            {
            pushFollow(FOLLOW_3);
            rule__Grammar__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1547:1: rule__Grammar__Group_2__0__Impl : ( 'with' ) ;
    public final void rule__Grammar__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1551:1: ( ( 'with' ) )
            // InternalXtextGrammarTestLanguage.g:1552:1: ( 'with' )
            {
            // InternalXtextGrammarTestLanguage.g:1552:1: ( 'with' )
            // InternalXtextGrammarTestLanguage.g:1553:2: 'with'
            {
             before(grammarAccess.getGrammarAccess().getWithKeyword_2_0()); 
            match(input,18,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:1562:1: rule__Grammar__Group_2__1 : rule__Grammar__Group_2__1__Impl rule__Grammar__Group_2__2 ;
    public final void rule__Grammar__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1566:1: ( rule__Grammar__Group_2__1__Impl rule__Grammar__Group_2__2 )
            // InternalXtextGrammarTestLanguage.g:1567:2: rule__Grammar__Group_2__1__Impl rule__Grammar__Group_2__2
            {
            pushFollow(FOLLOW_7);
            rule__Grammar__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1574:1: rule__Grammar__Group_2__1__Impl : ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) ) ;
    public final void rule__Grammar__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1578:1: ( ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:1579:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:1579:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) )
            // InternalXtextGrammarTestLanguage.g:1580:2: ( rule__Grammar__UsedGrammarsAssignment_2_1 )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_1()); 
            // InternalXtextGrammarTestLanguage.g:1581:2: ( rule__Grammar__UsedGrammarsAssignment_2_1 )
            // InternalXtextGrammarTestLanguage.g:1581:3: rule__Grammar__UsedGrammarsAssignment_2_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1589:1: rule__Grammar__Group_2__2 : rule__Grammar__Group_2__2__Impl ;
    public final void rule__Grammar__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1593:1: ( rule__Grammar__Group_2__2__Impl )
            // InternalXtextGrammarTestLanguage.g:1594:2: rule__Grammar__Group_2__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1600:1: rule__Grammar__Group_2__2__Impl : ( ( rule__Grammar__Group_2_2__0 )* ) ;
    public final void rule__Grammar__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1604:1: ( ( ( rule__Grammar__Group_2_2__0 )* ) )
            // InternalXtextGrammarTestLanguage.g:1605:1: ( ( rule__Grammar__Group_2_2__0 )* )
            {
            // InternalXtextGrammarTestLanguage.g:1605:1: ( ( rule__Grammar__Group_2_2__0 )* )
            // InternalXtextGrammarTestLanguage.g:1606:2: ( rule__Grammar__Group_2_2__0 )*
            {
             before(grammarAccess.getGrammarAccess().getGroup_2_2()); 
            // InternalXtextGrammarTestLanguage.g:1607:2: ( rule__Grammar__Group_2_2__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==19) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:1607:3: rule__Grammar__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__Grammar__Group_2_2__0();

            	    state._fsp--;


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
    // $ANTLR end "rule__Grammar__Group_2__2__Impl"


    // $ANTLR start "rule__Grammar__Group_2_2__0"
    // InternalXtextGrammarTestLanguage.g:1616:1: rule__Grammar__Group_2_2__0 : rule__Grammar__Group_2_2__0__Impl rule__Grammar__Group_2_2__1 ;
    public final void rule__Grammar__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1620:1: ( rule__Grammar__Group_2_2__0__Impl rule__Grammar__Group_2_2__1 )
            // InternalXtextGrammarTestLanguage.g:1621:2: rule__Grammar__Group_2_2__0__Impl rule__Grammar__Group_2_2__1
            {
            pushFollow(FOLLOW_3);
            rule__Grammar__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1628:1: rule__Grammar__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__Grammar__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1632:1: ( ( ',' ) )
            // InternalXtextGrammarTestLanguage.g:1633:1: ( ',' )
            {
            // InternalXtextGrammarTestLanguage.g:1633:1: ( ',' )
            // InternalXtextGrammarTestLanguage.g:1634:2: ','
            {
             before(grammarAccess.getGrammarAccess().getCommaKeyword_2_2_0()); 
            match(input,19,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:1643:1: rule__Grammar__Group_2_2__1 : rule__Grammar__Group_2_2__1__Impl ;
    public final void rule__Grammar__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1647:1: ( rule__Grammar__Group_2_2__1__Impl )
            // InternalXtextGrammarTestLanguage.g:1648:2: rule__Grammar__Group_2_2__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1654:1: rule__Grammar__Group_2_2__1__Impl : ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) ) ;
    public final void rule__Grammar__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1658:1: ( ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:1659:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:1659:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) )
            // InternalXtextGrammarTestLanguage.g:1660:2: ( rule__Grammar__UsedGrammarsAssignment_2_2_1 )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_2_1()); 
            // InternalXtextGrammarTestLanguage.g:1661:2: ( rule__Grammar__UsedGrammarsAssignment_2_2_1 )
            // InternalXtextGrammarTestLanguage.g:1661:3: rule__Grammar__UsedGrammarsAssignment_2_2_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1670:1: rule__Grammar__Group_3__0 : rule__Grammar__Group_3__0__Impl rule__Grammar__Group_3__1 ;
    public final void rule__Grammar__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1674:1: ( rule__Grammar__Group_3__0__Impl rule__Grammar__Group_3__1 )
            // InternalXtextGrammarTestLanguage.g:1675:2: rule__Grammar__Group_3__0__Impl rule__Grammar__Group_3__1
            {
            pushFollow(FOLLOW_9);
            rule__Grammar__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1682:1: rule__Grammar__Group_3__0__Impl : ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) ) ;
    public final void rule__Grammar__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1686:1: ( ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:1687:1: ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:1687:1: ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) )
            // InternalXtextGrammarTestLanguage.g:1688:2: ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 )
            {
             before(grammarAccess.getGrammarAccess().getDefinesHiddenTokensAssignment_3_0()); 
            // InternalXtextGrammarTestLanguage.g:1689:2: ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 )
            // InternalXtextGrammarTestLanguage.g:1689:3: rule__Grammar__DefinesHiddenTokensAssignment_3_0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1697:1: rule__Grammar__Group_3__1 : rule__Grammar__Group_3__1__Impl rule__Grammar__Group_3__2 ;
    public final void rule__Grammar__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1701:1: ( rule__Grammar__Group_3__1__Impl rule__Grammar__Group_3__2 )
            // InternalXtextGrammarTestLanguage.g:1702:2: rule__Grammar__Group_3__1__Impl rule__Grammar__Group_3__2
            {
            pushFollow(FOLLOW_10);
            rule__Grammar__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1709:1: rule__Grammar__Group_3__1__Impl : ( '(' ) ;
    public final void rule__Grammar__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1713:1: ( ( '(' ) )
            // InternalXtextGrammarTestLanguage.g:1714:1: ( '(' )
            {
            // InternalXtextGrammarTestLanguage.g:1714:1: ( '(' )
            // InternalXtextGrammarTestLanguage.g:1715:2: '('
            {
             before(grammarAccess.getGrammarAccess().getLeftParenthesisKeyword_3_1()); 
            match(input,20,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:1724:1: rule__Grammar__Group_3__2 : rule__Grammar__Group_3__2__Impl rule__Grammar__Group_3__3 ;
    public final void rule__Grammar__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1728:1: ( rule__Grammar__Group_3__2__Impl rule__Grammar__Group_3__3 )
            // InternalXtextGrammarTestLanguage.g:1729:2: rule__Grammar__Group_3__2__Impl rule__Grammar__Group_3__3
            {
            pushFollow(FOLLOW_10);
            rule__Grammar__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1736:1: rule__Grammar__Group_3__2__Impl : ( ( rule__Grammar__Group_3_2__0 )? ) ;
    public final void rule__Grammar__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1740:1: ( ( ( rule__Grammar__Group_3_2__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:1741:1: ( ( rule__Grammar__Group_3_2__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:1741:1: ( ( rule__Grammar__Group_3_2__0 )? )
            // InternalXtextGrammarTestLanguage.g:1742:2: ( rule__Grammar__Group_3_2__0 )?
            {
             before(grammarAccess.getGrammarAccess().getGroup_3_2()); 
            // InternalXtextGrammarTestLanguage.g:1743:2: ( rule__Grammar__Group_3_2__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ID) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1743:3: rule__Grammar__Group_3_2__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1751:1: rule__Grammar__Group_3__3 : rule__Grammar__Group_3__3__Impl ;
    public final void rule__Grammar__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1755:1: ( rule__Grammar__Group_3__3__Impl )
            // InternalXtextGrammarTestLanguage.g:1756:2: rule__Grammar__Group_3__3__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1762:1: rule__Grammar__Group_3__3__Impl : ( ')' ) ;
    public final void rule__Grammar__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1766:1: ( ( ')' ) )
            // InternalXtextGrammarTestLanguage.g:1767:1: ( ')' )
            {
            // InternalXtextGrammarTestLanguage.g:1767:1: ( ')' )
            // InternalXtextGrammarTestLanguage.g:1768:2: ')'
            {
             before(grammarAccess.getGrammarAccess().getRightParenthesisKeyword_3_3()); 
            match(input,21,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:1778:1: rule__Grammar__Group_3_2__0 : rule__Grammar__Group_3_2__0__Impl rule__Grammar__Group_3_2__1 ;
    public final void rule__Grammar__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1782:1: ( rule__Grammar__Group_3_2__0__Impl rule__Grammar__Group_3_2__1 )
            // InternalXtextGrammarTestLanguage.g:1783:2: rule__Grammar__Group_3_2__0__Impl rule__Grammar__Group_3_2__1
            {
            pushFollow(FOLLOW_7);
            rule__Grammar__Group_3_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1790:1: rule__Grammar__Group_3_2__0__Impl : ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) ) ;
    public final void rule__Grammar__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1794:1: ( ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:1795:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:1795:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) )
            // InternalXtextGrammarTestLanguage.g:1796:2: ( rule__Grammar__HiddenTokensAssignment_3_2_0 )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAssignment_3_2_0()); 
            // InternalXtextGrammarTestLanguage.g:1797:2: ( rule__Grammar__HiddenTokensAssignment_3_2_0 )
            // InternalXtextGrammarTestLanguage.g:1797:3: rule__Grammar__HiddenTokensAssignment_3_2_0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1805:1: rule__Grammar__Group_3_2__1 : rule__Grammar__Group_3_2__1__Impl ;
    public final void rule__Grammar__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1809:1: ( rule__Grammar__Group_3_2__1__Impl )
            // InternalXtextGrammarTestLanguage.g:1810:2: rule__Grammar__Group_3_2__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1816:1: rule__Grammar__Group_3_2__1__Impl : ( ( rule__Grammar__Group_3_2_1__0 )* ) ;
    public final void rule__Grammar__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1820:1: ( ( ( rule__Grammar__Group_3_2_1__0 )* ) )
            // InternalXtextGrammarTestLanguage.g:1821:1: ( ( rule__Grammar__Group_3_2_1__0 )* )
            {
            // InternalXtextGrammarTestLanguage.g:1821:1: ( ( rule__Grammar__Group_3_2_1__0 )* )
            // InternalXtextGrammarTestLanguage.g:1822:2: ( rule__Grammar__Group_3_2_1__0 )*
            {
             before(grammarAccess.getGrammarAccess().getGroup_3_2_1()); 
            // InternalXtextGrammarTestLanguage.g:1823:2: ( rule__Grammar__Group_3_2_1__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==19) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:1823:3: rule__Grammar__Group_3_2_1__0
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__Grammar__Group_3_2_1__0();

            	    state._fsp--;


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
    // $ANTLR end "rule__Grammar__Group_3_2__1__Impl"


    // $ANTLR start "rule__Grammar__Group_3_2_1__0"
    // InternalXtextGrammarTestLanguage.g:1832:1: rule__Grammar__Group_3_2_1__0 : rule__Grammar__Group_3_2_1__0__Impl rule__Grammar__Group_3_2_1__1 ;
    public final void rule__Grammar__Group_3_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1836:1: ( rule__Grammar__Group_3_2_1__0__Impl rule__Grammar__Group_3_2_1__1 )
            // InternalXtextGrammarTestLanguage.g:1837:2: rule__Grammar__Group_3_2_1__0__Impl rule__Grammar__Group_3_2_1__1
            {
            pushFollow(FOLLOW_3);
            rule__Grammar__Group_3_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1844:1: rule__Grammar__Group_3_2_1__0__Impl : ( ',' ) ;
    public final void rule__Grammar__Group_3_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1848:1: ( ( ',' ) )
            // InternalXtextGrammarTestLanguage.g:1849:1: ( ',' )
            {
            // InternalXtextGrammarTestLanguage.g:1849:1: ( ',' )
            // InternalXtextGrammarTestLanguage.g:1850:2: ','
            {
             before(grammarAccess.getGrammarAccess().getCommaKeyword_3_2_1_0()); 
            match(input,19,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:1859:1: rule__Grammar__Group_3_2_1__1 : rule__Grammar__Group_3_2_1__1__Impl ;
    public final void rule__Grammar__Group_3_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1863:1: ( rule__Grammar__Group_3_2_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:1864:2: rule__Grammar__Group_3_2_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1870:1: rule__Grammar__Group_3_2_1__1__Impl : ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) ) ;
    public final void rule__Grammar__Group_3_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1874:1: ( ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:1875:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:1875:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) )
            // InternalXtextGrammarTestLanguage.g:1876:2: ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAssignment_3_2_1_1()); 
            // InternalXtextGrammarTestLanguage.g:1877:2: ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 )
            // InternalXtextGrammarTestLanguage.g:1877:3: rule__Grammar__HiddenTokensAssignment_3_2_1_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1886:1: rule__GrammarID__Group__0 : rule__GrammarID__Group__0__Impl rule__GrammarID__Group__1 ;
    public final void rule__GrammarID__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1890:1: ( rule__GrammarID__Group__0__Impl rule__GrammarID__Group__1 )
            // InternalXtextGrammarTestLanguage.g:1891:2: rule__GrammarID__Group__0__Impl rule__GrammarID__Group__1
            {
            pushFollow(FOLLOW_11);
            rule__GrammarID__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1898:1: rule__GrammarID__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__GrammarID__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1902:1: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:1903:1: ( RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:1903:1: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:1904:2: RULE_ID
            {
             before(grammarAccess.getGrammarIDAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:1913:1: rule__GrammarID__Group__1 : rule__GrammarID__Group__1__Impl ;
    public final void rule__GrammarID__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1917:1: ( rule__GrammarID__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:1918:2: rule__GrammarID__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1924:1: rule__GrammarID__Group__1__Impl : ( ( rule__GrammarID__Group_1__0 )* ) ;
    public final void rule__GrammarID__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1928:1: ( ( ( rule__GrammarID__Group_1__0 )* ) )
            // InternalXtextGrammarTestLanguage.g:1929:1: ( ( rule__GrammarID__Group_1__0 )* )
            {
            // InternalXtextGrammarTestLanguage.g:1929:1: ( ( rule__GrammarID__Group_1__0 )* )
            // InternalXtextGrammarTestLanguage.g:1930:2: ( rule__GrammarID__Group_1__0 )*
            {
             before(grammarAccess.getGrammarIDAccess().getGroup_1()); 
            // InternalXtextGrammarTestLanguage.g:1931:2: ( rule__GrammarID__Group_1__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==22) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:1931:3: rule__GrammarID__Group_1__0
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__GrammarID__Group_1__0();

            	    state._fsp--;


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
    // $ANTLR end "rule__GrammarID__Group__1__Impl"


    // $ANTLR start "rule__GrammarID__Group_1__0"
    // InternalXtextGrammarTestLanguage.g:1940:1: rule__GrammarID__Group_1__0 : rule__GrammarID__Group_1__0__Impl rule__GrammarID__Group_1__1 ;
    public final void rule__GrammarID__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1944:1: ( rule__GrammarID__Group_1__0__Impl rule__GrammarID__Group_1__1 )
            // InternalXtextGrammarTestLanguage.g:1945:2: rule__GrammarID__Group_1__0__Impl rule__GrammarID__Group_1__1
            {
            pushFollow(FOLLOW_3);
            rule__GrammarID__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1952:1: rule__GrammarID__Group_1__0__Impl : ( '.' ) ;
    public final void rule__GrammarID__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1956:1: ( ( '.' ) )
            // InternalXtextGrammarTestLanguage.g:1957:1: ( '.' )
            {
            // InternalXtextGrammarTestLanguage.g:1957:1: ( '.' )
            // InternalXtextGrammarTestLanguage.g:1958:2: '.'
            {
             before(grammarAccess.getGrammarIDAccess().getFullStopKeyword_1_0()); 
            match(input,22,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:1967:1: rule__GrammarID__Group_1__1 : rule__GrammarID__Group_1__1__Impl ;
    public final void rule__GrammarID__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1971:1: ( rule__GrammarID__Group_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:1972:2: rule__GrammarID__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:1978:1: rule__GrammarID__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__GrammarID__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1982:1: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:1983:1: ( RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:1983:1: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:1984:2: RULE_ID
            {
             before(grammarAccess.getGrammarIDAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:1994:1: rule__GeneratedMetamodel__Group__0 : rule__GeneratedMetamodel__Group__0__Impl rule__GeneratedMetamodel__Group__1 ;
    public final void rule__GeneratedMetamodel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1998:1: ( rule__GeneratedMetamodel__Group__0__Impl rule__GeneratedMetamodel__Group__1 )
            // InternalXtextGrammarTestLanguage.g:1999:2: rule__GeneratedMetamodel__Group__0__Impl rule__GeneratedMetamodel__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__GeneratedMetamodel__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2006:1: rule__GeneratedMetamodel__Group__0__Impl : ( 'generate' ) ;
    public final void rule__GeneratedMetamodel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2010:1: ( ( 'generate' ) )
            // InternalXtextGrammarTestLanguage.g:2011:1: ( 'generate' )
            {
            // InternalXtextGrammarTestLanguage.g:2011:1: ( 'generate' )
            // InternalXtextGrammarTestLanguage.g:2012:2: 'generate'
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getGenerateKeyword_0()); 
            match(input,23,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:2021:1: rule__GeneratedMetamodel__Group__1 : rule__GeneratedMetamodel__Group__1__Impl rule__GeneratedMetamodel__Group__2 ;
    public final void rule__GeneratedMetamodel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2025:1: ( rule__GeneratedMetamodel__Group__1__Impl rule__GeneratedMetamodel__Group__2 )
            // InternalXtextGrammarTestLanguage.g:2026:2: rule__GeneratedMetamodel__Group__1__Impl rule__GeneratedMetamodel__Group__2
            {
            pushFollow(FOLLOW_13);
            rule__GeneratedMetamodel__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2033:1: rule__GeneratedMetamodel__Group__1__Impl : ( ( rule__GeneratedMetamodel__NameAssignment_1 ) ) ;
    public final void rule__GeneratedMetamodel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2037:1: ( ( ( rule__GeneratedMetamodel__NameAssignment_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:2038:1: ( ( rule__GeneratedMetamodel__NameAssignment_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2038:1: ( ( rule__GeneratedMetamodel__NameAssignment_1 ) )
            // InternalXtextGrammarTestLanguage.g:2039:2: ( rule__GeneratedMetamodel__NameAssignment_1 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getNameAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:2040:2: ( rule__GeneratedMetamodel__NameAssignment_1 )
            // InternalXtextGrammarTestLanguage.g:2040:3: rule__GeneratedMetamodel__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2048:1: rule__GeneratedMetamodel__Group__2 : rule__GeneratedMetamodel__Group__2__Impl rule__GeneratedMetamodel__Group__3 ;
    public final void rule__GeneratedMetamodel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2052:1: ( rule__GeneratedMetamodel__Group__2__Impl rule__GeneratedMetamodel__Group__3 )
            // InternalXtextGrammarTestLanguage.g:2053:2: rule__GeneratedMetamodel__Group__2__Impl rule__GeneratedMetamodel__Group__3
            {
            pushFollow(FOLLOW_14);
            rule__GeneratedMetamodel__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2060:1: rule__GeneratedMetamodel__Group__2__Impl : ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) ) ;
    public final void rule__GeneratedMetamodel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2064:1: ( ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) ) )
            // InternalXtextGrammarTestLanguage.g:2065:1: ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2065:1: ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) )
            // InternalXtextGrammarTestLanguage.g:2066:2: ( rule__GeneratedMetamodel__EPackageAssignment_2 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getEPackageAssignment_2()); 
            // InternalXtextGrammarTestLanguage.g:2067:2: ( rule__GeneratedMetamodel__EPackageAssignment_2 )
            // InternalXtextGrammarTestLanguage.g:2067:3: rule__GeneratedMetamodel__EPackageAssignment_2
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2075:1: rule__GeneratedMetamodel__Group__3 : rule__GeneratedMetamodel__Group__3__Impl ;
    public final void rule__GeneratedMetamodel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2079:1: ( rule__GeneratedMetamodel__Group__3__Impl )
            // InternalXtextGrammarTestLanguage.g:2080:2: rule__GeneratedMetamodel__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2086:1: rule__GeneratedMetamodel__Group__3__Impl : ( ( rule__GeneratedMetamodel__Group_3__0 )? ) ;
    public final void rule__GeneratedMetamodel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2090:1: ( ( ( rule__GeneratedMetamodel__Group_3__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:2091:1: ( ( rule__GeneratedMetamodel__Group_3__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:2091:1: ( ( rule__GeneratedMetamodel__Group_3__0 )? )
            // InternalXtextGrammarTestLanguage.g:2092:2: ( rule__GeneratedMetamodel__Group_3__0 )?
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getGroup_3()); 
            // InternalXtextGrammarTestLanguage.g:2093:2: ( rule__GeneratedMetamodel__Group_3__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==24) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:2093:3: rule__GeneratedMetamodel__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2102:1: rule__GeneratedMetamodel__Group_3__0 : rule__GeneratedMetamodel__Group_3__0__Impl rule__GeneratedMetamodel__Group_3__1 ;
    public final void rule__GeneratedMetamodel__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2106:1: ( rule__GeneratedMetamodel__Group_3__0__Impl rule__GeneratedMetamodel__Group_3__1 )
            // InternalXtextGrammarTestLanguage.g:2107:2: rule__GeneratedMetamodel__Group_3__0__Impl rule__GeneratedMetamodel__Group_3__1
            {
            pushFollow(FOLLOW_3);
            rule__GeneratedMetamodel__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2114:1: rule__GeneratedMetamodel__Group_3__0__Impl : ( 'as' ) ;
    public final void rule__GeneratedMetamodel__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2118:1: ( ( 'as' ) )
            // InternalXtextGrammarTestLanguage.g:2119:1: ( 'as' )
            {
            // InternalXtextGrammarTestLanguage.g:2119:1: ( 'as' )
            // InternalXtextGrammarTestLanguage.g:2120:2: 'as'
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getAsKeyword_3_0()); 
            match(input,24,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:2129:1: rule__GeneratedMetamodel__Group_3__1 : rule__GeneratedMetamodel__Group_3__1__Impl ;
    public final void rule__GeneratedMetamodel__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2133:1: ( rule__GeneratedMetamodel__Group_3__1__Impl )
            // InternalXtextGrammarTestLanguage.g:2134:2: rule__GeneratedMetamodel__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2140:1: rule__GeneratedMetamodel__Group_3__1__Impl : ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) ) ;
    public final void rule__GeneratedMetamodel__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2144:1: ( ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:2145:1: ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2145:1: ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) )
            // InternalXtextGrammarTestLanguage.g:2146:2: ( rule__GeneratedMetamodel__AliasAssignment_3_1 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getAliasAssignment_3_1()); 
            // InternalXtextGrammarTestLanguage.g:2147:2: ( rule__GeneratedMetamodel__AliasAssignment_3_1 )
            // InternalXtextGrammarTestLanguage.g:2147:3: rule__GeneratedMetamodel__AliasAssignment_3_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2156:1: rule__ReferencedMetamodel__Group__0 : rule__ReferencedMetamodel__Group__0__Impl rule__ReferencedMetamodel__Group__1 ;
    public final void rule__ReferencedMetamodel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2160:1: ( rule__ReferencedMetamodel__Group__0__Impl rule__ReferencedMetamodel__Group__1 )
            // InternalXtextGrammarTestLanguage.g:2161:2: rule__ReferencedMetamodel__Group__0__Impl rule__ReferencedMetamodel__Group__1
            {
            pushFollow(FOLLOW_13);
            rule__ReferencedMetamodel__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2168:1: rule__ReferencedMetamodel__Group__0__Impl : ( 'import' ) ;
    public final void rule__ReferencedMetamodel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2172:1: ( ( 'import' ) )
            // InternalXtextGrammarTestLanguage.g:2173:1: ( 'import' )
            {
            // InternalXtextGrammarTestLanguage.g:2173:1: ( 'import' )
            // InternalXtextGrammarTestLanguage.g:2174:2: 'import'
            {
             before(grammarAccess.getReferencedMetamodelAccess().getImportKeyword_0()); 
            match(input,25,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:2183:1: rule__ReferencedMetamodel__Group__1 : rule__ReferencedMetamodel__Group__1__Impl rule__ReferencedMetamodel__Group__2 ;
    public final void rule__ReferencedMetamodel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2187:1: ( rule__ReferencedMetamodel__Group__1__Impl rule__ReferencedMetamodel__Group__2 )
            // InternalXtextGrammarTestLanguage.g:2188:2: rule__ReferencedMetamodel__Group__1__Impl rule__ReferencedMetamodel__Group__2
            {
            pushFollow(FOLLOW_14);
            rule__ReferencedMetamodel__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2195:1: rule__ReferencedMetamodel__Group__1__Impl : ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) ) ;
    public final void rule__ReferencedMetamodel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2199:1: ( ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:2200:1: ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2200:1: ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) )
            // InternalXtextGrammarTestLanguage.g:2201:2: ( rule__ReferencedMetamodel__EPackageAssignment_1 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:2202:2: ( rule__ReferencedMetamodel__EPackageAssignment_1 )
            // InternalXtextGrammarTestLanguage.g:2202:3: rule__ReferencedMetamodel__EPackageAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2210:1: rule__ReferencedMetamodel__Group__2 : rule__ReferencedMetamodel__Group__2__Impl ;
    public final void rule__ReferencedMetamodel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2214:1: ( rule__ReferencedMetamodel__Group__2__Impl )
            // InternalXtextGrammarTestLanguage.g:2215:2: rule__ReferencedMetamodel__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2221:1: rule__ReferencedMetamodel__Group__2__Impl : ( ( rule__ReferencedMetamodel__Group_2__0 )? ) ;
    public final void rule__ReferencedMetamodel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2225:1: ( ( ( rule__ReferencedMetamodel__Group_2__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:2226:1: ( ( rule__ReferencedMetamodel__Group_2__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:2226:1: ( ( rule__ReferencedMetamodel__Group_2__0 )? )
            // InternalXtextGrammarTestLanguage.g:2227:2: ( rule__ReferencedMetamodel__Group_2__0 )?
            {
             before(grammarAccess.getReferencedMetamodelAccess().getGroup_2()); 
            // InternalXtextGrammarTestLanguage.g:2228:2: ( rule__ReferencedMetamodel__Group_2__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==24) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:2228:3: rule__ReferencedMetamodel__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2237:1: rule__ReferencedMetamodel__Group_2__0 : rule__ReferencedMetamodel__Group_2__0__Impl rule__ReferencedMetamodel__Group_2__1 ;
    public final void rule__ReferencedMetamodel__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2241:1: ( rule__ReferencedMetamodel__Group_2__0__Impl rule__ReferencedMetamodel__Group_2__1 )
            // InternalXtextGrammarTestLanguage.g:2242:2: rule__ReferencedMetamodel__Group_2__0__Impl rule__ReferencedMetamodel__Group_2__1
            {
            pushFollow(FOLLOW_3);
            rule__ReferencedMetamodel__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2249:1: rule__ReferencedMetamodel__Group_2__0__Impl : ( 'as' ) ;
    public final void rule__ReferencedMetamodel__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2253:1: ( ( 'as' ) )
            // InternalXtextGrammarTestLanguage.g:2254:1: ( 'as' )
            {
            // InternalXtextGrammarTestLanguage.g:2254:1: ( 'as' )
            // InternalXtextGrammarTestLanguage.g:2255:2: 'as'
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAsKeyword_2_0()); 
            match(input,24,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:2264:1: rule__ReferencedMetamodel__Group_2__1 : rule__ReferencedMetamodel__Group_2__1__Impl ;
    public final void rule__ReferencedMetamodel__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2268:1: ( rule__ReferencedMetamodel__Group_2__1__Impl )
            // InternalXtextGrammarTestLanguage.g:2269:2: rule__ReferencedMetamodel__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2275:1: rule__ReferencedMetamodel__Group_2__1__Impl : ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) ) ;
    public final void rule__ReferencedMetamodel__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2279:1: ( ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:2280:1: ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2280:1: ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) )
            // InternalXtextGrammarTestLanguage.g:2281:2: ( rule__ReferencedMetamodel__AliasAssignment_2_1 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAliasAssignment_2_1()); 
            // InternalXtextGrammarTestLanguage.g:2282:2: ( rule__ReferencedMetamodel__AliasAssignment_2_1 )
            // InternalXtextGrammarTestLanguage.g:2282:3: rule__ReferencedMetamodel__AliasAssignment_2_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2291:1: rule__ParserRule__Group__0 : rule__ParserRule__Group__0__Impl rule__ParserRule__Group__1 ;
    public final void rule__ParserRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2295:1: ( rule__ParserRule__Group__0__Impl rule__ParserRule__Group__1 )
            // InternalXtextGrammarTestLanguage.g:2296:2: rule__ParserRule__Group__0__Impl rule__ParserRule__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__ParserRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2303:1: rule__ParserRule__Group__0__Impl : ( ( rule__ParserRule__NameAssignment_0 ) ) ;
    public final void rule__ParserRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2307:1: ( ( ( rule__ParserRule__NameAssignment_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:2308:1: ( ( rule__ParserRule__NameAssignment_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2308:1: ( ( rule__ParserRule__NameAssignment_0 ) )
            // InternalXtextGrammarTestLanguage.g:2309:2: ( rule__ParserRule__NameAssignment_0 )
            {
             before(grammarAccess.getParserRuleAccess().getNameAssignment_0()); 
            // InternalXtextGrammarTestLanguage.g:2310:2: ( rule__ParserRule__NameAssignment_0 )
            // InternalXtextGrammarTestLanguage.g:2310:3: rule__ParserRule__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2318:1: rule__ParserRule__Group__1 : rule__ParserRule__Group__1__Impl rule__ParserRule__Group__2 ;
    public final void rule__ParserRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2322:1: ( rule__ParserRule__Group__1__Impl rule__ParserRule__Group__2 )
            // InternalXtextGrammarTestLanguage.g:2323:2: rule__ParserRule__Group__1__Impl rule__ParserRule__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__ParserRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2330:1: rule__ParserRule__Group__1__Impl : ( ( rule__ParserRule__Group_1__0 )? ) ;
    public final void rule__ParserRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2334:1: ( ( ( rule__ParserRule__Group_1__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:2335:1: ( ( rule__ParserRule__Group_1__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:2335:1: ( ( rule__ParserRule__Group_1__0 )? )
            // InternalXtextGrammarTestLanguage.g:2336:2: ( rule__ParserRule__Group_1__0 )?
            {
             before(grammarAccess.getParserRuleAccess().getGroup_1()); 
            // InternalXtextGrammarTestLanguage.g:2337:2: ( rule__ParserRule__Group_1__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==28) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:2337:3: rule__ParserRule__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2345:1: rule__ParserRule__Group__2 : rule__ParserRule__Group__2__Impl rule__ParserRule__Group__3 ;
    public final void rule__ParserRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2349:1: ( rule__ParserRule__Group__2__Impl rule__ParserRule__Group__3 )
            // InternalXtextGrammarTestLanguage.g:2350:2: rule__ParserRule__Group__2__Impl rule__ParserRule__Group__3
            {
            pushFollow(FOLLOW_15);
            rule__ParserRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2357:1: rule__ParserRule__Group__2__Impl : ( ( rule__ParserRule__Group_2__0 )? ) ;
    public final void rule__ParserRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2361:1: ( ( ( rule__ParserRule__Group_2__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:2362:1: ( ( rule__ParserRule__Group_2__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:2362:1: ( ( rule__ParserRule__Group_2__0 )? )
            // InternalXtextGrammarTestLanguage.g:2363:2: ( rule__ParserRule__Group_2__0 )?
            {
             before(grammarAccess.getParserRuleAccess().getGroup_2()); 
            // InternalXtextGrammarTestLanguage.g:2364:2: ( rule__ParserRule__Group_2__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==41) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:2364:3: rule__ParserRule__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2372:1: rule__ParserRule__Group__3 : rule__ParserRule__Group__3__Impl rule__ParserRule__Group__4 ;
    public final void rule__ParserRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2376:1: ( rule__ParserRule__Group__3__Impl rule__ParserRule__Group__4 )
            // InternalXtextGrammarTestLanguage.g:2377:2: rule__ParserRule__Group__3__Impl rule__ParserRule__Group__4
            {
            pushFollow(FOLLOW_16);
            rule__ParserRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2384:1: rule__ParserRule__Group__3__Impl : ( ':' ) ;
    public final void rule__ParserRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2388:1: ( ( ':' ) )
            // InternalXtextGrammarTestLanguage.g:2389:1: ( ':' )
            {
            // InternalXtextGrammarTestLanguage.g:2389:1: ( ':' )
            // InternalXtextGrammarTestLanguage.g:2390:2: ':'
            {
             before(grammarAccess.getParserRuleAccess().getColonKeyword_3()); 
            match(input,26,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:2399:1: rule__ParserRule__Group__4 : rule__ParserRule__Group__4__Impl rule__ParserRule__Group__5 ;
    public final void rule__ParserRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2403:1: ( rule__ParserRule__Group__4__Impl rule__ParserRule__Group__5 )
            // InternalXtextGrammarTestLanguage.g:2404:2: rule__ParserRule__Group__4__Impl rule__ParserRule__Group__5
            {
            pushFollow(FOLLOW_17);
            rule__ParserRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2411:1: rule__ParserRule__Group__4__Impl : ( ( rule__ParserRule__AlternativesAssignment_4 ) ) ;
    public final void rule__ParserRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2415:1: ( ( ( rule__ParserRule__AlternativesAssignment_4 ) ) )
            // InternalXtextGrammarTestLanguage.g:2416:1: ( ( rule__ParserRule__AlternativesAssignment_4 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2416:1: ( ( rule__ParserRule__AlternativesAssignment_4 ) )
            // InternalXtextGrammarTestLanguage.g:2417:2: ( rule__ParserRule__AlternativesAssignment_4 )
            {
             before(grammarAccess.getParserRuleAccess().getAlternativesAssignment_4()); 
            // InternalXtextGrammarTestLanguage.g:2418:2: ( rule__ParserRule__AlternativesAssignment_4 )
            // InternalXtextGrammarTestLanguage.g:2418:3: rule__ParserRule__AlternativesAssignment_4
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2426:1: rule__ParserRule__Group__5 : rule__ParserRule__Group__5__Impl ;
    public final void rule__ParserRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2430:1: ( rule__ParserRule__Group__5__Impl )
            // InternalXtextGrammarTestLanguage.g:2431:2: rule__ParserRule__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2437:1: rule__ParserRule__Group__5__Impl : ( ';' ) ;
    public final void rule__ParserRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2441:1: ( ( ';' ) )
            // InternalXtextGrammarTestLanguage.g:2442:1: ( ';' )
            {
            // InternalXtextGrammarTestLanguage.g:2442:1: ( ';' )
            // InternalXtextGrammarTestLanguage.g:2443:2: ';'
            {
             before(grammarAccess.getParserRuleAccess().getSemicolonKeyword_5()); 
            match(input,27,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:2453:1: rule__ParserRule__Group_1__0 : rule__ParserRule__Group_1__0__Impl rule__ParserRule__Group_1__1 ;
    public final void rule__ParserRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2457:1: ( rule__ParserRule__Group_1__0__Impl rule__ParserRule__Group_1__1 )
            // InternalXtextGrammarTestLanguage.g:2458:2: rule__ParserRule__Group_1__0__Impl rule__ParserRule__Group_1__1
            {
            pushFollow(FOLLOW_3);
            rule__ParserRule__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2465:1: rule__ParserRule__Group_1__0__Impl : ( 'returns' ) ;
    public final void rule__ParserRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2469:1: ( ( 'returns' ) )
            // InternalXtextGrammarTestLanguage.g:2470:1: ( 'returns' )
            {
            // InternalXtextGrammarTestLanguage.g:2470:1: ( 'returns' )
            // InternalXtextGrammarTestLanguage.g:2471:2: 'returns'
            {
             before(grammarAccess.getParserRuleAccess().getReturnsKeyword_1_0()); 
            match(input,28,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:2480:1: rule__ParserRule__Group_1__1 : rule__ParserRule__Group_1__1__Impl ;
    public final void rule__ParserRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2484:1: ( rule__ParserRule__Group_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:2485:2: rule__ParserRule__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2491:1: rule__ParserRule__Group_1__1__Impl : ( ( rule__ParserRule__TypeAssignment_1_1 ) ) ;
    public final void rule__ParserRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2495:1: ( ( ( rule__ParserRule__TypeAssignment_1_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:2496:1: ( ( rule__ParserRule__TypeAssignment_1_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2496:1: ( ( rule__ParserRule__TypeAssignment_1_1 ) )
            // InternalXtextGrammarTestLanguage.g:2497:2: ( rule__ParserRule__TypeAssignment_1_1 )
            {
             before(grammarAccess.getParserRuleAccess().getTypeAssignment_1_1()); 
            // InternalXtextGrammarTestLanguage.g:2498:2: ( rule__ParserRule__TypeAssignment_1_1 )
            // InternalXtextGrammarTestLanguage.g:2498:3: rule__ParserRule__TypeAssignment_1_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2507:1: rule__ParserRule__Group_2__0 : rule__ParserRule__Group_2__0__Impl rule__ParserRule__Group_2__1 ;
    public final void rule__ParserRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2511:1: ( rule__ParserRule__Group_2__0__Impl rule__ParserRule__Group_2__1 )
            // InternalXtextGrammarTestLanguage.g:2512:2: rule__ParserRule__Group_2__0__Impl rule__ParserRule__Group_2__1
            {
            pushFollow(FOLLOW_9);
            rule__ParserRule__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2519:1: rule__ParserRule__Group_2__0__Impl : ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) ) ;
    public final void rule__ParserRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2523:1: ( ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:2524:1: ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2524:1: ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) )
            // InternalXtextGrammarTestLanguage.g:2525:2: ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 )
            {
             before(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensAssignment_2_0()); 
            // InternalXtextGrammarTestLanguage.g:2526:2: ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 )
            // InternalXtextGrammarTestLanguage.g:2526:3: rule__ParserRule__DefinesHiddenTokensAssignment_2_0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2534:1: rule__ParserRule__Group_2__1 : rule__ParserRule__Group_2__1__Impl rule__ParserRule__Group_2__2 ;
    public final void rule__ParserRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2538:1: ( rule__ParserRule__Group_2__1__Impl rule__ParserRule__Group_2__2 )
            // InternalXtextGrammarTestLanguage.g:2539:2: rule__ParserRule__Group_2__1__Impl rule__ParserRule__Group_2__2
            {
            pushFollow(FOLLOW_10);
            rule__ParserRule__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2546:1: rule__ParserRule__Group_2__1__Impl : ( '(' ) ;
    public final void rule__ParserRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2550:1: ( ( '(' ) )
            // InternalXtextGrammarTestLanguage.g:2551:1: ( '(' )
            {
            // InternalXtextGrammarTestLanguage.g:2551:1: ( '(' )
            // InternalXtextGrammarTestLanguage.g:2552:2: '('
            {
             before(grammarAccess.getParserRuleAccess().getLeftParenthesisKeyword_2_1()); 
            match(input,20,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:2561:1: rule__ParserRule__Group_2__2 : rule__ParserRule__Group_2__2__Impl rule__ParserRule__Group_2__3 ;
    public final void rule__ParserRule__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2565:1: ( rule__ParserRule__Group_2__2__Impl rule__ParserRule__Group_2__3 )
            // InternalXtextGrammarTestLanguage.g:2566:2: rule__ParserRule__Group_2__2__Impl rule__ParserRule__Group_2__3
            {
            pushFollow(FOLLOW_10);
            rule__ParserRule__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2573:1: rule__ParserRule__Group_2__2__Impl : ( ( rule__ParserRule__Group_2_2__0 )? ) ;
    public final void rule__ParserRule__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2577:1: ( ( ( rule__ParserRule__Group_2_2__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:2578:1: ( ( rule__ParserRule__Group_2_2__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:2578:1: ( ( rule__ParserRule__Group_2_2__0 )? )
            // InternalXtextGrammarTestLanguage.g:2579:2: ( rule__ParserRule__Group_2_2__0 )?
            {
             before(grammarAccess.getParserRuleAccess().getGroup_2_2()); 
            // InternalXtextGrammarTestLanguage.g:2580:2: ( rule__ParserRule__Group_2_2__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_ID) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:2580:3: rule__ParserRule__Group_2_2__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2588:1: rule__ParserRule__Group_2__3 : rule__ParserRule__Group_2__3__Impl ;
    public final void rule__ParserRule__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2592:1: ( rule__ParserRule__Group_2__3__Impl )
            // InternalXtextGrammarTestLanguage.g:2593:2: rule__ParserRule__Group_2__3__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2599:1: rule__ParserRule__Group_2__3__Impl : ( ')' ) ;
    public final void rule__ParserRule__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2603:1: ( ( ')' ) )
            // InternalXtextGrammarTestLanguage.g:2604:1: ( ')' )
            {
            // InternalXtextGrammarTestLanguage.g:2604:1: ( ')' )
            // InternalXtextGrammarTestLanguage.g:2605:2: ')'
            {
             before(grammarAccess.getParserRuleAccess().getRightParenthesisKeyword_2_3()); 
            match(input,21,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:2615:1: rule__ParserRule__Group_2_2__0 : rule__ParserRule__Group_2_2__0__Impl rule__ParserRule__Group_2_2__1 ;
    public final void rule__ParserRule__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2619:1: ( rule__ParserRule__Group_2_2__0__Impl rule__ParserRule__Group_2_2__1 )
            // InternalXtextGrammarTestLanguage.g:2620:2: rule__ParserRule__Group_2_2__0__Impl rule__ParserRule__Group_2_2__1
            {
            pushFollow(FOLLOW_7);
            rule__ParserRule__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2627:1: rule__ParserRule__Group_2_2__0__Impl : ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) ) ;
    public final void rule__ParserRule__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2631:1: ( ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:2632:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2632:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) )
            // InternalXtextGrammarTestLanguage.g:2633:2: ( rule__ParserRule__HiddenTokensAssignment_2_2_0 )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_2_2_0()); 
            // InternalXtextGrammarTestLanguage.g:2634:2: ( rule__ParserRule__HiddenTokensAssignment_2_2_0 )
            // InternalXtextGrammarTestLanguage.g:2634:3: rule__ParserRule__HiddenTokensAssignment_2_2_0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2642:1: rule__ParserRule__Group_2_2__1 : rule__ParserRule__Group_2_2__1__Impl ;
    public final void rule__ParserRule__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2646:1: ( rule__ParserRule__Group_2_2__1__Impl )
            // InternalXtextGrammarTestLanguage.g:2647:2: rule__ParserRule__Group_2_2__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2653:1: rule__ParserRule__Group_2_2__1__Impl : ( ( rule__ParserRule__Group_2_2_1__0 )* ) ;
    public final void rule__ParserRule__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2657:1: ( ( ( rule__ParserRule__Group_2_2_1__0 )* ) )
            // InternalXtextGrammarTestLanguage.g:2658:1: ( ( rule__ParserRule__Group_2_2_1__0 )* )
            {
            // InternalXtextGrammarTestLanguage.g:2658:1: ( ( rule__ParserRule__Group_2_2_1__0 )* )
            // InternalXtextGrammarTestLanguage.g:2659:2: ( rule__ParserRule__Group_2_2_1__0 )*
            {
             before(grammarAccess.getParserRuleAccess().getGroup_2_2_1()); 
            // InternalXtextGrammarTestLanguage.g:2660:2: ( rule__ParserRule__Group_2_2_1__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==19) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:2660:3: rule__ParserRule__Group_2_2_1__0
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__ParserRule__Group_2_2_1__0();

            	    state._fsp--;


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
    // $ANTLR end "rule__ParserRule__Group_2_2__1__Impl"


    // $ANTLR start "rule__ParserRule__Group_2_2_1__0"
    // InternalXtextGrammarTestLanguage.g:2669:1: rule__ParserRule__Group_2_2_1__0 : rule__ParserRule__Group_2_2_1__0__Impl rule__ParserRule__Group_2_2_1__1 ;
    public final void rule__ParserRule__Group_2_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2673:1: ( rule__ParserRule__Group_2_2_1__0__Impl rule__ParserRule__Group_2_2_1__1 )
            // InternalXtextGrammarTestLanguage.g:2674:2: rule__ParserRule__Group_2_2_1__0__Impl rule__ParserRule__Group_2_2_1__1
            {
            pushFollow(FOLLOW_3);
            rule__ParserRule__Group_2_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2681:1: rule__ParserRule__Group_2_2_1__0__Impl : ( ',' ) ;
    public final void rule__ParserRule__Group_2_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2685:1: ( ( ',' ) )
            // InternalXtextGrammarTestLanguage.g:2686:1: ( ',' )
            {
            // InternalXtextGrammarTestLanguage.g:2686:1: ( ',' )
            // InternalXtextGrammarTestLanguage.g:2687:2: ','
            {
             before(grammarAccess.getParserRuleAccess().getCommaKeyword_2_2_1_0()); 
            match(input,19,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:2696:1: rule__ParserRule__Group_2_2_1__1 : rule__ParserRule__Group_2_2_1__1__Impl ;
    public final void rule__ParserRule__Group_2_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2700:1: ( rule__ParserRule__Group_2_2_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:2701:2: rule__ParserRule__Group_2_2_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2707:1: rule__ParserRule__Group_2_2_1__1__Impl : ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) ) ;
    public final void rule__ParserRule__Group_2_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2711:1: ( ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:2712:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2712:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) )
            // InternalXtextGrammarTestLanguage.g:2713:2: ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_2_2_1_1()); 
            // InternalXtextGrammarTestLanguage.g:2714:2: ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 )
            // InternalXtextGrammarTestLanguage.g:2714:3: rule__ParserRule__HiddenTokensAssignment_2_2_1_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2723:1: rule__TypeRef__Group__0 : rule__TypeRef__Group__0__Impl rule__TypeRef__Group__1 ;
    public final void rule__TypeRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2727:1: ( rule__TypeRef__Group__0__Impl rule__TypeRef__Group__1 )
            // InternalXtextGrammarTestLanguage.g:2728:2: rule__TypeRef__Group__0__Impl rule__TypeRef__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__TypeRef__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2735:1: rule__TypeRef__Group__0__Impl : ( ( rule__TypeRef__Group_0__0 )? ) ;
    public final void rule__TypeRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2739:1: ( ( ( rule__TypeRef__Group_0__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:2740:1: ( ( rule__TypeRef__Group_0__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:2740:1: ( ( rule__TypeRef__Group_0__0 )? )
            // InternalXtextGrammarTestLanguage.g:2741:2: ( rule__TypeRef__Group_0__0 )?
            {
             before(grammarAccess.getTypeRefAccess().getGroup_0()); 
            // InternalXtextGrammarTestLanguage.g:2742:2: ( rule__TypeRef__Group_0__0 )?
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
                    // InternalXtextGrammarTestLanguage.g:2742:3: rule__TypeRef__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2750:1: rule__TypeRef__Group__1 : rule__TypeRef__Group__1__Impl ;
    public final void rule__TypeRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2754:1: ( rule__TypeRef__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:2755:2: rule__TypeRef__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2761:1: rule__TypeRef__Group__1__Impl : ( ( rule__TypeRef__ClassifierAssignment_1 ) ) ;
    public final void rule__TypeRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2765:1: ( ( ( rule__TypeRef__ClassifierAssignment_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:2766:1: ( ( rule__TypeRef__ClassifierAssignment_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2766:1: ( ( rule__TypeRef__ClassifierAssignment_1 ) )
            // InternalXtextGrammarTestLanguage.g:2767:2: ( rule__TypeRef__ClassifierAssignment_1 )
            {
             before(grammarAccess.getTypeRefAccess().getClassifierAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:2768:2: ( rule__TypeRef__ClassifierAssignment_1 )
            // InternalXtextGrammarTestLanguage.g:2768:3: rule__TypeRef__ClassifierAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2777:1: rule__TypeRef__Group_0__0 : rule__TypeRef__Group_0__0__Impl rule__TypeRef__Group_0__1 ;
    public final void rule__TypeRef__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2781:1: ( rule__TypeRef__Group_0__0__Impl rule__TypeRef__Group_0__1 )
            // InternalXtextGrammarTestLanguage.g:2782:2: rule__TypeRef__Group_0__0__Impl rule__TypeRef__Group_0__1
            {
            pushFollow(FOLLOW_18);
            rule__TypeRef__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2789:1: rule__TypeRef__Group_0__0__Impl : ( ( rule__TypeRef__MetamodelAssignment_0_0 ) ) ;
    public final void rule__TypeRef__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2793:1: ( ( ( rule__TypeRef__MetamodelAssignment_0_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:2794:1: ( ( rule__TypeRef__MetamodelAssignment_0_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2794:1: ( ( rule__TypeRef__MetamodelAssignment_0_0 ) )
            // InternalXtextGrammarTestLanguage.g:2795:2: ( rule__TypeRef__MetamodelAssignment_0_0 )
            {
             before(grammarAccess.getTypeRefAccess().getMetamodelAssignment_0_0()); 
            // InternalXtextGrammarTestLanguage.g:2796:2: ( rule__TypeRef__MetamodelAssignment_0_0 )
            // InternalXtextGrammarTestLanguage.g:2796:3: rule__TypeRef__MetamodelAssignment_0_0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2804:1: rule__TypeRef__Group_0__1 : rule__TypeRef__Group_0__1__Impl ;
    public final void rule__TypeRef__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2808:1: ( rule__TypeRef__Group_0__1__Impl )
            // InternalXtextGrammarTestLanguage.g:2809:2: rule__TypeRef__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2815:1: rule__TypeRef__Group_0__1__Impl : ( '::' ) ;
    public final void rule__TypeRef__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2819:1: ( ( '::' ) )
            // InternalXtextGrammarTestLanguage.g:2820:1: ( '::' )
            {
            // InternalXtextGrammarTestLanguage.g:2820:1: ( '::' )
            // InternalXtextGrammarTestLanguage.g:2821:2: '::'
            {
             before(grammarAccess.getTypeRefAccess().getColonColonKeyword_0_1()); 
            match(input,29,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:2831:1: rule__Alternatives__Group__0 : rule__Alternatives__Group__0__Impl rule__Alternatives__Group__1 ;
    public final void rule__Alternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2835:1: ( rule__Alternatives__Group__0__Impl rule__Alternatives__Group__1 )
            // InternalXtextGrammarTestLanguage.g:2836:2: rule__Alternatives__Group__0__Impl rule__Alternatives__Group__1
            {
            pushFollow(FOLLOW_19);
            rule__Alternatives__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2843:1: rule__Alternatives__Group__0__Impl : ( ruleGroup ) ;
    public final void rule__Alternatives__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2847:1: ( ( ruleGroup ) )
            // InternalXtextGrammarTestLanguage.g:2848:1: ( ruleGroup )
            {
            // InternalXtextGrammarTestLanguage.g:2848:1: ( ruleGroup )
            // InternalXtextGrammarTestLanguage.g:2849:2: ruleGroup
            {
             before(grammarAccess.getAlternativesAccess().getGroupParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleGroup();

            state._fsp--;

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
    // $ANTLR end "rule__Alternatives__Group__0__Impl"


    // $ANTLR start "rule__Alternatives__Group__1"
    // InternalXtextGrammarTestLanguage.g:2858:1: rule__Alternatives__Group__1 : rule__Alternatives__Group__1__Impl ;
    public final void rule__Alternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2862:1: ( rule__Alternatives__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:2863:2: rule__Alternatives__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2869:1: rule__Alternatives__Group__1__Impl : ( ( rule__Alternatives__Group_1__0 )? ) ;
    public final void rule__Alternatives__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2873:1: ( ( ( rule__Alternatives__Group_1__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:2874:1: ( ( rule__Alternatives__Group_1__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:2874:1: ( ( rule__Alternatives__Group_1__0 )? )
            // InternalXtextGrammarTestLanguage.g:2875:2: ( rule__Alternatives__Group_1__0 )?
            {
             before(grammarAccess.getAlternativesAccess().getGroup_1()); 
            // InternalXtextGrammarTestLanguage.g:2876:2: ( rule__Alternatives__Group_1__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==30) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:2876:3: rule__Alternatives__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2885:1: rule__Alternatives__Group_1__0 : rule__Alternatives__Group_1__0__Impl rule__Alternatives__Group_1__1 ;
    public final void rule__Alternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2889:1: ( rule__Alternatives__Group_1__0__Impl rule__Alternatives__Group_1__1 )
            // InternalXtextGrammarTestLanguage.g:2890:2: rule__Alternatives__Group_1__0__Impl rule__Alternatives__Group_1__1
            {
            pushFollow(FOLLOW_19);
            rule__Alternatives__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2897:1: rule__Alternatives__Group_1__0__Impl : ( () ) ;
    public final void rule__Alternatives__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2901:1: ( ( () ) )
            // InternalXtextGrammarTestLanguage.g:2902:1: ( () )
            {
            // InternalXtextGrammarTestLanguage.g:2902:1: ( () )
            // InternalXtextGrammarTestLanguage.g:2903:2: ()
            {
             before(grammarAccess.getAlternativesAccess().getAlternativesGroupsAction_1_0()); 
            // InternalXtextGrammarTestLanguage.g:2904:2: ()
            // InternalXtextGrammarTestLanguage.g:2904:3: 
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
    // $ANTLR end "rule__Alternatives__Group_1__0__Impl"


    // $ANTLR start "rule__Alternatives__Group_1__1"
    // InternalXtextGrammarTestLanguage.g:2912:1: rule__Alternatives__Group_1__1 : rule__Alternatives__Group_1__1__Impl ;
    public final void rule__Alternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2916:1: ( rule__Alternatives__Group_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:2917:2: rule__Alternatives__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2923:1: rule__Alternatives__Group_1__1__Impl : ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) ) ;
    public final void rule__Alternatives__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2927:1: ( ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) ) )
            // InternalXtextGrammarTestLanguage.g:2928:1: ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) )
            {
            // InternalXtextGrammarTestLanguage.g:2928:1: ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) )
            // InternalXtextGrammarTestLanguage.g:2929:2: ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* )
            {
            // InternalXtextGrammarTestLanguage.g:2929:2: ( ( rule__Alternatives__Group_1_1__0 ) )
            // InternalXtextGrammarTestLanguage.g:2930:3: ( rule__Alternatives__Group_1_1__0 )
            {
             before(grammarAccess.getAlternativesAccess().getGroup_1_1()); 
            // InternalXtextGrammarTestLanguage.g:2931:3: ( rule__Alternatives__Group_1_1__0 )
            // InternalXtextGrammarTestLanguage.g:2931:4: rule__Alternatives__Group_1_1__0
            {
            pushFollow(FOLLOW_20);
            rule__Alternatives__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getAlternativesAccess().getGroup_1_1()); 

            }

            // InternalXtextGrammarTestLanguage.g:2934:2: ( ( rule__Alternatives__Group_1_1__0 )* )
            // InternalXtextGrammarTestLanguage.g:2935:3: ( rule__Alternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getAlternativesAccess().getGroup_1_1()); 
            // InternalXtextGrammarTestLanguage.g:2936:3: ( rule__Alternatives__Group_1_1__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==30) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:2936:4: rule__Alternatives__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__Alternatives__Group_1_1__0();

            	    state._fsp--;


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
    // $ANTLR end "rule__Alternatives__Group_1__1__Impl"


    // $ANTLR start "rule__Alternatives__Group_1_1__0"
    // InternalXtextGrammarTestLanguage.g:2946:1: rule__Alternatives__Group_1_1__0 : rule__Alternatives__Group_1_1__0__Impl rule__Alternatives__Group_1_1__1 ;
    public final void rule__Alternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2950:1: ( rule__Alternatives__Group_1_1__0__Impl rule__Alternatives__Group_1_1__1 )
            // InternalXtextGrammarTestLanguage.g:2951:2: rule__Alternatives__Group_1_1__0__Impl rule__Alternatives__Group_1_1__1
            {
            pushFollow(FOLLOW_16);
            rule__Alternatives__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2958:1: rule__Alternatives__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__Alternatives__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2962:1: ( ( '|' ) )
            // InternalXtextGrammarTestLanguage.g:2963:1: ( '|' )
            {
            // InternalXtextGrammarTestLanguage.g:2963:1: ( '|' )
            // InternalXtextGrammarTestLanguage.g:2964:2: '|'
            {
             before(grammarAccess.getAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,30,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:2973:1: rule__Alternatives__Group_1_1__1 : rule__Alternatives__Group_1_1__1__Impl ;
    public final void rule__Alternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2977:1: ( rule__Alternatives__Group_1_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:2978:2: rule__Alternatives__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:2984:1: rule__Alternatives__Group_1_1__1__Impl : ( ( rule__Alternatives__GroupsAssignment_1_1_1 ) ) ;
    public final void rule__Alternatives__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2988:1: ( ( ( rule__Alternatives__GroupsAssignment_1_1_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:2989:1: ( ( rule__Alternatives__GroupsAssignment_1_1_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2989:1: ( ( rule__Alternatives__GroupsAssignment_1_1_1 ) )
            // InternalXtextGrammarTestLanguage.g:2990:2: ( rule__Alternatives__GroupsAssignment_1_1_1 )
            {
             before(grammarAccess.getAlternativesAccess().getGroupsAssignment_1_1_1()); 
            // InternalXtextGrammarTestLanguage.g:2991:2: ( rule__Alternatives__GroupsAssignment_1_1_1 )
            // InternalXtextGrammarTestLanguage.g:2991:3: rule__Alternatives__GroupsAssignment_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Alternatives__GroupsAssignment_1_1_1();

            state._fsp--;


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
    // $ANTLR end "rule__Alternatives__Group_1_1__1__Impl"


    // $ANTLR start "rule__Group__Group__0"
    // InternalXtextGrammarTestLanguage.g:3000:1: rule__Group__Group__0 : rule__Group__Group__0__Impl rule__Group__Group__1 ;
    public final void rule__Group__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3004:1: ( rule__Group__Group__0__Impl rule__Group__Group__1 )
            // InternalXtextGrammarTestLanguage.g:3005:2: rule__Group__Group__0__Impl rule__Group__Group__1
            {
            pushFollow(FOLLOW_16);
            rule__Group__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3012:1: rule__Group__Group__0__Impl : ( ruleAbstractToken ) ;
    public final void rule__Group__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3016:1: ( ( ruleAbstractToken ) )
            // InternalXtextGrammarTestLanguage.g:3017:1: ( ruleAbstractToken )
            {
            // InternalXtextGrammarTestLanguage.g:3017:1: ( ruleAbstractToken )
            // InternalXtextGrammarTestLanguage.g:3018:2: ruleAbstractToken
            {
             before(grammarAccess.getGroupAccess().getAbstractTokenParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3027:1: rule__Group__Group__1 : rule__Group__Group__1__Impl ;
    public final void rule__Group__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3031:1: ( rule__Group__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:3032:2: rule__Group__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3038:1: rule__Group__Group__1__Impl : ( ( rule__Group__Group_1__0 )? ) ;
    public final void rule__Group__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3042:1: ( ( ( rule__Group__Group_1__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:3043:1: ( ( rule__Group__Group_1__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:3043:1: ( ( rule__Group__Group_1__0 )? )
            // InternalXtextGrammarTestLanguage.g:3044:2: ( rule__Group__Group_1__0 )?
            {
             before(grammarAccess.getGroupAccess().getGroup_1()); 
            // InternalXtextGrammarTestLanguage.g:3045:2: ( rule__Group__Group_1__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( ((LA31_0>=RULE_ID && LA31_0<=RULE_STRING)||LA31_0==20||LA31_0==31) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:3045:3: rule__Group__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3054:1: rule__Group__Group_1__0 : rule__Group__Group_1__0__Impl rule__Group__Group_1__1 ;
    public final void rule__Group__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3058:1: ( rule__Group__Group_1__0__Impl rule__Group__Group_1__1 )
            // InternalXtextGrammarTestLanguage.g:3059:2: rule__Group__Group_1__0__Impl rule__Group__Group_1__1
            {
            pushFollow(FOLLOW_16);
            rule__Group__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3066:1: rule__Group__Group_1__0__Impl : ( () ) ;
    public final void rule__Group__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3070:1: ( ( () ) )
            // InternalXtextGrammarTestLanguage.g:3071:1: ( () )
            {
            // InternalXtextGrammarTestLanguage.g:3071:1: ( () )
            // InternalXtextGrammarTestLanguage.g:3072:2: ()
            {
             before(grammarAccess.getGroupAccess().getGroupTokensAction_1_0()); 
            // InternalXtextGrammarTestLanguage.g:3073:2: ()
            // InternalXtextGrammarTestLanguage.g:3073:3: 
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
    // $ANTLR end "rule__Group__Group_1__0__Impl"


    // $ANTLR start "rule__Group__Group_1__1"
    // InternalXtextGrammarTestLanguage.g:3081:1: rule__Group__Group_1__1 : rule__Group__Group_1__1__Impl ;
    public final void rule__Group__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3085:1: ( rule__Group__Group_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:3086:2: rule__Group__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3092:1: rule__Group__Group_1__1__Impl : ( ( ( rule__Group__TokensAssignment_1_1 ) ) ( ( rule__Group__TokensAssignment_1_1 )* ) ) ;
    public final void rule__Group__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3096:1: ( ( ( ( rule__Group__TokensAssignment_1_1 ) ) ( ( rule__Group__TokensAssignment_1_1 )* ) ) )
            // InternalXtextGrammarTestLanguage.g:3097:1: ( ( ( rule__Group__TokensAssignment_1_1 ) ) ( ( rule__Group__TokensAssignment_1_1 )* ) )
            {
            // InternalXtextGrammarTestLanguage.g:3097:1: ( ( ( rule__Group__TokensAssignment_1_1 ) ) ( ( rule__Group__TokensAssignment_1_1 )* ) )
            // InternalXtextGrammarTestLanguage.g:3098:2: ( ( rule__Group__TokensAssignment_1_1 ) ) ( ( rule__Group__TokensAssignment_1_1 )* )
            {
            // InternalXtextGrammarTestLanguage.g:3098:2: ( ( rule__Group__TokensAssignment_1_1 ) )
            // InternalXtextGrammarTestLanguage.g:3099:3: ( rule__Group__TokensAssignment_1_1 )
            {
             before(grammarAccess.getGroupAccess().getTokensAssignment_1_1()); 
            // InternalXtextGrammarTestLanguage.g:3100:3: ( rule__Group__TokensAssignment_1_1 )
            // InternalXtextGrammarTestLanguage.g:3100:4: rule__Group__TokensAssignment_1_1
            {
            pushFollow(FOLLOW_21);
            rule__Group__TokensAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getGroupAccess().getTokensAssignment_1_1()); 

            }

            // InternalXtextGrammarTestLanguage.g:3103:2: ( ( rule__Group__TokensAssignment_1_1 )* )
            // InternalXtextGrammarTestLanguage.g:3104:3: ( rule__Group__TokensAssignment_1_1 )*
            {
             before(grammarAccess.getGroupAccess().getTokensAssignment_1_1()); 
            // InternalXtextGrammarTestLanguage.g:3105:3: ( rule__Group__TokensAssignment_1_1 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0>=RULE_ID && LA32_0<=RULE_STRING)||LA32_0==20||LA32_0==31) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:3105:4: rule__Group__TokensAssignment_1_1
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__Group__TokensAssignment_1_1();

            	    state._fsp--;


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
    // $ANTLR end "rule__Group__Group_1__1__Impl"


    // $ANTLR start "rule__AbstractTokenWithCardinality__Group__0"
    // InternalXtextGrammarTestLanguage.g:3115:1: rule__AbstractTokenWithCardinality__Group__0 : rule__AbstractTokenWithCardinality__Group__0__Impl rule__AbstractTokenWithCardinality__Group__1 ;
    public final void rule__AbstractTokenWithCardinality__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3119:1: ( rule__AbstractTokenWithCardinality__Group__0__Impl rule__AbstractTokenWithCardinality__Group__1 )
            // InternalXtextGrammarTestLanguage.g:3120:2: rule__AbstractTokenWithCardinality__Group__0__Impl rule__AbstractTokenWithCardinality__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__AbstractTokenWithCardinality__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3127:1: rule__AbstractTokenWithCardinality__Group__0__Impl : ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) ) ;
    public final void rule__AbstractTokenWithCardinality__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3131:1: ( ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:3132:1: ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:3132:1: ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) )
            // InternalXtextGrammarTestLanguage.g:3133:2: ( rule__AbstractTokenWithCardinality__Alternatives_0 )
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getAlternatives_0()); 
            // InternalXtextGrammarTestLanguage.g:3134:2: ( rule__AbstractTokenWithCardinality__Alternatives_0 )
            // InternalXtextGrammarTestLanguage.g:3134:3: rule__AbstractTokenWithCardinality__Alternatives_0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3142:1: rule__AbstractTokenWithCardinality__Group__1 : rule__AbstractTokenWithCardinality__Group__1__Impl ;
    public final void rule__AbstractTokenWithCardinality__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3146:1: ( rule__AbstractTokenWithCardinality__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:3147:2: rule__AbstractTokenWithCardinality__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3153:1: rule__AbstractTokenWithCardinality__Group__1__Impl : ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? ) ;
    public final void rule__AbstractTokenWithCardinality__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3157:1: ( ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? ) )
            // InternalXtextGrammarTestLanguage.g:3158:1: ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? )
            {
            // InternalXtextGrammarTestLanguage.g:3158:1: ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? )
            // InternalXtextGrammarTestLanguage.g:3159:2: ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )?
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:3160:2: ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=11 && LA33_0<=13)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:3160:3: rule__AbstractTokenWithCardinality__CardinalityAssignment_1
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3169:1: rule__Action__Group__0 : rule__Action__Group__0__Impl rule__Action__Group__1 ;
    public final void rule__Action__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3173:1: ( rule__Action__Group__0__Impl rule__Action__Group__1 )
            // InternalXtextGrammarTestLanguage.g:3174:2: rule__Action__Group__0__Impl rule__Action__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Action__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3181:1: rule__Action__Group__0__Impl : ( '{' ) ;
    public final void rule__Action__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3185:1: ( ( '{' ) )
            // InternalXtextGrammarTestLanguage.g:3186:1: ( '{' )
            {
            // InternalXtextGrammarTestLanguage.g:3186:1: ( '{' )
            // InternalXtextGrammarTestLanguage.g:3187:2: '{'
            {
             before(grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,31,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:3196:1: rule__Action__Group__1 : rule__Action__Group__1__Impl rule__Action__Group__2 ;
    public final void rule__Action__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3200:1: ( rule__Action__Group__1__Impl rule__Action__Group__2 )
            // InternalXtextGrammarTestLanguage.g:3201:2: rule__Action__Group__1__Impl rule__Action__Group__2
            {
            pushFollow(FOLLOW_23);
            rule__Action__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3208:1: rule__Action__Group__1__Impl : ( ( rule__Action__TypeAssignment_1 ) ) ;
    public final void rule__Action__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3212:1: ( ( ( rule__Action__TypeAssignment_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:3213:1: ( ( rule__Action__TypeAssignment_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:3213:1: ( ( rule__Action__TypeAssignment_1 ) )
            // InternalXtextGrammarTestLanguage.g:3214:2: ( rule__Action__TypeAssignment_1 )
            {
             before(grammarAccess.getActionAccess().getTypeAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:3215:2: ( rule__Action__TypeAssignment_1 )
            // InternalXtextGrammarTestLanguage.g:3215:3: rule__Action__TypeAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3223:1: rule__Action__Group__2 : rule__Action__Group__2__Impl rule__Action__Group__3 ;
    public final void rule__Action__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3227:1: ( rule__Action__Group__2__Impl rule__Action__Group__3 )
            // InternalXtextGrammarTestLanguage.g:3228:2: rule__Action__Group__2__Impl rule__Action__Group__3
            {
            pushFollow(FOLLOW_23);
            rule__Action__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3235:1: rule__Action__Group__2__Impl : ( ( rule__Action__Group_2__0 )? ) ;
    public final void rule__Action__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3239:1: ( ( ( rule__Action__Group_2__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:3240:1: ( ( rule__Action__Group_2__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:3240:1: ( ( rule__Action__Group_2__0 )? )
            // InternalXtextGrammarTestLanguage.g:3241:2: ( rule__Action__Group_2__0 )?
            {
             before(grammarAccess.getActionAccess().getGroup_2()); 
            // InternalXtextGrammarTestLanguage.g:3242:2: ( rule__Action__Group_2__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==22) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:3242:3: rule__Action__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3250:1: rule__Action__Group__3 : rule__Action__Group__3__Impl ;
    public final void rule__Action__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3254:1: ( rule__Action__Group__3__Impl )
            // InternalXtextGrammarTestLanguage.g:3255:2: rule__Action__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3261:1: rule__Action__Group__3__Impl : ( '}' ) ;
    public final void rule__Action__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3265:1: ( ( '}' ) )
            // InternalXtextGrammarTestLanguage.g:3266:1: ( '}' )
            {
            // InternalXtextGrammarTestLanguage.g:3266:1: ( '}' )
            // InternalXtextGrammarTestLanguage.g:3267:2: '}'
            {
             before(grammarAccess.getActionAccess().getRightCurlyBracketKeyword_3()); 
            match(input,32,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:3277:1: rule__Action__Group_2__0 : rule__Action__Group_2__0__Impl rule__Action__Group_2__1 ;
    public final void rule__Action__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3281:1: ( rule__Action__Group_2__0__Impl rule__Action__Group_2__1 )
            // InternalXtextGrammarTestLanguage.g:3282:2: rule__Action__Group_2__0__Impl rule__Action__Group_2__1
            {
            pushFollow(FOLLOW_3);
            rule__Action__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3289:1: rule__Action__Group_2__0__Impl : ( '.' ) ;
    public final void rule__Action__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3293:1: ( ( '.' ) )
            // InternalXtextGrammarTestLanguage.g:3294:1: ( '.' )
            {
            // InternalXtextGrammarTestLanguage.g:3294:1: ( '.' )
            // InternalXtextGrammarTestLanguage.g:3295:2: '.'
            {
             before(grammarAccess.getActionAccess().getFullStopKeyword_2_0()); 
            match(input,22,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:3304:1: rule__Action__Group_2__1 : rule__Action__Group_2__1__Impl rule__Action__Group_2__2 ;
    public final void rule__Action__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3308:1: ( rule__Action__Group_2__1__Impl rule__Action__Group_2__2 )
            // InternalXtextGrammarTestLanguage.g:3309:2: rule__Action__Group_2__1__Impl rule__Action__Group_2__2
            {
            pushFollow(FOLLOW_24);
            rule__Action__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3316:1: rule__Action__Group_2__1__Impl : ( ( rule__Action__FeatureAssignment_2_1 ) ) ;
    public final void rule__Action__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3320:1: ( ( ( rule__Action__FeatureAssignment_2_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:3321:1: ( ( rule__Action__FeatureAssignment_2_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:3321:1: ( ( rule__Action__FeatureAssignment_2_1 ) )
            // InternalXtextGrammarTestLanguage.g:3322:2: ( rule__Action__FeatureAssignment_2_1 )
            {
             before(grammarAccess.getActionAccess().getFeatureAssignment_2_1()); 
            // InternalXtextGrammarTestLanguage.g:3323:2: ( rule__Action__FeatureAssignment_2_1 )
            // InternalXtextGrammarTestLanguage.g:3323:3: rule__Action__FeatureAssignment_2_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3331:1: rule__Action__Group_2__2 : rule__Action__Group_2__2__Impl rule__Action__Group_2__3 ;
    public final void rule__Action__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3335:1: ( rule__Action__Group_2__2__Impl rule__Action__Group_2__3 )
            // InternalXtextGrammarTestLanguage.g:3336:2: rule__Action__Group_2__2__Impl rule__Action__Group_2__3
            {
            pushFollow(FOLLOW_25);
            rule__Action__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3343:1: rule__Action__Group_2__2__Impl : ( ( rule__Action__OperatorAssignment_2_2 ) ) ;
    public final void rule__Action__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3347:1: ( ( ( rule__Action__OperatorAssignment_2_2 ) ) )
            // InternalXtextGrammarTestLanguage.g:3348:1: ( ( rule__Action__OperatorAssignment_2_2 ) )
            {
            // InternalXtextGrammarTestLanguage.g:3348:1: ( ( rule__Action__OperatorAssignment_2_2 ) )
            // InternalXtextGrammarTestLanguage.g:3349:2: ( rule__Action__OperatorAssignment_2_2 )
            {
             before(grammarAccess.getActionAccess().getOperatorAssignment_2_2()); 
            // InternalXtextGrammarTestLanguage.g:3350:2: ( rule__Action__OperatorAssignment_2_2 )
            // InternalXtextGrammarTestLanguage.g:3350:3: rule__Action__OperatorAssignment_2_2
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3358:1: rule__Action__Group_2__3 : rule__Action__Group_2__3__Impl ;
    public final void rule__Action__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3362:1: ( rule__Action__Group_2__3__Impl )
            // InternalXtextGrammarTestLanguage.g:3363:2: rule__Action__Group_2__3__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3369:1: rule__Action__Group_2__3__Impl : ( 'current' ) ;
    public final void rule__Action__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3373:1: ( ( 'current' ) )
            // InternalXtextGrammarTestLanguage.g:3374:1: ( 'current' )
            {
            // InternalXtextGrammarTestLanguage.g:3374:1: ( 'current' )
            // InternalXtextGrammarTestLanguage.g:3375:2: 'current'
            {
             before(grammarAccess.getActionAccess().getCurrentKeyword_2_3()); 
            match(input,33,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:3385:1: rule__Assignment__Group__0 : rule__Assignment__Group__0__Impl rule__Assignment__Group__1 ;
    public final void rule__Assignment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3389:1: ( rule__Assignment__Group__0__Impl rule__Assignment__Group__1 )
            // InternalXtextGrammarTestLanguage.g:3390:2: rule__Assignment__Group__0__Impl rule__Assignment__Group__1
            {
            pushFollow(FOLLOW_26);
            rule__Assignment__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3397:1: rule__Assignment__Group__0__Impl : ( ( rule__Assignment__FeatureAssignment_0 ) ) ;
    public final void rule__Assignment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3401:1: ( ( ( rule__Assignment__FeatureAssignment_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:3402:1: ( ( rule__Assignment__FeatureAssignment_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:3402:1: ( ( rule__Assignment__FeatureAssignment_0 ) )
            // InternalXtextGrammarTestLanguage.g:3403:2: ( rule__Assignment__FeatureAssignment_0 )
            {
             before(grammarAccess.getAssignmentAccess().getFeatureAssignment_0()); 
            // InternalXtextGrammarTestLanguage.g:3404:2: ( rule__Assignment__FeatureAssignment_0 )
            // InternalXtextGrammarTestLanguage.g:3404:3: rule__Assignment__FeatureAssignment_0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3412:1: rule__Assignment__Group__1 : rule__Assignment__Group__1__Impl rule__Assignment__Group__2 ;
    public final void rule__Assignment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3416:1: ( rule__Assignment__Group__1__Impl rule__Assignment__Group__2 )
            // InternalXtextGrammarTestLanguage.g:3417:2: rule__Assignment__Group__1__Impl rule__Assignment__Group__2
            {
            pushFollow(FOLLOW_27);
            rule__Assignment__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3424:1: rule__Assignment__Group__1__Impl : ( ( rule__Assignment__OperatorAssignment_1 ) ) ;
    public final void rule__Assignment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3428:1: ( ( ( rule__Assignment__OperatorAssignment_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:3429:1: ( ( rule__Assignment__OperatorAssignment_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:3429:1: ( ( rule__Assignment__OperatorAssignment_1 ) )
            // InternalXtextGrammarTestLanguage.g:3430:2: ( rule__Assignment__OperatorAssignment_1 )
            {
             before(grammarAccess.getAssignmentAccess().getOperatorAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:3431:2: ( rule__Assignment__OperatorAssignment_1 )
            // InternalXtextGrammarTestLanguage.g:3431:3: rule__Assignment__OperatorAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3439:1: rule__Assignment__Group__2 : rule__Assignment__Group__2__Impl ;
    public final void rule__Assignment__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3443:1: ( rule__Assignment__Group__2__Impl )
            // InternalXtextGrammarTestLanguage.g:3444:2: rule__Assignment__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3450:1: rule__Assignment__Group__2__Impl : ( ( rule__Assignment__TerminalAssignment_2 ) ) ;
    public final void rule__Assignment__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3454:1: ( ( ( rule__Assignment__TerminalAssignment_2 ) ) )
            // InternalXtextGrammarTestLanguage.g:3455:1: ( ( rule__Assignment__TerminalAssignment_2 ) )
            {
            // InternalXtextGrammarTestLanguage.g:3455:1: ( ( rule__Assignment__TerminalAssignment_2 ) )
            // InternalXtextGrammarTestLanguage.g:3456:2: ( rule__Assignment__TerminalAssignment_2 )
            {
             before(grammarAccess.getAssignmentAccess().getTerminalAssignment_2()); 
            // InternalXtextGrammarTestLanguage.g:3457:2: ( rule__Assignment__TerminalAssignment_2 )
            // InternalXtextGrammarTestLanguage.g:3457:3: rule__Assignment__TerminalAssignment_2
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3466:1: rule__ParenthesizedAssignableElement__Group__0 : rule__ParenthesizedAssignableElement__Group__0__Impl rule__ParenthesizedAssignableElement__Group__1 ;
    public final void rule__ParenthesizedAssignableElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3470:1: ( rule__ParenthesizedAssignableElement__Group__0__Impl rule__ParenthesizedAssignableElement__Group__1 )
            // InternalXtextGrammarTestLanguage.g:3471:2: rule__ParenthesizedAssignableElement__Group__0__Impl rule__ParenthesizedAssignableElement__Group__1
            {
            pushFollow(FOLLOW_27);
            rule__ParenthesizedAssignableElement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3478:1: rule__ParenthesizedAssignableElement__Group__0__Impl : ( '(' ) ;
    public final void rule__ParenthesizedAssignableElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3482:1: ( ( '(' ) )
            // InternalXtextGrammarTestLanguage.g:3483:1: ( '(' )
            {
            // InternalXtextGrammarTestLanguage.g:3483:1: ( '(' )
            // InternalXtextGrammarTestLanguage.g:3484:2: '('
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getLeftParenthesisKeyword_0()); 
            match(input,20,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:3493:1: rule__ParenthesizedAssignableElement__Group__1 : rule__ParenthesizedAssignableElement__Group__1__Impl rule__ParenthesizedAssignableElement__Group__2 ;
    public final void rule__ParenthesizedAssignableElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3497:1: ( rule__ParenthesizedAssignableElement__Group__1__Impl rule__ParenthesizedAssignableElement__Group__2 )
            // InternalXtextGrammarTestLanguage.g:3498:2: rule__ParenthesizedAssignableElement__Group__1__Impl rule__ParenthesizedAssignableElement__Group__2
            {
            pushFollow(FOLLOW_28);
            rule__ParenthesizedAssignableElement__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3505:1: rule__ParenthesizedAssignableElement__Group__1__Impl : ( ruleAssignableAlternatives ) ;
    public final void rule__ParenthesizedAssignableElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3509:1: ( ( ruleAssignableAlternatives ) )
            // InternalXtextGrammarTestLanguage.g:3510:1: ( ruleAssignableAlternatives )
            {
            // InternalXtextGrammarTestLanguage.g:3510:1: ( ruleAssignableAlternatives )
            // InternalXtextGrammarTestLanguage.g:3511:2: ruleAssignableAlternatives
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getAssignableAlternativesParserRuleCall_1()); 
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3520:1: rule__ParenthesizedAssignableElement__Group__2 : rule__ParenthesizedAssignableElement__Group__2__Impl ;
    public final void rule__ParenthesizedAssignableElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3524:1: ( rule__ParenthesizedAssignableElement__Group__2__Impl )
            // InternalXtextGrammarTestLanguage.g:3525:2: rule__ParenthesizedAssignableElement__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3531:1: rule__ParenthesizedAssignableElement__Group__2__Impl : ( ')' ) ;
    public final void rule__ParenthesizedAssignableElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3535:1: ( ( ')' ) )
            // InternalXtextGrammarTestLanguage.g:3536:1: ( ')' )
            {
            // InternalXtextGrammarTestLanguage.g:3536:1: ( ')' )
            // InternalXtextGrammarTestLanguage.g:3537:2: ')'
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getRightParenthesisKeyword_2()); 
            match(input,21,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:3547:1: rule__AssignableAlternatives__Group__0 : rule__AssignableAlternatives__Group__0__Impl rule__AssignableAlternatives__Group__1 ;
    public final void rule__AssignableAlternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3551:1: ( rule__AssignableAlternatives__Group__0__Impl rule__AssignableAlternatives__Group__1 )
            // InternalXtextGrammarTestLanguage.g:3552:2: rule__AssignableAlternatives__Group__0__Impl rule__AssignableAlternatives__Group__1
            {
            pushFollow(FOLLOW_19);
            rule__AssignableAlternatives__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3559:1: rule__AssignableAlternatives__Group__0__Impl : ( ruleAssignableTerminal ) ;
    public final void rule__AssignableAlternatives__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3563:1: ( ( ruleAssignableTerminal ) )
            // InternalXtextGrammarTestLanguage.g:3564:1: ( ruleAssignableTerminal )
            {
            // InternalXtextGrammarTestLanguage.g:3564:1: ( ruleAssignableTerminal )
            // InternalXtextGrammarTestLanguage.g:3565:2: ruleAssignableTerminal
            {
             before(grammarAccess.getAssignableAlternativesAccess().getAssignableTerminalParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3574:1: rule__AssignableAlternatives__Group__1 : rule__AssignableAlternatives__Group__1__Impl ;
    public final void rule__AssignableAlternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3578:1: ( rule__AssignableAlternatives__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:3579:2: rule__AssignableAlternatives__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3585:1: rule__AssignableAlternatives__Group__1__Impl : ( ( rule__AssignableAlternatives__Group_1__0 )? ) ;
    public final void rule__AssignableAlternatives__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3589:1: ( ( ( rule__AssignableAlternatives__Group_1__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:3590:1: ( ( rule__AssignableAlternatives__Group_1__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:3590:1: ( ( rule__AssignableAlternatives__Group_1__0 )? )
            // InternalXtextGrammarTestLanguage.g:3591:2: ( rule__AssignableAlternatives__Group_1__0 )?
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup_1()); 
            // InternalXtextGrammarTestLanguage.g:3592:2: ( rule__AssignableAlternatives__Group_1__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==30) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:3592:3: rule__AssignableAlternatives__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3601:1: rule__AssignableAlternatives__Group_1__0 : rule__AssignableAlternatives__Group_1__0__Impl rule__AssignableAlternatives__Group_1__1 ;
    public final void rule__AssignableAlternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3605:1: ( rule__AssignableAlternatives__Group_1__0__Impl rule__AssignableAlternatives__Group_1__1 )
            // InternalXtextGrammarTestLanguage.g:3606:2: rule__AssignableAlternatives__Group_1__0__Impl rule__AssignableAlternatives__Group_1__1
            {
            pushFollow(FOLLOW_19);
            rule__AssignableAlternatives__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3613:1: rule__AssignableAlternatives__Group_1__0__Impl : ( () ) ;
    public final void rule__AssignableAlternatives__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3617:1: ( ( () ) )
            // InternalXtextGrammarTestLanguage.g:3618:1: ( () )
            {
            // InternalXtextGrammarTestLanguage.g:3618:1: ( () )
            // InternalXtextGrammarTestLanguage.g:3619:2: ()
            {
             before(grammarAccess.getAssignableAlternativesAccess().getAlternativesGroupsAction_1_0()); 
            // InternalXtextGrammarTestLanguage.g:3620:2: ()
            // InternalXtextGrammarTestLanguage.g:3620:3: 
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
    // $ANTLR end "rule__AssignableAlternatives__Group_1__0__Impl"


    // $ANTLR start "rule__AssignableAlternatives__Group_1__1"
    // InternalXtextGrammarTestLanguage.g:3628:1: rule__AssignableAlternatives__Group_1__1 : rule__AssignableAlternatives__Group_1__1__Impl ;
    public final void rule__AssignableAlternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3632:1: ( rule__AssignableAlternatives__Group_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:3633:2: rule__AssignableAlternatives__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3639:1: rule__AssignableAlternatives__Group_1__1__Impl : ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) ) ;
    public final void rule__AssignableAlternatives__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3643:1: ( ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) ) )
            // InternalXtextGrammarTestLanguage.g:3644:1: ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) )
            {
            // InternalXtextGrammarTestLanguage.g:3644:1: ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) )
            // InternalXtextGrammarTestLanguage.g:3645:2: ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* )
            {
            // InternalXtextGrammarTestLanguage.g:3645:2: ( ( rule__AssignableAlternatives__Group_1_1__0 ) )
            // InternalXtextGrammarTestLanguage.g:3646:3: ( rule__AssignableAlternatives__Group_1_1__0 )
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 
            // InternalXtextGrammarTestLanguage.g:3647:3: ( rule__AssignableAlternatives__Group_1_1__0 )
            // InternalXtextGrammarTestLanguage.g:3647:4: rule__AssignableAlternatives__Group_1_1__0
            {
            pushFollow(FOLLOW_20);
            rule__AssignableAlternatives__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 

            }

            // InternalXtextGrammarTestLanguage.g:3650:2: ( ( rule__AssignableAlternatives__Group_1_1__0 )* )
            // InternalXtextGrammarTestLanguage.g:3651:3: ( rule__AssignableAlternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 
            // InternalXtextGrammarTestLanguage.g:3652:3: ( rule__AssignableAlternatives__Group_1_1__0 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==30) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:3652:4: rule__AssignableAlternatives__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__AssignableAlternatives__Group_1_1__0();

            	    state._fsp--;


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
    // $ANTLR end "rule__AssignableAlternatives__Group_1__1__Impl"


    // $ANTLR start "rule__AssignableAlternatives__Group_1_1__0"
    // InternalXtextGrammarTestLanguage.g:3662:1: rule__AssignableAlternatives__Group_1_1__0 : rule__AssignableAlternatives__Group_1_1__0__Impl rule__AssignableAlternatives__Group_1_1__1 ;
    public final void rule__AssignableAlternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3666:1: ( rule__AssignableAlternatives__Group_1_1__0__Impl rule__AssignableAlternatives__Group_1_1__1 )
            // InternalXtextGrammarTestLanguage.g:3667:2: rule__AssignableAlternatives__Group_1_1__0__Impl rule__AssignableAlternatives__Group_1_1__1
            {
            pushFollow(FOLLOW_27);
            rule__AssignableAlternatives__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3674:1: rule__AssignableAlternatives__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__AssignableAlternatives__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3678:1: ( ( '|' ) )
            // InternalXtextGrammarTestLanguage.g:3679:1: ( '|' )
            {
            // InternalXtextGrammarTestLanguage.g:3679:1: ( '|' )
            // InternalXtextGrammarTestLanguage.g:3680:2: '|'
            {
             before(grammarAccess.getAssignableAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,30,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:3689:1: rule__AssignableAlternatives__Group_1_1__1 : rule__AssignableAlternatives__Group_1_1__1__Impl ;
    public final void rule__AssignableAlternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3693:1: ( rule__AssignableAlternatives__Group_1_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:3694:2: rule__AssignableAlternatives__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3700:1: rule__AssignableAlternatives__Group_1_1__1__Impl : ( ( rule__AssignableAlternatives__GroupsAssignment_1_1_1 ) ) ;
    public final void rule__AssignableAlternatives__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3704:1: ( ( ( rule__AssignableAlternatives__GroupsAssignment_1_1_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:3705:1: ( ( rule__AssignableAlternatives__GroupsAssignment_1_1_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:3705:1: ( ( rule__AssignableAlternatives__GroupsAssignment_1_1_1 ) )
            // InternalXtextGrammarTestLanguage.g:3706:2: ( rule__AssignableAlternatives__GroupsAssignment_1_1_1 )
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroupsAssignment_1_1_1()); 
            // InternalXtextGrammarTestLanguage.g:3707:2: ( rule__AssignableAlternatives__GroupsAssignment_1_1_1 )
            // InternalXtextGrammarTestLanguage.g:3707:3: rule__AssignableAlternatives__GroupsAssignment_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__AssignableAlternatives__GroupsAssignment_1_1_1();

            state._fsp--;


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
    // $ANTLR end "rule__AssignableAlternatives__Group_1_1__1__Impl"


    // $ANTLR start "rule__CrossReference__Group__0"
    // InternalXtextGrammarTestLanguage.g:3716:1: rule__CrossReference__Group__0 : rule__CrossReference__Group__0__Impl rule__CrossReference__Group__1 ;
    public final void rule__CrossReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3720:1: ( rule__CrossReference__Group__0__Impl rule__CrossReference__Group__1 )
            // InternalXtextGrammarTestLanguage.g:3721:2: rule__CrossReference__Group__0__Impl rule__CrossReference__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__CrossReference__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3728:1: rule__CrossReference__Group__0__Impl : ( '[' ) ;
    public final void rule__CrossReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3732:1: ( ( '[' ) )
            // InternalXtextGrammarTestLanguage.g:3733:1: ( '[' )
            {
            // InternalXtextGrammarTestLanguage.g:3733:1: ( '[' )
            // InternalXtextGrammarTestLanguage.g:3734:2: '['
            {
             before(grammarAccess.getCrossReferenceAccess().getLeftSquareBracketKeyword_0()); 
            match(input,34,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:3743:1: rule__CrossReference__Group__1 : rule__CrossReference__Group__1__Impl rule__CrossReference__Group__2 ;
    public final void rule__CrossReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3747:1: ( rule__CrossReference__Group__1__Impl rule__CrossReference__Group__2 )
            // InternalXtextGrammarTestLanguage.g:3748:2: rule__CrossReference__Group__1__Impl rule__CrossReference__Group__2
            {
            pushFollow(FOLLOW_29);
            rule__CrossReference__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3755:1: rule__CrossReference__Group__1__Impl : ( ( rule__CrossReference__TypeAssignment_1 ) ) ;
    public final void rule__CrossReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3759:1: ( ( ( rule__CrossReference__TypeAssignment_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:3760:1: ( ( rule__CrossReference__TypeAssignment_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:3760:1: ( ( rule__CrossReference__TypeAssignment_1 ) )
            // InternalXtextGrammarTestLanguage.g:3761:2: ( rule__CrossReference__TypeAssignment_1 )
            {
             before(grammarAccess.getCrossReferenceAccess().getTypeAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:3762:2: ( rule__CrossReference__TypeAssignment_1 )
            // InternalXtextGrammarTestLanguage.g:3762:3: rule__CrossReference__TypeAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3770:1: rule__CrossReference__Group__2 : rule__CrossReference__Group__2__Impl rule__CrossReference__Group__3 ;
    public final void rule__CrossReference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3774:1: ( rule__CrossReference__Group__2__Impl rule__CrossReference__Group__3 )
            // InternalXtextGrammarTestLanguage.g:3775:2: rule__CrossReference__Group__2__Impl rule__CrossReference__Group__3
            {
            pushFollow(FOLLOW_29);
            rule__CrossReference__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3782:1: rule__CrossReference__Group__2__Impl : ( ( rule__CrossReference__Group_2__0 )? ) ;
    public final void rule__CrossReference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3786:1: ( ( ( rule__CrossReference__Group_2__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:3787:1: ( ( rule__CrossReference__Group_2__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:3787:1: ( ( rule__CrossReference__Group_2__0 )? )
            // InternalXtextGrammarTestLanguage.g:3788:2: ( rule__CrossReference__Group_2__0 )?
            {
             before(grammarAccess.getCrossReferenceAccess().getGroup_2()); 
            // InternalXtextGrammarTestLanguage.g:3789:2: ( rule__CrossReference__Group_2__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==30) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:3789:3: rule__CrossReference__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3797:1: rule__CrossReference__Group__3 : rule__CrossReference__Group__3__Impl ;
    public final void rule__CrossReference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3801:1: ( rule__CrossReference__Group__3__Impl )
            // InternalXtextGrammarTestLanguage.g:3802:2: rule__CrossReference__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3808:1: rule__CrossReference__Group__3__Impl : ( ']' ) ;
    public final void rule__CrossReference__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3812:1: ( ( ']' ) )
            // InternalXtextGrammarTestLanguage.g:3813:1: ( ']' )
            {
            // InternalXtextGrammarTestLanguage.g:3813:1: ( ']' )
            // InternalXtextGrammarTestLanguage.g:3814:2: ']'
            {
             before(grammarAccess.getCrossReferenceAccess().getRightSquareBracketKeyword_3()); 
            match(input,35,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:3824:1: rule__CrossReference__Group_2__0 : rule__CrossReference__Group_2__0__Impl rule__CrossReference__Group_2__1 ;
    public final void rule__CrossReference__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3828:1: ( rule__CrossReference__Group_2__0__Impl rule__CrossReference__Group_2__1 )
            // InternalXtextGrammarTestLanguage.g:3829:2: rule__CrossReference__Group_2__0__Impl rule__CrossReference__Group_2__1
            {
            pushFollow(FOLLOW_30);
            rule__CrossReference__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3836:1: rule__CrossReference__Group_2__0__Impl : ( '|' ) ;
    public final void rule__CrossReference__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3840:1: ( ( '|' ) )
            // InternalXtextGrammarTestLanguage.g:3841:1: ( '|' )
            {
            // InternalXtextGrammarTestLanguage.g:3841:1: ( '|' )
            // InternalXtextGrammarTestLanguage.g:3842:2: '|'
            {
             before(grammarAccess.getCrossReferenceAccess().getVerticalLineKeyword_2_0()); 
            match(input,30,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:3851:1: rule__CrossReference__Group_2__1 : rule__CrossReference__Group_2__1__Impl ;
    public final void rule__CrossReference__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3855:1: ( rule__CrossReference__Group_2__1__Impl )
            // InternalXtextGrammarTestLanguage.g:3856:2: rule__CrossReference__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:3862:1: rule__CrossReference__Group_2__1__Impl : ( ( rule__CrossReference__TerminalAssignment_2_1 ) ) ;
    public final void rule__CrossReference__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3866:1: ( ( ( rule__CrossReference__TerminalAssignment_2_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:3867:1: ( ( rule__CrossReference__TerminalAssignment_2_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:3867:1: ( ( rule__CrossReference__TerminalAssignment_2_1 ) )
            // InternalXtextGrammarTestLanguage.g:3868:2: ( rule__CrossReference__TerminalAssignment_2_1 )
            {
             before(grammarAccess.getCrossReferenceAccess().getTerminalAssignment_2_1()); 
            // InternalXtextGrammarTestLanguage.g:3869:2: ( rule__CrossReference__TerminalAssignment_2_1 )
            // InternalXtextGrammarTestLanguage.g:3869:3: rule__CrossReference__TerminalAssignment_2_1
            {
            pushFollow(FOLLOW_2);
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


    // $ANTLR start "rule__ParenthesizedCrossReferenceableElement__Group__0"
    // InternalXtextGrammarTestLanguage.g:3878:1: rule__ParenthesizedCrossReferenceableElement__Group__0 : rule__ParenthesizedCrossReferenceableElement__Group__0__Impl rule__ParenthesizedCrossReferenceableElement__Group__1 ;
    public final void rule__ParenthesizedCrossReferenceableElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3882:1: ( rule__ParenthesizedCrossReferenceableElement__Group__0__Impl rule__ParenthesizedCrossReferenceableElement__Group__1 )
            // InternalXtextGrammarTestLanguage.g:3883:2: rule__ParenthesizedCrossReferenceableElement__Group__0__Impl rule__ParenthesizedCrossReferenceableElement__Group__1
            {
            pushFollow(FOLLOW_30);
            rule__ParenthesizedCrossReferenceableElement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParenthesizedCrossReferenceableElement__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedCrossReferenceableElement__Group__0"


    // $ANTLR start "rule__ParenthesizedCrossReferenceableElement__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:3890:1: rule__ParenthesizedCrossReferenceableElement__Group__0__Impl : ( '(' ) ;
    public final void rule__ParenthesizedCrossReferenceableElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3894:1: ( ( '(' ) )
            // InternalXtextGrammarTestLanguage.g:3895:1: ( '(' )
            {
            // InternalXtextGrammarTestLanguage.g:3895:1: ( '(' )
            // InternalXtextGrammarTestLanguage.g:3896:2: '('
            {
             before(grammarAccess.getParenthesizedCrossReferenceableElementAccess().getLeftParenthesisKeyword_0()); 
            match(input,20,FOLLOW_2); 
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
    // $ANTLR end "rule__ParenthesizedCrossReferenceableElement__Group__0__Impl"


    // $ANTLR start "rule__ParenthesizedCrossReferenceableElement__Group__1"
    // InternalXtextGrammarTestLanguage.g:3905:1: rule__ParenthesizedCrossReferenceableElement__Group__1 : rule__ParenthesizedCrossReferenceableElement__Group__1__Impl rule__ParenthesizedCrossReferenceableElement__Group__2 ;
    public final void rule__ParenthesizedCrossReferenceableElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3909:1: ( rule__ParenthesizedCrossReferenceableElement__Group__1__Impl rule__ParenthesizedCrossReferenceableElement__Group__2 )
            // InternalXtextGrammarTestLanguage.g:3910:2: rule__ParenthesizedCrossReferenceableElement__Group__1__Impl rule__ParenthesizedCrossReferenceableElement__Group__2
            {
            pushFollow(FOLLOW_28);
            rule__ParenthesizedCrossReferenceableElement__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParenthesizedCrossReferenceableElement__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedCrossReferenceableElement__Group__1"


    // $ANTLR start "rule__ParenthesizedCrossReferenceableElement__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:3917:1: rule__ParenthesizedCrossReferenceableElement__Group__1__Impl : ( ruleCrossReferenceableAlternatives ) ;
    public final void rule__ParenthesizedCrossReferenceableElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3921:1: ( ( ruleCrossReferenceableAlternatives ) )
            // InternalXtextGrammarTestLanguage.g:3922:1: ( ruleCrossReferenceableAlternatives )
            {
            // InternalXtextGrammarTestLanguage.g:3922:1: ( ruleCrossReferenceableAlternatives )
            // InternalXtextGrammarTestLanguage.g:3923:2: ruleCrossReferenceableAlternatives
            {
             before(grammarAccess.getParenthesizedCrossReferenceableElementAccess().getCrossReferenceableAlternativesParserRuleCall_1()); 
            pushFollow(FOLLOW_2);
            ruleCrossReferenceableAlternatives();

            state._fsp--;

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
    // $ANTLR end "rule__ParenthesizedCrossReferenceableElement__Group__1__Impl"


    // $ANTLR start "rule__ParenthesizedCrossReferenceableElement__Group__2"
    // InternalXtextGrammarTestLanguage.g:3932:1: rule__ParenthesizedCrossReferenceableElement__Group__2 : rule__ParenthesizedCrossReferenceableElement__Group__2__Impl ;
    public final void rule__ParenthesizedCrossReferenceableElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3936:1: ( rule__ParenthesizedCrossReferenceableElement__Group__2__Impl )
            // InternalXtextGrammarTestLanguage.g:3937:2: rule__ParenthesizedCrossReferenceableElement__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ParenthesizedCrossReferenceableElement__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedCrossReferenceableElement__Group__2"


    // $ANTLR start "rule__ParenthesizedCrossReferenceableElement__Group__2__Impl"
    // InternalXtextGrammarTestLanguage.g:3943:1: rule__ParenthesizedCrossReferenceableElement__Group__2__Impl : ( ')' ) ;
    public final void rule__ParenthesizedCrossReferenceableElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3947:1: ( ( ')' ) )
            // InternalXtextGrammarTestLanguage.g:3948:1: ( ')' )
            {
            // InternalXtextGrammarTestLanguage.g:3948:1: ( ')' )
            // InternalXtextGrammarTestLanguage.g:3949:2: ')'
            {
             before(grammarAccess.getParenthesizedCrossReferenceableElementAccess().getRightParenthesisKeyword_2()); 
            match(input,21,FOLLOW_2); 
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
    // $ANTLR end "rule__ParenthesizedCrossReferenceableElement__Group__2__Impl"


    // $ANTLR start "rule__CrossReferenceableAlternatives__Group__0"
    // InternalXtextGrammarTestLanguage.g:3959:1: rule__CrossReferenceableAlternatives__Group__0 : rule__CrossReferenceableAlternatives__Group__0__Impl rule__CrossReferenceableAlternatives__Group__1 ;
    public final void rule__CrossReferenceableAlternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3963:1: ( rule__CrossReferenceableAlternatives__Group__0__Impl rule__CrossReferenceableAlternatives__Group__1 )
            // InternalXtextGrammarTestLanguage.g:3964:2: rule__CrossReferenceableAlternatives__Group__0__Impl rule__CrossReferenceableAlternatives__Group__1
            {
            pushFollow(FOLLOW_19);
            rule__CrossReferenceableAlternatives__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CrossReferenceableAlternatives__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossReferenceableAlternatives__Group__0"


    // $ANTLR start "rule__CrossReferenceableAlternatives__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:3971:1: rule__CrossReferenceableAlternatives__Group__0__Impl : ( ruleCrossReferenceableTerminal ) ;
    public final void rule__CrossReferenceableAlternatives__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3975:1: ( ( ruleCrossReferenceableTerminal ) )
            // InternalXtextGrammarTestLanguage.g:3976:1: ( ruleCrossReferenceableTerminal )
            {
            // InternalXtextGrammarTestLanguage.g:3976:1: ( ruleCrossReferenceableTerminal )
            // InternalXtextGrammarTestLanguage.g:3977:2: ruleCrossReferenceableTerminal
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getCrossReferenceableTerminalParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleCrossReferenceableTerminal();

            state._fsp--;

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
    // $ANTLR end "rule__CrossReferenceableAlternatives__Group__0__Impl"


    // $ANTLR start "rule__CrossReferenceableAlternatives__Group__1"
    // InternalXtextGrammarTestLanguage.g:3986:1: rule__CrossReferenceableAlternatives__Group__1 : rule__CrossReferenceableAlternatives__Group__1__Impl ;
    public final void rule__CrossReferenceableAlternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3990:1: ( rule__CrossReferenceableAlternatives__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:3991:2: rule__CrossReferenceableAlternatives__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CrossReferenceableAlternatives__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossReferenceableAlternatives__Group__1"


    // $ANTLR start "rule__CrossReferenceableAlternatives__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:3997:1: rule__CrossReferenceableAlternatives__Group__1__Impl : ( ( rule__CrossReferenceableAlternatives__Group_1__0 )? ) ;
    public final void rule__CrossReferenceableAlternatives__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4001:1: ( ( ( rule__CrossReferenceableAlternatives__Group_1__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:4002:1: ( ( rule__CrossReferenceableAlternatives__Group_1__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:4002:1: ( ( rule__CrossReferenceableAlternatives__Group_1__0 )? )
            // InternalXtextGrammarTestLanguage.g:4003:2: ( rule__CrossReferenceableAlternatives__Group_1__0 )?
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getGroup_1()); 
            // InternalXtextGrammarTestLanguage.g:4004:2: ( rule__CrossReferenceableAlternatives__Group_1__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==30) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:4004:3: rule__CrossReferenceableAlternatives__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__CrossReferenceableAlternatives__Group_1__0();

                    state._fsp--;


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
    // $ANTLR end "rule__CrossReferenceableAlternatives__Group__1__Impl"


    // $ANTLR start "rule__CrossReferenceableAlternatives__Group_1__0"
    // InternalXtextGrammarTestLanguage.g:4013:1: rule__CrossReferenceableAlternatives__Group_1__0 : rule__CrossReferenceableAlternatives__Group_1__0__Impl rule__CrossReferenceableAlternatives__Group_1__1 ;
    public final void rule__CrossReferenceableAlternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4017:1: ( rule__CrossReferenceableAlternatives__Group_1__0__Impl rule__CrossReferenceableAlternatives__Group_1__1 )
            // InternalXtextGrammarTestLanguage.g:4018:2: rule__CrossReferenceableAlternatives__Group_1__0__Impl rule__CrossReferenceableAlternatives__Group_1__1
            {
            pushFollow(FOLLOW_19);
            rule__CrossReferenceableAlternatives__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CrossReferenceableAlternatives__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossReferenceableAlternatives__Group_1__0"


    // $ANTLR start "rule__CrossReferenceableAlternatives__Group_1__0__Impl"
    // InternalXtextGrammarTestLanguage.g:4025:1: rule__CrossReferenceableAlternatives__Group_1__0__Impl : ( () ) ;
    public final void rule__CrossReferenceableAlternatives__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4029:1: ( ( () ) )
            // InternalXtextGrammarTestLanguage.g:4030:1: ( () )
            {
            // InternalXtextGrammarTestLanguage.g:4030:1: ( () )
            // InternalXtextGrammarTestLanguage.g:4031:2: ()
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getAlternativesGroupsAction_1_0()); 
            // InternalXtextGrammarTestLanguage.g:4032:2: ()
            // InternalXtextGrammarTestLanguage.g:4032:3: 
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
    // $ANTLR end "rule__CrossReferenceableAlternatives__Group_1__0__Impl"


    // $ANTLR start "rule__CrossReferenceableAlternatives__Group_1__1"
    // InternalXtextGrammarTestLanguage.g:4040:1: rule__CrossReferenceableAlternatives__Group_1__1 : rule__CrossReferenceableAlternatives__Group_1__1__Impl ;
    public final void rule__CrossReferenceableAlternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4044:1: ( rule__CrossReferenceableAlternatives__Group_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:4045:2: rule__CrossReferenceableAlternatives__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CrossReferenceableAlternatives__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossReferenceableAlternatives__Group_1__1"


    // $ANTLR start "rule__CrossReferenceableAlternatives__Group_1__1__Impl"
    // InternalXtextGrammarTestLanguage.g:4051:1: rule__CrossReferenceableAlternatives__Group_1__1__Impl : ( ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 ) ) ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 )* ) ) ;
    public final void rule__CrossReferenceableAlternatives__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4055:1: ( ( ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 ) ) ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 )* ) ) )
            // InternalXtextGrammarTestLanguage.g:4056:1: ( ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 ) ) ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 )* ) )
            {
            // InternalXtextGrammarTestLanguage.g:4056:1: ( ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 ) ) ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 )* ) )
            // InternalXtextGrammarTestLanguage.g:4057:2: ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 ) ) ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 )* )
            {
            // InternalXtextGrammarTestLanguage.g:4057:2: ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 ) )
            // InternalXtextGrammarTestLanguage.g:4058:3: ( rule__CrossReferenceableAlternatives__Group_1_1__0 )
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getGroup_1_1()); 
            // InternalXtextGrammarTestLanguage.g:4059:3: ( rule__CrossReferenceableAlternatives__Group_1_1__0 )
            // InternalXtextGrammarTestLanguage.g:4059:4: rule__CrossReferenceableAlternatives__Group_1_1__0
            {
            pushFollow(FOLLOW_20);
            rule__CrossReferenceableAlternatives__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getCrossReferenceableAlternativesAccess().getGroup_1_1()); 

            }

            // InternalXtextGrammarTestLanguage.g:4062:2: ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 )* )
            // InternalXtextGrammarTestLanguage.g:4063:3: ( rule__CrossReferenceableAlternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getGroup_1_1()); 
            // InternalXtextGrammarTestLanguage.g:4064:3: ( rule__CrossReferenceableAlternatives__Group_1_1__0 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==30) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:4064:4: rule__CrossReferenceableAlternatives__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__CrossReferenceableAlternatives__Group_1_1__0();

            	    state._fsp--;


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
    // $ANTLR end "rule__CrossReferenceableAlternatives__Group_1__1__Impl"


    // $ANTLR start "rule__CrossReferenceableAlternatives__Group_1_1__0"
    // InternalXtextGrammarTestLanguage.g:4074:1: rule__CrossReferenceableAlternatives__Group_1_1__0 : rule__CrossReferenceableAlternatives__Group_1_1__0__Impl rule__CrossReferenceableAlternatives__Group_1_1__1 ;
    public final void rule__CrossReferenceableAlternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4078:1: ( rule__CrossReferenceableAlternatives__Group_1_1__0__Impl rule__CrossReferenceableAlternatives__Group_1_1__1 )
            // InternalXtextGrammarTestLanguage.g:4079:2: rule__CrossReferenceableAlternatives__Group_1_1__0__Impl rule__CrossReferenceableAlternatives__Group_1_1__1
            {
            pushFollow(FOLLOW_30);
            rule__CrossReferenceableAlternatives__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CrossReferenceableAlternatives__Group_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossReferenceableAlternatives__Group_1_1__0"


    // $ANTLR start "rule__CrossReferenceableAlternatives__Group_1_1__0__Impl"
    // InternalXtextGrammarTestLanguage.g:4086:1: rule__CrossReferenceableAlternatives__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__CrossReferenceableAlternatives__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4090:1: ( ( '|' ) )
            // InternalXtextGrammarTestLanguage.g:4091:1: ( '|' )
            {
            // InternalXtextGrammarTestLanguage.g:4091:1: ( '|' )
            // InternalXtextGrammarTestLanguage.g:4092:2: '|'
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,30,FOLLOW_2); 
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
    // $ANTLR end "rule__CrossReferenceableAlternatives__Group_1_1__0__Impl"


    // $ANTLR start "rule__CrossReferenceableAlternatives__Group_1_1__1"
    // InternalXtextGrammarTestLanguage.g:4101:1: rule__CrossReferenceableAlternatives__Group_1_1__1 : rule__CrossReferenceableAlternatives__Group_1_1__1__Impl ;
    public final void rule__CrossReferenceableAlternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4105:1: ( rule__CrossReferenceableAlternatives__Group_1_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:4106:2: rule__CrossReferenceableAlternatives__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CrossReferenceableAlternatives__Group_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossReferenceableAlternatives__Group_1_1__1"


    // $ANTLR start "rule__CrossReferenceableAlternatives__Group_1_1__1__Impl"
    // InternalXtextGrammarTestLanguage.g:4112:1: rule__CrossReferenceableAlternatives__Group_1_1__1__Impl : ( ( rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1 ) ) ;
    public final void rule__CrossReferenceableAlternatives__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4116:1: ( ( ( rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:4117:1: ( ( rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:4117:1: ( ( rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1 ) )
            // InternalXtextGrammarTestLanguage.g:4118:2: ( rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1 )
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getGroupsAssignment_1_1_1()); 
            // InternalXtextGrammarTestLanguage.g:4119:2: ( rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1 )
            // InternalXtextGrammarTestLanguage.g:4119:3: rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1();

            state._fsp--;


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
    // $ANTLR end "rule__CrossReferenceableAlternatives__Group_1_1__1__Impl"


    // $ANTLR start "rule__ParenthesizedElement__Group__0"
    // InternalXtextGrammarTestLanguage.g:4128:1: rule__ParenthesizedElement__Group__0 : rule__ParenthesizedElement__Group__0__Impl rule__ParenthesizedElement__Group__1 ;
    public final void rule__ParenthesizedElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4132:1: ( rule__ParenthesizedElement__Group__0__Impl rule__ParenthesizedElement__Group__1 )
            // InternalXtextGrammarTestLanguage.g:4133:2: rule__ParenthesizedElement__Group__0__Impl rule__ParenthesizedElement__Group__1
            {
            pushFollow(FOLLOW_16);
            rule__ParenthesizedElement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:4140:1: rule__ParenthesizedElement__Group__0__Impl : ( '(' ) ;
    public final void rule__ParenthesizedElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4144:1: ( ( '(' ) )
            // InternalXtextGrammarTestLanguage.g:4145:1: ( '(' )
            {
            // InternalXtextGrammarTestLanguage.g:4145:1: ( '(' )
            // InternalXtextGrammarTestLanguage.g:4146:2: '('
            {
             before(grammarAccess.getParenthesizedElementAccess().getLeftParenthesisKeyword_0()); 
            match(input,20,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:4155:1: rule__ParenthesizedElement__Group__1 : rule__ParenthesizedElement__Group__1__Impl rule__ParenthesizedElement__Group__2 ;
    public final void rule__ParenthesizedElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4159:1: ( rule__ParenthesizedElement__Group__1__Impl rule__ParenthesizedElement__Group__2 )
            // InternalXtextGrammarTestLanguage.g:4160:2: rule__ParenthesizedElement__Group__1__Impl rule__ParenthesizedElement__Group__2
            {
            pushFollow(FOLLOW_28);
            rule__ParenthesizedElement__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:4167:1: rule__ParenthesizedElement__Group__1__Impl : ( ruleAlternatives ) ;
    public final void rule__ParenthesizedElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4171:1: ( ( ruleAlternatives ) )
            // InternalXtextGrammarTestLanguage.g:4172:1: ( ruleAlternatives )
            {
            // InternalXtextGrammarTestLanguage.g:4172:1: ( ruleAlternatives )
            // InternalXtextGrammarTestLanguage.g:4173:2: ruleAlternatives
            {
             before(grammarAccess.getParenthesizedElementAccess().getAlternativesParserRuleCall_1()); 
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:4182:1: rule__ParenthesizedElement__Group__2 : rule__ParenthesizedElement__Group__2__Impl ;
    public final void rule__ParenthesizedElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4186:1: ( rule__ParenthesizedElement__Group__2__Impl )
            // InternalXtextGrammarTestLanguage.g:4187:2: rule__ParenthesizedElement__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:4193:1: rule__ParenthesizedElement__Group__2__Impl : ( ')' ) ;
    public final void rule__ParenthesizedElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4197:1: ( ( ')' ) )
            // InternalXtextGrammarTestLanguage.g:4198:1: ( ')' )
            {
            // InternalXtextGrammarTestLanguage.g:4198:1: ( ')' )
            // InternalXtextGrammarTestLanguage.g:4199:2: ')'
            {
             before(grammarAccess.getParenthesizedElementAccess().getRightParenthesisKeyword_2()); 
            match(input,21,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:4209:1: rule__TerminalRule__Group__0 : rule__TerminalRule__Group__0__Impl rule__TerminalRule__Group__1 ;
    public final void rule__TerminalRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4213:1: ( rule__TerminalRule__Group__0__Impl rule__TerminalRule__Group__1 )
            // InternalXtextGrammarTestLanguage.g:4214:2: rule__TerminalRule__Group__0__Impl rule__TerminalRule__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__TerminalRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:4221:1: rule__TerminalRule__Group__0__Impl : ( 'terminal' ) ;
    public final void rule__TerminalRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4225:1: ( ( 'terminal' ) )
            // InternalXtextGrammarTestLanguage.g:4226:1: ( 'terminal' )
            {
            // InternalXtextGrammarTestLanguage.g:4226:1: ( 'terminal' )
            // InternalXtextGrammarTestLanguage.g:4227:2: 'terminal'
            {
             before(grammarAccess.getTerminalRuleAccess().getTerminalKeyword_0()); 
            match(input,36,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:4236:1: rule__TerminalRule__Group__1 : rule__TerminalRule__Group__1__Impl rule__TerminalRule__Group__2 ;
    public final void rule__TerminalRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4240:1: ( rule__TerminalRule__Group__1__Impl rule__TerminalRule__Group__2 )
            // InternalXtextGrammarTestLanguage.g:4241:2: rule__TerminalRule__Group__1__Impl rule__TerminalRule__Group__2
            {
            pushFollow(FOLLOW_31);
            rule__TerminalRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:4248:1: rule__TerminalRule__Group__1__Impl : ( ( rule__TerminalRule__NameAssignment_1 ) ) ;
    public final void rule__TerminalRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4252:1: ( ( ( rule__TerminalRule__NameAssignment_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:4253:1: ( ( rule__TerminalRule__NameAssignment_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:4253:1: ( ( rule__TerminalRule__NameAssignment_1 ) )
            // InternalXtextGrammarTestLanguage.g:4254:2: ( rule__TerminalRule__NameAssignment_1 )
            {
             before(grammarAccess.getTerminalRuleAccess().getNameAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:4255:2: ( rule__TerminalRule__NameAssignment_1 )
            // InternalXtextGrammarTestLanguage.g:4255:3: rule__TerminalRule__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__TerminalRule__NameAssignment_1();

            state._fsp--;


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
    // $ANTLR end "rule__TerminalRule__Group__1__Impl"


    // $ANTLR start "rule__TerminalRule__Group__2"
    // InternalXtextGrammarTestLanguage.g:4263:1: rule__TerminalRule__Group__2 : rule__TerminalRule__Group__2__Impl rule__TerminalRule__Group__3 ;
    public final void rule__TerminalRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4267:1: ( rule__TerminalRule__Group__2__Impl rule__TerminalRule__Group__3 )
            // InternalXtextGrammarTestLanguage.g:4268:2: rule__TerminalRule__Group__2__Impl rule__TerminalRule__Group__3
            {
            pushFollow(FOLLOW_31);
            rule__TerminalRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:4275:1: rule__TerminalRule__Group__2__Impl : ( ( rule__TerminalRule__Group_2__0 )? ) ;
    public final void rule__TerminalRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4279:1: ( ( ( rule__TerminalRule__Group_2__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:4280:1: ( ( rule__TerminalRule__Group_2__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:4280:1: ( ( rule__TerminalRule__Group_2__0 )? )
            // InternalXtextGrammarTestLanguage.g:4281:2: ( rule__TerminalRule__Group_2__0 )?
            {
             before(grammarAccess.getTerminalRuleAccess().getGroup_2()); 
            // InternalXtextGrammarTestLanguage.g:4282:2: ( rule__TerminalRule__Group_2__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==28) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:4282:3: rule__TerminalRule__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TerminalRule__Group_2__0();

                    state._fsp--;


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
    // $ANTLR end "rule__TerminalRule__Group__2__Impl"


    // $ANTLR start "rule__TerminalRule__Group__3"
    // InternalXtextGrammarTestLanguage.g:4290:1: rule__TerminalRule__Group__3 : rule__TerminalRule__Group__3__Impl rule__TerminalRule__Group__4 ;
    public final void rule__TerminalRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4294:1: ( rule__TerminalRule__Group__3__Impl rule__TerminalRule__Group__4 )
            // InternalXtextGrammarTestLanguage.g:4295:2: rule__TerminalRule__Group__3__Impl rule__TerminalRule__Group__4
            {
            pushFollow(FOLLOW_32);
            rule__TerminalRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:4302:1: rule__TerminalRule__Group__3__Impl : ( ':' ) ;
    public final void rule__TerminalRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4306:1: ( ( ':' ) )
            // InternalXtextGrammarTestLanguage.g:4307:1: ( ':' )
            {
            // InternalXtextGrammarTestLanguage.g:4307:1: ( ':' )
            // InternalXtextGrammarTestLanguage.g:4308:2: ':'
            {
             before(grammarAccess.getTerminalRuleAccess().getColonKeyword_3()); 
            match(input,26,FOLLOW_2); 
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
    // $ANTLR end "rule__TerminalRule__Group__3__Impl"


    // $ANTLR start "rule__TerminalRule__Group__4"
    // InternalXtextGrammarTestLanguage.g:4317:1: rule__TerminalRule__Group__4 : rule__TerminalRule__Group__4__Impl rule__TerminalRule__Group__5 ;
    public final void rule__TerminalRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4321:1: ( rule__TerminalRule__Group__4__Impl rule__TerminalRule__Group__5 )
            // InternalXtextGrammarTestLanguage.g:4322:2: rule__TerminalRule__Group__4__Impl rule__TerminalRule__Group__5
            {
            pushFollow(FOLLOW_17);
            rule__TerminalRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TerminalRule__Group__5();

            state._fsp--;


            }

        }
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
    // InternalXtextGrammarTestLanguage.g:4329:1: rule__TerminalRule__Group__4__Impl : ( ( rule__TerminalRule__AlternativesAssignment_4 ) ) ;
    public final void rule__TerminalRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4333:1: ( ( ( rule__TerminalRule__AlternativesAssignment_4 ) ) )
            // InternalXtextGrammarTestLanguage.g:4334:1: ( ( rule__TerminalRule__AlternativesAssignment_4 ) )
            {
            // InternalXtextGrammarTestLanguage.g:4334:1: ( ( rule__TerminalRule__AlternativesAssignment_4 ) )
            // InternalXtextGrammarTestLanguage.g:4335:2: ( rule__TerminalRule__AlternativesAssignment_4 )
            {
             before(grammarAccess.getTerminalRuleAccess().getAlternativesAssignment_4()); 
            // InternalXtextGrammarTestLanguage.g:4336:2: ( rule__TerminalRule__AlternativesAssignment_4 )
            // InternalXtextGrammarTestLanguage.g:4336:3: rule__TerminalRule__AlternativesAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__TerminalRule__AlternativesAssignment_4();

            state._fsp--;


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
    // $ANTLR end "rule__TerminalRule__Group__4__Impl"


    // $ANTLR start "rule__TerminalRule__Group__5"
    // InternalXtextGrammarTestLanguage.g:4344:1: rule__TerminalRule__Group__5 : rule__TerminalRule__Group__5__Impl ;
    public final void rule__TerminalRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4348:1: ( rule__TerminalRule__Group__5__Impl )
            // InternalXtextGrammarTestLanguage.g:4349:2: rule__TerminalRule__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TerminalRule__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group__5"


    // $ANTLR start "rule__TerminalRule__Group__5__Impl"
    // InternalXtextGrammarTestLanguage.g:4355:1: rule__TerminalRule__Group__5__Impl : ( ';' ) ;
    public final void rule__TerminalRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4359:1: ( ( ';' ) )
            // InternalXtextGrammarTestLanguage.g:4360:1: ( ';' )
            {
            // InternalXtextGrammarTestLanguage.g:4360:1: ( ';' )
            // InternalXtextGrammarTestLanguage.g:4361:2: ';'
            {
             before(grammarAccess.getTerminalRuleAccess().getSemicolonKeyword_5()); 
            match(input,27,FOLLOW_2); 
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
    // $ANTLR end "rule__TerminalRule__Group__5__Impl"


    // $ANTLR start "rule__TerminalRule__Group_2__0"
    // InternalXtextGrammarTestLanguage.g:4371:1: rule__TerminalRule__Group_2__0 : rule__TerminalRule__Group_2__0__Impl rule__TerminalRule__Group_2__1 ;
    public final void rule__TerminalRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4375:1: ( rule__TerminalRule__Group_2__0__Impl rule__TerminalRule__Group_2__1 )
            // InternalXtextGrammarTestLanguage.g:4376:2: rule__TerminalRule__Group_2__0__Impl rule__TerminalRule__Group_2__1
            {
            pushFollow(FOLLOW_3);
            rule__TerminalRule__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TerminalRule__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_2__0"


    // $ANTLR start "rule__TerminalRule__Group_2__0__Impl"
    // InternalXtextGrammarTestLanguage.g:4383:1: rule__TerminalRule__Group_2__0__Impl : ( 'returns' ) ;
    public final void rule__TerminalRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4387:1: ( ( 'returns' ) )
            // InternalXtextGrammarTestLanguage.g:4388:1: ( 'returns' )
            {
            // InternalXtextGrammarTestLanguage.g:4388:1: ( 'returns' )
            // InternalXtextGrammarTestLanguage.g:4389:2: 'returns'
            {
             before(grammarAccess.getTerminalRuleAccess().getReturnsKeyword_2_0()); 
            match(input,28,FOLLOW_2); 
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
    // $ANTLR end "rule__TerminalRule__Group_2__0__Impl"


    // $ANTLR start "rule__TerminalRule__Group_2__1"
    // InternalXtextGrammarTestLanguage.g:4398:1: rule__TerminalRule__Group_2__1 : rule__TerminalRule__Group_2__1__Impl ;
    public final void rule__TerminalRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4402:1: ( rule__TerminalRule__Group_2__1__Impl )
            // InternalXtextGrammarTestLanguage.g:4403:2: rule__TerminalRule__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TerminalRule__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_2__1"


    // $ANTLR start "rule__TerminalRule__Group_2__1__Impl"
    // InternalXtextGrammarTestLanguage.g:4409:1: rule__TerminalRule__Group_2__1__Impl : ( ( rule__TerminalRule__TypeAssignment_2_1 ) ) ;
    public final void rule__TerminalRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4413:1: ( ( ( rule__TerminalRule__TypeAssignment_2_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:4414:1: ( ( rule__TerminalRule__TypeAssignment_2_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:4414:1: ( ( rule__TerminalRule__TypeAssignment_2_1 ) )
            // InternalXtextGrammarTestLanguage.g:4415:2: ( rule__TerminalRule__TypeAssignment_2_1 )
            {
             before(grammarAccess.getTerminalRuleAccess().getTypeAssignment_2_1()); 
            // InternalXtextGrammarTestLanguage.g:4416:2: ( rule__TerminalRule__TypeAssignment_2_1 )
            // InternalXtextGrammarTestLanguage.g:4416:3: rule__TerminalRule__TypeAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__TerminalRule__TypeAssignment_2_1();

            state._fsp--;


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
    // $ANTLR end "rule__TerminalRule__Group_2__1__Impl"


    // $ANTLR start "rule__TerminalAlternatives__Group__0"
    // InternalXtextGrammarTestLanguage.g:4425:1: rule__TerminalAlternatives__Group__0 : rule__TerminalAlternatives__Group__0__Impl rule__TerminalAlternatives__Group__1 ;
    public final void rule__TerminalAlternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4429:1: ( rule__TerminalAlternatives__Group__0__Impl rule__TerminalAlternatives__Group__1 )
            // InternalXtextGrammarTestLanguage.g:4430:2: rule__TerminalAlternatives__Group__0__Impl rule__TerminalAlternatives__Group__1
            {
            pushFollow(FOLLOW_19);
            rule__TerminalAlternatives__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:4437:1: rule__TerminalAlternatives__Group__0__Impl : ( ruleTerminalGroup ) ;
    public final void rule__TerminalAlternatives__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4441:1: ( ( ruleTerminalGroup ) )
            // InternalXtextGrammarTestLanguage.g:4442:1: ( ruleTerminalGroup )
            {
            // InternalXtextGrammarTestLanguage.g:4442:1: ( ruleTerminalGroup )
            // InternalXtextGrammarTestLanguage.g:4443:2: ruleTerminalGroup
            {
             before(grammarAccess.getTerminalAlternativesAccess().getTerminalGroupParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:4452:1: rule__TerminalAlternatives__Group__1 : rule__TerminalAlternatives__Group__1__Impl ;
    public final void rule__TerminalAlternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4456:1: ( rule__TerminalAlternatives__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:4457:2: rule__TerminalAlternatives__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:4463:1: rule__TerminalAlternatives__Group__1__Impl : ( ( rule__TerminalAlternatives__Group_1__0 )? ) ;
    public final void rule__TerminalAlternatives__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4467:1: ( ( ( rule__TerminalAlternatives__Group_1__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:4468:1: ( ( rule__TerminalAlternatives__Group_1__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:4468:1: ( ( rule__TerminalAlternatives__Group_1__0 )? )
            // InternalXtextGrammarTestLanguage.g:4469:2: ( rule__TerminalAlternatives__Group_1__0 )?
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup_1()); 
            // InternalXtextGrammarTestLanguage.g:4470:2: ( rule__TerminalAlternatives__Group_1__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==30) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:4470:3: rule__TerminalAlternatives__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:4479:1: rule__TerminalAlternatives__Group_1__0 : rule__TerminalAlternatives__Group_1__0__Impl rule__TerminalAlternatives__Group_1__1 ;
    public final void rule__TerminalAlternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4483:1: ( rule__TerminalAlternatives__Group_1__0__Impl rule__TerminalAlternatives__Group_1__1 )
            // InternalXtextGrammarTestLanguage.g:4484:2: rule__TerminalAlternatives__Group_1__0__Impl rule__TerminalAlternatives__Group_1__1
            {
            pushFollow(FOLLOW_19);
            rule__TerminalAlternatives__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:4491:1: rule__TerminalAlternatives__Group_1__0__Impl : ( () ) ;
    public final void rule__TerminalAlternatives__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4495:1: ( ( () ) )
            // InternalXtextGrammarTestLanguage.g:4496:1: ( () )
            {
            // InternalXtextGrammarTestLanguage.g:4496:1: ( () )
            // InternalXtextGrammarTestLanguage.g:4497:2: ()
            {
             before(grammarAccess.getTerminalAlternativesAccess().getAlternativesGroupsAction_1_0()); 
            // InternalXtextGrammarTestLanguage.g:4498:2: ()
            // InternalXtextGrammarTestLanguage.g:4498:3: 
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
    // $ANTLR end "rule__TerminalAlternatives__Group_1__0__Impl"


    // $ANTLR start "rule__TerminalAlternatives__Group_1__1"
    // InternalXtextGrammarTestLanguage.g:4506:1: rule__TerminalAlternatives__Group_1__1 : rule__TerminalAlternatives__Group_1__1__Impl ;
    public final void rule__TerminalAlternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4510:1: ( rule__TerminalAlternatives__Group_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:4511:2: rule__TerminalAlternatives__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:4517:1: rule__TerminalAlternatives__Group_1__1__Impl : ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) ) ;
    public final void rule__TerminalAlternatives__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4521:1: ( ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) ) )
            // InternalXtextGrammarTestLanguage.g:4522:1: ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) )
            {
            // InternalXtextGrammarTestLanguage.g:4522:1: ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) )
            // InternalXtextGrammarTestLanguage.g:4523:2: ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* )
            {
            // InternalXtextGrammarTestLanguage.g:4523:2: ( ( rule__TerminalAlternatives__Group_1_1__0 ) )
            // InternalXtextGrammarTestLanguage.g:4524:3: ( rule__TerminalAlternatives__Group_1_1__0 )
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 
            // InternalXtextGrammarTestLanguage.g:4525:3: ( rule__TerminalAlternatives__Group_1_1__0 )
            // InternalXtextGrammarTestLanguage.g:4525:4: rule__TerminalAlternatives__Group_1_1__0
            {
            pushFollow(FOLLOW_20);
            rule__TerminalAlternatives__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 

            }

            // InternalXtextGrammarTestLanguage.g:4528:2: ( ( rule__TerminalAlternatives__Group_1_1__0 )* )
            // InternalXtextGrammarTestLanguage.g:4529:3: ( rule__TerminalAlternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 
            // InternalXtextGrammarTestLanguage.g:4530:3: ( rule__TerminalAlternatives__Group_1_1__0 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==30) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:4530:4: rule__TerminalAlternatives__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__TerminalAlternatives__Group_1_1__0();

            	    state._fsp--;


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
    // $ANTLR end "rule__TerminalAlternatives__Group_1__1__Impl"


    // $ANTLR start "rule__TerminalAlternatives__Group_1_1__0"
    // InternalXtextGrammarTestLanguage.g:4540:1: rule__TerminalAlternatives__Group_1_1__0 : rule__TerminalAlternatives__Group_1_1__0__Impl rule__TerminalAlternatives__Group_1_1__1 ;
    public final void rule__TerminalAlternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4544:1: ( rule__TerminalAlternatives__Group_1_1__0__Impl rule__TerminalAlternatives__Group_1_1__1 )
            // InternalXtextGrammarTestLanguage.g:4545:2: rule__TerminalAlternatives__Group_1_1__0__Impl rule__TerminalAlternatives__Group_1_1__1
            {
            pushFollow(FOLLOW_32);
            rule__TerminalAlternatives__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:4552:1: rule__TerminalAlternatives__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__TerminalAlternatives__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4556:1: ( ( '|' ) )
            // InternalXtextGrammarTestLanguage.g:4557:1: ( '|' )
            {
            // InternalXtextGrammarTestLanguage.g:4557:1: ( '|' )
            // InternalXtextGrammarTestLanguage.g:4558:2: '|'
            {
             before(grammarAccess.getTerminalAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,30,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:4567:1: rule__TerminalAlternatives__Group_1_1__1 : rule__TerminalAlternatives__Group_1_1__1__Impl ;
    public final void rule__TerminalAlternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4571:1: ( rule__TerminalAlternatives__Group_1_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:4572:2: rule__TerminalAlternatives__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:4578:1: rule__TerminalAlternatives__Group_1_1__1__Impl : ( ( rule__TerminalAlternatives__GroupsAssignment_1_1_1 ) ) ;
    public final void rule__TerminalAlternatives__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4582:1: ( ( ( rule__TerminalAlternatives__GroupsAssignment_1_1_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:4583:1: ( ( rule__TerminalAlternatives__GroupsAssignment_1_1_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:4583:1: ( ( rule__TerminalAlternatives__GroupsAssignment_1_1_1 ) )
            // InternalXtextGrammarTestLanguage.g:4584:2: ( rule__TerminalAlternatives__GroupsAssignment_1_1_1 )
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroupsAssignment_1_1_1()); 
            // InternalXtextGrammarTestLanguage.g:4585:2: ( rule__TerminalAlternatives__GroupsAssignment_1_1_1 )
            // InternalXtextGrammarTestLanguage.g:4585:3: rule__TerminalAlternatives__GroupsAssignment_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__TerminalAlternatives__GroupsAssignment_1_1_1();

            state._fsp--;


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
    // $ANTLR end "rule__TerminalAlternatives__Group_1_1__1__Impl"


    // $ANTLR start "rule__TerminalGroup__Group__0"
    // InternalXtextGrammarTestLanguage.g:4594:1: rule__TerminalGroup__Group__0 : rule__TerminalGroup__Group__0__Impl rule__TerminalGroup__Group__1 ;
    public final void rule__TerminalGroup__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4598:1: ( rule__TerminalGroup__Group__0__Impl rule__TerminalGroup__Group__1 )
            // InternalXtextGrammarTestLanguage.g:4599:2: rule__TerminalGroup__Group__0__Impl rule__TerminalGroup__Group__1
            {
            pushFollow(FOLLOW_32);
            rule__TerminalGroup__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:4606:1: rule__TerminalGroup__Group__0__Impl : ( ruleTerminalToken ) ;
    public final void rule__TerminalGroup__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4610:1: ( ( ruleTerminalToken ) )
            // InternalXtextGrammarTestLanguage.g:4611:1: ( ruleTerminalToken )
            {
            // InternalXtextGrammarTestLanguage.g:4611:1: ( ruleTerminalToken )
            // InternalXtextGrammarTestLanguage.g:4612:2: ruleTerminalToken
            {
             before(grammarAccess.getTerminalGroupAccess().getTerminalTokenParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:4621:1: rule__TerminalGroup__Group__1 : rule__TerminalGroup__Group__1__Impl ;
    public final void rule__TerminalGroup__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4625:1: ( rule__TerminalGroup__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:4626:2: rule__TerminalGroup__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:4632:1: rule__TerminalGroup__Group__1__Impl : ( ( rule__TerminalGroup__Group_1__0 )? ) ;
    public final void rule__TerminalGroup__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4636:1: ( ( ( rule__TerminalGroup__Group_1__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:4637:1: ( ( rule__TerminalGroup__Group_1__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:4637:1: ( ( rule__TerminalGroup__Group_1__0 )? )
            // InternalXtextGrammarTestLanguage.g:4638:2: ( rule__TerminalGroup__Group_1__0 )?
            {
             before(grammarAccess.getTerminalGroupAccess().getGroup_1()); 
            // InternalXtextGrammarTestLanguage.g:4639:2: ( rule__TerminalGroup__Group_1__0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=RULE_ID && LA43_0<=RULE_STRING)||LA43_0==20||LA43_0==22||(LA43_0>=37 && LA43_0<=38)) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:4639:3: rule__TerminalGroup__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:4648:1: rule__TerminalGroup__Group_1__0 : rule__TerminalGroup__Group_1__0__Impl rule__TerminalGroup__Group_1__1 ;
    public final void rule__TerminalGroup__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4652:1: ( rule__TerminalGroup__Group_1__0__Impl rule__TerminalGroup__Group_1__1 )
            // InternalXtextGrammarTestLanguage.g:4653:2: rule__TerminalGroup__Group_1__0__Impl rule__TerminalGroup__Group_1__1
            {
            pushFollow(FOLLOW_32);
            rule__TerminalGroup__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:4660:1: rule__TerminalGroup__Group_1__0__Impl : ( () ) ;
    public final void rule__TerminalGroup__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4664:1: ( ( () ) )
            // InternalXtextGrammarTestLanguage.g:4665:1: ( () )
            {
            // InternalXtextGrammarTestLanguage.g:4665:1: ( () )
            // InternalXtextGrammarTestLanguage.g:4666:2: ()
            {
             before(grammarAccess.getTerminalGroupAccess().getGroupTokensAction_1_0()); 
            // InternalXtextGrammarTestLanguage.g:4667:2: ()
            // InternalXtextGrammarTestLanguage.g:4667:3: 
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
    // $ANTLR end "rule__TerminalGroup__Group_1__0__Impl"


    // $ANTLR start "rule__TerminalGroup__Group_1__1"
    // InternalXtextGrammarTestLanguage.g:4675:1: rule__TerminalGroup__Group_1__1 : rule__TerminalGroup__Group_1__1__Impl ;
    public final void rule__TerminalGroup__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4679:1: ( rule__TerminalGroup__Group_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:4680:2: rule__TerminalGroup__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:4686:1: rule__TerminalGroup__Group_1__1__Impl : ( ( ( rule__TerminalGroup__TokensAssignment_1_1 ) ) ( ( rule__TerminalGroup__TokensAssignment_1_1 )* ) ) ;
    public final void rule__TerminalGroup__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4690:1: ( ( ( ( rule__TerminalGroup__TokensAssignment_1_1 ) ) ( ( rule__TerminalGroup__TokensAssignment_1_1 )* ) ) )
            // InternalXtextGrammarTestLanguage.g:4691:1: ( ( ( rule__TerminalGroup__TokensAssignment_1_1 ) ) ( ( rule__TerminalGroup__TokensAssignment_1_1 )* ) )
            {
            // InternalXtextGrammarTestLanguage.g:4691:1: ( ( ( rule__TerminalGroup__TokensAssignment_1_1 ) ) ( ( rule__TerminalGroup__TokensAssignment_1_1 )* ) )
            // InternalXtextGrammarTestLanguage.g:4692:2: ( ( rule__TerminalGroup__TokensAssignment_1_1 ) ) ( ( rule__TerminalGroup__TokensAssignment_1_1 )* )
            {
            // InternalXtextGrammarTestLanguage.g:4692:2: ( ( rule__TerminalGroup__TokensAssignment_1_1 ) )
            // InternalXtextGrammarTestLanguage.g:4693:3: ( rule__TerminalGroup__TokensAssignment_1_1 )
            {
             before(grammarAccess.getTerminalGroupAccess().getTokensAssignment_1_1()); 
            // InternalXtextGrammarTestLanguage.g:4694:3: ( rule__TerminalGroup__TokensAssignment_1_1 )
            // InternalXtextGrammarTestLanguage.g:4694:4: rule__TerminalGroup__TokensAssignment_1_1
            {
            pushFollow(FOLLOW_33);
            rule__TerminalGroup__TokensAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getTerminalGroupAccess().getTokensAssignment_1_1()); 

            }

            // InternalXtextGrammarTestLanguage.g:4697:2: ( ( rule__TerminalGroup__TokensAssignment_1_1 )* )
            // InternalXtextGrammarTestLanguage.g:4698:3: ( rule__TerminalGroup__TokensAssignment_1_1 )*
            {
             before(grammarAccess.getTerminalGroupAccess().getTokensAssignment_1_1()); 
            // InternalXtextGrammarTestLanguage.g:4699:3: ( rule__TerminalGroup__TokensAssignment_1_1 )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( ((LA44_0>=RULE_ID && LA44_0<=RULE_STRING)||LA44_0==20||LA44_0==22||(LA44_0>=37 && LA44_0<=38)) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:4699:4: rule__TerminalGroup__TokensAssignment_1_1
            	    {
            	    pushFollow(FOLLOW_33);
            	    rule__TerminalGroup__TokensAssignment_1_1();

            	    state._fsp--;


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
    // $ANTLR end "rule__TerminalGroup__Group_1__1__Impl"


    // $ANTLR start "rule__TerminalToken__Group__0"
    // InternalXtextGrammarTestLanguage.g:4709:1: rule__TerminalToken__Group__0 : rule__TerminalToken__Group__0__Impl rule__TerminalToken__Group__1 ;
    public final void rule__TerminalToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4713:1: ( rule__TerminalToken__Group__0__Impl rule__TerminalToken__Group__1 )
            // InternalXtextGrammarTestLanguage.g:4714:2: rule__TerminalToken__Group__0__Impl rule__TerminalToken__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__TerminalToken__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:4721:1: rule__TerminalToken__Group__0__Impl : ( ruleTerminalTokenElement ) ;
    public final void rule__TerminalToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4725:1: ( ( ruleTerminalTokenElement ) )
            // InternalXtextGrammarTestLanguage.g:4726:1: ( ruleTerminalTokenElement )
            {
            // InternalXtextGrammarTestLanguage.g:4726:1: ( ruleTerminalTokenElement )
            // InternalXtextGrammarTestLanguage.g:4727:2: ruleTerminalTokenElement
            {
             before(grammarAccess.getTerminalTokenAccess().getTerminalTokenElementParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:4736:1: rule__TerminalToken__Group__1 : rule__TerminalToken__Group__1__Impl ;
    public final void rule__TerminalToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4740:1: ( rule__TerminalToken__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:4741:2: rule__TerminalToken__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:4747:1: rule__TerminalToken__Group__1__Impl : ( ( rule__TerminalToken__CardinalityAssignment_1 )? ) ;
    public final void rule__TerminalToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4751:1: ( ( ( rule__TerminalToken__CardinalityAssignment_1 )? ) )
            // InternalXtextGrammarTestLanguage.g:4752:1: ( ( rule__TerminalToken__CardinalityAssignment_1 )? )
            {
            // InternalXtextGrammarTestLanguage.g:4752:1: ( ( rule__TerminalToken__CardinalityAssignment_1 )? )
            // InternalXtextGrammarTestLanguage.g:4753:2: ( rule__TerminalToken__CardinalityAssignment_1 )?
            {
             before(grammarAccess.getTerminalTokenAccess().getCardinalityAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:4754:2: ( rule__TerminalToken__CardinalityAssignment_1 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( ((LA45_0>=11 && LA45_0<=13)) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:4754:3: rule__TerminalToken__CardinalityAssignment_1
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:4763:1: rule__ParenthesizedTerminalElement__Group__0 : rule__ParenthesizedTerminalElement__Group__0__Impl rule__ParenthesizedTerminalElement__Group__1 ;
    public final void rule__ParenthesizedTerminalElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4767:1: ( rule__ParenthesizedTerminalElement__Group__0__Impl rule__ParenthesizedTerminalElement__Group__1 )
            // InternalXtextGrammarTestLanguage.g:4768:2: rule__ParenthesizedTerminalElement__Group__0__Impl rule__ParenthesizedTerminalElement__Group__1
            {
            pushFollow(FOLLOW_32);
            rule__ParenthesizedTerminalElement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:4775:1: rule__ParenthesizedTerminalElement__Group__0__Impl : ( '(' ) ;
    public final void rule__ParenthesizedTerminalElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4779:1: ( ( '(' ) )
            // InternalXtextGrammarTestLanguage.g:4780:1: ( '(' )
            {
            // InternalXtextGrammarTestLanguage.g:4780:1: ( '(' )
            // InternalXtextGrammarTestLanguage.g:4781:2: '('
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getLeftParenthesisKeyword_0()); 
            match(input,20,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:4790:1: rule__ParenthesizedTerminalElement__Group__1 : rule__ParenthesizedTerminalElement__Group__1__Impl rule__ParenthesizedTerminalElement__Group__2 ;
    public final void rule__ParenthesizedTerminalElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4794:1: ( rule__ParenthesizedTerminalElement__Group__1__Impl rule__ParenthesizedTerminalElement__Group__2 )
            // InternalXtextGrammarTestLanguage.g:4795:2: rule__ParenthesizedTerminalElement__Group__1__Impl rule__ParenthesizedTerminalElement__Group__2
            {
            pushFollow(FOLLOW_28);
            rule__ParenthesizedTerminalElement__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:4802:1: rule__ParenthesizedTerminalElement__Group__1__Impl : ( ruleTerminalAlternatives ) ;
    public final void rule__ParenthesizedTerminalElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4806:1: ( ( ruleTerminalAlternatives ) )
            // InternalXtextGrammarTestLanguage.g:4807:1: ( ruleTerminalAlternatives )
            {
            // InternalXtextGrammarTestLanguage.g:4807:1: ( ruleTerminalAlternatives )
            // InternalXtextGrammarTestLanguage.g:4808:2: ruleTerminalAlternatives
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getTerminalAlternativesParserRuleCall_1()); 
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:4817:1: rule__ParenthesizedTerminalElement__Group__2 : rule__ParenthesizedTerminalElement__Group__2__Impl ;
    public final void rule__ParenthesizedTerminalElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4821:1: ( rule__ParenthesizedTerminalElement__Group__2__Impl )
            // InternalXtextGrammarTestLanguage.g:4822:2: rule__ParenthesizedTerminalElement__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:4828:1: rule__ParenthesizedTerminalElement__Group__2__Impl : ( ')' ) ;
    public final void rule__ParenthesizedTerminalElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4832:1: ( ( ')' ) )
            // InternalXtextGrammarTestLanguage.g:4833:1: ( ')' )
            {
            // InternalXtextGrammarTestLanguage.g:4833:1: ( ')' )
            // InternalXtextGrammarTestLanguage.g:4834:2: ')'
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getRightParenthesisKeyword_2()); 
            match(input,21,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:4844:1: rule__NegatedToken__Group__0 : rule__NegatedToken__Group__0__Impl rule__NegatedToken__Group__1 ;
    public final void rule__NegatedToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4848:1: ( rule__NegatedToken__Group__0__Impl rule__NegatedToken__Group__1 )
            // InternalXtextGrammarTestLanguage.g:4849:2: rule__NegatedToken__Group__0__Impl rule__NegatedToken__Group__1
            {
            pushFollow(FOLLOW_32);
            rule__NegatedToken__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:4856:1: rule__NegatedToken__Group__0__Impl : ( '!' ) ;
    public final void rule__NegatedToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4860:1: ( ( '!' ) )
            // InternalXtextGrammarTestLanguage.g:4861:1: ( '!' )
            {
            // InternalXtextGrammarTestLanguage.g:4861:1: ( '!' )
            // InternalXtextGrammarTestLanguage.g:4862:2: '!'
            {
             before(grammarAccess.getNegatedTokenAccess().getExclamationMarkKeyword_0()); 
            match(input,37,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:4871:1: rule__NegatedToken__Group__1 : rule__NegatedToken__Group__1__Impl ;
    public final void rule__NegatedToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4875:1: ( rule__NegatedToken__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:4876:2: rule__NegatedToken__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:4882:1: rule__NegatedToken__Group__1__Impl : ( ( rule__NegatedToken__TerminalAssignment_1 ) ) ;
    public final void rule__NegatedToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4886:1: ( ( ( rule__NegatedToken__TerminalAssignment_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:4887:1: ( ( rule__NegatedToken__TerminalAssignment_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:4887:1: ( ( rule__NegatedToken__TerminalAssignment_1 ) )
            // InternalXtextGrammarTestLanguage.g:4888:2: ( rule__NegatedToken__TerminalAssignment_1 )
            {
             before(grammarAccess.getNegatedTokenAccess().getTerminalAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:4889:2: ( rule__NegatedToken__TerminalAssignment_1 )
            // InternalXtextGrammarTestLanguage.g:4889:3: rule__NegatedToken__TerminalAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:4898:1: rule__UntilToken__Group__0 : rule__UntilToken__Group__0__Impl rule__UntilToken__Group__1 ;
    public final void rule__UntilToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4902:1: ( rule__UntilToken__Group__0__Impl rule__UntilToken__Group__1 )
            // InternalXtextGrammarTestLanguage.g:4903:2: rule__UntilToken__Group__0__Impl rule__UntilToken__Group__1
            {
            pushFollow(FOLLOW_32);
            rule__UntilToken__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:4910:1: rule__UntilToken__Group__0__Impl : ( '->' ) ;
    public final void rule__UntilToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4914:1: ( ( '->' ) )
            // InternalXtextGrammarTestLanguage.g:4915:1: ( '->' )
            {
            // InternalXtextGrammarTestLanguage.g:4915:1: ( '->' )
            // InternalXtextGrammarTestLanguage.g:4916:2: '->'
            {
             before(grammarAccess.getUntilTokenAccess().getHyphenMinusGreaterThanSignKeyword_0()); 
            match(input,38,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:4925:1: rule__UntilToken__Group__1 : rule__UntilToken__Group__1__Impl ;
    public final void rule__UntilToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4929:1: ( rule__UntilToken__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:4930:2: rule__UntilToken__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:4936:1: rule__UntilToken__Group__1__Impl : ( ( rule__UntilToken__TerminalAssignment_1 ) ) ;
    public final void rule__UntilToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4940:1: ( ( ( rule__UntilToken__TerminalAssignment_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:4941:1: ( ( rule__UntilToken__TerminalAssignment_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:4941:1: ( ( rule__UntilToken__TerminalAssignment_1 ) )
            // InternalXtextGrammarTestLanguage.g:4942:2: ( rule__UntilToken__TerminalAssignment_1 )
            {
             before(grammarAccess.getUntilTokenAccess().getTerminalAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:4943:2: ( rule__UntilToken__TerminalAssignment_1 )
            // InternalXtextGrammarTestLanguage.g:4943:3: rule__UntilToken__TerminalAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:4952:1: rule__Wildcard__Group__0 : rule__Wildcard__Group__0__Impl rule__Wildcard__Group__1 ;
    public final void rule__Wildcard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4956:1: ( rule__Wildcard__Group__0__Impl rule__Wildcard__Group__1 )
            // InternalXtextGrammarTestLanguage.g:4957:2: rule__Wildcard__Group__0__Impl rule__Wildcard__Group__1
            {
            pushFollow(FOLLOW_32);
            rule__Wildcard__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:4964:1: rule__Wildcard__Group__0__Impl : ( () ) ;
    public final void rule__Wildcard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4968:1: ( ( () ) )
            // InternalXtextGrammarTestLanguage.g:4969:1: ( () )
            {
            // InternalXtextGrammarTestLanguage.g:4969:1: ( () )
            // InternalXtextGrammarTestLanguage.g:4970:2: ()
            {
             before(grammarAccess.getWildcardAccess().getWildcardAction_0()); 
            // InternalXtextGrammarTestLanguage.g:4971:2: ()
            // InternalXtextGrammarTestLanguage.g:4971:3: 
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
    // InternalXtextGrammarTestLanguage.g:4979:1: rule__Wildcard__Group__1 : rule__Wildcard__Group__1__Impl ;
    public final void rule__Wildcard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4983:1: ( rule__Wildcard__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:4984:2: rule__Wildcard__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:4990:1: rule__Wildcard__Group__1__Impl : ( '.' ) ;
    public final void rule__Wildcard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4994:1: ( ( '.' ) )
            // InternalXtextGrammarTestLanguage.g:4995:1: ( '.' )
            {
            // InternalXtextGrammarTestLanguage.g:4995:1: ( '.' )
            // InternalXtextGrammarTestLanguage.g:4996:2: '.'
            {
             before(grammarAccess.getWildcardAccess().getFullStopKeyword_1()); 
            match(input,22,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:5006:1: rule__CharacterRange__Group__0 : rule__CharacterRange__Group__0__Impl rule__CharacterRange__Group__1 ;
    public final void rule__CharacterRange__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5010:1: ( rule__CharacterRange__Group__0__Impl rule__CharacterRange__Group__1 )
            // InternalXtextGrammarTestLanguage.g:5011:2: rule__CharacterRange__Group__0__Impl rule__CharacterRange__Group__1
            {
            pushFollow(FOLLOW_34);
            rule__CharacterRange__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5018:1: rule__CharacterRange__Group__0__Impl : ( ruleKeyword ) ;
    public final void rule__CharacterRange__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5022:1: ( ( ruleKeyword ) )
            // InternalXtextGrammarTestLanguage.g:5023:1: ( ruleKeyword )
            {
            // InternalXtextGrammarTestLanguage.g:5023:1: ( ruleKeyword )
            // InternalXtextGrammarTestLanguage.g:5024:2: ruleKeyword
            {
             before(grammarAccess.getCharacterRangeAccess().getKeywordParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5033:1: rule__CharacterRange__Group__1 : rule__CharacterRange__Group__1__Impl ;
    public final void rule__CharacterRange__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5037:1: ( rule__CharacterRange__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:5038:2: rule__CharacterRange__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5044:1: rule__CharacterRange__Group__1__Impl : ( ( rule__CharacterRange__Group_1__0 )? ) ;
    public final void rule__CharacterRange__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5048:1: ( ( ( rule__CharacterRange__Group_1__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:5049:1: ( ( rule__CharacterRange__Group_1__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:5049:1: ( ( rule__CharacterRange__Group_1__0 )? )
            // InternalXtextGrammarTestLanguage.g:5050:2: ( rule__CharacterRange__Group_1__0 )?
            {
             before(grammarAccess.getCharacterRangeAccess().getGroup_1()); 
            // InternalXtextGrammarTestLanguage.g:5051:2: ( rule__CharacterRange__Group_1__0 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==39) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:5051:3: rule__CharacterRange__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5060:1: rule__CharacterRange__Group_1__0 : rule__CharacterRange__Group_1__0__Impl rule__CharacterRange__Group_1__1 ;
    public final void rule__CharacterRange__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5064:1: ( rule__CharacterRange__Group_1__0__Impl rule__CharacterRange__Group_1__1 )
            // InternalXtextGrammarTestLanguage.g:5065:2: rule__CharacterRange__Group_1__0__Impl rule__CharacterRange__Group_1__1
            {
            pushFollow(FOLLOW_34);
            rule__CharacterRange__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5072:1: rule__CharacterRange__Group_1__0__Impl : ( () ) ;
    public final void rule__CharacterRange__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5076:1: ( ( () ) )
            // InternalXtextGrammarTestLanguage.g:5077:1: ( () )
            {
            // InternalXtextGrammarTestLanguage.g:5077:1: ( () )
            // InternalXtextGrammarTestLanguage.g:5078:2: ()
            {
             before(grammarAccess.getCharacterRangeAccess().getCharacterRangeLeftAction_1_0()); 
            // InternalXtextGrammarTestLanguage.g:5079:2: ()
            // InternalXtextGrammarTestLanguage.g:5079:3: 
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
    // InternalXtextGrammarTestLanguage.g:5087:1: rule__CharacterRange__Group_1__1 : rule__CharacterRange__Group_1__1__Impl rule__CharacterRange__Group_1__2 ;
    public final void rule__CharacterRange__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5091:1: ( rule__CharacterRange__Group_1__1__Impl rule__CharacterRange__Group_1__2 )
            // InternalXtextGrammarTestLanguage.g:5092:2: rule__CharacterRange__Group_1__1__Impl rule__CharacterRange__Group_1__2
            {
            pushFollow(FOLLOW_13);
            rule__CharacterRange__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5099:1: rule__CharacterRange__Group_1__1__Impl : ( '..' ) ;
    public final void rule__CharacterRange__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5103:1: ( ( '..' ) )
            // InternalXtextGrammarTestLanguage.g:5104:1: ( '..' )
            {
            // InternalXtextGrammarTestLanguage.g:5104:1: ( '..' )
            // InternalXtextGrammarTestLanguage.g:5105:2: '..'
            {
             before(grammarAccess.getCharacterRangeAccess().getFullStopFullStopKeyword_1_1()); 
            match(input,39,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:5114:1: rule__CharacterRange__Group_1__2 : rule__CharacterRange__Group_1__2__Impl ;
    public final void rule__CharacterRange__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5118:1: ( rule__CharacterRange__Group_1__2__Impl )
            // InternalXtextGrammarTestLanguage.g:5119:2: rule__CharacterRange__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5125:1: rule__CharacterRange__Group_1__2__Impl : ( ( rule__CharacterRange__RightAssignment_1_2 ) ) ;
    public final void rule__CharacterRange__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5129:1: ( ( ( rule__CharacterRange__RightAssignment_1_2 ) ) )
            // InternalXtextGrammarTestLanguage.g:5130:1: ( ( rule__CharacterRange__RightAssignment_1_2 ) )
            {
            // InternalXtextGrammarTestLanguage.g:5130:1: ( ( rule__CharacterRange__RightAssignment_1_2 ) )
            // InternalXtextGrammarTestLanguage.g:5131:2: ( rule__CharacterRange__RightAssignment_1_2 )
            {
             before(grammarAccess.getCharacterRangeAccess().getRightAssignment_1_2()); 
            // InternalXtextGrammarTestLanguage.g:5132:2: ( rule__CharacterRange__RightAssignment_1_2 )
            // InternalXtextGrammarTestLanguage.g:5132:3: rule__CharacterRange__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5141:1: rule__EnumRule__Group__0 : rule__EnumRule__Group__0__Impl rule__EnumRule__Group__1 ;
    public final void rule__EnumRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5145:1: ( rule__EnumRule__Group__0__Impl rule__EnumRule__Group__1 )
            // InternalXtextGrammarTestLanguage.g:5146:2: rule__EnumRule__Group__0__Impl rule__EnumRule__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__EnumRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5153:1: rule__EnumRule__Group__0__Impl : ( 'enum' ) ;
    public final void rule__EnumRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5157:1: ( ( 'enum' ) )
            // InternalXtextGrammarTestLanguage.g:5158:1: ( 'enum' )
            {
            // InternalXtextGrammarTestLanguage.g:5158:1: ( 'enum' )
            // InternalXtextGrammarTestLanguage.g:5159:2: 'enum'
            {
             before(grammarAccess.getEnumRuleAccess().getEnumKeyword_0()); 
            match(input,40,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:5168:1: rule__EnumRule__Group__1 : rule__EnumRule__Group__1__Impl rule__EnumRule__Group__2 ;
    public final void rule__EnumRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5172:1: ( rule__EnumRule__Group__1__Impl rule__EnumRule__Group__2 )
            // InternalXtextGrammarTestLanguage.g:5173:2: rule__EnumRule__Group__1__Impl rule__EnumRule__Group__2
            {
            pushFollow(FOLLOW_31);
            rule__EnumRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5180:1: rule__EnumRule__Group__1__Impl : ( ( rule__EnumRule__NameAssignment_1 ) ) ;
    public final void rule__EnumRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5184:1: ( ( ( rule__EnumRule__NameAssignment_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:5185:1: ( ( rule__EnumRule__NameAssignment_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:5185:1: ( ( rule__EnumRule__NameAssignment_1 ) )
            // InternalXtextGrammarTestLanguage.g:5186:2: ( rule__EnumRule__NameAssignment_1 )
            {
             before(grammarAccess.getEnumRuleAccess().getNameAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:5187:2: ( rule__EnumRule__NameAssignment_1 )
            // InternalXtextGrammarTestLanguage.g:5187:3: rule__EnumRule__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5195:1: rule__EnumRule__Group__2 : rule__EnumRule__Group__2__Impl rule__EnumRule__Group__3 ;
    public final void rule__EnumRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5199:1: ( rule__EnumRule__Group__2__Impl rule__EnumRule__Group__3 )
            // InternalXtextGrammarTestLanguage.g:5200:2: rule__EnumRule__Group__2__Impl rule__EnumRule__Group__3
            {
            pushFollow(FOLLOW_31);
            rule__EnumRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5207:1: rule__EnumRule__Group__2__Impl : ( ( rule__EnumRule__Group_2__0 )? ) ;
    public final void rule__EnumRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5211:1: ( ( ( rule__EnumRule__Group_2__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:5212:1: ( ( rule__EnumRule__Group_2__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:5212:1: ( ( rule__EnumRule__Group_2__0 )? )
            // InternalXtextGrammarTestLanguage.g:5213:2: ( rule__EnumRule__Group_2__0 )?
            {
             before(grammarAccess.getEnumRuleAccess().getGroup_2()); 
            // InternalXtextGrammarTestLanguage.g:5214:2: ( rule__EnumRule__Group_2__0 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==28) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:5214:3: rule__EnumRule__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5222:1: rule__EnumRule__Group__3 : rule__EnumRule__Group__3__Impl rule__EnumRule__Group__4 ;
    public final void rule__EnumRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5226:1: ( rule__EnumRule__Group__3__Impl rule__EnumRule__Group__4 )
            // InternalXtextGrammarTestLanguage.g:5227:2: rule__EnumRule__Group__3__Impl rule__EnumRule__Group__4
            {
            pushFollow(FOLLOW_3);
            rule__EnumRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5234:1: rule__EnumRule__Group__3__Impl : ( ':' ) ;
    public final void rule__EnumRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5238:1: ( ( ':' ) )
            // InternalXtextGrammarTestLanguage.g:5239:1: ( ':' )
            {
            // InternalXtextGrammarTestLanguage.g:5239:1: ( ':' )
            // InternalXtextGrammarTestLanguage.g:5240:2: ':'
            {
             before(grammarAccess.getEnumRuleAccess().getColonKeyword_3()); 
            match(input,26,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:5249:1: rule__EnumRule__Group__4 : rule__EnumRule__Group__4__Impl rule__EnumRule__Group__5 ;
    public final void rule__EnumRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5253:1: ( rule__EnumRule__Group__4__Impl rule__EnumRule__Group__5 )
            // InternalXtextGrammarTestLanguage.g:5254:2: rule__EnumRule__Group__4__Impl rule__EnumRule__Group__5
            {
            pushFollow(FOLLOW_17);
            rule__EnumRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5261:1: rule__EnumRule__Group__4__Impl : ( ( rule__EnumRule__AlternativesAssignment_4 ) ) ;
    public final void rule__EnumRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5265:1: ( ( ( rule__EnumRule__AlternativesAssignment_4 ) ) )
            // InternalXtextGrammarTestLanguage.g:5266:1: ( ( rule__EnumRule__AlternativesAssignment_4 ) )
            {
            // InternalXtextGrammarTestLanguage.g:5266:1: ( ( rule__EnumRule__AlternativesAssignment_4 ) )
            // InternalXtextGrammarTestLanguage.g:5267:2: ( rule__EnumRule__AlternativesAssignment_4 )
            {
             before(grammarAccess.getEnumRuleAccess().getAlternativesAssignment_4()); 
            // InternalXtextGrammarTestLanguage.g:5268:2: ( rule__EnumRule__AlternativesAssignment_4 )
            // InternalXtextGrammarTestLanguage.g:5268:3: rule__EnumRule__AlternativesAssignment_4
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5276:1: rule__EnumRule__Group__5 : rule__EnumRule__Group__5__Impl ;
    public final void rule__EnumRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5280:1: ( rule__EnumRule__Group__5__Impl )
            // InternalXtextGrammarTestLanguage.g:5281:2: rule__EnumRule__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5287:1: rule__EnumRule__Group__5__Impl : ( ';' ) ;
    public final void rule__EnumRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5291:1: ( ( ';' ) )
            // InternalXtextGrammarTestLanguage.g:5292:1: ( ';' )
            {
            // InternalXtextGrammarTestLanguage.g:5292:1: ( ';' )
            // InternalXtextGrammarTestLanguage.g:5293:2: ';'
            {
             before(grammarAccess.getEnumRuleAccess().getSemicolonKeyword_5()); 
            match(input,27,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:5303:1: rule__EnumRule__Group_2__0 : rule__EnumRule__Group_2__0__Impl rule__EnumRule__Group_2__1 ;
    public final void rule__EnumRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5307:1: ( rule__EnumRule__Group_2__0__Impl rule__EnumRule__Group_2__1 )
            // InternalXtextGrammarTestLanguage.g:5308:2: rule__EnumRule__Group_2__0__Impl rule__EnumRule__Group_2__1
            {
            pushFollow(FOLLOW_3);
            rule__EnumRule__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5315:1: rule__EnumRule__Group_2__0__Impl : ( 'returns' ) ;
    public final void rule__EnumRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5319:1: ( ( 'returns' ) )
            // InternalXtextGrammarTestLanguage.g:5320:1: ( 'returns' )
            {
            // InternalXtextGrammarTestLanguage.g:5320:1: ( 'returns' )
            // InternalXtextGrammarTestLanguage.g:5321:2: 'returns'
            {
             before(grammarAccess.getEnumRuleAccess().getReturnsKeyword_2_0()); 
            match(input,28,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:5330:1: rule__EnumRule__Group_2__1 : rule__EnumRule__Group_2__1__Impl ;
    public final void rule__EnumRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5334:1: ( rule__EnumRule__Group_2__1__Impl )
            // InternalXtextGrammarTestLanguage.g:5335:2: rule__EnumRule__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5341:1: rule__EnumRule__Group_2__1__Impl : ( ( rule__EnumRule__TypeAssignment_2_1 ) ) ;
    public final void rule__EnumRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5345:1: ( ( ( rule__EnumRule__TypeAssignment_2_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:5346:1: ( ( rule__EnumRule__TypeAssignment_2_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:5346:1: ( ( rule__EnumRule__TypeAssignment_2_1 ) )
            // InternalXtextGrammarTestLanguage.g:5347:2: ( rule__EnumRule__TypeAssignment_2_1 )
            {
             before(grammarAccess.getEnumRuleAccess().getTypeAssignment_2_1()); 
            // InternalXtextGrammarTestLanguage.g:5348:2: ( rule__EnumRule__TypeAssignment_2_1 )
            // InternalXtextGrammarTestLanguage.g:5348:3: rule__EnumRule__TypeAssignment_2_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5357:1: rule__EnumLiterals__Group__0 : rule__EnumLiterals__Group__0__Impl rule__EnumLiterals__Group__1 ;
    public final void rule__EnumLiterals__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5361:1: ( rule__EnumLiterals__Group__0__Impl rule__EnumLiterals__Group__1 )
            // InternalXtextGrammarTestLanguage.g:5362:2: rule__EnumLiterals__Group__0__Impl rule__EnumLiterals__Group__1
            {
            pushFollow(FOLLOW_19);
            rule__EnumLiterals__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5369:1: rule__EnumLiterals__Group__0__Impl : ( ruleEnumLiteralDeclaration ) ;
    public final void rule__EnumLiterals__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5373:1: ( ( ruleEnumLiteralDeclaration ) )
            // InternalXtextGrammarTestLanguage.g:5374:1: ( ruleEnumLiteralDeclaration )
            {
            // InternalXtextGrammarTestLanguage.g:5374:1: ( ruleEnumLiteralDeclaration )
            // InternalXtextGrammarTestLanguage.g:5375:2: ruleEnumLiteralDeclaration
            {
             before(grammarAccess.getEnumLiteralsAccess().getEnumLiteralDeclarationParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5384:1: rule__EnumLiterals__Group__1 : rule__EnumLiterals__Group__1__Impl ;
    public final void rule__EnumLiterals__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5388:1: ( rule__EnumLiterals__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:5389:2: rule__EnumLiterals__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5395:1: rule__EnumLiterals__Group__1__Impl : ( ( rule__EnumLiterals__Group_1__0 )? ) ;
    public final void rule__EnumLiterals__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5399:1: ( ( ( rule__EnumLiterals__Group_1__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:5400:1: ( ( rule__EnumLiterals__Group_1__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:5400:1: ( ( rule__EnumLiterals__Group_1__0 )? )
            // InternalXtextGrammarTestLanguage.g:5401:2: ( rule__EnumLiterals__Group_1__0 )?
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup_1()); 
            // InternalXtextGrammarTestLanguage.g:5402:2: ( rule__EnumLiterals__Group_1__0 )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==30) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:5402:3: rule__EnumLiterals__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5411:1: rule__EnumLiterals__Group_1__0 : rule__EnumLiterals__Group_1__0__Impl rule__EnumLiterals__Group_1__1 ;
    public final void rule__EnumLiterals__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5415:1: ( rule__EnumLiterals__Group_1__0__Impl rule__EnumLiterals__Group_1__1 )
            // InternalXtextGrammarTestLanguage.g:5416:2: rule__EnumLiterals__Group_1__0__Impl rule__EnumLiterals__Group_1__1
            {
            pushFollow(FOLLOW_19);
            rule__EnumLiterals__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5423:1: rule__EnumLiterals__Group_1__0__Impl : ( () ) ;
    public final void rule__EnumLiterals__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5427:1: ( ( () ) )
            // InternalXtextGrammarTestLanguage.g:5428:1: ( () )
            {
            // InternalXtextGrammarTestLanguage.g:5428:1: ( () )
            // InternalXtextGrammarTestLanguage.g:5429:2: ()
            {
             before(grammarAccess.getEnumLiteralsAccess().getAlternativesGroupsAction_1_0()); 
            // InternalXtextGrammarTestLanguage.g:5430:2: ()
            // InternalXtextGrammarTestLanguage.g:5430:3: 
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
    // $ANTLR end "rule__EnumLiterals__Group_1__0__Impl"


    // $ANTLR start "rule__EnumLiterals__Group_1__1"
    // InternalXtextGrammarTestLanguage.g:5438:1: rule__EnumLiterals__Group_1__1 : rule__EnumLiterals__Group_1__1__Impl ;
    public final void rule__EnumLiterals__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5442:1: ( rule__EnumLiterals__Group_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:5443:2: rule__EnumLiterals__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5449:1: rule__EnumLiterals__Group_1__1__Impl : ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) ) ;
    public final void rule__EnumLiterals__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5453:1: ( ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) ) )
            // InternalXtextGrammarTestLanguage.g:5454:1: ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) )
            {
            // InternalXtextGrammarTestLanguage.g:5454:1: ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) )
            // InternalXtextGrammarTestLanguage.g:5455:2: ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* )
            {
            // InternalXtextGrammarTestLanguage.g:5455:2: ( ( rule__EnumLiterals__Group_1_1__0 ) )
            // InternalXtextGrammarTestLanguage.g:5456:3: ( rule__EnumLiterals__Group_1_1__0 )
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 
            // InternalXtextGrammarTestLanguage.g:5457:3: ( rule__EnumLiterals__Group_1_1__0 )
            // InternalXtextGrammarTestLanguage.g:5457:4: rule__EnumLiterals__Group_1_1__0
            {
            pushFollow(FOLLOW_20);
            rule__EnumLiterals__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 

            }

            // InternalXtextGrammarTestLanguage.g:5460:2: ( ( rule__EnumLiterals__Group_1_1__0 )* )
            // InternalXtextGrammarTestLanguage.g:5461:3: ( rule__EnumLiterals__Group_1_1__0 )*
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 
            // InternalXtextGrammarTestLanguage.g:5462:3: ( rule__EnumLiterals__Group_1_1__0 )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==30) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:5462:4: rule__EnumLiterals__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__EnumLiterals__Group_1_1__0();

            	    state._fsp--;


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
    // $ANTLR end "rule__EnumLiterals__Group_1__1__Impl"


    // $ANTLR start "rule__EnumLiterals__Group_1_1__0"
    // InternalXtextGrammarTestLanguage.g:5472:1: rule__EnumLiterals__Group_1_1__0 : rule__EnumLiterals__Group_1_1__0__Impl rule__EnumLiterals__Group_1_1__1 ;
    public final void rule__EnumLiterals__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5476:1: ( rule__EnumLiterals__Group_1_1__0__Impl rule__EnumLiterals__Group_1_1__1 )
            // InternalXtextGrammarTestLanguage.g:5477:2: rule__EnumLiterals__Group_1_1__0__Impl rule__EnumLiterals__Group_1_1__1
            {
            pushFollow(FOLLOW_3);
            rule__EnumLiterals__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5484:1: rule__EnumLiterals__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__EnumLiterals__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5488:1: ( ( '|' ) )
            // InternalXtextGrammarTestLanguage.g:5489:1: ( '|' )
            {
            // InternalXtextGrammarTestLanguage.g:5489:1: ( '|' )
            // InternalXtextGrammarTestLanguage.g:5490:2: '|'
            {
             before(grammarAccess.getEnumLiteralsAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,30,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:5499:1: rule__EnumLiterals__Group_1_1__1 : rule__EnumLiterals__Group_1_1__1__Impl ;
    public final void rule__EnumLiterals__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5503:1: ( rule__EnumLiterals__Group_1_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:5504:2: rule__EnumLiterals__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5510:1: rule__EnumLiterals__Group_1_1__1__Impl : ( ( rule__EnumLiterals__GroupsAssignment_1_1_1 ) ) ;
    public final void rule__EnumLiterals__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5514:1: ( ( ( rule__EnumLiterals__GroupsAssignment_1_1_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:5515:1: ( ( rule__EnumLiterals__GroupsAssignment_1_1_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:5515:1: ( ( rule__EnumLiterals__GroupsAssignment_1_1_1 ) )
            // InternalXtextGrammarTestLanguage.g:5516:2: ( rule__EnumLiterals__GroupsAssignment_1_1_1 )
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroupsAssignment_1_1_1()); 
            // InternalXtextGrammarTestLanguage.g:5517:2: ( rule__EnumLiterals__GroupsAssignment_1_1_1 )
            // InternalXtextGrammarTestLanguage.g:5517:3: rule__EnumLiterals__GroupsAssignment_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__EnumLiterals__GroupsAssignment_1_1_1();

            state._fsp--;


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
    // $ANTLR end "rule__EnumLiterals__Group_1_1__1__Impl"


    // $ANTLR start "rule__EnumLiteralDeclaration__Group__0"
    // InternalXtextGrammarTestLanguage.g:5526:1: rule__EnumLiteralDeclaration__Group__0 : rule__EnumLiteralDeclaration__Group__0__Impl rule__EnumLiteralDeclaration__Group__1 ;
    public final void rule__EnumLiteralDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5530:1: ( rule__EnumLiteralDeclaration__Group__0__Impl rule__EnumLiteralDeclaration__Group__1 )
            // InternalXtextGrammarTestLanguage.g:5531:2: rule__EnumLiteralDeclaration__Group__0__Impl rule__EnumLiteralDeclaration__Group__1
            {
            pushFollow(FOLLOW_35);
            rule__EnumLiteralDeclaration__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5538:1: rule__EnumLiteralDeclaration__Group__0__Impl : ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) ) ;
    public final void rule__EnumLiteralDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5542:1: ( ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:5543:1: ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:5543:1: ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) )
            // InternalXtextGrammarTestLanguage.g:5544:2: ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralAssignment_0()); 
            // InternalXtextGrammarTestLanguage.g:5545:2: ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 )
            // InternalXtextGrammarTestLanguage.g:5545:3: rule__EnumLiteralDeclaration__EnumLiteralAssignment_0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5553:1: rule__EnumLiteralDeclaration__Group__1 : rule__EnumLiteralDeclaration__Group__1__Impl ;
    public final void rule__EnumLiteralDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5557:1: ( rule__EnumLiteralDeclaration__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:5558:2: rule__EnumLiteralDeclaration__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5564:1: rule__EnumLiteralDeclaration__Group__1__Impl : ( ( rule__EnumLiteralDeclaration__Group_1__0 )? ) ;
    public final void rule__EnumLiteralDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5568:1: ( ( ( rule__EnumLiteralDeclaration__Group_1__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:5569:1: ( ( rule__EnumLiteralDeclaration__Group_1__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:5569:1: ( ( rule__EnumLiteralDeclaration__Group_1__0 )? )
            // InternalXtextGrammarTestLanguage.g:5570:2: ( rule__EnumLiteralDeclaration__Group_1__0 )?
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getGroup_1()); 
            // InternalXtextGrammarTestLanguage.g:5571:2: ( rule__EnumLiteralDeclaration__Group_1__0 )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==14) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:5571:3: rule__EnumLiteralDeclaration__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5580:1: rule__EnumLiteralDeclaration__Group_1__0 : rule__EnumLiteralDeclaration__Group_1__0__Impl rule__EnumLiteralDeclaration__Group_1__1 ;
    public final void rule__EnumLiteralDeclaration__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5584:1: ( rule__EnumLiteralDeclaration__Group_1__0__Impl rule__EnumLiteralDeclaration__Group_1__1 )
            // InternalXtextGrammarTestLanguage.g:5585:2: rule__EnumLiteralDeclaration__Group_1__0__Impl rule__EnumLiteralDeclaration__Group_1__1
            {
            pushFollow(FOLLOW_13);
            rule__EnumLiteralDeclaration__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5592:1: rule__EnumLiteralDeclaration__Group_1__0__Impl : ( '=' ) ;
    public final void rule__EnumLiteralDeclaration__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5596:1: ( ( '=' ) )
            // InternalXtextGrammarTestLanguage.g:5597:1: ( '=' )
            {
            // InternalXtextGrammarTestLanguage.g:5597:1: ( '=' )
            // InternalXtextGrammarTestLanguage.g:5598:2: '='
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEqualsSignKeyword_1_0()); 
            match(input,14,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:5607:1: rule__EnumLiteralDeclaration__Group_1__1 : rule__EnumLiteralDeclaration__Group_1__1__Impl ;
    public final void rule__EnumLiteralDeclaration__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5611:1: ( rule__EnumLiteralDeclaration__Group_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:5612:2: rule__EnumLiteralDeclaration__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5618:1: rule__EnumLiteralDeclaration__Group_1__1__Impl : ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) ) ;
    public final void rule__EnumLiteralDeclaration__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5622:1: ( ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:5623:1: ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:5623:1: ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) )
            // InternalXtextGrammarTestLanguage.g:5624:2: ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralAssignment_1_1()); 
            // InternalXtextGrammarTestLanguage.g:5625:2: ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 )
            // InternalXtextGrammarTestLanguage.g:5625:3: rule__EnumLiteralDeclaration__LiteralAssignment_1_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5634:1: rule__Grammar__NameAssignment_1 : ( ruleGrammarID ) ;
    public final void rule__Grammar__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5638:1: ( ( ruleGrammarID ) )
            // InternalXtextGrammarTestLanguage.g:5639:2: ( ruleGrammarID )
            {
            // InternalXtextGrammarTestLanguage.g:5639:2: ( ruleGrammarID )
            // InternalXtextGrammarTestLanguage.g:5640:3: ruleGrammarID
            {
             before(grammarAccess.getGrammarAccess().getNameGrammarIDParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5649:1: rule__Grammar__UsedGrammarsAssignment_2_1 : ( ( ruleGrammarID ) ) ;
    public final void rule__Grammar__UsedGrammarsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5653:1: ( ( ( ruleGrammarID ) ) )
            // InternalXtextGrammarTestLanguage.g:5654:2: ( ( ruleGrammarID ) )
            {
            // InternalXtextGrammarTestLanguage.g:5654:2: ( ( ruleGrammarID ) )
            // InternalXtextGrammarTestLanguage.g:5655:3: ( ruleGrammarID )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_1_0()); 
            // InternalXtextGrammarTestLanguage.g:5656:3: ( ruleGrammarID )
            // InternalXtextGrammarTestLanguage.g:5657:4: ruleGrammarID
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarGrammarIDParserRuleCall_2_1_0_1()); 
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5668:1: rule__Grammar__UsedGrammarsAssignment_2_2_1 : ( ( ruleGrammarID ) ) ;
    public final void rule__Grammar__UsedGrammarsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5672:1: ( ( ( ruleGrammarID ) ) )
            // InternalXtextGrammarTestLanguage.g:5673:2: ( ( ruleGrammarID ) )
            {
            // InternalXtextGrammarTestLanguage.g:5673:2: ( ( ruleGrammarID ) )
            // InternalXtextGrammarTestLanguage.g:5674:3: ( ruleGrammarID )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_2_1_0()); 
            // InternalXtextGrammarTestLanguage.g:5675:3: ( ruleGrammarID )
            // InternalXtextGrammarTestLanguage.g:5676:4: ruleGrammarID
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarGrammarIDParserRuleCall_2_2_1_0_1()); 
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5687:1: rule__Grammar__DefinesHiddenTokensAssignment_3_0 : ( ( 'hidden' ) ) ;
    public final void rule__Grammar__DefinesHiddenTokensAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5691:1: ( ( ( 'hidden' ) ) )
            // InternalXtextGrammarTestLanguage.g:5692:2: ( ( 'hidden' ) )
            {
            // InternalXtextGrammarTestLanguage.g:5692:2: ( ( 'hidden' ) )
            // InternalXtextGrammarTestLanguage.g:5693:3: ( 'hidden' )
            {
             before(grammarAccess.getGrammarAccess().getDefinesHiddenTokensHiddenKeyword_3_0_0()); 
            // InternalXtextGrammarTestLanguage.g:5694:3: ( 'hidden' )
            // InternalXtextGrammarTestLanguage.g:5695:4: 'hidden'
            {
             before(grammarAccess.getGrammarAccess().getDefinesHiddenTokensHiddenKeyword_3_0_0()); 
            match(input,41,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:5706:1: rule__Grammar__HiddenTokensAssignment_3_2_0 : ( ( RULE_ID ) ) ;
    public final void rule__Grammar__HiddenTokensAssignment_3_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5710:1: ( ( ( RULE_ID ) ) )
            // InternalXtextGrammarTestLanguage.g:5711:2: ( ( RULE_ID ) )
            {
            // InternalXtextGrammarTestLanguage.g:5711:2: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:5712:3: ( RULE_ID )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_0_0()); 
            // InternalXtextGrammarTestLanguage.g:5713:3: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:5714:4: RULE_ID
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_3_2_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:5725:1: rule__Grammar__HiddenTokensAssignment_3_2_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Grammar__HiddenTokensAssignment_3_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5729:1: ( ( ( RULE_ID ) ) )
            // InternalXtextGrammarTestLanguage.g:5730:2: ( ( RULE_ID ) )
            {
            // InternalXtextGrammarTestLanguage.g:5730:2: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:5731:3: ( RULE_ID )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_1_1_0()); 
            // InternalXtextGrammarTestLanguage.g:5732:3: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:5733:4: RULE_ID
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_3_2_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:5744:1: rule__Grammar__MetamodelDeclarationsAssignment_4 : ( ruleAbstractMetamodelDeclaration ) ;
    public final void rule__Grammar__MetamodelDeclarationsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5748:1: ( ( ruleAbstractMetamodelDeclaration ) )
            // InternalXtextGrammarTestLanguage.g:5749:2: ( ruleAbstractMetamodelDeclaration )
            {
            // InternalXtextGrammarTestLanguage.g:5749:2: ( ruleAbstractMetamodelDeclaration )
            // InternalXtextGrammarTestLanguage.g:5750:3: ruleAbstractMetamodelDeclaration
            {
             before(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5759:1: rule__Grammar__RulesAssignment_5 : ( ruleAbstractRule ) ;
    public final void rule__Grammar__RulesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5763:1: ( ( ruleAbstractRule ) )
            // InternalXtextGrammarTestLanguage.g:5764:2: ( ruleAbstractRule )
            {
            // InternalXtextGrammarTestLanguage.g:5764:2: ( ruleAbstractRule )
            // InternalXtextGrammarTestLanguage.g:5765:3: ruleAbstractRule
            {
             before(grammarAccess.getGrammarAccess().getRulesAbstractRuleParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5774:1: rule__GeneratedMetamodel__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__GeneratedMetamodel__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5778:1: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:5779:2: ( RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:5779:2: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:5780:3: RULE_ID
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:5789:1: rule__GeneratedMetamodel__EPackageAssignment_2 : ( ( RULE_STRING ) ) ;
    public final void rule__GeneratedMetamodel__EPackageAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5793:1: ( ( ( RULE_STRING ) ) )
            // InternalXtextGrammarTestLanguage.g:5794:2: ( ( RULE_STRING ) )
            {
            // InternalXtextGrammarTestLanguage.g:5794:2: ( ( RULE_STRING ) )
            // InternalXtextGrammarTestLanguage.g:5795:3: ( RULE_STRING )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageCrossReference_2_0()); 
            // InternalXtextGrammarTestLanguage.g:5796:3: ( RULE_STRING )
            // InternalXtextGrammarTestLanguage.g:5797:4: RULE_STRING
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_2_0_1()); 
            match(input,RULE_STRING,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:5808:1: rule__GeneratedMetamodel__AliasAssignment_3_1 : ( RULE_ID ) ;
    public final void rule__GeneratedMetamodel__AliasAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5812:1: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:5813:2: ( RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:5813:2: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:5814:3: RULE_ID
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getAliasIDTerminalRuleCall_3_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:5823:1: rule__ReferencedMetamodel__EPackageAssignment_1 : ( ( RULE_STRING ) ) ;
    public final void rule__ReferencedMetamodel__EPackageAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5827:1: ( ( ( RULE_STRING ) ) )
            // InternalXtextGrammarTestLanguage.g:5828:2: ( ( RULE_STRING ) )
            {
            // InternalXtextGrammarTestLanguage.g:5828:2: ( ( RULE_STRING ) )
            // InternalXtextGrammarTestLanguage.g:5829:3: ( RULE_STRING )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageCrossReference_1_0()); 
            // InternalXtextGrammarTestLanguage.g:5830:3: ( RULE_STRING )
            // InternalXtextGrammarTestLanguage.g:5831:4: RULE_STRING
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_1_0_1()); 
            match(input,RULE_STRING,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:5842:1: rule__ReferencedMetamodel__AliasAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__ReferencedMetamodel__AliasAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5846:1: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:5847:2: ( RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:5847:2: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:5848:3: RULE_ID
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAliasIDTerminalRuleCall_2_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:5857:1: rule__ParserRule__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__ParserRule__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5861:1: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:5862:2: ( RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:5862:2: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:5863:3: RULE_ID
            {
             before(grammarAccess.getParserRuleAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:5872:1: rule__ParserRule__TypeAssignment_1_1 : ( ruleTypeRef ) ;
    public final void rule__ParserRule__TypeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5876:1: ( ( ruleTypeRef ) )
            // InternalXtextGrammarTestLanguage.g:5877:2: ( ruleTypeRef )
            {
            // InternalXtextGrammarTestLanguage.g:5877:2: ( ruleTypeRef )
            // InternalXtextGrammarTestLanguage.g:5878:3: ruleTypeRef
            {
             before(grammarAccess.getParserRuleAccess().getTypeTypeRefParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5887:1: rule__ParserRule__DefinesHiddenTokensAssignment_2_0 : ( ( 'hidden' ) ) ;
    public final void rule__ParserRule__DefinesHiddenTokensAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5891:1: ( ( ( 'hidden' ) ) )
            // InternalXtextGrammarTestLanguage.g:5892:2: ( ( 'hidden' ) )
            {
            // InternalXtextGrammarTestLanguage.g:5892:2: ( ( 'hidden' ) )
            // InternalXtextGrammarTestLanguage.g:5893:3: ( 'hidden' )
            {
             before(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_2_0_0()); 
            // InternalXtextGrammarTestLanguage.g:5894:3: ( 'hidden' )
            // InternalXtextGrammarTestLanguage.g:5895:4: 'hidden'
            {
             before(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_2_0_0()); 
            match(input,41,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:5906:1: rule__ParserRule__HiddenTokensAssignment_2_2_0 : ( ( RULE_ID ) ) ;
    public final void rule__ParserRule__HiddenTokensAssignment_2_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5910:1: ( ( ( RULE_ID ) ) )
            // InternalXtextGrammarTestLanguage.g:5911:2: ( ( RULE_ID ) )
            {
            // InternalXtextGrammarTestLanguage.g:5911:2: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:5912:3: ( RULE_ID )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_0_0()); 
            // InternalXtextGrammarTestLanguage.g:5913:3: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:5914:4: RULE_ID
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_2_2_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:5925:1: rule__ParserRule__HiddenTokensAssignment_2_2_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__ParserRule__HiddenTokensAssignment_2_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5929:1: ( ( ( RULE_ID ) ) )
            // InternalXtextGrammarTestLanguage.g:5930:2: ( ( RULE_ID ) )
            {
            // InternalXtextGrammarTestLanguage.g:5930:2: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:5931:3: ( RULE_ID )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_1_1_0()); 
            // InternalXtextGrammarTestLanguage.g:5932:3: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:5933:4: RULE_ID
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_2_2_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:5944:1: rule__ParserRule__AlternativesAssignment_4 : ( ruleAlternatives ) ;
    public final void rule__ParserRule__AlternativesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5948:1: ( ( ruleAlternatives ) )
            // InternalXtextGrammarTestLanguage.g:5949:2: ( ruleAlternatives )
            {
            // InternalXtextGrammarTestLanguage.g:5949:2: ( ruleAlternatives )
            // InternalXtextGrammarTestLanguage.g:5950:3: ruleAlternatives
            {
             before(grammarAccess.getParserRuleAccess().getAlternativesAlternativesParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:5959:1: rule__TypeRef__MetamodelAssignment_0_0 : ( ( RULE_ID ) ) ;
    public final void rule__TypeRef__MetamodelAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5963:1: ( ( ( RULE_ID ) ) )
            // InternalXtextGrammarTestLanguage.g:5964:2: ( ( RULE_ID ) )
            {
            // InternalXtextGrammarTestLanguage.g:5964:2: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:5965:3: ( RULE_ID )
            {
             before(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationCrossReference_0_0_0()); 
            // InternalXtextGrammarTestLanguage.g:5966:3: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:5967:4: RULE_ID
            {
             before(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationIDTerminalRuleCall_0_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:5978:1: rule__TypeRef__ClassifierAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__TypeRef__ClassifierAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5982:1: ( ( ( RULE_ID ) ) )
            // InternalXtextGrammarTestLanguage.g:5983:2: ( ( RULE_ID ) )
            {
            // InternalXtextGrammarTestLanguage.g:5983:2: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:5984:3: ( RULE_ID )
            {
             before(grammarAccess.getTypeRefAccess().getClassifierEClassifierCrossReference_1_0()); 
            // InternalXtextGrammarTestLanguage.g:5985:3: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:5986:4: RULE_ID
            {
             before(grammarAccess.getTypeRefAccess().getClassifierEClassifierIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
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


    // $ANTLR start "rule__Alternatives__GroupsAssignment_1_1_1"
    // InternalXtextGrammarTestLanguage.g:5997:1: rule__Alternatives__GroupsAssignment_1_1_1 : ( ruleGroup ) ;
    public final void rule__Alternatives__GroupsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6001:1: ( ( ruleGroup ) )
            // InternalXtextGrammarTestLanguage.g:6002:2: ( ruleGroup )
            {
            // InternalXtextGrammarTestLanguage.g:6002:2: ( ruleGroup )
            // InternalXtextGrammarTestLanguage.g:6003:3: ruleGroup
            {
             before(grammarAccess.getAlternativesAccess().getGroupsGroupParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleGroup();

            state._fsp--;

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
    // $ANTLR end "rule__Alternatives__GroupsAssignment_1_1_1"


    // $ANTLR start "rule__Group__TokensAssignment_1_1"
    // InternalXtextGrammarTestLanguage.g:6012:1: rule__Group__TokensAssignment_1_1 : ( ruleAbstractToken ) ;
    public final void rule__Group__TokensAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6016:1: ( ( ruleAbstractToken ) )
            // InternalXtextGrammarTestLanguage.g:6017:2: ( ruleAbstractToken )
            {
            // InternalXtextGrammarTestLanguage.g:6017:2: ( ruleAbstractToken )
            // InternalXtextGrammarTestLanguage.g:6018:3: ruleAbstractToken
            {
             before(grammarAccess.getGroupAccess().getTokensAbstractTokenParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAbstractToken();

            state._fsp--;

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
    // $ANTLR end "rule__Group__TokensAssignment_1_1"


    // $ANTLR start "rule__AbstractTokenWithCardinality__CardinalityAssignment_1"
    // InternalXtextGrammarTestLanguage.g:6027:1: rule__AbstractTokenWithCardinality__CardinalityAssignment_1 : ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) ) ;
    public final void rule__AbstractTokenWithCardinality__CardinalityAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6031:1: ( ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:6032:2: ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:6032:2: ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) )
            // InternalXtextGrammarTestLanguage.g:6033:3: ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 )
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAlternatives_1_0()); 
            // InternalXtextGrammarTestLanguage.g:6034:3: ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 )
            // InternalXtextGrammarTestLanguage.g:6034:4: rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:6042:1: rule__Action__TypeAssignment_1 : ( ruleTypeRef ) ;
    public final void rule__Action__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6046:1: ( ( ruleTypeRef ) )
            // InternalXtextGrammarTestLanguage.g:6047:2: ( ruleTypeRef )
            {
            // InternalXtextGrammarTestLanguage.g:6047:2: ( ruleTypeRef )
            // InternalXtextGrammarTestLanguage.g:6048:3: ruleTypeRef
            {
             before(grammarAccess.getActionAccess().getTypeTypeRefParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:6057:1: rule__Action__FeatureAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__Action__FeatureAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6061:1: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:6062:2: ( RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:6062:2: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:6063:3: RULE_ID
            {
             before(grammarAccess.getActionAccess().getFeatureIDTerminalRuleCall_2_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:6072:1: rule__Action__OperatorAssignment_2_2 : ( ( rule__Action__OperatorAlternatives_2_2_0 ) ) ;
    public final void rule__Action__OperatorAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6076:1: ( ( ( rule__Action__OperatorAlternatives_2_2_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:6077:2: ( ( rule__Action__OperatorAlternatives_2_2_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:6077:2: ( ( rule__Action__OperatorAlternatives_2_2_0 ) )
            // InternalXtextGrammarTestLanguage.g:6078:3: ( rule__Action__OperatorAlternatives_2_2_0 )
            {
             before(grammarAccess.getActionAccess().getOperatorAlternatives_2_2_0()); 
            // InternalXtextGrammarTestLanguage.g:6079:3: ( rule__Action__OperatorAlternatives_2_2_0 )
            // InternalXtextGrammarTestLanguage.g:6079:4: rule__Action__OperatorAlternatives_2_2_0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:6087:1: rule__Keyword__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__Keyword__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6091:1: ( ( RULE_STRING ) )
            // InternalXtextGrammarTestLanguage.g:6092:2: ( RULE_STRING )
            {
            // InternalXtextGrammarTestLanguage.g:6092:2: ( RULE_STRING )
            // InternalXtextGrammarTestLanguage.g:6093:3: RULE_STRING
            {
             before(grammarAccess.getKeywordAccess().getValueSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:6102:1: rule__RuleCall__RuleAssignment : ( ( RULE_ID ) ) ;
    public final void rule__RuleCall__RuleAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6106:1: ( ( ( RULE_ID ) ) )
            // InternalXtextGrammarTestLanguage.g:6107:2: ( ( RULE_ID ) )
            {
            // InternalXtextGrammarTestLanguage.g:6107:2: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:6108:3: ( RULE_ID )
            {
             before(grammarAccess.getRuleCallAccess().getRuleAbstractRuleCrossReference_0()); 
            // InternalXtextGrammarTestLanguage.g:6109:3: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:6110:4: RULE_ID
            {
             before(grammarAccess.getRuleCallAccess().getRuleAbstractRuleIDTerminalRuleCall_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:6121:1: rule__Assignment__FeatureAssignment_0 : ( RULE_ID ) ;
    public final void rule__Assignment__FeatureAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6125:1: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:6126:2: ( RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:6126:2: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:6127:3: RULE_ID
            {
             before(grammarAccess.getAssignmentAccess().getFeatureIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:6136:1: rule__Assignment__OperatorAssignment_1 : ( ( rule__Assignment__OperatorAlternatives_1_0 ) ) ;
    public final void rule__Assignment__OperatorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6140:1: ( ( ( rule__Assignment__OperatorAlternatives_1_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:6141:2: ( ( rule__Assignment__OperatorAlternatives_1_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:6141:2: ( ( rule__Assignment__OperatorAlternatives_1_0 ) )
            // InternalXtextGrammarTestLanguage.g:6142:3: ( rule__Assignment__OperatorAlternatives_1_0 )
            {
             before(grammarAccess.getAssignmentAccess().getOperatorAlternatives_1_0()); 
            // InternalXtextGrammarTestLanguage.g:6143:3: ( rule__Assignment__OperatorAlternatives_1_0 )
            // InternalXtextGrammarTestLanguage.g:6143:4: rule__Assignment__OperatorAlternatives_1_0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:6151:1: rule__Assignment__TerminalAssignment_2 : ( ruleAssignableTerminal ) ;
    public final void rule__Assignment__TerminalAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6155:1: ( ( ruleAssignableTerminal ) )
            // InternalXtextGrammarTestLanguage.g:6156:2: ( ruleAssignableTerminal )
            {
            // InternalXtextGrammarTestLanguage.g:6156:2: ( ruleAssignableTerminal )
            // InternalXtextGrammarTestLanguage.g:6157:3: ruleAssignableTerminal
            {
             before(grammarAccess.getAssignmentAccess().getTerminalAssignableTerminalParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
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


    // $ANTLR start "rule__AssignableAlternatives__GroupsAssignment_1_1_1"
    // InternalXtextGrammarTestLanguage.g:6166:1: rule__AssignableAlternatives__GroupsAssignment_1_1_1 : ( ruleAssignableTerminal ) ;
    public final void rule__AssignableAlternatives__GroupsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6170:1: ( ( ruleAssignableTerminal ) )
            // InternalXtextGrammarTestLanguage.g:6171:2: ( ruleAssignableTerminal )
            {
            // InternalXtextGrammarTestLanguage.g:6171:2: ( ruleAssignableTerminal )
            // InternalXtextGrammarTestLanguage.g:6172:3: ruleAssignableTerminal
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroupsAssignableTerminalParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAssignableTerminal();

            state._fsp--;

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
    // $ANTLR end "rule__AssignableAlternatives__GroupsAssignment_1_1_1"


    // $ANTLR start "rule__CrossReference__TypeAssignment_1"
    // InternalXtextGrammarTestLanguage.g:6181:1: rule__CrossReference__TypeAssignment_1 : ( ruleTypeRef ) ;
    public final void rule__CrossReference__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6185:1: ( ( ruleTypeRef ) )
            // InternalXtextGrammarTestLanguage.g:6186:2: ( ruleTypeRef )
            {
            // InternalXtextGrammarTestLanguage.g:6186:2: ( ruleTypeRef )
            // InternalXtextGrammarTestLanguage.g:6187:3: ruleTypeRef
            {
             before(grammarAccess.getCrossReferenceAccess().getTypeTypeRefParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:6196:1: rule__CrossReference__TerminalAssignment_2_1 : ( ruleCrossReferenceableTerminal ) ;
    public final void rule__CrossReference__TerminalAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6200:1: ( ( ruleCrossReferenceableTerminal ) )
            // InternalXtextGrammarTestLanguage.g:6201:2: ( ruleCrossReferenceableTerminal )
            {
            // InternalXtextGrammarTestLanguage.g:6201:2: ( ruleCrossReferenceableTerminal )
            // InternalXtextGrammarTestLanguage.g:6202:3: ruleCrossReferenceableTerminal
            {
             before(grammarAccess.getCrossReferenceAccess().getTerminalCrossReferenceableTerminalParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
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


    // $ANTLR start "rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1"
    // InternalXtextGrammarTestLanguage.g:6211:1: rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1 : ( ruleCrossReferenceableTerminal ) ;
    public final void rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6215:1: ( ( ruleCrossReferenceableTerminal ) )
            // InternalXtextGrammarTestLanguage.g:6216:2: ( ruleCrossReferenceableTerminal )
            {
            // InternalXtextGrammarTestLanguage.g:6216:2: ( ruleCrossReferenceableTerminal )
            // InternalXtextGrammarTestLanguage.g:6217:3: ruleCrossReferenceableTerminal
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getGroupsCrossReferenceableTerminalParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleCrossReferenceableTerminal();

            state._fsp--;

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
    // $ANTLR end "rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1"


    // $ANTLR start "rule__TerminalRule__NameAssignment_1"
    // InternalXtextGrammarTestLanguage.g:6226:1: rule__TerminalRule__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__TerminalRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6230:1: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:6231:2: ( RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:6231:2: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:6232:3: RULE_ID
            {
             before(grammarAccess.getTerminalRuleAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // $ANTLR end "rule__TerminalRule__NameAssignment_1"


    // $ANTLR start "rule__TerminalRule__TypeAssignment_2_1"
    // InternalXtextGrammarTestLanguage.g:6241:1: rule__TerminalRule__TypeAssignment_2_1 : ( ruleTypeRef ) ;
    public final void rule__TerminalRule__TypeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6245:1: ( ( ruleTypeRef ) )
            // InternalXtextGrammarTestLanguage.g:6246:2: ( ruleTypeRef )
            {
            // InternalXtextGrammarTestLanguage.g:6246:2: ( ruleTypeRef )
            // InternalXtextGrammarTestLanguage.g:6247:3: ruleTypeRef
            {
             before(grammarAccess.getTerminalRuleAccess().getTypeTypeRefParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTypeRef();

            state._fsp--;

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
    // $ANTLR end "rule__TerminalRule__TypeAssignment_2_1"


    // $ANTLR start "rule__TerminalRule__AlternativesAssignment_4"
    // InternalXtextGrammarTestLanguage.g:6256:1: rule__TerminalRule__AlternativesAssignment_4 : ( ruleTerminalAlternatives ) ;
    public final void rule__TerminalRule__AlternativesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6260:1: ( ( ruleTerminalAlternatives ) )
            // InternalXtextGrammarTestLanguage.g:6261:2: ( ruleTerminalAlternatives )
            {
            // InternalXtextGrammarTestLanguage.g:6261:2: ( ruleTerminalAlternatives )
            // InternalXtextGrammarTestLanguage.g:6262:3: ruleTerminalAlternatives
            {
             before(grammarAccess.getTerminalRuleAccess().getAlternativesTerminalAlternativesParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleTerminalAlternatives();

            state._fsp--;

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
    // $ANTLR end "rule__TerminalRule__AlternativesAssignment_4"


    // $ANTLR start "rule__TerminalAlternatives__GroupsAssignment_1_1_1"
    // InternalXtextGrammarTestLanguage.g:6271:1: rule__TerminalAlternatives__GroupsAssignment_1_1_1 : ( ruleTerminalGroup ) ;
    public final void rule__TerminalAlternatives__GroupsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6275:1: ( ( ruleTerminalGroup ) )
            // InternalXtextGrammarTestLanguage.g:6276:2: ( ruleTerminalGroup )
            {
            // InternalXtextGrammarTestLanguage.g:6276:2: ( ruleTerminalGroup )
            // InternalXtextGrammarTestLanguage.g:6277:3: ruleTerminalGroup
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroupsTerminalGroupParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTerminalGroup();

            state._fsp--;

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
    // $ANTLR end "rule__TerminalAlternatives__GroupsAssignment_1_1_1"


    // $ANTLR start "rule__TerminalGroup__TokensAssignment_1_1"
    // InternalXtextGrammarTestLanguage.g:6286:1: rule__TerminalGroup__TokensAssignment_1_1 : ( ruleTerminalToken ) ;
    public final void rule__TerminalGroup__TokensAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6290:1: ( ( ruleTerminalToken ) )
            // InternalXtextGrammarTestLanguage.g:6291:2: ( ruleTerminalToken )
            {
            // InternalXtextGrammarTestLanguage.g:6291:2: ( ruleTerminalToken )
            // InternalXtextGrammarTestLanguage.g:6292:3: ruleTerminalToken
            {
             before(grammarAccess.getTerminalGroupAccess().getTokensTerminalTokenParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTerminalToken();

            state._fsp--;

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
    // $ANTLR end "rule__TerminalGroup__TokensAssignment_1_1"


    // $ANTLR start "rule__TerminalToken__CardinalityAssignment_1"
    // InternalXtextGrammarTestLanguage.g:6301:1: rule__TerminalToken__CardinalityAssignment_1 : ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) ) ;
    public final void rule__TerminalToken__CardinalityAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6305:1: ( ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:6306:2: ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:6306:2: ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) )
            // InternalXtextGrammarTestLanguage.g:6307:3: ( rule__TerminalToken__CardinalityAlternatives_1_0 )
            {
             before(grammarAccess.getTerminalTokenAccess().getCardinalityAlternatives_1_0()); 
            // InternalXtextGrammarTestLanguage.g:6308:3: ( rule__TerminalToken__CardinalityAlternatives_1_0 )
            // InternalXtextGrammarTestLanguage.g:6308:4: rule__TerminalToken__CardinalityAlternatives_1_0
            {
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:6316:1: rule__NegatedToken__TerminalAssignment_1 : ( ruleTerminalTokenElement ) ;
    public final void rule__NegatedToken__TerminalAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6320:1: ( ( ruleTerminalTokenElement ) )
            // InternalXtextGrammarTestLanguage.g:6321:2: ( ruleTerminalTokenElement )
            {
            // InternalXtextGrammarTestLanguage.g:6321:2: ( ruleTerminalTokenElement )
            // InternalXtextGrammarTestLanguage.g:6322:3: ruleTerminalTokenElement
            {
             before(grammarAccess.getNegatedTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:6331:1: rule__UntilToken__TerminalAssignment_1 : ( ruleTerminalTokenElement ) ;
    public final void rule__UntilToken__TerminalAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6335:1: ( ( ruleTerminalTokenElement ) )
            // InternalXtextGrammarTestLanguage.g:6336:2: ( ruleTerminalTokenElement )
            {
            // InternalXtextGrammarTestLanguage.g:6336:2: ( ruleTerminalTokenElement )
            // InternalXtextGrammarTestLanguage.g:6337:3: ruleTerminalTokenElement
            {
             before(grammarAccess.getUntilTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:6346:1: rule__CharacterRange__RightAssignment_1_2 : ( ruleKeyword ) ;
    public final void rule__CharacterRange__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6350:1: ( ( ruleKeyword ) )
            // InternalXtextGrammarTestLanguage.g:6351:2: ( ruleKeyword )
            {
            // InternalXtextGrammarTestLanguage.g:6351:2: ( ruleKeyword )
            // InternalXtextGrammarTestLanguage.g:6352:3: ruleKeyword
            {
             before(grammarAccess.getCharacterRangeAccess().getRightKeywordParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:6361:1: rule__EnumRule__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__EnumRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6365:1: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:6366:2: ( RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:6366:2: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:6367:3: RULE_ID
            {
             before(grammarAccess.getEnumRuleAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:6376:1: rule__EnumRule__TypeAssignment_2_1 : ( ruleTypeRef ) ;
    public final void rule__EnumRule__TypeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6380:1: ( ( ruleTypeRef ) )
            // InternalXtextGrammarTestLanguage.g:6381:2: ( ruleTypeRef )
            {
            // InternalXtextGrammarTestLanguage.g:6381:2: ( ruleTypeRef )
            // InternalXtextGrammarTestLanguage.g:6382:3: ruleTypeRef
            {
             before(grammarAccess.getEnumRuleAccess().getTypeTypeRefParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalXtextGrammarTestLanguage.g:6391:1: rule__EnumRule__AlternativesAssignment_4 : ( ruleEnumLiterals ) ;
    public final void rule__EnumRule__AlternativesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6395:1: ( ( ruleEnumLiterals ) )
            // InternalXtextGrammarTestLanguage.g:6396:2: ( ruleEnumLiterals )
            {
            // InternalXtextGrammarTestLanguage.g:6396:2: ( ruleEnumLiterals )
            // InternalXtextGrammarTestLanguage.g:6397:3: ruleEnumLiterals
            {
             before(grammarAccess.getEnumRuleAccess().getAlternativesEnumLiteralsParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
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


    // $ANTLR start "rule__EnumLiterals__GroupsAssignment_1_1_1"
    // InternalXtextGrammarTestLanguage.g:6406:1: rule__EnumLiterals__GroupsAssignment_1_1_1 : ( ruleEnumLiteralDeclaration ) ;
    public final void rule__EnumLiterals__GroupsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6410:1: ( ( ruleEnumLiteralDeclaration ) )
            // InternalXtextGrammarTestLanguage.g:6411:2: ( ruleEnumLiteralDeclaration )
            {
            // InternalXtextGrammarTestLanguage.g:6411:2: ( ruleEnumLiteralDeclaration )
            // InternalXtextGrammarTestLanguage.g:6412:3: ruleEnumLiteralDeclaration
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroupsEnumLiteralDeclarationParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEnumLiteralDeclaration();

            state._fsp--;

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
    // $ANTLR end "rule__EnumLiterals__GroupsAssignment_1_1_1"


    // $ANTLR start "rule__EnumLiteralDeclaration__EnumLiteralAssignment_0"
    // InternalXtextGrammarTestLanguage.g:6421:1: rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__EnumLiteralDeclaration__EnumLiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6425:1: ( ( ( RULE_ID ) ) )
            // InternalXtextGrammarTestLanguage.g:6426:2: ( ( RULE_ID ) )
            {
            // InternalXtextGrammarTestLanguage.g:6426:2: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:6427:3: ( RULE_ID )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralCrossReference_0_0()); 
            // InternalXtextGrammarTestLanguage.g:6428:3: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:6429:4: RULE_ID
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // InternalXtextGrammarTestLanguage.g:6440:1: rule__EnumLiteralDeclaration__LiteralAssignment_1_1 : ( ruleKeyword ) ;
    public final void rule__EnumLiteralDeclaration__LiteralAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6444:1: ( ( ruleKeyword ) )
            // InternalXtextGrammarTestLanguage.g:6445:2: ( ruleKeyword )
            {
            // InternalXtextGrammarTestLanguage.g:6445:2: ( ruleKeyword )
            // InternalXtextGrammarTestLanguage.g:6446:3: ruleKeyword
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralKeywordParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
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


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000031002840010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000002800002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000031002840012L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000020014000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000080100030L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000080100032L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000003800L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000100400000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x000000000001C000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000400100030L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000840000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000100030L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000006000500030L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000006000500032L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000004000L});

}
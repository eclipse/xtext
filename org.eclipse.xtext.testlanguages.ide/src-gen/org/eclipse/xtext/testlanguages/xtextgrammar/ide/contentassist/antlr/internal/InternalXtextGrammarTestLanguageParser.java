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

/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
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
    // InternalXtextGrammarTestLanguage.g:58:1: entryRuleGrammar : ruleGrammar EOF ;
    public final void entryRuleGrammar() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:59:1: ( ruleGrammar EOF )
            // InternalXtextGrammarTestLanguage.g:60:1: ruleGrammar EOF
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
    // InternalXtextGrammarTestLanguage.g:67:1: ruleGrammar : ( ( rule__Grammar__Group__0 ) ) ;
    public final void ruleGrammar() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:71:2: ( ( ( rule__Grammar__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:72:2: ( ( rule__Grammar__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:72:2: ( ( rule__Grammar__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:73:3: ( rule__Grammar__Group__0 )
            {
             before(grammarAccess.getGrammarAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:74:3: ( rule__Grammar__Group__0 )
            // InternalXtextGrammarTestLanguage.g:74:4: rule__Grammar__Group__0
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
    // InternalXtextGrammarTestLanguage.g:83:1: entryRuleGrammarID : ruleGrammarID EOF ;
    public final void entryRuleGrammarID() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:84:1: ( ruleGrammarID EOF )
            // InternalXtextGrammarTestLanguage.g:85:1: ruleGrammarID EOF
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
    // InternalXtextGrammarTestLanguage.g:92:1: ruleGrammarID : ( ( rule__GrammarID__Group__0 ) ) ;
    public final void ruleGrammarID() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:96:2: ( ( ( rule__GrammarID__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:97:2: ( ( rule__GrammarID__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:97:2: ( ( rule__GrammarID__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:98:3: ( rule__GrammarID__Group__0 )
            {
             before(grammarAccess.getGrammarIDAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:99:3: ( rule__GrammarID__Group__0 )
            // InternalXtextGrammarTestLanguage.g:99:4: rule__GrammarID__Group__0
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
    // InternalXtextGrammarTestLanguage.g:108:1: entryRuleAbstractRule : ruleAbstractRule EOF ;
    public final void entryRuleAbstractRule() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:109:1: ( ruleAbstractRule EOF )
            // InternalXtextGrammarTestLanguage.g:110:1: ruleAbstractRule EOF
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
    // InternalXtextGrammarTestLanguage.g:117:1: ruleAbstractRule : ( ( rule__AbstractRule__Alternatives ) ) ;
    public final void ruleAbstractRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:121:2: ( ( ( rule__AbstractRule__Alternatives ) ) )
            // InternalXtextGrammarTestLanguage.g:122:2: ( ( rule__AbstractRule__Alternatives ) )
            {
            // InternalXtextGrammarTestLanguage.g:122:2: ( ( rule__AbstractRule__Alternatives ) )
            // InternalXtextGrammarTestLanguage.g:123:3: ( rule__AbstractRule__Alternatives )
            {
             before(grammarAccess.getAbstractRuleAccess().getAlternatives()); 
            // InternalXtextGrammarTestLanguage.g:124:3: ( rule__AbstractRule__Alternatives )
            // InternalXtextGrammarTestLanguage.g:124:4: rule__AbstractRule__Alternatives
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
    // InternalXtextGrammarTestLanguage.g:133:1: entryRuleAbstractMetamodelDeclaration : ruleAbstractMetamodelDeclaration EOF ;
    public final void entryRuleAbstractMetamodelDeclaration() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:134:1: ( ruleAbstractMetamodelDeclaration EOF )
            // InternalXtextGrammarTestLanguage.g:135:1: ruleAbstractMetamodelDeclaration EOF
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
    // InternalXtextGrammarTestLanguage.g:142:1: ruleAbstractMetamodelDeclaration : ( ( rule__AbstractMetamodelDeclaration__Alternatives ) ) ;
    public final void ruleAbstractMetamodelDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:146:2: ( ( ( rule__AbstractMetamodelDeclaration__Alternatives ) ) )
            // InternalXtextGrammarTestLanguage.g:147:2: ( ( rule__AbstractMetamodelDeclaration__Alternatives ) )
            {
            // InternalXtextGrammarTestLanguage.g:147:2: ( ( rule__AbstractMetamodelDeclaration__Alternatives ) )
            // InternalXtextGrammarTestLanguage.g:148:3: ( rule__AbstractMetamodelDeclaration__Alternatives )
            {
             before(grammarAccess.getAbstractMetamodelDeclarationAccess().getAlternatives()); 
            // InternalXtextGrammarTestLanguage.g:149:3: ( rule__AbstractMetamodelDeclaration__Alternatives )
            // InternalXtextGrammarTestLanguage.g:149:4: rule__AbstractMetamodelDeclaration__Alternatives
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
    // InternalXtextGrammarTestLanguage.g:158:1: entryRuleGeneratedMetamodel : ruleGeneratedMetamodel EOF ;
    public final void entryRuleGeneratedMetamodel() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:159:1: ( ruleGeneratedMetamodel EOF )
            // InternalXtextGrammarTestLanguage.g:160:1: ruleGeneratedMetamodel EOF
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
    // InternalXtextGrammarTestLanguage.g:167:1: ruleGeneratedMetamodel : ( ( rule__GeneratedMetamodel__Group__0 ) ) ;
    public final void ruleGeneratedMetamodel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:171:2: ( ( ( rule__GeneratedMetamodel__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:172:2: ( ( rule__GeneratedMetamodel__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:172:2: ( ( rule__GeneratedMetamodel__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:173:3: ( rule__GeneratedMetamodel__Group__0 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:174:3: ( rule__GeneratedMetamodel__Group__0 )
            // InternalXtextGrammarTestLanguage.g:174:4: rule__GeneratedMetamodel__Group__0
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
    // InternalXtextGrammarTestLanguage.g:183:1: entryRuleReferencedMetamodel : ruleReferencedMetamodel EOF ;
    public final void entryRuleReferencedMetamodel() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:184:1: ( ruleReferencedMetamodel EOF )
            // InternalXtextGrammarTestLanguage.g:185:1: ruleReferencedMetamodel EOF
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
    // InternalXtextGrammarTestLanguage.g:192:1: ruleReferencedMetamodel : ( ( rule__ReferencedMetamodel__Group__0 ) ) ;
    public final void ruleReferencedMetamodel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:196:2: ( ( ( rule__ReferencedMetamodel__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:197:2: ( ( rule__ReferencedMetamodel__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:197:2: ( ( rule__ReferencedMetamodel__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:198:3: ( rule__ReferencedMetamodel__Group__0 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:199:3: ( rule__ReferencedMetamodel__Group__0 )
            // InternalXtextGrammarTestLanguage.g:199:4: rule__ReferencedMetamodel__Group__0
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
    // InternalXtextGrammarTestLanguage.g:208:1: entryRuleParserRule : ruleParserRule EOF ;
    public final void entryRuleParserRule() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:209:1: ( ruleParserRule EOF )
            // InternalXtextGrammarTestLanguage.g:210:1: ruleParserRule EOF
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
    // InternalXtextGrammarTestLanguage.g:217:1: ruleParserRule : ( ( rule__ParserRule__Group__0 ) ) ;
    public final void ruleParserRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:221:2: ( ( ( rule__ParserRule__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:222:2: ( ( rule__ParserRule__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:222:2: ( ( rule__ParserRule__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:223:3: ( rule__ParserRule__Group__0 )
            {
             before(grammarAccess.getParserRuleAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:224:3: ( rule__ParserRule__Group__0 )
            // InternalXtextGrammarTestLanguage.g:224:4: rule__ParserRule__Group__0
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
    // InternalXtextGrammarTestLanguage.g:233:1: entryRuleTypeRef : ruleTypeRef EOF ;
    public final void entryRuleTypeRef() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:234:1: ( ruleTypeRef EOF )
            // InternalXtextGrammarTestLanguage.g:235:1: ruleTypeRef EOF
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
    // InternalXtextGrammarTestLanguage.g:242:1: ruleTypeRef : ( ( rule__TypeRef__Group__0 ) ) ;
    public final void ruleTypeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:246:2: ( ( ( rule__TypeRef__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:247:2: ( ( rule__TypeRef__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:247:2: ( ( rule__TypeRef__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:248:3: ( rule__TypeRef__Group__0 )
            {
             before(grammarAccess.getTypeRefAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:249:3: ( rule__TypeRef__Group__0 )
            // InternalXtextGrammarTestLanguage.g:249:4: rule__TypeRef__Group__0
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
    // InternalXtextGrammarTestLanguage.g:258:1: entryRuleAlternatives : ruleAlternatives EOF ;
    public final void entryRuleAlternatives() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:259:1: ( ruleAlternatives EOF )
            // InternalXtextGrammarTestLanguage.g:260:1: ruleAlternatives EOF
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
    // InternalXtextGrammarTestLanguage.g:267:1: ruleAlternatives : ( ( rule__Alternatives__Group__0 ) ) ;
    public final void ruleAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:271:2: ( ( ( rule__Alternatives__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:272:2: ( ( rule__Alternatives__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:272:2: ( ( rule__Alternatives__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:273:3: ( rule__Alternatives__Group__0 )
            {
             before(grammarAccess.getAlternativesAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:274:3: ( rule__Alternatives__Group__0 )
            // InternalXtextGrammarTestLanguage.g:274:4: rule__Alternatives__Group__0
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
    // InternalXtextGrammarTestLanguage.g:283:1: entryRuleGroup : ruleGroup EOF ;
    public final void entryRuleGroup() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:284:1: ( ruleGroup EOF )
            // InternalXtextGrammarTestLanguage.g:285:1: ruleGroup EOF
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
    // InternalXtextGrammarTestLanguage.g:292:1: ruleGroup : ( ( rule__Group__Group__0 ) ) ;
    public final void ruleGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:296:2: ( ( ( rule__Group__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:297:2: ( ( rule__Group__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:297:2: ( ( rule__Group__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:298:3: ( rule__Group__Group__0 )
            {
             before(grammarAccess.getGroupAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:299:3: ( rule__Group__Group__0 )
            // InternalXtextGrammarTestLanguage.g:299:4: rule__Group__Group__0
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
    // InternalXtextGrammarTestLanguage.g:308:1: entryRuleAbstractToken : ruleAbstractToken EOF ;
    public final void entryRuleAbstractToken() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:309:1: ( ruleAbstractToken EOF )
            // InternalXtextGrammarTestLanguage.g:310:1: ruleAbstractToken EOF
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
    // InternalXtextGrammarTestLanguage.g:317:1: ruleAbstractToken : ( ( rule__AbstractToken__Alternatives ) ) ;
    public final void ruleAbstractToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:321:2: ( ( ( rule__AbstractToken__Alternatives ) ) )
            // InternalXtextGrammarTestLanguage.g:322:2: ( ( rule__AbstractToken__Alternatives ) )
            {
            // InternalXtextGrammarTestLanguage.g:322:2: ( ( rule__AbstractToken__Alternatives ) )
            // InternalXtextGrammarTestLanguage.g:323:3: ( rule__AbstractToken__Alternatives )
            {
             before(grammarAccess.getAbstractTokenAccess().getAlternatives()); 
            // InternalXtextGrammarTestLanguage.g:324:3: ( rule__AbstractToken__Alternatives )
            // InternalXtextGrammarTestLanguage.g:324:4: rule__AbstractToken__Alternatives
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
    // InternalXtextGrammarTestLanguage.g:333:1: entryRuleAbstractTokenWithCardinality : ruleAbstractTokenWithCardinality EOF ;
    public final void entryRuleAbstractTokenWithCardinality() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:334:1: ( ruleAbstractTokenWithCardinality EOF )
            // InternalXtextGrammarTestLanguage.g:335:1: ruleAbstractTokenWithCardinality EOF
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
    // InternalXtextGrammarTestLanguage.g:342:1: ruleAbstractTokenWithCardinality : ( ( rule__AbstractTokenWithCardinality__Group__0 ) ) ;
    public final void ruleAbstractTokenWithCardinality() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:346:2: ( ( ( rule__AbstractTokenWithCardinality__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:347:2: ( ( rule__AbstractTokenWithCardinality__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:347:2: ( ( rule__AbstractTokenWithCardinality__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:348:3: ( rule__AbstractTokenWithCardinality__Group__0 )
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:349:3: ( rule__AbstractTokenWithCardinality__Group__0 )
            // InternalXtextGrammarTestLanguage.g:349:4: rule__AbstractTokenWithCardinality__Group__0
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
    // InternalXtextGrammarTestLanguage.g:358:1: entryRuleAction : ruleAction EOF ;
    public final void entryRuleAction() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:359:1: ( ruleAction EOF )
            // InternalXtextGrammarTestLanguage.g:360:1: ruleAction EOF
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
    // InternalXtextGrammarTestLanguage.g:367:1: ruleAction : ( ( rule__Action__Group__0 ) ) ;
    public final void ruleAction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:371:2: ( ( ( rule__Action__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:372:2: ( ( rule__Action__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:372:2: ( ( rule__Action__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:373:3: ( rule__Action__Group__0 )
            {
             before(grammarAccess.getActionAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:374:3: ( rule__Action__Group__0 )
            // InternalXtextGrammarTestLanguage.g:374:4: rule__Action__Group__0
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
    // InternalXtextGrammarTestLanguage.g:383:1: entryRuleAbstractTerminal : ruleAbstractTerminal EOF ;
    public final void entryRuleAbstractTerminal() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:384:1: ( ruleAbstractTerminal EOF )
            // InternalXtextGrammarTestLanguage.g:385:1: ruleAbstractTerminal EOF
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
    // InternalXtextGrammarTestLanguage.g:392:1: ruleAbstractTerminal : ( ( rule__AbstractTerminal__Alternatives ) ) ;
    public final void ruleAbstractTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:396:2: ( ( ( rule__AbstractTerminal__Alternatives ) ) )
            // InternalXtextGrammarTestLanguage.g:397:2: ( ( rule__AbstractTerminal__Alternatives ) )
            {
            // InternalXtextGrammarTestLanguage.g:397:2: ( ( rule__AbstractTerminal__Alternatives ) )
            // InternalXtextGrammarTestLanguage.g:398:3: ( rule__AbstractTerminal__Alternatives )
            {
             before(grammarAccess.getAbstractTerminalAccess().getAlternatives()); 
            // InternalXtextGrammarTestLanguage.g:399:3: ( rule__AbstractTerminal__Alternatives )
            // InternalXtextGrammarTestLanguage.g:399:4: rule__AbstractTerminal__Alternatives
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
    // InternalXtextGrammarTestLanguage.g:408:1: entryRuleKeyword : ruleKeyword EOF ;
    public final void entryRuleKeyword() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:409:1: ( ruleKeyword EOF )
            // InternalXtextGrammarTestLanguage.g:410:1: ruleKeyword EOF
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
    // InternalXtextGrammarTestLanguage.g:417:1: ruleKeyword : ( ( rule__Keyword__ValueAssignment ) ) ;
    public final void ruleKeyword() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:421:2: ( ( ( rule__Keyword__ValueAssignment ) ) )
            // InternalXtextGrammarTestLanguage.g:422:2: ( ( rule__Keyword__ValueAssignment ) )
            {
            // InternalXtextGrammarTestLanguage.g:422:2: ( ( rule__Keyword__ValueAssignment ) )
            // InternalXtextGrammarTestLanguage.g:423:3: ( rule__Keyword__ValueAssignment )
            {
             before(grammarAccess.getKeywordAccess().getValueAssignment()); 
            // InternalXtextGrammarTestLanguage.g:424:3: ( rule__Keyword__ValueAssignment )
            // InternalXtextGrammarTestLanguage.g:424:4: rule__Keyword__ValueAssignment
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
    // InternalXtextGrammarTestLanguage.g:433:1: entryRuleRuleCall : ruleRuleCall EOF ;
    public final void entryRuleRuleCall() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:434:1: ( ruleRuleCall EOF )
            // InternalXtextGrammarTestLanguage.g:435:1: ruleRuleCall EOF
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
    // InternalXtextGrammarTestLanguage.g:442:1: ruleRuleCall : ( ( rule__RuleCall__RuleAssignment ) ) ;
    public final void ruleRuleCall() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:446:2: ( ( ( rule__RuleCall__RuleAssignment ) ) )
            // InternalXtextGrammarTestLanguage.g:447:2: ( ( rule__RuleCall__RuleAssignment ) )
            {
            // InternalXtextGrammarTestLanguage.g:447:2: ( ( rule__RuleCall__RuleAssignment ) )
            // InternalXtextGrammarTestLanguage.g:448:3: ( rule__RuleCall__RuleAssignment )
            {
             before(grammarAccess.getRuleCallAccess().getRuleAssignment()); 
            // InternalXtextGrammarTestLanguage.g:449:3: ( rule__RuleCall__RuleAssignment )
            // InternalXtextGrammarTestLanguage.g:449:4: rule__RuleCall__RuleAssignment
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
    // InternalXtextGrammarTestLanguage.g:458:1: entryRuleAssignment : ruleAssignment EOF ;
    public final void entryRuleAssignment() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:459:1: ( ruleAssignment EOF )
            // InternalXtextGrammarTestLanguage.g:460:1: ruleAssignment EOF
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
    // InternalXtextGrammarTestLanguage.g:467:1: ruleAssignment : ( ( rule__Assignment__Group__0 ) ) ;
    public final void ruleAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:471:2: ( ( ( rule__Assignment__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:472:2: ( ( rule__Assignment__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:472:2: ( ( rule__Assignment__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:473:3: ( rule__Assignment__Group__0 )
            {
             before(grammarAccess.getAssignmentAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:474:3: ( rule__Assignment__Group__0 )
            // InternalXtextGrammarTestLanguage.g:474:4: rule__Assignment__Group__0
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
    // InternalXtextGrammarTestLanguage.g:483:1: entryRuleAssignableTerminal : ruleAssignableTerminal EOF ;
    public final void entryRuleAssignableTerminal() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:484:1: ( ruleAssignableTerminal EOF )
            // InternalXtextGrammarTestLanguage.g:485:1: ruleAssignableTerminal EOF
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
    // InternalXtextGrammarTestLanguage.g:492:1: ruleAssignableTerminal : ( ( rule__AssignableTerminal__Alternatives ) ) ;
    public final void ruleAssignableTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:496:2: ( ( ( rule__AssignableTerminal__Alternatives ) ) )
            // InternalXtextGrammarTestLanguage.g:497:2: ( ( rule__AssignableTerminal__Alternatives ) )
            {
            // InternalXtextGrammarTestLanguage.g:497:2: ( ( rule__AssignableTerminal__Alternatives ) )
            // InternalXtextGrammarTestLanguage.g:498:3: ( rule__AssignableTerminal__Alternatives )
            {
             before(grammarAccess.getAssignableTerminalAccess().getAlternatives()); 
            // InternalXtextGrammarTestLanguage.g:499:3: ( rule__AssignableTerminal__Alternatives )
            // InternalXtextGrammarTestLanguage.g:499:4: rule__AssignableTerminal__Alternatives
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
    // InternalXtextGrammarTestLanguage.g:508:1: entryRuleParenthesizedAssignableElement : ruleParenthesizedAssignableElement EOF ;
    public final void entryRuleParenthesizedAssignableElement() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:509:1: ( ruleParenthesizedAssignableElement EOF )
            // InternalXtextGrammarTestLanguage.g:510:1: ruleParenthesizedAssignableElement EOF
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
    // InternalXtextGrammarTestLanguage.g:517:1: ruleParenthesizedAssignableElement : ( ( rule__ParenthesizedAssignableElement__Group__0 ) ) ;
    public final void ruleParenthesizedAssignableElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:521:2: ( ( ( rule__ParenthesizedAssignableElement__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:522:2: ( ( rule__ParenthesizedAssignableElement__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:522:2: ( ( rule__ParenthesizedAssignableElement__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:523:3: ( rule__ParenthesizedAssignableElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:524:3: ( rule__ParenthesizedAssignableElement__Group__0 )
            // InternalXtextGrammarTestLanguage.g:524:4: rule__ParenthesizedAssignableElement__Group__0
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
    // InternalXtextGrammarTestLanguage.g:533:1: entryRuleAssignableAlternatives : ruleAssignableAlternatives EOF ;
    public final void entryRuleAssignableAlternatives() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:534:1: ( ruleAssignableAlternatives EOF )
            // InternalXtextGrammarTestLanguage.g:535:1: ruleAssignableAlternatives EOF
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
    // InternalXtextGrammarTestLanguage.g:542:1: ruleAssignableAlternatives : ( ( rule__AssignableAlternatives__Group__0 ) ) ;
    public final void ruleAssignableAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:546:2: ( ( ( rule__AssignableAlternatives__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:547:2: ( ( rule__AssignableAlternatives__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:547:2: ( ( rule__AssignableAlternatives__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:548:3: ( rule__AssignableAlternatives__Group__0 )
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:549:3: ( rule__AssignableAlternatives__Group__0 )
            // InternalXtextGrammarTestLanguage.g:549:4: rule__AssignableAlternatives__Group__0
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
    // InternalXtextGrammarTestLanguage.g:558:1: entryRuleCrossReference : ruleCrossReference EOF ;
    public final void entryRuleCrossReference() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:559:1: ( ruleCrossReference EOF )
            // InternalXtextGrammarTestLanguage.g:560:1: ruleCrossReference EOF
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
    // InternalXtextGrammarTestLanguage.g:567:1: ruleCrossReference : ( ( rule__CrossReference__Group__0 ) ) ;
    public final void ruleCrossReference() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:571:2: ( ( ( rule__CrossReference__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:572:2: ( ( rule__CrossReference__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:572:2: ( ( rule__CrossReference__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:573:3: ( rule__CrossReference__Group__0 )
            {
             before(grammarAccess.getCrossReferenceAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:574:3: ( rule__CrossReference__Group__0 )
            // InternalXtextGrammarTestLanguage.g:574:4: rule__CrossReference__Group__0
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
    // InternalXtextGrammarTestLanguage.g:583:1: entryRuleCrossReferenceableTerminal : ruleCrossReferenceableTerminal EOF ;
    public final void entryRuleCrossReferenceableTerminal() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:584:1: ( ruleCrossReferenceableTerminal EOF )
            // InternalXtextGrammarTestLanguage.g:585:1: ruleCrossReferenceableTerminal EOF
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
    // InternalXtextGrammarTestLanguage.g:592:1: ruleCrossReferenceableTerminal : ( ( rule__CrossReferenceableTerminal__Alternatives ) ) ;
    public final void ruleCrossReferenceableTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:596:2: ( ( ( rule__CrossReferenceableTerminal__Alternatives ) ) )
            // InternalXtextGrammarTestLanguage.g:597:2: ( ( rule__CrossReferenceableTerminal__Alternatives ) )
            {
            // InternalXtextGrammarTestLanguage.g:597:2: ( ( rule__CrossReferenceableTerminal__Alternatives ) )
            // InternalXtextGrammarTestLanguage.g:598:3: ( rule__CrossReferenceableTerminal__Alternatives )
            {
             before(grammarAccess.getCrossReferenceableTerminalAccess().getAlternatives()); 
            // InternalXtextGrammarTestLanguage.g:599:3: ( rule__CrossReferenceableTerminal__Alternatives )
            // InternalXtextGrammarTestLanguage.g:599:4: rule__CrossReferenceableTerminal__Alternatives
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
    // InternalXtextGrammarTestLanguage.g:608:1: entryRuleParenthesizedCrossReferenceableElement : ruleParenthesizedCrossReferenceableElement EOF ;
    public final void entryRuleParenthesizedCrossReferenceableElement() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:609:1: ( ruleParenthesizedCrossReferenceableElement EOF )
            // InternalXtextGrammarTestLanguage.g:610:1: ruleParenthesizedCrossReferenceableElement EOF
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
    // InternalXtextGrammarTestLanguage.g:617:1: ruleParenthesizedCrossReferenceableElement : ( ( rule__ParenthesizedCrossReferenceableElement__Group__0 ) ) ;
    public final void ruleParenthesizedCrossReferenceableElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:621:2: ( ( ( rule__ParenthesizedCrossReferenceableElement__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:622:2: ( ( rule__ParenthesizedCrossReferenceableElement__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:622:2: ( ( rule__ParenthesizedCrossReferenceableElement__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:623:3: ( rule__ParenthesizedCrossReferenceableElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedCrossReferenceableElementAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:624:3: ( rule__ParenthesizedCrossReferenceableElement__Group__0 )
            // InternalXtextGrammarTestLanguage.g:624:4: rule__ParenthesizedCrossReferenceableElement__Group__0
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
    // InternalXtextGrammarTestLanguage.g:633:1: entryRuleCrossReferenceableAlternatives : ruleCrossReferenceableAlternatives EOF ;
    public final void entryRuleCrossReferenceableAlternatives() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:634:1: ( ruleCrossReferenceableAlternatives EOF )
            // InternalXtextGrammarTestLanguage.g:635:1: ruleCrossReferenceableAlternatives EOF
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
    // InternalXtextGrammarTestLanguage.g:642:1: ruleCrossReferenceableAlternatives : ( ( rule__CrossReferenceableAlternatives__Group__0 ) ) ;
    public final void ruleCrossReferenceableAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:646:2: ( ( ( rule__CrossReferenceableAlternatives__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:647:2: ( ( rule__CrossReferenceableAlternatives__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:647:2: ( ( rule__CrossReferenceableAlternatives__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:648:3: ( rule__CrossReferenceableAlternatives__Group__0 )
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:649:3: ( rule__CrossReferenceableAlternatives__Group__0 )
            // InternalXtextGrammarTestLanguage.g:649:4: rule__CrossReferenceableAlternatives__Group__0
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
    // InternalXtextGrammarTestLanguage.g:658:1: entryRuleParenthesizedElement : ruleParenthesizedElement EOF ;
    public final void entryRuleParenthesizedElement() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:659:1: ( ruleParenthesizedElement EOF )
            // InternalXtextGrammarTestLanguage.g:660:1: ruleParenthesizedElement EOF
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
    // InternalXtextGrammarTestLanguage.g:667:1: ruleParenthesizedElement : ( ( rule__ParenthesizedElement__Group__0 ) ) ;
    public final void ruleParenthesizedElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:671:2: ( ( ( rule__ParenthesizedElement__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:672:2: ( ( rule__ParenthesizedElement__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:672:2: ( ( rule__ParenthesizedElement__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:673:3: ( rule__ParenthesizedElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedElementAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:674:3: ( rule__ParenthesizedElement__Group__0 )
            // InternalXtextGrammarTestLanguage.g:674:4: rule__ParenthesizedElement__Group__0
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
    // InternalXtextGrammarTestLanguage.g:683:1: entryRuleTerminalRule : ruleTerminalRule EOF ;
    public final void entryRuleTerminalRule() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:684:1: ( ruleTerminalRule EOF )
            // InternalXtextGrammarTestLanguage.g:685:1: ruleTerminalRule EOF
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
    // InternalXtextGrammarTestLanguage.g:692:1: ruleTerminalRule : ( ( rule__TerminalRule__Group__0 ) ) ;
    public final void ruleTerminalRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:696:2: ( ( ( rule__TerminalRule__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:697:2: ( ( rule__TerminalRule__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:697:2: ( ( rule__TerminalRule__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:698:3: ( rule__TerminalRule__Group__0 )
            {
             before(grammarAccess.getTerminalRuleAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:699:3: ( rule__TerminalRule__Group__0 )
            // InternalXtextGrammarTestLanguage.g:699:4: rule__TerminalRule__Group__0
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
    // InternalXtextGrammarTestLanguage.g:708:1: entryRuleTerminalAlternatives : ruleTerminalAlternatives EOF ;
    public final void entryRuleTerminalAlternatives() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:709:1: ( ruleTerminalAlternatives EOF )
            // InternalXtextGrammarTestLanguage.g:710:1: ruleTerminalAlternatives EOF
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
    // InternalXtextGrammarTestLanguage.g:717:1: ruleTerminalAlternatives : ( ( rule__TerminalAlternatives__Group__0 ) ) ;
    public final void ruleTerminalAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:721:2: ( ( ( rule__TerminalAlternatives__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:722:2: ( ( rule__TerminalAlternatives__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:722:2: ( ( rule__TerminalAlternatives__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:723:3: ( rule__TerminalAlternatives__Group__0 )
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:724:3: ( rule__TerminalAlternatives__Group__0 )
            // InternalXtextGrammarTestLanguage.g:724:4: rule__TerminalAlternatives__Group__0
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
    // InternalXtextGrammarTestLanguage.g:733:1: entryRuleTerminalGroup : ruleTerminalGroup EOF ;
    public final void entryRuleTerminalGroup() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:734:1: ( ruleTerminalGroup EOF )
            // InternalXtextGrammarTestLanguage.g:735:1: ruleTerminalGroup EOF
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
    // InternalXtextGrammarTestLanguage.g:742:1: ruleTerminalGroup : ( ( rule__TerminalGroup__Group__0 ) ) ;
    public final void ruleTerminalGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:746:2: ( ( ( rule__TerminalGroup__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:747:2: ( ( rule__TerminalGroup__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:747:2: ( ( rule__TerminalGroup__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:748:3: ( rule__TerminalGroup__Group__0 )
            {
             before(grammarAccess.getTerminalGroupAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:749:3: ( rule__TerminalGroup__Group__0 )
            // InternalXtextGrammarTestLanguage.g:749:4: rule__TerminalGroup__Group__0
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
    // InternalXtextGrammarTestLanguage.g:758:1: entryRuleTerminalToken : ruleTerminalToken EOF ;
    public final void entryRuleTerminalToken() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:759:1: ( ruleTerminalToken EOF )
            // InternalXtextGrammarTestLanguage.g:760:1: ruleTerminalToken EOF
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
    // InternalXtextGrammarTestLanguage.g:767:1: ruleTerminalToken : ( ( rule__TerminalToken__Group__0 ) ) ;
    public final void ruleTerminalToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:771:2: ( ( ( rule__TerminalToken__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:772:2: ( ( rule__TerminalToken__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:772:2: ( ( rule__TerminalToken__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:773:3: ( rule__TerminalToken__Group__0 )
            {
             before(grammarAccess.getTerminalTokenAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:774:3: ( rule__TerminalToken__Group__0 )
            // InternalXtextGrammarTestLanguage.g:774:4: rule__TerminalToken__Group__0
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
    // InternalXtextGrammarTestLanguage.g:783:1: entryRuleTerminalTokenElement : ruleTerminalTokenElement EOF ;
    public final void entryRuleTerminalTokenElement() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:784:1: ( ruleTerminalTokenElement EOF )
            // InternalXtextGrammarTestLanguage.g:785:1: ruleTerminalTokenElement EOF
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
    // InternalXtextGrammarTestLanguage.g:792:1: ruleTerminalTokenElement : ( ( rule__TerminalTokenElement__Alternatives ) ) ;
    public final void ruleTerminalTokenElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:796:2: ( ( ( rule__TerminalTokenElement__Alternatives ) ) )
            // InternalXtextGrammarTestLanguage.g:797:2: ( ( rule__TerminalTokenElement__Alternatives ) )
            {
            // InternalXtextGrammarTestLanguage.g:797:2: ( ( rule__TerminalTokenElement__Alternatives ) )
            // InternalXtextGrammarTestLanguage.g:798:3: ( rule__TerminalTokenElement__Alternatives )
            {
             before(grammarAccess.getTerminalTokenElementAccess().getAlternatives()); 
            // InternalXtextGrammarTestLanguage.g:799:3: ( rule__TerminalTokenElement__Alternatives )
            // InternalXtextGrammarTestLanguage.g:799:4: rule__TerminalTokenElement__Alternatives
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
    // InternalXtextGrammarTestLanguage.g:808:1: entryRuleParenthesizedTerminalElement : ruleParenthesizedTerminalElement EOF ;
    public final void entryRuleParenthesizedTerminalElement() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:809:1: ( ruleParenthesizedTerminalElement EOF )
            // InternalXtextGrammarTestLanguage.g:810:1: ruleParenthesizedTerminalElement EOF
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
    // InternalXtextGrammarTestLanguage.g:817:1: ruleParenthesizedTerminalElement : ( ( rule__ParenthesizedTerminalElement__Group__0 ) ) ;
    public final void ruleParenthesizedTerminalElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:821:2: ( ( ( rule__ParenthesizedTerminalElement__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:822:2: ( ( rule__ParenthesizedTerminalElement__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:822:2: ( ( rule__ParenthesizedTerminalElement__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:823:3: ( rule__ParenthesizedTerminalElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:824:3: ( rule__ParenthesizedTerminalElement__Group__0 )
            // InternalXtextGrammarTestLanguage.g:824:4: rule__ParenthesizedTerminalElement__Group__0
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
    // InternalXtextGrammarTestLanguage.g:833:1: entryRuleAbstractNegatedToken : ruleAbstractNegatedToken EOF ;
    public final void entryRuleAbstractNegatedToken() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:834:1: ( ruleAbstractNegatedToken EOF )
            // InternalXtextGrammarTestLanguage.g:835:1: ruleAbstractNegatedToken EOF
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
    // InternalXtextGrammarTestLanguage.g:842:1: ruleAbstractNegatedToken : ( ( rule__AbstractNegatedToken__Alternatives ) ) ;
    public final void ruleAbstractNegatedToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:846:2: ( ( ( rule__AbstractNegatedToken__Alternatives ) ) )
            // InternalXtextGrammarTestLanguage.g:847:2: ( ( rule__AbstractNegatedToken__Alternatives ) )
            {
            // InternalXtextGrammarTestLanguage.g:847:2: ( ( rule__AbstractNegatedToken__Alternatives ) )
            // InternalXtextGrammarTestLanguage.g:848:3: ( rule__AbstractNegatedToken__Alternatives )
            {
             before(grammarAccess.getAbstractNegatedTokenAccess().getAlternatives()); 
            // InternalXtextGrammarTestLanguage.g:849:3: ( rule__AbstractNegatedToken__Alternatives )
            // InternalXtextGrammarTestLanguage.g:849:4: rule__AbstractNegatedToken__Alternatives
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
    // InternalXtextGrammarTestLanguage.g:858:1: entryRuleNegatedToken : ruleNegatedToken EOF ;
    public final void entryRuleNegatedToken() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:859:1: ( ruleNegatedToken EOF )
            // InternalXtextGrammarTestLanguage.g:860:1: ruleNegatedToken EOF
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
    // InternalXtextGrammarTestLanguage.g:867:1: ruleNegatedToken : ( ( rule__NegatedToken__Group__0 ) ) ;
    public final void ruleNegatedToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:871:2: ( ( ( rule__NegatedToken__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:872:2: ( ( rule__NegatedToken__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:872:2: ( ( rule__NegatedToken__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:873:3: ( rule__NegatedToken__Group__0 )
            {
             before(grammarAccess.getNegatedTokenAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:874:3: ( rule__NegatedToken__Group__0 )
            // InternalXtextGrammarTestLanguage.g:874:4: rule__NegatedToken__Group__0
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
    // InternalXtextGrammarTestLanguage.g:883:1: entryRuleUntilToken : ruleUntilToken EOF ;
    public final void entryRuleUntilToken() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:884:1: ( ruleUntilToken EOF )
            // InternalXtextGrammarTestLanguage.g:885:1: ruleUntilToken EOF
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
    // InternalXtextGrammarTestLanguage.g:892:1: ruleUntilToken : ( ( rule__UntilToken__Group__0 ) ) ;
    public final void ruleUntilToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:896:2: ( ( ( rule__UntilToken__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:897:2: ( ( rule__UntilToken__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:897:2: ( ( rule__UntilToken__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:898:3: ( rule__UntilToken__Group__0 )
            {
             before(grammarAccess.getUntilTokenAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:899:3: ( rule__UntilToken__Group__0 )
            // InternalXtextGrammarTestLanguage.g:899:4: rule__UntilToken__Group__0
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
    // InternalXtextGrammarTestLanguage.g:908:1: entryRuleWildcard : ruleWildcard EOF ;
    public final void entryRuleWildcard() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:909:1: ( ruleWildcard EOF )
            // InternalXtextGrammarTestLanguage.g:910:1: ruleWildcard EOF
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
    // InternalXtextGrammarTestLanguage.g:917:1: ruleWildcard : ( ( rule__Wildcard__Group__0 ) ) ;
    public final void ruleWildcard() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:921:2: ( ( ( rule__Wildcard__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:922:2: ( ( rule__Wildcard__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:922:2: ( ( rule__Wildcard__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:923:3: ( rule__Wildcard__Group__0 )
            {
             before(grammarAccess.getWildcardAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:924:3: ( rule__Wildcard__Group__0 )
            // InternalXtextGrammarTestLanguage.g:924:4: rule__Wildcard__Group__0
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
    // InternalXtextGrammarTestLanguage.g:933:1: entryRuleCharacterRange : ruleCharacterRange EOF ;
    public final void entryRuleCharacterRange() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:934:1: ( ruleCharacterRange EOF )
            // InternalXtextGrammarTestLanguage.g:935:1: ruleCharacterRange EOF
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
    // InternalXtextGrammarTestLanguage.g:942:1: ruleCharacterRange : ( ( rule__CharacterRange__Group__0 ) ) ;
    public final void ruleCharacterRange() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:946:2: ( ( ( rule__CharacterRange__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:947:2: ( ( rule__CharacterRange__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:947:2: ( ( rule__CharacterRange__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:948:3: ( rule__CharacterRange__Group__0 )
            {
             before(grammarAccess.getCharacterRangeAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:949:3: ( rule__CharacterRange__Group__0 )
            // InternalXtextGrammarTestLanguage.g:949:4: rule__CharacterRange__Group__0
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
    // InternalXtextGrammarTestLanguage.g:958:1: entryRuleEnumRule : ruleEnumRule EOF ;
    public final void entryRuleEnumRule() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:959:1: ( ruleEnumRule EOF )
            // InternalXtextGrammarTestLanguage.g:960:1: ruleEnumRule EOF
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
    // InternalXtextGrammarTestLanguage.g:967:1: ruleEnumRule : ( ( rule__EnumRule__Group__0 ) ) ;
    public final void ruleEnumRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:971:2: ( ( ( rule__EnumRule__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:972:2: ( ( rule__EnumRule__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:972:2: ( ( rule__EnumRule__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:973:3: ( rule__EnumRule__Group__0 )
            {
             before(grammarAccess.getEnumRuleAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:974:3: ( rule__EnumRule__Group__0 )
            // InternalXtextGrammarTestLanguage.g:974:4: rule__EnumRule__Group__0
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
    // InternalXtextGrammarTestLanguage.g:983:1: entryRuleEnumLiterals : ruleEnumLiterals EOF ;
    public final void entryRuleEnumLiterals() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:984:1: ( ruleEnumLiterals EOF )
            // InternalXtextGrammarTestLanguage.g:985:1: ruleEnumLiterals EOF
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
    // InternalXtextGrammarTestLanguage.g:992:1: ruleEnumLiterals : ( ( rule__EnumLiterals__Group__0 ) ) ;
    public final void ruleEnumLiterals() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:996:2: ( ( ( rule__EnumLiterals__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:997:2: ( ( rule__EnumLiterals__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:997:2: ( ( rule__EnumLiterals__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:998:3: ( rule__EnumLiterals__Group__0 )
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:999:3: ( rule__EnumLiterals__Group__0 )
            // InternalXtextGrammarTestLanguage.g:999:4: rule__EnumLiterals__Group__0
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
    // InternalXtextGrammarTestLanguage.g:1008:1: entryRuleEnumLiteralDeclaration : ruleEnumLiteralDeclaration EOF ;
    public final void entryRuleEnumLiteralDeclaration() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:1009:1: ( ruleEnumLiteralDeclaration EOF )
            // InternalXtextGrammarTestLanguage.g:1010:1: ruleEnumLiteralDeclaration EOF
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
    // InternalXtextGrammarTestLanguage.g:1017:1: ruleEnumLiteralDeclaration : ( ( rule__EnumLiteralDeclaration__Group__0 ) ) ;
    public final void ruleEnumLiteralDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1021:2: ( ( ( rule__EnumLiteralDeclaration__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:1022:2: ( ( rule__EnumLiteralDeclaration__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:1022:2: ( ( rule__EnumLiteralDeclaration__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:1023:3: ( rule__EnumLiteralDeclaration__Group__0 )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:1024:3: ( rule__EnumLiteralDeclaration__Group__0 )
            // InternalXtextGrammarTestLanguage.g:1024:4: rule__EnumLiteralDeclaration__Group__0
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
    // InternalXtextGrammarTestLanguage.g:1032:1: rule__AbstractRule__Alternatives : ( ( ruleParserRule ) | ( ruleTerminalRule ) | ( ruleEnumRule ) );
    public final void rule__AbstractRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1036:1: ( ( ruleParserRule ) | ( ruleTerminalRule ) | ( ruleEnumRule ) )
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
                    // InternalXtextGrammarTestLanguage.g:1037:2: ( ruleParserRule )
                    {
                    // InternalXtextGrammarTestLanguage.g:1037:2: ( ruleParserRule )
                    // InternalXtextGrammarTestLanguage.g:1038:3: ruleParserRule
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
                    // InternalXtextGrammarTestLanguage.g:1043:2: ( ruleTerminalRule )
                    {
                    // InternalXtextGrammarTestLanguage.g:1043:2: ( ruleTerminalRule )
                    // InternalXtextGrammarTestLanguage.g:1044:3: ruleTerminalRule
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
                    // InternalXtextGrammarTestLanguage.g:1049:2: ( ruleEnumRule )
                    {
                    // InternalXtextGrammarTestLanguage.g:1049:2: ( ruleEnumRule )
                    // InternalXtextGrammarTestLanguage.g:1050:3: ruleEnumRule
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
    // InternalXtextGrammarTestLanguage.g:1059:1: rule__AbstractMetamodelDeclaration__Alternatives : ( ( ruleGeneratedMetamodel ) | ( ruleReferencedMetamodel ) );
    public final void rule__AbstractMetamodelDeclaration__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1063:1: ( ( ruleGeneratedMetamodel ) | ( ruleReferencedMetamodel ) )
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
                    // InternalXtextGrammarTestLanguage.g:1064:2: ( ruleGeneratedMetamodel )
                    {
                    // InternalXtextGrammarTestLanguage.g:1064:2: ( ruleGeneratedMetamodel )
                    // InternalXtextGrammarTestLanguage.g:1065:3: ruleGeneratedMetamodel
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
                    // InternalXtextGrammarTestLanguage.g:1070:2: ( ruleReferencedMetamodel )
                    {
                    // InternalXtextGrammarTestLanguage.g:1070:2: ( ruleReferencedMetamodel )
                    // InternalXtextGrammarTestLanguage.g:1071:3: ruleReferencedMetamodel
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
    // InternalXtextGrammarTestLanguage.g:1080:1: rule__AbstractToken__Alternatives : ( ( ruleAbstractTokenWithCardinality ) | ( ruleAction ) );
    public final void rule__AbstractToken__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1084:1: ( ( ruleAbstractTokenWithCardinality ) | ( ruleAction ) )
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
                    // InternalXtextGrammarTestLanguage.g:1085:2: ( ruleAbstractTokenWithCardinality )
                    {
                    // InternalXtextGrammarTestLanguage.g:1085:2: ( ruleAbstractTokenWithCardinality )
                    // InternalXtextGrammarTestLanguage.g:1086:3: ruleAbstractTokenWithCardinality
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
                    // InternalXtextGrammarTestLanguage.g:1091:2: ( ruleAction )
                    {
                    // InternalXtextGrammarTestLanguage.g:1091:2: ( ruleAction )
                    // InternalXtextGrammarTestLanguage.g:1092:3: ruleAction
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
    // InternalXtextGrammarTestLanguage.g:1101:1: rule__AbstractTokenWithCardinality__Alternatives_0 : ( ( ruleAssignment ) | ( ruleAbstractTerminal ) );
    public final void rule__AbstractTokenWithCardinality__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1105:1: ( ( ruleAssignment ) | ( ruleAbstractTerminal ) )
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
                    // InternalXtextGrammarTestLanguage.g:1106:2: ( ruleAssignment )
                    {
                    // InternalXtextGrammarTestLanguage.g:1106:2: ( ruleAssignment )
                    // InternalXtextGrammarTestLanguage.g:1107:3: ruleAssignment
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
                    // InternalXtextGrammarTestLanguage.g:1112:2: ( ruleAbstractTerminal )
                    {
                    // InternalXtextGrammarTestLanguage.g:1112:2: ( ruleAbstractTerminal )
                    // InternalXtextGrammarTestLanguage.g:1113:3: ruleAbstractTerminal
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
    // InternalXtextGrammarTestLanguage.g:1122:1: rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 : ( ( '?' ) | ( '*' ) | ( '+' ) );
    public final void rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1126:1: ( ( '?' ) | ( '*' ) | ( '+' ) )
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
                    // InternalXtextGrammarTestLanguage.g:1127:2: ( '?' )
                    {
                    // InternalXtextGrammarTestLanguage.g:1127:2: ( '?' )
                    // InternalXtextGrammarTestLanguage.g:1128:3: '?'
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1133:2: ( '*' )
                    {
                    // InternalXtextGrammarTestLanguage.g:1133:2: ( '*' )
                    // InternalXtextGrammarTestLanguage.g:1134:3: '*'
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAsteriskKeyword_1_0_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAsteriskKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtextGrammarTestLanguage.g:1139:2: ( '+' )
                    {
                    // InternalXtextGrammarTestLanguage.g:1139:2: ( '+' )
                    // InternalXtextGrammarTestLanguage.g:1140:3: '+'
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
    // InternalXtextGrammarTestLanguage.g:1149:1: rule__Action__OperatorAlternatives_2_2_0 : ( ( '=' ) | ( '+=' ) );
    public final void rule__Action__OperatorAlternatives_2_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1153:1: ( ( '=' ) | ( '+=' ) )
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
                    // InternalXtextGrammarTestLanguage.g:1154:2: ( '=' )
                    {
                    // InternalXtextGrammarTestLanguage.g:1154:2: ( '=' )
                    // InternalXtextGrammarTestLanguage.g:1155:3: '='
                    {
                     before(grammarAccess.getActionAccess().getOperatorEqualsSignKeyword_2_2_0_0()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getActionAccess().getOperatorEqualsSignKeyword_2_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1160:2: ( '+=' )
                    {
                    // InternalXtextGrammarTestLanguage.g:1160:2: ( '+=' )
                    // InternalXtextGrammarTestLanguage.g:1161:3: '+='
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
    // InternalXtextGrammarTestLanguage.g:1170:1: rule__AbstractTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedElement ) );
    public final void rule__AbstractTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1174:1: ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedElement ) )
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
                    // InternalXtextGrammarTestLanguage.g:1175:2: ( ruleKeyword )
                    {
                    // InternalXtextGrammarTestLanguage.g:1175:2: ( ruleKeyword )
                    // InternalXtextGrammarTestLanguage.g:1176:3: ruleKeyword
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
                    // InternalXtextGrammarTestLanguage.g:1181:2: ( ruleRuleCall )
                    {
                    // InternalXtextGrammarTestLanguage.g:1181:2: ( ruleRuleCall )
                    // InternalXtextGrammarTestLanguage.g:1182:3: ruleRuleCall
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
                    // InternalXtextGrammarTestLanguage.g:1187:2: ( ruleParenthesizedElement )
                    {
                    // InternalXtextGrammarTestLanguage.g:1187:2: ( ruleParenthesizedElement )
                    // InternalXtextGrammarTestLanguage.g:1188:3: ruleParenthesizedElement
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
    // InternalXtextGrammarTestLanguage.g:1197:1: rule__Assignment__OperatorAlternatives_1_0 : ( ( '+=' ) | ( '=' ) | ( '?=' ) );
    public final void rule__Assignment__OperatorAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1201:1: ( ( '+=' ) | ( '=' ) | ( '?=' ) )
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
                    // InternalXtextGrammarTestLanguage.g:1202:2: ( '+=' )
                    {
                    // InternalXtextGrammarTestLanguage.g:1202:2: ( '+=' )
                    // InternalXtextGrammarTestLanguage.g:1203:3: '+='
                    {
                     before(grammarAccess.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_1_0_0()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1208:2: ( '=' )
                    {
                    // InternalXtextGrammarTestLanguage.g:1208:2: ( '=' )
                    // InternalXtextGrammarTestLanguage.g:1209:3: '='
                    {
                     before(grammarAccess.getAssignmentAccess().getOperatorEqualsSignKeyword_1_0_1()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getAssignmentAccess().getOperatorEqualsSignKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtextGrammarTestLanguage.g:1214:2: ( '?=' )
                    {
                    // InternalXtextGrammarTestLanguage.g:1214:2: ( '?=' )
                    // InternalXtextGrammarTestLanguage.g:1215:3: '?='
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
    // InternalXtextGrammarTestLanguage.g:1224:1: rule__AssignableTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedAssignableElement ) | ( ruleCrossReference ) );
    public final void rule__AssignableTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1228:1: ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedAssignableElement ) | ( ruleCrossReference ) )
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
                    // InternalXtextGrammarTestLanguage.g:1229:2: ( ruleKeyword )
                    {
                    // InternalXtextGrammarTestLanguage.g:1229:2: ( ruleKeyword )
                    // InternalXtextGrammarTestLanguage.g:1230:3: ruleKeyword
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
                    // InternalXtextGrammarTestLanguage.g:1235:2: ( ruleRuleCall )
                    {
                    // InternalXtextGrammarTestLanguage.g:1235:2: ( ruleRuleCall )
                    // InternalXtextGrammarTestLanguage.g:1236:3: ruleRuleCall
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
                    // InternalXtextGrammarTestLanguage.g:1241:2: ( ruleParenthesizedAssignableElement )
                    {
                    // InternalXtextGrammarTestLanguage.g:1241:2: ( ruleParenthesizedAssignableElement )
                    // InternalXtextGrammarTestLanguage.g:1242:3: ruleParenthesizedAssignableElement
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
                    // InternalXtextGrammarTestLanguage.g:1247:2: ( ruleCrossReference )
                    {
                    // InternalXtextGrammarTestLanguage.g:1247:2: ( ruleCrossReference )
                    // InternalXtextGrammarTestLanguage.g:1248:3: ruleCrossReference
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
    // InternalXtextGrammarTestLanguage.g:1257:1: rule__CrossReferenceableTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedCrossReferenceableElement ) );
    public final void rule__CrossReferenceableTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1261:1: ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedCrossReferenceableElement ) )
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
                    // InternalXtextGrammarTestLanguage.g:1262:2: ( ruleKeyword )
                    {
                    // InternalXtextGrammarTestLanguage.g:1262:2: ( ruleKeyword )
                    // InternalXtextGrammarTestLanguage.g:1263:3: ruleKeyword
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
                    // InternalXtextGrammarTestLanguage.g:1268:2: ( ruleRuleCall )
                    {
                    // InternalXtextGrammarTestLanguage.g:1268:2: ( ruleRuleCall )
                    // InternalXtextGrammarTestLanguage.g:1269:3: ruleRuleCall
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
                    // InternalXtextGrammarTestLanguage.g:1274:2: ( ruleParenthesizedCrossReferenceableElement )
                    {
                    // InternalXtextGrammarTestLanguage.g:1274:2: ( ruleParenthesizedCrossReferenceableElement )
                    // InternalXtextGrammarTestLanguage.g:1275:3: ruleParenthesizedCrossReferenceableElement
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
    // InternalXtextGrammarTestLanguage.g:1284:1: rule__TerminalToken__CardinalityAlternatives_1_0 : ( ( '?' ) | ( '*' ) | ( '+' ) );
    public final void rule__TerminalToken__CardinalityAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1288:1: ( ( '?' ) | ( '*' ) | ( '+' ) )
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
                    // InternalXtextGrammarTestLanguage.g:1289:2: ( '?' )
                    {
                    // InternalXtextGrammarTestLanguage.g:1289:2: ( '?' )
                    // InternalXtextGrammarTestLanguage.g:1290:3: '?'
                    {
                     before(grammarAccess.getTerminalTokenAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getTerminalTokenAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1295:2: ( '*' )
                    {
                    // InternalXtextGrammarTestLanguage.g:1295:2: ( '*' )
                    // InternalXtextGrammarTestLanguage.g:1296:3: '*'
                    {
                     before(grammarAccess.getTerminalTokenAccess().getCardinalityAsteriskKeyword_1_0_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getTerminalTokenAccess().getCardinalityAsteriskKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtextGrammarTestLanguage.g:1301:2: ( '+' )
                    {
                    // InternalXtextGrammarTestLanguage.g:1301:2: ( '+' )
                    // InternalXtextGrammarTestLanguage.g:1302:3: '+'
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
    // InternalXtextGrammarTestLanguage.g:1311:1: rule__TerminalTokenElement__Alternatives : ( ( ruleCharacterRange ) | ( ruleRuleCall ) | ( ruleParenthesizedTerminalElement ) | ( ruleAbstractNegatedToken ) | ( ruleWildcard ) );
    public final void rule__TerminalTokenElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1315:1: ( ( ruleCharacterRange ) | ( ruleRuleCall ) | ( ruleParenthesizedTerminalElement ) | ( ruleAbstractNegatedToken ) | ( ruleWildcard ) )
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
                    // InternalXtextGrammarTestLanguage.g:1316:2: ( ruleCharacterRange )
                    {
                    // InternalXtextGrammarTestLanguage.g:1316:2: ( ruleCharacterRange )
                    // InternalXtextGrammarTestLanguage.g:1317:3: ruleCharacterRange
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
                    // InternalXtextGrammarTestLanguage.g:1322:2: ( ruleRuleCall )
                    {
                    // InternalXtextGrammarTestLanguage.g:1322:2: ( ruleRuleCall )
                    // InternalXtextGrammarTestLanguage.g:1323:3: ruleRuleCall
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
                    // InternalXtextGrammarTestLanguage.g:1328:2: ( ruleParenthesizedTerminalElement )
                    {
                    // InternalXtextGrammarTestLanguage.g:1328:2: ( ruleParenthesizedTerminalElement )
                    // InternalXtextGrammarTestLanguage.g:1329:3: ruleParenthesizedTerminalElement
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
                    // InternalXtextGrammarTestLanguage.g:1334:2: ( ruleAbstractNegatedToken )
                    {
                    // InternalXtextGrammarTestLanguage.g:1334:2: ( ruleAbstractNegatedToken )
                    // InternalXtextGrammarTestLanguage.g:1335:3: ruleAbstractNegatedToken
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
                    // InternalXtextGrammarTestLanguage.g:1340:2: ( ruleWildcard )
                    {
                    // InternalXtextGrammarTestLanguage.g:1340:2: ( ruleWildcard )
                    // InternalXtextGrammarTestLanguage.g:1341:3: ruleWildcard
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
    // InternalXtextGrammarTestLanguage.g:1350:1: rule__AbstractNegatedToken__Alternatives : ( ( ruleNegatedToken ) | ( ruleUntilToken ) );
    public final void rule__AbstractNegatedToken__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1354:1: ( ( ruleNegatedToken ) | ( ruleUntilToken ) )
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
                    // InternalXtextGrammarTestLanguage.g:1355:2: ( ruleNegatedToken )
                    {
                    // InternalXtextGrammarTestLanguage.g:1355:2: ( ruleNegatedToken )
                    // InternalXtextGrammarTestLanguage.g:1356:3: ruleNegatedToken
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
                    // InternalXtextGrammarTestLanguage.g:1361:2: ( ruleUntilToken )
                    {
                    // InternalXtextGrammarTestLanguage.g:1361:2: ( ruleUntilToken )
                    // InternalXtextGrammarTestLanguage.g:1362:3: ruleUntilToken
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
    // InternalXtextGrammarTestLanguage.g:1371:1: rule__Grammar__Group__0 : rule__Grammar__Group__0__Impl rule__Grammar__Group__1 ;
    public final void rule__Grammar__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1375:1: ( rule__Grammar__Group__0__Impl rule__Grammar__Group__1 )
            // InternalXtextGrammarTestLanguage.g:1376:2: rule__Grammar__Group__0__Impl rule__Grammar__Group__1
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
    // InternalXtextGrammarTestLanguage.g:1383:1: rule__Grammar__Group__0__Impl : ( 'grammar' ) ;
    public final void rule__Grammar__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1387:1: ( ( 'grammar' ) )
            // InternalXtextGrammarTestLanguage.g:1388:1: ( 'grammar' )
            {
            // InternalXtextGrammarTestLanguage.g:1388:1: ( 'grammar' )
            // InternalXtextGrammarTestLanguage.g:1389:2: 'grammar'
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
    // InternalXtextGrammarTestLanguage.g:1398:1: rule__Grammar__Group__1 : rule__Grammar__Group__1__Impl rule__Grammar__Group__2 ;
    public final void rule__Grammar__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1402:1: ( rule__Grammar__Group__1__Impl rule__Grammar__Group__2 )
            // InternalXtextGrammarTestLanguage.g:1403:2: rule__Grammar__Group__1__Impl rule__Grammar__Group__2
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
    // InternalXtextGrammarTestLanguage.g:1410:1: rule__Grammar__Group__1__Impl : ( ( rule__Grammar__NameAssignment_1 ) ) ;
    public final void rule__Grammar__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1414:1: ( ( ( rule__Grammar__NameAssignment_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:1415:1: ( ( rule__Grammar__NameAssignment_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:1415:1: ( ( rule__Grammar__NameAssignment_1 ) )
            // InternalXtextGrammarTestLanguage.g:1416:2: ( rule__Grammar__NameAssignment_1 )
            {
             before(grammarAccess.getGrammarAccess().getNameAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:1417:2: ( rule__Grammar__NameAssignment_1 )
            // InternalXtextGrammarTestLanguage.g:1417:3: rule__Grammar__NameAssignment_1
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
    // InternalXtextGrammarTestLanguage.g:1425:1: rule__Grammar__Group__2 : rule__Grammar__Group__2__Impl rule__Grammar__Group__3 ;
    public final void rule__Grammar__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1429:1: ( rule__Grammar__Group__2__Impl rule__Grammar__Group__3 )
            // InternalXtextGrammarTestLanguage.g:1430:2: rule__Grammar__Group__2__Impl rule__Grammar__Group__3
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
    // InternalXtextGrammarTestLanguage.g:1437:1: rule__Grammar__Group__2__Impl : ( ( rule__Grammar__Group_2__0 )? ) ;
    public final void rule__Grammar__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1441:1: ( ( ( rule__Grammar__Group_2__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:1442:1: ( ( rule__Grammar__Group_2__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:1442:1: ( ( rule__Grammar__Group_2__0 )? )
            // InternalXtextGrammarTestLanguage.g:1443:2: ( rule__Grammar__Group_2__0 )?
            {
             before(grammarAccess.getGrammarAccess().getGroup_2()); 
            // InternalXtextGrammarTestLanguage.g:1444:2: ( rule__Grammar__Group_2__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==18) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1444:3: rule__Grammar__Group_2__0
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
    // InternalXtextGrammarTestLanguage.g:1452:1: rule__Grammar__Group__3 : rule__Grammar__Group__3__Impl rule__Grammar__Group__4 ;
    public final void rule__Grammar__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1456:1: ( rule__Grammar__Group__3__Impl rule__Grammar__Group__4 )
            // InternalXtextGrammarTestLanguage.g:1457:2: rule__Grammar__Group__3__Impl rule__Grammar__Group__4
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
    // InternalXtextGrammarTestLanguage.g:1464:1: rule__Grammar__Group__3__Impl : ( ( rule__Grammar__Group_3__0 )? ) ;
    public final void rule__Grammar__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1468:1: ( ( ( rule__Grammar__Group_3__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:1469:1: ( ( rule__Grammar__Group_3__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:1469:1: ( ( rule__Grammar__Group_3__0 )? )
            // InternalXtextGrammarTestLanguage.g:1470:2: ( rule__Grammar__Group_3__0 )?
            {
             before(grammarAccess.getGrammarAccess().getGroup_3()); 
            // InternalXtextGrammarTestLanguage.g:1471:2: ( rule__Grammar__Group_3__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==41) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1471:3: rule__Grammar__Group_3__0
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
    // InternalXtextGrammarTestLanguage.g:1479:1: rule__Grammar__Group__4 : rule__Grammar__Group__4__Impl rule__Grammar__Group__5 ;
    public final void rule__Grammar__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1483:1: ( rule__Grammar__Group__4__Impl rule__Grammar__Group__5 )
            // InternalXtextGrammarTestLanguage.g:1484:2: rule__Grammar__Group__4__Impl rule__Grammar__Group__5
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
    // InternalXtextGrammarTestLanguage.g:1491:1: rule__Grammar__Group__4__Impl : ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* ) ;
    public final void rule__Grammar__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1495:1: ( ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* ) )
            // InternalXtextGrammarTestLanguage.g:1496:1: ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* )
            {
            // InternalXtextGrammarTestLanguage.g:1496:1: ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* )
            // InternalXtextGrammarTestLanguage.g:1497:2: ( rule__Grammar__MetamodelDeclarationsAssignment_4 )*
            {
             before(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAssignment_4()); 
            // InternalXtextGrammarTestLanguage.g:1498:2: ( rule__Grammar__MetamodelDeclarationsAssignment_4 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==23||LA16_0==25) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:1498:3: rule__Grammar__MetamodelDeclarationsAssignment_4
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
    // InternalXtextGrammarTestLanguage.g:1506:1: rule__Grammar__Group__5 : rule__Grammar__Group__5__Impl ;
    public final void rule__Grammar__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1510:1: ( rule__Grammar__Group__5__Impl )
            // InternalXtextGrammarTestLanguage.g:1511:2: rule__Grammar__Group__5__Impl
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
    // InternalXtextGrammarTestLanguage.g:1517:1: rule__Grammar__Group__5__Impl : ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) ) ;
    public final void rule__Grammar__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1521:1: ( ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) ) )
            // InternalXtextGrammarTestLanguage.g:1522:1: ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) )
            {
            // InternalXtextGrammarTestLanguage.g:1522:1: ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) )
            // InternalXtextGrammarTestLanguage.g:1523:2: ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* )
            {
            // InternalXtextGrammarTestLanguage.g:1523:2: ( ( rule__Grammar__RulesAssignment_5 ) )
            // InternalXtextGrammarTestLanguage.g:1524:3: ( rule__Grammar__RulesAssignment_5 )
            {
             before(grammarAccess.getGrammarAccess().getRulesAssignment_5()); 
            // InternalXtextGrammarTestLanguage.g:1525:3: ( rule__Grammar__RulesAssignment_5 )
            // InternalXtextGrammarTestLanguage.g:1525:4: rule__Grammar__RulesAssignment_5
            {
            pushFollow(FOLLOW_6);
            rule__Grammar__RulesAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getGrammarAccess().getRulesAssignment_5()); 

            }

            // InternalXtextGrammarTestLanguage.g:1528:2: ( ( rule__Grammar__RulesAssignment_5 )* )
            // InternalXtextGrammarTestLanguage.g:1529:3: ( rule__Grammar__RulesAssignment_5 )*
            {
             before(grammarAccess.getGrammarAccess().getRulesAssignment_5()); 
            // InternalXtextGrammarTestLanguage.g:1530:3: ( rule__Grammar__RulesAssignment_5 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_ID||LA17_0==36||LA17_0==40) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:1530:4: rule__Grammar__RulesAssignment_5
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
    // InternalXtextGrammarTestLanguage.g:1540:1: rule__Grammar__Group_2__0 : rule__Grammar__Group_2__0__Impl rule__Grammar__Group_2__1 ;
    public final void rule__Grammar__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1544:1: ( rule__Grammar__Group_2__0__Impl rule__Grammar__Group_2__1 )
            // InternalXtextGrammarTestLanguage.g:1545:2: rule__Grammar__Group_2__0__Impl rule__Grammar__Group_2__1
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
    // InternalXtextGrammarTestLanguage.g:1552:1: rule__Grammar__Group_2__0__Impl : ( 'with' ) ;
    public final void rule__Grammar__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1556:1: ( ( 'with' ) )
            // InternalXtextGrammarTestLanguage.g:1557:1: ( 'with' )
            {
            // InternalXtextGrammarTestLanguage.g:1557:1: ( 'with' )
            // InternalXtextGrammarTestLanguage.g:1558:2: 'with'
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
    // InternalXtextGrammarTestLanguage.g:1567:1: rule__Grammar__Group_2__1 : rule__Grammar__Group_2__1__Impl rule__Grammar__Group_2__2 ;
    public final void rule__Grammar__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1571:1: ( rule__Grammar__Group_2__1__Impl rule__Grammar__Group_2__2 )
            // InternalXtextGrammarTestLanguage.g:1572:2: rule__Grammar__Group_2__1__Impl rule__Grammar__Group_2__2
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
    // InternalXtextGrammarTestLanguage.g:1579:1: rule__Grammar__Group_2__1__Impl : ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) ) ;
    public final void rule__Grammar__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1583:1: ( ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:1584:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:1584:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) )
            // InternalXtextGrammarTestLanguage.g:1585:2: ( rule__Grammar__UsedGrammarsAssignment_2_1 )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_1()); 
            // InternalXtextGrammarTestLanguage.g:1586:2: ( rule__Grammar__UsedGrammarsAssignment_2_1 )
            // InternalXtextGrammarTestLanguage.g:1586:3: rule__Grammar__UsedGrammarsAssignment_2_1
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
    // InternalXtextGrammarTestLanguage.g:1594:1: rule__Grammar__Group_2__2 : rule__Grammar__Group_2__2__Impl ;
    public final void rule__Grammar__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1598:1: ( rule__Grammar__Group_2__2__Impl )
            // InternalXtextGrammarTestLanguage.g:1599:2: rule__Grammar__Group_2__2__Impl
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
    // InternalXtextGrammarTestLanguage.g:1605:1: rule__Grammar__Group_2__2__Impl : ( ( rule__Grammar__Group_2_2__0 )* ) ;
    public final void rule__Grammar__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1609:1: ( ( ( rule__Grammar__Group_2_2__0 )* ) )
            // InternalXtextGrammarTestLanguage.g:1610:1: ( ( rule__Grammar__Group_2_2__0 )* )
            {
            // InternalXtextGrammarTestLanguage.g:1610:1: ( ( rule__Grammar__Group_2_2__0 )* )
            // InternalXtextGrammarTestLanguage.g:1611:2: ( rule__Grammar__Group_2_2__0 )*
            {
             before(grammarAccess.getGrammarAccess().getGroup_2_2()); 
            // InternalXtextGrammarTestLanguage.g:1612:2: ( rule__Grammar__Group_2_2__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==19) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:1612:3: rule__Grammar__Group_2_2__0
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
    // InternalXtextGrammarTestLanguage.g:1621:1: rule__Grammar__Group_2_2__0 : rule__Grammar__Group_2_2__0__Impl rule__Grammar__Group_2_2__1 ;
    public final void rule__Grammar__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1625:1: ( rule__Grammar__Group_2_2__0__Impl rule__Grammar__Group_2_2__1 )
            // InternalXtextGrammarTestLanguage.g:1626:2: rule__Grammar__Group_2_2__0__Impl rule__Grammar__Group_2_2__1
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
    // InternalXtextGrammarTestLanguage.g:1633:1: rule__Grammar__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__Grammar__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1637:1: ( ( ',' ) )
            // InternalXtextGrammarTestLanguage.g:1638:1: ( ',' )
            {
            // InternalXtextGrammarTestLanguage.g:1638:1: ( ',' )
            // InternalXtextGrammarTestLanguage.g:1639:2: ','
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
    // InternalXtextGrammarTestLanguage.g:1648:1: rule__Grammar__Group_2_2__1 : rule__Grammar__Group_2_2__1__Impl ;
    public final void rule__Grammar__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1652:1: ( rule__Grammar__Group_2_2__1__Impl )
            // InternalXtextGrammarTestLanguage.g:1653:2: rule__Grammar__Group_2_2__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:1659:1: rule__Grammar__Group_2_2__1__Impl : ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) ) ;
    public final void rule__Grammar__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1663:1: ( ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:1664:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:1664:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) )
            // InternalXtextGrammarTestLanguage.g:1665:2: ( rule__Grammar__UsedGrammarsAssignment_2_2_1 )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_2_1()); 
            // InternalXtextGrammarTestLanguage.g:1666:2: ( rule__Grammar__UsedGrammarsAssignment_2_2_1 )
            // InternalXtextGrammarTestLanguage.g:1666:3: rule__Grammar__UsedGrammarsAssignment_2_2_1
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
    // InternalXtextGrammarTestLanguage.g:1675:1: rule__Grammar__Group_3__0 : rule__Grammar__Group_3__0__Impl rule__Grammar__Group_3__1 ;
    public final void rule__Grammar__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1679:1: ( rule__Grammar__Group_3__0__Impl rule__Grammar__Group_3__1 )
            // InternalXtextGrammarTestLanguage.g:1680:2: rule__Grammar__Group_3__0__Impl rule__Grammar__Group_3__1
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
    // InternalXtextGrammarTestLanguage.g:1687:1: rule__Grammar__Group_3__0__Impl : ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) ) ;
    public final void rule__Grammar__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1691:1: ( ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:1692:1: ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:1692:1: ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) )
            // InternalXtextGrammarTestLanguage.g:1693:2: ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 )
            {
             before(grammarAccess.getGrammarAccess().getDefinesHiddenTokensAssignment_3_0()); 
            // InternalXtextGrammarTestLanguage.g:1694:2: ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 )
            // InternalXtextGrammarTestLanguage.g:1694:3: rule__Grammar__DefinesHiddenTokensAssignment_3_0
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
    // InternalXtextGrammarTestLanguage.g:1702:1: rule__Grammar__Group_3__1 : rule__Grammar__Group_3__1__Impl rule__Grammar__Group_3__2 ;
    public final void rule__Grammar__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1706:1: ( rule__Grammar__Group_3__1__Impl rule__Grammar__Group_3__2 )
            // InternalXtextGrammarTestLanguage.g:1707:2: rule__Grammar__Group_3__1__Impl rule__Grammar__Group_3__2
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
    // InternalXtextGrammarTestLanguage.g:1714:1: rule__Grammar__Group_3__1__Impl : ( '(' ) ;
    public final void rule__Grammar__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1718:1: ( ( '(' ) )
            // InternalXtextGrammarTestLanguage.g:1719:1: ( '(' )
            {
            // InternalXtextGrammarTestLanguage.g:1719:1: ( '(' )
            // InternalXtextGrammarTestLanguage.g:1720:2: '('
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
    // InternalXtextGrammarTestLanguage.g:1729:1: rule__Grammar__Group_3__2 : rule__Grammar__Group_3__2__Impl rule__Grammar__Group_3__3 ;
    public final void rule__Grammar__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1733:1: ( rule__Grammar__Group_3__2__Impl rule__Grammar__Group_3__3 )
            // InternalXtextGrammarTestLanguage.g:1734:2: rule__Grammar__Group_3__2__Impl rule__Grammar__Group_3__3
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
    // InternalXtextGrammarTestLanguage.g:1741:1: rule__Grammar__Group_3__2__Impl : ( ( rule__Grammar__Group_3_2__0 )? ) ;
    public final void rule__Grammar__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1745:1: ( ( ( rule__Grammar__Group_3_2__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:1746:1: ( ( rule__Grammar__Group_3_2__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:1746:1: ( ( rule__Grammar__Group_3_2__0 )? )
            // InternalXtextGrammarTestLanguage.g:1747:2: ( rule__Grammar__Group_3_2__0 )?
            {
             before(grammarAccess.getGrammarAccess().getGroup_3_2()); 
            // InternalXtextGrammarTestLanguage.g:1748:2: ( rule__Grammar__Group_3_2__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ID) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1748:3: rule__Grammar__Group_3_2__0
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
    // InternalXtextGrammarTestLanguage.g:1756:1: rule__Grammar__Group_3__3 : rule__Grammar__Group_3__3__Impl ;
    public final void rule__Grammar__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1760:1: ( rule__Grammar__Group_3__3__Impl )
            // InternalXtextGrammarTestLanguage.g:1761:2: rule__Grammar__Group_3__3__Impl
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
    // InternalXtextGrammarTestLanguage.g:1767:1: rule__Grammar__Group_3__3__Impl : ( ')' ) ;
    public final void rule__Grammar__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1771:1: ( ( ')' ) )
            // InternalXtextGrammarTestLanguage.g:1772:1: ( ')' )
            {
            // InternalXtextGrammarTestLanguage.g:1772:1: ( ')' )
            // InternalXtextGrammarTestLanguage.g:1773:2: ')'
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
    // InternalXtextGrammarTestLanguage.g:1783:1: rule__Grammar__Group_3_2__0 : rule__Grammar__Group_3_2__0__Impl rule__Grammar__Group_3_2__1 ;
    public final void rule__Grammar__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1787:1: ( rule__Grammar__Group_3_2__0__Impl rule__Grammar__Group_3_2__1 )
            // InternalXtextGrammarTestLanguage.g:1788:2: rule__Grammar__Group_3_2__0__Impl rule__Grammar__Group_3_2__1
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
    // InternalXtextGrammarTestLanguage.g:1795:1: rule__Grammar__Group_3_2__0__Impl : ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) ) ;
    public final void rule__Grammar__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1799:1: ( ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:1800:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:1800:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) )
            // InternalXtextGrammarTestLanguage.g:1801:2: ( rule__Grammar__HiddenTokensAssignment_3_2_0 )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAssignment_3_2_0()); 
            // InternalXtextGrammarTestLanguage.g:1802:2: ( rule__Grammar__HiddenTokensAssignment_3_2_0 )
            // InternalXtextGrammarTestLanguage.g:1802:3: rule__Grammar__HiddenTokensAssignment_3_2_0
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
    // InternalXtextGrammarTestLanguage.g:1810:1: rule__Grammar__Group_3_2__1 : rule__Grammar__Group_3_2__1__Impl ;
    public final void rule__Grammar__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1814:1: ( rule__Grammar__Group_3_2__1__Impl )
            // InternalXtextGrammarTestLanguage.g:1815:2: rule__Grammar__Group_3_2__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:1821:1: rule__Grammar__Group_3_2__1__Impl : ( ( rule__Grammar__Group_3_2_1__0 )* ) ;
    public final void rule__Grammar__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1825:1: ( ( ( rule__Grammar__Group_3_2_1__0 )* ) )
            // InternalXtextGrammarTestLanguage.g:1826:1: ( ( rule__Grammar__Group_3_2_1__0 )* )
            {
            // InternalXtextGrammarTestLanguage.g:1826:1: ( ( rule__Grammar__Group_3_2_1__0 )* )
            // InternalXtextGrammarTestLanguage.g:1827:2: ( rule__Grammar__Group_3_2_1__0 )*
            {
             before(grammarAccess.getGrammarAccess().getGroup_3_2_1()); 
            // InternalXtextGrammarTestLanguage.g:1828:2: ( rule__Grammar__Group_3_2_1__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==19) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:1828:3: rule__Grammar__Group_3_2_1__0
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
    // InternalXtextGrammarTestLanguage.g:1837:1: rule__Grammar__Group_3_2_1__0 : rule__Grammar__Group_3_2_1__0__Impl rule__Grammar__Group_3_2_1__1 ;
    public final void rule__Grammar__Group_3_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1841:1: ( rule__Grammar__Group_3_2_1__0__Impl rule__Grammar__Group_3_2_1__1 )
            // InternalXtextGrammarTestLanguage.g:1842:2: rule__Grammar__Group_3_2_1__0__Impl rule__Grammar__Group_3_2_1__1
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
    // InternalXtextGrammarTestLanguage.g:1849:1: rule__Grammar__Group_3_2_1__0__Impl : ( ',' ) ;
    public final void rule__Grammar__Group_3_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1853:1: ( ( ',' ) )
            // InternalXtextGrammarTestLanguage.g:1854:1: ( ',' )
            {
            // InternalXtextGrammarTestLanguage.g:1854:1: ( ',' )
            // InternalXtextGrammarTestLanguage.g:1855:2: ','
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
    // InternalXtextGrammarTestLanguage.g:1864:1: rule__Grammar__Group_3_2_1__1 : rule__Grammar__Group_3_2_1__1__Impl ;
    public final void rule__Grammar__Group_3_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1868:1: ( rule__Grammar__Group_3_2_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:1869:2: rule__Grammar__Group_3_2_1__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:1875:1: rule__Grammar__Group_3_2_1__1__Impl : ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) ) ;
    public final void rule__Grammar__Group_3_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1879:1: ( ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:1880:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:1880:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) )
            // InternalXtextGrammarTestLanguage.g:1881:2: ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAssignment_3_2_1_1()); 
            // InternalXtextGrammarTestLanguage.g:1882:2: ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 )
            // InternalXtextGrammarTestLanguage.g:1882:3: rule__Grammar__HiddenTokensAssignment_3_2_1_1
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
    // InternalXtextGrammarTestLanguage.g:1891:1: rule__GrammarID__Group__0 : rule__GrammarID__Group__0__Impl rule__GrammarID__Group__1 ;
    public final void rule__GrammarID__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1895:1: ( rule__GrammarID__Group__0__Impl rule__GrammarID__Group__1 )
            // InternalXtextGrammarTestLanguage.g:1896:2: rule__GrammarID__Group__0__Impl rule__GrammarID__Group__1
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
    // InternalXtextGrammarTestLanguage.g:1903:1: rule__GrammarID__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__GrammarID__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1907:1: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:1908:1: ( RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:1908:1: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:1909:2: RULE_ID
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
    // InternalXtextGrammarTestLanguage.g:1918:1: rule__GrammarID__Group__1 : rule__GrammarID__Group__1__Impl ;
    public final void rule__GrammarID__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1922:1: ( rule__GrammarID__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:1923:2: rule__GrammarID__Group__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:1929:1: rule__GrammarID__Group__1__Impl : ( ( rule__GrammarID__Group_1__0 )* ) ;
    public final void rule__GrammarID__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1933:1: ( ( ( rule__GrammarID__Group_1__0 )* ) )
            // InternalXtextGrammarTestLanguage.g:1934:1: ( ( rule__GrammarID__Group_1__0 )* )
            {
            // InternalXtextGrammarTestLanguage.g:1934:1: ( ( rule__GrammarID__Group_1__0 )* )
            // InternalXtextGrammarTestLanguage.g:1935:2: ( rule__GrammarID__Group_1__0 )*
            {
             before(grammarAccess.getGrammarIDAccess().getGroup_1()); 
            // InternalXtextGrammarTestLanguage.g:1936:2: ( rule__GrammarID__Group_1__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==22) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:1936:3: rule__GrammarID__Group_1__0
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
    // InternalXtextGrammarTestLanguage.g:1945:1: rule__GrammarID__Group_1__0 : rule__GrammarID__Group_1__0__Impl rule__GrammarID__Group_1__1 ;
    public final void rule__GrammarID__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1949:1: ( rule__GrammarID__Group_1__0__Impl rule__GrammarID__Group_1__1 )
            // InternalXtextGrammarTestLanguage.g:1950:2: rule__GrammarID__Group_1__0__Impl rule__GrammarID__Group_1__1
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
    // InternalXtextGrammarTestLanguage.g:1957:1: rule__GrammarID__Group_1__0__Impl : ( '.' ) ;
    public final void rule__GrammarID__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1961:1: ( ( '.' ) )
            // InternalXtextGrammarTestLanguage.g:1962:1: ( '.' )
            {
            // InternalXtextGrammarTestLanguage.g:1962:1: ( '.' )
            // InternalXtextGrammarTestLanguage.g:1963:2: '.'
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
    // InternalXtextGrammarTestLanguage.g:1972:1: rule__GrammarID__Group_1__1 : rule__GrammarID__Group_1__1__Impl ;
    public final void rule__GrammarID__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1976:1: ( rule__GrammarID__Group_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:1977:2: rule__GrammarID__Group_1__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:1983:1: rule__GrammarID__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__GrammarID__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1987:1: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:1988:1: ( RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:1988:1: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:1989:2: RULE_ID
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
    // InternalXtextGrammarTestLanguage.g:1999:1: rule__GeneratedMetamodel__Group__0 : rule__GeneratedMetamodel__Group__0__Impl rule__GeneratedMetamodel__Group__1 ;
    public final void rule__GeneratedMetamodel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2003:1: ( rule__GeneratedMetamodel__Group__0__Impl rule__GeneratedMetamodel__Group__1 )
            // InternalXtextGrammarTestLanguage.g:2004:2: rule__GeneratedMetamodel__Group__0__Impl rule__GeneratedMetamodel__Group__1
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
    // InternalXtextGrammarTestLanguage.g:2011:1: rule__GeneratedMetamodel__Group__0__Impl : ( 'generate' ) ;
    public final void rule__GeneratedMetamodel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2015:1: ( ( 'generate' ) )
            // InternalXtextGrammarTestLanguage.g:2016:1: ( 'generate' )
            {
            // InternalXtextGrammarTestLanguage.g:2016:1: ( 'generate' )
            // InternalXtextGrammarTestLanguage.g:2017:2: 'generate'
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
    // InternalXtextGrammarTestLanguage.g:2026:1: rule__GeneratedMetamodel__Group__1 : rule__GeneratedMetamodel__Group__1__Impl rule__GeneratedMetamodel__Group__2 ;
    public final void rule__GeneratedMetamodel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2030:1: ( rule__GeneratedMetamodel__Group__1__Impl rule__GeneratedMetamodel__Group__2 )
            // InternalXtextGrammarTestLanguage.g:2031:2: rule__GeneratedMetamodel__Group__1__Impl rule__GeneratedMetamodel__Group__2
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
    // InternalXtextGrammarTestLanguage.g:2038:1: rule__GeneratedMetamodel__Group__1__Impl : ( ( rule__GeneratedMetamodel__NameAssignment_1 ) ) ;
    public final void rule__GeneratedMetamodel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2042:1: ( ( ( rule__GeneratedMetamodel__NameAssignment_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:2043:1: ( ( rule__GeneratedMetamodel__NameAssignment_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2043:1: ( ( rule__GeneratedMetamodel__NameAssignment_1 ) )
            // InternalXtextGrammarTestLanguage.g:2044:2: ( rule__GeneratedMetamodel__NameAssignment_1 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getNameAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:2045:2: ( rule__GeneratedMetamodel__NameAssignment_1 )
            // InternalXtextGrammarTestLanguage.g:2045:3: rule__GeneratedMetamodel__NameAssignment_1
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
    // InternalXtextGrammarTestLanguage.g:2053:1: rule__GeneratedMetamodel__Group__2 : rule__GeneratedMetamodel__Group__2__Impl rule__GeneratedMetamodel__Group__3 ;
    public final void rule__GeneratedMetamodel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2057:1: ( rule__GeneratedMetamodel__Group__2__Impl rule__GeneratedMetamodel__Group__3 )
            // InternalXtextGrammarTestLanguage.g:2058:2: rule__GeneratedMetamodel__Group__2__Impl rule__GeneratedMetamodel__Group__3
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
    // InternalXtextGrammarTestLanguage.g:2065:1: rule__GeneratedMetamodel__Group__2__Impl : ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) ) ;
    public final void rule__GeneratedMetamodel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2069:1: ( ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) ) )
            // InternalXtextGrammarTestLanguage.g:2070:1: ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2070:1: ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) )
            // InternalXtextGrammarTestLanguage.g:2071:2: ( rule__GeneratedMetamodel__EPackageAssignment_2 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getEPackageAssignment_2()); 
            // InternalXtextGrammarTestLanguage.g:2072:2: ( rule__GeneratedMetamodel__EPackageAssignment_2 )
            // InternalXtextGrammarTestLanguage.g:2072:3: rule__GeneratedMetamodel__EPackageAssignment_2
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
    // InternalXtextGrammarTestLanguage.g:2080:1: rule__GeneratedMetamodel__Group__3 : rule__GeneratedMetamodel__Group__3__Impl ;
    public final void rule__GeneratedMetamodel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2084:1: ( rule__GeneratedMetamodel__Group__3__Impl )
            // InternalXtextGrammarTestLanguage.g:2085:2: rule__GeneratedMetamodel__Group__3__Impl
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
    // InternalXtextGrammarTestLanguage.g:2091:1: rule__GeneratedMetamodel__Group__3__Impl : ( ( rule__GeneratedMetamodel__Group_3__0 )? ) ;
    public final void rule__GeneratedMetamodel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2095:1: ( ( ( rule__GeneratedMetamodel__Group_3__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:2096:1: ( ( rule__GeneratedMetamodel__Group_3__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:2096:1: ( ( rule__GeneratedMetamodel__Group_3__0 )? )
            // InternalXtextGrammarTestLanguage.g:2097:2: ( rule__GeneratedMetamodel__Group_3__0 )?
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getGroup_3()); 
            // InternalXtextGrammarTestLanguage.g:2098:2: ( rule__GeneratedMetamodel__Group_3__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==24) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:2098:3: rule__GeneratedMetamodel__Group_3__0
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
    // InternalXtextGrammarTestLanguage.g:2107:1: rule__GeneratedMetamodel__Group_3__0 : rule__GeneratedMetamodel__Group_3__0__Impl rule__GeneratedMetamodel__Group_3__1 ;
    public final void rule__GeneratedMetamodel__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2111:1: ( rule__GeneratedMetamodel__Group_3__0__Impl rule__GeneratedMetamodel__Group_3__1 )
            // InternalXtextGrammarTestLanguage.g:2112:2: rule__GeneratedMetamodel__Group_3__0__Impl rule__GeneratedMetamodel__Group_3__1
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
    // InternalXtextGrammarTestLanguage.g:2119:1: rule__GeneratedMetamodel__Group_3__0__Impl : ( 'as' ) ;
    public final void rule__GeneratedMetamodel__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2123:1: ( ( 'as' ) )
            // InternalXtextGrammarTestLanguage.g:2124:1: ( 'as' )
            {
            // InternalXtextGrammarTestLanguage.g:2124:1: ( 'as' )
            // InternalXtextGrammarTestLanguage.g:2125:2: 'as'
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
    // InternalXtextGrammarTestLanguage.g:2134:1: rule__GeneratedMetamodel__Group_3__1 : rule__GeneratedMetamodel__Group_3__1__Impl ;
    public final void rule__GeneratedMetamodel__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2138:1: ( rule__GeneratedMetamodel__Group_3__1__Impl )
            // InternalXtextGrammarTestLanguage.g:2139:2: rule__GeneratedMetamodel__Group_3__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:2145:1: rule__GeneratedMetamodel__Group_3__1__Impl : ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) ) ;
    public final void rule__GeneratedMetamodel__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2149:1: ( ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:2150:1: ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2150:1: ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) )
            // InternalXtextGrammarTestLanguage.g:2151:2: ( rule__GeneratedMetamodel__AliasAssignment_3_1 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getAliasAssignment_3_1()); 
            // InternalXtextGrammarTestLanguage.g:2152:2: ( rule__GeneratedMetamodel__AliasAssignment_3_1 )
            // InternalXtextGrammarTestLanguage.g:2152:3: rule__GeneratedMetamodel__AliasAssignment_3_1
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
    // InternalXtextGrammarTestLanguage.g:2161:1: rule__ReferencedMetamodel__Group__0 : rule__ReferencedMetamodel__Group__0__Impl rule__ReferencedMetamodel__Group__1 ;
    public final void rule__ReferencedMetamodel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2165:1: ( rule__ReferencedMetamodel__Group__0__Impl rule__ReferencedMetamodel__Group__1 )
            // InternalXtextGrammarTestLanguage.g:2166:2: rule__ReferencedMetamodel__Group__0__Impl rule__ReferencedMetamodel__Group__1
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
    // InternalXtextGrammarTestLanguage.g:2173:1: rule__ReferencedMetamodel__Group__0__Impl : ( 'import' ) ;
    public final void rule__ReferencedMetamodel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2177:1: ( ( 'import' ) )
            // InternalXtextGrammarTestLanguage.g:2178:1: ( 'import' )
            {
            // InternalXtextGrammarTestLanguage.g:2178:1: ( 'import' )
            // InternalXtextGrammarTestLanguage.g:2179:2: 'import'
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
    // InternalXtextGrammarTestLanguage.g:2188:1: rule__ReferencedMetamodel__Group__1 : rule__ReferencedMetamodel__Group__1__Impl rule__ReferencedMetamodel__Group__2 ;
    public final void rule__ReferencedMetamodel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2192:1: ( rule__ReferencedMetamodel__Group__1__Impl rule__ReferencedMetamodel__Group__2 )
            // InternalXtextGrammarTestLanguage.g:2193:2: rule__ReferencedMetamodel__Group__1__Impl rule__ReferencedMetamodel__Group__2
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
    // InternalXtextGrammarTestLanguage.g:2200:1: rule__ReferencedMetamodel__Group__1__Impl : ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) ) ;
    public final void rule__ReferencedMetamodel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2204:1: ( ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:2205:1: ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2205:1: ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) )
            // InternalXtextGrammarTestLanguage.g:2206:2: ( rule__ReferencedMetamodel__EPackageAssignment_1 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:2207:2: ( rule__ReferencedMetamodel__EPackageAssignment_1 )
            // InternalXtextGrammarTestLanguage.g:2207:3: rule__ReferencedMetamodel__EPackageAssignment_1
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
    // InternalXtextGrammarTestLanguage.g:2215:1: rule__ReferencedMetamodel__Group__2 : rule__ReferencedMetamodel__Group__2__Impl ;
    public final void rule__ReferencedMetamodel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2219:1: ( rule__ReferencedMetamodel__Group__2__Impl )
            // InternalXtextGrammarTestLanguage.g:2220:2: rule__ReferencedMetamodel__Group__2__Impl
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
    // InternalXtextGrammarTestLanguage.g:2226:1: rule__ReferencedMetamodel__Group__2__Impl : ( ( rule__ReferencedMetamodel__Group_2__0 )? ) ;
    public final void rule__ReferencedMetamodel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2230:1: ( ( ( rule__ReferencedMetamodel__Group_2__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:2231:1: ( ( rule__ReferencedMetamodel__Group_2__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:2231:1: ( ( rule__ReferencedMetamodel__Group_2__0 )? )
            // InternalXtextGrammarTestLanguage.g:2232:2: ( rule__ReferencedMetamodel__Group_2__0 )?
            {
             before(grammarAccess.getReferencedMetamodelAccess().getGroup_2()); 
            // InternalXtextGrammarTestLanguage.g:2233:2: ( rule__ReferencedMetamodel__Group_2__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==24) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:2233:3: rule__ReferencedMetamodel__Group_2__0
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
    // InternalXtextGrammarTestLanguage.g:2242:1: rule__ReferencedMetamodel__Group_2__0 : rule__ReferencedMetamodel__Group_2__0__Impl rule__ReferencedMetamodel__Group_2__1 ;
    public final void rule__ReferencedMetamodel__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2246:1: ( rule__ReferencedMetamodel__Group_2__0__Impl rule__ReferencedMetamodel__Group_2__1 )
            // InternalXtextGrammarTestLanguage.g:2247:2: rule__ReferencedMetamodel__Group_2__0__Impl rule__ReferencedMetamodel__Group_2__1
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
    // InternalXtextGrammarTestLanguage.g:2254:1: rule__ReferencedMetamodel__Group_2__0__Impl : ( 'as' ) ;
    public final void rule__ReferencedMetamodel__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2258:1: ( ( 'as' ) )
            // InternalXtextGrammarTestLanguage.g:2259:1: ( 'as' )
            {
            // InternalXtextGrammarTestLanguage.g:2259:1: ( 'as' )
            // InternalXtextGrammarTestLanguage.g:2260:2: 'as'
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
    // InternalXtextGrammarTestLanguage.g:2269:1: rule__ReferencedMetamodel__Group_2__1 : rule__ReferencedMetamodel__Group_2__1__Impl ;
    public final void rule__ReferencedMetamodel__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2273:1: ( rule__ReferencedMetamodel__Group_2__1__Impl )
            // InternalXtextGrammarTestLanguage.g:2274:2: rule__ReferencedMetamodel__Group_2__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:2280:1: rule__ReferencedMetamodel__Group_2__1__Impl : ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) ) ;
    public final void rule__ReferencedMetamodel__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2284:1: ( ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:2285:1: ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2285:1: ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) )
            // InternalXtextGrammarTestLanguage.g:2286:2: ( rule__ReferencedMetamodel__AliasAssignment_2_1 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAliasAssignment_2_1()); 
            // InternalXtextGrammarTestLanguage.g:2287:2: ( rule__ReferencedMetamodel__AliasAssignment_2_1 )
            // InternalXtextGrammarTestLanguage.g:2287:3: rule__ReferencedMetamodel__AliasAssignment_2_1
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
    // InternalXtextGrammarTestLanguage.g:2296:1: rule__ParserRule__Group__0 : rule__ParserRule__Group__0__Impl rule__ParserRule__Group__1 ;
    public final void rule__ParserRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2300:1: ( rule__ParserRule__Group__0__Impl rule__ParserRule__Group__1 )
            // InternalXtextGrammarTestLanguage.g:2301:2: rule__ParserRule__Group__0__Impl rule__ParserRule__Group__1
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
    // InternalXtextGrammarTestLanguage.g:2308:1: rule__ParserRule__Group__0__Impl : ( ( rule__ParserRule__NameAssignment_0 ) ) ;
    public final void rule__ParserRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2312:1: ( ( ( rule__ParserRule__NameAssignment_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:2313:1: ( ( rule__ParserRule__NameAssignment_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2313:1: ( ( rule__ParserRule__NameAssignment_0 ) )
            // InternalXtextGrammarTestLanguage.g:2314:2: ( rule__ParserRule__NameAssignment_0 )
            {
             before(grammarAccess.getParserRuleAccess().getNameAssignment_0()); 
            // InternalXtextGrammarTestLanguage.g:2315:2: ( rule__ParserRule__NameAssignment_0 )
            // InternalXtextGrammarTestLanguage.g:2315:3: rule__ParserRule__NameAssignment_0
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
    // InternalXtextGrammarTestLanguage.g:2323:1: rule__ParserRule__Group__1 : rule__ParserRule__Group__1__Impl rule__ParserRule__Group__2 ;
    public final void rule__ParserRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2327:1: ( rule__ParserRule__Group__1__Impl rule__ParserRule__Group__2 )
            // InternalXtextGrammarTestLanguage.g:2328:2: rule__ParserRule__Group__1__Impl rule__ParserRule__Group__2
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
    // InternalXtextGrammarTestLanguage.g:2335:1: rule__ParserRule__Group__1__Impl : ( ( rule__ParserRule__Group_1__0 )? ) ;
    public final void rule__ParserRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2339:1: ( ( ( rule__ParserRule__Group_1__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:2340:1: ( ( rule__ParserRule__Group_1__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:2340:1: ( ( rule__ParserRule__Group_1__0 )? )
            // InternalXtextGrammarTestLanguage.g:2341:2: ( rule__ParserRule__Group_1__0 )?
            {
             before(grammarAccess.getParserRuleAccess().getGroup_1()); 
            // InternalXtextGrammarTestLanguage.g:2342:2: ( rule__ParserRule__Group_1__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==28) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:2342:3: rule__ParserRule__Group_1__0
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
    // InternalXtextGrammarTestLanguage.g:2350:1: rule__ParserRule__Group__2 : rule__ParserRule__Group__2__Impl rule__ParserRule__Group__3 ;
    public final void rule__ParserRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2354:1: ( rule__ParserRule__Group__2__Impl rule__ParserRule__Group__3 )
            // InternalXtextGrammarTestLanguage.g:2355:2: rule__ParserRule__Group__2__Impl rule__ParserRule__Group__3
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
    // InternalXtextGrammarTestLanguage.g:2362:1: rule__ParserRule__Group__2__Impl : ( ( rule__ParserRule__Group_2__0 )? ) ;
    public final void rule__ParserRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2366:1: ( ( ( rule__ParserRule__Group_2__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:2367:1: ( ( rule__ParserRule__Group_2__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:2367:1: ( ( rule__ParserRule__Group_2__0 )? )
            // InternalXtextGrammarTestLanguage.g:2368:2: ( rule__ParserRule__Group_2__0 )?
            {
             before(grammarAccess.getParserRuleAccess().getGroup_2()); 
            // InternalXtextGrammarTestLanguage.g:2369:2: ( rule__ParserRule__Group_2__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==41) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:2369:3: rule__ParserRule__Group_2__0
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
    // InternalXtextGrammarTestLanguage.g:2377:1: rule__ParserRule__Group__3 : rule__ParserRule__Group__3__Impl rule__ParserRule__Group__4 ;
    public final void rule__ParserRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2381:1: ( rule__ParserRule__Group__3__Impl rule__ParserRule__Group__4 )
            // InternalXtextGrammarTestLanguage.g:2382:2: rule__ParserRule__Group__3__Impl rule__ParserRule__Group__4
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
    // InternalXtextGrammarTestLanguage.g:2389:1: rule__ParserRule__Group__3__Impl : ( ':' ) ;
    public final void rule__ParserRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2393:1: ( ( ':' ) )
            // InternalXtextGrammarTestLanguage.g:2394:1: ( ':' )
            {
            // InternalXtextGrammarTestLanguage.g:2394:1: ( ':' )
            // InternalXtextGrammarTestLanguage.g:2395:2: ':'
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
    // InternalXtextGrammarTestLanguage.g:2404:1: rule__ParserRule__Group__4 : rule__ParserRule__Group__4__Impl rule__ParserRule__Group__5 ;
    public final void rule__ParserRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2408:1: ( rule__ParserRule__Group__4__Impl rule__ParserRule__Group__5 )
            // InternalXtextGrammarTestLanguage.g:2409:2: rule__ParserRule__Group__4__Impl rule__ParserRule__Group__5
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
    // InternalXtextGrammarTestLanguage.g:2416:1: rule__ParserRule__Group__4__Impl : ( ( rule__ParserRule__AlternativesAssignment_4 ) ) ;
    public final void rule__ParserRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2420:1: ( ( ( rule__ParserRule__AlternativesAssignment_4 ) ) )
            // InternalXtextGrammarTestLanguage.g:2421:1: ( ( rule__ParserRule__AlternativesAssignment_4 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2421:1: ( ( rule__ParserRule__AlternativesAssignment_4 ) )
            // InternalXtextGrammarTestLanguage.g:2422:2: ( rule__ParserRule__AlternativesAssignment_4 )
            {
             before(grammarAccess.getParserRuleAccess().getAlternativesAssignment_4()); 
            // InternalXtextGrammarTestLanguage.g:2423:2: ( rule__ParserRule__AlternativesAssignment_4 )
            // InternalXtextGrammarTestLanguage.g:2423:3: rule__ParserRule__AlternativesAssignment_4
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
    // InternalXtextGrammarTestLanguage.g:2431:1: rule__ParserRule__Group__5 : rule__ParserRule__Group__5__Impl ;
    public final void rule__ParserRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2435:1: ( rule__ParserRule__Group__5__Impl )
            // InternalXtextGrammarTestLanguage.g:2436:2: rule__ParserRule__Group__5__Impl
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
    // InternalXtextGrammarTestLanguage.g:2442:1: rule__ParserRule__Group__5__Impl : ( ';' ) ;
    public final void rule__ParserRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2446:1: ( ( ';' ) )
            // InternalXtextGrammarTestLanguage.g:2447:1: ( ';' )
            {
            // InternalXtextGrammarTestLanguage.g:2447:1: ( ';' )
            // InternalXtextGrammarTestLanguage.g:2448:2: ';'
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
    // InternalXtextGrammarTestLanguage.g:2458:1: rule__ParserRule__Group_1__0 : rule__ParserRule__Group_1__0__Impl rule__ParserRule__Group_1__1 ;
    public final void rule__ParserRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2462:1: ( rule__ParserRule__Group_1__0__Impl rule__ParserRule__Group_1__1 )
            // InternalXtextGrammarTestLanguage.g:2463:2: rule__ParserRule__Group_1__0__Impl rule__ParserRule__Group_1__1
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
    // InternalXtextGrammarTestLanguage.g:2470:1: rule__ParserRule__Group_1__0__Impl : ( 'returns' ) ;
    public final void rule__ParserRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2474:1: ( ( 'returns' ) )
            // InternalXtextGrammarTestLanguage.g:2475:1: ( 'returns' )
            {
            // InternalXtextGrammarTestLanguage.g:2475:1: ( 'returns' )
            // InternalXtextGrammarTestLanguage.g:2476:2: 'returns'
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
    // InternalXtextGrammarTestLanguage.g:2485:1: rule__ParserRule__Group_1__1 : rule__ParserRule__Group_1__1__Impl ;
    public final void rule__ParserRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2489:1: ( rule__ParserRule__Group_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:2490:2: rule__ParserRule__Group_1__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:2496:1: rule__ParserRule__Group_1__1__Impl : ( ( rule__ParserRule__TypeAssignment_1_1 ) ) ;
    public final void rule__ParserRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2500:1: ( ( ( rule__ParserRule__TypeAssignment_1_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:2501:1: ( ( rule__ParserRule__TypeAssignment_1_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2501:1: ( ( rule__ParserRule__TypeAssignment_1_1 ) )
            // InternalXtextGrammarTestLanguage.g:2502:2: ( rule__ParserRule__TypeAssignment_1_1 )
            {
             before(grammarAccess.getParserRuleAccess().getTypeAssignment_1_1()); 
            // InternalXtextGrammarTestLanguage.g:2503:2: ( rule__ParserRule__TypeAssignment_1_1 )
            // InternalXtextGrammarTestLanguage.g:2503:3: rule__ParserRule__TypeAssignment_1_1
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
    // InternalXtextGrammarTestLanguage.g:2512:1: rule__ParserRule__Group_2__0 : rule__ParserRule__Group_2__0__Impl rule__ParserRule__Group_2__1 ;
    public final void rule__ParserRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2516:1: ( rule__ParserRule__Group_2__0__Impl rule__ParserRule__Group_2__1 )
            // InternalXtextGrammarTestLanguage.g:2517:2: rule__ParserRule__Group_2__0__Impl rule__ParserRule__Group_2__1
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
    // InternalXtextGrammarTestLanguage.g:2524:1: rule__ParserRule__Group_2__0__Impl : ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) ) ;
    public final void rule__ParserRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2528:1: ( ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:2529:1: ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2529:1: ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) )
            // InternalXtextGrammarTestLanguage.g:2530:2: ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 )
            {
             before(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensAssignment_2_0()); 
            // InternalXtextGrammarTestLanguage.g:2531:2: ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 )
            // InternalXtextGrammarTestLanguage.g:2531:3: rule__ParserRule__DefinesHiddenTokensAssignment_2_0
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
    // InternalXtextGrammarTestLanguage.g:2539:1: rule__ParserRule__Group_2__1 : rule__ParserRule__Group_2__1__Impl rule__ParserRule__Group_2__2 ;
    public final void rule__ParserRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2543:1: ( rule__ParserRule__Group_2__1__Impl rule__ParserRule__Group_2__2 )
            // InternalXtextGrammarTestLanguage.g:2544:2: rule__ParserRule__Group_2__1__Impl rule__ParserRule__Group_2__2
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
    // InternalXtextGrammarTestLanguage.g:2551:1: rule__ParserRule__Group_2__1__Impl : ( '(' ) ;
    public final void rule__ParserRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2555:1: ( ( '(' ) )
            // InternalXtextGrammarTestLanguage.g:2556:1: ( '(' )
            {
            // InternalXtextGrammarTestLanguage.g:2556:1: ( '(' )
            // InternalXtextGrammarTestLanguage.g:2557:2: '('
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
    // InternalXtextGrammarTestLanguage.g:2566:1: rule__ParserRule__Group_2__2 : rule__ParserRule__Group_2__2__Impl rule__ParserRule__Group_2__3 ;
    public final void rule__ParserRule__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2570:1: ( rule__ParserRule__Group_2__2__Impl rule__ParserRule__Group_2__3 )
            // InternalXtextGrammarTestLanguage.g:2571:2: rule__ParserRule__Group_2__2__Impl rule__ParserRule__Group_2__3
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
    // InternalXtextGrammarTestLanguage.g:2578:1: rule__ParserRule__Group_2__2__Impl : ( ( rule__ParserRule__Group_2_2__0 )? ) ;
    public final void rule__ParserRule__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2582:1: ( ( ( rule__ParserRule__Group_2_2__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:2583:1: ( ( rule__ParserRule__Group_2_2__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:2583:1: ( ( rule__ParserRule__Group_2_2__0 )? )
            // InternalXtextGrammarTestLanguage.g:2584:2: ( rule__ParserRule__Group_2_2__0 )?
            {
             before(grammarAccess.getParserRuleAccess().getGroup_2_2()); 
            // InternalXtextGrammarTestLanguage.g:2585:2: ( rule__ParserRule__Group_2_2__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_ID) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:2585:3: rule__ParserRule__Group_2_2__0
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
    // InternalXtextGrammarTestLanguage.g:2593:1: rule__ParserRule__Group_2__3 : rule__ParserRule__Group_2__3__Impl ;
    public final void rule__ParserRule__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2597:1: ( rule__ParserRule__Group_2__3__Impl )
            // InternalXtextGrammarTestLanguage.g:2598:2: rule__ParserRule__Group_2__3__Impl
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
    // InternalXtextGrammarTestLanguage.g:2604:1: rule__ParserRule__Group_2__3__Impl : ( ')' ) ;
    public final void rule__ParserRule__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2608:1: ( ( ')' ) )
            // InternalXtextGrammarTestLanguage.g:2609:1: ( ')' )
            {
            // InternalXtextGrammarTestLanguage.g:2609:1: ( ')' )
            // InternalXtextGrammarTestLanguage.g:2610:2: ')'
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
    // InternalXtextGrammarTestLanguage.g:2620:1: rule__ParserRule__Group_2_2__0 : rule__ParserRule__Group_2_2__0__Impl rule__ParserRule__Group_2_2__1 ;
    public final void rule__ParserRule__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2624:1: ( rule__ParserRule__Group_2_2__0__Impl rule__ParserRule__Group_2_2__1 )
            // InternalXtextGrammarTestLanguage.g:2625:2: rule__ParserRule__Group_2_2__0__Impl rule__ParserRule__Group_2_2__1
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
    // InternalXtextGrammarTestLanguage.g:2632:1: rule__ParserRule__Group_2_2__0__Impl : ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) ) ;
    public final void rule__ParserRule__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2636:1: ( ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:2637:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2637:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) )
            // InternalXtextGrammarTestLanguage.g:2638:2: ( rule__ParserRule__HiddenTokensAssignment_2_2_0 )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_2_2_0()); 
            // InternalXtextGrammarTestLanguage.g:2639:2: ( rule__ParserRule__HiddenTokensAssignment_2_2_0 )
            // InternalXtextGrammarTestLanguage.g:2639:3: rule__ParserRule__HiddenTokensAssignment_2_2_0
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
    // InternalXtextGrammarTestLanguage.g:2647:1: rule__ParserRule__Group_2_2__1 : rule__ParserRule__Group_2_2__1__Impl ;
    public final void rule__ParserRule__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2651:1: ( rule__ParserRule__Group_2_2__1__Impl )
            // InternalXtextGrammarTestLanguage.g:2652:2: rule__ParserRule__Group_2_2__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:2658:1: rule__ParserRule__Group_2_2__1__Impl : ( ( rule__ParserRule__Group_2_2_1__0 )* ) ;
    public final void rule__ParserRule__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2662:1: ( ( ( rule__ParserRule__Group_2_2_1__0 )* ) )
            // InternalXtextGrammarTestLanguage.g:2663:1: ( ( rule__ParserRule__Group_2_2_1__0 )* )
            {
            // InternalXtextGrammarTestLanguage.g:2663:1: ( ( rule__ParserRule__Group_2_2_1__0 )* )
            // InternalXtextGrammarTestLanguage.g:2664:2: ( rule__ParserRule__Group_2_2_1__0 )*
            {
             before(grammarAccess.getParserRuleAccess().getGroup_2_2_1()); 
            // InternalXtextGrammarTestLanguage.g:2665:2: ( rule__ParserRule__Group_2_2_1__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==19) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:2665:3: rule__ParserRule__Group_2_2_1__0
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
    // InternalXtextGrammarTestLanguage.g:2674:1: rule__ParserRule__Group_2_2_1__0 : rule__ParserRule__Group_2_2_1__0__Impl rule__ParserRule__Group_2_2_1__1 ;
    public final void rule__ParserRule__Group_2_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2678:1: ( rule__ParserRule__Group_2_2_1__0__Impl rule__ParserRule__Group_2_2_1__1 )
            // InternalXtextGrammarTestLanguage.g:2679:2: rule__ParserRule__Group_2_2_1__0__Impl rule__ParserRule__Group_2_2_1__1
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
    // InternalXtextGrammarTestLanguage.g:2686:1: rule__ParserRule__Group_2_2_1__0__Impl : ( ',' ) ;
    public final void rule__ParserRule__Group_2_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2690:1: ( ( ',' ) )
            // InternalXtextGrammarTestLanguage.g:2691:1: ( ',' )
            {
            // InternalXtextGrammarTestLanguage.g:2691:1: ( ',' )
            // InternalXtextGrammarTestLanguage.g:2692:2: ','
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
    // InternalXtextGrammarTestLanguage.g:2701:1: rule__ParserRule__Group_2_2_1__1 : rule__ParserRule__Group_2_2_1__1__Impl ;
    public final void rule__ParserRule__Group_2_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2705:1: ( rule__ParserRule__Group_2_2_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:2706:2: rule__ParserRule__Group_2_2_1__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:2712:1: rule__ParserRule__Group_2_2_1__1__Impl : ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) ) ;
    public final void rule__ParserRule__Group_2_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2716:1: ( ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:2717:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2717:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) )
            // InternalXtextGrammarTestLanguage.g:2718:2: ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_2_2_1_1()); 
            // InternalXtextGrammarTestLanguage.g:2719:2: ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 )
            // InternalXtextGrammarTestLanguage.g:2719:3: rule__ParserRule__HiddenTokensAssignment_2_2_1_1
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
    // InternalXtextGrammarTestLanguage.g:2728:1: rule__TypeRef__Group__0 : rule__TypeRef__Group__0__Impl rule__TypeRef__Group__1 ;
    public final void rule__TypeRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2732:1: ( rule__TypeRef__Group__0__Impl rule__TypeRef__Group__1 )
            // InternalXtextGrammarTestLanguage.g:2733:2: rule__TypeRef__Group__0__Impl rule__TypeRef__Group__1
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
    // InternalXtextGrammarTestLanguage.g:2740:1: rule__TypeRef__Group__0__Impl : ( ( rule__TypeRef__Group_0__0 )? ) ;
    public final void rule__TypeRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2744:1: ( ( ( rule__TypeRef__Group_0__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:2745:1: ( ( rule__TypeRef__Group_0__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:2745:1: ( ( rule__TypeRef__Group_0__0 )? )
            // InternalXtextGrammarTestLanguage.g:2746:2: ( rule__TypeRef__Group_0__0 )?
            {
             before(grammarAccess.getTypeRefAccess().getGroup_0()); 
            // InternalXtextGrammarTestLanguage.g:2747:2: ( rule__TypeRef__Group_0__0 )?
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
                    // InternalXtextGrammarTestLanguage.g:2747:3: rule__TypeRef__Group_0__0
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
    // InternalXtextGrammarTestLanguage.g:2755:1: rule__TypeRef__Group__1 : rule__TypeRef__Group__1__Impl ;
    public final void rule__TypeRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2759:1: ( rule__TypeRef__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:2760:2: rule__TypeRef__Group__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:2766:1: rule__TypeRef__Group__1__Impl : ( ( rule__TypeRef__ClassifierAssignment_1 ) ) ;
    public final void rule__TypeRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2770:1: ( ( ( rule__TypeRef__ClassifierAssignment_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:2771:1: ( ( rule__TypeRef__ClassifierAssignment_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2771:1: ( ( rule__TypeRef__ClassifierAssignment_1 ) )
            // InternalXtextGrammarTestLanguage.g:2772:2: ( rule__TypeRef__ClassifierAssignment_1 )
            {
             before(grammarAccess.getTypeRefAccess().getClassifierAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:2773:2: ( rule__TypeRef__ClassifierAssignment_1 )
            // InternalXtextGrammarTestLanguage.g:2773:3: rule__TypeRef__ClassifierAssignment_1
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
    // InternalXtextGrammarTestLanguage.g:2782:1: rule__TypeRef__Group_0__0 : rule__TypeRef__Group_0__0__Impl rule__TypeRef__Group_0__1 ;
    public final void rule__TypeRef__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2786:1: ( rule__TypeRef__Group_0__0__Impl rule__TypeRef__Group_0__1 )
            // InternalXtextGrammarTestLanguage.g:2787:2: rule__TypeRef__Group_0__0__Impl rule__TypeRef__Group_0__1
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
    // InternalXtextGrammarTestLanguage.g:2794:1: rule__TypeRef__Group_0__0__Impl : ( ( rule__TypeRef__MetamodelAssignment_0_0 ) ) ;
    public final void rule__TypeRef__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2798:1: ( ( ( rule__TypeRef__MetamodelAssignment_0_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:2799:1: ( ( rule__TypeRef__MetamodelAssignment_0_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2799:1: ( ( rule__TypeRef__MetamodelAssignment_0_0 ) )
            // InternalXtextGrammarTestLanguage.g:2800:2: ( rule__TypeRef__MetamodelAssignment_0_0 )
            {
             before(grammarAccess.getTypeRefAccess().getMetamodelAssignment_0_0()); 
            // InternalXtextGrammarTestLanguage.g:2801:2: ( rule__TypeRef__MetamodelAssignment_0_0 )
            // InternalXtextGrammarTestLanguage.g:2801:3: rule__TypeRef__MetamodelAssignment_0_0
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
    // InternalXtextGrammarTestLanguage.g:2809:1: rule__TypeRef__Group_0__1 : rule__TypeRef__Group_0__1__Impl ;
    public final void rule__TypeRef__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2813:1: ( rule__TypeRef__Group_0__1__Impl )
            // InternalXtextGrammarTestLanguage.g:2814:2: rule__TypeRef__Group_0__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:2820:1: rule__TypeRef__Group_0__1__Impl : ( '::' ) ;
    public final void rule__TypeRef__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2824:1: ( ( '::' ) )
            // InternalXtextGrammarTestLanguage.g:2825:1: ( '::' )
            {
            // InternalXtextGrammarTestLanguage.g:2825:1: ( '::' )
            // InternalXtextGrammarTestLanguage.g:2826:2: '::'
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
    // InternalXtextGrammarTestLanguage.g:2836:1: rule__Alternatives__Group__0 : rule__Alternatives__Group__0__Impl rule__Alternatives__Group__1 ;
    public final void rule__Alternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2840:1: ( rule__Alternatives__Group__0__Impl rule__Alternatives__Group__1 )
            // InternalXtextGrammarTestLanguage.g:2841:2: rule__Alternatives__Group__0__Impl rule__Alternatives__Group__1
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
    // InternalXtextGrammarTestLanguage.g:2848:1: rule__Alternatives__Group__0__Impl : ( ruleGroup ) ;
    public final void rule__Alternatives__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2852:1: ( ( ruleGroup ) )
            // InternalXtextGrammarTestLanguage.g:2853:1: ( ruleGroup )
            {
            // InternalXtextGrammarTestLanguage.g:2853:1: ( ruleGroup )
            // InternalXtextGrammarTestLanguage.g:2854:2: ruleGroup
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
    // InternalXtextGrammarTestLanguage.g:2863:1: rule__Alternatives__Group__1 : rule__Alternatives__Group__1__Impl ;
    public final void rule__Alternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2867:1: ( rule__Alternatives__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:2868:2: rule__Alternatives__Group__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:2874:1: rule__Alternatives__Group__1__Impl : ( ( rule__Alternatives__Group_1__0 )? ) ;
    public final void rule__Alternatives__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2878:1: ( ( ( rule__Alternatives__Group_1__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:2879:1: ( ( rule__Alternatives__Group_1__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:2879:1: ( ( rule__Alternatives__Group_1__0 )? )
            // InternalXtextGrammarTestLanguage.g:2880:2: ( rule__Alternatives__Group_1__0 )?
            {
             before(grammarAccess.getAlternativesAccess().getGroup_1()); 
            // InternalXtextGrammarTestLanguage.g:2881:2: ( rule__Alternatives__Group_1__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==30) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:2881:3: rule__Alternatives__Group_1__0
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
    // InternalXtextGrammarTestLanguage.g:2890:1: rule__Alternatives__Group_1__0 : rule__Alternatives__Group_1__0__Impl rule__Alternatives__Group_1__1 ;
    public final void rule__Alternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2894:1: ( rule__Alternatives__Group_1__0__Impl rule__Alternatives__Group_1__1 )
            // InternalXtextGrammarTestLanguage.g:2895:2: rule__Alternatives__Group_1__0__Impl rule__Alternatives__Group_1__1
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
    // InternalXtextGrammarTestLanguage.g:2902:1: rule__Alternatives__Group_1__0__Impl : ( () ) ;
    public final void rule__Alternatives__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2906:1: ( ( () ) )
            // InternalXtextGrammarTestLanguage.g:2907:1: ( () )
            {
            // InternalXtextGrammarTestLanguage.g:2907:1: ( () )
            // InternalXtextGrammarTestLanguage.g:2908:2: ()
            {
             before(grammarAccess.getAlternativesAccess().getAlternativesGroupsAction_1_0()); 
            // InternalXtextGrammarTestLanguage.g:2909:2: ()
            // InternalXtextGrammarTestLanguage.g:2909:3: 
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
    // InternalXtextGrammarTestLanguage.g:2917:1: rule__Alternatives__Group_1__1 : rule__Alternatives__Group_1__1__Impl ;
    public final void rule__Alternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2921:1: ( rule__Alternatives__Group_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:2922:2: rule__Alternatives__Group_1__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:2928:1: rule__Alternatives__Group_1__1__Impl : ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) ) ;
    public final void rule__Alternatives__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2932:1: ( ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) ) )
            // InternalXtextGrammarTestLanguage.g:2933:1: ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) )
            {
            // InternalXtextGrammarTestLanguage.g:2933:1: ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) )
            // InternalXtextGrammarTestLanguage.g:2934:2: ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* )
            {
            // InternalXtextGrammarTestLanguage.g:2934:2: ( ( rule__Alternatives__Group_1_1__0 ) )
            // InternalXtextGrammarTestLanguage.g:2935:3: ( rule__Alternatives__Group_1_1__0 )
            {
             before(grammarAccess.getAlternativesAccess().getGroup_1_1()); 
            // InternalXtextGrammarTestLanguage.g:2936:3: ( rule__Alternatives__Group_1_1__0 )
            // InternalXtextGrammarTestLanguage.g:2936:4: rule__Alternatives__Group_1_1__0
            {
            pushFollow(FOLLOW_20);
            rule__Alternatives__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getAlternativesAccess().getGroup_1_1()); 

            }

            // InternalXtextGrammarTestLanguage.g:2939:2: ( ( rule__Alternatives__Group_1_1__0 )* )
            // InternalXtextGrammarTestLanguage.g:2940:3: ( rule__Alternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getAlternativesAccess().getGroup_1_1()); 
            // InternalXtextGrammarTestLanguage.g:2941:3: ( rule__Alternatives__Group_1_1__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==30) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:2941:4: rule__Alternatives__Group_1_1__0
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
    // InternalXtextGrammarTestLanguage.g:2951:1: rule__Alternatives__Group_1_1__0 : rule__Alternatives__Group_1_1__0__Impl rule__Alternatives__Group_1_1__1 ;
    public final void rule__Alternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2955:1: ( rule__Alternatives__Group_1_1__0__Impl rule__Alternatives__Group_1_1__1 )
            // InternalXtextGrammarTestLanguage.g:2956:2: rule__Alternatives__Group_1_1__0__Impl rule__Alternatives__Group_1_1__1
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
    // InternalXtextGrammarTestLanguage.g:2963:1: rule__Alternatives__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__Alternatives__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2967:1: ( ( '|' ) )
            // InternalXtextGrammarTestLanguage.g:2968:1: ( '|' )
            {
            // InternalXtextGrammarTestLanguage.g:2968:1: ( '|' )
            // InternalXtextGrammarTestLanguage.g:2969:2: '|'
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
    // InternalXtextGrammarTestLanguage.g:2978:1: rule__Alternatives__Group_1_1__1 : rule__Alternatives__Group_1_1__1__Impl ;
    public final void rule__Alternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2982:1: ( rule__Alternatives__Group_1_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:2983:2: rule__Alternatives__Group_1_1__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:2989:1: rule__Alternatives__Group_1_1__1__Impl : ( ( rule__Alternatives__GroupsAssignment_1_1_1 ) ) ;
    public final void rule__Alternatives__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2993:1: ( ( ( rule__Alternatives__GroupsAssignment_1_1_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:2994:1: ( ( rule__Alternatives__GroupsAssignment_1_1_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2994:1: ( ( rule__Alternatives__GroupsAssignment_1_1_1 ) )
            // InternalXtextGrammarTestLanguage.g:2995:2: ( rule__Alternatives__GroupsAssignment_1_1_1 )
            {
             before(grammarAccess.getAlternativesAccess().getGroupsAssignment_1_1_1()); 
            // InternalXtextGrammarTestLanguage.g:2996:2: ( rule__Alternatives__GroupsAssignment_1_1_1 )
            // InternalXtextGrammarTestLanguage.g:2996:3: rule__Alternatives__GroupsAssignment_1_1_1
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
    // InternalXtextGrammarTestLanguage.g:3005:1: rule__Group__Group__0 : rule__Group__Group__0__Impl rule__Group__Group__1 ;
    public final void rule__Group__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3009:1: ( rule__Group__Group__0__Impl rule__Group__Group__1 )
            // InternalXtextGrammarTestLanguage.g:3010:2: rule__Group__Group__0__Impl rule__Group__Group__1
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
    // InternalXtextGrammarTestLanguage.g:3017:1: rule__Group__Group__0__Impl : ( ruleAbstractToken ) ;
    public final void rule__Group__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3021:1: ( ( ruleAbstractToken ) )
            // InternalXtextGrammarTestLanguage.g:3022:1: ( ruleAbstractToken )
            {
            // InternalXtextGrammarTestLanguage.g:3022:1: ( ruleAbstractToken )
            // InternalXtextGrammarTestLanguage.g:3023:2: ruleAbstractToken
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
    // InternalXtextGrammarTestLanguage.g:3032:1: rule__Group__Group__1 : rule__Group__Group__1__Impl ;
    public final void rule__Group__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3036:1: ( rule__Group__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:3037:2: rule__Group__Group__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:3043:1: rule__Group__Group__1__Impl : ( ( rule__Group__Group_1__0 )? ) ;
    public final void rule__Group__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3047:1: ( ( ( rule__Group__Group_1__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:3048:1: ( ( rule__Group__Group_1__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:3048:1: ( ( rule__Group__Group_1__0 )? )
            // InternalXtextGrammarTestLanguage.g:3049:2: ( rule__Group__Group_1__0 )?
            {
             before(grammarAccess.getGroupAccess().getGroup_1()); 
            // InternalXtextGrammarTestLanguage.g:3050:2: ( rule__Group__Group_1__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( ((LA31_0>=RULE_ID && LA31_0<=RULE_STRING)||LA31_0==20||LA31_0==31) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:3050:3: rule__Group__Group_1__0
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
    // InternalXtextGrammarTestLanguage.g:3059:1: rule__Group__Group_1__0 : rule__Group__Group_1__0__Impl rule__Group__Group_1__1 ;
    public final void rule__Group__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3063:1: ( rule__Group__Group_1__0__Impl rule__Group__Group_1__1 )
            // InternalXtextGrammarTestLanguage.g:3064:2: rule__Group__Group_1__0__Impl rule__Group__Group_1__1
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
    // InternalXtextGrammarTestLanguage.g:3071:1: rule__Group__Group_1__0__Impl : ( () ) ;
    public final void rule__Group__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3075:1: ( ( () ) )
            // InternalXtextGrammarTestLanguage.g:3076:1: ( () )
            {
            // InternalXtextGrammarTestLanguage.g:3076:1: ( () )
            // InternalXtextGrammarTestLanguage.g:3077:2: ()
            {
             before(grammarAccess.getGroupAccess().getGroupTokensAction_1_0()); 
            // InternalXtextGrammarTestLanguage.g:3078:2: ()
            // InternalXtextGrammarTestLanguage.g:3078:3: 
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
    // InternalXtextGrammarTestLanguage.g:3086:1: rule__Group__Group_1__1 : rule__Group__Group_1__1__Impl ;
    public final void rule__Group__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3090:1: ( rule__Group__Group_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:3091:2: rule__Group__Group_1__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:3097:1: rule__Group__Group_1__1__Impl : ( ( ( rule__Group__TokensAssignment_1_1 ) ) ( ( rule__Group__TokensAssignment_1_1 )* ) ) ;
    public final void rule__Group__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3101:1: ( ( ( ( rule__Group__TokensAssignment_1_1 ) ) ( ( rule__Group__TokensAssignment_1_1 )* ) ) )
            // InternalXtextGrammarTestLanguage.g:3102:1: ( ( ( rule__Group__TokensAssignment_1_1 ) ) ( ( rule__Group__TokensAssignment_1_1 )* ) )
            {
            // InternalXtextGrammarTestLanguage.g:3102:1: ( ( ( rule__Group__TokensAssignment_1_1 ) ) ( ( rule__Group__TokensAssignment_1_1 )* ) )
            // InternalXtextGrammarTestLanguage.g:3103:2: ( ( rule__Group__TokensAssignment_1_1 ) ) ( ( rule__Group__TokensAssignment_1_1 )* )
            {
            // InternalXtextGrammarTestLanguage.g:3103:2: ( ( rule__Group__TokensAssignment_1_1 ) )
            // InternalXtextGrammarTestLanguage.g:3104:3: ( rule__Group__TokensAssignment_1_1 )
            {
             before(grammarAccess.getGroupAccess().getTokensAssignment_1_1()); 
            // InternalXtextGrammarTestLanguage.g:3105:3: ( rule__Group__TokensAssignment_1_1 )
            // InternalXtextGrammarTestLanguage.g:3105:4: rule__Group__TokensAssignment_1_1
            {
            pushFollow(FOLLOW_21);
            rule__Group__TokensAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getGroupAccess().getTokensAssignment_1_1()); 

            }

            // InternalXtextGrammarTestLanguage.g:3108:2: ( ( rule__Group__TokensAssignment_1_1 )* )
            // InternalXtextGrammarTestLanguage.g:3109:3: ( rule__Group__TokensAssignment_1_1 )*
            {
             before(grammarAccess.getGroupAccess().getTokensAssignment_1_1()); 
            // InternalXtextGrammarTestLanguage.g:3110:3: ( rule__Group__TokensAssignment_1_1 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0>=RULE_ID && LA32_0<=RULE_STRING)||LA32_0==20||LA32_0==31) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:3110:4: rule__Group__TokensAssignment_1_1
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
    // InternalXtextGrammarTestLanguage.g:3120:1: rule__AbstractTokenWithCardinality__Group__0 : rule__AbstractTokenWithCardinality__Group__0__Impl rule__AbstractTokenWithCardinality__Group__1 ;
    public final void rule__AbstractTokenWithCardinality__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3124:1: ( rule__AbstractTokenWithCardinality__Group__0__Impl rule__AbstractTokenWithCardinality__Group__1 )
            // InternalXtextGrammarTestLanguage.g:3125:2: rule__AbstractTokenWithCardinality__Group__0__Impl rule__AbstractTokenWithCardinality__Group__1
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
    // InternalXtextGrammarTestLanguage.g:3132:1: rule__AbstractTokenWithCardinality__Group__0__Impl : ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) ) ;
    public final void rule__AbstractTokenWithCardinality__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3136:1: ( ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:3137:1: ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:3137:1: ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) )
            // InternalXtextGrammarTestLanguage.g:3138:2: ( rule__AbstractTokenWithCardinality__Alternatives_0 )
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getAlternatives_0()); 
            // InternalXtextGrammarTestLanguage.g:3139:2: ( rule__AbstractTokenWithCardinality__Alternatives_0 )
            // InternalXtextGrammarTestLanguage.g:3139:3: rule__AbstractTokenWithCardinality__Alternatives_0
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
    // InternalXtextGrammarTestLanguage.g:3147:1: rule__AbstractTokenWithCardinality__Group__1 : rule__AbstractTokenWithCardinality__Group__1__Impl ;
    public final void rule__AbstractTokenWithCardinality__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3151:1: ( rule__AbstractTokenWithCardinality__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:3152:2: rule__AbstractTokenWithCardinality__Group__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:3158:1: rule__AbstractTokenWithCardinality__Group__1__Impl : ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? ) ;
    public final void rule__AbstractTokenWithCardinality__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3162:1: ( ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? ) )
            // InternalXtextGrammarTestLanguage.g:3163:1: ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? )
            {
            // InternalXtextGrammarTestLanguage.g:3163:1: ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? )
            // InternalXtextGrammarTestLanguage.g:3164:2: ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )?
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:3165:2: ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=11 && LA33_0<=13)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:3165:3: rule__AbstractTokenWithCardinality__CardinalityAssignment_1
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
    // InternalXtextGrammarTestLanguage.g:3174:1: rule__Action__Group__0 : rule__Action__Group__0__Impl rule__Action__Group__1 ;
    public final void rule__Action__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3178:1: ( rule__Action__Group__0__Impl rule__Action__Group__1 )
            // InternalXtextGrammarTestLanguage.g:3179:2: rule__Action__Group__0__Impl rule__Action__Group__1
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
    // InternalXtextGrammarTestLanguage.g:3186:1: rule__Action__Group__0__Impl : ( '{' ) ;
    public final void rule__Action__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3190:1: ( ( '{' ) )
            // InternalXtextGrammarTestLanguage.g:3191:1: ( '{' )
            {
            // InternalXtextGrammarTestLanguage.g:3191:1: ( '{' )
            // InternalXtextGrammarTestLanguage.g:3192:2: '{'
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
    // InternalXtextGrammarTestLanguage.g:3201:1: rule__Action__Group__1 : rule__Action__Group__1__Impl rule__Action__Group__2 ;
    public final void rule__Action__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3205:1: ( rule__Action__Group__1__Impl rule__Action__Group__2 )
            // InternalXtextGrammarTestLanguage.g:3206:2: rule__Action__Group__1__Impl rule__Action__Group__2
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
    // InternalXtextGrammarTestLanguage.g:3213:1: rule__Action__Group__1__Impl : ( ( rule__Action__TypeAssignment_1 ) ) ;
    public final void rule__Action__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3217:1: ( ( ( rule__Action__TypeAssignment_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:3218:1: ( ( rule__Action__TypeAssignment_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:3218:1: ( ( rule__Action__TypeAssignment_1 ) )
            // InternalXtextGrammarTestLanguage.g:3219:2: ( rule__Action__TypeAssignment_1 )
            {
             before(grammarAccess.getActionAccess().getTypeAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:3220:2: ( rule__Action__TypeAssignment_1 )
            // InternalXtextGrammarTestLanguage.g:3220:3: rule__Action__TypeAssignment_1
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
    // InternalXtextGrammarTestLanguage.g:3228:1: rule__Action__Group__2 : rule__Action__Group__2__Impl rule__Action__Group__3 ;
    public final void rule__Action__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3232:1: ( rule__Action__Group__2__Impl rule__Action__Group__3 )
            // InternalXtextGrammarTestLanguage.g:3233:2: rule__Action__Group__2__Impl rule__Action__Group__3
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
    // InternalXtextGrammarTestLanguage.g:3240:1: rule__Action__Group__2__Impl : ( ( rule__Action__Group_2__0 )? ) ;
    public final void rule__Action__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3244:1: ( ( ( rule__Action__Group_2__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:3245:1: ( ( rule__Action__Group_2__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:3245:1: ( ( rule__Action__Group_2__0 )? )
            // InternalXtextGrammarTestLanguage.g:3246:2: ( rule__Action__Group_2__0 )?
            {
             before(grammarAccess.getActionAccess().getGroup_2()); 
            // InternalXtextGrammarTestLanguage.g:3247:2: ( rule__Action__Group_2__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==22) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:3247:3: rule__Action__Group_2__0
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
    // InternalXtextGrammarTestLanguage.g:3255:1: rule__Action__Group__3 : rule__Action__Group__3__Impl ;
    public final void rule__Action__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3259:1: ( rule__Action__Group__3__Impl )
            // InternalXtextGrammarTestLanguage.g:3260:2: rule__Action__Group__3__Impl
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
    // InternalXtextGrammarTestLanguage.g:3266:1: rule__Action__Group__3__Impl : ( '}' ) ;
    public final void rule__Action__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3270:1: ( ( '}' ) )
            // InternalXtextGrammarTestLanguage.g:3271:1: ( '}' )
            {
            // InternalXtextGrammarTestLanguage.g:3271:1: ( '}' )
            // InternalXtextGrammarTestLanguage.g:3272:2: '}'
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
    // InternalXtextGrammarTestLanguage.g:3282:1: rule__Action__Group_2__0 : rule__Action__Group_2__0__Impl rule__Action__Group_2__1 ;
    public final void rule__Action__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3286:1: ( rule__Action__Group_2__0__Impl rule__Action__Group_2__1 )
            // InternalXtextGrammarTestLanguage.g:3287:2: rule__Action__Group_2__0__Impl rule__Action__Group_2__1
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
    // InternalXtextGrammarTestLanguage.g:3294:1: rule__Action__Group_2__0__Impl : ( '.' ) ;
    public final void rule__Action__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3298:1: ( ( '.' ) )
            // InternalXtextGrammarTestLanguage.g:3299:1: ( '.' )
            {
            // InternalXtextGrammarTestLanguage.g:3299:1: ( '.' )
            // InternalXtextGrammarTestLanguage.g:3300:2: '.'
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
    // InternalXtextGrammarTestLanguage.g:3309:1: rule__Action__Group_2__1 : rule__Action__Group_2__1__Impl rule__Action__Group_2__2 ;
    public final void rule__Action__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3313:1: ( rule__Action__Group_2__1__Impl rule__Action__Group_2__2 )
            // InternalXtextGrammarTestLanguage.g:3314:2: rule__Action__Group_2__1__Impl rule__Action__Group_2__2
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
    // InternalXtextGrammarTestLanguage.g:3321:1: rule__Action__Group_2__1__Impl : ( ( rule__Action__FeatureAssignment_2_1 ) ) ;
    public final void rule__Action__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3325:1: ( ( ( rule__Action__FeatureAssignment_2_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:3326:1: ( ( rule__Action__FeatureAssignment_2_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:3326:1: ( ( rule__Action__FeatureAssignment_2_1 ) )
            // InternalXtextGrammarTestLanguage.g:3327:2: ( rule__Action__FeatureAssignment_2_1 )
            {
             before(grammarAccess.getActionAccess().getFeatureAssignment_2_1()); 
            // InternalXtextGrammarTestLanguage.g:3328:2: ( rule__Action__FeatureAssignment_2_1 )
            // InternalXtextGrammarTestLanguage.g:3328:3: rule__Action__FeatureAssignment_2_1
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
    // InternalXtextGrammarTestLanguage.g:3336:1: rule__Action__Group_2__2 : rule__Action__Group_2__2__Impl rule__Action__Group_2__3 ;
    public final void rule__Action__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3340:1: ( rule__Action__Group_2__2__Impl rule__Action__Group_2__3 )
            // InternalXtextGrammarTestLanguage.g:3341:2: rule__Action__Group_2__2__Impl rule__Action__Group_2__3
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
    // InternalXtextGrammarTestLanguage.g:3348:1: rule__Action__Group_2__2__Impl : ( ( rule__Action__OperatorAssignment_2_2 ) ) ;
    public final void rule__Action__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3352:1: ( ( ( rule__Action__OperatorAssignment_2_2 ) ) )
            // InternalXtextGrammarTestLanguage.g:3353:1: ( ( rule__Action__OperatorAssignment_2_2 ) )
            {
            // InternalXtextGrammarTestLanguage.g:3353:1: ( ( rule__Action__OperatorAssignment_2_2 ) )
            // InternalXtextGrammarTestLanguage.g:3354:2: ( rule__Action__OperatorAssignment_2_2 )
            {
             before(grammarAccess.getActionAccess().getOperatorAssignment_2_2()); 
            // InternalXtextGrammarTestLanguage.g:3355:2: ( rule__Action__OperatorAssignment_2_2 )
            // InternalXtextGrammarTestLanguage.g:3355:3: rule__Action__OperatorAssignment_2_2
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
    // InternalXtextGrammarTestLanguage.g:3363:1: rule__Action__Group_2__3 : rule__Action__Group_2__3__Impl ;
    public final void rule__Action__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3367:1: ( rule__Action__Group_2__3__Impl )
            // InternalXtextGrammarTestLanguage.g:3368:2: rule__Action__Group_2__3__Impl
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
    // InternalXtextGrammarTestLanguage.g:3374:1: rule__Action__Group_2__3__Impl : ( 'current' ) ;
    public final void rule__Action__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3378:1: ( ( 'current' ) )
            // InternalXtextGrammarTestLanguage.g:3379:1: ( 'current' )
            {
            // InternalXtextGrammarTestLanguage.g:3379:1: ( 'current' )
            // InternalXtextGrammarTestLanguage.g:3380:2: 'current'
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
    // InternalXtextGrammarTestLanguage.g:3390:1: rule__Assignment__Group__0 : rule__Assignment__Group__0__Impl rule__Assignment__Group__1 ;
    public final void rule__Assignment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3394:1: ( rule__Assignment__Group__0__Impl rule__Assignment__Group__1 )
            // InternalXtextGrammarTestLanguage.g:3395:2: rule__Assignment__Group__0__Impl rule__Assignment__Group__1
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
    // InternalXtextGrammarTestLanguage.g:3402:1: rule__Assignment__Group__0__Impl : ( ( rule__Assignment__FeatureAssignment_0 ) ) ;
    public final void rule__Assignment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3406:1: ( ( ( rule__Assignment__FeatureAssignment_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:3407:1: ( ( rule__Assignment__FeatureAssignment_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:3407:1: ( ( rule__Assignment__FeatureAssignment_0 ) )
            // InternalXtextGrammarTestLanguage.g:3408:2: ( rule__Assignment__FeatureAssignment_0 )
            {
             before(grammarAccess.getAssignmentAccess().getFeatureAssignment_0()); 
            // InternalXtextGrammarTestLanguage.g:3409:2: ( rule__Assignment__FeatureAssignment_0 )
            // InternalXtextGrammarTestLanguage.g:3409:3: rule__Assignment__FeatureAssignment_0
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
    // InternalXtextGrammarTestLanguage.g:3417:1: rule__Assignment__Group__1 : rule__Assignment__Group__1__Impl rule__Assignment__Group__2 ;
    public final void rule__Assignment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3421:1: ( rule__Assignment__Group__1__Impl rule__Assignment__Group__2 )
            // InternalXtextGrammarTestLanguage.g:3422:2: rule__Assignment__Group__1__Impl rule__Assignment__Group__2
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
    // InternalXtextGrammarTestLanguage.g:3429:1: rule__Assignment__Group__1__Impl : ( ( rule__Assignment__OperatorAssignment_1 ) ) ;
    public final void rule__Assignment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3433:1: ( ( ( rule__Assignment__OperatorAssignment_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:3434:1: ( ( rule__Assignment__OperatorAssignment_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:3434:1: ( ( rule__Assignment__OperatorAssignment_1 ) )
            // InternalXtextGrammarTestLanguage.g:3435:2: ( rule__Assignment__OperatorAssignment_1 )
            {
             before(grammarAccess.getAssignmentAccess().getOperatorAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:3436:2: ( rule__Assignment__OperatorAssignment_1 )
            // InternalXtextGrammarTestLanguage.g:3436:3: rule__Assignment__OperatorAssignment_1
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
    // InternalXtextGrammarTestLanguage.g:3444:1: rule__Assignment__Group__2 : rule__Assignment__Group__2__Impl ;
    public final void rule__Assignment__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3448:1: ( rule__Assignment__Group__2__Impl )
            // InternalXtextGrammarTestLanguage.g:3449:2: rule__Assignment__Group__2__Impl
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
    // InternalXtextGrammarTestLanguage.g:3455:1: rule__Assignment__Group__2__Impl : ( ( rule__Assignment__TerminalAssignment_2 ) ) ;
    public final void rule__Assignment__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3459:1: ( ( ( rule__Assignment__TerminalAssignment_2 ) ) )
            // InternalXtextGrammarTestLanguage.g:3460:1: ( ( rule__Assignment__TerminalAssignment_2 ) )
            {
            // InternalXtextGrammarTestLanguage.g:3460:1: ( ( rule__Assignment__TerminalAssignment_2 ) )
            // InternalXtextGrammarTestLanguage.g:3461:2: ( rule__Assignment__TerminalAssignment_2 )
            {
             before(grammarAccess.getAssignmentAccess().getTerminalAssignment_2()); 
            // InternalXtextGrammarTestLanguage.g:3462:2: ( rule__Assignment__TerminalAssignment_2 )
            // InternalXtextGrammarTestLanguage.g:3462:3: rule__Assignment__TerminalAssignment_2
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
    // InternalXtextGrammarTestLanguage.g:3471:1: rule__ParenthesizedAssignableElement__Group__0 : rule__ParenthesizedAssignableElement__Group__0__Impl rule__ParenthesizedAssignableElement__Group__1 ;
    public final void rule__ParenthesizedAssignableElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3475:1: ( rule__ParenthesizedAssignableElement__Group__0__Impl rule__ParenthesizedAssignableElement__Group__1 )
            // InternalXtextGrammarTestLanguage.g:3476:2: rule__ParenthesizedAssignableElement__Group__0__Impl rule__ParenthesizedAssignableElement__Group__1
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
    // InternalXtextGrammarTestLanguage.g:3483:1: rule__ParenthesizedAssignableElement__Group__0__Impl : ( '(' ) ;
    public final void rule__ParenthesizedAssignableElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3487:1: ( ( '(' ) )
            // InternalXtextGrammarTestLanguage.g:3488:1: ( '(' )
            {
            // InternalXtextGrammarTestLanguage.g:3488:1: ( '(' )
            // InternalXtextGrammarTestLanguage.g:3489:2: '('
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
    // InternalXtextGrammarTestLanguage.g:3498:1: rule__ParenthesizedAssignableElement__Group__1 : rule__ParenthesizedAssignableElement__Group__1__Impl rule__ParenthesizedAssignableElement__Group__2 ;
    public final void rule__ParenthesizedAssignableElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3502:1: ( rule__ParenthesizedAssignableElement__Group__1__Impl rule__ParenthesizedAssignableElement__Group__2 )
            // InternalXtextGrammarTestLanguage.g:3503:2: rule__ParenthesizedAssignableElement__Group__1__Impl rule__ParenthesizedAssignableElement__Group__2
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
    // InternalXtextGrammarTestLanguage.g:3510:1: rule__ParenthesizedAssignableElement__Group__1__Impl : ( ruleAssignableAlternatives ) ;
    public final void rule__ParenthesizedAssignableElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3514:1: ( ( ruleAssignableAlternatives ) )
            // InternalXtextGrammarTestLanguage.g:3515:1: ( ruleAssignableAlternatives )
            {
            // InternalXtextGrammarTestLanguage.g:3515:1: ( ruleAssignableAlternatives )
            // InternalXtextGrammarTestLanguage.g:3516:2: ruleAssignableAlternatives
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
    // InternalXtextGrammarTestLanguage.g:3525:1: rule__ParenthesizedAssignableElement__Group__2 : rule__ParenthesizedAssignableElement__Group__2__Impl ;
    public final void rule__ParenthesizedAssignableElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3529:1: ( rule__ParenthesizedAssignableElement__Group__2__Impl )
            // InternalXtextGrammarTestLanguage.g:3530:2: rule__ParenthesizedAssignableElement__Group__2__Impl
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
    // InternalXtextGrammarTestLanguage.g:3536:1: rule__ParenthesizedAssignableElement__Group__2__Impl : ( ')' ) ;
    public final void rule__ParenthesizedAssignableElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3540:1: ( ( ')' ) )
            // InternalXtextGrammarTestLanguage.g:3541:1: ( ')' )
            {
            // InternalXtextGrammarTestLanguage.g:3541:1: ( ')' )
            // InternalXtextGrammarTestLanguage.g:3542:2: ')'
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
    // InternalXtextGrammarTestLanguage.g:3552:1: rule__AssignableAlternatives__Group__0 : rule__AssignableAlternatives__Group__0__Impl rule__AssignableAlternatives__Group__1 ;
    public final void rule__AssignableAlternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3556:1: ( rule__AssignableAlternatives__Group__0__Impl rule__AssignableAlternatives__Group__1 )
            // InternalXtextGrammarTestLanguage.g:3557:2: rule__AssignableAlternatives__Group__0__Impl rule__AssignableAlternatives__Group__1
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
    // InternalXtextGrammarTestLanguage.g:3564:1: rule__AssignableAlternatives__Group__0__Impl : ( ruleAssignableTerminal ) ;
    public final void rule__AssignableAlternatives__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3568:1: ( ( ruleAssignableTerminal ) )
            // InternalXtextGrammarTestLanguage.g:3569:1: ( ruleAssignableTerminal )
            {
            // InternalXtextGrammarTestLanguage.g:3569:1: ( ruleAssignableTerminal )
            // InternalXtextGrammarTestLanguage.g:3570:2: ruleAssignableTerminal
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
    // InternalXtextGrammarTestLanguage.g:3579:1: rule__AssignableAlternatives__Group__1 : rule__AssignableAlternatives__Group__1__Impl ;
    public final void rule__AssignableAlternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3583:1: ( rule__AssignableAlternatives__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:3584:2: rule__AssignableAlternatives__Group__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:3590:1: rule__AssignableAlternatives__Group__1__Impl : ( ( rule__AssignableAlternatives__Group_1__0 )? ) ;
    public final void rule__AssignableAlternatives__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3594:1: ( ( ( rule__AssignableAlternatives__Group_1__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:3595:1: ( ( rule__AssignableAlternatives__Group_1__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:3595:1: ( ( rule__AssignableAlternatives__Group_1__0 )? )
            // InternalXtextGrammarTestLanguage.g:3596:2: ( rule__AssignableAlternatives__Group_1__0 )?
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup_1()); 
            // InternalXtextGrammarTestLanguage.g:3597:2: ( rule__AssignableAlternatives__Group_1__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==30) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:3597:3: rule__AssignableAlternatives__Group_1__0
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
    // InternalXtextGrammarTestLanguage.g:3606:1: rule__AssignableAlternatives__Group_1__0 : rule__AssignableAlternatives__Group_1__0__Impl rule__AssignableAlternatives__Group_1__1 ;
    public final void rule__AssignableAlternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3610:1: ( rule__AssignableAlternatives__Group_1__0__Impl rule__AssignableAlternatives__Group_1__1 )
            // InternalXtextGrammarTestLanguage.g:3611:2: rule__AssignableAlternatives__Group_1__0__Impl rule__AssignableAlternatives__Group_1__1
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
    // InternalXtextGrammarTestLanguage.g:3618:1: rule__AssignableAlternatives__Group_1__0__Impl : ( () ) ;
    public final void rule__AssignableAlternatives__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3622:1: ( ( () ) )
            // InternalXtextGrammarTestLanguage.g:3623:1: ( () )
            {
            // InternalXtextGrammarTestLanguage.g:3623:1: ( () )
            // InternalXtextGrammarTestLanguage.g:3624:2: ()
            {
             before(grammarAccess.getAssignableAlternativesAccess().getAlternativesGroupsAction_1_0()); 
            // InternalXtextGrammarTestLanguage.g:3625:2: ()
            // InternalXtextGrammarTestLanguage.g:3625:3: 
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
    // InternalXtextGrammarTestLanguage.g:3633:1: rule__AssignableAlternatives__Group_1__1 : rule__AssignableAlternatives__Group_1__1__Impl ;
    public final void rule__AssignableAlternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3637:1: ( rule__AssignableAlternatives__Group_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:3638:2: rule__AssignableAlternatives__Group_1__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:3644:1: rule__AssignableAlternatives__Group_1__1__Impl : ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) ) ;
    public final void rule__AssignableAlternatives__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3648:1: ( ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) ) )
            // InternalXtextGrammarTestLanguage.g:3649:1: ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) )
            {
            // InternalXtextGrammarTestLanguage.g:3649:1: ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) )
            // InternalXtextGrammarTestLanguage.g:3650:2: ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* )
            {
            // InternalXtextGrammarTestLanguage.g:3650:2: ( ( rule__AssignableAlternatives__Group_1_1__0 ) )
            // InternalXtextGrammarTestLanguage.g:3651:3: ( rule__AssignableAlternatives__Group_1_1__0 )
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 
            // InternalXtextGrammarTestLanguage.g:3652:3: ( rule__AssignableAlternatives__Group_1_1__0 )
            // InternalXtextGrammarTestLanguage.g:3652:4: rule__AssignableAlternatives__Group_1_1__0
            {
            pushFollow(FOLLOW_20);
            rule__AssignableAlternatives__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 

            }

            // InternalXtextGrammarTestLanguage.g:3655:2: ( ( rule__AssignableAlternatives__Group_1_1__0 )* )
            // InternalXtextGrammarTestLanguage.g:3656:3: ( rule__AssignableAlternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 
            // InternalXtextGrammarTestLanguage.g:3657:3: ( rule__AssignableAlternatives__Group_1_1__0 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==30) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:3657:4: rule__AssignableAlternatives__Group_1_1__0
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
    // InternalXtextGrammarTestLanguage.g:3667:1: rule__AssignableAlternatives__Group_1_1__0 : rule__AssignableAlternatives__Group_1_1__0__Impl rule__AssignableAlternatives__Group_1_1__1 ;
    public final void rule__AssignableAlternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3671:1: ( rule__AssignableAlternatives__Group_1_1__0__Impl rule__AssignableAlternatives__Group_1_1__1 )
            // InternalXtextGrammarTestLanguage.g:3672:2: rule__AssignableAlternatives__Group_1_1__0__Impl rule__AssignableAlternatives__Group_1_1__1
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
    // InternalXtextGrammarTestLanguage.g:3679:1: rule__AssignableAlternatives__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__AssignableAlternatives__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3683:1: ( ( '|' ) )
            // InternalXtextGrammarTestLanguage.g:3684:1: ( '|' )
            {
            // InternalXtextGrammarTestLanguage.g:3684:1: ( '|' )
            // InternalXtextGrammarTestLanguage.g:3685:2: '|'
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
    // InternalXtextGrammarTestLanguage.g:3694:1: rule__AssignableAlternatives__Group_1_1__1 : rule__AssignableAlternatives__Group_1_1__1__Impl ;
    public final void rule__AssignableAlternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3698:1: ( rule__AssignableAlternatives__Group_1_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:3699:2: rule__AssignableAlternatives__Group_1_1__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:3705:1: rule__AssignableAlternatives__Group_1_1__1__Impl : ( ( rule__AssignableAlternatives__GroupsAssignment_1_1_1 ) ) ;
    public final void rule__AssignableAlternatives__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3709:1: ( ( ( rule__AssignableAlternatives__GroupsAssignment_1_1_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:3710:1: ( ( rule__AssignableAlternatives__GroupsAssignment_1_1_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:3710:1: ( ( rule__AssignableAlternatives__GroupsAssignment_1_1_1 ) )
            // InternalXtextGrammarTestLanguage.g:3711:2: ( rule__AssignableAlternatives__GroupsAssignment_1_1_1 )
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroupsAssignment_1_1_1()); 
            // InternalXtextGrammarTestLanguage.g:3712:2: ( rule__AssignableAlternatives__GroupsAssignment_1_1_1 )
            // InternalXtextGrammarTestLanguage.g:3712:3: rule__AssignableAlternatives__GroupsAssignment_1_1_1
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
    // InternalXtextGrammarTestLanguage.g:3721:1: rule__CrossReference__Group__0 : rule__CrossReference__Group__0__Impl rule__CrossReference__Group__1 ;
    public final void rule__CrossReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3725:1: ( rule__CrossReference__Group__0__Impl rule__CrossReference__Group__1 )
            // InternalXtextGrammarTestLanguage.g:3726:2: rule__CrossReference__Group__0__Impl rule__CrossReference__Group__1
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
    // InternalXtextGrammarTestLanguage.g:3733:1: rule__CrossReference__Group__0__Impl : ( '[' ) ;
    public final void rule__CrossReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3737:1: ( ( '[' ) )
            // InternalXtextGrammarTestLanguage.g:3738:1: ( '[' )
            {
            // InternalXtextGrammarTestLanguage.g:3738:1: ( '[' )
            // InternalXtextGrammarTestLanguage.g:3739:2: '['
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
    // InternalXtextGrammarTestLanguage.g:3748:1: rule__CrossReference__Group__1 : rule__CrossReference__Group__1__Impl rule__CrossReference__Group__2 ;
    public final void rule__CrossReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3752:1: ( rule__CrossReference__Group__1__Impl rule__CrossReference__Group__2 )
            // InternalXtextGrammarTestLanguage.g:3753:2: rule__CrossReference__Group__1__Impl rule__CrossReference__Group__2
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
    // InternalXtextGrammarTestLanguage.g:3760:1: rule__CrossReference__Group__1__Impl : ( ( rule__CrossReference__TypeAssignment_1 ) ) ;
    public final void rule__CrossReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3764:1: ( ( ( rule__CrossReference__TypeAssignment_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:3765:1: ( ( rule__CrossReference__TypeAssignment_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:3765:1: ( ( rule__CrossReference__TypeAssignment_1 ) )
            // InternalXtextGrammarTestLanguage.g:3766:2: ( rule__CrossReference__TypeAssignment_1 )
            {
             before(grammarAccess.getCrossReferenceAccess().getTypeAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:3767:2: ( rule__CrossReference__TypeAssignment_1 )
            // InternalXtextGrammarTestLanguage.g:3767:3: rule__CrossReference__TypeAssignment_1
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
    // InternalXtextGrammarTestLanguage.g:3775:1: rule__CrossReference__Group__2 : rule__CrossReference__Group__2__Impl rule__CrossReference__Group__3 ;
    public final void rule__CrossReference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3779:1: ( rule__CrossReference__Group__2__Impl rule__CrossReference__Group__3 )
            // InternalXtextGrammarTestLanguage.g:3780:2: rule__CrossReference__Group__2__Impl rule__CrossReference__Group__3
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
    // InternalXtextGrammarTestLanguage.g:3787:1: rule__CrossReference__Group__2__Impl : ( ( rule__CrossReference__Group_2__0 )? ) ;
    public final void rule__CrossReference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3791:1: ( ( ( rule__CrossReference__Group_2__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:3792:1: ( ( rule__CrossReference__Group_2__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:3792:1: ( ( rule__CrossReference__Group_2__0 )? )
            // InternalXtextGrammarTestLanguage.g:3793:2: ( rule__CrossReference__Group_2__0 )?
            {
             before(grammarAccess.getCrossReferenceAccess().getGroup_2()); 
            // InternalXtextGrammarTestLanguage.g:3794:2: ( rule__CrossReference__Group_2__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==30) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:3794:3: rule__CrossReference__Group_2__0
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
    // InternalXtextGrammarTestLanguage.g:3802:1: rule__CrossReference__Group__3 : rule__CrossReference__Group__3__Impl ;
    public final void rule__CrossReference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3806:1: ( rule__CrossReference__Group__3__Impl )
            // InternalXtextGrammarTestLanguage.g:3807:2: rule__CrossReference__Group__3__Impl
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
    // InternalXtextGrammarTestLanguage.g:3813:1: rule__CrossReference__Group__3__Impl : ( ']' ) ;
    public final void rule__CrossReference__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3817:1: ( ( ']' ) )
            // InternalXtextGrammarTestLanguage.g:3818:1: ( ']' )
            {
            // InternalXtextGrammarTestLanguage.g:3818:1: ( ']' )
            // InternalXtextGrammarTestLanguage.g:3819:2: ']'
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
    // InternalXtextGrammarTestLanguage.g:3829:1: rule__CrossReference__Group_2__0 : rule__CrossReference__Group_2__0__Impl rule__CrossReference__Group_2__1 ;
    public final void rule__CrossReference__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3833:1: ( rule__CrossReference__Group_2__0__Impl rule__CrossReference__Group_2__1 )
            // InternalXtextGrammarTestLanguage.g:3834:2: rule__CrossReference__Group_2__0__Impl rule__CrossReference__Group_2__1
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
    // InternalXtextGrammarTestLanguage.g:3841:1: rule__CrossReference__Group_2__0__Impl : ( '|' ) ;
    public final void rule__CrossReference__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3845:1: ( ( '|' ) )
            // InternalXtextGrammarTestLanguage.g:3846:1: ( '|' )
            {
            // InternalXtextGrammarTestLanguage.g:3846:1: ( '|' )
            // InternalXtextGrammarTestLanguage.g:3847:2: '|'
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
    // InternalXtextGrammarTestLanguage.g:3856:1: rule__CrossReference__Group_2__1 : rule__CrossReference__Group_2__1__Impl ;
    public final void rule__CrossReference__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3860:1: ( rule__CrossReference__Group_2__1__Impl )
            // InternalXtextGrammarTestLanguage.g:3861:2: rule__CrossReference__Group_2__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:3867:1: rule__CrossReference__Group_2__1__Impl : ( ( rule__CrossReference__TerminalAssignment_2_1 ) ) ;
    public final void rule__CrossReference__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3871:1: ( ( ( rule__CrossReference__TerminalAssignment_2_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:3872:1: ( ( rule__CrossReference__TerminalAssignment_2_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:3872:1: ( ( rule__CrossReference__TerminalAssignment_2_1 ) )
            // InternalXtextGrammarTestLanguage.g:3873:2: ( rule__CrossReference__TerminalAssignment_2_1 )
            {
             before(grammarAccess.getCrossReferenceAccess().getTerminalAssignment_2_1()); 
            // InternalXtextGrammarTestLanguage.g:3874:2: ( rule__CrossReference__TerminalAssignment_2_1 )
            // InternalXtextGrammarTestLanguage.g:3874:3: rule__CrossReference__TerminalAssignment_2_1
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
    // InternalXtextGrammarTestLanguage.g:3883:1: rule__ParenthesizedCrossReferenceableElement__Group__0 : rule__ParenthesizedCrossReferenceableElement__Group__0__Impl rule__ParenthesizedCrossReferenceableElement__Group__1 ;
    public final void rule__ParenthesizedCrossReferenceableElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3887:1: ( rule__ParenthesizedCrossReferenceableElement__Group__0__Impl rule__ParenthesizedCrossReferenceableElement__Group__1 )
            // InternalXtextGrammarTestLanguage.g:3888:2: rule__ParenthesizedCrossReferenceableElement__Group__0__Impl rule__ParenthesizedCrossReferenceableElement__Group__1
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
    // InternalXtextGrammarTestLanguage.g:3895:1: rule__ParenthesizedCrossReferenceableElement__Group__0__Impl : ( '(' ) ;
    public final void rule__ParenthesizedCrossReferenceableElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3899:1: ( ( '(' ) )
            // InternalXtextGrammarTestLanguage.g:3900:1: ( '(' )
            {
            // InternalXtextGrammarTestLanguage.g:3900:1: ( '(' )
            // InternalXtextGrammarTestLanguage.g:3901:2: '('
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
    // InternalXtextGrammarTestLanguage.g:3910:1: rule__ParenthesizedCrossReferenceableElement__Group__1 : rule__ParenthesizedCrossReferenceableElement__Group__1__Impl rule__ParenthesizedCrossReferenceableElement__Group__2 ;
    public final void rule__ParenthesizedCrossReferenceableElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3914:1: ( rule__ParenthesizedCrossReferenceableElement__Group__1__Impl rule__ParenthesizedCrossReferenceableElement__Group__2 )
            // InternalXtextGrammarTestLanguage.g:3915:2: rule__ParenthesizedCrossReferenceableElement__Group__1__Impl rule__ParenthesizedCrossReferenceableElement__Group__2
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
    // InternalXtextGrammarTestLanguage.g:3922:1: rule__ParenthesizedCrossReferenceableElement__Group__1__Impl : ( ruleCrossReferenceableAlternatives ) ;
    public final void rule__ParenthesizedCrossReferenceableElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3926:1: ( ( ruleCrossReferenceableAlternatives ) )
            // InternalXtextGrammarTestLanguage.g:3927:1: ( ruleCrossReferenceableAlternatives )
            {
            // InternalXtextGrammarTestLanguage.g:3927:1: ( ruleCrossReferenceableAlternatives )
            // InternalXtextGrammarTestLanguage.g:3928:2: ruleCrossReferenceableAlternatives
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
    // InternalXtextGrammarTestLanguage.g:3937:1: rule__ParenthesizedCrossReferenceableElement__Group__2 : rule__ParenthesizedCrossReferenceableElement__Group__2__Impl ;
    public final void rule__ParenthesizedCrossReferenceableElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3941:1: ( rule__ParenthesizedCrossReferenceableElement__Group__2__Impl )
            // InternalXtextGrammarTestLanguage.g:3942:2: rule__ParenthesizedCrossReferenceableElement__Group__2__Impl
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
    // InternalXtextGrammarTestLanguage.g:3948:1: rule__ParenthesizedCrossReferenceableElement__Group__2__Impl : ( ')' ) ;
    public final void rule__ParenthesizedCrossReferenceableElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3952:1: ( ( ')' ) )
            // InternalXtextGrammarTestLanguage.g:3953:1: ( ')' )
            {
            // InternalXtextGrammarTestLanguage.g:3953:1: ( ')' )
            // InternalXtextGrammarTestLanguage.g:3954:2: ')'
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
    // InternalXtextGrammarTestLanguage.g:3964:1: rule__CrossReferenceableAlternatives__Group__0 : rule__CrossReferenceableAlternatives__Group__0__Impl rule__CrossReferenceableAlternatives__Group__1 ;
    public final void rule__CrossReferenceableAlternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3968:1: ( rule__CrossReferenceableAlternatives__Group__0__Impl rule__CrossReferenceableAlternatives__Group__1 )
            // InternalXtextGrammarTestLanguage.g:3969:2: rule__CrossReferenceableAlternatives__Group__0__Impl rule__CrossReferenceableAlternatives__Group__1
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
    // InternalXtextGrammarTestLanguage.g:3976:1: rule__CrossReferenceableAlternatives__Group__0__Impl : ( ruleCrossReferenceableTerminal ) ;
    public final void rule__CrossReferenceableAlternatives__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3980:1: ( ( ruleCrossReferenceableTerminal ) )
            // InternalXtextGrammarTestLanguage.g:3981:1: ( ruleCrossReferenceableTerminal )
            {
            // InternalXtextGrammarTestLanguage.g:3981:1: ( ruleCrossReferenceableTerminal )
            // InternalXtextGrammarTestLanguage.g:3982:2: ruleCrossReferenceableTerminal
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
    // InternalXtextGrammarTestLanguage.g:3991:1: rule__CrossReferenceableAlternatives__Group__1 : rule__CrossReferenceableAlternatives__Group__1__Impl ;
    public final void rule__CrossReferenceableAlternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3995:1: ( rule__CrossReferenceableAlternatives__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:3996:2: rule__CrossReferenceableAlternatives__Group__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:4002:1: rule__CrossReferenceableAlternatives__Group__1__Impl : ( ( rule__CrossReferenceableAlternatives__Group_1__0 )? ) ;
    public final void rule__CrossReferenceableAlternatives__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4006:1: ( ( ( rule__CrossReferenceableAlternatives__Group_1__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:4007:1: ( ( rule__CrossReferenceableAlternatives__Group_1__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:4007:1: ( ( rule__CrossReferenceableAlternatives__Group_1__0 )? )
            // InternalXtextGrammarTestLanguage.g:4008:2: ( rule__CrossReferenceableAlternatives__Group_1__0 )?
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getGroup_1()); 
            // InternalXtextGrammarTestLanguage.g:4009:2: ( rule__CrossReferenceableAlternatives__Group_1__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==30) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:4009:3: rule__CrossReferenceableAlternatives__Group_1__0
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
    // InternalXtextGrammarTestLanguage.g:4018:1: rule__CrossReferenceableAlternatives__Group_1__0 : rule__CrossReferenceableAlternatives__Group_1__0__Impl rule__CrossReferenceableAlternatives__Group_1__1 ;
    public final void rule__CrossReferenceableAlternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4022:1: ( rule__CrossReferenceableAlternatives__Group_1__0__Impl rule__CrossReferenceableAlternatives__Group_1__1 )
            // InternalXtextGrammarTestLanguage.g:4023:2: rule__CrossReferenceableAlternatives__Group_1__0__Impl rule__CrossReferenceableAlternatives__Group_1__1
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
    // InternalXtextGrammarTestLanguage.g:4030:1: rule__CrossReferenceableAlternatives__Group_1__0__Impl : ( () ) ;
    public final void rule__CrossReferenceableAlternatives__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4034:1: ( ( () ) )
            // InternalXtextGrammarTestLanguage.g:4035:1: ( () )
            {
            // InternalXtextGrammarTestLanguage.g:4035:1: ( () )
            // InternalXtextGrammarTestLanguage.g:4036:2: ()
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getAlternativesGroupsAction_1_0()); 
            // InternalXtextGrammarTestLanguage.g:4037:2: ()
            // InternalXtextGrammarTestLanguage.g:4037:3: 
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
    // InternalXtextGrammarTestLanguage.g:4045:1: rule__CrossReferenceableAlternatives__Group_1__1 : rule__CrossReferenceableAlternatives__Group_1__1__Impl ;
    public final void rule__CrossReferenceableAlternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4049:1: ( rule__CrossReferenceableAlternatives__Group_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:4050:2: rule__CrossReferenceableAlternatives__Group_1__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:4056:1: rule__CrossReferenceableAlternatives__Group_1__1__Impl : ( ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 ) ) ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 )* ) ) ;
    public final void rule__CrossReferenceableAlternatives__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4060:1: ( ( ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 ) ) ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 )* ) ) )
            // InternalXtextGrammarTestLanguage.g:4061:1: ( ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 ) ) ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 )* ) )
            {
            // InternalXtextGrammarTestLanguage.g:4061:1: ( ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 ) ) ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 )* ) )
            // InternalXtextGrammarTestLanguage.g:4062:2: ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 ) ) ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 )* )
            {
            // InternalXtextGrammarTestLanguage.g:4062:2: ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 ) )
            // InternalXtextGrammarTestLanguage.g:4063:3: ( rule__CrossReferenceableAlternatives__Group_1_1__0 )
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getGroup_1_1()); 
            // InternalXtextGrammarTestLanguage.g:4064:3: ( rule__CrossReferenceableAlternatives__Group_1_1__0 )
            // InternalXtextGrammarTestLanguage.g:4064:4: rule__CrossReferenceableAlternatives__Group_1_1__0
            {
            pushFollow(FOLLOW_20);
            rule__CrossReferenceableAlternatives__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getCrossReferenceableAlternativesAccess().getGroup_1_1()); 

            }

            // InternalXtextGrammarTestLanguage.g:4067:2: ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 )* )
            // InternalXtextGrammarTestLanguage.g:4068:3: ( rule__CrossReferenceableAlternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getGroup_1_1()); 
            // InternalXtextGrammarTestLanguage.g:4069:3: ( rule__CrossReferenceableAlternatives__Group_1_1__0 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==30) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:4069:4: rule__CrossReferenceableAlternatives__Group_1_1__0
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
    // InternalXtextGrammarTestLanguage.g:4079:1: rule__CrossReferenceableAlternatives__Group_1_1__0 : rule__CrossReferenceableAlternatives__Group_1_1__0__Impl rule__CrossReferenceableAlternatives__Group_1_1__1 ;
    public final void rule__CrossReferenceableAlternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4083:1: ( rule__CrossReferenceableAlternatives__Group_1_1__0__Impl rule__CrossReferenceableAlternatives__Group_1_1__1 )
            // InternalXtextGrammarTestLanguage.g:4084:2: rule__CrossReferenceableAlternatives__Group_1_1__0__Impl rule__CrossReferenceableAlternatives__Group_1_1__1
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
    // InternalXtextGrammarTestLanguage.g:4091:1: rule__CrossReferenceableAlternatives__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__CrossReferenceableAlternatives__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4095:1: ( ( '|' ) )
            // InternalXtextGrammarTestLanguage.g:4096:1: ( '|' )
            {
            // InternalXtextGrammarTestLanguage.g:4096:1: ( '|' )
            // InternalXtextGrammarTestLanguage.g:4097:2: '|'
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
    // InternalXtextGrammarTestLanguage.g:4106:1: rule__CrossReferenceableAlternatives__Group_1_1__1 : rule__CrossReferenceableAlternatives__Group_1_1__1__Impl ;
    public final void rule__CrossReferenceableAlternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4110:1: ( rule__CrossReferenceableAlternatives__Group_1_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:4111:2: rule__CrossReferenceableAlternatives__Group_1_1__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:4117:1: rule__CrossReferenceableAlternatives__Group_1_1__1__Impl : ( ( rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1 ) ) ;
    public final void rule__CrossReferenceableAlternatives__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4121:1: ( ( ( rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:4122:1: ( ( rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:4122:1: ( ( rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1 ) )
            // InternalXtextGrammarTestLanguage.g:4123:2: ( rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1 )
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getGroupsAssignment_1_1_1()); 
            // InternalXtextGrammarTestLanguage.g:4124:2: ( rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1 )
            // InternalXtextGrammarTestLanguage.g:4124:3: rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1
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
    // InternalXtextGrammarTestLanguage.g:4133:1: rule__ParenthesizedElement__Group__0 : rule__ParenthesizedElement__Group__0__Impl rule__ParenthesizedElement__Group__1 ;
    public final void rule__ParenthesizedElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4137:1: ( rule__ParenthesizedElement__Group__0__Impl rule__ParenthesizedElement__Group__1 )
            // InternalXtextGrammarTestLanguage.g:4138:2: rule__ParenthesizedElement__Group__0__Impl rule__ParenthesizedElement__Group__1
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
    // InternalXtextGrammarTestLanguage.g:4145:1: rule__ParenthesizedElement__Group__0__Impl : ( '(' ) ;
    public final void rule__ParenthesizedElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4149:1: ( ( '(' ) )
            // InternalXtextGrammarTestLanguage.g:4150:1: ( '(' )
            {
            // InternalXtextGrammarTestLanguage.g:4150:1: ( '(' )
            // InternalXtextGrammarTestLanguage.g:4151:2: '('
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
    // InternalXtextGrammarTestLanguage.g:4160:1: rule__ParenthesizedElement__Group__1 : rule__ParenthesizedElement__Group__1__Impl rule__ParenthesizedElement__Group__2 ;
    public final void rule__ParenthesizedElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4164:1: ( rule__ParenthesizedElement__Group__1__Impl rule__ParenthesizedElement__Group__2 )
            // InternalXtextGrammarTestLanguage.g:4165:2: rule__ParenthesizedElement__Group__1__Impl rule__ParenthesizedElement__Group__2
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
    // InternalXtextGrammarTestLanguage.g:4172:1: rule__ParenthesizedElement__Group__1__Impl : ( ruleAlternatives ) ;
    public final void rule__ParenthesizedElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4176:1: ( ( ruleAlternatives ) )
            // InternalXtextGrammarTestLanguage.g:4177:1: ( ruleAlternatives )
            {
            // InternalXtextGrammarTestLanguage.g:4177:1: ( ruleAlternatives )
            // InternalXtextGrammarTestLanguage.g:4178:2: ruleAlternatives
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
    // InternalXtextGrammarTestLanguage.g:4187:1: rule__ParenthesizedElement__Group__2 : rule__ParenthesizedElement__Group__2__Impl ;
    public final void rule__ParenthesizedElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4191:1: ( rule__ParenthesizedElement__Group__2__Impl )
            // InternalXtextGrammarTestLanguage.g:4192:2: rule__ParenthesizedElement__Group__2__Impl
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
    // InternalXtextGrammarTestLanguage.g:4198:1: rule__ParenthesizedElement__Group__2__Impl : ( ')' ) ;
    public final void rule__ParenthesizedElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4202:1: ( ( ')' ) )
            // InternalXtextGrammarTestLanguage.g:4203:1: ( ')' )
            {
            // InternalXtextGrammarTestLanguage.g:4203:1: ( ')' )
            // InternalXtextGrammarTestLanguage.g:4204:2: ')'
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
    // InternalXtextGrammarTestLanguage.g:4214:1: rule__TerminalRule__Group__0 : rule__TerminalRule__Group__0__Impl rule__TerminalRule__Group__1 ;
    public final void rule__TerminalRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4218:1: ( rule__TerminalRule__Group__0__Impl rule__TerminalRule__Group__1 )
            // InternalXtextGrammarTestLanguage.g:4219:2: rule__TerminalRule__Group__0__Impl rule__TerminalRule__Group__1
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
    // InternalXtextGrammarTestLanguage.g:4226:1: rule__TerminalRule__Group__0__Impl : ( 'terminal' ) ;
    public final void rule__TerminalRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4230:1: ( ( 'terminal' ) )
            // InternalXtextGrammarTestLanguage.g:4231:1: ( 'terminal' )
            {
            // InternalXtextGrammarTestLanguage.g:4231:1: ( 'terminal' )
            // InternalXtextGrammarTestLanguage.g:4232:2: 'terminal'
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
    // InternalXtextGrammarTestLanguage.g:4241:1: rule__TerminalRule__Group__1 : rule__TerminalRule__Group__1__Impl rule__TerminalRule__Group__2 ;
    public final void rule__TerminalRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4245:1: ( rule__TerminalRule__Group__1__Impl rule__TerminalRule__Group__2 )
            // InternalXtextGrammarTestLanguage.g:4246:2: rule__TerminalRule__Group__1__Impl rule__TerminalRule__Group__2
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
    // InternalXtextGrammarTestLanguage.g:4253:1: rule__TerminalRule__Group__1__Impl : ( ( rule__TerminalRule__NameAssignment_1 ) ) ;
    public final void rule__TerminalRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4257:1: ( ( ( rule__TerminalRule__NameAssignment_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:4258:1: ( ( rule__TerminalRule__NameAssignment_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:4258:1: ( ( rule__TerminalRule__NameAssignment_1 ) )
            // InternalXtextGrammarTestLanguage.g:4259:2: ( rule__TerminalRule__NameAssignment_1 )
            {
             before(grammarAccess.getTerminalRuleAccess().getNameAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:4260:2: ( rule__TerminalRule__NameAssignment_1 )
            // InternalXtextGrammarTestLanguage.g:4260:3: rule__TerminalRule__NameAssignment_1
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
    // InternalXtextGrammarTestLanguage.g:4268:1: rule__TerminalRule__Group__2 : rule__TerminalRule__Group__2__Impl rule__TerminalRule__Group__3 ;
    public final void rule__TerminalRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4272:1: ( rule__TerminalRule__Group__2__Impl rule__TerminalRule__Group__3 )
            // InternalXtextGrammarTestLanguage.g:4273:2: rule__TerminalRule__Group__2__Impl rule__TerminalRule__Group__3
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
    // InternalXtextGrammarTestLanguage.g:4280:1: rule__TerminalRule__Group__2__Impl : ( ( rule__TerminalRule__Group_2__0 )? ) ;
    public final void rule__TerminalRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4284:1: ( ( ( rule__TerminalRule__Group_2__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:4285:1: ( ( rule__TerminalRule__Group_2__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:4285:1: ( ( rule__TerminalRule__Group_2__0 )? )
            // InternalXtextGrammarTestLanguage.g:4286:2: ( rule__TerminalRule__Group_2__0 )?
            {
             before(grammarAccess.getTerminalRuleAccess().getGroup_2()); 
            // InternalXtextGrammarTestLanguage.g:4287:2: ( rule__TerminalRule__Group_2__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==28) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:4287:3: rule__TerminalRule__Group_2__0
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
    // InternalXtextGrammarTestLanguage.g:4295:1: rule__TerminalRule__Group__3 : rule__TerminalRule__Group__3__Impl rule__TerminalRule__Group__4 ;
    public final void rule__TerminalRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4299:1: ( rule__TerminalRule__Group__3__Impl rule__TerminalRule__Group__4 )
            // InternalXtextGrammarTestLanguage.g:4300:2: rule__TerminalRule__Group__3__Impl rule__TerminalRule__Group__4
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
    // InternalXtextGrammarTestLanguage.g:4307:1: rule__TerminalRule__Group__3__Impl : ( ':' ) ;
    public final void rule__TerminalRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4311:1: ( ( ':' ) )
            // InternalXtextGrammarTestLanguage.g:4312:1: ( ':' )
            {
            // InternalXtextGrammarTestLanguage.g:4312:1: ( ':' )
            // InternalXtextGrammarTestLanguage.g:4313:2: ':'
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
    // InternalXtextGrammarTestLanguage.g:4322:1: rule__TerminalRule__Group__4 : rule__TerminalRule__Group__4__Impl rule__TerminalRule__Group__5 ;
    public final void rule__TerminalRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4326:1: ( rule__TerminalRule__Group__4__Impl rule__TerminalRule__Group__5 )
            // InternalXtextGrammarTestLanguage.g:4327:2: rule__TerminalRule__Group__4__Impl rule__TerminalRule__Group__5
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
    // InternalXtextGrammarTestLanguage.g:4334:1: rule__TerminalRule__Group__4__Impl : ( ( rule__TerminalRule__AlternativesAssignment_4 ) ) ;
    public final void rule__TerminalRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4338:1: ( ( ( rule__TerminalRule__AlternativesAssignment_4 ) ) )
            // InternalXtextGrammarTestLanguage.g:4339:1: ( ( rule__TerminalRule__AlternativesAssignment_4 ) )
            {
            // InternalXtextGrammarTestLanguage.g:4339:1: ( ( rule__TerminalRule__AlternativesAssignment_4 ) )
            // InternalXtextGrammarTestLanguage.g:4340:2: ( rule__TerminalRule__AlternativesAssignment_4 )
            {
             before(grammarAccess.getTerminalRuleAccess().getAlternativesAssignment_4()); 
            // InternalXtextGrammarTestLanguage.g:4341:2: ( rule__TerminalRule__AlternativesAssignment_4 )
            // InternalXtextGrammarTestLanguage.g:4341:3: rule__TerminalRule__AlternativesAssignment_4
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
    // InternalXtextGrammarTestLanguage.g:4349:1: rule__TerminalRule__Group__5 : rule__TerminalRule__Group__5__Impl ;
    public final void rule__TerminalRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4353:1: ( rule__TerminalRule__Group__5__Impl )
            // InternalXtextGrammarTestLanguage.g:4354:2: rule__TerminalRule__Group__5__Impl
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
    // InternalXtextGrammarTestLanguage.g:4360:1: rule__TerminalRule__Group__5__Impl : ( ';' ) ;
    public final void rule__TerminalRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4364:1: ( ( ';' ) )
            // InternalXtextGrammarTestLanguage.g:4365:1: ( ';' )
            {
            // InternalXtextGrammarTestLanguage.g:4365:1: ( ';' )
            // InternalXtextGrammarTestLanguage.g:4366:2: ';'
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
    // InternalXtextGrammarTestLanguage.g:4376:1: rule__TerminalRule__Group_2__0 : rule__TerminalRule__Group_2__0__Impl rule__TerminalRule__Group_2__1 ;
    public final void rule__TerminalRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4380:1: ( rule__TerminalRule__Group_2__0__Impl rule__TerminalRule__Group_2__1 )
            // InternalXtextGrammarTestLanguage.g:4381:2: rule__TerminalRule__Group_2__0__Impl rule__TerminalRule__Group_2__1
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
    // InternalXtextGrammarTestLanguage.g:4388:1: rule__TerminalRule__Group_2__0__Impl : ( 'returns' ) ;
    public final void rule__TerminalRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4392:1: ( ( 'returns' ) )
            // InternalXtextGrammarTestLanguage.g:4393:1: ( 'returns' )
            {
            // InternalXtextGrammarTestLanguage.g:4393:1: ( 'returns' )
            // InternalXtextGrammarTestLanguage.g:4394:2: 'returns'
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
    // InternalXtextGrammarTestLanguage.g:4403:1: rule__TerminalRule__Group_2__1 : rule__TerminalRule__Group_2__1__Impl ;
    public final void rule__TerminalRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4407:1: ( rule__TerminalRule__Group_2__1__Impl )
            // InternalXtextGrammarTestLanguage.g:4408:2: rule__TerminalRule__Group_2__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:4414:1: rule__TerminalRule__Group_2__1__Impl : ( ( rule__TerminalRule__TypeAssignment_2_1 ) ) ;
    public final void rule__TerminalRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4418:1: ( ( ( rule__TerminalRule__TypeAssignment_2_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:4419:1: ( ( rule__TerminalRule__TypeAssignment_2_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:4419:1: ( ( rule__TerminalRule__TypeAssignment_2_1 ) )
            // InternalXtextGrammarTestLanguage.g:4420:2: ( rule__TerminalRule__TypeAssignment_2_1 )
            {
             before(grammarAccess.getTerminalRuleAccess().getTypeAssignment_2_1()); 
            // InternalXtextGrammarTestLanguage.g:4421:2: ( rule__TerminalRule__TypeAssignment_2_1 )
            // InternalXtextGrammarTestLanguage.g:4421:3: rule__TerminalRule__TypeAssignment_2_1
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
    // InternalXtextGrammarTestLanguage.g:4430:1: rule__TerminalAlternatives__Group__0 : rule__TerminalAlternatives__Group__0__Impl rule__TerminalAlternatives__Group__1 ;
    public final void rule__TerminalAlternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4434:1: ( rule__TerminalAlternatives__Group__0__Impl rule__TerminalAlternatives__Group__1 )
            // InternalXtextGrammarTestLanguage.g:4435:2: rule__TerminalAlternatives__Group__0__Impl rule__TerminalAlternatives__Group__1
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
    // InternalXtextGrammarTestLanguage.g:4442:1: rule__TerminalAlternatives__Group__0__Impl : ( ruleTerminalGroup ) ;
    public final void rule__TerminalAlternatives__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4446:1: ( ( ruleTerminalGroup ) )
            // InternalXtextGrammarTestLanguage.g:4447:1: ( ruleTerminalGroup )
            {
            // InternalXtextGrammarTestLanguage.g:4447:1: ( ruleTerminalGroup )
            // InternalXtextGrammarTestLanguage.g:4448:2: ruleTerminalGroup
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
    // InternalXtextGrammarTestLanguage.g:4457:1: rule__TerminalAlternatives__Group__1 : rule__TerminalAlternatives__Group__1__Impl ;
    public final void rule__TerminalAlternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4461:1: ( rule__TerminalAlternatives__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:4462:2: rule__TerminalAlternatives__Group__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:4468:1: rule__TerminalAlternatives__Group__1__Impl : ( ( rule__TerminalAlternatives__Group_1__0 )? ) ;
    public final void rule__TerminalAlternatives__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4472:1: ( ( ( rule__TerminalAlternatives__Group_1__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:4473:1: ( ( rule__TerminalAlternatives__Group_1__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:4473:1: ( ( rule__TerminalAlternatives__Group_1__0 )? )
            // InternalXtextGrammarTestLanguage.g:4474:2: ( rule__TerminalAlternatives__Group_1__0 )?
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup_1()); 
            // InternalXtextGrammarTestLanguage.g:4475:2: ( rule__TerminalAlternatives__Group_1__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==30) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:4475:3: rule__TerminalAlternatives__Group_1__0
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
    // InternalXtextGrammarTestLanguage.g:4484:1: rule__TerminalAlternatives__Group_1__0 : rule__TerminalAlternatives__Group_1__0__Impl rule__TerminalAlternatives__Group_1__1 ;
    public final void rule__TerminalAlternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4488:1: ( rule__TerminalAlternatives__Group_1__0__Impl rule__TerminalAlternatives__Group_1__1 )
            // InternalXtextGrammarTestLanguage.g:4489:2: rule__TerminalAlternatives__Group_1__0__Impl rule__TerminalAlternatives__Group_1__1
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
    // InternalXtextGrammarTestLanguage.g:4496:1: rule__TerminalAlternatives__Group_1__0__Impl : ( () ) ;
    public final void rule__TerminalAlternatives__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4500:1: ( ( () ) )
            // InternalXtextGrammarTestLanguage.g:4501:1: ( () )
            {
            // InternalXtextGrammarTestLanguage.g:4501:1: ( () )
            // InternalXtextGrammarTestLanguage.g:4502:2: ()
            {
             before(grammarAccess.getTerminalAlternativesAccess().getAlternativesGroupsAction_1_0()); 
            // InternalXtextGrammarTestLanguage.g:4503:2: ()
            // InternalXtextGrammarTestLanguage.g:4503:3: 
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
    // InternalXtextGrammarTestLanguage.g:4511:1: rule__TerminalAlternatives__Group_1__1 : rule__TerminalAlternatives__Group_1__1__Impl ;
    public final void rule__TerminalAlternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4515:1: ( rule__TerminalAlternatives__Group_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:4516:2: rule__TerminalAlternatives__Group_1__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:4522:1: rule__TerminalAlternatives__Group_1__1__Impl : ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) ) ;
    public final void rule__TerminalAlternatives__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4526:1: ( ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) ) )
            // InternalXtextGrammarTestLanguage.g:4527:1: ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) )
            {
            // InternalXtextGrammarTestLanguage.g:4527:1: ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) )
            // InternalXtextGrammarTestLanguage.g:4528:2: ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* )
            {
            // InternalXtextGrammarTestLanguage.g:4528:2: ( ( rule__TerminalAlternatives__Group_1_1__0 ) )
            // InternalXtextGrammarTestLanguage.g:4529:3: ( rule__TerminalAlternatives__Group_1_1__0 )
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 
            // InternalXtextGrammarTestLanguage.g:4530:3: ( rule__TerminalAlternatives__Group_1_1__0 )
            // InternalXtextGrammarTestLanguage.g:4530:4: rule__TerminalAlternatives__Group_1_1__0
            {
            pushFollow(FOLLOW_20);
            rule__TerminalAlternatives__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 

            }

            // InternalXtextGrammarTestLanguage.g:4533:2: ( ( rule__TerminalAlternatives__Group_1_1__0 )* )
            // InternalXtextGrammarTestLanguage.g:4534:3: ( rule__TerminalAlternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 
            // InternalXtextGrammarTestLanguage.g:4535:3: ( rule__TerminalAlternatives__Group_1_1__0 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==30) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:4535:4: rule__TerminalAlternatives__Group_1_1__0
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
    // InternalXtextGrammarTestLanguage.g:4545:1: rule__TerminalAlternatives__Group_1_1__0 : rule__TerminalAlternatives__Group_1_1__0__Impl rule__TerminalAlternatives__Group_1_1__1 ;
    public final void rule__TerminalAlternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4549:1: ( rule__TerminalAlternatives__Group_1_1__0__Impl rule__TerminalAlternatives__Group_1_1__1 )
            // InternalXtextGrammarTestLanguage.g:4550:2: rule__TerminalAlternatives__Group_1_1__0__Impl rule__TerminalAlternatives__Group_1_1__1
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
    // InternalXtextGrammarTestLanguage.g:4557:1: rule__TerminalAlternatives__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__TerminalAlternatives__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4561:1: ( ( '|' ) )
            // InternalXtextGrammarTestLanguage.g:4562:1: ( '|' )
            {
            // InternalXtextGrammarTestLanguage.g:4562:1: ( '|' )
            // InternalXtextGrammarTestLanguage.g:4563:2: '|'
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
    // InternalXtextGrammarTestLanguage.g:4572:1: rule__TerminalAlternatives__Group_1_1__1 : rule__TerminalAlternatives__Group_1_1__1__Impl ;
    public final void rule__TerminalAlternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4576:1: ( rule__TerminalAlternatives__Group_1_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:4577:2: rule__TerminalAlternatives__Group_1_1__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:4583:1: rule__TerminalAlternatives__Group_1_1__1__Impl : ( ( rule__TerminalAlternatives__GroupsAssignment_1_1_1 ) ) ;
    public final void rule__TerminalAlternatives__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4587:1: ( ( ( rule__TerminalAlternatives__GroupsAssignment_1_1_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:4588:1: ( ( rule__TerminalAlternatives__GroupsAssignment_1_1_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:4588:1: ( ( rule__TerminalAlternatives__GroupsAssignment_1_1_1 ) )
            // InternalXtextGrammarTestLanguage.g:4589:2: ( rule__TerminalAlternatives__GroupsAssignment_1_1_1 )
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroupsAssignment_1_1_1()); 
            // InternalXtextGrammarTestLanguage.g:4590:2: ( rule__TerminalAlternatives__GroupsAssignment_1_1_1 )
            // InternalXtextGrammarTestLanguage.g:4590:3: rule__TerminalAlternatives__GroupsAssignment_1_1_1
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
    // InternalXtextGrammarTestLanguage.g:4599:1: rule__TerminalGroup__Group__0 : rule__TerminalGroup__Group__0__Impl rule__TerminalGroup__Group__1 ;
    public final void rule__TerminalGroup__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4603:1: ( rule__TerminalGroup__Group__0__Impl rule__TerminalGroup__Group__1 )
            // InternalXtextGrammarTestLanguage.g:4604:2: rule__TerminalGroup__Group__0__Impl rule__TerminalGroup__Group__1
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
    // InternalXtextGrammarTestLanguage.g:4611:1: rule__TerminalGroup__Group__0__Impl : ( ruleTerminalToken ) ;
    public final void rule__TerminalGroup__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4615:1: ( ( ruleTerminalToken ) )
            // InternalXtextGrammarTestLanguage.g:4616:1: ( ruleTerminalToken )
            {
            // InternalXtextGrammarTestLanguage.g:4616:1: ( ruleTerminalToken )
            // InternalXtextGrammarTestLanguage.g:4617:2: ruleTerminalToken
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
    // InternalXtextGrammarTestLanguage.g:4626:1: rule__TerminalGroup__Group__1 : rule__TerminalGroup__Group__1__Impl ;
    public final void rule__TerminalGroup__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4630:1: ( rule__TerminalGroup__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:4631:2: rule__TerminalGroup__Group__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:4637:1: rule__TerminalGroup__Group__1__Impl : ( ( rule__TerminalGroup__Group_1__0 )? ) ;
    public final void rule__TerminalGroup__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4641:1: ( ( ( rule__TerminalGroup__Group_1__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:4642:1: ( ( rule__TerminalGroup__Group_1__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:4642:1: ( ( rule__TerminalGroup__Group_1__0 )? )
            // InternalXtextGrammarTestLanguage.g:4643:2: ( rule__TerminalGroup__Group_1__0 )?
            {
             before(grammarAccess.getTerminalGroupAccess().getGroup_1()); 
            // InternalXtextGrammarTestLanguage.g:4644:2: ( rule__TerminalGroup__Group_1__0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=RULE_ID && LA43_0<=RULE_STRING)||LA43_0==20||LA43_0==22||(LA43_0>=37 && LA43_0<=38)) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:4644:3: rule__TerminalGroup__Group_1__0
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
    // InternalXtextGrammarTestLanguage.g:4653:1: rule__TerminalGroup__Group_1__0 : rule__TerminalGroup__Group_1__0__Impl rule__TerminalGroup__Group_1__1 ;
    public final void rule__TerminalGroup__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4657:1: ( rule__TerminalGroup__Group_1__0__Impl rule__TerminalGroup__Group_1__1 )
            // InternalXtextGrammarTestLanguage.g:4658:2: rule__TerminalGroup__Group_1__0__Impl rule__TerminalGroup__Group_1__1
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
    // InternalXtextGrammarTestLanguage.g:4665:1: rule__TerminalGroup__Group_1__0__Impl : ( () ) ;
    public final void rule__TerminalGroup__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4669:1: ( ( () ) )
            // InternalXtextGrammarTestLanguage.g:4670:1: ( () )
            {
            // InternalXtextGrammarTestLanguage.g:4670:1: ( () )
            // InternalXtextGrammarTestLanguage.g:4671:2: ()
            {
             before(grammarAccess.getTerminalGroupAccess().getGroupTokensAction_1_0()); 
            // InternalXtextGrammarTestLanguage.g:4672:2: ()
            // InternalXtextGrammarTestLanguage.g:4672:3: 
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
    // InternalXtextGrammarTestLanguage.g:4680:1: rule__TerminalGroup__Group_1__1 : rule__TerminalGroup__Group_1__1__Impl ;
    public final void rule__TerminalGroup__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4684:1: ( rule__TerminalGroup__Group_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:4685:2: rule__TerminalGroup__Group_1__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:4691:1: rule__TerminalGroup__Group_1__1__Impl : ( ( ( rule__TerminalGroup__TokensAssignment_1_1 ) ) ( ( rule__TerminalGroup__TokensAssignment_1_1 )* ) ) ;
    public final void rule__TerminalGroup__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4695:1: ( ( ( ( rule__TerminalGroup__TokensAssignment_1_1 ) ) ( ( rule__TerminalGroup__TokensAssignment_1_1 )* ) ) )
            // InternalXtextGrammarTestLanguage.g:4696:1: ( ( ( rule__TerminalGroup__TokensAssignment_1_1 ) ) ( ( rule__TerminalGroup__TokensAssignment_1_1 )* ) )
            {
            // InternalXtextGrammarTestLanguage.g:4696:1: ( ( ( rule__TerminalGroup__TokensAssignment_1_1 ) ) ( ( rule__TerminalGroup__TokensAssignment_1_1 )* ) )
            // InternalXtextGrammarTestLanguage.g:4697:2: ( ( rule__TerminalGroup__TokensAssignment_1_1 ) ) ( ( rule__TerminalGroup__TokensAssignment_1_1 )* )
            {
            // InternalXtextGrammarTestLanguage.g:4697:2: ( ( rule__TerminalGroup__TokensAssignment_1_1 ) )
            // InternalXtextGrammarTestLanguage.g:4698:3: ( rule__TerminalGroup__TokensAssignment_1_1 )
            {
             before(grammarAccess.getTerminalGroupAccess().getTokensAssignment_1_1()); 
            // InternalXtextGrammarTestLanguage.g:4699:3: ( rule__TerminalGroup__TokensAssignment_1_1 )
            // InternalXtextGrammarTestLanguage.g:4699:4: rule__TerminalGroup__TokensAssignment_1_1
            {
            pushFollow(FOLLOW_33);
            rule__TerminalGroup__TokensAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getTerminalGroupAccess().getTokensAssignment_1_1()); 

            }

            // InternalXtextGrammarTestLanguage.g:4702:2: ( ( rule__TerminalGroup__TokensAssignment_1_1 )* )
            // InternalXtextGrammarTestLanguage.g:4703:3: ( rule__TerminalGroup__TokensAssignment_1_1 )*
            {
             before(grammarAccess.getTerminalGroupAccess().getTokensAssignment_1_1()); 
            // InternalXtextGrammarTestLanguage.g:4704:3: ( rule__TerminalGroup__TokensAssignment_1_1 )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( ((LA44_0>=RULE_ID && LA44_0<=RULE_STRING)||LA44_0==20||LA44_0==22||(LA44_0>=37 && LA44_0<=38)) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:4704:4: rule__TerminalGroup__TokensAssignment_1_1
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
    // InternalXtextGrammarTestLanguage.g:4714:1: rule__TerminalToken__Group__0 : rule__TerminalToken__Group__0__Impl rule__TerminalToken__Group__1 ;
    public final void rule__TerminalToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4718:1: ( rule__TerminalToken__Group__0__Impl rule__TerminalToken__Group__1 )
            // InternalXtextGrammarTestLanguage.g:4719:2: rule__TerminalToken__Group__0__Impl rule__TerminalToken__Group__1
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
    // InternalXtextGrammarTestLanguage.g:4726:1: rule__TerminalToken__Group__0__Impl : ( ruleTerminalTokenElement ) ;
    public final void rule__TerminalToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4730:1: ( ( ruleTerminalTokenElement ) )
            // InternalXtextGrammarTestLanguage.g:4731:1: ( ruleTerminalTokenElement )
            {
            // InternalXtextGrammarTestLanguage.g:4731:1: ( ruleTerminalTokenElement )
            // InternalXtextGrammarTestLanguage.g:4732:2: ruleTerminalTokenElement
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
    // InternalXtextGrammarTestLanguage.g:4741:1: rule__TerminalToken__Group__1 : rule__TerminalToken__Group__1__Impl ;
    public final void rule__TerminalToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4745:1: ( rule__TerminalToken__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:4746:2: rule__TerminalToken__Group__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:4752:1: rule__TerminalToken__Group__1__Impl : ( ( rule__TerminalToken__CardinalityAssignment_1 )? ) ;
    public final void rule__TerminalToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4756:1: ( ( ( rule__TerminalToken__CardinalityAssignment_1 )? ) )
            // InternalXtextGrammarTestLanguage.g:4757:1: ( ( rule__TerminalToken__CardinalityAssignment_1 )? )
            {
            // InternalXtextGrammarTestLanguage.g:4757:1: ( ( rule__TerminalToken__CardinalityAssignment_1 )? )
            // InternalXtextGrammarTestLanguage.g:4758:2: ( rule__TerminalToken__CardinalityAssignment_1 )?
            {
             before(grammarAccess.getTerminalTokenAccess().getCardinalityAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:4759:2: ( rule__TerminalToken__CardinalityAssignment_1 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( ((LA45_0>=11 && LA45_0<=13)) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:4759:3: rule__TerminalToken__CardinalityAssignment_1
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
    // InternalXtextGrammarTestLanguage.g:4768:1: rule__ParenthesizedTerminalElement__Group__0 : rule__ParenthesizedTerminalElement__Group__0__Impl rule__ParenthesizedTerminalElement__Group__1 ;
    public final void rule__ParenthesizedTerminalElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4772:1: ( rule__ParenthesizedTerminalElement__Group__0__Impl rule__ParenthesizedTerminalElement__Group__1 )
            // InternalXtextGrammarTestLanguage.g:4773:2: rule__ParenthesizedTerminalElement__Group__0__Impl rule__ParenthesizedTerminalElement__Group__1
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
    // InternalXtextGrammarTestLanguage.g:4780:1: rule__ParenthesizedTerminalElement__Group__0__Impl : ( '(' ) ;
    public final void rule__ParenthesizedTerminalElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4784:1: ( ( '(' ) )
            // InternalXtextGrammarTestLanguage.g:4785:1: ( '(' )
            {
            // InternalXtextGrammarTestLanguage.g:4785:1: ( '(' )
            // InternalXtextGrammarTestLanguage.g:4786:2: '('
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
    // InternalXtextGrammarTestLanguage.g:4795:1: rule__ParenthesizedTerminalElement__Group__1 : rule__ParenthesizedTerminalElement__Group__1__Impl rule__ParenthesizedTerminalElement__Group__2 ;
    public final void rule__ParenthesizedTerminalElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4799:1: ( rule__ParenthesizedTerminalElement__Group__1__Impl rule__ParenthesizedTerminalElement__Group__2 )
            // InternalXtextGrammarTestLanguage.g:4800:2: rule__ParenthesizedTerminalElement__Group__1__Impl rule__ParenthesizedTerminalElement__Group__2
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
    // InternalXtextGrammarTestLanguage.g:4807:1: rule__ParenthesizedTerminalElement__Group__1__Impl : ( ruleTerminalAlternatives ) ;
    public final void rule__ParenthesizedTerminalElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4811:1: ( ( ruleTerminalAlternatives ) )
            // InternalXtextGrammarTestLanguage.g:4812:1: ( ruleTerminalAlternatives )
            {
            // InternalXtextGrammarTestLanguage.g:4812:1: ( ruleTerminalAlternatives )
            // InternalXtextGrammarTestLanguage.g:4813:2: ruleTerminalAlternatives
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
    // InternalXtextGrammarTestLanguage.g:4822:1: rule__ParenthesizedTerminalElement__Group__2 : rule__ParenthesizedTerminalElement__Group__2__Impl ;
    public final void rule__ParenthesizedTerminalElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4826:1: ( rule__ParenthesizedTerminalElement__Group__2__Impl )
            // InternalXtextGrammarTestLanguage.g:4827:2: rule__ParenthesizedTerminalElement__Group__2__Impl
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
    // InternalXtextGrammarTestLanguage.g:4833:1: rule__ParenthesizedTerminalElement__Group__2__Impl : ( ')' ) ;
    public final void rule__ParenthesizedTerminalElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4837:1: ( ( ')' ) )
            // InternalXtextGrammarTestLanguage.g:4838:1: ( ')' )
            {
            // InternalXtextGrammarTestLanguage.g:4838:1: ( ')' )
            // InternalXtextGrammarTestLanguage.g:4839:2: ')'
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
    // InternalXtextGrammarTestLanguage.g:4849:1: rule__NegatedToken__Group__0 : rule__NegatedToken__Group__0__Impl rule__NegatedToken__Group__1 ;
    public final void rule__NegatedToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4853:1: ( rule__NegatedToken__Group__0__Impl rule__NegatedToken__Group__1 )
            // InternalXtextGrammarTestLanguage.g:4854:2: rule__NegatedToken__Group__0__Impl rule__NegatedToken__Group__1
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
    // InternalXtextGrammarTestLanguage.g:4861:1: rule__NegatedToken__Group__0__Impl : ( '!' ) ;
    public final void rule__NegatedToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4865:1: ( ( '!' ) )
            // InternalXtextGrammarTestLanguage.g:4866:1: ( '!' )
            {
            // InternalXtextGrammarTestLanguage.g:4866:1: ( '!' )
            // InternalXtextGrammarTestLanguage.g:4867:2: '!'
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
    // InternalXtextGrammarTestLanguage.g:4876:1: rule__NegatedToken__Group__1 : rule__NegatedToken__Group__1__Impl ;
    public final void rule__NegatedToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4880:1: ( rule__NegatedToken__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:4881:2: rule__NegatedToken__Group__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:4887:1: rule__NegatedToken__Group__1__Impl : ( ( rule__NegatedToken__TerminalAssignment_1 ) ) ;
    public final void rule__NegatedToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4891:1: ( ( ( rule__NegatedToken__TerminalAssignment_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:4892:1: ( ( rule__NegatedToken__TerminalAssignment_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:4892:1: ( ( rule__NegatedToken__TerminalAssignment_1 ) )
            // InternalXtextGrammarTestLanguage.g:4893:2: ( rule__NegatedToken__TerminalAssignment_1 )
            {
             before(grammarAccess.getNegatedTokenAccess().getTerminalAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:4894:2: ( rule__NegatedToken__TerminalAssignment_1 )
            // InternalXtextGrammarTestLanguage.g:4894:3: rule__NegatedToken__TerminalAssignment_1
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
    // InternalXtextGrammarTestLanguage.g:4903:1: rule__UntilToken__Group__0 : rule__UntilToken__Group__0__Impl rule__UntilToken__Group__1 ;
    public final void rule__UntilToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4907:1: ( rule__UntilToken__Group__0__Impl rule__UntilToken__Group__1 )
            // InternalXtextGrammarTestLanguage.g:4908:2: rule__UntilToken__Group__0__Impl rule__UntilToken__Group__1
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
    // InternalXtextGrammarTestLanguage.g:4915:1: rule__UntilToken__Group__0__Impl : ( '->' ) ;
    public final void rule__UntilToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4919:1: ( ( '->' ) )
            // InternalXtextGrammarTestLanguage.g:4920:1: ( '->' )
            {
            // InternalXtextGrammarTestLanguage.g:4920:1: ( '->' )
            // InternalXtextGrammarTestLanguage.g:4921:2: '->'
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
    // InternalXtextGrammarTestLanguage.g:4930:1: rule__UntilToken__Group__1 : rule__UntilToken__Group__1__Impl ;
    public final void rule__UntilToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4934:1: ( rule__UntilToken__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:4935:2: rule__UntilToken__Group__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:4941:1: rule__UntilToken__Group__1__Impl : ( ( rule__UntilToken__TerminalAssignment_1 ) ) ;
    public final void rule__UntilToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4945:1: ( ( ( rule__UntilToken__TerminalAssignment_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:4946:1: ( ( rule__UntilToken__TerminalAssignment_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:4946:1: ( ( rule__UntilToken__TerminalAssignment_1 ) )
            // InternalXtextGrammarTestLanguage.g:4947:2: ( rule__UntilToken__TerminalAssignment_1 )
            {
             before(grammarAccess.getUntilTokenAccess().getTerminalAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:4948:2: ( rule__UntilToken__TerminalAssignment_1 )
            // InternalXtextGrammarTestLanguage.g:4948:3: rule__UntilToken__TerminalAssignment_1
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
    // InternalXtextGrammarTestLanguage.g:4957:1: rule__Wildcard__Group__0 : rule__Wildcard__Group__0__Impl rule__Wildcard__Group__1 ;
    public final void rule__Wildcard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4961:1: ( rule__Wildcard__Group__0__Impl rule__Wildcard__Group__1 )
            // InternalXtextGrammarTestLanguage.g:4962:2: rule__Wildcard__Group__0__Impl rule__Wildcard__Group__1
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
    // InternalXtextGrammarTestLanguage.g:4969:1: rule__Wildcard__Group__0__Impl : ( () ) ;
    public final void rule__Wildcard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4973:1: ( ( () ) )
            // InternalXtextGrammarTestLanguage.g:4974:1: ( () )
            {
            // InternalXtextGrammarTestLanguage.g:4974:1: ( () )
            // InternalXtextGrammarTestLanguage.g:4975:2: ()
            {
             before(grammarAccess.getWildcardAccess().getWildcardAction_0()); 
            // InternalXtextGrammarTestLanguage.g:4976:2: ()
            // InternalXtextGrammarTestLanguage.g:4976:3: 
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
    // InternalXtextGrammarTestLanguage.g:4984:1: rule__Wildcard__Group__1 : rule__Wildcard__Group__1__Impl ;
    public final void rule__Wildcard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4988:1: ( rule__Wildcard__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:4989:2: rule__Wildcard__Group__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:4995:1: rule__Wildcard__Group__1__Impl : ( '.' ) ;
    public final void rule__Wildcard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4999:1: ( ( '.' ) )
            // InternalXtextGrammarTestLanguage.g:5000:1: ( '.' )
            {
            // InternalXtextGrammarTestLanguage.g:5000:1: ( '.' )
            // InternalXtextGrammarTestLanguage.g:5001:2: '.'
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
    // InternalXtextGrammarTestLanguage.g:5011:1: rule__CharacterRange__Group__0 : rule__CharacterRange__Group__0__Impl rule__CharacterRange__Group__1 ;
    public final void rule__CharacterRange__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5015:1: ( rule__CharacterRange__Group__0__Impl rule__CharacterRange__Group__1 )
            // InternalXtextGrammarTestLanguage.g:5016:2: rule__CharacterRange__Group__0__Impl rule__CharacterRange__Group__1
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
    // InternalXtextGrammarTestLanguage.g:5023:1: rule__CharacterRange__Group__0__Impl : ( ruleKeyword ) ;
    public final void rule__CharacterRange__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5027:1: ( ( ruleKeyword ) )
            // InternalXtextGrammarTestLanguage.g:5028:1: ( ruleKeyword )
            {
            // InternalXtextGrammarTestLanguage.g:5028:1: ( ruleKeyword )
            // InternalXtextGrammarTestLanguage.g:5029:2: ruleKeyword
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
    // InternalXtextGrammarTestLanguage.g:5038:1: rule__CharacterRange__Group__1 : rule__CharacterRange__Group__1__Impl ;
    public final void rule__CharacterRange__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5042:1: ( rule__CharacterRange__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:5043:2: rule__CharacterRange__Group__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:5049:1: rule__CharacterRange__Group__1__Impl : ( ( rule__CharacterRange__Group_1__0 )? ) ;
    public final void rule__CharacterRange__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5053:1: ( ( ( rule__CharacterRange__Group_1__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:5054:1: ( ( rule__CharacterRange__Group_1__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:5054:1: ( ( rule__CharacterRange__Group_1__0 )? )
            // InternalXtextGrammarTestLanguage.g:5055:2: ( rule__CharacterRange__Group_1__0 )?
            {
             before(grammarAccess.getCharacterRangeAccess().getGroup_1()); 
            // InternalXtextGrammarTestLanguage.g:5056:2: ( rule__CharacterRange__Group_1__0 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==39) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:5056:3: rule__CharacterRange__Group_1__0
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
    // InternalXtextGrammarTestLanguage.g:5065:1: rule__CharacterRange__Group_1__0 : rule__CharacterRange__Group_1__0__Impl rule__CharacterRange__Group_1__1 ;
    public final void rule__CharacterRange__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5069:1: ( rule__CharacterRange__Group_1__0__Impl rule__CharacterRange__Group_1__1 )
            // InternalXtextGrammarTestLanguage.g:5070:2: rule__CharacterRange__Group_1__0__Impl rule__CharacterRange__Group_1__1
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
    // InternalXtextGrammarTestLanguage.g:5077:1: rule__CharacterRange__Group_1__0__Impl : ( () ) ;
    public final void rule__CharacterRange__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5081:1: ( ( () ) )
            // InternalXtextGrammarTestLanguage.g:5082:1: ( () )
            {
            // InternalXtextGrammarTestLanguage.g:5082:1: ( () )
            // InternalXtextGrammarTestLanguage.g:5083:2: ()
            {
             before(grammarAccess.getCharacterRangeAccess().getCharacterRangeLeftAction_1_0()); 
            // InternalXtextGrammarTestLanguage.g:5084:2: ()
            // InternalXtextGrammarTestLanguage.g:5084:3: 
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
    // InternalXtextGrammarTestLanguage.g:5092:1: rule__CharacterRange__Group_1__1 : rule__CharacterRange__Group_1__1__Impl rule__CharacterRange__Group_1__2 ;
    public final void rule__CharacterRange__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5096:1: ( rule__CharacterRange__Group_1__1__Impl rule__CharacterRange__Group_1__2 )
            // InternalXtextGrammarTestLanguage.g:5097:2: rule__CharacterRange__Group_1__1__Impl rule__CharacterRange__Group_1__2
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
    // InternalXtextGrammarTestLanguage.g:5104:1: rule__CharacterRange__Group_1__1__Impl : ( '..' ) ;
    public final void rule__CharacterRange__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5108:1: ( ( '..' ) )
            // InternalXtextGrammarTestLanguage.g:5109:1: ( '..' )
            {
            // InternalXtextGrammarTestLanguage.g:5109:1: ( '..' )
            // InternalXtextGrammarTestLanguage.g:5110:2: '..'
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
    // InternalXtextGrammarTestLanguage.g:5119:1: rule__CharacterRange__Group_1__2 : rule__CharacterRange__Group_1__2__Impl ;
    public final void rule__CharacterRange__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5123:1: ( rule__CharacterRange__Group_1__2__Impl )
            // InternalXtextGrammarTestLanguage.g:5124:2: rule__CharacterRange__Group_1__2__Impl
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
    // InternalXtextGrammarTestLanguage.g:5130:1: rule__CharacterRange__Group_1__2__Impl : ( ( rule__CharacterRange__RightAssignment_1_2 ) ) ;
    public final void rule__CharacterRange__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5134:1: ( ( ( rule__CharacterRange__RightAssignment_1_2 ) ) )
            // InternalXtextGrammarTestLanguage.g:5135:1: ( ( rule__CharacterRange__RightAssignment_1_2 ) )
            {
            // InternalXtextGrammarTestLanguage.g:5135:1: ( ( rule__CharacterRange__RightAssignment_1_2 ) )
            // InternalXtextGrammarTestLanguage.g:5136:2: ( rule__CharacterRange__RightAssignment_1_2 )
            {
             before(grammarAccess.getCharacterRangeAccess().getRightAssignment_1_2()); 
            // InternalXtextGrammarTestLanguage.g:5137:2: ( rule__CharacterRange__RightAssignment_1_2 )
            // InternalXtextGrammarTestLanguage.g:5137:3: rule__CharacterRange__RightAssignment_1_2
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
    // InternalXtextGrammarTestLanguage.g:5146:1: rule__EnumRule__Group__0 : rule__EnumRule__Group__0__Impl rule__EnumRule__Group__1 ;
    public final void rule__EnumRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5150:1: ( rule__EnumRule__Group__0__Impl rule__EnumRule__Group__1 )
            // InternalXtextGrammarTestLanguage.g:5151:2: rule__EnumRule__Group__0__Impl rule__EnumRule__Group__1
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
    // InternalXtextGrammarTestLanguage.g:5158:1: rule__EnumRule__Group__0__Impl : ( 'enum' ) ;
    public final void rule__EnumRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5162:1: ( ( 'enum' ) )
            // InternalXtextGrammarTestLanguage.g:5163:1: ( 'enum' )
            {
            // InternalXtextGrammarTestLanguage.g:5163:1: ( 'enum' )
            // InternalXtextGrammarTestLanguage.g:5164:2: 'enum'
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
    // InternalXtextGrammarTestLanguage.g:5173:1: rule__EnumRule__Group__1 : rule__EnumRule__Group__1__Impl rule__EnumRule__Group__2 ;
    public final void rule__EnumRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5177:1: ( rule__EnumRule__Group__1__Impl rule__EnumRule__Group__2 )
            // InternalXtextGrammarTestLanguage.g:5178:2: rule__EnumRule__Group__1__Impl rule__EnumRule__Group__2
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
    // InternalXtextGrammarTestLanguage.g:5185:1: rule__EnumRule__Group__1__Impl : ( ( rule__EnumRule__NameAssignment_1 ) ) ;
    public final void rule__EnumRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5189:1: ( ( ( rule__EnumRule__NameAssignment_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:5190:1: ( ( rule__EnumRule__NameAssignment_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:5190:1: ( ( rule__EnumRule__NameAssignment_1 ) )
            // InternalXtextGrammarTestLanguage.g:5191:2: ( rule__EnumRule__NameAssignment_1 )
            {
             before(grammarAccess.getEnumRuleAccess().getNameAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:5192:2: ( rule__EnumRule__NameAssignment_1 )
            // InternalXtextGrammarTestLanguage.g:5192:3: rule__EnumRule__NameAssignment_1
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
    // InternalXtextGrammarTestLanguage.g:5200:1: rule__EnumRule__Group__2 : rule__EnumRule__Group__2__Impl rule__EnumRule__Group__3 ;
    public final void rule__EnumRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5204:1: ( rule__EnumRule__Group__2__Impl rule__EnumRule__Group__3 )
            // InternalXtextGrammarTestLanguage.g:5205:2: rule__EnumRule__Group__2__Impl rule__EnumRule__Group__3
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
    // InternalXtextGrammarTestLanguage.g:5212:1: rule__EnumRule__Group__2__Impl : ( ( rule__EnumRule__Group_2__0 )? ) ;
    public final void rule__EnumRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5216:1: ( ( ( rule__EnumRule__Group_2__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:5217:1: ( ( rule__EnumRule__Group_2__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:5217:1: ( ( rule__EnumRule__Group_2__0 )? )
            // InternalXtextGrammarTestLanguage.g:5218:2: ( rule__EnumRule__Group_2__0 )?
            {
             before(grammarAccess.getEnumRuleAccess().getGroup_2()); 
            // InternalXtextGrammarTestLanguage.g:5219:2: ( rule__EnumRule__Group_2__0 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==28) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:5219:3: rule__EnumRule__Group_2__0
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
    // InternalXtextGrammarTestLanguage.g:5227:1: rule__EnumRule__Group__3 : rule__EnumRule__Group__3__Impl rule__EnumRule__Group__4 ;
    public final void rule__EnumRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5231:1: ( rule__EnumRule__Group__3__Impl rule__EnumRule__Group__4 )
            // InternalXtextGrammarTestLanguage.g:5232:2: rule__EnumRule__Group__3__Impl rule__EnumRule__Group__4
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
    // InternalXtextGrammarTestLanguage.g:5239:1: rule__EnumRule__Group__3__Impl : ( ':' ) ;
    public final void rule__EnumRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5243:1: ( ( ':' ) )
            // InternalXtextGrammarTestLanguage.g:5244:1: ( ':' )
            {
            // InternalXtextGrammarTestLanguage.g:5244:1: ( ':' )
            // InternalXtextGrammarTestLanguage.g:5245:2: ':'
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
    // InternalXtextGrammarTestLanguage.g:5254:1: rule__EnumRule__Group__4 : rule__EnumRule__Group__4__Impl rule__EnumRule__Group__5 ;
    public final void rule__EnumRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5258:1: ( rule__EnumRule__Group__4__Impl rule__EnumRule__Group__5 )
            // InternalXtextGrammarTestLanguage.g:5259:2: rule__EnumRule__Group__4__Impl rule__EnumRule__Group__5
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
    // InternalXtextGrammarTestLanguage.g:5266:1: rule__EnumRule__Group__4__Impl : ( ( rule__EnumRule__AlternativesAssignment_4 ) ) ;
    public final void rule__EnumRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5270:1: ( ( ( rule__EnumRule__AlternativesAssignment_4 ) ) )
            // InternalXtextGrammarTestLanguage.g:5271:1: ( ( rule__EnumRule__AlternativesAssignment_4 ) )
            {
            // InternalXtextGrammarTestLanguage.g:5271:1: ( ( rule__EnumRule__AlternativesAssignment_4 ) )
            // InternalXtextGrammarTestLanguage.g:5272:2: ( rule__EnumRule__AlternativesAssignment_4 )
            {
             before(grammarAccess.getEnumRuleAccess().getAlternativesAssignment_4()); 
            // InternalXtextGrammarTestLanguage.g:5273:2: ( rule__EnumRule__AlternativesAssignment_4 )
            // InternalXtextGrammarTestLanguage.g:5273:3: rule__EnumRule__AlternativesAssignment_4
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
    // InternalXtextGrammarTestLanguage.g:5281:1: rule__EnumRule__Group__5 : rule__EnumRule__Group__5__Impl ;
    public final void rule__EnumRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5285:1: ( rule__EnumRule__Group__5__Impl )
            // InternalXtextGrammarTestLanguage.g:5286:2: rule__EnumRule__Group__5__Impl
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
    // InternalXtextGrammarTestLanguage.g:5292:1: rule__EnumRule__Group__5__Impl : ( ';' ) ;
    public final void rule__EnumRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5296:1: ( ( ';' ) )
            // InternalXtextGrammarTestLanguage.g:5297:1: ( ';' )
            {
            // InternalXtextGrammarTestLanguage.g:5297:1: ( ';' )
            // InternalXtextGrammarTestLanguage.g:5298:2: ';'
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
    // InternalXtextGrammarTestLanguage.g:5308:1: rule__EnumRule__Group_2__0 : rule__EnumRule__Group_2__0__Impl rule__EnumRule__Group_2__1 ;
    public final void rule__EnumRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5312:1: ( rule__EnumRule__Group_2__0__Impl rule__EnumRule__Group_2__1 )
            // InternalXtextGrammarTestLanguage.g:5313:2: rule__EnumRule__Group_2__0__Impl rule__EnumRule__Group_2__1
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
    // InternalXtextGrammarTestLanguage.g:5320:1: rule__EnumRule__Group_2__0__Impl : ( 'returns' ) ;
    public final void rule__EnumRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5324:1: ( ( 'returns' ) )
            // InternalXtextGrammarTestLanguage.g:5325:1: ( 'returns' )
            {
            // InternalXtextGrammarTestLanguage.g:5325:1: ( 'returns' )
            // InternalXtextGrammarTestLanguage.g:5326:2: 'returns'
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
    // InternalXtextGrammarTestLanguage.g:5335:1: rule__EnumRule__Group_2__1 : rule__EnumRule__Group_2__1__Impl ;
    public final void rule__EnumRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5339:1: ( rule__EnumRule__Group_2__1__Impl )
            // InternalXtextGrammarTestLanguage.g:5340:2: rule__EnumRule__Group_2__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:5346:1: rule__EnumRule__Group_2__1__Impl : ( ( rule__EnumRule__TypeAssignment_2_1 ) ) ;
    public final void rule__EnumRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5350:1: ( ( ( rule__EnumRule__TypeAssignment_2_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:5351:1: ( ( rule__EnumRule__TypeAssignment_2_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:5351:1: ( ( rule__EnumRule__TypeAssignment_2_1 ) )
            // InternalXtextGrammarTestLanguage.g:5352:2: ( rule__EnumRule__TypeAssignment_2_1 )
            {
             before(grammarAccess.getEnumRuleAccess().getTypeAssignment_2_1()); 
            // InternalXtextGrammarTestLanguage.g:5353:2: ( rule__EnumRule__TypeAssignment_2_1 )
            // InternalXtextGrammarTestLanguage.g:5353:3: rule__EnumRule__TypeAssignment_2_1
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
    // InternalXtextGrammarTestLanguage.g:5362:1: rule__EnumLiterals__Group__0 : rule__EnumLiterals__Group__0__Impl rule__EnumLiterals__Group__1 ;
    public final void rule__EnumLiterals__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5366:1: ( rule__EnumLiterals__Group__0__Impl rule__EnumLiterals__Group__1 )
            // InternalXtextGrammarTestLanguage.g:5367:2: rule__EnumLiterals__Group__0__Impl rule__EnumLiterals__Group__1
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
    // InternalXtextGrammarTestLanguage.g:5374:1: rule__EnumLiterals__Group__0__Impl : ( ruleEnumLiteralDeclaration ) ;
    public final void rule__EnumLiterals__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5378:1: ( ( ruleEnumLiteralDeclaration ) )
            // InternalXtextGrammarTestLanguage.g:5379:1: ( ruleEnumLiteralDeclaration )
            {
            // InternalXtextGrammarTestLanguage.g:5379:1: ( ruleEnumLiteralDeclaration )
            // InternalXtextGrammarTestLanguage.g:5380:2: ruleEnumLiteralDeclaration
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
    // InternalXtextGrammarTestLanguage.g:5389:1: rule__EnumLiterals__Group__1 : rule__EnumLiterals__Group__1__Impl ;
    public final void rule__EnumLiterals__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5393:1: ( rule__EnumLiterals__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:5394:2: rule__EnumLiterals__Group__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:5400:1: rule__EnumLiterals__Group__1__Impl : ( ( rule__EnumLiterals__Group_1__0 )? ) ;
    public final void rule__EnumLiterals__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5404:1: ( ( ( rule__EnumLiterals__Group_1__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:5405:1: ( ( rule__EnumLiterals__Group_1__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:5405:1: ( ( rule__EnumLiterals__Group_1__0 )? )
            // InternalXtextGrammarTestLanguage.g:5406:2: ( rule__EnumLiterals__Group_1__0 )?
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup_1()); 
            // InternalXtextGrammarTestLanguage.g:5407:2: ( rule__EnumLiterals__Group_1__0 )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==30) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:5407:3: rule__EnumLiterals__Group_1__0
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
    // InternalXtextGrammarTestLanguage.g:5416:1: rule__EnumLiterals__Group_1__0 : rule__EnumLiterals__Group_1__0__Impl rule__EnumLiterals__Group_1__1 ;
    public final void rule__EnumLiterals__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5420:1: ( rule__EnumLiterals__Group_1__0__Impl rule__EnumLiterals__Group_1__1 )
            // InternalXtextGrammarTestLanguage.g:5421:2: rule__EnumLiterals__Group_1__0__Impl rule__EnumLiterals__Group_1__1
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
    // InternalXtextGrammarTestLanguage.g:5428:1: rule__EnumLiterals__Group_1__0__Impl : ( () ) ;
    public final void rule__EnumLiterals__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5432:1: ( ( () ) )
            // InternalXtextGrammarTestLanguage.g:5433:1: ( () )
            {
            // InternalXtextGrammarTestLanguage.g:5433:1: ( () )
            // InternalXtextGrammarTestLanguage.g:5434:2: ()
            {
             before(grammarAccess.getEnumLiteralsAccess().getAlternativesGroupsAction_1_0()); 
            // InternalXtextGrammarTestLanguage.g:5435:2: ()
            // InternalXtextGrammarTestLanguage.g:5435:3: 
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
    // InternalXtextGrammarTestLanguage.g:5443:1: rule__EnumLiterals__Group_1__1 : rule__EnumLiterals__Group_1__1__Impl ;
    public final void rule__EnumLiterals__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5447:1: ( rule__EnumLiterals__Group_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:5448:2: rule__EnumLiterals__Group_1__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:5454:1: rule__EnumLiterals__Group_1__1__Impl : ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) ) ;
    public final void rule__EnumLiterals__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5458:1: ( ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) ) )
            // InternalXtextGrammarTestLanguage.g:5459:1: ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) )
            {
            // InternalXtextGrammarTestLanguage.g:5459:1: ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) )
            // InternalXtextGrammarTestLanguage.g:5460:2: ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* )
            {
            // InternalXtextGrammarTestLanguage.g:5460:2: ( ( rule__EnumLiterals__Group_1_1__0 ) )
            // InternalXtextGrammarTestLanguage.g:5461:3: ( rule__EnumLiterals__Group_1_1__0 )
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 
            // InternalXtextGrammarTestLanguage.g:5462:3: ( rule__EnumLiterals__Group_1_1__0 )
            // InternalXtextGrammarTestLanguage.g:5462:4: rule__EnumLiterals__Group_1_1__0
            {
            pushFollow(FOLLOW_20);
            rule__EnumLiterals__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 

            }

            // InternalXtextGrammarTestLanguage.g:5465:2: ( ( rule__EnumLiterals__Group_1_1__0 )* )
            // InternalXtextGrammarTestLanguage.g:5466:3: ( rule__EnumLiterals__Group_1_1__0 )*
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 
            // InternalXtextGrammarTestLanguage.g:5467:3: ( rule__EnumLiterals__Group_1_1__0 )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==30) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:5467:4: rule__EnumLiterals__Group_1_1__0
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
    // InternalXtextGrammarTestLanguage.g:5477:1: rule__EnumLiterals__Group_1_1__0 : rule__EnumLiterals__Group_1_1__0__Impl rule__EnumLiterals__Group_1_1__1 ;
    public final void rule__EnumLiterals__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5481:1: ( rule__EnumLiterals__Group_1_1__0__Impl rule__EnumLiterals__Group_1_1__1 )
            // InternalXtextGrammarTestLanguage.g:5482:2: rule__EnumLiterals__Group_1_1__0__Impl rule__EnumLiterals__Group_1_1__1
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
    // InternalXtextGrammarTestLanguage.g:5489:1: rule__EnumLiterals__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__EnumLiterals__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5493:1: ( ( '|' ) )
            // InternalXtextGrammarTestLanguage.g:5494:1: ( '|' )
            {
            // InternalXtextGrammarTestLanguage.g:5494:1: ( '|' )
            // InternalXtextGrammarTestLanguage.g:5495:2: '|'
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
    // InternalXtextGrammarTestLanguage.g:5504:1: rule__EnumLiterals__Group_1_1__1 : rule__EnumLiterals__Group_1_1__1__Impl ;
    public final void rule__EnumLiterals__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5508:1: ( rule__EnumLiterals__Group_1_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:5509:2: rule__EnumLiterals__Group_1_1__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:5515:1: rule__EnumLiterals__Group_1_1__1__Impl : ( ( rule__EnumLiterals__GroupsAssignment_1_1_1 ) ) ;
    public final void rule__EnumLiterals__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5519:1: ( ( ( rule__EnumLiterals__GroupsAssignment_1_1_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:5520:1: ( ( rule__EnumLiterals__GroupsAssignment_1_1_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:5520:1: ( ( rule__EnumLiterals__GroupsAssignment_1_1_1 ) )
            // InternalXtextGrammarTestLanguage.g:5521:2: ( rule__EnumLiterals__GroupsAssignment_1_1_1 )
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroupsAssignment_1_1_1()); 
            // InternalXtextGrammarTestLanguage.g:5522:2: ( rule__EnumLiterals__GroupsAssignment_1_1_1 )
            // InternalXtextGrammarTestLanguage.g:5522:3: rule__EnumLiterals__GroupsAssignment_1_1_1
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
    // InternalXtextGrammarTestLanguage.g:5531:1: rule__EnumLiteralDeclaration__Group__0 : rule__EnumLiteralDeclaration__Group__0__Impl rule__EnumLiteralDeclaration__Group__1 ;
    public final void rule__EnumLiteralDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5535:1: ( rule__EnumLiteralDeclaration__Group__0__Impl rule__EnumLiteralDeclaration__Group__1 )
            // InternalXtextGrammarTestLanguage.g:5536:2: rule__EnumLiteralDeclaration__Group__0__Impl rule__EnumLiteralDeclaration__Group__1
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
    // InternalXtextGrammarTestLanguage.g:5543:1: rule__EnumLiteralDeclaration__Group__0__Impl : ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) ) ;
    public final void rule__EnumLiteralDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5547:1: ( ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:5548:1: ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:5548:1: ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) )
            // InternalXtextGrammarTestLanguage.g:5549:2: ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralAssignment_0()); 
            // InternalXtextGrammarTestLanguage.g:5550:2: ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 )
            // InternalXtextGrammarTestLanguage.g:5550:3: rule__EnumLiteralDeclaration__EnumLiteralAssignment_0
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
    // InternalXtextGrammarTestLanguage.g:5558:1: rule__EnumLiteralDeclaration__Group__1 : rule__EnumLiteralDeclaration__Group__1__Impl ;
    public final void rule__EnumLiteralDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5562:1: ( rule__EnumLiteralDeclaration__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:5563:2: rule__EnumLiteralDeclaration__Group__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:5569:1: rule__EnumLiteralDeclaration__Group__1__Impl : ( ( rule__EnumLiteralDeclaration__Group_1__0 )? ) ;
    public final void rule__EnumLiteralDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5573:1: ( ( ( rule__EnumLiteralDeclaration__Group_1__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:5574:1: ( ( rule__EnumLiteralDeclaration__Group_1__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:5574:1: ( ( rule__EnumLiteralDeclaration__Group_1__0 )? )
            // InternalXtextGrammarTestLanguage.g:5575:2: ( rule__EnumLiteralDeclaration__Group_1__0 )?
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getGroup_1()); 
            // InternalXtextGrammarTestLanguage.g:5576:2: ( rule__EnumLiteralDeclaration__Group_1__0 )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==14) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:5576:3: rule__EnumLiteralDeclaration__Group_1__0
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
    // InternalXtextGrammarTestLanguage.g:5585:1: rule__EnumLiteralDeclaration__Group_1__0 : rule__EnumLiteralDeclaration__Group_1__0__Impl rule__EnumLiteralDeclaration__Group_1__1 ;
    public final void rule__EnumLiteralDeclaration__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5589:1: ( rule__EnumLiteralDeclaration__Group_1__0__Impl rule__EnumLiteralDeclaration__Group_1__1 )
            // InternalXtextGrammarTestLanguage.g:5590:2: rule__EnumLiteralDeclaration__Group_1__0__Impl rule__EnumLiteralDeclaration__Group_1__1
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
    // InternalXtextGrammarTestLanguage.g:5597:1: rule__EnumLiteralDeclaration__Group_1__0__Impl : ( '=' ) ;
    public final void rule__EnumLiteralDeclaration__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5601:1: ( ( '=' ) )
            // InternalXtextGrammarTestLanguage.g:5602:1: ( '=' )
            {
            // InternalXtextGrammarTestLanguage.g:5602:1: ( '=' )
            // InternalXtextGrammarTestLanguage.g:5603:2: '='
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
    // InternalXtextGrammarTestLanguage.g:5612:1: rule__EnumLiteralDeclaration__Group_1__1 : rule__EnumLiteralDeclaration__Group_1__1__Impl ;
    public final void rule__EnumLiteralDeclaration__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5616:1: ( rule__EnumLiteralDeclaration__Group_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:5617:2: rule__EnumLiteralDeclaration__Group_1__1__Impl
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
    // InternalXtextGrammarTestLanguage.g:5623:1: rule__EnumLiteralDeclaration__Group_1__1__Impl : ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) ) ;
    public final void rule__EnumLiteralDeclaration__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5627:1: ( ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:5628:1: ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:5628:1: ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) )
            // InternalXtextGrammarTestLanguage.g:5629:2: ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralAssignment_1_1()); 
            // InternalXtextGrammarTestLanguage.g:5630:2: ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 )
            // InternalXtextGrammarTestLanguage.g:5630:3: rule__EnumLiteralDeclaration__LiteralAssignment_1_1
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
    // InternalXtextGrammarTestLanguage.g:5639:1: rule__Grammar__NameAssignment_1 : ( ruleGrammarID ) ;
    public final void rule__Grammar__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5643:1: ( ( ruleGrammarID ) )
            // InternalXtextGrammarTestLanguage.g:5644:2: ( ruleGrammarID )
            {
            // InternalXtextGrammarTestLanguage.g:5644:2: ( ruleGrammarID )
            // InternalXtextGrammarTestLanguage.g:5645:3: ruleGrammarID
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
    // InternalXtextGrammarTestLanguage.g:5654:1: rule__Grammar__UsedGrammarsAssignment_2_1 : ( ( ruleGrammarID ) ) ;
    public final void rule__Grammar__UsedGrammarsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5658:1: ( ( ( ruleGrammarID ) ) )
            // InternalXtextGrammarTestLanguage.g:5659:2: ( ( ruleGrammarID ) )
            {
            // InternalXtextGrammarTestLanguage.g:5659:2: ( ( ruleGrammarID ) )
            // InternalXtextGrammarTestLanguage.g:5660:3: ( ruleGrammarID )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_1_0()); 
            // InternalXtextGrammarTestLanguage.g:5661:3: ( ruleGrammarID )
            // InternalXtextGrammarTestLanguage.g:5662:4: ruleGrammarID
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
    // InternalXtextGrammarTestLanguage.g:5673:1: rule__Grammar__UsedGrammarsAssignment_2_2_1 : ( ( ruleGrammarID ) ) ;
    public final void rule__Grammar__UsedGrammarsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5677:1: ( ( ( ruleGrammarID ) ) )
            // InternalXtextGrammarTestLanguage.g:5678:2: ( ( ruleGrammarID ) )
            {
            // InternalXtextGrammarTestLanguage.g:5678:2: ( ( ruleGrammarID ) )
            // InternalXtextGrammarTestLanguage.g:5679:3: ( ruleGrammarID )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_2_1_0()); 
            // InternalXtextGrammarTestLanguage.g:5680:3: ( ruleGrammarID )
            // InternalXtextGrammarTestLanguage.g:5681:4: ruleGrammarID
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
    // InternalXtextGrammarTestLanguage.g:5692:1: rule__Grammar__DefinesHiddenTokensAssignment_3_0 : ( ( 'hidden' ) ) ;
    public final void rule__Grammar__DefinesHiddenTokensAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5696:1: ( ( ( 'hidden' ) ) )
            // InternalXtextGrammarTestLanguage.g:5697:2: ( ( 'hidden' ) )
            {
            // InternalXtextGrammarTestLanguage.g:5697:2: ( ( 'hidden' ) )
            // InternalXtextGrammarTestLanguage.g:5698:3: ( 'hidden' )
            {
             before(grammarAccess.getGrammarAccess().getDefinesHiddenTokensHiddenKeyword_3_0_0()); 
            // InternalXtextGrammarTestLanguage.g:5699:3: ( 'hidden' )
            // InternalXtextGrammarTestLanguage.g:5700:4: 'hidden'
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
    // InternalXtextGrammarTestLanguage.g:5711:1: rule__Grammar__HiddenTokensAssignment_3_2_0 : ( ( RULE_ID ) ) ;
    public final void rule__Grammar__HiddenTokensAssignment_3_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5715:1: ( ( ( RULE_ID ) ) )
            // InternalXtextGrammarTestLanguage.g:5716:2: ( ( RULE_ID ) )
            {
            // InternalXtextGrammarTestLanguage.g:5716:2: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:5717:3: ( RULE_ID )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_0_0()); 
            // InternalXtextGrammarTestLanguage.g:5718:3: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:5719:4: RULE_ID
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
    // InternalXtextGrammarTestLanguage.g:5730:1: rule__Grammar__HiddenTokensAssignment_3_2_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Grammar__HiddenTokensAssignment_3_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5734:1: ( ( ( RULE_ID ) ) )
            // InternalXtextGrammarTestLanguage.g:5735:2: ( ( RULE_ID ) )
            {
            // InternalXtextGrammarTestLanguage.g:5735:2: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:5736:3: ( RULE_ID )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_1_1_0()); 
            // InternalXtextGrammarTestLanguage.g:5737:3: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:5738:4: RULE_ID
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
    // InternalXtextGrammarTestLanguage.g:5749:1: rule__Grammar__MetamodelDeclarationsAssignment_4 : ( ruleAbstractMetamodelDeclaration ) ;
    public final void rule__Grammar__MetamodelDeclarationsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5753:1: ( ( ruleAbstractMetamodelDeclaration ) )
            // InternalXtextGrammarTestLanguage.g:5754:2: ( ruleAbstractMetamodelDeclaration )
            {
            // InternalXtextGrammarTestLanguage.g:5754:2: ( ruleAbstractMetamodelDeclaration )
            // InternalXtextGrammarTestLanguage.g:5755:3: ruleAbstractMetamodelDeclaration
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
    // InternalXtextGrammarTestLanguage.g:5764:1: rule__Grammar__RulesAssignment_5 : ( ruleAbstractRule ) ;
    public final void rule__Grammar__RulesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5768:1: ( ( ruleAbstractRule ) )
            // InternalXtextGrammarTestLanguage.g:5769:2: ( ruleAbstractRule )
            {
            // InternalXtextGrammarTestLanguage.g:5769:2: ( ruleAbstractRule )
            // InternalXtextGrammarTestLanguage.g:5770:3: ruleAbstractRule
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
    // InternalXtextGrammarTestLanguage.g:5779:1: rule__GeneratedMetamodel__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__GeneratedMetamodel__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5783:1: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:5784:2: ( RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:5784:2: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:5785:3: RULE_ID
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
    // InternalXtextGrammarTestLanguage.g:5794:1: rule__GeneratedMetamodel__EPackageAssignment_2 : ( ( RULE_STRING ) ) ;
    public final void rule__GeneratedMetamodel__EPackageAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5798:1: ( ( ( RULE_STRING ) ) )
            // InternalXtextGrammarTestLanguage.g:5799:2: ( ( RULE_STRING ) )
            {
            // InternalXtextGrammarTestLanguage.g:5799:2: ( ( RULE_STRING ) )
            // InternalXtextGrammarTestLanguage.g:5800:3: ( RULE_STRING )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageCrossReference_2_0()); 
            // InternalXtextGrammarTestLanguage.g:5801:3: ( RULE_STRING )
            // InternalXtextGrammarTestLanguage.g:5802:4: RULE_STRING
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
    // InternalXtextGrammarTestLanguage.g:5813:1: rule__GeneratedMetamodel__AliasAssignment_3_1 : ( RULE_ID ) ;
    public final void rule__GeneratedMetamodel__AliasAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5817:1: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:5818:2: ( RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:5818:2: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:5819:3: RULE_ID
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
    // InternalXtextGrammarTestLanguage.g:5828:1: rule__ReferencedMetamodel__EPackageAssignment_1 : ( ( RULE_STRING ) ) ;
    public final void rule__ReferencedMetamodel__EPackageAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5832:1: ( ( ( RULE_STRING ) ) )
            // InternalXtextGrammarTestLanguage.g:5833:2: ( ( RULE_STRING ) )
            {
            // InternalXtextGrammarTestLanguage.g:5833:2: ( ( RULE_STRING ) )
            // InternalXtextGrammarTestLanguage.g:5834:3: ( RULE_STRING )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageCrossReference_1_0()); 
            // InternalXtextGrammarTestLanguage.g:5835:3: ( RULE_STRING )
            // InternalXtextGrammarTestLanguage.g:5836:4: RULE_STRING
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
    // InternalXtextGrammarTestLanguage.g:5847:1: rule__ReferencedMetamodel__AliasAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__ReferencedMetamodel__AliasAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5851:1: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:5852:2: ( RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:5852:2: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:5853:3: RULE_ID
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
    // InternalXtextGrammarTestLanguage.g:5862:1: rule__ParserRule__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__ParserRule__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5866:1: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:5867:2: ( RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:5867:2: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:5868:3: RULE_ID
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
    // InternalXtextGrammarTestLanguage.g:5877:1: rule__ParserRule__TypeAssignment_1_1 : ( ruleTypeRef ) ;
    public final void rule__ParserRule__TypeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5881:1: ( ( ruleTypeRef ) )
            // InternalXtextGrammarTestLanguage.g:5882:2: ( ruleTypeRef )
            {
            // InternalXtextGrammarTestLanguage.g:5882:2: ( ruleTypeRef )
            // InternalXtextGrammarTestLanguage.g:5883:3: ruleTypeRef
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
    // InternalXtextGrammarTestLanguage.g:5892:1: rule__ParserRule__DefinesHiddenTokensAssignment_2_0 : ( ( 'hidden' ) ) ;
    public final void rule__ParserRule__DefinesHiddenTokensAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5896:1: ( ( ( 'hidden' ) ) )
            // InternalXtextGrammarTestLanguage.g:5897:2: ( ( 'hidden' ) )
            {
            // InternalXtextGrammarTestLanguage.g:5897:2: ( ( 'hidden' ) )
            // InternalXtextGrammarTestLanguage.g:5898:3: ( 'hidden' )
            {
             before(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_2_0_0()); 
            // InternalXtextGrammarTestLanguage.g:5899:3: ( 'hidden' )
            // InternalXtextGrammarTestLanguage.g:5900:4: 'hidden'
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
    // InternalXtextGrammarTestLanguage.g:5911:1: rule__ParserRule__HiddenTokensAssignment_2_2_0 : ( ( RULE_ID ) ) ;
    public final void rule__ParserRule__HiddenTokensAssignment_2_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5915:1: ( ( ( RULE_ID ) ) )
            // InternalXtextGrammarTestLanguage.g:5916:2: ( ( RULE_ID ) )
            {
            // InternalXtextGrammarTestLanguage.g:5916:2: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:5917:3: ( RULE_ID )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_0_0()); 
            // InternalXtextGrammarTestLanguage.g:5918:3: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:5919:4: RULE_ID
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
    // InternalXtextGrammarTestLanguage.g:5930:1: rule__ParserRule__HiddenTokensAssignment_2_2_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__ParserRule__HiddenTokensAssignment_2_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5934:1: ( ( ( RULE_ID ) ) )
            // InternalXtextGrammarTestLanguage.g:5935:2: ( ( RULE_ID ) )
            {
            // InternalXtextGrammarTestLanguage.g:5935:2: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:5936:3: ( RULE_ID )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_1_1_0()); 
            // InternalXtextGrammarTestLanguage.g:5937:3: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:5938:4: RULE_ID
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
    // InternalXtextGrammarTestLanguage.g:5949:1: rule__ParserRule__AlternativesAssignment_4 : ( ruleAlternatives ) ;
    public final void rule__ParserRule__AlternativesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5953:1: ( ( ruleAlternatives ) )
            // InternalXtextGrammarTestLanguage.g:5954:2: ( ruleAlternatives )
            {
            // InternalXtextGrammarTestLanguage.g:5954:2: ( ruleAlternatives )
            // InternalXtextGrammarTestLanguage.g:5955:3: ruleAlternatives
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
    // InternalXtextGrammarTestLanguage.g:5964:1: rule__TypeRef__MetamodelAssignment_0_0 : ( ( RULE_ID ) ) ;
    public final void rule__TypeRef__MetamodelAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5968:1: ( ( ( RULE_ID ) ) )
            // InternalXtextGrammarTestLanguage.g:5969:2: ( ( RULE_ID ) )
            {
            // InternalXtextGrammarTestLanguage.g:5969:2: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:5970:3: ( RULE_ID )
            {
             before(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationCrossReference_0_0_0()); 
            // InternalXtextGrammarTestLanguage.g:5971:3: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:5972:4: RULE_ID
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
    // InternalXtextGrammarTestLanguage.g:5983:1: rule__TypeRef__ClassifierAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__TypeRef__ClassifierAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5987:1: ( ( ( RULE_ID ) ) )
            // InternalXtextGrammarTestLanguage.g:5988:2: ( ( RULE_ID ) )
            {
            // InternalXtextGrammarTestLanguage.g:5988:2: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:5989:3: ( RULE_ID )
            {
             before(grammarAccess.getTypeRefAccess().getClassifierEClassifierCrossReference_1_0()); 
            // InternalXtextGrammarTestLanguage.g:5990:3: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:5991:4: RULE_ID
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
    // InternalXtextGrammarTestLanguage.g:6002:1: rule__Alternatives__GroupsAssignment_1_1_1 : ( ruleGroup ) ;
    public final void rule__Alternatives__GroupsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6006:1: ( ( ruleGroup ) )
            // InternalXtextGrammarTestLanguage.g:6007:2: ( ruleGroup )
            {
            // InternalXtextGrammarTestLanguage.g:6007:2: ( ruleGroup )
            // InternalXtextGrammarTestLanguage.g:6008:3: ruleGroup
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
    // InternalXtextGrammarTestLanguage.g:6017:1: rule__Group__TokensAssignment_1_1 : ( ruleAbstractToken ) ;
    public final void rule__Group__TokensAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6021:1: ( ( ruleAbstractToken ) )
            // InternalXtextGrammarTestLanguage.g:6022:2: ( ruleAbstractToken )
            {
            // InternalXtextGrammarTestLanguage.g:6022:2: ( ruleAbstractToken )
            // InternalXtextGrammarTestLanguage.g:6023:3: ruleAbstractToken
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
    // InternalXtextGrammarTestLanguage.g:6032:1: rule__AbstractTokenWithCardinality__CardinalityAssignment_1 : ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) ) ;
    public final void rule__AbstractTokenWithCardinality__CardinalityAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6036:1: ( ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:6037:2: ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:6037:2: ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) )
            // InternalXtextGrammarTestLanguage.g:6038:3: ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 )
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAlternatives_1_0()); 
            // InternalXtextGrammarTestLanguage.g:6039:3: ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 )
            // InternalXtextGrammarTestLanguage.g:6039:4: rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0
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
    // InternalXtextGrammarTestLanguage.g:6047:1: rule__Action__TypeAssignment_1 : ( ruleTypeRef ) ;
    public final void rule__Action__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6051:1: ( ( ruleTypeRef ) )
            // InternalXtextGrammarTestLanguage.g:6052:2: ( ruleTypeRef )
            {
            // InternalXtextGrammarTestLanguage.g:6052:2: ( ruleTypeRef )
            // InternalXtextGrammarTestLanguage.g:6053:3: ruleTypeRef
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
    // InternalXtextGrammarTestLanguage.g:6062:1: rule__Action__FeatureAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__Action__FeatureAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6066:1: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:6067:2: ( RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:6067:2: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:6068:3: RULE_ID
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
    // InternalXtextGrammarTestLanguage.g:6077:1: rule__Action__OperatorAssignment_2_2 : ( ( rule__Action__OperatorAlternatives_2_2_0 ) ) ;
    public final void rule__Action__OperatorAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6081:1: ( ( ( rule__Action__OperatorAlternatives_2_2_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:6082:2: ( ( rule__Action__OperatorAlternatives_2_2_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:6082:2: ( ( rule__Action__OperatorAlternatives_2_2_0 ) )
            // InternalXtextGrammarTestLanguage.g:6083:3: ( rule__Action__OperatorAlternatives_2_2_0 )
            {
             before(grammarAccess.getActionAccess().getOperatorAlternatives_2_2_0()); 
            // InternalXtextGrammarTestLanguage.g:6084:3: ( rule__Action__OperatorAlternatives_2_2_0 )
            // InternalXtextGrammarTestLanguage.g:6084:4: rule__Action__OperatorAlternatives_2_2_0
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
    // InternalXtextGrammarTestLanguage.g:6092:1: rule__Keyword__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__Keyword__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6096:1: ( ( RULE_STRING ) )
            // InternalXtextGrammarTestLanguage.g:6097:2: ( RULE_STRING )
            {
            // InternalXtextGrammarTestLanguage.g:6097:2: ( RULE_STRING )
            // InternalXtextGrammarTestLanguage.g:6098:3: RULE_STRING
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
    // InternalXtextGrammarTestLanguage.g:6107:1: rule__RuleCall__RuleAssignment : ( ( RULE_ID ) ) ;
    public final void rule__RuleCall__RuleAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6111:1: ( ( ( RULE_ID ) ) )
            // InternalXtextGrammarTestLanguage.g:6112:2: ( ( RULE_ID ) )
            {
            // InternalXtextGrammarTestLanguage.g:6112:2: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:6113:3: ( RULE_ID )
            {
             before(grammarAccess.getRuleCallAccess().getRuleAbstractRuleCrossReference_0()); 
            // InternalXtextGrammarTestLanguage.g:6114:3: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:6115:4: RULE_ID
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
    // InternalXtextGrammarTestLanguage.g:6126:1: rule__Assignment__FeatureAssignment_0 : ( RULE_ID ) ;
    public final void rule__Assignment__FeatureAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6130:1: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:6131:2: ( RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:6131:2: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:6132:3: RULE_ID
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
    // InternalXtextGrammarTestLanguage.g:6141:1: rule__Assignment__OperatorAssignment_1 : ( ( rule__Assignment__OperatorAlternatives_1_0 ) ) ;
    public final void rule__Assignment__OperatorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6145:1: ( ( ( rule__Assignment__OperatorAlternatives_1_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:6146:2: ( ( rule__Assignment__OperatorAlternatives_1_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:6146:2: ( ( rule__Assignment__OperatorAlternatives_1_0 ) )
            // InternalXtextGrammarTestLanguage.g:6147:3: ( rule__Assignment__OperatorAlternatives_1_0 )
            {
             before(grammarAccess.getAssignmentAccess().getOperatorAlternatives_1_0()); 
            // InternalXtextGrammarTestLanguage.g:6148:3: ( rule__Assignment__OperatorAlternatives_1_0 )
            // InternalXtextGrammarTestLanguage.g:6148:4: rule__Assignment__OperatorAlternatives_1_0
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
    // InternalXtextGrammarTestLanguage.g:6156:1: rule__Assignment__TerminalAssignment_2 : ( ruleAssignableTerminal ) ;
    public final void rule__Assignment__TerminalAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6160:1: ( ( ruleAssignableTerminal ) )
            // InternalXtextGrammarTestLanguage.g:6161:2: ( ruleAssignableTerminal )
            {
            // InternalXtextGrammarTestLanguage.g:6161:2: ( ruleAssignableTerminal )
            // InternalXtextGrammarTestLanguage.g:6162:3: ruleAssignableTerminal
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
    // InternalXtextGrammarTestLanguage.g:6171:1: rule__AssignableAlternatives__GroupsAssignment_1_1_1 : ( ruleAssignableTerminal ) ;
    public final void rule__AssignableAlternatives__GroupsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6175:1: ( ( ruleAssignableTerminal ) )
            // InternalXtextGrammarTestLanguage.g:6176:2: ( ruleAssignableTerminal )
            {
            // InternalXtextGrammarTestLanguage.g:6176:2: ( ruleAssignableTerminal )
            // InternalXtextGrammarTestLanguage.g:6177:3: ruleAssignableTerminal
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
    // InternalXtextGrammarTestLanguage.g:6186:1: rule__CrossReference__TypeAssignment_1 : ( ruleTypeRef ) ;
    public final void rule__CrossReference__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6190:1: ( ( ruleTypeRef ) )
            // InternalXtextGrammarTestLanguage.g:6191:2: ( ruleTypeRef )
            {
            // InternalXtextGrammarTestLanguage.g:6191:2: ( ruleTypeRef )
            // InternalXtextGrammarTestLanguage.g:6192:3: ruleTypeRef
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
    // InternalXtextGrammarTestLanguage.g:6201:1: rule__CrossReference__TerminalAssignment_2_1 : ( ruleCrossReferenceableTerminal ) ;
    public final void rule__CrossReference__TerminalAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6205:1: ( ( ruleCrossReferenceableTerminal ) )
            // InternalXtextGrammarTestLanguage.g:6206:2: ( ruleCrossReferenceableTerminal )
            {
            // InternalXtextGrammarTestLanguage.g:6206:2: ( ruleCrossReferenceableTerminal )
            // InternalXtextGrammarTestLanguage.g:6207:3: ruleCrossReferenceableTerminal
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
    // InternalXtextGrammarTestLanguage.g:6216:1: rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1 : ( ruleCrossReferenceableTerminal ) ;
    public final void rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6220:1: ( ( ruleCrossReferenceableTerminal ) )
            // InternalXtextGrammarTestLanguage.g:6221:2: ( ruleCrossReferenceableTerminal )
            {
            // InternalXtextGrammarTestLanguage.g:6221:2: ( ruleCrossReferenceableTerminal )
            // InternalXtextGrammarTestLanguage.g:6222:3: ruleCrossReferenceableTerminal
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
    // InternalXtextGrammarTestLanguage.g:6231:1: rule__TerminalRule__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__TerminalRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6235:1: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:6236:2: ( RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:6236:2: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:6237:3: RULE_ID
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
    // InternalXtextGrammarTestLanguage.g:6246:1: rule__TerminalRule__TypeAssignment_2_1 : ( ruleTypeRef ) ;
    public final void rule__TerminalRule__TypeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6250:1: ( ( ruleTypeRef ) )
            // InternalXtextGrammarTestLanguage.g:6251:2: ( ruleTypeRef )
            {
            // InternalXtextGrammarTestLanguage.g:6251:2: ( ruleTypeRef )
            // InternalXtextGrammarTestLanguage.g:6252:3: ruleTypeRef
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
    // InternalXtextGrammarTestLanguage.g:6261:1: rule__TerminalRule__AlternativesAssignment_4 : ( ruleTerminalAlternatives ) ;
    public final void rule__TerminalRule__AlternativesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6265:1: ( ( ruleTerminalAlternatives ) )
            // InternalXtextGrammarTestLanguage.g:6266:2: ( ruleTerminalAlternatives )
            {
            // InternalXtextGrammarTestLanguage.g:6266:2: ( ruleTerminalAlternatives )
            // InternalXtextGrammarTestLanguage.g:6267:3: ruleTerminalAlternatives
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
    // InternalXtextGrammarTestLanguage.g:6276:1: rule__TerminalAlternatives__GroupsAssignment_1_1_1 : ( ruleTerminalGroup ) ;
    public final void rule__TerminalAlternatives__GroupsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6280:1: ( ( ruleTerminalGroup ) )
            // InternalXtextGrammarTestLanguage.g:6281:2: ( ruleTerminalGroup )
            {
            // InternalXtextGrammarTestLanguage.g:6281:2: ( ruleTerminalGroup )
            // InternalXtextGrammarTestLanguage.g:6282:3: ruleTerminalGroup
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
    // InternalXtextGrammarTestLanguage.g:6291:1: rule__TerminalGroup__TokensAssignment_1_1 : ( ruleTerminalToken ) ;
    public final void rule__TerminalGroup__TokensAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6295:1: ( ( ruleTerminalToken ) )
            // InternalXtextGrammarTestLanguage.g:6296:2: ( ruleTerminalToken )
            {
            // InternalXtextGrammarTestLanguage.g:6296:2: ( ruleTerminalToken )
            // InternalXtextGrammarTestLanguage.g:6297:3: ruleTerminalToken
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
    // InternalXtextGrammarTestLanguage.g:6306:1: rule__TerminalToken__CardinalityAssignment_1 : ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) ) ;
    public final void rule__TerminalToken__CardinalityAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6310:1: ( ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:6311:2: ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:6311:2: ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) )
            // InternalXtextGrammarTestLanguage.g:6312:3: ( rule__TerminalToken__CardinalityAlternatives_1_0 )
            {
             before(grammarAccess.getTerminalTokenAccess().getCardinalityAlternatives_1_0()); 
            // InternalXtextGrammarTestLanguage.g:6313:3: ( rule__TerminalToken__CardinalityAlternatives_1_0 )
            // InternalXtextGrammarTestLanguage.g:6313:4: rule__TerminalToken__CardinalityAlternatives_1_0
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
    // InternalXtextGrammarTestLanguage.g:6321:1: rule__NegatedToken__TerminalAssignment_1 : ( ruleTerminalTokenElement ) ;
    public final void rule__NegatedToken__TerminalAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6325:1: ( ( ruleTerminalTokenElement ) )
            // InternalXtextGrammarTestLanguage.g:6326:2: ( ruleTerminalTokenElement )
            {
            // InternalXtextGrammarTestLanguage.g:6326:2: ( ruleTerminalTokenElement )
            // InternalXtextGrammarTestLanguage.g:6327:3: ruleTerminalTokenElement
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
    // InternalXtextGrammarTestLanguage.g:6336:1: rule__UntilToken__TerminalAssignment_1 : ( ruleTerminalTokenElement ) ;
    public final void rule__UntilToken__TerminalAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6340:1: ( ( ruleTerminalTokenElement ) )
            // InternalXtextGrammarTestLanguage.g:6341:2: ( ruleTerminalTokenElement )
            {
            // InternalXtextGrammarTestLanguage.g:6341:2: ( ruleTerminalTokenElement )
            // InternalXtextGrammarTestLanguage.g:6342:3: ruleTerminalTokenElement
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
    // InternalXtextGrammarTestLanguage.g:6351:1: rule__CharacterRange__RightAssignment_1_2 : ( ruleKeyword ) ;
    public final void rule__CharacterRange__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6355:1: ( ( ruleKeyword ) )
            // InternalXtextGrammarTestLanguage.g:6356:2: ( ruleKeyword )
            {
            // InternalXtextGrammarTestLanguage.g:6356:2: ( ruleKeyword )
            // InternalXtextGrammarTestLanguage.g:6357:3: ruleKeyword
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
    // InternalXtextGrammarTestLanguage.g:6366:1: rule__EnumRule__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__EnumRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6370:1: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:6371:2: ( RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:6371:2: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:6372:3: RULE_ID
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
    // InternalXtextGrammarTestLanguage.g:6381:1: rule__EnumRule__TypeAssignment_2_1 : ( ruleTypeRef ) ;
    public final void rule__EnumRule__TypeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6385:1: ( ( ruleTypeRef ) )
            // InternalXtextGrammarTestLanguage.g:6386:2: ( ruleTypeRef )
            {
            // InternalXtextGrammarTestLanguage.g:6386:2: ( ruleTypeRef )
            // InternalXtextGrammarTestLanguage.g:6387:3: ruleTypeRef
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
    // InternalXtextGrammarTestLanguage.g:6396:1: rule__EnumRule__AlternativesAssignment_4 : ( ruleEnumLiterals ) ;
    public final void rule__EnumRule__AlternativesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6400:1: ( ( ruleEnumLiterals ) )
            // InternalXtextGrammarTestLanguage.g:6401:2: ( ruleEnumLiterals )
            {
            // InternalXtextGrammarTestLanguage.g:6401:2: ( ruleEnumLiterals )
            // InternalXtextGrammarTestLanguage.g:6402:3: ruleEnumLiterals
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
    // InternalXtextGrammarTestLanguage.g:6411:1: rule__EnumLiterals__GroupsAssignment_1_1_1 : ( ruleEnumLiteralDeclaration ) ;
    public final void rule__EnumLiterals__GroupsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6415:1: ( ( ruleEnumLiteralDeclaration ) )
            // InternalXtextGrammarTestLanguage.g:6416:2: ( ruleEnumLiteralDeclaration )
            {
            // InternalXtextGrammarTestLanguage.g:6416:2: ( ruleEnumLiteralDeclaration )
            // InternalXtextGrammarTestLanguage.g:6417:3: ruleEnumLiteralDeclaration
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
    // InternalXtextGrammarTestLanguage.g:6426:1: rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__EnumLiteralDeclaration__EnumLiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6430:1: ( ( ( RULE_ID ) ) )
            // InternalXtextGrammarTestLanguage.g:6431:2: ( ( RULE_ID ) )
            {
            // InternalXtextGrammarTestLanguage.g:6431:2: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:6432:3: ( RULE_ID )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralCrossReference_0_0()); 
            // InternalXtextGrammarTestLanguage.g:6433:3: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:6434:4: RULE_ID
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
    // InternalXtextGrammarTestLanguage.g:6445:1: rule__EnumLiteralDeclaration__LiteralAssignment_1_1 : ( ruleKeyword ) ;
    public final void rule__EnumLiteralDeclaration__LiteralAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6449:1: ( ( ruleKeyword ) )
            // InternalXtextGrammarTestLanguage.g:6450:2: ( ruleKeyword )
            {
            // InternalXtextGrammarTestLanguage.g:6450:2: ( ruleKeyword )
            // InternalXtextGrammarTestLanguage.g:6451:3: ruleKeyword
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
package org.eclipse.xtext.xtext.ide.contentassist.antlr.internal;

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
import org.eclipse.xtext.services.XtextGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/*******************************************************************************
 * Copyright (c) 2010, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
@SuppressWarnings("all")
public class InternalXtextParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'?'", "'*'", "'+'", "'='", "'+='", "'false'", "'true'", "'?='", "'grammar'", "'with'", "','", "'('", "')'", "'.'", "'generate'", "'as'", "'import'", "'@'", "':'", "';'", "'returns'", "'<'", "'>'", "'::'", "'|'", "'&'", "'{'", "'}'", "'current'", "'!'", "'['", "']'", "'terminal'", "'->'", "'EOF'", "'..'", "'enum'", "'hidden'", "'fragment'", "'=>'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int RULE_ID=4;
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
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

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
    // InternalXtext.g:58:1: entryRuleGrammar : ruleGrammar EOF ;
    public final void entryRuleGrammar() throws RecognitionException {
        try {
            // InternalXtext.g:59:1: ( ruleGrammar EOF )
            // InternalXtext.g:60:1: ruleGrammar EOF
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
    // InternalXtext.g:67:1: ruleGrammar : ( ( rule__Grammar__Group__0 ) ) ;
    public final void ruleGrammar() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:71:2: ( ( ( rule__Grammar__Group__0 ) ) )
            // InternalXtext.g:72:2: ( ( rule__Grammar__Group__0 ) )
            {
            // InternalXtext.g:72:2: ( ( rule__Grammar__Group__0 ) )
            // InternalXtext.g:73:3: ( rule__Grammar__Group__0 )
            {
             before(grammarAccess.getGrammarAccess().getGroup()); 
            // InternalXtext.g:74:3: ( rule__Grammar__Group__0 )
            // InternalXtext.g:74:4: rule__Grammar__Group__0
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
    // InternalXtext.g:83:1: entryRuleGrammarID : ruleGrammarID EOF ;
    public final void entryRuleGrammarID() throws RecognitionException {
        try {
            // InternalXtext.g:84:1: ( ruleGrammarID EOF )
            // InternalXtext.g:85:1: ruleGrammarID EOF
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
    // InternalXtext.g:92:1: ruleGrammarID : ( ( rule__GrammarID__Group__0 ) ) ;
    public final void ruleGrammarID() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:96:2: ( ( ( rule__GrammarID__Group__0 ) ) )
            // InternalXtext.g:97:2: ( ( rule__GrammarID__Group__0 ) )
            {
            // InternalXtext.g:97:2: ( ( rule__GrammarID__Group__0 ) )
            // InternalXtext.g:98:3: ( rule__GrammarID__Group__0 )
            {
             before(grammarAccess.getGrammarIDAccess().getGroup()); 
            // InternalXtext.g:99:3: ( rule__GrammarID__Group__0 )
            // InternalXtext.g:99:4: rule__GrammarID__Group__0
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
    // InternalXtext.g:108:1: entryRuleAbstractRule : ruleAbstractRule EOF ;
    public final void entryRuleAbstractRule() throws RecognitionException {
        try {
            // InternalXtext.g:109:1: ( ruleAbstractRule EOF )
            // InternalXtext.g:110:1: ruleAbstractRule EOF
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
    // InternalXtext.g:117:1: ruleAbstractRule : ( ( rule__AbstractRule__Alternatives ) ) ;
    public final void ruleAbstractRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:121:2: ( ( ( rule__AbstractRule__Alternatives ) ) )
            // InternalXtext.g:122:2: ( ( rule__AbstractRule__Alternatives ) )
            {
            // InternalXtext.g:122:2: ( ( rule__AbstractRule__Alternatives ) )
            // InternalXtext.g:123:3: ( rule__AbstractRule__Alternatives )
            {
             before(grammarAccess.getAbstractRuleAccess().getAlternatives()); 
            // InternalXtext.g:124:3: ( rule__AbstractRule__Alternatives )
            // InternalXtext.g:124:4: rule__AbstractRule__Alternatives
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
    // InternalXtext.g:133:1: entryRuleAbstractMetamodelDeclaration : ruleAbstractMetamodelDeclaration EOF ;
    public final void entryRuleAbstractMetamodelDeclaration() throws RecognitionException {
        try {
            // InternalXtext.g:134:1: ( ruleAbstractMetamodelDeclaration EOF )
            // InternalXtext.g:135:1: ruleAbstractMetamodelDeclaration EOF
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
    // InternalXtext.g:142:1: ruleAbstractMetamodelDeclaration : ( ( rule__AbstractMetamodelDeclaration__Alternatives ) ) ;
    public final void ruleAbstractMetamodelDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:146:2: ( ( ( rule__AbstractMetamodelDeclaration__Alternatives ) ) )
            // InternalXtext.g:147:2: ( ( rule__AbstractMetamodelDeclaration__Alternatives ) )
            {
            // InternalXtext.g:147:2: ( ( rule__AbstractMetamodelDeclaration__Alternatives ) )
            // InternalXtext.g:148:3: ( rule__AbstractMetamodelDeclaration__Alternatives )
            {
             before(grammarAccess.getAbstractMetamodelDeclarationAccess().getAlternatives()); 
            // InternalXtext.g:149:3: ( rule__AbstractMetamodelDeclaration__Alternatives )
            // InternalXtext.g:149:4: rule__AbstractMetamodelDeclaration__Alternatives
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
    // InternalXtext.g:158:1: entryRuleGeneratedMetamodel : ruleGeneratedMetamodel EOF ;
    public final void entryRuleGeneratedMetamodel() throws RecognitionException {
        try {
            // InternalXtext.g:159:1: ( ruleGeneratedMetamodel EOF )
            // InternalXtext.g:160:1: ruleGeneratedMetamodel EOF
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
    // InternalXtext.g:167:1: ruleGeneratedMetamodel : ( ( rule__GeneratedMetamodel__Group__0 ) ) ;
    public final void ruleGeneratedMetamodel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:171:2: ( ( ( rule__GeneratedMetamodel__Group__0 ) ) )
            // InternalXtext.g:172:2: ( ( rule__GeneratedMetamodel__Group__0 ) )
            {
            // InternalXtext.g:172:2: ( ( rule__GeneratedMetamodel__Group__0 ) )
            // InternalXtext.g:173:3: ( rule__GeneratedMetamodel__Group__0 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getGroup()); 
            // InternalXtext.g:174:3: ( rule__GeneratedMetamodel__Group__0 )
            // InternalXtext.g:174:4: rule__GeneratedMetamodel__Group__0
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
    // InternalXtext.g:183:1: entryRuleReferencedMetamodel : ruleReferencedMetamodel EOF ;
    public final void entryRuleReferencedMetamodel() throws RecognitionException {
        try {
            // InternalXtext.g:184:1: ( ruleReferencedMetamodel EOF )
            // InternalXtext.g:185:1: ruleReferencedMetamodel EOF
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
    // InternalXtext.g:192:1: ruleReferencedMetamodel : ( ( rule__ReferencedMetamodel__Group__0 ) ) ;
    public final void ruleReferencedMetamodel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:196:2: ( ( ( rule__ReferencedMetamodel__Group__0 ) ) )
            // InternalXtext.g:197:2: ( ( rule__ReferencedMetamodel__Group__0 ) )
            {
            // InternalXtext.g:197:2: ( ( rule__ReferencedMetamodel__Group__0 ) )
            // InternalXtext.g:198:3: ( rule__ReferencedMetamodel__Group__0 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getGroup()); 
            // InternalXtext.g:199:3: ( rule__ReferencedMetamodel__Group__0 )
            // InternalXtext.g:199:4: rule__ReferencedMetamodel__Group__0
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


    // $ANTLR start "entryRuleAnnotation"
    // InternalXtext.g:208:1: entryRuleAnnotation : ruleAnnotation EOF ;
    public final void entryRuleAnnotation() throws RecognitionException {
        try {
            // InternalXtext.g:209:1: ( ruleAnnotation EOF )
            // InternalXtext.g:210:1: ruleAnnotation EOF
            {
             before(grammarAccess.getAnnotationRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAnnotation();

            state._fsp--;

             after(grammarAccess.getAnnotationRule()); 
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
    // $ANTLR end "entryRuleAnnotation"


    // $ANTLR start "ruleAnnotation"
    // InternalXtext.g:217:1: ruleAnnotation : ( ( rule__Annotation__Group__0 ) ) ;
    public final void ruleAnnotation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:221:2: ( ( ( rule__Annotation__Group__0 ) ) )
            // InternalXtext.g:222:2: ( ( rule__Annotation__Group__0 ) )
            {
            // InternalXtext.g:222:2: ( ( rule__Annotation__Group__0 ) )
            // InternalXtext.g:223:3: ( rule__Annotation__Group__0 )
            {
             before(grammarAccess.getAnnotationAccess().getGroup()); 
            // InternalXtext.g:224:3: ( rule__Annotation__Group__0 )
            // InternalXtext.g:224:4: rule__Annotation__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Annotation__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAnnotationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAnnotation"


    // $ANTLR start "entryRuleParserRule"
    // InternalXtext.g:233:1: entryRuleParserRule : ruleParserRule EOF ;
    public final void entryRuleParserRule() throws RecognitionException {
        try {
            // InternalXtext.g:234:1: ( ruleParserRule EOF )
            // InternalXtext.g:235:1: ruleParserRule EOF
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
    // InternalXtext.g:242:1: ruleParserRule : ( ( rule__ParserRule__Group__0 ) ) ;
    public final void ruleParserRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:246:2: ( ( ( rule__ParserRule__Group__0 ) ) )
            // InternalXtext.g:247:2: ( ( rule__ParserRule__Group__0 ) )
            {
            // InternalXtext.g:247:2: ( ( rule__ParserRule__Group__0 ) )
            // InternalXtext.g:248:3: ( rule__ParserRule__Group__0 )
            {
             before(grammarAccess.getParserRuleAccess().getGroup()); 
            // InternalXtext.g:249:3: ( rule__ParserRule__Group__0 )
            // InternalXtext.g:249:4: rule__ParserRule__Group__0
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


    // $ANTLR start "ruleRuleNameAndParams"
    // InternalXtext.g:259:1: ruleRuleNameAndParams : ( ( rule__RuleNameAndParams__Group__0 ) ) ;
    public final void ruleRuleNameAndParams() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:263:2: ( ( ( rule__RuleNameAndParams__Group__0 ) ) )
            // InternalXtext.g:264:2: ( ( rule__RuleNameAndParams__Group__0 ) )
            {
            // InternalXtext.g:264:2: ( ( rule__RuleNameAndParams__Group__0 ) )
            // InternalXtext.g:265:3: ( rule__RuleNameAndParams__Group__0 )
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getGroup()); 
            // InternalXtext.g:266:3: ( rule__RuleNameAndParams__Group__0 )
            // InternalXtext.g:266:4: rule__RuleNameAndParams__Group__0
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
    // InternalXtext.g:275:1: entryRuleParameter : ruleParameter EOF ;
    public final void entryRuleParameter() throws RecognitionException {
        try {
            // InternalXtext.g:276:1: ( ruleParameter EOF )
            // InternalXtext.g:277:1: ruleParameter EOF
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
    // InternalXtext.g:284:1: ruleParameter : ( ( rule__Parameter__NameAssignment ) ) ;
    public final void ruleParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:288:2: ( ( ( rule__Parameter__NameAssignment ) ) )
            // InternalXtext.g:289:2: ( ( rule__Parameter__NameAssignment ) )
            {
            // InternalXtext.g:289:2: ( ( rule__Parameter__NameAssignment ) )
            // InternalXtext.g:290:3: ( rule__Parameter__NameAssignment )
            {
             before(grammarAccess.getParameterAccess().getNameAssignment()); 
            // InternalXtext.g:291:3: ( rule__Parameter__NameAssignment )
            // InternalXtext.g:291:4: rule__Parameter__NameAssignment
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
    // InternalXtext.g:300:1: entryRuleTypeRef : ruleTypeRef EOF ;
    public final void entryRuleTypeRef() throws RecognitionException {
        try {
            // InternalXtext.g:301:1: ( ruleTypeRef EOF )
            // InternalXtext.g:302:1: ruleTypeRef EOF
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
    // InternalXtext.g:309:1: ruleTypeRef : ( ( rule__TypeRef__Group__0 ) ) ;
    public final void ruleTypeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:313:2: ( ( ( rule__TypeRef__Group__0 ) ) )
            // InternalXtext.g:314:2: ( ( rule__TypeRef__Group__0 ) )
            {
            // InternalXtext.g:314:2: ( ( rule__TypeRef__Group__0 ) )
            // InternalXtext.g:315:3: ( rule__TypeRef__Group__0 )
            {
             before(grammarAccess.getTypeRefAccess().getGroup()); 
            // InternalXtext.g:316:3: ( rule__TypeRef__Group__0 )
            // InternalXtext.g:316:4: rule__TypeRef__Group__0
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
    // InternalXtext.g:325:1: entryRuleAlternatives : ruleAlternatives EOF ;
    public final void entryRuleAlternatives() throws RecognitionException {
        try {
            // InternalXtext.g:326:1: ( ruleAlternatives EOF )
            // InternalXtext.g:327:1: ruleAlternatives EOF
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
    // InternalXtext.g:334:1: ruleAlternatives : ( ( rule__Alternatives__Group__0 ) ) ;
    public final void ruleAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:338:2: ( ( ( rule__Alternatives__Group__0 ) ) )
            // InternalXtext.g:339:2: ( ( rule__Alternatives__Group__0 ) )
            {
            // InternalXtext.g:339:2: ( ( rule__Alternatives__Group__0 ) )
            // InternalXtext.g:340:3: ( rule__Alternatives__Group__0 )
            {
             before(grammarAccess.getAlternativesAccess().getGroup()); 
            // InternalXtext.g:341:3: ( rule__Alternatives__Group__0 )
            // InternalXtext.g:341:4: rule__Alternatives__Group__0
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
    // InternalXtext.g:350:1: entryRuleConditionalBranch : ruleConditionalBranch EOF ;
    public final void entryRuleConditionalBranch() throws RecognitionException {
        try {
            // InternalXtext.g:351:1: ( ruleConditionalBranch EOF )
            // InternalXtext.g:352:1: ruleConditionalBranch EOF
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
    // InternalXtext.g:359:1: ruleConditionalBranch : ( ( rule__ConditionalBranch__Alternatives ) ) ;
    public final void ruleConditionalBranch() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:363:2: ( ( ( rule__ConditionalBranch__Alternatives ) ) )
            // InternalXtext.g:364:2: ( ( rule__ConditionalBranch__Alternatives ) )
            {
            // InternalXtext.g:364:2: ( ( rule__ConditionalBranch__Alternatives ) )
            // InternalXtext.g:365:3: ( rule__ConditionalBranch__Alternatives )
            {
             before(grammarAccess.getConditionalBranchAccess().getAlternatives()); 
            // InternalXtext.g:366:3: ( rule__ConditionalBranch__Alternatives )
            // InternalXtext.g:366:4: rule__ConditionalBranch__Alternatives
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
    // InternalXtext.g:375:1: entryRuleUnorderedGroup : ruleUnorderedGroup EOF ;
    public final void entryRuleUnorderedGroup() throws RecognitionException {
        try {
            // InternalXtext.g:376:1: ( ruleUnorderedGroup EOF )
            // InternalXtext.g:377:1: ruleUnorderedGroup EOF
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
    // InternalXtext.g:384:1: ruleUnorderedGroup : ( ( rule__UnorderedGroup__Group__0 ) ) ;
    public final void ruleUnorderedGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:388:2: ( ( ( rule__UnorderedGroup__Group__0 ) ) )
            // InternalXtext.g:389:2: ( ( rule__UnorderedGroup__Group__0 ) )
            {
            // InternalXtext.g:389:2: ( ( rule__UnorderedGroup__Group__0 ) )
            // InternalXtext.g:390:3: ( rule__UnorderedGroup__Group__0 )
            {
             before(grammarAccess.getUnorderedGroupAccess().getGroup()); 
            // InternalXtext.g:391:3: ( rule__UnorderedGroup__Group__0 )
            // InternalXtext.g:391:4: rule__UnorderedGroup__Group__0
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
    // InternalXtext.g:400:1: entryRuleGroup : ruleGroup EOF ;
    public final void entryRuleGroup() throws RecognitionException {
        try {
            // InternalXtext.g:401:1: ( ruleGroup EOF )
            // InternalXtext.g:402:1: ruleGroup EOF
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
    // InternalXtext.g:409:1: ruleGroup : ( ( rule__Group__Group__0 ) ) ;
    public final void ruleGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:413:2: ( ( ( rule__Group__Group__0 ) ) )
            // InternalXtext.g:414:2: ( ( rule__Group__Group__0 ) )
            {
            // InternalXtext.g:414:2: ( ( rule__Group__Group__0 ) )
            // InternalXtext.g:415:3: ( rule__Group__Group__0 )
            {
             before(grammarAccess.getGroupAccess().getGroup()); 
            // InternalXtext.g:416:3: ( rule__Group__Group__0 )
            // InternalXtext.g:416:4: rule__Group__Group__0
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
    // InternalXtext.g:425:1: entryRuleAbstractToken : ruleAbstractToken EOF ;
    public final void entryRuleAbstractToken() throws RecognitionException {
        try {
            // InternalXtext.g:426:1: ( ruleAbstractToken EOF )
            // InternalXtext.g:427:1: ruleAbstractToken EOF
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
    // InternalXtext.g:434:1: ruleAbstractToken : ( ( rule__AbstractToken__Alternatives ) ) ;
    public final void ruleAbstractToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:438:2: ( ( ( rule__AbstractToken__Alternatives ) ) )
            // InternalXtext.g:439:2: ( ( rule__AbstractToken__Alternatives ) )
            {
            // InternalXtext.g:439:2: ( ( rule__AbstractToken__Alternatives ) )
            // InternalXtext.g:440:3: ( rule__AbstractToken__Alternatives )
            {
             before(grammarAccess.getAbstractTokenAccess().getAlternatives()); 
            // InternalXtext.g:441:3: ( rule__AbstractToken__Alternatives )
            // InternalXtext.g:441:4: rule__AbstractToken__Alternatives
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
    // InternalXtext.g:450:1: entryRuleAbstractTokenWithCardinality : ruleAbstractTokenWithCardinality EOF ;
    public final void entryRuleAbstractTokenWithCardinality() throws RecognitionException {
        try {
            // InternalXtext.g:451:1: ( ruleAbstractTokenWithCardinality EOF )
            // InternalXtext.g:452:1: ruleAbstractTokenWithCardinality EOF
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
    // InternalXtext.g:459:1: ruleAbstractTokenWithCardinality : ( ( rule__AbstractTokenWithCardinality__Group__0 ) ) ;
    public final void ruleAbstractTokenWithCardinality() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:463:2: ( ( ( rule__AbstractTokenWithCardinality__Group__0 ) ) )
            // InternalXtext.g:464:2: ( ( rule__AbstractTokenWithCardinality__Group__0 ) )
            {
            // InternalXtext.g:464:2: ( ( rule__AbstractTokenWithCardinality__Group__0 ) )
            // InternalXtext.g:465:3: ( rule__AbstractTokenWithCardinality__Group__0 )
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getGroup()); 
            // InternalXtext.g:466:3: ( rule__AbstractTokenWithCardinality__Group__0 )
            // InternalXtext.g:466:4: rule__AbstractTokenWithCardinality__Group__0
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
    // InternalXtext.g:475:1: entryRuleAction : ruleAction EOF ;
    public final void entryRuleAction() throws RecognitionException {
        try {
            // InternalXtext.g:476:1: ( ruleAction EOF )
            // InternalXtext.g:477:1: ruleAction EOF
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
    // InternalXtext.g:484:1: ruleAction : ( ( rule__Action__Group__0 ) ) ;
    public final void ruleAction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:488:2: ( ( ( rule__Action__Group__0 ) ) )
            // InternalXtext.g:489:2: ( ( rule__Action__Group__0 ) )
            {
            // InternalXtext.g:489:2: ( ( rule__Action__Group__0 ) )
            // InternalXtext.g:490:3: ( rule__Action__Group__0 )
            {
             before(grammarAccess.getActionAccess().getGroup()); 
            // InternalXtext.g:491:3: ( rule__Action__Group__0 )
            // InternalXtext.g:491:4: rule__Action__Group__0
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
    // InternalXtext.g:500:1: entryRuleAbstractTerminal : ruleAbstractTerminal EOF ;
    public final void entryRuleAbstractTerminal() throws RecognitionException {
        try {
            // InternalXtext.g:501:1: ( ruleAbstractTerminal EOF )
            // InternalXtext.g:502:1: ruleAbstractTerminal EOF
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
    // InternalXtext.g:509:1: ruleAbstractTerminal : ( ( rule__AbstractTerminal__Alternatives ) ) ;
    public final void ruleAbstractTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:513:2: ( ( ( rule__AbstractTerminal__Alternatives ) ) )
            // InternalXtext.g:514:2: ( ( rule__AbstractTerminal__Alternatives ) )
            {
            // InternalXtext.g:514:2: ( ( rule__AbstractTerminal__Alternatives ) )
            // InternalXtext.g:515:3: ( rule__AbstractTerminal__Alternatives )
            {
             before(grammarAccess.getAbstractTerminalAccess().getAlternatives()); 
            // InternalXtext.g:516:3: ( rule__AbstractTerminal__Alternatives )
            // InternalXtext.g:516:4: rule__AbstractTerminal__Alternatives
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
    // InternalXtext.g:525:1: entryRuleKeyword : ruleKeyword EOF ;
    public final void entryRuleKeyword() throws RecognitionException {
        try {
            // InternalXtext.g:526:1: ( ruleKeyword EOF )
            // InternalXtext.g:527:1: ruleKeyword EOF
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
    // InternalXtext.g:534:1: ruleKeyword : ( ( rule__Keyword__ValueAssignment ) ) ;
    public final void ruleKeyword() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:538:2: ( ( ( rule__Keyword__ValueAssignment ) ) )
            // InternalXtext.g:539:2: ( ( rule__Keyword__ValueAssignment ) )
            {
            // InternalXtext.g:539:2: ( ( rule__Keyword__ValueAssignment ) )
            // InternalXtext.g:540:3: ( rule__Keyword__ValueAssignment )
            {
             before(grammarAccess.getKeywordAccess().getValueAssignment()); 
            // InternalXtext.g:541:3: ( rule__Keyword__ValueAssignment )
            // InternalXtext.g:541:4: rule__Keyword__ValueAssignment
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
    // InternalXtext.g:550:1: entryRuleRuleCall : ruleRuleCall EOF ;
    public final void entryRuleRuleCall() throws RecognitionException {
        try {
            // InternalXtext.g:551:1: ( ruleRuleCall EOF )
            // InternalXtext.g:552:1: ruleRuleCall EOF
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
    // InternalXtext.g:559:1: ruleRuleCall : ( ( rule__RuleCall__Group__0 ) ) ;
    public final void ruleRuleCall() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:563:2: ( ( ( rule__RuleCall__Group__0 ) ) )
            // InternalXtext.g:564:2: ( ( rule__RuleCall__Group__0 ) )
            {
            // InternalXtext.g:564:2: ( ( rule__RuleCall__Group__0 ) )
            // InternalXtext.g:565:3: ( rule__RuleCall__Group__0 )
            {
             before(grammarAccess.getRuleCallAccess().getGroup()); 
            // InternalXtext.g:566:3: ( rule__RuleCall__Group__0 )
            // InternalXtext.g:566:4: rule__RuleCall__Group__0
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
    // InternalXtext.g:575:1: entryRuleNamedArgument : ruleNamedArgument EOF ;
    public final void entryRuleNamedArgument() throws RecognitionException {
        try {
            // InternalXtext.g:576:1: ( ruleNamedArgument EOF )
            // InternalXtext.g:577:1: ruleNamedArgument EOF
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
    // InternalXtext.g:584:1: ruleNamedArgument : ( ( rule__NamedArgument__Group__0 ) ) ;
    public final void ruleNamedArgument() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:588:2: ( ( ( rule__NamedArgument__Group__0 ) ) )
            // InternalXtext.g:589:2: ( ( rule__NamedArgument__Group__0 ) )
            {
            // InternalXtext.g:589:2: ( ( rule__NamedArgument__Group__0 ) )
            // InternalXtext.g:590:3: ( rule__NamedArgument__Group__0 )
            {
             before(grammarAccess.getNamedArgumentAccess().getGroup()); 
            // InternalXtext.g:591:3: ( rule__NamedArgument__Group__0 )
            // InternalXtext.g:591:4: rule__NamedArgument__Group__0
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
    // InternalXtext.g:600:1: entryRuleLiteralCondition : ruleLiteralCondition EOF ;
    public final void entryRuleLiteralCondition() throws RecognitionException {
        try {
            // InternalXtext.g:601:1: ( ruleLiteralCondition EOF )
            // InternalXtext.g:602:1: ruleLiteralCondition EOF
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
    // InternalXtext.g:609:1: ruleLiteralCondition : ( ( rule__LiteralCondition__Group__0 ) ) ;
    public final void ruleLiteralCondition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:613:2: ( ( ( rule__LiteralCondition__Group__0 ) ) )
            // InternalXtext.g:614:2: ( ( rule__LiteralCondition__Group__0 ) )
            {
            // InternalXtext.g:614:2: ( ( rule__LiteralCondition__Group__0 ) )
            // InternalXtext.g:615:3: ( rule__LiteralCondition__Group__0 )
            {
             before(grammarAccess.getLiteralConditionAccess().getGroup()); 
            // InternalXtext.g:616:3: ( rule__LiteralCondition__Group__0 )
            // InternalXtext.g:616:4: rule__LiteralCondition__Group__0
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
    // InternalXtext.g:625:1: entryRuleDisjunction : ruleDisjunction EOF ;
    public final void entryRuleDisjunction() throws RecognitionException {
        try {
            // InternalXtext.g:626:1: ( ruleDisjunction EOF )
            // InternalXtext.g:627:1: ruleDisjunction EOF
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
    // InternalXtext.g:634:1: ruleDisjunction : ( ( rule__Disjunction__Group__0 ) ) ;
    public final void ruleDisjunction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:638:2: ( ( ( rule__Disjunction__Group__0 ) ) )
            // InternalXtext.g:639:2: ( ( rule__Disjunction__Group__0 ) )
            {
            // InternalXtext.g:639:2: ( ( rule__Disjunction__Group__0 ) )
            // InternalXtext.g:640:3: ( rule__Disjunction__Group__0 )
            {
             before(grammarAccess.getDisjunctionAccess().getGroup()); 
            // InternalXtext.g:641:3: ( rule__Disjunction__Group__0 )
            // InternalXtext.g:641:4: rule__Disjunction__Group__0
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
    // InternalXtext.g:650:1: entryRuleConjunction : ruleConjunction EOF ;
    public final void entryRuleConjunction() throws RecognitionException {
        try {
            // InternalXtext.g:651:1: ( ruleConjunction EOF )
            // InternalXtext.g:652:1: ruleConjunction EOF
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
    // InternalXtext.g:659:1: ruleConjunction : ( ( rule__Conjunction__Group__0 ) ) ;
    public final void ruleConjunction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:663:2: ( ( ( rule__Conjunction__Group__0 ) ) )
            // InternalXtext.g:664:2: ( ( rule__Conjunction__Group__0 ) )
            {
            // InternalXtext.g:664:2: ( ( rule__Conjunction__Group__0 ) )
            // InternalXtext.g:665:3: ( rule__Conjunction__Group__0 )
            {
             before(grammarAccess.getConjunctionAccess().getGroup()); 
            // InternalXtext.g:666:3: ( rule__Conjunction__Group__0 )
            // InternalXtext.g:666:4: rule__Conjunction__Group__0
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
    // InternalXtext.g:675:1: entryRuleNegation : ruleNegation EOF ;
    public final void entryRuleNegation() throws RecognitionException {
        try {
            // InternalXtext.g:676:1: ( ruleNegation EOF )
            // InternalXtext.g:677:1: ruleNegation EOF
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
    // InternalXtext.g:684:1: ruleNegation : ( ( rule__Negation__Alternatives ) ) ;
    public final void ruleNegation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:688:2: ( ( ( rule__Negation__Alternatives ) ) )
            // InternalXtext.g:689:2: ( ( rule__Negation__Alternatives ) )
            {
            // InternalXtext.g:689:2: ( ( rule__Negation__Alternatives ) )
            // InternalXtext.g:690:3: ( rule__Negation__Alternatives )
            {
             before(grammarAccess.getNegationAccess().getAlternatives()); 
            // InternalXtext.g:691:3: ( rule__Negation__Alternatives )
            // InternalXtext.g:691:4: rule__Negation__Alternatives
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
    // InternalXtext.g:700:1: entryRuleAtom : ruleAtom EOF ;
    public final void entryRuleAtom() throws RecognitionException {
        try {
            // InternalXtext.g:701:1: ( ruleAtom EOF )
            // InternalXtext.g:702:1: ruleAtom EOF
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
    // InternalXtext.g:709:1: ruleAtom : ( ( rule__Atom__Alternatives ) ) ;
    public final void ruleAtom() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:713:2: ( ( ( rule__Atom__Alternatives ) ) )
            // InternalXtext.g:714:2: ( ( rule__Atom__Alternatives ) )
            {
            // InternalXtext.g:714:2: ( ( rule__Atom__Alternatives ) )
            // InternalXtext.g:715:3: ( rule__Atom__Alternatives )
            {
             before(grammarAccess.getAtomAccess().getAlternatives()); 
            // InternalXtext.g:716:3: ( rule__Atom__Alternatives )
            // InternalXtext.g:716:4: rule__Atom__Alternatives
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
    // InternalXtext.g:725:1: entryRuleParenthesizedCondition : ruleParenthesizedCondition EOF ;
    public final void entryRuleParenthesizedCondition() throws RecognitionException {
        try {
            // InternalXtext.g:726:1: ( ruleParenthesizedCondition EOF )
            // InternalXtext.g:727:1: ruleParenthesizedCondition EOF
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
    // InternalXtext.g:734:1: ruleParenthesizedCondition : ( ( rule__ParenthesizedCondition__Group__0 ) ) ;
    public final void ruleParenthesizedCondition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:738:2: ( ( ( rule__ParenthesizedCondition__Group__0 ) ) )
            // InternalXtext.g:739:2: ( ( rule__ParenthesizedCondition__Group__0 ) )
            {
            // InternalXtext.g:739:2: ( ( rule__ParenthesizedCondition__Group__0 ) )
            // InternalXtext.g:740:3: ( rule__ParenthesizedCondition__Group__0 )
            {
             before(grammarAccess.getParenthesizedConditionAccess().getGroup()); 
            // InternalXtext.g:741:3: ( rule__ParenthesizedCondition__Group__0 )
            // InternalXtext.g:741:4: rule__ParenthesizedCondition__Group__0
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
    // InternalXtext.g:750:1: entryRuleParameterReference : ruleParameterReference EOF ;
    public final void entryRuleParameterReference() throws RecognitionException {
        try {
            // InternalXtext.g:751:1: ( ruleParameterReference EOF )
            // InternalXtext.g:752:1: ruleParameterReference EOF
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
    // InternalXtext.g:759:1: ruleParameterReference : ( ( rule__ParameterReference__ParameterAssignment ) ) ;
    public final void ruleParameterReference() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:763:2: ( ( ( rule__ParameterReference__ParameterAssignment ) ) )
            // InternalXtext.g:764:2: ( ( rule__ParameterReference__ParameterAssignment ) )
            {
            // InternalXtext.g:764:2: ( ( rule__ParameterReference__ParameterAssignment ) )
            // InternalXtext.g:765:3: ( rule__ParameterReference__ParameterAssignment )
            {
             before(grammarAccess.getParameterReferenceAccess().getParameterAssignment()); 
            // InternalXtext.g:766:3: ( rule__ParameterReference__ParameterAssignment )
            // InternalXtext.g:766:4: rule__ParameterReference__ParameterAssignment
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
    // InternalXtext.g:775:1: entryRuleTerminalRuleCall : ruleTerminalRuleCall EOF ;
    public final void entryRuleTerminalRuleCall() throws RecognitionException {
        try {
            // InternalXtext.g:776:1: ( ruleTerminalRuleCall EOF )
            // InternalXtext.g:777:1: ruleTerminalRuleCall EOF
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
    // InternalXtext.g:784:1: ruleTerminalRuleCall : ( ( rule__TerminalRuleCall__RuleAssignment ) ) ;
    public final void ruleTerminalRuleCall() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:788:2: ( ( ( rule__TerminalRuleCall__RuleAssignment ) ) )
            // InternalXtext.g:789:2: ( ( rule__TerminalRuleCall__RuleAssignment ) )
            {
            // InternalXtext.g:789:2: ( ( rule__TerminalRuleCall__RuleAssignment ) )
            // InternalXtext.g:790:3: ( rule__TerminalRuleCall__RuleAssignment )
            {
             before(grammarAccess.getTerminalRuleCallAccess().getRuleAssignment()); 
            // InternalXtext.g:791:3: ( rule__TerminalRuleCall__RuleAssignment )
            // InternalXtext.g:791:4: rule__TerminalRuleCall__RuleAssignment
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
    // InternalXtext.g:800:1: entryRuleRuleID : ruleRuleID EOF ;
    public final void entryRuleRuleID() throws RecognitionException {
        try {
            // InternalXtext.g:801:1: ( ruleRuleID EOF )
            // InternalXtext.g:802:1: ruleRuleID EOF
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
    // InternalXtext.g:809:1: ruleRuleID : ( ( rule__RuleID__Group__0 ) ) ;
    public final void ruleRuleID() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:813:2: ( ( ( rule__RuleID__Group__0 ) ) )
            // InternalXtext.g:814:2: ( ( rule__RuleID__Group__0 ) )
            {
            // InternalXtext.g:814:2: ( ( rule__RuleID__Group__0 ) )
            // InternalXtext.g:815:3: ( rule__RuleID__Group__0 )
            {
             before(grammarAccess.getRuleIDAccess().getGroup()); 
            // InternalXtext.g:816:3: ( rule__RuleID__Group__0 )
            // InternalXtext.g:816:4: rule__RuleID__Group__0
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
    // InternalXtext.g:825:1: entryRuleValidID : ruleValidID EOF ;
    public final void entryRuleValidID() throws RecognitionException {
        try {
            // InternalXtext.g:826:1: ( ruleValidID EOF )
            // InternalXtext.g:827:1: ruleValidID EOF
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
    // InternalXtext.g:834:1: ruleValidID : ( ( rule__ValidID__Alternatives ) ) ;
    public final void ruleValidID() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:838:2: ( ( ( rule__ValidID__Alternatives ) ) )
            // InternalXtext.g:839:2: ( ( rule__ValidID__Alternatives ) )
            {
            // InternalXtext.g:839:2: ( ( rule__ValidID__Alternatives ) )
            // InternalXtext.g:840:3: ( rule__ValidID__Alternatives )
            {
             before(grammarAccess.getValidIDAccess().getAlternatives()); 
            // InternalXtext.g:841:3: ( rule__ValidID__Alternatives )
            // InternalXtext.g:841:4: rule__ValidID__Alternatives
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
    // InternalXtext.g:850:1: entryRulePredicatedKeyword : rulePredicatedKeyword EOF ;
    public final void entryRulePredicatedKeyword() throws RecognitionException {
        try {
            // InternalXtext.g:851:1: ( rulePredicatedKeyword EOF )
            // InternalXtext.g:852:1: rulePredicatedKeyword EOF
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
    // InternalXtext.g:859:1: rulePredicatedKeyword : ( ( rule__PredicatedKeyword__Group__0 ) ) ;
    public final void rulePredicatedKeyword() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:863:2: ( ( ( rule__PredicatedKeyword__Group__0 ) ) )
            // InternalXtext.g:864:2: ( ( rule__PredicatedKeyword__Group__0 ) )
            {
            // InternalXtext.g:864:2: ( ( rule__PredicatedKeyword__Group__0 ) )
            // InternalXtext.g:865:3: ( rule__PredicatedKeyword__Group__0 )
            {
             before(grammarAccess.getPredicatedKeywordAccess().getGroup()); 
            // InternalXtext.g:866:3: ( rule__PredicatedKeyword__Group__0 )
            // InternalXtext.g:866:4: rule__PredicatedKeyword__Group__0
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
    // InternalXtext.g:875:1: entryRulePredicatedRuleCall : rulePredicatedRuleCall EOF ;
    public final void entryRulePredicatedRuleCall() throws RecognitionException {
        try {
            // InternalXtext.g:876:1: ( rulePredicatedRuleCall EOF )
            // InternalXtext.g:877:1: rulePredicatedRuleCall EOF
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
    // InternalXtext.g:884:1: rulePredicatedRuleCall : ( ( rule__PredicatedRuleCall__Group__0 ) ) ;
    public final void rulePredicatedRuleCall() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:888:2: ( ( ( rule__PredicatedRuleCall__Group__0 ) ) )
            // InternalXtext.g:889:2: ( ( rule__PredicatedRuleCall__Group__0 ) )
            {
            // InternalXtext.g:889:2: ( ( rule__PredicatedRuleCall__Group__0 ) )
            // InternalXtext.g:890:3: ( rule__PredicatedRuleCall__Group__0 )
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getGroup()); 
            // InternalXtext.g:891:3: ( rule__PredicatedRuleCall__Group__0 )
            // InternalXtext.g:891:4: rule__PredicatedRuleCall__Group__0
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
    // InternalXtext.g:900:1: entryRuleAssignment : ruleAssignment EOF ;
    public final void entryRuleAssignment() throws RecognitionException {
        try {
            // InternalXtext.g:901:1: ( ruleAssignment EOF )
            // InternalXtext.g:902:1: ruleAssignment EOF
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
    // InternalXtext.g:909:1: ruleAssignment : ( ( rule__Assignment__Group__0 ) ) ;
    public final void ruleAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:913:2: ( ( ( rule__Assignment__Group__0 ) ) )
            // InternalXtext.g:914:2: ( ( rule__Assignment__Group__0 ) )
            {
            // InternalXtext.g:914:2: ( ( rule__Assignment__Group__0 ) )
            // InternalXtext.g:915:3: ( rule__Assignment__Group__0 )
            {
             before(grammarAccess.getAssignmentAccess().getGroup()); 
            // InternalXtext.g:916:3: ( rule__Assignment__Group__0 )
            // InternalXtext.g:916:4: rule__Assignment__Group__0
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
    // InternalXtext.g:925:1: entryRuleAssignableTerminal : ruleAssignableTerminal EOF ;
    public final void entryRuleAssignableTerminal() throws RecognitionException {
        try {
            // InternalXtext.g:926:1: ( ruleAssignableTerminal EOF )
            // InternalXtext.g:927:1: ruleAssignableTerminal EOF
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
    // InternalXtext.g:934:1: ruleAssignableTerminal : ( ( rule__AssignableTerminal__Alternatives ) ) ;
    public final void ruleAssignableTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:938:2: ( ( ( rule__AssignableTerminal__Alternatives ) ) )
            // InternalXtext.g:939:2: ( ( rule__AssignableTerminal__Alternatives ) )
            {
            // InternalXtext.g:939:2: ( ( rule__AssignableTerminal__Alternatives ) )
            // InternalXtext.g:940:3: ( rule__AssignableTerminal__Alternatives )
            {
             before(grammarAccess.getAssignableTerminalAccess().getAlternatives()); 
            // InternalXtext.g:941:3: ( rule__AssignableTerminal__Alternatives )
            // InternalXtext.g:941:4: rule__AssignableTerminal__Alternatives
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
    // InternalXtext.g:950:1: entryRuleParenthesizedAssignableElement : ruleParenthesizedAssignableElement EOF ;
    public final void entryRuleParenthesizedAssignableElement() throws RecognitionException {
        try {
            // InternalXtext.g:951:1: ( ruleParenthesizedAssignableElement EOF )
            // InternalXtext.g:952:1: ruleParenthesizedAssignableElement EOF
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
    // InternalXtext.g:959:1: ruleParenthesizedAssignableElement : ( ( rule__ParenthesizedAssignableElement__Group__0 ) ) ;
    public final void ruleParenthesizedAssignableElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:963:2: ( ( ( rule__ParenthesizedAssignableElement__Group__0 ) ) )
            // InternalXtext.g:964:2: ( ( rule__ParenthesizedAssignableElement__Group__0 ) )
            {
            // InternalXtext.g:964:2: ( ( rule__ParenthesizedAssignableElement__Group__0 ) )
            // InternalXtext.g:965:3: ( rule__ParenthesizedAssignableElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getGroup()); 
            // InternalXtext.g:966:3: ( rule__ParenthesizedAssignableElement__Group__0 )
            // InternalXtext.g:966:4: rule__ParenthesizedAssignableElement__Group__0
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
    // InternalXtext.g:975:1: entryRuleAssignableAlternatives : ruleAssignableAlternatives EOF ;
    public final void entryRuleAssignableAlternatives() throws RecognitionException {
        try {
            // InternalXtext.g:976:1: ( ruleAssignableAlternatives EOF )
            // InternalXtext.g:977:1: ruleAssignableAlternatives EOF
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
    // InternalXtext.g:984:1: ruleAssignableAlternatives : ( ( rule__AssignableAlternatives__Group__0 ) ) ;
    public final void ruleAssignableAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:988:2: ( ( ( rule__AssignableAlternatives__Group__0 ) ) )
            // InternalXtext.g:989:2: ( ( rule__AssignableAlternatives__Group__0 ) )
            {
            // InternalXtext.g:989:2: ( ( rule__AssignableAlternatives__Group__0 ) )
            // InternalXtext.g:990:3: ( rule__AssignableAlternatives__Group__0 )
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup()); 
            // InternalXtext.g:991:3: ( rule__AssignableAlternatives__Group__0 )
            // InternalXtext.g:991:4: rule__AssignableAlternatives__Group__0
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
    // InternalXtext.g:1000:1: entryRuleCrossReference : ruleCrossReference EOF ;
    public final void entryRuleCrossReference() throws RecognitionException {
        try {
            // InternalXtext.g:1001:1: ( ruleCrossReference EOF )
            // InternalXtext.g:1002:1: ruleCrossReference EOF
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
    // InternalXtext.g:1009:1: ruleCrossReference : ( ( rule__CrossReference__Group__0 ) ) ;
    public final void ruleCrossReference() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1013:2: ( ( ( rule__CrossReference__Group__0 ) ) )
            // InternalXtext.g:1014:2: ( ( rule__CrossReference__Group__0 ) )
            {
            // InternalXtext.g:1014:2: ( ( rule__CrossReference__Group__0 ) )
            // InternalXtext.g:1015:3: ( rule__CrossReference__Group__0 )
            {
             before(grammarAccess.getCrossReferenceAccess().getGroup()); 
            // InternalXtext.g:1016:3: ( rule__CrossReference__Group__0 )
            // InternalXtext.g:1016:4: rule__CrossReference__Group__0
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
    // InternalXtext.g:1025:1: entryRuleCrossReferenceableTerminal : ruleCrossReferenceableTerminal EOF ;
    public final void entryRuleCrossReferenceableTerminal() throws RecognitionException {
        try {
            // InternalXtext.g:1026:1: ( ruleCrossReferenceableTerminal EOF )
            // InternalXtext.g:1027:1: ruleCrossReferenceableTerminal EOF
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
    // InternalXtext.g:1034:1: ruleCrossReferenceableTerminal : ( ( rule__CrossReferenceableTerminal__Alternatives ) ) ;
    public final void ruleCrossReferenceableTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1038:2: ( ( ( rule__CrossReferenceableTerminal__Alternatives ) ) )
            // InternalXtext.g:1039:2: ( ( rule__CrossReferenceableTerminal__Alternatives ) )
            {
            // InternalXtext.g:1039:2: ( ( rule__CrossReferenceableTerminal__Alternatives ) )
            // InternalXtext.g:1040:3: ( rule__CrossReferenceableTerminal__Alternatives )
            {
             before(grammarAccess.getCrossReferenceableTerminalAccess().getAlternatives()); 
            // InternalXtext.g:1041:3: ( rule__CrossReferenceableTerminal__Alternatives )
            // InternalXtext.g:1041:4: rule__CrossReferenceableTerminal__Alternatives
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
    // InternalXtext.g:1050:1: entryRuleParenthesizedElement : ruleParenthesizedElement EOF ;
    public final void entryRuleParenthesizedElement() throws RecognitionException {
        try {
            // InternalXtext.g:1051:1: ( ruleParenthesizedElement EOF )
            // InternalXtext.g:1052:1: ruleParenthesizedElement EOF
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
    // InternalXtext.g:1059:1: ruleParenthesizedElement : ( ( rule__ParenthesizedElement__Group__0 ) ) ;
    public final void ruleParenthesizedElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1063:2: ( ( ( rule__ParenthesizedElement__Group__0 ) ) )
            // InternalXtext.g:1064:2: ( ( rule__ParenthesizedElement__Group__0 ) )
            {
            // InternalXtext.g:1064:2: ( ( rule__ParenthesizedElement__Group__0 ) )
            // InternalXtext.g:1065:3: ( rule__ParenthesizedElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedElementAccess().getGroup()); 
            // InternalXtext.g:1066:3: ( rule__ParenthesizedElement__Group__0 )
            // InternalXtext.g:1066:4: rule__ParenthesizedElement__Group__0
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
    // InternalXtext.g:1075:1: entryRulePredicatedGroup : rulePredicatedGroup EOF ;
    public final void entryRulePredicatedGroup() throws RecognitionException {
        try {
            // InternalXtext.g:1076:1: ( rulePredicatedGroup EOF )
            // InternalXtext.g:1077:1: rulePredicatedGroup EOF
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
    // InternalXtext.g:1084:1: rulePredicatedGroup : ( ( rule__PredicatedGroup__Group__0 ) ) ;
    public final void rulePredicatedGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1088:2: ( ( ( rule__PredicatedGroup__Group__0 ) ) )
            // InternalXtext.g:1089:2: ( ( rule__PredicatedGroup__Group__0 ) )
            {
            // InternalXtext.g:1089:2: ( ( rule__PredicatedGroup__Group__0 ) )
            // InternalXtext.g:1090:3: ( rule__PredicatedGroup__Group__0 )
            {
             before(grammarAccess.getPredicatedGroupAccess().getGroup()); 
            // InternalXtext.g:1091:3: ( rule__PredicatedGroup__Group__0 )
            // InternalXtext.g:1091:4: rule__PredicatedGroup__Group__0
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
    // InternalXtext.g:1100:1: entryRuleTerminalRule : ruleTerminalRule EOF ;
    public final void entryRuleTerminalRule() throws RecognitionException {
        try {
            // InternalXtext.g:1101:1: ( ruleTerminalRule EOF )
            // InternalXtext.g:1102:1: ruleTerminalRule EOF
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
    // InternalXtext.g:1109:1: ruleTerminalRule : ( ( rule__TerminalRule__Group__0 ) ) ;
    public final void ruleTerminalRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1113:2: ( ( ( rule__TerminalRule__Group__0 ) ) )
            // InternalXtext.g:1114:2: ( ( rule__TerminalRule__Group__0 ) )
            {
            // InternalXtext.g:1114:2: ( ( rule__TerminalRule__Group__0 ) )
            // InternalXtext.g:1115:3: ( rule__TerminalRule__Group__0 )
            {
             before(grammarAccess.getTerminalRuleAccess().getGroup()); 
            // InternalXtext.g:1116:3: ( rule__TerminalRule__Group__0 )
            // InternalXtext.g:1116:4: rule__TerminalRule__Group__0
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
    // InternalXtext.g:1125:1: entryRuleTerminalAlternatives : ruleTerminalAlternatives EOF ;
    public final void entryRuleTerminalAlternatives() throws RecognitionException {
        try {
            // InternalXtext.g:1126:1: ( ruleTerminalAlternatives EOF )
            // InternalXtext.g:1127:1: ruleTerminalAlternatives EOF
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
    // InternalXtext.g:1134:1: ruleTerminalAlternatives : ( ( rule__TerminalAlternatives__Group__0 ) ) ;
    public final void ruleTerminalAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1138:2: ( ( ( rule__TerminalAlternatives__Group__0 ) ) )
            // InternalXtext.g:1139:2: ( ( rule__TerminalAlternatives__Group__0 ) )
            {
            // InternalXtext.g:1139:2: ( ( rule__TerminalAlternatives__Group__0 ) )
            // InternalXtext.g:1140:3: ( rule__TerminalAlternatives__Group__0 )
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup()); 
            // InternalXtext.g:1141:3: ( rule__TerminalAlternatives__Group__0 )
            // InternalXtext.g:1141:4: rule__TerminalAlternatives__Group__0
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
    // InternalXtext.g:1150:1: entryRuleTerminalGroup : ruleTerminalGroup EOF ;
    public final void entryRuleTerminalGroup() throws RecognitionException {
        try {
            // InternalXtext.g:1151:1: ( ruleTerminalGroup EOF )
            // InternalXtext.g:1152:1: ruleTerminalGroup EOF
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
    // InternalXtext.g:1159:1: ruleTerminalGroup : ( ( rule__TerminalGroup__Group__0 ) ) ;
    public final void ruleTerminalGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1163:2: ( ( ( rule__TerminalGroup__Group__0 ) ) )
            // InternalXtext.g:1164:2: ( ( rule__TerminalGroup__Group__0 ) )
            {
            // InternalXtext.g:1164:2: ( ( rule__TerminalGroup__Group__0 ) )
            // InternalXtext.g:1165:3: ( rule__TerminalGroup__Group__0 )
            {
             before(grammarAccess.getTerminalGroupAccess().getGroup()); 
            // InternalXtext.g:1166:3: ( rule__TerminalGroup__Group__0 )
            // InternalXtext.g:1166:4: rule__TerminalGroup__Group__0
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
    // InternalXtext.g:1175:1: entryRuleTerminalToken : ruleTerminalToken EOF ;
    public final void entryRuleTerminalToken() throws RecognitionException {
        try {
            // InternalXtext.g:1176:1: ( ruleTerminalToken EOF )
            // InternalXtext.g:1177:1: ruleTerminalToken EOF
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
    // InternalXtext.g:1184:1: ruleTerminalToken : ( ( rule__TerminalToken__Group__0 ) ) ;
    public final void ruleTerminalToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1188:2: ( ( ( rule__TerminalToken__Group__0 ) ) )
            // InternalXtext.g:1189:2: ( ( rule__TerminalToken__Group__0 ) )
            {
            // InternalXtext.g:1189:2: ( ( rule__TerminalToken__Group__0 ) )
            // InternalXtext.g:1190:3: ( rule__TerminalToken__Group__0 )
            {
             before(grammarAccess.getTerminalTokenAccess().getGroup()); 
            // InternalXtext.g:1191:3: ( rule__TerminalToken__Group__0 )
            // InternalXtext.g:1191:4: rule__TerminalToken__Group__0
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
    // InternalXtext.g:1200:1: entryRuleTerminalTokenElement : ruleTerminalTokenElement EOF ;
    public final void entryRuleTerminalTokenElement() throws RecognitionException {
        try {
            // InternalXtext.g:1201:1: ( ruleTerminalTokenElement EOF )
            // InternalXtext.g:1202:1: ruleTerminalTokenElement EOF
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
    // InternalXtext.g:1209:1: ruleTerminalTokenElement : ( ( rule__TerminalTokenElement__Alternatives ) ) ;
    public final void ruleTerminalTokenElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1213:2: ( ( ( rule__TerminalTokenElement__Alternatives ) ) )
            // InternalXtext.g:1214:2: ( ( rule__TerminalTokenElement__Alternatives ) )
            {
            // InternalXtext.g:1214:2: ( ( rule__TerminalTokenElement__Alternatives ) )
            // InternalXtext.g:1215:3: ( rule__TerminalTokenElement__Alternatives )
            {
             before(grammarAccess.getTerminalTokenElementAccess().getAlternatives()); 
            // InternalXtext.g:1216:3: ( rule__TerminalTokenElement__Alternatives )
            // InternalXtext.g:1216:4: rule__TerminalTokenElement__Alternatives
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
    // InternalXtext.g:1225:1: entryRuleParenthesizedTerminalElement : ruleParenthesizedTerminalElement EOF ;
    public final void entryRuleParenthesizedTerminalElement() throws RecognitionException {
        try {
            // InternalXtext.g:1226:1: ( ruleParenthesizedTerminalElement EOF )
            // InternalXtext.g:1227:1: ruleParenthesizedTerminalElement EOF
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
    // InternalXtext.g:1234:1: ruleParenthesizedTerminalElement : ( ( rule__ParenthesizedTerminalElement__Group__0 ) ) ;
    public final void ruleParenthesizedTerminalElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1238:2: ( ( ( rule__ParenthesizedTerminalElement__Group__0 ) ) )
            // InternalXtext.g:1239:2: ( ( rule__ParenthesizedTerminalElement__Group__0 ) )
            {
            // InternalXtext.g:1239:2: ( ( rule__ParenthesizedTerminalElement__Group__0 ) )
            // InternalXtext.g:1240:3: ( rule__ParenthesizedTerminalElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getGroup()); 
            // InternalXtext.g:1241:3: ( rule__ParenthesizedTerminalElement__Group__0 )
            // InternalXtext.g:1241:4: rule__ParenthesizedTerminalElement__Group__0
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
    // InternalXtext.g:1250:1: entryRuleAbstractNegatedToken : ruleAbstractNegatedToken EOF ;
    public final void entryRuleAbstractNegatedToken() throws RecognitionException {
        try {
            // InternalXtext.g:1251:1: ( ruleAbstractNegatedToken EOF )
            // InternalXtext.g:1252:1: ruleAbstractNegatedToken EOF
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
    // InternalXtext.g:1259:1: ruleAbstractNegatedToken : ( ( rule__AbstractNegatedToken__Alternatives ) ) ;
    public final void ruleAbstractNegatedToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1263:2: ( ( ( rule__AbstractNegatedToken__Alternatives ) ) )
            // InternalXtext.g:1264:2: ( ( rule__AbstractNegatedToken__Alternatives ) )
            {
            // InternalXtext.g:1264:2: ( ( rule__AbstractNegatedToken__Alternatives ) )
            // InternalXtext.g:1265:3: ( rule__AbstractNegatedToken__Alternatives )
            {
             before(grammarAccess.getAbstractNegatedTokenAccess().getAlternatives()); 
            // InternalXtext.g:1266:3: ( rule__AbstractNegatedToken__Alternatives )
            // InternalXtext.g:1266:4: rule__AbstractNegatedToken__Alternatives
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
    // InternalXtext.g:1275:1: entryRuleNegatedToken : ruleNegatedToken EOF ;
    public final void entryRuleNegatedToken() throws RecognitionException {
        try {
            // InternalXtext.g:1276:1: ( ruleNegatedToken EOF )
            // InternalXtext.g:1277:1: ruleNegatedToken EOF
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
    // InternalXtext.g:1284:1: ruleNegatedToken : ( ( rule__NegatedToken__Group__0 ) ) ;
    public final void ruleNegatedToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1288:2: ( ( ( rule__NegatedToken__Group__0 ) ) )
            // InternalXtext.g:1289:2: ( ( rule__NegatedToken__Group__0 ) )
            {
            // InternalXtext.g:1289:2: ( ( rule__NegatedToken__Group__0 ) )
            // InternalXtext.g:1290:3: ( rule__NegatedToken__Group__0 )
            {
             before(grammarAccess.getNegatedTokenAccess().getGroup()); 
            // InternalXtext.g:1291:3: ( rule__NegatedToken__Group__0 )
            // InternalXtext.g:1291:4: rule__NegatedToken__Group__0
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
    // InternalXtext.g:1300:1: entryRuleUntilToken : ruleUntilToken EOF ;
    public final void entryRuleUntilToken() throws RecognitionException {
        try {
            // InternalXtext.g:1301:1: ( ruleUntilToken EOF )
            // InternalXtext.g:1302:1: ruleUntilToken EOF
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
    // InternalXtext.g:1309:1: ruleUntilToken : ( ( rule__UntilToken__Group__0 ) ) ;
    public final void ruleUntilToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1313:2: ( ( ( rule__UntilToken__Group__0 ) ) )
            // InternalXtext.g:1314:2: ( ( rule__UntilToken__Group__0 ) )
            {
            // InternalXtext.g:1314:2: ( ( rule__UntilToken__Group__0 ) )
            // InternalXtext.g:1315:3: ( rule__UntilToken__Group__0 )
            {
             before(grammarAccess.getUntilTokenAccess().getGroup()); 
            // InternalXtext.g:1316:3: ( rule__UntilToken__Group__0 )
            // InternalXtext.g:1316:4: rule__UntilToken__Group__0
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
    // InternalXtext.g:1325:1: entryRuleWildcard : ruleWildcard EOF ;
    public final void entryRuleWildcard() throws RecognitionException {
        try {
            // InternalXtext.g:1326:1: ( ruleWildcard EOF )
            // InternalXtext.g:1327:1: ruleWildcard EOF
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
    // InternalXtext.g:1334:1: ruleWildcard : ( ( rule__Wildcard__Group__0 ) ) ;
    public final void ruleWildcard() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1338:2: ( ( ( rule__Wildcard__Group__0 ) ) )
            // InternalXtext.g:1339:2: ( ( rule__Wildcard__Group__0 ) )
            {
            // InternalXtext.g:1339:2: ( ( rule__Wildcard__Group__0 ) )
            // InternalXtext.g:1340:3: ( rule__Wildcard__Group__0 )
            {
             before(grammarAccess.getWildcardAccess().getGroup()); 
            // InternalXtext.g:1341:3: ( rule__Wildcard__Group__0 )
            // InternalXtext.g:1341:4: rule__Wildcard__Group__0
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
    // InternalXtext.g:1350:1: entryRuleEOF : ruleEOF EOF ;
    public final void entryRuleEOF() throws RecognitionException {
        try {
            // InternalXtext.g:1351:1: ( ruleEOF EOF )
            // InternalXtext.g:1352:1: ruleEOF EOF
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
    // InternalXtext.g:1359:1: ruleEOF : ( ( rule__EOF__Group__0 ) ) ;
    public final void ruleEOF() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1363:2: ( ( ( rule__EOF__Group__0 ) ) )
            // InternalXtext.g:1364:2: ( ( rule__EOF__Group__0 ) )
            {
            // InternalXtext.g:1364:2: ( ( rule__EOF__Group__0 ) )
            // InternalXtext.g:1365:3: ( rule__EOF__Group__0 )
            {
             before(grammarAccess.getEOFAccess().getGroup()); 
            // InternalXtext.g:1366:3: ( rule__EOF__Group__0 )
            // InternalXtext.g:1366:4: rule__EOF__Group__0
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
    // InternalXtext.g:1375:1: entryRuleCharacterRange : ruleCharacterRange EOF ;
    public final void entryRuleCharacterRange() throws RecognitionException {
        try {
            // InternalXtext.g:1376:1: ( ruleCharacterRange EOF )
            // InternalXtext.g:1377:1: ruleCharacterRange EOF
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
    // InternalXtext.g:1384:1: ruleCharacterRange : ( ( rule__CharacterRange__Group__0 ) ) ;
    public final void ruleCharacterRange() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1388:2: ( ( ( rule__CharacterRange__Group__0 ) ) )
            // InternalXtext.g:1389:2: ( ( rule__CharacterRange__Group__0 ) )
            {
            // InternalXtext.g:1389:2: ( ( rule__CharacterRange__Group__0 ) )
            // InternalXtext.g:1390:3: ( rule__CharacterRange__Group__0 )
            {
             before(grammarAccess.getCharacterRangeAccess().getGroup()); 
            // InternalXtext.g:1391:3: ( rule__CharacterRange__Group__0 )
            // InternalXtext.g:1391:4: rule__CharacterRange__Group__0
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
    // InternalXtext.g:1400:1: entryRuleEnumRule : ruleEnumRule EOF ;
    public final void entryRuleEnumRule() throws RecognitionException {
        try {
            // InternalXtext.g:1401:1: ( ruleEnumRule EOF )
            // InternalXtext.g:1402:1: ruleEnumRule EOF
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
    // InternalXtext.g:1409:1: ruleEnumRule : ( ( rule__EnumRule__Group__0 ) ) ;
    public final void ruleEnumRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1413:2: ( ( ( rule__EnumRule__Group__0 ) ) )
            // InternalXtext.g:1414:2: ( ( rule__EnumRule__Group__0 ) )
            {
            // InternalXtext.g:1414:2: ( ( rule__EnumRule__Group__0 ) )
            // InternalXtext.g:1415:3: ( rule__EnumRule__Group__0 )
            {
             before(grammarAccess.getEnumRuleAccess().getGroup()); 
            // InternalXtext.g:1416:3: ( rule__EnumRule__Group__0 )
            // InternalXtext.g:1416:4: rule__EnumRule__Group__0
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
    // InternalXtext.g:1425:1: entryRuleEnumLiterals : ruleEnumLiterals EOF ;
    public final void entryRuleEnumLiterals() throws RecognitionException {
        try {
            // InternalXtext.g:1426:1: ( ruleEnumLiterals EOF )
            // InternalXtext.g:1427:1: ruleEnumLiterals EOF
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
    // InternalXtext.g:1434:1: ruleEnumLiterals : ( ( rule__EnumLiterals__Group__0 ) ) ;
    public final void ruleEnumLiterals() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1438:2: ( ( ( rule__EnumLiterals__Group__0 ) ) )
            // InternalXtext.g:1439:2: ( ( rule__EnumLiterals__Group__0 ) )
            {
            // InternalXtext.g:1439:2: ( ( rule__EnumLiterals__Group__0 ) )
            // InternalXtext.g:1440:3: ( rule__EnumLiterals__Group__0 )
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup()); 
            // InternalXtext.g:1441:3: ( rule__EnumLiterals__Group__0 )
            // InternalXtext.g:1441:4: rule__EnumLiterals__Group__0
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
    // InternalXtext.g:1450:1: entryRuleEnumLiteralDeclaration : ruleEnumLiteralDeclaration EOF ;
    public final void entryRuleEnumLiteralDeclaration() throws RecognitionException {
        try {
            // InternalXtext.g:1451:1: ( ruleEnumLiteralDeclaration EOF )
            // InternalXtext.g:1452:1: ruleEnumLiteralDeclaration EOF
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
    // InternalXtext.g:1459:1: ruleEnumLiteralDeclaration : ( ( rule__EnumLiteralDeclaration__Group__0 ) ) ;
    public final void ruleEnumLiteralDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1463:2: ( ( ( rule__EnumLiteralDeclaration__Group__0 ) ) )
            // InternalXtext.g:1464:2: ( ( rule__EnumLiteralDeclaration__Group__0 ) )
            {
            // InternalXtext.g:1464:2: ( ( rule__EnumLiteralDeclaration__Group__0 ) )
            // InternalXtext.g:1465:3: ( rule__EnumLiteralDeclaration__Group__0 )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getGroup()); 
            // InternalXtext.g:1466:3: ( rule__EnumLiteralDeclaration__Group__0 )
            // InternalXtext.g:1466:4: rule__EnumLiteralDeclaration__Group__0
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
    // InternalXtext.g:1474:1: rule__AbstractRule__Alternatives : ( ( ruleParserRule ) | ( ruleTerminalRule ) | ( ruleEnumRule ) );
    public final void rule__AbstractRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1478:1: ( ( ruleParserRule ) | ( ruleTerminalRule ) | ( ruleEnumRule ) )
            int alt1=3;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // InternalXtext.g:1479:2: ( ruleParserRule )
                    {
                    // InternalXtext.g:1479:2: ( ruleParserRule )
                    // InternalXtext.g:1480:3: ruleParserRule
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
                    // InternalXtext.g:1485:2: ( ruleTerminalRule )
                    {
                    // InternalXtext.g:1485:2: ( ruleTerminalRule )
                    // InternalXtext.g:1486:3: ruleTerminalRule
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
                    // InternalXtext.g:1491:2: ( ruleEnumRule )
                    {
                    // InternalXtext.g:1491:2: ( ruleEnumRule )
                    // InternalXtext.g:1492:3: ruleEnumRule
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
    // InternalXtext.g:1501:1: rule__AbstractMetamodelDeclaration__Alternatives : ( ( ruleGeneratedMetamodel ) | ( ruleReferencedMetamodel ) );
    public final void rule__AbstractMetamodelDeclaration__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1505:1: ( ( ruleGeneratedMetamodel ) | ( ruleReferencedMetamodel ) )
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
                    // InternalXtext.g:1506:2: ( ruleGeneratedMetamodel )
                    {
                    // InternalXtext.g:1506:2: ( ruleGeneratedMetamodel )
                    // InternalXtext.g:1507:3: ruleGeneratedMetamodel
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
                    // InternalXtext.g:1512:2: ( ruleReferencedMetamodel )
                    {
                    // InternalXtext.g:1512:2: ( ruleReferencedMetamodel )
                    // InternalXtext.g:1513:3: ruleReferencedMetamodel
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


    // $ANTLR start "rule__ParserRule__Alternatives_1"
    // InternalXtext.g:1522:1: rule__ParserRule__Alternatives_1 : ( ( ( rule__ParserRule__Group_1_0__0 ) ) | ( ( rule__ParserRule__Group_1_1__0 ) ) );
    public final void rule__ParserRule__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1526:1: ( ( ( rule__ParserRule__Group_1_0__0 ) ) | ( ( rule__ParserRule__Group_1_1__0 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==49) ) {
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
                    // InternalXtext.g:1527:2: ( ( rule__ParserRule__Group_1_0__0 ) )
                    {
                    // InternalXtext.g:1527:2: ( ( rule__ParserRule__Group_1_0__0 ) )
                    // InternalXtext.g:1528:3: ( rule__ParserRule__Group_1_0__0 )
                    {
                     before(grammarAccess.getParserRuleAccess().getGroup_1_0()); 
                    // InternalXtext.g:1529:3: ( rule__ParserRule__Group_1_0__0 )
                    // InternalXtext.g:1529:4: rule__ParserRule__Group_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ParserRule__Group_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getParserRuleAccess().getGroup_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:1533:2: ( ( rule__ParserRule__Group_1_1__0 ) )
                    {
                    // InternalXtext.g:1533:2: ( ( rule__ParserRule__Group_1_1__0 ) )
                    // InternalXtext.g:1534:3: ( rule__ParserRule__Group_1_1__0 )
                    {
                     before(grammarAccess.getParserRuleAccess().getGroup_1_1()); 
                    // InternalXtext.g:1535:3: ( rule__ParserRule__Group_1_1__0 )
                    // InternalXtext.g:1535:4: rule__ParserRule__Group_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ParserRule__Group_1_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getParserRuleAccess().getGroup_1_1()); 

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
    // $ANTLR end "rule__ParserRule__Alternatives_1"


    // $ANTLR start "rule__ParserRule__Alternatives_1_0_2"
    // InternalXtext.g:1543:1: rule__ParserRule__Alternatives_1_0_2 : ( ( ( rule__ParserRule__WildcardAssignment_1_0_2_0 ) ) | ( ( rule__ParserRule__Group_1_0_2_1__0 )? ) );
    public final void rule__ParserRule__Alternatives_1_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1547:1: ( ( ( rule__ParserRule__WildcardAssignment_1_0_2_0 ) ) | ( ( rule__ParserRule__Group_1_0_2_1__0 )? ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==12) ) {
                alt5=1;
            }
            else if ( (LA5_0==29||LA5_0==31||LA5_0==48) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalXtext.g:1548:2: ( ( rule__ParserRule__WildcardAssignment_1_0_2_0 ) )
                    {
                    // InternalXtext.g:1548:2: ( ( rule__ParserRule__WildcardAssignment_1_0_2_0 ) )
                    // InternalXtext.g:1549:3: ( rule__ParserRule__WildcardAssignment_1_0_2_0 )
                    {
                     before(grammarAccess.getParserRuleAccess().getWildcardAssignment_1_0_2_0()); 
                    // InternalXtext.g:1550:3: ( rule__ParserRule__WildcardAssignment_1_0_2_0 )
                    // InternalXtext.g:1550:4: rule__ParserRule__WildcardAssignment_1_0_2_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ParserRule__WildcardAssignment_1_0_2_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getParserRuleAccess().getWildcardAssignment_1_0_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:1554:2: ( ( rule__ParserRule__Group_1_0_2_1__0 )? )
                    {
                    // InternalXtext.g:1554:2: ( ( rule__ParserRule__Group_1_0_2_1__0 )? )
                    // InternalXtext.g:1555:3: ( rule__ParserRule__Group_1_0_2_1__0 )?
                    {
                     before(grammarAccess.getParserRuleAccess().getGroup_1_0_2_1()); 
                    // InternalXtext.g:1556:3: ( rule__ParserRule__Group_1_0_2_1__0 )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==31) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // InternalXtext.g:1556:4: rule__ParserRule__Group_1_0_2_1__0
                            {
                            pushFollow(FollowSets000.FOLLOW_2);
                            rule__ParserRule__Group_1_0_2_1__0();

                            state._fsp--;


                            }
                            break;

                    }

                     after(grammarAccess.getParserRuleAccess().getGroup_1_0_2_1()); 

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
    // $ANTLR end "rule__ParserRule__Alternatives_1_0_2"


    // $ANTLR start "rule__ConditionalBranch__Alternatives"
    // InternalXtext.g:1564:1: rule__ConditionalBranch__Alternatives : ( ( ruleUnorderedGroup ) | ( ( rule__ConditionalBranch__Group_1__0 ) ) );
    public final void rule__ConditionalBranch__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1568:1: ( ( ruleUnorderedGroup ) | ( ( rule__ConditionalBranch__Group_1__0 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=RULE_ID && LA6_0<=RULE_STRING)||(LA6_0>=16 && LA6_0<=17)||LA6_0==22||LA6_0==37||LA6_0==44||LA6_0==50) ) {
                alt6=1;
            }
            else if ( (LA6_0==32) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalXtext.g:1569:2: ( ruleUnorderedGroup )
                    {
                    // InternalXtext.g:1569:2: ( ruleUnorderedGroup )
                    // InternalXtext.g:1570:3: ruleUnorderedGroup
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
                    // InternalXtext.g:1575:2: ( ( rule__ConditionalBranch__Group_1__0 ) )
                    {
                    // InternalXtext.g:1575:2: ( ( rule__ConditionalBranch__Group_1__0 ) )
                    // InternalXtext.g:1576:3: ( rule__ConditionalBranch__Group_1__0 )
                    {
                     before(grammarAccess.getConditionalBranchAccess().getGroup_1()); 
                    // InternalXtext.g:1577:3: ( rule__ConditionalBranch__Group_1__0 )
                    // InternalXtext.g:1577:4: rule__ConditionalBranch__Group_1__0
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
    // InternalXtext.g:1585:1: rule__AbstractToken__Alternatives : ( ( ruleAbstractTokenWithCardinality ) | ( ruleAction ) );
    public final void rule__AbstractToken__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1589:1: ( ( ruleAbstractTokenWithCardinality ) | ( ruleAction ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=RULE_ID && LA7_0<=RULE_STRING)||(LA7_0>=16 && LA7_0<=17)||LA7_0==22||LA7_0==44||LA7_0==50) ) {
                alt7=1;
            }
            else if ( (LA7_0==37) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalXtext.g:1590:2: ( ruleAbstractTokenWithCardinality )
                    {
                    // InternalXtext.g:1590:2: ( ruleAbstractTokenWithCardinality )
                    // InternalXtext.g:1591:3: ruleAbstractTokenWithCardinality
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
                    // InternalXtext.g:1596:2: ( ruleAction )
                    {
                    // InternalXtext.g:1596:2: ( ruleAction )
                    // InternalXtext.g:1597:3: ruleAction
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
    // InternalXtext.g:1606:1: rule__AbstractTokenWithCardinality__Alternatives_0 : ( ( ruleAssignment ) | ( ruleAbstractTerminal ) );
    public final void rule__AbstractTokenWithCardinality__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1610:1: ( ( ruleAssignment ) | ( ruleAbstractTerminal ) )
            int alt8=2;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // InternalXtext.g:1611:2: ( ruleAssignment )
                    {
                    // InternalXtext.g:1611:2: ( ruleAssignment )
                    // InternalXtext.g:1612:3: ruleAssignment
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
                    // InternalXtext.g:1617:2: ( ruleAbstractTerminal )
                    {
                    // InternalXtext.g:1617:2: ( ruleAbstractTerminal )
                    // InternalXtext.g:1618:3: ruleAbstractTerminal
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
    // InternalXtext.g:1627:1: rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 : ( ( '?' ) | ( '*' ) | ( '+' ) );
    public final void rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1631:1: ( ( '?' ) | ( '*' ) | ( '+' ) )
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
                    // InternalXtext.g:1632:2: ( '?' )
                    {
                    // InternalXtext.g:1632:2: ( '?' )
                    // InternalXtext.g:1633:3: '?'
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:1638:2: ( '*' )
                    {
                    // InternalXtext.g:1638:2: ( '*' )
                    // InternalXtext.g:1639:3: '*'
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAsteriskKeyword_1_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAsteriskKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtext.g:1644:2: ( '+' )
                    {
                    // InternalXtext.g:1644:2: ( '+' )
                    // InternalXtext.g:1645:3: '+'
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
    // InternalXtext.g:1654:1: rule__Action__OperatorAlternatives_2_2_0 : ( ( '=' ) | ( '+=' ) );
    public final void rule__Action__OperatorAlternatives_2_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1658:1: ( ( '=' ) | ( '+=' ) )
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
                    // InternalXtext.g:1659:2: ( '=' )
                    {
                    // InternalXtext.g:1659:2: ( '=' )
                    // InternalXtext.g:1660:3: '='
                    {
                     before(grammarAccess.getActionAccess().getOperatorEqualsSignKeyword_2_2_0_0()); 
                    match(input,14,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getActionAccess().getOperatorEqualsSignKeyword_2_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:1665:2: ( '+=' )
                    {
                    // InternalXtext.g:1665:2: ( '+=' )
                    // InternalXtext.g:1666:3: '+='
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
    // InternalXtext.g:1675:1: rule__AbstractTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedElement ) | ( rulePredicatedKeyword ) | ( rulePredicatedRuleCall ) | ( rulePredicatedGroup ) );
    public final void rule__AbstractTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1679:1: ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedElement ) | ( rulePredicatedKeyword ) | ( rulePredicatedRuleCall ) | ( rulePredicatedGroup ) )
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
            case 50:
                {
                switch ( input.LA(2) ) {
                case RULE_STRING:
                    {
                    alt11=4;
                    }
                    break;
                case 22:
                    {
                    alt11=6;
                    }
                    break;
                case RULE_ID:
                case 16:
                case 17:
                    {
                    alt11=5;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 4, input);

                    throw nvae;
                }

                }
                break;
            case 44:
                {
                switch ( input.LA(2) ) {
                case RULE_STRING:
                    {
                    alt11=4;
                    }
                    break;
                case 22:
                    {
                    alt11=6;
                    }
                    break;
                case RULE_ID:
                case 16:
                case 17:
                    {
                    alt11=5;
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
                    // InternalXtext.g:1680:2: ( ruleKeyword )
                    {
                    // InternalXtext.g:1680:2: ( ruleKeyword )
                    // InternalXtext.g:1681:3: ruleKeyword
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
                    // InternalXtext.g:1686:2: ( ruleRuleCall )
                    {
                    // InternalXtext.g:1686:2: ( ruleRuleCall )
                    // InternalXtext.g:1687:3: ruleRuleCall
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
                    // InternalXtext.g:1692:2: ( ruleParenthesizedElement )
                    {
                    // InternalXtext.g:1692:2: ( ruleParenthesizedElement )
                    // InternalXtext.g:1693:3: ruleParenthesizedElement
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
                    // InternalXtext.g:1698:2: ( rulePredicatedKeyword )
                    {
                    // InternalXtext.g:1698:2: ( rulePredicatedKeyword )
                    // InternalXtext.g:1699:3: rulePredicatedKeyword
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
                    // InternalXtext.g:1704:2: ( rulePredicatedRuleCall )
                    {
                    // InternalXtext.g:1704:2: ( rulePredicatedRuleCall )
                    // InternalXtext.g:1705:3: rulePredicatedRuleCall
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
                    // InternalXtext.g:1710:2: ( rulePredicatedGroup )
                    {
                    // InternalXtext.g:1710:2: ( rulePredicatedGroup )
                    // InternalXtext.g:1711:3: rulePredicatedGroup
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
    // InternalXtext.g:1720:1: rule__LiteralCondition__Alternatives_1 : ( ( ( rule__LiteralCondition__TrueAssignment_1_0 ) ) | ( 'false' ) );
    public final void rule__LiteralCondition__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1724:1: ( ( ( rule__LiteralCondition__TrueAssignment_1_0 ) ) | ( 'false' ) )
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
                    // InternalXtext.g:1725:2: ( ( rule__LiteralCondition__TrueAssignment_1_0 ) )
                    {
                    // InternalXtext.g:1725:2: ( ( rule__LiteralCondition__TrueAssignment_1_0 ) )
                    // InternalXtext.g:1726:3: ( rule__LiteralCondition__TrueAssignment_1_0 )
                    {
                     before(grammarAccess.getLiteralConditionAccess().getTrueAssignment_1_0()); 
                    // InternalXtext.g:1727:3: ( rule__LiteralCondition__TrueAssignment_1_0 )
                    // InternalXtext.g:1727:4: rule__LiteralCondition__TrueAssignment_1_0
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
                    // InternalXtext.g:1731:2: ( 'false' )
                    {
                    // InternalXtext.g:1731:2: ( 'false' )
                    // InternalXtext.g:1732:3: 'false'
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
    // InternalXtext.g:1741:1: rule__Negation__Alternatives : ( ( ruleAtom ) | ( ( rule__Negation__Group_1__0 ) ) );
    public final void rule__Negation__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1745:1: ( ( ruleAtom ) | ( ( rule__Negation__Group_1__0 ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID||(LA13_0>=16 && LA13_0<=17)||LA13_0==22) ) {
                alt13=1;
            }
            else if ( (LA13_0==40) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalXtext.g:1746:2: ( ruleAtom )
                    {
                    // InternalXtext.g:1746:2: ( ruleAtom )
                    // InternalXtext.g:1747:3: ruleAtom
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
                    // InternalXtext.g:1752:2: ( ( rule__Negation__Group_1__0 ) )
                    {
                    // InternalXtext.g:1752:2: ( ( rule__Negation__Group_1__0 ) )
                    // InternalXtext.g:1753:3: ( rule__Negation__Group_1__0 )
                    {
                     before(grammarAccess.getNegationAccess().getGroup_1()); 
                    // InternalXtext.g:1754:3: ( rule__Negation__Group_1__0 )
                    // InternalXtext.g:1754:4: rule__Negation__Group_1__0
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
    // InternalXtext.g:1762:1: rule__Atom__Alternatives : ( ( ruleParameterReference ) | ( ruleParenthesizedCondition ) | ( ruleLiteralCondition ) );
    public final void rule__Atom__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1766:1: ( ( ruleParameterReference ) | ( ruleParenthesizedCondition ) | ( ruleLiteralCondition ) )
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
                    // InternalXtext.g:1767:2: ( ruleParameterReference )
                    {
                    // InternalXtext.g:1767:2: ( ruleParameterReference )
                    // InternalXtext.g:1768:3: ruleParameterReference
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
                    // InternalXtext.g:1773:2: ( ruleParenthesizedCondition )
                    {
                    // InternalXtext.g:1773:2: ( ruleParenthesizedCondition )
                    // InternalXtext.g:1774:3: ruleParenthesizedCondition
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
                    // InternalXtext.g:1779:2: ( ruleLiteralCondition )
                    {
                    // InternalXtext.g:1779:2: ( ruleLiteralCondition )
                    // InternalXtext.g:1780:3: ruleLiteralCondition
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
    // InternalXtext.g:1789:1: rule__ValidID__Alternatives : ( ( RULE_ID ) | ( 'true' ) | ( 'false' ) );
    public final void rule__ValidID__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1793:1: ( ( RULE_ID ) | ( 'true' ) | ( 'false' ) )
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
                    // InternalXtext.g:1794:2: ( RULE_ID )
                    {
                    // InternalXtext.g:1794:2: ( RULE_ID )
                    // InternalXtext.g:1795:3: RULE_ID
                    {
                     before(grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0()); 
                    match(input,RULE_ID,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:1800:2: ( 'true' )
                    {
                    // InternalXtext.g:1800:2: ( 'true' )
                    // InternalXtext.g:1801:3: 'true'
                    {
                     before(grammarAccess.getValidIDAccess().getTrueKeyword_1()); 
                    match(input,17,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getValidIDAccess().getTrueKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtext.g:1806:2: ( 'false' )
                    {
                    // InternalXtext.g:1806:2: ( 'false' )
                    // InternalXtext.g:1807:3: 'false'
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
    // InternalXtext.g:1816:1: rule__PredicatedKeyword__Alternatives_0 : ( ( ( rule__PredicatedKeyword__PredicatedAssignment_0_0 ) ) | ( ( rule__PredicatedKeyword__FirstSetPredicatedAssignment_0_1 ) ) );
    public final void rule__PredicatedKeyword__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1820:1: ( ( ( rule__PredicatedKeyword__PredicatedAssignment_0_0 ) ) | ( ( rule__PredicatedKeyword__FirstSetPredicatedAssignment_0_1 ) ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==50) ) {
                alt16=1;
            }
            else if ( (LA16_0==44) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalXtext.g:1821:2: ( ( rule__PredicatedKeyword__PredicatedAssignment_0_0 ) )
                    {
                    // InternalXtext.g:1821:2: ( ( rule__PredicatedKeyword__PredicatedAssignment_0_0 ) )
                    // InternalXtext.g:1822:3: ( rule__PredicatedKeyword__PredicatedAssignment_0_0 )
                    {
                     before(grammarAccess.getPredicatedKeywordAccess().getPredicatedAssignment_0_0()); 
                    // InternalXtext.g:1823:3: ( rule__PredicatedKeyword__PredicatedAssignment_0_0 )
                    // InternalXtext.g:1823:4: rule__PredicatedKeyword__PredicatedAssignment_0_0
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
                    // InternalXtext.g:1827:2: ( ( rule__PredicatedKeyword__FirstSetPredicatedAssignment_0_1 ) )
                    {
                    // InternalXtext.g:1827:2: ( ( rule__PredicatedKeyword__FirstSetPredicatedAssignment_0_1 ) )
                    // InternalXtext.g:1828:3: ( rule__PredicatedKeyword__FirstSetPredicatedAssignment_0_1 )
                    {
                     before(grammarAccess.getPredicatedKeywordAccess().getFirstSetPredicatedAssignment_0_1()); 
                    // InternalXtext.g:1829:3: ( rule__PredicatedKeyword__FirstSetPredicatedAssignment_0_1 )
                    // InternalXtext.g:1829:4: rule__PredicatedKeyword__FirstSetPredicatedAssignment_0_1
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
    // InternalXtext.g:1837:1: rule__PredicatedRuleCall__Alternatives_0 : ( ( ( rule__PredicatedRuleCall__PredicatedAssignment_0_0 ) ) | ( ( rule__PredicatedRuleCall__FirstSetPredicatedAssignment_0_1 ) ) );
    public final void rule__PredicatedRuleCall__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1841:1: ( ( ( rule__PredicatedRuleCall__PredicatedAssignment_0_0 ) ) | ( ( rule__PredicatedRuleCall__FirstSetPredicatedAssignment_0_1 ) ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==50) ) {
                alt17=1;
            }
            else if ( (LA17_0==44) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalXtext.g:1842:2: ( ( rule__PredicatedRuleCall__PredicatedAssignment_0_0 ) )
                    {
                    // InternalXtext.g:1842:2: ( ( rule__PredicatedRuleCall__PredicatedAssignment_0_0 ) )
                    // InternalXtext.g:1843:3: ( rule__PredicatedRuleCall__PredicatedAssignment_0_0 )
                    {
                     before(grammarAccess.getPredicatedRuleCallAccess().getPredicatedAssignment_0_0()); 
                    // InternalXtext.g:1844:3: ( rule__PredicatedRuleCall__PredicatedAssignment_0_0 )
                    // InternalXtext.g:1844:4: rule__PredicatedRuleCall__PredicatedAssignment_0_0
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
                    // InternalXtext.g:1848:2: ( ( rule__PredicatedRuleCall__FirstSetPredicatedAssignment_0_1 ) )
                    {
                    // InternalXtext.g:1848:2: ( ( rule__PredicatedRuleCall__FirstSetPredicatedAssignment_0_1 ) )
                    // InternalXtext.g:1849:3: ( rule__PredicatedRuleCall__FirstSetPredicatedAssignment_0_1 )
                    {
                     before(grammarAccess.getPredicatedRuleCallAccess().getFirstSetPredicatedAssignment_0_1()); 
                    // InternalXtext.g:1850:3: ( rule__PredicatedRuleCall__FirstSetPredicatedAssignment_0_1 )
                    // InternalXtext.g:1850:4: rule__PredicatedRuleCall__FirstSetPredicatedAssignment_0_1
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
    // InternalXtext.g:1858:1: rule__Assignment__Alternatives_0 : ( ( ( rule__Assignment__PredicatedAssignment_0_0 ) ) | ( ( rule__Assignment__FirstSetPredicatedAssignment_0_1 ) ) );
    public final void rule__Assignment__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1862:1: ( ( ( rule__Assignment__PredicatedAssignment_0_0 ) ) | ( ( rule__Assignment__FirstSetPredicatedAssignment_0_1 ) ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==50) ) {
                alt18=1;
            }
            else if ( (LA18_0==44) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalXtext.g:1863:2: ( ( rule__Assignment__PredicatedAssignment_0_0 ) )
                    {
                    // InternalXtext.g:1863:2: ( ( rule__Assignment__PredicatedAssignment_0_0 ) )
                    // InternalXtext.g:1864:3: ( rule__Assignment__PredicatedAssignment_0_0 )
                    {
                     before(grammarAccess.getAssignmentAccess().getPredicatedAssignment_0_0()); 
                    // InternalXtext.g:1865:3: ( rule__Assignment__PredicatedAssignment_0_0 )
                    // InternalXtext.g:1865:4: rule__Assignment__PredicatedAssignment_0_0
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
                    // InternalXtext.g:1869:2: ( ( rule__Assignment__FirstSetPredicatedAssignment_0_1 ) )
                    {
                    // InternalXtext.g:1869:2: ( ( rule__Assignment__FirstSetPredicatedAssignment_0_1 ) )
                    // InternalXtext.g:1870:3: ( rule__Assignment__FirstSetPredicatedAssignment_0_1 )
                    {
                     before(grammarAccess.getAssignmentAccess().getFirstSetPredicatedAssignment_0_1()); 
                    // InternalXtext.g:1871:3: ( rule__Assignment__FirstSetPredicatedAssignment_0_1 )
                    // InternalXtext.g:1871:4: rule__Assignment__FirstSetPredicatedAssignment_0_1
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
    // InternalXtext.g:1879:1: rule__Assignment__OperatorAlternatives_2_0 : ( ( '+=' ) | ( '=' ) | ( '?=' ) );
    public final void rule__Assignment__OperatorAlternatives_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1883:1: ( ( '+=' ) | ( '=' ) | ( '?=' ) )
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
                    // InternalXtext.g:1884:2: ( '+=' )
                    {
                    // InternalXtext.g:1884:2: ( '+=' )
                    // InternalXtext.g:1885:3: '+='
                    {
                     before(grammarAccess.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_2_0_0()); 
                    match(input,15,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:1890:2: ( '=' )
                    {
                    // InternalXtext.g:1890:2: ( '=' )
                    // InternalXtext.g:1891:3: '='
                    {
                     before(grammarAccess.getAssignmentAccess().getOperatorEqualsSignKeyword_2_0_1()); 
                    match(input,14,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getAssignmentAccess().getOperatorEqualsSignKeyword_2_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtext.g:1896:2: ( '?=' )
                    {
                    // InternalXtext.g:1896:2: ( '?=' )
                    // InternalXtext.g:1897:3: '?='
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
    // InternalXtext.g:1906:1: rule__AssignableTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedAssignableElement ) | ( ruleCrossReference ) );
    public final void rule__AssignableTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1910:1: ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedAssignableElement ) | ( ruleCrossReference ) )
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
            case 41:
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
                    // InternalXtext.g:1911:2: ( ruleKeyword )
                    {
                    // InternalXtext.g:1911:2: ( ruleKeyword )
                    // InternalXtext.g:1912:3: ruleKeyword
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
                    // InternalXtext.g:1917:2: ( ruleRuleCall )
                    {
                    // InternalXtext.g:1917:2: ( ruleRuleCall )
                    // InternalXtext.g:1918:3: ruleRuleCall
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
                    // InternalXtext.g:1923:2: ( ruleParenthesizedAssignableElement )
                    {
                    // InternalXtext.g:1923:2: ( ruleParenthesizedAssignableElement )
                    // InternalXtext.g:1924:3: ruleParenthesizedAssignableElement
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
                    // InternalXtext.g:1929:2: ( ruleCrossReference )
                    {
                    // InternalXtext.g:1929:2: ( ruleCrossReference )
                    // InternalXtext.g:1930:3: ruleCrossReference
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
    // InternalXtext.g:1939:1: rule__CrossReferenceableTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) );
    public final void rule__CrossReferenceableTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1943:1: ( ( ruleKeyword ) | ( ruleRuleCall ) )
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
                    // InternalXtext.g:1944:2: ( ruleKeyword )
                    {
                    // InternalXtext.g:1944:2: ( ruleKeyword )
                    // InternalXtext.g:1945:3: ruleKeyword
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
                    // InternalXtext.g:1950:2: ( ruleRuleCall )
                    {
                    // InternalXtext.g:1950:2: ( ruleRuleCall )
                    // InternalXtext.g:1951:3: ruleRuleCall
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
    // InternalXtext.g:1960:1: rule__PredicatedGroup__Alternatives_0 : ( ( ( rule__PredicatedGroup__PredicatedAssignment_0_0 ) ) | ( ( rule__PredicatedGroup__FirstSetPredicatedAssignment_0_1 ) ) );
    public final void rule__PredicatedGroup__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1964:1: ( ( ( rule__PredicatedGroup__PredicatedAssignment_0_0 ) ) | ( ( rule__PredicatedGroup__FirstSetPredicatedAssignment_0_1 ) ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==50) ) {
                alt22=1;
            }
            else if ( (LA22_0==44) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalXtext.g:1965:2: ( ( rule__PredicatedGroup__PredicatedAssignment_0_0 ) )
                    {
                    // InternalXtext.g:1965:2: ( ( rule__PredicatedGroup__PredicatedAssignment_0_0 ) )
                    // InternalXtext.g:1966:3: ( rule__PredicatedGroup__PredicatedAssignment_0_0 )
                    {
                     before(grammarAccess.getPredicatedGroupAccess().getPredicatedAssignment_0_0()); 
                    // InternalXtext.g:1967:3: ( rule__PredicatedGroup__PredicatedAssignment_0_0 )
                    // InternalXtext.g:1967:4: rule__PredicatedGroup__PredicatedAssignment_0_0
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
                    // InternalXtext.g:1971:2: ( ( rule__PredicatedGroup__FirstSetPredicatedAssignment_0_1 ) )
                    {
                    // InternalXtext.g:1971:2: ( ( rule__PredicatedGroup__FirstSetPredicatedAssignment_0_1 ) )
                    // InternalXtext.g:1972:3: ( rule__PredicatedGroup__FirstSetPredicatedAssignment_0_1 )
                    {
                     before(grammarAccess.getPredicatedGroupAccess().getFirstSetPredicatedAssignment_0_1()); 
                    // InternalXtext.g:1973:3: ( rule__PredicatedGroup__FirstSetPredicatedAssignment_0_1 )
                    // InternalXtext.g:1973:4: rule__PredicatedGroup__FirstSetPredicatedAssignment_0_1
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


    // $ANTLR start "rule__TerminalRule__Alternatives_2"
    // InternalXtext.g:1981:1: rule__TerminalRule__Alternatives_2 : ( ( ( rule__TerminalRule__Group_2_0__0 ) ) | ( ( rule__TerminalRule__Group_2_1__0 ) ) );
    public final void rule__TerminalRule__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1985:1: ( ( ( rule__TerminalRule__Group_2_0__0 ) ) | ( ( rule__TerminalRule__Group_2_1__0 ) ) )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==49) ) {
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
                    // InternalXtext.g:1986:2: ( ( rule__TerminalRule__Group_2_0__0 ) )
                    {
                    // InternalXtext.g:1986:2: ( ( rule__TerminalRule__Group_2_0__0 ) )
                    // InternalXtext.g:1987:3: ( rule__TerminalRule__Group_2_0__0 )
                    {
                     before(grammarAccess.getTerminalRuleAccess().getGroup_2_0()); 
                    // InternalXtext.g:1988:3: ( rule__TerminalRule__Group_2_0__0 )
                    // InternalXtext.g:1988:4: rule__TerminalRule__Group_2_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__TerminalRule__Group_2_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTerminalRuleAccess().getGroup_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:1992:2: ( ( rule__TerminalRule__Group_2_1__0 ) )
                    {
                    // InternalXtext.g:1992:2: ( ( rule__TerminalRule__Group_2_1__0 ) )
                    // InternalXtext.g:1993:3: ( rule__TerminalRule__Group_2_1__0 )
                    {
                     before(grammarAccess.getTerminalRuleAccess().getGroup_2_1()); 
                    // InternalXtext.g:1994:3: ( rule__TerminalRule__Group_2_1__0 )
                    // InternalXtext.g:1994:4: rule__TerminalRule__Group_2_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__TerminalRule__Group_2_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTerminalRuleAccess().getGroup_2_1()); 

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
    // $ANTLR end "rule__TerminalRule__Alternatives_2"


    // $ANTLR start "rule__TerminalToken__CardinalityAlternatives_1_0"
    // InternalXtext.g:2002:1: rule__TerminalToken__CardinalityAlternatives_1_0 : ( ( '?' ) | ( '*' ) | ( '+' ) );
    public final void rule__TerminalToken__CardinalityAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2006:1: ( ( '?' ) | ( '*' ) | ( '+' ) )
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
                    // InternalXtext.g:2007:2: ( '?' )
                    {
                    // InternalXtext.g:2007:2: ( '?' )
                    // InternalXtext.g:2008:3: '?'
                    {
                     before(grammarAccess.getTerminalTokenAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getTerminalTokenAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:2013:2: ( '*' )
                    {
                    // InternalXtext.g:2013:2: ( '*' )
                    // InternalXtext.g:2014:3: '*'
                    {
                     before(grammarAccess.getTerminalTokenAccess().getCardinalityAsteriskKeyword_1_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getTerminalTokenAccess().getCardinalityAsteriskKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtext.g:2019:2: ( '+' )
                    {
                    // InternalXtext.g:2019:2: ( '+' )
                    // InternalXtext.g:2020:3: '+'
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
    // InternalXtext.g:2029:1: rule__TerminalTokenElement__Alternatives : ( ( ruleCharacterRange ) | ( ruleTerminalRuleCall ) | ( ruleParenthesizedTerminalElement ) | ( ruleAbstractNegatedToken ) | ( ruleWildcard ) | ( ruleEOF ) );
    public final void rule__TerminalTokenElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2033:1: ( ( ruleCharacterRange ) | ( ruleTerminalRuleCall ) | ( ruleParenthesizedTerminalElement ) | ( ruleAbstractNegatedToken ) | ( ruleWildcard ) | ( ruleEOF ) )
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
            case 40:
            case 44:
                {
                alt25=4;
                }
                break;
            case 24:
                {
                alt25=5;
                }
                break;
            case 45:
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
                    // InternalXtext.g:2034:2: ( ruleCharacterRange )
                    {
                    // InternalXtext.g:2034:2: ( ruleCharacterRange )
                    // InternalXtext.g:2035:3: ruleCharacterRange
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
                    // InternalXtext.g:2040:2: ( ruleTerminalRuleCall )
                    {
                    // InternalXtext.g:2040:2: ( ruleTerminalRuleCall )
                    // InternalXtext.g:2041:3: ruleTerminalRuleCall
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
                    // InternalXtext.g:2046:2: ( ruleParenthesizedTerminalElement )
                    {
                    // InternalXtext.g:2046:2: ( ruleParenthesizedTerminalElement )
                    // InternalXtext.g:2047:3: ruleParenthesizedTerminalElement
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
                    // InternalXtext.g:2052:2: ( ruleAbstractNegatedToken )
                    {
                    // InternalXtext.g:2052:2: ( ruleAbstractNegatedToken )
                    // InternalXtext.g:2053:3: ruleAbstractNegatedToken
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
                    // InternalXtext.g:2058:2: ( ruleWildcard )
                    {
                    // InternalXtext.g:2058:2: ( ruleWildcard )
                    // InternalXtext.g:2059:3: ruleWildcard
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
                    // InternalXtext.g:2064:2: ( ruleEOF )
                    {
                    // InternalXtext.g:2064:2: ( ruleEOF )
                    // InternalXtext.g:2065:3: ruleEOF
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
    // InternalXtext.g:2074:1: rule__AbstractNegatedToken__Alternatives : ( ( ruleNegatedToken ) | ( ruleUntilToken ) );
    public final void rule__AbstractNegatedToken__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2078:1: ( ( ruleNegatedToken ) | ( ruleUntilToken ) )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==40) ) {
                alt26=1;
            }
            else if ( (LA26_0==44) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // InternalXtext.g:2079:2: ( ruleNegatedToken )
                    {
                    // InternalXtext.g:2079:2: ( ruleNegatedToken )
                    // InternalXtext.g:2080:3: ruleNegatedToken
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
                    // InternalXtext.g:2085:2: ( ruleUntilToken )
                    {
                    // InternalXtext.g:2085:2: ( ruleUntilToken )
                    // InternalXtext.g:2086:3: ruleUntilToken
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
    // InternalXtext.g:2095:1: rule__Grammar__Group__0 : rule__Grammar__Group__0__Impl rule__Grammar__Group__1 ;
    public final void rule__Grammar__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2099:1: ( rule__Grammar__Group__0__Impl rule__Grammar__Group__1 )
            // InternalXtext.g:2100:2: rule__Grammar__Group__0__Impl rule__Grammar__Group__1
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
    // InternalXtext.g:2107:1: rule__Grammar__Group__0__Impl : ( 'grammar' ) ;
    public final void rule__Grammar__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2111:1: ( ( 'grammar' ) )
            // InternalXtext.g:2112:1: ( 'grammar' )
            {
            // InternalXtext.g:2112:1: ( 'grammar' )
            // InternalXtext.g:2113:2: 'grammar'
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
    // InternalXtext.g:2122:1: rule__Grammar__Group__1 : rule__Grammar__Group__1__Impl rule__Grammar__Group__2 ;
    public final void rule__Grammar__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2126:1: ( rule__Grammar__Group__1__Impl rule__Grammar__Group__2 )
            // InternalXtext.g:2127:2: rule__Grammar__Group__1__Impl rule__Grammar__Group__2
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
    // InternalXtext.g:2134:1: rule__Grammar__Group__1__Impl : ( ( rule__Grammar__NameAssignment_1 ) ) ;
    public final void rule__Grammar__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2138:1: ( ( ( rule__Grammar__NameAssignment_1 ) ) )
            // InternalXtext.g:2139:1: ( ( rule__Grammar__NameAssignment_1 ) )
            {
            // InternalXtext.g:2139:1: ( ( rule__Grammar__NameAssignment_1 ) )
            // InternalXtext.g:2140:2: ( rule__Grammar__NameAssignment_1 )
            {
             before(grammarAccess.getGrammarAccess().getNameAssignment_1()); 
            // InternalXtext.g:2141:2: ( rule__Grammar__NameAssignment_1 )
            // InternalXtext.g:2141:3: rule__Grammar__NameAssignment_1
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
    // InternalXtext.g:2149:1: rule__Grammar__Group__2 : rule__Grammar__Group__2__Impl rule__Grammar__Group__3 ;
    public final void rule__Grammar__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2153:1: ( rule__Grammar__Group__2__Impl rule__Grammar__Group__3 )
            // InternalXtext.g:2154:2: rule__Grammar__Group__2__Impl rule__Grammar__Group__3
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
    // InternalXtext.g:2161:1: rule__Grammar__Group__2__Impl : ( ( rule__Grammar__Group_2__0 )? ) ;
    public final void rule__Grammar__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2165:1: ( ( ( rule__Grammar__Group_2__0 )? ) )
            // InternalXtext.g:2166:1: ( ( rule__Grammar__Group_2__0 )? )
            {
            // InternalXtext.g:2166:1: ( ( rule__Grammar__Group_2__0 )? )
            // InternalXtext.g:2167:2: ( rule__Grammar__Group_2__0 )?
            {
             before(grammarAccess.getGrammarAccess().getGroup_2()); 
            // InternalXtext.g:2168:2: ( rule__Grammar__Group_2__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==20) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalXtext.g:2168:3: rule__Grammar__Group_2__0
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
    // InternalXtext.g:2176:1: rule__Grammar__Group__3 : rule__Grammar__Group__3__Impl rule__Grammar__Group__4 ;
    public final void rule__Grammar__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2180:1: ( rule__Grammar__Group__3__Impl rule__Grammar__Group__4 )
            // InternalXtext.g:2181:2: rule__Grammar__Group__3__Impl rule__Grammar__Group__4
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
    // InternalXtext.g:2188:1: rule__Grammar__Group__3__Impl : ( ( rule__Grammar__Group_3__0 )? ) ;
    public final void rule__Grammar__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2192:1: ( ( ( rule__Grammar__Group_3__0 )? ) )
            // InternalXtext.g:2193:1: ( ( rule__Grammar__Group_3__0 )? )
            {
            // InternalXtext.g:2193:1: ( ( rule__Grammar__Group_3__0 )? )
            // InternalXtext.g:2194:2: ( rule__Grammar__Group_3__0 )?
            {
             before(grammarAccess.getGrammarAccess().getGroup_3()); 
            // InternalXtext.g:2195:2: ( rule__Grammar__Group_3__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==48) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalXtext.g:2195:3: rule__Grammar__Group_3__0
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
    // InternalXtext.g:2203:1: rule__Grammar__Group__4 : rule__Grammar__Group__4__Impl rule__Grammar__Group__5 ;
    public final void rule__Grammar__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2207:1: ( rule__Grammar__Group__4__Impl rule__Grammar__Group__5 )
            // InternalXtext.g:2208:2: rule__Grammar__Group__4__Impl rule__Grammar__Group__5
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
    // InternalXtext.g:2215:1: rule__Grammar__Group__4__Impl : ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* ) ;
    public final void rule__Grammar__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2219:1: ( ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* ) )
            // InternalXtext.g:2220:1: ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* )
            {
            // InternalXtext.g:2220:1: ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* )
            // InternalXtext.g:2221:2: ( rule__Grammar__MetamodelDeclarationsAssignment_4 )*
            {
             before(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAssignment_4()); 
            // InternalXtext.g:2222:2: ( rule__Grammar__MetamodelDeclarationsAssignment_4 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==25||LA29_0==27) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalXtext.g:2222:3: rule__Grammar__MetamodelDeclarationsAssignment_4
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
    // InternalXtext.g:2230:1: rule__Grammar__Group__5 : rule__Grammar__Group__5__Impl ;
    public final void rule__Grammar__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2234:1: ( rule__Grammar__Group__5__Impl )
            // InternalXtext.g:2235:2: rule__Grammar__Group__5__Impl
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
    // InternalXtext.g:2241:1: rule__Grammar__Group__5__Impl : ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) ) ;
    public final void rule__Grammar__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2245:1: ( ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) ) )
            // InternalXtext.g:2246:1: ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) )
            {
            // InternalXtext.g:2246:1: ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) )
            // InternalXtext.g:2247:2: ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* )
            {
            // InternalXtext.g:2247:2: ( ( rule__Grammar__RulesAssignment_5 ) )
            // InternalXtext.g:2248:3: ( rule__Grammar__RulesAssignment_5 )
            {
             before(grammarAccess.getGrammarAccess().getRulesAssignment_5()); 
            // InternalXtext.g:2249:3: ( rule__Grammar__RulesAssignment_5 )
            // InternalXtext.g:2249:4: rule__Grammar__RulesAssignment_5
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Grammar__RulesAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getGrammarAccess().getRulesAssignment_5()); 

            }

            // InternalXtext.g:2252:2: ( ( rule__Grammar__RulesAssignment_5 )* )
            // InternalXtext.g:2253:3: ( rule__Grammar__RulesAssignment_5 )*
            {
             before(grammarAccess.getGrammarAccess().getRulesAssignment_5()); 
            // InternalXtext.g:2254:3: ( rule__Grammar__RulesAssignment_5 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_ID||(LA30_0>=16 && LA30_0<=17)||LA30_0==28||LA30_0==43||LA30_0==47||LA30_0==49) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalXtext.g:2254:4: rule__Grammar__RulesAssignment_5
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
    // InternalXtext.g:2264:1: rule__Grammar__Group_2__0 : rule__Grammar__Group_2__0__Impl rule__Grammar__Group_2__1 ;
    public final void rule__Grammar__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2268:1: ( rule__Grammar__Group_2__0__Impl rule__Grammar__Group_2__1 )
            // InternalXtext.g:2269:2: rule__Grammar__Group_2__0__Impl rule__Grammar__Group_2__1
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
    // InternalXtext.g:2276:1: rule__Grammar__Group_2__0__Impl : ( 'with' ) ;
    public final void rule__Grammar__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2280:1: ( ( 'with' ) )
            // InternalXtext.g:2281:1: ( 'with' )
            {
            // InternalXtext.g:2281:1: ( 'with' )
            // InternalXtext.g:2282:2: 'with'
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
    // InternalXtext.g:2291:1: rule__Grammar__Group_2__1 : rule__Grammar__Group_2__1__Impl rule__Grammar__Group_2__2 ;
    public final void rule__Grammar__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2295:1: ( rule__Grammar__Group_2__1__Impl rule__Grammar__Group_2__2 )
            // InternalXtext.g:2296:2: rule__Grammar__Group_2__1__Impl rule__Grammar__Group_2__2
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
    // InternalXtext.g:2303:1: rule__Grammar__Group_2__1__Impl : ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) ) ;
    public final void rule__Grammar__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2307:1: ( ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) ) )
            // InternalXtext.g:2308:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) )
            {
            // InternalXtext.g:2308:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) )
            // InternalXtext.g:2309:2: ( rule__Grammar__UsedGrammarsAssignment_2_1 )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_1()); 
            // InternalXtext.g:2310:2: ( rule__Grammar__UsedGrammarsAssignment_2_1 )
            // InternalXtext.g:2310:3: rule__Grammar__UsedGrammarsAssignment_2_1
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
    // InternalXtext.g:2318:1: rule__Grammar__Group_2__2 : rule__Grammar__Group_2__2__Impl ;
    public final void rule__Grammar__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2322:1: ( rule__Grammar__Group_2__2__Impl )
            // InternalXtext.g:2323:2: rule__Grammar__Group_2__2__Impl
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
    // InternalXtext.g:2329:1: rule__Grammar__Group_2__2__Impl : ( ( rule__Grammar__Group_2_2__0 )* ) ;
    public final void rule__Grammar__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2333:1: ( ( ( rule__Grammar__Group_2_2__0 )* ) )
            // InternalXtext.g:2334:1: ( ( rule__Grammar__Group_2_2__0 )* )
            {
            // InternalXtext.g:2334:1: ( ( rule__Grammar__Group_2_2__0 )* )
            // InternalXtext.g:2335:2: ( rule__Grammar__Group_2_2__0 )*
            {
             before(grammarAccess.getGrammarAccess().getGroup_2_2()); 
            // InternalXtext.g:2336:2: ( rule__Grammar__Group_2_2__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==21) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalXtext.g:2336:3: rule__Grammar__Group_2_2__0
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
    // InternalXtext.g:2345:1: rule__Grammar__Group_2_2__0 : rule__Grammar__Group_2_2__0__Impl rule__Grammar__Group_2_2__1 ;
    public final void rule__Grammar__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2349:1: ( rule__Grammar__Group_2_2__0__Impl rule__Grammar__Group_2_2__1 )
            // InternalXtext.g:2350:2: rule__Grammar__Group_2_2__0__Impl rule__Grammar__Group_2_2__1
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
    // InternalXtext.g:2357:1: rule__Grammar__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__Grammar__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2361:1: ( ( ',' ) )
            // InternalXtext.g:2362:1: ( ',' )
            {
            // InternalXtext.g:2362:1: ( ',' )
            // InternalXtext.g:2363:2: ','
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
    // InternalXtext.g:2372:1: rule__Grammar__Group_2_2__1 : rule__Grammar__Group_2_2__1__Impl ;
    public final void rule__Grammar__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2376:1: ( rule__Grammar__Group_2_2__1__Impl )
            // InternalXtext.g:2377:2: rule__Grammar__Group_2_2__1__Impl
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
    // InternalXtext.g:2383:1: rule__Grammar__Group_2_2__1__Impl : ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) ) ;
    public final void rule__Grammar__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2387:1: ( ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) ) )
            // InternalXtext.g:2388:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) )
            {
            // InternalXtext.g:2388:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) )
            // InternalXtext.g:2389:2: ( rule__Grammar__UsedGrammarsAssignment_2_2_1 )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_2_1()); 
            // InternalXtext.g:2390:2: ( rule__Grammar__UsedGrammarsAssignment_2_2_1 )
            // InternalXtext.g:2390:3: rule__Grammar__UsedGrammarsAssignment_2_2_1
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
    // InternalXtext.g:2399:1: rule__Grammar__Group_3__0 : rule__Grammar__Group_3__0__Impl rule__Grammar__Group_3__1 ;
    public final void rule__Grammar__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2403:1: ( rule__Grammar__Group_3__0__Impl rule__Grammar__Group_3__1 )
            // InternalXtext.g:2404:2: rule__Grammar__Group_3__0__Impl rule__Grammar__Group_3__1
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
    // InternalXtext.g:2411:1: rule__Grammar__Group_3__0__Impl : ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) ) ;
    public final void rule__Grammar__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2415:1: ( ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) ) )
            // InternalXtext.g:2416:1: ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) )
            {
            // InternalXtext.g:2416:1: ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) )
            // InternalXtext.g:2417:2: ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 )
            {
             before(grammarAccess.getGrammarAccess().getDefinesHiddenTokensAssignment_3_0()); 
            // InternalXtext.g:2418:2: ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 )
            // InternalXtext.g:2418:3: rule__Grammar__DefinesHiddenTokensAssignment_3_0
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
    // InternalXtext.g:2426:1: rule__Grammar__Group_3__1 : rule__Grammar__Group_3__1__Impl rule__Grammar__Group_3__2 ;
    public final void rule__Grammar__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2430:1: ( rule__Grammar__Group_3__1__Impl rule__Grammar__Group_3__2 )
            // InternalXtext.g:2431:2: rule__Grammar__Group_3__1__Impl rule__Grammar__Group_3__2
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
    // InternalXtext.g:2438:1: rule__Grammar__Group_3__1__Impl : ( '(' ) ;
    public final void rule__Grammar__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2442:1: ( ( '(' ) )
            // InternalXtext.g:2443:1: ( '(' )
            {
            // InternalXtext.g:2443:1: ( '(' )
            // InternalXtext.g:2444:2: '('
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
    // InternalXtext.g:2453:1: rule__Grammar__Group_3__2 : rule__Grammar__Group_3__2__Impl rule__Grammar__Group_3__3 ;
    public final void rule__Grammar__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2457:1: ( rule__Grammar__Group_3__2__Impl rule__Grammar__Group_3__3 )
            // InternalXtext.g:2458:2: rule__Grammar__Group_3__2__Impl rule__Grammar__Group_3__3
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
    // InternalXtext.g:2465:1: rule__Grammar__Group_3__2__Impl : ( ( rule__Grammar__Group_3_2__0 )? ) ;
    public final void rule__Grammar__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2469:1: ( ( ( rule__Grammar__Group_3_2__0 )? ) )
            // InternalXtext.g:2470:1: ( ( rule__Grammar__Group_3_2__0 )? )
            {
            // InternalXtext.g:2470:1: ( ( rule__Grammar__Group_3_2__0 )? )
            // InternalXtext.g:2471:2: ( rule__Grammar__Group_3_2__0 )?
            {
             before(grammarAccess.getGrammarAccess().getGroup_3_2()); 
            // InternalXtext.g:2472:2: ( rule__Grammar__Group_3_2__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_ID||(LA32_0>=16 && LA32_0<=17)) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalXtext.g:2472:3: rule__Grammar__Group_3_2__0
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
    // InternalXtext.g:2480:1: rule__Grammar__Group_3__3 : rule__Grammar__Group_3__3__Impl ;
    public final void rule__Grammar__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2484:1: ( rule__Grammar__Group_3__3__Impl )
            // InternalXtext.g:2485:2: rule__Grammar__Group_3__3__Impl
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
    // InternalXtext.g:2491:1: rule__Grammar__Group_3__3__Impl : ( ')' ) ;
    public final void rule__Grammar__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2495:1: ( ( ')' ) )
            // InternalXtext.g:2496:1: ( ')' )
            {
            // InternalXtext.g:2496:1: ( ')' )
            // InternalXtext.g:2497:2: ')'
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
    // InternalXtext.g:2507:1: rule__Grammar__Group_3_2__0 : rule__Grammar__Group_3_2__0__Impl rule__Grammar__Group_3_2__1 ;
    public final void rule__Grammar__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2511:1: ( rule__Grammar__Group_3_2__0__Impl rule__Grammar__Group_3_2__1 )
            // InternalXtext.g:2512:2: rule__Grammar__Group_3_2__0__Impl rule__Grammar__Group_3_2__1
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
    // InternalXtext.g:2519:1: rule__Grammar__Group_3_2__0__Impl : ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) ) ;
    public final void rule__Grammar__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2523:1: ( ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) ) )
            // InternalXtext.g:2524:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) )
            {
            // InternalXtext.g:2524:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) )
            // InternalXtext.g:2525:2: ( rule__Grammar__HiddenTokensAssignment_3_2_0 )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAssignment_3_2_0()); 
            // InternalXtext.g:2526:2: ( rule__Grammar__HiddenTokensAssignment_3_2_0 )
            // InternalXtext.g:2526:3: rule__Grammar__HiddenTokensAssignment_3_2_0
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
    // InternalXtext.g:2534:1: rule__Grammar__Group_3_2__1 : rule__Grammar__Group_3_2__1__Impl ;
    public final void rule__Grammar__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2538:1: ( rule__Grammar__Group_3_2__1__Impl )
            // InternalXtext.g:2539:2: rule__Grammar__Group_3_2__1__Impl
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
    // InternalXtext.g:2545:1: rule__Grammar__Group_3_2__1__Impl : ( ( rule__Grammar__Group_3_2_1__0 )* ) ;
    public final void rule__Grammar__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2549:1: ( ( ( rule__Grammar__Group_3_2_1__0 )* ) )
            // InternalXtext.g:2550:1: ( ( rule__Grammar__Group_3_2_1__0 )* )
            {
            // InternalXtext.g:2550:1: ( ( rule__Grammar__Group_3_2_1__0 )* )
            // InternalXtext.g:2551:2: ( rule__Grammar__Group_3_2_1__0 )*
            {
             before(grammarAccess.getGrammarAccess().getGroup_3_2_1()); 
            // InternalXtext.g:2552:2: ( rule__Grammar__Group_3_2_1__0 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==21) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalXtext.g:2552:3: rule__Grammar__Group_3_2_1__0
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
    // InternalXtext.g:2561:1: rule__Grammar__Group_3_2_1__0 : rule__Grammar__Group_3_2_1__0__Impl rule__Grammar__Group_3_2_1__1 ;
    public final void rule__Grammar__Group_3_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2565:1: ( rule__Grammar__Group_3_2_1__0__Impl rule__Grammar__Group_3_2_1__1 )
            // InternalXtext.g:2566:2: rule__Grammar__Group_3_2_1__0__Impl rule__Grammar__Group_3_2_1__1
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
    // InternalXtext.g:2573:1: rule__Grammar__Group_3_2_1__0__Impl : ( ',' ) ;
    public final void rule__Grammar__Group_3_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2577:1: ( ( ',' ) )
            // InternalXtext.g:2578:1: ( ',' )
            {
            // InternalXtext.g:2578:1: ( ',' )
            // InternalXtext.g:2579:2: ','
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
    // InternalXtext.g:2588:1: rule__Grammar__Group_3_2_1__1 : rule__Grammar__Group_3_2_1__1__Impl ;
    public final void rule__Grammar__Group_3_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2592:1: ( rule__Grammar__Group_3_2_1__1__Impl )
            // InternalXtext.g:2593:2: rule__Grammar__Group_3_2_1__1__Impl
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
    // InternalXtext.g:2599:1: rule__Grammar__Group_3_2_1__1__Impl : ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) ) ;
    public final void rule__Grammar__Group_3_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2603:1: ( ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) ) )
            // InternalXtext.g:2604:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) )
            {
            // InternalXtext.g:2604:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) )
            // InternalXtext.g:2605:2: ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAssignment_3_2_1_1()); 
            // InternalXtext.g:2606:2: ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 )
            // InternalXtext.g:2606:3: rule__Grammar__HiddenTokensAssignment_3_2_1_1
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
    // InternalXtext.g:2615:1: rule__GrammarID__Group__0 : rule__GrammarID__Group__0__Impl rule__GrammarID__Group__1 ;
    public final void rule__GrammarID__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2619:1: ( rule__GrammarID__Group__0__Impl rule__GrammarID__Group__1 )
            // InternalXtext.g:2620:2: rule__GrammarID__Group__0__Impl rule__GrammarID__Group__1
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
    // InternalXtext.g:2627:1: rule__GrammarID__Group__0__Impl : ( ruleValidID ) ;
    public final void rule__GrammarID__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2631:1: ( ( ruleValidID ) )
            // InternalXtext.g:2632:1: ( ruleValidID )
            {
            // InternalXtext.g:2632:1: ( ruleValidID )
            // InternalXtext.g:2633:2: ruleValidID
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
    // InternalXtext.g:2642:1: rule__GrammarID__Group__1 : rule__GrammarID__Group__1__Impl ;
    public final void rule__GrammarID__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2646:1: ( rule__GrammarID__Group__1__Impl )
            // InternalXtext.g:2647:2: rule__GrammarID__Group__1__Impl
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
    // InternalXtext.g:2653:1: rule__GrammarID__Group__1__Impl : ( ( rule__GrammarID__Group_1__0 )* ) ;
    public final void rule__GrammarID__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2657:1: ( ( ( rule__GrammarID__Group_1__0 )* ) )
            // InternalXtext.g:2658:1: ( ( rule__GrammarID__Group_1__0 )* )
            {
            // InternalXtext.g:2658:1: ( ( rule__GrammarID__Group_1__0 )* )
            // InternalXtext.g:2659:2: ( rule__GrammarID__Group_1__0 )*
            {
             before(grammarAccess.getGrammarIDAccess().getGroup_1()); 
            // InternalXtext.g:2660:2: ( rule__GrammarID__Group_1__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==24) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalXtext.g:2660:3: rule__GrammarID__Group_1__0
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
    // InternalXtext.g:2669:1: rule__GrammarID__Group_1__0 : rule__GrammarID__Group_1__0__Impl rule__GrammarID__Group_1__1 ;
    public final void rule__GrammarID__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2673:1: ( rule__GrammarID__Group_1__0__Impl rule__GrammarID__Group_1__1 )
            // InternalXtext.g:2674:2: rule__GrammarID__Group_1__0__Impl rule__GrammarID__Group_1__1
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
    // InternalXtext.g:2681:1: rule__GrammarID__Group_1__0__Impl : ( '.' ) ;
    public final void rule__GrammarID__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2685:1: ( ( '.' ) )
            // InternalXtext.g:2686:1: ( '.' )
            {
            // InternalXtext.g:2686:1: ( '.' )
            // InternalXtext.g:2687:2: '.'
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
    // InternalXtext.g:2696:1: rule__GrammarID__Group_1__1 : rule__GrammarID__Group_1__1__Impl ;
    public final void rule__GrammarID__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2700:1: ( rule__GrammarID__Group_1__1__Impl )
            // InternalXtext.g:2701:2: rule__GrammarID__Group_1__1__Impl
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
    // InternalXtext.g:2707:1: rule__GrammarID__Group_1__1__Impl : ( ruleValidID ) ;
    public final void rule__GrammarID__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2711:1: ( ( ruleValidID ) )
            // InternalXtext.g:2712:1: ( ruleValidID )
            {
            // InternalXtext.g:2712:1: ( ruleValidID )
            // InternalXtext.g:2713:2: ruleValidID
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
    // InternalXtext.g:2723:1: rule__GeneratedMetamodel__Group__0 : rule__GeneratedMetamodel__Group__0__Impl rule__GeneratedMetamodel__Group__1 ;
    public final void rule__GeneratedMetamodel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2727:1: ( rule__GeneratedMetamodel__Group__0__Impl rule__GeneratedMetamodel__Group__1 )
            // InternalXtext.g:2728:2: rule__GeneratedMetamodel__Group__0__Impl rule__GeneratedMetamodel__Group__1
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
    // InternalXtext.g:2735:1: rule__GeneratedMetamodel__Group__0__Impl : ( 'generate' ) ;
    public final void rule__GeneratedMetamodel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2739:1: ( ( 'generate' ) )
            // InternalXtext.g:2740:1: ( 'generate' )
            {
            // InternalXtext.g:2740:1: ( 'generate' )
            // InternalXtext.g:2741:2: 'generate'
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
    // InternalXtext.g:2750:1: rule__GeneratedMetamodel__Group__1 : rule__GeneratedMetamodel__Group__1__Impl rule__GeneratedMetamodel__Group__2 ;
    public final void rule__GeneratedMetamodel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2754:1: ( rule__GeneratedMetamodel__Group__1__Impl rule__GeneratedMetamodel__Group__2 )
            // InternalXtext.g:2755:2: rule__GeneratedMetamodel__Group__1__Impl rule__GeneratedMetamodel__Group__2
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
    // InternalXtext.g:2762:1: rule__GeneratedMetamodel__Group__1__Impl : ( ( rule__GeneratedMetamodel__NameAssignment_1 ) ) ;
    public final void rule__GeneratedMetamodel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2766:1: ( ( ( rule__GeneratedMetamodel__NameAssignment_1 ) ) )
            // InternalXtext.g:2767:1: ( ( rule__GeneratedMetamodel__NameAssignment_1 ) )
            {
            // InternalXtext.g:2767:1: ( ( rule__GeneratedMetamodel__NameAssignment_1 ) )
            // InternalXtext.g:2768:2: ( rule__GeneratedMetamodel__NameAssignment_1 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getNameAssignment_1()); 
            // InternalXtext.g:2769:2: ( rule__GeneratedMetamodel__NameAssignment_1 )
            // InternalXtext.g:2769:3: rule__GeneratedMetamodel__NameAssignment_1
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
    // InternalXtext.g:2777:1: rule__GeneratedMetamodel__Group__2 : rule__GeneratedMetamodel__Group__2__Impl rule__GeneratedMetamodel__Group__3 ;
    public final void rule__GeneratedMetamodel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2781:1: ( rule__GeneratedMetamodel__Group__2__Impl rule__GeneratedMetamodel__Group__3 )
            // InternalXtext.g:2782:2: rule__GeneratedMetamodel__Group__2__Impl rule__GeneratedMetamodel__Group__3
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
    // InternalXtext.g:2789:1: rule__GeneratedMetamodel__Group__2__Impl : ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) ) ;
    public final void rule__GeneratedMetamodel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2793:1: ( ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) ) )
            // InternalXtext.g:2794:1: ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) )
            {
            // InternalXtext.g:2794:1: ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) )
            // InternalXtext.g:2795:2: ( rule__GeneratedMetamodel__EPackageAssignment_2 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getEPackageAssignment_2()); 
            // InternalXtext.g:2796:2: ( rule__GeneratedMetamodel__EPackageAssignment_2 )
            // InternalXtext.g:2796:3: rule__GeneratedMetamodel__EPackageAssignment_2
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
    // InternalXtext.g:2804:1: rule__GeneratedMetamodel__Group__3 : rule__GeneratedMetamodel__Group__3__Impl ;
    public final void rule__GeneratedMetamodel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2808:1: ( rule__GeneratedMetamodel__Group__3__Impl )
            // InternalXtext.g:2809:2: rule__GeneratedMetamodel__Group__3__Impl
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
    // InternalXtext.g:2815:1: rule__GeneratedMetamodel__Group__3__Impl : ( ( rule__GeneratedMetamodel__Group_3__0 )? ) ;
    public final void rule__GeneratedMetamodel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2819:1: ( ( ( rule__GeneratedMetamodel__Group_3__0 )? ) )
            // InternalXtext.g:2820:1: ( ( rule__GeneratedMetamodel__Group_3__0 )? )
            {
            // InternalXtext.g:2820:1: ( ( rule__GeneratedMetamodel__Group_3__0 )? )
            // InternalXtext.g:2821:2: ( rule__GeneratedMetamodel__Group_3__0 )?
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getGroup_3()); 
            // InternalXtext.g:2822:2: ( rule__GeneratedMetamodel__Group_3__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==26) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalXtext.g:2822:3: rule__GeneratedMetamodel__Group_3__0
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
    // InternalXtext.g:2831:1: rule__GeneratedMetamodel__Group_3__0 : rule__GeneratedMetamodel__Group_3__0__Impl rule__GeneratedMetamodel__Group_3__1 ;
    public final void rule__GeneratedMetamodel__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2835:1: ( rule__GeneratedMetamodel__Group_3__0__Impl rule__GeneratedMetamodel__Group_3__1 )
            // InternalXtext.g:2836:2: rule__GeneratedMetamodel__Group_3__0__Impl rule__GeneratedMetamodel__Group_3__1
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
    // InternalXtext.g:2843:1: rule__GeneratedMetamodel__Group_3__0__Impl : ( 'as' ) ;
    public final void rule__GeneratedMetamodel__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2847:1: ( ( 'as' ) )
            // InternalXtext.g:2848:1: ( 'as' )
            {
            // InternalXtext.g:2848:1: ( 'as' )
            // InternalXtext.g:2849:2: 'as'
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
    // InternalXtext.g:2858:1: rule__GeneratedMetamodel__Group_3__1 : rule__GeneratedMetamodel__Group_3__1__Impl ;
    public final void rule__GeneratedMetamodel__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2862:1: ( rule__GeneratedMetamodel__Group_3__1__Impl )
            // InternalXtext.g:2863:2: rule__GeneratedMetamodel__Group_3__1__Impl
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
    // InternalXtext.g:2869:1: rule__GeneratedMetamodel__Group_3__1__Impl : ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) ) ;
    public final void rule__GeneratedMetamodel__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2873:1: ( ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) ) )
            // InternalXtext.g:2874:1: ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) )
            {
            // InternalXtext.g:2874:1: ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) )
            // InternalXtext.g:2875:2: ( rule__GeneratedMetamodel__AliasAssignment_3_1 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getAliasAssignment_3_1()); 
            // InternalXtext.g:2876:2: ( rule__GeneratedMetamodel__AliasAssignment_3_1 )
            // InternalXtext.g:2876:3: rule__GeneratedMetamodel__AliasAssignment_3_1
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
    // InternalXtext.g:2885:1: rule__ReferencedMetamodel__Group__0 : rule__ReferencedMetamodel__Group__0__Impl rule__ReferencedMetamodel__Group__1 ;
    public final void rule__ReferencedMetamodel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2889:1: ( rule__ReferencedMetamodel__Group__0__Impl rule__ReferencedMetamodel__Group__1 )
            // InternalXtext.g:2890:2: rule__ReferencedMetamodel__Group__0__Impl rule__ReferencedMetamodel__Group__1
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
    // InternalXtext.g:2897:1: rule__ReferencedMetamodel__Group__0__Impl : ( 'import' ) ;
    public final void rule__ReferencedMetamodel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2901:1: ( ( 'import' ) )
            // InternalXtext.g:2902:1: ( 'import' )
            {
            // InternalXtext.g:2902:1: ( 'import' )
            // InternalXtext.g:2903:2: 'import'
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
    // InternalXtext.g:2912:1: rule__ReferencedMetamodel__Group__1 : rule__ReferencedMetamodel__Group__1__Impl rule__ReferencedMetamodel__Group__2 ;
    public final void rule__ReferencedMetamodel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2916:1: ( rule__ReferencedMetamodel__Group__1__Impl rule__ReferencedMetamodel__Group__2 )
            // InternalXtext.g:2917:2: rule__ReferencedMetamodel__Group__1__Impl rule__ReferencedMetamodel__Group__2
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
    // InternalXtext.g:2924:1: rule__ReferencedMetamodel__Group__1__Impl : ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) ) ;
    public final void rule__ReferencedMetamodel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2928:1: ( ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) ) )
            // InternalXtext.g:2929:1: ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) )
            {
            // InternalXtext.g:2929:1: ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) )
            // InternalXtext.g:2930:2: ( rule__ReferencedMetamodel__EPackageAssignment_1 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageAssignment_1()); 
            // InternalXtext.g:2931:2: ( rule__ReferencedMetamodel__EPackageAssignment_1 )
            // InternalXtext.g:2931:3: rule__ReferencedMetamodel__EPackageAssignment_1
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
    // InternalXtext.g:2939:1: rule__ReferencedMetamodel__Group__2 : rule__ReferencedMetamodel__Group__2__Impl ;
    public final void rule__ReferencedMetamodel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2943:1: ( rule__ReferencedMetamodel__Group__2__Impl )
            // InternalXtext.g:2944:2: rule__ReferencedMetamodel__Group__2__Impl
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
    // InternalXtext.g:2950:1: rule__ReferencedMetamodel__Group__2__Impl : ( ( rule__ReferencedMetamodel__Group_2__0 )? ) ;
    public final void rule__ReferencedMetamodel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2954:1: ( ( ( rule__ReferencedMetamodel__Group_2__0 )? ) )
            // InternalXtext.g:2955:1: ( ( rule__ReferencedMetamodel__Group_2__0 )? )
            {
            // InternalXtext.g:2955:1: ( ( rule__ReferencedMetamodel__Group_2__0 )? )
            // InternalXtext.g:2956:2: ( rule__ReferencedMetamodel__Group_2__0 )?
            {
             before(grammarAccess.getReferencedMetamodelAccess().getGroup_2()); 
            // InternalXtext.g:2957:2: ( rule__ReferencedMetamodel__Group_2__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==26) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalXtext.g:2957:3: rule__ReferencedMetamodel__Group_2__0
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
    // InternalXtext.g:2966:1: rule__ReferencedMetamodel__Group_2__0 : rule__ReferencedMetamodel__Group_2__0__Impl rule__ReferencedMetamodel__Group_2__1 ;
    public final void rule__ReferencedMetamodel__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2970:1: ( rule__ReferencedMetamodel__Group_2__0__Impl rule__ReferencedMetamodel__Group_2__1 )
            // InternalXtext.g:2971:2: rule__ReferencedMetamodel__Group_2__0__Impl rule__ReferencedMetamodel__Group_2__1
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
    // InternalXtext.g:2978:1: rule__ReferencedMetamodel__Group_2__0__Impl : ( 'as' ) ;
    public final void rule__ReferencedMetamodel__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2982:1: ( ( 'as' ) )
            // InternalXtext.g:2983:1: ( 'as' )
            {
            // InternalXtext.g:2983:1: ( 'as' )
            // InternalXtext.g:2984:2: 'as'
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
    // InternalXtext.g:2993:1: rule__ReferencedMetamodel__Group_2__1 : rule__ReferencedMetamodel__Group_2__1__Impl ;
    public final void rule__ReferencedMetamodel__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2997:1: ( rule__ReferencedMetamodel__Group_2__1__Impl )
            // InternalXtext.g:2998:2: rule__ReferencedMetamodel__Group_2__1__Impl
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
    // InternalXtext.g:3004:1: rule__ReferencedMetamodel__Group_2__1__Impl : ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) ) ;
    public final void rule__ReferencedMetamodel__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3008:1: ( ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) ) )
            // InternalXtext.g:3009:1: ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) )
            {
            // InternalXtext.g:3009:1: ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) )
            // InternalXtext.g:3010:2: ( rule__ReferencedMetamodel__AliasAssignment_2_1 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAliasAssignment_2_1()); 
            // InternalXtext.g:3011:2: ( rule__ReferencedMetamodel__AliasAssignment_2_1 )
            // InternalXtext.g:3011:3: rule__ReferencedMetamodel__AliasAssignment_2_1
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


    // $ANTLR start "rule__Annotation__Group__0"
    // InternalXtext.g:3020:1: rule__Annotation__Group__0 : rule__Annotation__Group__0__Impl rule__Annotation__Group__1 ;
    public final void rule__Annotation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3024:1: ( rule__Annotation__Group__0__Impl rule__Annotation__Group__1 )
            // InternalXtext.g:3025:2: rule__Annotation__Group__0__Impl rule__Annotation__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_15);
            rule__Annotation__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Annotation__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Annotation__Group__0"


    // $ANTLR start "rule__Annotation__Group__0__Impl"
    // InternalXtext.g:3032:1: rule__Annotation__Group__0__Impl : ( '@' ) ;
    public final void rule__Annotation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3036:1: ( ( '@' ) )
            // InternalXtext.g:3037:1: ( '@' )
            {
            // InternalXtext.g:3037:1: ( '@' )
            // InternalXtext.g:3038:2: '@'
            {
             before(grammarAccess.getAnnotationAccess().getCommercialAtKeyword_0()); 
            match(input,28,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAnnotationAccess().getCommercialAtKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Annotation__Group__0__Impl"


    // $ANTLR start "rule__Annotation__Group__1"
    // InternalXtext.g:3047:1: rule__Annotation__Group__1 : rule__Annotation__Group__1__Impl ;
    public final void rule__Annotation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3051:1: ( rule__Annotation__Group__1__Impl )
            // InternalXtext.g:3052:2: rule__Annotation__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Annotation__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Annotation__Group__1"


    // $ANTLR start "rule__Annotation__Group__1__Impl"
    // InternalXtext.g:3058:1: rule__Annotation__Group__1__Impl : ( ( rule__Annotation__NameAssignment_1 ) ) ;
    public final void rule__Annotation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3062:1: ( ( ( rule__Annotation__NameAssignment_1 ) ) )
            // InternalXtext.g:3063:1: ( ( rule__Annotation__NameAssignment_1 ) )
            {
            // InternalXtext.g:3063:1: ( ( rule__Annotation__NameAssignment_1 ) )
            // InternalXtext.g:3064:2: ( rule__Annotation__NameAssignment_1 )
            {
             before(grammarAccess.getAnnotationAccess().getNameAssignment_1()); 
            // InternalXtext.g:3065:2: ( rule__Annotation__NameAssignment_1 )
            // InternalXtext.g:3065:3: rule__Annotation__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Annotation__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getAnnotationAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Annotation__Group__1__Impl"


    // $ANTLR start "rule__ParserRule__Group__0"
    // InternalXtext.g:3074:1: rule__ParserRule__Group__0 : rule__ParserRule__Group__0__Impl rule__ParserRule__Group__1 ;
    public final void rule__ParserRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3078:1: ( rule__ParserRule__Group__0__Impl rule__ParserRule__Group__1 )
            // InternalXtext.g:3079:2: rule__ParserRule__Group__0__Impl rule__ParserRule__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_16);
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
    // InternalXtext.g:3086:1: rule__ParserRule__Group__0__Impl : ( ( rule__ParserRule__AnnotationsAssignment_0 )* ) ;
    public final void rule__ParserRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3090:1: ( ( ( rule__ParserRule__AnnotationsAssignment_0 )* ) )
            // InternalXtext.g:3091:1: ( ( rule__ParserRule__AnnotationsAssignment_0 )* )
            {
            // InternalXtext.g:3091:1: ( ( rule__ParserRule__AnnotationsAssignment_0 )* )
            // InternalXtext.g:3092:2: ( rule__ParserRule__AnnotationsAssignment_0 )*
            {
             before(grammarAccess.getParserRuleAccess().getAnnotationsAssignment_0()); 
            // InternalXtext.g:3093:2: ( rule__ParserRule__AnnotationsAssignment_0 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==28) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalXtext.g:3093:3: rule__ParserRule__AnnotationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_17);
            	    rule__ParserRule__AnnotationsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

             after(grammarAccess.getParserRuleAccess().getAnnotationsAssignment_0()); 

            }


            }

        }
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
    // InternalXtext.g:3101:1: rule__ParserRule__Group__1 : rule__ParserRule__Group__1__Impl rule__ParserRule__Group__2 ;
    public final void rule__ParserRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3105:1: ( rule__ParserRule__Group__1__Impl rule__ParserRule__Group__2 )
            // InternalXtext.g:3106:2: rule__ParserRule__Group__1__Impl rule__ParserRule__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_18);
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
    // InternalXtext.g:3113:1: rule__ParserRule__Group__1__Impl : ( ( rule__ParserRule__Alternatives_1 ) ) ;
    public final void rule__ParserRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3117:1: ( ( ( rule__ParserRule__Alternatives_1 ) ) )
            // InternalXtext.g:3118:1: ( ( rule__ParserRule__Alternatives_1 ) )
            {
            // InternalXtext.g:3118:1: ( ( rule__ParserRule__Alternatives_1 ) )
            // InternalXtext.g:3119:2: ( rule__ParserRule__Alternatives_1 )
            {
             before(grammarAccess.getParserRuleAccess().getAlternatives_1()); 
            // InternalXtext.g:3120:2: ( rule__ParserRule__Alternatives_1 )
            // InternalXtext.g:3120:3: rule__ParserRule__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getAlternatives_1()); 

            }


            }

        }
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
    // InternalXtext.g:3128:1: rule__ParserRule__Group__2 : rule__ParserRule__Group__2__Impl rule__ParserRule__Group__3 ;
    public final void rule__ParserRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3132:1: ( rule__ParserRule__Group__2__Impl rule__ParserRule__Group__3 )
            // InternalXtext.g:3133:2: rule__ParserRule__Group__2__Impl rule__ParserRule__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_18);
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
    // InternalXtext.g:3140:1: rule__ParserRule__Group__2__Impl : ( ( rule__ParserRule__Group_2__0 )? ) ;
    public final void rule__ParserRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3144:1: ( ( ( rule__ParserRule__Group_2__0 )? ) )
            // InternalXtext.g:3145:1: ( ( rule__ParserRule__Group_2__0 )? )
            {
            // InternalXtext.g:3145:1: ( ( rule__ParserRule__Group_2__0 )? )
            // InternalXtext.g:3146:2: ( rule__ParserRule__Group_2__0 )?
            {
             before(grammarAccess.getParserRuleAccess().getGroup_2()); 
            // InternalXtext.g:3147:2: ( rule__ParserRule__Group_2__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==48) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalXtext.g:3147:3: rule__ParserRule__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3155:1: rule__ParserRule__Group__3 : rule__ParserRule__Group__3__Impl rule__ParserRule__Group__4 ;
    public final void rule__ParserRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3159:1: ( rule__ParserRule__Group__3__Impl rule__ParserRule__Group__4 )
            // InternalXtext.g:3160:2: rule__ParserRule__Group__3__Impl rule__ParserRule__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_19);
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
    // InternalXtext.g:3167:1: rule__ParserRule__Group__3__Impl : ( ':' ) ;
    public final void rule__ParserRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3171:1: ( ( ':' ) )
            // InternalXtext.g:3172:1: ( ':' )
            {
            // InternalXtext.g:3172:1: ( ':' )
            // InternalXtext.g:3173:2: ':'
            {
             before(grammarAccess.getParserRuleAccess().getColonKeyword_3()); 
            match(input,29,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:3182:1: rule__ParserRule__Group__4 : rule__ParserRule__Group__4__Impl rule__ParserRule__Group__5 ;
    public final void rule__ParserRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3186:1: ( rule__ParserRule__Group__4__Impl rule__ParserRule__Group__5 )
            // InternalXtext.g:3187:2: rule__ParserRule__Group__4__Impl rule__ParserRule__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_20);
            rule__ParserRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3194:1: rule__ParserRule__Group__4__Impl : ( ( rule__ParserRule__AlternativesAssignment_4 ) ) ;
    public final void rule__ParserRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3198:1: ( ( ( rule__ParserRule__AlternativesAssignment_4 ) ) )
            // InternalXtext.g:3199:1: ( ( rule__ParserRule__AlternativesAssignment_4 ) )
            {
            // InternalXtext.g:3199:1: ( ( rule__ParserRule__AlternativesAssignment_4 ) )
            // InternalXtext.g:3200:2: ( rule__ParserRule__AlternativesAssignment_4 )
            {
             before(grammarAccess.getParserRuleAccess().getAlternativesAssignment_4()); 
            // InternalXtext.g:3201:2: ( rule__ParserRule__AlternativesAssignment_4 )
            // InternalXtext.g:3201:3: rule__ParserRule__AlternativesAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3209:1: rule__ParserRule__Group__5 : rule__ParserRule__Group__5__Impl ;
    public final void rule__ParserRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3213:1: ( rule__ParserRule__Group__5__Impl )
            // InternalXtext.g:3214:2: rule__ParserRule__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3220:1: rule__ParserRule__Group__5__Impl : ( ';' ) ;
    public final void rule__ParserRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3224:1: ( ( ';' ) )
            // InternalXtext.g:3225:1: ( ';' )
            {
            // InternalXtext.g:3225:1: ( ';' )
            // InternalXtext.g:3226:2: ';'
            {
             before(grammarAccess.getParserRuleAccess().getSemicolonKeyword_5()); 
            match(input,30,FollowSets000.FOLLOW_2); 
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


    // $ANTLR start "rule__ParserRule__Group_1_0__0"
    // InternalXtext.g:3236:1: rule__ParserRule__Group_1_0__0 : rule__ParserRule__Group_1_0__0__Impl rule__ParserRule__Group_1_0__1 ;
    public final void rule__ParserRule__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3240:1: ( rule__ParserRule__Group_1_0__0__Impl rule__ParserRule__Group_1_0__1 )
            // InternalXtext.g:3241:2: rule__ParserRule__Group_1_0__0__Impl rule__ParserRule__Group_1_0__1
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__ParserRule__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_1_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_0__0"


    // $ANTLR start "rule__ParserRule__Group_1_0__0__Impl"
    // InternalXtext.g:3248:1: rule__ParserRule__Group_1_0__0__Impl : ( ( rule__ParserRule__FragmentAssignment_1_0_0 ) ) ;
    public final void rule__ParserRule__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3252:1: ( ( ( rule__ParserRule__FragmentAssignment_1_0_0 ) ) )
            // InternalXtext.g:3253:1: ( ( rule__ParserRule__FragmentAssignment_1_0_0 ) )
            {
            // InternalXtext.g:3253:1: ( ( rule__ParserRule__FragmentAssignment_1_0_0 ) )
            // InternalXtext.g:3254:2: ( rule__ParserRule__FragmentAssignment_1_0_0 )
            {
             before(grammarAccess.getParserRuleAccess().getFragmentAssignment_1_0_0()); 
            // InternalXtext.g:3255:2: ( rule__ParserRule__FragmentAssignment_1_0_0 )
            // InternalXtext.g:3255:3: rule__ParserRule__FragmentAssignment_1_0_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__FragmentAssignment_1_0_0();

            state._fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getFragmentAssignment_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_0__0__Impl"


    // $ANTLR start "rule__ParserRule__Group_1_0__1"
    // InternalXtext.g:3263:1: rule__ParserRule__Group_1_0__1 : rule__ParserRule__Group_1_0__1__Impl rule__ParserRule__Group_1_0__2 ;
    public final void rule__ParserRule__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3267:1: ( rule__ParserRule__Group_1_0__1__Impl rule__ParserRule__Group_1_0__2 )
            // InternalXtext.g:3268:2: rule__ParserRule__Group_1_0__1__Impl rule__ParserRule__Group_1_0__2
            {
            pushFollow(FollowSets000.FOLLOW_21);
            rule__ParserRule__Group_1_0__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_1_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_0__1"


    // $ANTLR start "rule__ParserRule__Group_1_0__1__Impl"
    // InternalXtext.g:3275:1: rule__ParserRule__Group_1_0__1__Impl : ( ruleRuleNameAndParams ) ;
    public final void rule__ParserRule__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3279:1: ( ( ruleRuleNameAndParams ) )
            // InternalXtext.g:3280:1: ( ruleRuleNameAndParams )
            {
            // InternalXtext.g:3280:1: ( ruleRuleNameAndParams )
            // InternalXtext.g:3281:2: ruleRuleNameAndParams
            {
             before(grammarAccess.getParserRuleAccess().getRuleNameAndParamsParserRuleCall_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleRuleNameAndParams();

            state._fsp--;

             after(grammarAccess.getParserRuleAccess().getRuleNameAndParamsParserRuleCall_1_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_0__1__Impl"


    // $ANTLR start "rule__ParserRule__Group_1_0__2"
    // InternalXtext.g:3290:1: rule__ParserRule__Group_1_0__2 : rule__ParserRule__Group_1_0__2__Impl ;
    public final void rule__ParserRule__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3294:1: ( rule__ParserRule__Group_1_0__2__Impl )
            // InternalXtext.g:3295:2: rule__ParserRule__Group_1_0__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_1_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_0__2"


    // $ANTLR start "rule__ParserRule__Group_1_0__2__Impl"
    // InternalXtext.g:3301:1: rule__ParserRule__Group_1_0__2__Impl : ( ( rule__ParserRule__Alternatives_1_0_2 ) ) ;
    public final void rule__ParserRule__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3305:1: ( ( ( rule__ParserRule__Alternatives_1_0_2 ) ) )
            // InternalXtext.g:3306:1: ( ( rule__ParserRule__Alternatives_1_0_2 ) )
            {
            // InternalXtext.g:3306:1: ( ( rule__ParserRule__Alternatives_1_0_2 ) )
            // InternalXtext.g:3307:2: ( rule__ParserRule__Alternatives_1_0_2 )
            {
             before(grammarAccess.getParserRuleAccess().getAlternatives_1_0_2()); 
            // InternalXtext.g:3308:2: ( rule__ParserRule__Alternatives_1_0_2 )
            // InternalXtext.g:3308:3: rule__ParserRule__Alternatives_1_0_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Alternatives_1_0_2();

            state._fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getAlternatives_1_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_0__2__Impl"


    // $ANTLR start "rule__ParserRule__Group_1_0_2_1__0"
    // InternalXtext.g:3317:1: rule__ParserRule__Group_1_0_2_1__0 : rule__ParserRule__Group_1_0_2_1__0__Impl rule__ParserRule__Group_1_0_2_1__1 ;
    public final void rule__ParserRule__Group_1_0_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3321:1: ( rule__ParserRule__Group_1_0_2_1__0__Impl rule__ParserRule__Group_1_0_2_1__1 )
            // InternalXtext.g:3322:2: rule__ParserRule__Group_1_0_2_1__0__Impl rule__ParserRule__Group_1_0_2_1__1
            {
            pushFollow(FollowSets000.FOLLOW_15);
            rule__ParserRule__Group_1_0_2_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_1_0_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_0_2_1__0"


    // $ANTLR start "rule__ParserRule__Group_1_0_2_1__0__Impl"
    // InternalXtext.g:3329:1: rule__ParserRule__Group_1_0_2_1__0__Impl : ( 'returns' ) ;
    public final void rule__ParserRule__Group_1_0_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3333:1: ( ( 'returns' ) )
            // InternalXtext.g:3334:1: ( 'returns' )
            {
            // InternalXtext.g:3334:1: ( 'returns' )
            // InternalXtext.g:3335:2: 'returns'
            {
             before(grammarAccess.getParserRuleAccess().getReturnsKeyword_1_0_2_1_0()); 
            match(input,31,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParserRuleAccess().getReturnsKeyword_1_0_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_0_2_1__0__Impl"


    // $ANTLR start "rule__ParserRule__Group_1_0_2_1__1"
    // InternalXtext.g:3344:1: rule__ParserRule__Group_1_0_2_1__1 : rule__ParserRule__Group_1_0_2_1__1__Impl ;
    public final void rule__ParserRule__Group_1_0_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3348:1: ( rule__ParserRule__Group_1_0_2_1__1__Impl )
            // InternalXtext.g:3349:2: rule__ParserRule__Group_1_0_2_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_1_0_2_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_0_2_1__1"


    // $ANTLR start "rule__ParserRule__Group_1_0_2_1__1__Impl"
    // InternalXtext.g:3355:1: rule__ParserRule__Group_1_0_2_1__1__Impl : ( ( rule__ParserRule__TypeAssignment_1_0_2_1_1 ) ) ;
    public final void rule__ParserRule__Group_1_0_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3359:1: ( ( ( rule__ParserRule__TypeAssignment_1_0_2_1_1 ) ) )
            // InternalXtext.g:3360:1: ( ( rule__ParserRule__TypeAssignment_1_0_2_1_1 ) )
            {
            // InternalXtext.g:3360:1: ( ( rule__ParserRule__TypeAssignment_1_0_2_1_1 ) )
            // InternalXtext.g:3361:2: ( rule__ParserRule__TypeAssignment_1_0_2_1_1 )
            {
             before(grammarAccess.getParserRuleAccess().getTypeAssignment_1_0_2_1_1()); 
            // InternalXtext.g:3362:2: ( rule__ParserRule__TypeAssignment_1_0_2_1_1 )
            // InternalXtext.g:3362:3: rule__ParserRule__TypeAssignment_1_0_2_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__TypeAssignment_1_0_2_1_1();

            state._fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getTypeAssignment_1_0_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_0_2_1__1__Impl"


    // $ANTLR start "rule__ParserRule__Group_1_1__0"
    // InternalXtext.g:3371:1: rule__ParserRule__Group_1_1__0 : rule__ParserRule__Group_1_1__0__Impl rule__ParserRule__Group_1_1__1 ;
    public final void rule__ParserRule__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3375:1: ( rule__ParserRule__Group_1_1__0__Impl rule__ParserRule__Group_1_1__1 )
            // InternalXtext.g:3376:2: rule__ParserRule__Group_1_1__0__Impl rule__ParserRule__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_22);
            rule__ParserRule__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_1__0"


    // $ANTLR start "rule__ParserRule__Group_1_1__0__Impl"
    // InternalXtext.g:3383:1: rule__ParserRule__Group_1_1__0__Impl : ( ruleRuleNameAndParams ) ;
    public final void rule__ParserRule__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3387:1: ( ( ruleRuleNameAndParams ) )
            // InternalXtext.g:3388:1: ( ruleRuleNameAndParams )
            {
            // InternalXtext.g:3388:1: ( ruleRuleNameAndParams )
            // InternalXtext.g:3389:2: ruleRuleNameAndParams
            {
             before(grammarAccess.getParserRuleAccess().getRuleNameAndParamsParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleRuleNameAndParams();

            state._fsp--;

             after(grammarAccess.getParserRuleAccess().getRuleNameAndParamsParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_1__0__Impl"


    // $ANTLR start "rule__ParserRule__Group_1_1__1"
    // InternalXtext.g:3398:1: rule__ParserRule__Group_1_1__1 : rule__ParserRule__Group_1_1__1__Impl ;
    public final void rule__ParserRule__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3402:1: ( rule__ParserRule__Group_1_1__1__Impl )
            // InternalXtext.g:3403:2: rule__ParserRule__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_1__1"


    // $ANTLR start "rule__ParserRule__Group_1_1__1__Impl"
    // InternalXtext.g:3409:1: rule__ParserRule__Group_1_1__1__Impl : ( ( rule__ParserRule__Group_1_1_1__0 )? ) ;
    public final void rule__ParserRule__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3413:1: ( ( ( rule__ParserRule__Group_1_1_1__0 )? ) )
            // InternalXtext.g:3414:1: ( ( rule__ParserRule__Group_1_1_1__0 )? )
            {
            // InternalXtext.g:3414:1: ( ( rule__ParserRule__Group_1_1_1__0 )? )
            // InternalXtext.g:3415:2: ( rule__ParserRule__Group_1_1_1__0 )?
            {
             before(grammarAccess.getParserRuleAccess().getGroup_1_1_1()); 
            // InternalXtext.g:3416:2: ( rule__ParserRule__Group_1_1_1__0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==31) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalXtext.g:3416:3: rule__ParserRule__Group_1_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ParserRule__Group_1_1_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParserRuleAccess().getGroup_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_1__1__Impl"


    // $ANTLR start "rule__ParserRule__Group_1_1_1__0"
    // InternalXtext.g:3425:1: rule__ParserRule__Group_1_1_1__0 : rule__ParserRule__Group_1_1_1__0__Impl rule__ParserRule__Group_1_1_1__1 ;
    public final void rule__ParserRule__Group_1_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3429:1: ( rule__ParserRule__Group_1_1_1__0__Impl rule__ParserRule__Group_1_1_1__1 )
            // InternalXtext.g:3430:2: rule__ParserRule__Group_1_1_1__0__Impl rule__ParserRule__Group_1_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_15);
            rule__ParserRule__Group_1_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_1_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_1_1__0"


    // $ANTLR start "rule__ParserRule__Group_1_1_1__0__Impl"
    // InternalXtext.g:3437:1: rule__ParserRule__Group_1_1_1__0__Impl : ( 'returns' ) ;
    public final void rule__ParserRule__Group_1_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3441:1: ( ( 'returns' ) )
            // InternalXtext.g:3442:1: ( 'returns' )
            {
            // InternalXtext.g:3442:1: ( 'returns' )
            // InternalXtext.g:3443:2: 'returns'
            {
             before(grammarAccess.getParserRuleAccess().getReturnsKeyword_1_1_1_0()); 
            match(input,31,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParserRuleAccess().getReturnsKeyword_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_1_1__0__Impl"


    // $ANTLR start "rule__ParserRule__Group_1_1_1__1"
    // InternalXtext.g:3452:1: rule__ParserRule__Group_1_1_1__1 : rule__ParserRule__Group_1_1_1__1__Impl ;
    public final void rule__ParserRule__Group_1_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3456:1: ( rule__ParserRule__Group_1_1_1__1__Impl )
            // InternalXtext.g:3457:2: rule__ParserRule__Group_1_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_1_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_1_1__1"


    // $ANTLR start "rule__ParserRule__Group_1_1_1__1__Impl"
    // InternalXtext.g:3463:1: rule__ParserRule__Group_1_1_1__1__Impl : ( ( rule__ParserRule__TypeAssignment_1_1_1_1 ) ) ;
    public final void rule__ParserRule__Group_1_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3467:1: ( ( ( rule__ParserRule__TypeAssignment_1_1_1_1 ) ) )
            // InternalXtext.g:3468:1: ( ( rule__ParserRule__TypeAssignment_1_1_1_1 ) )
            {
            // InternalXtext.g:3468:1: ( ( rule__ParserRule__TypeAssignment_1_1_1_1 ) )
            // InternalXtext.g:3469:2: ( rule__ParserRule__TypeAssignment_1_1_1_1 )
            {
             before(grammarAccess.getParserRuleAccess().getTypeAssignment_1_1_1_1()); 
            // InternalXtext.g:3470:2: ( rule__ParserRule__TypeAssignment_1_1_1_1 )
            // InternalXtext.g:3470:3: rule__ParserRule__TypeAssignment_1_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__TypeAssignment_1_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getTypeAssignment_1_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_1_1__1__Impl"


    // $ANTLR start "rule__ParserRule__Group_2__0"
    // InternalXtext.g:3479:1: rule__ParserRule__Group_2__0 : rule__ParserRule__Group_2__0__Impl rule__ParserRule__Group_2__1 ;
    public final void rule__ParserRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3483:1: ( rule__ParserRule__Group_2__0__Impl rule__ParserRule__Group_2__1 )
            // InternalXtext.g:3484:2: rule__ParserRule__Group_2__0__Impl rule__ParserRule__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__ParserRule__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3491:1: rule__ParserRule__Group_2__0__Impl : ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) ) ;
    public final void rule__ParserRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3495:1: ( ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) ) )
            // InternalXtext.g:3496:1: ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) )
            {
            // InternalXtext.g:3496:1: ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) )
            // InternalXtext.g:3497:2: ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 )
            {
             before(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensAssignment_2_0()); 
            // InternalXtext.g:3498:2: ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 )
            // InternalXtext.g:3498:3: rule__ParserRule__DefinesHiddenTokensAssignment_2_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3506:1: rule__ParserRule__Group_2__1 : rule__ParserRule__Group_2__1__Impl rule__ParserRule__Group_2__2 ;
    public final void rule__ParserRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3510:1: ( rule__ParserRule__Group_2__1__Impl rule__ParserRule__Group_2__2 )
            // InternalXtext.g:3511:2: rule__ParserRule__Group_2__1__Impl rule__ParserRule__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__ParserRule__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3518:1: rule__ParserRule__Group_2__1__Impl : ( '(' ) ;
    public final void rule__ParserRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3522:1: ( ( '(' ) )
            // InternalXtext.g:3523:1: ( '(' )
            {
            // InternalXtext.g:3523:1: ( '(' )
            // InternalXtext.g:3524:2: '('
            {
             before(grammarAccess.getParserRuleAccess().getLeftParenthesisKeyword_2_1()); 
            match(input,22,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:3533:1: rule__ParserRule__Group_2__2 : rule__ParserRule__Group_2__2__Impl rule__ParserRule__Group_2__3 ;
    public final void rule__ParserRule__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3537:1: ( rule__ParserRule__Group_2__2__Impl rule__ParserRule__Group_2__3 )
            // InternalXtext.g:3538:2: rule__ParserRule__Group_2__2__Impl rule__ParserRule__Group_2__3
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__ParserRule__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3545:1: rule__ParserRule__Group_2__2__Impl : ( ( rule__ParserRule__Group_2_2__0 )? ) ;
    public final void rule__ParserRule__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3549:1: ( ( ( rule__ParserRule__Group_2_2__0 )? ) )
            // InternalXtext.g:3550:1: ( ( rule__ParserRule__Group_2_2__0 )? )
            {
            // InternalXtext.g:3550:1: ( ( rule__ParserRule__Group_2_2__0 )? )
            // InternalXtext.g:3551:2: ( rule__ParserRule__Group_2_2__0 )?
            {
             before(grammarAccess.getParserRuleAccess().getGroup_2_2()); 
            // InternalXtext.g:3552:2: ( rule__ParserRule__Group_2_2__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_ID||(LA40_0>=16 && LA40_0<=17)) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalXtext.g:3552:3: rule__ParserRule__Group_2_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3560:1: rule__ParserRule__Group_2__3 : rule__ParserRule__Group_2__3__Impl ;
    public final void rule__ParserRule__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3564:1: ( rule__ParserRule__Group_2__3__Impl )
            // InternalXtext.g:3565:2: rule__ParserRule__Group_2__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3571:1: rule__ParserRule__Group_2__3__Impl : ( ')' ) ;
    public final void rule__ParserRule__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3575:1: ( ( ')' ) )
            // InternalXtext.g:3576:1: ( ')' )
            {
            // InternalXtext.g:3576:1: ( ')' )
            // InternalXtext.g:3577:2: ')'
            {
             before(grammarAccess.getParserRuleAccess().getRightParenthesisKeyword_2_3()); 
            match(input,23,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:3587:1: rule__ParserRule__Group_2_2__0 : rule__ParserRule__Group_2_2__0__Impl rule__ParserRule__Group_2_2__1 ;
    public final void rule__ParserRule__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3591:1: ( rule__ParserRule__Group_2_2__0__Impl rule__ParserRule__Group_2_2__1 )
            // InternalXtext.g:3592:2: rule__ParserRule__Group_2_2__0__Impl rule__ParserRule__Group_2_2__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__ParserRule__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3599:1: rule__ParserRule__Group_2_2__0__Impl : ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) ) ;
    public final void rule__ParserRule__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3603:1: ( ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) ) )
            // InternalXtext.g:3604:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) )
            {
            // InternalXtext.g:3604:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) )
            // InternalXtext.g:3605:2: ( rule__ParserRule__HiddenTokensAssignment_2_2_0 )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_2_2_0()); 
            // InternalXtext.g:3606:2: ( rule__ParserRule__HiddenTokensAssignment_2_2_0 )
            // InternalXtext.g:3606:3: rule__ParserRule__HiddenTokensAssignment_2_2_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3614:1: rule__ParserRule__Group_2_2__1 : rule__ParserRule__Group_2_2__1__Impl ;
    public final void rule__ParserRule__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3618:1: ( rule__ParserRule__Group_2_2__1__Impl )
            // InternalXtext.g:3619:2: rule__ParserRule__Group_2_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3625:1: rule__ParserRule__Group_2_2__1__Impl : ( ( rule__ParserRule__Group_2_2_1__0 )* ) ;
    public final void rule__ParserRule__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3629:1: ( ( ( rule__ParserRule__Group_2_2_1__0 )* ) )
            // InternalXtext.g:3630:1: ( ( rule__ParserRule__Group_2_2_1__0 )* )
            {
            // InternalXtext.g:3630:1: ( ( rule__ParserRule__Group_2_2_1__0 )* )
            // InternalXtext.g:3631:2: ( rule__ParserRule__Group_2_2_1__0 )*
            {
             before(grammarAccess.getParserRuleAccess().getGroup_2_2_1()); 
            // InternalXtext.g:3632:2: ( rule__ParserRule__Group_2_2_1__0 )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==21) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalXtext.g:3632:3: rule__ParserRule__Group_2_2_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    rule__ParserRule__Group_2_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop41;
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
    // InternalXtext.g:3641:1: rule__ParserRule__Group_2_2_1__0 : rule__ParserRule__Group_2_2_1__0__Impl rule__ParserRule__Group_2_2_1__1 ;
    public final void rule__ParserRule__Group_2_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3645:1: ( rule__ParserRule__Group_2_2_1__0__Impl rule__ParserRule__Group_2_2_1__1 )
            // InternalXtext.g:3646:2: rule__ParserRule__Group_2_2_1__0__Impl rule__ParserRule__Group_2_2_1__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__ParserRule__Group_2_2_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3653:1: rule__ParserRule__Group_2_2_1__0__Impl : ( ',' ) ;
    public final void rule__ParserRule__Group_2_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3657:1: ( ( ',' ) )
            // InternalXtext.g:3658:1: ( ',' )
            {
            // InternalXtext.g:3658:1: ( ',' )
            // InternalXtext.g:3659:2: ','
            {
             before(grammarAccess.getParserRuleAccess().getCommaKeyword_2_2_1_0()); 
            match(input,21,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:3668:1: rule__ParserRule__Group_2_2_1__1 : rule__ParserRule__Group_2_2_1__1__Impl ;
    public final void rule__ParserRule__Group_2_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3672:1: ( rule__ParserRule__Group_2_2_1__1__Impl )
            // InternalXtext.g:3673:2: rule__ParserRule__Group_2_2_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:3679:1: rule__ParserRule__Group_2_2_1__1__Impl : ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) ) ;
    public final void rule__ParserRule__Group_2_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3683:1: ( ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) ) )
            // InternalXtext.g:3684:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) )
            {
            // InternalXtext.g:3684:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) )
            // InternalXtext.g:3685:2: ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_2_2_1_1()); 
            // InternalXtext.g:3686:2: ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 )
            // InternalXtext.g:3686:3: rule__ParserRule__HiddenTokensAssignment_2_2_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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


    // $ANTLR start "rule__RuleNameAndParams__Group__0"
    // InternalXtext.g:3695:1: rule__RuleNameAndParams__Group__0 : rule__RuleNameAndParams__Group__0__Impl rule__RuleNameAndParams__Group__1 ;
    public final void rule__RuleNameAndParams__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3699:1: ( rule__RuleNameAndParams__Group__0__Impl rule__RuleNameAndParams__Group__1 )
            // InternalXtext.g:3700:2: rule__RuleNameAndParams__Group__0__Impl rule__RuleNameAndParams__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_23);
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
    // InternalXtext.g:3707:1: rule__RuleNameAndParams__Group__0__Impl : ( ( rule__RuleNameAndParams__NameAssignment_0 ) ) ;
    public final void rule__RuleNameAndParams__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3711:1: ( ( ( rule__RuleNameAndParams__NameAssignment_0 ) ) )
            // InternalXtext.g:3712:1: ( ( rule__RuleNameAndParams__NameAssignment_0 ) )
            {
            // InternalXtext.g:3712:1: ( ( rule__RuleNameAndParams__NameAssignment_0 ) )
            // InternalXtext.g:3713:2: ( rule__RuleNameAndParams__NameAssignment_0 )
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getNameAssignment_0()); 
            // InternalXtext.g:3714:2: ( rule__RuleNameAndParams__NameAssignment_0 )
            // InternalXtext.g:3714:3: rule__RuleNameAndParams__NameAssignment_0
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
    // InternalXtext.g:3722:1: rule__RuleNameAndParams__Group__1 : rule__RuleNameAndParams__Group__1__Impl ;
    public final void rule__RuleNameAndParams__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3726:1: ( rule__RuleNameAndParams__Group__1__Impl )
            // InternalXtext.g:3727:2: rule__RuleNameAndParams__Group__1__Impl
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
    // InternalXtext.g:3733:1: rule__RuleNameAndParams__Group__1__Impl : ( ( rule__RuleNameAndParams__Group_1__0 )? ) ;
    public final void rule__RuleNameAndParams__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3737:1: ( ( ( rule__RuleNameAndParams__Group_1__0 )? ) )
            // InternalXtext.g:3738:1: ( ( rule__RuleNameAndParams__Group_1__0 )? )
            {
            // InternalXtext.g:3738:1: ( ( rule__RuleNameAndParams__Group_1__0 )? )
            // InternalXtext.g:3739:2: ( rule__RuleNameAndParams__Group_1__0 )?
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getGroup_1()); 
            // InternalXtext.g:3740:2: ( rule__RuleNameAndParams__Group_1__0 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==32) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalXtext.g:3740:3: rule__RuleNameAndParams__Group_1__0
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
    // InternalXtext.g:3749:1: rule__RuleNameAndParams__Group_1__0 : rule__RuleNameAndParams__Group_1__0__Impl rule__RuleNameAndParams__Group_1__1 ;
    public final void rule__RuleNameAndParams__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3753:1: ( rule__RuleNameAndParams__Group_1__0__Impl rule__RuleNameAndParams__Group_1__1 )
            // InternalXtext.g:3754:2: rule__RuleNameAndParams__Group_1__0__Impl rule__RuleNameAndParams__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_24);
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
    // InternalXtext.g:3761:1: rule__RuleNameAndParams__Group_1__0__Impl : ( '<' ) ;
    public final void rule__RuleNameAndParams__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3765:1: ( ( '<' ) )
            // InternalXtext.g:3766:1: ( '<' )
            {
            // InternalXtext.g:3766:1: ( '<' )
            // InternalXtext.g:3767:2: '<'
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getLessThanSignKeyword_1_0()); 
            match(input,32,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:3776:1: rule__RuleNameAndParams__Group_1__1 : rule__RuleNameAndParams__Group_1__1__Impl rule__RuleNameAndParams__Group_1__2 ;
    public final void rule__RuleNameAndParams__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3780:1: ( rule__RuleNameAndParams__Group_1__1__Impl rule__RuleNameAndParams__Group_1__2 )
            // InternalXtext.g:3781:2: rule__RuleNameAndParams__Group_1__1__Impl rule__RuleNameAndParams__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_24);
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
    // InternalXtext.g:3788:1: rule__RuleNameAndParams__Group_1__1__Impl : ( ( rule__RuleNameAndParams__Group_1_1__0 )? ) ;
    public final void rule__RuleNameAndParams__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3792:1: ( ( ( rule__RuleNameAndParams__Group_1_1__0 )? ) )
            // InternalXtext.g:3793:1: ( ( rule__RuleNameAndParams__Group_1_1__0 )? )
            {
            // InternalXtext.g:3793:1: ( ( rule__RuleNameAndParams__Group_1_1__0 )? )
            // InternalXtext.g:3794:2: ( rule__RuleNameAndParams__Group_1_1__0 )?
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getGroup_1_1()); 
            // InternalXtext.g:3795:2: ( rule__RuleNameAndParams__Group_1_1__0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==RULE_ID) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalXtext.g:3795:3: rule__RuleNameAndParams__Group_1_1__0
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
    // InternalXtext.g:3803:1: rule__RuleNameAndParams__Group_1__2 : rule__RuleNameAndParams__Group_1__2__Impl ;
    public final void rule__RuleNameAndParams__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3807:1: ( rule__RuleNameAndParams__Group_1__2__Impl )
            // InternalXtext.g:3808:2: rule__RuleNameAndParams__Group_1__2__Impl
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
    // InternalXtext.g:3814:1: rule__RuleNameAndParams__Group_1__2__Impl : ( '>' ) ;
    public final void rule__RuleNameAndParams__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3818:1: ( ( '>' ) )
            // InternalXtext.g:3819:1: ( '>' )
            {
            // InternalXtext.g:3819:1: ( '>' )
            // InternalXtext.g:3820:2: '>'
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getGreaterThanSignKeyword_1_2()); 
            match(input,33,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:3830:1: rule__RuleNameAndParams__Group_1_1__0 : rule__RuleNameAndParams__Group_1_1__0__Impl rule__RuleNameAndParams__Group_1_1__1 ;
    public final void rule__RuleNameAndParams__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3834:1: ( rule__RuleNameAndParams__Group_1_1__0__Impl rule__RuleNameAndParams__Group_1_1__1 )
            // InternalXtext.g:3835:2: rule__RuleNameAndParams__Group_1_1__0__Impl rule__RuleNameAndParams__Group_1_1__1
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
    // InternalXtext.g:3842:1: rule__RuleNameAndParams__Group_1_1__0__Impl : ( ( rule__RuleNameAndParams__ParametersAssignment_1_1_0 ) ) ;
    public final void rule__RuleNameAndParams__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3846:1: ( ( ( rule__RuleNameAndParams__ParametersAssignment_1_1_0 ) ) )
            // InternalXtext.g:3847:1: ( ( rule__RuleNameAndParams__ParametersAssignment_1_1_0 ) )
            {
            // InternalXtext.g:3847:1: ( ( rule__RuleNameAndParams__ParametersAssignment_1_1_0 ) )
            // InternalXtext.g:3848:2: ( rule__RuleNameAndParams__ParametersAssignment_1_1_0 )
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getParametersAssignment_1_1_0()); 
            // InternalXtext.g:3849:2: ( rule__RuleNameAndParams__ParametersAssignment_1_1_0 )
            // InternalXtext.g:3849:3: rule__RuleNameAndParams__ParametersAssignment_1_1_0
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
    // InternalXtext.g:3857:1: rule__RuleNameAndParams__Group_1_1__1 : rule__RuleNameAndParams__Group_1_1__1__Impl ;
    public final void rule__RuleNameAndParams__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3861:1: ( rule__RuleNameAndParams__Group_1_1__1__Impl )
            // InternalXtext.g:3862:2: rule__RuleNameAndParams__Group_1_1__1__Impl
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
    // InternalXtext.g:3868:1: rule__RuleNameAndParams__Group_1_1__1__Impl : ( ( rule__RuleNameAndParams__Group_1_1_1__0 )* ) ;
    public final void rule__RuleNameAndParams__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3872:1: ( ( ( rule__RuleNameAndParams__Group_1_1_1__0 )* ) )
            // InternalXtext.g:3873:1: ( ( rule__RuleNameAndParams__Group_1_1_1__0 )* )
            {
            // InternalXtext.g:3873:1: ( ( rule__RuleNameAndParams__Group_1_1_1__0 )* )
            // InternalXtext.g:3874:2: ( rule__RuleNameAndParams__Group_1_1_1__0 )*
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getGroup_1_1_1()); 
            // InternalXtext.g:3875:2: ( rule__RuleNameAndParams__Group_1_1_1__0 )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==21) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalXtext.g:3875:3: rule__RuleNameAndParams__Group_1_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    rule__RuleNameAndParams__Group_1_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop44;
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
    // InternalXtext.g:3884:1: rule__RuleNameAndParams__Group_1_1_1__0 : rule__RuleNameAndParams__Group_1_1_1__0__Impl rule__RuleNameAndParams__Group_1_1_1__1 ;
    public final void rule__RuleNameAndParams__Group_1_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3888:1: ( rule__RuleNameAndParams__Group_1_1_1__0__Impl rule__RuleNameAndParams__Group_1_1_1__1 )
            // InternalXtext.g:3889:2: rule__RuleNameAndParams__Group_1_1_1__0__Impl rule__RuleNameAndParams__Group_1_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_15);
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
    // InternalXtext.g:3896:1: rule__RuleNameAndParams__Group_1_1_1__0__Impl : ( ',' ) ;
    public final void rule__RuleNameAndParams__Group_1_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3900:1: ( ( ',' ) )
            // InternalXtext.g:3901:1: ( ',' )
            {
            // InternalXtext.g:3901:1: ( ',' )
            // InternalXtext.g:3902:2: ','
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
    // InternalXtext.g:3911:1: rule__RuleNameAndParams__Group_1_1_1__1 : rule__RuleNameAndParams__Group_1_1_1__1__Impl ;
    public final void rule__RuleNameAndParams__Group_1_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3915:1: ( rule__RuleNameAndParams__Group_1_1_1__1__Impl )
            // InternalXtext.g:3916:2: rule__RuleNameAndParams__Group_1_1_1__1__Impl
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
    // InternalXtext.g:3922:1: rule__RuleNameAndParams__Group_1_1_1__1__Impl : ( ( rule__RuleNameAndParams__ParametersAssignment_1_1_1_1 ) ) ;
    public final void rule__RuleNameAndParams__Group_1_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3926:1: ( ( ( rule__RuleNameAndParams__ParametersAssignment_1_1_1_1 ) ) )
            // InternalXtext.g:3927:1: ( ( rule__RuleNameAndParams__ParametersAssignment_1_1_1_1 ) )
            {
            // InternalXtext.g:3927:1: ( ( rule__RuleNameAndParams__ParametersAssignment_1_1_1_1 ) )
            // InternalXtext.g:3928:2: ( rule__RuleNameAndParams__ParametersAssignment_1_1_1_1 )
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getParametersAssignment_1_1_1_1()); 
            // InternalXtext.g:3929:2: ( rule__RuleNameAndParams__ParametersAssignment_1_1_1_1 )
            // InternalXtext.g:3929:3: rule__RuleNameAndParams__ParametersAssignment_1_1_1_1
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
    // InternalXtext.g:3938:1: rule__TypeRef__Group__0 : rule__TypeRef__Group__0__Impl rule__TypeRef__Group__1 ;
    public final void rule__TypeRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3942:1: ( rule__TypeRef__Group__0__Impl rule__TypeRef__Group__1 )
            // InternalXtext.g:3943:2: rule__TypeRef__Group__0__Impl rule__TypeRef__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_15);
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
    // InternalXtext.g:3950:1: rule__TypeRef__Group__0__Impl : ( ( rule__TypeRef__Group_0__0 )? ) ;
    public final void rule__TypeRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3954:1: ( ( ( rule__TypeRef__Group_0__0 )? ) )
            // InternalXtext.g:3955:1: ( ( rule__TypeRef__Group_0__0 )? )
            {
            // InternalXtext.g:3955:1: ( ( rule__TypeRef__Group_0__0 )? )
            // InternalXtext.g:3956:2: ( rule__TypeRef__Group_0__0 )?
            {
             before(grammarAccess.getTypeRefAccess().getGroup_0()); 
            // InternalXtext.g:3957:2: ( rule__TypeRef__Group_0__0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_ID) ) {
                int LA45_1 = input.LA(2);

                if ( (LA45_1==34) ) {
                    alt45=1;
                }
            }
            switch (alt45) {
                case 1 :
                    // InternalXtext.g:3957:3: rule__TypeRef__Group_0__0
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
    // InternalXtext.g:3965:1: rule__TypeRef__Group__1 : rule__TypeRef__Group__1__Impl ;
    public final void rule__TypeRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3969:1: ( rule__TypeRef__Group__1__Impl )
            // InternalXtext.g:3970:2: rule__TypeRef__Group__1__Impl
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
    // InternalXtext.g:3976:1: rule__TypeRef__Group__1__Impl : ( ( rule__TypeRef__ClassifierAssignment_1 ) ) ;
    public final void rule__TypeRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3980:1: ( ( ( rule__TypeRef__ClassifierAssignment_1 ) ) )
            // InternalXtext.g:3981:1: ( ( rule__TypeRef__ClassifierAssignment_1 ) )
            {
            // InternalXtext.g:3981:1: ( ( rule__TypeRef__ClassifierAssignment_1 ) )
            // InternalXtext.g:3982:2: ( rule__TypeRef__ClassifierAssignment_1 )
            {
             before(grammarAccess.getTypeRefAccess().getClassifierAssignment_1()); 
            // InternalXtext.g:3983:2: ( rule__TypeRef__ClassifierAssignment_1 )
            // InternalXtext.g:3983:3: rule__TypeRef__ClassifierAssignment_1
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
    // InternalXtext.g:3992:1: rule__TypeRef__Group_0__0 : rule__TypeRef__Group_0__0__Impl rule__TypeRef__Group_0__1 ;
    public final void rule__TypeRef__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3996:1: ( rule__TypeRef__Group_0__0__Impl rule__TypeRef__Group_0__1 )
            // InternalXtext.g:3997:2: rule__TypeRef__Group_0__0__Impl rule__TypeRef__Group_0__1
            {
            pushFollow(FollowSets000.FOLLOW_25);
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
    // InternalXtext.g:4004:1: rule__TypeRef__Group_0__0__Impl : ( ( rule__TypeRef__MetamodelAssignment_0_0 ) ) ;
    public final void rule__TypeRef__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4008:1: ( ( ( rule__TypeRef__MetamodelAssignment_0_0 ) ) )
            // InternalXtext.g:4009:1: ( ( rule__TypeRef__MetamodelAssignment_0_0 ) )
            {
            // InternalXtext.g:4009:1: ( ( rule__TypeRef__MetamodelAssignment_0_0 ) )
            // InternalXtext.g:4010:2: ( rule__TypeRef__MetamodelAssignment_0_0 )
            {
             before(grammarAccess.getTypeRefAccess().getMetamodelAssignment_0_0()); 
            // InternalXtext.g:4011:2: ( rule__TypeRef__MetamodelAssignment_0_0 )
            // InternalXtext.g:4011:3: rule__TypeRef__MetamodelAssignment_0_0
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
    // InternalXtext.g:4019:1: rule__TypeRef__Group_0__1 : rule__TypeRef__Group_0__1__Impl ;
    public final void rule__TypeRef__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4023:1: ( rule__TypeRef__Group_0__1__Impl )
            // InternalXtext.g:4024:2: rule__TypeRef__Group_0__1__Impl
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
    // InternalXtext.g:4030:1: rule__TypeRef__Group_0__1__Impl : ( '::' ) ;
    public final void rule__TypeRef__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4034:1: ( ( '::' ) )
            // InternalXtext.g:4035:1: ( '::' )
            {
            // InternalXtext.g:4035:1: ( '::' )
            // InternalXtext.g:4036:2: '::'
            {
             before(grammarAccess.getTypeRefAccess().getColonColonKeyword_0_1()); 
            match(input,34,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:4046:1: rule__Alternatives__Group__0 : rule__Alternatives__Group__0__Impl rule__Alternatives__Group__1 ;
    public final void rule__Alternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4050:1: ( rule__Alternatives__Group__0__Impl rule__Alternatives__Group__1 )
            // InternalXtext.g:4051:2: rule__Alternatives__Group__0__Impl rule__Alternatives__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_26);
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
    // InternalXtext.g:4058:1: rule__Alternatives__Group__0__Impl : ( ruleConditionalBranch ) ;
    public final void rule__Alternatives__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4062:1: ( ( ruleConditionalBranch ) )
            // InternalXtext.g:4063:1: ( ruleConditionalBranch )
            {
            // InternalXtext.g:4063:1: ( ruleConditionalBranch )
            // InternalXtext.g:4064:2: ruleConditionalBranch
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
    // InternalXtext.g:4073:1: rule__Alternatives__Group__1 : rule__Alternatives__Group__1__Impl ;
    public final void rule__Alternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4077:1: ( rule__Alternatives__Group__1__Impl )
            // InternalXtext.g:4078:2: rule__Alternatives__Group__1__Impl
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
    // InternalXtext.g:4084:1: rule__Alternatives__Group__1__Impl : ( ( rule__Alternatives__Group_1__0 )? ) ;
    public final void rule__Alternatives__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4088:1: ( ( ( rule__Alternatives__Group_1__0 )? ) )
            // InternalXtext.g:4089:1: ( ( rule__Alternatives__Group_1__0 )? )
            {
            // InternalXtext.g:4089:1: ( ( rule__Alternatives__Group_1__0 )? )
            // InternalXtext.g:4090:2: ( rule__Alternatives__Group_1__0 )?
            {
             before(grammarAccess.getAlternativesAccess().getGroup_1()); 
            // InternalXtext.g:4091:2: ( rule__Alternatives__Group_1__0 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==35) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalXtext.g:4091:3: rule__Alternatives__Group_1__0
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
    // InternalXtext.g:4100:1: rule__Alternatives__Group_1__0 : rule__Alternatives__Group_1__0__Impl rule__Alternatives__Group_1__1 ;
    public final void rule__Alternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4104:1: ( rule__Alternatives__Group_1__0__Impl rule__Alternatives__Group_1__1 )
            // InternalXtext.g:4105:2: rule__Alternatives__Group_1__0__Impl rule__Alternatives__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_26);
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
    // InternalXtext.g:4112:1: rule__Alternatives__Group_1__0__Impl : ( () ) ;
    public final void rule__Alternatives__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4116:1: ( ( () ) )
            // InternalXtext.g:4117:1: ( () )
            {
            // InternalXtext.g:4117:1: ( () )
            // InternalXtext.g:4118:2: ()
            {
             before(grammarAccess.getAlternativesAccess().getAlternativesElementsAction_1_0()); 
            // InternalXtext.g:4119:2: ()
            // InternalXtext.g:4119:3: 
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
    // InternalXtext.g:4127:1: rule__Alternatives__Group_1__1 : rule__Alternatives__Group_1__1__Impl ;
    public final void rule__Alternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4131:1: ( rule__Alternatives__Group_1__1__Impl )
            // InternalXtext.g:4132:2: rule__Alternatives__Group_1__1__Impl
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
    // InternalXtext.g:4138:1: rule__Alternatives__Group_1__1__Impl : ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) ) ;
    public final void rule__Alternatives__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4142:1: ( ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) ) )
            // InternalXtext.g:4143:1: ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) )
            {
            // InternalXtext.g:4143:1: ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) )
            // InternalXtext.g:4144:2: ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* )
            {
            // InternalXtext.g:4144:2: ( ( rule__Alternatives__Group_1_1__0 ) )
            // InternalXtext.g:4145:3: ( rule__Alternatives__Group_1_1__0 )
            {
             before(grammarAccess.getAlternativesAccess().getGroup_1_1()); 
            // InternalXtext.g:4146:3: ( rule__Alternatives__Group_1_1__0 )
            // InternalXtext.g:4146:4: rule__Alternatives__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_27);
            rule__Alternatives__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getAlternativesAccess().getGroup_1_1()); 

            }

            // InternalXtext.g:4149:2: ( ( rule__Alternatives__Group_1_1__0 )* )
            // InternalXtext.g:4150:3: ( rule__Alternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getAlternativesAccess().getGroup_1_1()); 
            // InternalXtext.g:4151:3: ( rule__Alternatives__Group_1_1__0 )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==35) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalXtext.g:4151:4: rule__Alternatives__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_27);
            	    rule__Alternatives__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop47;
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
    // InternalXtext.g:4161:1: rule__Alternatives__Group_1_1__0 : rule__Alternatives__Group_1_1__0__Impl rule__Alternatives__Group_1_1__1 ;
    public final void rule__Alternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4165:1: ( rule__Alternatives__Group_1_1__0__Impl rule__Alternatives__Group_1_1__1 )
            // InternalXtext.g:4166:2: rule__Alternatives__Group_1_1__0__Impl rule__Alternatives__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_19);
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
    // InternalXtext.g:4173:1: rule__Alternatives__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__Alternatives__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4177:1: ( ( '|' ) )
            // InternalXtext.g:4178:1: ( '|' )
            {
            // InternalXtext.g:4178:1: ( '|' )
            // InternalXtext.g:4179:2: '|'
            {
             before(grammarAccess.getAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,35,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:4188:1: rule__Alternatives__Group_1_1__1 : rule__Alternatives__Group_1_1__1__Impl ;
    public final void rule__Alternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4192:1: ( rule__Alternatives__Group_1_1__1__Impl )
            // InternalXtext.g:4193:2: rule__Alternatives__Group_1_1__1__Impl
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
    // InternalXtext.g:4199:1: rule__Alternatives__Group_1_1__1__Impl : ( ( rule__Alternatives__ElementsAssignment_1_1_1 ) ) ;
    public final void rule__Alternatives__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4203:1: ( ( ( rule__Alternatives__ElementsAssignment_1_1_1 ) ) )
            // InternalXtext.g:4204:1: ( ( rule__Alternatives__ElementsAssignment_1_1_1 ) )
            {
            // InternalXtext.g:4204:1: ( ( rule__Alternatives__ElementsAssignment_1_1_1 ) )
            // InternalXtext.g:4205:2: ( rule__Alternatives__ElementsAssignment_1_1_1 )
            {
             before(grammarAccess.getAlternativesAccess().getElementsAssignment_1_1_1()); 
            // InternalXtext.g:4206:2: ( rule__Alternatives__ElementsAssignment_1_1_1 )
            // InternalXtext.g:4206:3: rule__Alternatives__ElementsAssignment_1_1_1
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
    // InternalXtext.g:4215:1: rule__ConditionalBranch__Group_1__0 : rule__ConditionalBranch__Group_1__0__Impl rule__ConditionalBranch__Group_1__1 ;
    public final void rule__ConditionalBranch__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4219:1: ( rule__ConditionalBranch__Group_1__0__Impl rule__ConditionalBranch__Group_1__1 )
            // InternalXtext.g:4220:2: rule__ConditionalBranch__Group_1__0__Impl rule__ConditionalBranch__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_19);
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
    // InternalXtext.g:4227:1: rule__ConditionalBranch__Group_1__0__Impl : ( () ) ;
    public final void rule__ConditionalBranch__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4231:1: ( ( () ) )
            // InternalXtext.g:4232:1: ( () )
            {
            // InternalXtext.g:4232:1: ( () )
            // InternalXtext.g:4233:2: ()
            {
             before(grammarAccess.getConditionalBranchAccess().getGroupAction_1_0()); 
            // InternalXtext.g:4234:2: ()
            // InternalXtext.g:4234:3: 
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
    // InternalXtext.g:4242:1: rule__ConditionalBranch__Group_1__1 : rule__ConditionalBranch__Group_1__1__Impl rule__ConditionalBranch__Group_1__2 ;
    public final void rule__ConditionalBranch__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4246:1: ( rule__ConditionalBranch__Group_1__1__Impl rule__ConditionalBranch__Group_1__2 )
            // InternalXtext.g:4247:2: rule__ConditionalBranch__Group_1__1__Impl rule__ConditionalBranch__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_28);
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
    // InternalXtext.g:4254:1: rule__ConditionalBranch__Group_1__1__Impl : ( '<' ) ;
    public final void rule__ConditionalBranch__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4258:1: ( ( '<' ) )
            // InternalXtext.g:4259:1: ( '<' )
            {
            // InternalXtext.g:4259:1: ( '<' )
            // InternalXtext.g:4260:2: '<'
            {
             before(grammarAccess.getConditionalBranchAccess().getLessThanSignKeyword_1_1()); 
            match(input,32,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:4269:1: rule__ConditionalBranch__Group_1__2 : rule__ConditionalBranch__Group_1__2__Impl rule__ConditionalBranch__Group_1__3 ;
    public final void rule__ConditionalBranch__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4273:1: ( rule__ConditionalBranch__Group_1__2__Impl rule__ConditionalBranch__Group_1__3 )
            // InternalXtext.g:4274:2: rule__ConditionalBranch__Group_1__2__Impl rule__ConditionalBranch__Group_1__3
            {
            pushFollow(FollowSets000.FOLLOW_29);
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
    // InternalXtext.g:4281:1: rule__ConditionalBranch__Group_1__2__Impl : ( ( rule__ConditionalBranch__GuardConditionAssignment_1_2 ) ) ;
    public final void rule__ConditionalBranch__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4285:1: ( ( ( rule__ConditionalBranch__GuardConditionAssignment_1_2 ) ) )
            // InternalXtext.g:4286:1: ( ( rule__ConditionalBranch__GuardConditionAssignment_1_2 ) )
            {
            // InternalXtext.g:4286:1: ( ( rule__ConditionalBranch__GuardConditionAssignment_1_2 ) )
            // InternalXtext.g:4287:2: ( rule__ConditionalBranch__GuardConditionAssignment_1_2 )
            {
             before(grammarAccess.getConditionalBranchAccess().getGuardConditionAssignment_1_2()); 
            // InternalXtext.g:4288:2: ( rule__ConditionalBranch__GuardConditionAssignment_1_2 )
            // InternalXtext.g:4288:3: rule__ConditionalBranch__GuardConditionAssignment_1_2
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
    // InternalXtext.g:4296:1: rule__ConditionalBranch__Group_1__3 : rule__ConditionalBranch__Group_1__3__Impl rule__ConditionalBranch__Group_1__4 ;
    public final void rule__ConditionalBranch__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4300:1: ( rule__ConditionalBranch__Group_1__3__Impl rule__ConditionalBranch__Group_1__4 )
            // InternalXtext.g:4301:2: rule__ConditionalBranch__Group_1__3__Impl rule__ConditionalBranch__Group_1__4
            {
            pushFollow(FollowSets000.FOLLOW_30);
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
    // InternalXtext.g:4308:1: rule__ConditionalBranch__Group_1__3__Impl : ( '>' ) ;
    public final void rule__ConditionalBranch__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4312:1: ( ( '>' ) )
            // InternalXtext.g:4313:1: ( '>' )
            {
            // InternalXtext.g:4313:1: ( '>' )
            // InternalXtext.g:4314:2: '>'
            {
             before(grammarAccess.getConditionalBranchAccess().getGreaterThanSignKeyword_1_3()); 
            match(input,33,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:4323:1: rule__ConditionalBranch__Group_1__4 : rule__ConditionalBranch__Group_1__4__Impl ;
    public final void rule__ConditionalBranch__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4327:1: ( rule__ConditionalBranch__Group_1__4__Impl )
            // InternalXtext.g:4328:2: rule__ConditionalBranch__Group_1__4__Impl
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
    // InternalXtext.g:4334:1: rule__ConditionalBranch__Group_1__4__Impl : ( ( ( rule__ConditionalBranch__ElementsAssignment_1_4 ) ) ( ( rule__ConditionalBranch__ElementsAssignment_1_4 )* ) ) ;
    public final void rule__ConditionalBranch__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4338:1: ( ( ( ( rule__ConditionalBranch__ElementsAssignment_1_4 ) ) ( ( rule__ConditionalBranch__ElementsAssignment_1_4 )* ) ) )
            // InternalXtext.g:4339:1: ( ( ( rule__ConditionalBranch__ElementsAssignment_1_4 ) ) ( ( rule__ConditionalBranch__ElementsAssignment_1_4 )* ) )
            {
            // InternalXtext.g:4339:1: ( ( ( rule__ConditionalBranch__ElementsAssignment_1_4 ) ) ( ( rule__ConditionalBranch__ElementsAssignment_1_4 )* ) )
            // InternalXtext.g:4340:2: ( ( rule__ConditionalBranch__ElementsAssignment_1_4 ) ) ( ( rule__ConditionalBranch__ElementsAssignment_1_4 )* )
            {
            // InternalXtext.g:4340:2: ( ( rule__ConditionalBranch__ElementsAssignment_1_4 ) )
            // InternalXtext.g:4341:3: ( rule__ConditionalBranch__ElementsAssignment_1_4 )
            {
             before(grammarAccess.getConditionalBranchAccess().getElementsAssignment_1_4()); 
            // InternalXtext.g:4342:3: ( rule__ConditionalBranch__ElementsAssignment_1_4 )
            // InternalXtext.g:4342:4: rule__ConditionalBranch__ElementsAssignment_1_4
            {
            pushFollow(FollowSets000.FOLLOW_31);
            rule__ConditionalBranch__ElementsAssignment_1_4();

            state._fsp--;


            }

             after(grammarAccess.getConditionalBranchAccess().getElementsAssignment_1_4()); 

            }

            // InternalXtext.g:4345:2: ( ( rule__ConditionalBranch__ElementsAssignment_1_4 )* )
            // InternalXtext.g:4346:3: ( rule__ConditionalBranch__ElementsAssignment_1_4 )*
            {
             before(grammarAccess.getConditionalBranchAccess().getElementsAssignment_1_4()); 
            // InternalXtext.g:4347:3: ( rule__ConditionalBranch__ElementsAssignment_1_4 )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( ((LA48_0>=RULE_ID && LA48_0<=RULE_STRING)||(LA48_0>=16 && LA48_0<=17)||LA48_0==22||LA48_0==37||LA48_0==44||LA48_0==50) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalXtext.g:4347:4: rule__ConditionalBranch__ElementsAssignment_1_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_31);
            	    rule__ConditionalBranch__ElementsAssignment_1_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop48;
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
    // InternalXtext.g:4357:1: rule__UnorderedGroup__Group__0 : rule__UnorderedGroup__Group__0__Impl rule__UnorderedGroup__Group__1 ;
    public final void rule__UnorderedGroup__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4361:1: ( rule__UnorderedGroup__Group__0__Impl rule__UnorderedGroup__Group__1 )
            // InternalXtext.g:4362:2: rule__UnorderedGroup__Group__0__Impl rule__UnorderedGroup__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_32);
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
    // InternalXtext.g:4369:1: rule__UnorderedGroup__Group__0__Impl : ( ruleGroup ) ;
    public final void rule__UnorderedGroup__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4373:1: ( ( ruleGroup ) )
            // InternalXtext.g:4374:1: ( ruleGroup )
            {
            // InternalXtext.g:4374:1: ( ruleGroup )
            // InternalXtext.g:4375:2: ruleGroup
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
    // InternalXtext.g:4384:1: rule__UnorderedGroup__Group__1 : rule__UnorderedGroup__Group__1__Impl ;
    public final void rule__UnorderedGroup__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4388:1: ( rule__UnorderedGroup__Group__1__Impl )
            // InternalXtext.g:4389:2: rule__UnorderedGroup__Group__1__Impl
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
    // InternalXtext.g:4395:1: rule__UnorderedGroup__Group__1__Impl : ( ( rule__UnorderedGroup__Group_1__0 )? ) ;
    public final void rule__UnorderedGroup__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4399:1: ( ( ( rule__UnorderedGroup__Group_1__0 )? ) )
            // InternalXtext.g:4400:1: ( ( rule__UnorderedGroup__Group_1__0 )? )
            {
            // InternalXtext.g:4400:1: ( ( rule__UnorderedGroup__Group_1__0 )? )
            // InternalXtext.g:4401:2: ( rule__UnorderedGroup__Group_1__0 )?
            {
             before(grammarAccess.getUnorderedGroupAccess().getGroup_1()); 
            // InternalXtext.g:4402:2: ( rule__UnorderedGroup__Group_1__0 )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==36) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalXtext.g:4402:3: rule__UnorderedGroup__Group_1__0
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
    // InternalXtext.g:4411:1: rule__UnorderedGroup__Group_1__0 : rule__UnorderedGroup__Group_1__0__Impl rule__UnorderedGroup__Group_1__1 ;
    public final void rule__UnorderedGroup__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4415:1: ( rule__UnorderedGroup__Group_1__0__Impl rule__UnorderedGroup__Group_1__1 )
            // InternalXtext.g:4416:2: rule__UnorderedGroup__Group_1__0__Impl rule__UnorderedGroup__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_32);
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
    // InternalXtext.g:4423:1: rule__UnorderedGroup__Group_1__0__Impl : ( () ) ;
    public final void rule__UnorderedGroup__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4427:1: ( ( () ) )
            // InternalXtext.g:4428:1: ( () )
            {
            // InternalXtext.g:4428:1: ( () )
            // InternalXtext.g:4429:2: ()
            {
             before(grammarAccess.getUnorderedGroupAccess().getUnorderedGroupElementsAction_1_0()); 
            // InternalXtext.g:4430:2: ()
            // InternalXtext.g:4430:3: 
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
    // InternalXtext.g:4438:1: rule__UnorderedGroup__Group_1__1 : rule__UnorderedGroup__Group_1__1__Impl ;
    public final void rule__UnorderedGroup__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4442:1: ( rule__UnorderedGroup__Group_1__1__Impl )
            // InternalXtext.g:4443:2: rule__UnorderedGroup__Group_1__1__Impl
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
    // InternalXtext.g:4449:1: rule__UnorderedGroup__Group_1__1__Impl : ( ( ( rule__UnorderedGroup__Group_1_1__0 ) ) ( ( rule__UnorderedGroup__Group_1_1__0 )* ) ) ;
    public final void rule__UnorderedGroup__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4453:1: ( ( ( ( rule__UnorderedGroup__Group_1_1__0 ) ) ( ( rule__UnorderedGroup__Group_1_1__0 )* ) ) )
            // InternalXtext.g:4454:1: ( ( ( rule__UnorderedGroup__Group_1_1__0 ) ) ( ( rule__UnorderedGroup__Group_1_1__0 )* ) )
            {
            // InternalXtext.g:4454:1: ( ( ( rule__UnorderedGroup__Group_1_1__0 ) ) ( ( rule__UnorderedGroup__Group_1_1__0 )* ) )
            // InternalXtext.g:4455:2: ( ( rule__UnorderedGroup__Group_1_1__0 ) ) ( ( rule__UnorderedGroup__Group_1_1__0 )* )
            {
            // InternalXtext.g:4455:2: ( ( rule__UnorderedGroup__Group_1_1__0 ) )
            // InternalXtext.g:4456:3: ( rule__UnorderedGroup__Group_1_1__0 )
            {
             before(grammarAccess.getUnorderedGroupAccess().getGroup_1_1()); 
            // InternalXtext.g:4457:3: ( rule__UnorderedGroup__Group_1_1__0 )
            // InternalXtext.g:4457:4: rule__UnorderedGroup__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_33);
            rule__UnorderedGroup__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getUnorderedGroupAccess().getGroup_1_1()); 

            }

            // InternalXtext.g:4460:2: ( ( rule__UnorderedGroup__Group_1_1__0 )* )
            // InternalXtext.g:4461:3: ( rule__UnorderedGroup__Group_1_1__0 )*
            {
             before(grammarAccess.getUnorderedGroupAccess().getGroup_1_1()); 
            // InternalXtext.g:4462:3: ( rule__UnorderedGroup__Group_1_1__0 )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==36) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalXtext.g:4462:4: rule__UnorderedGroup__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_33);
            	    rule__UnorderedGroup__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop50;
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
    // InternalXtext.g:4472:1: rule__UnorderedGroup__Group_1_1__0 : rule__UnorderedGroup__Group_1_1__0__Impl rule__UnorderedGroup__Group_1_1__1 ;
    public final void rule__UnorderedGroup__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4476:1: ( rule__UnorderedGroup__Group_1_1__0__Impl rule__UnorderedGroup__Group_1_1__1 )
            // InternalXtext.g:4477:2: rule__UnorderedGroup__Group_1_1__0__Impl rule__UnorderedGroup__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_30);
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
    // InternalXtext.g:4484:1: rule__UnorderedGroup__Group_1_1__0__Impl : ( '&' ) ;
    public final void rule__UnorderedGroup__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4488:1: ( ( '&' ) )
            // InternalXtext.g:4489:1: ( '&' )
            {
            // InternalXtext.g:4489:1: ( '&' )
            // InternalXtext.g:4490:2: '&'
            {
             before(grammarAccess.getUnorderedGroupAccess().getAmpersandKeyword_1_1_0()); 
            match(input,36,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:4499:1: rule__UnorderedGroup__Group_1_1__1 : rule__UnorderedGroup__Group_1_1__1__Impl ;
    public final void rule__UnorderedGroup__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4503:1: ( rule__UnorderedGroup__Group_1_1__1__Impl )
            // InternalXtext.g:4504:2: rule__UnorderedGroup__Group_1_1__1__Impl
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
    // InternalXtext.g:4510:1: rule__UnorderedGroup__Group_1_1__1__Impl : ( ( rule__UnorderedGroup__ElementsAssignment_1_1_1 ) ) ;
    public final void rule__UnorderedGroup__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4514:1: ( ( ( rule__UnorderedGroup__ElementsAssignment_1_1_1 ) ) )
            // InternalXtext.g:4515:1: ( ( rule__UnorderedGroup__ElementsAssignment_1_1_1 ) )
            {
            // InternalXtext.g:4515:1: ( ( rule__UnorderedGroup__ElementsAssignment_1_1_1 ) )
            // InternalXtext.g:4516:2: ( rule__UnorderedGroup__ElementsAssignment_1_1_1 )
            {
             before(grammarAccess.getUnorderedGroupAccess().getElementsAssignment_1_1_1()); 
            // InternalXtext.g:4517:2: ( rule__UnorderedGroup__ElementsAssignment_1_1_1 )
            // InternalXtext.g:4517:3: rule__UnorderedGroup__ElementsAssignment_1_1_1
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
    // InternalXtext.g:4526:1: rule__Group__Group__0 : rule__Group__Group__0__Impl rule__Group__Group__1 ;
    public final void rule__Group__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4530:1: ( rule__Group__Group__0__Impl rule__Group__Group__1 )
            // InternalXtext.g:4531:2: rule__Group__Group__0__Impl rule__Group__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_30);
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
    // InternalXtext.g:4538:1: rule__Group__Group__0__Impl : ( ruleAbstractToken ) ;
    public final void rule__Group__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4542:1: ( ( ruleAbstractToken ) )
            // InternalXtext.g:4543:1: ( ruleAbstractToken )
            {
            // InternalXtext.g:4543:1: ( ruleAbstractToken )
            // InternalXtext.g:4544:2: ruleAbstractToken
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
    // InternalXtext.g:4553:1: rule__Group__Group__1 : rule__Group__Group__1__Impl ;
    public final void rule__Group__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4557:1: ( rule__Group__Group__1__Impl )
            // InternalXtext.g:4558:2: rule__Group__Group__1__Impl
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
    // InternalXtext.g:4564:1: rule__Group__Group__1__Impl : ( ( rule__Group__Group_1__0 )? ) ;
    public final void rule__Group__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4568:1: ( ( ( rule__Group__Group_1__0 )? ) )
            // InternalXtext.g:4569:1: ( ( rule__Group__Group_1__0 )? )
            {
            // InternalXtext.g:4569:1: ( ( rule__Group__Group_1__0 )? )
            // InternalXtext.g:4570:2: ( rule__Group__Group_1__0 )?
            {
             before(grammarAccess.getGroupAccess().getGroup_1()); 
            // InternalXtext.g:4571:2: ( rule__Group__Group_1__0 )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( ((LA51_0>=RULE_ID && LA51_0<=RULE_STRING)||(LA51_0>=16 && LA51_0<=17)||LA51_0==22||LA51_0==37||LA51_0==44||LA51_0==50) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalXtext.g:4571:3: rule__Group__Group_1__0
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
    // InternalXtext.g:4580:1: rule__Group__Group_1__0 : rule__Group__Group_1__0__Impl rule__Group__Group_1__1 ;
    public final void rule__Group__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4584:1: ( rule__Group__Group_1__0__Impl rule__Group__Group_1__1 )
            // InternalXtext.g:4585:2: rule__Group__Group_1__0__Impl rule__Group__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_30);
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
    // InternalXtext.g:4592:1: rule__Group__Group_1__0__Impl : ( () ) ;
    public final void rule__Group__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4596:1: ( ( () ) )
            // InternalXtext.g:4597:1: ( () )
            {
            // InternalXtext.g:4597:1: ( () )
            // InternalXtext.g:4598:2: ()
            {
             before(grammarAccess.getGroupAccess().getGroupElementsAction_1_0()); 
            // InternalXtext.g:4599:2: ()
            // InternalXtext.g:4599:3: 
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
    // InternalXtext.g:4607:1: rule__Group__Group_1__1 : rule__Group__Group_1__1__Impl ;
    public final void rule__Group__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4611:1: ( rule__Group__Group_1__1__Impl )
            // InternalXtext.g:4612:2: rule__Group__Group_1__1__Impl
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
    // InternalXtext.g:4618:1: rule__Group__Group_1__1__Impl : ( ( ( rule__Group__ElementsAssignment_1_1 ) ) ( ( rule__Group__ElementsAssignment_1_1 )* ) ) ;
    public final void rule__Group__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4622:1: ( ( ( ( rule__Group__ElementsAssignment_1_1 ) ) ( ( rule__Group__ElementsAssignment_1_1 )* ) ) )
            // InternalXtext.g:4623:1: ( ( ( rule__Group__ElementsAssignment_1_1 ) ) ( ( rule__Group__ElementsAssignment_1_1 )* ) )
            {
            // InternalXtext.g:4623:1: ( ( ( rule__Group__ElementsAssignment_1_1 ) ) ( ( rule__Group__ElementsAssignment_1_1 )* ) )
            // InternalXtext.g:4624:2: ( ( rule__Group__ElementsAssignment_1_1 ) ) ( ( rule__Group__ElementsAssignment_1_1 )* )
            {
            // InternalXtext.g:4624:2: ( ( rule__Group__ElementsAssignment_1_1 ) )
            // InternalXtext.g:4625:3: ( rule__Group__ElementsAssignment_1_1 )
            {
             before(grammarAccess.getGroupAccess().getElementsAssignment_1_1()); 
            // InternalXtext.g:4626:3: ( rule__Group__ElementsAssignment_1_1 )
            // InternalXtext.g:4626:4: rule__Group__ElementsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_31);
            rule__Group__ElementsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getGroupAccess().getElementsAssignment_1_1()); 

            }

            // InternalXtext.g:4629:2: ( ( rule__Group__ElementsAssignment_1_1 )* )
            // InternalXtext.g:4630:3: ( rule__Group__ElementsAssignment_1_1 )*
            {
             before(grammarAccess.getGroupAccess().getElementsAssignment_1_1()); 
            // InternalXtext.g:4631:3: ( rule__Group__ElementsAssignment_1_1 )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( ((LA52_0>=RULE_ID && LA52_0<=RULE_STRING)||(LA52_0>=16 && LA52_0<=17)||LA52_0==22||LA52_0==37||LA52_0==44||LA52_0==50) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalXtext.g:4631:4: rule__Group__ElementsAssignment_1_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_31);
            	    rule__Group__ElementsAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop52;
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
    // InternalXtext.g:4641:1: rule__AbstractTokenWithCardinality__Group__0 : rule__AbstractTokenWithCardinality__Group__0__Impl rule__AbstractTokenWithCardinality__Group__1 ;
    public final void rule__AbstractTokenWithCardinality__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4645:1: ( rule__AbstractTokenWithCardinality__Group__0__Impl rule__AbstractTokenWithCardinality__Group__1 )
            // InternalXtext.g:4646:2: rule__AbstractTokenWithCardinality__Group__0__Impl rule__AbstractTokenWithCardinality__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_34);
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
    // InternalXtext.g:4653:1: rule__AbstractTokenWithCardinality__Group__0__Impl : ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) ) ;
    public final void rule__AbstractTokenWithCardinality__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4657:1: ( ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) ) )
            // InternalXtext.g:4658:1: ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) )
            {
            // InternalXtext.g:4658:1: ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) )
            // InternalXtext.g:4659:2: ( rule__AbstractTokenWithCardinality__Alternatives_0 )
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getAlternatives_0()); 
            // InternalXtext.g:4660:2: ( rule__AbstractTokenWithCardinality__Alternatives_0 )
            // InternalXtext.g:4660:3: rule__AbstractTokenWithCardinality__Alternatives_0
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
    // InternalXtext.g:4668:1: rule__AbstractTokenWithCardinality__Group__1 : rule__AbstractTokenWithCardinality__Group__1__Impl ;
    public final void rule__AbstractTokenWithCardinality__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4672:1: ( rule__AbstractTokenWithCardinality__Group__1__Impl )
            // InternalXtext.g:4673:2: rule__AbstractTokenWithCardinality__Group__1__Impl
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
    // InternalXtext.g:4679:1: rule__AbstractTokenWithCardinality__Group__1__Impl : ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? ) ;
    public final void rule__AbstractTokenWithCardinality__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4683:1: ( ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? ) )
            // InternalXtext.g:4684:1: ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? )
            {
            // InternalXtext.g:4684:1: ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? )
            // InternalXtext.g:4685:2: ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )?
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAssignment_1()); 
            // InternalXtext.g:4686:2: ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( ((LA53_0>=11 && LA53_0<=13)) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalXtext.g:4686:3: rule__AbstractTokenWithCardinality__CardinalityAssignment_1
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
    // InternalXtext.g:4695:1: rule__Action__Group__0 : rule__Action__Group__0__Impl rule__Action__Group__1 ;
    public final void rule__Action__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4699:1: ( rule__Action__Group__0__Impl rule__Action__Group__1 )
            // InternalXtext.g:4700:2: rule__Action__Group__0__Impl rule__Action__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_15);
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
    // InternalXtext.g:4707:1: rule__Action__Group__0__Impl : ( '{' ) ;
    public final void rule__Action__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4711:1: ( ( '{' ) )
            // InternalXtext.g:4712:1: ( '{' )
            {
            // InternalXtext.g:4712:1: ( '{' )
            // InternalXtext.g:4713:2: '{'
            {
             before(grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,37,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:4722:1: rule__Action__Group__1 : rule__Action__Group__1__Impl rule__Action__Group__2 ;
    public final void rule__Action__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4726:1: ( rule__Action__Group__1__Impl rule__Action__Group__2 )
            // InternalXtext.g:4727:2: rule__Action__Group__1__Impl rule__Action__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_35);
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
    // InternalXtext.g:4734:1: rule__Action__Group__1__Impl : ( ( rule__Action__TypeAssignment_1 ) ) ;
    public final void rule__Action__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4738:1: ( ( ( rule__Action__TypeAssignment_1 ) ) )
            // InternalXtext.g:4739:1: ( ( rule__Action__TypeAssignment_1 ) )
            {
            // InternalXtext.g:4739:1: ( ( rule__Action__TypeAssignment_1 ) )
            // InternalXtext.g:4740:2: ( rule__Action__TypeAssignment_1 )
            {
             before(grammarAccess.getActionAccess().getTypeAssignment_1()); 
            // InternalXtext.g:4741:2: ( rule__Action__TypeAssignment_1 )
            // InternalXtext.g:4741:3: rule__Action__TypeAssignment_1
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
    // InternalXtext.g:4749:1: rule__Action__Group__2 : rule__Action__Group__2__Impl rule__Action__Group__3 ;
    public final void rule__Action__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4753:1: ( rule__Action__Group__2__Impl rule__Action__Group__3 )
            // InternalXtext.g:4754:2: rule__Action__Group__2__Impl rule__Action__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_35);
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
    // InternalXtext.g:4761:1: rule__Action__Group__2__Impl : ( ( rule__Action__Group_2__0 )? ) ;
    public final void rule__Action__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4765:1: ( ( ( rule__Action__Group_2__0 )? ) )
            // InternalXtext.g:4766:1: ( ( rule__Action__Group_2__0 )? )
            {
            // InternalXtext.g:4766:1: ( ( rule__Action__Group_2__0 )? )
            // InternalXtext.g:4767:2: ( rule__Action__Group_2__0 )?
            {
             before(grammarAccess.getActionAccess().getGroup_2()); 
            // InternalXtext.g:4768:2: ( rule__Action__Group_2__0 )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==24) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalXtext.g:4768:3: rule__Action__Group_2__0
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
    // InternalXtext.g:4776:1: rule__Action__Group__3 : rule__Action__Group__3__Impl ;
    public final void rule__Action__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4780:1: ( rule__Action__Group__3__Impl )
            // InternalXtext.g:4781:2: rule__Action__Group__3__Impl
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
    // InternalXtext.g:4787:1: rule__Action__Group__3__Impl : ( '}' ) ;
    public final void rule__Action__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4791:1: ( ( '}' ) )
            // InternalXtext.g:4792:1: ( '}' )
            {
            // InternalXtext.g:4792:1: ( '}' )
            // InternalXtext.g:4793:2: '}'
            {
             before(grammarAccess.getActionAccess().getRightCurlyBracketKeyword_3()); 
            match(input,38,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:4803:1: rule__Action__Group_2__0 : rule__Action__Group_2__0__Impl rule__Action__Group_2__1 ;
    public final void rule__Action__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4807:1: ( rule__Action__Group_2__0__Impl rule__Action__Group_2__1 )
            // InternalXtext.g:4808:2: rule__Action__Group_2__0__Impl rule__Action__Group_2__1
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
    // InternalXtext.g:4815:1: rule__Action__Group_2__0__Impl : ( '.' ) ;
    public final void rule__Action__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4819:1: ( ( '.' ) )
            // InternalXtext.g:4820:1: ( '.' )
            {
            // InternalXtext.g:4820:1: ( '.' )
            // InternalXtext.g:4821:2: '.'
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
    // InternalXtext.g:4830:1: rule__Action__Group_2__1 : rule__Action__Group_2__1__Impl rule__Action__Group_2__2 ;
    public final void rule__Action__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4834:1: ( rule__Action__Group_2__1__Impl rule__Action__Group_2__2 )
            // InternalXtext.g:4835:2: rule__Action__Group_2__1__Impl rule__Action__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_36);
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
    // InternalXtext.g:4842:1: rule__Action__Group_2__1__Impl : ( ( rule__Action__FeatureAssignment_2_1 ) ) ;
    public final void rule__Action__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4846:1: ( ( ( rule__Action__FeatureAssignment_2_1 ) ) )
            // InternalXtext.g:4847:1: ( ( rule__Action__FeatureAssignment_2_1 ) )
            {
            // InternalXtext.g:4847:1: ( ( rule__Action__FeatureAssignment_2_1 ) )
            // InternalXtext.g:4848:2: ( rule__Action__FeatureAssignment_2_1 )
            {
             before(grammarAccess.getActionAccess().getFeatureAssignment_2_1()); 
            // InternalXtext.g:4849:2: ( rule__Action__FeatureAssignment_2_1 )
            // InternalXtext.g:4849:3: rule__Action__FeatureAssignment_2_1
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
    // InternalXtext.g:4857:1: rule__Action__Group_2__2 : rule__Action__Group_2__2__Impl rule__Action__Group_2__3 ;
    public final void rule__Action__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4861:1: ( rule__Action__Group_2__2__Impl rule__Action__Group_2__3 )
            // InternalXtext.g:4862:2: rule__Action__Group_2__2__Impl rule__Action__Group_2__3
            {
            pushFollow(FollowSets000.FOLLOW_37);
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
    // InternalXtext.g:4869:1: rule__Action__Group_2__2__Impl : ( ( rule__Action__OperatorAssignment_2_2 ) ) ;
    public final void rule__Action__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4873:1: ( ( ( rule__Action__OperatorAssignment_2_2 ) ) )
            // InternalXtext.g:4874:1: ( ( rule__Action__OperatorAssignment_2_2 ) )
            {
            // InternalXtext.g:4874:1: ( ( rule__Action__OperatorAssignment_2_2 ) )
            // InternalXtext.g:4875:2: ( rule__Action__OperatorAssignment_2_2 )
            {
             before(grammarAccess.getActionAccess().getOperatorAssignment_2_2()); 
            // InternalXtext.g:4876:2: ( rule__Action__OperatorAssignment_2_2 )
            // InternalXtext.g:4876:3: rule__Action__OperatorAssignment_2_2
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
    // InternalXtext.g:4884:1: rule__Action__Group_2__3 : rule__Action__Group_2__3__Impl ;
    public final void rule__Action__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4888:1: ( rule__Action__Group_2__3__Impl )
            // InternalXtext.g:4889:2: rule__Action__Group_2__3__Impl
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
    // InternalXtext.g:4895:1: rule__Action__Group_2__3__Impl : ( 'current' ) ;
    public final void rule__Action__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4899:1: ( ( 'current' ) )
            // InternalXtext.g:4900:1: ( 'current' )
            {
            // InternalXtext.g:4900:1: ( 'current' )
            // InternalXtext.g:4901:2: 'current'
            {
             before(grammarAccess.getActionAccess().getCurrentKeyword_2_3()); 
            match(input,39,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:4911:1: rule__RuleCall__Group__0 : rule__RuleCall__Group__0__Impl rule__RuleCall__Group__1 ;
    public final void rule__RuleCall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4915:1: ( rule__RuleCall__Group__0__Impl rule__RuleCall__Group__1 )
            // InternalXtext.g:4916:2: rule__RuleCall__Group__0__Impl rule__RuleCall__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_23);
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
    // InternalXtext.g:4923:1: rule__RuleCall__Group__0__Impl : ( ( rule__RuleCall__RuleAssignment_0 ) ) ;
    public final void rule__RuleCall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4927:1: ( ( ( rule__RuleCall__RuleAssignment_0 ) ) )
            // InternalXtext.g:4928:1: ( ( rule__RuleCall__RuleAssignment_0 ) )
            {
            // InternalXtext.g:4928:1: ( ( rule__RuleCall__RuleAssignment_0 ) )
            // InternalXtext.g:4929:2: ( rule__RuleCall__RuleAssignment_0 )
            {
             before(grammarAccess.getRuleCallAccess().getRuleAssignment_0()); 
            // InternalXtext.g:4930:2: ( rule__RuleCall__RuleAssignment_0 )
            // InternalXtext.g:4930:3: rule__RuleCall__RuleAssignment_0
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
    // InternalXtext.g:4938:1: rule__RuleCall__Group__1 : rule__RuleCall__Group__1__Impl ;
    public final void rule__RuleCall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4942:1: ( rule__RuleCall__Group__1__Impl )
            // InternalXtext.g:4943:2: rule__RuleCall__Group__1__Impl
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
    // InternalXtext.g:4949:1: rule__RuleCall__Group__1__Impl : ( ( rule__RuleCall__Group_1__0 )? ) ;
    public final void rule__RuleCall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4953:1: ( ( ( rule__RuleCall__Group_1__0 )? ) )
            // InternalXtext.g:4954:1: ( ( rule__RuleCall__Group_1__0 )? )
            {
            // InternalXtext.g:4954:1: ( ( rule__RuleCall__Group_1__0 )? )
            // InternalXtext.g:4955:2: ( rule__RuleCall__Group_1__0 )?
            {
             before(grammarAccess.getRuleCallAccess().getGroup_1()); 
            // InternalXtext.g:4956:2: ( rule__RuleCall__Group_1__0 )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==32) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalXtext.g:4956:3: rule__RuleCall__Group_1__0
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
    // InternalXtext.g:4965:1: rule__RuleCall__Group_1__0 : rule__RuleCall__Group_1__0__Impl rule__RuleCall__Group_1__1 ;
    public final void rule__RuleCall__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4969:1: ( rule__RuleCall__Group_1__0__Impl rule__RuleCall__Group_1__1 )
            // InternalXtext.g:4970:2: rule__RuleCall__Group_1__0__Impl rule__RuleCall__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_28);
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
    // InternalXtext.g:4977:1: rule__RuleCall__Group_1__0__Impl : ( '<' ) ;
    public final void rule__RuleCall__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4981:1: ( ( '<' ) )
            // InternalXtext.g:4982:1: ( '<' )
            {
            // InternalXtext.g:4982:1: ( '<' )
            // InternalXtext.g:4983:2: '<'
            {
             before(grammarAccess.getRuleCallAccess().getLessThanSignKeyword_1_0()); 
            match(input,32,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:4992:1: rule__RuleCall__Group_1__1 : rule__RuleCall__Group_1__1__Impl rule__RuleCall__Group_1__2 ;
    public final void rule__RuleCall__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4996:1: ( rule__RuleCall__Group_1__1__Impl rule__RuleCall__Group_1__2 )
            // InternalXtext.g:4997:2: rule__RuleCall__Group_1__1__Impl rule__RuleCall__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_38);
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
    // InternalXtext.g:5004:1: rule__RuleCall__Group_1__1__Impl : ( ( rule__RuleCall__ArgumentsAssignment_1_1 ) ) ;
    public final void rule__RuleCall__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5008:1: ( ( ( rule__RuleCall__ArgumentsAssignment_1_1 ) ) )
            // InternalXtext.g:5009:1: ( ( rule__RuleCall__ArgumentsAssignment_1_1 ) )
            {
            // InternalXtext.g:5009:1: ( ( rule__RuleCall__ArgumentsAssignment_1_1 ) )
            // InternalXtext.g:5010:2: ( rule__RuleCall__ArgumentsAssignment_1_1 )
            {
             before(grammarAccess.getRuleCallAccess().getArgumentsAssignment_1_1()); 
            // InternalXtext.g:5011:2: ( rule__RuleCall__ArgumentsAssignment_1_1 )
            // InternalXtext.g:5011:3: rule__RuleCall__ArgumentsAssignment_1_1
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
    // InternalXtext.g:5019:1: rule__RuleCall__Group_1__2 : rule__RuleCall__Group_1__2__Impl rule__RuleCall__Group_1__3 ;
    public final void rule__RuleCall__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5023:1: ( rule__RuleCall__Group_1__2__Impl rule__RuleCall__Group_1__3 )
            // InternalXtext.g:5024:2: rule__RuleCall__Group_1__2__Impl rule__RuleCall__Group_1__3
            {
            pushFollow(FollowSets000.FOLLOW_38);
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
    // InternalXtext.g:5031:1: rule__RuleCall__Group_1__2__Impl : ( ( rule__RuleCall__Group_1_2__0 )* ) ;
    public final void rule__RuleCall__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5035:1: ( ( ( rule__RuleCall__Group_1_2__0 )* ) )
            // InternalXtext.g:5036:1: ( ( rule__RuleCall__Group_1_2__0 )* )
            {
            // InternalXtext.g:5036:1: ( ( rule__RuleCall__Group_1_2__0 )* )
            // InternalXtext.g:5037:2: ( rule__RuleCall__Group_1_2__0 )*
            {
             before(grammarAccess.getRuleCallAccess().getGroup_1_2()); 
            // InternalXtext.g:5038:2: ( rule__RuleCall__Group_1_2__0 )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==21) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalXtext.g:5038:3: rule__RuleCall__Group_1_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    rule__RuleCall__Group_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop56;
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
    // InternalXtext.g:5046:1: rule__RuleCall__Group_1__3 : rule__RuleCall__Group_1__3__Impl ;
    public final void rule__RuleCall__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5050:1: ( rule__RuleCall__Group_1__3__Impl )
            // InternalXtext.g:5051:2: rule__RuleCall__Group_1__3__Impl
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
    // InternalXtext.g:5057:1: rule__RuleCall__Group_1__3__Impl : ( '>' ) ;
    public final void rule__RuleCall__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5061:1: ( ( '>' ) )
            // InternalXtext.g:5062:1: ( '>' )
            {
            // InternalXtext.g:5062:1: ( '>' )
            // InternalXtext.g:5063:2: '>'
            {
             before(grammarAccess.getRuleCallAccess().getGreaterThanSignKeyword_1_3()); 
            match(input,33,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:5073:1: rule__RuleCall__Group_1_2__0 : rule__RuleCall__Group_1_2__0__Impl rule__RuleCall__Group_1_2__1 ;
    public final void rule__RuleCall__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5077:1: ( rule__RuleCall__Group_1_2__0__Impl rule__RuleCall__Group_1_2__1 )
            // InternalXtext.g:5078:2: rule__RuleCall__Group_1_2__0__Impl rule__RuleCall__Group_1_2__1
            {
            pushFollow(FollowSets000.FOLLOW_28);
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
    // InternalXtext.g:5085:1: rule__RuleCall__Group_1_2__0__Impl : ( ',' ) ;
    public final void rule__RuleCall__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5089:1: ( ( ',' ) )
            // InternalXtext.g:5090:1: ( ',' )
            {
            // InternalXtext.g:5090:1: ( ',' )
            // InternalXtext.g:5091:2: ','
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
    // InternalXtext.g:5100:1: rule__RuleCall__Group_1_2__1 : rule__RuleCall__Group_1_2__1__Impl ;
    public final void rule__RuleCall__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5104:1: ( rule__RuleCall__Group_1_2__1__Impl )
            // InternalXtext.g:5105:2: rule__RuleCall__Group_1_2__1__Impl
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
    // InternalXtext.g:5111:1: rule__RuleCall__Group_1_2__1__Impl : ( ( rule__RuleCall__ArgumentsAssignment_1_2_1 ) ) ;
    public final void rule__RuleCall__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5115:1: ( ( ( rule__RuleCall__ArgumentsAssignment_1_2_1 ) ) )
            // InternalXtext.g:5116:1: ( ( rule__RuleCall__ArgumentsAssignment_1_2_1 ) )
            {
            // InternalXtext.g:5116:1: ( ( rule__RuleCall__ArgumentsAssignment_1_2_1 ) )
            // InternalXtext.g:5117:2: ( rule__RuleCall__ArgumentsAssignment_1_2_1 )
            {
             before(grammarAccess.getRuleCallAccess().getArgumentsAssignment_1_2_1()); 
            // InternalXtext.g:5118:2: ( rule__RuleCall__ArgumentsAssignment_1_2_1 )
            // InternalXtext.g:5118:3: rule__RuleCall__ArgumentsAssignment_1_2_1
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
    // InternalXtext.g:5127:1: rule__NamedArgument__Group__0 : rule__NamedArgument__Group__0__Impl rule__NamedArgument__Group__1 ;
    public final void rule__NamedArgument__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5131:1: ( rule__NamedArgument__Group__0__Impl rule__NamedArgument__Group__1 )
            // InternalXtext.g:5132:2: rule__NamedArgument__Group__0__Impl rule__NamedArgument__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_28);
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
    // InternalXtext.g:5139:1: rule__NamedArgument__Group__0__Impl : ( ( rule__NamedArgument__Group_0__0 )? ) ;
    public final void rule__NamedArgument__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5143:1: ( ( ( rule__NamedArgument__Group_0__0 )? ) )
            // InternalXtext.g:5144:1: ( ( rule__NamedArgument__Group_0__0 )? )
            {
            // InternalXtext.g:5144:1: ( ( rule__NamedArgument__Group_0__0 )? )
            // InternalXtext.g:5145:2: ( rule__NamedArgument__Group_0__0 )?
            {
             before(grammarAccess.getNamedArgumentAccess().getGroup_0()); 
            // InternalXtext.g:5146:2: ( rule__NamedArgument__Group_0__0 )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==RULE_ID) ) {
                int LA57_1 = input.LA(2);

                if ( (LA57_1==14) ) {
                    alt57=1;
                }
            }
            switch (alt57) {
                case 1 :
                    // InternalXtext.g:5146:3: rule__NamedArgument__Group_0__0
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
    // InternalXtext.g:5154:1: rule__NamedArgument__Group__1 : rule__NamedArgument__Group__1__Impl ;
    public final void rule__NamedArgument__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5158:1: ( rule__NamedArgument__Group__1__Impl )
            // InternalXtext.g:5159:2: rule__NamedArgument__Group__1__Impl
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
    // InternalXtext.g:5165:1: rule__NamedArgument__Group__1__Impl : ( ( rule__NamedArgument__ValueAssignment_1 ) ) ;
    public final void rule__NamedArgument__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5169:1: ( ( ( rule__NamedArgument__ValueAssignment_1 ) ) )
            // InternalXtext.g:5170:1: ( ( rule__NamedArgument__ValueAssignment_1 ) )
            {
            // InternalXtext.g:5170:1: ( ( rule__NamedArgument__ValueAssignment_1 ) )
            // InternalXtext.g:5171:2: ( rule__NamedArgument__ValueAssignment_1 )
            {
             before(grammarAccess.getNamedArgumentAccess().getValueAssignment_1()); 
            // InternalXtext.g:5172:2: ( rule__NamedArgument__ValueAssignment_1 )
            // InternalXtext.g:5172:3: rule__NamedArgument__ValueAssignment_1
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
    // InternalXtext.g:5181:1: rule__NamedArgument__Group_0__0 : rule__NamedArgument__Group_0__0__Impl rule__NamedArgument__Group_0__1 ;
    public final void rule__NamedArgument__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5185:1: ( rule__NamedArgument__Group_0__0__Impl rule__NamedArgument__Group_0__1 )
            // InternalXtext.g:5186:2: rule__NamedArgument__Group_0__0__Impl rule__NamedArgument__Group_0__1
            {
            pushFollow(FollowSets000.FOLLOW_39);
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
    // InternalXtext.g:5193:1: rule__NamedArgument__Group_0__0__Impl : ( ( rule__NamedArgument__ParameterAssignment_0_0 ) ) ;
    public final void rule__NamedArgument__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5197:1: ( ( ( rule__NamedArgument__ParameterAssignment_0_0 ) ) )
            // InternalXtext.g:5198:1: ( ( rule__NamedArgument__ParameterAssignment_0_0 ) )
            {
            // InternalXtext.g:5198:1: ( ( rule__NamedArgument__ParameterAssignment_0_0 ) )
            // InternalXtext.g:5199:2: ( rule__NamedArgument__ParameterAssignment_0_0 )
            {
             before(grammarAccess.getNamedArgumentAccess().getParameterAssignment_0_0()); 
            // InternalXtext.g:5200:2: ( rule__NamedArgument__ParameterAssignment_0_0 )
            // InternalXtext.g:5200:3: rule__NamedArgument__ParameterAssignment_0_0
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
    // InternalXtext.g:5208:1: rule__NamedArgument__Group_0__1 : rule__NamedArgument__Group_0__1__Impl ;
    public final void rule__NamedArgument__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5212:1: ( rule__NamedArgument__Group_0__1__Impl )
            // InternalXtext.g:5213:2: rule__NamedArgument__Group_0__1__Impl
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
    // InternalXtext.g:5219:1: rule__NamedArgument__Group_0__1__Impl : ( ( rule__NamedArgument__CalledByNameAssignment_0_1 ) ) ;
    public final void rule__NamedArgument__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5223:1: ( ( ( rule__NamedArgument__CalledByNameAssignment_0_1 ) ) )
            // InternalXtext.g:5224:1: ( ( rule__NamedArgument__CalledByNameAssignment_0_1 ) )
            {
            // InternalXtext.g:5224:1: ( ( rule__NamedArgument__CalledByNameAssignment_0_1 ) )
            // InternalXtext.g:5225:2: ( rule__NamedArgument__CalledByNameAssignment_0_1 )
            {
             before(grammarAccess.getNamedArgumentAccess().getCalledByNameAssignment_0_1()); 
            // InternalXtext.g:5226:2: ( rule__NamedArgument__CalledByNameAssignment_0_1 )
            // InternalXtext.g:5226:3: rule__NamedArgument__CalledByNameAssignment_0_1
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
    // InternalXtext.g:5235:1: rule__LiteralCondition__Group__0 : rule__LiteralCondition__Group__0__Impl rule__LiteralCondition__Group__1 ;
    public final void rule__LiteralCondition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5239:1: ( rule__LiteralCondition__Group__0__Impl rule__LiteralCondition__Group__1 )
            // InternalXtext.g:5240:2: rule__LiteralCondition__Group__0__Impl rule__LiteralCondition__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_40);
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
    // InternalXtext.g:5247:1: rule__LiteralCondition__Group__0__Impl : ( () ) ;
    public final void rule__LiteralCondition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5251:1: ( ( () ) )
            // InternalXtext.g:5252:1: ( () )
            {
            // InternalXtext.g:5252:1: ( () )
            // InternalXtext.g:5253:2: ()
            {
             before(grammarAccess.getLiteralConditionAccess().getLiteralConditionAction_0()); 
            // InternalXtext.g:5254:2: ()
            // InternalXtext.g:5254:3: 
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
    // InternalXtext.g:5262:1: rule__LiteralCondition__Group__1 : rule__LiteralCondition__Group__1__Impl ;
    public final void rule__LiteralCondition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5266:1: ( rule__LiteralCondition__Group__1__Impl )
            // InternalXtext.g:5267:2: rule__LiteralCondition__Group__1__Impl
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
    // InternalXtext.g:5273:1: rule__LiteralCondition__Group__1__Impl : ( ( rule__LiteralCondition__Alternatives_1 ) ) ;
    public final void rule__LiteralCondition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5277:1: ( ( ( rule__LiteralCondition__Alternatives_1 ) ) )
            // InternalXtext.g:5278:1: ( ( rule__LiteralCondition__Alternatives_1 ) )
            {
            // InternalXtext.g:5278:1: ( ( rule__LiteralCondition__Alternatives_1 ) )
            // InternalXtext.g:5279:2: ( rule__LiteralCondition__Alternatives_1 )
            {
             before(grammarAccess.getLiteralConditionAccess().getAlternatives_1()); 
            // InternalXtext.g:5280:2: ( rule__LiteralCondition__Alternatives_1 )
            // InternalXtext.g:5280:3: rule__LiteralCondition__Alternatives_1
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
    // InternalXtext.g:5289:1: rule__Disjunction__Group__0 : rule__Disjunction__Group__0__Impl rule__Disjunction__Group__1 ;
    public final void rule__Disjunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5293:1: ( rule__Disjunction__Group__0__Impl rule__Disjunction__Group__1 )
            // InternalXtext.g:5294:2: rule__Disjunction__Group__0__Impl rule__Disjunction__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_26);
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
    // InternalXtext.g:5301:1: rule__Disjunction__Group__0__Impl : ( ruleConjunction ) ;
    public final void rule__Disjunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5305:1: ( ( ruleConjunction ) )
            // InternalXtext.g:5306:1: ( ruleConjunction )
            {
            // InternalXtext.g:5306:1: ( ruleConjunction )
            // InternalXtext.g:5307:2: ruleConjunction
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
    // InternalXtext.g:5316:1: rule__Disjunction__Group__1 : rule__Disjunction__Group__1__Impl ;
    public final void rule__Disjunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5320:1: ( rule__Disjunction__Group__1__Impl )
            // InternalXtext.g:5321:2: rule__Disjunction__Group__1__Impl
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
    // InternalXtext.g:5327:1: rule__Disjunction__Group__1__Impl : ( ( rule__Disjunction__Group_1__0 )* ) ;
    public final void rule__Disjunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5331:1: ( ( ( rule__Disjunction__Group_1__0 )* ) )
            // InternalXtext.g:5332:1: ( ( rule__Disjunction__Group_1__0 )* )
            {
            // InternalXtext.g:5332:1: ( ( rule__Disjunction__Group_1__0 )* )
            // InternalXtext.g:5333:2: ( rule__Disjunction__Group_1__0 )*
            {
             before(grammarAccess.getDisjunctionAccess().getGroup_1()); 
            // InternalXtext.g:5334:2: ( rule__Disjunction__Group_1__0 )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==35) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // InternalXtext.g:5334:3: rule__Disjunction__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_27);
            	    rule__Disjunction__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop58;
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
    // InternalXtext.g:5343:1: rule__Disjunction__Group_1__0 : rule__Disjunction__Group_1__0__Impl rule__Disjunction__Group_1__1 ;
    public final void rule__Disjunction__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5347:1: ( rule__Disjunction__Group_1__0__Impl rule__Disjunction__Group_1__1 )
            // InternalXtext.g:5348:2: rule__Disjunction__Group_1__0__Impl rule__Disjunction__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_26);
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
    // InternalXtext.g:5355:1: rule__Disjunction__Group_1__0__Impl : ( () ) ;
    public final void rule__Disjunction__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5359:1: ( ( () ) )
            // InternalXtext.g:5360:1: ( () )
            {
            // InternalXtext.g:5360:1: ( () )
            // InternalXtext.g:5361:2: ()
            {
             before(grammarAccess.getDisjunctionAccess().getDisjunctionLeftAction_1_0()); 
            // InternalXtext.g:5362:2: ()
            // InternalXtext.g:5362:3: 
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
    // InternalXtext.g:5370:1: rule__Disjunction__Group_1__1 : rule__Disjunction__Group_1__1__Impl rule__Disjunction__Group_1__2 ;
    public final void rule__Disjunction__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5374:1: ( rule__Disjunction__Group_1__1__Impl rule__Disjunction__Group_1__2 )
            // InternalXtext.g:5375:2: rule__Disjunction__Group_1__1__Impl rule__Disjunction__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_28);
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
    // InternalXtext.g:5382:1: rule__Disjunction__Group_1__1__Impl : ( '|' ) ;
    public final void rule__Disjunction__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5386:1: ( ( '|' ) )
            // InternalXtext.g:5387:1: ( '|' )
            {
            // InternalXtext.g:5387:1: ( '|' )
            // InternalXtext.g:5388:2: '|'
            {
             before(grammarAccess.getDisjunctionAccess().getVerticalLineKeyword_1_1()); 
            match(input,35,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:5397:1: rule__Disjunction__Group_1__2 : rule__Disjunction__Group_1__2__Impl ;
    public final void rule__Disjunction__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5401:1: ( rule__Disjunction__Group_1__2__Impl )
            // InternalXtext.g:5402:2: rule__Disjunction__Group_1__2__Impl
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
    // InternalXtext.g:5408:1: rule__Disjunction__Group_1__2__Impl : ( ( rule__Disjunction__RightAssignment_1_2 ) ) ;
    public final void rule__Disjunction__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5412:1: ( ( ( rule__Disjunction__RightAssignment_1_2 ) ) )
            // InternalXtext.g:5413:1: ( ( rule__Disjunction__RightAssignment_1_2 ) )
            {
            // InternalXtext.g:5413:1: ( ( rule__Disjunction__RightAssignment_1_2 ) )
            // InternalXtext.g:5414:2: ( rule__Disjunction__RightAssignment_1_2 )
            {
             before(grammarAccess.getDisjunctionAccess().getRightAssignment_1_2()); 
            // InternalXtext.g:5415:2: ( rule__Disjunction__RightAssignment_1_2 )
            // InternalXtext.g:5415:3: rule__Disjunction__RightAssignment_1_2
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
    // InternalXtext.g:5424:1: rule__Conjunction__Group__0 : rule__Conjunction__Group__0__Impl rule__Conjunction__Group__1 ;
    public final void rule__Conjunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5428:1: ( rule__Conjunction__Group__0__Impl rule__Conjunction__Group__1 )
            // InternalXtext.g:5429:2: rule__Conjunction__Group__0__Impl rule__Conjunction__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_32);
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
    // InternalXtext.g:5436:1: rule__Conjunction__Group__0__Impl : ( ruleNegation ) ;
    public final void rule__Conjunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5440:1: ( ( ruleNegation ) )
            // InternalXtext.g:5441:1: ( ruleNegation )
            {
            // InternalXtext.g:5441:1: ( ruleNegation )
            // InternalXtext.g:5442:2: ruleNegation
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
    // InternalXtext.g:5451:1: rule__Conjunction__Group__1 : rule__Conjunction__Group__1__Impl ;
    public final void rule__Conjunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5455:1: ( rule__Conjunction__Group__1__Impl )
            // InternalXtext.g:5456:2: rule__Conjunction__Group__1__Impl
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
    // InternalXtext.g:5462:1: rule__Conjunction__Group__1__Impl : ( ( rule__Conjunction__Group_1__0 )* ) ;
    public final void rule__Conjunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5466:1: ( ( ( rule__Conjunction__Group_1__0 )* ) )
            // InternalXtext.g:5467:1: ( ( rule__Conjunction__Group_1__0 )* )
            {
            // InternalXtext.g:5467:1: ( ( rule__Conjunction__Group_1__0 )* )
            // InternalXtext.g:5468:2: ( rule__Conjunction__Group_1__0 )*
            {
             before(grammarAccess.getConjunctionAccess().getGroup_1()); 
            // InternalXtext.g:5469:2: ( rule__Conjunction__Group_1__0 )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==36) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // InternalXtext.g:5469:3: rule__Conjunction__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_33);
            	    rule__Conjunction__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop59;
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
    // InternalXtext.g:5478:1: rule__Conjunction__Group_1__0 : rule__Conjunction__Group_1__0__Impl rule__Conjunction__Group_1__1 ;
    public final void rule__Conjunction__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5482:1: ( rule__Conjunction__Group_1__0__Impl rule__Conjunction__Group_1__1 )
            // InternalXtext.g:5483:2: rule__Conjunction__Group_1__0__Impl rule__Conjunction__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_32);
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
    // InternalXtext.g:5490:1: rule__Conjunction__Group_1__0__Impl : ( () ) ;
    public final void rule__Conjunction__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5494:1: ( ( () ) )
            // InternalXtext.g:5495:1: ( () )
            {
            // InternalXtext.g:5495:1: ( () )
            // InternalXtext.g:5496:2: ()
            {
             before(grammarAccess.getConjunctionAccess().getConjunctionLeftAction_1_0()); 
            // InternalXtext.g:5497:2: ()
            // InternalXtext.g:5497:3: 
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
    // InternalXtext.g:5505:1: rule__Conjunction__Group_1__1 : rule__Conjunction__Group_1__1__Impl rule__Conjunction__Group_1__2 ;
    public final void rule__Conjunction__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5509:1: ( rule__Conjunction__Group_1__1__Impl rule__Conjunction__Group_1__2 )
            // InternalXtext.g:5510:2: rule__Conjunction__Group_1__1__Impl rule__Conjunction__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_28);
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
    // InternalXtext.g:5517:1: rule__Conjunction__Group_1__1__Impl : ( '&' ) ;
    public final void rule__Conjunction__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5521:1: ( ( '&' ) )
            // InternalXtext.g:5522:1: ( '&' )
            {
            // InternalXtext.g:5522:1: ( '&' )
            // InternalXtext.g:5523:2: '&'
            {
             before(grammarAccess.getConjunctionAccess().getAmpersandKeyword_1_1()); 
            match(input,36,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:5532:1: rule__Conjunction__Group_1__2 : rule__Conjunction__Group_1__2__Impl ;
    public final void rule__Conjunction__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5536:1: ( rule__Conjunction__Group_1__2__Impl )
            // InternalXtext.g:5537:2: rule__Conjunction__Group_1__2__Impl
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
    // InternalXtext.g:5543:1: rule__Conjunction__Group_1__2__Impl : ( ( rule__Conjunction__RightAssignment_1_2 ) ) ;
    public final void rule__Conjunction__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5547:1: ( ( ( rule__Conjunction__RightAssignment_1_2 ) ) )
            // InternalXtext.g:5548:1: ( ( rule__Conjunction__RightAssignment_1_2 ) )
            {
            // InternalXtext.g:5548:1: ( ( rule__Conjunction__RightAssignment_1_2 ) )
            // InternalXtext.g:5549:2: ( rule__Conjunction__RightAssignment_1_2 )
            {
             before(grammarAccess.getConjunctionAccess().getRightAssignment_1_2()); 
            // InternalXtext.g:5550:2: ( rule__Conjunction__RightAssignment_1_2 )
            // InternalXtext.g:5550:3: rule__Conjunction__RightAssignment_1_2
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
    // InternalXtext.g:5559:1: rule__Negation__Group_1__0 : rule__Negation__Group_1__0__Impl rule__Negation__Group_1__1 ;
    public final void rule__Negation__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5563:1: ( rule__Negation__Group_1__0__Impl rule__Negation__Group_1__1 )
            // InternalXtext.g:5564:2: rule__Negation__Group_1__0__Impl rule__Negation__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_28);
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
    // InternalXtext.g:5571:1: rule__Negation__Group_1__0__Impl : ( () ) ;
    public final void rule__Negation__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5575:1: ( ( () ) )
            // InternalXtext.g:5576:1: ( () )
            {
            // InternalXtext.g:5576:1: ( () )
            // InternalXtext.g:5577:2: ()
            {
             before(grammarAccess.getNegationAccess().getNegationAction_1_0()); 
            // InternalXtext.g:5578:2: ()
            // InternalXtext.g:5578:3: 
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
    // InternalXtext.g:5586:1: rule__Negation__Group_1__1 : rule__Negation__Group_1__1__Impl rule__Negation__Group_1__2 ;
    public final void rule__Negation__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5590:1: ( rule__Negation__Group_1__1__Impl rule__Negation__Group_1__2 )
            // InternalXtext.g:5591:2: rule__Negation__Group_1__1__Impl rule__Negation__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_28);
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
    // InternalXtext.g:5598:1: rule__Negation__Group_1__1__Impl : ( '!' ) ;
    public final void rule__Negation__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5602:1: ( ( '!' ) )
            // InternalXtext.g:5603:1: ( '!' )
            {
            // InternalXtext.g:5603:1: ( '!' )
            // InternalXtext.g:5604:2: '!'
            {
             before(grammarAccess.getNegationAccess().getExclamationMarkKeyword_1_1()); 
            match(input,40,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:5613:1: rule__Negation__Group_1__2 : rule__Negation__Group_1__2__Impl ;
    public final void rule__Negation__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5617:1: ( rule__Negation__Group_1__2__Impl )
            // InternalXtext.g:5618:2: rule__Negation__Group_1__2__Impl
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
    // InternalXtext.g:5624:1: rule__Negation__Group_1__2__Impl : ( ( rule__Negation__ValueAssignment_1_2 ) ) ;
    public final void rule__Negation__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5628:1: ( ( ( rule__Negation__ValueAssignment_1_2 ) ) )
            // InternalXtext.g:5629:1: ( ( rule__Negation__ValueAssignment_1_2 ) )
            {
            // InternalXtext.g:5629:1: ( ( rule__Negation__ValueAssignment_1_2 ) )
            // InternalXtext.g:5630:2: ( rule__Negation__ValueAssignment_1_2 )
            {
             before(grammarAccess.getNegationAccess().getValueAssignment_1_2()); 
            // InternalXtext.g:5631:2: ( rule__Negation__ValueAssignment_1_2 )
            // InternalXtext.g:5631:3: rule__Negation__ValueAssignment_1_2
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
    // InternalXtext.g:5640:1: rule__ParenthesizedCondition__Group__0 : rule__ParenthesizedCondition__Group__0__Impl rule__ParenthesizedCondition__Group__1 ;
    public final void rule__ParenthesizedCondition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5644:1: ( rule__ParenthesizedCondition__Group__0__Impl rule__ParenthesizedCondition__Group__1 )
            // InternalXtext.g:5645:2: rule__ParenthesizedCondition__Group__0__Impl rule__ParenthesizedCondition__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_28);
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
    // InternalXtext.g:5652:1: rule__ParenthesizedCondition__Group__0__Impl : ( '(' ) ;
    public final void rule__ParenthesizedCondition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5656:1: ( ( '(' ) )
            // InternalXtext.g:5657:1: ( '(' )
            {
            // InternalXtext.g:5657:1: ( '(' )
            // InternalXtext.g:5658:2: '('
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
    // InternalXtext.g:5667:1: rule__ParenthesizedCondition__Group__1 : rule__ParenthesizedCondition__Group__1__Impl rule__ParenthesizedCondition__Group__2 ;
    public final void rule__ParenthesizedCondition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5671:1: ( rule__ParenthesizedCondition__Group__1__Impl rule__ParenthesizedCondition__Group__2 )
            // InternalXtext.g:5672:2: rule__ParenthesizedCondition__Group__1__Impl rule__ParenthesizedCondition__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_41);
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
    // InternalXtext.g:5679:1: rule__ParenthesizedCondition__Group__1__Impl : ( ruleDisjunction ) ;
    public final void rule__ParenthesizedCondition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5683:1: ( ( ruleDisjunction ) )
            // InternalXtext.g:5684:1: ( ruleDisjunction )
            {
            // InternalXtext.g:5684:1: ( ruleDisjunction )
            // InternalXtext.g:5685:2: ruleDisjunction
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
    // InternalXtext.g:5694:1: rule__ParenthesizedCondition__Group__2 : rule__ParenthesizedCondition__Group__2__Impl ;
    public final void rule__ParenthesizedCondition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5698:1: ( rule__ParenthesizedCondition__Group__2__Impl )
            // InternalXtext.g:5699:2: rule__ParenthesizedCondition__Group__2__Impl
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
    // InternalXtext.g:5705:1: rule__ParenthesizedCondition__Group__2__Impl : ( ')' ) ;
    public final void rule__ParenthesizedCondition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5709:1: ( ( ')' ) )
            // InternalXtext.g:5710:1: ( ')' )
            {
            // InternalXtext.g:5710:1: ( ')' )
            // InternalXtext.g:5711:2: ')'
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
    // InternalXtext.g:5721:1: rule__RuleID__Group__0 : rule__RuleID__Group__0__Impl rule__RuleID__Group__1 ;
    public final void rule__RuleID__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5725:1: ( rule__RuleID__Group__0__Impl rule__RuleID__Group__1 )
            // InternalXtext.g:5726:2: rule__RuleID__Group__0__Impl rule__RuleID__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_25);
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
    // InternalXtext.g:5733:1: rule__RuleID__Group__0__Impl : ( ruleValidID ) ;
    public final void rule__RuleID__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5737:1: ( ( ruleValidID ) )
            // InternalXtext.g:5738:1: ( ruleValidID )
            {
            // InternalXtext.g:5738:1: ( ruleValidID )
            // InternalXtext.g:5739:2: ruleValidID
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
    // InternalXtext.g:5748:1: rule__RuleID__Group__1 : rule__RuleID__Group__1__Impl ;
    public final void rule__RuleID__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5752:1: ( rule__RuleID__Group__1__Impl )
            // InternalXtext.g:5753:2: rule__RuleID__Group__1__Impl
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
    // InternalXtext.g:5759:1: rule__RuleID__Group__1__Impl : ( ( rule__RuleID__Group_1__0 )* ) ;
    public final void rule__RuleID__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5763:1: ( ( ( rule__RuleID__Group_1__0 )* ) )
            // InternalXtext.g:5764:1: ( ( rule__RuleID__Group_1__0 )* )
            {
            // InternalXtext.g:5764:1: ( ( rule__RuleID__Group_1__0 )* )
            // InternalXtext.g:5765:2: ( rule__RuleID__Group_1__0 )*
            {
             before(grammarAccess.getRuleIDAccess().getGroup_1()); 
            // InternalXtext.g:5766:2: ( rule__RuleID__Group_1__0 )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==34) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // InternalXtext.g:5766:3: rule__RuleID__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_42);
            	    rule__RuleID__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop60;
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
    // InternalXtext.g:5775:1: rule__RuleID__Group_1__0 : rule__RuleID__Group_1__0__Impl rule__RuleID__Group_1__1 ;
    public final void rule__RuleID__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5779:1: ( rule__RuleID__Group_1__0__Impl rule__RuleID__Group_1__1 )
            // InternalXtext.g:5780:2: rule__RuleID__Group_1__0__Impl rule__RuleID__Group_1__1
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
    // InternalXtext.g:5787:1: rule__RuleID__Group_1__0__Impl : ( '::' ) ;
    public final void rule__RuleID__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5791:1: ( ( '::' ) )
            // InternalXtext.g:5792:1: ( '::' )
            {
            // InternalXtext.g:5792:1: ( '::' )
            // InternalXtext.g:5793:2: '::'
            {
             before(grammarAccess.getRuleIDAccess().getColonColonKeyword_1_0()); 
            match(input,34,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:5802:1: rule__RuleID__Group_1__1 : rule__RuleID__Group_1__1__Impl ;
    public final void rule__RuleID__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5806:1: ( rule__RuleID__Group_1__1__Impl )
            // InternalXtext.g:5807:2: rule__RuleID__Group_1__1__Impl
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
    // InternalXtext.g:5813:1: rule__RuleID__Group_1__1__Impl : ( ruleValidID ) ;
    public final void rule__RuleID__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5817:1: ( ( ruleValidID ) )
            // InternalXtext.g:5818:1: ( ruleValidID )
            {
            // InternalXtext.g:5818:1: ( ruleValidID )
            // InternalXtext.g:5819:2: ruleValidID
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
    // InternalXtext.g:5829:1: rule__PredicatedKeyword__Group__0 : rule__PredicatedKeyword__Group__0__Impl rule__PredicatedKeyword__Group__1 ;
    public final void rule__PredicatedKeyword__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5833:1: ( rule__PredicatedKeyword__Group__0__Impl rule__PredicatedKeyword__Group__1 )
            // InternalXtext.g:5834:2: rule__PredicatedKeyword__Group__0__Impl rule__PredicatedKeyword__Group__1
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
    // InternalXtext.g:5841:1: rule__PredicatedKeyword__Group__0__Impl : ( ( rule__PredicatedKeyword__Alternatives_0 ) ) ;
    public final void rule__PredicatedKeyword__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5845:1: ( ( ( rule__PredicatedKeyword__Alternatives_0 ) ) )
            // InternalXtext.g:5846:1: ( ( rule__PredicatedKeyword__Alternatives_0 ) )
            {
            // InternalXtext.g:5846:1: ( ( rule__PredicatedKeyword__Alternatives_0 ) )
            // InternalXtext.g:5847:2: ( rule__PredicatedKeyword__Alternatives_0 )
            {
             before(grammarAccess.getPredicatedKeywordAccess().getAlternatives_0()); 
            // InternalXtext.g:5848:2: ( rule__PredicatedKeyword__Alternatives_0 )
            // InternalXtext.g:5848:3: rule__PredicatedKeyword__Alternatives_0
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
    // InternalXtext.g:5856:1: rule__PredicatedKeyword__Group__1 : rule__PredicatedKeyword__Group__1__Impl ;
    public final void rule__PredicatedKeyword__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5860:1: ( rule__PredicatedKeyword__Group__1__Impl )
            // InternalXtext.g:5861:2: rule__PredicatedKeyword__Group__1__Impl
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
    // InternalXtext.g:5867:1: rule__PredicatedKeyword__Group__1__Impl : ( ( rule__PredicatedKeyword__ValueAssignment_1 ) ) ;
    public final void rule__PredicatedKeyword__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5871:1: ( ( ( rule__PredicatedKeyword__ValueAssignment_1 ) ) )
            // InternalXtext.g:5872:1: ( ( rule__PredicatedKeyword__ValueAssignment_1 ) )
            {
            // InternalXtext.g:5872:1: ( ( rule__PredicatedKeyword__ValueAssignment_1 ) )
            // InternalXtext.g:5873:2: ( rule__PredicatedKeyword__ValueAssignment_1 )
            {
             before(grammarAccess.getPredicatedKeywordAccess().getValueAssignment_1()); 
            // InternalXtext.g:5874:2: ( rule__PredicatedKeyword__ValueAssignment_1 )
            // InternalXtext.g:5874:3: rule__PredicatedKeyword__ValueAssignment_1
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
    // InternalXtext.g:5883:1: rule__PredicatedRuleCall__Group__0 : rule__PredicatedRuleCall__Group__0__Impl rule__PredicatedRuleCall__Group__1 ;
    public final void rule__PredicatedRuleCall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5887:1: ( rule__PredicatedRuleCall__Group__0__Impl rule__PredicatedRuleCall__Group__1 )
            // InternalXtext.g:5888:2: rule__PredicatedRuleCall__Group__0__Impl rule__PredicatedRuleCall__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
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
    // InternalXtext.g:5895:1: rule__PredicatedRuleCall__Group__0__Impl : ( ( rule__PredicatedRuleCall__Alternatives_0 ) ) ;
    public final void rule__PredicatedRuleCall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5899:1: ( ( ( rule__PredicatedRuleCall__Alternatives_0 ) ) )
            // InternalXtext.g:5900:1: ( ( rule__PredicatedRuleCall__Alternatives_0 ) )
            {
            // InternalXtext.g:5900:1: ( ( rule__PredicatedRuleCall__Alternatives_0 ) )
            // InternalXtext.g:5901:2: ( rule__PredicatedRuleCall__Alternatives_0 )
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getAlternatives_0()); 
            // InternalXtext.g:5902:2: ( rule__PredicatedRuleCall__Alternatives_0 )
            // InternalXtext.g:5902:3: rule__PredicatedRuleCall__Alternatives_0
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
    // InternalXtext.g:5910:1: rule__PredicatedRuleCall__Group__1 : rule__PredicatedRuleCall__Group__1__Impl rule__PredicatedRuleCall__Group__2 ;
    public final void rule__PredicatedRuleCall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5914:1: ( rule__PredicatedRuleCall__Group__1__Impl rule__PredicatedRuleCall__Group__2 )
            // InternalXtext.g:5915:2: rule__PredicatedRuleCall__Group__1__Impl rule__PredicatedRuleCall__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_23);
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
    // InternalXtext.g:5922:1: rule__PredicatedRuleCall__Group__1__Impl : ( ( rule__PredicatedRuleCall__RuleAssignment_1 ) ) ;
    public final void rule__PredicatedRuleCall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5926:1: ( ( ( rule__PredicatedRuleCall__RuleAssignment_1 ) ) )
            // InternalXtext.g:5927:1: ( ( rule__PredicatedRuleCall__RuleAssignment_1 ) )
            {
            // InternalXtext.g:5927:1: ( ( rule__PredicatedRuleCall__RuleAssignment_1 ) )
            // InternalXtext.g:5928:2: ( rule__PredicatedRuleCall__RuleAssignment_1 )
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getRuleAssignment_1()); 
            // InternalXtext.g:5929:2: ( rule__PredicatedRuleCall__RuleAssignment_1 )
            // InternalXtext.g:5929:3: rule__PredicatedRuleCall__RuleAssignment_1
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
    // InternalXtext.g:5937:1: rule__PredicatedRuleCall__Group__2 : rule__PredicatedRuleCall__Group__2__Impl ;
    public final void rule__PredicatedRuleCall__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5941:1: ( rule__PredicatedRuleCall__Group__2__Impl )
            // InternalXtext.g:5942:2: rule__PredicatedRuleCall__Group__2__Impl
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
    // InternalXtext.g:5948:1: rule__PredicatedRuleCall__Group__2__Impl : ( ( rule__PredicatedRuleCall__Group_2__0 )? ) ;
    public final void rule__PredicatedRuleCall__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5952:1: ( ( ( rule__PredicatedRuleCall__Group_2__0 )? ) )
            // InternalXtext.g:5953:1: ( ( rule__PredicatedRuleCall__Group_2__0 )? )
            {
            // InternalXtext.g:5953:1: ( ( rule__PredicatedRuleCall__Group_2__0 )? )
            // InternalXtext.g:5954:2: ( rule__PredicatedRuleCall__Group_2__0 )?
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getGroup_2()); 
            // InternalXtext.g:5955:2: ( rule__PredicatedRuleCall__Group_2__0 )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==32) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalXtext.g:5955:3: rule__PredicatedRuleCall__Group_2__0
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
    // InternalXtext.g:5964:1: rule__PredicatedRuleCall__Group_2__0 : rule__PredicatedRuleCall__Group_2__0__Impl rule__PredicatedRuleCall__Group_2__1 ;
    public final void rule__PredicatedRuleCall__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5968:1: ( rule__PredicatedRuleCall__Group_2__0__Impl rule__PredicatedRuleCall__Group_2__1 )
            // InternalXtext.g:5969:2: rule__PredicatedRuleCall__Group_2__0__Impl rule__PredicatedRuleCall__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_28);
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
    // InternalXtext.g:5976:1: rule__PredicatedRuleCall__Group_2__0__Impl : ( '<' ) ;
    public final void rule__PredicatedRuleCall__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5980:1: ( ( '<' ) )
            // InternalXtext.g:5981:1: ( '<' )
            {
            // InternalXtext.g:5981:1: ( '<' )
            // InternalXtext.g:5982:2: '<'
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getLessThanSignKeyword_2_0()); 
            match(input,32,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:5991:1: rule__PredicatedRuleCall__Group_2__1 : rule__PredicatedRuleCall__Group_2__1__Impl rule__PredicatedRuleCall__Group_2__2 ;
    public final void rule__PredicatedRuleCall__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5995:1: ( rule__PredicatedRuleCall__Group_2__1__Impl rule__PredicatedRuleCall__Group_2__2 )
            // InternalXtext.g:5996:2: rule__PredicatedRuleCall__Group_2__1__Impl rule__PredicatedRuleCall__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_38);
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
    // InternalXtext.g:6003:1: rule__PredicatedRuleCall__Group_2__1__Impl : ( ( rule__PredicatedRuleCall__ArgumentsAssignment_2_1 ) ) ;
    public final void rule__PredicatedRuleCall__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6007:1: ( ( ( rule__PredicatedRuleCall__ArgumentsAssignment_2_1 ) ) )
            // InternalXtext.g:6008:1: ( ( rule__PredicatedRuleCall__ArgumentsAssignment_2_1 ) )
            {
            // InternalXtext.g:6008:1: ( ( rule__PredicatedRuleCall__ArgumentsAssignment_2_1 ) )
            // InternalXtext.g:6009:2: ( rule__PredicatedRuleCall__ArgumentsAssignment_2_1 )
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getArgumentsAssignment_2_1()); 
            // InternalXtext.g:6010:2: ( rule__PredicatedRuleCall__ArgumentsAssignment_2_1 )
            // InternalXtext.g:6010:3: rule__PredicatedRuleCall__ArgumentsAssignment_2_1
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
    // InternalXtext.g:6018:1: rule__PredicatedRuleCall__Group_2__2 : rule__PredicatedRuleCall__Group_2__2__Impl rule__PredicatedRuleCall__Group_2__3 ;
    public final void rule__PredicatedRuleCall__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6022:1: ( rule__PredicatedRuleCall__Group_2__2__Impl rule__PredicatedRuleCall__Group_2__3 )
            // InternalXtext.g:6023:2: rule__PredicatedRuleCall__Group_2__2__Impl rule__PredicatedRuleCall__Group_2__3
            {
            pushFollow(FollowSets000.FOLLOW_38);
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
    // InternalXtext.g:6030:1: rule__PredicatedRuleCall__Group_2__2__Impl : ( ( rule__PredicatedRuleCall__Group_2_2__0 )* ) ;
    public final void rule__PredicatedRuleCall__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6034:1: ( ( ( rule__PredicatedRuleCall__Group_2_2__0 )* ) )
            // InternalXtext.g:6035:1: ( ( rule__PredicatedRuleCall__Group_2_2__0 )* )
            {
            // InternalXtext.g:6035:1: ( ( rule__PredicatedRuleCall__Group_2_2__0 )* )
            // InternalXtext.g:6036:2: ( rule__PredicatedRuleCall__Group_2_2__0 )*
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getGroup_2_2()); 
            // InternalXtext.g:6037:2: ( rule__PredicatedRuleCall__Group_2_2__0 )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==21) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalXtext.g:6037:3: rule__PredicatedRuleCall__Group_2_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    rule__PredicatedRuleCall__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop62;
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
    // InternalXtext.g:6045:1: rule__PredicatedRuleCall__Group_2__3 : rule__PredicatedRuleCall__Group_2__3__Impl ;
    public final void rule__PredicatedRuleCall__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6049:1: ( rule__PredicatedRuleCall__Group_2__3__Impl )
            // InternalXtext.g:6050:2: rule__PredicatedRuleCall__Group_2__3__Impl
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
    // InternalXtext.g:6056:1: rule__PredicatedRuleCall__Group_2__3__Impl : ( '>' ) ;
    public final void rule__PredicatedRuleCall__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6060:1: ( ( '>' ) )
            // InternalXtext.g:6061:1: ( '>' )
            {
            // InternalXtext.g:6061:1: ( '>' )
            // InternalXtext.g:6062:2: '>'
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getGreaterThanSignKeyword_2_3()); 
            match(input,33,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:6072:1: rule__PredicatedRuleCall__Group_2_2__0 : rule__PredicatedRuleCall__Group_2_2__0__Impl rule__PredicatedRuleCall__Group_2_2__1 ;
    public final void rule__PredicatedRuleCall__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6076:1: ( rule__PredicatedRuleCall__Group_2_2__0__Impl rule__PredicatedRuleCall__Group_2_2__1 )
            // InternalXtext.g:6077:2: rule__PredicatedRuleCall__Group_2_2__0__Impl rule__PredicatedRuleCall__Group_2_2__1
            {
            pushFollow(FollowSets000.FOLLOW_28);
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
    // InternalXtext.g:6084:1: rule__PredicatedRuleCall__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__PredicatedRuleCall__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6088:1: ( ( ',' ) )
            // InternalXtext.g:6089:1: ( ',' )
            {
            // InternalXtext.g:6089:1: ( ',' )
            // InternalXtext.g:6090:2: ','
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
    // InternalXtext.g:6099:1: rule__PredicatedRuleCall__Group_2_2__1 : rule__PredicatedRuleCall__Group_2_2__1__Impl ;
    public final void rule__PredicatedRuleCall__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6103:1: ( rule__PredicatedRuleCall__Group_2_2__1__Impl )
            // InternalXtext.g:6104:2: rule__PredicatedRuleCall__Group_2_2__1__Impl
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
    // InternalXtext.g:6110:1: rule__PredicatedRuleCall__Group_2_2__1__Impl : ( ( rule__PredicatedRuleCall__ArgumentsAssignment_2_2_1 ) ) ;
    public final void rule__PredicatedRuleCall__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6114:1: ( ( ( rule__PredicatedRuleCall__ArgumentsAssignment_2_2_1 ) ) )
            // InternalXtext.g:6115:1: ( ( rule__PredicatedRuleCall__ArgumentsAssignment_2_2_1 ) )
            {
            // InternalXtext.g:6115:1: ( ( rule__PredicatedRuleCall__ArgumentsAssignment_2_2_1 ) )
            // InternalXtext.g:6116:2: ( rule__PredicatedRuleCall__ArgumentsAssignment_2_2_1 )
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getArgumentsAssignment_2_2_1()); 
            // InternalXtext.g:6117:2: ( rule__PredicatedRuleCall__ArgumentsAssignment_2_2_1 )
            // InternalXtext.g:6117:3: rule__PredicatedRuleCall__ArgumentsAssignment_2_2_1
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
    // InternalXtext.g:6126:1: rule__Assignment__Group__0 : rule__Assignment__Group__0__Impl rule__Assignment__Group__1 ;
    public final void rule__Assignment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6130:1: ( rule__Assignment__Group__0__Impl rule__Assignment__Group__1 )
            // InternalXtext.g:6131:2: rule__Assignment__Group__0__Impl rule__Assignment__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_43);
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
    // InternalXtext.g:6138:1: rule__Assignment__Group__0__Impl : ( ( rule__Assignment__Alternatives_0 )? ) ;
    public final void rule__Assignment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6142:1: ( ( ( rule__Assignment__Alternatives_0 )? ) )
            // InternalXtext.g:6143:1: ( ( rule__Assignment__Alternatives_0 )? )
            {
            // InternalXtext.g:6143:1: ( ( rule__Assignment__Alternatives_0 )? )
            // InternalXtext.g:6144:2: ( rule__Assignment__Alternatives_0 )?
            {
             before(grammarAccess.getAssignmentAccess().getAlternatives_0()); 
            // InternalXtext.g:6145:2: ( rule__Assignment__Alternatives_0 )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==44||LA63_0==50) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalXtext.g:6145:3: rule__Assignment__Alternatives_0
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
    // InternalXtext.g:6153:1: rule__Assignment__Group__1 : rule__Assignment__Group__1__Impl rule__Assignment__Group__2 ;
    public final void rule__Assignment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6157:1: ( rule__Assignment__Group__1__Impl rule__Assignment__Group__2 )
            // InternalXtext.g:6158:2: rule__Assignment__Group__1__Impl rule__Assignment__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_44);
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
    // InternalXtext.g:6165:1: rule__Assignment__Group__1__Impl : ( ( rule__Assignment__FeatureAssignment_1 ) ) ;
    public final void rule__Assignment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6169:1: ( ( ( rule__Assignment__FeatureAssignment_1 ) ) )
            // InternalXtext.g:6170:1: ( ( rule__Assignment__FeatureAssignment_1 ) )
            {
            // InternalXtext.g:6170:1: ( ( rule__Assignment__FeatureAssignment_1 ) )
            // InternalXtext.g:6171:2: ( rule__Assignment__FeatureAssignment_1 )
            {
             before(grammarAccess.getAssignmentAccess().getFeatureAssignment_1()); 
            // InternalXtext.g:6172:2: ( rule__Assignment__FeatureAssignment_1 )
            // InternalXtext.g:6172:3: rule__Assignment__FeatureAssignment_1
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
    // InternalXtext.g:6180:1: rule__Assignment__Group__2 : rule__Assignment__Group__2__Impl rule__Assignment__Group__3 ;
    public final void rule__Assignment__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6184:1: ( rule__Assignment__Group__2__Impl rule__Assignment__Group__3 )
            // InternalXtext.g:6185:2: rule__Assignment__Group__2__Impl rule__Assignment__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_45);
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
    // InternalXtext.g:6192:1: rule__Assignment__Group__2__Impl : ( ( rule__Assignment__OperatorAssignment_2 ) ) ;
    public final void rule__Assignment__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6196:1: ( ( ( rule__Assignment__OperatorAssignment_2 ) ) )
            // InternalXtext.g:6197:1: ( ( rule__Assignment__OperatorAssignment_2 ) )
            {
            // InternalXtext.g:6197:1: ( ( rule__Assignment__OperatorAssignment_2 ) )
            // InternalXtext.g:6198:2: ( rule__Assignment__OperatorAssignment_2 )
            {
             before(grammarAccess.getAssignmentAccess().getOperatorAssignment_2()); 
            // InternalXtext.g:6199:2: ( rule__Assignment__OperatorAssignment_2 )
            // InternalXtext.g:6199:3: rule__Assignment__OperatorAssignment_2
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
    // InternalXtext.g:6207:1: rule__Assignment__Group__3 : rule__Assignment__Group__3__Impl ;
    public final void rule__Assignment__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6211:1: ( rule__Assignment__Group__3__Impl )
            // InternalXtext.g:6212:2: rule__Assignment__Group__3__Impl
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
    // InternalXtext.g:6218:1: rule__Assignment__Group__3__Impl : ( ( rule__Assignment__TerminalAssignment_3 ) ) ;
    public final void rule__Assignment__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6222:1: ( ( ( rule__Assignment__TerminalAssignment_3 ) ) )
            // InternalXtext.g:6223:1: ( ( rule__Assignment__TerminalAssignment_3 ) )
            {
            // InternalXtext.g:6223:1: ( ( rule__Assignment__TerminalAssignment_3 ) )
            // InternalXtext.g:6224:2: ( rule__Assignment__TerminalAssignment_3 )
            {
             before(grammarAccess.getAssignmentAccess().getTerminalAssignment_3()); 
            // InternalXtext.g:6225:2: ( rule__Assignment__TerminalAssignment_3 )
            // InternalXtext.g:6225:3: rule__Assignment__TerminalAssignment_3
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
    // InternalXtext.g:6234:1: rule__ParenthesizedAssignableElement__Group__0 : rule__ParenthesizedAssignableElement__Group__0__Impl rule__ParenthesizedAssignableElement__Group__1 ;
    public final void rule__ParenthesizedAssignableElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6238:1: ( rule__ParenthesizedAssignableElement__Group__0__Impl rule__ParenthesizedAssignableElement__Group__1 )
            // InternalXtext.g:6239:2: rule__ParenthesizedAssignableElement__Group__0__Impl rule__ParenthesizedAssignableElement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_45);
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
    // InternalXtext.g:6246:1: rule__ParenthesizedAssignableElement__Group__0__Impl : ( '(' ) ;
    public final void rule__ParenthesizedAssignableElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6250:1: ( ( '(' ) )
            // InternalXtext.g:6251:1: ( '(' )
            {
            // InternalXtext.g:6251:1: ( '(' )
            // InternalXtext.g:6252:2: '('
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
    // InternalXtext.g:6261:1: rule__ParenthesizedAssignableElement__Group__1 : rule__ParenthesizedAssignableElement__Group__1__Impl rule__ParenthesizedAssignableElement__Group__2 ;
    public final void rule__ParenthesizedAssignableElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6265:1: ( rule__ParenthesizedAssignableElement__Group__1__Impl rule__ParenthesizedAssignableElement__Group__2 )
            // InternalXtext.g:6266:2: rule__ParenthesizedAssignableElement__Group__1__Impl rule__ParenthesizedAssignableElement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_41);
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
    // InternalXtext.g:6273:1: rule__ParenthesizedAssignableElement__Group__1__Impl : ( ruleAssignableAlternatives ) ;
    public final void rule__ParenthesizedAssignableElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6277:1: ( ( ruleAssignableAlternatives ) )
            // InternalXtext.g:6278:1: ( ruleAssignableAlternatives )
            {
            // InternalXtext.g:6278:1: ( ruleAssignableAlternatives )
            // InternalXtext.g:6279:2: ruleAssignableAlternatives
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
    // InternalXtext.g:6288:1: rule__ParenthesizedAssignableElement__Group__2 : rule__ParenthesizedAssignableElement__Group__2__Impl ;
    public final void rule__ParenthesizedAssignableElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6292:1: ( rule__ParenthesizedAssignableElement__Group__2__Impl )
            // InternalXtext.g:6293:2: rule__ParenthesizedAssignableElement__Group__2__Impl
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
    // InternalXtext.g:6299:1: rule__ParenthesizedAssignableElement__Group__2__Impl : ( ')' ) ;
    public final void rule__ParenthesizedAssignableElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6303:1: ( ( ')' ) )
            // InternalXtext.g:6304:1: ( ')' )
            {
            // InternalXtext.g:6304:1: ( ')' )
            // InternalXtext.g:6305:2: ')'
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
    // InternalXtext.g:6315:1: rule__AssignableAlternatives__Group__0 : rule__AssignableAlternatives__Group__0__Impl rule__AssignableAlternatives__Group__1 ;
    public final void rule__AssignableAlternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6319:1: ( rule__AssignableAlternatives__Group__0__Impl rule__AssignableAlternatives__Group__1 )
            // InternalXtext.g:6320:2: rule__AssignableAlternatives__Group__0__Impl rule__AssignableAlternatives__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_26);
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
    // InternalXtext.g:6327:1: rule__AssignableAlternatives__Group__0__Impl : ( ruleAssignableTerminal ) ;
    public final void rule__AssignableAlternatives__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6331:1: ( ( ruleAssignableTerminal ) )
            // InternalXtext.g:6332:1: ( ruleAssignableTerminal )
            {
            // InternalXtext.g:6332:1: ( ruleAssignableTerminal )
            // InternalXtext.g:6333:2: ruleAssignableTerminal
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
    // InternalXtext.g:6342:1: rule__AssignableAlternatives__Group__1 : rule__AssignableAlternatives__Group__1__Impl ;
    public final void rule__AssignableAlternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6346:1: ( rule__AssignableAlternatives__Group__1__Impl )
            // InternalXtext.g:6347:2: rule__AssignableAlternatives__Group__1__Impl
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
    // InternalXtext.g:6353:1: rule__AssignableAlternatives__Group__1__Impl : ( ( rule__AssignableAlternatives__Group_1__0 )? ) ;
    public final void rule__AssignableAlternatives__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6357:1: ( ( ( rule__AssignableAlternatives__Group_1__0 )? ) )
            // InternalXtext.g:6358:1: ( ( rule__AssignableAlternatives__Group_1__0 )? )
            {
            // InternalXtext.g:6358:1: ( ( rule__AssignableAlternatives__Group_1__0 )? )
            // InternalXtext.g:6359:2: ( rule__AssignableAlternatives__Group_1__0 )?
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup_1()); 
            // InternalXtext.g:6360:2: ( rule__AssignableAlternatives__Group_1__0 )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==35) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalXtext.g:6360:3: rule__AssignableAlternatives__Group_1__0
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
    // InternalXtext.g:6369:1: rule__AssignableAlternatives__Group_1__0 : rule__AssignableAlternatives__Group_1__0__Impl rule__AssignableAlternatives__Group_1__1 ;
    public final void rule__AssignableAlternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6373:1: ( rule__AssignableAlternatives__Group_1__0__Impl rule__AssignableAlternatives__Group_1__1 )
            // InternalXtext.g:6374:2: rule__AssignableAlternatives__Group_1__0__Impl rule__AssignableAlternatives__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_26);
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
    // InternalXtext.g:6381:1: rule__AssignableAlternatives__Group_1__0__Impl : ( () ) ;
    public final void rule__AssignableAlternatives__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6385:1: ( ( () ) )
            // InternalXtext.g:6386:1: ( () )
            {
            // InternalXtext.g:6386:1: ( () )
            // InternalXtext.g:6387:2: ()
            {
             before(grammarAccess.getAssignableAlternativesAccess().getAlternativesElementsAction_1_0()); 
            // InternalXtext.g:6388:2: ()
            // InternalXtext.g:6388:3: 
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
    // InternalXtext.g:6396:1: rule__AssignableAlternatives__Group_1__1 : rule__AssignableAlternatives__Group_1__1__Impl ;
    public final void rule__AssignableAlternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6400:1: ( rule__AssignableAlternatives__Group_1__1__Impl )
            // InternalXtext.g:6401:2: rule__AssignableAlternatives__Group_1__1__Impl
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
    // InternalXtext.g:6407:1: rule__AssignableAlternatives__Group_1__1__Impl : ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) ) ;
    public final void rule__AssignableAlternatives__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6411:1: ( ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) ) )
            // InternalXtext.g:6412:1: ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) )
            {
            // InternalXtext.g:6412:1: ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) )
            // InternalXtext.g:6413:2: ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* )
            {
            // InternalXtext.g:6413:2: ( ( rule__AssignableAlternatives__Group_1_1__0 ) )
            // InternalXtext.g:6414:3: ( rule__AssignableAlternatives__Group_1_1__0 )
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 
            // InternalXtext.g:6415:3: ( rule__AssignableAlternatives__Group_1_1__0 )
            // InternalXtext.g:6415:4: rule__AssignableAlternatives__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_27);
            rule__AssignableAlternatives__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 

            }

            // InternalXtext.g:6418:2: ( ( rule__AssignableAlternatives__Group_1_1__0 )* )
            // InternalXtext.g:6419:3: ( rule__AssignableAlternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 
            // InternalXtext.g:6420:3: ( rule__AssignableAlternatives__Group_1_1__0 )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==35) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // InternalXtext.g:6420:4: rule__AssignableAlternatives__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_27);
            	    rule__AssignableAlternatives__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop65;
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
    // InternalXtext.g:6430:1: rule__AssignableAlternatives__Group_1_1__0 : rule__AssignableAlternatives__Group_1_1__0__Impl rule__AssignableAlternatives__Group_1_1__1 ;
    public final void rule__AssignableAlternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6434:1: ( rule__AssignableAlternatives__Group_1_1__0__Impl rule__AssignableAlternatives__Group_1_1__1 )
            // InternalXtext.g:6435:2: rule__AssignableAlternatives__Group_1_1__0__Impl rule__AssignableAlternatives__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_45);
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
    // InternalXtext.g:6442:1: rule__AssignableAlternatives__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__AssignableAlternatives__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6446:1: ( ( '|' ) )
            // InternalXtext.g:6447:1: ( '|' )
            {
            // InternalXtext.g:6447:1: ( '|' )
            // InternalXtext.g:6448:2: '|'
            {
             before(grammarAccess.getAssignableAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,35,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:6457:1: rule__AssignableAlternatives__Group_1_1__1 : rule__AssignableAlternatives__Group_1_1__1__Impl ;
    public final void rule__AssignableAlternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6461:1: ( rule__AssignableAlternatives__Group_1_1__1__Impl )
            // InternalXtext.g:6462:2: rule__AssignableAlternatives__Group_1_1__1__Impl
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
    // InternalXtext.g:6468:1: rule__AssignableAlternatives__Group_1_1__1__Impl : ( ( rule__AssignableAlternatives__ElementsAssignment_1_1_1 ) ) ;
    public final void rule__AssignableAlternatives__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6472:1: ( ( ( rule__AssignableAlternatives__ElementsAssignment_1_1_1 ) ) )
            // InternalXtext.g:6473:1: ( ( rule__AssignableAlternatives__ElementsAssignment_1_1_1 ) )
            {
            // InternalXtext.g:6473:1: ( ( rule__AssignableAlternatives__ElementsAssignment_1_1_1 ) )
            // InternalXtext.g:6474:2: ( rule__AssignableAlternatives__ElementsAssignment_1_1_1 )
            {
             before(grammarAccess.getAssignableAlternativesAccess().getElementsAssignment_1_1_1()); 
            // InternalXtext.g:6475:2: ( rule__AssignableAlternatives__ElementsAssignment_1_1_1 )
            // InternalXtext.g:6475:3: rule__AssignableAlternatives__ElementsAssignment_1_1_1
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
    // InternalXtext.g:6484:1: rule__CrossReference__Group__0 : rule__CrossReference__Group__0__Impl rule__CrossReference__Group__1 ;
    public final void rule__CrossReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6488:1: ( rule__CrossReference__Group__0__Impl rule__CrossReference__Group__1 )
            // InternalXtext.g:6489:2: rule__CrossReference__Group__0__Impl rule__CrossReference__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_15);
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
    // InternalXtext.g:6496:1: rule__CrossReference__Group__0__Impl : ( '[' ) ;
    public final void rule__CrossReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6500:1: ( ( '[' ) )
            // InternalXtext.g:6501:1: ( '[' )
            {
            // InternalXtext.g:6501:1: ( '[' )
            // InternalXtext.g:6502:2: '['
            {
             before(grammarAccess.getCrossReferenceAccess().getLeftSquareBracketKeyword_0()); 
            match(input,41,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:6511:1: rule__CrossReference__Group__1 : rule__CrossReference__Group__1__Impl rule__CrossReference__Group__2 ;
    public final void rule__CrossReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6515:1: ( rule__CrossReference__Group__1__Impl rule__CrossReference__Group__2 )
            // InternalXtext.g:6516:2: rule__CrossReference__Group__1__Impl rule__CrossReference__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_46);
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
    // InternalXtext.g:6523:1: rule__CrossReference__Group__1__Impl : ( ( rule__CrossReference__TypeAssignment_1 ) ) ;
    public final void rule__CrossReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6527:1: ( ( ( rule__CrossReference__TypeAssignment_1 ) ) )
            // InternalXtext.g:6528:1: ( ( rule__CrossReference__TypeAssignment_1 ) )
            {
            // InternalXtext.g:6528:1: ( ( rule__CrossReference__TypeAssignment_1 ) )
            // InternalXtext.g:6529:2: ( rule__CrossReference__TypeAssignment_1 )
            {
             before(grammarAccess.getCrossReferenceAccess().getTypeAssignment_1()); 
            // InternalXtext.g:6530:2: ( rule__CrossReference__TypeAssignment_1 )
            // InternalXtext.g:6530:3: rule__CrossReference__TypeAssignment_1
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
    // InternalXtext.g:6538:1: rule__CrossReference__Group__2 : rule__CrossReference__Group__2__Impl rule__CrossReference__Group__3 ;
    public final void rule__CrossReference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6542:1: ( rule__CrossReference__Group__2__Impl rule__CrossReference__Group__3 )
            // InternalXtext.g:6543:2: rule__CrossReference__Group__2__Impl rule__CrossReference__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_46);
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
    // InternalXtext.g:6550:1: rule__CrossReference__Group__2__Impl : ( ( rule__CrossReference__Group_2__0 )? ) ;
    public final void rule__CrossReference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6554:1: ( ( ( rule__CrossReference__Group_2__0 )? ) )
            // InternalXtext.g:6555:1: ( ( rule__CrossReference__Group_2__0 )? )
            {
            // InternalXtext.g:6555:1: ( ( rule__CrossReference__Group_2__0 )? )
            // InternalXtext.g:6556:2: ( rule__CrossReference__Group_2__0 )?
            {
             before(grammarAccess.getCrossReferenceAccess().getGroup_2()); 
            // InternalXtext.g:6557:2: ( rule__CrossReference__Group_2__0 )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==35) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalXtext.g:6557:3: rule__CrossReference__Group_2__0
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
    // InternalXtext.g:6565:1: rule__CrossReference__Group__3 : rule__CrossReference__Group__3__Impl ;
    public final void rule__CrossReference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6569:1: ( rule__CrossReference__Group__3__Impl )
            // InternalXtext.g:6570:2: rule__CrossReference__Group__3__Impl
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
    // InternalXtext.g:6576:1: rule__CrossReference__Group__3__Impl : ( ']' ) ;
    public final void rule__CrossReference__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6580:1: ( ( ']' ) )
            // InternalXtext.g:6581:1: ( ']' )
            {
            // InternalXtext.g:6581:1: ( ']' )
            // InternalXtext.g:6582:2: ']'
            {
             before(grammarAccess.getCrossReferenceAccess().getRightSquareBracketKeyword_3()); 
            match(input,42,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:6592:1: rule__CrossReference__Group_2__0 : rule__CrossReference__Group_2__0__Impl rule__CrossReference__Group_2__1 ;
    public final void rule__CrossReference__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6596:1: ( rule__CrossReference__Group_2__0__Impl rule__CrossReference__Group_2__1 )
            // InternalXtext.g:6597:2: rule__CrossReference__Group_2__0__Impl rule__CrossReference__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_47);
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
    // InternalXtext.g:6604:1: rule__CrossReference__Group_2__0__Impl : ( '|' ) ;
    public final void rule__CrossReference__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6608:1: ( ( '|' ) )
            // InternalXtext.g:6609:1: ( '|' )
            {
            // InternalXtext.g:6609:1: ( '|' )
            // InternalXtext.g:6610:2: '|'
            {
             before(grammarAccess.getCrossReferenceAccess().getVerticalLineKeyword_2_0()); 
            match(input,35,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:6619:1: rule__CrossReference__Group_2__1 : rule__CrossReference__Group_2__1__Impl ;
    public final void rule__CrossReference__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6623:1: ( rule__CrossReference__Group_2__1__Impl )
            // InternalXtext.g:6624:2: rule__CrossReference__Group_2__1__Impl
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
    // InternalXtext.g:6630:1: rule__CrossReference__Group_2__1__Impl : ( ( rule__CrossReference__TerminalAssignment_2_1 ) ) ;
    public final void rule__CrossReference__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6634:1: ( ( ( rule__CrossReference__TerminalAssignment_2_1 ) ) )
            // InternalXtext.g:6635:1: ( ( rule__CrossReference__TerminalAssignment_2_1 ) )
            {
            // InternalXtext.g:6635:1: ( ( rule__CrossReference__TerminalAssignment_2_1 ) )
            // InternalXtext.g:6636:2: ( rule__CrossReference__TerminalAssignment_2_1 )
            {
             before(grammarAccess.getCrossReferenceAccess().getTerminalAssignment_2_1()); 
            // InternalXtext.g:6637:2: ( rule__CrossReference__TerminalAssignment_2_1 )
            // InternalXtext.g:6637:3: rule__CrossReference__TerminalAssignment_2_1
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
    // InternalXtext.g:6646:1: rule__ParenthesizedElement__Group__0 : rule__ParenthesizedElement__Group__0__Impl rule__ParenthesizedElement__Group__1 ;
    public final void rule__ParenthesizedElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6650:1: ( rule__ParenthesizedElement__Group__0__Impl rule__ParenthesizedElement__Group__1 )
            // InternalXtext.g:6651:2: rule__ParenthesizedElement__Group__0__Impl rule__ParenthesizedElement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_19);
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
    // InternalXtext.g:6658:1: rule__ParenthesizedElement__Group__0__Impl : ( '(' ) ;
    public final void rule__ParenthesizedElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6662:1: ( ( '(' ) )
            // InternalXtext.g:6663:1: ( '(' )
            {
            // InternalXtext.g:6663:1: ( '(' )
            // InternalXtext.g:6664:2: '('
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
    // InternalXtext.g:6673:1: rule__ParenthesizedElement__Group__1 : rule__ParenthesizedElement__Group__1__Impl rule__ParenthesizedElement__Group__2 ;
    public final void rule__ParenthesizedElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6677:1: ( rule__ParenthesizedElement__Group__1__Impl rule__ParenthesizedElement__Group__2 )
            // InternalXtext.g:6678:2: rule__ParenthesizedElement__Group__1__Impl rule__ParenthesizedElement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_41);
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
    // InternalXtext.g:6685:1: rule__ParenthesizedElement__Group__1__Impl : ( ruleAlternatives ) ;
    public final void rule__ParenthesizedElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6689:1: ( ( ruleAlternatives ) )
            // InternalXtext.g:6690:1: ( ruleAlternatives )
            {
            // InternalXtext.g:6690:1: ( ruleAlternatives )
            // InternalXtext.g:6691:2: ruleAlternatives
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
    // InternalXtext.g:6700:1: rule__ParenthesizedElement__Group__2 : rule__ParenthesizedElement__Group__2__Impl ;
    public final void rule__ParenthesizedElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6704:1: ( rule__ParenthesizedElement__Group__2__Impl )
            // InternalXtext.g:6705:2: rule__ParenthesizedElement__Group__2__Impl
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
    // InternalXtext.g:6711:1: rule__ParenthesizedElement__Group__2__Impl : ( ')' ) ;
    public final void rule__ParenthesizedElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6715:1: ( ( ')' ) )
            // InternalXtext.g:6716:1: ( ')' )
            {
            // InternalXtext.g:6716:1: ( ')' )
            // InternalXtext.g:6717:2: ')'
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
    // InternalXtext.g:6727:1: rule__PredicatedGroup__Group__0 : rule__PredicatedGroup__Group__0__Impl rule__PredicatedGroup__Group__1 ;
    public final void rule__PredicatedGroup__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6731:1: ( rule__PredicatedGroup__Group__0__Impl rule__PredicatedGroup__Group__1 )
            // InternalXtext.g:6732:2: rule__PredicatedGroup__Group__0__Impl rule__PredicatedGroup__Group__1
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
    // InternalXtext.g:6739:1: rule__PredicatedGroup__Group__0__Impl : ( ( rule__PredicatedGroup__Alternatives_0 ) ) ;
    public final void rule__PredicatedGroup__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6743:1: ( ( ( rule__PredicatedGroup__Alternatives_0 ) ) )
            // InternalXtext.g:6744:1: ( ( rule__PredicatedGroup__Alternatives_0 ) )
            {
            // InternalXtext.g:6744:1: ( ( rule__PredicatedGroup__Alternatives_0 ) )
            // InternalXtext.g:6745:2: ( rule__PredicatedGroup__Alternatives_0 )
            {
             before(grammarAccess.getPredicatedGroupAccess().getAlternatives_0()); 
            // InternalXtext.g:6746:2: ( rule__PredicatedGroup__Alternatives_0 )
            // InternalXtext.g:6746:3: rule__PredicatedGroup__Alternatives_0
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
    // InternalXtext.g:6754:1: rule__PredicatedGroup__Group__1 : rule__PredicatedGroup__Group__1__Impl rule__PredicatedGroup__Group__2 ;
    public final void rule__PredicatedGroup__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6758:1: ( rule__PredicatedGroup__Group__1__Impl rule__PredicatedGroup__Group__2 )
            // InternalXtext.g:6759:2: rule__PredicatedGroup__Group__1__Impl rule__PredicatedGroup__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_19);
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
    // InternalXtext.g:6766:1: rule__PredicatedGroup__Group__1__Impl : ( '(' ) ;
    public final void rule__PredicatedGroup__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6770:1: ( ( '(' ) )
            // InternalXtext.g:6771:1: ( '(' )
            {
            // InternalXtext.g:6771:1: ( '(' )
            // InternalXtext.g:6772:2: '('
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
    // InternalXtext.g:6781:1: rule__PredicatedGroup__Group__2 : rule__PredicatedGroup__Group__2__Impl rule__PredicatedGroup__Group__3 ;
    public final void rule__PredicatedGroup__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6785:1: ( rule__PredicatedGroup__Group__2__Impl rule__PredicatedGroup__Group__3 )
            // InternalXtext.g:6786:2: rule__PredicatedGroup__Group__2__Impl rule__PredicatedGroup__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_41);
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
    // InternalXtext.g:6793:1: rule__PredicatedGroup__Group__2__Impl : ( ( rule__PredicatedGroup__ElementsAssignment_2 ) ) ;
    public final void rule__PredicatedGroup__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6797:1: ( ( ( rule__PredicatedGroup__ElementsAssignment_2 ) ) )
            // InternalXtext.g:6798:1: ( ( rule__PredicatedGroup__ElementsAssignment_2 ) )
            {
            // InternalXtext.g:6798:1: ( ( rule__PredicatedGroup__ElementsAssignment_2 ) )
            // InternalXtext.g:6799:2: ( rule__PredicatedGroup__ElementsAssignment_2 )
            {
             before(grammarAccess.getPredicatedGroupAccess().getElementsAssignment_2()); 
            // InternalXtext.g:6800:2: ( rule__PredicatedGroup__ElementsAssignment_2 )
            // InternalXtext.g:6800:3: rule__PredicatedGroup__ElementsAssignment_2
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
    // InternalXtext.g:6808:1: rule__PredicatedGroup__Group__3 : rule__PredicatedGroup__Group__3__Impl ;
    public final void rule__PredicatedGroup__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6812:1: ( rule__PredicatedGroup__Group__3__Impl )
            // InternalXtext.g:6813:2: rule__PredicatedGroup__Group__3__Impl
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
    // InternalXtext.g:6819:1: rule__PredicatedGroup__Group__3__Impl : ( ')' ) ;
    public final void rule__PredicatedGroup__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6823:1: ( ( ')' ) )
            // InternalXtext.g:6824:1: ( ')' )
            {
            // InternalXtext.g:6824:1: ( ')' )
            // InternalXtext.g:6825:2: ')'
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
    // InternalXtext.g:6835:1: rule__TerminalRule__Group__0 : rule__TerminalRule__Group__0__Impl rule__TerminalRule__Group__1 ;
    public final void rule__TerminalRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6839:1: ( rule__TerminalRule__Group__0__Impl rule__TerminalRule__Group__1 )
            // InternalXtext.g:6840:2: rule__TerminalRule__Group__0__Impl rule__TerminalRule__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_48);
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
    // InternalXtext.g:6847:1: rule__TerminalRule__Group__0__Impl : ( ( rule__TerminalRule__AnnotationsAssignment_0 )* ) ;
    public final void rule__TerminalRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6851:1: ( ( ( rule__TerminalRule__AnnotationsAssignment_0 )* ) )
            // InternalXtext.g:6852:1: ( ( rule__TerminalRule__AnnotationsAssignment_0 )* )
            {
            // InternalXtext.g:6852:1: ( ( rule__TerminalRule__AnnotationsAssignment_0 )* )
            // InternalXtext.g:6853:2: ( rule__TerminalRule__AnnotationsAssignment_0 )*
            {
             before(grammarAccess.getTerminalRuleAccess().getAnnotationsAssignment_0()); 
            // InternalXtext.g:6854:2: ( rule__TerminalRule__AnnotationsAssignment_0 )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==28) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // InternalXtext.g:6854:3: rule__TerminalRule__AnnotationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_17);
            	    rule__TerminalRule__AnnotationsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop67;
                }
            } while (true);

             after(grammarAccess.getTerminalRuleAccess().getAnnotationsAssignment_0()); 

            }


            }

        }
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
    // InternalXtext.g:6862:1: rule__TerminalRule__Group__1 : rule__TerminalRule__Group__1__Impl rule__TerminalRule__Group__2 ;
    public final void rule__TerminalRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6866:1: ( rule__TerminalRule__Group__1__Impl rule__TerminalRule__Group__2 )
            // InternalXtext.g:6867:2: rule__TerminalRule__Group__1__Impl rule__TerminalRule__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_49);
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
    // InternalXtext.g:6874:1: rule__TerminalRule__Group__1__Impl : ( 'terminal' ) ;
    public final void rule__TerminalRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6878:1: ( ( 'terminal' ) )
            // InternalXtext.g:6879:1: ( 'terminal' )
            {
            // InternalXtext.g:6879:1: ( 'terminal' )
            // InternalXtext.g:6880:2: 'terminal'
            {
             before(grammarAccess.getTerminalRuleAccess().getTerminalKeyword_1()); 
            match(input,43,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTerminalRuleAccess().getTerminalKeyword_1()); 

            }


            }

        }
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
    // InternalXtext.g:6889:1: rule__TerminalRule__Group__2 : rule__TerminalRule__Group__2__Impl rule__TerminalRule__Group__3 ;
    public final void rule__TerminalRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6893:1: ( rule__TerminalRule__Group__2__Impl rule__TerminalRule__Group__3 )
            // InternalXtext.g:6894:2: rule__TerminalRule__Group__2__Impl rule__TerminalRule__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_50);
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
    // InternalXtext.g:6901:1: rule__TerminalRule__Group__2__Impl : ( ( rule__TerminalRule__Alternatives_2 ) ) ;
    public final void rule__TerminalRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6905:1: ( ( ( rule__TerminalRule__Alternatives_2 ) ) )
            // InternalXtext.g:6906:1: ( ( rule__TerminalRule__Alternatives_2 ) )
            {
            // InternalXtext.g:6906:1: ( ( rule__TerminalRule__Alternatives_2 ) )
            // InternalXtext.g:6907:2: ( rule__TerminalRule__Alternatives_2 )
            {
             before(grammarAccess.getTerminalRuleAccess().getAlternatives_2()); 
            // InternalXtext.g:6908:2: ( rule__TerminalRule__Alternatives_2 )
            // InternalXtext.g:6908:3: rule__TerminalRule__Alternatives_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__Alternatives_2();

            state._fsp--;


            }

             after(grammarAccess.getTerminalRuleAccess().getAlternatives_2()); 

            }


            }

        }
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
    // InternalXtext.g:6916:1: rule__TerminalRule__Group__3 : rule__TerminalRule__Group__3__Impl rule__TerminalRule__Group__4 ;
    public final void rule__TerminalRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6920:1: ( rule__TerminalRule__Group__3__Impl rule__TerminalRule__Group__4 )
            // InternalXtext.g:6921:2: rule__TerminalRule__Group__3__Impl rule__TerminalRule__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_51);
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
    // InternalXtext.g:6928:1: rule__TerminalRule__Group__3__Impl : ( ':' ) ;
    public final void rule__TerminalRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6932:1: ( ( ':' ) )
            // InternalXtext.g:6933:1: ( ':' )
            {
            // InternalXtext.g:6933:1: ( ':' )
            // InternalXtext.g:6934:2: ':'
            {
             before(grammarAccess.getTerminalRuleAccess().getColonKeyword_3()); 
            match(input,29,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:6943:1: rule__TerminalRule__Group__4 : rule__TerminalRule__Group__4__Impl rule__TerminalRule__Group__5 ;
    public final void rule__TerminalRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6947:1: ( rule__TerminalRule__Group__4__Impl rule__TerminalRule__Group__5 )
            // InternalXtext.g:6948:2: rule__TerminalRule__Group__4__Impl rule__TerminalRule__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_20);
            rule__TerminalRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:6955:1: rule__TerminalRule__Group__4__Impl : ( ( rule__TerminalRule__AlternativesAssignment_4 ) ) ;
    public final void rule__TerminalRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6959:1: ( ( ( rule__TerminalRule__AlternativesAssignment_4 ) ) )
            // InternalXtext.g:6960:1: ( ( rule__TerminalRule__AlternativesAssignment_4 ) )
            {
            // InternalXtext.g:6960:1: ( ( rule__TerminalRule__AlternativesAssignment_4 ) )
            // InternalXtext.g:6961:2: ( rule__TerminalRule__AlternativesAssignment_4 )
            {
             before(grammarAccess.getTerminalRuleAccess().getAlternativesAssignment_4()); 
            // InternalXtext.g:6962:2: ( rule__TerminalRule__AlternativesAssignment_4 )
            // InternalXtext.g:6962:3: rule__TerminalRule__AlternativesAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:6970:1: rule__TerminalRule__Group__5 : rule__TerminalRule__Group__5__Impl ;
    public final void rule__TerminalRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6974:1: ( rule__TerminalRule__Group__5__Impl )
            // InternalXtext.g:6975:2: rule__TerminalRule__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalXtext.g:6981:1: rule__TerminalRule__Group__5__Impl : ( ';' ) ;
    public final void rule__TerminalRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6985:1: ( ( ';' ) )
            // InternalXtext.g:6986:1: ( ';' )
            {
            // InternalXtext.g:6986:1: ( ';' )
            // InternalXtext.g:6987:2: ';'
            {
             before(grammarAccess.getTerminalRuleAccess().getSemicolonKeyword_5()); 
            match(input,30,FollowSets000.FOLLOW_2); 
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


    // $ANTLR start "rule__TerminalRule__Group_2_0__0"
    // InternalXtext.g:6997:1: rule__TerminalRule__Group_2_0__0 : rule__TerminalRule__Group_2_0__0__Impl rule__TerminalRule__Group_2_0__1 ;
    public final void rule__TerminalRule__Group_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7001:1: ( rule__TerminalRule__Group_2_0__0__Impl rule__TerminalRule__Group_2_0__1 )
            // InternalXtext.g:7002:2: rule__TerminalRule__Group_2_0__0__Impl rule__TerminalRule__Group_2_0__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__TerminalRule__Group_2_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__Group_2_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_2_0__0"


    // $ANTLR start "rule__TerminalRule__Group_2_0__0__Impl"
    // InternalXtext.g:7009:1: rule__TerminalRule__Group_2_0__0__Impl : ( ( rule__TerminalRule__FragmentAssignment_2_0_0 ) ) ;
    public final void rule__TerminalRule__Group_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7013:1: ( ( ( rule__TerminalRule__FragmentAssignment_2_0_0 ) ) )
            // InternalXtext.g:7014:1: ( ( rule__TerminalRule__FragmentAssignment_2_0_0 ) )
            {
            // InternalXtext.g:7014:1: ( ( rule__TerminalRule__FragmentAssignment_2_0_0 ) )
            // InternalXtext.g:7015:2: ( rule__TerminalRule__FragmentAssignment_2_0_0 )
            {
             before(grammarAccess.getTerminalRuleAccess().getFragmentAssignment_2_0_0()); 
            // InternalXtext.g:7016:2: ( rule__TerminalRule__FragmentAssignment_2_0_0 )
            // InternalXtext.g:7016:3: rule__TerminalRule__FragmentAssignment_2_0_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__FragmentAssignment_2_0_0();

            state._fsp--;


            }

             after(grammarAccess.getTerminalRuleAccess().getFragmentAssignment_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_2_0__0__Impl"


    // $ANTLR start "rule__TerminalRule__Group_2_0__1"
    // InternalXtext.g:7024:1: rule__TerminalRule__Group_2_0__1 : rule__TerminalRule__Group_2_0__1__Impl ;
    public final void rule__TerminalRule__Group_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7028:1: ( rule__TerminalRule__Group_2_0__1__Impl )
            // InternalXtext.g:7029:2: rule__TerminalRule__Group_2_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__Group_2_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_2_0__1"


    // $ANTLR start "rule__TerminalRule__Group_2_0__1__Impl"
    // InternalXtext.g:7035:1: rule__TerminalRule__Group_2_0__1__Impl : ( ( rule__TerminalRule__NameAssignment_2_0_1 ) ) ;
    public final void rule__TerminalRule__Group_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7039:1: ( ( ( rule__TerminalRule__NameAssignment_2_0_1 ) ) )
            // InternalXtext.g:7040:1: ( ( rule__TerminalRule__NameAssignment_2_0_1 ) )
            {
            // InternalXtext.g:7040:1: ( ( rule__TerminalRule__NameAssignment_2_0_1 ) )
            // InternalXtext.g:7041:2: ( rule__TerminalRule__NameAssignment_2_0_1 )
            {
             before(grammarAccess.getTerminalRuleAccess().getNameAssignment_2_0_1()); 
            // InternalXtext.g:7042:2: ( rule__TerminalRule__NameAssignment_2_0_1 )
            // InternalXtext.g:7042:3: rule__TerminalRule__NameAssignment_2_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__NameAssignment_2_0_1();

            state._fsp--;


            }

             after(grammarAccess.getTerminalRuleAccess().getNameAssignment_2_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_2_0__1__Impl"


    // $ANTLR start "rule__TerminalRule__Group_2_1__0"
    // InternalXtext.g:7051:1: rule__TerminalRule__Group_2_1__0 : rule__TerminalRule__Group_2_1__0__Impl rule__TerminalRule__Group_2_1__1 ;
    public final void rule__TerminalRule__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7055:1: ( rule__TerminalRule__Group_2_1__0__Impl rule__TerminalRule__Group_2_1__1 )
            // InternalXtext.g:7056:2: rule__TerminalRule__Group_2_1__0__Impl rule__TerminalRule__Group_2_1__1
            {
            pushFollow(FollowSets000.FOLLOW_22);
            rule__TerminalRule__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__Group_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_2_1__0"


    // $ANTLR start "rule__TerminalRule__Group_2_1__0__Impl"
    // InternalXtext.g:7063:1: rule__TerminalRule__Group_2_1__0__Impl : ( ( rule__TerminalRule__NameAssignment_2_1_0 ) ) ;
    public final void rule__TerminalRule__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7067:1: ( ( ( rule__TerminalRule__NameAssignment_2_1_0 ) ) )
            // InternalXtext.g:7068:1: ( ( rule__TerminalRule__NameAssignment_2_1_0 ) )
            {
            // InternalXtext.g:7068:1: ( ( rule__TerminalRule__NameAssignment_2_1_0 ) )
            // InternalXtext.g:7069:2: ( rule__TerminalRule__NameAssignment_2_1_0 )
            {
             before(grammarAccess.getTerminalRuleAccess().getNameAssignment_2_1_0()); 
            // InternalXtext.g:7070:2: ( rule__TerminalRule__NameAssignment_2_1_0 )
            // InternalXtext.g:7070:3: rule__TerminalRule__NameAssignment_2_1_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__NameAssignment_2_1_0();

            state._fsp--;


            }

             after(grammarAccess.getTerminalRuleAccess().getNameAssignment_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_2_1__0__Impl"


    // $ANTLR start "rule__TerminalRule__Group_2_1__1"
    // InternalXtext.g:7078:1: rule__TerminalRule__Group_2_1__1 : rule__TerminalRule__Group_2_1__1__Impl ;
    public final void rule__TerminalRule__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7082:1: ( rule__TerminalRule__Group_2_1__1__Impl )
            // InternalXtext.g:7083:2: rule__TerminalRule__Group_2_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__Group_2_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_2_1__1"


    // $ANTLR start "rule__TerminalRule__Group_2_1__1__Impl"
    // InternalXtext.g:7089:1: rule__TerminalRule__Group_2_1__1__Impl : ( ( rule__TerminalRule__Group_2_1_1__0 )? ) ;
    public final void rule__TerminalRule__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7093:1: ( ( ( rule__TerminalRule__Group_2_1_1__0 )? ) )
            // InternalXtext.g:7094:1: ( ( rule__TerminalRule__Group_2_1_1__0 )? )
            {
            // InternalXtext.g:7094:1: ( ( rule__TerminalRule__Group_2_1_1__0 )? )
            // InternalXtext.g:7095:2: ( rule__TerminalRule__Group_2_1_1__0 )?
            {
             before(grammarAccess.getTerminalRuleAccess().getGroup_2_1_1()); 
            // InternalXtext.g:7096:2: ( rule__TerminalRule__Group_2_1_1__0 )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==31) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalXtext.g:7096:3: rule__TerminalRule__Group_2_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__TerminalRule__Group_2_1_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTerminalRuleAccess().getGroup_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_2_1__1__Impl"


    // $ANTLR start "rule__TerminalRule__Group_2_1_1__0"
    // InternalXtext.g:7105:1: rule__TerminalRule__Group_2_1_1__0 : rule__TerminalRule__Group_2_1_1__0__Impl rule__TerminalRule__Group_2_1_1__1 ;
    public final void rule__TerminalRule__Group_2_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7109:1: ( rule__TerminalRule__Group_2_1_1__0__Impl rule__TerminalRule__Group_2_1_1__1 )
            // InternalXtext.g:7110:2: rule__TerminalRule__Group_2_1_1__0__Impl rule__TerminalRule__Group_2_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_15);
            rule__TerminalRule__Group_2_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__Group_2_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_2_1_1__0"


    // $ANTLR start "rule__TerminalRule__Group_2_1_1__0__Impl"
    // InternalXtext.g:7117:1: rule__TerminalRule__Group_2_1_1__0__Impl : ( 'returns' ) ;
    public final void rule__TerminalRule__Group_2_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7121:1: ( ( 'returns' ) )
            // InternalXtext.g:7122:1: ( 'returns' )
            {
            // InternalXtext.g:7122:1: ( 'returns' )
            // InternalXtext.g:7123:2: 'returns'
            {
             before(grammarAccess.getTerminalRuleAccess().getReturnsKeyword_2_1_1_0()); 
            match(input,31,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTerminalRuleAccess().getReturnsKeyword_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_2_1_1__0__Impl"


    // $ANTLR start "rule__TerminalRule__Group_2_1_1__1"
    // InternalXtext.g:7132:1: rule__TerminalRule__Group_2_1_1__1 : rule__TerminalRule__Group_2_1_1__1__Impl ;
    public final void rule__TerminalRule__Group_2_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7136:1: ( rule__TerminalRule__Group_2_1_1__1__Impl )
            // InternalXtext.g:7137:2: rule__TerminalRule__Group_2_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__Group_2_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_2_1_1__1"


    // $ANTLR start "rule__TerminalRule__Group_2_1_1__1__Impl"
    // InternalXtext.g:7143:1: rule__TerminalRule__Group_2_1_1__1__Impl : ( ( rule__TerminalRule__TypeAssignment_2_1_1_1 ) ) ;
    public final void rule__TerminalRule__Group_2_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7147:1: ( ( ( rule__TerminalRule__TypeAssignment_2_1_1_1 ) ) )
            // InternalXtext.g:7148:1: ( ( rule__TerminalRule__TypeAssignment_2_1_1_1 ) )
            {
            // InternalXtext.g:7148:1: ( ( rule__TerminalRule__TypeAssignment_2_1_1_1 ) )
            // InternalXtext.g:7149:2: ( rule__TerminalRule__TypeAssignment_2_1_1_1 )
            {
             before(grammarAccess.getTerminalRuleAccess().getTypeAssignment_2_1_1_1()); 
            // InternalXtext.g:7150:2: ( rule__TerminalRule__TypeAssignment_2_1_1_1 )
            // InternalXtext.g:7150:3: rule__TerminalRule__TypeAssignment_2_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__TypeAssignment_2_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getTerminalRuleAccess().getTypeAssignment_2_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_2_1_1__1__Impl"


    // $ANTLR start "rule__TerminalAlternatives__Group__0"
    // InternalXtext.g:7159:1: rule__TerminalAlternatives__Group__0 : rule__TerminalAlternatives__Group__0__Impl rule__TerminalAlternatives__Group__1 ;
    public final void rule__TerminalAlternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7163:1: ( rule__TerminalAlternatives__Group__0__Impl rule__TerminalAlternatives__Group__1 )
            // InternalXtext.g:7164:2: rule__TerminalAlternatives__Group__0__Impl rule__TerminalAlternatives__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_26);
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
    // InternalXtext.g:7171:1: rule__TerminalAlternatives__Group__0__Impl : ( ruleTerminalGroup ) ;
    public final void rule__TerminalAlternatives__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7175:1: ( ( ruleTerminalGroup ) )
            // InternalXtext.g:7176:1: ( ruleTerminalGroup )
            {
            // InternalXtext.g:7176:1: ( ruleTerminalGroup )
            // InternalXtext.g:7177:2: ruleTerminalGroup
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
    // InternalXtext.g:7186:1: rule__TerminalAlternatives__Group__1 : rule__TerminalAlternatives__Group__1__Impl ;
    public final void rule__TerminalAlternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7190:1: ( rule__TerminalAlternatives__Group__1__Impl )
            // InternalXtext.g:7191:2: rule__TerminalAlternatives__Group__1__Impl
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
    // InternalXtext.g:7197:1: rule__TerminalAlternatives__Group__1__Impl : ( ( rule__TerminalAlternatives__Group_1__0 )? ) ;
    public final void rule__TerminalAlternatives__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7201:1: ( ( ( rule__TerminalAlternatives__Group_1__0 )? ) )
            // InternalXtext.g:7202:1: ( ( rule__TerminalAlternatives__Group_1__0 )? )
            {
            // InternalXtext.g:7202:1: ( ( rule__TerminalAlternatives__Group_1__0 )? )
            // InternalXtext.g:7203:2: ( rule__TerminalAlternatives__Group_1__0 )?
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup_1()); 
            // InternalXtext.g:7204:2: ( rule__TerminalAlternatives__Group_1__0 )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==35) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalXtext.g:7204:3: rule__TerminalAlternatives__Group_1__0
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
    // InternalXtext.g:7213:1: rule__TerminalAlternatives__Group_1__0 : rule__TerminalAlternatives__Group_1__0__Impl rule__TerminalAlternatives__Group_1__1 ;
    public final void rule__TerminalAlternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7217:1: ( rule__TerminalAlternatives__Group_1__0__Impl rule__TerminalAlternatives__Group_1__1 )
            // InternalXtext.g:7218:2: rule__TerminalAlternatives__Group_1__0__Impl rule__TerminalAlternatives__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_26);
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
    // InternalXtext.g:7225:1: rule__TerminalAlternatives__Group_1__0__Impl : ( () ) ;
    public final void rule__TerminalAlternatives__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7229:1: ( ( () ) )
            // InternalXtext.g:7230:1: ( () )
            {
            // InternalXtext.g:7230:1: ( () )
            // InternalXtext.g:7231:2: ()
            {
             before(grammarAccess.getTerminalAlternativesAccess().getAlternativesElementsAction_1_0()); 
            // InternalXtext.g:7232:2: ()
            // InternalXtext.g:7232:3: 
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
    // InternalXtext.g:7240:1: rule__TerminalAlternatives__Group_1__1 : rule__TerminalAlternatives__Group_1__1__Impl ;
    public final void rule__TerminalAlternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7244:1: ( rule__TerminalAlternatives__Group_1__1__Impl )
            // InternalXtext.g:7245:2: rule__TerminalAlternatives__Group_1__1__Impl
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
    // InternalXtext.g:7251:1: rule__TerminalAlternatives__Group_1__1__Impl : ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) ) ;
    public final void rule__TerminalAlternatives__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7255:1: ( ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) ) )
            // InternalXtext.g:7256:1: ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) )
            {
            // InternalXtext.g:7256:1: ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) )
            // InternalXtext.g:7257:2: ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* )
            {
            // InternalXtext.g:7257:2: ( ( rule__TerminalAlternatives__Group_1_1__0 ) )
            // InternalXtext.g:7258:3: ( rule__TerminalAlternatives__Group_1_1__0 )
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 
            // InternalXtext.g:7259:3: ( rule__TerminalAlternatives__Group_1_1__0 )
            // InternalXtext.g:7259:4: rule__TerminalAlternatives__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_27);
            rule__TerminalAlternatives__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 

            }

            // InternalXtext.g:7262:2: ( ( rule__TerminalAlternatives__Group_1_1__0 )* )
            // InternalXtext.g:7263:3: ( rule__TerminalAlternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 
            // InternalXtext.g:7264:3: ( rule__TerminalAlternatives__Group_1_1__0 )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==35) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // InternalXtext.g:7264:4: rule__TerminalAlternatives__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_27);
            	    rule__TerminalAlternatives__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop70;
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
    // InternalXtext.g:7274:1: rule__TerminalAlternatives__Group_1_1__0 : rule__TerminalAlternatives__Group_1_1__0__Impl rule__TerminalAlternatives__Group_1_1__1 ;
    public final void rule__TerminalAlternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7278:1: ( rule__TerminalAlternatives__Group_1_1__0__Impl rule__TerminalAlternatives__Group_1_1__1 )
            // InternalXtext.g:7279:2: rule__TerminalAlternatives__Group_1_1__0__Impl rule__TerminalAlternatives__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_51);
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
    // InternalXtext.g:7286:1: rule__TerminalAlternatives__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__TerminalAlternatives__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7290:1: ( ( '|' ) )
            // InternalXtext.g:7291:1: ( '|' )
            {
            // InternalXtext.g:7291:1: ( '|' )
            // InternalXtext.g:7292:2: '|'
            {
             before(grammarAccess.getTerminalAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,35,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:7301:1: rule__TerminalAlternatives__Group_1_1__1 : rule__TerminalAlternatives__Group_1_1__1__Impl ;
    public final void rule__TerminalAlternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7305:1: ( rule__TerminalAlternatives__Group_1_1__1__Impl )
            // InternalXtext.g:7306:2: rule__TerminalAlternatives__Group_1_1__1__Impl
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
    // InternalXtext.g:7312:1: rule__TerminalAlternatives__Group_1_1__1__Impl : ( ( rule__TerminalAlternatives__ElementsAssignment_1_1_1 ) ) ;
    public final void rule__TerminalAlternatives__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7316:1: ( ( ( rule__TerminalAlternatives__ElementsAssignment_1_1_1 ) ) )
            // InternalXtext.g:7317:1: ( ( rule__TerminalAlternatives__ElementsAssignment_1_1_1 ) )
            {
            // InternalXtext.g:7317:1: ( ( rule__TerminalAlternatives__ElementsAssignment_1_1_1 ) )
            // InternalXtext.g:7318:2: ( rule__TerminalAlternatives__ElementsAssignment_1_1_1 )
            {
             before(grammarAccess.getTerminalAlternativesAccess().getElementsAssignment_1_1_1()); 
            // InternalXtext.g:7319:2: ( rule__TerminalAlternatives__ElementsAssignment_1_1_1 )
            // InternalXtext.g:7319:3: rule__TerminalAlternatives__ElementsAssignment_1_1_1
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
    // InternalXtext.g:7328:1: rule__TerminalGroup__Group__0 : rule__TerminalGroup__Group__0__Impl rule__TerminalGroup__Group__1 ;
    public final void rule__TerminalGroup__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7332:1: ( rule__TerminalGroup__Group__0__Impl rule__TerminalGroup__Group__1 )
            // InternalXtext.g:7333:2: rule__TerminalGroup__Group__0__Impl rule__TerminalGroup__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_51);
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
    // InternalXtext.g:7340:1: rule__TerminalGroup__Group__0__Impl : ( ruleTerminalToken ) ;
    public final void rule__TerminalGroup__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7344:1: ( ( ruleTerminalToken ) )
            // InternalXtext.g:7345:1: ( ruleTerminalToken )
            {
            // InternalXtext.g:7345:1: ( ruleTerminalToken )
            // InternalXtext.g:7346:2: ruleTerminalToken
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
    // InternalXtext.g:7355:1: rule__TerminalGroup__Group__1 : rule__TerminalGroup__Group__1__Impl ;
    public final void rule__TerminalGroup__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7359:1: ( rule__TerminalGroup__Group__1__Impl )
            // InternalXtext.g:7360:2: rule__TerminalGroup__Group__1__Impl
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
    // InternalXtext.g:7366:1: rule__TerminalGroup__Group__1__Impl : ( ( rule__TerminalGroup__Group_1__0 )? ) ;
    public final void rule__TerminalGroup__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7370:1: ( ( ( rule__TerminalGroup__Group_1__0 )? ) )
            // InternalXtext.g:7371:1: ( ( rule__TerminalGroup__Group_1__0 )? )
            {
            // InternalXtext.g:7371:1: ( ( rule__TerminalGroup__Group_1__0 )? )
            // InternalXtext.g:7372:2: ( rule__TerminalGroup__Group_1__0 )?
            {
             before(grammarAccess.getTerminalGroupAccess().getGroup_1()); 
            // InternalXtext.g:7373:2: ( rule__TerminalGroup__Group_1__0 )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( ((LA71_0>=RULE_ID && LA71_0<=RULE_STRING)||(LA71_0>=16 && LA71_0<=17)||LA71_0==22||LA71_0==24||LA71_0==40||(LA71_0>=44 && LA71_0<=45)) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalXtext.g:7373:3: rule__TerminalGroup__Group_1__0
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
    // InternalXtext.g:7382:1: rule__TerminalGroup__Group_1__0 : rule__TerminalGroup__Group_1__0__Impl rule__TerminalGroup__Group_1__1 ;
    public final void rule__TerminalGroup__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7386:1: ( rule__TerminalGroup__Group_1__0__Impl rule__TerminalGroup__Group_1__1 )
            // InternalXtext.g:7387:2: rule__TerminalGroup__Group_1__0__Impl rule__TerminalGroup__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_51);
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
    // InternalXtext.g:7394:1: rule__TerminalGroup__Group_1__0__Impl : ( () ) ;
    public final void rule__TerminalGroup__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7398:1: ( ( () ) )
            // InternalXtext.g:7399:1: ( () )
            {
            // InternalXtext.g:7399:1: ( () )
            // InternalXtext.g:7400:2: ()
            {
             before(grammarAccess.getTerminalGroupAccess().getGroupElementsAction_1_0()); 
            // InternalXtext.g:7401:2: ()
            // InternalXtext.g:7401:3: 
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
    // InternalXtext.g:7409:1: rule__TerminalGroup__Group_1__1 : rule__TerminalGroup__Group_1__1__Impl ;
    public final void rule__TerminalGroup__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7413:1: ( rule__TerminalGroup__Group_1__1__Impl )
            // InternalXtext.g:7414:2: rule__TerminalGroup__Group_1__1__Impl
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
    // InternalXtext.g:7420:1: rule__TerminalGroup__Group_1__1__Impl : ( ( ( rule__TerminalGroup__ElementsAssignment_1_1 ) ) ( ( rule__TerminalGroup__ElementsAssignment_1_1 )* ) ) ;
    public final void rule__TerminalGroup__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7424:1: ( ( ( ( rule__TerminalGroup__ElementsAssignment_1_1 ) ) ( ( rule__TerminalGroup__ElementsAssignment_1_1 )* ) ) )
            // InternalXtext.g:7425:1: ( ( ( rule__TerminalGroup__ElementsAssignment_1_1 ) ) ( ( rule__TerminalGroup__ElementsAssignment_1_1 )* ) )
            {
            // InternalXtext.g:7425:1: ( ( ( rule__TerminalGroup__ElementsAssignment_1_1 ) ) ( ( rule__TerminalGroup__ElementsAssignment_1_1 )* ) )
            // InternalXtext.g:7426:2: ( ( rule__TerminalGroup__ElementsAssignment_1_1 ) ) ( ( rule__TerminalGroup__ElementsAssignment_1_1 )* )
            {
            // InternalXtext.g:7426:2: ( ( rule__TerminalGroup__ElementsAssignment_1_1 ) )
            // InternalXtext.g:7427:3: ( rule__TerminalGroup__ElementsAssignment_1_1 )
            {
             before(grammarAccess.getTerminalGroupAccess().getElementsAssignment_1_1()); 
            // InternalXtext.g:7428:3: ( rule__TerminalGroup__ElementsAssignment_1_1 )
            // InternalXtext.g:7428:4: rule__TerminalGroup__ElementsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_52);
            rule__TerminalGroup__ElementsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getTerminalGroupAccess().getElementsAssignment_1_1()); 

            }

            // InternalXtext.g:7431:2: ( ( rule__TerminalGroup__ElementsAssignment_1_1 )* )
            // InternalXtext.g:7432:3: ( rule__TerminalGroup__ElementsAssignment_1_1 )*
            {
             before(grammarAccess.getTerminalGroupAccess().getElementsAssignment_1_1()); 
            // InternalXtext.g:7433:3: ( rule__TerminalGroup__ElementsAssignment_1_1 )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( ((LA72_0>=RULE_ID && LA72_0<=RULE_STRING)||(LA72_0>=16 && LA72_0<=17)||LA72_0==22||LA72_0==24||LA72_0==40||(LA72_0>=44 && LA72_0<=45)) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // InternalXtext.g:7433:4: rule__TerminalGroup__ElementsAssignment_1_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_52);
            	    rule__TerminalGroup__ElementsAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop72;
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
    // InternalXtext.g:7443:1: rule__TerminalToken__Group__0 : rule__TerminalToken__Group__0__Impl rule__TerminalToken__Group__1 ;
    public final void rule__TerminalToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7447:1: ( rule__TerminalToken__Group__0__Impl rule__TerminalToken__Group__1 )
            // InternalXtext.g:7448:2: rule__TerminalToken__Group__0__Impl rule__TerminalToken__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_34);
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
    // InternalXtext.g:7455:1: rule__TerminalToken__Group__0__Impl : ( ruleTerminalTokenElement ) ;
    public final void rule__TerminalToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7459:1: ( ( ruleTerminalTokenElement ) )
            // InternalXtext.g:7460:1: ( ruleTerminalTokenElement )
            {
            // InternalXtext.g:7460:1: ( ruleTerminalTokenElement )
            // InternalXtext.g:7461:2: ruleTerminalTokenElement
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
    // InternalXtext.g:7470:1: rule__TerminalToken__Group__1 : rule__TerminalToken__Group__1__Impl ;
    public final void rule__TerminalToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7474:1: ( rule__TerminalToken__Group__1__Impl )
            // InternalXtext.g:7475:2: rule__TerminalToken__Group__1__Impl
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
    // InternalXtext.g:7481:1: rule__TerminalToken__Group__1__Impl : ( ( rule__TerminalToken__CardinalityAssignment_1 )? ) ;
    public final void rule__TerminalToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7485:1: ( ( ( rule__TerminalToken__CardinalityAssignment_1 )? ) )
            // InternalXtext.g:7486:1: ( ( rule__TerminalToken__CardinalityAssignment_1 )? )
            {
            // InternalXtext.g:7486:1: ( ( rule__TerminalToken__CardinalityAssignment_1 )? )
            // InternalXtext.g:7487:2: ( rule__TerminalToken__CardinalityAssignment_1 )?
            {
             before(grammarAccess.getTerminalTokenAccess().getCardinalityAssignment_1()); 
            // InternalXtext.g:7488:2: ( rule__TerminalToken__CardinalityAssignment_1 )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( ((LA73_0>=11 && LA73_0<=13)) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalXtext.g:7488:3: rule__TerminalToken__CardinalityAssignment_1
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
    // InternalXtext.g:7497:1: rule__ParenthesizedTerminalElement__Group__0 : rule__ParenthesizedTerminalElement__Group__0__Impl rule__ParenthesizedTerminalElement__Group__1 ;
    public final void rule__ParenthesizedTerminalElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7501:1: ( rule__ParenthesizedTerminalElement__Group__0__Impl rule__ParenthesizedTerminalElement__Group__1 )
            // InternalXtext.g:7502:2: rule__ParenthesizedTerminalElement__Group__0__Impl rule__ParenthesizedTerminalElement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_51);
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
    // InternalXtext.g:7509:1: rule__ParenthesizedTerminalElement__Group__0__Impl : ( '(' ) ;
    public final void rule__ParenthesizedTerminalElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7513:1: ( ( '(' ) )
            // InternalXtext.g:7514:1: ( '(' )
            {
            // InternalXtext.g:7514:1: ( '(' )
            // InternalXtext.g:7515:2: '('
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
    // InternalXtext.g:7524:1: rule__ParenthesizedTerminalElement__Group__1 : rule__ParenthesizedTerminalElement__Group__1__Impl rule__ParenthesizedTerminalElement__Group__2 ;
    public final void rule__ParenthesizedTerminalElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7528:1: ( rule__ParenthesizedTerminalElement__Group__1__Impl rule__ParenthesizedTerminalElement__Group__2 )
            // InternalXtext.g:7529:2: rule__ParenthesizedTerminalElement__Group__1__Impl rule__ParenthesizedTerminalElement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_41);
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
    // InternalXtext.g:7536:1: rule__ParenthesizedTerminalElement__Group__1__Impl : ( ruleTerminalAlternatives ) ;
    public final void rule__ParenthesizedTerminalElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7540:1: ( ( ruleTerminalAlternatives ) )
            // InternalXtext.g:7541:1: ( ruleTerminalAlternatives )
            {
            // InternalXtext.g:7541:1: ( ruleTerminalAlternatives )
            // InternalXtext.g:7542:2: ruleTerminalAlternatives
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
    // InternalXtext.g:7551:1: rule__ParenthesizedTerminalElement__Group__2 : rule__ParenthesizedTerminalElement__Group__2__Impl ;
    public final void rule__ParenthesizedTerminalElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7555:1: ( rule__ParenthesizedTerminalElement__Group__2__Impl )
            // InternalXtext.g:7556:2: rule__ParenthesizedTerminalElement__Group__2__Impl
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
    // InternalXtext.g:7562:1: rule__ParenthesizedTerminalElement__Group__2__Impl : ( ')' ) ;
    public final void rule__ParenthesizedTerminalElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7566:1: ( ( ')' ) )
            // InternalXtext.g:7567:1: ( ')' )
            {
            // InternalXtext.g:7567:1: ( ')' )
            // InternalXtext.g:7568:2: ')'
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
    // InternalXtext.g:7578:1: rule__NegatedToken__Group__0 : rule__NegatedToken__Group__0__Impl rule__NegatedToken__Group__1 ;
    public final void rule__NegatedToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7582:1: ( rule__NegatedToken__Group__0__Impl rule__NegatedToken__Group__1 )
            // InternalXtext.g:7583:2: rule__NegatedToken__Group__0__Impl rule__NegatedToken__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_51);
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
    // InternalXtext.g:7590:1: rule__NegatedToken__Group__0__Impl : ( '!' ) ;
    public final void rule__NegatedToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7594:1: ( ( '!' ) )
            // InternalXtext.g:7595:1: ( '!' )
            {
            // InternalXtext.g:7595:1: ( '!' )
            // InternalXtext.g:7596:2: '!'
            {
             before(grammarAccess.getNegatedTokenAccess().getExclamationMarkKeyword_0()); 
            match(input,40,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:7605:1: rule__NegatedToken__Group__1 : rule__NegatedToken__Group__1__Impl ;
    public final void rule__NegatedToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7609:1: ( rule__NegatedToken__Group__1__Impl )
            // InternalXtext.g:7610:2: rule__NegatedToken__Group__1__Impl
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
    // InternalXtext.g:7616:1: rule__NegatedToken__Group__1__Impl : ( ( rule__NegatedToken__TerminalAssignment_1 ) ) ;
    public final void rule__NegatedToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7620:1: ( ( ( rule__NegatedToken__TerminalAssignment_1 ) ) )
            // InternalXtext.g:7621:1: ( ( rule__NegatedToken__TerminalAssignment_1 ) )
            {
            // InternalXtext.g:7621:1: ( ( rule__NegatedToken__TerminalAssignment_1 ) )
            // InternalXtext.g:7622:2: ( rule__NegatedToken__TerminalAssignment_1 )
            {
             before(grammarAccess.getNegatedTokenAccess().getTerminalAssignment_1()); 
            // InternalXtext.g:7623:2: ( rule__NegatedToken__TerminalAssignment_1 )
            // InternalXtext.g:7623:3: rule__NegatedToken__TerminalAssignment_1
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
    // InternalXtext.g:7632:1: rule__UntilToken__Group__0 : rule__UntilToken__Group__0__Impl rule__UntilToken__Group__1 ;
    public final void rule__UntilToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7636:1: ( rule__UntilToken__Group__0__Impl rule__UntilToken__Group__1 )
            // InternalXtext.g:7637:2: rule__UntilToken__Group__0__Impl rule__UntilToken__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_51);
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
    // InternalXtext.g:7644:1: rule__UntilToken__Group__0__Impl : ( '->' ) ;
    public final void rule__UntilToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7648:1: ( ( '->' ) )
            // InternalXtext.g:7649:1: ( '->' )
            {
            // InternalXtext.g:7649:1: ( '->' )
            // InternalXtext.g:7650:2: '->'
            {
             before(grammarAccess.getUntilTokenAccess().getHyphenMinusGreaterThanSignKeyword_0()); 
            match(input,44,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:7659:1: rule__UntilToken__Group__1 : rule__UntilToken__Group__1__Impl ;
    public final void rule__UntilToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7663:1: ( rule__UntilToken__Group__1__Impl )
            // InternalXtext.g:7664:2: rule__UntilToken__Group__1__Impl
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
    // InternalXtext.g:7670:1: rule__UntilToken__Group__1__Impl : ( ( rule__UntilToken__TerminalAssignment_1 ) ) ;
    public final void rule__UntilToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7674:1: ( ( ( rule__UntilToken__TerminalAssignment_1 ) ) )
            // InternalXtext.g:7675:1: ( ( rule__UntilToken__TerminalAssignment_1 ) )
            {
            // InternalXtext.g:7675:1: ( ( rule__UntilToken__TerminalAssignment_1 ) )
            // InternalXtext.g:7676:2: ( rule__UntilToken__TerminalAssignment_1 )
            {
             before(grammarAccess.getUntilTokenAccess().getTerminalAssignment_1()); 
            // InternalXtext.g:7677:2: ( rule__UntilToken__TerminalAssignment_1 )
            // InternalXtext.g:7677:3: rule__UntilToken__TerminalAssignment_1
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
    // InternalXtext.g:7686:1: rule__Wildcard__Group__0 : rule__Wildcard__Group__0__Impl rule__Wildcard__Group__1 ;
    public final void rule__Wildcard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7690:1: ( rule__Wildcard__Group__0__Impl rule__Wildcard__Group__1 )
            // InternalXtext.g:7691:2: rule__Wildcard__Group__0__Impl rule__Wildcard__Group__1
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
    // InternalXtext.g:7698:1: rule__Wildcard__Group__0__Impl : ( () ) ;
    public final void rule__Wildcard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7702:1: ( ( () ) )
            // InternalXtext.g:7703:1: ( () )
            {
            // InternalXtext.g:7703:1: ( () )
            // InternalXtext.g:7704:2: ()
            {
             before(grammarAccess.getWildcardAccess().getWildcardAction_0()); 
            // InternalXtext.g:7705:2: ()
            // InternalXtext.g:7705:3: 
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
    // InternalXtext.g:7713:1: rule__Wildcard__Group__1 : rule__Wildcard__Group__1__Impl ;
    public final void rule__Wildcard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7717:1: ( rule__Wildcard__Group__1__Impl )
            // InternalXtext.g:7718:2: rule__Wildcard__Group__1__Impl
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
    // InternalXtext.g:7724:1: rule__Wildcard__Group__1__Impl : ( '.' ) ;
    public final void rule__Wildcard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7728:1: ( ( '.' ) )
            // InternalXtext.g:7729:1: ( '.' )
            {
            // InternalXtext.g:7729:1: ( '.' )
            // InternalXtext.g:7730:2: '.'
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
    // InternalXtext.g:7740:1: rule__EOF__Group__0 : rule__EOF__Group__0__Impl rule__EOF__Group__1 ;
    public final void rule__EOF__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7744:1: ( rule__EOF__Group__0__Impl rule__EOF__Group__1 )
            // InternalXtext.g:7745:2: rule__EOF__Group__0__Impl rule__EOF__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_51);
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
    // InternalXtext.g:7752:1: rule__EOF__Group__0__Impl : ( () ) ;
    public final void rule__EOF__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7756:1: ( ( () ) )
            // InternalXtext.g:7757:1: ( () )
            {
            // InternalXtext.g:7757:1: ( () )
            // InternalXtext.g:7758:2: ()
            {
             before(grammarAccess.getEOFAccess().getEOFAction_0()); 
            // InternalXtext.g:7759:2: ()
            // InternalXtext.g:7759:3: 
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
    // InternalXtext.g:7767:1: rule__EOF__Group__1 : rule__EOF__Group__1__Impl ;
    public final void rule__EOF__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7771:1: ( rule__EOF__Group__1__Impl )
            // InternalXtext.g:7772:2: rule__EOF__Group__1__Impl
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
    // InternalXtext.g:7778:1: rule__EOF__Group__1__Impl : ( 'EOF' ) ;
    public final void rule__EOF__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7782:1: ( ( 'EOF' ) )
            // InternalXtext.g:7783:1: ( 'EOF' )
            {
            // InternalXtext.g:7783:1: ( 'EOF' )
            // InternalXtext.g:7784:2: 'EOF'
            {
             before(grammarAccess.getEOFAccess().getEOFKeyword_1()); 
            match(input,45,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:7794:1: rule__CharacterRange__Group__0 : rule__CharacterRange__Group__0__Impl rule__CharacterRange__Group__1 ;
    public final void rule__CharacterRange__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7798:1: ( rule__CharacterRange__Group__0__Impl rule__CharacterRange__Group__1 )
            // InternalXtext.g:7799:2: rule__CharacterRange__Group__0__Impl rule__CharacterRange__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_53);
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
    // InternalXtext.g:7806:1: rule__CharacterRange__Group__0__Impl : ( ruleKeyword ) ;
    public final void rule__CharacterRange__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7810:1: ( ( ruleKeyword ) )
            // InternalXtext.g:7811:1: ( ruleKeyword )
            {
            // InternalXtext.g:7811:1: ( ruleKeyword )
            // InternalXtext.g:7812:2: ruleKeyword
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
    // InternalXtext.g:7821:1: rule__CharacterRange__Group__1 : rule__CharacterRange__Group__1__Impl ;
    public final void rule__CharacterRange__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7825:1: ( rule__CharacterRange__Group__1__Impl )
            // InternalXtext.g:7826:2: rule__CharacterRange__Group__1__Impl
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
    // InternalXtext.g:7832:1: rule__CharacterRange__Group__1__Impl : ( ( rule__CharacterRange__Group_1__0 )? ) ;
    public final void rule__CharacterRange__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7836:1: ( ( ( rule__CharacterRange__Group_1__0 )? ) )
            // InternalXtext.g:7837:1: ( ( rule__CharacterRange__Group_1__0 )? )
            {
            // InternalXtext.g:7837:1: ( ( rule__CharacterRange__Group_1__0 )? )
            // InternalXtext.g:7838:2: ( rule__CharacterRange__Group_1__0 )?
            {
             before(grammarAccess.getCharacterRangeAccess().getGroup_1()); 
            // InternalXtext.g:7839:2: ( rule__CharacterRange__Group_1__0 )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==46) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalXtext.g:7839:3: rule__CharacterRange__Group_1__0
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
    // InternalXtext.g:7848:1: rule__CharacterRange__Group_1__0 : rule__CharacterRange__Group_1__0__Impl rule__CharacterRange__Group_1__1 ;
    public final void rule__CharacterRange__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7852:1: ( rule__CharacterRange__Group_1__0__Impl rule__CharacterRange__Group_1__1 )
            // InternalXtext.g:7853:2: rule__CharacterRange__Group_1__0__Impl rule__CharacterRange__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_53);
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
    // InternalXtext.g:7860:1: rule__CharacterRange__Group_1__0__Impl : ( () ) ;
    public final void rule__CharacterRange__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7864:1: ( ( () ) )
            // InternalXtext.g:7865:1: ( () )
            {
            // InternalXtext.g:7865:1: ( () )
            // InternalXtext.g:7866:2: ()
            {
             before(grammarAccess.getCharacterRangeAccess().getCharacterRangeLeftAction_1_0()); 
            // InternalXtext.g:7867:2: ()
            // InternalXtext.g:7867:3: 
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
    // InternalXtext.g:7875:1: rule__CharacterRange__Group_1__1 : rule__CharacterRange__Group_1__1__Impl rule__CharacterRange__Group_1__2 ;
    public final void rule__CharacterRange__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7879:1: ( rule__CharacterRange__Group_1__1__Impl rule__CharacterRange__Group_1__2 )
            // InternalXtext.g:7880:2: rule__CharacterRange__Group_1__1__Impl rule__CharacterRange__Group_1__2
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
    // InternalXtext.g:7887:1: rule__CharacterRange__Group_1__1__Impl : ( '..' ) ;
    public final void rule__CharacterRange__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7891:1: ( ( '..' ) )
            // InternalXtext.g:7892:1: ( '..' )
            {
            // InternalXtext.g:7892:1: ( '..' )
            // InternalXtext.g:7893:2: '..'
            {
             before(grammarAccess.getCharacterRangeAccess().getFullStopFullStopKeyword_1_1()); 
            match(input,46,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:7902:1: rule__CharacterRange__Group_1__2 : rule__CharacterRange__Group_1__2__Impl ;
    public final void rule__CharacterRange__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7906:1: ( rule__CharacterRange__Group_1__2__Impl )
            // InternalXtext.g:7907:2: rule__CharacterRange__Group_1__2__Impl
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
    // InternalXtext.g:7913:1: rule__CharacterRange__Group_1__2__Impl : ( ( rule__CharacterRange__RightAssignment_1_2 ) ) ;
    public final void rule__CharacterRange__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7917:1: ( ( ( rule__CharacterRange__RightAssignment_1_2 ) ) )
            // InternalXtext.g:7918:1: ( ( rule__CharacterRange__RightAssignment_1_2 ) )
            {
            // InternalXtext.g:7918:1: ( ( rule__CharacterRange__RightAssignment_1_2 ) )
            // InternalXtext.g:7919:2: ( rule__CharacterRange__RightAssignment_1_2 )
            {
             before(grammarAccess.getCharacterRangeAccess().getRightAssignment_1_2()); 
            // InternalXtext.g:7920:2: ( rule__CharacterRange__RightAssignment_1_2 )
            // InternalXtext.g:7920:3: rule__CharacterRange__RightAssignment_1_2
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
    // InternalXtext.g:7929:1: rule__EnumRule__Group__0 : rule__EnumRule__Group__0__Impl rule__EnumRule__Group__1 ;
    public final void rule__EnumRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7933:1: ( rule__EnumRule__Group__0__Impl rule__EnumRule__Group__1 )
            // InternalXtext.g:7934:2: rule__EnumRule__Group__0__Impl rule__EnumRule__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
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
    // InternalXtext.g:7941:1: rule__EnumRule__Group__0__Impl : ( ( rule__EnumRule__AnnotationsAssignment_0 )* ) ;
    public final void rule__EnumRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7945:1: ( ( ( rule__EnumRule__AnnotationsAssignment_0 )* ) )
            // InternalXtext.g:7946:1: ( ( rule__EnumRule__AnnotationsAssignment_0 )* )
            {
            // InternalXtext.g:7946:1: ( ( rule__EnumRule__AnnotationsAssignment_0 )* )
            // InternalXtext.g:7947:2: ( rule__EnumRule__AnnotationsAssignment_0 )*
            {
             before(grammarAccess.getEnumRuleAccess().getAnnotationsAssignment_0()); 
            // InternalXtext.g:7948:2: ( rule__EnumRule__AnnotationsAssignment_0 )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==28) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // InternalXtext.g:7948:3: rule__EnumRule__AnnotationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_17);
            	    rule__EnumRule__AnnotationsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop75;
                }
            } while (true);

             after(grammarAccess.getEnumRuleAccess().getAnnotationsAssignment_0()); 

            }


            }

        }
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
    // InternalXtext.g:7956:1: rule__EnumRule__Group__1 : rule__EnumRule__Group__1__Impl rule__EnumRule__Group__2 ;
    public final void rule__EnumRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7960:1: ( rule__EnumRule__Group__1__Impl rule__EnumRule__Group__2 )
            // InternalXtext.g:7961:2: rule__EnumRule__Group__1__Impl rule__EnumRule__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_3);
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
    // InternalXtext.g:7968:1: rule__EnumRule__Group__1__Impl : ( 'enum' ) ;
    public final void rule__EnumRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7972:1: ( ( 'enum' ) )
            // InternalXtext.g:7973:1: ( 'enum' )
            {
            // InternalXtext.g:7973:1: ( 'enum' )
            // InternalXtext.g:7974:2: 'enum'
            {
             before(grammarAccess.getEnumRuleAccess().getEnumKeyword_1()); 
            match(input,47,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getEnumRuleAccess().getEnumKeyword_1()); 

            }


            }

        }
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
    // InternalXtext.g:7983:1: rule__EnumRule__Group__2 : rule__EnumRule__Group__2__Impl rule__EnumRule__Group__3 ;
    public final void rule__EnumRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7987:1: ( rule__EnumRule__Group__2__Impl rule__EnumRule__Group__3 )
            // InternalXtext.g:7988:2: rule__EnumRule__Group__2__Impl rule__EnumRule__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_54);
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
    // InternalXtext.g:7995:1: rule__EnumRule__Group__2__Impl : ( ( rule__EnumRule__NameAssignment_2 ) ) ;
    public final void rule__EnumRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7999:1: ( ( ( rule__EnumRule__NameAssignment_2 ) ) )
            // InternalXtext.g:8000:1: ( ( rule__EnumRule__NameAssignment_2 ) )
            {
            // InternalXtext.g:8000:1: ( ( rule__EnumRule__NameAssignment_2 ) )
            // InternalXtext.g:8001:2: ( rule__EnumRule__NameAssignment_2 )
            {
             before(grammarAccess.getEnumRuleAccess().getNameAssignment_2()); 
            // InternalXtext.g:8002:2: ( rule__EnumRule__NameAssignment_2 )
            // InternalXtext.g:8002:3: rule__EnumRule__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumRule__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getEnumRuleAccess().getNameAssignment_2()); 

            }


            }

        }
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
    // InternalXtext.g:8010:1: rule__EnumRule__Group__3 : rule__EnumRule__Group__3__Impl rule__EnumRule__Group__4 ;
    public final void rule__EnumRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8014:1: ( rule__EnumRule__Group__3__Impl rule__EnumRule__Group__4 )
            // InternalXtext.g:8015:2: rule__EnumRule__Group__3__Impl rule__EnumRule__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_54);
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
    // InternalXtext.g:8022:1: rule__EnumRule__Group__3__Impl : ( ( rule__EnumRule__Group_3__0 )? ) ;
    public final void rule__EnumRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8026:1: ( ( ( rule__EnumRule__Group_3__0 )? ) )
            // InternalXtext.g:8027:1: ( ( rule__EnumRule__Group_3__0 )? )
            {
            // InternalXtext.g:8027:1: ( ( rule__EnumRule__Group_3__0 )? )
            // InternalXtext.g:8028:2: ( rule__EnumRule__Group_3__0 )?
            {
             before(grammarAccess.getEnumRuleAccess().getGroup_3()); 
            // InternalXtext.g:8029:2: ( rule__EnumRule__Group_3__0 )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==31) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalXtext.g:8029:3: rule__EnumRule__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__EnumRule__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEnumRuleAccess().getGroup_3()); 

            }


            }

        }
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
    // InternalXtext.g:8037:1: rule__EnumRule__Group__4 : rule__EnumRule__Group__4__Impl rule__EnumRule__Group__5 ;
    public final void rule__EnumRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8041:1: ( rule__EnumRule__Group__4__Impl rule__EnumRule__Group__5 )
            // InternalXtext.g:8042:2: rule__EnumRule__Group__4__Impl rule__EnumRule__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_3);
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
    // InternalXtext.g:8049:1: rule__EnumRule__Group__4__Impl : ( ':' ) ;
    public final void rule__EnumRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8053:1: ( ( ':' ) )
            // InternalXtext.g:8054:1: ( ':' )
            {
            // InternalXtext.g:8054:1: ( ':' )
            // InternalXtext.g:8055:2: ':'
            {
             before(grammarAccess.getEnumRuleAccess().getColonKeyword_4()); 
            match(input,29,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getEnumRuleAccess().getColonKeyword_4()); 

            }


            }

        }
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
    // InternalXtext.g:8064:1: rule__EnumRule__Group__5 : rule__EnumRule__Group__5__Impl rule__EnumRule__Group__6 ;
    public final void rule__EnumRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8068:1: ( rule__EnumRule__Group__5__Impl rule__EnumRule__Group__6 )
            // InternalXtext.g:8069:2: rule__EnumRule__Group__5__Impl rule__EnumRule__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_20);
            rule__EnumRule__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumRule__Group__6();

            state._fsp--;


            }

        }
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
    // InternalXtext.g:8076:1: rule__EnumRule__Group__5__Impl : ( ( rule__EnumRule__AlternativesAssignment_5 ) ) ;
    public final void rule__EnumRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8080:1: ( ( ( rule__EnumRule__AlternativesAssignment_5 ) ) )
            // InternalXtext.g:8081:1: ( ( rule__EnumRule__AlternativesAssignment_5 ) )
            {
            // InternalXtext.g:8081:1: ( ( rule__EnumRule__AlternativesAssignment_5 ) )
            // InternalXtext.g:8082:2: ( rule__EnumRule__AlternativesAssignment_5 )
            {
             before(grammarAccess.getEnumRuleAccess().getAlternativesAssignment_5()); 
            // InternalXtext.g:8083:2: ( rule__EnumRule__AlternativesAssignment_5 )
            // InternalXtext.g:8083:3: rule__EnumRule__AlternativesAssignment_5
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumRule__AlternativesAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getEnumRuleAccess().getAlternativesAssignment_5()); 

            }


            }

        }
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


    // $ANTLR start "rule__EnumRule__Group__6"
    // InternalXtext.g:8091:1: rule__EnumRule__Group__6 : rule__EnumRule__Group__6__Impl ;
    public final void rule__EnumRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8095:1: ( rule__EnumRule__Group__6__Impl )
            // InternalXtext.g:8096:2: rule__EnumRule__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumRule__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__Group__6"


    // $ANTLR start "rule__EnumRule__Group__6__Impl"
    // InternalXtext.g:8102:1: rule__EnumRule__Group__6__Impl : ( ';' ) ;
    public final void rule__EnumRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8106:1: ( ( ';' ) )
            // InternalXtext.g:8107:1: ( ';' )
            {
            // InternalXtext.g:8107:1: ( ';' )
            // InternalXtext.g:8108:2: ';'
            {
             before(grammarAccess.getEnumRuleAccess().getSemicolonKeyword_6()); 
            match(input,30,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getEnumRuleAccess().getSemicolonKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__Group__6__Impl"


    // $ANTLR start "rule__EnumRule__Group_3__0"
    // InternalXtext.g:8118:1: rule__EnumRule__Group_3__0 : rule__EnumRule__Group_3__0__Impl rule__EnumRule__Group_3__1 ;
    public final void rule__EnumRule__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8122:1: ( rule__EnumRule__Group_3__0__Impl rule__EnumRule__Group_3__1 )
            // InternalXtext.g:8123:2: rule__EnumRule__Group_3__0__Impl rule__EnumRule__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_15);
            rule__EnumRule__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumRule__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__Group_3__0"


    // $ANTLR start "rule__EnumRule__Group_3__0__Impl"
    // InternalXtext.g:8130:1: rule__EnumRule__Group_3__0__Impl : ( 'returns' ) ;
    public final void rule__EnumRule__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8134:1: ( ( 'returns' ) )
            // InternalXtext.g:8135:1: ( 'returns' )
            {
            // InternalXtext.g:8135:1: ( 'returns' )
            // InternalXtext.g:8136:2: 'returns'
            {
             before(grammarAccess.getEnumRuleAccess().getReturnsKeyword_3_0()); 
            match(input,31,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getEnumRuleAccess().getReturnsKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__Group_3__0__Impl"


    // $ANTLR start "rule__EnumRule__Group_3__1"
    // InternalXtext.g:8145:1: rule__EnumRule__Group_3__1 : rule__EnumRule__Group_3__1__Impl ;
    public final void rule__EnumRule__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8149:1: ( rule__EnumRule__Group_3__1__Impl )
            // InternalXtext.g:8150:2: rule__EnumRule__Group_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumRule__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__Group_3__1"


    // $ANTLR start "rule__EnumRule__Group_3__1__Impl"
    // InternalXtext.g:8156:1: rule__EnumRule__Group_3__1__Impl : ( ( rule__EnumRule__TypeAssignment_3_1 ) ) ;
    public final void rule__EnumRule__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8160:1: ( ( ( rule__EnumRule__TypeAssignment_3_1 ) ) )
            // InternalXtext.g:8161:1: ( ( rule__EnumRule__TypeAssignment_3_1 ) )
            {
            // InternalXtext.g:8161:1: ( ( rule__EnumRule__TypeAssignment_3_1 ) )
            // InternalXtext.g:8162:2: ( rule__EnumRule__TypeAssignment_3_1 )
            {
             before(grammarAccess.getEnumRuleAccess().getTypeAssignment_3_1()); 
            // InternalXtext.g:8163:2: ( rule__EnumRule__TypeAssignment_3_1 )
            // InternalXtext.g:8163:3: rule__EnumRule__TypeAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumRule__TypeAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getEnumRuleAccess().getTypeAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__Group_3__1__Impl"


    // $ANTLR start "rule__EnumLiterals__Group__0"
    // InternalXtext.g:8172:1: rule__EnumLiterals__Group__0 : rule__EnumLiterals__Group__0__Impl rule__EnumLiterals__Group__1 ;
    public final void rule__EnumLiterals__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8176:1: ( rule__EnumLiterals__Group__0__Impl rule__EnumLiterals__Group__1 )
            // InternalXtext.g:8177:2: rule__EnumLiterals__Group__0__Impl rule__EnumLiterals__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_26);
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
    // InternalXtext.g:8184:1: rule__EnumLiterals__Group__0__Impl : ( ruleEnumLiteralDeclaration ) ;
    public final void rule__EnumLiterals__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8188:1: ( ( ruleEnumLiteralDeclaration ) )
            // InternalXtext.g:8189:1: ( ruleEnumLiteralDeclaration )
            {
            // InternalXtext.g:8189:1: ( ruleEnumLiteralDeclaration )
            // InternalXtext.g:8190:2: ruleEnumLiteralDeclaration
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
    // InternalXtext.g:8199:1: rule__EnumLiterals__Group__1 : rule__EnumLiterals__Group__1__Impl ;
    public final void rule__EnumLiterals__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8203:1: ( rule__EnumLiterals__Group__1__Impl )
            // InternalXtext.g:8204:2: rule__EnumLiterals__Group__1__Impl
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
    // InternalXtext.g:8210:1: rule__EnumLiterals__Group__1__Impl : ( ( rule__EnumLiterals__Group_1__0 )? ) ;
    public final void rule__EnumLiterals__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8214:1: ( ( ( rule__EnumLiterals__Group_1__0 )? ) )
            // InternalXtext.g:8215:1: ( ( rule__EnumLiterals__Group_1__0 )? )
            {
            // InternalXtext.g:8215:1: ( ( rule__EnumLiterals__Group_1__0 )? )
            // InternalXtext.g:8216:2: ( rule__EnumLiterals__Group_1__0 )?
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup_1()); 
            // InternalXtext.g:8217:2: ( rule__EnumLiterals__Group_1__0 )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==35) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalXtext.g:8217:3: rule__EnumLiterals__Group_1__0
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
    // InternalXtext.g:8226:1: rule__EnumLiterals__Group_1__0 : rule__EnumLiterals__Group_1__0__Impl rule__EnumLiterals__Group_1__1 ;
    public final void rule__EnumLiterals__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8230:1: ( rule__EnumLiterals__Group_1__0__Impl rule__EnumLiterals__Group_1__1 )
            // InternalXtext.g:8231:2: rule__EnumLiterals__Group_1__0__Impl rule__EnumLiterals__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_26);
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
    // InternalXtext.g:8238:1: rule__EnumLiterals__Group_1__0__Impl : ( () ) ;
    public final void rule__EnumLiterals__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8242:1: ( ( () ) )
            // InternalXtext.g:8243:1: ( () )
            {
            // InternalXtext.g:8243:1: ( () )
            // InternalXtext.g:8244:2: ()
            {
             before(grammarAccess.getEnumLiteralsAccess().getAlternativesElementsAction_1_0()); 
            // InternalXtext.g:8245:2: ()
            // InternalXtext.g:8245:3: 
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
    // InternalXtext.g:8253:1: rule__EnumLiterals__Group_1__1 : rule__EnumLiterals__Group_1__1__Impl ;
    public final void rule__EnumLiterals__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8257:1: ( rule__EnumLiterals__Group_1__1__Impl )
            // InternalXtext.g:8258:2: rule__EnumLiterals__Group_1__1__Impl
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
    // InternalXtext.g:8264:1: rule__EnumLiterals__Group_1__1__Impl : ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) ) ;
    public final void rule__EnumLiterals__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8268:1: ( ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) ) )
            // InternalXtext.g:8269:1: ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) )
            {
            // InternalXtext.g:8269:1: ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) )
            // InternalXtext.g:8270:2: ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* )
            {
            // InternalXtext.g:8270:2: ( ( rule__EnumLiterals__Group_1_1__0 ) )
            // InternalXtext.g:8271:3: ( rule__EnumLiterals__Group_1_1__0 )
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 
            // InternalXtext.g:8272:3: ( rule__EnumLiterals__Group_1_1__0 )
            // InternalXtext.g:8272:4: rule__EnumLiterals__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_27);
            rule__EnumLiterals__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 

            }

            // InternalXtext.g:8275:2: ( ( rule__EnumLiterals__Group_1_1__0 )* )
            // InternalXtext.g:8276:3: ( rule__EnumLiterals__Group_1_1__0 )*
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 
            // InternalXtext.g:8277:3: ( rule__EnumLiterals__Group_1_1__0 )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==35) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // InternalXtext.g:8277:4: rule__EnumLiterals__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_27);
            	    rule__EnumLiterals__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop78;
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
    // InternalXtext.g:8287:1: rule__EnumLiterals__Group_1_1__0 : rule__EnumLiterals__Group_1_1__0__Impl rule__EnumLiterals__Group_1_1__1 ;
    public final void rule__EnumLiterals__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8291:1: ( rule__EnumLiterals__Group_1_1__0__Impl rule__EnumLiterals__Group_1_1__1 )
            // InternalXtext.g:8292:2: rule__EnumLiterals__Group_1_1__0__Impl rule__EnumLiterals__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
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
    // InternalXtext.g:8299:1: rule__EnumLiterals__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__EnumLiterals__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8303:1: ( ( '|' ) )
            // InternalXtext.g:8304:1: ( '|' )
            {
            // InternalXtext.g:8304:1: ( '|' )
            // InternalXtext.g:8305:2: '|'
            {
             before(grammarAccess.getEnumLiteralsAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,35,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:8314:1: rule__EnumLiterals__Group_1_1__1 : rule__EnumLiterals__Group_1_1__1__Impl ;
    public final void rule__EnumLiterals__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8318:1: ( rule__EnumLiterals__Group_1_1__1__Impl )
            // InternalXtext.g:8319:2: rule__EnumLiterals__Group_1_1__1__Impl
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
    // InternalXtext.g:8325:1: rule__EnumLiterals__Group_1_1__1__Impl : ( ( rule__EnumLiterals__ElementsAssignment_1_1_1 ) ) ;
    public final void rule__EnumLiterals__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8329:1: ( ( ( rule__EnumLiterals__ElementsAssignment_1_1_1 ) ) )
            // InternalXtext.g:8330:1: ( ( rule__EnumLiterals__ElementsAssignment_1_1_1 ) )
            {
            // InternalXtext.g:8330:1: ( ( rule__EnumLiterals__ElementsAssignment_1_1_1 ) )
            // InternalXtext.g:8331:2: ( rule__EnumLiterals__ElementsAssignment_1_1_1 )
            {
             before(grammarAccess.getEnumLiteralsAccess().getElementsAssignment_1_1_1()); 
            // InternalXtext.g:8332:2: ( rule__EnumLiterals__ElementsAssignment_1_1_1 )
            // InternalXtext.g:8332:3: rule__EnumLiterals__ElementsAssignment_1_1_1
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
    // InternalXtext.g:8341:1: rule__EnumLiteralDeclaration__Group__0 : rule__EnumLiteralDeclaration__Group__0__Impl rule__EnumLiteralDeclaration__Group__1 ;
    public final void rule__EnumLiteralDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8345:1: ( rule__EnumLiteralDeclaration__Group__0__Impl rule__EnumLiteralDeclaration__Group__1 )
            // InternalXtext.g:8346:2: rule__EnumLiteralDeclaration__Group__0__Impl rule__EnumLiteralDeclaration__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_39);
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
    // InternalXtext.g:8353:1: rule__EnumLiteralDeclaration__Group__0__Impl : ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) ) ;
    public final void rule__EnumLiteralDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8357:1: ( ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) ) )
            // InternalXtext.g:8358:1: ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) )
            {
            // InternalXtext.g:8358:1: ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) )
            // InternalXtext.g:8359:2: ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralAssignment_0()); 
            // InternalXtext.g:8360:2: ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 )
            // InternalXtext.g:8360:3: rule__EnumLiteralDeclaration__EnumLiteralAssignment_0
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
    // InternalXtext.g:8368:1: rule__EnumLiteralDeclaration__Group__1 : rule__EnumLiteralDeclaration__Group__1__Impl ;
    public final void rule__EnumLiteralDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8372:1: ( rule__EnumLiteralDeclaration__Group__1__Impl )
            // InternalXtext.g:8373:2: rule__EnumLiteralDeclaration__Group__1__Impl
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
    // InternalXtext.g:8379:1: rule__EnumLiteralDeclaration__Group__1__Impl : ( ( rule__EnumLiteralDeclaration__Group_1__0 )? ) ;
    public final void rule__EnumLiteralDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8383:1: ( ( ( rule__EnumLiteralDeclaration__Group_1__0 )? ) )
            // InternalXtext.g:8384:1: ( ( rule__EnumLiteralDeclaration__Group_1__0 )? )
            {
            // InternalXtext.g:8384:1: ( ( rule__EnumLiteralDeclaration__Group_1__0 )? )
            // InternalXtext.g:8385:2: ( rule__EnumLiteralDeclaration__Group_1__0 )?
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getGroup_1()); 
            // InternalXtext.g:8386:2: ( rule__EnumLiteralDeclaration__Group_1__0 )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==14) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalXtext.g:8386:3: rule__EnumLiteralDeclaration__Group_1__0
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
    // InternalXtext.g:8395:1: rule__EnumLiteralDeclaration__Group_1__0 : rule__EnumLiteralDeclaration__Group_1__0__Impl rule__EnumLiteralDeclaration__Group_1__1 ;
    public final void rule__EnumLiteralDeclaration__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8399:1: ( rule__EnumLiteralDeclaration__Group_1__0__Impl rule__EnumLiteralDeclaration__Group_1__1 )
            // InternalXtext.g:8400:2: rule__EnumLiteralDeclaration__Group_1__0__Impl rule__EnumLiteralDeclaration__Group_1__1
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
    // InternalXtext.g:8407:1: rule__EnumLiteralDeclaration__Group_1__0__Impl : ( '=' ) ;
    public final void rule__EnumLiteralDeclaration__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8411:1: ( ( '=' ) )
            // InternalXtext.g:8412:1: ( '=' )
            {
            // InternalXtext.g:8412:1: ( '=' )
            // InternalXtext.g:8413:2: '='
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
    // InternalXtext.g:8422:1: rule__EnumLiteralDeclaration__Group_1__1 : rule__EnumLiteralDeclaration__Group_1__1__Impl ;
    public final void rule__EnumLiteralDeclaration__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8426:1: ( rule__EnumLiteralDeclaration__Group_1__1__Impl )
            // InternalXtext.g:8427:2: rule__EnumLiteralDeclaration__Group_1__1__Impl
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
    // InternalXtext.g:8433:1: rule__EnumLiteralDeclaration__Group_1__1__Impl : ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) ) ;
    public final void rule__EnumLiteralDeclaration__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8437:1: ( ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) ) )
            // InternalXtext.g:8438:1: ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) )
            {
            // InternalXtext.g:8438:1: ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) )
            // InternalXtext.g:8439:2: ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralAssignment_1_1()); 
            // InternalXtext.g:8440:2: ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 )
            // InternalXtext.g:8440:3: rule__EnumLiteralDeclaration__LiteralAssignment_1_1
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
    // InternalXtext.g:8449:1: rule__Grammar__NameAssignment_1 : ( ruleGrammarID ) ;
    public final void rule__Grammar__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8453:1: ( ( ruleGrammarID ) )
            // InternalXtext.g:8454:2: ( ruleGrammarID )
            {
            // InternalXtext.g:8454:2: ( ruleGrammarID )
            // InternalXtext.g:8455:3: ruleGrammarID
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
    // InternalXtext.g:8464:1: rule__Grammar__UsedGrammarsAssignment_2_1 : ( ( ruleGrammarID ) ) ;
    public final void rule__Grammar__UsedGrammarsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8468:1: ( ( ( ruleGrammarID ) ) )
            // InternalXtext.g:8469:2: ( ( ruleGrammarID ) )
            {
            // InternalXtext.g:8469:2: ( ( ruleGrammarID ) )
            // InternalXtext.g:8470:3: ( ruleGrammarID )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_1_0()); 
            // InternalXtext.g:8471:3: ( ruleGrammarID )
            // InternalXtext.g:8472:4: ruleGrammarID
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
    // InternalXtext.g:8483:1: rule__Grammar__UsedGrammarsAssignment_2_2_1 : ( ( ruleGrammarID ) ) ;
    public final void rule__Grammar__UsedGrammarsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8487:1: ( ( ( ruleGrammarID ) ) )
            // InternalXtext.g:8488:2: ( ( ruleGrammarID ) )
            {
            // InternalXtext.g:8488:2: ( ( ruleGrammarID ) )
            // InternalXtext.g:8489:3: ( ruleGrammarID )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_2_1_0()); 
            // InternalXtext.g:8490:3: ( ruleGrammarID )
            // InternalXtext.g:8491:4: ruleGrammarID
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
    // InternalXtext.g:8502:1: rule__Grammar__DefinesHiddenTokensAssignment_3_0 : ( ( 'hidden' ) ) ;
    public final void rule__Grammar__DefinesHiddenTokensAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8506:1: ( ( ( 'hidden' ) ) )
            // InternalXtext.g:8507:2: ( ( 'hidden' ) )
            {
            // InternalXtext.g:8507:2: ( ( 'hidden' ) )
            // InternalXtext.g:8508:3: ( 'hidden' )
            {
             before(grammarAccess.getGrammarAccess().getDefinesHiddenTokensHiddenKeyword_3_0_0()); 
            // InternalXtext.g:8509:3: ( 'hidden' )
            // InternalXtext.g:8510:4: 'hidden'
            {
             before(grammarAccess.getGrammarAccess().getDefinesHiddenTokensHiddenKeyword_3_0_0()); 
            match(input,48,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:8521:1: rule__Grammar__HiddenTokensAssignment_3_2_0 : ( ( ruleRuleID ) ) ;
    public final void rule__Grammar__HiddenTokensAssignment_3_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8525:1: ( ( ( ruleRuleID ) ) )
            // InternalXtext.g:8526:2: ( ( ruleRuleID ) )
            {
            // InternalXtext.g:8526:2: ( ( ruleRuleID ) )
            // InternalXtext.g:8527:3: ( ruleRuleID )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_0_0()); 
            // InternalXtext.g:8528:3: ( ruleRuleID )
            // InternalXtext.g:8529:4: ruleRuleID
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
    // InternalXtext.g:8540:1: rule__Grammar__HiddenTokensAssignment_3_2_1_1 : ( ( ruleRuleID ) ) ;
    public final void rule__Grammar__HiddenTokensAssignment_3_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8544:1: ( ( ( ruleRuleID ) ) )
            // InternalXtext.g:8545:2: ( ( ruleRuleID ) )
            {
            // InternalXtext.g:8545:2: ( ( ruleRuleID ) )
            // InternalXtext.g:8546:3: ( ruleRuleID )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_1_1_0()); 
            // InternalXtext.g:8547:3: ( ruleRuleID )
            // InternalXtext.g:8548:4: ruleRuleID
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
    // InternalXtext.g:8559:1: rule__Grammar__MetamodelDeclarationsAssignment_4 : ( ruleAbstractMetamodelDeclaration ) ;
    public final void rule__Grammar__MetamodelDeclarationsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8563:1: ( ( ruleAbstractMetamodelDeclaration ) )
            // InternalXtext.g:8564:2: ( ruleAbstractMetamodelDeclaration )
            {
            // InternalXtext.g:8564:2: ( ruleAbstractMetamodelDeclaration )
            // InternalXtext.g:8565:3: ruleAbstractMetamodelDeclaration
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
    // InternalXtext.g:8574:1: rule__Grammar__RulesAssignment_5 : ( ruleAbstractRule ) ;
    public final void rule__Grammar__RulesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8578:1: ( ( ruleAbstractRule ) )
            // InternalXtext.g:8579:2: ( ruleAbstractRule )
            {
            // InternalXtext.g:8579:2: ( ruleAbstractRule )
            // InternalXtext.g:8580:3: ruleAbstractRule
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
    // InternalXtext.g:8589:1: rule__GeneratedMetamodel__NameAssignment_1 : ( ruleValidID ) ;
    public final void rule__GeneratedMetamodel__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8593:1: ( ( ruleValidID ) )
            // InternalXtext.g:8594:2: ( ruleValidID )
            {
            // InternalXtext.g:8594:2: ( ruleValidID )
            // InternalXtext.g:8595:3: ruleValidID
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
    // InternalXtext.g:8604:1: rule__GeneratedMetamodel__EPackageAssignment_2 : ( ( RULE_STRING ) ) ;
    public final void rule__GeneratedMetamodel__EPackageAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8608:1: ( ( ( RULE_STRING ) ) )
            // InternalXtext.g:8609:2: ( ( RULE_STRING ) )
            {
            // InternalXtext.g:8609:2: ( ( RULE_STRING ) )
            // InternalXtext.g:8610:3: ( RULE_STRING )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageCrossReference_2_0()); 
            // InternalXtext.g:8611:3: ( RULE_STRING )
            // InternalXtext.g:8612:4: RULE_STRING
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
    // InternalXtext.g:8623:1: rule__GeneratedMetamodel__AliasAssignment_3_1 : ( ruleValidID ) ;
    public final void rule__GeneratedMetamodel__AliasAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8627:1: ( ( ruleValidID ) )
            // InternalXtext.g:8628:2: ( ruleValidID )
            {
            // InternalXtext.g:8628:2: ( ruleValidID )
            // InternalXtext.g:8629:3: ruleValidID
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
    // InternalXtext.g:8638:1: rule__ReferencedMetamodel__EPackageAssignment_1 : ( ( RULE_STRING ) ) ;
    public final void rule__ReferencedMetamodel__EPackageAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8642:1: ( ( ( RULE_STRING ) ) )
            // InternalXtext.g:8643:2: ( ( RULE_STRING ) )
            {
            // InternalXtext.g:8643:2: ( ( RULE_STRING ) )
            // InternalXtext.g:8644:3: ( RULE_STRING )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageCrossReference_1_0()); 
            // InternalXtext.g:8645:3: ( RULE_STRING )
            // InternalXtext.g:8646:4: RULE_STRING
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
    // InternalXtext.g:8657:1: rule__ReferencedMetamodel__AliasAssignment_2_1 : ( ruleValidID ) ;
    public final void rule__ReferencedMetamodel__AliasAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8661:1: ( ( ruleValidID ) )
            // InternalXtext.g:8662:2: ( ruleValidID )
            {
            // InternalXtext.g:8662:2: ( ruleValidID )
            // InternalXtext.g:8663:3: ruleValidID
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


    // $ANTLR start "rule__Annotation__NameAssignment_1"
    // InternalXtext.g:8672:1: rule__Annotation__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Annotation__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8676:1: ( ( RULE_ID ) )
            // InternalXtext.g:8677:2: ( RULE_ID )
            {
            // InternalXtext.g:8677:2: ( RULE_ID )
            // InternalXtext.g:8678:3: RULE_ID
            {
             before(grammarAccess.getAnnotationAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAnnotationAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Annotation__NameAssignment_1"


    // $ANTLR start "rule__ParserRule__AnnotationsAssignment_0"
    // InternalXtext.g:8687:1: rule__ParserRule__AnnotationsAssignment_0 : ( ruleAnnotation ) ;
    public final void rule__ParserRule__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8691:1: ( ( ruleAnnotation ) )
            // InternalXtext.g:8692:2: ( ruleAnnotation )
            {
            // InternalXtext.g:8692:2: ( ruleAnnotation )
            // InternalXtext.g:8693:3: ruleAnnotation
            {
             before(grammarAccess.getParserRuleAccess().getAnnotationsAnnotationParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAnnotation();

            state._fsp--;

             after(grammarAccess.getParserRuleAccess().getAnnotationsAnnotationParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__AnnotationsAssignment_0"


    // $ANTLR start "rule__ParserRule__FragmentAssignment_1_0_0"
    // InternalXtext.g:8702:1: rule__ParserRule__FragmentAssignment_1_0_0 : ( ( 'fragment' ) ) ;
    public final void rule__ParserRule__FragmentAssignment_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8706:1: ( ( ( 'fragment' ) ) )
            // InternalXtext.g:8707:2: ( ( 'fragment' ) )
            {
            // InternalXtext.g:8707:2: ( ( 'fragment' ) )
            // InternalXtext.g:8708:3: ( 'fragment' )
            {
             before(grammarAccess.getParserRuleAccess().getFragmentFragmentKeyword_1_0_0_0()); 
            // InternalXtext.g:8709:3: ( 'fragment' )
            // InternalXtext.g:8710:4: 'fragment'
            {
             before(grammarAccess.getParserRuleAccess().getFragmentFragmentKeyword_1_0_0_0()); 
            match(input,49,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParserRuleAccess().getFragmentFragmentKeyword_1_0_0_0()); 

            }

             after(grammarAccess.getParserRuleAccess().getFragmentFragmentKeyword_1_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__FragmentAssignment_1_0_0"


    // $ANTLR start "rule__ParserRule__WildcardAssignment_1_0_2_0"
    // InternalXtext.g:8721:1: rule__ParserRule__WildcardAssignment_1_0_2_0 : ( ( '*' ) ) ;
    public final void rule__ParserRule__WildcardAssignment_1_0_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8725:1: ( ( ( '*' ) ) )
            // InternalXtext.g:8726:2: ( ( '*' ) )
            {
            // InternalXtext.g:8726:2: ( ( '*' ) )
            // InternalXtext.g:8727:3: ( '*' )
            {
             before(grammarAccess.getParserRuleAccess().getWildcardAsteriskKeyword_1_0_2_0_0()); 
            // InternalXtext.g:8728:3: ( '*' )
            // InternalXtext.g:8729:4: '*'
            {
             before(grammarAccess.getParserRuleAccess().getWildcardAsteriskKeyword_1_0_2_0_0()); 
            match(input,12,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParserRuleAccess().getWildcardAsteriskKeyword_1_0_2_0_0()); 

            }

             after(grammarAccess.getParserRuleAccess().getWildcardAsteriskKeyword_1_0_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__WildcardAssignment_1_0_2_0"


    // $ANTLR start "rule__ParserRule__TypeAssignment_1_0_2_1_1"
    // InternalXtext.g:8740:1: rule__ParserRule__TypeAssignment_1_0_2_1_1 : ( ruleTypeRef ) ;
    public final void rule__ParserRule__TypeAssignment_1_0_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8744:1: ( ( ruleTypeRef ) )
            // InternalXtext.g:8745:2: ( ruleTypeRef )
            {
            // InternalXtext.g:8745:2: ( ruleTypeRef )
            // InternalXtext.g:8746:3: ruleTypeRef
            {
             before(grammarAccess.getParserRuleAccess().getTypeTypeRefParserRuleCall_1_0_2_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTypeRef();

            state._fsp--;

             after(grammarAccess.getParserRuleAccess().getTypeTypeRefParserRuleCall_1_0_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__TypeAssignment_1_0_2_1_1"


    // $ANTLR start "rule__ParserRule__TypeAssignment_1_1_1_1"
    // InternalXtext.g:8755:1: rule__ParserRule__TypeAssignment_1_1_1_1 : ( ruleTypeRef ) ;
    public final void rule__ParserRule__TypeAssignment_1_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8759:1: ( ( ruleTypeRef ) )
            // InternalXtext.g:8760:2: ( ruleTypeRef )
            {
            // InternalXtext.g:8760:2: ( ruleTypeRef )
            // InternalXtext.g:8761:3: ruleTypeRef
            {
             before(grammarAccess.getParserRuleAccess().getTypeTypeRefParserRuleCall_1_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTypeRef();

            state._fsp--;

             after(grammarAccess.getParserRuleAccess().getTypeTypeRefParserRuleCall_1_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__TypeAssignment_1_1_1_1"


    // $ANTLR start "rule__ParserRule__DefinesHiddenTokensAssignment_2_0"
    // InternalXtext.g:8770:1: rule__ParserRule__DefinesHiddenTokensAssignment_2_0 : ( ( 'hidden' ) ) ;
    public final void rule__ParserRule__DefinesHiddenTokensAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8774:1: ( ( ( 'hidden' ) ) )
            // InternalXtext.g:8775:2: ( ( 'hidden' ) )
            {
            // InternalXtext.g:8775:2: ( ( 'hidden' ) )
            // InternalXtext.g:8776:3: ( 'hidden' )
            {
             before(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_2_0_0()); 
            // InternalXtext.g:8777:3: ( 'hidden' )
            // InternalXtext.g:8778:4: 'hidden'
            {
             before(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_2_0_0()); 
            match(input,48,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:8789:1: rule__ParserRule__HiddenTokensAssignment_2_2_0 : ( ( ruleRuleID ) ) ;
    public final void rule__ParserRule__HiddenTokensAssignment_2_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8793:1: ( ( ( ruleRuleID ) ) )
            // InternalXtext.g:8794:2: ( ( ruleRuleID ) )
            {
            // InternalXtext.g:8794:2: ( ( ruleRuleID ) )
            // InternalXtext.g:8795:3: ( ruleRuleID )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_0_0()); 
            // InternalXtext.g:8796:3: ( ruleRuleID )
            // InternalXtext.g:8797:4: ruleRuleID
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleRuleIDParserRuleCall_2_2_0_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleRuleID();

            state._fsp--;

             after(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleRuleIDParserRuleCall_2_2_0_0_1()); 

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
    // InternalXtext.g:8808:1: rule__ParserRule__HiddenTokensAssignment_2_2_1_1 : ( ( ruleRuleID ) ) ;
    public final void rule__ParserRule__HiddenTokensAssignment_2_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8812:1: ( ( ( ruleRuleID ) ) )
            // InternalXtext.g:8813:2: ( ( ruleRuleID ) )
            {
            // InternalXtext.g:8813:2: ( ( ruleRuleID ) )
            // InternalXtext.g:8814:3: ( ruleRuleID )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_1_1_0()); 
            // InternalXtext.g:8815:3: ( ruleRuleID )
            // InternalXtext.g:8816:4: ruleRuleID
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleRuleIDParserRuleCall_2_2_1_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleRuleID();

            state._fsp--;

             after(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleRuleIDParserRuleCall_2_2_1_1_0_1()); 

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
    // InternalXtext.g:8827:1: rule__ParserRule__AlternativesAssignment_4 : ( ruleAlternatives ) ;
    public final void rule__ParserRule__AlternativesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8831:1: ( ( ruleAlternatives ) )
            // InternalXtext.g:8832:2: ( ruleAlternatives )
            {
            // InternalXtext.g:8832:2: ( ruleAlternatives )
            // InternalXtext.g:8833:3: ruleAlternatives
            {
             before(grammarAccess.getParserRuleAccess().getAlternativesAlternativesParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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


    // $ANTLR start "rule__RuleNameAndParams__NameAssignment_0"
    // InternalXtext.g:8842:1: rule__RuleNameAndParams__NameAssignment_0 : ( ruleValidID ) ;
    public final void rule__RuleNameAndParams__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8846:1: ( ( ruleValidID ) )
            // InternalXtext.g:8847:2: ( ruleValidID )
            {
            // InternalXtext.g:8847:2: ( ruleValidID )
            // InternalXtext.g:8848:3: ruleValidID
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
    // InternalXtext.g:8857:1: rule__RuleNameAndParams__ParametersAssignment_1_1_0 : ( ruleParameter ) ;
    public final void rule__RuleNameAndParams__ParametersAssignment_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8861:1: ( ( ruleParameter ) )
            // InternalXtext.g:8862:2: ( ruleParameter )
            {
            // InternalXtext.g:8862:2: ( ruleParameter )
            // InternalXtext.g:8863:3: ruleParameter
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
    // InternalXtext.g:8872:1: rule__RuleNameAndParams__ParametersAssignment_1_1_1_1 : ( ruleParameter ) ;
    public final void rule__RuleNameAndParams__ParametersAssignment_1_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8876:1: ( ( ruleParameter ) )
            // InternalXtext.g:8877:2: ( ruleParameter )
            {
            // InternalXtext.g:8877:2: ( ruleParameter )
            // InternalXtext.g:8878:3: ruleParameter
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
    // InternalXtext.g:8887:1: rule__Parameter__NameAssignment : ( RULE_ID ) ;
    public final void rule__Parameter__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8891:1: ( ( RULE_ID ) )
            // InternalXtext.g:8892:2: ( RULE_ID )
            {
            // InternalXtext.g:8892:2: ( RULE_ID )
            // InternalXtext.g:8893:3: RULE_ID
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
    // InternalXtext.g:8902:1: rule__TypeRef__MetamodelAssignment_0_0 : ( ( RULE_ID ) ) ;
    public final void rule__TypeRef__MetamodelAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8906:1: ( ( ( RULE_ID ) ) )
            // InternalXtext.g:8907:2: ( ( RULE_ID ) )
            {
            // InternalXtext.g:8907:2: ( ( RULE_ID ) )
            // InternalXtext.g:8908:3: ( RULE_ID )
            {
             before(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationCrossReference_0_0_0()); 
            // InternalXtext.g:8909:3: ( RULE_ID )
            // InternalXtext.g:8910:4: RULE_ID
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
    // InternalXtext.g:8921:1: rule__TypeRef__ClassifierAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__TypeRef__ClassifierAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8925:1: ( ( ( RULE_ID ) ) )
            // InternalXtext.g:8926:2: ( ( RULE_ID ) )
            {
            // InternalXtext.g:8926:2: ( ( RULE_ID ) )
            // InternalXtext.g:8927:3: ( RULE_ID )
            {
             before(grammarAccess.getTypeRefAccess().getClassifierEClassifierCrossReference_1_0()); 
            // InternalXtext.g:8928:3: ( RULE_ID )
            // InternalXtext.g:8929:4: RULE_ID
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
    // InternalXtext.g:8940:1: rule__Alternatives__ElementsAssignment_1_1_1 : ( ruleConditionalBranch ) ;
    public final void rule__Alternatives__ElementsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8944:1: ( ( ruleConditionalBranch ) )
            // InternalXtext.g:8945:2: ( ruleConditionalBranch )
            {
            // InternalXtext.g:8945:2: ( ruleConditionalBranch )
            // InternalXtext.g:8946:3: ruleConditionalBranch
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
    // InternalXtext.g:8955:1: rule__ConditionalBranch__GuardConditionAssignment_1_2 : ( ruleDisjunction ) ;
    public final void rule__ConditionalBranch__GuardConditionAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8959:1: ( ( ruleDisjunction ) )
            // InternalXtext.g:8960:2: ( ruleDisjunction )
            {
            // InternalXtext.g:8960:2: ( ruleDisjunction )
            // InternalXtext.g:8961:3: ruleDisjunction
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
    // InternalXtext.g:8970:1: rule__ConditionalBranch__ElementsAssignment_1_4 : ( ruleAbstractToken ) ;
    public final void rule__ConditionalBranch__ElementsAssignment_1_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8974:1: ( ( ruleAbstractToken ) )
            // InternalXtext.g:8975:2: ( ruleAbstractToken )
            {
            // InternalXtext.g:8975:2: ( ruleAbstractToken )
            // InternalXtext.g:8976:3: ruleAbstractToken
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
    // InternalXtext.g:8985:1: rule__UnorderedGroup__ElementsAssignment_1_1_1 : ( ruleGroup ) ;
    public final void rule__UnorderedGroup__ElementsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8989:1: ( ( ruleGroup ) )
            // InternalXtext.g:8990:2: ( ruleGroup )
            {
            // InternalXtext.g:8990:2: ( ruleGroup )
            // InternalXtext.g:8991:3: ruleGroup
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
    // InternalXtext.g:9000:1: rule__Group__ElementsAssignment_1_1 : ( ruleAbstractToken ) ;
    public final void rule__Group__ElementsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9004:1: ( ( ruleAbstractToken ) )
            // InternalXtext.g:9005:2: ( ruleAbstractToken )
            {
            // InternalXtext.g:9005:2: ( ruleAbstractToken )
            // InternalXtext.g:9006:3: ruleAbstractToken
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
    // InternalXtext.g:9015:1: rule__AbstractTokenWithCardinality__CardinalityAssignment_1 : ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) ) ;
    public final void rule__AbstractTokenWithCardinality__CardinalityAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9019:1: ( ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) ) )
            // InternalXtext.g:9020:2: ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) )
            {
            // InternalXtext.g:9020:2: ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) )
            // InternalXtext.g:9021:3: ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 )
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAlternatives_1_0()); 
            // InternalXtext.g:9022:3: ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 )
            // InternalXtext.g:9022:4: rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0
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
    // InternalXtext.g:9030:1: rule__Action__TypeAssignment_1 : ( ruleTypeRef ) ;
    public final void rule__Action__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9034:1: ( ( ruleTypeRef ) )
            // InternalXtext.g:9035:2: ( ruleTypeRef )
            {
            // InternalXtext.g:9035:2: ( ruleTypeRef )
            // InternalXtext.g:9036:3: ruleTypeRef
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
    // InternalXtext.g:9045:1: rule__Action__FeatureAssignment_2_1 : ( ruleValidID ) ;
    public final void rule__Action__FeatureAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9049:1: ( ( ruleValidID ) )
            // InternalXtext.g:9050:2: ( ruleValidID )
            {
            // InternalXtext.g:9050:2: ( ruleValidID )
            // InternalXtext.g:9051:3: ruleValidID
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
    // InternalXtext.g:9060:1: rule__Action__OperatorAssignment_2_2 : ( ( rule__Action__OperatorAlternatives_2_2_0 ) ) ;
    public final void rule__Action__OperatorAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9064:1: ( ( ( rule__Action__OperatorAlternatives_2_2_0 ) ) )
            // InternalXtext.g:9065:2: ( ( rule__Action__OperatorAlternatives_2_2_0 ) )
            {
            // InternalXtext.g:9065:2: ( ( rule__Action__OperatorAlternatives_2_2_0 ) )
            // InternalXtext.g:9066:3: ( rule__Action__OperatorAlternatives_2_2_0 )
            {
             before(grammarAccess.getActionAccess().getOperatorAlternatives_2_2_0()); 
            // InternalXtext.g:9067:3: ( rule__Action__OperatorAlternatives_2_2_0 )
            // InternalXtext.g:9067:4: rule__Action__OperatorAlternatives_2_2_0
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
    // InternalXtext.g:9075:1: rule__Keyword__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__Keyword__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9079:1: ( ( RULE_STRING ) )
            // InternalXtext.g:9080:2: ( RULE_STRING )
            {
            // InternalXtext.g:9080:2: ( RULE_STRING )
            // InternalXtext.g:9081:3: RULE_STRING
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
    // InternalXtext.g:9090:1: rule__RuleCall__RuleAssignment_0 : ( ( ruleRuleID ) ) ;
    public final void rule__RuleCall__RuleAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9094:1: ( ( ( ruleRuleID ) ) )
            // InternalXtext.g:9095:2: ( ( ruleRuleID ) )
            {
            // InternalXtext.g:9095:2: ( ( ruleRuleID ) )
            // InternalXtext.g:9096:3: ( ruleRuleID )
            {
             before(grammarAccess.getRuleCallAccess().getRuleAbstractRuleCrossReference_0_0()); 
            // InternalXtext.g:9097:3: ( ruleRuleID )
            // InternalXtext.g:9098:4: ruleRuleID
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
    // InternalXtext.g:9109:1: rule__RuleCall__ArgumentsAssignment_1_1 : ( ruleNamedArgument ) ;
    public final void rule__RuleCall__ArgumentsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9113:1: ( ( ruleNamedArgument ) )
            // InternalXtext.g:9114:2: ( ruleNamedArgument )
            {
            // InternalXtext.g:9114:2: ( ruleNamedArgument )
            // InternalXtext.g:9115:3: ruleNamedArgument
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
    // InternalXtext.g:9124:1: rule__RuleCall__ArgumentsAssignment_1_2_1 : ( ruleNamedArgument ) ;
    public final void rule__RuleCall__ArgumentsAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9128:1: ( ( ruleNamedArgument ) )
            // InternalXtext.g:9129:2: ( ruleNamedArgument )
            {
            // InternalXtext.g:9129:2: ( ruleNamedArgument )
            // InternalXtext.g:9130:3: ruleNamedArgument
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
    // InternalXtext.g:9139:1: rule__NamedArgument__ParameterAssignment_0_0 : ( ( RULE_ID ) ) ;
    public final void rule__NamedArgument__ParameterAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9143:1: ( ( ( RULE_ID ) ) )
            // InternalXtext.g:9144:2: ( ( RULE_ID ) )
            {
            // InternalXtext.g:9144:2: ( ( RULE_ID ) )
            // InternalXtext.g:9145:3: ( RULE_ID )
            {
             before(grammarAccess.getNamedArgumentAccess().getParameterParameterCrossReference_0_0_0()); 
            // InternalXtext.g:9146:3: ( RULE_ID )
            // InternalXtext.g:9147:4: RULE_ID
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
    // InternalXtext.g:9158:1: rule__NamedArgument__CalledByNameAssignment_0_1 : ( ( '=' ) ) ;
    public final void rule__NamedArgument__CalledByNameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9162:1: ( ( ( '=' ) ) )
            // InternalXtext.g:9163:2: ( ( '=' ) )
            {
            // InternalXtext.g:9163:2: ( ( '=' ) )
            // InternalXtext.g:9164:3: ( '=' )
            {
             before(grammarAccess.getNamedArgumentAccess().getCalledByNameEqualsSignKeyword_0_1_0()); 
            // InternalXtext.g:9165:3: ( '=' )
            // InternalXtext.g:9166:4: '='
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
    // InternalXtext.g:9177:1: rule__NamedArgument__ValueAssignment_1 : ( ruleDisjunction ) ;
    public final void rule__NamedArgument__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9181:1: ( ( ruleDisjunction ) )
            // InternalXtext.g:9182:2: ( ruleDisjunction )
            {
            // InternalXtext.g:9182:2: ( ruleDisjunction )
            // InternalXtext.g:9183:3: ruleDisjunction
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
    // InternalXtext.g:9192:1: rule__LiteralCondition__TrueAssignment_1_0 : ( ( 'true' ) ) ;
    public final void rule__LiteralCondition__TrueAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9196:1: ( ( ( 'true' ) ) )
            // InternalXtext.g:9197:2: ( ( 'true' ) )
            {
            // InternalXtext.g:9197:2: ( ( 'true' ) )
            // InternalXtext.g:9198:3: ( 'true' )
            {
             before(grammarAccess.getLiteralConditionAccess().getTrueTrueKeyword_1_0_0()); 
            // InternalXtext.g:9199:3: ( 'true' )
            // InternalXtext.g:9200:4: 'true'
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
    // InternalXtext.g:9211:1: rule__Disjunction__RightAssignment_1_2 : ( ruleConjunction ) ;
    public final void rule__Disjunction__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9215:1: ( ( ruleConjunction ) )
            // InternalXtext.g:9216:2: ( ruleConjunction )
            {
            // InternalXtext.g:9216:2: ( ruleConjunction )
            // InternalXtext.g:9217:3: ruleConjunction
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
    // InternalXtext.g:9226:1: rule__Conjunction__RightAssignment_1_2 : ( ruleNegation ) ;
    public final void rule__Conjunction__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9230:1: ( ( ruleNegation ) )
            // InternalXtext.g:9231:2: ( ruleNegation )
            {
            // InternalXtext.g:9231:2: ( ruleNegation )
            // InternalXtext.g:9232:3: ruleNegation
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
    // InternalXtext.g:9241:1: rule__Negation__ValueAssignment_1_2 : ( ruleNegation ) ;
    public final void rule__Negation__ValueAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9245:1: ( ( ruleNegation ) )
            // InternalXtext.g:9246:2: ( ruleNegation )
            {
            // InternalXtext.g:9246:2: ( ruleNegation )
            // InternalXtext.g:9247:3: ruleNegation
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
    // InternalXtext.g:9256:1: rule__ParameterReference__ParameterAssignment : ( ( RULE_ID ) ) ;
    public final void rule__ParameterReference__ParameterAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9260:1: ( ( ( RULE_ID ) ) )
            // InternalXtext.g:9261:2: ( ( RULE_ID ) )
            {
            // InternalXtext.g:9261:2: ( ( RULE_ID ) )
            // InternalXtext.g:9262:3: ( RULE_ID )
            {
             before(grammarAccess.getParameterReferenceAccess().getParameterParameterCrossReference_0()); 
            // InternalXtext.g:9263:3: ( RULE_ID )
            // InternalXtext.g:9264:4: RULE_ID
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
    // InternalXtext.g:9275:1: rule__TerminalRuleCall__RuleAssignment : ( ( ruleRuleID ) ) ;
    public final void rule__TerminalRuleCall__RuleAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9279:1: ( ( ( ruleRuleID ) ) )
            // InternalXtext.g:9280:2: ( ( ruleRuleID ) )
            {
            // InternalXtext.g:9280:2: ( ( ruleRuleID ) )
            // InternalXtext.g:9281:3: ( ruleRuleID )
            {
             before(grammarAccess.getTerminalRuleCallAccess().getRuleAbstractRuleCrossReference_0()); 
            // InternalXtext.g:9282:3: ( ruleRuleID )
            // InternalXtext.g:9283:4: ruleRuleID
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
    // InternalXtext.g:9294:1: rule__PredicatedKeyword__PredicatedAssignment_0_0 : ( ( '=>' ) ) ;
    public final void rule__PredicatedKeyword__PredicatedAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9298:1: ( ( ( '=>' ) ) )
            // InternalXtext.g:9299:2: ( ( '=>' ) )
            {
            // InternalXtext.g:9299:2: ( ( '=>' ) )
            // InternalXtext.g:9300:3: ( '=>' )
            {
             before(grammarAccess.getPredicatedKeywordAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 
            // InternalXtext.g:9301:3: ( '=>' )
            // InternalXtext.g:9302:4: '=>'
            {
             before(grammarAccess.getPredicatedKeywordAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 
            match(input,50,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:9313:1: rule__PredicatedKeyword__FirstSetPredicatedAssignment_0_1 : ( ( '->' ) ) ;
    public final void rule__PredicatedKeyword__FirstSetPredicatedAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9317:1: ( ( ( '->' ) ) )
            // InternalXtext.g:9318:2: ( ( '->' ) )
            {
            // InternalXtext.g:9318:2: ( ( '->' ) )
            // InternalXtext.g:9319:3: ( '->' )
            {
             before(grammarAccess.getPredicatedKeywordAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 
            // InternalXtext.g:9320:3: ( '->' )
            // InternalXtext.g:9321:4: '->'
            {
             before(grammarAccess.getPredicatedKeywordAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 
            match(input,44,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:9332:1: rule__PredicatedKeyword__ValueAssignment_1 : ( RULE_STRING ) ;
    public final void rule__PredicatedKeyword__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9336:1: ( ( RULE_STRING ) )
            // InternalXtext.g:9337:2: ( RULE_STRING )
            {
            // InternalXtext.g:9337:2: ( RULE_STRING )
            // InternalXtext.g:9338:3: RULE_STRING
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
    // InternalXtext.g:9347:1: rule__PredicatedRuleCall__PredicatedAssignment_0_0 : ( ( '=>' ) ) ;
    public final void rule__PredicatedRuleCall__PredicatedAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9351:1: ( ( ( '=>' ) ) )
            // InternalXtext.g:9352:2: ( ( '=>' ) )
            {
            // InternalXtext.g:9352:2: ( ( '=>' ) )
            // InternalXtext.g:9353:3: ( '=>' )
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 
            // InternalXtext.g:9354:3: ( '=>' )
            // InternalXtext.g:9355:4: '=>'
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 
            match(input,50,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:9366:1: rule__PredicatedRuleCall__FirstSetPredicatedAssignment_0_1 : ( ( '->' ) ) ;
    public final void rule__PredicatedRuleCall__FirstSetPredicatedAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9370:1: ( ( ( '->' ) ) )
            // InternalXtext.g:9371:2: ( ( '->' ) )
            {
            // InternalXtext.g:9371:2: ( ( '->' ) )
            // InternalXtext.g:9372:3: ( '->' )
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 
            // InternalXtext.g:9373:3: ( '->' )
            // InternalXtext.g:9374:4: '->'
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 
            match(input,44,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:9385:1: rule__PredicatedRuleCall__RuleAssignment_1 : ( ( ruleRuleID ) ) ;
    public final void rule__PredicatedRuleCall__RuleAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9389:1: ( ( ( ruleRuleID ) ) )
            // InternalXtext.g:9390:2: ( ( ruleRuleID ) )
            {
            // InternalXtext.g:9390:2: ( ( ruleRuleID ) )
            // InternalXtext.g:9391:3: ( ruleRuleID )
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getRuleAbstractRuleCrossReference_1_0()); 
            // InternalXtext.g:9392:3: ( ruleRuleID )
            // InternalXtext.g:9393:4: ruleRuleID
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getRuleAbstractRuleRuleIDParserRuleCall_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleRuleID();

            state._fsp--;

             after(grammarAccess.getPredicatedRuleCallAccess().getRuleAbstractRuleRuleIDParserRuleCall_1_0_1()); 

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
    // InternalXtext.g:9404:1: rule__PredicatedRuleCall__ArgumentsAssignment_2_1 : ( ruleNamedArgument ) ;
    public final void rule__PredicatedRuleCall__ArgumentsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9408:1: ( ( ruleNamedArgument ) )
            // InternalXtext.g:9409:2: ( ruleNamedArgument )
            {
            // InternalXtext.g:9409:2: ( ruleNamedArgument )
            // InternalXtext.g:9410:3: ruleNamedArgument
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
    // InternalXtext.g:9419:1: rule__PredicatedRuleCall__ArgumentsAssignment_2_2_1 : ( ruleNamedArgument ) ;
    public final void rule__PredicatedRuleCall__ArgumentsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9423:1: ( ( ruleNamedArgument ) )
            // InternalXtext.g:9424:2: ( ruleNamedArgument )
            {
            // InternalXtext.g:9424:2: ( ruleNamedArgument )
            // InternalXtext.g:9425:3: ruleNamedArgument
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
    // InternalXtext.g:9434:1: rule__Assignment__PredicatedAssignment_0_0 : ( ( '=>' ) ) ;
    public final void rule__Assignment__PredicatedAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9438:1: ( ( ( '=>' ) ) )
            // InternalXtext.g:9439:2: ( ( '=>' ) )
            {
            // InternalXtext.g:9439:2: ( ( '=>' ) )
            // InternalXtext.g:9440:3: ( '=>' )
            {
             before(grammarAccess.getAssignmentAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 
            // InternalXtext.g:9441:3: ( '=>' )
            // InternalXtext.g:9442:4: '=>'
            {
             before(grammarAccess.getAssignmentAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 
            match(input,50,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:9453:1: rule__Assignment__FirstSetPredicatedAssignment_0_1 : ( ( '->' ) ) ;
    public final void rule__Assignment__FirstSetPredicatedAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9457:1: ( ( ( '->' ) ) )
            // InternalXtext.g:9458:2: ( ( '->' ) )
            {
            // InternalXtext.g:9458:2: ( ( '->' ) )
            // InternalXtext.g:9459:3: ( '->' )
            {
             before(grammarAccess.getAssignmentAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 
            // InternalXtext.g:9460:3: ( '->' )
            // InternalXtext.g:9461:4: '->'
            {
             before(grammarAccess.getAssignmentAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 
            match(input,44,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:9472:1: rule__Assignment__FeatureAssignment_1 : ( ruleValidID ) ;
    public final void rule__Assignment__FeatureAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9476:1: ( ( ruleValidID ) )
            // InternalXtext.g:9477:2: ( ruleValidID )
            {
            // InternalXtext.g:9477:2: ( ruleValidID )
            // InternalXtext.g:9478:3: ruleValidID
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
    // InternalXtext.g:9487:1: rule__Assignment__OperatorAssignment_2 : ( ( rule__Assignment__OperatorAlternatives_2_0 ) ) ;
    public final void rule__Assignment__OperatorAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9491:1: ( ( ( rule__Assignment__OperatorAlternatives_2_0 ) ) )
            // InternalXtext.g:9492:2: ( ( rule__Assignment__OperatorAlternatives_2_0 ) )
            {
            // InternalXtext.g:9492:2: ( ( rule__Assignment__OperatorAlternatives_2_0 ) )
            // InternalXtext.g:9493:3: ( rule__Assignment__OperatorAlternatives_2_0 )
            {
             before(grammarAccess.getAssignmentAccess().getOperatorAlternatives_2_0()); 
            // InternalXtext.g:9494:3: ( rule__Assignment__OperatorAlternatives_2_0 )
            // InternalXtext.g:9494:4: rule__Assignment__OperatorAlternatives_2_0
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
    // InternalXtext.g:9502:1: rule__Assignment__TerminalAssignment_3 : ( ruleAssignableTerminal ) ;
    public final void rule__Assignment__TerminalAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9506:1: ( ( ruleAssignableTerminal ) )
            // InternalXtext.g:9507:2: ( ruleAssignableTerminal )
            {
            // InternalXtext.g:9507:2: ( ruleAssignableTerminal )
            // InternalXtext.g:9508:3: ruleAssignableTerminal
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
    // InternalXtext.g:9517:1: rule__AssignableAlternatives__ElementsAssignment_1_1_1 : ( ruleAssignableTerminal ) ;
    public final void rule__AssignableAlternatives__ElementsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9521:1: ( ( ruleAssignableTerminal ) )
            // InternalXtext.g:9522:2: ( ruleAssignableTerminal )
            {
            // InternalXtext.g:9522:2: ( ruleAssignableTerminal )
            // InternalXtext.g:9523:3: ruleAssignableTerminal
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
    // InternalXtext.g:9532:1: rule__CrossReference__TypeAssignment_1 : ( ruleTypeRef ) ;
    public final void rule__CrossReference__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9536:1: ( ( ruleTypeRef ) )
            // InternalXtext.g:9537:2: ( ruleTypeRef )
            {
            // InternalXtext.g:9537:2: ( ruleTypeRef )
            // InternalXtext.g:9538:3: ruleTypeRef
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
    // InternalXtext.g:9547:1: rule__CrossReference__TerminalAssignment_2_1 : ( ruleCrossReferenceableTerminal ) ;
    public final void rule__CrossReference__TerminalAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9551:1: ( ( ruleCrossReferenceableTerminal ) )
            // InternalXtext.g:9552:2: ( ruleCrossReferenceableTerminal )
            {
            // InternalXtext.g:9552:2: ( ruleCrossReferenceableTerminal )
            // InternalXtext.g:9553:3: ruleCrossReferenceableTerminal
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
    // InternalXtext.g:9562:1: rule__PredicatedGroup__PredicatedAssignment_0_0 : ( ( '=>' ) ) ;
    public final void rule__PredicatedGroup__PredicatedAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9566:1: ( ( ( '=>' ) ) )
            // InternalXtext.g:9567:2: ( ( '=>' ) )
            {
            // InternalXtext.g:9567:2: ( ( '=>' ) )
            // InternalXtext.g:9568:3: ( '=>' )
            {
             before(grammarAccess.getPredicatedGroupAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 
            // InternalXtext.g:9569:3: ( '=>' )
            // InternalXtext.g:9570:4: '=>'
            {
             before(grammarAccess.getPredicatedGroupAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 
            match(input,50,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:9581:1: rule__PredicatedGroup__FirstSetPredicatedAssignment_0_1 : ( ( '->' ) ) ;
    public final void rule__PredicatedGroup__FirstSetPredicatedAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9585:1: ( ( ( '->' ) ) )
            // InternalXtext.g:9586:2: ( ( '->' ) )
            {
            // InternalXtext.g:9586:2: ( ( '->' ) )
            // InternalXtext.g:9587:3: ( '->' )
            {
             before(grammarAccess.getPredicatedGroupAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 
            // InternalXtext.g:9588:3: ( '->' )
            // InternalXtext.g:9589:4: '->'
            {
             before(grammarAccess.getPredicatedGroupAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 
            match(input,44,FollowSets000.FOLLOW_2); 
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
    // InternalXtext.g:9600:1: rule__PredicatedGroup__ElementsAssignment_2 : ( ruleAlternatives ) ;
    public final void rule__PredicatedGroup__ElementsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9604:1: ( ( ruleAlternatives ) )
            // InternalXtext.g:9605:2: ( ruleAlternatives )
            {
            // InternalXtext.g:9605:2: ( ruleAlternatives )
            // InternalXtext.g:9606:3: ruleAlternatives
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


    // $ANTLR start "rule__TerminalRule__AnnotationsAssignment_0"
    // InternalXtext.g:9615:1: rule__TerminalRule__AnnotationsAssignment_0 : ( ruleAnnotation ) ;
    public final void rule__TerminalRule__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9619:1: ( ( ruleAnnotation ) )
            // InternalXtext.g:9620:2: ( ruleAnnotation )
            {
            // InternalXtext.g:9620:2: ( ruleAnnotation )
            // InternalXtext.g:9621:3: ruleAnnotation
            {
             before(grammarAccess.getTerminalRuleAccess().getAnnotationsAnnotationParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAnnotation();

            state._fsp--;

             after(grammarAccess.getTerminalRuleAccess().getAnnotationsAnnotationParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__AnnotationsAssignment_0"


    // $ANTLR start "rule__TerminalRule__FragmentAssignment_2_0_0"
    // InternalXtext.g:9630:1: rule__TerminalRule__FragmentAssignment_2_0_0 : ( ( 'fragment' ) ) ;
    public final void rule__TerminalRule__FragmentAssignment_2_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9634:1: ( ( ( 'fragment' ) ) )
            // InternalXtext.g:9635:2: ( ( 'fragment' ) )
            {
            // InternalXtext.g:9635:2: ( ( 'fragment' ) )
            // InternalXtext.g:9636:3: ( 'fragment' )
            {
             before(grammarAccess.getTerminalRuleAccess().getFragmentFragmentKeyword_2_0_0_0()); 
            // InternalXtext.g:9637:3: ( 'fragment' )
            // InternalXtext.g:9638:4: 'fragment'
            {
             before(grammarAccess.getTerminalRuleAccess().getFragmentFragmentKeyword_2_0_0_0()); 
            match(input,49,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTerminalRuleAccess().getFragmentFragmentKeyword_2_0_0_0()); 

            }

             after(grammarAccess.getTerminalRuleAccess().getFragmentFragmentKeyword_2_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__FragmentAssignment_2_0_0"


    // $ANTLR start "rule__TerminalRule__NameAssignment_2_0_1"
    // InternalXtext.g:9649:1: rule__TerminalRule__NameAssignment_2_0_1 : ( ruleValidID ) ;
    public final void rule__TerminalRule__NameAssignment_2_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9653:1: ( ( ruleValidID ) )
            // InternalXtext.g:9654:2: ( ruleValidID )
            {
            // InternalXtext.g:9654:2: ( ruleValidID )
            // InternalXtext.g:9655:3: ruleValidID
            {
             before(grammarAccess.getTerminalRuleAccess().getNameValidIDParserRuleCall_2_0_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getTerminalRuleAccess().getNameValidIDParserRuleCall_2_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__NameAssignment_2_0_1"


    // $ANTLR start "rule__TerminalRule__NameAssignment_2_1_0"
    // InternalXtext.g:9664:1: rule__TerminalRule__NameAssignment_2_1_0 : ( ruleValidID ) ;
    public final void rule__TerminalRule__NameAssignment_2_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9668:1: ( ( ruleValidID ) )
            // InternalXtext.g:9669:2: ( ruleValidID )
            {
            // InternalXtext.g:9669:2: ( ruleValidID )
            // InternalXtext.g:9670:3: ruleValidID
            {
             before(grammarAccess.getTerminalRuleAccess().getNameValidIDParserRuleCall_2_1_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getTerminalRuleAccess().getNameValidIDParserRuleCall_2_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__NameAssignment_2_1_0"


    // $ANTLR start "rule__TerminalRule__TypeAssignment_2_1_1_1"
    // InternalXtext.g:9679:1: rule__TerminalRule__TypeAssignment_2_1_1_1 : ( ruleTypeRef ) ;
    public final void rule__TerminalRule__TypeAssignment_2_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9683:1: ( ( ruleTypeRef ) )
            // InternalXtext.g:9684:2: ( ruleTypeRef )
            {
            // InternalXtext.g:9684:2: ( ruleTypeRef )
            // InternalXtext.g:9685:3: ruleTypeRef
            {
             before(grammarAccess.getTerminalRuleAccess().getTypeTypeRefParserRuleCall_2_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTypeRef();

            state._fsp--;

             after(grammarAccess.getTerminalRuleAccess().getTypeTypeRefParserRuleCall_2_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__TypeAssignment_2_1_1_1"


    // $ANTLR start "rule__TerminalRule__AlternativesAssignment_4"
    // InternalXtext.g:9694:1: rule__TerminalRule__AlternativesAssignment_4 : ( ruleTerminalAlternatives ) ;
    public final void rule__TerminalRule__AlternativesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9698:1: ( ( ruleTerminalAlternatives ) )
            // InternalXtext.g:9699:2: ( ruleTerminalAlternatives )
            {
            // InternalXtext.g:9699:2: ( ruleTerminalAlternatives )
            // InternalXtext.g:9700:3: ruleTerminalAlternatives
            {
             before(grammarAccess.getTerminalRuleAccess().getAlternativesTerminalAlternativesParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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


    // $ANTLR start "rule__TerminalAlternatives__ElementsAssignment_1_1_1"
    // InternalXtext.g:9709:1: rule__TerminalAlternatives__ElementsAssignment_1_1_1 : ( ruleTerminalGroup ) ;
    public final void rule__TerminalAlternatives__ElementsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9713:1: ( ( ruleTerminalGroup ) )
            // InternalXtext.g:9714:2: ( ruleTerminalGroup )
            {
            // InternalXtext.g:9714:2: ( ruleTerminalGroup )
            // InternalXtext.g:9715:3: ruleTerminalGroup
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
    // InternalXtext.g:9724:1: rule__TerminalGroup__ElementsAssignment_1_1 : ( ruleTerminalToken ) ;
    public final void rule__TerminalGroup__ElementsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9728:1: ( ( ruleTerminalToken ) )
            // InternalXtext.g:9729:2: ( ruleTerminalToken )
            {
            // InternalXtext.g:9729:2: ( ruleTerminalToken )
            // InternalXtext.g:9730:3: ruleTerminalToken
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
    // InternalXtext.g:9739:1: rule__TerminalToken__CardinalityAssignment_1 : ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) ) ;
    public final void rule__TerminalToken__CardinalityAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9743:1: ( ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) ) )
            // InternalXtext.g:9744:2: ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) )
            {
            // InternalXtext.g:9744:2: ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) )
            // InternalXtext.g:9745:3: ( rule__TerminalToken__CardinalityAlternatives_1_0 )
            {
             before(grammarAccess.getTerminalTokenAccess().getCardinalityAlternatives_1_0()); 
            // InternalXtext.g:9746:3: ( rule__TerminalToken__CardinalityAlternatives_1_0 )
            // InternalXtext.g:9746:4: rule__TerminalToken__CardinalityAlternatives_1_0
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
    // InternalXtext.g:9754:1: rule__NegatedToken__TerminalAssignment_1 : ( ruleTerminalTokenElement ) ;
    public final void rule__NegatedToken__TerminalAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9758:1: ( ( ruleTerminalTokenElement ) )
            // InternalXtext.g:9759:2: ( ruleTerminalTokenElement )
            {
            // InternalXtext.g:9759:2: ( ruleTerminalTokenElement )
            // InternalXtext.g:9760:3: ruleTerminalTokenElement
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
    // InternalXtext.g:9769:1: rule__UntilToken__TerminalAssignment_1 : ( ruleTerminalTokenElement ) ;
    public final void rule__UntilToken__TerminalAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9773:1: ( ( ruleTerminalTokenElement ) )
            // InternalXtext.g:9774:2: ( ruleTerminalTokenElement )
            {
            // InternalXtext.g:9774:2: ( ruleTerminalTokenElement )
            // InternalXtext.g:9775:3: ruleTerminalTokenElement
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
    // InternalXtext.g:9784:1: rule__CharacterRange__RightAssignment_1_2 : ( ruleKeyword ) ;
    public final void rule__CharacterRange__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9788:1: ( ( ruleKeyword ) )
            // InternalXtext.g:9789:2: ( ruleKeyword )
            {
            // InternalXtext.g:9789:2: ( ruleKeyword )
            // InternalXtext.g:9790:3: ruleKeyword
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


    // $ANTLR start "rule__EnumRule__AnnotationsAssignment_0"
    // InternalXtext.g:9799:1: rule__EnumRule__AnnotationsAssignment_0 : ( ruleAnnotation ) ;
    public final void rule__EnumRule__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9803:1: ( ( ruleAnnotation ) )
            // InternalXtext.g:9804:2: ( ruleAnnotation )
            {
            // InternalXtext.g:9804:2: ( ruleAnnotation )
            // InternalXtext.g:9805:3: ruleAnnotation
            {
             before(grammarAccess.getEnumRuleAccess().getAnnotationsAnnotationParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAnnotation();

            state._fsp--;

             after(grammarAccess.getEnumRuleAccess().getAnnotationsAnnotationParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__AnnotationsAssignment_0"


    // $ANTLR start "rule__EnumRule__NameAssignment_2"
    // InternalXtext.g:9814:1: rule__EnumRule__NameAssignment_2 : ( ruleValidID ) ;
    public final void rule__EnumRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9818:1: ( ( ruleValidID ) )
            // InternalXtext.g:9819:2: ( ruleValidID )
            {
            // InternalXtext.g:9819:2: ( ruleValidID )
            // InternalXtext.g:9820:3: ruleValidID
            {
             before(grammarAccess.getEnumRuleAccess().getNameValidIDParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getEnumRuleAccess().getNameValidIDParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__NameAssignment_2"


    // $ANTLR start "rule__EnumRule__TypeAssignment_3_1"
    // InternalXtext.g:9829:1: rule__EnumRule__TypeAssignment_3_1 : ( ruleTypeRef ) ;
    public final void rule__EnumRule__TypeAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9833:1: ( ( ruleTypeRef ) )
            // InternalXtext.g:9834:2: ( ruleTypeRef )
            {
            // InternalXtext.g:9834:2: ( ruleTypeRef )
            // InternalXtext.g:9835:3: ruleTypeRef
            {
             before(grammarAccess.getEnumRuleAccess().getTypeTypeRefParserRuleCall_3_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTypeRef();

            state._fsp--;

             after(grammarAccess.getEnumRuleAccess().getTypeTypeRefParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__TypeAssignment_3_1"


    // $ANTLR start "rule__EnumRule__AlternativesAssignment_5"
    // InternalXtext.g:9844:1: rule__EnumRule__AlternativesAssignment_5 : ( ruleEnumLiterals ) ;
    public final void rule__EnumRule__AlternativesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9848:1: ( ( ruleEnumLiterals ) )
            // InternalXtext.g:9849:2: ( ruleEnumLiterals )
            {
            // InternalXtext.g:9849:2: ( ruleEnumLiterals )
            // InternalXtext.g:9850:3: ruleEnumLiterals
            {
             before(grammarAccess.getEnumRuleAccess().getAlternativesEnumLiteralsParserRuleCall_5_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleEnumLiterals();

            state._fsp--;

             after(grammarAccess.getEnumRuleAccess().getAlternativesEnumLiteralsParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__AlternativesAssignment_5"


    // $ANTLR start "rule__EnumLiterals__ElementsAssignment_1_1_1"
    // InternalXtext.g:9859:1: rule__EnumLiterals__ElementsAssignment_1_1_1 : ( ruleEnumLiteralDeclaration ) ;
    public final void rule__EnumLiterals__ElementsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9863:1: ( ( ruleEnumLiteralDeclaration ) )
            // InternalXtext.g:9864:2: ( ruleEnumLiteralDeclaration )
            {
            // InternalXtext.g:9864:2: ( ruleEnumLiteralDeclaration )
            // InternalXtext.g:9865:3: ruleEnumLiteralDeclaration
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
    // InternalXtext.g:9874:1: rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 : ( ( ruleValidID ) ) ;
    public final void rule__EnumLiteralDeclaration__EnumLiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9878:1: ( ( ( ruleValidID ) ) )
            // InternalXtext.g:9879:2: ( ( ruleValidID ) )
            {
            // InternalXtext.g:9879:2: ( ( ruleValidID ) )
            // InternalXtext.g:9880:3: ( ruleValidID )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralCrossReference_0_0()); 
            // InternalXtext.g:9881:3: ( ruleValidID )
            // InternalXtext.g:9882:4: ruleValidID
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralValidIDParserRuleCall_0_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralValidIDParserRuleCall_0_0_1()); 

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
    // InternalXtext.g:9893:1: rule__EnumLiteralDeclaration__LiteralAssignment_1_1 : ( ruleKeyword ) ;
    public final void rule__EnumLiteralDeclaration__LiteralAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9897:1: ( ( ruleKeyword ) )
            // InternalXtext.g:9898:2: ( ruleKeyword )
            {
            // InternalXtext.g:9898:2: ( ruleKeyword )
            // InternalXtext.g:9899:3: ruleKeyword
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


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA8 dfa8 = new DFA8(this);
    static final String dfa_1s = "\6\uffff";
    static final String dfa_2s = "\2\4\3\uffff\1\4";
    static final String dfa_3s = "\1\61\1\4\3\uffff\1\61";
    static final String dfa_4s = "\2\uffff\1\1\1\2\1\3\1\uffff";
    static final String dfa_5s = "\6\uffff}>";
    static final String[] dfa_6s = {
            "\1\2\13\uffff\2\2\12\uffff\1\1\16\uffff\1\3\3\uffff\1\4\1\uffff\1\2",
            "\1\5",
            "",
            "",
            "",
            "\1\2\13\uffff\2\2\12\uffff\1\1\16\uffff\1\3\3\uffff\1\4\1\uffff\1\2"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "1474:1: rule__AbstractRule__Alternatives : ( ( ruleParserRule ) | ( ruleTerminalRule ) | ( ruleEnumRule ) );";
        }
    }
    static final String dfa_7s = "\13\uffff";
    static final String dfa_8s = "\3\uffff\3\6\1\uffff\3\6\1\uffff";
    static final String dfa_9s = "\6\4\1\uffff\3\4\1\uffff";
    static final String dfa_10s = "\1\62\2\26\3\62\1\uffff\3\62\1\uffff";
    static final String dfa_11s = "\6\uffff\1\2\3\uffff\1\1";
    static final String dfa_12s = "\13\uffff}>";
    static final String[] dfa_13s = {
            "\1\3\1\6\12\uffff\1\5\1\4\4\uffff\1\6\25\uffff\1\2\5\uffff\1\1",
            "\1\7\1\6\12\uffff\1\11\1\10\4\uffff\1\6",
            "\1\7\1\6\12\uffff\1\11\1\10\4\uffff\1\6",
            "\2\6\5\uffff\3\6\2\12\2\6\1\12\3\uffff\2\6\6\uffff\1\6\1\uffff\1\6\1\uffff\4\6\6\uffff\1\6\5\uffff\1\6",
            "\2\6\5\uffff\3\6\2\12\2\6\1\12\3\uffff\2\6\6\uffff\1\6\1\uffff\1\6\1\uffff\4\6\6\uffff\1\6\5\uffff\1\6",
            "\2\6\5\uffff\3\6\2\12\2\6\1\12\3\uffff\2\6\6\uffff\1\6\1\uffff\1\6\1\uffff\4\6\6\uffff\1\6\5\uffff\1\6",
            "",
            "\2\6\5\uffff\3\6\2\12\2\6\1\12\3\uffff\2\6\6\uffff\1\6\1\uffff\1\6\1\uffff\4\6\6\uffff\1\6\5\uffff\1\6",
            "\2\6\5\uffff\3\6\2\12\2\6\1\12\3\uffff\2\6\6\uffff\1\6\1\uffff\1\6\1\uffff\4\6\6\uffff\1\6\5\uffff\1\6",
            "\2\6\5\uffff\3\6\2\12\2\6\1\12\3\uffff\2\6\6\uffff\1\6\1\uffff\1\6\1\uffff\4\6\6\uffff\1\6\5\uffff\1\6",
            ""
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "1606:1: rule__AbstractTokenWithCardinality__Alternatives_0 : ( ( ruleAssignment ) | ( ruleAbstractTerminal ) );";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000030010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000388001A130010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000000000A000002L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000388001A130012L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000830010L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0002000010030010L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000010000002L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0001000020000000L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0004102100430030L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000080001000L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000200000010L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000800000002L});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000010000430010L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0004102000430030L});
        public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0004102000430032L});
        public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000001000000002L});
        public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000003800L});
        public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000004001000000L});
        public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000008000000000L});
        public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000200200000L});
        public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000430010L});
        public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0004100000030010L});
        public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x000000000004C000L});
        public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000020000430030L});
        public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000040800000000L});
        public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000030030L});
        public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000080010000000L});
        public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0002000000030010L});
        public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000310001430030L});
        public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000310001430032L});
        public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000400000000000L});
        public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x00000000A0000000L});
    }


}
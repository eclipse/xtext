package org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal;

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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug304681TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
@SuppressWarnings("all")
public class InternalBug304681TestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "';'", "'1'", "'2'", "'package'", "'object'", "'{'", "'}'", "'extends'", "'shortDescription'", "'longDescription'", "'serialUID'", "'before'", "'after'", "'optionalLoop'", "'mandatoryLoop'", "'Attribute'", "'Reference'", "'constraint'", "'parameters'", "'message'", "'enabled'", "'abstract'", "'cloneable'", "'*'", "'required'", "'technical'"
    };
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
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
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalBug304681TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug304681TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug304681TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug304681TestLanguage.g"; }


    	private Bug304681TestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(Bug304681TestLanguageGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleModel"
    // InternalBug304681TestLanguage.g:59:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalBug304681TestLanguage.g:60:1: ( ruleModel EOF )
            // InternalBug304681TestLanguage.g:61:1: ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleModel();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalBug304681TestLanguage.g:68:1: ruleModel : ( ( rule__Model__Alternatives ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:72:2: ( ( ( rule__Model__Alternatives ) ) )
            // InternalBug304681TestLanguage.g:73:2: ( ( rule__Model__Alternatives ) )
            {
            // InternalBug304681TestLanguage.g:73:2: ( ( rule__Model__Alternatives ) )
            // InternalBug304681TestLanguage.g:74:3: ( rule__Model__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getAlternatives()); 
            }
            // InternalBug304681TestLanguage.g:75:3: ( rule__Model__Alternatives )
            // InternalBug304681TestLanguage.g:75:4: rule__Model__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getAlternatives()); 
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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRulePackageDefinition"
    // InternalBug304681TestLanguage.g:84:1: entryRulePackageDefinition : rulePackageDefinition EOF ;
    public final void entryRulePackageDefinition() throws RecognitionException {
        try {
            // InternalBug304681TestLanguage.g:85:1: ( rulePackageDefinition EOF )
            // InternalBug304681TestLanguage.g:86:1: rulePackageDefinition EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageDefinitionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            rulePackageDefinition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageDefinitionRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePackageDefinition"


    // $ANTLR start "rulePackageDefinition"
    // InternalBug304681TestLanguage.g:93:1: rulePackageDefinition : ( ( rule__PackageDefinition__Group__0 ) ) ;
    public final void rulePackageDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:97:2: ( ( ( rule__PackageDefinition__Group__0 ) ) )
            // InternalBug304681TestLanguage.g:98:2: ( ( rule__PackageDefinition__Group__0 ) )
            {
            // InternalBug304681TestLanguage.g:98:2: ( ( rule__PackageDefinition__Group__0 ) )
            // InternalBug304681TestLanguage.g:99:3: ( rule__PackageDefinition__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageDefinitionAccess().getGroup()); 
            }
            // InternalBug304681TestLanguage.g:100:3: ( rule__PackageDefinition__Group__0 )
            // InternalBug304681TestLanguage.g:100:4: rule__PackageDefinition__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PackageDefinition__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageDefinitionAccess().getGroup()); 
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
    // $ANTLR end "rulePackageDefinition"


    // $ANTLR start "entryRuleObject"
    // InternalBug304681TestLanguage.g:109:1: entryRuleObject : ruleObject EOF ;
    public final void entryRuleObject() throws RecognitionException {
        try {
            // InternalBug304681TestLanguage.g:110:1: ( ruleObject EOF )
            // InternalBug304681TestLanguage.g:111:1: ruleObject EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleObject();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleObject"


    // $ANTLR start "ruleObject"
    // InternalBug304681TestLanguage.g:118:1: ruleObject : ( ( rule__Object__Group__0 ) ) ;
    public final void ruleObject() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:122:2: ( ( ( rule__Object__Group__0 ) ) )
            // InternalBug304681TestLanguage.g:123:2: ( ( rule__Object__Group__0 ) )
            {
            // InternalBug304681TestLanguage.g:123:2: ( ( rule__Object__Group__0 ) )
            // InternalBug304681TestLanguage.g:124:3: ( rule__Object__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getGroup()); 
            }
            // InternalBug304681TestLanguage.g:125:3: ( rule__Object__Group__0 )
            // InternalBug304681TestLanguage.g:125:4: rule__Object__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getGroup()); 
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
    // $ANTLR end "ruleObject"


    // $ANTLR start "entryRuleFeature"
    // InternalBug304681TestLanguage.g:134:1: entryRuleFeature : ruleFeature EOF ;
    public final void entryRuleFeature() throws RecognitionException {
        try {
            // InternalBug304681TestLanguage.g:135:1: ( ruleFeature EOF )
            // InternalBug304681TestLanguage.g:136:1: ruleFeature EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFeature();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFeature"


    // $ANTLR start "ruleFeature"
    // InternalBug304681TestLanguage.g:143:1: ruleFeature : ( ( rule__Feature__Alternatives ) ) ;
    public final void ruleFeature() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:147:2: ( ( ( rule__Feature__Alternatives ) ) )
            // InternalBug304681TestLanguage.g:148:2: ( ( rule__Feature__Alternatives ) )
            {
            // InternalBug304681TestLanguage.g:148:2: ( ( rule__Feature__Alternatives ) )
            // InternalBug304681TestLanguage.g:149:3: ( rule__Feature__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureAccess().getAlternatives()); 
            }
            // InternalBug304681TestLanguage.g:150:3: ( rule__Feature__Alternatives )
            // InternalBug304681TestLanguage.g:150:4: rule__Feature__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Feature__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureAccess().getAlternatives()); 
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
    // $ANTLR end "ruleFeature"


    // $ANTLR start "entryRuleAttribute"
    // InternalBug304681TestLanguage.g:159:1: entryRuleAttribute : ruleAttribute EOF ;
    public final void entryRuleAttribute() throws RecognitionException {
        try {
            // InternalBug304681TestLanguage.g:160:1: ( ruleAttribute EOF )
            // InternalBug304681TestLanguage.g:161:1: ruleAttribute EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAttribute();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalBug304681TestLanguage.g:168:1: ruleAttribute : ( ( rule__Attribute__Group__0 ) ) ;
    public final void ruleAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:172:2: ( ( ( rule__Attribute__Group__0 ) ) )
            // InternalBug304681TestLanguage.g:173:2: ( ( rule__Attribute__Group__0 ) )
            {
            // InternalBug304681TestLanguage.g:173:2: ( ( rule__Attribute__Group__0 ) )
            // InternalBug304681TestLanguage.g:174:3: ( rule__Attribute__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getGroup()); 
            }
            // InternalBug304681TestLanguage.g:175:3: ( rule__Attribute__Group__0 )
            // InternalBug304681TestLanguage.g:175:4: rule__Attribute__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeAccess().getGroup()); 
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
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleReference"
    // InternalBug304681TestLanguage.g:184:1: entryRuleReference : ruleReference EOF ;
    public final void entryRuleReference() throws RecognitionException {
        try {
            // InternalBug304681TestLanguage.g:185:1: ( ruleReference EOF )
            // InternalBug304681TestLanguage.g:186:1: ruleReference EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleReference"


    // $ANTLR start "ruleReference"
    // InternalBug304681TestLanguage.g:193:1: ruleReference : ( ( rule__Reference__Group__0 ) ) ;
    public final void ruleReference() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:197:2: ( ( ( rule__Reference__Group__0 ) ) )
            // InternalBug304681TestLanguage.g:198:2: ( ( rule__Reference__Group__0 ) )
            {
            // InternalBug304681TestLanguage.g:198:2: ( ( rule__Reference__Group__0 ) )
            // InternalBug304681TestLanguage.g:199:3: ( rule__Reference__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getGroup()); 
            }
            // InternalBug304681TestLanguage.g:200:3: ( rule__Reference__Group__0 )
            // InternalBug304681TestLanguage.g:200:4: rule__Reference__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getGroup()); 
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
    // $ANTLR end "ruleReference"


    // $ANTLR start "entryRulePackageDefinition2"
    // InternalBug304681TestLanguage.g:209:1: entryRulePackageDefinition2 : rulePackageDefinition2 EOF ;
    public final void entryRulePackageDefinition2() throws RecognitionException {
        try {
            // InternalBug304681TestLanguage.g:210:1: ( rulePackageDefinition2 EOF )
            // InternalBug304681TestLanguage.g:211:1: rulePackageDefinition2 EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageDefinition2Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            rulePackageDefinition2();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageDefinition2Rule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePackageDefinition2"


    // $ANTLR start "rulePackageDefinition2"
    // InternalBug304681TestLanguage.g:218:1: rulePackageDefinition2 : ( ( rule__PackageDefinition2__Group__0 ) ) ;
    public final void rulePackageDefinition2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:222:2: ( ( ( rule__PackageDefinition2__Group__0 ) ) )
            // InternalBug304681TestLanguage.g:223:2: ( ( rule__PackageDefinition2__Group__0 ) )
            {
            // InternalBug304681TestLanguage.g:223:2: ( ( rule__PackageDefinition2__Group__0 ) )
            // InternalBug304681TestLanguage.g:224:3: ( rule__PackageDefinition2__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageDefinition2Access().getGroup()); 
            }
            // InternalBug304681TestLanguage.g:225:3: ( rule__PackageDefinition2__Group__0 )
            // InternalBug304681TestLanguage.g:225:4: rule__PackageDefinition2__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PackageDefinition2__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageDefinition2Access().getGroup()); 
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
    // $ANTLR end "rulePackageDefinition2"


    // $ANTLR start "entryRuleObject2"
    // InternalBug304681TestLanguage.g:234:1: entryRuleObject2 : ruleObject2 EOF ;
    public final void entryRuleObject2() throws RecognitionException {
        try {
            // InternalBug304681TestLanguage.g:235:1: ( ruleObject2 EOF )
            // InternalBug304681TestLanguage.g:236:1: ruleObject2 EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleObject2();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Rule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleObject2"


    // $ANTLR start "ruleObject2"
    // InternalBug304681TestLanguage.g:243:1: ruleObject2 : ( ( rule__Object2__Group__0 ) ) ;
    public final void ruleObject2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:247:2: ( ( ( rule__Object2__Group__0 ) ) )
            // InternalBug304681TestLanguage.g:248:2: ( ( rule__Object2__Group__0 ) )
            {
            // InternalBug304681TestLanguage.g:248:2: ( ( rule__Object2__Group__0 ) )
            // InternalBug304681TestLanguage.g:249:3: ( rule__Object2__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getGroup()); 
            }
            // InternalBug304681TestLanguage.g:250:3: ( rule__Object2__Group__0 )
            // InternalBug304681TestLanguage.g:250:4: rule__Object2__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getGroup()); 
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
    // $ANTLR end "ruleObject2"


    // $ANTLR start "entryRuleFeature2"
    // InternalBug304681TestLanguage.g:259:1: entryRuleFeature2 : ruleFeature2 EOF ;
    public final void entryRuleFeature2() throws RecognitionException {
        try {
            // InternalBug304681TestLanguage.g:260:1: ( ruleFeature2 EOF )
            // InternalBug304681TestLanguage.g:261:1: ruleFeature2 EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeature2Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFeature2();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeature2Rule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFeature2"


    // $ANTLR start "ruleFeature2"
    // InternalBug304681TestLanguage.g:268:1: ruleFeature2 : ( ( rule__Feature2__Alternatives ) ) ;
    public final void ruleFeature2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:272:2: ( ( ( rule__Feature2__Alternatives ) ) )
            // InternalBug304681TestLanguage.g:273:2: ( ( rule__Feature2__Alternatives ) )
            {
            // InternalBug304681TestLanguage.g:273:2: ( ( rule__Feature2__Alternatives ) )
            // InternalBug304681TestLanguage.g:274:3: ( rule__Feature2__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeature2Access().getAlternatives()); 
            }
            // InternalBug304681TestLanguage.g:275:3: ( rule__Feature2__Alternatives )
            // InternalBug304681TestLanguage.g:275:4: rule__Feature2__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Feature2__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeature2Access().getAlternatives()); 
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
    // $ANTLR end "ruleFeature2"


    // $ANTLR start "entryRuleAttribute2"
    // InternalBug304681TestLanguage.g:284:1: entryRuleAttribute2 : ruleAttribute2 EOF ;
    public final void entryRuleAttribute2() throws RecognitionException {
        try {
            // InternalBug304681TestLanguage.g:285:1: ( ruleAttribute2 EOF )
            // InternalBug304681TestLanguage.g:286:1: ruleAttribute2 EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAttribute2();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Rule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAttribute2"


    // $ANTLR start "ruleAttribute2"
    // InternalBug304681TestLanguage.g:293:1: ruleAttribute2 : ( ( rule__Attribute2__Group__0 ) ) ;
    public final void ruleAttribute2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:297:2: ( ( ( rule__Attribute2__Group__0 ) ) )
            // InternalBug304681TestLanguage.g:298:2: ( ( rule__Attribute2__Group__0 ) )
            {
            // InternalBug304681TestLanguage.g:298:2: ( ( rule__Attribute2__Group__0 ) )
            // InternalBug304681TestLanguage.g:299:3: ( rule__Attribute2__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getGroup()); 
            }
            // InternalBug304681TestLanguage.g:300:3: ( rule__Attribute2__Group__0 )
            // InternalBug304681TestLanguage.g:300:4: rule__Attribute2__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getGroup()); 
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
    // $ANTLR end "ruleAttribute2"


    // $ANTLR start "entryRuleReference2"
    // InternalBug304681TestLanguage.g:309:1: entryRuleReference2 : ruleReference2 EOF ;
    public final void entryRuleReference2() throws RecognitionException {
        try {
            // InternalBug304681TestLanguage.g:310:1: ( ruleReference2 EOF )
            // InternalBug304681TestLanguage.g:311:1: ruleReference2 EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleReference2();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Rule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleReference2"


    // $ANTLR start "ruleReference2"
    // InternalBug304681TestLanguage.g:318:1: ruleReference2 : ( ( rule__Reference2__Group__0 ) ) ;
    public final void ruleReference2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:322:2: ( ( ( rule__Reference2__Group__0 ) ) )
            // InternalBug304681TestLanguage.g:323:2: ( ( rule__Reference2__Group__0 ) )
            {
            // InternalBug304681TestLanguage.g:323:2: ( ( rule__Reference2__Group__0 ) )
            // InternalBug304681TestLanguage.g:324:3: ( rule__Reference2__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getGroup()); 
            }
            // InternalBug304681TestLanguage.g:325:3: ( rule__Reference2__Group__0 )
            // InternalBug304681TestLanguage.g:325:4: rule__Reference2__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getGroup()); 
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
    // $ANTLR end "ruleReference2"


    // $ANTLR start "entryRuleConstraintDefinition"
    // InternalBug304681TestLanguage.g:334:1: entryRuleConstraintDefinition : ruleConstraintDefinition EOF ;
    public final void entryRuleConstraintDefinition() throws RecognitionException {
        try {
            // InternalBug304681TestLanguage.g:335:1: ( ruleConstraintDefinition EOF )
            // InternalBug304681TestLanguage.g:336:1: ruleConstraintDefinition EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintDefinitionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleConstraintDefinition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintDefinitionRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConstraintDefinition"


    // $ANTLR start "ruleConstraintDefinition"
    // InternalBug304681TestLanguage.g:343:1: ruleConstraintDefinition : ( ( rule__ConstraintDefinition__Group__0 ) ) ;
    public final void ruleConstraintDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:347:2: ( ( ( rule__ConstraintDefinition__Group__0 ) ) )
            // InternalBug304681TestLanguage.g:348:2: ( ( rule__ConstraintDefinition__Group__0 ) )
            {
            // InternalBug304681TestLanguage.g:348:2: ( ( rule__ConstraintDefinition__Group__0 ) )
            // InternalBug304681TestLanguage.g:349:3: ( rule__ConstraintDefinition__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintDefinitionAccess().getGroup()); 
            }
            // InternalBug304681TestLanguage.g:350:3: ( rule__ConstraintDefinition__Group__0 )
            // InternalBug304681TestLanguage.g:350:4: rule__ConstraintDefinition__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConstraintDefinition__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintDefinitionAccess().getGroup()); 
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
    // $ANTLR end "ruleConstraintDefinition"


    // $ANTLR start "rule__Model__Alternatives"
    // InternalBug304681TestLanguage.g:358:1: rule__Model__Alternatives : ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) );
    public final void rule__Model__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:362:1: ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==12) ) {
                alt1=1;
            }
            else if ( (LA1_0==13) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalBug304681TestLanguage.g:363:2: ( ( rule__Model__Group_0__0 ) )
                    {
                    // InternalBug304681TestLanguage.g:363:2: ( ( rule__Model__Group_0__0 ) )
                    // InternalBug304681TestLanguage.g:364:3: ( rule__Model__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getModelAccess().getGroup_0()); 
                    }
                    // InternalBug304681TestLanguage.g:365:3: ( rule__Model__Group_0__0 )
                    // InternalBug304681TestLanguage.g:365:4: rule__Model__Group_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Model__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getModelAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBug304681TestLanguage.g:369:2: ( ( rule__Model__Group_1__0 ) )
                    {
                    // InternalBug304681TestLanguage.g:369:2: ( ( rule__Model__Group_1__0 ) )
                    // InternalBug304681TestLanguage.g:370:3: ( rule__Model__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getModelAccess().getGroup_1()); 
                    }
                    // InternalBug304681TestLanguage.g:371:3: ( rule__Model__Group_1__0 )
                    // InternalBug304681TestLanguage.g:371:4: rule__Model__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Model__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getModelAccess().getGroup_1()); 
                    }

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
    // $ANTLR end "rule__Model__Alternatives"


    // $ANTLR start "rule__Object__Alternatives_0"
    // InternalBug304681TestLanguage.g:379:1: rule__Object__Alternatives_0 : ( ( ( rule__Object__EnabledAssignment_0_0 ) ) | ( ( rule__Object__AbstractAssignment_0_1 ) ) );
    public final void rule__Object__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:383:1: ( ( ( rule__Object__EnabledAssignment_0_0 ) ) | ( ( rule__Object__AbstractAssignment_0_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==31) ) {
                alt2=1;
            }
            else if ( (LA2_0==32) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalBug304681TestLanguage.g:384:2: ( ( rule__Object__EnabledAssignment_0_0 ) )
                    {
                    // InternalBug304681TestLanguage.g:384:2: ( ( rule__Object__EnabledAssignment_0_0 ) )
                    // InternalBug304681TestLanguage.g:385:3: ( rule__Object__EnabledAssignment_0_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectAccess().getEnabledAssignment_0_0()); 
                    }
                    // InternalBug304681TestLanguage.g:386:3: ( rule__Object__EnabledAssignment_0_0 )
                    // InternalBug304681TestLanguage.g:386:4: rule__Object__EnabledAssignment_0_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object__EnabledAssignment_0_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectAccess().getEnabledAssignment_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBug304681TestLanguage.g:390:2: ( ( rule__Object__AbstractAssignment_0_1 ) )
                    {
                    // InternalBug304681TestLanguage.g:390:2: ( ( rule__Object__AbstractAssignment_0_1 ) )
                    // InternalBug304681TestLanguage.g:391:3: ( rule__Object__AbstractAssignment_0_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectAccess().getAbstractAssignment_0_1()); 
                    }
                    // InternalBug304681TestLanguage.g:392:3: ( rule__Object__AbstractAssignment_0_1 )
                    // InternalBug304681TestLanguage.g:392:4: rule__Object__AbstractAssignment_0_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object__AbstractAssignment_0_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectAccess().getAbstractAssignment_0_1()); 
                    }

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
    // $ANTLR end "rule__Object__Alternatives_0"


    // $ANTLR start "rule__Feature__Alternatives"
    // InternalBug304681TestLanguage.g:400:1: rule__Feature__Alternatives : ( ( ruleAttribute ) | ( ruleReference ) );
    public final void rule__Feature__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:404:1: ( ( ruleAttribute ) | ( ruleReference ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==26) ) {
                alt3=1;
            }
            else if ( (LA3_0==27) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalBug304681TestLanguage.g:405:2: ( ruleAttribute )
                    {
                    // InternalBug304681TestLanguage.g:405:2: ( ruleAttribute )
                    // InternalBug304681TestLanguage.g:406:3: ruleAttribute
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFeatureAccess().getAttributeParserRuleCall_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAttribute();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFeatureAccess().getAttributeParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBug304681TestLanguage.g:411:2: ( ruleReference )
                    {
                    // InternalBug304681TestLanguage.g:411:2: ( ruleReference )
                    // InternalBug304681TestLanguage.g:412:3: ruleReference
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFeatureAccess().getReferenceParserRuleCall_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleReference();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFeatureAccess().getReferenceParserRuleCall_1()); 
                    }

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
    // $ANTLR end "rule__Feature__Alternatives"


    // $ANTLR start "rule__Reference__Alternatives_4"
    // InternalBug304681TestLanguage.g:421:1: rule__Reference__Alternatives_4 : ( ( ( rule__Reference__Group_4_0__0 ) ) | ( ';' ) );
    public final void rule__Reference__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:425:1: ( ( ( rule__Reference__Group_4_0__0 ) ) | ( ';' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            else if ( (LA4_0==11) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalBug304681TestLanguage.g:426:2: ( ( rule__Reference__Group_4_0__0 ) )
                    {
                    // InternalBug304681TestLanguage.g:426:2: ( ( rule__Reference__Group_4_0__0 ) )
                    // InternalBug304681TestLanguage.g:427:3: ( rule__Reference__Group_4_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReferenceAccess().getGroup_4_0()); 
                    }
                    // InternalBug304681TestLanguage.g:428:3: ( rule__Reference__Group_4_0__0 )
                    // InternalBug304681TestLanguage.g:428:4: rule__Reference__Group_4_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Reference__Group_4_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getReferenceAccess().getGroup_4_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBug304681TestLanguage.g:432:2: ( ';' )
                    {
                    // InternalBug304681TestLanguage.g:432:2: ( ';' )
                    // InternalBug304681TestLanguage.g:433:3: ';'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReferenceAccess().getSemicolonKeyword_4_1()); 
                    }
                    match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getReferenceAccess().getSemicolonKeyword_4_1()); 
                    }

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
    // $ANTLR end "rule__Reference__Alternatives_4"


    // $ANTLR start "rule__Object2__Alternatives_0"
    // InternalBug304681TestLanguage.g:442:1: rule__Object2__Alternatives_0 : ( ( ( rule__Object2__EnabledAssignment_0_0 ) ) | ( ( rule__Object2__AbstractAssignment_0_1 ) ) );
    public final void rule__Object2__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:446:1: ( ( ( rule__Object2__EnabledAssignment_0_0 ) ) | ( ( rule__Object2__AbstractAssignment_0_1 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==31) ) {
                alt5=1;
            }
            else if ( (LA5_0==32) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalBug304681TestLanguage.g:447:2: ( ( rule__Object2__EnabledAssignment_0_0 ) )
                    {
                    // InternalBug304681TestLanguage.g:447:2: ( ( rule__Object2__EnabledAssignment_0_0 ) )
                    // InternalBug304681TestLanguage.g:448:3: ( rule__Object2__EnabledAssignment_0_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObject2Access().getEnabledAssignment_0_0()); 
                    }
                    // InternalBug304681TestLanguage.g:449:3: ( rule__Object2__EnabledAssignment_0_0 )
                    // InternalBug304681TestLanguage.g:449:4: rule__Object2__EnabledAssignment_0_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object2__EnabledAssignment_0_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObject2Access().getEnabledAssignment_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBug304681TestLanguage.g:453:2: ( ( rule__Object2__AbstractAssignment_0_1 ) )
                    {
                    // InternalBug304681TestLanguage.g:453:2: ( ( rule__Object2__AbstractAssignment_0_1 ) )
                    // InternalBug304681TestLanguage.g:454:3: ( rule__Object2__AbstractAssignment_0_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObject2Access().getAbstractAssignment_0_1()); 
                    }
                    // InternalBug304681TestLanguage.g:455:3: ( rule__Object2__AbstractAssignment_0_1 )
                    // InternalBug304681TestLanguage.g:455:4: rule__Object2__AbstractAssignment_0_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object2__AbstractAssignment_0_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObject2Access().getAbstractAssignment_0_1()); 
                    }

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
    // $ANTLR end "rule__Object2__Alternatives_0"


    // $ANTLR start "rule__Feature2__Alternatives"
    // InternalBug304681TestLanguage.g:463:1: rule__Feature2__Alternatives : ( ( ruleAttribute2 ) | ( ruleReference2 ) );
    public final void rule__Feature2__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:467:1: ( ( ruleAttribute2 ) | ( ruleReference2 ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==26) ) {
                alt6=1;
            }
            else if ( (LA6_0==27) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalBug304681TestLanguage.g:468:2: ( ruleAttribute2 )
                    {
                    // InternalBug304681TestLanguage.g:468:2: ( ruleAttribute2 )
                    // InternalBug304681TestLanguage.g:469:3: ruleAttribute2
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFeature2Access().getAttribute2ParserRuleCall_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAttribute2();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFeature2Access().getAttribute2ParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBug304681TestLanguage.g:474:2: ( ruleReference2 )
                    {
                    // InternalBug304681TestLanguage.g:474:2: ( ruleReference2 )
                    // InternalBug304681TestLanguage.g:475:3: ruleReference2
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFeature2Access().getReference2ParserRuleCall_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleReference2();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFeature2Access().getReference2ParserRuleCall_1()); 
                    }

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
    // $ANTLR end "rule__Feature2__Alternatives"


    // $ANTLR start "rule__Attribute2__Alternatives_3"
    // InternalBug304681TestLanguage.g:484:1: rule__Attribute2__Alternatives_3 : ( ( ( rule__Attribute2__Group_3_0__0 ) ) | ( ';' ) );
    public final void rule__Attribute2__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:488:1: ( ( ( rule__Attribute2__Group_3_0__0 ) ) | ( ';' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==16) ) {
                alt7=1;
            }
            else if ( (LA7_0==11) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalBug304681TestLanguage.g:489:2: ( ( rule__Attribute2__Group_3_0__0 ) )
                    {
                    // InternalBug304681TestLanguage.g:489:2: ( ( rule__Attribute2__Group_3_0__0 ) )
                    // InternalBug304681TestLanguage.g:490:3: ( rule__Attribute2__Group_3_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAttribute2Access().getGroup_3_0()); 
                    }
                    // InternalBug304681TestLanguage.g:491:3: ( rule__Attribute2__Group_3_0__0 )
                    // InternalBug304681TestLanguage.g:491:4: rule__Attribute2__Group_3_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Attribute2__Group_3_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAttribute2Access().getGroup_3_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBug304681TestLanguage.g:495:2: ( ';' )
                    {
                    // InternalBug304681TestLanguage.g:495:2: ( ';' )
                    // InternalBug304681TestLanguage.g:496:3: ';'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAttribute2Access().getSemicolonKeyword_3_1()); 
                    }
                    match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAttribute2Access().getSemicolonKeyword_3_1()); 
                    }

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
    // $ANTLR end "rule__Attribute2__Alternatives_3"


    // $ANTLR start "rule__Reference2__Alternatives_4"
    // InternalBug304681TestLanguage.g:505:1: rule__Reference2__Alternatives_4 : ( ( ( rule__Reference2__Group_4_0__0 ) ) | ( ';' ) );
    public final void rule__Reference2__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:509:1: ( ( ( rule__Reference2__Group_4_0__0 ) ) | ( ';' ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==16) ) {
                alt8=1;
            }
            else if ( (LA8_0==11) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalBug304681TestLanguage.g:510:2: ( ( rule__Reference2__Group_4_0__0 ) )
                    {
                    // InternalBug304681TestLanguage.g:510:2: ( ( rule__Reference2__Group_4_0__0 ) )
                    // InternalBug304681TestLanguage.g:511:3: ( rule__Reference2__Group_4_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReference2Access().getGroup_4_0()); 
                    }
                    // InternalBug304681TestLanguage.g:512:3: ( rule__Reference2__Group_4_0__0 )
                    // InternalBug304681TestLanguage.g:512:4: rule__Reference2__Group_4_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Reference2__Group_4_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getReference2Access().getGroup_4_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBug304681TestLanguage.g:516:2: ( ';' )
                    {
                    // InternalBug304681TestLanguage.g:516:2: ( ';' )
                    // InternalBug304681TestLanguage.g:517:3: ';'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReference2Access().getSemicolonKeyword_4_1()); 
                    }
                    match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getReference2Access().getSemicolonKeyword_4_1()); 
                    }

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
    // $ANTLR end "rule__Reference2__Alternatives_4"


    // $ANTLR start "rule__Model__Group_0__0"
    // InternalBug304681TestLanguage.g:526:1: rule__Model__Group_0__0 : rule__Model__Group_0__0__Impl rule__Model__Group_0__1 ;
    public final void rule__Model__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:530:1: ( rule__Model__Group_0__0__Impl rule__Model__Group_0__1 )
            // InternalBug304681TestLanguage.g:531:2: rule__Model__Group_0__0__Impl rule__Model__Group_0__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Model__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_0__0"


    // $ANTLR start "rule__Model__Group_0__0__Impl"
    // InternalBug304681TestLanguage.g:538:1: rule__Model__Group_0__0__Impl : ( '1' ) ;
    public final void rule__Model__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:542:1: ( ( '1' ) )
            // InternalBug304681TestLanguage.g:543:1: ( '1' )
            {
            // InternalBug304681TestLanguage.g:543:1: ( '1' )
            // InternalBug304681TestLanguage.g:544:2: '1'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getDigitOneKeyword_0_0()); 
            }
            match(input,12,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getDigitOneKeyword_0_0()); 
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
    // $ANTLR end "rule__Model__Group_0__0__Impl"


    // $ANTLR start "rule__Model__Group_0__1"
    // InternalBug304681TestLanguage.g:553:1: rule__Model__Group_0__1 : rule__Model__Group_0__1__Impl ;
    public final void rule__Model__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:557:1: ( rule__Model__Group_0__1__Impl )
            // InternalBug304681TestLanguage.g:558:2: rule__Model__Group_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_0__1"


    // $ANTLR start "rule__Model__Group_0__1__Impl"
    // InternalBug304681TestLanguage.g:564:1: rule__Model__Group_0__1__Impl : ( ( rule__Model__DefinitionAssignment_0_1 ) ) ;
    public final void rule__Model__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:568:1: ( ( ( rule__Model__DefinitionAssignment_0_1 ) ) )
            // InternalBug304681TestLanguage.g:569:1: ( ( rule__Model__DefinitionAssignment_0_1 ) )
            {
            // InternalBug304681TestLanguage.g:569:1: ( ( rule__Model__DefinitionAssignment_0_1 ) )
            // InternalBug304681TestLanguage.g:570:2: ( rule__Model__DefinitionAssignment_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getDefinitionAssignment_0_1()); 
            }
            // InternalBug304681TestLanguage.g:571:2: ( rule__Model__DefinitionAssignment_0_1 )
            // InternalBug304681TestLanguage.g:571:3: rule__Model__DefinitionAssignment_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__DefinitionAssignment_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getDefinitionAssignment_0_1()); 
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
    // $ANTLR end "rule__Model__Group_0__1__Impl"


    // $ANTLR start "rule__Model__Group_1__0"
    // InternalBug304681TestLanguage.g:580:1: rule__Model__Group_1__0 : rule__Model__Group_1__0__Impl rule__Model__Group_1__1 ;
    public final void rule__Model__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:584:1: ( rule__Model__Group_1__0__Impl rule__Model__Group_1__1 )
            // InternalBug304681TestLanguage.g:585:2: rule__Model__Group_1__0__Impl rule__Model__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Model__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1__0"


    // $ANTLR start "rule__Model__Group_1__0__Impl"
    // InternalBug304681TestLanguage.g:592:1: rule__Model__Group_1__0__Impl : ( '2' ) ;
    public final void rule__Model__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:596:1: ( ( '2' ) )
            // InternalBug304681TestLanguage.g:597:1: ( '2' )
            {
            // InternalBug304681TestLanguage.g:597:1: ( '2' )
            // InternalBug304681TestLanguage.g:598:2: '2'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getDigitTwoKeyword_1_0()); 
            }
            match(input,13,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getDigitTwoKeyword_1_0()); 
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
    // $ANTLR end "rule__Model__Group_1__0__Impl"


    // $ANTLR start "rule__Model__Group_1__1"
    // InternalBug304681TestLanguage.g:607:1: rule__Model__Group_1__1 : rule__Model__Group_1__1__Impl ;
    public final void rule__Model__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:611:1: ( rule__Model__Group_1__1__Impl )
            // InternalBug304681TestLanguage.g:612:2: rule__Model__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1__1"


    // $ANTLR start "rule__Model__Group_1__1__Impl"
    // InternalBug304681TestLanguage.g:618:1: rule__Model__Group_1__1__Impl : ( ( rule__Model__DefinitionAssignment_1_1 ) ) ;
    public final void rule__Model__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:622:1: ( ( ( rule__Model__DefinitionAssignment_1_1 ) ) )
            // InternalBug304681TestLanguage.g:623:1: ( ( rule__Model__DefinitionAssignment_1_1 ) )
            {
            // InternalBug304681TestLanguage.g:623:1: ( ( rule__Model__DefinitionAssignment_1_1 ) )
            // InternalBug304681TestLanguage.g:624:2: ( rule__Model__DefinitionAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getDefinitionAssignment_1_1()); 
            }
            // InternalBug304681TestLanguage.g:625:2: ( rule__Model__DefinitionAssignment_1_1 )
            // InternalBug304681TestLanguage.g:625:3: rule__Model__DefinitionAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__DefinitionAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getDefinitionAssignment_1_1()); 
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
    // $ANTLR end "rule__Model__Group_1__1__Impl"


    // $ANTLR start "rule__PackageDefinition__Group__0"
    // InternalBug304681TestLanguage.g:634:1: rule__PackageDefinition__Group__0 : rule__PackageDefinition__Group__0__Impl rule__PackageDefinition__Group__1 ;
    public final void rule__PackageDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:638:1: ( rule__PackageDefinition__Group__0__Impl rule__PackageDefinition__Group__1 )
            // InternalBug304681TestLanguage.g:639:2: rule__PackageDefinition__Group__0__Impl rule__PackageDefinition__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__PackageDefinition__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PackageDefinition__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition__Group__0"


    // $ANTLR start "rule__PackageDefinition__Group__0__Impl"
    // InternalBug304681TestLanguage.g:646:1: rule__PackageDefinition__Group__0__Impl : ( () ) ;
    public final void rule__PackageDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:650:1: ( ( () ) )
            // InternalBug304681TestLanguage.g:651:1: ( () )
            {
            // InternalBug304681TestLanguage.g:651:1: ( () )
            // InternalBug304681TestLanguage.g:652:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageDefinitionAccess().getPackageDefinitionAction_0()); 
            }
            // InternalBug304681TestLanguage.g:653:2: ()
            // InternalBug304681TestLanguage.g:653:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageDefinitionAccess().getPackageDefinitionAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition__Group__0__Impl"


    // $ANTLR start "rule__PackageDefinition__Group__1"
    // InternalBug304681TestLanguage.g:661:1: rule__PackageDefinition__Group__1 : rule__PackageDefinition__Group__1__Impl rule__PackageDefinition__Group__2 ;
    public final void rule__PackageDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:665:1: ( rule__PackageDefinition__Group__1__Impl rule__PackageDefinition__Group__2 )
            // InternalBug304681TestLanguage.g:666:2: rule__PackageDefinition__Group__1__Impl rule__PackageDefinition__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__PackageDefinition__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PackageDefinition__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition__Group__1"


    // $ANTLR start "rule__PackageDefinition__Group__1__Impl"
    // InternalBug304681TestLanguage.g:673:1: rule__PackageDefinition__Group__1__Impl : ( 'package' ) ;
    public final void rule__PackageDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:677:1: ( ( 'package' ) )
            // InternalBug304681TestLanguage.g:678:1: ( 'package' )
            {
            // InternalBug304681TestLanguage.g:678:1: ( 'package' )
            // InternalBug304681TestLanguage.g:679:2: 'package'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageDefinitionAccess().getPackageKeyword_1()); 
            }
            match(input,14,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageDefinitionAccess().getPackageKeyword_1()); 
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
    // $ANTLR end "rule__PackageDefinition__Group__1__Impl"


    // $ANTLR start "rule__PackageDefinition__Group__2"
    // InternalBug304681TestLanguage.g:688:1: rule__PackageDefinition__Group__2 : rule__PackageDefinition__Group__2__Impl rule__PackageDefinition__Group__3 ;
    public final void rule__PackageDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:692:1: ( rule__PackageDefinition__Group__2__Impl rule__PackageDefinition__Group__3 )
            // InternalBug304681TestLanguage.g:693:2: rule__PackageDefinition__Group__2__Impl rule__PackageDefinition__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__PackageDefinition__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PackageDefinition__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition__Group__2"


    // $ANTLR start "rule__PackageDefinition__Group__2__Impl"
    // InternalBug304681TestLanguage.g:700:1: rule__PackageDefinition__Group__2__Impl : ( ( rule__PackageDefinition__NamespaceAssignment_2 ) ) ;
    public final void rule__PackageDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:704:1: ( ( ( rule__PackageDefinition__NamespaceAssignment_2 ) ) )
            // InternalBug304681TestLanguage.g:705:1: ( ( rule__PackageDefinition__NamespaceAssignment_2 ) )
            {
            // InternalBug304681TestLanguage.g:705:1: ( ( rule__PackageDefinition__NamespaceAssignment_2 ) )
            // InternalBug304681TestLanguage.g:706:2: ( rule__PackageDefinition__NamespaceAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageDefinitionAccess().getNamespaceAssignment_2()); 
            }
            // InternalBug304681TestLanguage.g:707:2: ( rule__PackageDefinition__NamespaceAssignment_2 )
            // InternalBug304681TestLanguage.g:707:3: rule__PackageDefinition__NamespaceAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PackageDefinition__NamespaceAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageDefinitionAccess().getNamespaceAssignment_2()); 
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
    // $ANTLR end "rule__PackageDefinition__Group__2__Impl"


    // $ANTLR start "rule__PackageDefinition__Group__3"
    // InternalBug304681TestLanguage.g:715:1: rule__PackageDefinition__Group__3 : rule__PackageDefinition__Group__3__Impl rule__PackageDefinition__Group__4 ;
    public final void rule__PackageDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:719:1: ( rule__PackageDefinition__Group__3__Impl rule__PackageDefinition__Group__4 )
            // InternalBug304681TestLanguage.g:720:2: rule__PackageDefinition__Group__3__Impl rule__PackageDefinition__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__PackageDefinition__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PackageDefinition__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition__Group__3"


    // $ANTLR start "rule__PackageDefinition__Group__3__Impl"
    // InternalBug304681TestLanguage.g:727:1: rule__PackageDefinition__Group__3__Impl : ( ';' ) ;
    public final void rule__PackageDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:731:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:732:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:732:1: ( ';' )
            // InternalBug304681TestLanguage.g:733:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageDefinitionAccess().getSemicolonKeyword_3()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageDefinitionAccess().getSemicolonKeyword_3()); 
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
    // $ANTLR end "rule__PackageDefinition__Group__3__Impl"


    // $ANTLR start "rule__PackageDefinition__Group__4"
    // InternalBug304681TestLanguage.g:742:1: rule__PackageDefinition__Group__4 : rule__PackageDefinition__Group__4__Impl ;
    public final void rule__PackageDefinition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:746:1: ( rule__PackageDefinition__Group__4__Impl )
            // InternalBug304681TestLanguage.g:747:2: rule__PackageDefinition__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PackageDefinition__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition__Group__4"


    // $ANTLR start "rule__PackageDefinition__Group__4__Impl"
    // InternalBug304681TestLanguage.g:753:1: rule__PackageDefinition__Group__4__Impl : ( ( rule__PackageDefinition__ContentsAssignment_4 )* ) ;
    public final void rule__PackageDefinition__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:757:1: ( ( ( rule__PackageDefinition__ContentsAssignment_4 )* ) )
            // InternalBug304681TestLanguage.g:758:1: ( ( rule__PackageDefinition__ContentsAssignment_4 )* )
            {
            // InternalBug304681TestLanguage.g:758:1: ( ( rule__PackageDefinition__ContentsAssignment_4 )* )
            // InternalBug304681TestLanguage.g:759:2: ( rule__PackageDefinition__ContentsAssignment_4 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageDefinitionAccess().getContentsAssignment_4()); 
            }
            // InternalBug304681TestLanguage.g:760:2: ( rule__PackageDefinition__ContentsAssignment_4 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==15||(LA9_0>=31 && LA9_0<=32)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalBug304681TestLanguage.g:760:3: rule__PackageDefinition__ContentsAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    rule__PackageDefinition__ContentsAssignment_4();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageDefinitionAccess().getContentsAssignment_4()); 
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
    // $ANTLR end "rule__PackageDefinition__Group__4__Impl"


    // $ANTLR start "rule__Object__Group__0"
    // InternalBug304681TestLanguage.g:769:1: rule__Object__Group__0 : rule__Object__Group__0__Impl rule__Object__Group__1 ;
    public final void rule__Object__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:773:1: ( rule__Object__Group__0__Impl rule__Object__Group__1 )
            // InternalBug304681TestLanguage.g:774:2: rule__Object__Group__0__Impl rule__Object__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Object__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group__0"


    // $ANTLR start "rule__Object__Group__0__Impl"
    // InternalBug304681TestLanguage.g:781:1: rule__Object__Group__0__Impl : ( ( rule__Object__Alternatives_0 )? ) ;
    public final void rule__Object__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:785:1: ( ( ( rule__Object__Alternatives_0 )? ) )
            // InternalBug304681TestLanguage.g:786:1: ( ( rule__Object__Alternatives_0 )? )
            {
            // InternalBug304681TestLanguage.g:786:1: ( ( rule__Object__Alternatives_0 )? )
            // InternalBug304681TestLanguage.g:787:2: ( rule__Object__Alternatives_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getAlternatives_0()); 
            }
            // InternalBug304681TestLanguage.g:788:2: ( rule__Object__Alternatives_0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=31 && LA10_0<=32)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalBug304681TestLanguage.g:788:3: rule__Object__Alternatives_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object__Alternatives_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getAlternatives_0()); 
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
    // $ANTLR end "rule__Object__Group__0__Impl"


    // $ANTLR start "rule__Object__Group__1"
    // InternalBug304681TestLanguage.g:796:1: rule__Object__Group__1 : rule__Object__Group__1__Impl rule__Object__Group__2 ;
    public final void rule__Object__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:800:1: ( rule__Object__Group__1__Impl rule__Object__Group__2 )
            // InternalBug304681TestLanguage.g:801:2: rule__Object__Group__1__Impl rule__Object__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Object__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group__1"


    // $ANTLR start "rule__Object__Group__1__Impl"
    // InternalBug304681TestLanguage.g:808:1: rule__Object__Group__1__Impl : ( 'object' ) ;
    public final void rule__Object__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:812:1: ( ( 'object' ) )
            // InternalBug304681TestLanguage.g:813:1: ( 'object' )
            {
            // InternalBug304681TestLanguage.g:813:1: ( 'object' )
            // InternalBug304681TestLanguage.g:814:2: 'object'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getObjectKeyword_1()); 
            }
            match(input,15,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getObjectKeyword_1()); 
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
    // $ANTLR end "rule__Object__Group__1__Impl"


    // $ANTLR start "rule__Object__Group__2"
    // InternalBug304681TestLanguage.g:823:1: rule__Object__Group__2 : rule__Object__Group__2__Impl rule__Object__Group__3 ;
    public final void rule__Object__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:827:1: ( rule__Object__Group__2__Impl rule__Object__Group__3 )
            // InternalBug304681TestLanguage.g:828:2: rule__Object__Group__2__Impl rule__Object__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Object__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group__2"


    // $ANTLR start "rule__Object__Group__2__Impl"
    // InternalBug304681TestLanguage.g:835:1: rule__Object__Group__2__Impl : ( ( rule__Object__NameAssignment_2 ) ) ;
    public final void rule__Object__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:839:1: ( ( ( rule__Object__NameAssignment_2 ) ) )
            // InternalBug304681TestLanguage.g:840:1: ( ( rule__Object__NameAssignment_2 ) )
            {
            // InternalBug304681TestLanguage.g:840:1: ( ( rule__Object__NameAssignment_2 ) )
            // InternalBug304681TestLanguage.g:841:2: ( rule__Object__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getNameAssignment_2()); 
            }
            // InternalBug304681TestLanguage.g:842:2: ( rule__Object__NameAssignment_2 )
            // InternalBug304681TestLanguage.g:842:3: rule__Object__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getNameAssignment_2()); 
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
    // $ANTLR end "rule__Object__Group__2__Impl"


    // $ANTLR start "rule__Object__Group__3"
    // InternalBug304681TestLanguage.g:850:1: rule__Object__Group__3 : rule__Object__Group__3__Impl rule__Object__Group__4 ;
    public final void rule__Object__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:854:1: ( rule__Object__Group__3__Impl rule__Object__Group__4 )
            // InternalBug304681TestLanguage.g:855:2: rule__Object__Group__3__Impl rule__Object__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Object__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group__3"


    // $ANTLR start "rule__Object__Group__3__Impl"
    // InternalBug304681TestLanguage.g:862:1: rule__Object__Group__3__Impl : ( ( rule__Object__Group_3__0 )? ) ;
    public final void rule__Object__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:866:1: ( ( ( rule__Object__Group_3__0 )? ) )
            // InternalBug304681TestLanguage.g:867:1: ( ( rule__Object__Group_3__0 )? )
            {
            // InternalBug304681TestLanguage.g:867:1: ( ( rule__Object__Group_3__0 )? )
            // InternalBug304681TestLanguage.g:868:2: ( rule__Object__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getGroup_3()); 
            }
            // InternalBug304681TestLanguage.g:869:2: ( rule__Object__Group_3__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==18) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalBug304681TestLanguage.g:869:3: rule__Object__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getGroup_3()); 
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
    // $ANTLR end "rule__Object__Group__3__Impl"


    // $ANTLR start "rule__Object__Group__4"
    // InternalBug304681TestLanguage.g:877:1: rule__Object__Group__4 : rule__Object__Group__4__Impl rule__Object__Group__5 ;
    public final void rule__Object__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:881:1: ( rule__Object__Group__4__Impl rule__Object__Group__5 )
            // InternalBug304681TestLanguage.g:882:2: rule__Object__Group__4__Impl rule__Object__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__Object__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group__4"


    // $ANTLR start "rule__Object__Group__4__Impl"
    // InternalBug304681TestLanguage.g:889:1: rule__Object__Group__4__Impl : ( '{' ) ;
    public final void rule__Object__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:893:1: ( ( '{' ) )
            // InternalBug304681TestLanguage.g:894:1: ( '{' )
            {
            // InternalBug304681TestLanguage.g:894:1: ( '{' )
            // InternalBug304681TestLanguage.g:895:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getLeftCurlyBracketKeyword_4()); 
            }
            match(input,16,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getLeftCurlyBracketKeyword_4()); 
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
    // $ANTLR end "rule__Object__Group__4__Impl"


    // $ANTLR start "rule__Object__Group__5"
    // InternalBug304681TestLanguage.g:904:1: rule__Object__Group__5 : rule__Object__Group__5__Impl rule__Object__Group__6 ;
    public final void rule__Object__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:908:1: ( rule__Object__Group__5__Impl rule__Object__Group__6 )
            // InternalBug304681TestLanguage.g:909:2: rule__Object__Group__5__Impl rule__Object__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Object__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group__5"


    // $ANTLR start "rule__Object__Group__5__Impl"
    // InternalBug304681TestLanguage.g:916:1: rule__Object__Group__5__Impl : ( ( rule__Object__UnorderedGroup_5 ) ) ;
    public final void rule__Object__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:920:1: ( ( ( rule__Object__UnorderedGroup_5 ) ) )
            // InternalBug304681TestLanguage.g:921:1: ( ( rule__Object__UnorderedGroup_5 ) )
            {
            // InternalBug304681TestLanguage.g:921:1: ( ( rule__Object__UnorderedGroup_5 ) )
            // InternalBug304681TestLanguage.g:922:2: ( rule__Object__UnorderedGroup_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getUnorderedGroup_5()); 
            }
            // InternalBug304681TestLanguage.g:923:2: ( rule__Object__UnorderedGroup_5 )
            // InternalBug304681TestLanguage.g:923:3: rule__Object__UnorderedGroup_5
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__UnorderedGroup_5();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getUnorderedGroup_5()); 
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
    // $ANTLR end "rule__Object__Group__5__Impl"


    // $ANTLR start "rule__Object__Group__6"
    // InternalBug304681TestLanguage.g:931:1: rule__Object__Group__6 : rule__Object__Group__6__Impl ;
    public final void rule__Object__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:935:1: ( rule__Object__Group__6__Impl )
            // InternalBug304681TestLanguage.g:936:2: rule__Object__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group__6"


    // $ANTLR start "rule__Object__Group__6__Impl"
    // InternalBug304681TestLanguage.g:942:1: rule__Object__Group__6__Impl : ( '}' ) ;
    public final void rule__Object__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:946:1: ( ( '}' ) )
            // InternalBug304681TestLanguage.g:947:1: ( '}' )
            {
            // InternalBug304681TestLanguage.g:947:1: ( '}' )
            // InternalBug304681TestLanguage.g:948:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getRightCurlyBracketKeyword_6()); 
            }
            match(input,17,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getRightCurlyBracketKeyword_6()); 
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
    // $ANTLR end "rule__Object__Group__6__Impl"


    // $ANTLR start "rule__Object__Group_3__0"
    // InternalBug304681TestLanguage.g:958:1: rule__Object__Group_3__0 : rule__Object__Group_3__0__Impl rule__Object__Group_3__1 ;
    public final void rule__Object__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:962:1: ( rule__Object__Group_3__0__Impl rule__Object__Group_3__1 )
            // InternalBug304681TestLanguage.g:963:2: rule__Object__Group_3__0__Impl rule__Object__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Object__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_3__0"


    // $ANTLR start "rule__Object__Group_3__0__Impl"
    // InternalBug304681TestLanguage.g:970:1: rule__Object__Group_3__0__Impl : ( 'extends' ) ;
    public final void rule__Object__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:974:1: ( ( 'extends' ) )
            // InternalBug304681TestLanguage.g:975:1: ( 'extends' )
            {
            // InternalBug304681TestLanguage.g:975:1: ( 'extends' )
            // InternalBug304681TestLanguage.g:976:2: 'extends'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getExtendsKeyword_3_0()); 
            }
            match(input,18,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getExtendsKeyword_3_0()); 
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
    // $ANTLR end "rule__Object__Group_3__0__Impl"


    // $ANTLR start "rule__Object__Group_3__1"
    // InternalBug304681TestLanguage.g:985:1: rule__Object__Group_3__1 : rule__Object__Group_3__1__Impl ;
    public final void rule__Object__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:989:1: ( rule__Object__Group_3__1__Impl )
            // InternalBug304681TestLanguage.g:990:2: rule__Object__Group_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_3__1"


    // $ANTLR start "rule__Object__Group_3__1__Impl"
    // InternalBug304681TestLanguage.g:996:1: rule__Object__Group_3__1__Impl : ( ( rule__Object__ParentAssignment_3_1 ) ) ;
    public final void rule__Object__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1000:1: ( ( ( rule__Object__ParentAssignment_3_1 ) ) )
            // InternalBug304681TestLanguage.g:1001:1: ( ( rule__Object__ParentAssignment_3_1 ) )
            {
            // InternalBug304681TestLanguage.g:1001:1: ( ( rule__Object__ParentAssignment_3_1 ) )
            // InternalBug304681TestLanguage.g:1002:2: ( rule__Object__ParentAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getParentAssignment_3_1()); 
            }
            // InternalBug304681TestLanguage.g:1003:2: ( rule__Object__ParentAssignment_3_1 )
            // InternalBug304681TestLanguage.g:1003:3: rule__Object__ParentAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__ParentAssignment_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getParentAssignment_3_1()); 
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
    // $ANTLR end "rule__Object__Group_3__1__Impl"


    // $ANTLR start "rule__Object__Group_5_0__0"
    // InternalBug304681TestLanguage.g:1012:1: rule__Object__Group_5_0__0 : rule__Object__Group_5_0__0__Impl rule__Object__Group_5_0__1 ;
    public final void rule__Object__Group_5_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1016:1: ( rule__Object__Group_5_0__0__Impl rule__Object__Group_5_0__1 )
            // InternalBug304681TestLanguage.g:1017:2: rule__Object__Group_5_0__0__Impl rule__Object__Group_5_0__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__Object__Group_5_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_5_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_0__0"


    // $ANTLR start "rule__Object__Group_5_0__0__Impl"
    // InternalBug304681TestLanguage.g:1024:1: rule__Object__Group_5_0__0__Impl : ( 'shortDescription' ) ;
    public final void rule__Object__Group_5_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1028:1: ( ( 'shortDescription' ) )
            // InternalBug304681TestLanguage.g:1029:1: ( 'shortDescription' )
            {
            // InternalBug304681TestLanguage.g:1029:1: ( 'shortDescription' )
            // InternalBug304681TestLanguage.g:1030:2: 'shortDescription'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getShortDescriptionKeyword_5_0_0()); 
            }
            match(input,19,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getShortDescriptionKeyword_5_0_0()); 
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
    // $ANTLR end "rule__Object__Group_5_0__0__Impl"


    // $ANTLR start "rule__Object__Group_5_0__1"
    // InternalBug304681TestLanguage.g:1039:1: rule__Object__Group_5_0__1 : rule__Object__Group_5_0__1__Impl rule__Object__Group_5_0__2 ;
    public final void rule__Object__Group_5_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1043:1: ( rule__Object__Group_5_0__1__Impl rule__Object__Group_5_0__2 )
            // InternalBug304681TestLanguage.g:1044:2: rule__Object__Group_5_0__1__Impl rule__Object__Group_5_0__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Object__Group_5_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_5_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_0__1"


    // $ANTLR start "rule__Object__Group_5_0__1__Impl"
    // InternalBug304681TestLanguage.g:1051:1: rule__Object__Group_5_0__1__Impl : ( ( rule__Object__ShortDescriptionAssignment_5_0_1 ) ) ;
    public final void rule__Object__Group_5_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1055:1: ( ( ( rule__Object__ShortDescriptionAssignment_5_0_1 ) ) )
            // InternalBug304681TestLanguage.g:1056:1: ( ( rule__Object__ShortDescriptionAssignment_5_0_1 ) )
            {
            // InternalBug304681TestLanguage.g:1056:1: ( ( rule__Object__ShortDescriptionAssignment_5_0_1 ) )
            // InternalBug304681TestLanguage.g:1057:2: ( rule__Object__ShortDescriptionAssignment_5_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getShortDescriptionAssignment_5_0_1()); 
            }
            // InternalBug304681TestLanguage.g:1058:2: ( rule__Object__ShortDescriptionAssignment_5_0_1 )
            // InternalBug304681TestLanguage.g:1058:3: rule__Object__ShortDescriptionAssignment_5_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__ShortDescriptionAssignment_5_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getShortDescriptionAssignment_5_0_1()); 
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
    // $ANTLR end "rule__Object__Group_5_0__1__Impl"


    // $ANTLR start "rule__Object__Group_5_0__2"
    // InternalBug304681TestLanguage.g:1066:1: rule__Object__Group_5_0__2 : rule__Object__Group_5_0__2__Impl ;
    public final void rule__Object__Group_5_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1070:1: ( rule__Object__Group_5_0__2__Impl )
            // InternalBug304681TestLanguage.g:1071:2: rule__Object__Group_5_0__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_5_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_0__2"


    // $ANTLR start "rule__Object__Group_5_0__2__Impl"
    // InternalBug304681TestLanguage.g:1077:1: rule__Object__Group_5_0__2__Impl : ( ';' ) ;
    public final void rule__Object__Group_5_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1081:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:1082:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:1082:1: ( ';' )
            // InternalBug304681TestLanguage.g:1083:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getSemicolonKeyword_5_0_2()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getSemicolonKeyword_5_0_2()); 
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
    // $ANTLR end "rule__Object__Group_5_0__2__Impl"


    // $ANTLR start "rule__Object__Group_5_1__0"
    // InternalBug304681TestLanguage.g:1093:1: rule__Object__Group_5_1__0 : rule__Object__Group_5_1__0__Impl rule__Object__Group_5_1__1 ;
    public final void rule__Object__Group_5_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1097:1: ( rule__Object__Group_5_1__0__Impl rule__Object__Group_5_1__1 )
            // InternalBug304681TestLanguage.g:1098:2: rule__Object__Group_5_1__0__Impl rule__Object__Group_5_1__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__Object__Group_5_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_5_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_1__0"


    // $ANTLR start "rule__Object__Group_5_1__0__Impl"
    // InternalBug304681TestLanguage.g:1105:1: rule__Object__Group_5_1__0__Impl : ( 'longDescription' ) ;
    public final void rule__Object__Group_5_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1109:1: ( ( 'longDescription' ) )
            // InternalBug304681TestLanguage.g:1110:1: ( 'longDescription' )
            {
            // InternalBug304681TestLanguage.g:1110:1: ( 'longDescription' )
            // InternalBug304681TestLanguage.g:1111:2: 'longDescription'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getLongDescriptionKeyword_5_1_0()); 
            }
            match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getLongDescriptionKeyword_5_1_0()); 
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
    // $ANTLR end "rule__Object__Group_5_1__0__Impl"


    // $ANTLR start "rule__Object__Group_5_1__1"
    // InternalBug304681TestLanguage.g:1120:1: rule__Object__Group_5_1__1 : rule__Object__Group_5_1__1__Impl rule__Object__Group_5_1__2 ;
    public final void rule__Object__Group_5_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1124:1: ( rule__Object__Group_5_1__1__Impl rule__Object__Group_5_1__2 )
            // InternalBug304681TestLanguage.g:1125:2: rule__Object__Group_5_1__1__Impl rule__Object__Group_5_1__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Object__Group_5_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_5_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_1__1"


    // $ANTLR start "rule__Object__Group_5_1__1__Impl"
    // InternalBug304681TestLanguage.g:1132:1: rule__Object__Group_5_1__1__Impl : ( ( rule__Object__LongDescriptionAssignment_5_1_1 ) ) ;
    public final void rule__Object__Group_5_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1136:1: ( ( ( rule__Object__LongDescriptionAssignment_5_1_1 ) ) )
            // InternalBug304681TestLanguage.g:1137:1: ( ( rule__Object__LongDescriptionAssignment_5_1_1 ) )
            {
            // InternalBug304681TestLanguage.g:1137:1: ( ( rule__Object__LongDescriptionAssignment_5_1_1 ) )
            // InternalBug304681TestLanguage.g:1138:2: ( rule__Object__LongDescriptionAssignment_5_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getLongDescriptionAssignment_5_1_1()); 
            }
            // InternalBug304681TestLanguage.g:1139:2: ( rule__Object__LongDescriptionAssignment_5_1_1 )
            // InternalBug304681TestLanguage.g:1139:3: rule__Object__LongDescriptionAssignment_5_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__LongDescriptionAssignment_5_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getLongDescriptionAssignment_5_1_1()); 
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
    // $ANTLR end "rule__Object__Group_5_1__1__Impl"


    // $ANTLR start "rule__Object__Group_5_1__2"
    // InternalBug304681TestLanguage.g:1147:1: rule__Object__Group_5_1__2 : rule__Object__Group_5_1__2__Impl ;
    public final void rule__Object__Group_5_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1151:1: ( rule__Object__Group_5_1__2__Impl )
            // InternalBug304681TestLanguage.g:1152:2: rule__Object__Group_5_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_5_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_1__2"


    // $ANTLR start "rule__Object__Group_5_1__2__Impl"
    // InternalBug304681TestLanguage.g:1158:1: rule__Object__Group_5_1__2__Impl : ( ';' ) ;
    public final void rule__Object__Group_5_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1162:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:1163:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:1163:1: ( ';' )
            // InternalBug304681TestLanguage.g:1164:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getSemicolonKeyword_5_1_2()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getSemicolonKeyword_5_1_2()); 
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
    // $ANTLR end "rule__Object__Group_5_1__2__Impl"


    // $ANTLR start "rule__Object__Group_5_2__0"
    // InternalBug304681TestLanguage.g:1174:1: rule__Object__Group_5_2__0 : rule__Object__Group_5_2__0__Impl rule__Object__Group_5_2__1 ;
    public final void rule__Object__Group_5_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1178:1: ( rule__Object__Group_5_2__0__Impl rule__Object__Group_5_2__1 )
            // InternalBug304681TestLanguage.g:1179:2: rule__Object__Group_5_2__0__Impl rule__Object__Group_5_2__1
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__Object__Group_5_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_5_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_2__0"


    // $ANTLR start "rule__Object__Group_5_2__0__Impl"
    // InternalBug304681TestLanguage.g:1186:1: rule__Object__Group_5_2__0__Impl : ( 'serialUID' ) ;
    public final void rule__Object__Group_5_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1190:1: ( ( 'serialUID' ) )
            // InternalBug304681TestLanguage.g:1191:1: ( 'serialUID' )
            {
            // InternalBug304681TestLanguage.g:1191:1: ( 'serialUID' )
            // InternalBug304681TestLanguage.g:1192:2: 'serialUID'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getSerialUIDKeyword_5_2_0()); 
            }
            match(input,21,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getSerialUIDKeyword_5_2_0()); 
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
    // $ANTLR end "rule__Object__Group_5_2__0__Impl"


    // $ANTLR start "rule__Object__Group_5_2__1"
    // InternalBug304681TestLanguage.g:1201:1: rule__Object__Group_5_2__1 : rule__Object__Group_5_2__1__Impl rule__Object__Group_5_2__2 ;
    public final void rule__Object__Group_5_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1205:1: ( rule__Object__Group_5_2__1__Impl rule__Object__Group_5_2__2 )
            // InternalBug304681TestLanguage.g:1206:2: rule__Object__Group_5_2__1__Impl rule__Object__Group_5_2__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Object__Group_5_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_5_2__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_2__1"


    // $ANTLR start "rule__Object__Group_5_2__1__Impl"
    // InternalBug304681TestLanguage.g:1213:1: rule__Object__Group_5_2__1__Impl : ( ( rule__Object__SerialVersionUIDAssignment_5_2_1 ) ) ;
    public final void rule__Object__Group_5_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1217:1: ( ( ( rule__Object__SerialVersionUIDAssignment_5_2_1 ) ) )
            // InternalBug304681TestLanguage.g:1218:1: ( ( rule__Object__SerialVersionUIDAssignment_5_2_1 ) )
            {
            // InternalBug304681TestLanguage.g:1218:1: ( ( rule__Object__SerialVersionUIDAssignment_5_2_1 ) )
            // InternalBug304681TestLanguage.g:1219:2: ( rule__Object__SerialVersionUIDAssignment_5_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getSerialVersionUIDAssignment_5_2_1()); 
            }
            // InternalBug304681TestLanguage.g:1220:2: ( rule__Object__SerialVersionUIDAssignment_5_2_1 )
            // InternalBug304681TestLanguage.g:1220:3: rule__Object__SerialVersionUIDAssignment_5_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__SerialVersionUIDAssignment_5_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getSerialVersionUIDAssignment_5_2_1()); 
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
    // $ANTLR end "rule__Object__Group_5_2__1__Impl"


    // $ANTLR start "rule__Object__Group_5_2__2"
    // InternalBug304681TestLanguage.g:1228:1: rule__Object__Group_5_2__2 : rule__Object__Group_5_2__2__Impl ;
    public final void rule__Object__Group_5_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1232:1: ( rule__Object__Group_5_2__2__Impl )
            // InternalBug304681TestLanguage.g:1233:2: rule__Object__Group_5_2__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_5_2__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_2__2"


    // $ANTLR start "rule__Object__Group_5_2__2__Impl"
    // InternalBug304681TestLanguage.g:1239:1: rule__Object__Group_5_2__2__Impl : ( ';' ) ;
    public final void rule__Object__Group_5_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1243:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:1244:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:1244:1: ( ';' )
            // InternalBug304681TestLanguage.g:1245:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getSemicolonKeyword_5_2_2()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getSemicolonKeyword_5_2_2()); 
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
    // $ANTLR end "rule__Object__Group_5_2__2__Impl"


    // $ANTLR start "rule__Object__Group_5_3__0"
    // InternalBug304681TestLanguage.g:1255:1: rule__Object__Group_5_3__0 : rule__Object__Group_5_3__0__Impl rule__Object__Group_5_3__1 ;
    public final void rule__Object__Group_5_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1259:1: ( rule__Object__Group_5_3__0__Impl rule__Object__Group_5_3__1 )
            // InternalBug304681TestLanguage.g:1260:2: rule__Object__Group_5_3__0__Impl rule__Object__Group_5_3__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Object__Group_5_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_5_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_3__0"


    // $ANTLR start "rule__Object__Group_5_3__0__Impl"
    // InternalBug304681TestLanguage.g:1267:1: rule__Object__Group_5_3__0__Impl : ( ( rule__Object__CloneableAssignment_5_3_0 ) ) ;
    public final void rule__Object__Group_5_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1271:1: ( ( ( rule__Object__CloneableAssignment_5_3_0 ) ) )
            // InternalBug304681TestLanguage.g:1272:1: ( ( rule__Object__CloneableAssignment_5_3_0 ) )
            {
            // InternalBug304681TestLanguage.g:1272:1: ( ( rule__Object__CloneableAssignment_5_3_0 ) )
            // InternalBug304681TestLanguage.g:1273:2: ( rule__Object__CloneableAssignment_5_3_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getCloneableAssignment_5_3_0()); 
            }
            // InternalBug304681TestLanguage.g:1274:2: ( rule__Object__CloneableAssignment_5_3_0 )
            // InternalBug304681TestLanguage.g:1274:3: rule__Object__CloneableAssignment_5_3_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__CloneableAssignment_5_3_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getCloneableAssignment_5_3_0()); 
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
    // $ANTLR end "rule__Object__Group_5_3__0__Impl"


    // $ANTLR start "rule__Object__Group_5_3__1"
    // InternalBug304681TestLanguage.g:1282:1: rule__Object__Group_5_3__1 : rule__Object__Group_5_3__1__Impl ;
    public final void rule__Object__Group_5_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1286:1: ( rule__Object__Group_5_3__1__Impl )
            // InternalBug304681TestLanguage.g:1287:2: rule__Object__Group_5_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_5_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_3__1"


    // $ANTLR start "rule__Object__Group_5_3__1__Impl"
    // InternalBug304681TestLanguage.g:1293:1: rule__Object__Group_5_3__1__Impl : ( ';' ) ;
    public final void rule__Object__Group_5_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1297:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:1298:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:1298:1: ( ';' )
            // InternalBug304681TestLanguage.g:1299:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getSemicolonKeyword_5_3_1()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getSemicolonKeyword_5_3_1()); 
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
    // $ANTLR end "rule__Object__Group_5_3__1__Impl"


    // $ANTLR start "rule__Object__Group_5_5__0"
    // InternalBug304681TestLanguage.g:1309:1: rule__Object__Group_5_5__0 : rule__Object__Group_5_5__0__Impl rule__Object__Group_5_5__1 ;
    public final void rule__Object__Group_5_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1313:1: ( rule__Object__Group_5_5__0__Impl rule__Object__Group_5_5__1 )
            // InternalBug304681TestLanguage.g:1314:2: rule__Object__Group_5_5__0__Impl rule__Object__Group_5_5__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__Object__Group_5_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_5_5__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_5__0"


    // $ANTLR start "rule__Object__Group_5_5__0__Impl"
    // InternalBug304681TestLanguage.g:1321:1: rule__Object__Group_5_5__0__Impl : ( 'before' ) ;
    public final void rule__Object__Group_5_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1325:1: ( ( 'before' ) )
            // InternalBug304681TestLanguage.g:1326:1: ( 'before' )
            {
            // InternalBug304681TestLanguage.g:1326:1: ( 'before' )
            // InternalBug304681TestLanguage.g:1327:2: 'before'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getBeforeKeyword_5_5_0()); 
            }
            match(input,22,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getBeforeKeyword_5_5_0()); 
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
    // $ANTLR end "rule__Object__Group_5_5__0__Impl"


    // $ANTLR start "rule__Object__Group_5_5__1"
    // InternalBug304681TestLanguage.g:1336:1: rule__Object__Group_5_5__1 : rule__Object__Group_5_5__1__Impl rule__Object__Group_5_5__2 ;
    public final void rule__Object__Group_5_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1340:1: ( rule__Object__Group_5_5__1__Impl rule__Object__Group_5_5__2 )
            // InternalBug304681TestLanguage.g:1341:2: rule__Object__Group_5_5__1__Impl rule__Object__Group_5_5__2
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__Object__Group_5_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_5_5__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_5__1"


    // $ANTLR start "rule__Object__Group_5_5__1__Impl"
    // InternalBug304681TestLanguage.g:1348:1: rule__Object__Group_5_5__1__Impl : ( ( rule__Object__FeaturesAssignment_5_5_1 )* ) ;
    public final void rule__Object__Group_5_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1352:1: ( ( ( rule__Object__FeaturesAssignment_5_5_1 )* ) )
            // InternalBug304681TestLanguage.g:1353:1: ( ( rule__Object__FeaturesAssignment_5_5_1 )* )
            {
            // InternalBug304681TestLanguage.g:1353:1: ( ( rule__Object__FeaturesAssignment_5_5_1 )* )
            // InternalBug304681TestLanguage.g:1354:2: ( rule__Object__FeaturesAssignment_5_5_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getFeaturesAssignment_5_5_1()); 
            }
            // InternalBug304681TestLanguage.g:1355:2: ( rule__Object__FeaturesAssignment_5_5_1 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=26 && LA12_0<=27)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalBug304681TestLanguage.g:1355:3: rule__Object__FeaturesAssignment_5_5_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_14);
            	    rule__Object__FeaturesAssignment_5_5_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getFeaturesAssignment_5_5_1()); 
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
    // $ANTLR end "rule__Object__Group_5_5__1__Impl"


    // $ANTLR start "rule__Object__Group_5_5__2"
    // InternalBug304681TestLanguage.g:1363:1: rule__Object__Group_5_5__2 : rule__Object__Group_5_5__2__Impl ;
    public final void rule__Object__Group_5_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1367:1: ( rule__Object__Group_5_5__2__Impl )
            // InternalBug304681TestLanguage.g:1368:2: rule__Object__Group_5_5__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_5_5__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_5__2"


    // $ANTLR start "rule__Object__Group_5_5__2__Impl"
    // InternalBug304681TestLanguage.g:1374:1: rule__Object__Group_5_5__2__Impl : ( 'after' ) ;
    public final void rule__Object__Group_5_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1378:1: ( ( 'after' ) )
            // InternalBug304681TestLanguage.g:1379:1: ( 'after' )
            {
            // InternalBug304681TestLanguage.g:1379:1: ( 'after' )
            // InternalBug304681TestLanguage.g:1380:2: 'after'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getAfterKeyword_5_5_2()); 
            }
            match(input,23,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getAfterKeyword_5_5_2()); 
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
    // $ANTLR end "rule__Object__Group_5_5__2__Impl"


    // $ANTLR start "rule__Object__Group_5_6__0"
    // InternalBug304681TestLanguage.g:1390:1: rule__Object__Group_5_6__0 : rule__Object__Group_5_6__0__Impl rule__Object__Group_5_6__1 ;
    public final void rule__Object__Group_5_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1394:1: ( rule__Object__Group_5_6__0__Impl rule__Object__Group_5_6__1 )
            // InternalBug304681TestLanguage.g:1395:2: rule__Object__Group_5_6__0__Impl rule__Object__Group_5_6__1
            {
            pushFollow(FollowSets000.FOLLOW_15);
            rule__Object__Group_5_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_5_6__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_6__0"


    // $ANTLR start "rule__Object__Group_5_6__0__Impl"
    // InternalBug304681TestLanguage.g:1402:1: rule__Object__Group_5_6__0__Impl : ( 'optionalLoop' ) ;
    public final void rule__Object__Group_5_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1406:1: ( ( 'optionalLoop' ) )
            // InternalBug304681TestLanguage.g:1407:1: ( 'optionalLoop' )
            {
            // InternalBug304681TestLanguage.g:1407:1: ( 'optionalLoop' )
            // InternalBug304681TestLanguage.g:1408:2: 'optionalLoop'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getOptionalLoopKeyword_5_6_0()); 
            }
            match(input,24,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getOptionalLoopKeyword_5_6_0()); 
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
    // $ANTLR end "rule__Object__Group_5_6__0__Impl"


    // $ANTLR start "rule__Object__Group_5_6__1"
    // InternalBug304681TestLanguage.g:1417:1: rule__Object__Group_5_6__1 : rule__Object__Group_5_6__1__Impl ;
    public final void rule__Object__Group_5_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1421:1: ( rule__Object__Group_5_6__1__Impl )
            // InternalBug304681TestLanguage.g:1422:2: rule__Object__Group_5_6__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_5_6__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_6__1"


    // $ANTLR start "rule__Object__Group_5_6__1__Impl"
    // InternalBug304681TestLanguage.g:1428:1: rule__Object__Group_5_6__1__Impl : ( ( rule__Object__FeaturesAssignment_5_6_1 )* ) ;
    public final void rule__Object__Group_5_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1432:1: ( ( ( rule__Object__FeaturesAssignment_5_6_1 )* ) )
            // InternalBug304681TestLanguage.g:1433:1: ( ( rule__Object__FeaturesAssignment_5_6_1 )* )
            {
            // InternalBug304681TestLanguage.g:1433:1: ( ( rule__Object__FeaturesAssignment_5_6_1 )* )
            // InternalBug304681TestLanguage.g:1434:2: ( rule__Object__FeaturesAssignment_5_6_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getFeaturesAssignment_5_6_1()); 
            }
            // InternalBug304681TestLanguage.g:1435:2: ( rule__Object__FeaturesAssignment_5_6_1 )*
            loop13:
            do {
                int alt13=2;
                alt13 = dfa13.predict(input);
                switch (alt13) {
            	case 1 :
            	    // InternalBug304681TestLanguage.g:1435:3: rule__Object__FeaturesAssignment_5_6_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_14);
            	    rule__Object__FeaturesAssignment_5_6_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getFeaturesAssignment_5_6_1()); 
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
    // $ANTLR end "rule__Object__Group_5_6__1__Impl"


    // $ANTLR start "rule__Object__Group_5_7__0"
    // InternalBug304681TestLanguage.g:1444:1: rule__Object__Group_5_7__0 : rule__Object__Group_5_7__0__Impl rule__Object__Group_5_7__1 ;
    public final void rule__Object__Group_5_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1448:1: ( rule__Object__Group_5_7__0__Impl rule__Object__Group_5_7__1 )
            // InternalBug304681TestLanguage.g:1449:2: rule__Object__Group_5_7__0__Impl rule__Object__Group_5_7__1
            {
            pushFollow(FollowSets000.FOLLOW_15);
            rule__Object__Group_5_7__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_5_7__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_7__0"


    // $ANTLR start "rule__Object__Group_5_7__0__Impl"
    // InternalBug304681TestLanguage.g:1456:1: rule__Object__Group_5_7__0__Impl : ( 'mandatoryLoop' ) ;
    public final void rule__Object__Group_5_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1460:1: ( ( 'mandatoryLoop' ) )
            // InternalBug304681TestLanguage.g:1461:1: ( 'mandatoryLoop' )
            {
            // InternalBug304681TestLanguage.g:1461:1: ( 'mandatoryLoop' )
            // InternalBug304681TestLanguage.g:1462:2: 'mandatoryLoop'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getMandatoryLoopKeyword_5_7_0()); 
            }
            match(input,25,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getMandatoryLoopKeyword_5_7_0()); 
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
    // $ANTLR end "rule__Object__Group_5_7__0__Impl"


    // $ANTLR start "rule__Object__Group_5_7__1"
    // InternalBug304681TestLanguage.g:1471:1: rule__Object__Group_5_7__1 : rule__Object__Group_5_7__1__Impl ;
    public final void rule__Object__Group_5_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1475:1: ( rule__Object__Group_5_7__1__Impl )
            // InternalBug304681TestLanguage.g:1476:2: rule__Object__Group_5_7__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_5_7__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_7__1"


    // $ANTLR start "rule__Object__Group_5_7__1__Impl"
    // InternalBug304681TestLanguage.g:1482:1: rule__Object__Group_5_7__1__Impl : ( ( ( rule__Object__FeaturesAssignment_5_7_1 ) ) ( ( rule__Object__FeaturesAssignment_5_7_1 )* ) ) ;
    public final void rule__Object__Group_5_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1486:1: ( ( ( ( rule__Object__FeaturesAssignment_5_7_1 ) ) ( ( rule__Object__FeaturesAssignment_5_7_1 )* ) ) )
            // InternalBug304681TestLanguage.g:1487:1: ( ( ( rule__Object__FeaturesAssignment_5_7_1 ) ) ( ( rule__Object__FeaturesAssignment_5_7_1 )* ) )
            {
            // InternalBug304681TestLanguage.g:1487:1: ( ( ( rule__Object__FeaturesAssignment_5_7_1 ) ) ( ( rule__Object__FeaturesAssignment_5_7_1 )* ) )
            // InternalBug304681TestLanguage.g:1488:2: ( ( rule__Object__FeaturesAssignment_5_7_1 ) ) ( ( rule__Object__FeaturesAssignment_5_7_1 )* )
            {
            // InternalBug304681TestLanguage.g:1488:2: ( ( rule__Object__FeaturesAssignment_5_7_1 ) )
            // InternalBug304681TestLanguage.g:1489:3: ( rule__Object__FeaturesAssignment_5_7_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getFeaturesAssignment_5_7_1()); 
            }
            // InternalBug304681TestLanguage.g:1490:3: ( rule__Object__FeaturesAssignment_5_7_1 )
            // InternalBug304681TestLanguage.g:1490:4: rule__Object__FeaturesAssignment_5_7_1
            {
            pushFollow(FollowSets000.FOLLOW_14);
            rule__Object__FeaturesAssignment_5_7_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getFeaturesAssignment_5_7_1()); 
            }

            }

            // InternalBug304681TestLanguage.g:1493:2: ( ( rule__Object__FeaturesAssignment_5_7_1 )* )
            // InternalBug304681TestLanguage.g:1494:3: ( rule__Object__FeaturesAssignment_5_7_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getFeaturesAssignment_5_7_1()); 
            }
            // InternalBug304681TestLanguage.g:1495:3: ( rule__Object__FeaturesAssignment_5_7_1 )*
            loop14:
            do {
                int alt14=2;
                alt14 = dfa14.predict(input);
                switch (alt14) {
            	case 1 :
            	    // InternalBug304681TestLanguage.g:1495:4: rule__Object__FeaturesAssignment_5_7_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_14);
            	    rule__Object__FeaturesAssignment_5_7_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getFeaturesAssignment_5_7_1()); 
            }

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
    // $ANTLR end "rule__Object__Group_5_7__1__Impl"


    // $ANTLR start "rule__Attribute__Group__0"
    // InternalBug304681TestLanguage.g:1505:1: rule__Attribute__Group__0 : rule__Attribute__Group__0__Impl rule__Attribute__Group__1 ;
    public final void rule__Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1509:1: ( rule__Attribute__Group__0__Impl rule__Attribute__Group__1 )
            // InternalBug304681TestLanguage.g:1510:2: rule__Attribute__Group__0__Impl rule__Attribute__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Attribute__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__0"


    // $ANTLR start "rule__Attribute__Group__0__Impl"
    // InternalBug304681TestLanguage.g:1517:1: rule__Attribute__Group__0__Impl : ( 'Attribute' ) ;
    public final void rule__Attribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1521:1: ( ( 'Attribute' ) )
            // InternalBug304681TestLanguage.g:1522:1: ( 'Attribute' )
            {
            // InternalBug304681TestLanguage.g:1522:1: ( 'Attribute' )
            // InternalBug304681TestLanguage.g:1523:2: 'Attribute'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getAttributeKeyword_0()); 
            }
            match(input,26,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeAccess().getAttributeKeyword_0()); 
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
    // $ANTLR end "rule__Attribute__Group__0__Impl"


    // $ANTLR start "rule__Attribute__Group__1"
    // InternalBug304681TestLanguage.g:1532:1: rule__Attribute__Group__1 : rule__Attribute__Group__1__Impl rule__Attribute__Group__2 ;
    public final void rule__Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1536:1: ( rule__Attribute__Group__1__Impl rule__Attribute__Group__2 )
            // InternalBug304681TestLanguage.g:1537:2: rule__Attribute__Group__1__Impl rule__Attribute__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Attribute__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__1"


    // $ANTLR start "rule__Attribute__Group__1__Impl"
    // InternalBug304681TestLanguage.g:1544:1: rule__Attribute__Group__1__Impl : ( ( rule__Attribute__TypeAssignment_1 ) ) ;
    public final void rule__Attribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1548:1: ( ( ( rule__Attribute__TypeAssignment_1 ) ) )
            // InternalBug304681TestLanguage.g:1549:1: ( ( rule__Attribute__TypeAssignment_1 ) )
            {
            // InternalBug304681TestLanguage.g:1549:1: ( ( rule__Attribute__TypeAssignment_1 ) )
            // InternalBug304681TestLanguage.g:1550:2: ( rule__Attribute__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getTypeAssignment_1()); 
            }
            // InternalBug304681TestLanguage.g:1551:2: ( rule__Attribute__TypeAssignment_1 )
            // InternalBug304681TestLanguage.g:1551:3: rule__Attribute__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute__TypeAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeAccess().getTypeAssignment_1()); 
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
    // $ANTLR end "rule__Attribute__Group__1__Impl"


    // $ANTLR start "rule__Attribute__Group__2"
    // InternalBug304681TestLanguage.g:1559:1: rule__Attribute__Group__2 : rule__Attribute__Group__2__Impl rule__Attribute__Group__3 ;
    public final void rule__Attribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1563:1: ( rule__Attribute__Group__2__Impl rule__Attribute__Group__3 )
            // InternalBug304681TestLanguage.g:1564:2: rule__Attribute__Group__2__Impl rule__Attribute__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Attribute__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__2"


    // $ANTLR start "rule__Attribute__Group__2__Impl"
    // InternalBug304681TestLanguage.g:1571:1: rule__Attribute__Group__2__Impl : ( ( rule__Attribute__NameAssignment_2 ) ) ;
    public final void rule__Attribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1575:1: ( ( ( rule__Attribute__NameAssignment_2 ) ) )
            // InternalBug304681TestLanguage.g:1576:1: ( ( rule__Attribute__NameAssignment_2 ) )
            {
            // InternalBug304681TestLanguage.g:1576:1: ( ( rule__Attribute__NameAssignment_2 ) )
            // InternalBug304681TestLanguage.g:1577:2: ( rule__Attribute__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getNameAssignment_2()); 
            }
            // InternalBug304681TestLanguage.g:1578:2: ( rule__Attribute__NameAssignment_2 )
            // InternalBug304681TestLanguage.g:1578:3: rule__Attribute__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeAccess().getNameAssignment_2()); 
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
    // $ANTLR end "rule__Attribute__Group__2__Impl"


    // $ANTLR start "rule__Attribute__Group__3"
    // InternalBug304681TestLanguage.g:1586:1: rule__Attribute__Group__3 : rule__Attribute__Group__3__Impl ;
    public final void rule__Attribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1590:1: ( rule__Attribute__Group__3__Impl )
            // InternalBug304681TestLanguage.g:1591:2: rule__Attribute__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__3"


    // $ANTLR start "rule__Attribute__Group__3__Impl"
    // InternalBug304681TestLanguage.g:1597:1: rule__Attribute__Group__3__Impl : ( ';' ) ;
    public final void rule__Attribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1601:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:1602:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:1602:1: ( ';' )
            // InternalBug304681TestLanguage.g:1603:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getSemicolonKeyword_3()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeAccess().getSemicolonKeyword_3()); 
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
    // $ANTLR end "rule__Attribute__Group__3__Impl"


    // $ANTLR start "rule__Reference__Group__0"
    // InternalBug304681TestLanguage.g:1613:1: rule__Reference__Group__0 : rule__Reference__Group__0__Impl rule__Reference__Group__1 ;
    public final void rule__Reference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1617:1: ( rule__Reference__Group__0__Impl rule__Reference__Group__1 )
            // InternalBug304681TestLanguage.g:1618:2: rule__Reference__Group__0__Impl rule__Reference__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Reference__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__0"


    // $ANTLR start "rule__Reference__Group__0__Impl"
    // InternalBug304681TestLanguage.g:1625:1: rule__Reference__Group__0__Impl : ( 'Reference' ) ;
    public final void rule__Reference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1629:1: ( ( 'Reference' ) )
            // InternalBug304681TestLanguage.g:1630:1: ( 'Reference' )
            {
            // InternalBug304681TestLanguage.g:1630:1: ( 'Reference' )
            // InternalBug304681TestLanguage.g:1631:2: 'Reference'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getReferenceKeyword_0()); 
            }
            match(input,27,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getReferenceKeyword_0()); 
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
    // $ANTLR end "rule__Reference__Group__0__Impl"


    // $ANTLR start "rule__Reference__Group__1"
    // InternalBug304681TestLanguage.g:1640:1: rule__Reference__Group__1 : rule__Reference__Group__1__Impl rule__Reference__Group__2 ;
    public final void rule__Reference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1644:1: ( rule__Reference__Group__1__Impl rule__Reference__Group__2 )
            // InternalBug304681TestLanguage.g:1645:2: rule__Reference__Group__1__Impl rule__Reference__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__Reference__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__1"


    // $ANTLR start "rule__Reference__Group__1__Impl"
    // InternalBug304681TestLanguage.g:1652:1: rule__Reference__Group__1__Impl : ( ( rule__Reference__TypeAssignment_1 ) ) ;
    public final void rule__Reference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1656:1: ( ( ( rule__Reference__TypeAssignment_1 ) ) )
            // InternalBug304681TestLanguage.g:1657:1: ( ( rule__Reference__TypeAssignment_1 ) )
            {
            // InternalBug304681TestLanguage.g:1657:1: ( ( rule__Reference__TypeAssignment_1 ) )
            // InternalBug304681TestLanguage.g:1658:2: ( rule__Reference__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getTypeAssignment_1()); 
            }
            // InternalBug304681TestLanguage.g:1659:2: ( rule__Reference__TypeAssignment_1 )
            // InternalBug304681TestLanguage.g:1659:3: rule__Reference__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__TypeAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getTypeAssignment_1()); 
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
    // $ANTLR end "rule__Reference__Group__1__Impl"


    // $ANTLR start "rule__Reference__Group__2"
    // InternalBug304681TestLanguage.g:1667:1: rule__Reference__Group__2 : rule__Reference__Group__2__Impl rule__Reference__Group__3 ;
    public final void rule__Reference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1671:1: ( rule__Reference__Group__2__Impl rule__Reference__Group__3 )
            // InternalBug304681TestLanguage.g:1672:2: rule__Reference__Group__2__Impl rule__Reference__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__Reference__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__2"


    // $ANTLR start "rule__Reference__Group__2__Impl"
    // InternalBug304681TestLanguage.g:1679:1: rule__Reference__Group__2__Impl : ( ( rule__Reference__ManyAssignment_2 )? ) ;
    public final void rule__Reference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1683:1: ( ( ( rule__Reference__ManyAssignment_2 )? ) )
            // InternalBug304681TestLanguage.g:1684:1: ( ( rule__Reference__ManyAssignment_2 )? )
            {
            // InternalBug304681TestLanguage.g:1684:1: ( ( rule__Reference__ManyAssignment_2 )? )
            // InternalBug304681TestLanguage.g:1685:2: ( rule__Reference__ManyAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getManyAssignment_2()); 
            }
            // InternalBug304681TestLanguage.g:1686:2: ( rule__Reference__ManyAssignment_2 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==34) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalBug304681TestLanguage.g:1686:3: rule__Reference__ManyAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Reference__ManyAssignment_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getManyAssignment_2()); 
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
    // $ANTLR end "rule__Reference__Group__2__Impl"


    // $ANTLR start "rule__Reference__Group__3"
    // InternalBug304681TestLanguage.g:1694:1: rule__Reference__Group__3 : rule__Reference__Group__3__Impl rule__Reference__Group__4 ;
    public final void rule__Reference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1698:1: ( rule__Reference__Group__3__Impl rule__Reference__Group__4 )
            // InternalBug304681TestLanguage.g:1699:2: rule__Reference__Group__3__Impl rule__Reference__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_17);
            rule__Reference__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__3"


    // $ANTLR start "rule__Reference__Group__3__Impl"
    // InternalBug304681TestLanguage.g:1706:1: rule__Reference__Group__3__Impl : ( ( rule__Reference__NameAssignment_3 ) ) ;
    public final void rule__Reference__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1710:1: ( ( ( rule__Reference__NameAssignment_3 ) ) )
            // InternalBug304681TestLanguage.g:1711:1: ( ( rule__Reference__NameAssignment_3 ) )
            {
            // InternalBug304681TestLanguage.g:1711:1: ( ( rule__Reference__NameAssignment_3 ) )
            // InternalBug304681TestLanguage.g:1712:2: ( rule__Reference__NameAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getNameAssignment_3()); 
            }
            // InternalBug304681TestLanguage.g:1713:2: ( rule__Reference__NameAssignment_3 )
            // InternalBug304681TestLanguage.g:1713:3: rule__Reference__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__NameAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getNameAssignment_3()); 
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
    // $ANTLR end "rule__Reference__Group__3__Impl"


    // $ANTLR start "rule__Reference__Group__4"
    // InternalBug304681TestLanguage.g:1721:1: rule__Reference__Group__4 : rule__Reference__Group__4__Impl ;
    public final void rule__Reference__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1725:1: ( rule__Reference__Group__4__Impl )
            // InternalBug304681TestLanguage.g:1726:2: rule__Reference__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__4"


    // $ANTLR start "rule__Reference__Group__4__Impl"
    // InternalBug304681TestLanguage.g:1732:1: rule__Reference__Group__4__Impl : ( ( rule__Reference__Alternatives_4 ) ) ;
    public final void rule__Reference__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1736:1: ( ( ( rule__Reference__Alternatives_4 ) ) )
            // InternalBug304681TestLanguage.g:1737:1: ( ( rule__Reference__Alternatives_4 ) )
            {
            // InternalBug304681TestLanguage.g:1737:1: ( ( rule__Reference__Alternatives_4 ) )
            // InternalBug304681TestLanguage.g:1738:2: ( rule__Reference__Alternatives_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getAlternatives_4()); 
            }
            // InternalBug304681TestLanguage.g:1739:2: ( rule__Reference__Alternatives_4 )
            // InternalBug304681TestLanguage.g:1739:3: rule__Reference__Alternatives_4
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Alternatives_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getAlternatives_4()); 
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
    // $ANTLR end "rule__Reference__Group__4__Impl"


    // $ANTLR start "rule__Reference__Group_4_0__0"
    // InternalBug304681TestLanguage.g:1748:1: rule__Reference__Group_4_0__0 : rule__Reference__Group_4_0__0__Impl rule__Reference__Group_4_0__1 ;
    public final void rule__Reference__Group_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1752:1: ( rule__Reference__Group_4_0__0__Impl rule__Reference__Group_4_0__1 )
            // InternalBug304681TestLanguage.g:1753:2: rule__Reference__Group_4_0__0__Impl rule__Reference__Group_4_0__1
            {
            pushFollow(FollowSets000.FOLLOW_18);
            rule__Reference__Group_4_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group_4_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_0__0"


    // $ANTLR start "rule__Reference__Group_4_0__0__Impl"
    // InternalBug304681TestLanguage.g:1760:1: rule__Reference__Group_4_0__0__Impl : ( '{' ) ;
    public final void rule__Reference__Group_4_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1764:1: ( ( '{' ) )
            // InternalBug304681TestLanguage.g:1765:1: ( '{' )
            {
            // InternalBug304681TestLanguage.g:1765:1: ( '{' )
            // InternalBug304681TestLanguage.g:1766:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getLeftCurlyBracketKeyword_4_0_0()); 
            }
            match(input,16,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getLeftCurlyBracketKeyword_4_0_0()); 
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
    // $ANTLR end "rule__Reference__Group_4_0__0__Impl"


    // $ANTLR start "rule__Reference__Group_4_0__1"
    // InternalBug304681TestLanguage.g:1775:1: rule__Reference__Group_4_0__1 : rule__Reference__Group_4_0__1__Impl rule__Reference__Group_4_0__2 ;
    public final void rule__Reference__Group_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1779:1: ( rule__Reference__Group_4_0__1__Impl rule__Reference__Group_4_0__2 )
            // InternalBug304681TestLanguage.g:1780:2: rule__Reference__Group_4_0__1__Impl rule__Reference__Group_4_0__2
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Reference__Group_4_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group_4_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_0__1"


    // $ANTLR start "rule__Reference__Group_4_0__1__Impl"
    // InternalBug304681TestLanguage.g:1787:1: rule__Reference__Group_4_0__1__Impl : ( ( rule__Reference__UnorderedGroup_4_0_1 ) ) ;
    public final void rule__Reference__Group_4_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1791:1: ( ( ( rule__Reference__UnorderedGroup_4_0_1 ) ) )
            // InternalBug304681TestLanguage.g:1792:1: ( ( rule__Reference__UnorderedGroup_4_0_1 ) )
            {
            // InternalBug304681TestLanguage.g:1792:1: ( ( rule__Reference__UnorderedGroup_4_0_1 ) )
            // InternalBug304681TestLanguage.g:1793:2: ( rule__Reference__UnorderedGroup_4_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1()); 
            }
            // InternalBug304681TestLanguage.g:1794:2: ( rule__Reference__UnorderedGroup_4_0_1 )
            // InternalBug304681TestLanguage.g:1794:3: rule__Reference__UnorderedGroup_4_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__UnorderedGroup_4_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1()); 
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
    // $ANTLR end "rule__Reference__Group_4_0__1__Impl"


    // $ANTLR start "rule__Reference__Group_4_0__2"
    // InternalBug304681TestLanguage.g:1802:1: rule__Reference__Group_4_0__2 : rule__Reference__Group_4_0__2__Impl ;
    public final void rule__Reference__Group_4_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1806:1: ( rule__Reference__Group_4_0__2__Impl )
            // InternalBug304681TestLanguage.g:1807:2: rule__Reference__Group_4_0__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group_4_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_0__2"


    // $ANTLR start "rule__Reference__Group_4_0__2__Impl"
    // InternalBug304681TestLanguage.g:1813:1: rule__Reference__Group_4_0__2__Impl : ( '}' ) ;
    public final void rule__Reference__Group_4_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1817:1: ( ( '}' ) )
            // InternalBug304681TestLanguage.g:1818:1: ( '}' )
            {
            // InternalBug304681TestLanguage.g:1818:1: ( '}' )
            // InternalBug304681TestLanguage.g:1819:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getRightCurlyBracketKeyword_4_0_2()); 
            }
            match(input,17,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getRightCurlyBracketKeyword_4_0_2()); 
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
    // $ANTLR end "rule__Reference__Group_4_0__2__Impl"


    // $ANTLR start "rule__Reference__Group_4_0_1_0__0"
    // InternalBug304681TestLanguage.g:1829:1: rule__Reference__Group_4_0_1_0__0 : rule__Reference__Group_4_0_1_0__0__Impl rule__Reference__Group_4_0_1_0__1 ;
    public final void rule__Reference__Group_4_0_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1833:1: ( rule__Reference__Group_4_0_1_0__0__Impl rule__Reference__Group_4_0_1_0__1 )
            // InternalBug304681TestLanguage.g:1834:2: rule__Reference__Group_4_0_1_0__0__Impl rule__Reference__Group_4_0_1_0__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__Reference__Group_4_0_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group_4_0_1_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_0_1_0__0"


    // $ANTLR start "rule__Reference__Group_4_0_1_0__0__Impl"
    // InternalBug304681TestLanguage.g:1841:1: rule__Reference__Group_4_0_1_0__0__Impl : ( 'shortDescription' ) ;
    public final void rule__Reference__Group_4_0_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1845:1: ( ( 'shortDescription' ) )
            // InternalBug304681TestLanguage.g:1846:1: ( 'shortDescription' )
            {
            // InternalBug304681TestLanguage.g:1846:1: ( 'shortDescription' )
            // InternalBug304681TestLanguage.g:1847:2: 'shortDescription'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getShortDescriptionKeyword_4_0_1_0_0()); 
            }
            match(input,19,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getShortDescriptionKeyword_4_0_1_0_0()); 
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
    // $ANTLR end "rule__Reference__Group_4_0_1_0__0__Impl"


    // $ANTLR start "rule__Reference__Group_4_0_1_0__1"
    // InternalBug304681TestLanguage.g:1856:1: rule__Reference__Group_4_0_1_0__1 : rule__Reference__Group_4_0_1_0__1__Impl rule__Reference__Group_4_0_1_0__2 ;
    public final void rule__Reference__Group_4_0_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1860:1: ( rule__Reference__Group_4_0_1_0__1__Impl rule__Reference__Group_4_0_1_0__2 )
            // InternalBug304681TestLanguage.g:1861:2: rule__Reference__Group_4_0_1_0__1__Impl rule__Reference__Group_4_0_1_0__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Reference__Group_4_0_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group_4_0_1_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_0_1_0__1"


    // $ANTLR start "rule__Reference__Group_4_0_1_0__1__Impl"
    // InternalBug304681TestLanguage.g:1868:1: rule__Reference__Group_4_0_1_0__1__Impl : ( ( rule__Reference__ShortDescriptionAssignment_4_0_1_0_1 ) ) ;
    public final void rule__Reference__Group_4_0_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1872:1: ( ( ( rule__Reference__ShortDescriptionAssignment_4_0_1_0_1 ) ) )
            // InternalBug304681TestLanguage.g:1873:1: ( ( rule__Reference__ShortDescriptionAssignment_4_0_1_0_1 ) )
            {
            // InternalBug304681TestLanguage.g:1873:1: ( ( rule__Reference__ShortDescriptionAssignment_4_0_1_0_1 ) )
            // InternalBug304681TestLanguage.g:1874:2: ( rule__Reference__ShortDescriptionAssignment_4_0_1_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getShortDescriptionAssignment_4_0_1_0_1()); 
            }
            // InternalBug304681TestLanguage.g:1875:2: ( rule__Reference__ShortDescriptionAssignment_4_0_1_0_1 )
            // InternalBug304681TestLanguage.g:1875:3: rule__Reference__ShortDescriptionAssignment_4_0_1_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__ShortDescriptionAssignment_4_0_1_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getShortDescriptionAssignment_4_0_1_0_1()); 
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
    // $ANTLR end "rule__Reference__Group_4_0_1_0__1__Impl"


    // $ANTLR start "rule__Reference__Group_4_0_1_0__2"
    // InternalBug304681TestLanguage.g:1883:1: rule__Reference__Group_4_0_1_0__2 : rule__Reference__Group_4_0_1_0__2__Impl ;
    public final void rule__Reference__Group_4_0_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1887:1: ( rule__Reference__Group_4_0_1_0__2__Impl )
            // InternalBug304681TestLanguage.g:1888:2: rule__Reference__Group_4_0_1_0__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group_4_0_1_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_0_1_0__2"


    // $ANTLR start "rule__Reference__Group_4_0_1_0__2__Impl"
    // InternalBug304681TestLanguage.g:1894:1: rule__Reference__Group_4_0_1_0__2__Impl : ( ';' ) ;
    public final void rule__Reference__Group_4_0_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1898:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:1899:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:1899:1: ( ';' )
            // InternalBug304681TestLanguage.g:1900:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getSemicolonKeyword_4_0_1_0_2()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getSemicolonKeyword_4_0_1_0_2()); 
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
    // $ANTLR end "rule__Reference__Group_4_0_1_0__2__Impl"


    // $ANTLR start "rule__Reference__Group_4_0_1_1__0"
    // InternalBug304681TestLanguage.g:1910:1: rule__Reference__Group_4_0_1_1__0 : rule__Reference__Group_4_0_1_1__0__Impl rule__Reference__Group_4_0_1_1__1 ;
    public final void rule__Reference__Group_4_0_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1914:1: ( rule__Reference__Group_4_0_1_1__0__Impl rule__Reference__Group_4_0_1_1__1 )
            // InternalBug304681TestLanguage.g:1915:2: rule__Reference__Group_4_0_1_1__0__Impl rule__Reference__Group_4_0_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__Reference__Group_4_0_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group_4_0_1_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_0_1_1__0"


    // $ANTLR start "rule__Reference__Group_4_0_1_1__0__Impl"
    // InternalBug304681TestLanguage.g:1922:1: rule__Reference__Group_4_0_1_1__0__Impl : ( 'longDescription' ) ;
    public final void rule__Reference__Group_4_0_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1926:1: ( ( 'longDescription' ) )
            // InternalBug304681TestLanguage.g:1927:1: ( 'longDescription' )
            {
            // InternalBug304681TestLanguage.g:1927:1: ( 'longDescription' )
            // InternalBug304681TestLanguage.g:1928:2: 'longDescription'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getLongDescriptionKeyword_4_0_1_1_0()); 
            }
            match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getLongDescriptionKeyword_4_0_1_1_0()); 
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
    // $ANTLR end "rule__Reference__Group_4_0_1_1__0__Impl"


    // $ANTLR start "rule__Reference__Group_4_0_1_1__1"
    // InternalBug304681TestLanguage.g:1937:1: rule__Reference__Group_4_0_1_1__1 : rule__Reference__Group_4_0_1_1__1__Impl rule__Reference__Group_4_0_1_1__2 ;
    public final void rule__Reference__Group_4_0_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1941:1: ( rule__Reference__Group_4_0_1_1__1__Impl rule__Reference__Group_4_0_1_1__2 )
            // InternalBug304681TestLanguage.g:1942:2: rule__Reference__Group_4_0_1_1__1__Impl rule__Reference__Group_4_0_1_1__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Reference__Group_4_0_1_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group_4_0_1_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_0_1_1__1"


    // $ANTLR start "rule__Reference__Group_4_0_1_1__1__Impl"
    // InternalBug304681TestLanguage.g:1949:1: rule__Reference__Group_4_0_1_1__1__Impl : ( ( rule__Reference__LongDescriptionAssignment_4_0_1_1_1 ) ) ;
    public final void rule__Reference__Group_4_0_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1953:1: ( ( ( rule__Reference__LongDescriptionAssignment_4_0_1_1_1 ) ) )
            // InternalBug304681TestLanguage.g:1954:1: ( ( rule__Reference__LongDescriptionAssignment_4_0_1_1_1 ) )
            {
            // InternalBug304681TestLanguage.g:1954:1: ( ( rule__Reference__LongDescriptionAssignment_4_0_1_1_1 ) )
            // InternalBug304681TestLanguage.g:1955:2: ( rule__Reference__LongDescriptionAssignment_4_0_1_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getLongDescriptionAssignment_4_0_1_1_1()); 
            }
            // InternalBug304681TestLanguage.g:1956:2: ( rule__Reference__LongDescriptionAssignment_4_0_1_1_1 )
            // InternalBug304681TestLanguage.g:1956:3: rule__Reference__LongDescriptionAssignment_4_0_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__LongDescriptionAssignment_4_0_1_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getLongDescriptionAssignment_4_0_1_1_1()); 
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
    // $ANTLR end "rule__Reference__Group_4_0_1_1__1__Impl"


    // $ANTLR start "rule__Reference__Group_4_0_1_1__2"
    // InternalBug304681TestLanguage.g:1964:1: rule__Reference__Group_4_0_1_1__2 : rule__Reference__Group_4_0_1_1__2__Impl ;
    public final void rule__Reference__Group_4_0_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1968:1: ( rule__Reference__Group_4_0_1_1__2__Impl )
            // InternalBug304681TestLanguage.g:1969:2: rule__Reference__Group_4_0_1_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group_4_0_1_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_0_1_1__2"


    // $ANTLR start "rule__Reference__Group_4_0_1_1__2__Impl"
    // InternalBug304681TestLanguage.g:1975:1: rule__Reference__Group_4_0_1_1__2__Impl : ( ';' ) ;
    public final void rule__Reference__Group_4_0_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1979:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:1980:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:1980:1: ( ';' )
            // InternalBug304681TestLanguage.g:1981:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getSemicolonKeyword_4_0_1_1_2()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getSemicolonKeyword_4_0_1_1_2()); 
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
    // $ANTLR end "rule__Reference__Group_4_0_1_1__2__Impl"


    // $ANTLR start "rule__PackageDefinition2__Group__0"
    // InternalBug304681TestLanguage.g:1991:1: rule__PackageDefinition2__Group__0 : rule__PackageDefinition2__Group__0__Impl rule__PackageDefinition2__Group__1 ;
    public final void rule__PackageDefinition2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1995:1: ( rule__PackageDefinition2__Group__0__Impl rule__PackageDefinition2__Group__1 )
            // InternalBug304681TestLanguage.g:1996:2: rule__PackageDefinition2__Group__0__Impl rule__PackageDefinition2__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__PackageDefinition2__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PackageDefinition2__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition2__Group__0"


    // $ANTLR start "rule__PackageDefinition2__Group__0__Impl"
    // InternalBug304681TestLanguage.g:2003:1: rule__PackageDefinition2__Group__0__Impl : ( () ) ;
    public final void rule__PackageDefinition2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2007:1: ( ( () ) )
            // InternalBug304681TestLanguage.g:2008:1: ( () )
            {
            // InternalBug304681TestLanguage.g:2008:1: ( () )
            // InternalBug304681TestLanguage.g:2009:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageDefinition2Access().getPackageDefinitionAction_0()); 
            }
            // InternalBug304681TestLanguage.g:2010:2: ()
            // InternalBug304681TestLanguage.g:2010:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageDefinition2Access().getPackageDefinitionAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition2__Group__0__Impl"


    // $ANTLR start "rule__PackageDefinition2__Group__1"
    // InternalBug304681TestLanguage.g:2018:1: rule__PackageDefinition2__Group__1 : rule__PackageDefinition2__Group__1__Impl rule__PackageDefinition2__Group__2 ;
    public final void rule__PackageDefinition2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2022:1: ( rule__PackageDefinition2__Group__1__Impl rule__PackageDefinition2__Group__2 )
            // InternalBug304681TestLanguage.g:2023:2: rule__PackageDefinition2__Group__1__Impl rule__PackageDefinition2__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__PackageDefinition2__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PackageDefinition2__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition2__Group__1"


    // $ANTLR start "rule__PackageDefinition2__Group__1__Impl"
    // InternalBug304681TestLanguage.g:2030:1: rule__PackageDefinition2__Group__1__Impl : ( 'package' ) ;
    public final void rule__PackageDefinition2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2034:1: ( ( 'package' ) )
            // InternalBug304681TestLanguage.g:2035:1: ( 'package' )
            {
            // InternalBug304681TestLanguage.g:2035:1: ( 'package' )
            // InternalBug304681TestLanguage.g:2036:2: 'package'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageDefinition2Access().getPackageKeyword_1()); 
            }
            match(input,14,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageDefinition2Access().getPackageKeyword_1()); 
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
    // $ANTLR end "rule__PackageDefinition2__Group__1__Impl"


    // $ANTLR start "rule__PackageDefinition2__Group__2"
    // InternalBug304681TestLanguage.g:2045:1: rule__PackageDefinition2__Group__2 : rule__PackageDefinition2__Group__2__Impl rule__PackageDefinition2__Group__3 ;
    public final void rule__PackageDefinition2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2049:1: ( rule__PackageDefinition2__Group__2__Impl rule__PackageDefinition2__Group__3 )
            // InternalBug304681TestLanguage.g:2050:2: rule__PackageDefinition2__Group__2__Impl rule__PackageDefinition2__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__PackageDefinition2__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PackageDefinition2__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition2__Group__2"


    // $ANTLR start "rule__PackageDefinition2__Group__2__Impl"
    // InternalBug304681TestLanguage.g:2057:1: rule__PackageDefinition2__Group__2__Impl : ( ( rule__PackageDefinition2__NamespaceAssignment_2 ) ) ;
    public final void rule__PackageDefinition2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2061:1: ( ( ( rule__PackageDefinition2__NamespaceAssignment_2 ) ) )
            // InternalBug304681TestLanguage.g:2062:1: ( ( rule__PackageDefinition2__NamespaceAssignment_2 ) )
            {
            // InternalBug304681TestLanguage.g:2062:1: ( ( rule__PackageDefinition2__NamespaceAssignment_2 ) )
            // InternalBug304681TestLanguage.g:2063:2: ( rule__PackageDefinition2__NamespaceAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageDefinition2Access().getNamespaceAssignment_2()); 
            }
            // InternalBug304681TestLanguage.g:2064:2: ( rule__PackageDefinition2__NamespaceAssignment_2 )
            // InternalBug304681TestLanguage.g:2064:3: rule__PackageDefinition2__NamespaceAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PackageDefinition2__NamespaceAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageDefinition2Access().getNamespaceAssignment_2()); 
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
    // $ANTLR end "rule__PackageDefinition2__Group__2__Impl"


    // $ANTLR start "rule__PackageDefinition2__Group__3"
    // InternalBug304681TestLanguage.g:2072:1: rule__PackageDefinition2__Group__3 : rule__PackageDefinition2__Group__3__Impl rule__PackageDefinition2__Group__4 ;
    public final void rule__PackageDefinition2__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2076:1: ( rule__PackageDefinition2__Group__3__Impl rule__PackageDefinition2__Group__4 )
            // InternalBug304681TestLanguage.g:2077:2: rule__PackageDefinition2__Group__3__Impl rule__PackageDefinition2__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__PackageDefinition2__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PackageDefinition2__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition2__Group__3"


    // $ANTLR start "rule__PackageDefinition2__Group__3__Impl"
    // InternalBug304681TestLanguage.g:2084:1: rule__PackageDefinition2__Group__3__Impl : ( ';' ) ;
    public final void rule__PackageDefinition2__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2088:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:2089:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:2089:1: ( ';' )
            // InternalBug304681TestLanguage.g:2090:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageDefinition2Access().getSemicolonKeyword_3()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageDefinition2Access().getSemicolonKeyword_3()); 
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
    // $ANTLR end "rule__PackageDefinition2__Group__3__Impl"


    // $ANTLR start "rule__PackageDefinition2__Group__4"
    // InternalBug304681TestLanguage.g:2099:1: rule__PackageDefinition2__Group__4 : rule__PackageDefinition2__Group__4__Impl ;
    public final void rule__PackageDefinition2__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2103:1: ( rule__PackageDefinition2__Group__4__Impl )
            // InternalBug304681TestLanguage.g:2104:2: rule__PackageDefinition2__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PackageDefinition2__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition2__Group__4"


    // $ANTLR start "rule__PackageDefinition2__Group__4__Impl"
    // InternalBug304681TestLanguage.g:2110:1: rule__PackageDefinition2__Group__4__Impl : ( ( rule__PackageDefinition2__ContentsAssignment_4 )* ) ;
    public final void rule__PackageDefinition2__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2114:1: ( ( ( rule__PackageDefinition2__ContentsAssignment_4 )* ) )
            // InternalBug304681TestLanguage.g:2115:1: ( ( rule__PackageDefinition2__ContentsAssignment_4 )* )
            {
            // InternalBug304681TestLanguage.g:2115:1: ( ( rule__PackageDefinition2__ContentsAssignment_4 )* )
            // InternalBug304681TestLanguage.g:2116:2: ( rule__PackageDefinition2__ContentsAssignment_4 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageDefinition2Access().getContentsAssignment_4()); 
            }
            // InternalBug304681TestLanguage.g:2117:2: ( rule__PackageDefinition2__ContentsAssignment_4 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==15||(LA16_0>=31 && LA16_0<=32)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalBug304681TestLanguage.g:2117:3: rule__PackageDefinition2__ContentsAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    rule__PackageDefinition2__ContentsAssignment_4();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageDefinition2Access().getContentsAssignment_4()); 
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
    // $ANTLR end "rule__PackageDefinition2__Group__4__Impl"


    // $ANTLR start "rule__Object2__Group__0"
    // InternalBug304681TestLanguage.g:2126:1: rule__Object2__Group__0 : rule__Object2__Group__0__Impl rule__Object2__Group__1 ;
    public final void rule__Object2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2130:1: ( rule__Object2__Group__0__Impl rule__Object2__Group__1 )
            // InternalBug304681TestLanguage.g:2131:2: rule__Object2__Group__0__Impl rule__Object2__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Object2__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group__0"


    // $ANTLR start "rule__Object2__Group__0__Impl"
    // InternalBug304681TestLanguage.g:2138:1: rule__Object2__Group__0__Impl : ( ( rule__Object2__Alternatives_0 )? ) ;
    public final void rule__Object2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2142:1: ( ( ( rule__Object2__Alternatives_0 )? ) )
            // InternalBug304681TestLanguage.g:2143:1: ( ( rule__Object2__Alternatives_0 )? )
            {
            // InternalBug304681TestLanguage.g:2143:1: ( ( rule__Object2__Alternatives_0 )? )
            // InternalBug304681TestLanguage.g:2144:2: ( rule__Object2__Alternatives_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getAlternatives_0()); 
            }
            // InternalBug304681TestLanguage.g:2145:2: ( rule__Object2__Alternatives_0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=31 && LA17_0<=32)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalBug304681TestLanguage.g:2145:3: rule__Object2__Alternatives_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object2__Alternatives_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getAlternatives_0()); 
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
    // $ANTLR end "rule__Object2__Group__0__Impl"


    // $ANTLR start "rule__Object2__Group__1"
    // InternalBug304681TestLanguage.g:2153:1: rule__Object2__Group__1 : rule__Object2__Group__1__Impl rule__Object2__Group__2 ;
    public final void rule__Object2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2157:1: ( rule__Object2__Group__1__Impl rule__Object2__Group__2 )
            // InternalBug304681TestLanguage.g:2158:2: rule__Object2__Group__1__Impl rule__Object2__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Object2__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group__1"


    // $ANTLR start "rule__Object2__Group__1__Impl"
    // InternalBug304681TestLanguage.g:2165:1: rule__Object2__Group__1__Impl : ( 'object' ) ;
    public final void rule__Object2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2169:1: ( ( 'object' ) )
            // InternalBug304681TestLanguage.g:2170:1: ( 'object' )
            {
            // InternalBug304681TestLanguage.g:2170:1: ( 'object' )
            // InternalBug304681TestLanguage.g:2171:2: 'object'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getObjectKeyword_1()); 
            }
            match(input,15,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getObjectKeyword_1()); 
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
    // $ANTLR end "rule__Object2__Group__1__Impl"


    // $ANTLR start "rule__Object2__Group__2"
    // InternalBug304681TestLanguage.g:2180:1: rule__Object2__Group__2 : rule__Object2__Group__2__Impl rule__Object2__Group__3 ;
    public final void rule__Object2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2184:1: ( rule__Object2__Group__2__Impl rule__Object2__Group__3 )
            // InternalBug304681TestLanguage.g:2185:2: rule__Object2__Group__2__Impl rule__Object2__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Object2__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group__2"


    // $ANTLR start "rule__Object2__Group__2__Impl"
    // InternalBug304681TestLanguage.g:2192:1: rule__Object2__Group__2__Impl : ( ( rule__Object2__NameAssignment_2 ) ) ;
    public final void rule__Object2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2196:1: ( ( ( rule__Object2__NameAssignment_2 ) ) )
            // InternalBug304681TestLanguage.g:2197:1: ( ( rule__Object2__NameAssignment_2 ) )
            {
            // InternalBug304681TestLanguage.g:2197:1: ( ( rule__Object2__NameAssignment_2 ) )
            // InternalBug304681TestLanguage.g:2198:2: ( rule__Object2__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getNameAssignment_2()); 
            }
            // InternalBug304681TestLanguage.g:2199:2: ( rule__Object2__NameAssignment_2 )
            // InternalBug304681TestLanguage.g:2199:3: rule__Object2__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getNameAssignment_2()); 
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
    // $ANTLR end "rule__Object2__Group__2__Impl"


    // $ANTLR start "rule__Object2__Group__3"
    // InternalBug304681TestLanguage.g:2207:1: rule__Object2__Group__3 : rule__Object2__Group__3__Impl rule__Object2__Group__4 ;
    public final void rule__Object2__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2211:1: ( rule__Object2__Group__3__Impl rule__Object2__Group__4 )
            // InternalBug304681TestLanguage.g:2212:2: rule__Object2__Group__3__Impl rule__Object2__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Object2__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group__3"


    // $ANTLR start "rule__Object2__Group__3__Impl"
    // InternalBug304681TestLanguage.g:2219:1: rule__Object2__Group__3__Impl : ( ( rule__Object2__Group_3__0 )? ) ;
    public final void rule__Object2__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2223:1: ( ( ( rule__Object2__Group_3__0 )? ) )
            // InternalBug304681TestLanguage.g:2224:1: ( ( rule__Object2__Group_3__0 )? )
            {
            // InternalBug304681TestLanguage.g:2224:1: ( ( rule__Object2__Group_3__0 )? )
            // InternalBug304681TestLanguage.g:2225:2: ( rule__Object2__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getGroup_3()); 
            }
            // InternalBug304681TestLanguage.g:2226:2: ( rule__Object2__Group_3__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==18) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalBug304681TestLanguage.g:2226:3: rule__Object2__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object2__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getGroup_3()); 
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
    // $ANTLR end "rule__Object2__Group__3__Impl"


    // $ANTLR start "rule__Object2__Group__4"
    // InternalBug304681TestLanguage.g:2234:1: rule__Object2__Group__4 : rule__Object2__Group__4__Impl rule__Object2__Group__5 ;
    public final void rule__Object2__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2238:1: ( rule__Object2__Group__4__Impl rule__Object2__Group__5 )
            // InternalBug304681TestLanguage.g:2239:2: rule__Object2__Group__4__Impl rule__Object2__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_19);
            rule__Object2__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group__4"


    // $ANTLR start "rule__Object2__Group__4__Impl"
    // InternalBug304681TestLanguage.g:2246:1: rule__Object2__Group__4__Impl : ( '{' ) ;
    public final void rule__Object2__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2250:1: ( ( '{' ) )
            // InternalBug304681TestLanguage.g:2251:1: ( '{' )
            {
            // InternalBug304681TestLanguage.g:2251:1: ( '{' )
            // InternalBug304681TestLanguage.g:2252:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getLeftCurlyBracketKeyword_4()); 
            }
            match(input,16,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getLeftCurlyBracketKeyword_4()); 
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
    // $ANTLR end "rule__Object2__Group__4__Impl"


    // $ANTLR start "rule__Object2__Group__5"
    // InternalBug304681TestLanguage.g:2261:1: rule__Object2__Group__5 : rule__Object2__Group__5__Impl rule__Object2__Group__6 ;
    public final void rule__Object2__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2265:1: ( rule__Object2__Group__5__Impl rule__Object2__Group__6 )
            // InternalBug304681TestLanguage.g:2266:2: rule__Object2__Group__5__Impl rule__Object2__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Object2__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group__5"


    // $ANTLR start "rule__Object2__Group__5__Impl"
    // InternalBug304681TestLanguage.g:2273:1: rule__Object2__Group__5__Impl : ( ( rule__Object2__UnorderedGroup_5 ) ) ;
    public final void rule__Object2__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2277:1: ( ( ( rule__Object2__UnorderedGroup_5 ) ) )
            // InternalBug304681TestLanguage.g:2278:1: ( ( rule__Object2__UnorderedGroup_5 ) )
            {
            // InternalBug304681TestLanguage.g:2278:1: ( ( rule__Object2__UnorderedGroup_5 ) )
            // InternalBug304681TestLanguage.g:2279:2: ( rule__Object2__UnorderedGroup_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getUnorderedGroup_5()); 
            }
            // InternalBug304681TestLanguage.g:2280:2: ( rule__Object2__UnorderedGroup_5 )
            // InternalBug304681TestLanguage.g:2280:3: rule__Object2__UnorderedGroup_5
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__UnorderedGroup_5();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getUnorderedGroup_5()); 
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
    // $ANTLR end "rule__Object2__Group__5__Impl"


    // $ANTLR start "rule__Object2__Group__6"
    // InternalBug304681TestLanguage.g:2288:1: rule__Object2__Group__6 : rule__Object2__Group__6__Impl ;
    public final void rule__Object2__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2292:1: ( rule__Object2__Group__6__Impl )
            // InternalBug304681TestLanguage.g:2293:2: rule__Object2__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group__6"


    // $ANTLR start "rule__Object2__Group__6__Impl"
    // InternalBug304681TestLanguage.g:2299:1: rule__Object2__Group__6__Impl : ( '}' ) ;
    public final void rule__Object2__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2303:1: ( ( '}' ) )
            // InternalBug304681TestLanguage.g:2304:1: ( '}' )
            {
            // InternalBug304681TestLanguage.g:2304:1: ( '}' )
            // InternalBug304681TestLanguage.g:2305:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getRightCurlyBracketKeyword_6()); 
            }
            match(input,17,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getRightCurlyBracketKeyword_6()); 
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
    // $ANTLR end "rule__Object2__Group__6__Impl"


    // $ANTLR start "rule__Object2__Group_3__0"
    // InternalBug304681TestLanguage.g:2315:1: rule__Object2__Group_3__0 : rule__Object2__Group_3__0__Impl rule__Object2__Group_3__1 ;
    public final void rule__Object2__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2319:1: ( rule__Object2__Group_3__0__Impl rule__Object2__Group_3__1 )
            // InternalBug304681TestLanguage.g:2320:2: rule__Object2__Group_3__0__Impl rule__Object2__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Object2__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_3__0"


    // $ANTLR start "rule__Object2__Group_3__0__Impl"
    // InternalBug304681TestLanguage.g:2327:1: rule__Object2__Group_3__0__Impl : ( 'extends' ) ;
    public final void rule__Object2__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2331:1: ( ( 'extends' ) )
            // InternalBug304681TestLanguage.g:2332:1: ( 'extends' )
            {
            // InternalBug304681TestLanguage.g:2332:1: ( 'extends' )
            // InternalBug304681TestLanguage.g:2333:2: 'extends'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getExtendsKeyword_3_0()); 
            }
            match(input,18,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getExtendsKeyword_3_0()); 
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
    // $ANTLR end "rule__Object2__Group_3__0__Impl"


    // $ANTLR start "rule__Object2__Group_3__1"
    // InternalBug304681TestLanguage.g:2342:1: rule__Object2__Group_3__1 : rule__Object2__Group_3__1__Impl ;
    public final void rule__Object2__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2346:1: ( rule__Object2__Group_3__1__Impl )
            // InternalBug304681TestLanguage.g:2347:2: rule__Object2__Group_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_3__1"


    // $ANTLR start "rule__Object2__Group_3__1__Impl"
    // InternalBug304681TestLanguage.g:2353:1: rule__Object2__Group_3__1__Impl : ( ( rule__Object2__ParentAssignment_3_1 ) ) ;
    public final void rule__Object2__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2357:1: ( ( ( rule__Object2__ParentAssignment_3_1 ) ) )
            // InternalBug304681TestLanguage.g:2358:1: ( ( rule__Object2__ParentAssignment_3_1 ) )
            {
            // InternalBug304681TestLanguage.g:2358:1: ( ( rule__Object2__ParentAssignment_3_1 ) )
            // InternalBug304681TestLanguage.g:2359:2: ( rule__Object2__ParentAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getParentAssignment_3_1()); 
            }
            // InternalBug304681TestLanguage.g:2360:2: ( rule__Object2__ParentAssignment_3_1 )
            // InternalBug304681TestLanguage.g:2360:3: rule__Object2__ParentAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__ParentAssignment_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getParentAssignment_3_1()); 
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
    // $ANTLR end "rule__Object2__Group_3__1__Impl"


    // $ANTLR start "rule__Object2__Group_5_0__0"
    // InternalBug304681TestLanguage.g:2369:1: rule__Object2__Group_5_0__0 : rule__Object2__Group_5_0__0__Impl rule__Object2__Group_5_0__1 ;
    public final void rule__Object2__Group_5_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2373:1: ( rule__Object2__Group_5_0__0__Impl rule__Object2__Group_5_0__1 )
            // InternalBug304681TestLanguage.g:2374:2: rule__Object2__Group_5_0__0__Impl rule__Object2__Group_5_0__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__Object2__Group_5_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group_5_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_5_0__0"


    // $ANTLR start "rule__Object2__Group_5_0__0__Impl"
    // InternalBug304681TestLanguage.g:2381:1: rule__Object2__Group_5_0__0__Impl : ( 'shortDescription' ) ;
    public final void rule__Object2__Group_5_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2385:1: ( ( 'shortDescription' ) )
            // InternalBug304681TestLanguage.g:2386:1: ( 'shortDescription' )
            {
            // InternalBug304681TestLanguage.g:2386:1: ( 'shortDescription' )
            // InternalBug304681TestLanguage.g:2387:2: 'shortDescription'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getShortDescriptionKeyword_5_0_0()); 
            }
            match(input,19,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getShortDescriptionKeyword_5_0_0()); 
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
    // $ANTLR end "rule__Object2__Group_5_0__0__Impl"


    // $ANTLR start "rule__Object2__Group_5_0__1"
    // InternalBug304681TestLanguage.g:2396:1: rule__Object2__Group_5_0__1 : rule__Object2__Group_5_0__1__Impl rule__Object2__Group_5_0__2 ;
    public final void rule__Object2__Group_5_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2400:1: ( rule__Object2__Group_5_0__1__Impl rule__Object2__Group_5_0__2 )
            // InternalBug304681TestLanguage.g:2401:2: rule__Object2__Group_5_0__1__Impl rule__Object2__Group_5_0__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Object2__Group_5_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group_5_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_5_0__1"


    // $ANTLR start "rule__Object2__Group_5_0__1__Impl"
    // InternalBug304681TestLanguage.g:2408:1: rule__Object2__Group_5_0__1__Impl : ( ( rule__Object2__ShortDescriptionAssignment_5_0_1 ) ) ;
    public final void rule__Object2__Group_5_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2412:1: ( ( ( rule__Object2__ShortDescriptionAssignment_5_0_1 ) ) )
            // InternalBug304681TestLanguage.g:2413:1: ( ( rule__Object2__ShortDescriptionAssignment_5_0_1 ) )
            {
            // InternalBug304681TestLanguage.g:2413:1: ( ( rule__Object2__ShortDescriptionAssignment_5_0_1 ) )
            // InternalBug304681TestLanguage.g:2414:2: ( rule__Object2__ShortDescriptionAssignment_5_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getShortDescriptionAssignment_5_0_1()); 
            }
            // InternalBug304681TestLanguage.g:2415:2: ( rule__Object2__ShortDescriptionAssignment_5_0_1 )
            // InternalBug304681TestLanguage.g:2415:3: rule__Object2__ShortDescriptionAssignment_5_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__ShortDescriptionAssignment_5_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getShortDescriptionAssignment_5_0_1()); 
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
    // $ANTLR end "rule__Object2__Group_5_0__1__Impl"


    // $ANTLR start "rule__Object2__Group_5_0__2"
    // InternalBug304681TestLanguage.g:2423:1: rule__Object2__Group_5_0__2 : rule__Object2__Group_5_0__2__Impl ;
    public final void rule__Object2__Group_5_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2427:1: ( rule__Object2__Group_5_0__2__Impl )
            // InternalBug304681TestLanguage.g:2428:2: rule__Object2__Group_5_0__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group_5_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_5_0__2"


    // $ANTLR start "rule__Object2__Group_5_0__2__Impl"
    // InternalBug304681TestLanguage.g:2434:1: rule__Object2__Group_5_0__2__Impl : ( ';' ) ;
    public final void rule__Object2__Group_5_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2438:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:2439:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:2439:1: ( ';' )
            // InternalBug304681TestLanguage.g:2440:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getSemicolonKeyword_5_0_2()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getSemicolonKeyword_5_0_2()); 
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
    // $ANTLR end "rule__Object2__Group_5_0__2__Impl"


    // $ANTLR start "rule__Object2__Group_5_1__0"
    // InternalBug304681TestLanguage.g:2450:1: rule__Object2__Group_5_1__0 : rule__Object2__Group_5_1__0__Impl rule__Object2__Group_5_1__1 ;
    public final void rule__Object2__Group_5_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2454:1: ( rule__Object2__Group_5_1__0__Impl rule__Object2__Group_5_1__1 )
            // InternalBug304681TestLanguage.g:2455:2: rule__Object2__Group_5_1__0__Impl rule__Object2__Group_5_1__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__Object2__Group_5_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group_5_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_5_1__0"


    // $ANTLR start "rule__Object2__Group_5_1__0__Impl"
    // InternalBug304681TestLanguage.g:2462:1: rule__Object2__Group_5_1__0__Impl : ( 'longDescription' ) ;
    public final void rule__Object2__Group_5_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2466:1: ( ( 'longDescription' ) )
            // InternalBug304681TestLanguage.g:2467:1: ( 'longDescription' )
            {
            // InternalBug304681TestLanguage.g:2467:1: ( 'longDescription' )
            // InternalBug304681TestLanguage.g:2468:2: 'longDescription'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getLongDescriptionKeyword_5_1_0()); 
            }
            match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getLongDescriptionKeyword_5_1_0()); 
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
    // $ANTLR end "rule__Object2__Group_5_1__0__Impl"


    // $ANTLR start "rule__Object2__Group_5_1__1"
    // InternalBug304681TestLanguage.g:2477:1: rule__Object2__Group_5_1__1 : rule__Object2__Group_5_1__1__Impl rule__Object2__Group_5_1__2 ;
    public final void rule__Object2__Group_5_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2481:1: ( rule__Object2__Group_5_1__1__Impl rule__Object2__Group_5_1__2 )
            // InternalBug304681TestLanguage.g:2482:2: rule__Object2__Group_5_1__1__Impl rule__Object2__Group_5_1__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Object2__Group_5_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group_5_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_5_1__1"


    // $ANTLR start "rule__Object2__Group_5_1__1__Impl"
    // InternalBug304681TestLanguage.g:2489:1: rule__Object2__Group_5_1__1__Impl : ( ( rule__Object2__LongDescriptionAssignment_5_1_1 ) ) ;
    public final void rule__Object2__Group_5_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2493:1: ( ( ( rule__Object2__LongDescriptionAssignment_5_1_1 ) ) )
            // InternalBug304681TestLanguage.g:2494:1: ( ( rule__Object2__LongDescriptionAssignment_5_1_1 ) )
            {
            // InternalBug304681TestLanguage.g:2494:1: ( ( rule__Object2__LongDescriptionAssignment_5_1_1 ) )
            // InternalBug304681TestLanguage.g:2495:2: ( rule__Object2__LongDescriptionAssignment_5_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getLongDescriptionAssignment_5_1_1()); 
            }
            // InternalBug304681TestLanguage.g:2496:2: ( rule__Object2__LongDescriptionAssignment_5_1_1 )
            // InternalBug304681TestLanguage.g:2496:3: rule__Object2__LongDescriptionAssignment_5_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__LongDescriptionAssignment_5_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getLongDescriptionAssignment_5_1_1()); 
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
    // $ANTLR end "rule__Object2__Group_5_1__1__Impl"


    // $ANTLR start "rule__Object2__Group_5_1__2"
    // InternalBug304681TestLanguage.g:2504:1: rule__Object2__Group_5_1__2 : rule__Object2__Group_5_1__2__Impl ;
    public final void rule__Object2__Group_5_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2508:1: ( rule__Object2__Group_5_1__2__Impl )
            // InternalBug304681TestLanguage.g:2509:2: rule__Object2__Group_5_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group_5_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_5_1__2"


    // $ANTLR start "rule__Object2__Group_5_1__2__Impl"
    // InternalBug304681TestLanguage.g:2515:1: rule__Object2__Group_5_1__2__Impl : ( ';' ) ;
    public final void rule__Object2__Group_5_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2519:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:2520:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:2520:1: ( ';' )
            // InternalBug304681TestLanguage.g:2521:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getSemicolonKeyword_5_1_2()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getSemicolonKeyword_5_1_2()); 
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
    // $ANTLR end "rule__Object2__Group_5_1__2__Impl"


    // $ANTLR start "rule__Object2__Group_5_2__0"
    // InternalBug304681TestLanguage.g:2531:1: rule__Object2__Group_5_2__0 : rule__Object2__Group_5_2__0__Impl rule__Object2__Group_5_2__1 ;
    public final void rule__Object2__Group_5_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2535:1: ( rule__Object2__Group_5_2__0__Impl rule__Object2__Group_5_2__1 )
            // InternalBug304681TestLanguage.g:2536:2: rule__Object2__Group_5_2__0__Impl rule__Object2__Group_5_2__1
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__Object2__Group_5_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group_5_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_5_2__0"


    // $ANTLR start "rule__Object2__Group_5_2__0__Impl"
    // InternalBug304681TestLanguage.g:2543:1: rule__Object2__Group_5_2__0__Impl : ( 'serialUID' ) ;
    public final void rule__Object2__Group_5_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2547:1: ( ( 'serialUID' ) )
            // InternalBug304681TestLanguage.g:2548:1: ( 'serialUID' )
            {
            // InternalBug304681TestLanguage.g:2548:1: ( 'serialUID' )
            // InternalBug304681TestLanguage.g:2549:2: 'serialUID'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getSerialUIDKeyword_5_2_0()); 
            }
            match(input,21,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getSerialUIDKeyword_5_2_0()); 
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
    // $ANTLR end "rule__Object2__Group_5_2__0__Impl"


    // $ANTLR start "rule__Object2__Group_5_2__1"
    // InternalBug304681TestLanguage.g:2558:1: rule__Object2__Group_5_2__1 : rule__Object2__Group_5_2__1__Impl rule__Object2__Group_5_2__2 ;
    public final void rule__Object2__Group_5_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2562:1: ( rule__Object2__Group_5_2__1__Impl rule__Object2__Group_5_2__2 )
            // InternalBug304681TestLanguage.g:2563:2: rule__Object2__Group_5_2__1__Impl rule__Object2__Group_5_2__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Object2__Group_5_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group_5_2__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_5_2__1"


    // $ANTLR start "rule__Object2__Group_5_2__1__Impl"
    // InternalBug304681TestLanguage.g:2570:1: rule__Object2__Group_5_2__1__Impl : ( ( rule__Object2__SerialVersionUIDAssignment_5_2_1 ) ) ;
    public final void rule__Object2__Group_5_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2574:1: ( ( ( rule__Object2__SerialVersionUIDAssignment_5_2_1 ) ) )
            // InternalBug304681TestLanguage.g:2575:1: ( ( rule__Object2__SerialVersionUIDAssignment_5_2_1 ) )
            {
            // InternalBug304681TestLanguage.g:2575:1: ( ( rule__Object2__SerialVersionUIDAssignment_5_2_1 ) )
            // InternalBug304681TestLanguage.g:2576:2: ( rule__Object2__SerialVersionUIDAssignment_5_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getSerialVersionUIDAssignment_5_2_1()); 
            }
            // InternalBug304681TestLanguage.g:2577:2: ( rule__Object2__SerialVersionUIDAssignment_5_2_1 )
            // InternalBug304681TestLanguage.g:2577:3: rule__Object2__SerialVersionUIDAssignment_5_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__SerialVersionUIDAssignment_5_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getSerialVersionUIDAssignment_5_2_1()); 
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
    // $ANTLR end "rule__Object2__Group_5_2__1__Impl"


    // $ANTLR start "rule__Object2__Group_5_2__2"
    // InternalBug304681TestLanguage.g:2585:1: rule__Object2__Group_5_2__2 : rule__Object2__Group_5_2__2__Impl ;
    public final void rule__Object2__Group_5_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2589:1: ( rule__Object2__Group_5_2__2__Impl )
            // InternalBug304681TestLanguage.g:2590:2: rule__Object2__Group_5_2__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group_5_2__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_5_2__2"


    // $ANTLR start "rule__Object2__Group_5_2__2__Impl"
    // InternalBug304681TestLanguage.g:2596:1: rule__Object2__Group_5_2__2__Impl : ( ';' ) ;
    public final void rule__Object2__Group_5_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2600:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:2601:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:2601:1: ( ';' )
            // InternalBug304681TestLanguage.g:2602:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getSemicolonKeyword_5_2_2()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getSemicolonKeyword_5_2_2()); 
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
    // $ANTLR end "rule__Object2__Group_5_2__2__Impl"


    // $ANTLR start "rule__Object2__Group_5_3__0"
    // InternalBug304681TestLanguage.g:2612:1: rule__Object2__Group_5_3__0 : rule__Object2__Group_5_3__0__Impl rule__Object2__Group_5_3__1 ;
    public final void rule__Object2__Group_5_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2616:1: ( rule__Object2__Group_5_3__0__Impl rule__Object2__Group_5_3__1 )
            // InternalBug304681TestLanguage.g:2617:2: rule__Object2__Group_5_3__0__Impl rule__Object2__Group_5_3__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Object2__Group_5_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group_5_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_5_3__0"


    // $ANTLR start "rule__Object2__Group_5_3__0__Impl"
    // InternalBug304681TestLanguage.g:2624:1: rule__Object2__Group_5_3__0__Impl : ( ( rule__Object2__CloneableAssignment_5_3_0 ) ) ;
    public final void rule__Object2__Group_5_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2628:1: ( ( ( rule__Object2__CloneableAssignment_5_3_0 ) ) )
            // InternalBug304681TestLanguage.g:2629:1: ( ( rule__Object2__CloneableAssignment_5_3_0 ) )
            {
            // InternalBug304681TestLanguage.g:2629:1: ( ( rule__Object2__CloneableAssignment_5_3_0 ) )
            // InternalBug304681TestLanguage.g:2630:2: ( rule__Object2__CloneableAssignment_5_3_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getCloneableAssignment_5_3_0()); 
            }
            // InternalBug304681TestLanguage.g:2631:2: ( rule__Object2__CloneableAssignment_5_3_0 )
            // InternalBug304681TestLanguage.g:2631:3: rule__Object2__CloneableAssignment_5_3_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__CloneableAssignment_5_3_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getCloneableAssignment_5_3_0()); 
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
    // $ANTLR end "rule__Object2__Group_5_3__0__Impl"


    // $ANTLR start "rule__Object2__Group_5_3__1"
    // InternalBug304681TestLanguage.g:2639:1: rule__Object2__Group_5_3__1 : rule__Object2__Group_5_3__1__Impl ;
    public final void rule__Object2__Group_5_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2643:1: ( rule__Object2__Group_5_3__1__Impl )
            // InternalBug304681TestLanguage.g:2644:2: rule__Object2__Group_5_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group_5_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_5_3__1"


    // $ANTLR start "rule__Object2__Group_5_3__1__Impl"
    // InternalBug304681TestLanguage.g:2650:1: rule__Object2__Group_5_3__1__Impl : ( ';' ) ;
    public final void rule__Object2__Group_5_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2654:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:2655:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:2655:1: ( ';' )
            // InternalBug304681TestLanguage.g:2656:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getSemicolonKeyword_5_3_1()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getSemicolonKeyword_5_3_1()); 
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
    // $ANTLR end "rule__Object2__Group_5_3__1__Impl"


    // $ANTLR start "rule__Attribute2__Group__0"
    // InternalBug304681TestLanguage.g:2666:1: rule__Attribute2__Group__0 : rule__Attribute2__Group__0__Impl rule__Attribute2__Group__1 ;
    public final void rule__Attribute2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2670:1: ( rule__Attribute2__Group__0__Impl rule__Attribute2__Group__1 )
            // InternalBug304681TestLanguage.g:2671:2: rule__Attribute2__Group__0__Impl rule__Attribute2__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Attribute2__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group__0"


    // $ANTLR start "rule__Attribute2__Group__0__Impl"
    // InternalBug304681TestLanguage.g:2678:1: rule__Attribute2__Group__0__Impl : ( 'Attribute' ) ;
    public final void rule__Attribute2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2682:1: ( ( 'Attribute' ) )
            // InternalBug304681TestLanguage.g:2683:1: ( 'Attribute' )
            {
            // InternalBug304681TestLanguage.g:2683:1: ( 'Attribute' )
            // InternalBug304681TestLanguage.g:2684:2: 'Attribute'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getAttributeKeyword_0()); 
            }
            match(input,26,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getAttributeKeyword_0()); 
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
    // $ANTLR end "rule__Attribute2__Group__0__Impl"


    // $ANTLR start "rule__Attribute2__Group__1"
    // InternalBug304681TestLanguage.g:2693:1: rule__Attribute2__Group__1 : rule__Attribute2__Group__1__Impl rule__Attribute2__Group__2 ;
    public final void rule__Attribute2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2697:1: ( rule__Attribute2__Group__1__Impl rule__Attribute2__Group__2 )
            // InternalBug304681TestLanguage.g:2698:2: rule__Attribute2__Group__1__Impl rule__Attribute2__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Attribute2__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group__1"


    // $ANTLR start "rule__Attribute2__Group__1__Impl"
    // InternalBug304681TestLanguage.g:2705:1: rule__Attribute2__Group__1__Impl : ( ( rule__Attribute2__TypeAssignment_1 ) ) ;
    public final void rule__Attribute2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2709:1: ( ( ( rule__Attribute2__TypeAssignment_1 ) ) )
            // InternalBug304681TestLanguage.g:2710:1: ( ( rule__Attribute2__TypeAssignment_1 ) )
            {
            // InternalBug304681TestLanguage.g:2710:1: ( ( rule__Attribute2__TypeAssignment_1 ) )
            // InternalBug304681TestLanguage.g:2711:2: ( rule__Attribute2__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getTypeAssignment_1()); 
            }
            // InternalBug304681TestLanguage.g:2712:2: ( rule__Attribute2__TypeAssignment_1 )
            // InternalBug304681TestLanguage.g:2712:3: rule__Attribute2__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__TypeAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getTypeAssignment_1()); 
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
    // $ANTLR end "rule__Attribute2__Group__1__Impl"


    // $ANTLR start "rule__Attribute2__Group__2"
    // InternalBug304681TestLanguage.g:2720:1: rule__Attribute2__Group__2 : rule__Attribute2__Group__2__Impl rule__Attribute2__Group__3 ;
    public final void rule__Attribute2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2724:1: ( rule__Attribute2__Group__2__Impl rule__Attribute2__Group__3 )
            // InternalBug304681TestLanguage.g:2725:2: rule__Attribute2__Group__2__Impl rule__Attribute2__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_17);
            rule__Attribute2__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group__2"


    // $ANTLR start "rule__Attribute2__Group__2__Impl"
    // InternalBug304681TestLanguage.g:2732:1: rule__Attribute2__Group__2__Impl : ( ( rule__Attribute2__NameAssignment_2 ) ) ;
    public final void rule__Attribute2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2736:1: ( ( ( rule__Attribute2__NameAssignment_2 ) ) )
            // InternalBug304681TestLanguage.g:2737:1: ( ( rule__Attribute2__NameAssignment_2 ) )
            {
            // InternalBug304681TestLanguage.g:2737:1: ( ( rule__Attribute2__NameAssignment_2 ) )
            // InternalBug304681TestLanguage.g:2738:2: ( rule__Attribute2__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getNameAssignment_2()); 
            }
            // InternalBug304681TestLanguage.g:2739:2: ( rule__Attribute2__NameAssignment_2 )
            // InternalBug304681TestLanguage.g:2739:3: rule__Attribute2__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getNameAssignment_2()); 
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
    // $ANTLR end "rule__Attribute2__Group__2__Impl"


    // $ANTLR start "rule__Attribute2__Group__3"
    // InternalBug304681TestLanguage.g:2747:1: rule__Attribute2__Group__3 : rule__Attribute2__Group__3__Impl ;
    public final void rule__Attribute2__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2751:1: ( rule__Attribute2__Group__3__Impl )
            // InternalBug304681TestLanguage.g:2752:2: rule__Attribute2__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group__3"


    // $ANTLR start "rule__Attribute2__Group__3__Impl"
    // InternalBug304681TestLanguage.g:2758:1: rule__Attribute2__Group__3__Impl : ( ( rule__Attribute2__Alternatives_3 ) ) ;
    public final void rule__Attribute2__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2762:1: ( ( ( rule__Attribute2__Alternatives_3 ) ) )
            // InternalBug304681TestLanguage.g:2763:1: ( ( rule__Attribute2__Alternatives_3 ) )
            {
            // InternalBug304681TestLanguage.g:2763:1: ( ( rule__Attribute2__Alternatives_3 ) )
            // InternalBug304681TestLanguage.g:2764:2: ( rule__Attribute2__Alternatives_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getAlternatives_3()); 
            }
            // InternalBug304681TestLanguage.g:2765:2: ( rule__Attribute2__Alternatives_3 )
            // InternalBug304681TestLanguage.g:2765:3: rule__Attribute2__Alternatives_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__Alternatives_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getAlternatives_3()); 
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
    // $ANTLR end "rule__Attribute2__Group__3__Impl"


    // $ANTLR start "rule__Attribute2__Group_3_0__0"
    // InternalBug304681TestLanguage.g:2774:1: rule__Attribute2__Group_3_0__0 : rule__Attribute2__Group_3_0__0__Impl rule__Attribute2__Group_3_0__1 ;
    public final void rule__Attribute2__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2778:1: ( rule__Attribute2__Group_3_0__0__Impl rule__Attribute2__Group_3_0__1 )
            // InternalBug304681TestLanguage.g:2779:2: rule__Attribute2__Group_3_0__0__Impl rule__Attribute2__Group_3_0__1
            {
            pushFollow(FollowSets000.FOLLOW_20);
            rule__Attribute2__Group_3_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__Group_3_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0__0"


    // $ANTLR start "rule__Attribute2__Group_3_0__0__Impl"
    // InternalBug304681TestLanguage.g:2786:1: rule__Attribute2__Group_3_0__0__Impl : ( '{' ) ;
    public final void rule__Attribute2__Group_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2790:1: ( ( '{' ) )
            // InternalBug304681TestLanguage.g:2791:1: ( '{' )
            {
            // InternalBug304681TestLanguage.g:2791:1: ( '{' )
            // InternalBug304681TestLanguage.g:2792:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getLeftCurlyBracketKeyword_3_0_0()); 
            }
            match(input,16,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getLeftCurlyBracketKeyword_3_0_0()); 
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
    // $ANTLR end "rule__Attribute2__Group_3_0__0__Impl"


    // $ANTLR start "rule__Attribute2__Group_3_0__1"
    // InternalBug304681TestLanguage.g:2801:1: rule__Attribute2__Group_3_0__1 : rule__Attribute2__Group_3_0__1__Impl rule__Attribute2__Group_3_0__2 ;
    public final void rule__Attribute2__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2805:1: ( rule__Attribute2__Group_3_0__1__Impl rule__Attribute2__Group_3_0__2 )
            // InternalBug304681TestLanguage.g:2806:2: rule__Attribute2__Group_3_0__1__Impl rule__Attribute2__Group_3_0__2
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Attribute2__Group_3_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__Group_3_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0__1"


    // $ANTLR start "rule__Attribute2__Group_3_0__1__Impl"
    // InternalBug304681TestLanguage.g:2813:1: rule__Attribute2__Group_3_0__1__Impl : ( ( rule__Attribute2__UnorderedGroup_3_0_1 ) ) ;
    public final void rule__Attribute2__Group_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2817:1: ( ( ( rule__Attribute2__UnorderedGroup_3_0_1 ) ) )
            // InternalBug304681TestLanguage.g:2818:1: ( ( rule__Attribute2__UnorderedGroup_3_0_1 ) )
            {
            // InternalBug304681TestLanguage.g:2818:1: ( ( rule__Attribute2__UnorderedGroup_3_0_1 ) )
            // InternalBug304681TestLanguage.g:2819:2: ( rule__Attribute2__UnorderedGroup_3_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1()); 
            }
            // InternalBug304681TestLanguage.g:2820:2: ( rule__Attribute2__UnorderedGroup_3_0_1 )
            // InternalBug304681TestLanguage.g:2820:3: rule__Attribute2__UnorderedGroup_3_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__UnorderedGroup_3_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1()); 
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
    // $ANTLR end "rule__Attribute2__Group_3_0__1__Impl"


    // $ANTLR start "rule__Attribute2__Group_3_0__2"
    // InternalBug304681TestLanguage.g:2828:1: rule__Attribute2__Group_3_0__2 : rule__Attribute2__Group_3_0__2__Impl ;
    public final void rule__Attribute2__Group_3_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2832:1: ( rule__Attribute2__Group_3_0__2__Impl )
            // InternalBug304681TestLanguage.g:2833:2: rule__Attribute2__Group_3_0__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__Group_3_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0__2"


    // $ANTLR start "rule__Attribute2__Group_3_0__2__Impl"
    // InternalBug304681TestLanguage.g:2839:1: rule__Attribute2__Group_3_0__2__Impl : ( '}' ) ;
    public final void rule__Attribute2__Group_3_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2843:1: ( ( '}' ) )
            // InternalBug304681TestLanguage.g:2844:1: ( '}' )
            {
            // InternalBug304681TestLanguage.g:2844:1: ( '}' )
            // InternalBug304681TestLanguage.g:2845:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getRightCurlyBracketKeyword_3_0_2()); 
            }
            match(input,17,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getRightCurlyBracketKeyword_3_0_2()); 
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
    // $ANTLR end "rule__Attribute2__Group_3_0__2__Impl"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_0__0"
    // InternalBug304681TestLanguage.g:2855:1: rule__Attribute2__Group_3_0_1_0__0 : rule__Attribute2__Group_3_0_1_0__0__Impl rule__Attribute2__Group_3_0_1_0__1 ;
    public final void rule__Attribute2__Group_3_0_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2859:1: ( rule__Attribute2__Group_3_0_1_0__0__Impl rule__Attribute2__Group_3_0_1_0__1 )
            // InternalBug304681TestLanguage.g:2860:2: rule__Attribute2__Group_3_0_1_0__0__Impl rule__Attribute2__Group_3_0_1_0__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__Attribute2__Group_3_0_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__Group_3_0_1_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0_1_0__0"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_0__0__Impl"
    // InternalBug304681TestLanguage.g:2867:1: rule__Attribute2__Group_3_0_1_0__0__Impl : ( 'shortDescription' ) ;
    public final void rule__Attribute2__Group_3_0_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2871:1: ( ( 'shortDescription' ) )
            // InternalBug304681TestLanguage.g:2872:1: ( 'shortDescription' )
            {
            // InternalBug304681TestLanguage.g:2872:1: ( 'shortDescription' )
            // InternalBug304681TestLanguage.g:2873:2: 'shortDescription'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getShortDescriptionKeyword_3_0_1_0_0()); 
            }
            match(input,19,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getShortDescriptionKeyword_3_0_1_0_0()); 
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
    // $ANTLR end "rule__Attribute2__Group_3_0_1_0__0__Impl"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_0__1"
    // InternalBug304681TestLanguage.g:2882:1: rule__Attribute2__Group_3_0_1_0__1 : rule__Attribute2__Group_3_0_1_0__1__Impl rule__Attribute2__Group_3_0_1_0__2 ;
    public final void rule__Attribute2__Group_3_0_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2886:1: ( rule__Attribute2__Group_3_0_1_0__1__Impl rule__Attribute2__Group_3_0_1_0__2 )
            // InternalBug304681TestLanguage.g:2887:2: rule__Attribute2__Group_3_0_1_0__1__Impl rule__Attribute2__Group_3_0_1_0__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Attribute2__Group_3_0_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__Group_3_0_1_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0_1_0__1"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_0__1__Impl"
    // InternalBug304681TestLanguage.g:2894:1: rule__Attribute2__Group_3_0_1_0__1__Impl : ( ( rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1 ) ) ;
    public final void rule__Attribute2__Group_3_0_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2898:1: ( ( ( rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1 ) ) )
            // InternalBug304681TestLanguage.g:2899:1: ( ( rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1 ) )
            {
            // InternalBug304681TestLanguage.g:2899:1: ( ( rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1 ) )
            // InternalBug304681TestLanguage.g:2900:2: ( rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getShortDescriptionAssignment_3_0_1_0_1()); 
            }
            // InternalBug304681TestLanguage.g:2901:2: ( rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1 )
            // InternalBug304681TestLanguage.g:2901:3: rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getShortDescriptionAssignment_3_0_1_0_1()); 
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
    // $ANTLR end "rule__Attribute2__Group_3_0_1_0__1__Impl"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_0__2"
    // InternalBug304681TestLanguage.g:2909:1: rule__Attribute2__Group_3_0_1_0__2 : rule__Attribute2__Group_3_0_1_0__2__Impl ;
    public final void rule__Attribute2__Group_3_0_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2913:1: ( rule__Attribute2__Group_3_0_1_0__2__Impl )
            // InternalBug304681TestLanguage.g:2914:2: rule__Attribute2__Group_3_0_1_0__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__Group_3_0_1_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0_1_0__2"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_0__2__Impl"
    // InternalBug304681TestLanguage.g:2920:1: rule__Attribute2__Group_3_0_1_0__2__Impl : ( ';' ) ;
    public final void rule__Attribute2__Group_3_0_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2924:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:2925:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:2925:1: ( ';' )
            // InternalBug304681TestLanguage.g:2926:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getSemicolonKeyword_3_0_1_0_2()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getSemicolonKeyword_3_0_1_0_2()); 
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
    // $ANTLR end "rule__Attribute2__Group_3_0_1_0__2__Impl"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_1__0"
    // InternalBug304681TestLanguage.g:2936:1: rule__Attribute2__Group_3_0_1_1__0 : rule__Attribute2__Group_3_0_1_1__0__Impl rule__Attribute2__Group_3_0_1_1__1 ;
    public final void rule__Attribute2__Group_3_0_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2940:1: ( rule__Attribute2__Group_3_0_1_1__0__Impl rule__Attribute2__Group_3_0_1_1__1 )
            // InternalBug304681TestLanguage.g:2941:2: rule__Attribute2__Group_3_0_1_1__0__Impl rule__Attribute2__Group_3_0_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__Attribute2__Group_3_0_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__Group_3_0_1_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0_1_1__0"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_1__0__Impl"
    // InternalBug304681TestLanguage.g:2948:1: rule__Attribute2__Group_3_0_1_1__0__Impl : ( 'longDescription' ) ;
    public final void rule__Attribute2__Group_3_0_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2952:1: ( ( 'longDescription' ) )
            // InternalBug304681TestLanguage.g:2953:1: ( 'longDescription' )
            {
            // InternalBug304681TestLanguage.g:2953:1: ( 'longDescription' )
            // InternalBug304681TestLanguage.g:2954:2: 'longDescription'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getLongDescriptionKeyword_3_0_1_1_0()); 
            }
            match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getLongDescriptionKeyword_3_0_1_1_0()); 
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
    // $ANTLR end "rule__Attribute2__Group_3_0_1_1__0__Impl"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_1__1"
    // InternalBug304681TestLanguage.g:2963:1: rule__Attribute2__Group_3_0_1_1__1 : rule__Attribute2__Group_3_0_1_1__1__Impl rule__Attribute2__Group_3_0_1_1__2 ;
    public final void rule__Attribute2__Group_3_0_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2967:1: ( rule__Attribute2__Group_3_0_1_1__1__Impl rule__Attribute2__Group_3_0_1_1__2 )
            // InternalBug304681TestLanguage.g:2968:2: rule__Attribute2__Group_3_0_1_1__1__Impl rule__Attribute2__Group_3_0_1_1__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Attribute2__Group_3_0_1_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__Group_3_0_1_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0_1_1__1"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_1__1__Impl"
    // InternalBug304681TestLanguage.g:2975:1: rule__Attribute2__Group_3_0_1_1__1__Impl : ( ( rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1 ) ) ;
    public final void rule__Attribute2__Group_3_0_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2979:1: ( ( ( rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1 ) ) )
            // InternalBug304681TestLanguage.g:2980:1: ( ( rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1 ) )
            {
            // InternalBug304681TestLanguage.g:2980:1: ( ( rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1 ) )
            // InternalBug304681TestLanguage.g:2981:2: ( rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getLongDescriptionAssignment_3_0_1_1_1()); 
            }
            // InternalBug304681TestLanguage.g:2982:2: ( rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1 )
            // InternalBug304681TestLanguage.g:2982:3: rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getLongDescriptionAssignment_3_0_1_1_1()); 
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
    // $ANTLR end "rule__Attribute2__Group_3_0_1_1__1__Impl"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_1__2"
    // InternalBug304681TestLanguage.g:2990:1: rule__Attribute2__Group_3_0_1_1__2 : rule__Attribute2__Group_3_0_1_1__2__Impl ;
    public final void rule__Attribute2__Group_3_0_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2994:1: ( rule__Attribute2__Group_3_0_1_1__2__Impl )
            // InternalBug304681TestLanguage.g:2995:2: rule__Attribute2__Group_3_0_1_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__Group_3_0_1_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0_1_1__2"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_1__2__Impl"
    // InternalBug304681TestLanguage.g:3001:1: rule__Attribute2__Group_3_0_1_1__2__Impl : ( ';' ) ;
    public final void rule__Attribute2__Group_3_0_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3005:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:3006:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:3006:1: ( ';' )
            // InternalBug304681TestLanguage.g:3007:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getSemicolonKeyword_3_0_1_1_2()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getSemicolonKeyword_3_0_1_1_2()); 
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
    // $ANTLR end "rule__Attribute2__Group_3_0_1_1__2__Impl"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_3__0"
    // InternalBug304681TestLanguage.g:3017:1: rule__Attribute2__Group_3_0_1_3__0 : rule__Attribute2__Group_3_0_1_3__0__Impl rule__Attribute2__Group_3_0_1_3__1 ;
    public final void rule__Attribute2__Group_3_0_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3021:1: ( rule__Attribute2__Group_3_0_1_3__0__Impl rule__Attribute2__Group_3_0_1_3__1 )
            // InternalBug304681TestLanguage.g:3022:2: rule__Attribute2__Group_3_0_1_3__0__Impl rule__Attribute2__Group_3_0_1_3__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Attribute2__Group_3_0_1_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__Group_3_0_1_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0_1_3__0"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_3__0__Impl"
    // InternalBug304681TestLanguage.g:3029:1: rule__Attribute2__Group_3_0_1_3__0__Impl : ( ( rule__Attribute2__RequiredAssignment_3_0_1_3_0 ) ) ;
    public final void rule__Attribute2__Group_3_0_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3033:1: ( ( ( rule__Attribute2__RequiredAssignment_3_0_1_3_0 ) ) )
            // InternalBug304681TestLanguage.g:3034:1: ( ( rule__Attribute2__RequiredAssignment_3_0_1_3_0 ) )
            {
            // InternalBug304681TestLanguage.g:3034:1: ( ( rule__Attribute2__RequiredAssignment_3_0_1_3_0 ) )
            // InternalBug304681TestLanguage.g:3035:2: ( rule__Attribute2__RequiredAssignment_3_0_1_3_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getRequiredAssignment_3_0_1_3_0()); 
            }
            // InternalBug304681TestLanguage.g:3036:2: ( rule__Attribute2__RequiredAssignment_3_0_1_3_0 )
            // InternalBug304681TestLanguage.g:3036:3: rule__Attribute2__RequiredAssignment_3_0_1_3_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__RequiredAssignment_3_0_1_3_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getRequiredAssignment_3_0_1_3_0()); 
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
    // $ANTLR end "rule__Attribute2__Group_3_0_1_3__0__Impl"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_3__1"
    // InternalBug304681TestLanguage.g:3044:1: rule__Attribute2__Group_3_0_1_3__1 : rule__Attribute2__Group_3_0_1_3__1__Impl ;
    public final void rule__Attribute2__Group_3_0_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3048:1: ( rule__Attribute2__Group_3_0_1_3__1__Impl )
            // InternalBug304681TestLanguage.g:3049:2: rule__Attribute2__Group_3_0_1_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__Group_3_0_1_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0_1_3__1"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_3__1__Impl"
    // InternalBug304681TestLanguage.g:3055:1: rule__Attribute2__Group_3_0_1_3__1__Impl : ( ';' ) ;
    public final void rule__Attribute2__Group_3_0_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3059:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:3060:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:3060:1: ( ';' )
            // InternalBug304681TestLanguage.g:3061:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getSemicolonKeyword_3_0_1_3_1()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getSemicolonKeyword_3_0_1_3_1()); 
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
    // $ANTLR end "rule__Attribute2__Group_3_0_1_3__1__Impl"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_4__0"
    // InternalBug304681TestLanguage.g:3071:1: rule__Attribute2__Group_3_0_1_4__0 : rule__Attribute2__Group_3_0_1_4__0__Impl rule__Attribute2__Group_3_0_1_4__1 ;
    public final void rule__Attribute2__Group_3_0_1_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3075:1: ( rule__Attribute2__Group_3_0_1_4__0__Impl rule__Attribute2__Group_3_0_1_4__1 )
            // InternalBug304681TestLanguage.g:3076:2: rule__Attribute2__Group_3_0_1_4__0__Impl rule__Attribute2__Group_3_0_1_4__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Attribute2__Group_3_0_1_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__Group_3_0_1_4__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0_1_4__0"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_4__0__Impl"
    // InternalBug304681TestLanguage.g:3083:1: rule__Attribute2__Group_3_0_1_4__0__Impl : ( ( rule__Attribute2__TechnicalAssignment_3_0_1_4_0 ) ) ;
    public final void rule__Attribute2__Group_3_0_1_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3087:1: ( ( ( rule__Attribute2__TechnicalAssignment_3_0_1_4_0 ) ) )
            // InternalBug304681TestLanguage.g:3088:1: ( ( rule__Attribute2__TechnicalAssignment_3_0_1_4_0 ) )
            {
            // InternalBug304681TestLanguage.g:3088:1: ( ( rule__Attribute2__TechnicalAssignment_3_0_1_4_0 ) )
            // InternalBug304681TestLanguage.g:3089:2: ( rule__Attribute2__TechnicalAssignment_3_0_1_4_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getTechnicalAssignment_3_0_1_4_0()); 
            }
            // InternalBug304681TestLanguage.g:3090:2: ( rule__Attribute2__TechnicalAssignment_3_0_1_4_0 )
            // InternalBug304681TestLanguage.g:3090:3: rule__Attribute2__TechnicalAssignment_3_0_1_4_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__TechnicalAssignment_3_0_1_4_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getTechnicalAssignment_3_0_1_4_0()); 
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
    // $ANTLR end "rule__Attribute2__Group_3_0_1_4__0__Impl"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_4__1"
    // InternalBug304681TestLanguage.g:3098:1: rule__Attribute2__Group_3_0_1_4__1 : rule__Attribute2__Group_3_0_1_4__1__Impl ;
    public final void rule__Attribute2__Group_3_0_1_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3102:1: ( rule__Attribute2__Group_3_0_1_4__1__Impl )
            // InternalBug304681TestLanguage.g:3103:2: rule__Attribute2__Group_3_0_1_4__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__Group_3_0_1_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0_1_4__1"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_4__1__Impl"
    // InternalBug304681TestLanguage.g:3109:1: rule__Attribute2__Group_3_0_1_4__1__Impl : ( ';' ) ;
    public final void rule__Attribute2__Group_3_0_1_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3113:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:3114:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:3114:1: ( ';' )
            // InternalBug304681TestLanguage.g:3115:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getSemicolonKeyword_3_0_1_4_1()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getSemicolonKeyword_3_0_1_4_1()); 
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
    // $ANTLR end "rule__Attribute2__Group_3_0_1_4__1__Impl"


    // $ANTLR start "rule__Reference2__Group__0"
    // InternalBug304681TestLanguage.g:3125:1: rule__Reference2__Group__0 : rule__Reference2__Group__0__Impl rule__Reference2__Group__1 ;
    public final void rule__Reference2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3129:1: ( rule__Reference2__Group__0__Impl rule__Reference2__Group__1 )
            // InternalBug304681TestLanguage.g:3130:2: rule__Reference2__Group__0__Impl rule__Reference2__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Reference2__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group__0"


    // $ANTLR start "rule__Reference2__Group__0__Impl"
    // InternalBug304681TestLanguage.g:3137:1: rule__Reference2__Group__0__Impl : ( 'Reference' ) ;
    public final void rule__Reference2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3141:1: ( ( 'Reference' ) )
            // InternalBug304681TestLanguage.g:3142:1: ( 'Reference' )
            {
            // InternalBug304681TestLanguage.g:3142:1: ( 'Reference' )
            // InternalBug304681TestLanguage.g:3143:2: 'Reference'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getReferenceKeyword_0()); 
            }
            match(input,27,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getReferenceKeyword_0()); 
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
    // $ANTLR end "rule__Reference2__Group__0__Impl"


    // $ANTLR start "rule__Reference2__Group__1"
    // InternalBug304681TestLanguage.g:3152:1: rule__Reference2__Group__1 : rule__Reference2__Group__1__Impl rule__Reference2__Group__2 ;
    public final void rule__Reference2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3156:1: ( rule__Reference2__Group__1__Impl rule__Reference2__Group__2 )
            // InternalBug304681TestLanguage.g:3157:2: rule__Reference2__Group__1__Impl rule__Reference2__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__Reference2__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group__1"


    // $ANTLR start "rule__Reference2__Group__1__Impl"
    // InternalBug304681TestLanguage.g:3164:1: rule__Reference2__Group__1__Impl : ( ( rule__Reference2__TypeAssignment_1 ) ) ;
    public final void rule__Reference2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3168:1: ( ( ( rule__Reference2__TypeAssignment_1 ) ) )
            // InternalBug304681TestLanguage.g:3169:1: ( ( rule__Reference2__TypeAssignment_1 ) )
            {
            // InternalBug304681TestLanguage.g:3169:1: ( ( rule__Reference2__TypeAssignment_1 ) )
            // InternalBug304681TestLanguage.g:3170:2: ( rule__Reference2__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getTypeAssignment_1()); 
            }
            // InternalBug304681TestLanguage.g:3171:2: ( rule__Reference2__TypeAssignment_1 )
            // InternalBug304681TestLanguage.g:3171:3: rule__Reference2__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__TypeAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getTypeAssignment_1()); 
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
    // $ANTLR end "rule__Reference2__Group__1__Impl"


    // $ANTLR start "rule__Reference2__Group__2"
    // InternalBug304681TestLanguage.g:3179:1: rule__Reference2__Group__2 : rule__Reference2__Group__2__Impl rule__Reference2__Group__3 ;
    public final void rule__Reference2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3183:1: ( rule__Reference2__Group__2__Impl rule__Reference2__Group__3 )
            // InternalBug304681TestLanguage.g:3184:2: rule__Reference2__Group__2__Impl rule__Reference2__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__Reference2__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group__2"


    // $ANTLR start "rule__Reference2__Group__2__Impl"
    // InternalBug304681TestLanguage.g:3191:1: rule__Reference2__Group__2__Impl : ( ( rule__Reference2__ManyAssignment_2 )? ) ;
    public final void rule__Reference2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3195:1: ( ( ( rule__Reference2__ManyAssignment_2 )? ) )
            // InternalBug304681TestLanguage.g:3196:1: ( ( rule__Reference2__ManyAssignment_2 )? )
            {
            // InternalBug304681TestLanguage.g:3196:1: ( ( rule__Reference2__ManyAssignment_2 )? )
            // InternalBug304681TestLanguage.g:3197:2: ( rule__Reference2__ManyAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getManyAssignment_2()); 
            }
            // InternalBug304681TestLanguage.g:3198:2: ( rule__Reference2__ManyAssignment_2 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==34) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalBug304681TestLanguage.g:3198:3: rule__Reference2__ManyAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Reference2__ManyAssignment_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getManyAssignment_2()); 
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
    // $ANTLR end "rule__Reference2__Group__2__Impl"


    // $ANTLR start "rule__Reference2__Group__3"
    // InternalBug304681TestLanguage.g:3206:1: rule__Reference2__Group__3 : rule__Reference2__Group__3__Impl rule__Reference2__Group__4 ;
    public final void rule__Reference2__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3210:1: ( rule__Reference2__Group__3__Impl rule__Reference2__Group__4 )
            // InternalBug304681TestLanguage.g:3211:2: rule__Reference2__Group__3__Impl rule__Reference2__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_17);
            rule__Reference2__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group__3"


    // $ANTLR start "rule__Reference2__Group__3__Impl"
    // InternalBug304681TestLanguage.g:3218:1: rule__Reference2__Group__3__Impl : ( ( rule__Reference2__NameAssignment_3 ) ) ;
    public final void rule__Reference2__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3222:1: ( ( ( rule__Reference2__NameAssignment_3 ) ) )
            // InternalBug304681TestLanguage.g:3223:1: ( ( rule__Reference2__NameAssignment_3 ) )
            {
            // InternalBug304681TestLanguage.g:3223:1: ( ( rule__Reference2__NameAssignment_3 ) )
            // InternalBug304681TestLanguage.g:3224:2: ( rule__Reference2__NameAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getNameAssignment_3()); 
            }
            // InternalBug304681TestLanguage.g:3225:2: ( rule__Reference2__NameAssignment_3 )
            // InternalBug304681TestLanguage.g:3225:3: rule__Reference2__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__NameAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getNameAssignment_3()); 
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
    // $ANTLR end "rule__Reference2__Group__3__Impl"


    // $ANTLR start "rule__Reference2__Group__4"
    // InternalBug304681TestLanguage.g:3233:1: rule__Reference2__Group__4 : rule__Reference2__Group__4__Impl ;
    public final void rule__Reference2__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3237:1: ( rule__Reference2__Group__4__Impl )
            // InternalBug304681TestLanguage.g:3238:2: rule__Reference2__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group__4"


    // $ANTLR start "rule__Reference2__Group__4__Impl"
    // InternalBug304681TestLanguage.g:3244:1: rule__Reference2__Group__4__Impl : ( ( rule__Reference2__Alternatives_4 ) ) ;
    public final void rule__Reference2__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3248:1: ( ( ( rule__Reference2__Alternatives_4 ) ) )
            // InternalBug304681TestLanguage.g:3249:1: ( ( rule__Reference2__Alternatives_4 ) )
            {
            // InternalBug304681TestLanguage.g:3249:1: ( ( rule__Reference2__Alternatives_4 ) )
            // InternalBug304681TestLanguage.g:3250:2: ( rule__Reference2__Alternatives_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getAlternatives_4()); 
            }
            // InternalBug304681TestLanguage.g:3251:2: ( rule__Reference2__Alternatives_4 )
            // InternalBug304681TestLanguage.g:3251:3: rule__Reference2__Alternatives_4
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Alternatives_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getAlternatives_4()); 
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
    // $ANTLR end "rule__Reference2__Group__4__Impl"


    // $ANTLR start "rule__Reference2__Group_4_0__0"
    // InternalBug304681TestLanguage.g:3260:1: rule__Reference2__Group_4_0__0 : rule__Reference2__Group_4_0__0__Impl rule__Reference2__Group_4_0__1 ;
    public final void rule__Reference2__Group_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3264:1: ( rule__Reference2__Group_4_0__0__Impl rule__Reference2__Group_4_0__1 )
            // InternalBug304681TestLanguage.g:3265:2: rule__Reference2__Group_4_0__0__Impl rule__Reference2__Group_4_0__1
            {
            pushFollow(FollowSets000.FOLLOW_18);
            rule__Reference2__Group_4_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Group_4_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group_4_0__0"


    // $ANTLR start "rule__Reference2__Group_4_0__0__Impl"
    // InternalBug304681TestLanguage.g:3272:1: rule__Reference2__Group_4_0__0__Impl : ( '{' ) ;
    public final void rule__Reference2__Group_4_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3276:1: ( ( '{' ) )
            // InternalBug304681TestLanguage.g:3277:1: ( '{' )
            {
            // InternalBug304681TestLanguage.g:3277:1: ( '{' )
            // InternalBug304681TestLanguage.g:3278:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getLeftCurlyBracketKeyword_4_0_0()); 
            }
            match(input,16,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getLeftCurlyBracketKeyword_4_0_0()); 
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
    // $ANTLR end "rule__Reference2__Group_4_0__0__Impl"


    // $ANTLR start "rule__Reference2__Group_4_0__1"
    // InternalBug304681TestLanguage.g:3287:1: rule__Reference2__Group_4_0__1 : rule__Reference2__Group_4_0__1__Impl rule__Reference2__Group_4_0__2 ;
    public final void rule__Reference2__Group_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3291:1: ( rule__Reference2__Group_4_0__1__Impl rule__Reference2__Group_4_0__2 )
            // InternalBug304681TestLanguage.g:3292:2: rule__Reference2__Group_4_0__1__Impl rule__Reference2__Group_4_0__2
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Reference2__Group_4_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Group_4_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group_4_0__1"


    // $ANTLR start "rule__Reference2__Group_4_0__1__Impl"
    // InternalBug304681TestLanguage.g:3299:1: rule__Reference2__Group_4_0__1__Impl : ( ( rule__Reference2__UnorderedGroup_4_0_1 ) ) ;
    public final void rule__Reference2__Group_4_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3303:1: ( ( ( rule__Reference2__UnorderedGroup_4_0_1 ) ) )
            // InternalBug304681TestLanguage.g:3304:1: ( ( rule__Reference2__UnorderedGroup_4_0_1 ) )
            {
            // InternalBug304681TestLanguage.g:3304:1: ( ( rule__Reference2__UnorderedGroup_4_0_1 ) )
            // InternalBug304681TestLanguage.g:3305:2: ( rule__Reference2__UnorderedGroup_4_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1()); 
            }
            // InternalBug304681TestLanguage.g:3306:2: ( rule__Reference2__UnorderedGroup_4_0_1 )
            // InternalBug304681TestLanguage.g:3306:3: rule__Reference2__UnorderedGroup_4_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__UnorderedGroup_4_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1()); 
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
    // $ANTLR end "rule__Reference2__Group_4_0__1__Impl"


    // $ANTLR start "rule__Reference2__Group_4_0__2"
    // InternalBug304681TestLanguage.g:3314:1: rule__Reference2__Group_4_0__2 : rule__Reference2__Group_4_0__2__Impl ;
    public final void rule__Reference2__Group_4_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3318:1: ( rule__Reference2__Group_4_0__2__Impl )
            // InternalBug304681TestLanguage.g:3319:2: rule__Reference2__Group_4_0__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Group_4_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group_4_0__2"


    // $ANTLR start "rule__Reference2__Group_4_0__2__Impl"
    // InternalBug304681TestLanguage.g:3325:1: rule__Reference2__Group_4_0__2__Impl : ( '}' ) ;
    public final void rule__Reference2__Group_4_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3329:1: ( ( '}' ) )
            // InternalBug304681TestLanguage.g:3330:1: ( '}' )
            {
            // InternalBug304681TestLanguage.g:3330:1: ( '}' )
            // InternalBug304681TestLanguage.g:3331:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getRightCurlyBracketKeyword_4_0_2()); 
            }
            match(input,17,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getRightCurlyBracketKeyword_4_0_2()); 
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
    // $ANTLR end "rule__Reference2__Group_4_0__2__Impl"


    // $ANTLR start "rule__Reference2__Group_4_0_1_0__0"
    // InternalBug304681TestLanguage.g:3341:1: rule__Reference2__Group_4_0_1_0__0 : rule__Reference2__Group_4_0_1_0__0__Impl rule__Reference2__Group_4_0_1_0__1 ;
    public final void rule__Reference2__Group_4_0_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3345:1: ( rule__Reference2__Group_4_0_1_0__0__Impl rule__Reference2__Group_4_0_1_0__1 )
            // InternalBug304681TestLanguage.g:3346:2: rule__Reference2__Group_4_0_1_0__0__Impl rule__Reference2__Group_4_0_1_0__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__Reference2__Group_4_0_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Group_4_0_1_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group_4_0_1_0__0"


    // $ANTLR start "rule__Reference2__Group_4_0_1_0__0__Impl"
    // InternalBug304681TestLanguage.g:3353:1: rule__Reference2__Group_4_0_1_0__0__Impl : ( 'shortDescription' ) ;
    public final void rule__Reference2__Group_4_0_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3357:1: ( ( 'shortDescription' ) )
            // InternalBug304681TestLanguage.g:3358:1: ( 'shortDescription' )
            {
            // InternalBug304681TestLanguage.g:3358:1: ( 'shortDescription' )
            // InternalBug304681TestLanguage.g:3359:2: 'shortDescription'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getShortDescriptionKeyword_4_0_1_0_0()); 
            }
            match(input,19,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getShortDescriptionKeyword_4_0_1_0_0()); 
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
    // $ANTLR end "rule__Reference2__Group_4_0_1_0__0__Impl"


    // $ANTLR start "rule__Reference2__Group_4_0_1_0__1"
    // InternalBug304681TestLanguage.g:3368:1: rule__Reference2__Group_4_0_1_0__1 : rule__Reference2__Group_4_0_1_0__1__Impl rule__Reference2__Group_4_0_1_0__2 ;
    public final void rule__Reference2__Group_4_0_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3372:1: ( rule__Reference2__Group_4_0_1_0__1__Impl rule__Reference2__Group_4_0_1_0__2 )
            // InternalBug304681TestLanguage.g:3373:2: rule__Reference2__Group_4_0_1_0__1__Impl rule__Reference2__Group_4_0_1_0__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Reference2__Group_4_0_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Group_4_0_1_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group_4_0_1_0__1"


    // $ANTLR start "rule__Reference2__Group_4_0_1_0__1__Impl"
    // InternalBug304681TestLanguage.g:3380:1: rule__Reference2__Group_4_0_1_0__1__Impl : ( ( rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1 ) ) ;
    public final void rule__Reference2__Group_4_0_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3384:1: ( ( ( rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1 ) ) )
            // InternalBug304681TestLanguage.g:3385:1: ( ( rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1 ) )
            {
            // InternalBug304681TestLanguage.g:3385:1: ( ( rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1 ) )
            // InternalBug304681TestLanguage.g:3386:2: ( rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getShortDescriptionAssignment_4_0_1_0_1()); 
            }
            // InternalBug304681TestLanguage.g:3387:2: ( rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1 )
            // InternalBug304681TestLanguage.g:3387:3: rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getShortDescriptionAssignment_4_0_1_0_1()); 
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
    // $ANTLR end "rule__Reference2__Group_4_0_1_0__1__Impl"


    // $ANTLR start "rule__Reference2__Group_4_0_1_0__2"
    // InternalBug304681TestLanguage.g:3395:1: rule__Reference2__Group_4_0_1_0__2 : rule__Reference2__Group_4_0_1_0__2__Impl ;
    public final void rule__Reference2__Group_4_0_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3399:1: ( rule__Reference2__Group_4_0_1_0__2__Impl )
            // InternalBug304681TestLanguage.g:3400:2: rule__Reference2__Group_4_0_1_0__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Group_4_0_1_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group_4_0_1_0__2"


    // $ANTLR start "rule__Reference2__Group_4_0_1_0__2__Impl"
    // InternalBug304681TestLanguage.g:3406:1: rule__Reference2__Group_4_0_1_0__2__Impl : ( ';' ) ;
    public final void rule__Reference2__Group_4_0_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3410:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:3411:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:3411:1: ( ';' )
            // InternalBug304681TestLanguage.g:3412:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getSemicolonKeyword_4_0_1_0_2()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getSemicolonKeyword_4_0_1_0_2()); 
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
    // $ANTLR end "rule__Reference2__Group_4_0_1_0__2__Impl"


    // $ANTLR start "rule__Reference2__Group_4_0_1_1__0"
    // InternalBug304681TestLanguage.g:3422:1: rule__Reference2__Group_4_0_1_1__0 : rule__Reference2__Group_4_0_1_1__0__Impl rule__Reference2__Group_4_0_1_1__1 ;
    public final void rule__Reference2__Group_4_0_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3426:1: ( rule__Reference2__Group_4_0_1_1__0__Impl rule__Reference2__Group_4_0_1_1__1 )
            // InternalBug304681TestLanguage.g:3427:2: rule__Reference2__Group_4_0_1_1__0__Impl rule__Reference2__Group_4_0_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__Reference2__Group_4_0_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Group_4_0_1_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group_4_0_1_1__0"


    // $ANTLR start "rule__Reference2__Group_4_0_1_1__0__Impl"
    // InternalBug304681TestLanguage.g:3434:1: rule__Reference2__Group_4_0_1_1__0__Impl : ( 'longDescription' ) ;
    public final void rule__Reference2__Group_4_0_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3438:1: ( ( 'longDescription' ) )
            // InternalBug304681TestLanguage.g:3439:1: ( 'longDescription' )
            {
            // InternalBug304681TestLanguage.g:3439:1: ( 'longDescription' )
            // InternalBug304681TestLanguage.g:3440:2: 'longDescription'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getLongDescriptionKeyword_4_0_1_1_0()); 
            }
            match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getLongDescriptionKeyword_4_0_1_1_0()); 
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
    // $ANTLR end "rule__Reference2__Group_4_0_1_1__0__Impl"


    // $ANTLR start "rule__Reference2__Group_4_0_1_1__1"
    // InternalBug304681TestLanguage.g:3449:1: rule__Reference2__Group_4_0_1_1__1 : rule__Reference2__Group_4_0_1_1__1__Impl rule__Reference2__Group_4_0_1_1__2 ;
    public final void rule__Reference2__Group_4_0_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3453:1: ( rule__Reference2__Group_4_0_1_1__1__Impl rule__Reference2__Group_4_0_1_1__2 )
            // InternalBug304681TestLanguage.g:3454:2: rule__Reference2__Group_4_0_1_1__1__Impl rule__Reference2__Group_4_0_1_1__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Reference2__Group_4_0_1_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Group_4_0_1_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group_4_0_1_1__1"


    // $ANTLR start "rule__Reference2__Group_4_0_1_1__1__Impl"
    // InternalBug304681TestLanguage.g:3461:1: rule__Reference2__Group_4_0_1_1__1__Impl : ( ( rule__Reference2__LongDescriptionAssignment_4_0_1_1_1 ) ) ;
    public final void rule__Reference2__Group_4_0_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3465:1: ( ( ( rule__Reference2__LongDescriptionAssignment_4_0_1_1_1 ) ) )
            // InternalBug304681TestLanguage.g:3466:1: ( ( rule__Reference2__LongDescriptionAssignment_4_0_1_1_1 ) )
            {
            // InternalBug304681TestLanguage.g:3466:1: ( ( rule__Reference2__LongDescriptionAssignment_4_0_1_1_1 ) )
            // InternalBug304681TestLanguage.g:3467:2: ( rule__Reference2__LongDescriptionAssignment_4_0_1_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getLongDescriptionAssignment_4_0_1_1_1()); 
            }
            // InternalBug304681TestLanguage.g:3468:2: ( rule__Reference2__LongDescriptionAssignment_4_0_1_1_1 )
            // InternalBug304681TestLanguage.g:3468:3: rule__Reference2__LongDescriptionAssignment_4_0_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__LongDescriptionAssignment_4_0_1_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getLongDescriptionAssignment_4_0_1_1_1()); 
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
    // $ANTLR end "rule__Reference2__Group_4_0_1_1__1__Impl"


    // $ANTLR start "rule__Reference2__Group_4_0_1_1__2"
    // InternalBug304681TestLanguage.g:3476:1: rule__Reference2__Group_4_0_1_1__2 : rule__Reference2__Group_4_0_1_1__2__Impl ;
    public final void rule__Reference2__Group_4_0_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3480:1: ( rule__Reference2__Group_4_0_1_1__2__Impl )
            // InternalBug304681TestLanguage.g:3481:2: rule__Reference2__Group_4_0_1_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Group_4_0_1_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group_4_0_1_1__2"


    // $ANTLR start "rule__Reference2__Group_4_0_1_1__2__Impl"
    // InternalBug304681TestLanguage.g:3487:1: rule__Reference2__Group_4_0_1_1__2__Impl : ( ';' ) ;
    public final void rule__Reference2__Group_4_0_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3491:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:3492:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:3492:1: ( ';' )
            // InternalBug304681TestLanguage.g:3493:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getSemicolonKeyword_4_0_1_1_2()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getSemicolonKeyword_4_0_1_1_2()); 
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
    // $ANTLR end "rule__Reference2__Group_4_0_1_1__2__Impl"


    // $ANTLR start "rule__ConstraintDefinition__Group__0"
    // InternalBug304681TestLanguage.g:3503:1: rule__ConstraintDefinition__Group__0 : rule__ConstraintDefinition__Group__0__Impl rule__ConstraintDefinition__Group__1 ;
    public final void rule__ConstraintDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3507:1: ( rule__ConstraintDefinition__Group__0__Impl rule__ConstraintDefinition__Group__1 )
            // InternalBug304681TestLanguage.g:3508:2: rule__ConstraintDefinition__Group__0__Impl rule__ConstraintDefinition__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__ConstraintDefinition__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConstraintDefinition__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__Group__0"


    // $ANTLR start "rule__ConstraintDefinition__Group__0__Impl"
    // InternalBug304681TestLanguage.g:3515:1: rule__ConstraintDefinition__Group__0__Impl : ( 'constraint' ) ;
    public final void rule__ConstraintDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3519:1: ( ( 'constraint' ) )
            // InternalBug304681TestLanguage.g:3520:1: ( 'constraint' )
            {
            // InternalBug304681TestLanguage.g:3520:1: ( 'constraint' )
            // InternalBug304681TestLanguage.g:3521:2: 'constraint'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintDefinitionAccess().getConstraintKeyword_0()); 
            }
            match(input,28,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintDefinitionAccess().getConstraintKeyword_0()); 
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
    // $ANTLR end "rule__ConstraintDefinition__Group__0__Impl"


    // $ANTLR start "rule__ConstraintDefinition__Group__1"
    // InternalBug304681TestLanguage.g:3530:1: rule__ConstraintDefinition__Group__1 : rule__ConstraintDefinition__Group__1__Impl rule__ConstraintDefinition__Group__2 ;
    public final void rule__ConstraintDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3534:1: ( rule__ConstraintDefinition__Group__1__Impl rule__ConstraintDefinition__Group__2 )
            // InternalBug304681TestLanguage.g:3535:2: rule__ConstraintDefinition__Group__1__Impl rule__ConstraintDefinition__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_21);
            rule__ConstraintDefinition__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConstraintDefinition__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__Group__1"


    // $ANTLR start "rule__ConstraintDefinition__Group__1__Impl"
    // InternalBug304681TestLanguage.g:3542:1: rule__ConstraintDefinition__Group__1__Impl : ( ( rule__ConstraintDefinition__TypeAssignment_1 ) ) ;
    public final void rule__ConstraintDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3546:1: ( ( ( rule__ConstraintDefinition__TypeAssignment_1 ) ) )
            // InternalBug304681TestLanguage.g:3547:1: ( ( rule__ConstraintDefinition__TypeAssignment_1 ) )
            {
            // InternalBug304681TestLanguage.g:3547:1: ( ( rule__ConstraintDefinition__TypeAssignment_1 ) )
            // InternalBug304681TestLanguage.g:3548:2: ( rule__ConstraintDefinition__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintDefinitionAccess().getTypeAssignment_1()); 
            }
            // InternalBug304681TestLanguage.g:3549:2: ( rule__ConstraintDefinition__TypeAssignment_1 )
            // InternalBug304681TestLanguage.g:3549:3: rule__ConstraintDefinition__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConstraintDefinition__TypeAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintDefinitionAccess().getTypeAssignment_1()); 
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
    // $ANTLR end "rule__ConstraintDefinition__Group__1__Impl"


    // $ANTLR start "rule__ConstraintDefinition__Group__2"
    // InternalBug304681TestLanguage.g:3557:1: rule__ConstraintDefinition__Group__2 : rule__ConstraintDefinition__Group__2__Impl rule__ConstraintDefinition__Group__3 ;
    public final void rule__ConstraintDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3561:1: ( rule__ConstraintDefinition__Group__2__Impl rule__ConstraintDefinition__Group__3 )
            // InternalBug304681TestLanguage.g:3562:2: rule__ConstraintDefinition__Group__2__Impl rule__ConstraintDefinition__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_22);
            rule__ConstraintDefinition__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConstraintDefinition__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__Group__2"


    // $ANTLR start "rule__ConstraintDefinition__Group__2__Impl"
    // InternalBug304681TestLanguage.g:3569:1: rule__ConstraintDefinition__Group__2__Impl : ( '{' ) ;
    public final void rule__ConstraintDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3573:1: ( ( '{' ) )
            // InternalBug304681TestLanguage.g:3574:1: ( '{' )
            {
            // InternalBug304681TestLanguage.g:3574:1: ( '{' )
            // InternalBug304681TestLanguage.g:3575:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintDefinitionAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,16,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintDefinitionAccess().getLeftCurlyBracketKeyword_2()); 
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
    // $ANTLR end "rule__ConstraintDefinition__Group__2__Impl"


    // $ANTLR start "rule__ConstraintDefinition__Group__3"
    // InternalBug304681TestLanguage.g:3584:1: rule__ConstraintDefinition__Group__3 : rule__ConstraintDefinition__Group__3__Impl rule__ConstraintDefinition__Group__4 ;
    public final void rule__ConstraintDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3588:1: ( rule__ConstraintDefinition__Group__3__Impl rule__ConstraintDefinition__Group__4 )
            // InternalBug304681TestLanguage.g:3589:2: rule__ConstraintDefinition__Group__3__Impl rule__ConstraintDefinition__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__ConstraintDefinition__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConstraintDefinition__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__Group__3"


    // $ANTLR start "rule__ConstraintDefinition__Group__3__Impl"
    // InternalBug304681TestLanguage.g:3596:1: rule__ConstraintDefinition__Group__3__Impl : ( ( rule__ConstraintDefinition__UnorderedGroup_3 ) ) ;
    public final void rule__ConstraintDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3600:1: ( ( ( rule__ConstraintDefinition__UnorderedGroup_3 ) ) )
            // InternalBug304681TestLanguage.g:3601:1: ( ( rule__ConstraintDefinition__UnorderedGroup_3 ) )
            {
            // InternalBug304681TestLanguage.g:3601:1: ( ( rule__ConstraintDefinition__UnorderedGroup_3 ) )
            // InternalBug304681TestLanguage.g:3602:2: ( rule__ConstraintDefinition__UnorderedGroup_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3()); 
            }
            // InternalBug304681TestLanguage.g:3603:2: ( rule__ConstraintDefinition__UnorderedGroup_3 )
            // InternalBug304681TestLanguage.g:3603:3: rule__ConstraintDefinition__UnorderedGroup_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConstraintDefinition__UnorderedGroup_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3()); 
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
    // $ANTLR end "rule__ConstraintDefinition__Group__3__Impl"


    // $ANTLR start "rule__ConstraintDefinition__Group__4"
    // InternalBug304681TestLanguage.g:3611:1: rule__ConstraintDefinition__Group__4 : rule__ConstraintDefinition__Group__4__Impl ;
    public final void rule__ConstraintDefinition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3615:1: ( rule__ConstraintDefinition__Group__4__Impl )
            // InternalBug304681TestLanguage.g:3616:2: rule__ConstraintDefinition__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConstraintDefinition__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__Group__4"


    // $ANTLR start "rule__ConstraintDefinition__Group__4__Impl"
    // InternalBug304681TestLanguage.g:3622:1: rule__ConstraintDefinition__Group__4__Impl : ( '}' ) ;
    public final void rule__ConstraintDefinition__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3626:1: ( ( '}' ) )
            // InternalBug304681TestLanguage.g:3627:1: ( '}' )
            {
            // InternalBug304681TestLanguage.g:3627:1: ( '}' )
            // InternalBug304681TestLanguage.g:3628:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintDefinitionAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,17,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintDefinitionAccess().getRightCurlyBracketKeyword_4()); 
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
    // $ANTLR end "rule__ConstraintDefinition__Group__4__Impl"


    // $ANTLR start "rule__ConstraintDefinition__Group_3_0__0"
    // InternalBug304681TestLanguage.g:3638:1: rule__ConstraintDefinition__Group_3_0__0 : rule__ConstraintDefinition__Group_3_0__0__Impl rule__ConstraintDefinition__Group_3_0__1 ;
    public final void rule__ConstraintDefinition__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3642:1: ( rule__ConstraintDefinition__Group_3_0__0__Impl rule__ConstraintDefinition__Group_3_0__1 )
            // InternalBug304681TestLanguage.g:3643:2: rule__ConstraintDefinition__Group_3_0__0__Impl rule__ConstraintDefinition__Group_3_0__1
            {
            pushFollow(FollowSets000.FOLLOW_23);
            rule__ConstraintDefinition__Group_3_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConstraintDefinition__Group_3_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__Group_3_0__0"


    // $ANTLR start "rule__ConstraintDefinition__Group_3_0__0__Impl"
    // InternalBug304681TestLanguage.g:3650:1: rule__ConstraintDefinition__Group_3_0__0__Impl : ( 'parameters' ) ;
    public final void rule__ConstraintDefinition__Group_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3654:1: ( ( 'parameters' ) )
            // InternalBug304681TestLanguage.g:3655:1: ( 'parameters' )
            {
            // InternalBug304681TestLanguage.g:3655:1: ( 'parameters' )
            // InternalBug304681TestLanguage.g:3656:2: 'parameters'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintDefinitionAccess().getParametersKeyword_3_0_0()); 
            }
            match(input,29,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintDefinitionAccess().getParametersKeyword_3_0_0()); 
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
    // $ANTLR end "rule__ConstraintDefinition__Group_3_0__0__Impl"


    // $ANTLR start "rule__ConstraintDefinition__Group_3_0__1"
    // InternalBug304681TestLanguage.g:3665:1: rule__ConstraintDefinition__Group_3_0__1 : rule__ConstraintDefinition__Group_3_0__1__Impl rule__ConstraintDefinition__Group_3_0__2 ;
    public final void rule__ConstraintDefinition__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3669:1: ( rule__ConstraintDefinition__Group_3_0__1__Impl rule__ConstraintDefinition__Group_3_0__2 )
            // InternalBug304681TestLanguage.g:3670:2: rule__ConstraintDefinition__Group_3_0__1__Impl rule__ConstraintDefinition__Group_3_0__2
            {
            pushFollow(FollowSets000.FOLLOW_23);
            rule__ConstraintDefinition__Group_3_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConstraintDefinition__Group_3_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__Group_3_0__1"


    // $ANTLR start "rule__ConstraintDefinition__Group_3_0__1__Impl"
    // InternalBug304681TestLanguage.g:3677:1: rule__ConstraintDefinition__Group_3_0__1__Impl : ( ( rule__ConstraintDefinition__ParametersAssignment_3_0_1 )* ) ;
    public final void rule__ConstraintDefinition__Group_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3681:1: ( ( ( rule__ConstraintDefinition__ParametersAssignment_3_0_1 )* ) )
            // InternalBug304681TestLanguage.g:3682:1: ( ( rule__ConstraintDefinition__ParametersAssignment_3_0_1 )* )
            {
            // InternalBug304681TestLanguage.g:3682:1: ( ( rule__ConstraintDefinition__ParametersAssignment_3_0_1 )* )
            // InternalBug304681TestLanguage.g:3683:2: ( rule__ConstraintDefinition__ParametersAssignment_3_0_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintDefinitionAccess().getParametersAssignment_3_0_1()); 
            }
            // InternalBug304681TestLanguage.g:3684:2: ( rule__ConstraintDefinition__ParametersAssignment_3_0_1 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_STRING) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalBug304681TestLanguage.g:3684:3: rule__ConstraintDefinition__ParametersAssignment_3_0_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_24);
            	    rule__ConstraintDefinition__ParametersAssignment_3_0_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintDefinitionAccess().getParametersAssignment_3_0_1()); 
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
    // $ANTLR end "rule__ConstraintDefinition__Group_3_0__1__Impl"


    // $ANTLR start "rule__ConstraintDefinition__Group_3_0__2"
    // InternalBug304681TestLanguage.g:3692:1: rule__ConstraintDefinition__Group_3_0__2 : rule__ConstraintDefinition__Group_3_0__2__Impl ;
    public final void rule__ConstraintDefinition__Group_3_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3696:1: ( rule__ConstraintDefinition__Group_3_0__2__Impl )
            // InternalBug304681TestLanguage.g:3697:2: rule__ConstraintDefinition__Group_3_0__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConstraintDefinition__Group_3_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__Group_3_0__2"


    // $ANTLR start "rule__ConstraintDefinition__Group_3_0__2__Impl"
    // InternalBug304681TestLanguage.g:3703:1: rule__ConstraintDefinition__Group_3_0__2__Impl : ( ';' ) ;
    public final void rule__ConstraintDefinition__Group_3_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3707:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:3708:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:3708:1: ( ';' )
            // InternalBug304681TestLanguage.g:3709:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintDefinitionAccess().getSemicolonKeyword_3_0_2()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintDefinitionAccess().getSemicolonKeyword_3_0_2()); 
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
    // $ANTLR end "rule__ConstraintDefinition__Group_3_0__2__Impl"


    // $ANTLR start "rule__ConstraintDefinition__Group_3_1__0"
    // InternalBug304681TestLanguage.g:3719:1: rule__ConstraintDefinition__Group_3_1__0 : rule__ConstraintDefinition__Group_3_1__0__Impl rule__ConstraintDefinition__Group_3_1__1 ;
    public final void rule__ConstraintDefinition__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3723:1: ( rule__ConstraintDefinition__Group_3_1__0__Impl rule__ConstraintDefinition__Group_3_1__1 )
            // InternalBug304681TestLanguage.g:3724:2: rule__ConstraintDefinition__Group_3_1__0__Impl rule__ConstraintDefinition__Group_3_1__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__ConstraintDefinition__Group_3_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConstraintDefinition__Group_3_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__Group_3_1__0"


    // $ANTLR start "rule__ConstraintDefinition__Group_3_1__0__Impl"
    // InternalBug304681TestLanguage.g:3731:1: rule__ConstraintDefinition__Group_3_1__0__Impl : ( 'message' ) ;
    public final void rule__ConstraintDefinition__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3735:1: ( ( 'message' ) )
            // InternalBug304681TestLanguage.g:3736:1: ( 'message' )
            {
            // InternalBug304681TestLanguage.g:3736:1: ( 'message' )
            // InternalBug304681TestLanguage.g:3737:2: 'message'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintDefinitionAccess().getMessageKeyword_3_1_0()); 
            }
            match(input,30,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintDefinitionAccess().getMessageKeyword_3_1_0()); 
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
    // $ANTLR end "rule__ConstraintDefinition__Group_3_1__0__Impl"


    // $ANTLR start "rule__ConstraintDefinition__Group_3_1__1"
    // InternalBug304681TestLanguage.g:3746:1: rule__ConstraintDefinition__Group_3_1__1 : rule__ConstraintDefinition__Group_3_1__1__Impl rule__ConstraintDefinition__Group_3_1__2 ;
    public final void rule__ConstraintDefinition__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3750:1: ( rule__ConstraintDefinition__Group_3_1__1__Impl rule__ConstraintDefinition__Group_3_1__2 )
            // InternalBug304681TestLanguage.g:3751:2: rule__ConstraintDefinition__Group_3_1__1__Impl rule__ConstraintDefinition__Group_3_1__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__ConstraintDefinition__Group_3_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConstraintDefinition__Group_3_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__Group_3_1__1"


    // $ANTLR start "rule__ConstraintDefinition__Group_3_1__1__Impl"
    // InternalBug304681TestLanguage.g:3758:1: rule__ConstraintDefinition__Group_3_1__1__Impl : ( ( rule__ConstraintDefinition__MessageAssignment_3_1_1 ) ) ;
    public final void rule__ConstraintDefinition__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3762:1: ( ( ( rule__ConstraintDefinition__MessageAssignment_3_1_1 ) ) )
            // InternalBug304681TestLanguage.g:3763:1: ( ( rule__ConstraintDefinition__MessageAssignment_3_1_1 ) )
            {
            // InternalBug304681TestLanguage.g:3763:1: ( ( rule__ConstraintDefinition__MessageAssignment_3_1_1 ) )
            // InternalBug304681TestLanguage.g:3764:2: ( rule__ConstraintDefinition__MessageAssignment_3_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintDefinitionAccess().getMessageAssignment_3_1_1()); 
            }
            // InternalBug304681TestLanguage.g:3765:2: ( rule__ConstraintDefinition__MessageAssignment_3_1_1 )
            // InternalBug304681TestLanguage.g:3765:3: rule__ConstraintDefinition__MessageAssignment_3_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConstraintDefinition__MessageAssignment_3_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintDefinitionAccess().getMessageAssignment_3_1_1()); 
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
    // $ANTLR end "rule__ConstraintDefinition__Group_3_1__1__Impl"


    // $ANTLR start "rule__ConstraintDefinition__Group_3_1__2"
    // InternalBug304681TestLanguage.g:3773:1: rule__ConstraintDefinition__Group_3_1__2 : rule__ConstraintDefinition__Group_3_1__2__Impl ;
    public final void rule__ConstraintDefinition__Group_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3777:1: ( rule__ConstraintDefinition__Group_3_1__2__Impl )
            // InternalBug304681TestLanguage.g:3778:2: rule__ConstraintDefinition__Group_3_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConstraintDefinition__Group_3_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__Group_3_1__2"


    // $ANTLR start "rule__ConstraintDefinition__Group_3_1__2__Impl"
    // InternalBug304681TestLanguage.g:3784:1: rule__ConstraintDefinition__Group_3_1__2__Impl : ( ';' ) ;
    public final void rule__ConstraintDefinition__Group_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3788:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:3789:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:3789:1: ( ';' )
            // InternalBug304681TestLanguage.g:3790:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintDefinitionAccess().getSemicolonKeyword_3_1_2()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintDefinitionAccess().getSemicolonKeyword_3_1_2()); 
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
    // $ANTLR end "rule__ConstraintDefinition__Group_3_1__2__Impl"


    // $ANTLR start "rule__Object__UnorderedGroup_5"
    // InternalBug304681TestLanguage.g:3800:1: rule__Object__UnorderedGroup_5 : ( rule__Object__UnorderedGroup_5__0 )? ;
    public final void rule__Object__UnorderedGroup_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getObjectAccess().getUnorderedGroup_5());
        	
        try {
            // InternalBug304681TestLanguage.g:3805:1: ( ( rule__Object__UnorderedGroup_5__0 )? )
            // InternalBug304681TestLanguage.g:3806:2: ( rule__Object__UnorderedGroup_5__0 )?
            {
            // InternalBug304681TestLanguage.g:3806:2: ( rule__Object__UnorderedGroup_5__0 )?
            int alt21=2;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Object__UnorderedGroup_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object__UnorderedGroup_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getObjectAccess().getUnorderedGroup_5());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__UnorderedGroup_5"


    // $ANTLR start "rule__Object__UnorderedGroup_5__Impl"
    // InternalBug304681TestLanguage.g:3814:1: rule__Object__UnorderedGroup_5__Impl : ( ({...}? => ( ( ( rule__Object__Group_5_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_5__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_6__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_7__0 ) ) ) ) ) ;
    public final void rule__Object__UnorderedGroup_5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
        	
        try {
            // InternalBug304681TestLanguage.g:3819:1: ( ( ({...}? => ( ( ( rule__Object__Group_5_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_5__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_6__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_7__0 ) ) ) ) ) )
            // InternalBug304681TestLanguage.g:3820:3: ( ({...}? => ( ( ( rule__Object__Group_5_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_5__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_6__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_7__0 ) ) ) ) )
            {
            // InternalBug304681TestLanguage.g:3820:3: ( ({...}? => ( ( ( rule__Object__Group_5_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_5__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_6__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_7__0 ) ) ) ) )
            int alt23=8;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // InternalBug304681TestLanguage.g:3821:3: ({...}? => ( ( ( rule__Object__Group_5_0__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:3821:3: ({...}? => ( ( ( rule__Object__Group_5_0__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:3822:4: {...}? => ( ( ( rule__Object__Group_5_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Object__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0)");
                    }
                    // InternalBug304681TestLanguage.g:3822:102: ( ( ( rule__Object__Group_5_0__0 ) ) )
                    // InternalBug304681TestLanguage.g:3823:5: ( ( rule__Object__Group_5_0__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0);
                    selected = true;
                    // InternalBug304681TestLanguage.g:3829:5: ( ( rule__Object__Group_5_0__0 ) )
                    // InternalBug304681TestLanguage.g:3830:6: ( rule__Object__Group_5_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectAccess().getGroup_5_0()); 
                    }
                    // InternalBug304681TestLanguage.g:3831:6: ( rule__Object__Group_5_0__0 )
                    // InternalBug304681TestLanguage.g:3831:7: rule__Object__Group_5_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object__Group_5_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectAccess().getGroup_5_0()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBug304681TestLanguage.g:3836:3: ({...}? => ( ( ( rule__Object__Group_5_1__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:3836:3: ({...}? => ( ( ( rule__Object__Group_5_1__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:3837:4: {...}? => ( ( ( rule__Object__Group_5_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Object__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1)");
                    }
                    // InternalBug304681TestLanguage.g:3837:102: ( ( ( rule__Object__Group_5_1__0 ) ) )
                    // InternalBug304681TestLanguage.g:3838:5: ( ( rule__Object__Group_5_1__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1);
                    selected = true;
                    // InternalBug304681TestLanguage.g:3844:5: ( ( rule__Object__Group_5_1__0 ) )
                    // InternalBug304681TestLanguage.g:3845:6: ( rule__Object__Group_5_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectAccess().getGroup_5_1()); 
                    }
                    // InternalBug304681TestLanguage.g:3846:6: ( rule__Object__Group_5_1__0 )
                    // InternalBug304681TestLanguage.g:3846:7: rule__Object__Group_5_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object__Group_5_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectAccess().getGroup_5_1()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalBug304681TestLanguage.g:3851:3: ({...}? => ( ( ( rule__Object__Group_5_2__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:3851:3: ({...}? => ( ( ( rule__Object__Group_5_2__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:3852:4: {...}? => ( ( ( rule__Object__Group_5_2__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Object__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2)");
                    }
                    // InternalBug304681TestLanguage.g:3852:102: ( ( ( rule__Object__Group_5_2__0 ) ) )
                    // InternalBug304681TestLanguage.g:3853:5: ( ( rule__Object__Group_5_2__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2);
                    selected = true;
                    // InternalBug304681TestLanguage.g:3859:5: ( ( rule__Object__Group_5_2__0 ) )
                    // InternalBug304681TestLanguage.g:3860:6: ( rule__Object__Group_5_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectAccess().getGroup_5_2()); 
                    }
                    // InternalBug304681TestLanguage.g:3861:6: ( rule__Object__Group_5_2__0 )
                    // InternalBug304681TestLanguage.g:3861:7: rule__Object__Group_5_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object__Group_5_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectAccess().getGroup_5_2()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalBug304681TestLanguage.g:3866:3: ({...}? => ( ( ( rule__Object__Group_5_3__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:3866:3: ({...}? => ( ( ( rule__Object__Group_5_3__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:3867:4: {...}? => ( ( ( rule__Object__Group_5_3__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Object__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3)");
                    }
                    // InternalBug304681TestLanguage.g:3867:102: ( ( ( rule__Object__Group_5_3__0 ) ) )
                    // InternalBug304681TestLanguage.g:3868:5: ( ( rule__Object__Group_5_3__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3);
                    selected = true;
                    // InternalBug304681TestLanguage.g:3874:5: ( ( rule__Object__Group_5_3__0 ) )
                    // InternalBug304681TestLanguage.g:3875:6: ( rule__Object__Group_5_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectAccess().getGroup_5_3()); 
                    }
                    // InternalBug304681TestLanguage.g:3876:6: ( rule__Object__Group_5_3__0 )
                    // InternalBug304681TestLanguage.g:3876:7: rule__Object__Group_5_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object__Group_5_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectAccess().getGroup_5_3()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalBug304681TestLanguage.g:3881:3: ({...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:3881:3: ({...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* ) ) ) )
                    // InternalBug304681TestLanguage.g:3882:4: {...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Object__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4)");
                    }
                    // InternalBug304681TestLanguage.g:3882:102: ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* ) ) )
                    // InternalBug304681TestLanguage.g:3883:5: ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4);
                    selected = true;
                    // InternalBug304681TestLanguage.g:3889:5: ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* ) )
                    // InternalBug304681TestLanguage.g:3890:6: ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* )
                    {
                    // InternalBug304681TestLanguage.g:3890:6: ( ( rule__Object__FeaturesAssignment_5_4 ) )
                    // InternalBug304681TestLanguage.g:3891:7: ( rule__Object__FeaturesAssignment_5_4 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectAccess().getFeaturesAssignment_5_4()); 
                    }
                    // InternalBug304681TestLanguage.g:3892:7: ( rule__Object__FeaturesAssignment_5_4 )
                    // InternalBug304681TestLanguage.g:3892:8: rule__Object__FeaturesAssignment_5_4
                    {
                    pushFollow(FollowSets000.FOLLOW_14);
                    rule__Object__FeaturesAssignment_5_4();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectAccess().getFeaturesAssignment_5_4()); 
                    }

                    }

                    // InternalBug304681TestLanguage.g:3895:6: ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* )
                    // InternalBug304681TestLanguage.g:3896:7: ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )*
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectAccess().getFeaturesAssignment_5_4()); 
                    }
                    // InternalBug304681TestLanguage.g:3897:7: ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )*
                    loop22:
                    do {
                        int alt22=2;
                        alt22 = dfa22.predict(input);
                        switch (alt22) {
                    	case 1 :
                    	    // InternalBug304681TestLanguage.g:3897:8: ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4
                    	    {
                    	    pushFollow(FollowSets000.FOLLOW_14);
                    	    rule__Object__FeaturesAssignment_5_4();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectAccess().getFeaturesAssignment_5_4()); 
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalBug304681TestLanguage.g:3903:3: ({...}? => ( ( ( rule__Object__Group_5_5__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:3903:3: ({...}? => ( ( ( rule__Object__Group_5_5__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:3904:4: {...}? => ( ( ( rule__Object__Group_5_5__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Object__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5)");
                    }
                    // InternalBug304681TestLanguage.g:3904:102: ( ( ( rule__Object__Group_5_5__0 ) ) )
                    // InternalBug304681TestLanguage.g:3905:5: ( ( rule__Object__Group_5_5__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5);
                    selected = true;
                    // InternalBug304681TestLanguage.g:3911:5: ( ( rule__Object__Group_5_5__0 ) )
                    // InternalBug304681TestLanguage.g:3912:6: ( rule__Object__Group_5_5__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectAccess().getGroup_5_5()); 
                    }
                    // InternalBug304681TestLanguage.g:3913:6: ( rule__Object__Group_5_5__0 )
                    // InternalBug304681TestLanguage.g:3913:7: rule__Object__Group_5_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object__Group_5_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectAccess().getGroup_5_5()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalBug304681TestLanguage.g:3918:3: ({...}? => ( ( ( rule__Object__Group_5_6__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:3918:3: ({...}? => ( ( ( rule__Object__Group_5_6__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:3919:4: {...}? => ( ( ( rule__Object__Group_5_6__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Object__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6)");
                    }
                    // InternalBug304681TestLanguage.g:3919:102: ( ( ( rule__Object__Group_5_6__0 ) ) )
                    // InternalBug304681TestLanguage.g:3920:5: ( ( rule__Object__Group_5_6__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6);
                    selected = true;
                    // InternalBug304681TestLanguage.g:3926:5: ( ( rule__Object__Group_5_6__0 ) )
                    // InternalBug304681TestLanguage.g:3927:6: ( rule__Object__Group_5_6__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectAccess().getGroup_5_6()); 
                    }
                    // InternalBug304681TestLanguage.g:3928:6: ( rule__Object__Group_5_6__0 )
                    // InternalBug304681TestLanguage.g:3928:7: rule__Object__Group_5_6__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object__Group_5_6__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectAccess().getGroup_5_6()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalBug304681TestLanguage.g:3933:3: ({...}? => ( ( ( rule__Object__Group_5_7__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:3933:3: ({...}? => ( ( ( rule__Object__Group_5_7__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:3934:4: {...}? => ( ( ( rule__Object__Group_5_7__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Object__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7)");
                    }
                    // InternalBug304681TestLanguage.g:3934:102: ( ( ( rule__Object__Group_5_7__0 ) ) )
                    // InternalBug304681TestLanguage.g:3935:5: ( ( rule__Object__Group_5_7__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7);
                    selected = true;
                    // InternalBug304681TestLanguage.g:3941:5: ( ( rule__Object__Group_5_7__0 ) )
                    // InternalBug304681TestLanguage.g:3942:6: ( rule__Object__Group_5_7__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectAccess().getGroup_5_7()); 
                    }
                    // InternalBug304681TestLanguage.g:3943:6: ( rule__Object__Group_5_7__0 )
                    // InternalBug304681TestLanguage.g:3943:7: rule__Object__Group_5_7__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object__Group_5_7__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectAccess().getGroup_5_7()); 
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__UnorderedGroup_5__Impl"


    // $ANTLR start "rule__Object__UnorderedGroup_5__0"
    // InternalBug304681TestLanguage.g:3956:1: rule__Object__UnorderedGroup_5__0 : rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__1 )? ;
    public final void rule__Object__UnorderedGroup_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3960:1: ( rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__1 )? )
            // InternalBug304681TestLanguage.g:3961:2: rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_25);
            rule__Object__UnorderedGroup_5__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBug304681TestLanguage.g:3962:2: ( rule__Object__UnorderedGroup_5__1 )?
            int alt24=2;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Object__UnorderedGroup_5__1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object__UnorderedGroup_5__1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__UnorderedGroup_5__0"


    // $ANTLR start "rule__Object__UnorderedGroup_5__1"
    // InternalBug304681TestLanguage.g:3968:1: rule__Object__UnorderedGroup_5__1 : rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__2 )? ;
    public final void rule__Object__UnorderedGroup_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3972:1: ( rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__2 )? )
            // InternalBug304681TestLanguage.g:3973:2: rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__2 )?
            {
            pushFollow(FollowSets000.FOLLOW_25);
            rule__Object__UnorderedGroup_5__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBug304681TestLanguage.g:3974:2: ( rule__Object__UnorderedGroup_5__2 )?
            int alt25=2;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Object__UnorderedGroup_5__2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object__UnorderedGroup_5__2();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__UnorderedGroup_5__1"


    // $ANTLR start "rule__Object__UnorderedGroup_5__2"
    // InternalBug304681TestLanguage.g:3980:1: rule__Object__UnorderedGroup_5__2 : rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__3 )? ;
    public final void rule__Object__UnorderedGroup_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3984:1: ( rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__3 )? )
            // InternalBug304681TestLanguage.g:3985:2: rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__3 )?
            {
            pushFollow(FollowSets000.FOLLOW_25);
            rule__Object__UnorderedGroup_5__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBug304681TestLanguage.g:3986:2: ( rule__Object__UnorderedGroup_5__3 )?
            int alt26=2;
            alt26 = dfa26.predict(input);
            switch (alt26) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Object__UnorderedGroup_5__3
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object__UnorderedGroup_5__3();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__UnorderedGroup_5__2"


    // $ANTLR start "rule__Object__UnorderedGroup_5__3"
    // InternalBug304681TestLanguage.g:3992:1: rule__Object__UnorderedGroup_5__3 : rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__4 )? ;
    public final void rule__Object__UnorderedGroup_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3996:1: ( rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__4 )? )
            // InternalBug304681TestLanguage.g:3997:2: rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__4 )?
            {
            pushFollow(FollowSets000.FOLLOW_25);
            rule__Object__UnorderedGroup_5__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBug304681TestLanguage.g:3998:2: ( rule__Object__UnorderedGroup_5__4 )?
            int alt27=2;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Object__UnorderedGroup_5__4
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object__UnorderedGroup_5__4();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__UnorderedGroup_5__3"


    // $ANTLR start "rule__Object__UnorderedGroup_5__4"
    // InternalBug304681TestLanguage.g:4004:1: rule__Object__UnorderedGroup_5__4 : rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__5 )? ;
    public final void rule__Object__UnorderedGroup_5__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4008:1: ( rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__5 )? )
            // InternalBug304681TestLanguage.g:4009:2: rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__5 )?
            {
            pushFollow(FollowSets000.FOLLOW_25);
            rule__Object__UnorderedGroup_5__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBug304681TestLanguage.g:4010:2: ( rule__Object__UnorderedGroup_5__5 )?
            int alt28=2;
            alt28 = dfa28.predict(input);
            switch (alt28) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Object__UnorderedGroup_5__5
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object__UnorderedGroup_5__5();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__UnorderedGroup_5__4"


    // $ANTLR start "rule__Object__UnorderedGroup_5__5"
    // InternalBug304681TestLanguage.g:4016:1: rule__Object__UnorderedGroup_5__5 : rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__6 )? ;
    public final void rule__Object__UnorderedGroup_5__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4020:1: ( rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__6 )? )
            // InternalBug304681TestLanguage.g:4021:2: rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__6 )?
            {
            pushFollow(FollowSets000.FOLLOW_25);
            rule__Object__UnorderedGroup_5__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBug304681TestLanguage.g:4022:2: ( rule__Object__UnorderedGroup_5__6 )?
            int alt29=2;
            alt29 = dfa29.predict(input);
            switch (alt29) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Object__UnorderedGroup_5__6
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object__UnorderedGroup_5__6();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__UnorderedGroup_5__5"


    // $ANTLR start "rule__Object__UnorderedGroup_5__6"
    // InternalBug304681TestLanguage.g:4028:1: rule__Object__UnorderedGroup_5__6 : rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__7 )? ;
    public final void rule__Object__UnorderedGroup_5__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4032:1: ( rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__7 )? )
            // InternalBug304681TestLanguage.g:4033:2: rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__7 )?
            {
            pushFollow(FollowSets000.FOLLOW_25);
            rule__Object__UnorderedGroup_5__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBug304681TestLanguage.g:4034:2: ( rule__Object__UnorderedGroup_5__7 )?
            int alt30=2;
            alt30 = dfa30.predict(input);
            switch (alt30) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Object__UnorderedGroup_5__7
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object__UnorderedGroup_5__7();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__UnorderedGroup_5__6"


    // $ANTLR start "rule__Object__UnorderedGroup_5__7"
    // InternalBug304681TestLanguage.g:4040:1: rule__Object__UnorderedGroup_5__7 : rule__Object__UnorderedGroup_5__Impl ;
    public final void rule__Object__UnorderedGroup_5__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4044:1: ( rule__Object__UnorderedGroup_5__Impl )
            // InternalBug304681TestLanguage.g:4045:2: rule__Object__UnorderedGroup_5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__UnorderedGroup_5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__UnorderedGroup_5__7"


    // $ANTLR start "rule__Reference__UnorderedGroup_4_0_1"
    // InternalBug304681TestLanguage.g:4052:1: rule__Reference__UnorderedGroup_4_0_1 : ( rule__Reference__UnorderedGroup_4_0_1__0 )? ;
    public final void rule__Reference__UnorderedGroup_4_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1());
        	
        try {
            // InternalBug304681TestLanguage.g:4057:1: ( ( rule__Reference__UnorderedGroup_4_0_1__0 )? )
            // InternalBug304681TestLanguage.g:4058:2: ( rule__Reference__UnorderedGroup_4_0_1__0 )?
            {
            // InternalBug304681TestLanguage.g:4058:2: ( rule__Reference__UnorderedGroup_4_0_1__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( LA31_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0) ) {
                alt31=1;
            }
            else if ( LA31_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Reference__UnorderedGroup_4_0_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Reference__UnorderedGroup_4_0_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__UnorderedGroup_4_0_1"


    // $ANTLR start "rule__Reference__UnorderedGroup_4_0_1__Impl"
    // InternalBug304681TestLanguage.g:4066:1: rule__Reference__UnorderedGroup_4_0_1__Impl : ( ({...}? => ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Reference__Group_4_0_1_1__0 ) ) ) ) ) ;
    public final void rule__Reference__UnorderedGroup_4_0_1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
        	
        try {
            // InternalBug304681TestLanguage.g:4071:1: ( ( ({...}? => ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Reference__Group_4_0_1_1__0 ) ) ) ) ) )
            // InternalBug304681TestLanguage.g:4072:3: ( ({...}? => ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Reference__Group_4_0_1_1__0 ) ) ) ) )
            {
            // InternalBug304681TestLanguage.g:4072:3: ( ({...}? => ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Reference__Group_4_0_1_1__0 ) ) ) ) )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( LA32_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0) ) {
                alt32=1;
            }
            else if ( LA32_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1) ) {
                alt32=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // InternalBug304681TestLanguage.g:4073:3: ({...}? => ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:4073:3: ({...}? => ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:4074:4: {...}? => ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Reference__UnorderedGroup_4_0_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0)");
                    }
                    // InternalBug304681TestLanguage.g:4074:109: ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) )
                    // InternalBug304681TestLanguage.g:4075:5: ( ( rule__Reference__Group_4_0_1_0__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0);
                    selected = true;
                    // InternalBug304681TestLanguage.g:4081:5: ( ( rule__Reference__Group_4_0_1_0__0 ) )
                    // InternalBug304681TestLanguage.g:4082:6: ( rule__Reference__Group_4_0_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReferenceAccess().getGroup_4_0_1_0()); 
                    }
                    // InternalBug304681TestLanguage.g:4083:6: ( rule__Reference__Group_4_0_1_0__0 )
                    // InternalBug304681TestLanguage.g:4083:7: rule__Reference__Group_4_0_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Reference__Group_4_0_1_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getReferenceAccess().getGroup_4_0_1_0()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBug304681TestLanguage.g:4088:3: ({...}? => ( ( ( rule__Reference__Group_4_0_1_1__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:4088:3: ({...}? => ( ( ( rule__Reference__Group_4_0_1_1__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:4089:4: {...}? => ( ( ( rule__Reference__Group_4_0_1_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Reference__UnorderedGroup_4_0_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1)");
                    }
                    // InternalBug304681TestLanguage.g:4089:109: ( ( ( rule__Reference__Group_4_0_1_1__0 ) ) )
                    // InternalBug304681TestLanguage.g:4090:5: ( ( rule__Reference__Group_4_0_1_1__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1);
                    selected = true;
                    // InternalBug304681TestLanguage.g:4096:5: ( ( rule__Reference__Group_4_0_1_1__0 ) )
                    // InternalBug304681TestLanguage.g:4097:6: ( rule__Reference__Group_4_0_1_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReferenceAccess().getGroup_4_0_1_1()); 
                    }
                    // InternalBug304681TestLanguage.g:4098:6: ( rule__Reference__Group_4_0_1_1__0 )
                    // InternalBug304681TestLanguage.g:4098:7: rule__Reference__Group_4_0_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Reference__Group_4_0_1_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getReferenceAccess().getGroup_4_0_1_1()); 
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__UnorderedGroup_4_0_1__Impl"


    // $ANTLR start "rule__Reference__UnorderedGroup_4_0_1__0"
    // InternalBug304681TestLanguage.g:4111:1: rule__Reference__UnorderedGroup_4_0_1__0 : rule__Reference__UnorderedGroup_4_0_1__Impl ( rule__Reference__UnorderedGroup_4_0_1__1 )? ;
    public final void rule__Reference__UnorderedGroup_4_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4115:1: ( rule__Reference__UnorderedGroup_4_0_1__Impl ( rule__Reference__UnorderedGroup_4_0_1__1 )? )
            // InternalBug304681TestLanguage.g:4116:2: rule__Reference__UnorderedGroup_4_0_1__Impl ( rule__Reference__UnorderedGroup_4_0_1__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_26);
            rule__Reference__UnorderedGroup_4_0_1__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBug304681TestLanguage.g:4117:2: ( rule__Reference__UnorderedGroup_4_0_1__1 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( LA33_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0) ) {
                alt33=1;
            }
            else if ( LA33_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Reference__UnorderedGroup_4_0_1__1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Reference__UnorderedGroup_4_0_1__1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__UnorderedGroup_4_0_1__0"


    // $ANTLR start "rule__Reference__UnorderedGroup_4_0_1__1"
    // InternalBug304681TestLanguage.g:4123:1: rule__Reference__UnorderedGroup_4_0_1__1 : rule__Reference__UnorderedGroup_4_0_1__Impl ;
    public final void rule__Reference__UnorderedGroup_4_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4127:1: ( rule__Reference__UnorderedGroup_4_0_1__Impl )
            // InternalBug304681TestLanguage.g:4128:2: rule__Reference__UnorderedGroup_4_0_1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__UnorderedGroup_4_0_1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__UnorderedGroup_4_0_1__1"


    // $ANTLR start "rule__Object2__UnorderedGroup_5"
    // InternalBug304681TestLanguage.g:4135:1: rule__Object2__UnorderedGroup_5 : ( rule__Object2__UnorderedGroup_5__0 )? ;
    public final void rule__Object2__UnorderedGroup_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getObject2Access().getUnorderedGroup_5());
        	
        try {
            // InternalBug304681TestLanguage.g:4140:1: ( ( rule__Object2__UnorderedGroup_5__0 )? )
            // InternalBug304681TestLanguage.g:4141:2: ( rule__Object2__UnorderedGroup_5__0 )?
            {
            // InternalBug304681TestLanguage.g:4141:2: ( rule__Object2__UnorderedGroup_5__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( LA34_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0) ) {
                alt34=1;
            }
            else if ( LA34_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1) ) {
                alt34=1;
            }
            else if ( LA34_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2) ) {
                alt34=1;
            }
            else if ( LA34_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3) ) {
                alt34=1;
            }
            else if ( LA34_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4) ) {
                alt34=1;
            }
            else if ( LA34_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Object2__UnorderedGroup_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object2__UnorderedGroup_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getObject2Access().getUnorderedGroup_5());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__UnorderedGroup_5"


    // $ANTLR start "rule__Object2__UnorderedGroup_5__Impl"
    // InternalBug304681TestLanguage.g:4149:1: rule__Object2__UnorderedGroup_5__Impl : ( ({...}? => ( ( ( rule__Object2__Group_5_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Object2__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object2__FeaturesAssignment_5_4 )=> rule__Object2__FeaturesAssignment_5_4 )* ) ) ) ) ) ;
    public final void rule__Object2__UnorderedGroup_5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
        	
        try {
            // InternalBug304681TestLanguage.g:4154:1: ( ( ({...}? => ( ( ( rule__Object2__Group_5_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Object2__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object2__FeaturesAssignment_5_4 )=> rule__Object2__FeaturesAssignment_5_4 )* ) ) ) ) ) )
            // InternalBug304681TestLanguage.g:4155:3: ( ({...}? => ( ( ( rule__Object2__Group_5_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Object2__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object2__FeaturesAssignment_5_4 )=> rule__Object2__FeaturesAssignment_5_4 )* ) ) ) ) )
            {
            // InternalBug304681TestLanguage.g:4155:3: ( ({...}? => ( ( ( rule__Object2__Group_5_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Object2__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object2__FeaturesAssignment_5_4 )=> rule__Object2__FeaturesAssignment_5_4 )* ) ) ) ) )
            int alt36=5;
            int LA36_0 = input.LA(1);

            if ( LA36_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0) ) {
                alt36=1;
            }
            else if ( LA36_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1) ) {
                alt36=2;
            }
            else if ( LA36_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2) ) {
                alt36=3;
            }
            else if ( LA36_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3) ) {
                alt36=4;
            }
            else if ( LA36_0 >= 26 && LA36_0 <= 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4) ) {
                alt36=5;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // InternalBug304681TestLanguage.g:4156:3: ({...}? => ( ( ( rule__Object2__Group_5_0__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:4156:3: ({...}? => ( ( ( rule__Object2__Group_5_0__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:4157:4: {...}? => ( ( ( rule__Object2__Group_5_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Object2__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0)");
                    }
                    // InternalBug304681TestLanguage.g:4157:103: ( ( ( rule__Object2__Group_5_0__0 ) ) )
                    // InternalBug304681TestLanguage.g:4158:5: ( ( rule__Object2__Group_5_0__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0);
                    selected = true;
                    // InternalBug304681TestLanguage.g:4164:5: ( ( rule__Object2__Group_5_0__0 ) )
                    // InternalBug304681TestLanguage.g:4165:6: ( rule__Object2__Group_5_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObject2Access().getGroup_5_0()); 
                    }
                    // InternalBug304681TestLanguage.g:4166:6: ( rule__Object2__Group_5_0__0 )
                    // InternalBug304681TestLanguage.g:4166:7: rule__Object2__Group_5_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object2__Group_5_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObject2Access().getGroup_5_0()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBug304681TestLanguage.g:4171:3: ({...}? => ( ( ( rule__Object2__Group_5_1__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:4171:3: ({...}? => ( ( ( rule__Object2__Group_5_1__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:4172:4: {...}? => ( ( ( rule__Object2__Group_5_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Object2__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1)");
                    }
                    // InternalBug304681TestLanguage.g:4172:103: ( ( ( rule__Object2__Group_5_1__0 ) ) )
                    // InternalBug304681TestLanguage.g:4173:5: ( ( rule__Object2__Group_5_1__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1);
                    selected = true;
                    // InternalBug304681TestLanguage.g:4179:5: ( ( rule__Object2__Group_5_1__0 ) )
                    // InternalBug304681TestLanguage.g:4180:6: ( rule__Object2__Group_5_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObject2Access().getGroup_5_1()); 
                    }
                    // InternalBug304681TestLanguage.g:4181:6: ( rule__Object2__Group_5_1__0 )
                    // InternalBug304681TestLanguage.g:4181:7: rule__Object2__Group_5_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object2__Group_5_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObject2Access().getGroup_5_1()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalBug304681TestLanguage.g:4186:3: ({...}? => ( ( ( rule__Object2__Group_5_2__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:4186:3: ({...}? => ( ( ( rule__Object2__Group_5_2__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:4187:4: {...}? => ( ( ( rule__Object2__Group_5_2__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Object2__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2)");
                    }
                    // InternalBug304681TestLanguage.g:4187:103: ( ( ( rule__Object2__Group_5_2__0 ) ) )
                    // InternalBug304681TestLanguage.g:4188:5: ( ( rule__Object2__Group_5_2__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2);
                    selected = true;
                    // InternalBug304681TestLanguage.g:4194:5: ( ( rule__Object2__Group_5_2__0 ) )
                    // InternalBug304681TestLanguage.g:4195:6: ( rule__Object2__Group_5_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObject2Access().getGroup_5_2()); 
                    }
                    // InternalBug304681TestLanguage.g:4196:6: ( rule__Object2__Group_5_2__0 )
                    // InternalBug304681TestLanguage.g:4196:7: rule__Object2__Group_5_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object2__Group_5_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObject2Access().getGroup_5_2()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalBug304681TestLanguage.g:4201:3: ({...}? => ( ( ( rule__Object2__Group_5_3__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:4201:3: ({...}? => ( ( ( rule__Object2__Group_5_3__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:4202:4: {...}? => ( ( ( rule__Object2__Group_5_3__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Object2__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3)");
                    }
                    // InternalBug304681TestLanguage.g:4202:103: ( ( ( rule__Object2__Group_5_3__0 ) ) )
                    // InternalBug304681TestLanguage.g:4203:5: ( ( rule__Object2__Group_5_3__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3);
                    selected = true;
                    // InternalBug304681TestLanguage.g:4209:5: ( ( rule__Object2__Group_5_3__0 ) )
                    // InternalBug304681TestLanguage.g:4210:6: ( rule__Object2__Group_5_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObject2Access().getGroup_5_3()); 
                    }
                    // InternalBug304681TestLanguage.g:4211:6: ( rule__Object2__Group_5_3__0 )
                    // InternalBug304681TestLanguage.g:4211:7: rule__Object2__Group_5_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object2__Group_5_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObject2Access().getGroup_5_3()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalBug304681TestLanguage.g:4216:3: ({...}? => ( ( ( ( rule__Object2__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object2__FeaturesAssignment_5_4 )=> rule__Object2__FeaturesAssignment_5_4 )* ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:4216:3: ({...}? => ( ( ( ( rule__Object2__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object2__FeaturesAssignment_5_4 )=> rule__Object2__FeaturesAssignment_5_4 )* ) ) ) )
                    // InternalBug304681TestLanguage.g:4217:4: {...}? => ( ( ( ( rule__Object2__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object2__FeaturesAssignment_5_4 )=> rule__Object2__FeaturesAssignment_5_4 )* ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Object2__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)");
                    }
                    // InternalBug304681TestLanguage.g:4217:103: ( ( ( ( rule__Object2__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object2__FeaturesAssignment_5_4 )=> rule__Object2__FeaturesAssignment_5_4 )* ) ) )
                    // InternalBug304681TestLanguage.g:4218:5: ( ( ( rule__Object2__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object2__FeaturesAssignment_5_4 )=> rule__Object2__FeaturesAssignment_5_4 )* ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4);
                    selected = true;
                    // InternalBug304681TestLanguage.g:4224:5: ( ( ( rule__Object2__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object2__FeaturesAssignment_5_4 )=> rule__Object2__FeaturesAssignment_5_4 )* ) )
                    // InternalBug304681TestLanguage.g:4225:6: ( ( rule__Object2__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object2__FeaturesAssignment_5_4 )=> rule__Object2__FeaturesAssignment_5_4 )* )
                    {
                    // InternalBug304681TestLanguage.g:4225:6: ( ( rule__Object2__FeaturesAssignment_5_4 ) )
                    // InternalBug304681TestLanguage.g:4226:7: ( rule__Object2__FeaturesAssignment_5_4 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObject2Access().getFeaturesAssignment_5_4()); 
                    }
                    // InternalBug304681TestLanguage.g:4227:7: ( rule__Object2__FeaturesAssignment_5_4 )
                    // InternalBug304681TestLanguage.g:4227:8: rule__Object2__FeaturesAssignment_5_4
                    {
                    pushFollow(FollowSets000.FOLLOW_27);
                    rule__Object2__FeaturesAssignment_5_4();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObject2Access().getFeaturesAssignment_5_4()); 
                    }

                    }

                    // InternalBug304681TestLanguage.g:4230:6: ( ( ( rule__Object2__FeaturesAssignment_5_4 )=> rule__Object2__FeaturesAssignment_5_4 )* )
                    // InternalBug304681TestLanguage.g:4231:7: ( ( rule__Object2__FeaturesAssignment_5_4 )=> rule__Object2__FeaturesAssignment_5_4 )*
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObject2Access().getFeaturesAssignment_5_4()); 
                    }
                    // InternalBug304681TestLanguage.g:4232:7: ( ( rule__Object2__FeaturesAssignment_5_4 )=> rule__Object2__FeaturesAssignment_5_4 )*
                    loop35:
                    do {
                        int alt35=2;
                        alt35 = dfa35.predict(input);
                        switch (alt35) {
                    	case 1 :
                    	    // InternalBug304681TestLanguage.g:4232:8: ( rule__Object2__FeaturesAssignment_5_4 )=> rule__Object2__FeaturesAssignment_5_4
                    	    {
                    	    pushFollow(FollowSets000.FOLLOW_27);
                    	    rule__Object2__FeaturesAssignment_5_4();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop35;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObject2Access().getFeaturesAssignment_5_4()); 
                    }

                    }


                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObject2Access().getUnorderedGroup_5());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__UnorderedGroup_5__Impl"


    // $ANTLR start "rule__Object2__UnorderedGroup_5__0"
    // InternalBug304681TestLanguage.g:4246:1: rule__Object2__UnorderedGroup_5__0 : rule__Object2__UnorderedGroup_5__Impl ( rule__Object2__UnorderedGroup_5__1 )? ;
    public final void rule__Object2__UnorderedGroup_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4250:1: ( rule__Object2__UnorderedGroup_5__Impl ( rule__Object2__UnorderedGroup_5__1 )? )
            // InternalBug304681TestLanguage.g:4251:2: rule__Object2__UnorderedGroup_5__Impl ( rule__Object2__UnorderedGroup_5__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_27);
            rule__Object2__UnorderedGroup_5__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBug304681TestLanguage.g:4252:2: ( rule__Object2__UnorderedGroup_5__1 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( LA37_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0) ) {
                alt37=1;
            }
            else if ( LA37_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1) ) {
                alt37=1;
            }
            else if ( LA37_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2) ) {
                alt37=1;
            }
            else if ( LA37_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3) ) {
                alt37=1;
            }
            else if ( LA37_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4) ) {
                alt37=1;
            }
            else if ( LA37_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Object2__UnorderedGroup_5__1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object2__UnorderedGroup_5__1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__UnorderedGroup_5__0"


    // $ANTLR start "rule__Object2__UnorderedGroup_5__1"
    // InternalBug304681TestLanguage.g:4258:1: rule__Object2__UnorderedGroup_5__1 : rule__Object2__UnorderedGroup_5__Impl ( rule__Object2__UnorderedGroup_5__2 )? ;
    public final void rule__Object2__UnorderedGroup_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4262:1: ( rule__Object2__UnorderedGroup_5__Impl ( rule__Object2__UnorderedGroup_5__2 )? )
            // InternalBug304681TestLanguage.g:4263:2: rule__Object2__UnorderedGroup_5__Impl ( rule__Object2__UnorderedGroup_5__2 )?
            {
            pushFollow(FollowSets000.FOLLOW_27);
            rule__Object2__UnorderedGroup_5__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBug304681TestLanguage.g:4264:2: ( rule__Object2__UnorderedGroup_5__2 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( LA38_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0) ) {
                alt38=1;
            }
            else if ( LA38_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1) ) {
                alt38=1;
            }
            else if ( LA38_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2) ) {
                alt38=1;
            }
            else if ( LA38_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3) ) {
                alt38=1;
            }
            else if ( LA38_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4) ) {
                alt38=1;
            }
            else if ( LA38_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Object2__UnorderedGroup_5__2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object2__UnorderedGroup_5__2();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__UnorderedGroup_5__1"


    // $ANTLR start "rule__Object2__UnorderedGroup_5__2"
    // InternalBug304681TestLanguage.g:4270:1: rule__Object2__UnorderedGroup_5__2 : rule__Object2__UnorderedGroup_5__Impl ( rule__Object2__UnorderedGroup_5__3 )? ;
    public final void rule__Object2__UnorderedGroup_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4274:1: ( rule__Object2__UnorderedGroup_5__Impl ( rule__Object2__UnorderedGroup_5__3 )? )
            // InternalBug304681TestLanguage.g:4275:2: rule__Object2__UnorderedGroup_5__Impl ( rule__Object2__UnorderedGroup_5__3 )?
            {
            pushFollow(FollowSets000.FOLLOW_27);
            rule__Object2__UnorderedGroup_5__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBug304681TestLanguage.g:4276:2: ( rule__Object2__UnorderedGroup_5__3 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( LA39_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0) ) {
                alt39=1;
            }
            else if ( LA39_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1) ) {
                alt39=1;
            }
            else if ( LA39_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2) ) {
                alt39=1;
            }
            else if ( LA39_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3) ) {
                alt39=1;
            }
            else if ( LA39_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4) ) {
                alt39=1;
            }
            else if ( LA39_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Object2__UnorderedGroup_5__3
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object2__UnorderedGroup_5__3();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__UnorderedGroup_5__2"


    // $ANTLR start "rule__Object2__UnorderedGroup_5__3"
    // InternalBug304681TestLanguage.g:4282:1: rule__Object2__UnorderedGroup_5__3 : rule__Object2__UnorderedGroup_5__Impl ( rule__Object2__UnorderedGroup_5__4 )? ;
    public final void rule__Object2__UnorderedGroup_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4286:1: ( rule__Object2__UnorderedGroup_5__Impl ( rule__Object2__UnorderedGroup_5__4 )? )
            // InternalBug304681TestLanguage.g:4287:2: rule__Object2__UnorderedGroup_5__Impl ( rule__Object2__UnorderedGroup_5__4 )?
            {
            pushFollow(FollowSets000.FOLLOW_27);
            rule__Object2__UnorderedGroup_5__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBug304681TestLanguage.g:4288:2: ( rule__Object2__UnorderedGroup_5__4 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( LA40_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0) ) {
                alt40=1;
            }
            else if ( LA40_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1) ) {
                alt40=1;
            }
            else if ( LA40_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2) ) {
                alt40=1;
            }
            else if ( LA40_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3) ) {
                alt40=1;
            }
            else if ( LA40_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4) ) {
                alt40=1;
            }
            else if ( LA40_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Object2__UnorderedGroup_5__4
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object2__UnorderedGroup_5__4();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__UnorderedGroup_5__3"


    // $ANTLR start "rule__Object2__UnorderedGroup_5__4"
    // InternalBug304681TestLanguage.g:4294:1: rule__Object2__UnorderedGroup_5__4 : rule__Object2__UnorderedGroup_5__Impl ;
    public final void rule__Object2__UnorderedGroup_5__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4298:1: ( rule__Object2__UnorderedGroup_5__Impl )
            // InternalBug304681TestLanguage.g:4299:2: rule__Object2__UnorderedGroup_5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__UnorderedGroup_5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__UnorderedGroup_5__4"


    // $ANTLR start "rule__Attribute2__UnorderedGroup_3_0_1"
    // InternalBug304681TestLanguage.g:4306:1: rule__Attribute2__UnorderedGroup_3_0_1 : ( rule__Attribute2__UnorderedGroup_3_0_1__0 )? ;
    public final void rule__Attribute2__UnorderedGroup_3_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1());
        	
        try {
            // InternalBug304681TestLanguage.g:4311:1: ( ( rule__Attribute2__UnorderedGroup_3_0_1__0 )? )
            // InternalBug304681TestLanguage.g:4312:2: ( rule__Attribute2__UnorderedGroup_3_0_1__0 )?
            {
            // InternalBug304681TestLanguage.g:4312:2: ( rule__Attribute2__UnorderedGroup_3_0_1__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( LA41_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0) ) {
                alt41=1;
            }
            else if ( LA41_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1) ) {
                alt41=1;
            }
            else if ( LA41_0 == 28 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2) ) {
                alt41=1;
            }
            else if ( LA41_0 == 35 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3) ) {
                alt41=1;
            }
            else if ( LA41_0 == 36 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Attribute2__UnorderedGroup_3_0_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Attribute2__UnorderedGroup_3_0_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__UnorderedGroup_3_0_1"


    // $ANTLR start "rule__Attribute2__UnorderedGroup_3_0_1__Impl"
    // InternalBug304681TestLanguage.g:4320:1: rule__Attribute2__UnorderedGroup_3_0_1__Impl : ( ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_1__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_4__0 ) ) ) ) ) ;
    public final void rule__Attribute2__UnorderedGroup_3_0_1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
        	
        try {
            // InternalBug304681TestLanguage.g:4325:1: ( ( ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_1__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_4__0 ) ) ) ) ) )
            // InternalBug304681TestLanguage.g:4326:3: ( ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_1__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_4__0 ) ) ) ) )
            {
            // InternalBug304681TestLanguage.g:4326:3: ( ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_1__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_4__0 ) ) ) ) )
            int alt43=5;
            int LA43_0 = input.LA(1);

            if ( LA43_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0) ) {
                alt43=1;
            }
            else if ( LA43_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1) ) {
                alt43=2;
            }
            else if ( LA43_0 == 28 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2) ) {
                alt43=3;
            }
            else if ( LA43_0 == 35 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3) ) {
                alt43=4;
            }
            else if ( LA43_0 == 36 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4) ) {
                alt43=5;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // InternalBug304681TestLanguage.g:4327:3: ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_0__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:4327:3: ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_0__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:4328:4: {...}? => ( ( ( rule__Attribute2__Group_3_0_1_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Attribute2__UnorderedGroup_3_0_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0)");
                    }
                    // InternalBug304681TestLanguage.g:4328:110: ( ( ( rule__Attribute2__Group_3_0_1_0__0 ) ) )
                    // InternalBug304681TestLanguage.g:4329:5: ( ( rule__Attribute2__Group_3_0_1_0__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0);
                    selected = true;
                    // InternalBug304681TestLanguage.g:4335:5: ( ( rule__Attribute2__Group_3_0_1_0__0 ) )
                    // InternalBug304681TestLanguage.g:4336:6: ( rule__Attribute2__Group_3_0_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAttribute2Access().getGroup_3_0_1_0()); 
                    }
                    // InternalBug304681TestLanguage.g:4337:6: ( rule__Attribute2__Group_3_0_1_0__0 )
                    // InternalBug304681TestLanguage.g:4337:7: rule__Attribute2__Group_3_0_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Attribute2__Group_3_0_1_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAttribute2Access().getGroup_3_0_1_0()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBug304681TestLanguage.g:4342:3: ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_1__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:4342:3: ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_1__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:4343:4: {...}? => ( ( ( rule__Attribute2__Group_3_0_1_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Attribute2__UnorderedGroup_3_0_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1)");
                    }
                    // InternalBug304681TestLanguage.g:4343:110: ( ( ( rule__Attribute2__Group_3_0_1_1__0 ) ) )
                    // InternalBug304681TestLanguage.g:4344:5: ( ( rule__Attribute2__Group_3_0_1_1__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1);
                    selected = true;
                    // InternalBug304681TestLanguage.g:4350:5: ( ( rule__Attribute2__Group_3_0_1_1__0 ) )
                    // InternalBug304681TestLanguage.g:4351:6: ( rule__Attribute2__Group_3_0_1_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAttribute2Access().getGroup_3_0_1_1()); 
                    }
                    // InternalBug304681TestLanguage.g:4352:6: ( rule__Attribute2__Group_3_0_1_1__0 )
                    // InternalBug304681TestLanguage.g:4352:7: rule__Attribute2__Group_3_0_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Attribute2__Group_3_0_1_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAttribute2Access().getGroup_3_0_1_1()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalBug304681TestLanguage.g:4357:3: ({...}? => ( ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:4357:3: ({...}? => ( ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) ) ) )
                    // InternalBug304681TestLanguage.g:4358:4: {...}? => ( ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Attribute2__UnorderedGroup_3_0_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2)");
                    }
                    // InternalBug304681TestLanguage.g:4358:110: ( ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) ) )
                    // InternalBug304681TestLanguage.g:4359:5: ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2);
                    selected = true;
                    // InternalBug304681TestLanguage.g:4365:5: ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) )
                    // InternalBug304681TestLanguage.g:4366:6: ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* )
                    {
                    // InternalBug304681TestLanguage.g:4366:6: ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) )
                    // InternalBug304681TestLanguage.g:4367:7: ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAttribute2Access().getConstraintDefinitionsAssignment_3_0_1_2()); 
                    }
                    // InternalBug304681TestLanguage.g:4368:7: ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )
                    // InternalBug304681TestLanguage.g:4368:8: rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2
                    {
                    pushFollow(FollowSets000.FOLLOW_28);
                    rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAttribute2Access().getConstraintDefinitionsAssignment_3_0_1_2()); 
                    }

                    }

                    // InternalBug304681TestLanguage.g:4371:6: ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* )
                    // InternalBug304681TestLanguage.g:4372:7: ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )*
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAttribute2Access().getConstraintDefinitionsAssignment_3_0_1_2()); 
                    }
                    // InternalBug304681TestLanguage.g:4373:7: ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )*
                    loop42:
                    do {
                        int alt42=2;
                        alt42 = dfa42.predict(input);
                        switch (alt42) {
                    	case 1 :
                    	    // InternalBug304681TestLanguage.g:4373:8: ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2
                    	    {
                    	    pushFollow(FollowSets000.FOLLOW_28);
                    	    rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop42;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAttribute2Access().getConstraintDefinitionsAssignment_3_0_1_2()); 
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalBug304681TestLanguage.g:4379:3: ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_3__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:4379:3: ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_3__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:4380:4: {...}? => ( ( ( rule__Attribute2__Group_3_0_1_3__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Attribute2__UnorderedGroup_3_0_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3)");
                    }
                    // InternalBug304681TestLanguage.g:4380:110: ( ( ( rule__Attribute2__Group_3_0_1_3__0 ) ) )
                    // InternalBug304681TestLanguage.g:4381:5: ( ( rule__Attribute2__Group_3_0_1_3__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3);
                    selected = true;
                    // InternalBug304681TestLanguage.g:4387:5: ( ( rule__Attribute2__Group_3_0_1_3__0 ) )
                    // InternalBug304681TestLanguage.g:4388:6: ( rule__Attribute2__Group_3_0_1_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAttribute2Access().getGroup_3_0_1_3()); 
                    }
                    // InternalBug304681TestLanguage.g:4389:6: ( rule__Attribute2__Group_3_0_1_3__0 )
                    // InternalBug304681TestLanguage.g:4389:7: rule__Attribute2__Group_3_0_1_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Attribute2__Group_3_0_1_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAttribute2Access().getGroup_3_0_1_3()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalBug304681TestLanguage.g:4394:3: ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_4__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:4394:3: ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_4__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:4395:4: {...}? => ( ( ( rule__Attribute2__Group_3_0_1_4__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Attribute2__UnorderedGroup_3_0_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4)");
                    }
                    // InternalBug304681TestLanguage.g:4395:110: ( ( ( rule__Attribute2__Group_3_0_1_4__0 ) ) )
                    // InternalBug304681TestLanguage.g:4396:5: ( ( rule__Attribute2__Group_3_0_1_4__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4);
                    selected = true;
                    // InternalBug304681TestLanguage.g:4402:5: ( ( rule__Attribute2__Group_3_0_1_4__0 ) )
                    // InternalBug304681TestLanguage.g:4403:6: ( rule__Attribute2__Group_3_0_1_4__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAttribute2Access().getGroup_3_0_1_4()); 
                    }
                    // InternalBug304681TestLanguage.g:4404:6: ( rule__Attribute2__Group_3_0_1_4__0 )
                    // InternalBug304681TestLanguage.g:4404:7: rule__Attribute2__Group_3_0_1_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Attribute2__Group_3_0_1_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAttribute2Access().getGroup_3_0_1_4()); 
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__UnorderedGroup_3_0_1__Impl"


    // $ANTLR start "rule__Attribute2__UnorderedGroup_3_0_1__0"
    // InternalBug304681TestLanguage.g:4417:1: rule__Attribute2__UnorderedGroup_3_0_1__0 : rule__Attribute2__UnorderedGroup_3_0_1__Impl ( rule__Attribute2__UnorderedGroup_3_0_1__1 )? ;
    public final void rule__Attribute2__UnorderedGroup_3_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4421:1: ( rule__Attribute2__UnorderedGroup_3_0_1__Impl ( rule__Attribute2__UnorderedGroup_3_0_1__1 )? )
            // InternalBug304681TestLanguage.g:4422:2: rule__Attribute2__UnorderedGroup_3_0_1__Impl ( rule__Attribute2__UnorderedGroup_3_0_1__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_29);
            rule__Attribute2__UnorderedGroup_3_0_1__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBug304681TestLanguage.g:4423:2: ( rule__Attribute2__UnorderedGroup_3_0_1__1 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( LA44_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0) ) {
                alt44=1;
            }
            else if ( LA44_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1) ) {
                alt44=1;
            }
            else if ( LA44_0 == 28 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2) ) {
                alt44=1;
            }
            else if ( LA44_0 == 35 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3) ) {
                alt44=1;
            }
            else if ( LA44_0 == 36 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Attribute2__UnorderedGroup_3_0_1__1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Attribute2__UnorderedGroup_3_0_1__1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__UnorderedGroup_3_0_1__0"


    // $ANTLR start "rule__Attribute2__UnorderedGroup_3_0_1__1"
    // InternalBug304681TestLanguage.g:4429:1: rule__Attribute2__UnorderedGroup_3_0_1__1 : rule__Attribute2__UnorderedGroup_3_0_1__Impl ( rule__Attribute2__UnorderedGroup_3_0_1__2 )? ;
    public final void rule__Attribute2__UnorderedGroup_3_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4433:1: ( rule__Attribute2__UnorderedGroup_3_0_1__Impl ( rule__Attribute2__UnorderedGroup_3_0_1__2 )? )
            // InternalBug304681TestLanguage.g:4434:2: rule__Attribute2__UnorderedGroup_3_0_1__Impl ( rule__Attribute2__UnorderedGroup_3_0_1__2 )?
            {
            pushFollow(FollowSets000.FOLLOW_29);
            rule__Attribute2__UnorderedGroup_3_0_1__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBug304681TestLanguage.g:4435:2: ( rule__Attribute2__UnorderedGroup_3_0_1__2 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( LA45_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0) ) {
                alt45=1;
            }
            else if ( LA45_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1) ) {
                alt45=1;
            }
            else if ( LA45_0 == 28 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2) ) {
                alt45=1;
            }
            else if ( LA45_0 == 35 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3) ) {
                alt45=1;
            }
            else if ( LA45_0 == 36 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Attribute2__UnorderedGroup_3_0_1__2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Attribute2__UnorderedGroup_3_0_1__2();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__UnorderedGroup_3_0_1__1"


    // $ANTLR start "rule__Attribute2__UnorderedGroup_3_0_1__2"
    // InternalBug304681TestLanguage.g:4441:1: rule__Attribute2__UnorderedGroup_3_0_1__2 : rule__Attribute2__UnorderedGroup_3_0_1__Impl ( rule__Attribute2__UnorderedGroup_3_0_1__3 )? ;
    public final void rule__Attribute2__UnorderedGroup_3_0_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4445:1: ( rule__Attribute2__UnorderedGroup_3_0_1__Impl ( rule__Attribute2__UnorderedGroup_3_0_1__3 )? )
            // InternalBug304681TestLanguage.g:4446:2: rule__Attribute2__UnorderedGroup_3_0_1__Impl ( rule__Attribute2__UnorderedGroup_3_0_1__3 )?
            {
            pushFollow(FollowSets000.FOLLOW_29);
            rule__Attribute2__UnorderedGroup_3_0_1__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBug304681TestLanguage.g:4447:2: ( rule__Attribute2__UnorderedGroup_3_0_1__3 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( LA46_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0) ) {
                alt46=1;
            }
            else if ( LA46_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1) ) {
                alt46=1;
            }
            else if ( LA46_0 == 28 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2) ) {
                alt46=1;
            }
            else if ( LA46_0 == 35 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3) ) {
                alt46=1;
            }
            else if ( LA46_0 == 36 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Attribute2__UnorderedGroup_3_0_1__3
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Attribute2__UnorderedGroup_3_0_1__3();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__UnorderedGroup_3_0_1__2"


    // $ANTLR start "rule__Attribute2__UnorderedGroup_3_0_1__3"
    // InternalBug304681TestLanguage.g:4453:1: rule__Attribute2__UnorderedGroup_3_0_1__3 : rule__Attribute2__UnorderedGroup_3_0_1__Impl ( rule__Attribute2__UnorderedGroup_3_0_1__4 )? ;
    public final void rule__Attribute2__UnorderedGroup_3_0_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4457:1: ( rule__Attribute2__UnorderedGroup_3_0_1__Impl ( rule__Attribute2__UnorderedGroup_3_0_1__4 )? )
            // InternalBug304681TestLanguage.g:4458:2: rule__Attribute2__UnorderedGroup_3_0_1__Impl ( rule__Attribute2__UnorderedGroup_3_0_1__4 )?
            {
            pushFollow(FollowSets000.FOLLOW_29);
            rule__Attribute2__UnorderedGroup_3_0_1__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBug304681TestLanguage.g:4459:2: ( rule__Attribute2__UnorderedGroup_3_0_1__4 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( LA47_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0) ) {
                alt47=1;
            }
            else if ( LA47_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1) ) {
                alt47=1;
            }
            else if ( LA47_0 == 28 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2) ) {
                alt47=1;
            }
            else if ( LA47_0 == 35 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3) ) {
                alt47=1;
            }
            else if ( LA47_0 == 36 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Attribute2__UnorderedGroup_3_0_1__4
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Attribute2__UnorderedGroup_3_0_1__4();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__UnorderedGroup_3_0_1__3"


    // $ANTLR start "rule__Attribute2__UnorderedGroup_3_0_1__4"
    // InternalBug304681TestLanguage.g:4465:1: rule__Attribute2__UnorderedGroup_3_0_1__4 : rule__Attribute2__UnorderedGroup_3_0_1__Impl ;
    public final void rule__Attribute2__UnorderedGroup_3_0_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4469:1: ( rule__Attribute2__UnorderedGroup_3_0_1__Impl )
            // InternalBug304681TestLanguage.g:4470:2: rule__Attribute2__UnorderedGroup_3_0_1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__UnorderedGroup_3_0_1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__UnorderedGroup_3_0_1__4"


    // $ANTLR start "rule__Reference2__UnorderedGroup_4_0_1"
    // InternalBug304681TestLanguage.g:4477:1: rule__Reference2__UnorderedGroup_4_0_1 : ( rule__Reference2__UnorderedGroup_4_0_1__0 )? ;
    public final void rule__Reference2__UnorderedGroup_4_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1());
        	
        try {
            // InternalBug304681TestLanguage.g:4482:1: ( ( rule__Reference2__UnorderedGroup_4_0_1__0 )? )
            // InternalBug304681TestLanguage.g:4483:2: ( rule__Reference2__UnorderedGroup_4_0_1__0 )?
            {
            // InternalBug304681TestLanguage.g:4483:2: ( rule__Reference2__UnorderedGroup_4_0_1__0 )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( LA48_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0) ) {
                alt48=1;
            }
            else if ( LA48_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 1) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Reference2__UnorderedGroup_4_0_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Reference2__UnorderedGroup_4_0_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__UnorderedGroup_4_0_1"


    // $ANTLR start "rule__Reference2__UnorderedGroup_4_0_1__Impl"
    // InternalBug304681TestLanguage.g:4491:1: rule__Reference2__UnorderedGroup_4_0_1__Impl : ( ({...}? => ( ( ( rule__Reference2__Group_4_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Reference2__Group_4_0_1_1__0 ) ) ) ) ) ;
    public final void rule__Reference2__UnorderedGroup_4_0_1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
        	
        try {
            // InternalBug304681TestLanguage.g:4496:1: ( ( ({...}? => ( ( ( rule__Reference2__Group_4_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Reference2__Group_4_0_1_1__0 ) ) ) ) ) )
            // InternalBug304681TestLanguage.g:4497:3: ( ({...}? => ( ( ( rule__Reference2__Group_4_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Reference2__Group_4_0_1_1__0 ) ) ) ) )
            {
            // InternalBug304681TestLanguage.g:4497:3: ( ({...}? => ( ( ( rule__Reference2__Group_4_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Reference2__Group_4_0_1_1__0 ) ) ) ) )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( LA49_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0) ) {
                alt49=1;
            }
            else if ( LA49_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 1) ) {
                alt49=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // InternalBug304681TestLanguage.g:4498:3: ({...}? => ( ( ( rule__Reference2__Group_4_0_1_0__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:4498:3: ({...}? => ( ( ( rule__Reference2__Group_4_0_1_0__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:4499:4: {...}? => ( ( ( rule__Reference2__Group_4_0_1_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Reference2__UnorderedGroup_4_0_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0)");
                    }
                    // InternalBug304681TestLanguage.g:4499:110: ( ( ( rule__Reference2__Group_4_0_1_0__0 ) ) )
                    // InternalBug304681TestLanguage.g:4500:5: ( ( rule__Reference2__Group_4_0_1_0__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0);
                    selected = true;
                    // InternalBug304681TestLanguage.g:4506:5: ( ( rule__Reference2__Group_4_0_1_0__0 ) )
                    // InternalBug304681TestLanguage.g:4507:6: ( rule__Reference2__Group_4_0_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReference2Access().getGroup_4_0_1_0()); 
                    }
                    // InternalBug304681TestLanguage.g:4508:6: ( rule__Reference2__Group_4_0_1_0__0 )
                    // InternalBug304681TestLanguage.g:4508:7: rule__Reference2__Group_4_0_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Reference2__Group_4_0_1_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getReference2Access().getGroup_4_0_1_0()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBug304681TestLanguage.g:4513:3: ({...}? => ( ( ( rule__Reference2__Group_4_0_1_1__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:4513:3: ({...}? => ( ( ( rule__Reference2__Group_4_0_1_1__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:4514:4: {...}? => ( ( ( rule__Reference2__Group_4_0_1_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 1) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Reference2__UnorderedGroup_4_0_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 1)");
                    }
                    // InternalBug304681TestLanguage.g:4514:110: ( ( ( rule__Reference2__Group_4_0_1_1__0 ) ) )
                    // InternalBug304681TestLanguage.g:4515:5: ( ( rule__Reference2__Group_4_0_1_1__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 1);
                    selected = true;
                    // InternalBug304681TestLanguage.g:4521:5: ( ( rule__Reference2__Group_4_0_1_1__0 ) )
                    // InternalBug304681TestLanguage.g:4522:6: ( rule__Reference2__Group_4_0_1_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReference2Access().getGroup_4_0_1_1()); 
                    }
                    // InternalBug304681TestLanguage.g:4523:6: ( rule__Reference2__Group_4_0_1_1__0 )
                    // InternalBug304681TestLanguage.g:4523:7: rule__Reference2__Group_4_0_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Reference2__Group_4_0_1_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getReference2Access().getGroup_4_0_1_1()); 
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__UnorderedGroup_4_0_1__Impl"


    // $ANTLR start "rule__Reference2__UnorderedGroup_4_0_1__0"
    // InternalBug304681TestLanguage.g:4536:1: rule__Reference2__UnorderedGroup_4_0_1__0 : rule__Reference2__UnorderedGroup_4_0_1__Impl ( rule__Reference2__UnorderedGroup_4_0_1__1 )? ;
    public final void rule__Reference2__UnorderedGroup_4_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4540:1: ( rule__Reference2__UnorderedGroup_4_0_1__Impl ( rule__Reference2__UnorderedGroup_4_0_1__1 )? )
            // InternalBug304681TestLanguage.g:4541:2: rule__Reference2__UnorderedGroup_4_0_1__Impl ( rule__Reference2__UnorderedGroup_4_0_1__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_26);
            rule__Reference2__UnorderedGroup_4_0_1__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBug304681TestLanguage.g:4542:2: ( rule__Reference2__UnorderedGroup_4_0_1__1 )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( LA50_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0) ) {
                alt50=1;
            }
            else if ( LA50_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 1) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Reference2__UnorderedGroup_4_0_1__1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Reference2__UnorderedGroup_4_0_1__1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__UnorderedGroup_4_0_1__0"


    // $ANTLR start "rule__Reference2__UnorderedGroup_4_0_1__1"
    // InternalBug304681TestLanguage.g:4548:1: rule__Reference2__UnorderedGroup_4_0_1__1 : rule__Reference2__UnorderedGroup_4_0_1__Impl ;
    public final void rule__Reference2__UnorderedGroup_4_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4552:1: ( rule__Reference2__UnorderedGroup_4_0_1__Impl )
            // InternalBug304681TestLanguage.g:4553:2: rule__Reference2__UnorderedGroup_4_0_1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__UnorderedGroup_4_0_1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__UnorderedGroup_4_0_1__1"


    // $ANTLR start "rule__ConstraintDefinition__UnorderedGroup_3"
    // InternalBug304681TestLanguage.g:4560:1: rule__ConstraintDefinition__UnorderedGroup_3 : rule__ConstraintDefinition__UnorderedGroup_3__0 {...}?;
    public final void rule__ConstraintDefinition__UnorderedGroup_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3());
        	
        try {
            // InternalBug304681TestLanguage.g:4565:1: ( rule__ConstraintDefinition__UnorderedGroup_3__0 {...}?)
            // InternalBug304681TestLanguage.g:4566:2: rule__ConstraintDefinition__UnorderedGroup_3__0 {...}?
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConstraintDefinition__UnorderedGroup_3__0();

            state._fsp--;
            if (state.failed) return ;
            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3()) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "rule__ConstraintDefinition__UnorderedGroup_3", "getUnorderedGroupHelper().canLeave(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3())");
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__UnorderedGroup_3"


    // $ANTLR start "rule__ConstraintDefinition__UnorderedGroup_3__Impl"
    // InternalBug304681TestLanguage.g:4574:1: rule__ConstraintDefinition__UnorderedGroup_3__Impl : ( ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_1__0 ) ) ) ) ) ;
    public final void rule__ConstraintDefinition__UnorderedGroup_3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
        	
        try {
            // InternalBug304681TestLanguage.g:4579:1: ( ( ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_1__0 ) ) ) ) ) )
            // InternalBug304681TestLanguage.g:4580:3: ( ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_1__0 ) ) ) ) )
            {
            // InternalBug304681TestLanguage.g:4580:3: ( ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_1__0 ) ) ) ) )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( LA51_0 == 29 && getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 0) ) {
                alt51=1;
            }
            else if ( LA51_0 == 30 && getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 1) ) {
                alt51=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // InternalBug304681TestLanguage.g:4581:3: ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_0__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:4581:3: ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_0__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:4582:4: {...}? => ( ( ( rule__ConstraintDefinition__Group_3_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 0) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ConstraintDefinition__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 0)");
                    }
                    // InternalBug304681TestLanguage.g:4582:116: ( ( ( rule__ConstraintDefinition__Group_3_0__0 ) ) )
                    // InternalBug304681TestLanguage.g:4583:5: ( ( rule__ConstraintDefinition__Group_3_0__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 0);
                    selected = true;
                    // InternalBug304681TestLanguage.g:4589:5: ( ( rule__ConstraintDefinition__Group_3_0__0 ) )
                    // InternalBug304681TestLanguage.g:4590:6: ( rule__ConstraintDefinition__Group_3_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getConstraintDefinitionAccess().getGroup_3_0()); 
                    }
                    // InternalBug304681TestLanguage.g:4591:6: ( rule__ConstraintDefinition__Group_3_0__0 )
                    // InternalBug304681TestLanguage.g:4591:7: rule__ConstraintDefinition__Group_3_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ConstraintDefinition__Group_3_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getConstraintDefinitionAccess().getGroup_3_0()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBug304681TestLanguage.g:4596:3: ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_1__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:4596:3: ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_1__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:4597:4: {...}? => ( ( ( rule__ConstraintDefinition__Group_3_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 1) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ConstraintDefinition__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 1)");
                    }
                    // InternalBug304681TestLanguage.g:4597:116: ( ( ( rule__ConstraintDefinition__Group_3_1__0 ) ) )
                    // InternalBug304681TestLanguage.g:4598:5: ( ( rule__ConstraintDefinition__Group_3_1__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 1);
                    selected = true;
                    // InternalBug304681TestLanguage.g:4604:5: ( ( rule__ConstraintDefinition__Group_3_1__0 ) )
                    // InternalBug304681TestLanguage.g:4605:6: ( rule__ConstraintDefinition__Group_3_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getConstraintDefinitionAccess().getGroup_3_1()); 
                    }
                    // InternalBug304681TestLanguage.g:4606:6: ( rule__ConstraintDefinition__Group_3_1__0 )
                    // InternalBug304681TestLanguage.g:4606:7: rule__ConstraintDefinition__Group_3_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ConstraintDefinition__Group_3_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getConstraintDefinitionAccess().getGroup_3_1()); 
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__UnorderedGroup_3__Impl"


    // $ANTLR start "rule__ConstraintDefinition__UnorderedGroup_3__0"
    // InternalBug304681TestLanguage.g:4619:1: rule__ConstraintDefinition__UnorderedGroup_3__0 : rule__ConstraintDefinition__UnorderedGroup_3__Impl ( rule__ConstraintDefinition__UnorderedGroup_3__1 )? ;
    public final void rule__ConstraintDefinition__UnorderedGroup_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4623:1: ( rule__ConstraintDefinition__UnorderedGroup_3__Impl ( rule__ConstraintDefinition__UnorderedGroup_3__1 )? )
            // InternalBug304681TestLanguage.g:4624:2: rule__ConstraintDefinition__UnorderedGroup_3__Impl ( rule__ConstraintDefinition__UnorderedGroup_3__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_30);
            rule__ConstraintDefinition__UnorderedGroup_3__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBug304681TestLanguage.g:4625:2: ( rule__ConstraintDefinition__UnorderedGroup_3__1 )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( LA52_0 == 29 && getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 0) ) {
                alt52=1;
            }
            else if ( LA52_0 == 30 && getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 1) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__ConstraintDefinition__UnorderedGroup_3__1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ConstraintDefinition__UnorderedGroup_3__1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__UnorderedGroup_3__0"


    // $ANTLR start "rule__ConstraintDefinition__UnorderedGroup_3__1"
    // InternalBug304681TestLanguage.g:4631:1: rule__ConstraintDefinition__UnorderedGroup_3__1 : rule__ConstraintDefinition__UnorderedGroup_3__Impl ;
    public final void rule__ConstraintDefinition__UnorderedGroup_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4635:1: ( rule__ConstraintDefinition__UnorderedGroup_3__Impl )
            // InternalBug304681TestLanguage.g:4636:2: rule__ConstraintDefinition__UnorderedGroup_3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConstraintDefinition__UnorderedGroup_3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__UnorderedGroup_3__1"


    // $ANTLR start "rule__Model__DefinitionAssignment_0_1"
    // InternalBug304681TestLanguage.g:4643:1: rule__Model__DefinitionAssignment_0_1 : ( rulePackageDefinition ) ;
    public final void rule__Model__DefinitionAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4647:1: ( ( rulePackageDefinition ) )
            // InternalBug304681TestLanguage.g:4648:2: ( rulePackageDefinition )
            {
            // InternalBug304681TestLanguage.g:4648:2: ( rulePackageDefinition )
            // InternalBug304681TestLanguage.g:4649:3: rulePackageDefinition
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getDefinitionPackageDefinitionParserRuleCall_0_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_2);
            rulePackageDefinition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getDefinitionPackageDefinitionParserRuleCall_0_1_0()); 
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
    // $ANTLR end "rule__Model__DefinitionAssignment_0_1"


    // $ANTLR start "rule__Model__DefinitionAssignment_1_1"
    // InternalBug304681TestLanguage.g:4658:1: rule__Model__DefinitionAssignment_1_1 : ( rulePackageDefinition2 ) ;
    public final void rule__Model__DefinitionAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4662:1: ( ( rulePackageDefinition2 ) )
            // InternalBug304681TestLanguage.g:4663:2: ( rulePackageDefinition2 )
            {
            // InternalBug304681TestLanguage.g:4663:2: ( rulePackageDefinition2 )
            // InternalBug304681TestLanguage.g:4664:3: rulePackageDefinition2
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getDefinitionPackageDefinition2ParserRuleCall_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_2);
            rulePackageDefinition2();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getDefinitionPackageDefinition2ParserRuleCall_1_1_0()); 
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
    // $ANTLR end "rule__Model__DefinitionAssignment_1_1"


    // $ANTLR start "rule__PackageDefinition__NamespaceAssignment_2"
    // InternalBug304681TestLanguage.g:4673:1: rule__PackageDefinition__NamespaceAssignment_2 : ( RULE_ID ) ;
    public final void rule__PackageDefinition__NamespaceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4677:1: ( ( RULE_ID ) )
            // InternalBug304681TestLanguage.g:4678:2: ( RULE_ID )
            {
            // InternalBug304681TestLanguage.g:4678:2: ( RULE_ID )
            // InternalBug304681TestLanguage.g:4679:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageDefinitionAccess().getNamespaceIDTerminalRuleCall_2_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageDefinitionAccess().getNamespaceIDTerminalRuleCall_2_0()); 
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
    // $ANTLR end "rule__PackageDefinition__NamespaceAssignment_2"


    // $ANTLR start "rule__PackageDefinition__ContentsAssignment_4"
    // InternalBug304681TestLanguage.g:4688:1: rule__PackageDefinition__ContentsAssignment_4 : ( ruleObject ) ;
    public final void rule__PackageDefinition__ContentsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4692:1: ( ( ruleObject ) )
            // InternalBug304681TestLanguage.g:4693:2: ( ruleObject )
            {
            // InternalBug304681TestLanguage.g:4693:2: ( ruleObject )
            // InternalBug304681TestLanguage.g:4694:3: ruleObject
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageDefinitionAccess().getContentsObjectParserRuleCall_4_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleObject();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageDefinitionAccess().getContentsObjectParserRuleCall_4_0()); 
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
    // $ANTLR end "rule__PackageDefinition__ContentsAssignment_4"


    // $ANTLR start "rule__Object__EnabledAssignment_0_0"
    // InternalBug304681TestLanguage.g:4703:1: rule__Object__EnabledAssignment_0_0 : ( ( 'enabled' ) ) ;
    public final void rule__Object__EnabledAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4707:1: ( ( ( 'enabled' ) ) )
            // InternalBug304681TestLanguage.g:4708:2: ( ( 'enabled' ) )
            {
            // InternalBug304681TestLanguage.g:4708:2: ( ( 'enabled' ) )
            // InternalBug304681TestLanguage.g:4709:3: ( 'enabled' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getEnabledEnabledKeyword_0_0_0()); 
            }
            // InternalBug304681TestLanguage.g:4710:3: ( 'enabled' )
            // InternalBug304681TestLanguage.g:4711:4: 'enabled'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getEnabledEnabledKeyword_0_0_0()); 
            }
            match(input,31,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getEnabledEnabledKeyword_0_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getEnabledEnabledKeyword_0_0_0()); 
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
    // $ANTLR end "rule__Object__EnabledAssignment_0_0"


    // $ANTLR start "rule__Object__AbstractAssignment_0_1"
    // InternalBug304681TestLanguage.g:4722:1: rule__Object__AbstractAssignment_0_1 : ( ( 'abstract' ) ) ;
    public final void rule__Object__AbstractAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4726:1: ( ( ( 'abstract' ) ) )
            // InternalBug304681TestLanguage.g:4727:2: ( ( 'abstract' ) )
            {
            // InternalBug304681TestLanguage.g:4727:2: ( ( 'abstract' ) )
            // InternalBug304681TestLanguage.g:4728:3: ( 'abstract' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getAbstractAbstractKeyword_0_1_0()); 
            }
            // InternalBug304681TestLanguage.g:4729:3: ( 'abstract' )
            // InternalBug304681TestLanguage.g:4730:4: 'abstract'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getAbstractAbstractKeyword_0_1_0()); 
            }
            match(input,32,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getAbstractAbstractKeyword_0_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getAbstractAbstractKeyword_0_1_0()); 
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
    // $ANTLR end "rule__Object__AbstractAssignment_0_1"


    // $ANTLR start "rule__Object__NameAssignment_2"
    // InternalBug304681TestLanguage.g:4741:1: rule__Object__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Object__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4745:1: ( ( RULE_ID ) )
            // InternalBug304681TestLanguage.g:4746:2: ( RULE_ID )
            {
            // InternalBug304681TestLanguage.g:4746:2: ( RULE_ID )
            // InternalBug304681TestLanguage.g:4747:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getNameIDTerminalRuleCall_2_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getNameIDTerminalRuleCall_2_0()); 
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
    // $ANTLR end "rule__Object__NameAssignment_2"


    // $ANTLR start "rule__Object__ParentAssignment_3_1"
    // InternalBug304681TestLanguage.g:4756:1: rule__Object__ParentAssignment_3_1 : ( ( RULE_ID ) ) ;
    public final void rule__Object__ParentAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4760:1: ( ( ( RULE_ID ) ) )
            // InternalBug304681TestLanguage.g:4761:2: ( ( RULE_ID ) )
            {
            // InternalBug304681TestLanguage.g:4761:2: ( ( RULE_ID ) )
            // InternalBug304681TestLanguage.g:4762:3: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getParentObjectCrossReference_3_1_0()); 
            }
            // InternalBug304681TestLanguage.g:4763:3: ( RULE_ID )
            // InternalBug304681TestLanguage.g:4764:4: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getParentObjectIDTerminalRuleCall_3_1_0_1()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getParentObjectIDTerminalRuleCall_3_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getParentObjectCrossReference_3_1_0()); 
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
    // $ANTLR end "rule__Object__ParentAssignment_3_1"


    // $ANTLR start "rule__Object__ShortDescriptionAssignment_5_0_1"
    // InternalBug304681TestLanguage.g:4775:1: rule__Object__ShortDescriptionAssignment_5_0_1 : ( RULE_STRING ) ;
    public final void rule__Object__ShortDescriptionAssignment_5_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4779:1: ( ( RULE_STRING ) )
            // InternalBug304681TestLanguage.g:4780:2: ( RULE_STRING )
            {
            // InternalBug304681TestLanguage.g:4780:2: ( RULE_STRING )
            // InternalBug304681TestLanguage.g:4781:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getShortDescriptionSTRINGTerminalRuleCall_5_0_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getShortDescriptionSTRINGTerminalRuleCall_5_0_1_0()); 
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
    // $ANTLR end "rule__Object__ShortDescriptionAssignment_5_0_1"


    // $ANTLR start "rule__Object__LongDescriptionAssignment_5_1_1"
    // InternalBug304681TestLanguage.g:4790:1: rule__Object__LongDescriptionAssignment_5_1_1 : ( RULE_STRING ) ;
    public final void rule__Object__LongDescriptionAssignment_5_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4794:1: ( ( RULE_STRING ) )
            // InternalBug304681TestLanguage.g:4795:2: ( RULE_STRING )
            {
            // InternalBug304681TestLanguage.g:4795:2: ( RULE_STRING )
            // InternalBug304681TestLanguage.g:4796:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getLongDescriptionSTRINGTerminalRuleCall_5_1_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getLongDescriptionSTRINGTerminalRuleCall_5_1_1_0()); 
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
    // $ANTLR end "rule__Object__LongDescriptionAssignment_5_1_1"


    // $ANTLR start "rule__Object__SerialVersionUIDAssignment_5_2_1"
    // InternalBug304681TestLanguage.g:4805:1: rule__Object__SerialVersionUIDAssignment_5_2_1 : ( RULE_INT ) ;
    public final void rule__Object__SerialVersionUIDAssignment_5_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4809:1: ( ( RULE_INT ) )
            // InternalBug304681TestLanguage.g:4810:2: ( RULE_INT )
            {
            // InternalBug304681TestLanguage.g:4810:2: ( RULE_INT )
            // InternalBug304681TestLanguage.g:4811:3: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getSerialVersionUIDINTTerminalRuleCall_5_2_1_0()); 
            }
            match(input,RULE_INT,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getSerialVersionUIDINTTerminalRuleCall_5_2_1_0()); 
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
    // $ANTLR end "rule__Object__SerialVersionUIDAssignment_5_2_1"


    // $ANTLR start "rule__Object__CloneableAssignment_5_3_0"
    // InternalBug304681TestLanguage.g:4820:1: rule__Object__CloneableAssignment_5_3_0 : ( ( 'cloneable' ) ) ;
    public final void rule__Object__CloneableAssignment_5_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4824:1: ( ( ( 'cloneable' ) ) )
            // InternalBug304681TestLanguage.g:4825:2: ( ( 'cloneable' ) )
            {
            // InternalBug304681TestLanguage.g:4825:2: ( ( 'cloneable' ) )
            // InternalBug304681TestLanguage.g:4826:3: ( 'cloneable' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getCloneableCloneableKeyword_5_3_0_0()); 
            }
            // InternalBug304681TestLanguage.g:4827:3: ( 'cloneable' )
            // InternalBug304681TestLanguage.g:4828:4: 'cloneable'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getCloneableCloneableKeyword_5_3_0_0()); 
            }
            match(input,33,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getCloneableCloneableKeyword_5_3_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getCloneableCloneableKeyword_5_3_0_0()); 
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
    // $ANTLR end "rule__Object__CloneableAssignment_5_3_0"


    // $ANTLR start "rule__Object__FeaturesAssignment_5_4"
    // InternalBug304681TestLanguage.g:4839:1: rule__Object__FeaturesAssignment_5_4 : ( ruleFeature ) ;
    public final void rule__Object__FeaturesAssignment_5_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4843:1: ( ( ruleFeature ) )
            // InternalBug304681TestLanguage.g:4844:2: ( ruleFeature )
            {
            // InternalBug304681TestLanguage.g:4844:2: ( ruleFeature )
            // InternalBug304681TestLanguage.g:4845:3: ruleFeature
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_4_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFeature();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_4_0()); 
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
    // $ANTLR end "rule__Object__FeaturesAssignment_5_4"


    // $ANTLR start "rule__Object__FeaturesAssignment_5_5_1"
    // InternalBug304681TestLanguage.g:4854:1: rule__Object__FeaturesAssignment_5_5_1 : ( ruleFeature ) ;
    public final void rule__Object__FeaturesAssignment_5_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4858:1: ( ( ruleFeature ) )
            // InternalBug304681TestLanguage.g:4859:2: ( ruleFeature )
            {
            // InternalBug304681TestLanguage.g:4859:2: ( ruleFeature )
            // InternalBug304681TestLanguage.g:4860:3: ruleFeature
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_5_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFeature();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_5_1_0()); 
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
    // $ANTLR end "rule__Object__FeaturesAssignment_5_5_1"


    // $ANTLR start "rule__Object__FeaturesAssignment_5_6_1"
    // InternalBug304681TestLanguage.g:4869:1: rule__Object__FeaturesAssignment_5_6_1 : ( ruleFeature ) ;
    public final void rule__Object__FeaturesAssignment_5_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4873:1: ( ( ruleFeature ) )
            // InternalBug304681TestLanguage.g:4874:2: ( ruleFeature )
            {
            // InternalBug304681TestLanguage.g:4874:2: ( ruleFeature )
            // InternalBug304681TestLanguage.g:4875:3: ruleFeature
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_6_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFeature();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_6_1_0()); 
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
    // $ANTLR end "rule__Object__FeaturesAssignment_5_6_1"


    // $ANTLR start "rule__Object__FeaturesAssignment_5_7_1"
    // InternalBug304681TestLanguage.g:4884:1: rule__Object__FeaturesAssignment_5_7_1 : ( ruleFeature ) ;
    public final void rule__Object__FeaturesAssignment_5_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4888:1: ( ( ruleFeature ) )
            // InternalBug304681TestLanguage.g:4889:2: ( ruleFeature )
            {
            // InternalBug304681TestLanguage.g:4889:2: ( ruleFeature )
            // InternalBug304681TestLanguage.g:4890:3: ruleFeature
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_7_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFeature();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_7_1_0()); 
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
    // $ANTLR end "rule__Object__FeaturesAssignment_5_7_1"


    // $ANTLR start "rule__Attribute__TypeAssignment_1"
    // InternalBug304681TestLanguage.g:4899:1: rule__Attribute__TypeAssignment_1 : ( RULE_ID ) ;
    public final void rule__Attribute__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4903:1: ( ( RULE_ID ) )
            // InternalBug304681TestLanguage.g:4904:2: ( RULE_ID )
            {
            // InternalBug304681TestLanguage.g:4904:2: ( RULE_ID )
            // InternalBug304681TestLanguage.g:4905:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getTypeIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeAccess().getTypeIDTerminalRuleCall_1_0()); 
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
    // $ANTLR end "rule__Attribute__TypeAssignment_1"


    // $ANTLR start "rule__Attribute__NameAssignment_2"
    // InternalBug304681TestLanguage.g:4914:1: rule__Attribute__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Attribute__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4918:1: ( ( RULE_ID ) )
            // InternalBug304681TestLanguage.g:4919:2: ( RULE_ID )
            {
            // InternalBug304681TestLanguage.g:4919:2: ( RULE_ID )
            // InternalBug304681TestLanguage.g:4920:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
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
    // $ANTLR end "rule__Attribute__NameAssignment_2"


    // $ANTLR start "rule__Reference__TypeAssignment_1"
    // InternalBug304681TestLanguage.g:4929:1: rule__Reference__TypeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Reference__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4933:1: ( ( ( RULE_ID ) ) )
            // InternalBug304681TestLanguage.g:4934:2: ( ( RULE_ID ) )
            {
            // InternalBug304681TestLanguage.g:4934:2: ( ( RULE_ID ) )
            // InternalBug304681TestLanguage.g:4935:3: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getTypeObjectCrossReference_1_0()); 
            }
            // InternalBug304681TestLanguage.g:4936:3: ( RULE_ID )
            // InternalBug304681TestLanguage.g:4937:4: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getTypeObjectIDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getTypeObjectIDTerminalRuleCall_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getTypeObjectCrossReference_1_0()); 
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
    // $ANTLR end "rule__Reference__TypeAssignment_1"


    // $ANTLR start "rule__Reference__ManyAssignment_2"
    // InternalBug304681TestLanguage.g:4948:1: rule__Reference__ManyAssignment_2 : ( ( '*' ) ) ;
    public final void rule__Reference__ManyAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4952:1: ( ( ( '*' ) ) )
            // InternalBug304681TestLanguage.g:4953:2: ( ( '*' ) )
            {
            // InternalBug304681TestLanguage.g:4953:2: ( ( '*' ) )
            // InternalBug304681TestLanguage.g:4954:3: ( '*' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getManyAsteriskKeyword_2_0()); 
            }
            // InternalBug304681TestLanguage.g:4955:3: ( '*' )
            // InternalBug304681TestLanguage.g:4956:4: '*'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getManyAsteriskKeyword_2_0()); 
            }
            match(input,34,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getManyAsteriskKeyword_2_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getManyAsteriskKeyword_2_0()); 
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
    // $ANTLR end "rule__Reference__ManyAssignment_2"


    // $ANTLR start "rule__Reference__NameAssignment_3"
    // InternalBug304681TestLanguage.g:4967:1: rule__Reference__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__Reference__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4971:1: ( ( RULE_ID ) )
            // InternalBug304681TestLanguage.g:4972:2: ( RULE_ID )
            {
            // InternalBug304681TestLanguage.g:4972:2: ( RULE_ID )
            // InternalBug304681TestLanguage.g:4973:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getNameIDTerminalRuleCall_3_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getNameIDTerminalRuleCall_3_0()); 
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
    // $ANTLR end "rule__Reference__NameAssignment_3"


    // $ANTLR start "rule__Reference__ShortDescriptionAssignment_4_0_1_0_1"
    // InternalBug304681TestLanguage.g:4982:1: rule__Reference__ShortDescriptionAssignment_4_0_1_0_1 : ( RULE_STRING ) ;
    public final void rule__Reference__ShortDescriptionAssignment_4_0_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4986:1: ( ( RULE_STRING ) )
            // InternalBug304681TestLanguage.g:4987:2: ( RULE_STRING )
            {
            // InternalBug304681TestLanguage.g:4987:2: ( RULE_STRING )
            // InternalBug304681TestLanguage.g:4988:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getShortDescriptionSTRINGTerminalRuleCall_4_0_1_0_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getShortDescriptionSTRINGTerminalRuleCall_4_0_1_0_1_0()); 
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
    // $ANTLR end "rule__Reference__ShortDescriptionAssignment_4_0_1_0_1"


    // $ANTLR start "rule__Reference__LongDescriptionAssignment_4_0_1_1_1"
    // InternalBug304681TestLanguage.g:4997:1: rule__Reference__LongDescriptionAssignment_4_0_1_1_1 : ( RULE_STRING ) ;
    public final void rule__Reference__LongDescriptionAssignment_4_0_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5001:1: ( ( RULE_STRING ) )
            // InternalBug304681TestLanguage.g:5002:2: ( RULE_STRING )
            {
            // InternalBug304681TestLanguage.g:5002:2: ( RULE_STRING )
            // InternalBug304681TestLanguage.g:5003:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getLongDescriptionSTRINGTerminalRuleCall_4_0_1_1_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getLongDescriptionSTRINGTerminalRuleCall_4_0_1_1_1_0()); 
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
    // $ANTLR end "rule__Reference__LongDescriptionAssignment_4_0_1_1_1"


    // $ANTLR start "rule__PackageDefinition2__NamespaceAssignment_2"
    // InternalBug304681TestLanguage.g:5012:1: rule__PackageDefinition2__NamespaceAssignment_2 : ( RULE_ID ) ;
    public final void rule__PackageDefinition2__NamespaceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5016:1: ( ( RULE_ID ) )
            // InternalBug304681TestLanguage.g:5017:2: ( RULE_ID )
            {
            // InternalBug304681TestLanguage.g:5017:2: ( RULE_ID )
            // InternalBug304681TestLanguage.g:5018:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageDefinition2Access().getNamespaceIDTerminalRuleCall_2_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageDefinition2Access().getNamespaceIDTerminalRuleCall_2_0()); 
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
    // $ANTLR end "rule__PackageDefinition2__NamespaceAssignment_2"


    // $ANTLR start "rule__PackageDefinition2__ContentsAssignment_4"
    // InternalBug304681TestLanguage.g:5027:1: rule__PackageDefinition2__ContentsAssignment_4 : ( ruleObject2 ) ;
    public final void rule__PackageDefinition2__ContentsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5031:1: ( ( ruleObject2 ) )
            // InternalBug304681TestLanguage.g:5032:2: ( ruleObject2 )
            {
            // InternalBug304681TestLanguage.g:5032:2: ( ruleObject2 )
            // InternalBug304681TestLanguage.g:5033:3: ruleObject2
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageDefinition2Access().getContentsObject2ParserRuleCall_4_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleObject2();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageDefinition2Access().getContentsObject2ParserRuleCall_4_0()); 
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
    // $ANTLR end "rule__PackageDefinition2__ContentsAssignment_4"


    // $ANTLR start "rule__Object2__EnabledAssignment_0_0"
    // InternalBug304681TestLanguage.g:5042:1: rule__Object2__EnabledAssignment_0_0 : ( ( 'enabled' ) ) ;
    public final void rule__Object2__EnabledAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5046:1: ( ( ( 'enabled' ) ) )
            // InternalBug304681TestLanguage.g:5047:2: ( ( 'enabled' ) )
            {
            // InternalBug304681TestLanguage.g:5047:2: ( ( 'enabled' ) )
            // InternalBug304681TestLanguage.g:5048:3: ( 'enabled' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getEnabledEnabledKeyword_0_0_0()); 
            }
            // InternalBug304681TestLanguage.g:5049:3: ( 'enabled' )
            // InternalBug304681TestLanguage.g:5050:4: 'enabled'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getEnabledEnabledKeyword_0_0_0()); 
            }
            match(input,31,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getEnabledEnabledKeyword_0_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getEnabledEnabledKeyword_0_0_0()); 
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
    // $ANTLR end "rule__Object2__EnabledAssignment_0_0"


    // $ANTLR start "rule__Object2__AbstractAssignment_0_1"
    // InternalBug304681TestLanguage.g:5061:1: rule__Object2__AbstractAssignment_0_1 : ( ( 'abstract' ) ) ;
    public final void rule__Object2__AbstractAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5065:1: ( ( ( 'abstract' ) ) )
            // InternalBug304681TestLanguage.g:5066:2: ( ( 'abstract' ) )
            {
            // InternalBug304681TestLanguage.g:5066:2: ( ( 'abstract' ) )
            // InternalBug304681TestLanguage.g:5067:3: ( 'abstract' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getAbstractAbstractKeyword_0_1_0()); 
            }
            // InternalBug304681TestLanguage.g:5068:3: ( 'abstract' )
            // InternalBug304681TestLanguage.g:5069:4: 'abstract'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getAbstractAbstractKeyword_0_1_0()); 
            }
            match(input,32,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getAbstractAbstractKeyword_0_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getAbstractAbstractKeyword_0_1_0()); 
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
    // $ANTLR end "rule__Object2__AbstractAssignment_0_1"


    // $ANTLR start "rule__Object2__NameAssignment_2"
    // InternalBug304681TestLanguage.g:5080:1: rule__Object2__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Object2__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5084:1: ( ( RULE_ID ) )
            // InternalBug304681TestLanguage.g:5085:2: ( RULE_ID )
            {
            // InternalBug304681TestLanguage.g:5085:2: ( RULE_ID )
            // InternalBug304681TestLanguage.g:5086:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getNameIDTerminalRuleCall_2_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getNameIDTerminalRuleCall_2_0()); 
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
    // $ANTLR end "rule__Object2__NameAssignment_2"


    // $ANTLR start "rule__Object2__ParentAssignment_3_1"
    // InternalBug304681TestLanguage.g:5095:1: rule__Object2__ParentAssignment_3_1 : ( ( RULE_ID ) ) ;
    public final void rule__Object2__ParentAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5099:1: ( ( ( RULE_ID ) ) )
            // InternalBug304681TestLanguage.g:5100:2: ( ( RULE_ID ) )
            {
            // InternalBug304681TestLanguage.g:5100:2: ( ( RULE_ID ) )
            // InternalBug304681TestLanguage.g:5101:3: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getParentObjectCrossReference_3_1_0()); 
            }
            // InternalBug304681TestLanguage.g:5102:3: ( RULE_ID )
            // InternalBug304681TestLanguage.g:5103:4: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getParentObjectIDTerminalRuleCall_3_1_0_1()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getParentObjectIDTerminalRuleCall_3_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getParentObjectCrossReference_3_1_0()); 
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
    // $ANTLR end "rule__Object2__ParentAssignment_3_1"


    // $ANTLR start "rule__Object2__ShortDescriptionAssignment_5_0_1"
    // InternalBug304681TestLanguage.g:5114:1: rule__Object2__ShortDescriptionAssignment_5_0_1 : ( RULE_STRING ) ;
    public final void rule__Object2__ShortDescriptionAssignment_5_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5118:1: ( ( RULE_STRING ) )
            // InternalBug304681TestLanguage.g:5119:2: ( RULE_STRING )
            {
            // InternalBug304681TestLanguage.g:5119:2: ( RULE_STRING )
            // InternalBug304681TestLanguage.g:5120:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getShortDescriptionSTRINGTerminalRuleCall_5_0_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getShortDescriptionSTRINGTerminalRuleCall_5_0_1_0()); 
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
    // $ANTLR end "rule__Object2__ShortDescriptionAssignment_5_0_1"


    // $ANTLR start "rule__Object2__LongDescriptionAssignment_5_1_1"
    // InternalBug304681TestLanguage.g:5129:1: rule__Object2__LongDescriptionAssignment_5_1_1 : ( RULE_STRING ) ;
    public final void rule__Object2__LongDescriptionAssignment_5_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5133:1: ( ( RULE_STRING ) )
            // InternalBug304681TestLanguage.g:5134:2: ( RULE_STRING )
            {
            // InternalBug304681TestLanguage.g:5134:2: ( RULE_STRING )
            // InternalBug304681TestLanguage.g:5135:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getLongDescriptionSTRINGTerminalRuleCall_5_1_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getLongDescriptionSTRINGTerminalRuleCall_5_1_1_0()); 
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
    // $ANTLR end "rule__Object2__LongDescriptionAssignment_5_1_1"


    // $ANTLR start "rule__Object2__SerialVersionUIDAssignment_5_2_1"
    // InternalBug304681TestLanguage.g:5144:1: rule__Object2__SerialVersionUIDAssignment_5_2_1 : ( RULE_INT ) ;
    public final void rule__Object2__SerialVersionUIDAssignment_5_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5148:1: ( ( RULE_INT ) )
            // InternalBug304681TestLanguage.g:5149:2: ( RULE_INT )
            {
            // InternalBug304681TestLanguage.g:5149:2: ( RULE_INT )
            // InternalBug304681TestLanguage.g:5150:3: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getSerialVersionUIDINTTerminalRuleCall_5_2_1_0()); 
            }
            match(input,RULE_INT,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getSerialVersionUIDINTTerminalRuleCall_5_2_1_0()); 
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
    // $ANTLR end "rule__Object2__SerialVersionUIDAssignment_5_2_1"


    // $ANTLR start "rule__Object2__CloneableAssignment_5_3_0"
    // InternalBug304681TestLanguage.g:5159:1: rule__Object2__CloneableAssignment_5_3_0 : ( ( 'cloneable' ) ) ;
    public final void rule__Object2__CloneableAssignment_5_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5163:1: ( ( ( 'cloneable' ) ) )
            // InternalBug304681TestLanguage.g:5164:2: ( ( 'cloneable' ) )
            {
            // InternalBug304681TestLanguage.g:5164:2: ( ( 'cloneable' ) )
            // InternalBug304681TestLanguage.g:5165:3: ( 'cloneable' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getCloneableCloneableKeyword_5_3_0_0()); 
            }
            // InternalBug304681TestLanguage.g:5166:3: ( 'cloneable' )
            // InternalBug304681TestLanguage.g:5167:4: 'cloneable'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getCloneableCloneableKeyword_5_3_0_0()); 
            }
            match(input,33,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getCloneableCloneableKeyword_5_3_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getCloneableCloneableKeyword_5_3_0_0()); 
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
    // $ANTLR end "rule__Object2__CloneableAssignment_5_3_0"


    // $ANTLR start "rule__Object2__FeaturesAssignment_5_4"
    // InternalBug304681TestLanguage.g:5178:1: rule__Object2__FeaturesAssignment_5_4 : ( ruleFeature2 ) ;
    public final void rule__Object2__FeaturesAssignment_5_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5182:1: ( ( ruleFeature2 ) )
            // InternalBug304681TestLanguage.g:5183:2: ( ruleFeature2 )
            {
            // InternalBug304681TestLanguage.g:5183:2: ( ruleFeature2 )
            // InternalBug304681TestLanguage.g:5184:3: ruleFeature2
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getFeaturesFeature2ParserRuleCall_5_4_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFeature2();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getFeaturesFeature2ParserRuleCall_5_4_0()); 
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
    // $ANTLR end "rule__Object2__FeaturesAssignment_5_4"


    // $ANTLR start "rule__Attribute2__TypeAssignment_1"
    // InternalBug304681TestLanguage.g:5193:1: rule__Attribute2__TypeAssignment_1 : ( RULE_ID ) ;
    public final void rule__Attribute2__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5197:1: ( ( RULE_ID ) )
            // InternalBug304681TestLanguage.g:5198:2: ( RULE_ID )
            {
            // InternalBug304681TestLanguage.g:5198:2: ( RULE_ID )
            // InternalBug304681TestLanguage.g:5199:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getTypeIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getTypeIDTerminalRuleCall_1_0()); 
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
    // $ANTLR end "rule__Attribute2__TypeAssignment_1"


    // $ANTLR start "rule__Attribute2__NameAssignment_2"
    // InternalBug304681TestLanguage.g:5208:1: rule__Attribute2__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Attribute2__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5212:1: ( ( RULE_ID ) )
            // InternalBug304681TestLanguage.g:5213:2: ( RULE_ID )
            {
            // InternalBug304681TestLanguage.g:5213:2: ( RULE_ID )
            // InternalBug304681TestLanguage.g:5214:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getNameIDTerminalRuleCall_2_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getNameIDTerminalRuleCall_2_0()); 
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
    // $ANTLR end "rule__Attribute2__NameAssignment_2"


    // $ANTLR start "rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1"
    // InternalBug304681TestLanguage.g:5223:1: rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1 : ( RULE_STRING ) ;
    public final void rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5227:1: ( ( RULE_STRING ) )
            // InternalBug304681TestLanguage.g:5228:2: ( RULE_STRING )
            {
            // InternalBug304681TestLanguage.g:5228:2: ( RULE_STRING )
            // InternalBug304681TestLanguage.g:5229:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getShortDescriptionSTRINGTerminalRuleCall_3_0_1_0_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getShortDescriptionSTRINGTerminalRuleCall_3_0_1_0_1_0()); 
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
    // $ANTLR end "rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1"


    // $ANTLR start "rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1"
    // InternalBug304681TestLanguage.g:5238:1: rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1 : ( RULE_STRING ) ;
    public final void rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5242:1: ( ( RULE_STRING ) )
            // InternalBug304681TestLanguage.g:5243:2: ( RULE_STRING )
            {
            // InternalBug304681TestLanguage.g:5243:2: ( RULE_STRING )
            // InternalBug304681TestLanguage.g:5244:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getLongDescriptionSTRINGTerminalRuleCall_3_0_1_1_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getLongDescriptionSTRINGTerminalRuleCall_3_0_1_1_1_0()); 
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
    // $ANTLR end "rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1"


    // $ANTLR start "rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2"
    // InternalBug304681TestLanguage.g:5253:1: rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 : ( ruleConstraintDefinition ) ;
    public final void rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5257:1: ( ( ruleConstraintDefinition ) )
            // InternalBug304681TestLanguage.g:5258:2: ( ruleConstraintDefinition )
            {
            // InternalBug304681TestLanguage.g:5258:2: ( ruleConstraintDefinition )
            // InternalBug304681TestLanguage.g:5259:3: ruleConstraintDefinition
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getConstraintDefinitionsConstraintDefinitionParserRuleCall_3_0_1_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleConstraintDefinition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getConstraintDefinitionsConstraintDefinitionParserRuleCall_3_0_1_2_0()); 
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
    // $ANTLR end "rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2"


    // $ANTLR start "rule__Attribute2__RequiredAssignment_3_0_1_3_0"
    // InternalBug304681TestLanguage.g:5268:1: rule__Attribute2__RequiredAssignment_3_0_1_3_0 : ( ( 'required' ) ) ;
    public final void rule__Attribute2__RequiredAssignment_3_0_1_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5272:1: ( ( ( 'required' ) ) )
            // InternalBug304681TestLanguage.g:5273:2: ( ( 'required' ) )
            {
            // InternalBug304681TestLanguage.g:5273:2: ( ( 'required' ) )
            // InternalBug304681TestLanguage.g:5274:3: ( 'required' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getRequiredRequiredKeyword_3_0_1_3_0_0()); 
            }
            // InternalBug304681TestLanguage.g:5275:3: ( 'required' )
            // InternalBug304681TestLanguage.g:5276:4: 'required'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getRequiredRequiredKeyword_3_0_1_3_0_0()); 
            }
            match(input,35,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getRequiredRequiredKeyword_3_0_1_3_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getRequiredRequiredKeyword_3_0_1_3_0_0()); 
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
    // $ANTLR end "rule__Attribute2__RequiredAssignment_3_0_1_3_0"


    // $ANTLR start "rule__Attribute2__TechnicalAssignment_3_0_1_4_0"
    // InternalBug304681TestLanguage.g:5287:1: rule__Attribute2__TechnicalAssignment_3_0_1_4_0 : ( ( 'technical' ) ) ;
    public final void rule__Attribute2__TechnicalAssignment_3_0_1_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5291:1: ( ( ( 'technical' ) ) )
            // InternalBug304681TestLanguage.g:5292:2: ( ( 'technical' ) )
            {
            // InternalBug304681TestLanguage.g:5292:2: ( ( 'technical' ) )
            // InternalBug304681TestLanguage.g:5293:3: ( 'technical' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getTechnicalTechnicalKeyword_3_0_1_4_0_0()); 
            }
            // InternalBug304681TestLanguage.g:5294:3: ( 'technical' )
            // InternalBug304681TestLanguage.g:5295:4: 'technical'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getTechnicalTechnicalKeyword_3_0_1_4_0_0()); 
            }
            match(input,36,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getTechnicalTechnicalKeyword_3_0_1_4_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getTechnicalTechnicalKeyword_3_0_1_4_0_0()); 
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
    // $ANTLR end "rule__Attribute2__TechnicalAssignment_3_0_1_4_0"


    // $ANTLR start "rule__Reference2__TypeAssignment_1"
    // InternalBug304681TestLanguage.g:5306:1: rule__Reference2__TypeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Reference2__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5310:1: ( ( ( RULE_ID ) ) )
            // InternalBug304681TestLanguage.g:5311:2: ( ( RULE_ID ) )
            {
            // InternalBug304681TestLanguage.g:5311:2: ( ( RULE_ID ) )
            // InternalBug304681TestLanguage.g:5312:3: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getTypeObjectCrossReference_1_0()); 
            }
            // InternalBug304681TestLanguage.g:5313:3: ( RULE_ID )
            // InternalBug304681TestLanguage.g:5314:4: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getTypeObjectIDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getTypeObjectIDTerminalRuleCall_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getTypeObjectCrossReference_1_0()); 
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
    // $ANTLR end "rule__Reference2__TypeAssignment_1"


    // $ANTLR start "rule__Reference2__ManyAssignment_2"
    // InternalBug304681TestLanguage.g:5325:1: rule__Reference2__ManyAssignment_2 : ( ( '*' ) ) ;
    public final void rule__Reference2__ManyAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5329:1: ( ( ( '*' ) ) )
            // InternalBug304681TestLanguage.g:5330:2: ( ( '*' ) )
            {
            // InternalBug304681TestLanguage.g:5330:2: ( ( '*' ) )
            // InternalBug304681TestLanguage.g:5331:3: ( '*' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getManyAsteriskKeyword_2_0()); 
            }
            // InternalBug304681TestLanguage.g:5332:3: ( '*' )
            // InternalBug304681TestLanguage.g:5333:4: '*'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getManyAsteriskKeyword_2_0()); 
            }
            match(input,34,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getManyAsteriskKeyword_2_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getManyAsteriskKeyword_2_0()); 
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
    // $ANTLR end "rule__Reference2__ManyAssignment_2"


    // $ANTLR start "rule__Reference2__NameAssignment_3"
    // InternalBug304681TestLanguage.g:5344:1: rule__Reference2__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__Reference2__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5348:1: ( ( RULE_ID ) )
            // InternalBug304681TestLanguage.g:5349:2: ( RULE_ID )
            {
            // InternalBug304681TestLanguage.g:5349:2: ( RULE_ID )
            // InternalBug304681TestLanguage.g:5350:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getNameIDTerminalRuleCall_3_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getNameIDTerminalRuleCall_3_0()); 
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
    // $ANTLR end "rule__Reference2__NameAssignment_3"


    // $ANTLR start "rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1"
    // InternalBug304681TestLanguage.g:5359:1: rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1 : ( RULE_STRING ) ;
    public final void rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5363:1: ( ( RULE_STRING ) )
            // InternalBug304681TestLanguage.g:5364:2: ( RULE_STRING )
            {
            // InternalBug304681TestLanguage.g:5364:2: ( RULE_STRING )
            // InternalBug304681TestLanguage.g:5365:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getShortDescriptionSTRINGTerminalRuleCall_4_0_1_0_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getShortDescriptionSTRINGTerminalRuleCall_4_0_1_0_1_0()); 
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
    // $ANTLR end "rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1"


    // $ANTLR start "rule__Reference2__LongDescriptionAssignment_4_0_1_1_1"
    // InternalBug304681TestLanguage.g:5374:1: rule__Reference2__LongDescriptionAssignment_4_0_1_1_1 : ( RULE_STRING ) ;
    public final void rule__Reference2__LongDescriptionAssignment_4_0_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5378:1: ( ( RULE_STRING ) )
            // InternalBug304681TestLanguage.g:5379:2: ( RULE_STRING )
            {
            // InternalBug304681TestLanguage.g:5379:2: ( RULE_STRING )
            // InternalBug304681TestLanguage.g:5380:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getLongDescriptionSTRINGTerminalRuleCall_4_0_1_1_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getLongDescriptionSTRINGTerminalRuleCall_4_0_1_1_1_0()); 
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
    // $ANTLR end "rule__Reference2__LongDescriptionAssignment_4_0_1_1_1"


    // $ANTLR start "rule__ConstraintDefinition__TypeAssignment_1"
    // InternalBug304681TestLanguage.g:5389:1: rule__ConstraintDefinition__TypeAssignment_1 : ( RULE_ID ) ;
    public final void rule__ConstraintDefinition__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5393:1: ( ( RULE_ID ) )
            // InternalBug304681TestLanguage.g:5394:2: ( RULE_ID )
            {
            // InternalBug304681TestLanguage.g:5394:2: ( RULE_ID )
            // InternalBug304681TestLanguage.g:5395:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintDefinitionAccess().getTypeIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintDefinitionAccess().getTypeIDTerminalRuleCall_1_0()); 
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
    // $ANTLR end "rule__ConstraintDefinition__TypeAssignment_1"


    // $ANTLR start "rule__ConstraintDefinition__ParametersAssignment_3_0_1"
    // InternalBug304681TestLanguage.g:5404:1: rule__ConstraintDefinition__ParametersAssignment_3_0_1 : ( RULE_STRING ) ;
    public final void rule__ConstraintDefinition__ParametersAssignment_3_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5408:1: ( ( RULE_STRING ) )
            // InternalBug304681TestLanguage.g:5409:2: ( RULE_STRING )
            {
            // InternalBug304681TestLanguage.g:5409:2: ( RULE_STRING )
            // InternalBug304681TestLanguage.g:5410:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintDefinitionAccess().getParametersSTRINGTerminalRuleCall_3_0_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintDefinitionAccess().getParametersSTRINGTerminalRuleCall_3_0_1_0()); 
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
    // $ANTLR end "rule__ConstraintDefinition__ParametersAssignment_3_0_1"


    // $ANTLR start "rule__ConstraintDefinition__MessageAssignment_3_1_1"
    // InternalBug304681TestLanguage.g:5419:1: rule__ConstraintDefinition__MessageAssignment_3_1_1 : ( RULE_STRING ) ;
    public final void rule__ConstraintDefinition__MessageAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5423:1: ( ( RULE_STRING ) )
            // InternalBug304681TestLanguage.g:5424:2: ( RULE_STRING )
            {
            // InternalBug304681TestLanguage.g:5424:2: ( RULE_STRING )
            // InternalBug304681TestLanguage.g:5425:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintDefinitionAccess().getMessageSTRINGTerminalRuleCall_3_1_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintDefinitionAccess().getMessageSTRINGTerminalRuleCall_3_1_1_0()); 
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
    // $ANTLR end "rule__ConstraintDefinition__MessageAssignment_3_1_1"

    // $ANTLR start synpred13_InternalBug304681TestLanguage
    public final void synpred13_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:1435:3: ( rule__Object__FeaturesAssignment_5_6_1 )
        // InternalBug304681TestLanguage.g:1435:3: rule__Object__FeaturesAssignment_5_6_1
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object__FeaturesAssignment_5_6_1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred13_InternalBug304681TestLanguage

    // $ANTLR start synpred14_InternalBug304681TestLanguage
    public final void synpred14_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:1495:4: ( rule__Object__FeaturesAssignment_5_7_1 )
        // InternalBug304681TestLanguage.g:1495:4: rule__Object__FeaturesAssignment_5_7_1
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object__FeaturesAssignment_5_7_1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_InternalBug304681TestLanguage

    // $ANTLR start synpred21_InternalBug304681TestLanguage
    public final void synpred21_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:3806:2: ( rule__Object__UnorderedGroup_5__0 )
        // InternalBug304681TestLanguage.g:3806:2: rule__Object__UnorderedGroup_5__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object__UnorderedGroup_5__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred21_InternalBug304681TestLanguage

    // $ANTLR start synpred22_InternalBug304681TestLanguage
    public final void synpred22_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:3821:3: ( ({...}? => ( ( ( rule__Object__Group_5_0__0 ) ) ) ) )
        // InternalBug304681TestLanguage.g:3821:3: ({...}? => ( ( ( rule__Object__Group_5_0__0 ) ) ) )
        {
        // InternalBug304681TestLanguage.g:3821:3: ({...}? => ( ( ( rule__Object__Group_5_0__0 ) ) ) )
        // InternalBug304681TestLanguage.g:3822:4: {...}? => ( ( ( rule__Object__Group_5_0__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred22_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0)");
        }
        // InternalBug304681TestLanguage.g:3822:102: ( ( ( rule__Object__Group_5_0__0 ) ) )
        // InternalBug304681TestLanguage.g:3823:5: ( ( rule__Object__Group_5_0__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0);
        // InternalBug304681TestLanguage.g:3829:5: ( ( rule__Object__Group_5_0__0 ) )
        // InternalBug304681TestLanguage.g:3830:6: ( rule__Object__Group_5_0__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getObjectAccess().getGroup_5_0()); 
        }
        // InternalBug304681TestLanguage.g:3831:6: ( rule__Object__Group_5_0__0 )
        // InternalBug304681TestLanguage.g:3831:7: rule__Object__Group_5_0__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object__Group_5_0__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred22_InternalBug304681TestLanguage

    // $ANTLR start synpred23_InternalBug304681TestLanguage
    public final void synpred23_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:3836:3: ( ({...}? => ( ( ( rule__Object__Group_5_1__0 ) ) ) ) )
        // InternalBug304681TestLanguage.g:3836:3: ({...}? => ( ( ( rule__Object__Group_5_1__0 ) ) ) )
        {
        // InternalBug304681TestLanguage.g:3836:3: ({...}? => ( ( ( rule__Object__Group_5_1__0 ) ) ) )
        // InternalBug304681TestLanguage.g:3837:4: {...}? => ( ( ( rule__Object__Group_5_1__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred23_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1)");
        }
        // InternalBug304681TestLanguage.g:3837:102: ( ( ( rule__Object__Group_5_1__0 ) ) )
        // InternalBug304681TestLanguage.g:3838:5: ( ( rule__Object__Group_5_1__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1);
        // InternalBug304681TestLanguage.g:3844:5: ( ( rule__Object__Group_5_1__0 ) )
        // InternalBug304681TestLanguage.g:3845:6: ( rule__Object__Group_5_1__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getObjectAccess().getGroup_5_1()); 
        }
        // InternalBug304681TestLanguage.g:3846:6: ( rule__Object__Group_5_1__0 )
        // InternalBug304681TestLanguage.g:3846:7: rule__Object__Group_5_1__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object__Group_5_1__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred23_InternalBug304681TestLanguage

    // $ANTLR start synpred24_InternalBug304681TestLanguage
    public final void synpred24_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:3851:3: ( ({...}? => ( ( ( rule__Object__Group_5_2__0 ) ) ) ) )
        // InternalBug304681TestLanguage.g:3851:3: ({...}? => ( ( ( rule__Object__Group_5_2__0 ) ) ) )
        {
        // InternalBug304681TestLanguage.g:3851:3: ({...}? => ( ( ( rule__Object__Group_5_2__0 ) ) ) )
        // InternalBug304681TestLanguage.g:3852:4: {...}? => ( ( ( rule__Object__Group_5_2__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred24_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2)");
        }
        // InternalBug304681TestLanguage.g:3852:102: ( ( ( rule__Object__Group_5_2__0 ) ) )
        // InternalBug304681TestLanguage.g:3853:5: ( ( rule__Object__Group_5_2__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2);
        // InternalBug304681TestLanguage.g:3859:5: ( ( rule__Object__Group_5_2__0 ) )
        // InternalBug304681TestLanguage.g:3860:6: ( rule__Object__Group_5_2__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getObjectAccess().getGroup_5_2()); 
        }
        // InternalBug304681TestLanguage.g:3861:6: ( rule__Object__Group_5_2__0 )
        // InternalBug304681TestLanguage.g:3861:7: rule__Object__Group_5_2__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object__Group_5_2__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred24_InternalBug304681TestLanguage

    // $ANTLR start synpred25_InternalBug304681TestLanguage
    public final void synpred25_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:3866:3: ( ({...}? => ( ( ( rule__Object__Group_5_3__0 ) ) ) ) )
        // InternalBug304681TestLanguage.g:3866:3: ({...}? => ( ( ( rule__Object__Group_5_3__0 ) ) ) )
        {
        // InternalBug304681TestLanguage.g:3866:3: ({...}? => ( ( ( rule__Object__Group_5_3__0 ) ) ) )
        // InternalBug304681TestLanguage.g:3867:4: {...}? => ( ( ( rule__Object__Group_5_3__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred25_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3)");
        }
        // InternalBug304681TestLanguage.g:3867:102: ( ( ( rule__Object__Group_5_3__0 ) ) )
        // InternalBug304681TestLanguage.g:3868:5: ( ( rule__Object__Group_5_3__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3);
        // InternalBug304681TestLanguage.g:3874:5: ( ( rule__Object__Group_5_3__0 ) )
        // InternalBug304681TestLanguage.g:3875:6: ( rule__Object__Group_5_3__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getObjectAccess().getGroup_5_3()); 
        }
        // InternalBug304681TestLanguage.g:3876:6: ( rule__Object__Group_5_3__0 )
        // InternalBug304681TestLanguage.g:3876:7: rule__Object__Group_5_3__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object__Group_5_3__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred25_InternalBug304681TestLanguage

    // $ANTLR start synpred26_InternalBug304681TestLanguage
    public final void synpred26_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:3897:8: ( rule__Object__FeaturesAssignment_5_4 )
        // InternalBug304681TestLanguage.g:3897:9: rule__Object__FeaturesAssignment_5_4
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object__FeaturesAssignment_5_4();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_InternalBug304681TestLanguage

    // $ANTLR start synpred27_InternalBug304681TestLanguage
    public final void synpred27_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:3881:3: ( ({...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* ) ) ) ) )
        // InternalBug304681TestLanguage.g:3881:3: ({...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* ) ) ) )
        {
        // InternalBug304681TestLanguage.g:3881:3: ({...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* ) ) ) )
        // InternalBug304681TestLanguage.g:3882:4: {...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred27_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4)");
        }
        // InternalBug304681TestLanguage.g:3882:102: ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* ) ) )
        // InternalBug304681TestLanguage.g:3883:5: ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4);
        // InternalBug304681TestLanguage.g:3889:5: ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* ) )
        // InternalBug304681TestLanguage.g:3890:6: ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* )
        {
        // InternalBug304681TestLanguage.g:3890:6: ( ( rule__Object__FeaturesAssignment_5_4 ) )
        // InternalBug304681TestLanguage.g:3891:7: ( rule__Object__FeaturesAssignment_5_4 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getObjectAccess().getFeaturesAssignment_5_4()); 
        }
        // InternalBug304681TestLanguage.g:3892:7: ( rule__Object__FeaturesAssignment_5_4 )
        // InternalBug304681TestLanguage.g:3892:8: rule__Object__FeaturesAssignment_5_4
        {
        pushFollow(FollowSets000.FOLLOW_14);
        rule__Object__FeaturesAssignment_5_4();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalBug304681TestLanguage.g:3895:6: ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* )
        // InternalBug304681TestLanguage.g:3896:7: ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )*
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getObjectAccess().getFeaturesAssignment_5_4()); 
        }
        // InternalBug304681TestLanguage.g:3897:7: ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )*
        loop53:
        do {
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==26) && (synpred26_InternalBug304681TestLanguage())) {
                alt53=1;
            }
            else if ( (LA53_0==27) && (synpred26_InternalBug304681TestLanguage())) {
                alt53=1;
            }


            switch (alt53) {
        	case 1 :
        	    // InternalBug304681TestLanguage.g:3897:8: ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4
        	    {
        	    pushFollow(FollowSets000.FOLLOW_14);
        	    rule__Object__FeaturesAssignment_5_4();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop53;
            }
        } while (true);


        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred27_InternalBug304681TestLanguage

    // $ANTLR start synpred28_InternalBug304681TestLanguage
    public final void synpred28_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:3903:3: ( ({...}? => ( ( ( rule__Object__Group_5_5__0 ) ) ) ) )
        // InternalBug304681TestLanguage.g:3903:3: ({...}? => ( ( ( rule__Object__Group_5_5__0 ) ) ) )
        {
        // InternalBug304681TestLanguage.g:3903:3: ({...}? => ( ( ( rule__Object__Group_5_5__0 ) ) ) )
        // InternalBug304681TestLanguage.g:3904:4: {...}? => ( ( ( rule__Object__Group_5_5__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred28_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5)");
        }
        // InternalBug304681TestLanguage.g:3904:102: ( ( ( rule__Object__Group_5_5__0 ) ) )
        // InternalBug304681TestLanguage.g:3905:5: ( ( rule__Object__Group_5_5__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5);
        // InternalBug304681TestLanguage.g:3911:5: ( ( rule__Object__Group_5_5__0 ) )
        // InternalBug304681TestLanguage.g:3912:6: ( rule__Object__Group_5_5__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getObjectAccess().getGroup_5_5()); 
        }
        // InternalBug304681TestLanguage.g:3913:6: ( rule__Object__Group_5_5__0 )
        // InternalBug304681TestLanguage.g:3913:7: rule__Object__Group_5_5__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object__Group_5_5__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred28_InternalBug304681TestLanguage

    // $ANTLR start synpred29_InternalBug304681TestLanguage
    public final void synpred29_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:3918:3: ( ({...}? => ( ( ( rule__Object__Group_5_6__0 ) ) ) ) )
        // InternalBug304681TestLanguage.g:3918:3: ({...}? => ( ( ( rule__Object__Group_5_6__0 ) ) ) )
        {
        // InternalBug304681TestLanguage.g:3918:3: ({...}? => ( ( ( rule__Object__Group_5_6__0 ) ) ) )
        // InternalBug304681TestLanguage.g:3919:4: {...}? => ( ( ( rule__Object__Group_5_6__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred29_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6)");
        }
        // InternalBug304681TestLanguage.g:3919:102: ( ( ( rule__Object__Group_5_6__0 ) ) )
        // InternalBug304681TestLanguage.g:3920:5: ( ( rule__Object__Group_5_6__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6);
        // InternalBug304681TestLanguage.g:3926:5: ( ( rule__Object__Group_5_6__0 ) )
        // InternalBug304681TestLanguage.g:3927:6: ( rule__Object__Group_5_6__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getObjectAccess().getGroup_5_6()); 
        }
        // InternalBug304681TestLanguage.g:3928:6: ( rule__Object__Group_5_6__0 )
        // InternalBug304681TestLanguage.g:3928:7: rule__Object__Group_5_6__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object__Group_5_6__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred29_InternalBug304681TestLanguage

    // $ANTLR start synpred30_InternalBug304681TestLanguage
    public final void synpred30_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:3962:2: ( rule__Object__UnorderedGroup_5__1 )
        // InternalBug304681TestLanguage.g:3962:2: rule__Object__UnorderedGroup_5__1
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object__UnorderedGroup_5__1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_InternalBug304681TestLanguage

    // $ANTLR start synpred31_InternalBug304681TestLanguage
    public final void synpred31_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:3974:2: ( rule__Object__UnorderedGroup_5__2 )
        // InternalBug304681TestLanguage.g:3974:2: rule__Object__UnorderedGroup_5__2
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object__UnorderedGroup_5__2();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred31_InternalBug304681TestLanguage

    // $ANTLR start synpred32_InternalBug304681TestLanguage
    public final void synpred32_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:3986:2: ( rule__Object__UnorderedGroup_5__3 )
        // InternalBug304681TestLanguage.g:3986:2: rule__Object__UnorderedGroup_5__3
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object__UnorderedGroup_5__3();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred32_InternalBug304681TestLanguage

    // $ANTLR start synpred33_InternalBug304681TestLanguage
    public final void synpred33_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:3998:2: ( rule__Object__UnorderedGroup_5__4 )
        // InternalBug304681TestLanguage.g:3998:2: rule__Object__UnorderedGroup_5__4
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object__UnorderedGroup_5__4();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred33_InternalBug304681TestLanguage

    // $ANTLR start synpred34_InternalBug304681TestLanguage
    public final void synpred34_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4010:2: ( rule__Object__UnorderedGroup_5__5 )
        // InternalBug304681TestLanguage.g:4010:2: rule__Object__UnorderedGroup_5__5
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object__UnorderedGroup_5__5();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred34_InternalBug304681TestLanguage

    // $ANTLR start synpred35_InternalBug304681TestLanguage
    public final void synpred35_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4022:2: ( rule__Object__UnorderedGroup_5__6 )
        // InternalBug304681TestLanguage.g:4022:2: rule__Object__UnorderedGroup_5__6
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object__UnorderedGroup_5__6();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred35_InternalBug304681TestLanguage

    // $ANTLR start synpred36_InternalBug304681TestLanguage
    public final void synpred36_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4034:2: ( rule__Object__UnorderedGroup_5__7 )
        // InternalBug304681TestLanguage.g:4034:2: rule__Object__UnorderedGroup_5__7
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object__UnorderedGroup_5__7();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred36_InternalBug304681TestLanguage

    // $ANTLR start synpred37_InternalBug304681TestLanguage
    public final void synpred37_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4058:2: ( rule__Reference__UnorderedGroup_4_0_1__0 )
        // InternalBug304681TestLanguage.g:4058:2: rule__Reference__UnorderedGroup_4_0_1__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Reference__UnorderedGroup_4_0_1__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred37_InternalBug304681TestLanguage

    // $ANTLR start synpred38_InternalBug304681TestLanguage
    public final void synpred38_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4073:3: ( ({...}? => ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) ) ) )
        // InternalBug304681TestLanguage.g:4073:3: ({...}? => ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) ) )
        {
        // InternalBug304681TestLanguage.g:4073:3: ({...}? => ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) ) )
        // InternalBug304681TestLanguage.g:4074:4: {...}? => ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred38_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0)");
        }
        // InternalBug304681TestLanguage.g:4074:109: ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) )
        // InternalBug304681TestLanguage.g:4075:5: ( ( rule__Reference__Group_4_0_1_0__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0);
        // InternalBug304681TestLanguage.g:4081:5: ( ( rule__Reference__Group_4_0_1_0__0 ) )
        // InternalBug304681TestLanguage.g:4082:6: ( rule__Reference__Group_4_0_1_0__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getReferenceAccess().getGroup_4_0_1_0()); 
        }
        // InternalBug304681TestLanguage.g:4083:6: ( rule__Reference__Group_4_0_1_0__0 )
        // InternalBug304681TestLanguage.g:4083:7: rule__Reference__Group_4_0_1_0__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Reference__Group_4_0_1_0__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred38_InternalBug304681TestLanguage

    // $ANTLR start synpred39_InternalBug304681TestLanguage
    public final void synpred39_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4117:2: ( rule__Reference__UnorderedGroup_4_0_1__1 )
        // InternalBug304681TestLanguage.g:4117:2: rule__Reference__UnorderedGroup_4_0_1__1
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Reference__UnorderedGroup_4_0_1__1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_InternalBug304681TestLanguage

    // $ANTLR start synpred40_InternalBug304681TestLanguage
    public final void synpred40_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4141:2: ( rule__Object2__UnorderedGroup_5__0 )
        // InternalBug304681TestLanguage.g:4141:2: rule__Object2__UnorderedGroup_5__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object2__UnorderedGroup_5__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred40_InternalBug304681TestLanguage

    // $ANTLR start synpred41_InternalBug304681TestLanguage
    public final void synpred41_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4156:3: ( ({...}? => ( ( ( rule__Object2__Group_5_0__0 ) ) ) ) )
        // InternalBug304681TestLanguage.g:4156:3: ({...}? => ( ( ( rule__Object2__Group_5_0__0 ) ) ) )
        {
        // InternalBug304681TestLanguage.g:4156:3: ({...}? => ( ( ( rule__Object2__Group_5_0__0 ) ) ) )
        // InternalBug304681TestLanguage.g:4157:4: {...}? => ( ( ( rule__Object2__Group_5_0__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred41_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0)");
        }
        // InternalBug304681TestLanguage.g:4157:103: ( ( ( rule__Object2__Group_5_0__0 ) ) )
        // InternalBug304681TestLanguage.g:4158:5: ( ( rule__Object2__Group_5_0__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0);
        // InternalBug304681TestLanguage.g:4164:5: ( ( rule__Object2__Group_5_0__0 ) )
        // InternalBug304681TestLanguage.g:4165:6: ( rule__Object2__Group_5_0__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getObject2Access().getGroup_5_0()); 
        }
        // InternalBug304681TestLanguage.g:4166:6: ( rule__Object2__Group_5_0__0 )
        // InternalBug304681TestLanguage.g:4166:7: rule__Object2__Group_5_0__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object2__Group_5_0__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred41_InternalBug304681TestLanguage

    // $ANTLR start synpred42_InternalBug304681TestLanguage
    public final void synpred42_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4171:3: ( ({...}? => ( ( ( rule__Object2__Group_5_1__0 ) ) ) ) )
        // InternalBug304681TestLanguage.g:4171:3: ({...}? => ( ( ( rule__Object2__Group_5_1__0 ) ) ) )
        {
        // InternalBug304681TestLanguage.g:4171:3: ({...}? => ( ( ( rule__Object2__Group_5_1__0 ) ) ) )
        // InternalBug304681TestLanguage.g:4172:4: {...}? => ( ( ( rule__Object2__Group_5_1__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred42_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1)");
        }
        // InternalBug304681TestLanguage.g:4172:103: ( ( ( rule__Object2__Group_5_1__0 ) ) )
        // InternalBug304681TestLanguage.g:4173:5: ( ( rule__Object2__Group_5_1__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1);
        // InternalBug304681TestLanguage.g:4179:5: ( ( rule__Object2__Group_5_1__0 ) )
        // InternalBug304681TestLanguage.g:4180:6: ( rule__Object2__Group_5_1__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getObject2Access().getGroup_5_1()); 
        }
        // InternalBug304681TestLanguage.g:4181:6: ( rule__Object2__Group_5_1__0 )
        // InternalBug304681TestLanguage.g:4181:7: rule__Object2__Group_5_1__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object2__Group_5_1__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred42_InternalBug304681TestLanguage

    // $ANTLR start synpred43_InternalBug304681TestLanguage
    public final void synpred43_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4186:3: ( ({...}? => ( ( ( rule__Object2__Group_5_2__0 ) ) ) ) )
        // InternalBug304681TestLanguage.g:4186:3: ({...}? => ( ( ( rule__Object2__Group_5_2__0 ) ) ) )
        {
        // InternalBug304681TestLanguage.g:4186:3: ({...}? => ( ( ( rule__Object2__Group_5_2__0 ) ) ) )
        // InternalBug304681TestLanguage.g:4187:4: {...}? => ( ( ( rule__Object2__Group_5_2__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred43_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2)");
        }
        // InternalBug304681TestLanguage.g:4187:103: ( ( ( rule__Object2__Group_5_2__0 ) ) )
        // InternalBug304681TestLanguage.g:4188:5: ( ( rule__Object2__Group_5_2__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2);
        // InternalBug304681TestLanguage.g:4194:5: ( ( rule__Object2__Group_5_2__0 ) )
        // InternalBug304681TestLanguage.g:4195:6: ( rule__Object2__Group_5_2__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getObject2Access().getGroup_5_2()); 
        }
        // InternalBug304681TestLanguage.g:4196:6: ( rule__Object2__Group_5_2__0 )
        // InternalBug304681TestLanguage.g:4196:7: rule__Object2__Group_5_2__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object2__Group_5_2__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred43_InternalBug304681TestLanguage

    // $ANTLR start synpred44_InternalBug304681TestLanguage
    public final void synpred44_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4201:3: ( ({...}? => ( ( ( rule__Object2__Group_5_3__0 ) ) ) ) )
        // InternalBug304681TestLanguage.g:4201:3: ({...}? => ( ( ( rule__Object2__Group_5_3__0 ) ) ) )
        {
        // InternalBug304681TestLanguage.g:4201:3: ({...}? => ( ( ( rule__Object2__Group_5_3__0 ) ) ) )
        // InternalBug304681TestLanguage.g:4202:4: {...}? => ( ( ( rule__Object2__Group_5_3__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred44_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3)");
        }
        // InternalBug304681TestLanguage.g:4202:103: ( ( ( rule__Object2__Group_5_3__0 ) ) )
        // InternalBug304681TestLanguage.g:4203:5: ( ( rule__Object2__Group_5_3__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3);
        // InternalBug304681TestLanguage.g:4209:5: ( ( rule__Object2__Group_5_3__0 ) )
        // InternalBug304681TestLanguage.g:4210:6: ( rule__Object2__Group_5_3__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getObject2Access().getGroup_5_3()); 
        }
        // InternalBug304681TestLanguage.g:4211:6: ( rule__Object2__Group_5_3__0 )
        // InternalBug304681TestLanguage.g:4211:7: rule__Object2__Group_5_3__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object2__Group_5_3__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred44_InternalBug304681TestLanguage

    // $ANTLR start synpred45_InternalBug304681TestLanguage
    public final void synpred45_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4232:8: ( rule__Object2__FeaturesAssignment_5_4 )
        // InternalBug304681TestLanguage.g:4232:9: rule__Object2__FeaturesAssignment_5_4
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object2__FeaturesAssignment_5_4();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred45_InternalBug304681TestLanguage

    // $ANTLR start synpred46_InternalBug304681TestLanguage
    public final void synpred46_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4252:2: ( rule__Object2__UnorderedGroup_5__1 )
        // InternalBug304681TestLanguage.g:4252:2: rule__Object2__UnorderedGroup_5__1
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object2__UnorderedGroup_5__1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred46_InternalBug304681TestLanguage

    // $ANTLR start synpred47_InternalBug304681TestLanguage
    public final void synpred47_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4264:2: ( rule__Object2__UnorderedGroup_5__2 )
        // InternalBug304681TestLanguage.g:4264:2: rule__Object2__UnorderedGroup_5__2
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object2__UnorderedGroup_5__2();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred47_InternalBug304681TestLanguage

    // $ANTLR start synpred48_InternalBug304681TestLanguage
    public final void synpred48_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4276:2: ( rule__Object2__UnorderedGroup_5__3 )
        // InternalBug304681TestLanguage.g:4276:2: rule__Object2__UnorderedGroup_5__3
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object2__UnorderedGroup_5__3();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred48_InternalBug304681TestLanguage

    // $ANTLR start synpred49_InternalBug304681TestLanguage
    public final void synpred49_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4288:2: ( rule__Object2__UnorderedGroup_5__4 )
        // InternalBug304681TestLanguage.g:4288:2: rule__Object2__UnorderedGroup_5__4
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object2__UnorderedGroup_5__4();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred49_InternalBug304681TestLanguage

    // $ANTLR start synpred50_InternalBug304681TestLanguage
    public final void synpred50_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4312:2: ( rule__Attribute2__UnorderedGroup_3_0_1__0 )
        // InternalBug304681TestLanguage.g:4312:2: rule__Attribute2__UnorderedGroup_3_0_1__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Attribute2__UnorderedGroup_3_0_1__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred50_InternalBug304681TestLanguage

    // $ANTLR start synpred51_InternalBug304681TestLanguage
    public final void synpred51_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4327:3: ( ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_0__0 ) ) ) ) )
        // InternalBug304681TestLanguage.g:4327:3: ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_0__0 ) ) ) )
        {
        // InternalBug304681TestLanguage.g:4327:3: ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_0__0 ) ) ) )
        // InternalBug304681TestLanguage.g:4328:4: {...}? => ( ( ( rule__Attribute2__Group_3_0_1_0__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred51_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0)");
        }
        // InternalBug304681TestLanguage.g:4328:110: ( ( ( rule__Attribute2__Group_3_0_1_0__0 ) ) )
        // InternalBug304681TestLanguage.g:4329:5: ( ( rule__Attribute2__Group_3_0_1_0__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0);
        // InternalBug304681TestLanguage.g:4335:5: ( ( rule__Attribute2__Group_3_0_1_0__0 ) )
        // InternalBug304681TestLanguage.g:4336:6: ( rule__Attribute2__Group_3_0_1_0__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getAttribute2Access().getGroup_3_0_1_0()); 
        }
        // InternalBug304681TestLanguage.g:4337:6: ( rule__Attribute2__Group_3_0_1_0__0 )
        // InternalBug304681TestLanguage.g:4337:7: rule__Attribute2__Group_3_0_1_0__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Attribute2__Group_3_0_1_0__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred51_InternalBug304681TestLanguage

    // $ANTLR start synpred52_InternalBug304681TestLanguage
    public final void synpred52_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4342:3: ( ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_1__0 ) ) ) ) )
        // InternalBug304681TestLanguage.g:4342:3: ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_1__0 ) ) ) )
        {
        // InternalBug304681TestLanguage.g:4342:3: ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_1__0 ) ) ) )
        // InternalBug304681TestLanguage.g:4343:4: {...}? => ( ( ( rule__Attribute2__Group_3_0_1_1__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred52_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1)");
        }
        // InternalBug304681TestLanguage.g:4343:110: ( ( ( rule__Attribute2__Group_3_0_1_1__0 ) ) )
        // InternalBug304681TestLanguage.g:4344:5: ( ( rule__Attribute2__Group_3_0_1_1__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1);
        // InternalBug304681TestLanguage.g:4350:5: ( ( rule__Attribute2__Group_3_0_1_1__0 ) )
        // InternalBug304681TestLanguage.g:4351:6: ( rule__Attribute2__Group_3_0_1_1__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getAttribute2Access().getGroup_3_0_1_1()); 
        }
        // InternalBug304681TestLanguage.g:4352:6: ( rule__Attribute2__Group_3_0_1_1__0 )
        // InternalBug304681TestLanguage.g:4352:7: rule__Attribute2__Group_3_0_1_1__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Attribute2__Group_3_0_1_1__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred52_InternalBug304681TestLanguage

    // $ANTLR start synpred53_InternalBug304681TestLanguage
    public final void synpred53_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4373:8: ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )
        // InternalBug304681TestLanguage.g:4373:9: rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred53_InternalBug304681TestLanguage

    // $ANTLR start synpred54_InternalBug304681TestLanguage
    public final void synpred54_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4357:3: ( ({...}? => ( ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) ) ) ) )
        // InternalBug304681TestLanguage.g:4357:3: ({...}? => ( ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) ) ) )
        {
        // InternalBug304681TestLanguage.g:4357:3: ({...}? => ( ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) ) ) )
        // InternalBug304681TestLanguage.g:4358:4: {...}? => ( ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred54_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2)");
        }
        // InternalBug304681TestLanguage.g:4358:110: ( ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) ) )
        // InternalBug304681TestLanguage.g:4359:5: ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2);
        // InternalBug304681TestLanguage.g:4365:5: ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) )
        // InternalBug304681TestLanguage.g:4366:6: ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* )
        {
        // InternalBug304681TestLanguage.g:4366:6: ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) )
        // InternalBug304681TestLanguage.g:4367:7: ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getAttribute2Access().getConstraintDefinitionsAssignment_3_0_1_2()); 
        }
        // InternalBug304681TestLanguage.g:4368:7: ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )
        // InternalBug304681TestLanguage.g:4368:8: rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2
        {
        pushFollow(FollowSets000.FOLLOW_28);
        rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalBug304681TestLanguage.g:4371:6: ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* )
        // InternalBug304681TestLanguage.g:4372:7: ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )*
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getAttribute2Access().getConstraintDefinitionsAssignment_3_0_1_2()); 
        }
        // InternalBug304681TestLanguage.g:4373:7: ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )*
        loop54:
        do {
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==28) && (synpred53_InternalBug304681TestLanguage())) {
                alt54=1;
            }


            switch (alt54) {
        	case 1 :
        	    // InternalBug304681TestLanguage.g:4373:8: ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2
        	    {
        	    pushFollow(FollowSets000.FOLLOW_28);
        	    rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop54;
            }
        } while (true);


        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred54_InternalBug304681TestLanguage

    // $ANTLR start synpred55_InternalBug304681TestLanguage
    public final void synpred55_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4379:3: ( ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_3__0 ) ) ) ) )
        // InternalBug304681TestLanguage.g:4379:3: ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_3__0 ) ) ) )
        {
        // InternalBug304681TestLanguage.g:4379:3: ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_3__0 ) ) ) )
        // InternalBug304681TestLanguage.g:4380:4: {...}? => ( ( ( rule__Attribute2__Group_3_0_1_3__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred55_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3)");
        }
        // InternalBug304681TestLanguage.g:4380:110: ( ( ( rule__Attribute2__Group_3_0_1_3__0 ) ) )
        // InternalBug304681TestLanguage.g:4381:5: ( ( rule__Attribute2__Group_3_0_1_3__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3);
        // InternalBug304681TestLanguage.g:4387:5: ( ( rule__Attribute2__Group_3_0_1_3__0 ) )
        // InternalBug304681TestLanguage.g:4388:6: ( rule__Attribute2__Group_3_0_1_3__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getAttribute2Access().getGroup_3_0_1_3()); 
        }
        // InternalBug304681TestLanguage.g:4389:6: ( rule__Attribute2__Group_3_0_1_3__0 )
        // InternalBug304681TestLanguage.g:4389:7: rule__Attribute2__Group_3_0_1_3__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Attribute2__Group_3_0_1_3__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred55_InternalBug304681TestLanguage

    // $ANTLR start synpred56_InternalBug304681TestLanguage
    public final void synpred56_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4423:2: ( rule__Attribute2__UnorderedGroup_3_0_1__1 )
        // InternalBug304681TestLanguage.g:4423:2: rule__Attribute2__UnorderedGroup_3_0_1__1
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Attribute2__UnorderedGroup_3_0_1__1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred56_InternalBug304681TestLanguage

    // $ANTLR start synpred57_InternalBug304681TestLanguage
    public final void synpred57_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4435:2: ( rule__Attribute2__UnorderedGroup_3_0_1__2 )
        // InternalBug304681TestLanguage.g:4435:2: rule__Attribute2__UnorderedGroup_3_0_1__2
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Attribute2__UnorderedGroup_3_0_1__2();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred57_InternalBug304681TestLanguage

    // $ANTLR start synpred58_InternalBug304681TestLanguage
    public final void synpred58_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4447:2: ( rule__Attribute2__UnorderedGroup_3_0_1__3 )
        // InternalBug304681TestLanguage.g:4447:2: rule__Attribute2__UnorderedGroup_3_0_1__3
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Attribute2__UnorderedGroup_3_0_1__3();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred58_InternalBug304681TestLanguage

    // $ANTLR start synpred59_InternalBug304681TestLanguage
    public final void synpred59_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4459:2: ( rule__Attribute2__UnorderedGroup_3_0_1__4 )
        // InternalBug304681TestLanguage.g:4459:2: rule__Attribute2__UnorderedGroup_3_0_1__4
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Attribute2__UnorderedGroup_3_0_1__4();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred59_InternalBug304681TestLanguage

    // $ANTLR start synpred60_InternalBug304681TestLanguage
    public final void synpred60_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4483:2: ( rule__Reference2__UnorderedGroup_4_0_1__0 )
        // InternalBug304681TestLanguage.g:4483:2: rule__Reference2__UnorderedGroup_4_0_1__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Reference2__UnorderedGroup_4_0_1__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred60_InternalBug304681TestLanguage

    // $ANTLR start synpred61_InternalBug304681TestLanguage
    public final void synpred61_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4498:3: ( ({...}? => ( ( ( rule__Reference2__Group_4_0_1_0__0 ) ) ) ) )
        // InternalBug304681TestLanguage.g:4498:3: ({...}? => ( ( ( rule__Reference2__Group_4_0_1_0__0 ) ) ) )
        {
        // InternalBug304681TestLanguage.g:4498:3: ({...}? => ( ( ( rule__Reference2__Group_4_0_1_0__0 ) ) ) )
        // InternalBug304681TestLanguage.g:4499:4: {...}? => ( ( ( rule__Reference2__Group_4_0_1_0__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred61_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0)");
        }
        // InternalBug304681TestLanguage.g:4499:110: ( ( ( rule__Reference2__Group_4_0_1_0__0 ) ) )
        // InternalBug304681TestLanguage.g:4500:5: ( ( rule__Reference2__Group_4_0_1_0__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0);
        // InternalBug304681TestLanguage.g:4506:5: ( ( rule__Reference2__Group_4_0_1_0__0 ) )
        // InternalBug304681TestLanguage.g:4507:6: ( rule__Reference2__Group_4_0_1_0__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getReference2Access().getGroup_4_0_1_0()); 
        }
        // InternalBug304681TestLanguage.g:4508:6: ( rule__Reference2__Group_4_0_1_0__0 )
        // InternalBug304681TestLanguage.g:4508:7: rule__Reference2__Group_4_0_1_0__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Reference2__Group_4_0_1_0__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred61_InternalBug304681TestLanguage

    // $ANTLR start synpred62_InternalBug304681TestLanguage
    public final void synpred62_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4542:2: ( rule__Reference2__UnorderedGroup_4_0_1__1 )
        // InternalBug304681TestLanguage.g:4542:2: rule__Reference2__UnorderedGroup_4_0_1__1
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Reference2__UnorderedGroup_4_0_1__1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred62_InternalBug304681TestLanguage

    // $ANTLR start synpred63_InternalBug304681TestLanguage
    public final void synpred63_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4581:3: ( ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_0__0 ) ) ) ) )
        // InternalBug304681TestLanguage.g:4581:3: ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_0__0 ) ) ) )
        {
        // InternalBug304681TestLanguage.g:4581:3: ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_0__0 ) ) ) )
        // InternalBug304681TestLanguage.g:4582:4: {...}? => ( ( ( rule__ConstraintDefinition__Group_3_0__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred63_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 0)");
        }
        // InternalBug304681TestLanguage.g:4582:116: ( ( ( rule__ConstraintDefinition__Group_3_0__0 ) ) )
        // InternalBug304681TestLanguage.g:4583:5: ( ( rule__ConstraintDefinition__Group_3_0__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 0);
        // InternalBug304681TestLanguage.g:4589:5: ( ( rule__ConstraintDefinition__Group_3_0__0 ) )
        // InternalBug304681TestLanguage.g:4590:6: ( rule__ConstraintDefinition__Group_3_0__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getConstraintDefinitionAccess().getGroup_3_0()); 
        }
        // InternalBug304681TestLanguage.g:4591:6: ( rule__ConstraintDefinition__Group_3_0__0 )
        // InternalBug304681TestLanguage.g:4591:7: rule__ConstraintDefinition__Group_3_0__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__ConstraintDefinition__Group_3_0__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred63_InternalBug304681TestLanguage

    // $ANTLR start synpred64_InternalBug304681TestLanguage
    public final void synpred64_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4625:2: ( rule__ConstraintDefinition__UnorderedGroup_3__1 )
        // InternalBug304681TestLanguage.g:4625:2: rule__ConstraintDefinition__UnorderedGroup_3__1
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__ConstraintDefinition__UnorderedGroup_3__1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred64_InternalBug304681TestLanguage

    // Delegated rules

    public final boolean synpred36_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred52_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred52_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred44_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred44_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred39_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred39_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred25_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred41_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred41_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred57_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred57_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred28_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred50_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred50_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred46_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred46_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred61_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred61_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred54_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred54_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred49_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred49_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred43_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred43_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred40_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred40_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred38_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred38_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred48_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred48_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred56_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred56_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred51_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred51_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred64_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred64_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred24_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred59_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred59_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred37_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred37_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred45_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred45_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred53_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred53_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred62_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred62_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred58_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred58_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred42_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred42_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred31_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred47_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred47_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred60_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred60_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred63_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred63_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred55_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred55_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA13 dfa13 = new DFA13(this);
    protected DFA14 dfa14 = new DFA14(this);
    protected DFA21 dfa21 = new DFA21(this);
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA22 dfa22 = new DFA22(this);
    protected DFA24 dfa24 = new DFA24(this);
    protected DFA25 dfa25 = new DFA25(this);
    protected DFA26 dfa26 = new DFA26(this);
    protected DFA27 dfa27 = new DFA27(this);
    protected DFA28 dfa28 = new DFA28(this);
    protected DFA29 dfa29 = new DFA29(this);
    protected DFA30 dfa30 = new DFA30(this);
    protected DFA35 dfa35 = new DFA35(this);
    protected DFA42 dfa42 = new DFA42(this);
    static final String dfa_1s = "\32\uffff";
    static final String dfa_2s = "\1\1\31\uffff";
    static final String dfa_3s = "\1\21\1\uffff\4\4\1\13\1\4\1\13\1\0\1\21\1\0\1\uffff\2\5\1\0\2\13\2\21\2\5\2\13\2\21";
    static final String dfa_4s = "\1\41\1\uffff\3\4\1\42\1\13\1\4\1\20\1\0\1\24\1\0\1\uffff\2\5\1\0\2\13\2\24\2\5\2\13\2\21";
    static final String dfa_5s = "\1\uffff\1\2\12\uffff\1\1\15\uffff";
    static final String dfa_6s = "\11\uffff\1\1\1\uffff\1\2\3\uffff\1\0\12\uffff}>";
    static final String[] dfa_7s = {
            "\1\1\1\uffff\4\1\1\uffff\2\1\1\2\1\3\5\uffff\1\1",
            "",
            "\1\4",
            "\1\5",
            "\1\6",
            "\1\10\35\uffff\1\7",
            "\1\11",
            "\1\10",
            "\1\13\4\uffff\1\12",
            "\1\uffff",
            "\1\17\1\uffff\1\15\1\16",
            "\1\uffff",
            "",
            "\1\20",
            "\1\21",
            "\1\uffff",
            "\1\22",
            "\1\23",
            "\1\17\1\uffff\1\24\1\25",
            "\1\17\1\uffff\1\24\1\25",
            "\1\26",
            "\1\27",
            "\1\30",
            "\1\31",
            "\1\17",
            "\1\17"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 1435:2: ( rule__Object__FeaturesAssignment_5_6_1 )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA13_15 = input.LA(1);

                         
                        int index13_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalBug304681TestLanguage()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index13_15);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA13_9 = input.LA(1);

                         
                        int index13_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalBug304681TestLanguage()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index13_9);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA13_11 = input.LA(1);

                         
                        int index13_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalBug304681TestLanguage()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index13_11);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 13, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_8s = "\11\uffff\1\1\1\uffff\1\0\3\uffff\1\2\12\uffff}>";
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_8;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 1495:3: ( rule__Object__FeaturesAssignment_5_7_1 )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_11 = input.LA(1);

                         
                        int index14_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalBug304681TestLanguage()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index14_11);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA14_9 = input.LA(1);

                         
                        int index14_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalBug304681TestLanguage()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index14_9);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA14_15 = input.LA(1);

                         
                        int index14_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalBug304681TestLanguage()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index14_15);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_9s = "\13\uffff";
    static final String dfa_10s = "\1\21\12\uffff";
    static final String dfa_11s = "\1\41\12\uffff";
    static final String dfa_12s = "\1\uffff\11\1\1\2";
    static final String dfa_13s = "\1\0\12\uffff}>";
    static final String[] dfa_14s = {
            "\1\12\1\uffff\1\1\1\2\1\3\1\7\1\uffff\1\10\1\11\1\5\1\6\5\uffff\1\4",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final char[] dfa_11 = DFA.unpackEncodedStringToUnsignedChars(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = dfa_9;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "3806:2: ( rule__Object__UnorderedGroup_5__0 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA21_0 = input.LA(1);

                         
                        int index21_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA21_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0) ) {s = 1;}

                        else if ( LA21_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1) ) {s = 2;}

                        else if ( LA21_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2) ) {s = 3;}

                        else if ( LA21_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3) ) {s = 4;}

                        else if ( LA21_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 5;}

                        else if ( LA21_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 6;}

                        else if ( LA21_0 == 22 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5) ) {s = 7;}

                        else if ( LA21_0 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6) ) {s = 8;}

                        else if ( LA21_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7) ) {s = 9;}

                        else if ( (LA21_0==17) ) {s = 10;}

                         
                        input.seek(index21_0);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 21, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_15s = "\12\uffff";
    static final String dfa_16s = "\1\23\11\uffff";
    static final String dfa_17s = "\1\41\11\uffff";
    static final String dfa_18s = "\1\uffff\1\1\1\2\1\3\1\4\2\5\1\6\1\7\1\10";
    static final String dfa_19s = "\1\0\11\uffff}>";
    static final String[] dfa_20s = {
            "\1\1\1\2\1\3\1\7\1\uffff\1\10\1\11\1\5\1\6\5\uffff\1\4",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_15 = DFA.unpackEncodedString(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final char[] dfa_17 = DFA.unpackEncodedStringToUnsignedChars(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final short[][] dfa_20 = unpackEncodedStringArray(dfa_20s);

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = dfa_15;
            this.eof = dfa_15;
            this.min = dfa_16;
            this.max = dfa_17;
            this.accept = dfa_18;
            this.special = dfa_19;
            this.transition = dfa_20;
        }
        public String getDescription() {
            return "3820:3: ( ({...}? => ( ( ( rule__Object__Group_5_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_5__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_6__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_7__0 ) ) ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA23_0 = input.LA(1);

                         
                        int index23_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA23_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0) ) {s = 1;}

                        else if ( LA23_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1) ) {s = 2;}

                        else if ( LA23_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2) ) {s = 3;}

                        else if ( LA23_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3) ) {s = 4;}

                        else if ( LA23_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 5;}

                        else if ( LA23_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 6;}

                        else if ( LA23_0 == 22 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5) ) {s = 7;}

                        else if ( LA23_0 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6) ) {s = 8;}

                        else if ( LA23_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7) ) {s = 9;}

                         
                        input.seek(index23_0);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 23, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 3897:7: ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA22_15 = input.LA(1);

                         
                        int index22_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalBug304681TestLanguage()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index22_15);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA22_9 = input.LA(1);

                         
                        int index22_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalBug304681TestLanguage()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index22_9);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA22_11 = input.LA(1);

                         
                        int index22_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalBug304681TestLanguage()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index22_11);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 22, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_21s = "\1\12\12\uffff";
    static final short[] dfa_21 = DFA.unpackEncodedString(dfa_21s);

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = dfa_9;
            this.eof = dfa_21;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "3962:2: ( rule__Object__UnorderedGroup_5__1 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA24_0 = input.LA(1);

                         
                        int index24_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA24_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0) ) {s = 1;}

                        else if ( LA24_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1) ) {s = 2;}

                        else if ( LA24_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2) ) {s = 3;}

                        else if ( LA24_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3) ) {s = 4;}

                        else if ( LA24_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 5;}

                        else if ( LA24_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 6;}

                        else if ( LA24_0 == 22 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5) ) {s = 7;}

                        else if ( LA24_0 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6) ) {s = 8;}

                        else if ( LA24_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7) ) {s = 9;}

                        else if ( (LA24_0==EOF||LA24_0==17) ) {s = 10;}

                         
                        input.seek(index24_0);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 24, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = dfa_9;
            this.eof = dfa_21;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "3974:2: ( rule__Object__UnorderedGroup_5__2 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA25_0 = input.LA(1);

                         
                        int index25_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA25_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0) ) {s = 1;}

                        else if ( LA25_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1) ) {s = 2;}

                        else if ( LA25_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2) ) {s = 3;}

                        else if ( LA25_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3) ) {s = 4;}

                        else if ( LA25_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 5;}

                        else if ( LA25_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 6;}

                        else if ( LA25_0 == 22 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5) ) {s = 7;}

                        else if ( LA25_0 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6) ) {s = 8;}

                        else if ( LA25_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7) ) {s = 9;}

                        else if ( (LA25_0==EOF||LA25_0==17) ) {s = 10;}

                         
                        input.seek(index25_0);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 25, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = dfa_9;
            this.eof = dfa_21;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "3986:2: ( rule__Object__UnorderedGroup_5__3 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA26_0 = input.LA(1);

                         
                        int index26_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA26_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0) ) {s = 1;}

                        else if ( LA26_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1) ) {s = 2;}

                        else if ( LA26_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2) ) {s = 3;}

                        else if ( LA26_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3) ) {s = 4;}

                        else if ( LA26_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 5;}

                        else if ( LA26_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 6;}

                        else if ( LA26_0 == 22 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5) ) {s = 7;}

                        else if ( LA26_0 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6) ) {s = 8;}

                        else if ( LA26_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7) ) {s = 9;}

                        else if ( (LA26_0==EOF||LA26_0==17) ) {s = 10;}

                         
                        input.seek(index26_0);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 26, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = dfa_9;
            this.eof = dfa_21;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "3998:2: ( rule__Object__UnorderedGroup_5__4 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA27_0 = input.LA(1);

                         
                        int index27_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA27_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0) ) {s = 1;}

                        else if ( LA27_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1) ) {s = 2;}

                        else if ( LA27_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2) ) {s = 3;}

                        else if ( LA27_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3) ) {s = 4;}

                        else if ( LA27_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 5;}

                        else if ( LA27_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 6;}

                        else if ( LA27_0 == 22 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5) ) {s = 7;}

                        else if ( LA27_0 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6) ) {s = 8;}

                        else if ( LA27_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7) ) {s = 9;}

                        else if ( (LA27_0==EOF||LA27_0==17) ) {s = 10;}

                         
                        input.seek(index27_0);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 27, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = dfa_9;
            this.eof = dfa_21;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "4010:2: ( rule__Object__UnorderedGroup_5__5 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA28_0 = input.LA(1);

                         
                        int index28_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA28_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0) ) {s = 1;}

                        else if ( LA28_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1) ) {s = 2;}

                        else if ( LA28_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2) ) {s = 3;}

                        else if ( LA28_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3) ) {s = 4;}

                        else if ( LA28_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 5;}

                        else if ( LA28_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 6;}

                        else if ( LA28_0 == 22 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5) ) {s = 7;}

                        else if ( LA28_0 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6) ) {s = 8;}

                        else if ( LA28_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7) ) {s = 9;}

                        else if ( (LA28_0==EOF||LA28_0==17) ) {s = 10;}

                         
                        input.seek(index28_0);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 28, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = dfa_9;
            this.eof = dfa_21;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "4022:2: ( rule__Object__UnorderedGroup_5__6 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA29_0 = input.LA(1);

                         
                        int index29_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA29_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0) ) {s = 1;}

                        else if ( LA29_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1) ) {s = 2;}

                        else if ( LA29_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2) ) {s = 3;}

                        else if ( LA29_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3) ) {s = 4;}

                        else if ( LA29_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 5;}

                        else if ( LA29_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 6;}

                        else if ( LA29_0 == 22 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5) ) {s = 7;}

                        else if ( LA29_0 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6) ) {s = 8;}

                        else if ( LA29_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7) ) {s = 9;}

                        else if ( (LA29_0==EOF||LA29_0==17) ) {s = 10;}

                         
                        input.seek(index29_0);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 29, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = dfa_9;
            this.eof = dfa_21;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "4034:2: ( rule__Object__UnorderedGroup_5__7 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA30_0 = input.LA(1);

                         
                        int index30_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA30_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0) ) {s = 1;}

                        else if ( LA30_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1) ) {s = 2;}

                        else if ( LA30_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2) ) {s = 3;}

                        else if ( LA30_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3) ) {s = 4;}

                        else if ( LA30_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 5;}

                        else if ( LA30_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 6;}

                        else if ( LA30_0 == 22 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5) ) {s = 7;}

                        else if ( LA30_0 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6) ) {s = 8;}

                        else if ( LA30_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7) ) {s = 9;}

                        else if ( (LA30_0==EOF||LA30_0==17) ) {s = 10;}

                         
                        input.seek(index30_0);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 30, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_22s = "\u01fa\uffff";
    static final String dfa_23s = "\1\1\u01f9\uffff";
    static final String dfa_24s = "\1\21\1\uffff\4\4\1\13\1\4\1\13\1\21\1\0\1\21\1\0\2\5\1\4\2\13\1\0\1\uffff\2\5\1\0\2\13\1\20\2\21\2\13\2\21\1\35\2\5\1\4\2\13\2\21\2\5\2\13\1\20\2\21\3\5\1\21\1\13\2\21\1\35\2\5\1\4\4\13\2\5\2\21\2\5\2\13\1\20\4\21\1\5\1\21\1\13\1\4\1\5\1\21\1\13\2\21\1\35\2\5\1\4\2\13\1\21\1\20\2\5\2\21\2\5\2\13\1\20\2\21\1\35\1\5\1\21\1\13\1\4\1\5\1\21\1\13\2\21\1\35\2\5\1\4\2\13\2\5\1\21\1\20\2\5\2\21\2\5\2\13\1\20\2\21\1\5\1\21\1\13\1\35\1\5\1\21\1\13\1\4\1\5\1\21\1\13\2\21\1\35\2\5\2\21\2\5\1\21\1\20\2\5\2\21\3\5\1\21\1\13\1\4\2\5\2\13\1\5\1\21\1\13\1\35\1\5\1\21\1\13\1\4\1\5\1\21\1\13\1\21\1\20\2\13\2\21\2\5\2\21\2\5\1\21\1\20\2\5\2\21\1\35\2\21\2\5\1\4\2\13\1\5\1\21\1\13\1\4\1\5\1\21\1\13\1\35\1\5\1\21\1\13\1\4\2\5\2\13\1\20\3\21\1\20\2\5\2\21\2\5\1\21\1\20\1\5\1\21\1\13\2\21\1\35\2\5\1\4\2\13\1\35\1\5\1\21\1\13\1\4\1\5\1\21\1\13\1\35\2\5\2\21\2\5\2\13\1\20\2\21\2\5\1\21\1\20\2\5\2\21\3\5\1\21\1\13\1\4\2\5\2\13\1\5\1\21\1\13\2\21\1\35\1\5\1\21\1\13\1\35\1\5\1\21\1\13\1\4\1\5\1\21\1\13\1\21\1\20\2\13\2\21\2\5\2\21\4\5\2\21\2\5\1\21\1\20\2\5\2\21\1\35\2\21\2\5\1\4\2\13\1\5\1\21\1\13\1\5\1\21\1\13\1\5\1\21\1\13\1\4\1\5\1\21\1\13\1\35\1\5\1\21\1\13\2\5\2\13\1\20\3\21\2\5\3\21\1\20\2\5\2\21\2\5\1\21\1\5\1\21\1\13\2\21\1\35\1\5\1\21\1\13\1\35\1\5\1\21\1\13\1\4\1\5\1\21\1\13\2\5\2\21\2\5\1\21\2\5\1\21\1\20\2\5\2\21\1\5\1\21\1\13\2\5\1\4\2\13\1\5\1\21\1\13\1\5\1\21\1\13\1\35\1\5\1\21\1\13\1\21\2\13\1\20\2\21\2\5\2\21\2\5\2\21\2\5\3\21\1\35\1\5\1\21\1\13\1\5\1\21\1\13\1\4\1\5\1\21\1\13\2\5\2\21\1\20\2\5\2\21\1\5\1\21\1\13\1\35\1\5\1\21\1\13\2\5\2\21\2\5\1\21\1\5\1\21\1\13\1\4\1\5\1\21\1\13\1\21\1\20\2\5\2\21\1\35\1\5\1\21\1\13\2\5\1\21\1\5\1\21\1\13\2\5\2\21\1\5\1\21\1\13\1\21";
    static final String dfa_25s = "\1\41\1\uffff\3\4\1\42\1\20\1\4\1\20\1\44\1\0\1\24\1\0\2\5\1\4\2\13\1\0\1\uffff\2\5\1\0\2\13\1\20\2\44\2\13\2\44\1\36\2\5\1\4\2\13\2\24\1\13\1\5\2\13\1\20\2\44\2\5\1\13\1\36\1\13\2\44\1\36\2\5\1\4\5\13\1\5\1\44\1\36\1\13\1\5\2\13\1\20\2\44\2\21\1\13\1\21\1\13\1\4\1\13\1\36\1\13\2\44\1\36\2\5\1\4\2\13\1\21\1\20\1\13\1\5\1\44\1\36\1\13\1\5\2\13\1\20\2\44\1\36\1\13\1\21\1\13\1\4\1\13\1\36\1\13\2\44\1\36\2\5\1\4\3\13\1\5\1\21\1\20\1\13\1\5\1\44\1\36\1\13\1\5\2\13\1\20\2\21\1\13\1\36\1\13\1\36\1\13\1\21\1\13\1\4\1\13\1\36\1\13\2\21\1\36\1\13\1\5\1\44\1\36\1\13\1\5\1\21\1\20\1\13\1\5\1\44\1\36\1\13\1\5\1\13\1\21\1\13\1\4\2\5\3\13\1\36\1\13\1\36\1\13\1\21\1\13\1\4\1\13\1\36\1\13\1\21\1\20\2\13\2\44\1\13\1\5\1\44\1\36\1\13\1\5\1\21\1\20\1\13\1\5\1\34\2\36\2\44\2\5\1\4\3\13\1\21\1\13\1\4\1\13\1\36\1\13\1\36\1\13\1\21\1\13\1\4\1\13\1\5\2\13\1\20\2\44\1\21\1\20\1\13\1\5\1\44\1\36\1\13\1\5\1\21\1\20\1\13\1\36\1\13\2\44\1\36\2\5\1\4\2\13\1\36\1\13\1\21\1\13\1\4\1\13\1\36\1\13\1\36\1\13\1\5\1\44\1\36\1\13\1\5\2\13\1\20\2\44\1\13\1\5\1\21\1\20\1\13\1\5\1\44\1\36\1\13\1\5\1\13\1\21\1\13\1\4\2\5\3\13\1\36\1\13\2\44\1\36\1\13\1\36\1\13\1\36\1\13\1\21\1\13\1\4\1\13\1\36\1\13\1\21\1\20\2\13\2\44\1\13\1\5\1\44\1\36\1\13\1\5\1\13\1\5\1\44\1\36\1\13\1\5\1\21\1\20\1\13\1\5\1\34\2\36\2\44\2\5\1\4\3\13\1\21\2\13\1\36\2\13\1\21\1\13\1\4\1\13\1\36\1\13\1\36\1\13\1\21\2\13\1\5\2\13\1\20\2\44\1\21\1\13\1\5\1\44\1\36\1\21\1\20\1\13\1\5\1\44\1\36\1\13\1\5\1\21\1\13\1\36\1\13\2\44\1\36\1\13\1\21\1\13\1\36\1\13\1\21\1\13\1\4\1\13\1\36\2\13\1\5\1\44\1\36\1\13\1\5\1\21\1\13\1\5\1\21\1\20\1\13\1\5\1\44\1\36\1\13\1\21\1\13\2\5\1\4\3\13\1\36\2\13\1\36\1\13\1\36\1\13\1\21\1\13\1\21\2\13\1\20\2\44\1\13\1\5\1\44\1\36\1\13\1\5\1\44\1\36\1\13\1\5\1\21\2\44\1\36\1\13\1\21\2\13\1\21\1\13\1\4\1\13\1\36\2\13\1\5\2\21\1\20\1\13\1\5\1\44\1\36\1\13\1\36\1\13\1\36\1\13\1\21\2\13\1\5\1\44\1\36\1\13\1\5\1\21\1\13\1\21\1\13\1\4\1\13\1\36\1\13\1\21\1\20\1\13\1\5\1\44\2\36\1\13\1\21\2\13\1\5\1\21\1\13\1\36\2\13\1\5\1\44\1\36\1\13\1\21\1\13\1\21";
    static final String dfa_26s = "\1\uffff\1\2\21\uffff\1\1\u01e6\uffff";
    static final String dfa_27s = "\12\uffff\1\3\1\uffff\1\1\5\uffff\1\2\3\uffff\1\0\u01e3\uffff}>";
    static final String[] dfa_28s = {
            "\1\1\1\uffff\3\1\4\uffff\1\2\1\3\5\uffff\1\1",
            "",
            "\1\4",
            "\1\5",
            "\1\6",
            "\1\10\35\uffff\1\7",
            "\1\12\4\uffff\1\11",
            "\1\10",
            "\1\14\4\uffff\1\13",
            "\1\22\1\uffff\1\15\1\16\7\uffff\1\17\6\uffff\1\20\1\21",
            "\1\uffff",
            "\1\26\1\uffff\1\24\1\25",
            "\1\uffff",
            "\1\27",
            "\1\30",
            "\1\31",
            "\1\32",
            "\1\33",
            "\1\uffff",
            "",
            "\1\34",
            "\1\35",
            "\1\uffff",
            "\1\36",
            "\1\37",
            "\1\40",
            "\1\22\1\uffff\1\41\1\42\7\uffff\1\43\6\uffff\1\44\1\45",
            "\1\22\1\uffff\1\41\1\42\7\uffff\1\43\6\uffff\1\44\1\45",
            "\1\46",
            "\1\47",
            "\1\22\1\uffff\1\41\1\42\7\uffff\1\43\6\uffff\1\44\1\45",
            "\1\22\1\uffff\1\41\1\42\7\uffff\1\43\6\uffff\1\44\1\45",
            "\1\50\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55",
            "\1\56",
            "\1\26\1\uffff\1\57\1\60",
            "\1\26\1\uffff\1\57\1\60",
            "\1\61\5\uffff\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\22\1\uffff\1\67\1\70\7\uffff\1\71\6\uffff\1\72\1\73",
            "\1\22\1\uffff\1\67\1\70\7\uffff\1\71\6\uffff\1\72\1\73",
            "\1\74",
            "\1\75",
            "\1\61\5\uffff\1\62",
            "\1\100\13\uffff\1\76\1\77",
            "\1\101",
            "\1\22\1\uffff\1\67\1\70\7\uffff\1\71\6\uffff\1\72\1\73",
            "\1\22\1\uffff\1\67\1\70\7\uffff\1\71\6\uffff\1\72\1\73",
            "\1\102\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113\5\uffff\1\114",
            "\1\115",
            "\1\22\1\uffff\1\41\1\42\7\uffff\1\116\6\uffff\1\44\1\45",
            "\1\100\13\uffff\1\76\1\77",
            "\1\117\5\uffff\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\22\1\uffff\1\125\1\126\7\uffff\1\127\6\uffff\1\130\1\131",
            "\1\22\1\uffff\1\125\1\126\7\uffff\1\127\6\uffff\1\130\1\131",
            "\1\26",
            "\1\26",
            "\1\113\5\uffff\1\114",
            "\1\100",
            "\1\132",
            "\1\133",
            "\1\117\5\uffff\1\120",
            "\1\136\13\uffff\1\134\1\135",
            "\1\137",
            "\1\22\1\uffff\1\125\1\126\7\uffff\1\127\6\uffff\1\130\1\131",
            "\1\22\1\uffff\1\125\1\126\7\uffff\1\127\6\uffff\1\130\1\131",
            "\1\140\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\100",
            "\1\147",
            "\1\150\5\uffff\1\151",
            "\1\152",
            "\1\22\1\uffff\1\67\1\70\7\uffff\1\153\6\uffff\1\72\1\73",
            "\1\136\13\uffff\1\134\1\135",
            "\1\154\5\uffff\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\22\1\uffff\1\162\1\163\7\uffff\1\164\6\uffff\1\165\1\166",
            "\1\22\1\uffff\1\162\1\163\7\uffff\1\164\6\uffff\1\165\1\166",
            "\1\167\1\170",
            "\1\150\5\uffff\1\151",
            "\1\136",
            "\1\171",
            "\1\172",
            "\1\154\5\uffff\1\155",
            "\1\175\13\uffff\1\173\1\174",
            "\1\176",
            "\1\22\1\uffff\1\162\1\163\7\uffff\1\164\6\uffff\1\165\1\166",
            "\1\22\1\uffff\1\162\1\163\7\uffff\1\164\6\uffff\1\165\1\166",
            "\1\177\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086\5\uffff\1\u0087",
            "\1\u0088",
            "\1\136",
            "\1\u0089",
            "\1\u008a\5\uffff\1\u008b",
            "\1\u008c",
            "\1\22\1\uffff\1\125\1\126\7\uffff\1\u008d\6\uffff\1\130\1\131",
            "\1\175\13\uffff\1\173\1\174",
            "\1\u008e\5\uffff\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\22",
            "\1\22",
            "\1\u0086\5\uffff\1\u0087",
            "\1\u0096\13\uffff\1\u0094\1\u0095",
            "\1\u0097",
            "\1\u0098\1\u0099",
            "\1\u008a\5\uffff\1\u008b",
            "\1\175",
            "\1\u009a",
            "\1\u009b",
            "\1\u008e\5\uffff\1\u008f",
            "\1\u009e\13\uffff\1\u009c\1\u009d",
            "\1\u009f",
            "\1\22",
            "\1\22",
            "\1\u00a0\1\u00a1",
            "\1\u00a2\5\uffff\1\u00a3",
            "\1\u00a4",
            "\1\22\1\uffff\1\u00a6\1\u00a7\7\uffff\1\u00a5\6\uffff\1\u00a8\1\u00a9",
            "\1\u0096\13\uffff\1\u0094\1\u0095",
            "\1\u00aa\5\uffff\1\u00ab",
            "\1\u00ac",
            "\1\175",
            "\1\u00ad",
            "\1\u00ae\5\uffff\1\u00af",
            "\1\u00b0",
            "\1\22\1\uffff\1\162\1\163\7\uffff\1\u00b1\6\uffff\1\165\1\166",
            "\1\u009e\13\uffff\1\u009c\1\u009d",
            "\1\u00b2\5\uffff\1\u00b3",
            "\1\u00b4",
            "\1\u00a2\5\uffff\1\u00a3",
            "\1\u0096",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00aa\5\uffff\1\u00ab",
            "\1\u00bd\13\uffff\1\u00bb\1\u00bc",
            "\1\u00be",
            "\1\u00bf\1\u00c0",
            "\1\u00ae\5\uffff\1\u00af",
            "\1\u009e",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00b2\5\uffff\1\u00b3",
            "\1\u00c5\13\uffff\1\u00c3\1\u00c4",
            "\1\u00c6",
            "\1\u0096",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "\1\22\1\uffff\1\u00ca\1\u00cb\7\uffff\1\u00cc\6\uffff\1\u00cd\1\u00ce",
            "\1\22\1\uffff\1\u00ca\1\u00cb\7\uffff\1\u00cc\6\uffff\1\u00cd\1\u00ce",
            "\1\u00cf\5\uffff\1\u00d0",
            "\1\u00d1",
            "\1\22\1\uffff\1\u00ca\1\u00cb\7\uffff\1\u00d2\6\uffff\1\u00cd\1\u00ce",
            "\1\u00bd\13\uffff\1\u00bb\1\u00bc",
            "\1\u00d3\5\uffff\1\u00d4",
            "\1\u00d5",
            "\1\u009e",
            "\1\u00d6",
            "\1\u00d7\5\uffff\1\u00d8",
            "\1\u00d9",
            "\1\22\12\uffff\1\u00da",
            "\1\u00c5\13\uffff\1\u00c3\1\u00c4",
            "\1\u00db\1\u00dc",
            "\1\22\1\uffff\1\u00ca\1\u00cb\7\uffff\1\u00cc\6\uffff\1\u00cd\1\u00ce",
            "\1\22\1\uffff\1\u00ca\1\u00cb\7\uffff\1\u00cc\6\uffff\1\u00cd\1\u00ce",
            "\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "\1\u00e0",
            "\1\u00e1",
            "\1\u00cf\5\uffff\1\u00d0",
            "\1\u00bd",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00d3\5\uffff\1\u00d4",
            "\1\u00e6\13\uffff\1\u00e4\1\u00e5",
            "\1\u00e7",
            "\1\u00e8\1\u00e9",
            "\1\u00d7\5\uffff\1\u00d8",
            "\1\u00c5",
            "\1\u00ea",
            "\1\u00eb",
            "\1\u00ec\5\uffff\1\u00ed",
            "\1\u00ee",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00f1",
            "\1\22\1\uffff\1\u00f2\1\u00f3\7\uffff\1\u00f4\6\uffff\1\u00f5\1\u00f6",
            "\1\22\1\uffff\1\u00f2\1\u00f3\7\uffff\1\u00f4\6\uffff\1\u00f5\1\u00f6",
            "\1\u00bd",
            "\1\u00f7",
            "\1\u00f8\5\uffff\1\u00f9",
            "\1\u00fa",
            "\1\22\1\uffff\1\u00f2\1\u00f3\7\uffff\1\u00fb\6\uffff\1\u00f5\1\u00f6",
            "\1\u00e6\13\uffff\1\u00e4\1\u00e5",
            "\1\u00fc\5\uffff\1\u00fd",
            "\1\u00fe",
            "\1\u00c5",
            "\1\u00ff",
            "\1\u00ec\5\uffff\1\u00ed",
            "\1\u0102\13\uffff\1\u0100\1\u0101",
            "\1\u0103",
            "\1\22\1\uffff\1\u00f2\1\u00f3\7\uffff\1\u00f4\6\uffff\1\u00f5\1\u00f6",
            "\1\22\1\uffff\1\u00f2\1\u00f3\7\uffff\1\u00f4\6\uffff\1\u00f5\1\u00f6",
            "\1\u0104\1\u0105",
            "\1\u0106",
            "\1\u0107",
            "\1\u0108",
            "\1\u0109",
            "\1\u010a",
            "\1\u010b\1\u010c",
            "\1\u00f8\5\uffff\1\u00f9",
            "\1\u00e6",
            "\1\u010d",
            "\1\u010e",
            "\1\u00fc\5\uffff\1\u00fd",
            "\1\u0111\13\uffff\1\u010f\1\u0110",
            "\1\u0112",
            "\1\u0113\1\u0114",
            "\1\u0115\5\uffff\1\u0116",
            "\1\u0117",
            "\1\22\1\uffff\1\u0119\1\u011a\7\uffff\1\u0118\6\uffff\1\u011b\1\u011c",
            "\1\u0102\13\uffff\1\u0100\1\u0101",
            "\1\u011d\5\uffff\1\u011e",
            "\1\u011f",
            "\1\u0120",
            "\1\u0121",
            "\1\u0122",
            "\1\22\1\uffff\1\162\1\163\7\uffff\1\164\6\uffff\1\165\1\166",
            "\1\22\1\uffff\1\162\1\163\7\uffff\1\164\6\uffff\1\165\1\166",
            "\1\u0123\5\uffff\1\u0124",
            "\1\u0125",
            "\1\u00e6",
            "\1\u0126",
            "\1\u0127\5\uffff\1\u0128",
            "\1\u0129",
            "\1\22\1\uffff\1\162\1\163\7\uffff\1\u012a\6\uffff\1\165\1\166",
            "\1\u0111\13\uffff\1\u010f\1\u0110",
            "\1\u012b\5\uffff\1\u012c",
            "\1\u012d",
            "\1\u0115\5\uffff\1\u0116",
            "\1\u0102",
            "\1\u012e",
            "\1\u012f",
            "\1\u0130",
            "\1\u0131",
            "\1\u0132",
            "\1\u0133",
            "\1\u011d\5\uffff\1\u011e",
            "\1\u0136\13\uffff\1\u0134\1\u0135",
            "\1\u0137",
            "\1\22\1\uffff\1\162\1\163\7\uffff\1\164\6\uffff\1\165\1\166",
            "\1\22\1\uffff\1\162\1\163\7\uffff\1\164\6\uffff\1\165\1\166",
            "\1\u0138\1\u0139",
            "\1\u0123\5\uffff\1\u0124",
            "\1\u013c\13\uffff\1\u013a\1\u013b",
            "\1\u013d",
            "\1\u013e\1\u013f",
            "\1\u0127\5\uffff\1\u0128",
            "\1\u0111",
            "\1\u0140",
            "\1\u0141",
            "\1\u012b\5\uffff\1\u012c",
            "\1\u0144\13\uffff\1\u0142\1\u0143",
            "\1\u0145",
            "\1\u0102",
            "\1\u0146",
            "\1\u0147",
            "\1\u0148",
            "\1\22\1\uffff\1\u0149\1\u014a\7\uffff\1\u014b\6\uffff\1\u014c\1\u014d",
            "\1\22\1\uffff\1\u0149\1\u014a\7\uffff\1\u014b\6\uffff\1\u014c\1\u014d",
            "\1\u014e\5\uffff\1\u014f",
            "\1\u0150",
            "\1\22\1\uffff\1\u00f2\1\u00f3\7\uffff\1\u00fb\6\uffff\1\u00f5\1\u00f6",
            "\1\u0136\13\uffff\1\u0134\1\u0135",
            "\1\u0151\5\uffff\1\u0152",
            "\1\u0153",
            "\1\u0154\5\uffff\1\u0155",
            "\1\u0156",
            "\1\22\1\uffff\1\u0149\1\u014a\7\uffff\1\u0157\6\uffff\1\u014c\1\u014d",
            "\1\u013c\13\uffff\1\u013a\1\u013b",
            "\1\u0158\5\uffff\1\u0159",
            "\1\u015a",
            "\1\u0111",
            "\1\u015b",
            "\1\u015c\5\uffff\1\u015d",
            "\1\u015e",
            "\1\22\12\uffff\1\u00da",
            "\1\u0144\13\uffff\1\u0142\1\u0143",
            "\1\u015f\1\u0160",
            "\1\22\1\uffff\1\u0149\1\u014a\7\uffff\1\u014b\6\uffff\1\u014c\1\u014d",
            "\1\22\1\uffff\1\u0149\1\u014a\7\uffff\1\u014b\6\uffff\1\u014c\1\u014d",
            "\1\u0161",
            "\1\u0162",
            "\1\u0163",
            "\1\u0164",
            "\1\u0165",
            "\1\u014e\5\uffff\1\u014f",
            "\1\u0136",
            "\1\u0166",
            "\1\u0151\5\uffff\1\u0152",
            "\1\u0169\13\uffff\1\u0167\1\u0168",
            "\1\u016a",
            "\1\u0154\5\uffff\1\u0155",
            "\1\u013c",
            "\1\u016b",
            "\1\u016c",
            "\1\u0158\5\uffff\1\u0159",
            "\1\u016f\13\uffff\1\u016d\1\u016e",
            "\1\u0170",
            "\1\u0171\1\u0172",
            "\1\u015c\5\uffff\1\u015d",
            "\1\u0144",
            "\1\u0173",
            "\1\u0174\5\uffff\1\u0175",
            "\1\u0176",
            "\1\u0177",
            "\1\u0178",
            "\1\u0179",
            "\1\22\1\uffff\1\u00f2\1\u00f3\7\uffff\1\u00f4\6\uffff\1\u00f5\1\u00f6",
            "\1\22\1\uffff\1\u00f2\1\u00f3\7\uffff\1\u00f4\6\uffff\1\u00f5\1\u00f6",
            "\1\u0136",
            "\1\u017a\5\uffff\1\u017b",
            "\1\u017c",
            "\1\22\1\uffff\1\162\1\163\7\uffff\1\u012a\6\uffff\1\165\1\166",
            "\1\u0169\13\uffff\1\u0167\1\u0168",
            "\1\u013c",
            "\1\u017d",
            "\1\u017e\5\uffff\1\u017f",
            "\1\u0180",
            "\1\22\1\uffff\1\u00f2\1\u00f3\7\uffff\1\u0181\6\uffff\1\u00f5\1\u00f6",
            "\1\u016f\13\uffff\1\u016d\1\u016e",
            "\1\u0182\5\uffff\1\u0183",
            "\1\u0184",
            "\1\u0144",
            "\1\u0174\5\uffff\1\u0175",
            "\1\u0187\13\uffff\1\u0185\1\u0186",
            "\1\u0188",
            "\1\22\1\uffff\1\u00f2\1\u00f3\7\uffff\1\u00f4\6\uffff\1\u00f5\1\u00f6",
            "\1\22\1\uffff\1\u00f2\1\u00f3\7\uffff\1\u00f4\6\uffff\1\u00f5\1\u00f6",
            "\1\u0189\1\u018a",
            "\1\u017a\5\uffff\1\u017b",
            "\1\u0169",
            "\1\u018b",
            "\1\u018c\1\u018d",
            "\1\u017e\5\uffff\1\u017f",
            "\1\u016f",
            "\1\u018e",
            "\1\u018f",
            "\1\u0182\5\uffff\1\u0183",
            "\1\u0192\13\uffff\1\u0190\1\u0191",
            "\1\u0193",
            "\1\u0194\5\uffff\1\u0195",
            "\1\u0196",
            "\1\22\1\uffff\1\u0197\1\u0198\7\uffff\1\u0199\6\uffff\1\u019a\1\u019b",
            "\1\u0187\13\uffff\1\u0185\1\u0186",
            "\1\u019c\5\uffff\1\u019d",
            "\1\u019e",
            "\1\u0169",
            "\1\u019f\5\uffff\1\u01a0",
            "\1\u01a1",
            "\1\u016f",
            "\1\u01a2",
            "\1\u01a3\5\uffff\1\u01a4",
            "\1\u01a5",
            "\1\22\1\uffff\1\162\1\163\7\uffff\1\u012a\6\uffff\1\165\1\166",
            "\1\u0192\13\uffff\1\u0190\1\u0191",
            "\1\u0194\5\uffff\1\u0195",
            "\1\u0187",
            "\1\u01a6",
            "\1\u01a7",
            "\1\u01a8",
            "\1\u01a9",
            "\1\u01aa",
            "\1\u01ab",
            "\1\u019c\5\uffff\1\u019d",
            "\1\u01ae\13\uffff\1\u01ac\1\u01ad",
            "\1\u01af",
            "\1\u019f\5\uffff\1\u01a0",
            "\1\u01b2\13\uffff\1\u01b0\1\u01b1",
            "\1\u01b3",
            "\1\u01b4\1\u01b5",
            "\1\u01a3\5\uffff\1\u01a4",
            "\1\u0192",
            "\1\u01b6",
            "\1\u0187",
            "\1\u01b7",
            "\1\u01b8",
            "\1\u01b9",
            "\1\22\1\uffff\1\u0149\1\u014a\7\uffff\1\u014b\6\uffff\1\u014c\1\u014d",
            "\1\22\1\uffff\1\u0149\1\u014a\7\uffff\1\u014b\6\uffff\1\u014c\1\u014d",
            "\1\u01ba\5\uffff\1\u01bb",
            "\1\u01bc",
            "\1\22\1\uffff\1\u00f2\1\u00f3\7\uffff\1\u0181\6\uffff\1\u00f5\1\u00f6",
            "\1\u01ae\13\uffff\1\u01ac\1\u01ad",
            "\1\u01bd\5\uffff\1\u01be",
            "\1\u01bf",
            "\1\22\1\uffff\1\u0149\1\u014a\7\uffff\1\u01c0\6\uffff\1\u014c\1\u014d",
            "\1\u01b2\13\uffff\1\u01b0\1\u01b1",
            "\1\u01c1\5\uffff\1\u01c2",
            "\1\u01c3",
            "\1\u0192",
            "\1\22\1\uffff\1\u0149\1\u014a\7\uffff\1\u014b\6\uffff\1\u014c\1\u014d",
            "\1\22\1\uffff\1\u0149\1\u014a\7\uffff\1\u014b\6\uffff\1\u014c\1\u014d",
            "\1\u01c4\1\u01c5",
            "\1\u01ba\5\uffff\1\u01bb",
            "\1\u01ae",
            "\1\u01c6",
            "\1\u01bd\5\uffff\1\u01be",
            "\1\u01b2",
            "\1\u01c7",
            "\1\u01c8",
            "\1\u01c1\5\uffff\1\u01c2",
            "\1\u01cb\13\uffff\1\u01c9\1\u01ca",
            "\1\u01cc",
            "\1\u01cd\5\uffff\1\u01ce",
            "\1\u01cf",
            "\1\u01ae",
            "\1\u01b2",
            "\1\u01d0",
            "\1\u01d1\5\uffff\1\u01d2",
            "\1\u01d3",
            "\1\22\1\uffff\1\u00f2\1\u00f3\7\uffff\1\u0181\6\uffff\1\u00f5\1\u00f6",
            "\1\u01cb\13\uffff\1\u01c9\1\u01ca",
            "\1\u01cd\5\uffff\1\u01ce",
            "\1\u01d6\13\uffff\1\u01d4\1\u01d5",
            "\1\u01d7",
            "\1\u01d8\1\u01d9",
            "\1\u01d1\5\uffff\1\u01d2",
            "\1\u01cb",
            "\1\u01da",
            "\1\u01db\5\uffff\1\u01dc",
            "\1\u01dd",
            "\1\22\1\uffff\1\u0197\1\u0198\7\uffff\1\u01de\6\uffff\1\u019a\1\u019b",
            "\1\u01d6\13\uffff\1\u01d4\1\u01d5",
            "\1\u01df\5\uffff\1\u01e0",
            "\1\u01e1",
            "\1\u01cb",
            "\1\u01db\5\uffff\1\u01dc",
            "\1\u01d6",
            "\1\u01e2",
            "\1\u01e3",
            "\1\u01df\5\uffff\1\u01e0",
            "\1\u01e6\13\uffff\1\u01e4\1\u01e5",
            "\1\u01e7",
            "\1\u01d6",
            "\1\u01e8",
            "\1\u01e9\5\uffff\1\u01ea",
            "\1\u01eb",
            "\1\22\1\uffff\1\u0149\1\u014a\7\uffff\1\u01c0\6\uffff\1\u014c\1\u014d",
            "\1\u01e6\13\uffff\1\u01e4\1\u01e5",
            "\1\u01ec\1\u01ed",
            "\1\u01e9\5\uffff\1\u01ea",
            "\1\u01e6",
            "\1\u01ee",
            "\1\u01ef\5\uffff\1\u01f0",
            "\1\u01f1",
            "\1\u01e6",
            "\1\u01ef\5\uffff\1\u01f0",
            "\1\u01f4\13\uffff\1\u01f2\1\u01f3",
            "\1\u01f5",
            "\1\u01f6\5\uffff\1\u01f7",
            "\1\u01f8",
            "\1\22\1\uffff\1\u0197\1\u0198\7\uffff\1\u01de\6\uffff\1\u019a\1\u019b",
            "\1\u01f4\13\uffff\1\u01f2\1\u01f3",
            "\1\u01f6\5\uffff\1\u01f7",
            "\1\u01f4",
            "\1\u01f9",
            "\1\u01f4"
    };

    static final short[] dfa_22 = DFA.unpackEncodedString(dfa_22s);
    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final char[] dfa_24 = DFA.unpackEncodedStringToUnsignedChars(dfa_24s);
    static final char[] dfa_25 = DFA.unpackEncodedStringToUnsignedChars(dfa_25s);
    static final short[] dfa_26 = DFA.unpackEncodedString(dfa_26s);
    static final short[] dfa_27 = DFA.unpackEncodedString(dfa_27s);
    static final short[][] dfa_28 = unpackEncodedStringArray(dfa_28s);

    class DFA35 extends DFA {

        public DFA35(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 35;
            this.eot = dfa_22;
            this.eof = dfa_23;
            this.min = dfa_24;
            this.max = dfa_25;
            this.accept = dfa_26;
            this.special = dfa_27;
            this.transition = dfa_28;
        }
        public String getDescription() {
            return "()* loopback of 4232:7: ( ( rule__Object2__FeaturesAssignment_5_4 )=> rule__Object2__FeaturesAssignment_5_4 )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA35_22 = input.LA(1);

                         
                        int index35_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalBug304681TestLanguage()) ) {s = 19;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index35_22);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA35_12 = input.LA(1);

                         
                        int index35_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalBug304681TestLanguage()) ) {s = 19;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index35_12);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA35_18 = input.LA(1);

                         
                        int index35_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalBug304681TestLanguage()) ) {s = 19;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index35_18);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA35_10 = input.LA(1);

                         
                        int index35_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalBug304681TestLanguage()) ) {s = 19;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index35_10);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 35, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_29s = "\23\uffff";
    static final String dfa_30s = "\1\1\22\uffff";
    static final String dfa_31s = "\1\21\1\uffff\1\4\1\20\1\35\3\5\1\21\1\13\2\5\1\0\1\21\1\5\1\21\1\13\1\uffff\1\21";
    static final String dfa_32s = "\1\44\1\uffff\1\4\1\20\1\36\1\13\1\5\1\13\1\36\2\13\1\5\1\0\1\36\1\13\1\21\1\13\1\uffff\1\21";
    static final String dfa_33s = "\1\uffff\1\2\17\uffff\1\1\1\uffff";
    static final String dfa_34s = "\14\uffff\1\0\6\uffff}>";
    static final String[] dfa_35s = {
            "\1\1\1\uffff\2\1\7\uffff\1\2\6\uffff\2\1",
            "",
            "\1\3",
            "\1\4",
            "\1\5\1\6",
            "\1\7\5\uffff\1\10",
            "\1\11",
            "\1\7\5\uffff\1\10",
            "\1\14\13\uffff\1\12\1\13",
            "\1\15",
            "\1\16\5\uffff\1\17",
            "\1\20",
            "\1\uffff",
            "\1\14\13\uffff\1\12\1\13",
            "\1\16\5\uffff\1\17",
            "\1\14",
            "\1\22",
            "",
            "\1\14"
    };

    static final short[] dfa_29 = DFA.unpackEncodedString(dfa_29s);
    static final short[] dfa_30 = DFA.unpackEncodedString(dfa_30s);
    static final char[] dfa_31 = DFA.unpackEncodedStringToUnsignedChars(dfa_31s);
    static final char[] dfa_32 = DFA.unpackEncodedStringToUnsignedChars(dfa_32s);
    static final short[] dfa_33 = DFA.unpackEncodedString(dfa_33s);
    static final short[] dfa_34 = DFA.unpackEncodedString(dfa_34s);
    static final short[][] dfa_35 = unpackEncodedStringArray(dfa_35s);

    class DFA42 extends DFA {

        public DFA42(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 42;
            this.eot = dfa_29;
            this.eof = dfa_30;
            this.min = dfa_31;
            this.max = dfa_32;
            this.accept = dfa_33;
            this.special = dfa_34;
            this.transition = dfa_35;
        }
        public String getDescription() {
            return "()* loopback of 4373:7: ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA42_12 = input.LA(1);

                         
                        int index42_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred53_InternalBug304681TestLanguage()) ) {s = 17;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index42_12);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 42, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000180008000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000180008002L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000050000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x000000020F780000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x000000000C800000L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x000000000C000002L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x000000000C000000L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000400000010L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000010800L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000180000L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x000000020C380000L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000001810180000L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000060000000L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000820L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x000000020F780002L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000180002L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x000000020C380002L});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000010000002L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000001810180002L});
        public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000060000002L});
    }


}
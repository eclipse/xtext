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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug347012TestLanguageGrammarAccess;



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
public class InternalBug347012TestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_LT", "RULE_ID", "RULE_NUMBER", "RULE_STRING", "RULE_IDPLAINCHAR", "RULE_DIGIT", "RULE_WS", "RULE_ESCAPE", "RULE_HEX", "';'", "'.'", "'package'", "'{'", "'}'", "'public'", "'class'", "'var'", "','", "':'", "'='", "'true'", "'false'", "'private'"
    };
    public static final int RULE_HEX=12;
    public static final int RULE_STRING=7;
    public static final int RULE_IDPLAINCHAR=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ESCAPE=11;
    public static final int RULE_ID=5;
    public static final int RULE_WS=10;
    public static final int RULE_DIGIT=9;
    public static final int RULE_NUMBER=6;
    public static final int RULE_LT=4;
    public static final int T__26=26;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalBug347012TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug347012TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug347012TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug347012TestLanguage.g"; }


    	private Bug347012TestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(Bug347012TestLanguageGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleMyProgram"
    // InternalBug347012TestLanguage.g:58:1: entryRuleMyProgram : ruleMyProgram EOF ;
    public final void entryRuleMyProgram() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:59:1: ( ruleMyProgram EOF )
            // InternalBug347012TestLanguage.g:60:1: ruleMyProgram EOF
            {
             before(grammarAccess.getMyProgramRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMyProgram();

            state._fsp--;

             after(grammarAccess.getMyProgramRule()); 
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
    // $ANTLR end "entryRuleMyProgram"


    // $ANTLR start "ruleMyProgram"
    // InternalBug347012TestLanguage.g:67:1: ruleMyProgram : ( ( rule__MyProgram__Group__0 ) ) ;
    public final void ruleMyProgram() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:71:2: ( ( ( rule__MyProgram__Group__0 ) ) )
            // InternalBug347012TestLanguage.g:72:2: ( ( rule__MyProgram__Group__0 ) )
            {
            // InternalBug347012TestLanguage.g:72:2: ( ( rule__MyProgram__Group__0 ) )
            // InternalBug347012TestLanguage.g:73:3: ( rule__MyProgram__Group__0 )
            {
             before(grammarAccess.getMyProgramAccess().getGroup()); 
            // InternalBug347012TestLanguage.g:74:3: ( rule__MyProgram__Group__0 )
            // InternalBug347012TestLanguage.g:74:4: rule__MyProgram__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyProgram__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMyProgramAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMyProgram"


    // $ANTLR start "entryRuleIdentifier"
    // InternalBug347012TestLanguage.g:83:1: entryRuleIdentifier : ruleIdentifier EOF ;
    public final void entryRuleIdentifier() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:84:1: ( ruleIdentifier EOF )
            // InternalBug347012TestLanguage.g:85:1: ruleIdentifier EOF
            {
             before(grammarAccess.getIdentifierRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleIdentifier();

            state._fsp--;

             after(grammarAccess.getIdentifierRule()); 
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
    // $ANTLR end "entryRuleIdentifier"


    // $ANTLR start "ruleIdentifier"
    // InternalBug347012TestLanguage.g:92:1: ruleIdentifier : ( ( rule__Identifier__NameAssignment ) ) ;
    public final void ruleIdentifier() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:96:2: ( ( ( rule__Identifier__NameAssignment ) ) )
            // InternalBug347012TestLanguage.g:97:2: ( ( rule__Identifier__NameAssignment ) )
            {
            // InternalBug347012TestLanguage.g:97:2: ( ( rule__Identifier__NameAssignment ) )
            // InternalBug347012TestLanguage.g:98:3: ( rule__Identifier__NameAssignment )
            {
             before(grammarAccess.getIdentifierAccess().getNameAssignment()); 
            // InternalBug347012TestLanguage.g:99:3: ( rule__Identifier__NameAssignment )
            // InternalBug347012TestLanguage.g:99:4: rule__Identifier__NameAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Identifier__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getIdentifierAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIdentifier"


    // $ANTLR start "entryRuleFQN"
    // InternalBug347012TestLanguage.g:108:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:109:1: ( ruleFQN EOF )
            // InternalBug347012TestLanguage.g:110:1: ruleFQN EOF
            {
             before(grammarAccess.getFQNRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getFQNRule()); 
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
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // InternalBug347012TestLanguage.g:117:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:121:2: ( ( ( rule__FQN__Group__0 ) ) )
            // InternalBug347012TestLanguage.g:122:2: ( ( rule__FQN__Group__0 ) )
            {
            // InternalBug347012TestLanguage.g:122:2: ( ( rule__FQN__Group__0 ) )
            // InternalBug347012TestLanguage.g:123:3: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // InternalBug347012TestLanguage.g:124:3: ( rule__FQN__Group__0 )
            // InternalBug347012TestLanguage.g:124:4: rule__FQN__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__FQN__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFQNAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFQN"


    // $ANTLR start "entryRuleVirtualSemi"
    // InternalBug347012TestLanguage.g:133:1: entryRuleVirtualSemi : ruleVirtualSemi EOF ;
    public final void entryRuleVirtualSemi() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:134:1: ( ruleVirtualSemi EOF )
            // InternalBug347012TestLanguage.g:135:1: ruleVirtualSemi EOF
            {
             before(grammarAccess.getVirtualSemiRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleVirtualSemi();

            state._fsp--;

             after(grammarAccess.getVirtualSemiRule()); 
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
    // $ANTLR end "entryRuleVirtualSemi"


    // $ANTLR start "ruleVirtualSemi"
    // InternalBug347012TestLanguage.g:142:1: ruleVirtualSemi : ( ( rule__VirtualSemi__Alternatives ) ) ;
    public final void ruleVirtualSemi() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:146:2: ( ( ( rule__VirtualSemi__Alternatives ) ) )
            // InternalBug347012TestLanguage.g:147:2: ( ( rule__VirtualSemi__Alternatives ) )
            {
            // InternalBug347012TestLanguage.g:147:2: ( ( rule__VirtualSemi__Alternatives ) )
            // InternalBug347012TestLanguage.g:148:3: ( rule__VirtualSemi__Alternatives )
            {
             before(grammarAccess.getVirtualSemiAccess().getAlternatives()); 
            // InternalBug347012TestLanguage.g:149:3: ( rule__VirtualSemi__Alternatives )
            // InternalBug347012TestLanguage.g:149:4: rule__VirtualSemi__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__VirtualSemi__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getVirtualSemiAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVirtualSemi"


    // $ANTLR start "entryRuleLiteral"
    // InternalBug347012TestLanguage.g:158:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:159:1: ( ruleLiteral EOF )
            // InternalBug347012TestLanguage.g:160:1: ruleLiteral EOF
            {
             before(grammarAccess.getLiteralRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleLiteral();

            state._fsp--;

             after(grammarAccess.getLiteralRule()); 
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
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // InternalBug347012TestLanguage.g:167:1: ruleLiteral : ( ( rule__Literal__Alternatives ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:171:2: ( ( ( rule__Literal__Alternatives ) ) )
            // InternalBug347012TestLanguage.g:172:2: ( ( rule__Literal__Alternatives ) )
            {
            // InternalBug347012TestLanguage.g:172:2: ( ( rule__Literal__Alternatives ) )
            // InternalBug347012TestLanguage.g:173:3: ( rule__Literal__Alternatives )
            {
             before(grammarAccess.getLiteralAccess().getAlternatives()); 
            // InternalBug347012TestLanguage.g:174:3: ( rule__Literal__Alternatives )
            // InternalBug347012TestLanguage.g:174:4: rule__Literal__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Literal__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getLiteralAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleMyPrimary"
    // InternalBug347012TestLanguage.g:183:1: entryRuleMyPrimary : ruleMyPrimary EOF ;
    public final void entryRuleMyPrimary() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:184:1: ( ruleMyPrimary EOF )
            // InternalBug347012TestLanguage.g:185:1: ruleMyPrimary EOF
            {
             before(grammarAccess.getMyPrimaryRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMyPrimary();

            state._fsp--;

             after(grammarAccess.getMyPrimaryRule()); 
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
    // $ANTLR end "entryRuleMyPrimary"


    // $ANTLR start "ruleMyPrimary"
    // InternalBug347012TestLanguage.g:192:1: ruleMyPrimary : ( ( rule__MyPrimary__Alternatives ) ) ;
    public final void ruleMyPrimary() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:196:2: ( ( ( rule__MyPrimary__Alternatives ) ) )
            // InternalBug347012TestLanguage.g:197:2: ( ( rule__MyPrimary__Alternatives ) )
            {
            // InternalBug347012TestLanguage.g:197:2: ( ( rule__MyPrimary__Alternatives ) )
            // InternalBug347012TestLanguage.g:198:3: ( rule__MyPrimary__Alternatives )
            {
             before(grammarAccess.getMyPrimaryAccess().getAlternatives()); 
            // InternalBug347012TestLanguage.g:199:3: ( rule__MyPrimary__Alternatives )
            // InternalBug347012TestLanguage.g:199:4: rule__MyPrimary__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyPrimary__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getMyPrimaryAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMyPrimary"


    // $ANTLR start "entryRuleMyPackage"
    // InternalBug347012TestLanguage.g:208:1: entryRuleMyPackage : ruleMyPackage EOF ;
    public final void entryRuleMyPackage() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:209:1: ( ruleMyPackage EOF )
            // InternalBug347012TestLanguage.g:210:1: ruleMyPackage EOF
            {
             before(grammarAccess.getMyPackageRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMyPackage();

            state._fsp--;

             after(grammarAccess.getMyPackageRule()); 
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
    // $ANTLR end "entryRuleMyPackage"


    // $ANTLR start "ruleMyPackage"
    // InternalBug347012TestLanguage.g:217:1: ruleMyPackage : ( ( rule__MyPackage__Group__0 ) ) ;
    public final void ruleMyPackage() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:221:2: ( ( ( rule__MyPackage__Group__0 ) ) )
            // InternalBug347012TestLanguage.g:222:2: ( ( rule__MyPackage__Group__0 ) )
            {
            // InternalBug347012TestLanguage.g:222:2: ( ( rule__MyPackage__Group__0 ) )
            // InternalBug347012TestLanguage.g:223:3: ( rule__MyPackage__Group__0 )
            {
             before(grammarAccess.getMyPackageAccess().getGroup()); 
            // InternalBug347012TestLanguage.g:224:3: ( rule__MyPackage__Group__0 )
            // InternalBug347012TestLanguage.g:224:4: rule__MyPackage__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyPackage__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMyPackageAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMyPackage"


    // $ANTLR start "entryRuleMyClass"
    // InternalBug347012TestLanguage.g:233:1: entryRuleMyClass : ruleMyClass EOF ;
    public final void entryRuleMyClass() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:234:1: ( ruleMyClass EOF )
            // InternalBug347012TestLanguage.g:235:1: ruleMyClass EOF
            {
             before(grammarAccess.getMyClassRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMyClass();

            state._fsp--;

             after(grammarAccess.getMyClassRule()); 
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
    // $ANTLR end "entryRuleMyClass"


    // $ANTLR start "ruleMyClass"
    // InternalBug347012TestLanguage.g:242:1: ruleMyClass : ( ( rule__MyClass__Group__0 ) ) ;
    public final void ruleMyClass() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:246:2: ( ( ( rule__MyClass__Group__0 ) ) )
            // InternalBug347012TestLanguage.g:247:2: ( ( rule__MyClass__Group__0 ) )
            {
            // InternalBug347012TestLanguage.g:247:2: ( ( rule__MyClass__Group__0 ) )
            // InternalBug347012TestLanguage.g:248:3: ( rule__MyClass__Group__0 )
            {
             before(grammarAccess.getMyClassAccess().getGroup()); 
            // InternalBug347012TestLanguage.g:249:3: ( rule__MyClass__Group__0 )
            // InternalBug347012TestLanguage.g:249:4: rule__MyClass__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyClass__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMyClassAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMyClass"


    // $ANTLR start "entryRuleMyAttribute"
    // InternalBug347012TestLanguage.g:258:1: entryRuleMyAttribute : ruleMyAttribute EOF ;
    public final void entryRuleMyAttribute() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:259:1: ( ruleMyAttribute EOF )
            // InternalBug347012TestLanguage.g:260:1: ruleMyAttribute EOF
            {
             before(grammarAccess.getMyAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMyAttribute();

            state._fsp--;

             after(grammarAccess.getMyAttributeRule()); 
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
    // $ANTLR end "entryRuleMyAttribute"


    // $ANTLR start "ruleMyAttribute"
    // InternalBug347012TestLanguage.g:267:1: ruleMyAttribute : ( ( rule__MyAttribute__Alternatives ) ) ;
    public final void ruleMyAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:271:2: ( ( ( rule__MyAttribute__Alternatives ) ) )
            // InternalBug347012TestLanguage.g:272:2: ( ( rule__MyAttribute__Alternatives ) )
            {
            // InternalBug347012TestLanguage.g:272:2: ( ( rule__MyAttribute__Alternatives ) )
            // InternalBug347012TestLanguage.g:273:3: ( rule__MyAttribute__Alternatives )
            {
             before(grammarAccess.getMyAttributeAccess().getAlternatives()); 
            // InternalBug347012TestLanguage.g:274:3: ( rule__MyAttribute__Alternatives )
            // InternalBug347012TestLanguage.g:274:4: rule__MyAttribute__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyAttribute__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getMyAttributeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMyAttribute"


    // $ANTLR start "entryRuleMyAttributes"
    // InternalBug347012TestLanguage.g:283:1: entryRuleMyAttributes : ruleMyAttributes EOF ;
    public final void entryRuleMyAttributes() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:284:1: ( ruleMyAttributes EOF )
            // InternalBug347012TestLanguage.g:285:1: ruleMyAttributes EOF
            {
             before(grammarAccess.getMyAttributesRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMyAttributes();

            state._fsp--;

             after(grammarAccess.getMyAttributesRule()); 
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
    // $ANTLR end "entryRuleMyAttributes"


    // $ANTLR start "ruleMyAttributes"
    // InternalBug347012TestLanguage.g:292:1: ruleMyAttributes : ( ( rule__MyAttributes__Group__0 ) ) ;
    public final void ruleMyAttributes() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:296:2: ( ( ( rule__MyAttributes__Group__0 ) ) )
            // InternalBug347012TestLanguage.g:297:2: ( ( rule__MyAttributes__Group__0 ) )
            {
            // InternalBug347012TestLanguage.g:297:2: ( ( rule__MyAttributes__Group__0 ) )
            // InternalBug347012TestLanguage.g:298:3: ( rule__MyAttributes__Group__0 )
            {
             before(grammarAccess.getMyAttributesAccess().getGroup()); 
            // InternalBug347012TestLanguage.g:299:3: ( rule__MyAttributes__Group__0 )
            // InternalBug347012TestLanguage.g:299:4: rule__MyAttributes__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyAttributes__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMyAttributesAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMyAttributes"


    // $ANTLR start "entryRuleMyField"
    // InternalBug347012TestLanguage.g:308:1: entryRuleMyField : ruleMyField EOF ;
    public final void entryRuleMyField() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:309:1: ( ruleMyField EOF )
            // InternalBug347012TestLanguage.g:310:1: ruleMyField EOF
            {
             before(grammarAccess.getMyFieldRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMyField();

            state._fsp--;

             after(grammarAccess.getMyFieldRule()); 
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
    // $ANTLR end "entryRuleMyField"


    // $ANTLR start "ruleMyField"
    // InternalBug347012TestLanguage.g:317:1: ruleMyField : ( ( rule__MyField__Group__0 ) ) ;
    public final void ruleMyField() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:321:2: ( ( ( rule__MyField__Group__0 ) ) )
            // InternalBug347012TestLanguage.g:322:2: ( ( rule__MyField__Group__0 ) )
            {
            // InternalBug347012TestLanguage.g:322:2: ( ( rule__MyField__Group__0 ) )
            // InternalBug347012TestLanguage.g:323:3: ( rule__MyField__Group__0 )
            {
             before(grammarAccess.getMyFieldAccess().getGroup()); 
            // InternalBug347012TestLanguage.g:324:3: ( rule__MyField__Group__0 )
            // InternalBug347012TestLanguage.g:324:4: rule__MyField__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyField__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMyFieldAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMyField"


    // $ANTLR start "entryRuleMyBinding"
    // InternalBug347012TestLanguage.g:333:1: entryRuleMyBinding : ruleMyBinding EOF ;
    public final void entryRuleMyBinding() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:334:1: ( ruleMyBinding EOF )
            // InternalBug347012TestLanguage.g:335:1: ruleMyBinding EOF
            {
             before(grammarAccess.getMyBindingRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMyBinding();

            state._fsp--;

             after(grammarAccess.getMyBindingRule()); 
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
    // $ANTLR end "entryRuleMyBinding"


    // $ANTLR start "ruleMyBinding"
    // InternalBug347012TestLanguage.g:342:1: ruleMyBinding : ( ( rule__MyBinding__Group__0 ) ) ;
    public final void ruleMyBinding() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:346:2: ( ( ( rule__MyBinding__Group__0 ) ) )
            // InternalBug347012TestLanguage.g:347:2: ( ( rule__MyBinding__Group__0 ) )
            {
            // InternalBug347012TestLanguage.g:347:2: ( ( rule__MyBinding__Group__0 ) )
            // InternalBug347012TestLanguage.g:348:3: ( rule__MyBinding__Group__0 )
            {
             before(grammarAccess.getMyBindingAccess().getGroup()); 
            // InternalBug347012TestLanguage.g:349:3: ( rule__MyBinding__Group__0 )
            // InternalBug347012TestLanguage.g:349:4: rule__MyBinding__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyBinding__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMyBindingAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMyBinding"


    // $ANTLR start "rule__VirtualSemi__Alternatives"
    // InternalBug347012TestLanguage.g:357:1: rule__VirtualSemi__Alternatives : ( ( ';' ) | ( RULE_LT ) );
    public final void rule__VirtualSemi__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:361:1: ( ( ';' ) | ( RULE_LT ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==13) ) {
                alt1=1;
            }
            else if ( (LA1_0==RULE_LT) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalBug347012TestLanguage.g:362:2: ( ';' )
                    {
                    // InternalBug347012TestLanguage.g:362:2: ( ';' )
                    // InternalBug347012TestLanguage.g:363:3: ';'
                    {
                     before(grammarAccess.getVirtualSemiAccess().getSemicolonKeyword_0()); 
                    match(input,13,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getVirtualSemiAccess().getSemicolonKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug347012TestLanguage.g:368:2: ( RULE_LT )
                    {
                    // InternalBug347012TestLanguage.g:368:2: ( RULE_LT )
                    // InternalBug347012TestLanguage.g:369:3: RULE_LT
                    {
                     before(grammarAccess.getVirtualSemiAccess().getLTTerminalRuleCall_1()); 
                    match(input,RULE_LT,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getVirtualSemiAccess().getLTTerminalRuleCall_1()); 

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
    // $ANTLR end "rule__VirtualSemi__Alternatives"


    // $ANTLR start "rule__Literal__Alternatives"
    // InternalBug347012TestLanguage.g:378:1: rule__Literal__Alternatives : ( ( ( rule__Literal__NumAssignment_0 ) ) | ( ( rule__Literal__StrAssignment_1 ) ) | ( ( rule__Literal__BoolAssignment_2 ) ) | ( ( rule__Literal__BoolAssignment_3 ) ) );
    public final void rule__Literal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:382:1: ( ( ( rule__Literal__NumAssignment_0 ) ) | ( ( rule__Literal__StrAssignment_1 ) ) | ( ( rule__Literal__BoolAssignment_2 ) ) | ( ( rule__Literal__BoolAssignment_3 ) ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case RULE_NUMBER:
                {
                alt2=1;
                }
                break;
            case RULE_STRING:
                {
                alt2=2;
                }
                break;
            case 24:
                {
                alt2=3;
                }
                break;
            case 25:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalBug347012TestLanguage.g:383:2: ( ( rule__Literal__NumAssignment_0 ) )
                    {
                    // InternalBug347012TestLanguage.g:383:2: ( ( rule__Literal__NumAssignment_0 ) )
                    // InternalBug347012TestLanguage.g:384:3: ( rule__Literal__NumAssignment_0 )
                    {
                     before(grammarAccess.getLiteralAccess().getNumAssignment_0()); 
                    // InternalBug347012TestLanguage.g:385:3: ( rule__Literal__NumAssignment_0 )
                    // InternalBug347012TestLanguage.g:385:4: rule__Literal__NumAssignment_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Literal__NumAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getLiteralAccess().getNumAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug347012TestLanguage.g:389:2: ( ( rule__Literal__StrAssignment_1 ) )
                    {
                    // InternalBug347012TestLanguage.g:389:2: ( ( rule__Literal__StrAssignment_1 ) )
                    // InternalBug347012TestLanguage.g:390:3: ( rule__Literal__StrAssignment_1 )
                    {
                     before(grammarAccess.getLiteralAccess().getStrAssignment_1()); 
                    // InternalBug347012TestLanguage.g:391:3: ( rule__Literal__StrAssignment_1 )
                    // InternalBug347012TestLanguage.g:391:4: rule__Literal__StrAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Literal__StrAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getLiteralAccess().getStrAssignment_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBug347012TestLanguage.g:395:2: ( ( rule__Literal__BoolAssignment_2 ) )
                    {
                    // InternalBug347012TestLanguage.g:395:2: ( ( rule__Literal__BoolAssignment_2 ) )
                    // InternalBug347012TestLanguage.g:396:3: ( rule__Literal__BoolAssignment_2 )
                    {
                     before(grammarAccess.getLiteralAccess().getBoolAssignment_2()); 
                    // InternalBug347012TestLanguage.g:397:3: ( rule__Literal__BoolAssignment_2 )
                    // InternalBug347012TestLanguage.g:397:4: rule__Literal__BoolAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Literal__BoolAssignment_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getLiteralAccess().getBoolAssignment_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBug347012TestLanguage.g:401:2: ( ( rule__Literal__BoolAssignment_3 ) )
                    {
                    // InternalBug347012TestLanguage.g:401:2: ( ( rule__Literal__BoolAssignment_3 ) )
                    // InternalBug347012TestLanguage.g:402:3: ( rule__Literal__BoolAssignment_3 )
                    {
                     before(grammarAccess.getLiteralAccess().getBoolAssignment_3()); 
                    // InternalBug347012TestLanguage.g:403:3: ( rule__Literal__BoolAssignment_3 )
                    // InternalBug347012TestLanguage.g:403:4: rule__Literal__BoolAssignment_3
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Literal__BoolAssignment_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getLiteralAccess().getBoolAssignment_3()); 

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
    // $ANTLR end "rule__Literal__Alternatives"


    // $ANTLR start "rule__MyPrimary__Alternatives"
    // InternalBug347012TestLanguage.g:411:1: rule__MyPrimary__Alternatives : ( ( ruleLiteral ) | ( ruleIdentifier ) );
    public final void rule__MyPrimary__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:415:1: ( ( ruleLiteral ) | ( ruleIdentifier ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=RULE_NUMBER && LA3_0<=RULE_STRING)||(LA3_0>=24 && LA3_0<=25)) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_ID) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalBug347012TestLanguage.g:416:2: ( ruleLiteral )
                    {
                    // InternalBug347012TestLanguage.g:416:2: ( ruleLiteral )
                    // InternalBug347012TestLanguage.g:417:3: ruleLiteral
                    {
                     before(grammarAccess.getMyPrimaryAccess().getLiteralParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleLiteral();

                    state._fsp--;

                     after(grammarAccess.getMyPrimaryAccess().getLiteralParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug347012TestLanguage.g:422:2: ( ruleIdentifier )
                    {
                    // InternalBug347012TestLanguage.g:422:2: ( ruleIdentifier )
                    // InternalBug347012TestLanguage.g:423:3: ruleIdentifier
                    {
                     before(grammarAccess.getMyPrimaryAccess().getIdentifierParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleIdentifier();

                    state._fsp--;

                     after(grammarAccess.getMyPrimaryAccess().getIdentifierParserRuleCall_1()); 

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
    // $ANTLR end "rule__MyPrimary__Alternatives"


    // $ANTLR start "rule__MyAttribute__Alternatives"
    // InternalBug347012TestLanguage.g:432:1: rule__MyAttribute__Alternatives : ( ( ( rule__MyAttribute__PUBLICAssignment_0 ) ) | ( ( rule__MyAttribute__PRIVATEAssignment_1 ) ) );
    public final void rule__MyAttribute__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:436:1: ( ( ( rule__MyAttribute__PUBLICAssignment_0 ) ) | ( ( rule__MyAttribute__PRIVATEAssignment_1 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==18) ) {
                alt4=1;
            }
            else if ( (LA4_0==26) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalBug347012TestLanguage.g:437:2: ( ( rule__MyAttribute__PUBLICAssignment_0 ) )
                    {
                    // InternalBug347012TestLanguage.g:437:2: ( ( rule__MyAttribute__PUBLICAssignment_0 ) )
                    // InternalBug347012TestLanguage.g:438:3: ( rule__MyAttribute__PUBLICAssignment_0 )
                    {
                     before(grammarAccess.getMyAttributeAccess().getPUBLICAssignment_0()); 
                    // InternalBug347012TestLanguage.g:439:3: ( rule__MyAttribute__PUBLICAssignment_0 )
                    // InternalBug347012TestLanguage.g:439:4: rule__MyAttribute__PUBLICAssignment_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__MyAttribute__PUBLICAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getMyAttributeAccess().getPUBLICAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug347012TestLanguage.g:443:2: ( ( rule__MyAttribute__PRIVATEAssignment_1 ) )
                    {
                    // InternalBug347012TestLanguage.g:443:2: ( ( rule__MyAttribute__PRIVATEAssignment_1 ) )
                    // InternalBug347012TestLanguage.g:444:3: ( rule__MyAttribute__PRIVATEAssignment_1 )
                    {
                     before(grammarAccess.getMyAttributeAccess().getPRIVATEAssignment_1()); 
                    // InternalBug347012TestLanguage.g:445:3: ( rule__MyAttribute__PRIVATEAssignment_1 )
                    // InternalBug347012TestLanguage.g:445:4: rule__MyAttribute__PRIVATEAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__MyAttribute__PRIVATEAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getMyAttributeAccess().getPRIVATEAssignment_1()); 

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
    // $ANTLR end "rule__MyAttribute__Alternatives"


    // $ANTLR start "rule__MyProgram__Group__0"
    // InternalBug347012TestLanguage.g:453:1: rule__MyProgram__Group__0 : rule__MyProgram__Group__0__Impl rule__MyProgram__Group__1 ;
    public final void rule__MyProgram__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:457:1: ( rule__MyProgram__Group__0__Impl rule__MyProgram__Group__1 )
            // InternalBug347012TestLanguage.g:458:2: rule__MyProgram__Group__0__Impl rule__MyProgram__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__MyProgram__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyProgram__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyProgram__Group__0"


    // $ANTLR start "rule__MyProgram__Group__0__Impl"
    // InternalBug347012TestLanguage.g:465:1: rule__MyProgram__Group__0__Impl : ( () ) ;
    public final void rule__MyProgram__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:469:1: ( ( () ) )
            // InternalBug347012TestLanguage.g:470:1: ( () )
            {
            // InternalBug347012TestLanguage.g:470:1: ( () )
            // InternalBug347012TestLanguage.g:471:2: ()
            {
             before(grammarAccess.getMyProgramAccess().getMyProgramAction_0()); 
            // InternalBug347012TestLanguage.g:472:2: ()
            // InternalBug347012TestLanguage.g:472:3: 
            {
            }

             after(grammarAccess.getMyProgramAccess().getMyProgramAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyProgram__Group__0__Impl"


    // $ANTLR start "rule__MyProgram__Group__1"
    // InternalBug347012TestLanguage.g:480:1: rule__MyProgram__Group__1 : rule__MyProgram__Group__1__Impl rule__MyProgram__Group__2 ;
    public final void rule__MyProgram__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:484:1: ( rule__MyProgram__Group__1__Impl rule__MyProgram__Group__2 )
            // InternalBug347012TestLanguage.g:485:2: rule__MyProgram__Group__1__Impl rule__MyProgram__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__MyProgram__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyProgram__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyProgram__Group__1"


    // $ANTLR start "rule__MyProgram__Group__1__Impl"
    // InternalBug347012TestLanguage.g:492:1: rule__MyProgram__Group__1__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyProgram__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:496:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:497:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:497:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:498:2: ( RULE_LT )*
            {
             before(grammarAccess.getMyProgramAccess().getLTTerminalRuleCall_1()); 
            // InternalBug347012TestLanguage.g:499:2: ( RULE_LT )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_LT) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:499:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_4); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getMyProgramAccess().getLTTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyProgram__Group__1__Impl"


    // $ANTLR start "rule__MyProgram__Group__2"
    // InternalBug347012TestLanguage.g:507:1: rule__MyProgram__Group__2 : rule__MyProgram__Group__2__Impl rule__MyProgram__Group__3 ;
    public final void rule__MyProgram__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:511:1: ( rule__MyProgram__Group__2__Impl rule__MyProgram__Group__3 )
            // InternalBug347012TestLanguage.g:512:2: rule__MyProgram__Group__2__Impl rule__MyProgram__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__MyProgram__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyProgram__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyProgram__Group__2"


    // $ANTLR start "rule__MyProgram__Group__2__Impl"
    // InternalBug347012TestLanguage.g:519:1: rule__MyProgram__Group__2__Impl : ( ( rule__MyProgram__PackageAssignment_2 ) ) ;
    public final void rule__MyProgram__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:523:1: ( ( ( rule__MyProgram__PackageAssignment_2 ) ) )
            // InternalBug347012TestLanguage.g:524:1: ( ( rule__MyProgram__PackageAssignment_2 ) )
            {
            // InternalBug347012TestLanguage.g:524:1: ( ( rule__MyProgram__PackageAssignment_2 ) )
            // InternalBug347012TestLanguage.g:525:2: ( rule__MyProgram__PackageAssignment_2 )
            {
             before(grammarAccess.getMyProgramAccess().getPackageAssignment_2()); 
            // InternalBug347012TestLanguage.g:526:2: ( rule__MyProgram__PackageAssignment_2 )
            // InternalBug347012TestLanguage.g:526:3: rule__MyProgram__PackageAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyProgram__PackageAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getMyProgramAccess().getPackageAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyProgram__Group__2__Impl"


    // $ANTLR start "rule__MyProgram__Group__3"
    // InternalBug347012TestLanguage.g:534:1: rule__MyProgram__Group__3 : rule__MyProgram__Group__3__Impl ;
    public final void rule__MyProgram__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:538:1: ( rule__MyProgram__Group__3__Impl )
            // InternalBug347012TestLanguage.g:539:2: rule__MyProgram__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyProgram__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyProgram__Group__3"


    // $ANTLR start "rule__MyProgram__Group__3__Impl"
    // InternalBug347012TestLanguage.g:545:1: rule__MyProgram__Group__3__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyProgram__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:549:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:550:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:550:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:551:2: ( RULE_LT )*
            {
             before(grammarAccess.getMyProgramAccess().getLTTerminalRuleCall_3()); 
            // InternalBug347012TestLanguage.g:552:2: ( RULE_LT )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_LT) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:552:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_4); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getMyProgramAccess().getLTTerminalRuleCall_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyProgram__Group__3__Impl"


    // $ANTLR start "rule__FQN__Group__0"
    // InternalBug347012TestLanguage.g:561:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:565:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // InternalBug347012TestLanguage.g:566:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__FQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__FQN__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group__0"


    // $ANTLR start "rule__FQN__Group__0__Impl"
    // InternalBug347012TestLanguage.g:573:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:577:1: ( ( RULE_ID ) )
            // InternalBug347012TestLanguage.g:578:1: ( RULE_ID )
            {
            // InternalBug347012TestLanguage.g:578:1: ( RULE_ID )
            // InternalBug347012TestLanguage.g:579:2: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group__0__Impl"


    // $ANTLR start "rule__FQN__Group__1"
    // InternalBug347012TestLanguage.g:588:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:592:1: ( rule__FQN__Group__1__Impl )
            // InternalBug347012TestLanguage.g:593:2: rule__FQN__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__FQN__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group__1"


    // $ANTLR start "rule__FQN__Group__1__Impl"
    // InternalBug347012TestLanguage.g:599:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:603:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // InternalBug347012TestLanguage.g:604:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // InternalBug347012TestLanguage.g:604:1: ( ( rule__FQN__Group_1__0 )* )
            // InternalBug347012TestLanguage.g:605:2: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // InternalBug347012TestLanguage.g:606:2: ( rule__FQN__Group_1__0 )*
            loop7:
            do {
                int alt7=2;
                alt7 = dfa7.predict(input);
                switch (alt7) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:606:3: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    rule__FQN__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getFQNAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group__1__Impl"


    // $ANTLR start "rule__FQN__Group_1__0"
    // InternalBug347012TestLanguage.g:615:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:619:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // InternalBug347012TestLanguage.g:620:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__FQN__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__FQN__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group_1__0"


    // $ANTLR start "rule__FQN__Group_1__0__Impl"
    // InternalBug347012TestLanguage.g:627:1: rule__FQN__Group_1__0__Impl : ( ( RULE_LT )* ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:631:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:632:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:632:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:633:2: ( RULE_LT )*
            {
             before(grammarAccess.getFQNAccess().getLTTerminalRuleCall_1_0()); 
            // InternalBug347012TestLanguage.g:634:2: ( RULE_LT )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_LT) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:634:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_4); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getFQNAccess().getLTTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group_1__0__Impl"


    // $ANTLR start "rule__FQN__Group_1__1"
    // InternalBug347012TestLanguage.g:642:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl rule__FQN__Group_1__2 ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:646:1: ( rule__FQN__Group_1__1__Impl rule__FQN__Group_1__2 )
            // InternalBug347012TestLanguage.g:647:2: rule__FQN__Group_1__1__Impl rule__FQN__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__FQN__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__FQN__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group_1__1"


    // $ANTLR start "rule__FQN__Group_1__1__Impl"
    // InternalBug347012TestLanguage.g:654:1: rule__FQN__Group_1__1__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:658:1: ( ( '.' ) )
            // InternalBug347012TestLanguage.g:659:1: ( '.' )
            {
            // InternalBug347012TestLanguage.g:659:1: ( '.' )
            // InternalBug347012TestLanguage.g:660:2: '.'
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_1()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getFQNAccess().getFullStopKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group_1__1__Impl"


    // $ANTLR start "rule__FQN__Group_1__2"
    // InternalBug347012TestLanguage.g:669:1: rule__FQN__Group_1__2 : rule__FQN__Group_1__2__Impl rule__FQN__Group_1__3 ;
    public final void rule__FQN__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:673:1: ( rule__FQN__Group_1__2__Impl rule__FQN__Group_1__3 )
            // InternalBug347012TestLanguage.g:674:2: rule__FQN__Group_1__2__Impl rule__FQN__Group_1__3
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__FQN__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__FQN__Group_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group_1__2"


    // $ANTLR start "rule__FQN__Group_1__2__Impl"
    // InternalBug347012TestLanguage.g:681:1: rule__FQN__Group_1__2__Impl : ( ( RULE_LT )* ) ;
    public final void rule__FQN__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:685:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:686:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:686:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:687:2: ( RULE_LT )*
            {
             before(grammarAccess.getFQNAccess().getLTTerminalRuleCall_1_2()); 
            // InternalBug347012TestLanguage.g:688:2: ( RULE_LT )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_LT) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:688:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_4); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getFQNAccess().getLTTerminalRuleCall_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group_1__2__Impl"


    // $ANTLR start "rule__FQN__Group_1__3"
    // InternalBug347012TestLanguage.g:696:1: rule__FQN__Group_1__3 : rule__FQN__Group_1__3__Impl ;
    public final void rule__FQN__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:700:1: ( rule__FQN__Group_1__3__Impl )
            // InternalBug347012TestLanguage.g:701:2: rule__FQN__Group_1__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__FQN__Group_1__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group_1__3"


    // $ANTLR start "rule__FQN__Group_1__3__Impl"
    // InternalBug347012TestLanguage.g:707:1: rule__FQN__Group_1__3__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:711:1: ( ( RULE_ID ) )
            // InternalBug347012TestLanguage.g:712:1: ( RULE_ID )
            {
            // InternalBug347012TestLanguage.g:712:1: ( RULE_ID )
            // InternalBug347012TestLanguage.g:713:2: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_3()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group_1__3__Impl"


    // $ANTLR start "rule__MyPackage__Group__0"
    // InternalBug347012TestLanguage.g:723:1: rule__MyPackage__Group__0 : rule__MyPackage__Group__0__Impl rule__MyPackage__Group__1 ;
    public final void rule__MyPackage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:727:1: ( rule__MyPackage__Group__0__Impl rule__MyPackage__Group__1 )
            // InternalBug347012TestLanguage.g:728:2: rule__MyPackage__Group__0__Impl rule__MyPackage__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__MyPackage__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyPackage__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyPackage__Group__0"


    // $ANTLR start "rule__MyPackage__Group__0__Impl"
    // InternalBug347012TestLanguage.g:735:1: rule__MyPackage__Group__0__Impl : ( 'package' ) ;
    public final void rule__MyPackage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:739:1: ( ( 'package' ) )
            // InternalBug347012TestLanguage.g:740:1: ( 'package' )
            {
            // InternalBug347012TestLanguage.g:740:1: ( 'package' )
            // InternalBug347012TestLanguage.g:741:2: 'package'
            {
             before(grammarAccess.getMyPackageAccess().getPackageKeyword_0()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMyPackageAccess().getPackageKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyPackage__Group__0__Impl"


    // $ANTLR start "rule__MyPackage__Group__1"
    // InternalBug347012TestLanguage.g:750:1: rule__MyPackage__Group__1 : rule__MyPackage__Group__1__Impl rule__MyPackage__Group__2 ;
    public final void rule__MyPackage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:754:1: ( rule__MyPackage__Group__1__Impl rule__MyPackage__Group__2 )
            // InternalBug347012TestLanguage.g:755:2: rule__MyPackage__Group__1__Impl rule__MyPackage__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__MyPackage__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyPackage__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyPackage__Group__1"


    // $ANTLR start "rule__MyPackage__Group__1__Impl"
    // InternalBug347012TestLanguage.g:762:1: rule__MyPackage__Group__1__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyPackage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:766:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:767:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:767:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:768:2: ( RULE_LT )*
            {
             before(grammarAccess.getMyPackageAccess().getLTTerminalRuleCall_1()); 
            // InternalBug347012TestLanguage.g:769:2: ( RULE_LT )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_LT) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:769:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_4); 

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getMyPackageAccess().getLTTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyPackage__Group__1__Impl"


    // $ANTLR start "rule__MyPackage__Group__2"
    // InternalBug347012TestLanguage.g:777:1: rule__MyPackage__Group__2 : rule__MyPackage__Group__2__Impl rule__MyPackage__Group__3 ;
    public final void rule__MyPackage__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:781:1: ( rule__MyPackage__Group__2__Impl rule__MyPackage__Group__3 )
            // InternalBug347012TestLanguage.g:782:2: rule__MyPackage__Group__2__Impl rule__MyPackage__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__MyPackage__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyPackage__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyPackage__Group__2"


    // $ANTLR start "rule__MyPackage__Group__2__Impl"
    // InternalBug347012TestLanguage.g:789:1: rule__MyPackage__Group__2__Impl : ( ( rule__MyPackage__NameAssignment_2 ) ) ;
    public final void rule__MyPackage__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:793:1: ( ( ( rule__MyPackage__NameAssignment_2 ) ) )
            // InternalBug347012TestLanguage.g:794:1: ( ( rule__MyPackage__NameAssignment_2 ) )
            {
            // InternalBug347012TestLanguage.g:794:1: ( ( rule__MyPackage__NameAssignment_2 ) )
            // InternalBug347012TestLanguage.g:795:2: ( rule__MyPackage__NameAssignment_2 )
            {
             before(grammarAccess.getMyPackageAccess().getNameAssignment_2()); 
            // InternalBug347012TestLanguage.g:796:2: ( rule__MyPackage__NameAssignment_2 )
            // InternalBug347012TestLanguage.g:796:3: rule__MyPackage__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyPackage__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getMyPackageAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyPackage__Group__2__Impl"


    // $ANTLR start "rule__MyPackage__Group__3"
    // InternalBug347012TestLanguage.g:804:1: rule__MyPackage__Group__3 : rule__MyPackage__Group__3__Impl rule__MyPackage__Group__4 ;
    public final void rule__MyPackage__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:808:1: ( rule__MyPackage__Group__3__Impl rule__MyPackage__Group__4 )
            // InternalBug347012TestLanguage.g:809:2: rule__MyPackage__Group__3__Impl rule__MyPackage__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__MyPackage__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyPackage__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyPackage__Group__3"


    // $ANTLR start "rule__MyPackage__Group__3__Impl"
    // InternalBug347012TestLanguage.g:816:1: rule__MyPackage__Group__3__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyPackage__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:820:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:821:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:821:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:822:2: ( RULE_LT )*
            {
             before(grammarAccess.getMyPackageAccess().getLTTerminalRuleCall_3()); 
            // InternalBug347012TestLanguage.g:823:2: ( RULE_LT )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_LT) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:823:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_4); 

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getMyPackageAccess().getLTTerminalRuleCall_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyPackage__Group__3__Impl"


    // $ANTLR start "rule__MyPackage__Group__4"
    // InternalBug347012TestLanguage.g:831:1: rule__MyPackage__Group__4 : rule__MyPackage__Group__4__Impl rule__MyPackage__Group__5 ;
    public final void rule__MyPackage__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:835:1: ( rule__MyPackage__Group__4__Impl rule__MyPackage__Group__5 )
            // InternalBug347012TestLanguage.g:836:2: rule__MyPackage__Group__4__Impl rule__MyPackage__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__MyPackage__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyPackage__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyPackage__Group__4"


    // $ANTLR start "rule__MyPackage__Group__4__Impl"
    // InternalBug347012TestLanguage.g:843:1: rule__MyPackage__Group__4__Impl : ( '{' ) ;
    public final void rule__MyPackage__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:847:1: ( ( '{' ) )
            // InternalBug347012TestLanguage.g:848:1: ( '{' )
            {
            // InternalBug347012TestLanguage.g:848:1: ( '{' )
            // InternalBug347012TestLanguage.g:849:2: '{'
            {
             before(grammarAccess.getMyPackageAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,16,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMyPackageAccess().getLeftCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyPackage__Group__4__Impl"


    // $ANTLR start "rule__MyPackage__Group__5"
    // InternalBug347012TestLanguage.g:858:1: rule__MyPackage__Group__5 : rule__MyPackage__Group__5__Impl rule__MyPackage__Group__6 ;
    public final void rule__MyPackage__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:862:1: ( rule__MyPackage__Group__5__Impl rule__MyPackage__Group__6 )
            // InternalBug347012TestLanguage.g:863:2: rule__MyPackage__Group__5__Impl rule__MyPackage__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__MyPackage__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyPackage__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyPackage__Group__5"


    // $ANTLR start "rule__MyPackage__Group__5__Impl"
    // InternalBug347012TestLanguage.g:870:1: rule__MyPackage__Group__5__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyPackage__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:874:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:875:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:875:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:876:2: ( RULE_LT )*
            {
             before(grammarAccess.getMyPackageAccess().getLTTerminalRuleCall_5()); 
            // InternalBug347012TestLanguage.g:877:2: ( RULE_LT )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_LT) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:877:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_4); 

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getMyPackageAccess().getLTTerminalRuleCall_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyPackage__Group__5__Impl"


    // $ANTLR start "rule__MyPackage__Group__6"
    // InternalBug347012TestLanguage.g:885:1: rule__MyPackage__Group__6 : rule__MyPackage__Group__6__Impl rule__MyPackage__Group__7 ;
    public final void rule__MyPackage__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:889:1: ( rule__MyPackage__Group__6__Impl rule__MyPackage__Group__7 )
            // InternalBug347012TestLanguage.g:890:2: rule__MyPackage__Group__6__Impl rule__MyPackage__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__MyPackage__Group__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyPackage__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyPackage__Group__6"


    // $ANTLR start "rule__MyPackage__Group__6__Impl"
    // InternalBug347012TestLanguage.g:897:1: rule__MyPackage__Group__6__Impl : ( ( rule__MyPackage__Group_6__0 )* ) ;
    public final void rule__MyPackage__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:901:1: ( ( ( rule__MyPackage__Group_6__0 )* ) )
            // InternalBug347012TestLanguage.g:902:1: ( ( rule__MyPackage__Group_6__0 )* )
            {
            // InternalBug347012TestLanguage.g:902:1: ( ( rule__MyPackage__Group_6__0 )* )
            // InternalBug347012TestLanguage.g:903:2: ( rule__MyPackage__Group_6__0 )*
            {
             before(grammarAccess.getMyPackageAccess().getGroup_6()); 
            // InternalBug347012TestLanguage.g:904:2: ( rule__MyPackage__Group_6__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=18 && LA13_0<=19)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:904:3: rule__MyPackage__Group_6__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_11);
            	    rule__MyPackage__Group_6__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getMyPackageAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyPackage__Group__6__Impl"


    // $ANTLR start "rule__MyPackage__Group__7"
    // InternalBug347012TestLanguage.g:912:1: rule__MyPackage__Group__7 : rule__MyPackage__Group__7__Impl ;
    public final void rule__MyPackage__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:916:1: ( rule__MyPackage__Group__7__Impl )
            // InternalBug347012TestLanguage.g:917:2: rule__MyPackage__Group__7__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyPackage__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyPackage__Group__7"


    // $ANTLR start "rule__MyPackage__Group__7__Impl"
    // InternalBug347012TestLanguage.g:923:1: rule__MyPackage__Group__7__Impl : ( '}' ) ;
    public final void rule__MyPackage__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:927:1: ( ( '}' ) )
            // InternalBug347012TestLanguage.g:928:1: ( '}' )
            {
            // InternalBug347012TestLanguage.g:928:1: ( '}' )
            // InternalBug347012TestLanguage.g:929:2: '}'
            {
             before(grammarAccess.getMyPackageAccess().getRightCurlyBracketKeyword_7()); 
            match(input,17,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMyPackageAccess().getRightCurlyBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyPackage__Group__7__Impl"


    // $ANTLR start "rule__MyPackage__Group_6__0"
    // InternalBug347012TestLanguage.g:939:1: rule__MyPackage__Group_6__0 : rule__MyPackage__Group_6__0__Impl rule__MyPackage__Group_6__1 ;
    public final void rule__MyPackage__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:943:1: ( rule__MyPackage__Group_6__0__Impl rule__MyPackage__Group_6__1 )
            // InternalBug347012TestLanguage.g:944:2: rule__MyPackage__Group_6__0__Impl rule__MyPackage__Group_6__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__MyPackage__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyPackage__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyPackage__Group_6__0"


    // $ANTLR start "rule__MyPackage__Group_6__0__Impl"
    // InternalBug347012TestLanguage.g:951:1: rule__MyPackage__Group_6__0__Impl : ( ( rule__MyPackage__DirectivesAssignment_6_0 ) ) ;
    public final void rule__MyPackage__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:955:1: ( ( ( rule__MyPackage__DirectivesAssignment_6_0 ) ) )
            // InternalBug347012TestLanguage.g:956:1: ( ( rule__MyPackage__DirectivesAssignment_6_0 ) )
            {
            // InternalBug347012TestLanguage.g:956:1: ( ( rule__MyPackage__DirectivesAssignment_6_0 ) )
            // InternalBug347012TestLanguage.g:957:2: ( rule__MyPackage__DirectivesAssignment_6_0 )
            {
             before(grammarAccess.getMyPackageAccess().getDirectivesAssignment_6_0()); 
            // InternalBug347012TestLanguage.g:958:2: ( rule__MyPackage__DirectivesAssignment_6_0 )
            // InternalBug347012TestLanguage.g:958:3: rule__MyPackage__DirectivesAssignment_6_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyPackage__DirectivesAssignment_6_0();

            state._fsp--;


            }

             after(grammarAccess.getMyPackageAccess().getDirectivesAssignment_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyPackage__Group_6__0__Impl"


    // $ANTLR start "rule__MyPackage__Group_6__1"
    // InternalBug347012TestLanguage.g:966:1: rule__MyPackage__Group_6__1 : rule__MyPackage__Group_6__1__Impl ;
    public final void rule__MyPackage__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:970:1: ( rule__MyPackage__Group_6__1__Impl )
            // InternalBug347012TestLanguage.g:971:2: rule__MyPackage__Group_6__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyPackage__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyPackage__Group_6__1"


    // $ANTLR start "rule__MyPackage__Group_6__1__Impl"
    // InternalBug347012TestLanguage.g:977:1: rule__MyPackage__Group_6__1__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyPackage__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:981:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:982:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:982:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:983:2: ( RULE_LT )*
            {
             before(grammarAccess.getMyPackageAccess().getLTTerminalRuleCall_6_1()); 
            // InternalBug347012TestLanguage.g:984:2: ( RULE_LT )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_LT) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:984:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_4); 

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getMyPackageAccess().getLTTerminalRuleCall_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyPackage__Group_6__1__Impl"


    // $ANTLR start "rule__MyClass__Group__0"
    // InternalBug347012TestLanguage.g:993:1: rule__MyClass__Group__0 : rule__MyClass__Group__0__Impl rule__MyClass__Group__1 ;
    public final void rule__MyClass__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:997:1: ( rule__MyClass__Group__0__Impl rule__MyClass__Group__1 )
            // InternalBug347012TestLanguage.g:998:2: rule__MyClass__Group__0__Impl rule__MyClass__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__MyClass__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyClass__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyClass__Group__0"


    // $ANTLR start "rule__MyClass__Group__0__Impl"
    // InternalBug347012TestLanguage.g:1005:1: rule__MyClass__Group__0__Impl : ( ( 'public' )? ) ;
    public final void rule__MyClass__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1009:1: ( ( ( 'public' )? ) )
            // InternalBug347012TestLanguage.g:1010:1: ( ( 'public' )? )
            {
            // InternalBug347012TestLanguage.g:1010:1: ( ( 'public' )? )
            // InternalBug347012TestLanguage.g:1011:2: ( 'public' )?
            {
             before(grammarAccess.getMyClassAccess().getPublicKeyword_0()); 
            // InternalBug347012TestLanguage.g:1012:2: ( 'public' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==18) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalBug347012TestLanguage.g:1012:3: 'public'
                    {
                    match(input,18,FollowSets000.FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getMyClassAccess().getPublicKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyClass__Group__0__Impl"


    // $ANTLR start "rule__MyClass__Group__1"
    // InternalBug347012TestLanguage.g:1020:1: rule__MyClass__Group__1 : rule__MyClass__Group__1__Impl rule__MyClass__Group__2 ;
    public final void rule__MyClass__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1024:1: ( rule__MyClass__Group__1__Impl rule__MyClass__Group__2 )
            // InternalBug347012TestLanguage.g:1025:2: rule__MyClass__Group__1__Impl rule__MyClass__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__MyClass__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyClass__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyClass__Group__1"


    // $ANTLR start "rule__MyClass__Group__1__Impl"
    // InternalBug347012TestLanguage.g:1032:1: rule__MyClass__Group__1__Impl : ( 'class' ) ;
    public final void rule__MyClass__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1036:1: ( ( 'class' ) )
            // InternalBug347012TestLanguage.g:1037:1: ( 'class' )
            {
            // InternalBug347012TestLanguage.g:1037:1: ( 'class' )
            // InternalBug347012TestLanguage.g:1038:2: 'class'
            {
             before(grammarAccess.getMyClassAccess().getClassKeyword_1()); 
            match(input,19,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMyClassAccess().getClassKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyClass__Group__1__Impl"


    // $ANTLR start "rule__MyClass__Group__2"
    // InternalBug347012TestLanguage.g:1047:1: rule__MyClass__Group__2 : rule__MyClass__Group__2__Impl rule__MyClass__Group__3 ;
    public final void rule__MyClass__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1051:1: ( rule__MyClass__Group__2__Impl rule__MyClass__Group__3 )
            // InternalBug347012TestLanguage.g:1052:2: rule__MyClass__Group__2__Impl rule__MyClass__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__MyClass__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyClass__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyClass__Group__2"


    // $ANTLR start "rule__MyClass__Group__2__Impl"
    // InternalBug347012TestLanguage.g:1059:1: rule__MyClass__Group__2__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyClass__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1063:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:1064:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:1064:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:1065:2: ( RULE_LT )*
            {
             before(grammarAccess.getMyClassAccess().getLTTerminalRuleCall_2()); 
            // InternalBug347012TestLanguage.g:1066:2: ( RULE_LT )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_LT) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1066:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_4); 

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getMyClassAccess().getLTTerminalRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyClass__Group__2__Impl"


    // $ANTLR start "rule__MyClass__Group__3"
    // InternalBug347012TestLanguage.g:1074:1: rule__MyClass__Group__3 : rule__MyClass__Group__3__Impl rule__MyClass__Group__4 ;
    public final void rule__MyClass__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1078:1: ( rule__MyClass__Group__3__Impl rule__MyClass__Group__4 )
            // InternalBug347012TestLanguage.g:1079:2: rule__MyClass__Group__3__Impl rule__MyClass__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__MyClass__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyClass__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyClass__Group__3"


    // $ANTLR start "rule__MyClass__Group__3__Impl"
    // InternalBug347012TestLanguage.g:1086:1: rule__MyClass__Group__3__Impl : ( ( rule__MyClass__NameAssignment_3 ) ) ;
    public final void rule__MyClass__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1090:1: ( ( ( rule__MyClass__NameAssignment_3 ) ) )
            // InternalBug347012TestLanguage.g:1091:1: ( ( rule__MyClass__NameAssignment_3 ) )
            {
            // InternalBug347012TestLanguage.g:1091:1: ( ( rule__MyClass__NameAssignment_3 ) )
            // InternalBug347012TestLanguage.g:1092:2: ( rule__MyClass__NameAssignment_3 )
            {
             before(grammarAccess.getMyClassAccess().getNameAssignment_3()); 
            // InternalBug347012TestLanguage.g:1093:2: ( rule__MyClass__NameAssignment_3 )
            // InternalBug347012TestLanguage.g:1093:3: rule__MyClass__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyClass__NameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getMyClassAccess().getNameAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyClass__Group__3__Impl"


    // $ANTLR start "rule__MyClass__Group__4"
    // InternalBug347012TestLanguage.g:1101:1: rule__MyClass__Group__4 : rule__MyClass__Group__4__Impl rule__MyClass__Group__5 ;
    public final void rule__MyClass__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1105:1: ( rule__MyClass__Group__4__Impl rule__MyClass__Group__5 )
            // InternalBug347012TestLanguage.g:1106:2: rule__MyClass__Group__4__Impl rule__MyClass__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__MyClass__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyClass__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyClass__Group__4"


    // $ANTLR start "rule__MyClass__Group__4__Impl"
    // InternalBug347012TestLanguage.g:1113:1: rule__MyClass__Group__4__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyClass__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1117:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:1118:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:1118:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:1119:2: ( RULE_LT )*
            {
             before(grammarAccess.getMyClassAccess().getLTTerminalRuleCall_4()); 
            // InternalBug347012TestLanguage.g:1120:2: ( RULE_LT )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_LT) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1120:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_4); 

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getMyClassAccess().getLTTerminalRuleCall_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyClass__Group__4__Impl"


    // $ANTLR start "rule__MyClass__Group__5"
    // InternalBug347012TestLanguage.g:1128:1: rule__MyClass__Group__5 : rule__MyClass__Group__5__Impl rule__MyClass__Group__6 ;
    public final void rule__MyClass__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1132:1: ( rule__MyClass__Group__5__Impl rule__MyClass__Group__6 )
            // InternalBug347012TestLanguage.g:1133:2: rule__MyClass__Group__5__Impl rule__MyClass__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__MyClass__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyClass__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyClass__Group__5"


    // $ANTLR start "rule__MyClass__Group__5__Impl"
    // InternalBug347012TestLanguage.g:1140:1: rule__MyClass__Group__5__Impl : ( '{' ) ;
    public final void rule__MyClass__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1144:1: ( ( '{' ) )
            // InternalBug347012TestLanguage.g:1145:1: ( '{' )
            {
            // InternalBug347012TestLanguage.g:1145:1: ( '{' )
            // InternalBug347012TestLanguage.g:1146:2: '{'
            {
             before(grammarAccess.getMyClassAccess().getLeftCurlyBracketKeyword_5()); 
            match(input,16,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMyClassAccess().getLeftCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyClass__Group__5__Impl"


    // $ANTLR start "rule__MyClass__Group__6"
    // InternalBug347012TestLanguage.g:1155:1: rule__MyClass__Group__6 : rule__MyClass__Group__6__Impl rule__MyClass__Group__7 ;
    public final void rule__MyClass__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1159:1: ( rule__MyClass__Group__6__Impl rule__MyClass__Group__7 )
            // InternalBug347012TestLanguage.g:1160:2: rule__MyClass__Group__6__Impl rule__MyClass__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__MyClass__Group__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyClass__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyClass__Group__6"


    // $ANTLR start "rule__MyClass__Group__6__Impl"
    // InternalBug347012TestLanguage.g:1167:1: rule__MyClass__Group__6__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyClass__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1171:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:1172:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:1172:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:1173:2: ( RULE_LT )*
            {
             before(grammarAccess.getMyClassAccess().getLTTerminalRuleCall_6()); 
            // InternalBug347012TestLanguage.g:1174:2: ( RULE_LT )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_LT) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1174:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_4); 

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getMyClassAccess().getLTTerminalRuleCall_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyClass__Group__6__Impl"


    // $ANTLR start "rule__MyClass__Group__7"
    // InternalBug347012TestLanguage.g:1182:1: rule__MyClass__Group__7 : rule__MyClass__Group__7__Impl rule__MyClass__Group__8 ;
    public final void rule__MyClass__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1186:1: ( rule__MyClass__Group__7__Impl rule__MyClass__Group__8 )
            // InternalBug347012TestLanguage.g:1187:2: rule__MyClass__Group__7__Impl rule__MyClass__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__MyClass__Group__7__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyClass__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyClass__Group__7"


    // $ANTLR start "rule__MyClass__Group__7__Impl"
    // InternalBug347012TestLanguage.g:1194:1: rule__MyClass__Group__7__Impl : ( ( rule__MyClass__Group_7__0 )* ) ;
    public final void rule__MyClass__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1198:1: ( ( ( rule__MyClass__Group_7__0 )* ) )
            // InternalBug347012TestLanguage.g:1199:1: ( ( rule__MyClass__Group_7__0 )* )
            {
            // InternalBug347012TestLanguage.g:1199:1: ( ( rule__MyClass__Group_7__0 )* )
            // InternalBug347012TestLanguage.g:1200:2: ( rule__MyClass__Group_7__0 )*
            {
             before(grammarAccess.getMyClassAccess().getGroup_7()); 
            // InternalBug347012TestLanguage.g:1201:2: ( rule__MyClass__Group_7__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==EOF||LA19_0==18||LA19_0==20||LA19_0==26) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1201:3: rule__MyClass__Group_7__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_14);
            	    rule__MyClass__Group_7__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getMyClassAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyClass__Group__7__Impl"


    // $ANTLR start "rule__MyClass__Group__8"
    // InternalBug347012TestLanguage.g:1209:1: rule__MyClass__Group__8 : rule__MyClass__Group__8__Impl ;
    public final void rule__MyClass__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1213:1: ( rule__MyClass__Group__8__Impl )
            // InternalBug347012TestLanguage.g:1214:2: rule__MyClass__Group__8__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyClass__Group__8__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyClass__Group__8"


    // $ANTLR start "rule__MyClass__Group__8__Impl"
    // InternalBug347012TestLanguage.g:1220:1: rule__MyClass__Group__8__Impl : ( '}' ) ;
    public final void rule__MyClass__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1224:1: ( ( '}' ) )
            // InternalBug347012TestLanguage.g:1225:1: ( '}' )
            {
            // InternalBug347012TestLanguage.g:1225:1: ( '}' )
            // InternalBug347012TestLanguage.g:1226:2: '}'
            {
             before(grammarAccess.getMyClassAccess().getRightCurlyBracketKeyword_8()); 
            match(input,17,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMyClassAccess().getRightCurlyBracketKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyClass__Group__8__Impl"


    // $ANTLR start "rule__MyClass__Group_7__0"
    // InternalBug347012TestLanguage.g:1236:1: rule__MyClass__Group_7__0 : rule__MyClass__Group_7__0__Impl rule__MyClass__Group_7__1 ;
    public final void rule__MyClass__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1240:1: ( rule__MyClass__Group_7__0__Impl rule__MyClass__Group_7__1 )
            // InternalBug347012TestLanguage.g:1241:2: rule__MyClass__Group_7__0__Impl rule__MyClass__Group_7__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__MyClass__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyClass__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyClass__Group_7__0"


    // $ANTLR start "rule__MyClass__Group_7__0__Impl"
    // InternalBug347012TestLanguage.g:1248:1: rule__MyClass__Group_7__0__Impl : ( ( rule__MyClass__DirectivesAssignment_7_0 ) ) ;
    public final void rule__MyClass__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1252:1: ( ( ( rule__MyClass__DirectivesAssignment_7_0 ) ) )
            // InternalBug347012TestLanguage.g:1253:1: ( ( rule__MyClass__DirectivesAssignment_7_0 ) )
            {
            // InternalBug347012TestLanguage.g:1253:1: ( ( rule__MyClass__DirectivesAssignment_7_0 ) )
            // InternalBug347012TestLanguage.g:1254:2: ( rule__MyClass__DirectivesAssignment_7_0 )
            {
             before(grammarAccess.getMyClassAccess().getDirectivesAssignment_7_0()); 
            // InternalBug347012TestLanguage.g:1255:2: ( rule__MyClass__DirectivesAssignment_7_0 )
            // InternalBug347012TestLanguage.g:1255:3: rule__MyClass__DirectivesAssignment_7_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyClass__DirectivesAssignment_7_0();

            state._fsp--;


            }

             after(grammarAccess.getMyClassAccess().getDirectivesAssignment_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyClass__Group_7__0__Impl"


    // $ANTLR start "rule__MyClass__Group_7__1"
    // InternalBug347012TestLanguage.g:1263:1: rule__MyClass__Group_7__1 : rule__MyClass__Group_7__1__Impl ;
    public final void rule__MyClass__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1267:1: ( rule__MyClass__Group_7__1__Impl )
            // InternalBug347012TestLanguage.g:1268:2: rule__MyClass__Group_7__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyClass__Group_7__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyClass__Group_7__1"


    // $ANTLR start "rule__MyClass__Group_7__1__Impl"
    // InternalBug347012TestLanguage.g:1274:1: rule__MyClass__Group_7__1__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyClass__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1278:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:1279:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:1279:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:1280:2: ( RULE_LT )*
            {
             before(grammarAccess.getMyClassAccess().getLTTerminalRuleCall_7_1()); 
            // InternalBug347012TestLanguage.g:1281:2: ( RULE_LT )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_LT) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1281:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_4); 

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getMyClassAccess().getLTTerminalRuleCall_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyClass__Group_7__1__Impl"


    // $ANTLR start "rule__MyAttributes__Group__0"
    // InternalBug347012TestLanguage.g:1290:1: rule__MyAttributes__Group__0 : rule__MyAttributes__Group__0__Impl rule__MyAttributes__Group__1 ;
    public final void rule__MyAttributes__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1294:1: ( rule__MyAttributes__Group__0__Impl rule__MyAttributes__Group__1 )
            // InternalBug347012TestLanguage.g:1295:2: rule__MyAttributes__Group__0__Impl rule__MyAttributes__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_15);
            rule__MyAttributes__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyAttributes__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyAttributes__Group__0"


    // $ANTLR start "rule__MyAttributes__Group__0__Impl"
    // InternalBug347012TestLanguage.g:1302:1: rule__MyAttributes__Group__0__Impl : ( () ) ;
    public final void rule__MyAttributes__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1306:1: ( ( () ) )
            // InternalBug347012TestLanguage.g:1307:1: ( () )
            {
            // InternalBug347012TestLanguage.g:1307:1: ( () )
            // InternalBug347012TestLanguage.g:1308:2: ()
            {
             before(grammarAccess.getMyAttributesAccess().getMyAttributesAction_0()); 
            // InternalBug347012TestLanguage.g:1309:2: ()
            // InternalBug347012TestLanguage.g:1309:3: 
            {
            }

             after(grammarAccess.getMyAttributesAccess().getMyAttributesAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyAttributes__Group__0__Impl"


    // $ANTLR start "rule__MyAttributes__Group__1"
    // InternalBug347012TestLanguage.g:1317:1: rule__MyAttributes__Group__1 : rule__MyAttributes__Group__1__Impl ;
    public final void rule__MyAttributes__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1321:1: ( rule__MyAttributes__Group__1__Impl )
            // InternalBug347012TestLanguage.g:1322:2: rule__MyAttributes__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyAttributes__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyAttributes__Group__1"


    // $ANTLR start "rule__MyAttributes__Group__1__Impl"
    // InternalBug347012TestLanguage.g:1328:1: rule__MyAttributes__Group__1__Impl : ( ( rule__MyAttributes__AttributesAssignment_1 )* ) ;
    public final void rule__MyAttributes__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1332:1: ( ( ( rule__MyAttributes__AttributesAssignment_1 )* ) )
            // InternalBug347012TestLanguage.g:1333:1: ( ( rule__MyAttributes__AttributesAssignment_1 )* )
            {
            // InternalBug347012TestLanguage.g:1333:1: ( ( rule__MyAttributes__AttributesAssignment_1 )* )
            // InternalBug347012TestLanguage.g:1334:2: ( rule__MyAttributes__AttributesAssignment_1 )*
            {
             before(grammarAccess.getMyAttributesAccess().getAttributesAssignment_1()); 
            // InternalBug347012TestLanguage.g:1335:2: ( rule__MyAttributes__AttributesAssignment_1 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==18||LA21_0==26) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1335:3: rule__MyAttributes__AttributesAssignment_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_14);
            	    rule__MyAttributes__AttributesAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getMyAttributesAccess().getAttributesAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyAttributes__Group__1__Impl"


    // $ANTLR start "rule__MyField__Group__0"
    // InternalBug347012TestLanguage.g:1344:1: rule__MyField__Group__0 : rule__MyField__Group__0__Impl rule__MyField__Group__1 ;
    public final void rule__MyField__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1348:1: ( rule__MyField__Group__0__Impl rule__MyField__Group__1 )
            // InternalBug347012TestLanguage.g:1349:2: rule__MyField__Group__0__Impl rule__MyField__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__MyField__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyField__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyField__Group__0"


    // $ANTLR start "rule__MyField__Group__0__Impl"
    // InternalBug347012TestLanguage.g:1356:1: rule__MyField__Group__0__Impl : ( ( rule__MyField__AttrAssignment_0 ) ) ;
    public final void rule__MyField__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1360:1: ( ( ( rule__MyField__AttrAssignment_0 ) ) )
            // InternalBug347012TestLanguage.g:1361:1: ( ( rule__MyField__AttrAssignment_0 ) )
            {
            // InternalBug347012TestLanguage.g:1361:1: ( ( rule__MyField__AttrAssignment_0 ) )
            // InternalBug347012TestLanguage.g:1362:2: ( rule__MyField__AttrAssignment_0 )
            {
             before(grammarAccess.getMyFieldAccess().getAttrAssignment_0()); 
            // InternalBug347012TestLanguage.g:1363:2: ( rule__MyField__AttrAssignment_0 )
            // InternalBug347012TestLanguage.g:1363:3: rule__MyField__AttrAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyField__AttrAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getMyFieldAccess().getAttrAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyField__Group__0__Impl"


    // $ANTLR start "rule__MyField__Group__1"
    // InternalBug347012TestLanguage.g:1371:1: rule__MyField__Group__1 : rule__MyField__Group__1__Impl rule__MyField__Group__2 ;
    public final void rule__MyField__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1375:1: ( rule__MyField__Group__1__Impl rule__MyField__Group__2 )
            // InternalBug347012TestLanguage.g:1376:2: rule__MyField__Group__1__Impl rule__MyField__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__MyField__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyField__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyField__Group__1"


    // $ANTLR start "rule__MyField__Group__1__Impl"
    // InternalBug347012TestLanguage.g:1383:1: rule__MyField__Group__1__Impl : ( 'var' ) ;
    public final void rule__MyField__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1387:1: ( ( 'var' ) )
            // InternalBug347012TestLanguage.g:1388:1: ( 'var' )
            {
            // InternalBug347012TestLanguage.g:1388:1: ( 'var' )
            // InternalBug347012TestLanguage.g:1389:2: 'var'
            {
             before(grammarAccess.getMyFieldAccess().getVarKeyword_1()); 
            match(input,20,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMyFieldAccess().getVarKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyField__Group__1__Impl"


    // $ANTLR start "rule__MyField__Group__2"
    // InternalBug347012TestLanguage.g:1398:1: rule__MyField__Group__2 : rule__MyField__Group__2__Impl rule__MyField__Group__3 ;
    public final void rule__MyField__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1402:1: ( rule__MyField__Group__2__Impl rule__MyField__Group__3 )
            // InternalBug347012TestLanguage.g:1403:2: rule__MyField__Group__2__Impl rule__MyField__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__MyField__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyField__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyField__Group__2"


    // $ANTLR start "rule__MyField__Group__2__Impl"
    // InternalBug347012TestLanguage.g:1410:1: rule__MyField__Group__2__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyField__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1414:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:1415:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:1415:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:1416:2: ( RULE_LT )*
            {
             before(grammarAccess.getMyFieldAccess().getLTTerminalRuleCall_2()); 
            // InternalBug347012TestLanguage.g:1417:2: ( RULE_LT )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_LT) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1417:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_4); 

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getMyFieldAccess().getLTTerminalRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyField__Group__2__Impl"


    // $ANTLR start "rule__MyField__Group__3"
    // InternalBug347012TestLanguage.g:1425:1: rule__MyField__Group__3 : rule__MyField__Group__3__Impl rule__MyField__Group__4 ;
    public final void rule__MyField__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1429:1: ( rule__MyField__Group__3__Impl rule__MyField__Group__4 )
            // InternalBug347012TestLanguage.g:1430:2: rule__MyField__Group__3__Impl rule__MyField__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_17);
            rule__MyField__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyField__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyField__Group__3"


    // $ANTLR start "rule__MyField__Group__3__Impl"
    // InternalBug347012TestLanguage.g:1437:1: rule__MyField__Group__3__Impl : ( ( rule__MyField__BindingsAssignment_3 ) ) ;
    public final void rule__MyField__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1441:1: ( ( ( rule__MyField__BindingsAssignment_3 ) ) )
            // InternalBug347012TestLanguage.g:1442:1: ( ( rule__MyField__BindingsAssignment_3 ) )
            {
            // InternalBug347012TestLanguage.g:1442:1: ( ( rule__MyField__BindingsAssignment_3 ) )
            // InternalBug347012TestLanguage.g:1443:2: ( rule__MyField__BindingsAssignment_3 )
            {
             before(grammarAccess.getMyFieldAccess().getBindingsAssignment_3()); 
            // InternalBug347012TestLanguage.g:1444:2: ( rule__MyField__BindingsAssignment_3 )
            // InternalBug347012TestLanguage.g:1444:3: rule__MyField__BindingsAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyField__BindingsAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getMyFieldAccess().getBindingsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyField__Group__3__Impl"


    // $ANTLR start "rule__MyField__Group__4"
    // InternalBug347012TestLanguage.g:1452:1: rule__MyField__Group__4 : rule__MyField__Group__4__Impl rule__MyField__Group__5 ;
    public final void rule__MyField__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1456:1: ( rule__MyField__Group__4__Impl rule__MyField__Group__5 )
            // InternalBug347012TestLanguage.g:1457:2: rule__MyField__Group__4__Impl rule__MyField__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_17);
            rule__MyField__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyField__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyField__Group__4"


    // $ANTLR start "rule__MyField__Group__4__Impl"
    // InternalBug347012TestLanguage.g:1464:1: rule__MyField__Group__4__Impl : ( ( rule__MyField__Group_4__0 )* ) ;
    public final void rule__MyField__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1468:1: ( ( ( rule__MyField__Group_4__0 )* ) )
            // InternalBug347012TestLanguage.g:1469:1: ( ( rule__MyField__Group_4__0 )* )
            {
            // InternalBug347012TestLanguage.g:1469:1: ( ( rule__MyField__Group_4__0 )* )
            // InternalBug347012TestLanguage.g:1470:2: ( rule__MyField__Group_4__0 )*
            {
             before(grammarAccess.getMyFieldAccess().getGroup_4()); 
            // InternalBug347012TestLanguage.g:1471:2: ( rule__MyField__Group_4__0 )*
            loop23:
            do {
                int alt23=2;
                alt23 = dfa23.predict(input);
                switch (alt23) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1471:3: rule__MyField__Group_4__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_18);
            	    rule__MyField__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getMyFieldAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyField__Group__4__Impl"


    // $ANTLR start "rule__MyField__Group__5"
    // InternalBug347012TestLanguage.g:1479:1: rule__MyField__Group__5 : rule__MyField__Group__5__Impl ;
    public final void rule__MyField__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1483:1: ( rule__MyField__Group__5__Impl )
            // InternalBug347012TestLanguage.g:1484:2: rule__MyField__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyField__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyField__Group__5"


    // $ANTLR start "rule__MyField__Group__5__Impl"
    // InternalBug347012TestLanguage.g:1490:1: rule__MyField__Group__5__Impl : ( ruleVirtualSemi ) ;
    public final void rule__MyField__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1494:1: ( ( ruleVirtualSemi ) )
            // InternalBug347012TestLanguage.g:1495:1: ( ruleVirtualSemi )
            {
            // InternalBug347012TestLanguage.g:1495:1: ( ruleVirtualSemi )
            // InternalBug347012TestLanguage.g:1496:2: ruleVirtualSemi
            {
             before(grammarAccess.getMyFieldAccess().getVirtualSemiParserRuleCall_5()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleVirtualSemi();

            state._fsp--;

             after(grammarAccess.getMyFieldAccess().getVirtualSemiParserRuleCall_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyField__Group__5__Impl"


    // $ANTLR start "rule__MyField__Group_4__0"
    // InternalBug347012TestLanguage.g:1506:1: rule__MyField__Group_4__0 : rule__MyField__Group_4__0__Impl rule__MyField__Group_4__1 ;
    public final void rule__MyField__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1510:1: ( rule__MyField__Group_4__0__Impl rule__MyField__Group_4__1 )
            // InternalBug347012TestLanguage.g:1511:2: rule__MyField__Group_4__0__Impl rule__MyField__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_19);
            rule__MyField__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyField__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyField__Group_4__0"


    // $ANTLR start "rule__MyField__Group_4__0__Impl"
    // InternalBug347012TestLanguage.g:1518:1: rule__MyField__Group_4__0__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyField__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1522:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:1523:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:1523:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:1524:2: ( RULE_LT )*
            {
             before(grammarAccess.getMyFieldAccess().getLTTerminalRuleCall_4_0()); 
            // InternalBug347012TestLanguage.g:1525:2: ( RULE_LT )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_LT) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1525:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_4); 

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

             after(grammarAccess.getMyFieldAccess().getLTTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyField__Group_4__0__Impl"


    // $ANTLR start "rule__MyField__Group_4__1"
    // InternalBug347012TestLanguage.g:1533:1: rule__MyField__Group_4__1 : rule__MyField__Group_4__1__Impl rule__MyField__Group_4__2 ;
    public final void rule__MyField__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1537:1: ( rule__MyField__Group_4__1__Impl rule__MyField__Group_4__2 )
            // InternalBug347012TestLanguage.g:1538:2: rule__MyField__Group_4__1__Impl rule__MyField__Group_4__2
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__MyField__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyField__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyField__Group_4__1"


    // $ANTLR start "rule__MyField__Group_4__1__Impl"
    // InternalBug347012TestLanguage.g:1545:1: rule__MyField__Group_4__1__Impl : ( ',' ) ;
    public final void rule__MyField__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1549:1: ( ( ',' ) )
            // InternalBug347012TestLanguage.g:1550:1: ( ',' )
            {
            // InternalBug347012TestLanguage.g:1550:1: ( ',' )
            // InternalBug347012TestLanguage.g:1551:2: ','
            {
             before(grammarAccess.getMyFieldAccess().getCommaKeyword_4_1()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMyFieldAccess().getCommaKeyword_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyField__Group_4__1__Impl"


    // $ANTLR start "rule__MyField__Group_4__2"
    // InternalBug347012TestLanguage.g:1560:1: rule__MyField__Group_4__2 : rule__MyField__Group_4__2__Impl rule__MyField__Group_4__3 ;
    public final void rule__MyField__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1564:1: ( rule__MyField__Group_4__2__Impl rule__MyField__Group_4__3 )
            // InternalBug347012TestLanguage.g:1565:2: rule__MyField__Group_4__2__Impl rule__MyField__Group_4__3
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__MyField__Group_4__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyField__Group_4__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyField__Group_4__2"


    // $ANTLR start "rule__MyField__Group_4__2__Impl"
    // InternalBug347012TestLanguage.g:1572:1: rule__MyField__Group_4__2__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyField__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1576:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:1577:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:1577:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:1578:2: ( RULE_LT )*
            {
             before(grammarAccess.getMyFieldAccess().getLTTerminalRuleCall_4_2()); 
            // InternalBug347012TestLanguage.g:1579:2: ( RULE_LT )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_LT) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1579:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_4); 

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getMyFieldAccess().getLTTerminalRuleCall_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyField__Group_4__2__Impl"


    // $ANTLR start "rule__MyField__Group_4__3"
    // InternalBug347012TestLanguage.g:1587:1: rule__MyField__Group_4__3 : rule__MyField__Group_4__3__Impl ;
    public final void rule__MyField__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1591:1: ( rule__MyField__Group_4__3__Impl )
            // InternalBug347012TestLanguage.g:1592:2: rule__MyField__Group_4__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyField__Group_4__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyField__Group_4__3"


    // $ANTLR start "rule__MyField__Group_4__3__Impl"
    // InternalBug347012TestLanguage.g:1598:1: rule__MyField__Group_4__3__Impl : ( ( rule__MyField__BindingsAssignment_4_3 ) ) ;
    public final void rule__MyField__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1602:1: ( ( ( rule__MyField__BindingsAssignment_4_3 ) ) )
            // InternalBug347012TestLanguage.g:1603:1: ( ( rule__MyField__BindingsAssignment_4_3 ) )
            {
            // InternalBug347012TestLanguage.g:1603:1: ( ( rule__MyField__BindingsAssignment_4_3 ) )
            // InternalBug347012TestLanguage.g:1604:2: ( rule__MyField__BindingsAssignment_4_3 )
            {
             before(grammarAccess.getMyFieldAccess().getBindingsAssignment_4_3()); 
            // InternalBug347012TestLanguage.g:1605:2: ( rule__MyField__BindingsAssignment_4_3 )
            // InternalBug347012TestLanguage.g:1605:3: rule__MyField__BindingsAssignment_4_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyField__BindingsAssignment_4_3();

            state._fsp--;


            }

             after(grammarAccess.getMyFieldAccess().getBindingsAssignment_4_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyField__Group_4__3__Impl"


    // $ANTLR start "rule__MyBinding__Group__0"
    // InternalBug347012TestLanguage.g:1614:1: rule__MyBinding__Group__0 : rule__MyBinding__Group__0__Impl rule__MyBinding__Group__1 ;
    public final void rule__MyBinding__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1618:1: ( rule__MyBinding__Group__0__Impl rule__MyBinding__Group__1 )
            // InternalBug347012TestLanguage.g:1619:2: rule__MyBinding__Group__0__Impl rule__MyBinding__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_20);
            rule__MyBinding__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyBinding__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__Group__0"


    // $ANTLR start "rule__MyBinding__Group__0__Impl"
    // InternalBug347012TestLanguage.g:1626:1: rule__MyBinding__Group__0__Impl : ( ( rule__MyBinding__NameAssignment_0 ) ) ;
    public final void rule__MyBinding__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1630:1: ( ( ( rule__MyBinding__NameAssignment_0 ) ) )
            // InternalBug347012TestLanguage.g:1631:1: ( ( rule__MyBinding__NameAssignment_0 ) )
            {
            // InternalBug347012TestLanguage.g:1631:1: ( ( rule__MyBinding__NameAssignment_0 ) )
            // InternalBug347012TestLanguage.g:1632:2: ( rule__MyBinding__NameAssignment_0 )
            {
             before(grammarAccess.getMyBindingAccess().getNameAssignment_0()); 
            // InternalBug347012TestLanguage.g:1633:2: ( rule__MyBinding__NameAssignment_0 )
            // InternalBug347012TestLanguage.g:1633:3: rule__MyBinding__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyBinding__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getMyBindingAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__Group__0__Impl"


    // $ANTLR start "rule__MyBinding__Group__1"
    // InternalBug347012TestLanguage.g:1641:1: rule__MyBinding__Group__1 : rule__MyBinding__Group__1__Impl rule__MyBinding__Group__2 ;
    public final void rule__MyBinding__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1645:1: ( rule__MyBinding__Group__1__Impl rule__MyBinding__Group__2 )
            // InternalBug347012TestLanguage.g:1646:2: rule__MyBinding__Group__1__Impl rule__MyBinding__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_20);
            rule__MyBinding__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyBinding__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__Group__1"


    // $ANTLR start "rule__MyBinding__Group__1__Impl"
    // InternalBug347012TestLanguage.g:1653:1: rule__MyBinding__Group__1__Impl : ( ( rule__MyBinding__Group_1__0 )? ) ;
    public final void rule__MyBinding__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1657:1: ( ( ( rule__MyBinding__Group_1__0 )? ) )
            // InternalBug347012TestLanguage.g:1658:1: ( ( rule__MyBinding__Group_1__0 )? )
            {
            // InternalBug347012TestLanguage.g:1658:1: ( ( rule__MyBinding__Group_1__0 )? )
            // InternalBug347012TestLanguage.g:1659:2: ( rule__MyBinding__Group_1__0 )?
            {
             before(grammarAccess.getMyBindingAccess().getGroup_1()); 
            // InternalBug347012TestLanguage.g:1660:2: ( rule__MyBinding__Group_1__0 )?
            int alt26=2;
            alt26 = dfa26.predict(input);
            switch (alt26) {
                case 1 :
                    // InternalBug347012TestLanguage.g:1660:3: rule__MyBinding__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__MyBinding__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMyBindingAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__Group__1__Impl"


    // $ANTLR start "rule__MyBinding__Group__2"
    // InternalBug347012TestLanguage.g:1668:1: rule__MyBinding__Group__2 : rule__MyBinding__Group__2__Impl ;
    public final void rule__MyBinding__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1672:1: ( rule__MyBinding__Group__2__Impl )
            // InternalBug347012TestLanguage.g:1673:2: rule__MyBinding__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyBinding__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__Group__2"


    // $ANTLR start "rule__MyBinding__Group__2__Impl"
    // InternalBug347012TestLanguage.g:1679:1: rule__MyBinding__Group__2__Impl : ( ( rule__MyBinding__Group_2__0 )? ) ;
    public final void rule__MyBinding__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1683:1: ( ( ( rule__MyBinding__Group_2__0 )? ) )
            // InternalBug347012TestLanguage.g:1684:1: ( ( rule__MyBinding__Group_2__0 )? )
            {
            // InternalBug347012TestLanguage.g:1684:1: ( ( rule__MyBinding__Group_2__0 )? )
            // InternalBug347012TestLanguage.g:1685:2: ( rule__MyBinding__Group_2__0 )?
            {
             before(grammarAccess.getMyBindingAccess().getGroup_2()); 
            // InternalBug347012TestLanguage.g:1686:2: ( rule__MyBinding__Group_2__0 )?
            int alt27=2;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // InternalBug347012TestLanguage.g:1686:3: rule__MyBinding__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__MyBinding__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMyBindingAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__Group__2__Impl"


    // $ANTLR start "rule__MyBinding__Group_1__0"
    // InternalBug347012TestLanguage.g:1695:1: rule__MyBinding__Group_1__0 : rule__MyBinding__Group_1__0__Impl rule__MyBinding__Group_1__1 ;
    public final void rule__MyBinding__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1699:1: ( rule__MyBinding__Group_1__0__Impl rule__MyBinding__Group_1__1 )
            // InternalBug347012TestLanguage.g:1700:2: rule__MyBinding__Group_1__0__Impl rule__MyBinding__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_21);
            rule__MyBinding__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyBinding__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__Group_1__0"


    // $ANTLR start "rule__MyBinding__Group_1__0__Impl"
    // InternalBug347012TestLanguage.g:1707:1: rule__MyBinding__Group_1__0__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyBinding__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1711:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:1712:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:1712:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:1713:2: ( RULE_LT )*
            {
             before(grammarAccess.getMyBindingAccess().getLTTerminalRuleCall_1_0()); 
            // InternalBug347012TestLanguage.g:1714:2: ( RULE_LT )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_LT) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1714:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_4); 

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

             after(grammarAccess.getMyBindingAccess().getLTTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__Group_1__0__Impl"


    // $ANTLR start "rule__MyBinding__Group_1__1"
    // InternalBug347012TestLanguage.g:1722:1: rule__MyBinding__Group_1__1 : rule__MyBinding__Group_1__1__Impl rule__MyBinding__Group_1__2 ;
    public final void rule__MyBinding__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1726:1: ( rule__MyBinding__Group_1__1__Impl rule__MyBinding__Group_1__2 )
            // InternalBug347012TestLanguage.g:1727:2: rule__MyBinding__Group_1__1__Impl rule__MyBinding__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__MyBinding__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyBinding__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__Group_1__1"


    // $ANTLR start "rule__MyBinding__Group_1__1__Impl"
    // InternalBug347012TestLanguage.g:1734:1: rule__MyBinding__Group_1__1__Impl : ( ':' ) ;
    public final void rule__MyBinding__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1738:1: ( ( ':' ) )
            // InternalBug347012TestLanguage.g:1739:1: ( ':' )
            {
            // InternalBug347012TestLanguage.g:1739:1: ( ':' )
            // InternalBug347012TestLanguage.g:1740:2: ':'
            {
             before(grammarAccess.getMyBindingAccess().getColonKeyword_1_1()); 
            match(input,22,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMyBindingAccess().getColonKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__Group_1__1__Impl"


    // $ANTLR start "rule__MyBinding__Group_1__2"
    // InternalBug347012TestLanguage.g:1749:1: rule__MyBinding__Group_1__2 : rule__MyBinding__Group_1__2__Impl rule__MyBinding__Group_1__3 ;
    public final void rule__MyBinding__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1753:1: ( rule__MyBinding__Group_1__2__Impl rule__MyBinding__Group_1__3 )
            // InternalBug347012TestLanguage.g:1754:2: rule__MyBinding__Group_1__2__Impl rule__MyBinding__Group_1__3
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__MyBinding__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyBinding__Group_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__Group_1__2"


    // $ANTLR start "rule__MyBinding__Group_1__2__Impl"
    // InternalBug347012TestLanguage.g:1761:1: rule__MyBinding__Group_1__2__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyBinding__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1765:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:1766:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:1766:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:1767:2: ( RULE_LT )*
            {
             before(grammarAccess.getMyBindingAccess().getLTTerminalRuleCall_1_2()); 
            // InternalBug347012TestLanguage.g:1768:2: ( RULE_LT )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==RULE_LT) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1768:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_4); 

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

             after(grammarAccess.getMyBindingAccess().getLTTerminalRuleCall_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__Group_1__2__Impl"


    // $ANTLR start "rule__MyBinding__Group_1__3"
    // InternalBug347012TestLanguage.g:1776:1: rule__MyBinding__Group_1__3 : rule__MyBinding__Group_1__3__Impl ;
    public final void rule__MyBinding__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1780:1: ( rule__MyBinding__Group_1__3__Impl )
            // InternalBug347012TestLanguage.g:1781:2: rule__MyBinding__Group_1__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyBinding__Group_1__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__Group_1__3"


    // $ANTLR start "rule__MyBinding__Group_1__3__Impl"
    // InternalBug347012TestLanguage.g:1787:1: rule__MyBinding__Group_1__3__Impl : ( ( rule__MyBinding__TypeAssignment_1_3 ) ) ;
    public final void rule__MyBinding__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1791:1: ( ( ( rule__MyBinding__TypeAssignment_1_3 ) ) )
            // InternalBug347012TestLanguage.g:1792:1: ( ( rule__MyBinding__TypeAssignment_1_3 ) )
            {
            // InternalBug347012TestLanguage.g:1792:1: ( ( rule__MyBinding__TypeAssignment_1_3 ) )
            // InternalBug347012TestLanguage.g:1793:2: ( rule__MyBinding__TypeAssignment_1_3 )
            {
             before(grammarAccess.getMyBindingAccess().getTypeAssignment_1_3()); 
            // InternalBug347012TestLanguage.g:1794:2: ( rule__MyBinding__TypeAssignment_1_3 )
            // InternalBug347012TestLanguage.g:1794:3: rule__MyBinding__TypeAssignment_1_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyBinding__TypeAssignment_1_3();

            state._fsp--;


            }

             after(grammarAccess.getMyBindingAccess().getTypeAssignment_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__Group_1__3__Impl"


    // $ANTLR start "rule__MyBinding__Group_2__0"
    // InternalBug347012TestLanguage.g:1803:1: rule__MyBinding__Group_2__0 : rule__MyBinding__Group_2__0__Impl rule__MyBinding__Group_2__1 ;
    public final void rule__MyBinding__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1807:1: ( rule__MyBinding__Group_2__0__Impl rule__MyBinding__Group_2__1 )
            // InternalBug347012TestLanguage.g:1808:2: rule__MyBinding__Group_2__0__Impl rule__MyBinding__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_22);
            rule__MyBinding__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyBinding__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__Group_2__0"


    // $ANTLR start "rule__MyBinding__Group_2__0__Impl"
    // InternalBug347012TestLanguage.g:1815:1: rule__MyBinding__Group_2__0__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyBinding__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1819:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:1820:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:1820:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:1821:2: ( RULE_LT )*
            {
             before(grammarAccess.getMyBindingAccess().getLTTerminalRuleCall_2_0()); 
            // InternalBug347012TestLanguage.g:1822:2: ( RULE_LT )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_LT) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1822:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_4); 

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

             after(grammarAccess.getMyBindingAccess().getLTTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__Group_2__0__Impl"


    // $ANTLR start "rule__MyBinding__Group_2__1"
    // InternalBug347012TestLanguage.g:1830:1: rule__MyBinding__Group_2__1 : rule__MyBinding__Group_2__1__Impl rule__MyBinding__Group_2__2 ;
    public final void rule__MyBinding__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1834:1: ( rule__MyBinding__Group_2__1__Impl rule__MyBinding__Group_2__2 )
            // InternalBug347012TestLanguage.g:1835:2: rule__MyBinding__Group_2__1__Impl rule__MyBinding__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_23);
            rule__MyBinding__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyBinding__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__Group_2__1"


    // $ANTLR start "rule__MyBinding__Group_2__1__Impl"
    // InternalBug347012TestLanguage.g:1842:1: rule__MyBinding__Group_2__1__Impl : ( '=' ) ;
    public final void rule__MyBinding__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1846:1: ( ( '=' ) )
            // InternalBug347012TestLanguage.g:1847:1: ( '=' )
            {
            // InternalBug347012TestLanguage.g:1847:1: ( '=' )
            // InternalBug347012TestLanguage.g:1848:2: '='
            {
             before(grammarAccess.getMyBindingAccess().getEqualsSignKeyword_2_1()); 
            match(input,23,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMyBindingAccess().getEqualsSignKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__Group_2__1__Impl"


    // $ANTLR start "rule__MyBinding__Group_2__2"
    // InternalBug347012TestLanguage.g:1857:1: rule__MyBinding__Group_2__2 : rule__MyBinding__Group_2__2__Impl rule__MyBinding__Group_2__3 ;
    public final void rule__MyBinding__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1861:1: ( rule__MyBinding__Group_2__2__Impl rule__MyBinding__Group_2__3 )
            // InternalBug347012TestLanguage.g:1862:2: rule__MyBinding__Group_2__2__Impl rule__MyBinding__Group_2__3
            {
            pushFollow(FollowSets000.FOLLOW_23);
            rule__MyBinding__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyBinding__Group_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__Group_2__2"


    // $ANTLR start "rule__MyBinding__Group_2__2__Impl"
    // InternalBug347012TestLanguage.g:1869:1: rule__MyBinding__Group_2__2__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyBinding__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1873:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:1874:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:1874:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:1875:2: ( RULE_LT )*
            {
             before(grammarAccess.getMyBindingAccess().getLTTerminalRuleCall_2_2()); 
            // InternalBug347012TestLanguage.g:1876:2: ( RULE_LT )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==RULE_LT) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1876:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_4); 

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

             after(grammarAccess.getMyBindingAccess().getLTTerminalRuleCall_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__Group_2__2__Impl"


    // $ANTLR start "rule__MyBinding__Group_2__3"
    // InternalBug347012TestLanguage.g:1884:1: rule__MyBinding__Group_2__3 : rule__MyBinding__Group_2__3__Impl ;
    public final void rule__MyBinding__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1888:1: ( rule__MyBinding__Group_2__3__Impl )
            // InternalBug347012TestLanguage.g:1889:2: rule__MyBinding__Group_2__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyBinding__Group_2__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__Group_2__3"


    // $ANTLR start "rule__MyBinding__Group_2__3__Impl"
    // InternalBug347012TestLanguage.g:1895:1: rule__MyBinding__Group_2__3__Impl : ( ( rule__MyBinding__ExpressionAssignment_2_3 ) ) ;
    public final void rule__MyBinding__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1899:1: ( ( ( rule__MyBinding__ExpressionAssignment_2_3 ) ) )
            // InternalBug347012TestLanguage.g:1900:1: ( ( rule__MyBinding__ExpressionAssignment_2_3 ) )
            {
            // InternalBug347012TestLanguage.g:1900:1: ( ( rule__MyBinding__ExpressionAssignment_2_3 ) )
            // InternalBug347012TestLanguage.g:1901:2: ( rule__MyBinding__ExpressionAssignment_2_3 )
            {
             before(grammarAccess.getMyBindingAccess().getExpressionAssignment_2_3()); 
            // InternalBug347012TestLanguage.g:1902:2: ( rule__MyBinding__ExpressionAssignment_2_3 )
            // InternalBug347012TestLanguage.g:1902:3: rule__MyBinding__ExpressionAssignment_2_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyBinding__ExpressionAssignment_2_3();

            state._fsp--;


            }

             after(grammarAccess.getMyBindingAccess().getExpressionAssignment_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__Group_2__3__Impl"


    // $ANTLR start "rule__MyProgram__PackageAssignment_2"
    // InternalBug347012TestLanguage.g:1911:1: rule__MyProgram__PackageAssignment_2 : ( ruleMyPackage ) ;
    public final void rule__MyProgram__PackageAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1915:1: ( ( ruleMyPackage ) )
            // InternalBug347012TestLanguage.g:1916:2: ( ruleMyPackage )
            {
            // InternalBug347012TestLanguage.g:1916:2: ( ruleMyPackage )
            // InternalBug347012TestLanguage.g:1917:3: ruleMyPackage
            {
             before(grammarAccess.getMyProgramAccess().getPackageMyPackageParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleMyPackage();

            state._fsp--;

             after(grammarAccess.getMyProgramAccess().getPackageMyPackageParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyProgram__PackageAssignment_2"


    // $ANTLR start "rule__Identifier__NameAssignment"
    // InternalBug347012TestLanguage.g:1926:1: rule__Identifier__NameAssignment : ( RULE_ID ) ;
    public final void rule__Identifier__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1930:1: ( ( RULE_ID ) )
            // InternalBug347012TestLanguage.g:1931:2: ( RULE_ID )
            {
            // InternalBug347012TestLanguage.g:1931:2: ( RULE_ID )
            // InternalBug347012TestLanguage.g:1932:3: RULE_ID
            {
             before(grammarAccess.getIdentifierAccess().getNameIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getIdentifierAccess().getNameIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Identifier__NameAssignment"


    // $ANTLR start "rule__Literal__NumAssignment_0"
    // InternalBug347012TestLanguage.g:1941:1: rule__Literal__NumAssignment_0 : ( RULE_NUMBER ) ;
    public final void rule__Literal__NumAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1945:1: ( ( RULE_NUMBER ) )
            // InternalBug347012TestLanguage.g:1946:2: ( RULE_NUMBER )
            {
            // InternalBug347012TestLanguage.g:1946:2: ( RULE_NUMBER )
            // InternalBug347012TestLanguage.g:1947:3: RULE_NUMBER
            {
             before(grammarAccess.getLiteralAccess().getNumNUMBERTerminalRuleCall_0_0()); 
            match(input,RULE_NUMBER,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getLiteralAccess().getNumNUMBERTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__NumAssignment_0"


    // $ANTLR start "rule__Literal__StrAssignment_1"
    // InternalBug347012TestLanguage.g:1956:1: rule__Literal__StrAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Literal__StrAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1960:1: ( ( RULE_STRING ) )
            // InternalBug347012TestLanguage.g:1961:2: ( RULE_STRING )
            {
            // InternalBug347012TestLanguage.g:1961:2: ( RULE_STRING )
            // InternalBug347012TestLanguage.g:1962:3: RULE_STRING
            {
             before(grammarAccess.getLiteralAccess().getStrSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getLiteralAccess().getStrSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__StrAssignment_1"


    // $ANTLR start "rule__Literal__BoolAssignment_2"
    // InternalBug347012TestLanguage.g:1971:1: rule__Literal__BoolAssignment_2 : ( ( 'true' ) ) ;
    public final void rule__Literal__BoolAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1975:1: ( ( ( 'true' ) ) )
            // InternalBug347012TestLanguage.g:1976:2: ( ( 'true' ) )
            {
            // InternalBug347012TestLanguage.g:1976:2: ( ( 'true' ) )
            // InternalBug347012TestLanguage.g:1977:3: ( 'true' )
            {
             before(grammarAccess.getLiteralAccess().getBoolTrueKeyword_2_0()); 
            // InternalBug347012TestLanguage.g:1978:3: ( 'true' )
            // InternalBug347012TestLanguage.g:1979:4: 'true'
            {
             before(grammarAccess.getLiteralAccess().getBoolTrueKeyword_2_0()); 
            match(input,24,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getLiteralAccess().getBoolTrueKeyword_2_0()); 

            }

             after(grammarAccess.getLiteralAccess().getBoolTrueKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__BoolAssignment_2"


    // $ANTLR start "rule__Literal__BoolAssignment_3"
    // InternalBug347012TestLanguage.g:1990:1: rule__Literal__BoolAssignment_3 : ( ( 'false' ) ) ;
    public final void rule__Literal__BoolAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1994:1: ( ( ( 'false' ) ) )
            // InternalBug347012TestLanguage.g:1995:2: ( ( 'false' ) )
            {
            // InternalBug347012TestLanguage.g:1995:2: ( ( 'false' ) )
            // InternalBug347012TestLanguage.g:1996:3: ( 'false' )
            {
             before(grammarAccess.getLiteralAccess().getBoolFalseKeyword_3_0()); 
            // InternalBug347012TestLanguage.g:1997:3: ( 'false' )
            // InternalBug347012TestLanguage.g:1998:4: 'false'
            {
             before(grammarAccess.getLiteralAccess().getBoolFalseKeyword_3_0()); 
            match(input,25,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getLiteralAccess().getBoolFalseKeyword_3_0()); 

            }

             after(grammarAccess.getLiteralAccess().getBoolFalseKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__BoolAssignment_3"


    // $ANTLR start "rule__MyPackage__NameAssignment_2"
    // InternalBug347012TestLanguage.g:2009:1: rule__MyPackage__NameAssignment_2 : ( ruleFQN ) ;
    public final void rule__MyPackage__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:2013:1: ( ( ruleFQN ) )
            // InternalBug347012TestLanguage.g:2014:2: ( ruleFQN )
            {
            // InternalBug347012TestLanguage.g:2014:2: ( ruleFQN )
            // InternalBug347012TestLanguage.g:2015:3: ruleFQN
            {
             before(grammarAccess.getMyPackageAccess().getNameFQNParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getMyPackageAccess().getNameFQNParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyPackage__NameAssignment_2"


    // $ANTLR start "rule__MyPackage__DirectivesAssignment_6_0"
    // InternalBug347012TestLanguage.g:2024:1: rule__MyPackage__DirectivesAssignment_6_0 : ( ruleMyClass ) ;
    public final void rule__MyPackage__DirectivesAssignment_6_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:2028:1: ( ( ruleMyClass ) )
            // InternalBug347012TestLanguage.g:2029:2: ( ruleMyClass )
            {
            // InternalBug347012TestLanguage.g:2029:2: ( ruleMyClass )
            // InternalBug347012TestLanguage.g:2030:3: ruleMyClass
            {
             before(grammarAccess.getMyPackageAccess().getDirectivesMyClassParserRuleCall_6_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleMyClass();

            state._fsp--;

             after(grammarAccess.getMyPackageAccess().getDirectivesMyClassParserRuleCall_6_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyPackage__DirectivesAssignment_6_0"


    // $ANTLR start "rule__MyClass__NameAssignment_3"
    // InternalBug347012TestLanguage.g:2039:1: rule__MyClass__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__MyClass__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:2043:1: ( ( RULE_ID ) )
            // InternalBug347012TestLanguage.g:2044:2: ( RULE_ID )
            {
            // InternalBug347012TestLanguage.g:2044:2: ( RULE_ID )
            // InternalBug347012TestLanguage.g:2045:3: RULE_ID
            {
             before(grammarAccess.getMyClassAccess().getNameIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMyClassAccess().getNameIDTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyClass__NameAssignment_3"


    // $ANTLR start "rule__MyClass__DirectivesAssignment_7_0"
    // InternalBug347012TestLanguage.g:2054:1: rule__MyClass__DirectivesAssignment_7_0 : ( ruleMyField ) ;
    public final void rule__MyClass__DirectivesAssignment_7_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:2058:1: ( ( ruleMyField ) )
            // InternalBug347012TestLanguage.g:2059:2: ( ruleMyField )
            {
            // InternalBug347012TestLanguage.g:2059:2: ( ruleMyField )
            // InternalBug347012TestLanguage.g:2060:3: ruleMyField
            {
             before(grammarAccess.getMyClassAccess().getDirectivesMyFieldParserRuleCall_7_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleMyField();

            state._fsp--;

             after(grammarAccess.getMyClassAccess().getDirectivesMyFieldParserRuleCall_7_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyClass__DirectivesAssignment_7_0"


    // $ANTLR start "rule__MyAttribute__PUBLICAssignment_0"
    // InternalBug347012TestLanguage.g:2069:1: rule__MyAttribute__PUBLICAssignment_0 : ( ( 'public' ) ) ;
    public final void rule__MyAttribute__PUBLICAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:2073:1: ( ( ( 'public' ) ) )
            // InternalBug347012TestLanguage.g:2074:2: ( ( 'public' ) )
            {
            // InternalBug347012TestLanguage.g:2074:2: ( ( 'public' ) )
            // InternalBug347012TestLanguage.g:2075:3: ( 'public' )
            {
             before(grammarAccess.getMyAttributeAccess().getPUBLICPublicKeyword_0_0()); 
            // InternalBug347012TestLanguage.g:2076:3: ( 'public' )
            // InternalBug347012TestLanguage.g:2077:4: 'public'
            {
             before(grammarAccess.getMyAttributeAccess().getPUBLICPublicKeyword_0_0()); 
            match(input,18,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMyAttributeAccess().getPUBLICPublicKeyword_0_0()); 

            }

             after(grammarAccess.getMyAttributeAccess().getPUBLICPublicKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyAttribute__PUBLICAssignment_0"


    // $ANTLR start "rule__MyAttribute__PRIVATEAssignment_1"
    // InternalBug347012TestLanguage.g:2088:1: rule__MyAttribute__PRIVATEAssignment_1 : ( ( 'private' ) ) ;
    public final void rule__MyAttribute__PRIVATEAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:2092:1: ( ( ( 'private' ) ) )
            // InternalBug347012TestLanguage.g:2093:2: ( ( 'private' ) )
            {
            // InternalBug347012TestLanguage.g:2093:2: ( ( 'private' ) )
            // InternalBug347012TestLanguage.g:2094:3: ( 'private' )
            {
             before(grammarAccess.getMyAttributeAccess().getPRIVATEPrivateKeyword_1_0()); 
            // InternalBug347012TestLanguage.g:2095:3: ( 'private' )
            // InternalBug347012TestLanguage.g:2096:4: 'private'
            {
             before(grammarAccess.getMyAttributeAccess().getPRIVATEPrivateKeyword_1_0()); 
            match(input,26,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMyAttributeAccess().getPRIVATEPrivateKeyword_1_0()); 

            }

             after(grammarAccess.getMyAttributeAccess().getPRIVATEPrivateKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyAttribute__PRIVATEAssignment_1"


    // $ANTLR start "rule__MyAttributes__AttributesAssignment_1"
    // InternalBug347012TestLanguage.g:2107:1: rule__MyAttributes__AttributesAssignment_1 : ( ruleMyAttribute ) ;
    public final void rule__MyAttributes__AttributesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:2111:1: ( ( ruleMyAttribute ) )
            // InternalBug347012TestLanguage.g:2112:2: ( ruleMyAttribute )
            {
            // InternalBug347012TestLanguage.g:2112:2: ( ruleMyAttribute )
            // InternalBug347012TestLanguage.g:2113:3: ruleMyAttribute
            {
             before(grammarAccess.getMyAttributesAccess().getAttributesMyAttributeParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleMyAttribute();

            state._fsp--;

             after(grammarAccess.getMyAttributesAccess().getAttributesMyAttributeParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyAttributes__AttributesAssignment_1"


    // $ANTLR start "rule__MyField__AttrAssignment_0"
    // InternalBug347012TestLanguage.g:2122:1: rule__MyField__AttrAssignment_0 : ( ruleMyAttributes ) ;
    public final void rule__MyField__AttrAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:2126:1: ( ( ruleMyAttributes ) )
            // InternalBug347012TestLanguage.g:2127:2: ( ruleMyAttributes )
            {
            // InternalBug347012TestLanguage.g:2127:2: ( ruleMyAttributes )
            // InternalBug347012TestLanguage.g:2128:3: ruleMyAttributes
            {
             before(grammarAccess.getMyFieldAccess().getAttrMyAttributesParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleMyAttributes();

            state._fsp--;

             after(grammarAccess.getMyFieldAccess().getAttrMyAttributesParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyField__AttrAssignment_0"


    // $ANTLR start "rule__MyField__BindingsAssignment_3"
    // InternalBug347012TestLanguage.g:2137:1: rule__MyField__BindingsAssignment_3 : ( ruleMyBinding ) ;
    public final void rule__MyField__BindingsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:2141:1: ( ( ruleMyBinding ) )
            // InternalBug347012TestLanguage.g:2142:2: ( ruleMyBinding )
            {
            // InternalBug347012TestLanguage.g:2142:2: ( ruleMyBinding )
            // InternalBug347012TestLanguage.g:2143:3: ruleMyBinding
            {
             before(grammarAccess.getMyFieldAccess().getBindingsMyBindingParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleMyBinding();

            state._fsp--;

             after(grammarAccess.getMyFieldAccess().getBindingsMyBindingParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyField__BindingsAssignment_3"


    // $ANTLR start "rule__MyField__BindingsAssignment_4_3"
    // InternalBug347012TestLanguage.g:2152:1: rule__MyField__BindingsAssignment_4_3 : ( ruleMyBinding ) ;
    public final void rule__MyField__BindingsAssignment_4_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:2156:1: ( ( ruleMyBinding ) )
            // InternalBug347012TestLanguage.g:2157:2: ( ruleMyBinding )
            {
            // InternalBug347012TestLanguage.g:2157:2: ( ruleMyBinding )
            // InternalBug347012TestLanguage.g:2158:3: ruleMyBinding
            {
             before(grammarAccess.getMyFieldAccess().getBindingsMyBindingParserRuleCall_4_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleMyBinding();

            state._fsp--;

             after(grammarAccess.getMyFieldAccess().getBindingsMyBindingParserRuleCall_4_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyField__BindingsAssignment_4_3"


    // $ANTLR start "rule__MyBinding__NameAssignment_0"
    // InternalBug347012TestLanguage.g:2167:1: rule__MyBinding__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__MyBinding__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:2171:1: ( ( RULE_ID ) )
            // InternalBug347012TestLanguage.g:2172:2: ( RULE_ID )
            {
            // InternalBug347012TestLanguage.g:2172:2: ( RULE_ID )
            // InternalBug347012TestLanguage.g:2173:3: RULE_ID
            {
             before(grammarAccess.getMyBindingAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMyBindingAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__NameAssignment_0"


    // $ANTLR start "rule__MyBinding__TypeAssignment_1_3"
    // InternalBug347012TestLanguage.g:2182:1: rule__MyBinding__TypeAssignment_1_3 : ( ruleFQN ) ;
    public final void rule__MyBinding__TypeAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:2186:1: ( ( ruleFQN ) )
            // InternalBug347012TestLanguage.g:2187:2: ( ruleFQN )
            {
            // InternalBug347012TestLanguage.g:2187:2: ( ruleFQN )
            // InternalBug347012TestLanguage.g:2188:3: ruleFQN
            {
             before(grammarAccess.getMyBindingAccess().getTypeFQNParserRuleCall_1_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getMyBindingAccess().getTypeFQNParserRuleCall_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__TypeAssignment_1_3"


    // $ANTLR start "rule__MyBinding__ExpressionAssignment_2_3"
    // InternalBug347012TestLanguage.g:2197:1: rule__MyBinding__ExpressionAssignment_2_3 : ( ruleMyPrimary ) ;
    public final void rule__MyBinding__ExpressionAssignment_2_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:2201:1: ( ( ruleMyPrimary ) )
            // InternalBug347012TestLanguage.g:2202:2: ( ruleMyPrimary )
            {
            // InternalBug347012TestLanguage.g:2202:2: ( ruleMyPrimary )
            // InternalBug347012TestLanguage.g:2203:3: ruleMyPrimary
            {
             before(grammarAccess.getMyBindingAccess().getExpressionMyPrimaryParserRuleCall_2_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleMyPrimary();

            state._fsp--;

             after(grammarAccess.getMyBindingAccess().getExpressionMyPrimaryParserRuleCall_2_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__ExpressionAssignment_2_3"

    // Delegated rules


    protected DFA7 dfa7 = new DFA7(this);
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA26 dfa26 = new DFA26(this);
    protected DFA27 dfa27 = new DFA27(this);
    static final String dfa_1s = "\5\uffff";
    static final String dfa_2s = "\1\1\1\uffff\1\1\2\uffff";
    static final String dfa_3s = "\1\4\1\uffff\1\4\1\uffff\1\4";
    static final String dfa_4s = "\1\27\1\uffff\1\32\1\uffff\1\32";
    static final String dfa_5s = "\1\uffff\1\2\1\uffff\1\1\1\uffff";
    static final String dfa_6s = "\5\uffff}>";
    static final String[] dfa_7s = {
            "\1\2\10\uffff\1\1\1\3\1\uffff\1\1\4\uffff\1\1\1\uffff\1\1",
            "",
            "\1\4\11\uffff\1\3\1\uffff\3\1\1\uffff\2\1\1\uffff\1\1\2\uffff\1\1",
            "",
            "\1\4\11\uffff\1\3\1\uffff\3\1\1\uffff\2\1\1\uffff\1\1\2\uffff\1\1"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 606:2: ( rule__FQN__Group_1__0 )*";
        }
    }
    static final String dfa_8s = "\2\uffff\1\1\2\uffff";
    static final String dfa_9s = "\1\25\1\uffff\1\32\1\uffff\1\32";
    static final String[] dfa_10s = {
            "\1\2\10\uffff\1\1\7\uffff\1\3",
            "",
            "\1\4\14\uffff\2\1\1\uffff\1\1\1\3\4\uffff\1\1",
            "",
            "\1\4\14\uffff\2\1\1\uffff\1\1\1\3\4\uffff\1\1"
    };
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[][] dfa_10 = unpackEncodedStringArray(dfa_10s);

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = dfa_1;
            this.eof = dfa_8;
            this.min = dfa_3;
            this.max = dfa_9;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_10;
        }
        public String getDescription() {
            return "()* loopback of 1471:2: ( rule__MyField__Group_4__0 )*";
        }
    }
    static final String dfa_11s = "\2\3\3\uffff";
    static final String dfa_12s = "\2\4\2\uffff\1\4";
    static final String dfa_13s = "\1\27\1\32\2\uffff\1\32";
    static final String dfa_14s = "\2\uffff\1\1\1\2\1\uffff";
    static final String[] dfa_15s = {
            "\1\1\10\uffff\1\3\7\uffff\1\3\1\2\1\3",
            "\1\4\14\uffff\2\3\1\uffff\2\3\1\2\1\3\2\uffff\1\3",
            "",
            "",
            "\1\4\14\uffff\2\3\1\uffff\2\3\1\2\1\3\2\uffff\1\3"
    };
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final char[] dfa_12 = DFA.unpackEncodedStringToUnsignedChars(dfa_12s);
    static final char[] dfa_13 = DFA.unpackEncodedStringToUnsignedChars(dfa_13s);
    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final short[][] dfa_15 = unpackEncodedStringArray(dfa_15s);

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = dfa_1;
            this.eof = dfa_11;
            this.min = dfa_12;
            this.max = dfa_13;
            this.accept = dfa_14;
            this.special = dfa_6;
            this.transition = dfa_15;
        }
        public String getDescription() {
            return "1660:2: ( rule__MyBinding__Group_1__0 )?";
        }
    }
    static final String[] dfa_16s = {
            "\1\1\10\uffff\1\3\7\uffff\1\3\1\uffff\1\2",
            "\1\4\14\uffff\2\3\1\uffff\2\3\1\uffff\1\2\2\uffff\1\3",
            "",
            "",
            "\1\4\14\uffff\2\3\1\uffff\2\3\1\uffff\1\2\2\uffff\1\3"
    };
    static final short[][] dfa_16 = unpackEncodedStringArray(dfa_16s);

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = dfa_1;
            this.eof = dfa_11;
            this.min = dfa_12;
            this.max = dfa_13;
            this.accept = dfa_14;
            this.special = dfa_6;
            this.transition = dfa_16;
        }
        public String getDescription() {
            return "1686:2: ( rule__MyBinding__Group_2__0 )?";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000008010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004012L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000000000E0010L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00000000000C0002L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00000000000C0000L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000004060010L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000004040002L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000004040000L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000202010L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000200012L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000C00010L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000400010L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000800010L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x00000000030000F0L});
    }


}
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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug360834TestLanguageGrammarAccess;



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
public class InternalBug360834TestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'public'", "'protected'", "'private'", "'alternative'", "'unordered'", "'package'", "';'", "'.'", "'class'", "'{'", "'}'", "'var'", "'final'", "'abstract'", "'extern'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalBug360834TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug360834TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug360834TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug360834TestLanguage.g"; }


    	private Bug360834TestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(Bug360834TestLanguageGrammarAccess grammarAccess) {
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
    // InternalBug360834TestLanguage.g:58:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalBug360834TestLanguage.g:59:1: ( ruleModel EOF )
            // InternalBug360834TestLanguage.g:60:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalBug360834TestLanguage.g:67:1: ruleModel : ( ( rule__Model__Alternatives ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:71:2: ( ( ( rule__Model__Alternatives ) ) )
            // InternalBug360834TestLanguage.g:72:2: ( ( rule__Model__Alternatives ) )
            {
            // InternalBug360834TestLanguage.g:72:2: ( ( rule__Model__Alternatives ) )
            // InternalBug360834TestLanguage.g:73:3: ( rule__Model__Alternatives )
            {
             before(grammarAccess.getModelAccess().getAlternatives()); 
            // InternalBug360834TestLanguage.g:74:3: ( rule__Model__Alternatives )
            // InternalBug360834TestLanguage.g:74:4: rule__Model__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getAlternatives()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleAlternative"
    // InternalBug360834TestLanguage.g:83:1: entryRuleAlternative : ruleAlternative EOF ;
    public final void entryRuleAlternative() throws RecognitionException {
        try {
            // InternalBug360834TestLanguage.g:84:1: ( ruleAlternative EOF )
            // InternalBug360834TestLanguage.g:85:1: ruleAlternative EOF
            {
             before(grammarAccess.getAlternativeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAlternative();

            state._fsp--;

             after(grammarAccess.getAlternativeRule()); 
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
    // $ANTLR end "entryRuleAlternative"


    // $ANTLR start "ruleAlternative"
    // InternalBug360834TestLanguage.g:92:1: ruleAlternative : ( ( rule__Alternative__Group__0 ) ) ;
    public final void ruleAlternative() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:96:2: ( ( ( rule__Alternative__Group__0 ) ) )
            // InternalBug360834TestLanguage.g:97:2: ( ( rule__Alternative__Group__0 ) )
            {
            // InternalBug360834TestLanguage.g:97:2: ( ( rule__Alternative__Group__0 ) )
            // InternalBug360834TestLanguage.g:98:3: ( rule__Alternative__Group__0 )
            {
             before(grammarAccess.getAlternativeAccess().getGroup()); 
            // InternalBug360834TestLanguage.g:99:3: ( rule__Alternative__Group__0 )
            // InternalBug360834TestLanguage.g:99:4: rule__Alternative__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Alternative__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAlternativeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAlternative"


    // $ANTLR start "entryRuleFQN"
    // InternalBug360834TestLanguage.g:108:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // InternalBug360834TestLanguage.g:109:1: ( ruleFQN EOF )
            // InternalBug360834TestLanguage.g:110:1: ruleFQN EOF
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
    // InternalBug360834TestLanguage.g:117:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:121:2: ( ( ( rule__FQN__Group__0 ) ) )
            // InternalBug360834TestLanguage.g:122:2: ( ( rule__FQN__Group__0 ) )
            {
            // InternalBug360834TestLanguage.g:122:2: ( ( rule__FQN__Group__0 ) )
            // InternalBug360834TestLanguage.g:123:3: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // InternalBug360834TestLanguage.g:124:3: ( rule__FQN__Group__0 )
            // InternalBug360834TestLanguage.g:124:4: rule__FQN__Group__0
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


    // $ANTLR start "entryRuleRecursiveClassDeclaration"
    // InternalBug360834TestLanguage.g:133:1: entryRuleRecursiveClassDeclaration : ruleRecursiveClassDeclaration EOF ;
    public final void entryRuleRecursiveClassDeclaration() throws RecognitionException {
        try {
            // InternalBug360834TestLanguage.g:134:1: ( ruleRecursiveClassDeclaration EOF )
            // InternalBug360834TestLanguage.g:135:1: ruleRecursiveClassDeclaration EOF
            {
             before(grammarAccess.getRecursiveClassDeclarationRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleRecursiveClassDeclaration();

            state._fsp--;

             after(grammarAccess.getRecursiveClassDeclarationRule()); 
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
    // $ANTLR end "entryRuleRecursiveClassDeclaration"


    // $ANTLR start "ruleRecursiveClassDeclaration"
    // InternalBug360834TestLanguage.g:142:1: ruleRecursiveClassDeclaration : ( ( rule__RecursiveClassDeclaration__Group__0 ) ) ;
    public final void ruleRecursiveClassDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:146:2: ( ( ( rule__RecursiveClassDeclaration__Group__0 ) ) )
            // InternalBug360834TestLanguage.g:147:2: ( ( rule__RecursiveClassDeclaration__Group__0 ) )
            {
            // InternalBug360834TestLanguage.g:147:2: ( ( rule__RecursiveClassDeclaration__Group__0 ) )
            // InternalBug360834TestLanguage.g:148:3: ( rule__RecursiveClassDeclaration__Group__0 )
            {
             before(grammarAccess.getRecursiveClassDeclarationAccess().getGroup()); 
            // InternalBug360834TestLanguage.g:149:3: ( rule__RecursiveClassDeclaration__Group__0 )
            // InternalBug360834TestLanguage.g:149:4: rule__RecursiveClassDeclaration__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RecursiveClassDeclaration__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRecursiveClassDeclarationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRecursiveClassDeclaration"


    // $ANTLR start "entryRuleAlternativeClassModifiers"
    // InternalBug360834TestLanguage.g:158:1: entryRuleAlternativeClassModifiers : ruleAlternativeClassModifiers EOF ;
    public final void entryRuleAlternativeClassModifiers() throws RecognitionException {
        try {
            // InternalBug360834TestLanguage.g:159:1: ( ruleAlternativeClassModifiers EOF )
            // InternalBug360834TestLanguage.g:160:1: ruleAlternativeClassModifiers EOF
            {
             before(grammarAccess.getAlternativeClassModifiersRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAlternativeClassModifiers();

            state._fsp--;

             after(grammarAccess.getAlternativeClassModifiersRule()); 
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
    // $ANTLR end "entryRuleAlternativeClassModifiers"


    // $ANTLR start "ruleAlternativeClassModifiers"
    // InternalBug360834TestLanguage.g:167:1: ruleAlternativeClassModifiers : ( ( rule__AlternativeClassModifiers__Group__0 ) ) ;
    public final void ruleAlternativeClassModifiers() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:171:2: ( ( ( rule__AlternativeClassModifiers__Group__0 ) ) )
            // InternalBug360834TestLanguage.g:172:2: ( ( rule__AlternativeClassModifiers__Group__0 ) )
            {
            // InternalBug360834TestLanguage.g:172:2: ( ( rule__AlternativeClassModifiers__Group__0 ) )
            // InternalBug360834TestLanguage.g:173:3: ( rule__AlternativeClassModifiers__Group__0 )
            {
             before(grammarAccess.getAlternativeClassModifiersAccess().getGroup()); 
            // InternalBug360834TestLanguage.g:174:3: ( rule__AlternativeClassModifiers__Group__0 )
            // InternalBug360834TestLanguage.g:174:4: rule__AlternativeClassModifiers__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AlternativeClassModifiers__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAlternativeClassModifiersAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAlternativeClassModifiers"


    // $ANTLR start "entryRuleUnordered"
    // InternalBug360834TestLanguage.g:183:1: entryRuleUnordered : ruleUnordered EOF ;
    public final void entryRuleUnordered() throws RecognitionException {
        try {
            // InternalBug360834TestLanguage.g:184:1: ( ruleUnordered EOF )
            // InternalBug360834TestLanguage.g:185:1: ruleUnordered EOF
            {
             before(grammarAccess.getUnorderedRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleUnordered();

            state._fsp--;

             after(grammarAccess.getUnorderedRule()); 
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
    // $ANTLR end "entryRuleUnordered"


    // $ANTLR start "ruleUnordered"
    // InternalBug360834TestLanguage.g:192:1: ruleUnordered : ( ( rule__Unordered__Group__0 ) ) ;
    public final void ruleUnordered() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:196:2: ( ( ( rule__Unordered__Group__0 ) ) )
            // InternalBug360834TestLanguage.g:197:2: ( ( rule__Unordered__Group__0 ) )
            {
            // InternalBug360834TestLanguage.g:197:2: ( ( rule__Unordered__Group__0 ) )
            // InternalBug360834TestLanguage.g:198:3: ( rule__Unordered__Group__0 )
            {
             before(grammarAccess.getUnorderedAccess().getGroup()); 
            // InternalBug360834TestLanguage.g:199:3: ( rule__Unordered__Group__0 )
            // InternalBug360834TestLanguage.g:199:4: rule__Unordered__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Unordered__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUnorderedAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUnordered"


    // $ANTLR start "entryRuleSimpleClassDeclaration"
    // InternalBug360834TestLanguage.g:208:1: entryRuleSimpleClassDeclaration : ruleSimpleClassDeclaration EOF ;
    public final void entryRuleSimpleClassDeclaration() throws RecognitionException {
        try {
            // InternalBug360834TestLanguage.g:209:1: ( ruleSimpleClassDeclaration EOF )
            // InternalBug360834TestLanguage.g:210:1: ruleSimpleClassDeclaration EOF
            {
             before(grammarAccess.getSimpleClassDeclarationRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleSimpleClassDeclaration();

            state._fsp--;

             after(grammarAccess.getSimpleClassDeclarationRule()); 
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
    // $ANTLR end "entryRuleSimpleClassDeclaration"


    // $ANTLR start "ruleSimpleClassDeclaration"
    // InternalBug360834TestLanguage.g:217:1: ruleSimpleClassDeclaration : ( ( rule__SimpleClassDeclaration__Group__0 ) ) ;
    public final void ruleSimpleClassDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:221:2: ( ( ( rule__SimpleClassDeclaration__Group__0 ) ) )
            // InternalBug360834TestLanguage.g:222:2: ( ( rule__SimpleClassDeclaration__Group__0 ) )
            {
            // InternalBug360834TestLanguage.g:222:2: ( ( rule__SimpleClassDeclaration__Group__0 ) )
            // InternalBug360834TestLanguage.g:223:3: ( rule__SimpleClassDeclaration__Group__0 )
            {
             before(grammarAccess.getSimpleClassDeclarationAccess().getGroup()); 
            // InternalBug360834TestLanguage.g:224:3: ( rule__SimpleClassDeclaration__Group__0 )
            // InternalBug360834TestLanguage.g:224:4: rule__SimpleClassDeclaration__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__SimpleClassDeclaration__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSimpleClassDeclarationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSimpleClassDeclaration"


    // $ANTLR start "entryRuleClassMember"
    // InternalBug360834TestLanguage.g:233:1: entryRuleClassMember : ruleClassMember EOF ;
    public final void entryRuleClassMember() throws RecognitionException {
        try {
            // InternalBug360834TestLanguage.g:234:1: ( ruleClassMember EOF )
            // InternalBug360834TestLanguage.g:235:1: ruleClassMember EOF
            {
             before(grammarAccess.getClassMemberRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleClassMember();

            state._fsp--;

             after(grammarAccess.getClassMemberRule()); 
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
    // $ANTLR end "entryRuleClassMember"


    // $ANTLR start "ruleClassMember"
    // InternalBug360834TestLanguage.g:242:1: ruleClassMember : ( ( rule__ClassMember__Group__0 ) ) ;
    public final void ruleClassMember() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:246:2: ( ( ( rule__ClassMember__Group__0 ) ) )
            // InternalBug360834TestLanguage.g:247:2: ( ( rule__ClassMember__Group__0 ) )
            {
            // InternalBug360834TestLanguage.g:247:2: ( ( rule__ClassMember__Group__0 ) )
            // InternalBug360834TestLanguage.g:248:3: ( rule__ClassMember__Group__0 )
            {
             before(grammarAccess.getClassMemberAccess().getGroup()); 
            // InternalBug360834TestLanguage.g:249:3: ( rule__ClassMember__Group__0 )
            // InternalBug360834TestLanguage.g:249:4: rule__ClassMember__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ClassMember__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getClassMemberAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleClassMember"


    // $ANTLR start "entryRuleUnorderedModifiers"
    // InternalBug360834TestLanguage.g:258:1: entryRuleUnorderedModifiers : ruleUnorderedModifiers EOF ;
    public final void entryRuleUnorderedModifiers() throws RecognitionException {
        try {
            // InternalBug360834TestLanguage.g:259:1: ( ruleUnorderedModifiers EOF )
            // InternalBug360834TestLanguage.g:260:1: ruleUnorderedModifiers EOF
            {
             before(grammarAccess.getUnorderedModifiersRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleUnorderedModifiers();

            state._fsp--;

             after(grammarAccess.getUnorderedModifiersRule()); 
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
    // $ANTLR end "entryRuleUnorderedModifiers"


    // $ANTLR start "ruleUnorderedModifiers"
    // InternalBug360834TestLanguage.g:267:1: ruleUnorderedModifiers : ( ( rule__UnorderedModifiers__Group__0 ) ) ;
    public final void ruleUnorderedModifiers() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:271:2: ( ( ( rule__UnorderedModifiers__Group__0 ) ) )
            // InternalBug360834TestLanguage.g:272:2: ( ( rule__UnorderedModifiers__Group__0 ) )
            {
            // InternalBug360834TestLanguage.g:272:2: ( ( rule__UnorderedModifiers__Group__0 ) )
            // InternalBug360834TestLanguage.g:273:3: ( rule__UnorderedModifiers__Group__0 )
            {
             before(grammarAccess.getUnorderedModifiersAccess().getGroup()); 
            // InternalBug360834TestLanguage.g:274:3: ( rule__UnorderedModifiers__Group__0 )
            // InternalBug360834TestLanguage.g:274:4: rule__UnorderedModifiers__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__UnorderedModifiers__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUnorderedModifiersAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUnorderedModifiers"


    // $ANTLR start "ruleVisibility"
    // InternalBug360834TestLanguage.g:283:1: ruleVisibility : ( ( rule__Visibility__Alternatives ) ) ;
    public final void ruleVisibility() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:287:1: ( ( ( rule__Visibility__Alternatives ) ) )
            // InternalBug360834TestLanguage.g:288:2: ( ( rule__Visibility__Alternatives ) )
            {
            // InternalBug360834TestLanguage.g:288:2: ( ( rule__Visibility__Alternatives ) )
            // InternalBug360834TestLanguage.g:289:3: ( rule__Visibility__Alternatives )
            {
             before(grammarAccess.getVisibilityAccess().getAlternatives()); 
            // InternalBug360834TestLanguage.g:290:3: ( rule__Visibility__Alternatives )
            // InternalBug360834TestLanguage.g:290:4: rule__Visibility__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Visibility__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getVisibilityAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVisibility"


    // $ANTLR start "rule__Model__Alternatives"
    // InternalBug360834TestLanguage.g:298:1: rule__Model__Alternatives : ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) );
    public final void rule__Model__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:302:1: ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==14) ) {
                alt1=1;
            }
            else if ( (LA1_0==15) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalBug360834TestLanguage.g:303:2: ( ( rule__Model__Group_0__0 ) )
                    {
                    // InternalBug360834TestLanguage.g:303:2: ( ( rule__Model__Group_0__0 ) )
                    // InternalBug360834TestLanguage.g:304:3: ( rule__Model__Group_0__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_0()); 
                    // InternalBug360834TestLanguage.g:305:3: ( rule__Model__Group_0__0 )
                    // InternalBug360834TestLanguage.g:305:4: rule__Model__Group_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Model__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug360834TestLanguage.g:309:2: ( ( rule__Model__Group_1__0 ) )
                    {
                    // InternalBug360834TestLanguage.g:309:2: ( ( rule__Model__Group_1__0 ) )
                    // InternalBug360834TestLanguage.g:310:3: ( rule__Model__Group_1__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_1()); 
                    // InternalBug360834TestLanguage.g:311:3: ( rule__Model__Group_1__0 )
                    // InternalBug360834TestLanguage.g:311:4: rule__Model__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Model__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_1()); 

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


    // $ANTLR start "rule__AlternativeClassModifiers__Alternatives_1"
    // InternalBug360834TestLanguage.g:319:1: rule__AlternativeClassModifiers__Alternatives_1 : ( ( ( rule__AlternativeClassModifiers__FinalAssignment_1_0 ) ) | ( ( rule__AlternativeClassModifiers__AbstractAssignment_1_1 ) ) | ( ( rule__AlternativeClassModifiers__ExternAssignment_1_2 ) ) | ( ( rule__AlternativeClassModifiers__VisibilityAssignment_1_3 )? ) );
    public final void rule__AlternativeClassModifiers__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:323:1: ( ( ( rule__AlternativeClassModifiers__FinalAssignment_1_0 ) ) | ( ( rule__AlternativeClassModifiers__AbstractAssignment_1_1 ) ) | ( ( rule__AlternativeClassModifiers__ExternAssignment_1_2 ) ) | ( ( rule__AlternativeClassModifiers__VisibilityAssignment_1_3 )? ) )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt3=1;
                }
                break;
            case 24:
                {
                alt3=2;
                }
                break;
            case 25:
                {
                alt3=3;
                }
                break;
            case EOF:
            case 11:
            case 12:
            case 13:
            case 19:
                {
                alt3=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalBug360834TestLanguage.g:324:2: ( ( rule__AlternativeClassModifiers__FinalAssignment_1_0 ) )
                    {
                    // InternalBug360834TestLanguage.g:324:2: ( ( rule__AlternativeClassModifiers__FinalAssignment_1_0 ) )
                    // InternalBug360834TestLanguage.g:325:3: ( rule__AlternativeClassModifiers__FinalAssignment_1_0 )
                    {
                     before(grammarAccess.getAlternativeClassModifiersAccess().getFinalAssignment_1_0()); 
                    // InternalBug360834TestLanguage.g:326:3: ( rule__AlternativeClassModifiers__FinalAssignment_1_0 )
                    // InternalBug360834TestLanguage.g:326:4: rule__AlternativeClassModifiers__FinalAssignment_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__AlternativeClassModifiers__FinalAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getAlternativeClassModifiersAccess().getFinalAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug360834TestLanguage.g:330:2: ( ( rule__AlternativeClassModifiers__AbstractAssignment_1_1 ) )
                    {
                    // InternalBug360834TestLanguage.g:330:2: ( ( rule__AlternativeClassModifiers__AbstractAssignment_1_1 ) )
                    // InternalBug360834TestLanguage.g:331:3: ( rule__AlternativeClassModifiers__AbstractAssignment_1_1 )
                    {
                     before(grammarAccess.getAlternativeClassModifiersAccess().getAbstractAssignment_1_1()); 
                    // InternalBug360834TestLanguage.g:332:3: ( rule__AlternativeClassModifiers__AbstractAssignment_1_1 )
                    // InternalBug360834TestLanguage.g:332:4: rule__AlternativeClassModifiers__AbstractAssignment_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__AlternativeClassModifiers__AbstractAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getAlternativeClassModifiersAccess().getAbstractAssignment_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBug360834TestLanguage.g:336:2: ( ( rule__AlternativeClassModifiers__ExternAssignment_1_2 ) )
                    {
                    // InternalBug360834TestLanguage.g:336:2: ( ( rule__AlternativeClassModifiers__ExternAssignment_1_2 ) )
                    // InternalBug360834TestLanguage.g:337:3: ( rule__AlternativeClassModifiers__ExternAssignment_1_2 )
                    {
                     before(grammarAccess.getAlternativeClassModifiersAccess().getExternAssignment_1_2()); 
                    // InternalBug360834TestLanguage.g:338:3: ( rule__AlternativeClassModifiers__ExternAssignment_1_2 )
                    // InternalBug360834TestLanguage.g:338:4: rule__AlternativeClassModifiers__ExternAssignment_1_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__AlternativeClassModifiers__ExternAssignment_1_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getAlternativeClassModifiersAccess().getExternAssignment_1_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBug360834TestLanguage.g:342:2: ( ( rule__AlternativeClassModifiers__VisibilityAssignment_1_3 )? )
                    {
                    // InternalBug360834TestLanguage.g:342:2: ( ( rule__AlternativeClassModifiers__VisibilityAssignment_1_3 )? )
                    // InternalBug360834TestLanguage.g:343:3: ( rule__AlternativeClassModifiers__VisibilityAssignment_1_3 )?
                    {
                     before(grammarAccess.getAlternativeClassModifiersAccess().getVisibilityAssignment_1_3()); 
                    // InternalBug360834TestLanguage.g:344:3: ( rule__AlternativeClassModifiers__VisibilityAssignment_1_3 )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( ((LA2_0>=11 && LA2_0<=13)) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // InternalBug360834TestLanguage.g:344:4: rule__AlternativeClassModifiers__VisibilityAssignment_1_3
                            {
                            pushFollow(FollowSets000.FOLLOW_2);
                            rule__AlternativeClassModifiers__VisibilityAssignment_1_3();

                            state._fsp--;


                            }
                            break;

                    }

                     after(grammarAccess.getAlternativeClassModifiersAccess().getVisibilityAssignment_1_3()); 

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
    // $ANTLR end "rule__AlternativeClassModifiers__Alternatives_1"


    // $ANTLR start "rule__Visibility__Alternatives"
    // InternalBug360834TestLanguage.g:352:1: rule__Visibility__Alternatives : ( ( ( 'public' ) ) | ( ( 'protected' ) ) | ( ( 'private' ) ) );
    public final void rule__Visibility__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:356:1: ( ( ( 'public' ) ) | ( ( 'protected' ) ) | ( ( 'private' ) ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt4=1;
                }
                break;
            case 12:
                {
                alt4=2;
                }
                break;
            case 13:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalBug360834TestLanguage.g:357:2: ( ( 'public' ) )
                    {
                    // InternalBug360834TestLanguage.g:357:2: ( ( 'public' ) )
                    // InternalBug360834TestLanguage.g:358:3: ( 'public' )
                    {
                     before(grammarAccess.getVisibilityAccess().getPUBLICEnumLiteralDeclaration_0()); 
                    // InternalBug360834TestLanguage.g:359:3: ( 'public' )
                    // InternalBug360834TestLanguage.g:359:4: 'public'
                    {
                    match(input,11,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getVisibilityAccess().getPUBLICEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug360834TestLanguage.g:363:2: ( ( 'protected' ) )
                    {
                    // InternalBug360834TestLanguage.g:363:2: ( ( 'protected' ) )
                    // InternalBug360834TestLanguage.g:364:3: ( 'protected' )
                    {
                     before(grammarAccess.getVisibilityAccess().getPROTECTEDEnumLiteralDeclaration_1()); 
                    // InternalBug360834TestLanguage.g:365:3: ( 'protected' )
                    // InternalBug360834TestLanguage.g:365:4: 'protected'
                    {
                    match(input,12,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getVisibilityAccess().getPROTECTEDEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBug360834TestLanguage.g:369:2: ( ( 'private' ) )
                    {
                    // InternalBug360834TestLanguage.g:369:2: ( ( 'private' ) )
                    // InternalBug360834TestLanguage.g:370:3: ( 'private' )
                    {
                     before(grammarAccess.getVisibilityAccess().getPRIVATEEnumLiteralDeclaration_2()); 
                    // InternalBug360834TestLanguage.g:371:3: ( 'private' )
                    // InternalBug360834TestLanguage.g:371:4: 'private'
                    {
                    match(input,13,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getVisibilityAccess().getPRIVATEEnumLiteralDeclaration_2()); 

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
    // $ANTLR end "rule__Visibility__Alternatives"


    // $ANTLR start "rule__Model__Group_0__0"
    // InternalBug360834TestLanguage.g:379:1: rule__Model__Group_0__0 : rule__Model__Group_0__0__Impl rule__Model__Group_0__1 ;
    public final void rule__Model__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:383:1: ( rule__Model__Group_0__0__Impl rule__Model__Group_0__1 )
            // InternalBug360834TestLanguage.g:384:2: rule__Model__Group_0__0__Impl rule__Model__Group_0__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Model__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Group_0__1();

            state._fsp--;


            }

        }
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
    // InternalBug360834TestLanguage.g:391:1: rule__Model__Group_0__0__Impl : ( 'alternative' ) ;
    public final void rule__Model__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:395:1: ( ( 'alternative' ) )
            // InternalBug360834TestLanguage.g:396:1: ( 'alternative' )
            {
            // InternalBug360834TestLanguage.g:396:1: ( 'alternative' )
            // InternalBug360834TestLanguage.g:397:2: 'alternative'
            {
             before(grammarAccess.getModelAccess().getAlternativeKeyword_0_0()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getModelAccess().getAlternativeKeyword_0_0()); 

            }


            }

        }
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
    // InternalBug360834TestLanguage.g:406:1: rule__Model__Group_0__1 : rule__Model__Group_0__1__Impl ;
    public final void rule__Model__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:410:1: ( rule__Model__Group_0__1__Impl )
            // InternalBug360834TestLanguage.g:411:2: rule__Model__Group_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Group_0__1__Impl();

            state._fsp--;


            }

        }
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
    // InternalBug360834TestLanguage.g:417:1: rule__Model__Group_0__1__Impl : ( ( rule__Model__ElementAssignment_0_1 ) ) ;
    public final void rule__Model__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:421:1: ( ( ( rule__Model__ElementAssignment_0_1 ) ) )
            // InternalBug360834TestLanguage.g:422:1: ( ( rule__Model__ElementAssignment_0_1 ) )
            {
            // InternalBug360834TestLanguage.g:422:1: ( ( rule__Model__ElementAssignment_0_1 ) )
            // InternalBug360834TestLanguage.g:423:2: ( rule__Model__ElementAssignment_0_1 )
            {
             before(grammarAccess.getModelAccess().getElementAssignment_0_1()); 
            // InternalBug360834TestLanguage.g:424:2: ( rule__Model__ElementAssignment_0_1 )
            // InternalBug360834TestLanguage.g:424:3: rule__Model__ElementAssignment_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__ElementAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getElementAssignment_0_1()); 

            }


            }

        }
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
    // InternalBug360834TestLanguage.g:433:1: rule__Model__Group_1__0 : rule__Model__Group_1__0__Impl rule__Model__Group_1__1 ;
    public final void rule__Model__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:437:1: ( rule__Model__Group_1__0__Impl rule__Model__Group_1__1 )
            // InternalBug360834TestLanguage.g:438:2: rule__Model__Group_1__0__Impl rule__Model__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Model__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Group_1__1();

            state._fsp--;


            }

        }
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
    // InternalBug360834TestLanguage.g:445:1: rule__Model__Group_1__0__Impl : ( 'unordered' ) ;
    public final void rule__Model__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:449:1: ( ( 'unordered' ) )
            // InternalBug360834TestLanguage.g:450:1: ( 'unordered' )
            {
            // InternalBug360834TestLanguage.g:450:1: ( 'unordered' )
            // InternalBug360834TestLanguage.g:451:2: 'unordered'
            {
             before(grammarAccess.getModelAccess().getUnorderedKeyword_1_0()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getModelAccess().getUnorderedKeyword_1_0()); 

            }


            }

        }
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
    // InternalBug360834TestLanguage.g:460:1: rule__Model__Group_1__1 : rule__Model__Group_1__1__Impl ;
    public final void rule__Model__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:464:1: ( rule__Model__Group_1__1__Impl )
            // InternalBug360834TestLanguage.g:465:2: rule__Model__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Group_1__1__Impl();

            state._fsp--;


            }

        }
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
    // InternalBug360834TestLanguage.g:471:1: rule__Model__Group_1__1__Impl : ( ( rule__Model__ElementAssignment_1_1 ) ) ;
    public final void rule__Model__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:475:1: ( ( ( rule__Model__ElementAssignment_1_1 ) ) )
            // InternalBug360834TestLanguage.g:476:1: ( ( rule__Model__ElementAssignment_1_1 ) )
            {
            // InternalBug360834TestLanguage.g:476:1: ( ( rule__Model__ElementAssignment_1_1 ) )
            // InternalBug360834TestLanguage.g:477:2: ( rule__Model__ElementAssignment_1_1 )
            {
             before(grammarAccess.getModelAccess().getElementAssignment_1_1()); 
            // InternalBug360834TestLanguage.g:478:2: ( rule__Model__ElementAssignment_1_1 )
            // InternalBug360834TestLanguage.g:478:3: rule__Model__ElementAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__ElementAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getElementAssignment_1_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__Alternative__Group__0"
    // InternalBug360834TestLanguage.g:487:1: rule__Alternative__Group__0 : rule__Alternative__Group__0__Impl rule__Alternative__Group__1 ;
    public final void rule__Alternative__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:491:1: ( rule__Alternative__Group__0__Impl rule__Alternative__Group__1 )
            // InternalBug360834TestLanguage.g:492:2: rule__Alternative__Group__0__Impl rule__Alternative__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Alternative__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Alternative__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternative__Group__0"


    // $ANTLR start "rule__Alternative__Group__0__Impl"
    // InternalBug360834TestLanguage.g:499:1: rule__Alternative__Group__0__Impl : ( 'package' ) ;
    public final void rule__Alternative__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:503:1: ( ( 'package' ) )
            // InternalBug360834TestLanguage.g:504:1: ( 'package' )
            {
            // InternalBug360834TestLanguage.g:504:1: ( 'package' )
            // InternalBug360834TestLanguage.g:505:2: 'package'
            {
             before(grammarAccess.getAlternativeAccess().getPackageKeyword_0()); 
            match(input,16,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAlternativeAccess().getPackageKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternative__Group__0__Impl"


    // $ANTLR start "rule__Alternative__Group__1"
    // InternalBug360834TestLanguage.g:514:1: rule__Alternative__Group__1 : rule__Alternative__Group__1__Impl rule__Alternative__Group__2 ;
    public final void rule__Alternative__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:518:1: ( rule__Alternative__Group__1__Impl rule__Alternative__Group__2 )
            // InternalBug360834TestLanguage.g:519:2: rule__Alternative__Group__1__Impl rule__Alternative__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Alternative__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Alternative__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternative__Group__1"


    // $ANTLR start "rule__Alternative__Group__1__Impl"
    // InternalBug360834TestLanguage.g:526:1: rule__Alternative__Group__1__Impl : ( ( rule__Alternative__NameAssignment_1 ) ) ;
    public final void rule__Alternative__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:530:1: ( ( ( rule__Alternative__NameAssignment_1 ) ) )
            // InternalBug360834TestLanguage.g:531:1: ( ( rule__Alternative__NameAssignment_1 ) )
            {
            // InternalBug360834TestLanguage.g:531:1: ( ( rule__Alternative__NameAssignment_1 ) )
            // InternalBug360834TestLanguage.g:532:2: ( rule__Alternative__NameAssignment_1 )
            {
             before(grammarAccess.getAlternativeAccess().getNameAssignment_1()); 
            // InternalBug360834TestLanguage.g:533:2: ( rule__Alternative__NameAssignment_1 )
            // InternalBug360834TestLanguage.g:533:3: rule__Alternative__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Alternative__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getAlternativeAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternative__Group__1__Impl"


    // $ANTLR start "rule__Alternative__Group__2"
    // InternalBug360834TestLanguage.g:541:1: rule__Alternative__Group__2 : rule__Alternative__Group__2__Impl rule__Alternative__Group__3 ;
    public final void rule__Alternative__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:545:1: ( rule__Alternative__Group__2__Impl rule__Alternative__Group__3 )
            // InternalBug360834TestLanguage.g:546:2: rule__Alternative__Group__2__Impl rule__Alternative__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Alternative__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Alternative__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternative__Group__2"


    // $ANTLR start "rule__Alternative__Group__2__Impl"
    // InternalBug360834TestLanguage.g:553:1: rule__Alternative__Group__2__Impl : ( ';' ) ;
    public final void rule__Alternative__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:557:1: ( ( ';' ) )
            // InternalBug360834TestLanguage.g:558:1: ( ';' )
            {
            // InternalBug360834TestLanguage.g:558:1: ( ';' )
            // InternalBug360834TestLanguage.g:559:2: ';'
            {
             before(grammarAccess.getAlternativeAccess().getSemicolonKeyword_2()); 
            match(input,17,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAlternativeAccess().getSemicolonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternative__Group__2__Impl"


    // $ANTLR start "rule__Alternative__Group__3"
    // InternalBug360834TestLanguage.g:568:1: rule__Alternative__Group__3 : rule__Alternative__Group__3__Impl ;
    public final void rule__Alternative__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:572:1: ( rule__Alternative__Group__3__Impl )
            // InternalBug360834TestLanguage.g:573:2: rule__Alternative__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Alternative__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternative__Group__3"


    // $ANTLR start "rule__Alternative__Group__3__Impl"
    // InternalBug360834TestLanguage.g:579:1: rule__Alternative__Group__3__Impl : ( ( rule__Alternative__RootDeclarationAssignment_3 ) ) ;
    public final void rule__Alternative__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:583:1: ( ( ( rule__Alternative__RootDeclarationAssignment_3 ) ) )
            // InternalBug360834TestLanguage.g:584:1: ( ( rule__Alternative__RootDeclarationAssignment_3 ) )
            {
            // InternalBug360834TestLanguage.g:584:1: ( ( rule__Alternative__RootDeclarationAssignment_3 ) )
            // InternalBug360834TestLanguage.g:585:2: ( rule__Alternative__RootDeclarationAssignment_3 )
            {
             before(grammarAccess.getAlternativeAccess().getRootDeclarationAssignment_3()); 
            // InternalBug360834TestLanguage.g:586:2: ( rule__Alternative__RootDeclarationAssignment_3 )
            // InternalBug360834TestLanguage.g:586:3: rule__Alternative__RootDeclarationAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Alternative__RootDeclarationAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getAlternativeAccess().getRootDeclarationAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternative__Group__3__Impl"


    // $ANTLR start "rule__FQN__Group__0"
    // InternalBug360834TestLanguage.g:595:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:599:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // InternalBug360834TestLanguage.g:600:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
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
    // InternalBug360834TestLanguage.g:607:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:611:1: ( ( RULE_ID ) )
            // InternalBug360834TestLanguage.g:612:1: ( RULE_ID )
            {
            // InternalBug360834TestLanguage.g:612:1: ( RULE_ID )
            // InternalBug360834TestLanguage.g:613:2: RULE_ID
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
    // InternalBug360834TestLanguage.g:622:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:626:1: ( rule__FQN__Group__1__Impl )
            // InternalBug360834TestLanguage.g:627:2: rule__FQN__Group__1__Impl
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
    // InternalBug360834TestLanguage.g:633:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:637:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // InternalBug360834TestLanguage.g:638:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // InternalBug360834TestLanguage.g:638:1: ( ( rule__FQN__Group_1__0 )* )
            // InternalBug360834TestLanguage.g:639:2: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // InternalBug360834TestLanguage.g:640:2: ( rule__FQN__Group_1__0 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==18) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalBug360834TestLanguage.g:640:3: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    rule__FQN__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
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
    // InternalBug360834TestLanguage.g:649:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:653:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // InternalBug360834TestLanguage.g:654:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
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
    // InternalBug360834TestLanguage.g:661:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:665:1: ( ( '.' ) )
            // InternalBug360834TestLanguage.g:666:1: ( '.' )
            {
            // InternalBug360834TestLanguage.g:666:1: ( '.' )
            // InternalBug360834TestLanguage.g:667:2: '.'
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,18,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
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
    // InternalBug360834TestLanguage.g:676:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:680:1: ( rule__FQN__Group_1__1__Impl )
            // InternalBug360834TestLanguage.g:681:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__FQN__Group_1__1__Impl();

            state._fsp--;


            }

        }
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
    // InternalBug360834TestLanguage.g:687:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:691:1: ( ( RULE_ID ) )
            // InternalBug360834TestLanguage.g:692:1: ( RULE_ID )
            {
            // InternalBug360834TestLanguage.g:692:1: ( RULE_ID )
            // InternalBug360834TestLanguage.g:693:2: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__RecursiveClassDeclaration__Group__0"
    // InternalBug360834TestLanguage.g:703:1: rule__RecursiveClassDeclaration__Group__0 : rule__RecursiveClassDeclaration__Group__0__Impl rule__RecursiveClassDeclaration__Group__1 ;
    public final void rule__RecursiveClassDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:707:1: ( rule__RecursiveClassDeclaration__Group__0__Impl rule__RecursiveClassDeclaration__Group__1 )
            // InternalBug360834TestLanguage.g:708:2: rule__RecursiveClassDeclaration__Group__0__Impl rule__RecursiveClassDeclaration__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__RecursiveClassDeclaration__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RecursiveClassDeclaration__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecursiveClassDeclaration__Group__0"


    // $ANTLR start "rule__RecursiveClassDeclaration__Group__0__Impl"
    // InternalBug360834TestLanguage.g:715:1: rule__RecursiveClassDeclaration__Group__0__Impl : ( ( rule__RecursiveClassDeclaration__ModifiersAssignment_0 ) ) ;
    public final void rule__RecursiveClassDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:719:1: ( ( ( rule__RecursiveClassDeclaration__ModifiersAssignment_0 ) ) )
            // InternalBug360834TestLanguage.g:720:1: ( ( rule__RecursiveClassDeclaration__ModifiersAssignment_0 ) )
            {
            // InternalBug360834TestLanguage.g:720:1: ( ( rule__RecursiveClassDeclaration__ModifiersAssignment_0 ) )
            // InternalBug360834TestLanguage.g:721:2: ( rule__RecursiveClassDeclaration__ModifiersAssignment_0 )
            {
             before(grammarAccess.getRecursiveClassDeclarationAccess().getModifiersAssignment_0()); 
            // InternalBug360834TestLanguage.g:722:2: ( rule__RecursiveClassDeclaration__ModifiersAssignment_0 )
            // InternalBug360834TestLanguage.g:722:3: rule__RecursiveClassDeclaration__ModifiersAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RecursiveClassDeclaration__ModifiersAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getRecursiveClassDeclarationAccess().getModifiersAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecursiveClassDeclaration__Group__0__Impl"


    // $ANTLR start "rule__RecursiveClassDeclaration__Group__1"
    // InternalBug360834TestLanguage.g:730:1: rule__RecursiveClassDeclaration__Group__1 : rule__RecursiveClassDeclaration__Group__1__Impl rule__RecursiveClassDeclaration__Group__2 ;
    public final void rule__RecursiveClassDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:734:1: ( rule__RecursiveClassDeclaration__Group__1__Impl rule__RecursiveClassDeclaration__Group__2 )
            // InternalBug360834TestLanguage.g:735:2: rule__RecursiveClassDeclaration__Group__1__Impl rule__RecursiveClassDeclaration__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__RecursiveClassDeclaration__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RecursiveClassDeclaration__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecursiveClassDeclaration__Group__1"


    // $ANTLR start "rule__RecursiveClassDeclaration__Group__1__Impl"
    // InternalBug360834TestLanguage.g:742:1: rule__RecursiveClassDeclaration__Group__1__Impl : ( 'class' ) ;
    public final void rule__RecursiveClassDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:746:1: ( ( 'class' ) )
            // InternalBug360834TestLanguage.g:747:1: ( 'class' )
            {
            // InternalBug360834TestLanguage.g:747:1: ( 'class' )
            // InternalBug360834TestLanguage.g:748:2: 'class'
            {
             before(grammarAccess.getRecursiveClassDeclarationAccess().getClassKeyword_1()); 
            match(input,19,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRecursiveClassDeclarationAccess().getClassKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecursiveClassDeclaration__Group__1__Impl"


    // $ANTLR start "rule__RecursiveClassDeclaration__Group__2"
    // InternalBug360834TestLanguage.g:757:1: rule__RecursiveClassDeclaration__Group__2 : rule__RecursiveClassDeclaration__Group__2__Impl rule__RecursiveClassDeclaration__Group__3 ;
    public final void rule__RecursiveClassDeclaration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:761:1: ( rule__RecursiveClassDeclaration__Group__2__Impl rule__RecursiveClassDeclaration__Group__3 )
            // InternalBug360834TestLanguage.g:762:2: rule__RecursiveClassDeclaration__Group__2__Impl rule__RecursiveClassDeclaration__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__RecursiveClassDeclaration__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RecursiveClassDeclaration__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecursiveClassDeclaration__Group__2"


    // $ANTLR start "rule__RecursiveClassDeclaration__Group__2__Impl"
    // InternalBug360834TestLanguage.g:769:1: rule__RecursiveClassDeclaration__Group__2__Impl : ( ( rule__RecursiveClassDeclaration__NameAssignment_2 ) ) ;
    public final void rule__RecursiveClassDeclaration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:773:1: ( ( ( rule__RecursiveClassDeclaration__NameAssignment_2 ) ) )
            // InternalBug360834TestLanguage.g:774:1: ( ( rule__RecursiveClassDeclaration__NameAssignment_2 ) )
            {
            // InternalBug360834TestLanguage.g:774:1: ( ( rule__RecursiveClassDeclaration__NameAssignment_2 ) )
            // InternalBug360834TestLanguage.g:775:2: ( rule__RecursiveClassDeclaration__NameAssignment_2 )
            {
             before(grammarAccess.getRecursiveClassDeclarationAccess().getNameAssignment_2()); 
            // InternalBug360834TestLanguage.g:776:2: ( rule__RecursiveClassDeclaration__NameAssignment_2 )
            // InternalBug360834TestLanguage.g:776:3: rule__RecursiveClassDeclaration__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RecursiveClassDeclaration__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getRecursiveClassDeclarationAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecursiveClassDeclaration__Group__2__Impl"


    // $ANTLR start "rule__RecursiveClassDeclaration__Group__3"
    // InternalBug360834TestLanguage.g:784:1: rule__RecursiveClassDeclaration__Group__3 : rule__RecursiveClassDeclaration__Group__3__Impl rule__RecursiveClassDeclaration__Group__4 ;
    public final void rule__RecursiveClassDeclaration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:788:1: ( rule__RecursiveClassDeclaration__Group__3__Impl rule__RecursiveClassDeclaration__Group__4 )
            // InternalBug360834TestLanguage.g:789:2: rule__RecursiveClassDeclaration__Group__3__Impl rule__RecursiveClassDeclaration__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__RecursiveClassDeclaration__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RecursiveClassDeclaration__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecursiveClassDeclaration__Group__3"


    // $ANTLR start "rule__RecursiveClassDeclaration__Group__3__Impl"
    // InternalBug360834TestLanguage.g:796:1: rule__RecursiveClassDeclaration__Group__3__Impl : ( '{' ) ;
    public final void rule__RecursiveClassDeclaration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:800:1: ( ( '{' ) )
            // InternalBug360834TestLanguage.g:801:1: ( '{' )
            {
            // InternalBug360834TestLanguage.g:801:1: ( '{' )
            // InternalBug360834TestLanguage.g:802:2: '{'
            {
             before(grammarAccess.getRecursiveClassDeclarationAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,20,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRecursiveClassDeclarationAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecursiveClassDeclaration__Group__3__Impl"


    // $ANTLR start "rule__RecursiveClassDeclaration__Group__4"
    // InternalBug360834TestLanguage.g:811:1: rule__RecursiveClassDeclaration__Group__4 : rule__RecursiveClassDeclaration__Group__4__Impl rule__RecursiveClassDeclaration__Group__5 ;
    public final void rule__RecursiveClassDeclaration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:815:1: ( rule__RecursiveClassDeclaration__Group__4__Impl rule__RecursiveClassDeclaration__Group__5 )
            // InternalBug360834TestLanguage.g:816:2: rule__RecursiveClassDeclaration__Group__4__Impl rule__RecursiveClassDeclaration__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__RecursiveClassDeclaration__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RecursiveClassDeclaration__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecursiveClassDeclaration__Group__4"


    // $ANTLR start "rule__RecursiveClassDeclaration__Group__4__Impl"
    // InternalBug360834TestLanguage.g:823:1: rule__RecursiveClassDeclaration__Group__4__Impl : ( ( rule__RecursiveClassDeclaration__MembersAssignment_4 )* ) ;
    public final void rule__RecursiveClassDeclaration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:827:1: ( ( ( rule__RecursiveClassDeclaration__MembersAssignment_4 )* ) )
            // InternalBug360834TestLanguage.g:828:1: ( ( rule__RecursiveClassDeclaration__MembersAssignment_4 )* )
            {
            // InternalBug360834TestLanguage.g:828:1: ( ( rule__RecursiveClassDeclaration__MembersAssignment_4 )* )
            // InternalBug360834TestLanguage.g:829:2: ( rule__RecursiveClassDeclaration__MembersAssignment_4 )*
            {
             before(grammarAccess.getRecursiveClassDeclarationAccess().getMembersAssignment_4()); 
            // InternalBug360834TestLanguage.g:830:2: ( rule__RecursiveClassDeclaration__MembersAssignment_4 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==EOF||(LA6_0>=11 && LA6_0<=13)||LA6_0==19||(LA6_0>=23 && LA6_0<=25)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalBug360834TestLanguage.g:830:3: rule__RecursiveClassDeclaration__MembersAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_12);
            	    rule__RecursiveClassDeclaration__MembersAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getRecursiveClassDeclarationAccess().getMembersAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecursiveClassDeclaration__Group__4__Impl"


    // $ANTLR start "rule__RecursiveClassDeclaration__Group__5"
    // InternalBug360834TestLanguage.g:838:1: rule__RecursiveClassDeclaration__Group__5 : rule__RecursiveClassDeclaration__Group__5__Impl ;
    public final void rule__RecursiveClassDeclaration__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:842:1: ( rule__RecursiveClassDeclaration__Group__5__Impl )
            // InternalBug360834TestLanguage.g:843:2: rule__RecursiveClassDeclaration__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RecursiveClassDeclaration__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecursiveClassDeclaration__Group__5"


    // $ANTLR start "rule__RecursiveClassDeclaration__Group__5__Impl"
    // InternalBug360834TestLanguage.g:849:1: rule__RecursiveClassDeclaration__Group__5__Impl : ( '}' ) ;
    public final void rule__RecursiveClassDeclaration__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:853:1: ( ( '}' ) )
            // InternalBug360834TestLanguage.g:854:1: ( '}' )
            {
            // InternalBug360834TestLanguage.g:854:1: ( '}' )
            // InternalBug360834TestLanguage.g:855:2: '}'
            {
             before(grammarAccess.getRecursiveClassDeclarationAccess().getRightCurlyBracketKeyword_5()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRecursiveClassDeclarationAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecursiveClassDeclaration__Group__5__Impl"


    // $ANTLR start "rule__AlternativeClassModifiers__Group__0"
    // InternalBug360834TestLanguage.g:865:1: rule__AlternativeClassModifiers__Group__0 : rule__AlternativeClassModifiers__Group__0__Impl rule__AlternativeClassModifiers__Group__1 ;
    public final void rule__AlternativeClassModifiers__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:869:1: ( rule__AlternativeClassModifiers__Group__0__Impl rule__AlternativeClassModifiers__Group__1 )
            // InternalBug360834TestLanguage.g:870:2: rule__AlternativeClassModifiers__Group__0__Impl rule__AlternativeClassModifiers__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__AlternativeClassModifiers__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__AlternativeClassModifiers__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeClassModifiers__Group__0"


    // $ANTLR start "rule__AlternativeClassModifiers__Group__0__Impl"
    // InternalBug360834TestLanguage.g:877:1: rule__AlternativeClassModifiers__Group__0__Impl : ( () ) ;
    public final void rule__AlternativeClassModifiers__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:881:1: ( ( () ) )
            // InternalBug360834TestLanguage.g:882:1: ( () )
            {
            // InternalBug360834TestLanguage.g:882:1: ( () )
            // InternalBug360834TestLanguage.g:883:2: ()
            {
             before(grammarAccess.getAlternativeClassModifiersAccess().getModifiersAction_0()); 
            // InternalBug360834TestLanguage.g:884:2: ()
            // InternalBug360834TestLanguage.g:884:3: 
            {
            }

             after(grammarAccess.getAlternativeClassModifiersAccess().getModifiersAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeClassModifiers__Group__0__Impl"


    // $ANTLR start "rule__AlternativeClassModifiers__Group__1"
    // InternalBug360834TestLanguage.g:892:1: rule__AlternativeClassModifiers__Group__1 : rule__AlternativeClassModifiers__Group__1__Impl ;
    public final void rule__AlternativeClassModifiers__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:896:1: ( rule__AlternativeClassModifiers__Group__1__Impl )
            // InternalBug360834TestLanguage.g:897:2: rule__AlternativeClassModifiers__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AlternativeClassModifiers__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeClassModifiers__Group__1"


    // $ANTLR start "rule__AlternativeClassModifiers__Group__1__Impl"
    // InternalBug360834TestLanguage.g:903:1: rule__AlternativeClassModifiers__Group__1__Impl : ( ( rule__AlternativeClassModifiers__Alternatives_1 ) ) ;
    public final void rule__AlternativeClassModifiers__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:907:1: ( ( ( rule__AlternativeClassModifiers__Alternatives_1 ) ) )
            // InternalBug360834TestLanguage.g:908:1: ( ( rule__AlternativeClassModifiers__Alternatives_1 ) )
            {
            // InternalBug360834TestLanguage.g:908:1: ( ( rule__AlternativeClassModifiers__Alternatives_1 ) )
            // InternalBug360834TestLanguage.g:909:2: ( rule__AlternativeClassModifiers__Alternatives_1 )
            {
             before(grammarAccess.getAlternativeClassModifiersAccess().getAlternatives_1()); 
            // InternalBug360834TestLanguage.g:910:2: ( rule__AlternativeClassModifiers__Alternatives_1 )
            // InternalBug360834TestLanguage.g:910:3: rule__AlternativeClassModifiers__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AlternativeClassModifiers__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getAlternativeClassModifiersAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeClassModifiers__Group__1__Impl"


    // $ANTLR start "rule__Unordered__Group__0"
    // InternalBug360834TestLanguage.g:919:1: rule__Unordered__Group__0 : rule__Unordered__Group__0__Impl rule__Unordered__Group__1 ;
    public final void rule__Unordered__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:923:1: ( rule__Unordered__Group__0__Impl rule__Unordered__Group__1 )
            // InternalBug360834TestLanguage.g:924:2: rule__Unordered__Group__0__Impl rule__Unordered__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Unordered__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Unordered__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Unordered__Group__0"


    // $ANTLR start "rule__Unordered__Group__0__Impl"
    // InternalBug360834TestLanguage.g:931:1: rule__Unordered__Group__0__Impl : ( 'package' ) ;
    public final void rule__Unordered__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:935:1: ( ( 'package' ) )
            // InternalBug360834TestLanguage.g:936:1: ( 'package' )
            {
            // InternalBug360834TestLanguage.g:936:1: ( 'package' )
            // InternalBug360834TestLanguage.g:937:2: 'package'
            {
             before(grammarAccess.getUnorderedAccess().getPackageKeyword_0()); 
            match(input,16,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getUnorderedAccess().getPackageKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Unordered__Group__0__Impl"


    // $ANTLR start "rule__Unordered__Group__1"
    // InternalBug360834TestLanguage.g:946:1: rule__Unordered__Group__1 : rule__Unordered__Group__1__Impl rule__Unordered__Group__2 ;
    public final void rule__Unordered__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:950:1: ( rule__Unordered__Group__1__Impl rule__Unordered__Group__2 )
            // InternalBug360834TestLanguage.g:951:2: rule__Unordered__Group__1__Impl rule__Unordered__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Unordered__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Unordered__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Unordered__Group__1"


    // $ANTLR start "rule__Unordered__Group__1__Impl"
    // InternalBug360834TestLanguage.g:958:1: rule__Unordered__Group__1__Impl : ( ( rule__Unordered__NameAssignment_1 ) ) ;
    public final void rule__Unordered__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:962:1: ( ( ( rule__Unordered__NameAssignment_1 ) ) )
            // InternalBug360834TestLanguage.g:963:1: ( ( rule__Unordered__NameAssignment_1 ) )
            {
            // InternalBug360834TestLanguage.g:963:1: ( ( rule__Unordered__NameAssignment_1 ) )
            // InternalBug360834TestLanguage.g:964:2: ( rule__Unordered__NameAssignment_1 )
            {
             before(grammarAccess.getUnorderedAccess().getNameAssignment_1()); 
            // InternalBug360834TestLanguage.g:965:2: ( rule__Unordered__NameAssignment_1 )
            // InternalBug360834TestLanguage.g:965:3: rule__Unordered__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Unordered__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getUnorderedAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Unordered__Group__1__Impl"


    // $ANTLR start "rule__Unordered__Group__2"
    // InternalBug360834TestLanguage.g:973:1: rule__Unordered__Group__2 : rule__Unordered__Group__2__Impl rule__Unordered__Group__3 ;
    public final void rule__Unordered__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:977:1: ( rule__Unordered__Group__2__Impl rule__Unordered__Group__3 )
            // InternalBug360834TestLanguage.g:978:2: rule__Unordered__Group__2__Impl rule__Unordered__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Unordered__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Unordered__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Unordered__Group__2"


    // $ANTLR start "rule__Unordered__Group__2__Impl"
    // InternalBug360834TestLanguage.g:985:1: rule__Unordered__Group__2__Impl : ( ';' ) ;
    public final void rule__Unordered__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:989:1: ( ( ';' ) )
            // InternalBug360834TestLanguage.g:990:1: ( ';' )
            {
            // InternalBug360834TestLanguage.g:990:1: ( ';' )
            // InternalBug360834TestLanguage.g:991:2: ';'
            {
             before(grammarAccess.getUnorderedAccess().getSemicolonKeyword_2()); 
            match(input,17,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getUnorderedAccess().getSemicolonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Unordered__Group__2__Impl"


    // $ANTLR start "rule__Unordered__Group__3"
    // InternalBug360834TestLanguage.g:1000:1: rule__Unordered__Group__3 : rule__Unordered__Group__3__Impl ;
    public final void rule__Unordered__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1004:1: ( rule__Unordered__Group__3__Impl )
            // InternalBug360834TestLanguage.g:1005:2: rule__Unordered__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Unordered__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Unordered__Group__3"


    // $ANTLR start "rule__Unordered__Group__3__Impl"
    // InternalBug360834TestLanguage.g:1011:1: rule__Unordered__Group__3__Impl : ( ( rule__Unordered__RootDeclarationAssignment_3 ) ) ;
    public final void rule__Unordered__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1015:1: ( ( ( rule__Unordered__RootDeclarationAssignment_3 ) ) )
            // InternalBug360834TestLanguage.g:1016:1: ( ( rule__Unordered__RootDeclarationAssignment_3 ) )
            {
            // InternalBug360834TestLanguage.g:1016:1: ( ( rule__Unordered__RootDeclarationAssignment_3 ) )
            // InternalBug360834TestLanguage.g:1017:2: ( rule__Unordered__RootDeclarationAssignment_3 )
            {
             before(grammarAccess.getUnorderedAccess().getRootDeclarationAssignment_3()); 
            // InternalBug360834TestLanguage.g:1018:2: ( rule__Unordered__RootDeclarationAssignment_3 )
            // InternalBug360834TestLanguage.g:1018:3: rule__Unordered__RootDeclarationAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Unordered__RootDeclarationAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getUnorderedAccess().getRootDeclarationAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Unordered__Group__3__Impl"


    // $ANTLR start "rule__SimpleClassDeclaration__Group__0"
    // InternalBug360834TestLanguage.g:1027:1: rule__SimpleClassDeclaration__Group__0 : rule__SimpleClassDeclaration__Group__0__Impl rule__SimpleClassDeclaration__Group__1 ;
    public final void rule__SimpleClassDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1031:1: ( rule__SimpleClassDeclaration__Group__0__Impl rule__SimpleClassDeclaration__Group__1 )
            // InternalBug360834TestLanguage.g:1032:2: rule__SimpleClassDeclaration__Group__0__Impl rule__SimpleClassDeclaration__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__SimpleClassDeclaration__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__SimpleClassDeclaration__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleClassDeclaration__Group__0"


    // $ANTLR start "rule__SimpleClassDeclaration__Group__0__Impl"
    // InternalBug360834TestLanguage.g:1039:1: rule__SimpleClassDeclaration__Group__0__Impl : ( ( rule__SimpleClassDeclaration__ModifiersAssignment_0 ) ) ;
    public final void rule__SimpleClassDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1043:1: ( ( ( rule__SimpleClassDeclaration__ModifiersAssignment_0 ) ) )
            // InternalBug360834TestLanguage.g:1044:1: ( ( rule__SimpleClassDeclaration__ModifiersAssignment_0 ) )
            {
            // InternalBug360834TestLanguage.g:1044:1: ( ( rule__SimpleClassDeclaration__ModifiersAssignment_0 ) )
            // InternalBug360834TestLanguage.g:1045:2: ( rule__SimpleClassDeclaration__ModifiersAssignment_0 )
            {
             before(grammarAccess.getSimpleClassDeclarationAccess().getModifiersAssignment_0()); 
            // InternalBug360834TestLanguage.g:1046:2: ( rule__SimpleClassDeclaration__ModifiersAssignment_0 )
            // InternalBug360834TestLanguage.g:1046:3: rule__SimpleClassDeclaration__ModifiersAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__SimpleClassDeclaration__ModifiersAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getSimpleClassDeclarationAccess().getModifiersAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleClassDeclaration__Group__0__Impl"


    // $ANTLR start "rule__SimpleClassDeclaration__Group__1"
    // InternalBug360834TestLanguage.g:1054:1: rule__SimpleClassDeclaration__Group__1 : rule__SimpleClassDeclaration__Group__1__Impl rule__SimpleClassDeclaration__Group__2 ;
    public final void rule__SimpleClassDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1058:1: ( rule__SimpleClassDeclaration__Group__1__Impl rule__SimpleClassDeclaration__Group__2 )
            // InternalBug360834TestLanguage.g:1059:2: rule__SimpleClassDeclaration__Group__1__Impl rule__SimpleClassDeclaration__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__SimpleClassDeclaration__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__SimpleClassDeclaration__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleClassDeclaration__Group__1"


    // $ANTLR start "rule__SimpleClassDeclaration__Group__1__Impl"
    // InternalBug360834TestLanguage.g:1066:1: rule__SimpleClassDeclaration__Group__1__Impl : ( 'class' ) ;
    public final void rule__SimpleClassDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1070:1: ( ( 'class' ) )
            // InternalBug360834TestLanguage.g:1071:1: ( 'class' )
            {
            // InternalBug360834TestLanguage.g:1071:1: ( 'class' )
            // InternalBug360834TestLanguage.g:1072:2: 'class'
            {
             before(grammarAccess.getSimpleClassDeclarationAccess().getClassKeyword_1()); 
            match(input,19,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSimpleClassDeclarationAccess().getClassKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleClassDeclaration__Group__1__Impl"


    // $ANTLR start "rule__SimpleClassDeclaration__Group__2"
    // InternalBug360834TestLanguage.g:1081:1: rule__SimpleClassDeclaration__Group__2 : rule__SimpleClassDeclaration__Group__2__Impl rule__SimpleClassDeclaration__Group__3 ;
    public final void rule__SimpleClassDeclaration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1085:1: ( rule__SimpleClassDeclaration__Group__2__Impl rule__SimpleClassDeclaration__Group__3 )
            // InternalBug360834TestLanguage.g:1086:2: rule__SimpleClassDeclaration__Group__2__Impl rule__SimpleClassDeclaration__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__SimpleClassDeclaration__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__SimpleClassDeclaration__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleClassDeclaration__Group__2"


    // $ANTLR start "rule__SimpleClassDeclaration__Group__2__Impl"
    // InternalBug360834TestLanguage.g:1093:1: rule__SimpleClassDeclaration__Group__2__Impl : ( ( rule__SimpleClassDeclaration__NameAssignment_2 ) ) ;
    public final void rule__SimpleClassDeclaration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1097:1: ( ( ( rule__SimpleClassDeclaration__NameAssignment_2 ) ) )
            // InternalBug360834TestLanguage.g:1098:1: ( ( rule__SimpleClassDeclaration__NameAssignment_2 ) )
            {
            // InternalBug360834TestLanguage.g:1098:1: ( ( rule__SimpleClassDeclaration__NameAssignment_2 ) )
            // InternalBug360834TestLanguage.g:1099:2: ( rule__SimpleClassDeclaration__NameAssignment_2 )
            {
             before(grammarAccess.getSimpleClassDeclarationAccess().getNameAssignment_2()); 
            // InternalBug360834TestLanguage.g:1100:2: ( rule__SimpleClassDeclaration__NameAssignment_2 )
            // InternalBug360834TestLanguage.g:1100:3: rule__SimpleClassDeclaration__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__SimpleClassDeclaration__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getSimpleClassDeclarationAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleClassDeclaration__Group__2__Impl"


    // $ANTLR start "rule__SimpleClassDeclaration__Group__3"
    // InternalBug360834TestLanguage.g:1108:1: rule__SimpleClassDeclaration__Group__3 : rule__SimpleClassDeclaration__Group__3__Impl rule__SimpleClassDeclaration__Group__4 ;
    public final void rule__SimpleClassDeclaration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1112:1: ( rule__SimpleClassDeclaration__Group__3__Impl rule__SimpleClassDeclaration__Group__4 )
            // InternalBug360834TestLanguage.g:1113:2: rule__SimpleClassDeclaration__Group__3__Impl rule__SimpleClassDeclaration__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__SimpleClassDeclaration__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__SimpleClassDeclaration__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleClassDeclaration__Group__3"


    // $ANTLR start "rule__SimpleClassDeclaration__Group__3__Impl"
    // InternalBug360834TestLanguage.g:1120:1: rule__SimpleClassDeclaration__Group__3__Impl : ( '{' ) ;
    public final void rule__SimpleClassDeclaration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1124:1: ( ( '{' ) )
            // InternalBug360834TestLanguage.g:1125:1: ( '{' )
            {
            // InternalBug360834TestLanguage.g:1125:1: ( '{' )
            // InternalBug360834TestLanguage.g:1126:2: '{'
            {
             before(grammarAccess.getSimpleClassDeclarationAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,20,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSimpleClassDeclarationAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleClassDeclaration__Group__3__Impl"


    // $ANTLR start "rule__SimpleClassDeclaration__Group__4"
    // InternalBug360834TestLanguage.g:1135:1: rule__SimpleClassDeclaration__Group__4 : rule__SimpleClassDeclaration__Group__4__Impl rule__SimpleClassDeclaration__Group__5 ;
    public final void rule__SimpleClassDeclaration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1139:1: ( rule__SimpleClassDeclaration__Group__4__Impl rule__SimpleClassDeclaration__Group__5 )
            // InternalBug360834TestLanguage.g:1140:2: rule__SimpleClassDeclaration__Group__4__Impl rule__SimpleClassDeclaration__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__SimpleClassDeclaration__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__SimpleClassDeclaration__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleClassDeclaration__Group__4"


    // $ANTLR start "rule__SimpleClassDeclaration__Group__4__Impl"
    // InternalBug360834TestLanguage.g:1147:1: rule__SimpleClassDeclaration__Group__4__Impl : ( ( rule__SimpleClassDeclaration__MembersAssignment_4 )* ) ;
    public final void rule__SimpleClassDeclaration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1151:1: ( ( ( rule__SimpleClassDeclaration__MembersAssignment_4 )* ) )
            // InternalBug360834TestLanguage.g:1152:1: ( ( rule__SimpleClassDeclaration__MembersAssignment_4 )* )
            {
            // InternalBug360834TestLanguage.g:1152:1: ( ( rule__SimpleClassDeclaration__MembersAssignment_4 )* )
            // InternalBug360834TestLanguage.g:1153:2: ( rule__SimpleClassDeclaration__MembersAssignment_4 )*
            {
             before(grammarAccess.getSimpleClassDeclarationAccess().getMembersAssignment_4()); 
            // InternalBug360834TestLanguage.g:1154:2: ( rule__SimpleClassDeclaration__MembersAssignment_4 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==EOF||(LA7_0>=11 && LA7_0<=13)||LA7_0==19||(LA7_0>=22 && LA7_0<=25)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalBug360834TestLanguage.g:1154:3: rule__SimpleClassDeclaration__MembersAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_12);
            	    rule__SimpleClassDeclaration__MembersAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getSimpleClassDeclarationAccess().getMembersAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleClassDeclaration__Group__4__Impl"


    // $ANTLR start "rule__SimpleClassDeclaration__Group__5"
    // InternalBug360834TestLanguage.g:1162:1: rule__SimpleClassDeclaration__Group__5 : rule__SimpleClassDeclaration__Group__5__Impl ;
    public final void rule__SimpleClassDeclaration__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1166:1: ( rule__SimpleClassDeclaration__Group__5__Impl )
            // InternalBug360834TestLanguage.g:1167:2: rule__SimpleClassDeclaration__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__SimpleClassDeclaration__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleClassDeclaration__Group__5"


    // $ANTLR start "rule__SimpleClassDeclaration__Group__5__Impl"
    // InternalBug360834TestLanguage.g:1173:1: rule__SimpleClassDeclaration__Group__5__Impl : ( '}' ) ;
    public final void rule__SimpleClassDeclaration__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1177:1: ( ( '}' ) )
            // InternalBug360834TestLanguage.g:1178:1: ( '}' )
            {
            // InternalBug360834TestLanguage.g:1178:1: ( '}' )
            // InternalBug360834TestLanguage.g:1179:2: '}'
            {
             before(grammarAccess.getSimpleClassDeclarationAccess().getRightCurlyBracketKeyword_5()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSimpleClassDeclarationAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleClassDeclaration__Group__5__Impl"


    // $ANTLR start "rule__ClassMember__Group__0"
    // InternalBug360834TestLanguage.g:1189:1: rule__ClassMember__Group__0 : rule__ClassMember__Group__0__Impl rule__ClassMember__Group__1 ;
    public final void rule__ClassMember__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1193:1: ( rule__ClassMember__Group__0__Impl rule__ClassMember__Group__1 )
            // InternalBug360834TestLanguage.g:1194:2: rule__ClassMember__Group__0__Impl rule__ClassMember__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__ClassMember__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ClassMember__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMember__Group__0"


    // $ANTLR start "rule__ClassMember__Group__0__Impl"
    // InternalBug360834TestLanguage.g:1201:1: rule__ClassMember__Group__0__Impl : ( ( rule__ClassMember__ModifiersAssignment_0 ) ) ;
    public final void rule__ClassMember__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1205:1: ( ( ( rule__ClassMember__ModifiersAssignment_0 ) ) )
            // InternalBug360834TestLanguage.g:1206:1: ( ( rule__ClassMember__ModifiersAssignment_0 ) )
            {
            // InternalBug360834TestLanguage.g:1206:1: ( ( rule__ClassMember__ModifiersAssignment_0 ) )
            // InternalBug360834TestLanguage.g:1207:2: ( rule__ClassMember__ModifiersAssignment_0 )
            {
             before(grammarAccess.getClassMemberAccess().getModifiersAssignment_0()); 
            // InternalBug360834TestLanguage.g:1208:2: ( rule__ClassMember__ModifiersAssignment_0 )
            // InternalBug360834TestLanguage.g:1208:3: rule__ClassMember__ModifiersAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ClassMember__ModifiersAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getClassMemberAccess().getModifiersAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMember__Group__0__Impl"


    // $ANTLR start "rule__ClassMember__Group__1"
    // InternalBug360834TestLanguage.g:1216:1: rule__ClassMember__Group__1 : rule__ClassMember__Group__1__Impl rule__ClassMember__Group__2 ;
    public final void rule__ClassMember__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1220:1: ( rule__ClassMember__Group__1__Impl rule__ClassMember__Group__2 )
            // InternalBug360834TestLanguage.g:1221:2: rule__ClassMember__Group__1__Impl rule__ClassMember__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__ClassMember__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ClassMember__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMember__Group__1"


    // $ANTLR start "rule__ClassMember__Group__1__Impl"
    // InternalBug360834TestLanguage.g:1228:1: rule__ClassMember__Group__1__Impl : ( 'var' ) ;
    public final void rule__ClassMember__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1232:1: ( ( 'var' ) )
            // InternalBug360834TestLanguage.g:1233:1: ( 'var' )
            {
            // InternalBug360834TestLanguage.g:1233:1: ( 'var' )
            // InternalBug360834TestLanguage.g:1234:2: 'var'
            {
             before(grammarAccess.getClassMemberAccess().getVarKeyword_1()); 
            match(input,22,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassMemberAccess().getVarKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMember__Group__1__Impl"


    // $ANTLR start "rule__ClassMember__Group__2"
    // InternalBug360834TestLanguage.g:1243:1: rule__ClassMember__Group__2 : rule__ClassMember__Group__2__Impl rule__ClassMember__Group__3 ;
    public final void rule__ClassMember__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1247:1: ( rule__ClassMember__Group__2__Impl rule__ClassMember__Group__3 )
            // InternalBug360834TestLanguage.g:1248:2: rule__ClassMember__Group__2__Impl rule__ClassMember__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__ClassMember__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ClassMember__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMember__Group__2"


    // $ANTLR start "rule__ClassMember__Group__2__Impl"
    // InternalBug360834TestLanguage.g:1255:1: rule__ClassMember__Group__2__Impl : ( ( rule__ClassMember__NameAssignment_2 ) ) ;
    public final void rule__ClassMember__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1259:1: ( ( ( rule__ClassMember__NameAssignment_2 ) ) )
            // InternalBug360834TestLanguage.g:1260:1: ( ( rule__ClassMember__NameAssignment_2 ) )
            {
            // InternalBug360834TestLanguage.g:1260:1: ( ( rule__ClassMember__NameAssignment_2 ) )
            // InternalBug360834TestLanguage.g:1261:2: ( rule__ClassMember__NameAssignment_2 )
            {
             before(grammarAccess.getClassMemberAccess().getNameAssignment_2()); 
            // InternalBug360834TestLanguage.g:1262:2: ( rule__ClassMember__NameAssignment_2 )
            // InternalBug360834TestLanguage.g:1262:3: rule__ClassMember__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ClassMember__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getClassMemberAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMember__Group__2__Impl"


    // $ANTLR start "rule__ClassMember__Group__3"
    // InternalBug360834TestLanguage.g:1270:1: rule__ClassMember__Group__3 : rule__ClassMember__Group__3__Impl ;
    public final void rule__ClassMember__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1274:1: ( rule__ClassMember__Group__3__Impl )
            // InternalBug360834TestLanguage.g:1275:2: rule__ClassMember__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ClassMember__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMember__Group__3"


    // $ANTLR start "rule__ClassMember__Group__3__Impl"
    // InternalBug360834TestLanguage.g:1281:1: rule__ClassMember__Group__3__Impl : ( ';' ) ;
    public final void rule__ClassMember__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1285:1: ( ( ';' ) )
            // InternalBug360834TestLanguage.g:1286:1: ( ';' )
            {
            // InternalBug360834TestLanguage.g:1286:1: ( ';' )
            // InternalBug360834TestLanguage.g:1287:2: ';'
            {
             before(grammarAccess.getClassMemberAccess().getSemicolonKeyword_3()); 
            match(input,17,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassMemberAccess().getSemicolonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMember__Group__3__Impl"


    // $ANTLR start "rule__UnorderedModifiers__Group__0"
    // InternalBug360834TestLanguage.g:1297:1: rule__UnorderedModifiers__Group__0 : rule__UnorderedModifiers__Group__0__Impl rule__UnorderedModifiers__Group__1 ;
    public final void rule__UnorderedModifiers__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1301:1: ( rule__UnorderedModifiers__Group__0__Impl rule__UnorderedModifiers__Group__1 )
            // InternalBug360834TestLanguage.g:1302:2: rule__UnorderedModifiers__Group__0__Impl rule__UnorderedModifiers__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__UnorderedModifiers__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__UnorderedModifiers__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedModifiers__Group__0"


    // $ANTLR start "rule__UnorderedModifiers__Group__0__Impl"
    // InternalBug360834TestLanguage.g:1309:1: rule__UnorderedModifiers__Group__0__Impl : ( () ) ;
    public final void rule__UnorderedModifiers__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1313:1: ( ( () ) )
            // InternalBug360834TestLanguage.g:1314:1: ( () )
            {
            // InternalBug360834TestLanguage.g:1314:1: ( () )
            // InternalBug360834TestLanguage.g:1315:2: ()
            {
             before(grammarAccess.getUnorderedModifiersAccess().getModifiersAction_0()); 
            // InternalBug360834TestLanguage.g:1316:2: ()
            // InternalBug360834TestLanguage.g:1316:3: 
            {
            }

             after(grammarAccess.getUnorderedModifiersAccess().getModifiersAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedModifiers__Group__0__Impl"


    // $ANTLR start "rule__UnorderedModifiers__Group__1"
    // InternalBug360834TestLanguage.g:1324:1: rule__UnorderedModifiers__Group__1 : rule__UnorderedModifiers__Group__1__Impl ;
    public final void rule__UnorderedModifiers__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1328:1: ( rule__UnorderedModifiers__Group__1__Impl )
            // InternalBug360834TestLanguage.g:1329:2: rule__UnorderedModifiers__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__UnorderedModifiers__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedModifiers__Group__1"


    // $ANTLR start "rule__UnorderedModifiers__Group__1__Impl"
    // InternalBug360834TestLanguage.g:1335:1: rule__UnorderedModifiers__Group__1__Impl : ( ( rule__UnorderedModifiers__UnorderedGroup_1 ) ) ;
    public final void rule__UnorderedModifiers__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1339:1: ( ( ( rule__UnorderedModifiers__UnorderedGroup_1 ) ) )
            // InternalBug360834TestLanguage.g:1340:1: ( ( rule__UnorderedModifiers__UnorderedGroup_1 ) )
            {
            // InternalBug360834TestLanguage.g:1340:1: ( ( rule__UnorderedModifiers__UnorderedGroup_1 ) )
            // InternalBug360834TestLanguage.g:1341:2: ( rule__UnorderedModifiers__UnorderedGroup_1 )
            {
             before(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1()); 
            // InternalBug360834TestLanguage.g:1342:2: ( rule__UnorderedModifiers__UnorderedGroup_1 )
            // InternalBug360834TestLanguage.g:1342:3: rule__UnorderedModifiers__UnorderedGroup_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__UnorderedModifiers__UnorderedGroup_1();

            state._fsp--;


            }

             after(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedModifiers__Group__1__Impl"


    // $ANTLR start "rule__UnorderedModifiers__UnorderedGroup_1"
    // InternalBug360834TestLanguage.g:1351:1: rule__UnorderedModifiers__UnorderedGroup_1 : ( rule__UnorderedModifiers__UnorderedGroup_1__0 )? ;
    public final void rule__UnorderedModifiers__UnorderedGroup_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1());
        	
        try {
            // InternalBug360834TestLanguage.g:1356:1: ( ( rule__UnorderedModifiers__UnorderedGroup_1__0 )? )
            // InternalBug360834TestLanguage.g:1357:2: ( rule__UnorderedModifiers__UnorderedGroup_1__0 )?
            {
            // InternalBug360834TestLanguage.g:1357:2: ( rule__UnorderedModifiers__UnorderedGroup_1__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( LA8_0 == 23 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 0) ) {
                alt8=1;
            }
            else if ( LA8_0 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 1) ) {
                alt8=1;
            }
            else if ( LA8_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 2) ) {
                alt8=1;
            }
            else if ( LA8_0 >= 11 && LA8_0 <= 13 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 3) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalBug360834TestLanguage.g:1357:2: rule__UnorderedModifiers__UnorderedGroup_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__UnorderedModifiers__UnorderedGroup_1__0();

                    state._fsp--;


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

            	getUnorderedGroupHelper().leave(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedModifiers__UnorderedGroup_1"


    // $ANTLR start "rule__UnorderedModifiers__UnorderedGroup_1__Impl"
    // InternalBug360834TestLanguage.g:1365:1: rule__UnorderedModifiers__UnorderedGroup_1__Impl : ( ({...}? => ( ( ( rule__UnorderedModifiers__FinalAssignment_1_0 ) ) ) ) | ({...}? => ( ( ( rule__UnorderedModifiers__AbstractAssignment_1_1 ) ) ) ) | ({...}? => ( ( ( rule__UnorderedModifiers__ExternAssignment_1_2 ) ) ) ) | ({...}? => ( ( ( rule__UnorderedModifiers__VisibilityAssignment_1_3 ) ) ) ) ) ;
    public final void rule__UnorderedModifiers__UnorderedGroup_1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
        	
        try {
            // InternalBug360834TestLanguage.g:1370:1: ( ( ({...}? => ( ( ( rule__UnorderedModifiers__FinalAssignment_1_0 ) ) ) ) | ({...}? => ( ( ( rule__UnorderedModifiers__AbstractAssignment_1_1 ) ) ) ) | ({...}? => ( ( ( rule__UnorderedModifiers__ExternAssignment_1_2 ) ) ) ) | ({...}? => ( ( ( rule__UnorderedModifiers__VisibilityAssignment_1_3 ) ) ) ) ) )
            // InternalBug360834TestLanguage.g:1371:3: ( ({...}? => ( ( ( rule__UnorderedModifiers__FinalAssignment_1_0 ) ) ) ) | ({...}? => ( ( ( rule__UnorderedModifiers__AbstractAssignment_1_1 ) ) ) ) | ({...}? => ( ( ( rule__UnorderedModifiers__ExternAssignment_1_2 ) ) ) ) | ({...}? => ( ( ( rule__UnorderedModifiers__VisibilityAssignment_1_3 ) ) ) ) )
            {
            // InternalBug360834TestLanguage.g:1371:3: ( ({...}? => ( ( ( rule__UnorderedModifiers__FinalAssignment_1_0 ) ) ) ) | ({...}? => ( ( ( rule__UnorderedModifiers__AbstractAssignment_1_1 ) ) ) ) | ({...}? => ( ( ( rule__UnorderedModifiers__ExternAssignment_1_2 ) ) ) ) | ({...}? => ( ( ( rule__UnorderedModifiers__VisibilityAssignment_1_3 ) ) ) ) )
            int alt9=4;
            int LA9_0 = input.LA(1);

            if ( LA9_0 == 23 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 0) ) {
                alt9=1;
            }
            else if ( LA9_0 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 1) ) {
                alt9=2;
            }
            else if ( LA9_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 2) ) {
                alt9=3;
            }
            else if ( LA9_0 >= 11 && LA9_0 <= 13 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 3) ) {
                alt9=4;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalBug360834TestLanguage.g:1372:3: ({...}? => ( ( ( rule__UnorderedModifiers__FinalAssignment_1_0 ) ) ) )
                    {
                    // InternalBug360834TestLanguage.g:1372:3: ({...}? => ( ( ( rule__UnorderedModifiers__FinalAssignment_1_0 ) ) ) )
                    // InternalBug360834TestLanguage.g:1373:4: {...}? => ( ( ( rule__UnorderedModifiers__FinalAssignment_1_0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 0) ) {
                        throw new FailedPredicateException(input, "rule__UnorderedModifiers__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 0)");
                    }
                    // InternalBug360834TestLanguage.g:1373:114: ( ( ( rule__UnorderedModifiers__FinalAssignment_1_0 ) ) )
                    // InternalBug360834TestLanguage.g:1374:5: ( ( rule__UnorderedModifiers__FinalAssignment_1_0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 0);
                    				

                    					selected = true;
                    				
                    // InternalBug360834TestLanguage.g:1380:5: ( ( rule__UnorderedModifiers__FinalAssignment_1_0 ) )
                    // InternalBug360834TestLanguage.g:1381:6: ( rule__UnorderedModifiers__FinalAssignment_1_0 )
                    {
                     before(grammarAccess.getUnorderedModifiersAccess().getFinalAssignment_1_0()); 
                    // InternalBug360834TestLanguage.g:1382:6: ( rule__UnorderedModifiers__FinalAssignment_1_0 )
                    // InternalBug360834TestLanguage.g:1382:7: rule__UnorderedModifiers__FinalAssignment_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__UnorderedModifiers__FinalAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getUnorderedModifiersAccess().getFinalAssignment_1_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBug360834TestLanguage.g:1387:3: ({...}? => ( ( ( rule__UnorderedModifiers__AbstractAssignment_1_1 ) ) ) )
                    {
                    // InternalBug360834TestLanguage.g:1387:3: ({...}? => ( ( ( rule__UnorderedModifiers__AbstractAssignment_1_1 ) ) ) )
                    // InternalBug360834TestLanguage.g:1388:4: {...}? => ( ( ( rule__UnorderedModifiers__AbstractAssignment_1_1 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 1) ) {
                        throw new FailedPredicateException(input, "rule__UnorderedModifiers__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 1)");
                    }
                    // InternalBug360834TestLanguage.g:1388:114: ( ( ( rule__UnorderedModifiers__AbstractAssignment_1_1 ) ) )
                    // InternalBug360834TestLanguage.g:1389:5: ( ( rule__UnorderedModifiers__AbstractAssignment_1_1 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 1);
                    				

                    					selected = true;
                    				
                    // InternalBug360834TestLanguage.g:1395:5: ( ( rule__UnorderedModifiers__AbstractAssignment_1_1 ) )
                    // InternalBug360834TestLanguage.g:1396:6: ( rule__UnorderedModifiers__AbstractAssignment_1_1 )
                    {
                     before(grammarAccess.getUnorderedModifiersAccess().getAbstractAssignment_1_1()); 
                    // InternalBug360834TestLanguage.g:1397:6: ( rule__UnorderedModifiers__AbstractAssignment_1_1 )
                    // InternalBug360834TestLanguage.g:1397:7: rule__UnorderedModifiers__AbstractAssignment_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__UnorderedModifiers__AbstractAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getUnorderedModifiersAccess().getAbstractAssignment_1_1()); 

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalBug360834TestLanguage.g:1402:3: ({...}? => ( ( ( rule__UnorderedModifiers__ExternAssignment_1_2 ) ) ) )
                    {
                    // InternalBug360834TestLanguage.g:1402:3: ({...}? => ( ( ( rule__UnorderedModifiers__ExternAssignment_1_2 ) ) ) )
                    // InternalBug360834TestLanguage.g:1403:4: {...}? => ( ( ( rule__UnorderedModifiers__ExternAssignment_1_2 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 2) ) {
                        throw new FailedPredicateException(input, "rule__UnorderedModifiers__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 2)");
                    }
                    // InternalBug360834TestLanguage.g:1403:114: ( ( ( rule__UnorderedModifiers__ExternAssignment_1_2 ) ) )
                    // InternalBug360834TestLanguage.g:1404:5: ( ( rule__UnorderedModifiers__ExternAssignment_1_2 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 2);
                    				

                    					selected = true;
                    				
                    // InternalBug360834TestLanguage.g:1410:5: ( ( rule__UnorderedModifiers__ExternAssignment_1_2 ) )
                    // InternalBug360834TestLanguage.g:1411:6: ( rule__UnorderedModifiers__ExternAssignment_1_2 )
                    {
                     before(grammarAccess.getUnorderedModifiersAccess().getExternAssignment_1_2()); 
                    // InternalBug360834TestLanguage.g:1412:6: ( rule__UnorderedModifiers__ExternAssignment_1_2 )
                    // InternalBug360834TestLanguage.g:1412:7: rule__UnorderedModifiers__ExternAssignment_1_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__UnorderedModifiers__ExternAssignment_1_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getUnorderedModifiersAccess().getExternAssignment_1_2()); 

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalBug360834TestLanguage.g:1417:3: ({...}? => ( ( ( rule__UnorderedModifiers__VisibilityAssignment_1_3 ) ) ) )
                    {
                    // InternalBug360834TestLanguage.g:1417:3: ({...}? => ( ( ( rule__UnorderedModifiers__VisibilityAssignment_1_3 ) ) ) )
                    // InternalBug360834TestLanguage.g:1418:4: {...}? => ( ( ( rule__UnorderedModifiers__VisibilityAssignment_1_3 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 3) ) {
                        throw new FailedPredicateException(input, "rule__UnorderedModifiers__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 3)");
                    }
                    // InternalBug360834TestLanguage.g:1418:114: ( ( ( rule__UnorderedModifiers__VisibilityAssignment_1_3 ) ) )
                    // InternalBug360834TestLanguage.g:1419:5: ( ( rule__UnorderedModifiers__VisibilityAssignment_1_3 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 3);
                    				

                    					selected = true;
                    				
                    // InternalBug360834TestLanguage.g:1425:5: ( ( rule__UnorderedModifiers__VisibilityAssignment_1_3 ) )
                    // InternalBug360834TestLanguage.g:1426:6: ( rule__UnorderedModifiers__VisibilityAssignment_1_3 )
                    {
                     before(grammarAccess.getUnorderedModifiersAccess().getVisibilityAssignment_1_3()); 
                    // InternalBug360834TestLanguage.g:1427:6: ( rule__UnorderedModifiers__VisibilityAssignment_1_3 )
                    // InternalBug360834TestLanguage.g:1427:7: rule__UnorderedModifiers__VisibilityAssignment_1_3
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__UnorderedModifiers__VisibilityAssignment_1_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getUnorderedModifiersAccess().getVisibilityAssignment_1_3()); 

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
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedModifiers__UnorderedGroup_1__Impl"


    // $ANTLR start "rule__UnorderedModifiers__UnorderedGroup_1__0"
    // InternalBug360834TestLanguage.g:1440:1: rule__UnorderedModifiers__UnorderedGroup_1__0 : rule__UnorderedModifiers__UnorderedGroup_1__Impl ( rule__UnorderedModifiers__UnorderedGroup_1__1 )? ;
    public final void rule__UnorderedModifiers__UnorderedGroup_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1444:1: ( rule__UnorderedModifiers__UnorderedGroup_1__Impl ( rule__UnorderedModifiers__UnorderedGroup_1__1 )? )
            // InternalBug360834TestLanguage.g:1445:2: rule__UnorderedModifiers__UnorderedGroup_1__Impl ( rule__UnorderedModifiers__UnorderedGroup_1__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__UnorderedModifiers__UnorderedGroup_1__Impl();

            state._fsp--;

            // InternalBug360834TestLanguage.g:1446:2: ( rule__UnorderedModifiers__UnorderedGroup_1__1 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( LA10_0 == 23 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 0) ) {
                alt10=1;
            }
            else if ( LA10_0 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 1) ) {
                alt10=1;
            }
            else if ( LA10_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 2) ) {
                alt10=1;
            }
            else if ( LA10_0 >= 11 && LA10_0 <= 13 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 3) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalBug360834TestLanguage.g:1446:2: rule__UnorderedModifiers__UnorderedGroup_1__1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__UnorderedModifiers__UnorderedGroup_1__1();

                    state._fsp--;


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
    // $ANTLR end "rule__UnorderedModifiers__UnorderedGroup_1__0"


    // $ANTLR start "rule__UnorderedModifiers__UnorderedGroup_1__1"
    // InternalBug360834TestLanguage.g:1452:1: rule__UnorderedModifiers__UnorderedGroup_1__1 : rule__UnorderedModifiers__UnorderedGroup_1__Impl ( rule__UnorderedModifiers__UnorderedGroup_1__2 )? ;
    public final void rule__UnorderedModifiers__UnorderedGroup_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1456:1: ( rule__UnorderedModifiers__UnorderedGroup_1__Impl ( rule__UnorderedModifiers__UnorderedGroup_1__2 )? )
            // InternalBug360834TestLanguage.g:1457:2: rule__UnorderedModifiers__UnorderedGroup_1__Impl ( rule__UnorderedModifiers__UnorderedGroup_1__2 )?
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__UnorderedModifiers__UnorderedGroup_1__Impl();

            state._fsp--;

            // InternalBug360834TestLanguage.g:1458:2: ( rule__UnorderedModifiers__UnorderedGroup_1__2 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( LA11_0 == 23 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 0) ) {
                alt11=1;
            }
            else if ( LA11_0 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 1) ) {
                alt11=1;
            }
            else if ( LA11_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 2) ) {
                alt11=1;
            }
            else if ( LA11_0 >= 11 && LA11_0 <= 13 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 3) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalBug360834TestLanguage.g:1458:2: rule__UnorderedModifiers__UnorderedGroup_1__2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__UnorderedModifiers__UnorderedGroup_1__2();

                    state._fsp--;


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
    // $ANTLR end "rule__UnorderedModifiers__UnorderedGroup_1__1"


    // $ANTLR start "rule__UnorderedModifiers__UnorderedGroup_1__2"
    // InternalBug360834TestLanguage.g:1464:1: rule__UnorderedModifiers__UnorderedGroup_1__2 : rule__UnorderedModifiers__UnorderedGroup_1__Impl ( rule__UnorderedModifiers__UnorderedGroup_1__3 )? ;
    public final void rule__UnorderedModifiers__UnorderedGroup_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1468:1: ( rule__UnorderedModifiers__UnorderedGroup_1__Impl ( rule__UnorderedModifiers__UnorderedGroup_1__3 )? )
            // InternalBug360834TestLanguage.g:1469:2: rule__UnorderedModifiers__UnorderedGroup_1__Impl ( rule__UnorderedModifiers__UnorderedGroup_1__3 )?
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__UnorderedModifiers__UnorderedGroup_1__Impl();

            state._fsp--;

            // InternalBug360834TestLanguage.g:1470:2: ( rule__UnorderedModifiers__UnorderedGroup_1__3 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( LA12_0 == 23 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 0) ) {
                alt12=1;
            }
            else if ( LA12_0 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 1) ) {
                alt12=1;
            }
            else if ( LA12_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 2) ) {
                alt12=1;
            }
            else if ( LA12_0 >= 11 && LA12_0 <= 13 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 3) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalBug360834TestLanguage.g:1470:2: rule__UnorderedModifiers__UnorderedGroup_1__3
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__UnorderedModifiers__UnorderedGroup_1__3();

                    state._fsp--;


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
    // $ANTLR end "rule__UnorderedModifiers__UnorderedGroup_1__2"


    // $ANTLR start "rule__UnorderedModifiers__UnorderedGroup_1__3"
    // InternalBug360834TestLanguage.g:1476:1: rule__UnorderedModifiers__UnorderedGroup_1__3 : rule__UnorderedModifiers__UnorderedGroup_1__Impl ;
    public final void rule__UnorderedModifiers__UnorderedGroup_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1480:1: ( rule__UnorderedModifiers__UnorderedGroup_1__Impl )
            // InternalBug360834TestLanguage.g:1481:2: rule__UnorderedModifiers__UnorderedGroup_1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__UnorderedModifiers__UnorderedGroup_1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedModifiers__UnorderedGroup_1__3"


    // $ANTLR start "rule__Model__ElementAssignment_0_1"
    // InternalBug360834TestLanguage.g:1488:1: rule__Model__ElementAssignment_0_1 : ( ruleAlternative ) ;
    public final void rule__Model__ElementAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1492:1: ( ( ruleAlternative ) )
            // InternalBug360834TestLanguage.g:1493:2: ( ruleAlternative )
            {
            // InternalBug360834TestLanguage.g:1493:2: ( ruleAlternative )
            // InternalBug360834TestLanguage.g:1494:3: ruleAlternative
            {
             before(grammarAccess.getModelAccess().getElementAlternativeParserRuleCall_0_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAlternative();

            state._fsp--;

             after(grammarAccess.getModelAccess().getElementAlternativeParserRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ElementAssignment_0_1"


    // $ANTLR start "rule__Model__ElementAssignment_1_1"
    // InternalBug360834TestLanguage.g:1503:1: rule__Model__ElementAssignment_1_1 : ( ruleUnordered ) ;
    public final void rule__Model__ElementAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1507:1: ( ( ruleUnordered ) )
            // InternalBug360834TestLanguage.g:1508:2: ( ruleUnordered )
            {
            // InternalBug360834TestLanguage.g:1508:2: ( ruleUnordered )
            // InternalBug360834TestLanguage.g:1509:3: ruleUnordered
            {
             before(grammarAccess.getModelAccess().getElementUnorderedParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleUnordered();

            state._fsp--;

             after(grammarAccess.getModelAccess().getElementUnorderedParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ElementAssignment_1_1"


    // $ANTLR start "rule__Alternative__NameAssignment_1"
    // InternalBug360834TestLanguage.g:1518:1: rule__Alternative__NameAssignment_1 : ( ruleFQN ) ;
    public final void rule__Alternative__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1522:1: ( ( ruleFQN ) )
            // InternalBug360834TestLanguage.g:1523:2: ( ruleFQN )
            {
            // InternalBug360834TestLanguage.g:1523:2: ( ruleFQN )
            // InternalBug360834TestLanguage.g:1524:3: ruleFQN
            {
             before(grammarAccess.getAlternativeAccess().getNameFQNParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getAlternativeAccess().getNameFQNParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternative__NameAssignment_1"


    // $ANTLR start "rule__Alternative__RootDeclarationAssignment_3"
    // InternalBug360834TestLanguage.g:1533:1: rule__Alternative__RootDeclarationAssignment_3 : ( ruleRecursiveClassDeclaration ) ;
    public final void rule__Alternative__RootDeclarationAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1537:1: ( ( ruleRecursiveClassDeclaration ) )
            // InternalBug360834TestLanguage.g:1538:2: ( ruleRecursiveClassDeclaration )
            {
            // InternalBug360834TestLanguage.g:1538:2: ( ruleRecursiveClassDeclaration )
            // InternalBug360834TestLanguage.g:1539:3: ruleRecursiveClassDeclaration
            {
             before(grammarAccess.getAlternativeAccess().getRootDeclarationRecursiveClassDeclarationParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleRecursiveClassDeclaration();

            state._fsp--;

             after(grammarAccess.getAlternativeAccess().getRootDeclarationRecursiveClassDeclarationParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternative__RootDeclarationAssignment_3"


    // $ANTLR start "rule__RecursiveClassDeclaration__ModifiersAssignment_0"
    // InternalBug360834TestLanguage.g:1548:1: rule__RecursiveClassDeclaration__ModifiersAssignment_0 : ( ruleAlternativeClassModifiers ) ;
    public final void rule__RecursiveClassDeclaration__ModifiersAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1552:1: ( ( ruleAlternativeClassModifiers ) )
            // InternalBug360834TestLanguage.g:1553:2: ( ruleAlternativeClassModifiers )
            {
            // InternalBug360834TestLanguage.g:1553:2: ( ruleAlternativeClassModifiers )
            // InternalBug360834TestLanguage.g:1554:3: ruleAlternativeClassModifiers
            {
             before(grammarAccess.getRecursiveClassDeclarationAccess().getModifiersAlternativeClassModifiersParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAlternativeClassModifiers();

            state._fsp--;

             after(grammarAccess.getRecursiveClassDeclarationAccess().getModifiersAlternativeClassModifiersParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecursiveClassDeclaration__ModifiersAssignment_0"


    // $ANTLR start "rule__RecursiveClassDeclaration__NameAssignment_2"
    // InternalBug360834TestLanguage.g:1563:1: rule__RecursiveClassDeclaration__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__RecursiveClassDeclaration__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1567:1: ( ( RULE_ID ) )
            // InternalBug360834TestLanguage.g:1568:2: ( RULE_ID )
            {
            // InternalBug360834TestLanguage.g:1568:2: ( RULE_ID )
            // InternalBug360834TestLanguage.g:1569:3: RULE_ID
            {
             before(grammarAccess.getRecursiveClassDeclarationAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRecursiveClassDeclarationAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecursiveClassDeclaration__NameAssignment_2"


    // $ANTLR start "rule__RecursiveClassDeclaration__MembersAssignment_4"
    // InternalBug360834TestLanguage.g:1578:1: rule__RecursiveClassDeclaration__MembersAssignment_4 : ( ruleRecursiveClassDeclaration ) ;
    public final void rule__RecursiveClassDeclaration__MembersAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1582:1: ( ( ruleRecursiveClassDeclaration ) )
            // InternalBug360834TestLanguage.g:1583:2: ( ruleRecursiveClassDeclaration )
            {
            // InternalBug360834TestLanguage.g:1583:2: ( ruleRecursiveClassDeclaration )
            // InternalBug360834TestLanguage.g:1584:3: ruleRecursiveClassDeclaration
            {
             before(grammarAccess.getRecursiveClassDeclarationAccess().getMembersRecursiveClassDeclarationParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleRecursiveClassDeclaration();

            state._fsp--;

             after(grammarAccess.getRecursiveClassDeclarationAccess().getMembersRecursiveClassDeclarationParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecursiveClassDeclaration__MembersAssignment_4"


    // $ANTLR start "rule__AlternativeClassModifiers__FinalAssignment_1_0"
    // InternalBug360834TestLanguage.g:1593:1: rule__AlternativeClassModifiers__FinalAssignment_1_0 : ( ( 'final' ) ) ;
    public final void rule__AlternativeClassModifiers__FinalAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1597:1: ( ( ( 'final' ) ) )
            // InternalBug360834TestLanguage.g:1598:2: ( ( 'final' ) )
            {
            // InternalBug360834TestLanguage.g:1598:2: ( ( 'final' ) )
            // InternalBug360834TestLanguage.g:1599:3: ( 'final' )
            {
             before(grammarAccess.getAlternativeClassModifiersAccess().getFinalFinalKeyword_1_0_0()); 
            // InternalBug360834TestLanguage.g:1600:3: ( 'final' )
            // InternalBug360834TestLanguage.g:1601:4: 'final'
            {
             before(grammarAccess.getAlternativeClassModifiersAccess().getFinalFinalKeyword_1_0_0()); 
            match(input,23,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAlternativeClassModifiersAccess().getFinalFinalKeyword_1_0_0()); 

            }

             after(grammarAccess.getAlternativeClassModifiersAccess().getFinalFinalKeyword_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeClassModifiers__FinalAssignment_1_0"


    // $ANTLR start "rule__AlternativeClassModifiers__AbstractAssignment_1_1"
    // InternalBug360834TestLanguage.g:1612:1: rule__AlternativeClassModifiers__AbstractAssignment_1_1 : ( ( 'abstract' ) ) ;
    public final void rule__AlternativeClassModifiers__AbstractAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1616:1: ( ( ( 'abstract' ) ) )
            // InternalBug360834TestLanguage.g:1617:2: ( ( 'abstract' ) )
            {
            // InternalBug360834TestLanguage.g:1617:2: ( ( 'abstract' ) )
            // InternalBug360834TestLanguage.g:1618:3: ( 'abstract' )
            {
             before(grammarAccess.getAlternativeClassModifiersAccess().getAbstractAbstractKeyword_1_1_0()); 
            // InternalBug360834TestLanguage.g:1619:3: ( 'abstract' )
            // InternalBug360834TestLanguage.g:1620:4: 'abstract'
            {
             before(grammarAccess.getAlternativeClassModifiersAccess().getAbstractAbstractKeyword_1_1_0()); 
            match(input,24,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAlternativeClassModifiersAccess().getAbstractAbstractKeyword_1_1_0()); 

            }

             after(grammarAccess.getAlternativeClassModifiersAccess().getAbstractAbstractKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeClassModifiers__AbstractAssignment_1_1"


    // $ANTLR start "rule__AlternativeClassModifiers__ExternAssignment_1_2"
    // InternalBug360834TestLanguage.g:1631:1: rule__AlternativeClassModifiers__ExternAssignment_1_2 : ( ( 'extern' ) ) ;
    public final void rule__AlternativeClassModifiers__ExternAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1635:1: ( ( ( 'extern' ) ) )
            // InternalBug360834TestLanguage.g:1636:2: ( ( 'extern' ) )
            {
            // InternalBug360834TestLanguage.g:1636:2: ( ( 'extern' ) )
            // InternalBug360834TestLanguage.g:1637:3: ( 'extern' )
            {
             before(grammarAccess.getAlternativeClassModifiersAccess().getExternExternKeyword_1_2_0()); 
            // InternalBug360834TestLanguage.g:1638:3: ( 'extern' )
            // InternalBug360834TestLanguage.g:1639:4: 'extern'
            {
             before(grammarAccess.getAlternativeClassModifiersAccess().getExternExternKeyword_1_2_0()); 
            match(input,25,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAlternativeClassModifiersAccess().getExternExternKeyword_1_2_0()); 

            }

             after(grammarAccess.getAlternativeClassModifiersAccess().getExternExternKeyword_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeClassModifiers__ExternAssignment_1_2"


    // $ANTLR start "rule__AlternativeClassModifiers__VisibilityAssignment_1_3"
    // InternalBug360834TestLanguage.g:1650:1: rule__AlternativeClassModifiers__VisibilityAssignment_1_3 : ( ruleVisibility ) ;
    public final void rule__AlternativeClassModifiers__VisibilityAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1654:1: ( ( ruleVisibility ) )
            // InternalBug360834TestLanguage.g:1655:2: ( ruleVisibility )
            {
            // InternalBug360834TestLanguage.g:1655:2: ( ruleVisibility )
            // InternalBug360834TestLanguage.g:1656:3: ruleVisibility
            {
             before(grammarAccess.getAlternativeClassModifiersAccess().getVisibilityVisibilityEnumRuleCall_1_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleVisibility();

            state._fsp--;

             after(grammarAccess.getAlternativeClassModifiersAccess().getVisibilityVisibilityEnumRuleCall_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeClassModifiers__VisibilityAssignment_1_3"


    // $ANTLR start "rule__Unordered__NameAssignment_1"
    // InternalBug360834TestLanguage.g:1665:1: rule__Unordered__NameAssignment_1 : ( ruleFQN ) ;
    public final void rule__Unordered__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1669:1: ( ( ruleFQN ) )
            // InternalBug360834TestLanguage.g:1670:2: ( ruleFQN )
            {
            // InternalBug360834TestLanguage.g:1670:2: ( ruleFQN )
            // InternalBug360834TestLanguage.g:1671:3: ruleFQN
            {
             before(grammarAccess.getUnorderedAccess().getNameFQNParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getUnorderedAccess().getNameFQNParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Unordered__NameAssignment_1"


    // $ANTLR start "rule__Unordered__RootDeclarationAssignment_3"
    // InternalBug360834TestLanguage.g:1680:1: rule__Unordered__RootDeclarationAssignment_3 : ( ruleSimpleClassDeclaration ) ;
    public final void rule__Unordered__RootDeclarationAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1684:1: ( ( ruleSimpleClassDeclaration ) )
            // InternalBug360834TestLanguage.g:1685:2: ( ruleSimpleClassDeclaration )
            {
            // InternalBug360834TestLanguage.g:1685:2: ( ruleSimpleClassDeclaration )
            // InternalBug360834TestLanguage.g:1686:3: ruleSimpleClassDeclaration
            {
             before(grammarAccess.getUnorderedAccess().getRootDeclarationSimpleClassDeclarationParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleSimpleClassDeclaration();

            state._fsp--;

             after(grammarAccess.getUnorderedAccess().getRootDeclarationSimpleClassDeclarationParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Unordered__RootDeclarationAssignment_3"


    // $ANTLR start "rule__SimpleClassDeclaration__ModifiersAssignment_0"
    // InternalBug360834TestLanguage.g:1695:1: rule__SimpleClassDeclaration__ModifiersAssignment_0 : ( ruleUnorderedModifiers ) ;
    public final void rule__SimpleClassDeclaration__ModifiersAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1699:1: ( ( ruleUnorderedModifiers ) )
            // InternalBug360834TestLanguage.g:1700:2: ( ruleUnorderedModifiers )
            {
            // InternalBug360834TestLanguage.g:1700:2: ( ruleUnorderedModifiers )
            // InternalBug360834TestLanguage.g:1701:3: ruleUnorderedModifiers
            {
             before(grammarAccess.getSimpleClassDeclarationAccess().getModifiersUnorderedModifiersParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleUnorderedModifiers();

            state._fsp--;

             after(grammarAccess.getSimpleClassDeclarationAccess().getModifiersUnorderedModifiersParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleClassDeclaration__ModifiersAssignment_0"


    // $ANTLR start "rule__SimpleClassDeclaration__NameAssignment_2"
    // InternalBug360834TestLanguage.g:1710:1: rule__SimpleClassDeclaration__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__SimpleClassDeclaration__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1714:1: ( ( RULE_ID ) )
            // InternalBug360834TestLanguage.g:1715:2: ( RULE_ID )
            {
            // InternalBug360834TestLanguage.g:1715:2: ( RULE_ID )
            // InternalBug360834TestLanguage.g:1716:3: RULE_ID
            {
             before(grammarAccess.getSimpleClassDeclarationAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSimpleClassDeclarationAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleClassDeclaration__NameAssignment_2"


    // $ANTLR start "rule__SimpleClassDeclaration__MembersAssignment_4"
    // InternalBug360834TestLanguage.g:1725:1: rule__SimpleClassDeclaration__MembersAssignment_4 : ( ruleClassMember ) ;
    public final void rule__SimpleClassDeclaration__MembersAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1729:1: ( ( ruleClassMember ) )
            // InternalBug360834TestLanguage.g:1730:2: ( ruleClassMember )
            {
            // InternalBug360834TestLanguage.g:1730:2: ( ruleClassMember )
            // InternalBug360834TestLanguage.g:1731:3: ruleClassMember
            {
             before(grammarAccess.getSimpleClassDeclarationAccess().getMembersClassMemberParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleClassMember();

            state._fsp--;

             after(grammarAccess.getSimpleClassDeclarationAccess().getMembersClassMemberParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleClassDeclaration__MembersAssignment_4"


    // $ANTLR start "rule__ClassMember__ModifiersAssignment_0"
    // InternalBug360834TestLanguage.g:1740:1: rule__ClassMember__ModifiersAssignment_0 : ( ruleUnorderedModifiers ) ;
    public final void rule__ClassMember__ModifiersAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1744:1: ( ( ruleUnorderedModifiers ) )
            // InternalBug360834TestLanguage.g:1745:2: ( ruleUnorderedModifiers )
            {
            // InternalBug360834TestLanguage.g:1745:2: ( ruleUnorderedModifiers )
            // InternalBug360834TestLanguage.g:1746:3: ruleUnorderedModifiers
            {
             before(grammarAccess.getClassMemberAccess().getModifiersUnorderedModifiersParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleUnorderedModifiers();

            state._fsp--;

             after(grammarAccess.getClassMemberAccess().getModifiersUnorderedModifiersParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMember__ModifiersAssignment_0"


    // $ANTLR start "rule__ClassMember__NameAssignment_2"
    // InternalBug360834TestLanguage.g:1755:1: rule__ClassMember__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ClassMember__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1759:1: ( ( RULE_ID ) )
            // InternalBug360834TestLanguage.g:1760:2: ( RULE_ID )
            {
            // InternalBug360834TestLanguage.g:1760:2: ( RULE_ID )
            // InternalBug360834TestLanguage.g:1761:3: RULE_ID
            {
             before(grammarAccess.getClassMemberAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassMemberAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMember__NameAssignment_2"


    // $ANTLR start "rule__UnorderedModifiers__FinalAssignment_1_0"
    // InternalBug360834TestLanguage.g:1770:1: rule__UnorderedModifiers__FinalAssignment_1_0 : ( ( 'final' ) ) ;
    public final void rule__UnorderedModifiers__FinalAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1774:1: ( ( ( 'final' ) ) )
            // InternalBug360834TestLanguage.g:1775:2: ( ( 'final' ) )
            {
            // InternalBug360834TestLanguage.g:1775:2: ( ( 'final' ) )
            // InternalBug360834TestLanguage.g:1776:3: ( 'final' )
            {
             before(grammarAccess.getUnorderedModifiersAccess().getFinalFinalKeyword_1_0_0()); 
            // InternalBug360834TestLanguage.g:1777:3: ( 'final' )
            // InternalBug360834TestLanguage.g:1778:4: 'final'
            {
             before(grammarAccess.getUnorderedModifiersAccess().getFinalFinalKeyword_1_0_0()); 
            match(input,23,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getUnorderedModifiersAccess().getFinalFinalKeyword_1_0_0()); 

            }

             after(grammarAccess.getUnorderedModifiersAccess().getFinalFinalKeyword_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedModifiers__FinalAssignment_1_0"


    // $ANTLR start "rule__UnorderedModifiers__AbstractAssignment_1_1"
    // InternalBug360834TestLanguage.g:1789:1: rule__UnorderedModifiers__AbstractAssignment_1_1 : ( ( 'abstract' ) ) ;
    public final void rule__UnorderedModifiers__AbstractAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1793:1: ( ( ( 'abstract' ) ) )
            // InternalBug360834TestLanguage.g:1794:2: ( ( 'abstract' ) )
            {
            // InternalBug360834TestLanguage.g:1794:2: ( ( 'abstract' ) )
            // InternalBug360834TestLanguage.g:1795:3: ( 'abstract' )
            {
             before(grammarAccess.getUnorderedModifiersAccess().getAbstractAbstractKeyword_1_1_0()); 
            // InternalBug360834TestLanguage.g:1796:3: ( 'abstract' )
            // InternalBug360834TestLanguage.g:1797:4: 'abstract'
            {
             before(grammarAccess.getUnorderedModifiersAccess().getAbstractAbstractKeyword_1_1_0()); 
            match(input,24,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getUnorderedModifiersAccess().getAbstractAbstractKeyword_1_1_0()); 

            }

             after(grammarAccess.getUnorderedModifiersAccess().getAbstractAbstractKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedModifiers__AbstractAssignment_1_1"


    // $ANTLR start "rule__UnorderedModifiers__ExternAssignment_1_2"
    // InternalBug360834TestLanguage.g:1808:1: rule__UnorderedModifiers__ExternAssignment_1_2 : ( ( 'extern' ) ) ;
    public final void rule__UnorderedModifiers__ExternAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1812:1: ( ( ( 'extern' ) ) )
            // InternalBug360834TestLanguage.g:1813:2: ( ( 'extern' ) )
            {
            // InternalBug360834TestLanguage.g:1813:2: ( ( 'extern' ) )
            // InternalBug360834TestLanguage.g:1814:3: ( 'extern' )
            {
             before(grammarAccess.getUnorderedModifiersAccess().getExternExternKeyword_1_2_0()); 
            // InternalBug360834TestLanguage.g:1815:3: ( 'extern' )
            // InternalBug360834TestLanguage.g:1816:4: 'extern'
            {
             before(grammarAccess.getUnorderedModifiersAccess().getExternExternKeyword_1_2_0()); 
            match(input,25,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getUnorderedModifiersAccess().getExternExternKeyword_1_2_0()); 

            }

             after(grammarAccess.getUnorderedModifiersAccess().getExternExternKeyword_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedModifiers__ExternAssignment_1_2"


    // $ANTLR start "rule__UnorderedModifiers__VisibilityAssignment_1_3"
    // InternalBug360834TestLanguage.g:1827:1: rule__UnorderedModifiers__VisibilityAssignment_1_3 : ( ruleVisibility ) ;
    public final void rule__UnorderedModifiers__VisibilityAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1831:1: ( ( ruleVisibility ) )
            // InternalBug360834TestLanguage.g:1832:2: ( ruleVisibility )
            {
            // InternalBug360834TestLanguage.g:1832:2: ( ruleVisibility )
            // InternalBug360834TestLanguage.g:1833:3: ruleVisibility
            {
             before(grammarAccess.getUnorderedModifiersAccess().getVisibilityVisibilityEnumRuleCall_1_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleVisibility();

            state._fsp--;

             after(grammarAccess.getUnorderedModifiersAccess().getVisibilityVisibilityEnumRuleCall_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedModifiers__VisibilityAssignment_1_3"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000003803800L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000003A03800L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000003803802L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000400000L});
    }


}
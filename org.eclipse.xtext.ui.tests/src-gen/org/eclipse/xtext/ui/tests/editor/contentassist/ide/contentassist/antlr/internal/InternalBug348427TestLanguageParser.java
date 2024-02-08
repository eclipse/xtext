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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug348427TestLanguageGrammarAccess;



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
public class InternalBug348427TestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'a'", "'b'", "'1.1'", "'next'", "'1.2'", "'1.3'", "'1.4'", "':'", "'child1'", "'end'", "'keyword'", "'child2'", "'child3'", "'2.1'", "'2.2'", "'2.3'", "'2.4'", "'2.5'", "'2.6'", "'2.7'", "'2.8'", "'bool'"
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
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
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


        public InternalBug348427TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug348427TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug348427TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug348427TestLanguage.g"; }


    	private Bug348427TestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(Bug348427TestLanguageGrammarAccess grammarAccess) {
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
    // InternalBug348427TestLanguage.g:58:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:59:1: ( ruleModel EOF )
            // InternalBug348427TestLanguage.g:60:1: ruleModel EOF
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
    // InternalBug348427TestLanguage.g:67:1: ruleModel : ( ( rule__Model__Alternatives ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:71:2: ( ( ( rule__Model__Alternatives ) ) )
            // InternalBug348427TestLanguage.g:72:2: ( ( rule__Model__Alternatives ) )
            {
            // InternalBug348427TestLanguage.g:72:2: ( ( rule__Model__Alternatives ) )
            // InternalBug348427TestLanguage.g:73:3: ( rule__Model__Alternatives )
            {
             before(grammarAccess.getModelAccess().getAlternatives()); 
            // InternalBug348427TestLanguage.g:74:3: ( rule__Model__Alternatives )
            // InternalBug348427TestLanguage.g:74:4: rule__Model__Alternatives
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


    // $ANTLR start "entryRuleScenario1_1"
    // InternalBug348427TestLanguage.g:83:1: entryRuleScenario1_1 : ruleScenario1_1 EOF ;
    public final void entryRuleScenario1_1() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:84:1: ( ruleScenario1_1 EOF )
            // InternalBug348427TestLanguage.g:85:1: ruleScenario1_1 EOF
            {
             before(grammarAccess.getScenario1_1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleScenario1_1();

            state._fsp--;

             after(grammarAccess.getScenario1_1Rule()); 
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
    // $ANTLR end "entryRuleScenario1_1"


    // $ANTLR start "ruleScenario1_1"
    // InternalBug348427TestLanguage.g:92:1: ruleScenario1_1 : ( ( rule__Scenario1_1__Group__0 ) ) ;
    public final void ruleScenario1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:96:2: ( ( ( rule__Scenario1_1__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:97:2: ( ( rule__Scenario1_1__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:97:2: ( ( rule__Scenario1_1__Group__0 ) )
            // InternalBug348427TestLanguage.g:98:3: ( rule__Scenario1_1__Group__0 )
            {
             before(grammarAccess.getScenario1_1Access().getGroup()); 
            // InternalBug348427TestLanguage.g:99:3: ( rule__Scenario1_1__Group__0 )
            // InternalBug348427TestLanguage.g:99:4: rule__Scenario1_1__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario1_1__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getScenario1_1Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleScenario1_1"


    // $ANTLR start "entryRuleScenario1_2"
    // InternalBug348427TestLanguage.g:108:1: entryRuleScenario1_2 : ruleScenario1_2 EOF ;
    public final void entryRuleScenario1_2() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:109:1: ( ruleScenario1_2 EOF )
            // InternalBug348427TestLanguage.g:110:1: ruleScenario1_2 EOF
            {
             before(grammarAccess.getScenario1_2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleScenario1_2();

            state._fsp--;

             after(grammarAccess.getScenario1_2Rule()); 
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
    // $ANTLR end "entryRuleScenario1_2"


    // $ANTLR start "ruleScenario1_2"
    // InternalBug348427TestLanguage.g:117:1: ruleScenario1_2 : ( ( rule__Scenario1_2__Group__0 ) ) ;
    public final void ruleScenario1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:121:2: ( ( ( rule__Scenario1_2__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:122:2: ( ( rule__Scenario1_2__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:122:2: ( ( rule__Scenario1_2__Group__0 ) )
            // InternalBug348427TestLanguage.g:123:3: ( rule__Scenario1_2__Group__0 )
            {
             before(grammarAccess.getScenario1_2Access().getGroup()); 
            // InternalBug348427TestLanguage.g:124:3: ( rule__Scenario1_2__Group__0 )
            // InternalBug348427TestLanguage.g:124:4: rule__Scenario1_2__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario1_2__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getScenario1_2Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleScenario1_2"


    // $ANTLR start "entryRuleScenario1_3"
    // InternalBug348427TestLanguage.g:133:1: entryRuleScenario1_3 : ruleScenario1_3 EOF ;
    public final void entryRuleScenario1_3() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:134:1: ( ruleScenario1_3 EOF )
            // InternalBug348427TestLanguage.g:135:1: ruleScenario1_3 EOF
            {
             before(grammarAccess.getScenario1_3Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleScenario1_3();

            state._fsp--;

             after(grammarAccess.getScenario1_3Rule()); 
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
    // $ANTLR end "entryRuleScenario1_3"


    // $ANTLR start "ruleScenario1_3"
    // InternalBug348427TestLanguage.g:142:1: ruleScenario1_3 : ( ( rule__Scenario1_3__Group__0 ) ) ;
    public final void ruleScenario1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:146:2: ( ( ( rule__Scenario1_3__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:147:2: ( ( rule__Scenario1_3__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:147:2: ( ( rule__Scenario1_3__Group__0 ) )
            // InternalBug348427TestLanguage.g:148:3: ( rule__Scenario1_3__Group__0 )
            {
             before(grammarAccess.getScenario1_3Access().getGroup()); 
            // InternalBug348427TestLanguage.g:149:3: ( rule__Scenario1_3__Group__0 )
            // InternalBug348427TestLanguage.g:149:4: rule__Scenario1_3__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario1_3__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getScenario1_3Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleScenario1_3"


    // $ANTLR start "entryRuleScenario1_4"
    // InternalBug348427TestLanguage.g:158:1: entryRuleScenario1_4 : ruleScenario1_4 EOF ;
    public final void entryRuleScenario1_4() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:159:1: ( ruleScenario1_4 EOF )
            // InternalBug348427TestLanguage.g:160:1: ruleScenario1_4 EOF
            {
             before(grammarAccess.getScenario1_4Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleScenario1_4();

            state._fsp--;

             after(grammarAccess.getScenario1_4Rule()); 
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
    // $ANTLR end "entryRuleScenario1_4"


    // $ANTLR start "ruleScenario1_4"
    // InternalBug348427TestLanguage.g:167:1: ruleScenario1_4 : ( ( rule__Scenario1_4__Group__0 ) ) ;
    public final void ruleScenario1_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:171:2: ( ( ( rule__Scenario1_4__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:172:2: ( ( rule__Scenario1_4__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:172:2: ( ( rule__Scenario1_4__Group__0 ) )
            // InternalBug348427TestLanguage.g:173:3: ( rule__Scenario1_4__Group__0 )
            {
             before(grammarAccess.getScenario1_4Access().getGroup()); 
            // InternalBug348427TestLanguage.g:174:3: ( rule__Scenario1_4__Group__0 )
            // InternalBug348427TestLanguage.g:174:4: rule__Scenario1_4__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario1_4__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getScenario1_4Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleScenario1_4"


    // $ANTLR start "entryRuleChild1_1"
    // InternalBug348427TestLanguage.g:183:1: entryRuleChild1_1 : ruleChild1_1 EOF ;
    public final void entryRuleChild1_1() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:184:1: ( ruleChild1_1 EOF )
            // InternalBug348427TestLanguage.g:185:1: ruleChild1_1 EOF
            {
             before(grammarAccess.getChild1_1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleChild1_1();

            state._fsp--;

             after(grammarAccess.getChild1_1Rule()); 
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
    // $ANTLR end "entryRuleChild1_1"


    // $ANTLR start "ruleChild1_1"
    // InternalBug348427TestLanguage.g:192:1: ruleChild1_1 : ( ( rule__Child1_1__Group__0 ) ) ;
    public final void ruleChild1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:196:2: ( ( ( rule__Child1_1__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:197:2: ( ( rule__Child1_1__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:197:2: ( ( rule__Child1_1__Group__0 ) )
            // InternalBug348427TestLanguage.g:198:3: ( rule__Child1_1__Group__0 )
            {
             before(grammarAccess.getChild1_1Access().getGroup()); 
            // InternalBug348427TestLanguage.g:199:3: ( rule__Child1_1__Group__0 )
            // InternalBug348427TestLanguage.g:199:4: rule__Child1_1__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child1_1__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getChild1_1Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleChild1_1"


    // $ANTLR start "entryRuleChild1_2"
    // InternalBug348427TestLanguage.g:208:1: entryRuleChild1_2 : ruleChild1_2 EOF ;
    public final void entryRuleChild1_2() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:209:1: ( ruleChild1_2 EOF )
            // InternalBug348427TestLanguage.g:210:1: ruleChild1_2 EOF
            {
             before(grammarAccess.getChild1_2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleChild1_2();

            state._fsp--;

             after(grammarAccess.getChild1_2Rule()); 
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
    // $ANTLR end "entryRuleChild1_2"


    // $ANTLR start "ruleChild1_2"
    // InternalBug348427TestLanguage.g:217:1: ruleChild1_2 : ( ( rule__Child1_2__Group__0 ) ) ;
    public final void ruleChild1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:221:2: ( ( ( rule__Child1_2__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:222:2: ( ( rule__Child1_2__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:222:2: ( ( rule__Child1_2__Group__0 ) )
            // InternalBug348427TestLanguage.g:223:3: ( rule__Child1_2__Group__0 )
            {
             before(grammarAccess.getChild1_2Access().getGroup()); 
            // InternalBug348427TestLanguage.g:224:3: ( rule__Child1_2__Group__0 )
            // InternalBug348427TestLanguage.g:224:4: rule__Child1_2__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child1_2__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getChild1_2Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleChild1_2"


    // $ANTLR start "entryRuleChild1_3"
    // InternalBug348427TestLanguage.g:233:1: entryRuleChild1_3 : ruleChild1_3 EOF ;
    public final void entryRuleChild1_3() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:234:1: ( ruleChild1_3 EOF )
            // InternalBug348427TestLanguage.g:235:1: ruleChild1_3 EOF
            {
             before(grammarAccess.getChild1_3Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleChild1_3();

            state._fsp--;

             after(grammarAccess.getChild1_3Rule()); 
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
    // $ANTLR end "entryRuleChild1_3"


    // $ANTLR start "ruleChild1_3"
    // InternalBug348427TestLanguage.g:242:1: ruleChild1_3 : ( ( rule__Child1_3__Group__0 ) ) ;
    public final void ruleChild1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:246:2: ( ( ( rule__Child1_3__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:247:2: ( ( rule__Child1_3__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:247:2: ( ( rule__Child1_3__Group__0 ) )
            // InternalBug348427TestLanguage.g:248:3: ( rule__Child1_3__Group__0 )
            {
             before(grammarAccess.getChild1_3Access().getGroup()); 
            // InternalBug348427TestLanguage.g:249:3: ( rule__Child1_3__Group__0 )
            // InternalBug348427TestLanguage.g:249:4: rule__Child1_3__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child1_3__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getChild1_3Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleChild1_3"


    // $ANTLR start "entryRuleScenario2_1"
    // InternalBug348427TestLanguage.g:258:1: entryRuleScenario2_1 : ruleScenario2_1 EOF ;
    public final void entryRuleScenario2_1() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:259:1: ( ruleScenario2_1 EOF )
            // InternalBug348427TestLanguage.g:260:1: ruleScenario2_1 EOF
            {
             before(grammarAccess.getScenario2_1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleScenario2_1();

            state._fsp--;

             after(grammarAccess.getScenario2_1Rule()); 
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
    // $ANTLR end "entryRuleScenario2_1"


    // $ANTLR start "ruleScenario2_1"
    // InternalBug348427TestLanguage.g:267:1: ruleScenario2_1 : ( ( rule__Scenario2_1__Group__0 ) ) ;
    public final void ruleScenario2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:271:2: ( ( ( rule__Scenario2_1__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:272:2: ( ( rule__Scenario2_1__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:272:2: ( ( rule__Scenario2_1__Group__0 ) )
            // InternalBug348427TestLanguage.g:273:3: ( rule__Scenario2_1__Group__0 )
            {
             before(grammarAccess.getScenario2_1Access().getGroup()); 
            // InternalBug348427TestLanguage.g:274:3: ( rule__Scenario2_1__Group__0 )
            // InternalBug348427TestLanguage.g:274:4: rule__Scenario2_1__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario2_1__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getScenario2_1Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleScenario2_1"


    // $ANTLR start "entryRuleScenario2_2"
    // InternalBug348427TestLanguage.g:283:1: entryRuleScenario2_2 : ruleScenario2_2 EOF ;
    public final void entryRuleScenario2_2() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:284:1: ( ruleScenario2_2 EOF )
            // InternalBug348427TestLanguage.g:285:1: ruleScenario2_2 EOF
            {
             before(grammarAccess.getScenario2_2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleScenario2_2();

            state._fsp--;

             after(grammarAccess.getScenario2_2Rule()); 
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
    // $ANTLR end "entryRuleScenario2_2"


    // $ANTLR start "ruleScenario2_2"
    // InternalBug348427TestLanguage.g:292:1: ruleScenario2_2 : ( ( rule__Scenario2_2__Group__0 ) ) ;
    public final void ruleScenario2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:296:2: ( ( ( rule__Scenario2_2__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:297:2: ( ( rule__Scenario2_2__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:297:2: ( ( rule__Scenario2_2__Group__0 ) )
            // InternalBug348427TestLanguage.g:298:3: ( rule__Scenario2_2__Group__0 )
            {
             before(grammarAccess.getScenario2_2Access().getGroup()); 
            // InternalBug348427TestLanguage.g:299:3: ( rule__Scenario2_2__Group__0 )
            // InternalBug348427TestLanguage.g:299:4: rule__Scenario2_2__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario2_2__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getScenario2_2Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleScenario2_2"


    // $ANTLR start "entryRuleScenario2_3"
    // InternalBug348427TestLanguage.g:308:1: entryRuleScenario2_3 : ruleScenario2_3 EOF ;
    public final void entryRuleScenario2_3() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:309:1: ( ruleScenario2_3 EOF )
            // InternalBug348427TestLanguage.g:310:1: ruleScenario2_3 EOF
            {
             before(grammarAccess.getScenario2_3Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleScenario2_3();

            state._fsp--;

             after(grammarAccess.getScenario2_3Rule()); 
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
    // $ANTLR end "entryRuleScenario2_3"


    // $ANTLR start "ruleScenario2_3"
    // InternalBug348427TestLanguage.g:317:1: ruleScenario2_3 : ( ( rule__Scenario2_3__Group__0 ) ) ;
    public final void ruleScenario2_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:321:2: ( ( ( rule__Scenario2_3__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:322:2: ( ( rule__Scenario2_3__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:322:2: ( ( rule__Scenario2_3__Group__0 ) )
            // InternalBug348427TestLanguage.g:323:3: ( rule__Scenario2_3__Group__0 )
            {
             before(grammarAccess.getScenario2_3Access().getGroup()); 
            // InternalBug348427TestLanguage.g:324:3: ( rule__Scenario2_3__Group__0 )
            // InternalBug348427TestLanguage.g:324:4: rule__Scenario2_3__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario2_3__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getScenario2_3Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleScenario2_3"


    // $ANTLR start "entryRuleScenario2_4"
    // InternalBug348427TestLanguage.g:333:1: entryRuleScenario2_4 : ruleScenario2_4 EOF ;
    public final void entryRuleScenario2_4() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:334:1: ( ruleScenario2_4 EOF )
            // InternalBug348427TestLanguage.g:335:1: ruleScenario2_4 EOF
            {
             before(grammarAccess.getScenario2_4Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleScenario2_4();

            state._fsp--;

             after(grammarAccess.getScenario2_4Rule()); 
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
    // $ANTLR end "entryRuleScenario2_4"


    // $ANTLR start "ruleScenario2_4"
    // InternalBug348427TestLanguage.g:342:1: ruleScenario2_4 : ( ( rule__Scenario2_4__Group__0 ) ) ;
    public final void ruleScenario2_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:346:2: ( ( ( rule__Scenario2_4__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:347:2: ( ( rule__Scenario2_4__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:347:2: ( ( rule__Scenario2_4__Group__0 ) )
            // InternalBug348427TestLanguage.g:348:3: ( rule__Scenario2_4__Group__0 )
            {
             before(grammarAccess.getScenario2_4Access().getGroup()); 
            // InternalBug348427TestLanguage.g:349:3: ( rule__Scenario2_4__Group__0 )
            // InternalBug348427TestLanguage.g:349:4: rule__Scenario2_4__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario2_4__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getScenario2_4Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleScenario2_4"


    // $ANTLR start "entryRuleScenario2_5"
    // InternalBug348427TestLanguage.g:358:1: entryRuleScenario2_5 : ruleScenario2_5 EOF ;
    public final void entryRuleScenario2_5() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:359:1: ( ruleScenario2_5 EOF )
            // InternalBug348427TestLanguage.g:360:1: ruleScenario2_5 EOF
            {
             before(grammarAccess.getScenario2_5Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleScenario2_5();

            state._fsp--;

             after(grammarAccess.getScenario2_5Rule()); 
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
    // $ANTLR end "entryRuleScenario2_5"


    // $ANTLR start "ruleScenario2_5"
    // InternalBug348427TestLanguage.g:367:1: ruleScenario2_5 : ( ( rule__Scenario2_5__Group__0 ) ) ;
    public final void ruleScenario2_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:371:2: ( ( ( rule__Scenario2_5__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:372:2: ( ( rule__Scenario2_5__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:372:2: ( ( rule__Scenario2_5__Group__0 ) )
            // InternalBug348427TestLanguage.g:373:3: ( rule__Scenario2_5__Group__0 )
            {
             before(grammarAccess.getScenario2_5Access().getGroup()); 
            // InternalBug348427TestLanguage.g:374:3: ( rule__Scenario2_5__Group__0 )
            // InternalBug348427TestLanguage.g:374:4: rule__Scenario2_5__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario2_5__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getScenario2_5Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleScenario2_5"


    // $ANTLR start "entryRuleScenario2_6"
    // InternalBug348427TestLanguage.g:383:1: entryRuleScenario2_6 : ruleScenario2_6 EOF ;
    public final void entryRuleScenario2_6() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:384:1: ( ruleScenario2_6 EOF )
            // InternalBug348427TestLanguage.g:385:1: ruleScenario2_6 EOF
            {
             before(grammarAccess.getScenario2_6Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleScenario2_6();

            state._fsp--;

             after(grammarAccess.getScenario2_6Rule()); 
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
    // $ANTLR end "entryRuleScenario2_6"


    // $ANTLR start "ruleScenario2_6"
    // InternalBug348427TestLanguage.g:392:1: ruleScenario2_6 : ( ( rule__Scenario2_6__Group__0 ) ) ;
    public final void ruleScenario2_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:396:2: ( ( ( rule__Scenario2_6__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:397:2: ( ( rule__Scenario2_6__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:397:2: ( ( rule__Scenario2_6__Group__0 ) )
            // InternalBug348427TestLanguage.g:398:3: ( rule__Scenario2_6__Group__0 )
            {
             before(grammarAccess.getScenario2_6Access().getGroup()); 
            // InternalBug348427TestLanguage.g:399:3: ( rule__Scenario2_6__Group__0 )
            // InternalBug348427TestLanguage.g:399:4: rule__Scenario2_6__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario2_6__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getScenario2_6Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleScenario2_6"


    // $ANTLR start "entryRuleScenario2_7"
    // InternalBug348427TestLanguage.g:408:1: entryRuleScenario2_7 : ruleScenario2_7 EOF ;
    public final void entryRuleScenario2_7() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:409:1: ( ruleScenario2_7 EOF )
            // InternalBug348427TestLanguage.g:410:1: ruleScenario2_7 EOF
            {
             before(grammarAccess.getScenario2_7Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleScenario2_7();

            state._fsp--;

             after(grammarAccess.getScenario2_7Rule()); 
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
    // $ANTLR end "entryRuleScenario2_7"


    // $ANTLR start "ruleScenario2_7"
    // InternalBug348427TestLanguage.g:417:1: ruleScenario2_7 : ( ( rule__Scenario2_7__Group__0 ) ) ;
    public final void ruleScenario2_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:421:2: ( ( ( rule__Scenario2_7__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:422:2: ( ( rule__Scenario2_7__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:422:2: ( ( rule__Scenario2_7__Group__0 ) )
            // InternalBug348427TestLanguage.g:423:3: ( rule__Scenario2_7__Group__0 )
            {
             before(grammarAccess.getScenario2_7Access().getGroup()); 
            // InternalBug348427TestLanguage.g:424:3: ( rule__Scenario2_7__Group__0 )
            // InternalBug348427TestLanguage.g:424:4: rule__Scenario2_7__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario2_7__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getScenario2_7Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleScenario2_7"


    // $ANTLR start "entryRuleScenario2_8"
    // InternalBug348427TestLanguage.g:433:1: entryRuleScenario2_8 : ruleScenario2_8 EOF ;
    public final void entryRuleScenario2_8() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:434:1: ( ruleScenario2_8 EOF )
            // InternalBug348427TestLanguage.g:435:1: ruleScenario2_8 EOF
            {
             before(grammarAccess.getScenario2_8Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleScenario2_8();

            state._fsp--;

             after(grammarAccess.getScenario2_8Rule()); 
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
    // $ANTLR end "entryRuleScenario2_8"


    // $ANTLR start "ruleScenario2_8"
    // InternalBug348427TestLanguage.g:442:1: ruleScenario2_8 : ( ( rule__Scenario2_8__Group__0 ) ) ;
    public final void ruleScenario2_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:446:2: ( ( ( rule__Scenario2_8__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:447:2: ( ( rule__Scenario2_8__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:447:2: ( ( rule__Scenario2_8__Group__0 ) )
            // InternalBug348427TestLanguage.g:448:3: ( rule__Scenario2_8__Group__0 )
            {
             before(grammarAccess.getScenario2_8Access().getGroup()); 
            // InternalBug348427TestLanguage.g:449:3: ( rule__Scenario2_8__Group__0 )
            // InternalBug348427TestLanguage.g:449:4: rule__Scenario2_8__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario2_8__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getScenario2_8Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleScenario2_8"


    // $ANTLR start "entryRuleChild2_1"
    // InternalBug348427TestLanguage.g:458:1: entryRuleChild2_1 : ruleChild2_1 EOF ;
    public final void entryRuleChild2_1() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:459:1: ( ruleChild2_1 EOF )
            // InternalBug348427TestLanguage.g:460:1: ruleChild2_1 EOF
            {
             before(grammarAccess.getChild2_1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleChild2_1();

            state._fsp--;

             after(grammarAccess.getChild2_1Rule()); 
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
    // $ANTLR end "entryRuleChild2_1"


    // $ANTLR start "ruleChild2_1"
    // InternalBug348427TestLanguage.g:467:1: ruleChild2_1 : ( ( rule__Child2_1__Group__0 ) ) ;
    public final void ruleChild2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:471:2: ( ( ( rule__Child2_1__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:472:2: ( ( rule__Child2_1__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:472:2: ( ( rule__Child2_1__Group__0 ) )
            // InternalBug348427TestLanguage.g:473:3: ( rule__Child2_1__Group__0 )
            {
             before(grammarAccess.getChild2_1Access().getGroup()); 
            // InternalBug348427TestLanguage.g:474:3: ( rule__Child2_1__Group__0 )
            // InternalBug348427TestLanguage.g:474:4: rule__Child2_1__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_1__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getChild2_1Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleChild2_1"


    // $ANTLR start "entryRuleChild2_2"
    // InternalBug348427TestLanguage.g:483:1: entryRuleChild2_2 : ruleChild2_2 EOF ;
    public final void entryRuleChild2_2() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:484:1: ( ruleChild2_2 EOF )
            // InternalBug348427TestLanguage.g:485:1: ruleChild2_2 EOF
            {
             before(grammarAccess.getChild2_2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleChild2_2();

            state._fsp--;

             after(grammarAccess.getChild2_2Rule()); 
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
    // $ANTLR end "entryRuleChild2_2"


    // $ANTLR start "ruleChild2_2"
    // InternalBug348427TestLanguage.g:492:1: ruleChild2_2 : ( ( rule__Child2_2__Group__0 ) ) ;
    public final void ruleChild2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:496:2: ( ( ( rule__Child2_2__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:497:2: ( ( rule__Child2_2__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:497:2: ( ( rule__Child2_2__Group__0 ) )
            // InternalBug348427TestLanguage.g:498:3: ( rule__Child2_2__Group__0 )
            {
             before(grammarAccess.getChild2_2Access().getGroup()); 
            // InternalBug348427TestLanguage.g:499:3: ( rule__Child2_2__Group__0 )
            // InternalBug348427TestLanguage.g:499:4: rule__Child2_2__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_2__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getChild2_2Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleChild2_2"


    // $ANTLR start "entryRuleChild2_3"
    // InternalBug348427TestLanguage.g:508:1: entryRuleChild2_3 : ruleChild2_3 EOF ;
    public final void entryRuleChild2_3() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:509:1: ( ruleChild2_3 EOF )
            // InternalBug348427TestLanguage.g:510:1: ruleChild2_3 EOF
            {
             before(grammarAccess.getChild2_3Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleChild2_3();

            state._fsp--;

             after(grammarAccess.getChild2_3Rule()); 
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
    // $ANTLR end "entryRuleChild2_3"


    // $ANTLR start "ruleChild2_3"
    // InternalBug348427TestLanguage.g:517:1: ruleChild2_3 : ( ( rule__Child2_3__Group__0 ) ) ;
    public final void ruleChild2_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:521:2: ( ( ( rule__Child2_3__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:522:2: ( ( rule__Child2_3__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:522:2: ( ( rule__Child2_3__Group__0 ) )
            // InternalBug348427TestLanguage.g:523:3: ( rule__Child2_3__Group__0 )
            {
             before(grammarAccess.getChild2_3Access().getGroup()); 
            // InternalBug348427TestLanguage.g:524:3: ( rule__Child2_3__Group__0 )
            // InternalBug348427TestLanguage.g:524:4: rule__Child2_3__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_3__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getChild2_3Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleChild2_3"


    // $ANTLR start "entryRuleChild2_4"
    // InternalBug348427TestLanguage.g:533:1: entryRuleChild2_4 : ruleChild2_4 EOF ;
    public final void entryRuleChild2_4() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:534:1: ( ruleChild2_4 EOF )
            // InternalBug348427TestLanguage.g:535:1: ruleChild2_4 EOF
            {
             before(grammarAccess.getChild2_4Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleChild2_4();

            state._fsp--;

             after(grammarAccess.getChild2_4Rule()); 
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
    // $ANTLR end "entryRuleChild2_4"


    // $ANTLR start "ruleChild2_4"
    // InternalBug348427TestLanguage.g:542:1: ruleChild2_4 : ( ( rule__Child2_4__Group__0 ) ) ;
    public final void ruleChild2_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:546:2: ( ( ( rule__Child2_4__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:547:2: ( ( rule__Child2_4__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:547:2: ( ( rule__Child2_4__Group__0 ) )
            // InternalBug348427TestLanguage.g:548:3: ( rule__Child2_4__Group__0 )
            {
             before(grammarAccess.getChild2_4Access().getGroup()); 
            // InternalBug348427TestLanguage.g:549:3: ( rule__Child2_4__Group__0 )
            // InternalBug348427TestLanguage.g:549:4: rule__Child2_4__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_4__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getChild2_4Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleChild2_4"


    // $ANTLR start "entryRuleChild2_5"
    // InternalBug348427TestLanguage.g:558:1: entryRuleChild2_5 : ruleChild2_5 EOF ;
    public final void entryRuleChild2_5() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:559:1: ( ruleChild2_5 EOF )
            // InternalBug348427TestLanguage.g:560:1: ruleChild2_5 EOF
            {
             before(grammarAccess.getChild2_5Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleChild2_5();

            state._fsp--;

             after(grammarAccess.getChild2_5Rule()); 
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
    // $ANTLR end "entryRuleChild2_5"


    // $ANTLR start "ruleChild2_5"
    // InternalBug348427TestLanguage.g:567:1: ruleChild2_5 : ( ( rule__Child2_5__Group__0 ) ) ;
    public final void ruleChild2_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:571:2: ( ( ( rule__Child2_5__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:572:2: ( ( rule__Child2_5__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:572:2: ( ( rule__Child2_5__Group__0 ) )
            // InternalBug348427TestLanguage.g:573:3: ( rule__Child2_5__Group__0 )
            {
             before(grammarAccess.getChild2_5Access().getGroup()); 
            // InternalBug348427TestLanguage.g:574:3: ( rule__Child2_5__Group__0 )
            // InternalBug348427TestLanguage.g:574:4: rule__Child2_5__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_5__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getChild2_5Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleChild2_5"


    // $ANTLR start "entryRuleChild2_6"
    // InternalBug348427TestLanguage.g:583:1: entryRuleChild2_6 : ruleChild2_6 EOF ;
    public final void entryRuleChild2_6() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:584:1: ( ruleChild2_6 EOF )
            // InternalBug348427TestLanguage.g:585:1: ruleChild2_6 EOF
            {
             before(grammarAccess.getChild2_6Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleChild2_6();

            state._fsp--;

             after(grammarAccess.getChild2_6Rule()); 
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
    // $ANTLR end "entryRuleChild2_6"


    // $ANTLR start "ruleChild2_6"
    // InternalBug348427TestLanguage.g:592:1: ruleChild2_6 : ( ( rule__Child2_6__Group__0 ) ) ;
    public final void ruleChild2_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:596:2: ( ( ( rule__Child2_6__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:597:2: ( ( rule__Child2_6__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:597:2: ( ( rule__Child2_6__Group__0 ) )
            // InternalBug348427TestLanguage.g:598:3: ( rule__Child2_6__Group__0 )
            {
             before(grammarAccess.getChild2_6Access().getGroup()); 
            // InternalBug348427TestLanguage.g:599:3: ( rule__Child2_6__Group__0 )
            // InternalBug348427TestLanguage.g:599:4: rule__Child2_6__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_6__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getChild2_6Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleChild2_6"


    // $ANTLR start "ruleEnumType"
    // InternalBug348427TestLanguage.g:608:1: ruleEnumType : ( ( rule__EnumType__Alternatives ) ) ;
    public final void ruleEnumType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:612:1: ( ( ( rule__EnumType__Alternatives ) ) )
            // InternalBug348427TestLanguage.g:613:2: ( ( rule__EnumType__Alternatives ) )
            {
            // InternalBug348427TestLanguage.g:613:2: ( ( rule__EnumType__Alternatives ) )
            // InternalBug348427TestLanguage.g:614:3: ( rule__EnumType__Alternatives )
            {
             before(grammarAccess.getEnumTypeAccess().getAlternatives()); 
            // InternalBug348427TestLanguage.g:615:3: ( rule__EnumType__Alternatives )
            // InternalBug348427TestLanguage.g:615:4: rule__EnumType__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEnumTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEnumType"


    // $ANTLR start "rule__Model__Alternatives"
    // InternalBug348427TestLanguage.g:623:1: rule__Model__Alternatives : ( ( ( rule__Model__Element1Assignment_0 ) ) | ( ( rule__Model__Element1Assignment_1 ) ) | ( ( rule__Model__Element1Assignment_2 ) ) | ( ( rule__Model__Element1Assignment_3 ) ) | ( ( rule__Model__Element2Assignment_4 ) ) | ( ( rule__Model__Element2Assignment_5 ) ) | ( ( rule__Model__Element2Assignment_6 ) ) | ( ( rule__Model__Element2Assignment_7 ) ) | ( ( rule__Model__Element2Assignment_8 ) ) | ( ( rule__Model__Element2Assignment_9 ) ) | ( ( rule__Model__Element2Assignment_10 ) ) | ( ( rule__Model__Element2Assignment_11 ) ) );
    public final void rule__Model__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:627:1: ( ( ( rule__Model__Element1Assignment_0 ) ) | ( ( rule__Model__Element1Assignment_1 ) ) | ( ( rule__Model__Element1Assignment_2 ) ) | ( ( rule__Model__Element1Assignment_3 ) ) | ( ( rule__Model__Element2Assignment_4 ) ) | ( ( rule__Model__Element2Assignment_5 ) ) | ( ( rule__Model__Element2Assignment_6 ) ) | ( ( rule__Model__Element2Assignment_7 ) ) | ( ( rule__Model__Element2Assignment_8 ) ) | ( ( rule__Model__Element2Assignment_9 ) ) | ( ( rule__Model__Element2Assignment_10 ) ) | ( ( rule__Model__Element2Assignment_11 ) ) )
            int alt1=12;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt1=1;
                }
                break;
            case 15:
                {
                alt1=2;
                }
                break;
            case 16:
                {
                alt1=3;
                }
                break;
            case 17:
                {
                alt1=4;
                }
                break;
            case 24:
                {
                alt1=5;
                }
                break;
            case 25:
                {
                alt1=6;
                }
                break;
            case 26:
                {
                alt1=7;
                }
                break;
            case 27:
                {
                alt1=8;
                }
                break;
            case 28:
                {
                alt1=9;
                }
                break;
            case 29:
                {
                alt1=10;
                }
                break;
            case 30:
                {
                alt1=11;
                }
                break;
            case 31:
                {
                alt1=12;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalBug348427TestLanguage.g:628:2: ( ( rule__Model__Element1Assignment_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:628:2: ( ( rule__Model__Element1Assignment_0 ) )
                    // InternalBug348427TestLanguage.g:629:3: ( rule__Model__Element1Assignment_0 )
                    {
                     before(grammarAccess.getModelAccess().getElement1Assignment_0()); 
                    // InternalBug348427TestLanguage.g:630:3: ( rule__Model__Element1Assignment_0 )
                    // InternalBug348427TestLanguage.g:630:4: rule__Model__Element1Assignment_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Model__Element1Assignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getElement1Assignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug348427TestLanguage.g:634:2: ( ( rule__Model__Element1Assignment_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:634:2: ( ( rule__Model__Element1Assignment_1 ) )
                    // InternalBug348427TestLanguage.g:635:3: ( rule__Model__Element1Assignment_1 )
                    {
                     before(grammarAccess.getModelAccess().getElement1Assignment_1()); 
                    // InternalBug348427TestLanguage.g:636:3: ( rule__Model__Element1Assignment_1 )
                    // InternalBug348427TestLanguage.g:636:4: rule__Model__Element1Assignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Model__Element1Assignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getElement1Assignment_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBug348427TestLanguage.g:640:2: ( ( rule__Model__Element1Assignment_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:640:2: ( ( rule__Model__Element1Assignment_2 ) )
                    // InternalBug348427TestLanguage.g:641:3: ( rule__Model__Element1Assignment_2 )
                    {
                     before(grammarAccess.getModelAccess().getElement1Assignment_2()); 
                    // InternalBug348427TestLanguage.g:642:3: ( rule__Model__Element1Assignment_2 )
                    // InternalBug348427TestLanguage.g:642:4: rule__Model__Element1Assignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Model__Element1Assignment_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getElement1Assignment_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBug348427TestLanguage.g:646:2: ( ( rule__Model__Element1Assignment_3 ) )
                    {
                    // InternalBug348427TestLanguage.g:646:2: ( ( rule__Model__Element1Assignment_3 ) )
                    // InternalBug348427TestLanguage.g:647:3: ( rule__Model__Element1Assignment_3 )
                    {
                     before(grammarAccess.getModelAccess().getElement1Assignment_3()); 
                    // InternalBug348427TestLanguage.g:648:3: ( rule__Model__Element1Assignment_3 )
                    // InternalBug348427TestLanguage.g:648:4: rule__Model__Element1Assignment_3
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Model__Element1Assignment_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getElement1Assignment_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalBug348427TestLanguage.g:652:2: ( ( rule__Model__Element2Assignment_4 ) )
                    {
                    // InternalBug348427TestLanguage.g:652:2: ( ( rule__Model__Element2Assignment_4 ) )
                    // InternalBug348427TestLanguage.g:653:3: ( rule__Model__Element2Assignment_4 )
                    {
                     before(grammarAccess.getModelAccess().getElement2Assignment_4()); 
                    // InternalBug348427TestLanguage.g:654:3: ( rule__Model__Element2Assignment_4 )
                    // InternalBug348427TestLanguage.g:654:4: rule__Model__Element2Assignment_4
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Model__Element2Assignment_4();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getElement2Assignment_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalBug348427TestLanguage.g:658:2: ( ( rule__Model__Element2Assignment_5 ) )
                    {
                    // InternalBug348427TestLanguage.g:658:2: ( ( rule__Model__Element2Assignment_5 ) )
                    // InternalBug348427TestLanguage.g:659:3: ( rule__Model__Element2Assignment_5 )
                    {
                     before(grammarAccess.getModelAccess().getElement2Assignment_5()); 
                    // InternalBug348427TestLanguage.g:660:3: ( rule__Model__Element2Assignment_5 )
                    // InternalBug348427TestLanguage.g:660:4: rule__Model__Element2Assignment_5
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Model__Element2Assignment_5();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getElement2Assignment_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalBug348427TestLanguage.g:664:2: ( ( rule__Model__Element2Assignment_6 ) )
                    {
                    // InternalBug348427TestLanguage.g:664:2: ( ( rule__Model__Element2Assignment_6 ) )
                    // InternalBug348427TestLanguage.g:665:3: ( rule__Model__Element2Assignment_6 )
                    {
                     before(grammarAccess.getModelAccess().getElement2Assignment_6()); 
                    // InternalBug348427TestLanguage.g:666:3: ( rule__Model__Element2Assignment_6 )
                    // InternalBug348427TestLanguage.g:666:4: rule__Model__Element2Assignment_6
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Model__Element2Assignment_6();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getElement2Assignment_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalBug348427TestLanguage.g:670:2: ( ( rule__Model__Element2Assignment_7 ) )
                    {
                    // InternalBug348427TestLanguage.g:670:2: ( ( rule__Model__Element2Assignment_7 ) )
                    // InternalBug348427TestLanguage.g:671:3: ( rule__Model__Element2Assignment_7 )
                    {
                     before(grammarAccess.getModelAccess().getElement2Assignment_7()); 
                    // InternalBug348427TestLanguage.g:672:3: ( rule__Model__Element2Assignment_7 )
                    // InternalBug348427TestLanguage.g:672:4: rule__Model__Element2Assignment_7
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Model__Element2Assignment_7();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getElement2Assignment_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalBug348427TestLanguage.g:676:2: ( ( rule__Model__Element2Assignment_8 ) )
                    {
                    // InternalBug348427TestLanguage.g:676:2: ( ( rule__Model__Element2Assignment_8 ) )
                    // InternalBug348427TestLanguage.g:677:3: ( rule__Model__Element2Assignment_8 )
                    {
                     before(grammarAccess.getModelAccess().getElement2Assignment_8()); 
                    // InternalBug348427TestLanguage.g:678:3: ( rule__Model__Element2Assignment_8 )
                    // InternalBug348427TestLanguage.g:678:4: rule__Model__Element2Assignment_8
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Model__Element2Assignment_8();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getElement2Assignment_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalBug348427TestLanguage.g:682:2: ( ( rule__Model__Element2Assignment_9 ) )
                    {
                    // InternalBug348427TestLanguage.g:682:2: ( ( rule__Model__Element2Assignment_9 ) )
                    // InternalBug348427TestLanguage.g:683:3: ( rule__Model__Element2Assignment_9 )
                    {
                     before(grammarAccess.getModelAccess().getElement2Assignment_9()); 
                    // InternalBug348427TestLanguage.g:684:3: ( rule__Model__Element2Assignment_9 )
                    // InternalBug348427TestLanguage.g:684:4: rule__Model__Element2Assignment_9
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Model__Element2Assignment_9();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getElement2Assignment_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalBug348427TestLanguage.g:688:2: ( ( rule__Model__Element2Assignment_10 ) )
                    {
                    // InternalBug348427TestLanguage.g:688:2: ( ( rule__Model__Element2Assignment_10 ) )
                    // InternalBug348427TestLanguage.g:689:3: ( rule__Model__Element2Assignment_10 )
                    {
                     before(grammarAccess.getModelAccess().getElement2Assignment_10()); 
                    // InternalBug348427TestLanguage.g:690:3: ( rule__Model__Element2Assignment_10 )
                    // InternalBug348427TestLanguage.g:690:4: rule__Model__Element2Assignment_10
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Model__Element2Assignment_10();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getElement2Assignment_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalBug348427TestLanguage.g:694:2: ( ( rule__Model__Element2Assignment_11 ) )
                    {
                    // InternalBug348427TestLanguage.g:694:2: ( ( rule__Model__Element2Assignment_11 ) )
                    // InternalBug348427TestLanguage.g:695:3: ( rule__Model__Element2Assignment_11 )
                    {
                     before(grammarAccess.getModelAccess().getElement2Assignment_11()); 
                    // InternalBug348427TestLanguage.g:696:3: ( rule__Model__Element2Assignment_11 )
                    // InternalBug348427TestLanguage.g:696:4: rule__Model__Element2Assignment_11
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Model__Element2Assignment_11();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getElement2Assignment_11()); 

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


    // $ANTLR start "rule__Scenario1_1__Alternatives_1"
    // InternalBug348427TestLanguage.g:704:1: rule__Scenario1_1__Alternatives_1 : ( ( ( rule__Scenario1_1__ChildAssignment_1_0 ) ) | ( ( rule__Scenario1_1__ChildAssignment_1_1 ) ) | ( ( rule__Scenario1_1__ChildAssignment_1_2 ) ) );
    public final void rule__Scenario1_1__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:708:1: ( ( ( rule__Scenario1_1__ChildAssignment_1_0 ) ) | ( ( rule__Scenario1_1__ChildAssignment_1_1 ) ) | ( ( rule__Scenario1_1__ChildAssignment_1_2 ) ) )
            int alt2=3;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // InternalBug348427TestLanguage.g:709:2: ( ( rule__Scenario1_1__ChildAssignment_1_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:709:2: ( ( rule__Scenario1_1__ChildAssignment_1_0 ) )
                    // InternalBug348427TestLanguage.g:710:3: ( rule__Scenario1_1__ChildAssignment_1_0 )
                    {
                     before(grammarAccess.getScenario1_1Access().getChildAssignment_1_0()); 
                    // InternalBug348427TestLanguage.g:711:3: ( rule__Scenario1_1__ChildAssignment_1_0 )
                    // InternalBug348427TestLanguage.g:711:4: rule__Scenario1_1__ChildAssignment_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario1_1__ChildAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario1_1Access().getChildAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug348427TestLanguage.g:715:2: ( ( rule__Scenario1_1__ChildAssignment_1_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:715:2: ( ( rule__Scenario1_1__ChildAssignment_1_1 ) )
                    // InternalBug348427TestLanguage.g:716:3: ( rule__Scenario1_1__ChildAssignment_1_1 )
                    {
                     before(grammarAccess.getScenario1_1Access().getChildAssignment_1_1()); 
                    // InternalBug348427TestLanguage.g:717:3: ( rule__Scenario1_1__ChildAssignment_1_1 )
                    // InternalBug348427TestLanguage.g:717:4: rule__Scenario1_1__ChildAssignment_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario1_1__ChildAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario1_1Access().getChildAssignment_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBug348427TestLanguage.g:721:2: ( ( rule__Scenario1_1__ChildAssignment_1_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:721:2: ( ( rule__Scenario1_1__ChildAssignment_1_2 ) )
                    // InternalBug348427TestLanguage.g:722:3: ( rule__Scenario1_1__ChildAssignment_1_2 )
                    {
                     before(grammarAccess.getScenario1_1Access().getChildAssignment_1_2()); 
                    // InternalBug348427TestLanguage.g:723:3: ( rule__Scenario1_1__ChildAssignment_1_2 )
                    // InternalBug348427TestLanguage.g:723:4: rule__Scenario1_1__ChildAssignment_1_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario1_1__ChildAssignment_1_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario1_1Access().getChildAssignment_1_2()); 

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
    // $ANTLR end "rule__Scenario1_1__Alternatives_1"


    // $ANTLR start "rule__Scenario1_2__Alternatives_1"
    // InternalBug348427TestLanguage.g:731:1: rule__Scenario1_2__Alternatives_1 : ( ( ( rule__Scenario1_2__ChildAssignment_1_0 ) ) | ( ( rule__Scenario1_2__ChildAssignment_1_1 ) ) | ( ( rule__Scenario1_2__ChildAssignment_1_2 ) ) );
    public final void rule__Scenario1_2__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:735:1: ( ( ( rule__Scenario1_2__ChildAssignment_1_0 ) ) | ( ( rule__Scenario1_2__ChildAssignment_1_1 ) ) | ( ( rule__Scenario1_2__ChildAssignment_1_2 ) ) )
            int alt3=3;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // InternalBug348427TestLanguage.g:736:2: ( ( rule__Scenario1_2__ChildAssignment_1_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:736:2: ( ( rule__Scenario1_2__ChildAssignment_1_0 ) )
                    // InternalBug348427TestLanguage.g:737:3: ( rule__Scenario1_2__ChildAssignment_1_0 )
                    {
                     before(grammarAccess.getScenario1_2Access().getChildAssignment_1_0()); 
                    // InternalBug348427TestLanguage.g:738:3: ( rule__Scenario1_2__ChildAssignment_1_0 )
                    // InternalBug348427TestLanguage.g:738:4: rule__Scenario1_2__ChildAssignment_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario1_2__ChildAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario1_2Access().getChildAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug348427TestLanguage.g:742:2: ( ( rule__Scenario1_2__ChildAssignment_1_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:742:2: ( ( rule__Scenario1_2__ChildAssignment_1_1 ) )
                    // InternalBug348427TestLanguage.g:743:3: ( rule__Scenario1_2__ChildAssignment_1_1 )
                    {
                     before(grammarAccess.getScenario1_2Access().getChildAssignment_1_1()); 
                    // InternalBug348427TestLanguage.g:744:3: ( rule__Scenario1_2__ChildAssignment_1_1 )
                    // InternalBug348427TestLanguage.g:744:4: rule__Scenario1_2__ChildAssignment_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario1_2__ChildAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario1_2Access().getChildAssignment_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBug348427TestLanguage.g:748:2: ( ( rule__Scenario1_2__ChildAssignment_1_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:748:2: ( ( rule__Scenario1_2__ChildAssignment_1_2 ) )
                    // InternalBug348427TestLanguage.g:749:3: ( rule__Scenario1_2__ChildAssignment_1_2 )
                    {
                     before(grammarAccess.getScenario1_2Access().getChildAssignment_1_2()); 
                    // InternalBug348427TestLanguage.g:750:3: ( rule__Scenario1_2__ChildAssignment_1_2 )
                    // InternalBug348427TestLanguage.g:750:4: rule__Scenario1_2__ChildAssignment_1_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario1_2__ChildAssignment_1_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario1_2Access().getChildAssignment_1_2()); 

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
    // $ANTLR end "rule__Scenario1_2__Alternatives_1"


    // $ANTLR start "rule__Scenario1_3__Alternatives_2"
    // InternalBug348427TestLanguage.g:758:1: rule__Scenario1_3__Alternatives_2 : ( ( ( rule__Scenario1_3__ChildAssignment_2_0 ) ) | ( ( rule__Scenario1_3__ChildAssignment_2_1 ) ) | ( ( rule__Scenario1_3__ChildAssignment_2_2 ) ) );
    public final void rule__Scenario1_3__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:762:1: ( ( ( rule__Scenario1_3__ChildAssignment_2_0 ) ) | ( ( rule__Scenario1_3__ChildAssignment_2_1 ) ) | ( ( rule__Scenario1_3__ChildAssignment_2_2 ) ) )
            int alt4=3;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // InternalBug348427TestLanguage.g:763:2: ( ( rule__Scenario1_3__ChildAssignment_2_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:763:2: ( ( rule__Scenario1_3__ChildAssignment_2_0 ) )
                    // InternalBug348427TestLanguage.g:764:3: ( rule__Scenario1_3__ChildAssignment_2_0 )
                    {
                     before(grammarAccess.getScenario1_3Access().getChildAssignment_2_0()); 
                    // InternalBug348427TestLanguage.g:765:3: ( rule__Scenario1_3__ChildAssignment_2_0 )
                    // InternalBug348427TestLanguage.g:765:4: rule__Scenario1_3__ChildAssignment_2_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario1_3__ChildAssignment_2_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario1_3Access().getChildAssignment_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug348427TestLanguage.g:769:2: ( ( rule__Scenario1_3__ChildAssignment_2_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:769:2: ( ( rule__Scenario1_3__ChildAssignment_2_1 ) )
                    // InternalBug348427TestLanguage.g:770:3: ( rule__Scenario1_3__ChildAssignment_2_1 )
                    {
                     before(grammarAccess.getScenario1_3Access().getChildAssignment_2_1()); 
                    // InternalBug348427TestLanguage.g:771:3: ( rule__Scenario1_3__ChildAssignment_2_1 )
                    // InternalBug348427TestLanguage.g:771:4: rule__Scenario1_3__ChildAssignment_2_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario1_3__ChildAssignment_2_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario1_3Access().getChildAssignment_2_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBug348427TestLanguage.g:775:2: ( ( rule__Scenario1_3__ChildAssignment_2_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:775:2: ( ( rule__Scenario1_3__ChildAssignment_2_2 ) )
                    // InternalBug348427TestLanguage.g:776:3: ( rule__Scenario1_3__ChildAssignment_2_2 )
                    {
                     before(grammarAccess.getScenario1_3Access().getChildAssignment_2_2()); 
                    // InternalBug348427TestLanguage.g:777:3: ( rule__Scenario1_3__ChildAssignment_2_2 )
                    // InternalBug348427TestLanguage.g:777:4: rule__Scenario1_3__ChildAssignment_2_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario1_3__ChildAssignment_2_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario1_3Access().getChildAssignment_2_2()); 

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
    // $ANTLR end "rule__Scenario1_3__Alternatives_2"


    // $ANTLR start "rule__Scenario1_4__Alternatives_2"
    // InternalBug348427TestLanguage.g:785:1: rule__Scenario1_4__Alternatives_2 : ( ( ( rule__Scenario1_4__ChildAssignment_2_0 ) ) | ( ( rule__Scenario1_4__ChildAssignment_2_1 ) ) | ( ( rule__Scenario1_4__ChildAssignment_2_2 ) ) );
    public final void rule__Scenario1_4__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:789:1: ( ( ( rule__Scenario1_4__ChildAssignment_2_0 ) ) | ( ( rule__Scenario1_4__ChildAssignment_2_1 ) ) | ( ( rule__Scenario1_4__ChildAssignment_2_2 ) ) )
            int alt5=3;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // InternalBug348427TestLanguage.g:790:2: ( ( rule__Scenario1_4__ChildAssignment_2_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:790:2: ( ( rule__Scenario1_4__ChildAssignment_2_0 ) )
                    // InternalBug348427TestLanguage.g:791:3: ( rule__Scenario1_4__ChildAssignment_2_0 )
                    {
                     before(grammarAccess.getScenario1_4Access().getChildAssignment_2_0()); 
                    // InternalBug348427TestLanguage.g:792:3: ( rule__Scenario1_4__ChildAssignment_2_0 )
                    // InternalBug348427TestLanguage.g:792:4: rule__Scenario1_4__ChildAssignment_2_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario1_4__ChildAssignment_2_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario1_4Access().getChildAssignment_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug348427TestLanguage.g:796:2: ( ( rule__Scenario1_4__ChildAssignment_2_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:796:2: ( ( rule__Scenario1_4__ChildAssignment_2_1 ) )
                    // InternalBug348427TestLanguage.g:797:3: ( rule__Scenario1_4__ChildAssignment_2_1 )
                    {
                     before(grammarAccess.getScenario1_4Access().getChildAssignment_2_1()); 
                    // InternalBug348427TestLanguage.g:798:3: ( rule__Scenario1_4__ChildAssignment_2_1 )
                    // InternalBug348427TestLanguage.g:798:4: rule__Scenario1_4__ChildAssignment_2_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario1_4__ChildAssignment_2_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario1_4Access().getChildAssignment_2_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBug348427TestLanguage.g:802:2: ( ( rule__Scenario1_4__ChildAssignment_2_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:802:2: ( ( rule__Scenario1_4__ChildAssignment_2_2 ) )
                    // InternalBug348427TestLanguage.g:803:3: ( rule__Scenario1_4__ChildAssignment_2_2 )
                    {
                     before(grammarAccess.getScenario1_4Access().getChildAssignment_2_2()); 
                    // InternalBug348427TestLanguage.g:804:3: ( rule__Scenario1_4__ChildAssignment_2_2 )
                    // InternalBug348427TestLanguage.g:804:4: rule__Scenario1_4__ChildAssignment_2_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario1_4__ChildAssignment_2_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario1_4Access().getChildAssignment_2_2()); 

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
    // $ANTLR end "rule__Scenario1_4__Alternatives_2"


    // $ANTLR start "rule__Scenario2_1__Alternatives_1"
    // InternalBug348427TestLanguage.g:812:1: rule__Scenario2_1__Alternatives_1 : ( ( ( rule__Scenario2_1__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_1__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_1__ChildAssignment_1_2 ) ) );
    public final void rule__Scenario2_1__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:816:1: ( ( ( rule__Scenario2_1__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_1__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_1__ChildAssignment_1_2 ) ) )
            int alt6=3;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // InternalBug348427TestLanguage.g:817:2: ( ( rule__Scenario2_1__ChildAssignment_1_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:817:2: ( ( rule__Scenario2_1__ChildAssignment_1_0 ) )
                    // InternalBug348427TestLanguage.g:818:3: ( rule__Scenario2_1__ChildAssignment_1_0 )
                    {
                     before(grammarAccess.getScenario2_1Access().getChildAssignment_1_0()); 
                    // InternalBug348427TestLanguage.g:819:3: ( rule__Scenario2_1__ChildAssignment_1_0 )
                    // InternalBug348427TestLanguage.g:819:4: rule__Scenario2_1__ChildAssignment_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario2_1__ChildAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_1Access().getChildAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug348427TestLanguage.g:823:2: ( ( rule__Scenario2_1__ChildAssignment_1_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:823:2: ( ( rule__Scenario2_1__ChildAssignment_1_1 ) )
                    // InternalBug348427TestLanguage.g:824:3: ( rule__Scenario2_1__ChildAssignment_1_1 )
                    {
                     before(grammarAccess.getScenario2_1Access().getChildAssignment_1_1()); 
                    // InternalBug348427TestLanguage.g:825:3: ( rule__Scenario2_1__ChildAssignment_1_1 )
                    // InternalBug348427TestLanguage.g:825:4: rule__Scenario2_1__ChildAssignment_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario2_1__ChildAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_1Access().getChildAssignment_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBug348427TestLanguage.g:829:2: ( ( rule__Scenario2_1__ChildAssignment_1_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:829:2: ( ( rule__Scenario2_1__ChildAssignment_1_2 ) )
                    // InternalBug348427TestLanguage.g:830:3: ( rule__Scenario2_1__ChildAssignment_1_2 )
                    {
                     before(grammarAccess.getScenario2_1Access().getChildAssignment_1_2()); 
                    // InternalBug348427TestLanguage.g:831:3: ( rule__Scenario2_1__ChildAssignment_1_2 )
                    // InternalBug348427TestLanguage.g:831:4: rule__Scenario2_1__ChildAssignment_1_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario2_1__ChildAssignment_1_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_1Access().getChildAssignment_1_2()); 

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
    // $ANTLR end "rule__Scenario2_1__Alternatives_1"


    // $ANTLR start "rule__Scenario2_2__Alternatives_1"
    // InternalBug348427TestLanguage.g:839:1: rule__Scenario2_2__Alternatives_1 : ( ( ( rule__Scenario2_2__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_2__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_2__ChildAssignment_1_2 ) ) );
    public final void rule__Scenario2_2__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:843:1: ( ( ( rule__Scenario2_2__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_2__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_2__ChildAssignment_1_2 ) ) )
            int alt7=3;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // InternalBug348427TestLanguage.g:844:2: ( ( rule__Scenario2_2__ChildAssignment_1_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:844:2: ( ( rule__Scenario2_2__ChildAssignment_1_0 ) )
                    // InternalBug348427TestLanguage.g:845:3: ( rule__Scenario2_2__ChildAssignment_1_0 )
                    {
                     before(grammarAccess.getScenario2_2Access().getChildAssignment_1_0()); 
                    // InternalBug348427TestLanguage.g:846:3: ( rule__Scenario2_2__ChildAssignment_1_0 )
                    // InternalBug348427TestLanguage.g:846:4: rule__Scenario2_2__ChildAssignment_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario2_2__ChildAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_2Access().getChildAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug348427TestLanguage.g:850:2: ( ( rule__Scenario2_2__ChildAssignment_1_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:850:2: ( ( rule__Scenario2_2__ChildAssignment_1_1 ) )
                    // InternalBug348427TestLanguage.g:851:3: ( rule__Scenario2_2__ChildAssignment_1_1 )
                    {
                     before(grammarAccess.getScenario2_2Access().getChildAssignment_1_1()); 
                    // InternalBug348427TestLanguage.g:852:3: ( rule__Scenario2_2__ChildAssignment_1_1 )
                    // InternalBug348427TestLanguage.g:852:4: rule__Scenario2_2__ChildAssignment_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario2_2__ChildAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_2Access().getChildAssignment_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBug348427TestLanguage.g:856:2: ( ( rule__Scenario2_2__ChildAssignment_1_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:856:2: ( ( rule__Scenario2_2__ChildAssignment_1_2 ) )
                    // InternalBug348427TestLanguage.g:857:3: ( rule__Scenario2_2__ChildAssignment_1_2 )
                    {
                     before(grammarAccess.getScenario2_2Access().getChildAssignment_1_2()); 
                    // InternalBug348427TestLanguage.g:858:3: ( rule__Scenario2_2__ChildAssignment_1_2 )
                    // InternalBug348427TestLanguage.g:858:4: rule__Scenario2_2__ChildAssignment_1_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario2_2__ChildAssignment_1_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_2Access().getChildAssignment_1_2()); 

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
    // $ANTLR end "rule__Scenario2_2__Alternatives_1"


    // $ANTLR start "rule__Scenario2_3__Alternatives_1"
    // InternalBug348427TestLanguage.g:866:1: rule__Scenario2_3__Alternatives_1 : ( ( ( rule__Scenario2_3__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_3__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_3__ChildAssignment_1_2 ) ) );
    public final void rule__Scenario2_3__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:870:1: ( ( ( rule__Scenario2_3__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_3__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_3__ChildAssignment_1_2 ) ) )
            int alt8=3;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // InternalBug348427TestLanguage.g:871:2: ( ( rule__Scenario2_3__ChildAssignment_1_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:871:2: ( ( rule__Scenario2_3__ChildAssignment_1_0 ) )
                    // InternalBug348427TestLanguage.g:872:3: ( rule__Scenario2_3__ChildAssignment_1_0 )
                    {
                     before(grammarAccess.getScenario2_3Access().getChildAssignment_1_0()); 
                    // InternalBug348427TestLanguage.g:873:3: ( rule__Scenario2_3__ChildAssignment_1_0 )
                    // InternalBug348427TestLanguage.g:873:4: rule__Scenario2_3__ChildAssignment_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario2_3__ChildAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_3Access().getChildAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug348427TestLanguage.g:877:2: ( ( rule__Scenario2_3__ChildAssignment_1_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:877:2: ( ( rule__Scenario2_3__ChildAssignment_1_1 ) )
                    // InternalBug348427TestLanguage.g:878:3: ( rule__Scenario2_3__ChildAssignment_1_1 )
                    {
                     before(grammarAccess.getScenario2_3Access().getChildAssignment_1_1()); 
                    // InternalBug348427TestLanguage.g:879:3: ( rule__Scenario2_3__ChildAssignment_1_1 )
                    // InternalBug348427TestLanguage.g:879:4: rule__Scenario2_3__ChildAssignment_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario2_3__ChildAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_3Access().getChildAssignment_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBug348427TestLanguage.g:883:2: ( ( rule__Scenario2_3__ChildAssignment_1_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:883:2: ( ( rule__Scenario2_3__ChildAssignment_1_2 ) )
                    // InternalBug348427TestLanguage.g:884:3: ( rule__Scenario2_3__ChildAssignment_1_2 )
                    {
                     before(grammarAccess.getScenario2_3Access().getChildAssignment_1_2()); 
                    // InternalBug348427TestLanguage.g:885:3: ( rule__Scenario2_3__ChildAssignment_1_2 )
                    // InternalBug348427TestLanguage.g:885:4: rule__Scenario2_3__ChildAssignment_1_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario2_3__ChildAssignment_1_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_3Access().getChildAssignment_1_2()); 

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
    // $ANTLR end "rule__Scenario2_3__Alternatives_1"


    // $ANTLR start "rule__Scenario2_4__Alternatives_1"
    // InternalBug348427TestLanguage.g:893:1: rule__Scenario2_4__Alternatives_1 : ( ( ( rule__Scenario2_4__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_4__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_4__ChildAssignment_1_2 ) ) );
    public final void rule__Scenario2_4__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:897:1: ( ( ( rule__Scenario2_4__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_4__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_4__ChildAssignment_1_2 ) ) )
            int alt9=3;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // InternalBug348427TestLanguage.g:898:2: ( ( rule__Scenario2_4__ChildAssignment_1_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:898:2: ( ( rule__Scenario2_4__ChildAssignment_1_0 ) )
                    // InternalBug348427TestLanguage.g:899:3: ( rule__Scenario2_4__ChildAssignment_1_0 )
                    {
                     before(grammarAccess.getScenario2_4Access().getChildAssignment_1_0()); 
                    // InternalBug348427TestLanguage.g:900:3: ( rule__Scenario2_4__ChildAssignment_1_0 )
                    // InternalBug348427TestLanguage.g:900:4: rule__Scenario2_4__ChildAssignment_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario2_4__ChildAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_4Access().getChildAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug348427TestLanguage.g:904:2: ( ( rule__Scenario2_4__ChildAssignment_1_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:904:2: ( ( rule__Scenario2_4__ChildAssignment_1_1 ) )
                    // InternalBug348427TestLanguage.g:905:3: ( rule__Scenario2_4__ChildAssignment_1_1 )
                    {
                     before(grammarAccess.getScenario2_4Access().getChildAssignment_1_1()); 
                    // InternalBug348427TestLanguage.g:906:3: ( rule__Scenario2_4__ChildAssignment_1_1 )
                    // InternalBug348427TestLanguage.g:906:4: rule__Scenario2_4__ChildAssignment_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario2_4__ChildAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_4Access().getChildAssignment_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBug348427TestLanguage.g:910:2: ( ( rule__Scenario2_4__ChildAssignment_1_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:910:2: ( ( rule__Scenario2_4__ChildAssignment_1_2 ) )
                    // InternalBug348427TestLanguage.g:911:3: ( rule__Scenario2_4__ChildAssignment_1_2 )
                    {
                     before(grammarAccess.getScenario2_4Access().getChildAssignment_1_2()); 
                    // InternalBug348427TestLanguage.g:912:3: ( rule__Scenario2_4__ChildAssignment_1_2 )
                    // InternalBug348427TestLanguage.g:912:4: rule__Scenario2_4__ChildAssignment_1_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario2_4__ChildAssignment_1_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_4Access().getChildAssignment_1_2()); 

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
    // $ANTLR end "rule__Scenario2_4__Alternatives_1"


    // $ANTLR start "rule__Scenario2_5__Alternatives_2"
    // InternalBug348427TestLanguage.g:920:1: rule__Scenario2_5__Alternatives_2 : ( ( ( rule__Scenario2_5__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_5__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_5__ChildAssignment_2_2 ) ) );
    public final void rule__Scenario2_5__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:924:1: ( ( ( rule__Scenario2_5__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_5__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_5__ChildAssignment_2_2 ) ) )
            int alt10=3;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // InternalBug348427TestLanguage.g:925:2: ( ( rule__Scenario2_5__ChildAssignment_2_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:925:2: ( ( rule__Scenario2_5__ChildAssignment_2_0 ) )
                    // InternalBug348427TestLanguage.g:926:3: ( rule__Scenario2_5__ChildAssignment_2_0 )
                    {
                     before(grammarAccess.getScenario2_5Access().getChildAssignment_2_0()); 
                    // InternalBug348427TestLanguage.g:927:3: ( rule__Scenario2_5__ChildAssignment_2_0 )
                    // InternalBug348427TestLanguage.g:927:4: rule__Scenario2_5__ChildAssignment_2_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario2_5__ChildAssignment_2_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_5Access().getChildAssignment_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug348427TestLanguage.g:931:2: ( ( rule__Scenario2_5__ChildAssignment_2_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:931:2: ( ( rule__Scenario2_5__ChildAssignment_2_1 ) )
                    // InternalBug348427TestLanguage.g:932:3: ( rule__Scenario2_5__ChildAssignment_2_1 )
                    {
                     before(grammarAccess.getScenario2_5Access().getChildAssignment_2_1()); 
                    // InternalBug348427TestLanguage.g:933:3: ( rule__Scenario2_5__ChildAssignment_2_1 )
                    // InternalBug348427TestLanguage.g:933:4: rule__Scenario2_5__ChildAssignment_2_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario2_5__ChildAssignment_2_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_5Access().getChildAssignment_2_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBug348427TestLanguage.g:937:2: ( ( rule__Scenario2_5__ChildAssignment_2_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:937:2: ( ( rule__Scenario2_5__ChildAssignment_2_2 ) )
                    // InternalBug348427TestLanguage.g:938:3: ( rule__Scenario2_5__ChildAssignment_2_2 )
                    {
                     before(grammarAccess.getScenario2_5Access().getChildAssignment_2_2()); 
                    // InternalBug348427TestLanguage.g:939:3: ( rule__Scenario2_5__ChildAssignment_2_2 )
                    // InternalBug348427TestLanguage.g:939:4: rule__Scenario2_5__ChildAssignment_2_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario2_5__ChildAssignment_2_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_5Access().getChildAssignment_2_2()); 

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
    // $ANTLR end "rule__Scenario2_5__Alternatives_2"


    // $ANTLR start "rule__Scenario2_6__Alternatives_2"
    // InternalBug348427TestLanguage.g:947:1: rule__Scenario2_6__Alternatives_2 : ( ( ( rule__Scenario2_6__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_6__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_6__ChildAssignment_2_2 ) ) );
    public final void rule__Scenario2_6__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:951:1: ( ( ( rule__Scenario2_6__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_6__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_6__ChildAssignment_2_2 ) ) )
            int alt11=3;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // InternalBug348427TestLanguage.g:952:2: ( ( rule__Scenario2_6__ChildAssignment_2_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:952:2: ( ( rule__Scenario2_6__ChildAssignment_2_0 ) )
                    // InternalBug348427TestLanguage.g:953:3: ( rule__Scenario2_6__ChildAssignment_2_0 )
                    {
                     before(grammarAccess.getScenario2_6Access().getChildAssignment_2_0()); 
                    // InternalBug348427TestLanguage.g:954:3: ( rule__Scenario2_6__ChildAssignment_2_0 )
                    // InternalBug348427TestLanguage.g:954:4: rule__Scenario2_6__ChildAssignment_2_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario2_6__ChildAssignment_2_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_6Access().getChildAssignment_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug348427TestLanguage.g:958:2: ( ( rule__Scenario2_6__ChildAssignment_2_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:958:2: ( ( rule__Scenario2_6__ChildAssignment_2_1 ) )
                    // InternalBug348427TestLanguage.g:959:3: ( rule__Scenario2_6__ChildAssignment_2_1 )
                    {
                     before(grammarAccess.getScenario2_6Access().getChildAssignment_2_1()); 
                    // InternalBug348427TestLanguage.g:960:3: ( rule__Scenario2_6__ChildAssignment_2_1 )
                    // InternalBug348427TestLanguage.g:960:4: rule__Scenario2_6__ChildAssignment_2_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario2_6__ChildAssignment_2_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_6Access().getChildAssignment_2_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBug348427TestLanguage.g:964:2: ( ( rule__Scenario2_6__ChildAssignment_2_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:964:2: ( ( rule__Scenario2_6__ChildAssignment_2_2 ) )
                    // InternalBug348427TestLanguage.g:965:3: ( rule__Scenario2_6__ChildAssignment_2_2 )
                    {
                     before(grammarAccess.getScenario2_6Access().getChildAssignment_2_2()); 
                    // InternalBug348427TestLanguage.g:966:3: ( rule__Scenario2_6__ChildAssignment_2_2 )
                    // InternalBug348427TestLanguage.g:966:4: rule__Scenario2_6__ChildAssignment_2_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario2_6__ChildAssignment_2_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_6Access().getChildAssignment_2_2()); 

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
    // $ANTLR end "rule__Scenario2_6__Alternatives_2"


    // $ANTLR start "rule__Scenario2_7__Alternatives_2"
    // InternalBug348427TestLanguage.g:974:1: rule__Scenario2_7__Alternatives_2 : ( ( ( rule__Scenario2_7__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_7__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_7__ChildAssignment_2_2 ) ) );
    public final void rule__Scenario2_7__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:978:1: ( ( ( rule__Scenario2_7__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_7__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_7__ChildAssignment_2_2 ) ) )
            int alt12=3;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // InternalBug348427TestLanguage.g:979:2: ( ( rule__Scenario2_7__ChildAssignment_2_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:979:2: ( ( rule__Scenario2_7__ChildAssignment_2_0 ) )
                    // InternalBug348427TestLanguage.g:980:3: ( rule__Scenario2_7__ChildAssignment_2_0 )
                    {
                     before(grammarAccess.getScenario2_7Access().getChildAssignment_2_0()); 
                    // InternalBug348427TestLanguage.g:981:3: ( rule__Scenario2_7__ChildAssignment_2_0 )
                    // InternalBug348427TestLanguage.g:981:4: rule__Scenario2_7__ChildAssignment_2_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario2_7__ChildAssignment_2_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_7Access().getChildAssignment_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug348427TestLanguage.g:985:2: ( ( rule__Scenario2_7__ChildAssignment_2_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:985:2: ( ( rule__Scenario2_7__ChildAssignment_2_1 ) )
                    // InternalBug348427TestLanguage.g:986:3: ( rule__Scenario2_7__ChildAssignment_2_1 )
                    {
                     before(grammarAccess.getScenario2_7Access().getChildAssignment_2_1()); 
                    // InternalBug348427TestLanguage.g:987:3: ( rule__Scenario2_7__ChildAssignment_2_1 )
                    // InternalBug348427TestLanguage.g:987:4: rule__Scenario2_7__ChildAssignment_2_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario2_7__ChildAssignment_2_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_7Access().getChildAssignment_2_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBug348427TestLanguage.g:991:2: ( ( rule__Scenario2_7__ChildAssignment_2_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:991:2: ( ( rule__Scenario2_7__ChildAssignment_2_2 ) )
                    // InternalBug348427TestLanguage.g:992:3: ( rule__Scenario2_7__ChildAssignment_2_2 )
                    {
                     before(grammarAccess.getScenario2_7Access().getChildAssignment_2_2()); 
                    // InternalBug348427TestLanguage.g:993:3: ( rule__Scenario2_7__ChildAssignment_2_2 )
                    // InternalBug348427TestLanguage.g:993:4: rule__Scenario2_7__ChildAssignment_2_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario2_7__ChildAssignment_2_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_7Access().getChildAssignment_2_2()); 

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
    // $ANTLR end "rule__Scenario2_7__Alternatives_2"


    // $ANTLR start "rule__Scenario2_8__Alternatives_2"
    // InternalBug348427TestLanguage.g:1001:1: rule__Scenario2_8__Alternatives_2 : ( ( ( rule__Scenario2_8__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_8__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_8__ChildAssignment_2_2 ) ) );
    public final void rule__Scenario2_8__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1005:1: ( ( ( rule__Scenario2_8__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_8__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_8__ChildAssignment_2_2 ) ) )
            int alt13=3;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // InternalBug348427TestLanguage.g:1006:2: ( ( rule__Scenario2_8__ChildAssignment_2_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:1006:2: ( ( rule__Scenario2_8__ChildAssignment_2_0 ) )
                    // InternalBug348427TestLanguage.g:1007:3: ( rule__Scenario2_8__ChildAssignment_2_0 )
                    {
                     before(grammarAccess.getScenario2_8Access().getChildAssignment_2_0()); 
                    // InternalBug348427TestLanguage.g:1008:3: ( rule__Scenario2_8__ChildAssignment_2_0 )
                    // InternalBug348427TestLanguage.g:1008:4: rule__Scenario2_8__ChildAssignment_2_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario2_8__ChildAssignment_2_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_8Access().getChildAssignment_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug348427TestLanguage.g:1012:2: ( ( rule__Scenario2_8__ChildAssignment_2_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:1012:2: ( ( rule__Scenario2_8__ChildAssignment_2_1 ) )
                    // InternalBug348427TestLanguage.g:1013:3: ( rule__Scenario2_8__ChildAssignment_2_1 )
                    {
                     before(grammarAccess.getScenario2_8Access().getChildAssignment_2_1()); 
                    // InternalBug348427TestLanguage.g:1014:3: ( rule__Scenario2_8__ChildAssignment_2_1 )
                    // InternalBug348427TestLanguage.g:1014:4: rule__Scenario2_8__ChildAssignment_2_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario2_8__ChildAssignment_2_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_8Access().getChildAssignment_2_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBug348427TestLanguage.g:1018:2: ( ( rule__Scenario2_8__ChildAssignment_2_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:1018:2: ( ( rule__Scenario2_8__ChildAssignment_2_2 ) )
                    // InternalBug348427TestLanguage.g:1019:3: ( rule__Scenario2_8__ChildAssignment_2_2 )
                    {
                     before(grammarAccess.getScenario2_8Access().getChildAssignment_2_2()); 
                    // InternalBug348427TestLanguage.g:1020:3: ( rule__Scenario2_8__ChildAssignment_2_2 )
                    // InternalBug348427TestLanguage.g:1020:4: rule__Scenario2_8__ChildAssignment_2_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario2_8__ChildAssignment_2_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_8Access().getChildAssignment_2_2()); 

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
    // $ANTLR end "rule__Scenario2_8__Alternatives_2"


    // $ANTLR start "rule__Child2_1__StringAlternatives_3_0"
    // InternalBug348427TestLanguage.g:1028:1: rule__Child2_1__StringAlternatives_3_0 : ( ( 'a' ) | ( 'b' ) );
    public final void rule__Child2_1__StringAlternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1032:1: ( ( 'a' ) | ( 'b' ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==11) ) {
                alt14=1;
            }
            else if ( (LA14_0==12) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalBug348427TestLanguage.g:1033:2: ( 'a' )
                    {
                    // InternalBug348427TestLanguage.g:1033:2: ( 'a' )
                    // InternalBug348427TestLanguage.g:1034:3: 'a'
                    {
                     before(grammarAccess.getChild2_1Access().getStringAKeyword_3_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getChild2_1Access().getStringAKeyword_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug348427TestLanguage.g:1039:2: ( 'b' )
                    {
                    // InternalBug348427TestLanguage.g:1039:2: ( 'b' )
                    // InternalBug348427TestLanguage.g:1040:3: 'b'
                    {
                     before(grammarAccess.getChild2_1Access().getStringBKeyword_3_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getChild2_1Access().getStringBKeyword_3_0_1()); 

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
    // $ANTLR end "rule__Child2_1__StringAlternatives_3_0"


    // $ANTLR start "rule__Child2_2__StringAlternatives_3_0"
    // InternalBug348427TestLanguage.g:1049:1: rule__Child2_2__StringAlternatives_3_0 : ( ( 'a' ) | ( 'b' ) );
    public final void rule__Child2_2__StringAlternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1053:1: ( ( 'a' ) | ( 'b' ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==11) ) {
                alt15=1;
            }
            else if ( (LA15_0==12) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalBug348427TestLanguage.g:1054:2: ( 'a' )
                    {
                    // InternalBug348427TestLanguage.g:1054:2: ( 'a' )
                    // InternalBug348427TestLanguage.g:1055:3: 'a'
                    {
                     before(grammarAccess.getChild2_2Access().getStringAKeyword_3_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getChild2_2Access().getStringAKeyword_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug348427TestLanguage.g:1060:2: ( 'b' )
                    {
                    // InternalBug348427TestLanguage.g:1060:2: ( 'b' )
                    // InternalBug348427TestLanguage.g:1061:3: 'b'
                    {
                     before(grammarAccess.getChild2_2Access().getStringBKeyword_3_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getChild2_2Access().getStringBKeyword_3_0_1()); 

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
    // $ANTLR end "rule__Child2_2__StringAlternatives_3_0"


    // $ANTLR start "rule__Child2_3__StringAlternatives_3_0"
    // InternalBug348427TestLanguage.g:1070:1: rule__Child2_3__StringAlternatives_3_0 : ( ( 'a' ) | ( 'b' ) );
    public final void rule__Child2_3__StringAlternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1074:1: ( ( 'a' ) | ( 'b' ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==11) ) {
                alt16=1;
            }
            else if ( (LA16_0==12) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalBug348427TestLanguage.g:1075:2: ( 'a' )
                    {
                    // InternalBug348427TestLanguage.g:1075:2: ( 'a' )
                    // InternalBug348427TestLanguage.g:1076:3: 'a'
                    {
                     before(grammarAccess.getChild2_3Access().getStringAKeyword_3_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getChild2_3Access().getStringAKeyword_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug348427TestLanguage.g:1081:2: ( 'b' )
                    {
                    // InternalBug348427TestLanguage.g:1081:2: ( 'b' )
                    // InternalBug348427TestLanguage.g:1082:3: 'b'
                    {
                     before(grammarAccess.getChild2_3Access().getStringBKeyword_3_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getChild2_3Access().getStringBKeyword_3_0_1()); 

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
    // $ANTLR end "rule__Child2_3__StringAlternatives_3_0"


    // $ANTLR start "rule__Child2_4__Alternatives_3"
    // InternalBug348427TestLanguage.g:1091:1: rule__Child2_4__Alternatives_3 : ( ( ( rule__Child2_4__StringAssignment_3_0 ) ) | ( ( rule__Child2_4__StringAssignment_3_1 ) ) );
    public final void rule__Child2_4__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1095:1: ( ( ( rule__Child2_4__StringAssignment_3_0 ) ) | ( ( rule__Child2_4__StringAssignment_3_1 ) ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==11) ) {
                alt17=1;
            }
            else if ( (LA17_0==12) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalBug348427TestLanguage.g:1096:2: ( ( rule__Child2_4__StringAssignment_3_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:1096:2: ( ( rule__Child2_4__StringAssignment_3_0 ) )
                    // InternalBug348427TestLanguage.g:1097:3: ( rule__Child2_4__StringAssignment_3_0 )
                    {
                     before(grammarAccess.getChild2_4Access().getStringAssignment_3_0()); 
                    // InternalBug348427TestLanguage.g:1098:3: ( rule__Child2_4__StringAssignment_3_0 )
                    // InternalBug348427TestLanguage.g:1098:4: rule__Child2_4__StringAssignment_3_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Child2_4__StringAssignment_3_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getChild2_4Access().getStringAssignment_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug348427TestLanguage.g:1102:2: ( ( rule__Child2_4__StringAssignment_3_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:1102:2: ( ( rule__Child2_4__StringAssignment_3_1 ) )
                    // InternalBug348427TestLanguage.g:1103:3: ( rule__Child2_4__StringAssignment_3_1 )
                    {
                     before(grammarAccess.getChild2_4Access().getStringAssignment_3_1()); 
                    // InternalBug348427TestLanguage.g:1104:3: ( rule__Child2_4__StringAssignment_3_1 )
                    // InternalBug348427TestLanguage.g:1104:4: rule__Child2_4__StringAssignment_3_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Child2_4__StringAssignment_3_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getChild2_4Access().getStringAssignment_3_1()); 

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
    // $ANTLR end "rule__Child2_4__Alternatives_3"


    // $ANTLR start "rule__Child2_5__Alternatives_3"
    // InternalBug348427TestLanguage.g:1112:1: rule__Child2_5__Alternatives_3 : ( ( ( rule__Child2_5__StringAssignment_3_0 ) ) | ( ( rule__Child2_5__StringAssignment_3_1 ) ) );
    public final void rule__Child2_5__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1116:1: ( ( ( rule__Child2_5__StringAssignment_3_0 ) ) | ( ( rule__Child2_5__StringAssignment_3_1 ) ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==11) ) {
                alt18=1;
            }
            else if ( (LA18_0==12) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalBug348427TestLanguage.g:1117:2: ( ( rule__Child2_5__StringAssignment_3_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:1117:2: ( ( rule__Child2_5__StringAssignment_3_0 ) )
                    // InternalBug348427TestLanguage.g:1118:3: ( rule__Child2_5__StringAssignment_3_0 )
                    {
                     before(grammarAccess.getChild2_5Access().getStringAssignment_3_0()); 
                    // InternalBug348427TestLanguage.g:1119:3: ( rule__Child2_5__StringAssignment_3_0 )
                    // InternalBug348427TestLanguage.g:1119:4: rule__Child2_5__StringAssignment_3_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Child2_5__StringAssignment_3_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getChild2_5Access().getStringAssignment_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug348427TestLanguage.g:1123:2: ( ( rule__Child2_5__StringAssignment_3_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:1123:2: ( ( rule__Child2_5__StringAssignment_3_1 ) )
                    // InternalBug348427TestLanguage.g:1124:3: ( rule__Child2_5__StringAssignment_3_1 )
                    {
                     before(grammarAccess.getChild2_5Access().getStringAssignment_3_1()); 
                    // InternalBug348427TestLanguage.g:1125:3: ( rule__Child2_5__StringAssignment_3_1 )
                    // InternalBug348427TestLanguage.g:1125:4: rule__Child2_5__StringAssignment_3_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Child2_5__StringAssignment_3_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getChild2_5Access().getStringAssignment_3_1()); 

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
    // $ANTLR end "rule__Child2_5__Alternatives_3"


    // $ANTLR start "rule__Child2_6__Alternatives_3"
    // InternalBug348427TestLanguage.g:1133:1: rule__Child2_6__Alternatives_3 : ( ( ( rule__Child2_6__StringAssignment_3_0 ) ) | ( ( rule__Child2_6__StringAssignment_3_1 ) ) );
    public final void rule__Child2_6__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1137:1: ( ( ( rule__Child2_6__StringAssignment_3_0 ) ) | ( ( rule__Child2_6__StringAssignment_3_1 ) ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==11) ) {
                alt19=1;
            }
            else if ( (LA19_0==12) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalBug348427TestLanguage.g:1138:2: ( ( rule__Child2_6__StringAssignment_3_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:1138:2: ( ( rule__Child2_6__StringAssignment_3_0 ) )
                    // InternalBug348427TestLanguage.g:1139:3: ( rule__Child2_6__StringAssignment_3_0 )
                    {
                     before(grammarAccess.getChild2_6Access().getStringAssignment_3_0()); 
                    // InternalBug348427TestLanguage.g:1140:3: ( rule__Child2_6__StringAssignment_3_0 )
                    // InternalBug348427TestLanguage.g:1140:4: rule__Child2_6__StringAssignment_3_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Child2_6__StringAssignment_3_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getChild2_6Access().getStringAssignment_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug348427TestLanguage.g:1144:2: ( ( rule__Child2_6__StringAssignment_3_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:1144:2: ( ( rule__Child2_6__StringAssignment_3_1 ) )
                    // InternalBug348427TestLanguage.g:1145:3: ( rule__Child2_6__StringAssignment_3_1 )
                    {
                     before(grammarAccess.getChild2_6Access().getStringAssignment_3_1()); 
                    // InternalBug348427TestLanguage.g:1146:3: ( rule__Child2_6__StringAssignment_3_1 )
                    // InternalBug348427TestLanguage.g:1146:4: rule__Child2_6__StringAssignment_3_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Child2_6__StringAssignment_3_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getChild2_6Access().getStringAssignment_3_1()); 

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
    // $ANTLR end "rule__Child2_6__Alternatives_3"


    // $ANTLR start "rule__EnumType__Alternatives"
    // InternalBug348427TestLanguage.g:1154:1: rule__EnumType__Alternatives : ( ( ( 'a' ) ) | ( ( 'b' ) ) );
    public final void rule__EnumType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1158:1: ( ( ( 'a' ) ) | ( ( 'b' ) ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==11) ) {
                alt20=1;
            }
            else if ( (LA20_0==12) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // InternalBug348427TestLanguage.g:1159:2: ( ( 'a' ) )
                    {
                    // InternalBug348427TestLanguage.g:1159:2: ( ( 'a' ) )
                    // InternalBug348427TestLanguage.g:1160:3: ( 'a' )
                    {
                     before(grammarAccess.getEnumTypeAccess().getAEnumLiteralDeclaration_0()); 
                    // InternalBug348427TestLanguage.g:1161:3: ( 'a' )
                    // InternalBug348427TestLanguage.g:1161:4: 'a'
                    {
                    match(input,11,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getEnumTypeAccess().getAEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug348427TestLanguage.g:1165:2: ( ( 'b' ) )
                    {
                    // InternalBug348427TestLanguage.g:1165:2: ( ( 'b' ) )
                    // InternalBug348427TestLanguage.g:1166:3: ( 'b' )
                    {
                     before(grammarAccess.getEnumTypeAccess().getBEnumLiteralDeclaration_1()); 
                    // InternalBug348427TestLanguage.g:1167:3: ( 'b' )
                    // InternalBug348427TestLanguage.g:1167:4: 'b'
                    {
                    match(input,12,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getEnumTypeAccess().getBEnumLiteralDeclaration_1()); 

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
    // $ANTLR end "rule__EnumType__Alternatives"


    // $ANTLR start "rule__Scenario1_1__Group__0"
    // InternalBug348427TestLanguage.g:1175:1: rule__Scenario1_1__Group__0 : rule__Scenario1_1__Group__0__Impl rule__Scenario1_1__Group__1 ;
    public final void rule__Scenario1_1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1179:1: ( rule__Scenario1_1__Group__0__Impl rule__Scenario1_1__Group__1 )
            // InternalBug348427TestLanguage.g:1180:2: rule__Scenario1_1__Group__0__Impl rule__Scenario1_1__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Scenario1_1__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario1_1__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_1__Group__0"


    // $ANTLR start "rule__Scenario1_1__Group__0__Impl"
    // InternalBug348427TestLanguage.g:1187:1: rule__Scenario1_1__Group__0__Impl : ( '1.1' ) ;
    public final void rule__Scenario1_1__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1191:1: ( ( '1.1' ) )
            // InternalBug348427TestLanguage.g:1192:1: ( '1.1' )
            {
            // InternalBug348427TestLanguage.g:1192:1: ( '1.1' )
            // InternalBug348427TestLanguage.g:1193:2: '1.1'
            {
             before(grammarAccess.getScenario1_1Access().getDigitOneFullStopDigitOneKeyword_0()); 
            match(input,13,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getScenario1_1Access().getDigitOneFullStopDigitOneKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_1__Group__0__Impl"


    // $ANTLR start "rule__Scenario1_1__Group__1"
    // InternalBug348427TestLanguage.g:1202:1: rule__Scenario1_1__Group__1 : rule__Scenario1_1__Group__1__Impl rule__Scenario1_1__Group__2 ;
    public final void rule__Scenario1_1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1206:1: ( rule__Scenario1_1__Group__1__Impl rule__Scenario1_1__Group__2 )
            // InternalBug348427TestLanguage.g:1207:2: rule__Scenario1_1__Group__1__Impl rule__Scenario1_1__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Scenario1_1__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario1_1__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_1__Group__1"


    // $ANTLR start "rule__Scenario1_1__Group__1__Impl"
    // InternalBug348427TestLanguage.g:1214:1: rule__Scenario1_1__Group__1__Impl : ( ( rule__Scenario1_1__Alternatives_1 ) ) ;
    public final void rule__Scenario1_1__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1218:1: ( ( ( rule__Scenario1_1__Alternatives_1 ) ) )
            // InternalBug348427TestLanguage.g:1219:1: ( ( rule__Scenario1_1__Alternatives_1 ) )
            {
            // InternalBug348427TestLanguage.g:1219:1: ( ( rule__Scenario1_1__Alternatives_1 ) )
            // InternalBug348427TestLanguage.g:1220:2: ( rule__Scenario1_1__Alternatives_1 )
            {
             before(grammarAccess.getScenario1_1Access().getAlternatives_1()); 
            // InternalBug348427TestLanguage.g:1221:2: ( rule__Scenario1_1__Alternatives_1 )
            // InternalBug348427TestLanguage.g:1221:3: rule__Scenario1_1__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario1_1__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getScenario1_1Access().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_1__Group__1__Impl"


    // $ANTLR start "rule__Scenario1_1__Group__2"
    // InternalBug348427TestLanguage.g:1229:1: rule__Scenario1_1__Group__2 : rule__Scenario1_1__Group__2__Impl ;
    public final void rule__Scenario1_1__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1233:1: ( rule__Scenario1_1__Group__2__Impl )
            // InternalBug348427TestLanguage.g:1234:2: rule__Scenario1_1__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario1_1__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_1__Group__2"


    // $ANTLR start "rule__Scenario1_1__Group__2__Impl"
    // InternalBug348427TestLanguage.g:1240:1: rule__Scenario1_1__Group__2__Impl : ( 'next' ) ;
    public final void rule__Scenario1_1__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1244:1: ( ( 'next' ) )
            // InternalBug348427TestLanguage.g:1245:1: ( 'next' )
            {
            // InternalBug348427TestLanguage.g:1245:1: ( 'next' )
            // InternalBug348427TestLanguage.g:1246:2: 'next'
            {
             before(grammarAccess.getScenario1_1Access().getNextKeyword_2()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getScenario1_1Access().getNextKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_1__Group__2__Impl"


    // $ANTLR start "rule__Scenario1_2__Group__0"
    // InternalBug348427TestLanguage.g:1256:1: rule__Scenario1_2__Group__0 : rule__Scenario1_2__Group__0__Impl rule__Scenario1_2__Group__1 ;
    public final void rule__Scenario1_2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1260:1: ( rule__Scenario1_2__Group__0__Impl rule__Scenario1_2__Group__1 )
            // InternalBug348427TestLanguage.g:1261:2: rule__Scenario1_2__Group__0__Impl rule__Scenario1_2__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Scenario1_2__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario1_2__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_2__Group__0"


    // $ANTLR start "rule__Scenario1_2__Group__0__Impl"
    // InternalBug348427TestLanguage.g:1268:1: rule__Scenario1_2__Group__0__Impl : ( '1.2' ) ;
    public final void rule__Scenario1_2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1272:1: ( ( '1.2' ) )
            // InternalBug348427TestLanguage.g:1273:1: ( '1.2' )
            {
            // InternalBug348427TestLanguage.g:1273:1: ( '1.2' )
            // InternalBug348427TestLanguage.g:1274:2: '1.2'
            {
             before(grammarAccess.getScenario1_2Access().getDigitOneFullStopDigitTwoKeyword_0()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getScenario1_2Access().getDigitOneFullStopDigitTwoKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_2__Group__0__Impl"


    // $ANTLR start "rule__Scenario1_2__Group__1"
    // InternalBug348427TestLanguage.g:1283:1: rule__Scenario1_2__Group__1 : rule__Scenario1_2__Group__1__Impl rule__Scenario1_2__Group__2 ;
    public final void rule__Scenario1_2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1287:1: ( rule__Scenario1_2__Group__1__Impl rule__Scenario1_2__Group__2 )
            // InternalBug348427TestLanguage.g:1288:2: rule__Scenario1_2__Group__1__Impl rule__Scenario1_2__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Scenario1_2__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario1_2__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_2__Group__1"


    // $ANTLR start "rule__Scenario1_2__Group__1__Impl"
    // InternalBug348427TestLanguage.g:1295:1: rule__Scenario1_2__Group__1__Impl : ( ( ( rule__Scenario1_2__Alternatives_1 ) ) ( ( rule__Scenario1_2__Alternatives_1 )* ) ) ;
    public final void rule__Scenario1_2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1299:1: ( ( ( ( rule__Scenario1_2__Alternatives_1 ) ) ( ( rule__Scenario1_2__Alternatives_1 )* ) ) )
            // InternalBug348427TestLanguage.g:1300:1: ( ( ( rule__Scenario1_2__Alternatives_1 ) ) ( ( rule__Scenario1_2__Alternatives_1 )* ) )
            {
            // InternalBug348427TestLanguage.g:1300:1: ( ( ( rule__Scenario1_2__Alternatives_1 ) ) ( ( rule__Scenario1_2__Alternatives_1 )* ) )
            // InternalBug348427TestLanguage.g:1301:2: ( ( rule__Scenario1_2__Alternatives_1 ) ) ( ( rule__Scenario1_2__Alternatives_1 )* )
            {
            // InternalBug348427TestLanguage.g:1301:2: ( ( rule__Scenario1_2__Alternatives_1 ) )
            // InternalBug348427TestLanguage.g:1302:3: ( rule__Scenario1_2__Alternatives_1 )
            {
             before(grammarAccess.getScenario1_2Access().getAlternatives_1()); 
            // InternalBug348427TestLanguage.g:1303:3: ( rule__Scenario1_2__Alternatives_1 )
            // InternalBug348427TestLanguage.g:1303:4: rule__Scenario1_2__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Scenario1_2__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getScenario1_2Access().getAlternatives_1()); 

            }

            // InternalBug348427TestLanguage.g:1306:2: ( ( rule__Scenario1_2__Alternatives_1 )* )
            // InternalBug348427TestLanguage.g:1307:3: ( rule__Scenario1_2__Alternatives_1 )*
            {
             before(grammarAccess.getScenario1_2Access().getAlternatives_1()); 
            // InternalBug348427TestLanguage.g:1308:3: ( rule__Scenario1_2__Alternatives_1 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_ID) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalBug348427TestLanguage.g:1308:4: rule__Scenario1_2__Alternatives_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    rule__Scenario1_2__Alternatives_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getScenario1_2Access().getAlternatives_1()); 

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
    // $ANTLR end "rule__Scenario1_2__Group__1__Impl"


    // $ANTLR start "rule__Scenario1_2__Group__2"
    // InternalBug348427TestLanguage.g:1317:1: rule__Scenario1_2__Group__2 : rule__Scenario1_2__Group__2__Impl ;
    public final void rule__Scenario1_2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1321:1: ( rule__Scenario1_2__Group__2__Impl )
            // InternalBug348427TestLanguage.g:1322:2: rule__Scenario1_2__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario1_2__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_2__Group__2"


    // $ANTLR start "rule__Scenario1_2__Group__2__Impl"
    // InternalBug348427TestLanguage.g:1328:1: rule__Scenario1_2__Group__2__Impl : ( 'next' ) ;
    public final void rule__Scenario1_2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1332:1: ( ( 'next' ) )
            // InternalBug348427TestLanguage.g:1333:1: ( 'next' )
            {
            // InternalBug348427TestLanguage.g:1333:1: ( 'next' )
            // InternalBug348427TestLanguage.g:1334:2: 'next'
            {
             before(grammarAccess.getScenario1_2Access().getNextKeyword_2()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getScenario1_2Access().getNextKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_2__Group__2__Impl"


    // $ANTLR start "rule__Scenario1_3__Group__0"
    // InternalBug348427TestLanguage.g:1344:1: rule__Scenario1_3__Group__0 : rule__Scenario1_3__Group__0__Impl rule__Scenario1_3__Group__1 ;
    public final void rule__Scenario1_3__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1348:1: ( rule__Scenario1_3__Group__0__Impl rule__Scenario1_3__Group__1 )
            // InternalBug348427TestLanguage.g:1349:2: rule__Scenario1_3__Group__0__Impl rule__Scenario1_3__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Scenario1_3__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario1_3__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_3__Group__0"


    // $ANTLR start "rule__Scenario1_3__Group__0__Impl"
    // InternalBug348427TestLanguage.g:1356:1: rule__Scenario1_3__Group__0__Impl : ( () ) ;
    public final void rule__Scenario1_3__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1360:1: ( ( () ) )
            // InternalBug348427TestLanguage.g:1361:1: ( () )
            {
            // InternalBug348427TestLanguage.g:1361:1: ( () )
            // InternalBug348427TestLanguage.g:1362:2: ()
            {
             before(grammarAccess.getScenario1_3Access().getScenario1Action_0()); 
            // InternalBug348427TestLanguage.g:1363:2: ()
            // InternalBug348427TestLanguage.g:1363:3: 
            {
            }

             after(grammarAccess.getScenario1_3Access().getScenario1Action_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_3__Group__0__Impl"


    // $ANTLR start "rule__Scenario1_3__Group__1"
    // InternalBug348427TestLanguage.g:1371:1: rule__Scenario1_3__Group__1 : rule__Scenario1_3__Group__1__Impl rule__Scenario1_3__Group__2 ;
    public final void rule__Scenario1_3__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1375:1: ( rule__Scenario1_3__Group__1__Impl rule__Scenario1_3__Group__2 )
            // InternalBug348427TestLanguage.g:1376:2: rule__Scenario1_3__Group__1__Impl rule__Scenario1_3__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Scenario1_3__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario1_3__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_3__Group__1"


    // $ANTLR start "rule__Scenario1_3__Group__1__Impl"
    // InternalBug348427TestLanguage.g:1383:1: rule__Scenario1_3__Group__1__Impl : ( '1.3' ) ;
    public final void rule__Scenario1_3__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1387:1: ( ( '1.3' ) )
            // InternalBug348427TestLanguage.g:1388:1: ( '1.3' )
            {
            // InternalBug348427TestLanguage.g:1388:1: ( '1.3' )
            // InternalBug348427TestLanguage.g:1389:2: '1.3'
            {
             before(grammarAccess.getScenario1_3Access().getDigitOneFullStopDigitThreeKeyword_1()); 
            match(input,16,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getScenario1_3Access().getDigitOneFullStopDigitThreeKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_3__Group__1__Impl"


    // $ANTLR start "rule__Scenario1_3__Group__2"
    // InternalBug348427TestLanguage.g:1398:1: rule__Scenario1_3__Group__2 : rule__Scenario1_3__Group__2__Impl rule__Scenario1_3__Group__3 ;
    public final void rule__Scenario1_3__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1402:1: ( rule__Scenario1_3__Group__2__Impl rule__Scenario1_3__Group__3 )
            // InternalBug348427TestLanguage.g:1403:2: rule__Scenario1_3__Group__2__Impl rule__Scenario1_3__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Scenario1_3__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario1_3__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_3__Group__2"


    // $ANTLR start "rule__Scenario1_3__Group__2__Impl"
    // InternalBug348427TestLanguage.g:1410:1: rule__Scenario1_3__Group__2__Impl : ( ( rule__Scenario1_3__Alternatives_2 )* ) ;
    public final void rule__Scenario1_3__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1414:1: ( ( ( rule__Scenario1_3__Alternatives_2 )* ) )
            // InternalBug348427TestLanguage.g:1415:1: ( ( rule__Scenario1_3__Alternatives_2 )* )
            {
            // InternalBug348427TestLanguage.g:1415:1: ( ( rule__Scenario1_3__Alternatives_2 )* )
            // InternalBug348427TestLanguage.g:1416:2: ( rule__Scenario1_3__Alternatives_2 )*
            {
             before(grammarAccess.getScenario1_3Access().getAlternatives_2()); 
            // InternalBug348427TestLanguage.g:1417:2: ( rule__Scenario1_3__Alternatives_2 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_ID) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalBug348427TestLanguage.g:1417:3: rule__Scenario1_3__Alternatives_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    rule__Scenario1_3__Alternatives_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getScenario1_3Access().getAlternatives_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_3__Group__2__Impl"


    // $ANTLR start "rule__Scenario1_3__Group__3"
    // InternalBug348427TestLanguage.g:1425:1: rule__Scenario1_3__Group__3 : rule__Scenario1_3__Group__3__Impl ;
    public final void rule__Scenario1_3__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1429:1: ( rule__Scenario1_3__Group__3__Impl )
            // InternalBug348427TestLanguage.g:1430:2: rule__Scenario1_3__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario1_3__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_3__Group__3"


    // $ANTLR start "rule__Scenario1_3__Group__3__Impl"
    // InternalBug348427TestLanguage.g:1436:1: rule__Scenario1_3__Group__3__Impl : ( 'next' ) ;
    public final void rule__Scenario1_3__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1440:1: ( ( 'next' ) )
            // InternalBug348427TestLanguage.g:1441:1: ( 'next' )
            {
            // InternalBug348427TestLanguage.g:1441:1: ( 'next' )
            // InternalBug348427TestLanguage.g:1442:2: 'next'
            {
             before(grammarAccess.getScenario1_3Access().getNextKeyword_3()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getScenario1_3Access().getNextKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_3__Group__3__Impl"


    // $ANTLR start "rule__Scenario1_4__Group__0"
    // InternalBug348427TestLanguage.g:1452:1: rule__Scenario1_4__Group__0 : rule__Scenario1_4__Group__0__Impl rule__Scenario1_4__Group__1 ;
    public final void rule__Scenario1_4__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1456:1: ( rule__Scenario1_4__Group__0__Impl rule__Scenario1_4__Group__1 )
            // InternalBug348427TestLanguage.g:1457:2: rule__Scenario1_4__Group__0__Impl rule__Scenario1_4__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Scenario1_4__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario1_4__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_4__Group__0"


    // $ANTLR start "rule__Scenario1_4__Group__0__Impl"
    // InternalBug348427TestLanguage.g:1464:1: rule__Scenario1_4__Group__0__Impl : ( () ) ;
    public final void rule__Scenario1_4__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1468:1: ( ( () ) )
            // InternalBug348427TestLanguage.g:1469:1: ( () )
            {
            // InternalBug348427TestLanguage.g:1469:1: ( () )
            // InternalBug348427TestLanguage.g:1470:2: ()
            {
             before(grammarAccess.getScenario1_4Access().getScenario1Action_0()); 
            // InternalBug348427TestLanguage.g:1471:2: ()
            // InternalBug348427TestLanguage.g:1471:3: 
            {
            }

             after(grammarAccess.getScenario1_4Access().getScenario1Action_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_4__Group__0__Impl"


    // $ANTLR start "rule__Scenario1_4__Group__1"
    // InternalBug348427TestLanguage.g:1479:1: rule__Scenario1_4__Group__1 : rule__Scenario1_4__Group__1__Impl rule__Scenario1_4__Group__2 ;
    public final void rule__Scenario1_4__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1483:1: ( rule__Scenario1_4__Group__1__Impl rule__Scenario1_4__Group__2 )
            // InternalBug348427TestLanguage.g:1484:2: rule__Scenario1_4__Group__1__Impl rule__Scenario1_4__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Scenario1_4__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario1_4__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_4__Group__1"


    // $ANTLR start "rule__Scenario1_4__Group__1__Impl"
    // InternalBug348427TestLanguage.g:1491:1: rule__Scenario1_4__Group__1__Impl : ( '1.4' ) ;
    public final void rule__Scenario1_4__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1495:1: ( ( '1.4' ) )
            // InternalBug348427TestLanguage.g:1496:1: ( '1.4' )
            {
            // InternalBug348427TestLanguage.g:1496:1: ( '1.4' )
            // InternalBug348427TestLanguage.g:1497:2: '1.4'
            {
             before(grammarAccess.getScenario1_4Access().getDigitOneFullStopDigitFourKeyword_1()); 
            match(input,17,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getScenario1_4Access().getDigitOneFullStopDigitFourKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_4__Group__1__Impl"


    // $ANTLR start "rule__Scenario1_4__Group__2"
    // InternalBug348427TestLanguage.g:1506:1: rule__Scenario1_4__Group__2 : rule__Scenario1_4__Group__2__Impl rule__Scenario1_4__Group__3 ;
    public final void rule__Scenario1_4__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1510:1: ( rule__Scenario1_4__Group__2__Impl rule__Scenario1_4__Group__3 )
            // InternalBug348427TestLanguage.g:1511:2: rule__Scenario1_4__Group__2__Impl rule__Scenario1_4__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Scenario1_4__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario1_4__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_4__Group__2"


    // $ANTLR start "rule__Scenario1_4__Group__2__Impl"
    // InternalBug348427TestLanguage.g:1518:1: rule__Scenario1_4__Group__2__Impl : ( ( rule__Scenario1_4__Alternatives_2 )? ) ;
    public final void rule__Scenario1_4__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1522:1: ( ( ( rule__Scenario1_4__Alternatives_2 )? ) )
            // InternalBug348427TestLanguage.g:1523:1: ( ( rule__Scenario1_4__Alternatives_2 )? )
            {
            // InternalBug348427TestLanguage.g:1523:1: ( ( rule__Scenario1_4__Alternatives_2 )? )
            // InternalBug348427TestLanguage.g:1524:2: ( rule__Scenario1_4__Alternatives_2 )?
            {
             before(grammarAccess.getScenario1_4Access().getAlternatives_2()); 
            // InternalBug348427TestLanguage.g:1525:2: ( rule__Scenario1_4__Alternatives_2 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_ID) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalBug348427TestLanguage.g:1525:3: rule__Scenario1_4__Alternatives_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario1_4__Alternatives_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getScenario1_4Access().getAlternatives_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_4__Group__2__Impl"


    // $ANTLR start "rule__Scenario1_4__Group__3"
    // InternalBug348427TestLanguage.g:1533:1: rule__Scenario1_4__Group__3 : rule__Scenario1_4__Group__3__Impl ;
    public final void rule__Scenario1_4__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1537:1: ( rule__Scenario1_4__Group__3__Impl )
            // InternalBug348427TestLanguage.g:1538:2: rule__Scenario1_4__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario1_4__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_4__Group__3"


    // $ANTLR start "rule__Scenario1_4__Group__3__Impl"
    // InternalBug348427TestLanguage.g:1544:1: rule__Scenario1_4__Group__3__Impl : ( 'next' ) ;
    public final void rule__Scenario1_4__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1548:1: ( ( 'next' ) )
            // InternalBug348427TestLanguage.g:1549:1: ( 'next' )
            {
            // InternalBug348427TestLanguage.g:1549:1: ( 'next' )
            // InternalBug348427TestLanguage.g:1550:2: 'next'
            {
             before(grammarAccess.getScenario1_4Access().getNextKeyword_3()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getScenario1_4Access().getNextKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_4__Group__3__Impl"


    // $ANTLR start "rule__Child1_1__Group__0"
    // InternalBug348427TestLanguage.g:1560:1: rule__Child1_1__Group__0 : rule__Child1_1__Group__0__Impl rule__Child1_1__Group__1 ;
    public final void rule__Child1_1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1564:1: ( rule__Child1_1__Group__0__Impl rule__Child1_1__Group__1 )
            // InternalBug348427TestLanguage.g:1565:2: rule__Child1_1__Group__0__Impl rule__Child1_1__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__Child1_1__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child1_1__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_1__Group__0"


    // $ANTLR start "rule__Child1_1__Group__0__Impl"
    // InternalBug348427TestLanguage.g:1572:1: rule__Child1_1__Group__0__Impl : ( ( rule__Child1_1__NameAssignment_0 ) ) ;
    public final void rule__Child1_1__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1576:1: ( ( ( rule__Child1_1__NameAssignment_0 ) ) )
            // InternalBug348427TestLanguage.g:1577:1: ( ( rule__Child1_1__NameAssignment_0 ) )
            {
            // InternalBug348427TestLanguage.g:1577:1: ( ( rule__Child1_1__NameAssignment_0 ) )
            // InternalBug348427TestLanguage.g:1578:2: ( rule__Child1_1__NameAssignment_0 )
            {
             before(grammarAccess.getChild1_1Access().getNameAssignment_0()); 
            // InternalBug348427TestLanguage.g:1579:2: ( rule__Child1_1__NameAssignment_0 )
            // InternalBug348427TestLanguage.g:1579:3: rule__Child1_1__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child1_1__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getChild1_1Access().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_1__Group__0__Impl"


    // $ANTLR start "rule__Child1_1__Group__1"
    // InternalBug348427TestLanguage.g:1587:1: rule__Child1_1__Group__1 : rule__Child1_1__Group__1__Impl rule__Child1_1__Group__2 ;
    public final void rule__Child1_1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1591:1: ( rule__Child1_1__Group__1__Impl rule__Child1_1__Group__2 )
            // InternalBug348427TestLanguage.g:1592:2: rule__Child1_1__Group__1__Impl rule__Child1_1__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Child1_1__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child1_1__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_1__Group__1"


    // $ANTLR start "rule__Child1_1__Group__1__Impl"
    // InternalBug348427TestLanguage.g:1599:1: rule__Child1_1__Group__1__Impl : ( ':' ) ;
    public final void rule__Child1_1__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1603:1: ( ( ':' ) )
            // InternalBug348427TestLanguage.g:1604:1: ( ':' )
            {
            // InternalBug348427TestLanguage.g:1604:1: ( ':' )
            // InternalBug348427TestLanguage.g:1605:2: ':'
            {
             before(grammarAccess.getChild1_1Access().getColonKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild1_1Access().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_1__Group__1__Impl"


    // $ANTLR start "rule__Child1_1__Group__2"
    // InternalBug348427TestLanguage.g:1614:1: rule__Child1_1__Group__2 : rule__Child1_1__Group__2__Impl rule__Child1_1__Group__3 ;
    public final void rule__Child1_1__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1618:1: ( rule__Child1_1__Group__2__Impl rule__Child1_1__Group__3 )
            // InternalBug348427TestLanguage.g:1619:2: rule__Child1_1__Group__2__Impl rule__Child1_1__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Child1_1__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child1_1__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_1__Group__2"


    // $ANTLR start "rule__Child1_1__Group__2__Impl"
    // InternalBug348427TestLanguage.g:1626:1: rule__Child1_1__Group__2__Impl : ( ( rule__Child1_1__Group_2__0 )? ) ;
    public final void rule__Child1_1__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1630:1: ( ( ( rule__Child1_1__Group_2__0 )? ) )
            // InternalBug348427TestLanguage.g:1631:1: ( ( rule__Child1_1__Group_2__0 )? )
            {
            // InternalBug348427TestLanguage.g:1631:1: ( ( rule__Child1_1__Group_2__0 )? )
            // InternalBug348427TestLanguage.g:1632:2: ( rule__Child1_1__Group_2__0 )?
            {
             before(grammarAccess.getChild1_1Access().getGroup_2()); 
            // InternalBug348427TestLanguage.g:1633:2: ( rule__Child1_1__Group_2__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==32) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalBug348427TestLanguage.g:1633:3: rule__Child1_1__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Child1_1__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getChild1_1Access().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_1__Group__2__Impl"


    // $ANTLR start "rule__Child1_1__Group__3"
    // InternalBug348427TestLanguage.g:1641:1: rule__Child1_1__Group__3 : rule__Child1_1__Group__3__Impl rule__Child1_1__Group__4 ;
    public final void rule__Child1_1__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1645:1: ( rule__Child1_1__Group__3__Impl rule__Child1_1__Group__4 )
            // InternalBug348427TestLanguage.g:1646:2: rule__Child1_1__Group__3__Impl rule__Child1_1__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__Child1_1__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child1_1__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_1__Group__3"


    // $ANTLR start "rule__Child1_1__Group__3__Impl"
    // InternalBug348427TestLanguage.g:1653:1: rule__Child1_1__Group__3__Impl : ( ( rule__Child1_1__EnumTypeAssignment_3 ) ) ;
    public final void rule__Child1_1__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1657:1: ( ( ( rule__Child1_1__EnumTypeAssignment_3 ) ) )
            // InternalBug348427TestLanguage.g:1658:1: ( ( rule__Child1_1__EnumTypeAssignment_3 ) )
            {
            // InternalBug348427TestLanguage.g:1658:1: ( ( rule__Child1_1__EnumTypeAssignment_3 ) )
            // InternalBug348427TestLanguage.g:1659:2: ( rule__Child1_1__EnumTypeAssignment_3 )
            {
             before(grammarAccess.getChild1_1Access().getEnumTypeAssignment_3()); 
            // InternalBug348427TestLanguage.g:1660:2: ( rule__Child1_1__EnumTypeAssignment_3 )
            // InternalBug348427TestLanguage.g:1660:3: rule__Child1_1__EnumTypeAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child1_1__EnumTypeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getChild1_1Access().getEnumTypeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_1__Group__3__Impl"


    // $ANTLR start "rule__Child1_1__Group__4"
    // InternalBug348427TestLanguage.g:1668:1: rule__Child1_1__Group__4 : rule__Child1_1__Group__4__Impl rule__Child1_1__Group__5 ;
    public final void rule__Child1_1__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1672:1: ( rule__Child1_1__Group__4__Impl rule__Child1_1__Group__5 )
            // InternalBug348427TestLanguage.g:1673:2: rule__Child1_1__Group__4__Impl rule__Child1_1__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__Child1_1__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child1_1__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_1__Group__4"


    // $ANTLR start "rule__Child1_1__Group__4__Impl"
    // InternalBug348427TestLanguage.g:1680:1: rule__Child1_1__Group__4__Impl : ( 'child1' ) ;
    public final void rule__Child1_1__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1684:1: ( ( 'child1' ) )
            // InternalBug348427TestLanguage.g:1685:1: ( 'child1' )
            {
            // InternalBug348427TestLanguage.g:1685:1: ( 'child1' )
            // InternalBug348427TestLanguage.g:1686:2: 'child1'
            {
             before(grammarAccess.getChild1_1Access().getChild1Keyword_4()); 
            match(input,19,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild1_1Access().getChild1Keyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_1__Group__4__Impl"


    // $ANTLR start "rule__Child1_1__Group__5"
    // InternalBug348427TestLanguage.g:1695:1: rule__Child1_1__Group__5 : rule__Child1_1__Group__5__Impl ;
    public final void rule__Child1_1__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1699:1: ( rule__Child1_1__Group__5__Impl )
            // InternalBug348427TestLanguage.g:1700:2: rule__Child1_1__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child1_1__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_1__Group__5"


    // $ANTLR start "rule__Child1_1__Group__5__Impl"
    // InternalBug348427TestLanguage.g:1706:1: rule__Child1_1__Group__5__Impl : ( 'end' ) ;
    public final void rule__Child1_1__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1710:1: ( ( 'end' ) )
            // InternalBug348427TestLanguage.g:1711:1: ( 'end' )
            {
            // InternalBug348427TestLanguage.g:1711:1: ( 'end' )
            // InternalBug348427TestLanguage.g:1712:2: 'end'
            {
             before(grammarAccess.getChild1_1Access().getEndKeyword_5()); 
            match(input,20,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild1_1Access().getEndKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_1__Group__5__Impl"


    // $ANTLR start "rule__Child1_1__Group_2__0"
    // InternalBug348427TestLanguage.g:1722:1: rule__Child1_1__Group_2__0 : rule__Child1_1__Group_2__0__Impl rule__Child1_1__Group_2__1 ;
    public final void rule__Child1_1__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1726:1: ( rule__Child1_1__Group_2__0__Impl rule__Child1_1__Group_2__1 )
            // InternalBug348427TestLanguage.g:1727:2: rule__Child1_1__Group_2__0__Impl rule__Child1_1__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__Child1_1__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child1_1__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_1__Group_2__0"


    // $ANTLR start "rule__Child1_1__Group_2__0__Impl"
    // InternalBug348427TestLanguage.g:1734:1: rule__Child1_1__Group_2__0__Impl : ( ( rule__Child1_1__BoolAssignment_2_0 ) ) ;
    public final void rule__Child1_1__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1738:1: ( ( ( rule__Child1_1__BoolAssignment_2_0 ) ) )
            // InternalBug348427TestLanguage.g:1739:1: ( ( rule__Child1_1__BoolAssignment_2_0 ) )
            {
            // InternalBug348427TestLanguage.g:1739:1: ( ( rule__Child1_1__BoolAssignment_2_0 ) )
            // InternalBug348427TestLanguage.g:1740:2: ( rule__Child1_1__BoolAssignment_2_0 )
            {
             before(grammarAccess.getChild1_1Access().getBoolAssignment_2_0()); 
            // InternalBug348427TestLanguage.g:1741:2: ( rule__Child1_1__BoolAssignment_2_0 )
            // InternalBug348427TestLanguage.g:1741:3: rule__Child1_1__BoolAssignment_2_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child1_1__BoolAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getChild1_1Access().getBoolAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_1__Group_2__0__Impl"


    // $ANTLR start "rule__Child1_1__Group_2__1"
    // InternalBug348427TestLanguage.g:1749:1: rule__Child1_1__Group_2__1 : rule__Child1_1__Group_2__1__Impl ;
    public final void rule__Child1_1__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1753:1: ( rule__Child1_1__Group_2__1__Impl )
            // InternalBug348427TestLanguage.g:1754:2: rule__Child1_1__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child1_1__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_1__Group_2__1"


    // $ANTLR start "rule__Child1_1__Group_2__1__Impl"
    // InternalBug348427TestLanguage.g:1760:1: rule__Child1_1__Group_2__1__Impl : ( 'keyword' ) ;
    public final void rule__Child1_1__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1764:1: ( ( 'keyword' ) )
            // InternalBug348427TestLanguage.g:1765:1: ( 'keyword' )
            {
            // InternalBug348427TestLanguage.g:1765:1: ( 'keyword' )
            // InternalBug348427TestLanguage.g:1766:2: 'keyword'
            {
             before(grammarAccess.getChild1_1Access().getKeywordKeyword_2_1()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild1_1Access().getKeywordKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_1__Group_2__1__Impl"


    // $ANTLR start "rule__Child1_2__Group__0"
    // InternalBug348427TestLanguage.g:1776:1: rule__Child1_2__Group__0 : rule__Child1_2__Group__0__Impl rule__Child1_2__Group__1 ;
    public final void rule__Child1_2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1780:1: ( rule__Child1_2__Group__0__Impl rule__Child1_2__Group__1 )
            // InternalBug348427TestLanguage.g:1781:2: rule__Child1_2__Group__0__Impl rule__Child1_2__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__Child1_2__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child1_2__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_2__Group__0"


    // $ANTLR start "rule__Child1_2__Group__0__Impl"
    // InternalBug348427TestLanguage.g:1788:1: rule__Child1_2__Group__0__Impl : ( ( rule__Child1_2__NameAssignment_0 ) ) ;
    public final void rule__Child1_2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1792:1: ( ( ( rule__Child1_2__NameAssignment_0 ) ) )
            // InternalBug348427TestLanguage.g:1793:1: ( ( rule__Child1_2__NameAssignment_0 ) )
            {
            // InternalBug348427TestLanguage.g:1793:1: ( ( rule__Child1_2__NameAssignment_0 ) )
            // InternalBug348427TestLanguage.g:1794:2: ( rule__Child1_2__NameAssignment_0 )
            {
             before(grammarAccess.getChild1_2Access().getNameAssignment_0()); 
            // InternalBug348427TestLanguage.g:1795:2: ( rule__Child1_2__NameAssignment_0 )
            // InternalBug348427TestLanguage.g:1795:3: rule__Child1_2__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child1_2__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getChild1_2Access().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_2__Group__0__Impl"


    // $ANTLR start "rule__Child1_2__Group__1"
    // InternalBug348427TestLanguage.g:1803:1: rule__Child1_2__Group__1 : rule__Child1_2__Group__1__Impl rule__Child1_2__Group__2 ;
    public final void rule__Child1_2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1807:1: ( rule__Child1_2__Group__1__Impl rule__Child1_2__Group__2 )
            // InternalBug348427TestLanguage.g:1808:2: rule__Child1_2__Group__1__Impl rule__Child1_2__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Child1_2__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child1_2__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_2__Group__1"


    // $ANTLR start "rule__Child1_2__Group__1__Impl"
    // InternalBug348427TestLanguage.g:1815:1: rule__Child1_2__Group__1__Impl : ( ':' ) ;
    public final void rule__Child1_2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1819:1: ( ( ':' ) )
            // InternalBug348427TestLanguage.g:1820:1: ( ':' )
            {
            // InternalBug348427TestLanguage.g:1820:1: ( ':' )
            // InternalBug348427TestLanguage.g:1821:2: ':'
            {
             before(grammarAccess.getChild1_2Access().getColonKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild1_2Access().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_2__Group__1__Impl"


    // $ANTLR start "rule__Child1_2__Group__2"
    // InternalBug348427TestLanguage.g:1830:1: rule__Child1_2__Group__2 : rule__Child1_2__Group__2__Impl rule__Child1_2__Group__3 ;
    public final void rule__Child1_2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1834:1: ( rule__Child1_2__Group__2__Impl rule__Child1_2__Group__3 )
            // InternalBug348427TestLanguage.g:1835:2: rule__Child1_2__Group__2__Impl rule__Child1_2__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Child1_2__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child1_2__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_2__Group__2"


    // $ANTLR start "rule__Child1_2__Group__2__Impl"
    // InternalBug348427TestLanguage.g:1842:1: rule__Child1_2__Group__2__Impl : ( ( rule__Child1_2__Group_2__0 )? ) ;
    public final void rule__Child1_2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1846:1: ( ( ( rule__Child1_2__Group_2__0 )? ) )
            // InternalBug348427TestLanguage.g:1847:1: ( ( rule__Child1_2__Group_2__0 )? )
            {
            // InternalBug348427TestLanguage.g:1847:1: ( ( rule__Child1_2__Group_2__0 )? )
            // InternalBug348427TestLanguage.g:1848:2: ( rule__Child1_2__Group_2__0 )?
            {
             before(grammarAccess.getChild1_2Access().getGroup_2()); 
            // InternalBug348427TestLanguage.g:1849:2: ( rule__Child1_2__Group_2__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==32) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalBug348427TestLanguage.g:1849:3: rule__Child1_2__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Child1_2__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getChild1_2Access().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_2__Group__2__Impl"


    // $ANTLR start "rule__Child1_2__Group__3"
    // InternalBug348427TestLanguage.g:1857:1: rule__Child1_2__Group__3 : rule__Child1_2__Group__3__Impl rule__Child1_2__Group__4 ;
    public final void rule__Child1_2__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1861:1: ( rule__Child1_2__Group__3__Impl rule__Child1_2__Group__4 )
            // InternalBug348427TestLanguage.g:1862:2: rule__Child1_2__Group__3__Impl rule__Child1_2__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_14);
            rule__Child1_2__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child1_2__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_2__Group__3"


    // $ANTLR start "rule__Child1_2__Group__3__Impl"
    // InternalBug348427TestLanguage.g:1869:1: rule__Child1_2__Group__3__Impl : ( ( rule__Child1_2__EnumTypeAssignment_3 ) ) ;
    public final void rule__Child1_2__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1873:1: ( ( ( rule__Child1_2__EnumTypeAssignment_3 ) ) )
            // InternalBug348427TestLanguage.g:1874:1: ( ( rule__Child1_2__EnumTypeAssignment_3 ) )
            {
            // InternalBug348427TestLanguage.g:1874:1: ( ( rule__Child1_2__EnumTypeAssignment_3 ) )
            // InternalBug348427TestLanguage.g:1875:2: ( rule__Child1_2__EnumTypeAssignment_3 )
            {
             before(grammarAccess.getChild1_2Access().getEnumTypeAssignment_3()); 
            // InternalBug348427TestLanguage.g:1876:2: ( rule__Child1_2__EnumTypeAssignment_3 )
            // InternalBug348427TestLanguage.g:1876:3: rule__Child1_2__EnumTypeAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child1_2__EnumTypeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getChild1_2Access().getEnumTypeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_2__Group__3__Impl"


    // $ANTLR start "rule__Child1_2__Group__4"
    // InternalBug348427TestLanguage.g:1884:1: rule__Child1_2__Group__4 : rule__Child1_2__Group__4__Impl rule__Child1_2__Group__5 ;
    public final void rule__Child1_2__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1888:1: ( rule__Child1_2__Group__4__Impl rule__Child1_2__Group__5 )
            // InternalBug348427TestLanguage.g:1889:2: rule__Child1_2__Group__4__Impl rule__Child1_2__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__Child1_2__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child1_2__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_2__Group__4"


    // $ANTLR start "rule__Child1_2__Group__4__Impl"
    // InternalBug348427TestLanguage.g:1896:1: rule__Child1_2__Group__4__Impl : ( 'child2' ) ;
    public final void rule__Child1_2__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1900:1: ( ( 'child2' ) )
            // InternalBug348427TestLanguage.g:1901:1: ( 'child2' )
            {
            // InternalBug348427TestLanguage.g:1901:1: ( 'child2' )
            // InternalBug348427TestLanguage.g:1902:2: 'child2'
            {
             before(grammarAccess.getChild1_2Access().getChild2Keyword_4()); 
            match(input,22,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild1_2Access().getChild2Keyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_2__Group__4__Impl"


    // $ANTLR start "rule__Child1_2__Group__5"
    // InternalBug348427TestLanguage.g:1911:1: rule__Child1_2__Group__5 : rule__Child1_2__Group__5__Impl ;
    public final void rule__Child1_2__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1915:1: ( rule__Child1_2__Group__5__Impl )
            // InternalBug348427TestLanguage.g:1916:2: rule__Child1_2__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child1_2__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_2__Group__5"


    // $ANTLR start "rule__Child1_2__Group__5__Impl"
    // InternalBug348427TestLanguage.g:1922:1: rule__Child1_2__Group__5__Impl : ( 'end' ) ;
    public final void rule__Child1_2__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1926:1: ( ( 'end' ) )
            // InternalBug348427TestLanguage.g:1927:1: ( 'end' )
            {
            // InternalBug348427TestLanguage.g:1927:1: ( 'end' )
            // InternalBug348427TestLanguage.g:1928:2: 'end'
            {
             before(grammarAccess.getChild1_2Access().getEndKeyword_5()); 
            match(input,20,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild1_2Access().getEndKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_2__Group__5__Impl"


    // $ANTLR start "rule__Child1_2__Group_2__0"
    // InternalBug348427TestLanguage.g:1938:1: rule__Child1_2__Group_2__0 : rule__Child1_2__Group_2__0__Impl rule__Child1_2__Group_2__1 ;
    public final void rule__Child1_2__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1942:1: ( rule__Child1_2__Group_2__0__Impl rule__Child1_2__Group_2__1 )
            // InternalBug348427TestLanguage.g:1943:2: rule__Child1_2__Group_2__0__Impl rule__Child1_2__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__Child1_2__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child1_2__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_2__Group_2__0"


    // $ANTLR start "rule__Child1_2__Group_2__0__Impl"
    // InternalBug348427TestLanguage.g:1950:1: rule__Child1_2__Group_2__0__Impl : ( ( rule__Child1_2__BoolAssignment_2_0 ) ) ;
    public final void rule__Child1_2__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1954:1: ( ( ( rule__Child1_2__BoolAssignment_2_0 ) ) )
            // InternalBug348427TestLanguage.g:1955:1: ( ( rule__Child1_2__BoolAssignment_2_0 ) )
            {
            // InternalBug348427TestLanguage.g:1955:1: ( ( rule__Child1_2__BoolAssignment_2_0 ) )
            // InternalBug348427TestLanguage.g:1956:2: ( rule__Child1_2__BoolAssignment_2_0 )
            {
             before(grammarAccess.getChild1_2Access().getBoolAssignment_2_0()); 
            // InternalBug348427TestLanguage.g:1957:2: ( rule__Child1_2__BoolAssignment_2_0 )
            // InternalBug348427TestLanguage.g:1957:3: rule__Child1_2__BoolAssignment_2_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child1_2__BoolAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getChild1_2Access().getBoolAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_2__Group_2__0__Impl"


    // $ANTLR start "rule__Child1_2__Group_2__1"
    // InternalBug348427TestLanguage.g:1965:1: rule__Child1_2__Group_2__1 : rule__Child1_2__Group_2__1__Impl ;
    public final void rule__Child1_2__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1969:1: ( rule__Child1_2__Group_2__1__Impl )
            // InternalBug348427TestLanguage.g:1970:2: rule__Child1_2__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child1_2__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_2__Group_2__1"


    // $ANTLR start "rule__Child1_2__Group_2__1__Impl"
    // InternalBug348427TestLanguage.g:1976:1: rule__Child1_2__Group_2__1__Impl : ( 'keyword' ) ;
    public final void rule__Child1_2__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1980:1: ( ( 'keyword' ) )
            // InternalBug348427TestLanguage.g:1981:1: ( 'keyword' )
            {
            // InternalBug348427TestLanguage.g:1981:1: ( 'keyword' )
            // InternalBug348427TestLanguage.g:1982:2: 'keyword'
            {
             before(grammarAccess.getChild1_2Access().getKeywordKeyword_2_1()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild1_2Access().getKeywordKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_2__Group_2__1__Impl"


    // $ANTLR start "rule__Child1_3__Group__0"
    // InternalBug348427TestLanguage.g:1992:1: rule__Child1_3__Group__0 : rule__Child1_3__Group__0__Impl rule__Child1_3__Group__1 ;
    public final void rule__Child1_3__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1996:1: ( rule__Child1_3__Group__0__Impl rule__Child1_3__Group__1 )
            // InternalBug348427TestLanguage.g:1997:2: rule__Child1_3__Group__0__Impl rule__Child1_3__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__Child1_3__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child1_3__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_3__Group__0"


    // $ANTLR start "rule__Child1_3__Group__0__Impl"
    // InternalBug348427TestLanguage.g:2004:1: rule__Child1_3__Group__0__Impl : ( ( rule__Child1_3__NameAssignment_0 ) ) ;
    public final void rule__Child1_3__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2008:1: ( ( ( rule__Child1_3__NameAssignment_0 ) ) )
            // InternalBug348427TestLanguage.g:2009:1: ( ( rule__Child1_3__NameAssignment_0 ) )
            {
            // InternalBug348427TestLanguage.g:2009:1: ( ( rule__Child1_3__NameAssignment_0 ) )
            // InternalBug348427TestLanguage.g:2010:2: ( rule__Child1_3__NameAssignment_0 )
            {
             before(grammarAccess.getChild1_3Access().getNameAssignment_0()); 
            // InternalBug348427TestLanguage.g:2011:2: ( rule__Child1_3__NameAssignment_0 )
            // InternalBug348427TestLanguage.g:2011:3: rule__Child1_3__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child1_3__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getChild1_3Access().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_3__Group__0__Impl"


    // $ANTLR start "rule__Child1_3__Group__1"
    // InternalBug348427TestLanguage.g:2019:1: rule__Child1_3__Group__1 : rule__Child1_3__Group__1__Impl rule__Child1_3__Group__2 ;
    public final void rule__Child1_3__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2023:1: ( rule__Child1_3__Group__1__Impl rule__Child1_3__Group__2 )
            // InternalBug348427TestLanguage.g:2024:2: rule__Child1_3__Group__1__Impl rule__Child1_3__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Child1_3__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child1_3__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_3__Group__1"


    // $ANTLR start "rule__Child1_3__Group__1__Impl"
    // InternalBug348427TestLanguage.g:2031:1: rule__Child1_3__Group__1__Impl : ( ':' ) ;
    public final void rule__Child1_3__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2035:1: ( ( ':' ) )
            // InternalBug348427TestLanguage.g:2036:1: ( ':' )
            {
            // InternalBug348427TestLanguage.g:2036:1: ( ':' )
            // InternalBug348427TestLanguage.g:2037:2: ':'
            {
             before(grammarAccess.getChild1_3Access().getColonKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild1_3Access().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_3__Group__1__Impl"


    // $ANTLR start "rule__Child1_3__Group__2"
    // InternalBug348427TestLanguage.g:2046:1: rule__Child1_3__Group__2 : rule__Child1_3__Group__2__Impl rule__Child1_3__Group__3 ;
    public final void rule__Child1_3__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2050:1: ( rule__Child1_3__Group__2__Impl rule__Child1_3__Group__3 )
            // InternalBug348427TestLanguage.g:2051:2: rule__Child1_3__Group__2__Impl rule__Child1_3__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Child1_3__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child1_3__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_3__Group__2"


    // $ANTLR start "rule__Child1_3__Group__2__Impl"
    // InternalBug348427TestLanguage.g:2058:1: rule__Child1_3__Group__2__Impl : ( ( rule__Child1_3__Group_2__0 )? ) ;
    public final void rule__Child1_3__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2062:1: ( ( ( rule__Child1_3__Group_2__0 )? ) )
            // InternalBug348427TestLanguage.g:2063:1: ( ( rule__Child1_3__Group_2__0 )? )
            {
            // InternalBug348427TestLanguage.g:2063:1: ( ( rule__Child1_3__Group_2__0 )? )
            // InternalBug348427TestLanguage.g:2064:2: ( rule__Child1_3__Group_2__0 )?
            {
             before(grammarAccess.getChild1_3Access().getGroup_2()); 
            // InternalBug348427TestLanguage.g:2065:2: ( rule__Child1_3__Group_2__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==32) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalBug348427TestLanguage.g:2065:3: rule__Child1_3__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Child1_3__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getChild1_3Access().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_3__Group__2__Impl"


    // $ANTLR start "rule__Child1_3__Group__3"
    // InternalBug348427TestLanguage.g:2073:1: rule__Child1_3__Group__3 : rule__Child1_3__Group__3__Impl rule__Child1_3__Group__4 ;
    public final void rule__Child1_3__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2077:1: ( rule__Child1_3__Group__3__Impl rule__Child1_3__Group__4 )
            // InternalBug348427TestLanguage.g:2078:2: rule__Child1_3__Group__3__Impl rule__Child1_3__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_15);
            rule__Child1_3__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child1_3__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_3__Group__3"


    // $ANTLR start "rule__Child1_3__Group__3__Impl"
    // InternalBug348427TestLanguage.g:2085:1: rule__Child1_3__Group__3__Impl : ( ( rule__Child1_3__EnumTypeAssignment_3 ) ) ;
    public final void rule__Child1_3__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2089:1: ( ( ( rule__Child1_3__EnumTypeAssignment_3 ) ) )
            // InternalBug348427TestLanguage.g:2090:1: ( ( rule__Child1_3__EnumTypeAssignment_3 ) )
            {
            // InternalBug348427TestLanguage.g:2090:1: ( ( rule__Child1_3__EnumTypeAssignment_3 ) )
            // InternalBug348427TestLanguage.g:2091:2: ( rule__Child1_3__EnumTypeAssignment_3 )
            {
             before(grammarAccess.getChild1_3Access().getEnumTypeAssignment_3()); 
            // InternalBug348427TestLanguage.g:2092:2: ( rule__Child1_3__EnumTypeAssignment_3 )
            // InternalBug348427TestLanguage.g:2092:3: rule__Child1_3__EnumTypeAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child1_3__EnumTypeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getChild1_3Access().getEnumTypeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_3__Group__3__Impl"


    // $ANTLR start "rule__Child1_3__Group__4"
    // InternalBug348427TestLanguage.g:2100:1: rule__Child1_3__Group__4 : rule__Child1_3__Group__4__Impl rule__Child1_3__Group__5 ;
    public final void rule__Child1_3__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2104:1: ( rule__Child1_3__Group__4__Impl rule__Child1_3__Group__5 )
            // InternalBug348427TestLanguage.g:2105:2: rule__Child1_3__Group__4__Impl rule__Child1_3__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__Child1_3__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child1_3__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_3__Group__4"


    // $ANTLR start "rule__Child1_3__Group__4__Impl"
    // InternalBug348427TestLanguage.g:2112:1: rule__Child1_3__Group__4__Impl : ( 'child3' ) ;
    public final void rule__Child1_3__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2116:1: ( ( 'child3' ) )
            // InternalBug348427TestLanguage.g:2117:1: ( 'child3' )
            {
            // InternalBug348427TestLanguage.g:2117:1: ( 'child3' )
            // InternalBug348427TestLanguage.g:2118:2: 'child3'
            {
             before(grammarAccess.getChild1_3Access().getChild3Keyword_4()); 
            match(input,23,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild1_3Access().getChild3Keyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_3__Group__4__Impl"


    // $ANTLR start "rule__Child1_3__Group__5"
    // InternalBug348427TestLanguage.g:2127:1: rule__Child1_3__Group__5 : rule__Child1_3__Group__5__Impl ;
    public final void rule__Child1_3__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2131:1: ( rule__Child1_3__Group__5__Impl )
            // InternalBug348427TestLanguage.g:2132:2: rule__Child1_3__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child1_3__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_3__Group__5"


    // $ANTLR start "rule__Child1_3__Group__5__Impl"
    // InternalBug348427TestLanguage.g:2138:1: rule__Child1_3__Group__5__Impl : ( 'end' ) ;
    public final void rule__Child1_3__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2142:1: ( ( 'end' ) )
            // InternalBug348427TestLanguage.g:2143:1: ( 'end' )
            {
            // InternalBug348427TestLanguage.g:2143:1: ( 'end' )
            // InternalBug348427TestLanguage.g:2144:2: 'end'
            {
             before(grammarAccess.getChild1_3Access().getEndKeyword_5()); 
            match(input,20,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild1_3Access().getEndKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_3__Group__5__Impl"


    // $ANTLR start "rule__Child1_3__Group_2__0"
    // InternalBug348427TestLanguage.g:2154:1: rule__Child1_3__Group_2__0 : rule__Child1_3__Group_2__0__Impl rule__Child1_3__Group_2__1 ;
    public final void rule__Child1_3__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2158:1: ( rule__Child1_3__Group_2__0__Impl rule__Child1_3__Group_2__1 )
            // InternalBug348427TestLanguage.g:2159:2: rule__Child1_3__Group_2__0__Impl rule__Child1_3__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__Child1_3__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child1_3__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_3__Group_2__0"


    // $ANTLR start "rule__Child1_3__Group_2__0__Impl"
    // InternalBug348427TestLanguage.g:2166:1: rule__Child1_3__Group_2__0__Impl : ( ( rule__Child1_3__BoolAssignment_2_0 ) ) ;
    public final void rule__Child1_3__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2170:1: ( ( ( rule__Child1_3__BoolAssignment_2_0 ) ) )
            // InternalBug348427TestLanguage.g:2171:1: ( ( rule__Child1_3__BoolAssignment_2_0 ) )
            {
            // InternalBug348427TestLanguage.g:2171:1: ( ( rule__Child1_3__BoolAssignment_2_0 ) )
            // InternalBug348427TestLanguage.g:2172:2: ( rule__Child1_3__BoolAssignment_2_0 )
            {
             before(grammarAccess.getChild1_3Access().getBoolAssignment_2_0()); 
            // InternalBug348427TestLanguage.g:2173:2: ( rule__Child1_3__BoolAssignment_2_0 )
            // InternalBug348427TestLanguage.g:2173:3: rule__Child1_3__BoolAssignment_2_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child1_3__BoolAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getChild1_3Access().getBoolAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_3__Group_2__0__Impl"


    // $ANTLR start "rule__Child1_3__Group_2__1"
    // InternalBug348427TestLanguage.g:2181:1: rule__Child1_3__Group_2__1 : rule__Child1_3__Group_2__1__Impl ;
    public final void rule__Child1_3__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2185:1: ( rule__Child1_3__Group_2__1__Impl )
            // InternalBug348427TestLanguage.g:2186:2: rule__Child1_3__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child1_3__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_3__Group_2__1"


    // $ANTLR start "rule__Child1_3__Group_2__1__Impl"
    // InternalBug348427TestLanguage.g:2192:1: rule__Child1_3__Group_2__1__Impl : ( 'keyword' ) ;
    public final void rule__Child1_3__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2196:1: ( ( 'keyword' ) )
            // InternalBug348427TestLanguage.g:2197:1: ( 'keyword' )
            {
            // InternalBug348427TestLanguage.g:2197:1: ( 'keyword' )
            // InternalBug348427TestLanguage.g:2198:2: 'keyword'
            {
             before(grammarAccess.getChild1_3Access().getKeywordKeyword_2_1()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild1_3Access().getKeywordKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_3__Group_2__1__Impl"


    // $ANTLR start "rule__Scenario2_1__Group__0"
    // InternalBug348427TestLanguage.g:2208:1: rule__Scenario2_1__Group__0 : rule__Scenario2_1__Group__0__Impl rule__Scenario2_1__Group__1 ;
    public final void rule__Scenario2_1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2212:1: ( rule__Scenario2_1__Group__0__Impl rule__Scenario2_1__Group__1 )
            // InternalBug348427TestLanguage.g:2213:2: rule__Scenario2_1__Group__0__Impl rule__Scenario2_1__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Scenario2_1__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario2_1__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_1__Group__0"


    // $ANTLR start "rule__Scenario2_1__Group__0__Impl"
    // InternalBug348427TestLanguage.g:2220:1: rule__Scenario2_1__Group__0__Impl : ( '2.1' ) ;
    public final void rule__Scenario2_1__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2224:1: ( ( '2.1' ) )
            // InternalBug348427TestLanguage.g:2225:1: ( '2.1' )
            {
            // InternalBug348427TestLanguage.g:2225:1: ( '2.1' )
            // InternalBug348427TestLanguage.g:2226:2: '2.1'
            {
             before(grammarAccess.getScenario2_1Access().getDigitTwoFullStopDigitOneKeyword_0()); 
            match(input,24,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getScenario2_1Access().getDigitTwoFullStopDigitOneKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_1__Group__0__Impl"


    // $ANTLR start "rule__Scenario2_1__Group__1"
    // InternalBug348427TestLanguage.g:2235:1: rule__Scenario2_1__Group__1 : rule__Scenario2_1__Group__1__Impl rule__Scenario2_1__Group__2 ;
    public final void rule__Scenario2_1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2239:1: ( rule__Scenario2_1__Group__1__Impl rule__Scenario2_1__Group__2 )
            // InternalBug348427TestLanguage.g:2240:2: rule__Scenario2_1__Group__1__Impl rule__Scenario2_1__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Scenario2_1__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario2_1__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_1__Group__1"


    // $ANTLR start "rule__Scenario2_1__Group__1__Impl"
    // InternalBug348427TestLanguage.g:2247:1: rule__Scenario2_1__Group__1__Impl : ( ( rule__Scenario2_1__Alternatives_1 ) ) ;
    public final void rule__Scenario2_1__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2251:1: ( ( ( rule__Scenario2_1__Alternatives_1 ) ) )
            // InternalBug348427TestLanguage.g:2252:1: ( ( rule__Scenario2_1__Alternatives_1 ) )
            {
            // InternalBug348427TestLanguage.g:2252:1: ( ( rule__Scenario2_1__Alternatives_1 ) )
            // InternalBug348427TestLanguage.g:2253:2: ( rule__Scenario2_1__Alternatives_1 )
            {
             before(grammarAccess.getScenario2_1Access().getAlternatives_1()); 
            // InternalBug348427TestLanguage.g:2254:2: ( rule__Scenario2_1__Alternatives_1 )
            // InternalBug348427TestLanguage.g:2254:3: rule__Scenario2_1__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario2_1__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getScenario2_1Access().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_1__Group__1__Impl"


    // $ANTLR start "rule__Scenario2_1__Group__2"
    // InternalBug348427TestLanguage.g:2262:1: rule__Scenario2_1__Group__2 : rule__Scenario2_1__Group__2__Impl ;
    public final void rule__Scenario2_1__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2266:1: ( rule__Scenario2_1__Group__2__Impl )
            // InternalBug348427TestLanguage.g:2267:2: rule__Scenario2_1__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario2_1__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_1__Group__2"


    // $ANTLR start "rule__Scenario2_1__Group__2__Impl"
    // InternalBug348427TestLanguage.g:2273:1: rule__Scenario2_1__Group__2__Impl : ( 'next' ) ;
    public final void rule__Scenario2_1__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2277:1: ( ( 'next' ) )
            // InternalBug348427TestLanguage.g:2278:1: ( 'next' )
            {
            // InternalBug348427TestLanguage.g:2278:1: ( 'next' )
            // InternalBug348427TestLanguage.g:2279:2: 'next'
            {
             before(grammarAccess.getScenario2_1Access().getNextKeyword_2()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getScenario2_1Access().getNextKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_1__Group__2__Impl"


    // $ANTLR start "rule__Scenario2_2__Group__0"
    // InternalBug348427TestLanguage.g:2289:1: rule__Scenario2_2__Group__0 : rule__Scenario2_2__Group__0__Impl rule__Scenario2_2__Group__1 ;
    public final void rule__Scenario2_2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2293:1: ( rule__Scenario2_2__Group__0__Impl rule__Scenario2_2__Group__1 )
            // InternalBug348427TestLanguage.g:2294:2: rule__Scenario2_2__Group__0__Impl rule__Scenario2_2__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Scenario2_2__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario2_2__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_2__Group__0"


    // $ANTLR start "rule__Scenario2_2__Group__0__Impl"
    // InternalBug348427TestLanguage.g:2301:1: rule__Scenario2_2__Group__0__Impl : ( '2.2' ) ;
    public final void rule__Scenario2_2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2305:1: ( ( '2.2' ) )
            // InternalBug348427TestLanguage.g:2306:1: ( '2.2' )
            {
            // InternalBug348427TestLanguage.g:2306:1: ( '2.2' )
            // InternalBug348427TestLanguage.g:2307:2: '2.2'
            {
             before(grammarAccess.getScenario2_2Access().getDigitTwoFullStopDigitTwoKeyword_0()); 
            match(input,25,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getScenario2_2Access().getDigitTwoFullStopDigitTwoKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_2__Group__0__Impl"


    // $ANTLR start "rule__Scenario2_2__Group__1"
    // InternalBug348427TestLanguage.g:2316:1: rule__Scenario2_2__Group__1 : rule__Scenario2_2__Group__1__Impl rule__Scenario2_2__Group__2 ;
    public final void rule__Scenario2_2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2320:1: ( rule__Scenario2_2__Group__1__Impl rule__Scenario2_2__Group__2 )
            // InternalBug348427TestLanguage.g:2321:2: rule__Scenario2_2__Group__1__Impl rule__Scenario2_2__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Scenario2_2__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario2_2__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_2__Group__1"


    // $ANTLR start "rule__Scenario2_2__Group__1__Impl"
    // InternalBug348427TestLanguage.g:2328:1: rule__Scenario2_2__Group__1__Impl : ( ( ( rule__Scenario2_2__Alternatives_1 ) ) ( ( rule__Scenario2_2__Alternatives_1 )* ) ) ;
    public final void rule__Scenario2_2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2332:1: ( ( ( ( rule__Scenario2_2__Alternatives_1 ) ) ( ( rule__Scenario2_2__Alternatives_1 )* ) ) )
            // InternalBug348427TestLanguage.g:2333:1: ( ( ( rule__Scenario2_2__Alternatives_1 ) ) ( ( rule__Scenario2_2__Alternatives_1 )* ) )
            {
            // InternalBug348427TestLanguage.g:2333:1: ( ( ( rule__Scenario2_2__Alternatives_1 ) ) ( ( rule__Scenario2_2__Alternatives_1 )* ) )
            // InternalBug348427TestLanguage.g:2334:2: ( ( rule__Scenario2_2__Alternatives_1 ) ) ( ( rule__Scenario2_2__Alternatives_1 )* )
            {
            // InternalBug348427TestLanguage.g:2334:2: ( ( rule__Scenario2_2__Alternatives_1 ) )
            // InternalBug348427TestLanguage.g:2335:3: ( rule__Scenario2_2__Alternatives_1 )
            {
             before(grammarAccess.getScenario2_2Access().getAlternatives_1()); 
            // InternalBug348427TestLanguage.g:2336:3: ( rule__Scenario2_2__Alternatives_1 )
            // InternalBug348427TestLanguage.g:2336:4: rule__Scenario2_2__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Scenario2_2__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getScenario2_2Access().getAlternatives_1()); 

            }

            // InternalBug348427TestLanguage.g:2339:2: ( ( rule__Scenario2_2__Alternatives_1 )* )
            // InternalBug348427TestLanguage.g:2340:3: ( rule__Scenario2_2__Alternatives_1 )*
            {
             before(grammarAccess.getScenario2_2Access().getAlternatives_1()); 
            // InternalBug348427TestLanguage.g:2341:3: ( rule__Scenario2_2__Alternatives_1 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_ID) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalBug348427TestLanguage.g:2341:4: rule__Scenario2_2__Alternatives_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    rule__Scenario2_2__Alternatives_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

             after(grammarAccess.getScenario2_2Access().getAlternatives_1()); 

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
    // $ANTLR end "rule__Scenario2_2__Group__1__Impl"


    // $ANTLR start "rule__Scenario2_2__Group__2"
    // InternalBug348427TestLanguage.g:2350:1: rule__Scenario2_2__Group__2 : rule__Scenario2_2__Group__2__Impl ;
    public final void rule__Scenario2_2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2354:1: ( rule__Scenario2_2__Group__2__Impl )
            // InternalBug348427TestLanguage.g:2355:2: rule__Scenario2_2__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario2_2__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_2__Group__2"


    // $ANTLR start "rule__Scenario2_2__Group__2__Impl"
    // InternalBug348427TestLanguage.g:2361:1: rule__Scenario2_2__Group__2__Impl : ( 'next' ) ;
    public final void rule__Scenario2_2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2365:1: ( ( 'next' ) )
            // InternalBug348427TestLanguage.g:2366:1: ( 'next' )
            {
            // InternalBug348427TestLanguage.g:2366:1: ( 'next' )
            // InternalBug348427TestLanguage.g:2367:2: 'next'
            {
             before(grammarAccess.getScenario2_2Access().getNextKeyword_2()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getScenario2_2Access().getNextKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_2__Group__2__Impl"


    // $ANTLR start "rule__Scenario2_3__Group__0"
    // InternalBug348427TestLanguage.g:2377:1: rule__Scenario2_3__Group__0 : rule__Scenario2_3__Group__0__Impl rule__Scenario2_3__Group__1 ;
    public final void rule__Scenario2_3__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2381:1: ( rule__Scenario2_3__Group__0__Impl rule__Scenario2_3__Group__1 )
            // InternalBug348427TestLanguage.g:2382:2: rule__Scenario2_3__Group__0__Impl rule__Scenario2_3__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Scenario2_3__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario2_3__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_3__Group__0"


    // $ANTLR start "rule__Scenario2_3__Group__0__Impl"
    // InternalBug348427TestLanguage.g:2389:1: rule__Scenario2_3__Group__0__Impl : ( '2.3' ) ;
    public final void rule__Scenario2_3__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2393:1: ( ( '2.3' ) )
            // InternalBug348427TestLanguage.g:2394:1: ( '2.3' )
            {
            // InternalBug348427TestLanguage.g:2394:1: ( '2.3' )
            // InternalBug348427TestLanguage.g:2395:2: '2.3'
            {
             before(grammarAccess.getScenario2_3Access().getDigitTwoFullStopDigitThreeKeyword_0()); 
            match(input,26,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getScenario2_3Access().getDigitTwoFullStopDigitThreeKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_3__Group__0__Impl"


    // $ANTLR start "rule__Scenario2_3__Group__1"
    // InternalBug348427TestLanguage.g:2404:1: rule__Scenario2_3__Group__1 : rule__Scenario2_3__Group__1__Impl rule__Scenario2_3__Group__2 ;
    public final void rule__Scenario2_3__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2408:1: ( rule__Scenario2_3__Group__1__Impl rule__Scenario2_3__Group__2 )
            // InternalBug348427TestLanguage.g:2409:2: rule__Scenario2_3__Group__1__Impl rule__Scenario2_3__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Scenario2_3__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario2_3__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_3__Group__1"


    // $ANTLR start "rule__Scenario2_3__Group__1__Impl"
    // InternalBug348427TestLanguage.g:2416:1: rule__Scenario2_3__Group__1__Impl : ( ( rule__Scenario2_3__Alternatives_1 ) ) ;
    public final void rule__Scenario2_3__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2420:1: ( ( ( rule__Scenario2_3__Alternatives_1 ) ) )
            // InternalBug348427TestLanguage.g:2421:1: ( ( rule__Scenario2_3__Alternatives_1 ) )
            {
            // InternalBug348427TestLanguage.g:2421:1: ( ( rule__Scenario2_3__Alternatives_1 ) )
            // InternalBug348427TestLanguage.g:2422:2: ( rule__Scenario2_3__Alternatives_1 )
            {
             before(grammarAccess.getScenario2_3Access().getAlternatives_1()); 
            // InternalBug348427TestLanguage.g:2423:2: ( rule__Scenario2_3__Alternatives_1 )
            // InternalBug348427TestLanguage.g:2423:3: rule__Scenario2_3__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario2_3__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getScenario2_3Access().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_3__Group__1__Impl"


    // $ANTLR start "rule__Scenario2_3__Group__2"
    // InternalBug348427TestLanguage.g:2431:1: rule__Scenario2_3__Group__2 : rule__Scenario2_3__Group__2__Impl ;
    public final void rule__Scenario2_3__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2435:1: ( rule__Scenario2_3__Group__2__Impl )
            // InternalBug348427TestLanguage.g:2436:2: rule__Scenario2_3__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario2_3__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_3__Group__2"


    // $ANTLR start "rule__Scenario2_3__Group__2__Impl"
    // InternalBug348427TestLanguage.g:2442:1: rule__Scenario2_3__Group__2__Impl : ( 'next' ) ;
    public final void rule__Scenario2_3__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2446:1: ( ( 'next' ) )
            // InternalBug348427TestLanguage.g:2447:1: ( 'next' )
            {
            // InternalBug348427TestLanguage.g:2447:1: ( 'next' )
            // InternalBug348427TestLanguage.g:2448:2: 'next'
            {
             before(grammarAccess.getScenario2_3Access().getNextKeyword_2()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getScenario2_3Access().getNextKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_3__Group__2__Impl"


    // $ANTLR start "rule__Scenario2_4__Group__0"
    // InternalBug348427TestLanguage.g:2458:1: rule__Scenario2_4__Group__0 : rule__Scenario2_4__Group__0__Impl rule__Scenario2_4__Group__1 ;
    public final void rule__Scenario2_4__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2462:1: ( rule__Scenario2_4__Group__0__Impl rule__Scenario2_4__Group__1 )
            // InternalBug348427TestLanguage.g:2463:2: rule__Scenario2_4__Group__0__Impl rule__Scenario2_4__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Scenario2_4__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario2_4__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_4__Group__0"


    // $ANTLR start "rule__Scenario2_4__Group__0__Impl"
    // InternalBug348427TestLanguage.g:2470:1: rule__Scenario2_4__Group__0__Impl : ( '2.4' ) ;
    public final void rule__Scenario2_4__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2474:1: ( ( '2.4' ) )
            // InternalBug348427TestLanguage.g:2475:1: ( '2.4' )
            {
            // InternalBug348427TestLanguage.g:2475:1: ( '2.4' )
            // InternalBug348427TestLanguage.g:2476:2: '2.4'
            {
             before(grammarAccess.getScenario2_4Access().getDigitTwoFullStopDigitFourKeyword_0()); 
            match(input,27,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getScenario2_4Access().getDigitTwoFullStopDigitFourKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_4__Group__0__Impl"


    // $ANTLR start "rule__Scenario2_4__Group__1"
    // InternalBug348427TestLanguage.g:2485:1: rule__Scenario2_4__Group__1 : rule__Scenario2_4__Group__1__Impl rule__Scenario2_4__Group__2 ;
    public final void rule__Scenario2_4__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2489:1: ( rule__Scenario2_4__Group__1__Impl rule__Scenario2_4__Group__2 )
            // InternalBug348427TestLanguage.g:2490:2: rule__Scenario2_4__Group__1__Impl rule__Scenario2_4__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Scenario2_4__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario2_4__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_4__Group__1"


    // $ANTLR start "rule__Scenario2_4__Group__1__Impl"
    // InternalBug348427TestLanguage.g:2497:1: rule__Scenario2_4__Group__1__Impl : ( ( ( rule__Scenario2_4__Alternatives_1 ) ) ( ( rule__Scenario2_4__Alternatives_1 )* ) ) ;
    public final void rule__Scenario2_4__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2501:1: ( ( ( ( rule__Scenario2_4__Alternatives_1 ) ) ( ( rule__Scenario2_4__Alternatives_1 )* ) ) )
            // InternalBug348427TestLanguage.g:2502:1: ( ( ( rule__Scenario2_4__Alternatives_1 ) ) ( ( rule__Scenario2_4__Alternatives_1 )* ) )
            {
            // InternalBug348427TestLanguage.g:2502:1: ( ( ( rule__Scenario2_4__Alternatives_1 ) ) ( ( rule__Scenario2_4__Alternatives_1 )* ) )
            // InternalBug348427TestLanguage.g:2503:2: ( ( rule__Scenario2_4__Alternatives_1 ) ) ( ( rule__Scenario2_4__Alternatives_1 )* )
            {
            // InternalBug348427TestLanguage.g:2503:2: ( ( rule__Scenario2_4__Alternatives_1 ) )
            // InternalBug348427TestLanguage.g:2504:3: ( rule__Scenario2_4__Alternatives_1 )
            {
             before(grammarAccess.getScenario2_4Access().getAlternatives_1()); 
            // InternalBug348427TestLanguage.g:2505:3: ( rule__Scenario2_4__Alternatives_1 )
            // InternalBug348427TestLanguage.g:2505:4: rule__Scenario2_4__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Scenario2_4__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getScenario2_4Access().getAlternatives_1()); 

            }

            // InternalBug348427TestLanguage.g:2508:2: ( ( rule__Scenario2_4__Alternatives_1 )* )
            // InternalBug348427TestLanguage.g:2509:3: ( rule__Scenario2_4__Alternatives_1 )*
            {
             before(grammarAccess.getScenario2_4Access().getAlternatives_1()); 
            // InternalBug348427TestLanguage.g:2510:3: ( rule__Scenario2_4__Alternatives_1 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_ID) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalBug348427TestLanguage.g:2510:4: rule__Scenario2_4__Alternatives_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    rule__Scenario2_4__Alternatives_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

             after(grammarAccess.getScenario2_4Access().getAlternatives_1()); 

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
    // $ANTLR end "rule__Scenario2_4__Group__1__Impl"


    // $ANTLR start "rule__Scenario2_4__Group__2"
    // InternalBug348427TestLanguage.g:2519:1: rule__Scenario2_4__Group__2 : rule__Scenario2_4__Group__2__Impl ;
    public final void rule__Scenario2_4__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2523:1: ( rule__Scenario2_4__Group__2__Impl )
            // InternalBug348427TestLanguage.g:2524:2: rule__Scenario2_4__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario2_4__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_4__Group__2"


    // $ANTLR start "rule__Scenario2_4__Group__2__Impl"
    // InternalBug348427TestLanguage.g:2530:1: rule__Scenario2_4__Group__2__Impl : ( 'next' ) ;
    public final void rule__Scenario2_4__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2534:1: ( ( 'next' ) )
            // InternalBug348427TestLanguage.g:2535:1: ( 'next' )
            {
            // InternalBug348427TestLanguage.g:2535:1: ( 'next' )
            // InternalBug348427TestLanguage.g:2536:2: 'next'
            {
             before(grammarAccess.getScenario2_4Access().getNextKeyword_2()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getScenario2_4Access().getNextKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_4__Group__2__Impl"


    // $ANTLR start "rule__Scenario2_5__Group__0"
    // InternalBug348427TestLanguage.g:2546:1: rule__Scenario2_5__Group__0 : rule__Scenario2_5__Group__0__Impl rule__Scenario2_5__Group__1 ;
    public final void rule__Scenario2_5__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2550:1: ( rule__Scenario2_5__Group__0__Impl rule__Scenario2_5__Group__1 )
            // InternalBug348427TestLanguage.g:2551:2: rule__Scenario2_5__Group__0__Impl rule__Scenario2_5__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__Scenario2_5__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario2_5__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_5__Group__0"


    // $ANTLR start "rule__Scenario2_5__Group__0__Impl"
    // InternalBug348427TestLanguage.g:2558:1: rule__Scenario2_5__Group__0__Impl : ( () ) ;
    public final void rule__Scenario2_5__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2562:1: ( ( () ) )
            // InternalBug348427TestLanguage.g:2563:1: ( () )
            {
            // InternalBug348427TestLanguage.g:2563:1: ( () )
            // InternalBug348427TestLanguage.g:2564:2: ()
            {
             before(grammarAccess.getScenario2_5Access().getScenario2Action_0()); 
            // InternalBug348427TestLanguage.g:2565:2: ()
            // InternalBug348427TestLanguage.g:2565:3: 
            {
            }

             after(grammarAccess.getScenario2_5Access().getScenario2Action_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_5__Group__0__Impl"


    // $ANTLR start "rule__Scenario2_5__Group__1"
    // InternalBug348427TestLanguage.g:2573:1: rule__Scenario2_5__Group__1 : rule__Scenario2_5__Group__1__Impl rule__Scenario2_5__Group__2 ;
    public final void rule__Scenario2_5__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2577:1: ( rule__Scenario2_5__Group__1__Impl rule__Scenario2_5__Group__2 )
            // InternalBug348427TestLanguage.g:2578:2: rule__Scenario2_5__Group__1__Impl rule__Scenario2_5__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Scenario2_5__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario2_5__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_5__Group__1"


    // $ANTLR start "rule__Scenario2_5__Group__1__Impl"
    // InternalBug348427TestLanguage.g:2585:1: rule__Scenario2_5__Group__1__Impl : ( '2.5' ) ;
    public final void rule__Scenario2_5__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2589:1: ( ( '2.5' ) )
            // InternalBug348427TestLanguage.g:2590:1: ( '2.5' )
            {
            // InternalBug348427TestLanguage.g:2590:1: ( '2.5' )
            // InternalBug348427TestLanguage.g:2591:2: '2.5'
            {
             before(grammarAccess.getScenario2_5Access().getDigitTwoFullStopDigitFiveKeyword_1()); 
            match(input,28,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getScenario2_5Access().getDigitTwoFullStopDigitFiveKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_5__Group__1__Impl"


    // $ANTLR start "rule__Scenario2_5__Group__2"
    // InternalBug348427TestLanguage.g:2600:1: rule__Scenario2_5__Group__2 : rule__Scenario2_5__Group__2__Impl rule__Scenario2_5__Group__3 ;
    public final void rule__Scenario2_5__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2604:1: ( rule__Scenario2_5__Group__2__Impl rule__Scenario2_5__Group__3 )
            // InternalBug348427TestLanguage.g:2605:2: rule__Scenario2_5__Group__2__Impl rule__Scenario2_5__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Scenario2_5__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario2_5__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_5__Group__2"


    // $ANTLR start "rule__Scenario2_5__Group__2__Impl"
    // InternalBug348427TestLanguage.g:2612:1: rule__Scenario2_5__Group__2__Impl : ( ( rule__Scenario2_5__Alternatives_2 )? ) ;
    public final void rule__Scenario2_5__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2616:1: ( ( ( rule__Scenario2_5__Alternatives_2 )? ) )
            // InternalBug348427TestLanguage.g:2617:1: ( ( rule__Scenario2_5__Alternatives_2 )? )
            {
            // InternalBug348427TestLanguage.g:2617:1: ( ( rule__Scenario2_5__Alternatives_2 )? )
            // InternalBug348427TestLanguage.g:2618:2: ( rule__Scenario2_5__Alternatives_2 )?
            {
             before(grammarAccess.getScenario2_5Access().getAlternatives_2()); 
            // InternalBug348427TestLanguage.g:2619:2: ( rule__Scenario2_5__Alternatives_2 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_ID) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalBug348427TestLanguage.g:2619:3: rule__Scenario2_5__Alternatives_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario2_5__Alternatives_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getScenario2_5Access().getAlternatives_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_5__Group__2__Impl"


    // $ANTLR start "rule__Scenario2_5__Group__3"
    // InternalBug348427TestLanguage.g:2627:1: rule__Scenario2_5__Group__3 : rule__Scenario2_5__Group__3__Impl ;
    public final void rule__Scenario2_5__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2631:1: ( rule__Scenario2_5__Group__3__Impl )
            // InternalBug348427TestLanguage.g:2632:2: rule__Scenario2_5__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario2_5__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_5__Group__3"


    // $ANTLR start "rule__Scenario2_5__Group__3__Impl"
    // InternalBug348427TestLanguage.g:2638:1: rule__Scenario2_5__Group__3__Impl : ( 'next' ) ;
    public final void rule__Scenario2_5__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2642:1: ( ( 'next' ) )
            // InternalBug348427TestLanguage.g:2643:1: ( 'next' )
            {
            // InternalBug348427TestLanguage.g:2643:1: ( 'next' )
            // InternalBug348427TestLanguage.g:2644:2: 'next'
            {
             before(grammarAccess.getScenario2_5Access().getNextKeyword_3()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getScenario2_5Access().getNextKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_5__Group__3__Impl"


    // $ANTLR start "rule__Scenario2_6__Group__0"
    // InternalBug348427TestLanguage.g:2654:1: rule__Scenario2_6__Group__0 : rule__Scenario2_6__Group__0__Impl rule__Scenario2_6__Group__1 ;
    public final void rule__Scenario2_6__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2658:1: ( rule__Scenario2_6__Group__0__Impl rule__Scenario2_6__Group__1 )
            // InternalBug348427TestLanguage.g:2659:2: rule__Scenario2_6__Group__0__Impl rule__Scenario2_6__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_17);
            rule__Scenario2_6__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario2_6__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_6__Group__0"


    // $ANTLR start "rule__Scenario2_6__Group__0__Impl"
    // InternalBug348427TestLanguage.g:2666:1: rule__Scenario2_6__Group__0__Impl : ( () ) ;
    public final void rule__Scenario2_6__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2670:1: ( ( () ) )
            // InternalBug348427TestLanguage.g:2671:1: ( () )
            {
            // InternalBug348427TestLanguage.g:2671:1: ( () )
            // InternalBug348427TestLanguage.g:2672:2: ()
            {
             before(grammarAccess.getScenario2_6Access().getScenario2Action_0()); 
            // InternalBug348427TestLanguage.g:2673:2: ()
            // InternalBug348427TestLanguage.g:2673:3: 
            {
            }

             after(grammarAccess.getScenario2_6Access().getScenario2Action_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_6__Group__0__Impl"


    // $ANTLR start "rule__Scenario2_6__Group__1"
    // InternalBug348427TestLanguage.g:2681:1: rule__Scenario2_6__Group__1 : rule__Scenario2_6__Group__1__Impl rule__Scenario2_6__Group__2 ;
    public final void rule__Scenario2_6__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2685:1: ( rule__Scenario2_6__Group__1__Impl rule__Scenario2_6__Group__2 )
            // InternalBug348427TestLanguage.g:2686:2: rule__Scenario2_6__Group__1__Impl rule__Scenario2_6__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Scenario2_6__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario2_6__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_6__Group__1"


    // $ANTLR start "rule__Scenario2_6__Group__1__Impl"
    // InternalBug348427TestLanguage.g:2693:1: rule__Scenario2_6__Group__1__Impl : ( '2.6' ) ;
    public final void rule__Scenario2_6__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2697:1: ( ( '2.6' ) )
            // InternalBug348427TestLanguage.g:2698:1: ( '2.6' )
            {
            // InternalBug348427TestLanguage.g:2698:1: ( '2.6' )
            // InternalBug348427TestLanguage.g:2699:2: '2.6'
            {
             before(grammarAccess.getScenario2_6Access().getDigitTwoFullStopDigitSixKeyword_1()); 
            match(input,29,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getScenario2_6Access().getDigitTwoFullStopDigitSixKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_6__Group__1__Impl"


    // $ANTLR start "rule__Scenario2_6__Group__2"
    // InternalBug348427TestLanguage.g:2708:1: rule__Scenario2_6__Group__2 : rule__Scenario2_6__Group__2__Impl rule__Scenario2_6__Group__3 ;
    public final void rule__Scenario2_6__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2712:1: ( rule__Scenario2_6__Group__2__Impl rule__Scenario2_6__Group__3 )
            // InternalBug348427TestLanguage.g:2713:2: rule__Scenario2_6__Group__2__Impl rule__Scenario2_6__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Scenario2_6__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario2_6__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_6__Group__2"


    // $ANTLR start "rule__Scenario2_6__Group__2__Impl"
    // InternalBug348427TestLanguage.g:2720:1: rule__Scenario2_6__Group__2__Impl : ( ( rule__Scenario2_6__Alternatives_2 )* ) ;
    public final void rule__Scenario2_6__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2724:1: ( ( ( rule__Scenario2_6__Alternatives_2 )* ) )
            // InternalBug348427TestLanguage.g:2725:1: ( ( rule__Scenario2_6__Alternatives_2 )* )
            {
            // InternalBug348427TestLanguage.g:2725:1: ( ( rule__Scenario2_6__Alternatives_2 )* )
            // InternalBug348427TestLanguage.g:2726:2: ( rule__Scenario2_6__Alternatives_2 )*
            {
             before(grammarAccess.getScenario2_6Access().getAlternatives_2()); 
            // InternalBug348427TestLanguage.g:2727:2: ( rule__Scenario2_6__Alternatives_2 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_ID) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalBug348427TestLanguage.g:2727:3: rule__Scenario2_6__Alternatives_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    rule__Scenario2_6__Alternatives_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

             after(grammarAccess.getScenario2_6Access().getAlternatives_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_6__Group__2__Impl"


    // $ANTLR start "rule__Scenario2_6__Group__3"
    // InternalBug348427TestLanguage.g:2735:1: rule__Scenario2_6__Group__3 : rule__Scenario2_6__Group__3__Impl ;
    public final void rule__Scenario2_6__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2739:1: ( rule__Scenario2_6__Group__3__Impl )
            // InternalBug348427TestLanguage.g:2740:2: rule__Scenario2_6__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario2_6__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_6__Group__3"


    // $ANTLR start "rule__Scenario2_6__Group__3__Impl"
    // InternalBug348427TestLanguage.g:2746:1: rule__Scenario2_6__Group__3__Impl : ( 'next' ) ;
    public final void rule__Scenario2_6__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2750:1: ( ( 'next' ) )
            // InternalBug348427TestLanguage.g:2751:1: ( 'next' )
            {
            // InternalBug348427TestLanguage.g:2751:1: ( 'next' )
            // InternalBug348427TestLanguage.g:2752:2: 'next'
            {
             before(grammarAccess.getScenario2_6Access().getNextKeyword_3()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getScenario2_6Access().getNextKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_6__Group__3__Impl"


    // $ANTLR start "rule__Scenario2_7__Group__0"
    // InternalBug348427TestLanguage.g:2762:1: rule__Scenario2_7__Group__0 : rule__Scenario2_7__Group__0__Impl rule__Scenario2_7__Group__1 ;
    public final void rule__Scenario2_7__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2766:1: ( rule__Scenario2_7__Group__0__Impl rule__Scenario2_7__Group__1 )
            // InternalBug348427TestLanguage.g:2767:2: rule__Scenario2_7__Group__0__Impl rule__Scenario2_7__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_18);
            rule__Scenario2_7__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario2_7__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_7__Group__0"


    // $ANTLR start "rule__Scenario2_7__Group__0__Impl"
    // InternalBug348427TestLanguage.g:2774:1: rule__Scenario2_7__Group__0__Impl : ( () ) ;
    public final void rule__Scenario2_7__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2778:1: ( ( () ) )
            // InternalBug348427TestLanguage.g:2779:1: ( () )
            {
            // InternalBug348427TestLanguage.g:2779:1: ( () )
            // InternalBug348427TestLanguage.g:2780:2: ()
            {
             before(grammarAccess.getScenario2_7Access().getScenario2Action_0()); 
            // InternalBug348427TestLanguage.g:2781:2: ()
            // InternalBug348427TestLanguage.g:2781:3: 
            {
            }

             after(grammarAccess.getScenario2_7Access().getScenario2Action_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_7__Group__0__Impl"


    // $ANTLR start "rule__Scenario2_7__Group__1"
    // InternalBug348427TestLanguage.g:2789:1: rule__Scenario2_7__Group__1 : rule__Scenario2_7__Group__1__Impl rule__Scenario2_7__Group__2 ;
    public final void rule__Scenario2_7__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2793:1: ( rule__Scenario2_7__Group__1__Impl rule__Scenario2_7__Group__2 )
            // InternalBug348427TestLanguage.g:2794:2: rule__Scenario2_7__Group__1__Impl rule__Scenario2_7__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Scenario2_7__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario2_7__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_7__Group__1"


    // $ANTLR start "rule__Scenario2_7__Group__1__Impl"
    // InternalBug348427TestLanguage.g:2801:1: rule__Scenario2_7__Group__1__Impl : ( '2.7' ) ;
    public final void rule__Scenario2_7__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2805:1: ( ( '2.7' ) )
            // InternalBug348427TestLanguage.g:2806:1: ( '2.7' )
            {
            // InternalBug348427TestLanguage.g:2806:1: ( '2.7' )
            // InternalBug348427TestLanguage.g:2807:2: '2.7'
            {
             before(grammarAccess.getScenario2_7Access().getDigitTwoFullStopDigitSevenKeyword_1()); 
            match(input,30,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getScenario2_7Access().getDigitTwoFullStopDigitSevenKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_7__Group__1__Impl"


    // $ANTLR start "rule__Scenario2_7__Group__2"
    // InternalBug348427TestLanguage.g:2816:1: rule__Scenario2_7__Group__2 : rule__Scenario2_7__Group__2__Impl rule__Scenario2_7__Group__3 ;
    public final void rule__Scenario2_7__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2820:1: ( rule__Scenario2_7__Group__2__Impl rule__Scenario2_7__Group__3 )
            // InternalBug348427TestLanguage.g:2821:2: rule__Scenario2_7__Group__2__Impl rule__Scenario2_7__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Scenario2_7__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario2_7__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_7__Group__2"


    // $ANTLR start "rule__Scenario2_7__Group__2__Impl"
    // InternalBug348427TestLanguage.g:2828:1: rule__Scenario2_7__Group__2__Impl : ( ( rule__Scenario2_7__Alternatives_2 )? ) ;
    public final void rule__Scenario2_7__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2832:1: ( ( ( rule__Scenario2_7__Alternatives_2 )? ) )
            // InternalBug348427TestLanguage.g:2833:1: ( ( rule__Scenario2_7__Alternatives_2 )? )
            {
            // InternalBug348427TestLanguage.g:2833:1: ( ( rule__Scenario2_7__Alternatives_2 )? )
            // InternalBug348427TestLanguage.g:2834:2: ( rule__Scenario2_7__Alternatives_2 )?
            {
             before(grammarAccess.getScenario2_7Access().getAlternatives_2()); 
            // InternalBug348427TestLanguage.g:2835:2: ( rule__Scenario2_7__Alternatives_2 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_ID) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalBug348427TestLanguage.g:2835:3: rule__Scenario2_7__Alternatives_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario2_7__Alternatives_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getScenario2_7Access().getAlternatives_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_7__Group__2__Impl"


    // $ANTLR start "rule__Scenario2_7__Group__3"
    // InternalBug348427TestLanguage.g:2843:1: rule__Scenario2_7__Group__3 : rule__Scenario2_7__Group__3__Impl ;
    public final void rule__Scenario2_7__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2847:1: ( rule__Scenario2_7__Group__3__Impl )
            // InternalBug348427TestLanguage.g:2848:2: rule__Scenario2_7__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario2_7__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_7__Group__3"


    // $ANTLR start "rule__Scenario2_7__Group__3__Impl"
    // InternalBug348427TestLanguage.g:2854:1: rule__Scenario2_7__Group__3__Impl : ( 'next' ) ;
    public final void rule__Scenario2_7__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2858:1: ( ( 'next' ) )
            // InternalBug348427TestLanguage.g:2859:1: ( 'next' )
            {
            // InternalBug348427TestLanguage.g:2859:1: ( 'next' )
            // InternalBug348427TestLanguage.g:2860:2: 'next'
            {
             before(grammarAccess.getScenario2_7Access().getNextKeyword_3()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getScenario2_7Access().getNextKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_7__Group__3__Impl"


    // $ANTLR start "rule__Scenario2_8__Group__0"
    // InternalBug348427TestLanguage.g:2870:1: rule__Scenario2_8__Group__0 : rule__Scenario2_8__Group__0__Impl rule__Scenario2_8__Group__1 ;
    public final void rule__Scenario2_8__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2874:1: ( rule__Scenario2_8__Group__0__Impl rule__Scenario2_8__Group__1 )
            // InternalBug348427TestLanguage.g:2875:2: rule__Scenario2_8__Group__0__Impl rule__Scenario2_8__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_19);
            rule__Scenario2_8__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario2_8__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_8__Group__0"


    // $ANTLR start "rule__Scenario2_8__Group__0__Impl"
    // InternalBug348427TestLanguage.g:2882:1: rule__Scenario2_8__Group__0__Impl : ( () ) ;
    public final void rule__Scenario2_8__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2886:1: ( ( () ) )
            // InternalBug348427TestLanguage.g:2887:1: ( () )
            {
            // InternalBug348427TestLanguage.g:2887:1: ( () )
            // InternalBug348427TestLanguage.g:2888:2: ()
            {
             before(grammarAccess.getScenario2_8Access().getScenario2Action_0()); 
            // InternalBug348427TestLanguage.g:2889:2: ()
            // InternalBug348427TestLanguage.g:2889:3: 
            {
            }

             after(grammarAccess.getScenario2_8Access().getScenario2Action_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_8__Group__0__Impl"


    // $ANTLR start "rule__Scenario2_8__Group__1"
    // InternalBug348427TestLanguage.g:2897:1: rule__Scenario2_8__Group__1 : rule__Scenario2_8__Group__1__Impl rule__Scenario2_8__Group__2 ;
    public final void rule__Scenario2_8__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2901:1: ( rule__Scenario2_8__Group__1__Impl rule__Scenario2_8__Group__2 )
            // InternalBug348427TestLanguage.g:2902:2: rule__Scenario2_8__Group__1__Impl rule__Scenario2_8__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Scenario2_8__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario2_8__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_8__Group__1"


    // $ANTLR start "rule__Scenario2_8__Group__1__Impl"
    // InternalBug348427TestLanguage.g:2909:1: rule__Scenario2_8__Group__1__Impl : ( '2.8' ) ;
    public final void rule__Scenario2_8__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2913:1: ( ( '2.8' ) )
            // InternalBug348427TestLanguage.g:2914:1: ( '2.8' )
            {
            // InternalBug348427TestLanguage.g:2914:1: ( '2.8' )
            // InternalBug348427TestLanguage.g:2915:2: '2.8'
            {
             before(grammarAccess.getScenario2_8Access().getDigitTwoFullStopDigitEightKeyword_1()); 
            match(input,31,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getScenario2_8Access().getDigitTwoFullStopDigitEightKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_8__Group__1__Impl"


    // $ANTLR start "rule__Scenario2_8__Group__2"
    // InternalBug348427TestLanguage.g:2924:1: rule__Scenario2_8__Group__2 : rule__Scenario2_8__Group__2__Impl rule__Scenario2_8__Group__3 ;
    public final void rule__Scenario2_8__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2928:1: ( rule__Scenario2_8__Group__2__Impl rule__Scenario2_8__Group__3 )
            // InternalBug348427TestLanguage.g:2929:2: rule__Scenario2_8__Group__2__Impl rule__Scenario2_8__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Scenario2_8__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario2_8__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_8__Group__2"


    // $ANTLR start "rule__Scenario2_8__Group__2__Impl"
    // InternalBug348427TestLanguage.g:2936:1: rule__Scenario2_8__Group__2__Impl : ( ( rule__Scenario2_8__Alternatives_2 )* ) ;
    public final void rule__Scenario2_8__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2940:1: ( ( ( rule__Scenario2_8__Alternatives_2 )* ) )
            // InternalBug348427TestLanguage.g:2941:1: ( ( rule__Scenario2_8__Alternatives_2 )* )
            {
            // InternalBug348427TestLanguage.g:2941:1: ( ( rule__Scenario2_8__Alternatives_2 )* )
            // InternalBug348427TestLanguage.g:2942:2: ( rule__Scenario2_8__Alternatives_2 )*
            {
             before(grammarAccess.getScenario2_8Access().getAlternatives_2()); 
            // InternalBug348427TestLanguage.g:2943:2: ( rule__Scenario2_8__Alternatives_2 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_ID) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalBug348427TestLanguage.g:2943:3: rule__Scenario2_8__Alternatives_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    rule__Scenario2_8__Alternatives_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

             after(grammarAccess.getScenario2_8Access().getAlternatives_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_8__Group__2__Impl"


    // $ANTLR start "rule__Scenario2_8__Group__3"
    // InternalBug348427TestLanguage.g:2951:1: rule__Scenario2_8__Group__3 : rule__Scenario2_8__Group__3__Impl ;
    public final void rule__Scenario2_8__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2955:1: ( rule__Scenario2_8__Group__3__Impl )
            // InternalBug348427TestLanguage.g:2956:2: rule__Scenario2_8__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario2_8__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_8__Group__3"


    // $ANTLR start "rule__Scenario2_8__Group__3__Impl"
    // InternalBug348427TestLanguage.g:2962:1: rule__Scenario2_8__Group__3__Impl : ( 'next' ) ;
    public final void rule__Scenario2_8__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2966:1: ( ( 'next' ) )
            // InternalBug348427TestLanguage.g:2967:1: ( 'next' )
            {
            // InternalBug348427TestLanguage.g:2967:1: ( 'next' )
            // InternalBug348427TestLanguage.g:2968:2: 'next'
            {
             before(grammarAccess.getScenario2_8Access().getNextKeyword_3()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getScenario2_8Access().getNextKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_8__Group__3__Impl"


    // $ANTLR start "rule__Child2_1__Group__0"
    // InternalBug348427TestLanguage.g:2978:1: rule__Child2_1__Group__0 : rule__Child2_1__Group__0__Impl rule__Child2_1__Group__1 ;
    public final void rule__Child2_1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2982:1: ( rule__Child2_1__Group__0__Impl rule__Child2_1__Group__1 )
            // InternalBug348427TestLanguage.g:2983:2: rule__Child2_1__Group__0__Impl rule__Child2_1__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__Child2_1__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_1__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_1__Group__0"


    // $ANTLR start "rule__Child2_1__Group__0__Impl"
    // InternalBug348427TestLanguage.g:2990:1: rule__Child2_1__Group__0__Impl : ( ( rule__Child2_1__NameAssignment_0 ) ) ;
    public final void rule__Child2_1__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2994:1: ( ( ( rule__Child2_1__NameAssignment_0 ) ) )
            // InternalBug348427TestLanguage.g:2995:1: ( ( rule__Child2_1__NameAssignment_0 ) )
            {
            // InternalBug348427TestLanguage.g:2995:1: ( ( rule__Child2_1__NameAssignment_0 ) )
            // InternalBug348427TestLanguage.g:2996:2: ( rule__Child2_1__NameAssignment_0 )
            {
             before(grammarAccess.getChild2_1Access().getNameAssignment_0()); 
            // InternalBug348427TestLanguage.g:2997:2: ( rule__Child2_1__NameAssignment_0 )
            // InternalBug348427TestLanguage.g:2997:3: rule__Child2_1__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_1__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getChild2_1Access().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_1__Group__0__Impl"


    // $ANTLR start "rule__Child2_1__Group__1"
    // InternalBug348427TestLanguage.g:3005:1: rule__Child2_1__Group__1 : rule__Child2_1__Group__1__Impl rule__Child2_1__Group__2 ;
    public final void rule__Child2_1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3009:1: ( rule__Child2_1__Group__1__Impl rule__Child2_1__Group__2 )
            // InternalBug348427TestLanguage.g:3010:2: rule__Child2_1__Group__1__Impl rule__Child2_1__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Child2_1__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_1__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_1__Group__1"


    // $ANTLR start "rule__Child2_1__Group__1__Impl"
    // InternalBug348427TestLanguage.g:3017:1: rule__Child2_1__Group__1__Impl : ( ':' ) ;
    public final void rule__Child2_1__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3021:1: ( ( ':' ) )
            // InternalBug348427TestLanguage.g:3022:1: ( ':' )
            {
            // InternalBug348427TestLanguage.g:3022:1: ( ':' )
            // InternalBug348427TestLanguage.g:3023:2: ':'
            {
             before(grammarAccess.getChild2_1Access().getColonKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_1Access().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_1__Group__1__Impl"


    // $ANTLR start "rule__Child2_1__Group__2"
    // InternalBug348427TestLanguage.g:3032:1: rule__Child2_1__Group__2 : rule__Child2_1__Group__2__Impl rule__Child2_1__Group__3 ;
    public final void rule__Child2_1__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3036:1: ( rule__Child2_1__Group__2__Impl rule__Child2_1__Group__3 )
            // InternalBug348427TestLanguage.g:3037:2: rule__Child2_1__Group__2__Impl rule__Child2_1__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Child2_1__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_1__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_1__Group__2"


    // $ANTLR start "rule__Child2_1__Group__2__Impl"
    // InternalBug348427TestLanguage.g:3044:1: rule__Child2_1__Group__2__Impl : ( ( rule__Child2_1__Group_2__0 )? ) ;
    public final void rule__Child2_1__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3048:1: ( ( ( rule__Child2_1__Group_2__0 )? ) )
            // InternalBug348427TestLanguage.g:3049:1: ( ( rule__Child2_1__Group_2__0 )? )
            {
            // InternalBug348427TestLanguage.g:3049:1: ( ( rule__Child2_1__Group_2__0 )? )
            // InternalBug348427TestLanguage.g:3050:2: ( rule__Child2_1__Group_2__0 )?
            {
             before(grammarAccess.getChild2_1Access().getGroup_2()); 
            // InternalBug348427TestLanguage.g:3051:2: ( rule__Child2_1__Group_2__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==32) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalBug348427TestLanguage.g:3051:3: rule__Child2_1__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Child2_1__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getChild2_1Access().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_1__Group__2__Impl"


    // $ANTLR start "rule__Child2_1__Group__3"
    // InternalBug348427TestLanguage.g:3059:1: rule__Child2_1__Group__3 : rule__Child2_1__Group__3__Impl rule__Child2_1__Group__4 ;
    public final void rule__Child2_1__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3063:1: ( rule__Child2_1__Group__3__Impl rule__Child2_1__Group__4 )
            // InternalBug348427TestLanguage.g:3064:2: rule__Child2_1__Group__3__Impl rule__Child2_1__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__Child2_1__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_1__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_1__Group__3"


    // $ANTLR start "rule__Child2_1__Group__3__Impl"
    // InternalBug348427TestLanguage.g:3071:1: rule__Child2_1__Group__3__Impl : ( ( rule__Child2_1__StringAssignment_3 ) ) ;
    public final void rule__Child2_1__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3075:1: ( ( ( rule__Child2_1__StringAssignment_3 ) ) )
            // InternalBug348427TestLanguage.g:3076:1: ( ( rule__Child2_1__StringAssignment_3 ) )
            {
            // InternalBug348427TestLanguage.g:3076:1: ( ( rule__Child2_1__StringAssignment_3 ) )
            // InternalBug348427TestLanguage.g:3077:2: ( rule__Child2_1__StringAssignment_3 )
            {
             before(grammarAccess.getChild2_1Access().getStringAssignment_3()); 
            // InternalBug348427TestLanguage.g:3078:2: ( rule__Child2_1__StringAssignment_3 )
            // InternalBug348427TestLanguage.g:3078:3: rule__Child2_1__StringAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_1__StringAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getChild2_1Access().getStringAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_1__Group__3__Impl"


    // $ANTLR start "rule__Child2_1__Group__4"
    // InternalBug348427TestLanguage.g:3086:1: rule__Child2_1__Group__4 : rule__Child2_1__Group__4__Impl rule__Child2_1__Group__5 ;
    public final void rule__Child2_1__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3090:1: ( rule__Child2_1__Group__4__Impl rule__Child2_1__Group__5 )
            // InternalBug348427TestLanguage.g:3091:2: rule__Child2_1__Group__4__Impl rule__Child2_1__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__Child2_1__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_1__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_1__Group__4"


    // $ANTLR start "rule__Child2_1__Group__4__Impl"
    // InternalBug348427TestLanguage.g:3098:1: rule__Child2_1__Group__4__Impl : ( 'child1' ) ;
    public final void rule__Child2_1__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3102:1: ( ( 'child1' ) )
            // InternalBug348427TestLanguage.g:3103:1: ( 'child1' )
            {
            // InternalBug348427TestLanguage.g:3103:1: ( 'child1' )
            // InternalBug348427TestLanguage.g:3104:2: 'child1'
            {
             before(grammarAccess.getChild2_1Access().getChild1Keyword_4()); 
            match(input,19,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_1Access().getChild1Keyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_1__Group__4__Impl"


    // $ANTLR start "rule__Child2_1__Group__5"
    // InternalBug348427TestLanguage.g:3113:1: rule__Child2_1__Group__5 : rule__Child2_1__Group__5__Impl ;
    public final void rule__Child2_1__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3117:1: ( rule__Child2_1__Group__5__Impl )
            // InternalBug348427TestLanguage.g:3118:2: rule__Child2_1__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_1__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_1__Group__5"


    // $ANTLR start "rule__Child2_1__Group__5__Impl"
    // InternalBug348427TestLanguage.g:3124:1: rule__Child2_1__Group__5__Impl : ( 'end' ) ;
    public final void rule__Child2_1__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3128:1: ( ( 'end' ) )
            // InternalBug348427TestLanguage.g:3129:1: ( 'end' )
            {
            // InternalBug348427TestLanguage.g:3129:1: ( 'end' )
            // InternalBug348427TestLanguage.g:3130:2: 'end'
            {
             before(grammarAccess.getChild2_1Access().getEndKeyword_5()); 
            match(input,20,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_1Access().getEndKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_1__Group__5__Impl"


    // $ANTLR start "rule__Child2_1__Group_2__0"
    // InternalBug348427TestLanguage.g:3140:1: rule__Child2_1__Group_2__0 : rule__Child2_1__Group_2__0__Impl rule__Child2_1__Group_2__1 ;
    public final void rule__Child2_1__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3144:1: ( rule__Child2_1__Group_2__0__Impl rule__Child2_1__Group_2__1 )
            // InternalBug348427TestLanguage.g:3145:2: rule__Child2_1__Group_2__0__Impl rule__Child2_1__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__Child2_1__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_1__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_1__Group_2__0"


    // $ANTLR start "rule__Child2_1__Group_2__0__Impl"
    // InternalBug348427TestLanguage.g:3152:1: rule__Child2_1__Group_2__0__Impl : ( ( rule__Child2_1__BoolAssignment_2_0 ) ) ;
    public final void rule__Child2_1__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3156:1: ( ( ( rule__Child2_1__BoolAssignment_2_0 ) ) )
            // InternalBug348427TestLanguage.g:3157:1: ( ( rule__Child2_1__BoolAssignment_2_0 ) )
            {
            // InternalBug348427TestLanguage.g:3157:1: ( ( rule__Child2_1__BoolAssignment_2_0 ) )
            // InternalBug348427TestLanguage.g:3158:2: ( rule__Child2_1__BoolAssignment_2_0 )
            {
             before(grammarAccess.getChild2_1Access().getBoolAssignment_2_0()); 
            // InternalBug348427TestLanguage.g:3159:2: ( rule__Child2_1__BoolAssignment_2_0 )
            // InternalBug348427TestLanguage.g:3159:3: rule__Child2_1__BoolAssignment_2_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_1__BoolAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getChild2_1Access().getBoolAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_1__Group_2__0__Impl"


    // $ANTLR start "rule__Child2_1__Group_2__1"
    // InternalBug348427TestLanguage.g:3167:1: rule__Child2_1__Group_2__1 : rule__Child2_1__Group_2__1__Impl ;
    public final void rule__Child2_1__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3171:1: ( rule__Child2_1__Group_2__1__Impl )
            // InternalBug348427TestLanguage.g:3172:2: rule__Child2_1__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_1__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_1__Group_2__1"


    // $ANTLR start "rule__Child2_1__Group_2__1__Impl"
    // InternalBug348427TestLanguage.g:3178:1: rule__Child2_1__Group_2__1__Impl : ( 'keyword' ) ;
    public final void rule__Child2_1__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3182:1: ( ( 'keyword' ) )
            // InternalBug348427TestLanguage.g:3183:1: ( 'keyword' )
            {
            // InternalBug348427TestLanguage.g:3183:1: ( 'keyword' )
            // InternalBug348427TestLanguage.g:3184:2: 'keyword'
            {
             before(grammarAccess.getChild2_1Access().getKeywordKeyword_2_1()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_1Access().getKeywordKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_1__Group_2__1__Impl"


    // $ANTLR start "rule__Child2_2__Group__0"
    // InternalBug348427TestLanguage.g:3194:1: rule__Child2_2__Group__0 : rule__Child2_2__Group__0__Impl rule__Child2_2__Group__1 ;
    public final void rule__Child2_2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3198:1: ( rule__Child2_2__Group__0__Impl rule__Child2_2__Group__1 )
            // InternalBug348427TestLanguage.g:3199:2: rule__Child2_2__Group__0__Impl rule__Child2_2__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__Child2_2__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_2__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_2__Group__0"


    // $ANTLR start "rule__Child2_2__Group__0__Impl"
    // InternalBug348427TestLanguage.g:3206:1: rule__Child2_2__Group__0__Impl : ( ( rule__Child2_2__NameAssignment_0 ) ) ;
    public final void rule__Child2_2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3210:1: ( ( ( rule__Child2_2__NameAssignment_0 ) ) )
            // InternalBug348427TestLanguage.g:3211:1: ( ( rule__Child2_2__NameAssignment_0 ) )
            {
            // InternalBug348427TestLanguage.g:3211:1: ( ( rule__Child2_2__NameAssignment_0 ) )
            // InternalBug348427TestLanguage.g:3212:2: ( rule__Child2_2__NameAssignment_0 )
            {
             before(grammarAccess.getChild2_2Access().getNameAssignment_0()); 
            // InternalBug348427TestLanguage.g:3213:2: ( rule__Child2_2__NameAssignment_0 )
            // InternalBug348427TestLanguage.g:3213:3: rule__Child2_2__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_2__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getChild2_2Access().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_2__Group__0__Impl"


    // $ANTLR start "rule__Child2_2__Group__1"
    // InternalBug348427TestLanguage.g:3221:1: rule__Child2_2__Group__1 : rule__Child2_2__Group__1__Impl rule__Child2_2__Group__2 ;
    public final void rule__Child2_2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3225:1: ( rule__Child2_2__Group__1__Impl rule__Child2_2__Group__2 )
            // InternalBug348427TestLanguage.g:3226:2: rule__Child2_2__Group__1__Impl rule__Child2_2__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Child2_2__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_2__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_2__Group__1"


    // $ANTLR start "rule__Child2_2__Group__1__Impl"
    // InternalBug348427TestLanguage.g:3233:1: rule__Child2_2__Group__1__Impl : ( ':' ) ;
    public final void rule__Child2_2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3237:1: ( ( ':' ) )
            // InternalBug348427TestLanguage.g:3238:1: ( ':' )
            {
            // InternalBug348427TestLanguage.g:3238:1: ( ':' )
            // InternalBug348427TestLanguage.g:3239:2: ':'
            {
             before(grammarAccess.getChild2_2Access().getColonKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_2Access().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_2__Group__1__Impl"


    // $ANTLR start "rule__Child2_2__Group__2"
    // InternalBug348427TestLanguage.g:3248:1: rule__Child2_2__Group__2 : rule__Child2_2__Group__2__Impl rule__Child2_2__Group__3 ;
    public final void rule__Child2_2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3252:1: ( rule__Child2_2__Group__2__Impl rule__Child2_2__Group__3 )
            // InternalBug348427TestLanguage.g:3253:2: rule__Child2_2__Group__2__Impl rule__Child2_2__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Child2_2__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_2__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_2__Group__2"


    // $ANTLR start "rule__Child2_2__Group__2__Impl"
    // InternalBug348427TestLanguage.g:3260:1: rule__Child2_2__Group__2__Impl : ( ( rule__Child2_2__Group_2__0 )? ) ;
    public final void rule__Child2_2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3264:1: ( ( ( rule__Child2_2__Group_2__0 )? ) )
            // InternalBug348427TestLanguage.g:3265:1: ( ( rule__Child2_2__Group_2__0 )? )
            {
            // InternalBug348427TestLanguage.g:3265:1: ( ( rule__Child2_2__Group_2__0 )? )
            // InternalBug348427TestLanguage.g:3266:2: ( rule__Child2_2__Group_2__0 )?
            {
             before(grammarAccess.getChild2_2Access().getGroup_2()); 
            // InternalBug348427TestLanguage.g:3267:2: ( rule__Child2_2__Group_2__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==32) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalBug348427TestLanguage.g:3267:3: rule__Child2_2__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Child2_2__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getChild2_2Access().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_2__Group__2__Impl"


    // $ANTLR start "rule__Child2_2__Group__3"
    // InternalBug348427TestLanguage.g:3275:1: rule__Child2_2__Group__3 : rule__Child2_2__Group__3__Impl rule__Child2_2__Group__4 ;
    public final void rule__Child2_2__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3279:1: ( rule__Child2_2__Group__3__Impl rule__Child2_2__Group__4 )
            // InternalBug348427TestLanguage.g:3280:2: rule__Child2_2__Group__3__Impl rule__Child2_2__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_14);
            rule__Child2_2__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_2__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_2__Group__3"


    // $ANTLR start "rule__Child2_2__Group__3__Impl"
    // InternalBug348427TestLanguage.g:3287:1: rule__Child2_2__Group__3__Impl : ( ( rule__Child2_2__StringAssignment_3 ) ) ;
    public final void rule__Child2_2__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3291:1: ( ( ( rule__Child2_2__StringAssignment_3 ) ) )
            // InternalBug348427TestLanguage.g:3292:1: ( ( rule__Child2_2__StringAssignment_3 ) )
            {
            // InternalBug348427TestLanguage.g:3292:1: ( ( rule__Child2_2__StringAssignment_3 ) )
            // InternalBug348427TestLanguage.g:3293:2: ( rule__Child2_2__StringAssignment_3 )
            {
             before(grammarAccess.getChild2_2Access().getStringAssignment_3()); 
            // InternalBug348427TestLanguage.g:3294:2: ( rule__Child2_2__StringAssignment_3 )
            // InternalBug348427TestLanguage.g:3294:3: rule__Child2_2__StringAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_2__StringAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getChild2_2Access().getStringAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_2__Group__3__Impl"


    // $ANTLR start "rule__Child2_2__Group__4"
    // InternalBug348427TestLanguage.g:3302:1: rule__Child2_2__Group__4 : rule__Child2_2__Group__4__Impl rule__Child2_2__Group__5 ;
    public final void rule__Child2_2__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3306:1: ( rule__Child2_2__Group__4__Impl rule__Child2_2__Group__5 )
            // InternalBug348427TestLanguage.g:3307:2: rule__Child2_2__Group__4__Impl rule__Child2_2__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__Child2_2__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_2__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_2__Group__4"


    // $ANTLR start "rule__Child2_2__Group__4__Impl"
    // InternalBug348427TestLanguage.g:3314:1: rule__Child2_2__Group__4__Impl : ( 'child2' ) ;
    public final void rule__Child2_2__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3318:1: ( ( 'child2' ) )
            // InternalBug348427TestLanguage.g:3319:1: ( 'child2' )
            {
            // InternalBug348427TestLanguage.g:3319:1: ( 'child2' )
            // InternalBug348427TestLanguage.g:3320:2: 'child2'
            {
             before(grammarAccess.getChild2_2Access().getChild2Keyword_4()); 
            match(input,22,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_2Access().getChild2Keyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_2__Group__4__Impl"


    // $ANTLR start "rule__Child2_2__Group__5"
    // InternalBug348427TestLanguage.g:3329:1: rule__Child2_2__Group__5 : rule__Child2_2__Group__5__Impl ;
    public final void rule__Child2_2__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3333:1: ( rule__Child2_2__Group__5__Impl )
            // InternalBug348427TestLanguage.g:3334:2: rule__Child2_2__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_2__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_2__Group__5"


    // $ANTLR start "rule__Child2_2__Group__5__Impl"
    // InternalBug348427TestLanguage.g:3340:1: rule__Child2_2__Group__5__Impl : ( 'end' ) ;
    public final void rule__Child2_2__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3344:1: ( ( 'end' ) )
            // InternalBug348427TestLanguage.g:3345:1: ( 'end' )
            {
            // InternalBug348427TestLanguage.g:3345:1: ( 'end' )
            // InternalBug348427TestLanguage.g:3346:2: 'end'
            {
             before(grammarAccess.getChild2_2Access().getEndKeyword_5()); 
            match(input,20,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_2Access().getEndKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_2__Group__5__Impl"


    // $ANTLR start "rule__Child2_2__Group_2__0"
    // InternalBug348427TestLanguage.g:3356:1: rule__Child2_2__Group_2__0 : rule__Child2_2__Group_2__0__Impl rule__Child2_2__Group_2__1 ;
    public final void rule__Child2_2__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3360:1: ( rule__Child2_2__Group_2__0__Impl rule__Child2_2__Group_2__1 )
            // InternalBug348427TestLanguage.g:3361:2: rule__Child2_2__Group_2__0__Impl rule__Child2_2__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__Child2_2__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_2__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_2__Group_2__0"


    // $ANTLR start "rule__Child2_2__Group_2__0__Impl"
    // InternalBug348427TestLanguage.g:3368:1: rule__Child2_2__Group_2__0__Impl : ( ( rule__Child2_2__BoolAssignment_2_0 ) ) ;
    public final void rule__Child2_2__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3372:1: ( ( ( rule__Child2_2__BoolAssignment_2_0 ) ) )
            // InternalBug348427TestLanguage.g:3373:1: ( ( rule__Child2_2__BoolAssignment_2_0 ) )
            {
            // InternalBug348427TestLanguage.g:3373:1: ( ( rule__Child2_2__BoolAssignment_2_0 ) )
            // InternalBug348427TestLanguage.g:3374:2: ( rule__Child2_2__BoolAssignment_2_0 )
            {
             before(grammarAccess.getChild2_2Access().getBoolAssignment_2_0()); 
            // InternalBug348427TestLanguage.g:3375:2: ( rule__Child2_2__BoolAssignment_2_0 )
            // InternalBug348427TestLanguage.g:3375:3: rule__Child2_2__BoolAssignment_2_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_2__BoolAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getChild2_2Access().getBoolAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_2__Group_2__0__Impl"


    // $ANTLR start "rule__Child2_2__Group_2__1"
    // InternalBug348427TestLanguage.g:3383:1: rule__Child2_2__Group_2__1 : rule__Child2_2__Group_2__1__Impl ;
    public final void rule__Child2_2__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3387:1: ( rule__Child2_2__Group_2__1__Impl )
            // InternalBug348427TestLanguage.g:3388:2: rule__Child2_2__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_2__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_2__Group_2__1"


    // $ANTLR start "rule__Child2_2__Group_2__1__Impl"
    // InternalBug348427TestLanguage.g:3394:1: rule__Child2_2__Group_2__1__Impl : ( 'keyword' ) ;
    public final void rule__Child2_2__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3398:1: ( ( 'keyword' ) )
            // InternalBug348427TestLanguage.g:3399:1: ( 'keyword' )
            {
            // InternalBug348427TestLanguage.g:3399:1: ( 'keyword' )
            // InternalBug348427TestLanguage.g:3400:2: 'keyword'
            {
             before(grammarAccess.getChild2_2Access().getKeywordKeyword_2_1()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_2Access().getKeywordKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_2__Group_2__1__Impl"


    // $ANTLR start "rule__Child2_3__Group__0"
    // InternalBug348427TestLanguage.g:3410:1: rule__Child2_3__Group__0 : rule__Child2_3__Group__0__Impl rule__Child2_3__Group__1 ;
    public final void rule__Child2_3__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3414:1: ( rule__Child2_3__Group__0__Impl rule__Child2_3__Group__1 )
            // InternalBug348427TestLanguage.g:3415:2: rule__Child2_3__Group__0__Impl rule__Child2_3__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__Child2_3__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_3__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_3__Group__0"


    // $ANTLR start "rule__Child2_3__Group__0__Impl"
    // InternalBug348427TestLanguage.g:3422:1: rule__Child2_3__Group__0__Impl : ( ( rule__Child2_3__NameAssignment_0 ) ) ;
    public final void rule__Child2_3__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3426:1: ( ( ( rule__Child2_3__NameAssignment_0 ) ) )
            // InternalBug348427TestLanguage.g:3427:1: ( ( rule__Child2_3__NameAssignment_0 ) )
            {
            // InternalBug348427TestLanguage.g:3427:1: ( ( rule__Child2_3__NameAssignment_0 ) )
            // InternalBug348427TestLanguage.g:3428:2: ( rule__Child2_3__NameAssignment_0 )
            {
             before(grammarAccess.getChild2_3Access().getNameAssignment_0()); 
            // InternalBug348427TestLanguage.g:3429:2: ( rule__Child2_3__NameAssignment_0 )
            // InternalBug348427TestLanguage.g:3429:3: rule__Child2_3__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_3__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getChild2_3Access().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_3__Group__0__Impl"


    // $ANTLR start "rule__Child2_3__Group__1"
    // InternalBug348427TestLanguage.g:3437:1: rule__Child2_3__Group__1 : rule__Child2_3__Group__1__Impl rule__Child2_3__Group__2 ;
    public final void rule__Child2_3__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3441:1: ( rule__Child2_3__Group__1__Impl rule__Child2_3__Group__2 )
            // InternalBug348427TestLanguage.g:3442:2: rule__Child2_3__Group__1__Impl rule__Child2_3__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Child2_3__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_3__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_3__Group__1"


    // $ANTLR start "rule__Child2_3__Group__1__Impl"
    // InternalBug348427TestLanguage.g:3449:1: rule__Child2_3__Group__1__Impl : ( ':' ) ;
    public final void rule__Child2_3__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3453:1: ( ( ':' ) )
            // InternalBug348427TestLanguage.g:3454:1: ( ':' )
            {
            // InternalBug348427TestLanguage.g:3454:1: ( ':' )
            // InternalBug348427TestLanguage.g:3455:2: ':'
            {
             before(grammarAccess.getChild2_3Access().getColonKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_3Access().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_3__Group__1__Impl"


    // $ANTLR start "rule__Child2_3__Group__2"
    // InternalBug348427TestLanguage.g:3464:1: rule__Child2_3__Group__2 : rule__Child2_3__Group__2__Impl rule__Child2_3__Group__3 ;
    public final void rule__Child2_3__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3468:1: ( rule__Child2_3__Group__2__Impl rule__Child2_3__Group__3 )
            // InternalBug348427TestLanguage.g:3469:2: rule__Child2_3__Group__2__Impl rule__Child2_3__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Child2_3__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_3__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_3__Group__2"


    // $ANTLR start "rule__Child2_3__Group__2__Impl"
    // InternalBug348427TestLanguage.g:3476:1: rule__Child2_3__Group__2__Impl : ( ( rule__Child2_3__Group_2__0 )? ) ;
    public final void rule__Child2_3__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3480:1: ( ( ( rule__Child2_3__Group_2__0 )? ) )
            // InternalBug348427TestLanguage.g:3481:1: ( ( rule__Child2_3__Group_2__0 )? )
            {
            // InternalBug348427TestLanguage.g:3481:1: ( ( rule__Child2_3__Group_2__0 )? )
            // InternalBug348427TestLanguage.g:3482:2: ( rule__Child2_3__Group_2__0 )?
            {
             before(grammarAccess.getChild2_3Access().getGroup_2()); 
            // InternalBug348427TestLanguage.g:3483:2: ( rule__Child2_3__Group_2__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==32) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalBug348427TestLanguage.g:3483:3: rule__Child2_3__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Child2_3__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getChild2_3Access().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_3__Group__2__Impl"


    // $ANTLR start "rule__Child2_3__Group__3"
    // InternalBug348427TestLanguage.g:3491:1: rule__Child2_3__Group__3 : rule__Child2_3__Group__3__Impl rule__Child2_3__Group__4 ;
    public final void rule__Child2_3__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3495:1: ( rule__Child2_3__Group__3__Impl rule__Child2_3__Group__4 )
            // InternalBug348427TestLanguage.g:3496:2: rule__Child2_3__Group__3__Impl rule__Child2_3__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_15);
            rule__Child2_3__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_3__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_3__Group__3"


    // $ANTLR start "rule__Child2_3__Group__3__Impl"
    // InternalBug348427TestLanguage.g:3503:1: rule__Child2_3__Group__3__Impl : ( ( rule__Child2_3__StringAssignment_3 ) ) ;
    public final void rule__Child2_3__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3507:1: ( ( ( rule__Child2_3__StringAssignment_3 ) ) )
            // InternalBug348427TestLanguage.g:3508:1: ( ( rule__Child2_3__StringAssignment_3 ) )
            {
            // InternalBug348427TestLanguage.g:3508:1: ( ( rule__Child2_3__StringAssignment_3 ) )
            // InternalBug348427TestLanguage.g:3509:2: ( rule__Child2_3__StringAssignment_3 )
            {
             before(grammarAccess.getChild2_3Access().getStringAssignment_3()); 
            // InternalBug348427TestLanguage.g:3510:2: ( rule__Child2_3__StringAssignment_3 )
            // InternalBug348427TestLanguage.g:3510:3: rule__Child2_3__StringAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_3__StringAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getChild2_3Access().getStringAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_3__Group__3__Impl"


    // $ANTLR start "rule__Child2_3__Group__4"
    // InternalBug348427TestLanguage.g:3518:1: rule__Child2_3__Group__4 : rule__Child2_3__Group__4__Impl rule__Child2_3__Group__5 ;
    public final void rule__Child2_3__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3522:1: ( rule__Child2_3__Group__4__Impl rule__Child2_3__Group__5 )
            // InternalBug348427TestLanguage.g:3523:2: rule__Child2_3__Group__4__Impl rule__Child2_3__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__Child2_3__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_3__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_3__Group__4"


    // $ANTLR start "rule__Child2_3__Group__4__Impl"
    // InternalBug348427TestLanguage.g:3530:1: rule__Child2_3__Group__4__Impl : ( 'child3' ) ;
    public final void rule__Child2_3__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3534:1: ( ( 'child3' ) )
            // InternalBug348427TestLanguage.g:3535:1: ( 'child3' )
            {
            // InternalBug348427TestLanguage.g:3535:1: ( 'child3' )
            // InternalBug348427TestLanguage.g:3536:2: 'child3'
            {
             before(grammarAccess.getChild2_3Access().getChild3Keyword_4()); 
            match(input,23,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_3Access().getChild3Keyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_3__Group__4__Impl"


    // $ANTLR start "rule__Child2_3__Group__5"
    // InternalBug348427TestLanguage.g:3545:1: rule__Child2_3__Group__5 : rule__Child2_3__Group__5__Impl ;
    public final void rule__Child2_3__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3549:1: ( rule__Child2_3__Group__5__Impl )
            // InternalBug348427TestLanguage.g:3550:2: rule__Child2_3__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_3__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_3__Group__5"


    // $ANTLR start "rule__Child2_3__Group__5__Impl"
    // InternalBug348427TestLanguage.g:3556:1: rule__Child2_3__Group__5__Impl : ( 'end' ) ;
    public final void rule__Child2_3__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3560:1: ( ( 'end' ) )
            // InternalBug348427TestLanguage.g:3561:1: ( 'end' )
            {
            // InternalBug348427TestLanguage.g:3561:1: ( 'end' )
            // InternalBug348427TestLanguage.g:3562:2: 'end'
            {
             before(grammarAccess.getChild2_3Access().getEndKeyword_5()); 
            match(input,20,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_3Access().getEndKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_3__Group__5__Impl"


    // $ANTLR start "rule__Child2_3__Group_2__0"
    // InternalBug348427TestLanguage.g:3572:1: rule__Child2_3__Group_2__0 : rule__Child2_3__Group_2__0__Impl rule__Child2_3__Group_2__1 ;
    public final void rule__Child2_3__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3576:1: ( rule__Child2_3__Group_2__0__Impl rule__Child2_3__Group_2__1 )
            // InternalBug348427TestLanguage.g:3577:2: rule__Child2_3__Group_2__0__Impl rule__Child2_3__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__Child2_3__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_3__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_3__Group_2__0"


    // $ANTLR start "rule__Child2_3__Group_2__0__Impl"
    // InternalBug348427TestLanguage.g:3584:1: rule__Child2_3__Group_2__0__Impl : ( ( rule__Child2_3__BoolAssignment_2_0 ) ) ;
    public final void rule__Child2_3__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3588:1: ( ( ( rule__Child2_3__BoolAssignment_2_0 ) ) )
            // InternalBug348427TestLanguage.g:3589:1: ( ( rule__Child2_3__BoolAssignment_2_0 ) )
            {
            // InternalBug348427TestLanguage.g:3589:1: ( ( rule__Child2_3__BoolAssignment_2_0 ) )
            // InternalBug348427TestLanguage.g:3590:2: ( rule__Child2_3__BoolAssignment_2_0 )
            {
             before(grammarAccess.getChild2_3Access().getBoolAssignment_2_0()); 
            // InternalBug348427TestLanguage.g:3591:2: ( rule__Child2_3__BoolAssignment_2_0 )
            // InternalBug348427TestLanguage.g:3591:3: rule__Child2_3__BoolAssignment_2_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_3__BoolAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getChild2_3Access().getBoolAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_3__Group_2__0__Impl"


    // $ANTLR start "rule__Child2_3__Group_2__1"
    // InternalBug348427TestLanguage.g:3599:1: rule__Child2_3__Group_2__1 : rule__Child2_3__Group_2__1__Impl ;
    public final void rule__Child2_3__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3603:1: ( rule__Child2_3__Group_2__1__Impl )
            // InternalBug348427TestLanguage.g:3604:2: rule__Child2_3__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_3__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_3__Group_2__1"


    // $ANTLR start "rule__Child2_3__Group_2__1__Impl"
    // InternalBug348427TestLanguage.g:3610:1: rule__Child2_3__Group_2__1__Impl : ( 'keyword' ) ;
    public final void rule__Child2_3__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3614:1: ( ( 'keyword' ) )
            // InternalBug348427TestLanguage.g:3615:1: ( 'keyword' )
            {
            // InternalBug348427TestLanguage.g:3615:1: ( 'keyword' )
            // InternalBug348427TestLanguage.g:3616:2: 'keyword'
            {
             before(grammarAccess.getChild2_3Access().getKeywordKeyword_2_1()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_3Access().getKeywordKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_3__Group_2__1__Impl"


    // $ANTLR start "rule__Child2_4__Group__0"
    // InternalBug348427TestLanguage.g:3626:1: rule__Child2_4__Group__0 : rule__Child2_4__Group__0__Impl rule__Child2_4__Group__1 ;
    public final void rule__Child2_4__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3630:1: ( rule__Child2_4__Group__0__Impl rule__Child2_4__Group__1 )
            // InternalBug348427TestLanguage.g:3631:2: rule__Child2_4__Group__0__Impl rule__Child2_4__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__Child2_4__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_4__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_4__Group__0"


    // $ANTLR start "rule__Child2_4__Group__0__Impl"
    // InternalBug348427TestLanguage.g:3638:1: rule__Child2_4__Group__0__Impl : ( ( rule__Child2_4__NameAssignment_0 ) ) ;
    public final void rule__Child2_4__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3642:1: ( ( ( rule__Child2_4__NameAssignment_0 ) ) )
            // InternalBug348427TestLanguage.g:3643:1: ( ( rule__Child2_4__NameAssignment_0 ) )
            {
            // InternalBug348427TestLanguage.g:3643:1: ( ( rule__Child2_4__NameAssignment_0 ) )
            // InternalBug348427TestLanguage.g:3644:2: ( rule__Child2_4__NameAssignment_0 )
            {
             before(grammarAccess.getChild2_4Access().getNameAssignment_0()); 
            // InternalBug348427TestLanguage.g:3645:2: ( rule__Child2_4__NameAssignment_0 )
            // InternalBug348427TestLanguage.g:3645:3: rule__Child2_4__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_4__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getChild2_4Access().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_4__Group__0__Impl"


    // $ANTLR start "rule__Child2_4__Group__1"
    // InternalBug348427TestLanguage.g:3653:1: rule__Child2_4__Group__1 : rule__Child2_4__Group__1__Impl rule__Child2_4__Group__2 ;
    public final void rule__Child2_4__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3657:1: ( rule__Child2_4__Group__1__Impl rule__Child2_4__Group__2 )
            // InternalBug348427TestLanguage.g:3658:2: rule__Child2_4__Group__1__Impl rule__Child2_4__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Child2_4__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_4__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_4__Group__1"


    // $ANTLR start "rule__Child2_4__Group__1__Impl"
    // InternalBug348427TestLanguage.g:3665:1: rule__Child2_4__Group__1__Impl : ( ':' ) ;
    public final void rule__Child2_4__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3669:1: ( ( ':' ) )
            // InternalBug348427TestLanguage.g:3670:1: ( ':' )
            {
            // InternalBug348427TestLanguage.g:3670:1: ( ':' )
            // InternalBug348427TestLanguage.g:3671:2: ':'
            {
             before(grammarAccess.getChild2_4Access().getColonKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_4Access().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_4__Group__1__Impl"


    // $ANTLR start "rule__Child2_4__Group__2"
    // InternalBug348427TestLanguage.g:3680:1: rule__Child2_4__Group__2 : rule__Child2_4__Group__2__Impl rule__Child2_4__Group__3 ;
    public final void rule__Child2_4__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3684:1: ( rule__Child2_4__Group__2__Impl rule__Child2_4__Group__3 )
            // InternalBug348427TestLanguage.g:3685:2: rule__Child2_4__Group__2__Impl rule__Child2_4__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Child2_4__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_4__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_4__Group__2"


    // $ANTLR start "rule__Child2_4__Group__2__Impl"
    // InternalBug348427TestLanguage.g:3692:1: rule__Child2_4__Group__2__Impl : ( ( rule__Child2_4__Group_2__0 )? ) ;
    public final void rule__Child2_4__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3696:1: ( ( ( rule__Child2_4__Group_2__0 )? ) )
            // InternalBug348427TestLanguage.g:3697:1: ( ( rule__Child2_4__Group_2__0 )? )
            {
            // InternalBug348427TestLanguage.g:3697:1: ( ( rule__Child2_4__Group_2__0 )? )
            // InternalBug348427TestLanguage.g:3698:2: ( rule__Child2_4__Group_2__0 )?
            {
             before(grammarAccess.getChild2_4Access().getGroup_2()); 
            // InternalBug348427TestLanguage.g:3699:2: ( rule__Child2_4__Group_2__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==32) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalBug348427TestLanguage.g:3699:3: rule__Child2_4__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Child2_4__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getChild2_4Access().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_4__Group__2__Impl"


    // $ANTLR start "rule__Child2_4__Group__3"
    // InternalBug348427TestLanguage.g:3707:1: rule__Child2_4__Group__3 : rule__Child2_4__Group__3__Impl rule__Child2_4__Group__4 ;
    public final void rule__Child2_4__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3711:1: ( rule__Child2_4__Group__3__Impl rule__Child2_4__Group__4 )
            // InternalBug348427TestLanguage.g:3712:2: rule__Child2_4__Group__3__Impl rule__Child2_4__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__Child2_4__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_4__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_4__Group__3"


    // $ANTLR start "rule__Child2_4__Group__3__Impl"
    // InternalBug348427TestLanguage.g:3719:1: rule__Child2_4__Group__3__Impl : ( ( rule__Child2_4__Alternatives_3 ) ) ;
    public final void rule__Child2_4__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3723:1: ( ( ( rule__Child2_4__Alternatives_3 ) ) )
            // InternalBug348427TestLanguage.g:3724:1: ( ( rule__Child2_4__Alternatives_3 ) )
            {
            // InternalBug348427TestLanguage.g:3724:1: ( ( rule__Child2_4__Alternatives_3 ) )
            // InternalBug348427TestLanguage.g:3725:2: ( rule__Child2_4__Alternatives_3 )
            {
             before(grammarAccess.getChild2_4Access().getAlternatives_3()); 
            // InternalBug348427TestLanguage.g:3726:2: ( rule__Child2_4__Alternatives_3 )
            // InternalBug348427TestLanguage.g:3726:3: rule__Child2_4__Alternatives_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_4__Alternatives_3();

            state._fsp--;


            }

             after(grammarAccess.getChild2_4Access().getAlternatives_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_4__Group__3__Impl"


    // $ANTLR start "rule__Child2_4__Group__4"
    // InternalBug348427TestLanguage.g:3734:1: rule__Child2_4__Group__4 : rule__Child2_4__Group__4__Impl rule__Child2_4__Group__5 ;
    public final void rule__Child2_4__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3738:1: ( rule__Child2_4__Group__4__Impl rule__Child2_4__Group__5 )
            // InternalBug348427TestLanguage.g:3739:2: rule__Child2_4__Group__4__Impl rule__Child2_4__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__Child2_4__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_4__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_4__Group__4"


    // $ANTLR start "rule__Child2_4__Group__4__Impl"
    // InternalBug348427TestLanguage.g:3746:1: rule__Child2_4__Group__4__Impl : ( 'child1' ) ;
    public final void rule__Child2_4__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3750:1: ( ( 'child1' ) )
            // InternalBug348427TestLanguage.g:3751:1: ( 'child1' )
            {
            // InternalBug348427TestLanguage.g:3751:1: ( 'child1' )
            // InternalBug348427TestLanguage.g:3752:2: 'child1'
            {
             before(grammarAccess.getChild2_4Access().getChild1Keyword_4()); 
            match(input,19,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_4Access().getChild1Keyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_4__Group__4__Impl"


    // $ANTLR start "rule__Child2_4__Group__5"
    // InternalBug348427TestLanguage.g:3761:1: rule__Child2_4__Group__5 : rule__Child2_4__Group__5__Impl ;
    public final void rule__Child2_4__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3765:1: ( rule__Child2_4__Group__5__Impl )
            // InternalBug348427TestLanguage.g:3766:2: rule__Child2_4__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_4__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_4__Group__5"


    // $ANTLR start "rule__Child2_4__Group__5__Impl"
    // InternalBug348427TestLanguage.g:3772:1: rule__Child2_4__Group__5__Impl : ( 'end' ) ;
    public final void rule__Child2_4__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3776:1: ( ( 'end' ) )
            // InternalBug348427TestLanguage.g:3777:1: ( 'end' )
            {
            // InternalBug348427TestLanguage.g:3777:1: ( 'end' )
            // InternalBug348427TestLanguage.g:3778:2: 'end'
            {
             before(grammarAccess.getChild2_4Access().getEndKeyword_5()); 
            match(input,20,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_4Access().getEndKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_4__Group__5__Impl"


    // $ANTLR start "rule__Child2_4__Group_2__0"
    // InternalBug348427TestLanguage.g:3788:1: rule__Child2_4__Group_2__0 : rule__Child2_4__Group_2__0__Impl rule__Child2_4__Group_2__1 ;
    public final void rule__Child2_4__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3792:1: ( rule__Child2_4__Group_2__0__Impl rule__Child2_4__Group_2__1 )
            // InternalBug348427TestLanguage.g:3793:2: rule__Child2_4__Group_2__0__Impl rule__Child2_4__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__Child2_4__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_4__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_4__Group_2__0"


    // $ANTLR start "rule__Child2_4__Group_2__0__Impl"
    // InternalBug348427TestLanguage.g:3800:1: rule__Child2_4__Group_2__0__Impl : ( ( rule__Child2_4__BoolAssignment_2_0 ) ) ;
    public final void rule__Child2_4__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3804:1: ( ( ( rule__Child2_4__BoolAssignment_2_0 ) ) )
            // InternalBug348427TestLanguage.g:3805:1: ( ( rule__Child2_4__BoolAssignment_2_0 ) )
            {
            // InternalBug348427TestLanguage.g:3805:1: ( ( rule__Child2_4__BoolAssignment_2_0 ) )
            // InternalBug348427TestLanguage.g:3806:2: ( rule__Child2_4__BoolAssignment_2_0 )
            {
             before(grammarAccess.getChild2_4Access().getBoolAssignment_2_0()); 
            // InternalBug348427TestLanguage.g:3807:2: ( rule__Child2_4__BoolAssignment_2_0 )
            // InternalBug348427TestLanguage.g:3807:3: rule__Child2_4__BoolAssignment_2_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_4__BoolAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getChild2_4Access().getBoolAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_4__Group_2__0__Impl"


    // $ANTLR start "rule__Child2_4__Group_2__1"
    // InternalBug348427TestLanguage.g:3815:1: rule__Child2_4__Group_2__1 : rule__Child2_4__Group_2__1__Impl ;
    public final void rule__Child2_4__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3819:1: ( rule__Child2_4__Group_2__1__Impl )
            // InternalBug348427TestLanguage.g:3820:2: rule__Child2_4__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_4__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_4__Group_2__1"


    // $ANTLR start "rule__Child2_4__Group_2__1__Impl"
    // InternalBug348427TestLanguage.g:3826:1: rule__Child2_4__Group_2__1__Impl : ( 'keyword' ) ;
    public final void rule__Child2_4__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3830:1: ( ( 'keyword' ) )
            // InternalBug348427TestLanguage.g:3831:1: ( 'keyword' )
            {
            // InternalBug348427TestLanguage.g:3831:1: ( 'keyword' )
            // InternalBug348427TestLanguage.g:3832:2: 'keyword'
            {
             before(grammarAccess.getChild2_4Access().getKeywordKeyword_2_1()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_4Access().getKeywordKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_4__Group_2__1__Impl"


    // $ANTLR start "rule__Child2_5__Group__0"
    // InternalBug348427TestLanguage.g:3842:1: rule__Child2_5__Group__0 : rule__Child2_5__Group__0__Impl rule__Child2_5__Group__1 ;
    public final void rule__Child2_5__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3846:1: ( rule__Child2_5__Group__0__Impl rule__Child2_5__Group__1 )
            // InternalBug348427TestLanguage.g:3847:2: rule__Child2_5__Group__0__Impl rule__Child2_5__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__Child2_5__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_5__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_5__Group__0"


    // $ANTLR start "rule__Child2_5__Group__0__Impl"
    // InternalBug348427TestLanguage.g:3854:1: rule__Child2_5__Group__0__Impl : ( ( rule__Child2_5__NameAssignment_0 ) ) ;
    public final void rule__Child2_5__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3858:1: ( ( ( rule__Child2_5__NameAssignment_0 ) ) )
            // InternalBug348427TestLanguage.g:3859:1: ( ( rule__Child2_5__NameAssignment_0 ) )
            {
            // InternalBug348427TestLanguage.g:3859:1: ( ( rule__Child2_5__NameAssignment_0 ) )
            // InternalBug348427TestLanguage.g:3860:2: ( rule__Child2_5__NameAssignment_0 )
            {
             before(grammarAccess.getChild2_5Access().getNameAssignment_0()); 
            // InternalBug348427TestLanguage.g:3861:2: ( rule__Child2_5__NameAssignment_0 )
            // InternalBug348427TestLanguage.g:3861:3: rule__Child2_5__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_5__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getChild2_5Access().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_5__Group__0__Impl"


    // $ANTLR start "rule__Child2_5__Group__1"
    // InternalBug348427TestLanguage.g:3869:1: rule__Child2_5__Group__1 : rule__Child2_5__Group__1__Impl rule__Child2_5__Group__2 ;
    public final void rule__Child2_5__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3873:1: ( rule__Child2_5__Group__1__Impl rule__Child2_5__Group__2 )
            // InternalBug348427TestLanguage.g:3874:2: rule__Child2_5__Group__1__Impl rule__Child2_5__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Child2_5__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_5__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_5__Group__1"


    // $ANTLR start "rule__Child2_5__Group__1__Impl"
    // InternalBug348427TestLanguage.g:3881:1: rule__Child2_5__Group__1__Impl : ( ':' ) ;
    public final void rule__Child2_5__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3885:1: ( ( ':' ) )
            // InternalBug348427TestLanguage.g:3886:1: ( ':' )
            {
            // InternalBug348427TestLanguage.g:3886:1: ( ':' )
            // InternalBug348427TestLanguage.g:3887:2: ':'
            {
             before(grammarAccess.getChild2_5Access().getColonKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_5Access().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_5__Group__1__Impl"


    // $ANTLR start "rule__Child2_5__Group__2"
    // InternalBug348427TestLanguage.g:3896:1: rule__Child2_5__Group__2 : rule__Child2_5__Group__2__Impl rule__Child2_5__Group__3 ;
    public final void rule__Child2_5__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3900:1: ( rule__Child2_5__Group__2__Impl rule__Child2_5__Group__3 )
            // InternalBug348427TestLanguage.g:3901:2: rule__Child2_5__Group__2__Impl rule__Child2_5__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Child2_5__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_5__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_5__Group__2"


    // $ANTLR start "rule__Child2_5__Group__2__Impl"
    // InternalBug348427TestLanguage.g:3908:1: rule__Child2_5__Group__2__Impl : ( ( rule__Child2_5__Group_2__0 )? ) ;
    public final void rule__Child2_5__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3912:1: ( ( ( rule__Child2_5__Group_2__0 )? ) )
            // InternalBug348427TestLanguage.g:3913:1: ( ( rule__Child2_5__Group_2__0 )? )
            {
            // InternalBug348427TestLanguage.g:3913:1: ( ( rule__Child2_5__Group_2__0 )? )
            // InternalBug348427TestLanguage.g:3914:2: ( rule__Child2_5__Group_2__0 )?
            {
             before(grammarAccess.getChild2_5Access().getGroup_2()); 
            // InternalBug348427TestLanguage.g:3915:2: ( rule__Child2_5__Group_2__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==32) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalBug348427TestLanguage.g:3915:3: rule__Child2_5__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Child2_5__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getChild2_5Access().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_5__Group__2__Impl"


    // $ANTLR start "rule__Child2_5__Group__3"
    // InternalBug348427TestLanguage.g:3923:1: rule__Child2_5__Group__3 : rule__Child2_5__Group__3__Impl rule__Child2_5__Group__4 ;
    public final void rule__Child2_5__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3927:1: ( rule__Child2_5__Group__3__Impl rule__Child2_5__Group__4 )
            // InternalBug348427TestLanguage.g:3928:2: rule__Child2_5__Group__3__Impl rule__Child2_5__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_14);
            rule__Child2_5__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_5__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_5__Group__3"


    // $ANTLR start "rule__Child2_5__Group__3__Impl"
    // InternalBug348427TestLanguage.g:3935:1: rule__Child2_5__Group__3__Impl : ( ( rule__Child2_5__Alternatives_3 ) ) ;
    public final void rule__Child2_5__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3939:1: ( ( ( rule__Child2_5__Alternatives_3 ) ) )
            // InternalBug348427TestLanguage.g:3940:1: ( ( rule__Child2_5__Alternatives_3 ) )
            {
            // InternalBug348427TestLanguage.g:3940:1: ( ( rule__Child2_5__Alternatives_3 ) )
            // InternalBug348427TestLanguage.g:3941:2: ( rule__Child2_5__Alternatives_3 )
            {
             before(grammarAccess.getChild2_5Access().getAlternatives_3()); 
            // InternalBug348427TestLanguage.g:3942:2: ( rule__Child2_5__Alternatives_3 )
            // InternalBug348427TestLanguage.g:3942:3: rule__Child2_5__Alternatives_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_5__Alternatives_3();

            state._fsp--;


            }

             after(grammarAccess.getChild2_5Access().getAlternatives_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_5__Group__3__Impl"


    // $ANTLR start "rule__Child2_5__Group__4"
    // InternalBug348427TestLanguage.g:3950:1: rule__Child2_5__Group__4 : rule__Child2_5__Group__4__Impl rule__Child2_5__Group__5 ;
    public final void rule__Child2_5__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3954:1: ( rule__Child2_5__Group__4__Impl rule__Child2_5__Group__5 )
            // InternalBug348427TestLanguage.g:3955:2: rule__Child2_5__Group__4__Impl rule__Child2_5__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__Child2_5__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_5__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_5__Group__4"


    // $ANTLR start "rule__Child2_5__Group__4__Impl"
    // InternalBug348427TestLanguage.g:3962:1: rule__Child2_5__Group__4__Impl : ( 'child2' ) ;
    public final void rule__Child2_5__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3966:1: ( ( 'child2' ) )
            // InternalBug348427TestLanguage.g:3967:1: ( 'child2' )
            {
            // InternalBug348427TestLanguage.g:3967:1: ( 'child2' )
            // InternalBug348427TestLanguage.g:3968:2: 'child2'
            {
             before(grammarAccess.getChild2_5Access().getChild2Keyword_4()); 
            match(input,22,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_5Access().getChild2Keyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_5__Group__4__Impl"


    // $ANTLR start "rule__Child2_5__Group__5"
    // InternalBug348427TestLanguage.g:3977:1: rule__Child2_5__Group__5 : rule__Child2_5__Group__5__Impl ;
    public final void rule__Child2_5__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3981:1: ( rule__Child2_5__Group__5__Impl )
            // InternalBug348427TestLanguage.g:3982:2: rule__Child2_5__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_5__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_5__Group__5"


    // $ANTLR start "rule__Child2_5__Group__5__Impl"
    // InternalBug348427TestLanguage.g:3988:1: rule__Child2_5__Group__5__Impl : ( 'end' ) ;
    public final void rule__Child2_5__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3992:1: ( ( 'end' ) )
            // InternalBug348427TestLanguage.g:3993:1: ( 'end' )
            {
            // InternalBug348427TestLanguage.g:3993:1: ( 'end' )
            // InternalBug348427TestLanguage.g:3994:2: 'end'
            {
             before(grammarAccess.getChild2_5Access().getEndKeyword_5()); 
            match(input,20,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_5Access().getEndKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_5__Group__5__Impl"


    // $ANTLR start "rule__Child2_5__Group_2__0"
    // InternalBug348427TestLanguage.g:4004:1: rule__Child2_5__Group_2__0 : rule__Child2_5__Group_2__0__Impl rule__Child2_5__Group_2__1 ;
    public final void rule__Child2_5__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4008:1: ( rule__Child2_5__Group_2__0__Impl rule__Child2_5__Group_2__1 )
            // InternalBug348427TestLanguage.g:4009:2: rule__Child2_5__Group_2__0__Impl rule__Child2_5__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__Child2_5__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_5__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_5__Group_2__0"


    // $ANTLR start "rule__Child2_5__Group_2__0__Impl"
    // InternalBug348427TestLanguage.g:4016:1: rule__Child2_5__Group_2__0__Impl : ( ( rule__Child2_5__BoolAssignment_2_0 ) ) ;
    public final void rule__Child2_5__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4020:1: ( ( ( rule__Child2_5__BoolAssignment_2_0 ) ) )
            // InternalBug348427TestLanguage.g:4021:1: ( ( rule__Child2_5__BoolAssignment_2_0 ) )
            {
            // InternalBug348427TestLanguage.g:4021:1: ( ( rule__Child2_5__BoolAssignment_2_0 ) )
            // InternalBug348427TestLanguage.g:4022:2: ( rule__Child2_5__BoolAssignment_2_0 )
            {
             before(grammarAccess.getChild2_5Access().getBoolAssignment_2_0()); 
            // InternalBug348427TestLanguage.g:4023:2: ( rule__Child2_5__BoolAssignment_2_0 )
            // InternalBug348427TestLanguage.g:4023:3: rule__Child2_5__BoolAssignment_2_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_5__BoolAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getChild2_5Access().getBoolAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_5__Group_2__0__Impl"


    // $ANTLR start "rule__Child2_5__Group_2__1"
    // InternalBug348427TestLanguage.g:4031:1: rule__Child2_5__Group_2__1 : rule__Child2_5__Group_2__1__Impl ;
    public final void rule__Child2_5__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4035:1: ( rule__Child2_5__Group_2__1__Impl )
            // InternalBug348427TestLanguage.g:4036:2: rule__Child2_5__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_5__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_5__Group_2__1"


    // $ANTLR start "rule__Child2_5__Group_2__1__Impl"
    // InternalBug348427TestLanguage.g:4042:1: rule__Child2_5__Group_2__1__Impl : ( 'keyword' ) ;
    public final void rule__Child2_5__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4046:1: ( ( 'keyword' ) )
            // InternalBug348427TestLanguage.g:4047:1: ( 'keyword' )
            {
            // InternalBug348427TestLanguage.g:4047:1: ( 'keyword' )
            // InternalBug348427TestLanguage.g:4048:2: 'keyword'
            {
             before(grammarAccess.getChild2_5Access().getKeywordKeyword_2_1()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_5Access().getKeywordKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_5__Group_2__1__Impl"


    // $ANTLR start "rule__Child2_6__Group__0"
    // InternalBug348427TestLanguage.g:4058:1: rule__Child2_6__Group__0 : rule__Child2_6__Group__0__Impl rule__Child2_6__Group__1 ;
    public final void rule__Child2_6__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4062:1: ( rule__Child2_6__Group__0__Impl rule__Child2_6__Group__1 )
            // InternalBug348427TestLanguage.g:4063:2: rule__Child2_6__Group__0__Impl rule__Child2_6__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__Child2_6__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_6__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_6__Group__0"


    // $ANTLR start "rule__Child2_6__Group__0__Impl"
    // InternalBug348427TestLanguage.g:4070:1: rule__Child2_6__Group__0__Impl : ( ( rule__Child2_6__NameAssignment_0 ) ) ;
    public final void rule__Child2_6__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4074:1: ( ( ( rule__Child2_6__NameAssignment_0 ) ) )
            // InternalBug348427TestLanguage.g:4075:1: ( ( rule__Child2_6__NameAssignment_0 ) )
            {
            // InternalBug348427TestLanguage.g:4075:1: ( ( rule__Child2_6__NameAssignment_0 ) )
            // InternalBug348427TestLanguage.g:4076:2: ( rule__Child2_6__NameAssignment_0 )
            {
             before(grammarAccess.getChild2_6Access().getNameAssignment_0()); 
            // InternalBug348427TestLanguage.g:4077:2: ( rule__Child2_6__NameAssignment_0 )
            // InternalBug348427TestLanguage.g:4077:3: rule__Child2_6__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_6__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getChild2_6Access().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_6__Group__0__Impl"


    // $ANTLR start "rule__Child2_6__Group__1"
    // InternalBug348427TestLanguage.g:4085:1: rule__Child2_6__Group__1 : rule__Child2_6__Group__1__Impl rule__Child2_6__Group__2 ;
    public final void rule__Child2_6__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4089:1: ( rule__Child2_6__Group__1__Impl rule__Child2_6__Group__2 )
            // InternalBug348427TestLanguage.g:4090:2: rule__Child2_6__Group__1__Impl rule__Child2_6__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Child2_6__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_6__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_6__Group__1"


    // $ANTLR start "rule__Child2_6__Group__1__Impl"
    // InternalBug348427TestLanguage.g:4097:1: rule__Child2_6__Group__1__Impl : ( ':' ) ;
    public final void rule__Child2_6__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4101:1: ( ( ':' ) )
            // InternalBug348427TestLanguage.g:4102:1: ( ':' )
            {
            // InternalBug348427TestLanguage.g:4102:1: ( ':' )
            // InternalBug348427TestLanguage.g:4103:2: ':'
            {
             before(grammarAccess.getChild2_6Access().getColonKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_6Access().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_6__Group__1__Impl"


    // $ANTLR start "rule__Child2_6__Group__2"
    // InternalBug348427TestLanguage.g:4112:1: rule__Child2_6__Group__2 : rule__Child2_6__Group__2__Impl rule__Child2_6__Group__3 ;
    public final void rule__Child2_6__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4116:1: ( rule__Child2_6__Group__2__Impl rule__Child2_6__Group__3 )
            // InternalBug348427TestLanguage.g:4117:2: rule__Child2_6__Group__2__Impl rule__Child2_6__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Child2_6__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_6__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_6__Group__2"


    // $ANTLR start "rule__Child2_6__Group__2__Impl"
    // InternalBug348427TestLanguage.g:4124:1: rule__Child2_6__Group__2__Impl : ( ( rule__Child2_6__Group_2__0 )? ) ;
    public final void rule__Child2_6__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4128:1: ( ( ( rule__Child2_6__Group_2__0 )? ) )
            // InternalBug348427TestLanguage.g:4129:1: ( ( rule__Child2_6__Group_2__0 )? )
            {
            // InternalBug348427TestLanguage.g:4129:1: ( ( rule__Child2_6__Group_2__0 )? )
            // InternalBug348427TestLanguage.g:4130:2: ( rule__Child2_6__Group_2__0 )?
            {
             before(grammarAccess.getChild2_6Access().getGroup_2()); 
            // InternalBug348427TestLanguage.g:4131:2: ( rule__Child2_6__Group_2__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==32) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalBug348427TestLanguage.g:4131:3: rule__Child2_6__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Child2_6__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getChild2_6Access().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_6__Group__2__Impl"


    // $ANTLR start "rule__Child2_6__Group__3"
    // InternalBug348427TestLanguage.g:4139:1: rule__Child2_6__Group__3 : rule__Child2_6__Group__3__Impl rule__Child2_6__Group__4 ;
    public final void rule__Child2_6__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4143:1: ( rule__Child2_6__Group__3__Impl rule__Child2_6__Group__4 )
            // InternalBug348427TestLanguage.g:4144:2: rule__Child2_6__Group__3__Impl rule__Child2_6__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_15);
            rule__Child2_6__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_6__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_6__Group__3"


    // $ANTLR start "rule__Child2_6__Group__3__Impl"
    // InternalBug348427TestLanguage.g:4151:1: rule__Child2_6__Group__3__Impl : ( ( rule__Child2_6__Alternatives_3 ) ) ;
    public final void rule__Child2_6__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4155:1: ( ( ( rule__Child2_6__Alternatives_3 ) ) )
            // InternalBug348427TestLanguage.g:4156:1: ( ( rule__Child2_6__Alternatives_3 ) )
            {
            // InternalBug348427TestLanguage.g:4156:1: ( ( rule__Child2_6__Alternatives_3 ) )
            // InternalBug348427TestLanguage.g:4157:2: ( rule__Child2_6__Alternatives_3 )
            {
             before(grammarAccess.getChild2_6Access().getAlternatives_3()); 
            // InternalBug348427TestLanguage.g:4158:2: ( rule__Child2_6__Alternatives_3 )
            // InternalBug348427TestLanguage.g:4158:3: rule__Child2_6__Alternatives_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_6__Alternatives_3();

            state._fsp--;


            }

             after(grammarAccess.getChild2_6Access().getAlternatives_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_6__Group__3__Impl"


    // $ANTLR start "rule__Child2_6__Group__4"
    // InternalBug348427TestLanguage.g:4166:1: rule__Child2_6__Group__4 : rule__Child2_6__Group__4__Impl rule__Child2_6__Group__5 ;
    public final void rule__Child2_6__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4170:1: ( rule__Child2_6__Group__4__Impl rule__Child2_6__Group__5 )
            // InternalBug348427TestLanguage.g:4171:2: rule__Child2_6__Group__4__Impl rule__Child2_6__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__Child2_6__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_6__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_6__Group__4"


    // $ANTLR start "rule__Child2_6__Group__4__Impl"
    // InternalBug348427TestLanguage.g:4178:1: rule__Child2_6__Group__4__Impl : ( 'child3' ) ;
    public final void rule__Child2_6__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4182:1: ( ( 'child3' ) )
            // InternalBug348427TestLanguage.g:4183:1: ( 'child3' )
            {
            // InternalBug348427TestLanguage.g:4183:1: ( 'child3' )
            // InternalBug348427TestLanguage.g:4184:2: 'child3'
            {
             before(grammarAccess.getChild2_6Access().getChild3Keyword_4()); 
            match(input,23,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_6Access().getChild3Keyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_6__Group__4__Impl"


    // $ANTLR start "rule__Child2_6__Group__5"
    // InternalBug348427TestLanguage.g:4193:1: rule__Child2_6__Group__5 : rule__Child2_6__Group__5__Impl ;
    public final void rule__Child2_6__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4197:1: ( rule__Child2_6__Group__5__Impl )
            // InternalBug348427TestLanguage.g:4198:2: rule__Child2_6__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_6__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_6__Group__5"


    // $ANTLR start "rule__Child2_6__Group__5__Impl"
    // InternalBug348427TestLanguage.g:4204:1: rule__Child2_6__Group__5__Impl : ( 'end' ) ;
    public final void rule__Child2_6__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4208:1: ( ( 'end' ) )
            // InternalBug348427TestLanguage.g:4209:1: ( 'end' )
            {
            // InternalBug348427TestLanguage.g:4209:1: ( 'end' )
            // InternalBug348427TestLanguage.g:4210:2: 'end'
            {
             before(grammarAccess.getChild2_6Access().getEndKeyword_5()); 
            match(input,20,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_6Access().getEndKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_6__Group__5__Impl"


    // $ANTLR start "rule__Child2_6__Group_2__0"
    // InternalBug348427TestLanguage.g:4220:1: rule__Child2_6__Group_2__0 : rule__Child2_6__Group_2__0__Impl rule__Child2_6__Group_2__1 ;
    public final void rule__Child2_6__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4224:1: ( rule__Child2_6__Group_2__0__Impl rule__Child2_6__Group_2__1 )
            // InternalBug348427TestLanguage.g:4225:2: rule__Child2_6__Group_2__0__Impl rule__Child2_6__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__Child2_6__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_6__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_6__Group_2__0"


    // $ANTLR start "rule__Child2_6__Group_2__0__Impl"
    // InternalBug348427TestLanguage.g:4232:1: rule__Child2_6__Group_2__0__Impl : ( ( rule__Child2_6__BoolAssignment_2_0 ) ) ;
    public final void rule__Child2_6__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4236:1: ( ( ( rule__Child2_6__BoolAssignment_2_0 ) ) )
            // InternalBug348427TestLanguage.g:4237:1: ( ( rule__Child2_6__BoolAssignment_2_0 ) )
            {
            // InternalBug348427TestLanguage.g:4237:1: ( ( rule__Child2_6__BoolAssignment_2_0 ) )
            // InternalBug348427TestLanguage.g:4238:2: ( rule__Child2_6__BoolAssignment_2_0 )
            {
             before(grammarAccess.getChild2_6Access().getBoolAssignment_2_0()); 
            // InternalBug348427TestLanguage.g:4239:2: ( rule__Child2_6__BoolAssignment_2_0 )
            // InternalBug348427TestLanguage.g:4239:3: rule__Child2_6__BoolAssignment_2_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_6__BoolAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getChild2_6Access().getBoolAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_6__Group_2__0__Impl"


    // $ANTLR start "rule__Child2_6__Group_2__1"
    // InternalBug348427TestLanguage.g:4247:1: rule__Child2_6__Group_2__1 : rule__Child2_6__Group_2__1__Impl ;
    public final void rule__Child2_6__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4251:1: ( rule__Child2_6__Group_2__1__Impl )
            // InternalBug348427TestLanguage.g:4252:2: rule__Child2_6__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_6__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_6__Group_2__1"


    // $ANTLR start "rule__Child2_6__Group_2__1__Impl"
    // InternalBug348427TestLanguage.g:4258:1: rule__Child2_6__Group_2__1__Impl : ( 'keyword' ) ;
    public final void rule__Child2_6__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4262:1: ( ( 'keyword' ) )
            // InternalBug348427TestLanguage.g:4263:1: ( 'keyword' )
            {
            // InternalBug348427TestLanguage.g:4263:1: ( 'keyword' )
            // InternalBug348427TestLanguage.g:4264:2: 'keyword'
            {
             before(grammarAccess.getChild2_6Access().getKeywordKeyword_2_1()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_6Access().getKeywordKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_6__Group_2__1__Impl"


    // $ANTLR start "rule__Model__Element1Assignment_0"
    // InternalBug348427TestLanguage.g:4274:1: rule__Model__Element1Assignment_0 : ( ruleScenario1_1 ) ;
    public final void rule__Model__Element1Assignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4278:1: ( ( ruleScenario1_1 ) )
            // InternalBug348427TestLanguage.g:4279:2: ( ruleScenario1_1 )
            {
            // InternalBug348427TestLanguage.g:4279:2: ( ruleScenario1_1 )
            // InternalBug348427TestLanguage.g:4280:3: ruleScenario1_1
            {
             before(grammarAccess.getModelAccess().getElement1Scenario1_1ParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleScenario1_1();

            state._fsp--;

             after(grammarAccess.getModelAccess().getElement1Scenario1_1ParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Element1Assignment_0"


    // $ANTLR start "rule__Model__Element1Assignment_1"
    // InternalBug348427TestLanguage.g:4289:1: rule__Model__Element1Assignment_1 : ( ruleScenario1_2 ) ;
    public final void rule__Model__Element1Assignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4293:1: ( ( ruleScenario1_2 ) )
            // InternalBug348427TestLanguage.g:4294:2: ( ruleScenario1_2 )
            {
            // InternalBug348427TestLanguage.g:4294:2: ( ruleScenario1_2 )
            // InternalBug348427TestLanguage.g:4295:3: ruleScenario1_2
            {
             before(grammarAccess.getModelAccess().getElement1Scenario1_2ParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleScenario1_2();

            state._fsp--;

             after(grammarAccess.getModelAccess().getElement1Scenario1_2ParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Element1Assignment_1"


    // $ANTLR start "rule__Model__Element1Assignment_2"
    // InternalBug348427TestLanguage.g:4304:1: rule__Model__Element1Assignment_2 : ( ruleScenario1_3 ) ;
    public final void rule__Model__Element1Assignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4308:1: ( ( ruleScenario1_3 ) )
            // InternalBug348427TestLanguage.g:4309:2: ( ruleScenario1_3 )
            {
            // InternalBug348427TestLanguage.g:4309:2: ( ruleScenario1_3 )
            // InternalBug348427TestLanguage.g:4310:3: ruleScenario1_3
            {
             before(grammarAccess.getModelAccess().getElement1Scenario1_3ParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleScenario1_3();

            state._fsp--;

             after(grammarAccess.getModelAccess().getElement1Scenario1_3ParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Element1Assignment_2"


    // $ANTLR start "rule__Model__Element1Assignment_3"
    // InternalBug348427TestLanguage.g:4319:1: rule__Model__Element1Assignment_3 : ( ruleScenario1_4 ) ;
    public final void rule__Model__Element1Assignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4323:1: ( ( ruleScenario1_4 ) )
            // InternalBug348427TestLanguage.g:4324:2: ( ruleScenario1_4 )
            {
            // InternalBug348427TestLanguage.g:4324:2: ( ruleScenario1_4 )
            // InternalBug348427TestLanguage.g:4325:3: ruleScenario1_4
            {
             before(grammarAccess.getModelAccess().getElement1Scenario1_4ParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleScenario1_4();

            state._fsp--;

             after(grammarAccess.getModelAccess().getElement1Scenario1_4ParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Element1Assignment_3"


    // $ANTLR start "rule__Model__Element2Assignment_4"
    // InternalBug348427TestLanguage.g:4334:1: rule__Model__Element2Assignment_4 : ( ruleScenario2_1 ) ;
    public final void rule__Model__Element2Assignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4338:1: ( ( ruleScenario2_1 ) )
            // InternalBug348427TestLanguage.g:4339:2: ( ruleScenario2_1 )
            {
            // InternalBug348427TestLanguage.g:4339:2: ( ruleScenario2_1 )
            // InternalBug348427TestLanguage.g:4340:3: ruleScenario2_1
            {
             before(grammarAccess.getModelAccess().getElement2Scenario2_1ParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleScenario2_1();

            state._fsp--;

             after(grammarAccess.getModelAccess().getElement2Scenario2_1ParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Element2Assignment_4"


    // $ANTLR start "rule__Model__Element2Assignment_5"
    // InternalBug348427TestLanguage.g:4349:1: rule__Model__Element2Assignment_5 : ( ruleScenario2_2 ) ;
    public final void rule__Model__Element2Assignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4353:1: ( ( ruleScenario2_2 ) )
            // InternalBug348427TestLanguage.g:4354:2: ( ruleScenario2_2 )
            {
            // InternalBug348427TestLanguage.g:4354:2: ( ruleScenario2_2 )
            // InternalBug348427TestLanguage.g:4355:3: ruleScenario2_2
            {
             before(grammarAccess.getModelAccess().getElement2Scenario2_2ParserRuleCall_5_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleScenario2_2();

            state._fsp--;

             after(grammarAccess.getModelAccess().getElement2Scenario2_2ParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Element2Assignment_5"


    // $ANTLR start "rule__Model__Element2Assignment_6"
    // InternalBug348427TestLanguage.g:4364:1: rule__Model__Element2Assignment_6 : ( ruleScenario2_3 ) ;
    public final void rule__Model__Element2Assignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4368:1: ( ( ruleScenario2_3 ) )
            // InternalBug348427TestLanguage.g:4369:2: ( ruleScenario2_3 )
            {
            // InternalBug348427TestLanguage.g:4369:2: ( ruleScenario2_3 )
            // InternalBug348427TestLanguage.g:4370:3: ruleScenario2_3
            {
             before(grammarAccess.getModelAccess().getElement2Scenario2_3ParserRuleCall_6_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleScenario2_3();

            state._fsp--;

             after(grammarAccess.getModelAccess().getElement2Scenario2_3ParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Element2Assignment_6"


    // $ANTLR start "rule__Model__Element2Assignment_7"
    // InternalBug348427TestLanguage.g:4379:1: rule__Model__Element2Assignment_7 : ( ruleScenario2_4 ) ;
    public final void rule__Model__Element2Assignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4383:1: ( ( ruleScenario2_4 ) )
            // InternalBug348427TestLanguage.g:4384:2: ( ruleScenario2_4 )
            {
            // InternalBug348427TestLanguage.g:4384:2: ( ruleScenario2_4 )
            // InternalBug348427TestLanguage.g:4385:3: ruleScenario2_4
            {
             before(grammarAccess.getModelAccess().getElement2Scenario2_4ParserRuleCall_7_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleScenario2_4();

            state._fsp--;

             after(grammarAccess.getModelAccess().getElement2Scenario2_4ParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Element2Assignment_7"


    // $ANTLR start "rule__Model__Element2Assignment_8"
    // InternalBug348427TestLanguage.g:4394:1: rule__Model__Element2Assignment_8 : ( ruleScenario2_5 ) ;
    public final void rule__Model__Element2Assignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4398:1: ( ( ruleScenario2_5 ) )
            // InternalBug348427TestLanguage.g:4399:2: ( ruleScenario2_5 )
            {
            // InternalBug348427TestLanguage.g:4399:2: ( ruleScenario2_5 )
            // InternalBug348427TestLanguage.g:4400:3: ruleScenario2_5
            {
             before(grammarAccess.getModelAccess().getElement2Scenario2_5ParserRuleCall_8_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleScenario2_5();

            state._fsp--;

             after(grammarAccess.getModelAccess().getElement2Scenario2_5ParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Element2Assignment_8"


    // $ANTLR start "rule__Model__Element2Assignment_9"
    // InternalBug348427TestLanguage.g:4409:1: rule__Model__Element2Assignment_9 : ( ruleScenario2_6 ) ;
    public final void rule__Model__Element2Assignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4413:1: ( ( ruleScenario2_6 ) )
            // InternalBug348427TestLanguage.g:4414:2: ( ruleScenario2_6 )
            {
            // InternalBug348427TestLanguage.g:4414:2: ( ruleScenario2_6 )
            // InternalBug348427TestLanguage.g:4415:3: ruleScenario2_6
            {
             before(grammarAccess.getModelAccess().getElement2Scenario2_6ParserRuleCall_9_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleScenario2_6();

            state._fsp--;

             after(grammarAccess.getModelAccess().getElement2Scenario2_6ParserRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Element2Assignment_9"


    // $ANTLR start "rule__Model__Element2Assignment_10"
    // InternalBug348427TestLanguage.g:4424:1: rule__Model__Element2Assignment_10 : ( ruleScenario2_7 ) ;
    public final void rule__Model__Element2Assignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4428:1: ( ( ruleScenario2_7 ) )
            // InternalBug348427TestLanguage.g:4429:2: ( ruleScenario2_7 )
            {
            // InternalBug348427TestLanguage.g:4429:2: ( ruleScenario2_7 )
            // InternalBug348427TestLanguage.g:4430:3: ruleScenario2_7
            {
             before(grammarAccess.getModelAccess().getElement2Scenario2_7ParserRuleCall_10_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleScenario2_7();

            state._fsp--;

             after(grammarAccess.getModelAccess().getElement2Scenario2_7ParserRuleCall_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Element2Assignment_10"


    // $ANTLR start "rule__Model__Element2Assignment_11"
    // InternalBug348427TestLanguage.g:4439:1: rule__Model__Element2Assignment_11 : ( ruleScenario2_8 ) ;
    public final void rule__Model__Element2Assignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4443:1: ( ( ruleScenario2_8 ) )
            // InternalBug348427TestLanguage.g:4444:2: ( ruleScenario2_8 )
            {
            // InternalBug348427TestLanguage.g:4444:2: ( ruleScenario2_8 )
            // InternalBug348427TestLanguage.g:4445:3: ruleScenario2_8
            {
             before(grammarAccess.getModelAccess().getElement2Scenario2_8ParserRuleCall_11_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleScenario2_8();

            state._fsp--;

             after(grammarAccess.getModelAccess().getElement2Scenario2_8ParserRuleCall_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Element2Assignment_11"


    // $ANTLR start "rule__Scenario1_1__ChildAssignment_1_0"
    // InternalBug348427TestLanguage.g:4454:1: rule__Scenario1_1__ChildAssignment_1_0 : ( ruleChild1_1 ) ;
    public final void rule__Scenario1_1__ChildAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4458:1: ( ( ruleChild1_1 ) )
            // InternalBug348427TestLanguage.g:4459:2: ( ruleChild1_1 )
            {
            // InternalBug348427TestLanguage.g:4459:2: ( ruleChild1_1 )
            // InternalBug348427TestLanguage.g:4460:3: ruleChild1_1
            {
             before(grammarAccess.getScenario1_1Access().getChildChild1_1ParserRuleCall_1_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleChild1_1();

            state._fsp--;

             after(grammarAccess.getScenario1_1Access().getChildChild1_1ParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_1__ChildAssignment_1_0"


    // $ANTLR start "rule__Scenario1_1__ChildAssignment_1_1"
    // InternalBug348427TestLanguage.g:4469:1: rule__Scenario1_1__ChildAssignment_1_1 : ( ruleChild1_2 ) ;
    public final void rule__Scenario1_1__ChildAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4473:1: ( ( ruleChild1_2 ) )
            // InternalBug348427TestLanguage.g:4474:2: ( ruleChild1_2 )
            {
            // InternalBug348427TestLanguage.g:4474:2: ( ruleChild1_2 )
            // InternalBug348427TestLanguage.g:4475:3: ruleChild1_2
            {
             before(grammarAccess.getScenario1_1Access().getChildChild1_2ParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleChild1_2();

            state._fsp--;

             after(grammarAccess.getScenario1_1Access().getChildChild1_2ParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_1__ChildAssignment_1_1"


    // $ANTLR start "rule__Scenario1_1__ChildAssignment_1_2"
    // InternalBug348427TestLanguage.g:4484:1: rule__Scenario1_1__ChildAssignment_1_2 : ( ruleChild1_3 ) ;
    public final void rule__Scenario1_1__ChildAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4488:1: ( ( ruleChild1_3 ) )
            // InternalBug348427TestLanguage.g:4489:2: ( ruleChild1_3 )
            {
            // InternalBug348427TestLanguage.g:4489:2: ( ruleChild1_3 )
            // InternalBug348427TestLanguage.g:4490:3: ruleChild1_3
            {
             before(grammarAccess.getScenario1_1Access().getChildChild1_3ParserRuleCall_1_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleChild1_3();

            state._fsp--;

             after(grammarAccess.getScenario1_1Access().getChildChild1_3ParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_1__ChildAssignment_1_2"


    // $ANTLR start "rule__Scenario1_2__ChildAssignment_1_0"
    // InternalBug348427TestLanguage.g:4499:1: rule__Scenario1_2__ChildAssignment_1_0 : ( ruleChild1_1 ) ;
    public final void rule__Scenario1_2__ChildAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4503:1: ( ( ruleChild1_1 ) )
            // InternalBug348427TestLanguage.g:4504:2: ( ruleChild1_1 )
            {
            // InternalBug348427TestLanguage.g:4504:2: ( ruleChild1_1 )
            // InternalBug348427TestLanguage.g:4505:3: ruleChild1_1
            {
             before(grammarAccess.getScenario1_2Access().getChildChild1_1ParserRuleCall_1_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleChild1_1();

            state._fsp--;

             after(grammarAccess.getScenario1_2Access().getChildChild1_1ParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_2__ChildAssignment_1_0"


    // $ANTLR start "rule__Scenario1_2__ChildAssignment_1_1"
    // InternalBug348427TestLanguage.g:4514:1: rule__Scenario1_2__ChildAssignment_1_1 : ( ruleChild1_2 ) ;
    public final void rule__Scenario1_2__ChildAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4518:1: ( ( ruleChild1_2 ) )
            // InternalBug348427TestLanguage.g:4519:2: ( ruleChild1_2 )
            {
            // InternalBug348427TestLanguage.g:4519:2: ( ruleChild1_2 )
            // InternalBug348427TestLanguage.g:4520:3: ruleChild1_2
            {
             before(grammarAccess.getScenario1_2Access().getChildChild1_2ParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleChild1_2();

            state._fsp--;

             after(grammarAccess.getScenario1_2Access().getChildChild1_2ParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_2__ChildAssignment_1_1"


    // $ANTLR start "rule__Scenario1_2__ChildAssignment_1_2"
    // InternalBug348427TestLanguage.g:4529:1: rule__Scenario1_2__ChildAssignment_1_2 : ( ruleChild1_3 ) ;
    public final void rule__Scenario1_2__ChildAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4533:1: ( ( ruleChild1_3 ) )
            // InternalBug348427TestLanguage.g:4534:2: ( ruleChild1_3 )
            {
            // InternalBug348427TestLanguage.g:4534:2: ( ruleChild1_3 )
            // InternalBug348427TestLanguage.g:4535:3: ruleChild1_3
            {
             before(grammarAccess.getScenario1_2Access().getChildChild1_3ParserRuleCall_1_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleChild1_3();

            state._fsp--;

             after(grammarAccess.getScenario1_2Access().getChildChild1_3ParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_2__ChildAssignment_1_2"


    // $ANTLR start "rule__Scenario1_3__ChildAssignment_2_0"
    // InternalBug348427TestLanguage.g:4544:1: rule__Scenario1_3__ChildAssignment_2_0 : ( ruleChild1_1 ) ;
    public final void rule__Scenario1_3__ChildAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4548:1: ( ( ruleChild1_1 ) )
            // InternalBug348427TestLanguage.g:4549:2: ( ruleChild1_1 )
            {
            // InternalBug348427TestLanguage.g:4549:2: ( ruleChild1_1 )
            // InternalBug348427TestLanguage.g:4550:3: ruleChild1_1
            {
             before(grammarAccess.getScenario1_3Access().getChildChild1_1ParserRuleCall_2_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleChild1_1();

            state._fsp--;

             after(grammarAccess.getScenario1_3Access().getChildChild1_1ParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_3__ChildAssignment_2_0"


    // $ANTLR start "rule__Scenario1_3__ChildAssignment_2_1"
    // InternalBug348427TestLanguage.g:4559:1: rule__Scenario1_3__ChildAssignment_2_1 : ( ruleChild1_2 ) ;
    public final void rule__Scenario1_3__ChildAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4563:1: ( ( ruleChild1_2 ) )
            // InternalBug348427TestLanguage.g:4564:2: ( ruleChild1_2 )
            {
            // InternalBug348427TestLanguage.g:4564:2: ( ruleChild1_2 )
            // InternalBug348427TestLanguage.g:4565:3: ruleChild1_2
            {
             before(grammarAccess.getScenario1_3Access().getChildChild1_2ParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleChild1_2();

            state._fsp--;

             after(grammarAccess.getScenario1_3Access().getChildChild1_2ParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_3__ChildAssignment_2_1"


    // $ANTLR start "rule__Scenario1_3__ChildAssignment_2_2"
    // InternalBug348427TestLanguage.g:4574:1: rule__Scenario1_3__ChildAssignment_2_2 : ( ruleChild1_3 ) ;
    public final void rule__Scenario1_3__ChildAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4578:1: ( ( ruleChild1_3 ) )
            // InternalBug348427TestLanguage.g:4579:2: ( ruleChild1_3 )
            {
            // InternalBug348427TestLanguage.g:4579:2: ( ruleChild1_3 )
            // InternalBug348427TestLanguage.g:4580:3: ruleChild1_3
            {
             before(grammarAccess.getScenario1_3Access().getChildChild1_3ParserRuleCall_2_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleChild1_3();

            state._fsp--;

             after(grammarAccess.getScenario1_3Access().getChildChild1_3ParserRuleCall_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_3__ChildAssignment_2_2"


    // $ANTLR start "rule__Scenario1_4__ChildAssignment_2_0"
    // InternalBug348427TestLanguage.g:4589:1: rule__Scenario1_4__ChildAssignment_2_0 : ( ruleChild1_1 ) ;
    public final void rule__Scenario1_4__ChildAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4593:1: ( ( ruleChild1_1 ) )
            // InternalBug348427TestLanguage.g:4594:2: ( ruleChild1_1 )
            {
            // InternalBug348427TestLanguage.g:4594:2: ( ruleChild1_1 )
            // InternalBug348427TestLanguage.g:4595:3: ruleChild1_1
            {
             before(grammarAccess.getScenario1_4Access().getChildChild1_1ParserRuleCall_2_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleChild1_1();

            state._fsp--;

             after(grammarAccess.getScenario1_4Access().getChildChild1_1ParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_4__ChildAssignment_2_0"


    // $ANTLR start "rule__Scenario1_4__ChildAssignment_2_1"
    // InternalBug348427TestLanguage.g:4604:1: rule__Scenario1_4__ChildAssignment_2_1 : ( ruleChild1_2 ) ;
    public final void rule__Scenario1_4__ChildAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4608:1: ( ( ruleChild1_2 ) )
            // InternalBug348427TestLanguage.g:4609:2: ( ruleChild1_2 )
            {
            // InternalBug348427TestLanguage.g:4609:2: ( ruleChild1_2 )
            // InternalBug348427TestLanguage.g:4610:3: ruleChild1_2
            {
             before(grammarAccess.getScenario1_4Access().getChildChild1_2ParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleChild1_2();

            state._fsp--;

             after(grammarAccess.getScenario1_4Access().getChildChild1_2ParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_4__ChildAssignment_2_1"


    // $ANTLR start "rule__Scenario1_4__ChildAssignment_2_2"
    // InternalBug348427TestLanguage.g:4619:1: rule__Scenario1_4__ChildAssignment_2_2 : ( ruleChild1_3 ) ;
    public final void rule__Scenario1_4__ChildAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4623:1: ( ( ruleChild1_3 ) )
            // InternalBug348427TestLanguage.g:4624:2: ( ruleChild1_3 )
            {
            // InternalBug348427TestLanguage.g:4624:2: ( ruleChild1_3 )
            // InternalBug348427TestLanguage.g:4625:3: ruleChild1_3
            {
             before(grammarAccess.getScenario1_4Access().getChildChild1_3ParserRuleCall_2_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleChild1_3();

            state._fsp--;

             after(grammarAccess.getScenario1_4Access().getChildChild1_3ParserRuleCall_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario1_4__ChildAssignment_2_2"


    // $ANTLR start "rule__Child1_1__NameAssignment_0"
    // InternalBug348427TestLanguage.g:4634:1: rule__Child1_1__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Child1_1__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4638:1: ( ( RULE_ID ) )
            // InternalBug348427TestLanguage.g:4639:2: ( RULE_ID )
            {
            // InternalBug348427TestLanguage.g:4639:2: ( RULE_ID )
            // InternalBug348427TestLanguage.g:4640:3: RULE_ID
            {
             before(grammarAccess.getChild1_1Access().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild1_1Access().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_1__NameAssignment_0"


    // $ANTLR start "rule__Child1_1__BoolAssignment_2_0"
    // InternalBug348427TestLanguage.g:4649:1: rule__Child1_1__BoolAssignment_2_0 : ( ( 'bool' ) ) ;
    public final void rule__Child1_1__BoolAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4653:1: ( ( ( 'bool' ) ) )
            // InternalBug348427TestLanguage.g:4654:2: ( ( 'bool' ) )
            {
            // InternalBug348427TestLanguage.g:4654:2: ( ( 'bool' ) )
            // InternalBug348427TestLanguage.g:4655:3: ( 'bool' )
            {
             before(grammarAccess.getChild1_1Access().getBoolBoolKeyword_2_0_0()); 
            // InternalBug348427TestLanguage.g:4656:3: ( 'bool' )
            // InternalBug348427TestLanguage.g:4657:4: 'bool'
            {
             before(grammarAccess.getChild1_1Access().getBoolBoolKeyword_2_0_0()); 
            match(input,32,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild1_1Access().getBoolBoolKeyword_2_0_0()); 

            }

             after(grammarAccess.getChild1_1Access().getBoolBoolKeyword_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_1__BoolAssignment_2_0"


    // $ANTLR start "rule__Child1_1__EnumTypeAssignment_3"
    // InternalBug348427TestLanguage.g:4668:1: rule__Child1_1__EnumTypeAssignment_3 : ( ruleEnumType ) ;
    public final void rule__Child1_1__EnumTypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4672:1: ( ( ruleEnumType ) )
            // InternalBug348427TestLanguage.g:4673:2: ( ruleEnumType )
            {
            // InternalBug348427TestLanguage.g:4673:2: ( ruleEnumType )
            // InternalBug348427TestLanguage.g:4674:3: ruleEnumType
            {
             before(grammarAccess.getChild1_1Access().getEnumTypeEnumTypeEnumRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleEnumType();

            state._fsp--;

             after(grammarAccess.getChild1_1Access().getEnumTypeEnumTypeEnumRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_1__EnumTypeAssignment_3"


    // $ANTLR start "rule__Child1_2__NameAssignment_0"
    // InternalBug348427TestLanguage.g:4683:1: rule__Child1_2__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Child1_2__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4687:1: ( ( RULE_ID ) )
            // InternalBug348427TestLanguage.g:4688:2: ( RULE_ID )
            {
            // InternalBug348427TestLanguage.g:4688:2: ( RULE_ID )
            // InternalBug348427TestLanguage.g:4689:3: RULE_ID
            {
             before(grammarAccess.getChild1_2Access().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild1_2Access().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_2__NameAssignment_0"


    // $ANTLR start "rule__Child1_2__BoolAssignment_2_0"
    // InternalBug348427TestLanguage.g:4698:1: rule__Child1_2__BoolAssignment_2_0 : ( ( 'bool' ) ) ;
    public final void rule__Child1_2__BoolAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4702:1: ( ( ( 'bool' ) ) )
            // InternalBug348427TestLanguage.g:4703:2: ( ( 'bool' ) )
            {
            // InternalBug348427TestLanguage.g:4703:2: ( ( 'bool' ) )
            // InternalBug348427TestLanguage.g:4704:3: ( 'bool' )
            {
             before(grammarAccess.getChild1_2Access().getBoolBoolKeyword_2_0_0()); 
            // InternalBug348427TestLanguage.g:4705:3: ( 'bool' )
            // InternalBug348427TestLanguage.g:4706:4: 'bool'
            {
             before(grammarAccess.getChild1_2Access().getBoolBoolKeyword_2_0_0()); 
            match(input,32,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild1_2Access().getBoolBoolKeyword_2_0_0()); 

            }

             after(grammarAccess.getChild1_2Access().getBoolBoolKeyword_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_2__BoolAssignment_2_0"


    // $ANTLR start "rule__Child1_2__EnumTypeAssignment_3"
    // InternalBug348427TestLanguage.g:4717:1: rule__Child1_2__EnumTypeAssignment_3 : ( ruleEnumType ) ;
    public final void rule__Child1_2__EnumTypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4721:1: ( ( ruleEnumType ) )
            // InternalBug348427TestLanguage.g:4722:2: ( ruleEnumType )
            {
            // InternalBug348427TestLanguage.g:4722:2: ( ruleEnumType )
            // InternalBug348427TestLanguage.g:4723:3: ruleEnumType
            {
             before(grammarAccess.getChild1_2Access().getEnumTypeEnumTypeEnumRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleEnumType();

            state._fsp--;

             after(grammarAccess.getChild1_2Access().getEnumTypeEnumTypeEnumRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_2__EnumTypeAssignment_3"


    // $ANTLR start "rule__Child1_3__NameAssignment_0"
    // InternalBug348427TestLanguage.g:4732:1: rule__Child1_3__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Child1_3__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4736:1: ( ( RULE_ID ) )
            // InternalBug348427TestLanguage.g:4737:2: ( RULE_ID )
            {
            // InternalBug348427TestLanguage.g:4737:2: ( RULE_ID )
            // InternalBug348427TestLanguage.g:4738:3: RULE_ID
            {
             before(grammarAccess.getChild1_3Access().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild1_3Access().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_3__NameAssignment_0"


    // $ANTLR start "rule__Child1_3__BoolAssignment_2_0"
    // InternalBug348427TestLanguage.g:4747:1: rule__Child1_3__BoolAssignment_2_0 : ( ( 'bool' ) ) ;
    public final void rule__Child1_3__BoolAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4751:1: ( ( ( 'bool' ) ) )
            // InternalBug348427TestLanguage.g:4752:2: ( ( 'bool' ) )
            {
            // InternalBug348427TestLanguage.g:4752:2: ( ( 'bool' ) )
            // InternalBug348427TestLanguage.g:4753:3: ( 'bool' )
            {
             before(grammarAccess.getChild1_3Access().getBoolBoolKeyword_2_0_0()); 
            // InternalBug348427TestLanguage.g:4754:3: ( 'bool' )
            // InternalBug348427TestLanguage.g:4755:4: 'bool'
            {
             before(grammarAccess.getChild1_3Access().getBoolBoolKeyword_2_0_0()); 
            match(input,32,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild1_3Access().getBoolBoolKeyword_2_0_0()); 

            }

             after(grammarAccess.getChild1_3Access().getBoolBoolKeyword_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_3__BoolAssignment_2_0"


    // $ANTLR start "rule__Child1_3__EnumTypeAssignment_3"
    // InternalBug348427TestLanguage.g:4766:1: rule__Child1_3__EnumTypeAssignment_3 : ( ruleEnumType ) ;
    public final void rule__Child1_3__EnumTypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4770:1: ( ( ruleEnumType ) )
            // InternalBug348427TestLanguage.g:4771:2: ( ruleEnumType )
            {
            // InternalBug348427TestLanguage.g:4771:2: ( ruleEnumType )
            // InternalBug348427TestLanguage.g:4772:3: ruleEnumType
            {
             before(grammarAccess.getChild1_3Access().getEnumTypeEnumTypeEnumRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleEnumType();

            state._fsp--;

             after(grammarAccess.getChild1_3Access().getEnumTypeEnumTypeEnumRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child1_3__EnumTypeAssignment_3"


    // $ANTLR start "rule__Scenario2_1__ChildAssignment_1_0"
    // InternalBug348427TestLanguage.g:4781:1: rule__Scenario2_1__ChildAssignment_1_0 : ( ruleChild2_1 ) ;
    public final void rule__Scenario2_1__ChildAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4785:1: ( ( ruleChild2_1 ) )
            // InternalBug348427TestLanguage.g:4786:2: ( ruleChild2_1 )
            {
            // InternalBug348427TestLanguage.g:4786:2: ( ruleChild2_1 )
            // InternalBug348427TestLanguage.g:4787:3: ruleChild2_1
            {
             before(grammarAccess.getScenario2_1Access().getChildChild2_1ParserRuleCall_1_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleChild2_1();

            state._fsp--;

             after(grammarAccess.getScenario2_1Access().getChildChild2_1ParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_1__ChildAssignment_1_0"


    // $ANTLR start "rule__Scenario2_1__ChildAssignment_1_1"
    // InternalBug348427TestLanguage.g:4796:1: rule__Scenario2_1__ChildAssignment_1_1 : ( ruleChild2_2 ) ;
    public final void rule__Scenario2_1__ChildAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4800:1: ( ( ruleChild2_2 ) )
            // InternalBug348427TestLanguage.g:4801:2: ( ruleChild2_2 )
            {
            // InternalBug348427TestLanguage.g:4801:2: ( ruleChild2_2 )
            // InternalBug348427TestLanguage.g:4802:3: ruleChild2_2
            {
             before(grammarAccess.getScenario2_1Access().getChildChild2_2ParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleChild2_2();

            state._fsp--;

             after(grammarAccess.getScenario2_1Access().getChildChild2_2ParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_1__ChildAssignment_1_1"


    // $ANTLR start "rule__Scenario2_1__ChildAssignment_1_2"
    // InternalBug348427TestLanguage.g:4811:1: rule__Scenario2_1__ChildAssignment_1_2 : ( ruleChild2_3 ) ;
    public final void rule__Scenario2_1__ChildAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4815:1: ( ( ruleChild2_3 ) )
            // InternalBug348427TestLanguage.g:4816:2: ( ruleChild2_3 )
            {
            // InternalBug348427TestLanguage.g:4816:2: ( ruleChild2_3 )
            // InternalBug348427TestLanguage.g:4817:3: ruleChild2_3
            {
             before(grammarAccess.getScenario2_1Access().getChildChild2_3ParserRuleCall_1_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleChild2_3();

            state._fsp--;

             after(grammarAccess.getScenario2_1Access().getChildChild2_3ParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_1__ChildAssignment_1_2"


    // $ANTLR start "rule__Scenario2_2__ChildAssignment_1_0"
    // InternalBug348427TestLanguage.g:4826:1: rule__Scenario2_2__ChildAssignment_1_0 : ( ruleChild2_1 ) ;
    public final void rule__Scenario2_2__ChildAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4830:1: ( ( ruleChild2_1 ) )
            // InternalBug348427TestLanguage.g:4831:2: ( ruleChild2_1 )
            {
            // InternalBug348427TestLanguage.g:4831:2: ( ruleChild2_1 )
            // InternalBug348427TestLanguage.g:4832:3: ruleChild2_1
            {
             before(grammarAccess.getScenario2_2Access().getChildChild2_1ParserRuleCall_1_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleChild2_1();

            state._fsp--;

             after(grammarAccess.getScenario2_2Access().getChildChild2_1ParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_2__ChildAssignment_1_0"


    // $ANTLR start "rule__Scenario2_2__ChildAssignment_1_1"
    // InternalBug348427TestLanguage.g:4841:1: rule__Scenario2_2__ChildAssignment_1_1 : ( ruleChild2_2 ) ;
    public final void rule__Scenario2_2__ChildAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4845:1: ( ( ruleChild2_2 ) )
            // InternalBug348427TestLanguage.g:4846:2: ( ruleChild2_2 )
            {
            // InternalBug348427TestLanguage.g:4846:2: ( ruleChild2_2 )
            // InternalBug348427TestLanguage.g:4847:3: ruleChild2_2
            {
             before(grammarAccess.getScenario2_2Access().getChildChild2_2ParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleChild2_2();

            state._fsp--;

             after(grammarAccess.getScenario2_2Access().getChildChild2_2ParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_2__ChildAssignment_1_1"


    // $ANTLR start "rule__Scenario2_2__ChildAssignment_1_2"
    // InternalBug348427TestLanguage.g:4856:1: rule__Scenario2_2__ChildAssignment_1_2 : ( ruleChild2_3 ) ;
    public final void rule__Scenario2_2__ChildAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4860:1: ( ( ruleChild2_3 ) )
            // InternalBug348427TestLanguage.g:4861:2: ( ruleChild2_3 )
            {
            // InternalBug348427TestLanguage.g:4861:2: ( ruleChild2_3 )
            // InternalBug348427TestLanguage.g:4862:3: ruleChild2_3
            {
             before(grammarAccess.getScenario2_2Access().getChildChild2_3ParserRuleCall_1_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleChild2_3();

            state._fsp--;

             after(grammarAccess.getScenario2_2Access().getChildChild2_3ParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_2__ChildAssignment_1_2"


    // $ANTLR start "rule__Scenario2_3__ChildAssignment_1_0"
    // InternalBug348427TestLanguage.g:4871:1: rule__Scenario2_3__ChildAssignment_1_0 : ( ruleChild2_4 ) ;
    public final void rule__Scenario2_3__ChildAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4875:1: ( ( ruleChild2_4 ) )
            // InternalBug348427TestLanguage.g:4876:2: ( ruleChild2_4 )
            {
            // InternalBug348427TestLanguage.g:4876:2: ( ruleChild2_4 )
            // InternalBug348427TestLanguage.g:4877:3: ruleChild2_4
            {
             before(grammarAccess.getScenario2_3Access().getChildChild2_4ParserRuleCall_1_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleChild2_4();

            state._fsp--;

             after(grammarAccess.getScenario2_3Access().getChildChild2_4ParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_3__ChildAssignment_1_0"


    // $ANTLR start "rule__Scenario2_3__ChildAssignment_1_1"
    // InternalBug348427TestLanguage.g:4886:1: rule__Scenario2_3__ChildAssignment_1_1 : ( ruleChild2_5 ) ;
    public final void rule__Scenario2_3__ChildAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4890:1: ( ( ruleChild2_5 ) )
            // InternalBug348427TestLanguage.g:4891:2: ( ruleChild2_5 )
            {
            // InternalBug348427TestLanguage.g:4891:2: ( ruleChild2_5 )
            // InternalBug348427TestLanguage.g:4892:3: ruleChild2_5
            {
             before(grammarAccess.getScenario2_3Access().getChildChild2_5ParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleChild2_5();

            state._fsp--;

             after(grammarAccess.getScenario2_3Access().getChildChild2_5ParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_3__ChildAssignment_1_1"


    // $ANTLR start "rule__Scenario2_3__ChildAssignment_1_2"
    // InternalBug348427TestLanguage.g:4901:1: rule__Scenario2_3__ChildAssignment_1_2 : ( ruleChild2_6 ) ;
    public final void rule__Scenario2_3__ChildAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4905:1: ( ( ruleChild2_6 ) )
            // InternalBug348427TestLanguage.g:4906:2: ( ruleChild2_6 )
            {
            // InternalBug348427TestLanguage.g:4906:2: ( ruleChild2_6 )
            // InternalBug348427TestLanguage.g:4907:3: ruleChild2_6
            {
             before(grammarAccess.getScenario2_3Access().getChildChild2_6ParserRuleCall_1_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleChild2_6();

            state._fsp--;

             after(grammarAccess.getScenario2_3Access().getChildChild2_6ParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_3__ChildAssignment_1_2"


    // $ANTLR start "rule__Scenario2_4__ChildAssignment_1_0"
    // InternalBug348427TestLanguage.g:4916:1: rule__Scenario2_4__ChildAssignment_1_0 : ( ruleChild2_4 ) ;
    public final void rule__Scenario2_4__ChildAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4920:1: ( ( ruleChild2_4 ) )
            // InternalBug348427TestLanguage.g:4921:2: ( ruleChild2_4 )
            {
            // InternalBug348427TestLanguage.g:4921:2: ( ruleChild2_4 )
            // InternalBug348427TestLanguage.g:4922:3: ruleChild2_4
            {
             before(grammarAccess.getScenario2_4Access().getChildChild2_4ParserRuleCall_1_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleChild2_4();

            state._fsp--;

             after(grammarAccess.getScenario2_4Access().getChildChild2_4ParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_4__ChildAssignment_1_0"


    // $ANTLR start "rule__Scenario2_4__ChildAssignment_1_1"
    // InternalBug348427TestLanguage.g:4931:1: rule__Scenario2_4__ChildAssignment_1_1 : ( ruleChild2_5 ) ;
    public final void rule__Scenario2_4__ChildAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4935:1: ( ( ruleChild2_5 ) )
            // InternalBug348427TestLanguage.g:4936:2: ( ruleChild2_5 )
            {
            // InternalBug348427TestLanguage.g:4936:2: ( ruleChild2_5 )
            // InternalBug348427TestLanguage.g:4937:3: ruleChild2_5
            {
             before(grammarAccess.getScenario2_4Access().getChildChild2_5ParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleChild2_5();

            state._fsp--;

             after(grammarAccess.getScenario2_4Access().getChildChild2_5ParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_4__ChildAssignment_1_1"


    // $ANTLR start "rule__Scenario2_4__ChildAssignment_1_2"
    // InternalBug348427TestLanguage.g:4946:1: rule__Scenario2_4__ChildAssignment_1_2 : ( ruleChild2_6 ) ;
    public final void rule__Scenario2_4__ChildAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4950:1: ( ( ruleChild2_6 ) )
            // InternalBug348427TestLanguage.g:4951:2: ( ruleChild2_6 )
            {
            // InternalBug348427TestLanguage.g:4951:2: ( ruleChild2_6 )
            // InternalBug348427TestLanguage.g:4952:3: ruleChild2_6
            {
             before(grammarAccess.getScenario2_4Access().getChildChild2_6ParserRuleCall_1_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleChild2_6();

            state._fsp--;

             after(grammarAccess.getScenario2_4Access().getChildChild2_6ParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_4__ChildAssignment_1_2"


    // $ANTLR start "rule__Scenario2_5__ChildAssignment_2_0"
    // InternalBug348427TestLanguage.g:4961:1: rule__Scenario2_5__ChildAssignment_2_0 : ( ruleChild2_1 ) ;
    public final void rule__Scenario2_5__ChildAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4965:1: ( ( ruleChild2_1 ) )
            // InternalBug348427TestLanguage.g:4966:2: ( ruleChild2_1 )
            {
            // InternalBug348427TestLanguage.g:4966:2: ( ruleChild2_1 )
            // InternalBug348427TestLanguage.g:4967:3: ruleChild2_1
            {
             before(grammarAccess.getScenario2_5Access().getChildChild2_1ParserRuleCall_2_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleChild2_1();

            state._fsp--;

             after(grammarAccess.getScenario2_5Access().getChildChild2_1ParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_5__ChildAssignment_2_0"


    // $ANTLR start "rule__Scenario2_5__ChildAssignment_2_1"
    // InternalBug348427TestLanguage.g:4976:1: rule__Scenario2_5__ChildAssignment_2_1 : ( ruleChild2_2 ) ;
    public final void rule__Scenario2_5__ChildAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4980:1: ( ( ruleChild2_2 ) )
            // InternalBug348427TestLanguage.g:4981:2: ( ruleChild2_2 )
            {
            // InternalBug348427TestLanguage.g:4981:2: ( ruleChild2_2 )
            // InternalBug348427TestLanguage.g:4982:3: ruleChild2_2
            {
             before(grammarAccess.getScenario2_5Access().getChildChild2_2ParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleChild2_2();

            state._fsp--;

             after(grammarAccess.getScenario2_5Access().getChildChild2_2ParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_5__ChildAssignment_2_1"


    // $ANTLR start "rule__Scenario2_5__ChildAssignment_2_2"
    // InternalBug348427TestLanguage.g:4991:1: rule__Scenario2_5__ChildAssignment_2_2 : ( ruleChild2_3 ) ;
    public final void rule__Scenario2_5__ChildAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4995:1: ( ( ruleChild2_3 ) )
            // InternalBug348427TestLanguage.g:4996:2: ( ruleChild2_3 )
            {
            // InternalBug348427TestLanguage.g:4996:2: ( ruleChild2_3 )
            // InternalBug348427TestLanguage.g:4997:3: ruleChild2_3
            {
             before(grammarAccess.getScenario2_5Access().getChildChild2_3ParserRuleCall_2_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleChild2_3();

            state._fsp--;

             after(grammarAccess.getScenario2_5Access().getChildChild2_3ParserRuleCall_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_5__ChildAssignment_2_2"


    // $ANTLR start "rule__Scenario2_6__ChildAssignment_2_0"
    // InternalBug348427TestLanguage.g:5006:1: rule__Scenario2_6__ChildAssignment_2_0 : ( ruleChild2_1 ) ;
    public final void rule__Scenario2_6__ChildAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5010:1: ( ( ruleChild2_1 ) )
            // InternalBug348427TestLanguage.g:5011:2: ( ruleChild2_1 )
            {
            // InternalBug348427TestLanguage.g:5011:2: ( ruleChild2_1 )
            // InternalBug348427TestLanguage.g:5012:3: ruleChild2_1
            {
             before(grammarAccess.getScenario2_6Access().getChildChild2_1ParserRuleCall_2_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleChild2_1();

            state._fsp--;

             after(grammarAccess.getScenario2_6Access().getChildChild2_1ParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_6__ChildAssignment_2_0"


    // $ANTLR start "rule__Scenario2_6__ChildAssignment_2_1"
    // InternalBug348427TestLanguage.g:5021:1: rule__Scenario2_6__ChildAssignment_2_1 : ( ruleChild2_2 ) ;
    public final void rule__Scenario2_6__ChildAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5025:1: ( ( ruleChild2_2 ) )
            // InternalBug348427TestLanguage.g:5026:2: ( ruleChild2_2 )
            {
            // InternalBug348427TestLanguage.g:5026:2: ( ruleChild2_2 )
            // InternalBug348427TestLanguage.g:5027:3: ruleChild2_2
            {
             before(grammarAccess.getScenario2_6Access().getChildChild2_2ParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleChild2_2();

            state._fsp--;

             after(grammarAccess.getScenario2_6Access().getChildChild2_2ParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_6__ChildAssignment_2_1"


    // $ANTLR start "rule__Scenario2_6__ChildAssignment_2_2"
    // InternalBug348427TestLanguage.g:5036:1: rule__Scenario2_6__ChildAssignment_2_2 : ( ruleChild2_3 ) ;
    public final void rule__Scenario2_6__ChildAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5040:1: ( ( ruleChild2_3 ) )
            // InternalBug348427TestLanguage.g:5041:2: ( ruleChild2_3 )
            {
            // InternalBug348427TestLanguage.g:5041:2: ( ruleChild2_3 )
            // InternalBug348427TestLanguage.g:5042:3: ruleChild2_3
            {
             before(grammarAccess.getScenario2_6Access().getChildChild2_3ParserRuleCall_2_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleChild2_3();

            state._fsp--;

             after(grammarAccess.getScenario2_6Access().getChildChild2_3ParserRuleCall_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_6__ChildAssignment_2_2"


    // $ANTLR start "rule__Scenario2_7__ChildAssignment_2_0"
    // InternalBug348427TestLanguage.g:5051:1: rule__Scenario2_7__ChildAssignment_2_0 : ( ruleChild2_4 ) ;
    public final void rule__Scenario2_7__ChildAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5055:1: ( ( ruleChild2_4 ) )
            // InternalBug348427TestLanguage.g:5056:2: ( ruleChild2_4 )
            {
            // InternalBug348427TestLanguage.g:5056:2: ( ruleChild2_4 )
            // InternalBug348427TestLanguage.g:5057:3: ruleChild2_4
            {
             before(grammarAccess.getScenario2_7Access().getChildChild2_4ParserRuleCall_2_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleChild2_4();

            state._fsp--;

             after(grammarAccess.getScenario2_7Access().getChildChild2_4ParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_7__ChildAssignment_2_0"


    // $ANTLR start "rule__Scenario2_7__ChildAssignment_2_1"
    // InternalBug348427TestLanguage.g:5066:1: rule__Scenario2_7__ChildAssignment_2_1 : ( ruleChild2_5 ) ;
    public final void rule__Scenario2_7__ChildAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5070:1: ( ( ruleChild2_5 ) )
            // InternalBug348427TestLanguage.g:5071:2: ( ruleChild2_5 )
            {
            // InternalBug348427TestLanguage.g:5071:2: ( ruleChild2_5 )
            // InternalBug348427TestLanguage.g:5072:3: ruleChild2_5
            {
             before(grammarAccess.getScenario2_7Access().getChildChild2_5ParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleChild2_5();

            state._fsp--;

             after(grammarAccess.getScenario2_7Access().getChildChild2_5ParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_7__ChildAssignment_2_1"


    // $ANTLR start "rule__Scenario2_7__ChildAssignment_2_2"
    // InternalBug348427TestLanguage.g:5081:1: rule__Scenario2_7__ChildAssignment_2_2 : ( ruleChild2_6 ) ;
    public final void rule__Scenario2_7__ChildAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5085:1: ( ( ruleChild2_6 ) )
            // InternalBug348427TestLanguage.g:5086:2: ( ruleChild2_6 )
            {
            // InternalBug348427TestLanguage.g:5086:2: ( ruleChild2_6 )
            // InternalBug348427TestLanguage.g:5087:3: ruleChild2_6
            {
             before(grammarAccess.getScenario2_7Access().getChildChild2_6ParserRuleCall_2_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleChild2_6();

            state._fsp--;

             after(grammarAccess.getScenario2_7Access().getChildChild2_6ParserRuleCall_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_7__ChildAssignment_2_2"


    // $ANTLR start "rule__Scenario2_8__ChildAssignment_2_0"
    // InternalBug348427TestLanguage.g:5096:1: rule__Scenario2_8__ChildAssignment_2_0 : ( ruleChild2_4 ) ;
    public final void rule__Scenario2_8__ChildAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5100:1: ( ( ruleChild2_4 ) )
            // InternalBug348427TestLanguage.g:5101:2: ( ruleChild2_4 )
            {
            // InternalBug348427TestLanguage.g:5101:2: ( ruleChild2_4 )
            // InternalBug348427TestLanguage.g:5102:3: ruleChild2_4
            {
             before(grammarAccess.getScenario2_8Access().getChildChild2_4ParserRuleCall_2_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleChild2_4();

            state._fsp--;

             after(grammarAccess.getScenario2_8Access().getChildChild2_4ParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_8__ChildAssignment_2_0"


    // $ANTLR start "rule__Scenario2_8__ChildAssignment_2_1"
    // InternalBug348427TestLanguage.g:5111:1: rule__Scenario2_8__ChildAssignment_2_1 : ( ruleChild2_5 ) ;
    public final void rule__Scenario2_8__ChildAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5115:1: ( ( ruleChild2_5 ) )
            // InternalBug348427TestLanguage.g:5116:2: ( ruleChild2_5 )
            {
            // InternalBug348427TestLanguage.g:5116:2: ( ruleChild2_5 )
            // InternalBug348427TestLanguage.g:5117:3: ruleChild2_5
            {
             before(grammarAccess.getScenario2_8Access().getChildChild2_5ParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleChild2_5();

            state._fsp--;

             after(grammarAccess.getScenario2_8Access().getChildChild2_5ParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_8__ChildAssignment_2_1"


    // $ANTLR start "rule__Scenario2_8__ChildAssignment_2_2"
    // InternalBug348427TestLanguage.g:5126:1: rule__Scenario2_8__ChildAssignment_2_2 : ( ruleChild2_6 ) ;
    public final void rule__Scenario2_8__ChildAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5130:1: ( ( ruleChild2_6 ) )
            // InternalBug348427TestLanguage.g:5131:2: ( ruleChild2_6 )
            {
            // InternalBug348427TestLanguage.g:5131:2: ( ruleChild2_6 )
            // InternalBug348427TestLanguage.g:5132:3: ruleChild2_6
            {
             before(grammarAccess.getScenario2_8Access().getChildChild2_6ParserRuleCall_2_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleChild2_6();

            state._fsp--;

             after(grammarAccess.getScenario2_8Access().getChildChild2_6ParserRuleCall_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario2_8__ChildAssignment_2_2"


    // $ANTLR start "rule__Child2_1__NameAssignment_0"
    // InternalBug348427TestLanguage.g:5141:1: rule__Child2_1__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Child2_1__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5145:1: ( ( RULE_ID ) )
            // InternalBug348427TestLanguage.g:5146:2: ( RULE_ID )
            {
            // InternalBug348427TestLanguage.g:5146:2: ( RULE_ID )
            // InternalBug348427TestLanguage.g:5147:3: RULE_ID
            {
             before(grammarAccess.getChild2_1Access().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_1Access().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_1__NameAssignment_0"


    // $ANTLR start "rule__Child2_1__BoolAssignment_2_0"
    // InternalBug348427TestLanguage.g:5156:1: rule__Child2_1__BoolAssignment_2_0 : ( ( 'bool' ) ) ;
    public final void rule__Child2_1__BoolAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5160:1: ( ( ( 'bool' ) ) )
            // InternalBug348427TestLanguage.g:5161:2: ( ( 'bool' ) )
            {
            // InternalBug348427TestLanguage.g:5161:2: ( ( 'bool' ) )
            // InternalBug348427TestLanguage.g:5162:3: ( 'bool' )
            {
             before(grammarAccess.getChild2_1Access().getBoolBoolKeyword_2_0_0()); 
            // InternalBug348427TestLanguage.g:5163:3: ( 'bool' )
            // InternalBug348427TestLanguage.g:5164:4: 'bool'
            {
             before(grammarAccess.getChild2_1Access().getBoolBoolKeyword_2_0_0()); 
            match(input,32,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_1Access().getBoolBoolKeyword_2_0_0()); 

            }

             after(grammarAccess.getChild2_1Access().getBoolBoolKeyword_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_1__BoolAssignment_2_0"


    // $ANTLR start "rule__Child2_1__StringAssignment_3"
    // InternalBug348427TestLanguage.g:5175:1: rule__Child2_1__StringAssignment_3 : ( ( rule__Child2_1__StringAlternatives_3_0 ) ) ;
    public final void rule__Child2_1__StringAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5179:1: ( ( ( rule__Child2_1__StringAlternatives_3_0 ) ) )
            // InternalBug348427TestLanguage.g:5180:2: ( ( rule__Child2_1__StringAlternatives_3_0 ) )
            {
            // InternalBug348427TestLanguage.g:5180:2: ( ( rule__Child2_1__StringAlternatives_3_0 ) )
            // InternalBug348427TestLanguage.g:5181:3: ( rule__Child2_1__StringAlternatives_3_0 )
            {
             before(grammarAccess.getChild2_1Access().getStringAlternatives_3_0()); 
            // InternalBug348427TestLanguage.g:5182:3: ( rule__Child2_1__StringAlternatives_3_0 )
            // InternalBug348427TestLanguage.g:5182:4: rule__Child2_1__StringAlternatives_3_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_1__StringAlternatives_3_0();

            state._fsp--;


            }

             after(grammarAccess.getChild2_1Access().getStringAlternatives_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_1__StringAssignment_3"


    // $ANTLR start "rule__Child2_2__NameAssignment_0"
    // InternalBug348427TestLanguage.g:5190:1: rule__Child2_2__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Child2_2__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5194:1: ( ( RULE_ID ) )
            // InternalBug348427TestLanguage.g:5195:2: ( RULE_ID )
            {
            // InternalBug348427TestLanguage.g:5195:2: ( RULE_ID )
            // InternalBug348427TestLanguage.g:5196:3: RULE_ID
            {
             before(grammarAccess.getChild2_2Access().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_2Access().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_2__NameAssignment_0"


    // $ANTLR start "rule__Child2_2__BoolAssignment_2_0"
    // InternalBug348427TestLanguage.g:5205:1: rule__Child2_2__BoolAssignment_2_0 : ( ( 'bool' ) ) ;
    public final void rule__Child2_2__BoolAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5209:1: ( ( ( 'bool' ) ) )
            // InternalBug348427TestLanguage.g:5210:2: ( ( 'bool' ) )
            {
            // InternalBug348427TestLanguage.g:5210:2: ( ( 'bool' ) )
            // InternalBug348427TestLanguage.g:5211:3: ( 'bool' )
            {
             before(grammarAccess.getChild2_2Access().getBoolBoolKeyword_2_0_0()); 
            // InternalBug348427TestLanguage.g:5212:3: ( 'bool' )
            // InternalBug348427TestLanguage.g:5213:4: 'bool'
            {
             before(grammarAccess.getChild2_2Access().getBoolBoolKeyword_2_0_0()); 
            match(input,32,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_2Access().getBoolBoolKeyword_2_0_0()); 

            }

             after(grammarAccess.getChild2_2Access().getBoolBoolKeyword_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_2__BoolAssignment_2_0"


    // $ANTLR start "rule__Child2_2__StringAssignment_3"
    // InternalBug348427TestLanguage.g:5224:1: rule__Child2_2__StringAssignment_3 : ( ( rule__Child2_2__StringAlternatives_3_0 ) ) ;
    public final void rule__Child2_2__StringAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5228:1: ( ( ( rule__Child2_2__StringAlternatives_3_0 ) ) )
            // InternalBug348427TestLanguage.g:5229:2: ( ( rule__Child2_2__StringAlternatives_3_0 ) )
            {
            // InternalBug348427TestLanguage.g:5229:2: ( ( rule__Child2_2__StringAlternatives_3_0 ) )
            // InternalBug348427TestLanguage.g:5230:3: ( rule__Child2_2__StringAlternatives_3_0 )
            {
             before(grammarAccess.getChild2_2Access().getStringAlternatives_3_0()); 
            // InternalBug348427TestLanguage.g:5231:3: ( rule__Child2_2__StringAlternatives_3_0 )
            // InternalBug348427TestLanguage.g:5231:4: rule__Child2_2__StringAlternatives_3_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_2__StringAlternatives_3_0();

            state._fsp--;


            }

             after(grammarAccess.getChild2_2Access().getStringAlternatives_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_2__StringAssignment_3"


    // $ANTLR start "rule__Child2_3__NameAssignment_0"
    // InternalBug348427TestLanguage.g:5239:1: rule__Child2_3__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Child2_3__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5243:1: ( ( RULE_ID ) )
            // InternalBug348427TestLanguage.g:5244:2: ( RULE_ID )
            {
            // InternalBug348427TestLanguage.g:5244:2: ( RULE_ID )
            // InternalBug348427TestLanguage.g:5245:3: RULE_ID
            {
             before(grammarAccess.getChild2_3Access().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_3Access().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_3__NameAssignment_0"


    // $ANTLR start "rule__Child2_3__BoolAssignment_2_0"
    // InternalBug348427TestLanguage.g:5254:1: rule__Child2_3__BoolAssignment_2_0 : ( ( 'bool' ) ) ;
    public final void rule__Child2_3__BoolAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5258:1: ( ( ( 'bool' ) ) )
            // InternalBug348427TestLanguage.g:5259:2: ( ( 'bool' ) )
            {
            // InternalBug348427TestLanguage.g:5259:2: ( ( 'bool' ) )
            // InternalBug348427TestLanguage.g:5260:3: ( 'bool' )
            {
             before(grammarAccess.getChild2_3Access().getBoolBoolKeyword_2_0_0()); 
            // InternalBug348427TestLanguage.g:5261:3: ( 'bool' )
            // InternalBug348427TestLanguage.g:5262:4: 'bool'
            {
             before(grammarAccess.getChild2_3Access().getBoolBoolKeyword_2_0_0()); 
            match(input,32,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_3Access().getBoolBoolKeyword_2_0_0()); 

            }

             after(grammarAccess.getChild2_3Access().getBoolBoolKeyword_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_3__BoolAssignment_2_0"


    // $ANTLR start "rule__Child2_3__StringAssignment_3"
    // InternalBug348427TestLanguage.g:5273:1: rule__Child2_3__StringAssignment_3 : ( ( rule__Child2_3__StringAlternatives_3_0 ) ) ;
    public final void rule__Child2_3__StringAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5277:1: ( ( ( rule__Child2_3__StringAlternatives_3_0 ) ) )
            // InternalBug348427TestLanguage.g:5278:2: ( ( rule__Child2_3__StringAlternatives_3_0 ) )
            {
            // InternalBug348427TestLanguage.g:5278:2: ( ( rule__Child2_3__StringAlternatives_3_0 ) )
            // InternalBug348427TestLanguage.g:5279:3: ( rule__Child2_3__StringAlternatives_3_0 )
            {
             before(grammarAccess.getChild2_3Access().getStringAlternatives_3_0()); 
            // InternalBug348427TestLanguage.g:5280:3: ( rule__Child2_3__StringAlternatives_3_0 )
            // InternalBug348427TestLanguage.g:5280:4: rule__Child2_3__StringAlternatives_3_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Child2_3__StringAlternatives_3_0();

            state._fsp--;


            }

             after(grammarAccess.getChild2_3Access().getStringAlternatives_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_3__StringAssignment_3"


    // $ANTLR start "rule__Child2_4__NameAssignment_0"
    // InternalBug348427TestLanguage.g:5288:1: rule__Child2_4__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Child2_4__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5292:1: ( ( RULE_ID ) )
            // InternalBug348427TestLanguage.g:5293:2: ( RULE_ID )
            {
            // InternalBug348427TestLanguage.g:5293:2: ( RULE_ID )
            // InternalBug348427TestLanguage.g:5294:3: RULE_ID
            {
             before(grammarAccess.getChild2_4Access().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_4Access().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_4__NameAssignment_0"


    // $ANTLR start "rule__Child2_4__BoolAssignment_2_0"
    // InternalBug348427TestLanguage.g:5303:1: rule__Child2_4__BoolAssignment_2_0 : ( ( 'bool' ) ) ;
    public final void rule__Child2_4__BoolAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5307:1: ( ( ( 'bool' ) ) )
            // InternalBug348427TestLanguage.g:5308:2: ( ( 'bool' ) )
            {
            // InternalBug348427TestLanguage.g:5308:2: ( ( 'bool' ) )
            // InternalBug348427TestLanguage.g:5309:3: ( 'bool' )
            {
             before(grammarAccess.getChild2_4Access().getBoolBoolKeyword_2_0_0()); 
            // InternalBug348427TestLanguage.g:5310:3: ( 'bool' )
            // InternalBug348427TestLanguage.g:5311:4: 'bool'
            {
             before(grammarAccess.getChild2_4Access().getBoolBoolKeyword_2_0_0()); 
            match(input,32,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_4Access().getBoolBoolKeyword_2_0_0()); 

            }

             after(grammarAccess.getChild2_4Access().getBoolBoolKeyword_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_4__BoolAssignment_2_0"


    // $ANTLR start "rule__Child2_4__StringAssignment_3_0"
    // InternalBug348427TestLanguage.g:5322:1: rule__Child2_4__StringAssignment_3_0 : ( ( 'a' ) ) ;
    public final void rule__Child2_4__StringAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5326:1: ( ( ( 'a' ) ) )
            // InternalBug348427TestLanguage.g:5327:2: ( ( 'a' ) )
            {
            // InternalBug348427TestLanguage.g:5327:2: ( ( 'a' ) )
            // InternalBug348427TestLanguage.g:5328:3: ( 'a' )
            {
             before(grammarAccess.getChild2_4Access().getStringAKeyword_3_0_0()); 
            // InternalBug348427TestLanguage.g:5329:3: ( 'a' )
            // InternalBug348427TestLanguage.g:5330:4: 'a'
            {
             before(grammarAccess.getChild2_4Access().getStringAKeyword_3_0_0()); 
            match(input,11,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_4Access().getStringAKeyword_3_0_0()); 

            }

             after(grammarAccess.getChild2_4Access().getStringAKeyword_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_4__StringAssignment_3_0"


    // $ANTLR start "rule__Child2_4__StringAssignment_3_1"
    // InternalBug348427TestLanguage.g:5341:1: rule__Child2_4__StringAssignment_3_1 : ( ( 'b' ) ) ;
    public final void rule__Child2_4__StringAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5345:1: ( ( ( 'b' ) ) )
            // InternalBug348427TestLanguage.g:5346:2: ( ( 'b' ) )
            {
            // InternalBug348427TestLanguage.g:5346:2: ( ( 'b' ) )
            // InternalBug348427TestLanguage.g:5347:3: ( 'b' )
            {
             before(grammarAccess.getChild2_4Access().getStringBKeyword_3_1_0()); 
            // InternalBug348427TestLanguage.g:5348:3: ( 'b' )
            // InternalBug348427TestLanguage.g:5349:4: 'b'
            {
             before(grammarAccess.getChild2_4Access().getStringBKeyword_3_1_0()); 
            match(input,12,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_4Access().getStringBKeyword_3_1_0()); 

            }

             after(grammarAccess.getChild2_4Access().getStringBKeyword_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_4__StringAssignment_3_1"


    // $ANTLR start "rule__Child2_5__NameAssignment_0"
    // InternalBug348427TestLanguage.g:5360:1: rule__Child2_5__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Child2_5__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5364:1: ( ( RULE_ID ) )
            // InternalBug348427TestLanguage.g:5365:2: ( RULE_ID )
            {
            // InternalBug348427TestLanguage.g:5365:2: ( RULE_ID )
            // InternalBug348427TestLanguage.g:5366:3: RULE_ID
            {
             before(grammarAccess.getChild2_5Access().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_5Access().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_5__NameAssignment_0"


    // $ANTLR start "rule__Child2_5__BoolAssignment_2_0"
    // InternalBug348427TestLanguage.g:5375:1: rule__Child2_5__BoolAssignment_2_0 : ( ( 'bool' ) ) ;
    public final void rule__Child2_5__BoolAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5379:1: ( ( ( 'bool' ) ) )
            // InternalBug348427TestLanguage.g:5380:2: ( ( 'bool' ) )
            {
            // InternalBug348427TestLanguage.g:5380:2: ( ( 'bool' ) )
            // InternalBug348427TestLanguage.g:5381:3: ( 'bool' )
            {
             before(grammarAccess.getChild2_5Access().getBoolBoolKeyword_2_0_0()); 
            // InternalBug348427TestLanguage.g:5382:3: ( 'bool' )
            // InternalBug348427TestLanguage.g:5383:4: 'bool'
            {
             before(grammarAccess.getChild2_5Access().getBoolBoolKeyword_2_0_0()); 
            match(input,32,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_5Access().getBoolBoolKeyword_2_0_0()); 

            }

             after(grammarAccess.getChild2_5Access().getBoolBoolKeyword_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_5__BoolAssignment_2_0"


    // $ANTLR start "rule__Child2_5__StringAssignment_3_0"
    // InternalBug348427TestLanguage.g:5394:1: rule__Child2_5__StringAssignment_3_0 : ( ( 'a' ) ) ;
    public final void rule__Child2_5__StringAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5398:1: ( ( ( 'a' ) ) )
            // InternalBug348427TestLanguage.g:5399:2: ( ( 'a' ) )
            {
            // InternalBug348427TestLanguage.g:5399:2: ( ( 'a' ) )
            // InternalBug348427TestLanguage.g:5400:3: ( 'a' )
            {
             before(grammarAccess.getChild2_5Access().getStringAKeyword_3_0_0()); 
            // InternalBug348427TestLanguage.g:5401:3: ( 'a' )
            // InternalBug348427TestLanguage.g:5402:4: 'a'
            {
             before(grammarAccess.getChild2_5Access().getStringAKeyword_3_0_0()); 
            match(input,11,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_5Access().getStringAKeyword_3_0_0()); 

            }

             after(grammarAccess.getChild2_5Access().getStringAKeyword_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_5__StringAssignment_3_0"


    // $ANTLR start "rule__Child2_5__StringAssignment_3_1"
    // InternalBug348427TestLanguage.g:5413:1: rule__Child2_5__StringAssignment_3_1 : ( ( 'b' ) ) ;
    public final void rule__Child2_5__StringAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5417:1: ( ( ( 'b' ) ) )
            // InternalBug348427TestLanguage.g:5418:2: ( ( 'b' ) )
            {
            // InternalBug348427TestLanguage.g:5418:2: ( ( 'b' ) )
            // InternalBug348427TestLanguage.g:5419:3: ( 'b' )
            {
             before(grammarAccess.getChild2_5Access().getStringBKeyword_3_1_0()); 
            // InternalBug348427TestLanguage.g:5420:3: ( 'b' )
            // InternalBug348427TestLanguage.g:5421:4: 'b'
            {
             before(grammarAccess.getChild2_5Access().getStringBKeyword_3_1_0()); 
            match(input,12,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_5Access().getStringBKeyword_3_1_0()); 

            }

             after(grammarAccess.getChild2_5Access().getStringBKeyword_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_5__StringAssignment_3_1"


    // $ANTLR start "rule__Child2_6__NameAssignment_0"
    // InternalBug348427TestLanguage.g:5432:1: rule__Child2_6__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Child2_6__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5436:1: ( ( RULE_ID ) )
            // InternalBug348427TestLanguage.g:5437:2: ( RULE_ID )
            {
            // InternalBug348427TestLanguage.g:5437:2: ( RULE_ID )
            // InternalBug348427TestLanguage.g:5438:3: RULE_ID
            {
             before(grammarAccess.getChild2_6Access().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_6Access().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_6__NameAssignment_0"


    // $ANTLR start "rule__Child2_6__BoolAssignment_2_0"
    // InternalBug348427TestLanguage.g:5447:1: rule__Child2_6__BoolAssignment_2_0 : ( ( 'bool' ) ) ;
    public final void rule__Child2_6__BoolAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5451:1: ( ( ( 'bool' ) ) )
            // InternalBug348427TestLanguage.g:5452:2: ( ( 'bool' ) )
            {
            // InternalBug348427TestLanguage.g:5452:2: ( ( 'bool' ) )
            // InternalBug348427TestLanguage.g:5453:3: ( 'bool' )
            {
             before(grammarAccess.getChild2_6Access().getBoolBoolKeyword_2_0_0()); 
            // InternalBug348427TestLanguage.g:5454:3: ( 'bool' )
            // InternalBug348427TestLanguage.g:5455:4: 'bool'
            {
             before(grammarAccess.getChild2_6Access().getBoolBoolKeyword_2_0_0()); 
            match(input,32,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_6Access().getBoolBoolKeyword_2_0_0()); 

            }

             after(grammarAccess.getChild2_6Access().getBoolBoolKeyword_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_6__BoolAssignment_2_0"


    // $ANTLR start "rule__Child2_6__StringAssignment_3_0"
    // InternalBug348427TestLanguage.g:5466:1: rule__Child2_6__StringAssignment_3_0 : ( ( 'a' ) ) ;
    public final void rule__Child2_6__StringAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5470:1: ( ( ( 'a' ) ) )
            // InternalBug348427TestLanguage.g:5471:2: ( ( 'a' ) )
            {
            // InternalBug348427TestLanguage.g:5471:2: ( ( 'a' ) )
            // InternalBug348427TestLanguage.g:5472:3: ( 'a' )
            {
             before(grammarAccess.getChild2_6Access().getStringAKeyword_3_0_0()); 
            // InternalBug348427TestLanguage.g:5473:3: ( 'a' )
            // InternalBug348427TestLanguage.g:5474:4: 'a'
            {
             before(grammarAccess.getChild2_6Access().getStringAKeyword_3_0_0()); 
            match(input,11,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_6Access().getStringAKeyword_3_0_0()); 

            }

             after(grammarAccess.getChild2_6Access().getStringAKeyword_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_6__StringAssignment_3_0"


    // $ANTLR start "rule__Child2_6__StringAssignment_3_1"
    // InternalBug348427TestLanguage.g:5485:1: rule__Child2_6__StringAssignment_3_1 : ( ( 'b' ) ) ;
    public final void rule__Child2_6__StringAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5489:1: ( ( ( 'b' ) ) )
            // InternalBug348427TestLanguage.g:5490:2: ( ( 'b' ) )
            {
            // InternalBug348427TestLanguage.g:5490:2: ( ( 'b' ) )
            // InternalBug348427TestLanguage.g:5491:3: ( 'b' )
            {
             before(grammarAccess.getChild2_6Access().getStringBKeyword_3_1_0()); 
            // InternalBug348427TestLanguage.g:5492:3: ( 'b' )
            // InternalBug348427TestLanguage.g:5493:4: 'b'
            {
             before(grammarAccess.getChild2_6Access().getStringBKeyword_3_1_0()); 
            match(input,12,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getChild2_6Access().getStringBKeyword_3_1_0()); 

            }

             after(grammarAccess.getChild2_6Access().getStringBKeyword_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Child2_6__StringAssignment_3_1"

    // Delegated rules


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA3 dfa3 = new DFA3(this);
    protected DFA4 dfa4 = new DFA4(this);
    protected DFA5 dfa5 = new DFA5(this);
    protected DFA6 dfa6 = new DFA6(this);
    protected DFA7 dfa7 = new DFA7(this);
    protected DFA8 dfa8 = new DFA8(this);
    protected DFA9 dfa9 = new DFA9(this);
    protected DFA10 dfa10 = new DFA10(this);
    protected DFA11 dfa11 = new DFA11(this);
    protected DFA12 dfa12 = new DFA12(this);
    protected DFA13 dfa13 = new DFA13(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\1\4\1\22\1\13\1\25\2\23\1\13\3\uffff";
    static final String dfa_3s = "\1\4\1\22\1\40\1\25\2\27\1\14\3\uffff";
    static final String dfa_4s = "\7\uffff\1\1\1\2\1\3";
    static final String dfa_5s = "\12\uffff}>";
    static final String[] dfa_6s = {
            "\1\1",
            "\1\2",
            "\1\4\1\5\23\uffff\1\3",
            "\1\6",
            "\1\7\2\uffff\1\10\1\11",
            "\1\7\2\uffff\1\10\1\11",
            "\1\4\1\5",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "704:1: rule__Scenario1_1__Alternatives_1 : ( ( ( rule__Scenario1_1__ChildAssignment_1_0 ) ) | ( ( rule__Scenario1_1__ChildAssignment_1_1 ) ) | ( ( rule__Scenario1_1__ChildAssignment_1_2 ) ) );";
        }
    }
    static final String dfa_7s = "\7\uffff\1\2\1\3\1\1";
    static final String[] dfa_8s = {
            "\1\1",
            "\1\2",
            "\1\4\1\5\23\uffff\1\3",
            "\1\6",
            "\1\11\2\uffff\1\7\1\10",
            "\1\11\2\uffff\1\7\1\10",
            "\1\4\1\5",
            "",
            "",
            ""
    };
    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final short[][] dfa_8 = unpackEncodedStringArray(dfa_8s);

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_7;
            this.special = dfa_5;
            this.transition = dfa_8;
        }
        public String getDescription() {
            return "731:1: rule__Scenario1_2__Alternatives_1 : ( ( ( rule__Scenario1_2__ChildAssignment_1_0 ) ) | ( ( rule__Scenario1_2__ChildAssignment_1_1 ) ) | ( ( rule__Scenario1_2__ChildAssignment_1_2 ) ) );";
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "758:1: rule__Scenario1_3__Alternatives_2 : ( ( ( rule__Scenario1_3__ChildAssignment_2_0 ) ) | ( ( rule__Scenario1_3__ChildAssignment_2_1 ) ) | ( ( rule__Scenario1_3__ChildAssignment_2_2 ) ) );";
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_7;
            this.special = dfa_5;
            this.transition = dfa_8;
        }
        public String getDescription() {
            return "785:1: rule__Scenario1_4__Alternatives_2 : ( ( ( rule__Scenario1_4__ChildAssignment_2_0 ) ) | ( ( rule__Scenario1_4__ChildAssignment_2_1 ) ) | ( ( rule__Scenario1_4__ChildAssignment_2_2 ) ) );";
        }
    }
    static final String dfa_9s = "\7\uffff\1\3\1\1\1\2";
    static final String[] dfa_10s = {
            "\1\1",
            "\1\2",
            "\1\4\1\5\23\uffff\1\3",
            "\1\6",
            "\1\10\2\uffff\1\11\1\7",
            "\1\10\2\uffff\1\11\1\7",
            "\1\4\1\5",
            "",
            "",
            ""
    };
    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final short[][] dfa_10 = unpackEncodedStringArray(dfa_10s);

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_9;
            this.special = dfa_5;
            this.transition = dfa_10;
        }
        public String getDescription() {
            return "812:1: rule__Scenario2_1__Alternatives_1 : ( ( ( rule__Scenario2_1__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_1__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_1__ChildAssignment_1_2 ) ) );";
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_7;
            this.special = dfa_5;
            this.transition = dfa_8;
        }
        public String getDescription() {
            return "839:1: rule__Scenario2_2__Alternatives_1 : ( ( ( rule__Scenario2_2__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_2__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_2__ChildAssignment_1_2 ) ) );";
        }
    }
    static final String dfa_11s = "\7\uffff\1\1\1\3\1\2";
    static final String[] dfa_12s = {
            "\1\1",
            "\1\2",
            "\1\4\1\5\23\uffff\1\3",
            "\1\6",
            "\1\7\2\uffff\1\11\1\10",
            "\1\7\2\uffff\1\11\1\10",
            "\1\4\1\5",
            "",
            "",
            ""
    };
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_11;
            this.special = dfa_5;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "866:1: rule__Scenario2_3__Alternatives_1 : ( ( ( rule__Scenario2_3__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_3__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_3__ChildAssignment_1_2 ) ) );";
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_9;
            this.special = dfa_5;
            this.transition = dfa_10;
        }
        public String getDescription() {
            return "893:1: rule__Scenario2_4__Alternatives_1 : ( ( ( rule__Scenario2_4__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_4__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_4__ChildAssignment_1_2 ) ) );";
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "920:1: rule__Scenario2_5__Alternatives_2 : ( ( ( rule__Scenario2_5__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_5__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_5__ChildAssignment_2_2 ) ) );";
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_9;
            this.special = dfa_5;
            this.transition = dfa_10;
        }
        public String getDescription() {
            return "947:1: rule__Scenario2_6__Alternatives_2 : ( ( ( rule__Scenario2_6__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_6__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_6__ChildAssignment_2_2 ) ) );";
        }
    }
    static final String dfa_13s = "\7\uffff\1\2\1\1\1\3";
    static final String[] dfa_14s = {
            "\1\1",
            "\1\2",
            "\1\4\1\5\23\uffff\1\3",
            "\1\6",
            "\1\10\2\uffff\1\7\1\11",
            "\1\10\2\uffff\1\7\1\11",
            "\1\4\1\5",
            "",
            "",
            ""
    };
    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_13;
            this.special = dfa_5;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "974:1: rule__Scenario2_7__Alternatives_2 : ( ( ( rule__Scenario2_7__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_7__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_7__ChildAssignment_2_2 ) ) );";
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_11;
            this.special = dfa_5;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "1001:1: rule__Scenario2_8__Alternatives_2 : ( ( ( rule__Scenario2_8__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_8__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_8__ChildAssignment_2_2 ) ) );";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000100001800L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000080000000L});
    }


}
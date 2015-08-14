package org.eclipse.xtext.ui.tests.editor.contentassist.ui.contentassist.antlr.internal; 

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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug348427TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug348427TestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'a'", "'b'", "'1.1'", "'next'", "'1.2'", "'1.3'", "'1.4'", "':'", "'child1'", "'end'", "'keyword'", "'child2'", "'child3'", "'2.1'", "'2.2'", "'2.3'", "'2.4'", "'2.5'", "'2.6'", "'2.7'", "'2.8'", "'bool'"
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
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_STRING=6;
    public static final int T__32=32;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;

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
    // InternalBug348427TestLanguage.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:61:1: ( ruleModel EOF )
            // InternalBug348427TestLanguage.g:62:1: ruleModel EOF
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
    // InternalBug348427TestLanguage.g:69:1: ruleModel : ( ( rule__Model__Alternatives ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:73:2: ( ( ( rule__Model__Alternatives ) ) )
            // InternalBug348427TestLanguage.g:74:1: ( ( rule__Model__Alternatives ) )
            {
            // InternalBug348427TestLanguage.g:74:1: ( ( rule__Model__Alternatives ) )
            // InternalBug348427TestLanguage.g:75:1: ( rule__Model__Alternatives )
            {
             before(grammarAccess.getModelAccess().getAlternatives()); 
            // InternalBug348427TestLanguage.g:76:1: ( rule__Model__Alternatives )
            // InternalBug348427TestLanguage.g:76:2: rule__Model__Alternatives
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
    // InternalBug348427TestLanguage.g:88:1: entryRuleScenario1_1 : ruleScenario1_1 EOF ;
    public final void entryRuleScenario1_1() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:89:1: ( ruleScenario1_1 EOF )
            // InternalBug348427TestLanguage.g:90:1: ruleScenario1_1 EOF
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
    // InternalBug348427TestLanguage.g:97:1: ruleScenario1_1 : ( ( rule__Scenario1_1__Group__0 ) ) ;
    public final void ruleScenario1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:101:2: ( ( ( rule__Scenario1_1__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:102:1: ( ( rule__Scenario1_1__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:102:1: ( ( rule__Scenario1_1__Group__0 ) )
            // InternalBug348427TestLanguage.g:103:1: ( rule__Scenario1_1__Group__0 )
            {
             before(grammarAccess.getScenario1_1Access().getGroup()); 
            // InternalBug348427TestLanguage.g:104:1: ( rule__Scenario1_1__Group__0 )
            // InternalBug348427TestLanguage.g:104:2: rule__Scenario1_1__Group__0
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
    // InternalBug348427TestLanguage.g:116:1: entryRuleScenario1_2 : ruleScenario1_2 EOF ;
    public final void entryRuleScenario1_2() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:117:1: ( ruleScenario1_2 EOF )
            // InternalBug348427TestLanguage.g:118:1: ruleScenario1_2 EOF
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
    // InternalBug348427TestLanguage.g:125:1: ruleScenario1_2 : ( ( rule__Scenario1_2__Group__0 ) ) ;
    public final void ruleScenario1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:129:2: ( ( ( rule__Scenario1_2__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:130:1: ( ( rule__Scenario1_2__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:130:1: ( ( rule__Scenario1_2__Group__0 ) )
            // InternalBug348427TestLanguage.g:131:1: ( rule__Scenario1_2__Group__0 )
            {
             before(grammarAccess.getScenario1_2Access().getGroup()); 
            // InternalBug348427TestLanguage.g:132:1: ( rule__Scenario1_2__Group__0 )
            // InternalBug348427TestLanguage.g:132:2: rule__Scenario1_2__Group__0
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
    // InternalBug348427TestLanguage.g:144:1: entryRuleScenario1_3 : ruleScenario1_3 EOF ;
    public final void entryRuleScenario1_3() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:145:1: ( ruleScenario1_3 EOF )
            // InternalBug348427TestLanguage.g:146:1: ruleScenario1_3 EOF
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
    // InternalBug348427TestLanguage.g:153:1: ruleScenario1_3 : ( ( rule__Scenario1_3__Group__0 ) ) ;
    public final void ruleScenario1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:157:2: ( ( ( rule__Scenario1_3__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:158:1: ( ( rule__Scenario1_3__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:158:1: ( ( rule__Scenario1_3__Group__0 ) )
            // InternalBug348427TestLanguage.g:159:1: ( rule__Scenario1_3__Group__0 )
            {
             before(grammarAccess.getScenario1_3Access().getGroup()); 
            // InternalBug348427TestLanguage.g:160:1: ( rule__Scenario1_3__Group__0 )
            // InternalBug348427TestLanguage.g:160:2: rule__Scenario1_3__Group__0
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
    // InternalBug348427TestLanguage.g:172:1: entryRuleScenario1_4 : ruleScenario1_4 EOF ;
    public final void entryRuleScenario1_4() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:173:1: ( ruleScenario1_4 EOF )
            // InternalBug348427TestLanguage.g:174:1: ruleScenario1_4 EOF
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
    // InternalBug348427TestLanguage.g:181:1: ruleScenario1_4 : ( ( rule__Scenario1_4__Group__0 ) ) ;
    public final void ruleScenario1_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:185:2: ( ( ( rule__Scenario1_4__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:186:1: ( ( rule__Scenario1_4__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:186:1: ( ( rule__Scenario1_4__Group__0 ) )
            // InternalBug348427TestLanguage.g:187:1: ( rule__Scenario1_4__Group__0 )
            {
             before(grammarAccess.getScenario1_4Access().getGroup()); 
            // InternalBug348427TestLanguage.g:188:1: ( rule__Scenario1_4__Group__0 )
            // InternalBug348427TestLanguage.g:188:2: rule__Scenario1_4__Group__0
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
    // InternalBug348427TestLanguage.g:200:1: entryRuleChild1_1 : ruleChild1_1 EOF ;
    public final void entryRuleChild1_1() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:201:1: ( ruleChild1_1 EOF )
            // InternalBug348427TestLanguage.g:202:1: ruleChild1_1 EOF
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
    // InternalBug348427TestLanguage.g:209:1: ruleChild1_1 : ( ( rule__Child1_1__Group__0 ) ) ;
    public final void ruleChild1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:213:2: ( ( ( rule__Child1_1__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:214:1: ( ( rule__Child1_1__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:214:1: ( ( rule__Child1_1__Group__0 ) )
            // InternalBug348427TestLanguage.g:215:1: ( rule__Child1_1__Group__0 )
            {
             before(grammarAccess.getChild1_1Access().getGroup()); 
            // InternalBug348427TestLanguage.g:216:1: ( rule__Child1_1__Group__0 )
            // InternalBug348427TestLanguage.g:216:2: rule__Child1_1__Group__0
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
    // InternalBug348427TestLanguage.g:228:1: entryRuleChild1_2 : ruleChild1_2 EOF ;
    public final void entryRuleChild1_2() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:229:1: ( ruleChild1_2 EOF )
            // InternalBug348427TestLanguage.g:230:1: ruleChild1_2 EOF
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
    // InternalBug348427TestLanguage.g:237:1: ruleChild1_2 : ( ( rule__Child1_2__Group__0 ) ) ;
    public final void ruleChild1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:241:2: ( ( ( rule__Child1_2__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:242:1: ( ( rule__Child1_2__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:242:1: ( ( rule__Child1_2__Group__0 ) )
            // InternalBug348427TestLanguage.g:243:1: ( rule__Child1_2__Group__0 )
            {
             before(grammarAccess.getChild1_2Access().getGroup()); 
            // InternalBug348427TestLanguage.g:244:1: ( rule__Child1_2__Group__0 )
            // InternalBug348427TestLanguage.g:244:2: rule__Child1_2__Group__0
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
    // InternalBug348427TestLanguage.g:256:1: entryRuleChild1_3 : ruleChild1_3 EOF ;
    public final void entryRuleChild1_3() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:257:1: ( ruleChild1_3 EOF )
            // InternalBug348427TestLanguage.g:258:1: ruleChild1_3 EOF
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
    // InternalBug348427TestLanguage.g:265:1: ruleChild1_3 : ( ( rule__Child1_3__Group__0 ) ) ;
    public final void ruleChild1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:269:2: ( ( ( rule__Child1_3__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:270:1: ( ( rule__Child1_3__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:270:1: ( ( rule__Child1_3__Group__0 ) )
            // InternalBug348427TestLanguage.g:271:1: ( rule__Child1_3__Group__0 )
            {
             before(grammarAccess.getChild1_3Access().getGroup()); 
            // InternalBug348427TestLanguage.g:272:1: ( rule__Child1_3__Group__0 )
            // InternalBug348427TestLanguage.g:272:2: rule__Child1_3__Group__0
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
    // InternalBug348427TestLanguage.g:284:1: entryRuleScenario2_1 : ruleScenario2_1 EOF ;
    public final void entryRuleScenario2_1() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:285:1: ( ruleScenario2_1 EOF )
            // InternalBug348427TestLanguage.g:286:1: ruleScenario2_1 EOF
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
    // InternalBug348427TestLanguage.g:293:1: ruleScenario2_1 : ( ( rule__Scenario2_1__Group__0 ) ) ;
    public final void ruleScenario2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:297:2: ( ( ( rule__Scenario2_1__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:298:1: ( ( rule__Scenario2_1__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:298:1: ( ( rule__Scenario2_1__Group__0 ) )
            // InternalBug348427TestLanguage.g:299:1: ( rule__Scenario2_1__Group__0 )
            {
             before(grammarAccess.getScenario2_1Access().getGroup()); 
            // InternalBug348427TestLanguage.g:300:1: ( rule__Scenario2_1__Group__0 )
            // InternalBug348427TestLanguage.g:300:2: rule__Scenario2_1__Group__0
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
    // InternalBug348427TestLanguage.g:312:1: entryRuleScenario2_2 : ruleScenario2_2 EOF ;
    public final void entryRuleScenario2_2() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:313:1: ( ruleScenario2_2 EOF )
            // InternalBug348427TestLanguage.g:314:1: ruleScenario2_2 EOF
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
    // InternalBug348427TestLanguage.g:321:1: ruleScenario2_2 : ( ( rule__Scenario2_2__Group__0 ) ) ;
    public final void ruleScenario2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:325:2: ( ( ( rule__Scenario2_2__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:326:1: ( ( rule__Scenario2_2__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:326:1: ( ( rule__Scenario2_2__Group__0 ) )
            // InternalBug348427TestLanguage.g:327:1: ( rule__Scenario2_2__Group__0 )
            {
             before(grammarAccess.getScenario2_2Access().getGroup()); 
            // InternalBug348427TestLanguage.g:328:1: ( rule__Scenario2_2__Group__0 )
            // InternalBug348427TestLanguage.g:328:2: rule__Scenario2_2__Group__0
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
    // InternalBug348427TestLanguage.g:340:1: entryRuleScenario2_3 : ruleScenario2_3 EOF ;
    public final void entryRuleScenario2_3() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:341:1: ( ruleScenario2_3 EOF )
            // InternalBug348427TestLanguage.g:342:1: ruleScenario2_3 EOF
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
    // InternalBug348427TestLanguage.g:349:1: ruleScenario2_3 : ( ( rule__Scenario2_3__Group__0 ) ) ;
    public final void ruleScenario2_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:353:2: ( ( ( rule__Scenario2_3__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:354:1: ( ( rule__Scenario2_3__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:354:1: ( ( rule__Scenario2_3__Group__0 ) )
            // InternalBug348427TestLanguage.g:355:1: ( rule__Scenario2_3__Group__0 )
            {
             before(grammarAccess.getScenario2_3Access().getGroup()); 
            // InternalBug348427TestLanguage.g:356:1: ( rule__Scenario2_3__Group__0 )
            // InternalBug348427TestLanguage.g:356:2: rule__Scenario2_3__Group__0
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
    // InternalBug348427TestLanguage.g:368:1: entryRuleScenario2_4 : ruleScenario2_4 EOF ;
    public final void entryRuleScenario2_4() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:369:1: ( ruleScenario2_4 EOF )
            // InternalBug348427TestLanguage.g:370:1: ruleScenario2_4 EOF
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
    // InternalBug348427TestLanguage.g:377:1: ruleScenario2_4 : ( ( rule__Scenario2_4__Group__0 ) ) ;
    public final void ruleScenario2_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:381:2: ( ( ( rule__Scenario2_4__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:382:1: ( ( rule__Scenario2_4__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:382:1: ( ( rule__Scenario2_4__Group__0 ) )
            // InternalBug348427TestLanguage.g:383:1: ( rule__Scenario2_4__Group__0 )
            {
             before(grammarAccess.getScenario2_4Access().getGroup()); 
            // InternalBug348427TestLanguage.g:384:1: ( rule__Scenario2_4__Group__0 )
            // InternalBug348427TestLanguage.g:384:2: rule__Scenario2_4__Group__0
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
    // InternalBug348427TestLanguage.g:396:1: entryRuleScenario2_5 : ruleScenario2_5 EOF ;
    public final void entryRuleScenario2_5() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:397:1: ( ruleScenario2_5 EOF )
            // InternalBug348427TestLanguage.g:398:1: ruleScenario2_5 EOF
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
    // InternalBug348427TestLanguage.g:405:1: ruleScenario2_5 : ( ( rule__Scenario2_5__Group__0 ) ) ;
    public final void ruleScenario2_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:409:2: ( ( ( rule__Scenario2_5__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:410:1: ( ( rule__Scenario2_5__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:410:1: ( ( rule__Scenario2_5__Group__0 ) )
            // InternalBug348427TestLanguage.g:411:1: ( rule__Scenario2_5__Group__0 )
            {
             before(grammarAccess.getScenario2_5Access().getGroup()); 
            // InternalBug348427TestLanguage.g:412:1: ( rule__Scenario2_5__Group__0 )
            // InternalBug348427TestLanguage.g:412:2: rule__Scenario2_5__Group__0
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
    // InternalBug348427TestLanguage.g:424:1: entryRuleScenario2_6 : ruleScenario2_6 EOF ;
    public final void entryRuleScenario2_6() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:425:1: ( ruleScenario2_6 EOF )
            // InternalBug348427TestLanguage.g:426:1: ruleScenario2_6 EOF
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
    // InternalBug348427TestLanguage.g:433:1: ruleScenario2_6 : ( ( rule__Scenario2_6__Group__0 ) ) ;
    public final void ruleScenario2_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:437:2: ( ( ( rule__Scenario2_6__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:438:1: ( ( rule__Scenario2_6__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:438:1: ( ( rule__Scenario2_6__Group__0 ) )
            // InternalBug348427TestLanguage.g:439:1: ( rule__Scenario2_6__Group__0 )
            {
             before(grammarAccess.getScenario2_6Access().getGroup()); 
            // InternalBug348427TestLanguage.g:440:1: ( rule__Scenario2_6__Group__0 )
            // InternalBug348427TestLanguage.g:440:2: rule__Scenario2_6__Group__0
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
    // InternalBug348427TestLanguage.g:452:1: entryRuleScenario2_7 : ruleScenario2_7 EOF ;
    public final void entryRuleScenario2_7() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:453:1: ( ruleScenario2_7 EOF )
            // InternalBug348427TestLanguage.g:454:1: ruleScenario2_7 EOF
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
    // InternalBug348427TestLanguage.g:461:1: ruleScenario2_7 : ( ( rule__Scenario2_7__Group__0 ) ) ;
    public final void ruleScenario2_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:465:2: ( ( ( rule__Scenario2_7__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:466:1: ( ( rule__Scenario2_7__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:466:1: ( ( rule__Scenario2_7__Group__0 ) )
            // InternalBug348427TestLanguage.g:467:1: ( rule__Scenario2_7__Group__0 )
            {
             before(grammarAccess.getScenario2_7Access().getGroup()); 
            // InternalBug348427TestLanguage.g:468:1: ( rule__Scenario2_7__Group__0 )
            // InternalBug348427TestLanguage.g:468:2: rule__Scenario2_7__Group__0
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
    // InternalBug348427TestLanguage.g:480:1: entryRuleScenario2_8 : ruleScenario2_8 EOF ;
    public final void entryRuleScenario2_8() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:481:1: ( ruleScenario2_8 EOF )
            // InternalBug348427TestLanguage.g:482:1: ruleScenario2_8 EOF
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
    // InternalBug348427TestLanguage.g:489:1: ruleScenario2_8 : ( ( rule__Scenario2_8__Group__0 ) ) ;
    public final void ruleScenario2_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:493:2: ( ( ( rule__Scenario2_8__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:494:1: ( ( rule__Scenario2_8__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:494:1: ( ( rule__Scenario2_8__Group__0 ) )
            // InternalBug348427TestLanguage.g:495:1: ( rule__Scenario2_8__Group__0 )
            {
             before(grammarAccess.getScenario2_8Access().getGroup()); 
            // InternalBug348427TestLanguage.g:496:1: ( rule__Scenario2_8__Group__0 )
            // InternalBug348427TestLanguage.g:496:2: rule__Scenario2_8__Group__0
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
    // InternalBug348427TestLanguage.g:508:1: entryRuleChild2_1 : ruleChild2_1 EOF ;
    public final void entryRuleChild2_1() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:509:1: ( ruleChild2_1 EOF )
            // InternalBug348427TestLanguage.g:510:1: ruleChild2_1 EOF
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
    // InternalBug348427TestLanguage.g:517:1: ruleChild2_1 : ( ( rule__Child2_1__Group__0 ) ) ;
    public final void ruleChild2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:521:2: ( ( ( rule__Child2_1__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:522:1: ( ( rule__Child2_1__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:522:1: ( ( rule__Child2_1__Group__0 ) )
            // InternalBug348427TestLanguage.g:523:1: ( rule__Child2_1__Group__0 )
            {
             before(grammarAccess.getChild2_1Access().getGroup()); 
            // InternalBug348427TestLanguage.g:524:1: ( rule__Child2_1__Group__0 )
            // InternalBug348427TestLanguage.g:524:2: rule__Child2_1__Group__0
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
    // InternalBug348427TestLanguage.g:536:1: entryRuleChild2_2 : ruleChild2_2 EOF ;
    public final void entryRuleChild2_2() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:537:1: ( ruleChild2_2 EOF )
            // InternalBug348427TestLanguage.g:538:1: ruleChild2_2 EOF
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
    // InternalBug348427TestLanguage.g:545:1: ruleChild2_2 : ( ( rule__Child2_2__Group__0 ) ) ;
    public final void ruleChild2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:549:2: ( ( ( rule__Child2_2__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:550:1: ( ( rule__Child2_2__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:550:1: ( ( rule__Child2_2__Group__0 ) )
            // InternalBug348427TestLanguage.g:551:1: ( rule__Child2_2__Group__0 )
            {
             before(grammarAccess.getChild2_2Access().getGroup()); 
            // InternalBug348427TestLanguage.g:552:1: ( rule__Child2_2__Group__0 )
            // InternalBug348427TestLanguage.g:552:2: rule__Child2_2__Group__0
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
    // InternalBug348427TestLanguage.g:564:1: entryRuleChild2_3 : ruleChild2_3 EOF ;
    public final void entryRuleChild2_3() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:565:1: ( ruleChild2_3 EOF )
            // InternalBug348427TestLanguage.g:566:1: ruleChild2_3 EOF
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
    // InternalBug348427TestLanguage.g:573:1: ruleChild2_3 : ( ( rule__Child2_3__Group__0 ) ) ;
    public final void ruleChild2_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:577:2: ( ( ( rule__Child2_3__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:578:1: ( ( rule__Child2_3__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:578:1: ( ( rule__Child2_3__Group__0 ) )
            // InternalBug348427TestLanguage.g:579:1: ( rule__Child2_3__Group__0 )
            {
             before(grammarAccess.getChild2_3Access().getGroup()); 
            // InternalBug348427TestLanguage.g:580:1: ( rule__Child2_3__Group__0 )
            // InternalBug348427TestLanguage.g:580:2: rule__Child2_3__Group__0
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
    // InternalBug348427TestLanguage.g:592:1: entryRuleChild2_4 : ruleChild2_4 EOF ;
    public final void entryRuleChild2_4() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:593:1: ( ruleChild2_4 EOF )
            // InternalBug348427TestLanguage.g:594:1: ruleChild2_4 EOF
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
    // InternalBug348427TestLanguage.g:601:1: ruleChild2_4 : ( ( rule__Child2_4__Group__0 ) ) ;
    public final void ruleChild2_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:605:2: ( ( ( rule__Child2_4__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:606:1: ( ( rule__Child2_4__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:606:1: ( ( rule__Child2_4__Group__0 ) )
            // InternalBug348427TestLanguage.g:607:1: ( rule__Child2_4__Group__0 )
            {
             before(grammarAccess.getChild2_4Access().getGroup()); 
            // InternalBug348427TestLanguage.g:608:1: ( rule__Child2_4__Group__0 )
            // InternalBug348427TestLanguage.g:608:2: rule__Child2_4__Group__0
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
    // InternalBug348427TestLanguage.g:620:1: entryRuleChild2_5 : ruleChild2_5 EOF ;
    public final void entryRuleChild2_5() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:621:1: ( ruleChild2_5 EOF )
            // InternalBug348427TestLanguage.g:622:1: ruleChild2_5 EOF
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
    // InternalBug348427TestLanguage.g:629:1: ruleChild2_5 : ( ( rule__Child2_5__Group__0 ) ) ;
    public final void ruleChild2_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:633:2: ( ( ( rule__Child2_5__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:634:1: ( ( rule__Child2_5__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:634:1: ( ( rule__Child2_5__Group__0 ) )
            // InternalBug348427TestLanguage.g:635:1: ( rule__Child2_5__Group__0 )
            {
             before(grammarAccess.getChild2_5Access().getGroup()); 
            // InternalBug348427TestLanguage.g:636:1: ( rule__Child2_5__Group__0 )
            // InternalBug348427TestLanguage.g:636:2: rule__Child2_5__Group__0
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
    // InternalBug348427TestLanguage.g:648:1: entryRuleChild2_6 : ruleChild2_6 EOF ;
    public final void entryRuleChild2_6() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:649:1: ( ruleChild2_6 EOF )
            // InternalBug348427TestLanguage.g:650:1: ruleChild2_6 EOF
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
    // InternalBug348427TestLanguage.g:657:1: ruleChild2_6 : ( ( rule__Child2_6__Group__0 ) ) ;
    public final void ruleChild2_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:661:2: ( ( ( rule__Child2_6__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:662:1: ( ( rule__Child2_6__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:662:1: ( ( rule__Child2_6__Group__0 ) )
            // InternalBug348427TestLanguage.g:663:1: ( rule__Child2_6__Group__0 )
            {
             before(grammarAccess.getChild2_6Access().getGroup()); 
            // InternalBug348427TestLanguage.g:664:1: ( rule__Child2_6__Group__0 )
            // InternalBug348427TestLanguage.g:664:2: rule__Child2_6__Group__0
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
    // InternalBug348427TestLanguage.g:677:1: ruleEnumType : ( ( rule__EnumType__Alternatives ) ) ;
    public final void ruleEnumType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:681:1: ( ( ( rule__EnumType__Alternatives ) ) )
            // InternalBug348427TestLanguage.g:682:1: ( ( rule__EnumType__Alternatives ) )
            {
            // InternalBug348427TestLanguage.g:682:1: ( ( rule__EnumType__Alternatives ) )
            // InternalBug348427TestLanguage.g:683:1: ( rule__EnumType__Alternatives )
            {
             before(grammarAccess.getEnumTypeAccess().getAlternatives()); 
            // InternalBug348427TestLanguage.g:684:1: ( rule__EnumType__Alternatives )
            // InternalBug348427TestLanguage.g:684:2: rule__EnumType__Alternatives
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
    // InternalBug348427TestLanguage.g:695:1: rule__Model__Alternatives : ( ( ( rule__Model__Element1Assignment_0 ) ) | ( ( rule__Model__Element1Assignment_1 ) ) | ( ( rule__Model__Element1Assignment_2 ) ) | ( ( rule__Model__Element1Assignment_3 ) ) | ( ( rule__Model__Element2Assignment_4 ) ) | ( ( rule__Model__Element2Assignment_5 ) ) | ( ( rule__Model__Element2Assignment_6 ) ) | ( ( rule__Model__Element2Assignment_7 ) ) | ( ( rule__Model__Element2Assignment_8 ) ) | ( ( rule__Model__Element2Assignment_9 ) ) | ( ( rule__Model__Element2Assignment_10 ) ) | ( ( rule__Model__Element2Assignment_11 ) ) );
    public final void rule__Model__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:699:1: ( ( ( rule__Model__Element1Assignment_0 ) ) | ( ( rule__Model__Element1Assignment_1 ) ) | ( ( rule__Model__Element1Assignment_2 ) ) | ( ( rule__Model__Element1Assignment_3 ) ) | ( ( rule__Model__Element2Assignment_4 ) ) | ( ( rule__Model__Element2Assignment_5 ) ) | ( ( rule__Model__Element2Assignment_6 ) ) | ( ( rule__Model__Element2Assignment_7 ) ) | ( ( rule__Model__Element2Assignment_8 ) ) | ( ( rule__Model__Element2Assignment_9 ) ) | ( ( rule__Model__Element2Assignment_10 ) ) | ( ( rule__Model__Element2Assignment_11 ) ) )
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
                    // InternalBug348427TestLanguage.g:700:1: ( ( rule__Model__Element1Assignment_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:700:1: ( ( rule__Model__Element1Assignment_0 ) )
                    // InternalBug348427TestLanguage.g:701:1: ( rule__Model__Element1Assignment_0 )
                    {
                     before(grammarAccess.getModelAccess().getElement1Assignment_0()); 
                    // InternalBug348427TestLanguage.g:702:1: ( rule__Model__Element1Assignment_0 )
                    // InternalBug348427TestLanguage.g:702:2: rule__Model__Element1Assignment_0
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
                    // InternalBug348427TestLanguage.g:706:6: ( ( rule__Model__Element1Assignment_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:706:6: ( ( rule__Model__Element1Assignment_1 ) )
                    // InternalBug348427TestLanguage.g:707:1: ( rule__Model__Element1Assignment_1 )
                    {
                     before(grammarAccess.getModelAccess().getElement1Assignment_1()); 
                    // InternalBug348427TestLanguage.g:708:1: ( rule__Model__Element1Assignment_1 )
                    // InternalBug348427TestLanguage.g:708:2: rule__Model__Element1Assignment_1
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
                    // InternalBug348427TestLanguage.g:712:6: ( ( rule__Model__Element1Assignment_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:712:6: ( ( rule__Model__Element1Assignment_2 ) )
                    // InternalBug348427TestLanguage.g:713:1: ( rule__Model__Element1Assignment_2 )
                    {
                     before(grammarAccess.getModelAccess().getElement1Assignment_2()); 
                    // InternalBug348427TestLanguage.g:714:1: ( rule__Model__Element1Assignment_2 )
                    // InternalBug348427TestLanguage.g:714:2: rule__Model__Element1Assignment_2
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
                    // InternalBug348427TestLanguage.g:718:6: ( ( rule__Model__Element1Assignment_3 ) )
                    {
                    // InternalBug348427TestLanguage.g:718:6: ( ( rule__Model__Element1Assignment_3 ) )
                    // InternalBug348427TestLanguage.g:719:1: ( rule__Model__Element1Assignment_3 )
                    {
                     before(grammarAccess.getModelAccess().getElement1Assignment_3()); 
                    // InternalBug348427TestLanguage.g:720:1: ( rule__Model__Element1Assignment_3 )
                    // InternalBug348427TestLanguage.g:720:2: rule__Model__Element1Assignment_3
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
                    // InternalBug348427TestLanguage.g:724:6: ( ( rule__Model__Element2Assignment_4 ) )
                    {
                    // InternalBug348427TestLanguage.g:724:6: ( ( rule__Model__Element2Assignment_4 ) )
                    // InternalBug348427TestLanguage.g:725:1: ( rule__Model__Element2Assignment_4 )
                    {
                     before(grammarAccess.getModelAccess().getElement2Assignment_4()); 
                    // InternalBug348427TestLanguage.g:726:1: ( rule__Model__Element2Assignment_4 )
                    // InternalBug348427TestLanguage.g:726:2: rule__Model__Element2Assignment_4
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
                    // InternalBug348427TestLanguage.g:730:6: ( ( rule__Model__Element2Assignment_5 ) )
                    {
                    // InternalBug348427TestLanguage.g:730:6: ( ( rule__Model__Element2Assignment_5 ) )
                    // InternalBug348427TestLanguage.g:731:1: ( rule__Model__Element2Assignment_5 )
                    {
                     before(grammarAccess.getModelAccess().getElement2Assignment_5()); 
                    // InternalBug348427TestLanguage.g:732:1: ( rule__Model__Element2Assignment_5 )
                    // InternalBug348427TestLanguage.g:732:2: rule__Model__Element2Assignment_5
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
                    // InternalBug348427TestLanguage.g:736:6: ( ( rule__Model__Element2Assignment_6 ) )
                    {
                    // InternalBug348427TestLanguage.g:736:6: ( ( rule__Model__Element2Assignment_6 ) )
                    // InternalBug348427TestLanguage.g:737:1: ( rule__Model__Element2Assignment_6 )
                    {
                     before(grammarAccess.getModelAccess().getElement2Assignment_6()); 
                    // InternalBug348427TestLanguage.g:738:1: ( rule__Model__Element2Assignment_6 )
                    // InternalBug348427TestLanguage.g:738:2: rule__Model__Element2Assignment_6
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
                    // InternalBug348427TestLanguage.g:742:6: ( ( rule__Model__Element2Assignment_7 ) )
                    {
                    // InternalBug348427TestLanguage.g:742:6: ( ( rule__Model__Element2Assignment_7 ) )
                    // InternalBug348427TestLanguage.g:743:1: ( rule__Model__Element2Assignment_7 )
                    {
                     before(grammarAccess.getModelAccess().getElement2Assignment_7()); 
                    // InternalBug348427TestLanguage.g:744:1: ( rule__Model__Element2Assignment_7 )
                    // InternalBug348427TestLanguage.g:744:2: rule__Model__Element2Assignment_7
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
                    // InternalBug348427TestLanguage.g:748:6: ( ( rule__Model__Element2Assignment_8 ) )
                    {
                    // InternalBug348427TestLanguage.g:748:6: ( ( rule__Model__Element2Assignment_8 ) )
                    // InternalBug348427TestLanguage.g:749:1: ( rule__Model__Element2Assignment_8 )
                    {
                     before(grammarAccess.getModelAccess().getElement2Assignment_8()); 
                    // InternalBug348427TestLanguage.g:750:1: ( rule__Model__Element2Assignment_8 )
                    // InternalBug348427TestLanguage.g:750:2: rule__Model__Element2Assignment_8
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
                    // InternalBug348427TestLanguage.g:754:6: ( ( rule__Model__Element2Assignment_9 ) )
                    {
                    // InternalBug348427TestLanguage.g:754:6: ( ( rule__Model__Element2Assignment_9 ) )
                    // InternalBug348427TestLanguage.g:755:1: ( rule__Model__Element2Assignment_9 )
                    {
                     before(grammarAccess.getModelAccess().getElement2Assignment_9()); 
                    // InternalBug348427TestLanguage.g:756:1: ( rule__Model__Element2Assignment_9 )
                    // InternalBug348427TestLanguage.g:756:2: rule__Model__Element2Assignment_9
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
                    // InternalBug348427TestLanguage.g:760:6: ( ( rule__Model__Element2Assignment_10 ) )
                    {
                    // InternalBug348427TestLanguage.g:760:6: ( ( rule__Model__Element2Assignment_10 ) )
                    // InternalBug348427TestLanguage.g:761:1: ( rule__Model__Element2Assignment_10 )
                    {
                     before(grammarAccess.getModelAccess().getElement2Assignment_10()); 
                    // InternalBug348427TestLanguage.g:762:1: ( rule__Model__Element2Assignment_10 )
                    // InternalBug348427TestLanguage.g:762:2: rule__Model__Element2Assignment_10
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
                    // InternalBug348427TestLanguage.g:766:6: ( ( rule__Model__Element2Assignment_11 ) )
                    {
                    // InternalBug348427TestLanguage.g:766:6: ( ( rule__Model__Element2Assignment_11 ) )
                    // InternalBug348427TestLanguage.g:767:1: ( rule__Model__Element2Assignment_11 )
                    {
                     before(grammarAccess.getModelAccess().getElement2Assignment_11()); 
                    // InternalBug348427TestLanguage.g:768:1: ( rule__Model__Element2Assignment_11 )
                    // InternalBug348427TestLanguage.g:768:2: rule__Model__Element2Assignment_11
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
    // InternalBug348427TestLanguage.g:777:1: rule__Scenario1_1__Alternatives_1 : ( ( ( rule__Scenario1_1__ChildAssignment_1_0 ) ) | ( ( rule__Scenario1_1__ChildAssignment_1_1 ) ) | ( ( rule__Scenario1_1__ChildAssignment_1_2 ) ) );
    public final void rule__Scenario1_1__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:781:1: ( ( ( rule__Scenario1_1__ChildAssignment_1_0 ) ) | ( ( rule__Scenario1_1__ChildAssignment_1_1 ) ) | ( ( rule__Scenario1_1__ChildAssignment_1_2 ) ) )
            int alt2=3;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // InternalBug348427TestLanguage.g:782:1: ( ( rule__Scenario1_1__ChildAssignment_1_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:782:1: ( ( rule__Scenario1_1__ChildAssignment_1_0 ) )
                    // InternalBug348427TestLanguage.g:783:1: ( rule__Scenario1_1__ChildAssignment_1_0 )
                    {
                     before(grammarAccess.getScenario1_1Access().getChildAssignment_1_0()); 
                    // InternalBug348427TestLanguage.g:784:1: ( rule__Scenario1_1__ChildAssignment_1_0 )
                    // InternalBug348427TestLanguage.g:784:2: rule__Scenario1_1__ChildAssignment_1_0
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
                    // InternalBug348427TestLanguage.g:788:6: ( ( rule__Scenario1_1__ChildAssignment_1_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:788:6: ( ( rule__Scenario1_1__ChildAssignment_1_1 ) )
                    // InternalBug348427TestLanguage.g:789:1: ( rule__Scenario1_1__ChildAssignment_1_1 )
                    {
                     before(grammarAccess.getScenario1_1Access().getChildAssignment_1_1()); 
                    // InternalBug348427TestLanguage.g:790:1: ( rule__Scenario1_1__ChildAssignment_1_1 )
                    // InternalBug348427TestLanguage.g:790:2: rule__Scenario1_1__ChildAssignment_1_1
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
                    // InternalBug348427TestLanguage.g:794:6: ( ( rule__Scenario1_1__ChildAssignment_1_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:794:6: ( ( rule__Scenario1_1__ChildAssignment_1_2 ) )
                    // InternalBug348427TestLanguage.g:795:1: ( rule__Scenario1_1__ChildAssignment_1_2 )
                    {
                     before(grammarAccess.getScenario1_1Access().getChildAssignment_1_2()); 
                    // InternalBug348427TestLanguage.g:796:1: ( rule__Scenario1_1__ChildAssignment_1_2 )
                    // InternalBug348427TestLanguage.g:796:2: rule__Scenario1_1__ChildAssignment_1_2
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
    // InternalBug348427TestLanguage.g:805:1: rule__Scenario1_2__Alternatives_1 : ( ( ( rule__Scenario1_2__ChildAssignment_1_0 ) ) | ( ( rule__Scenario1_2__ChildAssignment_1_1 ) ) | ( ( rule__Scenario1_2__ChildAssignment_1_2 ) ) );
    public final void rule__Scenario1_2__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:809:1: ( ( ( rule__Scenario1_2__ChildAssignment_1_0 ) ) | ( ( rule__Scenario1_2__ChildAssignment_1_1 ) ) | ( ( rule__Scenario1_2__ChildAssignment_1_2 ) ) )
            int alt3=3;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // InternalBug348427TestLanguage.g:810:1: ( ( rule__Scenario1_2__ChildAssignment_1_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:810:1: ( ( rule__Scenario1_2__ChildAssignment_1_0 ) )
                    // InternalBug348427TestLanguage.g:811:1: ( rule__Scenario1_2__ChildAssignment_1_0 )
                    {
                     before(grammarAccess.getScenario1_2Access().getChildAssignment_1_0()); 
                    // InternalBug348427TestLanguage.g:812:1: ( rule__Scenario1_2__ChildAssignment_1_0 )
                    // InternalBug348427TestLanguage.g:812:2: rule__Scenario1_2__ChildAssignment_1_0
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
                    // InternalBug348427TestLanguage.g:816:6: ( ( rule__Scenario1_2__ChildAssignment_1_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:816:6: ( ( rule__Scenario1_2__ChildAssignment_1_1 ) )
                    // InternalBug348427TestLanguage.g:817:1: ( rule__Scenario1_2__ChildAssignment_1_1 )
                    {
                     before(grammarAccess.getScenario1_2Access().getChildAssignment_1_1()); 
                    // InternalBug348427TestLanguage.g:818:1: ( rule__Scenario1_2__ChildAssignment_1_1 )
                    // InternalBug348427TestLanguage.g:818:2: rule__Scenario1_2__ChildAssignment_1_1
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
                    // InternalBug348427TestLanguage.g:822:6: ( ( rule__Scenario1_2__ChildAssignment_1_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:822:6: ( ( rule__Scenario1_2__ChildAssignment_1_2 ) )
                    // InternalBug348427TestLanguage.g:823:1: ( rule__Scenario1_2__ChildAssignment_1_2 )
                    {
                     before(grammarAccess.getScenario1_2Access().getChildAssignment_1_2()); 
                    // InternalBug348427TestLanguage.g:824:1: ( rule__Scenario1_2__ChildAssignment_1_2 )
                    // InternalBug348427TestLanguage.g:824:2: rule__Scenario1_2__ChildAssignment_1_2
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
    // InternalBug348427TestLanguage.g:833:1: rule__Scenario1_3__Alternatives_2 : ( ( ( rule__Scenario1_3__ChildAssignment_2_0 ) ) | ( ( rule__Scenario1_3__ChildAssignment_2_1 ) ) | ( ( rule__Scenario1_3__ChildAssignment_2_2 ) ) );
    public final void rule__Scenario1_3__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:837:1: ( ( ( rule__Scenario1_3__ChildAssignment_2_0 ) ) | ( ( rule__Scenario1_3__ChildAssignment_2_1 ) ) | ( ( rule__Scenario1_3__ChildAssignment_2_2 ) ) )
            int alt4=3;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // InternalBug348427TestLanguage.g:838:1: ( ( rule__Scenario1_3__ChildAssignment_2_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:838:1: ( ( rule__Scenario1_3__ChildAssignment_2_0 ) )
                    // InternalBug348427TestLanguage.g:839:1: ( rule__Scenario1_3__ChildAssignment_2_0 )
                    {
                     before(grammarAccess.getScenario1_3Access().getChildAssignment_2_0()); 
                    // InternalBug348427TestLanguage.g:840:1: ( rule__Scenario1_3__ChildAssignment_2_0 )
                    // InternalBug348427TestLanguage.g:840:2: rule__Scenario1_3__ChildAssignment_2_0
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
                    // InternalBug348427TestLanguage.g:844:6: ( ( rule__Scenario1_3__ChildAssignment_2_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:844:6: ( ( rule__Scenario1_3__ChildAssignment_2_1 ) )
                    // InternalBug348427TestLanguage.g:845:1: ( rule__Scenario1_3__ChildAssignment_2_1 )
                    {
                     before(grammarAccess.getScenario1_3Access().getChildAssignment_2_1()); 
                    // InternalBug348427TestLanguage.g:846:1: ( rule__Scenario1_3__ChildAssignment_2_1 )
                    // InternalBug348427TestLanguage.g:846:2: rule__Scenario1_3__ChildAssignment_2_1
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
                    // InternalBug348427TestLanguage.g:850:6: ( ( rule__Scenario1_3__ChildAssignment_2_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:850:6: ( ( rule__Scenario1_3__ChildAssignment_2_2 ) )
                    // InternalBug348427TestLanguage.g:851:1: ( rule__Scenario1_3__ChildAssignment_2_2 )
                    {
                     before(grammarAccess.getScenario1_3Access().getChildAssignment_2_2()); 
                    // InternalBug348427TestLanguage.g:852:1: ( rule__Scenario1_3__ChildAssignment_2_2 )
                    // InternalBug348427TestLanguage.g:852:2: rule__Scenario1_3__ChildAssignment_2_2
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
    // InternalBug348427TestLanguage.g:861:1: rule__Scenario1_4__Alternatives_2 : ( ( ( rule__Scenario1_4__ChildAssignment_2_0 ) ) | ( ( rule__Scenario1_4__ChildAssignment_2_1 ) ) | ( ( rule__Scenario1_4__ChildAssignment_2_2 ) ) );
    public final void rule__Scenario1_4__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:865:1: ( ( ( rule__Scenario1_4__ChildAssignment_2_0 ) ) | ( ( rule__Scenario1_4__ChildAssignment_2_1 ) ) | ( ( rule__Scenario1_4__ChildAssignment_2_2 ) ) )
            int alt5=3;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // InternalBug348427TestLanguage.g:866:1: ( ( rule__Scenario1_4__ChildAssignment_2_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:866:1: ( ( rule__Scenario1_4__ChildAssignment_2_0 ) )
                    // InternalBug348427TestLanguage.g:867:1: ( rule__Scenario1_4__ChildAssignment_2_0 )
                    {
                     before(grammarAccess.getScenario1_4Access().getChildAssignment_2_0()); 
                    // InternalBug348427TestLanguage.g:868:1: ( rule__Scenario1_4__ChildAssignment_2_0 )
                    // InternalBug348427TestLanguage.g:868:2: rule__Scenario1_4__ChildAssignment_2_0
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
                    // InternalBug348427TestLanguage.g:872:6: ( ( rule__Scenario1_4__ChildAssignment_2_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:872:6: ( ( rule__Scenario1_4__ChildAssignment_2_1 ) )
                    // InternalBug348427TestLanguage.g:873:1: ( rule__Scenario1_4__ChildAssignment_2_1 )
                    {
                     before(grammarAccess.getScenario1_4Access().getChildAssignment_2_1()); 
                    // InternalBug348427TestLanguage.g:874:1: ( rule__Scenario1_4__ChildAssignment_2_1 )
                    // InternalBug348427TestLanguage.g:874:2: rule__Scenario1_4__ChildAssignment_2_1
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
                    // InternalBug348427TestLanguage.g:878:6: ( ( rule__Scenario1_4__ChildAssignment_2_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:878:6: ( ( rule__Scenario1_4__ChildAssignment_2_2 ) )
                    // InternalBug348427TestLanguage.g:879:1: ( rule__Scenario1_4__ChildAssignment_2_2 )
                    {
                     before(grammarAccess.getScenario1_4Access().getChildAssignment_2_2()); 
                    // InternalBug348427TestLanguage.g:880:1: ( rule__Scenario1_4__ChildAssignment_2_2 )
                    // InternalBug348427TestLanguage.g:880:2: rule__Scenario1_4__ChildAssignment_2_2
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
    // InternalBug348427TestLanguage.g:889:1: rule__Scenario2_1__Alternatives_1 : ( ( ( rule__Scenario2_1__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_1__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_1__ChildAssignment_1_2 ) ) );
    public final void rule__Scenario2_1__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:893:1: ( ( ( rule__Scenario2_1__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_1__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_1__ChildAssignment_1_2 ) ) )
            int alt6=3;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // InternalBug348427TestLanguage.g:894:1: ( ( rule__Scenario2_1__ChildAssignment_1_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:894:1: ( ( rule__Scenario2_1__ChildAssignment_1_0 ) )
                    // InternalBug348427TestLanguage.g:895:1: ( rule__Scenario2_1__ChildAssignment_1_0 )
                    {
                     before(grammarAccess.getScenario2_1Access().getChildAssignment_1_0()); 
                    // InternalBug348427TestLanguage.g:896:1: ( rule__Scenario2_1__ChildAssignment_1_0 )
                    // InternalBug348427TestLanguage.g:896:2: rule__Scenario2_1__ChildAssignment_1_0
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
                    // InternalBug348427TestLanguage.g:900:6: ( ( rule__Scenario2_1__ChildAssignment_1_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:900:6: ( ( rule__Scenario2_1__ChildAssignment_1_1 ) )
                    // InternalBug348427TestLanguage.g:901:1: ( rule__Scenario2_1__ChildAssignment_1_1 )
                    {
                     before(grammarAccess.getScenario2_1Access().getChildAssignment_1_1()); 
                    // InternalBug348427TestLanguage.g:902:1: ( rule__Scenario2_1__ChildAssignment_1_1 )
                    // InternalBug348427TestLanguage.g:902:2: rule__Scenario2_1__ChildAssignment_1_1
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
                    // InternalBug348427TestLanguage.g:906:6: ( ( rule__Scenario2_1__ChildAssignment_1_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:906:6: ( ( rule__Scenario2_1__ChildAssignment_1_2 ) )
                    // InternalBug348427TestLanguage.g:907:1: ( rule__Scenario2_1__ChildAssignment_1_2 )
                    {
                     before(grammarAccess.getScenario2_1Access().getChildAssignment_1_2()); 
                    // InternalBug348427TestLanguage.g:908:1: ( rule__Scenario2_1__ChildAssignment_1_2 )
                    // InternalBug348427TestLanguage.g:908:2: rule__Scenario2_1__ChildAssignment_1_2
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
    // InternalBug348427TestLanguage.g:917:1: rule__Scenario2_2__Alternatives_1 : ( ( ( rule__Scenario2_2__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_2__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_2__ChildAssignment_1_2 ) ) );
    public final void rule__Scenario2_2__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:921:1: ( ( ( rule__Scenario2_2__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_2__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_2__ChildAssignment_1_2 ) ) )
            int alt7=3;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // InternalBug348427TestLanguage.g:922:1: ( ( rule__Scenario2_2__ChildAssignment_1_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:922:1: ( ( rule__Scenario2_2__ChildAssignment_1_0 ) )
                    // InternalBug348427TestLanguage.g:923:1: ( rule__Scenario2_2__ChildAssignment_1_0 )
                    {
                     before(grammarAccess.getScenario2_2Access().getChildAssignment_1_0()); 
                    // InternalBug348427TestLanguage.g:924:1: ( rule__Scenario2_2__ChildAssignment_1_0 )
                    // InternalBug348427TestLanguage.g:924:2: rule__Scenario2_2__ChildAssignment_1_0
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
                    // InternalBug348427TestLanguage.g:928:6: ( ( rule__Scenario2_2__ChildAssignment_1_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:928:6: ( ( rule__Scenario2_2__ChildAssignment_1_1 ) )
                    // InternalBug348427TestLanguage.g:929:1: ( rule__Scenario2_2__ChildAssignment_1_1 )
                    {
                     before(grammarAccess.getScenario2_2Access().getChildAssignment_1_1()); 
                    // InternalBug348427TestLanguage.g:930:1: ( rule__Scenario2_2__ChildAssignment_1_1 )
                    // InternalBug348427TestLanguage.g:930:2: rule__Scenario2_2__ChildAssignment_1_1
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
                    // InternalBug348427TestLanguage.g:934:6: ( ( rule__Scenario2_2__ChildAssignment_1_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:934:6: ( ( rule__Scenario2_2__ChildAssignment_1_2 ) )
                    // InternalBug348427TestLanguage.g:935:1: ( rule__Scenario2_2__ChildAssignment_1_2 )
                    {
                     before(grammarAccess.getScenario2_2Access().getChildAssignment_1_2()); 
                    // InternalBug348427TestLanguage.g:936:1: ( rule__Scenario2_2__ChildAssignment_1_2 )
                    // InternalBug348427TestLanguage.g:936:2: rule__Scenario2_2__ChildAssignment_1_2
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
    // InternalBug348427TestLanguage.g:945:1: rule__Scenario2_3__Alternatives_1 : ( ( ( rule__Scenario2_3__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_3__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_3__ChildAssignment_1_2 ) ) );
    public final void rule__Scenario2_3__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:949:1: ( ( ( rule__Scenario2_3__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_3__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_3__ChildAssignment_1_2 ) ) )
            int alt8=3;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // InternalBug348427TestLanguage.g:950:1: ( ( rule__Scenario2_3__ChildAssignment_1_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:950:1: ( ( rule__Scenario2_3__ChildAssignment_1_0 ) )
                    // InternalBug348427TestLanguage.g:951:1: ( rule__Scenario2_3__ChildAssignment_1_0 )
                    {
                     before(grammarAccess.getScenario2_3Access().getChildAssignment_1_0()); 
                    // InternalBug348427TestLanguage.g:952:1: ( rule__Scenario2_3__ChildAssignment_1_0 )
                    // InternalBug348427TestLanguage.g:952:2: rule__Scenario2_3__ChildAssignment_1_0
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
                    // InternalBug348427TestLanguage.g:956:6: ( ( rule__Scenario2_3__ChildAssignment_1_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:956:6: ( ( rule__Scenario2_3__ChildAssignment_1_1 ) )
                    // InternalBug348427TestLanguage.g:957:1: ( rule__Scenario2_3__ChildAssignment_1_1 )
                    {
                     before(grammarAccess.getScenario2_3Access().getChildAssignment_1_1()); 
                    // InternalBug348427TestLanguage.g:958:1: ( rule__Scenario2_3__ChildAssignment_1_1 )
                    // InternalBug348427TestLanguage.g:958:2: rule__Scenario2_3__ChildAssignment_1_1
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
                    // InternalBug348427TestLanguage.g:962:6: ( ( rule__Scenario2_3__ChildAssignment_1_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:962:6: ( ( rule__Scenario2_3__ChildAssignment_1_2 ) )
                    // InternalBug348427TestLanguage.g:963:1: ( rule__Scenario2_3__ChildAssignment_1_2 )
                    {
                     before(grammarAccess.getScenario2_3Access().getChildAssignment_1_2()); 
                    // InternalBug348427TestLanguage.g:964:1: ( rule__Scenario2_3__ChildAssignment_1_2 )
                    // InternalBug348427TestLanguage.g:964:2: rule__Scenario2_3__ChildAssignment_1_2
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
    // InternalBug348427TestLanguage.g:973:1: rule__Scenario2_4__Alternatives_1 : ( ( ( rule__Scenario2_4__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_4__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_4__ChildAssignment_1_2 ) ) );
    public final void rule__Scenario2_4__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:977:1: ( ( ( rule__Scenario2_4__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_4__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_4__ChildAssignment_1_2 ) ) )
            int alt9=3;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // InternalBug348427TestLanguage.g:978:1: ( ( rule__Scenario2_4__ChildAssignment_1_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:978:1: ( ( rule__Scenario2_4__ChildAssignment_1_0 ) )
                    // InternalBug348427TestLanguage.g:979:1: ( rule__Scenario2_4__ChildAssignment_1_0 )
                    {
                     before(grammarAccess.getScenario2_4Access().getChildAssignment_1_0()); 
                    // InternalBug348427TestLanguage.g:980:1: ( rule__Scenario2_4__ChildAssignment_1_0 )
                    // InternalBug348427TestLanguage.g:980:2: rule__Scenario2_4__ChildAssignment_1_0
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
                    // InternalBug348427TestLanguage.g:984:6: ( ( rule__Scenario2_4__ChildAssignment_1_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:984:6: ( ( rule__Scenario2_4__ChildAssignment_1_1 ) )
                    // InternalBug348427TestLanguage.g:985:1: ( rule__Scenario2_4__ChildAssignment_1_1 )
                    {
                     before(grammarAccess.getScenario2_4Access().getChildAssignment_1_1()); 
                    // InternalBug348427TestLanguage.g:986:1: ( rule__Scenario2_4__ChildAssignment_1_1 )
                    // InternalBug348427TestLanguage.g:986:2: rule__Scenario2_4__ChildAssignment_1_1
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
                    // InternalBug348427TestLanguage.g:990:6: ( ( rule__Scenario2_4__ChildAssignment_1_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:990:6: ( ( rule__Scenario2_4__ChildAssignment_1_2 ) )
                    // InternalBug348427TestLanguage.g:991:1: ( rule__Scenario2_4__ChildAssignment_1_2 )
                    {
                     before(grammarAccess.getScenario2_4Access().getChildAssignment_1_2()); 
                    // InternalBug348427TestLanguage.g:992:1: ( rule__Scenario2_4__ChildAssignment_1_2 )
                    // InternalBug348427TestLanguage.g:992:2: rule__Scenario2_4__ChildAssignment_1_2
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
    // InternalBug348427TestLanguage.g:1001:1: rule__Scenario2_5__Alternatives_2 : ( ( ( rule__Scenario2_5__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_5__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_5__ChildAssignment_2_2 ) ) );
    public final void rule__Scenario2_5__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1005:1: ( ( ( rule__Scenario2_5__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_5__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_5__ChildAssignment_2_2 ) ) )
            int alt10=3;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // InternalBug348427TestLanguage.g:1006:1: ( ( rule__Scenario2_5__ChildAssignment_2_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:1006:1: ( ( rule__Scenario2_5__ChildAssignment_2_0 ) )
                    // InternalBug348427TestLanguage.g:1007:1: ( rule__Scenario2_5__ChildAssignment_2_0 )
                    {
                     before(grammarAccess.getScenario2_5Access().getChildAssignment_2_0()); 
                    // InternalBug348427TestLanguage.g:1008:1: ( rule__Scenario2_5__ChildAssignment_2_0 )
                    // InternalBug348427TestLanguage.g:1008:2: rule__Scenario2_5__ChildAssignment_2_0
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
                    // InternalBug348427TestLanguage.g:1012:6: ( ( rule__Scenario2_5__ChildAssignment_2_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:1012:6: ( ( rule__Scenario2_5__ChildAssignment_2_1 ) )
                    // InternalBug348427TestLanguage.g:1013:1: ( rule__Scenario2_5__ChildAssignment_2_1 )
                    {
                     before(grammarAccess.getScenario2_5Access().getChildAssignment_2_1()); 
                    // InternalBug348427TestLanguage.g:1014:1: ( rule__Scenario2_5__ChildAssignment_2_1 )
                    // InternalBug348427TestLanguage.g:1014:2: rule__Scenario2_5__ChildAssignment_2_1
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
                    // InternalBug348427TestLanguage.g:1018:6: ( ( rule__Scenario2_5__ChildAssignment_2_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:1018:6: ( ( rule__Scenario2_5__ChildAssignment_2_2 ) )
                    // InternalBug348427TestLanguage.g:1019:1: ( rule__Scenario2_5__ChildAssignment_2_2 )
                    {
                     before(grammarAccess.getScenario2_5Access().getChildAssignment_2_2()); 
                    // InternalBug348427TestLanguage.g:1020:1: ( rule__Scenario2_5__ChildAssignment_2_2 )
                    // InternalBug348427TestLanguage.g:1020:2: rule__Scenario2_5__ChildAssignment_2_2
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
    // InternalBug348427TestLanguage.g:1029:1: rule__Scenario2_6__Alternatives_2 : ( ( ( rule__Scenario2_6__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_6__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_6__ChildAssignment_2_2 ) ) );
    public final void rule__Scenario2_6__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1033:1: ( ( ( rule__Scenario2_6__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_6__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_6__ChildAssignment_2_2 ) ) )
            int alt11=3;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // InternalBug348427TestLanguage.g:1034:1: ( ( rule__Scenario2_6__ChildAssignment_2_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:1034:1: ( ( rule__Scenario2_6__ChildAssignment_2_0 ) )
                    // InternalBug348427TestLanguage.g:1035:1: ( rule__Scenario2_6__ChildAssignment_2_0 )
                    {
                     before(grammarAccess.getScenario2_6Access().getChildAssignment_2_0()); 
                    // InternalBug348427TestLanguage.g:1036:1: ( rule__Scenario2_6__ChildAssignment_2_0 )
                    // InternalBug348427TestLanguage.g:1036:2: rule__Scenario2_6__ChildAssignment_2_0
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
                    // InternalBug348427TestLanguage.g:1040:6: ( ( rule__Scenario2_6__ChildAssignment_2_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:1040:6: ( ( rule__Scenario2_6__ChildAssignment_2_1 ) )
                    // InternalBug348427TestLanguage.g:1041:1: ( rule__Scenario2_6__ChildAssignment_2_1 )
                    {
                     before(grammarAccess.getScenario2_6Access().getChildAssignment_2_1()); 
                    // InternalBug348427TestLanguage.g:1042:1: ( rule__Scenario2_6__ChildAssignment_2_1 )
                    // InternalBug348427TestLanguage.g:1042:2: rule__Scenario2_6__ChildAssignment_2_1
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
                    // InternalBug348427TestLanguage.g:1046:6: ( ( rule__Scenario2_6__ChildAssignment_2_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:1046:6: ( ( rule__Scenario2_6__ChildAssignment_2_2 ) )
                    // InternalBug348427TestLanguage.g:1047:1: ( rule__Scenario2_6__ChildAssignment_2_2 )
                    {
                     before(grammarAccess.getScenario2_6Access().getChildAssignment_2_2()); 
                    // InternalBug348427TestLanguage.g:1048:1: ( rule__Scenario2_6__ChildAssignment_2_2 )
                    // InternalBug348427TestLanguage.g:1048:2: rule__Scenario2_6__ChildAssignment_2_2
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
    // InternalBug348427TestLanguage.g:1057:1: rule__Scenario2_7__Alternatives_2 : ( ( ( rule__Scenario2_7__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_7__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_7__ChildAssignment_2_2 ) ) );
    public final void rule__Scenario2_7__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1061:1: ( ( ( rule__Scenario2_7__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_7__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_7__ChildAssignment_2_2 ) ) )
            int alt12=3;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // InternalBug348427TestLanguage.g:1062:1: ( ( rule__Scenario2_7__ChildAssignment_2_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:1062:1: ( ( rule__Scenario2_7__ChildAssignment_2_0 ) )
                    // InternalBug348427TestLanguage.g:1063:1: ( rule__Scenario2_7__ChildAssignment_2_0 )
                    {
                     before(grammarAccess.getScenario2_7Access().getChildAssignment_2_0()); 
                    // InternalBug348427TestLanguage.g:1064:1: ( rule__Scenario2_7__ChildAssignment_2_0 )
                    // InternalBug348427TestLanguage.g:1064:2: rule__Scenario2_7__ChildAssignment_2_0
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
                    // InternalBug348427TestLanguage.g:1068:6: ( ( rule__Scenario2_7__ChildAssignment_2_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:1068:6: ( ( rule__Scenario2_7__ChildAssignment_2_1 ) )
                    // InternalBug348427TestLanguage.g:1069:1: ( rule__Scenario2_7__ChildAssignment_2_1 )
                    {
                     before(grammarAccess.getScenario2_7Access().getChildAssignment_2_1()); 
                    // InternalBug348427TestLanguage.g:1070:1: ( rule__Scenario2_7__ChildAssignment_2_1 )
                    // InternalBug348427TestLanguage.g:1070:2: rule__Scenario2_7__ChildAssignment_2_1
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
                    // InternalBug348427TestLanguage.g:1074:6: ( ( rule__Scenario2_7__ChildAssignment_2_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:1074:6: ( ( rule__Scenario2_7__ChildAssignment_2_2 ) )
                    // InternalBug348427TestLanguage.g:1075:1: ( rule__Scenario2_7__ChildAssignment_2_2 )
                    {
                     before(grammarAccess.getScenario2_7Access().getChildAssignment_2_2()); 
                    // InternalBug348427TestLanguage.g:1076:1: ( rule__Scenario2_7__ChildAssignment_2_2 )
                    // InternalBug348427TestLanguage.g:1076:2: rule__Scenario2_7__ChildAssignment_2_2
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
    // InternalBug348427TestLanguage.g:1085:1: rule__Scenario2_8__Alternatives_2 : ( ( ( rule__Scenario2_8__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_8__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_8__ChildAssignment_2_2 ) ) );
    public final void rule__Scenario2_8__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1089:1: ( ( ( rule__Scenario2_8__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_8__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_8__ChildAssignment_2_2 ) ) )
            int alt13=3;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // InternalBug348427TestLanguage.g:1090:1: ( ( rule__Scenario2_8__ChildAssignment_2_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:1090:1: ( ( rule__Scenario2_8__ChildAssignment_2_0 ) )
                    // InternalBug348427TestLanguage.g:1091:1: ( rule__Scenario2_8__ChildAssignment_2_0 )
                    {
                     before(grammarAccess.getScenario2_8Access().getChildAssignment_2_0()); 
                    // InternalBug348427TestLanguage.g:1092:1: ( rule__Scenario2_8__ChildAssignment_2_0 )
                    // InternalBug348427TestLanguage.g:1092:2: rule__Scenario2_8__ChildAssignment_2_0
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
                    // InternalBug348427TestLanguage.g:1096:6: ( ( rule__Scenario2_8__ChildAssignment_2_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:1096:6: ( ( rule__Scenario2_8__ChildAssignment_2_1 ) )
                    // InternalBug348427TestLanguage.g:1097:1: ( rule__Scenario2_8__ChildAssignment_2_1 )
                    {
                     before(grammarAccess.getScenario2_8Access().getChildAssignment_2_1()); 
                    // InternalBug348427TestLanguage.g:1098:1: ( rule__Scenario2_8__ChildAssignment_2_1 )
                    // InternalBug348427TestLanguage.g:1098:2: rule__Scenario2_8__ChildAssignment_2_1
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
                    // InternalBug348427TestLanguage.g:1102:6: ( ( rule__Scenario2_8__ChildAssignment_2_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:1102:6: ( ( rule__Scenario2_8__ChildAssignment_2_2 ) )
                    // InternalBug348427TestLanguage.g:1103:1: ( rule__Scenario2_8__ChildAssignment_2_2 )
                    {
                     before(grammarAccess.getScenario2_8Access().getChildAssignment_2_2()); 
                    // InternalBug348427TestLanguage.g:1104:1: ( rule__Scenario2_8__ChildAssignment_2_2 )
                    // InternalBug348427TestLanguage.g:1104:2: rule__Scenario2_8__ChildAssignment_2_2
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
    // InternalBug348427TestLanguage.g:1113:1: rule__Child2_1__StringAlternatives_3_0 : ( ( 'a' ) | ( 'b' ) );
    public final void rule__Child2_1__StringAlternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1117:1: ( ( 'a' ) | ( 'b' ) )
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
                    // InternalBug348427TestLanguage.g:1118:1: ( 'a' )
                    {
                    // InternalBug348427TestLanguage.g:1118:1: ( 'a' )
                    // InternalBug348427TestLanguage.g:1119:1: 'a'
                    {
                     before(grammarAccess.getChild2_1Access().getStringAKeyword_3_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getChild2_1Access().getStringAKeyword_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug348427TestLanguage.g:1126:6: ( 'b' )
                    {
                    // InternalBug348427TestLanguage.g:1126:6: ( 'b' )
                    // InternalBug348427TestLanguage.g:1127:1: 'b'
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
    // InternalBug348427TestLanguage.g:1139:1: rule__Child2_2__StringAlternatives_3_0 : ( ( 'a' ) | ( 'b' ) );
    public final void rule__Child2_2__StringAlternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1143:1: ( ( 'a' ) | ( 'b' ) )
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
                    // InternalBug348427TestLanguage.g:1144:1: ( 'a' )
                    {
                    // InternalBug348427TestLanguage.g:1144:1: ( 'a' )
                    // InternalBug348427TestLanguage.g:1145:1: 'a'
                    {
                     before(grammarAccess.getChild2_2Access().getStringAKeyword_3_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getChild2_2Access().getStringAKeyword_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug348427TestLanguage.g:1152:6: ( 'b' )
                    {
                    // InternalBug348427TestLanguage.g:1152:6: ( 'b' )
                    // InternalBug348427TestLanguage.g:1153:1: 'b'
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
    // InternalBug348427TestLanguage.g:1165:1: rule__Child2_3__StringAlternatives_3_0 : ( ( 'a' ) | ( 'b' ) );
    public final void rule__Child2_3__StringAlternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1169:1: ( ( 'a' ) | ( 'b' ) )
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
                    // InternalBug348427TestLanguage.g:1170:1: ( 'a' )
                    {
                    // InternalBug348427TestLanguage.g:1170:1: ( 'a' )
                    // InternalBug348427TestLanguage.g:1171:1: 'a'
                    {
                     before(grammarAccess.getChild2_3Access().getStringAKeyword_3_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getChild2_3Access().getStringAKeyword_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug348427TestLanguage.g:1178:6: ( 'b' )
                    {
                    // InternalBug348427TestLanguage.g:1178:6: ( 'b' )
                    // InternalBug348427TestLanguage.g:1179:1: 'b'
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
    // InternalBug348427TestLanguage.g:1191:1: rule__Child2_4__Alternatives_3 : ( ( ( rule__Child2_4__StringAssignment_3_0 ) ) | ( ( rule__Child2_4__StringAssignment_3_1 ) ) );
    public final void rule__Child2_4__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1195:1: ( ( ( rule__Child2_4__StringAssignment_3_0 ) ) | ( ( rule__Child2_4__StringAssignment_3_1 ) ) )
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
                    // InternalBug348427TestLanguage.g:1196:1: ( ( rule__Child2_4__StringAssignment_3_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:1196:1: ( ( rule__Child2_4__StringAssignment_3_0 ) )
                    // InternalBug348427TestLanguage.g:1197:1: ( rule__Child2_4__StringAssignment_3_0 )
                    {
                     before(grammarAccess.getChild2_4Access().getStringAssignment_3_0()); 
                    // InternalBug348427TestLanguage.g:1198:1: ( rule__Child2_4__StringAssignment_3_0 )
                    // InternalBug348427TestLanguage.g:1198:2: rule__Child2_4__StringAssignment_3_0
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
                    // InternalBug348427TestLanguage.g:1202:6: ( ( rule__Child2_4__StringAssignment_3_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:1202:6: ( ( rule__Child2_4__StringAssignment_3_1 ) )
                    // InternalBug348427TestLanguage.g:1203:1: ( rule__Child2_4__StringAssignment_3_1 )
                    {
                     before(grammarAccess.getChild2_4Access().getStringAssignment_3_1()); 
                    // InternalBug348427TestLanguage.g:1204:1: ( rule__Child2_4__StringAssignment_3_1 )
                    // InternalBug348427TestLanguage.g:1204:2: rule__Child2_4__StringAssignment_3_1
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
    // InternalBug348427TestLanguage.g:1213:1: rule__Child2_5__Alternatives_3 : ( ( ( rule__Child2_5__StringAssignment_3_0 ) ) | ( ( rule__Child2_5__StringAssignment_3_1 ) ) );
    public final void rule__Child2_5__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1217:1: ( ( ( rule__Child2_5__StringAssignment_3_0 ) ) | ( ( rule__Child2_5__StringAssignment_3_1 ) ) )
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
                    // InternalBug348427TestLanguage.g:1218:1: ( ( rule__Child2_5__StringAssignment_3_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:1218:1: ( ( rule__Child2_5__StringAssignment_3_0 ) )
                    // InternalBug348427TestLanguage.g:1219:1: ( rule__Child2_5__StringAssignment_3_0 )
                    {
                     before(grammarAccess.getChild2_5Access().getStringAssignment_3_0()); 
                    // InternalBug348427TestLanguage.g:1220:1: ( rule__Child2_5__StringAssignment_3_0 )
                    // InternalBug348427TestLanguage.g:1220:2: rule__Child2_5__StringAssignment_3_0
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
                    // InternalBug348427TestLanguage.g:1224:6: ( ( rule__Child2_5__StringAssignment_3_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:1224:6: ( ( rule__Child2_5__StringAssignment_3_1 ) )
                    // InternalBug348427TestLanguage.g:1225:1: ( rule__Child2_5__StringAssignment_3_1 )
                    {
                     before(grammarAccess.getChild2_5Access().getStringAssignment_3_1()); 
                    // InternalBug348427TestLanguage.g:1226:1: ( rule__Child2_5__StringAssignment_3_1 )
                    // InternalBug348427TestLanguage.g:1226:2: rule__Child2_5__StringAssignment_3_1
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
    // InternalBug348427TestLanguage.g:1235:1: rule__Child2_6__Alternatives_3 : ( ( ( rule__Child2_6__StringAssignment_3_0 ) ) | ( ( rule__Child2_6__StringAssignment_3_1 ) ) );
    public final void rule__Child2_6__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1239:1: ( ( ( rule__Child2_6__StringAssignment_3_0 ) ) | ( ( rule__Child2_6__StringAssignment_3_1 ) ) )
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
                    // InternalBug348427TestLanguage.g:1240:1: ( ( rule__Child2_6__StringAssignment_3_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:1240:1: ( ( rule__Child2_6__StringAssignment_3_0 ) )
                    // InternalBug348427TestLanguage.g:1241:1: ( rule__Child2_6__StringAssignment_3_0 )
                    {
                     before(grammarAccess.getChild2_6Access().getStringAssignment_3_0()); 
                    // InternalBug348427TestLanguage.g:1242:1: ( rule__Child2_6__StringAssignment_3_0 )
                    // InternalBug348427TestLanguage.g:1242:2: rule__Child2_6__StringAssignment_3_0
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
                    // InternalBug348427TestLanguage.g:1246:6: ( ( rule__Child2_6__StringAssignment_3_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:1246:6: ( ( rule__Child2_6__StringAssignment_3_1 ) )
                    // InternalBug348427TestLanguage.g:1247:1: ( rule__Child2_6__StringAssignment_3_1 )
                    {
                     before(grammarAccess.getChild2_6Access().getStringAssignment_3_1()); 
                    // InternalBug348427TestLanguage.g:1248:1: ( rule__Child2_6__StringAssignment_3_1 )
                    // InternalBug348427TestLanguage.g:1248:2: rule__Child2_6__StringAssignment_3_1
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
    // InternalBug348427TestLanguage.g:1257:1: rule__EnumType__Alternatives : ( ( ( 'a' ) ) | ( ( 'b' ) ) );
    public final void rule__EnumType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1261:1: ( ( ( 'a' ) ) | ( ( 'b' ) ) )
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
                    // InternalBug348427TestLanguage.g:1262:1: ( ( 'a' ) )
                    {
                    // InternalBug348427TestLanguage.g:1262:1: ( ( 'a' ) )
                    // InternalBug348427TestLanguage.g:1263:1: ( 'a' )
                    {
                     before(grammarAccess.getEnumTypeAccess().getAEnumLiteralDeclaration_0()); 
                    // InternalBug348427TestLanguage.g:1264:1: ( 'a' )
                    // InternalBug348427TestLanguage.g:1264:3: 'a'
                    {
                    match(input,11,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getEnumTypeAccess().getAEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug348427TestLanguage.g:1269:6: ( ( 'b' ) )
                    {
                    // InternalBug348427TestLanguage.g:1269:6: ( ( 'b' ) )
                    // InternalBug348427TestLanguage.g:1270:1: ( 'b' )
                    {
                     before(grammarAccess.getEnumTypeAccess().getBEnumLiteralDeclaration_1()); 
                    // InternalBug348427TestLanguage.g:1271:1: ( 'b' )
                    // InternalBug348427TestLanguage.g:1271:3: 'b'
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
    // InternalBug348427TestLanguage.g:1283:1: rule__Scenario1_1__Group__0 : rule__Scenario1_1__Group__0__Impl rule__Scenario1_1__Group__1 ;
    public final void rule__Scenario1_1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1287:1: ( rule__Scenario1_1__Group__0__Impl rule__Scenario1_1__Group__1 )
            // InternalBug348427TestLanguage.g:1288:2: rule__Scenario1_1__Group__0__Impl rule__Scenario1_1__Group__1
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
    // InternalBug348427TestLanguage.g:1295:1: rule__Scenario1_1__Group__0__Impl : ( '1.1' ) ;
    public final void rule__Scenario1_1__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1299:1: ( ( '1.1' ) )
            // InternalBug348427TestLanguage.g:1300:1: ( '1.1' )
            {
            // InternalBug348427TestLanguage.g:1300:1: ( '1.1' )
            // InternalBug348427TestLanguage.g:1301:1: '1.1'
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
    // InternalBug348427TestLanguage.g:1314:1: rule__Scenario1_1__Group__1 : rule__Scenario1_1__Group__1__Impl rule__Scenario1_1__Group__2 ;
    public final void rule__Scenario1_1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1318:1: ( rule__Scenario1_1__Group__1__Impl rule__Scenario1_1__Group__2 )
            // InternalBug348427TestLanguage.g:1319:2: rule__Scenario1_1__Group__1__Impl rule__Scenario1_1__Group__2
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
    // InternalBug348427TestLanguage.g:1326:1: rule__Scenario1_1__Group__1__Impl : ( ( rule__Scenario1_1__Alternatives_1 ) ) ;
    public final void rule__Scenario1_1__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1330:1: ( ( ( rule__Scenario1_1__Alternatives_1 ) ) )
            // InternalBug348427TestLanguage.g:1331:1: ( ( rule__Scenario1_1__Alternatives_1 ) )
            {
            // InternalBug348427TestLanguage.g:1331:1: ( ( rule__Scenario1_1__Alternatives_1 ) )
            // InternalBug348427TestLanguage.g:1332:1: ( rule__Scenario1_1__Alternatives_1 )
            {
             before(grammarAccess.getScenario1_1Access().getAlternatives_1()); 
            // InternalBug348427TestLanguage.g:1333:1: ( rule__Scenario1_1__Alternatives_1 )
            // InternalBug348427TestLanguage.g:1333:2: rule__Scenario1_1__Alternatives_1
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
    // InternalBug348427TestLanguage.g:1343:1: rule__Scenario1_1__Group__2 : rule__Scenario1_1__Group__2__Impl ;
    public final void rule__Scenario1_1__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1347:1: ( rule__Scenario1_1__Group__2__Impl )
            // InternalBug348427TestLanguage.g:1348:2: rule__Scenario1_1__Group__2__Impl
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
    // InternalBug348427TestLanguage.g:1354:1: rule__Scenario1_1__Group__2__Impl : ( 'next' ) ;
    public final void rule__Scenario1_1__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1358:1: ( ( 'next' ) )
            // InternalBug348427TestLanguage.g:1359:1: ( 'next' )
            {
            // InternalBug348427TestLanguage.g:1359:1: ( 'next' )
            // InternalBug348427TestLanguage.g:1360:1: 'next'
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
    // InternalBug348427TestLanguage.g:1379:1: rule__Scenario1_2__Group__0 : rule__Scenario1_2__Group__0__Impl rule__Scenario1_2__Group__1 ;
    public final void rule__Scenario1_2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1383:1: ( rule__Scenario1_2__Group__0__Impl rule__Scenario1_2__Group__1 )
            // InternalBug348427TestLanguage.g:1384:2: rule__Scenario1_2__Group__0__Impl rule__Scenario1_2__Group__1
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
    // InternalBug348427TestLanguage.g:1391:1: rule__Scenario1_2__Group__0__Impl : ( '1.2' ) ;
    public final void rule__Scenario1_2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1395:1: ( ( '1.2' ) )
            // InternalBug348427TestLanguage.g:1396:1: ( '1.2' )
            {
            // InternalBug348427TestLanguage.g:1396:1: ( '1.2' )
            // InternalBug348427TestLanguage.g:1397:1: '1.2'
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
    // InternalBug348427TestLanguage.g:1410:1: rule__Scenario1_2__Group__1 : rule__Scenario1_2__Group__1__Impl rule__Scenario1_2__Group__2 ;
    public final void rule__Scenario1_2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1414:1: ( rule__Scenario1_2__Group__1__Impl rule__Scenario1_2__Group__2 )
            // InternalBug348427TestLanguage.g:1415:2: rule__Scenario1_2__Group__1__Impl rule__Scenario1_2__Group__2
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
    // InternalBug348427TestLanguage.g:1422:1: rule__Scenario1_2__Group__1__Impl : ( ( ( rule__Scenario1_2__Alternatives_1 ) ) ( ( rule__Scenario1_2__Alternatives_1 )* ) ) ;
    public final void rule__Scenario1_2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1426:1: ( ( ( ( rule__Scenario1_2__Alternatives_1 ) ) ( ( rule__Scenario1_2__Alternatives_1 )* ) ) )
            // InternalBug348427TestLanguage.g:1427:1: ( ( ( rule__Scenario1_2__Alternatives_1 ) ) ( ( rule__Scenario1_2__Alternatives_1 )* ) )
            {
            // InternalBug348427TestLanguage.g:1427:1: ( ( ( rule__Scenario1_2__Alternatives_1 ) ) ( ( rule__Scenario1_2__Alternatives_1 )* ) )
            // InternalBug348427TestLanguage.g:1428:1: ( ( rule__Scenario1_2__Alternatives_1 ) ) ( ( rule__Scenario1_2__Alternatives_1 )* )
            {
            // InternalBug348427TestLanguage.g:1428:1: ( ( rule__Scenario1_2__Alternatives_1 ) )
            // InternalBug348427TestLanguage.g:1429:1: ( rule__Scenario1_2__Alternatives_1 )
            {
             before(grammarAccess.getScenario1_2Access().getAlternatives_1()); 
            // InternalBug348427TestLanguage.g:1430:1: ( rule__Scenario1_2__Alternatives_1 )
            // InternalBug348427TestLanguage.g:1430:2: rule__Scenario1_2__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Scenario1_2__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getScenario1_2Access().getAlternatives_1()); 

            }

            // InternalBug348427TestLanguage.g:1433:1: ( ( rule__Scenario1_2__Alternatives_1 )* )
            // InternalBug348427TestLanguage.g:1434:1: ( rule__Scenario1_2__Alternatives_1 )*
            {
             before(grammarAccess.getScenario1_2Access().getAlternatives_1()); 
            // InternalBug348427TestLanguage.g:1435:1: ( rule__Scenario1_2__Alternatives_1 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_ID) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalBug348427TestLanguage.g:1435:2: rule__Scenario1_2__Alternatives_1
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
    // InternalBug348427TestLanguage.g:1446:1: rule__Scenario1_2__Group__2 : rule__Scenario1_2__Group__2__Impl ;
    public final void rule__Scenario1_2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1450:1: ( rule__Scenario1_2__Group__2__Impl )
            // InternalBug348427TestLanguage.g:1451:2: rule__Scenario1_2__Group__2__Impl
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
    // InternalBug348427TestLanguage.g:1457:1: rule__Scenario1_2__Group__2__Impl : ( 'next' ) ;
    public final void rule__Scenario1_2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1461:1: ( ( 'next' ) )
            // InternalBug348427TestLanguage.g:1462:1: ( 'next' )
            {
            // InternalBug348427TestLanguage.g:1462:1: ( 'next' )
            // InternalBug348427TestLanguage.g:1463:1: 'next'
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
    // InternalBug348427TestLanguage.g:1482:1: rule__Scenario1_3__Group__0 : rule__Scenario1_3__Group__0__Impl rule__Scenario1_3__Group__1 ;
    public final void rule__Scenario1_3__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1486:1: ( rule__Scenario1_3__Group__0__Impl rule__Scenario1_3__Group__1 )
            // InternalBug348427TestLanguage.g:1487:2: rule__Scenario1_3__Group__0__Impl rule__Scenario1_3__Group__1
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
    // InternalBug348427TestLanguage.g:1494:1: rule__Scenario1_3__Group__0__Impl : ( () ) ;
    public final void rule__Scenario1_3__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1498:1: ( ( () ) )
            // InternalBug348427TestLanguage.g:1499:1: ( () )
            {
            // InternalBug348427TestLanguage.g:1499:1: ( () )
            // InternalBug348427TestLanguage.g:1500:1: ()
            {
             before(grammarAccess.getScenario1_3Access().getScenario1Action_0()); 
            // InternalBug348427TestLanguage.g:1501:1: ()
            // InternalBug348427TestLanguage.g:1503:1: 
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
    // InternalBug348427TestLanguage.g:1513:1: rule__Scenario1_3__Group__1 : rule__Scenario1_3__Group__1__Impl rule__Scenario1_3__Group__2 ;
    public final void rule__Scenario1_3__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1517:1: ( rule__Scenario1_3__Group__1__Impl rule__Scenario1_3__Group__2 )
            // InternalBug348427TestLanguage.g:1518:2: rule__Scenario1_3__Group__1__Impl rule__Scenario1_3__Group__2
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
    // InternalBug348427TestLanguage.g:1525:1: rule__Scenario1_3__Group__1__Impl : ( '1.3' ) ;
    public final void rule__Scenario1_3__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1529:1: ( ( '1.3' ) )
            // InternalBug348427TestLanguage.g:1530:1: ( '1.3' )
            {
            // InternalBug348427TestLanguage.g:1530:1: ( '1.3' )
            // InternalBug348427TestLanguage.g:1531:1: '1.3'
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
    // InternalBug348427TestLanguage.g:1544:1: rule__Scenario1_3__Group__2 : rule__Scenario1_3__Group__2__Impl rule__Scenario1_3__Group__3 ;
    public final void rule__Scenario1_3__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1548:1: ( rule__Scenario1_3__Group__2__Impl rule__Scenario1_3__Group__3 )
            // InternalBug348427TestLanguage.g:1549:2: rule__Scenario1_3__Group__2__Impl rule__Scenario1_3__Group__3
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
    // InternalBug348427TestLanguage.g:1556:1: rule__Scenario1_3__Group__2__Impl : ( ( rule__Scenario1_3__Alternatives_2 )* ) ;
    public final void rule__Scenario1_3__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1560:1: ( ( ( rule__Scenario1_3__Alternatives_2 )* ) )
            // InternalBug348427TestLanguage.g:1561:1: ( ( rule__Scenario1_3__Alternatives_2 )* )
            {
            // InternalBug348427TestLanguage.g:1561:1: ( ( rule__Scenario1_3__Alternatives_2 )* )
            // InternalBug348427TestLanguage.g:1562:1: ( rule__Scenario1_3__Alternatives_2 )*
            {
             before(grammarAccess.getScenario1_3Access().getAlternatives_2()); 
            // InternalBug348427TestLanguage.g:1563:1: ( rule__Scenario1_3__Alternatives_2 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_ID) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalBug348427TestLanguage.g:1563:2: rule__Scenario1_3__Alternatives_2
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
    // InternalBug348427TestLanguage.g:1573:1: rule__Scenario1_3__Group__3 : rule__Scenario1_3__Group__3__Impl ;
    public final void rule__Scenario1_3__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1577:1: ( rule__Scenario1_3__Group__3__Impl )
            // InternalBug348427TestLanguage.g:1578:2: rule__Scenario1_3__Group__3__Impl
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
    // InternalBug348427TestLanguage.g:1584:1: rule__Scenario1_3__Group__3__Impl : ( 'next' ) ;
    public final void rule__Scenario1_3__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1588:1: ( ( 'next' ) )
            // InternalBug348427TestLanguage.g:1589:1: ( 'next' )
            {
            // InternalBug348427TestLanguage.g:1589:1: ( 'next' )
            // InternalBug348427TestLanguage.g:1590:1: 'next'
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
    // InternalBug348427TestLanguage.g:1611:1: rule__Scenario1_4__Group__0 : rule__Scenario1_4__Group__0__Impl rule__Scenario1_4__Group__1 ;
    public final void rule__Scenario1_4__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1615:1: ( rule__Scenario1_4__Group__0__Impl rule__Scenario1_4__Group__1 )
            // InternalBug348427TestLanguage.g:1616:2: rule__Scenario1_4__Group__0__Impl rule__Scenario1_4__Group__1
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
    // InternalBug348427TestLanguage.g:1623:1: rule__Scenario1_4__Group__0__Impl : ( () ) ;
    public final void rule__Scenario1_4__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1627:1: ( ( () ) )
            // InternalBug348427TestLanguage.g:1628:1: ( () )
            {
            // InternalBug348427TestLanguage.g:1628:1: ( () )
            // InternalBug348427TestLanguage.g:1629:1: ()
            {
             before(grammarAccess.getScenario1_4Access().getScenario1Action_0()); 
            // InternalBug348427TestLanguage.g:1630:1: ()
            // InternalBug348427TestLanguage.g:1632:1: 
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
    // InternalBug348427TestLanguage.g:1642:1: rule__Scenario1_4__Group__1 : rule__Scenario1_4__Group__1__Impl rule__Scenario1_4__Group__2 ;
    public final void rule__Scenario1_4__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1646:1: ( rule__Scenario1_4__Group__1__Impl rule__Scenario1_4__Group__2 )
            // InternalBug348427TestLanguage.g:1647:2: rule__Scenario1_4__Group__1__Impl rule__Scenario1_4__Group__2
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
    // InternalBug348427TestLanguage.g:1654:1: rule__Scenario1_4__Group__1__Impl : ( '1.4' ) ;
    public final void rule__Scenario1_4__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1658:1: ( ( '1.4' ) )
            // InternalBug348427TestLanguage.g:1659:1: ( '1.4' )
            {
            // InternalBug348427TestLanguage.g:1659:1: ( '1.4' )
            // InternalBug348427TestLanguage.g:1660:1: '1.4'
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
    // InternalBug348427TestLanguage.g:1673:1: rule__Scenario1_4__Group__2 : rule__Scenario1_4__Group__2__Impl rule__Scenario1_4__Group__3 ;
    public final void rule__Scenario1_4__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1677:1: ( rule__Scenario1_4__Group__2__Impl rule__Scenario1_4__Group__3 )
            // InternalBug348427TestLanguage.g:1678:2: rule__Scenario1_4__Group__2__Impl rule__Scenario1_4__Group__3
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
    // InternalBug348427TestLanguage.g:1685:1: rule__Scenario1_4__Group__2__Impl : ( ( rule__Scenario1_4__Alternatives_2 )? ) ;
    public final void rule__Scenario1_4__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1689:1: ( ( ( rule__Scenario1_4__Alternatives_2 )? ) )
            // InternalBug348427TestLanguage.g:1690:1: ( ( rule__Scenario1_4__Alternatives_2 )? )
            {
            // InternalBug348427TestLanguage.g:1690:1: ( ( rule__Scenario1_4__Alternatives_2 )? )
            // InternalBug348427TestLanguage.g:1691:1: ( rule__Scenario1_4__Alternatives_2 )?
            {
             before(grammarAccess.getScenario1_4Access().getAlternatives_2()); 
            // InternalBug348427TestLanguage.g:1692:1: ( rule__Scenario1_4__Alternatives_2 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_ID) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalBug348427TestLanguage.g:1692:2: rule__Scenario1_4__Alternatives_2
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
    // InternalBug348427TestLanguage.g:1702:1: rule__Scenario1_4__Group__3 : rule__Scenario1_4__Group__3__Impl ;
    public final void rule__Scenario1_4__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1706:1: ( rule__Scenario1_4__Group__3__Impl )
            // InternalBug348427TestLanguage.g:1707:2: rule__Scenario1_4__Group__3__Impl
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
    // InternalBug348427TestLanguage.g:1713:1: rule__Scenario1_4__Group__3__Impl : ( 'next' ) ;
    public final void rule__Scenario1_4__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1717:1: ( ( 'next' ) )
            // InternalBug348427TestLanguage.g:1718:1: ( 'next' )
            {
            // InternalBug348427TestLanguage.g:1718:1: ( 'next' )
            // InternalBug348427TestLanguage.g:1719:1: 'next'
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
    // InternalBug348427TestLanguage.g:1740:1: rule__Child1_1__Group__0 : rule__Child1_1__Group__0__Impl rule__Child1_1__Group__1 ;
    public final void rule__Child1_1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1744:1: ( rule__Child1_1__Group__0__Impl rule__Child1_1__Group__1 )
            // InternalBug348427TestLanguage.g:1745:2: rule__Child1_1__Group__0__Impl rule__Child1_1__Group__1
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
    // InternalBug348427TestLanguage.g:1752:1: rule__Child1_1__Group__0__Impl : ( ( rule__Child1_1__NameAssignment_0 ) ) ;
    public final void rule__Child1_1__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1756:1: ( ( ( rule__Child1_1__NameAssignment_0 ) ) )
            // InternalBug348427TestLanguage.g:1757:1: ( ( rule__Child1_1__NameAssignment_0 ) )
            {
            // InternalBug348427TestLanguage.g:1757:1: ( ( rule__Child1_1__NameAssignment_0 ) )
            // InternalBug348427TestLanguage.g:1758:1: ( rule__Child1_1__NameAssignment_0 )
            {
             before(grammarAccess.getChild1_1Access().getNameAssignment_0()); 
            // InternalBug348427TestLanguage.g:1759:1: ( rule__Child1_1__NameAssignment_0 )
            // InternalBug348427TestLanguage.g:1759:2: rule__Child1_1__NameAssignment_0
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
    // InternalBug348427TestLanguage.g:1769:1: rule__Child1_1__Group__1 : rule__Child1_1__Group__1__Impl rule__Child1_1__Group__2 ;
    public final void rule__Child1_1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1773:1: ( rule__Child1_1__Group__1__Impl rule__Child1_1__Group__2 )
            // InternalBug348427TestLanguage.g:1774:2: rule__Child1_1__Group__1__Impl rule__Child1_1__Group__2
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
    // InternalBug348427TestLanguage.g:1781:1: rule__Child1_1__Group__1__Impl : ( ':' ) ;
    public final void rule__Child1_1__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1785:1: ( ( ':' ) )
            // InternalBug348427TestLanguage.g:1786:1: ( ':' )
            {
            // InternalBug348427TestLanguage.g:1786:1: ( ':' )
            // InternalBug348427TestLanguage.g:1787:1: ':'
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
    // InternalBug348427TestLanguage.g:1800:1: rule__Child1_1__Group__2 : rule__Child1_1__Group__2__Impl rule__Child1_1__Group__3 ;
    public final void rule__Child1_1__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1804:1: ( rule__Child1_1__Group__2__Impl rule__Child1_1__Group__3 )
            // InternalBug348427TestLanguage.g:1805:2: rule__Child1_1__Group__2__Impl rule__Child1_1__Group__3
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
    // InternalBug348427TestLanguage.g:1812:1: rule__Child1_1__Group__2__Impl : ( ( rule__Child1_1__Group_2__0 )? ) ;
    public final void rule__Child1_1__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1816:1: ( ( ( rule__Child1_1__Group_2__0 )? ) )
            // InternalBug348427TestLanguage.g:1817:1: ( ( rule__Child1_1__Group_2__0 )? )
            {
            // InternalBug348427TestLanguage.g:1817:1: ( ( rule__Child1_1__Group_2__0 )? )
            // InternalBug348427TestLanguage.g:1818:1: ( rule__Child1_1__Group_2__0 )?
            {
             before(grammarAccess.getChild1_1Access().getGroup_2()); 
            // InternalBug348427TestLanguage.g:1819:1: ( rule__Child1_1__Group_2__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==32) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalBug348427TestLanguage.g:1819:2: rule__Child1_1__Group_2__0
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
    // InternalBug348427TestLanguage.g:1829:1: rule__Child1_1__Group__3 : rule__Child1_1__Group__3__Impl rule__Child1_1__Group__4 ;
    public final void rule__Child1_1__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1833:1: ( rule__Child1_1__Group__3__Impl rule__Child1_1__Group__4 )
            // InternalBug348427TestLanguage.g:1834:2: rule__Child1_1__Group__3__Impl rule__Child1_1__Group__4
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
    // InternalBug348427TestLanguage.g:1841:1: rule__Child1_1__Group__3__Impl : ( ( rule__Child1_1__EnumTypeAssignment_3 ) ) ;
    public final void rule__Child1_1__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1845:1: ( ( ( rule__Child1_1__EnumTypeAssignment_3 ) ) )
            // InternalBug348427TestLanguage.g:1846:1: ( ( rule__Child1_1__EnumTypeAssignment_3 ) )
            {
            // InternalBug348427TestLanguage.g:1846:1: ( ( rule__Child1_1__EnumTypeAssignment_3 ) )
            // InternalBug348427TestLanguage.g:1847:1: ( rule__Child1_1__EnumTypeAssignment_3 )
            {
             before(grammarAccess.getChild1_1Access().getEnumTypeAssignment_3()); 
            // InternalBug348427TestLanguage.g:1848:1: ( rule__Child1_1__EnumTypeAssignment_3 )
            // InternalBug348427TestLanguage.g:1848:2: rule__Child1_1__EnumTypeAssignment_3
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
    // InternalBug348427TestLanguage.g:1858:1: rule__Child1_1__Group__4 : rule__Child1_1__Group__4__Impl rule__Child1_1__Group__5 ;
    public final void rule__Child1_1__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1862:1: ( rule__Child1_1__Group__4__Impl rule__Child1_1__Group__5 )
            // InternalBug348427TestLanguage.g:1863:2: rule__Child1_1__Group__4__Impl rule__Child1_1__Group__5
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
    // InternalBug348427TestLanguage.g:1870:1: rule__Child1_1__Group__4__Impl : ( 'child1' ) ;
    public final void rule__Child1_1__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1874:1: ( ( 'child1' ) )
            // InternalBug348427TestLanguage.g:1875:1: ( 'child1' )
            {
            // InternalBug348427TestLanguage.g:1875:1: ( 'child1' )
            // InternalBug348427TestLanguage.g:1876:1: 'child1'
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
    // InternalBug348427TestLanguage.g:1889:1: rule__Child1_1__Group__5 : rule__Child1_1__Group__5__Impl ;
    public final void rule__Child1_1__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1893:1: ( rule__Child1_1__Group__5__Impl )
            // InternalBug348427TestLanguage.g:1894:2: rule__Child1_1__Group__5__Impl
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
    // InternalBug348427TestLanguage.g:1900:1: rule__Child1_1__Group__5__Impl : ( 'end' ) ;
    public final void rule__Child1_1__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1904:1: ( ( 'end' ) )
            // InternalBug348427TestLanguage.g:1905:1: ( 'end' )
            {
            // InternalBug348427TestLanguage.g:1905:1: ( 'end' )
            // InternalBug348427TestLanguage.g:1906:1: 'end'
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
    // InternalBug348427TestLanguage.g:1931:1: rule__Child1_1__Group_2__0 : rule__Child1_1__Group_2__0__Impl rule__Child1_1__Group_2__1 ;
    public final void rule__Child1_1__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1935:1: ( rule__Child1_1__Group_2__0__Impl rule__Child1_1__Group_2__1 )
            // InternalBug348427TestLanguage.g:1936:2: rule__Child1_1__Group_2__0__Impl rule__Child1_1__Group_2__1
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
    // InternalBug348427TestLanguage.g:1943:1: rule__Child1_1__Group_2__0__Impl : ( ( rule__Child1_1__BoolAssignment_2_0 ) ) ;
    public final void rule__Child1_1__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1947:1: ( ( ( rule__Child1_1__BoolAssignment_2_0 ) ) )
            // InternalBug348427TestLanguage.g:1948:1: ( ( rule__Child1_1__BoolAssignment_2_0 ) )
            {
            // InternalBug348427TestLanguage.g:1948:1: ( ( rule__Child1_1__BoolAssignment_2_0 ) )
            // InternalBug348427TestLanguage.g:1949:1: ( rule__Child1_1__BoolAssignment_2_0 )
            {
             before(grammarAccess.getChild1_1Access().getBoolAssignment_2_0()); 
            // InternalBug348427TestLanguage.g:1950:1: ( rule__Child1_1__BoolAssignment_2_0 )
            // InternalBug348427TestLanguage.g:1950:2: rule__Child1_1__BoolAssignment_2_0
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
    // InternalBug348427TestLanguage.g:1960:1: rule__Child1_1__Group_2__1 : rule__Child1_1__Group_2__1__Impl ;
    public final void rule__Child1_1__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1964:1: ( rule__Child1_1__Group_2__1__Impl )
            // InternalBug348427TestLanguage.g:1965:2: rule__Child1_1__Group_2__1__Impl
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
    // InternalBug348427TestLanguage.g:1971:1: rule__Child1_1__Group_2__1__Impl : ( 'keyword' ) ;
    public final void rule__Child1_1__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1975:1: ( ( 'keyword' ) )
            // InternalBug348427TestLanguage.g:1976:1: ( 'keyword' )
            {
            // InternalBug348427TestLanguage.g:1976:1: ( 'keyword' )
            // InternalBug348427TestLanguage.g:1977:1: 'keyword'
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
    // InternalBug348427TestLanguage.g:1994:1: rule__Child1_2__Group__0 : rule__Child1_2__Group__0__Impl rule__Child1_2__Group__1 ;
    public final void rule__Child1_2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:1998:1: ( rule__Child1_2__Group__0__Impl rule__Child1_2__Group__1 )
            // InternalBug348427TestLanguage.g:1999:2: rule__Child1_2__Group__0__Impl rule__Child1_2__Group__1
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
    // InternalBug348427TestLanguage.g:2006:1: rule__Child1_2__Group__0__Impl : ( ( rule__Child1_2__NameAssignment_0 ) ) ;
    public final void rule__Child1_2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2010:1: ( ( ( rule__Child1_2__NameAssignment_0 ) ) )
            // InternalBug348427TestLanguage.g:2011:1: ( ( rule__Child1_2__NameAssignment_0 ) )
            {
            // InternalBug348427TestLanguage.g:2011:1: ( ( rule__Child1_2__NameAssignment_0 ) )
            // InternalBug348427TestLanguage.g:2012:1: ( rule__Child1_2__NameAssignment_0 )
            {
             before(grammarAccess.getChild1_2Access().getNameAssignment_0()); 
            // InternalBug348427TestLanguage.g:2013:1: ( rule__Child1_2__NameAssignment_0 )
            // InternalBug348427TestLanguage.g:2013:2: rule__Child1_2__NameAssignment_0
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
    // InternalBug348427TestLanguage.g:2023:1: rule__Child1_2__Group__1 : rule__Child1_2__Group__1__Impl rule__Child1_2__Group__2 ;
    public final void rule__Child1_2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2027:1: ( rule__Child1_2__Group__1__Impl rule__Child1_2__Group__2 )
            // InternalBug348427TestLanguage.g:2028:2: rule__Child1_2__Group__1__Impl rule__Child1_2__Group__2
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
    // InternalBug348427TestLanguage.g:2035:1: rule__Child1_2__Group__1__Impl : ( ':' ) ;
    public final void rule__Child1_2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2039:1: ( ( ':' ) )
            // InternalBug348427TestLanguage.g:2040:1: ( ':' )
            {
            // InternalBug348427TestLanguage.g:2040:1: ( ':' )
            // InternalBug348427TestLanguage.g:2041:1: ':'
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
    // InternalBug348427TestLanguage.g:2054:1: rule__Child1_2__Group__2 : rule__Child1_2__Group__2__Impl rule__Child1_2__Group__3 ;
    public final void rule__Child1_2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2058:1: ( rule__Child1_2__Group__2__Impl rule__Child1_2__Group__3 )
            // InternalBug348427TestLanguage.g:2059:2: rule__Child1_2__Group__2__Impl rule__Child1_2__Group__3
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
    // InternalBug348427TestLanguage.g:2066:1: rule__Child1_2__Group__2__Impl : ( ( rule__Child1_2__Group_2__0 )? ) ;
    public final void rule__Child1_2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2070:1: ( ( ( rule__Child1_2__Group_2__0 )? ) )
            // InternalBug348427TestLanguage.g:2071:1: ( ( rule__Child1_2__Group_2__0 )? )
            {
            // InternalBug348427TestLanguage.g:2071:1: ( ( rule__Child1_2__Group_2__0 )? )
            // InternalBug348427TestLanguage.g:2072:1: ( rule__Child1_2__Group_2__0 )?
            {
             before(grammarAccess.getChild1_2Access().getGroup_2()); 
            // InternalBug348427TestLanguage.g:2073:1: ( rule__Child1_2__Group_2__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==32) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalBug348427TestLanguage.g:2073:2: rule__Child1_2__Group_2__0
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
    // InternalBug348427TestLanguage.g:2083:1: rule__Child1_2__Group__3 : rule__Child1_2__Group__3__Impl rule__Child1_2__Group__4 ;
    public final void rule__Child1_2__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2087:1: ( rule__Child1_2__Group__3__Impl rule__Child1_2__Group__4 )
            // InternalBug348427TestLanguage.g:2088:2: rule__Child1_2__Group__3__Impl rule__Child1_2__Group__4
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
    // InternalBug348427TestLanguage.g:2095:1: rule__Child1_2__Group__3__Impl : ( ( rule__Child1_2__EnumTypeAssignment_3 ) ) ;
    public final void rule__Child1_2__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2099:1: ( ( ( rule__Child1_2__EnumTypeAssignment_3 ) ) )
            // InternalBug348427TestLanguage.g:2100:1: ( ( rule__Child1_2__EnumTypeAssignment_3 ) )
            {
            // InternalBug348427TestLanguage.g:2100:1: ( ( rule__Child1_2__EnumTypeAssignment_3 ) )
            // InternalBug348427TestLanguage.g:2101:1: ( rule__Child1_2__EnumTypeAssignment_3 )
            {
             before(grammarAccess.getChild1_2Access().getEnumTypeAssignment_3()); 
            // InternalBug348427TestLanguage.g:2102:1: ( rule__Child1_2__EnumTypeAssignment_3 )
            // InternalBug348427TestLanguage.g:2102:2: rule__Child1_2__EnumTypeAssignment_3
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
    // InternalBug348427TestLanguage.g:2112:1: rule__Child1_2__Group__4 : rule__Child1_2__Group__4__Impl rule__Child1_2__Group__5 ;
    public final void rule__Child1_2__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2116:1: ( rule__Child1_2__Group__4__Impl rule__Child1_2__Group__5 )
            // InternalBug348427TestLanguage.g:2117:2: rule__Child1_2__Group__4__Impl rule__Child1_2__Group__5
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
    // InternalBug348427TestLanguage.g:2124:1: rule__Child1_2__Group__4__Impl : ( 'child2' ) ;
    public final void rule__Child1_2__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2128:1: ( ( 'child2' ) )
            // InternalBug348427TestLanguage.g:2129:1: ( 'child2' )
            {
            // InternalBug348427TestLanguage.g:2129:1: ( 'child2' )
            // InternalBug348427TestLanguage.g:2130:1: 'child2'
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
    // InternalBug348427TestLanguage.g:2143:1: rule__Child1_2__Group__5 : rule__Child1_2__Group__5__Impl ;
    public final void rule__Child1_2__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2147:1: ( rule__Child1_2__Group__5__Impl )
            // InternalBug348427TestLanguage.g:2148:2: rule__Child1_2__Group__5__Impl
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
    // InternalBug348427TestLanguage.g:2154:1: rule__Child1_2__Group__5__Impl : ( 'end' ) ;
    public final void rule__Child1_2__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2158:1: ( ( 'end' ) )
            // InternalBug348427TestLanguage.g:2159:1: ( 'end' )
            {
            // InternalBug348427TestLanguage.g:2159:1: ( 'end' )
            // InternalBug348427TestLanguage.g:2160:1: 'end'
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
    // InternalBug348427TestLanguage.g:2185:1: rule__Child1_2__Group_2__0 : rule__Child1_2__Group_2__0__Impl rule__Child1_2__Group_2__1 ;
    public final void rule__Child1_2__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2189:1: ( rule__Child1_2__Group_2__0__Impl rule__Child1_2__Group_2__1 )
            // InternalBug348427TestLanguage.g:2190:2: rule__Child1_2__Group_2__0__Impl rule__Child1_2__Group_2__1
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
    // InternalBug348427TestLanguage.g:2197:1: rule__Child1_2__Group_2__0__Impl : ( ( rule__Child1_2__BoolAssignment_2_0 ) ) ;
    public final void rule__Child1_2__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2201:1: ( ( ( rule__Child1_2__BoolAssignment_2_0 ) ) )
            // InternalBug348427TestLanguage.g:2202:1: ( ( rule__Child1_2__BoolAssignment_2_0 ) )
            {
            // InternalBug348427TestLanguage.g:2202:1: ( ( rule__Child1_2__BoolAssignment_2_0 ) )
            // InternalBug348427TestLanguage.g:2203:1: ( rule__Child1_2__BoolAssignment_2_0 )
            {
             before(grammarAccess.getChild1_2Access().getBoolAssignment_2_0()); 
            // InternalBug348427TestLanguage.g:2204:1: ( rule__Child1_2__BoolAssignment_2_0 )
            // InternalBug348427TestLanguage.g:2204:2: rule__Child1_2__BoolAssignment_2_0
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
    // InternalBug348427TestLanguage.g:2214:1: rule__Child1_2__Group_2__1 : rule__Child1_2__Group_2__1__Impl ;
    public final void rule__Child1_2__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2218:1: ( rule__Child1_2__Group_2__1__Impl )
            // InternalBug348427TestLanguage.g:2219:2: rule__Child1_2__Group_2__1__Impl
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
    // InternalBug348427TestLanguage.g:2225:1: rule__Child1_2__Group_2__1__Impl : ( 'keyword' ) ;
    public final void rule__Child1_2__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2229:1: ( ( 'keyword' ) )
            // InternalBug348427TestLanguage.g:2230:1: ( 'keyword' )
            {
            // InternalBug348427TestLanguage.g:2230:1: ( 'keyword' )
            // InternalBug348427TestLanguage.g:2231:1: 'keyword'
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
    // InternalBug348427TestLanguage.g:2248:1: rule__Child1_3__Group__0 : rule__Child1_3__Group__0__Impl rule__Child1_3__Group__1 ;
    public final void rule__Child1_3__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2252:1: ( rule__Child1_3__Group__0__Impl rule__Child1_3__Group__1 )
            // InternalBug348427TestLanguage.g:2253:2: rule__Child1_3__Group__0__Impl rule__Child1_3__Group__1
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
    // InternalBug348427TestLanguage.g:2260:1: rule__Child1_3__Group__0__Impl : ( ( rule__Child1_3__NameAssignment_0 ) ) ;
    public final void rule__Child1_3__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2264:1: ( ( ( rule__Child1_3__NameAssignment_0 ) ) )
            // InternalBug348427TestLanguage.g:2265:1: ( ( rule__Child1_3__NameAssignment_0 ) )
            {
            // InternalBug348427TestLanguage.g:2265:1: ( ( rule__Child1_3__NameAssignment_0 ) )
            // InternalBug348427TestLanguage.g:2266:1: ( rule__Child1_3__NameAssignment_0 )
            {
             before(grammarAccess.getChild1_3Access().getNameAssignment_0()); 
            // InternalBug348427TestLanguage.g:2267:1: ( rule__Child1_3__NameAssignment_0 )
            // InternalBug348427TestLanguage.g:2267:2: rule__Child1_3__NameAssignment_0
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
    // InternalBug348427TestLanguage.g:2277:1: rule__Child1_3__Group__1 : rule__Child1_3__Group__1__Impl rule__Child1_3__Group__2 ;
    public final void rule__Child1_3__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2281:1: ( rule__Child1_3__Group__1__Impl rule__Child1_3__Group__2 )
            // InternalBug348427TestLanguage.g:2282:2: rule__Child1_3__Group__1__Impl rule__Child1_3__Group__2
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
    // InternalBug348427TestLanguage.g:2289:1: rule__Child1_3__Group__1__Impl : ( ':' ) ;
    public final void rule__Child1_3__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2293:1: ( ( ':' ) )
            // InternalBug348427TestLanguage.g:2294:1: ( ':' )
            {
            // InternalBug348427TestLanguage.g:2294:1: ( ':' )
            // InternalBug348427TestLanguage.g:2295:1: ':'
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
    // InternalBug348427TestLanguage.g:2308:1: rule__Child1_3__Group__2 : rule__Child1_3__Group__2__Impl rule__Child1_3__Group__3 ;
    public final void rule__Child1_3__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2312:1: ( rule__Child1_3__Group__2__Impl rule__Child1_3__Group__3 )
            // InternalBug348427TestLanguage.g:2313:2: rule__Child1_3__Group__2__Impl rule__Child1_3__Group__3
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
    // InternalBug348427TestLanguage.g:2320:1: rule__Child1_3__Group__2__Impl : ( ( rule__Child1_3__Group_2__0 )? ) ;
    public final void rule__Child1_3__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2324:1: ( ( ( rule__Child1_3__Group_2__0 )? ) )
            // InternalBug348427TestLanguage.g:2325:1: ( ( rule__Child1_3__Group_2__0 )? )
            {
            // InternalBug348427TestLanguage.g:2325:1: ( ( rule__Child1_3__Group_2__0 )? )
            // InternalBug348427TestLanguage.g:2326:1: ( rule__Child1_3__Group_2__0 )?
            {
             before(grammarAccess.getChild1_3Access().getGroup_2()); 
            // InternalBug348427TestLanguage.g:2327:1: ( rule__Child1_3__Group_2__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==32) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalBug348427TestLanguage.g:2327:2: rule__Child1_3__Group_2__0
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
    // InternalBug348427TestLanguage.g:2337:1: rule__Child1_3__Group__3 : rule__Child1_3__Group__3__Impl rule__Child1_3__Group__4 ;
    public final void rule__Child1_3__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2341:1: ( rule__Child1_3__Group__3__Impl rule__Child1_3__Group__4 )
            // InternalBug348427TestLanguage.g:2342:2: rule__Child1_3__Group__3__Impl rule__Child1_3__Group__4
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
    // InternalBug348427TestLanguage.g:2349:1: rule__Child1_3__Group__3__Impl : ( ( rule__Child1_3__EnumTypeAssignment_3 ) ) ;
    public final void rule__Child1_3__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2353:1: ( ( ( rule__Child1_3__EnumTypeAssignment_3 ) ) )
            // InternalBug348427TestLanguage.g:2354:1: ( ( rule__Child1_3__EnumTypeAssignment_3 ) )
            {
            // InternalBug348427TestLanguage.g:2354:1: ( ( rule__Child1_3__EnumTypeAssignment_3 ) )
            // InternalBug348427TestLanguage.g:2355:1: ( rule__Child1_3__EnumTypeAssignment_3 )
            {
             before(grammarAccess.getChild1_3Access().getEnumTypeAssignment_3()); 
            // InternalBug348427TestLanguage.g:2356:1: ( rule__Child1_3__EnumTypeAssignment_3 )
            // InternalBug348427TestLanguage.g:2356:2: rule__Child1_3__EnumTypeAssignment_3
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
    // InternalBug348427TestLanguage.g:2366:1: rule__Child1_3__Group__4 : rule__Child1_3__Group__4__Impl rule__Child1_3__Group__5 ;
    public final void rule__Child1_3__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2370:1: ( rule__Child1_3__Group__4__Impl rule__Child1_3__Group__5 )
            // InternalBug348427TestLanguage.g:2371:2: rule__Child1_3__Group__4__Impl rule__Child1_3__Group__5
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
    // InternalBug348427TestLanguage.g:2378:1: rule__Child1_3__Group__4__Impl : ( 'child3' ) ;
    public final void rule__Child1_3__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2382:1: ( ( 'child3' ) )
            // InternalBug348427TestLanguage.g:2383:1: ( 'child3' )
            {
            // InternalBug348427TestLanguage.g:2383:1: ( 'child3' )
            // InternalBug348427TestLanguage.g:2384:1: 'child3'
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
    // InternalBug348427TestLanguage.g:2397:1: rule__Child1_3__Group__5 : rule__Child1_3__Group__5__Impl ;
    public final void rule__Child1_3__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2401:1: ( rule__Child1_3__Group__5__Impl )
            // InternalBug348427TestLanguage.g:2402:2: rule__Child1_3__Group__5__Impl
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
    // InternalBug348427TestLanguage.g:2408:1: rule__Child1_3__Group__5__Impl : ( 'end' ) ;
    public final void rule__Child1_3__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2412:1: ( ( 'end' ) )
            // InternalBug348427TestLanguage.g:2413:1: ( 'end' )
            {
            // InternalBug348427TestLanguage.g:2413:1: ( 'end' )
            // InternalBug348427TestLanguage.g:2414:1: 'end'
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
    // InternalBug348427TestLanguage.g:2439:1: rule__Child1_3__Group_2__0 : rule__Child1_3__Group_2__0__Impl rule__Child1_3__Group_2__1 ;
    public final void rule__Child1_3__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2443:1: ( rule__Child1_3__Group_2__0__Impl rule__Child1_3__Group_2__1 )
            // InternalBug348427TestLanguage.g:2444:2: rule__Child1_3__Group_2__0__Impl rule__Child1_3__Group_2__1
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
    // InternalBug348427TestLanguage.g:2451:1: rule__Child1_3__Group_2__0__Impl : ( ( rule__Child1_3__BoolAssignment_2_0 ) ) ;
    public final void rule__Child1_3__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2455:1: ( ( ( rule__Child1_3__BoolAssignment_2_0 ) ) )
            // InternalBug348427TestLanguage.g:2456:1: ( ( rule__Child1_3__BoolAssignment_2_0 ) )
            {
            // InternalBug348427TestLanguage.g:2456:1: ( ( rule__Child1_3__BoolAssignment_2_0 ) )
            // InternalBug348427TestLanguage.g:2457:1: ( rule__Child1_3__BoolAssignment_2_0 )
            {
             before(grammarAccess.getChild1_3Access().getBoolAssignment_2_0()); 
            // InternalBug348427TestLanguage.g:2458:1: ( rule__Child1_3__BoolAssignment_2_0 )
            // InternalBug348427TestLanguage.g:2458:2: rule__Child1_3__BoolAssignment_2_0
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
    // InternalBug348427TestLanguage.g:2468:1: rule__Child1_3__Group_2__1 : rule__Child1_3__Group_2__1__Impl ;
    public final void rule__Child1_3__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2472:1: ( rule__Child1_3__Group_2__1__Impl )
            // InternalBug348427TestLanguage.g:2473:2: rule__Child1_3__Group_2__1__Impl
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
    // InternalBug348427TestLanguage.g:2479:1: rule__Child1_3__Group_2__1__Impl : ( 'keyword' ) ;
    public final void rule__Child1_3__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2483:1: ( ( 'keyword' ) )
            // InternalBug348427TestLanguage.g:2484:1: ( 'keyword' )
            {
            // InternalBug348427TestLanguage.g:2484:1: ( 'keyword' )
            // InternalBug348427TestLanguage.g:2485:1: 'keyword'
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
    // InternalBug348427TestLanguage.g:2502:1: rule__Scenario2_1__Group__0 : rule__Scenario2_1__Group__0__Impl rule__Scenario2_1__Group__1 ;
    public final void rule__Scenario2_1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2506:1: ( rule__Scenario2_1__Group__0__Impl rule__Scenario2_1__Group__1 )
            // InternalBug348427TestLanguage.g:2507:2: rule__Scenario2_1__Group__0__Impl rule__Scenario2_1__Group__1
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
    // InternalBug348427TestLanguage.g:2514:1: rule__Scenario2_1__Group__0__Impl : ( '2.1' ) ;
    public final void rule__Scenario2_1__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2518:1: ( ( '2.1' ) )
            // InternalBug348427TestLanguage.g:2519:1: ( '2.1' )
            {
            // InternalBug348427TestLanguage.g:2519:1: ( '2.1' )
            // InternalBug348427TestLanguage.g:2520:1: '2.1'
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
    // InternalBug348427TestLanguage.g:2533:1: rule__Scenario2_1__Group__1 : rule__Scenario2_1__Group__1__Impl rule__Scenario2_1__Group__2 ;
    public final void rule__Scenario2_1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2537:1: ( rule__Scenario2_1__Group__1__Impl rule__Scenario2_1__Group__2 )
            // InternalBug348427TestLanguage.g:2538:2: rule__Scenario2_1__Group__1__Impl rule__Scenario2_1__Group__2
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
    // InternalBug348427TestLanguage.g:2545:1: rule__Scenario2_1__Group__1__Impl : ( ( rule__Scenario2_1__Alternatives_1 ) ) ;
    public final void rule__Scenario2_1__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2549:1: ( ( ( rule__Scenario2_1__Alternatives_1 ) ) )
            // InternalBug348427TestLanguage.g:2550:1: ( ( rule__Scenario2_1__Alternatives_1 ) )
            {
            // InternalBug348427TestLanguage.g:2550:1: ( ( rule__Scenario2_1__Alternatives_1 ) )
            // InternalBug348427TestLanguage.g:2551:1: ( rule__Scenario2_1__Alternatives_1 )
            {
             before(grammarAccess.getScenario2_1Access().getAlternatives_1()); 
            // InternalBug348427TestLanguage.g:2552:1: ( rule__Scenario2_1__Alternatives_1 )
            // InternalBug348427TestLanguage.g:2552:2: rule__Scenario2_1__Alternatives_1
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
    // InternalBug348427TestLanguage.g:2562:1: rule__Scenario2_1__Group__2 : rule__Scenario2_1__Group__2__Impl ;
    public final void rule__Scenario2_1__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2566:1: ( rule__Scenario2_1__Group__2__Impl )
            // InternalBug348427TestLanguage.g:2567:2: rule__Scenario2_1__Group__2__Impl
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
    // InternalBug348427TestLanguage.g:2573:1: rule__Scenario2_1__Group__2__Impl : ( 'next' ) ;
    public final void rule__Scenario2_1__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2577:1: ( ( 'next' ) )
            // InternalBug348427TestLanguage.g:2578:1: ( 'next' )
            {
            // InternalBug348427TestLanguage.g:2578:1: ( 'next' )
            // InternalBug348427TestLanguage.g:2579:1: 'next'
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
    // InternalBug348427TestLanguage.g:2598:1: rule__Scenario2_2__Group__0 : rule__Scenario2_2__Group__0__Impl rule__Scenario2_2__Group__1 ;
    public final void rule__Scenario2_2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2602:1: ( rule__Scenario2_2__Group__0__Impl rule__Scenario2_2__Group__1 )
            // InternalBug348427TestLanguage.g:2603:2: rule__Scenario2_2__Group__0__Impl rule__Scenario2_2__Group__1
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
    // InternalBug348427TestLanguage.g:2610:1: rule__Scenario2_2__Group__0__Impl : ( '2.2' ) ;
    public final void rule__Scenario2_2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2614:1: ( ( '2.2' ) )
            // InternalBug348427TestLanguage.g:2615:1: ( '2.2' )
            {
            // InternalBug348427TestLanguage.g:2615:1: ( '2.2' )
            // InternalBug348427TestLanguage.g:2616:1: '2.2'
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
    // InternalBug348427TestLanguage.g:2629:1: rule__Scenario2_2__Group__1 : rule__Scenario2_2__Group__1__Impl rule__Scenario2_2__Group__2 ;
    public final void rule__Scenario2_2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2633:1: ( rule__Scenario2_2__Group__1__Impl rule__Scenario2_2__Group__2 )
            // InternalBug348427TestLanguage.g:2634:2: rule__Scenario2_2__Group__1__Impl rule__Scenario2_2__Group__2
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
    // InternalBug348427TestLanguage.g:2641:1: rule__Scenario2_2__Group__1__Impl : ( ( ( rule__Scenario2_2__Alternatives_1 ) ) ( ( rule__Scenario2_2__Alternatives_1 )* ) ) ;
    public final void rule__Scenario2_2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2645:1: ( ( ( ( rule__Scenario2_2__Alternatives_1 ) ) ( ( rule__Scenario2_2__Alternatives_1 )* ) ) )
            // InternalBug348427TestLanguage.g:2646:1: ( ( ( rule__Scenario2_2__Alternatives_1 ) ) ( ( rule__Scenario2_2__Alternatives_1 )* ) )
            {
            // InternalBug348427TestLanguage.g:2646:1: ( ( ( rule__Scenario2_2__Alternatives_1 ) ) ( ( rule__Scenario2_2__Alternatives_1 )* ) )
            // InternalBug348427TestLanguage.g:2647:1: ( ( rule__Scenario2_2__Alternatives_1 ) ) ( ( rule__Scenario2_2__Alternatives_1 )* )
            {
            // InternalBug348427TestLanguage.g:2647:1: ( ( rule__Scenario2_2__Alternatives_1 ) )
            // InternalBug348427TestLanguage.g:2648:1: ( rule__Scenario2_2__Alternatives_1 )
            {
             before(grammarAccess.getScenario2_2Access().getAlternatives_1()); 
            // InternalBug348427TestLanguage.g:2649:1: ( rule__Scenario2_2__Alternatives_1 )
            // InternalBug348427TestLanguage.g:2649:2: rule__Scenario2_2__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Scenario2_2__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getScenario2_2Access().getAlternatives_1()); 

            }

            // InternalBug348427TestLanguage.g:2652:1: ( ( rule__Scenario2_2__Alternatives_1 )* )
            // InternalBug348427TestLanguage.g:2653:1: ( rule__Scenario2_2__Alternatives_1 )*
            {
             before(grammarAccess.getScenario2_2Access().getAlternatives_1()); 
            // InternalBug348427TestLanguage.g:2654:1: ( rule__Scenario2_2__Alternatives_1 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_ID) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalBug348427TestLanguage.g:2654:2: rule__Scenario2_2__Alternatives_1
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
    // InternalBug348427TestLanguage.g:2665:1: rule__Scenario2_2__Group__2 : rule__Scenario2_2__Group__2__Impl ;
    public final void rule__Scenario2_2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2669:1: ( rule__Scenario2_2__Group__2__Impl )
            // InternalBug348427TestLanguage.g:2670:2: rule__Scenario2_2__Group__2__Impl
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
    // InternalBug348427TestLanguage.g:2676:1: rule__Scenario2_2__Group__2__Impl : ( 'next' ) ;
    public final void rule__Scenario2_2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2680:1: ( ( 'next' ) )
            // InternalBug348427TestLanguage.g:2681:1: ( 'next' )
            {
            // InternalBug348427TestLanguage.g:2681:1: ( 'next' )
            // InternalBug348427TestLanguage.g:2682:1: 'next'
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
    // InternalBug348427TestLanguage.g:2701:1: rule__Scenario2_3__Group__0 : rule__Scenario2_3__Group__0__Impl rule__Scenario2_3__Group__1 ;
    public final void rule__Scenario2_3__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2705:1: ( rule__Scenario2_3__Group__0__Impl rule__Scenario2_3__Group__1 )
            // InternalBug348427TestLanguage.g:2706:2: rule__Scenario2_3__Group__0__Impl rule__Scenario2_3__Group__1
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
    // InternalBug348427TestLanguage.g:2713:1: rule__Scenario2_3__Group__0__Impl : ( '2.3' ) ;
    public final void rule__Scenario2_3__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2717:1: ( ( '2.3' ) )
            // InternalBug348427TestLanguage.g:2718:1: ( '2.3' )
            {
            // InternalBug348427TestLanguage.g:2718:1: ( '2.3' )
            // InternalBug348427TestLanguage.g:2719:1: '2.3'
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
    // InternalBug348427TestLanguage.g:2732:1: rule__Scenario2_3__Group__1 : rule__Scenario2_3__Group__1__Impl rule__Scenario2_3__Group__2 ;
    public final void rule__Scenario2_3__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2736:1: ( rule__Scenario2_3__Group__1__Impl rule__Scenario2_3__Group__2 )
            // InternalBug348427TestLanguage.g:2737:2: rule__Scenario2_3__Group__1__Impl rule__Scenario2_3__Group__2
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
    // InternalBug348427TestLanguage.g:2744:1: rule__Scenario2_3__Group__1__Impl : ( ( rule__Scenario2_3__Alternatives_1 ) ) ;
    public final void rule__Scenario2_3__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2748:1: ( ( ( rule__Scenario2_3__Alternatives_1 ) ) )
            // InternalBug348427TestLanguage.g:2749:1: ( ( rule__Scenario2_3__Alternatives_1 ) )
            {
            // InternalBug348427TestLanguage.g:2749:1: ( ( rule__Scenario2_3__Alternatives_1 ) )
            // InternalBug348427TestLanguage.g:2750:1: ( rule__Scenario2_3__Alternatives_1 )
            {
             before(grammarAccess.getScenario2_3Access().getAlternatives_1()); 
            // InternalBug348427TestLanguage.g:2751:1: ( rule__Scenario2_3__Alternatives_1 )
            // InternalBug348427TestLanguage.g:2751:2: rule__Scenario2_3__Alternatives_1
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
    // InternalBug348427TestLanguage.g:2761:1: rule__Scenario2_3__Group__2 : rule__Scenario2_3__Group__2__Impl ;
    public final void rule__Scenario2_3__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2765:1: ( rule__Scenario2_3__Group__2__Impl )
            // InternalBug348427TestLanguage.g:2766:2: rule__Scenario2_3__Group__2__Impl
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
    // InternalBug348427TestLanguage.g:2772:1: rule__Scenario2_3__Group__2__Impl : ( 'next' ) ;
    public final void rule__Scenario2_3__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2776:1: ( ( 'next' ) )
            // InternalBug348427TestLanguage.g:2777:1: ( 'next' )
            {
            // InternalBug348427TestLanguage.g:2777:1: ( 'next' )
            // InternalBug348427TestLanguage.g:2778:1: 'next'
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
    // InternalBug348427TestLanguage.g:2797:1: rule__Scenario2_4__Group__0 : rule__Scenario2_4__Group__0__Impl rule__Scenario2_4__Group__1 ;
    public final void rule__Scenario2_4__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2801:1: ( rule__Scenario2_4__Group__0__Impl rule__Scenario2_4__Group__1 )
            // InternalBug348427TestLanguage.g:2802:2: rule__Scenario2_4__Group__0__Impl rule__Scenario2_4__Group__1
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
    // InternalBug348427TestLanguage.g:2809:1: rule__Scenario2_4__Group__0__Impl : ( '2.4' ) ;
    public final void rule__Scenario2_4__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2813:1: ( ( '2.4' ) )
            // InternalBug348427TestLanguage.g:2814:1: ( '2.4' )
            {
            // InternalBug348427TestLanguage.g:2814:1: ( '2.4' )
            // InternalBug348427TestLanguage.g:2815:1: '2.4'
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
    // InternalBug348427TestLanguage.g:2828:1: rule__Scenario2_4__Group__1 : rule__Scenario2_4__Group__1__Impl rule__Scenario2_4__Group__2 ;
    public final void rule__Scenario2_4__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2832:1: ( rule__Scenario2_4__Group__1__Impl rule__Scenario2_4__Group__2 )
            // InternalBug348427TestLanguage.g:2833:2: rule__Scenario2_4__Group__1__Impl rule__Scenario2_4__Group__2
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
    // InternalBug348427TestLanguage.g:2840:1: rule__Scenario2_4__Group__1__Impl : ( ( ( rule__Scenario2_4__Alternatives_1 ) ) ( ( rule__Scenario2_4__Alternatives_1 )* ) ) ;
    public final void rule__Scenario2_4__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2844:1: ( ( ( ( rule__Scenario2_4__Alternatives_1 ) ) ( ( rule__Scenario2_4__Alternatives_1 )* ) ) )
            // InternalBug348427TestLanguage.g:2845:1: ( ( ( rule__Scenario2_4__Alternatives_1 ) ) ( ( rule__Scenario2_4__Alternatives_1 )* ) )
            {
            // InternalBug348427TestLanguage.g:2845:1: ( ( ( rule__Scenario2_4__Alternatives_1 ) ) ( ( rule__Scenario2_4__Alternatives_1 )* ) )
            // InternalBug348427TestLanguage.g:2846:1: ( ( rule__Scenario2_4__Alternatives_1 ) ) ( ( rule__Scenario2_4__Alternatives_1 )* )
            {
            // InternalBug348427TestLanguage.g:2846:1: ( ( rule__Scenario2_4__Alternatives_1 ) )
            // InternalBug348427TestLanguage.g:2847:1: ( rule__Scenario2_4__Alternatives_1 )
            {
             before(grammarAccess.getScenario2_4Access().getAlternatives_1()); 
            // InternalBug348427TestLanguage.g:2848:1: ( rule__Scenario2_4__Alternatives_1 )
            // InternalBug348427TestLanguage.g:2848:2: rule__Scenario2_4__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Scenario2_4__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getScenario2_4Access().getAlternatives_1()); 

            }

            // InternalBug348427TestLanguage.g:2851:1: ( ( rule__Scenario2_4__Alternatives_1 )* )
            // InternalBug348427TestLanguage.g:2852:1: ( rule__Scenario2_4__Alternatives_1 )*
            {
             before(grammarAccess.getScenario2_4Access().getAlternatives_1()); 
            // InternalBug348427TestLanguage.g:2853:1: ( rule__Scenario2_4__Alternatives_1 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_ID) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalBug348427TestLanguage.g:2853:2: rule__Scenario2_4__Alternatives_1
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
    // InternalBug348427TestLanguage.g:2864:1: rule__Scenario2_4__Group__2 : rule__Scenario2_4__Group__2__Impl ;
    public final void rule__Scenario2_4__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2868:1: ( rule__Scenario2_4__Group__2__Impl )
            // InternalBug348427TestLanguage.g:2869:2: rule__Scenario2_4__Group__2__Impl
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
    // InternalBug348427TestLanguage.g:2875:1: rule__Scenario2_4__Group__2__Impl : ( 'next' ) ;
    public final void rule__Scenario2_4__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2879:1: ( ( 'next' ) )
            // InternalBug348427TestLanguage.g:2880:1: ( 'next' )
            {
            // InternalBug348427TestLanguage.g:2880:1: ( 'next' )
            // InternalBug348427TestLanguage.g:2881:1: 'next'
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
    // InternalBug348427TestLanguage.g:2900:1: rule__Scenario2_5__Group__0 : rule__Scenario2_5__Group__0__Impl rule__Scenario2_5__Group__1 ;
    public final void rule__Scenario2_5__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2904:1: ( rule__Scenario2_5__Group__0__Impl rule__Scenario2_5__Group__1 )
            // InternalBug348427TestLanguage.g:2905:2: rule__Scenario2_5__Group__0__Impl rule__Scenario2_5__Group__1
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
    // InternalBug348427TestLanguage.g:2912:1: rule__Scenario2_5__Group__0__Impl : ( () ) ;
    public final void rule__Scenario2_5__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2916:1: ( ( () ) )
            // InternalBug348427TestLanguage.g:2917:1: ( () )
            {
            // InternalBug348427TestLanguage.g:2917:1: ( () )
            // InternalBug348427TestLanguage.g:2918:1: ()
            {
             before(grammarAccess.getScenario2_5Access().getScenario2Action_0()); 
            // InternalBug348427TestLanguage.g:2919:1: ()
            // InternalBug348427TestLanguage.g:2921:1: 
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
    // InternalBug348427TestLanguage.g:2931:1: rule__Scenario2_5__Group__1 : rule__Scenario2_5__Group__1__Impl rule__Scenario2_5__Group__2 ;
    public final void rule__Scenario2_5__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2935:1: ( rule__Scenario2_5__Group__1__Impl rule__Scenario2_5__Group__2 )
            // InternalBug348427TestLanguage.g:2936:2: rule__Scenario2_5__Group__1__Impl rule__Scenario2_5__Group__2
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
    // InternalBug348427TestLanguage.g:2943:1: rule__Scenario2_5__Group__1__Impl : ( '2.5' ) ;
    public final void rule__Scenario2_5__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2947:1: ( ( '2.5' ) )
            // InternalBug348427TestLanguage.g:2948:1: ( '2.5' )
            {
            // InternalBug348427TestLanguage.g:2948:1: ( '2.5' )
            // InternalBug348427TestLanguage.g:2949:1: '2.5'
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
    // InternalBug348427TestLanguage.g:2962:1: rule__Scenario2_5__Group__2 : rule__Scenario2_5__Group__2__Impl rule__Scenario2_5__Group__3 ;
    public final void rule__Scenario2_5__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2966:1: ( rule__Scenario2_5__Group__2__Impl rule__Scenario2_5__Group__3 )
            // InternalBug348427TestLanguage.g:2967:2: rule__Scenario2_5__Group__2__Impl rule__Scenario2_5__Group__3
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
    // InternalBug348427TestLanguage.g:2974:1: rule__Scenario2_5__Group__2__Impl : ( ( rule__Scenario2_5__Alternatives_2 )? ) ;
    public final void rule__Scenario2_5__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2978:1: ( ( ( rule__Scenario2_5__Alternatives_2 )? ) )
            // InternalBug348427TestLanguage.g:2979:1: ( ( rule__Scenario2_5__Alternatives_2 )? )
            {
            // InternalBug348427TestLanguage.g:2979:1: ( ( rule__Scenario2_5__Alternatives_2 )? )
            // InternalBug348427TestLanguage.g:2980:1: ( rule__Scenario2_5__Alternatives_2 )?
            {
             before(grammarAccess.getScenario2_5Access().getAlternatives_2()); 
            // InternalBug348427TestLanguage.g:2981:1: ( rule__Scenario2_5__Alternatives_2 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_ID) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalBug348427TestLanguage.g:2981:2: rule__Scenario2_5__Alternatives_2
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
    // InternalBug348427TestLanguage.g:2991:1: rule__Scenario2_5__Group__3 : rule__Scenario2_5__Group__3__Impl ;
    public final void rule__Scenario2_5__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:2995:1: ( rule__Scenario2_5__Group__3__Impl )
            // InternalBug348427TestLanguage.g:2996:2: rule__Scenario2_5__Group__3__Impl
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
    // InternalBug348427TestLanguage.g:3002:1: rule__Scenario2_5__Group__3__Impl : ( 'next' ) ;
    public final void rule__Scenario2_5__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3006:1: ( ( 'next' ) )
            // InternalBug348427TestLanguage.g:3007:1: ( 'next' )
            {
            // InternalBug348427TestLanguage.g:3007:1: ( 'next' )
            // InternalBug348427TestLanguage.g:3008:1: 'next'
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
    // InternalBug348427TestLanguage.g:3029:1: rule__Scenario2_6__Group__0 : rule__Scenario2_6__Group__0__Impl rule__Scenario2_6__Group__1 ;
    public final void rule__Scenario2_6__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3033:1: ( rule__Scenario2_6__Group__0__Impl rule__Scenario2_6__Group__1 )
            // InternalBug348427TestLanguage.g:3034:2: rule__Scenario2_6__Group__0__Impl rule__Scenario2_6__Group__1
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
    // InternalBug348427TestLanguage.g:3041:1: rule__Scenario2_6__Group__0__Impl : ( () ) ;
    public final void rule__Scenario2_6__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3045:1: ( ( () ) )
            // InternalBug348427TestLanguage.g:3046:1: ( () )
            {
            // InternalBug348427TestLanguage.g:3046:1: ( () )
            // InternalBug348427TestLanguage.g:3047:1: ()
            {
             before(grammarAccess.getScenario2_6Access().getScenario2Action_0()); 
            // InternalBug348427TestLanguage.g:3048:1: ()
            // InternalBug348427TestLanguage.g:3050:1: 
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
    // InternalBug348427TestLanguage.g:3060:1: rule__Scenario2_6__Group__1 : rule__Scenario2_6__Group__1__Impl rule__Scenario2_6__Group__2 ;
    public final void rule__Scenario2_6__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3064:1: ( rule__Scenario2_6__Group__1__Impl rule__Scenario2_6__Group__2 )
            // InternalBug348427TestLanguage.g:3065:2: rule__Scenario2_6__Group__1__Impl rule__Scenario2_6__Group__2
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
    // InternalBug348427TestLanguage.g:3072:1: rule__Scenario2_6__Group__1__Impl : ( '2.6' ) ;
    public final void rule__Scenario2_6__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3076:1: ( ( '2.6' ) )
            // InternalBug348427TestLanguage.g:3077:1: ( '2.6' )
            {
            // InternalBug348427TestLanguage.g:3077:1: ( '2.6' )
            // InternalBug348427TestLanguage.g:3078:1: '2.6'
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
    // InternalBug348427TestLanguage.g:3091:1: rule__Scenario2_6__Group__2 : rule__Scenario2_6__Group__2__Impl rule__Scenario2_6__Group__3 ;
    public final void rule__Scenario2_6__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3095:1: ( rule__Scenario2_6__Group__2__Impl rule__Scenario2_6__Group__3 )
            // InternalBug348427TestLanguage.g:3096:2: rule__Scenario2_6__Group__2__Impl rule__Scenario2_6__Group__3
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
    // InternalBug348427TestLanguage.g:3103:1: rule__Scenario2_6__Group__2__Impl : ( ( rule__Scenario2_6__Alternatives_2 )* ) ;
    public final void rule__Scenario2_6__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3107:1: ( ( ( rule__Scenario2_6__Alternatives_2 )* ) )
            // InternalBug348427TestLanguage.g:3108:1: ( ( rule__Scenario2_6__Alternatives_2 )* )
            {
            // InternalBug348427TestLanguage.g:3108:1: ( ( rule__Scenario2_6__Alternatives_2 )* )
            // InternalBug348427TestLanguage.g:3109:1: ( rule__Scenario2_6__Alternatives_2 )*
            {
             before(grammarAccess.getScenario2_6Access().getAlternatives_2()); 
            // InternalBug348427TestLanguage.g:3110:1: ( rule__Scenario2_6__Alternatives_2 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_ID) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalBug348427TestLanguage.g:3110:2: rule__Scenario2_6__Alternatives_2
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
    // InternalBug348427TestLanguage.g:3120:1: rule__Scenario2_6__Group__3 : rule__Scenario2_6__Group__3__Impl ;
    public final void rule__Scenario2_6__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3124:1: ( rule__Scenario2_6__Group__3__Impl )
            // InternalBug348427TestLanguage.g:3125:2: rule__Scenario2_6__Group__3__Impl
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
    // InternalBug348427TestLanguage.g:3131:1: rule__Scenario2_6__Group__3__Impl : ( 'next' ) ;
    public final void rule__Scenario2_6__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3135:1: ( ( 'next' ) )
            // InternalBug348427TestLanguage.g:3136:1: ( 'next' )
            {
            // InternalBug348427TestLanguage.g:3136:1: ( 'next' )
            // InternalBug348427TestLanguage.g:3137:1: 'next'
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
    // InternalBug348427TestLanguage.g:3158:1: rule__Scenario2_7__Group__0 : rule__Scenario2_7__Group__0__Impl rule__Scenario2_7__Group__1 ;
    public final void rule__Scenario2_7__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3162:1: ( rule__Scenario2_7__Group__0__Impl rule__Scenario2_7__Group__1 )
            // InternalBug348427TestLanguage.g:3163:2: rule__Scenario2_7__Group__0__Impl rule__Scenario2_7__Group__1
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
    // InternalBug348427TestLanguage.g:3170:1: rule__Scenario2_7__Group__0__Impl : ( () ) ;
    public final void rule__Scenario2_7__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3174:1: ( ( () ) )
            // InternalBug348427TestLanguage.g:3175:1: ( () )
            {
            // InternalBug348427TestLanguage.g:3175:1: ( () )
            // InternalBug348427TestLanguage.g:3176:1: ()
            {
             before(grammarAccess.getScenario2_7Access().getScenario2Action_0()); 
            // InternalBug348427TestLanguage.g:3177:1: ()
            // InternalBug348427TestLanguage.g:3179:1: 
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
    // InternalBug348427TestLanguage.g:3189:1: rule__Scenario2_7__Group__1 : rule__Scenario2_7__Group__1__Impl rule__Scenario2_7__Group__2 ;
    public final void rule__Scenario2_7__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3193:1: ( rule__Scenario2_7__Group__1__Impl rule__Scenario2_7__Group__2 )
            // InternalBug348427TestLanguage.g:3194:2: rule__Scenario2_7__Group__1__Impl rule__Scenario2_7__Group__2
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
    // InternalBug348427TestLanguage.g:3201:1: rule__Scenario2_7__Group__1__Impl : ( '2.7' ) ;
    public final void rule__Scenario2_7__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3205:1: ( ( '2.7' ) )
            // InternalBug348427TestLanguage.g:3206:1: ( '2.7' )
            {
            // InternalBug348427TestLanguage.g:3206:1: ( '2.7' )
            // InternalBug348427TestLanguage.g:3207:1: '2.7'
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
    // InternalBug348427TestLanguage.g:3220:1: rule__Scenario2_7__Group__2 : rule__Scenario2_7__Group__2__Impl rule__Scenario2_7__Group__3 ;
    public final void rule__Scenario2_7__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3224:1: ( rule__Scenario2_7__Group__2__Impl rule__Scenario2_7__Group__3 )
            // InternalBug348427TestLanguage.g:3225:2: rule__Scenario2_7__Group__2__Impl rule__Scenario2_7__Group__3
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
    // InternalBug348427TestLanguage.g:3232:1: rule__Scenario2_7__Group__2__Impl : ( ( rule__Scenario2_7__Alternatives_2 )? ) ;
    public final void rule__Scenario2_7__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3236:1: ( ( ( rule__Scenario2_7__Alternatives_2 )? ) )
            // InternalBug348427TestLanguage.g:3237:1: ( ( rule__Scenario2_7__Alternatives_2 )? )
            {
            // InternalBug348427TestLanguage.g:3237:1: ( ( rule__Scenario2_7__Alternatives_2 )? )
            // InternalBug348427TestLanguage.g:3238:1: ( rule__Scenario2_7__Alternatives_2 )?
            {
             before(grammarAccess.getScenario2_7Access().getAlternatives_2()); 
            // InternalBug348427TestLanguage.g:3239:1: ( rule__Scenario2_7__Alternatives_2 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_ID) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalBug348427TestLanguage.g:3239:2: rule__Scenario2_7__Alternatives_2
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
    // InternalBug348427TestLanguage.g:3249:1: rule__Scenario2_7__Group__3 : rule__Scenario2_7__Group__3__Impl ;
    public final void rule__Scenario2_7__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3253:1: ( rule__Scenario2_7__Group__3__Impl )
            // InternalBug348427TestLanguage.g:3254:2: rule__Scenario2_7__Group__3__Impl
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
    // InternalBug348427TestLanguage.g:3260:1: rule__Scenario2_7__Group__3__Impl : ( 'next' ) ;
    public final void rule__Scenario2_7__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3264:1: ( ( 'next' ) )
            // InternalBug348427TestLanguage.g:3265:1: ( 'next' )
            {
            // InternalBug348427TestLanguage.g:3265:1: ( 'next' )
            // InternalBug348427TestLanguage.g:3266:1: 'next'
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
    // InternalBug348427TestLanguage.g:3287:1: rule__Scenario2_8__Group__0 : rule__Scenario2_8__Group__0__Impl rule__Scenario2_8__Group__1 ;
    public final void rule__Scenario2_8__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3291:1: ( rule__Scenario2_8__Group__0__Impl rule__Scenario2_8__Group__1 )
            // InternalBug348427TestLanguage.g:3292:2: rule__Scenario2_8__Group__0__Impl rule__Scenario2_8__Group__1
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
    // InternalBug348427TestLanguage.g:3299:1: rule__Scenario2_8__Group__0__Impl : ( () ) ;
    public final void rule__Scenario2_8__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3303:1: ( ( () ) )
            // InternalBug348427TestLanguage.g:3304:1: ( () )
            {
            // InternalBug348427TestLanguage.g:3304:1: ( () )
            // InternalBug348427TestLanguage.g:3305:1: ()
            {
             before(grammarAccess.getScenario2_8Access().getScenario2Action_0()); 
            // InternalBug348427TestLanguage.g:3306:1: ()
            // InternalBug348427TestLanguage.g:3308:1: 
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
    // InternalBug348427TestLanguage.g:3318:1: rule__Scenario2_8__Group__1 : rule__Scenario2_8__Group__1__Impl rule__Scenario2_8__Group__2 ;
    public final void rule__Scenario2_8__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3322:1: ( rule__Scenario2_8__Group__1__Impl rule__Scenario2_8__Group__2 )
            // InternalBug348427TestLanguage.g:3323:2: rule__Scenario2_8__Group__1__Impl rule__Scenario2_8__Group__2
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
    // InternalBug348427TestLanguage.g:3330:1: rule__Scenario2_8__Group__1__Impl : ( '2.8' ) ;
    public final void rule__Scenario2_8__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3334:1: ( ( '2.8' ) )
            // InternalBug348427TestLanguage.g:3335:1: ( '2.8' )
            {
            // InternalBug348427TestLanguage.g:3335:1: ( '2.8' )
            // InternalBug348427TestLanguage.g:3336:1: '2.8'
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
    // InternalBug348427TestLanguage.g:3349:1: rule__Scenario2_8__Group__2 : rule__Scenario2_8__Group__2__Impl rule__Scenario2_8__Group__3 ;
    public final void rule__Scenario2_8__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3353:1: ( rule__Scenario2_8__Group__2__Impl rule__Scenario2_8__Group__3 )
            // InternalBug348427TestLanguage.g:3354:2: rule__Scenario2_8__Group__2__Impl rule__Scenario2_8__Group__3
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
    // InternalBug348427TestLanguage.g:3361:1: rule__Scenario2_8__Group__2__Impl : ( ( rule__Scenario2_8__Alternatives_2 )* ) ;
    public final void rule__Scenario2_8__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3365:1: ( ( ( rule__Scenario2_8__Alternatives_2 )* ) )
            // InternalBug348427TestLanguage.g:3366:1: ( ( rule__Scenario2_8__Alternatives_2 )* )
            {
            // InternalBug348427TestLanguage.g:3366:1: ( ( rule__Scenario2_8__Alternatives_2 )* )
            // InternalBug348427TestLanguage.g:3367:1: ( rule__Scenario2_8__Alternatives_2 )*
            {
             before(grammarAccess.getScenario2_8Access().getAlternatives_2()); 
            // InternalBug348427TestLanguage.g:3368:1: ( rule__Scenario2_8__Alternatives_2 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_ID) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalBug348427TestLanguage.g:3368:2: rule__Scenario2_8__Alternatives_2
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
    // InternalBug348427TestLanguage.g:3378:1: rule__Scenario2_8__Group__3 : rule__Scenario2_8__Group__3__Impl ;
    public final void rule__Scenario2_8__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3382:1: ( rule__Scenario2_8__Group__3__Impl )
            // InternalBug348427TestLanguage.g:3383:2: rule__Scenario2_8__Group__3__Impl
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
    // InternalBug348427TestLanguage.g:3389:1: rule__Scenario2_8__Group__3__Impl : ( 'next' ) ;
    public final void rule__Scenario2_8__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3393:1: ( ( 'next' ) )
            // InternalBug348427TestLanguage.g:3394:1: ( 'next' )
            {
            // InternalBug348427TestLanguage.g:3394:1: ( 'next' )
            // InternalBug348427TestLanguage.g:3395:1: 'next'
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
    // InternalBug348427TestLanguage.g:3416:1: rule__Child2_1__Group__0 : rule__Child2_1__Group__0__Impl rule__Child2_1__Group__1 ;
    public final void rule__Child2_1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3420:1: ( rule__Child2_1__Group__0__Impl rule__Child2_1__Group__1 )
            // InternalBug348427TestLanguage.g:3421:2: rule__Child2_1__Group__0__Impl rule__Child2_1__Group__1
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
    // InternalBug348427TestLanguage.g:3428:1: rule__Child2_1__Group__0__Impl : ( ( rule__Child2_1__NameAssignment_0 ) ) ;
    public final void rule__Child2_1__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3432:1: ( ( ( rule__Child2_1__NameAssignment_0 ) ) )
            // InternalBug348427TestLanguage.g:3433:1: ( ( rule__Child2_1__NameAssignment_0 ) )
            {
            // InternalBug348427TestLanguage.g:3433:1: ( ( rule__Child2_1__NameAssignment_0 ) )
            // InternalBug348427TestLanguage.g:3434:1: ( rule__Child2_1__NameAssignment_0 )
            {
             before(grammarAccess.getChild2_1Access().getNameAssignment_0()); 
            // InternalBug348427TestLanguage.g:3435:1: ( rule__Child2_1__NameAssignment_0 )
            // InternalBug348427TestLanguage.g:3435:2: rule__Child2_1__NameAssignment_0
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
    // InternalBug348427TestLanguage.g:3445:1: rule__Child2_1__Group__1 : rule__Child2_1__Group__1__Impl rule__Child2_1__Group__2 ;
    public final void rule__Child2_1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3449:1: ( rule__Child2_1__Group__1__Impl rule__Child2_1__Group__2 )
            // InternalBug348427TestLanguage.g:3450:2: rule__Child2_1__Group__1__Impl rule__Child2_1__Group__2
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
    // InternalBug348427TestLanguage.g:3457:1: rule__Child2_1__Group__1__Impl : ( ':' ) ;
    public final void rule__Child2_1__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3461:1: ( ( ':' ) )
            // InternalBug348427TestLanguage.g:3462:1: ( ':' )
            {
            // InternalBug348427TestLanguage.g:3462:1: ( ':' )
            // InternalBug348427TestLanguage.g:3463:1: ':'
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
    // InternalBug348427TestLanguage.g:3476:1: rule__Child2_1__Group__2 : rule__Child2_1__Group__2__Impl rule__Child2_1__Group__3 ;
    public final void rule__Child2_1__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3480:1: ( rule__Child2_1__Group__2__Impl rule__Child2_1__Group__3 )
            // InternalBug348427TestLanguage.g:3481:2: rule__Child2_1__Group__2__Impl rule__Child2_1__Group__3
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
    // InternalBug348427TestLanguage.g:3488:1: rule__Child2_1__Group__2__Impl : ( ( rule__Child2_1__Group_2__0 )? ) ;
    public final void rule__Child2_1__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3492:1: ( ( ( rule__Child2_1__Group_2__0 )? ) )
            // InternalBug348427TestLanguage.g:3493:1: ( ( rule__Child2_1__Group_2__0 )? )
            {
            // InternalBug348427TestLanguage.g:3493:1: ( ( rule__Child2_1__Group_2__0 )? )
            // InternalBug348427TestLanguage.g:3494:1: ( rule__Child2_1__Group_2__0 )?
            {
             before(grammarAccess.getChild2_1Access().getGroup_2()); 
            // InternalBug348427TestLanguage.g:3495:1: ( rule__Child2_1__Group_2__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==32) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalBug348427TestLanguage.g:3495:2: rule__Child2_1__Group_2__0
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
    // InternalBug348427TestLanguage.g:3505:1: rule__Child2_1__Group__3 : rule__Child2_1__Group__3__Impl rule__Child2_1__Group__4 ;
    public final void rule__Child2_1__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3509:1: ( rule__Child2_1__Group__3__Impl rule__Child2_1__Group__4 )
            // InternalBug348427TestLanguage.g:3510:2: rule__Child2_1__Group__3__Impl rule__Child2_1__Group__4
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
    // InternalBug348427TestLanguage.g:3517:1: rule__Child2_1__Group__3__Impl : ( ( rule__Child2_1__StringAssignment_3 ) ) ;
    public final void rule__Child2_1__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3521:1: ( ( ( rule__Child2_1__StringAssignment_3 ) ) )
            // InternalBug348427TestLanguage.g:3522:1: ( ( rule__Child2_1__StringAssignment_3 ) )
            {
            // InternalBug348427TestLanguage.g:3522:1: ( ( rule__Child2_1__StringAssignment_3 ) )
            // InternalBug348427TestLanguage.g:3523:1: ( rule__Child2_1__StringAssignment_3 )
            {
             before(grammarAccess.getChild2_1Access().getStringAssignment_3()); 
            // InternalBug348427TestLanguage.g:3524:1: ( rule__Child2_1__StringAssignment_3 )
            // InternalBug348427TestLanguage.g:3524:2: rule__Child2_1__StringAssignment_3
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
    // InternalBug348427TestLanguage.g:3534:1: rule__Child2_1__Group__4 : rule__Child2_1__Group__4__Impl rule__Child2_1__Group__5 ;
    public final void rule__Child2_1__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3538:1: ( rule__Child2_1__Group__4__Impl rule__Child2_1__Group__5 )
            // InternalBug348427TestLanguage.g:3539:2: rule__Child2_1__Group__4__Impl rule__Child2_1__Group__5
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
    // InternalBug348427TestLanguage.g:3546:1: rule__Child2_1__Group__4__Impl : ( 'child1' ) ;
    public final void rule__Child2_1__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3550:1: ( ( 'child1' ) )
            // InternalBug348427TestLanguage.g:3551:1: ( 'child1' )
            {
            // InternalBug348427TestLanguage.g:3551:1: ( 'child1' )
            // InternalBug348427TestLanguage.g:3552:1: 'child1'
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
    // InternalBug348427TestLanguage.g:3565:1: rule__Child2_1__Group__5 : rule__Child2_1__Group__5__Impl ;
    public final void rule__Child2_1__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3569:1: ( rule__Child2_1__Group__5__Impl )
            // InternalBug348427TestLanguage.g:3570:2: rule__Child2_1__Group__5__Impl
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
    // InternalBug348427TestLanguage.g:3576:1: rule__Child2_1__Group__5__Impl : ( 'end' ) ;
    public final void rule__Child2_1__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3580:1: ( ( 'end' ) )
            // InternalBug348427TestLanguage.g:3581:1: ( 'end' )
            {
            // InternalBug348427TestLanguage.g:3581:1: ( 'end' )
            // InternalBug348427TestLanguage.g:3582:1: 'end'
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
    // InternalBug348427TestLanguage.g:3607:1: rule__Child2_1__Group_2__0 : rule__Child2_1__Group_2__0__Impl rule__Child2_1__Group_2__1 ;
    public final void rule__Child2_1__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3611:1: ( rule__Child2_1__Group_2__0__Impl rule__Child2_1__Group_2__1 )
            // InternalBug348427TestLanguage.g:3612:2: rule__Child2_1__Group_2__0__Impl rule__Child2_1__Group_2__1
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
    // InternalBug348427TestLanguage.g:3619:1: rule__Child2_1__Group_2__0__Impl : ( ( rule__Child2_1__BoolAssignment_2_0 ) ) ;
    public final void rule__Child2_1__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3623:1: ( ( ( rule__Child2_1__BoolAssignment_2_0 ) ) )
            // InternalBug348427TestLanguage.g:3624:1: ( ( rule__Child2_1__BoolAssignment_2_0 ) )
            {
            // InternalBug348427TestLanguage.g:3624:1: ( ( rule__Child2_1__BoolAssignment_2_0 ) )
            // InternalBug348427TestLanguage.g:3625:1: ( rule__Child2_1__BoolAssignment_2_0 )
            {
             before(grammarAccess.getChild2_1Access().getBoolAssignment_2_0()); 
            // InternalBug348427TestLanguage.g:3626:1: ( rule__Child2_1__BoolAssignment_2_0 )
            // InternalBug348427TestLanguage.g:3626:2: rule__Child2_1__BoolAssignment_2_0
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
    // InternalBug348427TestLanguage.g:3636:1: rule__Child2_1__Group_2__1 : rule__Child2_1__Group_2__1__Impl ;
    public final void rule__Child2_1__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3640:1: ( rule__Child2_1__Group_2__1__Impl )
            // InternalBug348427TestLanguage.g:3641:2: rule__Child2_1__Group_2__1__Impl
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
    // InternalBug348427TestLanguage.g:3647:1: rule__Child2_1__Group_2__1__Impl : ( 'keyword' ) ;
    public final void rule__Child2_1__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3651:1: ( ( 'keyword' ) )
            // InternalBug348427TestLanguage.g:3652:1: ( 'keyword' )
            {
            // InternalBug348427TestLanguage.g:3652:1: ( 'keyword' )
            // InternalBug348427TestLanguage.g:3653:1: 'keyword'
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
    // InternalBug348427TestLanguage.g:3670:1: rule__Child2_2__Group__0 : rule__Child2_2__Group__0__Impl rule__Child2_2__Group__1 ;
    public final void rule__Child2_2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3674:1: ( rule__Child2_2__Group__0__Impl rule__Child2_2__Group__1 )
            // InternalBug348427TestLanguage.g:3675:2: rule__Child2_2__Group__0__Impl rule__Child2_2__Group__1
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
    // InternalBug348427TestLanguage.g:3682:1: rule__Child2_2__Group__0__Impl : ( ( rule__Child2_2__NameAssignment_0 ) ) ;
    public final void rule__Child2_2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3686:1: ( ( ( rule__Child2_2__NameAssignment_0 ) ) )
            // InternalBug348427TestLanguage.g:3687:1: ( ( rule__Child2_2__NameAssignment_0 ) )
            {
            // InternalBug348427TestLanguage.g:3687:1: ( ( rule__Child2_2__NameAssignment_0 ) )
            // InternalBug348427TestLanguage.g:3688:1: ( rule__Child2_2__NameAssignment_0 )
            {
             before(grammarAccess.getChild2_2Access().getNameAssignment_0()); 
            // InternalBug348427TestLanguage.g:3689:1: ( rule__Child2_2__NameAssignment_0 )
            // InternalBug348427TestLanguage.g:3689:2: rule__Child2_2__NameAssignment_0
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
    // InternalBug348427TestLanguage.g:3699:1: rule__Child2_2__Group__1 : rule__Child2_2__Group__1__Impl rule__Child2_2__Group__2 ;
    public final void rule__Child2_2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3703:1: ( rule__Child2_2__Group__1__Impl rule__Child2_2__Group__2 )
            // InternalBug348427TestLanguage.g:3704:2: rule__Child2_2__Group__1__Impl rule__Child2_2__Group__2
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
    // InternalBug348427TestLanguage.g:3711:1: rule__Child2_2__Group__1__Impl : ( ':' ) ;
    public final void rule__Child2_2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3715:1: ( ( ':' ) )
            // InternalBug348427TestLanguage.g:3716:1: ( ':' )
            {
            // InternalBug348427TestLanguage.g:3716:1: ( ':' )
            // InternalBug348427TestLanguage.g:3717:1: ':'
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
    // InternalBug348427TestLanguage.g:3730:1: rule__Child2_2__Group__2 : rule__Child2_2__Group__2__Impl rule__Child2_2__Group__3 ;
    public final void rule__Child2_2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3734:1: ( rule__Child2_2__Group__2__Impl rule__Child2_2__Group__3 )
            // InternalBug348427TestLanguage.g:3735:2: rule__Child2_2__Group__2__Impl rule__Child2_2__Group__3
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
    // InternalBug348427TestLanguage.g:3742:1: rule__Child2_2__Group__2__Impl : ( ( rule__Child2_2__Group_2__0 )? ) ;
    public final void rule__Child2_2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3746:1: ( ( ( rule__Child2_2__Group_2__0 )? ) )
            // InternalBug348427TestLanguage.g:3747:1: ( ( rule__Child2_2__Group_2__0 )? )
            {
            // InternalBug348427TestLanguage.g:3747:1: ( ( rule__Child2_2__Group_2__0 )? )
            // InternalBug348427TestLanguage.g:3748:1: ( rule__Child2_2__Group_2__0 )?
            {
             before(grammarAccess.getChild2_2Access().getGroup_2()); 
            // InternalBug348427TestLanguage.g:3749:1: ( rule__Child2_2__Group_2__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==32) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalBug348427TestLanguage.g:3749:2: rule__Child2_2__Group_2__0
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
    // InternalBug348427TestLanguage.g:3759:1: rule__Child2_2__Group__3 : rule__Child2_2__Group__3__Impl rule__Child2_2__Group__4 ;
    public final void rule__Child2_2__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3763:1: ( rule__Child2_2__Group__3__Impl rule__Child2_2__Group__4 )
            // InternalBug348427TestLanguage.g:3764:2: rule__Child2_2__Group__3__Impl rule__Child2_2__Group__4
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
    // InternalBug348427TestLanguage.g:3771:1: rule__Child2_2__Group__3__Impl : ( ( rule__Child2_2__StringAssignment_3 ) ) ;
    public final void rule__Child2_2__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3775:1: ( ( ( rule__Child2_2__StringAssignment_3 ) ) )
            // InternalBug348427TestLanguage.g:3776:1: ( ( rule__Child2_2__StringAssignment_3 ) )
            {
            // InternalBug348427TestLanguage.g:3776:1: ( ( rule__Child2_2__StringAssignment_3 ) )
            // InternalBug348427TestLanguage.g:3777:1: ( rule__Child2_2__StringAssignment_3 )
            {
             before(grammarAccess.getChild2_2Access().getStringAssignment_3()); 
            // InternalBug348427TestLanguage.g:3778:1: ( rule__Child2_2__StringAssignment_3 )
            // InternalBug348427TestLanguage.g:3778:2: rule__Child2_2__StringAssignment_3
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
    // InternalBug348427TestLanguage.g:3788:1: rule__Child2_2__Group__4 : rule__Child2_2__Group__4__Impl rule__Child2_2__Group__5 ;
    public final void rule__Child2_2__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3792:1: ( rule__Child2_2__Group__4__Impl rule__Child2_2__Group__5 )
            // InternalBug348427TestLanguage.g:3793:2: rule__Child2_2__Group__4__Impl rule__Child2_2__Group__5
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
    // InternalBug348427TestLanguage.g:3800:1: rule__Child2_2__Group__4__Impl : ( 'child2' ) ;
    public final void rule__Child2_2__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3804:1: ( ( 'child2' ) )
            // InternalBug348427TestLanguage.g:3805:1: ( 'child2' )
            {
            // InternalBug348427TestLanguage.g:3805:1: ( 'child2' )
            // InternalBug348427TestLanguage.g:3806:1: 'child2'
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
    // InternalBug348427TestLanguage.g:3819:1: rule__Child2_2__Group__5 : rule__Child2_2__Group__5__Impl ;
    public final void rule__Child2_2__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3823:1: ( rule__Child2_2__Group__5__Impl )
            // InternalBug348427TestLanguage.g:3824:2: rule__Child2_2__Group__5__Impl
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
    // InternalBug348427TestLanguage.g:3830:1: rule__Child2_2__Group__5__Impl : ( 'end' ) ;
    public final void rule__Child2_2__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3834:1: ( ( 'end' ) )
            // InternalBug348427TestLanguage.g:3835:1: ( 'end' )
            {
            // InternalBug348427TestLanguage.g:3835:1: ( 'end' )
            // InternalBug348427TestLanguage.g:3836:1: 'end'
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
    // InternalBug348427TestLanguage.g:3861:1: rule__Child2_2__Group_2__0 : rule__Child2_2__Group_2__0__Impl rule__Child2_2__Group_2__1 ;
    public final void rule__Child2_2__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3865:1: ( rule__Child2_2__Group_2__0__Impl rule__Child2_2__Group_2__1 )
            // InternalBug348427TestLanguage.g:3866:2: rule__Child2_2__Group_2__0__Impl rule__Child2_2__Group_2__1
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
    // InternalBug348427TestLanguage.g:3873:1: rule__Child2_2__Group_2__0__Impl : ( ( rule__Child2_2__BoolAssignment_2_0 ) ) ;
    public final void rule__Child2_2__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3877:1: ( ( ( rule__Child2_2__BoolAssignment_2_0 ) ) )
            // InternalBug348427TestLanguage.g:3878:1: ( ( rule__Child2_2__BoolAssignment_2_0 ) )
            {
            // InternalBug348427TestLanguage.g:3878:1: ( ( rule__Child2_2__BoolAssignment_2_0 ) )
            // InternalBug348427TestLanguage.g:3879:1: ( rule__Child2_2__BoolAssignment_2_0 )
            {
             before(grammarAccess.getChild2_2Access().getBoolAssignment_2_0()); 
            // InternalBug348427TestLanguage.g:3880:1: ( rule__Child2_2__BoolAssignment_2_0 )
            // InternalBug348427TestLanguage.g:3880:2: rule__Child2_2__BoolAssignment_2_0
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
    // InternalBug348427TestLanguage.g:3890:1: rule__Child2_2__Group_2__1 : rule__Child2_2__Group_2__1__Impl ;
    public final void rule__Child2_2__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3894:1: ( rule__Child2_2__Group_2__1__Impl )
            // InternalBug348427TestLanguage.g:3895:2: rule__Child2_2__Group_2__1__Impl
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
    // InternalBug348427TestLanguage.g:3901:1: rule__Child2_2__Group_2__1__Impl : ( 'keyword' ) ;
    public final void rule__Child2_2__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3905:1: ( ( 'keyword' ) )
            // InternalBug348427TestLanguage.g:3906:1: ( 'keyword' )
            {
            // InternalBug348427TestLanguage.g:3906:1: ( 'keyword' )
            // InternalBug348427TestLanguage.g:3907:1: 'keyword'
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
    // InternalBug348427TestLanguage.g:3924:1: rule__Child2_3__Group__0 : rule__Child2_3__Group__0__Impl rule__Child2_3__Group__1 ;
    public final void rule__Child2_3__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3928:1: ( rule__Child2_3__Group__0__Impl rule__Child2_3__Group__1 )
            // InternalBug348427TestLanguage.g:3929:2: rule__Child2_3__Group__0__Impl rule__Child2_3__Group__1
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
    // InternalBug348427TestLanguage.g:3936:1: rule__Child2_3__Group__0__Impl : ( ( rule__Child2_3__NameAssignment_0 ) ) ;
    public final void rule__Child2_3__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3940:1: ( ( ( rule__Child2_3__NameAssignment_0 ) ) )
            // InternalBug348427TestLanguage.g:3941:1: ( ( rule__Child2_3__NameAssignment_0 ) )
            {
            // InternalBug348427TestLanguage.g:3941:1: ( ( rule__Child2_3__NameAssignment_0 ) )
            // InternalBug348427TestLanguage.g:3942:1: ( rule__Child2_3__NameAssignment_0 )
            {
             before(grammarAccess.getChild2_3Access().getNameAssignment_0()); 
            // InternalBug348427TestLanguage.g:3943:1: ( rule__Child2_3__NameAssignment_0 )
            // InternalBug348427TestLanguage.g:3943:2: rule__Child2_3__NameAssignment_0
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
    // InternalBug348427TestLanguage.g:3953:1: rule__Child2_3__Group__1 : rule__Child2_3__Group__1__Impl rule__Child2_3__Group__2 ;
    public final void rule__Child2_3__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3957:1: ( rule__Child2_3__Group__1__Impl rule__Child2_3__Group__2 )
            // InternalBug348427TestLanguage.g:3958:2: rule__Child2_3__Group__1__Impl rule__Child2_3__Group__2
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
    // InternalBug348427TestLanguage.g:3965:1: rule__Child2_3__Group__1__Impl : ( ':' ) ;
    public final void rule__Child2_3__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3969:1: ( ( ':' ) )
            // InternalBug348427TestLanguage.g:3970:1: ( ':' )
            {
            // InternalBug348427TestLanguage.g:3970:1: ( ':' )
            // InternalBug348427TestLanguage.g:3971:1: ':'
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
    // InternalBug348427TestLanguage.g:3984:1: rule__Child2_3__Group__2 : rule__Child2_3__Group__2__Impl rule__Child2_3__Group__3 ;
    public final void rule__Child2_3__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:3988:1: ( rule__Child2_3__Group__2__Impl rule__Child2_3__Group__3 )
            // InternalBug348427TestLanguage.g:3989:2: rule__Child2_3__Group__2__Impl rule__Child2_3__Group__3
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
    // InternalBug348427TestLanguage.g:3996:1: rule__Child2_3__Group__2__Impl : ( ( rule__Child2_3__Group_2__0 )? ) ;
    public final void rule__Child2_3__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4000:1: ( ( ( rule__Child2_3__Group_2__0 )? ) )
            // InternalBug348427TestLanguage.g:4001:1: ( ( rule__Child2_3__Group_2__0 )? )
            {
            // InternalBug348427TestLanguage.g:4001:1: ( ( rule__Child2_3__Group_2__0 )? )
            // InternalBug348427TestLanguage.g:4002:1: ( rule__Child2_3__Group_2__0 )?
            {
             before(grammarAccess.getChild2_3Access().getGroup_2()); 
            // InternalBug348427TestLanguage.g:4003:1: ( rule__Child2_3__Group_2__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==32) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalBug348427TestLanguage.g:4003:2: rule__Child2_3__Group_2__0
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
    // InternalBug348427TestLanguage.g:4013:1: rule__Child2_3__Group__3 : rule__Child2_3__Group__3__Impl rule__Child2_3__Group__4 ;
    public final void rule__Child2_3__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4017:1: ( rule__Child2_3__Group__3__Impl rule__Child2_3__Group__4 )
            // InternalBug348427TestLanguage.g:4018:2: rule__Child2_3__Group__3__Impl rule__Child2_3__Group__4
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
    // InternalBug348427TestLanguage.g:4025:1: rule__Child2_3__Group__3__Impl : ( ( rule__Child2_3__StringAssignment_3 ) ) ;
    public final void rule__Child2_3__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4029:1: ( ( ( rule__Child2_3__StringAssignment_3 ) ) )
            // InternalBug348427TestLanguage.g:4030:1: ( ( rule__Child2_3__StringAssignment_3 ) )
            {
            // InternalBug348427TestLanguage.g:4030:1: ( ( rule__Child2_3__StringAssignment_3 ) )
            // InternalBug348427TestLanguage.g:4031:1: ( rule__Child2_3__StringAssignment_3 )
            {
             before(grammarAccess.getChild2_3Access().getStringAssignment_3()); 
            // InternalBug348427TestLanguage.g:4032:1: ( rule__Child2_3__StringAssignment_3 )
            // InternalBug348427TestLanguage.g:4032:2: rule__Child2_3__StringAssignment_3
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
    // InternalBug348427TestLanguage.g:4042:1: rule__Child2_3__Group__4 : rule__Child2_3__Group__4__Impl rule__Child2_3__Group__5 ;
    public final void rule__Child2_3__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4046:1: ( rule__Child2_3__Group__4__Impl rule__Child2_3__Group__5 )
            // InternalBug348427TestLanguage.g:4047:2: rule__Child2_3__Group__4__Impl rule__Child2_3__Group__5
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
    // InternalBug348427TestLanguage.g:4054:1: rule__Child2_3__Group__4__Impl : ( 'child3' ) ;
    public final void rule__Child2_3__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4058:1: ( ( 'child3' ) )
            // InternalBug348427TestLanguage.g:4059:1: ( 'child3' )
            {
            // InternalBug348427TestLanguage.g:4059:1: ( 'child3' )
            // InternalBug348427TestLanguage.g:4060:1: 'child3'
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
    // InternalBug348427TestLanguage.g:4073:1: rule__Child2_3__Group__5 : rule__Child2_3__Group__5__Impl ;
    public final void rule__Child2_3__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4077:1: ( rule__Child2_3__Group__5__Impl )
            // InternalBug348427TestLanguage.g:4078:2: rule__Child2_3__Group__5__Impl
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
    // InternalBug348427TestLanguage.g:4084:1: rule__Child2_3__Group__5__Impl : ( 'end' ) ;
    public final void rule__Child2_3__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4088:1: ( ( 'end' ) )
            // InternalBug348427TestLanguage.g:4089:1: ( 'end' )
            {
            // InternalBug348427TestLanguage.g:4089:1: ( 'end' )
            // InternalBug348427TestLanguage.g:4090:1: 'end'
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
    // InternalBug348427TestLanguage.g:4115:1: rule__Child2_3__Group_2__0 : rule__Child2_3__Group_2__0__Impl rule__Child2_3__Group_2__1 ;
    public final void rule__Child2_3__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4119:1: ( rule__Child2_3__Group_2__0__Impl rule__Child2_3__Group_2__1 )
            // InternalBug348427TestLanguage.g:4120:2: rule__Child2_3__Group_2__0__Impl rule__Child2_3__Group_2__1
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
    // InternalBug348427TestLanguage.g:4127:1: rule__Child2_3__Group_2__0__Impl : ( ( rule__Child2_3__BoolAssignment_2_0 ) ) ;
    public final void rule__Child2_3__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4131:1: ( ( ( rule__Child2_3__BoolAssignment_2_0 ) ) )
            // InternalBug348427TestLanguage.g:4132:1: ( ( rule__Child2_3__BoolAssignment_2_0 ) )
            {
            // InternalBug348427TestLanguage.g:4132:1: ( ( rule__Child2_3__BoolAssignment_2_0 ) )
            // InternalBug348427TestLanguage.g:4133:1: ( rule__Child2_3__BoolAssignment_2_0 )
            {
             before(grammarAccess.getChild2_3Access().getBoolAssignment_2_0()); 
            // InternalBug348427TestLanguage.g:4134:1: ( rule__Child2_3__BoolAssignment_2_0 )
            // InternalBug348427TestLanguage.g:4134:2: rule__Child2_3__BoolAssignment_2_0
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
    // InternalBug348427TestLanguage.g:4144:1: rule__Child2_3__Group_2__1 : rule__Child2_3__Group_2__1__Impl ;
    public final void rule__Child2_3__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4148:1: ( rule__Child2_3__Group_2__1__Impl )
            // InternalBug348427TestLanguage.g:4149:2: rule__Child2_3__Group_2__1__Impl
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
    // InternalBug348427TestLanguage.g:4155:1: rule__Child2_3__Group_2__1__Impl : ( 'keyword' ) ;
    public final void rule__Child2_3__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4159:1: ( ( 'keyword' ) )
            // InternalBug348427TestLanguage.g:4160:1: ( 'keyword' )
            {
            // InternalBug348427TestLanguage.g:4160:1: ( 'keyword' )
            // InternalBug348427TestLanguage.g:4161:1: 'keyword'
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
    // InternalBug348427TestLanguage.g:4178:1: rule__Child2_4__Group__0 : rule__Child2_4__Group__0__Impl rule__Child2_4__Group__1 ;
    public final void rule__Child2_4__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4182:1: ( rule__Child2_4__Group__0__Impl rule__Child2_4__Group__1 )
            // InternalBug348427TestLanguage.g:4183:2: rule__Child2_4__Group__0__Impl rule__Child2_4__Group__1
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
    // InternalBug348427TestLanguage.g:4190:1: rule__Child2_4__Group__0__Impl : ( ( rule__Child2_4__NameAssignment_0 ) ) ;
    public final void rule__Child2_4__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4194:1: ( ( ( rule__Child2_4__NameAssignment_0 ) ) )
            // InternalBug348427TestLanguage.g:4195:1: ( ( rule__Child2_4__NameAssignment_0 ) )
            {
            // InternalBug348427TestLanguage.g:4195:1: ( ( rule__Child2_4__NameAssignment_0 ) )
            // InternalBug348427TestLanguage.g:4196:1: ( rule__Child2_4__NameAssignment_0 )
            {
             before(grammarAccess.getChild2_4Access().getNameAssignment_0()); 
            // InternalBug348427TestLanguage.g:4197:1: ( rule__Child2_4__NameAssignment_0 )
            // InternalBug348427TestLanguage.g:4197:2: rule__Child2_4__NameAssignment_0
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
    // InternalBug348427TestLanguage.g:4207:1: rule__Child2_4__Group__1 : rule__Child2_4__Group__1__Impl rule__Child2_4__Group__2 ;
    public final void rule__Child2_4__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4211:1: ( rule__Child2_4__Group__1__Impl rule__Child2_4__Group__2 )
            // InternalBug348427TestLanguage.g:4212:2: rule__Child2_4__Group__1__Impl rule__Child2_4__Group__2
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
    // InternalBug348427TestLanguage.g:4219:1: rule__Child2_4__Group__1__Impl : ( ':' ) ;
    public final void rule__Child2_4__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4223:1: ( ( ':' ) )
            // InternalBug348427TestLanguage.g:4224:1: ( ':' )
            {
            // InternalBug348427TestLanguage.g:4224:1: ( ':' )
            // InternalBug348427TestLanguage.g:4225:1: ':'
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
    // InternalBug348427TestLanguage.g:4238:1: rule__Child2_4__Group__2 : rule__Child2_4__Group__2__Impl rule__Child2_4__Group__3 ;
    public final void rule__Child2_4__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4242:1: ( rule__Child2_4__Group__2__Impl rule__Child2_4__Group__3 )
            // InternalBug348427TestLanguage.g:4243:2: rule__Child2_4__Group__2__Impl rule__Child2_4__Group__3
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
    // InternalBug348427TestLanguage.g:4250:1: rule__Child2_4__Group__2__Impl : ( ( rule__Child2_4__Group_2__0 )? ) ;
    public final void rule__Child2_4__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4254:1: ( ( ( rule__Child2_4__Group_2__0 )? ) )
            // InternalBug348427TestLanguage.g:4255:1: ( ( rule__Child2_4__Group_2__0 )? )
            {
            // InternalBug348427TestLanguage.g:4255:1: ( ( rule__Child2_4__Group_2__0 )? )
            // InternalBug348427TestLanguage.g:4256:1: ( rule__Child2_4__Group_2__0 )?
            {
             before(grammarAccess.getChild2_4Access().getGroup_2()); 
            // InternalBug348427TestLanguage.g:4257:1: ( rule__Child2_4__Group_2__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==32) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalBug348427TestLanguage.g:4257:2: rule__Child2_4__Group_2__0
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
    // InternalBug348427TestLanguage.g:4267:1: rule__Child2_4__Group__3 : rule__Child2_4__Group__3__Impl rule__Child2_4__Group__4 ;
    public final void rule__Child2_4__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4271:1: ( rule__Child2_4__Group__3__Impl rule__Child2_4__Group__4 )
            // InternalBug348427TestLanguage.g:4272:2: rule__Child2_4__Group__3__Impl rule__Child2_4__Group__4
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
    // InternalBug348427TestLanguage.g:4279:1: rule__Child2_4__Group__3__Impl : ( ( rule__Child2_4__Alternatives_3 ) ) ;
    public final void rule__Child2_4__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4283:1: ( ( ( rule__Child2_4__Alternatives_3 ) ) )
            // InternalBug348427TestLanguage.g:4284:1: ( ( rule__Child2_4__Alternatives_3 ) )
            {
            // InternalBug348427TestLanguage.g:4284:1: ( ( rule__Child2_4__Alternatives_3 ) )
            // InternalBug348427TestLanguage.g:4285:1: ( rule__Child2_4__Alternatives_3 )
            {
             before(grammarAccess.getChild2_4Access().getAlternatives_3()); 
            // InternalBug348427TestLanguage.g:4286:1: ( rule__Child2_4__Alternatives_3 )
            // InternalBug348427TestLanguage.g:4286:2: rule__Child2_4__Alternatives_3
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
    // InternalBug348427TestLanguage.g:4296:1: rule__Child2_4__Group__4 : rule__Child2_4__Group__4__Impl rule__Child2_4__Group__5 ;
    public final void rule__Child2_4__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4300:1: ( rule__Child2_4__Group__4__Impl rule__Child2_4__Group__5 )
            // InternalBug348427TestLanguage.g:4301:2: rule__Child2_4__Group__4__Impl rule__Child2_4__Group__5
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
    // InternalBug348427TestLanguage.g:4308:1: rule__Child2_4__Group__4__Impl : ( 'child1' ) ;
    public final void rule__Child2_4__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4312:1: ( ( 'child1' ) )
            // InternalBug348427TestLanguage.g:4313:1: ( 'child1' )
            {
            // InternalBug348427TestLanguage.g:4313:1: ( 'child1' )
            // InternalBug348427TestLanguage.g:4314:1: 'child1'
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
    // InternalBug348427TestLanguage.g:4327:1: rule__Child2_4__Group__5 : rule__Child2_4__Group__5__Impl ;
    public final void rule__Child2_4__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4331:1: ( rule__Child2_4__Group__5__Impl )
            // InternalBug348427TestLanguage.g:4332:2: rule__Child2_4__Group__5__Impl
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
    // InternalBug348427TestLanguage.g:4338:1: rule__Child2_4__Group__5__Impl : ( 'end' ) ;
    public final void rule__Child2_4__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4342:1: ( ( 'end' ) )
            // InternalBug348427TestLanguage.g:4343:1: ( 'end' )
            {
            // InternalBug348427TestLanguage.g:4343:1: ( 'end' )
            // InternalBug348427TestLanguage.g:4344:1: 'end'
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
    // InternalBug348427TestLanguage.g:4369:1: rule__Child2_4__Group_2__0 : rule__Child2_4__Group_2__0__Impl rule__Child2_4__Group_2__1 ;
    public final void rule__Child2_4__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4373:1: ( rule__Child2_4__Group_2__0__Impl rule__Child2_4__Group_2__1 )
            // InternalBug348427TestLanguage.g:4374:2: rule__Child2_4__Group_2__0__Impl rule__Child2_4__Group_2__1
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
    // InternalBug348427TestLanguage.g:4381:1: rule__Child2_4__Group_2__0__Impl : ( ( rule__Child2_4__BoolAssignment_2_0 ) ) ;
    public final void rule__Child2_4__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4385:1: ( ( ( rule__Child2_4__BoolAssignment_2_0 ) ) )
            // InternalBug348427TestLanguage.g:4386:1: ( ( rule__Child2_4__BoolAssignment_2_0 ) )
            {
            // InternalBug348427TestLanguage.g:4386:1: ( ( rule__Child2_4__BoolAssignment_2_0 ) )
            // InternalBug348427TestLanguage.g:4387:1: ( rule__Child2_4__BoolAssignment_2_0 )
            {
             before(grammarAccess.getChild2_4Access().getBoolAssignment_2_0()); 
            // InternalBug348427TestLanguage.g:4388:1: ( rule__Child2_4__BoolAssignment_2_0 )
            // InternalBug348427TestLanguage.g:4388:2: rule__Child2_4__BoolAssignment_2_0
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
    // InternalBug348427TestLanguage.g:4398:1: rule__Child2_4__Group_2__1 : rule__Child2_4__Group_2__1__Impl ;
    public final void rule__Child2_4__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4402:1: ( rule__Child2_4__Group_2__1__Impl )
            // InternalBug348427TestLanguage.g:4403:2: rule__Child2_4__Group_2__1__Impl
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
    // InternalBug348427TestLanguage.g:4409:1: rule__Child2_4__Group_2__1__Impl : ( 'keyword' ) ;
    public final void rule__Child2_4__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4413:1: ( ( 'keyword' ) )
            // InternalBug348427TestLanguage.g:4414:1: ( 'keyword' )
            {
            // InternalBug348427TestLanguage.g:4414:1: ( 'keyword' )
            // InternalBug348427TestLanguage.g:4415:1: 'keyword'
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
    // InternalBug348427TestLanguage.g:4432:1: rule__Child2_5__Group__0 : rule__Child2_5__Group__0__Impl rule__Child2_5__Group__1 ;
    public final void rule__Child2_5__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4436:1: ( rule__Child2_5__Group__0__Impl rule__Child2_5__Group__1 )
            // InternalBug348427TestLanguage.g:4437:2: rule__Child2_5__Group__0__Impl rule__Child2_5__Group__1
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
    // InternalBug348427TestLanguage.g:4444:1: rule__Child2_5__Group__0__Impl : ( ( rule__Child2_5__NameAssignment_0 ) ) ;
    public final void rule__Child2_5__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4448:1: ( ( ( rule__Child2_5__NameAssignment_0 ) ) )
            // InternalBug348427TestLanguage.g:4449:1: ( ( rule__Child2_5__NameAssignment_0 ) )
            {
            // InternalBug348427TestLanguage.g:4449:1: ( ( rule__Child2_5__NameAssignment_0 ) )
            // InternalBug348427TestLanguage.g:4450:1: ( rule__Child2_5__NameAssignment_0 )
            {
             before(grammarAccess.getChild2_5Access().getNameAssignment_0()); 
            // InternalBug348427TestLanguage.g:4451:1: ( rule__Child2_5__NameAssignment_0 )
            // InternalBug348427TestLanguage.g:4451:2: rule__Child2_5__NameAssignment_0
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
    // InternalBug348427TestLanguage.g:4461:1: rule__Child2_5__Group__1 : rule__Child2_5__Group__1__Impl rule__Child2_5__Group__2 ;
    public final void rule__Child2_5__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4465:1: ( rule__Child2_5__Group__1__Impl rule__Child2_5__Group__2 )
            // InternalBug348427TestLanguage.g:4466:2: rule__Child2_5__Group__1__Impl rule__Child2_5__Group__2
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
    // InternalBug348427TestLanguage.g:4473:1: rule__Child2_5__Group__1__Impl : ( ':' ) ;
    public final void rule__Child2_5__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4477:1: ( ( ':' ) )
            // InternalBug348427TestLanguage.g:4478:1: ( ':' )
            {
            // InternalBug348427TestLanguage.g:4478:1: ( ':' )
            // InternalBug348427TestLanguage.g:4479:1: ':'
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
    // InternalBug348427TestLanguage.g:4492:1: rule__Child2_5__Group__2 : rule__Child2_5__Group__2__Impl rule__Child2_5__Group__3 ;
    public final void rule__Child2_5__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4496:1: ( rule__Child2_5__Group__2__Impl rule__Child2_5__Group__3 )
            // InternalBug348427TestLanguage.g:4497:2: rule__Child2_5__Group__2__Impl rule__Child2_5__Group__3
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
    // InternalBug348427TestLanguage.g:4504:1: rule__Child2_5__Group__2__Impl : ( ( rule__Child2_5__Group_2__0 )? ) ;
    public final void rule__Child2_5__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4508:1: ( ( ( rule__Child2_5__Group_2__0 )? ) )
            // InternalBug348427TestLanguage.g:4509:1: ( ( rule__Child2_5__Group_2__0 )? )
            {
            // InternalBug348427TestLanguage.g:4509:1: ( ( rule__Child2_5__Group_2__0 )? )
            // InternalBug348427TestLanguage.g:4510:1: ( rule__Child2_5__Group_2__0 )?
            {
             before(grammarAccess.getChild2_5Access().getGroup_2()); 
            // InternalBug348427TestLanguage.g:4511:1: ( rule__Child2_5__Group_2__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==32) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalBug348427TestLanguage.g:4511:2: rule__Child2_5__Group_2__0
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
    // InternalBug348427TestLanguage.g:4521:1: rule__Child2_5__Group__3 : rule__Child2_5__Group__3__Impl rule__Child2_5__Group__4 ;
    public final void rule__Child2_5__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4525:1: ( rule__Child2_5__Group__3__Impl rule__Child2_5__Group__4 )
            // InternalBug348427TestLanguage.g:4526:2: rule__Child2_5__Group__3__Impl rule__Child2_5__Group__4
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
    // InternalBug348427TestLanguage.g:4533:1: rule__Child2_5__Group__3__Impl : ( ( rule__Child2_5__Alternatives_3 ) ) ;
    public final void rule__Child2_5__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4537:1: ( ( ( rule__Child2_5__Alternatives_3 ) ) )
            // InternalBug348427TestLanguage.g:4538:1: ( ( rule__Child2_5__Alternatives_3 ) )
            {
            // InternalBug348427TestLanguage.g:4538:1: ( ( rule__Child2_5__Alternatives_3 ) )
            // InternalBug348427TestLanguage.g:4539:1: ( rule__Child2_5__Alternatives_3 )
            {
             before(grammarAccess.getChild2_5Access().getAlternatives_3()); 
            // InternalBug348427TestLanguage.g:4540:1: ( rule__Child2_5__Alternatives_3 )
            // InternalBug348427TestLanguage.g:4540:2: rule__Child2_5__Alternatives_3
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
    // InternalBug348427TestLanguage.g:4550:1: rule__Child2_5__Group__4 : rule__Child2_5__Group__4__Impl rule__Child2_5__Group__5 ;
    public final void rule__Child2_5__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4554:1: ( rule__Child2_5__Group__4__Impl rule__Child2_5__Group__5 )
            // InternalBug348427TestLanguage.g:4555:2: rule__Child2_5__Group__4__Impl rule__Child2_5__Group__5
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
    // InternalBug348427TestLanguage.g:4562:1: rule__Child2_5__Group__4__Impl : ( 'child2' ) ;
    public final void rule__Child2_5__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4566:1: ( ( 'child2' ) )
            // InternalBug348427TestLanguage.g:4567:1: ( 'child2' )
            {
            // InternalBug348427TestLanguage.g:4567:1: ( 'child2' )
            // InternalBug348427TestLanguage.g:4568:1: 'child2'
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
    // InternalBug348427TestLanguage.g:4581:1: rule__Child2_5__Group__5 : rule__Child2_5__Group__5__Impl ;
    public final void rule__Child2_5__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4585:1: ( rule__Child2_5__Group__5__Impl )
            // InternalBug348427TestLanguage.g:4586:2: rule__Child2_5__Group__5__Impl
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
    // InternalBug348427TestLanguage.g:4592:1: rule__Child2_5__Group__5__Impl : ( 'end' ) ;
    public final void rule__Child2_5__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4596:1: ( ( 'end' ) )
            // InternalBug348427TestLanguage.g:4597:1: ( 'end' )
            {
            // InternalBug348427TestLanguage.g:4597:1: ( 'end' )
            // InternalBug348427TestLanguage.g:4598:1: 'end'
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
    // InternalBug348427TestLanguage.g:4623:1: rule__Child2_5__Group_2__0 : rule__Child2_5__Group_2__0__Impl rule__Child2_5__Group_2__1 ;
    public final void rule__Child2_5__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4627:1: ( rule__Child2_5__Group_2__0__Impl rule__Child2_5__Group_2__1 )
            // InternalBug348427TestLanguage.g:4628:2: rule__Child2_5__Group_2__0__Impl rule__Child2_5__Group_2__1
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
    // InternalBug348427TestLanguage.g:4635:1: rule__Child2_5__Group_2__0__Impl : ( ( rule__Child2_5__BoolAssignment_2_0 ) ) ;
    public final void rule__Child2_5__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4639:1: ( ( ( rule__Child2_5__BoolAssignment_2_0 ) ) )
            // InternalBug348427TestLanguage.g:4640:1: ( ( rule__Child2_5__BoolAssignment_2_0 ) )
            {
            // InternalBug348427TestLanguage.g:4640:1: ( ( rule__Child2_5__BoolAssignment_2_0 ) )
            // InternalBug348427TestLanguage.g:4641:1: ( rule__Child2_5__BoolAssignment_2_0 )
            {
             before(grammarAccess.getChild2_5Access().getBoolAssignment_2_0()); 
            // InternalBug348427TestLanguage.g:4642:1: ( rule__Child2_5__BoolAssignment_2_0 )
            // InternalBug348427TestLanguage.g:4642:2: rule__Child2_5__BoolAssignment_2_0
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
    // InternalBug348427TestLanguage.g:4652:1: rule__Child2_5__Group_2__1 : rule__Child2_5__Group_2__1__Impl ;
    public final void rule__Child2_5__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4656:1: ( rule__Child2_5__Group_2__1__Impl )
            // InternalBug348427TestLanguage.g:4657:2: rule__Child2_5__Group_2__1__Impl
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
    // InternalBug348427TestLanguage.g:4663:1: rule__Child2_5__Group_2__1__Impl : ( 'keyword' ) ;
    public final void rule__Child2_5__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4667:1: ( ( 'keyword' ) )
            // InternalBug348427TestLanguage.g:4668:1: ( 'keyword' )
            {
            // InternalBug348427TestLanguage.g:4668:1: ( 'keyword' )
            // InternalBug348427TestLanguage.g:4669:1: 'keyword'
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
    // InternalBug348427TestLanguage.g:4686:1: rule__Child2_6__Group__0 : rule__Child2_6__Group__0__Impl rule__Child2_6__Group__1 ;
    public final void rule__Child2_6__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4690:1: ( rule__Child2_6__Group__0__Impl rule__Child2_6__Group__1 )
            // InternalBug348427TestLanguage.g:4691:2: rule__Child2_6__Group__0__Impl rule__Child2_6__Group__1
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
    // InternalBug348427TestLanguage.g:4698:1: rule__Child2_6__Group__0__Impl : ( ( rule__Child2_6__NameAssignment_0 ) ) ;
    public final void rule__Child2_6__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4702:1: ( ( ( rule__Child2_6__NameAssignment_0 ) ) )
            // InternalBug348427TestLanguage.g:4703:1: ( ( rule__Child2_6__NameAssignment_0 ) )
            {
            // InternalBug348427TestLanguage.g:4703:1: ( ( rule__Child2_6__NameAssignment_0 ) )
            // InternalBug348427TestLanguage.g:4704:1: ( rule__Child2_6__NameAssignment_0 )
            {
             before(grammarAccess.getChild2_6Access().getNameAssignment_0()); 
            // InternalBug348427TestLanguage.g:4705:1: ( rule__Child2_6__NameAssignment_0 )
            // InternalBug348427TestLanguage.g:4705:2: rule__Child2_6__NameAssignment_0
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
    // InternalBug348427TestLanguage.g:4715:1: rule__Child2_6__Group__1 : rule__Child2_6__Group__1__Impl rule__Child2_6__Group__2 ;
    public final void rule__Child2_6__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4719:1: ( rule__Child2_6__Group__1__Impl rule__Child2_6__Group__2 )
            // InternalBug348427TestLanguage.g:4720:2: rule__Child2_6__Group__1__Impl rule__Child2_6__Group__2
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
    // InternalBug348427TestLanguage.g:4727:1: rule__Child2_6__Group__1__Impl : ( ':' ) ;
    public final void rule__Child2_6__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4731:1: ( ( ':' ) )
            // InternalBug348427TestLanguage.g:4732:1: ( ':' )
            {
            // InternalBug348427TestLanguage.g:4732:1: ( ':' )
            // InternalBug348427TestLanguage.g:4733:1: ':'
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
    // InternalBug348427TestLanguage.g:4746:1: rule__Child2_6__Group__2 : rule__Child2_6__Group__2__Impl rule__Child2_6__Group__3 ;
    public final void rule__Child2_6__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4750:1: ( rule__Child2_6__Group__2__Impl rule__Child2_6__Group__3 )
            // InternalBug348427TestLanguage.g:4751:2: rule__Child2_6__Group__2__Impl rule__Child2_6__Group__3
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
    // InternalBug348427TestLanguage.g:4758:1: rule__Child2_6__Group__2__Impl : ( ( rule__Child2_6__Group_2__0 )? ) ;
    public final void rule__Child2_6__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4762:1: ( ( ( rule__Child2_6__Group_2__0 )? ) )
            // InternalBug348427TestLanguage.g:4763:1: ( ( rule__Child2_6__Group_2__0 )? )
            {
            // InternalBug348427TestLanguage.g:4763:1: ( ( rule__Child2_6__Group_2__0 )? )
            // InternalBug348427TestLanguage.g:4764:1: ( rule__Child2_6__Group_2__0 )?
            {
             before(grammarAccess.getChild2_6Access().getGroup_2()); 
            // InternalBug348427TestLanguage.g:4765:1: ( rule__Child2_6__Group_2__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==32) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalBug348427TestLanguage.g:4765:2: rule__Child2_6__Group_2__0
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
    // InternalBug348427TestLanguage.g:4775:1: rule__Child2_6__Group__3 : rule__Child2_6__Group__3__Impl rule__Child2_6__Group__4 ;
    public final void rule__Child2_6__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4779:1: ( rule__Child2_6__Group__3__Impl rule__Child2_6__Group__4 )
            // InternalBug348427TestLanguage.g:4780:2: rule__Child2_6__Group__3__Impl rule__Child2_6__Group__4
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
    // InternalBug348427TestLanguage.g:4787:1: rule__Child2_6__Group__3__Impl : ( ( rule__Child2_6__Alternatives_3 ) ) ;
    public final void rule__Child2_6__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4791:1: ( ( ( rule__Child2_6__Alternatives_3 ) ) )
            // InternalBug348427TestLanguage.g:4792:1: ( ( rule__Child2_6__Alternatives_3 ) )
            {
            // InternalBug348427TestLanguage.g:4792:1: ( ( rule__Child2_6__Alternatives_3 ) )
            // InternalBug348427TestLanguage.g:4793:1: ( rule__Child2_6__Alternatives_3 )
            {
             before(grammarAccess.getChild2_6Access().getAlternatives_3()); 
            // InternalBug348427TestLanguage.g:4794:1: ( rule__Child2_6__Alternatives_3 )
            // InternalBug348427TestLanguage.g:4794:2: rule__Child2_6__Alternatives_3
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
    // InternalBug348427TestLanguage.g:4804:1: rule__Child2_6__Group__4 : rule__Child2_6__Group__4__Impl rule__Child2_6__Group__5 ;
    public final void rule__Child2_6__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4808:1: ( rule__Child2_6__Group__4__Impl rule__Child2_6__Group__5 )
            // InternalBug348427TestLanguage.g:4809:2: rule__Child2_6__Group__4__Impl rule__Child2_6__Group__5
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
    // InternalBug348427TestLanguage.g:4816:1: rule__Child2_6__Group__4__Impl : ( 'child3' ) ;
    public final void rule__Child2_6__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4820:1: ( ( 'child3' ) )
            // InternalBug348427TestLanguage.g:4821:1: ( 'child3' )
            {
            // InternalBug348427TestLanguage.g:4821:1: ( 'child3' )
            // InternalBug348427TestLanguage.g:4822:1: 'child3'
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
    // InternalBug348427TestLanguage.g:4835:1: rule__Child2_6__Group__5 : rule__Child2_6__Group__5__Impl ;
    public final void rule__Child2_6__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4839:1: ( rule__Child2_6__Group__5__Impl )
            // InternalBug348427TestLanguage.g:4840:2: rule__Child2_6__Group__5__Impl
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
    // InternalBug348427TestLanguage.g:4846:1: rule__Child2_6__Group__5__Impl : ( 'end' ) ;
    public final void rule__Child2_6__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4850:1: ( ( 'end' ) )
            // InternalBug348427TestLanguage.g:4851:1: ( 'end' )
            {
            // InternalBug348427TestLanguage.g:4851:1: ( 'end' )
            // InternalBug348427TestLanguage.g:4852:1: 'end'
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
    // InternalBug348427TestLanguage.g:4877:1: rule__Child2_6__Group_2__0 : rule__Child2_6__Group_2__0__Impl rule__Child2_6__Group_2__1 ;
    public final void rule__Child2_6__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4881:1: ( rule__Child2_6__Group_2__0__Impl rule__Child2_6__Group_2__1 )
            // InternalBug348427TestLanguage.g:4882:2: rule__Child2_6__Group_2__0__Impl rule__Child2_6__Group_2__1
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
    // InternalBug348427TestLanguage.g:4889:1: rule__Child2_6__Group_2__0__Impl : ( ( rule__Child2_6__BoolAssignment_2_0 ) ) ;
    public final void rule__Child2_6__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4893:1: ( ( ( rule__Child2_6__BoolAssignment_2_0 ) ) )
            // InternalBug348427TestLanguage.g:4894:1: ( ( rule__Child2_6__BoolAssignment_2_0 ) )
            {
            // InternalBug348427TestLanguage.g:4894:1: ( ( rule__Child2_6__BoolAssignment_2_0 ) )
            // InternalBug348427TestLanguage.g:4895:1: ( rule__Child2_6__BoolAssignment_2_0 )
            {
             before(grammarAccess.getChild2_6Access().getBoolAssignment_2_0()); 
            // InternalBug348427TestLanguage.g:4896:1: ( rule__Child2_6__BoolAssignment_2_0 )
            // InternalBug348427TestLanguage.g:4896:2: rule__Child2_6__BoolAssignment_2_0
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
    // InternalBug348427TestLanguage.g:4906:1: rule__Child2_6__Group_2__1 : rule__Child2_6__Group_2__1__Impl ;
    public final void rule__Child2_6__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4910:1: ( rule__Child2_6__Group_2__1__Impl )
            // InternalBug348427TestLanguage.g:4911:2: rule__Child2_6__Group_2__1__Impl
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
    // InternalBug348427TestLanguage.g:4917:1: rule__Child2_6__Group_2__1__Impl : ( 'keyword' ) ;
    public final void rule__Child2_6__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4921:1: ( ( 'keyword' ) )
            // InternalBug348427TestLanguage.g:4922:1: ( 'keyword' )
            {
            // InternalBug348427TestLanguage.g:4922:1: ( 'keyword' )
            // InternalBug348427TestLanguage.g:4923:1: 'keyword'
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
    // InternalBug348427TestLanguage.g:4941:1: rule__Model__Element1Assignment_0 : ( ruleScenario1_1 ) ;
    public final void rule__Model__Element1Assignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4945:1: ( ( ruleScenario1_1 ) )
            // InternalBug348427TestLanguage.g:4946:1: ( ruleScenario1_1 )
            {
            // InternalBug348427TestLanguage.g:4946:1: ( ruleScenario1_1 )
            // InternalBug348427TestLanguage.g:4947:1: ruleScenario1_1
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
    // InternalBug348427TestLanguage.g:4956:1: rule__Model__Element1Assignment_1 : ( ruleScenario1_2 ) ;
    public final void rule__Model__Element1Assignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4960:1: ( ( ruleScenario1_2 ) )
            // InternalBug348427TestLanguage.g:4961:1: ( ruleScenario1_2 )
            {
            // InternalBug348427TestLanguage.g:4961:1: ( ruleScenario1_2 )
            // InternalBug348427TestLanguage.g:4962:1: ruleScenario1_2
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
    // InternalBug348427TestLanguage.g:4971:1: rule__Model__Element1Assignment_2 : ( ruleScenario1_3 ) ;
    public final void rule__Model__Element1Assignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4975:1: ( ( ruleScenario1_3 ) )
            // InternalBug348427TestLanguage.g:4976:1: ( ruleScenario1_3 )
            {
            // InternalBug348427TestLanguage.g:4976:1: ( ruleScenario1_3 )
            // InternalBug348427TestLanguage.g:4977:1: ruleScenario1_3
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
    // InternalBug348427TestLanguage.g:4986:1: rule__Model__Element1Assignment_3 : ( ruleScenario1_4 ) ;
    public final void rule__Model__Element1Assignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:4990:1: ( ( ruleScenario1_4 ) )
            // InternalBug348427TestLanguage.g:4991:1: ( ruleScenario1_4 )
            {
            // InternalBug348427TestLanguage.g:4991:1: ( ruleScenario1_4 )
            // InternalBug348427TestLanguage.g:4992:1: ruleScenario1_4
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
    // InternalBug348427TestLanguage.g:5001:1: rule__Model__Element2Assignment_4 : ( ruleScenario2_1 ) ;
    public final void rule__Model__Element2Assignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5005:1: ( ( ruleScenario2_1 ) )
            // InternalBug348427TestLanguage.g:5006:1: ( ruleScenario2_1 )
            {
            // InternalBug348427TestLanguage.g:5006:1: ( ruleScenario2_1 )
            // InternalBug348427TestLanguage.g:5007:1: ruleScenario2_1
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
    // InternalBug348427TestLanguage.g:5016:1: rule__Model__Element2Assignment_5 : ( ruleScenario2_2 ) ;
    public final void rule__Model__Element2Assignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5020:1: ( ( ruleScenario2_2 ) )
            // InternalBug348427TestLanguage.g:5021:1: ( ruleScenario2_2 )
            {
            // InternalBug348427TestLanguage.g:5021:1: ( ruleScenario2_2 )
            // InternalBug348427TestLanguage.g:5022:1: ruleScenario2_2
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
    // InternalBug348427TestLanguage.g:5031:1: rule__Model__Element2Assignment_6 : ( ruleScenario2_3 ) ;
    public final void rule__Model__Element2Assignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5035:1: ( ( ruleScenario2_3 ) )
            // InternalBug348427TestLanguage.g:5036:1: ( ruleScenario2_3 )
            {
            // InternalBug348427TestLanguage.g:5036:1: ( ruleScenario2_3 )
            // InternalBug348427TestLanguage.g:5037:1: ruleScenario2_3
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
    // InternalBug348427TestLanguage.g:5046:1: rule__Model__Element2Assignment_7 : ( ruleScenario2_4 ) ;
    public final void rule__Model__Element2Assignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5050:1: ( ( ruleScenario2_4 ) )
            // InternalBug348427TestLanguage.g:5051:1: ( ruleScenario2_4 )
            {
            // InternalBug348427TestLanguage.g:5051:1: ( ruleScenario2_4 )
            // InternalBug348427TestLanguage.g:5052:1: ruleScenario2_4
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
    // InternalBug348427TestLanguage.g:5061:1: rule__Model__Element2Assignment_8 : ( ruleScenario2_5 ) ;
    public final void rule__Model__Element2Assignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5065:1: ( ( ruleScenario2_5 ) )
            // InternalBug348427TestLanguage.g:5066:1: ( ruleScenario2_5 )
            {
            // InternalBug348427TestLanguage.g:5066:1: ( ruleScenario2_5 )
            // InternalBug348427TestLanguage.g:5067:1: ruleScenario2_5
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
    // InternalBug348427TestLanguage.g:5076:1: rule__Model__Element2Assignment_9 : ( ruleScenario2_6 ) ;
    public final void rule__Model__Element2Assignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5080:1: ( ( ruleScenario2_6 ) )
            // InternalBug348427TestLanguage.g:5081:1: ( ruleScenario2_6 )
            {
            // InternalBug348427TestLanguage.g:5081:1: ( ruleScenario2_6 )
            // InternalBug348427TestLanguage.g:5082:1: ruleScenario2_6
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
    // InternalBug348427TestLanguage.g:5091:1: rule__Model__Element2Assignment_10 : ( ruleScenario2_7 ) ;
    public final void rule__Model__Element2Assignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5095:1: ( ( ruleScenario2_7 ) )
            // InternalBug348427TestLanguage.g:5096:1: ( ruleScenario2_7 )
            {
            // InternalBug348427TestLanguage.g:5096:1: ( ruleScenario2_7 )
            // InternalBug348427TestLanguage.g:5097:1: ruleScenario2_7
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
    // InternalBug348427TestLanguage.g:5106:1: rule__Model__Element2Assignment_11 : ( ruleScenario2_8 ) ;
    public final void rule__Model__Element2Assignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5110:1: ( ( ruleScenario2_8 ) )
            // InternalBug348427TestLanguage.g:5111:1: ( ruleScenario2_8 )
            {
            // InternalBug348427TestLanguage.g:5111:1: ( ruleScenario2_8 )
            // InternalBug348427TestLanguage.g:5112:1: ruleScenario2_8
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
    // InternalBug348427TestLanguage.g:5121:1: rule__Scenario1_1__ChildAssignment_1_0 : ( ruleChild1_1 ) ;
    public final void rule__Scenario1_1__ChildAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5125:1: ( ( ruleChild1_1 ) )
            // InternalBug348427TestLanguage.g:5126:1: ( ruleChild1_1 )
            {
            // InternalBug348427TestLanguage.g:5126:1: ( ruleChild1_1 )
            // InternalBug348427TestLanguage.g:5127:1: ruleChild1_1
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
    // InternalBug348427TestLanguage.g:5136:1: rule__Scenario1_1__ChildAssignment_1_1 : ( ruleChild1_2 ) ;
    public final void rule__Scenario1_1__ChildAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5140:1: ( ( ruleChild1_2 ) )
            // InternalBug348427TestLanguage.g:5141:1: ( ruleChild1_2 )
            {
            // InternalBug348427TestLanguage.g:5141:1: ( ruleChild1_2 )
            // InternalBug348427TestLanguage.g:5142:1: ruleChild1_2
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
    // InternalBug348427TestLanguage.g:5151:1: rule__Scenario1_1__ChildAssignment_1_2 : ( ruleChild1_3 ) ;
    public final void rule__Scenario1_1__ChildAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5155:1: ( ( ruleChild1_3 ) )
            // InternalBug348427TestLanguage.g:5156:1: ( ruleChild1_3 )
            {
            // InternalBug348427TestLanguage.g:5156:1: ( ruleChild1_3 )
            // InternalBug348427TestLanguage.g:5157:1: ruleChild1_3
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
    // InternalBug348427TestLanguage.g:5166:1: rule__Scenario1_2__ChildAssignment_1_0 : ( ruleChild1_1 ) ;
    public final void rule__Scenario1_2__ChildAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5170:1: ( ( ruleChild1_1 ) )
            // InternalBug348427TestLanguage.g:5171:1: ( ruleChild1_1 )
            {
            // InternalBug348427TestLanguage.g:5171:1: ( ruleChild1_1 )
            // InternalBug348427TestLanguage.g:5172:1: ruleChild1_1
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
    // InternalBug348427TestLanguage.g:5181:1: rule__Scenario1_2__ChildAssignment_1_1 : ( ruleChild1_2 ) ;
    public final void rule__Scenario1_2__ChildAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5185:1: ( ( ruleChild1_2 ) )
            // InternalBug348427TestLanguage.g:5186:1: ( ruleChild1_2 )
            {
            // InternalBug348427TestLanguage.g:5186:1: ( ruleChild1_2 )
            // InternalBug348427TestLanguage.g:5187:1: ruleChild1_2
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
    // InternalBug348427TestLanguage.g:5196:1: rule__Scenario1_2__ChildAssignment_1_2 : ( ruleChild1_3 ) ;
    public final void rule__Scenario1_2__ChildAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5200:1: ( ( ruleChild1_3 ) )
            // InternalBug348427TestLanguage.g:5201:1: ( ruleChild1_3 )
            {
            // InternalBug348427TestLanguage.g:5201:1: ( ruleChild1_3 )
            // InternalBug348427TestLanguage.g:5202:1: ruleChild1_3
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
    // InternalBug348427TestLanguage.g:5211:1: rule__Scenario1_3__ChildAssignment_2_0 : ( ruleChild1_1 ) ;
    public final void rule__Scenario1_3__ChildAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5215:1: ( ( ruleChild1_1 ) )
            // InternalBug348427TestLanguage.g:5216:1: ( ruleChild1_1 )
            {
            // InternalBug348427TestLanguage.g:5216:1: ( ruleChild1_1 )
            // InternalBug348427TestLanguage.g:5217:1: ruleChild1_1
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
    // InternalBug348427TestLanguage.g:5226:1: rule__Scenario1_3__ChildAssignment_2_1 : ( ruleChild1_2 ) ;
    public final void rule__Scenario1_3__ChildAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5230:1: ( ( ruleChild1_2 ) )
            // InternalBug348427TestLanguage.g:5231:1: ( ruleChild1_2 )
            {
            // InternalBug348427TestLanguage.g:5231:1: ( ruleChild1_2 )
            // InternalBug348427TestLanguage.g:5232:1: ruleChild1_2
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
    // InternalBug348427TestLanguage.g:5241:1: rule__Scenario1_3__ChildAssignment_2_2 : ( ruleChild1_3 ) ;
    public final void rule__Scenario1_3__ChildAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5245:1: ( ( ruleChild1_3 ) )
            // InternalBug348427TestLanguage.g:5246:1: ( ruleChild1_3 )
            {
            // InternalBug348427TestLanguage.g:5246:1: ( ruleChild1_3 )
            // InternalBug348427TestLanguage.g:5247:1: ruleChild1_3
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
    // InternalBug348427TestLanguage.g:5256:1: rule__Scenario1_4__ChildAssignment_2_0 : ( ruleChild1_1 ) ;
    public final void rule__Scenario1_4__ChildAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5260:1: ( ( ruleChild1_1 ) )
            // InternalBug348427TestLanguage.g:5261:1: ( ruleChild1_1 )
            {
            // InternalBug348427TestLanguage.g:5261:1: ( ruleChild1_1 )
            // InternalBug348427TestLanguage.g:5262:1: ruleChild1_1
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
    // InternalBug348427TestLanguage.g:5271:1: rule__Scenario1_4__ChildAssignment_2_1 : ( ruleChild1_2 ) ;
    public final void rule__Scenario1_4__ChildAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5275:1: ( ( ruleChild1_2 ) )
            // InternalBug348427TestLanguage.g:5276:1: ( ruleChild1_2 )
            {
            // InternalBug348427TestLanguage.g:5276:1: ( ruleChild1_2 )
            // InternalBug348427TestLanguage.g:5277:1: ruleChild1_2
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
    // InternalBug348427TestLanguage.g:5286:1: rule__Scenario1_4__ChildAssignment_2_2 : ( ruleChild1_3 ) ;
    public final void rule__Scenario1_4__ChildAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5290:1: ( ( ruleChild1_3 ) )
            // InternalBug348427TestLanguage.g:5291:1: ( ruleChild1_3 )
            {
            // InternalBug348427TestLanguage.g:5291:1: ( ruleChild1_3 )
            // InternalBug348427TestLanguage.g:5292:1: ruleChild1_3
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
    // InternalBug348427TestLanguage.g:5301:1: rule__Child1_1__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Child1_1__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5305:1: ( ( RULE_ID ) )
            // InternalBug348427TestLanguage.g:5306:1: ( RULE_ID )
            {
            // InternalBug348427TestLanguage.g:5306:1: ( RULE_ID )
            // InternalBug348427TestLanguage.g:5307:1: RULE_ID
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
    // InternalBug348427TestLanguage.g:5316:1: rule__Child1_1__BoolAssignment_2_0 : ( ( 'bool' ) ) ;
    public final void rule__Child1_1__BoolAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5320:1: ( ( ( 'bool' ) ) )
            // InternalBug348427TestLanguage.g:5321:1: ( ( 'bool' ) )
            {
            // InternalBug348427TestLanguage.g:5321:1: ( ( 'bool' ) )
            // InternalBug348427TestLanguage.g:5322:1: ( 'bool' )
            {
             before(grammarAccess.getChild1_1Access().getBoolBoolKeyword_2_0_0()); 
            // InternalBug348427TestLanguage.g:5323:1: ( 'bool' )
            // InternalBug348427TestLanguage.g:5324:1: 'bool'
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
    // InternalBug348427TestLanguage.g:5339:1: rule__Child1_1__EnumTypeAssignment_3 : ( ruleEnumType ) ;
    public final void rule__Child1_1__EnumTypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5343:1: ( ( ruleEnumType ) )
            // InternalBug348427TestLanguage.g:5344:1: ( ruleEnumType )
            {
            // InternalBug348427TestLanguage.g:5344:1: ( ruleEnumType )
            // InternalBug348427TestLanguage.g:5345:1: ruleEnumType
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
    // InternalBug348427TestLanguage.g:5354:1: rule__Child1_2__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Child1_2__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5358:1: ( ( RULE_ID ) )
            // InternalBug348427TestLanguage.g:5359:1: ( RULE_ID )
            {
            // InternalBug348427TestLanguage.g:5359:1: ( RULE_ID )
            // InternalBug348427TestLanguage.g:5360:1: RULE_ID
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
    // InternalBug348427TestLanguage.g:5369:1: rule__Child1_2__BoolAssignment_2_0 : ( ( 'bool' ) ) ;
    public final void rule__Child1_2__BoolAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5373:1: ( ( ( 'bool' ) ) )
            // InternalBug348427TestLanguage.g:5374:1: ( ( 'bool' ) )
            {
            // InternalBug348427TestLanguage.g:5374:1: ( ( 'bool' ) )
            // InternalBug348427TestLanguage.g:5375:1: ( 'bool' )
            {
             before(grammarAccess.getChild1_2Access().getBoolBoolKeyword_2_0_0()); 
            // InternalBug348427TestLanguage.g:5376:1: ( 'bool' )
            // InternalBug348427TestLanguage.g:5377:1: 'bool'
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
    // InternalBug348427TestLanguage.g:5392:1: rule__Child1_2__EnumTypeAssignment_3 : ( ruleEnumType ) ;
    public final void rule__Child1_2__EnumTypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5396:1: ( ( ruleEnumType ) )
            // InternalBug348427TestLanguage.g:5397:1: ( ruleEnumType )
            {
            // InternalBug348427TestLanguage.g:5397:1: ( ruleEnumType )
            // InternalBug348427TestLanguage.g:5398:1: ruleEnumType
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
    // InternalBug348427TestLanguage.g:5407:1: rule__Child1_3__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Child1_3__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5411:1: ( ( RULE_ID ) )
            // InternalBug348427TestLanguage.g:5412:1: ( RULE_ID )
            {
            // InternalBug348427TestLanguage.g:5412:1: ( RULE_ID )
            // InternalBug348427TestLanguage.g:5413:1: RULE_ID
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
    // InternalBug348427TestLanguage.g:5422:1: rule__Child1_3__BoolAssignment_2_0 : ( ( 'bool' ) ) ;
    public final void rule__Child1_3__BoolAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5426:1: ( ( ( 'bool' ) ) )
            // InternalBug348427TestLanguage.g:5427:1: ( ( 'bool' ) )
            {
            // InternalBug348427TestLanguage.g:5427:1: ( ( 'bool' ) )
            // InternalBug348427TestLanguage.g:5428:1: ( 'bool' )
            {
             before(grammarAccess.getChild1_3Access().getBoolBoolKeyword_2_0_0()); 
            // InternalBug348427TestLanguage.g:5429:1: ( 'bool' )
            // InternalBug348427TestLanguage.g:5430:1: 'bool'
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
    // InternalBug348427TestLanguage.g:5445:1: rule__Child1_3__EnumTypeAssignment_3 : ( ruleEnumType ) ;
    public final void rule__Child1_3__EnumTypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5449:1: ( ( ruleEnumType ) )
            // InternalBug348427TestLanguage.g:5450:1: ( ruleEnumType )
            {
            // InternalBug348427TestLanguage.g:5450:1: ( ruleEnumType )
            // InternalBug348427TestLanguage.g:5451:1: ruleEnumType
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
    // InternalBug348427TestLanguage.g:5460:1: rule__Scenario2_1__ChildAssignment_1_0 : ( ruleChild2_1 ) ;
    public final void rule__Scenario2_1__ChildAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5464:1: ( ( ruleChild2_1 ) )
            // InternalBug348427TestLanguage.g:5465:1: ( ruleChild2_1 )
            {
            // InternalBug348427TestLanguage.g:5465:1: ( ruleChild2_1 )
            // InternalBug348427TestLanguage.g:5466:1: ruleChild2_1
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
    // InternalBug348427TestLanguage.g:5475:1: rule__Scenario2_1__ChildAssignment_1_1 : ( ruleChild2_2 ) ;
    public final void rule__Scenario2_1__ChildAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5479:1: ( ( ruleChild2_2 ) )
            // InternalBug348427TestLanguage.g:5480:1: ( ruleChild2_2 )
            {
            // InternalBug348427TestLanguage.g:5480:1: ( ruleChild2_2 )
            // InternalBug348427TestLanguage.g:5481:1: ruleChild2_2
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
    // InternalBug348427TestLanguage.g:5490:1: rule__Scenario2_1__ChildAssignment_1_2 : ( ruleChild2_3 ) ;
    public final void rule__Scenario2_1__ChildAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5494:1: ( ( ruleChild2_3 ) )
            // InternalBug348427TestLanguage.g:5495:1: ( ruleChild2_3 )
            {
            // InternalBug348427TestLanguage.g:5495:1: ( ruleChild2_3 )
            // InternalBug348427TestLanguage.g:5496:1: ruleChild2_3
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
    // InternalBug348427TestLanguage.g:5505:1: rule__Scenario2_2__ChildAssignment_1_0 : ( ruleChild2_1 ) ;
    public final void rule__Scenario2_2__ChildAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5509:1: ( ( ruleChild2_1 ) )
            // InternalBug348427TestLanguage.g:5510:1: ( ruleChild2_1 )
            {
            // InternalBug348427TestLanguage.g:5510:1: ( ruleChild2_1 )
            // InternalBug348427TestLanguage.g:5511:1: ruleChild2_1
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
    // InternalBug348427TestLanguage.g:5520:1: rule__Scenario2_2__ChildAssignment_1_1 : ( ruleChild2_2 ) ;
    public final void rule__Scenario2_2__ChildAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5524:1: ( ( ruleChild2_2 ) )
            // InternalBug348427TestLanguage.g:5525:1: ( ruleChild2_2 )
            {
            // InternalBug348427TestLanguage.g:5525:1: ( ruleChild2_2 )
            // InternalBug348427TestLanguage.g:5526:1: ruleChild2_2
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
    // InternalBug348427TestLanguage.g:5535:1: rule__Scenario2_2__ChildAssignment_1_2 : ( ruleChild2_3 ) ;
    public final void rule__Scenario2_2__ChildAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5539:1: ( ( ruleChild2_3 ) )
            // InternalBug348427TestLanguage.g:5540:1: ( ruleChild2_3 )
            {
            // InternalBug348427TestLanguage.g:5540:1: ( ruleChild2_3 )
            // InternalBug348427TestLanguage.g:5541:1: ruleChild2_3
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
    // InternalBug348427TestLanguage.g:5550:1: rule__Scenario2_3__ChildAssignment_1_0 : ( ruleChild2_4 ) ;
    public final void rule__Scenario2_3__ChildAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5554:1: ( ( ruleChild2_4 ) )
            // InternalBug348427TestLanguage.g:5555:1: ( ruleChild2_4 )
            {
            // InternalBug348427TestLanguage.g:5555:1: ( ruleChild2_4 )
            // InternalBug348427TestLanguage.g:5556:1: ruleChild2_4
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
    // InternalBug348427TestLanguage.g:5565:1: rule__Scenario2_3__ChildAssignment_1_1 : ( ruleChild2_5 ) ;
    public final void rule__Scenario2_3__ChildAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5569:1: ( ( ruleChild2_5 ) )
            // InternalBug348427TestLanguage.g:5570:1: ( ruleChild2_5 )
            {
            // InternalBug348427TestLanguage.g:5570:1: ( ruleChild2_5 )
            // InternalBug348427TestLanguage.g:5571:1: ruleChild2_5
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
    // InternalBug348427TestLanguage.g:5580:1: rule__Scenario2_3__ChildAssignment_1_2 : ( ruleChild2_6 ) ;
    public final void rule__Scenario2_3__ChildAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5584:1: ( ( ruleChild2_6 ) )
            // InternalBug348427TestLanguage.g:5585:1: ( ruleChild2_6 )
            {
            // InternalBug348427TestLanguage.g:5585:1: ( ruleChild2_6 )
            // InternalBug348427TestLanguage.g:5586:1: ruleChild2_6
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
    // InternalBug348427TestLanguage.g:5595:1: rule__Scenario2_4__ChildAssignment_1_0 : ( ruleChild2_4 ) ;
    public final void rule__Scenario2_4__ChildAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5599:1: ( ( ruleChild2_4 ) )
            // InternalBug348427TestLanguage.g:5600:1: ( ruleChild2_4 )
            {
            // InternalBug348427TestLanguage.g:5600:1: ( ruleChild2_4 )
            // InternalBug348427TestLanguage.g:5601:1: ruleChild2_4
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
    // InternalBug348427TestLanguage.g:5610:1: rule__Scenario2_4__ChildAssignment_1_1 : ( ruleChild2_5 ) ;
    public final void rule__Scenario2_4__ChildAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5614:1: ( ( ruleChild2_5 ) )
            // InternalBug348427TestLanguage.g:5615:1: ( ruleChild2_5 )
            {
            // InternalBug348427TestLanguage.g:5615:1: ( ruleChild2_5 )
            // InternalBug348427TestLanguage.g:5616:1: ruleChild2_5
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
    // InternalBug348427TestLanguage.g:5625:1: rule__Scenario2_4__ChildAssignment_1_2 : ( ruleChild2_6 ) ;
    public final void rule__Scenario2_4__ChildAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5629:1: ( ( ruleChild2_6 ) )
            // InternalBug348427TestLanguage.g:5630:1: ( ruleChild2_6 )
            {
            // InternalBug348427TestLanguage.g:5630:1: ( ruleChild2_6 )
            // InternalBug348427TestLanguage.g:5631:1: ruleChild2_6
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
    // InternalBug348427TestLanguage.g:5640:1: rule__Scenario2_5__ChildAssignment_2_0 : ( ruleChild2_1 ) ;
    public final void rule__Scenario2_5__ChildAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5644:1: ( ( ruleChild2_1 ) )
            // InternalBug348427TestLanguage.g:5645:1: ( ruleChild2_1 )
            {
            // InternalBug348427TestLanguage.g:5645:1: ( ruleChild2_1 )
            // InternalBug348427TestLanguage.g:5646:1: ruleChild2_1
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
    // InternalBug348427TestLanguage.g:5655:1: rule__Scenario2_5__ChildAssignment_2_1 : ( ruleChild2_2 ) ;
    public final void rule__Scenario2_5__ChildAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5659:1: ( ( ruleChild2_2 ) )
            // InternalBug348427TestLanguage.g:5660:1: ( ruleChild2_2 )
            {
            // InternalBug348427TestLanguage.g:5660:1: ( ruleChild2_2 )
            // InternalBug348427TestLanguage.g:5661:1: ruleChild2_2
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
    // InternalBug348427TestLanguage.g:5670:1: rule__Scenario2_5__ChildAssignment_2_2 : ( ruleChild2_3 ) ;
    public final void rule__Scenario2_5__ChildAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5674:1: ( ( ruleChild2_3 ) )
            // InternalBug348427TestLanguage.g:5675:1: ( ruleChild2_3 )
            {
            // InternalBug348427TestLanguage.g:5675:1: ( ruleChild2_3 )
            // InternalBug348427TestLanguage.g:5676:1: ruleChild2_3
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
    // InternalBug348427TestLanguage.g:5685:1: rule__Scenario2_6__ChildAssignment_2_0 : ( ruleChild2_1 ) ;
    public final void rule__Scenario2_6__ChildAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5689:1: ( ( ruleChild2_1 ) )
            // InternalBug348427TestLanguage.g:5690:1: ( ruleChild2_1 )
            {
            // InternalBug348427TestLanguage.g:5690:1: ( ruleChild2_1 )
            // InternalBug348427TestLanguage.g:5691:1: ruleChild2_1
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
    // InternalBug348427TestLanguage.g:5700:1: rule__Scenario2_6__ChildAssignment_2_1 : ( ruleChild2_2 ) ;
    public final void rule__Scenario2_6__ChildAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5704:1: ( ( ruleChild2_2 ) )
            // InternalBug348427TestLanguage.g:5705:1: ( ruleChild2_2 )
            {
            // InternalBug348427TestLanguage.g:5705:1: ( ruleChild2_2 )
            // InternalBug348427TestLanguage.g:5706:1: ruleChild2_2
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
    // InternalBug348427TestLanguage.g:5715:1: rule__Scenario2_6__ChildAssignment_2_2 : ( ruleChild2_3 ) ;
    public final void rule__Scenario2_6__ChildAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5719:1: ( ( ruleChild2_3 ) )
            // InternalBug348427TestLanguage.g:5720:1: ( ruleChild2_3 )
            {
            // InternalBug348427TestLanguage.g:5720:1: ( ruleChild2_3 )
            // InternalBug348427TestLanguage.g:5721:1: ruleChild2_3
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
    // InternalBug348427TestLanguage.g:5730:1: rule__Scenario2_7__ChildAssignment_2_0 : ( ruleChild2_4 ) ;
    public final void rule__Scenario2_7__ChildAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5734:1: ( ( ruleChild2_4 ) )
            // InternalBug348427TestLanguage.g:5735:1: ( ruleChild2_4 )
            {
            // InternalBug348427TestLanguage.g:5735:1: ( ruleChild2_4 )
            // InternalBug348427TestLanguage.g:5736:1: ruleChild2_4
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
    // InternalBug348427TestLanguage.g:5745:1: rule__Scenario2_7__ChildAssignment_2_1 : ( ruleChild2_5 ) ;
    public final void rule__Scenario2_7__ChildAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5749:1: ( ( ruleChild2_5 ) )
            // InternalBug348427TestLanguage.g:5750:1: ( ruleChild2_5 )
            {
            // InternalBug348427TestLanguage.g:5750:1: ( ruleChild2_5 )
            // InternalBug348427TestLanguage.g:5751:1: ruleChild2_5
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
    // InternalBug348427TestLanguage.g:5760:1: rule__Scenario2_7__ChildAssignment_2_2 : ( ruleChild2_6 ) ;
    public final void rule__Scenario2_7__ChildAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5764:1: ( ( ruleChild2_6 ) )
            // InternalBug348427TestLanguage.g:5765:1: ( ruleChild2_6 )
            {
            // InternalBug348427TestLanguage.g:5765:1: ( ruleChild2_6 )
            // InternalBug348427TestLanguage.g:5766:1: ruleChild2_6
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
    // InternalBug348427TestLanguage.g:5775:1: rule__Scenario2_8__ChildAssignment_2_0 : ( ruleChild2_4 ) ;
    public final void rule__Scenario2_8__ChildAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5779:1: ( ( ruleChild2_4 ) )
            // InternalBug348427TestLanguage.g:5780:1: ( ruleChild2_4 )
            {
            // InternalBug348427TestLanguage.g:5780:1: ( ruleChild2_4 )
            // InternalBug348427TestLanguage.g:5781:1: ruleChild2_4
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
    // InternalBug348427TestLanguage.g:5790:1: rule__Scenario2_8__ChildAssignment_2_1 : ( ruleChild2_5 ) ;
    public final void rule__Scenario2_8__ChildAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5794:1: ( ( ruleChild2_5 ) )
            // InternalBug348427TestLanguage.g:5795:1: ( ruleChild2_5 )
            {
            // InternalBug348427TestLanguage.g:5795:1: ( ruleChild2_5 )
            // InternalBug348427TestLanguage.g:5796:1: ruleChild2_5
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
    // InternalBug348427TestLanguage.g:5805:1: rule__Scenario2_8__ChildAssignment_2_2 : ( ruleChild2_6 ) ;
    public final void rule__Scenario2_8__ChildAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5809:1: ( ( ruleChild2_6 ) )
            // InternalBug348427TestLanguage.g:5810:1: ( ruleChild2_6 )
            {
            // InternalBug348427TestLanguage.g:5810:1: ( ruleChild2_6 )
            // InternalBug348427TestLanguage.g:5811:1: ruleChild2_6
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
    // InternalBug348427TestLanguage.g:5820:1: rule__Child2_1__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Child2_1__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5824:1: ( ( RULE_ID ) )
            // InternalBug348427TestLanguage.g:5825:1: ( RULE_ID )
            {
            // InternalBug348427TestLanguage.g:5825:1: ( RULE_ID )
            // InternalBug348427TestLanguage.g:5826:1: RULE_ID
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
    // InternalBug348427TestLanguage.g:5835:1: rule__Child2_1__BoolAssignment_2_0 : ( ( 'bool' ) ) ;
    public final void rule__Child2_1__BoolAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5839:1: ( ( ( 'bool' ) ) )
            // InternalBug348427TestLanguage.g:5840:1: ( ( 'bool' ) )
            {
            // InternalBug348427TestLanguage.g:5840:1: ( ( 'bool' ) )
            // InternalBug348427TestLanguage.g:5841:1: ( 'bool' )
            {
             before(grammarAccess.getChild2_1Access().getBoolBoolKeyword_2_0_0()); 
            // InternalBug348427TestLanguage.g:5842:1: ( 'bool' )
            // InternalBug348427TestLanguage.g:5843:1: 'bool'
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
    // InternalBug348427TestLanguage.g:5858:1: rule__Child2_1__StringAssignment_3 : ( ( rule__Child2_1__StringAlternatives_3_0 ) ) ;
    public final void rule__Child2_1__StringAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5862:1: ( ( ( rule__Child2_1__StringAlternatives_3_0 ) ) )
            // InternalBug348427TestLanguage.g:5863:1: ( ( rule__Child2_1__StringAlternatives_3_0 ) )
            {
            // InternalBug348427TestLanguage.g:5863:1: ( ( rule__Child2_1__StringAlternatives_3_0 ) )
            // InternalBug348427TestLanguage.g:5864:1: ( rule__Child2_1__StringAlternatives_3_0 )
            {
             before(grammarAccess.getChild2_1Access().getStringAlternatives_3_0()); 
            // InternalBug348427TestLanguage.g:5865:1: ( rule__Child2_1__StringAlternatives_3_0 )
            // InternalBug348427TestLanguage.g:5865:2: rule__Child2_1__StringAlternatives_3_0
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
    // InternalBug348427TestLanguage.g:5874:1: rule__Child2_2__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Child2_2__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5878:1: ( ( RULE_ID ) )
            // InternalBug348427TestLanguage.g:5879:1: ( RULE_ID )
            {
            // InternalBug348427TestLanguage.g:5879:1: ( RULE_ID )
            // InternalBug348427TestLanguage.g:5880:1: RULE_ID
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
    // InternalBug348427TestLanguage.g:5889:1: rule__Child2_2__BoolAssignment_2_0 : ( ( 'bool' ) ) ;
    public final void rule__Child2_2__BoolAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5893:1: ( ( ( 'bool' ) ) )
            // InternalBug348427TestLanguage.g:5894:1: ( ( 'bool' ) )
            {
            // InternalBug348427TestLanguage.g:5894:1: ( ( 'bool' ) )
            // InternalBug348427TestLanguage.g:5895:1: ( 'bool' )
            {
             before(grammarAccess.getChild2_2Access().getBoolBoolKeyword_2_0_0()); 
            // InternalBug348427TestLanguage.g:5896:1: ( 'bool' )
            // InternalBug348427TestLanguage.g:5897:1: 'bool'
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
    // InternalBug348427TestLanguage.g:5912:1: rule__Child2_2__StringAssignment_3 : ( ( rule__Child2_2__StringAlternatives_3_0 ) ) ;
    public final void rule__Child2_2__StringAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5916:1: ( ( ( rule__Child2_2__StringAlternatives_3_0 ) ) )
            // InternalBug348427TestLanguage.g:5917:1: ( ( rule__Child2_2__StringAlternatives_3_0 ) )
            {
            // InternalBug348427TestLanguage.g:5917:1: ( ( rule__Child2_2__StringAlternatives_3_0 ) )
            // InternalBug348427TestLanguage.g:5918:1: ( rule__Child2_2__StringAlternatives_3_0 )
            {
             before(grammarAccess.getChild2_2Access().getStringAlternatives_3_0()); 
            // InternalBug348427TestLanguage.g:5919:1: ( rule__Child2_2__StringAlternatives_3_0 )
            // InternalBug348427TestLanguage.g:5919:2: rule__Child2_2__StringAlternatives_3_0
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
    // InternalBug348427TestLanguage.g:5928:1: rule__Child2_3__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Child2_3__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5932:1: ( ( RULE_ID ) )
            // InternalBug348427TestLanguage.g:5933:1: ( RULE_ID )
            {
            // InternalBug348427TestLanguage.g:5933:1: ( RULE_ID )
            // InternalBug348427TestLanguage.g:5934:1: RULE_ID
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
    // InternalBug348427TestLanguage.g:5943:1: rule__Child2_3__BoolAssignment_2_0 : ( ( 'bool' ) ) ;
    public final void rule__Child2_3__BoolAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5947:1: ( ( ( 'bool' ) ) )
            // InternalBug348427TestLanguage.g:5948:1: ( ( 'bool' ) )
            {
            // InternalBug348427TestLanguage.g:5948:1: ( ( 'bool' ) )
            // InternalBug348427TestLanguage.g:5949:1: ( 'bool' )
            {
             before(grammarAccess.getChild2_3Access().getBoolBoolKeyword_2_0_0()); 
            // InternalBug348427TestLanguage.g:5950:1: ( 'bool' )
            // InternalBug348427TestLanguage.g:5951:1: 'bool'
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
    // InternalBug348427TestLanguage.g:5966:1: rule__Child2_3__StringAssignment_3 : ( ( rule__Child2_3__StringAlternatives_3_0 ) ) ;
    public final void rule__Child2_3__StringAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5970:1: ( ( ( rule__Child2_3__StringAlternatives_3_0 ) ) )
            // InternalBug348427TestLanguage.g:5971:1: ( ( rule__Child2_3__StringAlternatives_3_0 ) )
            {
            // InternalBug348427TestLanguage.g:5971:1: ( ( rule__Child2_3__StringAlternatives_3_0 ) )
            // InternalBug348427TestLanguage.g:5972:1: ( rule__Child2_3__StringAlternatives_3_0 )
            {
             before(grammarAccess.getChild2_3Access().getStringAlternatives_3_0()); 
            // InternalBug348427TestLanguage.g:5973:1: ( rule__Child2_3__StringAlternatives_3_0 )
            // InternalBug348427TestLanguage.g:5973:2: rule__Child2_3__StringAlternatives_3_0
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
    // InternalBug348427TestLanguage.g:5982:1: rule__Child2_4__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Child2_4__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:5986:1: ( ( RULE_ID ) )
            // InternalBug348427TestLanguage.g:5987:1: ( RULE_ID )
            {
            // InternalBug348427TestLanguage.g:5987:1: ( RULE_ID )
            // InternalBug348427TestLanguage.g:5988:1: RULE_ID
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
    // InternalBug348427TestLanguage.g:5997:1: rule__Child2_4__BoolAssignment_2_0 : ( ( 'bool' ) ) ;
    public final void rule__Child2_4__BoolAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:6001:1: ( ( ( 'bool' ) ) )
            // InternalBug348427TestLanguage.g:6002:1: ( ( 'bool' ) )
            {
            // InternalBug348427TestLanguage.g:6002:1: ( ( 'bool' ) )
            // InternalBug348427TestLanguage.g:6003:1: ( 'bool' )
            {
             before(grammarAccess.getChild2_4Access().getBoolBoolKeyword_2_0_0()); 
            // InternalBug348427TestLanguage.g:6004:1: ( 'bool' )
            // InternalBug348427TestLanguage.g:6005:1: 'bool'
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
    // InternalBug348427TestLanguage.g:6020:1: rule__Child2_4__StringAssignment_3_0 : ( ( 'a' ) ) ;
    public final void rule__Child2_4__StringAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:6024:1: ( ( ( 'a' ) ) )
            // InternalBug348427TestLanguage.g:6025:1: ( ( 'a' ) )
            {
            // InternalBug348427TestLanguage.g:6025:1: ( ( 'a' ) )
            // InternalBug348427TestLanguage.g:6026:1: ( 'a' )
            {
             before(grammarAccess.getChild2_4Access().getStringAKeyword_3_0_0()); 
            // InternalBug348427TestLanguage.g:6027:1: ( 'a' )
            // InternalBug348427TestLanguage.g:6028:1: 'a'
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
    // InternalBug348427TestLanguage.g:6043:1: rule__Child2_4__StringAssignment_3_1 : ( ( 'b' ) ) ;
    public final void rule__Child2_4__StringAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:6047:1: ( ( ( 'b' ) ) )
            // InternalBug348427TestLanguage.g:6048:1: ( ( 'b' ) )
            {
            // InternalBug348427TestLanguage.g:6048:1: ( ( 'b' ) )
            // InternalBug348427TestLanguage.g:6049:1: ( 'b' )
            {
             before(grammarAccess.getChild2_4Access().getStringBKeyword_3_1_0()); 
            // InternalBug348427TestLanguage.g:6050:1: ( 'b' )
            // InternalBug348427TestLanguage.g:6051:1: 'b'
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
    // InternalBug348427TestLanguage.g:6066:1: rule__Child2_5__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Child2_5__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:6070:1: ( ( RULE_ID ) )
            // InternalBug348427TestLanguage.g:6071:1: ( RULE_ID )
            {
            // InternalBug348427TestLanguage.g:6071:1: ( RULE_ID )
            // InternalBug348427TestLanguage.g:6072:1: RULE_ID
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
    // InternalBug348427TestLanguage.g:6081:1: rule__Child2_5__BoolAssignment_2_0 : ( ( 'bool' ) ) ;
    public final void rule__Child2_5__BoolAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:6085:1: ( ( ( 'bool' ) ) )
            // InternalBug348427TestLanguage.g:6086:1: ( ( 'bool' ) )
            {
            // InternalBug348427TestLanguage.g:6086:1: ( ( 'bool' ) )
            // InternalBug348427TestLanguage.g:6087:1: ( 'bool' )
            {
             before(grammarAccess.getChild2_5Access().getBoolBoolKeyword_2_0_0()); 
            // InternalBug348427TestLanguage.g:6088:1: ( 'bool' )
            // InternalBug348427TestLanguage.g:6089:1: 'bool'
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
    // InternalBug348427TestLanguage.g:6104:1: rule__Child2_5__StringAssignment_3_0 : ( ( 'a' ) ) ;
    public final void rule__Child2_5__StringAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:6108:1: ( ( ( 'a' ) ) )
            // InternalBug348427TestLanguage.g:6109:1: ( ( 'a' ) )
            {
            // InternalBug348427TestLanguage.g:6109:1: ( ( 'a' ) )
            // InternalBug348427TestLanguage.g:6110:1: ( 'a' )
            {
             before(grammarAccess.getChild2_5Access().getStringAKeyword_3_0_0()); 
            // InternalBug348427TestLanguage.g:6111:1: ( 'a' )
            // InternalBug348427TestLanguage.g:6112:1: 'a'
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
    // InternalBug348427TestLanguage.g:6127:1: rule__Child2_5__StringAssignment_3_1 : ( ( 'b' ) ) ;
    public final void rule__Child2_5__StringAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:6131:1: ( ( ( 'b' ) ) )
            // InternalBug348427TestLanguage.g:6132:1: ( ( 'b' ) )
            {
            // InternalBug348427TestLanguage.g:6132:1: ( ( 'b' ) )
            // InternalBug348427TestLanguage.g:6133:1: ( 'b' )
            {
             before(grammarAccess.getChild2_5Access().getStringBKeyword_3_1_0()); 
            // InternalBug348427TestLanguage.g:6134:1: ( 'b' )
            // InternalBug348427TestLanguage.g:6135:1: 'b'
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
    // InternalBug348427TestLanguage.g:6150:1: rule__Child2_6__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Child2_6__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:6154:1: ( ( RULE_ID ) )
            // InternalBug348427TestLanguage.g:6155:1: ( RULE_ID )
            {
            // InternalBug348427TestLanguage.g:6155:1: ( RULE_ID )
            // InternalBug348427TestLanguage.g:6156:1: RULE_ID
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
    // InternalBug348427TestLanguage.g:6165:1: rule__Child2_6__BoolAssignment_2_0 : ( ( 'bool' ) ) ;
    public final void rule__Child2_6__BoolAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:6169:1: ( ( ( 'bool' ) ) )
            // InternalBug348427TestLanguage.g:6170:1: ( ( 'bool' ) )
            {
            // InternalBug348427TestLanguage.g:6170:1: ( ( 'bool' ) )
            // InternalBug348427TestLanguage.g:6171:1: ( 'bool' )
            {
             before(grammarAccess.getChild2_6Access().getBoolBoolKeyword_2_0_0()); 
            // InternalBug348427TestLanguage.g:6172:1: ( 'bool' )
            // InternalBug348427TestLanguage.g:6173:1: 'bool'
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
    // InternalBug348427TestLanguage.g:6188:1: rule__Child2_6__StringAssignment_3_0 : ( ( 'a' ) ) ;
    public final void rule__Child2_6__StringAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:6192:1: ( ( ( 'a' ) ) )
            // InternalBug348427TestLanguage.g:6193:1: ( ( 'a' ) )
            {
            // InternalBug348427TestLanguage.g:6193:1: ( ( 'a' ) )
            // InternalBug348427TestLanguage.g:6194:1: ( 'a' )
            {
             before(grammarAccess.getChild2_6Access().getStringAKeyword_3_0_0()); 
            // InternalBug348427TestLanguage.g:6195:1: ( 'a' )
            // InternalBug348427TestLanguage.g:6196:1: 'a'
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
    // InternalBug348427TestLanguage.g:6211:1: rule__Child2_6__StringAssignment_3_1 : ( ( 'b' ) ) ;
    public final void rule__Child2_6__StringAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348427TestLanguage.g:6215:1: ( ( ( 'b' ) ) )
            // InternalBug348427TestLanguage.g:6216:1: ( ( 'b' ) )
            {
            // InternalBug348427TestLanguage.g:6216:1: ( ( 'b' ) )
            // InternalBug348427TestLanguage.g:6217:1: ( 'b' )
            {
             before(grammarAccess.getChild2_6Access().getStringBKeyword_3_1_0()); 
            // InternalBug348427TestLanguage.g:6218:1: ( 'b' )
            // InternalBug348427TestLanguage.g:6219:1: 'b'
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
    static final String DFA2_eotS =
        "\12\uffff";
    static final String DFA2_eofS =
        "\12\uffff";
    static final String DFA2_minS =
        "\1\4\1\22\1\13\1\25\2\23\1\13\3\uffff";
    static final String DFA2_maxS =
        "\1\4\1\22\1\40\1\25\2\27\1\14\3\uffff";
    static final String DFA2_acceptS =
        "\7\uffff\1\2\1\1\1\3";
    static final String DFA2_specialS =
        "\12\uffff}>";
    static final String[] DFA2_transitionS = {
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
            return "777:1: rule__Scenario1_1__Alternatives_1 : ( ( ( rule__Scenario1_1__ChildAssignment_1_0 ) ) | ( ( rule__Scenario1_1__ChildAssignment_1_1 ) ) | ( ( rule__Scenario1_1__ChildAssignment_1_2 ) ) );";
        }
    }
    static final String DFA3_eotS =
        "\12\uffff";
    static final String DFA3_eofS =
        "\12\uffff";
    static final String DFA3_minS =
        "\1\4\1\22\1\13\1\25\2\23\1\13\3\uffff";
    static final String DFA3_maxS =
        "\1\4\1\22\1\40\1\25\2\27\1\14\3\uffff";
    static final String DFA3_acceptS =
        "\7\uffff\1\3\1\2\1\1";
    static final String DFA3_specialS =
        "\12\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\1",
            "\1\2",
            "\1\4\1\5\23\uffff\1\3",
            "\1\6",
            "\1\11\2\uffff\1\10\1\7",
            "\1\11\2\uffff\1\10\1\7",
            "\1\4\1\5",
            "",
            "",
            ""
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
            return "805:1: rule__Scenario1_2__Alternatives_1 : ( ( ( rule__Scenario1_2__ChildAssignment_1_0 ) ) | ( ( rule__Scenario1_2__ChildAssignment_1_1 ) ) | ( ( rule__Scenario1_2__ChildAssignment_1_2 ) ) );";
        }
    }
    static final String DFA4_eotS =
        "\12\uffff";
    static final String DFA4_eofS =
        "\12\uffff";
    static final String DFA4_minS =
        "\1\4\1\22\1\13\1\25\2\23\1\13\3\uffff";
    static final String DFA4_maxS =
        "\1\4\1\22\1\40\1\25\2\27\1\14\3\uffff";
    static final String DFA4_acceptS =
        "\7\uffff\1\1\1\3\1\2";
    static final String DFA4_specialS =
        "\12\uffff}>";
    static final String[] DFA4_transitionS = {
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
            return "833:1: rule__Scenario1_3__Alternatives_2 : ( ( ( rule__Scenario1_3__ChildAssignment_2_0 ) ) | ( ( rule__Scenario1_3__ChildAssignment_2_1 ) ) | ( ( rule__Scenario1_3__ChildAssignment_2_2 ) ) );";
        }
    }
    static final String DFA5_eotS =
        "\12\uffff";
    static final String DFA5_eofS =
        "\12\uffff";
    static final String DFA5_minS =
        "\1\4\1\22\1\13\1\25\2\23\1\13\3\uffff";
    static final String DFA5_maxS =
        "\1\4\1\22\1\40\1\25\2\27\1\14\3\uffff";
    static final String DFA5_acceptS =
        "\7\uffff\1\3\1\2\1\1";
    static final String DFA5_specialS =
        "\12\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\1",
            "\1\2",
            "\1\4\1\5\23\uffff\1\3",
            "\1\6",
            "\1\11\2\uffff\1\10\1\7",
            "\1\11\2\uffff\1\10\1\7",
            "\1\4\1\5",
            "",
            "",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "861:1: rule__Scenario1_4__Alternatives_2 : ( ( ( rule__Scenario1_4__ChildAssignment_2_0 ) ) | ( ( rule__Scenario1_4__ChildAssignment_2_1 ) ) | ( ( rule__Scenario1_4__ChildAssignment_2_2 ) ) );";
        }
    }
    static final String DFA6_eotS =
        "\12\uffff";
    static final String DFA6_eofS =
        "\12\uffff";
    static final String DFA6_minS =
        "\1\4\1\22\1\13\1\25\2\23\1\13\3\uffff";
    static final String DFA6_maxS =
        "\1\4\1\22\1\40\1\25\2\27\1\14\3\uffff";
    static final String DFA6_acceptS =
        "\7\uffff\1\2\1\1\1\3";
    static final String DFA6_specialS =
        "\12\uffff}>";
    static final String[] DFA6_transitionS = {
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
            return "889:1: rule__Scenario2_1__Alternatives_1 : ( ( ( rule__Scenario2_1__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_1__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_1__ChildAssignment_1_2 ) ) );";
        }
    }
    static final String DFA7_eotS =
        "\12\uffff";
    static final String DFA7_eofS =
        "\12\uffff";
    static final String DFA7_minS =
        "\1\4\1\22\1\13\1\25\2\23\1\13\3\uffff";
    static final String DFA7_maxS =
        "\1\4\1\22\1\40\1\25\2\27\1\14\3\uffff";
    static final String DFA7_acceptS =
        "\7\uffff\1\1\1\3\1\2";
    static final String DFA7_specialS =
        "\12\uffff}>";
    static final String[] DFA7_transitionS = {
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
            return "917:1: rule__Scenario2_2__Alternatives_1 : ( ( ( rule__Scenario2_2__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_2__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_2__ChildAssignment_1_2 ) ) );";
        }
    }
    static final String DFA8_eotS =
        "\12\uffff";
    static final String DFA8_eofS =
        "\12\uffff";
    static final String DFA8_minS =
        "\1\4\1\22\1\13\1\25\2\23\1\13\3\uffff";
    static final String DFA8_maxS =
        "\1\4\1\22\1\40\1\25\2\27\1\14\3\uffff";
    static final String DFA8_acceptS =
        "\7\uffff\1\3\1\1\1\2";
    static final String DFA8_specialS =
        "\12\uffff}>";
    static final String[] DFA8_transitionS = {
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

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "945:1: rule__Scenario2_3__Alternatives_1 : ( ( ( rule__Scenario2_3__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_3__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_3__ChildAssignment_1_2 ) ) );";
        }
    }
    static final String DFA9_eotS =
        "\12\uffff";
    static final String DFA9_eofS =
        "\12\uffff";
    static final String DFA9_minS =
        "\1\4\1\22\1\13\1\25\2\23\1\13\3\uffff";
    static final String DFA9_maxS =
        "\1\4\1\22\1\40\1\25\2\27\1\14\3\uffff";
    static final String DFA9_acceptS =
        "\7\uffff\1\1\1\3\1\2";
    static final String DFA9_specialS =
        "\12\uffff}>";
    static final String[] DFA9_transitionS = {
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

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "973:1: rule__Scenario2_4__Alternatives_1 : ( ( ( rule__Scenario2_4__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_4__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_4__ChildAssignment_1_2 ) ) );";
        }
    }
    static final String DFA10_eotS =
        "\12\uffff";
    static final String DFA10_eofS =
        "\12\uffff";
    static final String DFA10_minS =
        "\1\4\1\22\1\13\1\25\2\23\1\13\3\uffff";
    static final String DFA10_maxS =
        "\1\4\1\22\1\40\1\25\2\27\1\14\3\uffff";
    static final String DFA10_acceptS =
        "\7\uffff\1\2\1\1\1\3";
    static final String DFA10_specialS =
        "\12\uffff}>";
    static final String[] DFA10_transitionS = {
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

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "1001:1: rule__Scenario2_5__Alternatives_2 : ( ( ( rule__Scenario2_5__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_5__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_5__ChildAssignment_2_2 ) ) );";
        }
    }
    static final String DFA11_eotS =
        "\12\uffff";
    static final String DFA11_eofS =
        "\12\uffff";
    static final String DFA11_minS =
        "\1\4\1\22\1\13\1\25\2\23\1\13\3\uffff";
    static final String DFA11_maxS =
        "\1\4\1\22\1\40\1\25\2\27\1\14\3\uffff";
    static final String DFA11_acceptS =
        "\7\uffff\1\2\1\1\1\3";
    static final String DFA11_specialS =
        "\12\uffff}>";
    static final String[] DFA11_transitionS = {
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

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "1029:1: rule__Scenario2_6__Alternatives_2 : ( ( ( rule__Scenario2_6__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_6__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_6__ChildAssignment_2_2 ) ) );";
        }
    }
    static final String DFA12_eotS =
        "\12\uffff";
    static final String DFA12_eofS =
        "\12\uffff";
    static final String DFA12_minS =
        "\1\4\1\22\1\13\1\25\2\23\1\13\3\uffff";
    static final String DFA12_maxS =
        "\1\4\1\22\1\40\1\25\2\27\1\14\3\uffff";
    static final String DFA12_acceptS =
        "\7\uffff\1\1\1\2\1\3";
    static final String DFA12_specialS =
        "\12\uffff}>";
    static final String[] DFA12_transitionS = {
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

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1057:1: rule__Scenario2_7__Alternatives_2 : ( ( ( rule__Scenario2_7__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_7__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_7__ChildAssignment_2_2 ) ) );";
        }
    }
    static final String DFA13_eotS =
        "\12\uffff";
    static final String DFA13_eofS =
        "\12\uffff";
    static final String DFA13_minS =
        "\1\4\1\22\1\13\1\25\2\23\1\13\3\uffff";
    static final String DFA13_maxS =
        "\1\4\1\22\1\40\1\25\2\27\1\14\3\uffff";
    static final String DFA13_acceptS =
        "\7\uffff\1\3\1\1\1\2";
    static final String DFA13_specialS =
        "\12\uffff}>";
    static final String[] DFA13_transitionS = {
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

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "1085:1: rule__Scenario2_8__Alternatives_2 : ( ( ( rule__Scenario2_8__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_8__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_8__ChildAssignment_2_2 ) ) );";
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
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
    // InternalBug348427TestLanguage.g:53:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:54:1: ( ruleModel EOF )
            // InternalBug348427TestLanguage.g:55:1: ruleModel EOF
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
    // InternalBug348427TestLanguage.g:62:1: ruleModel : ( ( rule__Model__Alternatives ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:66:2: ( ( ( rule__Model__Alternatives ) ) )
            // InternalBug348427TestLanguage.g:67:2: ( ( rule__Model__Alternatives ) )
            {
            // InternalBug348427TestLanguage.g:67:2: ( ( rule__Model__Alternatives ) )
            // InternalBug348427TestLanguage.g:68:3: ( rule__Model__Alternatives )
            {
             before(grammarAccess.getModelAccess().getAlternatives()); 
            // InternalBug348427TestLanguage.g:69:3: ( rule__Model__Alternatives )
            // InternalBug348427TestLanguage.g:69:4: rule__Model__Alternatives
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
    // InternalBug348427TestLanguage.g:78:1: entryRuleScenario1_1 : ruleScenario1_1 EOF ;
    public final void entryRuleScenario1_1() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:79:1: ( ruleScenario1_1 EOF )
            // InternalBug348427TestLanguage.g:80:1: ruleScenario1_1 EOF
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
    // InternalBug348427TestLanguage.g:87:1: ruleScenario1_1 : ( ( rule__Scenario1_1__Group__0 ) ) ;
    public final void ruleScenario1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:91:2: ( ( ( rule__Scenario1_1__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:92:2: ( ( rule__Scenario1_1__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:92:2: ( ( rule__Scenario1_1__Group__0 ) )
            // InternalBug348427TestLanguage.g:93:3: ( rule__Scenario1_1__Group__0 )
            {
             before(grammarAccess.getScenario1_1Access().getGroup()); 
            // InternalBug348427TestLanguage.g:94:3: ( rule__Scenario1_1__Group__0 )
            // InternalBug348427TestLanguage.g:94:4: rule__Scenario1_1__Group__0
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
    // InternalBug348427TestLanguage.g:103:1: entryRuleScenario1_2 : ruleScenario1_2 EOF ;
    public final void entryRuleScenario1_2() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:104:1: ( ruleScenario1_2 EOF )
            // InternalBug348427TestLanguage.g:105:1: ruleScenario1_2 EOF
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
    // InternalBug348427TestLanguage.g:112:1: ruleScenario1_2 : ( ( rule__Scenario1_2__Group__0 ) ) ;
    public final void ruleScenario1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:116:2: ( ( ( rule__Scenario1_2__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:117:2: ( ( rule__Scenario1_2__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:117:2: ( ( rule__Scenario1_2__Group__0 ) )
            // InternalBug348427TestLanguage.g:118:3: ( rule__Scenario1_2__Group__0 )
            {
             before(grammarAccess.getScenario1_2Access().getGroup()); 
            // InternalBug348427TestLanguage.g:119:3: ( rule__Scenario1_2__Group__0 )
            // InternalBug348427TestLanguage.g:119:4: rule__Scenario1_2__Group__0
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
    // InternalBug348427TestLanguage.g:128:1: entryRuleScenario1_3 : ruleScenario1_3 EOF ;
    public final void entryRuleScenario1_3() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:129:1: ( ruleScenario1_3 EOF )
            // InternalBug348427TestLanguage.g:130:1: ruleScenario1_3 EOF
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
    // InternalBug348427TestLanguage.g:137:1: ruleScenario1_3 : ( ( rule__Scenario1_3__Group__0 ) ) ;
    public final void ruleScenario1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:141:2: ( ( ( rule__Scenario1_3__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:142:2: ( ( rule__Scenario1_3__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:142:2: ( ( rule__Scenario1_3__Group__0 ) )
            // InternalBug348427TestLanguage.g:143:3: ( rule__Scenario1_3__Group__0 )
            {
             before(grammarAccess.getScenario1_3Access().getGroup()); 
            // InternalBug348427TestLanguage.g:144:3: ( rule__Scenario1_3__Group__0 )
            // InternalBug348427TestLanguage.g:144:4: rule__Scenario1_3__Group__0
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
    // InternalBug348427TestLanguage.g:153:1: entryRuleScenario1_4 : ruleScenario1_4 EOF ;
    public final void entryRuleScenario1_4() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:154:1: ( ruleScenario1_4 EOF )
            // InternalBug348427TestLanguage.g:155:1: ruleScenario1_4 EOF
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
    // InternalBug348427TestLanguage.g:162:1: ruleScenario1_4 : ( ( rule__Scenario1_4__Group__0 ) ) ;
    public final void ruleScenario1_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:166:2: ( ( ( rule__Scenario1_4__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:167:2: ( ( rule__Scenario1_4__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:167:2: ( ( rule__Scenario1_4__Group__0 ) )
            // InternalBug348427TestLanguage.g:168:3: ( rule__Scenario1_4__Group__0 )
            {
             before(grammarAccess.getScenario1_4Access().getGroup()); 
            // InternalBug348427TestLanguage.g:169:3: ( rule__Scenario1_4__Group__0 )
            // InternalBug348427TestLanguage.g:169:4: rule__Scenario1_4__Group__0
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
    // InternalBug348427TestLanguage.g:178:1: entryRuleChild1_1 : ruleChild1_1 EOF ;
    public final void entryRuleChild1_1() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:179:1: ( ruleChild1_1 EOF )
            // InternalBug348427TestLanguage.g:180:1: ruleChild1_1 EOF
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
    // InternalBug348427TestLanguage.g:187:1: ruleChild1_1 : ( ( rule__Child1_1__Group__0 ) ) ;
    public final void ruleChild1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:191:2: ( ( ( rule__Child1_1__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:192:2: ( ( rule__Child1_1__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:192:2: ( ( rule__Child1_1__Group__0 ) )
            // InternalBug348427TestLanguage.g:193:3: ( rule__Child1_1__Group__0 )
            {
             before(grammarAccess.getChild1_1Access().getGroup()); 
            // InternalBug348427TestLanguage.g:194:3: ( rule__Child1_1__Group__0 )
            // InternalBug348427TestLanguage.g:194:4: rule__Child1_1__Group__0
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
    // InternalBug348427TestLanguage.g:203:1: entryRuleChild1_2 : ruleChild1_2 EOF ;
    public final void entryRuleChild1_2() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:204:1: ( ruleChild1_2 EOF )
            // InternalBug348427TestLanguage.g:205:1: ruleChild1_2 EOF
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
    // InternalBug348427TestLanguage.g:212:1: ruleChild1_2 : ( ( rule__Child1_2__Group__0 ) ) ;
    public final void ruleChild1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:216:2: ( ( ( rule__Child1_2__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:217:2: ( ( rule__Child1_2__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:217:2: ( ( rule__Child1_2__Group__0 ) )
            // InternalBug348427TestLanguage.g:218:3: ( rule__Child1_2__Group__0 )
            {
             before(grammarAccess.getChild1_2Access().getGroup()); 
            // InternalBug348427TestLanguage.g:219:3: ( rule__Child1_2__Group__0 )
            // InternalBug348427TestLanguage.g:219:4: rule__Child1_2__Group__0
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
    // InternalBug348427TestLanguage.g:228:1: entryRuleChild1_3 : ruleChild1_3 EOF ;
    public final void entryRuleChild1_3() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:229:1: ( ruleChild1_3 EOF )
            // InternalBug348427TestLanguage.g:230:1: ruleChild1_3 EOF
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
    // InternalBug348427TestLanguage.g:237:1: ruleChild1_3 : ( ( rule__Child1_3__Group__0 ) ) ;
    public final void ruleChild1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:241:2: ( ( ( rule__Child1_3__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:242:2: ( ( rule__Child1_3__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:242:2: ( ( rule__Child1_3__Group__0 ) )
            // InternalBug348427TestLanguage.g:243:3: ( rule__Child1_3__Group__0 )
            {
             before(grammarAccess.getChild1_3Access().getGroup()); 
            // InternalBug348427TestLanguage.g:244:3: ( rule__Child1_3__Group__0 )
            // InternalBug348427TestLanguage.g:244:4: rule__Child1_3__Group__0
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
    // InternalBug348427TestLanguage.g:253:1: entryRuleScenario2_1 : ruleScenario2_1 EOF ;
    public final void entryRuleScenario2_1() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:254:1: ( ruleScenario2_1 EOF )
            // InternalBug348427TestLanguage.g:255:1: ruleScenario2_1 EOF
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
    // InternalBug348427TestLanguage.g:262:1: ruleScenario2_1 : ( ( rule__Scenario2_1__Group__0 ) ) ;
    public final void ruleScenario2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:266:2: ( ( ( rule__Scenario2_1__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:267:2: ( ( rule__Scenario2_1__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:267:2: ( ( rule__Scenario2_1__Group__0 ) )
            // InternalBug348427TestLanguage.g:268:3: ( rule__Scenario2_1__Group__0 )
            {
             before(grammarAccess.getScenario2_1Access().getGroup()); 
            // InternalBug348427TestLanguage.g:269:3: ( rule__Scenario2_1__Group__0 )
            // InternalBug348427TestLanguage.g:269:4: rule__Scenario2_1__Group__0
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
    // InternalBug348427TestLanguage.g:278:1: entryRuleScenario2_2 : ruleScenario2_2 EOF ;
    public final void entryRuleScenario2_2() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:279:1: ( ruleScenario2_2 EOF )
            // InternalBug348427TestLanguage.g:280:1: ruleScenario2_2 EOF
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
    // InternalBug348427TestLanguage.g:287:1: ruleScenario2_2 : ( ( rule__Scenario2_2__Group__0 ) ) ;
    public final void ruleScenario2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:291:2: ( ( ( rule__Scenario2_2__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:292:2: ( ( rule__Scenario2_2__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:292:2: ( ( rule__Scenario2_2__Group__0 ) )
            // InternalBug348427TestLanguage.g:293:3: ( rule__Scenario2_2__Group__0 )
            {
             before(grammarAccess.getScenario2_2Access().getGroup()); 
            // InternalBug348427TestLanguage.g:294:3: ( rule__Scenario2_2__Group__0 )
            // InternalBug348427TestLanguage.g:294:4: rule__Scenario2_2__Group__0
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
    // InternalBug348427TestLanguage.g:303:1: entryRuleScenario2_3 : ruleScenario2_3 EOF ;
    public final void entryRuleScenario2_3() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:304:1: ( ruleScenario2_3 EOF )
            // InternalBug348427TestLanguage.g:305:1: ruleScenario2_3 EOF
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
    // InternalBug348427TestLanguage.g:312:1: ruleScenario2_3 : ( ( rule__Scenario2_3__Group__0 ) ) ;
    public final void ruleScenario2_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:316:2: ( ( ( rule__Scenario2_3__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:317:2: ( ( rule__Scenario2_3__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:317:2: ( ( rule__Scenario2_3__Group__0 ) )
            // InternalBug348427TestLanguage.g:318:3: ( rule__Scenario2_3__Group__0 )
            {
             before(grammarAccess.getScenario2_3Access().getGroup()); 
            // InternalBug348427TestLanguage.g:319:3: ( rule__Scenario2_3__Group__0 )
            // InternalBug348427TestLanguage.g:319:4: rule__Scenario2_3__Group__0
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
    // InternalBug348427TestLanguage.g:328:1: entryRuleScenario2_4 : ruleScenario2_4 EOF ;
    public final void entryRuleScenario2_4() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:329:1: ( ruleScenario2_4 EOF )
            // InternalBug348427TestLanguage.g:330:1: ruleScenario2_4 EOF
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
    // InternalBug348427TestLanguage.g:337:1: ruleScenario2_4 : ( ( rule__Scenario2_4__Group__0 ) ) ;
    public final void ruleScenario2_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:341:2: ( ( ( rule__Scenario2_4__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:342:2: ( ( rule__Scenario2_4__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:342:2: ( ( rule__Scenario2_4__Group__0 ) )
            // InternalBug348427TestLanguage.g:343:3: ( rule__Scenario2_4__Group__0 )
            {
             before(grammarAccess.getScenario2_4Access().getGroup()); 
            // InternalBug348427TestLanguage.g:344:3: ( rule__Scenario2_4__Group__0 )
            // InternalBug348427TestLanguage.g:344:4: rule__Scenario2_4__Group__0
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
    // InternalBug348427TestLanguage.g:353:1: entryRuleScenario2_5 : ruleScenario2_5 EOF ;
    public final void entryRuleScenario2_5() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:354:1: ( ruleScenario2_5 EOF )
            // InternalBug348427TestLanguage.g:355:1: ruleScenario2_5 EOF
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
    // InternalBug348427TestLanguage.g:362:1: ruleScenario2_5 : ( ( rule__Scenario2_5__Group__0 ) ) ;
    public final void ruleScenario2_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:366:2: ( ( ( rule__Scenario2_5__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:367:2: ( ( rule__Scenario2_5__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:367:2: ( ( rule__Scenario2_5__Group__0 ) )
            // InternalBug348427TestLanguage.g:368:3: ( rule__Scenario2_5__Group__0 )
            {
             before(grammarAccess.getScenario2_5Access().getGroup()); 
            // InternalBug348427TestLanguage.g:369:3: ( rule__Scenario2_5__Group__0 )
            // InternalBug348427TestLanguage.g:369:4: rule__Scenario2_5__Group__0
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
    // InternalBug348427TestLanguage.g:378:1: entryRuleScenario2_6 : ruleScenario2_6 EOF ;
    public final void entryRuleScenario2_6() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:379:1: ( ruleScenario2_6 EOF )
            // InternalBug348427TestLanguage.g:380:1: ruleScenario2_6 EOF
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
    // InternalBug348427TestLanguage.g:387:1: ruleScenario2_6 : ( ( rule__Scenario2_6__Group__0 ) ) ;
    public final void ruleScenario2_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:391:2: ( ( ( rule__Scenario2_6__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:392:2: ( ( rule__Scenario2_6__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:392:2: ( ( rule__Scenario2_6__Group__0 ) )
            // InternalBug348427TestLanguage.g:393:3: ( rule__Scenario2_6__Group__0 )
            {
             before(grammarAccess.getScenario2_6Access().getGroup()); 
            // InternalBug348427TestLanguage.g:394:3: ( rule__Scenario2_6__Group__0 )
            // InternalBug348427TestLanguage.g:394:4: rule__Scenario2_6__Group__0
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
    // InternalBug348427TestLanguage.g:403:1: entryRuleScenario2_7 : ruleScenario2_7 EOF ;
    public final void entryRuleScenario2_7() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:404:1: ( ruleScenario2_7 EOF )
            // InternalBug348427TestLanguage.g:405:1: ruleScenario2_7 EOF
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
    // InternalBug348427TestLanguage.g:412:1: ruleScenario2_7 : ( ( rule__Scenario2_7__Group__0 ) ) ;
    public final void ruleScenario2_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:416:2: ( ( ( rule__Scenario2_7__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:417:2: ( ( rule__Scenario2_7__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:417:2: ( ( rule__Scenario2_7__Group__0 ) )
            // InternalBug348427TestLanguage.g:418:3: ( rule__Scenario2_7__Group__0 )
            {
             before(grammarAccess.getScenario2_7Access().getGroup()); 
            // InternalBug348427TestLanguage.g:419:3: ( rule__Scenario2_7__Group__0 )
            // InternalBug348427TestLanguage.g:419:4: rule__Scenario2_7__Group__0
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
    // InternalBug348427TestLanguage.g:428:1: entryRuleScenario2_8 : ruleScenario2_8 EOF ;
    public final void entryRuleScenario2_8() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:429:1: ( ruleScenario2_8 EOF )
            // InternalBug348427TestLanguage.g:430:1: ruleScenario2_8 EOF
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
    // InternalBug348427TestLanguage.g:437:1: ruleScenario2_8 : ( ( rule__Scenario2_8__Group__0 ) ) ;
    public final void ruleScenario2_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:441:2: ( ( ( rule__Scenario2_8__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:442:2: ( ( rule__Scenario2_8__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:442:2: ( ( rule__Scenario2_8__Group__0 ) )
            // InternalBug348427TestLanguage.g:443:3: ( rule__Scenario2_8__Group__0 )
            {
             before(grammarAccess.getScenario2_8Access().getGroup()); 
            // InternalBug348427TestLanguage.g:444:3: ( rule__Scenario2_8__Group__0 )
            // InternalBug348427TestLanguage.g:444:4: rule__Scenario2_8__Group__0
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
    // InternalBug348427TestLanguage.g:453:1: entryRuleChild2_1 : ruleChild2_1 EOF ;
    public final void entryRuleChild2_1() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:454:1: ( ruleChild2_1 EOF )
            // InternalBug348427TestLanguage.g:455:1: ruleChild2_1 EOF
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
    // InternalBug348427TestLanguage.g:462:1: ruleChild2_1 : ( ( rule__Child2_1__Group__0 ) ) ;
    public final void ruleChild2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:466:2: ( ( ( rule__Child2_1__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:467:2: ( ( rule__Child2_1__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:467:2: ( ( rule__Child2_1__Group__0 ) )
            // InternalBug348427TestLanguage.g:468:3: ( rule__Child2_1__Group__0 )
            {
             before(grammarAccess.getChild2_1Access().getGroup()); 
            // InternalBug348427TestLanguage.g:469:3: ( rule__Child2_1__Group__0 )
            // InternalBug348427TestLanguage.g:469:4: rule__Child2_1__Group__0
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
    // InternalBug348427TestLanguage.g:478:1: entryRuleChild2_2 : ruleChild2_2 EOF ;
    public final void entryRuleChild2_2() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:479:1: ( ruleChild2_2 EOF )
            // InternalBug348427TestLanguage.g:480:1: ruleChild2_2 EOF
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
    // InternalBug348427TestLanguage.g:487:1: ruleChild2_2 : ( ( rule__Child2_2__Group__0 ) ) ;
    public final void ruleChild2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:491:2: ( ( ( rule__Child2_2__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:492:2: ( ( rule__Child2_2__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:492:2: ( ( rule__Child2_2__Group__0 ) )
            // InternalBug348427TestLanguage.g:493:3: ( rule__Child2_2__Group__0 )
            {
             before(grammarAccess.getChild2_2Access().getGroup()); 
            // InternalBug348427TestLanguage.g:494:3: ( rule__Child2_2__Group__0 )
            // InternalBug348427TestLanguage.g:494:4: rule__Child2_2__Group__0
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
    // InternalBug348427TestLanguage.g:503:1: entryRuleChild2_3 : ruleChild2_3 EOF ;
    public final void entryRuleChild2_3() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:504:1: ( ruleChild2_3 EOF )
            // InternalBug348427TestLanguage.g:505:1: ruleChild2_3 EOF
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
    // InternalBug348427TestLanguage.g:512:1: ruleChild2_3 : ( ( rule__Child2_3__Group__0 ) ) ;
    public final void ruleChild2_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:516:2: ( ( ( rule__Child2_3__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:517:2: ( ( rule__Child2_3__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:517:2: ( ( rule__Child2_3__Group__0 ) )
            // InternalBug348427TestLanguage.g:518:3: ( rule__Child2_3__Group__0 )
            {
             before(grammarAccess.getChild2_3Access().getGroup()); 
            // InternalBug348427TestLanguage.g:519:3: ( rule__Child2_3__Group__0 )
            // InternalBug348427TestLanguage.g:519:4: rule__Child2_3__Group__0
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
    // InternalBug348427TestLanguage.g:528:1: entryRuleChild2_4 : ruleChild2_4 EOF ;
    public final void entryRuleChild2_4() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:529:1: ( ruleChild2_4 EOF )
            // InternalBug348427TestLanguage.g:530:1: ruleChild2_4 EOF
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
    // InternalBug348427TestLanguage.g:537:1: ruleChild2_4 : ( ( rule__Child2_4__Group__0 ) ) ;
    public final void ruleChild2_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:541:2: ( ( ( rule__Child2_4__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:542:2: ( ( rule__Child2_4__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:542:2: ( ( rule__Child2_4__Group__0 ) )
            // InternalBug348427TestLanguage.g:543:3: ( rule__Child2_4__Group__0 )
            {
             before(grammarAccess.getChild2_4Access().getGroup()); 
            // InternalBug348427TestLanguage.g:544:3: ( rule__Child2_4__Group__0 )
            // InternalBug348427TestLanguage.g:544:4: rule__Child2_4__Group__0
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
    // InternalBug348427TestLanguage.g:553:1: entryRuleChild2_5 : ruleChild2_5 EOF ;
    public final void entryRuleChild2_5() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:554:1: ( ruleChild2_5 EOF )
            // InternalBug348427TestLanguage.g:555:1: ruleChild2_5 EOF
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
    // InternalBug348427TestLanguage.g:562:1: ruleChild2_5 : ( ( rule__Child2_5__Group__0 ) ) ;
    public final void ruleChild2_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:566:2: ( ( ( rule__Child2_5__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:567:2: ( ( rule__Child2_5__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:567:2: ( ( rule__Child2_5__Group__0 ) )
            // InternalBug348427TestLanguage.g:568:3: ( rule__Child2_5__Group__0 )
            {
             before(grammarAccess.getChild2_5Access().getGroup()); 
            // InternalBug348427TestLanguage.g:569:3: ( rule__Child2_5__Group__0 )
            // InternalBug348427TestLanguage.g:569:4: rule__Child2_5__Group__0
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
    // InternalBug348427TestLanguage.g:578:1: entryRuleChild2_6 : ruleChild2_6 EOF ;
    public final void entryRuleChild2_6() throws RecognitionException {
        try {
            // InternalBug348427TestLanguage.g:579:1: ( ruleChild2_6 EOF )
            // InternalBug348427TestLanguage.g:580:1: ruleChild2_6 EOF
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
    // InternalBug348427TestLanguage.g:587:1: ruleChild2_6 : ( ( rule__Child2_6__Group__0 ) ) ;
    public final void ruleChild2_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:591:2: ( ( ( rule__Child2_6__Group__0 ) ) )
            // InternalBug348427TestLanguage.g:592:2: ( ( rule__Child2_6__Group__0 ) )
            {
            // InternalBug348427TestLanguage.g:592:2: ( ( rule__Child2_6__Group__0 ) )
            // InternalBug348427TestLanguage.g:593:3: ( rule__Child2_6__Group__0 )
            {
             before(grammarAccess.getChild2_6Access().getGroup()); 
            // InternalBug348427TestLanguage.g:594:3: ( rule__Child2_6__Group__0 )
            // InternalBug348427TestLanguage.g:594:4: rule__Child2_6__Group__0
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
    // InternalBug348427TestLanguage.g:603:1: ruleEnumType : ( ( rule__EnumType__Alternatives ) ) ;
    public final void ruleEnumType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:607:1: ( ( ( rule__EnumType__Alternatives ) ) )
            // InternalBug348427TestLanguage.g:608:2: ( ( rule__EnumType__Alternatives ) )
            {
            // InternalBug348427TestLanguage.g:608:2: ( ( rule__EnumType__Alternatives ) )
            // InternalBug348427TestLanguage.g:609:3: ( rule__EnumType__Alternatives )
            {
             before(grammarAccess.getEnumTypeAccess().getAlternatives()); 
            // InternalBug348427TestLanguage.g:610:3: ( rule__EnumType__Alternatives )
            // InternalBug348427TestLanguage.g:610:4: rule__EnumType__Alternatives
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
    // InternalBug348427TestLanguage.g:618:1: rule__Model__Alternatives : ( ( ( rule__Model__Element1Assignment_0 ) ) | ( ( rule__Model__Element1Assignment_1 ) ) | ( ( rule__Model__Element1Assignment_2 ) ) | ( ( rule__Model__Element1Assignment_3 ) ) | ( ( rule__Model__Element2Assignment_4 ) ) | ( ( rule__Model__Element2Assignment_5 ) ) | ( ( rule__Model__Element2Assignment_6 ) ) | ( ( rule__Model__Element2Assignment_7 ) ) | ( ( rule__Model__Element2Assignment_8 ) ) | ( ( rule__Model__Element2Assignment_9 ) ) | ( ( rule__Model__Element2Assignment_10 ) ) | ( ( rule__Model__Element2Assignment_11 ) ) );
    public final void rule__Model__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:622:1: ( ( ( rule__Model__Element1Assignment_0 ) ) | ( ( rule__Model__Element1Assignment_1 ) ) | ( ( rule__Model__Element1Assignment_2 ) ) | ( ( rule__Model__Element1Assignment_3 ) ) | ( ( rule__Model__Element2Assignment_4 ) ) | ( ( rule__Model__Element2Assignment_5 ) ) | ( ( rule__Model__Element2Assignment_6 ) ) | ( ( rule__Model__Element2Assignment_7 ) ) | ( ( rule__Model__Element2Assignment_8 ) ) | ( ( rule__Model__Element2Assignment_9 ) ) | ( ( rule__Model__Element2Assignment_10 ) ) | ( ( rule__Model__Element2Assignment_11 ) ) )
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
                    // InternalBug348427TestLanguage.g:623:2: ( ( rule__Model__Element1Assignment_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:623:2: ( ( rule__Model__Element1Assignment_0 ) )
                    // InternalBug348427TestLanguage.g:624:3: ( rule__Model__Element1Assignment_0 )
                    {
                     before(grammarAccess.getModelAccess().getElement1Assignment_0()); 
                    // InternalBug348427TestLanguage.g:625:3: ( rule__Model__Element1Assignment_0 )
                    // InternalBug348427TestLanguage.g:625:4: rule__Model__Element1Assignment_0
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
                    // InternalBug348427TestLanguage.g:629:2: ( ( rule__Model__Element1Assignment_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:629:2: ( ( rule__Model__Element1Assignment_1 ) )
                    // InternalBug348427TestLanguage.g:630:3: ( rule__Model__Element1Assignment_1 )
                    {
                     before(grammarAccess.getModelAccess().getElement1Assignment_1()); 
                    // InternalBug348427TestLanguage.g:631:3: ( rule__Model__Element1Assignment_1 )
                    // InternalBug348427TestLanguage.g:631:4: rule__Model__Element1Assignment_1
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
                    // InternalBug348427TestLanguage.g:635:2: ( ( rule__Model__Element1Assignment_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:635:2: ( ( rule__Model__Element1Assignment_2 ) )
                    // InternalBug348427TestLanguage.g:636:3: ( rule__Model__Element1Assignment_2 )
                    {
                     before(grammarAccess.getModelAccess().getElement1Assignment_2()); 
                    // InternalBug348427TestLanguage.g:637:3: ( rule__Model__Element1Assignment_2 )
                    // InternalBug348427TestLanguage.g:637:4: rule__Model__Element1Assignment_2
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
                    // InternalBug348427TestLanguage.g:641:2: ( ( rule__Model__Element1Assignment_3 ) )
                    {
                    // InternalBug348427TestLanguage.g:641:2: ( ( rule__Model__Element1Assignment_3 ) )
                    // InternalBug348427TestLanguage.g:642:3: ( rule__Model__Element1Assignment_3 )
                    {
                     before(grammarAccess.getModelAccess().getElement1Assignment_3()); 
                    // InternalBug348427TestLanguage.g:643:3: ( rule__Model__Element1Assignment_3 )
                    // InternalBug348427TestLanguage.g:643:4: rule__Model__Element1Assignment_3
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
                    // InternalBug348427TestLanguage.g:647:2: ( ( rule__Model__Element2Assignment_4 ) )
                    {
                    // InternalBug348427TestLanguage.g:647:2: ( ( rule__Model__Element2Assignment_4 ) )
                    // InternalBug348427TestLanguage.g:648:3: ( rule__Model__Element2Assignment_4 )
                    {
                     before(grammarAccess.getModelAccess().getElement2Assignment_4()); 
                    // InternalBug348427TestLanguage.g:649:3: ( rule__Model__Element2Assignment_4 )
                    // InternalBug348427TestLanguage.g:649:4: rule__Model__Element2Assignment_4
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
                    // InternalBug348427TestLanguage.g:653:2: ( ( rule__Model__Element2Assignment_5 ) )
                    {
                    // InternalBug348427TestLanguage.g:653:2: ( ( rule__Model__Element2Assignment_5 ) )
                    // InternalBug348427TestLanguage.g:654:3: ( rule__Model__Element2Assignment_5 )
                    {
                     before(grammarAccess.getModelAccess().getElement2Assignment_5()); 
                    // InternalBug348427TestLanguage.g:655:3: ( rule__Model__Element2Assignment_5 )
                    // InternalBug348427TestLanguage.g:655:4: rule__Model__Element2Assignment_5
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
                    // InternalBug348427TestLanguage.g:659:2: ( ( rule__Model__Element2Assignment_6 ) )
                    {
                    // InternalBug348427TestLanguage.g:659:2: ( ( rule__Model__Element2Assignment_6 ) )
                    // InternalBug348427TestLanguage.g:660:3: ( rule__Model__Element2Assignment_6 )
                    {
                     before(grammarAccess.getModelAccess().getElement2Assignment_6()); 
                    // InternalBug348427TestLanguage.g:661:3: ( rule__Model__Element2Assignment_6 )
                    // InternalBug348427TestLanguage.g:661:4: rule__Model__Element2Assignment_6
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
                    // InternalBug348427TestLanguage.g:665:2: ( ( rule__Model__Element2Assignment_7 ) )
                    {
                    // InternalBug348427TestLanguage.g:665:2: ( ( rule__Model__Element2Assignment_7 ) )
                    // InternalBug348427TestLanguage.g:666:3: ( rule__Model__Element2Assignment_7 )
                    {
                     before(grammarAccess.getModelAccess().getElement2Assignment_7()); 
                    // InternalBug348427TestLanguage.g:667:3: ( rule__Model__Element2Assignment_7 )
                    // InternalBug348427TestLanguage.g:667:4: rule__Model__Element2Assignment_7
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
                    // InternalBug348427TestLanguage.g:671:2: ( ( rule__Model__Element2Assignment_8 ) )
                    {
                    // InternalBug348427TestLanguage.g:671:2: ( ( rule__Model__Element2Assignment_8 ) )
                    // InternalBug348427TestLanguage.g:672:3: ( rule__Model__Element2Assignment_8 )
                    {
                     before(grammarAccess.getModelAccess().getElement2Assignment_8()); 
                    // InternalBug348427TestLanguage.g:673:3: ( rule__Model__Element2Assignment_8 )
                    // InternalBug348427TestLanguage.g:673:4: rule__Model__Element2Assignment_8
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
                    // InternalBug348427TestLanguage.g:677:2: ( ( rule__Model__Element2Assignment_9 ) )
                    {
                    // InternalBug348427TestLanguage.g:677:2: ( ( rule__Model__Element2Assignment_9 ) )
                    // InternalBug348427TestLanguage.g:678:3: ( rule__Model__Element2Assignment_9 )
                    {
                     before(grammarAccess.getModelAccess().getElement2Assignment_9()); 
                    // InternalBug348427TestLanguage.g:679:3: ( rule__Model__Element2Assignment_9 )
                    // InternalBug348427TestLanguage.g:679:4: rule__Model__Element2Assignment_9
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
                    // InternalBug348427TestLanguage.g:683:2: ( ( rule__Model__Element2Assignment_10 ) )
                    {
                    // InternalBug348427TestLanguage.g:683:2: ( ( rule__Model__Element2Assignment_10 ) )
                    // InternalBug348427TestLanguage.g:684:3: ( rule__Model__Element2Assignment_10 )
                    {
                     before(grammarAccess.getModelAccess().getElement2Assignment_10()); 
                    // InternalBug348427TestLanguage.g:685:3: ( rule__Model__Element2Assignment_10 )
                    // InternalBug348427TestLanguage.g:685:4: rule__Model__Element2Assignment_10
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
                    // InternalBug348427TestLanguage.g:689:2: ( ( rule__Model__Element2Assignment_11 ) )
                    {
                    // InternalBug348427TestLanguage.g:689:2: ( ( rule__Model__Element2Assignment_11 ) )
                    // InternalBug348427TestLanguage.g:690:3: ( rule__Model__Element2Assignment_11 )
                    {
                     before(grammarAccess.getModelAccess().getElement2Assignment_11()); 
                    // InternalBug348427TestLanguage.g:691:3: ( rule__Model__Element2Assignment_11 )
                    // InternalBug348427TestLanguage.g:691:4: rule__Model__Element2Assignment_11
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
    // InternalBug348427TestLanguage.g:699:1: rule__Scenario1_1__Alternatives_1 : ( ( ( rule__Scenario1_1__ChildAssignment_1_0 ) ) | ( ( rule__Scenario1_1__ChildAssignment_1_1 ) ) | ( ( rule__Scenario1_1__ChildAssignment_1_2 ) ) );
    public final void rule__Scenario1_1__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:703:1: ( ( ( rule__Scenario1_1__ChildAssignment_1_0 ) ) | ( ( rule__Scenario1_1__ChildAssignment_1_1 ) ) | ( ( rule__Scenario1_1__ChildAssignment_1_2 ) ) )
            int alt2=3;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // InternalBug348427TestLanguage.g:704:2: ( ( rule__Scenario1_1__ChildAssignment_1_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:704:2: ( ( rule__Scenario1_1__ChildAssignment_1_0 ) )
                    // InternalBug348427TestLanguage.g:705:3: ( rule__Scenario1_1__ChildAssignment_1_0 )
                    {
                     before(grammarAccess.getScenario1_1Access().getChildAssignment_1_0()); 
                    // InternalBug348427TestLanguage.g:706:3: ( rule__Scenario1_1__ChildAssignment_1_0 )
                    // InternalBug348427TestLanguage.g:706:4: rule__Scenario1_1__ChildAssignment_1_0
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
                    // InternalBug348427TestLanguage.g:710:2: ( ( rule__Scenario1_1__ChildAssignment_1_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:710:2: ( ( rule__Scenario1_1__ChildAssignment_1_1 ) )
                    // InternalBug348427TestLanguage.g:711:3: ( rule__Scenario1_1__ChildAssignment_1_1 )
                    {
                     before(grammarAccess.getScenario1_1Access().getChildAssignment_1_1()); 
                    // InternalBug348427TestLanguage.g:712:3: ( rule__Scenario1_1__ChildAssignment_1_1 )
                    // InternalBug348427TestLanguage.g:712:4: rule__Scenario1_1__ChildAssignment_1_1
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
                    // InternalBug348427TestLanguage.g:716:2: ( ( rule__Scenario1_1__ChildAssignment_1_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:716:2: ( ( rule__Scenario1_1__ChildAssignment_1_2 ) )
                    // InternalBug348427TestLanguage.g:717:3: ( rule__Scenario1_1__ChildAssignment_1_2 )
                    {
                     before(grammarAccess.getScenario1_1Access().getChildAssignment_1_2()); 
                    // InternalBug348427TestLanguage.g:718:3: ( rule__Scenario1_1__ChildAssignment_1_2 )
                    // InternalBug348427TestLanguage.g:718:4: rule__Scenario1_1__ChildAssignment_1_2
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
    // InternalBug348427TestLanguage.g:726:1: rule__Scenario1_2__Alternatives_1 : ( ( ( rule__Scenario1_2__ChildAssignment_1_0 ) ) | ( ( rule__Scenario1_2__ChildAssignment_1_1 ) ) | ( ( rule__Scenario1_2__ChildAssignment_1_2 ) ) );
    public final void rule__Scenario1_2__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:730:1: ( ( ( rule__Scenario1_2__ChildAssignment_1_0 ) ) | ( ( rule__Scenario1_2__ChildAssignment_1_1 ) ) | ( ( rule__Scenario1_2__ChildAssignment_1_2 ) ) )
            int alt3=3;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // InternalBug348427TestLanguage.g:731:2: ( ( rule__Scenario1_2__ChildAssignment_1_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:731:2: ( ( rule__Scenario1_2__ChildAssignment_1_0 ) )
                    // InternalBug348427TestLanguage.g:732:3: ( rule__Scenario1_2__ChildAssignment_1_0 )
                    {
                     before(grammarAccess.getScenario1_2Access().getChildAssignment_1_0()); 
                    // InternalBug348427TestLanguage.g:733:3: ( rule__Scenario1_2__ChildAssignment_1_0 )
                    // InternalBug348427TestLanguage.g:733:4: rule__Scenario1_2__ChildAssignment_1_0
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
                    // InternalBug348427TestLanguage.g:737:2: ( ( rule__Scenario1_2__ChildAssignment_1_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:737:2: ( ( rule__Scenario1_2__ChildAssignment_1_1 ) )
                    // InternalBug348427TestLanguage.g:738:3: ( rule__Scenario1_2__ChildAssignment_1_1 )
                    {
                     before(grammarAccess.getScenario1_2Access().getChildAssignment_1_1()); 
                    // InternalBug348427TestLanguage.g:739:3: ( rule__Scenario1_2__ChildAssignment_1_1 )
                    // InternalBug348427TestLanguage.g:739:4: rule__Scenario1_2__ChildAssignment_1_1
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
                    // InternalBug348427TestLanguage.g:743:2: ( ( rule__Scenario1_2__ChildAssignment_1_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:743:2: ( ( rule__Scenario1_2__ChildAssignment_1_2 ) )
                    // InternalBug348427TestLanguage.g:744:3: ( rule__Scenario1_2__ChildAssignment_1_2 )
                    {
                     before(grammarAccess.getScenario1_2Access().getChildAssignment_1_2()); 
                    // InternalBug348427TestLanguage.g:745:3: ( rule__Scenario1_2__ChildAssignment_1_2 )
                    // InternalBug348427TestLanguage.g:745:4: rule__Scenario1_2__ChildAssignment_1_2
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
    // InternalBug348427TestLanguage.g:753:1: rule__Scenario1_3__Alternatives_2 : ( ( ( rule__Scenario1_3__ChildAssignment_2_0 ) ) | ( ( rule__Scenario1_3__ChildAssignment_2_1 ) ) | ( ( rule__Scenario1_3__ChildAssignment_2_2 ) ) );
    public final void rule__Scenario1_3__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:757:1: ( ( ( rule__Scenario1_3__ChildAssignment_2_0 ) ) | ( ( rule__Scenario1_3__ChildAssignment_2_1 ) ) | ( ( rule__Scenario1_3__ChildAssignment_2_2 ) ) )
            int alt4=3;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // InternalBug348427TestLanguage.g:758:2: ( ( rule__Scenario1_3__ChildAssignment_2_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:758:2: ( ( rule__Scenario1_3__ChildAssignment_2_0 ) )
                    // InternalBug348427TestLanguage.g:759:3: ( rule__Scenario1_3__ChildAssignment_2_0 )
                    {
                     before(grammarAccess.getScenario1_3Access().getChildAssignment_2_0()); 
                    // InternalBug348427TestLanguage.g:760:3: ( rule__Scenario1_3__ChildAssignment_2_0 )
                    // InternalBug348427TestLanguage.g:760:4: rule__Scenario1_3__ChildAssignment_2_0
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
                    // InternalBug348427TestLanguage.g:764:2: ( ( rule__Scenario1_3__ChildAssignment_2_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:764:2: ( ( rule__Scenario1_3__ChildAssignment_2_1 ) )
                    // InternalBug348427TestLanguage.g:765:3: ( rule__Scenario1_3__ChildAssignment_2_1 )
                    {
                     before(grammarAccess.getScenario1_3Access().getChildAssignment_2_1()); 
                    // InternalBug348427TestLanguage.g:766:3: ( rule__Scenario1_3__ChildAssignment_2_1 )
                    // InternalBug348427TestLanguage.g:766:4: rule__Scenario1_3__ChildAssignment_2_1
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
                    // InternalBug348427TestLanguage.g:770:2: ( ( rule__Scenario1_3__ChildAssignment_2_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:770:2: ( ( rule__Scenario1_3__ChildAssignment_2_2 ) )
                    // InternalBug348427TestLanguage.g:771:3: ( rule__Scenario1_3__ChildAssignment_2_2 )
                    {
                     before(grammarAccess.getScenario1_3Access().getChildAssignment_2_2()); 
                    // InternalBug348427TestLanguage.g:772:3: ( rule__Scenario1_3__ChildAssignment_2_2 )
                    // InternalBug348427TestLanguage.g:772:4: rule__Scenario1_3__ChildAssignment_2_2
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
    // InternalBug348427TestLanguage.g:780:1: rule__Scenario1_4__Alternatives_2 : ( ( ( rule__Scenario1_4__ChildAssignment_2_0 ) ) | ( ( rule__Scenario1_4__ChildAssignment_2_1 ) ) | ( ( rule__Scenario1_4__ChildAssignment_2_2 ) ) );
    public final void rule__Scenario1_4__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:784:1: ( ( ( rule__Scenario1_4__ChildAssignment_2_0 ) ) | ( ( rule__Scenario1_4__ChildAssignment_2_1 ) ) | ( ( rule__Scenario1_4__ChildAssignment_2_2 ) ) )
            int alt5=3;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // InternalBug348427TestLanguage.g:785:2: ( ( rule__Scenario1_4__ChildAssignment_2_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:785:2: ( ( rule__Scenario1_4__ChildAssignment_2_0 ) )
                    // InternalBug348427TestLanguage.g:786:3: ( rule__Scenario1_4__ChildAssignment_2_0 )
                    {
                     before(grammarAccess.getScenario1_4Access().getChildAssignment_2_0()); 
                    // InternalBug348427TestLanguage.g:787:3: ( rule__Scenario1_4__ChildAssignment_2_0 )
                    // InternalBug348427TestLanguage.g:787:4: rule__Scenario1_4__ChildAssignment_2_0
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
                    // InternalBug348427TestLanguage.g:791:2: ( ( rule__Scenario1_4__ChildAssignment_2_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:791:2: ( ( rule__Scenario1_4__ChildAssignment_2_1 ) )
                    // InternalBug348427TestLanguage.g:792:3: ( rule__Scenario1_4__ChildAssignment_2_1 )
                    {
                     before(grammarAccess.getScenario1_4Access().getChildAssignment_2_1()); 
                    // InternalBug348427TestLanguage.g:793:3: ( rule__Scenario1_4__ChildAssignment_2_1 )
                    // InternalBug348427TestLanguage.g:793:4: rule__Scenario1_4__ChildAssignment_2_1
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
                    // InternalBug348427TestLanguage.g:797:2: ( ( rule__Scenario1_4__ChildAssignment_2_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:797:2: ( ( rule__Scenario1_4__ChildAssignment_2_2 ) )
                    // InternalBug348427TestLanguage.g:798:3: ( rule__Scenario1_4__ChildAssignment_2_2 )
                    {
                     before(grammarAccess.getScenario1_4Access().getChildAssignment_2_2()); 
                    // InternalBug348427TestLanguage.g:799:3: ( rule__Scenario1_4__ChildAssignment_2_2 )
                    // InternalBug348427TestLanguage.g:799:4: rule__Scenario1_4__ChildAssignment_2_2
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
    // InternalBug348427TestLanguage.g:807:1: rule__Scenario2_1__Alternatives_1 : ( ( ( rule__Scenario2_1__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_1__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_1__ChildAssignment_1_2 ) ) );
    public final void rule__Scenario2_1__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:811:1: ( ( ( rule__Scenario2_1__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_1__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_1__ChildAssignment_1_2 ) ) )
            int alt6=3;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // InternalBug348427TestLanguage.g:812:2: ( ( rule__Scenario2_1__ChildAssignment_1_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:812:2: ( ( rule__Scenario2_1__ChildAssignment_1_0 ) )
                    // InternalBug348427TestLanguage.g:813:3: ( rule__Scenario2_1__ChildAssignment_1_0 )
                    {
                     before(grammarAccess.getScenario2_1Access().getChildAssignment_1_0()); 
                    // InternalBug348427TestLanguage.g:814:3: ( rule__Scenario2_1__ChildAssignment_1_0 )
                    // InternalBug348427TestLanguage.g:814:4: rule__Scenario2_1__ChildAssignment_1_0
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
                    // InternalBug348427TestLanguage.g:818:2: ( ( rule__Scenario2_1__ChildAssignment_1_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:818:2: ( ( rule__Scenario2_1__ChildAssignment_1_1 ) )
                    // InternalBug348427TestLanguage.g:819:3: ( rule__Scenario2_1__ChildAssignment_1_1 )
                    {
                     before(grammarAccess.getScenario2_1Access().getChildAssignment_1_1()); 
                    // InternalBug348427TestLanguage.g:820:3: ( rule__Scenario2_1__ChildAssignment_1_1 )
                    // InternalBug348427TestLanguage.g:820:4: rule__Scenario2_1__ChildAssignment_1_1
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
                    // InternalBug348427TestLanguage.g:824:2: ( ( rule__Scenario2_1__ChildAssignment_1_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:824:2: ( ( rule__Scenario2_1__ChildAssignment_1_2 ) )
                    // InternalBug348427TestLanguage.g:825:3: ( rule__Scenario2_1__ChildAssignment_1_2 )
                    {
                     before(grammarAccess.getScenario2_1Access().getChildAssignment_1_2()); 
                    // InternalBug348427TestLanguage.g:826:3: ( rule__Scenario2_1__ChildAssignment_1_2 )
                    // InternalBug348427TestLanguage.g:826:4: rule__Scenario2_1__ChildAssignment_1_2
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
    // InternalBug348427TestLanguage.g:834:1: rule__Scenario2_2__Alternatives_1 : ( ( ( rule__Scenario2_2__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_2__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_2__ChildAssignment_1_2 ) ) );
    public final void rule__Scenario2_2__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:838:1: ( ( ( rule__Scenario2_2__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_2__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_2__ChildAssignment_1_2 ) ) )
            int alt7=3;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // InternalBug348427TestLanguage.g:839:2: ( ( rule__Scenario2_2__ChildAssignment_1_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:839:2: ( ( rule__Scenario2_2__ChildAssignment_1_0 ) )
                    // InternalBug348427TestLanguage.g:840:3: ( rule__Scenario2_2__ChildAssignment_1_0 )
                    {
                     before(grammarAccess.getScenario2_2Access().getChildAssignment_1_0()); 
                    // InternalBug348427TestLanguage.g:841:3: ( rule__Scenario2_2__ChildAssignment_1_0 )
                    // InternalBug348427TestLanguage.g:841:4: rule__Scenario2_2__ChildAssignment_1_0
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
                    // InternalBug348427TestLanguage.g:845:2: ( ( rule__Scenario2_2__ChildAssignment_1_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:845:2: ( ( rule__Scenario2_2__ChildAssignment_1_1 ) )
                    // InternalBug348427TestLanguage.g:846:3: ( rule__Scenario2_2__ChildAssignment_1_1 )
                    {
                     before(grammarAccess.getScenario2_2Access().getChildAssignment_1_1()); 
                    // InternalBug348427TestLanguage.g:847:3: ( rule__Scenario2_2__ChildAssignment_1_1 )
                    // InternalBug348427TestLanguage.g:847:4: rule__Scenario2_2__ChildAssignment_1_1
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
                    // InternalBug348427TestLanguage.g:851:2: ( ( rule__Scenario2_2__ChildAssignment_1_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:851:2: ( ( rule__Scenario2_2__ChildAssignment_1_2 ) )
                    // InternalBug348427TestLanguage.g:852:3: ( rule__Scenario2_2__ChildAssignment_1_2 )
                    {
                     before(grammarAccess.getScenario2_2Access().getChildAssignment_1_2()); 
                    // InternalBug348427TestLanguage.g:853:3: ( rule__Scenario2_2__ChildAssignment_1_2 )
                    // InternalBug348427TestLanguage.g:853:4: rule__Scenario2_2__ChildAssignment_1_2
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
    // InternalBug348427TestLanguage.g:861:1: rule__Scenario2_3__Alternatives_1 : ( ( ( rule__Scenario2_3__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_3__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_3__ChildAssignment_1_2 ) ) );
    public final void rule__Scenario2_3__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:865:1: ( ( ( rule__Scenario2_3__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_3__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_3__ChildAssignment_1_2 ) ) )
            int alt8=3;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // InternalBug348427TestLanguage.g:866:2: ( ( rule__Scenario2_3__ChildAssignment_1_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:866:2: ( ( rule__Scenario2_3__ChildAssignment_1_0 ) )
                    // InternalBug348427TestLanguage.g:867:3: ( rule__Scenario2_3__ChildAssignment_1_0 )
                    {
                     before(grammarAccess.getScenario2_3Access().getChildAssignment_1_0()); 
                    // InternalBug348427TestLanguage.g:868:3: ( rule__Scenario2_3__ChildAssignment_1_0 )
                    // InternalBug348427TestLanguage.g:868:4: rule__Scenario2_3__ChildAssignment_1_0
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
                    // InternalBug348427TestLanguage.g:872:2: ( ( rule__Scenario2_3__ChildAssignment_1_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:872:2: ( ( rule__Scenario2_3__ChildAssignment_1_1 ) )
                    // InternalBug348427TestLanguage.g:873:3: ( rule__Scenario2_3__ChildAssignment_1_1 )
                    {
                     before(grammarAccess.getScenario2_3Access().getChildAssignment_1_1()); 
                    // InternalBug348427TestLanguage.g:874:3: ( rule__Scenario2_3__ChildAssignment_1_1 )
                    // InternalBug348427TestLanguage.g:874:4: rule__Scenario2_3__ChildAssignment_1_1
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
                    // InternalBug348427TestLanguage.g:878:2: ( ( rule__Scenario2_3__ChildAssignment_1_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:878:2: ( ( rule__Scenario2_3__ChildAssignment_1_2 ) )
                    // InternalBug348427TestLanguage.g:879:3: ( rule__Scenario2_3__ChildAssignment_1_2 )
                    {
                     before(grammarAccess.getScenario2_3Access().getChildAssignment_1_2()); 
                    // InternalBug348427TestLanguage.g:880:3: ( rule__Scenario2_3__ChildAssignment_1_2 )
                    // InternalBug348427TestLanguage.g:880:4: rule__Scenario2_3__ChildAssignment_1_2
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
    // InternalBug348427TestLanguage.g:888:1: rule__Scenario2_4__Alternatives_1 : ( ( ( rule__Scenario2_4__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_4__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_4__ChildAssignment_1_2 ) ) );
    public final void rule__Scenario2_4__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:892:1: ( ( ( rule__Scenario2_4__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_4__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_4__ChildAssignment_1_2 ) ) )
            int alt9=3;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // InternalBug348427TestLanguage.g:893:2: ( ( rule__Scenario2_4__ChildAssignment_1_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:893:2: ( ( rule__Scenario2_4__ChildAssignment_1_0 ) )
                    // InternalBug348427TestLanguage.g:894:3: ( rule__Scenario2_4__ChildAssignment_1_0 )
                    {
                     before(grammarAccess.getScenario2_4Access().getChildAssignment_1_0()); 
                    // InternalBug348427TestLanguage.g:895:3: ( rule__Scenario2_4__ChildAssignment_1_0 )
                    // InternalBug348427TestLanguage.g:895:4: rule__Scenario2_4__ChildAssignment_1_0
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
                    // InternalBug348427TestLanguage.g:899:2: ( ( rule__Scenario2_4__ChildAssignment_1_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:899:2: ( ( rule__Scenario2_4__ChildAssignment_1_1 ) )
                    // InternalBug348427TestLanguage.g:900:3: ( rule__Scenario2_4__ChildAssignment_1_1 )
                    {
                     before(grammarAccess.getScenario2_4Access().getChildAssignment_1_1()); 
                    // InternalBug348427TestLanguage.g:901:3: ( rule__Scenario2_4__ChildAssignment_1_1 )
                    // InternalBug348427TestLanguage.g:901:4: rule__Scenario2_4__ChildAssignment_1_1
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
                    // InternalBug348427TestLanguage.g:905:2: ( ( rule__Scenario2_4__ChildAssignment_1_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:905:2: ( ( rule__Scenario2_4__ChildAssignment_1_2 ) )
                    // InternalBug348427TestLanguage.g:906:3: ( rule__Scenario2_4__ChildAssignment_1_2 )
                    {
                     before(grammarAccess.getScenario2_4Access().getChildAssignment_1_2()); 
                    // InternalBug348427TestLanguage.g:907:3: ( rule__Scenario2_4__ChildAssignment_1_2 )
                    // InternalBug348427TestLanguage.g:907:4: rule__Scenario2_4__ChildAssignment_1_2
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
    // InternalBug348427TestLanguage.g:915:1: rule__Scenario2_5__Alternatives_2 : ( ( ( rule__Scenario2_5__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_5__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_5__ChildAssignment_2_2 ) ) );
    public final void rule__Scenario2_5__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:919:1: ( ( ( rule__Scenario2_5__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_5__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_5__ChildAssignment_2_2 ) ) )
            int alt10=3;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // InternalBug348427TestLanguage.g:920:2: ( ( rule__Scenario2_5__ChildAssignment_2_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:920:2: ( ( rule__Scenario2_5__ChildAssignment_2_0 ) )
                    // InternalBug348427TestLanguage.g:921:3: ( rule__Scenario2_5__ChildAssignment_2_0 )
                    {
                     before(grammarAccess.getScenario2_5Access().getChildAssignment_2_0()); 
                    // InternalBug348427TestLanguage.g:922:3: ( rule__Scenario2_5__ChildAssignment_2_0 )
                    // InternalBug348427TestLanguage.g:922:4: rule__Scenario2_5__ChildAssignment_2_0
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
                    // InternalBug348427TestLanguage.g:926:2: ( ( rule__Scenario2_5__ChildAssignment_2_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:926:2: ( ( rule__Scenario2_5__ChildAssignment_2_1 ) )
                    // InternalBug348427TestLanguage.g:927:3: ( rule__Scenario2_5__ChildAssignment_2_1 )
                    {
                     before(grammarAccess.getScenario2_5Access().getChildAssignment_2_1()); 
                    // InternalBug348427TestLanguage.g:928:3: ( rule__Scenario2_5__ChildAssignment_2_1 )
                    // InternalBug348427TestLanguage.g:928:4: rule__Scenario2_5__ChildAssignment_2_1
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
                    // InternalBug348427TestLanguage.g:932:2: ( ( rule__Scenario2_5__ChildAssignment_2_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:932:2: ( ( rule__Scenario2_5__ChildAssignment_2_2 ) )
                    // InternalBug348427TestLanguage.g:933:3: ( rule__Scenario2_5__ChildAssignment_2_2 )
                    {
                     before(grammarAccess.getScenario2_5Access().getChildAssignment_2_2()); 
                    // InternalBug348427TestLanguage.g:934:3: ( rule__Scenario2_5__ChildAssignment_2_2 )
                    // InternalBug348427TestLanguage.g:934:4: rule__Scenario2_5__ChildAssignment_2_2
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
    // InternalBug348427TestLanguage.g:942:1: rule__Scenario2_6__Alternatives_2 : ( ( ( rule__Scenario2_6__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_6__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_6__ChildAssignment_2_2 ) ) );
    public final void rule__Scenario2_6__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:946:1: ( ( ( rule__Scenario2_6__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_6__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_6__ChildAssignment_2_2 ) ) )
            int alt11=3;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // InternalBug348427TestLanguage.g:947:2: ( ( rule__Scenario2_6__ChildAssignment_2_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:947:2: ( ( rule__Scenario2_6__ChildAssignment_2_0 ) )
                    // InternalBug348427TestLanguage.g:948:3: ( rule__Scenario2_6__ChildAssignment_2_0 )
                    {
                     before(grammarAccess.getScenario2_6Access().getChildAssignment_2_0()); 
                    // InternalBug348427TestLanguage.g:949:3: ( rule__Scenario2_6__ChildAssignment_2_0 )
                    // InternalBug348427TestLanguage.g:949:4: rule__Scenario2_6__ChildAssignment_2_0
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
                    // InternalBug348427TestLanguage.g:953:2: ( ( rule__Scenario2_6__ChildAssignment_2_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:953:2: ( ( rule__Scenario2_6__ChildAssignment_2_1 ) )
                    // InternalBug348427TestLanguage.g:954:3: ( rule__Scenario2_6__ChildAssignment_2_1 )
                    {
                     before(grammarAccess.getScenario2_6Access().getChildAssignment_2_1()); 
                    // InternalBug348427TestLanguage.g:955:3: ( rule__Scenario2_6__ChildAssignment_2_1 )
                    // InternalBug348427TestLanguage.g:955:4: rule__Scenario2_6__ChildAssignment_2_1
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
                    // InternalBug348427TestLanguage.g:959:2: ( ( rule__Scenario2_6__ChildAssignment_2_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:959:2: ( ( rule__Scenario2_6__ChildAssignment_2_2 ) )
                    // InternalBug348427TestLanguage.g:960:3: ( rule__Scenario2_6__ChildAssignment_2_2 )
                    {
                     before(grammarAccess.getScenario2_6Access().getChildAssignment_2_2()); 
                    // InternalBug348427TestLanguage.g:961:3: ( rule__Scenario2_6__ChildAssignment_2_2 )
                    // InternalBug348427TestLanguage.g:961:4: rule__Scenario2_6__ChildAssignment_2_2
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
    // InternalBug348427TestLanguage.g:969:1: rule__Scenario2_7__Alternatives_2 : ( ( ( rule__Scenario2_7__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_7__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_7__ChildAssignment_2_2 ) ) );
    public final void rule__Scenario2_7__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:973:1: ( ( ( rule__Scenario2_7__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_7__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_7__ChildAssignment_2_2 ) ) )
            int alt12=3;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // InternalBug348427TestLanguage.g:974:2: ( ( rule__Scenario2_7__ChildAssignment_2_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:974:2: ( ( rule__Scenario2_7__ChildAssignment_2_0 ) )
                    // InternalBug348427TestLanguage.g:975:3: ( rule__Scenario2_7__ChildAssignment_2_0 )
                    {
                     before(grammarAccess.getScenario2_7Access().getChildAssignment_2_0()); 
                    // InternalBug348427TestLanguage.g:976:3: ( rule__Scenario2_7__ChildAssignment_2_0 )
                    // InternalBug348427TestLanguage.g:976:4: rule__Scenario2_7__ChildAssignment_2_0
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
                    // InternalBug348427TestLanguage.g:980:2: ( ( rule__Scenario2_7__ChildAssignment_2_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:980:2: ( ( rule__Scenario2_7__ChildAssignment_2_1 ) )
                    // InternalBug348427TestLanguage.g:981:3: ( rule__Scenario2_7__ChildAssignment_2_1 )
                    {
                     before(grammarAccess.getScenario2_7Access().getChildAssignment_2_1()); 
                    // InternalBug348427TestLanguage.g:982:3: ( rule__Scenario2_7__ChildAssignment_2_1 )
                    // InternalBug348427TestLanguage.g:982:4: rule__Scenario2_7__ChildAssignment_2_1
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
                    // InternalBug348427TestLanguage.g:986:2: ( ( rule__Scenario2_7__ChildAssignment_2_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:986:2: ( ( rule__Scenario2_7__ChildAssignment_2_2 ) )
                    // InternalBug348427TestLanguage.g:987:3: ( rule__Scenario2_7__ChildAssignment_2_2 )
                    {
                     before(grammarAccess.getScenario2_7Access().getChildAssignment_2_2()); 
                    // InternalBug348427TestLanguage.g:988:3: ( rule__Scenario2_7__ChildAssignment_2_2 )
                    // InternalBug348427TestLanguage.g:988:4: rule__Scenario2_7__ChildAssignment_2_2
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
    // InternalBug348427TestLanguage.g:996:1: rule__Scenario2_8__Alternatives_2 : ( ( ( rule__Scenario2_8__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_8__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_8__ChildAssignment_2_2 ) ) );
    public final void rule__Scenario2_8__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1000:1: ( ( ( rule__Scenario2_8__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_8__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_8__ChildAssignment_2_2 ) ) )
            int alt13=3;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // InternalBug348427TestLanguage.g:1001:2: ( ( rule__Scenario2_8__ChildAssignment_2_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:1001:2: ( ( rule__Scenario2_8__ChildAssignment_2_0 ) )
                    // InternalBug348427TestLanguage.g:1002:3: ( rule__Scenario2_8__ChildAssignment_2_0 )
                    {
                     before(grammarAccess.getScenario2_8Access().getChildAssignment_2_0()); 
                    // InternalBug348427TestLanguage.g:1003:3: ( rule__Scenario2_8__ChildAssignment_2_0 )
                    // InternalBug348427TestLanguage.g:1003:4: rule__Scenario2_8__ChildAssignment_2_0
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
                    // InternalBug348427TestLanguage.g:1007:2: ( ( rule__Scenario2_8__ChildAssignment_2_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:1007:2: ( ( rule__Scenario2_8__ChildAssignment_2_1 ) )
                    // InternalBug348427TestLanguage.g:1008:3: ( rule__Scenario2_8__ChildAssignment_2_1 )
                    {
                     before(grammarAccess.getScenario2_8Access().getChildAssignment_2_1()); 
                    // InternalBug348427TestLanguage.g:1009:3: ( rule__Scenario2_8__ChildAssignment_2_1 )
                    // InternalBug348427TestLanguage.g:1009:4: rule__Scenario2_8__ChildAssignment_2_1
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
                    // InternalBug348427TestLanguage.g:1013:2: ( ( rule__Scenario2_8__ChildAssignment_2_2 ) )
                    {
                    // InternalBug348427TestLanguage.g:1013:2: ( ( rule__Scenario2_8__ChildAssignment_2_2 ) )
                    // InternalBug348427TestLanguage.g:1014:3: ( rule__Scenario2_8__ChildAssignment_2_2 )
                    {
                     before(grammarAccess.getScenario2_8Access().getChildAssignment_2_2()); 
                    // InternalBug348427TestLanguage.g:1015:3: ( rule__Scenario2_8__ChildAssignment_2_2 )
                    // InternalBug348427TestLanguage.g:1015:4: rule__Scenario2_8__ChildAssignment_2_2
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
    // InternalBug348427TestLanguage.g:1023:1: rule__Child2_1__StringAlternatives_3_0 : ( ( 'a' ) | ( 'b' ) );
    public final void rule__Child2_1__StringAlternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1027:1: ( ( 'a' ) | ( 'b' ) )
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
                    // InternalBug348427TestLanguage.g:1028:2: ( 'a' )
                    {
                    // InternalBug348427TestLanguage.g:1028:2: ( 'a' )
                    // InternalBug348427TestLanguage.g:1029:3: 'a'
                    {
                     before(grammarAccess.getChild2_1Access().getStringAKeyword_3_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getChild2_1Access().getStringAKeyword_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug348427TestLanguage.g:1034:2: ( 'b' )
                    {
                    // InternalBug348427TestLanguage.g:1034:2: ( 'b' )
                    // InternalBug348427TestLanguage.g:1035:3: 'b'
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
    // InternalBug348427TestLanguage.g:1044:1: rule__Child2_2__StringAlternatives_3_0 : ( ( 'a' ) | ( 'b' ) );
    public final void rule__Child2_2__StringAlternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1048:1: ( ( 'a' ) | ( 'b' ) )
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
                    // InternalBug348427TestLanguage.g:1049:2: ( 'a' )
                    {
                    // InternalBug348427TestLanguage.g:1049:2: ( 'a' )
                    // InternalBug348427TestLanguage.g:1050:3: 'a'
                    {
                     before(grammarAccess.getChild2_2Access().getStringAKeyword_3_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getChild2_2Access().getStringAKeyword_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug348427TestLanguage.g:1055:2: ( 'b' )
                    {
                    // InternalBug348427TestLanguage.g:1055:2: ( 'b' )
                    // InternalBug348427TestLanguage.g:1056:3: 'b'
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
    // InternalBug348427TestLanguage.g:1065:1: rule__Child2_3__StringAlternatives_3_0 : ( ( 'a' ) | ( 'b' ) );
    public final void rule__Child2_3__StringAlternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1069:1: ( ( 'a' ) | ( 'b' ) )
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
                    // InternalBug348427TestLanguage.g:1070:2: ( 'a' )
                    {
                    // InternalBug348427TestLanguage.g:1070:2: ( 'a' )
                    // InternalBug348427TestLanguage.g:1071:3: 'a'
                    {
                     before(grammarAccess.getChild2_3Access().getStringAKeyword_3_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getChild2_3Access().getStringAKeyword_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug348427TestLanguage.g:1076:2: ( 'b' )
                    {
                    // InternalBug348427TestLanguage.g:1076:2: ( 'b' )
                    // InternalBug348427TestLanguage.g:1077:3: 'b'
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
    // InternalBug348427TestLanguage.g:1086:1: rule__Child2_4__Alternatives_3 : ( ( ( rule__Child2_4__StringAssignment_3_0 ) ) | ( ( rule__Child2_4__StringAssignment_3_1 ) ) );
    public final void rule__Child2_4__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1090:1: ( ( ( rule__Child2_4__StringAssignment_3_0 ) ) | ( ( rule__Child2_4__StringAssignment_3_1 ) ) )
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
                    // InternalBug348427TestLanguage.g:1091:2: ( ( rule__Child2_4__StringAssignment_3_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:1091:2: ( ( rule__Child2_4__StringAssignment_3_0 ) )
                    // InternalBug348427TestLanguage.g:1092:3: ( rule__Child2_4__StringAssignment_3_0 )
                    {
                     before(grammarAccess.getChild2_4Access().getStringAssignment_3_0()); 
                    // InternalBug348427TestLanguage.g:1093:3: ( rule__Child2_4__StringAssignment_3_0 )
                    // InternalBug348427TestLanguage.g:1093:4: rule__Child2_4__StringAssignment_3_0
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
                    // InternalBug348427TestLanguage.g:1097:2: ( ( rule__Child2_4__StringAssignment_3_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:1097:2: ( ( rule__Child2_4__StringAssignment_3_1 ) )
                    // InternalBug348427TestLanguage.g:1098:3: ( rule__Child2_4__StringAssignment_3_1 )
                    {
                     before(grammarAccess.getChild2_4Access().getStringAssignment_3_1()); 
                    // InternalBug348427TestLanguage.g:1099:3: ( rule__Child2_4__StringAssignment_3_1 )
                    // InternalBug348427TestLanguage.g:1099:4: rule__Child2_4__StringAssignment_3_1
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
    // InternalBug348427TestLanguage.g:1107:1: rule__Child2_5__Alternatives_3 : ( ( ( rule__Child2_5__StringAssignment_3_0 ) ) | ( ( rule__Child2_5__StringAssignment_3_1 ) ) );
    public final void rule__Child2_5__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1111:1: ( ( ( rule__Child2_5__StringAssignment_3_0 ) ) | ( ( rule__Child2_5__StringAssignment_3_1 ) ) )
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
                    // InternalBug348427TestLanguage.g:1112:2: ( ( rule__Child2_5__StringAssignment_3_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:1112:2: ( ( rule__Child2_5__StringAssignment_3_0 ) )
                    // InternalBug348427TestLanguage.g:1113:3: ( rule__Child2_5__StringAssignment_3_0 )
                    {
                     before(grammarAccess.getChild2_5Access().getStringAssignment_3_0()); 
                    // InternalBug348427TestLanguage.g:1114:3: ( rule__Child2_5__StringAssignment_3_0 )
                    // InternalBug348427TestLanguage.g:1114:4: rule__Child2_5__StringAssignment_3_0
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
                    // InternalBug348427TestLanguage.g:1118:2: ( ( rule__Child2_5__StringAssignment_3_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:1118:2: ( ( rule__Child2_5__StringAssignment_3_1 ) )
                    // InternalBug348427TestLanguage.g:1119:3: ( rule__Child2_5__StringAssignment_3_1 )
                    {
                     before(grammarAccess.getChild2_5Access().getStringAssignment_3_1()); 
                    // InternalBug348427TestLanguage.g:1120:3: ( rule__Child2_5__StringAssignment_3_1 )
                    // InternalBug348427TestLanguage.g:1120:4: rule__Child2_5__StringAssignment_3_1
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
    // InternalBug348427TestLanguage.g:1128:1: rule__Child2_6__Alternatives_3 : ( ( ( rule__Child2_6__StringAssignment_3_0 ) ) | ( ( rule__Child2_6__StringAssignment_3_1 ) ) );
    public final void rule__Child2_6__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1132:1: ( ( ( rule__Child2_6__StringAssignment_3_0 ) ) | ( ( rule__Child2_6__StringAssignment_3_1 ) ) )
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
                    // InternalBug348427TestLanguage.g:1133:2: ( ( rule__Child2_6__StringAssignment_3_0 ) )
                    {
                    // InternalBug348427TestLanguage.g:1133:2: ( ( rule__Child2_6__StringAssignment_3_0 ) )
                    // InternalBug348427TestLanguage.g:1134:3: ( rule__Child2_6__StringAssignment_3_0 )
                    {
                     before(grammarAccess.getChild2_6Access().getStringAssignment_3_0()); 
                    // InternalBug348427TestLanguage.g:1135:3: ( rule__Child2_6__StringAssignment_3_0 )
                    // InternalBug348427TestLanguage.g:1135:4: rule__Child2_6__StringAssignment_3_0
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
                    // InternalBug348427TestLanguage.g:1139:2: ( ( rule__Child2_6__StringAssignment_3_1 ) )
                    {
                    // InternalBug348427TestLanguage.g:1139:2: ( ( rule__Child2_6__StringAssignment_3_1 ) )
                    // InternalBug348427TestLanguage.g:1140:3: ( rule__Child2_6__StringAssignment_3_1 )
                    {
                     before(grammarAccess.getChild2_6Access().getStringAssignment_3_1()); 
                    // InternalBug348427TestLanguage.g:1141:3: ( rule__Child2_6__StringAssignment_3_1 )
                    // InternalBug348427TestLanguage.g:1141:4: rule__Child2_6__StringAssignment_3_1
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
    // InternalBug348427TestLanguage.g:1149:1: rule__EnumType__Alternatives : ( ( ( 'a' ) ) | ( ( 'b' ) ) );
    public final void rule__EnumType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1153:1: ( ( ( 'a' ) ) | ( ( 'b' ) ) )
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
                    // InternalBug348427TestLanguage.g:1154:2: ( ( 'a' ) )
                    {
                    // InternalBug348427TestLanguage.g:1154:2: ( ( 'a' ) )
                    // InternalBug348427TestLanguage.g:1155:3: ( 'a' )
                    {
                     before(grammarAccess.getEnumTypeAccess().getAEnumLiteralDeclaration_0()); 
                    // InternalBug348427TestLanguage.g:1156:3: ( 'a' )
                    // InternalBug348427TestLanguage.g:1156:4: 'a'
                    {
                    match(input,11,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getEnumTypeAccess().getAEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug348427TestLanguage.g:1160:2: ( ( 'b' ) )
                    {
                    // InternalBug348427TestLanguage.g:1160:2: ( ( 'b' ) )
                    // InternalBug348427TestLanguage.g:1161:3: ( 'b' )
                    {
                     before(grammarAccess.getEnumTypeAccess().getBEnumLiteralDeclaration_1()); 
                    // InternalBug348427TestLanguage.g:1162:3: ( 'b' )
                    // InternalBug348427TestLanguage.g:1162:4: 'b'
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
    // InternalBug348427TestLanguage.g:1170:1: rule__Scenario1_1__Group__0 : rule__Scenario1_1__Group__0__Impl rule__Scenario1_1__Group__1 ;
    public final void rule__Scenario1_1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1174:1: ( rule__Scenario1_1__Group__0__Impl rule__Scenario1_1__Group__1 )
            // InternalBug348427TestLanguage.g:1175:2: rule__Scenario1_1__Group__0__Impl rule__Scenario1_1__Group__1
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
    // InternalBug348427TestLanguage.g:1182:1: rule__Scenario1_1__Group__0__Impl : ( '1.1' ) ;
    public final void rule__Scenario1_1__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1186:1: ( ( '1.1' ) )
            // InternalBug348427TestLanguage.g:1187:1: ( '1.1' )
            {
            // InternalBug348427TestLanguage.g:1187:1: ( '1.1' )
            // InternalBug348427TestLanguage.g:1188:2: '1.1'
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
    // InternalBug348427TestLanguage.g:1197:1: rule__Scenario1_1__Group__1 : rule__Scenario1_1__Group__1__Impl rule__Scenario1_1__Group__2 ;
    public final void rule__Scenario1_1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1201:1: ( rule__Scenario1_1__Group__1__Impl rule__Scenario1_1__Group__2 )
            // InternalBug348427TestLanguage.g:1202:2: rule__Scenario1_1__Group__1__Impl rule__Scenario1_1__Group__2
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
    // InternalBug348427TestLanguage.g:1209:1: rule__Scenario1_1__Group__1__Impl : ( ( rule__Scenario1_1__Alternatives_1 ) ) ;
    public final void rule__Scenario1_1__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1213:1: ( ( ( rule__Scenario1_1__Alternatives_1 ) ) )
            // InternalBug348427TestLanguage.g:1214:1: ( ( rule__Scenario1_1__Alternatives_1 ) )
            {
            // InternalBug348427TestLanguage.g:1214:1: ( ( rule__Scenario1_1__Alternatives_1 ) )
            // InternalBug348427TestLanguage.g:1215:2: ( rule__Scenario1_1__Alternatives_1 )
            {
             before(grammarAccess.getScenario1_1Access().getAlternatives_1()); 
            // InternalBug348427TestLanguage.g:1216:2: ( rule__Scenario1_1__Alternatives_1 )
            // InternalBug348427TestLanguage.g:1216:3: rule__Scenario1_1__Alternatives_1
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
    // InternalBug348427TestLanguage.g:1224:1: rule__Scenario1_1__Group__2 : rule__Scenario1_1__Group__2__Impl ;
    public final void rule__Scenario1_1__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1228:1: ( rule__Scenario1_1__Group__2__Impl )
            // InternalBug348427TestLanguage.g:1229:2: rule__Scenario1_1__Group__2__Impl
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
    // InternalBug348427TestLanguage.g:1235:1: rule__Scenario1_1__Group__2__Impl : ( 'next' ) ;
    public final void rule__Scenario1_1__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1239:1: ( ( 'next' ) )
            // InternalBug348427TestLanguage.g:1240:1: ( 'next' )
            {
            // InternalBug348427TestLanguage.g:1240:1: ( 'next' )
            // InternalBug348427TestLanguage.g:1241:2: 'next'
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
    // InternalBug348427TestLanguage.g:1251:1: rule__Scenario1_2__Group__0 : rule__Scenario1_2__Group__0__Impl rule__Scenario1_2__Group__1 ;
    public final void rule__Scenario1_2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1255:1: ( rule__Scenario1_2__Group__0__Impl rule__Scenario1_2__Group__1 )
            // InternalBug348427TestLanguage.g:1256:2: rule__Scenario1_2__Group__0__Impl rule__Scenario1_2__Group__1
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
    // InternalBug348427TestLanguage.g:1263:1: rule__Scenario1_2__Group__0__Impl : ( '1.2' ) ;
    public final void rule__Scenario1_2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1267:1: ( ( '1.2' ) )
            // InternalBug348427TestLanguage.g:1268:1: ( '1.2' )
            {
            // InternalBug348427TestLanguage.g:1268:1: ( '1.2' )
            // InternalBug348427TestLanguage.g:1269:2: '1.2'
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
    // InternalBug348427TestLanguage.g:1278:1: rule__Scenario1_2__Group__1 : rule__Scenario1_2__Group__1__Impl rule__Scenario1_2__Group__2 ;
    public final void rule__Scenario1_2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1282:1: ( rule__Scenario1_2__Group__1__Impl rule__Scenario1_2__Group__2 )
            // InternalBug348427TestLanguage.g:1283:2: rule__Scenario1_2__Group__1__Impl rule__Scenario1_2__Group__2
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
    // InternalBug348427TestLanguage.g:1290:1: rule__Scenario1_2__Group__1__Impl : ( ( ( rule__Scenario1_2__Alternatives_1 ) ) ( ( rule__Scenario1_2__Alternatives_1 )* ) ) ;
    public final void rule__Scenario1_2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1294:1: ( ( ( ( rule__Scenario1_2__Alternatives_1 ) ) ( ( rule__Scenario1_2__Alternatives_1 )* ) ) )
            // InternalBug348427TestLanguage.g:1295:1: ( ( ( rule__Scenario1_2__Alternatives_1 ) ) ( ( rule__Scenario1_2__Alternatives_1 )* ) )
            {
            // InternalBug348427TestLanguage.g:1295:1: ( ( ( rule__Scenario1_2__Alternatives_1 ) ) ( ( rule__Scenario1_2__Alternatives_1 )* ) )
            // InternalBug348427TestLanguage.g:1296:2: ( ( rule__Scenario1_2__Alternatives_1 ) ) ( ( rule__Scenario1_2__Alternatives_1 )* )
            {
            // InternalBug348427TestLanguage.g:1296:2: ( ( rule__Scenario1_2__Alternatives_1 ) )
            // InternalBug348427TestLanguage.g:1297:3: ( rule__Scenario1_2__Alternatives_1 )
            {
             before(grammarAccess.getScenario1_2Access().getAlternatives_1()); 
            // InternalBug348427TestLanguage.g:1298:3: ( rule__Scenario1_2__Alternatives_1 )
            // InternalBug348427TestLanguage.g:1298:4: rule__Scenario1_2__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Scenario1_2__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getScenario1_2Access().getAlternatives_1()); 

            }

            // InternalBug348427TestLanguage.g:1301:2: ( ( rule__Scenario1_2__Alternatives_1 )* )
            // InternalBug348427TestLanguage.g:1302:3: ( rule__Scenario1_2__Alternatives_1 )*
            {
             before(grammarAccess.getScenario1_2Access().getAlternatives_1()); 
            // InternalBug348427TestLanguage.g:1303:3: ( rule__Scenario1_2__Alternatives_1 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_ID) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalBug348427TestLanguage.g:1303:4: rule__Scenario1_2__Alternatives_1
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
    // InternalBug348427TestLanguage.g:1312:1: rule__Scenario1_2__Group__2 : rule__Scenario1_2__Group__2__Impl ;
    public final void rule__Scenario1_2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1316:1: ( rule__Scenario1_2__Group__2__Impl )
            // InternalBug348427TestLanguage.g:1317:2: rule__Scenario1_2__Group__2__Impl
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
    // InternalBug348427TestLanguage.g:1323:1: rule__Scenario1_2__Group__2__Impl : ( 'next' ) ;
    public final void rule__Scenario1_2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1327:1: ( ( 'next' ) )
            // InternalBug348427TestLanguage.g:1328:1: ( 'next' )
            {
            // InternalBug348427TestLanguage.g:1328:1: ( 'next' )
            // InternalBug348427TestLanguage.g:1329:2: 'next'
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
    // InternalBug348427TestLanguage.g:1339:1: rule__Scenario1_3__Group__0 : rule__Scenario1_3__Group__0__Impl rule__Scenario1_3__Group__1 ;
    public final void rule__Scenario1_3__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1343:1: ( rule__Scenario1_3__Group__0__Impl rule__Scenario1_3__Group__1 )
            // InternalBug348427TestLanguage.g:1344:2: rule__Scenario1_3__Group__0__Impl rule__Scenario1_3__Group__1
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
    // InternalBug348427TestLanguage.g:1351:1: rule__Scenario1_3__Group__0__Impl : ( () ) ;
    public final void rule__Scenario1_3__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1355:1: ( ( () ) )
            // InternalBug348427TestLanguage.g:1356:1: ( () )
            {
            // InternalBug348427TestLanguage.g:1356:1: ( () )
            // InternalBug348427TestLanguage.g:1357:2: ()
            {
             before(grammarAccess.getScenario1_3Access().getScenario1Action_0()); 
            // InternalBug348427TestLanguage.g:1358:2: ()
            // InternalBug348427TestLanguage.g:1358:3: 
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
    // InternalBug348427TestLanguage.g:1366:1: rule__Scenario1_3__Group__1 : rule__Scenario1_3__Group__1__Impl rule__Scenario1_3__Group__2 ;
    public final void rule__Scenario1_3__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1370:1: ( rule__Scenario1_3__Group__1__Impl rule__Scenario1_3__Group__2 )
            // InternalBug348427TestLanguage.g:1371:2: rule__Scenario1_3__Group__1__Impl rule__Scenario1_3__Group__2
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
    // InternalBug348427TestLanguage.g:1378:1: rule__Scenario1_3__Group__1__Impl : ( '1.3' ) ;
    public final void rule__Scenario1_3__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1382:1: ( ( '1.3' ) )
            // InternalBug348427TestLanguage.g:1383:1: ( '1.3' )
            {
            // InternalBug348427TestLanguage.g:1383:1: ( '1.3' )
            // InternalBug348427TestLanguage.g:1384:2: '1.3'
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
    // InternalBug348427TestLanguage.g:1393:1: rule__Scenario1_3__Group__2 : rule__Scenario1_3__Group__2__Impl rule__Scenario1_3__Group__3 ;
    public final void rule__Scenario1_3__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1397:1: ( rule__Scenario1_3__Group__2__Impl rule__Scenario1_3__Group__3 )
            // InternalBug348427TestLanguage.g:1398:2: rule__Scenario1_3__Group__2__Impl rule__Scenario1_3__Group__3
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
    // InternalBug348427TestLanguage.g:1405:1: rule__Scenario1_3__Group__2__Impl : ( ( rule__Scenario1_3__Alternatives_2 )* ) ;
    public final void rule__Scenario1_3__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1409:1: ( ( ( rule__Scenario1_3__Alternatives_2 )* ) )
            // InternalBug348427TestLanguage.g:1410:1: ( ( rule__Scenario1_3__Alternatives_2 )* )
            {
            // InternalBug348427TestLanguage.g:1410:1: ( ( rule__Scenario1_3__Alternatives_2 )* )
            // InternalBug348427TestLanguage.g:1411:2: ( rule__Scenario1_3__Alternatives_2 )*
            {
             before(grammarAccess.getScenario1_3Access().getAlternatives_2()); 
            // InternalBug348427TestLanguage.g:1412:2: ( rule__Scenario1_3__Alternatives_2 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_ID) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalBug348427TestLanguage.g:1412:3: rule__Scenario1_3__Alternatives_2
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
    // InternalBug348427TestLanguage.g:1420:1: rule__Scenario1_3__Group__3 : rule__Scenario1_3__Group__3__Impl ;
    public final void rule__Scenario1_3__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1424:1: ( rule__Scenario1_3__Group__3__Impl )
            // InternalBug348427TestLanguage.g:1425:2: rule__Scenario1_3__Group__3__Impl
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
    // InternalBug348427TestLanguage.g:1431:1: rule__Scenario1_3__Group__3__Impl : ( 'next' ) ;
    public final void rule__Scenario1_3__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1435:1: ( ( 'next' ) )
            // InternalBug348427TestLanguage.g:1436:1: ( 'next' )
            {
            // InternalBug348427TestLanguage.g:1436:1: ( 'next' )
            // InternalBug348427TestLanguage.g:1437:2: 'next'
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
    // InternalBug348427TestLanguage.g:1447:1: rule__Scenario1_4__Group__0 : rule__Scenario1_4__Group__0__Impl rule__Scenario1_4__Group__1 ;
    public final void rule__Scenario1_4__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1451:1: ( rule__Scenario1_4__Group__0__Impl rule__Scenario1_4__Group__1 )
            // InternalBug348427TestLanguage.g:1452:2: rule__Scenario1_4__Group__0__Impl rule__Scenario1_4__Group__1
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
    // InternalBug348427TestLanguage.g:1459:1: rule__Scenario1_4__Group__0__Impl : ( () ) ;
    public final void rule__Scenario1_4__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1463:1: ( ( () ) )
            // InternalBug348427TestLanguage.g:1464:1: ( () )
            {
            // InternalBug348427TestLanguage.g:1464:1: ( () )
            // InternalBug348427TestLanguage.g:1465:2: ()
            {
             before(grammarAccess.getScenario1_4Access().getScenario1Action_0()); 
            // InternalBug348427TestLanguage.g:1466:2: ()
            // InternalBug348427TestLanguage.g:1466:3: 
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
    // InternalBug348427TestLanguage.g:1474:1: rule__Scenario1_4__Group__1 : rule__Scenario1_4__Group__1__Impl rule__Scenario1_4__Group__2 ;
    public final void rule__Scenario1_4__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1478:1: ( rule__Scenario1_4__Group__1__Impl rule__Scenario1_4__Group__2 )
            // InternalBug348427TestLanguage.g:1479:2: rule__Scenario1_4__Group__1__Impl rule__Scenario1_4__Group__2
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
    // InternalBug348427TestLanguage.g:1486:1: rule__Scenario1_4__Group__1__Impl : ( '1.4' ) ;
    public final void rule__Scenario1_4__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1490:1: ( ( '1.4' ) )
            // InternalBug348427TestLanguage.g:1491:1: ( '1.4' )
            {
            // InternalBug348427TestLanguage.g:1491:1: ( '1.4' )
            // InternalBug348427TestLanguage.g:1492:2: '1.4'
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
    // InternalBug348427TestLanguage.g:1501:1: rule__Scenario1_4__Group__2 : rule__Scenario1_4__Group__2__Impl rule__Scenario1_4__Group__3 ;
    public final void rule__Scenario1_4__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1505:1: ( rule__Scenario1_4__Group__2__Impl rule__Scenario1_4__Group__3 )
            // InternalBug348427TestLanguage.g:1506:2: rule__Scenario1_4__Group__2__Impl rule__Scenario1_4__Group__3
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
    // InternalBug348427TestLanguage.g:1513:1: rule__Scenario1_4__Group__2__Impl : ( ( rule__Scenario1_4__Alternatives_2 )? ) ;
    public final void rule__Scenario1_4__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1517:1: ( ( ( rule__Scenario1_4__Alternatives_2 )? ) )
            // InternalBug348427TestLanguage.g:1518:1: ( ( rule__Scenario1_4__Alternatives_2 )? )
            {
            // InternalBug348427TestLanguage.g:1518:1: ( ( rule__Scenario1_4__Alternatives_2 )? )
            // InternalBug348427TestLanguage.g:1519:2: ( rule__Scenario1_4__Alternatives_2 )?
            {
             before(grammarAccess.getScenario1_4Access().getAlternatives_2()); 
            // InternalBug348427TestLanguage.g:1520:2: ( rule__Scenario1_4__Alternatives_2 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_ID) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalBug348427TestLanguage.g:1520:3: rule__Scenario1_4__Alternatives_2
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
    // InternalBug348427TestLanguage.g:1528:1: rule__Scenario1_4__Group__3 : rule__Scenario1_4__Group__3__Impl ;
    public final void rule__Scenario1_4__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1532:1: ( rule__Scenario1_4__Group__3__Impl )
            // InternalBug348427TestLanguage.g:1533:2: rule__Scenario1_4__Group__3__Impl
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
    // InternalBug348427TestLanguage.g:1539:1: rule__Scenario1_4__Group__3__Impl : ( 'next' ) ;
    public final void rule__Scenario1_4__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1543:1: ( ( 'next' ) )
            // InternalBug348427TestLanguage.g:1544:1: ( 'next' )
            {
            // InternalBug348427TestLanguage.g:1544:1: ( 'next' )
            // InternalBug348427TestLanguage.g:1545:2: 'next'
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
    // InternalBug348427TestLanguage.g:1555:1: rule__Child1_1__Group__0 : rule__Child1_1__Group__0__Impl rule__Child1_1__Group__1 ;
    public final void rule__Child1_1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1559:1: ( rule__Child1_1__Group__0__Impl rule__Child1_1__Group__1 )
            // InternalBug348427TestLanguage.g:1560:2: rule__Child1_1__Group__0__Impl rule__Child1_1__Group__1
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
    // InternalBug348427TestLanguage.g:1567:1: rule__Child1_1__Group__0__Impl : ( ( rule__Child1_1__NameAssignment_0 ) ) ;
    public final void rule__Child1_1__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1571:1: ( ( ( rule__Child1_1__NameAssignment_0 ) ) )
            // InternalBug348427TestLanguage.g:1572:1: ( ( rule__Child1_1__NameAssignment_0 ) )
            {
            // InternalBug348427TestLanguage.g:1572:1: ( ( rule__Child1_1__NameAssignment_0 ) )
            // InternalBug348427TestLanguage.g:1573:2: ( rule__Child1_1__NameAssignment_0 )
            {
             before(grammarAccess.getChild1_1Access().getNameAssignment_0()); 
            // InternalBug348427TestLanguage.g:1574:2: ( rule__Child1_1__NameAssignment_0 )
            // InternalBug348427TestLanguage.g:1574:3: rule__Child1_1__NameAssignment_0
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
    // InternalBug348427TestLanguage.g:1582:1: rule__Child1_1__Group__1 : rule__Child1_1__Group__1__Impl rule__Child1_1__Group__2 ;
    public final void rule__Child1_1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1586:1: ( rule__Child1_1__Group__1__Impl rule__Child1_1__Group__2 )
            // InternalBug348427TestLanguage.g:1587:2: rule__Child1_1__Group__1__Impl rule__Child1_1__Group__2
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
    // InternalBug348427TestLanguage.g:1594:1: rule__Child1_1__Group__1__Impl : ( ':' ) ;
    public final void rule__Child1_1__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1598:1: ( ( ':' ) )
            // InternalBug348427TestLanguage.g:1599:1: ( ':' )
            {
            // InternalBug348427TestLanguage.g:1599:1: ( ':' )
            // InternalBug348427TestLanguage.g:1600:2: ':'
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
    // InternalBug348427TestLanguage.g:1609:1: rule__Child1_1__Group__2 : rule__Child1_1__Group__2__Impl rule__Child1_1__Group__3 ;
    public final void rule__Child1_1__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1613:1: ( rule__Child1_1__Group__2__Impl rule__Child1_1__Group__3 )
            // InternalBug348427TestLanguage.g:1614:2: rule__Child1_1__Group__2__Impl rule__Child1_1__Group__3
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
    // InternalBug348427TestLanguage.g:1621:1: rule__Child1_1__Group__2__Impl : ( ( rule__Child1_1__Group_2__0 )? ) ;
    public final void rule__Child1_1__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1625:1: ( ( ( rule__Child1_1__Group_2__0 )? ) )
            // InternalBug348427TestLanguage.g:1626:1: ( ( rule__Child1_1__Group_2__0 )? )
            {
            // InternalBug348427TestLanguage.g:1626:1: ( ( rule__Child1_1__Group_2__0 )? )
            // InternalBug348427TestLanguage.g:1627:2: ( rule__Child1_1__Group_2__0 )?
            {
             before(grammarAccess.getChild1_1Access().getGroup_2()); 
            // InternalBug348427TestLanguage.g:1628:2: ( rule__Child1_1__Group_2__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==32) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalBug348427TestLanguage.g:1628:3: rule__Child1_1__Group_2__0
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
    // InternalBug348427TestLanguage.g:1636:1: rule__Child1_1__Group__3 : rule__Child1_1__Group__3__Impl rule__Child1_1__Group__4 ;
    public final void rule__Child1_1__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1640:1: ( rule__Child1_1__Group__3__Impl rule__Child1_1__Group__4 )
            // InternalBug348427TestLanguage.g:1641:2: rule__Child1_1__Group__3__Impl rule__Child1_1__Group__4
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
    // InternalBug348427TestLanguage.g:1648:1: rule__Child1_1__Group__3__Impl : ( ( rule__Child1_1__EnumTypeAssignment_3 ) ) ;
    public final void rule__Child1_1__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1652:1: ( ( ( rule__Child1_1__EnumTypeAssignment_3 ) ) )
            // InternalBug348427TestLanguage.g:1653:1: ( ( rule__Child1_1__EnumTypeAssignment_3 ) )
            {
            // InternalBug348427TestLanguage.g:1653:1: ( ( rule__Child1_1__EnumTypeAssignment_3 ) )
            // InternalBug348427TestLanguage.g:1654:2: ( rule__Child1_1__EnumTypeAssignment_3 )
            {
             before(grammarAccess.getChild1_1Access().getEnumTypeAssignment_3()); 
            // InternalBug348427TestLanguage.g:1655:2: ( rule__Child1_1__EnumTypeAssignment_3 )
            // InternalBug348427TestLanguage.g:1655:3: rule__Child1_1__EnumTypeAssignment_3
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
    // InternalBug348427TestLanguage.g:1663:1: rule__Child1_1__Group__4 : rule__Child1_1__Group__4__Impl rule__Child1_1__Group__5 ;
    public final void rule__Child1_1__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1667:1: ( rule__Child1_1__Group__4__Impl rule__Child1_1__Group__5 )
            // InternalBug348427TestLanguage.g:1668:2: rule__Child1_1__Group__4__Impl rule__Child1_1__Group__5
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
    // InternalBug348427TestLanguage.g:1675:1: rule__Child1_1__Group__4__Impl : ( 'child1' ) ;
    public final void rule__Child1_1__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1679:1: ( ( 'child1' ) )
            // InternalBug348427TestLanguage.g:1680:1: ( 'child1' )
            {
            // InternalBug348427TestLanguage.g:1680:1: ( 'child1' )
            // InternalBug348427TestLanguage.g:1681:2: 'child1'
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
    // InternalBug348427TestLanguage.g:1690:1: rule__Child1_1__Group__5 : rule__Child1_1__Group__5__Impl ;
    public final void rule__Child1_1__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1694:1: ( rule__Child1_1__Group__5__Impl )
            // InternalBug348427TestLanguage.g:1695:2: rule__Child1_1__Group__5__Impl
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
    // InternalBug348427TestLanguage.g:1701:1: rule__Child1_1__Group__5__Impl : ( 'end' ) ;
    public final void rule__Child1_1__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1705:1: ( ( 'end' ) )
            // InternalBug348427TestLanguage.g:1706:1: ( 'end' )
            {
            // InternalBug348427TestLanguage.g:1706:1: ( 'end' )
            // InternalBug348427TestLanguage.g:1707:2: 'end'
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
    // InternalBug348427TestLanguage.g:1717:1: rule__Child1_1__Group_2__0 : rule__Child1_1__Group_2__0__Impl rule__Child1_1__Group_2__1 ;
    public final void rule__Child1_1__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1721:1: ( rule__Child1_1__Group_2__0__Impl rule__Child1_1__Group_2__1 )
            // InternalBug348427TestLanguage.g:1722:2: rule__Child1_1__Group_2__0__Impl rule__Child1_1__Group_2__1
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
    // InternalBug348427TestLanguage.g:1729:1: rule__Child1_1__Group_2__0__Impl : ( ( rule__Child1_1__BoolAssignment_2_0 ) ) ;
    public final void rule__Child1_1__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1733:1: ( ( ( rule__Child1_1__BoolAssignment_2_0 ) ) )
            // InternalBug348427TestLanguage.g:1734:1: ( ( rule__Child1_1__BoolAssignment_2_0 ) )
            {
            // InternalBug348427TestLanguage.g:1734:1: ( ( rule__Child1_1__BoolAssignment_2_0 ) )
            // InternalBug348427TestLanguage.g:1735:2: ( rule__Child1_1__BoolAssignment_2_0 )
            {
             before(grammarAccess.getChild1_1Access().getBoolAssignment_2_0()); 
            // InternalBug348427TestLanguage.g:1736:2: ( rule__Child1_1__BoolAssignment_2_0 )
            // InternalBug348427TestLanguage.g:1736:3: rule__Child1_1__BoolAssignment_2_0
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
    // InternalBug348427TestLanguage.g:1744:1: rule__Child1_1__Group_2__1 : rule__Child1_1__Group_2__1__Impl ;
    public final void rule__Child1_1__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1748:1: ( rule__Child1_1__Group_2__1__Impl )
            // InternalBug348427TestLanguage.g:1749:2: rule__Child1_1__Group_2__1__Impl
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
    // InternalBug348427TestLanguage.g:1755:1: rule__Child1_1__Group_2__1__Impl : ( 'keyword' ) ;
    public final void rule__Child1_1__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1759:1: ( ( 'keyword' ) )
            // InternalBug348427TestLanguage.g:1760:1: ( 'keyword' )
            {
            // InternalBug348427TestLanguage.g:1760:1: ( 'keyword' )
            // InternalBug348427TestLanguage.g:1761:2: 'keyword'
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
    // InternalBug348427TestLanguage.g:1771:1: rule__Child1_2__Group__0 : rule__Child1_2__Group__0__Impl rule__Child1_2__Group__1 ;
    public final void rule__Child1_2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1775:1: ( rule__Child1_2__Group__0__Impl rule__Child1_2__Group__1 )
            // InternalBug348427TestLanguage.g:1776:2: rule__Child1_2__Group__0__Impl rule__Child1_2__Group__1
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
    // InternalBug348427TestLanguage.g:1783:1: rule__Child1_2__Group__0__Impl : ( ( rule__Child1_2__NameAssignment_0 ) ) ;
    public final void rule__Child1_2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1787:1: ( ( ( rule__Child1_2__NameAssignment_0 ) ) )
            // InternalBug348427TestLanguage.g:1788:1: ( ( rule__Child1_2__NameAssignment_0 ) )
            {
            // InternalBug348427TestLanguage.g:1788:1: ( ( rule__Child1_2__NameAssignment_0 ) )
            // InternalBug348427TestLanguage.g:1789:2: ( rule__Child1_2__NameAssignment_0 )
            {
             before(grammarAccess.getChild1_2Access().getNameAssignment_0()); 
            // InternalBug348427TestLanguage.g:1790:2: ( rule__Child1_2__NameAssignment_0 )
            // InternalBug348427TestLanguage.g:1790:3: rule__Child1_2__NameAssignment_0
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
    // InternalBug348427TestLanguage.g:1798:1: rule__Child1_2__Group__1 : rule__Child1_2__Group__1__Impl rule__Child1_2__Group__2 ;
    public final void rule__Child1_2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1802:1: ( rule__Child1_2__Group__1__Impl rule__Child1_2__Group__2 )
            // InternalBug348427TestLanguage.g:1803:2: rule__Child1_2__Group__1__Impl rule__Child1_2__Group__2
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
    // InternalBug348427TestLanguage.g:1810:1: rule__Child1_2__Group__1__Impl : ( ':' ) ;
    public final void rule__Child1_2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1814:1: ( ( ':' ) )
            // InternalBug348427TestLanguage.g:1815:1: ( ':' )
            {
            // InternalBug348427TestLanguage.g:1815:1: ( ':' )
            // InternalBug348427TestLanguage.g:1816:2: ':'
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
    // InternalBug348427TestLanguage.g:1825:1: rule__Child1_2__Group__2 : rule__Child1_2__Group__2__Impl rule__Child1_2__Group__3 ;
    public final void rule__Child1_2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1829:1: ( rule__Child1_2__Group__2__Impl rule__Child1_2__Group__3 )
            // InternalBug348427TestLanguage.g:1830:2: rule__Child1_2__Group__2__Impl rule__Child1_2__Group__3
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
    // InternalBug348427TestLanguage.g:1837:1: rule__Child1_2__Group__2__Impl : ( ( rule__Child1_2__Group_2__0 )? ) ;
    public final void rule__Child1_2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1841:1: ( ( ( rule__Child1_2__Group_2__0 )? ) )
            // InternalBug348427TestLanguage.g:1842:1: ( ( rule__Child1_2__Group_2__0 )? )
            {
            // InternalBug348427TestLanguage.g:1842:1: ( ( rule__Child1_2__Group_2__0 )? )
            // InternalBug348427TestLanguage.g:1843:2: ( rule__Child1_2__Group_2__0 )?
            {
             before(grammarAccess.getChild1_2Access().getGroup_2()); 
            // InternalBug348427TestLanguage.g:1844:2: ( rule__Child1_2__Group_2__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==32) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalBug348427TestLanguage.g:1844:3: rule__Child1_2__Group_2__0
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
    // InternalBug348427TestLanguage.g:1852:1: rule__Child1_2__Group__3 : rule__Child1_2__Group__3__Impl rule__Child1_2__Group__4 ;
    public final void rule__Child1_2__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1856:1: ( rule__Child1_2__Group__3__Impl rule__Child1_2__Group__4 )
            // InternalBug348427TestLanguage.g:1857:2: rule__Child1_2__Group__3__Impl rule__Child1_2__Group__4
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
    // InternalBug348427TestLanguage.g:1864:1: rule__Child1_2__Group__3__Impl : ( ( rule__Child1_2__EnumTypeAssignment_3 ) ) ;
    public final void rule__Child1_2__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1868:1: ( ( ( rule__Child1_2__EnumTypeAssignment_3 ) ) )
            // InternalBug348427TestLanguage.g:1869:1: ( ( rule__Child1_2__EnumTypeAssignment_3 ) )
            {
            // InternalBug348427TestLanguage.g:1869:1: ( ( rule__Child1_2__EnumTypeAssignment_3 ) )
            // InternalBug348427TestLanguage.g:1870:2: ( rule__Child1_2__EnumTypeAssignment_3 )
            {
             before(grammarAccess.getChild1_2Access().getEnumTypeAssignment_3()); 
            // InternalBug348427TestLanguage.g:1871:2: ( rule__Child1_2__EnumTypeAssignment_3 )
            // InternalBug348427TestLanguage.g:1871:3: rule__Child1_2__EnumTypeAssignment_3
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
    // InternalBug348427TestLanguage.g:1879:1: rule__Child1_2__Group__4 : rule__Child1_2__Group__4__Impl rule__Child1_2__Group__5 ;
    public final void rule__Child1_2__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1883:1: ( rule__Child1_2__Group__4__Impl rule__Child1_2__Group__5 )
            // InternalBug348427TestLanguage.g:1884:2: rule__Child1_2__Group__4__Impl rule__Child1_2__Group__5
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
    // InternalBug348427TestLanguage.g:1891:1: rule__Child1_2__Group__4__Impl : ( 'child2' ) ;
    public final void rule__Child1_2__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1895:1: ( ( 'child2' ) )
            // InternalBug348427TestLanguage.g:1896:1: ( 'child2' )
            {
            // InternalBug348427TestLanguage.g:1896:1: ( 'child2' )
            // InternalBug348427TestLanguage.g:1897:2: 'child2'
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
    // InternalBug348427TestLanguage.g:1906:1: rule__Child1_2__Group__5 : rule__Child1_2__Group__5__Impl ;
    public final void rule__Child1_2__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1910:1: ( rule__Child1_2__Group__5__Impl )
            // InternalBug348427TestLanguage.g:1911:2: rule__Child1_2__Group__5__Impl
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
    // InternalBug348427TestLanguage.g:1917:1: rule__Child1_2__Group__5__Impl : ( 'end' ) ;
    public final void rule__Child1_2__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1921:1: ( ( 'end' ) )
            // InternalBug348427TestLanguage.g:1922:1: ( 'end' )
            {
            // InternalBug348427TestLanguage.g:1922:1: ( 'end' )
            // InternalBug348427TestLanguage.g:1923:2: 'end'
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
    // InternalBug348427TestLanguage.g:1933:1: rule__Child1_2__Group_2__0 : rule__Child1_2__Group_2__0__Impl rule__Child1_2__Group_2__1 ;
    public final void rule__Child1_2__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1937:1: ( rule__Child1_2__Group_2__0__Impl rule__Child1_2__Group_2__1 )
            // InternalBug348427TestLanguage.g:1938:2: rule__Child1_2__Group_2__0__Impl rule__Child1_2__Group_2__1
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
    // InternalBug348427TestLanguage.g:1945:1: rule__Child1_2__Group_2__0__Impl : ( ( rule__Child1_2__BoolAssignment_2_0 ) ) ;
    public final void rule__Child1_2__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1949:1: ( ( ( rule__Child1_2__BoolAssignment_2_0 ) ) )
            // InternalBug348427TestLanguage.g:1950:1: ( ( rule__Child1_2__BoolAssignment_2_0 ) )
            {
            // InternalBug348427TestLanguage.g:1950:1: ( ( rule__Child1_2__BoolAssignment_2_0 ) )
            // InternalBug348427TestLanguage.g:1951:2: ( rule__Child1_2__BoolAssignment_2_0 )
            {
             before(grammarAccess.getChild1_2Access().getBoolAssignment_2_0()); 
            // InternalBug348427TestLanguage.g:1952:2: ( rule__Child1_2__BoolAssignment_2_0 )
            // InternalBug348427TestLanguage.g:1952:3: rule__Child1_2__BoolAssignment_2_0
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
    // InternalBug348427TestLanguage.g:1960:1: rule__Child1_2__Group_2__1 : rule__Child1_2__Group_2__1__Impl ;
    public final void rule__Child1_2__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1964:1: ( rule__Child1_2__Group_2__1__Impl )
            // InternalBug348427TestLanguage.g:1965:2: rule__Child1_2__Group_2__1__Impl
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
    // InternalBug348427TestLanguage.g:1971:1: rule__Child1_2__Group_2__1__Impl : ( 'keyword' ) ;
    public final void rule__Child1_2__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1975:1: ( ( 'keyword' ) )
            // InternalBug348427TestLanguage.g:1976:1: ( 'keyword' )
            {
            // InternalBug348427TestLanguage.g:1976:1: ( 'keyword' )
            // InternalBug348427TestLanguage.g:1977:2: 'keyword'
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
    // InternalBug348427TestLanguage.g:1987:1: rule__Child1_3__Group__0 : rule__Child1_3__Group__0__Impl rule__Child1_3__Group__1 ;
    public final void rule__Child1_3__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:1991:1: ( rule__Child1_3__Group__0__Impl rule__Child1_3__Group__1 )
            // InternalBug348427TestLanguage.g:1992:2: rule__Child1_3__Group__0__Impl rule__Child1_3__Group__1
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
    // InternalBug348427TestLanguage.g:1999:1: rule__Child1_3__Group__0__Impl : ( ( rule__Child1_3__NameAssignment_0 ) ) ;
    public final void rule__Child1_3__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2003:1: ( ( ( rule__Child1_3__NameAssignment_0 ) ) )
            // InternalBug348427TestLanguage.g:2004:1: ( ( rule__Child1_3__NameAssignment_0 ) )
            {
            // InternalBug348427TestLanguage.g:2004:1: ( ( rule__Child1_3__NameAssignment_0 ) )
            // InternalBug348427TestLanguage.g:2005:2: ( rule__Child1_3__NameAssignment_0 )
            {
             before(grammarAccess.getChild1_3Access().getNameAssignment_0()); 
            // InternalBug348427TestLanguage.g:2006:2: ( rule__Child1_3__NameAssignment_0 )
            // InternalBug348427TestLanguage.g:2006:3: rule__Child1_3__NameAssignment_0
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
    // InternalBug348427TestLanguage.g:2014:1: rule__Child1_3__Group__1 : rule__Child1_3__Group__1__Impl rule__Child1_3__Group__2 ;
    public final void rule__Child1_3__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2018:1: ( rule__Child1_3__Group__1__Impl rule__Child1_3__Group__2 )
            // InternalBug348427TestLanguage.g:2019:2: rule__Child1_3__Group__1__Impl rule__Child1_3__Group__2
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
    // InternalBug348427TestLanguage.g:2026:1: rule__Child1_3__Group__1__Impl : ( ':' ) ;
    public final void rule__Child1_3__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2030:1: ( ( ':' ) )
            // InternalBug348427TestLanguage.g:2031:1: ( ':' )
            {
            // InternalBug348427TestLanguage.g:2031:1: ( ':' )
            // InternalBug348427TestLanguage.g:2032:2: ':'
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
    // InternalBug348427TestLanguage.g:2041:1: rule__Child1_3__Group__2 : rule__Child1_3__Group__2__Impl rule__Child1_3__Group__3 ;
    public final void rule__Child1_3__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2045:1: ( rule__Child1_3__Group__2__Impl rule__Child1_3__Group__3 )
            // InternalBug348427TestLanguage.g:2046:2: rule__Child1_3__Group__2__Impl rule__Child1_3__Group__3
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
    // InternalBug348427TestLanguage.g:2053:1: rule__Child1_3__Group__2__Impl : ( ( rule__Child1_3__Group_2__0 )? ) ;
    public final void rule__Child1_3__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2057:1: ( ( ( rule__Child1_3__Group_2__0 )? ) )
            // InternalBug348427TestLanguage.g:2058:1: ( ( rule__Child1_3__Group_2__0 )? )
            {
            // InternalBug348427TestLanguage.g:2058:1: ( ( rule__Child1_3__Group_2__0 )? )
            // InternalBug348427TestLanguage.g:2059:2: ( rule__Child1_3__Group_2__0 )?
            {
             before(grammarAccess.getChild1_3Access().getGroup_2()); 
            // InternalBug348427TestLanguage.g:2060:2: ( rule__Child1_3__Group_2__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==32) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalBug348427TestLanguage.g:2060:3: rule__Child1_3__Group_2__0
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
    // InternalBug348427TestLanguage.g:2068:1: rule__Child1_3__Group__3 : rule__Child1_3__Group__3__Impl rule__Child1_3__Group__4 ;
    public final void rule__Child1_3__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2072:1: ( rule__Child1_3__Group__3__Impl rule__Child1_3__Group__4 )
            // InternalBug348427TestLanguage.g:2073:2: rule__Child1_3__Group__3__Impl rule__Child1_3__Group__4
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
    // InternalBug348427TestLanguage.g:2080:1: rule__Child1_3__Group__3__Impl : ( ( rule__Child1_3__EnumTypeAssignment_3 ) ) ;
    public final void rule__Child1_3__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2084:1: ( ( ( rule__Child1_3__EnumTypeAssignment_3 ) ) )
            // InternalBug348427TestLanguage.g:2085:1: ( ( rule__Child1_3__EnumTypeAssignment_3 ) )
            {
            // InternalBug348427TestLanguage.g:2085:1: ( ( rule__Child1_3__EnumTypeAssignment_3 ) )
            // InternalBug348427TestLanguage.g:2086:2: ( rule__Child1_3__EnumTypeAssignment_3 )
            {
             before(grammarAccess.getChild1_3Access().getEnumTypeAssignment_3()); 
            // InternalBug348427TestLanguage.g:2087:2: ( rule__Child1_3__EnumTypeAssignment_3 )
            // InternalBug348427TestLanguage.g:2087:3: rule__Child1_3__EnumTypeAssignment_3
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
    // InternalBug348427TestLanguage.g:2095:1: rule__Child1_3__Group__4 : rule__Child1_3__Group__4__Impl rule__Child1_3__Group__5 ;
    public final void rule__Child1_3__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2099:1: ( rule__Child1_3__Group__4__Impl rule__Child1_3__Group__5 )
            // InternalBug348427TestLanguage.g:2100:2: rule__Child1_3__Group__4__Impl rule__Child1_3__Group__5
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
    // InternalBug348427TestLanguage.g:2107:1: rule__Child1_3__Group__4__Impl : ( 'child3' ) ;
    public final void rule__Child1_3__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2111:1: ( ( 'child3' ) )
            // InternalBug348427TestLanguage.g:2112:1: ( 'child3' )
            {
            // InternalBug348427TestLanguage.g:2112:1: ( 'child3' )
            // InternalBug348427TestLanguage.g:2113:2: 'child3'
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
    // InternalBug348427TestLanguage.g:2122:1: rule__Child1_3__Group__5 : rule__Child1_3__Group__5__Impl ;
    public final void rule__Child1_3__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2126:1: ( rule__Child1_3__Group__5__Impl )
            // InternalBug348427TestLanguage.g:2127:2: rule__Child1_3__Group__5__Impl
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
    // InternalBug348427TestLanguage.g:2133:1: rule__Child1_3__Group__5__Impl : ( 'end' ) ;
    public final void rule__Child1_3__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2137:1: ( ( 'end' ) )
            // InternalBug348427TestLanguage.g:2138:1: ( 'end' )
            {
            // InternalBug348427TestLanguage.g:2138:1: ( 'end' )
            // InternalBug348427TestLanguage.g:2139:2: 'end'
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
    // InternalBug348427TestLanguage.g:2149:1: rule__Child1_3__Group_2__0 : rule__Child1_3__Group_2__0__Impl rule__Child1_3__Group_2__1 ;
    public final void rule__Child1_3__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2153:1: ( rule__Child1_3__Group_2__0__Impl rule__Child1_3__Group_2__1 )
            // InternalBug348427TestLanguage.g:2154:2: rule__Child1_3__Group_2__0__Impl rule__Child1_3__Group_2__1
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
    // InternalBug348427TestLanguage.g:2161:1: rule__Child1_3__Group_2__0__Impl : ( ( rule__Child1_3__BoolAssignment_2_0 ) ) ;
    public final void rule__Child1_3__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2165:1: ( ( ( rule__Child1_3__BoolAssignment_2_0 ) ) )
            // InternalBug348427TestLanguage.g:2166:1: ( ( rule__Child1_3__BoolAssignment_2_0 ) )
            {
            // InternalBug348427TestLanguage.g:2166:1: ( ( rule__Child1_3__BoolAssignment_2_0 ) )
            // InternalBug348427TestLanguage.g:2167:2: ( rule__Child1_3__BoolAssignment_2_0 )
            {
             before(grammarAccess.getChild1_3Access().getBoolAssignment_2_0()); 
            // InternalBug348427TestLanguage.g:2168:2: ( rule__Child1_3__BoolAssignment_2_0 )
            // InternalBug348427TestLanguage.g:2168:3: rule__Child1_3__BoolAssignment_2_0
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
    // InternalBug348427TestLanguage.g:2176:1: rule__Child1_3__Group_2__1 : rule__Child1_3__Group_2__1__Impl ;
    public final void rule__Child1_3__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2180:1: ( rule__Child1_3__Group_2__1__Impl )
            // InternalBug348427TestLanguage.g:2181:2: rule__Child1_3__Group_2__1__Impl
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
    // InternalBug348427TestLanguage.g:2187:1: rule__Child1_3__Group_2__1__Impl : ( 'keyword' ) ;
    public final void rule__Child1_3__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2191:1: ( ( 'keyword' ) )
            // InternalBug348427TestLanguage.g:2192:1: ( 'keyword' )
            {
            // InternalBug348427TestLanguage.g:2192:1: ( 'keyword' )
            // InternalBug348427TestLanguage.g:2193:2: 'keyword'
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
    // InternalBug348427TestLanguage.g:2203:1: rule__Scenario2_1__Group__0 : rule__Scenario2_1__Group__0__Impl rule__Scenario2_1__Group__1 ;
    public final void rule__Scenario2_1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2207:1: ( rule__Scenario2_1__Group__0__Impl rule__Scenario2_1__Group__1 )
            // InternalBug348427TestLanguage.g:2208:2: rule__Scenario2_1__Group__0__Impl rule__Scenario2_1__Group__1
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
    // InternalBug348427TestLanguage.g:2215:1: rule__Scenario2_1__Group__0__Impl : ( '2.1' ) ;
    public final void rule__Scenario2_1__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2219:1: ( ( '2.1' ) )
            // InternalBug348427TestLanguage.g:2220:1: ( '2.1' )
            {
            // InternalBug348427TestLanguage.g:2220:1: ( '2.1' )
            // InternalBug348427TestLanguage.g:2221:2: '2.1'
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
    // InternalBug348427TestLanguage.g:2230:1: rule__Scenario2_1__Group__1 : rule__Scenario2_1__Group__1__Impl rule__Scenario2_1__Group__2 ;
    public final void rule__Scenario2_1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2234:1: ( rule__Scenario2_1__Group__1__Impl rule__Scenario2_1__Group__2 )
            // InternalBug348427TestLanguage.g:2235:2: rule__Scenario2_1__Group__1__Impl rule__Scenario2_1__Group__2
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
    // InternalBug348427TestLanguage.g:2242:1: rule__Scenario2_1__Group__1__Impl : ( ( rule__Scenario2_1__Alternatives_1 ) ) ;
    public final void rule__Scenario2_1__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2246:1: ( ( ( rule__Scenario2_1__Alternatives_1 ) ) )
            // InternalBug348427TestLanguage.g:2247:1: ( ( rule__Scenario2_1__Alternatives_1 ) )
            {
            // InternalBug348427TestLanguage.g:2247:1: ( ( rule__Scenario2_1__Alternatives_1 ) )
            // InternalBug348427TestLanguage.g:2248:2: ( rule__Scenario2_1__Alternatives_1 )
            {
             before(grammarAccess.getScenario2_1Access().getAlternatives_1()); 
            // InternalBug348427TestLanguage.g:2249:2: ( rule__Scenario2_1__Alternatives_1 )
            // InternalBug348427TestLanguage.g:2249:3: rule__Scenario2_1__Alternatives_1
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
    // InternalBug348427TestLanguage.g:2257:1: rule__Scenario2_1__Group__2 : rule__Scenario2_1__Group__2__Impl ;
    public final void rule__Scenario2_1__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2261:1: ( rule__Scenario2_1__Group__2__Impl )
            // InternalBug348427TestLanguage.g:2262:2: rule__Scenario2_1__Group__2__Impl
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
    // InternalBug348427TestLanguage.g:2268:1: rule__Scenario2_1__Group__2__Impl : ( 'next' ) ;
    public final void rule__Scenario2_1__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2272:1: ( ( 'next' ) )
            // InternalBug348427TestLanguage.g:2273:1: ( 'next' )
            {
            // InternalBug348427TestLanguage.g:2273:1: ( 'next' )
            // InternalBug348427TestLanguage.g:2274:2: 'next'
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
    // InternalBug348427TestLanguage.g:2284:1: rule__Scenario2_2__Group__0 : rule__Scenario2_2__Group__0__Impl rule__Scenario2_2__Group__1 ;
    public final void rule__Scenario2_2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2288:1: ( rule__Scenario2_2__Group__0__Impl rule__Scenario2_2__Group__1 )
            // InternalBug348427TestLanguage.g:2289:2: rule__Scenario2_2__Group__0__Impl rule__Scenario2_2__Group__1
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
    // InternalBug348427TestLanguage.g:2296:1: rule__Scenario2_2__Group__0__Impl : ( '2.2' ) ;
    public final void rule__Scenario2_2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2300:1: ( ( '2.2' ) )
            // InternalBug348427TestLanguage.g:2301:1: ( '2.2' )
            {
            // InternalBug348427TestLanguage.g:2301:1: ( '2.2' )
            // InternalBug348427TestLanguage.g:2302:2: '2.2'
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
    // InternalBug348427TestLanguage.g:2311:1: rule__Scenario2_2__Group__1 : rule__Scenario2_2__Group__1__Impl rule__Scenario2_2__Group__2 ;
    public final void rule__Scenario2_2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2315:1: ( rule__Scenario2_2__Group__1__Impl rule__Scenario2_2__Group__2 )
            // InternalBug348427TestLanguage.g:2316:2: rule__Scenario2_2__Group__1__Impl rule__Scenario2_2__Group__2
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
    // InternalBug348427TestLanguage.g:2323:1: rule__Scenario2_2__Group__1__Impl : ( ( ( rule__Scenario2_2__Alternatives_1 ) ) ( ( rule__Scenario2_2__Alternatives_1 )* ) ) ;
    public final void rule__Scenario2_2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2327:1: ( ( ( ( rule__Scenario2_2__Alternatives_1 ) ) ( ( rule__Scenario2_2__Alternatives_1 )* ) ) )
            // InternalBug348427TestLanguage.g:2328:1: ( ( ( rule__Scenario2_2__Alternatives_1 ) ) ( ( rule__Scenario2_2__Alternatives_1 )* ) )
            {
            // InternalBug348427TestLanguage.g:2328:1: ( ( ( rule__Scenario2_2__Alternatives_1 ) ) ( ( rule__Scenario2_2__Alternatives_1 )* ) )
            // InternalBug348427TestLanguage.g:2329:2: ( ( rule__Scenario2_2__Alternatives_1 ) ) ( ( rule__Scenario2_2__Alternatives_1 )* )
            {
            // InternalBug348427TestLanguage.g:2329:2: ( ( rule__Scenario2_2__Alternatives_1 ) )
            // InternalBug348427TestLanguage.g:2330:3: ( rule__Scenario2_2__Alternatives_1 )
            {
             before(grammarAccess.getScenario2_2Access().getAlternatives_1()); 
            // InternalBug348427TestLanguage.g:2331:3: ( rule__Scenario2_2__Alternatives_1 )
            // InternalBug348427TestLanguage.g:2331:4: rule__Scenario2_2__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Scenario2_2__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getScenario2_2Access().getAlternatives_1()); 

            }

            // InternalBug348427TestLanguage.g:2334:2: ( ( rule__Scenario2_2__Alternatives_1 )* )
            // InternalBug348427TestLanguage.g:2335:3: ( rule__Scenario2_2__Alternatives_1 )*
            {
             before(grammarAccess.getScenario2_2Access().getAlternatives_1()); 
            // InternalBug348427TestLanguage.g:2336:3: ( rule__Scenario2_2__Alternatives_1 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_ID) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalBug348427TestLanguage.g:2336:4: rule__Scenario2_2__Alternatives_1
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
    // InternalBug348427TestLanguage.g:2345:1: rule__Scenario2_2__Group__2 : rule__Scenario2_2__Group__2__Impl ;
    public final void rule__Scenario2_2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2349:1: ( rule__Scenario2_2__Group__2__Impl )
            // InternalBug348427TestLanguage.g:2350:2: rule__Scenario2_2__Group__2__Impl
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
    // InternalBug348427TestLanguage.g:2356:1: rule__Scenario2_2__Group__2__Impl : ( 'next' ) ;
    public final void rule__Scenario2_2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2360:1: ( ( 'next' ) )
            // InternalBug348427TestLanguage.g:2361:1: ( 'next' )
            {
            // InternalBug348427TestLanguage.g:2361:1: ( 'next' )
            // InternalBug348427TestLanguage.g:2362:2: 'next'
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
    // InternalBug348427TestLanguage.g:2372:1: rule__Scenario2_3__Group__0 : rule__Scenario2_3__Group__0__Impl rule__Scenario2_3__Group__1 ;
    public final void rule__Scenario2_3__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2376:1: ( rule__Scenario2_3__Group__0__Impl rule__Scenario2_3__Group__1 )
            // InternalBug348427TestLanguage.g:2377:2: rule__Scenario2_3__Group__0__Impl rule__Scenario2_3__Group__1
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
    // InternalBug348427TestLanguage.g:2384:1: rule__Scenario2_3__Group__0__Impl : ( '2.3' ) ;
    public final void rule__Scenario2_3__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2388:1: ( ( '2.3' ) )
            // InternalBug348427TestLanguage.g:2389:1: ( '2.3' )
            {
            // InternalBug348427TestLanguage.g:2389:1: ( '2.3' )
            // InternalBug348427TestLanguage.g:2390:2: '2.3'
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
    // InternalBug348427TestLanguage.g:2399:1: rule__Scenario2_3__Group__1 : rule__Scenario2_3__Group__1__Impl rule__Scenario2_3__Group__2 ;
    public final void rule__Scenario2_3__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2403:1: ( rule__Scenario2_3__Group__1__Impl rule__Scenario2_3__Group__2 )
            // InternalBug348427TestLanguage.g:2404:2: rule__Scenario2_3__Group__1__Impl rule__Scenario2_3__Group__2
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
    // InternalBug348427TestLanguage.g:2411:1: rule__Scenario2_3__Group__1__Impl : ( ( rule__Scenario2_3__Alternatives_1 ) ) ;
    public final void rule__Scenario2_3__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2415:1: ( ( ( rule__Scenario2_3__Alternatives_1 ) ) )
            // InternalBug348427TestLanguage.g:2416:1: ( ( rule__Scenario2_3__Alternatives_1 ) )
            {
            // InternalBug348427TestLanguage.g:2416:1: ( ( rule__Scenario2_3__Alternatives_1 ) )
            // InternalBug348427TestLanguage.g:2417:2: ( rule__Scenario2_3__Alternatives_1 )
            {
             before(grammarAccess.getScenario2_3Access().getAlternatives_1()); 
            // InternalBug348427TestLanguage.g:2418:2: ( rule__Scenario2_3__Alternatives_1 )
            // InternalBug348427TestLanguage.g:2418:3: rule__Scenario2_3__Alternatives_1
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
    // InternalBug348427TestLanguage.g:2426:1: rule__Scenario2_3__Group__2 : rule__Scenario2_3__Group__2__Impl ;
    public final void rule__Scenario2_3__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2430:1: ( rule__Scenario2_3__Group__2__Impl )
            // InternalBug348427TestLanguage.g:2431:2: rule__Scenario2_3__Group__2__Impl
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
    // InternalBug348427TestLanguage.g:2437:1: rule__Scenario2_3__Group__2__Impl : ( 'next' ) ;
    public final void rule__Scenario2_3__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2441:1: ( ( 'next' ) )
            // InternalBug348427TestLanguage.g:2442:1: ( 'next' )
            {
            // InternalBug348427TestLanguage.g:2442:1: ( 'next' )
            // InternalBug348427TestLanguage.g:2443:2: 'next'
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
    // InternalBug348427TestLanguage.g:2453:1: rule__Scenario2_4__Group__0 : rule__Scenario2_4__Group__0__Impl rule__Scenario2_4__Group__1 ;
    public final void rule__Scenario2_4__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2457:1: ( rule__Scenario2_4__Group__0__Impl rule__Scenario2_4__Group__1 )
            // InternalBug348427TestLanguage.g:2458:2: rule__Scenario2_4__Group__0__Impl rule__Scenario2_4__Group__1
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
    // InternalBug348427TestLanguage.g:2465:1: rule__Scenario2_4__Group__0__Impl : ( '2.4' ) ;
    public final void rule__Scenario2_4__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2469:1: ( ( '2.4' ) )
            // InternalBug348427TestLanguage.g:2470:1: ( '2.4' )
            {
            // InternalBug348427TestLanguage.g:2470:1: ( '2.4' )
            // InternalBug348427TestLanguage.g:2471:2: '2.4'
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
    // InternalBug348427TestLanguage.g:2480:1: rule__Scenario2_4__Group__1 : rule__Scenario2_4__Group__1__Impl rule__Scenario2_4__Group__2 ;
    public final void rule__Scenario2_4__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2484:1: ( rule__Scenario2_4__Group__1__Impl rule__Scenario2_4__Group__2 )
            // InternalBug348427TestLanguage.g:2485:2: rule__Scenario2_4__Group__1__Impl rule__Scenario2_4__Group__2
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
    // InternalBug348427TestLanguage.g:2492:1: rule__Scenario2_4__Group__1__Impl : ( ( ( rule__Scenario2_4__Alternatives_1 ) ) ( ( rule__Scenario2_4__Alternatives_1 )* ) ) ;
    public final void rule__Scenario2_4__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2496:1: ( ( ( ( rule__Scenario2_4__Alternatives_1 ) ) ( ( rule__Scenario2_4__Alternatives_1 )* ) ) )
            // InternalBug348427TestLanguage.g:2497:1: ( ( ( rule__Scenario2_4__Alternatives_1 ) ) ( ( rule__Scenario2_4__Alternatives_1 )* ) )
            {
            // InternalBug348427TestLanguage.g:2497:1: ( ( ( rule__Scenario2_4__Alternatives_1 ) ) ( ( rule__Scenario2_4__Alternatives_1 )* ) )
            // InternalBug348427TestLanguage.g:2498:2: ( ( rule__Scenario2_4__Alternatives_1 ) ) ( ( rule__Scenario2_4__Alternatives_1 )* )
            {
            // InternalBug348427TestLanguage.g:2498:2: ( ( rule__Scenario2_4__Alternatives_1 ) )
            // InternalBug348427TestLanguage.g:2499:3: ( rule__Scenario2_4__Alternatives_1 )
            {
             before(grammarAccess.getScenario2_4Access().getAlternatives_1()); 
            // InternalBug348427TestLanguage.g:2500:3: ( rule__Scenario2_4__Alternatives_1 )
            // InternalBug348427TestLanguage.g:2500:4: rule__Scenario2_4__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Scenario2_4__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getScenario2_4Access().getAlternatives_1()); 

            }

            // InternalBug348427TestLanguage.g:2503:2: ( ( rule__Scenario2_4__Alternatives_1 )* )
            // InternalBug348427TestLanguage.g:2504:3: ( rule__Scenario2_4__Alternatives_1 )*
            {
             before(grammarAccess.getScenario2_4Access().getAlternatives_1()); 
            // InternalBug348427TestLanguage.g:2505:3: ( rule__Scenario2_4__Alternatives_1 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_ID) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalBug348427TestLanguage.g:2505:4: rule__Scenario2_4__Alternatives_1
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
    // InternalBug348427TestLanguage.g:2514:1: rule__Scenario2_4__Group__2 : rule__Scenario2_4__Group__2__Impl ;
    public final void rule__Scenario2_4__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2518:1: ( rule__Scenario2_4__Group__2__Impl )
            // InternalBug348427TestLanguage.g:2519:2: rule__Scenario2_4__Group__2__Impl
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
    // InternalBug348427TestLanguage.g:2525:1: rule__Scenario2_4__Group__2__Impl : ( 'next' ) ;
    public final void rule__Scenario2_4__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2529:1: ( ( 'next' ) )
            // InternalBug348427TestLanguage.g:2530:1: ( 'next' )
            {
            // InternalBug348427TestLanguage.g:2530:1: ( 'next' )
            // InternalBug348427TestLanguage.g:2531:2: 'next'
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
    // InternalBug348427TestLanguage.g:2541:1: rule__Scenario2_5__Group__0 : rule__Scenario2_5__Group__0__Impl rule__Scenario2_5__Group__1 ;
    public final void rule__Scenario2_5__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2545:1: ( rule__Scenario2_5__Group__0__Impl rule__Scenario2_5__Group__1 )
            // InternalBug348427TestLanguage.g:2546:2: rule__Scenario2_5__Group__0__Impl rule__Scenario2_5__Group__1
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
    // InternalBug348427TestLanguage.g:2553:1: rule__Scenario2_5__Group__0__Impl : ( () ) ;
    public final void rule__Scenario2_5__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2557:1: ( ( () ) )
            // InternalBug348427TestLanguage.g:2558:1: ( () )
            {
            // InternalBug348427TestLanguage.g:2558:1: ( () )
            // InternalBug348427TestLanguage.g:2559:2: ()
            {
             before(grammarAccess.getScenario2_5Access().getScenario2Action_0()); 
            // InternalBug348427TestLanguage.g:2560:2: ()
            // InternalBug348427TestLanguage.g:2560:3: 
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
    // InternalBug348427TestLanguage.g:2568:1: rule__Scenario2_5__Group__1 : rule__Scenario2_5__Group__1__Impl rule__Scenario2_5__Group__2 ;
    public final void rule__Scenario2_5__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2572:1: ( rule__Scenario2_5__Group__1__Impl rule__Scenario2_5__Group__2 )
            // InternalBug348427TestLanguage.g:2573:2: rule__Scenario2_5__Group__1__Impl rule__Scenario2_5__Group__2
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
    // InternalBug348427TestLanguage.g:2580:1: rule__Scenario2_5__Group__1__Impl : ( '2.5' ) ;
    public final void rule__Scenario2_5__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2584:1: ( ( '2.5' ) )
            // InternalBug348427TestLanguage.g:2585:1: ( '2.5' )
            {
            // InternalBug348427TestLanguage.g:2585:1: ( '2.5' )
            // InternalBug348427TestLanguage.g:2586:2: '2.5'
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
    // InternalBug348427TestLanguage.g:2595:1: rule__Scenario2_5__Group__2 : rule__Scenario2_5__Group__2__Impl rule__Scenario2_5__Group__3 ;
    public final void rule__Scenario2_5__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2599:1: ( rule__Scenario2_5__Group__2__Impl rule__Scenario2_5__Group__3 )
            // InternalBug348427TestLanguage.g:2600:2: rule__Scenario2_5__Group__2__Impl rule__Scenario2_5__Group__3
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
    // InternalBug348427TestLanguage.g:2607:1: rule__Scenario2_5__Group__2__Impl : ( ( rule__Scenario2_5__Alternatives_2 )? ) ;
    public final void rule__Scenario2_5__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2611:1: ( ( ( rule__Scenario2_5__Alternatives_2 )? ) )
            // InternalBug348427TestLanguage.g:2612:1: ( ( rule__Scenario2_5__Alternatives_2 )? )
            {
            // InternalBug348427TestLanguage.g:2612:1: ( ( rule__Scenario2_5__Alternatives_2 )? )
            // InternalBug348427TestLanguage.g:2613:2: ( rule__Scenario2_5__Alternatives_2 )?
            {
             before(grammarAccess.getScenario2_5Access().getAlternatives_2()); 
            // InternalBug348427TestLanguage.g:2614:2: ( rule__Scenario2_5__Alternatives_2 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_ID) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalBug348427TestLanguage.g:2614:3: rule__Scenario2_5__Alternatives_2
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
    // InternalBug348427TestLanguage.g:2622:1: rule__Scenario2_5__Group__3 : rule__Scenario2_5__Group__3__Impl ;
    public final void rule__Scenario2_5__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2626:1: ( rule__Scenario2_5__Group__3__Impl )
            // InternalBug348427TestLanguage.g:2627:2: rule__Scenario2_5__Group__3__Impl
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
    // InternalBug348427TestLanguage.g:2633:1: rule__Scenario2_5__Group__3__Impl : ( 'next' ) ;
    public final void rule__Scenario2_5__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2637:1: ( ( 'next' ) )
            // InternalBug348427TestLanguage.g:2638:1: ( 'next' )
            {
            // InternalBug348427TestLanguage.g:2638:1: ( 'next' )
            // InternalBug348427TestLanguage.g:2639:2: 'next'
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
    // InternalBug348427TestLanguage.g:2649:1: rule__Scenario2_6__Group__0 : rule__Scenario2_6__Group__0__Impl rule__Scenario2_6__Group__1 ;
    public final void rule__Scenario2_6__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2653:1: ( rule__Scenario2_6__Group__0__Impl rule__Scenario2_6__Group__1 )
            // InternalBug348427TestLanguage.g:2654:2: rule__Scenario2_6__Group__0__Impl rule__Scenario2_6__Group__1
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
    // InternalBug348427TestLanguage.g:2661:1: rule__Scenario2_6__Group__0__Impl : ( () ) ;
    public final void rule__Scenario2_6__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2665:1: ( ( () ) )
            // InternalBug348427TestLanguage.g:2666:1: ( () )
            {
            // InternalBug348427TestLanguage.g:2666:1: ( () )
            // InternalBug348427TestLanguage.g:2667:2: ()
            {
             before(grammarAccess.getScenario2_6Access().getScenario2Action_0()); 
            // InternalBug348427TestLanguage.g:2668:2: ()
            // InternalBug348427TestLanguage.g:2668:3: 
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
    // InternalBug348427TestLanguage.g:2676:1: rule__Scenario2_6__Group__1 : rule__Scenario2_6__Group__1__Impl rule__Scenario2_6__Group__2 ;
    public final void rule__Scenario2_6__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2680:1: ( rule__Scenario2_6__Group__1__Impl rule__Scenario2_6__Group__2 )
            // InternalBug348427TestLanguage.g:2681:2: rule__Scenario2_6__Group__1__Impl rule__Scenario2_6__Group__2
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
    // InternalBug348427TestLanguage.g:2688:1: rule__Scenario2_6__Group__1__Impl : ( '2.6' ) ;
    public final void rule__Scenario2_6__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2692:1: ( ( '2.6' ) )
            // InternalBug348427TestLanguage.g:2693:1: ( '2.6' )
            {
            // InternalBug348427TestLanguage.g:2693:1: ( '2.6' )
            // InternalBug348427TestLanguage.g:2694:2: '2.6'
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
    // InternalBug348427TestLanguage.g:2703:1: rule__Scenario2_6__Group__2 : rule__Scenario2_6__Group__2__Impl rule__Scenario2_6__Group__3 ;
    public final void rule__Scenario2_6__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2707:1: ( rule__Scenario2_6__Group__2__Impl rule__Scenario2_6__Group__3 )
            // InternalBug348427TestLanguage.g:2708:2: rule__Scenario2_6__Group__2__Impl rule__Scenario2_6__Group__3
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
    // InternalBug348427TestLanguage.g:2715:1: rule__Scenario2_6__Group__2__Impl : ( ( rule__Scenario2_6__Alternatives_2 )* ) ;
    public final void rule__Scenario2_6__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2719:1: ( ( ( rule__Scenario2_6__Alternatives_2 )* ) )
            // InternalBug348427TestLanguage.g:2720:1: ( ( rule__Scenario2_6__Alternatives_2 )* )
            {
            // InternalBug348427TestLanguage.g:2720:1: ( ( rule__Scenario2_6__Alternatives_2 )* )
            // InternalBug348427TestLanguage.g:2721:2: ( rule__Scenario2_6__Alternatives_2 )*
            {
             before(grammarAccess.getScenario2_6Access().getAlternatives_2()); 
            // InternalBug348427TestLanguage.g:2722:2: ( rule__Scenario2_6__Alternatives_2 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_ID) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalBug348427TestLanguage.g:2722:3: rule__Scenario2_6__Alternatives_2
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
    // InternalBug348427TestLanguage.g:2730:1: rule__Scenario2_6__Group__3 : rule__Scenario2_6__Group__3__Impl ;
    public final void rule__Scenario2_6__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2734:1: ( rule__Scenario2_6__Group__3__Impl )
            // InternalBug348427TestLanguage.g:2735:2: rule__Scenario2_6__Group__3__Impl
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
    // InternalBug348427TestLanguage.g:2741:1: rule__Scenario2_6__Group__3__Impl : ( 'next' ) ;
    public final void rule__Scenario2_6__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2745:1: ( ( 'next' ) )
            // InternalBug348427TestLanguage.g:2746:1: ( 'next' )
            {
            // InternalBug348427TestLanguage.g:2746:1: ( 'next' )
            // InternalBug348427TestLanguage.g:2747:2: 'next'
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
    // InternalBug348427TestLanguage.g:2757:1: rule__Scenario2_7__Group__0 : rule__Scenario2_7__Group__0__Impl rule__Scenario2_7__Group__1 ;
    public final void rule__Scenario2_7__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2761:1: ( rule__Scenario2_7__Group__0__Impl rule__Scenario2_7__Group__1 )
            // InternalBug348427TestLanguage.g:2762:2: rule__Scenario2_7__Group__0__Impl rule__Scenario2_7__Group__1
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
    // InternalBug348427TestLanguage.g:2769:1: rule__Scenario2_7__Group__0__Impl : ( () ) ;
    public final void rule__Scenario2_7__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2773:1: ( ( () ) )
            // InternalBug348427TestLanguage.g:2774:1: ( () )
            {
            // InternalBug348427TestLanguage.g:2774:1: ( () )
            // InternalBug348427TestLanguage.g:2775:2: ()
            {
             before(grammarAccess.getScenario2_7Access().getScenario2Action_0()); 
            // InternalBug348427TestLanguage.g:2776:2: ()
            // InternalBug348427TestLanguage.g:2776:3: 
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
    // InternalBug348427TestLanguage.g:2784:1: rule__Scenario2_7__Group__1 : rule__Scenario2_7__Group__1__Impl rule__Scenario2_7__Group__2 ;
    public final void rule__Scenario2_7__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2788:1: ( rule__Scenario2_7__Group__1__Impl rule__Scenario2_7__Group__2 )
            // InternalBug348427TestLanguage.g:2789:2: rule__Scenario2_7__Group__1__Impl rule__Scenario2_7__Group__2
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
    // InternalBug348427TestLanguage.g:2796:1: rule__Scenario2_7__Group__1__Impl : ( '2.7' ) ;
    public final void rule__Scenario2_7__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2800:1: ( ( '2.7' ) )
            // InternalBug348427TestLanguage.g:2801:1: ( '2.7' )
            {
            // InternalBug348427TestLanguage.g:2801:1: ( '2.7' )
            // InternalBug348427TestLanguage.g:2802:2: '2.7'
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
    // InternalBug348427TestLanguage.g:2811:1: rule__Scenario2_7__Group__2 : rule__Scenario2_7__Group__2__Impl rule__Scenario2_7__Group__3 ;
    public final void rule__Scenario2_7__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2815:1: ( rule__Scenario2_7__Group__2__Impl rule__Scenario2_7__Group__3 )
            // InternalBug348427TestLanguage.g:2816:2: rule__Scenario2_7__Group__2__Impl rule__Scenario2_7__Group__3
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
    // InternalBug348427TestLanguage.g:2823:1: rule__Scenario2_7__Group__2__Impl : ( ( rule__Scenario2_7__Alternatives_2 )? ) ;
    public final void rule__Scenario2_7__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2827:1: ( ( ( rule__Scenario2_7__Alternatives_2 )? ) )
            // InternalBug348427TestLanguage.g:2828:1: ( ( rule__Scenario2_7__Alternatives_2 )? )
            {
            // InternalBug348427TestLanguage.g:2828:1: ( ( rule__Scenario2_7__Alternatives_2 )? )
            // InternalBug348427TestLanguage.g:2829:2: ( rule__Scenario2_7__Alternatives_2 )?
            {
             before(grammarAccess.getScenario2_7Access().getAlternatives_2()); 
            // InternalBug348427TestLanguage.g:2830:2: ( rule__Scenario2_7__Alternatives_2 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_ID) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalBug348427TestLanguage.g:2830:3: rule__Scenario2_7__Alternatives_2
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
    // InternalBug348427TestLanguage.g:2838:1: rule__Scenario2_7__Group__3 : rule__Scenario2_7__Group__3__Impl ;
    public final void rule__Scenario2_7__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2842:1: ( rule__Scenario2_7__Group__3__Impl )
            // InternalBug348427TestLanguage.g:2843:2: rule__Scenario2_7__Group__3__Impl
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
    // InternalBug348427TestLanguage.g:2849:1: rule__Scenario2_7__Group__3__Impl : ( 'next' ) ;
    public final void rule__Scenario2_7__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2853:1: ( ( 'next' ) )
            // InternalBug348427TestLanguage.g:2854:1: ( 'next' )
            {
            // InternalBug348427TestLanguage.g:2854:1: ( 'next' )
            // InternalBug348427TestLanguage.g:2855:2: 'next'
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
    // InternalBug348427TestLanguage.g:2865:1: rule__Scenario2_8__Group__0 : rule__Scenario2_8__Group__0__Impl rule__Scenario2_8__Group__1 ;
    public final void rule__Scenario2_8__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2869:1: ( rule__Scenario2_8__Group__0__Impl rule__Scenario2_8__Group__1 )
            // InternalBug348427TestLanguage.g:2870:2: rule__Scenario2_8__Group__0__Impl rule__Scenario2_8__Group__1
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
    // InternalBug348427TestLanguage.g:2877:1: rule__Scenario2_8__Group__0__Impl : ( () ) ;
    public final void rule__Scenario2_8__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2881:1: ( ( () ) )
            // InternalBug348427TestLanguage.g:2882:1: ( () )
            {
            // InternalBug348427TestLanguage.g:2882:1: ( () )
            // InternalBug348427TestLanguage.g:2883:2: ()
            {
             before(grammarAccess.getScenario2_8Access().getScenario2Action_0()); 
            // InternalBug348427TestLanguage.g:2884:2: ()
            // InternalBug348427TestLanguage.g:2884:3: 
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
    // InternalBug348427TestLanguage.g:2892:1: rule__Scenario2_8__Group__1 : rule__Scenario2_8__Group__1__Impl rule__Scenario2_8__Group__2 ;
    public final void rule__Scenario2_8__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2896:1: ( rule__Scenario2_8__Group__1__Impl rule__Scenario2_8__Group__2 )
            // InternalBug348427TestLanguage.g:2897:2: rule__Scenario2_8__Group__1__Impl rule__Scenario2_8__Group__2
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
    // InternalBug348427TestLanguage.g:2904:1: rule__Scenario2_8__Group__1__Impl : ( '2.8' ) ;
    public final void rule__Scenario2_8__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2908:1: ( ( '2.8' ) )
            // InternalBug348427TestLanguage.g:2909:1: ( '2.8' )
            {
            // InternalBug348427TestLanguage.g:2909:1: ( '2.8' )
            // InternalBug348427TestLanguage.g:2910:2: '2.8'
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
    // InternalBug348427TestLanguage.g:2919:1: rule__Scenario2_8__Group__2 : rule__Scenario2_8__Group__2__Impl rule__Scenario2_8__Group__3 ;
    public final void rule__Scenario2_8__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2923:1: ( rule__Scenario2_8__Group__2__Impl rule__Scenario2_8__Group__3 )
            // InternalBug348427TestLanguage.g:2924:2: rule__Scenario2_8__Group__2__Impl rule__Scenario2_8__Group__3
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
    // InternalBug348427TestLanguage.g:2931:1: rule__Scenario2_8__Group__2__Impl : ( ( rule__Scenario2_8__Alternatives_2 )* ) ;
    public final void rule__Scenario2_8__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2935:1: ( ( ( rule__Scenario2_8__Alternatives_2 )* ) )
            // InternalBug348427TestLanguage.g:2936:1: ( ( rule__Scenario2_8__Alternatives_2 )* )
            {
            // InternalBug348427TestLanguage.g:2936:1: ( ( rule__Scenario2_8__Alternatives_2 )* )
            // InternalBug348427TestLanguage.g:2937:2: ( rule__Scenario2_8__Alternatives_2 )*
            {
             before(grammarAccess.getScenario2_8Access().getAlternatives_2()); 
            // InternalBug348427TestLanguage.g:2938:2: ( rule__Scenario2_8__Alternatives_2 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_ID) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalBug348427TestLanguage.g:2938:3: rule__Scenario2_8__Alternatives_2
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
    // InternalBug348427TestLanguage.g:2946:1: rule__Scenario2_8__Group__3 : rule__Scenario2_8__Group__3__Impl ;
    public final void rule__Scenario2_8__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2950:1: ( rule__Scenario2_8__Group__3__Impl )
            // InternalBug348427TestLanguage.g:2951:2: rule__Scenario2_8__Group__3__Impl
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
    // InternalBug348427TestLanguage.g:2957:1: rule__Scenario2_8__Group__3__Impl : ( 'next' ) ;
    public final void rule__Scenario2_8__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2961:1: ( ( 'next' ) )
            // InternalBug348427TestLanguage.g:2962:1: ( 'next' )
            {
            // InternalBug348427TestLanguage.g:2962:1: ( 'next' )
            // InternalBug348427TestLanguage.g:2963:2: 'next'
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
    // InternalBug348427TestLanguage.g:2973:1: rule__Child2_1__Group__0 : rule__Child2_1__Group__0__Impl rule__Child2_1__Group__1 ;
    public final void rule__Child2_1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2977:1: ( rule__Child2_1__Group__0__Impl rule__Child2_1__Group__1 )
            // InternalBug348427TestLanguage.g:2978:2: rule__Child2_1__Group__0__Impl rule__Child2_1__Group__1
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
    // InternalBug348427TestLanguage.g:2985:1: rule__Child2_1__Group__0__Impl : ( ( rule__Child2_1__NameAssignment_0 ) ) ;
    public final void rule__Child2_1__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:2989:1: ( ( ( rule__Child2_1__NameAssignment_0 ) ) )
            // InternalBug348427TestLanguage.g:2990:1: ( ( rule__Child2_1__NameAssignment_0 ) )
            {
            // InternalBug348427TestLanguage.g:2990:1: ( ( rule__Child2_1__NameAssignment_0 ) )
            // InternalBug348427TestLanguage.g:2991:2: ( rule__Child2_1__NameAssignment_0 )
            {
             before(grammarAccess.getChild2_1Access().getNameAssignment_0()); 
            // InternalBug348427TestLanguage.g:2992:2: ( rule__Child2_1__NameAssignment_0 )
            // InternalBug348427TestLanguage.g:2992:3: rule__Child2_1__NameAssignment_0
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
    // InternalBug348427TestLanguage.g:3000:1: rule__Child2_1__Group__1 : rule__Child2_1__Group__1__Impl rule__Child2_1__Group__2 ;
    public final void rule__Child2_1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3004:1: ( rule__Child2_1__Group__1__Impl rule__Child2_1__Group__2 )
            // InternalBug348427TestLanguage.g:3005:2: rule__Child2_1__Group__1__Impl rule__Child2_1__Group__2
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
    // InternalBug348427TestLanguage.g:3012:1: rule__Child2_1__Group__1__Impl : ( ':' ) ;
    public final void rule__Child2_1__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3016:1: ( ( ':' ) )
            // InternalBug348427TestLanguage.g:3017:1: ( ':' )
            {
            // InternalBug348427TestLanguage.g:3017:1: ( ':' )
            // InternalBug348427TestLanguage.g:3018:2: ':'
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
    // InternalBug348427TestLanguage.g:3027:1: rule__Child2_1__Group__2 : rule__Child2_1__Group__2__Impl rule__Child2_1__Group__3 ;
    public final void rule__Child2_1__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3031:1: ( rule__Child2_1__Group__2__Impl rule__Child2_1__Group__3 )
            // InternalBug348427TestLanguage.g:3032:2: rule__Child2_1__Group__2__Impl rule__Child2_1__Group__3
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
    // InternalBug348427TestLanguage.g:3039:1: rule__Child2_1__Group__2__Impl : ( ( rule__Child2_1__Group_2__0 )? ) ;
    public final void rule__Child2_1__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3043:1: ( ( ( rule__Child2_1__Group_2__0 )? ) )
            // InternalBug348427TestLanguage.g:3044:1: ( ( rule__Child2_1__Group_2__0 )? )
            {
            // InternalBug348427TestLanguage.g:3044:1: ( ( rule__Child2_1__Group_2__0 )? )
            // InternalBug348427TestLanguage.g:3045:2: ( rule__Child2_1__Group_2__0 )?
            {
             before(grammarAccess.getChild2_1Access().getGroup_2()); 
            // InternalBug348427TestLanguage.g:3046:2: ( rule__Child2_1__Group_2__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==32) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalBug348427TestLanguage.g:3046:3: rule__Child2_1__Group_2__0
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
    // InternalBug348427TestLanguage.g:3054:1: rule__Child2_1__Group__3 : rule__Child2_1__Group__3__Impl rule__Child2_1__Group__4 ;
    public final void rule__Child2_1__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3058:1: ( rule__Child2_1__Group__3__Impl rule__Child2_1__Group__4 )
            // InternalBug348427TestLanguage.g:3059:2: rule__Child2_1__Group__3__Impl rule__Child2_1__Group__4
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
    // InternalBug348427TestLanguage.g:3066:1: rule__Child2_1__Group__3__Impl : ( ( rule__Child2_1__StringAssignment_3 ) ) ;
    public final void rule__Child2_1__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3070:1: ( ( ( rule__Child2_1__StringAssignment_3 ) ) )
            // InternalBug348427TestLanguage.g:3071:1: ( ( rule__Child2_1__StringAssignment_3 ) )
            {
            // InternalBug348427TestLanguage.g:3071:1: ( ( rule__Child2_1__StringAssignment_3 ) )
            // InternalBug348427TestLanguage.g:3072:2: ( rule__Child2_1__StringAssignment_3 )
            {
             before(grammarAccess.getChild2_1Access().getStringAssignment_3()); 
            // InternalBug348427TestLanguage.g:3073:2: ( rule__Child2_1__StringAssignment_3 )
            // InternalBug348427TestLanguage.g:3073:3: rule__Child2_1__StringAssignment_3
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
    // InternalBug348427TestLanguage.g:3081:1: rule__Child2_1__Group__4 : rule__Child2_1__Group__4__Impl rule__Child2_1__Group__5 ;
    public final void rule__Child2_1__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3085:1: ( rule__Child2_1__Group__4__Impl rule__Child2_1__Group__5 )
            // InternalBug348427TestLanguage.g:3086:2: rule__Child2_1__Group__4__Impl rule__Child2_1__Group__5
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
    // InternalBug348427TestLanguage.g:3093:1: rule__Child2_1__Group__4__Impl : ( 'child1' ) ;
    public final void rule__Child2_1__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3097:1: ( ( 'child1' ) )
            // InternalBug348427TestLanguage.g:3098:1: ( 'child1' )
            {
            // InternalBug348427TestLanguage.g:3098:1: ( 'child1' )
            // InternalBug348427TestLanguage.g:3099:2: 'child1'
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
    // InternalBug348427TestLanguage.g:3108:1: rule__Child2_1__Group__5 : rule__Child2_1__Group__5__Impl ;
    public final void rule__Child2_1__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3112:1: ( rule__Child2_1__Group__5__Impl )
            // InternalBug348427TestLanguage.g:3113:2: rule__Child2_1__Group__5__Impl
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
    // InternalBug348427TestLanguage.g:3119:1: rule__Child2_1__Group__5__Impl : ( 'end' ) ;
    public final void rule__Child2_1__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3123:1: ( ( 'end' ) )
            // InternalBug348427TestLanguage.g:3124:1: ( 'end' )
            {
            // InternalBug348427TestLanguage.g:3124:1: ( 'end' )
            // InternalBug348427TestLanguage.g:3125:2: 'end'
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
    // InternalBug348427TestLanguage.g:3135:1: rule__Child2_1__Group_2__0 : rule__Child2_1__Group_2__0__Impl rule__Child2_1__Group_2__1 ;
    public final void rule__Child2_1__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3139:1: ( rule__Child2_1__Group_2__0__Impl rule__Child2_1__Group_2__1 )
            // InternalBug348427TestLanguage.g:3140:2: rule__Child2_1__Group_2__0__Impl rule__Child2_1__Group_2__1
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
    // InternalBug348427TestLanguage.g:3147:1: rule__Child2_1__Group_2__0__Impl : ( ( rule__Child2_1__BoolAssignment_2_0 ) ) ;
    public final void rule__Child2_1__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3151:1: ( ( ( rule__Child2_1__BoolAssignment_2_0 ) ) )
            // InternalBug348427TestLanguage.g:3152:1: ( ( rule__Child2_1__BoolAssignment_2_0 ) )
            {
            // InternalBug348427TestLanguage.g:3152:1: ( ( rule__Child2_1__BoolAssignment_2_0 ) )
            // InternalBug348427TestLanguage.g:3153:2: ( rule__Child2_1__BoolAssignment_2_0 )
            {
             before(grammarAccess.getChild2_1Access().getBoolAssignment_2_0()); 
            // InternalBug348427TestLanguage.g:3154:2: ( rule__Child2_1__BoolAssignment_2_0 )
            // InternalBug348427TestLanguage.g:3154:3: rule__Child2_1__BoolAssignment_2_0
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
    // InternalBug348427TestLanguage.g:3162:1: rule__Child2_1__Group_2__1 : rule__Child2_1__Group_2__1__Impl ;
    public final void rule__Child2_1__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3166:1: ( rule__Child2_1__Group_2__1__Impl )
            // InternalBug348427TestLanguage.g:3167:2: rule__Child2_1__Group_2__1__Impl
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
    // InternalBug348427TestLanguage.g:3173:1: rule__Child2_1__Group_2__1__Impl : ( 'keyword' ) ;
    public final void rule__Child2_1__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3177:1: ( ( 'keyword' ) )
            // InternalBug348427TestLanguage.g:3178:1: ( 'keyword' )
            {
            // InternalBug348427TestLanguage.g:3178:1: ( 'keyword' )
            // InternalBug348427TestLanguage.g:3179:2: 'keyword'
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
    // InternalBug348427TestLanguage.g:3189:1: rule__Child2_2__Group__0 : rule__Child2_2__Group__0__Impl rule__Child2_2__Group__1 ;
    public final void rule__Child2_2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3193:1: ( rule__Child2_2__Group__0__Impl rule__Child2_2__Group__1 )
            // InternalBug348427TestLanguage.g:3194:2: rule__Child2_2__Group__0__Impl rule__Child2_2__Group__1
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
    // InternalBug348427TestLanguage.g:3201:1: rule__Child2_2__Group__0__Impl : ( ( rule__Child2_2__NameAssignment_0 ) ) ;
    public final void rule__Child2_2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3205:1: ( ( ( rule__Child2_2__NameAssignment_0 ) ) )
            // InternalBug348427TestLanguage.g:3206:1: ( ( rule__Child2_2__NameAssignment_0 ) )
            {
            // InternalBug348427TestLanguage.g:3206:1: ( ( rule__Child2_2__NameAssignment_0 ) )
            // InternalBug348427TestLanguage.g:3207:2: ( rule__Child2_2__NameAssignment_0 )
            {
             before(grammarAccess.getChild2_2Access().getNameAssignment_0()); 
            // InternalBug348427TestLanguage.g:3208:2: ( rule__Child2_2__NameAssignment_0 )
            // InternalBug348427TestLanguage.g:3208:3: rule__Child2_2__NameAssignment_0
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
    // InternalBug348427TestLanguage.g:3216:1: rule__Child2_2__Group__1 : rule__Child2_2__Group__1__Impl rule__Child2_2__Group__2 ;
    public final void rule__Child2_2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3220:1: ( rule__Child2_2__Group__1__Impl rule__Child2_2__Group__2 )
            // InternalBug348427TestLanguage.g:3221:2: rule__Child2_2__Group__1__Impl rule__Child2_2__Group__2
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
    // InternalBug348427TestLanguage.g:3228:1: rule__Child2_2__Group__1__Impl : ( ':' ) ;
    public final void rule__Child2_2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3232:1: ( ( ':' ) )
            // InternalBug348427TestLanguage.g:3233:1: ( ':' )
            {
            // InternalBug348427TestLanguage.g:3233:1: ( ':' )
            // InternalBug348427TestLanguage.g:3234:2: ':'
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
    // InternalBug348427TestLanguage.g:3243:1: rule__Child2_2__Group__2 : rule__Child2_2__Group__2__Impl rule__Child2_2__Group__3 ;
    public final void rule__Child2_2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3247:1: ( rule__Child2_2__Group__2__Impl rule__Child2_2__Group__3 )
            // InternalBug348427TestLanguage.g:3248:2: rule__Child2_2__Group__2__Impl rule__Child2_2__Group__3
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
    // InternalBug348427TestLanguage.g:3255:1: rule__Child2_2__Group__2__Impl : ( ( rule__Child2_2__Group_2__0 )? ) ;
    public final void rule__Child2_2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3259:1: ( ( ( rule__Child2_2__Group_2__0 )? ) )
            // InternalBug348427TestLanguage.g:3260:1: ( ( rule__Child2_2__Group_2__0 )? )
            {
            // InternalBug348427TestLanguage.g:3260:1: ( ( rule__Child2_2__Group_2__0 )? )
            // InternalBug348427TestLanguage.g:3261:2: ( rule__Child2_2__Group_2__0 )?
            {
             before(grammarAccess.getChild2_2Access().getGroup_2()); 
            // InternalBug348427TestLanguage.g:3262:2: ( rule__Child2_2__Group_2__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==32) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalBug348427TestLanguage.g:3262:3: rule__Child2_2__Group_2__0
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
    // InternalBug348427TestLanguage.g:3270:1: rule__Child2_2__Group__3 : rule__Child2_2__Group__3__Impl rule__Child2_2__Group__4 ;
    public final void rule__Child2_2__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3274:1: ( rule__Child2_2__Group__3__Impl rule__Child2_2__Group__4 )
            // InternalBug348427TestLanguage.g:3275:2: rule__Child2_2__Group__3__Impl rule__Child2_2__Group__4
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
    // InternalBug348427TestLanguage.g:3282:1: rule__Child2_2__Group__3__Impl : ( ( rule__Child2_2__StringAssignment_3 ) ) ;
    public final void rule__Child2_2__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3286:1: ( ( ( rule__Child2_2__StringAssignment_3 ) ) )
            // InternalBug348427TestLanguage.g:3287:1: ( ( rule__Child2_2__StringAssignment_3 ) )
            {
            // InternalBug348427TestLanguage.g:3287:1: ( ( rule__Child2_2__StringAssignment_3 ) )
            // InternalBug348427TestLanguage.g:3288:2: ( rule__Child2_2__StringAssignment_3 )
            {
             before(grammarAccess.getChild2_2Access().getStringAssignment_3()); 
            // InternalBug348427TestLanguage.g:3289:2: ( rule__Child2_2__StringAssignment_3 )
            // InternalBug348427TestLanguage.g:3289:3: rule__Child2_2__StringAssignment_3
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
    // InternalBug348427TestLanguage.g:3297:1: rule__Child2_2__Group__4 : rule__Child2_2__Group__4__Impl rule__Child2_2__Group__5 ;
    public final void rule__Child2_2__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3301:1: ( rule__Child2_2__Group__4__Impl rule__Child2_2__Group__5 )
            // InternalBug348427TestLanguage.g:3302:2: rule__Child2_2__Group__4__Impl rule__Child2_2__Group__5
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
    // InternalBug348427TestLanguage.g:3309:1: rule__Child2_2__Group__4__Impl : ( 'child2' ) ;
    public final void rule__Child2_2__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3313:1: ( ( 'child2' ) )
            // InternalBug348427TestLanguage.g:3314:1: ( 'child2' )
            {
            // InternalBug348427TestLanguage.g:3314:1: ( 'child2' )
            // InternalBug348427TestLanguage.g:3315:2: 'child2'
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
    // InternalBug348427TestLanguage.g:3324:1: rule__Child2_2__Group__5 : rule__Child2_2__Group__5__Impl ;
    public final void rule__Child2_2__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3328:1: ( rule__Child2_2__Group__5__Impl )
            // InternalBug348427TestLanguage.g:3329:2: rule__Child2_2__Group__5__Impl
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
    // InternalBug348427TestLanguage.g:3335:1: rule__Child2_2__Group__5__Impl : ( 'end' ) ;
    public final void rule__Child2_2__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3339:1: ( ( 'end' ) )
            // InternalBug348427TestLanguage.g:3340:1: ( 'end' )
            {
            // InternalBug348427TestLanguage.g:3340:1: ( 'end' )
            // InternalBug348427TestLanguage.g:3341:2: 'end'
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
    // InternalBug348427TestLanguage.g:3351:1: rule__Child2_2__Group_2__0 : rule__Child2_2__Group_2__0__Impl rule__Child2_2__Group_2__1 ;
    public final void rule__Child2_2__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3355:1: ( rule__Child2_2__Group_2__0__Impl rule__Child2_2__Group_2__1 )
            // InternalBug348427TestLanguage.g:3356:2: rule__Child2_2__Group_2__0__Impl rule__Child2_2__Group_2__1
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
    // InternalBug348427TestLanguage.g:3363:1: rule__Child2_2__Group_2__0__Impl : ( ( rule__Child2_2__BoolAssignment_2_0 ) ) ;
    public final void rule__Child2_2__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3367:1: ( ( ( rule__Child2_2__BoolAssignment_2_0 ) ) )
            // InternalBug348427TestLanguage.g:3368:1: ( ( rule__Child2_2__BoolAssignment_2_0 ) )
            {
            // InternalBug348427TestLanguage.g:3368:1: ( ( rule__Child2_2__BoolAssignment_2_0 ) )
            // InternalBug348427TestLanguage.g:3369:2: ( rule__Child2_2__BoolAssignment_2_0 )
            {
             before(grammarAccess.getChild2_2Access().getBoolAssignment_2_0()); 
            // InternalBug348427TestLanguage.g:3370:2: ( rule__Child2_2__BoolAssignment_2_0 )
            // InternalBug348427TestLanguage.g:3370:3: rule__Child2_2__BoolAssignment_2_0
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
    // InternalBug348427TestLanguage.g:3378:1: rule__Child2_2__Group_2__1 : rule__Child2_2__Group_2__1__Impl ;
    public final void rule__Child2_2__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3382:1: ( rule__Child2_2__Group_2__1__Impl )
            // InternalBug348427TestLanguage.g:3383:2: rule__Child2_2__Group_2__1__Impl
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
    // InternalBug348427TestLanguage.g:3389:1: rule__Child2_2__Group_2__1__Impl : ( 'keyword' ) ;
    public final void rule__Child2_2__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3393:1: ( ( 'keyword' ) )
            // InternalBug348427TestLanguage.g:3394:1: ( 'keyword' )
            {
            // InternalBug348427TestLanguage.g:3394:1: ( 'keyword' )
            // InternalBug348427TestLanguage.g:3395:2: 'keyword'
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
    // InternalBug348427TestLanguage.g:3405:1: rule__Child2_3__Group__0 : rule__Child2_3__Group__0__Impl rule__Child2_3__Group__1 ;
    public final void rule__Child2_3__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3409:1: ( rule__Child2_3__Group__0__Impl rule__Child2_3__Group__1 )
            // InternalBug348427TestLanguage.g:3410:2: rule__Child2_3__Group__0__Impl rule__Child2_3__Group__1
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
    // InternalBug348427TestLanguage.g:3417:1: rule__Child2_3__Group__0__Impl : ( ( rule__Child2_3__NameAssignment_0 ) ) ;
    public final void rule__Child2_3__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3421:1: ( ( ( rule__Child2_3__NameAssignment_0 ) ) )
            // InternalBug348427TestLanguage.g:3422:1: ( ( rule__Child2_3__NameAssignment_0 ) )
            {
            // InternalBug348427TestLanguage.g:3422:1: ( ( rule__Child2_3__NameAssignment_0 ) )
            // InternalBug348427TestLanguage.g:3423:2: ( rule__Child2_3__NameAssignment_0 )
            {
             before(grammarAccess.getChild2_3Access().getNameAssignment_0()); 
            // InternalBug348427TestLanguage.g:3424:2: ( rule__Child2_3__NameAssignment_0 )
            // InternalBug348427TestLanguage.g:3424:3: rule__Child2_3__NameAssignment_0
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
    // InternalBug348427TestLanguage.g:3432:1: rule__Child2_3__Group__1 : rule__Child2_3__Group__1__Impl rule__Child2_3__Group__2 ;
    public final void rule__Child2_3__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3436:1: ( rule__Child2_3__Group__1__Impl rule__Child2_3__Group__2 )
            // InternalBug348427TestLanguage.g:3437:2: rule__Child2_3__Group__1__Impl rule__Child2_3__Group__2
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
    // InternalBug348427TestLanguage.g:3444:1: rule__Child2_3__Group__1__Impl : ( ':' ) ;
    public final void rule__Child2_3__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3448:1: ( ( ':' ) )
            // InternalBug348427TestLanguage.g:3449:1: ( ':' )
            {
            // InternalBug348427TestLanguage.g:3449:1: ( ':' )
            // InternalBug348427TestLanguage.g:3450:2: ':'
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
    // InternalBug348427TestLanguage.g:3459:1: rule__Child2_3__Group__2 : rule__Child2_3__Group__2__Impl rule__Child2_3__Group__3 ;
    public final void rule__Child2_3__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3463:1: ( rule__Child2_3__Group__2__Impl rule__Child2_3__Group__3 )
            // InternalBug348427TestLanguage.g:3464:2: rule__Child2_3__Group__2__Impl rule__Child2_3__Group__3
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
    // InternalBug348427TestLanguage.g:3471:1: rule__Child2_3__Group__2__Impl : ( ( rule__Child2_3__Group_2__0 )? ) ;
    public final void rule__Child2_3__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3475:1: ( ( ( rule__Child2_3__Group_2__0 )? ) )
            // InternalBug348427TestLanguage.g:3476:1: ( ( rule__Child2_3__Group_2__0 )? )
            {
            // InternalBug348427TestLanguage.g:3476:1: ( ( rule__Child2_3__Group_2__0 )? )
            // InternalBug348427TestLanguage.g:3477:2: ( rule__Child2_3__Group_2__0 )?
            {
             before(grammarAccess.getChild2_3Access().getGroup_2()); 
            // InternalBug348427TestLanguage.g:3478:2: ( rule__Child2_3__Group_2__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==32) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalBug348427TestLanguage.g:3478:3: rule__Child2_3__Group_2__0
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
    // InternalBug348427TestLanguage.g:3486:1: rule__Child2_3__Group__3 : rule__Child2_3__Group__3__Impl rule__Child2_3__Group__4 ;
    public final void rule__Child2_3__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3490:1: ( rule__Child2_3__Group__3__Impl rule__Child2_3__Group__4 )
            // InternalBug348427TestLanguage.g:3491:2: rule__Child2_3__Group__3__Impl rule__Child2_3__Group__4
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
    // InternalBug348427TestLanguage.g:3498:1: rule__Child2_3__Group__3__Impl : ( ( rule__Child2_3__StringAssignment_3 ) ) ;
    public final void rule__Child2_3__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3502:1: ( ( ( rule__Child2_3__StringAssignment_3 ) ) )
            // InternalBug348427TestLanguage.g:3503:1: ( ( rule__Child2_3__StringAssignment_3 ) )
            {
            // InternalBug348427TestLanguage.g:3503:1: ( ( rule__Child2_3__StringAssignment_3 ) )
            // InternalBug348427TestLanguage.g:3504:2: ( rule__Child2_3__StringAssignment_3 )
            {
             before(grammarAccess.getChild2_3Access().getStringAssignment_3()); 
            // InternalBug348427TestLanguage.g:3505:2: ( rule__Child2_3__StringAssignment_3 )
            // InternalBug348427TestLanguage.g:3505:3: rule__Child2_3__StringAssignment_3
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
    // InternalBug348427TestLanguage.g:3513:1: rule__Child2_3__Group__4 : rule__Child2_3__Group__4__Impl rule__Child2_3__Group__5 ;
    public final void rule__Child2_3__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3517:1: ( rule__Child2_3__Group__4__Impl rule__Child2_3__Group__5 )
            // InternalBug348427TestLanguage.g:3518:2: rule__Child2_3__Group__4__Impl rule__Child2_3__Group__5
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
    // InternalBug348427TestLanguage.g:3525:1: rule__Child2_3__Group__4__Impl : ( 'child3' ) ;
    public final void rule__Child2_3__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3529:1: ( ( 'child3' ) )
            // InternalBug348427TestLanguage.g:3530:1: ( 'child3' )
            {
            // InternalBug348427TestLanguage.g:3530:1: ( 'child3' )
            // InternalBug348427TestLanguage.g:3531:2: 'child3'
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
    // InternalBug348427TestLanguage.g:3540:1: rule__Child2_3__Group__5 : rule__Child2_3__Group__5__Impl ;
    public final void rule__Child2_3__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3544:1: ( rule__Child2_3__Group__5__Impl )
            // InternalBug348427TestLanguage.g:3545:2: rule__Child2_3__Group__5__Impl
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
    // InternalBug348427TestLanguage.g:3551:1: rule__Child2_3__Group__5__Impl : ( 'end' ) ;
    public final void rule__Child2_3__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3555:1: ( ( 'end' ) )
            // InternalBug348427TestLanguage.g:3556:1: ( 'end' )
            {
            // InternalBug348427TestLanguage.g:3556:1: ( 'end' )
            // InternalBug348427TestLanguage.g:3557:2: 'end'
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
    // InternalBug348427TestLanguage.g:3567:1: rule__Child2_3__Group_2__0 : rule__Child2_3__Group_2__0__Impl rule__Child2_3__Group_2__1 ;
    public final void rule__Child2_3__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3571:1: ( rule__Child2_3__Group_2__0__Impl rule__Child2_3__Group_2__1 )
            // InternalBug348427TestLanguage.g:3572:2: rule__Child2_3__Group_2__0__Impl rule__Child2_3__Group_2__1
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
    // InternalBug348427TestLanguage.g:3579:1: rule__Child2_3__Group_2__0__Impl : ( ( rule__Child2_3__BoolAssignment_2_0 ) ) ;
    public final void rule__Child2_3__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3583:1: ( ( ( rule__Child2_3__BoolAssignment_2_0 ) ) )
            // InternalBug348427TestLanguage.g:3584:1: ( ( rule__Child2_3__BoolAssignment_2_0 ) )
            {
            // InternalBug348427TestLanguage.g:3584:1: ( ( rule__Child2_3__BoolAssignment_2_0 ) )
            // InternalBug348427TestLanguage.g:3585:2: ( rule__Child2_3__BoolAssignment_2_0 )
            {
             before(grammarAccess.getChild2_3Access().getBoolAssignment_2_0()); 
            // InternalBug348427TestLanguage.g:3586:2: ( rule__Child2_3__BoolAssignment_2_0 )
            // InternalBug348427TestLanguage.g:3586:3: rule__Child2_3__BoolAssignment_2_0
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
    // InternalBug348427TestLanguage.g:3594:1: rule__Child2_3__Group_2__1 : rule__Child2_3__Group_2__1__Impl ;
    public final void rule__Child2_3__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3598:1: ( rule__Child2_3__Group_2__1__Impl )
            // InternalBug348427TestLanguage.g:3599:2: rule__Child2_3__Group_2__1__Impl
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
    // InternalBug348427TestLanguage.g:3605:1: rule__Child2_3__Group_2__1__Impl : ( 'keyword' ) ;
    public final void rule__Child2_3__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3609:1: ( ( 'keyword' ) )
            // InternalBug348427TestLanguage.g:3610:1: ( 'keyword' )
            {
            // InternalBug348427TestLanguage.g:3610:1: ( 'keyword' )
            // InternalBug348427TestLanguage.g:3611:2: 'keyword'
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
    // InternalBug348427TestLanguage.g:3621:1: rule__Child2_4__Group__0 : rule__Child2_4__Group__0__Impl rule__Child2_4__Group__1 ;
    public final void rule__Child2_4__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3625:1: ( rule__Child2_4__Group__0__Impl rule__Child2_4__Group__1 )
            // InternalBug348427TestLanguage.g:3626:2: rule__Child2_4__Group__0__Impl rule__Child2_4__Group__1
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
    // InternalBug348427TestLanguage.g:3633:1: rule__Child2_4__Group__0__Impl : ( ( rule__Child2_4__NameAssignment_0 ) ) ;
    public final void rule__Child2_4__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3637:1: ( ( ( rule__Child2_4__NameAssignment_0 ) ) )
            // InternalBug348427TestLanguage.g:3638:1: ( ( rule__Child2_4__NameAssignment_0 ) )
            {
            // InternalBug348427TestLanguage.g:3638:1: ( ( rule__Child2_4__NameAssignment_0 ) )
            // InternalBug348427TestLanguage.g:3639:2: ( rule__Child2_4__NameAssignment_0 )
            {
             before(grammarAccess.getChild2_4Access().getNameAssignment_0()); 
            // InternalBug348427TestLanguage.g:3640:2: ( rule__Child2_4__NameAssignment_0 )
            // InternalBug348427TestLanguage.g:3640:3: rule__Child2_4__NameAssignment_0
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
    // InternalBug348427TestLanguage.g:3648:1: rule__Child2_4__Group__1 : rule__Child2_4__Group__1__Impl rule__Child2_4__Group__2 ;
    public final void rule__Child2_4__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3652:1: ( rule__Child2_4__Group__1__Impl rule__Child2_4__Group__2 )
            // InternalBug348427TestLanguage.g:3653:2: rule__Child2_4__Group__1__Impl rule__Child2_4__Group__2
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
    // InternalBug348427TestLanguage.g:3660:1: rule__Child2_4__Group__1__Impl : ( ':' ) ;
    public final void rule__Child2_4__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3664:1: ( ( ':' ) )
            // InternalBug348427TestLanguage.g:3665:1: ( ':' )
            {
            // InternalBug348427TestLanguage.g:3665:1: ( ':' )
            // InternalBug348427TestLanguage.g:3666:2: ':'
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
    // InternalBug348427TestLanguage.g:3675:1: rule__Child2_4__Group__2 : rule__Child2_4__Group__2__Impl rule__Child2_4__Group__3 ;
    public final void rule__Child2_4__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3679:1: ( rule__Child2_4__Group__2__Impl rule__Child2_4__Group__3 )
            // InternalBug348427TestLanguage.g:3680:2: rule__Child2_4__Group__2__Impl rule__Child2_4__Group__3
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
    // InternalBug348427TestLanguage.g:3687:1: rule__Child2_4__Group__2__Impl : ( ( rule__Child2_4__Group_2__0 )? ) ;
    public final void rule__Child2_4__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3691:1: ( ( ( rule__Child2_4__Group_2__0 )? ) )
            // InternalBug348427TestLanguage.g:3692:1: ( ( rule__Child2_4__Group_2__0 )? )
            {
            // InternalBug348427TestLanguage.g:3692:1: ( ( rule__Child2_4__Group_2__0 )? )
            // InternalBug348427TestLanguage.g:3693:2: ( rule__Child2_4__Group_2__0 )?
            {
             before(grammarAccess.getChild2_4Access().getGroup_2()); 
            // InternalBug348427TestLanguage.g:3694:2: ( rule__Child2_4__Group_2__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==32) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalBug348427TestLanguage.g:3694:3: rule__Child2_4__Group_2__0
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
    // InternalBug348427TestLanguage.g:3702:1: rule__Child2_4__Group__3 : rule__Child2_4__Group__3__Impl rule__Child2_4__Group__4 ;
    public final void rule__Child2_4__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3706:1: ( rule__Child2_4__Group__3__Impl rule__Child2_4__Group__4 )
            // InternalBug348427TestLanguage.g:3707:2: rule__Child2_4__Group__3__Impl rule__Child2_4__Group__4
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
    // InternalBug348427TestLanguage.g:3714:1: rule__Child2_4__Group__3__Impl : ( ( rule__Child2_4__Alternatives_3 ) ) ;
    public final void rule__Child2_4__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3718:1: ( ( ( rule__Child2_4__Alternatives_3 ) ) )
            // InternalBug348427TestLanguage.g:3719:1: ( ( rule__Child2_4__Alternatives_3 ) )
            {
            // InternalBug348427TestLanguage.g:3719:1: ( ( rule__Child2_4__Alternatives_3 ) )
            // InternalBug348427TestLanguage.g:3720:2: ( rule__Child2_4__Alternatives_3 )
            {
             before(grammarAccess.getChild2_4Access().getAlternatives_3()); 
            // InternalBug348427TestLanguage.g:3721:2: ( rule__Child2_4__Alternatives_3 )
            // InternalBug348427TestLanguage.g:3721:3: rule__Child2_4__Alternatives_3
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
    // InternalBug348427TestLanguage.g:3729:1: rule__Child2_4__Group__4 : rule__Child2_4__Group__4__Impl rule__Child2_4__Group__5 ;
    public final void rule__Child2_4__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3733:1: ( rule__Child2_4__Group__4__Impl rule__Child2_4__Group__5 )
            // InternalBug348427TestLanguage.g:3734:2: rule__Child2_4__Group__4__Impl rule__Child2_4__Group__5
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
    // InternalBug348427TestLanguage.g:3741:1: rule__Child2_4__Group__4__Impl : ( 'child1' ) ;
    public final void rule__Child2_4__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3745:1: ( ( 'child1' ) )
            // InternalBug348427TestLanguage.g:3746:1: ( 'child1' )
            {
            // InternalBug348427TestLanguage.g:3746:1: ( 'child1' )
            // InternalBug348427TestLanguage.g:3747:2: 'child1'
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
    // InternalBug348427TestLanguage.g:3756:1: rule__Child2_4__Group__5 : rule__Child2_4__Group__5__Impl ;
    public final void rule__Child2_4__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3760:1: ( rule__Child2_4__Group__5__Impl )
            // InternalBug348427TestLanguage.g:3761:2: rule__Child2_4__Group__5__Impl
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
    // InternalBug348427TestLanguage.g:3767:1: rule__Child2_4__Group__5__Impl : ( 'end' ) ;
    public final void rule__Child2_4__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3771:1: ( ( 'end' ) )
            // InternalBug348427TestLanguage.g:3772:1: ( 'end' )
            {
            // InternalBug348427TestLanguage.g:3772:1: ( 'end' )
            // InternalBug348427TestLanguage.g:3773:2: 'end'
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
    // InternalBug348427TestLanguage.g:3783:1: rule__Child2_4__Group_2__0 : rule__Child2_4__Group_2__0__Impl rule__Child2_4__Group_2__1 ;
    public final void rule__Child2_4__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3787:1: ( rule__Child2_4__Group_2__0__Impl rule__Child2_4__Group_2__1 )
            // InternalBug348427TestLanguage.g:3788:2: rule__Child2_4__Group_2__0__Impl rule__Child2_4__Group_2__1
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
    // InternalBug348427TestLanguage.g:3795:1: rule__Child2_4__Group_2__0__Impl : ( ( rule__Child2_4__BoolAssignment_2_0 ) ) ;
    public final void rule__Child2_4__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3799:1: ( ( ( rule__Child2_4__BoolAssignment_2_0 ) ) )
            // InternalBug348427TestLanguage.g:3800:1: ( ( rule__Child2_4__BoolAssignment_2_0 ) )
            {
            // InternalBug348427TestLanguage.g:3800:1: ( ( rule__Child2_4__BoolAssignment_2_0 ) )
            // InternalBug348427TestLanguage.g:3801:2: ( rule__Child2_4__BoolAssignment_2_0 )
            {
             before(grammarAccess.getChild2_4Access().getBoolAssignment_2_0()); 
            // InternalBug348427TestLanguage.g:3802:2: ( rule__Child2_4__BoolAssignment_2_0 )
            // InternalBug348427TestLanguage.g:3802:3: rule__Child2_4__BoolAssignment_2_0
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
    // InternalBug348427TestLanguage.g:3810:1: rule__Child2_4__Group_2__1 : rule__Child2_4__Group_2__1__Impl ;
    public final void rule__Child2_4__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3814:1: ( rule__Child2_4__Group_2__1__Impl )
            // InternalBug348427TestLanguage.g:3815:2: rule__Child2_4__Group_2__1__Impl
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
    // InternalBug348427TestLanguage.g:3821:1: rule__Child2_4__Group_2__1__Impl : ( 'keyword' ) ;
    public final void rule__Child2_4__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3825:1: ( ( 'keyword' ) )
            // InternalBug348427TestLanguage.g:3826:1: ( 'keyword' )
            {
            // InternalBug348427TestLanguage.g:3826:1: ( 'keyword' )
            // InternalBug348427TestLanguage.g:3827:2: 'keyword'
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
    // InternalBug348427TestLanguage.g:3837:1: rule__Child2_5__Group__0 : rule__Child2_5__Group__0__Impl rule__Child2_5__Group__1 ;
    public final void rule__Child2_5__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3841:1: ( rule__Child2_5__Group__0__Impl rule__Child2_5__Group__1 )
            // InternalBug348427TestLanguage.g:3842:2: rule__Child2_5__Group__0__Impl rule__Child2_5__Group__1
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
    // InternalBug348427TestLanguage.g:3849:1: rule__Child2_5__Group__0__Impl : ( ( rule__Child2_5__NameAssignment_0 ) ) ;
    public final void rule__Child2_5__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3853:1: ( ( ( rule__Child2_5__NameAssignment_0 ) ) )
            // InternalBug348427TestLanguage.g:3854:1: ( ( rule__Child2_5__NameAssignment_0 ) )
            {
            // InternalBug348427TestLanguage.g:3854:1: ( ( rule__Child2_5__NameAssignment_0 ) )
            // InternalBug348427TestLanguage.g:3855:2: ( rule__Child2_5__NameAssignment_0 )
            {
             before(grammarAccess.getChild2_5Access().getNameAssignment_0()); 
            // InternalBug348427TestLanguage.g:3856:2: ( rule__Child2_5__NameAssignment_0 )
            // InternalBug348427TestLanguage.g:3856:3: rule__Child2_5__NameAssignment_0
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
    // InternalBug348427TestLanguage.g:3864:1: rule__Child2_5__Group__1 : rule__Child2_5__Group__1__Impl rule__Child2_5__Group__2 ;
    public final void rule__Child2_5__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3868:1: ( rule__Child2_5__Group__1__Impl rule__Child2_5__Group__2 )
            // InternalBug348427TestLanguage.g:3869:2: rule__Child2_5__Group__1__Impl rule__Child2_5__Group__2
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
    // InternalBug348427TestLanguage.g:3876:1: rule__Child2_5__Group__1__Impl : ( ':' ) ;
    public final void rule__Child2_5__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3880:1: ( ( ':' ) )
            // InternalBug348427TestLanguage.g:3881:1: ( ':' )
            {
            // InternalBug348427TestLanguage.g:3881:1: ( ':' )
            // InternalBug348427TestLanguage.g:3882:2: ':'
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
    // InternalBug348427TestLanguage.g:3891:1: rule__Child2_5__Group__2 : rule__Child2_5__Group__2__Impl rule__Child2_5__Group__3 ;
    public final void rule__Child2_5__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3895:1: ( rule__Child2_5__Group__2__Impl rule__Child2_5__Group__3 )
            // InternalBug348427TestLanguage.g:3896:2: rule__Child2_5__Group__2__Impl rule__Child2_5__Group__3
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
    // InternalBug348427TestLanguage.g:3903:1: rule__Child2_5__Group__2__Impl : ( ( rule__Child2_5__Group_2__0 )? ) ;
    public final void rule__Child2_5__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3907:1: ( ( ( rule__Child2_5__Group_2__0 )? ) )
            // InternalBug348427TestLanguage.g:3908:1: ( ( rule__Child2_5__Group_2__0 )? )
            {
            // InternalBug348427TestLanguage.g:3908:1: ( ( rule__Child2_5__Group_2__0 )? )
            // InternalBug348427TestLanguage.g:3909:2: ( rule__Child2_5__Group_2__0 )?
            {
             before(grammarAccess.getChild2_5Access().getGroup_2()); 
            // InternalBug348427TestLanguage.g:3910:2: ( rule__Child2_5__Group_2__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==32) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalBug348427TestLanguage.g:3910:3: rule__Child2_5__Group_2__0
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
    // InternalBug348427TestLanguage.g:3918:1: rule__Child2_5__Group__3 : rule__Child2_5__Group__3__Impl rule__Child2_5__Group__4 ;
    public final void rule__Child2_5__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3922:1: ( rule__Child2_5__Group__3__Impl rule__Child2_5__Group__4 )
            // InternalBug348427TestLanguage.g:3923:2: rule__Child2_5__Group__3__Impl rule__Child2_5__Group__4
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
    // InternalBug348427TestLanguage.g:3930:1: rule__Child2_5__Group__3__Impl : ( ( rule__Child2_5__Alternatives_3 ) ) ;
    public final void rule__Child2_5__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3934:1: ( ( ( rule__Child2_5__Alternatives_3 ) ) )
            // InternalBug348427TestLanguage.g:3935:1: ( ( rule__Child2_5__Alternatives_3 ) )
            {
            // InternalBug348427TestLanguage.g:3935:1: ( ( rule__Child2_5__Alternatives_3 ) )
            // InternalBug348427TestLanguage.g:3936:2: ( rule__Child2_5__Alternatives_3 )
            {
             before(grammarAccess.getChild2_5Access().getAlternatives_3()); 
            // InternalBug348427TestLanguage.g:3937:2: ( rule__Child2_5__Alternatives_3 )
            // InternalBug348427TestLanguage.g:3937:3: rule__Child2_5__Alternatives_3
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
    // InternalBug348427TestLanguage.g:3945:1: rule__Child2_5__Group__4 : rule__Child2_5__Group__4__Impl rule__Child2_5__Group__5 ;
    public final void rule__Child2_5__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3949:1: ( rule__Child2_5__Group__4__Impl rule__Child2_5__Group__5 )
            // InternalBug348427TestLanguage.g:3950:2: rule__Child2_5__Group__4__Impl rule__Child2_5__Group__5
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
    // InternalBug348427TestLanguage.g:3957:1: rule__Child2_5__Group__4__Impl : ( 'child2' ) ;
    public final void rule__Child2_5__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3961:1: ( ( 'child2' ) )
            // InternalBug348427TestLanguage.g:3962:1: ( 'child2' )
            {
            // InternalBug348427TestLanguage.g:3962:1: ( 'child2' )
            // InternalBug348427TestLanguage.g:3963:2: 'child2'
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
    // InternalBug348427TestLanguage.g:3972:1: rule__Child2_5__Group__5 : rule__Child2_5__Group__5__Impl ;
    public final void rule__Child2_5__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3976:1: ( rule__Child2_5__Group__5__Impl )
            // InternalBug348427TestLanguage.g:3977:2: rule__Child2_5__Group__5__Impl
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
    // InternalBug348427TestLanguage.g:3983:1: rule__Child2_5__Group__5__Impl : ( 'end' ) ;
    public final void rule__Child2_5__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:3987:1: ( ( 'end' ) )
            // InternalBug348427TestLanguage.g:3988:1: ( 'end' )
            {
            // InternalBug348427TestLanguage.g:3988:1: ( 'end' )
            // InternalBug348427TestLanguage.g:3989:2: 'end'
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
    // InternalBug348427TestLanguage.g:3999:1: rule__Child2_5__Group_2__0 : rule__Child2_5__Group_2__0__Impl rule__Child2_5__Group_2__1 ;
    public final void rule__Child2_5__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4003:1: ( rule__Child2_5__Group_2__0__Impl rule__Child2_5__Group_2__1 )
            // InternalBug348427TestLanguage.g:4004:2: rule__Child2_5__Group_2__0__Impl rule__Child2_5__Group_2__1
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
    // InternalBug348427TestLanguage.g:4011:1: rule__Child2_5__Group_2__0__Impl : ( ( rule__Child2_5__BoolAssignment_2_0 ) ) ;
    public final void rule__Child2_5__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4015:1: ( ( ( rule__Child2_5__BoolAssignment_2_0 ) ) )
            // InternalBug348427TestLanguage.g:4016:1: ( ( rule__Child2_5__BoolAssignment_2_0 ) )
            {
            // InternalBug348427TestLanguage.g:4016:1: ( ( rule__Child2_5__BoolAssignment_2_0 ) )
            // InternalBug348427TestLanguage.g:4017:2: ( rule__Child2_5__BoolAssignment_2_0 )
            {
             before(grammarAccess.getChild2_5Access().getBoolAssignment_2_0()); 
            // InternalBug348427TestLanguage.g:4018:2: ( rule__Child2_5__BoolAssignment_2_0 )
            // InternalBug348427TestLanguage.g:4018:3: rule__Child2_5__BoolAssignment_2_0
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
    // InternalBug348427TestLanguage.g:4026:1: rule__Child2_5__Group_2__1 : rule__Child2_5__Group_2__1__Impl ;
    public final void rule__Child2_5__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4030:1: ( rule__Child2_5__Group_2__1__Impl )
            // InternalBug348427TestLanguage.g:4031:2: rule__Child2_5__Group_2__1__Impl
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
    // InternalBug348427TestLanguage.g:4037:1: rule__Child2_5__Group_2__1__Impl : ( 'keyword' ) ;
    public final void rule__Child2_5__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4041:1: ( ( 'keyword' ) )
            // InternalBug348427TestLanguage.g:4042:1: ( 'keyword' )
            {
            // InternalBug348427TestLanguage.g:4042:1: ( 'keyword' )
            // InternalBug348427TestLanguage.g:4043:2: 'keyword'
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
    // InternalBug348427TestLanguage.g:4053:1: rule__Child2_6__Group__0 : rule__Child2_6__Group__0__Impl rule__Child2_6__Group__1 ;
    public final void rule__Child2_6__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4057:1: ( rule__Child2_6__Group__0__Impl rule__Child2_6__Group__1 )
            // InternalBug348427TestLanguage.g:4058:2: rule__Child2_6__Group__0__Impl rule__Child2_6__Group__1
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
    // InternalBug348427TestLanguage.g:4065:1: rule__Child2_6__Group__0__Impl : ( ( rule__Child2_6__NameAssignment_0 ) ) ;
    public final void rule__Child2_6__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4069:1: ( ( ( rule__Child2_6__NameAssignment_0 ) ) )
            // InternalBug348427TestLanguage.g:4070:1: ( ( rule__Child2_6__NameAssignment_0 ) )
            {
            // InternalBug348427TestLanguage.g:4070:1: ( ( rule__Child2_6__NameAssignment_0 ) )
            // InternalBug348427TestLanguage.g:4071:2: ( rule__Child2_6__NameAssignment_0 )
            {
             before(grammarAccess.getChild2_6Access().getNameAssignment_0()); 
            // InternalBug348427TestLanguage.g:4072:2: ( rule__Child2_6__NameAssignment_0 )
            // InternalBug348427TestLanguage.g:4072:3: rule__Child2_6__NameAssignment_0
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
    // InternalBug348427TestLanguage.g:4080:1: rule__Child2_6__Group__1 : rule__Child2_6__Group__1__Impl rule__Child2_6__Group__2 ;
    public final void rule__Child2_6__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4084:1: ( rule__Child2_6__Group__1__Impl rule__Child2_6__Group__2 )
            // InternalBug348427TestLanguage.g:4085:2: rule__Child2_6__Group__1__Impl rule__Child2_6__Group__2
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
    // InternalBug348427TestLanguage.g:4092:1: rule__Child2_6__Group__1__Impl : ( ':' ) ;
    public final void rule__Child2_6__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4096:1: ( ( ':' ) )
            // InternalBug348427TestLanguage.g:4097:1: ( ':' )
            {
            // InternalBug348427TestLanguage.g:4097:1: ( ':' )
            // InternalBug348427TestLanguage.g:4098:2: ':'
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
    // InternalBug348427TestLanguage.g:4107:1: rule__Child2_6__Group__2 : rule__Child2_6__Group__2__Impl rule__Child2_6__Group__3 ;
    public final void rule__Child2_6__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4111:1: ( rule__Child2_6__Group__2__Impl rule__Child2_6__Group__3 )
            // InternalBug348427TestLanguage.g:4112:2: rule__Child2_6__Group__2__Impl rule__Child2_6__Group__3
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
    // InternalBug348427TestLanguage.g:4119:1: rule__Child2_6__Group__2__Impl : ( ( rule__Child2_6__Group_2__0 )? ) ;
    public final void rule__Child2_6__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4123:1: ( ( ( rule__Child2_6__Group_2__0 )? ) )
            // InternalBug348427TestLanguage.g:4124:1: ( ( rule__Child2_6__Group_2__0 )? )
            {
            // InternalBug348427TestLanguage.g:4124:1: ( ( rule__Child2_6__Group_2__0 )? )
            // InternalBug348427TestLanguage.g:4125:2: ( rule__Child2_6__Group_2__0 )?
            {
             before(grammarAccess.getChild2_6Access().getGroup_2()); 
            // InternalBug348427TestLanguage.g:4126:2: ( rule__Child2_6__Group_2__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==32) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalBug348427TestLanguage.g:4126:3: rule__Child2_6__Group_2__0
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
    // InternalBug348427TestLanguage.g:4134:1: rule__Child2_6__Group__3 : rule__Child2_6__Group__3__Impl rule__Child2_6__Group__4 ;
    public final void rule__Child2_6__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4138:1: ( rule__Child2_6__Group__3__Impl rule__Child2_6__Group__4 )
            // InternalBug348427TestLanguage.g:4139:2: rule__Child2_6__Group__3__Impl rule__Child2_6__Group__4
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
    // InternalBug348427TestLanguage.g:4146:1: rule__Child2_6__Group__3__Impl : ( ( rule__Child2_6__Alternatives_3 ) ) ;
    public final void rule__Child2_6__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4150:1: ( ( ( rule__Child2_6__Alternatives_3 ) ) )
            // InternalBug348427TestLanguage.g:4151:1: ( ( rule__Child2_6__Alternatives_3 ) )
            {
            // InternalBug348427TestLanguage.g:4151:1: ( ( rule__Child2_6__Alternatives_3 ) )
            // InternalBug348427TestLanguage.g:4152:2: ( rule__Child2_6__Alternatives_3 )
            {
             before(grammarAccess.getChild2_6Access().getAlternatives_3()); 
            // InternalBug348427TestLanguage.g:4153:2: ( rule__Child2_6__Alternatives_3 )
            // InternalBug348427TestLanguage.g:4153:3: rule__Child2_6__Alternatives_3
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
    // InternalBug348427TestLanguage.g:4161:1: rule__Child2_6__Group__4 : rule__Child2_6__Group__4__Impl rule__Child2_6__Group__5 ;
    public final void rule__Child2_6__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4165:1: ( rule__Child2_6__Group__4__Impl rule__Child2_6__Group__5 )
            // InternalBug348427TestLanguage.g:4166:2: rule__Child2_6__Group__4__Impl rule__Child2_6__Group__5
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
    // InternalBug348427TestLanguage.g:4173:1: rule__Child2_6__Group__4__Impl : ( 'child3' ) ;
    public final void rule__Child2_6__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4177:1: ( ( 'child3' ) )
            // InternalBug348427TestLanguage.g:4178:1: ( 'child3' )
            {
            // InternalBug348427TestLanguage.g:4178:1: ( 'child3' )
            // InternalBug348427TestLanguage.g:4179:2: 'child3'
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
    // InternalBug348427TestLanguage.g:4188:1: rule__Child2_6__Group__5 : rule__Child2_6__Group__5__Impl ;
    public final void rule__Child2_6__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4192:1: ( rule__Child2_6__Group__5__Impl )
            // InternalBug348427TestLanguage.g:4193:2: rule__Child2_6__Group__5__Impl
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
    // InternalBug348427TestLanguage.g:4199:1: rule__Child2_6__Group__5__Impl : ( 'end' ) ;
    public final void rule__Child2_6__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4203:1: ( ( 'end' ) )
            // InternalBug348427TestLanguage.g:4204:1: ( 'end' )
            {
            // InternalBug348427TestLanguage.g:4204:1: ( 'end' )
            // InternalBug348427TestLanguage.g:4205:2: 'end'
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
    // InternalBug348427TestLanguage.g:4215:1: rule__Child2_6__Group_2__0 : rule__Child2_6__Group_2__0__Impl rule__Child2_6__Group_2__1 ;
    public final void rule__Child2_6__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4219:1: ( rule__Child2_6__Group_2__0__Impl rule__Child2_6__Group_2__1 )
            // InternalBug348427TestLanguage.g:4220:2: rule__Child2_6__Group_2__0__Impl rule__Child2_6__Group_2__1
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
    // InternalBug348427TestLanguage.g:4227:1: rule__Child2_6__Group_2__0__Impl : ( ( rule__Child2_6__BoolAssignment_2_0 ) ) ;
    public final void rule__Child2_6__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4231:1: ( ( ( rule__Child2_6__BoolAssignment_2_0 ) ) )
            // InternalBug348427TestLanguage.g:4232:1: ( ( rule__Child2_6__BoolAssignment_2_0 ) )
            {
            // InternalBug348427TestLanguage.g:4232:1: ( ( rule__Child2_6__BoolAssignment_2_0 ) )
            // InternalBug348427TestLanguage.g:4233:2: ( rule__Child2_6__BoolAssignment_2_0 )
            {
             before(grammarAccess.getChild2_6Access().getBoolAssignment_2_0()); 
            // InternalBug348427TestLanguage.g:4234:2: ( rule__Child2_6__BoolAssignment_2_0 )
            // InternalBug348427TestLanguage.g:4234:3: rule__Child2_6__BoolAssignment_2_0
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
    // InternalBug348427TestLanguage.g:4242:1: rule__Child2_6__Group_2__1 : rule__Child2_6__Group_2__1__Impl ;
    public final void rule__Child2_6__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4246:1: ( rule__Child2_6__Group_2__1__Impl )
            // InternalBug348427TestLanguage.g:4247:2: rule__Child2_6__Group_2__1__Impl
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
    // InternalBug348427TestLanguage.g:4253:1: rule__Child2_6__Group_2__1__Impl : ( 'keyword' ) ;
    public final void rule__Child2_6__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4257:1: ( ( 'keyword' ) )
            // InternalBug348427TestLanguage.g:4258:1: ( 'keyword' )
            {
            // InternalBug348427TestLanguage.g:4258:1: ( 'keyword' )
            // InternalBug348427TestLanguage.g:4259:2: 'keyword'
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
    // InternalBug348427TestLanguage.g:4269:1: rule__Model__Element1Assignment_0 : ( ruleScenario1_1 ) ;
    public final void rule__Model__Element1Assignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4273:1: ( ( ruleScenario1_1 ) )
            // InternalBug348427TestLanguage.g:4274:2: ( ruleScenario1_1 )
            {
            // InternalBug348427TestLanguage.g:4274:2: ( ruleScenario1_1 )
            // InternalBug348427TestLanguage.g:4275:3: ruleScenario1_1
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
    // InternalBug348427TestLanguage.g:4284:1: rule__Model__Element1Assignment_1 : ( ruleScenario1_2 ) ;
    public final void rule__Model__Element1Assignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4288:1: ( ( ruleScenario1_2 ) )
            // InternalBug348427TestLanguage.g:4289:2: ( ruleScenario1_2 )
            {
            // InternalBug348427TestLanguage.g:4289:2: ( ruleScenario1_2 )
            // InternalBug348427TestLanguage.g:4290:3: ruleScenario1_2
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
    // InternalBug348427TestLanguage.g:4299:1: rule__Model__Element1Assignment_2 : ( ruleScenario1_3 ) ;
    public final void rule__Model__Element1Assignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4303:1: ( ( ruleScenario1_3 ) )
            // InternalBug348427TestLanguage.g:4304:2: ( ruleScenario1_3 )
            {
            // InternalBug348427TestLanguage.g:4304:2: ( ruleScenario1_3 )
            // InternalBug348427TestLanguage.g:4305:3: ruleScenario1_3
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
    // InternalBug348427TestLanguage.g:4314:1: rule__Model__Element1Assignment_3 : ( ruleScenario1_4 ) ;
    public final void rule__Model__Element1Assignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4318:1: ( ( ruleScenario1_4 ) )
            // InternalBug348427TestLanguage.g:4319:2: ( ruleScenario1_4 )
            {
            // InternalBug348427TestLanguage.g:4319:2: ( ruleScenario1_4 )
            // InternalBug348427TestLanguage.g:4320:3: ruleScenario1_4
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
    // InternalBug348427TestLanguage.g:4329:1: rule__Model__Element2Assignment_4 : ( ruleScenario2_1 ) ;
    public final void rule__Model__Element2Assignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4333:1: ( ( ruleScenario2_1 ) )
            // InternalBug348427TestLanguage.g:4334:2: ( ruleScenario2_1 )
            {
            // InternalBug348427TestLanguage.g:4334:2: ( ruleScenario2_1 )
            // InternalBug348427TestLanguage.g:4335:3: ruleScenario2_1
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
    // InternalBug348427TestLanguage.g:4344:1: rule__Model__Element2Assignment_5 : ( ruleScenario2_2 ) ;
    public final void rule__Model__Element2Assignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4348:1: ( ( ruleScenario2_2 ) )
            // InternalBug348427TestLanguage.g:4349:2: ( ruleScenario2_2 )
            {
            // InternalBug348427TestLanguage.g:4349:2: ( ruleScenario2_2 )
            // InternalBug348427TestLanguage.g:4350:3: ruleScenario2_2
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
    // InternalBug348427TestLanguage.g:4359:1: rule__Model__Element2Assignment_6 : ( ruleScenario2_3 ) ;
    public final void rule__Model__Element2Assignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4363:1: ( ( ruleScenario2_3 ) )
            // InternalBug348427TestLanguage.g:4364:2: ( ruleScenario2_3 )
            {
            // InternalBug348427TestLanguage.g:4364:2: ( ruleScenario2_3 )
            // InternalBug348427TestLanguage.g:4365:3: ruleScenario2_3
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
    // InternalBug348427TestLanguage.g:4374:1: rule__Model__Element2Assignment_7 : ( ruleScenario2_4 ) ;
    public final void rule__Model__Element2Assignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4378:1: ( ( ruleScenario2_4 ) )
            // InternalBug348427TestLanguage.g:4379:2: ( ruleScenario2_4 )
            {
            // InternalBug348427TestLanguage.g:4379:2: ( ruleScenario2_4 )
            // InternalBug348427TestLanguage.g:4380:3: ruleScenario2_4
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
    // InternalBug348427TestLanguage.g:4389:1: rule__Model__Element2Assignment_8 : ( ruleScenario2_5 ) ;
    public final void rule__Model__Element2Assignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4393:1: ( ( ruleScenario2_5 ) )
            // InternalBug348427TestLanguage.g:4394:2: ( ruleScenario2_5 )
            {
            // InternalBug348427TestLanguage.g:4394:2: ( ruleScenario2_5 )
            // InternalBug348427TestLanguage.g:4395:3: ruleScenario2_5
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
    // InternalBug348427TestLanguage.g:4404:1: rule__Model__Element2Assignment_9 : ( ruleScenario2_6 ) ;
    public final void rule__Model__Element2Assignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4408:1: ( ( ruleScenario2_6 ) )
            // InternalBug348427TestLanguage.g:4409:2: ( ruleScenario2_6 )
            {
            // InternalBug348427TestLanguage.g:4409:2: ( ruleScenario2_6 )
            // InternalBug348427TestLanguage.g:4410:3: ruleScenario2_6
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
    // InternalBug348427TestLanguage.g:4419:1: rule__Model__Element2Assignment_10 : ( ruleScenario2_7 ) ;
    public final void rule__Model__Element2Assignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4423:1: ( ( ruleScenario2_7 ) )
            // InternalBug348427TestLanguage.g:4424:2: ( ruleScenario2_7 )
            {
            // InternalBug348427TestLanguage.g:4424:2: ( ruleScenario2_7 )
            // InternalBug348427TestLanguage.g:4425:3: ruleScenario2_7
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
    // InternalBug348427TestLanguage.g:4434:1: rule__Model__Element2Assignment_11 : ( ruleScenario2_8 ) ;
    public final void rule__Model__Element2Assignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4438:1: ( ( ruleScenario2_8 ) )
            // InternalBug348427TestLanguage.g:4439:2: ( ruleScenario2_8 )
            {
            // InternalBug348427TestLanguage.g:4439:2: ( ruleScenario2_8 )
            // InternalBug348427TestLanguage.g:4440:3: ruleScenario2_8
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
    // InternalBug348427TestLanguage.g:4449:1: rule__Scenario1_1__ChildAssignment_1_0 : ( ruleChild1_1 ) ;
    public final void rule__Scenario1_1__ChildAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4453:1: ( ( ruleChild1_1 ) )
            // InternalBug348427TestLanguage.g:4454:2: ( ruleChild1_1 )
            {
            // InternalBug348427TestLanguage.g:4454:2: ( ruleChild1_1 )
            // InternalBug348427TestLanguage.g:4455:3: ruleChild1_1
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
    // InternalBug348427TestLanguage.g:4464:1: rule__Scenario1_1__ChildAssignment_1_1 : ( ruleChild1_2 ) ;
    public final void rule__Scenario1_1__ChildAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4468:1: ( ( ruleChild1_2 ) )
            // InternalBug348427TestLanguage.g:4469:2: ( ruleChild1_2 )
            {
            // InternalBug348427TestLanguage.g:4469:2: ( ruleChild1_2 )
            // InternalBug348427TestLanguage.g:4470:3: ruleChild1_2
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
    // InternalBug348427TestLanguage.g:4479:1: rule__Scenario1_1__ChildAssignment_1_2 : ( ruleChild1_3 ) ;
    public final void rule__Scenario1_1__ChildAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4483:1: ( ( ruleChild1_3 ) )
            // InternalBug348427TestLanguage.g:4484:2: ( ruleChild1_3 )
            {
            // InternalBug348427TestLanguage.g:4484:2: ( ruleChild1_3 )
            // InternalBug348427TestLanguage.g:4485:3: ruleChild1_3
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
    // InternalBug348427TestLanguage.g:4494:1: rule__Scenario1_2__ChildAssignment_1_0 : ( ruleChild1_1 ) ;
    public final void rule__Scenario1_2__ChildAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4498:1: ( ( ruleChild1_1 ) )
            // InternalBug348427TestLanguage.g:4499:2: ( ruleChild1_1 )
            {
            // InternalBug348427TestLanguage.g:4499:2: ( ruleChild1_1 )
            // InternalBug348427TestLanguage.g:4500:3: ruleChild1_1
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
    // InternalBug348427TestLanguage.g:4509:1: rule__Scenario1_2__ChildAssignment_1_1 : ( ruleChild1_2 ) ;
    public final void rule__Scenario1_2__ChildAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4513:1: ( ( ruleChild1_2 ) )
            // InternalBug348427TestLanguage.g:4514:2: ( ruleChild1_2 )
            {
            // InternalBug348427TestLanguage.g:4514:2: ( ruleChild1_2 )
            // InternalBug348427TestLanguage.g:4515:3: ruleChild1_2
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
    // InternalBug348427TestLanguage.g:4524:1: rule__Scenario1_2__ChildAssignment_1_2 : ( ruleChild1_3 ) ;
    public final void rule__Scenario1_2__ChildAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4528:1: ( ( ruleChild1_3 ) )
            // InternalBug348427TestLanguage.g:4529:2: ( ruleChild1_3 )
            {
            // InternalBug348427TestLanguage.g:4529:2: ( ruleChild1_3 )
            // InternalBug348427TestLanguage.g:4530:3: ruleChild1_3
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
    // InternalBug348427TestLanguage.g:4539:1: rule__Scenario1_3__ChildAssignment_2_0 : ( ruleChild1_1 ) ;
    public final void rule__Scenario1_3__ChildAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4543:1: ( ( ruleChild1_1 ) )
            // InternalBug348427TestLanguage.g:4544:2: ( ruleChild1_1 )
            {
            // InternalBug348427TestLanguage.g:4544:2: ( ruleChild1_1 )
            // InternalBug348427TestLanguage.g:4545:3: ruleChild1_1
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
    // InternalBug348427TestLanguage.g:4554:1: rule__Scenario1_3__ChildAssignment_2_1 : ( ruleChild1_2 ) ;
    public final void rule__Scenario1_3__ChildAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4558:1: ( ( ruleChild1_2 ) )
            // InternalBug348427TestLanguage.g:4559:2: ( ruleChild1_2 )
            {
            // InternalBug348427TestLanguage.g:4559:2: ( ruleChild1_2 )
            // InternalBug348427TestLanguage.g:4560:3: ruleChild1_2
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
    // InternalBug348427TestLanguage.g:4569:1: rule__Scenario1_3__ChildAssignment_2_2 : ( ruleChild1_3 ) ;
    public final void rule__Scenario1_3__ChildAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4573:1: ( ( ruleChild1_3 ) )
            // InternalBug348427TestLanguage.g:4574:2: ( ruleChild1_3 )
            {
            // InternalBug348427TestLanguage.g:4574:2: ( ruleChild1_3 )
            // InternalBug348427TestLanguage.g:4575:3: ruleChild1_3
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
    // InternalBug348427TestLanguage.g:4584:1: rule__Scenario1_4__ChildAssignment_2_0 : ( ruleChild1_1 ) ;
    public final void rule__Scenario1_4__ChildAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4588:1: ( ( ruleChild1_1 ) )
            // InternalBug348427TestLanguage.g:4589:2: ( ruleChild1_1 )
            {
            // InternalBug348427TestLanguage.g:4589:2: ( ruleChild1_1 )
            // InternalBug348427TestLanguage.g:4590:3: ruleChild1_1
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
    // InternalBug348427TestLanguage.g:4599:1: rule__Scenario1_4__ChildAssignment_2_1 : ( ruleChild1_2 ) ;
    public final void rule__Scenario1_4__ChildAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4603:1: ( ( ruleChild1_2 ) )
            // InternalBug348427TestLanguage.g:4604:2: ( ruleChild1_2 )
            {
            // InternalBug348427TestLanguage.g:4604:2: ( ruleChild1_2 )
            // InternalBug348427TestLanguage.g:4605:3: ruleChild1_2
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
    // InternalBug348427TestLanguage.g:4614:1: rule__Scenario1_4__ChildAssignment_2_2 : ( ruleChild1_3 ) ;
    public final void rule__Scenario1_4__ChildAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4618:1: ( ( ruleChild1_3 ) )
            // InternalBug348427TestLanguage.g:4619:2: ( ruleChild1_3 )
            {
            // InternalBug348427TestLanguage.g:4619:2: ( ruleChild1_3 )
            // InternalBug348427TestLanguage.g:4620:3: ruleChild1_3
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
    // InternalBug348427TestLanguage.g:4629:1: rule__Child1_1__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Child1_1__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4633:1: ( ( RULE_ID ) )
            // InternalBug348427TestLanguage.g:4634:2: ( RULE_ID )
            {
            // InternalBug348427TestLanguage.g:4634:2: ( RULE_ID )
            // InternalBug348427TestLanguage.g:4635:3: RULE_ID
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
    // InternalBug348427TestLanguage.g:4644:1: rule__Child1_1__BoolAssignment_2_0 : ( ( 'bool' ) ) ;
    public final void rule__Child1_1__BoolAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4648:1: ( ( ( 'bool' ) ) )
            // InternalBug348427TestLanguage.g:4649:2: ( ( 'bool' ) )
            {
            // InternalBug348427TestLanguage.g:4649:2: ( ( 'bool' ) )
            // InternalBug348427TestLanguage.g:4650:3: ( 'bool' )
            {
             before(grammarAccess.getChild1_1Access().getBoolBoolKeyword_2_0_0()); 
            // InternalBug348427TestLanguage.g:4651:3: ( 'bool' )
            // InternalBug348427TestLanguage.g:4652:4: 'bool'
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
    // InternalBug348427TestLanguage.g:4663:1: rule__Child1_1__EnumTypeAssignment_3 : ( ruleEnumType ) ;
    public final void rule__Child1_1__EnumTypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4667:1: ( ( ruleEnumType ) )
            // InternalBug348427TestLanguage.g:4668:2: ( ruleEnumType )
            {
            // InternalBug348427TestLanguage.g:4668:2: ( ruleEnumType )
            // InternalBug348427TestLanguage.g:4669:3: ruleEnumType
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
    // InternalBug348427TestLanguage.g:4678:1: rule__Child1_2__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Child1_2__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4682:1: ( ( RULE_ID ) )
            // InternalBug348427TestLanguage.g:4683:2: ( RULE_ID )
            {
            // InternalBug348427TestLanguage.g:4683:2: ( RULE_ID )
            // InternalBug348427TestLanguage.g:4684:3: RULE_ID
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
    // InternalBug348427TestLanguage.g:4693:1: rule__Child1_2__BoolAssignment_2_0 : ( ( 'bool' ) ) ;
    public final void rule__Child1_2__BoolAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4697:1: ( ( ( 'bool' ) ) )
            // InternalBug348427TestLanguage.g:4698:2: ( ( 'bool' ) )
            {
            // InternalBug348427TestLanguage.g:4698:2: ( ( 'bool' ) )
            // InternalBug348427TestLanguage.g:4699:3: ( 'bool' )
            {
             before(grammarAccess.getChild1_2Access().getBoolBoolKeyword_2_0_0()); 
            // InternalBug348427TestLanguage.g:4700:3: ( 'bool' )
            // InternalBug348427TestLanguage.g:4701:4: 'bool'
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
    // InternalBug348427TestLanguage.g:4712:1: rule__Child1_2__EnumTypeAssignment_3 : ( ruleEnumType ) ;
    public final void rule__Child1_2__EnumTypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4716:1: ( ( ruleEnumType ) )
            // InternalBug348427TestLanguage.g:4717:2: ( ruleEnumType )
            {
            // InternalBug348427TestLanguage.g:4717:2: ( ruleEnumType )
            // InternalBug348427TestLanguage.g:4718:3: ruleEnumType
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
    // InternalBug348427TestLanguage.g:4727:1: rule__Child1_3__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Child1_3__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4731:1: ( ( RULE_ID ) )
            // InternalBug348427TestLanguage.g:4732:2: ( RULE_ID )
            {
            // InternalBug348427TestLanguage.g:4732:2: ( RULE_ID )
            // InternalBug348427TestLanguage.g:4733:3: RULE_ID
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
    // InternalBug348427TestLanguage.g:4742:1: rule__Child1_3__BoolAssignment_2_0 : ( ( 'bool' ) ) ;
    public final void rule__Child1_3__BoolAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4746:1: ( ( ( 'bool' ) ) )
            // InternalBug348427TestLanguage.g:4747:2: ( ( 'bool' ) )
            {
            // InternalBug348427TestLanguage.g:4747:2: ( ( 'bool' ) )
            // InternalBug348427TestLanguage.g:4748:3: ( 'bool' )
            {
             before(grammarAccess.getChild1_3Access().getBoolBoolKeyword_2_0_0()); 
            // InternalBug348427TestLanguage.g:4749:3: ( 'bool' )
            // InternalBug348427TestLanguage.g:4750:4: 'bool'
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
    // InternalBug348427TestLanguage.g:4761:1: rule__Child1_3__EnumTypeAssignment_3 : ( ruleEnumType ) ;
    public final void rule__Child1_3__EnumTypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4765:1: ( ( ruleEnumType ) )
            // InternalBug348427TestLanguage.g:4766:2: ( ruleEnumType )
            {
            // InternalBug348427TestLanguage.g:4766:2: ( ruleEnumType )
            // InternalBug348427TestLanguage.g:4767:3: ruleEnumType
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
    // InternalBug348427TestLanguage.g:4776:1: rule__Scenario2_1__ChildAssignment_1_0 : ( ruleChild2_1 ) ;
    public final void rule__Scenario2_1__ChildAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4780:1: ( ( ruleChild2_1 ) )
            // InternalBug348427TestLanguage.g:4781:2: ( ruleChild2_1 )
            {
            // InternalBug348427TestLanguage.g:4781:2: ( ruleChild2_1 )
            // InternalBug348427TestLanguage.g:4782:3: ruleChild2_1
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
    // InternalBug348427TestLanguage.g:4791:1: rule__Scenario2_1__ChildAssignment_1_1 : ( ruleChild2_2 ) ;
    public final void rule__Scenario2_1__ChildAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4795:1: ( ( ruleChild2_2 ) )
            // InternalBug348427TestLanguage.g:4796:2: ( ruleChild2_2 )
            {
            // InternalBug348427TestLanguage.g:4796:2: ( ruleChild2_2 )
            // InternalBug348427TestLanguage.g:4797:3: ruleChild2_2
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
    // InternalBug348427TestLanguage.g:4806:1: rule__Scenario2_1__ChildAssignment_1_2 : ( ruleChild2_3 ) ;
    public final void rule__Scenario2_1__ChildAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4810:1: ( ( ruleChild2_3 ) )
            // InternalBug348427TestLanguage.g:4811:2: ( ruleChild2_3 )
            {
            // InternalBug348427TestLanguage.g:4811:2: ( ruleChild2_3 )
            // InternalBug348427TestLanguage.g:4812:3: ruleChild2_3
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
    // InternalBug348427TestLanguage.g:4821:1: rule__Scenario2_2__ChildAssignment_1_0 : ( ruleChild2_1 ) ;
    public final void rule__Scenario2_2__ChildAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4825:1: ( ( ruleChild2_1 ) )
            // InternalBug348427TestLanguage.g:4826:2: ( ruleChild2_1 )
            {
            // InternalBug348427TestLanguage.g:4826:2: ( ruleChild2_1 )
            // InternalBug348427TestLanguage.g:4827:3: ruleChild2_1
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
    // InternalBug348427TestLanguage.g:4836:1: rule__Scenario2_2__ChildAssignment_1_1 : ( ruleChild2_2 ) ;
    public final void rule__Scenario2_2__ChildAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4840:1: ( ( ruleChild2_2 ) )
            // InternalBug348427TestLanguage.g:4841:2: ( ruleChild2_2 )
            {
            // InternalBug348427TestLanguage.g:4841:2: ( ruleChild2_2 )
            // InternalBug348427TestLanguage.g:4842:3: ruleChild2_2
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
    // InternalBug348427TestLanguage.g:4851:1: rule__Scenario2_2__ChildAssignment_1_2 : ( ruleChild2_3 ) ;
    public final void rule__Scenario2_2__ChildAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4855:1: ( ( ruleChild2_3 ) )
            // InternalBug348427TestLanguage.g:4856:2: ( ruleChild2_3 )
            {
            // InternalBug348427TestLanguage.g:4856:2: ( ruleChild2_3 )
            // InternalBug348427TestLanguage.g:4857:3: ruleChild2_3
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
    // InternalBug348427TestLanguage.g:4866:1: rule__Scenario2_3__ChildAssignment_1_0 : ( ruleChild2_4 ) ;
    public final void rule__Scenario2_3__ChildAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4870:1: ( ( ruleChild2_4 ) )
            // InternalBug348427TestLanguage.g:4871:2: ( ruleChild2_4 )
            {
            // InternalBug348427TestLanguage.g:4871:2: ( ruleChild2_4 )
            // InternalBug348427TestLanguage.g:4872:3: ruleChild2_4
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
    // InternalBug348427TestLanguage.g:4881:1: rule__Scenario2_3__ChildAssignment_1_1 : ( ruleChild2_5 ) ;
    public final void rule__Scenario2_3__ChildAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4885:1: ( ( ruleChild2_5 ) )
            // InternalBug348427TestLanguage.g:4886:2: ( ruleChild2_5 )
            {
            // InternalBug348427TestLanguage.g:4886:2: ( ruleChild2_5 )
            // InternalBug348427TestLanguage.g:4887:3: ruleChild2_5
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
    // InternalBug348427TestLanguage.g:4896:1: rule__Scenario2_3__ChildAssignment_1_2 : ( ruleChild2_6 ) ;
    public final void rule__Scenario2_3__ChildAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4900:1: ( ( ruleChild2_6 ) )
            // InternalBug348427TestLanguage.g:4901:2: ( ruleChild2_6 )
            {
            // InternalBug348427TestLanguage.g:4901:2: ( ruleChild2_6 )
            // InternalBug348427TestLanguage.g:4902:3: ruleChild2_6
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
    // InternalBug348427TestLanguage.g:4911:1: rule__Scenario2_4__ChildAssignment_1_0 : ( ruleChild2_4 ) ;
    public final void rule__Scenario2_4__ChildAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4915:1: ( ( ruleChild2_4 ) )
            // InternalBug348427TestLanguage.g:4916:2: ( ruleChild2_4 )
            {
            // InternalBug348427TestLanguage.g:4916:2: ( ruleChild2_4 )
            // InternalBug348427TestLanguage.g:4917:3: ruleChild2_4
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
    // InternalBug348427TestLanguage.g:4926:1: rule__Scenario2_4__ChildAssignment_1_1 : ( ruleChild2_5 ) ;
    public final void rule__Scenario2_4__ChildAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4930:1: ( ( ruleChild2_5 ) )
            // InternalBug348427TestLanguage.g:4931:2: ( ruleChild2_5 )
            {
            // InternalBug348427TestLanguage.g:4931:2: ( ruleChild2_5 )
            // InternalBug348427TestLanguage.g:4932:3: ruleChild2_5
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
    // InternalBug348427TestLanguage.g:4941:1: rule__Scenario2_4__ChildAssignment_1_2 : ( ruleChild2_6 ) ;
    public final void rule__Scenario2_4__ChildAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4945:1: ( ( ruleChild2_6 ) )
            // InternalBug348427TestLanguage.g:4946:2: ( ruleChild2_6 )
            {
            // InternalBug348427TestLanguage.g:4946:2: ( ruleChild2_6 )
            // InternalBug348427TestLanguage.g:4947:3: ruleChild2_6
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
    // InternalBug348427TestLanguage.g:4956:1: rule__Scenario2_5__ChildAssignment_2_0 : ( ruleChild2_1 ) ;
    public final void rule__Scenario2_5__ChildAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4960:1: ( ( ruleChild2_1 ) )
            // InternalBug348427TestLanguage.g:4961:2: ( ruleChild2_1 )
            {
            // InternalBug348427TestLanguage.g:4961:2: ( ruleChild2_1 )
            // InternalBug348427TestLanguage.g:4962:3: ruleChild2_1
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
    // InternalBug348427TestLanguage.g:4971:1: rule__Scenario2_5__ChildAssignment_2_1 : ( ruleChild2_2 ) ;
    public final void rule__Scenario2_5__ChildAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4975:1: ( ( ruleChild2_2 ) )
            // InternalBug348427TestLanguage.g:4976:2: ( ruleChild2_2 )
            {
            // InternalBug348427TestLanguage.g:4976:2: ( ruleChild2_2 )
            // InternalBug348427TestLanguage.g:4977:3: ruleChild2_2
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
    // InternalBug348427TestLanguage.g:4986:1: rule__Scenario2_5__ChildAssignment_2_2 : ( ruleChild2_3 ) ;
    public final void rule__Scenario2_5__ChildAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:4990:1: ( ( ruleChild2_3 ) )
            // InternalBug348427TestLanguage.g:4991:2: ( ruleChild2_3 )
            {
            // InternalBug348427TestLanguage.g:4991:2: ( ruleChild2_3 )
            // InternalBug348427TestLanguage.g:4992:3: ruleChild2_3
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
    // InternalBug348427TestLanguage.g:5001:1: rule__Scenario2_6__ChildAssignment_2_0 : ( ruleChild2_1 ) ;
    public final void rule__Scenario2_6__ChildAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5005:1: ( ( ruleChild2_1 ) )
            // InternalBug348427TestLanguage.g:5006:2: ( ruleChild2_1 )
            {
            // InternalBug348427TestLanguage.g:5006:2: ( ruleChild2_1 )
            // InternalBug348427TestLanguage.g:5007:3: ruleChild2_1
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
    // InternalBug348427TestLanguage.g:5016:1: rule__Scenario2_6__ChildAssignment_2_1 : ( ruleChild2_2 ) ;
    public final void rule__Scenario2_6__ChildAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5020:1: ( ( ruleChild2_2 ) )
            // InternalBug348427TestLanguage.g:5021:2: ( ruleChild2_2 )
            {
            // InternalBug348427TestLanguage.g:5021:2: ( ruleChild2_2 )
            // InternalBug348427TestLanguage.g:5022:3: ruleChild2_2
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
    // InternalBug348427TestLanguage.g:5031:1: rule__Scenario2_6__ChildAssignment_2_2 : ( ruleChild2_3 ) ;
    public final void rule__Scenario2_6__ChildAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5035:1: ( ( ruleChild2_3 ) )
            // InternalBug348427TestLanguage.g:5036:2: ( ruleChild2_3 )
            {
            // InternalBug348427TestLanguage.g:5036:2: ( ruleChild2_3 )
            // InternalBug348427TestLanguage.g:5037:3: ruleChild2_3
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
    // InternalBug348427TestLanguage.g:5046:1: rule__Scenario2_7__ChildAssignment_2_0 : ( ruleChild2_4 ) ;
    public final void rule__Scenario2_7__ChildAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5050:1: ( ( ruleChild2_4 ) )
            // InternalBug348427TestLanguage.g:5051:2: ( ruleChild2_4 )
            {
            // InternalBug348427TestLanguage.g:5051:2: ( ruleChild2_4 )
            // InternalBug348427TestLanguage.g:5052:3: ruleChild2_4
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
    // InternalBug348427TestLanguage.g:5061:1: rule__Scenario2_7__ChildAssignment_2_1 : ( ruleChild2_5 ) ;
    public final void rule__Scenario2_7__ChildAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5065:1: ( ( ruleChild2_5 ) )
            // InternalBug348427TestLanguage.g:5066:2: ( ruleChild2_5 )
            {
            // InternalBug348427TestLanguage.g:5066:2: ( ruleChild2_5 )
            // InternalBug348427TestLanguage.g:5067:3: ruleChild2_5
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
    // InternalBug348427TestLanguage.g:5076:1: rule__Scenario2_7__ChildAssignment_2_2 : ( ruleChild2_6 ) ;
    public final void rule__Scenario2_7__ChildAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5080:1: ( ( ruleChild2_6 ) )
            // InternalBug348427TestLanguage.g:5081:2: ( ruleChild2_6 )
            {
            // InternalBug348427TestLanguage.g:5081:2: ( ruleChild2_6 )
            // InternalBug348427TestLanguage.g:5082:3: ruleChild2_6
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
    // InternalBug348427TestLanguage.g:5091:1: rule__Scenario2_8__ChildAssignment_2_0 : ( ruleChild2_4 ) ;
    public final void rule__Scenario2_8__ChildAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5095:1: ( ( ruleChild2_4 ) )
            // InternalBug348427TestLanguage.g:5096:2: ( ruleChild2_4 )
            {
            // InternalBug348427TestLanguage.g:5096:2: ( ruleChild2_4 )
            // InternalBug348427TestLanguage.g:5097:3: ruleChild2_4
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
    // InternalBug348427TestLanguage.g:5106:1: rule__Scenario2_8__ChildAssignment_2_1 : ( ruleChild2_5 ) ;
    public final void rule__Scenario2_8__ChildAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5110:1: ( ( ruleChild2_5 ) )
            // InternalBug348427TestLanguage.g:5111:2: ( ruleChild2_5 )
            {
            // InternalBug348427TestLanguage.g:5111:2: ( ruleChild2_5 )
            // InternalBug348427TestLanguage.g:5112:3: ruleChild2_5
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
    // InternalBug348427TestLanguage.g:5121:1: rule__Scenario2_8__ChildAssignment_2_2 : ( ruleChild2_6 ) ;
    public final void rule__Scenario2_8__ChildAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5125:1: ( ( ruleChild2_6 ) )
            // InternalBug348427TestLanguage.g:5126:2: ( ruleChild2_6 )
            {
            // InternalBug348427TestLanguage.g:5126:2: ( ruleChild2_6 )
            // InternalBug348427TestLanguage.g:5127:3: ruleChild2_6
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
    // InternalBug348427TestLanguage.g:5136:1: rule__Child2_1__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Child2_1__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5140:1: ( ( RULE_ID ) )
            // InternalBug348427TestLanguage.g:5141:2: ( RULE_ID )
            {
            // InternalBug348427TestLanguage.g:5141:2: ( RULE_ID )
            // InternalBug348427TestLanguage.g:5142:3: RULE_ID
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
    // InternalBug348427TestLanguage.g:5151:1: rule__Child2_1__BoolAssignment_2_0 : ( ( 'bool' ) ) ;
    public final void rule__Child2_1__BoolAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5155:1: ( ( ( 'bool' ) ) )
            // InternalBug348427TestLanguage.g:5156:2: ( ( 'bool' ) )
            {
            // InternalBug348427TestLanguage.g:5156:2: ( ( 'bool' ) )
            // InternalBug348427TestLanguage.g:5157:3: ( 'bool' )
            {
             before(grammarAccess.getChild2_1Access().getBoolBoolKeyword_2_0_0()); 
            // InternalBug348427TestLanguage.g:5158:3: ( 'bool' )
            // InternalBug348427TestLanguage.g:5159:4: 'bool'
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
    // InternalBug348427TestLanguage.g:5170:1: rule__Child2_1__StringAssignment_3 : ( ( rule__Child2_1__StringAlternatives_3_0 ) ) ;
    public final void rule__Child2_1__StringAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5174:1: ( ( ( rule__Child2_1__StringAlternatives_3_0 ) ) )
            // InternalBug348427TestLanguage.g:5175:2: ( ( rule__Child2_1__StringAlternatives_3_0 ) )
            {
            // InternalBug348427TestLanguage.g:5175:2: ( ( rule__Child2_1__StringAlternatives_3_0 ) )
            // InternalBug348427TestLanguage.g:5176:3: ( rule__Child2_1__StringAlternatives_3_0 )
            {
             before(grammarAccess.getChild2_1Access().getStringAlternatives_3_0()); 
            // InternalBug348427TestLanguage.g:5177:3: ( rule__Child2_1__StringAlternatives_3_0 )
            // InternalBug348427TestLanguage.g:5177:4: rule__Child2_1__StringAlternatives_3_0
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
    // InternalBug348427TestLanguage.g:5185:1: rule__Child2_2__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Child2_2__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5189:1: ( ( RULE_ID ) )
            // InternalBug348427TestLanguage.g:5190:2: ( RULE_ID )
            {
            // InternalBug348427TestLanguage.g:5190:2: ( RULE_ID )
            // InternalBug348427TestLanguage.g:5191:3: RULE_ID
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
    // InternalBug348427TestLanguage.g:5200:1: rule__Child2_2__BoolAssignment_2_0 : ( ( 'bool' ) ) ;
    public final void rule__Child2_2__BoolAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5204:1: ( ( ( 'bool' ) ) )
            // InternalBug348427TestLanguage.g:5205:2: ( ( 'bool' ) )
            {
            // InternalBug348427TestLanguage.g:5205:2: ( ( 'bool' ) )
            // InternalBug348427TestLanguage.g:5206:3: ( 'bool' )
            {
             before(grammarAccess.getChild2_2Access().getBoolBoolKeyword_2_0_0()); 
            // InternalBug348427TestLanguage.g:5207:3: ( 'bool' )
            // InternalBug348427TestLanguage.g:5208:4: 'bool'
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
    // InternalBug348427TestLanguage.g:5219:1: rule__Child2_2__StringAssignment_3 : ( ( rule__Child2_2__StringAlternatives_3_0 ) ) ;
    public final void rule__Child2_2__StringAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5223:1: ( ( ( rule__Child2_2__StringAlternatives_3_0 ) ) )
            // InternalBug348427TestLanguage.g:5224:2: ( ( rule__Child2_2__StringAlternatives_3_0 ) )
            {
            // InternalBug348427TestLanguage.g:5224:2: ( ( rule__Child2_2__StringAlternatives_3_0 ) )
            // InternalBug348427TestLanguage.g:5225:3: ( rule__Child2_2__StringAlternatives_3_0 )
            {
             before(grammarAccess.getChild2_2Access().getStringAlternatives_3_0()); 
            // InternalBug348427TestLanguage.g:5226:3: ( rule__Child2_2__StringAlternatives_3_0 )
            // InternalBug348427TestLanguage.g:5226:4: rule__Child2_2__StringAlternatives_3_0
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
    // InternalBug348427TestLanguage.g:5234:1: rule__Child2_3__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Child2_3__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5238:1: ( ( RULE_ID ) )
            // InternalBug348427TestLanguage.g:5239:2: ( RULE_ID )
            {
            // InternalBug348427TestLanguage.g:5239:2: ( RULE_ID )
            // InternalBug348427TestLanguage.g:5240:3: RULE_ID
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
    // InternalBug348427TestLanguage.g:5249:1: rule__Child2_3__BoolAssignment_2_0 : ( ( 'bool' ) ) ;
    public final void rule__Child2_3__BoolAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5253:1: ( ( ( 'bool' ) ) )
            // InternalBug348427TestLanguage.g:5254:2: ( ( 'bool' ) )
            {
            // InternalBug348427TestLanguage.g:5254:2: ( ( 'bool' ) )
            // InternalBug348427TestLanguage.g:5255:3: ( 'bool' )
            {
             before(grammarAccess.getChild2_3Access().getBoolBoolKeyword_2_0_0()); 
            // InternalBug348427TestLanguage.g:5256:3: ( 'bool' )
            // InternalBug348427TestLanguage.g:5257:4: 'bool'
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
    // InternalBug348427TestLanguage.g:5268:1: rule__Child2_3__StringAssignment_3 : ( ( rule__Child2_3__StringAlternatives_3_0 ) ) ;
    public final void rule__Child2_3__StringAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5272:1: ( ( ( rule__Child2_3__StringAlternatives_3_0 ) ) )
            // InternalBug348427TestLanguage.g:5273:2: ( ( rule__Child2_3__StringAlternatives_3_0 ) )
            {
            // InternalBug348427TestLanguage.g:5273:2: ( ( rule__Child2_3__StringAlternatives_3_0 ) )
            // InternalBug348427TestLanguage.g:5274:3: ( rule__Child2_3__StringAlternatives_3_0 )
            {
             before(grammarAccess.getChild2_3Access().getStringAlternatives_3_0()); 
            // InternalBug348427TestLanguage.g:5275:3: ( rule__Child2_3__StringAlternatives_3_0 )
            // InternalBug348427TestLanguage.g:5275:4: rule__Child2_3__StringAlternatives_3_0
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
    // InternalBug348427TestLanguage.g:5283:1: rule__Child2_4__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Child2_4__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5287:1: ( ( RULE_ID ) )
            // InternalBug348427TestLanguage.g:5288:2: ( RULE_ID )
            {
            // InternalBug348427TestLanguage.g:5288:2: ( RULE_ID )
            // InternalBug348427TestLanguage.g:5289:3: RULE_ID
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
    // InternalBug348427TestLanguage.g:5298:1: rule__Child2_4__BoolAssignment_2_0 : ( ( 'bool' ) ) ;
    public final void rule__Child2_4__BoolAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5302:1: ( ( ( 'bool' ) ) )
            // InternalBug348427TestLanguage.g:5303:2: ( ( 'bool' ) )
            {
            // InternalBug348427TestLanguage.g:5303:2: ( ( 'bool' ) )
            // InternalBug348427TestLanguage.g:5304:3: ( 'bool' )
            {
             before(grammarAccess.getChild2_4Access().getBoolBoolKeyword_2_0_0()); 
            // InternalBug348427TestLanguage.g:5305:3: ( 'bool' )
            // InternalBug348427TestLanguage.g:5306:4: 'bool'
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
    // InternalBug348427TestLanguage.g:5317:1: rule__Child2_4__StringAssignment_3_0 : ( ( 'a' ) ) ;
    public final void rule__Child2_4__StringAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5321:1: ( ( ( 'a' ) ) )
            // InternalBug348427TestLanguage.g:5322:2: ( ( 'a' ) )
            {
            // InternalBug348427TestLanguage.g:5322:2: ( ( 'a' ) )
            // InternalBug348427TestLanguage.g:5323:3: ( 'a' )
            {
             before(grammarAccess.getChild2_4Access().getStringAKeyword_3_0_0()); 
            // InternalBug348427TestLanguage.g:5324:3: ( 'a' )
            // InternalBug348427TestLanguage.g:5325:4: 'a'
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
    // InternalBug348427TestLanguage.g:5336:1: rule__Child2_4__StringAssignment_3_1 : ( ( 'b' ) ) ;
    public final void rule__Child2_4__StringAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5340:1: ( ( ( 'b' ) ) )
            // InternalBug348427TestLanguage.g:5341:2: ( ( 'b' ) )
            {
            // InternalBug348427TestLanguage.g:5341:2: ( ( 'b' ) )
            // InternalBug348427TestLanguage.g:5342:3: ( 'b' )
            {
             before(grammarAccess.getChild2_4Access().getStringBKeyword_3_1_0()); 
            // InternalBug348427TestLanguage.g:5343:3: ( 'b' )
            // InternalBug348427TestLanguage.g:5344:4: 'b'
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
    // InternalBug348427TestLanguage.g:5355:1: rule__Child2_5__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Child2_5__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5359:1: ( ( RULE_ID ) )
            // InternalBug348427TestLanguage.g:5360:2: ( RULE_ID )
            {
            // InternalBug348427TestLanguage.g:5360:2: ( RULE_ID )
            // InternalBug348427TestLanguage.g:5361:3: RULE_ID
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
    // InternalBug348427TestLanguage.g:5370:1: rule__Child2_5__BoolAssignment_2_0 : ( ( 'bool' ) ) ;
    public final void rule__Child2_5__BoolAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5374:1: ( ( ( 'bool' ) ) )
            // InternalBug348427TestLanguage.g:5375:2: ( ( 'bool' ) )
            {
            // InternalBug348427TestLanguage.g:5375:2: ( ( 'bool' ) )
            // InternalBug348427TestLanguage.g:5376:3: ( 'bool' )
            {
             before(grammarAccess.getChild2_5Access().getBoolBoolKeyword_2_0_0()); 
            // InternalBug348427TestLanguage.g:5377:3: ( 'bool' )
            // InternalBug348427TestLanguage.g:5378:4: 'bool'
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
    // InternalBug348427TestLanguage.g:5389:1: rule__Child2_5__StringAssignment_3_0 : ( ( 'a' ) ) ;
    public final void rule__Child2_5__StringAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5393:1: ( ( ( 'a' ) ) )
            // InternalBug348427TestLanguage.g:5394:2: ( ( 'a' ) )
            {
            // InternalBug348427TestLanguage.g:5394:2: ( ( 'a' ) )
            // InternalBug348427TestLanguage.g:5395:3: ( 'a' )
            {
             before(grammarAccess.getChild2_5Access().getStringAKeyword_3_0_0()); 
            // InternalBug348427TestLanguage.g:5396:3: ( 'a' )
            // InternalBug348427TestLanguage.g:5397:4: 'a'
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
    // InternalBug348427TestLanguage.g:5408:1: rule__Child2_5__StringAssignment_3_1 : ( ( 'b' ) ) ;
    public final void rule__Child2_5__StringAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5412:1: ( ( ( 'b' ) ) )
            // InternalBug348427TestLanguage.g:5413:2: ( ( 'b' ) )
            {
            // InternalBug348427TestLanguage.g:5413:2: ( ( 'b' ) )
            // InternalBug348427TestLanguage.g:5414:3: ( 'b' )
            {
             before(grammarAccess.getChild2_5Access().getStringBKeyword_3_1_0()); 
            // InternalBug348427TestLanguage.g:5415:3: ( 'b' )
            // InternalBug348427TestLanguage.g:5416:4: 'b'
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
    // InternalBug348427TestLanguage.g:5427:1: rule__Child2_6__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Child2_6__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5431:1: ( ( RULE_ID ) )
            // InternalBug348427TestLanguage.g:5432:2: ( RULE_ID )
            {
            // InternalBug348427TestLanguage.g:5432:2: ( RULE_ID )
            // InternalBug348427TestLanguage.g:5433:3: RULE_ID
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
    // InternalBug348427TestLanguage.g:5442:1: rule__Child2_6__BoolAssignment_2_0 : ( ( 'bool' ) ) ;
    public final void rule__Child2_6__BoolAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5446:1: ( ( ( 'bool' ) ) )
            // InternalBug348427TestLanguage.g:5447:2: ( ( 'bool' ) )
            {
            // InternalBug348427TestLanguage.g:5447:2: ( ( 'bool' ) )
            // InternalBug348427TestLanguage.g:5448:3: ( 'bool' )
            {
             before(grammarAccess.getChild2_6Access().getBoolBoolKeyword_2_0_0()); 
            // InternalBug348427TestLanguage.g:5449:3: ( 'bool' )
            // InternalBug348427TestLanguage.g:5450:4: 'bool'
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
    // InternalBug348427TestLanguage.g:5461:1: rule__Child2_6__StringAssignment_3_0 : ( ( 'a' ) ) ;
    public final void rule__Child2_6__StringAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5465:1: ( ( ( 'a' ) ) )
            // InternalBug348427TestLanguage.g:5466:2: ( ( 'a' ) )
            {
            // InternalBug348427TestLanguage.g:5466:2: ( ( 'a' ) )
            // InternalBug348427TestLanguage.g:5467:3: ( 'a' )
            {
             before(grammarAccess.getChild2_6Access().getStringAKeyword_3_0_0()); 
            // InternalBug348427TestLanguage.g:5468:3: ( 'a' )
            // InternalBug348427TestLanguage.g:5469:4: 'a'
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
    // InternalBug348427TestLanguage.g:5480:1: rule__Child2_6__StringAssignment_3_1 : ( ( 'b' ) ) ;
    public final void rule__Child2_6__StringAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348427TestLanguage.g:5484:1: ( ( ( 'b' ) ) )
            // InternalBug348427TestLanguage.g:5485:2: ( ( 'b' ) )
            {
            // InternalBug348427TestLanguage.g:5485:2: ( ( 'b' ) )
            // InternalBug348427TestLanguage.g:5486:3: ( 'b' )
            {
             before(grammarAccess.getChild2_6Access().getStringBKeyword_3_1_0()); 
            // InternalBug348427TestLanguage.g:5487:3: ( 'b' )
            // InternalBug348427TestLanguage.g:5488:4: 'b'
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
            return "699:1: rule__Scenario1_1__Alternatives_1 : ( ( ( rule__Scenario1_1__ChildAssignment_1_0 ) ) | ( ( rule__Scenario1_1__ChildAssignment_1_1 ) ) | ( ( rule__Scenario1_1__ChildAssignment_1_2 ) ) );";
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
            return "726:1: rule__Scenario1_2__Alternatives_1 : ( ( ( rule__Scenario1_2__ChildAssignment_1_0 ) ) | ( ( rule__Scenario1_2__ChildAssignment_1_1 ) ) | ( ( rule__Scenario1_2__ChildAssignment_1_2 ) ) );";
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
            return "753:1: rule__Scenario1_3__Alternatives_2 : ( ( ( rule__Scenario1_3__ChildAssignment_2_0 ) ) | ( ( rule__Scenario1_3__ChildAssignment_2_1 ) ) | ( ( rule__Scenario1_3__ChildAssignment_2_2 ) ) );";
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
            return "780:1: rule__Scenario1_4__Alternatives_2 : ( ( ( rule__Scenario1_4__ChildAssignment_2_0 ) ) | ( ( rule__Scenario1_4__ChildAssignment_2_1 ) ) | ( ( rule__Scenario1_4__ChildAssignment_2_2 ) ) );";
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
            return "807:1: rule__Scenario2_1__Alternatives_1 : ( ( ( rule__Scenario2_1__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_1__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_1__ChildAssignment_1_2 ) ) );";
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
            return "834:1: rule__Scenario2_2__Alternatives_1 : ( ( ( rule__Scenario2_2__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_2__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_2__ChildAssignment_1_2 ) ) );";
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
            return "861:1: rule__Scenario2_3__Alternatives_1 : ( ( ( rule__Scenario2_3__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_3__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_3__ChildAssignment_1_2 ) ) );";
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
            return "888:1: rule__Scenario2_4__Alternatives_1 : ( ( ( rule__Scenario2_4__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_4__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_4__ChildAssignment_1_2 ) ) );";
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
            return "915:1: rule__Scenario2_5__Alternatives_2 : ( ( ( rule__Scenario2_5__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_5__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_5__ChildAssignment_2_2 ) ) );";
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
            return "942:1: rule__Scenario2_6__Alternatives_2 : ( ( ( rule__Scenario2_6__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_6__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_6__ChildAssignment_2_2 ) ) );";
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
            return "969:1: rule__Scenario2_7__Alternatives_2 : ( ( ( rule__Scenario2_7__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_7__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_7__ChildAssignment_2_2 ) ) );";
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
            return "996:1: rule__Scenario2_8__Alternatives_2 : ( ( ( rule__Scenario2_8__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_8__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_8__ChildAssignment_2_2 ) ) );";
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
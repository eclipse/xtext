package org.eclipse.xtext.ui.tests.editor.contentassist.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
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
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int T__12=12;
    public static final int T__28=28;
    public static final int T__23=23;
    public static final int T__20=20;
    public static final int T__13=13;
    public static final int RULE_STRING=6;
    public static final int T__21=21;
    public static final int T__19=19;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int T__22=22;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int RULE_WS=9;
    public static final int T__17=17;
    public static final int T__31=31;
    public static final int RULE_INT=5;
    public static final int EOF=-1;
    public static final int T__27=27;
    public static final int T__32=32;
    public static final int T__16=16;
    public static final int T__24=24;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__18=18;
    public static final int T__15=15;

    // delegates
    // delegators


        public InternalBug348427TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug348427TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug348427TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g"; }


     
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:61:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:62:1: ( ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:63:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel61);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel68); 

            }

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:70:1: ruleModel : ( ( rule__Model__Alternatives ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:74:2: ( ( ( rule__Model__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:75:1: ( ( rule__Model__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:75:1: ( ( rule__Model__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:76:1: ( rule__Model__Alternatives )
            {
             before(grammarAccess.getModelAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:77:1: ( rule__Model__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:77:2: rule__Model__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Alternatives_in_ruleModel94);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:89:1: entryRuleScenario1_1 : ruleScenario1_1 EOF ;
    public final void entryRuleScenario1_1() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:90:1: ( ruleScenario1_1 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:91:1: ruleScenario1_1 EOF
            {
             before(grammarAccess.getScenario1_1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleScenario1_1_in_entryRuleScenario1_1121);
            ruleScenario1_1();

            state._fsp--;

             after(grammarAccess.getScenario1_1Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario1_1128); 

            }

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:98:1: ruleScenario1_1 : ( ( rule__Scenario1_1__Group__0 ) ) ;
    public final void ruleScenario1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:102:2: ( ( ( rule__Scenario1_1__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:103:1: ( ( rule__Scenario1_1__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:103:1: ( ( rule__Scenario1_1__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:104:1: ( rule__Scenario1_1__Group__0 )
            {
             before(grammarAccess.getScenario1_1Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:105:1: ( rule__Scenario1_1__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:105:2: rule__Scenario1_1__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario1_1__Group__0_in_ruleScenario1_1154);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:117:1: entryRuleScenario1_2 : ruleScenario1_2 EOF ;
    public final void entryRuleScenario1_2() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:118:1: ( ruleScenario1_2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:119:1: ruleScenario1_2 EOF
            {
             before(grammarAccess.getScenario1_2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleScenario1_2_in_entryRuleScenario1_2181);
            ruleScenario1_2();

            state._fsp--;

             after(grammarAccess.getScenario1_2Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario1_2188); 

            }

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:126:1: ruleScenario1_2 : ( ( rule__Scenario1_2__Group__0 ) ) ;
    public final void ruleScenario1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:130:2: ( ( ( rule__Scenario1_2__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:131:1: ( ( rule__Scenario1_2__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:131:1: ( ( rule__Scenario1_2__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:132:1: ( rule__Scenario1_2__Group__0 )
            {
             before(grammarAccess.getScenario1_2Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:133:1: ( rule__Scenario1_2__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:133:2: rule__Scenario1_2__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario1_2__Group__0_in_ruleScenario1_2214);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:145:1: entryRuleScenario1_3 : ruleScenario1_3 EOF ;
    public final void entryRuleScenario1_3() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:146:1: ( ruleScenario1_3 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:147:1: ruleScenario1_3 EOF
            {
             before(grammarAccess.getScenario1_3Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleScenario1_3_in_entryRuleScenario1_3241);
            ruleScenario1_3();

            state._fsp--;

             after(grammarAccess.getScenario1_3Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario1_3248); 

            }

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:154:1: ruleScenario1_3 : ( ( rule__Scenario1_3__Group__0 ) ) ;
    public final void ruleScenario1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:158:2: ( ( ( rule__Scenario1_3__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:159:1: ( ( rule__Scenario1_3__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:159:1: ( ( rule__Scenario1_3__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:160:1: ( rule__Scenario1_3__Group__0 )
            {
             before(grammarAccess.getScenario1_3Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:161:1: ( rule__Scenario1_3__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:161:2: rule__Scenario1_3__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario1_3__Group__0_in_ruleScenario1_3274);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:173:1: entryRuleScenario1_4 : ruleScenario1_4 EOF ;
    public final void entryRuleScenario1_4() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:174:1: ( ruleScenario1_4 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:175:1: ruleScenario1_4 EOF
            {
             before(grammarAccess.getScenario1_4Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleScenario1_4_in_entryRuleScenario1_4301);
            ruleScenario1_4();

            state._fsp--;

             after(grammarAccess.getScenario1_4Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario1_4308); 

            }

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:182:1: ruleScenario1_4 : ( ( rule__Scenario1_4__Group__0 ) ) ;
    public final void ruleScenario1_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:186:2: ( ( ( rule__Scenario1_4__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:187:1: ( ( rule__Scenario1_4__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:187:1: ( ( rule__Scenario1_4__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:188:1: ( rule__Scenario1_4__Group__0 )
            {
             before(grammarAccess.getScenario1_4Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:189:1: ( rule__Scenario1_4__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:189:2: rule__Scenario1_4__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario1_4__Group__0_in_ruleScenario1_4334);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:201:1: entryRuleChild1_1 : ruleChild1_1 EOF ;
    public final void entryRuleChild1_1() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:202:1: ( ruleChild1_1 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:203:1: ruleChild1_1 EOF
            {
             before(grammarAccess.getChild1_1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild1_1_in_entryRuleChild1_1361);
            ruleChild1_1();

            state._fsp--;

             after(grammarAccess.getChild1_1Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChild1_1368); 

            }

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:210:1: ruleChild1_1 : ( ( rule__Child1_1__Group__0 ) ) ;
    public final void ruleChild1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:214:2: ( ( ( rule__Child1_1__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:215:1: ( ( rule__Child1_1__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:215:1: ( ( rule__Child1_1__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:216:1: ( rule__Child1_1__Group__0 )
            {
             before(grammarAccess.getChild1_1Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:217:1: ( rule__Child1_1__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:217:2: rule__Child1_1__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child1_1__Group__0_in_ruleChild1_1394);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:229:1: entryRuleChild1_2 : ruleChild1_2 EOF ;
    public final void entryRuleChild1_2() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:230:1: ( ruleChild1_2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:231:1: ruleChild1_2 EOF
            {
             before(grammarAccess.getChild1_2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild1_2_in_entryRuleChild1_2421);
            ruleChild1_2();

            state._fsp--;

             after(grammarAccess.getChild1_2Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChild1_2428); 

            }

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:238:1: ruleChild1_2 : ( ( rule__Child1_2__Group__0 ) ) ;
    public final void ruleChild1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:242:2: ( ( ( rule__Child1_2__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:243:1: ( ( rule__Child1_2__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:243:1: ( ( rule__Child1_2__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:244:1: ( rule__Child1_2__Group__0 )
            {
             before(grammarAccess.getChild1_2Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:245:1: ( rule__Child1_2__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:245:2: rule__Child1_2__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child1_2__Group__0_in_ruleChild1_2454);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:257:1: entryRuleChild1_3 : ruleChild1_3 EOF ;
    public final void entryRuleChild1_3() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:258:1: ( ruleChild1_3 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:259:1: ruleChild1_3 EOF
            {
             before(grammarAccess.getChild1_3Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild1_3_in_entryRuleChild1_3481);
            ruleChild1_3();

            state._fsp--;

             after(grammarAccess.getChild1_3Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChild1_3488); 

            }

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:266:1: ruleChild1_3 : ( ( rule__Child1_3__Group__0 ) ) ;
    public final void ruleChild1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:270:2: ( ( ( rule__Child1_3__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:271:1: ( ( rule__Child1_3__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:271:1: ( ( rule__Child1_3__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:272:1: ( rule__Child1_3__Group__0 )
            {
             before(grammarAccess.getChild1_3Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:273:1: ( rule__Child1_3__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:273:2: rule__Child1_3__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child1_3__Group__0_in_ruleChild1_3514);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:285:1: entryRuleScenario2_1 : ruleScenario2_1 EOF ;
    public final void entryRuleScenario2_1() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:286:1: ( ruleScenario2_1 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:287:1: ruleScenario2_1 EOF
            {
             before(grammarAccess.getScenario2_1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleScenario2_1_in_entryRuleScenario2_1541);
            ruleScenario2_1();

            state._fsp--;

             after(grammarAccess.getScenario2_1Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario2_1548); 

            }

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:294:1: ruleScenario2_1 : ( ( rule__Scenario2_1__Group__0 ) ) ;
    public final void ruleScenario2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:298:2: ( ( ( rule__Scenario2_1__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:299:1: ( ( rule__Scenario2_1__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:299:1: ( ( rule__Scenario2_1__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:300:1: ( rule__Scenario2_1__Group__0 )
            {
             before(grammarAccess.getScenario2_1Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:301:1: ( rule__Scenario2_1__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:301:2: rule__Scenario2_1__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_1__Group__0_in_ruleScenario2_1574);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:313:1: entryRuleScenario2_2 : ruleScenario2_2 EOF ;
    public final void entryRuleScenario2_2() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:314:1: ( ruleScenario2_2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:315:1: ruleScenario2_2 EOF
            {
             before(grammarAccess.getScenario2_2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleScenario2_2_in_entryRuleScenario2_2601);
            ruleScenario2_2();

            state._fsp--;

             after(grammarAccess.getScenario2_2Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario2_2608); 

            }

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:322:1: ruleScenario2_2 : ( ( rule__Scenario2_2__Group__0 ) ) ;
    public final void ruleScenario2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:326:2: ( ( ( rule__Scenario2_2__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:327:1: ( ( rule__Scenario2_2__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:327:1: ( ( rule__Scenario2_2__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:328:1: ( rule__Scenario2_2__Group__0 )
            {
             before(grammarAccess.getScenario2_2Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:329:1: ( rule__Scenario2_2__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:329:2: rule__Scenario2_2__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_2__Group__0_in_ruleScenario2_2634);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:341:1: entryRuleScenario2_3 : ruleScenario2_3 EOF ;
    public final void entryRuleScenario2_3() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:342:1: ( ruleScenario2_3 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:343:1: ruleScenario2_3 EOF
            {
             before(grammarAccess.getScenario2_3Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleScenario2_3_in_entryRuleScenario2_3661);
            ruleScenario2_3();

            state._fsp--;

             after(grammarAccess.getScenario2_3Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario2_3668); 

            }

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:350:1: ruleScenario2_3 : ( ( rule__Scenario2_3__Group__0 ) ) ;
    public final void ruleScenario2_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:354:2: ( ( ( rule__Scenario2_3__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:355:1: ( ( rule__Scenario2_3__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:355:1: ( ( rule__Scenario2_3__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:356:1: ( rule__Scenario2_3__Group__0 )
            {
             before(grammarAccess.getScenario2_3Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:357:1: ( rule__Scenario2_3__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:357:2: rule__Scenario2_3__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_3__Group__0_in_ruleScenario2_3694);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:369:1: entryRuleScenario2_4 : ruleScenario2_4 EOF ;
    public final void entryRuleScenario2_4() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:370:1: ( ruleScenario2_4 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:371:1: ruleScenario2_4 EOF
            {
             before(grammarAccess.getScenario2_4Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleScenario2_4_in_entryRuleScenario2_4721);
            ruleScenario2_4();

            state._fsp--;

             after(grammarAccess.getScenario2_4Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario2_4728); 

            }

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:378:1: ruleScenario2_4 : ( ( rule__Scenario2_4__Group__0 ) ) ;
    public final void ruleScenario2_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:382:2: ( ( ( rule__Scenario2_4__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:383:1: ( ( rule__Scenario2_4__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:383:1: ( ( rule__Scenario2_4__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:384:1: ( rule__Scenario2_4__Group__0 )
            {
             before(grammarAccess.getScenario2_4Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:385:1: ( rule__Scenario2_4__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:385:2: rule__Scenario2_4__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_4__Group__0_in_ruleScenario2_4754);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:397:1: entryRuleScenario2_5 : ruleScenario2_5 EOF ;
    public final void entryRuleScenario2_5() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:398:1: ( ruleScenario2_5 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:399:1: ruleScenario2_5 EOF
            {
             before(grammarAccess.getScenario2_5Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleScenario2_5_in_entryRuleScenario2_5781);
            ruleScenario2_5();

            state._fsp--;

             after(grammarAccess.getScenario2_5Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario2_5788); 

            }

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:406:1: ruleScenario2_5 : ( ( rule__Scenario2_5__Group__0 ) ) ;
    public final void ruleScenario2_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:410:2: ( ( ( rule__Scenario2_5__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:411:1: ( ( rule__Scenario2_5__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:411:1: ( ( rule__Scenario2_5__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:412:1: ( rule__Scenario2_5__Group__0 )
            {
             before(grammarAccess.getScenario2_5Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:413:1: ( rule__Scenario2_5__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:413:2: rule__Scenario2_5__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_5__Group__0_in_ruleScenario2_5814);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:425:1: entryRuleScenario2_6 : ruleScenario2_6 EOF ;
    public final void entryRuleScenario2_6() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:426:1: ( ruleScenario2_6 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:427:1: ruleScenario2_6 EOF
            {
             before(grammarAccess.getScenario2_6Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleScenario2_6_in_entryRuleScenario2_6841);
            ruleScenario2_6();

            state._fsp--;

             after(grammarAccess.getScenario2_6Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario2_6848); 

            }

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:434:1: ruleScenario2_6 : ( ( rule__Scenario2_6__Group__0 ) ) ;
    public final void ruleScenario2_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:438:2: ( ( ( rule__Scenario2_6__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:439:1: ( ( rule__Scenario2_6__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:439:1: ( ( rule__Scenario2_6__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:440:1: ( rule__Scenario2_6__Group__0 )
            {
             before(grammarAccess.getScenario2_6Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:441:1: ( rule__Scenario2_6__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:441:2: rule__Scenario2_6__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_6__Group__0_in_ruleScenario2_6874);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:453:1: entryRuleScenario2_7 : ruleScenario2_7 EOF ;
    public final void entryRuleScenario2_7() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:454:1: ( ruleScenario2_7 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:455:1: ruleScenario2_7 EOF
            {
             before(grammarAccess.getScenario2_7Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleScenario2_7_in_entryRuleScenario2_7901);
            ruleScenario2_7();

            state._fsp--;

             after(grammarAccess.getScenario2_7Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario2_7908); 

            }

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:462:1: ruleScenario2_7 : ( ( rule__Scenario2_7__Group__0 ) ) ;
    public final void ruleScenario2_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:466:2: ( ( ( rule__Scenario2_7__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:467:1: ( ( rule__Scenario2_7__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:467:1: ( ( rule__Scenario2_7__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:468:1: ( rule__Scenario2_7__Group__0 )
            {
             before(grammarAccess.getScenario2_7Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:469:1: ( rule__Scenario2_7__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:469:2: rule__Scenario2_7__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_7__Group__0_in_ruleScenario2_7934);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:481:1: entryRuleScenario2_8 : ruleScenario2_8 EOF ;
    public final void entryRuleScenario2_8() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:482:1: ( ruleScenario2_8 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:483:1: ruleScenario2_8 EOF
            {
             before(grammarAccess.getScenario2_8Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleScenario2_8_in_entryRuleScenario2_8961);
            ruleScenario2_8();

            state._fsp--;

             after(grammarAccess.getScenario2_8Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario2_8968); 

            }

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:490:1: ruleScenario2_8 : ( ( rule__Scenario2_8__Group__0 ) ) ;
    public final void ruleScenario2_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:494:2: ( ( ( rule__Scenario2_8__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:495:1: ( ( rule__Scenario2_8__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:495:1: ( ( rule__Scenario2_8__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:496:1: ( rule__Scenario2_8__Group__0 )
            {
             before(grammarAccess.getScenario2_8Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:497:1: ( rule__Scenario2_8__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:497:2: rule__Scenario2_8__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_8__Group__0_in_ruleScenario2_8994);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:509:1: entryRuleChild2_1 : ruleChild2_1 EOF ;
    public final void entryRuleChild2_1() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:510:1: ( ruleChild2_1 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:511:1: ruleChild2_1 EOF
            {
             before(grammarAccess.getChild2_1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_1_in_entryRuleChild2_11021);
            ruleChild2_1();

            state._fsp--;

             after(grammarAccess.getChild2_1Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChild2_11028); 

            }

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:518:1: ruleChild2_1 : ( ( rule__Child2_1__Group__0 ) ) ;
    public final void ruleChild2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:522:2: ( ( ( rule__Child2_1__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:523:1: ( ( rule__Child2_1__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:523:1: ( ( rule__Child2_1__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:524:1: ( rule__Child2_1__Group__0 )
            {
             before(grammarAccess.getChild2_1Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:525:1: ( rule__Child2_1__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:525:2: rule__Child2_1__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_1__Group__0_in_ruleChild2_11054);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:537:1: entryRuleChild2_2 : ruleChild2_2 EOF ;
    public final void entryRuleChild2_2() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:538:1: ( ruleChild2_2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:539:1: ruleChild2_2 EOF
            {
             before(grammarAccess.getChild2_2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_2_in_entryRuleChild2_21081);
            ruleChild2_2();

            state._fsp--;

             after(grammarAccess.getChild2_2Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChild2_21088); 

            }

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:546:1: ruleChild2_2 : ( ( rule__Child2_2__Group__0 ) ) ;
    public final void ruleChild2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:550:2: ( ( ( rule__Child2_2__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:551:1: ( ( rule__Child2_2__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:551:1: ( ( rule__Child2_2__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:552:1: ( rule__Child2_2__Group__0 )
            {
             before(grammarAccess.getChild2_2Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:553:1: ( rule__Child2_2__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:553:2: rule__Child2_2__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_2__Group__0_in_ruleChild2_21114);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:565:1: entryRuleChild2_3 : ruleChild2_3 EOF ;
    public final void entryRuleChild2_3() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:566:1: ( ruleChild2_3 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:567:1: ruleChild2_3 EOF
            {
             before(grammarAccess.getChild2_3Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_3_in_entryRuleChild2_31141);
            ruleChild2_3();

            state._fsp--;

             after(grammarAccess.getChild2_3Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChild2_31148); 

            }

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:574:1: ruleChild2_3 : ( ( rule__Child2_3__Group__0 ) ) ;
    public final void ruleChild2_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:578:2: ( ( ( rule__Child2_3__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:579:1: ( ( rule__Child2_3__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:579:1: ( ( rule__Child2_3__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:580:1: ( rule__Child2_3__Group__0 )
            {
             before(grammarAccess.getChild2_3Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:581:1: ( rule__Child2_3__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:581:2: rule__Child2_3__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_3__Group__0_in_ruleChild2_31174);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:593:1: entryRuleChild2_4 : ruleChild2_4 EOF ;
    public final void entryRuleChild2_4() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:594:1: ( ruleChild2_4 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:595:1: ruleChild2_4 EOF
            {
             before(grammarAccess.getChild2_4Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_4_in_entryRuleChild2_41201);
            ruleChild2_4();

            state._fsp--;

             after(grammarAccess.getChild2_4Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChild2_41208); 

            }

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:602:1: ruleChild2_4 : ( ( rule__Child2_4__Group__0 ) ) ;
    public final void ruleChild2_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:606:2: ( ( ( rule__Child2_4__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:607:1: ( ( rule__Child2_4__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:607:1: ( ( rule__Child2_4__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:608:1: ( rule__Child2_4__Group__0 )
            {
             before(grammarAccess.getChild2_4Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:609:1: ( rule__Child2_4__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:609:2: rule__Child2_4__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_4__Group__0_in_ruleChild2_41234);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:621:1: entryRuleChild2_5 : ruleChild2_5 EOF ;
    public final void entryRuleChild2_5() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:622:1: ( ruleChild2_5 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:623:1: ruleChild2_5 EOF
            {
             before(grammarAccess.getChild2_5Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_5_in_entryRuleChild2_51261);
            ruleChild2_5();

            state._fsp--;

             after(grammarAccess.getChild2_5Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChild2_51268); 

            }

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:630:1: ruleChild2_5 : ( ( rule__Child2_5__Group__0 ) ) ;
    public final void ruleChild2_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:634:2: ( ( ( rule__Child2_5__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:635:1: ( ( rule__Child2_5__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:635:1: ( ( rule__Child2_5__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:636:1: ( rule__Child2_5__Group__0 )
            {
             before(grammarAccess.getChild2_5Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:637:1: ( rule__Child2_5__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:637:2: rule__Child2_5__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_5__Group__0_in_ruleChild2_51294);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:649:1: entryRuleChild2_6 : ruleChild2_6 EOF ;
    public final void entryRuleChild2_6() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:650:1: ( ruleChild2_6 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:651:1: ruleChild2_6 EOF
            {
             before(grammarAccess.getChild2_6Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_6_in_entryRuleChild2_61321);
            ruleChild2_6();

            state._fsp--;

             after(grammarAccess.getChild2_6Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChild2_61328); 

            }

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:658:1: ruleChild2_6 : ( ( rule__Child2_6__Group__0 ) ) ;
    public final void ruleChild2_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:662:2: ( ( ( rule__Child2_6__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:663:1: ( ( rule__Child2_6__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:663:1: ( ( rule__Child2_6__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:664:1: ( rule__Child2_6__Group__0 )
            {
             before(grammarAccess.getChild2_6Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:665:1: ( rule__Child2_6__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:665:2: rule__Child2_6__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_6__Group__0_in_ruleChild2_61354);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:678:1: ruleEnumType : ( ( rule__EnumType__Alternatives ) ) ;
    public final void ruleEnumType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:682:1: ( ( ( rule__EnumType__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:683:1: ( ( rule__EnumType__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:683:1: ( ( rule__EnumType__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:684:1: ( rule__EnumType__Alternatives )
            {
             before(grammarAccess.getEnumTypeAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:685:1: ( rule__EnumType__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:685:2: rule__EnumType__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumType__Alternatives_in_ruleEnumType1391);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:696:1: rule__Model__Alternatives : ( ( ( rule__Model__Element1Assignment_0 ) ) | ( ( rule__Model__Element1Assignment_1 ) ) | ( ( rule__Model__Element1Assignment_2 ) ) | ( ( rule__Model__Element1Assignment_3 ) ) | ( ( rule__Model__Element2Assignment_4 ) ) | ( ( rule__Model__Element2Assignment_5 ) ) | ( ( rule__Model__Element2Assignment_6 ) ) | ( ( rule__Model__Element2Assignment_7 ) ) | ( ( rule__Model__Element2Assignment_8 ) ) | ( ( rule__Model__Element2Assignment_9 ) ) | ( ( rule__Model__Element2Assignment_10 ) ) | ( ( rule__Model__Element2Assignment_11 ) ) );
    public final void rule__Model__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:700:1: ( ( ( rule__Model__Element1Assignment_0 ) ) | ( ( rule__Model__Element1Assignment_1 ) ) | ( ( rule__Model__Element1Assignment_2 ) ) | ( ( rule__Model__Element1Assignment_3 ) ) | ( ( rule__Model__Element2Assignment_4 ) ) | ( ( rule__Model__Element2Assignment_5 ) ) | ( ( rule__Model__Element2Assignment_6 ) ) | ( ( rule__Model__Element2Assignment_7 ) ) | ( ( rule__Model__Element2Assignment_8 ) ) | ( ( rule__Model__Element2Assignment_9 ) ) | ( ( rule__Model__Element2Assignment_10 ) ) | ( ( rule__Model__Element2Assignment_11 ) ) )
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:701:1: ( ( rule__Model__Element1Assignment_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:701:1: ( ( rule__Model__Element1Assignment_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:702:1: ( rule__Model__Element1Assignment_0 )
                    {
                     before(grammarAccess.getModelAccess().getElement1Assignment_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:703:1: ( rule__Model__Element1Assignment_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:703:2: rule__Model__Element1Assignment_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Element1Assignment_0_in_rule__Model__Alternatives1426);
                    rule__Model__Element1Assignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getElement1Assignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:707:6: ( ( rule__Model__Element1Assignment_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:707:6: ( ( rule__Model__Element1Assignment_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:708:1: ( rule__Model__Element1Assignment_1 )
                    {
                     before(grammarAccess.getModelAccess().getElement1Assignment_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:709:1: ( rule__Model__Element1Assignment_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:709:2: rule__Model__Element1Assignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Element1Assignment_1_in_rule__Model__Alternatives1444);
                    rule__Model__Element1Assignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getElement1Assignment_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:713:6: ( ( rule__Model__Element1Assignment_2 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:713:6: ( ( rule__Model__Element1Assignment_2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:714:1: ( rule__Model__Element1Assignment_2 )
                    {
                     before(grammarAccess.getModelAccess().getElement1Assignment_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:715:1: ( rule__Model__Element1Assignment_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:715:2: rule__Model__Element1Assignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Element1Assignment_2_in_rule__Model__Alternatives1462);
                    rule__Model__Element1Assignment_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getElement1Assignment_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:719:6: ( ( rule__Model__Element1Assignment_3 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:719:6: ( ( rule__Model__Element1Assignment_3 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:720:1: ( rule__Model__Element1Assignment_3 )
                    {
                     before(grammarAccess.getModelAccess().getElement1Assignment_3()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:721:1: ( rule__Model__Element1Assignment_3 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:721:2: rule__Model__Element1Assignment_3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Element1Assignment_3_in_rule__Model__Alternatives1480);
                    rule__Model__Element1Assignment_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getElement1Assignment_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:725:6: ( ( rule__Model__Element2Assignment_4 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:725:6: ( ( rule__Model__Element2Assignment_4 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:726:1: ( rule__Model__Element2Assignment_4 )
                    {
                     before(grammarAccess.getModelAccess().getElement2Assignment_4()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:727:1: ( rule__Model__Element2Assignment_4 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:727:2: rule__Model__Element2Assignment_4
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Element2Assignment_4_in_rule__Model__Alternatives1498);
                    rule__Model__Element2Assignment_4();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getElement2Assignment_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:731:6: ( ( rule__Model__Element2Assignment_5 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:731:6: ( ( rule__Model__Element2Assignment_5 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:732:1: ( rule__Model__Element2Assignment_5 )
                    {
                     before(grammarAccess.getModelAccess().getElement2Assignment_5()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:733:1: ( rule__Model__Element2Assignment_5 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:733:2: rule__Model__Element2Assignment_5
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Element2Assignment_5_in_rule__Model__Alternatives1516);
                    rule__Model__Element2Assignment_5();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getElement2Assignment_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:737:6: ( ( rule__Model__Element2Assignment_6 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:737:6: ( ( rule__Model__Element2Assignment_6 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:738:1: ( rule__Model__Element2Assignment_6 )
                    {
                     before(grammarAccess.getModelAccess().getElement2Assignment_6()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:739:1: ( rule__Model__Element2Assignment_6 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:739:2: rule__Model__Element2Assignment_6
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Element2Assignment_6_in_rule__Model__Alternatives1534);
                    rule__Model__Element2Assignment_6();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getElement2Assignment_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:743:6: ( ( rule__Model__Element2Assignment_7 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:743:6: ( ( rule__Model__Element2Assignment_7 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:744:1: ( rule__Model__Element2Assignment_7 )
                    {
                     before(grammarAccess.getModelAccess().getElement2Assignment_7()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:745:1: ( rule__Model__Element2Assignment_7 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:745:2: rule__Model__Element2Assignment_7
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Element2Assignment_7_in_rule__Model__Alternatives1552);
                    rule__Model__Element2Assignment_7();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getElement2Assignment_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:749:6: ( ( rule__Model__Element2Assignment_8 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:749:6: ( ( rule__Model__Element2Assignment_8 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:750:1: ( rule__Model__Element2Assignment_8 )
                    {
                     before(grammarAccess.getModelAccess().getElement2Assignment_8()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:751:1: ( rule__Model__Element2Assignment_8 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:751:2: rule__Model__Element2Assignment_8
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Element2Assignment_8_in_rule__Model__Alternatives1570);
                    rule__Model__Element2Assignment_8();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getElement2Assignment_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:755:6: ( ( rule__Model__Element2Assignment_9 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:755:6: ( ( rule__Model__Element2Assignment_9 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:756:1: ( rule__Model__Element2Assignment_9 )
                    {
                     before(grammarAccess.getModelAccess().getElement2Assignment_9()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:757:1: ( rule__Model__Element2Assignment_9 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:757:2: rule__Model__Element2Assignment_9
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Element2Assignment_9_in_rule__Model__Alternatives1588);
                    rule__Model__Element2Assignment_9();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getElement2Assignment_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:761:6: ( ( rule__Model__Element2Assignment_10 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:761:6: ( ( rule__Model__Element2Assignment_10 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:762:1: ( rule__Model__Element2Assignment_10 )
                    {
                     before(grammarAccess.getModelAccess().getElement2Assignment_10()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:763:1: ( rule__Model__Element2Assignment_10 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:763:2: rule__Model__Element2Assignment_10
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Element2Assignment_10_in_rule__Model__Alternatives1606);
                    rule__Model__Element2Assignment_10();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getElement2Assignment_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:767:6: ( ( rule__Model__Element2Assignment_11 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:767:6: ( ( rule__Model__Element2Assignment_11 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:768:1: ( rule__Model__Element2Assignment_11 )
                    {
                     before(grammarAccess.getModelAccess().getElement2Assignment_11()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:769:1: ( rule__Model__Element2Assignment_11 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:769:2: rule__Model__Element2Assignment_11
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Element2Assignment_11_in_rule__Model__Alternatives1624);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:778:1: rule__Scenario1_1__Alternatives_1 : ( ( ( rule__Scenario1_1__ChildAssignment_1_0 ) ) | ( ( rule__Scenario1_1__ChildAssignment_1_1 ) ) | ( ( rule__Scenario1_1__ChildAssignment_1_2 ) ) );
    public final void rule__Scenario1_1__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:782:1: ( ( ( rule__Scenario1_1__ChildAssignment_1_0 ) ) | ( ( rule__Scenario1_1__ChildAssignment_1_1 ) ) | ( ( rule__Scenario1_1__ChildAssignment_1_2 ) ) )
            int alt2=3;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:783:1: ( ( rule__Scenario1_1__ChildAssignment_1_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:783:1: ( ( rule__Scenario1_1__ChildAssignment_1_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:784:1: ( rule__Scenario1_1__ChildAssignment_1_0 )
                    {
                     before(grammarAccess.getScenario1_1Access().getChildAssignment_1_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:785:1: ( rule__Scenario1_1__ChildAssignment_1_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:785:2: rule__Scenario1_1__ChildAssignment_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario1_1__ChildAssignment_1_0_in_rule__Scenario1_1__Alternatives_11657);
                    rule__Scenario1_1__ChildAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario1_1Access().getChildAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:789:6: ( ( rule__Scenario1_1__ChildAssignment_1_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:789:6: ( ( rule__Scenario1_1__ChildAssignment_1_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:790:1: ( rule__Scenario1_1__ChildAssignment_1_1 )
                    {
                     before(grammarAccess.getScenario1_1Access().getChildAssignment_1_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:791:1: ( rule__Scenario1_1__ChildAssignment_1_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:791:2: rule__Scenario1_1__ChildAssignment_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario1_1__ChildAssignment_1_1_in_rule__Scenario1_1__Alternatives_11675);
                    rule__Scenario1_1__ChildAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario1_1Access().getChildAssignment_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:795:6: ( ( rule__Scenario1_1__ChildAssignment_1_2 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:795:6: ( ( rule__Scenario1_1__ChildAssignment_1_2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:796:1: ( rule__Scenario1_1__ChildAssignment_1_2 )
                    {
                     before(grammarAccess.getScenario1_1Access().getChildAssignment_1_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:797:1: ( rule__Scenario1_1__ChildAssignment_1_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:797:2: rule__Scenario1_1__ChildAssignment_1_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario1_1__ChildAssignment_1_2_in_rule__Scenario1_1__Alternatives_11693);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:806:1: rule__Scenario1_2__Alternatives_1 : ( ( ( rule__Scenario1_2__ChildAssignment_1_0 ) ) | ( ( rule__Scenario1_2__ChildAssignment_1_1 ) ) | ( ( rule__Scenario1_2__ChildAssignment_1_2 ) ) );
    public final void rule__Scenario1_2__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:810:1: ( ( ( rule__Scenario1_2__ChildAssignment_1_0 ) ) | ( ( rule__Scenario1_2__ChildAssignment_1_1 ) ) | ( ( rule__Scenario1_2__ChildAssignment_1_2 ) ) )
            int alt3=3;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:811:1: ( ( rule__Scenario1_2__ChildAssignment_1_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:811:1: ( ( rule__Scenario1_2__ChildAssignment_1_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:812:1: ( rule__Scenario1_2__ChildAssignment_1_0 )
                    {
                     before(grammarAccess.getScenario1_2Access().getChildAssignment_1_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:813:1: ( rule__Scenario1_2__ChildAssignment_1_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:813:2: rule__Scenario1_2__ChildAssignment_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario1_2__ChildAssignment_1_0_in_rule__Scenario1_2__Alternatives_11726);
                    rule__Scenario1_2__ChildAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario1_2Access().getChildAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:817:6: ( ( rule__Scenario1_2__ChildAssignment_1_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:817:6: ( ( rule__Scenario1_2__ChildAssignment_1_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:818:1: ( rule__Scenario1_2__ChildAssignment_1_1 )
                    {
                     before(grammarAccess.getScenario1_2Access().getChildAssignment_1_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:819:1: ( rule__Scenario1_2__ChildAssignment_1_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:819:2: rule__Scenario1_2__ChildAssignment_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario1_2__ChildAssignment_1_1_in_rule__Scenario1_2__Alternatives_11744);
                    rule__Scenario1_2__ChildAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario1_2Access().getChildAssignment_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:823:6: ( ( rule__Scenario1_2__ChildAssignment_1_2 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:823:6: ( ( rule__Scenario1_2__ChildAssignment_1_2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:824:1: ( rule__Scenario1_2__ChildAssignment_1_2 )
                    {
                     before(grammarAccess.getScenario1_2Access().getChildAssignment_1_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:825:1: ( rule__Scenario1_2__ChildAssignment_1_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:825:2: rule__Scenario1_2__ChildAssignment_1_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario1_2__ChildAssignment_1_2_in_rule__Scenario1_2__Alternatives_11762);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:834:1: rule__Scenario1_3__Alternatives_2 : ( ( ( rule__Scenario1_3__ChildAssignment_2_0 ) ) | ( ( rule__Scenario1_3__ChildAssignment_2_1 ) ) | ( ( rule__Scenario1_3__ChildAssignment_2_2 ) ) );
    public final void rule__Scenario1_3__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:838:1: ( ( ( rule__Scenario1_3__ChildAssignment_2_0 ) ) | ( ( rule__Scenario1_3__ChildAssignment_2_1 ) ) | ( ( rule__Scenario1_3__ChildAssignment_2_2 ) ) )
            int alt4=3;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:839:1: ( ( rule__Scenario1_3__ChildAssignment_2_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:839:1: ( ( rule__Scenario1_3__ChildAssignment_2_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:840:1: ( rule__Scenario1_3__ChildAssignment_2_0 )
                    {
                     before(grammarAccess.getScenario1_3Access().getChildAssignment_2_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:841:1: ( rule__Scenario1_3__ChildAssignment_2_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:841:2: rule__Scenario1_3__ChildAssignment_2_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario1_3__ChildAssignment_2_0_in_rule__Scenario1_3__Alternatives_21795);
                    rule__Scenario1_3__ChildAssignment_2_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario1_3Access().getChildAssignment_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:845:6: ( ( rule__Scenario1_3__ChildAssignment_2_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:845:6: ( ( rule__Scenario1_3__ChildAssignment_2_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:846:1: ( rule__Scenario1_3__ChildAssignment_2_1 )
                    {
                     before(grammarAccess.getScenario1_3Access().getChildAssignment_2_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:847:1: ( rule__Scenario1_3__ChildAssignment_2_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:847:2: rule__Scenario1_3__ChildAssignment_2_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario1_3__ChildAssignment_2_1_in_rule__Scenario1_3__Alternatives_21813);
                    rule__Scenario1_3__ChildAssignment_2_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario1_3Access().getChildAssignment_2_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:851:6: ( ( rule__Scenario1_3__ChildAssignment_2_2 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:851:6: ( ( rule__Scenario1_3__ChildAssignment_2_2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:852:1: ( rule__Scenario1_3__ChildAssignment_2_2 )
                    {
                     before(grammarAccess.getScenario1_3Access().getChildAssignment_2_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:853:1: ( rule__Scenario1_3__ChildAssignment_2_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:853:2: rule__Scenario1_3__ChildAssignment_2_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario1_3__ChildAssignment_2_2_in_rule__Scenario1_3__Alternatives_21831);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:862:1: rule__Scenario1_4__Alternatives_2 : ( ( ( rule__Scenario1_4__ChildAssignment_2_0 ) ) | ( ( rule__Scenario1_4__ChildAssignment_2_1 ) ) | ( ( rule__Scenario1_4__ChildAssignment_2_2 ) ) );
    public final void rule__Scenario1_4__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:866:1: ( ( ( rule__Scenario1_4__ChildAssignment_2_0 ) ) | ( ( rule__Scenario1_4__ChildAssignment_2_1 ) ) | ( ( rule__Scenario1_4__ChildAssignment_2_2 ) ) )
            int alt5=3;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:867:1: ( ( rule__Scenario1_4__ChildAssignment_2_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:867:1: ( ( rule__Scenario1_4__ChildAssignment_2_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:868:1: ( rule__Scenario1_4__ChildAssignment_2_0 )
                    {
                     before(grammarAccess.getScenario1_4Access().getChildAssignment_2_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:869:1: ( rule__Scenario1_4__ChildAssignment_2_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:869:2: rule__Scenario1_4__ChildAssignment_2_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario1_4__ChildAssignment_2_0_in_rule__Scenario1_4__Alternatives_21864);
                    rule__Scenario1_4__ChildAssignment_2_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario1_4Access().getChildAssignment_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:873:6: ( ( rule__Scenario1_4__ChildAssignment_2_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:873:6: ( ( rule__Scenario1_4__ChildAssignment_2_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:874:1: ( rule__Scenario1_4__ChildAssignment_2_1 )
                    {
                     before(grammarAccess.getScenario1_4Access().getChildAssignment_2_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:875:1: ( rule__Scenario1_4__ChildAssignment_2_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:875:2: rule__Scenario1_4__ChildAssignment_2_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario1_4__ChildAssignment_2_1_in_rule__Scenario1_4__Alternatives_21882);
                    rule__Scenario1_4__ChildAssignment_2_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario1_4Access().getChildAssignment_2_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:879:6: ( ( rule__Scenario1_4__ChildAssignment_2_2 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:879:6: ( ( rule__Scenario1_4__ChildAssignment_2_2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:880:1: ( rule__Scenario1_4__ChildAssignment_2_2 )
                    {
                     before(grammarAccess.getScenario1_4Access().getChildAssignment_2_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:881:1: ( rule__Scenario1_4__ChildAssignment_2_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:881:2: rule__Scenario1_4__ChildAssignment_2_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario1_4__ChildAssignment_2_2_in_rule__Scenario1_4__Alternatives_21900);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:890:1: rule__Scenario2_1__Alternatives_1 : ( ( ( rule__Scenario2_1__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_1__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_1__ChildAssignment_1_2 ) ) );
    public final void rule__Scenario2_1__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:894:1: ( ( ( rule__Scenario2_1__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_1__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_1__ChildAssignment_1_2 ) ) )
            int alt6=3;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:895:1: ( ( rule__Scenario2_1__ChildAssignment_1_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:895:1: ( ( rule__Scenario2_1__ChildAssignment_1_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:896:1: ( rule__Scenario2_1__ChildAssignment_1_0 )
                    {
                     before(grammarAccess.getScenario2_1Access().getChildAssignment_1_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:897:1: ( rule__Scenario2_1__ChildAssignment_1_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:897:2: rule__Scenario2_1__ChildAssignment_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario2_1__ChildAssignment_1_0_in_rule__Scenario2_1__Alternatives_11933);
                    rule__Scenario2_1__ChildAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_1Access().getChildAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:901:6: ( ( rule__Scenario2_1__ChildAssignment_1_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:901:6: ( ( rule__Scenario2_1__ChildAssignment_1_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:902:1: ( rule__Scenario2_1__ChildAssignment_1_1 )
                    {
                     before(grammarAccess.getScenario2_1Access().getChildAssignment_1_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:903:1: ( rule__Scenario2_1__ChildAssignment_1_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:903:2: rule__Scenario2_1__ChildAssignment_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario2_1__ChildAssignment_1_1_in_rule__Scenario2_1__Alternatives_11951);
                    rule__Scenario2_1__ChildAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_1Access().getChildAssignment_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:907:6: ( ( rule__Scenario2_1__ChildAssignment_1_2 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:907:6: ( ( rule__Scenario2_1__ChildAssignment_1_2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:908:1: ( rule__Scenario2_1__ChildAssignment_1_2 )
                    {
                     before(grammarAccess.getScenario2_1Access().getChildAssignment_1_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:909:1: ( rule__Scenario2_1__ChildAssignment_1_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:909:2: rule__Scenario2_1__ChildAssignment_1_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario2_1__ChildAssignment_1_2_in_rule__Scenario2_1__Alternatives_11969);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:918:1: rule__Scenario2_2__Alternatives_1 : ( ( ( rule__Scenario2_2__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_2__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_2__ChildAssignment_1_2 ) ) );
    public final void rule__Scenario2_2__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:922:1: ( ( ( rule__Scenario2_2__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_2__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_2__ChildAssignment_1_2 ) ) )
            int alt7=3;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:923:1: ( ( rule__Scenario2_2__ChildAssignment_1_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:923:1: ( ( rule__Scenario2_2__ChildAssignment_1_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:924:1: ( rule__Scenario2_2__ChildAssignment_1_0 )
                    {
                     before(grammarAccess.getScenario2_2Access().getChildAssignment_1_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:925:1: ( rule__Scenario2_2__ChildAssignment_1_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:925:2: rule__Scenario2_2__ChildAssignment_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario2_2__ChildAssignment_1_0_in_rule__Scenario2_2__Alternatives_12002);
                    rule__Scenario2_2__ChildAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_2Access().getChildAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:929:6: ( ( rule__Scenario2_2__ChildAssignment_1_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:929:6: ( ( rule__Scenario2_2__ChildAssignment_1_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:930:1: ( rule__Scenario2_2__ChildAssignment_1_1 )
                    {
                     before(grammarAccess.getScenario2_2Access().getChildAssignment_1_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:931:1: ( rule__Scenario2_2__ChildAssignment_1_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:931:2: rule__Scenario2_2__ChildAssignment_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario2_2__ChildAssignment_1_1_in_rule__Scenario2_2__Alternatives_12020);
                    rule__Scenario2_2__ChildAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_2Access().getChildAssignment_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:935:6: ( ( rule__Scenario2_2__ChildAssignment_1_2 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:935:6: ( ( rule__Scenario2_2__ChildAssignment_1_2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:936:1: ( rule__Scenario2_2__ChildAssignment_1_2 )
                    {
                     before(grammarAccess.getScenario2_2Access().getChildAssignment_1_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:937:1: ( rule__Scenario2_2__ChildAssignment_1_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:937:2: rule__Scenario2_2__ChildAssignment_1_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario2_2__ChildAssignment_1_2_in_rule__Scenario2_2__Alternatives_12038);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:946:1: rule__Scenario2_3__Alternatives_1 : ( ( ( rule__Scenario2_3__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_3__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_3__ChildAssignment_1_2 ) ) );
    public final void rule__Scenario2_3__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:950:1: ( ( ( rule__Scenario2_3__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_3__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_3__ChildAssignment_1_2 ) ) )
            int alt8=3;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:951:1: ( ( rule__Scenario2_3__ChildAssignment_1_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:951:1: ( ( rule__Scenario2_3__ChildAssignment_1_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:952:1: ( rule__Scenario2_3__ChildAssignment_1_0 )
                    {
                     before(grammarAccess.getScenario2_3Access().getChildAssignment_1_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:953:1: ( rule__Scenario2_3__ChildAssignment_1_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:953:2: rule__Scenario2_3__ChildAssignment_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario2_3__ChildAssignment_1_0_in_rule__Scenario2_3__Alternatives_12071);
                    rule__Scenario2_3__ChildAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_3Access().getChildAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:957:6: ( ( rule__Scenario2_3__ChildAssignment_1_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:957:6: ( ( rule__Scenario2_3__ChildAssignment_1_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:958:1: ( rule__Scenario2_3__ChildAssignment_1_1 )
                    {
                     before(grammarAccess.getScenario2_3Access().getChildAssignment_1_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:959:1: ( rule__Scenario2_3__ChildAssignment_1_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:959:2: rule__Scenario2_3__ChildAssignment_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario2_3__ChildAssignment_1_1_in_rule__Scenario2_3__Alternatives_12089);
                    rule__Scenario2_3__ChildAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_3Access().getChildAssignment_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:963:6: ( ( rule__Scenario2_3__ChildAssignment_1_2 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:963:6: ( ( rule__Scenario2_3__ChildAssignment_1_2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:964:1: ( rule__Scenario2_3__ChildAssignment_1_2 )
                    {
                     before(grammarAccess.getScenario2_3Access().getChildAssignment_1_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:965:1: ( rule__Scenario2_3__ChildAssignment_1_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:965:2: rule__Scenario2_3__ChildAssignment_1_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario2_3__ChildAssignment_1_2_in_rule__Scenario2_3__Alternatives_12107);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:974:1: rule__Scenario2_4__Alternatives_1 : ( ( ( rule__Scenario2_4__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_4__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_4__ChildAssignment_1_2 ) ) );
    public final void rule__Scenario2_4__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:978:1: ( ( ( rule__Scenario2_4__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_4__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_4__ChildAssignment_1_2 ) ) )
            int alt9=3;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:979:1: ( ( rule__Scenario2_4__ChildAssignment_1_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:979:1: ( ( rule__Scenario2_4__ChildAssignment_1_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:980:1: ( rule__Scenario2_4__ChildAssignment_1_0 )
                    {
                     before(grammarAccess.getScenario2_4Access().getChildAssignment_1_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:981:1: ( rule__Scenario2_4__ChildAssignment_1_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:981:2: rule__Scenario2_4__ChildAssignment_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario2_4__ChildAssignment_1_0_in_rule__Scenario2_4__Alternatives_12140);
                    rule__Scenario2_4__ChildAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_4Access().getChildAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:985:6: ( ( rule__Scenario2_4__ChildAssignment_1_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:985:6: ( ( rule__Scenario2_4__ChildAssignment_1_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:986:1: ( rule__Scenario2_4__ChildAssignment_1_1 )
                    {
                     before(grammarAccess.getScenario2_4Access().getChildAssignment_1_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:987:1: ( rule__Scenario2_4__ChildAssignment_1_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:987:2: rule__Scenario2_4__ChildAssignment_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario2_4__ChildAssignment_1_1_in_rule__Scenario2_4__Alternatives_12158);
                    rule__Scenario2_4__ChildAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_4Access().getChildAssignment_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:991:6: ( ( rule__Scenario2_4__ChildAssignment_1_2 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:991:6: ( ( rule__Scenario2_4__ChildAssignment_1_2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:992:1: ( rule__Scenario2_4__ChildAssignment_1_2 )
                    {
                     before(grammarAccess.getScenario2_4Access().getChildAssignment_1_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:993:1: ( rule__Scenario2_4__ChildAssignment_1_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:993:2: rule__Scenario2_4__ChildAssignment_1_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario2_4__ChildAssignment_1_2_in_rule__Scenario2_4__Alternatives_12176);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1002:1: rule__Scenario2_5__Alternatives_2 : ( ( ( rule__Scenario2_5__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_5__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_5__ChildAssignment_2_2 ) ) );
    public final void rule__Scenario2_5__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1006:1: ( ( ( rule__Scenario2_5__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_5__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_5__ChildAssignment_2_2 ) ) )
            int alt10=3;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1007:1: ( ( rule__Scenario2_5__ChildAssignment_2_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1007:1: ( ( rule__Scenario2_5__ChildAssignment_2_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1008:1: ( rule__Scenario2_5__ChildAssignment_2_0 )
                    {
                     before(grammarAccess.getScenario2_5Access().getChildAssignment_2_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1009:1: ( rule__Scenario2_5__ChildAssignment_2_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1009:2: rule__Scenario2_5__ChildAssignment_2_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario2_5__ChildAssignment_2_0_in_rule__Scenario2_5__Alternatives_22209);
                    rule__Scenario2_5__ChildAssignment_2_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_5Access().getChildAssignment_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1013:6: ( ( rule__Scenario2_5__ChildAssignment_2_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1013:6: ( ( rule__Scenario2_5__ChildAssignment_2_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1014:1: ( rule__Scenario2_5__ChildAssignment_2_1 )
                    {
                     before(grammarAccess.getScenario2_5Access().getChildAssignment_2_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1015:1: ( rule__Scenario2_5__ChildAssignment_2_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1015:2: rule__Scenario2_5__ChildAssignment_2_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario2_5__ChildAssignment_2_1_in_rule__Scenario2_5__Alternatives_22227);
                    rule__Scenario2_5__ChildAssignment_2_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_5Access().getChildAssignment_2_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1019:6: ( ( rule__Scenario2_5__ChildAssignment_2_2 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1019:6: ( ( rule__Scenario2_5__ChildAssignment_2_2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1020:1: ( rule__Scenario2_5__ChildAssignment_2_2 )
                    {
                     before(grammarAccess.getScenario2_5Access().getChildAssignment_2_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1021:1: ( rule__Scenario2_5__ChildAssignment_2_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1021:2: rule__Scenario2_5__ChildAssignment_2_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario2_5__ChildAssignment_2_2_in_rule__Scenario2_5__Alternatives_22245);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1030:1: rule__Scenario2_6__Alternatives_2 : ( ( ( rule__Scenario2_6__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_6__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_6__ChildAssignment_2_2 ) ) );
    public final void rule__Scenario2_6__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1034:1: ( ( ( rule__Scenario2_6__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_6__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_6__ChildAssignment_2_2 ) ) )
            int alt11=3;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1035:1: ( ( rule__Scenario2_6__ChildAssignment_2_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1035:1: ( ( rule__Scenario2_6__ChildAssignment_2_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1036:1: ( rule__Scenario2_6__ChildAssignment_2_0 )
                    {
                     before(grammarAccess.getScenario2_6Access().getChildAssignment_2_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1037:1: ( rule__Scenario2_6__ChildAssignment_2_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1037:2: rule__Scenario2_6__ChildAssignment_2_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario2_6__ChildAssignment_2_0_in_rule__Scenario2_6__Alternatives_22278);
                    rule__Scenario2_6__ChildAssignment_2_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_6Access().getChildAssignment_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1041:6: ( ( rule__Scenario2_6__ChildAssignment_2_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1041:6: ( ( rule__Scenario2_6__ChildAssignment_2_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1042:1: ( rule__Scenario2_6__ChildAssignment_2_1 )
                    {
                     before(grammarAccess.getScenario2_6Access().getChildAssignment_2_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1043:1: ( rule__Scenario2_6__ChildAssignment_2_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1043:2: rule__Scenario2_6__ChildAssignment_2_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario2_6__ChildAssignment_2_1_in_rule__Scenario2_6__Alternatives_22296);
                    rule__Scenario2_6__ChildAssignment_2_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_6Access().getChildAssignment_2_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1047:6: ( ( rule__Scenario2_6__ChildAssignment_2_2 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1047:6: ( ( rule__Scenario2_6__ChildAssignment_2_2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1048:1: ( rule__Scenario2_6__ChildAssignment_2_2 )
                    {
                     before(grammarAccess.getScenario2_6Access().getChildAssignment_2_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1049:1: ( rule__Scenario2_6__ChildAssignment_2_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1049:2: rule__Scenario2_6__ChildAssignment_2_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario2_6__ChildAssignment_2_2_in_rule__Scenario2_6__Alternatives_22314);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1058:1: rule__Scenario2_7__Alternatives_2 : ( ( ( rule__Scenario2_7__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_7__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_7__ChildAssignment_2_2 ) ) );
    public final void rule__Scenario2_7__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1062:1: ( ( ( rule__Scenario2_7__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_7__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_7__ChildAssignment_2_2 ) ) )
            int alt12=3;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1063:1: ( ( rule__Scenario2_7__ChildAssignment_2_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1063:1: ( ( rule__Scenario2_7__ChildAssignment_2_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1064:1: ( rule__Scenario2_7__ChildAssignment_2_0 )
                    {
                     before(grammarAccess.getScenario2_7Access().getChildAssignment_2_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1065:1: ( rule__Scenario2_7__ChildAssignment_2_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1065:2: rule__Scenario2_7__ChildAssignment_2_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario2_7__ChildAssignment_2_0_in_rule__Scenario2_7__Alternatives_22347);
                    rule__Scenario2_7__ChildAssignment_2_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_7Access().getChildAssignment_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1069:6: ( ( rule__Scenario2_7__ChildAssignment_2_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1069:6: ( ( rule__Scenario2_7__ChildAssignment_2_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1070:1: ( rule__Scenario2_7__ChildAssignment_2_1 )
                    {
                     before(grammarAccess.getScenario2_7Access().getChildAssignment_2_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1071:1: ( rule__Scenario2_7__ChildAssignment_2_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1071:2: rule__Scenario2_7__ChildAssignment_2_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario2_7__ChildAssignment_2_1_in_rule__Scenario2_7__Alternatives_22365);
                    rule__Scenario2_7__ChildAssignment_2_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_7Access().getChildAssignment_2_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1075:6: ( ( rule__Scenario2_7__ChildAssignment_2_2 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1075:6: ( ( rule__Scenario2_7__ChildAssignment_2_2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1076:1: ( rule__Scenario2_7__ChildAssignment_2_2 )
                    {
                     before(grammarAccess.getScenario2_7Access().getChildAssignment_2_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1077:1: ( rule__Scenario2_7__ChildAssignment_2_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1077:2: rule__Scenario2_7__ChildAssignment_2_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario2_7__ChildAssignment_2_2_in_rule__Scenario2_7__Alternatives_22383);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1086:1: rule__Scenario2_8__Alternatives_2 : ( ( ( rule__Scenario2_8__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_8__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_8__ChildAssignment_2_2 ) ) );
    public final void rule__Scenario2_8__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1090:1: ( ( ( rule__Scenario2_8__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_8__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_8__ChildAssignment_2_2 ) ) )
            int alt13=3;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1091:1: ( ( rule__Scenario2_8__ChildAssignment_2_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1091:1: ( ( rule__Scenario2_8__ChildAssignment_2_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1092:1: ( rule__Scenario2_8__ChildAssignment_2_0 )
                    {
                     before(grammarAccess.getScenario2_8Access().getChildAssignment_2_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1093:1: ( rule__Scenario2_8__ChildAssignment_2_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1093:2: rule__Scenario2_8__ChildAssignment_2_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario2_8__ChildAssignment_2_0_in_rule__Scenario2_8__Alternatives_22416);
                    rule__Scenario2_8__ChildAssignment_2_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_8Access().getChildAssignment_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1097:6: ( ( rule__Scenario2_8__ChildAssignment_2_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1097:6: ( ( rule__Scenario2_8__ChildAssignment_2_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1098:1: ( rule__Scenario2_8__ChildAssignment_2_1 )
                    {
                     before(grammarAccess.getScenario2_8Access().getChildAssignment_2_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1099:1: ( rule__Scenario2_8__ChildAssignment_2_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1099:2: rule__Scenario2_8__ChildAssignment_2_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario2_8__ChildAssignment_2_1_in_rule__Scenario2_8__Alternatives_22434);
                    rule__Scenario2_8__ChildAssignment_2_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenario2_8Access().getChildAssignment_2_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1103:6: ( ( rule__Scenario2_8__ChildAssignment_2_2 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1103:6: ( ( rule__Scenario2_8__ChildAssignment_2_2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1104:1: ( rule__Scenario2_8__ChildAssignment_2_2 )
                    {
                     before(grammarAccess.getScenario2_8Access().getChildAssignment_2_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1105:1: ( rule__Scenario2_8__ChildAssignment_2_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1105:2: rule__Scenario2_8__ChildAssignment_2_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario2_8__ChildAssignment_2_2_in_rule__Scenario2_8__Alternatives_22452);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1114:1: rule__Child2_1__StringAlternatives_3_0 : ( ( 'a' ) | ( 'b' ) );
    public final void rule__Child2_1__StringAlternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1118:1: ( ( 'a' ) | ( 'b' ) )
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1119:1: ( 'a' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1119:1: ( 'a' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1120:1: 'a'
                    {
                     before(grammarAccess.getChild2_1Access().getStringAKeyword_3_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__Child2_1__StringAlternatives_3_02486); 
                     after(grammarAccess.getChild2_1Access().getStringAKeyword_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1127:6: ( 'b' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1127:6: ( 'b' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1128:1: 'b'
                    {
                     before(grammarAccess.getChild2_1Access().getStringBKeyword_3_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__Child2_1__StringAlternatives_3_02506); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1140:1: rule__Child2_2__StringAlternatives_3_0 : ( ( 'a' ) | ( 'b' ) );
    public final void rule__Child2_2__StringAlternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1144:1: ( ( 'a' ) | ( 'b' ) )
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1145:1: ( 'a' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1145:1: ( 'a' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1146:1: 'a'
                    {
                     before(grammarAccess.getChild2_2Access().getStringAKeyword_3_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__Child2_2__StringAlternatives_3_02541); 
                     after(grammarAccess.getChild2_2Access().getStringAKeyword_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1153:6: ( 'b' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1153:6: ( 'b' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1154:1: 'b'
                    {
                     before(grammarAccess.getChild2_2Access().getStringBKeyword_3_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__Child2_2__StringAlternatives_3_02561); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1166:1: rule__Child2_3__StringAlternatives_3_0 : ( ( 'a' ) | ( 'b' ) );
    public final void rule__Child2_3__StringAlternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1170:1: ( ( 'a' ) | ( 'b' ) )
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1171:1: ( 'a' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1171:1: ( 'a' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1172:1: 'a'
                    {
                     before(grammarAccess.getChild2_3Access().getStringAKeyword_3_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__Child2_3__StringAlternatives_3_02596); 
                     after(grammarAccess.getChild2_3Access().getStringAKeyword_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1179:6: ( 'b' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1179:6: ( 'b' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1180:1: 'b'
                    {
                     before(grammarAccess.getChild2_3Access().getStringBKeyword_3_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__Child2_3__StringAlternatives_3_02616); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1192:1: rule__Child2_4__Alternatives_3 : ( ( ( rule__Child2_4__StringAssignment_3_0 ) ) | ( ( rule__Child2_4__StringAssignment_3_1 ) ) );
    public final void rule__Child2_4__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1196:1: ( ( ( rule__Child2_4__StringAssignment_3_0 ) ) | ( ( rule__Child2_4__StringAssignment_3_1 ) ) )
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1197:1: ( ( rule__Child2_4__StringAssignment_3_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1197:1: ( ( rule__Child2_4__StringAssignment_3_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1198:1: ( rule__Child2_4__StringAssignment_3_0 )
                    {
                     before(grammarAccess.getChild2_4Access().getStringAssignment_3_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1199:1: ( rule__Child2_4__StringAssignment_3_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1199:2: rule__Child2_4__StringAssignment_3_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Child2_4__StringAssignment_3_0_in_rule__Child2_4__Alternatives_32650);
                    rule__Child2_4__StringAssignment_3_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getChild2_4Access().getStringAssignment_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1203:6: ( ( rule__Child2_4__StringAssignment_3_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1203:6: ( ( rule__Child2_4__StringAssignment_3_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1204:1: ( rule__Child2_4__StringAssignment_3_1 )
                    {
                     before(grammarAccess.getChild2_4Access().getStringAssignment_3_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1205:1: ( rule__Child2_4__StringAssignment_3_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1205:2: rule__Child2_4__StringAssignment_3_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Child2_4__StringAssignment_3_1_in_rule__Child2_4__Alternatives_32668);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1214:1: rule__Child2_5__Alternatives_3 : ( ( ( rule__Child2_5__StringAssignment_3_0 ) ) | ( ( rule__Child2_5__StringAssignment_3_1 ) ) );
    public final void rule__Child2_5__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1218:1: ( ( ( rule__Child2_5__StringAssignment_3_0 ) ) | ( ( rule__Child2_5__StringAssignment_3_1 ) ) )
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1219:1: ( ( rule__Child2_5__StringAssignment_3_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1219:1: ( ( rule__Child2_5__StringAssignment_3_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1220:1: ( rule__Child2_5__StringAssignment_3_0 )
                    {
                     before(grammarAccess.getChild2_5Access().getStringAssignment_3_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1221:1: ( rule__Child2_5__StringAssignment_3_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1221:2: rule__Child2_5__StringAssignment_3_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Child2_5__StringAssignment_3_0_in_rule__Child2_5__Alternatives_32701);
                    rule__Child2_5__StringAssignment_3_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getChild2_5Access().getStringAssignment_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1225:6: ( ( rule__Child2_5__StringAssignment_3_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1225:6: ( ( rule__Child2_5__StringAssignment_3_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1226:1: ( rule__Child2_5__StringAssignment_3_1 )
                    {
                     before(grammarAccess.getChild2_5Access().getStringAssignment_3_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1227:1: ( rule__Child2_5__StringAssignment_3_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1227:2: rule__Child2_5__StringAssignment_3_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Child2_5__StringAssignment_3_1_in_rule__Child2_5__Alternatives_32719);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1236:1: rule__Child2_6__Alternatives_3 : ( ( ( rule__Child2_6__StringAssignment_3_0 ) ) | ( ( rule__Child2_6__StringAssignment_3_1 ) ) );
    public final void rule__Child2_6__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1240:1: ( ( ( rule__Child2_6__StringAssignment_3_0 ) ) | ( ( rule__Child2_6__StringAssignment_3_1 ) ) )
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1241:1: ( ( rule__Child2_6__StringAssignment_3_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1241:1: ( ( rule__Child2_6__StringAssignment_3_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1242:1: ( rule__Child2_6__StringAssignment_3_0 )
                    {
                     before(grammarAccess.getChild2_6Access().getStringAssignment_3_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1243:1: ( rule__Child2_6__StringAssignment_3_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1243:2: rule__Child2_6__StringAssignment_3_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Child2_6__StringAssignment_3_0_in_rule__Child2_6__Alternatives_32752);
                    rule__Child2_6__StringAssignment_3_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getChild2_6Access().getStringAssignment_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1247:6: ( ( rule__Child2_6__StringAssignment_3_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1247:6: ( ( rule__Child2_6__StringAssignment_3_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1248:1: ( rule__Child2_6__StringAssignment_3_1 )
                    {
                     before(grammarAccess.getChild2_6Access().getStringAssignment_3_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1249:1: ( rule__Child2_6__StringAssignment_3_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1249:2: rule__Child2_6__StringAssignment_3_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Child2_6__StringAssignment_3_1_in_rule__Child2_6__Alternatives_32770);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1258:1: rule__EnumType__Alternatives : ( ( ( 'a' ) ) | ( ( 'b' ) ) );
    public final void rule__EnumType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1262:1: ( ( ( 'a' ) ) | ( ( 'b' ) ) )
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1263:1: ( ( 'a' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1263:1: ( ( 'a' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1264:1: ( 'a' )
                    {
                     before(grammarAccess.getEnumTypeAccess().getAEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1265:1: ( 'a' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1265:3: 'a'
                    {
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__EnumType__Alternatives2804); 

                    }

                     after(grammarAccess.getEnumTypeAccess().getAEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1270:6: ( ( 'b' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1270:6: ( ( 'b' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1271:1: ( 'b' )
                    {
                     before(grammarAccess.getEnumTypeAccess().getBEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1272:1: ( 'b' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1272:3: 'b'
                    {
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__EnumType__Alternatives2825); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1284:1: rule__Scenario1_1__Group__0 : rule__Scenario1_1__Group__0__Impl rule__Scenario1_1__Group__1 ;
    public final void rule__Scenario1_1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1288:1: ( rule__Scenario1_1__Group__0__Impl rule__Scenario1_1__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1289:2: rule__Scenario1_1__Group__0__Impl rule__Scenario1_1__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario1_1__Group__0__Impl_in_rule__Scenario1_1__Group__02858);
            rule__Scenario1_1__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario1_1__Group__1_in_rule__Scenario1_1__Group__02861);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1296:1: rule__Scenario1_1__Group__0__Impl : ( '1.1' ) ;
    public final void rule__Scenario1_1__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1300:1: ( ( '1.1' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1301:1: ( '1.1' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1301:1: ( '1.1' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1302:1: '1.1'
            {
             before(grammarAccess.getScenario1_1Access().getDigitOneFullStopDigitOneKeyword_0()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Scenario1_1__Group__0__Impl2889); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1315:1: rule__Scenario1_1__Group__1 : rule__Scenario1_1__Group__1__Impl rule__Scenario1_1__Group__2 ;
    public final void rule__Scenario1_1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1319:1: ( rule__Scenario1_1__Group__1__Impl rule__Scenario1_1__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1320:2: rule__Scenario1_1__Group__1__Impl rule__Scenario1_1__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario1_1__Group__1__Impl_in_rule__Scenario1_1__Group__12920);
            rule__Scenario1_1__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario1_1__Group__2_in_rule__Scenario1_1__Group__12923);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1327:1: rule__Scenario1_1__Group__1__Impl : ( ( rule__Scenario1_1__Alternatives_1 ) ) ;
    public final void rule__Scenario1_1__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1331:1: ( ( ( rule__Scenario1_1__Alternatives_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1332:1: ( ( rule__Scenario1_1__Alternatives_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1332:1: ( ( rule__Scenario1_1__Alternatives_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1333:1: ( rule__Scenario1_1__Alternatives_1 )
            {
             before(grammarAccess.getScenario1_1Access().getAlternatives_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1334:1: ( rule__Scenario1_1__Alternatives_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1334:2: rule__Scenario1_1__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario1_1__Alternatives_1_in_rule__Scenario1_1__Group__1__Impl2950);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1344:1: rule__Scenario1_1__Group__2 : rule__Scenario1_1__Group__2__Impl ;
    public final void rule__Scenario1_1__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1348:1: ( rule__Scenario1_1__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1349:2: rule__Scenario1_1__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario1_1__Group__2__Impl_in_rule__Scenario1_1__Group__22980);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1355:1: rule__Scenario1_1__Group__2__Impl : ( 'next' ) ;
    public final void rule__Scenario1_1__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1359:1: ( ( 'next' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1360:1: ( 'next' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1360:1: ( 'next' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1361:1: 'next'
            {
             before(grammarAccess.getScenario1_1Access().getNextKeyword_2()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Scenario1_1__Group__2__Impl3008); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1380:1: rule__Scenario1_2__Group__0 : rule__Scenario1_2__Group__0__Impl rule__Scenario1_2__Group__1 ;
    public final void rule__Scenario1_2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1384:1: ( rule__Scenario1_2__Group__0__Impl rule__Scenario1_2__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1385:2: rule__Scenario1_2__Group__0__Impl rule__Scenario1_2__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario1_2__Group__0__Impl_in_rule__Scenario1_2__Group__03045);
            rule__Scenario1_2__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario1_2__Group__1_in_rule__Scenario1_2__Group__03048);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1392:1: rule__Scenario1_2__Group__0__Impl : ( '1.2' ) ;
    public final void rule__Scenario1_2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1396:1: ( ( '1.2' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1397:1: ( '1.2' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1397:1: ( '1.2' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1398:1: '1.2'
            {
             before(grammarAccess.getScenario1_2Access().getDigitOneFullStopDigitTwoKeyword_0()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Scenario1_2__Group__0__Impl3076); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1411:1: rule__Scenario1_2__Group__1 : rule__Scenario1_2__Group__1__Impl rule__Scenario1_2__Group__2 ;
    public final void rule__Scenario1_2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1415:1: ( rule__Scenario1_2__Group__1__Impl rule__Scenario1_2__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1416:2: rule__Scenario1_2__Group__1__Impl rule__Scenario1_2__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario1_2__Group__1__Impl_in_rule__Scenario1_2__Group__13107);
            rule__Scenario1_2__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario1_2__Group__2_in_rule__Scenario1_2__Group__13110);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1423:1: rule__Scenario1_2__Group__1__Impl : ( ( ( rule__Scenario1_2__Alternatives_1 ) ) ( ( rule__Scenario1_2__Alternatives_1 )* ) ) ;
    public final void rule__Scenario1_2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1427:1: ( ( ( ( rule__Scenario1_2__Alternatives_1 ) ) ( ( rule__Scenario1_2__Alternatives_1 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1428:1: ( ( ( rule__Scenario1_2__Alternatives_1 ) ) ( ( rule__Scenario1_2__Alternatives_1 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1428:1: ( ( ( rule__Scenario1_2__Alternatives_1 ) ) ( ( rule__Scenario1_2__Alternatives_1 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1429:1: ( ( rule__Scenario1_2__Alternatives_1 ) ) ( ( rule__Scenario1_2__Alternatives_1 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1429:1: ( ( rule__Scenario1_2__Alternatives_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1430:1: ( rule__Scenario1_2__Alternatives_1 )
            {
             before(grammarAccess.getScenario1_2Access().getAlternatives_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1431:1: ( rule__Scenario1_2__Alternatives_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1431:2: rule__Scenario1_2__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario1_2__Alternatives_1_in_rule__Scenario1_2__Group__1__Impl3139);
            rule__Scenario1_2__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getScenario1_2Access().getAlternatives_1()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1434:1: ( ( rule__Scenario1_2__Alternatives_1 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1435:1: ( rule__Scenario1_2__Alternatives_1 )*
            {
             before(grammarAccess.getScenario1_2Access().getAlternatives_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1436:1: ( rule__Scenario1_2__Alternatives_1 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_ID) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1436:2: rule__Scenario1_2__Alternatives_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Scenario1_2__Alternatives_1_in_rule__Scenario1_2__Group__1__Impl3151);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1447:1: rule__Scenario1_2__Group__2 : rule__Scenario1_2__Group__2__Impl ;
    public final void rule__Scenario1_2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1451:1: ( rule__Scenario1_2__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1452:2: rule__Scenario1_2__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario1_2__Group__2__Impl_in_rule__Scenario1_2__Group__23184);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1458:1: rule__Scenario1_2__Group__2__Impl : ( 'next' ) ;
    public final void rule__Scenario1_2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1462:1: ( ( 'next' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1463:1: ( 'next' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1463:1: ( 'next' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1464:1: 'next'
            {
             before(grammarAccess.getScenario1_2Access().getNextKeyword_2()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Scenario1_2__Group__2__Impl3212); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1483:1: rule__Scenario1_3__Group__0 : rule__Scenario1_3__Group__0__Impl rule__Scenario1_3__Group__1 ;
    public final void rule__Scenario1_3__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1487:1: ( rule__Scenario1_3__Group__0__Impl rule__Scenario1_3__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1488:2: rule__Scenario1_3__Group__0__Impl rule__Scenario1_3__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario1_3__Group__0__Impl_in_rule__Scenario1_3__Group__03249);
            rule__Scenario1_3__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario1_3__Group__1_in_rule__Scenario1_3__Group__03252);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1495:1: rule__Scenario1_3__Group__0__Impl : ( () ) ;
    public final void rule__Scenario1_3__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1499:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1500:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1500:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1501:1: ()
            {
             before(grammarAccess.getScenario1_3Access().getScenario1Action_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1502:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1504:1: 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1514:1: rule__Scenario1_3__Group__1 : rule__Scenario1_3__Group__1__Impl rule__Scenario1_3__Group__2 ;
    public final void rule__Scenario1_3__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1518:1: ( rule__Scenario1_3__Group__1__Impl rule__Scenario1_3__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1519:2: rule__Scenario1_3__Group__1__Impl rule__Scenario1_3__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario1_3__Group__1__Impl_in_rule__Scenario1_3__Group__13310);
            rule__Scenario1_3__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario1_3__Group__2_in_rule__Scenario1_3__Group__13313);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1526:1: rule__Scenario1_3__Group__1__Impl : ( '1.3' ) ;
    public final void rule__Scenario1_3__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1530:1: ( ( '1.3' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1531:1: ( '1.3' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1531:1: ( '1.3' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1532:1: '1.3'
            {
             before(grammarAccess.getScenario1_3Access().getDigitOneFullStopDigitThreeKeyword_1()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Scenario1_3__Group__1__Impl3341); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1545:1: rule__Scenario1_3__Group__2 : rule__Scenario1_3__Group__2__Impl rule__Scenario1_3__Group__3 ;
    public final void rule__Scenario1_3__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1549:1: ( rule__Scenario1_3__Group__2__Impl rule__Scenario1_3__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1550:2: rule__Scenario1_3__Group__2__Impl rule__Scenario1_3__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario1_3__Group__2__Impl_in_rule__Scenario1_3__Group__23372);
            rule__Scenario1_3__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario1_3__Group__3_in_rule__Scenario1_3__Group__23375);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1557:1: rule__Scenario1_3__Group__2__Impl : ( ( rule__Scenario1_3__Alternatives_2 )* ) ;
    public final void rule__Scenario1_3__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1561:1: ( ( ( rule__Scenario1_3__Alternatives_2 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1562:1: ( ( rule__Scenario1_3__Alternatives_2 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1562:1: ( ( rule__Scenario1_3__Alternatives_2 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1563:1: ( rule__Scenario1_3__Alternatives_2 )*
            {
             before(grammarAccess.getScenario1_3Access().getAlternatives_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1564:1: ( rule__Scenario1_3__Alternatives_2 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_ID) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1564:2: rule__Scenario1_3__Alternatives_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Scenario1_3__Alternatives_2_in_rule__Scenario1_3__Group__2__Impl3402);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1574:1: rule__Scenario1_3__Group__3 : rule__Scenario1_3__Group__3__Impl ;
    public final void rule__Scenario1_3__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1578:1: ( rule__Scenario1_3__Group__3__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1579:2: rule__Scenario1_3__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario1_3__Group__3__Impl_in_rule__Scenario1_3__Group__33433);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1585:1: rule__Scenario1_3__Group__3__Impl : ( 'next' ) ;
    public final void rule__Scenario1_3__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1589:1: ( ( 'next' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1590:1: ( 'next' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1590:1: ( 'next' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1591:1: 'next'
            {
             before(grammarAccess.getScenario1_3Access().getNextKeyword_3()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Scenario1_3__Group__3__Impl3461); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1612:1: rule__Scenario1_4__Group__0 : rule__Scenario1_4__Group__0__Impl rule__Scenario1_4__Group__1 ;
    public final void rule__Scenario1_4__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1616:1: ( rule__Scenario1_4__Group__0__Impl rule__Scenario1_4__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1617:2: rule__Scenario1_4__Group__0__Impl rule__Scenario1_4__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario1_4__Group__0__Impl_in_rule__Scenario1_4__Group__03500);
            rule__Scenario1_4__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario1_4__Group__1_in_rule__Scenario1_4__Group__03503);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1624:1: rule__Scenario1_4__Group__0__Impl : ( () ) ;
    public final void rule__Scenario1_4__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1628:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1629:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1629:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1630:1: ()
            {
             before(grammarAccess.getScenario1_4Access().getScenario1Action_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1631:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1633:1: 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1643:1: rule__Scenario1_4__Group__1 : rule__Scenario1_4__Group__1__Impl rule__Scenario1_4__Group__2 ;
    public final void rule__Scenario1_4__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1647:1: ( rule__Scenario1_4__Group__1__Impl rule__Scenario1_4__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1648:2: rule__Scenario1_4__Group__1__Impl rule__Scenario1_4__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario1_4__Group__1__Impl_in_rule__Scenario1_4__Group__13561);
            rule__Scenario1_4__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario1_4__Group__2_in_rule__Scenario1_4__Group__13564);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1655:1: rule__Scenario1_4__Group__1__Impl : ( '1.4' ) ;
    public final void rule__Scenario1_4__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1659:1: ( ( '1.4' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1660:1: ( '1.4' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1660:1: ( '1.4' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1661:1: '1.4'
            {
             before(grammarAccess.getScenario1_4Access().getDigitOneFullStopDigitFourKeyword_1()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__Scenario1_4__Group__1__Impl3592); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1674:1: rule__Scenario1_4__Group__2 : rule__Scenario1_4__Group__2__Impl rule__Scenario1_4__Group__3 ;
    public final void rule__Scenario1_4__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1678:1: ( rule__Scenario1_4__Group__2__Impl rule__Scenario1_4__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1679:2: rule__Scenario1_4__Group__2__Impl rule__Scenario1_4__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario1_4__Group__2__Impl_in_rule__Scenario1_4__Group__23623);
            rule__Scenario1_4__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario1_4__Group__3_in_rule__Scenario1_4__Group__23626);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1686:1: rule__Scenario1_4__Group__2__Impl : ( ( rule__Scenario1_4__Alternatives_2 )? ) ;
    public final void rule__Scenario1_4__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1690:1: ( ( ( rule__Scenario1_4__Alternatives_2 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1691:1: ( ( rule__Scenario1_4__Alternatives_2 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1691:1: ( ( rule__Scenario1_4__Alternatives_2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1692:1: ( rule__Scenario1_4__Alternatives_2 )?
            {
             before(grammarAccess.getScenario1_4Access().getAlternatives_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1693:1: ( rule__Scenario1_4__Alternatives_2 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_ID) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1693:2: rule__Scenario1_4__Alternatives_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario1_4__Alternatives_2_in_rule__Scenario1_4__Group__2__Impl3653);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1703:1: rule__Scenario1_4__Group__3 : rule__Scenario1_4__Group__3__Impl ;
    public final void rule__Scenario1_4__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1707:1: ( rule__Scenario1_4__Group__3__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1708:2: rule__Scenario1_4__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario1_4__Group__3__Impl_in_rule__Scenario1_4__Group__33684);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1714:1: rule__Scenario1_4__Group__3__Impl : ( 'next' ) ;
    public final void rule__Scenario1_4__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1718:1: ( ( 'next' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1719:1: ( 'next' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1719:1: ( 'next' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1720:1: 'next'
            {
             before(grammarAccess.getScenario1_4Access().getNextKeyword_3()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Scenario1_4__Group__3__Impl3712); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1741:1: rule__Child1_1__Group__0 : rule__Child1_1__Group__0__Impl rule__Child1_1__Group__1 ;
    public final void rule__Child1_1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1745:1: ( rule__Child1_1__Group__0__Impl rule__Child1_1__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1746:2: rule__Child1_1__Group__0__Impl rule__Child1_1__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child1_1__Group__0__Impl_in_rule__Child1_1__Group__03751);
            rule__Child1_1__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child1_1__Group__1_in_rule__Child1_1__Group__03754);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1753:1: rule__Child1_1__Group__0__Impl : ( ( rule__Child1_1__NameAssignment_0 ) ) ;
    public final void rule__Child1_1__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1757:1: ( ( ( rule__Child1_1__NameAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1758:1: ( ( rule__Child1_1__NameAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1758:1: ( ( rule__Child1_1__NameAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1759:1: ( rule__Child1_1__NameAssignment_0 )
            {
             before(grammarAccess.getChild1_1Access().getNameAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1760:1: ( rule__Child1_1__NameAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1760:2: rule__Child1_1__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child1_1__NameAssignment_0_in_rule__Child1_1__Group__0__Impl3781);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1770:1: rule__Child1_1__Group__1 : rule__Child1_1__Group__1__Impl rule__Child1_1__Group__2 ;
    public final void rule__Child1_1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1774:1: ( rule__Child1_1__Group__1__Impl rule__Child1_1__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1775:2: rule__Child1_1__Group__1__Impl rule__Child1_1__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child1_1__Group__1__Impl_in_rule__Child1_1__Group__13811);
            rule__Child1_1__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child1_1__Group__2_in_rule__Child1_1__Group__13814);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1782:1: rule__Child1_1__Group__1__Impl : ( ':' ) ;
    public final void rule__Child1_1__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1786:1: ( ( ':' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1787:1: ( ':' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1787:1: ( ':' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1788:1: ':'
            {
             before(grammarAccess.getChild1_1Access().getColonKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Child1_1__Group__1__Impl3842); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1801:1: rule__Child1_1__Group__2 : rule__Child1_1__Group__2__Impl rule__Child1_1__Group__3 ;
    public final void rule__Child1_1__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1805:1: ( rule__Child1_1__Group__2__Impl rule__Child1_1__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1806:2: rule__Child1_1__Group__2__Impl rule__Child1_1__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child1_1__Group__2__Impl_in_rule__Child1_1__Group__23873);
            rule__Child1_1__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child1_1__Group__3_in_rule__Child1_1__Group__23876);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1813:1: rule__Child1_1__Group__2__Impl : ( ( rule__Child1_1__Group_2__0 )? ) ;
    public final void rule__Child1_1__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1817:1: ( ( ( rule__Child1_1__Group_2__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1818:1: ( ( rule__Child1_1__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1818:1: ( ( rule__Child1_1__Group_2__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1819:1: ( rule__Child1_1__Group_2__0 )?
            {
             before(grammarAccess.getChild1_1Access().getGroup_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1820:1: ( rule__Child1_1__Group_2__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==32) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1820:2: rule__Child1_1__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Child1_1__Group_2__0_in_rule__Child1_1__Group__2__Impl3903);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1830:1: rule__Child1_1__Group__3 : rule__Child1_1__Group__3__Impl rule__Child1_1__Group__4 ;
    public final void rule__Child1_1__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1834:1: ( rule__Child1_1__Group__3__Impl rule__Child1_1__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1835:2: rule__Child1_1__Group__3__Impl rule__Child1_1__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child1_1__Group__3__Impl_in_rule__Child1_1__Group__33934);
            rule__Child1_1__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child1_1__Group__4_in_rule__Child1_1__Group__33937);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1842:1: rule__Child1_1__Group__3__Impl : ( ( rule__Child1_1__EnumTypeAssignment_3 ) ) ;
    public final void rule__Child1_1__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1846:1: ( ( ( rule__Child1_1__EnumTypeAssignment_3 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1847:1: ( ( rule__Child1_1__EnumTypeAssignment_3 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1847:1: ( ( rule__Child1_1__EnumTypeAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1848:1: ( rule__Child1_1__EnumTypeAssignment_3 )
            {
             before(grammarAccess.getChild1_1Access().getEnumTypeAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1849:1: ( rule__Child1_1__EnumTypeAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1849:2: rule__Child1_1__EnumTypeAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child1_1__EnumTypeAssignment_3_in_rule__Child1_1__Group__3__Impl3964);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1859:1: rule__Child1_1__Group__4 : rule__Child1_1__Group__4__Impl rule__Child1_1__Group__5 ;
    public final void rule__Child1_1__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1863:1: ( rule__Child1_1__Group__4__Impl rule__Child1_1__Group__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1864:2: rule__Child1_1__Group__4__Impl rule__Child1_1__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child1_1__Group__4__Impl_in_rule__Child1_1__Group__43994);
            rule__Child1_1__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child1_1__Group__5_in_rule__Child1_1__Group__43997);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1871:1: rule__Child1_1__Group__4__Impl : ( 'child1' ) ;
    public final void rule__Child1_1__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1875:1: ( ( 'child1' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1876:1: ( 'child1' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1876:1: ( 'child1' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1877:1: 'child1'
            {
             before(grammarAccess.getChild1_1Access().getChild1Keyword_4()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Child1_1__Group__4__Impl4025); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1890:1: rule__Child1_1__Group__5 : rule__Child1_1__Group__5__Impl ;
    public final void rule__Child1_1__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1894:1: ( rule__Child1_1__Group__5__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1895:2: rule__Child1_1__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child1_1__Group__5__Impl_in_rule__Child1_1__Group__54056);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1901:1: rule__Child1_1__Group__5__Impl : ( 'end' ) ;
    public final void rule__Child1_1__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1905:1: ( ( 'end' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1906:1: ( 'end' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1906:1: ( 'end' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1907:1: 'end'
            {
             before(grammarAccess.getChild1_1Access().getEndKeyword_5()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Child1_1__Group__5__Impl4084); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1932:1: rule__Child1_1__Group_2__0 : rule__Child1_1__Group_2__0__Impl rule__Child1_1__Group_2__1 ;
    public final void rule__Child1_1__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1936:1: ( rule__Child1_1__Group_2__0__Impl rule__Child1_1__Group_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1937:2: rule__Child1_1__Group_2__0__Impl rule__Child1_1__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child1_1__Group_2__0__Impl_in_rule__Child1_1__Group_2__04127);
            rule__Child1_1__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child1_1__Group_2__1_in_rule__Child1_1__Group_2__04130);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1944:1: rule__Child1_1__Group_2__0__Impl : ( ( rule__Child1_1__BoolAssignment_2_0 ) ) ;
    public final void rule__Child1_1__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1948:1: ( ( ( rule__Child1_1__BoolAssignment_2_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1949:1: ( ( rule__Child1_1__BoolAssignment_2_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1949:1: ( ( rule__Child1_1__BoolAssignment_2_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1950:1: ( rule__Child1_1__BoolAssignment_2_0 )
            {
             before(grammarAccess.getChild1_1Access().getBoolAssignment_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1951:1: ( rule__Child1_1__BoolAssignment_2_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1951:2: rule__Child1_1__BoolAssignment_2_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child1_1__BoolAssignment_2_0_in_rule__Child1_1__Group_2__0__Impl4157);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1961:1: rule__Child1_1__Group_2__1 : rule__Child1_1__Group_2__1__Impl ;
    public final void rule__Child1_1__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1965:1: ( rule__Child1_1__Group_2__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1966:2: rule__Child1_1__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child1_1__Group_2__1__Impl_in_rule__Child1_1__Group_2__14187);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1972:1: rule__Child1_1__Group_2__1__Impl : ( 'keyword' ) ;
    public final void rule__Child1_1__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1976:1: ( ( 'keyword' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1977:1: ( 'keyword' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1977:1: ( 'keyword' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1978:1: 'keyword'
            {
             before(grammarAccess.getChild1_1Access().getKeywordKeyword_2_1()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__Child1_1__Group_2__1__Impl4215); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1995:1: rule__Child1_2__Group__0 : rule__Child1_2__Group__0__Impl rule__Child1_2__Group__1 ;
    public final void rule__Child1_2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:1999:1: ( rule__Child1_2__Group__0__Impl rule__Child1_2__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2000:2: rule__Child1_2__Group__0__Impl rule__Child1_2__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child1_2__Group__0__Impl_in_rule__Child1_2__Group__04250);
            rule__Child1_2__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child1_2__Group__1_in_rule__Child1_2__Group__04253);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2007:1: rule__Child1_2__Group__0__Impl : ( ( rule__Child1_2__NameAssignment_0 ) ) ;
    public final void rule__Child1_2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2011:1: ( ( ( rule__Child1_2__NameAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2012:1: ( ( rule__Child1_2__NameAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2012:1: ( ( rule__Child1_2__NameAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2013:1: ( rule__Child1_2__NameAssignment_0 )
            {
             before(grammarAccess.getChild1_2Access().getNameAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2014:1: ( rule__Child1_2__NameAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2014:2: rule__Child1_2__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child1_2__NameAssignment_0_in_rule__Child1_2__Group__0__Impl4280);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2024:1: rule__Child1_2__Group__1 : rule__Child1_2__Group__1__Impl rule__Child1_2__Group__2 ;
    public final void rule__Child1_2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2028:1: ( rule__Child1_2__Group__1__Impl rule__Child1_2__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2029:2: rule__Child1_2__Group__1__Impl rule__Child1_2__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child1_2__Group__1__Impl_in_rule__Child1_2__Group__14310);
            rule__Child1_2__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child1_2__Group__2_in_rule__Child1_2__Group__14313);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2036:1: rule__Child1_2__Group__1__Impl : ( ':' ) ;
    public final void rule__Child1_2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2040:1: ( ( ':' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2041:1: ( ':' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2041:1: ( ':' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2042:1: ':'
            {
             before(grammarAccess.getChild1_2Access().getColonKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Child1_2__Group__1__Impl4341); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2055:1: rule__Child1_2__Group__2 : rule__Child1_2__Group__2__Impl rule__Child1_2__Group__3 ;
    public final void rule__Child1_2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2059:1: ( rule__Child1_2__Group__2__Impl rule__Child1_2__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2060:2: rule__Child1_2__Group__2__Impl rule__Child1_2__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child1_2__Group__2__Impl_in_rule__Child1_2__Group__24372);
            rule__Child1_2__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child1_2__Group__3_in_rule__Child1_2__Group__24375);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2067:1: rule__Child1_2__Group__2__Impl : ( ( rule__Child1_2__Group_2__0 )? ) ;
    public final void rule__Child1_2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2071:1: ( ( ( rule__Child1_2__Group_2__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2072:1: ( ( rule__Child1_2__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2072:1: ( ( rule__Child1_2__Group_2__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2073:1: ( rule__Child1_2__Group_2__0 )?
            {
             before(grammarAccess.getChild1_2Access().getGroup_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2074:1: ( rule__Child1_2__Group_2__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==32) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2074:2: rule__Child1_2__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Child1_2__Group_2__0_in_rule__Child1_2__Group__2__Impl4402);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2084:1: rule__Child1_2__Group__3 : rule__Child1_2__Group__3__Impl rule__Child1_2__Group__4 ;
    public final void rule__Child1_2__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2088:1: ( rule__Child1_2__Group__3__Impl rule__Child1_2__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2089:2: rule__Child1_2__Group__3__Impl rule__Child1_2__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child1_2__Group__3__Impl_in_rule__Child1_2__Group__34433);
            rule__Child1_2__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child1_2__Group__4_in_rule__Child1_2__Group__34436);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2096:1: rule__Child1_2__Group__3__Impl : ( ( rule__Child1_2__EnumTypeAssignment_3 ) ) ;
    public final void rule__Child1_2__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2100:1: ( ( ( rule__Child1_2__EnumTypeAssignment_3 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2101:1: ( ( rule__Child1_2__EnumTypeAssignment_3 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2101:1: ( ( rule__Child1_2__EnumTypeAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2102:1: ( rule__Child1_2__EnumTypeAssignment_3 )
            {
             before(grammarAccess.getChild1_2Access().getEnumTypeAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2103:1: ( rule__Child1_2__EnumTypeAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2103:2: rule__Child1_2__EnumTypeAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child1_2__EnumTypeAssignment_3_in_rule__Child1_2__Group__3__Impl4463);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2113:1: rule__Child1_2__Group__4 : rule__Child1_2__Group__4__Impl rule__Child1_2__Group__5 ;
    public final void rule__Child1_2__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2117:1: ( rule__Child1_2__Group__4__Impl rule__Child1_2__Group__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2118:2: rule__Child1_2__Group__4__Impl rule__Child1_2__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child1_2__Group__4__Impl_in_rule__Child1_2__Group__44493);
            rule__Child1_2__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child1_2__Group__5_in_rule__Child1_2__Group__44496);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2125:1: rule__Child1_2__Group__4__Impl : ( 'child2' ) ;
    public final void rule__Child1_2__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2129:1: ( ( 'child2' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2130:1: ( 'child2' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2130:1: ( 'child2' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2131:1: 'child2'
            {
             before(grammarAccess.getChild1_2Access().getChild2Keyword_4()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__Child1_2__Group__4__Impl4524); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2144:1: rule__Child1_2__Group__5 : rule__Child1_2__Group__5__Impl ;
    public final void rule__Child1_2__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2148:1: ( rule__Child1_2__Group__5__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2149:2: rule__Child1_2__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child1_2__Group__5__Impl_in_rule__Child1_2__Group__54555);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2155:1: rule__Child1_2__Group__5__Impl : ( 'end' ) ;
    public final void rule__Child1_2__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2159:1: ( ( 'end' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2160:1: ( 'end' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2160:1: ( 'end' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2161:1: 'end'
            {
             before(grammarAccess.getChild1_2Access().getEndKeyword_5()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Child1_2__Group__5__Impl4583); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2186:1: rule__Child1_2__Group_2__0 : rule__Child1_2__Group_2__0__Impl rule__Child1_2__Group_2__1 ;
    public final void rule__Child1_2__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2190:1: ( rule__Child1_2__Group_2__0__Impl rule__Child1_2__Group_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2191:2: rule__Child1_2__Group_2__0__Impl rule__Child1_2__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child1_2__Group_2__0__Impl_in_rule__Child1_2__Group_2__04626);
            rule__Child1_2__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child1_2__Group_2__1_in_rule__Child1_2__Group_2__04629);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2198:1: rule__Child1_2__Group_2__0__Impl : ( ( rule__Child1_2__BoolAssignment_2_0 ) ) ;
    public final void rule__Child1_2__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2202:1: ( ( ( rule__Child1_2__BoolAssignment_2_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2203:1: ( ( rule__Child1_2__BoolAssignment_2_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2203:1: ( ( rule__Child1_2__BoolAssignment_2_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2204:1: ( rule__Child1_2__BoolAssignment_2_0 )
            {
             before(grammarAccess.getChild1_2Access().getBoolAssignment_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2205:1: ( rule__Child1_2__BoolAssignment_2_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2205:2: rule__Child1_2__BoolAssignment_2_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child1_2__BoolAssignment_2_0_in_rule__Child1_2__Group_2__0__Impl4656);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2215:1: rule__Child1_2__Group_2__1 : rule__Child1_2__Group_2__1__Impl ;
    public final void rule__Child1_2__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2219:1: ( rule__Child1_2__Group_2__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2220:2: rule__Child1_2__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child1_2__Group_2__1__Impl_in_rule__Child1_2__Group_2__14686);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2226:1: rule__Child1_2__Group_2__1__Impl : ( 'keyword' ) ;
    public final void rule__Child1_2__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2230:1: ( ( 'keyword' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2231:1: ( 'keyword' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2231:1: ( 'keyword' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2232:1: 'keyword'
            {
             before(grammarAccess.getChild1_2Access().getKeywordKeyword_2_1()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__Child1_2__Group_2__1__Impl4714); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2249:1: rule__Child1_3__Group__0 : rule__Child1_3__Group__0__Impl rule__Child1_3__Group__1 ;
    public final void rule__Child1_3__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2253:1: ( rule__Child1_3__Group__0__Impl rule__Child1_3__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2254:2: rule__Child1_3__Group__0__Impl rule__Child1_3__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child1_3__Group__0__Impl_in_rule__Child1_3__Group__04749);
            rule__Child1_3__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child1_3__Group__1_in_rule__Child1_3__Group__04752);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2261:1: rule__Child1_3__Group__0__Impl : ( ( rule__Child1_3__NameAssignment_0 ) ) ;
    public final void rule__Child1_3__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2265:1: ( ( ( rule__Child1_3__NameAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2266:1: ( ( rule__Child1_3__NameAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2266:1: ( ( rule__Child1_3__NameAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2267:1: ( rule__Child1_3__NameAssignment_0 )
            {
             before(grammarAccess.getChild1_3Access().getNameAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2268:1: ( rule__Child1_3__NameAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2268:2: rule__Child1_3__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child1_3__NameAssignment_0_in_rule__Child1_3__Group__0__Impl4779);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2278:1: rule__Child1_3__Group__1 : rule__Child1_3__Group__1__Impl rule__Child1_3__Group__2 ;
    public final void rule__Child1_3__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2282:1: ( rule__Child1_3__Group__1__Impl rule__Child1_3__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2283:2: rule__Child1_3__Group__1__Impl rule__Child1_3__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child1_3__Group__1__Impl_in_rule__Child1_3__Group__14809);
            rule__Child1_3__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child1_3__Group__2_in_rule__Child1_3__Group__14812);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2290:1: rule__Child1_3__Group__1__Impl : ( ':' ) ;
    public final void rule__Child1_3__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2294:1: ( ( ':' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2295:1: ( ':' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2295:1: ( ':' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2296:1: ':'
            {
             before(grammarAccess.getChild1_3Access().getColonKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Child1_3__Group__1__Impl4840); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2309:1: rule__Child1_3__Group__2 : rule__Child1_3__Group__2__Impl rule__Child1_3__Group__3 ;
    public final void rule__Child1_3__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2313:1: ( rule__Child1_3__Group__2__Impl rule__Child1_3__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2314:2: rule__Child1_3__Group__2__Impl rule__Child1_3__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child1_3__Group__2__Impl_in_rule__Child1_3__Group__24871);
            rule__Child1_3__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child1_3__Group__3_in_rule__Child1_3__Group__24874);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2321:1: rule__Child1_3__Group__2__Impl : ( ( rule__Child1_3__Group_2__0 )? ) ;
    public final void rule__Child1_3__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2325:1: ( ( ( rule__Child1_3__Group_2__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2326:1: ( ( rule__Child1_3__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2326:1: ( ( rule__Child1_3__Group_2__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2327:1: ( rule__Child1_3__Group_2__0 )?
            {
             before(grammarAccess.getChild1_3Access().getGroup_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2328:1: ( rule__Child1_3__Group_2__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==32) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2328:2: rule__Child1_3__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Child1_3__Group_2__0_in_rule__Child1_3__Group__2__Impl4901);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2338:1: rule__Child1_3__Group__3 : rule__Child1_3__Group__3__Impl rule__Child1_3__Group__4 ;
    public final void rule__Child1_3__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2342:1: ( rule__Child1_3__Group__3__Impl rule__Child1_3__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2343:2: rule__Child1_3__Group__3__Impl rule__Child1_3__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child1_3__Group__3__Impl_in_rule__Child1_3__Group__34932);
            rule__Child1_3__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child1_3__Group__4_in_rule__Child1_3__Group__34935);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2350:1: rule__Child1_3__Group__3__Impl : ( ( rule__Child1_3__EnumTypeAssignment_3 ) ) ;
    public final void rule__Child1_3__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2354:1: ( ( ( rule__Child1_3__EnumTypeAssignment_3 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2355:1: ( ( rule__Child1_3__EnumTypeAssignment_3 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2355:1: ( ( rule__Child1_3__EnumTypeAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2356:1: ( rule__Child1_3__EnumTypeAssignment_3 )
            {
             before(grammarAccess.getChild1_3Access().getEnumTypeAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2357:1: ( rule__Child1_3__EnumTypeAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2357:2: rule__Child1_3__EnumTypeAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child1_3__EnumTypeAssignment_3_in_rule__Child1_3__Group__3__Impl4962);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2367:1: rule__Child1_3__Group__4 : rule__Child1_3__Group__4__Impl rule__Child1_3__Group__5 ;
    public final void rule__Child1_3__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2371:1: ( rule__Child1_3__Group__4__Impl rule__Child1_3__Group__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2372:2: rule__Child1_3__Group__4__Impl rule__Child1_3__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child1_3__Group__4__Impl_in_rule__Child1_3__Group__44992);
            rule__Child1_3__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child1_3__Group__5_in_rule__Child1_3__Group__44995);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2379:1: rule__Child1_3__Group__4__Impl : ( 'child3' ) ;
    public final void rule__Child1_3__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2383:1: ( ( 'child3' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2384:1: ( 'child3' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2384:1: ( 'child3' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2385:1: 'child3'
            {
             before(grammarAccess.getChild1_3Access().getChild3Keyword_4()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__Child1_3__Group__4__Impl5023); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2398:1: rule__Child1_3__Group__5 : rule__Child1_3__Group__5__Impl ;
    public final void rule__Child1_3__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2402:1: ( rule__Child1_3__Group__5__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2403:2: rule__Child1_3__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child1_3__Group__5__Impl_in_rule__Child1_3__Group__55054);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2409:1: rule__Child1_3__Group__5__Impl : ( 'end' ) ;
    public final void rule__Child1_3__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2413:1: ( ( 'end' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2414:1: ( 'end' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2414:1: ( 'end' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2415:1: 'end'
            {
             before(grammarAccess.getChild1_3Access().getEndKeyword_5()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Child1_3__Group__5__Impl5082); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2440:1: rule__Child1_3__Group_2__0 : rule__Child1_3__Group_2__0__Impl rule__Child1_3__Group_2__1 ;
    public final void rule__Child1_3__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2444:1: ( rule__Child1_3__Group_2__0__Impl rule__Child1_3__Group_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2445:2: rule__Child1_3__Group_2__0__Impl rule__Child1_3__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child1_3__Group_2__0__Impl_in_rule__Child1_3__Group_2__05125);
            rule__Child1_3__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child1_3__Group_2__1_in_rule__Child1_3__Group_2__05128);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2452:1: rule__Child1_3__Group_2__0__Impl : ( ( rule__Child1_3__BoolAssignment_2_0 ) ) ;
    public final void rule__Child1_3__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2456:1: ( ( ( rule__Child1_3__BoolAssignment_2_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2457:1: ( ( rule__Child1_3__BoolAssignment_2_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2457:1: ( ( rule__Child1_3__BoolAssignment_2_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2458:1: ( rule__Child1_3__BoolAssignment_2_0 )
            {
             before(grammarAccess.getChild1_3Access().getBoolAssignment_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2459:1: ( rule__Child1_3__BoolAssignment_2_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2459:2: rule__Child1_3__BoolAssignment_2_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child1_3__BoolAssignment_2_0_in_rule__Child1_3__Group_2__0__Impl5155);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2469:1: rule__Child1_3__Group_2__1 : rule__Child1_3__Group_2__1__Impl ;
    public final void rule__Child1_3__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2473:1: ( rule__Child1_3__Group_2__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2474:2: rule__Child1_3__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child1_3__Group_2__1__Impl_in_rule__Child1_3__Group_2__15185);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2480:1: rule__Child1_3__Group_2__1__Impl : ( 'keyword' ) ;
    public final void rule__Child1_3__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2484:1: ( ( 'keyword' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2485:1: ( 'keyword' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2485:1: ( 'keyword' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2486:1: 'keyword'
            {
             before(grammarAccess.getChild1_3Access().getKeywordKeyword_2_1()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__Child1_3__Group_2__1__Impl5213); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2503:1: rule__Scenario2_1__Group__0 : rule__Scenario2_1__Group__0__Impl rule__Scenario2_1__Group__1 ;
    public final void rule__Scenario2_1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2507:1: ( rule__Scenario2_1__Group__0__Impl rule__Scenario2_1__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2508:2: rule__Scenario2_1__Group__0__Impl rule__Scenario2_1__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_1__Group__0__Impl_in_rule__Scenario2_1__Group__05248);
            rule__Scenario2_1__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_1__Group__1_in_rule__Scenario2_1__Group__05251);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2515:1: rule__Scenario2_1__Group__0__Impl : ( '2.1' ) ;
    public final void rule__Scenario2_1__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2519:1: ( ( '2.1' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2520:1: ( '2.1' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2520:1: ( '2.1' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2521:1: '2.1'
            {
             before(grammarAccess.getScenario2_1Access().getDigitTwoFullStopDigitOneKeyword_0()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__Scenario2_1__Group__0__Impl5279); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2534:1: rule__Scenario2_1__Group__1 : rule__Scenario2_1__Group__1__Impl rule__Scenario2_1__Group__2 ;
    public final void rule__Scenario2_1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2538:1: ( rule__Scenario2_1__Group__1__Impl rule__Scenario2_1__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2539:2: rule__Scenario2_1__Group__1__Impl rule__Scenario2_1__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_1__Group__1__Impl_in_rule__Scenario2_1__Group__15310);
            rule__Scenario2_1__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_1__Group__2_in_rule__Scenario2_1__Group__15313);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2546:1: rule__Scenario2_1__Group__1__Impl : ( ( rule__Scenario2_1__Alternatives_1 ) ) ;
    public final void rule__Scenario2_1__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2550:1: ( ( ( rule__Scenario2_1__Alternatives_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2551:1: ( ( rule__Scenario2_1__Alternatives_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2551:1: ( ( rule__Scenario2_1__Alternatives_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2552:1: ( rule__Scenario2_1__Alternatives_1 )
            {
             before(grammarAccess.getScenario2_1Access().getAlternatives_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2553:1: ( rule__Scenario2_1__Alternatives_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2553:2: rule__Scenario2_1__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_1__Alternatives_1_in_rule__Scenario2_1__Group__1__Impl5340);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2563:1: rule__Scenario2_1__Group__2 : rule__Scenario2_1__Group__2__Impl ;
    public final void rule__Scenario2_1__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2567:1: ( rule__Scenario2_1__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2568:2: rule__Scenario2_1__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_1__Group__2__Impl_in_rule__Scenario2_1__Group__25370);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2574:1: rule__Scenario2_1__Group__2__Impl : ( 'next' ) ;
    public final void rule__Scenario2_1__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2578:1: ( ( 'next' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2579:1: ( 'next' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2579:1: ( 'next' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2580:1: 'next'
            {
             before(grammarAccess.getScenario2_1Access().getNextKeyword_2()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Scenario2_1__Group__2__Impl5398); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2599:1: rule__Scenario2_2__Group__0 : rule__Scenario2_2__Group__0__Impl rule__Scenario2_2__Group__1 ;
    public final void rule__Scenario2_2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2603:1: ( rule__Scenario2_2__Group__0__Impl rule__Scenario2_2__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2604:2: rule__Scenario2_2__Group__0__Impl rule__Scenario2_2__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_2__Group__0__Impl_in_rule__Scenario2_2__Group__05435);
            rule__Scenario2_2__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_2__Group__1_in_rule__Scenario2_2__Group__05438);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2611:1: rule__Scenario2_2__Group__0__Impl : ( '2.2' ) ;
    public final void rule__Scenario2_2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2615:1: ( ( '2.2' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2616:1: ( '2.2' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2616:1: ( '2.2' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2617:1: '2.2'
            {
             before(grammarAccess.getScenario2_2Access().getDigitTwoFullStopDigitTwoKeyword_0()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__Scenario2_2__Group__0__Impl5466); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2630:1: rule__Scenario2_2__Group__1 : rule__Scenario2_2__Group__1__Impl rule__Scenario2_2__Group__2 ;
    public final void rule__Scenario2_2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2634:1: ( rule__Scenario2_2__Group__1__Impl rule__Scenario2_2__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2635:2: rule__Scenario2_2__Group__1__Impl rule__Scenario2_2__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_2__Group__1__Impl_in_rule__Scenario2_2__Group__15497);
            rule__Scenario2_2__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_2__Group__2_in_rule__Scenario2_2__Group__15500);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2642:1: rule__Scenario2_2__Group__1__Impl : ( ( ( rule__Scenario2_2__Alternatives_1 ) ) ( ( rule__Scenario2_2__Alternatives_1 )* ) ) ;
    public final void rule__Scenario2_2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2646:1: ( ( ( ( rule__Scenario2_2__Alternatives_1 ) ) ( ( rule__Scenario2_2__Alternatives_1 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2647:1: ( ( ( rule__Scenario2_2__Alternatives_1 ) ) ( ( rule__Scenario2_2__Alternatives_1 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2647:1: ( ( ( rule__Scenario2_2__Alternatives_1 ) ) ( ( rule__Scenario2_2__Alternatives_1 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2648:1: ( ( rule__Scenario2_2__Alternatives_1 ) ) ( ( rule__Scenario2_2__Alternatives_1 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2648:1: ( ( rule__Scenario2_2__Alternatives_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2649:1: ( rule__Scenario2_2__Alternatives_1 )
            {
             before(grammarAccess.getScenario2_2Access().getAlternatives_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2650:1: ( rule__Scenario2_2__Alternatives_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2650:2: rule__Scenario2_2__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_2__Alternatives_1_in_rule__Scenario2_2__Group__1__Impl5529);
            rule__Scenario2_2__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getScenario2_2Access().getAlternatives_1()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2653:1: ( ( rule__Scenario2_2__Alternatives_1 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2654:1: ( rule__Scenario2_2__Alternatives_1 )*
            {
             before(grammarAccess.getScenario2_2Access().getAlternatives_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2655:1: ( rule__Scenario2_2__Alternatives_1 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_ID) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2655:2: rule__Scenario2_2__Alternatives_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Scenario2_2__Alternatives_1_in_rule__Scenario2_2__Group__1__Impl5541);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2666:1: rule__Scenario2_2__Group__2 : rule__Scenario2_2__Group__2__Impl ;
    public final void rule__Scenario2_2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2670:1: ( rule__Scenario2_2__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2671:2: rule__Scenario2_2__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_2__Group__2__Impl_in_rule__Scenario2_2__Group__25574);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2677:1: rule__Scenario2_2__Group__2__Impl : ( 'next' ) ;
    public final void rule__Scenario2_2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2681:1: ( ( 'next' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2682:1: ( 'next' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2682:1: ( 'next' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2683:1: 'next'
            {
             before(grammarAccess.getScenario2_2Access().getNextKeyword_2()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Scenario2_2__Group__2__Impl5602); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2702:1: rule__Scenario2_3__Group__0 : rule__Scenario2_3__Group__0__Impl rule__Scenario2_3__Group__1 ;
    public final void rule__Scenario2_3__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2706:1: ( rule__Scenario2_3__Group__0__Impl rule__Scenario2_3__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2707:2: rule__Scenario2_3__Group__0__Impl rule__Scenario2_3__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_3__Group__0__Impl_in_rule__Scenario2_3__Group__05639);
            rule__Scenario2_3__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_3__Group__1_in_rule__Scenario2_3__Group__05642);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2714:1: rule__Scenario2_3__Group__0__Impl : ( '2.3' ) ;
    public final void rule__Scenario2_3__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2718:1: ( ( '2.3' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2719:1: ( '2.3' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2719:1: ( '2.3' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2720:1: '2.3'
            {
             before(grammarAccess.getScenario2_3Access().getDigitTwoFullStopDigitThreeKeyword_0()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__Scenario2_3__Group__0__Impl5670); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2733:1: rule__Scenario2_3__Group__1 : rule__Scenario2_3__Group__1__Impl rule__Scenario2_3__Group__2 ;
    public final void rule__Scenario2_3__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2737:1: ( rule__Scenario2_3__Group__1__Impl rule__Scenario2_3__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2738:2: rule__Scenario2_3__Group__1__Impl rule__Scenario2_3__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_3__Group__1__Impl_in_rule__Scenario2_3__Group__15701);
            rule__Scenario2_3__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_3__Group__2_in_rule__Scenario2_3__Group__15704);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2745:1: rule__Scenario2_3__Group__1__Impl : ( ( rule__Scenario2_3__Alternatives_1 ) ) ;
    public final void rule__Scenario2_3__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2749:1: ( ( ( rule__Scenario2_3__Alternatives_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2750:1: ( ( rule__Scenario2_3__Alternatives_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2750:1: ( ( rule__Scenario2_3__Alternatives_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2751:1: ( rule__Scenario2_3__Alternatives_1 )
            {
             before(grammarAccess.getScenario2_3Access().getAlternatives_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2752:1: ( rule__Scenario2_3__Alternatives_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2752:2: rule__Scenario2_3__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_3__Alternatives_1_in_rule__Scenario2_3__Group__1__Impl5731);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2762:1: rule__Scenario2_3__Group__2 : rule__Scenario2_3__Group__2__Impl ;
    public final void rule__Scenario2_3__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2766:1: ( rule__Scenario2_3__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2767:2: rule__Scenario2_3__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_3__Group__2__Impl_in_rule__Scenario2_3__Group__25761);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2773:1: rule__Scenario2_3__Group__2__Impl : ( 'next' ) ;
    public final void rule__Scenario2_3__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2777:1: ( ( 'next' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2778:1: ( 'next' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2778:1: ( 'next' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2779:1: 'next'
            {
             before(grammarAccess.getScenario2_3Access().getNextKeyword_2()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Scenario2_3__Group__2__Impl5789); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2798:1: rule__Scenario2_4__Group__0 : rule__Scenario2_4__Group__0__Impl rule__Scenario2_4__Group__1 ;
    public final void rule__Scenario2_4__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2802:1: ( rule__Scenario2_4__Group__0__Impl rule__Scenario2_4__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2803:2: rule__Scenario2_4__Group__0__Impl rule__Scenario2_4__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_4__Group__0__Impl_in_rule__Scenario2_4__Group__05826);
            rule__Scenario2_4__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_4__Group__1_in_rule__Scenario2_4__Group__05829);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2810:1: rule__Scenario2_4__Group__0__Impl : ( '2.4' ) ;
    public final void rule__Scenario2_4__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2814:1: ( ( '2.4' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2815:1: ( '2.4' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2815:1: ( '2.4' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2816:1: '2.4'
            {
             before(grammarAccess.getScenario2_4Access().getDigitTwoFullStopDigitFourKeyword_0()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__Scenario2_4__Group__0__Impl5857); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2829:1: rule__Scenario2_4__Group__1 : rule__Scenario2_4__Group__1__Impl rule__Scenario2_4__Group__2 ;
    public final void rule__Scenario2_4__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2833:1: ( rule__Scenario2_4__Group__1__Impl rule__Scenario2_4__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2834:2: rule__Scenario2_4__Group__1__Impl rule__Scenario2_4__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_4__Group__1__Impl_in_rule__Scenario2_4__Group__15888);
            rule__Scenario2_4__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_4__Group__2_in_rule__Scenario2_4__Group__15891);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2841:1: rule__Scenario2_4__Group__1__Impl : ( ( ( rule__Scenario2_4__Alternatives_1 ) ) ( ( rule__Scenario2_4__Alternatives_1 )* ) ) ;
    public final void rule__Scenario2_4__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2845:1: ( ( ( ( rule__Scenario2_4__Alternatives_1 ) ) ( ( rule__Scenario2_4__Alternatives_1 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2846:1: ( ( ( rule__Scenario2_4__Alternatives_1 ) ) ( ( rule__Scenario2_4__Alternatives_1 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2846:1: ( ( ( rule__Scenario2_4__Alternatives_1 ) ) ( ( rule__Scenario2_4__Alternatives_1 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2847:1: ( ( rule__Scenario2_4__Alternatives_1 ) ) ( ( rule__Scenario2_4__Alternatives_1 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2847:1: ( ( rule__Scenario2_4__Alternatives_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2848:1: ( rule__Scenario2_4__Alternatives_1 )
            {
             before(grammarAccess.getScenario2_4Access().getAlternatives_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2849:1: ( rule__Scenario2_4__Alternatives_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2849:2: rule__Scenario2_4__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_4__Alternatives_1_in_rule__Scenario2_4__Group__1__Impl5920);
            rule__Scenario2_4__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getScenario2_4Access().getAlternatives_1()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2852:1: ( ( rule__Scenario2_4__Alternatives_1 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2853:1: ( rule__Scenario2_4__Alternatives_1 )*
            {
             before(grammarAccess.getScenario2_4Access().getAlternatives_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2854:1: ( rule__Scenario2_4__Alternatives_1 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_ID) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2854:2: rule__Scenario2_4__Alternatives_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Scenario2_4__Alternatives_1_in_rule__Scenario2_4__Group__1__Impl5932);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2865:1: rule__Scenario2_4__Group__2 : rule__Scenario2_4__Group__2__Impl ;
    public final void rule__Scenario2_4__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2869:1: ( rule__Scenario2_4__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2870:2: rule__Scenario2_4__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_4__Group__2__Impl_in_rule__Scenario2_4__Group__25965);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2876:1: rule__Scenario2_4__Group__2__Impl : ( 'next' ) ;
    public final void rule__Scenario2_4__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2880:1: ( ( 'next' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2881:1: ( 'next' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2881:1: ( 'next' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2882:1: 'next'
            {
             before(grammarAccess.getScenario2_4Access().getNextKeyword_2()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Scenario2_4__Group__2__Impl5993); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2901:1: rule__Scenario2_5__Group__0 : rule__Scenario2_5__Group__0__Impl rule__Scenario2_5__Group__1 ;
    public final void rule__Scenario2_5__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2905:1: ( rule__Scenario2_5__Group__0__Impl rule__Scenario2_5__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2906:2: rule__Scenario2_5__Group__0__Impl rule__Scenario2_5__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_5__Group__0__Impl_in_rule__Scenario2_5__Group__06030);
            rule__Scenario2_5__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_5__Group__1_in_rule__Scenario2_5__Group__06033);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2913:1: rule__Scenario2_5__Group__0__Impl : ( () ) ;
    public final void rule__Scenario2_5__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2917:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2918:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2918:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2919:1: ()
            {
             before(grammarAccess.getScenario2_5Access().getScenario2Action_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2920:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2922:1: 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2932:1: rule__Scenario2_5__Group__1 : rule__Scenario2_5__Group__1__Impl rule__Scenario2_5__Group__2 ;
    public final void rule__Scenario2_5__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2936:1: ( rule__Scenario2_5__Group__1__Impl rule__Scenario2_5__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2937:2: rule__Scenario2_5__Group__1__Impl rule__Scenario2_5__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_5__Group__1__Impl_in_rule__Scenario2_5__Group__16091);
            rule__Scenario2_5__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_5__Group__2_in_rule__Scenario2_5__Group__16094);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2944:1: rule__Scenario2_5__Group__1__Impl : ( '2.5' ) ;
    public final void rule__Scenario2_5__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2948:1: ( ( '2.5' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2949:1: ( '2.5' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2949:1: ( '2.5' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2950:1: '2.5'
            {
             before(grammarAccess.getScenario2_5Access().getDigitTwoFullStopDigitFiveKeyword_1()); 
            match(input,28,FollowSets000.FOLLOW_28_in_rule__Scenario2_5__Group__1__Impl6122); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2963:1: rule__Scenario2_5__Group__2 : rule__Scenario2_5__Group__2__Impl rule__Scenario2_5__Group__3 ;
    public final void rule__Scenario2_5__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2967:1: ( rule__Scenario2_5__Group__2__Impl rule__Scenario2_5__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2968:2: rule__Scenario2_5__Group__2__Impl rule__Scenario2_5__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_5__Group__2__Impl_in_rule__Scenario2_5__Group__26153);
            rule__Scenario2_5__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_5__Group__3_in_rule__Scenario2_5__Group__26156);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2975:1: rule__Scenario2_5__Group__2__Impl : ( ( rule__Scenario2_5__Alternatives_2 )? ) ;
    public final void rule__Scenario2_5__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2979:1: ( ( ( rule__Scenario2_5__Alternatives_2 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2980:1: ( ( rule__Scenario2_5__Alternatives_2 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2980:1: ( ( rule__Scenario2_5__Alternatives_2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2981:1: ( rule__Scenario2_5__Alternatives_2 )?
            {
             before(grammarAccess.getScenario2_5Access().getAlternatives_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2982:1: ( rule__Scenario2_5__Alternatives_2 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_ID) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2982:2: rule__Scenario2_5__Alternatives_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario2_5__Alternatives_2_in_rule__Scenario2_5__Group__2__Impl6183);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2992:1: rule__Scenario2_5__Group__3 : rule__Scenario2_5__Group__3__Impl ;
    public final void rule__Scenario2_5__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2996:1: ( rule__Scenario2_5__Group__3__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:2997:2: rule__Scenario2_5__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_5__Group__3__Impl_in_rule__Scenario2_5__Group__36214);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3003:1: rule__Scenario2_5__Group__3__Impl : ( 'next' ) ;
    public final void rule__Scenario2_5__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3007:1: ( ( 'next' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3008:1: ( 'next' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3008:1: ( 'next' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3009:1: 'next'
            {
             before(grammarAccess.getScenario2_5Access().getNextKeyword_3()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Scenario2_5__Group__3__Impl6242); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3030:1: rule__Scenario2_6__Group__0 : rule__Scenario2_6__Group__0__Impl rule__Scenario2_6__Group__1 ;
    public final void rule__Scenario2_6__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3034:1: ( rule__Scenario2_6__Group__0__Impl rule__Scenario2_6__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3035:2: rule__Scenario2_6__Group__0__Impl rule__Scenario2_6__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_6__Group__0__Impl_in_rule__Scenario2_6__Group__06281);
            rule__Scenario2_6__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_6__Group__1_in_rule__Scenario2_6__Group__06284);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3042:1: rule__Scenario2_6__Group__0__Impl : ( () ) ;
    public final void rule__Scenario2_6__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3046:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3047:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3047:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3048:1: ()
            {
             before(grammarAccess.getScenario2_6Access().getScenario2Action_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3049:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3051:1: 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3061:1: rule__Scenario2_6__Group__1 : rule__Scenario2_6__Group__1__Impl rule__Scenario2_6__Group__2 ;
    public final void rule__Scenario2_6__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3065:1: ( rule__Scenario2_6__Group__1__Impl rule__Scenario2_6__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3066:2: rule__Scenario2_6__Group__1__Impl rule__Scenario2_6__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_6__Group__1__Impl_in_rule__Scenario2_6__Group__16342);
            rule__Scenario2_6__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_6__Group__2_in_rule__Scenario2_6__Group__16345);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3073:1: rule__Scenario2_6__Group__1__Impl : ( '2.6' ) ;
    public final void rule__Scenario2_6__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3077:1: ( ( '2.6' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3078:1: ( '2.6' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3078:1: ( '2.6' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3079:1: '2.6'
            {
             before(grammarAccess.getScenario2_6Access().getDigitTwoFullStopDigitSixKeyword_1()); 
            match(input,29,FollowSets000.FOLLOW_29_in_rule__Scenario2_6__Group__1__Impl6373); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3092:1: rule__Scenario2_6__Group__2 : rule__Scenario2_6__Group__2__Impl rule__Scenario2_6__Group__3 ;
    public final void rule__Scenario2_6__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3096:1: ( rule__Scenario2_6__Group__2__Impl rule__Scenario2_6__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3097:2: rule__Scenario2_6__Group__2__Impl rule__Scenario2_6__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_6__Group__2__Impl_in_rule__Scenario2_6__Group__26404);
            rule__Scenario2_6__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_6__Group__3_in_rule__Scenario2_6__Group__26407);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3104:1: rule__Scenario2_6__Group__2__Impl : ( ( rule__Scenario2_6__Alternatives_2 )* ) ;
    public final void rule__Scenario2_6__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3108:1: ( ( ( rule__Scenario2_6__Alternatives_2 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3109:1: ( ( rule__Scenario2_6__Alternatives_2 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3109:1: ( ( rule__Scenario2_6__Alternatives_2 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3110:1: ( rule__Scenario2_6__Alternatives_2 )*
            {
             before(grammarAccess.getScenario2_6Access().getAlternatives_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3111:1: ( rule__Scenario2_6__Alternatives_2 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_ID) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3111:2: rule__Scenario2_6__Alternatives_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Scenario2_6__Alternatives_2_in_rule__Scenario2_6__Group__2__Impl6434);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3121:1: rule__Scenario2_6__Group__3 : rule__Scenario2_6__Group__3__Impl ;
    public final void rule__Scenario2_6__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3125:1: ( rule__Scenario2_6__Group__3__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3126:2: rule__Scenario2_6__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_6__Group__3__Impl_in_rule__Scenario2_6__Group__36465);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3132:1: rule__Scenario2_6__Group__3__Impl : ( 'next' ) ;
    public final void rule__Scenario2_6__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3136:1: ( ( 'next' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3137:1: ( 'next' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3137:1: ( 'next' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3138:1: 'next'
            {
             before(grammarAccess.getScenario2_6Access().getNextKeyword_3()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Scenario2_6__Group__3__Impl6493); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3159:1: rule__Scenario2_7__Group__0 : rule__Scenario2_7__Group__0__Impl rule__Scenario2_7__Group__1 ;
    public final void rule__Scenario2_7__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3163:1: ( rule__Scenario2_7__Group__0__Impl rule__Scenario2_7__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3164:2: rule__Scenario2_7__Group__0__Impl rule__Scenario2_7__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_7__Group__0__Impl_in_rule__Scenario2_7__Group__06532);
            rule__Scenario2_7__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_7__Group__1_in_rule__Scenario2_7__Group__06535);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3171:1: rule__Scenario2_7__Group__0__Impl : ( () ) ;
    public final void rule__Scenario2_7__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3175:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3176:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3176:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3177:1: ()
            {
             before(grammarAccess.getScenario2_7Access().getScenario2Action_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3178:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3180:1: 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3190:1: rule__Scenario2_7__Group__1 : rule__Scenario2_7__Group__1__Impl rule__Scenario2_7__Group__2 ;
    public final void rule__Scenario2_7__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3194:1: ( rule__Scenario2_7__Group__1__Impl rule__Scenario2_7__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3195:2: rule__Scenario2_7__Group__1__Impl rule__Scenario2_7__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_7__Group__1__Impl_in_rule__Scenario2_7__Group__16593);
            rule__Scenario2_7__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_7__Group__2_in_rule__Scenario2_7__Group__16596);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3202:1: rule__Scenario2_7__Group__1__Impl : ( '2.7' ) ;
    public final void rule__Scenario2_7__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3206:1: ( ( '2.7' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3207:1: ( '2.7' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3207:1: ( '2.7' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3208:1: '2.7'
            {
             before(grammarAccess.getScenario2_7Access().getDigitTwoFullStopDigitSevenKeyword_1()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__Scenario2_7__Group__1__Impl6624); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3221:1: rule__Scenario2_7__Group__2 : rule__Scenario2_7__Group__2__Impl rule__Scenario2_7__Group__3 ;
    public final void rule__Scenario2_7__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3225:1: ( rule__Scenario2_7__Group__2__Impl rule__Scenario2_7__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3226:2: rule__Scenario2_7__Group__2__Impl rule__Scenario2_7__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_7__Group__2__Impl_in_rule__Scenario2_7__Group__26655);
            rule__Scenario2_7__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_7__Group__3_in_rule__Scenario2_7__Group__26658);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3233:1: rule__Scenario2_7__Group__2__Impl : ( ( rule__Scenario2_7__Alternatives_2 )? ) ;
    public final void rule__Scenario2_7__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3237:1: ( ( ( rule__Scenario2_7__Alternatives_2 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3238:1: ( ( rule__Scenario2_7__Alternatives_2 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3238:1: ( ( rule__Scenario2_7__Alternatives_2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3239:1: ( rule__Scenario2_7__Alternatives_2 )?
            {
             before(grammarAccess.getScenario2_7Access().getAlternatives_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3240:1: ( rule__Scenario2_7__Alternatives_2 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_ID) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3240:2: rule__Scenario2_7__Alternatives_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Scenario2_7__Alternatives_2_in_rule__Scenario2_7__Group__2__Impl6685);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3250:1: rule__Scenario2_7__Group__3 : rule__Scenario2_7__Group__3__Impl ;
    public final void rule__Scenario2_7__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3254:1: ( rule__Scenario2_7__Group__3__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3255:2: rule__Scenario2_7__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_7__Group__3__Impl_in_rule__Scenario2_7__Group__36716);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3261:1: rule__Scenario2_7__Group__3__Impl : ( 'next' ) ;
    public final void rule__Scenario2_7__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3265:1: ( ( 'next' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3266:1: ( 'next' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3266:1: ( 'next' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3267:1: 'next'
            {
             before(grammarAccess.getScenario2_7Access().getNextKeyword_3()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Scenario2_7__Group__3__Impl6744); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3288:1: rule__Scenario2_8__Group__0 : rule__Scenario2_8__Group__0__Impl rule__Scenario2_8__Group__1 ;
    public final void rule__Scenario2_8__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3292:1: ( rule__Scenario2_8__Group__0__Impl rule__Scenario2_8__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3293:2: rule__Scenario2_8__Group__0__Impl rule__Scenario2_8__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_8__Group__0__Impl_in_rule__Scenario2_8__Group__06783);
            rule__Scenario2_8__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_8__Group__1_in_rule__Scenario2_8__Group__06786);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3300:1: rule__Scenario2_8__Group__0__Impl : ( () ) ;
    public final void rule__Scenario2_8__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3304:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3305:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3305:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3306:1: ()
            {
             before(grammarAccess.getScenario2_8Access().getScenario2Action_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3307:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3309:1: 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3319:1: rule__Scenario2_8__Group__1 : rule__Scenario2_8__Group__1__Impl rule__Scenario2_8__Group__2 ;
    public final void rule__Scenario2_8__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3323:1: ( rule__Scenario2_8__Group__1__Impl rule__Scenario2_8__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3324:2: rule__Scenario2_8__Group__1__Impl rule__Scenario2_8__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_8__Group__1__Impl_in_rule__Scenario2_8__Group__16844);
            rule__Scenario2_8__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_8__Group__2_in_rule__Scenario2_8__Group__16847);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3331:1: rule__Scenario2_8__Group__1__Impl : ( '2.8' ) ;
    public final void rule__Scenario2_8__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3335:1: ( ( '2.8' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3336:1: ( '2.8' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3336:1: ( '2.8' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3337:1: '2.8'
            {
             before(grammarAccess.getScenario2_8Access().getDigitTwoFullStopDigitEightKeyword_1()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__Scenario2_8__Group__1__Impl6875); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3350:1: rule__Scenario2_8__Group__2 : rule__Scenario2_8__Group__2__Impl rule__Scenario2_8__Group__3 ;
    public final void rule__Scenario2_8__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3354:1: ( rule__Scenario2_8__Group__2__Impl rule__Scenario2_8__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3355:2: rule__Scenario2_8__Group__2__Impl rule__Scenario2_8__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_8__Group__2__Impl_in_rule__Scenario2_8__Group__26906);
            rule__Scenario2_8__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_8__Group__3_in_rule__Scenario2_8__Group__26909);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3362:1: rule__Scenario2_8__Group__2__Impl : ( ( rule__Scenario2_8__Alternatives_2 )* ) ;
    public final void rule__Scenario2_8__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3366:1: ( ( ( rule__Scenario2_8__Alternatives_2 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3367:1: ( ( rule__Scenario2_8__Alternatives_2 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3367:1: ( ( rule__Scenario2_8__Alternatives_2 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3368:1: ( rule__Scenario2_8__Alternatives_2 )*
            {
             before(grammarAccess.getScenario2_8Access().getAlternatives_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3369:1: ( rule__Scenario2_8__Alternatives_2 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_ID) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3369:2: rule__Scenario2_8__Alternatives_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Scenario2_8__Alternatives_2_in_rule__Scenario2_8__Group__2__Impl6936);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3379:1: rule__Scenario2_8__Group__3 : rule__Scenario2_8__Group__3__Impl ;
    public final void rule__Scenario2_8__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3383:1: ( rule__Scenario2_8__Group__3__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3384:2: rule__Scenario2_8__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario2_8__Group__3__Impl_in_rule__Scenario2_8__Group__36967);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3390:1: rule__Scenario2_8__Group__3__Impl : ( 'next' ) ;
    public final void rule__Scenario2_8__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3394:1: ( ( 'next' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3395:1: ( 'next' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3395:1: ( 'next' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3396:1: 'next'
            {
             before(grammarAccess.getScenario2_8Access().getNextKeyword_3()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Scenario2_8__Group__3__Impl6995); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3417:1: rule__Child2_1__Group__0 : rule__Child2_1__Group__0__Impl rule__Child2_1__Group__1 ;
    public final void rule__Child2_1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3421:1: ( rule__Child2_1__Group__0__Impl rule__Child2_1__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3422:2: rule__Child2_1__Group__0__Impl rule__Child2_1__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_1__Group__0__Impl_in_rule__Child2_1__Group__07034);
            rule__Child2_1__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child2_1__Group__1_in_rule__Child2_1__Group__07037);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3429:1: rule__Child2_1__Group__0__Impl : ( ( rule__Child2_1__NameAssignment_0 ) ) ;
    public final void rule__Child2_1__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3433:1: ( ( ( rule__Child2_1__NameAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3434:1: ( ( rule__Child2_1__NameAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3434:1: ( ( rule__Child2_1__NameAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3435:1: ( rule__Child2_1__NameAssignment_0 )
            {
             before(grammarAccess.getChild2_1Access().getNameAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3436:1: ( rule__Child2_1__NameAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3436:2: rule__Child2_1__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_1__NameAssignment_0_in_rule__Child2_1__Group__0__Impl7064);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3446:1: rule__Child2_1__Group__1 : rule__Child2_1__Group__1__Impl rule__Child2_1__Group__2 ;
    public final void rule__Child2_1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3450:1: ( rule__Child2_1__Group__1__Impl rule__Child2_1__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3451:2: rule__Child2_1__Group__1__Impl rule__Child2_1__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_1__Group__1__Impl_in_rule__Child2_1__Group__17094);
            rule__Child2_1__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child2_1__Group__2_in_rule__Child2_1__Group__17097);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3458:1: rule__Child2_1__Group__1__Impl : ( ':' ) ;
    public final void rule__Child2_1__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3462:1: ( ( ':' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3463:1: ( ':' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3463:1: ( ':' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3464:1: ':'
            {
             before(grammarAccess.getChild2_1Access().getColonKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Child2_1__Group__1__Impl7125); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3477:1: rule__Child2_1__Group__2 : rule__Child2_1__Group__2__Impl rule__Child2_1__Group__3 ;
    public final void rule__Child2_1__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3481:1: ( rule__Child2_1__Group__2__Impl rule__Child2_1__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3482:2: rule__Child2_1__Group__2__Impl rule__Child2_1__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_1__Group__2__Impl_in_rule__Child2_1__Group__27156);
            rule__Child2_1__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child2_1__Group__3_in_rule__Child2_1__Group__27159);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3489:1: rule__Child2_1__Group__2__Impl : ( ( rule__Child2_1__Group_2__0 )? ) ;
    public final void rule__Child2_1__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3493:1: ( ( ( rule__Child2_1__Group_2__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3494:1: ( ( rule__Child2_1__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3494:1: ( ( rule__Child2_1__Group_2__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3495:1: ( rule__Child2_1__Group_2__0 )?
            {
             before(grammarAccess.getChild2_1Access().getGroup_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3496:1: ( rule__Child2_1__Group_2__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==32) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3496:2: rule__Child2_1__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Child2_1__Group_2__0_in_rule__Child2_1__Group__2__Impl7186);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3506:1: rule__Child2_1__Group__3 : rule__Child2_1__Group__3__Impl rule__Child2_1__Group__4 ;
    public final void rule__Child2_1__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3510:1: ( rule__Child2_1__Group__3__Impl rule__Child2_1__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3511:2: rule__Child2_1__Group__3__Impl rule__Child2_1__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_1__Group__3__Impl_in_rule__Child2_1__Group__37217);
            rule__Child2_1__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child2_1__Group__4_in_rule__Child2_1__Group__37220);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3518:1: rule__Child2_1__Group__3__Impl : ( ( rule__Child2_1__StringAssignment_3 ) ) ;
    public final void rule__Child2_1__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3522:1: ( ( ( rule__Child2_1__StringAssignment_3 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3523:1: ( ( rule__Child2_1__StringAssignment_3 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3523:1: ( ( rule__Child2_1__StringAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3524:1: ( rule__Child2_1__StringAssignment_3 )
            {
             before(grammarAccess.getChild2_1Access().getStringAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3525:1: ( rule__Child2_1__StringAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3525:2: rule__Child2_1__StringAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_1__StringAssignment_3_in_rule__Child2_1__Group__3__Impl7247);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3535:1: rule__Child2_1__Group__4 : rule__Child2_1__Group__4__Impl rule__Child2_1__Group__5 ;
    public final void rule__Child2_1__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3539:1: ( rule__Child2_1__Group__4__Impl rule__Child2_1__Group__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3540:2: rule__Child2_1__Group__4__Impl rule__Child2_1__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_1__Group__4__Impl_in_rule__Child2_1__Group__47277);
            rule__Child2_1__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child2_1__Group__5_in_rule__Child2_1__Group__47280);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3547:1: rule__Child2_1__Group__4__Impl : ( 'child1' ) ;
    public final void rule__Child2_1__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3551:1: ( ( 'child1' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3552:1: ( 'child1' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3552:1: ( 'child1' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3553:1: 'child1'
            {
             before(grammarAccess.getChild2_1Access().getChild1Keyword_4()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Child2_1__Group__4__Impl7308); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3566:1: rule__Child2_1__Group__5 : rule__Child2_1__Group__5__Impl ;
    public final void rule__Child2_1__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3570:1: ( rule__Child2_1__Group__5__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3571:2: rule__Child2_1__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_1__Group__5__Impl_in_rule__Child2_1__Group__57339);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3577:1: rule__Child2_1__Group__5__Impl : ( 'end' ) ;
    public final void rule__Child2_1__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3581:1: ( ( 'end' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3582:1: ( 'end' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3582:1: ( 'end' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3583:1: 'end'
            {
             before(grammarAccess.getChild2_1Access().getEndKeyword_5()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Child2_1__Group__5__Impl7367); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3608:1: rule__Child2_1__Group_2__0 : rule__Child2_1__Group_2__0__Impl rule__Child2_1__Group_2__1 ;
    public final void rule__Child2_1__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3612:1: ( rule__Child2_1__Group_2__0__Impl rule__Child2_1__Group_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3613:2: rule__Child2_1__Group_2__0__Impl rule__Child2_1__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_1__Group_2__0__Impl_in_rule__Child2_1__Group_2__07410);
            rule__Child2_1__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child2_1__Group_2__1_in_rule__Child2_1__Group_2__07413);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3620:1: rule__Child2_1__Group_2__0__Impl : ( ( rule__Child2_1__BoolAssignment_2_0 ) ) ;
    public final void rule__Child2_1__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3624:1: ( ( ( rule__Child2_1__BoolAssignment_2_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3625:1: ( ( rule__Child2_1__BoolAssignment_2_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3625:1: ( ( rule__Child2_1__BoolAssignment_2_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3626:1: ( rule__Child2_1__BoolAssignment_2_0 )
            {
             before(grammarAccess.getChild2_1Access().getBoolAssignment_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3627:1: ( rule__Child2_1__BoolAssignment_2_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3627:2: rule__Child2_1__BoolAssignment_2_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_1__BoolAssignment_2_0_in_rule__Child2_1__Group_2__0__Impl7440);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3637:1: rule__Child2_1__Group_2__1 : rule__Child2_1__Group_2__1__Impl ;
    public final void rule__Child2_1__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3641:1: ( rule__Child2_1__Group_2__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3642:2: rule__Child2_1__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_1__Group_2__1__Impl_in_rule__Child2_1__Group_2__17470);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3648:1: rule__Child2_1__Group_2__1__Impl : ( 'keyword' ) ;
    public final void rule__Child2_1__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3652:1: ( ( 'keyword' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3653:1: ( 'keyword' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3653:1: ( 'keyword' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3654:1: 'keyword'
            {
             before(grammarAccess.getChild2_1Access().getKeywordKeyword_2_1()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__Child2_1__Group_2__1__Impl7498); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3671:1: rule__Child2_2__Group__0 : rule__Child2_2__Group__0__Impl rule__Child2_2__Group__1 ;
    public final void rule__Child2_2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3675:1: ( rule__Child2_2__Group__0__Impl rule__Child2_2__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3676:2: rule__Child2_2__Group__0__Impl rule__Child2_2__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_2__Group__0__Impl_in_rule__Child2_2__Group__07533);
            rule__Child2_2__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child2_2__Group__1_in_rule__Child2_2__Group__07536);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3683:1: rule__Child2_2__Group__0__Impl : ( ( rule__Child2_2__NameAssignment_0 ) ) ;
    public final void rule__Child2_2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3687:1: ( ( ( rule__Child2_2__NameAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3688:1: ( ( rule__Child2_2__NameAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3688:1: ( ( rule__Child2_2__NameAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3689:1: ( rule__Child2_2__NameAssignment_0 )
            {
             before(grammarAccess.getChild2_2Access().getNameAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3690:1: ( rule__Child2_2__NameAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3690:2: rule__Child2_2__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_2__NameAssignment_0_in_rule__Child2_2__Group__0__Impl7563);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3700:1: rule__Child2_2__Group__1 : rule__Child2_2__Group__1__Impl rule__Child2_2__Group__2 ;
    public final void rule__Child2_2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3704:1: ( rule__Child2_2__Group__1__Impl rule__Child2_2__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3705:2: rule__Child2_2__Group__1__Impl rule__Child2_2__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_2__Group__1__Impl_in_rule__Child2_2__Group__17593);
            rule__Child2_2__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child2_2__Group__2_in_rule__Child2_2__Group__17596);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3712:1: rule__Child2_2__Group__1__Impl : ( ':' ) ;
    public final void rule__Child2_2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3716:1: ( ( ':' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3717:1: ( ':' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3717:1: ( ':' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3718:1: ':'
            {
             before(grammarAccess.getChild2_2Access().getColonKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Child2_2__Group__1__Impl7624); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3731:1: rule__Child2_2__Group__2 : rule__Child2_2__Group__2__Impl rule__Child2_2__Group__3 ;
    public final void rule__Child2_2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3735:1: ( rule__Child2_2__Group__2__Impl rule__Child2_2__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3736:2: rule__Child2_2__Group__2__Impl rule__Child2_2__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_2__Group__2__Impl_in_rule__Child2_2__Group__27655);
            rule__Child2_2__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child2_2__Group__3_in_rule__Child2_2__Group__27658);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3743:1: rule__Child2_2__Group__2__Impl : ( ( rule__Child2_2__Group_2__0 )? ) ;
    public final void rule__Child2_2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3747:1: ( ( ( rule__Child2_2__Group_2__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3748:1: ( ( rule__Child2_2__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3748:1: ( ( rule__Child2_2__Group_2__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3749:1: ( rule__Child2_2__Group_2__0 )?
            {
             before(grammarAccess.getChild2_2Access().getGroup_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3750:1: ( rule__Child2_2__Group_2__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==32) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3750:2: rule__Child2_2__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Child2_2__Group_2__0_in_rule__Child2_2__Group__2__Impl7685);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3760:1: rule__Child2_2__Group__3 : rule__Child2_2__Group__3__Impl rule__Child2_2__Group__4 ;
    public final void rule__Child2_2__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3764:1: ( rule__Child2_2__Group__3__Impl rule__Child2_2__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3765:2: rule__Child2_2__Group__3__Impl rule__Child2_2__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_2__Group__3__Impl_in_rule__Child2_2__Group__37716);
            rule__Child2_2__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child2_2__Group__4_in_rule__Child2_2__Group__37719);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3772:1: rule__Child2_2__Group__3__Impl : ( ( rule__Child2_2__StringAssignment_3 ) ) ;
    public final void rule__Child2_2__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3776:1: ( ( ( rule__Child2_2__StringAssignment_3 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3777:1: ( ( rule__Child2_2__StringAssignment_3 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3777:1: ( ( rule__Child2_2__StringAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3778:1: ( rule__Child2_2__StringAssignment_3 )
            {
             before(grammarAccess.getChild2_2Access().getStringAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3779:1: ( rule__Child2_2__StringAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3779:2: rule__Child2_2__StringAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_2__StringAssignment_3_in_rule__Child2_2__Group__3__Impl7746);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3789:1: rule__Child2_2__Group__4 : rule__Child2_2__Group__4__Impl rule__Child2_2__Group__5 ;
    public final void rule__Child2_2__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3793:1: ( rule__Child2_2__Group__4__Impl rule__Child2_2__Group__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3794:2: rule__Child2_2__Group__4__Impl rule__Child2_2__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_2__Group__4__Impl_in_rule__Child2_2__Group__47776);
            rule__Child2_2__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child2_2__Group__5_in_rule__Child2_2__Group__47779);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3801:1: rule__Child2_2__Group__4__Impl : ( 'child2' ) ;
    public final void rule__Child2_2__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3805:1: ( ( 'child2' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3806:1: ( 'child2' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3806:1: ( 'child2' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3807:1: 'child2'
            {
             before(grammarAccess.getChild2_2Access().getChild2Keyword_4()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__Child2_2__Group__4__Impl7807); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3820:1: rule__Child2_2__Group__5 : rule__Child2_2__Group__5__Impl ;
    public final void rule__Child2_2__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3824:1: ( rule__Child2_2__Group__5__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3825:2: rule__Child2_2__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_2__Group__5__Impl_in_rule__Child2_2__Group__57838);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3831:1: rule__Child2_2__Group__5__Impl : ( 'end' ) ;
    public final void rule__Child2_2__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3835:1: ( ( 'end' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3836:1: ( 'end' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3836:1: ( 'end' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3837:1: 'end'
            {
             before(grammarAccess.getChild2_2Access().getEndKeyword_5()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Child2_2__Group__5__Impl7866); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3862:1: rule__Child2_2__Group_2__0 : rule__Child2_2__Group_2__0__Impl rule__Child2_2__Group_2__1 ;
    public final void rule__Child2_2__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3866:1: ( rule__Child2_2__Group_2__0__Impl rule__Child2_2__Group_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3867:2: rule__Child2_2__Group_2__0__Impl rule__Child2_2__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_2__Group_2__0__Impl_in_rule__Child2_2__Group_2__07909);
            rule__Child2_2__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child2_2__Group_2__1_in_rule__Child2_2__Group_2__07912);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3874:1: rule__Child2_2__Group_2__0__Impl : ( ( rule__Child2_2__BoolAssignment_2_0 ) ) ;
    public final void rule__Child2_2__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3878:1: ( ( ( rule__Child2_2__BoolAssignment_2_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3879:1: ( ( rule__Child2_2__BoolAssignment_2_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3879:1: ( ( rule__Child2_2__BoolAssignment_2_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3880:1: ( rule__Child2_2__BoolAssignment_2_0 )
            {
             before(grammarAccess.getChild2_2Access().getBoolAssignment_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3881:1: ( rule__Child2_2__BoolAssignment_2_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3881:2: rule__Child2_2__BoolAssignment_2_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_2__BoolAssignment_2_0_in_rule__Child2_2__Group_2__0__Impl7939);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3891:1: rule__Child2_2__Group_2__1 : rule__Child2_2__Group_2__1__Impl ;
    public final void rule__Child2_2__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3895:1: ( rule__Child2_2__Group_2__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3896:2: rule__Child2_2__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_2__Group_2__1__Impl_in_rule__Child2_2__Group_2__17969);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3902:1: rule__Child2_2__Group_2__1__Impl : ( 'keyword' ) ;
    public final void rule__Child2_2__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3906:1: ( ( 'keyword' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3907:1: ( 'keyword' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3907:1: ( 'keyword' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3908:1: 'keyword'
            {
             before(grammarAccess.getChild2_2Access().getKeywordKeyword_2_1()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__Child2_2__Group_2__1__Impl7997); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3925:1: rule__Child2_3__Group__0 : rule__Child2_3__Group__0__Impl rule__Child2_3__Group__1 ;
    public final void rule__Child2_3__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3929:1: ( rule__Child2_3__Group__0__Impl rule__Child2_3__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3930:2: rule__Child2_3__Group__0__Impl rule__Child2_3__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_3__Group__0__Impl_in_rule__Child2_3__Group__08032);
            rule__Child2_3__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child2_3__Group__1_in_rule__Child2_3__Group__08035);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3937:1: rule__Child2_3__Group__0__Impl : ( ( rule__Child2_3__NameAssignment_0 ) ) ;
    public final void rule__Child2_3__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3941:1: ( ( ( rule__Child2_3__NameAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3942:1: ( ( rule__Child2_3__NameAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3942:1: ( ( rule__Child2_3__NameAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3943:1: ( rule__Child2_3__NameAssignment_0 )
            {
             before(grammarAccess.getChild2_3Access().getNameAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3944:1: ( rule__Child2_3__NameAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3944:2: rule__Child2_3__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_3__NameAssignment_0_in_rule__Child2_3__Group__0__Impl8062);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3954:1: rule__Child2_3__Group__1 : rule__Child2_3__Group__1__Impl rule__Child2_3__Group__2 ;
    public final void rule__Child2_3__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3958:1: ( rule__Child2_3__Group__1__Impl rule__Child2_3__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3959:2: rule__Child2_3__Group__1__Impl rule__Child2_3__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_3__Group__1__Impl_in_rule__Child2_3__Group__18092);
            rule__Child2_3__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child2_3__Group__2_in_rule__Child2_3__Group__18095);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3966:1: rule__Child2_3__Group__1__Impl : ( ':' ) ;
    public final void rule__Child2_3__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3970:1: ( ( ':' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3971:1: ( ':' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3971:1: ( ':' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3972:1: ':'
            {
             before(grammarAccess.getChild2_3Access().getColonKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Child2_3__Group__1__Impl8123); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3985:1: rule__Child2_3__Group__2 : rule__Child2_3__Group__2__Impl rule__Child2_3__Group__3 ;
    public final void rule__Child2_3__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3989:1: ( rule__Child2_3__Group__2__Impl rule__Child2_3__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3990:2: rule__Child2_3__Group__2__Impl rule__Child2_3__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_3__Group__2__Impl_in_rule__Child2_3__Group__28154);
            rule__Child2_3__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child2_3__Group__3_in_rule__Child2_3__Group__28157);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:3997:1: rule__Child2_3__Group__2__Impl : ( ( rule__Child2_3__Group_2__0 )? ) ;
    public final void rule__Child2_3__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4001:1: ( ( ( rule__Child2_3__Group_2__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4002:1: ( ( rule__Child2_3__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4002:1: ( ( rule__Child2_3__Group_2__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4003:1: ( rule__Child2_3__Group_2__0 )?
            {
             before(grammarAccess.getChild2_3Access().getGroup_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4004:1: ( rule__Child2_3__Group_2__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==32) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4004:2: rule__Child2_3__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Child2_3__Group_2__0_in_rule__Child2_3__Group__2__Impl8184);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4014:1: rule__Child2_3__Group__3 : rule__Child2_3__Group__3__Impl rule__Child2_3__Group__4 ;
    public final void rule__Child2_3__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4018:1: ( rule__Child2_3__Group__3__Impl rule__Child2_3__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4019:2: rule__Child2_3__Group__3__Impl rule__Child2_3__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_3__Group__3__Impl_in_rule__Child2_3__Group__38215);
            rule__Child2_3__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child2_3__Group__4_in_rule__Child2_3__Group__38218);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4026:1: rule__Child2_3__Group__3__Impl : ( ( rule__Child2_3__StringAssignment_3 ) ) ;
    public final void rule__Child2_3__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4030:1: ( ( ( rule__Child2_3__StringAssignment_3 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4031:1: ( ( rule__Child2_3__StringAssignment_3 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4031:1: ( ( rule__Child2_3__StringAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4032:1: ( rule__Child2_3__StringAssignment_3 )
            {
             before(grammarAccess.getChild2_3Access().getStringAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4033:1: ( rule__Child2_3__StringAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4033:2: rule__Child2_3__StringAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_3__StringAssignment_3_in_rule__Child2_3__Group__3__Impl8245);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4043:1: rule__Child2_3__Group__4 : rule__Child2_3__Group__4__Impl rule__Child2_3__Group__5 ;
    public final void rule__Child2_3__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4047:1: ( rule__Child2_3__Group__4__Impl rule__Child2_3__Group__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4048:2: rule__Child2_3__Group__4__Impl rule__Child2_3__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_3__Group__4__Impl_in_rule__Child2_3__Group__48275);
            rule__Child2_3__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child2_3__Group__5_in_rule__Child2_3__Group__48278);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4055:1: rule__Child2_3__Group__4__Impl : ( 'child3' ) ;
    public final void rule__Child2_3__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4059:1: ( ( 'child3' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4060:1: ( 'child3' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4060:1: ( 'child3' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4061:1: 'child3'
            {
             before(grammarAccess.getChild2_3Access().getChild3Keyword_4()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__Child2_3__Group__4__Impl8306); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4074:1: rule__Child2_3__Group__5 : rule__Child2_3__Group__5__Impl ;
    public final void rule__Child2_3__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4078:1: ( rule__Child2_3__Group__5__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4079:2: rule__Child2_3__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_3__Group__5__Impl_in_rule__Child2_3__Group__58337);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4085:1: rule__Child2_3__Group__5__Impl : ( 'end' ) ;
    public final void rule__Child2_3__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4089:1: ( ( 'end' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4090:1: ( 'end' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4090:1: ( 'end' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4091:1: 'end'
            {
             before(grammarAccess.getChild2_3Access().getEndKeyword_5()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Child2_3__Group__5__Impl8365); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4116:1: rule__Child2_3__Group_2__0 : rule__Child2_3__Group_2__0__Impl rule__Child2_3__Group_2__1 ;
    public final void rule__Child2_3__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4120:1: ( rule__Child2_3__Group_2__0__Impl rule__Child2_3__Group_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4121:2: rule__Child2_3__Group_2__0__Impl rule__Child2_3__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_3__Group_2__0__Impl_in_rule__Child2_3__Group_2__08408);
            rule__Child2_3__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child2_3__Group_2__1_in_rule__Child2_3__Group_2__08411);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4128:1: rule__Child2_3__Group_2__0__Impl : ( ( rule__Child2_3__BoolAssignment_2_0 ) ) ;
    public final void rule__Child2_3__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4132:1: ( ( ( rule__Child2_3__BoolAssignment_2_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4133:1: ( ( rule__Child2_3__BoolAssignment_2_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4133:1: ( ( rule__Child2_3__BoolAssignment_2_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4134:1: ( rule__Child2_3__BoolAssignment_2_0 )
            {
             before(grammarAccess.getChild2_3Access().getBoolAssignment_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4135:1: ( rule__Child2_3__BoolAssignment_2_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4135:2: rule__Child2_3__BoolAssignment_2_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_3__BoolAssignment_2_0_in_rule__Child2_3__Group_2__0__Impl8438);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4145:1: rule__Child2_3__Group_2__1 : rule__Child2_3__Group_2__1__Impl ;
    public final void rule__Child2_3__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4149:1: ( rule__Child2_3__Group_2__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4150:2: rule__Child2_3__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_3__Group_2__1__Impl_in_rule__Child2_3__Group_2__18468);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4156:1: rule__Child2_3__Group_2__1__Impl : ( 'keyword' ) ;
    public final void rule__Child2_3__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4160:1: ( ( 'keyword' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4161:1: ( 'keyword' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4161:1: ( 'keyword' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4162:1: 'keyword'
            {
             before(grammarAccess.getChild2_3Access().getKeywordKeyword_2_1()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__Child2_3__Group_2__1__Impl8496); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4179:1: rule__Child2_4__Group__0 : rule__Child2_4__Group__0__Impl rule__Child2_4__Group__1 ;
    public final void rule__Child2_4__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4183:1: ( rule__Child2_4__Group__0__Impl rule__Child2_4__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4184:2: rule__Child2_4__Group__0__Impl rule__Child2_4__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_4__Group__0__Impl_in_rule__Child2_4__Group__08531);
            rule__Child2_4__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child2_4__Group__1_in_rule__Child2_4__Group__08534);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4191:1: rule__Child2_4__Group__0__Impl : ( ( rule__Child2_4__NameAssignment_0 ) ) ;
    public final void rule__Child2_4__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4195:1: ( ( ( rule__Child2_4__NameAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4196:1: ( ( rule__Child2_4__NameAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4196:1: ( ( rule__Child2_4__NameAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4197:1: ( rule__Child2_4__NameAssignment_0 )
            {
             before(grammarAccess.getChild2_4Access().getNameAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4198:1: ( rule__Child2_4__NameAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4198:2: rule__Child2_4__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_4__NameAssignment_0_in_rule__Child2_4__Group__0__Impl8561);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4208:1: rule__Child2_4__Group__1 : rule__Child2_4__Group__1__Impl rule__Child2_4__Group__2 ;
    public final void rule__Child2_4__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4212:1: ( rule__Child2_4__Group__1__Impl rule__Child2_4__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4213:2: rule__Child2_4__Group__1__Impl rule__Child2_4__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_4__Group__1__Impl_in_rule__Child2_4__Group__18591);
            rule__Child2_4__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child2_4__Group__2_in_rule__Child2_4__Group__18594);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4220:1: rule__Child2_4__Group__1__Impl : ( ':' ) ;
    public final void rule__Child2_4__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4224:1: ( ( ':' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4225:1: ( ':' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4225:1: ( ':' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4226:1: ':'
            {
             before(grammarAccess.getChild2_4Access().getColonKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Child2_4__Group__1__Impl8622); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4239:1: rule__Child2_4__Group__2 : rule__Child2_4__Group__2__Impl rule__Child2_4__Group__3 ;
    public final void rule__Child2_4__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4243:1: ( rule__Child2_4__Group__2__Impl rule__Child2_4__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4244:2: rule__Child2_4__Group__2__Impl rule__Child2_4__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_4__Group__2__Impl_in_rule__Child2_4__Group__28653);
            rule__Child2_4__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child2_4__Group__3_in_rule__Child2_4__Group__28656);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4251:1: rule__Child2_4__Group__2__Impl : ( ( rule__Child2_4__Group_2__0 )? ) ;
    public final void rule__Child2_4__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4255:1: ( ( ( rule__Child2_4__Group_2__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4256:1: ( ( rule__Child2_4__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4256:1: ( ( rule__Child2_4__Group_2__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4257:1: ( rule__Child2_4__Group_2__0 )?
            {
             before(grammarAccess.getChild2_4Access().getGroup_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4258:1: ( rule__Child2_4__Group_2__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==32) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4258:2: rule__Child2_4__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Child2_4__Group_2__0_in_rule__Child2_4__Group__2__Impl8683);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4268:1: rule__Child2_4__Group__3 : rule__Child2_4__Group__3__Impl rule__Child2_4__Group__4 ;
    public final void rule__Child2_4__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4272:1: ( rule__Child2_4__Group__3__Impl rule__Child2_4__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4273:2: rule__Child2_4__Group__3__Impl rule__Child2_4__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_4__Group__3__Impl_in_rule__Child2_4__Group__38714);
            rule__Child2_4__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child2_4__Group__4_in_rule__Child2_4__Group__38717);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4280:1: rule__Child2_4__Group__3__Impl : ( ( rule__Child2_4__Alternatives_3 ) ) ;
    public final void rule__Child2_4__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4284:1: ( ( ( rule__Child2_4__Alternatives_3 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4285:1: ( ( rule__Child2_4__Alternatives_3 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4285:1: ( ( rule__Child2_4__Alternatives_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4286:1: ( rule__Child2_4__Alternatives_3 )
            {
             before(grammarAccess.getChild2_4Access().getAlternatives_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4287:1: ( rule__Child2_4__Alternatives_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4287:2: rule__Child2_4__Alternatives_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_4__Alternatives_3_in_rule__Child2_4__Group__3__Impl8744);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4297:1: rule__Child2_4__Group__4 : rule__Child2_4__Group__4__Impl rule__Child2_4__Group__5 ;
    public final void rule__Child2_4__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4301:1: ( rule__Child2_4__Group__4__Impl rule__Child2_4__Group__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4302:2: rule__Child2_4__Group__4__Impl rule__Child2_4__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_4__Group__4__Impl_in_rule__Child2_4__Group__48774);
            rule__Child2_4__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child2_4__Group__5_in_rule__Child2_4__Group__48777);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4309:1: rule__Child2_4__Group__4__Impl : ( 'child1' ) ;
    public final void rule__Child2_4__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4313:1: ( ( 'child1' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4314:1: ( 'child1' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4314:1: ( 'child1' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4315:1: 'child1'
            {
             before(grammarAccess.getChild2_4Access().getChild1Keyword_4()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Child2_4__Group__4__Impl8805); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4328:1: rule__Child2_4__Group__5 : rule__Child2_4__Group__5__Impl ;
    public final void rule__Child2_4__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4332:1: ( rule__Child2_4__Group__5__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4333:2: rule__Child2_4__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_4__Group__5__Impl_in_rule__Child2_4__Group__58836);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4339:1: rule__Child2_4__Group__5__Impl : ( 'end' ) ;
    public final void rule__Child2_4__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4343:1: ( ( 'end' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4344:1: ( 'end' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4344:1: ( 'end' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4345:1: 'end'
            {
             before(grammarAccess.getChild2_4Access().getEndKeyword_5()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Child2_4__Group__5__Impl8864); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4370:1: rule__Child2_4__Group_2__0 : rule__Child2_4__Group_2__0__Impl rule__Child2_4__Group_2__1 ;
    public final void rule__Child2_4__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4374:1: ( rule__Child2_4__Group_2__0__Impl rule__Child2_4__Group_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4375:2: rule__Child2_4__Group_2__0__Impl rule__Child2_4__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_4__Group_2__0__Impl_in_rule__Child2_4__Group_2__08907);
            rule__Child2_4__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child2_4__Group_2__1_in_rule__Child2_4__Group_2__08910);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4382:1: rule__Child2_4__Group_2__0__Impl : ( ( rule__Child2_4__BoolAssignment_2_0 ) ) ;
    public final void rule__Child2_4__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4386:1: ( ( ( rule__Child2_4__BoolAssignment_2_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4387:1: ( ( rule__Child2_4__BoolAssignment_2_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4387:1: ( ( rule__Child2_4__BoolAssignment_2_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4388:1: ( rule__Child2_4__BoolAssignment_2_0 )
            {
             before(grammarAccess.getChild2_4Access().getBoolAssignment_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4389:1: ( rule__Child2_4__BoolAssignment_2_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4389:2: rule__Child2_4__BoolAssignment_2_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_4__BoolAssignment_2_0_in_rule__Child2_4__Group_2__0__Impl8937);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4399:1: rule__Child2_4__Group_2__1 : rule__Child2_4__Group_2__1__Impl ;
    public final void rule__Child2_4__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4403:1: ( rule__Child2_4__Group_2__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4404:2: rule__Child2_4__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_4__Group_2__1__Impl_in_rule__Child2_4__Group_2__18967);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4410:1: rule__Child2_4__Group_2__1__Impl : ( 'keyword' ) ;
    public final void rule__Child2_4__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4414:1: ( ( 'keyword' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4415:1: ( 'keyword' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4415:1: ( 'keyword' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4416:1: 'keyword'
            {
             before(grammarAccess.getChild2_4Access().getKeywordKeyword_2_1()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__Child2_4__Group_2__1__Impl8995); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4433:1: rule__Child2_5__Group__0 : rule__Child2_5__Group__0__Impl rule__Child2_5__Group__1 ;
    public final void rule__Child2_5__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4437:1: ( rule__Child2_5__Group__0__Impl rule__Child2_5__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4438:2: rule__Child2_5__Group__0__Impl rule__Child2_5__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_5__Group__0__Impl_in_rule__Child2_5__Group__09030);
            rule__Child2_5__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child2_5__Group__1_in_rule__Child2_5__Group__09033);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4445:1: rule__Child2_5__Group__0__Impl : ( ( rule__Child2_5__NameAssignment_0 ) ) ;
    public final void rule__Child2_5__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4449:1: ( ( ( rule__Child2_5__NameAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4450:1: ( ( rule__Child2_5__NameAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4450:1: ( ( rule__Child2_5__NameAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4451:1: ( rule__Child2_5__NameAssignment_0 )
            {
             before(grammarAccess.getChild2_5Access().getNameAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4452:1: ( rule__Child2_5__NameAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4452:2: rule__Child2_5__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_5__NameAssignment_0_in_rule__Child2_5__Group__0__Impl9060);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4462:1: rule__Child2_5__Group__1 : rule__Child2_5__Group__1__Impl rule__Child2_5__Group__2 ;
    public final void rule__Child2_5__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4466:1: ( rule__Child2_5__Group__1__Impl rule__Child2_5__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4467:2: rule__Child2_5__Group__1__Impl rule__Child2_5__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_5__Group__1__Impl_in_rule__Child2_5__Group__19090);
            rule__Child2_5__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child2_5__Group__2_in_rule__Child2_5__Group__19093);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4474:1: rule__Child2_5__Group__1__Impl : ( ':' ) ;
    public final void rule__Child2_5__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4478:1: ( ( ':' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4479:1: ( ':' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4479:1: ( ':' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4480:1: ':'
            {
             before(grammarAccess.getChild2_5Access().getColonKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Child2_5__Group__1__Impl9121); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4493:1: rule__Child2_5__Group__2 : rule__Child2_5__Group__2__Impl rule__Child2_5__Group__3 ;
    public final void rule__Child2_5__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4497:1: ( rule__Child2_5__Group__2__Impl rule__Child2_5__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4498:2: rule__Child2_5__Group__2__Impl rule__Child2_5__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_5__Group__2__Impl_in_rule__Child2_5__Group__29152);
            rule__Child2_5__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child2_5__Group__3_in_rule__Child2_5__Group__29155);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4505:1: rule__Child2_5__Group__2__Impl : ( ( rule__Child2_5__Group_2__0 )? ) ;
    public final void rule__Child2_5__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4509:1: ( ( ( rule__Child2_5__Group_2__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4510:1: ( ( rule__Child2_5__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4510:1: ( ( rule__Child2_5__Group_2__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4511:1: ( rule__Child2_5__Group_2__0 )?
            {
             before(grammarAccess.getChild2_5Access().getGroup_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4512:1: ( rule__Child2_5__Group_2__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==32) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4512:2: rule__Child2_5__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Child2_5__Group_2__0_in_rule__Child2_5__Group__2__Impl9182);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4522:1: rule__Child2_5__Group__3 : rule__Child2_5__Group__3__Impl rule__Child2_5__Group__4 ;
    public final void rule__Child2_5__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4526:1: ( rule__Child2_5__Group__3__Impl rule__Child2_5__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4527:2: rule__Child2_5__Group__3__Impl rule__Child2_5__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_5__Group__3__Impl_in_rule__Child2_5__Group__39213);
            rule__Child2_5__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child2_5__Group__4_in_rule__Child2_5__Group__39216);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4534:1: rule__Child2_5__Group__3__Impl : ( ( rule__Child2_5__Alternatives_3 ) ) ;
    public final void rule__Child2_5__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4538:1: ( ( ( rule__Child2_5__Alternatives_3 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4539:1: ( ( rule__Child2_5__Alternatives_3 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4539:1: ( ( rule__Child2_5__Alternatives_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4540:1: ( rule__Child2_5__Alternatives_3 )
            {
             before(grammarAccess.getChild2_5Access().getAlternatives_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4541:1: ( rule__Child2_5__Alternatives_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4541:2: rule__Child2_5__Alternatives_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_5__Alternatives_3_in_rule__Child2_5__Group__3__Impl9243);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4551:1: rule__Child2_5__Group__4 : rule__Child2_5__Group__4__Impl rule__Child2_5__Group__5 ;
    public final void rule__Child2_5__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4555:1: ( rule__Child2_5__Group__4__Impl rule__Child2_5__Group__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4556:2: rule__Child2_5__Group__4__Impl rule__Child2_5__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_5__Group__4__Impl_in_rule__Child2_5__Group__49273);
            rule__Child2_5__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child2_5__Group__5_in_rule__Child2_5__Group__49276);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4563:1: rule__Child2_5__Group__4__Impl : ( 'child2' ) ;
    public final void rule__Child2_5__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4567:1: ( ( 'child2' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4568:1: ( 'child2' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4568:1: ( 'child2' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4569:1: 'child2'
            {
             before(grammarAccess.getChild2_5Access().getChild2Keyword_4()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__Child2_5__Group__4__Impl9304); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4582:1: rule__Child2_5__Group__5 : rule__Child2_5__Group__5__Impl ;
    public final void rule__Child2_5__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4586:1: ( rule__Child2_5__Group__5__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4587:2: rule__Child2_5__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_5__Group__5__Impl_in_rule__Child2_5__Group__59335);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4593:1: rule__Child2_5__Group__5__Impl : ( 'end' ) ;
    public final void rule__Child2_5__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4597:1: ( ( 'end' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4598:1: ( 'end' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4598:1: ( 'end' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4599:1: 'end'
            {
             before(grammarAccess.getChild2_5Access().getEndKeyword_5()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Child2_5__Group__5__Impl9363); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4624:1: rule__Child2_5__Group_2__0 : rule__Child2_5__Group_2__0__Impl rule__Child2_5__Group_2__1 ;
    public final void rule__Child2_5__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4628:1: ( rule__Child2_5__Group_2__0__Impl rule__Child2_5__Group_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4629:2: rule__Child2_5__Group_2__0__Impl rule__Child2_5__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_5__Group_2__0__Impl_in_rule__Child2_5__Group_2__09406);
            rule__Child2_5__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child2_5__Group_2__1_in_rule__Child2_5__Group_2__09409);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4636:1: rule__Child2_5__Group_2__0__Impl : ( ( rule__Child2_5__BoolAssignment_2_0 ) ) ;
    public final void rule__Child2_5__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4640:1: ( ( ( rule__Child2_5__BoolAssignment_2_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4641:1: ( ( rule__Child2_5__BoolAssignment_2_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4641:1: ( ( rule__Child2_5__BoolAssignment_2_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4642:1: ( rule__Child2_5__BoolAssignment_2_0 )
            {
             before(grammarAccess.getChild2_5Access().getBoolAssignment_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4643:1: ( rule__Child2_5__BoolAssignment_2_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4643:2: rule__Child2_5__BoolAssignment_2_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_5__BoolAssignment_2_0_in_rule__Child2_5__Group_2__0__Impl9436);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4653:1: rule__Child2_5__Group_2__1 : rule__Child2_5__Group_2__1__Impl ;
    public final void rule__Child2_5__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4657:1: ( rule__Child2_5__Group_2__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4658:2: rule__Child2_5__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_5__Group_2__1__Impl_in_rule__Child2_5__Group_2__19466);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4664:1: rule__Child2_5__Group_2__1__Impl : ( 'keyword' ) ;
    public final void rule__Child2_5__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4668:1: ( ( 'keyword' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4669:1: ( 'keyword' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4669:1: ( 'keyword' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4670:1: 'keyword'
            {
             before(grammarAccess.getChild2_5Access().getKeywordKeyword_2_1()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__Child2_5__Group_2__1__Impl9494); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4687:1: rule__Child2_6__Group__0 : rule__Child2_6__Group__0__Impl rule__Child2_6__Group__1 ;
    public final void rule__Child2_6__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4691:1: ( rule__Child2_6__Group__0__Impl rule__Child2_6__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4692:2: rule__Child2_6__Group__0__Impl rule__Child2_6__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_6__Group__0__Impl_in_rule__Child2_6__Group__09529);
            rule__Child2_6__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child2_6__Group__1_in_rule__Child2_6__Group__09532);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4699:1: rule__Child2_6__Group__0__Impl : ( ( rule__Child2_6__NameAssignment_0 ) ) ;
    public final void rule__Child2_6__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4703:1: ( ( ( rule__Child2_6__NameAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4704:1: ( ( rule__Child2_6__NameAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4704:1: ( ( rule__Child2_6__NameAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4705:1: ( rule__Child2_6__NameAssignment_0 )
            {
             before(grammarAccess.getChild2_6Access().getNameAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4706:1: ( rule__Child2_6__NameAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4706:2: rule__Child2_6__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_6__NameAssignment_0_in_rule__Child2_6__Group__0__Impl9559);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4716:1: rule__Child2_6__Group__1 : rule__Child2_6__Group__1__Impl rule__Child2_6__Group__2 ;
    public final void rule__Child2_6__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4720:1: ( rule__Child2_6__Group__1__Impl rule__Child2_6__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4721:2: rule__Child2_6__Group__1__Impl rule__Child2_6__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_6__Group__1__Impl_in_rule__Child2_6__Group__19589);
            rule__Child2_6__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child2_6__Group__2_in_rule__Child2_6__Group__19592);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4728:1: rule__Child2_6__Group__1__Impl : ( ':' ) ;
    public final void rule__Child2_6__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4732:1: ( ( ':' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4733:1: ( ':' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4733:1: ( ':' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4734:1: ':'
            {
             before(grammarAccess.getChild2_6Access().getColonKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Child2_6__Group__1__Impl9620); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4747:1: rule__Child2_6__Group__2 : rule__Child2_6__Group__2__Impl rule__Child2_6__Group__3 ;
    public final void rule__Child2_6__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4751:1: ( rule__Child2_6__Group__2__Impl rule__Child2_6__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4752:2: rule__Child2_6__Group__2__Impl rule__Child2_6__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_6__Group__2__Impl_in_rule__Child2_6__Group__29651);
            rule__Child2_6__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child2_6__Group__3_in_rule__Child2_6__Group__29654);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4759:1: rule__Child2_6__Group__2__Impl : ( ( rule__Child2_6__Group_2__0 )? ) ;
    public final void rule__Child2_6__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4763:1: ( ( ( rule__Child2_6__Group_2__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4764:1: ( ( rule__Child2_6__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4764:1: ( ( rule__Child2_6__Group_2__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4765:1: ( rule__Child2_6__Group_2__0 )?
            {
             before(grammarAccess.getChild2_6Access().getGroup_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4766:1: ( rule__Child2_6__Group_2__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==32) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4766:2: rule__Child2_6__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Child2_6__Group_2__0_in_rule__Child2_6__Group__2__Impl9681);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4776:1: rule__Child2_6__Group__3 : rule__Child2_6__Group__3__Impl rule__Child2_6__Group__4 ;
    public final void rule__Child2_6__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4780:1: ( rule__Child2_6__Group__3__Impl rule__Child2_6__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4781:2: rule__Child2_6__Group__3__Impl rule__Child2_6__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_6__Group__3__Impl_in_rule__Child2_6__Group__39712);
            rule__Child2_6__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child2_6__Group__4_in_rule__Child2_6__Group__39715);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4788:1: rule__Child2_6__Group__3__Impl : ( ( rule__Child2_6__Alternatives_3 ) ) ;
    public final void rule__Child2_6__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4792:1: ( ( ( rule__Child2_6__Alternatives_3 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4793:1: ( ( rule__Child2_6__Alternatives_3 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4793:1: ( ( rule__Child2_6__Alternatives_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4794:1: ( rule__Child2_6__Alternatives_3 )
            {
             before(grammarAccess.getChild2_6Access().getAlternatives_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4795:1: ( rule__Child2_6__Alternatives_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4795:2: rule__Child2_6__Alternatives_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_6__Alternatives_3_in_rule__Child2_6__Group__3__Impl9742);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4805:1: rule__Child2_6__Group__4 : rule__Child2_6__Group__4__Impl rule__Child2_6__Group__5 ;
    public final void rule__Child2_6__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4809:1: ( rule__Child2_6__Group__4__Impl rule__Child2_6__Group__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4810:2: rule__Child2_6__Group__4__Impl rule__Child2_6__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_6__Group__4__Impl_in_rule__Child2_6__Group__49772);
            rule__Child2_6__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child2_6__Group__5_in_rule__Child2_6__Group__49775);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4817:1: rule__Child2_6__Group__4__Impl : ( 'child3' ) ;
    public final void rule__Child2_6__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4821:1: ( ( 'child3' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4822:1: ( 'child3' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4822:1: ( 'child3' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4823:1: 'child3'
            {
             before(grammarAccess.getChild2_6Access().getChild3Keyword_4()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__Child2_6__Group__4__Impl9803); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4836:1: rule__Child2_6__Group__5 : rule__Child2_6__Group__5__Impl ;
    public final void rule__Child2_6__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4840:1: ( rule__Child2_6__Group__5__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4841:2: rule__Child2_6__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_6__Group__5__Impl_in_rule__Child2_6__Group__59834);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4847:1: rule__Child2_6__Group__5__Impl : ( 'end' ) ;
    public final void rule__Child2_6__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4851:1: ( ( 'end' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4852:1: ( 'end' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4852:1: ( 'end' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4853:1: 'end'
            {
             before(grammarAccess.getChild2_6Access().getEndKeyword_5()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Child2_6__Group__5__Impl9862); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4878:1: rule__Child2_6__Group_2__0 : rule__Child2_6__Group_2__0__Impl rule__Child2_6__Group_2__1 ;
    public final void rule__Child2_6__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4882:1: ( rule__Child2_6__Group_2__0__Impl rule__Child2_6__Group_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4883:2: rule__Child2_6__Group_2__0__Impl rule__Child2_6__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_6__Group_2__0__Impl_in_rule__Child2_6__Group_2__09905);
            rule__Child2_6__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Child2_6__Group_2__1_in_rule__Child2_6__Group_2__09908);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4890:1: rule__Child2_6__Group_2__0__Impl : ( ( rule__Child2_6__BoolAssignment_2_0 ) ) ;
    public final void rule__Child2_6__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4894:1: ( ( ( rule__Child2_6__BoolAssignment_2_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4895:1: ( ( rule__Child2_6__BoolAssignment_2_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4895:1: ( ( rule__Child2_6__BoolAssignment_2_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4896:1: ( rule__Child2_6__BoolAssignment_2_0 )
            {
             before(grammarAccess.getChild2_6Access().getBoolAssignment_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4897:1: ( rule__Child2_6__BoolAssignment_2_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4897:2: rule__Child2_6__BoolAssignment_2_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_6__BoolAssignment_2_0_in_rule__Child2_6__Group_2__0__Impl9935);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4907:1: rule__Child2_6__Group_2__1 : rule__Child2_6__Group_2__1__Impl ;
    public final void rule__Child2_6__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4911:1: ( rule__Child2_6__Group_2__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4912:2: rule__Child2_6__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_6__Group_2__1__Impl_in_rule__Child2_6__Group_2__19965);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4918:1: rule__Child2_6__Group_2__1__Impl : ( 'keyword' ) ;
    public final void rule__Child2_6__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4922:1: ( ( 'keyword' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4923:1: ( 'keyword' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4923:1: ( 'keyword' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4924:1: 'keyword'
            {
             before(grammarAccess.getChild2_6Access().getKeywordKeyword_2_1()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__Child2_6__Group_2__1__Impl9993); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4942:1: rule__Model__Element1Assignment_0 : ( ruleScenario1_1 ) ;
    public final void rule__Model__Element1Assignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4946:1: ( ( ruleScenario1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4947:1: ( ruleScenario1_1 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4947:1: ( ruleScenario1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4948:1: ruleScenario1_1
            {
             before(grammarAccess.getModelAccess().getElement1Scenario1_1ParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleScenario1_1_in_rule__Model__Element1Assignment_010033);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4957:1: rule__Model__Element1Assignment_1 : ( ruleScenario1_2 ) ;
    public final void rule__Model__Element1Assignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4961:1: ( ( ruleScenario1_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4962:1: ( ruleScenario1_2 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4962:1: ( ruleScenario1_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4963:1: ruleScenario1_2
            {
             before(grammarAccess.getModelAccess().getElement1Scenario1_2ParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleScenario1_2_in_rule__Model__Element1Assignment_110064);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4972:1: rule__Model__Element1Assignment_2 : ( ruleScenario1_3 ) ;
    public final void rule__Model__Element1Assignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4976:1: ( ( ruleScenario1_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4977:1: ( ruleScenario1_3 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4977:1: ( ruleScenario1_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4978:1: ruleScenario1_3
            {
             before(grammarAccess.getModelAccess().getElement1Scenario1_3ParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleScenario1_3_in_rule__Model__Element1Assignment_210095);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4987:1: rule__Model__Element1Assignment_3 : ( ruleScenario1_4 ) ;
    public final void rule__Model__Element1Assignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4991:1: ( ( ruleScenario1_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4992:1: ( ruleScenario1_4 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4992:1: ( ruleScenario1_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:4993:1: ruleScenario1_4
            {
             before(grammarAccess.getModelAccess().getElement1Scenario1_4ParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleScenario1_4_in_rule__Model__Element1Assignment_310126);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5002:1: rule__Model__Element2Assignment_4 : ( ruleScenario2_1 ) ;
    public final void rule__Model__Element2Assignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5006:1: ( ( ruleScenario2_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5007:1: ( ruleScenario2_1 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5007:1: ( ruleScenario2_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5008:1: ruleScenario2_1
            {
             before(grammarAccess.getModelAccess().getElement2Scenario2_1ParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleScenario2_1_in_rule__Model__Element2Assignment_410157);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5017:1: rule__Model__Element2Assignment_5 : ( ruleScenario2_2 ) ;
    public final void rule__Model__Element2Assignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5021:1: ( ( ruleScenario2_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5022:1: ( ruleScenario2_2 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5022:1: ( ruleScenario2_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5023:1: ruleScenario2_2
            {
             before(grammarAccess.getModelAccess().getElement2Scenario2_2ParserRuleCall_5_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleScenario2_2_in_rule__Model__Element2Assignment_510188);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5032:1: rule__Model__Element2Assignment_6 : ( ruleScenario2_3 ) ;
    public final void rule__Model__Element2Assignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5036:1: ( ( ruleScenario2_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5037:1: ( ruleScenario2_3 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5037:1: ( ruleScenario2_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5038:1: ruleScenario2_3
            {
             before(grammarAccess.getModelAccess().getElement2Scenario2_3ParserRuleCall_6_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleScenario2_3_in_rule__Model__Element2Assignment_610219);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5047:1: rule__Model__Element2Assignment_7 : ( ruleScenario2_4 ) ;
    public final void rule__Model__Element2Assignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5051:1: ( ( ruleScenario2_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5052:1: ( ruleScenario2_4 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5052:1: ( ruleScenario2_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5053:1: ruleScenario2_4
            {
             before(grammarAccess.getModelAccess().getElement2Scenario2_4ParserRuleCall_7_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleScenario2_4_in_rule__Model__Element2Assignment_710250);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5062:1: rule__Model__Element2Assignment_8 : ( ruleScenario2_5 ) ;
    public final void rule__Model__Element2Assignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5066:1: ( ( ruleScenario2_5 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5067:1: ( ruleScenario2_5 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5067:1: ( ruleScenario2_5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5068:1: ruleScenario2_5
            {
             before(grammarAccess.getModelAccess().getElement2Scenario2_5ParserRuleCall_8_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleScenario2_5_in_rule__Model__Element2Assignment_810281);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5077:1: rule__Model__Element2Assignment_9 : ( ruleScenario2_6 ) ;
    public final void rule__Model__Element2Assignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5081:1: ( ( ruleScenario2_6 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5082:1: ( ruleScenario2_6 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5082:1: ( ruleScenario2_6 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5083:1: ruleScenario2_6
            {
             before(grammarAccess.getModelAccess().getElement2Scenario2_6ParserRuleCall_9_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleScenario2_6_in_rule__Model__Element2Assignment_910312);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5092:1: rule__Model__Element2Assignment_10 : ( ruleScenario2_7 ) ;
    public final void rule__Model__Element2Assignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5096:1: ( ( ruleScenario2_7 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5097:1: ( ruleScenario2_7 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5097:1: ( ruleScenario2_7 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5098:1: ruleScenario2_7
            {
             before(grammarAccess.getModelAccess().getElement2Scenario2_7ParserRuleCall_10_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleScenario2_7_in_rule__Model__Element2Assignment_1010343);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5107:1: rule__Model__Element2Assignment_11 : ( ruleScenario2_8 ) ;
    public final void rule__Model__Element2Assignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5111:1: ( ( ruleScenario2_8 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5112:1: ( ruleScenario2_8 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5112:1: ( ruleScenario2_8 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5113:1: ruleScenario2_8
            {
             before(grammarAccess.getModelAccess().getElement2Scenario2_8ParserRuleCall_11_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleScenario2_8_in_rule__Model__Element2Assignment_1110374);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5122:1: rule__Scenario1_1__ChildAssignment_1_0 : ( ruleChild1_1 ) ;
    public final void rule__Scenario1_1__ChildAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5126:1: ( ( ruleChild1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5127:1: ( ruleChild1_1 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5127:1: ( ruleChild1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5128:1: ruleChild1_1
            {
             before(grammarAccess.getScenario1_1Access().getChildChild1_1ParserRuleCall_1_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild1_1_in_rule__Scenario1_1__ChildAssignment_1_010405);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5137:1: rule__Scenario1_1__ChildAssignment_1_1 : ( ruleChild1_2 ) ;
    public final void rule__Scenario1_1__ChildAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5141:1: ( ( ruleChild1_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5142:1: ( ruleChild1_2 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5142:1: ( ruleChild1_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5143:1: ruleChild1_2
            {
             before(grammarAccess.getScenario1_1Access().getChildChild1_2ParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild1_2_in_rule__Scenario1_1__ChildAssignment_1_110436);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5152:1: rule__Scenario1_1__ChildAssignment_1_2 : ( ruleChild1_3 ) ;
    public final void rule__Scenario1_1__ChildAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5156:1: ( ( ruleChild1_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5157:1: ( ruleChild1_3 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5157:1: ( ruleChild1_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5158:1: ruleChild1_3
            {
             before(grammarAccess.getScenario1_1Access().getChildChild1_3ParserRuleCall_1_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild1_3_in_rule__Scenario1_1__ChildAssignment_1_210467);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5167:1: rule__Scenario1_2__ChildAssignment_1_0 : ( ruleChild1_1 ) ;
    public final void rule__Scenario1_2__ChildAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5171:1: ( ( ruleChild1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5172:1: ( ruleChild1_1 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5172:1: ( ruleChild1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5173:1: ruleChild1_1
            {
             before(grammarAccess.getScenario1_2Access().getChildChild1_1ParserRuleCall_1_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild1_1_in_rule__Scenario1_2__ChildAssignment_1_010498);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5182:1: rule__Scenario1_2__ChildAssignment_1_1 : ( ruleChild1_2 ) ;
    public final void rule__Scenario1_2__ChildAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5186:1: ( ( ruleChild1_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5187:1: ( ruleChild1_2 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5187:1: ( ruleChild1_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5188:1: ruleChild1_2
            {
             before(grammarAccess.getScenario1_2Access().getChildChild1_2ParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild1_2_in_rule__Scenario1_2__ChildAssignment_1_110529);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5197:1: rule__Scenario1_2__ChildAssignment_1_2 : ( ruleChild1_3 ) ;
    public final void rule__Scenario1_2__ChildAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5201:1: ( ( ruleChild1_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5202:1: ( ruleChild1_3 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5202:1: ( ruleChild1_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5203:1: ruleChild1_3
            {
             before(grammarAccess.getScenario1_2Access().getChildChild1_3ParserRuleCall_1_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild1_3_in_rule__Scenario1_2__ChildAssignment_1_210560);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5212:1: rule__Scenario1_3__ChildAssignment_2_0 : ( ruleChild1_1 ) ;
    public final void rule__Scenario1_3__ChildAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5216:1: ( ( ruleChild1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5217:1: ( ruleChild1_1 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5217:1: ( ruleChild1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5218:1: ruleChild1_1
            {
             before(grammarAccess.getScenario1_3Access().getChildChild1_1ParserRuleCall_2_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild1_1_in_rule__Scenario1_3__ChildAssignment_2_010591);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5227:1: rule__Scenario1_3__ChildAssignment_2_1 : ( ruleChild1_2 ) ;
    public final void rule__Scenario1_3__ChildAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5231:1: ( ( ruleChild1_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5232:1: ( ruleChild1_2 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5232:1: ( ruleChild1_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5233:1: ruleChild1_2
            {
             before(grammarAccess.getScenario1_3Access().getChildChild1_2ParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild1_2_in_rule__Scenario1_3__ChildAssignment_2_110622);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5242:1: rule__Scenario1_3__ChildAssignment_2_2 : ( ruleChild1_3 ) ;
    public final void rule__Scenario1_3__ChildAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5246:1: ( ( ruleChild1_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5247:1: ( ruleChild1_3 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5247:1: ( ruleChild1_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5248:1: ruleChild1_3
            {
             before(grammarAccess.getScenario1_3Access().getChildChild1_3ParserRuleCall_2_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild1_3_in_rule__Scenario1_3__ChildAssignment_2_210653);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5257:1: rule__Scenario1_4__ChildAssignment_2_0 : ( ruleChild1_1 ) ;
    public final void rule__Scenario1_4__ChildAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5261:1: ( ( ruleChild1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5262:1: ( ruleChild1_1 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5262:1: ( ruleChild1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5263:1: ruleChild1_1
            {
             before(grammarAccess.getScenario1_4Access().getChildChild1_1ParserRuleCall_2_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild1_1_in_rule__Scenario1_4__ChildAssignment_2_010684);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5272:1: rule__Scenario1_4__ChildAssignment_2_1 : ( ruleChild1_2 ) ;
    public final void rule__Scenario1_4__ChildAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5276:1: ( ( ruleChild1_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5277:1: ( ruleChild1_2 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5277:1: ( ruleChild1_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5278:1: ruleChild1_2
            {
             before(grammarAccess.getScenario1_4Access().getChildChild1_2ParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild1_2_in_rule__Scenario1_4__ChildAssignment_2_110715);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5287:1: rule__Scenario1_4__ChildAssignment_2_2 : ( ruleChild1_3 ) ;
    public final void rule__Scenario1_4__ChildAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5291:1: ( ( ruleChild1_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5292:1: ( ruleChild1_3 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5292:1: ( ruleChild1_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5293:1: ruleChild1_3
            {
             before(grammarAccess.getScenario1_4Access().getChildChild1_3ParserRuleCall_2_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild1_3_in_rule__Scenario1_4__ChildAssignment_2_210746);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5302:1: rule__Child1_1__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Child1_1__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5306:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5307:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5307:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5308:1: RULE_ID
            {
             before(grammarAccess.getChild1_1Access().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Child1_1__NameAssignment_010777); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5317:1: rule__Child1_1__BoolAssignment_2_0 : ( ( 'bool' ) ) ;
    public final void rule__Child1_1__BoolAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5321:1: ( ( ( 'bool' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5322:1: ( ( 'bool' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5322:1: ( ( 'bool' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5323:1: ( 'bool' )
            {
             before(grammarAccess.getChild1_1Access().getBoolBoolKeyword_2_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5324:1: ( 'bool' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5325:1: 'bool'
            {
             before(grammarAccess.getChild1_1Access().getBoolBoolKeyword_2_0_0()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__Child1_1__BoolAssignment_2_010813); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5340:1: rule__Child1_1__EnumTypeAssignment_3 : ( ruleEnumType ) ;
    public final void rule__Child1_1__EnumTypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5344:1: ( ( ruleEnumType ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5345:1: ( ruleEnumType )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5345:1: ( ruleEnumType )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5346:1: ruleEnumType
            {
             before(grammarAccess.getChild1_1Access().getEnumTypeEnumTypeEnumRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumType_in_rule__Child1_1__EnumTypeAssignment_310852);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5355:1: rule__Child1_2__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Child1_2__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5359:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5360:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5360:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5361:1: RULE_ID
            {
             before(grammarAccess.getChild1_2Access().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Child1_2__NameAssignment_010883); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5370:1: rule__Child1_2__BoolAssignment_2_0 : ( ( 'bool' ) ) ;
    public final void rule__Child1_2__BoolAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5374:1: ( ( ( 'bool' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5375:1: ( ( 'bool' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5375:1: ( ( 'bool' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5376:1: ( 'bool' )
            {
             before(grammarAccess.getChild1_2Access().getBoolBoolKeyword_2_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5377:1: ( 'bool' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5378:1: 'bool'
            {
             before(grammarAccess.getChild1_2Access().getBoolBoolKeyword_2_0_0()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__Child1_2__BoolAssignment_2_010919); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5393:1: rule__Child1_2__EnumTypeAssignment_3 : ( ruleEnumType ) ;
    public final void rule__Child1_2__EnumTypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5397:1: ( ( ruleEnumType ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5398:1: ( ruleEnumType )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5398:1: ( ruleEnumType )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5399:1: ruleEnumType
            {
             before(grammarAccess.getChild1_2Access().getEnumTypeEnumTypeEnumRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumType_in_rule__Child1_2__EnumTypeAssignment_310958);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5408:1: rule__Child1_3__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Child1_3__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5412:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5413:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5413:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5414:1: RULE_ID
            {
             before(grammarAccess.getChild1_3Access().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Child1_3__NameAssignment_010989); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5423:1: rule__Child1_3__BoolAssignment_2_0 : ( ( 'bool' ) ) ;
    public final void rule__Child1_3__BoolAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5427:1: ( ( ( 'bool' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5428:1: ( ( 'bool' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5428:1: ( ( 'bool' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5429:1: ( 'bool' )
            {
             before(grammarAccess.getChild1_3Access().getBoolBoolKeyword_2_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5430:1: ( 'bool' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5431:1: 'bool'
            {
             before(grammarAccess.getChild1_3Access().getBoolBoolKeyword_2_0_0()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__Child1_3__BoolAssignment_2_011025); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5446:1: rule__Child1_3__EnumTypeAssignment_3 : ( ruleEnumType ) ;
    public final void rule__Child1_3__EnumTypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5450:1: ( ( ruleEnumType ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5451:1: ( ruleEnumType )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5451:1: ( ruleEnumType )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5452:1: ruleEnumType
            {
             before(grammarAccess.getChild1_3Access().getEnumTypeEnumTypeEnumRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumType_in_rule__Child1_3__EnumTypeAssignment_311064);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5461:1: rule__Scenario2_1__ChildAssignment_1_0 : ( ruleChild2_1 ) ;
    public final void rule__Scenario2_1__ChildAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5465:1: ( ( ruleChild2_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5466:1: ( ruleChild2_1 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5466:1: ( ruleChild2_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5467:1: ruleChild2_1
            {
             before(grammarAccess.getScenario2_1Access().getChildChild2_1ParserRuleCall_1_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_1_in_rule__Scenario2_1__ChildAssignment_1_011095);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5476:1: rule__Scenario2_1__ChildAssignment_1_1 : ( ruleChild2_2 ) ;
    public final void rule__Scenario2_1__ChildAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5480:1: ( ( ruleChild2_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5481:1: ( ruleChild2_2 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5481:1: ( ruleChild2_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5482:1: ruleChild2_2
            {
             before(grammarAccess.getScenario2_1Access().getChildChild2_2ParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_2_in_rule__Scenario2_1__ChildAssignment_1_111126);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5491:1: rule__Scenario2_1__ChildAssignment_1_2 : ( ruleChild2_3 ) ;
    public final void rule__Scenario2_1__ChildAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5495:1: ( ( ruleChild2_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5496:1: ( ruleChild2_3 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5496:1: ( ruleChild2_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5497:1: ruleChild2_3
            {
             before(grammarAccess.getScenario2_1Access().getChildChild2_3ParserRuleCall_1_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_3_in_rule__Scenario2_1__ChildAssignment_1_211157);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5506:1: rule__Scenario2_2__ChildAssignment_1_0 : ( ruleChild2_1 ) ;
    public final void rule__Scenario2_2__ChildAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5510:1: ( ( ruleChild2_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5511:1: ( ruleChild2_1 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5511:1: ( ruleChild2_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5512:1: ruleChild2_1
            {
             before(grammarAccess.getScenario2_2Access().getChildChild2_1ParserRuleCall_1_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_1_in_rule__Scenario2_2__ChildAssignment_1_011188);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5521:1: rule__Scenario2_2__ChildAssignment_1_1 : ( ruleChild2_2 ) ;
    public final void rule__Scenario2_2__ChildAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5525:1: ( ( ruleChild2_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5526:1: ( ruleChild2_2 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5526:1: ( ruleChild2_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5527:1: ruleChild2_2
            {
             before(grammarAccess.getScenario2_2Access().getChildChild2_2ParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_2_in_rule__Scenario2_2__ChildAssignment_1_111219);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5536:1: rule__Scenario2_2__ChildAssignment_1_2 : ( ruleChild2_3 ) ;
    public final void rule__Scenario2_2__ChildAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5540:1: ( ( ruleChild2_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5541:1: ( ruleChild2_3 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5541:1: ( ruleChild2_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5542:1: ruleChild2_3
            {
             before(grammarAccess.getScenario2_2Access().getChildChild2_3ParserRuleCall_1_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_3_in_rule__Scenario2_2__ChildAssignment_1_211250);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5551:1: rule__Scenario2_3__ChildAssignment_1_0 : ( ruleChild2_4 ) ;
    public final void rule__Scenario2_3__ChildAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5555:1: ( ( ruleChild2_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5556:1: ( ruleChild2_4 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5556:1: ( ruleChild2_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5557:1: ruleChild2_4
            {
             before(grammarAccess.getScenario2_3Access().getChildChild2_4ParserRuleCall_1_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_4_in_rule__Scenario2_3__ChildAssignment_1_011281);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5566:1: rule__Scenario2_3__ChildAssignment_1_1 : ( ruleChild2_5 ) ;
    public final void rule__Scenario2_3__ChildAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5570:1: ( ( ruleChild2_5 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5571:1: ( ruleChild2_5 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5571:1: ( ruleChild2_5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5572:1: ruleChild2_5
            {
             before(grammarAccess.getScenario2_3Access().getChildChild2_5ParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_5_in_rule__Scenario2_3__ChildAssignment_1_111312);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5581:1: rule__Scenario2_3__ChildAssignment_1_2 : ( ruleChild2_6 ) ;
    public final void rule__Scenario2_3__ChildAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5585:1: ( ( ruleChild2_6 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5586:1: ( ruleChild2_6 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5586:1: ( ruleChild2_6 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5587:1: ruleChild2_6
            {
             before(grammarAccess.getScenario2_3Access().getChildChild2_6ParserRuleCall_1_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_6_in_rule__Scenario2_3__ChildAssignment_1_211343);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5596:1: rule__Scenario2_4__ChildAssignment_1_0 : ( ruleChild2_4 ) ;
    public final void rule__Scenario2_4__ChildAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5600:1: ( ( ruleChild2_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5601:1: ( ruleChild2_4 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5601:1: ( ruleChild2_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5602:1: ruleChild2_4
            {
             before(grammarAccess.getScenario2_4Access().getChildChild2_4ParserRuleCall_1_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_4_in_rule__Scenario2_4__ChildAssignment_1_011374);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5611:1: rule__Scenario2_4__ChildAssignment_1_1 : ( ruleChild2_5 ) ;
    public final void rule__Scenario2_4__ChildAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5615:1: ( ( ruleChild2_5 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5616:1: ( ruleChild2_5 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5616:1: ( ruleChild2_5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5617:1: ruleChild2_5
            {
             before(grammarAccess.getScenario2_4Access().getChildChild2_5ParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_5_in_rule__Scenario2_4__ChildAssignment_1_111405);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5626:1: rule__Scenario2_4__ChildAssignment_1_2 : ( ruleChild2_6 ) ;
    public final void rule__Scenario2_4__ChildAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5630:1: ( ( ruleChild2_6 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5631:1: ( ruleChild2_6 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5631:1: ( ruleChild2_6 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5632:1: ruleChild2_6
            {
             before(grammarAccess.getScenario2_4Access().getChildChild2_6ParserRuleCall_1_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_6_in_rule__Scenario2_4__ChildAssignment_1_211436);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5641:1: rule__Scenario2_5__ChildAssignment_2_0 : ( ruleChild2_1 ) ;
    public final void rule__Scenario2_5__ChildAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5645:1: ( ( ruleChild2_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5646:1: ( ruleChild2_1 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5646:1: ( ruleChild2_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5647:1: ruleChild2_1
            {
             before(grammarAccess.getScenario2_5Access().getChildChild2_1ParserRuleCall_2_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_1_in_rule__Scenario2_5__ChildAssignment_2_011467);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5656:1: rule__Scenario2_5__ChildAssignment_2_1 : ( ruleChild2_2 ) ;
    public final void rule__Scenario2_5__ChildAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5660:1: ( ( ruleChild2_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5661:1: ( ruleChild2_2 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5661:1: ( ruleChild2_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5662:1: ruleChild2_2
            {
             before(grammarAccess.getScenario2_5Access().getChildChild2_2ParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_2_in_rule__Scenario2_5__ChildAssignment_2_111498);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5671:1: rule__Scenario2_5__ChildAssignment_2_2 : ( ruleChild2_3 ) ;
    public final void rule__Scenario2_5__ChildAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5675:1: ( ( ruleChild2_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5676:1: ( ruleChild2_3 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5676:1: ( ruleChild2_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5677:1: ruleChild2_3
            {
             before(grammarAccess.getScenario2_5Access().getChildChild2_3ParserRuleCall_2_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_3_in_rule__Scenario2_5__ChildAssignment_2_211529);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5686:1: rule__Scenario2_6__ChildAssignment_2_0 : ( ruleChild2_1 ) ;
    public final void rule__Scenario2_6__ChildAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5690:1: ( ( ruleChild2_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5691:1: ( ruleChild2_1 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5691:1: ( ruleChild2_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5692:1: ruleChild2_1
            {
             before(grammarAccess.getScenario2_6Access().getChildChild2_1ParserRuleCall_2_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_1_in_rule__Scenario2_6__ChildAssignment_2_011560);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5701:1: rule__Scenario2_6__ChildAssignment_2_1 : ( ruleChild2_2 ) ;
    public final void rule__Scenario2_6__ChildAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5705:1: ( ( ruleChild2_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5706:1: ( ruleChild2_2 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5706:1: ( ruleChild2_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5707:1: ruleChild2_2
            {
             before(grammarAccess.getScenario2_6Access().getChildChild2_2ParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_2_in_rule__Scenario2_6__ChildAssignment_2_111591);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5716:1: rule__Scenario2_6__ChildAssignment_2_2 : ( ruleChild2_3 ) ;
    public final void rule__Scenario2_6__ChildAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5720:1: ( ( ruleChild2_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5721:1: ( ruleChild2_3 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5721:1: ( ruleChild2_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5722:1: ruleChild2_3
            {
             before(grammarAccess.getScenario2_6Access().getChildChild2_3ParserRuleCall_2_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_3_in_rule__Scenario2_6__ChildAssignment_2_211622);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5731:1: rule__Scenario2_7__ChildAssignment_2_0 : ( ruleChild2_4 ) ;
    public final void rule__Scenario2_7__ChildAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5735:1: ( ( ruleChild2_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5736:1: ( ruleChild2_4 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5736:1: ( ruleChild2_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5737:1: ruleChild2_4
            {
             before(grammarAccess.getScenario2_7Access().getChildChild2_4ParserRuleCall_2_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_4_in_rule__Scenario2_7__ChildAssignment_2_011653);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5746:1: rule__Scenario2_7__ChildAssignment_2_1 : ( ruleChild2_5 ) ;
    public final void rule__Scenario2_7__ChildAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5750:1: ( ( ruleChild2_5 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5751:1: ( ruleChild2_5 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5751:1: ( ruleChild2_5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5752:1: ruleChild2_5
            {
             before(grammarAccess.getScenario2_7Access().getChildChild2_5ParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_5_in_rule__Scenario2_7__ChildAssignment_2_111684);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5761:1: rule__Scenario2_7__ChildAssignment_2_2 : ( ruleChild2_6 ) ;
    public final void rule__Scenario2_7__ChildAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5765:1: ( ( ruleChild2_6 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5766:1: ( ruleChild2_6 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5766:1: ( ruleChild2_6 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5767:1: ruleChild2_6
            {
             before(grammarAccess.getScenario2_7Access().getChildChild2_6ParserRuleCall_2_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_6_in_rule__Scenario2_7__ChildAssignment_2_211715);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5776:1: rule__Scenario2_8__ChildAssignment_2_0 : ( ruleChild2_4 ) ;
    public final void rule__Scenario2_8__ChildAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5780:1: ( ( ruleChild2_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5781:1: ( ruleChild2_4 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5781:1: ( ruleChild2_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5782:1: ruleChild2_4
            {
             before(grammarAccess.getScenario2_8Access().getChildChild2_4ParserRuleCall_2_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_4_in_rule__Scenario2_8__ChildAssignment_2_011746);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5791:1: rule__Scenario2_8__ChildAssignment_2_1 : ( ruleChild2_5 ) ;
    public final void rule__Scenario2_8__ChildAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5795:1: ( ( ruleChild2_5 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5796:1: ( ruleChild2_5 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5796:1: ( ruleChild2_5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5797:1: ruleChild2_5
            {
             before(grammarAccess.getScenario2_8Access().getChildChild2_5ParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_5_in_rule__Scenario2_8__ChildAssignment_2_111777);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5806:1: rule__Scenario2_8__ChildAssignment_2_2 : ( ruleChild2_6 ) ;
    public final void rule__Scenario2_8__ChildAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5810:1: ( ( ruleChild2_6 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5811:1: ( ruleChild2_6 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5811:1: ( ruleChild2_6 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5812:1: ruleChild2_6
            {
             before(grammarAccess.getScenario2_8Access().getChildChild2_6ParserRuleCall_2_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_6_in_rule__Scenario2_8__ChildAssignment_2_211808);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5821:1: rule__Child2_1__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Child2_1__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5825:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5826:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5826:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5827:1: RULE_ID
            {
             before(grammarAccess.getChild2_1Access().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Child2_1__NameAssignment_011839); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5836:1: rule__Child2_1__BoolAssignment_2_0 : ( ( 'bool' ) ) ;
    public final void rule__Child2_1__BoolAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5840:1: ( ( ( 'bool' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5841:1: ( ( 'bool' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5841:1: ( ( 'bool' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5842:1: ( 'bool' )
            {
             before(grammarAccess.getChild2_1Access().getBoolBoolKeyword_2_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5843:1: ( 'bool' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5844:1: 'bool'
            {
             before(grammarAccess.getChild2_1Access().getBoolBoolKeyword_2_0_0()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__Child2_1__BoolAssignment_2_011875); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5859:1: rule__Child2_1__StringAssignment_3 : ( ( rule__Child2_1__StringAlternatives_3_0 ) ) ;
    public final void rule__Child2_1__StringAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5863:1: ( ( ( rule__Child2_1__StringAlternatives_3_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5864:1: ( ( rule__Child2_1__StringAlternatives_3_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5864:1: ( ( rule__Child2_1__StringAlternatives_3_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5865:1: ( rule__Child2_1__StringAlternatives_3_0 )
            {
             before(grammarAccess.getChild2_1Access().getStringAlternatives_3_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5866:1: ( rule__Child2_1__StringAlternatives_3_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5866:2: rule__Child2_1__StringAlternatives_3_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_1__StringAlternatives_3_0_in_rule__Child2_1__StringAssignment_311914);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5875:1: rule__Child2_2__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Child2_2__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5879:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5880:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5880:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5881:1: RULE_ID
            {
             before(grammarAccess.getChild2_2Access().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Child2_2__NameAssignment_011947); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5890:1: rule__Child2_2__BoolAssignment_2_0 : ( ( 'bool' ) ) ;
    public final void rule__Child2_2__BoolAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5894:1: ( ( ( 'bool' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5895:1: ( ( 'bool' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5895:1: ( ( 'bool' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5896:1: ( 'bool' )
            {
             before(grammarAccess.getChild2_2Access().getBoolBoolKeyword_2_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5897:1: ( 'bool' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5898:1: 'bool'
            {
             before(grammarAccess.getChild2_2Access().getBoolBoolKeyword_2_0_0()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__Child2_2__BoolAssignment_2_011983); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5913:1: rule__Child2_2__StringAssignment_3 : ( ( rule__Child2_2__StringAlternatives_3_0 ) ) ;
    public final void rule__Child2_2__StringAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5917:1: ( ( ( rule__Child2_2__StringAlternatives_3_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5918:1: ( ( rule__Child2_2__StringAlternatives_3_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5918:1: ( ( rule__Child2_2__StringAlternatives_3_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5919:1: ( rule__Child2_2__StringAlternatives_3_0 )
            {
             before(grammarAccess.getChild2_2Access().getStringAlternatives_3_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5920:1: ( rule__Child2_2__StringAlternatives_3_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5920:2: rule__Child2_2__StringAlternatives_3_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_2__StringAlternatives_3_0_in_rule__Child2_2__StringAssignment_312022);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5929:1: rule__Child2_3__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Child2_3__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5933:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5934:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5934:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5935:1: RULE_ID
            {
             before(grammarAccess.getChild2_3Access().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Child2_3__NameAssignment_012055); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5944:1: rule__Child2_3__BoolAssignment_2_0 : ( ( 'bool' ) ) ;
    public final void rule__Child2_3__BoolAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5948:1: ( ( ( 'bool' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5949:1: ( ( 'bool' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5949:1: ( ( 'bool' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5950:1: ( 'bool' )
            {
             before(grammarAccess.getChild2_3Access().getBoolBoolKeyword_2_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5951:1: ( 'bool' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5952:1: 'bool'
            {
             before(grammarAccess.getChild2_3Access().getBoolBoolKeyword_2_0_0()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__Child2_3__BoolAssignment_2_012091); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5967:1: rule__Child2_3__StringAssignment_3 : ( ( rule__Child2_3__StringAlternatives_3_0 ) ) ;
    public final void rule__Child2_3__StringAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5971:1: ( ( ( rule__Child2_3__StringAlternatives_3_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5972:1: ( ( rule__Child2_3__StringAlternatives_3_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5972:1: ( ( rule__Child2_3__StringAlternatives_3_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5973:1: ( rule__Child2_3__StringAlternatives_3_0 )
            {
             before(grammarAccess.getChild2_3Access().getStringAlternatives_3_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5974:1: ( rule__Child2_3__StringAlternatives_3_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5974:2: rule__Child2_3__StringAlternatives_3_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Child2_3__StringAlternatives_3_0_in_rule__Child2_3__StringAssignment_312130);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5983:1: rule__Child2_4__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Child2_4__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5987:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5988:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5988:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5989:1: RULE_ID
            {
             before(grammarAccess.getChild2_4Access().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Child2_4__NameAssignment_012163); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:5998:1: rule__Child2_4__BoolAssignment_2_0 : ( ( 'bool' ) ) ;
    public final void rule__Child2_4__BoolAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6002:1: ( ( ( 'bool' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6003:1: ( ( 'bool' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6003:1: ( ( 'bool' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6004:1: ( 'bool' )
            {
             before(grammarAccess.getChild2_4Access().getBoolBoolKeyword_2_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6005:1: ( 'bool' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6006:1: 'bool'
            {
             before(grammarAccess.getChild2_4Access().getBoolBoolKeyword_2_0_0()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__Child2_4__BoolAssignment_2_012199); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6021:1: rule__Child2_4__StringAssignment_3_0 : ( ( 'a' ) ) ;
    public final void rule__Child2_4__StringAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6025:1: ( ( ( 'a' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6026:1: ( ( 'a' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6026:1: ( ( 'a' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6027:1: ( 'a' )
            {
             before(grammarAccess.getChild2_4Access().getStringAKeyword_3_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6028:1: ( 'a' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6029:1: 'a'
            {
             before(grammarAccess.getChild2_4Access().getStringAKeyword_3_0_0()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Child2_4__StringAssignment_3_012243); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6044:1: rule__Child2_4__StringAssignment_3_1 : ( ( 'b' ) ) ;
    public final void rule__Child2_4__StringAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6048:1: ( ( ( 'b' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6049:1: ( ( 'b' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6049:1: ( ( 'b' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6050:1: ( 'b' )
            {
             before(grammarAccess.getChild2_4Access().getStringBKeyword_3_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6051:1: ( 'b' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6052:1: 'b'
            {
             before(grammarAccess.getChild2_4Access().getStringBKeyword_3_1_0()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Child2_4__StringAssignment_3_112287); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6067:1: rule__Child2_5__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Child2_5__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6071:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6072:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6072:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6073:1: RULE_ID
            {
             before(grammarAccess.getChild2_5Access().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Child2_5__NameAssignment_012326); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6082:1: rule__Child2_5__BoolAssignment_2_0 : ( ( 'bool' ) ) ;
    public final void rule__Child2_5__BoolAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6086:1: ( ( ( 'bool' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6087:1: ( ( 'bool' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6087:1: ( ( 'bool' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6088:1: ( 'bool' )
            {
             before(grammarAccess.getChild2_5Access().getBoolBoolKeyword_2_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6089:1: ( 'bool' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6090:1: 'bool'
            {
             before(grammarAccess.getChild2_5Access().getBoolBoolKeyword_2_0_0()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__Child2_5__BoolAssignment_2_012362); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6105:1: rule__Child2_5__StringAssignment_3_0 : ( ( 'a' ) ) ;
    public final void rule__Child2_5__StringAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6109:1: ( ( ( 'a' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6110:1: ( ( 'a' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6110:1: ( ( 'a' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6111:1: ( 'a' )
            {
             before(grammarAccess.getChild2_5Access().getStringAKeyword_3_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6112:1: ( 'a' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6113:1: 'a'
            {
             before(grammarAccess.getChild2_5Access().getStringAKeyword_3_0_0()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Child2_5__StringAssignment_3_012406); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6128:1: rule__Child2_5__StringAssignment_3_1 : ( ( 'b' ) ) ;
    public final void rule__Child2_5__StringAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6132:1: ( ( ( 'b' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6133:1: ( ( 'b' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6133:1: ( ( 'b' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6134:1: ( 'b' )
            {
             before(grammarAccess.getChild2_5Access().getStringBKeyword_3_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6135:1: ( 'b' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6136:1: 'b'
            {
             before(grammarAccess.getChild2_5Access().getStringBKeyword_3_1_0()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Child2_5__StringAssignment_3_112450); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6151:1: rule__Child2_6__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Child2_6__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6155:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6156:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6156:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6157:1: RULE_ID
            {
             before(grammarAccess.getChild2_6Access().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Child2_6__NameAssignment_012489); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6166:1: rule__Child2_6__BoolAssignment_2_0 : ( ( 'bool' ) ) ;
    public final void rule__Child2_6__BoolAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6170:1: ( ( ( 'bool' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6171:1: ( ( 'bool' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6171:1: ( ( 'bool' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6172:1: ( 'bool' )
            {
             before(grammarAccess.getChild2_6Access().getBoolBoolKeyword_2_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6173:1: ( 'bool' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6174:1: 'bool'
            {
             before(grammarAccess.getChild2_6Access().getBoolBoolKeyword_2_0_0()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__Child2_6__BoolAssignment_2_012525); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6189:1: rule__Child2_6__StringAssignment_3_0 : ( ( 'a' ) ) ;
    public final void rule__Child2_6__StringAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6193:1: ( ( ( 'a' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6194:1: ( ( 'a' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6194:1: ( ( 'a' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6195:1: ( 'a' )
            {
             before(grammarAccess.getChild2_6Access().getStringAKeyword_3_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6196:1: ( 'a' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6197:1: 'a'
            {
             before(grammarAccess.getChild2_6Access().getStringAKeyword_3_0_0()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Child2_6__StringAssignment_3_012569); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6212:1: rule__Child2_6__StringAssignment_3_1 : ( ( 'b' ) ) ;
    public final void rule__Child2_6__StringAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6216:1: ( ( ( 'b' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6217:1: ( ( 'b' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6217:1: ( ( 'b' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6218:1: ( 'b' )
            {
             before(grammarAccess.getChild2_6Access().getStringBKeyword_3_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6219:1: ( 'b' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug348427TestLanguage.g:6220:1: 'b'
            {
             before(grammarAccess.getChild2_6Access().getStringBKeyword_3_1_0()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Child2_6__StringAssignment_3_112613); 
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
        "\7\uffff\1\2\1\3\1\1";
    static final String DFA2_specialS =
        "\12\uffff}>";
    static final String[] DFA2_transitionS = {
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
            return "778:1: rule__Scenario1_1__Alternatives_1 : ( ( ( rule__Scenario1_1__ChildAssignment_1_0 ) ) | ( ( rule__Scenario1_1__ChildAssignment_1_1 ) ) | ( ( rule__Scenario1_1__ChildAssignment_1_2 ) ) );";
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
        "\7\uffff\1\2\1\1\1\3";
    static final String DFA3_specialS =
        "\12\uffff}>";
    static final String[] DFA3_transitionS = {
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
            return "806:1: rule__Scenario1_2__Alternatives_1 : ( ( ( rule__Scenario1_2__ChildAssignment_1_0 ) ) | ( ( rule__Scenario1_2__ChildAssignment_1_1 ) ) | ( ( rule__Scenario1_2__ChildAssignment_1_2 ) ) );";
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
        "\7\uffff\1\3\1\2\1\1";
    static final String DFA4_specialS =
        "\12\uffff}>";
    static final String[] DFA4_transitionS = {
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
            return "834:1: rule__Scenario1_3__Alternatives_2 : ( ( ( rule__Scenario1_3__ChildAssignment_2_0 ) ) | ( ( rule__Scenario1_3__ChildAssignment_2_1 ) ) | ( ( rule__Scenario1_3__ChildAssignment_2_2 ) ) );";
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
        "\7\uffff\1\1\1\2\1\3";
    static final String DFA5_specialS =
        "\12\uffff}>";
    static final String[] DFA5_transitionS = {
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
            return "862:1: rule__Scenario1_4__Alternatives_2 : ( ( ( rule__Scenario1_4__ChildAssignment_2_0 ) ) | ( ( rule__Scenario1_4__ChildAssignment_2_1 ) ) | ( ( rule__Scenario1_4__ChildAssignment_2_2 ) ) );";
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
        "\7\uffff\1\1\1\3\1\2";
    static final String DFA6_specialS =
        "\12\uffff}>";
    static final String[] DFA6_transitionS = {
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
            return "890:1: rule__Scenario2_1__Alternatives_1 : ( ( ( rule__Scenario2_1__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_1__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_1__ChildAssignment_1_2 ) ) );";
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
        "\7\uffff\1\2\1\1\1\3";
    static final String DFA7_specialS =
        "\12\uffff}>";
    static final String[] DFA7_transitionS = {
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
            return "918:1: rule__Scenario2_2__Alternatives_1 : ( ( ( rule__Scenario2_2__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_2__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_2__ChildAssignment_1_2 ) ) );";
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
        "\7\uffff\1\2\1\1\1\3";
    static final String DFA8_specialS =
        "\12\uffff}>";
    static final String[] DFA8_transitionS = {
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
            return "946:1: rule__Scenario2_3__Alternatives_1 : ( ( ( rule__Scenario2_3__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_3__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_3__ChildAssignment_1_2 ) ) );";
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
        "\7\uffff\1\3\1\2\1\1";
    static final String DFA9_specialS =
        "\12\uffff}>";
    static final String[] DFA9_transitionS = {
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
            return "974:1: rule__Scenario2_4__Alternatives_1 : ( ( ( rule__Scenario2_4__ChildAssignment_1_0 ) ) | ( ( rule__Scenario2_4__ChildAssignment_1_1 ) ) | ( ( rule__Scenario2_4__ChildAssignment_1_2 ) ) );";
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
        "\7\uffff\1\1\1\2\1\3";
    static final String DFA10_specialS =
        "\12\uffff}>";
    static final String[] DFA10_transitionS = {
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
            return "1002:1: rule__Scenario2_5__Alternatives_2 : ( ( ( rule__Scenario2_5__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_5__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_5__ChildAssignment_2_2 ) ) );";
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
        "\7\uffff\1\3\1\2\1\1";
    static final String DFA11_specialS =
        "\12\uffff}>";
    static final String[] DFA11_transitionS = {
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
            return "1030:1: rule__Scenario2_6__Alternatives_2 : ( ( ( rule__Scenario2_6__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_6__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_6__ChildAssignment_2_2 ) ) );";
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
        "\7\uffff\1\2\1\1\1\3";
    static final String DFA12_specialS =
        "\12\uffff}>";
    static final String[] DFA12_transitionS = {
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
            return "1058:1: rule__Scenario2_7__Alternatives_2 : ( ( ( rule__Scenario2_7__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_7__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_7__ChildAssignment_2_2 ) ) );";
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
            return "1086:1: rule__Scenario2_8__Alternatives_2 : ( ( ( rule__Scenario2_8__ChildAssignment_2_0 ) ) | ( ( rule__Scenario2_8__ChildAssignment_2_1 ) ) | ( ( rule__Scenario2_8__ChildAssignment_2_2 ) ) );";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Alternatives_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario1_1_in_entryRuleScenario1_1121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario1_1128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario1_1__Group__0_in_ruleScenario1_1154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario1_2_in_entryRuleScenario1_2181 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario1_2188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario1_2__Group__0_in_ruleScenario1_2214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario1_3_in_entryRuleScenario1_3241 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario1_3248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario1_3__Group__0_in_ruleScenario1_3274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario1_4_in_entryRuleScenario1_4301 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario1_4308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario1_4__Group__0_in_ruleScenario1_4334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild1_1_in_entryRuleChild1_1361 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChild1_1368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_1__Group__0_in_ruleChild1_1394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild1_2_in_entryRuleChild1_2421 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChild1_2428 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_2__Group__0_in_ruleChild1_2454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild1_3_in_entryRuleChild1_3481 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChild1_3488 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_3__Group__0_in_ruleChild1_3514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_1_in_entryRuleScenario2_1541 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario2_1548 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_1__Group__0_in_ruleScenario2_1574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_2_in_entryRuleScenario2_2601 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario2_2608 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_2__Group__0_in_ruleScenario2_2634 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_3_in_entryRuleScenario2_3661 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario2_3668 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_3__Group__0_in_ruleScenario2_3694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_4_in_entryRuleScenario2_4721 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario2_4728 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_4__Group__0_in_ruleScenario2_4754 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_5_in_entryRuleScenario2_5781 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario2_5788 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_5__Group__0_in_ruleScenario2_5814 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_6_in_entryRuleScenario2_6841 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario2_6848 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_6__Group__0_in_ruleScenario2_6874 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_7_in_entryRuleScenario2_7901 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario2_7908 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_7__Group__0_in_ruleScenario2_7934 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_8_in_entryRuleScenario2_8961 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario2_8968 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_8__Group__0_in_ruleScenario2_8994 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_1_in_entryRuleChild2_11021 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChild2_11028 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_1__Group__0_in_ruleChild2_11054 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_2_in_entryRuleChild2_21081 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChild2_21088 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_2__Group__0_in_ruleChild2_21114 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_3_in_entryRuleChild2_31141 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChild2_31148 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_3__Group__0_in_ruleChild2_31174 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_4_in_entryRuleChild2_41201 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChild2_41208 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_4__Group__0_in_ruleChild2_41234 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_5_in_entryRuleChild2_51261 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChild2_51268 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_5__Group__0_in_ruleChild2_51294 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_6_in_entryRuleChild2_61321 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChild2_61328 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_6__Group__0_in_ruleChild2_61354 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumType__Alternatives_in_ruleEnumType1391 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Element1Assignment_0_in_rule__Model__Alternatives1426 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Element1Assignment_1_in_rule__Model__Alternatives1444 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Element1Assignment_2_in_rule__Model__Alternatives1462 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Element1Assignment_3_in_rule__Model__Alternatives1480 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Element2Assignment_4_in_rule__Model__Alternatives1498 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Element2Assignment_5_in_rule__Model__Alternatives1516 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Element2Assignment_6_in_rule__Model__Alternatives1534 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Element2Assignment_7_in_rule__Model__Alternatives1552 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Element2Assignment_8_in_rule__Model__Alternatives1570 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Element2Assignment_9_in_rule__Model__Alternatives1588 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Element2Assignment_10_in_rule__Model__Alternatives1606 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Element2Assignment_11_in_rule__Model__Alternatives1624 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario1_1__ChildAssignment_1_0_in_rule__Scenario1_1__Alternatives_11657 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario1_1__ChildAssignment_1_1_in_rule__Scenario1_1__Alternatives_11675 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario1_1__ChildAssignment_1_2_in_rule__Scenario1_1__Alternatives_11693 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario1_2__ChildAssignment_1_0_in_rule__Scenario1_2__Alternatives_11726 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario1_2__ChildAssignment_1_1_in_rule__Scenario1_2__Alternatives_11744 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario1_2__ChildAssignment_1_2_in_rule__Scenario1_2__Alternatives_11762 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario1_3__ChildAssignment_2_0_in_rule__Scenario1_3__Alternatives_21795 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario1_3__ChildAssignment_2_1_in_rule__Scenario1_3__Alternatives_21813 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario1_3__ChildAssignment_2_2_in_rule__Scenario1_3__Alternatives_21831 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario1_4__ChildAssignment_2_0_in_rule__Scenario1_4__Alternatives_21864 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario1_4__ChildAssignment_2_1_in_rule__Scenario1_4__Alternatives_21882 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario1_4__ChildAssignment_2_2_in_rule__Scenario1_4__Alternatives_21900 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_1__ChildAssignment_1_0_in_rule__Scenario2_1__Alternatives_11933 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_1__ChildAssignment_1_1_in_rule__Scenario2_1__Alternatives_11951 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_1__ChildAssignment_1_2_in_rule__Scenario2_1__Alternatives_11969 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_2__ChildAssignment_1_0_in_rule__Scenario2_2__Alternatives_12002 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_2__ChildAssignment_1_1_in_rule__Scenario2_2__Alternatives_12020 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_2__ChildAssignment_1_2_in_rule__Scenario2_2__Alternatives_12038 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_3__ChildAssignment_1_0_in_rule__Scenario2_3__Alternatives_12071 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_3__ChildAssignment_1_1_in_rule__Scenario2_3__Alternatives_12089 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_3__ChildAssignment_1_2_in_rule__Scenario2_3__Alternatives_12107 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_4__ChildAssignment_1_0_in_rule__Scenario2_4__Alternatives_12140 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_4__ChildAssignment_1_1_in_rule__Scenario2_4__Alternatives_12158 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_4__ChildAssignment_1_2_in_rule__Scenario2_4__Alternatives_12176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_5__ChildAssignment_2_0_in_rule__Scenario2_5__Alternatives_22209 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_5__ChildAssignment_2_1_in_rule__Scenario2_5__Alternatives_22227 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_5__ChildAssignment_2_2_in_rule__Scenario2_5__Alternatives_22245 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_6__ChildAssignment_2_0_in_rule__Scenario2_6__Alternatives_22278 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_6__ChildAssignment_2_1_in_rule__Scenario2_6__Alternatives_22296 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_6__ChildAssignment_2_2_in_rule__Scenario2_6__Alternatives_22314 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_7__ChildAssignment_2_0_in_rule__Scenario2_7__Alternatives_22347 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_7__ChildAssignment_2_1_in_rule__Scenario2_7__Alternatives_22365 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_7__ChildAssignment_2_2_in_rule__Scenario2_7__Alternatives_22383 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_8__ChildAssignment_2_0_in_rule__Scenario2_8__Alternatives_22416 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_8__ChildAssignment_2_1_in_rule__Scenario2_8__Alternatives_22434 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_8__ChildAssignment_2_2_in_rule__Scenario2_8__Alternatives_22452 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Child2_1__StringAlternatives_3_02486 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Child2_1__StringAlternatives_3_02506 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Child2_2__StringAlternatives_3_02541 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Child2_2__StringAlternatives_3_02561 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Child2_3__StringAlternatives_3_02596 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Child2_3__StringAlternatives_3_02616 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_4__StringAssignment_3_0_in_rule__Child2_4__Alternatives_32650 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_4__StringAssignment_3_1_in_rule__Child2_4__Alternatives_32668 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_5__StringAssignment_3_0_in_rule__Child2_5__Alternatives_32701 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_5__StringAssignment_3_1_in_rule__Child2_5__Alternatives_32719 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_6__StringAssignment_3_0_in_rule__Child2_6__Alternatives_32752 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_6__StringAssignment_3_1_in_rule__Child2_6__Alternatives_32770 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__EnumType__Alternatives2804 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__EnumType__Alternatives2825 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario1_1__Group__0__Impl_in_rule__Scenario1_1__Group__02858 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Scenario1_1__Group__1_in_rule__Scenario1_1__Group__02861 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Scenario1_1__Group__0__Impl2889 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario1_1__Group__1__Impl_in_rule__Scenario1_1__Group__12920 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__Scenario1_1__Group__2_in_rule__Scenario1_1__Group__12923 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario1_1__Alternatives_1_in_rule__Scenario1_1__Group__1__Impl2950 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario1_1__Group__2__Impl_in_rule__Scenario1_1__Group__22980 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Scenario1_1__Group__2__Impl3008 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario1_2__Group__0__Impl_in_rule__Scenario1_2__Group__03045 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Scenario1_2__Group__1_in_rule__Scenario1_2__Group__03048 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Scenario1_2__Group__0__Impl3076 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario1_2__Group__1__Impl_in_rule__Scenario1_2__Group__13107 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__Scenario1_2__Group__2_in_rule__Scenario1_2__Group__13110 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario1_2__Alternatives_1_in_rule__Scenario1_2__Group__1__Impl3139 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__Scenario1_2__Alternatives_1_in_rule__Scenario1_2__Group__1__Impl3151 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__Scenario1_2__Group__2__Impl_in_rule__Scenario1_2__Group__23184 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Scenario1_2__Group__2__Impl3212 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario1_3__Group__0__Impl_in_rule__Scenario1_3__Group__03249 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_rule__Scenario1_3__Group__1_in_rule__Scenario1_3__Group__03252 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario1_3__Group__1__Impl_in_rule__Scenario1_3__Group__13310 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_rule__Scenario1_3__Group__2_in_rule__Scenario1_3__Group__13313 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Scenario1_3__Group__1__Impl3341 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario1_3__Group__2__Impl_in_rule__Scenario1_3__Group__23372 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_rule__Scenario1_3__Group__3_in_rule__Scenario1_3__Group__23375 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario1_3__Alternatives_2_in_rule__Scenario1_3__Group__2__Impl3402 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__Scenario1_3__Group__3__Impl_in_rule__Scenario1_3__Group__33433 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Scenario1_3__Group__3__Impl3461 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario1_4__Group__0__Impl_in_rule__Scenario1_4__Group__03500 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_rule__Scenario1_4__Group__1_in_rule__Scenario1_4__Group__03503 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario1_4__Group__1__Impl_in_rule__Scenario1_4__Group__13561 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_rule__Scenario1_4__Group__2_in_rule__Scenario1_4__Group__13564 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Scenario1_4__Group__1__Impl3592 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario1_4__Group__2__Impl_in_rule__Scenario1_4__Group__23623 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_rule__Scenario1_4__Group__3_in_rule__Scenario1_4__Group__23626 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario1_4__Alternatives_2_in_rule__Scenario1_4__Group__2__Impl3653 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario1_4__Group__3__Impl_in_rule__Scenario1_4__Group__33684 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Scenario1_4__Group__3__Impl3712 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_1__Group__0__Impl_in_rule__Child1_1__Group__03751 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__Child1_1__Group__1_in_rule__Child1_1__Group__03754 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_1__NameAssignment_0_in_rule__Child1_1__Group__0__Impl3781 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_1__Group__1__Impl_in_rule__Child1_1__Group__13811 = new BitSet(new long[]{0x0000000100001800L});
        public static final BitSet FOLLOW_rule__Child1_1__Group__2_in_rule__Child1_1__Group__13814 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Child1_1__Group__1__Impl3842 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_1__Group__2__Impl_in_rule__Child1_1__Group__23873 = new BitSet(new long[]{0x0000000100001800L});
        public static final BitSet FOLLOW_rule__Child1_1__Group__3_in_rule__Child1_1__Group__23876 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_1__Group_2__0_in_rule__Child1_1__Group__2__Impl3903 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_1__Group__3__Impl_in_rule__Child1_1__Group__33934 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__Child1_1__Group__4_in_rule__Child1_1__Group__33937 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_1__EnumTypeAssignment_3_in_rule__Child1_1__Group__3__Impl3964 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_1__Group__4__Impl_in_rule__Child1_1__Group__43994 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__Child1_1__Group__5_in_rule__Child1_1__Group__43997 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Child1_1__Group__4__Impl4025 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_1__Group__5__Impl_in_rule__Child1_1__Group__54056 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Child1_1__Group__5__Impl4084 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_1__Group_2__0__Impl_in_rule__Child1_1__Group_2__04127 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__Child1_1__Group_2__1_in_rule__Child1_1__Group_2__04130 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_1__BoolAssignment_2_0_in_rule__Child1_1__Group_2__0__Impl4157 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_1__Group_2__1__Impl_in_rule__Child1_1__Group_2__14187 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__Child1_1__Group_2__1__Impl4215 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_2__Group__0__Impl_in_rule__Child1_2__Group__04250 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__Child1_2__Group__1_in_rule__Child1_2__Group__04253 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_2__NameAssignment_0_in_rule__Child1_2__Group__0__Impl4280 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_2__Group__1__Impl_in_rule__Child1_2__Group__14310 = new BitSet(new long[]{0x0000000100001800L});
        public static final BitSet FOLLOW_rule__Child1_2__Group__2_in_rule__Child1_2__Group__14313 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Child1_2__Group__1__Impl4341 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_2__Group__2__Impl_in_rule__Child1_2__Group__24372 = new BitSet(new long[]{0x0000000100001800L});
        public static final BitSet FOLLOW_rule__Child1_2__Group__3_in_rule__Child1_2__Group__24375 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_2__Group_2__0_in_rule__Child1_2__Group__2__Impl4402 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_2__Group__3__Impl_in_rule__Child1_2__Group__34433 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__Child1_2__Group__4_in_rule__Child1_2__Group__34436 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_2__EnumTypeAssignment_3_in_rule__Child1_2__Group__3__Impl4463 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_2__Group__4__Impl_in_rule__Child1_2__Group__44493 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__Child1_2__Group__5_in_rule__Child1_2__Group__44496 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__Child1_2__Group__4__Impl4524 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_2__Group__5__Impl_in_rule__Child1_2__Group__54555 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Child1_2__Group__5__Impl4583 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_2__Group_2__0__Impl_in_rule__Child1_2__Group_2__04626 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__Child1_2__Group_2__1_in_rule__Child1_2__Group_2__04629 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_2__BoolAssignment_2_0_in_rule__Child1_2__Group_2__0__Impl4656 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_2__Group_2__1__Impl_in_rule__Child1_2__Group_2__14686 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__Child1_2__Group_2__1__Impl4714 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_3__Group__0__Impl_in_rule__Child1_3__Group__04749 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__Child1_3__Group__1_in_rule__Child1_3__Group__04752 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_3__NameAssignment_0_in_rule__Child1_3__Group__0__Impl4779 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_3__Group__1__Impl_in_rule__Child1_3__Group__14809 = new BitSet(new long[]{0x0000000100001800L});
        public static final BitSet FOLLOW_rule__Child1_3__Group__2_in_rule__Child1_3__Group__14812 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Child1_3__Group__1__Impl4840 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_3__Group__2__Impl_in_rule__Child1_3__Group__24871 = new BitSet(new long[]{0x0000000100001800L});
        public static final BitSet FOLLOW_rule__Child1_3__Group__3_in_rule__Child1_3__Group__24874 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_3__Group_2__0_in_rule__Child1_3__Group__2__Impl4901 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_3__Group__3__Impl_in_rule__Child1_3__Group__34932 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__Child1_3__Group__4_in_rule__Child1_3__Group__34935 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_3__EnumTypeAssignment_3_in_rule__Child1_3__Group__3__Impl4962 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_3__Group__4__Impl_in_rule__Child1_3__Group__44992 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__Child1_3__Group__5_in_rule__Child1_3__Group__44995 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__Child1_3__Group__4__Impl5023 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_3__Group__5__Impl_in_rule__Child1_3__Group__55054 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Child1_3__Group__5__Impl5082 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_3__Group_2__0__Impl_in_rule__Child1_3__Group_2__05125 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__Child1_3__Group_2__1_in_rule__Child1_3__Group_2__05128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_3__BoolAssignment_2_0_in_rule__Child1_3__Group_2__0__Impl5155 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child1_3__Group_2__1__Impl_in_rule__Child1_3__Group_2__15185 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__Child1_3__Group_2__1__Impl5213 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_1__Group__0__Impl_in_rule__Scenario2_1__Group__05248 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Scenario2_1__Group__1_in_rule__Scenario2_1__Group__05251 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__Scenario2_1__Group__0__Impl5279 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_1__Group__1__Impl_in_rule__Scenario2_1__Group__15310 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__Scenario2_1__Group__2_in_rule__Scenario2_1__Group__15313 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_1__Alternatives_1_in_rule__Scenario2_1__Group__1__Impl5340 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_1__Group__2__Impl_in_rule__Scenario2_1__Group__25370 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Scenario2_1__Group__2__Impl5398 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_2__Group__0__Impl_in_rule__Scenario2_2__Group__05435 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Scenario2_2__Group__1_in_rule__Scenario2_2__Group__05438 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__Scenario2_2__Group__0__Impl5466 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_2__Group__1__Impl_in_rule__Scenario2_2__Group__15497 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__Scenario2_2__Group__2_in_rule__Scenario2_2__Group__15500 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_2__Alternatives_1_in_rule__Scenario2_2__Group__1__Impl5529 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__Scenario2_2__Alternatives_1_in_rule__Scenario2_2__Group__1__Impl5541 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__Scenario2_2__Group__2__Impl_in_rule__Scenario2_2__Group__25574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Scenario2_2__Group__2__Impl5602 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_3__Group__0__Impl_in_rule__Scenario2_3__Group__05639 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Scenario2_3__Group__1_in_rule__Scenario2_3__Group__05642 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__Scenario2_3__Group__0__Impl5670 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_3__Group__1__Impl_in_rule__Scenario2_3__Group__15701 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__Scenario2_3__Group__2_in_rule__Scenario2_3__Group__15704 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_3__Alternatives_1_in_rule__Scenario2_3__Group__1__Impl5731 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_3__Group__2__Impl_in_rule__Scenario2_3__Group__25761 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Scenario2_3__Group__2__Impl5789 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_4__Group__0__Impl_in_rule__Scenario2_4__Group__05826 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Scenario2_4__Group__1_in_rule__Scenario2_4__Group__05829 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__Scenario2_4__Group__0__Impl5857 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_4__Group__1__Impl_in_rule__Scenario2_4__Group__15888 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__Scenario2_4__Group__2_in_rule__Scenario2_4__Group__15891 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_4__Alternatives_1_in_rule__Scenario2_4__Group__1__Impl5920 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__Scenario2_4__Alternatives_1_in_rule__Scenario2_4__Group__1__Impl5932 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__Scenario2_4__Group__2__Impl_in_rule__Scenario2_4__Group__25965 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Scenario2_4__Group__2__Impl5993 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_5__Group__0__Impl_in_rule__Scenario2_5__Group__06030 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_rule__Scenario2_5__Group__1_in_rule__Scenario2_5__Group__06033 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_5__Group__1__Impl_in_rule__Scenario2_5__Group__16091 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_rule__Scenario2_5__Group__2_in_rule__Scenario2_5__Group__16094 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__Scenario2_5__Group__1__Impl6122 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_5__Group__2__Impl_in_rule__Scenario2_5__Group__26153 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_rule__Scenario2_5__Group__3_in_rule__Scenario2_5__Group__26156 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_5__Alternatives_2_in_rule__Scenario2_5__Group__2__Impl6183 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_5__Group__3__Impl_in_rule__Scenario2_5__Group__36214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Scenario2_5__Group__3__Impl6242 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_6__Group__0__Impl_in_rule__Scenario2_6__Group__06281 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_rule__Scenario2_6__Group__1_in_rule__Scenario2_6__Group__06284 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_6__Group__1__Impl_in_rule__Scenario2_6__Group__16342 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_rule__Scenario2_6__Group__2_in_rule__Scenario2_6__Group__16345 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__Scenario2_6__Group__1__Impl6373 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_6__Group__2__Impl_in_rule__Scenario2_6__Group__26404 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_rule__Scenario2_6__Group__3_in_rule__Scenario2_6__Group__26407 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_6__Alternatives_2_in_rule__Scenario2_6__Group__2__Impl6434 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__Scenario2_6__Group__3__Impl_in_rule__Scenario2_6__Group__36465 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Scenario2_6__Group__3__Impl6493 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_7__Group__0__Impl_in_rule__Scenario2_7__Group__06532 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__Scenario2_7__Group__1_in_rule__Scenario2_7__Group__06535 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_7__Group__1__Impl_in_rule__Scenario2_7__Group__16593 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_rule__Scenario2_7__Group__2_in_rule__Scenario2_7__Group__16596 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__Scenario2_7__Group__1__Impl6624 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_7__Group__2__Impl_in_rule__Scenario2_7__Group__26655 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_rule__Scenario2_7__Group__3_in_rule__Scenario2_7__Group__26658 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_7__Alternatives_2_in_rule__Scenario2_7__Group__2__Impl6685 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_7__Group__3__Impl_in_rule__Scenario2_7__Group__36716 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Scenario2_7__Group__3__Impl6744 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_8__Group__0__Impl_in_rule__Scenario2_8__Group__06783 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_rule__Scenario2_8__Group__1_in_rule__Scenario2_8__Group__06786 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_8__Group__1__Impl_in_rule__Scenario2_8__Group__16844 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_rule__Scenario2_8__Group__2_in_rule__Scenario2_8__Group__16847 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__Scenario2_8__Group__1__Impl6875 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_8__Group__2__Impl_in_rule__Scenario2_8__Group__26906 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_rule__Scenario2_8__Group__3_in_rule__Scenario2_8__Group__26909 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario2_8__Alternatives_2_in_rule__Scenario2_8__Group__2__Impl6936 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__Scenario2_8__Group__3__Impl_in_rule__Scenario2_8__Group__36967 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Scenario2_8__Group__3__Impl6995 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_1__Group__0__Impl_in_rule__Child2_1__Group__07034 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__Child2_1__Group__1_in_rule__Child2_1__Group__07037 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_1__NameAssignment_0_in_rule__Child2_1__Group__0__Impl7064 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_1__Group__1__Impl_in_rule__Child2_1__Group__17094 = new BitSet(new long[]{0x0000000100001800L});
        public static final BitSet FOLLOW_rule__Child2_1__Group__2_in_rule__Child2_1__Group__17097 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Child2_1__Group__1__Impl7125 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_1__Group__2__Impl_in_rule__Child2_1__Group__27156 = new BitSet(new long[]{0x0000000100001800L});
        public static final BitSet FOLLOW_rule__Child2_1__Group__3_in_rule__Child2_1__Group__27159 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_1__Group_2__0_in_rule__Child2_1__Group__2__Impl7186 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_1__Group__3__Impl_in_rule__Child2_1__Group__37217 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__Child2_1__Group__4_in_rule__Child2_1__Group__37220 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_1__StringAssignment_3_in_rule__Child2_1__Group__3__Impl7247 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_1__Group__4__Impl_in_rule__Child2_1__Group__47277 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__Child2_1__Group__5_in_rule__Child2_1__Group__47280 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Child2_1__Group__4__Impl7308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_1__Group__5__Impl_in_rule__Child2_1__Group__57339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Child2_1__Group__5__Impl7367 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_1__Group_2__0__Impl_in_rule__Child2_1__Group_2__07410 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__Child2_1__Group_2__1_in_rule__Child2_1__Group_2__07413 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_1__BoolAssignment_2_0_in_rule__Child2_1__Group_2__0__Impl7440 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_1__Group_2__1__Impl_in_rule__Child2_1__Group_2__17470 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__Child2_1__Group_2__1__Impl7498 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_2__Group__0__Impl_in_rule__Child2_2__Group__07533 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__Child2_2__Group__1_in_rule__Child2_2__Group__07536 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_2__NameAssignment_0_in_rule__Child2_2__Group__0__Impl7563 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_2__Group__1__Impl_in_rule__Child2_2__Group__17593 = new BitSet(new long[]{0x0000000100001800L});
        public static final BitSet FOLLOW_rule__Child2_2__Group__2_in_rule__Child2_2__Group__17596 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Child2_2__Group__1__Impl7624 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_2__Group__2__Impl_in_rule__Child2_2__Group__27655 = new BitSet(new long[]{0x0000000100001800L});
        public static final BitSet FOLLOW_rule__Child2_2__Group__3_in_rule__Child2_2__Group__27658 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_2__Group_2__0_in_rule__Child2_2__Group__2__Impl7685 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_2__Group__3__Impl_in_rule__Child2_2__Group__37716 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__Child2_2__Group__4_in_rule__Child2_2__Group__37719 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_2__StringAssignment_3_in_rule__Child2_2__Group__3__Impl7746 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_2__Group__4__Impl_in_rule__Child2_2__Group__47776 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__Child2_2__Group__5_in_rule__Child2_2__Group__47779 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__Child2_2__Group__4__Impl7807 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_2__Group__5__Impl_in_rule__Child2_2__Group__57838 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Child2_2__Group__5__Impl7866 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_2__Group_2__0__Impl_in_rule__Child2_2__Group_2__07909 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__Child2_2__Group_2__1_in_rule__Child2_2__Group_2__07912 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_2__BoolAssignment_2_0_in_rule__Child2_2__Group_2__0__Impl7939 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_2__Group_2__1__Impl_in_rule__Child2_2__Group_2__17969 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__Child2_2__Group_2__1__Impl7997 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_3__Group__0__Impl_in_rule__Child2_3__Group__08032 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__Child2_3__Group__1_in_rule__Child2_3__Group__08035 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_3__NameAssignment_0_in_rule__Child2_3__Group__0__Impl8062 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_3__Group__1__Impl_in_rule__Child2_3__Group__18092 = new BitSet(new long[]{0x0000000100001800L});
        public static final BitSet FOLLOW_rule__Child2_3__Group__2_in_rule__Child2_3__Group__18095 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Child2_3__Group__1__Impl8123 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_3__Group__2__Impl_in_rule__Child2_3__Group__28154 = new BitSet(new long[]{0x0000000100001800L});
        public static final BitSet FOLLOW_rule__Child2_3__Group__3_in_rule__Child2_3__Group__28157 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_3__Group_2__0_in_rule__Child2_3__Group__2__Impl8184 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_3__Group__3__Impl_in_rule__Child2_3__Group__38215 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__Child2_3__Group__4_in_rule__Child2_3__Group__38218 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_3__StringAssignment_3_in_rule__Child2_3__Group__3__Impl8245 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_3__Group__4__Impl_in_rule__Child2_3__Group__48275 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__Child2_3__Group__5_in_rule__Child2_3__Group__48278 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__Child2_3__Group__4__Impl8306 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_3__Group__5__Impl_in_rule__Child2_3__Group__58337 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Child2_3__Group__5__Impl8365 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_3__Group_2__0__Impl_in_rule__Child2_3__Group_2__08408 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__Child2_3__Group_2__1_in_rule__Child2_3__Group_2__08411 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_3__BoolAssignment_2_0_in_rule__Child2_3__Group_2__0__Impl8438 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_3__Group_2__1__Impl_in_rule__Child2_3__Group_2__18468 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__Child2_3__Group_2__1__Impl8496 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_4__Group__0__Impl_in_rule__Child2_4__Group__08531 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__Child2_4__Group__1_in_rule__Child2_4__Group__08534 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_4__NameAssignment_0_in_rule__Child2_4__Group__0__Impl8561 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_4__Group__1__Impl_in_rule__Child2_4__Group__18591 = new BitSet(new long[]{0x0000000100001800L});
        public static final BitSet FOLLOW_rule__Child2_4__Group__2_in_rule__Child2_4__Group__18594 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Child2_4__Group__1__Impl8622 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_4__Group__2__Impl_in_rule__Child2_4__Group__28653 = new BitSet(new long[]{0x0000000100001800L});
        public static final BitSet FOLLOW_rule__Child2_4__Group__3_in_rule__Child2_4__Group__28656 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_4__Group_2__0_in_rule__Child2_4__Group__2__Impl8683 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_4__Group__3__Impl_in_rule__Child2_4__Group__38714 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__Child2_4__Group__4_in_rule__Child2_4__Group__38717 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_4__Alternatives_3_in_rule__Child2_4__Group__3__Impl8744 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_4__Group__4__Impl_in_rule__Child2_4__Group__48774 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__Child2_4__Group__5_in_rule__Child2_4__Group__48777 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Child2_4__Group__4__Impl8805 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_4__Group__5__Impl_in_rule__Child2_4__Group__58836 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Child2_4__Group__5__Impl8864 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_4__Group_2__0__Impl_in_rule__Child2_4__Group_2__08907 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__Child2_4__Group_2__1_in_rule__Child2_4__Group_2__08910 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_4__BoolAssignment_2_0_in_rule__Child2_4__Group_2__0__Impl8937 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_4__Group_2__1__Impl_in_rule__Child2_4__Group_2__18967 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__Child2_4__Group_2__1__Impl8995 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_5__Group__0__Impl_in_rule__Child2_5__Group__09030 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__Child2_5__Group__1_in_rule__Child2_5__Group__09033 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_5__NameAssignment_0_in_rule__Child2_5__Group__0__Impl9060 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_5__Group__1__Impl_in_rule__Child2_5__Group__19090 = new BitSet(new long[]{0x0000000100001800L});
        public static final BitSet FOLLOW_rule__Child2_5__Group__2_in_rule__Child2_5__Group__19093 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Child2_5__Group__1__Impl9121 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_5__Group__2__Impl_in_rule__Child2_5__Group__29152 = new BitSet(new long[]{0x0000000100001800L});
        public static final BitSet FOLLOW_rule__Child2_5__Group__3_in_rule__Child2_5__Group__29155 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_5__Group_2__0_in_rule__Child2_5__Group__2__Impl9182 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_5__Group__3__Impl_in_rule__Child2_5__Group__39213 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__Child2_5__Group__4_in_rule__Child2_5__Group__39216 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_5__Alternatives_3_in_rule__Child2_5__Group__3__Impl9243 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_5__Group__4__Impl_in_rule__Child2_5__Group__49273 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__Child2_5__Group__5_in_rule__Child2_5__Group__49276 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__Child2_5__Group__4__Impl9304 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_5__Group__5__Impl_in_rule__Child2_5__Group__59335 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Child2_5__Group__5__Impl9363 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_5__Group_2__0__Impl_in_rule__Child2_5__Group_2__09406 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__Child2_5__Group_2__1_in_rule__Child2_5__Group_2__09409 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_5__BoolAssignment_2_0_in_rule__Child2_5__Group_2__0__Impl9436 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_5__Group_2__1__Impl_in_rule__Child2_5__Group_2__19466 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__Child2_5__Group_2__1__Impl9494 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_6__Group__0__Impl_in_rule__Child2_6__Group__09529 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__Child2_6__Group__1_in_rule__Child2_6__Group__09532 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_6__NameAssignment_0_in_rule__Child2_6__Group__0__Impl9559 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_6__Group__1__Impl_in_rule__Child2_6__Group__19589 = new BitSet(new long[]{0x0000000100001800L});
        public static final BitSet FOLLOW_rule__Child2_6__Group__2_in_rule__Child2_6__Group__19592 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Child2_6__Group__1__Impl9620 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_6__Group__2__Impl_in_rule__Child2_6__Group__29651 = new BitSet(new long[]{0x0000000100001800L});
        public static final BitSet FOLLOW_rule__Child2_6__Group__3_in_rule__Child2_6__Group__29654 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_6__Group_2__0_in_rule__Child2_6__Group__2__Impl9681 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_6__Group__3__Impl_in_rule__Child2_6__Group__39712 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__Child2_6__Group__4_in_rule__Child2_6__Group__39715 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_6__Alternatives_3_in_rule__Child2_6__Group__3__Impl9742 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_6__Group__4__Impl_in_rule__Child2_6__Group__49772 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__Child2_6__Group__5_in_rule__Child2_6__Group__49775 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__Child2_6__Group__4__Impl9803 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_6__Group__5__Impl_in_rule__Child2_6__Group__59834 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Child2_6__Group__5__Impl9862 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_6__Group_2__0__Impl_in_rule__Child2_6__Group_2__09905 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__Child2_6__Group_2__1_in_rule__Child2_6__Group_2__09908 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_6__BoolAssignment_2_0_in_rule__Child2_6__Group_2__0__Impl9935 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_6__Group_2__1__Impl_in_rule__Child2_6__Group_2__19965 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__Child2_6__Group_2__1__Impl9993 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario1_1_in_rule__Model__Element1Assignment_010033 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario1_2_in_rule__Model__Element1Assignment_110064 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario1_3_in_rule__Model__Element1Assignment_210095 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario1_4_in_rule__Model__Element1Assignment_310126 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_1_in_rule__Model__Element2Assignment_410157 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_2_in_rule__Model__Element2Assignment_510188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_3_in_rule__Model__Element2Assignment_610219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_4_in_rule__Model__Element2Assignment_710250 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_5_in_rule__Model__Element2Assignment_810281 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_6_in_rule__Model__Element2Assignment_910312 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_7_in_rule__Model__Element2Assignment_1010343 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_8_in_rule__Model__Element2Assignment_1110374 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild1_1_in_rule__Scenario1_1__ChildAssignment_1_010405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild1_2_in_rule__Scenario1_1__ChildAssignment_1_110436 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild1_3_in_rule__Scenario1_1__ChildAssignment_1_210467 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild1_1_in_rule__Scenario1_2__ChildAssignment_1_010498 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild1_2_in_rule__Scenario1_2__ChildAssignment_1_110529 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild1_3_in_rule__Scenario1_2__ChildAssignment_1_210560 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild1_1_in_rule__Scenario1_3__ChildAssignment_2_010591 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild1_2_in_rule__Scenario1_3__ChildAssignment_2_110622 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild1_3_in_rule__Scenario1_3__ChildAssignment_2_210653 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild1_1_in_rule__Scenario1_4__ChildAssignment_2_010684 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild1_2_in_rule__Scenario1_4__ChildAssignment_2_110715 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild1_3_in_rule__Scenario1_4__ChildAssignment_2_210746 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Child1_1__NameAssignment_010777 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__Child1_1__BoolAssignment_2_010813 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumType_in_rule__Child1_1__EnumTypeAssignment_310852 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Child1_2__NameAssignment_010883 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__Child1_2__BoolAssignment_2_010919 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumType_in_rule__Child1_2__EnumTypeAssignment_310958 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Child1_3__NameAssignment_010989 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__Child1_3__BoolAssignment_2_011025 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumType_in_rule__Child1_3__EnumTypeAssignment_311064 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_1_in_rule__Scenario2_1__ChildAssignment_1_011095 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_2_in_rule__Scenario2_1__ChildAssignment_1_111126 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_3_in_rule__Scenario2_1__ChildAssignment_1_211157 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_1_in_rule__Scenario2_2__ChildAssignment_1_011188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_2_in_rule__Scenario2_2__ChildAssignment_1_111219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_3_in_rule__Scenario2_2__ChildAssignment_1_211250 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_4_in_rule__Scenario2_3__ChildAssignment_1_011281 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_5_in_rule__Scenario2_3__ChildAssignment_1_111312 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_6_in_rule__Scenario2_3__ChildAssignment_1_211343 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_4_in_rule__Scenario2_4__ChildAssignment_1_011374 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_5_in_rule__Scenario2_4__ChildAssignment_1_111405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_6_in_rule__Scenario2_4__ChildAssignment_1_211436 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_1_in_rule__Scenario2_5__ChildAssignment_2_011467 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_2_in_rule__Scenario2_5__ChildAssignment_2_111498 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_3_in_rule__Scenario2_5__ChildAssignment_2_211529 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_1_in_rule__Scenario2_6__ChildAssignment_2_011560 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_2_in_rule__Scenario2_6__ChildAssignment_2_111591 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_3_in_rule__Scenario2_6__ChildAssignment_2_211622 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_4_in_rule__Scenario2_7__ChildAssignment_2_011653 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_5_in_rule__Scenario2_7__ChildAssignment_2_111684 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_6_in_rule__Scenario2_7__ChildAssignment_2_211715 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_4_in_rule__Scenario2_8__ChildAssignment_2_011746 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_5_in_rule__Scenario2_8__ChildAssignment_2_111777 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_6_in_rule__Scenario2_8__ChildAssignment_2_211808 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Child2_1__NameAssignment_011839 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__Child2_1__BoolAssignment_2_011875 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_1__StringAlternatives_3_0_in_rule__Child2_1__StringAssignment_311914 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Child2_2__NameAssignment_011947 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__Child2_2__BoolAssignment_2_011983 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_2__StringAlternatives_3_0_in_rule__Child2_2__StringAssignment_312022 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Child2_3__NameAssignment_012055 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__Child2_3__BoolAssignment_2_012091 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Child2_3__StringAlternatives_3_0_in_rule__Child2_3__StringAssignment_312130 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Child2_4__NameAssignment_012163 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__Child2_4__BoolAssignment_2_012199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Child2_4__StringAssignment_3_012243 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Child2_4__StringAssignment_3_112287 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Child2_5__NameAssignment_012326 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__Child2_5__BoolAssignment_2_012362 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Child2_5__StringAssignment_3_012406 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Child2_5__StringAssignment_3_112450 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Child2_6__NameAssignment_012489 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__Child2_6__BoolAssignment_2_012525 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Child2_6__StringAssignment_3_012569 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Child2_6__StringAssignment_3_112613 = new BitSet(new long[]{0x0000000000000002L});
    }


}
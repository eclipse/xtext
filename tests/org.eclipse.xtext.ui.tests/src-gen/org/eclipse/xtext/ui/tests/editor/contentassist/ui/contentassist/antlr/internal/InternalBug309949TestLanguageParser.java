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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug309949TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug309949TestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1*'", "'{'", "'}'", "'#1+'", "'#2*'", "'#2+'", "'#3*'", "'#3+'", "'#4*'", "'#4+'", "'#5*'", "'#5+'", "'error'", "'operation'", "'@uuid'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int RULE_ID=4;
    public static final int T__23=23;
    public static final int T__20=20;
    public static final int T__13=13;
    public static final int RULE_STRING=6;
    public static final int T__21=21;
    public static final int T__19=19;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int T__22=22;
    public static final int RULE_WS=9;
    public static final int T__17=17;
    public static final int RULE_INT=5;
    public static final int EOF=-1;
    public static final int T__16=16;
    public static final int T__24=24;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__25=25;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__18=18;
    public static final int T__15=15;

    // delegates
    // delegators


        public InternalBug309949TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug309949TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug309949TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g"; }


     
     	private Bug309949TestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(Bug309949TestLanguageGrammarAccess grammarAccess) {
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:61:1: ( ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:62:1: ruleModel EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:69:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:73:2: ( ( ( rule__Model__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:74:1: ( ( rule__Model__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:74:1: ( ( rule__Model__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:75:1: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:76:1: ( rule__Model__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:76:2: rule__Model__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group__0_in_ruleModel94);
            rule__Model__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getGroup()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleError_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:88:1: entryRuleError_1 : ruleError_1 EOF ;
    public final void entryRuleError_1() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:89:1: ( ruleError_1 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:90:1: ruleError_1 EOF
            {
             before(grammarAccess.getError_1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleError_1_in_entryRuleError_1121);
            ruleError_1();

            state._fsp--;

             after(grammarAccess.getError_1Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleError_1128); 

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
    // $ANTLR end "entryRuleError_1"


    // $ANTLR start "ruleError_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:97:1: ruleError_1 : ( ( rule__Error_1__Group__0 ) ) ;
    public final void ruleError_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:101:2: ( ( ( rule__Error_1__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:102:1: ( ( rule__Error_1__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:102:1: ( ( rule__Error_1__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:103:1: ( rule__Error_1__Group__0 )
            {
             before(grammarAccess.getError_1Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:104:1: ( rule__Error_1__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:104:2: rule__Error_1__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Error_1__Group__0_in_ruleError_1154);
            rule__Error_1__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getError_1Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleError_1"


    // $ANTLR start "entryRuleOperation_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:116:1: entryRuleOperation_1 : ruleOperation_1 EOF ;
    public final void entryRuleOperation_1() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:117:1: ( ruleOperation_1 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:118:1: ruleOperation_1 EOF
            {
             before(grammarAccess.getOperation_1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleOperation_1_in_entryRuleOperation_1181);
            ruleOperation_1();

            state._fsp--;

             after(grammarAccess.getOperation_1Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOperation_1188); 

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
    // $ANTLR end "entryRuleOperation_1"


    // $ANTLR start "ruleOperation_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:125:1: ruleOperation_1 : ( ( rule__Operation_1__Group__0 ) ) ;
    public final void ruleOperation_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:129:2: ( ( ( rule__Operation_1__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:130:1: ( ( rule__Operation_1__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:130:1: ( ( rule__Operation_1__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:131:1: ( rule__Operation_1__Group__0 )
            {
             before(grammarAccess.getOperation_1Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:132:1: ( rule__Operation_1__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:132:2: rule__Operation_1__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation_1__Group__0_in_ruleOperation_1214);
            rule__Operation_1__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOperation_1Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOperation_1"


    // $ANTLR start "entryRuleError_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:144:1: entryRuleError_2 : ruleError_2 EOF ;
    public final void entryRuleError_2() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:145:1: ( ruleError_2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:146:1: ruleError_2 EOF
            {
             before(grammarAccess.getError_2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleError_2_in_entryRuleError_2241);
            ruleError_2();

            state._fsp--;

             after(grammarAccess.getError_2Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleError_2248); 

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
    // $ANTLR end "entryRuleError_2"


    // $ANTLR start "ruleError_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:153:1: ruleError_2 : ( ( rule__Error_2__Group__0 ) ) ;
    public final void ruleError_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:157:2: ( ( ( rule__Error_2__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:158:1: ( ( rule__Error_2__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:158:1: ( ( rule__Error_2__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:159:1: ( rule__Error_2__Group__0 )
            {
             before(grammarAccess.getError_2Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:160:1: ( rule__Error_2__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:160:2: rule__Error_2__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Error_2__Group__0_in_ruleError_2274);
            rule__Error_2__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getError_2Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleError_2"


    // $ANTLR start "entryRuleOperation_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:172:1: entryRuleOperation_2 : ruleOperation_2 EOF ;
    public final void entryRuleOperation_2() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:173:1: ( ruleOperation_2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:174:1: ruleOperation_2 EOF
            {
             before(grammarAccess.getOperation_2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleOperation_2_in_entryRuleOperation_2301);
            ruleOperation_2();

            state._fsp--;

             after(grammarAccess.getOperation_2Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOperation_2308); 

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
    // $ANTLR end "entryRuleOperation_2"


    // $ANTLR start "ruleOperation_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:181:1: ruleOperation_2 : ( ( rule__Operation_2__Group__0 ) ) ;
    public final void ruleOperation_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:185:2: ( ( ( rule__Operation_2__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:186:1: ( ( rule__Operation_2__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:186:1: ( ( rule__Operation_2__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:187:1: ( rule__Operation_2__Group__0 )
            {
             before(grammarAccess.getOperation_2Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:188:1: ( rule__Operation_2__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:188:2: rule__Operation_2__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation_2__Group__0_in_ruleOperation_2334);
            rule__Operation_2__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOperation_2Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOperation_2"


    // $ANTLR start "entryRuleError_3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:200:1: entryRuleError_3 : ruleError_3 EOF ;
    public final void entryRuleError_3() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:201:1: ( ruleError_3 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:202:1: ruleError_3 EOF
            {
             before(grammarAccess.getError_3Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleError_3_in_entryRuleError_3361);
            ruleError_3();

            state._fsp--;

             after(grammarAccess.getError_3Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleError_3368); 

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
    // $ANTLR end "entryRuleError_3"


    // $ANTLR start "ruleError_3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:209:1: ruleError_3 : ( ( rule__Error_3__Group__0 ) ) ;
    public final void ruleError_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:213:2: ( ( ( rule__Error_3__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:214:1: ( ( rule__Error_3__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:214:1: ( ( rule__Error_3__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:215:1: ( rule__Error_3__Group__0 )
            {
             before(grammarAccess.getError_3Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:216:1: ( rule__Error_3__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:216:2: rule__Error_3__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Error_3__Group__0_in_ruleError_3394);
            rule__Error_3__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getError_3Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleError_3"


    // $ANTLR start "entryRuleOperation_3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:228:1: entryRuleOperation_3 : ruleOperation_3 EOF ;
    public final void entryRuleOperation_3() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:229:1: ( ruleOperation_3 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:230:1: ruleOperation_3 EOF
            {
             before(grammarAccess.getOperation_3Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleOperation_3_in_entryRuleOperation_3421);
            ruleOperation_3();

            state._fsp--;

             after(grammarAccess.getOperation_3Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOperation_3428); 

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
    // $ANTLR end "entryRuleOperation_3"


    // $ANTLR start "ruleOperation_3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:237:1: ruleOperation_3 : ( ( rule__Operation_3__Group__0 ) ) ;
    public final void ruleOperation_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:241:2: ( ( ( rule__Operation_3__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:242:1: ( ( rule__Operation_3__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:242:1: ( ( rule__Operation_3__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:243:1: ( rule__Operation_3__Group__0 )
            {
             before(grammarAccess.getOperation_3Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:244:1: ( rule__Operation_3__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:244:2: rule__Operation_3__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation_3__Group__0_in_ruleOperation_3454);
            rule__Operation_3__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOperation_3Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOperation_3"


    // $ANTLR start "entryRuleError_4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:256:1: entryRuleError_4 : ruleError_4 EOF ;
    public final void entryRuleError_4() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:257:1: ( ruleError_4 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:258:1: ruleError_4 EOF
            {
             before(grammarAccess.getError_4Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleError_4_in_entryRuleError_4481);
            ruleError_4();

            state._fsp--;

             after(grammarAccess.getError_4Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleError_4488); 

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
    // $ANTLR end "entryRuleError_4"


    // $ANTLR start "ruleError_4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:265:1: ruleError_4 : ( ( rule__Error_4__Group__0 ) ) ;
    public final void ruleError_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:269:2: ( ( ( rule__Error_4__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:270:1: ( ( rule__Error_4__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:270:1: ( ( rule__Error_4__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:271:1: ( rule__Error_4__Group__0 )
            {
             before(grammarAccess.getError_4Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:272:1: ( rule__Error_4__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:272:2: rule__Error_4__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Error_4__Group__0_in_ruleError_4514);
            rule__Error_4__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getError_4Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleError_4"


    // $ANTLR start "entryRuleOperation_4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:284:1: entryRuleOperation_4 : ruleOperation_4 EOF ;
    public final void entryRuleOperation_4() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:285:1: ( ruleOperation_4 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:286:1: ruleOperation_4 EOF
            {
             before(grammarAccess.getOperation_4Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleOperation_4_in_entryRuleOperation_4541);
            ruleOperation_4();

            state._fsp--;

             after(grammarAccess.getOperation_4Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOperation_4548); 

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
    // $ANTLR end "entryRuleOperation_4"


    // $ANTLR start "ruleOperation_4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:293:1: ruleOperation_4 : ( ( rule__Operation_4__Group__0 ) ) ;
    public final void ruleOperation_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:297:2: ( ( ( rule__Operation_4__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:298:1: ( ( rule__Operation_4__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:298:1: ( ( rule__Operation_4__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:299:1: ( rule__Operation_4__Group__0 )
            {
             before(grammarAccess.getOperation_4Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:300:1: ( rule__Operation_4__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:300:2: rule__Operation_4__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation_4__Group__0_in_ruleOperation_4574);
            rule__Operation_4__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOperation_4Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOperation_4"


    // $ANTLR start "entryRuleError_5"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:312:1: entryRuleError_5 : ruleError_5 EOF ;
    public final void entryRuleError_5() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:313:1: ( ruleError_5 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:314:1: ruleError_5 EOF
            {
             before(grammarAccess.getError_5Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleError_5_in_entryRuleError_5601);
            ruleError_5();

            state._fsp--;

             after(grammarAccess.getError_5Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleError_5608); 

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
    // $ANTLR end "entryRuleError_5"


    // $ANTLR start "ruleError_5"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:321:1: ruleError_5 : ( ( rule__Error_5__Group__0 ) ) ;
    public final void ruleError_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:325:2: ( ( ( rule__Error_5__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:326:1: ( ( rule__Error_5__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:326:1: ( ( rule__Error_5__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:327:1: ( rule__Error_5__Group__0 )
            {
             before(grammarAccess.getError_5Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:328:1: ( rule__Error_5__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:328:2: rule__Error_5__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Error_5__Group__0_in_ruleError_5634);
            rule__Error_5__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getError_5Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleError_5"


    // $ANTLR start "entryRuleOperation_5"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:340:1: entryRuleOperation_5 : ruleOperation_5 EOF ;
    public final void entryRuleOperation_5() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:341:1: ( ruleOperation_5 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:342:1: ruleOperation_5 EOF
            {
             before(grammarAccess.getOperation_5Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleOperation_5_in_entryRuleOperation_5661);
            ruleOperation_5();

            state._fsp--;

             after(grammarAccess.getOperation_5Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOperation_5668); 

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
    // $ANTLR end "entryRuleOperation_5"


    // $ANTLR start "ruleOperation_5"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:349:1: ruleOperation_5 : ( ( rule__Operation_5__Group__0 ) ) ;
    public final void ruleOperation_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:353:2: ( ( ( rule__Operation_5__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:354:1: ( ( rule__Operation_5__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:354:1: ( ( rule__Operation_5__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:355:1: ( rule__Operation_5__Group__0 )
            {
             before(grammarAccess.getOperation_5Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:356:1: ( rule__Operation_5__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:356:2: rule__Operation_5__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation_5__Group__0_in_ruleOperation_5694);
            rule__Operation_5__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOperation_5Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOperation_5"


    // $ANTLR start "entryRuleAnnotation"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:368:1: entryRuleAnnotation : ruleAnnotation EOF ;
    public final void entryRuleAnnotation() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:369:1: ( ruleAnnotation EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:370:1: ruleAnnotation EOF
            {
             before(grammarAccess.getAnnotationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAnnotation_in_entryRuleAnnotation721);
            ruleAnnotation();

            state._fsp--;

             after(grammarAccess.getAnnotationRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAnnotation728); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:377:1: ruleAnnotation : ( ( rule__Annotation__Group__0 ) ) ;
    public final void ruleAnnotation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:381:2: ( ( ( rule__Annotation__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:382:1: ( ( rule__Annotation__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:382:1: ( ( rule__Annotation__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:383:1: ( rule__Annotation__Group__0 )
            {
             before(grammarAccess.getAnnotationAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:384:1: ( rule__Annotation__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:384:2: rule__Annotation__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Annotation__Group__0_in_ruleAnnotation754);
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


    // $ANTLR start "rule__Model__Alternatives_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:396:1: rule__Model__Alternatives_1 : ( ( ( rule__Model__Group_1_0__0 ) ) | ( ( rule__Model__Group_1_1__0 ) ) | ( ( rule__Model__Group_1_2__0 ) ) | ( ( rule__Model__Group_1_3__0 ) ) | ( ( rule__Model__Group_1_4__0 ) ) | ( ( rule__Model__Group_1_5__0 ) ) | ( ( rule__Model__Group_1_6__0 ) ) | ( ( rule__Model__Group_1_7__0 ) ) | ( ( rule__Model__Group_1_8__0 ) ) | ( ( rule__Model__Group_1_9__0 ) ) );
    public final void rule__Model__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:400:1: ( ( ( rule__Model__Group_1_0__0 ) ) | ( ( rule__Model__Group_1_1__0 ) ) | ( ( rule__Model__Group_1_2__0 ) ) | ( ( rule__Model__Group_1_3__0 ) ) | ( ( rule__Model__Group_1_4__0 ) ) | ( ( rule__Model__Group_1_5__0 ) ) | ( ( rule__Model__Group_1_6__0 ) ) | ( ( rule__Model__Group_1_7__0 ) ) | ( ( rule__Model__Group_1_8__0 ) ) | ( ( rule__Model__Group_1_9__0 ) ) )
            int alt1=10;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt1=1;
                }
                break;
            case 14:
                {
                alt1=2;
                }
                break;
            case 15:
                {
                alt1=3;
                }
                break;
            case 16:
                {
                alt1=4;
                }
                break;
            case 17:
                {
                alt1=5;
                }
                break;
            case 18:
                {
                alt1=6;
                }
                break;
            case 19:
                {
                alt1=7;
                }
                break;
            case 20:
                {
                alt1=8;
                }
                break;
            case 21:
                {
                alt1=9;
                }
                break;
            case 22:
                {
                alt1=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:401:1: ( ( rule__Model__Group_1_0__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:401:1: ( ( rule__Model__Group_1_0__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:402:1: ( rule__Model__Group_1_0__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_1_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:403:1: ( rule__Model__Group_1_0__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:403:2: rule__Model__Group_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_0__0_in_rule__Model__Alternatives_1790);
                    rule__Model__Group_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:407:6: ( ( rule__Model__Group_1_1__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:407:6: ( ( rule__Model__Group_1_1__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:408:1: ( rule__Model__Group_1_1__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_1_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:409:1: ( rule__Model__Group_1_1__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:409:2: rule__Model__Group_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_1__0_in_rule__Model__Alternatives_1808);
                    rule__Model__Group_1_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:413:6: ( ( rule__Model__Group_1_2__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:413:6: ( ( rule__Model__Group_1_2__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:414:1: ( rule__Model__Group_1_2__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_1_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:415:1: ( rule__Model__Group_1_2__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:415:2: rule__Model__Group_1_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_2__0_in_rule__Model__Alternatives_1826);
                    rule__Model__Group_1_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_1_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:419:6: ( ( rule__Model__Group_1_3__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:419:6: ( ( rule__Model__Group_1_3__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:420:1: ( rule__Model__Group_1_3__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_1_3()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:421:1: ( rule__Model__Group_1_3__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:421:2: rule__Model__Group_1_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_3__0_in_rule__Model__Alternatives_1844);
                    rule__Model__Group_1_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_1_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:425:6: ( ( rule__Model__Group_1_4__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:425:6: ( ( rule__Model__Group_1_4__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:426:1: ( rule__Model__Group_1_4__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_1_4()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:427:1: ( rule__Model__Group_1_4__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:427:2: rule__Model__Group_1_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_4__0_in_rule__Model__Alternatives_1862);
                    rule__Model__Group_1_4__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_1_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:431:6: ( ( rule__Model__Group_1_5__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:431:6: ( ( rule__Model__Group_1_5__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:432:1: ( rule__Model__Group_1_5__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_1_5()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:433:1: ( rule__Model__Group_1_5__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:433:2: rule__Model__Group_1_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_5__0_in_rule__Model__Alternatives_1880);
                    rule__Model__Group_1_5__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_1_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:437:6: ( ( rule__Model__Group_1_6__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:437:6: ( ( rule__Model__Group_1_6__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:438:1: ( rule__Model__Group_1_6__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_1_6()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:439:1: ( rule__Model__Group_1_6__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:439:2: rule__Model__Group_1_6__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_6__0_in_rule__Model__Alternatives_1898);
                    rule__Model__Group_1_6__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_1_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:443:6: ( ( rule__Model__Group_1_7__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:443:6: ( ( rule__Model__Group_1_7__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:444:1: ( rule__Model__Group_1_7__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_1_7()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:445:1: ( rule__Model__Group_1_7__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:445:2: rule__Model__Group_1_7__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_7__0_in_rule__Model__Alternatives_1916);
                    rule__Model__Group_1_7__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_1_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:449:6: ( ( rule__Model__Group_1_8__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:449:6: ( ( rule__Model__Group_1_8__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:450:1: ( rule__Model__Group_1_8__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_1_8()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:451:1: ( rule__Model__Group_1_8__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:451:2: rule__Model__Group_1_8__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_8__0_in_rule__Model__Alternatives_1934);
                    rule__Model__Group_1_8__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_1_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:455:6: ( ( rule__Model__Group_1_9__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:455:6: ( ( rule__Model__Group_1_9__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:456:1: ( rule__Model__Group_1_9__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_1_9()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:457:1: ( rule__Model__Group_1_9__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:457:2: rule__Model__Group_1_9__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_9__0_in_rule__Model__Alternatives_1952);
                    rule__Model__Group_1_9__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_1_9()); 

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
    // $ANTLR end "rule__Model__Alternatives_1"


    // $ANTLR start "rule__Model__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:468:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:472:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:473:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__0983);
            rule__Model__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group__1_in_rule__Model__Group__0986);
            rule__Model__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0"


    // $ANTLR start "rule__Model__Group__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:480:1: rule__Model__Group__0__Impl : ( () ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:484:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:485:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:485:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:486:1: ()
            {
             before(grammarAccess.getModelAccess().getModelAction_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:487:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:489:1: 
            {
            }

             after(grammarAccess.getModelAccess().getModelAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0__Impl"


    // $ANTLR start "rule__Model__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:499:1: rule__Model__Group__1 : rule__Model__Group__1__Impl ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:503:1: ( rule__Model__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:504:2: rule__Model__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__11044);
            rule__Model__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1"


    // $ANTLR start "rule__Model__Group__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:510:1: rule__Model__Group__1__Impl : ( ( rule__Model__Alternatives_1 ) ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:514:1: ( ( ( rule__Model__Alternatives_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:515:1: ( ( rule__Model__Alternatives_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:515:1: ( ( rule__Model__Alternatives_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:516:1: ( rule__Model__Alternatives_1 )
            {
             before(grammarAccess.getModelAccess().getAlternatives_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:517:1: ( rule__Model__Alternatives_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:517:2: rule__Model__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Alternatives_1_in_rule__Model__Group__1__Impl1071);
            rule__Model__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1__Impl"


    // $ANTLR start "rule__Model__Group_1_0__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:531:1: rule__Model__Group_1_0__0 : rule__Model__Group_1_0__0__Impl rule__Model__Group_1_0__1 ;
    public final void rule__Model__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:535:1: ( rule__Model__Group_1_0__0__Impl rule__Model__Group_1_0__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:536:2: rule__Model__Group_1_0__0__Impl rule__Model__Group_1_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_0__0__Impl_in_rule__Model__Group_1_0__01105);
            rule__Model__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_0__1_in_rule__Model__Group_1_0__01108);
            rule__Model__Group_1_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_0__0"


    // $ANTLR start "rule__Model__Group_1_0__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:543:1: rule__Model__Group_1_0__0__Impl : ( '#1*' ) ;
    public final void rule__Model__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:547:1: ( ( '#1*' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:548:1: ( '#1*' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:548:1: ( '#1*' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:549:1: '#1*'
            {
             before(grammarAccess.getModelAccess().getNumberSignDigitOneAsteriskKeyword_1_0_0()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Model__Group_1_0__0__Impl1136); 
             after(grammarAccess.getModelAccess().getNumberSignDigitOneAsteriskKeyword_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_0__0__Impl"


    // $ANTLR start "rule__Model__Group_1_0__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:562:1: rule__Model__Group_1_0__1 : rule__Model__Group_1_0__1__Impl rule__Model__Group_1_0__2 ;
    public final void rule__Model__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:566:1: ( rule__Model__Group_1_0__1__Impl rule__Model__Group_1_0__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:567:2: rule__Model__Group_1_0__1__Impl rule__Model__Group_1_0__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_0__1__Impl_in_rule__Model__Group_1_0__11167);
            rule__Model__Group_1_0__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_0__2_in_rule__Model__Group_1_0__11170);
            rule__Model__Group_1_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_0__1"


    // $ANTLR start "rule__Model__Group_1_0__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:574:1: rule__Model__Group_1_0__1__Impl : ( '{' ) ;
    public final void rule__Model__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:578:1: ( ( '{' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:579:1: ( '{' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:579:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:580:1: '{'
            {
             before(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_0_1()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Model__Group_1_0__1__Impl1198); 
             after(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_0__1__Impl"


    // $ANTLR start "rule__Model__Group_1_0__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:593:1: rule__Model__Group_1_0__2 : rule__Model__Group_1_0__2__Impl rule__Model__Group_1_0__3 ;
    public final void rule__Model__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:597:1: ( rule__Model__Group_1_0__2__Impl rule__Model__Group_1_0__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:598:2: rule__Model__Group_1_0__2__Impl rule__Model__Group_1_0__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_0__2__Impl_in_rule__Model__Group_1_0__21229);
            rule__Model__Group_1_0__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_0__3_in_rule__Model__Group_1_0__21232);
            rule__Model__Group_1_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_0__2"


    // $ANTLR start "rule__Model__Group_1_0__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:605:1: rule__Model__Group_1_0__2__Impl : ( ( rule__Model__ErrorsAssignment_1_0_2 )* ) ;
    public final void rule__Model__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:609:1: ( ( ( rule__Model__ErrorsAssignment_1_0_2 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:610:1: ( ( rule__Model__ErrorsAssignment_1_0_2 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:610:1: ( ( rule__Model__ErrorsAssignment_1_0_2 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:611:1: ( rule__Model__ErrorsAssignment_1_0_2 )*
            {
             before(grammarAccess.getModelAccess().getErrorsAssignment_1_0_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:612:1: ( rule__Model__ErrorsAssignment_1_0_2 )*
            loop2:
            do {
                int alt2=2;
                alt2 = dfa2.predict(input);
                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:612:2: rule__Model__ErrorsAssignment_1_0_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__ErrorsAssignment_1_0_2_in_rule__Model__Group_1_0__2__Impl1259);
            	    rule__Model__ErrorsAssignment_1_0_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getErrorsAssignment_1_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_0__2__Impl"


    // $ANTLR start "rule__Model__Group_1_0__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:622:1: rule__Model__Group_1_0__3 : rule__Model__Group_1_0__3__Impl rule__Model__Group_1_0__4 ;
    public final void rule__Model__Group_1_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:626:1: ( rule__Model__Group_1_0__3__Impl rule__Model__Group_1_0__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:627:2: rule__Model__Group_1_0__3__Impl rule__Model__Group_1_0__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_0__3__Impl_in_rule__Model__Group_1_0__31290);
            rule__Model__Group_1_0__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_0__4_in_rule__Model__Group_1_0__31293);
            rule__Model__Group_1_0__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_0__3"


    // $ANTLR start "rule__Model__Group_1_0__3__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:634:1: rule__Model__Group_1_0__3__Impl : ( ( rule__Model__OperationsAssignment_1_0_3 )* ) ;
    public final void rule__Model__Group_1_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:638:1: ( ( ( rule__Model__OperationsAssignment_1_0_3 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:639:1: ( ( rule__Model__OperationsAssignment_1_0_3 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:639:1: ( ( rule__Model__OperationsAssignment_1_0_3 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:640:1: ( rule__Model__OperationsAssignment_1_0_3 )*
            {
             before(grammarAccess.getModelAccess().getOperationsAssignment_1_0_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:641:1: ( rule__Model__OperationsAssignment_1_0_3 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=24 && LA3_0<=25)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:641:2: rule__Model__OperationsAssignment_1_0_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__OperationsAssignment_1_0_3_in_rule__Model__Group_1_0__3__Impl1320);
            	    rule__Model__OperationsAssignment_1_0_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getOperationsAssignment_1_0_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_0__3__Impl"


    // $ANTLR start "rule__Model__Group_1_0__4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:651:1: rule__Model__Group_1_0__4 : rule__Model__Group_1_0__4__Impl ;
    public final void rule__Model__Group_1_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:655:1: ( rule__Model__Group_1_0__4__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:656:2: rule__Model__Group_1_0__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_0__4__Impl_in_rule__Model__Group_1_0__41351);
            rule__Model__Group_1_0__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_0__4"


    // $ANTLR start "rule__Model__Group_1_0__4__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:662:1: rule__Model__Group_1_0__4__Impl : ( '}' ) ;
    public final void rule__Model__Group_1_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:666:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:667:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:667:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:668:1: '}'
            {
             before(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_0_4()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Model__Group_1_0__4__Impl1379); 
             after(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_0_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_0__4__Impl"


    // $ANTLR start "rule__Model__Group_1_1__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:691:1: rule__Model__Group_1_1__0 : rule__Model__Group_1_1__0__Impl rule__Model__Group_1_1__1 ;
    public final void rule__Model__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:695:1: ( rule__Model__Group_1_1__0__Impl rule__Model__Group_1_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:696:2: rule__Model__Group_1_1__0__Impl rule__Model__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_1__0__Impl_in_rule__Model__Group_1_1__01420);
            rule__Model__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_1__1_in_rule__Model__Group_1_1__01423);
            rule__Model__Group_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_1__0"


    // $ANTLR start "rule__Model__Group_1_1__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:703:1: rule__Model__Group_1_1__0__Impl : ( '#1+' ) ;
    public final void rule__Model__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:707:1: ( ( '#1+' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:708:1: ( '#1+' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:708:1: ( '#1+' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:709:1: '#1+'
            {
             before(grammarAccess.getModelAccess().getNumberSignDigitOnePlusSignKeyword_1_1_0()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Model__Group_1_1__0__Impl1451); 
             after(grammarAccess.getModelAccess().getNumberSignDigitOnePlusSignKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_1__0__Impl"


    // $ANTLR start "rule__Model__Group_1_1__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:722:1: rule__Model__Group_1_1__1 : rule__Model__Group_1_1__1__Impl rule__Model__Group_1_1__2 ;
    public final void rule__Model__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:726:1: ( rule__Model__Group_1_1__1__Impl rule__Model__Group_1_1__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:727:2: rule__Model__Group_1_1__1__Impl rule__Model__Group_1_1__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_1__1__Impl_in_rule__Model__Group_1_1__11482);
            rule__Model__Group_1_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_1__2_in_rule__Model__Group_1_1__11485);
            rule__Model__Group_1_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_1__1"


    // $ANTLR start "rule__Model__Group_1_1__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:734:1: rule__Model__Group_1_1__1__Impl : ( '{' ) ;
    public final void rule__Model__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:738:1: ( ( '{' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:739:1: ( '{' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:739:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:740:1: '{'
            {
             before(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_1_1()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Model__Group_1_1__1__Impl1513); 
             after(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_1__1__Impl"


    // $ANTLR start "rule__Model__Group_1_1__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:753:1: rule__Model__Group_1_1__2 : rule__Model__Group_1_1__2__Impl rule__Model__Group_1_1__3 ;
    public final void rule__Model__Group_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:757:1: ( rule__Model__Group_1_1__2__Impl rule__Model__Group_1_1__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:758:2: rule__Model__Group_1_1__2__Impl rule__Model__Group_1_1__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_1__2__Impl_in_rule__Model__Group_1_1__21544);
            rule__Model__Group_1_1__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_1__3_in_rule__Model__Group_1_1__21547);
            rule__Model__Group_1_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_1__2"


    // $ANTLR start "rule__Model__Group_1_1__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:765:1: rule__Model__Group_1_1__2__Impl : ( ( ( rule__Model__ErrorsAssignment_1_1_2 ) ) ( ( rule__Model__ErrorsAssignment_1_1_2 )* ) ) ;
    public final void rule__Model__Group_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:769:1: ( ( ( ( rule__Model__ErrorsAssignment_1_1_2 ) ) ( ( rule__Model__ErrorsAssignment_1_1_2 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:770:1: ( ( ( rule__Model__ErrorsAssignment_1_1_2 ) ) ( ( rule__Model__ErrorsAssignment_1_1_2 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:770:1: ( ( ( rule__Model__ErrorsAssignment_1_1_2 ) ) ( ( rule__Model__ErrorsAssignment_1_1_2 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:771:1: ( ( rule__Model__ErrorsAssignment_1_1_2 ) ) ( ( rule__Model__ErrorsAssignment_1_1_2 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:771:1: ( ( rule__Model__ErrorsAssignment_1_1_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:772:1: ( rule__Model__ErrorsAssignment_1_1_2 )
            {
             before(grammarAccess.getModelAccess().getErrorsAssignment_1_1_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:773:1: ( rule__Model__ErrorsAssignment_1_1_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:773:2: rule__Model__ErrorsAssignment_1_1_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__ErrorsAssignment_1_1_2_in_rule__Model__Group_1_1__2__Impl1576);
            rule__Model__ErrorsAssignment_1_1_2();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getErrorsAssignment_1_1_2()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:776:1: ( ( rule__Model__ErrorsAssignment_1_1_2 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:777:1: ( rule__Model__ErrorsAssignment_1_1_2 )*
            {
             before(grammarAccess.getModelAccess().getErrorsAssignment_1_1_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:778:1: ( rule__Model__ErrorsAssignment_1_1_2 )*
            loop4:
            do {
                int alt4=2;
                alt4 = dfa4.predict(input);
                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:778:2: rule__Model__ErrorsAssignment_1_1_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__ErrorsAssignment_1_1_2_in_rule__Model__Group_1_1__2__Impl1588);
            	    rule__Model__ErrorsAssignment_1_1_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getErrorsAssignment_1_1_2()); 

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
    // $ANTLR end "rule__Model__Group_1_1__2__Impl"


    // $ANTLR start "rule__Model__Group_1_1__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:789:1: rule__Model__Group_1_1__3 : rule__Model__Group_1_1__3__Impl rule__Model__Group_1_1__4 ;
    public final void rule__Model__Group_1_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:793:1: ( rule__Model__Group_1_1__3__Impl rule__Model__Group_1_1__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:794:2: rule__Model__Group_1_1__3__Impl rule__Model__Group_1_1__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_1__3__Impl_in_rule__Model__Group_1_1__31621);
            rule__Model__Group_1_1__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_1__4_in_rule__Model__Group_1_1__31624);
            rule__Model__Group_1_1__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_1__3"


    // $ANTLR start "rule__Model__Group_1_1__3__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:801:1: rule__Model__Group_1_1__3__Impl : ( ( ( rule__Model__OperationsAssignment_1_1_3 ) ) ( ( rule__Model__OperationsAssignment_1_1_3 )* ) ) ;
    public final void rule__Model__Group_1_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:805:1: ( ( ( ( rule__Model__OperationsAssignment_1_1_3 ) ) ( ( rule__Model__OperationsAssignment_1_1_3 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:806:1: ( ( ( rule__Model__OperationsAssignment_1_1_3 ) ) ( ( rule__Model__OperationsAssignment_1_1_3 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:806:1: ( ( ( rule__Model__OperationsAssignment_1_1_3 ) ) ( ( rule__Model__OperationsAssignment_1_1_3 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:807:1: ( ( rule__Model__OperationsAssignment_1_1_3 ) ) ( ( rule__Model__OperationsAssignment_1_1_3 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:807:1: ( ( rule__Model__OperationsAssignment_1_1_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:808:1: ( rule__Model__OperationsAssignment_1_1_3 )
            {
             before(grammarAccess.getModelAccess().getOperationsAssignment_1_1_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:809:1: ( rule__Model__OperationsAssignment_1_1_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:809:2: rule__Model__OperationsAssignment_1_1_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__OperationsAssignment_1_1_3_in_rule__Model__Group_1_1__3__Impl1653);
            rule__Model__OperationsAssignment_1_1_3();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getOperationsAssignment_1_1_3()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:812:1: ( ( rule__Model__OperationsAssignment_1_1_3 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:813:1: ( rule__Model__OperationsAssignment_1_1_3 )*
            {
             before(grammarAccess.getModelAccess().getOperationsAssignment_1_1_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:814:1: ( rule__Model__OperationsAssignment_1_1_3 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=24 && LA5_0<=25)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:814:2: rule__Model__OperationsAssignment_1_1_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__OperationsAssignment_1_1_3_in_rule__Model__Group_1_1__3__Impl1665);
            	    rule__Model__OperationsAssignment_1_1_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getOperationsAssignment_1_1_3()); 

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
    // $ANTLR end "rule__Model__Group_1_1__3__Impl"


    // $ANTLR start "rule__Model__Group_1_1__4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:825:1: rule__Model__Group_1_1__4 : rule__Model__Group_1_1__4__Impl ;
    public final void rule__Model__Group_1_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:829:1: ( rule__Model__Group_1_1__4__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:830:2: rule__Model__Group_1_1__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_1__4__Impl_in_rule__Model__Group_1_1__41698);
            rule__Model__Group_1_1__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_1__4"


    // $ANTLR start "rule__Model__Group_1_1__4__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:836:1: rule__Model__Group_1_1__4__Impl : ( '}' ) ;
    public final void rule__Model__Group_1_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:840:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:841:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:841:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:842:1: '}'
            {
             before(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_1_4()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Model__Group_1_1__4__Impl1726); 
             after(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_1_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_1__4__Impl"


    // $ANTLR start "rule__Model__Group_1_2__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:865:1: rule__Model__Group_1_2__0 : rule__Model__Group_1_2__0__Impl rule__Model__Group_1_2__1 ;
    public final void rule__Model__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:869:1: ( rule__Model__Group_1_2__0__Impl rule__Model__Group_1_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:870:2: rule__Model__Group_1_2__0__Impl rule__Model__Group_1_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_2__0__Impl_in_rule__Model__Group_1_2__01767);
            rule__Model__Group_1_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_2__1_in_rule__Model__Group_1_2__01770);
            rule__Model__Group_1_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_2__0"


    // $ANTLR start "rule__Model__Group_1_2__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:877:1: rule__Model__Group_1_2__0__Impl : ( '#2*' ) ;
    public final void rule__Model__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:881:1: ( ( '#2*' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:882:1: ( '#2*' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:882:1: ( '#2*' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:883:1: '#2*'
            {
             before(grammarAccess.getModelAccess().getNumberSignDigitTwoAsteriskKeyword_1_2_0()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Model__Group_1_2__0__Impl1798); 
             after(grammarAccess.getModelAccess().getNumberSignDigitTwoAsteriskKeyword_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_2__0__Impl"


    // $ANTLR start "rule__Model__Group_1_2__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:896:1: rule__Model__Group_1_2__1 : rule__Model__Group_1_2__1__Impl rule__Model__Group_1_2__2 ;
    public final void rule__Model__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:900:1: ( rule__Model__Group_1_2__1__Impl rule__Model__Group_1_2__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:901:2: rule__Model__Group_1_2__1__Impl rule__Model__Group_1_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_2__1__Impl_in_rule__Model__Group_1_2__11829);
            rule__Model__Group_1_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_2__2_in_rule__Model__Group_1_2__11832);
            rule__Model__Group_1_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_2__1"


    // $ANTLR start "rule__Model__Group_1_2__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:908:1: rule__Model__Group_1_2__1__Impl : ( '{' ) ;
    public final void rule__Model__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:912:1: ( ( '{' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:913:1: ( '{' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:913:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:914:1: '{'
            {
             before(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_2_1()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Model__Group_1_2__1__Impl1860); 
             after(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_2__1__Impl"


    // $ANTLR start "rule__Model__Group_1_2__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:927:1: rule__Model__Group_1_2__2 : rule__Model__Group_1_2__2__Impl rule__Model__Group_1_2__3 ;
    public final void rule__Model__Group_1_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:931:1: ( rule__Model__Group_1_2__2__Impl rule__Model__Group_1_2__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:932:2: rule__Model__Group_1_2__2__Impl rule__Model__Group_1_2__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_2__2__Impl_in_rule__Model__Group_1_2__21891);
            rule__Model__Group_1_2__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_2__3_in_rule__Model__Group_1_2__21894);
            rule__Model__Group_1_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_2__2"


    // $ANTLR start "rule__Model__Group_1_2__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:939:1: rule__Model__Group_1_2__2__Impl : ( ( rule__Model__ErrorsAssignment_1_2_2 )* ) ;
    public final void rule__Model__Group_1_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:943:1: ( ( ( rule__Model__ErrorsAssignment_1_2_2 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:944:1: ( ( rule__Model__ErrorsAssignment_1_2_2 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:944:1: ( ( rule__Model__ErrorsAssignment_1_2_2 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:945:1: ( rule__Model__ErrorsAssignment_1_2_2 )*
            {
             before(grammarAccess.getModelAccess().getErrorsAssignment_1_2_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:946:1: ( rule__Model__ErrorsAssignment_1_2_2 )*
            loop6:
            do {
                int alt6=2;
                alt6 = dfa6.predict(input);
                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:946:2: rule__Model__ErrorsAssignment_1_2_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__ErrorsAssignment_1_2_2_in_rule__Model__Group_1_2__2__Impl1921);
            	    rule__Model__ErrorsAssignment_1_2_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getErrorsAssignment_1_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_2__2__Impl"


    // $ANTLR start "rule__Model__Group_1_2__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:956:1: rule__Model__Group_1_2__3 : rule__Model__Group_1_2__3__Impl rule__Model__Group_1_2__4 ;
    public final void rule__Model__Group_1_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:960:1: ( rule__Model__Group_1_2__3__Impl rule__Model__Group_1_2__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:961:2: rule__Model__Group_1_2__3__Impl rule__Model__Group_1_2__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_2__3__Impl_in_rule__Model__Group_1_2__31952);
            rule__Model__Group_1_2__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_2__4_in_rule__Model__Group_1_2__31955);
            rule__Model__Group_1_2__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_2__3"


    // $ANTLR start "rule__Model__Group_1_2__3__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:968:1: rule__Model__Group_1_2__3__Impl : ( ( rule__Model__OperationsAssignment_1_2_3 )* ) ;
    public final void rule__Model__Group_1_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:972:1: ( ( ( rule__Model__OperationsAssignment_1_2_3 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:973:1: ( ( rule__Model__OperationsAssignment_1_2_3 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:973:1: ( ( rule__Model__OperationsAssignment_1_2_3 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:974:1: ( rule__Model__OperationsAssignment_1_2_3 )*
            {
             before(grammarAccess.getModelAccess().getOperationsAssignment_1_2_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:975:1: ( rule__Model__OperationsAssignment_1_2_3 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==25) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:975:2: rule__Model__OperationsAssignment_1_2_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__OperationsAssignment_1_2_3_in_rule__Model__Group_1_2__3__Impl1982);
            	    rule__Model__OperationsAssignment_1_2_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getOperationsAssignment_1_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_2__3__Impl"


    // $ANTLR start "rule__Model__Group_1_2__4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:985:1: rule__Model__Group_1_2__4 : rule__Model__Group_1_2__4__Impl ;
    public final void rule__Model__Group_1_2__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:989:1: ( rule__Model__Group_1_2__4__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:990:2: rule__Model__Group_1_2__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_2__4__Impl_in_rule__Model__Group_1_2__42013);
            rule__Model__Group_1_2__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_2__4"


    // $ANTLR start "rule__Model__Group_1_2__4__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:996:1: rule__Model__Group_1_2__4__Impl : ( '}' ) ;
    public final void rule__Model__Group_1_2__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1000:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1001:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1001:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1002:1: '}'
            {
             before(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_2_4()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Model__Group_1_2__4__Impl2041); 
             after(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_2_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_2__4__Impl"


    // $ANTLR start "rule__Model__Group_1_3__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1025:1: rule__Model__Group_1_3__0 : rule__Model__Group_1_3__0__Impl rule__Model__Group_1_3__1 ;
    public final void rule__Model__Group_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1029:1: ( rule__Model__Group_1_3__0__Impl rule__Model__Group_1_3__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1030:2: rule__Model__Group_1_3__0__Impl rule__Model__Group_1_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_3__0__Impl_in_rule__Model__Group_1_3__02082);
            rule__Model__Group_1_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_3__1_in_rule__Model__Group_1_3__02085);
            rule__Model__Group_1_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_3__0"


    // $ANTLR start "rule__Model__Group_1_3__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1037:1: rule__Model__Group_1_3__0__Impl : ( '#2+' ) ;
    public final void rule__Model__Group_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1041:1: ( ( '#2+' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1042:1: ( '#2+' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1042:1: ( '#2+' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1043:1: '#2+'
            {
             before(grammarAccess.getModelAccess().getNumberSignDigitTwoPlusSignKeyword_1_3_0()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Model__Group_1_3__0__Impl2113); 
             after(grammarAccess.getModelAccess().getNumberSignDigitTwoPlusSignKeyword_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_3__0__Impl"


    // $ANTLR start "rule__Model__Group_1_3__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1056:1: rule__Model__Group_1_3__1 : rule__Model__Group_1_3__1__Impl rule__Model__Group_1_3__2 ;
    public final void rule__Model__Group_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1060:1: ( rule__Model__Group_1_3__1__Impl rule__Model__Group_1_3__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1061:2: rule__Model__Group_1_3__1__Impl rule__Model__Group_1_3__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_3__1__Impl_in_rule__Model__Group_1_3__12144);
            rule__Model__Group_1_3__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_3__2_in_rule__Model__Group_1_3__12147);
            rule__Model__Group_1_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_3__1"


    // $ANTLR start "rule__Model__Group_1_3__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1068:1: rule__Model__Group_1_3__1__Impl : ( ( rule__Model__NameAssignment_1_3_1 ) ) ;
    public final void rule__Model__Group_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1072:1: ( ( ( rule__Model__NameAssignment_1_3_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1073:1: ( ( rule__Model__NameAssignment_1_3_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1073:1: ( ( rule__Model__NameAssignment_1_3_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1074:1: ( rule__Model__NameAssignment_1_3_1 )
            {
             before(grammarAccess.getModelAccess().getNameAssignment_1_3_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1075:1: ( rule__Model__NameAssignment_1_3_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1075:2: rule__Model__NameAssignment_1_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__NameAssignment_1_3_1_in_rule__Model__Group_1_3__1__Impl2174);
            rule__Model__NameAssignment_1_3_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getNameAssignment_1_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_3__1__Impl"


    // $ANTLR start "rule__Model__Group_1_3__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1085:1: rule__Model__Group_1_3__2 : rule__Model__Group_1_3__2__Impl rule__Model__Group_1_3__3 ;
    public final void rule__Model__Group_1_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1089:1: ( rule__Model__Group_1_3__2__Impl rule__Model__Group_1_3__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1090:2: rule__Model__Group_1_3__2__Impl rule__Model__Group_1_3__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_3__2__Impl_in_rule__Model__Group_1_3__22204);
            rule__Model__Group_1_3__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_3__3_in_rule__Model__Group_1_3__22207);
            rule__Model__Group_1_3__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_3__2"


    // $ANTLR start "rule__Model__Group_1_3__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1097:1: rule__Model__Group_1_3__2__Impl : ( '{' ) ;
    public final void rule__Model__Group_1_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1101:1: ( ( '{' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1102:1: ( '{' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1102:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1103:1: '{'
            {
             before(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_3_2()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Model__Group_1_3__2__Impl2235); 
             after(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_3__2__Impl"


    // $ANTLR start "rule__Model__Group_1_3__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1116:1: rule__Model__Group_1_3__3 : rule__Model__Group_1_3__3__Impl rule__Model__Group_1_3__4 ;
    public final void rule__Model__Group_1_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1120:1: ( rule__Model__Group_1_3__3__Impl rule__Model__Group_1_3__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1121:2: rule__Model__Group_1_3__3__Impl rule__Model__Group_1_3__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_3__3__Impl_in_rule__Model__Group_1_3__32266);
            rule__Model__Group_1_3__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_3__4_in_rule__Model__Group_1_3__32269);
            rule__Model__Group_1_3__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_3__3"


    // $ANTLR start "rule__Model__Group_1_3__3__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1128:1: rule__Model__Group_1_3__3__Impl : ( ( ( rule__Model__ErrorsAssignment_1_3_3 ) ) ( ( rule__Model__ErrorsAssignment_1_3_3 )* ) ) ;
    public final void rule__Model__Group_1_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1132:1: ( ( ( ( rule__Model__ErrorsAssignment_1_3_3 ) ) ( ( rule__Model__ErrorsAssignment_1_3_3 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1133:1: ( ( ( rule__Model__ErrorsAssignment_1_3_3 ) ) ( ( rule__Model__ErrorsAssignment_1_3_3 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1133:1: ( ( ( rule__Model__ErrorsAssignment_1_3_3 ) ) ( ( rule__Model__ErrorsAssignment_1_3_3 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1134:1: ( ( rule__Model__ErrorsAssignment_1_3_3 ) ) ( ( rule__Model__ErrorsAssignment_1_3_3 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1134:1: ( ( rule__Model__ErrorsAssignment_1_3_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1135:1: ( rule__Model__ErrorsAssignment_1_3_3 )
            {
             before(grammarAccess.getModelAccess().getErrorsAssignment_1_3_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1136:1: ( rule__Model__ErrorsAssignment_1_3_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1136:2: rule__Model__ErrorsAssignment_1_3_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__ErrorsAssignment_1_3_3_in_rule__Model__Group_1_3__3__Impl2298);
            rule__Model__ErrorsAssignment_1_3_3();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getErrorsAssignment_1_3_3()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1139:1: ( ( rule__Model__ErrorsAssignment_1_3_3 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1140:1: ( rule__Model__ErrorsAssignment_1_3_3 )*
            {
             before(grammarAccess.getModelAccess().getErrorsAssignment_1_3_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1141:1: ( rule__Model__ErrorsAssignment_1_3_3 )*
            loop8:
            do {
                int alt8=2;
                alt8 = dfa8.predict(input);
                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1141:2: rule__Model__ErrorsAssignment_1_3_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__ErrorsAssignment_1_3_3_in_rule__Model__Group_1_3__3__Impl2310);
            	    rule__Model__ErrorsAssignment_1_3_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getErrorsAssignment_1_3_3()); 

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
    // $ANTLR end "rule__Model__Group_1_3__3__Impl"


    // $ANTLR start "rule__Model__Group_1_3__4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1152:1: rule__Model__Group_1_3__4 : rule__Model__Group_1_3__4__Impl rule__Model__Group_1_3__5 ;
    public final void rule__Model__Group_1_3__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1156:1: ( rule__Model__Group_1_3__4__Impl rule__Model__Group_1_3__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1157:2: rule__Model__Group_1_3__4__Impl rule__Model__Group_1_3__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_3__4__Impl_in_rule__Model__Group_1_3__42343);
            rule__Model__Group_1_3__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_3__5_in_rule__Model__Group_1_3__42346);
            rule__Model__Group_1_3__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_3__4"


    // $ANTLR start "rule__Model__Group_1_3__4__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1164:1: rule__Model__Group_1_3__4__Impl : ( ( ( rule__Model__OperationsAssignment_1_3_4 ) ) ( ( rule__Model__OperationsAssignment_1_3_4 )* ) ) ;
    public final void rule__Model__Group_1_3__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1168:1: ( ( ( ( rule__Model__OperationsAssignment_1_3_4 ) ) ( ( rule__Model__OperationsAssignment_1_3_4 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1169:1: ( ( ( rule__Model__OperationsAssignment_1_3_4 ) ) ( ( rule__Model__OperationsAssignment_1_3_4 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1169:1: ( ( ( rule__Model__OperationsAssignment_1_3_4 ) ) ( ( rule__Model__OperationsAssignment_1_3_4 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1170:1: ( ( rule__Model__OperationsAssignment_1_3_4 ) ) ( ( rule__Model__OperationsAssignment_1_3_4 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1170:1: ( ( rule__Model__OperationsAssignment_1_3_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1171:1: ( rule__Model__OperationsAssignment_1_3_4 )
            {
             before(grammarAccess.getModelAccess().getOperationsAssignment_1_3_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1172:1: ( rule__Model__OperationsAssignment_1_3_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1172:2: rule__Model__OperationsAssignment_1_3_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__OperationsAssignment_1_3_4_in_rule__Model__Group_1_3__4__Impl2375);
            rule__Model__OperationsAssignment_1_3_4();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getOperationsAssignment_1_3_4()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1175:1: ( ( rule__Model__OperationsAssignment_1_3_4 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1176:1: ( rule__Model__OperationsAssignment_1_3_4 )*
            {
             before(grammarAccess.getModelAccess().getOperationsAssignment_1_3_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1177:1: ( rule__Model__OperationsAssignment_1_3_4 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==25) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1177:2: rule__Model__OperationsAssignment_1_3_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__OperationsAssignment_1_3_4_in_rule__Model__Group_1_3__4__Impl2387);
            	    rule__Model__OperationsAssignment_1_3_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getOperationsAssignment_1_3_4()); 

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
    // $ANTLR end "rule__Model__Group_1_3__4__Impl"


    // $ANTLR start "rule__Model__Group_1_3__5"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1188:1: rule__Model__Group_1_3__5 : rule__Model__Group_1_3__5__Impl ;
    public final void rule__Model__Group_1_3__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1192:1: ( rule__Model__Group_1_3__5__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1193:2: rule__Model__Group_1_3__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_3__5__Impl_in_rule__Model__Group_1_3__52420);
            rule__Model__Group_1_3__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_3__5"


    // $ANTLR start "rule__Model__Group_1_3__5__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1199:1: rule__Model__Group_1_3__5__Impl : ( '}' ) ;
    public final void rule__Model__Group_1_3__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1203:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1204:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1204:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1205:1: '}'
            {
             before(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_3_5()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Model__Group_1_3__5__Impl2448); 
             after(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_3_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_3__5__Impl"


    // $ANTLR start "rule__Model__Group_1_4__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1230:1: rule__Model__Group_1_4__0 : rule__Model__Group_1_4__0__Impl rule__Model__Group_1_4__1 ;
    public final void rule__Model__Group_1_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1234:1: ( rule__Model__Group_1_4__0__Impl rule__Model__Group_1_4__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1235:2: rule__Model__Group_1_4__0__Impl rule__Model__Group_1_4__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_4__0__Impl_in_rule__Model__Group_1_4__02491);
            rule__Model__Group_1_4__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_4__1_in_rule__Model__Group_1_4__02494);
            rule__Model__Group_1_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_4__0"


    // $ANTLR start "rule__Model__Group_1_4__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1242:1: rule__Model__Group_1_4__0__Impl : ( '#3*' ) ;
    public final void rule__Model__Group_1_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1246:1: ( ( '#3*' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1247:1: ( '#3*' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1247:1: ( '#3*' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1248:1: '#3*'
            {
             before(grammarAccess.getModelAccess().getNumberSignDigitThreeAsteriskKeyword_1_4_0()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__Model__Group_1_4__0__Impl2522); 
             after(grammarAccess.getModelAccess().getNumberSignDigitThreeAsteriskKeyword_1_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_4__0__Impl"


    // $ANTLR start "rule__Model__Group_1_4__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1261:1: rule__Model__Group_1_4__1 : rule__Model__Group_1_4__1__Impl rule__Model__Group_1_4__2 ;
    public final void rule__Model__Group_1_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1265:1: ( rule__Model__Group_1_4__1__Impl rule__Model__Group_1_4__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1266:2: rule__Model__Group_1_4__1__Impl rule__Model__Group_1_4__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_4__1__Impl_in_rule__Model__Group_1_4__12553);
            rule__Model__Group_1_4__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_4__2_in_rule__Model__Group_1_4__12556);
            rule__Model__Group_1_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_4__1"


    // $ANTLR start "rule__Model__Group_1_4__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1273:1: rule__Model__Group_1_4__1__Impl : ( ( rule__Model__NameAssignment_1_4_1 ) ) ;
    public final void rule__Model__Group_1_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1277:1: ( ( ( rule__Model__NameAssignment_1_4_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1278:1: ( ( rule__Model__NameAssignment_1_4_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1278:1: ( ( rule__Model__NameAssignment_1_4_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1279:1: ( rule__Model__NameAssignment_1_4_1 )
            {
             before(grammarAccess.getModelAccess().getNameAssignment_1_4_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1280:1: ( rule__Model__NameAssignment_1_4_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1280:2: rule__Model__NameAssignment_1_4_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__NameAssignment_1_4_1_in_rule__Model__Group_1_4__1__Impl2583);
            rule__Model__NameAssignment_1_4_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getNameAssignment_1_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_4__1__Impl"


    // $ANTLR start "rule__Model__Group_1_4__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1290:1: rule__Model__Group_1_4__2 : rule__Model__Group_1_4__2__Impl rule__Model__Group_1_4__3 ;
    public final void rule__Model__Group_1_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1294:1: ( rule__Model__Group_1_4__2__Impl rule__Model__Group_1_4__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1295:2: rule__Model__Group_1_4__2__Impl rule__Model__Group_1_4__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_4__2__Impl_in_rule__Model__Group_1_4__22613);
            rule__Model__Group_1_4__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_4__3_in_rule__Model__Group_1_4__22616);
            rule__Model__Group_1_4__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_4__2"


    // $ANTLR start "rule__Model__Group_1_4__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1302:1: rule__Model__Group_1_4__2__Impl : ( '{' ) ;
    public final void rule__Model__Group_1_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1306:1: ( ( '{' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1307:1: ( '{' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1307:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1308:1: '{'
            {
             before(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_4_2()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Model__Group_1_4__2__Impl2644); 
             after(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_4__2__Impl"


    // $ANTLR start "rule__Model__Group_1_4__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1321:1: rule__Model__Group_1_4__3 : rule__Model__Group_1_4__3__Impl rule__Model__Group_1_4__4 ;
    public final void rule__Model__Group_1_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1325:1: ( rule__Model__Group_1_4__3__Impl rule__Model__Group_1_4__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1326:2: rule__Model__Group_1_4__3__Impl rule__Model__Group_1_4__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_4__3__Impl_in_rule__Model__Group_1_4__32675);
            rule__Model__Group_1_4__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_4__4_in_rule__Model__Group_1_4__32678);
            rule__Model__Group_1_4__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_4__3"


    // $ANTLR start "rule__Model__Group_1_4__3__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1333:1: rule__Model__Group_1_4__3__Impl : ( ( rule__Model__ErrorsAssignment_1_4_3 )* ) ;
    public final void rule__Model__Group_1_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1337:1: ( ( ( rule__Model__ErrorsAssignment_1_4_3 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1338:1: ( ( rule__Model__ErrorsAssignment_1_4_3 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1338:1: ( ( rule__Model__ErrorsAssignment_1_4_3 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1339:1: ( rule__Model__ErrorsAssignment_1_4_3 )*
            {
             before(grammarAccess.getModelAccess().getErrorsAssignment_1_4_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1340:1: ( rule__Model__ErrorsAssignment_1_4_3 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==25) ) {
                    int LA10_1 = input.LA(2);

                    if ( (LA10_1==RULE_ID) ) {
                        int LA10_4 = input.LA(3);

                        if ( (LA10_4==23) ) {
                            alt10=1;
                        }


                    }


                }
                else if ( (LA10_0==23) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1340:2: rule__Model__ErrorsAssignment_1_4_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__ErrorsAssignment_1_4_3_in_rule__Model__Group_1_4__3__Impl2705);
            	    rule__Model__ErrorsAssignment_1_4_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getErrorsAssignment_1_4_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_4__3__Impl"


    // $ANTLR start "rule__Model__Group_1_4__4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1350:1: rule__Model__Group_1_4__4 : rule__Model__Group_1_4__4__Impl rule__Model__Group_1_4__5 ;
    public final void rule__Model__Group_1_4__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1354:1: ( rule__Model__Group_1_4__4__Impl rule__Model__Group_1_4__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1355:2: rule__Model__Group_1_4__4__Impl rule__Model__Group_1_4__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_4__4__Impl_in_rule__Model__Group_1_4__42736);
            rule__Model__Group_1_4__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_4__5_in_rule__Model__Group_1_4__42739);
            rule__Model__Group_1_4__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_4__4"


    // $ANTLR start "rule__Model__Group_1_4__4__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1362:1: rule__Model__Group_1_4__4__Impl : ( ( rule__Model__OperationsAssignment_1_4_4 )* ) ;
    public final void rule__Model__Group_1_4__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1366:1: ( ( ( rule__Model__OperationsAssignment_1_4_4 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1367:1: ( ( rule__Model__OperationsAssignment_1_4_4 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1367:1: ( ( rule__Model__OperationsAssignment_1_4_4 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1368:1: ( rule__Model__OperationsAssignment_1_4_4 )*
            {
             before(grammarAccess.getModelAccess().getOperationsAssignment_1_4_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1369:1: ( rule__Model__OperationsAssignment_1_4_4 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=24 && LA11_0<=25)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1369:2: rule__Model__OperationsAssignment_1_4_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__OperationsAssignment_1_4_4_in_rule__Model__Group_1_4__4__Impl2766);
            	    rule__Model__OperationsAssignment_1_4_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getOperationsAssignment_1_4_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_4__4__Impl"


    // $ANTLR start "rule__Model__Group_1_4__5"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1379:1: rule__Model__Group_1_4__5 : rule__Model__Group_1_4__5__Impl ;
    public final void rule__Model__Group_1_4__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1383:1: ( rule__Model__Group_1_4__5__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1384:2: rule__Model__Group_1_4__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_4__5__Impl_in_rule__Model__Group_1_4__52797);
            rule__Model__Group_1_4__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_4__5"


    // $ANTLR start "rule__Model__Group_1_4__5__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1390:1: rule__Model__Group_1_4__5__Impl : ( '}' ) ;
    public final void rule__Model__Group_1_4__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1394:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1395:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1395:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1396:1: '}'
            {
             before(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_4_5()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Model__Group_1_4__5__Impl2825); 
             after(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_4_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_4__5__Impl"


    // $ANTLR start "rule__Model__Group_1_5__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1421:1: rule__Model__Group_1_5__0 : rule__Model__Group_1_5__0__Impl rule__Model__Group_1_5__1 ;
    public final void rule__Model__Group_1_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1425:1: ( rule__Model__Group_1_5__0__Impl rule__Model__Group_1_5__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1426:2: rule__Model__Group_1_5__0__Impl rule__Model__Group_1_5__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_5__0__Impl_in_rule__Model__Group_1_5__02868);
            rule__Model__Group_1_5__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_5__1_in_rule__Model__Group_1_5__02871);
            rule__Model__Group_1_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_5__0"


    // $ANTLR start "rule__Model__Group_1_5__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1433:1: rule__Model__Group_1_5__0__Impl : ( '#3+' ) ;
    public final void rule__Model__Group_1_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1437:1: ( ( '#3+' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1438:1: ( '#3+' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1438:1: ( '#3+' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1439:1: '#3+'
            {
             before(grammarAccess.getModelAccess().getNumberSignDigitThreePlusSignKeyword_1_5_0()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Model__Group_1_5__0__Impl2899); 
             after(grammarAccess.getModelAccess().getNumberSignDigitThreePlusSignKeyword_1_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_5__0__Impl"


    // $ANTLR start "rule__Model__Group_1_5__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1452:1: rule__Model__Group_1_5__1 : rule__Model__Group_1_5__1__Impl rule__Model__Group_1_5__2 ;
    public final void rule__Model__Group_1_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1456:1: ( rule__Model__Group_1_5__1__Impl rule__Model__Group_1_5__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1457:2: rule__Model__Group_1_5__1__Impl rule__Model__Group_1_5__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_5__1__Impl_in_rule__Model__Group_1_5__12930);
            rule__Model__Group_1_5__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_5__2_in_rule__Model__Group_1_5__12933);
            rule__Model__Group_1_5__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_5__1"


    // $ANTLR start "rule__Model__Group_1_5__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1464:1: rule__Model__Group_1_5__1__Impl : ( ( rule__Model__NameAssignment_1_5_1 ) ) ;
    public final void rule__Model__Group_1_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1468:1: ( ( ( rule__Model__NameAssignment_1_5_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1469:1: ( ( rule__Model__NameAssignment_1_5_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1469:1: ( ( rule__Model__NameAssignment_1_5_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1470:1: ( rule__Model__NameAssignment_1_5_1 )
            {
             before(grammarAccess.getModelAccess().getNameAssignment_1_5_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1471:1: ( rule__Model__NameAssignment_1_5_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1471:2: rule__Model__NameAssignment_1_5_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__NameAssignment_1_5_1_in_rule__Model__Group_1_5__1__Impl2960);
            rule__Model__NameAssignment_1_5_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getNameAssignment_1_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_5__1__Impl"


    // $ANTLR start "rule__Model__Group_1_5__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1481:1: rule__Model__Group_1_5__2 : rule__Model__Group_1_5__2__Impl rule__Model__Group_1_5__3 ;
    public final void rule__Model__Group_1_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1485:1: ( rule__Model__Group_1_5__2__Impl rule__Model__Group_1_5__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1486:2: rule__Model__Group_1_5__2__Impl rule__Model__Group_1_5__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_5__2__Impl_in_rule__Model__Group_1_5__22990);
            rule__Model__Group_1_5__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_5__3_in_rule__Model__Group_1_5__22993);
            rule__Model__Group_1_5__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_5__2"


    // $ANTLR start "rule__Model__Group_1_5__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1493:1: rule__Model__Group_1_5__2__Impl : ( '{' ) ;
    public final void rule__Model__Group_1_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1497:1: ( ( '{' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1498:1: ( '{' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1498:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1499:1: '{'
            {
             before(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_5_2()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Model__Group_1_5__2__Impl3021); 
             after(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_5_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_5__2__Impl"


    // $ANTLR start "rule__Model__Group_1_5__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1512:1: rule__Model__Group_1_5__3 : rule__Model__Group_1_5__3__Impl rule__Model__Group_1_5__4 ;
    public final void rule__Model__Group_1_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1516:1: ( rule__Model__Group_1_5__3__Impl rule__Model__Group_1_5__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1517:2: rule__Model__Group_1_5__3__Impl rule__Model__Group_1_5__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_5__3__Impl_in_rule__Model__Group_1_5__33052);
            rule__Model__Group_1_5__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_5__4_in_rule__Model__Group_1_5__33055);
            rule__Model__Group_1_5__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_5__3"


    // $ANTLR start "rule__Model__Group_1_5__3__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1524:1: rule__Model__Group_1_5__3__Impl : ( ( ( rule__Model__ErrorsAssignment_1_5_3 ) ) ( ( rule__Model__ErrorsAssignment_1_5_3 )* ) ) ;
    public final void rule__Model__Group_1_5__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1528:1: ( ( ( ( rule__Model__ErrorsAssignment_1_5_3 ) ) ( ( rule__Model__ErrorsAssignment_1_5_3 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1529:1: ( ( ( rule__Model__ErrorsAssignment_1_5_3 ) ) ( ( rule__Model__ErrorsAssignment_1_5_3 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1529:1: ( ( ( rule__Model__ErrorsAssignment_1_5_3 ) ) ( ( rule__Model__ErrorsAssignment_1_5_3 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1530:1: ( ( rule__Model__ErrorsAssignment_1_5_3 ) ) ( ( rule__Model__ErrorsAssignment_1_5_3 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1530:1: ( ( rule__Model__ErrorsAssignment_1_5_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1531:1: ( rule__Model__ErrorsAssignment_1_5_3 )
            {
             before(grammarAccess.getModelAccess().getErrorsAssignment_1_5_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1532:1: ( rule__Model__ErrorsAssignment_1_5_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1532:2: rule__Model__ErrorsAssignment_1_5_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__ErrorsAssignment_1_5_3_in_rule__Model__Group_1_5__3__Impl3084);
            rule__Model__ErrorsAssignment_1_5_3();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getErrorsAssignment_1_5_3()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1535:1: ( ( rule__Model__ErrorsAssignment_1_5_3 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1536:1: ( rule__Model__ErrorsAssignment_1_5_3 )*
            {
             before(grammarAccess.getModelAccess().getErrorsAssignment_1_5_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1537:1: ( rule__Model__ErrorsAssignment_1_5_3 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==25) ) {
                    int LA12_1 = input.LA(2);

                    if ( (LA12_1==RULE_ID) ) {
                        int LA12_4 = input.LA(3);

                        if ( (LA12_4==23) ) {
                            alt12=1;
                        }


                    }


                }
                else if ( (LA12_0==23) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1537:2: rule__Model__ErrorsAssignment_1_5_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__ErrorsAssignment_1_5_3_in_rule__Model__Group_1_5__3__Impl3096);
            	    rule__Model__ErrorsAssignment_1_5_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getErrorsAssignment_1_5_3()); 

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
    // $ANTLR end "rule__Model__Group_1_5__3__Impl"


    // $ANTLR start "rule__Model__Group_1_5__4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1548:1: rule__Model__Group_1_5__4 : rule__Model__Group_1_5__4__Impl rule__Model__Group_1_5__5 ;
    public final void rule__Model__Group_1_5__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1552:1: ( rule__Model__Group_1_5__4__Impl rule__Model__Group_1_5__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1553:2: rule__Model__Group_1_5__4__Impl rule__Model__Group_1_5__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_5__4__Impl_in_rule__Model__Group_1_5__43129);
            rule__Model__Group_1_5__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_5__5_in_rule__Model__Group_1_5__43132);
            rule__Model__Group_1_5__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_5__4"


    // $ANTLR start "rule__Model__Group_1_5__4__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1560:1: rule__Model__Group_1_5__4__Impl : ( ( ( rule__Model__OperationsAssignment_1_5_4 ) ) ( ( rule__Model__OperationsAssignment_1_5_4 )* ) ) ;
    public final void rule__Model__Group_1_5__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1564:1: ( ( ( ( rule__Model__OperationsAssignment_1_5_4 ) ) ( ( rule__Model__OperationsAssignment_1_5_4 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1565:1: ( ( ( rule__Model__OperationsAssignment_1_5_4 ) ) ( ( rule__Model__OperationsAssignment_1_5_4 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1565:1: ( ( ( rule__Model__OperationsAssignment_1_5_4 ) ) ( ( rule__Model__OperationsAssignment_1_5_4 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1566:1: ( ( rule__Model__OperationsAssignment_1_5_4 ) ) ( ( rule__Model__OperationsAssignment_1_5_4 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1566:1: ( ( rule__Model__OperationsAssignment_1_5_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1567:1: ( rule__Model__OperationsAssignment_1_5_4 )
            {
             before(grammarAccess.getModelAccess().getOperationsAssignment_1_5_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1568:1: ( rule__Model__OperationsAssignment_1_5_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1568:2: rule__Model__OperationsAssignment_1_5_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__OperationsAssignment_1_5_4_in_rule__Model__Group_1_5__4__Impl3161);
            rule__Model__OperationsAssignment_1_5_4();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getOperationsAssignment_1_5_4()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1571:1: ( ( rule__Model__OperationsAssignment_1_5_4 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1572:1: ( rule__Model__OperationsAssignment_1_5_4 )*
            {
             before(grammarAccess.getModelAccess().getOperationsAssignment_1_5_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1573:1: ( rule__Model__OperationsAssignment_1_5_4 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=24 && LA13_0<=25)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1573:2: rule__Model__OperationsAssignment_1_5_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__OperationsAssignment_1_5_4_in_rule__Model__Group_1_5__4__Impl3173);
            	    rule__Model__OperationsAssignment_1_5_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getOperationsAssignment_1_5_4()); 

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
    // $ANTLR end "rule__Model__Group_1_5__4__Impl"


    // $ANTLR start "rule__Model__Group_1_5__5"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1584:1: rule__Model__Group_1_5__5 : rule__Model__Group_1_5__5__Impl ;
    public final void rule__Model__Group_1_5__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1588:1: ( rule__Model__Group_1_5__5__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1589:2: rule__Model__Group_1_5__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_5__5__Impl_in_rule__Model__Group_1_5__53206);
            rule__Model__Group_1_5__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_5__5"


    // $ANTLR start "rule__Model__Group_1_5__5__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1595:1: rule__Model__Group_1_5__5__Impl : ( '}' ) ;
    public final void rule__Model__Group_1_5__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1599:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1600:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1600:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1601:1: '}'
            {
             before(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_5_5()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Model__Group_1_5__5__Impl3234); 
             after(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_5_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_5__5__Impl"


    // $ANTLR start "rule__Model__Group_1_6__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1626:1: rule__Model__Group_1_6__0 : rule__Model__Group_1_6__0__Impl rule__Model__Group_1_6__1 ;
    public final void rule__Model__Group_1_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1630:1: ( rule__Model__Group_1_6__0__Impl rule__Model__Group_1_6__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1631:2: rule__Model__Group_1_6__0__Impl rule__Model__Group_1_6__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_6__0__Impl_in_rule__Model__Group_1_6__03277);
            rule__Model__Group_1_6__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_6__1_in_rule__Model__Group_1_6__03280);
            rule__Model__Group_1_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_6__0"


    // $ANTLR start "rule__Model__Group_1_6__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1638:1: rule__Model__Group_1_6__0__Impl : ( '#4*' ) ;
    public final void rule__Model__Group_1_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1642:1: ( ( '#4*' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1643:1: ( '#4*' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1643:1: ( '#4*' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1644:1: '#4*'
            {
             before(grammarAccess.getModelAccess().getNumberSignDigitFourAsteriskKeyword_1_6_0()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Model__Group_1_6__0__Impl3308); 
             after(grammarAccess.getModelAccess().getNumberSignDigitFourAsteriskKeyword_1_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_6__0__Impl"


    // $ANTLR start "rule__Model__Group_1_6__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1657:1: rule__Model__Group_1_6__1 : rule__Model__Group_1_6__1__Impl rule__Model__Group_1_6__2 ;
    public final void rule__Model__Group_1_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1661:1: ( rule__Model__Group_1_6__1__Impl rule__Model__Group_1_6__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1662:2: rule__Model__Group_1_6__1__Impl rule__Model__Group_1_6__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_6__1__Impl_in_rule__Model__Group_1_6__13339);
            rule__Model__Group_1_6__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_6__2_in_rule__Model__Group_1_6__13342);
            rule__Model__Group_1_6__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_6__1"


    // $ANTLR start "rule__Model__Group_1_6__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1669:1: rule__Model__Group_1_6__1__Impl : ( ( rule__Model__NameAssignment_1_6_1 ) ) ;
    public final void rule__Model__Group_1_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1673:1: ( ( ( rule__Model__NameAssignment_1_6_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1674:1: ( ( rule__Model__NameAssignment_1_6_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1674:1: ( ( rule__Model__NameAssignment_1_6_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1675:1: ( rule__Model__NameAssignment_1_6_1 )
            {
             before(grammarAccess.getModelAccess().getNameAssignment_1_6_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1676:1: ( rule__Model__NameAssignment_1_6_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1676:2: rule__Model__NameAssignment_1_6_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__NameAssignment_1_6_1_in_rule__Model__Group_1_6__1__Impl3369);
            rule__Model__NameAssignment_1_6_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getNameAssignment_1_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_6__1__Impl"


    // $ANTLR start "rule__Model__Group_1_6__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1686:1: rule__Model__Group_1_6__2 : rule__Model__Group_1_6__2__Impl rule__Model__Group_1_6__3 ;
    public final void rule__Model__Group_1_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1690:1: ( rule__Model__Group_1_6__2__Impl rule__Model__Group_1_6__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1691:2: rule__Model__Group_1_6__2__Impl rule__Model__Group_1_6__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_6__2__Impl_in_rule__Model__Group_1_6__23399);
            rule__Model__Group_1_6__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_6__3_in_rule__Model__Group_1_6__23402);
            rule__Model__Group_1_6__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_6__2"


    // $ANTLR start "rule__Model__Group_1_6__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1698:1: rule__Model__Group_1_6__2__Impl : ( '{' ) ;
    public final void rule__Model__Group_1_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1702:1: ( ( '{' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1703:1: ( '{' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1703:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1704:1: '{'
            {
             before(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_6_2()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Model__Group_1_6__2__Impl3430); 
             after(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_6_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_6__2__Impl"


    // $ANTLR start "rule__Model__Group_1_6__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1717:1: rule__Model__Group_1_6__3 : rule__Model__Group_1_6__3__Impl rule__Model__Group_1_6__4 ;
    public final void rule__Model__Group_1_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1721:1: ( rule__Model__Group_1_6__3__Impl rule__Model__Group_1_6__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1722:2: rule__Model__Group_1_6__3__Impl rule__Model__Group_1_6__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_6__3__Impl_in_rule__Model__Group_1_6__33461);
            rule__Model__Group_1_6__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_6__4_in_rule__Model__Group_1_6__33464);
            rule__Model__Group_1_6__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_6__3"


    // $ANTLR start "rule__Model__Group_1_6__3__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1729:1: rule__Model__Group_1_6__3__Impl : ( ( rule__Model__ErrorsAssignment_1_6_3 )* ) ;
    public final void rule__Model__Group_1_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1733:1: ( ( ( rule__Model__ErrorsAssignment_1_6_3 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1734:1: ( ( rule__Model__ErrorsAssignment_1_6_3 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1734:1: ( ( rule__Model__ErrorsAssignment_1_6_3 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1735:1: ( rule__Model__ErrorsAssignment_1_6_3 )*
            {
             before(grammarAccess.getModelAccess().getErrorsAssignment_1_6_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1736:1: ( rule__Model__ErrorsAssignment_1_6_3 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==25) ) {
                    int LA14_1 = input.LA(2);

                    if ( (LA14_1==RULE_ID) ) {
                        int LA14_3 = input.LA(3);

                        if ( (LA14_3==23) ) {
                            alt14=1;
                        }


                    }


                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1736:2: rule__Model__ErrorsAssignment_1_6_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__ErrorsAssignment_1_6_3_in_rule__Model__Group_1_6__3__Impl3491);
            	    rule__Model__ErrorsAssignment_1_6_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getErrorsAssignment_1_6_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_6__3__Impl"


    // $ANTLR start "rule__Model__Group_1_6__4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1746:1: rule__Model__Group_1_6__4 : rule__Model__Group_1_6__4__Impl rule__Model__Group_1_6__5 ;
    public final void rule__Model__Group_1_6__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1750:1: ( rule__Model__Group_1_6__4__Impl rule__Model__Group_1_6__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1751:2: rule__Model__Group_1_6__4__Impl rule__Model__Group_1_6__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_6__4__Impl_in_rule__Model__Group_1_6__43522);
            rule__Model__Group_1_6__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_6__5_in_rule__Model__Group_1_6__43525);
            rule__Model__Group_1_6__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_6__4"


    // $ANTLR start "rule__Model__Group_1_6__4__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1758:1: rule__Model__Group_1_6__4__Impl : ( ( rule__Model__OperationsAssignment_1_6_4 )* ) ;
    public final void rule__Model__Group_1_6__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1762:1: ( ( ( rule__Model__OperationsAssignment_1_6_4 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1763:1: ( ( rule__Model__OperationsAssignment_1_6_4 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1763:1: ( ( rule__Model__OperationsAssignment_1_6_4 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1764:1: ( rule__Model__OperationsAssignment_1_6_4 )*
            {
             before(grammarAccess.getModelAccess().getOperationsAssignment_1_6_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1765:1: ( rule__Model__OperationsAssignment_1_6_4 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==25) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1765:2: rule__Model__OperationsAssignment_1_6_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__OperationsAssignment_1_6_4_in_rule__Model__Group_1_6__4__Impl3552);
            	    rule__Model__OperationsAssignment_1_6_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getOperationsAssignment_1_6_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_6__4__Impl"


    // $ANTLR start "rule__Model__Group_1_6__5"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1775:1: rule__Model__Group_1_6__5 : rule__Model__Group_1_6__5__Impl ;
    public final void rule__Model__Group_1_6__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1779:1: ( rule__Model__Group_1_6__5__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1780:2: rule__Model__Group_1_6__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_6__5__Impl_in_rule__Model__Group_1_6__53583);
            rule__Model__Group_1_6__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_6__5"


    // $ANTLR start "rule__Model__Group_1_6__5__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1786:1: rule__Model__Group_1_6__5__Impl : ( '}' ) ;
    public final void rule__Model__Group_1_6__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1790:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1791:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1791:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1792:1: '}'
            {
             before(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_6_5()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Model__Group_1_6__5__Impl3611); 
             after(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_6_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_6__5__Impl"


    // $ANTLR start "rule__Model__Group_1_7__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1817:1: rule__Model__Group_1_7__0 : rule__Model__Group_1_7__0__Impl rule__Model__Group_1_7__1 ;
    public final void rule__Model__Group_1_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1821:1: ( rule__Model__Group_1_7__0__Impl rule__Model__Group_1_7__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1822:2: rule__Model__Group_1_7__0__Impl rule__Model__Group_1_7__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_7__0__Impl_in_rule__Model__Group_1_7__03654);
            rule__Model__Group_1_7__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_7__1_in_rule__Model__Group_1_7__03657);
            rule__Model__Group_1_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_7__0"


    // $ANTLR start "rule__Model__Group_1_7__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1829:1: rule__Model__Group_1_7__0__Impl : ( '#4+' ) ;
    public final void rule__Model__Group_1_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1833:1: ( ( '#4+' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1834:1: ( '#4+' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1834:1: ( '#4+' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1835:1: '#4+'
            {
             before(grammarAccess.getModelAccess().getNumberSignDigitFourPlusSignKeyword_1_7_0()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Model__Group_1_7__0__Impl3685); 
             after(grammarAccess.getModelAccess().getNumberSignDigitFourPlusSignKeyword_1_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_7__0__Impl"


    // $ANTLR start "rule__Model__Group_1_7__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1848:1: rule__Model__Group_1_7__1 : rule__Model__Group_1_7__1__Impl rule__Model__Group_1_7__2 ;
    public final void rule__Model__Group_1_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1852:1: ( rule__Model__Group_1_7__1__Impl rule__Model__Group_1_7__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1853:2: rule__Model__Group_1_7__1__Impl rule__Model__Group_1_7__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_7__1__Impl_in_rule__Model__Group_1_7__13716);
            rule__Model__Group_1_7__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_7__2_in_rule__Model__Group_1_7__13719);
            rule__Model__Group_1_7__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_7__1"


    // $ANTLR start "rule__Model__Group_1_7__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1860:1: rule__Model__Group_1_7__1__Impl : ( ( rule__Model__NameAssignment_1_7_1 ) ) ;
    public final void rule__Model__Group_1_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1864:1: ( ( ( rule__Model__NameAssignment_1_7_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1865:1: ( ( rule__Model__NameAssignment_1_7_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1865:1: ( ( rule__Model__NameAssignment_1_7_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1866:1: ( rule__Model__NameAssignment_1_7_1 )
            {
             before(grammarAccess.getModelAccess().getNameAssignment_1_7_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1867:1: ( rule__Model__NameAssignment_1_7_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1867:2: rule__Model__NameAssignment_1_7_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__NameAssignment_1_7_1_in_rule__Model__Group_1_7__1__Impl3746);
            rule__Model__NameAssignment_1_7_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getNameAssignment_1_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_7__1__Impl"


    // $ANTLR start "rule__Model__Group_1_7__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1877:1: rule__Model__Group_1_7__2 : rule__Model__Group_1_7__2__Impl rule__Model__Group_1_7__3 ;
    public final void rule__Model__Group_1_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1881:1: ( rule__Model__Group_1_7__2__Impl rule__Model__Group_1_7__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1882:2: rule__Model__Group_1_7__2__Impl rule__Model__Group_1_7__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_7__2__Impl_in_rule__Model__Group_1_7__23776);
            rule__Model__Group_1_7__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_7__3_in_rule__Model__Group_1_7__23779);
            rule__Model__Group_1_7__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_7__2"


    // $ANTLR start "rule__Model__Group_1_7__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1889:1: rule__Model__Group_1_7__2__Impl : ( '{' ) ;
    public final void rule__Model__Group_1_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1893:1: ( ( '{' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1894:1: ( '{' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1894:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1895:1: '{'
            {
             before(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_7_2()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Model__Group_1_7__2__Impl3807); 
             after(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_7_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_7__2__Impl"


    // $ANTLR start "rule__Model__Group_1_7__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1908:1: rule__Model__Group_1_7__3 : rule__Model__Group_1_7__3__Impl rule__Model__Group_1_7__4 ;
    public final void rule__Model__Group_1_7__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1912:1: ( rule__Model__Group_1_7__3__Impl rule__Model__Group_1_7__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1913:2: rule__Model__Group_1_7__3__Impl rule__Model__Group_1_7__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_7__3__Impl_in_rule__Model__Group_1_7__33838);
            rule__Model__Group_1_7__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_7__4_in_rule__Model__Group_1_7__33841);
            rule__Model__Group_1_7__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_7__3"


    // $ANTLR start "rule__Model__Group_1_7__3__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1920:1: rule__Model__Group_1_7__3__Impl : ( ( ( rule__Model__ErrorsAssignment_1_7_3 ) ) ( ( rule__Model__ErrorsAssignment_1_7_3 )* ) ) ;
    public final void rule__Model__Group_1_7__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1924:1: ( ( ( ( rule__Model__ErrorsAssignment_1_7_3 ) ) ( ( rule__Model__ErrorsAssignment_1_7_3 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1925:1: ( ( ( rule__Model__ErrorsAssignment_1_7_3 ) ) ( ( rule__Model__ErrorsAssignment_1_7_3 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1925:1: ( ( ( rule__Model__ErrorsAssignment_1_7_3 ) ) ( ( rule__Model__ErrorsAssignment_1_7_3 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1926:1: ( ( rule__Model__ErrorsAssignment_1_7_3 ) ) ( ( rule__Model__ErrorsAssignment_1_7_3 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1926:1: ( ( rule__Model__ErrorsAssignment_1_7_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1927:1: ( rule__Model__ErrorsAssignment_1_7_3 )
            {
             before(grammarAccess.getModelAccess().getErrorsAssignment_1_7_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1928:1: ( rule__Model__ErrorsAssignment_1_7_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1928:2: rule__Model__ErrorsAssignment_1_7_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__ErrorsAssignment_1_7_3_in_rule__Model__Group_1_7__3__Impl3870);
            rule__Model__ErrorsAssignment_1_7_3();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getErrorsAssignment_1_7_3()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1931:1: ( ( rule__Model__ErrorsAssignment_1_7_3 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1932:1: ( rule__Model__ErrorsAssignment_1_7_3 )*
            {
             before(grammarAccess.getModelAccess().getErrorsAssignment_1_7_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1933:1: ( rule__Model__ErrorsAssignment_1_7_3 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==25) ) {
                    int LA16_1 = input.LA(2);

                    if ( (LA16_1==RULE_ID) ) {
                        int LA16_2 = input.LA(3);

                        if ( (LA16_2==23) ) {
                            alt16=1;
                        }


                    }


                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1933:2: rule__Model__ErrorsAssignment_1_7_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__ErrorsAssignment_1_7_3_in_rule__Model__Group_1_7__3__Impl3882);
            	    rule__Model__ErrorsAssignment_1_7_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getErrorsAssignment_1_7_3()); 

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
    // $ANTLR end "rule__Model__Group_1_7__3__Impl"


    // $ANTLR start "rule__Model__Group_1_7__4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1944:1: rule__Model__Group_1_7__4 : rule__Model__Group_1_7__4__Impl rule__Model__Group_1_7__5 ;
    public final void rule__Model__Group_1_7__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1948:1: ( rule__Model__Group_1_7__4__Impl rule__Model__Group_1_7__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1949:2: rule__Model__Group_1_7__4__Impl rule__Model__Group_1_7__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_7__4__Impl_in_rule__Model__Group_1_7__43915);
            rule__Model__Group_1_7__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_7__5_in_rule__Model__Group_1_7__43918);
            rule__Model__Group_1_7__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_7__4"


    // $ANTLR start "rule__Model__Group_1_7__4__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1956:1: rule__Model__Group_1_7__4__Impl : ( ( ( rule__Model__OperationsAssignment_1_7_4 ) ) ( ( rule__Model__OperationsAssignment_1_7_4 )* ) ) ;
    public final void rule__Model__Group_1_7__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1960:1: ( ( ( ( rule__Model__OperationsAssignment_1_7_4 ) ) ( ( rule__Model__OperationsAssignment_1_7_4 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1961:1: ( ( ( rule__Model__OperationsAssignment_1_7_4 ) ) ( ( rule__Model__OperationsAssignment_1_7_4 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1961:1: ( ( ( rule__Model__OperationsAssignment_1_7_4 ) ) ( ( rule__Model__OperationsAssignment_1_7_4 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1962:1: ( ( rule__Model__OperationsAssignment_1_7_4 ) ) ( ( rule__Model__OperationsAssignment_1_7_4 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1962:1: ( ( rule__Model__OperationsAssignment_1_7_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1963:1: ( rule__Model__OperationsAssignment_1_7_4 )
            {
             before(grammarAccess.getModelAccess().getOperationsAssignment_1_7_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1964:1: ( rule__Model__OperationsAssignment_1_7_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1964:2: rule__Model__OperationsAssignment_1_7_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__OperationsAssignment_1_7_4_in_rule__Model__Group_1_7__4__Impl3947);
            rule__Model__OperationsAssignment_1_7_4();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getOperationsAssignment_1_7_4()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1967:1: ( ( rule__Model__OperationsAssignment_1_7_4 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1968:1: ( rule__Model__OperationsAssignment_1_7_4 )*
            {
             before(grammarAccess.getModelAccess().getOperationsAssignment_1_7_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1969:1: ( rule__Model__OperationsAssignment_1_7_4 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==25) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1969:2: rule__Model__OperationsAssignment_1_7_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__OperationsAssignment_1_7_4_in_rule__Model__Group_1_7__4__Impl3959);
            	    rule__Model__OperationsAssignment_1_7_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getOperationsAssignment_1_7_4()); 

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
    // $ANTLR end "rule__Model__Group_1_7__4__Impl"


    // $ANTLR start "rule__Model__Group_1_7__5"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1980:1: rule__Model__Group_1_7__5 : rule__Model__Group_1_7__5__Impl ;
    public final void rule__Model__Group_1_7__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1984:1: ( rule__Model__Group_1_7__5__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1985:2: rule__Model__Group_1_7__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_7__5__Impl_in_rule__Model__Group_1_7__53992);
            rule__Model__Group_1_7__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_7__5"


    // $ANTLR start "rule__Model__Group_1_7__5__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1991:1: rule__Model__Group_1_7__5__Impl : ( '}' ) ;
    public final void rule__Model__Group_1_7__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1995:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1996:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1996:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:1997:1: '}'
            {
             before(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_7_5()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Model__Group_1_7__5__Impl4020); 
             after(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_7_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_7__5__Impl"


    // $ANTLR start "rule__Model__Group_1_8__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2022:1: rule__Model__Group_1_8__0 : rule__Model__Group_1_8__0__Impl rule__Model__Group_1_8__1 ;
    public final void rule__Model__Group_1_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2026:1: ( rule__Model__Group_1_8__0__Impl rule__Model__Group_1_8__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2027:2: rule__Model__Group_1_8__0__Impl rule__Model__Group_1_8__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_8__0__Impl_in_rule__Model__Group_1_8__04063);
            rule__Model__Group_1_8__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_8__1_in_rule__Model__Group_1_8__04066);
            rule__Model__Group_1_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_8__0"


    // $ANTLR start "rule__Model__Group_1_8__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2034:1: rule__Model__Group_1_8__0__Impl : ( '#5*' ) ;
    public final void rule__Model__Group_1_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2038:1: ( ( '#5*' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2039:1: ( '#5*' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2039:1: ( '#5*' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2040:1: '#5*'
            {
             before(grammarAccess.getModelAccess().getNumberSignDigitFiveAsteriskKeyword_1_8_0()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__Model__Group_1_8__0__Impl4094); 
             after(grammarAccess.getModelAccess().getNumberSignDigitFiveAsteriskKeyword_1_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_8__0__Impl"


    // $ANTLR start "rule__Model__Group_1_8__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2053:1: rule__Model__Group_1_8__1 : rule__Model__Group_1_8__1__Impl rule__Model__Group_1_8__2 ;
    public final void rule__Model__Group_1_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2057:1: ( rule__Model__Group_1_8__1__Impl rule__Model__Group_1_8__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2058:2: rule__Model__Group_1_8__1__Impl rule__Model__Group_1_8__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_8__1__Impl_in_rule__Model__Group_1_8__14125);
            rule__Model__Group_1_8__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_8__2_in_rule__Model__Group_1_8__14128);
            rule__Model__Group_1_8__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_8__1"


    // $ANTLR start "rule__Model__Group_1_8__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2065:1: rule__Model__Group_1_8__1__Impl : ( ( rule__Model__NameAssignment_1_8_1 ) ) ;
    public final void rule__Model__Group_1_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2069:1: ( ( ( rule__Model__NameAssignment_1_8_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2070:1: ( ( rule__Model__NameAssignment_1_8_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2070:1: ( ( rule__Model__NameAssignment_1_8_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2071:1: ( rule__Model__NameAssignment_1_8_1 )
            {
             before(grammarAccess.getModelAccess().getNameAssignment_1_8_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2072:1: ( rule__Model__NameAssignment_1_8_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2072:2: rule__Model__NameAssignment_1_8_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__NameAssignment_1_8_1_in_rule__Model__Group_1_8__1__Impl4155);
            rule__Model__NameAssignment_1_8_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getNameAssignment_1_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_8__1__Impl"


    // $ANTLR start "rule__Model__Group_1_8__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2082:1: rule__Model__Group_1_8__2 : rule__Model__Group_1_8__2__Impl rule__Model__Group_1_8__3 ;
    public final void rule__Model__Group_1_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2086:1: ( rule__Model__Group_1_8__2__Impl rule__Model__Group_1_8__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2087:2: rule__Model__Group_1_8__2__Impl rule__Model__Group_1_8__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_8__2__Impl_in_rule__Model__Group_1_8__24185);
            rule__Model__Group_1_8__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_8__3_in_rule__Model__Group_1_8__24188);
            rule__Model__Group_1_8__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_8__2"


    // $ANTLR start "rule__Model__Group_1_8__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2094:1: rule__Model__Group_1_8__2__Impl : ( '{' ) ;
    public final void rule__Model__Group_1_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2098:1: ( ( '{' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2099:1: ( '{' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2099:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2100:1: '{'
            {
             before(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_8_2()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Model__Group_1_8__2__Impl4216); 
             after(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_8_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_8__2__Impl"


    // $ANTLR start "rule__Model__Group_1_8__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2113:1: rule__Model__Group_1_8__3 : rule__Model__Group_1_8__3__Impl rule__Model__Group_1_8__4 ;
    public final void rule__Model__Group_1_8__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2117:1: ( rule__Model__Group_1_8__3__Impl rule__Model__Group_1_8__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2118:2: rule__Model__Group_1_8__3__Impl rule__Model__Group_1_8__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_8__3__Impl_in_rule__Model__Group_1_8__34247);
            rule__Model__Group_1_8__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_8__4_in_rule__Model__Group_1_8__34250);
            rule__Model__Group_1_8__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_8__3"


    // $ANTLR start "rule__Model__Group_1_8__3__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2125:1: rule__Model__Group_1_8__3__Impl : ( ( rule__Model__ErrorsAssignment_1_8_3 )* ) ;
    public final void rule__Model__Group_1_8__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2129:1: ( ( ( rule__Model__ErrorsAssignment_1_8_3 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2130:1: ( ( rule__Model__ErrorsAssignment_1_8_3 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2130:1: ( ( rule__Model__ErrorsAssignment_1_8_3 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2131:1: ( rule__Model__ErrorsAssignment_1_8_3 )*
            {
             before(grammarAccess.getModelAccess().getErrorsAssignment_1_8_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2132:1: ( rule__Model__ErrorsAssignment_1_8_3 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==23) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2132:2: rule__Model__ErrorsAssignment_1_8_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__ErrorsAssignment_1_8_3_in_rule__Model__Group_1_8__3__Impl4277);
            	    rule__Model__ErrorsAssignment_1_8_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getErrorsAssignment_1_8_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_8__3__Impl"


    // $ANTLR start "rule__Model__Group_1_8__4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2142:1: rule__Model__Group_1_8__4 : rule__Model__Group_1_8__4__Impl rule__Model__Group_1_8__5 ;
    public final void rule__Model__Group_1_8__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2146:1: ( rule__Model__Group_1_8__4__Impl rule__Model__Group_1_8__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2147:2: rule__Model__Group_1_8__4__Impl rule__Model__Group_1_8__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_8__4__Impl_in_rule__Model__Group_1_8__44308);
            rule__Model__Group_1_8__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_8__5_in_rule__Model__Group_1_8__44311);
            rule__Model__Group_1_8__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_8__4"


    // $ANTLR start "rule__Model__Group_1_8__4__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2154:1: rule__Model__Group_1_8__4__Impl : ( ( rule__Model__OperationsAssignment_1_8_4 )* ) ;
    public final void rule__Model__Group_1_8__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2158:1: ( ( ( rule__Model__OperationsAssignment_1_8_4 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2159:1: ( ( rule__Model__OperationsAssignment_1_8_4 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2159:1: ( ( rule__Model__OperationsAssignment_1_8_4 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2160:1: ( rule__Model__OperationsAssignment_1_8_4 )*
            {
             before(grammarAccess.getModelAccess().getOperationsAssignment_1_8_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2161:1: ( rule__Model__OperationsAssignment_1_8_4 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==24) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2161:2: rule__Model__OperationsAssignment_1_8_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__OperationsAssignment_1_8_4_in_rule__Model__Group_1_8__4__Impl4338);
            	    rule__Model__OperationsAssignment_1_8_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getOperationsAssignment_1_8_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_8__4__Impl"


    // $ANTLR start "rule__Model__Group_1_8__5"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2171:1: rule__Model__Group_1_8__5 : rule__Model__Group_1_8__5__Impl ;
    public final void rule__Model__Group_1_8__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2175:1: ( rule__Model__Group_1_8__5__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2176:2: rule__Model__Group_1_8__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_8__5__Impl_in_rule__Model__Group_1_8__54369);
            rule__Model__Group_1_8__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_8__5"


    // $ANTLR start "rule__Model__Group_1_8__5__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2182:1: rule__Model__Group_1_8__5__Impl : ( '}' ) ;
    public final void rule__Model__Group_1_8__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2186:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2187:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2187:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2188:1: '}'
            {
             before(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_8_5()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Model__Group_1_8__5__Impl4397); 
             after(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_8_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_8__5__Impl"


    // $ANTLR start "rule__Model__Group_1_9__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2213:1: rule__Model__Group_1_9__0 : rule__Model__Group_1_9__0__Impl rule__Model__Group_1_9__1 ;
    public final void rule__Model__Group_1_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2217:1: ( rule__Model__Group_1_9__0__Impl rule__Model__Group_1_9__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2218:2: rule__Model__Group_1_9__0__Impl rule__Model__Group_1_9__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_9__0__Impl_in_rule__Model__Group_1_9__04440);
            rule__Model__Group_1_9__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_9__1_in_rule__Model__Group_1_9__04443);
            rule__Model__Group_1_9__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_9__0"


    // $ANTLR start "rule__Model__Group_1_9__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2225:1: rule__Model__Group_1_9__0__Impl : ( '#5+' ) ;
    public final void rule__Model__Group_1_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2229:1: ( ( '#5+' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2230:1: ( '#5+' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2230:1: ( '#5+' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2231:1: '#5+'
            {
             before(grammarAccess.getModelAccess().getNumberSignDigitFivePlusSignKeyword_1_9_0()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__Model__Group_1_9__0__Impl4471); 
             after(grammarAccess.getModelAccess().getNumberSignDigitFivePlusSignKeyword_1_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_9__0__Impl"


    // $ANTLR start "rule__Model__Group_1_9__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2244:1: rule__Model__Group_1_9__1 : rule__Model__Group_1_9__1__Impl rule__Model__Group_1_9__2 ;
    public final void rule__Model__Group_1_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2248:1: ( rule__Model__Group_1_9__1__Impl rule__Model__Group_1_9__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2249:2: rule__Model__Group_1_9__1__Impl rule__Model__Group_1_9__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_9__1__Impl_in_rule__Model__Group_1_9__14502);
            rule__Model__Group_1_9__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_9__2_in_rule__Model__Group_1_9__14505);
            rule__Model__Group_1_9__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_9__1"


    // $ANTLR start "rule__Model__Group_1_9__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2256:1: rule__Model__Group_1_9__1__Impl : ( ( rule__Model__NameAssignment_1_9_1 ) ) ;
    public final void rule__Model__Group_1_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2260:1: ( ( ( rule__Model__NameAssignment_1_9_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2261:1: ( ( rule__Model__NameAssignment_1_9_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2261:1: ( ( rule__Model__NameAssignment_1_9_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2262:1: ( rule__Model__NameAssignment_1_9_1 )
            {
             before(grammarAccess.getModelAccess().getNameAssignment_1_9_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2263:1: ( rule__Model__NameAssignment_1_9_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2263:2: rule__Model__NameAssignment_1_9_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__NameAssignment_1_9_1_in_rule__Model__Group_1_9__1__Impl4532);
            rule__Model__NameAssignment_1_9_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getNameAssignment_1_9_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_9__1__Impl"


    // $ANTLR start "rule__Model__Group_1_9__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2273:1: rule__Model__Group_1_9__2 : rule__Model__Group_1_9__2__Impl rule__Model__Group_1_9__3 ;
    public final void rule__Model__Group_1_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2277:1: ( rule__Model__Group_1_9__2__Impl rule__Model__Group_1_9__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2278:2: rule__Model__Group_1_9__2__Impl rule__Model__Group_1_9__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_9__2__Impl_in_rule__Model__Group_1_9__24562);
            rule__Model__Group_1_9__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_9__3_in_rule__Model__Group_1_9__24565);
            rule__Model__Group_1_9__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_9__2"


    // $ANTLR start "rule__Model__Group_1_9__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2285:1: rule__Model__Group_1_9__2__Impl : ( '{' ) ;
    public final void rule__Model__Group_1_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2289:1: ( ( '{' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2290:1: ( '{' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2290:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2291:1: '{'
            {
             before(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_9_2()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Model__Group_1_9__2__Impl4593); 
             after(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_9_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_9__2__Impl"


    // $ANTLR start "rule__Model__Group_1_9__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2304:1: rule__Model__Group_1_9__3 : rule__Model__Group_1_9__3__Impl rule__Model__Group_1_9__4 ;
    public final void rule__Model__Group_1_9__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2308:1: ( rule__Model__Group_1_9__3__Impl rule__Model__Group_1_9__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2309:2: rule__Model__Group_1_9__3__Impl rule__Model__Group_1_9__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_9__3__Impl_in_rule__Model__Group_1_9__34624);
            rule__Model__Group_1_9__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_9__4_in_rule__Model__Group_1_9__34627);
            rule__Model__Group_1_9__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_9__3"


    // $ANTLR start "rule__Model__Group_1_9__3__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2316:1: rule__Model__Group_1_9__3__Impl : ( ( ( rule__Model__ErrorsAssignment_1_9_3 ) ) ( ( rule__Model__ErrorsAssignment_1_9_3 )* ) ) ;
    public final void rule__Model__Group_1_9__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2320:1: ( ( ( ( rule__Model__ErrorsAssignment_1_9_3 ) ) ( ( rule__Model__ErrorsAssignment_1_9_3 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2321:1: ( ( ( rule__Model__ErrorsAssignment_1_9_3 ) ) ( ( rule__Model__ErrorsAssignment_1_9_3 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2321:1: ( ( ( rule__Model__ErrorsAssignment_1_9_3 ) ) ( ( rule__Model__ErrorsAssignment_1_9_3 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2322:1: ( ( rule__Model__ErrorsAssignment_1_9_3 ) ) ( ( rule__Model__ErrorsAssignment_1_9_3 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2322:1: ( ( rule__Model__ErrorsAssignment_1_9_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2323:1: ( rule__Model__ErrorsAssignment_1_9_3 )
            {
             before(grammarAccess.getModelAccess().getErrorsAssignment_1_9_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2324:1: ( rule__Model__ErrorsAssignment_1_9_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2324:2: rule__Model__ErrorsAssignment_1_9_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__ErrorsAssignment_1_9_3_in_rule__Model__Group_1_9__3__Impl4656);
            rule__Model__ErrorsAssignment_1_9_3();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getErrorsAssignment_1_9_3()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2327:1: ( ( rule__Model__ErrorsAssignment_1_9_3 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2328:1: ( rule__Model__ErrorsAssignment_1_9_3 )*
            {
             before(grammarAccess.getModelAccess().getErrorsAssignment_1_9_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2329:1: ( rule__Model__ErrorsAssignment_1_9_3 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==23) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2329:2: rule__Model__ErrorsAssignment_1_9_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__ErrorsAssignment_1_9_3_in_rule__Model__Group_1_9__3__Impl4668);
            	    rule__Model__ErrorsAssignment_1_9_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getErrorsAssignment_1_9_3()); 

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
    // $ANTLR end "rule__Model__Group_1_9__3__Impl"


    // $ANTLR start "rule__Model__Group_1_9__4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2340:1: rule__Model__Group_1_9__4 : rule__Model__Group_1_9__4__Impl rule__Model__Group_1_9__5 ;
    public final void rule__Model__Group_1_9__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2344:1: ( rule__Model__Group_1_9__4__Impl rule__Model__Group_1_9__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2345:2: rule__Model__Group_1_9__4__Impl rule__Model__Group_1_9__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_9__4__Impl_in_rule__Model__Group_1_9__44701);
            rule__Model__Group_1_9__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_9__5_in_rule__Model__Group_1_9__44704);
            rule__Model__Group_1_9__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_9__4"


    // $ANTLR start "rule__Model__Group_1_9__4__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2352:1: rule__Model__Group_1_9__4__Impl : ( ( ( rule__Model__OperationsAssignment_1_9_4 ) ) ( ( rule__Model__OperationsAssignment_1_9_4 )* ) ) ;
    public final void rule__Model__Group_1_9__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2356:1: ( ( ( ( rule__Model__OperationsAssignment_1_9_4 ) ) ( ( rule__Model__OperationsAssignment_1_9_4 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2357:1: ( ( ( rule__Model__OperationsAssignment_1_9_4 ) ) ( ( rule__Model__OperationsAssignment_1_9_4 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2357:1: ( ( ( rule__Model__OperationsAssignment_1_9_4 ) ) ( ( rule__Model__OperationsAssignment_1_9_4 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2358:1: ( ( rule__Model__OperationsAssignment_1_9_4 ) ) ( ( rule__Model__OperationsAssignment_1_9_4 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2358:1: ( ( rule__Model__OperationsAssignment_1_9_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2359:1: ( rule__Model__OperationsAssignment_1_9_4 )
            {
             before(grammarAccess.getModelAccess().getOperationsAssignment_1_9_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2360:1: ( rule__Model__OperationsAssignment_1_9_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2360:2: rule__Model__OperationsAssignment_1_9_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__OperationsAssignment_1_9_4_in_rule__Model__Group_1_9__4__Impl4733);
            rule__Model__OperationsAssignment_1_9_4();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getOperationsAssignment_1_9_4()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2363:1: ( ( rule__Model__OperationsAssignment_1_9_4 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2364:1: ( rule__Model__OperationsAssignment_1_9_4 )*
            {
             before(grammarAccess.getModelAccess().getOperationsAssignment_1_9_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2365:1: ( rule__Model__OperationsAssignment_1_9_4 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==24) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2365:2: rule__Model__OperationsAssignment_1_9_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__OperationsAssignment_1_9_4_in_rule__Model__Group_1_9__4__Impl4745);
            	    rule__Model__OperationsAssignment_1_9_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getOperationsAssignment_1_9_4()); 

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
    // $ANTLR end "rule__Model__Group_1_9__4__Impl"


    // $ANTLR start "rule__Model__Group_1_9__5"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2376:1: rule__Model__Group_1_9__5 : rule__Model__Group_1_9__5__Impl ;
    public final void rule__Model__Group_1_9__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2380:1: ( rule__Model__Group_1_9__5__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2381:2: rule__Model__Group_1_9__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1_9__5__Impl_in_rule__Model__Group_1_9__54778);
            rule__Model__Group_1_9__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_9__5"


    // $ANTLR start "rule__Model__Group_1_9__5__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2387:1: rule__Model__Group_1_9__5__Impl : ( '}' ) ;
    public final void rule__Model__Group_1_9__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2391:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2392:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2392:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2393:1: '}'
            {
             before(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_9_5()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Model__Group_1_9__5__Impl4806); 
             after(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_9_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1_9__5__Impl"


    // $ANTLR start "rule__Error_1__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2418:1: rule__Error_1__Group__0 : rule__Error_1__Group__0__Impl rule__Error_1__Group__1 ;
    public final void rule__Error_1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2422:1: ( rule__Error_1__Group__0__Impl rule__Error_1__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2423:2: rule__Error_1__Group__0__Impl rule__Error_1__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Error_1__Group__0__Impl_in_rule__Error_1__Group__04849);
            rule__Error_1__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Error_1__Group__1_in_rule__Error_1__Group__04852);
            rule__Error_1__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Error_1__Group__0"


    // $ANTLR start "rule__Error_1__Group__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2430:1: rule__Error_1__Group__0__Impl : ( ( rule__Error_1__AnnotationsAssignment_0 )* ) ;
    public final void rule__Error_1__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2434:1: ( ( ( rule__Error_1__AnnotationsAssignment_0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2435:1: ( ( rule__Error_1__AnnotationsAssignment_0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2435:1: ( ( rule__Error_1__AnnotationsAssignment_0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2436:1: ( rule__Error_1__AnnotationsAssignment_0 )*
            {
             before(grammarAccess.getError_1Access().getAnnotationsAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2437:1: ( rule__Error_1__AnnotationsAssignment_0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==25) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2437:2: rule__Error_1__AnnotationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Error_1__AnnotationsAssignment_0_in_rule__Error_1__Group__0__Impl4879);
            	    rule__Error_1__AnnotationsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getError_1Access().getAnnotationsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Error_1__Group__0__Impl"


    // $ANTLR start "rule__Error_1__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2447:1: rule__Error_1__Group__1 : rule__Error_1__Group__1__Impl rule__Error_1__Group__2 ;
    public final void rule__Error_1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2451:1: ( rule__Error_1__Group__1__Impl rule__Error_1__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2452:2: rule__Error_1__Group__1__Impl rule__Error_1__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Error_1__Group__1__Impl_in_rule__Error_1__Group__14910);
            rule__Error_1__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Error_1__Group__2_in_rule__Error_1__Group__14913);
            rule__Error_1__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Error_1__Group__1"


    // $ANTLR start "rule__Error_1__Group__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2459:1: rule__Error_1__Group__1__Impl : ( 'error' ) ;
    public final void rule__Error_1__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2463:1: ( ( 'error' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2464:1: ( 'error' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2464:1: ( 'error' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2465:1: 'error'
            {
             before(grammarAccess.getError_1Access().getErrorKeyword_1()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__Error_1__Group__1__Impl4941); 
             after(grammarAccess.getError_1Access().getErrorKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Error_1__Group__1__Impl"


    // $ANTLR start "rule__Error_1__Group__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2478:1: rule__Error_1__Group__2 : rule__Error_1__Group__2__Impl ;
    public final void rule__Error_1__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2482:1: ( rule__Error_1__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2483:2: rule__Error_1__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Error_1__Group__2__Impl_in_rule__Error_1__Group__24972);
            rule__Error_1__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Error_1__Group__2"


    // $ANTLR start "rule__Error_1__Group__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2489:1: rule__Error_1__Group__2__Impl : ( ( rule__Error_1__NameAssignment_2 ) ) ;
    public final void rule__Error_1__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2493:1: ( ( ( rule__Error_1__NameAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2494:1: ( ( rule__Error_1__NameAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2494:1: ( ( rule__Error_1__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2495:1: ( rule__Error_1__NameAssignment_2 )
            {
             before(grammarAccess.getError_1Access().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2496:1: ( rule__Error_1__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2496:2: rule__Error_1__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Error_1__NameAssignment_2_in_rule__Error_1__Group__2__Impl4999);
            rule__Error_1__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getError_1Access().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Error_1__Group__2__Impl"


    // $ANTLR start "rule__Operation_1__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2512:1: rule__Operation_1__Group__0 : rule__Operation_1__Group__0__Impl rule__Operation_1__Group__1 ;
    public final void rule__Operation_1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2516:1: ( rule__Operation_1__Group__0__Impl rule__Operation_1__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2517:2: rule__Operation_1__Group__0__Impl rule__Operation_1__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation_1__Group__0__Impl_in_rule__Operation_1__Group__05035);
            rule__Operation_1__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Operation_1__Group__1_in_rule__Operation_1__Group__05038);
            rule__Operation_1__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation_1__Group__0"


    // $ANTLR start "rule__Operation_1__Group__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2524:1: rule__Operation_1__Group__0__Impl : ( ( rule__Operation_1__AnnotationsAssignment_0 )* ) ;
    public final void rule__Operation_1__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2528:1: ( ( ( rule__Operation_1__AnnotationsAssignment_0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2529:1: ( ( rule__Operation_1__AnnotationsAssignment_0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2529:1: ( ( rule__Operation_1__AnnotationsAssignment_0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2530:1: ( rule__Operation_1__AnnotationsAssignment_0 )*
            {
             before(grammarAccess.getOperation_1Access().getAnnotationsAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2531:1: ( rule__Operation_1__AnnotationsAssignment_0 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==25) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2531:2: rule__Operation_1__AnnotationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Operation_1__AnnotationsAssignment_0_in_rule__Operation_1__Group__0__Impl5065);
            	    rule__Operation_1__AnnotationsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getOperation_1Access().getAnnotationsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation_1__Group__0__Impl"


    // $ANTLR start "rule__Operation_1__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2541:1: rule__Operation_1__Group__1 : rule__Operation_1__Group__1__Impl rule__Operation_1__Group__2 ;
    public final void rule__Operation_1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2545:1: ( rule__Operation_1__Group__1__Impl rule__Operation_1__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2546:2: rule__Operation_1__Group__1__Impl rule__Operation_1__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation_1__Group__1__Impl_in_rule__Operation_1__Group__15096);
            rule__Operation_1__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Operation_1__Group__2_in_rule__Operation_1__Group__15099);
            rule__Operation_1__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation_1__Group__1"


    // $ANTLR start "rule__Operation_1__Group__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2553:1: rule__Operation_1__Group__1__Impl : ( 'operation' ) ;
    public final void rule__Operation_1__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2557:1: ( ( 'operation' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2558:1: ( 'operation' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2558:1: ( 'operation' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2559:1: 'operation'
            {
             before(grammarAccess.getOperation_1Access().getOperationKeyword_1()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__Operation_1__Group__1__Impl5127); 
             after(grammarAccess.getOperation_1Access().getOperationKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation_1__Group__1__Impl"


    // $ANTLR start "rule__Operation_1__Group__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2572:1: rule__Operation_1__Group__2 : rule__Operation_1__Group__2__Impl ;
    public final void rule__Operation_1__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2576:1: ( rule__Operation_1__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2577:2: rule__Operation_1__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation_1__Group__2__Impl_in_rule__Operation_1__Group__25158);
            rule__Operation_1__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation_1__Group__2"


    // $ANTLR start "rule__Operation_1__Group__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2583:1: rule__Operation_1__Group__2__Impl : ( ( rule__Operation_1__NameAssignment_2 ) ) ;
    public final void rule__Operation_1__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2587:1: ( ( ( rule__Operation_1__NameAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2588:1: ( ( rule__Operation_1__NameAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2588:1: ( ( rule__Operation_1__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2589:1: ( rule__Operation_1__NameAssignment_2 )
            {
             before(grammarAccess.getOperation_1Access().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2590:1: ( rule__Operation_1__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2590:2: rule__Operation_1__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation_1__NameAssignment_2_in_rule__Operation_1__Group__2__Impl5185);
            rule__Operation_1__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getOperation_1Access().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation_1__Group__2__Impl"


    // $ANTLR start "rule__Error_2__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2606:1: rule__Error_2__Group__0 : rule__Error_2__Group__0__Impl rule__Error_2__Group__1 ;
    public final void rule__Error_2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2610:1: ( rule__Error_2__Group__0__Impl rule__Error_2__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2611:2: rule__Error_2__Group__0__Impl rule__Error_2__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Error_2__Group__0__Impl_in_rule__Error_2__Group__05221);
            rule__Error_2__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Error_2__Group__1_in_rule__Error_2__Group__05224);
            rule__Error_2__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Error_2__Group__0"


    // $ANTLR start "rule__Error_2__Group__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2618:1: rule__Error_2__Group__0__Impl : ( ( ( rule__Error_2__AnnotationsAssignment_0 ) ) ( ( rule__Error_2__AnnotationsAssignment_0 )* ) ) ;
    public final void rule__Error_2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2622:1: ( ( ( ( rule__Error_2__AnnotationsAssignment_0 ) ) ( ( rule__Error_2__AnnotationsAssignment_0 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2623:1: ( ( ( rule__Error_2__AnnotationsAssignment_0 ) ) ( ( rule__Error_2__AnnotationsAssignment_0 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2623:1: ( ( ( rule__Error_2__AnnotationsAssignment_0 ) ) ( ( rule__Error_2__AnnotationsAssignment_0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2624:1: ( ( rule__Error_2__AnnotationsAssignment_0 ) ) ( ( rule__Error_2__AnnotationsAssignment_0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2624:1: ( ( rule__Error_2__AnnotationsAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2625:1: ( rule__Error_2__AnnotationsAssignment_0 )
            {
             before(grammarAccess.getError_2Access().getAnnotationsAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2626:1: ( rule__Error_2__AnnotationsAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2626:2: rule__Error_2__AnnotationsAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Error_2__AnnotationsAssignment_0_in_rule__Error_2__Group__0__Impl5253);
            rule__Error_2__AnnotationsAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getError_2Access().getAnnotationsAssignment_0()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2629:1: ( ( rule__Error_2__AnnotationsAssignment_0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2630:1: ( rule__Error_2__AnnotationsAssignment_0 )*
            {
             before(grammarAccess.getError_2Access().getAnnotationsAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2631:1: ( rule__Error_2__AnnotationsAssignment_0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==25) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2631:2: rule__Error_2__AnnotationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Error_2__AnnotationsAssignment_0_in_rule__Error_2__Group__0__Impl5265);
            	    rule__Error_2__AnnotationsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

             after(grammarAccess.getError_2Access().getAnnotationsAssignment_0()); 

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
    // $ANTLR end "rule__Error_2__Group__0__Impl"


    // $ANTLR start "rule__Error_2__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2642:1: rule__Error_2__Group__1 : rule__Error_2__Group__1__Impl rule__Error_2__Group__2 ;
    public final void rule__Error_2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2646:1: ( rule__Error_2__Group__1__Impl rule__Error_2__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2647:2: rule__Error_2__Group__1__Impl rule__Error_2__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Error_2__Group__1__Impl_in_rule__Error_2__Group__15298);
            rule__Error_2__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Error_2__Group__2_in_rule__Error_2__Group__15301);
            rule__Error_2__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Error_2__Group__1"


    // $ANTLR start "rule__Error_2__Group__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2654:1: rule__Error_2__Group__1__Impl : ( 'error' ) ;
    public final void rule__Error_2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2658:1: ( ( 'error' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2659:1: ( 'error' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2659:1: ( 'error' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2660:1: 'error'
            {
             before(grammarAccess.getError_2Access().getErrorKeyword_1()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__Error_2__Group__1__Impl5329); 
             after(grammarAccess.getError_2Access().getErrorKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Error_2__Group__1__Impl"


    // $ANTLR start "rule__Error_2__Group__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2673:1: rule__Error_2__Group__2 : rule__Error_2__Group__2__Impl ;
    public final void rule__Error_2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2677:1: ( rule__Error_2__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2678:2: rule__Error_2__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Error_2__Group__2__Impl_in_rule__Error_2__Group__25360);
            rule__Error_2__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Error_2__Group__2"


    // $ANTLR start "rule__Error_2__Group__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2684:1: rule__Error_2__Group__2__Impl : ( ( rule__Error_2__NameAssignment_2 ) ) ;
    public final void rule__Error_2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2688:1: ( ( ( rule__Error_2__NameAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2689:1: ( ( rule__Error_2__NameAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2689:1: ( ( rule__Error_2__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2690:1: ( rule__Error_2__NameAssignment_2 )
            {
             before(grammarAccess.getError_2Access().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2691:1: ( rule__Error_2__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2691:2: rule__Error_2__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Error_2__NameAssignment_2_in_rule__Error_2__Group__2__Impl5387);
            rule__Error_2__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getError_2Access().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Error_2__Group__2__Impl"


    // $ANTLR start "rule__Operation_2__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2707:1: rule__Operation_2__Group__0 : rule__Operation_2__Group__0__Impl rule__Operation_2__Group__1 ;
    public final void rule__Operation_2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2711:1: ( rule__Operation_2__Group__0__Impl rule__Operation_2__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2712:2: rule__Operation_2__Group__0__Impl rule__Operation_2__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation_2__Group__0__Impl_in_rule__Operation_2__Group__05423);
            rule__Operation_2__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Operation_2__Group__1_in_rule__Operation_2__Group__05426);
            rule__Operation_2__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation_2__Group__0"


    // $ANTLR start "rule__Operation_2__Group__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2719:1: rule__Operation_2__Group__0__Impl : ( ( ( rule__Operation_2__AnnotationsAssignment_0 ) ) ( ( rule__Operation_2__AnnotationsAssignment_0 )* ) ) ;
    public final void rule__Operation_2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2723:1: ( ( ( ( rule__Operation_2__AnnotationsAssignment_0 ) ) ( ( rule__Operation_2__AnnotationsAssignment_0 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2724:1: ( ( ( rule__Operation_2__AnnotationsAssignment_0 ) ) ( ( rule__Operation_2__AnnotationsAssignment_0 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2724:1: ( ( ( rule__Operation_2__AnnotationsAssignment_0 ) ) ( ( rule__Operation_2__AnnotationsAssignment_0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2725:1: ( ( rule__Operation_2__AnnotationsAssignment_0 ) ) ( ( rule__Operation_2__AnnotationsAssignment_0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2725:1: ( ( rule__Operation_2__AnnotationsAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2726:1: ( rule__Operation_2__AnnotationsAssignment_0 )
            {
             before(grammarAccess.getOperation_2Access().getAnnotationsAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2727:1: ( rule__Operation_2__AnnotationsAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2727:2: rule__Operation_2__AnnotationsAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation_2__AnnotationsAssignment_0_in_rule__Operation_2__Group__0__Impl5455);
            rule__Operation_2__AnnotationsAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getOperation_2Access().getAnnotationsAssignment_0()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2730:1: ( ( rule__Operation_2__AnnotationsAssignment_0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2731:1: ( rule__Operation_2__AnnotationsAssignment_0 )*
            {
             before(grammarAccess.getOperation_2Access().getAnnotationsAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2732:1: ( rule__Operation_2__AnnotationsAssignment_0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==25) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2732:2: rule__Operation_2__AnnotationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Operation_2__AnnotationsAssignment_0_in_rule__Operation_2__Group__0__Impl5467);
            	    rule__Operation_2__AnnotationsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getOperation_2Access().getAnnotationsAssignment_0()); 

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
    // $ANTLR end "rule__Operation_2__Group__0__Impl"


    // $ANTLR start "rule__Operation_2__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2743:1: rule__Operation_2__Group__1 : rule__Operation_2__Group__1__Impl rule__Operation_2__Group__2 ;
    public final void rule__Operation_2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2747:1: ( rule__Operation_2__Group__1__Impl rule__Operation_2__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2748:2: rule__Operation_2__Group__1__Impl rule__Operation_2__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation_2__Group__1__Impl_in_rule__Operation_2__Group__15500);
            rule__Operation_2__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Operation_2__Group__2_in_rule__Operation_2__Group__15503);
            rule__Operation_2__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation_2__Group__1"


    // $ANTLR start "rule__Operation_2__Group__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2755:1: rule__Operation_2__Group__1__Impl : ( 'operation' ) ;
    public final void rule__Operation_2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2759:1: ( ( 'operation' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2760:1: ( 'operation' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2760:1: ( 'operation' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2761:1: 'operation'
            {
             before(grammarAccess.getOperation_2Access().getOperationKeyword_1()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__Operation_2__Group__1__Impl5531); 
             after(grammarAccess.getOperation_2Access().getOperationKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation_2__Group__1__Impl"


    // $ANTLR start "rule__Operation_2__Group__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2774:1: rule__Operation_2__Group__2 : rule__Operation_2__Group__2__Impl ;
    public final void rule__Operation_2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2778:1: ( rule__Operation_2__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2779:2: rule__Operation_2__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation_2__Group__2__Impl_in_rule__Operation_2__Group__25562);
            rule__Operation_2__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation_2__Group__2"


    // $ANTLR start "rule__Operation_2__Group__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2785:1: rule__Operation_2__Group__2__Impl : ( ( rule__Operation_2__NameAssignment_2 ) ) ;
    public final void rule__Operation_2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2789:1: ( ( ( rule__Operation_2__NameAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2790:1: ( ( rule__Operation_2__NameAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2790:1: ( ( rule__Operation_2__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2791:1: ( rule__Operation_2__NameAssignment_2 )
            {
             before(grammarAccess.getOperation_2Access().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2792:1: ( rule__Operation_2__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2792:2: rule__Operation_2__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation_2__NameAssignment_2_in_rule__Operation_2__Group__2__Impl5589);
            rule__Operation_2__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getOperation_2Access().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation_2__Group__2__Impl"


    // $ANTLR start "rule__Error_3__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2808:1: rule__Error_3__Group__0 : rule__Error_3__Group__0__Impl rule__Error_3__Group__1 ;
    public final void rule__Error_3__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2812:1: ( rule__Error_3__Group__0__Impl rule__Error_3__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2813:2: rule__Error_3__Group__0__Impl rule__Error_3__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Error_3__Group__0__Impl_in_rule__Error_3__Group__05625);
            rule__Error_3__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Error_3__Group__1_in_rule__Error_3__Group__05628);
            rule__Error_3__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Error_3__Group__0"


    // $ANTLR start "rule__Error_3__Group__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2820:1: rule__Error_3__Group__0__Impl : ( ( rule__Error_3__AnnotationsAssignment_0 )? ) ;
    public final void rule__Error_3__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2824:1: ( ( ( rule__Error_3__AnnotationsAssignment_0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2825:1: ( ( rule__Error_3__AnnotationsAssignment_0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2825:1: ( ( rule__Error_3__AnnotationsAssignment_0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2826:1: ( rule__Error_3__AnnotationsAssignment_0 )?
            {
             before(grammarAccess.getError_3Access().getAnnotationsAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2827:1: ( rule__Error_3__AnnotationsAssignment_0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==25) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2827:2: rule__Error_3__AnnotationsAssignment_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Error_3__AnnotationsAssignment_0_in_rule__Error_3__Group__0__Impl5655);
                    rule__Error_3__AnnotationsAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getError_3Access().getAnnotationsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Error_3__Group__0__Impl"


    // $ANTLR start "rule__Error_3__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2837:1: rule__Error_3__Group__1 : rule__Error_3__Group__1__Impl rule__Error_3__Group__2 ;
    public final void rule__Error_3__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2841:1: ( rule__Error_3__Group__1__Impl rule__Error_3__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2842:2: rule__Error_3__Group__1__Impl rule__Error_3__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Error_3__Group__1__Impl_in_rule__Error_3__Group__15686);
            rule__Error_3__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Error_3__Group__2_in_rule__Error_3__Group__15689);
            rule__Error_3__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Error_3__Group__1"


    // $ANTLR start "rule__Error_3__Group__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2849:1: rule__Error_3__Group__1__Impl : ( 'error' ) ;
    public final void rule__Error_3__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2853:1: ( ( 'error' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2854:1: ( 'error' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2854:1: ( 'error' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2855:1: 'error'
            {
             before(grammarAccess.getError_3Access().getErrorKeyword_1()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__Error_3__Group__1__Impl5717); 
             after(grammarAccess.getError_3Access().getErrorKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Error_3__Group__1__Impl"


    // $ANTLR start "rule__Error_3__Group__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2868:1: rule__Error_3__Group__2 : rule__Error_3__Group__2__Impl ;
    public final void rule__Error_3__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2872:1: ( rule__Error_3__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2873:2: rule__Error_3__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Error_3__Group__2__Impl_in_rule__Error_3__Group__25748);
            rule__Error_3__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Error_3__Group__2"


    // $ANTLR start "rule__Error_3__Group__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2879:1: rule__Error_3__Group__2__Impl : ( ( rule__Error_3__NameAssignment_2 ) ) ;
    public final void rule__Error_3__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2883:1: ( ( ( rule__Error_3__NameAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2884:1: ( ( rule__Error_3__NameAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2884:1: ( ( rule__Error_3__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2885:1: ( rule__Error_3__NameAssignment_2 )
            {
             before(grammarAccess.getError_3Access().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2886:1: ( rule__Error_3__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2886:2: rule__Error_3__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Error_3__NameAssignment_2_in_rule__Error_3__Group__2__Impl5775);
            rule__Error_3__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getError_3Access().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Error_3__Group__2__Impl"


    // $ANTLR start "rule__Operation_3__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2902:1: rule__Operation_3__Group__0 : rule__Operation_3__Group__0__Impl rule__Operation_3__Group__1 ;
    public final void rule__Operation_3__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2906:1: ( rule__Operation_3__Group__0__Impl rule__Operation_3__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2907:2: rule__Operation_3__Group__0__Impl rule__Operation_3__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation_3__Group__0__Impl_in_rule__Operation_3__Group__05811);
            rule__Operation_3__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Operation_3__Group__1_in_rule__Operation_3__Group__05814);
            rule__Operation_3__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation_3__Group__0"


    // $ANTLR start "rule__Operation_3__Group__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2914:1: rule__Operation_3__Group__0__Impl : ( ( rule__Operation_3__AnnotationsAssignment_0 )? ) ;
    public final void rule__Operation_3__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2918:1: ( ( ( rule__Operation_3__AnnotationsAssignment_0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2919:1: ( ( rule__Operation_3__AnnotationsAssignment_0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2919:1: ( ( rule__Operation_3__AnnotationsAssignment_0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2920:1: ( rule__Operation_3__AnnotationsAssignment_0 )?
            {
             before(grammarAccess.getOperation_3Access().getAnnotationsAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2921:1: ( rule__Operation_3__AnnotationsAssignment_0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==25) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2921:2: rule__Operation_3__AnnotationsAssignment_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Operation_3__AnnotationsAssignment_0_in_rule__Operation_3__Group__0__Impl5841);
                    rule__Operation_3__AnnotationsAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getOperation_3Access().getAnnotationsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation_3__Group__0__Impl"


    // $ANTLR start "rule__Operation_3__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2931:1: rule__Operation_3__Group__1 : rule__Operation_3__Group__1__Impl rule__Operation_3__Group__2 ;
    public final void rule__Operation_3__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2935:1: ( rule__Operation_3__Group__1__Impl rule__Operation_3__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2936:2: rule__Operation_3__Group__1__Impl rule__Operation_3__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation_3__Group__1__Impl_in_rule__Operation_3__Group__15872);
            rule__Operation_3__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Operation_3__Group__2_in_rule__Operation_3__Group__15875);
            rule__Operation_3__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation_3__Group__1"


    // $ANTLR start "rule__Operation_3__Group__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2943:1: rule__Operation_3__Group__1__Impl : ( 'operation' ) ;
    public final void rule__Operation_3__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2947:1: ( ( 'operation' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2948:1: ( 'operation' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2948:1: ( 'operation' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2949:1: 'operation'
            {
             before(grammarAccess.getOperation_3Access().getOperationKeyword_1()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__Operation_3__Group__1__Impl5903); 
             after(grammarAccess.getOperation_3Access().getOperationKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation_3__Group__1__Impl"


    // $ANTLR start "rule__Operation_3__Group__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2962:1: rule__Operation_3__Group__2 : rule__Operation_3__Group__2__Impl ;
    public final void rule__Operation_3__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2966:1: ( rule__Operation_3__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2967:2: rule__Operation_3__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation_3__Group__2__Impl_in_rule__Operation_3__Group__25934);
            rule__Operation_3__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation_3__Group__2"


    // $ANTLR start "rule__Operation_3__Group__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2973:1: rule__Operation_3__Group__2__Impl : ( ( rule__Operation_3__NameAssignment_2 ) ) ;
    public final void rule__Operation_3__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2977:1: ( ( ( rule__Operation_3__NameAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2978:1: ( ( rule__Operation_3__NameAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2978:1: ( ( rule__Operation_3__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2979:1: ( rule__Operation_3__NameAssignment_2 )
            {
             before(grammarAccess.getOperation_3Access().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2980:1: ( rule__Operation_3__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2980:2: rule__Operation_3__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation_3__NameAssignment_2_in_rule__Operation_3__Group__2__Impl5961);
            rule__Operation_3__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getOperation_3Access().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation_3__Group__2__Impl"


    // $ANTLR start "rule__Error_4__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:2996:1: rule__Error_4__Group__0 : rule__Error_4__Group__0__Impl rule__Error_4__Group__1 ;
    public final void rule__Error_4__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3000:1: ( rule__Error_4__Group__0__Impl rule__Error_4__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3001:2: rule__Error_4__Group__0__Impl rule__Error_4__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Error_4__Group__0__Impl_in_rule__Error_4__Group__05997);
            rule__Error_4__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Error_4__Group__1_in_rule__Error_4__Group__06000);
            rule__Error_4__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Error_4__Group__0"


    // $ANTLR start "rule__Error_4__Group__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3008:1: rule__Error_4__Group__0__Impl : ( ( rule__Error_4__AnnotationsAssignment_0 ) ) ;
    public final void rule__Error_4__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3012:1: ( ( ( rule__Error_4__AnnotationsAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3013:1: ( ( rule__Error_4__AnnotationsAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3013:1: ( ( rule__Error_4__AnnotationsAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3014:1: ( rule__Error_4__AnnotationsAssignment_0 )
            {
             before(grammarAccess.getError_4Access().getAnnotationsAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3015:1: ( rule__Error_4__AnnotationsAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3015:2: rule__Error_4__AnnotationsAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Error_4__AnnotationsAssignment_0_in_rule__Error_4__Group__0__Impl6027);
            rule__Error_4__AnnotationsAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getError_4Access().getAnnotationsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Error_4__Group__0__Impl"


    // $ANTLR start "rule__Error_4__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3025:1: rule__Error_4__Group__1 : rule__Error_4__Group__1__Impl rule__Error_4__Group__2 ;
    public final void rule__Error_4__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3029:1: ( rule__Error_4__Group__1__Impl rule__Error_4__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3030:2: rule__Error_4__Group__1__Impl rule__Error_4__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Error_4__Group__1__Impl_in_rule__Error_4__Group__16057);
            rule__Error_4__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Error_4__Group__2_in_rule__Error_4__Group__16060);
            rule__Error_4__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Error_4__Group__1"


    // $ANTLR start "rule__Error_4__Group__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3037:1: rule__Error_4__Group__1__Impl : ( 'error' ) ;
    public final void rule__Error_4__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3041:1: ( ( 'error' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3042:1: ( 'error' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3042:1: ( 'error' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3043:1: 'error'
            {
             before(grammarAccess.getError_4Access().getErrorKeyword_1()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__Error_4__Group__1__Impl6088); 
             after(grammarAccess.getError_4Access().getErrorKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Error_4__Group__1__Impl"


    // $ANTLR start "rule__Error_4__Group__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3056:1: rule__Error_4__Group__2 : rule__Error_4__Group__2__Impl ;
    public final void rule__Error_4__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3060:1: ( rule__Error_4__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3061:2: rule__Error_4__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Error_4__Group__2__Impl_in_rule__Error_4__Group__26119);
            rule__Error_4__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Error_4__Group__2"


    // $ANTLR start "rule__Error_4__Group__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3067:1: rule__Error_4__Group__2__Impl : ( ( rule__Error_4__NameAssignment_2 ) ) ;
    public final void rule__Error_4__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3071:1: ( ( ( rule__Error_4__NameAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3072:1: ( ( rule__Error_4__NameAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3072:1: ( ( rule__Error_4__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3073:1: ( rule__Error_4__NameAssignment_2 )
            {
             before(grammarAccess.getError_4Access().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3074:1: ( rule__Error_4__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3074:2: rule__Error_4__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Error_4__NameAssignment_2_in_rule__Error_4__Group__2__Impl6146);
            rule__Error_4__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getError_4Access().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Error_4__Group__2__Impl"


    // $ANTLR start "rule__Operation_4__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3090:1: rule__Operation_4__Group__0 : rule__Operation_4__Group__0__Impl rule__Operation_4__Group__1 ;
    public final void rule__Operation_4__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3094:1: ( rule__Operation_4__Group__0__Impl rule__Operation_4__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3095:2: rule__Operation_4__Group__0__Impl rule__Operation_4__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation_4__Group__0__Impl_in_rule__Operation_4__Group__06182);
            rule__Operation_4__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Operation_4__Group__1_in_rule__Operation_4__Group__06185);
            rule__Operation_4__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation_4__Group__0"


    // $ANTLR start "rule__Operation_4__Group__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3102:1: rule__Operation_4__Group__0__Impl : ( ( rule__Operation_4__AnnotationsAssignment_0 ) ) ;
    public final void rule__Operation_4__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3106:1: ( ( ( rule__Operation_4__AnnotationsAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3107:1: ( ( rule__Operation_4__AnnotationsAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3107:1: ( ( rule__Operation_4__AnnotationsAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3108:1: ( rule__Operation_4__AnnotationsAssignment_0 )
            {
             before(grammarAccess.getOperation_4Access().getAnnotationsAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3109:1: ( rule__Operation_4__AnnotationsAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3109:2: rule__Operation_4__AnnotationsAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation_4__AnnotationsAssignment_0_in_rule__Operation_4__Group__0__Impl6212);
            rule__Operation_4__AnnotationsAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getOperation_4Access().getAnnotationsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation_4__Group__0__Impl"


    // $ANTLR start "rule__Operation_4__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3119:1: rule__Operation_4__Group__1 : rule__Operation_4__Group__1__Impl rule__Operation_4__Group__2 ;
    public final void rule__Operation_4__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3123:1: ( rule__Operation_4__Group__1__Impl rule__Operation_4__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3124:2: rule__Operation_4__Group__1__Impl rule__Operation_4__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation_4__Group__1__Impl_in_rule__Operation_4__Group__16242);
            rule__Operation_4__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Operation_4__Group__2_in_rule__Operation_4__Group__16245);
            rule__Operation_4__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation_4__Group__1"


    // $ANTLR start "rule__Operation_4__Group__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3131:1: rule__Operation_4__Group__1__Impl : ( 'operation' ) ;
    public final void rule__Operation_4__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3135:1: ( ( 'operation' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3136:1: ( 'operation' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3136:1: ( 'operation' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3137:1: 'operation'
            {
             before(grammarAccess.getOperation_4Access().getOperationKeyword_1()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__Operation_4__Group__1__Impl6273); 
             after(grammarAccess.getOperation_4Access().getOperationKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation_4__Group__1__Impl"


    // $ANTLR start "rule__Operation_4__Group__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3150:1: rule__Operation_4__Group__2 : rule__Operation_4__Group__2__Impl ;
    public final void rule__Operation_4__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3154:1: ( rule__Operation_4__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3155:2: rule__Operation_4__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation_4__Group__2__Impl_in_rule__Operation_4__Group__26304);
            rule__Operation_4__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation_4__Group__2"


    // $ANTLR start "rule__Operation_4__Group__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3161:1: rule__Operation_4__Group__2__Impl : ( ( rule__Operation_4__NameAssignment_2 ) ) ;
    public final void rule__Operation_4__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3165:1: ( ( ( rule__Operation_4__NameAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3166:1: ( ( rule__Operation_4__NameAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3166:1: ( ( rule__Operation_4__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3167:1: ( rule__Operation_4__NameAssignment_2 )
            {
             before(grammarAccess.getOperation_4Access().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3168:1: ( rule__Operation_4__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3168:2: rule__Operation_4__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation_4__NameAssignment_2_in_rule__Operation_4__Group__2__Impl6331);
            rule__Operation_4__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getOperation_4Access().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation_4__Group__2__Impl"


    // $ANTLR start "rule__Error_5__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3184:1: rule__Error_5__Group__0 : rule__Error_5__Group__0__Impl rule__Error_5__Group__1 ;
    public final void rule__Error_5__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3188:1: ( rule__Error_5__Group__0__Impl rule__Error_5__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3189:2: rule__Error_5__Group__0__Impl rule__Error_5__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Error_5__Group__0__Impl_in_rule__Error_5__Group__06367);
            rule__Error_5__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Error_5__Group__1_in_rule__Error_5__Group__06370);
            rule__Error_5__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Error_5__Group__0"


    // $ANTLR start "rule__Error_5__Group__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3196:1: rule__Error_5__Group__0__Impl : ( 'error' ) ;
    public final void rule__Error_5__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3200:1: ( ( 'error' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3201:1: ( 'error' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3201:1: ( 'error' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3202:1: 'error'
            {
             before(grammarAccess.getError_5Access().getErrorKeyword_0()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__Error_5__Group__0__Impl6398); 
             after(grammarAccess.getError_5Access().getErrorKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Error_5__Group__0__Impl"


    // $ANTLR start "rule__Error_5__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3215:1: rule__Error_5__Group__1 : rule__Error_5__Group__1__Impl ;
    public final void rule__Error_5__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3219:1: ( rule__Error_5__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3220:2: rule__Error_5__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Error_5__Group__1__Impl_in_rule__Error_5__Group__16429);
            rule__Error_5__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Error_5__Group__1"


    // $ANTLR start "rule__Error_5__Group__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3226:1: rule__Error_5__Group__1__Impl : ( ( rule__Error_5__NameAssignment_1 ) ) ;
    public final void rule__Error_5__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3230:1: ( ( ( rule__Error_5__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3231:1: ( ( rule__Error_5__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3231:1: ( ( rule__Error_5__NameAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3232:1: ( rule__Error_5__NameAssignment_1 )
            {
             before(grammarAccess.getError_5Access().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3233:1: ( rule__Error_5__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3233:2: rule__Error_5__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Error_5__NameAssignment_1_in_rule__Error_5__Group__1__Impl6456);
            rule__Error_5__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getError_5Access().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Error_5__Group__1__Impl"


    // $ANTLR start "rule__Operation_5__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3247:1: rule__Operation_5__Group__0 : rule__Operation_5__Group__0__Impl rule__Operation_5__Group__1 ;
    public final void rule__Operation_5__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3251:1: ( rule__Operation_5__Group__0__Impl rule__Operation_5__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3252:2: rule__Operation_5__Group__0__Impl rule__Operation_5__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation_5__Group__0__Impl_in_rule__Operation_5__Group__06490);
            rule__Operation_5__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Operation_5__Group__1_in_rule__Operation_5__Group__06493);
            rule__Operation_5__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation_5__Group__0"


    // $ANTLR start "rule__Operation_5__Group__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3259:1: rule__Operation_5__Group__0__Impl : ( 'operation' ) ;
    public final void rule__Operation_5__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3263:1: ( ( 'operation' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3264:1: ( 'operation' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3264:1: ( 'operation' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3265:1: 'operation'
            {
             before(grammarAccess.getOperation_5Access().getOperationKeyword_0()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__Operation_5__Group__0__Impl6521); 
             after(grammarAccess.getOperation_5Access().getOperationKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation_5__Group__0__Impl"


    // $ANTLR start "rule__Operation_5__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3278:1: rule__Operation_5__Group__1 : rule__Operation_5__Group__1__Impl ;
    public final void rule__Operation_5__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3282:1: ( rule__Operation_5__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3283:2: rule__Operation_5__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation_5__Group__1__Impl_in_rule__Operation_5__Group__16552);
            rule__Operation_5__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation_5__Group__1"


    // $ANTLR start "rule__Operation_5__Group__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3289:1: rule__Operation_5__Group__1__Impl : ( ( rule__Operation_5__NameAssignment_1 ) ) ;
    public final void rule__Operation_5__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3293:1: ( ( ( rule__Operation_5__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3294:1: ( ( rule__Operation_5__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3294:1: ( ( rule__Operation_5__NameAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3295:1: ( rule__Operation_5__NameAssignment_1 )
            {
             before(grammarAccess.getOperation_5Access().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3296:1: ( rule__Operation_5__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3296:2: rule__Operation_5__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation_5__NameAssignment_1_in_rule__Operation_5__Group__1__Impl6579);
            rule__Operation_5__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getOperation_5Access().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation_5__Group__1__Impl"


    // $ANTLR start "rule__Annotation__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3310:1: rule__Annotation__Group__0 : rule__Annotation__Group__0__Impl rule__Annotation__Group__1 ;
    public final void rule__Annotation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3314:1: ( rule__Annotation__Group__0__Impl rule__Annotation__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3315:2: rule__Annotation__Group__0__Impl rule__Annotation__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Annotation__Group__0__Impl_in_rule__Annotation__Group__06613);
            rule__Annotation__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Annotation__Group__1_in_rule__Annotation__Group__06616);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3322:1: rule__Annotation__Group__0__Impl : ( '@uuid' ) ;
    public final void rule__Annotation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3326:1: ( ( '@uuid' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3327:1: ( '@uuid' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3327:1: ( '@uuid' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3328:1: '@uuid'
            {
             before(grammarAccess.getAnnotationAccess().getUuidKeyword_0()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__Annotation__Group__0__Impl6644); 
             after(grammarAccess.getAnnotationAccess().getUuidKeyword_0()); 

            }


            }

        }
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3341:1: rule__Annotation__Group__1 : rule__Annotation__Group__1__Impl ;
    public final void rule__Annotation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3345:1: ( rule__Annotation__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3346:2: rule__Annotation__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Annotation__Group__1__Impl_in_rule__Annotation__Group__16675);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3352:1: rule__Annotation__Group__1__Impl : ( ( rule__Annotation__NameAssignment_1 ) ) ;
    public final void rule__Annotation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3356:1: ( ( ( rule__Annotation__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3357:1: ( ( rule__Annotation__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3357:1: ( ( rule__Annotation__NameAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3358:1: ( rule__Annotation__NameAssignment_1 )
            {
             before(grammarAccess.getAnnotationAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3359:1: ( rule__Annotation__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3359:2: rule__Annotation__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Annotation__NameAssignment_1_in_rule__Annotation__Group__1__Impl6702);
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


    // $ANTLR start "rule__Model__ErrorsAssignment_1_0_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3374:1: rule__Model__ErrorsAssignment_1_0_2 : ( ruleError_1 ) ;
    public final void rule__Model__ErrorsAssignment_1_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3378:1: ( ( ruleError_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3379:1: ( ruleError_1 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3379:1: ( ruleError_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3380:1: ruleError_1
            {
             before(grammarAccess.getModelAccess().getErrorsError_1ParserRuleCall_1_0_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleError_1_in_rule__Model__ErrorsAssignment_1_0_26741);
            ruleError_1();

            state._fsp--;

             after(grammarAccess.getModelAccess().getErrorsError_1ParserRuleCall_1_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ErrorsAssignment_1_0_2"


    // $ANTLR start "rule__Model__OperationsAssignment_1_0_3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3389:1: rule__Model__OperationsAssignment_1_0_3 : ( ruleOperation_1 ) ;
    public final void rule__Model__OperationsAssignment_1_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3393:1: ( ( ruleOperation_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3394:1: ( ruleOperation_1 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3394:1: ( ruleOperation_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3395:1: ruleOperation_1
            {
             before(grammarAccess.getModelAccess().getOperationsOperation_1ParserRuleCall_1_0_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleOperation_1_in_rule__Model__OperationsAssignment_1_0_36772);
            ruleOperation_1();

            state._fsp--;

             after(grammarAccess.getModelAccess().getOperationsOperation_1ParserRuleCall_1_0_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__OperationsAssignment_1_0_3"


    // $ANTLR start "rule__Model__ErrorsAssignment_1_1_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3404:1: rule__Model__ErrorsAssignment_1_1_2 : ( ruleError_1 ) ;
    public final void rule__Model__ErrorsAssignment_1_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3408:1: ( ( ruleError_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3409:1: ( ruleError_1 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3409:1: ( ruleError_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3410:1: ruleError_1
            {
             before(grammarAccess.getModelAccess().getErrorsError_1ParserRuleCall_1_1_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleError_1_in_rule__Model__ErrorsAssignment_1_1_26803);
            ruleError_1();

            state._fsp--;

             after(grammarAccess.getModelAccess().getErrorsError_1ParserRuleCall_1_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ErrorsAssignment_1_1_2"


    // $ANTLR start "rule__Model__OperationsAssignment_1_1_3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3419:1: rule__Model__OperationsAssignment_1_1_3 : ( ruleOperation_1 ) ;
    public final void rule__Model__OperationsAssignment_1_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3423:1: ( ( ruleOperation_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3424:1: ( ruleOperation_1 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3424:1: ( ruleOperation_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3425:1: ruleOperation_1
            {
             before(grammarAccess.getModelAccess().getOperationsOperation_1ParserRuleCall_1_1_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleOperation_1_in_rule__Model__OperationsAssignment_1_1_36834);
            ruleOperation_1();

            state._fsp--;

             after(grammarAccess.getModelAccess().getOperationsOperation_1ParserRuleCall_1_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__OperationsAssignment_1_1_3"


    // $ANTLR start "rule__Model__ErrorsAssignment_1_2_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3434:1: rule__Model__ErrorsAssignment_1_2_2 : ( ruleError_2 ) ;
    public final void rule__Model__ErrorsAssignment_1_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3438:1: ( ( ruleError_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3439:1: ( ruleError_2 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3439:1: ( ruleError_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3440:1: ruleError_2
            {
             before(grammarAccess.getModelAccess().getErrorsError_2ParserRuleCall_1_2_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleError_2_in_rule__Model__ErrorsAssignment_1_2_26865);
            ruleError_2();

            state._fsp--;

             after(grammarAccess.getModelAccess().getErrorsError_2ParserRuleCall_1_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ErrorsAssignment_1_2_2"


    // $ANTLR start "rule__Model__OperationsAssignment_1_2_3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3449:1: rule__Model__OperationsAssignment_1_2_3 : ( ruleOperation_2 ) ;
    public final void rule__Model__OperationsAssignment_1_2_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3453:1: ( ( ruleOperation_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3454:1: ( ruleOperation_2 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3454:1: ( ruleOperation_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3455:1: ruleOperation_2
            {
             before(grammarAccess.getModelAccess().getOperationsOperation_2ParserRuleCall_1_2_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleOperation_2_in_rule__Model__OperationsAssignment_1_2_36896);
            ruleOperation_2();

            state._fsp--;

             after(grammarAccess.getModelAccess().getOperationsOperation_2ParserRuleCall_1_2_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__OperationsAssignment_1_2_3"


    // $ANTLR start "rule__Model__NameAssignment_1_3_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3464:1: rule__Model__NameAssignment_1_3_1 : ( RULE_ID ) ;
    public final void rule__Model__NameAssignment_1_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3468:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3469:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3469:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3470:1: RULE_ID
            {
             before(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_3_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Model__NameAssignment_1_3_16927); 
             after(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__NameAssignment_1_3_1"


    // $ANTLR start "rule__Model__ErrorsAssignment_1_3_3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3479:1: rule__Model__ErrorsAssignment_1_3_3 : ( ruleError_2 ) ;
    public final void rule__Model__ErrorsAssignment_1_3_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3483:1: ( ( ruleError_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3484:1: ( ruleError_2 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3484:1: ( ruleError_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3485:1: ruleError_2
            {
             before(grammarAccess.getModelAccess().getErrorsError_2ParserRuleCall_1_3_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleError_2_in_rule__Model__ErrorsAssignment_1_3_36958);
            ruleError_2();

            state._fsp--;

             after(grammarAccess.getModelAccess().getErrorsError_2ParserRuleCall_1_3_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ErrorsAssignment_1_3_3"


    // $ANTLR start "rule__Model__OperationsAssignment_1_3_4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3494:1: rule__Model__OperationsAssignment_1_3_4 : ( ruleOperation_2 ) ;
    public final void rule__Model__OperationsAssignment_1_3_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3498:1: ( ( ruleOperation_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3499:1: ( ruleOperation_2 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3499:1: ( ruleOperation_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3500:1: ruleOperation_2
            {
             before(grammarAccess.getModelAccess().getOperationsOperation_2ParserRuleCall_1_3_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleOperation_2_in_rule__Model__OperationsAssignment_1_3_46989);
            ruleOperation_2();

            state._fsp--;

             after(grammarAccess.getModelAccess().getOperationsOperation_2ParserRuleCall_1_3_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__OperationsAssignment_1_3_4"


    // $ANTLR start "rule__Model__NameAssignment_1_4_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3509:1: rule__Model__NameAssignment_1_4_1 : ( RULE_ID ) ;
    public final void rule__Model__NameAssignment_1_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3513:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3514:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3514:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3515:1: RULE_ID
            {
             before(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_4_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Model__NameAssignment_1_4_17020); 
             after(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__NameAssignment_1_4_1"


    // $ANTLR start "rule__Model__ErrorsAssignment_1_4_3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3524:1: rule__Model__ErrorsAssignment_1_4_3 : ( ruleError_3 ) ;
    public final void rule__Model__ErrorsAssignment_1_4_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3528:1: ( ( ruleError_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3529:1: ( ruleError_3 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3529:1: ( ruleError_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3530:1: ruleError_3
            {
             before(grammarAccess.getModelAccess().getErrorsError_3ParserRuleCall_1_4_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleError_3_in_rule__Model__ErrorsAssignment_1_4_37051);
            ruleError_3();

            state._fsp--;

             after(grammarAccess.getModelAccess().getErrorsError_3ParserRuleCall_1_4_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ErrorsAssignment_1_4_3"


    // $ANTLR start "rule__Model__OperationsAssignment_1_4_4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3539:1: rule__Model__OperationsAssignment_1_4_4 : ( ruleOperation_3 ) ;
    public final void rule__Model__OperationsAssignment_1_4_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3543:1: ( ( ruleOperation_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3544:1: ( ruleOperation_3 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3544:1: ( ruleOperation_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3545:1: ruleOperation_3
            {
             before(grammarAccess.getModelAccess().getOperationsOperation_3ParserRuleCall_1_4_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleOperation_3_in_rule__Model__OperationsAssignment_1_4_47082);
            ruleOperation_3();

            state._fsp--;

             after(grammarAccess.getModelAccess().getOperationsOperation_3ParserRuleCall_1_4_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__OperationsAssignment_1_4_4"


    // $ANTLR start "rule__Model__NameAssignment_1_5_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3554:1: rule__Model__NameAssignment_1_5_1 : ( RULE_ID ) ;
    public final void rule__Model__NameAssignment_1_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3558:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3559:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3559:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3560:1: RULE_ID
            {
             before(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_5_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Model__NameAssignment_1_5_17113); 
             after(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__NameAssignment_1_5_1"


    // $ANTLR start "rule__Model__ErrorsAssignment_1_5_3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3569:1: rule__Model__ErrorsAssignment_1_5_3 : ( ruleError_3 ) ;
    public final void rule__Model__ErrorsAssignment_1_5_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3573:1: ( ( ruleError_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3574:1: ( ruleError_3 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3574:1: ( ruleError_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3575:1: ruleError_3
            {
             before(grammarAccess.getModelAccess().getErrorsError_3ParserRuleCall_1_5_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleError_3_in_rule__Model__ErrorsAssignment_1_5_37144);
            ruleError_3();

            state._fsp--;

             after(grammarAccess.getModelAccess().getErrorsError_3ParserRuleCall_1_5_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ErrorsAssignment_1_5_3"


    // $ANTLR start "rule__Model__OperationsAssignment_1_5_4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3584:1: rule__Model__OperationsAssignment_1_5_4 : ( ruleOperation_3 ) ;
    public final void rule__Model__OperationsAssignment_1_5_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3588:1: ( ( ruleOperation_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3589:1: ( ruleOperation_3 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3589:1: ( ruleOperation_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3590:1: ruleOperation_3
            {
             before(grammarAccess.getModelAccess().getOperationsOperation_3ParserRuleCall_1_5_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleOperation_3_in_rule__Model__OperationsAssignment_1_5_47175);
            ruleOperation_3();

            state._fsp--;

             after(grammarAccess.getModelAccess().getOperationsOperation_3ParserRuleCall_1_5_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__OperationsAssignment_1_5_4"


    // $ANTLR start "rule__Model__NameAssignment_1_6_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3599:1: rule__Model__NameAssignment_1_6_1 : ( RULE_ID ) ;
    public final void rule__Model__NameAssignment_1_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3603:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3604:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3604:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3605:1: RULE_ID
            {
             before(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_6_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Model__NameAssignment_1_6_17206); 
             after(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__NameAssignment_1_6_1"


    // $ANTLR start "rule__Model__ErrorsAssignment_1_6_3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3614:1: rule__Model__ErrorsAssignment_1_6_3 : ( ruleError_4 ) ;
    public final void rule__Model__ErrorsAssignment_1_6_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3618:1: ( ( ruleError_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3619:1: ( ruleError_4 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3619:1: ( ruleError_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3620:1: ruleError_4
            {
             before(grammarAccess.getModelAccess().getErrorsError_4ParserRuleCall_1_6_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleError_4_in_rule__Model__ErrorsAssignment_1_6_37237);
            ruleError_4();

            state._fsp--;

             after(grammarAccess.getModelAccess().getErrorsError_4ParserRuleCall_1_6_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ErrorsAssignment_1_6_3"


    // $ANTLR start "rule__Model__OperationsAssignment_1_6_4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3629:1: rule__Model__OperationsAssignment_1_6_4 : ( ruleOperation_4 ) ;
    public final void rule__Model__OperationsAssignment_1_6_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3633:1: ( ( ruleOperation_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3634:1: ( ruleOperation_4 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3634:1: ( ruleOperation_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3635:1: ruleOperation_4
            {
             before(grammarAccess.getModelAccess().getOperationsOperation_4ParserRuleCall_1_6_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleOperation_4_in_rule__Model__OperationsAssignment_1_6_47268);
            ruleOperation_4();

            state._fsp--;

             after(grammarAccess.getModelAccess().getOperationsOperation_4ParserRuleCall_1_6_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__OperationsAssignment_1_6_4"


    // $ANTLR start "rule__Model__NameAssignment_1_7_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3644:1: rule__Model__NameAssignment_1_7_1 : ( RULE_ID ) ;
    public final void rule__Model__NameAssignment_1_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3648:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3649:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3649:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3650:1: RULE_ID
            {
             before(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_7_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Model__NameAssignment_1_7_17299); 
             after(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_7_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__NameAssignment_1_7_1"


    // $ANTLR start "rule__Model__ErrorsAssignment_1_7_3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3659:1: rule__Model__ErrorsAssignment_1_7_3 : ( ruleError_4 ) ;
    public final void rule__Model__ErrorsAssignment_1_7_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3663:1: ( ( ruleError_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3664:1: ( ruleError_4 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3664:1: ( ruleError_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3665:1: ruleError_4
            {
             before(grammarAccess.getModelAccess().getErrorsError_4ParserRuleCall_1_7_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleError_4_in_rule__Model__ErrorsAssignment_1_7_37330);
            ruleError_4();

            state._fsp--;

             after(grammarAccess.getModelAccess().getErrorsError_4ParserRuleCall_1_7_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ErrorsAssignment_1_7_3"


    // $ANTLR start "rule__Model__OperationsAssignment_1_7_4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3674:1: rule__Model__OperationsAssignment_1_7_4 : ( ruleOperation_4 ) ;
    public final void rule__Model__OperationsAssignment_1_7_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3678:1: ( ( ruleOperation_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3679:1: ( ruleOperation_4 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3679:1: ( ruleOperation_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3680:1: ruleOperation_4
            {
             before(grammarAccess.getModelAccess().getOperationsOperation_4ParserRuleCall_1_7_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleOperation_4_in_rule__Model__OperationsAssignment_1_7_47361);
            ruleOperation_4();

            state._fsp--;

             after(grammarAccess.getModelAccess().getOperationsOperation_4ParserRuleCall_1_7_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__OperationsAssignment_1_7_4"


    // $ANTLR start "rule__Model__NameAssignment_1_8_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3689:1: rule__Model__NameAssignment_1_8_1 : ( RULE_ID ) ;
    public final void rule__Model__NameAssignment_1_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3693:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3694:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3694:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3695:1: RULE_ID
            {
             before(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_8_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Model__NameAssignment_1_8_17392); 
             after(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_8_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__NameAssignment_1_8_1"


    // $ANTLR start "rule__Model__ErrorsAssignment_1_8_3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3704:1: rule__Model__ErrorsAssignment_1_8_3 : ( ruleError_5 ) ;
    public final void rule__Model__ErrorsAssignment_1_8_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3708:1: ( ( ruleError_5 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3709:1: ( ruleError_5 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3709:1: ( ruleError_5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3710:1: ruleError_5
            {
             before(grammarAccess.getModelAccess().getErrorsError_5ParserRuleCall_1_8_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleError_5_in_rule__Model__ErrorsAssignment_1_8_37423);
            ruleError_5();

            state._fsp--;

             after(grammarAccess.getModelAccess().getErrorsError_5ParserRuleCall_1_8_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ErrorsAssignment_1_8_3"


    // $ANTLR start "rule__Model__OperationsAssignment_1_8_4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3719:1: rule__Model__OperationsAssignment_1_8_4 : ( ruleOperation_5 ) ;
    public final void rule__Model__OperationsAssignment_1_8_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3723:1: ( ( ruleOperation_5 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3724:1: ( ruleOperation_5 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3724:1: ( ruleOperation_5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3725:1: ruleOperation_5
            {
             before(grammarAccess.getModelAccess().getOperationsOperation_5ParserRuleCall_1_8_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleOperation_5_in_rule__Model__OperationsAssignment_1_8_47454);
            ruleOperation_5();

            state._fsp--;

             after(grammarAccess.getModelAccess().getOperationsOperation_5ParserRuleCall_1_8_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__OperationsAssignment_1_8_4"


    // $ANTLR start "rule__Model__NameAssignment_1_9_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3734:1: rule__Model__NameAssignment_1_9_1 : ( RULE_ID ) ;
    public final void rule__Model__NameAssignment_1_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3738:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3739:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3739:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3740:1: RULE_ID
            {
             before(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_9_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Model__NameAssignment_1_9_17485); 
             after(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_9_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__NameAssignment_1_9_1"


    // $ANTLR start "rule__Model__ErrorsAssignment_1_9_3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3749:1: rule__Model__ErrorsAssignment_1_9_3 : ( ruleError_5 ) ;
    public final void rule__Model__ErrorsAssignment_1_9_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3753:1: ( ( ruleError_5 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3754:1: ( ruleError_5 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3754:1: ( ruleError_5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3755:1: ruleError_5
            {
             before(grammarAccess.getModelAccess().getErrorsError_5ParserRuleCall_1_9_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleError_5_in_rule__Model__ErrorsAssignment_1_9_37516);
            ruleError_5();

            state._fsp--;

             after(grammarAccess.getModelAccess().getErrorsError_5ParserRuleCall_1_9_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ErrorsAssignment_1_9_3"


    // $ANTLR start "rule__Model__OperationsAssignment_1_9_4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3764:1: rule__Model__OperationsAssignment_1_9_4 : ( ruleOperation_5 ) ;
    public final void rule__Model__OperationsAssignment_1_9_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3768:1: ( ( ruleOperation_5 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3769:1: ( ruleOperation_5 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3769:1: ( ruleOperation_5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3770:1: ruleOperation_5
            {
             before(grammarAccess.getModelAccess().getOperationsOperation_5ParserRuleCall_1_9_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleOperation_5_in_rule__Model__OperationsAssignment_1_9_47547);
            ruleOperation_5();

            state._fsp--;

             after(grammarAccess.getModelAccess().getOperationsOperation_5ParserRuleCall_1_9_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__OperationsAssignment_1_9_4"


    // $ANTLR start "rule__Error_1__AnnotationsAssignment_0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3779:1: rule__Error_1__AnnotationsAssignment_0 : ( ruleAnnotation ) ;
    public final void rule__Error_1__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3783:1: ( ( ruleAnnotation ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3784:1: ( ruleAnnotation )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3784:1: ( ruleAnnotation )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3785:1: ruleAnnotation
            {
             before(grammarAccess.getError_1Access().getAnnotationsAnnotationParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAnnotation_in_rule__Error_1__AnnotationsAssignment_07578);
            ruleAnnotation();

            state._fsp--;

             after(grammarAccess.getError_1Access().getAnnotationsAnnotationParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Error_1__AnnotationsAssignment_0"


    // $ANTLR start "rule__Error_1__NameAssignment_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3794:1: rule__Error_1__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Error_1__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3798:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3799:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3799:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3800:1: RULE_ID
            {
             before(grammarAccess.getError_1Access().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Error_1__NameAssignment_27609); 
             after(grammarAccess.getError_1Access().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Error_1__NameAssignment_2"


    // $ANTLR start "rule__Operation_1__AnnotationsAssignment_0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3809:1: rule__Operation_1__AnnotationsAssignment_0 : ( ruleAnnotation ) ;
    public final void rule__Operation_1__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3813:1: ( ( ruleAnnotation ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3814:1: ( ruleAnnotation )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3814:1: ( ruleAnnotation )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3815:1: ruleAnnotation
            {
             before(grammarAccess.getOperation_1Access().getAnnotationsAnnotationParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAnnotation_in_rule__Operation_1__AnnotationsAssignment_07640);
            ruleAnnotation();

            state._fsp--;

             after(grammarAccess.getOperation_1Access().getAnnotationsAnnotationParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation_1__AnnotationsAssignment_0"


    // $ANTLR start "rule__Operation_1__NameAssignment_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3824:1: rule__Operation_1__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Operation_1__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3828:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3829:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3829:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3830:1: RULE_ID
            {
             before(grammarAccess.getOperation_1Access().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Operation_1__NameAssignment_27671); 
             after(grammarAccess.getOperation_1Access().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation_1__NameAssignment_2"


    // $ANTLR start "rule__Error_2__AnnotationsAssignment_0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3839:1: rule__Error_2__AnnotationsAssignment_0 : ( ruleAnnotation ) ;
    public final void rule__Error_2__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3843:1: ( ( ruleAnnotation ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3844:1: ( ruleAnnotation )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3844:1: ( ruleAnnotation )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3845:1: ruleAnnotation
            {
             before(grammarAccess.getError_2Access().getAnnotationsAnnotationParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAnnotation_in_rule__Error_2__AnnotationsAssignment_07702);
            ruleAnnotation();

            state._fsp--;

             after(grammarAccess.getError_2Access().getAnnotationsAnnotationParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Error_2__AnnotationsAssignment_0"


    // $ANTLR start "rule__Error_2__NameAssignment_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3854:1: rule__Error_2__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Error_2__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3858:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3859:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3859:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3860:1: RULE_ID
            {
             before(grammarAccess.getError_2Access().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Error_2__NameAssignment_27733); 
             after(grammarAccess.getError_2Access().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Error_2__NameAssignment_2"


    // $ANTLR start "rule__Operation_2__AnnotationsAssignment_0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3869:1: rule__Operation_2__AnnotationsAssignment_0 : ( ruleAnnotation ) ;
    public final void rule__Operation_2__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3873:1: ( ( ruleAnnotation ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3874:1: ( ruleAnnotation )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3874:1: ( ruleAnnotation )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3875:1: ruleAnnotation
            {
             before(grammarAccess.getOperation_2Access().getAnnotationsAnnotationParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAnnotation_in_rule__Operation_2__AnnotationsAssignment_07764);
            ruleAnnotation();

            state._fsp--;

             after(grammarAccess.getOperation_2Access().getAnnotationsAnnotationParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation_2__AnnotationsAssignment_0"


    // $ANTLR start "rule__Operation_2__NameAssignment_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3884:1: rule__Operation_2__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Operation_2__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3888:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3889:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3889:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3890:1: RULE_ID
            {
             before(grammarAccess.getOperation_2Access().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Operation_2__NameAssignment_27795); 
             after(grammarAccess.getOperation_2Access().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation_2__NameAssignment_2"


    // $ANTLR start "rule__Error_3__AnnotationsAssignment_0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3899:1: rule__Error_3__AnnotationsAssignment_0 : ( ruleAnnotation ) ;
    public final void rule__Error_3__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3903:1: ( ( ruleAnnotation ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3904:1: ( ruleAnnotation )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3904:1: ( ruleAnnotation )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3905:1: ruleAnnotation
            {
             before(grammarAccess.getError_3Access().getAnnotationsAnnotationParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAnnotation_in_rule__Error_3__AnnotationsAssignment_07826);
            ruleAnnotation();

            state._fsp--;

             after(grammarAccess.getError_3Access().getAnnotationsAnnotationParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Error_3__AnnotationsAssignment_0"


    // $ANTLR start "rule__Error_3__NameAssignment_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3914:1: rule__Error_3__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Error_3__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3918:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3919:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3919:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3920:1: RULE_ID
            {
             before(grammarAccess.getError_3Access().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Error_3__NameAssignment_27857); 
             after(grammarAccess.getError_3Access().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Error_3__NameAssignment_2"


    // $ANTLR start "rule__Operation_3__AnnotationsAssignment_0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3929:1: rule__Operation_3__AnnotationsAssignment_0 : ( ruleAnnotation ) ;
    public final void rule__Operation_3__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3933:1: ( ( ruleAnnotation ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3934:1: ( ruleAnnotation )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3934:1: ( ruleAnnotation )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3935:1: ruleAnnotation
            {
             before(grammarAccess.getOperation_3Access().getAnnotationsAnnotationParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAnnotation_in_rule__Operation_3__AnnotationsAssignment_07888);
            ruleAnnotation();

            state._fsp--;

             after(grammarAccess.getOperation_3Access().getAnnotationsAnnotationParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation_3__AnnotationsAssignment_0"


    // $ANTLR start "rule__Operation_3__NameAssignment_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3944:1: rule__Operation_3__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Operation_3__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3948:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3949:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3949:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3950:1: RULE_ID
            {
             before(grammarAccess.getOperation_3Access().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Operation_3__NameAssignment_27919); 
             after(grammarAccess.getOperation_3Access().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation_3__NameAssignment_2"


    // $ANTLR start "rule__Error_4__AnnotationsAssignment_0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3959:1: rule__Error_4__AnnotationsAssignment_0 : ( ruleAnnotation ) ;
    public final void rule__Error_4__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3963:1: ( ( ruleAnnotation ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3964:1: ( ruleAnnotation )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3964:1: ( ruleAnnotation )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3965:1: ruleAnnotation
            {
             before(grammarAccess.getError_4Access().getAnnotationsAnnotationParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAnnotation_in_rule__Error_4__AnnotationsAssignment_07950);
            ruleAnnotation();

            state._fsp--;

             after(grammarAccess.getError_4Access().getAnnotationsAnnotationParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Error_4__AnnotationsAssignment_0"


    // $ANTLR start "rule__Error_4__NameAssignment_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3974:1: rule__Error_4__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Error_4__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3978:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3979:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3979:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3980:1: RULE_ID
            {
             before(grammarAccess.getError_4Access().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Error_4__NameAssignment_27981); 
             after(grammarAccess.getError_4Access().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Error_4__NameAssignment_2"


    // $ANTLR start "rule__Operation_4__AnnotationsAssignment_0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3989:1: rule__Operation_4__AnnotationsAssignment_0 : ( ruleAnnotation ) ;
    public final void rule__Operation_4__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3993:1: ( ( ruleAnnotation ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3994:1: ( ruleAnnotation )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3994:1: ( ruleAnnotation )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:3995:1: ruleAnnotation
            {
             before(grammarAccess.getOperation_4Access().getAnnotationsAnnotationParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAnnotation_in_rule__Operation_4__AnnotationsAssignment_08012);
            ruleAnnotation();

            state._fsp--;

             after(grammarAccess.getOperation_4Access().getAnnotationsAnnotationParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation_4__AnnotationsAssignment_0"


    // $ANTLR start "rule__Operation_4__NameAssignment_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:4004:1: rule__Operation_4__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Operation_4__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:4008:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:4009:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:4009:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:4010:1: RULE_ID
            {
             before(grammarAccess.getOperation_4Access().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Operation_4__NameAssignment_28043); 
             after(grammarAccess.getOperation_4Access().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation_4__NameAssignment_2"


    // $ANTLR start "rule__Error_5__NameAssignment_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:4019:1: rule__Error_5__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Error_5__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:4023:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:4024:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:4024:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:4025:1: RULE_ID
            {
             before(grammarAccess.getError_5Access().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Error_5__NameAssignment_18074); 
             after(grammarAccess.getError_5Access().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Error_5__NameAssignment_1"


    // $ANTLR start "rule__Operation_5__NameAssignment_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:4034:1: rule__Operation_5__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Operation_5__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:4038:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:4039:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:4039:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:4040:1: RULE_ID
            {
             before(grammarAccess.getOperation_5Access().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Operation_5__NameAssignment_18105); 
             after(grammarAccess.getOperation_5Access().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation_5__NameAssignment_1"


    // $ANTLR start "rule__Annotation__NameAssignment_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:4049:1: rule__Annotation__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Annotation__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:4053:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:4054:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:4054:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug309949TestLanguage.g:4055:1: RULE_ID
            {
             before(grammarAccess.getAnnotationAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Annotation__NameAssignment_18136); 
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

    // Delegated rules


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA4 dfa4 = new DFA4(this);
    protected DFA6 dfa6 = new DFA6(this);
    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA2_eotS =
        "\5\uffff";
    static final String DFA2_eofS =
        "\5\uffff";
    static final String DFA2_minS =
        "\1\15\1\4\2\uffff\1\27";
    static final String DFA2_maxS =
        "\1\31\1\4\2\uffff\1\31";
    static final String DFA2_acceptS =
        "\2\uffff\1\2\1\1\1\uffff";
    static final String DFA2_specialS =
        "\5\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\2\11\uffff\1\3\1\2\1\1",
            "\1\4",
            "",
            "",
            "\1\3\1\2\1\1"
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
            return "()* loopback of 612:1: ( rule__Model__ErrorsAssignment_1_0_2 )*";
        }
    }
    static final String DFA4_eotS =
        "\5\uffff";
    static final String DFA4_eofS =
        "\5\uffff";
    static final String DFA4_minS =
        "\1\27\1\4\2\uffff\1\27";
    static final String DFA4_maxS =
        "\1\31\1\4\2\uffff\1\31";
    static final String DFA4_acceptS =
        "\2\uffff\1\2\1\1\1\uffff";
    static final String DFA4_specialS =
        "\5\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\3\1\2\1\1",
            "\1\4",
            "",
            "",
            "\1\3\1\2\1\1"
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
            return "()* loopback of 778:1: ( rule__Model__ErrorsAssignment_1_1_2 )*";
        }
    }
    static final String DFA6_eotS =
        "\7\uffff";
    static final String DFA6_eofS =
        "\7\uffff";
    static final String DFA6_minS =
        "\1\15\1\4\1\uffff\1\27\1\4\1\uffff\1\27";
    static final String DFA6_maxS =
        "\1\31\1\4\1\uffff\1\31\1\4\1\uffff\1\31";
    static final String DFA6_acceptS =
        "\2\uffff\1\2\2\uffff\1\1\1\uffff";
    static final String DFA6_specialS =
        "\7\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\2\13\uffff\1\1",
            "\1\3",
            "",
            "\1\5\1\2\1\4",
            "\1\6",
            "",
            "\1\5\1\2\1\4"
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
            return "()* loopback of 946:1: ( rule__Model__ErrorsAssignment_1_2_2 )*";
        }
    }
    static final String DFA8_eotS =
        "\7\uffff";
    static final String DFA8_eofS =
        "\7\uffff";
    static final String DFA8_minS =
        "\1\31\1\4\1\27\1\4\2\uffff\1\27";
    static final String DFA8_maxS =
        "\1\31\1\4\1\31\1\4\2\uffff\1\31";
    static final String DFA8_acceptS =
        "\4\uffff\1\2\1\1\1\uffff";
    static final String DFA8_specialS =
        "\7\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\1",
            "\1\2",
            "\1\5\1\4\1\3",
            "\1\6",
            "",
            "",
            "\1\5\1\4\1\3"
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
            return "()* loopback of 1141:1: ( rule__Model__ErrorsAssignment_1_3_3 )*";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group__0_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleError_1_in_entryRuleError_1121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleError_1128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Error_1__Group__0_in_ruleError_1154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperation_1_in_entryRuleOperation_1181 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOperation_1188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation_1__Group__0_in_ruleOperation_1214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleError_2_in_entryRuleError_2241 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleError_2248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Error_2__Group__0_in_ruleError_2274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperation_2_in_entryRuleOperation_2301 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOperation_2308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation_2__Group__0_in_ruleOperation_2334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleError_3_in_entryRuleError_3361 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleError_3368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Error_3__Group__0_in_ruleError_3394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperation_3_in_entryRuleOperation_3421 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOperation_3428 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation_3__Group__0_in_ruleOperation_3454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleError_4_in_entryRuleError_4481 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleError_4488 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Error_4__Group__0_in_ruleError_4514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperation_4_in_entryRuleOperation_4541 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOperation_4548 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation_4__Group__0_in_ruleOperation_4574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleError_5_in_entryRuleError_5601 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleError_5608 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Error_5__Group__0_in_ruleError_5634 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperation_5_in_entryRuleOperation_5661 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOperation_5668 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation_5__Group__0_in_ruleOperation_5694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnnotation_in_entryRuleAnnotation721 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAnnotation728 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Annotation__Group__0_in_ruleAnnotation754 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_0__0_in_rule__Model__Alternatives_1790 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_1__0_in_rule__Model__Alternatives_1808 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_2__0_in_rule__Model__Alternatives_1826 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_3__0_in_rule__Model__Alternatives_1844 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_4__0_in_rule__Model__Alternatives_1862 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_5__0_in_rule__Model__Alternatives_1880 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_6__0_in_rule__Model__Alternatives_1898 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_7__0_in_rule__Model__Alternatives_1916 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_8__0_in_rule__Model__Alternatives_1934 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_9__0_in_rule__Model__Alternatives_1952 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__0983 = new BitSet(new long[]{0x00000000007FC800L});
        public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__0986 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__11044 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Alternatives_1_in_rule__Model__Group__1__Impl1071 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_0__0__Impl_in_rule__Model__Group_1_0__01105 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_0__1_in_rule__Model__Group_1_0__01108 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Model__Group_1_0__0__Impl1136 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_0__1__Impl_in_rule__Model__Group_1_0__11167 = new BitSet(new long[]{0x0000000003802000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_0__2_in_rule__Model__Group_1_0__11170 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Model__Group_1_0__1__Impl1198 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_0__2__Impl_in_rule__Model__Group_1_0__21229 = new BitSet(new long[]{0x0000000003802000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_0__3_in_rule__Model__Group_1_0__21232 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ErrorsAssignment_1_0_2_in_rule__Model__Group_1_0__2__Impl1259 = new BitSet(new long[]{0x0000000002800002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_0__3__Impl_in_rule__Model__Group_1_0__31290 = new BitSet(new long[]{0x0000000003802000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_0__4_in_rule__Model__Group_1_0__31293 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__OperationsAssignment_1_0_3_in_rule__Model__Group_1_0__3__Impl1320 = new BitSet(new long[]{0x0000000003000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_0__4__Impl_in_rule__Model__Group_1_0__41351 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Model__Group_1_0__4__Impl1379 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_1__0__Impl_in_rule__Model__Group_1_1__01420 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_1__1_in_rule__Model__Group_1_1__01423 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Model__Group_1_1__0__Impl1451 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_1__1__Impl_in_rule__Model__Group_1_1__11482 = new BitSet(new long[]{0x0000000002800000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_1__2_in_rule__Model__Group_1_1__11485 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Model__Group_1_1__1__Impl1513 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_1__2__Impl_in_rule__Model__Group_1_1__21544 = new BitSet(new long[]{0x0000000003000000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_1__3_in_rule__Model__Group_1_1__21547 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ErrorsAssignment_1_1_2_in_rule__Model__Group_1_1__2__Impl1576 = new BitSet(new long[]{0x0000000002800002L});
        public static final BitSet FOLLOW_rule__Model__ErrorsAssignment_1_1_2_in_rule__Model__Group_1_1__2__Impl1588 = new BitSet(new long[]{0x0000000002800002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_1__3__Impl_in_rule__Model__Group_1_1__31621 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_1__4_in_rule__Model__Group_1_1__31624 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__OperationsAssignment_1_1_3_in_rule__Model__Group_1_1__3__Impl1653 = new BitSet(new long[]{0x0000000003000002L});
        public static final BitSet FOLLOW_rule__Model__OperationsAssignment_1_1_3_in_rule__Model__Group_1_1__3__Impl1665 = new BitSet(new long[]{0x0000000003000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_1__4__Impl_in_rule__Model__Group_1_1__41698 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Model__Group_1_1__4__Impl1726 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_2__0__Impl_in_rule__Model__Group_1_2__01767 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_2__1_in_rule__Model__Group_1_2__01770 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Model__Group_1_2__0__Impl1798 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_2__1__Impl_in_rule__Model__Group_1_2__11829 = new BitSet(new long[]{0x0000000002002000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_2__2_in_rule__Model__Group_1_2__11832 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Model__Group_1_2__1__Impl1860 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_2__2__Impl_in_rule__Model__Group_1_2__21891 = new BitSet(new long[]{0x0000000002002000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_2__3_in_rule__Model__Group_1_2__21894 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ErrorsAssignment_1_2_2_in_rule__Model__Group_1_2__2__Impl1921 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_2__3__Impl_in_rule__Model__Group_1_2__31952 = new BitSet(new long[]{0x0000000002002000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_2__4_in_rule__Model__Group_1_2__31955 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__OperationsAssignment_1_2_3_in_rule__Model__Group_1_2__3__Impl1982 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_2__4__Impl_in_rule__Model__Group_1_2__42013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Model__Group_1_2__4__Impl2041 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_3__0__Impl_in_rule__Model__Group_1_3__02082 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Model__Group_1_3__1_in_rule__Model__Group_1_3__02085 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Model__Group_1_3__0__Impl2113 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_3__1__Impl_in_rule__Model__Group_1_3__12144 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_3__2_in_rule__Model__Group_1_3__12147 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__NameAssignment_1_3_1_in_rule__Model__Group_1_3__1__Impl2174 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_3__2__Impl_in_rule__Model__Group_1_3__22204 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_3__3_in_rule__Model__Group_1_3__22207 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Model__Group_1_3__2__Impl2235 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_3__3__Impl_in_rule__Model__Group_1_3__32266 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_3__4_in_rule__Model__Group_1_3__32269 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ErrorsAssignment_1_3_3_in_rule__Model__Group_1_3__3__Impl2298 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_rule__Model__ErrorsAssignment_1_3_3_in_rule__Model__Group_1_3__3__Impl2310 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_3__4__Impl_in_rule__Model__Group_1_3__42343 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_3__5_in_rule__Model__Group_1_3__42346 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__OperationsAssignment_1_3_4_in_rule__Model__Group_1_3__4__Impl2375 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_rule__Model__OperationsAssignment_1_3_4_in_rule__Model__Group_1_3__4__Impl2387 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_3__5__Impl_in_rule__Model__Group_1_3__52420 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Model__Group_1_3__5__Impl2448 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_4__0__Impl_in_rule__Model__Group_1_4__02491 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Model__Group_1_4__1_in_rule__Model__Group_1_4__02494 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Model__Group_1_4__0__Impl2522 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_4__1__Impl_in_rule__Model__Group_1_4__12553 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_4__2_in_rule__Model__Group_1_4__12556 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__NameAssignment_1_4_1_in_rule__Model__Group_1_4__1__Impl2583 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_4__2__Impl_in_rule__Model__Group_1_4__22613 = new BitSet(new long[]{0x0000000003802000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_4__3_in_rule__Model__Group_1_4__22616 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Model__Group_1_4__2__Impl2644 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_4__3__Impl_in_rule__Model__Group_1_4__32675 = new BitSet(new long[]{0x0000000003802000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_4__4_in_rule__Model__Group_1_4__32678 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ErrorsAssignment_1_4_3_in_rule__Model__Group_1_4__3__Impl2705 = new BitSet(new long[]{0x0000000002800002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_4__4__Impl_in_rule__Model__Group_1_4__42736 = new BitSet(new long[]{0x0000000003802000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_4__5_in_rule__Model__Group_1_4__42739 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__OperationsAssignment_1_4_4_in_rule__Model__Group_1_4__4__Impl2766 = new BitSet(new long[]{0x0000000003000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_4__5__Impl_in_rule__Model__Group_1_4__52797 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Model__Group_1_4__5__Impl2825 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_5__0__Impl_in_rule__Model__Group_1_5__02868 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Model__Group_1_5__1_in_rule__Model__Group_1_5__02871 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Model__Group_1_5__0__Impl2899 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_5__1__Impl_in_rule__Model__Group_1_5__12930 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_5__2_in_rule__Model__Group_1_5__12933 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__NameAssignment_1_5_1_in_rule__Model__Group_1_5__1__Impl2960 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_5__2__Impl_in_rule__Model__Group_1_5__22990 = new BitSet(new long[]{0x0000000002800000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_5__3_in_rule__Model__Group_1_5__22993 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Model__Group_1_5__2__Impl3021 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_5__3__Impl_in_rule__Model__Group_1_5__33052 = new BitSet(new long[]{0x0000000003000000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_5__4_in_rule__Model__Group_1_5__33055 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ErrorsAssignment_1_5_3_in_rule__Model__Group_1_5__3__Impl3084 = new BitSet(new long[]{0x0000000002800002L});
        public static final BitSet FOLLOW_rule__Model__ErrorsAssignment_1_5_3_in_rule__Model__Group_1_5__3__Impl3096 = new BitSet(new long[]{0x0000000002800002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_5__4__Impl_in_rule__Model__Group_1_5__43129 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_5__5_in_rule__Model__Group_1_5__43132 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__OperationsAssignment_1_5_4_in_rule__Model__Group_1_5__4__Impl3161 = new BitSet(new long[]{0x0000000003000002L});
        public static final BitSet FOLLOW_rule__Model__OperationsAssignment_1_5_4_in_rule__Model__Group_1_5__4__Impl3173 = new BitSet(new long[]{0x0000000003000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_5__5__Impl_in_rule__Model__Group_1_5__53206 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Model__Group_1_5__5__Impl3234 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_6__0__Impl_in_rule__Model__Group_1_6__03277 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Model__Group_1_6__1_in_rule__Model__Group_1_6__03280 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Model__Group_1_6__0__Impl3308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_6__1__Impl_in_rule__Model__Group_1_6__13339 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_6__2_in_rule__Model__Group_1_6__13342 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__NameAssignment_1_6_1_in_rule__Model__Group_1_6__1__Impl3369 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_6__2__Impl_in_rule__Model__Group_1_6__23399 = new BitSet(new long[]{0x0000000002002000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_6__3_in_rule__Model__Group_1_6__23402 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Model__Group_1_6__2__Impl3430 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_6__3__Impl_in_rule__Model__Group_1_6__33461 = new BitSet(new long[]{0x0000000002002000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_6__4_in_rule__Model__Group_1_6__33464 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ErrorsAssignment_1_6_3_in_rule__Model__Group_1_6__3__Impl3491 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_6__4__Impl_in_rule__Model__Group_1_6__43522 = new BitSet(new long[]{0x0000000002002000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_6__5_in_rule__Model__Group_1_6__43525 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__OperationsAssignment_1_6_4_in_rule__Model__Group_1_6__4__Impl3552 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_6__5__Impl_in_rule__Model__Group_1_6__53583 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Model__Group_1_6__5__Impl3611 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_7__0__Impl_in_rule__Model__Group_1_7__03654 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Model__Group_1_7__1_in_rule__Model__Group_1_7__03657 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Model__Group_1_7__0__Impl3685 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_7__1__Impl_in_rule__Model__Group_1_7__13716 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_7__2_in_rule__Model__Group_1_7__13719 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__NameAssignment_1_7_1_in_rule__Model__Group_1_7__1__Impl3746 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_7__2__Impl_in_rule__Model__Group_1_7__23776 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_7__3_in_rule__Model__Group_1_7__23779 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Model__Group_1_7__2__Impl3807 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_7__3__Impl_in_rule__Model__Group_1_7__33838 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_7__4_in_rule__Model__Group_1_7__33841 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ErrorsAssignment_1_7_3_in_rule__Model__Group_1_7__3__Impl3870 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_rule__Model__ErrorsAssignment_1_7_3_in_rule__Model__Group_1_7__3__Impl3882 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_7__4__Impl_in_rule__Model__Group_1_7__43915 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_7__5_in_rule__Model__Group_1_7__43918 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__OperationsAssignment_1_7_4_in_rule__Model__Group_1_7__4__Impl3947 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_rule__Model__OperationsAssignment_1_7_4_in_rule__Model__Group_1_7__4__Impl3959 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_7__5__Impl_in_rule__Model__Group_1_7__53992 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Model__Group_1_7__5__Impl4020 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_8__0__Impl_in_rule__Model__Group_1_8__04063 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Model__Group_1_8__1_in_rule__Model__Group_1_8__04066 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__Model__Group_1_8__0__Impl4094 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_8__1__Impl_in_rule__Model__Group_1_8__14125 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_8__2_in_rule__Model__Group_1_8__14128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__NameAssignment_1_8_1_in_rule__Model__Group_1_8__1__Impl4155 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_8__2__Impl_in_rule__Model__Group_1_8__24185 = new BitSet(new long[]{0x0000000001802000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_8__3_in_rule__Model__Group_1_8__24188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Model__Group_1_8__2__Impl4216 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_8__3__Impl_in_rule__Model__Group_1_8__34247 = new BitSet(new long[]{0x0000000001802000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_8__4_in_rule__Model__Group_1_8__34250 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ErrorsAssignment_1_8_3_in_rule__Model__Group_1_8__3__Impl4277 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_8__4__Impl_in_rule__Model__Group_1_8__44308 = new BitSet(new long[]{0x0000000001802000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_8__5_in_rule__Model__Group_1_8__44311 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__OperationsAssignment_1_8_4_in_rule__Model__Group_1_8__4__Impl4338 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_8__5__Impl_in_rule__Model__Group_1_8__54369 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Model__Group_1_8__5__Impl4397 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_9__0__Impl_in_rule__Model__Group_1_9__04440 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Model__Group_1_9__1_in_rule__Model__Group_1_9__04443 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__Model__Group_1_9__0__Impl4471 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_9__1__Impl_in_rule__Model__Group_1_9__14502 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_9__2_in_rule__Model__Group_1_9__14505 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__NameAssignment_1_9_1_in_rule__Model__Group_1_9__1__Impl4532 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_9__2__Impl_in_rule__Model__Group_1_9__24562 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_9__3_in_rule__Model__Group_1_9__24565 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Model__Group_1_9__2__Impl4593 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_9__3__Impl_in_rule__Model__Group_1_9__34624 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_9__4_in_rule__Model__Group_1_9__34627 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ErrorsAssignment_1_9_3_in_rule__Model__Group_1_9__3__Impl4656 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_rule__Model__ErrorsAssignment_1_9_3_in_rule__Model__Group_1_9__3__Impl4668 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_9__4__Impl_in_rule__Model__Group_1_9__44701 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__Model__Group_1_9__5_in_rule__Model__Group_1_9__44704 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__OperationsAssignment_1_9_4_in_rule__Model__Group_1_9__4__Impl4733 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_rule__Model__OperationsAssignment_1_9_4_in_rule__Model__Group_1_9__4__Impl4745 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1_9__5__Impl_in_rule__Model__Group_1_9__54778 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Model__Group_1_9__5__Impl4806 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Error_1__Group__0__Impl_in_rule__Error_1__Group__04849 = new BitSet(new long[]{0x0000000002800000L});
        public static final BitSet FOLLOW_rule__Error_1__Group__1_in_rule__Error_1__Group__04852 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Error_1__AnnotationsAssignment_0_in_rule__Error_1__Group__0__Impl4879 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_rule__Error_1__Group__1__Impl_in_rule__Error_1__Group__14910 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Error_1__Group__2_in_rule__Error_1__Group__14913 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__Error_1__Group__1__Impl4941 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Error_1__Group__2__Impl_in_rule__Error_1__Group__24972 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Error_1__NameAssignment_2_in_rule__Error_1__Group__2__Impl4999 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation_1__Group__0__Impl_in_rule__Operation_1__Group__05035 = new BitSet(new long[]{0x0000000003000000L});
        public static final BitSet FOLLOW_rule__Operation_1__Group__1_in_rule__Operation_1__Group__05038 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation_1__AnnotationsAssignment_0_in_rule__Operation_1__Group__0__Impl5065 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_rule__Operation_1__Group__1__Impl_in_rule__Operation_1__Group__15096 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Operation_1__Group__2_in_rule__Operation_1__Group__15099 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__Operation_1__Group__1__Impl5127 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation_1__Group__2__Impl_in_rule__Operation_1__Group__25158 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation_1__NameAssignment_2_in_rule__Operation_1__Group__2__Impl5185 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Error_2__Group__0__Impl_in_rule__Error_2__Group__05221 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__Error_2__Group__1_in_rule__Error_2__Group__05224 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Error_2__AnnotationsAssignment_0_in_rule__Error_2__Group__0__Impl5253 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_rule__Error_2__AnnotationsAssignment_0_in_rule__Error_2__Group__0__Impl5265 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_rule__Error_2__Group__1__Impl_in_rule__Error_2__Group__15298 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Error_2__Group__2_in_rule__Error_2__Group__15301 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__Error_2__Group__1__Impl5329 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Error_2__Group__2__Impl_in_rule__Error_2__Group__25360 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Error_2__NameAssignment_2_in_rule__Error_2__Group__2__Impl5387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation_2__Group__0__Impl_in_rule__Operation_2__Group__05423 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_rule__Operation_2__Group__1_in_rule__Operation_2__Group__05426 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation_2__AnnotationsAssignment_0_in_rule__Operation_2__Group__0__Impl5455 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_rule__Operation_2__AnnotationsAssignment_0_in_rule__Operation_2__Group__0__Impl5467 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_rule__Operation_2__Group__1__Impl_in_rule__Operation_2__Group__15500 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Operation_2__Group__2_in_rule__Operation_2__Group__15503 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__Operation_2__Group__1__Impl5531 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation_2__Group__2__Impl_in_rule__Operation_2__Group__25562 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation_2__NameAssignment_2_in_rule__Operation_2__Group__2__Impl5589 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Error_3__Group__0__Impl_in_rule__Error_3__Group__05625 = new BitSet(new long[]{0x0000000002800000L});
        public static final BitSet FOLLOW_rule__Error_3__Group__1_in_rule__Error_3__Group__05628 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Error_3__AnnotationsAssignment_0_in_rule__Error_3__Group__0__Impl5655 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Error_3__Group__1__Impl_in_rule__Error_3__Group__15686 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Error_3__Group__2_in_rule__Error_3__Group__15689 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__Error_3__Group__1__Impl5717 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Error_3__Group__2__Impl_in_rule__Error_3__Group__25748 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Error_3__NameAssignment_2_in_rule__Error_3__Group__2__Impl5775 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation_3__Group__0__Impl_in_rule__Operation_3__Group__05811 = new BitSet(new long[]{0x0000000003000000L});
        public static final BitSet FOLLOW_rule__Operation_3__Group__1_in_rule__Operation_3__Group__05814 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation_3__AnnotationsAssignment_0_in_rule__Operation_3__Group__0__Impl5841 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation_3__Group__1__Impl_in_rule__Operation_3__Group__15872 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Operation_3__Group__2_in_rule__Operation_3__Group__15875 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__Operation_3__Group__1__Impl5903 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation_3__Group__2__Impl_in_rule__Operation_3__Group__25934 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation_3__NameAssignment_2_in_rule__Operation_3__Group__2__Impl5961 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Error_4__Group__0__Impl_in_rule__Error_4__Group__05997 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__Error_4__Group__1_in_rule__Error_4__Group__06000 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Error_4__AnnotationsAssignment_0_in_rule__Error_4__Group__0__Impl6027 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Error_4__Group__1__Impl_in_rule__Error_4__Group__16057 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Error_4__Group__2_in_rule__Error_4__Group__16060 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__Error_4__Group__1__Impl6088 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Error_4__Group__2__Impl_in_rule__Error_4__Group__26119 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Error_4__NameAssignment_2_in_rule__Error_4__Group__2__Impl6146 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation_4__Group__0__Impl_in_rule__Operation_4__Group__06182 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_rule__Operation_4__Group__1_in_rule__Operation_4__Group__06185 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation_4__AnnotationsAssignment_0_in_rule__Operation_4__Group__0__Impl6212 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation_4__Group__1__Impl_in_rule__Operation_4__Group__16242 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Operation_4__Group__2_in_rule__Operation_4__Group__16245 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__Operation_4__Group__1__Impl6273 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation_4__Group__2__Impl_in_rule__Operation_4__Group__26304 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation_4__NameAssignment_2_in_rule__Operation_4__Group__2__Impl6331 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Error_5__Group__0__Impl_in_rule__Error_5__Group__06367 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Error_5__Group__1_in_rule__Error_5__Group__06370 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__Error_5__Group__0__Impl6398 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Error_5__Group__1__Impl_in_rule__Error_5__Group__16429 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Error_5__NameAssignment_1_in_rule__Error_5__Group__1__Impl6456 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation_5__Group__0__Impl_in_rule__Operation_5__Group__06490 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Operation_5__Group__1_in_rule__Operation_5__Group__06493 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__Operation_5__Group__0__Impl6521 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation_5__Group__1__Impl_in_rule__Operation_5__Group__16552 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation_5__NameAssignment_1_in_rule__Operation_5__Group__1__Impl6579 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Annotation__Group__0__Impl_in_rule__Annotation__Group__06613 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Annotation__Group__1_in_rule__Annotation__Group__06616 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__Annotation__Group__0__Impl6644 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Annotation__Group__1__Impl_in_rule__Annotation__Group__16675 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Annotation__NameAssignment_1_in_rule__Annotation__Group__1__Impl6702 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleError_1_in_rule__Model__ErrorsAssignment_1_0_26741 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperation_1_in_rule__Model__OperationsAssignment_1_0_36772 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleError_1_in_rule__Model__ErrorsAssignment_1_1_26803 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperation_1_in_rule__Model__OperationsAssignment_1_1_36834 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleError_2_in_rule__Model__ErrorsAssignment_1_2_26865 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperation_2_in_rule__Model__OperationsAssignment_1_2_36896 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Model__NameAssignment_1_3_16927 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleError_2_in_rule__Model__ErrorsAssignment_1_3_36958 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperation_2_in_rule__Model__OperationsAssignment_1_3_46989 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Model__NameAssignment_1_4_17020 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleError_3_in_rule__Model__ErrorsAssignment_1_4_37051 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperation_3_in_rule__Model__OperationsAssignment_1_4_47082 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Model__NameAssignment_1_5_17113 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleError_3_in_rule__Model__ErrorsAssignment_1_5_37144 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperation_3_in_rule__Model__OperationsAssignment_1_5_47175 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Model__NameAssignment_1_6_17206 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleError_4_in_rule__Model__ErrorsAssignment_1_6_37237 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperation_4_in_rule__Model__OperationsAssignment_1_6_47268 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Model__NameAssignment_1_7_17299 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleError_4_in_rule__Model__ErrorsAssignment_1_7_37330 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperation_4_in_rule__Model__OperationsAssignment_1_7_47361 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Model__NameAssignment_1_8_17392 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleError_5_in_rule__Model__ErrorsAssignment_1_8_37423 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperation_5_in_rule__Model__OperationsAssignment_1_8_47454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Model__NameAssignment_1_9_17485 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleError_5_in_rule__Model__ErrorsAssignment_1_9_37516 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperation_5_in_rule__Model__OperationsAssignment_1_9_47547 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnnotation_in_rule__Error_1__AnnotationsAssignment_07578 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Error_1__NameAssignment_27609 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnnotation_in_rule__Operation_1__AnnotationsAssignment_07640 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Operation_1__NameAssignment_27671 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnnotation_in_rule__Error_2__AnnotationsAssignment_07702 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Error_2__NameAssignment_27733 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnnotation_in_rule__Operation_2__AnnotationsAssignment_07764 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Operation_2__NameAssignment_27795 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnnotation_in_rule__Error_3__AnnotationsAssignment_07826 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Error_3__NameAssignment_27857 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnnotation_in_rule__Operation_3__AnnotationsAssignment_07888 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Operation_3__NameAssignment_27919 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnnotation_in_rule__Error_4__AnnotationsAssignment_07950 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Error_4__NameAssignment_27981 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnnotation_in_rule__Operation_4__AnnotationsAssignment_08012 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Operation_4__NameAssignment_28043 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Error_5__NameAssignment_18074 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Operation_5__NameAssignment_18105 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Annotation__NameAssignment_18136 = new BitSet(new long[]{0x0000000000000002L});
    }


}
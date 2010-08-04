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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.ContentAssistContextTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalContentAssistContextTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'A1'", "'A2'", "'B1'", "'B2'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalContentAssistContextTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g"; }


     
     	private ContentAssistContextTestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(ContentAssistContextTestLanguageGrammarAccess grammarAccess) {
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




    // $ANTLR start entryRuleFirstLevel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:61:1: entryRuleFirstLevel : ruleFirstLevel EOF ;
    public final void entryRuleFirstLevel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:62:1: ( ruleFirstLevel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:63:1: ruleFirstLevel EOF
            {
             before(grammarAccess.getFirstLevelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFirstLevel_in_entryRuleFirstLevel61);
            ruleFirstLevel();
            _fsp--;

             after(grammarAccess.getFirstLevelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFirstLevel68); 

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
    // $ANTLR end entryRuleFirstLevel


    // $ANTLR start ruleFirstLevel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:70:1: ruleFirstLevel : ( ( rule__FirstLevel__Group__0 ) ) ;
    public final void ruleFirstLevel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:74:2: ( ( ( rule__FirstLevel__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:75:1: ( ( rule__FirstLevel__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:75:1: ( ( rule__FirstLevel__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:76:1: ( rule__FirstLevel__Group__0 )
            {
             before(grammarAccess.getFirstLevelAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:77:1: ( rule__FirstLevel__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:77:2: rule__FirstLevel__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__FirstLevel__Group__0_in_ruleFirstLevel94);
            rule__FirstLevel__Group__0();
            _fsp--;


            }

             after(grammarAccess.getFirstLevelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleFirstLevel


    // $ANTLR start entryRuleSecondLevelA
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:89:1: entryRuleSecondLevelA : ruleSecondLevelA EOF ;
    public final void entryRuleSecondLevelA() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:90:1: ( ruleSecondLevelA EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:91:1: ruleSecondLevelA EOF
            {
             before(grammarAccess.getSecondLevelARule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSecondLevelA_in_entryRuleSecondLevelA121);
            ruleSecondLevelA();
            _fsp--;

             after(grammarAccess.getSecondLevelARule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSecondLevelA128); 

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
    // $ANTLR end entryRuleSecondLevelA


    // $ANTLR start ruleSecondLevelA
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:98:1: ruleSecondLevelA : ( ( rule__SecondLevelA__Group__0 ) ) ;
    public final void ruleSecondLevelA() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:102:2: ( ( ( rule__SecondLevelA__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:103:1: ( ( rule__SecondLevelA__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:103:1: ( ( rule__SecondLevelA__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:104:1: ( rule__SecondLevelA__Group__0 )
            {
             before(grammarAccess.getSecondLevelAAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:105:1: ( rule__SecondLevelA__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:105:2: rule__SecondLevelA__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__SecondLevelA__Group__0_in_ruleSecondLevelA154);
            rule__SecondLevelA__Group__0();
            _fsp--;


            }

             after(grammarAccess.getSecondLevelAAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleSecondLevelA


    // $ANTLR start entryRuleSecondLevelB
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:117:1: entryRuleSecondLevelB : ruleSecondLevelB EOF ;
    public final void entryRuleSecondLevelB() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:118:1: ( ruleSecondLevelB EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:119:1: ruleSecondLevelB EOF
            {
             before(grammarAccess.getSecondLevelBRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSecondLevelB_in_entryRuleSecondLevelB181);
            ruleSecondLevelB();
            _fsp--;

             after(grammarAccess.getSecondLevelBRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSecondLevelB188); 

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
    // $ANTLR end entryRuleSecondLevelB


    // $ANTLR start ruleSecondLevelB
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:126:1: ruleSecondLevelB : ( ( rule__SecondLevelB__Group__0 ) ) ;
    public final void ruleSecondLevelB() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:130:2: ( ( ( rule__SecondLevelB__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:131:1: ( ( rule__SecondLevelB__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:131:1: ( ( rule__SecondLevelB__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:132:1: ( rule__SecondLevelB__Group__0 )
            {
             before(grammarAccess.getSecondLevelBAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:133:1: ( rule__SecondLevelB__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:133:2: rule__SecondLevelB__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__SecondLevelB__Group__0_in_ruleSecondLevelB214);
            rule__SecondLevelB__Group__0();
            _fsp--;


            }

             after(grammarAccess.getSecondLevelBAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleSecondLevelB


    // $ANTLR start entryRuleThirdLevelA1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:145:1: entryRuleThirdLevelA1 : ruleThirdLevelA1 EOF ;
    public final void entryRuleThirdLevelA1() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:146:1: ( ruleThirdLevelA1 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:147:1: ruleThirdLevelA1 EOF
            {
             before(grammarAccess.getThirdLevelA1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleThirdLevelA1_in_entryRuleThirdLevelA1241);
            ruleThirdLevelA1();
            _fsp--;

             after(grammarAccess.getThirdLevelA1Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleThirdLevelA1248); 

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
    // $ANTLR end entryRuleThirdLevelA1


    // $ANTLR start ruleThirdLevelA1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:154:1: ruleThirdLevelA1 : ( ( rule__ThirdLevelA1__Group__0 ) ) ;
    public final void ruleThirdLevelA1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:158:2: ( ( ( rule__ThirdLevelA1__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:159:1: ( ( rule__ThirdLevelA1__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:159:1: ( ( rule__ThirdLevelA1__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:160:1: ( rule__ThirdLevelA1__Group__0 )
            {
             before(grammarAccess.getThirdLevelA1Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:161:1: ( rule__ThirdLevelA1__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:161:2: rule__ThirdLevelA1__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelA1__Group__0_in_ruleThirdLevelA1274);
            rule__ThirdLevelA1__Group__0();
            _fsp--;


            }

             after(grammarAccess.getThirdLevelA1Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleThirdLevelA1


    // $ANTLR start entryRuleThirdLevelA2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:173:1: entryRuleThirdLevelA2 : ruleThirdLevelA2 EOF ;
    public final void entryRuleThirdLevelA2() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:174:1: ( ruleThirdLevelA2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:175:1: ruleThirdLevelA2 EOF
            {
             before(grammarAccess.getThirdLevelA2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleThirdLevelA2_in_entryRuleThirdLevelA2301);
            ruleThirdLevelA2();
            _fsp--;

             after(grammarAccess.getThirdLevelA2Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleThirdLevelA2308); 

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
    // $ANTLR end entryRuleThirdLevelA2


    // $ANTLR start ruleThirdLevelA2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:182:1: ruleThirdLevelA2 : ( ( rule__ThirdLevelA2__Group__0 ) ) ;
    public final void ruleThirdLevelA2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:186:2: ( ( ( rule__ThirdLevelA2__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:187:1: ( ( rule__ThirdLevelA2__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:187:1: ( ( rule__ThirdLevelA2__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:188:1: ( rule__ThirdLevelA2__Group__0 )
            {
             before(grammarAccess.getThirdLevelA2Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:189:1: ( rule__ThirdLevelA2__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:189:2: rule__ThirdLevelA2__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelA2__Group__0_in_ruleThirdLevelA2334);
            rule__ThirdLevelA2__Group__0();
            _fsp--;


            }

             after(grammarAccess.getThirdLevelA2Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleThirdLevelA2


    // $ANTLR start entryRuleThirdLevelB1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:201:1: entryRuleThirdLevelB1 : ruleThirdLevelB1 EOF ;
    public final void entryRuleThirdLevelB1() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:202:1: ( ruleThirdLevelB1 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:203:1: ruleThirdLevelB1 EOF
            {
             before(grammarAccess.getThirdLevelB1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleThirdLevelB1_in_entryRuleThirdLevelB1361);
            ruleThirdLevelB1();
            _fsp--;

             after(grammarAccess.getThirdLevelB1Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleThirdLevelB1368); 

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
    // $ANTLR end entryRuleThirdLevelB1


    // $ANTLR start ruleThirdLevelB1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:210:1: ruleThirdLevelB1 : ( ( rule__ThirdLevelB1__Group__0 ) ) ;
    public final void ruleThirdLevelB1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:214:2: ( ( ( rule__ThirdLevelB1__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:215:1: ( ( rule__ThirdLevelB1__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:215:1: ( ( rule__ThirdLevelB1__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:216:1: ( rule__ThirdLevelB1__Group__0 )
            {
             before(grammarAccess.getThirdLevelB1Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:217:1: ( rule__ThirdLevelB1__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:217:2: rule__ThirdLevelB1__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelB1__Group__0_in_ruleThirdLevelB1394);
            rule__ThirdLevelB1__Group__0();
            _fsp--;


            }

             after(grammarAccess.getThirdLevelB1Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleThirdLevelB1


    // $ANTLR start entryRuleThirdLevelB2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:229:1: entryRuleThirdLevelB2 : ruleThirdLevelB2 EOF ;
    public final void entryRuleThirdLevelB2() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:230:1: ( ruleThirdLevelB2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:231:1: ruleThirdLevelB2 EOF
            {
             before(grammarAccess.getThirdLevelB2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleThirdLevelB2_in_entryRuleThirdLevelB2421);
            ruleThirdLevelB2();
            _fsp--;

             after(grammarAccess.getThirdLevelB2Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleThirdLevelB2428); 

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
    // $ANTLR end entryRuleThirdLevelB2


    // $ANTLR start ruleThirdLevelB2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:238:1: ruleThirdLevelB2 : ( ( rule__ThirdLevelB2__Group__0 ) ) ;
    public final void ruleThirdLevelB2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:242:2: ( ( ( rule__ThirdLevelB2__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:243:1: ( ( rule__ThirdLevelB2__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:243:1: ( ( rule__ThirdLevelB2__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:244:1: ( rule__ThirdLevelB2__Group__0 )
            {
             before(grammarAccess.getThirdLevelB2Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:245:1: ( rule__ThirdLevelB2__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:245:2: rule__ThirdLevelB2__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelB2__Group__0_in_ruleThirdLevelB2454);
            rule__ThirdLevelB2__Group__0();
            _fsp--;


            }

             after(grammarAccess.getThirdLevelB2Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleThirdLevelB2


    // $ANTLR start rule__FirstLevel__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:259:1: rule__FirstLevel__Group__0 : rule__FirstLevel__Group__0__Impl rule__FirstLevel__Group__1 ;
    public final void rule__FirstLevel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:263:1: ( rule__FirstLevel__Group__0__Impl rule__FirstLevel__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:264:2: rule__FirstLevel__Group__0__Impl rule__FirstLevel__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FirstLevel__Group__0__Impl_in_rule__FirstLevel__Group__0488);
            rule__FirstLevel__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__FirstLevel__Group__1_in_rule__FirstLevel__Group__0491);
            rule__FirstLevel__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FirstLevel__Group__0


    // $ANTLR start rule__FirstLevel__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:271:1: rule__FirstLevel__Group__0__Impl : ( ( rule__FirstLevel__SecondLevelAAssignment_0 )* ) ;
    public final void rule__FirstLevel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:275:1: ( ( ( rule__FirstLevel__SecondLevelAAssignment_0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:276:1: ( ( rule__FirstLevel__SecondLevelAAssignment_0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:276:1: ( ( rule__FirstLevel__SecondLevelAAssignment_0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:277:1: ( rule__FirstLevel__SecondLevelAAssignment_0 )*
            {
             before(grammarAccess.getFirstLevelAccess().getSecondLevelAAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:278:1: ( rule__FirstLevel__SecondLevelAAssignment_0 )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:278:2: rule__FirstLevel__SecondLevelAAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__FirstLevel__SecondLevelAAssignment_0_in_rule__FirstLevel__Group__0__Impl518);
            	    rule__FirstLevel__SecondLevelAAssignment_0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getFirstLevelAccess().getSecondLevelAAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FirstLevel__Group__0__Impl


    // $ANTLR start rule__FirstLevel__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:288:1: rule__FirstLevel__Group__1 : rule__FirstLevel__Group__1__Impl ;
    public final void rule__FirstLevel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:292:1: ( rule__FirstLevel__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:293:2: rule__FirstLevel__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__FirstLevel__Group__1__Impl_in_rule__FirstLevel__Group__1549);
            rule__FirstLevel__Group__1__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FirstLevel__Group__1


    // $ANTLR start rule__FirstLevel__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:299:1: rule__FirstLevel__Group__1__Impl : ( ( rule__FirstLevel__SecondLevelBAssignment_1 )* ) ;
    public final void rule__FirstLevel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:303:1: ( ( ( rule__FirstLevel__SecondLevelBAssignment_1 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:304:1: ( ( rule__FirstLevel__SecondLevelBAssignment_1 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:304:1: ( ( rule__FirstLevel__SecondLevelBAssignment_1 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:305:1: ( rule__FirstLevel__SecondLevelBAssignment_1 )*
            {
             before(grammarAccess.getFirstLevelAccess().getSecondLevelBAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:306:1: ( rule__FirstLevel__SecondLevelBAssignment_1 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:306:2: rule__FirstLevel__SecondLevelBAssignment_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__FirstLevel__SecondLevelBAssignment_1_in_rule__FirstLevel__Group__1__Impl576);
            	    rule__FirstLevel__SecondLevelBAssignment_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getFirstLevelAccess().getSecondLevelBAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FirstLevel__Group__1__Impl


    // $ANTLR start rule__SecondLevelA__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:320:1: rule__SecondLevelA__Group__0 : rule__SecondLevelA__Group__0__Impl rule__SecondLevelA__Group__1 ;
    public final void rule__SecondLevelA__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:324:1: ( rule__SecondLevelA__Group__0__Impl rule__SecondLevelA__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:325:2: rule__SecondLevelA__Group__0__Impl rule__SecondLevelA__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__SecondLevelA__Group__0__Impl_in_rule__SecondLevelA__Group__0611);
            rule__SecondLevelA__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__SecondLevelA__Group__1_in_rule__SecondLevelA__Group__0614);
            rule__SecondLevelA__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SecondLevelA__Group__0


    // $ANTLR start rule__SecondLevelA__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:332:1: rule__SecondLevelA__Group__0__Impl : ( ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 ) ) ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )* ) ) ;
    public final void rule__SecondLevelA__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:336:1: ( ( ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 ) ) ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:337:1: ( ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 ) ) ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:337:1: ( ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 ) ) ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:338:1: ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 ) ) ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:338:1: ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:339:1: ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )
            {
             before(grammarAccess.getSecondLevelAAccess().getThirdLevelA1Assignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:340:1: ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:340:2: rule__SecondLevelA__ThirdLevelA1Assignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__SecondLevelA__ThirdLevelA1Assignment_0_in_rule__SecondLevelA__Group__0__Impl643);
            rule__SecondLevelA__ThirdLevelA1Assignment_0();
            _fsp--;


            }

             after(grammarAccess.getSecondLevelAAccess().getThirdLevelA1Assignment_0()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:343:1: ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:344:1: ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )*
            {
             before(grammarAccess.getSecondLevelAAccess().getThirdLevelA1Assignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:345:1: ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==11) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:345:2: rule__SecondLevelA__ThirdLevelA1Assignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__SecondLevelA__ThirdLevelA1Assignment_0_in_rule__SecondLevelA__Group__0__Impl655);
            	    rule__SecondLevelA__ThirdLevelA1Assignment_0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getSecondLevelAAccess().getThirdLevelA1Assignment_0()); 

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
    // $ANTLR end rule__SecondLevelA__Group__0__Impl


    // $ANTLR start rule__SecondLevelA__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:356:1: rule__SecondLevelA__Group__1 : rule__SecondLevelA__Group__1__Impl ;
    public final void rule__SecondLevelA__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:360:1: ( rule__SecondLevelA__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:361:2: rule__SecondLevelA__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__SecondLevelA__Group__1__Impl_in_rule__SecondLevelA__Group__1688);
            rule__SecondLevelA__Group__1__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SecondLevelA__Group__1


    // $ANTLR start rule__SecondLevelA__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:367:1: rule__SecondLevelA__Group__1__Impl : ( ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 ) ) ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )* ) ) ;
    public final void rule__SecondLevelA__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:371:1: ( ( ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 ) ) ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:372:1: ( ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 ) ) ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:372:1: ( ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 ) ) ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:373:1: ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 ) ) ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:373:1: ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:374:1: ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )
            {
             before(grammarAccess.getSecondLevelAAccess().getThirdLevelA2Assignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:375:1: ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:375:2: rule__SecondLevelA__ThirdLevelA2Assignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__SecondLevelA__ThirdLevelA2Assignment_1_in_rule__SecondLevelA__Group__1__Impl717);
            rule__SecondLevelA__ThirdLevelA2Assignment_1();
            _fsp--;


            }

             after(grammarAccess.getSecondLevelAAccess().getThirdLevelA2Assignment_1()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:378:1: ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:379:1: ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )*
            {
             before(grammarAccess.getSecondLevelAAccess().getThirdLevelA2Assignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:380:1: ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==12) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:380:2: rule__SecondLevelA__ThirdLevelA2Assignment_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__SecondLevelA__ThirdLevelA2Assignment_1_in_rule__SecondLevelA__Group__1__Impl729);
            	    rule__SecondLevelA__ThirdLevelA2Assignment_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getSecondLevelAAccess().getThirdLevelA2Assignment_1()); 

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
    // $ANTLR end rule__SecondLevelA__Group__1__Impl


    // $ANTLR start rule__SecondLevelB__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:395:1: rule__SecondLevelB__Group__0 : rule__SecondLevelB__Group__0__Impl rule__SecondLevelB__Group__1 ;
    public final void rule__SecondLevelB__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:399:1: ( rule__SecondLevelB__Group__0__Impl rule__SecondLevelB__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:400:2: rule__SecondLevelB__Group__0__Impl rule__SecondLevelB__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__SecondLevelB__Group__0__Impl_in_rule__SecondLevelB__Group__0766);
            rule__SecondLevelB__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__SecondLevelB__Group__1_in_rule__SecondLevelB__Group__0769);
            rule__SecondLevelB__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SecondLevelB__Group__0


    // $ANTLR start rule__SecondLevelB__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:407:1: rule__SecondLevelB__Group__0__Impl : ( ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 ) ) ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )* ) ) ;
    public final void rule__SecondLevelB__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:411:1: ( ( ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 ) ) ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:412:1: ( ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 ) ) ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:412:1: ( ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 ) ) ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:413:1: ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 ) ) ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:413:1: ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:414:1: ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )
            {
             before(grammarAccess.getSecondLevelBAccess().getThirdLevelB1Assignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:415:1: ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:415:2: rule__SecondLevelB__ThirdLevelB1Assignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__SecondLevelB__ThirdLevelB1Assignment_0_in_rule__SecondLevelB__Group__0__Impl798);
            rule__SecondLevelB__ThirdLevelB1Assignment_0();
            _fsp--;


            }

             after(grammarAccess.getSecondLevelBAccess().getThirdLevelB1Assignment_0()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:418:1: ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:419:1: ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )*
            {
             before(grammarAccess.getSecondLevelBAccess().getThirdLevelB1Assignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:420:1: ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==13) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:420:2: rule__SecondLevelB__ThirdLevelB1Assignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__SecondLevelB__ThirdLevelB1Assignment_0_in_rule__SecondLevelB__Group__0__Impl810);
            	    rule__SecondLevelB__ThirdLevelB1Assignment_0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getSecondLevelBAccess().getThirdLevelB1Assignment_0()); 

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
    // $ANTLR end rule__SecondLevelB__Group__0__Impl


    // $ANTLR start rule__SecondLevelB__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:431:1: rule__SecondLevelB__Group__1 : rule__SecondLevelB__Group__1__Impl ;
    public final void rule__SecondLevelB__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:435:1: ( rule__SecondLevelB__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:436:2: rule__SecondLevelB__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__SecondLevelB__Group__1__Impl_in_rule__SecondLevelB__Group__1843);
            rule__SecondLevelB__Group__1__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SecondLevelB__Group__1


    // $ANTLR start rule__SecondLevelB__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:442:1: rule__SecondLevelB__Group__1__Impl : ( ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 ) ) ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )* ) ) ;
    public final void rule__SecondLevelB__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:446:1: ( ( ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 ) ) ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:447:1: ( ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 ) ) ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:447:1: ( ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 ) ) ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:448:1: ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 ) ) ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:448:1: ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:449:1: ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )
            {
             before(grammarAccess.getSecondLevelBAccess().getThirdLevelB2Assignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:450:1: ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:450:2: rule__SecondLevelB__ThirdLevelB2Assignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__SecondLevelB__ThirdLevelB2Assignment_1_in_rule__SecondLevelB__Group__1__Impl872);
            rule__SecondLevelB__ThirdLevelB2Assignment_1();
            _fsp--;


            }

             after(grammarAccess.getSecondLevelBAccess().getThirdLevelB2Assignment_1()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:453:1: ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:454:1: ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )*
            {
             before(grammarAccess.getSecondLevelBAccess().getThirdLevelB2Assignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:455:1: ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==14) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:455:2: rule__SecondLevelB__ThirdLevelB2Assignment_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__SecondLevelB__ThirdLevelB2Assignment_1_in_rule__SecondLevelB__Group__1__Impl884);
            	    rule__SecondLevelB__ThirdLevelB2Assignment_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getSecondLevelBAccess().getThirdLevelB2Assignment_1()); 

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
    // $ANTLR end rule__SecondLevelB__Group__1__Impl


    // $ANTLR start rule__ThirdLevelA1__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:470:1: rule__ThirdLevelA1__Group__0 : rule__ThirdLevelA1__Group__0__Impl rule__ThirdLevelA1__Group__1 ;
    public final void rule__ThirdLevelA1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:474:1: ( rule__ThirdLevelA1__Group__0__Impl rule__ThirdLevelA1__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:475:2: rule__ThirdLevelA1__Group__0__Impl rule__ThirdLevelA1__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelA1__Group__0__Impl_in_rule__ThirdLevelA1__Group__0921);
            rule__ThirdLevelA1__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelA1__Group__1_in_rule__ThirdLevelA1__Group__0924);
            rule__ThirdLevelA1__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ThirdLevelA1__Group__0


    // $ANTLR start rule__ThirdLevelA1__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:482:1: rule__ThirdLevelA1__Group__0__Impl : ( 'A1' ) ;
    public final void rule__ThirdLevelA1__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:486:1: ( ( 'A1' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:487:1: ( 'A1' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:487:1: ( 'A1' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:488:1: 'A1'
            {
             before(grammarAccess.getThirdLevelA1Access().getA1Keyword_0()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__ThirdLevelA1__Group__0__Impl952); 
             after(grammarAccess.getThirdLevelA1Access().getA1Keyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ThirdLevelA1__Group__0__Impl


    // $ANTLR start rule__ThirdLevelA1__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:501:1: rule__ThirdLevelA1__Group__1 : rule__ThirdLevelA1__Group__1__Impl rule__ThirdLevelA1__Group__2 ;
    public final void rule__ThirdLevelA1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:505:1: ( rule__ThirdLevelA1__Group__1__Impl rule__ThirdLevelA1__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:506:2: rule__ThirdLevelA1__Group__1__Impl rule__ThirdLevelA1__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelA1__Group__1__Impl_in_rule__ThirdLevelA1__Group__1983);
            rule__ThirdLevelA1__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelA1__Group__2_in_rule__ThirdLevelA1__Group__1986);
            rule__ThirdLevelA1__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ThirdLevelA1__Group__1


    // $ANTLR start rule__ThirdLevelA1__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:513:1: rule__ThirdLevelA1__Group__1__Impl : ( () ) ;
    public final void rule__ThirdLevelA1__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:517:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:518:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:518:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:519:1: ()
            {
             before(grammarAccess.getThirdLevelA1Access().getThirdLevelA1Action_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:520:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:522:1: 
            {
            }

             after(grammarAccess.getThirdLevelA1Access().getThirdLevelA1Action_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ThirdLevelA1__Group__1__Impl


    // $ANTLR start rule__ThirdLevelA1__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:532:1: rule__ThirdLevelA1__Group__2 : rule__ThirdLevelA1__Group__2__Impl ;
    public final void rule__ThirdLevelA1__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:536:1: ( rule__ThirdLevelA1__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:537:2: rule__ThirdLevelA1__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelA1__Group__2__Impl_in_rule__ThirdLevelA1__Group__21044);
            rule__ThirdLevelA1__Group__2__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ThirdLevelA1__Group__2


    // $ANTLR start rule__ThirdLevelA1__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:543:1: rule__ThirdLevelA1__Group__2__Impl : ( ( rule__ThirdLevelA1__NameAssignment_2 )? ) ;
    public final void rule__ThirdLevelA1__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:547:1: ( ( ( rule__ThirdLevelA1__NameAssignment_2 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:548:1: ( ( rule__ThirdLevelA1__NameAssignment_2 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:548:1: ( ( rule__ThirdLevelA1__NameAssignment_2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:549:1: ( rule__ThirdLevelA1__NameAssignment_2 )?
            {
             before(grammarAccess.getThirdLevelA1Access().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:550:1: ( rule__ThirdLevelA1__NameAssignment_2 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:550:2: rule__ThirdLevelA1__NameAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelA1__NameAssignment_2_in_rule__ThirdLevelA1__Group__2__Impl1071);
                    rule__ThirdLevelA1__NameAssignment_2();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getThirdLevelA1Access().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ThirdLevelA1__Group__2__Impl


    // $ANTLR start rule__ThirdLevelA2__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:566:1: rule__ThirdLevelA2__Group__0 : rule__ThirdLevelA2__Group__0__Impl rule__ThirdLevelA2__Group__1 ;
    public final void rule__ThirdLevelA2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:570:1: ( rule__ThirdLevelA2__Group__0__Impl rule__ThirdLevelA2__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:571:2: rule__ThirdLevelA2__Group__0__Impl rule__ThirdLevelA2__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelA2__Group__0__Impl_in_rule__ThirdLevelA2__Group__01108);
            rule__ThirdLevelA2__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelA2__Group__1_in_rule__ThirdLevelA2__Group__01111);
            rule__ThirdLevelA2__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ThirdLevelA2__Group__0


    // $ANTLR start rule__ThirdLevelA2__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:578:1: rule__ThirdLevelA2__Group__0__Impl : ( 'A2' ) ;
    public final void rule__ThirdLevelA2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:582:1: ( ( 'A2' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:583:1: ( 'A2' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:583:1: ( 'A2' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:584:1: 'A2'
            {
             before(grammarAccess.getThirdLevelA2Access().getA2Keyword_0()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__ThirdLevelA2__Group__0__Impl1139); 
             after(grammarAccess.getThirdLevelA2Access().getA2Keyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ThirdLevelA2__Group__0__Impl


    // $ANTLR start rule__ThirdLevelA2__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:597:1: rule__ThirdLevelA2__Group__1 : rule__ThirdLevelA2__Group__1__Impl rule__ThirdLevelA2__Group__2 ;
    public final void rule__ThirdLevelA2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:601:1: ( rule__ThirdLevelA2__Group__1__Impl rule__ThirdLevelA2__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:602:2: rule__ThirdLevelA2__Group__1__Impl rule__ThirdLevelA2__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelA2__Group__1__Impl_in_rule__ThirdLevelA2__Group__11170);
            rule__ThirdLevelA2__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelA2__Group__2_in_rule__ThirdLevelA2__Group__11173);
            rule__ThirdLevelA2__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ThirdLevelA2__Group__1


    // $ANTLR start rule__ThirdLevelA2__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:609:1: rule__ThirdLevelA2__Group__1__Impl : ( () ) ;
    public final void rule__ThirdLevelA2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:613:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:614:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:614:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:615:1: ()
            {
             before(grammarAccess.getThirdLevelA2Access().getThirdLevelA2Action_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:616:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:618:1: 
            {
            }

             after(grammarAccess.getThirdLevelA2Access().getThirdLevelA2Action_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ThirdLevelA2__Group__1__Impl


    // $ANTLR start rule__ThirdLevelA2__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:628:1: rule__ThirdLevelA2__Group__2 : rule__ThirdLevelA2__Group__2__Impl ;
    public final void rule__ThirdLevelA2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:632:1: ( rule__ThirdLevelA2__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:633:2: rule__ThirdLevelA2__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelA2__Group__2__Impl_in_rule__ThirdLevelA2__Group__21231);
            rule__ThirdLevelA2__Group__2__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ThirdLevelA2__Group__2


    // $ANTLR start rule__ThirdLevelA2__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:639:1: rule__ThirdLevelA2__Group__2__Impl : ( ( rule__ThirdLevelA2__NameAssignment_2 )? ) ;
    public final void rule__ThirdLevelA2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:643:1: ( ( ( rule__ThirdLevelA2__NameAssignment_2 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:644:1: ( ( rule__ThirdLevelA2__NameAssignment_2 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:644:1: ( ( rule__ThirdLevelA2__NameAssignment_2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:645:1: ( rule__ThirdLevelA2__NameAssignment_2 )?
            {
             before(grammarAccess.getThirdLevelA2Access().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:646:1: ( rule__ThirdLevelA2__NameAssignment_2 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:646:2: rule__ThirdLevelA2__NameAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelA2__NameAssignment_2_in_rule__ThirdLevelA2__Group__2__Impl1258);
                    rule__ThirdLevelA2__NameAssignment_2();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getThirdLevelA2Access().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ThirdLevelA2__Group__2__Impl


    // $ANTLR start rule__ThirdLevelB1__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:662:1: rule__ThirdLevelB1__Group__0 : rule__ThirdLevelB1__Group__0__Impl rule__ThirdLevelB1__Group__1 ;
    public final void rule__ThirdLevelB1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:666:1: ( rule__ThirdLevelB1__Group__0__Impl rule__ThirdLevelB1__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:667:2: rule__ThirdLevelB1__Group__0__Impl rule__ThirdLevelB1__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelB1__Group__0__Impl_in_rule__ThirdLevelB1__Group__01295);
            rule__ThirdLevelB1__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelB1__Group__1_in_rule__ThirdLevelB1__Group__01298);
            rule__ThirdLevelB1__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ThirdLevelB1__Group__0


    // $ANTLR start rule__ThirdLevelB1__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:674:1: rule__ThirdLevelB1__Group__0__Impl : ( 'B1' ) ;
    public final void rule__ThirdLevelB1__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:678:1: ( ( 'B1' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:679:1: ( 'B1' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:679:1: ( 'B1' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:680:1: 'B1'
            {
             before(grammarAccess.getThirdLevelB1Access().getB1Keyword_0()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__ThirdLevelB1__Group__0__Impl1326); 
             after(grammarAccess.getThirdLevelB1Access().getB1Keyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ThirdLevelB1__Group__0__Impl


    // $ANTLR start rule__ThirdLevelB1__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:693:1: rule__ThirdLevelB1__Group__1 : rule__ThirdLevelB1__Group__1__Impl rule__ThirdLevelB1__Group__2 ;
    public final void rule__ThirdLevelB1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:697:1: ( rule__ThirdLevelB1__Group__1__Impl rule__ThirdLevelB1__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:698:2: rule__ThirdLevelB1__Group__1__Impl rule__ThirdLevelB1__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelB1__Group__1__Impl_in_rule__ThirdLevelB1__Group__11357);
            rule__ThirdLevelB1__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelB1__Group__2_in_rule__ThirdLevelB1__Group__11360);
            rule__ThirdLevelB1__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ThirdLevelB1__Group__1


    // $ANTLR start rule__ThirdLevelB1__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:705:1: rule__ThirdLevelB1__Group__1__Impl : ( () ) ;
    public final void rule__ThirdLevelB1__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:709:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:710:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:710:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:711:1: ()
            {
             before(grammarAccess.getThirdLevelB1Access().getThirdLevelB1Action_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:712:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:714:1: 
            {
            }

             after(grammarAccess.getThirdLevelB1Access().getThirdLevelB1Action_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ThirdLevelB1__Group__1__Impl


    // $ANTLR start rule__ThirdLevelB1__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:724:1: rule__ThirdLevelB1__Group__2 : rule__ThirdLevelB1__Group__2__Impl ;
    public final void rule__ThirdLevelB1__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:728:1: ( rule__ThirdLevelB1__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:729:2: rule__ThirdLevelB1__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelB1__Group__2__Impl_in_rule__ThirdLevelB1__Group__21418);
            rule__ThirdLevelB1__Group__2__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ThirdLevelB1__Group__2


    // $ANTLR start rule__ThirdLevelB1__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:735:1: rule__ThirdLevelB1__Group__2__Impl : ( ( rule__ThirdLevelB1__NameAssignment_2 )? ) ;
    public final void rule__ThirdLevelB1__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:739:1: ( ( ( rule__ThirdLevelB1__NameAssignment_2 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:740:1: ( ( rule__ThirdLevelB1__NameAssignment_2 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:740:1: ( ( rule__ThirdLevelB1__NameAssignment_2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:741:1: ( rule__ThirdLevelB1__NameAssignment_2 )?
            {
             before(grammarAccess.getThirdLevelB1Access().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:742:1: ( rule__ThirdLevelB1__NameAssignment_2 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:742:2: rule__ThirdLevelB1__NameAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelB1__NameAssignment_2_in_rule__ThirdLevelB1__Group__2__Impl1445);
                    rule__ThirdLevelB1__NameAssignment_2();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getThirdLevelB1Access().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ThirdLevelB1__Group__2__Impl


    // $ANTLR start rule__ThirdLevelB2__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:758:1: rule__ThirdLevelB2__Group__0 : rule__ThirdLevelB2__Group__0__Impl rule__ThirdLevelB2__Group__1 ;
    public final void rule__ThirdLevelB2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:762:1: ( rule__ThirdLevelB2__Group__0__Impl rule__ThirdLevelB2__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:763:2: rule__ThirdLevelB2__Group__0__Impl rule__ThirdLevelB2__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelB2__Group__0__Impl_in_rule__ThirdLevelB2__Group__01482);
            rule__ThirdLevelB2__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelB2__Group__1_in_rule__ThirdLevelB2__Group__01485);
            rule__ThirdLevelB2__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ThirdLevelB2__Group__0


    // $ANTLR start rule__ThirdLevelB2__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:770:1: rule__ThirdLevelB2__Group__0__Impl : ( 'B2' ) ;
    public final void rule__ThirdLevelB2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:774:1: ( ( 'B2' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:775:1: ( 'B2' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:775:1: ( 'B2' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:776:1: 'B2'
            {
             before(grammarAccess.getThirdLevelB2Access().getB2Keyword_0()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__ThirdLevelB2__Group__0__Impl1513); 
             after(grammarAccess.getThirdLevelB2Access().getB2Keyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ThirdLevelB2__Group__0__Impl


    // $ANTLR start rule__ThirdLevelB2__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:789:1: rule__ThirdLevelB2__Group__1 : rule__ThirdLevelB2__Group__1__Impl rule__ThirdLevelB2__Group__2 ;
    public final void rule__ThirdLevelB2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:793:1: ( rule__ThirdLevelB2__Group__1__Impl rule__ThirdLevelB2__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:794:2: rule__ThirdLevelB2__Group__1__Impl rule__ThirdLevelB2__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelB2__Group__1__Impl_in_rule__ThirdLevelB2__Group__11544);
            rule__ThirdLevelB2__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelB2__Group__2_in_rule__ThirdLevelB2__Group__11547);
            rule__ThirdLevelB2__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ThirdLevelB2__Group__1


    // $ANTLR start rule__ThirdLevelB2__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:801:1: rule__ThirdLevelB2__Group__1__Impl : ( () ) ;
    public final void rule__ThirdLevelB2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:805:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:806:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:806:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:807:1: ()
            {
             before(grammarAccess.getThirdLevelB2Access().getThirdLevelB2Action_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:808:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:810:1: 
            {
            }

             after(grammarAccess.getThirdLevelB2Access().getThirdLevelB2Action_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ThirdLevelB2__Group__1__Impl


    // $ANTLR start rule__ThirdLevelB2__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:820:1: rule__ThirdLevelB2__Group__2 : rule__ThirdLevelB2__Group__2__Impl ;
    public final void rule__ThirdLevelB2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:824:1: ( rule__ThirdLevelB2__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:825:2: rule__ThirdLevelB2__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelB2__Group__2__Impl_in_rule__ThirdLevelB2__Group__21605);
            rule__ThirdLevelB2__Group__2__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ThirdLevelB2__Group__2


    // $ANTLR start rule__ThirdLevelB2__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:831:1: rule__ThirdLevelB2__Group__2__Impl : ( ( rule__ThirdLevelB2__NameAssignment_2 )? ) ;
    public final void rule__ThirdLevelB2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:835:1: ( ( ( rule__ThirdLevelB2__NameAssignment_2 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:836:1: ( ( rule__ThirdLevelB2__NameAssignment_2 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:836:1: ( ( rule__ThirdLevelB2__NameAssignment_2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:837:1: ( rule__ThirdLevelB2__NameAssignment_2 )?
            {
             before(grammarAccess.getThirdLevelB2Access().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:838:1: ( rule__ThirdLevelB2__NameAssignment_2 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:838:2: rule__ThirdLevelB2__NameAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelB2__NameAssignment_2_in_rule__ThirdLevelB2__Group__2__Impl1632);
                    rule__ThirdLevelB2__NameAssignment_2();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getThirdLevelB2Access().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ThirdLevelB2__Group__2__Impl


    // $ANTLR start rule__FirstLevel__SecondLevelAAssignment_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:855:1: rule__FirstLevel__SecondLevelAAssignment_0 : ( ruleSecondLevelA ) ;
    public final void rule__FirstLevel__SecondLevelAAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:859:1: ( ( ruleSecondLevelA ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:860:1: ( ruleSecondLevelA )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:860:1: ( ruleSecondLevelA )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:861:1: ruleSecondLevelA
            {
             before(grammarAccess.getFirstLevelAccess().getSecondLevelASecondLevelAParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSecondLevelA_in_rule__FirstLevel__SecondLevelAAssignment_01674);
            ruleSecondLevelA();
            _fsp--;

             after(grammarAccess.getFirstLevelAccess().getSecondLevelASecondLevelAParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FirstLevel__SecondLevelAAssignment_0


    // $ANTLR start rule__FirstLevel__SecondLevelBAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:870:1: rule__FirstLevel__SecondLevelBAssignment_1 : ( ruleSecondLevelB ) ;
    public final void rule__FirstLevel__SecondLevelBAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:874:1: ( ( ruleSecondLevelB ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:875:1: ( ruleSecondLevelB )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:875:1: ( ruleSecondLevelB )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:876:1: ruleSecondLevelB
            {
             before(grammarAccess.getFirstLevelAccess().getSecondLevelBSecondLevelBParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSecondLevelB_in_rule__FirstLevel__SecondLevelBAssignment_11705);
            ruleSecondLevelB();
            _fsp--;

             after(grammarAccess.getFirstLevelAccess().getSecondLevelBSecondLevelBParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FirstLevel__SecondLevelBAssignment_1


    // $ANTLR start rule__SecondLevelA__ThirdLevelA1Assignment_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:885:1: rule__SecondLevelA__ThirdLevelA1Assignment_0 : ( ruleThirdLevelA1 ) ;
    public final void rule__SecondLevelA__ThirdLevelA1Assignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:889:1: ( ( ruleThirdLevelA1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:890:1: ( ruleThirdLevelA1 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:890:1: ( ruleThirdLevelA1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:891:1: ruleThirdLevelA1
            {
             before(grammarAccess.getSecondLevelAAccess().getThirdLevelA1ThirdLevelA1ParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleThirdLevelA1_in_rule__SecondLevelA__ThirdLevelA1Assignment_01736);
            ruleThirdLevelA1();
            _fsp--;

             after(grammarAccess.getSecondLevelAAccess().getThirdLevelA1ThirdLevelA1ParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SecondLevelA__ThirdLevelA1Assignment_0


    // $ANTLR start rule__SecondLevelA__ThirdLevelA2Assignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:900:1: rule__SecondLevelA__ThirdLevelA2Assignment_1 : ( ruleThirdLevelA2 ) ;
    public final void rule__SecondLevelA__ThirdLevelA2Assignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:904:1: ( ( ruleThirdLevelA2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:905:1: ( ruleThirdLevelA2 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:905:1: ( ruleThirdLevelA2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:906:1: ruleThirdLevelA2
            {
             before(grammarAccess.getSecondLevelAAccess().getThirdLevelA2ThirdLevelA2ParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleThirdLevelA2_in_rule__SecondLevelA__ThirdLevelA2Assignment_11767);
            ruleThirdLevelA2();
            _fsp--;

             after(grammarAccess.getSecondLevelAAccess().getThirdLevelA2ThirdLevelA2ParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SecondLevelA__ThirdLevelA2Assignment_1


    // $ANTLR start rule__SecondLevelB__ThirdLevelB1Assignment_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:915:1: rule__SecondLevelB__ThirdLevelB1Assignment_0 : ( ruleThirdLevelB1 ) ;
    public final void rule__SecondLevelB__ThirdLevelB1Assignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:919:1: ( ( ruleThirdLevelB1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:920:1: ( ruleThirdLevelB1 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:920:1: ( ruleThirdLevelB1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:921:1: ruleThirdLevelB1
            {
             before(grammarAccess.getSecondLevelBAccess().getThirdLevelB1ThirdLevelB1ParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleThirdLevelB1_in_rule__SecondLevelB__ThirdLevelB1Assignment_01798);
            ruleThirdLevelB1();
            _fsp--;

             after(grammarAccess.getSecondLevelBAccess().getThirdLevelB1ThirdLevelB1ParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SecondLevelB__ThirdLevelB1Assignment_0


    // $ANTLR start rule__SecondLevelB__ThirdLevelB2Assignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:930:1: rule__SecondLevelB__ThirdLevelB2Assignment_1 : ( ruleThirdLevelB2 ) ;
    public final void rule__SecondLevelB__ThirdLevelB2Assignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:934:1: ( ( ruleThirdLevelB2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:935:1: ( ruleThirdLevelB2 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:935:1: ( ruleThirdLevelB2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:936:1: ruleThirdLevelB2
            {
             before(grammarAccess.getSecondLevelBAccess().getThirdLevelB2ThirdLevelB2ParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleThirdLevelB2_in_rule__SecondLevelB__ThirdLevelB2Assignment_11829);
            ruleThirdLevelB2();
            _fsp--;

             after(grammarAccess.getSecondLevelBAccess().getThirdLevelB2ThirdLevelB2ParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SecondLevelB__ThirdLevelB2Assignment_1


    // $ANTLR start rule__ThirdLevelA1__NameAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:945:1: rule__ThirdLevelA1__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ThirdLevelA1__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:949:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:950:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:950:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:951:1: RULE_ID
            {
             before(grammarAccess.getThirdLevelA1Access().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ThirdLevelA1__NameAssignment_21860); 
             after(grammarAccess.getThirdLevelA1Access().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ThirdLevelA1__NameAssignment_2


    // $ANTLR start rule__ThirdLevelA2__NameAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:960:1: rule__ThirdLevelA2__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ThirdLevelA2__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:964:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:965:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:965:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:966:1: RULE_ID
            {
             before(grammarAccess.getThirdLevelA2Access().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ThirdLevelA2__NameAssignment_21891); 
             after(grammarAccess.getThirdLevelA2Access().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ThirdLevelA2__NameAssignment_2


    // $ANTLR start rule__ThirdLevelB1__NameAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:975:1: rule__ThirdLevelB1__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ThirdLevelB1__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:979:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:980:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:980:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:981:1: RULE_ID
            {
             before(grammarAccess.getThirdLevelB1Access().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ThirdLevelB1__NameAssignment_21922); 
             after(grammarAccess.getThirdLevelB1Access().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ThirdLevelB1__NameAssignment_2


    // $ANTLR start rule__ThirdLevelB2__NameAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:990:1: rule__ThirdLevelB2__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ThirdLevelB2__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:994:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:995:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:995:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:996:1: RULE_ID
            {
             before(grammarAccess.getThirdLevelB2Access().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ThirdLevelB2__NameAssignment_21953); 
             after(grammarAccess.getThirdLevelB2Access().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ThirdLevelB2__NameAssignment_2


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleFirstLevel_in_entryRuleFirstLevel61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFirstLevel68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FirstLevel__Group__0_in_ruleFirstLevel94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSecondLevelA_in_entryRuleSecondLevelA121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSecondLevelA128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SecondLevelA__Group__0_in_ruleSecondLevelA154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSecondLevelB_in_entryRuleSecondLevelB181 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSecondLevelB188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SecondLevelB__Group__0_in_ruleSecondLevelB214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleThirdLevelA1_in_entryRuleThirdLevelA1241 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleThirdLevelA1248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ThirdLevelA1__Group__0_in_ruleThirdLevelA1274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleThirdLevelA2_in_entryRuleThirdLevelA2301 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleThirdLevelA2308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ThirdLevelA2__Group__0_in_ruleThirdLevelA2334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleThirdLevelB1_in_entryRuleThirdLevelB1361 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleThirdLevelB1368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ThirdLevelB1__Group__0_in_ruleThirdLevelB1394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleThirdLevelB2_in_entryRuleThirdLevelB2421 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleThirdLevelB2428 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ThirdLevelB2__Group__0_in_ruleThirdLevelB2454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FirstLevel__Group__0__Impl_in_rule__FirstLevel__Group__0488 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_rule__FirstLevel__Group__1_in_rule__FirstLevel__Group__0491 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FirstLevel__SecondLevelAAssignment_0_in_rule__FirstLevel__Group__0__Impl518 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_rule__FirstLevel__Group__1__Impl_in_rule__FirstLevel__Group__1549 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FirstLevel__SecondLevelBAssignment_1_in_rule__FirstLevel__Group__1__Impl576 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_rule__SecondLevelA__Group__0__Impl_in_rule__SecondLevelA__Group__0611 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rule__SecondLevelA__Group__1_in_rule__SecondLevelA__Group__0614 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SecondLevelA__ThirdLevelA1Assignment_0_in_rule__SecondLevelA__Group__0__Impl643 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_rule__SecondLevelA__ThirdLevelA1Assignment_0_in_rule__SecondLevelA__Group__0__Impl655 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_rule__SecondLevelA__Group__1__Impl_in_rule__SecondLevelA__Group__1688 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SecondLevelA__ThirdLevelA2Assignment_1_in_rule__SecondLevelA__Group__1__Impl717 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_rule__SecondLevelA__ThirdLevelA2Assignment_1_in_rule__SecondLevelA__Group__1__Impl729 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_rule__SecondLevelB__Group__0__Impl_in_rule__SecondLevelB__Group__0766 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__SecondLevelB__Group__1_in_rule__SecondLevelB__Group__0769 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SecondLevelB__ThirdLevelB1Assignment_0_in_rule__SecondLevelB__Group__0__Impl798 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_rule__SecondLevelB__ThirdLevelB1Assignment_0_in_rule__SecondLevelB__Group__0__Impl810 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_rule__SecondLevelB__Group__1__Impl_in_rule__SecondLevelB__Group__1843 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SecondLevelB__ThirdLevelB2Assignment_1_in_rule__SecondLevelB__Group__1__Impl872 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_rule__SecondLevelB__ThirdLevelB2Assignment_1_in_rule__SecondLevelB__Group__1__Impl884 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_rule__ThirdLevelA1__Group__0__Impl_in_rule__ThirdLevelA1__Group__0921 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__ThirdLevelA1__Group__1_in_rule__ThirdLevelA1__Group__0924 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__ThirdLevelA1__Group__0__Impl952 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ThirdLevelA1__Group__1__Impl_in_rule__ThirdLevelA1__Group__1983 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__ThirdLevelA1__Group__2_in_rule__ThirdLevelA1__Group__1986 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ThirdLevelA1__Group__2__Impl_in_rule__ThirdLevelA1__Group__21044 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ThirdLevelA1__NameAssignment_2_in_rule__ThirdLevelA1__Group__2__Impl1071 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ThirdLevelA2__Group__0__Impl_in_rule__ThirdLevelA2__Group__01108 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__ThirdLevelA2__Group__1_in_rule__ThirdLevelA2__Group__01111 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__ThirdLevelA2__Group__0__Impl1139 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ThirdLevelA2__Group__1__Impl_in_rule__ThirdLevelA2__Group__11170 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__ThirdLevelA2__Group__2_in_rule__ThirdLevelA2__Group__11173 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ThirdLevelA2__Group__2__Impl_in_rule__ThirdLevelA2__Group__21231 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ThirdLevelA2__NameAssignment_2_in_rule__ThirdLevelA2__Group__2__Impl1258 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ThirdLevelB1__Group__0__Impl_in_rule__ThirdLevelB1__Group__01295 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__ThirdLevelB1__Group__1_in_rule__ThirdLevelB1__Group__01298 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__ThirdLevelB1__Group__0__Impl1326 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ThirdLevelB1__Group__1__Impl_in_rule__ThirdLevelB1__Group__11357 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__ThirdLevelB1__Group__2_in_rule__ThirdLevelB1__Group__11360 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ThirdLevelB1__Group__2__Impl_in_rule__ThirdLevelB1__Group__21418 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ThirdLevelB1__NameAssignment_2_in_rule__ThirdLevelB1__Group__2__Impl1445 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ThirdLevelB2__Group__0__Impl_in_rule__ThirdLevelB2__Group__01482 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__ThirdLevelB2__Group__1_in_rule__ThirdLevelB2__Group__01485 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__ThirdLevelB2__Group__0__Impl1513 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ThirdLevelB2__Group__1__Impl_in_rule__ThirdLevelB2__Group__11544 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__ThirdLevelB2__Group__2_in_rule__ThirdLevelB2__Group__11547 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ThirdLevelB2__Group__2__Impl_in_rule__ThirdLevelB2__Group__21605 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ThirdLevelB2__NameAssignment_2_in_rule__ThirdLevelB2__Group__2__Impl1632 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSecondLevelA_in_rule__FirstLevel__SecondLevelAAssignment_01674 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSecondLevelB_in_rule__FirstLevel__SecondLevelBAssignment_11705 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleThirdLevelA1_in_rule__SecondLevelA__ThirdLevelA1Assignment_01736 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleThirdLevelA2_in_rule__SecondLevelA__ThirdLevelA2Assignment_11767 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleThirdLevelB1_in_rule__SecondLevelB__ThirdLevelB1Assignment_01798 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleThirdLevelB2_in_rule__SecondLevelB__ThirdLevelB2Assignment_11829 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ThirdLevelA1__NameAssignment_21860 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ThirdLevelA2__NameAssignment_21891 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ThirdLevelB1__NameAssignment_21922 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ThirdLevelB2__NameAssignment_21953 = new BitSet(new long[]{0x0000000000000002L});
    }


}
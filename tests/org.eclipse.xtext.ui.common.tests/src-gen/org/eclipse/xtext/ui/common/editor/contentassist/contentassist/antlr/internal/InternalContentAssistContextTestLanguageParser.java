package org.eclipse.xtext.ui.common.editor.contentassist.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.common.editor.contentassist.services.ContentAssistContextTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalContentAssistContextTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'A1'", "'A2'", "'B1'", "'B2'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalContentAssistContextTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g"; }


     
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:60:1: entryRuleFirstLevel : ruleFirstLevel EOF ;
    public final void entryRuleFirstLevel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:61:1: ( ruleFirstLevel EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:62:1: ruleFirstLevel EOF
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:69:1: ruleFirstLevel : ( ( rule__FirstLevel__Group__0 ) ) ;
    public final void ruleFirstLevel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:73:2: ( ( ( rule__FirstLevel__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:74:1: ( ( rule__FirstLevel__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:74:1: ( ( rule__FirstLevel__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:75:1: ( rule__FirstLevel__Group__0 )
            {
             before(grammarAccess.getFirstLevelAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:76:1: ( rule__FirstLevel__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:76:2: rule__FirstLevel__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__FirstLevel__Group__0_in_ruleFirstLevel95);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:88:1: entryRuleSecondLevelA : ruleSecondLevelA EOF ;
    public final void entryRuleSecondLevelA() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:89:1: ( ruleSecondLevelA EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:90:1: ruleSecondLevelA EOF
            {
             before(grammarAccess.getSecondLevelARule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSecondLevelA_in_entryRuleSecondLevelA122);
            ruleSecondLevelA();
            _fsp--;

             after(grammarAccess.getSecondLevelARule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSecondLevelA129); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:97:1: ruleSecondLevelA : ( ( rule__SecondLevelA__Group__0 ) ) ;
    public final void ruleSecondLevelA() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:101:2: ( ( ( rule__SecondLevelA__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:102:1: ( ( rule__SecondLevelA__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:102:1: ( ( rule__SecondLevelA__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:103:1: ( rule__SecondLevelA__Group__0 )
            {
             before(grammarAccess.getSecondLevelAAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:104:1: ( rule__SecondLevelA__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:104:2: rule__SecondLevelA__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__SecondLevelA__Group__0_in_ruleSecondLevelA156);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:116:1: entryRuleSecondLevelB : ruleSecondLevelB EOF ;
    public final void entryRuleSecondLevelB() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:117:1: ( ruleSecondLevelB EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:118:1: ruleSecondLevelB EOF
            {
             before(grammarAccess.getSecondLevelBRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSecondLevelB_in_entryRuleSecondLevelB183);
            ruleSecondLevelB();
            _fsp--;

             after(grammarAccess.getSecondLevelBRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSecondLevelB190); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:125:1: ruleSecondLevelB : ( ( rule__SecondLevelB__Group__0 ) ) ;
    public final void ruleSecondLevelB() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:129:2: ( ( ( rule__SecondLevelB__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:130:1: ( ( rule__SecondLevelB__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:130:1: ( ( rule__SecondLevelB__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:131:1: ( rule__SecondLevelB__Group__0 )
            {
             before(grammarAccess.getSecondLevelBAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:132:1: ( rule__SecondLevelB__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:132:2: rule__SecondLevelB__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__SecondLevelB__Group__0_in_ruleSecondLevelB217);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:144:1: entryRuleThirdLevelA1 : ruleThirdLevelA1 EOF ;
    public final void entryRuleThirdLevelA1() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:145:1: ( ruleThirdLevelA1 EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:146:1: ruleThirdLevelA1 EOF
            {
             before(grammarAccess.getThirdLevelA1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleThirdLevelA1_in_entryRuleThirdLevelA1244);
            ruleThirdLevelA1();
            _fsp--;

             after(grammarAccess.getThirdLevelA1Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleThirdLevelA1251); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:153:1: ruleThirdLevelA1 : ( ( rule__ThirdLevelA1__Group__0 ) ) ;
    public final void ruleThirdLevelA1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:157:2: ( ( ( rule__ThirdLevelA1__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:158:1: ( ( rule__ThirdLevelA1__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:158:1: ( ( rule__ThirdLevelA1__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:159:1: ( rule__ThirdLevelA1__Group__0 )
            {
             before(grammarAccess.getThirdLevelA1Access().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:160:1: ( rule__ThirdLevelA1__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:160:2: rule__ThirdLevelA1__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelA1__Group__0_in_ruleThirdLevelA1278);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:172:1: entryRuleThirdLevelA2 : ruleThirdLevelA2 EOF ;
    public final void entryRuleThirdLevelA2() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:173:1: ( ruleThirdLevelA2 EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:174:1: ruleThirdLevelA2 EOF
            {
             before(grammarAccess.getThirdLevelA2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleThirdLevelA2_in_entryRuleThirdLevelA2305);
            ruleThirdLevelA2();
            _fsp--;

             after(grammarAccess.getThirdLevelA2Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleThirdLevelA2312); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:181:1: ruleThirdLevelA2 : ( ( rule__ThirdLevelA2__Group__0 ) ) ;
    public final void ruleThirdLevelA2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:185:2: ( ( ( rule__ThirdLevelA2__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:186:1: ( ( rule__ThirdLevelA2__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:186:1: ( ( rule__ThirdLevelA2__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:187:1: ( rule__ThirdLevelA2__Group__0 )
            {
             before(grammarAccess.getThirdLevelA2Access().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:188:1: ( rule__ThirdLevelA2__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:188:2: rule__ThirdLevelA2__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelA2__Group__0_in_ruleThirdLevelA2339);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:200:1: entryRuleThirdLevelB1 : ruleThirdLevelB1 EOF ;
    public final void entryRuleThirdLevelB1() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:201:1: ( ruleThirdLevelB1 EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:202:1: ruleThirdLevelB1 EOF
            {
             before(grammarAccess.getThirdLevelB1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleThirdLevelB1_in_entryRuleThirdLevelB1366);
            ruleThirdLevelB1();
            _fsp--;

             after(grammarAccess.getThirdLevelB1Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleThirdLevelB1373); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:209:1: ruleThirdLevelB1 : ( ( rule__ThirdLevelB1__Group__0 ) ) ;
    public final void ruleThirdLevelB1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:213:2: ( ( ( rule__ThirdLevelB1__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:214:1: ( ( rule__ThirdLevelB1__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:214:1: ( ( rule__ThirdLevelB1__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:215:1: ( rule__ThirdLevelB1__Group__0 )
            {
             before(grammarAccess.getThirdLevelB1Access().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:216:1: ( rule__ThirdLevelB1__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:216:2: rule__ThirdLevelB1__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelB1__Group__0_in_ruleThirdLevelB1400);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:228:1: entryRuleThirdLevelB2 : ruleThirdLevelB2 EOF ;
    public final void entryRuleThirdLevelB2() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:229:1: ( ruleThirdLevelB2 EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:230:1: ruleThirdLevelB2 EOF
            {
             before(grammarAccess.getThirdLevelB2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleThirdLevelB2_in_entryRuleThirdLevelB2427);
            ruleThirdLevelB2();
            _fsp--;

             after(grammarAccess.getThirdLevelB2Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleThirdLevelB2434); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:237:1: ruleThirdLevelB2 : ( ( rule__ThirdLevelB2__Group__0 ) ) ;
    public final void ruleThirdLevelB2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:241:2: ( ( ( rule__ThirdLevelB2__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:242:1: ( ( rule__ThirdLevelB2__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:242:1: ( ( rule__ThirdLevelB2__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:243:1: ( rule__ThirdLevelB2__Group__0 )
            {
             before(grammarAccess.getThirdLevelB2Access().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:244:1: ( rule__ThirdLevelB2__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:244:2: rule__ThirdLevelB2__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelB2__Group__0_in_ruleThirdLevelB2461);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:258:1: rule__FirstLevel__Group__0 : ( ( rule__FirstLevel__SecondLevelAAssignment_0 )* ) rule__FirstLevel__Group__1 ;
    public final void rule__FirstLevel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:262:1: ( ( ( rule__FirstLevel__SecondLevelAAssignment_0 )* ) rule__FirstLevel__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:263:1: ( ( rule__FirstLevel__SecondLevelAAssignment_0 )* ) rule__FirstLevel__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:263:1: ( ( rule__FirstLevel__SecondLevelAAssignment_0 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:264:1: ( rule__FirstLevel__SecondLevelAAssignment_0 )*
            {
             before(grammarAccess.getFirstLevelAccess().getSecondLevelAAssignment_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:265:1: ( rule__FirstLevel__SecondLevelAAssignment_0 )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:265:2: rule__FirstLevel__SecondLevelAAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__FirstLevel__SecondLevelAAssignment_0_in_rule__FirstLevel__Group__0499);
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

            pushFollow(FollowSets000.FOLLOW_rule__FirstLevel__Group__1_in_rule__FirstLevel__Group__0509);
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


    // $ANTLR start rule__FirstLevel__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:276:1: rule__FirstLevel__Group__1 : ( ( rule__FirstLevel__SecondLevelBAssignment_1 )* ) ;
    public final void rule__FirstLevel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:280:1: ( ( ( rule__FirstLevel__SecondLevelBAssignment_1 )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:281:1: ( ( rule__FirstLevel__SecondLevelBAssignment_1 )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:281:1: ( ( rule__FirstLevel__SecondLevelBAssignment_1 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:282:1: ( rule__FirstLevel__SecondLevelBAssignment_1 )*
            {
             before(grammarAccess.getFirstLevelAccess().getSecondLevelBAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:283:1: ( rule__FirstLevel__SecondLevelBAssignment_1 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:283:2: rule__FirstLevel__SecondLevelBAssignment_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__FirstLevel__SecondLevelBAssignment_1_in_rule__FirstLevel__Group__1537);
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
    // $ANTLR end rule__FirstLevel__Group__1


    // $ANTLR start rule__SecondLevelA__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:297:1: rule__SecondLevelA__Group__0 : ( ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 ) ) ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )* ) ) rule__SecondLevelA__Group__1 ;
    public final void rule__SecondLevelA__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:301:1: ( ( ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 ) ) ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )* ) ) rule__SecondLevelA__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:302:1: ( ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 ) ) ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )* ) ) rule__SecondLevelA__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:302:1: ( ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 ) ) ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:303:1: ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 ) ) ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:303:1: ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:304:1: ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )
            {
             before(grammarAccess.getSecondLevelAAccess().getThirdLevelA1Assignment_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:305:1: ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:305:2: rule__SecondLevelA__ThirdLevelA1Assignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__SecondLevelA__ThirdLevelA1Assignment_0_in_rule__SecondLevelA__Group__0578);
            rule__SecondLevelA__ThirdLevelA1Assignment_0();
            _fsp--;


            }

             after(grammarAccess.getSecondLevelAAccess().getThirdLevelA1Assignment_0()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:308:1: ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:309:1: ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )*
            {
             before(grammarAccess.getSecondLevelAAccess().getThirdLevelA1Assignment_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:310:1: ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==11) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:310:2: rule__SecondLevelA__ThirdLevelA1Assignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__SecondLevelA__ThirdLevelA1Assignment_0_in_rule__SecondLevelA__Group__0590);
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

            pushFollow(FollowSets000.FOLLOW_rule__SecondLevelA__Group__1_in_rule__SecondLevelA__Group__0602);
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


    // $ANTLR start rule__SecondLevelA__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:322:1: rule__SecondLevelA__Group__1 : ( ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 ) ) ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )* ) ) ;
    public final void rule__SecondLevelA__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:326:1: ( ( ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 ) ) ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )* ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:327:1: ( ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 ) ) ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )* ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:327:1: ( ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 ) ) ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:328:1: ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 ) ) ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:328:1: ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:329:1: ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )
            {
             before(grammarAccess.getSecondLevelAAccess().getThirdLevelA2Assignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:330:1: ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:330:2: rule__SecondLevelA__ThirdLevelA2Assignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__SecondLevelA__ThirdLevelA2Assignment_1_in_rule__SecondLevelA__Group__1632);
            rule__SecondLevelA__ThirdLevelA2Assignment_1();
            _fsp--;


            }

             after(grammarAccess.getSecondLevelAAccess().getThirdLevelA2Assignment_1()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:333:1: ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:334:1: ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )*
            {
             before(grammarAccess.getSecondLevelAAccess().getThirdLevelA2Assignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:335:1: ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==12) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:335:2: rule__SecondLevelA__ThirdLevelA2Assignment_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__SecondLevelA__ThirdLevelA2Assignment_1_in_rule__SecondLevelA__Group__1644);
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
    // $ANTLR end rule__SecondLevelA__Group__1


    // $ANTLR start rule__SecondLevelB__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:350:1: rule__SecondLevelB__Group__0 : ( ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 ) ) ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )* ) ) rule__SecondLevelB__Group__1 ;
    public final void rule__SecondLevelB__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:354:1: ( ( ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 ) ) ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )* ) ) rule__SecondLevelB__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:355:1: ( ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 ) ) ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )* ) ) rule__SecondLevelB__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:355:1: ( ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 ) ) ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:356:1: ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 ) ) ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:356:1: ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:357:1: ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )
            {
             before(grammarAccess.getSecondLevelBAccess().getThirdLevelB1Assignment_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:358:1: ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:358:2: rule__SecondLevelB__ThirdLevelB1Assignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__SecondLevelB__ThirdLevelB1Assignment_0_in_rule__SecondLevelB__Group__0687);
            rule__SecondLevelB__ThirdLevelB1Assignment_0();
            _fsp--;


            }

             after(grammarAccess.getSecondLevelBAccess().getThirdLevelB1Assignment_0()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:361:1: ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:362:1: ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )*
            {
             before(grammarAccess.getSecondLevelBAccess().getThirdLevelB1Assignment_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:363:1: ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==13) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:363:2: rule__SecondLevelB__ThirdLevelB1Assignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__SecondLevelB__ThirdLevelB1Assignment_0_in_rule__SecondLevelB__Group__0699);
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

            pushFollow(FollowSets000.FOLLOW_rule__SecondLevelB__Group__1_in_rule__SecondLevelB__Group__0711);
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


    // $ANTLR start rule__SecondLevelB__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:375:1: rule__SecondLevelB__Group__1 : ( ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 ) ) ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )* ) ) ;
    public final void rule__SecondLevelB__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:379:1: ( ( ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 ) ) ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )* ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:380:1: ( ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 ) ) ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )* ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:380:1: ( ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 ) ) ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:381:1: ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 ) ) ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:381:1: ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:382:1: ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )
            {
             before(grammarAccess.getSecondLevelBAccess().getThirdLevelB2Assignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:383:1: ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:383:2: rule__SecondLevelB__ThirdLevelB2Assignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__SecondLevelB__ThirdLevelB2Assignment_1_in_rule__SecondLevelB__Group__1741);
            rule__SecondLevelB__ThirdLevelB2Assignment_1();
            _fsp--;


            }

             after(grammarAccess.getSecondLevelBAccess().getThirdLevelB2Assignment_1()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:386:1: ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:387:1: ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )*
            {
             before(grammarAccess.getSecondLevelBAccess().getThirdLevelB2Assignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:388:1: ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==14) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:388:2: rule__SecondLevelB__ThirdLevelB2Assignment_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__SecondLevelB__ThirdLevelB2Assignment_1_in_rule__SecondLevelB__Group__1753);
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
    // $ANTLR end rule__SecondLevelB__Group__1


    // $ANTLR start rule__ThirdLevelA1__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:403:1: rule__ThirdLevelA1__Group__0 : ( 'A1' ) rule__ThirdLevelA1__Group__1 ;
    public final void rule__ThirdLevelA1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:407:1: ( ( 'A1' ) rule__ThirdLevelA1__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:408:1: ( 'A1' ) rule__ThirdLevelA1__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:408:1: ( 'A1' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:409:1: 'A1'
            {
             before(grammarAccess.getThirdLevelA1Access().getA1Keyword_0()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__ThirdLevelA1__Group__0795); 
             after(grammarAccess.getThirdLevelA1Access().getA1Keyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelA1__Group__1_in_rule__ThirdLevelA1__Group__0805);
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


    // $ANTLR start rule__ThirdLevelA1__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:423:1: rule__ThirdLevelA1__Group__1 : ( () ) rule__ThirdLevelA1__Group__2 ;
    public final void rule__ThirdLevelA1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:427:1: ( ( () ) rule__ThirdLevelA1__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:428:1: ( () ) rule__ThirdLevelA1__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:428:1: ( () )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:429:1: ()
            {
             before(grammarAccess.getThirdLevelA1Access().getThirdLevelA1Action_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:430:1: ()
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:432:1: 
            {
            }

             after(grammarAccess.getThirdLevelA1Access().getThirdLevelA1Action_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelA1__Group__2_in_rule__ThirdLevelA1__Group__1843);
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


    // $ANTLR start rule__ThirdLevelA1__Group__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:443:1: rule__ThirdLevelA1__Group__2 : ( ( rule__ThirdLevelA1__NameAssignment_2 )? ) ;
    public final void rule__ThirdLevelA1__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:447:1: ( ( ( rule__ThirdLevelA1__NameAssignment_2 )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:448:1: ( ( rule__ThirdLevelA1__NameAssignment_2 )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:448:1: ( ( rule__ThirdLevelA1__NameAssignment_2 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:449:1: ( rule__ThirdLevelA1__NameAssignment_2 )?
            {
             before(grammarAccess.getThirdLevelA1Access().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:450:1: ( rule__ThirdLevelA1__NameAssignment_2 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:450:2: rule__ThirdLevelA1__NameAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelA1__NameAssignment_2_in_rule__ThirdLevelA1__Group__2871);
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
    // $ANTLR end rule__ThirdLevelA1__Group__2


    // $ANTLR start rule__ThirdLevelA2__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:466:1: rule__ThirdLevelA2__Group__0 : ( 'A2' ) rule__ThirdLevelA2__Group__1 ;
    public final void rule__ThirdLevelA2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:470:1: ( ( 'A2' ) rule__ThirdLevelA2__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:471:1: ( 'A2' ) rule__ThirdLevelA2__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:471:1: ( 'A2' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:472:1: 'A2'
            {
             before(grammarAccess.getThirdLevelA2Access().getA2Keyword_0()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__ThirdLevelA2__Group__0913); 
             after(grammarAccess.getThirdLevelA2Access().getA2Keyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelA2__Group__1_in_rule__ThirdLevelA2__Group__0923);
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


    // $ANTLR start rule__ThirdLevelA2__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:486:1: rule__ThirdLevelA2__Group__1 : ( () ) rule__ThirdLevelA2__Group__2 ;
    public final void rule__ThirdLevelA2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:490:1: ( ( () ) rule__ThirdLevelA2__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:491:1: ( () ) rule__ThirdLevelA2__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:491:1: ( () )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:492:1: ()
            {
             before(grammarAccess.getThirdLevelA2Access().getThirdLevelA2Action_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:493:1: ()
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:495:1: 
            {
            }

             after(grammarAccess.getThirdLevelA2Access().getThirdLevelA2Action_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelA2__Group__2_in_rule__ThirdLevelA2__Group__1961);
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


    // $ANTLR start rule__ThirdLevelA2__Group__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:506:1: rule__ThirdLevelA2__Group__2 : ( ( rule__ThirdLevelA2__NameAssignment_2 )? ) ;
    public final void rule__ThirdLevelA2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:510:1: ( ( ( rule__ThirdLevelA2__NameAssignment_2 )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:511:1: ( ( rule__ThirdLevelA2__NameAssignment_2 )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:511:1: ( ( rule__ThirdLevelA2__NameAssignment_2 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:512:1: ( rule__ThirdLevelA2__NameAssignment_2 )?
            {
             before(grammarAccess.getThirdLevelA2Access().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:513:1: ( rule__ThirdLevelA2__NameAssignment_2 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:513:2: rule__ThirdLevelA2__NameAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelA2__NameAssignment_2_in_rule__ThirdLevelA2__Group__2989);
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
    // $ANTLR end rule__ThirdLevelA2__Group__2


    // $ANTLR start rule__ThirdLevelB1__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:529:1: rule__ThirdLevelB1__Group__0 : ( 'B1' ) rule__ThirdLevelB1__Group__1 ;
    public final void rule__ThirdLevelB1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:533:1: ( ( 'B1' ) rule__ThirdLevelB1__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:534:1: ( 'B1' ) rule__ThirdLevelB1__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:534:1: ( 'B1' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:535:1: 'B1'
            {
             before(grammarAccess.getThirdLevelB1Access().getB1Keyword_0()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__ThirdLevelB1__Group__01031); 
             after(grammarAccess.getThirdLevelB1Access().getB1Keyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelB1__Group__1_in_rule__ThirdLevelB1__Group__01041);
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


    // $ANTLR start rule__ThirdLevelB1__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:549:1: rule__ThirdLevelB1__Group__1 : ( () ) rule__ThirdLevelB1__Group__2 ;
    public final void rule__ThirdLevelB1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:553:1: ( ( () ) rule__ThirdLevelB1__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:554:1: ( () ) rule__ThirdLevelB1__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:554:1: ( () )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:555:1: ()
            {
             before(grammarAccess.getThirdLevelB1Access().getThirdLevelB1Action_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:556:1: ()
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:558:1: 
            {
            }

             after(grammarAccess.getThirdLevelB1Access().getThirdLevelB1Action_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelB1__Group__2_in_rule__ThirdLevelB1__Group__11079);
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


    // $ANTLR start rule__ThirdLevelB1__Group__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:569:1: rule__ThirdLevelB1__Group__2 : ( ( rule__ThirdLevelB1__NameAssignment_2 )? ) ;
    public final void rule__ThirdLevelB1__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:573:1: ( ( ( rule__ThirdLevelB1__NameAssignment_2 )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:574:1: ( ( rule__ThirdLevelB1__NameAssignment_2 )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:574:1: ( ( rule__ThirdLevelB1__NameAssignment_2 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:575:1: ( rule__ThirdLevelB1__NameAssignment_2 )?
            {
             before(grammarAccess.getThirdLevelB1Access().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:576:1: ( rule__ThirdLevelB1__NameAssignment_2 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:576:2: rule__ThirdLevelB1__NameAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelB1__NameAssignment_2_in_rule__ThirdLevelB1__Group__21107);
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
    // $ANTLR end rule__ThirdLevelB1__Group__2


    // $ANTLR start rule__ThirdLevelB2__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:592:1: rule__ThirdLevelB2__Group__0 : ( 'B2' ) rule__ThirdLevelB2__Group__1 ;
    public final void rule__ThirdLevelB2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:596:1: ( ( 'B2' ) rule__ThirdLevelB2__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:597:1: ( 'B2' ) rule__ThirdLevelB2__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:597:1: ( 'B2' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:598:1: 'B2'
            {
             before(grammarAccess.getThirdLevelB2Access().getB2Keyword_0()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__ThirdLevelB2__Group__01149); 
             after(grammarAccess.getThirdLevelB2Access().getB2Keyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelB2__Group__1_in_rule__ThirdLevelB2__Group__01159);
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


    // $ANTLR start rule__ThirdLevelB2__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:612:1: rule__ThirdLevelB2__Group__1 : ( () ) rule__ThirdLevelB2__Group__2 ;
    public final void rule__ThirdLevelB2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:616:1: ( ( () ) rule__ThirdLevelB2__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:617:1: ( () ) rule__ThirdLevelB2__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:617:1: ( () )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:618:1: ()
            {
             before(grammarAccess.getThirdLevelB2Access().getThirdLevelB2Action_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:619:1: ()
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:621:1: 
            {
            }

             after(grammarAccess.getThirdLevelB2Access().getThirdLevelB2Action_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelB2__Group__2_in_rule__ThirdLevelB2__Group__11197);
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


    // $ANTLR start rule__ThirdLevelB2__Group__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:632:1: rule__ThirdLevelB2__Group__2 : ( ( rule__ThirdLevelB2__NameAssignment_2 )? ) ;
    public final void rule__ThirdLevelB2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:636:1: ( ( ( rule__ThirdLevelB2__NameAssignment_2 )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:637:1: ( ( rule__ThirdLevelB2__NameAssignment_2 )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:637:1: ( ( rule__ThirdLevelB2__NameAssignment_2 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:638:1: ( rule__ThirdLevelB2__NameAssignment_2 )?
            {
             before(grammarAccess.getThirdLevelB2Access().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:639:1: ( rule__ThirdLevelB2__NameAssignment_2 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:639:2: rule__ThirdLevelB2__NameAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ThirdLevelB2__NameAssignment_2_in_rule__ThirdLevelB2__Group__21225);
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
    // $ANTLR end rule__ThirdLevelB2__Group__2


    // $ANTLR start rule__FirstLevel__SecondLevelAAssignment_0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:655:1: rule__FirstLevel__SecondLevelAAssignment_0 : ( ruleSecondLevelA ) ;
    public final void rule__FirstLevel__SecondLevelAAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:659:1: ( ( ruleSecondLevelA ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:660:1: ( ruleSecondLevelA )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:660:1: ( ruleSecondLevelA )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:661:1: ruleSecondLevelA
            {
             before(grammarAccess.getFirstLevelAccess().getSecondLevelASecondLevelAParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSecondLevelA_in_rule__FirstLevel__SecondLevelAAssignment_01266);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:670:1: rule__FirstLevel__SecondLevelBAssignment_1 : ( ruleSecondLevelB ) ;
    public final void rule__FirstLevel__SecondLevelBAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:674:1: ( ( ruleSecondLevelB ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:675:1: ( ruleSecondLevelB )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:675:1: ( ruleSecondLevelB )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:676:1: ruleSecondLevelB
            {
             before(grammarAccess.getFirstLevelAccess().getSecondLevelBSecondLevelBParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSecondLevelB_in_rule__FirstLevel__SecondLevelBAssignment_11297);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:685:1: rule__SecondLevelA__ThirdLevelA1Assignment_0 : ( ruleThirdLevelA1 ) ;
    public final void rule__SecondLevelA__ThirdLevelA1Assignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:689:1: ( ( ruleThirdLevelA1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:690:1: ( ruleThirdLevelA1 )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:690:1: ( ruleThirdLevelA1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:691:1: ruleThirdLevelA1
            {
             before(grammarAccess.getSecondLevelAAccess().getThirdLevelA1ThirdLevelA1ParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleThirdLevelA1_in_rule__SecondLevelA__ThirdLevelA1Assignment_01328);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:700:1: rule__SecondLevelA__ThirdLevelA2Assignment_1 : ( ruleThirdLevelA2 ) ;
    public final void rule__SecondLevelA__ThirdLevelA2Assignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:704:1: ( ( ruleThirdLevelA2 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:705:1: ( ruleThirdLevelA2 )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:705:1: ( ruleThirdLevelA2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:706:1: ruleThirdLevelA2
            {
             before(grammarAccess.getSecondLevelAAccess().getThirdLevelA2ThirdLevelA2ParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleThirdLevelA2_in_rule__SecondLevelA__ThirdLevelA2Assignment_11359);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:715:1: rule__SecondLevelB__ThirdLevelB1Assignment_0 : ( ruleThirdLevelB1 ) ;
    public final void rule__SecondLevelB__ThirdLevelB1Assignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:719:1: ( ( ruleThirdLevelB1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:720:1: ( ruleThirdLevelB1 )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:720:1: ( ruleThirdLevelB1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:721:1: ruleThirdLevelB1
            {
             before(grammarAccess.getSecondLevelBAccess().getThirdLevelB1ThirdLevelB1ParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleThirdLevelB1_in_rule__SecondLevelB__ThirdLevelB1Assignment_01390);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:730:1: rule__SecondLevelB__ThirdLevelB2Assignment_1 : ( ruleThirdLevelB2 ) ;
    public final void rule__SecondLevelB__ThirdLevelB2Assignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:734:1: ( ( ruleThirdLevelB2 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:735:1: ( ruleThirdLevelB2 )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:735:1: ( ruleThirdLevelB2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:736:1: ruleThirdLevelB2
            {
             before(grammarAccess.getSecondLevelBAccess().getThirdLevelB2ThirdLevelB2ParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleThirdLevelB2_in_rule__SecondLevelB__ThirdLevelB2Assignment_11421);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:745:1: rule__ThirdLevelA1__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ThirdLevelA1__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:749:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:750:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:750:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:751:1: RULE_ID
            {
             before(grammarAccess.getThirdLevelA1Access().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ThirdLevelA1__NameAssignment_21452); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:760:1: rule__ThirdLevelA2__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ThirdLevelA2__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:764:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:765:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:765:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:766:1: RULE_ID
            {
             before(grammarAccess.getThirdLevelA2Access().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ThirdLevelA2__NameAssignment_21483); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:775:1: rule__ThirdLevelB1__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ThirdLevelB1__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:779:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:780:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:780:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:781:1: RULE_ID
            {
             before(grammarAccess.getThirdLevelB1Access().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ThirdLevelB1__NameAssignment_21514); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:790:1: rule__ThirdLevelB2__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ThirdLevelB2__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:794:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:795:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:795:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:796:1: RULE_ID
            {
             before(grammarAccess.getThirdLevelB2Access().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ThirdLevelB2__NameAssignment_21545); 
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
        public static final BitSet FOLLOW_rule__FirstLevel__Group__0_in_ruleFirstLevel95 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSecondLevelA_in_entryRuleSecondLevelA122 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSecondLevelA129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SecondLevelA__Group__0_in_ruleSecondLevelA156 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSecondLevelB_in_entryRuleSecondLevelB183 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSecondLevelB190 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SecondLevelB__Group__0_in_ruleSecondLevelB217 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleThirdLevelA1_in_entryRuleThirdLevelA1244 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleThirdLevelA1251 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ThirdLevelA1__Group__0_in_ruleThirdLevelA1278 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleThirdLevelA2_in_entryRuleThirdLevelA2305 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleThirdLevelA2312 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ThirdLevelA2__Group__0_in_ruleThirdLevelA2339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleThirdLevelB1_in_entryRuleThirdLevelB1366 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleThirdLevelB1373 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ThirdLevelB1__Group__0_in_ruleThirdLevelB1400 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleThirdLevelB2_in_entryRuleThirdLevelB2427 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleThirdLevelB2434 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ThirdLevelB2__Group__0_in_ruleThirdLevelB2461 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FirstLevel__SecondLevelAAssignment_0_in_rule__FirstLevel__Group__0499 = new BitSet(new long[]{0x0000000000002802L});
        public static final BitSet FOLLOW_rule__FirstLevel__Group__1_in_rule__FirstLevel__Group__0509 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FirstLevel__SecondLevelBAssignment_1_in_rule__FirstLevel__Group__1537 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_rule__SecondLevelA__ThirdLevelA1Assignment_0_in_rule__SecondLevelA__Group__0578 = new BitSet(new long[]{0x0000000000001800L});
        public static final BitSet FOLLOW_rule__SecondLevelA__ThirdLevelA1Assignment_0_in_rule__SecondLevelA__Group__0590 = new BitSet(new long[]{0x0000000000001800L});
        public static final BitSet FOLLOW_rule__SecondLevelA__Group__1_in_rule__SecondLevelA__Group__0602 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SecondLevelA__ThirdLevelA2Assignment_1_in_rule__SecondLevelA__Group__1632 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_rule__SecondLevelA__ThirdLevelA2Assignment_1_in_rule__SecondLevelA__Group__1644 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_rule__SecondLevelB__ThirdLevelB1Assignment_0_in_rule__SecondLevelB__Group__0687 = new BitSet(new long[]{0x0000000000006000L});
        public static final BitSet FOLLOW_rule__SecondLevelB__ThirdLevelB1Assignment_0_in_rule__SecondLevelB__Group__0699 = new BitSet(new long[]{0x0000000000006000L});
        public static final BitSet FOLLOW_rule__SecondLevelB__Group__1_in_rule__SecondLevelB__Group__0711 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SecondLevelB__ThirdLevelB2Assignment_1_in_rule__SecondLevelB__Group__1741 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_rule__SecondLevelB__ThirdLevelB2Assignment_1_in_rule__SecondLevelB__Group__1753 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_11_in_rule__ThirdLevelA1__Group__0795 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__ThirdLevelA1__Group__1_in_rule__ThirdLevelA1__Group__0805 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ThirdLevelA1__Group__2_in_rule__ThirdLevelA1__Group__1843 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ThirdLevelA1__NameAssignment_2_in_rule__ThirdLevelA1__Group__2871 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__ThirdLevelA2__Group__0913 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__ThirdLevelA2__Group__1_in_rule__ThirdLevelA2__Group__0923 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ThirdLevelA2__Group__2_in_rule__ThirdLevelA2__Group__1961 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ThirdLevelA2__NameAssignment_2_in_rule__ThirdLevelA2__Group__2989 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__ThirdLevelB1__Group__01031 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__ThirdLevelB1__Group__1_in_rule__ThirdLevelB1__Group__01041 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ThirdLevelB1__Group__2_in_rule__ThirdLevelB1__Group__11079 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ThirdLevelB1__NameAssignment_2_in_rule__ThirdLevelB1__Group__21107 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__ThirdLevelB2__Group__01149 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__ThirdLevelB2__Group__1_in_rule__ThirdLevelB2__Group__01159 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ThirdLevelB2__Group__2_in_rule__ThirdLevelB2__Group__11197 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ThirdLevelB2__NameAssignment_2_in_rule__ThirdLevelB2__Group__21225 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSecondLevelA_in_rule__FirstLevel__SecondLevelAAssignment_01266 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSecondLevelB_in_rule__FirstLevel__SecondLevelBAssignment_11297 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleThirdLevelA1_in_rule__SecondLevelA__ThirdLevelA1Assignment_01328 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleThirdLevelA2_in_rule__SecondLevelA__ThirdLevelA2Assignment_11359 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleThirdLevelB1_in_rule__SecondLevelB__ThirdLevelB1Assignment_01390 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleThirdLevelB2_in_rule__SecondLevelB__ThirdLevelB2Assignment_11421 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ThirdLevelA1__NameAssignment_21452 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ThirdLevelA2__NameAssignment_21483 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ThirdLevelB1__NameAssignment_21514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ThirdLevelB2__NameAssignment_21545 = new BitSet(new long[]{0x0000000000000002L});
    }


}
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
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:60:21: ( ruleFirstLevel EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:61:1: ruleFirstLevel EOF
            {
             before(grammarAccess.getFirstLevelRule()); 
            pushFollow(FOLLOW_ruleFirstLevel_in_entryRuleFirstLevel60);
            ruleFirstLevel();
            _fsp--;

             after(grammarAccess.getFirstLevelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFirstLevel67); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:68:1: ruleFirstLevel : ( ( rule__FirstLevel__Group__0 ) ) ;
    public final void ruleFirstLevel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:72:2: ( ( ( rule__FirstLevel__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:73:1: ( ( rule__FirstLevel__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:73:1: ( ( rule__FirstLevel__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:74:1: ( rule__FirstLevel__Group__0 )
            {
             before(grammarAccess.getFirstLevelAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:75:1: ( rule__FirstLevel__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:75:2: rule__FirstLevel__Group__0
            {
            pushFollow(FOLLOW_rule__FirstLevel__Group__0_in_ruleFirstLevel94);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:87:1: entryRuleSecondLevelA : ruleSecondLevelA EOF ;
    public final void entryRuleSecondLevelA() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:87:23: ( ruleSecondLevelA EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:88:1: ruleSecondLevelA EOF
            {
             before(grammarAccess.getSecondLevelARule()); 
            pushFollow(FOLLOW_ruleSecondLevelA_in_entryRuleSecondLevelA120);
            ruleSecondLevelA();
            _fsp--;

             after(grammarAccess.getSecondLevelARule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSecondLevelA127); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:95:1: ruleSecondLevelA : ( ( rule__SecondLevelA__Group__0 ) ) ;
    public final void ruleSecondLevelA() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:99:2: ( ( ( rule__SecondLevelA__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:100:1: ( ( rule__SecondLevelA__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:100:1: ( ( rule__SecondLevelA__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:101:1: ( rule__SecondLevelA__Group__0 )
            {
             before(grammarAccess.getSecondLevelAAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:102:1: ( rule__SecondLevelA__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:102:2: rule__SecondLevelA__Group__0
            {
            pushFollow(FOLLOW_rule__SecondLevelA__Group__0_in_ruleSecondLevelA154);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:114:1: entryRuleSecondLevelB : ruleSecondLevelB EOF ;
    public final void entryRuleSecondLevelB() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:114:23: ( ruleSecondLevelB EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:115:1: ruleSecondLevelB EOF
            {
             before(grammarAccess.getSecondLevelBRule()); 
            pushFollow(FOLLOW_ruleSecondLevelB_in_entryRuleSecondLevelB180);
            ruleSecondLevelB();
            _fsp--;

             after(grammarAccess.getSecondLevelBRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSecondLevelB187); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:122:1: ruleSecondLevelB : ( ( rule__SecondLevelB__Group__0 ) ) ;
    public final void ruleSecondLevelB() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:126:2: ( ( ( rule__SecondLevelB__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:127:1: ( ( rule__SecondLevelB__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:127:1: ( ( rule__SecondLevelB__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:128:1: ( rule__SecondLevelB__Group__0 )
            {
             before(grammarAccess.getSecondLevelBAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:129:1: ( rule__SecondLevelB__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:129:2: rule__SecondLevelB__Group__0
            {
            pushFollow(FOLLOW_rule__SecondLevelB__Group__0_in_ruleSecondLevelB214);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:141:1: entryRuleThirdLevelA1 : ruleThirdLevelA1 EOF ;
    public final void entryRuleThirdLevelA1() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:141:23: ( ruleThirdLevelA1 EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:142:1: ruleThirdLevelA1 EOF
            {
             before(grammarAccess.getThirdLevelA1Rule()); 
            pushFollow(FOLLOW_ruleThirdLevelA1_in_entryRuleThirdLevelA1240);
            ruleThirdLevelA1();
            _fsp--;

             after(grammarAccess.getThirdLevelA1Rule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleThirdLevelA1247); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:149:1: ruleThirdLevelA1 : ( ( rule__ThirdLevelA1__Group__0 ) ) ;
    public final void ruleThirdLevelA1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:153:2: ( ( ( rule__ThirdLevelA1__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:154:1: ( ( rule__ThirdLevelA1__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:154:1: ( ( rule__ThirdLevelA1__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:155:1: ( rule__ThirdLevelA1__Group__0 )
            {
             before(grammarAccess.getThirdLevelA1Access().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:156:1: ( rule__ThirdLevelA1__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:156:2: rule__ThirdLevelA1__Group__0
            {
            pushFollow(FOLLOW_rule__ThirdLevelA1__Group__0_in_ruleThirdLevelA1274);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:168:1: entryRuleThirdLevelA2 : ruleThirdLevelA2 EOF ;
    public final void entryRuleThirdLevelA2() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:168:23: ( ruleThirdLevelA2 EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:169:1: ruleThirdLevelA2 EOF
            {
             before(grammarAccess.getThirdLevelA2Rule()); 
            pushFollow(FOLLOW_ruleThirdLevelA2_in_entryRuleThirdLevelA2300);
            ruleThirdLevelA2();
            _fsp--;

             after(grammarAccess.getThirdLevelA2Rule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleThirdLevelA2307); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:176:1: ruleThirdLevelA2 : ( ( rule__ThirdLevelA2__Group__0 ) ) ;
    public final void ruleThirdLevelA2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:180:2: ( ( ( rule__ThirdLevelA2__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:181:1: ( ( rule__ThirdLevelA2__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:181:1: ( ( rule__ThirdLevelA2__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:182:1: ( rule__ThirdLevelA2__Group__0 )
            {
             before(grammarAccess.getThirdLevelA2Access().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:183:1: ( rule__ThirdLevelA2__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:183:2: rule__ThirdLevelA2__Group__0
            {
            pushFollow(FOLLOW_rule__ThirdLevelA2__Group__0_in_ruleThirdLevelA2334);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:195:1: entryRuleThirdLevelB1 : ruleThirdLevelB1 EOF ;
    public final void entryRuleThirdLevelB1() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:195:23: ( ruleThirdLevelB1 EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:196:1: ruleThirdLevelB1 EOF
            {
             before(grammarAccess.getThirdLevelB1Rule()); 
            pushFollow(FOLLOW_ruleThirdLevelB1_in_entryRuleThirdLevelB1360);
            ruleThirdLevelB1();
            _fsp--;

             after(grammarAccess.getThirdLevelB1Rule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleThirdLevelB1367); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:203:1: ruleThirdLevelB1 : ( ( rule__ThirdLevelB1__Group__0 ) ) ;
    public final void ruleThirdLevelB1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:207:2: ( ( ( rule__ThirdLevelB1__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:208:1: ( ( rule__ThirdLevelB1__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:208:1: ( ( rule__ThirdLevelB1__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:209:1: ( rule__ThirdLevelB1__Group__0 )
            {
             before(grammarAccess.getThirdLevelB1Access().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:210:1: ( rule__ThirdLevelB1__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:210:2: rule__ThirdLevelB1__Group__0
            {
            pushFollow(FOLLOW_rule__ThirdLevelB1__Group__0_in_ruleThirdLevelB1394);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:222:1: entryRuleThirdLevelB2 : ruleThirdLevelB2 EOF ;
    public final void entryRuleThirdLevelB2() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:222:23: ( ruleThirdLevelB2 EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:223:1: ruleThirdLevelB2 EOF
            {
             before(grammarAccess.getThirdLevelB2Rule()); 
            pushFollow(FOLLOW_ruleThirdLevelB2_in_entryRuleThirdLevelB2420);
            ruleThirdLevelB2();
            _fsp--;

             after(grammarAccess.getThirdLevelB2Rule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleThirdLevelB2427); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:230:1: ruleThirdLevelB2 : ( ( rule__ThirdLevelB2__Group__0 ) ) ;
    public final void ruleThirdLevelB2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:234:2: ( ( ( rule__ThirdLevelB2__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:235:1: ( ( rule__ThirdLevelB2__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:235:1: ( ( rule__ThirdLevelB2__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:236:1: ( rule__ThirdLevelB2__Group__0 )
            {
             before(grammarAccess.getThirdLevelB2Access().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:237:1: ( rule__ThirdLevelB2__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:237:2: rule__ThirdLevelB2__Group__0
            {
            pushFollow(FOLLOW_rule__ThirdLevelB2__Group__0_in_ruleThirdLevelB2454);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:251:1: rule__FirstLevel__Group__0 : ( ( rule__FirstLevel__SecondLevelAAssignment_0 )* ) rule__FirstLevel__Group__1 ;
    public final void rule__FirstLevel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:255:1: ( ( ( rule__FirstLevel__SecondLevelAAssignment_0 )* ) rule__FirstLevel__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:256:1: ( ( rule__FirstLevel__SecondLevelAAssignment_0 )* ) rule__FirstLevel__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:256:1: ( ( rule__FirstLevel__SecondLevelAAssignment_0 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:257:1: ( rule__FirstLevel__SecondLevelAAssignment_0 )*
            {
             before(grammarAccess.getFirstLevelAccess().getSecondLevelAAssignment_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:258:1: ( rule__FirstLevel__SecondLevelAAssignment_0 )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:258:2: rule__FirstLevel__SecondLevelAAssignment_0
            	    {
            	    pushFollow(FOLLOW_rule__FirstLevel__SecondLevelAAssignment_0_in_rule__FirstLevel__Group__0492);
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

            pushFollow(FOLLOW_rule__FirstLevel__Group__1_in_rule__FirstLevel__Group__0502);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:269:1: rule__FirstLevel__Group__1 : ( ( rule__FirstLevel__SecondLevelBAssignment_1 )* ) ;
    public final void rule__FirstLevel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:273:1: ( ( ( rule__FirstLevel__SecondLevelBAssignment_1 )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:274:1: ( ( rule__FirstLevel__SecondLevelBAssignment_1 )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:274:1: ( ( rule__FirstLevel__SecondLevelBAssignment_1 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:275:1: ( rule__FirstLevel__SecondLevelBAssignment_1 )*
            {
             before(grammarAccess.getFirstLevelAccess().getSecondLevelBAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:276:1: ( rule__FirstLevel__SecondLevelBAssignment_1 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:276:2: rule__FirstLevel__SecondLevelBAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__FirstLevel__SecondLevelBAssignment_1_in_rule__FirstLevel__Group__1530);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:290:1: rule__SecondLevelA__Group__0 : ( ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 ) ) ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )* ) ) rule__SecondLevelA__Group__1 ;
    public final void rule__SecondLevelA__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:294:1: ( ( ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 ) ) ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )* ) ) rule__SecondLevelA__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:295:1: ( ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 ) ) ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )* ) ) rule__SecondLevelA__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:295:1: ( ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 ) ) ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:296:1: ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 ) ) ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:296:1: ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:297:1: ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )
            {
             before(grammarAccess.getSecondLevelAAccess().getThirdLevelA1Assignment_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:298:1: ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:298:2: rule__SecondLevelA__ThirdLevelA1Assignment_0
            {
            pushFollow(FOLLOW_rule__SecondLevelA__ThirdLevelA1Assignment_0_in_rule__SecondLevelA__Group__0571);
            rule__SecondLevelA__ThirdLevelA1Assignment_0();
            _fsp--;


            }

             after(grammarAccess.getSecondLevelAAccess().getThirdLevelA1Assignment_0()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:301:1: ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:302:1: ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )*
            {
             before(grammarAccess.getSecondLevelAAccess().getThirdLevelA1Assignment_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:303:1: ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==11) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:303:2: rule__SecondLevelA__ThirdLevelA1Assignment_0
            	    {
            	    pushFollow(FOLLOW_rule__SecondLevelA__ThirdLevelA1Assignment_0_in_rule__SecondLevelA__Group__0583);
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

            pushFollow(FOLLOW_rule__SecondLevelA__Group__1_in_rule__SecondLevelA__Group__0595);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:315:1: rule__SecondLevelA__Group__1 : ( ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 ) ) ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )* ) ) ;
    public final void rule__SecondLevelA__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:319:1: ( ( ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 ) ) ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )* ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:320:1: ( ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 ) ) ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )* ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:320:1: ( ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 ) ) ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:321:1: ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 ) ) ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:321:1: ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:322:1: ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )
            {
             before(grammarAccess.getSecondLevelAAccess().getThirdLevelA2Assignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:323:1: ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:323:2: rule__SecondLevelA__ThirdLevelA2Assignment_1
            {
            pushFollow(FOLLOW_rule__SecondLevelA__ThirdLevelA2Assignment_1_in_rule__SecondLevelA__Group__1625);
            rule__SecondLevelA__ThirdLevelA2Assignment_1();
            _fsp--;


            }

             after(grammarAccess.getSecondLevelAAccess().getThirdLevelA2Assignment_1()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:326:1: ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:327:1: ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )*
            {
             before(grammarAccess.getSecondLevelAAccess().getThirdLevelA2Assignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:328:1: ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==12) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:328:2: rule__SecondLevelA__ThirdLevelA2Assignment_1
            	    {
            	    pushFollow(FOLLOW_rule__SecondLevelA__ThirdLevelA2Assignment_1_in_rule__SecondLevelA__Group__1637);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:343:1: rule__SecondLevelB__Group__0 : ( ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 ) ) ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )* ) ) rule__SecondLevelB__Group__1 ;
    public final void rule__SecondLevelB__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:347:1: ( ( ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 ) ) ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )* ) ) rule__SecondLevelB__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:348:1: ( ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 ) ) ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )* ) ) rule__SecondLevelB__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:348:1: ( ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 ) ) ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:349:1: ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 ) ) ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:349:1: ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:350:1: ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )
            {
             before(grammarAccess.getSecondLevelBAccess().getThirdLevelB1Assignment_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:351:1: ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:351:2: rule__SecondLevelB__ThirdLevelB1Assignment_0
            {
            pushFollow(FOLLOW_rule__SecondLevelB__ThirdLevelB1Assignment_0_in_rule__SecondLevelB__Group__0680);
            rule__SecondLevelB__ThirdLevelB1Assignment_0();
            _fsp--;


            }

             after(grammarAccess.getSecondLevelBAccess().getThirdLevelB1Assignment_0()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:354:1: ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:355:1: ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )*
            {
             before(grammarAccess.getSecondLevelBAccess().getThirdLevelB1Assignment_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:356:1: ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==13) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:356:2: rule__SecondLevelB__ThirdLevelB1Assignment_0
            	    {
            	    pushFollow(FOLLOW_rule__SecondLevelB__ThirdLevelB1Assignment_0_in_rule__SecondLevelB__Group__0692);
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

            pushFollow(FOLLOW_rule__SecondLevelB__Group__1_in_rule__SecondLevelB__Group__0704);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:368:1: rule__SecondLevelB__Group__1 : ( ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 ) ) ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )* ) ) ;
    public final void rule__SecondLevelB__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:372:1: ( ( ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 ) ) ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )* ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:373:1: ( ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 ) ) ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )* ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:373:1: ( ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 ) ) ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:374:1: ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 ) ) ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:374:1: ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:375:1: ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )
            {
             before(grammarAccess.getSecondLevelBAccess().getThirdLevelB2Assignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:376:1: ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:376:2: rule__SecondLevelB__ThirdLevelB2Assignment_1
            {
            pushFollow(FOLLOW_rule__SecondLevelB__ThirdLevelB2Assignment_1_in_rule__SecondLevelB__Group__1734);
            rule__SecondLevelB__ThirdLevelB2Assignment_1();
            _fsp--;


            }

             after(grammarAccess.getSecondLevelBAccess().getThirdLevelB2Assignment_1()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:379:1: ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:380:1: ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )*
            {
             before(grammarAccess.getSecondLevelBAccess().getThirdLevelB2Assignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:381:1: ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==14) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:381:2: rule__SecondLevelB__ThirdLevelB2Assignment_1
            	    {
            	    pushFollow(FOLLOW_rule__SecondLevelB__ThirdLevelB2Assignment_1_in_rule__SecondLevelB__Group__1746);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:396:1: rule__ThirdLevelA1__Group__0 : ( 'A1' ) rule__ThirdLevelA1__Group__1 ;
    public final void rule__ThirdLevelA1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:400:1: ( ( 'A1' ) rule__ThirdLevelA1__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:401:1: ( 'A1' ) rule__ThirdLevelA1__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:401:1: ( 'A1' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:402:1: 'A1'
            {
             before(grammarAccess.getThirdLevelA1Access().getA1Keyword_0()); 
            match(input,11,FOLLOW_11_in_rule__ThirdLevelA1__Group__0788); 
             after(grammarAccess.getThirdLevelA1Access().getA1Keyword_0()); 

            }

            pushFollow(FOLLOW_rule__ThirdLevelA1__Group__1_in_rule__ThirdLevelA1__Group__0798);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:416:1: rule__ThirdLevelA1__Group__1 : ( () ) rule__ThirdLevelA1__Group__2 ;
    public final void rule__ThirdLevelA1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:420:1: ( ( () ) rule__ThirdLevelA1__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:421:1: ( () ) rule__ThirdLevelA1__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:421:1: ( () )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:422:1: ()
            {
             before(grammarAccess.getThirdLevelA1Access().getThirdLevelA1Action_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:423:1: ()
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:425:1: 
            {
            }

             after(grammarAccess.getThirdLevelA1Access().getThirdLevelA1Action_1()); 

            }

            pushFollow(FOLLOW_rule__ThirdLevelA1__Group__2_in_rule__ThirdLevelA1__Group__1836);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:436:1: rule__ThirdLevelA1__Group__2 : ( ( rule__ThirdLevelA1__NameAssignment_2 )? ) ;
    public final void rule__ThirdLevelA1__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:440:1: ( ( ( rule__ThirdLevelA1__NameAssignment_2 )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:441:1: ( ( rule__ThirdLevelA1__NameAssignment_2 )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:441:1: ( ( rule__ThirdLevelA1__NameAssignment_2 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:442:1: ( rule__ThirdLevelA1__NameAssignment_2 )?
            {
             before(grammarAccess.getThirdLevelA1Access().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:443:1: ( rule__ThirdLevelA1__NameAssignment_2 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:443:2: rule__ThirdLevelA1__NameAssignment_2
                    {
                    pushFollow(FOLLOW_rule__ThirdLevelA1__NameAssignment_2_in_rule__ThirdLevelA1__Group__2864);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:459:1: rule__ThirdLevelA2__Group__0 : ( 'A2' ) rule__ThirdLevelA2__Group__1 ;
    public final void rule__ThirdLevelA2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:463:1: ( ( 'A2' ) rule__ThirdLevelA2__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:464:1: ( 'A2' ) rule__ThirdLevelA2__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:464:1: ( 'A2' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:465:1: 'A2'
            {
             before(grammarAccess.getThirdLevelA2Access().getA2Keyword_0()); 
            match(input,12,FOLLOW_12_in_rule__ThirdLevelA2__Group__0906); 
             after(grammarAccess.getThirdLevelA2Access().getA2Keyword_0()); 

            }

            pushFollow(FOLLOW_rule__ThirdLevelA2__Group__1_in_rule__ThirdLevelA2__Group__0916);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:479:1: rule__ThirdLevelA2__Group__1 : ( () ) rule__ThirdLevelA2__Group__2 ;
    public final void rule__ThirdLevelA2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:483:1: ( ( () ) rule__ThirdLevelA2__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:484:1: ( () ) rule__ThirdLevelA2__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:484:1: ( () )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:485:1: ()
            {
             before(grammarAccess.getThirdLevelA2Access().getThirdLevelA2Action_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:486:1: ()
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:488:1: 
            {
            }

             after(grammarAccess.getThirdLevelA2Access().getThirdLevelA2Action_1()); 

            }

            pushFollow(FOLLOW_rule__ThirdLevelA2__Group__2_in_rule__ThirdLevelA2__Group__1954);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:499:1: rule__ThirdLevelA2__Group__2 : ( ( rule__ThirdLevelA2__NameAssignment_2 )? ) ;
    public final void rule__ThirdLevelA2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:503:1: ( ( ( rule__ThirdLevelA2__NameAssignment_2 )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:504:1: ( ( rule__ThirdLevelA2__NameAssignment_2 )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:504:1: ( ( rule__ThirdLevelA2__NameAssignment_2 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:505:1: ( rule__ThirdLevelA2__NameAssignment_2 )?
            {
             before(grammarAccess.getThirdLevelA2Access().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:506:1: ( rule__ThirdLevelA2__NameAssignment_2 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:506:2: rule__ThirdLevelA2__NameAssignment_2
                    {
                    pushFollow(FOLLOW_rule__ThirdLevelA2__NameAssignment_2_in_rule__ThirdLevelA2__Group__2982);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:522:1: rule__ThirdLevelB1__Group__0 : ( 'B1' ) rule__ThirdLevelB1__Group__1 ;
    public final void rule__ThirdLevelB1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:526:1: ( ( 'B1' ) rule__ThirdLevelB1__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:527:1: ( 'B1' ) rule__ThirdLevelB1__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:527:1: ( 'B1' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:528:1: 'B1'
            {
             before(grammarAccess.getThirdLevelB1Access().getB1Keyword_0()); 
            match(input,13,FOLLOW_13_in_rule__ThirdLevelB1__Group__01024); 
             after(grammarAccess.getThirdLevelB1Access().getB1Keyword_0()); 

            }

            pushFollow(FOLLOW_rule__ThirdLevelB1__Group__1_in_rule__ThirdLevelB1__Group__01034);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:542:1: rule__ThirdLevelB1__Group__1 : ( () ) rule__ThirdLevelB1__Group__2 ;
    public final void rule__ThirdLevelB1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:546:1: ( ( () ) rule__ThirdLevelB1__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:547:1: ( () ) rule__ThirdLevelB1__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:547:1: ( () )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:548:1: ()
            {
             before(grammarAccess.getThirdLevelB1Access().getThirdLevelB1Action_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:549:1: ()
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:551:1: 
            {
            }

             after(grammarAccess.getThirdLevelB1Access().getThirdLevelB1Action_1()); 

            }

            pushFollow(FOLLOW_rule__ThirdLevelB1__Group__2_in_rule__ThirdLevelB1__Group__11072);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:562:1: rule__ThirdLevelB1__Group__2 : ( ( rule__ThirdLevelB1__NameAssignment_2 )? ) ;
    public final void rule__ThirdLevelB1__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:566:1: ( ( ( rule__ThirdLevelB1__NameAssignment_2 )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:567:1: ( ( rule__ThirdLevelB1__NameAssignment_2 )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:567:1: ( ( rule__ThirdLevelB1__NameAssignment_2 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:568:1: ( rule__ThirdLevelB1__NameAssignment_2 )?
            {
             before(grammarAccess.getThirdLevelB1Access().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:569:1: ( rule__ThirdLevelB1__NameAssignment_2 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:569:2: rule__ThirdLevelB1__NameAssignment_2
                    {
                    pushFollow(FOLLOW_rule__ThirdLevelB1__NameAssignment_2_in_rule__ThirdLevelB1__Group__21100);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:585:1: rule__ThirdLevelB2__Group__0 : ( 'B2' ) rule__ThirdLevelB2__Group__1 ;
    public final void rule__ThirdLevelB2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:589:1: ( ( 'B2' ) rule__ThirdLevelB2__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:590:1: ( 'B2' ) rule__ThirdLevelB2__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:590:1: ( 'B2' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:591:1: 'B2'
            {
             before(grammarAccess.getThirdLevelB2Access().getB2Keyword_0()); 
            match(input,14,FOLLOW_14_in_rule__ThirdLevelB2__Group__01142); 
             after(grammarAccess.getThirdLevelB2Access().getB2Keyword_0()); 

            }

            pushFollow(FOLLOW_rule__ThirdLevelB2__Group__1_in_rule__ThirdLevelB2__Group__01152);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:605:1: rule__ThirdLevelB2__Group__1 : ( () ) rule__ThirdLevelB2__Group__2 ;
    public final void rule__ThirdLevelB2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:609:1: ( ( () ) rule__ThirdLevelB2__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:610:1: ( () ) rule__ThirdLevelB2__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:610:1: ( () )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:611:1: ()
            {
             before(grammarAccess.getThirdLevelB2Access().getThirdLevelB2Action_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:612:1: ()
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:614:1: 
            {
            }

             after(grammarAccess.getThirdLevelB2Access().getThirdLevelB2Action_1()); 

            }

            pushFollow(FOLLOW_rule__ThirdLevelB2__Group__2_in_rule__ThirdLevelB2__Group__11190);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:625:1: rule__ThirdLevelB2__Group__2 : ( ( rule__ThirdLevelB2__NameAssignment_2 )? ) ;
    public final void rule__ThirdLevelB2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:629:1: ( ( ( rule__ThirdLevelB2__NameAssignment_2 )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:630:1: ( ( rule__ThirdLevelB2__NameAssignment_2 )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:630:1: ( ( rule__ThirdLevelB2__NameAssignment_2 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:631:1: ( rule__ThirdLevelB2__NameAssignment_2 )?
            {
             before(grammarAccess.getThirdLevelB2Access().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:632:1: ( rule__ThirdLevelB2__NameAssignment_2 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:632:2: rule__ThirdLevelB2__NameAssignment_2
                    {
                    pushFollow(FOLLOW_rule__ThirdLevelB2__NameAssignment_2_in_rule__ThirdLevelB2__Group__21218);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:648:1: rule__FirstLevel__SecondLevelAAssignment_0 : ( ruleSecondLevelA ) ;
    public final void rule__FirstLevel__SecondLevelAAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:652:1: ( ( ruleSecondLevelA ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:653:1: ( ruleSecondLevelA )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:653:1: ( ruleSecondLevelA )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:654:1: ruleSecondLevelA
            {
             before(grammarAccess.getFirstLevelAccess().getSecondLevelASecondLevelAParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleSecondLevelA_in_rule__FirstLevel__SecondLevelAAssignment_01259);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:663:1: rule__FirstLevel__SecondLevelBAssignment_1 : ( ruleSecondLevelB ) ;
    public final void rule__FirstLevel__SecondLevelBAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:667:1: ( ( ruleSecondLevelB ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:668:1: ( ruleSecondLevelB )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:668:1: ( ruleSecondLevelB )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:669:1: ruleSecondLevelB
            {
             before(grammarAccess.getFirstLevelAccess().getSecondLevelBSecondLevelBParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleSecondLevelB_in_rule__FirstLevel__SecondLevelBAssignment_11290);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:678:1: rule__SecondLevelA__ThirdLevelA1Assignment_0 : ( ruleThirdLevelA1 ) ;
    public final void rule__SecondLevelA__ThirdLevelA1Assignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:682:1: ( ( ruleThirdLevelA1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:683:1: ( ruleThirdLevelA1 )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:683:1: ( ruleThirdLevelA1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:684:1: ruleThirdLevelA1
            {
             before(grammarAccess.getSecondLevelAAccess().getThirdLevelA1ThirdLevelA1ParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleThirdLevelA1_in_rule__SecondLevelA__ThirdLevelA1Assignment_01321);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:693:1: rule__SecondLevelA__ThirdLevelA2Assignment_1 : ( ruleThirdLevelA2 ) ;
    public final void rule__SecondLevelA__ThirdLevelA2Assignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:697:1: ( ( ruleThirdLevelA2 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:698:1: ( ruleThirdLevelA2 )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:698:1: ( ruleThirdLevelA2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:699:1: ruleThirdLevelA2
            {
             before(grammarAccess.getSecondLevelAAccess().getThirdLevelA2ThirdLevelA2ParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleThirdLevelA2_in_rule__SecondLevelA__ThirdLevelA2Assignment_11352);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:708:1: rule__SecondLevelB__ThirdLevelB1Assignment_0 : ( ruleThirdLevelB1 ) ;
    public final void rule__SecondLevelB__ThirdLevelB1Assignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:712:1: ( ( ruleThirdLevelB1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:713:1: ( ruleThirdLevelB1 )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:713:1: ( ruleThirdLevelB1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:714:1: ruleThirdLevelB1
            {
             before(grammarAccess.getSecondLevelBAccess().getThirdLevelB1ThirdLevelB1ParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleThirdLevelB1_in_rule__SecondLevelB__ThirdLevelB1Assignment_01383);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:723:1: rule__SecondLevelB__ThirdLevelB2Assignment_1 : ( ruleThirdLevelB2 ) ;
    public final void rule__SecondLevelB__ThirdLevelB2Assignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:727:1: ( ( ruleThirdLevelB2 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:728:1: ( ruleThirdLevelB2 )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:728:1: ( ruleThirdLevelB2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:729:1: ruleThirdLevelB2
            {
             before(grammarAccess.getSecondLevelBAccess().getThirdLevelB2ThirdLevelB2ParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleThirdLevelB2_in_rule__SecondLevelB__ThirdLevelB2Assignment_11414);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:738:1: rule__ThirdLevelA1__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ThirdLevelA1__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:742:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:743:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:743:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:744:1: RULE_ID
            {
             before(grammarAccess.getThirdLevelA1Access().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ThirdLevelA1__NameAssignment_21445); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:753:1: rule__ThirdLevelA2__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ThirdLevelA2__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:757:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:758:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:758:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:759:1: RULE_ID
            {
             before(grammarAccess.getThirdLevelA2Access().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ThirdLevelA2__NameAssignment_21476); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:768:1: rule__ThirdLevelB1__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ThirdLevelB1__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:772:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:773:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:773:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:774:1: RULE_ID
            {
             before(grammarAccess.getThirdLevelB1Access().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ThirdLevelB1__NameAssignment_21507); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:783:1: rule__ThirdLevelB2__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ThirdLevelB2__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:787:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:788:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:788:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:789:1: RULE_ID
            {
             before(grammarAccess.getThirdLevelB2Access().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ThirdLevelB2__NameAssignment_21538); 
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


 

    public static final BitSet FOLLOW_ruleFirstLevel_in_entryRuleFirstLevel60 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFirstLevel67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FirstLevel__Group__0_in_ruleFirstLevel94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSecondLevelA_in_entryRuleSecondLevelA120 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSecondLevelA127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SecondLevelA__Group__0_in_ruleSecondLevelA154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSecondLevelB_in_entryRuleSecondLevelB180 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSecondLevelB187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SecondLevelB__Group__0_in_ruleSecondLevelB214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleThirdLevelA1_in_entryRuleThirdLevelA1240 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleThirdLevelA1247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ThirdLevelA1__Group__0_in_ruleThirdLevelA1274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleThirdLevelA2_in_entryRuleThirdLevelA2300 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleThirdLevelA2307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ThirdLevelA2__Group__0_in_ruleThirdLevelA2334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleThirdLevelB1_in_entryRuleThirdLevelB1360 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleThirdLevelB1367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ThirdLevelB1__Group__0_in_ruleThirdLevelB1394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleThirdLevelB2_in_entryRuleThirdLevelB2420 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleThirdLevelB2427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ThirdLevelB2__Group__0_in_ruleThirdLevelB2454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FirstLevel__SecondLevelAAssignment_0_in_rule__FirstLevel__Group__0492 = new BitSet(new long[]{0x0000000000002802L});
    public static final BitSet FOLLOW_rule__FirstLevel__Group__1_in_rule__FirstLevel__Group__0502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FirstLevel__SecondLevelBAssignment_1_in_rule__FirstLevel__Group__1530 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_rule__SecondLevelA__ThirdLevelA1Assignment_0_in_rule__SecondLevelA__Group__0571 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_rule__SecondLevelA__ThirdLevelA1Assignment_0_in_rule__SecondLevelA__Group__0583 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_rule__SecondLevelA__Group__1_in_rule__SecondLevelA__Group__0595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SecondLevelA__ThirdLevelA2Assignment_1_in_rule__SecondLevelA__Group__1625 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_rule__SecondLevelA__ThirdLevelA2Assignment_1_in_rule__SecondLevelA__Group__1637 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_rule__SecondLevelB__ThirdLevelB1Assignment_0_in_rule__SecondLevelB__Group__0680 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_rule__SecondLevelB__ThirdLevelB1Assignment_0_in_rule__SecondLevelB__Group__0692 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_rule__SecondLevelB__Group__1_in_rule__SecondLevelB__Group__0704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SecondLevelB__ThirdLevelB2Assignment_1_in_rule__SecondLevelB__Group__1734 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_rule__SecondLevelB__ThirdLevelB2Assignment_1_in_rule__SecondLevelB__Group__1746 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_11_in_rule__ThirdLevelA1__Group__0788 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__ThirdLevelA1__Group__1_in_rule__ThirdLevelA1__Group__0798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ThirdLevelA1__Group__2_in_rule__ThirdLevelA1__Group__1836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ThirdLevelA1__NameAssignment_2_in_rule__ThirdLevelA1__Group__2864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__ThirdLevelA2__Group__0906 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__ThirdLevelA2__Group__1_in_rule__ThirdLevelA2__Group__0916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ThirdLevelA2__Group__2_in_rule__ThirdLevelA2__Group__1954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ThirdLevelA2__NameAssignment_2_in_rule__ThirdLevelA2__Group__2982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__ThirdLevelB1__Group__01024 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__ThirdLevelB1__Group__1_in_rule__ThirdLevelB1__Group__01034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ThirdLevelB1__Group__2_in_rule__ThirdLevelB1__Group__11072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ThirdLevelB1__NameAssignment_2_in_rule__ThirdLevelB1__Group__21100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__ThirdLevelB2__Group__01142 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__ThirdLevelB2__Group__1_in_rule__ThirdLevelB2__Group__01152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ThirdLevelB2__Group__2_in_rule__ThirdLevelB2__Group__11190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ThirdLevelB2__NameAssignment_2_in_rule__ThirdLevelB2__Group__21218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSecondLevelA_in_rule__FirstLevel__SecondLevelAAssignment_01259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSecondLevelB_in_rule__FirstLevel__SecondLevelBAssignment_11290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleThirdLevelA1_in_rule__SecondLevelA__ThirdLevelA1Assignment_01321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleThirdLevelA2_in_rule__SecondLevelA__ThirdLevelA2Assignment_11352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleThirdLevelB1_in_rule__SecondLevelB__ThirdLevelB1Assignment_01383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleThirdLevelB2_in_rule__SecondLevelB__ThirdLevelB2Assignment_11414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ThirdLevelA1__NameAssignment_21445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ThirdLevelA2__NameAssignment_21476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ThirdLevelB1__NameAssignment_21507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ThirdLevelB2__NameAssignment_21538 = new BitSet(new long[]{0x0000000000000002L});

}
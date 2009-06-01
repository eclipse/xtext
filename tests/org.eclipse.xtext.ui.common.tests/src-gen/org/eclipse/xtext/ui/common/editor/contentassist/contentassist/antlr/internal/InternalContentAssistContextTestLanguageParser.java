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




    // $ANTLR start entryRuleFirstLevel
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:55:1: entryRuleFirstLevel : ruleFirstLevel EOF ;
    public final void entryRuleFirstLevel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:55:21: ( ruleFirstLevel EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:56:1: ruleFirstLevel EOF
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:63:1: ruleFirstLevel : ( ( rule__FirstLevel__Group ) ) ;
    public final void ruleFirstLevel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:67:2: ( ( ( rule__FirstLevel__Group ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:68:1: ( ( rule__FirstLevel__Group ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:68:1: ( ( rule__FirstLevel__Group ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:69:1: ( rule__FirstLevel__Group )
            {
             before(grammarAccess.getFirstLevelAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:70:1: ( rule__FirstLevel__Group )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:70:2: rule__FirstLevel__Group
            {
            pushFollow(FOLLOW_rule__FirstLevel__Group_in_ruleFirstLevel94);
            rule__FirstLevel__Group();
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:81:1: entryRuleSecondLevelA : ruleSecondLevelA EOF ;
    public final void entryRuleSecondLevelA() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:81:23: ( ruleSecondLevelA EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:82:1: ruleSecondLevelA EOF
            {
             before(grammarAccess.getSecondLevelARule()); 
            pushFollow(FOLLOW_ruleSecondLevelA_in_entryRuleSecondLevelA119);
            ruleSecondLevelA();
            _fsp--;

             after(grammarAccess.getSecondLevelARule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSecondLevelA126); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:89:1: ruleSecondLevelA : ( ( rule__SecondLevelA__Group ) ) ;
    public final void ruleSecondLevelA() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:93:2: ( ( ( rule__SecondLevelA__Group ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:94:1: ( ( rule__SecondLevelA__Group ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:94:1: ( ( rule__SecondLevelA__Group ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:95:1: ( rule__SecondLevelA__Group )
            {
             before(grammarAccess.getSecondLevelAAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:96:1: ( rule__SecondLevelA__Group )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:96:2: rule__SecondLevelA__Group
            {
            pushFollow(FOLLOW_rule__SecondLevelA__Group_in_ruleSecondLevelA153);
            rule__SecondLevelA__Group();
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:107:1: entryRuleSecondLevelB : ruleSecondLevelB EOF ;
    public final void entryRuleSecondLevelB() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:107:23: ( ruleSecondLevelB EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:108:1: ruleSecondLevelB EOF
            {
             before(grammarAccess.getSecondLevelBRule()); 
            pushFollow(FOLLOW_ruleSecondLevelB_in_entryRuleSecondLevelB178);
            ruleSecondLevelB();
            _fsp--;

             after(grammarAccess.getSecondLevelBRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSecondLevelB185); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:115:1: ruleSecondLevelB : ( ( rule__SecondLevelB__Group ) ) ;
    public final void ruleSecondLevelB() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:119:2: ( ( ( rule__SecondLevelB__Group ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:120:1: ( ( rule__SecondLevelB__Group ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:120:1: ( ( rule__SecondLevelB__Group ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:121:1: ( rule__SecondLevelB__Group )
            {
             before(grammarAccess.getSecondLevelBAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:122:1: ( rule__SecondLevelB__Group )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:122:2: rule__SecondLevelB__Group
            {
            pushFollow(FOLLOW_rule__SecondLevelB__Group_in_ruleSecondLevelB212);
            rule__SecondLevelB__Group();
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:133:1: entryRuleThirdLevelA1 : ruleThirdLevelA1 EOF ;
    public final void entryRuleThirdLevelA1() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:133:23: ( ruleThirdLevelA1 EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:134:1: ruleThirdLevelA1 EOF
            {
             before(grammarAccess.getThirdLevelA1Rule()); 
            pushFollow(FOLLOW_ruleThirdLevelA1_in_entryRuleThirdLevelA1237);
            ruleThirdLevelA1();
            _fsp--;

             after(grammarAccess.getThirdLevelA1Rule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleThirdLevelA1244); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:141:1: ruleThirdLevelA1 : ( ( rule__ThirdLevelA1__Group ) ) ;
    public final void ruleThirdLevelA1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:145:2: ( ( ( rule__ThirdLevelA1__Group ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:146:1: ( ( rule__ThirdLevelA1__Group ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:146:1: ( ( rule__ThirdLevelA1__Group ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:147:1: ( rule__ThirdLevelA1__Group )
            {
             before(grammarAccess.getThirdLevelA1Access().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:148:1: ( rule__ThirdLevelA1__Group )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:148:2: rule__ThirdLevelA1__Group
            {
            pushFollow(FOLLOW_rule__ThirdLevelA1__Group_in_ruleThirdLevelA1271);
            rule__ThirdLevelA1__Group();
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:159:1: entryRuleThirdLevelA2 : ruleThirdLevelA2 EOF ;
    public final void entryRuleThirdLevelA2() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:159:23: ( ruleThirdLevelA2 EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:160:1: ruleThirdLevelA2 EOF
            {
             before(grammarAccess.getThirdLevelA2Rule()); 
            pushFollow(FOLLOW_ruleThirdLevelA2_in_entryRuleThirdLevelA2296);
            ruleThirdLevelA2();
            _fsp--;

             after(grammarAccess.getThirdLevelA2Rule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleThirdLevelA2303); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:167:1: ruleThirdLevelA2 : ( ( rule__ThirdLevelA2__Group ) ) ;
    public final void ruleThirdLevelA2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:171:2: ( ( ( rule__ThirdLevelA2__Group ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:172:1: ( ( rule__ThirdLevelA2__Group ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:172:1: ( ( rule__ThirdLevelA2__Group ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:173:1: ( rule__ThirdLevelA2__Group )
            {
             before(grammarAccess.getThirdLevelA2Access().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:174:1: ( rule__ThirdLevelA2__Group )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:174:2: rule__ThirdLevelA2__Group
            {
            pushFollow(FOLLOW_rule__ThirdLevelA2__Group_in_ruleThirdLevelA2330);
            rule__ThirdLevelA2__Group();
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:185:1: entryRuleThirdLevelB1 : ruleThirdLevelB1 EOF ;
    public final void entryRuleThirdLevelB1() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:185:23: ( ruleThirdLevelB1 EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:186:1: ruleThirdLevelB1 EOF
            {
             before(grammarAccess.getThirdLevelB1Rule()); 
            pushFollow(FOLLOW_ruleThirdLevelB1_in_entryRuleThirdLevelB1355);
            ruleThirdLevelB1();
            _fsp--;

             after(grammarAccess.getThirdLevelB1Rule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleThirdLevelB1362); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:193:1: ruleThirdLevelB1 : ( ( rule__ThirdLevelB1__Group ) ) ;
    public final void ruleThirdLevelB1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:197:2: ( ( ( rule__ThirdLevelB1__Group ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:198:1: ( ( rule__ThirdLevelB1__Group ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:198:1: ( ( rule__ThirdLevelB1__Group ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:199:1: ( rule__ThirdLevelB1__Group )
            {
             before(grammarAccess.getThirdLevelB1Access().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:200:1: ( rule__ThirdLevelB1__Group )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:200:2: rule__ThirdLevelB1__Group
            {
            pushFollow(FOLLOW_rule__ThirdLevelB1__Group_in_ruleThirdLevelB1389);
            rule__ThirdLevelB1__Group();
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:211:1: entryRuleThirdLevelB2 : ruleThirdLevelB2 EOF ;
    public final void entryRuleThirdLevelB2() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:211:23: ( ruleThirdLevelB2 EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:212:1: ruleThirdLevelB2 EOF
            {
             before(grammarAccess.getThirdLevelB2Rule()); 
            pushFollow(FOLLOW_ruleThirdLevelB2_in_entryRuleThirdLevelB2414);
            ruleThirdLevelB2();
            _fsp--;

             after(grammarAccess.getThirdLevelB2Rule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleThirdLevelB2421); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:219:1: ruleThirdLevelB2 : ( ( rule__ThirdLevelB2__Group ) ) ;
    public final void ruleThirdLevelB2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:223:2: ( ( ( rule__ThirdLevelB2__Group ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:224:1: ( ( rule__ThirdLevelB2__Group ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:224:1: ( ( rule__ThirdLevelB2__Group ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:225:1: ( rule__ThirdLevelB2__Group )
            {
             before(grammarAccess.getThirdLevelB2Access().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:226:1: ( rule__ThirdLevelB2__Group )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:226:2: rule__ThirdLevelB2__Group
            {
            pushFollow(FOLLOW_rule__ThirdLevelB2__Group_in_ruleThirdLevelB2448);
            rule__ThirdLevelB2__Group();
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


    // $ANTLR start rule__FirstLevel__Group
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:238:1: rule__FirstLevel__Group : ( ( ( ruleSecondLevelA ) )* ) ( ( ( ruleSecondLevelB ) )* ) ;
    public final void rule__FirstLevel__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:242:1: ( ( ( ( ruleSecondLevelA ) )* ) ( ( ( ruleSecondLevelB ) )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:243:1: ( ( ( ruleSecondLevelA ) )* ) ( ( ( ruleSecondLevelB ) )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:243:1: ( ( ( ruleSecondLevelA ) )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:244:1: ( ( ruleSecondLevelA ) )*
            {
             before(grammarAccess.getFirstLevelAccess().getSecondLevelAAssignment_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:245:1: ( ( ruleSecondLevelA ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:246:1: ( ruleSecondLevelA )
            	    {
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:246:1: ( ruleSecondLevelA )
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:247:1: ruleSecondLevelA
            	    {
            	     before(grammarAccess.getFirstLevelAccess().getSecondLevelASecondLevelAParserRuleCall_0_0()); 
            	    pushFollow(FOLLOW_ruleSecondLevelA_in_rule__FirstLevel__Group491);
            	    ruleSecondLevelA();
            	    _fsp--;

            	     after(grammarAccess.getFirstLevelAccess().getSecondLevelASecondLevelAParserRuleCall_0_0()); 

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getFirstLevelAccess().getSecondLevelAAssignment_0()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:253:1: ( ( ( ruleSecondLevelB ) )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:254:1: ( ( ruleSecondLevelB ) )*
            {
             before(grammarAccess.getFirstLevelAccess().getSecondLevelBAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:255:1: ( ( ruleSecondLevelB ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:256:1: ( ruleSecondLevelB )
            	    {
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:256:1: ( ruleSecondLevelB )
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:257:1: ruleSecondLevelB
            	    {
            	     before(grammarAccess.getFirstLevelAccess().getSecondLevelBSecondLevelBParserRuleCall_1_0()); 
            	    pushFollow(FOLLOW_ruleSecondLevelB_in_rule__FirstLevel__Group516);
            	    ruleSecondLevelB();
            	    _fsp--;

            	     after(grammarAccess.getFirstLevelAccess().getSecondLevelBSecondLevelBParserRuleCall_1_0()); 

            	    }


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
    // $ANTLR end rule__FirstLevel__Group


    // $ANTLR start rule__SecondLevelA__Group
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:269:1: rule__SecondLevelA__Group : ( ( ( ruleThirdLevelA1 ) )+ ) ( ( ( ruleThirdLevelA2 ) )+ ) ;
    public final void rule__SecondLevelA__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:273:1: ( ( ( ( ruleThirdLevelA1 ) )+ ) ( ( ( ruleThirdLevelA2 ) )+ ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:274:1: ( ( ( ruleThirdLevelA1 ) )+ ) ( ( ( ruleThirdLevelA2 ) )+ )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:274:1: ( ( ( ruleThirdLevelA1 ) )+ )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:275:1: ( ( ruleThirdLevelA1 ) )+
            {
             before(grammarAccess.getSecondLevelAAccess().getThirdLevelA1Assignment_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:276:1: ( ( ruleThirdLevelA1 ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==11) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:277:1: ( ruleThirdLevelA1 )
            	    {
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:277:1: ( ruleThirdLevelA1 )
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:278:1: ruleThirdLevelA1
            	    {
            	     before(grammarAccess.getSecondLevelAAccess().getThirdLevelA1ThirdLevelA1ParserRuleCall_0_0()); 
            	    pushFollow(FOLLOW_ruleThirdLevelA1_in_rule__SecondLevelA__Group562);
            	    ruleThirdLevelA1();
            	    _fsp--;

            	     after(grammarAccess.getSecondLevelAAccess().getThirdLevelA1ThirdLevelA1ParserRuleCall_0_0()); 

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

             after(grammarAccess.getSecondLevelAAccess().getThirdLevelA1Assignment_0()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:284:1: ( ( ( ruleThirdLevelA2 ) )+ )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:285:1: ( ( ruleThirdLevelA2 ) )+
            {
             before(grammarAccess.getSecondLevelAAccess().getThirdLevelA2Assignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:286:1: ( ( ruleThirdLevelA2 ) )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==12) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:287:1: ( ruleThirdLevelA2 )
            	    {
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:287:1: ( ruleThirdLevelA2 )
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:288:1: ruleThirdLevelA2
            	    {
            	     before(grammarAccess.getSecondLevelAAccess().getThirdLevelA2ThirdLevelA2ParserRuleCall_1_0()); 
            	    pushFollow(FOLLOW_ruleThirdLevelA2_in_rule__SecondLevelA__Group587);
            	    ruleThirdLevelA2();
            	    _fsp--;

            	     after(grammarAccess.getSecondLevelAAccess().getThirdLevelA2ThirdLevelA2ParserRuleCall_1_0()); 

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

             after(grammarAccess.getSecondLevelAAccess().getThirdLevelA2Assignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SecondLevelA__Group


    // $ANTLR start rule__SecondLevelB__Group
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:300:1: rule__SecondLevelB__Group : ( ( ( ruleThirdLevelB1 ) )+ ) ( ( ( ruleThirdLevelB2 ) )+ ) ;
    public final void rule__SecondLevelB__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:304:1: ( ( ( ( ruleThirdLevelB1 ) )+ ) ( ( ( ruleThirdLevelB2 ) )+ ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:305:1: ( ( ( ruleThirdLevelB1 ) )+ ) ( ( ( ruleThirdLevelB2 ) )+ )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:305:1: ( ( ( ruleThirdLevelB1 ) )+ )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:306:1: ( ( ruleThirdLevelB1 ) )+
            {
             before(grammarAccess.getSecondLevelBAccess().getThirdLevelB1Assignment_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:307:1: ( ( ruleThirdLevelB1 ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==13) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:308:1: ( ruleThirdLevelB1 )
            	    {
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:308:1: ( ruleThirdLevelB1 )
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:309:1: ruleThirdLevelB1
            	    {
            	     before(grammarAccess.getSecondLevelBAccess().getThirdLevelB1ThirdLevelB1ParserRuleCall_0_0()); 
            	    pushFollow(FOLLOW_ruleThirdLevelB1_in_rule__SecondLevelB__Group633);
            	    ruleThirdLevelB1();
            	    _fsp--;

            	     after(grammarAccess.getSecondLevelBAccess().getThirdLevelB1ThirdLevelB1ParserRuleCall_0_0()); 

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

             after(grammarAccess.getSecondLevelBAccess().getThirdLevelB1Assignment_0()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:315:1: ( ( ( ruleThirdLevelB2 ) )+ )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:316:1: ( ( ruleThirdLevelB2 ) )+
            {
             before(grammarAccess.getSecondLevelBAccess().getThirdLevelB2Assignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:317:1: ( ( ruleThirdLevelB2 ) )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==14) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:318:1: ( ruleThirdLevelB2 )
            	    {
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:318:1: ( ruleThirdLevelB2 )
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:319:1: ruleThirdLevelB2
            	    {
            	     before(grammarAccess.getSecondLevelBAccess().getThirdLevelB2ThirdLevelB2ParserRuleCall_1_0()); 
            	    pushFollow(FOLLOW_ruleThirdLevelB2_in_rule__SecondLevelB__Group658);
            	    ruleThirdLevelB2();
            	    _fsp--;

            	     after(grammarAccess.getSecondLevelBAccess().getThirdLevelB2ThirdLevelB2ParserRuleCall_1_0()); 

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

             after(grammarAccess.getSecondLevelBAccess().getThirdLevelB2Assignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SecondLevelB__Group


    // $ANTLR start rule__ThirdLevelA1__Group
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:331:1: rule__ThirdLevelA1__Group : ( 'A1' ) ( () ) ( ( ( RULE_ID ) )? ) ;
    public final void rule__ThirdLevelA1__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:335:1: ( ( 'A1' ) ( () ) ( ( ( RULE_ID ) )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:336:1: ( 'A1' ) ( () ) ( ( ( RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:336:1: ( 'A1' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:337:1: 'A1'
            {
             before(grammarAccess.getThirdLevelA1Access().getA1Keyword_0()); 
            match(input,11,FOLLOW_11_in_rule__ThirdLevelA1__Group698); 
             after(grammarAccess.getThirdLevelA1Access().getA1Keyword_0()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:342:1: ( () )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:343:1: ()
            {
             before(grammarAccess.getThirdLevelA1Access().getThirdLevelA1Action_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:344:1: ()
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:346:1: 
            {
            }

             after(grammarAccess.getThirdLevelA1Access().getThirdLevelA1Action_1()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:348:1: ( ( ( RULE_ID ) )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:349:1: ( ( RULE_ID ) )?
            {
             before(grammarAccess.getThirdLevelA1Access().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:350:1: ( ( RULE_ID ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:351:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:351:1: ( RULE_ID )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:352:1: RULE_ID
                    {
                     before(grammarAccess.getThirdLevelA1Access().getNameIDTerminalRuleCall_2_0()); 
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ThirdLevelA1__Group729); 
                     after(grammarAccess.getThirdLevelA1Access().getNameIDTerminalRuleCall_2_0()); 

                    }


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
    // $ANTLR end rule__ThirdLevelA1__Group


    // $ANTLR start rule__ThirdLevelA2__Group
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:364:1: rule__ThirdLevelA2__Group : ( 'A2' ) ( () ) ( ( ( RULE_ID ) )? ) ;
    public final void rule__ThirdLevelA2__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:368:1: ( ( 'A2' ) ( () ) ( ( ( RULE_ID ) )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:369:1: ( 'A2' ) ( () ) ( ( ( RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:369:1: ( 'A2' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:370:1: 'A2'
            {
             before(grammarAccess.getThirdLevelA2Access().getA2Keyword_0()); 
            match(input,12,FOLLOW_12_in_rule__ThirdLevelA2__Group769); 
             after(grammarAccess.getThirdLevelA2Access().getA2Keyword_0()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:375:1: ( () )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:376:1: ()
            {
             before(grammarAccess.getThirdLevelA2Access().getThirdLevelA2Action_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:377:1: ()
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:379:1: 
            {
            }

             after(grammarAccess.getThirdLevelA2Access().getThirdLevelA2Action_1()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:381:1: ( ( ( RULE_ID ) )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:382:1: ( ( RULE_ID ) )?
            {
             before(grammarAccess.getThirdLevelA2Access().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:383:1: ( ( RULE_ID ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:384:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:384:1: ( RULE_ID )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:385:1: RULE_ID
                    {
                     before(grammarAccess.getThirdLevelA2Access().getNameIDTerminalRuleCall_2_0()); 
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ThirdLevelA2__Group800); 
                     after(grammarAccess.getThirdLevelA2Access().getNameIDTerminalRuleCall_2_0()); 

                    }


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
    // $ANTLR end rule__ThirdLevelA2__Group


    // $ANTLR start rule__ThirdLevelB1__Group
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:397:1: rule__ThirdLevelB1__Group : ( 'B1' ) ( () ) ( ( ( RULE_ID ) )? ) ;
    public final void rule__ThirdLevelB1__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:401:1: ( ( 'B1' ) ( () ) ( ( ( RULE_ID ) )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:402:1: ( 'B1' ) ( () ) ( ( ( RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:402:1: ( 'B1' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:403:1: 'B1'
            {
             before(grammarAccess.getThirdLevelB1Access().getB1Keyword_0()); 
            match(input,13,FOLLOW_13_in_rule__ThirdLevelB1__Group840); 
             after(grammarAccess.getThirdLevelB1Access().getB1Keyword_0()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:408:1: ( () )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:409:1: ()
            {
             before(grammarAccess.getThirdLevelB1Access().getThirdLevelB1Action_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:410:1: ()
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:412:1: 
            {
            }

             after(grammarAccess.getThirdLevelB1Access().getThirdLevelB1Action_1()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:414:1: ( ( ( RULE_ID ) )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:415:1: ( ( RULE_ID ) )?
            {
             before(grammarAccess.getThirdLevelB1Access().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:416:1: ( ( RULE_ID ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:417:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:417:1: ( RULE_ID )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:418:1: RULE_ID
                    {
                     before(grammarAccess.getThirdLevelB1Access().getNameIDTerminalRuleCall_2_0()); 
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ThirdLevelB1__Group871); 
                     after(grammarAccess.getThirdLevelB1Access().getNameIDTerminalRuleCall_2_0()); 

                    }


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
    // $ANTLR end rule__ThirdLevelB1__Group


    // $ANTLR start rule__ThirdLevelB2__Group
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:430:1: rule__ThirdLevelB2__Group : ( 'B2' ) ( () ) ( ( ( RULE_ID ) )? ) ;
    public final void rule__ThirdLevelB2__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:434:1: ( ( 'B2' ) ( () ) ( ( ( RULE_ID ) )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:435:1: ( 'B2' ) ( () ) ( ( ( RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:435:1: ( 'B2' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:436:1: 'B2'
            {
             before(grammarAccess.getThirdLevelB2Access().getB2Keyword_0()); 
            match(input,14,FOLLOW_14_in_rule__ThirdLevelB2__Group911); 
             after(grammarAccess.getThirdLevelB2Access().getB2Keyword_0()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:441:1: ( () )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:442:1: ()
            {
             before(grammarAccess.getThirdLevelB2Access().getThirdLevelB2Action_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:443:1: ()
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:445:1: 
            {
            }

             after(grammarAccess.getThirdLevelB2Access().getThirdLevelB2Action_1()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:447:1: ( ( ( RULE_ID ) )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:448:1: ( ( RULE_ID ) )?
            {
             before(grammarAccess.getThirdLevelB2Access().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:449:1: ( ( RULE_ID ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:450:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:450:1: ( RULE_ID )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalContentAssistContextTestLanguage.g:451:1: RULE_ID
                    {
                     before(grammarAccess.getThirdLevelB2Access().getNameIDTerminalRuleCall_2_0()); 
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ThirdLevelB2__Group942); 
                     after(grammarAccess.getThirdLevelB2Access().getNameIDTerminalRuleCall_2_0()); 

                    }


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
    // $ANTLR end rule__ThirdLevelB2__Group


 

    public static final BitSet FOLLOW_ruleFirstLevel_in_entryRuleFirstLevel60 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFirstLevel67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FirstLevel__Group_in_ruleFirstLevel94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSecondLevelA_in_entryRuleSecondLevelA119 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSecondLevelA126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SecondLevelA__Group_in_ruleSecondLevelA153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSecondLevelB_in_entryRuleSecondLevelB178 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSecondLevelB185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SecondLevelB__Group_in_ruleSecondLevelB212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleThirdLevelA1_in_entryRuleThirdLevelA1237 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleThirdLevelA1244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ThirdLevelA1__Group_in_ruleThirdLevelA1271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleThirdLevelA2_in_entryRuleThirdLevelA2296 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleThirdLevelA2303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ThirdLevelA2__Group_in_ruleThirdLevelA2330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleThirdLevelB1_in_entryRuleThirdLevelB1355 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleThirdLevelB1362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ThirdLevelB1__Group_in_ruleThirdLevelB1389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleThirdLevelB2_in_entryRuleThirdLevelB2414 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleThirdLevelB2421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ThirdLevelB2__Group_in_ruleThirdLevelB2448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSecondLevelA_in_rule__FirstLevel__Group491 = new BitSet(new long[]{0x0000000000002802L});
    public static final BitSet FOLLOW_ruleSecondLevelB_in_rule__FirstLevel__Group516 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_ruleThirdLevelA1_in_rule__SecondLevelA__Group562 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_ruleThirdLevelA2_in_rule__SecondLevelA__Group587 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ruleThirdLevelB1_in_rule__SecondLevelB__Group633 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_ruleThirdLevelB2_in_rule__SecondLevelB__Group658 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_11_in_rule__ThirdLevelA1__Group698 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ThirdLevelA1__Group729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__ThirdLevelA2__Group769 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ThirdLevelA2__Group800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__ThirdLevelB1__Group840 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ThirdLevelB1__Group871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__ThirdLevelB2__Group911 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ThirdLevelB2__Group942 = new BitSet(new long[]{0x0000000000000002L});

}
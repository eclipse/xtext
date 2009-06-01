package org.eclipse.xtext.testlanguages.contentassist.antlr.internal; 

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
import org.eclipse.xtext.testlanguages.services.ContentAssistTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalContentAssistTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'abstract rules'", "'end'", "'('", "')'", "';'", "'rule'", "':'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalContentAssistTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g"; }


     
     	private ContentAssistTestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(ContentAssistTestLanguageGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }




    // $ANTLR start entryRuleStart
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:55:1: entryRuleStart : ruleStart EOF ;
    public final void entryRuleStart() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:55:16: ( ruleStart EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:56:1: ruleStart EOF
            {
             before(grammarAccess.getStartRule()); 
            pushFollow(FOLLOW_ruleStart_in_entryRuleStart60);
            ruleStart();
            _fsp--;

             after(grammarAccess.getStartRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStart67); 

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
    // $ANTLR end entryRuleStart


    // $ANTLR start ruleStart
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:63:1: ruleStart : ( ( rule__Start__Group ) ) ;
    public final void ruleStart() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:67:2: ( ( ( rule__Start__Group ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:68:1: ( ( rule__Start__Group ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:68:1: ( ( rule__Start__Group ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:69:1: ( rule__Start__Group )
            {
             before(grammarAccess.getStartAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:70:1: ( rule__Start__Group )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:70:2: rule__Start__Group
            {
            pushFollow(FOLLOW_rule__Start__Group_in_ruleStart94);
            rule__Start__Group();
            _fsp--;


            }

             after(grammarAccess.getStartAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleStart


    // $ANTLR start entryRuleAbstractRule
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:81:1: entryRuleAbstractRule : ruleAbstractRule EOF ;
    public final void entryRuleAbstractRule() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:81:23: ( ruleAbstractRule EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:82:1: ruleAbstractRule EOF
            {
             before(grammarAccess.getAbstractRuleRule()); 
            pushFollow(FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule119);
            ruleAbstractRule();
            _fsp--;

             after(grammarAccess.getAbstractRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractRule126); 

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
    // $ANTLR end entryRuleAbstractRule


    // $ANTLR start ruleAbstractRule
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:89:1: ruleAbstractRule : ( ( rule__AbstractRule__Alternatives ) ) ;
    public final void ruleAbstractRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:93:2: ( ( ( rule__AbstractRule__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:94:1: ( ( rule__AbstractRule__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:94:1: ( ( rule__AbstractRule__Alternatives ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:95:1: ( rule__AbstractRule__Alternatives )
            {
             before(grammarAccess.getAbstractRuleAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:96:1: ( rule__AbstractRule__Alternatives )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:96:2: rule__AbstractRule__Alternatives
            {
            pushFollow(FOLLOW_rule__AbstractRule__Alternatives_in_ruleAbstractRule153);
            rule__AbstractRule__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getAbstractRuleAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleAbstractRule


    // $ANTLR start entryRuleFirstAbstractRuleChild
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:107:1: entryRuleFirstAbstractRuleChild : ruleFirstAbstractRuleChild EOF ;
    public final void entryRuleFirstAbstractRuleChild() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:107:33: ( ruleFirstAbstractRuleChild EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:108:1: ruleFirstAbstractRuleChild EOF
            {
             before(grammarAccess.getFirstAbstractRuleChildRule()); 
            pushFollow(FOLLOW_ruleFirstAbstractRuleChild_in_entryRuleFirstAbstractRuleChild178);
            ruleFirstAbstractRuleChild();
            _fsp--;

             after(grammarAccess.getFirstAbstractRuleChildRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFirstAbstractRuleChild185); 

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
    // $ANTLR end entryRuleFirstAbstractRuleChild


    // $ANTLR start ruleFirstAbstractRuleChild
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:115:1: ruleFirstAbstractRuleChild : ( ( rule__FirstAbstractRuleChild__Group ) ) ;
    public final void ruleFirstAbstractRuleChild() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:119:2: ( ( ( rule__FirstAbstractRuleChild__Group ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:120:1: ( ( rule__FirstAbstractRuleChild__Group ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:120:1: ( ( rule__FirstAbstractRuleChild__Group ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:121:1: ( rule__FirstAbstractRuleChild__Group )
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:122:1: ( rule__FirstAbstractRuleChild__Group )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:122:2: rule__FirstAbstractRuleChild__Group
            {
            pushFollow(FOLLOW_rule__FirstAbstractRuleChild__Group_in_ruleFirstAbstractRuleChild212);
            rule__FirstAbstractRuleChild__Group();
            _fsp--;


            }

             after(grammarAccess.getFirstAbstractRuleChildAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleFirstAbstractRuleChild


    // $ANTLR start entryRuleSecondAbstractRuleChild
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:133:1: entryRuleSecondAbstractRuleChild : ruleSecondAbstractRuleChild EOF ;
    public final void entryRuleSecondAbstractRuleChild() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:133:34: ( ruleSecondAbstractRuleChild EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:134:1: ruleSecondAbstractRuleChild EOF
            {
             before(grammarAccess.getSecondAbstractRuleChildRule()); 
            pushFollow(FOLLOW_ruleSecondAbstractRuleChild_in_entryRuleSecondAbstractRuleChild237);
            ruleSecondAbstractRuleChild();
            _fsp--;

             after(grammarAccess.getSecondAbstractRuleChildRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSecondAbstractRuleChild244); 

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
    // $ANTLR end entryRuleSecondAbstractRuleChild


    // $ANTLR start ruleSecondAbstractRuleChild
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:141:1: ruleSecondAbstractRuleChild : ( ( rule__SecondAbstractRuleChild__Group ) ) ;
    public final void ruleSecondAbstractRuleChild() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:145:2: ( ( ( rule__SecondAbstractRuleChild__Group ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:146:1: ( ( rule__SecondAbstractRuleChild__Group ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:146:1: ( ( rule__SecondAbstractRuleChild__Group ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:147:1: ( rule__SecondAbstractRuleChild__Group )
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:148:1: ( rule__SecondAbstractRuleChild__Group )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:148:2: rule__SecondAbstractRuleChild__Group
            {
            pushFollow(FOLLOW_rule__SecondAbstractRuleChild__Group_in_ruleSecondAbstractRuleChild271);
            rule__SecondAbstractRuleChild__Group();
            _fsp--;


            }

             after(grammarAccess.getSecondAbstractRuleChildAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleSecondAbstractRuleChild


    // $ANTLR start entryRuleAbstractRuleCall
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:159:1: entryRuleAbstractRuleCall : ruleAbstractRuleCall EOF ;
    public final void entryRuleAbstractRuleCall() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:159:27: ( ruleAbstractRuleCall EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:160:1: ruleAbstractRuleCall EOF
            {
             before(grammarAccess.getAbstractRuleCallRule()); 
            pushFollow(FOLLOW_ruleAbstractRuleCall_in_entryRuleAbstractRuleCall296);
            ruleAbstractRuleCall();
            _fsp--;

             after(grammarAccess.getAbstractRuleCallRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractRuleCall303); 

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
    // $ANTLR end entryRuleAbstractRuleCall


    // $ANTLR start ruleAbstractRuleCall
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:167:1: ruleAbstractRuleCall : ( ( ( ( RULE_ID ) ) ) ) ;
    public final void ruleAbstractRuleCall() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:171:2: ( ( ( ( ( RULE_ID ) ) ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:172:1: ( ( ( ( RULE_ID ) ) ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:172:1: ( ( ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:173:1: ( ( ( RULE_ID ) ) )
            {
             before(grammarAccess.getAbstractRuleCallAccess().getRuleAssignment()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:174:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:175:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:175:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:176:1: ( RULE_ID )
            {
             before(grammarAccess.getAbstractRuleCallAccess().getRuleAbstractRuleCrossReference_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:177:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:178:1: RULE_ID
            {
             before(grammarAccess.getAbstractRuleCallAccess().getRuleAbstractRuleIDTerminalRuleCall_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAbstractRuleCall341); 
             after(grammarAccess.getAbstractRuleCallAccess().getRuleAbstractRuleIDTerminalRuleCall_0_1()); 

            }

             after(grammarAccess.getAbstractRuleCallAccess().getRuleAbstractRuleCrossReference_0()); 

            }


            }

             after(grammarAccess.getAbstractRuleCallAccess().getRuleAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleAbstractRuleCall


    // $ANTLR start rule__AbstractRule__Alternatives
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:195:1: rule__AbstractRule__Alternatives : ( ( ruleFirstAbstractRuleChild ) | ( ruleSecondAbstractRuleChild ) );
    public final void rule__AbstractRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:199:1: ( ( ruleFirstAbstractRuleChild ) | ( ruleSecondAbstractRuleChild ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_ID) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==16) ) {
                    alt1=2;
                }
                else if ( (LA1_1==13) ) {
                    alt1=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("195:1: rule__AbstractRule__Alternatives : ( ( ruleFirstAbstractRuleChild ) | ( ruleSecondAbstractRuleChild ) );", 1, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("195:1: rule__AbstractRule__Alternatives : ( ( ruleFirstAbstractRuleChild ) | ( ruleSecondAbstractRuleChild ) );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:200:1: ( ruleFirstAbstractRuleChild )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:200:1: ( ruleFirstAbstractRuleChild )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:201:1: ruleFirstAbstractRuleChild
                    {
                     before(grammarAccess.getAbstractRuleAccess().getFirstAbstractRuleChildParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleFirstAbstractRuleChild_in_rule__AbstractRule__Alternatives386);
                    ruleFirstAbstractRuleChild();
                    _fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getFirstAbstractRuleChildParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:205:6: ( ruleSecondAbstractRuleChild )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:205:6: ( ruleSecondAbstractRuleChild )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:206:1: ruleSecondAbstractRuleChild
                    {
                     before(grammarAccess.getAbstractRuleAccess().getSecondAbstractRuleChildParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleSecondAbstractRuleChild_in_rule__AbstractRule__Alternatives402);
                    ruleSecondAbstractRuleChild();
                    _fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getSecondAbstractRuleChildParserRuleCall_1()); 

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
    // $ANTLR end rule__AbstractRule__Alternatives


    // $ANTLR start rule__Start__Group
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:216:1: rule__Start__Group : ( 'abstract rules' ) ( ( ( ruleAbstractRule ) )+ ) ( 'end' ) ;
    public final void rule__Start__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:220:1: ( ( 'abstract rules' ) ( ( ( ruleAbstractRule ) )+ ) ( 'end' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:221:1: ( 'abstract rules' ) ( ( ( ruleAbstractRule ) )+ ) ( 'end' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:221:1: ( 'abstract rules' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:222:1: 'abstract rules'
            {
             before(grammarAccess.getStartAccess().getAbstractRulesKeyword_0()); 
            match(input,11,FOLLOW_11_in_rule__Start__Group435); 
             after(grammarAccess.getStartAccess().getAbstractRulesKeyword_0()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:227:1: ( ( ( ruleAbstractRule ) )+ )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:228:1: ( ( ruleAbstractRule ) )+
            {
             before(grammarAccess.getStartAccess().getRulesAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:229:1: ( ( ruleAbstractRule ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:230:1: ( ruleAbstractRule )
            	    {
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:230:1: ( ruleAbstractRule )
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:231:1: ruleAbstractRule
            	    {
            	     before(grammarAccess.getStartAccess().getRulesAbstractRuleParserRuleCall_1_0()); 
            	    pushFollow(FOLLOW_ruleAbstractRule_in_rule__Start__Group454);
            	    ruleAbstractRule();
            	    _fsp--;

            	     after(grammarAccess.getStartAccess().getRulesAbstractRuleParserRuleCall_1_0()); 

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

             after(grammarAccess.getStartAccess().getRulesAssignment_1()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:237:1: ( 'end' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:238:1: 'end'
            {
             before(grammarAccess.getStartAccess().getEndKeyword_2()); 
            match(input,12,FOLLOW_12_in_rule__Start__Group473); 
             after(grammarAccess.getStartAccess().getEndKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Start__Group


    // $ANTLR start rule__FirstAbstractRuleChild__Group
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:249:1: rule__FirstAbstractRuleChild__Group : ( ( ( RULE_ID ) ) ) ( '(' ) ( ( ( ruleAbstractRule ) )+ ) ( ')' ) ( ';' ) ;
    public final void rule__FirstAbstractRuleChild__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:253:1: ( ( ( ( RULE_ID ) ) ) ( '(' ) ( ( ( ruleAbstractRule ) )+ ) ( ')' ) ( ';' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:254:1: ( ( ( RULE_ID ) ) ) ( '(' ) ( ( ( ruleAbstractRule ) )+ ) ( ')' ) ( ';' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:254:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:255:1: ( ( RULE_ID ) )
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getNameAssignment_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:256:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:257:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:257:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:258:1: RULE_ID
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FirstAbstractRuleChild__Group513); 
             after(grammarAccess.getFirstAbstractRuleChildAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

             after(grammarAccess.getFirstAbstractRuleChildAccess().getNameAssignment_0()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:264:1: ( '(' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:265:1: '('
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getLeftParenthesisKeyword_1()); 
            match(input,13,FOLLOW_13_in_rule__FirstAbstractRuleChild__Group531); 
             after(grammarAccess.getFirstAbstractRuleChildAccess().getLeftParenthesisKeyword_1()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:270:1: ( ( ( ruleAbstractRule ) )+ )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:271:1: ( ( ruleAbstractRule ) )+
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getElementsAssignment_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:272:1: ( ( ruleAbstractRule ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:273:1: ( ruleAbstractRule )
            	    {
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:273:1: ( ruleAbstractRule )
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:274:1: ruleAbstractRule
            	    {
            	     before(grammarAccess.getFirstAbstractRuleChildAccess().getElementsAbstractRuleParserRuleCall_2_0()); 
            	    pushFollow(FOLLOW_ruleAbstractRule_in_rule__FirstAbstractRuleChild__Group550);
            	    ruleAbstractRule();
            	    _fsp--;

            	     after(grammarAccess.getFirstAbstractRuleChildAccess().getElementsAbstractRuleParserRuleCall_2_0()); 

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

             after(grammarAccess.getFirstAbstractRuleChildAccess().getElementsAssignment_2()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:280:1: ( ')' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:281:1: ')'
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getRightParenthesisKeyword_3()); 
            match(input,14,FOLLOW_14_in_rule__FirstAbstractRuleChild__Group569); 
             after(grammarAccess.getFirstAbstractRuleChildAccess().getRightParenthesisKeyword_3()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:286:1: ( ';' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:287:1: ';'
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getSemicolonKeyword_4()); 
            match(input,15,FOLLOW_15_in_rule__FirstAbstractRuleChild__Group582); 
             after(grammarAccess.getFirstAbstractRuleChildAccess().getSemicolonKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FirstAbstractRuleChild__Group


    // $ANTLR start rule__SecondAbstractRuleChild__Group
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:298:1: rule__SecondAbstractRuleChild__Group : ( ( ( RULE_ID ) ) ) ( 'rule' ) ( ':' ) ( ( ( ruleAbstractRuleCall ) ) ) ( ';' ) ;
    public final void rule__SecondAbstractRuleChild__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:302:1: ( ( ( ( RULE_ID ) ) ) ( 'rule' ) ( ':' ) ( ( ( ruleAbstractRuleCall ) ) ) ( ';' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:303:1: ( ( ( RULE_ID ) ) ) ( 'rule' ) ( ':' ) ( ( ( ruleAbstractRuleCall ) ) ) ( ';' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:303:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:304:1: ( ( RULE_ID ) )
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getNameAssignment_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:305:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:306:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:306:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:307:1: RULE_ID
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SecondAbstractRuleChild__Group622); 
             after(grammarAccess.getSecondAbstractRuleChildAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

             after(grammarAccess.getSecondAbstractRuleChildAccess().getNameAssignment_0()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:313:1: ( 'rule' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:314:1: 'rule'
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getRuleKeyword_1()); 
            match(input,16,FOLLOW_16_in_rule__SecondAbstractRuleChild__Group640); 
             after(grammarAccess.getSecondAbstractRuleChildAccess().getRuleKeyword_1()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:319:1: ( ':' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:320:1: ':'
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getColonKeyword_2()); 
            match(input,17,FOLLOW_17_in_rule__SecondAbstractRuleChild__Group653); 
             after(grammarAccess.getSecondAbstractRuleChildAccess().getColonKeyword_2()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:325:1: ( ( ( ruleAbstractRuleCall ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:326:1: ( ( ruleAbstractRuleCall ) )
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getRuleAssignment_3()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:327:1: ( ( ruleAbstractRuleCall ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:328:1: ( ruleAbstractRuleCall )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:328:1: ( ruleAbstractRuleCall )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:329:1: ruleAbstractRuleCall
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getRuleAbstractRuleCallParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleAbstractRuleCall_in_rule__SecondAbstractRuleChild__Group672);
            ruleAbstractRuleCall();
            _fsp--;

             after(grammarAccess.getSecondAbstractRuleChildAccess().getRuleAbstractRuleCallParserRuleCall_3_0()); 

            }


            }

             after(grammarAccess.getSecondAbstractRuleChildAccess().getRuleAssignment_3()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:335:1: ( ';' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:336:1: ';'
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getSemicolonKeyword_4()); 
            match(input,15,FOLLOW_15_in_rule__SecondAbstractRuleChild__Group690); 
             after(grammarAccess.getSecondAbstractRuleChildAccess().getSemicolonKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SecondAbstractRuleChild__Group


 

    public static final BitSet FOLLOW_ruleStart_in_entryRuleStart60 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStart67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Start__Group_in_ruleStart94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule119 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRule126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractRule__Alternatives_in_ruleAbstractRule153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFirstAbstractRuleChild_in_entryRuleFirstAbstractRuleChild178 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFirstAbstractRuleChild185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FirstAbstractRuleChild__Group_in_ruleFirstAbstractRuleChild212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSecondAbstractRuleChild_in_entryRuleSecondAbstractRuleChild237 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSecondAbstractRuleChild244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SecondAbstractRuleChild__Group_in_ruleSecondAbstractRuleChild271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractRuleCall_in_entryRuleAbstractRuleCall296 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRuleCall303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAbstractRuleCall341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFirstAbstractRuleChild_in_rule__AbstractRule__Alternatives386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSecondAbstractRuleChild_in_rule__AbstractRule__Alternatives402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Start__Group435 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_rule__Start__Group454 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_12_in_rule__Start__Group473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FirstAbstractRuleChild__Group513 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_rule__FirstAbstractRuleChild__Group531 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_rule__FirstAbstractRuleChild__Group550 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_14_in_rule__FirstAbstractRuleChild__Group569 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_rule__FirstAbstractRuleChild__Group582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SecondAbstractRuleChild__Group622 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_rule__SecondAbstractRuleChild__Group640 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_rule__SecondAbstractRuleChild__Group653 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAbstractRuleCall_in_rule__SecondAbstractRuleChild__Group672 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_rule__SecondAbstractRuleChild__Group690 = new BitSet(new long[]{0x0000000000000002L});

}
package org.eclipse.xtext.ui.tests.testlanguages.ui.contentassist.antlr.internal; 

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
import org.eclipse.xtext.ui.tests.testlanguages.services.ContentAssistTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalContentAssistTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'abstract rules'", "'end'", "'('", "')'", "';'", "'rule'", "':'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalContentAssistTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g"; }


     
     	private ContentAssistTestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(ContentAssistTestLanguageGrammarAccess grammarAccess) {
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




    // $ANTLR start entryRuleStart
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:61:1: entryRuleStart : ruleStart EOF ;
    public final void entryRuleStart() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:62:1: ( ruleStart EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:63:1: ruleStart EOF
            {
             before(grammarAccess.getStartRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleStart_in_entryRuleStart61);
            ruleStart();
            _fsp--;

             after(grammarAccess.getStartRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStart68); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:70:1: ruleStart : ( ( rule__Start__Group__0 ) ) ;
    public final void ruleStart() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:74:2: ( ( ( rule__Start__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:75:1: ( ( rule__Start__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:75:1: ( ( rule__Start__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:76:1: ( rule__Start__Group__0 )
            {
             before(grammarAccess.getStartAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:77:1: ( rule__Start__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:77:2: rule__Start__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Start__Group__0_in_ruleStart94);
            rule__Start__Group__0();
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:89:1: entryRuleAbstractRule : ruleAbstractRule EOF ;
    public final void entryRuleAbstractRule() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:90:1: ( ruleAbstractRule EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:91:1: ruleAbstractRule EOF
            {
             before(grammarAccess.getAbstractRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule121);
            ruleAbstractRule();
            _fsp--;

             after(grammarAccess.getAbstractRuleRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractRule128); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:98:1: ruleAbstractRule : ( ( rule__AbstractRule__Alternatives ) ) ;
    public final void ruleAbstractRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:102:2: ( ( ( rule__AbstractRule__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:103:1: ( ( rule__AbstractRule__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:103:1: ( ( rule__AbstractRule__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:104:1: ( rule__AbstractRule__Alternatives )
            {
             before(grammarAccess.getAbstractRuleAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:105:1: ( rule__AbstractRule__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:105:2: rule__AbstractRule__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractRule__Alternatives_in_ruleAbstractRule154);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:117:1: entryRuleFirstAbstractRuleChild : ruleFirstAbstractRuleChild EOF ;
    public final void entryRuleFirstAbstractRuleChild() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:118:1: ( ruleFirstAbstractRuleChild EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:119:1: ruleFirstAbstractRuleChild EOF
            {
             before(grammarAccess.getFirstAbstractRuleChildRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFirstAbstractRuleChild_in_entryRuleFirstAbstractRuleChild181);
            ruleFirstAbstractRuleChild();
            _fsp--;

             after(grammarAccess.getFirstAbstractRuleChildRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFirstAbstractRuleChild188); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:126:1: ruleFirstAbstractRuleChild : ( ( rule__FirstAbstractRuleChild__Group__0 ) ) ;
    public final void ruleFirstAbstractRuleChild() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:130:2: ( ( ( rule__FirstAbstractRuleChild__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:131:1: ( ( rule__FirstAbstractRuleChild__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:131:1: ( ( rule__FirstAbstractRuleChild__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:132:1: ( rule__FirstAbstractRuleChild__Group__0 )
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:133:1: ( rule__FirstAbstractRuleChild__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:133:2: rule__FirstAbstractRuleChild__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__FirstAbstractRuleChild__Group__0_in_ruleFirstAbstractRuleChild214);
            rule__FirstAbstractRuleChild__Group__0();
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:145:1: entryRuleSecondAbstractRuleChild : ruleSecondAbstractRuleChild EOF ;
    public final void entryRuleSecondAbstractRuleChild() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:146:1: ( ruleSecondAbstractRuleChild EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:147:1: ruleSecondAbstractRuleChild EOF
            {
             before(grammarAccess.getSecondAbstractRuleChildRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSecondAbstractRuleChild_in_entryRuleSecondAbstractRuleChild241);
            ruleSecondAbstractRuleChild();
            _fsp--;

             after(grammarAccess.getSecondAbstractRuleChildRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSecondAbstractRuleChild248); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:154:1: ruleSecondAbstractRuleChild : ( ( rule__SecondAbstractRuleChild__Group__0 ) ) ;
    public final void ruleSecondAbstractRuleChild() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:158:2: ( ( ( rule__SecondAbstractRuleChild__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:159:1: ( ( rule__SecondAbstractRuleChild__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:159:1: ( ( rule__SecondAbstractRuleChild__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:160:1: ( rule__SecondAbstractRuleChild__Group__0 )
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:161:1: ( rule__SecondAbstractRuleChild__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:161:2: rule__SecondAbstractRuleChild__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__SecondAbstractRuleChild__Group__0_in_ruleSecondAbstractRuleChild274);
            rule__SecondAbstractRuleChild__Group__0();
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:173:1: entryRuleAbstractRuleCall : ruleAbstractRuleCall EOF ;
    public final void entryRuleAbstractRuleCall() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:174:1: ( ruleAbstractRuleCall EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:175:1: ruleAbstractRuleCall EOF
            {
             before(grammarAccess.getAbstractRuleCallRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractRuleCall_in_entryRuleAbstractRuleCall301);
            ruleAbstractRuleCall();
            _fsp--;

             after(grammarAccess.getAbstractRuleCallRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractRuleCall308); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:182:1: ruleAbstractRuleCall : ( ( rule__AbstractRuleCall__RuleAssignment ) ) ;
    public final void ruleAbstractRuleCall() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:186:2: ( ( ( rule__AbstractRuleCall__RuleAssignment ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:187:1: ( ( rule__AbstractRuleCall__RuleAssignment ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:187:1: ( ( rule__AbstractRuleCall__RuleAssignment ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:188:1: ( rule__AbstractRuleCall__RuleAssignment )
            {
             before(grammarAccess.getAbstractRuleCallAccess().getRuleAssignment()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:189:1: ( rule__AbstractRuleCall__RuleAssignment )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:189:2: rule__AbstractRuleCall__RuleAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractRuleCall__RuleAssignment_in_ruleAbstractRuleCall334);
            rule__AbstractRuleCall__RuleAssignment();
            _fsp--;


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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:201:1: rule__AbstractRule__Alternatives : ( ( ruleFirstAbstractRuleChild ) | ( ruleSecondAbstractRuleChild ) );
    public final void rule__AbstractRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:205:1: ( ( ruleFirstAbstractRuleChild ) | ( ruleSecondAbstractRuleChild ) )
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
                        new NoViableAltException("201:1: rule__AbstractRule__Alternatives : ( ( ruleFirstAbstractRuleChild ) | ( ruleSecondAbstractRuleChild ) );", 1, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("201:1: rule__AbstractRule__Alternatives : ( ( ruleFirstAbstractRuleChild ) | ( ruleSecondAbstractRuleChild ) );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:206:1: ( ruleFirstAbstractRuleChild )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:206:1: ( ruleFirstAbstractRuleChild )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:207:1: ruleFirstAbstractRuleChild
                    {
                     before(grammarAccess.getAbstractRuleAccess().getFirstAbstractRuleChildParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleFirstAbstractRuleChild_in_rule__AbstractRule__Alternatives370);
                    ruleFirstAbstractRuleChild();
                    _fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getFirstAbstractRuleChildParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:212:6: ( ruleSecondAbstractRuleChild )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:212:6: ( ruleSecondAbstractRuleChild )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:213:1: ruleSecondAbstractRuleChild
                    {
                     before(grammarAccess.getAbstractRuleAccess().getSecondAbstractRuleChildParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleSecondAbstractRuleChild_in_rule__AbstractRule__Alternatives387);
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


    // $ANTLR start rule__Start__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:225:1: rule__Start__Group__0 : rule__Start__Group__0__Impl rule__Start__Group__1 ;
    public final void rule__Start__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:229:1: ( rule__Start__Group__0__Impl rule__Start__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:230:2: rule__Start__Group__0__Impl rule__Start__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Start__Group__0__Impl_in_rule__Start__Group__0417);
            rule__Start__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Start__Group__1_in_rule__Start__Group__0420);
            rule__Start__Group__1();
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
    // $ANTLR end rule__Start__Group__0


    // $ANTLR start rule__Start__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:237:1: rule__Start__Group__0__Impl : ( 'abstract rules' ) ;
    public final void rule__Start__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:241:1: ( ( 'abstract rules' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:242:1: ( 'abstract rules' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:242:1: ( 'abstract rules' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:243:1: 'abstract rules'
            {
             before(grammarAccess.getStartAccess().getAbstractRulesKeyword_0()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Start__Group__0__Impl448); 
             after(grammarAccess.getStartAccess().getAbstractRulesKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Start__Group__0__Impl


    // $ANTLR start rule__Start__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:256:1: rule__Start__Group__1 : rule__Start__Group__1__Impl rule__Start__Group__2 ;
    public final void rule__Start__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:260:1: ( rule__Start__Group__1__Impl rule__Start__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:261:2: rule__Start__Group__1__Impl rule__Start__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Start__Group__1__Impl_in_rule__Start__Group__1479);
            rule__Start__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Start__Group__2_in_rule__Start__Group__1482);
            rule__Start__Group__2();
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
    // $ANTLR end rule__Start__Group__1


    // $ANTLR start rule__Start__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:268:1: rule__Start__Group__1__Impl : ( ( ( rule__Start__RulesAssignment_1 ) ) ( ( rule__Start__RulesAssignment_1 )* ) ) ;
    public final void rule__Start__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:272:1: ( ( ( ( rule__Start__RulesAssignment_1 ) ) ( ( rule__Start__RulesAssignment_1 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:273:1: ( ( ( rule__Start__RulesAssignment_1 ) ) ( ( rule__Start__RulesAssignment_1 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:273:1: ( ( ( rule__Start__RulesAssignment_1 ) ) ( ( rule__Start__RulesAssignment_1 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:274:1: ( ( rule__Start__RulesAssignment_1 ) ) ( ( rule__Start__RulesAssignment_1 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:274:1: ( ( rule__Start__RulesAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:275:1: ( rule__Start__RulesAssignment_1 )
            {
             before(grammarAccess.getStartAccess().getRulesAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:276:1: ( rule__Start__RulesAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:276:2: rule__Start__RulesAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Start__RulesAssignment_1_in_rule__Start__Group__1__Impl511);
            rule__Start__RulesAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getStartAccess().getRulesAssignment_1()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:279:1: ( ( rule__Start__RulesAssignment_1 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:280:1: ( rule__Start__RulesAssignment_1 )*
            {
             before(grammarAccess.getStartAccess().getRulesAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:281:1: ( rule__Start__RulesAssignment_1 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:281:2: rule__Start__RulesAssignment_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Start__RulesAssignment_1_in_rule__Start__Group__1__Impl523);
            	    rule__Start__RulesAssignment_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getStartAccess().getRulesAssignment_1()); 

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
    // $ANTLR end rule__Start__Group__1__Impl


    // $ANTLR start rule__Start__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:292:1: rule__Start__Group__2 : rule__Start__Group__2__Impl ;
    public final void rule__Start__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:296:1: ( rule__Start__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:297:2: rule__Start__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Start__Group__2__Impl_in_rule__Start__Group__2556);
            rule__Start__Group__2__Impl();
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
    // $ANTLR end rule__Start__Group__2


    // $ANTLR start rule__Start__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:303:1: rule__Start__Group__2__Impl : ( 'end' ) ;
    public final void rule__Start__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:307:1: ( ( 'end' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:308:1: ( 'end' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:308:1: ( 'end' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:309:1: 'end'
            {
             before(grammarAccess.getStartAccess().getEndKeyword_2()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Start__Group__2__Impl584); 
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
    // $ANTLR end rule__Start__Group__2__Impl


    // $ANTLR start rule__FirstAbstractRuleChild__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:328:1: rule__FirstAbstractRuleChild__Group__0 : rule__FirstAbstractRuleChild__Group__0__Impl rule__FirstAbstractRuleChild__Group__1 ;
    public final void rule__FirstAbstractRuleChild__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:332:1: ( rule__FirstAbstractRuleChild__Group__0__Impl rule__FirstAbstractRuleChild__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:333:2: rule__FirstAbstractRuleChild__Group__0__Impl rule__FirstAbstractRuleChild__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FirstAbstractRuleChild__Group__0__Impl_in_rule__FirstAbstractRuleChild__Group__0621);
            rule__FirstAbstractRuleChild__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__FirstAbstractRuleChild__Group__1_in_rule__FirstAbstractRuleChild__Group__0624);
            rule__FirstAbstractRuleChild__Group__1();
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
    // $ANTLR end rule__FirstAbstractRuleChild__Group__0


    // $ANTLR start rule__FirstAbstractRuleChild__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:340:1: rule__FirstAbstractRuleChild__Group__0__Impl : ( ( rule__FirstAbstractRuleChild__NameAssignment_0 ) ) ;
    public final void rule__FirstAbstractRuleChild__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:344:1: ( ( ( rule__FirstAbstractRuleChild__NameAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:345:1: ( ( rule__FirstAbstractRuleChild__NameAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:345:1: ( ( rule__FirstAbstractRuleChild__NameAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:346:1: ( rule__FirstAbstractRuleChild__NameAssignment_0 )
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getNameAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:347:1: ( rule__FirstAbstractRuleChild__NameAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:347:2: rule__FirstAbstractRuleChild__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__FirstAbstractRuleChild__NameAssignment_0_in_rule__FirstAbstractRuleChild__Group__0__Impl651);
            rule__FirstAbstractRuleChild__NameAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getFirstAbstractRuleChildAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FirstAbstractRuleChild__Group__0__Impl


    // $ANTLR start rule__FirstAbstractRuleChild__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:357:1: rule__FirstAbstractRuleChild__Group__1 : rule__FirstAbstractRuleChild__Group__1__Impl rule__FirstAbstractRuleChild__Group__2 ;
    public final void rule__FirstAbstractRuleChild__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:361:1: ( rule__FirstAbstractRuleChild__Group__1__Impl rule__FirstAbstractRuleChild__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:362:2: rule__FirstAbstractRuleChild__Group__1__Impl rule__FirstAbstractRuleChild__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__FirstAbstractRuleChild__Group__1__Impl_in_rule__FirstAbstractRuleChild__Group__1681);
            rule__FirstAbstractRuleChild__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__FirstAbstractRuleChild__Group__2_in_rule__FirstAbstractRuleChild__Group__1684);
            rule__FirstAbstractRuleChild__Group__2();
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
    // $ANTLR end rule__FirstAbstractRuleChild__Group__1


    // $ANTLR start rule__FirstAbstractRuleChild__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:369:1: rule__FirstAbstractRuleChild__Group__1__Impl : ( '(' ) ;
    public final void rule__FirstAbstractRuleChild__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:373:1: ( ( '(' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:374:1: ( '(' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:374:1: ( '(' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:375:1: '('
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getLeftParenthesisKeyword_1()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__FirstAbstractRuleChild__Group__1__Impl712); 
             after(grammarAccess.getFirstAbstractRuleChildAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FirstAbstractRuleChild__Group__1__Impl


    // $ANTLR start rule__FirstAbstractRuleChild__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:388:1: rule__FirstAbstractRuleChild__Group__2 : rule__FirstAbstractRuleChild__Group__2__Impl rule__FirstAbstractRuleChild__Group__3 ;
    public final void rule__FirstAbstractRuleChild__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:392:1: ( rule__FirstAbstractRuleChild__Group__2__Impl rule__FirstAbstractRuleChild__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:393:2: rule__FirstAbstractRuleChild__Group__2__Impl rule__FirstAbstractRuleChild__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__FirstAbstractRuleChild__Group__2__Impl_in_rule__FirstAbstractRuleChild__Group__2743);
            rule__FirstAbstractRuleChild__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__FirstAbstractRuleChild__Group__3_in_rule__FirstAbstractRuleChild__Group__2746);
            rule__FirstAbstractRuleChild__Group__3();
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
    // $ANTLR end rule__FirstAbstractRuleChild__Group__2


    // $ANTLR start rule__FirstAbstractRuleChild__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:400:1: rule__FirstAbstractRuleChild__Group__2__Impl : ( ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 ) ) ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )* ) ) ;
    public final void rule__FirstAbstractRuleChild__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:404:1: ( ( ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 ) ) ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:405:1: ( ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 ) ) ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:405:1: ( ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 ) ) ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:406:1: ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 ) ) ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:406:1: ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:407:1: ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getElementsAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:408:1: ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:408:2: rule__FirstAbstractRuleChild__ElementsAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__FirstAbstractRuleChild__ElementsAssignment_2_in_rule__FirstAbstractRuleChild__Group__2__Impl775);
            rule__FirstAbstractRuleChild__ElementsAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getFirstAbstractRuleChildAccess().getElementsAssignment_2()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:411:1: ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:412:1: ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )*
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getElementsAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:413:1: ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:413:2: rule__FirstAbstractRuleChild__ElementsAssignment_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__FirstAbstractRuleChild__ElementsAssignment_2_in_rule__FirstAbstractRuleChild__Group__2__Impl787);
            	    rule__FirstAbstractRuleChild__ElementsAssignment_2();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getFirstAbstractRuleChildAccess().getElementsAssignment_2()); 

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
    // $ANTLR end rule__FirstAbstractRuleChild__Group__2__Impl


    // $ANTLR start rule__FirstAbstractRuleChild__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:424:1: rule__FirstAbstractRuleChild__Group__3 : rule__FirstAbstractRuleChild__Group__3__Impl rule__FirstAbstractRuleChild__Group__4 ;
    public final void rule__FirstAbstractRuleChild__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:428:1: ( rule__FirstAbstractRuleChild__Group__3__Impl rule__FirstAbstractRuleChild__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:429:2: rule__FirstAbstractRuleChild__Group__3__Impl rule__FirstAbstractRuleChild__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__FirstAbstractRuleChild__Group__3__Impl_in_rule__FirstAbstractRuleChild__Group__3820);
            rule__FirstAbstractRuleChild__Group__3__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__FirstAbstractRuleChild__Group__4_in_rule__FirstAbstractRuleChild__Group__3823);
            rule__FirstAbstractRuleChild__Group__4();
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
    // $ANTLR end rule__FirstAbstractRuleChild__Group__3


    // $ANTLR start rule__FirstAbstractRuleChild__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:436:1: rule__FirstAbstractRuleChild__Group__3__Impl : ( ')' ) ;
    public final void rule__FirstAbstractRuleChild__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:440:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:441:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:441:1: ( ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:442:1: ')'
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getRightParenthesisKeyword_3()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__FirstAbstractRuleChild__Group__3__Impl851); 
             after(grammarAccess.getFirstAbstractRuleChildAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FirstAbstractRuleChild__Group__3__Impl


    // $ANTLR start rule__FirstAbstractRuleChild__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:455:1: rule__FirstAbstractRuleChild__Group__4 : rule__FirstAbstractRuleChild__Group__4__Impl ;
    public final void rule__FirstAbstractRuleChild__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:459:1: ( rule__FirstAbstractRuleChild__Group__4__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:460:2: rule__FirstAbstractRuleChild__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__FirstAbstractRuleChild__Group__4__Impl_in_rule__FirstAbstractRuleChild__Group__4882);
            rule__FirstAbstractRuleChild__Group__4__Impl();
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
    // $ANTLR end rule__FirstAbstractRuleChild__Group__4


    // $ANTLR start rule__FirstAbstractRuleChild__Group__4__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:466:1: rule__FirstAbstractRuleChild__Group__4__Impl : ( ';' ) ;
    public final void rule__FirstAbstractRuleChild__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:470:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:471:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:471:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:472:1: ';'
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getSemicolonKeyword_4()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__FirstAbstractRuleChild__Group__4__Impl910); 
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
    // $ANTLR end rule__FirstAbstractRuleChild__Group__4__Impl


    // $ANTLR start rule__SecondAbstractRuleChild__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:495:1: rule__SecondAbstractRuleChild__Group__0 : rule__SecondAbstractRuleChild__Group__0__Impl rule__SecondAbstractRuleChild__Group__1 ;
    public final void rule__SecondAbstractRuleChild__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:499:1: ( rule__SecondAbstractRuleChild__Group__0__Impl rule__SecondAbstractRuleChild__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:500:2: rule__SecondAbstractRuleChild__Group__0__Impl rule__SecondAbstractRuleChild__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__SecondAbstractRuleChild__Group__0__Impl_in_rule__SecondAbstractRuleChild__Group__0951);
            rule__SecondAbstractRuleChild__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__SecondAbstractRuleChild__Group__1_in_rule__SecondAbstractRuleChild__Group__0954);
            rule__SecondAbstractRuleChild__Group__1();
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
    // $ANTLR end rule__SecondAbstractRuleChild__Group__0


    // $ANTLR start rule__SecondAbstractRuleChild__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:507:1: rule__SecondAbstractRuleChild__Group__0__Impl : ( ( rule__SecondAbstractRuleChild__NameAssignment_0 ) ) ;
    public final void rule__SecondAbstractRuleChild__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:511:1: ( ( ( rule__SecondAbstractRuleChild__NameAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:512:1: ( ( rule__SecondAbstractRuleChild__NameAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:512:1: ( ( rule__SecondAbstractRuleChild__NameAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:513:1: ( rule__SecondAbstractRuleChild__NameAssignment_0 )
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getNameAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:514:1: ( rule__SecondAbstractRuleChild__NameAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:514:2: rule__SecondAbstractRuleChild__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__SecondAbstractRuleChild__NameAssignment_0_in_rule__SecondAbstractRuleChild__Group__0__Impl981);
            rule__SecondAbstractRuleChild__NameAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getSecondAbstractRuleChildAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SecondAbstractRuleChild__Group__0__Impl


    // $ANTLR start rule__SecondAbstractRuleChild__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:524:1: rule__SecondAbstractRuleChild__Group__1 : rule__SecondAbstractRuleChild__Group__1__Impl rule__SecondAbstractRuleChild__Group__2 ;
    public final void rule__SecondAbstractRuleChild__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:528:1: ( rule__SecondAbstractRuleChild__Group__1__Impl rule__SecondAbstractRuleChild__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:529:2: rule__SecondAbstractRuleChild__Group__1__Impl rule__SecondAbstractRuleChild__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__SecondAbstractRuleChild__Group__1__Impl_in_rule__SecondAbstractRuleChild__Group__11011);
            rule__SecondAbstractRuleChild__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__SecondAbstractRuleChild__Group__2_in_rule__SecondAbstractRuleChild__Group__11014);
            rule__SecondAbstractRuleChild__Group__2();
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
    // $ANTLR end rule__SecondAbstractRuleChild__Group__1


    // $ANTLR start rule__SecondAbstractRuleChild__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:536:1: rule__SecondAbstractRuleChild__Group__1__Impl : ( 'rule' ) ;
    public final void rule__SecondAbstractRuleChild__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:540:1: ( ( 'rule' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:541:1: ( 'rule' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:541:1: ( 'rule' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:542:1: 'rule'
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getRuleKeyword_1()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__SecondAbstractRuleChild__Group__1__Impl1042); 
             after(grammarAccess.getSecondAbstractRuleChildAccess().getRuleKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SecondAbstractRuleChild__Group__1__Impl


    // $ANTLR start rule__SecondAbstractRuleChild__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:555:1: rule__SecondAbstractRuleChild__Group__2 : rule__SecondAbstractRuleChild__Group__2__Impl rule__SecondAbstractRuleChild__Group__3 ;
    public final void rule__SecondAbstractRuleChild__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:559:1: ( rule__SecondAbstractRuleChild__Group__2__Impl rule__SecondAbstractRuleChild__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:560:2: rule__SecondAbstractRuleChild__Group__2__Impl rule__SecondAbstractRuleChild__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__SecondAbstractRuleChild__Group__2__Impl_in_rule__SecondAbstractRuleChild__Group__21073);
            rule__SecondAbstractRuleChild__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__SecondAbstractRuleChild__Group__3_in_rule__SecondAbstractRuleChild__Group__21076);
            rule__SecondAbstractRuleChild__Group__3();
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
    // $ANTLR end rule__SecondAbstractRuleChild__Group__2


    // $ANTLR start rule__SecondAbstractRuleChild__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:567:1: rule__SecondAbstractRuleChild__Group__2__Impl : ( ':' ) ;
    public final void rule__SecondAbstractRuleChild__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:571:1: ( ( ':' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:572:1: ( ':' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:572:1: ( ':' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:573:1: ':'
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getColonKeyword_2()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__SecondAbstractRuleChild__Group__2__Impl1104); 
             after(grammarAccess.getSecondAbstractRuleChildAccess().getColonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SecondAbstractRuleChild__Group__2__Impl


    // $ANTLR start rule__SecondAbstractRuleChild__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:586:1: rule__SecondAbstractRuleChild__Group__3 : rule__SecondAbstractRuleChild__Group__3__Impl rule__SecondAbstractRuleChild__Group__4 ;
    public final void rule__SecondAbstractRuleChild__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:590:1: ( rule__SecondAbstractRuleChild__Group__3__Impl rule__SecondAbstractRuleChild__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:591:2: rule__SecondAbstractRuleChild__Group__3__Impl rule__SecondAbstractRuleChild__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__SecondAbstractRuleChild__Group__3__Impl_in_rule__SecondAbstractRuleChild__Group__31135);
            rule__SecondAbstractRuleChild__Group__3__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__SecondAbstractRuleChild__Group__4_in_rule__SecondAbstractRuleChild__Group__31138);
            rule__SecondAbstractRuleChild__Group__4();
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
    // $ANTLR end rule__SecondAbstractRuleChild__Group__3


    // $ANTLR start rule__SecondAbstractRuleChild__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:598:1: rule__SecondAbstractRuleChild__Group__3__Impl : ( ( rule__SecondAbstractRuleChild__RuleAssignment_3 ) ) ;
    public final void rule__SecondAbstractRuleChild__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:602:1: ( ( ( rule__SecondAbstractRuleChild__RuleAssignment_3 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:603:1: ( ( rule__SecondAbstractRuleChild__RuleAssignment_3 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:603:1: ( ( rule__SecondAbstractRuleChild__RuleAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:604:1: ( rule__SecondAbstractRuleChild__RuleAssignment_3 )
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getRuleAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:605:1: ( rule__SecondAbstractRuleChild__RuleAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:605:2: rule__SecondAbstractRuleChild__RuleAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__SecondAbstractRuleChild__RuleAssignment_3_in_rule__SecondAbstractRuleChild__Group__3__Impl1165);
            rule__SecondAbstractRuleChild__RuleAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getSecondAbstractRuleChildAccess().getRuleAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SecondAbstractRuleChild__Group__3__Impl


    // $ANTLR start rule__SecondAbstractRuleChild__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:615:1: rule__SecondAbstractRuleChild__Group__4 : rule__SecondAbstractRuleChild__Group__4__Impl ;
    public final void rule__SecondAbstractRuleChild__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:619:1: ( rule__SecondAbstractRuleChild__Group__4__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:620:2: rule__SecondAbstractRuleChild__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__SecondAbstractRuleChild__Group__4__Impl_in_rule__SecondAbstractRuleChild__Group__41195);
            rule__SecondAbstractRuleChild__Group__4__Impl();
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
    // $ANTLR end rule__SecondAbstractRuleChild__Group__4


    // $ANTLR start rule__SecondAbstractRuleChild__Group__4__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:626:1: rule__SecondAbstractRuleChild__Group__4__Impl : ( ';' ) ;
    public final void rule__SecondAbstractRuleChild__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:630:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:631:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:631:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:632:1: ';'
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getSemicolonKeyword_4()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__SecondAbstractRuleChild__Group__4__Impl1223); 
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
    // $ANTLR end rule__SecondAbstractRuleChild__Group__4__Impl


    // $ANTLR start rule__Start__RulesAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:656:1: rule__Start__RulesAssignment_1 : ( ruleAbstractRule ) ;
    public final void rule__Start__RulesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:660:1: ( ( ruleAbstractRule ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:661:1: ( ruleAbstractRule )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:661:1: ( ruleAbstractRule )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:662:1: ruleAbstractRule
            {
             before(grammarAccess.getStartAccess().getRulesAbstractRuleParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractRule_in_rule__Start__RulesAssignment_11269);
            ruleAbstractRule();
            _fsp--;

             after(grammarAccess.getStartAccess().getRulesAbstractRuleParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Start__RulesAssignment_1


    // $ANTLR start rule__FirstAbstractRuleChild__NameAssignment_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:671:1: rule__FirstAbstractRuleChild__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__FirstAbstractRuleChild__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:675:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:676:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:676:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:677:1: RULE_ID
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__FirstAbstractRuleChild__NameAssignment_01300); 
             after(grammarAccess.getFirstAbstractRuleChildAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FirstAbstractRuleChild__NameAssignment_0


    // $ANTLR start rule__FirstAbstractRuleChild__ElementsAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:686:1: rule__FirstAbstractRuleChild__ElementsAssignment_2 : ( ruleAbstractRule ) ;
    public final void rule__FirstAbstractRuleChild__ElementsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:690:1: ( ( ruleAbstractRule ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:691:1: ( ruleAbstractRule )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:691:1: ( ruleAbstractRule )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:692:1: ruleAbstractRule
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getElementsAbstractRuleParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractRule_in_rule__FirstAbstractRuleChild__ElementsAssignment_21331);
            ruleAbstractRule();
            _fsp--;

             after(grammarAccess.getFirstAbstractRuleChildAccess().getElementsAbstractRuleParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FirstAbstractRuleChild__ElementsAssignment_2


    // $ANTLR start rule__SecondAbstractRuleChild__NameAssignment_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:701:1: rule__SecondAbstractRuleChild__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__SecondAbstractRuleChild__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:705:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:706:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:706:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:707:1: RULE_ID
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__SecondAbstractRuleChild__NameAssignment_01362); 
             after(grammarAccess.getSecondAbstractRuleChildAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SecondAbstractRuleChild__NameAssignment_0


    // $ANTLR start rule__SecondAbstractRuleChild__RuleAssignment_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:716:1: rule__SecondAbstractRuleChild__RuleAssignment_3 : ( ruleAbstractRuleCall ) ;
    public final void rule__SecondAbstractRuleChild__RuleAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:720:1: ( ( ruleAbstractRuleCall ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:721:1: ( ruleAbstractRuleCall )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:721:1: ( ruleAbstractRuleCall )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:722:1: ruleAbstractRuleCall
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getRuleAbstractRuleCallParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractRuleCall_in_rule__SecondAbstractRuleChild__RuleAssignment_31393);
            ruleAbstractRuleCall();
            _fsp--;

             after(grammarAccess.getSecondAbstractRuleChildAccess().getRuleAbstractRuleCallParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SecondAbstractRuleChild__RuleAssignment_3


    // $ANTLR start rule__AbstractRuleCall__RuleAssignment
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:731:1: rule__AbstractRuleCall__RuleAssignment : ( ( RULE_ID ) ) ;
    public final void rule__AbstractRuleCall__RuleAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:735:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:736:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:736:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:737:1: ( RULE_ID )
            {
             before(grammarAccess.getAbstractRuleCallAccess().getRuleAbstractRuleCrossReference_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:738:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:739:1: RULE_ID
            {
             before(grammarAccess.getAbstractRuleCallAccess().getRuleAbstractRuleIDTerminalRuleCall_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__AbstractRuleCall__RuleAssignment1428); 
             after(grammarAccess.getAbstractRuleCallAccess().getRuleAbstractRuleIDTerminalRuleCall_0_1()); 

            }

             after(grammarAccess.getAbstractRuleCallAccess().getRuleAbstractRuleCrossReference_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AbstractRuleCall__RuleAssignment


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleStart_in_entryRuleStart61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStart68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Start__Group__0_in_ruleStart94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRule128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractRule__Alternatives_in_ruleAbstractRule154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstAbstractRuleChild_in_entryRuleFirstAbstractRuleChild181 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFirstAbstractRuleChild188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FirstAbstractRuleChild__Group__0_in_ruleFirstAbstractRuleChild214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSecondAbstractRuleChild_in_entryRuleSecondAbstractRuleChild241 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSecondAbstractRuleChild248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SecondAbstractRuleChild__Group__0_in_ruleSecondAbstractRuleChild274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractRuleCall_in_entryRuleAbstractRuleCall301 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRuleCall308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractRuleCall__RuleAssignment_in_ruleAbstractRuleCall334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstAbstractRuleChild_in_rule__AbstractRule__Alternatives370 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSecondAbstractRuleChild_in_rule__AbstractRule__Alternatives387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Start__Group__0__Impl_in_rule__Start__Group__0417 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Start__Group__1_in_rule__Start__Group__0420 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Start__Group__0__Impl448 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Start__Group__1__Impl_in_rule__Start__Group__1479 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rule__Start__Group__2_in_rule__Start__Group__1482 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Start__RulesAssignment_1_in_rule__Start__Group__1__Impl511 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__Start__RulesAssignment_1_in_rule__Start__Group__1__Impl523 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__Start__Group__2__Impl_in_rule__Start__Group__2556 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Start__Group__2__Impl584 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FirstAbstractRuleChild__Group__0__Impl_in_rule__FirstAbstractRuleChild__Group__0621 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__FirstAbstractRuleChild__Group__1_in_rule__FirstAbstractRuleChild__Group__0624 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FirstAbstractRuleChild__NameAssignment_0_in_rule__FirstAbstractRuleChild__Group__0__Impl651 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FirstAbstractRuleChild__Group__1__Impl_in_rule__FirstAbstractRuleChild__Group__1681 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__FirstAbstractRuleChild__Group__2_in_rule__FirstAbstractRuleChild__Group__1684 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__FirstAbstractRuleChild__Group__1__Impl712 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FirstAbstractRuleChild__Group__2__Impl_in_rule__FirstAbstractRuleChild__Group__2743 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__FirstAbstractRuleChild__Group__3_in_rule__FirstAbstractRuleChild__Group__2746 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FirstAbstractRuleChild__ElementsAssignment_2_in_rule__FirstAbstractRuleChild__Group__2__Impl775 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__FirstAbstractRuleChild__ElementsAssignment_2_in_rule__FirstAbstractRuleChild__Group__2__Impl787 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__FirstAbstractRuleChild__Group__3__Impl_in_rule__FirstAbstractRuleChild__Group__3820 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_rule__FirstAbstractRuleChild__Group__4_in_rule__FirstAbstractRuleChild__Group__3823 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__FirstAbstractRuleChild__Group__3__Impl851 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FirstAbstractRuleChild__Group__4__Impl_in_rule__FirstAbstractRuleChild__Group__4882 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__FirstAbstractRuleChild__Group__4__Impl910 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SecondAbstractRuleChild__Group__0__Impl_in_rule__SecondAbstractRuleChild__Group__0951 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_rule__SecondAbstractRuleChild__Group__1_in_rule__SecondAbstractRuleChild__Group__0954 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SecondAbstractRuleChild__NameAssignment_0_in_rule__SecondAbstractRuleChild__Group__0__Impl981 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SecondAbstractRuleChild__Group__1__Impl_in_rule__SecondAbstractRuleChild__Group__11011 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_rule__SecondAbstractRuleChild__Group__2_in_rule__SecondAbstractRuleChild__Group__11014 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__SecondAbstractRuleChild__Group__1__Impl1042 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SecondAbstractRuleChild__Group__2__Impl_in_rule__SecondAbstractRuleChild__Group__21073 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__SecondAbstractRuleChild__Group__3_in_rule__SecondAbstractRuleChild__Group__21076 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__SecondAbstractRuleChild__Group__2__Impl1104 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SecondAbstractRuleChild__Group__3__Impl_in_rule__SecondAbstractRuleChild__Group__31135 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_rule__SecondAbstractRuleChild__Group__4_in_rule__SecondAbstractRuleChild__Group__31138 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SecondAbstractRuleChild__RuleAssignment_3_in_rule__SecondAbstractRuleChild__Group__3__Impl1165 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SecondAbstractRuleChild__Group__4__Impl_in_rule__SecondAbstractRuleChild__Group__41195 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__SecondAbstractRuleChild__Group__4__Impl1223 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractRule_in_rule__Start__RulesAssignment_11269 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__FirstAbstractRuleChild__NameAssignment_01300 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractRule_in_rule__FirstAbstractRuleChild__ElementsAssignment_21331 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__SecondAbstractRuleChild__NameAssignment_01362 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractRuleCall_in_rule__SecondAbstractRuleChild__RuleAssignment_31393 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__AbstractRuleCall__RuleAssignment1428 = new BitSet(new long[]{0x0000000000000002L});
    }


}
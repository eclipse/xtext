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
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start entryRuleStart
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:60:1: entryRuleStart : ruleStart EOF ;
    public final void entryRuleStart() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:60:16: ( ruleStart EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:61:1: ruleStart EOF
            {
             before(grammarAccess.getStartRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleStart_in_entryRuleStart60);
            ruleStart();
            _fsp--;

             after(grammarAccess.getStartRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStart67); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:68:1: ruleStart : ( ( rule__Start__Group__0 ) ) ;
    public final void ruleStart() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:72:2: ( ( ( rule__Start__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:73:1: ( ( rule__Start__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:73:1: ( ( rule__Start__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:74:1: ( rule__Start__Group__0 )
            {
             before(grammarAccess.getStartAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:75:1: ( rule__Start__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:75:2: rule__Start__Group__0
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:87:1: entryRuleAbstractRule : ruleAbstractRule EOF ;
    public final void entryRuleAbstractRule() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:87:23: ( ruleAbstractRule EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:88:1: ruleAbstractRule EOF
            {
             before(grammarAccess.getAbstractRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule120);
            ruleAbstractRule();
            _fsp--;

             after(grammarAccess.getAbstractRuleRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractRule127); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:95:1: ruleAbstractRule : ( ( rule__AbstractRule__Alternatives ) ) ;
    public final void ruleAbstractRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:99:2: ( ( ( rule__AbstractRule__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:100:1: ( ( rule__AbstractRule__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:100:1: ( ( rule__AbstractRule__Alternatives ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:101:1: ( rule__AbstractRule__Alternatives )
            {
             before(grammarAccess.getAbstractRuleAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:102:1: ( rule__AbstractRule__Alternatives )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:102:2: rule__AbstractRule__Alternatives
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:114:1: entryRuleFirstAbstractRuleChild : ruleFirstAbstractRuleChild EOF ;
    public final void entryRuleFirstAbstractRuleChild() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:114:33: ( ruleFirstAbstractRuleChild EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:115:1: ruleFirstAbstractRuleChild EOF
            {
             before(grammarAccess.getFirstAbstractRuleChildRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFirstAbstractRuleChild_in_entryRuleFirstAbstractRuleChild180);
            ruleFirstAbstractRuleChild();
            _fsp--;

             after(grammarAccess.getFirstAbstractRuleChildRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFirstAbstractRuleChild187); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:122:1: ruleFirstAbstractRuleChild : ( ( rule__FirstAbstractRuleChild__Group__0 ) ) ;
    public final void ruleFirstAbstractRuleChild() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:126:2: ( ( ( rule__FirstAbstractRuleChild__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:127:1: ( ( rule__FirstAbstractRuleChild__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:127:1: ( ( rule__FirstAbstractRuleChild__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:128:1: ( rule__FirstAbstractRuleChild__Group__0 )
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:129:1: ( rule__FirstAbstractRuleChild__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:129:2: rule__FirstAbstractRuleChild__Group__0
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:141:1: entryRuleSecondAbstractRuleChild : ruleSecondAbstractRuleChild EOF ;
    public final void entryRuleSecondAbstractRuleChild() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:141:34: ( ruleSecondAbstractRuleChild EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:142:1: ruleSecondAbstractRuleChild EOF
            {
             before(grammarAccess.getSecondAbstractRuleChildRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSecondAbstractRuleChild_in_entryRuleSecondAbstractRuleChild240);
            ruleSecondAbstractRuleChild();
            _fsp--;

             after(grammarAccess.getSecondAbstractRuleChildRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSecondAbstractRuleChild247); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:149:1: ruleSecondAbstractRuleChild : ( ( rule__SecondAbstractRuleChild__Group__0 ) ) ;
    public final void ruleSecondAbstractRuleChild() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:153:2: ( ( ( rule__SecondAbstractRuleChild__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:154:1: ( ( rule__SecondAbstractRuleChild__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:154:1: ( ( rule__SecondAbstractRuleChild__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:155:1: ( rule__SecondAbstractRuleChild__Group__0 )
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:156:1: ( rule__SecondAbstractRuleChild__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:156:2: rule__SecondAbstractRuleChild__Group__0
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:168:1: entryRuleAbstractRuleCall : ruleAbstractRuleCall EOF ;
    public final void entryRuleAbstractRuleCall() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:168:27: ( ruleAbstractRuleCall EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:169:1: ruleAbstractRuleCall EOF
            {
             before(grammarAccess.getAbstractRuleCallRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractRuleCall_in_entryRuleAbstractRuleCall300);
            ruleAbstractRuleCall();
            _fsp--;

             after(grammarAccess.getAbstractRuleCallRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractRuleCall307); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:176:1: ruleAbstractRuleCall : ( ( rule__AbstractRuleCall__RuleAssignment ) ) ;
    public final void ruleAbstractRuleCall() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:180:2: ( ( ( rule__AbstractRuleCall__RuleAssignment ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:181:1: ( ( rule__AbstractRuleCall__RuleAssignment ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:181:1: ( ( rule__AbstractRuleCall__RuleAssignment ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:182:1: ( rule__AbstractRuleCall__RuleAssignment )
            {
             before(grammarAccess.getAbstractRuleCallAccess().getRuleAssignment()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:183:1: ( rule__AbstractRuleCall__RuleAssignment )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:183:2: rule__AbstractRuleCall__RuleAssignment
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
                    pushFollow(FollowSets000.FOLLOW_ruleFirstAbstractRuleChild_in_rule__AbstractRule__Alternatives370);
                    ruleFirstAbstractRuleChild();
                    _fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getFirstAbstractRuleChildParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:206:6: ( ruleSecondAbstractRuleChild )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:206:6: ( ruleSecondAbstractRuleChild )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:207:1: ruleSecondAbstractRuleChild
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:219:1: rule__Start__Group__0 : ( 'abstract rules' ) rule__Start__Group__1 ;
    public final void rule__Start__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:223:1: ( ( 'abstract rules' ) rule__Start__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:224:1: ( 'abstract rules' ) rule__Start__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:224:1: ( 'abstract rules' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:225:1: 'abstract rules'
            {
             before(grammarAccess.getStartAccess().getAbstractRulesKeyword_0()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Start__Group__0422); 
             after(grammarAccess.getStartAccess().getAbstractRulesKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Start__Group__1_in_rule__Start__Group__0432);
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


    // $ANTLR start rule__Start__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:239:1: rule__Start__Group__1 : ( ( ( rule__Start__RulesAssignment_1 ) ) ( ( rule__Start__RulesAssignment_1 )* ) ) rule__Start__Group__2 ;
    public final void rule__Start__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:243:1: ( ( ( ( rule__Start__RulesAssignment_1 ) ) ( ( rule__Start__RulesAssignment_1 )* ) ) rule__Start__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:244:1: ( ( ( rule__Start__RulesAssignment_1 ) ) ( ( rule__Start__RulesAssignment_1 )* ) ) rule__Start__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:244:1: ( ( ( rule__Start__RulesAssignment_1 ) ) ( ( rule__Start__RulesAssignment_1 )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:245:1: ( ( rule__Start__RulesAssignment_1 ) ) ( ( rule__Start__RulesAssignment_1 )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:245:1: ( ( rule__Start__RulesAssignment_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:246:1: ( rule__Start__RulesAssignment_1 )
            {
             before(grammarAccess.getStartAccess().getRulesAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:247:1: ( rule__Start__RulesAssignment_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:247:2: rule__Start__RulesAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Start__RulesAssignment_1_in_rule__Start__Group__1462);
            rule__Start__RulesAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getStartAccess().getRulesAssignment_1()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:250:1: ( ( rule__Start__RulesAssignment_1 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:251:1: ( rule__Start__RulesAssignment_1 )*
            {
             before(grammarAccess.getStartAccess().getRulesAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:252:1: ( rule__Start__RulesAssignment_1 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:252:2: rule__Start__RulesAssignment_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Start__RulesAssignment_1_in_rule__Start__Group__1474);
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

            pushFollow(FollowSets000.FOLLOW_rule__Start__Group__2_in_rule__Start__Group__1486);
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


    // $ANTLR start rule__Start__Group__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:264:1: rule__Start__Group__2 : ( 'end' ) ;
    public final void rule__Start__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:268:1: ( ( 'end' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:269:1: ( 'end' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:269:1: ( 'end' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:270:1: 'end'
            {
             before(grammarAccess.getStartAccess().getEndKeyword_2()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Start__Group__2515); 
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
    // $ANTLR end rule__Start__Group__2


    // $ANTLR start rule__FirstAbstractRuleChild__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:289:1: rule__FirstAbstractRuleChild__Group__0 : ( ( rule__FirstAbstractRuleChild__NameAssignment_0 ) ) rule__FirstAbstractRuleChild__Group__1 ;
    public final void rule__FirstAbstractRuleChild__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:293:1: ( ( ( rule__FirstAbstractRuleChild__NameAssignment_0 ) ) rule__FirstAbstractRuleChild__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:294:1: ( ( rule__FirstAbstractRuleChild__NameAssignment_0 ) ) rule__FirstAbstractRuleChild__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:294:1: ( ( rule__FirstAbstractRuleChild__NameAssignment_0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:295:1: ( rule__FirstAbstractRuleChild__NameAssignment_0 )
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getNameAssignment_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:296:1: ( rule__FirstAbstractRuleChild__NameAssignment_0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:296:2: rule__FirstAbstractRuleChild__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__FirstAbstractRuleChild__NameAssignment_0_in_rule__FirstAbstractRuleChild__Group__0556);
            rule__FirstAbstractRuleChild__NameAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getFirstAbstractRuleChildAccess().getNameAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__FirstAbstractRuleChild__Group__1_in_rule__FirstAbstractRuleChild__Group__0565);
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


    // $ANTLR start rule__FirstAbstractRuleChild__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:307:1: rule__FirstAbstractRuleChild__Group__1 : ( '(' ) rule__FirstAbstractRuleChild__Group__2 ;
    public final void rule__FirstAbstractRuleChild__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:311:1: ( ( '(' ) rule__FirstAbstractRuleChild__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:312:1: ( '(' ) rule__FirstAbstractRuleChild__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:312:1: ( '(' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:313:1: '('
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getLeftParenthesisKeyword_1()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__FirstAbstractRuleChild__Group__1594); 
             after(grammarAccess.getFirstAbstractRuleChildAccess().getLeftParenthesisKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__FirstAbstractRuleChild__Group__2_in_rule__FirstAbstractRuleChild__Group__1604);
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


    // $ANTLR start rule__FirstAbstractRuleChild__Group__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:327:1: rule__FirstAbstractRuleChild__Group__2 : ( ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 ) ) ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )* ) ) rule__FirstAbstractRuleChild__Group__3 ;
    public final void rule__FirstAbstractRuleChild__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:331:1: ( ( ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 ) ) ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )* ) ) rule__FirstAbstractRuleChild__Group__3 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:332:1: ( ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 ) ) ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )* ) ) rule__FirstAbstractRuleChild__Group__3
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:332:1: ( ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 ) ) ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:333:1: ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 ) ) ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:333:1: ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:334:1: ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getElementsAssignment_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:335:1: ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:335:2: rule__FirstAbstractRuleChild__ElementsAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__FirstAbstractRuleChild__ElementsAssignment_2_in_rule__FirstAbstractRuleChild__Group__2634);
            rule__FirstAbstractRuleChild__ElementsAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getFirstAbstractRuleChildAccess().getElementsAssignment_2()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:338:1: ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:339:1: ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )*
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getElementsAssignment_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:340:1: ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:340:2: rule__FirstAbstractRuleChild__ElementsAssignment_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__FirstAbstractRuleChild__ElementsAssignment_2_in_rule__FirstAbstractRuleChild__Group__2646);
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

            pushFollow(FollowSets000.FOLLOW_rule__FirstAbstractRuleChild__Group__3_in_rule__FirstAbstractRuleChild__Group__2658);
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


    // $ANTLR start rule__FirstAbstractRuleChild__Group__3
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:352:1: rule__FirstAbstractRuleChild__Group__3 : ( ')' ) rule__FirstAbstractRuleChild__Group__4 ;
    public final void rule__FirstAbstractRuleChild__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:356:1: ( ( ')' ) rule__FirstAbstractRuleChild__Group__4 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:357:1: ( ')' ) rule__FirstAbstractRuleChild__Group__4
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:357:1: ( ')' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:358:1: ')'
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getRightParenthesisKeyword_3()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__FirstAbstractRuleChild__Group__3687); 
             after(grammarAccess.getFirstAbstractRuleChildAccess().getRightParenthesisKeyword_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__FirstAbstractRuleChild__Group__4_in_rule__FirstAbstractRuleChild__Group__3697);
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


    // $ANTLR start rule__FirstAbstractRuleChild__Group__4
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:372:1: rule__FirstAbstractRuleChild__Group__4 : ( ';' ) ;
    public final void rule__FirstAbstractRuleChild__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:376:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:377:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:377:1: ( ';' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:378:1: ';'
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getSemicolonKeyword_4()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__FirstAbstractRuleChild__Group__4726); 
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
    // $ANTLR end rule__FirstAbstractRuleChild__Group__4


    // $ANTLR start rule__SecondAbstractRuleChild__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:401:1: rule__SecondAbstractRuleChild__Group__0 : ( ( rule__SecondAbstractRuleChild__NameAssignment_0 ) ) rule__SecondAbstractRuleChild__Group__1 ;
    public final void rule__SecondAbstractRuleChild__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:405:1: ( ( ( rule__SecondAbstractRuleChild__NameAssignment_0 ) ) rule__SecondAbstractRuleChild__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:406:1: ( ( rule__SecondAbstractRuleChild__NameAssignment_0 ) ) rule__SecondAbstractRuleChild__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:406:1: ( ( rule__SecondAbstractRuleChild__NameAssignment_0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:407:1: ( rule__SecondAbstractRuleChild__NameAssignment_0 )
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getNameAssignment_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:408:1: ( rule__SecondAbstractRuleChild__NameAssignment_0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:408:2: rule__SecondAbstractRuleChild__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__SecondAbstractRuleChild__NameAssignment_0_in_rule__SecondAbstractRuleChild__Group__0771);
            rule__SecondAbstractRuleChild__NameAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getSecondAbstractRuleChildAccess().getNameAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__SecondAbstractRuleChild__Group__1_in_rule__SecondAbstractRuleChild__Group__0780);
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


    // $ANTLR start rule__SecondAbstractRuleChild__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:419:1: rule__SecondAbstractRuleChild__Group__1 : ( 'rule' ) rule__SecondAbstractRuleChild__Group__2 ;
    public final void rule__SecondAbstractRuleChild__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:423:1: ( ( 'rule' ) rule__SecondAbstractRuleChild__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:424:1: ( 'rule' ) rule__SecondAbstractRuleChild__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:424:1: ( 'rule' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:425:1: 'rule'
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getRuleKeyword_1()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__SecondAbstractRuleChild__Group__1809); 
             after(grammarAccess.getSecondAbstractRuleChildAccess().getRuleKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__SecondAbstractRuleChild__Group__2_in_rule__SecondAbstractRuleChild__Group__1819);
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


    // $ANTLR start rule__SecondAbstractRuleChild__Group__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:439:1: rule__SecondAbstractRuleChild__Group__2 : ( ':' ) rule__SecondAbstractRuleChild__Group__3 ;
    public final void rule__SecondAbstractRuleChild__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:443:1: ( ( ':' ) rule__SecondAbstractRuleChild__Group__3 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:444:1: ( ':' ) rule__SecondAbstractRuleChild__Group__3
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:444:1: ( ':' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:445:1: ':'
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getColonKeyword_2()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__SecondAbstractRuleChild__Group__2848); 
             after(grammarAccess.getSecondAbstractRuleChildAccess().getColonKeyword_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__SecondAbstractRuleChild__Group__3_in_rule__SecondAbstractRuleChild__Group__2858);
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


    // $ANTLR start rule__SecondAbstractRuleChild__Group__3
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:459:1: rule__SecondAbstractRuleChild__Group__3 : ( ( rule__SecondAbstractRuleChild__RuleAssignment_3 ) ) rule__SecondAbstractRuleChild__Group__4 ;
    public final void rule__SecondAbstractRuleChild__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:463:1: ( ( ( rule__SecondAbstractRuleChild__RuleAssignment_3 ) ) rule__SecondAbstractRuleChild__Group__4 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:464:1: ( ( rule__SecondAbstractRuleChild__RuleAssignment_3 ) ) rule__SecondAbstractRuleChild__Group__4
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:464:1: ( ( rule__SecondAbstractRuleChild__RuleAssignment_3 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:465:1: ( rule__SecondAbstractRuleChild__RuleAssignment_3 )
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getRuleAssignment_3()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:466:1: ( rule__SecondAbstractRuleChild__RuleAssignment_3 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:466:2: rule__SecondAbstractRuleChild__RuleAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__SecondAbstractRuleChild__RuleAssignment_3_in_rule__SecondAbstractRuleChild__Group__3886);
            rule__SecondAbstractRuleChild__RuleAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getSecondAbstractRuleChildAccess().getRuleAssignment_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__SecondAbstractRuleChild__Group__4_in_rule__SecondAbstractRuleChild__Group__3895);
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


    // $ANTLR start rule__SecondAbstractRuleChild__Group__4
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:477:1: rule__SecondAbstractRuleChild__Group__4 : ( ';' ) ;
    public final void rule__SecondAbstractRuleChild__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:481:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:482:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:482:1: ( ';' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:483:1: ';'
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getSemicolonKeyword_4()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__SecondAbstractRuleChild__Group__4924); 
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
    // $ANTLR end rule__SecondAbstractRuleChild__Group__4


    // $ANTLR start rule__Start__RulesAssignment_1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:506:1: rule__Start__RulesAssignment_1 : ( ruleAbstractRule ) ;
    public final void rule__Start__RulesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:510:1: ( ( ruleAbstractRule ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:511:1: ( ruleAbstractRule )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:511:1: ( ruleAbstractRule )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:512:1: ruleAbstractRule
            {
             before(grammarAccess.getStartAccess().getRulesAbstractRuleParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractRule_in_rule__Start__RulesAssignment_1969);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:521:1: rule__FirstAbstractRuleChild__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__FirstAbstractRuleChild__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:525:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:526:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:526:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:527:1: RULE_ID
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__FirstAbstractRuleChild__NameAssignment_01000); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:536:1: rule__FirstAbstractRuleChild__ElementsAssignment_2 : ( ruleAbstractRule ) ;
    public final void rule__FirstAbstractRuleChild__ElementsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:540:1: ( ( ruleAbstractRule ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:541:1: ( ruleAbstractRule )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:541:1: ( ruleAbstractRule )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:542:1: ruleAbstractRule
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getElementsAbstractRuleParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractRule_in_rule__FirstAbstractRuleChild__ElementsAssignment_21031);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:551:1: rule__SecondAbstractRuleChild__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__SecondAbstractRuleChild__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:555:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:556:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:556:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:557:1: RULE_ID
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__SecondAbstractRuleChild__NameAssignment_01062); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:566:1: rule__SecondAbstractRuleChild__RuleAssignment_3 : ( ruleAbstractRuleCall ) ;
    public final void rule__SecondAbstractRuleChild__RuleAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:570:1: ( ( ruleAbstractRuleCall ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:571:1: ( ruleAbstractRuleCall )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:571:1: ( ruleAbstractRuleCall )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:572:1: ruleAbstractRuleCall
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getRuleAbstractRuleCallParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractRuleCall_in_rule__SecondAbstractRuleChild__RuleAssignment_31093);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:581:1: rule__AbstractRuleCall__RuleAssignment : ( ( RULE_ID ) ) ;
    public final void rule__AbstractRuleCall__RuleAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:585:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:586:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:586:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:587:1: ( RULE_ID )
            {
             before(grammarAccess.getAbstractRuleCallAccess().getRuleAbstractRuleCrossReference_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:588:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:589:1: RULE_ID
            {
             before(grammarAccess.getAbstractRuleCallAccess().getRuleAbstractRuleIDTerminalRuleCall_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__AbstractRuleCall__RuleAssignment1128); 
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
        public static final BitSet FOLLOW_ruleStart_in_entryRuleStart60 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStart67 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Start__Group__0_in_ruleStart94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule120 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRule127 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractRule__Alternatives_in_ruleAbstractRule154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstAbstractRuleChild_in_entryRuleFirstAbstractRuleChild180 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFirstAbstractRuleChild187 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FirstAbstractRuleChild__Group__0_in_ruleFirstAbstractRuleChild214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSecondAbstractRuleChild_in_entryRuleSecondAbstractRuleChild240 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSecondAbstractRuleChild247 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SecondAbstractRuleChild__Group__0_in_ruleSecondAbstractRuleChild274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractRuleCall_in_entryRuleAbstractRuleCall300 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRuleCall307 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractRuleCall__RuleAssignment_in_ruleAbstractRuleCall334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstAbstractRuleChild_in_rule__AbstractRule__Alternatives370 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSecondAbstractRuleChild_in_rule__AbstractRule__Alternatives387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Start__Group__0422 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Start__Group__1_in_rule__Start__Group__0432 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Start__RulesAssignment_1_in_rule__Start__Group__1462 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_rule__Start__RulesAssignment_1_in_rule__Start__Group__1474 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_rule__Start__Group__2_in_rule__Start__Group__1486 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Start__Group__2515 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FirstAbstractRuleChild__NameAssignment_0_in_rule__FirstAbstractRuleChild__Group__0556 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__FirstAbstractRuleChild__Group__1_in_rule__FirstAbstractRuleChild__Group__0565 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__FirstAbstractRuleChild__Group__1594 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__FirstAbstractRuleChild__Group__2_in_rule__FirstAbstractRuleChild__Group__1604 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FirstAbstractRuleChild__ElementsAssignment_2_in_rule__FirstAbstractRuleChild__Group__2634 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_rule__FirstAbstractRuleChild__ElementsAssignment_2_in_rule__FirstAbstractRuleChild__Group__2646 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_rule__FirstAbstractRuleChild__Group__3_in_rule__FirstAbstractRuleChild__Group__2658 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__FirstAbstractRuleChild__Group__3687 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_rule__FirstAbstractRuleChild__Group__4_in_rule__FirstAbstractRuleChild__Group__3697 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__FirstAbstractRuleChild__Group__4726 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SecondAbstractRuleChild__NameAssignment_0_in_rule__SecondAbstractRuleChild__Group__0771 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_rule__SecondAbstractRuleChild__Group__1_in_rule__SecondAbstractRuleChild__Group__0780 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__SecondAbstractRuleChild__Group__1809 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_rule__SecondAbstractRuleChild__Group__2_in_rule__SecondAbstractRuleChild__Group__1819 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__SecondAbstractRuleChild__Group__2848 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__SecondAbstractRuleChild__Group__3_in_rule__SecondAbstractRuleChild__Group__2858 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SecondAbstractRuleChild__RuleAssignment_3_in_rule__SecondAbstractRuleChild__Group__3886 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_rule__SecondAbstractRuleChild__Group__4_in_rule__SecondAbstractRuleChild__Group__3895 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__SecondAbstractRuleChild__Group__4924 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractRule_in_rule__Start__RulesAssignment_1969 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__FirstAbstractRuleChild__NameAssignment_01000 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractRule_in_rule__FirstAbstractRuleChild__ElementsAssignment_21031 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__SecondAbstractRuleChild__NameAssignment_01062 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractRuleCall_in_rule__SecondAbstractRuleChild__RuleAssignment_31093 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__AbstractRuleCall__RuleAssignment1128 = new BitSet(new long[]{0x0000000000000002L});
    }


}
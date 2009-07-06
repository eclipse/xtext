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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:63:1: ruleStart : ( ( rule__Start__Group__0 ) ) ;
    public final void ruleStart() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:67:2: ( ( ( rule__Start__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:68:1: ( ( rule__Start__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:68:1: ( ( rule__Start__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:69:1: ( rule__Start__Group__0 )
            {
             before(grammarAccess.getStartAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:70:1: ( rule__Start__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:70:2: rule__Start__Group__0
            {
            pushFollow(FOLLOW_rule__Start__Group__0_in_ruleStart94);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:82:1: entryRuleAbstractRule : ruleAbstractRule EOF ;
    public final void entryRuleAbstractRule() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:82:23: ( ruleAbstractRule EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:83:1: ruleAbstractRule EOF
            {
             before(grammarAccess.getAbstractRuleRule()); 
            pushFollow(FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule120);
            ruleAbstractRule();
            _fsp--;

             after(grammarAccess.getAbstractRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractRule127); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:90:1: ruleAbstractRule : ( ( rule__AbstractRule__Alternatives ) ) ;
    public final void ruleAbstractRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:94:2: ( ( ( rule__AbstractRule__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:95:1: ( ( rule__AbstractRule__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:95:1: ( ( rule__AbstractRule__Alternatives ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:96:1: ( rule__AbstractRule__Alternatives )
            {
             before(grammarAccess.getAbstractRuleAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:97:1: ( rule__AbstractRule__Alternatives )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:97:2: rule__AbstractRule__Alternatives
            {
            pushFollow(FOLLOW_rule__AbstractRule__Alternatives_in_ruleAbstractRule154);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:109:1: entryRuleFirstAbstractRuleChild : ruleFirstAbstractRuleChild EOF ;
    public final void entryRuleFirstAbstractRuleChild() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:109:33: ( ruleFirstAbstractRuleChild EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:110:1: ruleFirstAbstractRuleChild EOF
            {
             before(grammarAccess.getFirstAbstractRuleChildRule()); 
            pushFollow(FOLLOW_ruleFirstAbstractRuleChild_in_entryRuleFirstAbstractRuleChild180);
            ruleFirstAbstractRuleChild();
            _fsp--;

             after(grammarAccess.getFirstAbstractRuleChildRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFirstAbstractRuleChild187); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:117:1: ruleFirstAbstractRuleChild : ( ( rule__FirstAbstractRuleChild__Group__0 ) ) ;
    public final void ruleFirstAbstractRuleChild() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:121:2: ( ( ( rule__FirstAbstractRuleChild__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:122:1: ( ( rule__FirstAbstractRuleChild__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:122:1: ( ( rule__FirstAbstractRuleChild__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:123:1: ( rule__FirstAbstractRuleChild__Group__0 )
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:124:1: ( rule__FirstAbstractRuleChild__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:124:2: rule__FirstAbstractRuleChild__Group__0
            {
            pushFollow(FOLLOW_rule__FirstAbstractRuleChild__Group__0_in_ruleFirstAbstractRuleChild214);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:136:1: entryRuleSecondAbstractRuleChild : ruleSecondAbstractRuleChild EOF ;
    public final void entryRuleSecondAbstractRuleChild() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:136:34: ( ruleSecondAbstractRuleChild EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:137:1: ruleSecondAbstractRuleChild EOF
            {
             before(grammarAccess.getSecondAbstractRuleChildRule()); 
            pushFollow(FOLLOW_ruleSecondAbstractRuleChild_in_entryRuleSecondAbstractRuleChild240);
            ruleSecondAbstractRuleChild();
            _fsp--;

             after(grammarAccess.getSecondAbstractRuleChildRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSecondAbstractRuleChild247); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:144:1: ruleSecondAbstractRuleChild : ( ( rule__SecondAbstractRuleChild__Group__0 ) ) ;
    public final void ruleSecondAbstractRuleChild() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:148:2: ( ( ( rule__SecondAbstractRuleChild__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:149:1: ( ( rule__SecondAbstractRuleChild__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:149:1: ( ( rule__SecondAbstractRuleChild__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:150:1: ( rule__SecondAbstractRuleChild__Group__0 )
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:151:1: ( rule__SecondAbstractRuleChild__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:151:2: rule__SecondAbstractRuleChild__Group__0
            {
            pushFollow(FOLLOW_rule__SecondAbstractRuleChild__Group__0_in_ruleSecondAbstractRuleChild274);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:163:1: entryRuleAbstractRuleCall : ruleAbstractRuleCall EOF ;
    public final void entryRuleAbstractRuleCall() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:163:27: ( ruleAbstractRuleCall EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:164:1: ruleAbstractRuleCall EOF
            {
             before(grammarAccess.getAbstractRuleCallRule()); 
            pushFollow(FOLLOW_ruleAbstractRuleCall_in_entryRuleAbstractRuleCall300);
            ruleAbstractRuleCall();
            _fsp--;

             after(grammarAccess.getAbstractRuleCallRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractRuleCall307); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:171:1: ruleAbstractRuleCall : ( ( rule__AbstractRuleCall__RuleAssignment ) ) ;
    public final void ruleAbstractRuleCall() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:175:2: ( ( ( rule__AbstractRuleCall__RuleAssignment ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:176:1: ( ( rule__AbstractRuleCall__RuleAssignment ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:176:1: ( ( rule__AbstractRuleCall__RuleAssignment ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:177:1: ( rule__AbstractRuleCall__RuleAssignment )
            {
             before(grammarAccess.getAbstractRuleCallAccess().getRuleAssignment()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:178:1: ( rule__AbstractRuleCall__RuleAssignment )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:178:2: rule__AbstractRuleCall__RuleAssignment
            {
            pushFollow(FOLLOW_rule__AbstractRuleCall__RuleAssignment_in_ruleAbstractRuleCall334);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:190:1: rule__AbstractRule__Alternatives : ( ( ruleFirstAbstractRuleChild ) | ( ruleSecondAbstractRuleChild ) );
    public final void rule__AbstractRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:194:1: ( ( ruleFirstAbstractRuleChild ) | ( ruleSecondAbstractRuleChild ) )
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
                        new NoViableAltException("190:1: rule__AbstractRule__Alternatives : ( ( ruleFirstAbstractRuleChild ) | ( ruleSecondAbstractRuleChild ) );", 1, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("190:1: rule__AbstractRule__Alternatives : ( ( ruleFirstAbstractRuleChild ) | ( ruleSecondAbstractRuleChild ) );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:195:1: ( ruleFirstAbstractRuleChild )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:195:1: ( ruleFirstAbstractRuleChild )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:196:1: ruleFirstAbstractRuleChild
                    {
                     before(grammarAccess.getAbstractRuleAccess().getFirstAbstractRuleChildParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleFirstAbstractRuleChild_in_rule__AbstractRule__Alternatives370);
                    ruleFirstAbstractRuleChild();
                    _fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getFirstAbstractRuleChildParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:201:6: ( ruleSecondAbstractRuleChild )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:201:6: ( ruleSecondAbstractRuleChild )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:202:1: ruleSecondAbstractRuleChild
                    {
                     before(grammarAccess.getAbstractRuleAccess().getSecondAbstractRuleChildParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleSecondAbstractRuleChild_in_rule__AbstractRule__Alternatives387);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:214:1: rule__Start__Group__0 : ( 'abstract rules' ) rule__Start__Group__1 ;
    public final void rule__Start__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:218:1: ( ( 'abstract rules' ) rule__Start__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:219:1: ( 'abstract rules' ) rule__Start__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:219:1: ( 'abstract rules' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:220:1: 'abstract rules'
            {
             before(grammarAccess.getStartAccess().getAbstractRulesKeyword_0()); 
            match(input,11,FOLLOW_11_in_rule__Start__Group__0422); 
             after(grammarAccess.getStartAccess().getAbstractRulesKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__Start__Group__1_in_rule__Start__Group__0432);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:234:1: rule__Start__Group__1 : ( ( ( rule__Start__RulesAssignment_1 ) ) ( ( rule__Start__RulesAssignment_1 )* ) ) rule__Start__Group__2 ;
    public final void rule__Start__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:238:1: ( ( ( ( rule__Start__RulesAssignment_1 ) ) ( ( rule__Start__RulesAssignment_1 )* ) ) rule__Start__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:239:1: ( ( ( rule__Start__RulesAssignment_1 ) ) ( ( rule__Start__RulesAssignment_1 )* ) ) rule__Start__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:239:1: ( ( ( rule__Start__RulesAssignment_1 ) ) ( ( rule__Start__RulesAssignment_1 )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:240:1: ( ( rule__Start__RulesAssignment_1 ) ) ( ( rule__Start__RulesAssignment_1 )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:240:1: ( ( rule__Start__RulesAssignment_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:241:1: ( rule__Start__RulesAssignment_1 )
            {
             before(grammarAccess.getStartAccess().getRulesAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:242:1: ( rule__Start__RulesAssignment_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:242:2: rule__Start__RulesAssignment_1
            {
            pushFollow(FOLLOW_rule__Start__RulesAssignment_1_in_rule__Start__Group__1462);
            rule__Start__RulesAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getStartAccess().getRulesAssignment_1()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:245:1: ( ( rule__Start__RulesAssignment_1 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:246:1: ( rule__Start__RulesAssignment_1 )*
            {
             before(grammarAccess.getStartAccess().getRulesAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:247:1: ( rule__Start__RulesAssignment_1 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:247:2: rule__Start__RulesAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__Start__RulesAssignment_1_in_rule__Start__Group__1474);
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

            pushFollow(FOLLOW_rule__Start__Group__2_in_rule__Start__Group__1486);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:259:1: rule__Start__Group__2 : ( 'end' ) ;
    public final void rule__Start__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:263:1: ( ( 'end' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:264:1: ( 'end' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:264:1: ( 'end' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:265:1: 'end'
            {
             before(grammarAccess.getStartAccess().getEndKeyword_2()); 
            match(input,12,FOLLOW_12_in_rule__Start__Group__2515); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:284:1: rule__FirstAbstractRuleChild__Group__0 : ( ( rule__FirstAbstractRuleChild__NameAssignment_0 ) ) rule__FirstAbstractRuleChild__Group__1 ;
    public final void rule__FirstAbstractRuleChild__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:288:1: ( ( ( rule__FirstAbstractRuleChild__NameAssignment_0 ) ) rule__FirstAbstractRuleChild__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:289:1: ( ( rule__FirstAbstractRuleChild__NameAssignment_0 ) ) rule__FirstAbstractRuleChild__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:289:1: ( ( rule__FirstAbstractRuleChild__NameAssignment_0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:290:1: ( rule__FirstAbstractRuleChild__NameAssignment_0 )
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getNameAssignment_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:291:1: ( rule__FirstAbstractRuleChild__NameAssignment_0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:291:2: rule__FirstAbstractRuleChild__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__FirstAbstractRuleChild__NameAssignment_0_in_rule__FirstAbstractRuleChild__Group__0556);
            rule__FirstAbstractRuleChild__NameAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getFirstAbstractRuleChildAccess().getNameAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__FirstAbstractRuleChild__Group__1_in_rule__FirstAbstractRuleChild__Group__0565);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:302:1: rule__FirstAbstractRuleChild__Group__1 : ( '(' ) rule__FirstAbstractRuleChild__Group__2 ;
    public final void rule__FirstAbstractRuleChild__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:306:1: ( ( '(' ) rule__FirstAbstractRuleChild__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:307:1: ( '(' ) rule__FirstAbstractRuleChild__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:307:1: ( '(' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:308:1: '('
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getLeftParenthesisKeyword_1()); 
            match(input,13,FOLLOW_13_in_rule__FirstAbstractRuleChild__Group__1594); 
             after(grammarAccess.getFirstAbstractRuleChildAccess().getLeftParenthesisKeyword_1()); 

            }

            pushFollow(FOLLOW_rule__FirstAbstractRuleChild__Group__2_in_rule__FirstAbstractRuleChild__Group__1604);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:322:1: rule__FirstAbstractRuleChild__Group__2 : ( ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 ) ) ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )* ) ) rule__FirstAbstractRuleChild__Group__3 ;
    public final void rule__FirstAbstractRuleChild__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:326:1: ( ( ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 ) ) ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )* ) ) rule__FirstAbstractRuleChild__Group__3 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:327:1: ( ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 ) ) ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )* ) ) rule__FirstAbstractRuleChild__Group__3
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:327:1: ( ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 ) ) ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:328:1: ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 ) ) ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:328:1: ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:329:1: ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getElementsAssignment_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:330:1: ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:330:2: rule__FirstAbstractRuleChild__ElementsAssignment_2
            {
            pushFollow(FOLLOW_rule__FirstAbstractRuleChild__ElementsAssignment_2_in_rule__FirstAbstractRuleChild__Group__2634);
            rule__FirstAbstractRuleChild__ElementsAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getFirstAbstractRuleChildAccess().getElementsAssignment_2()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:333:1: ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:334:1: ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )*
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getElementsAssignment_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:335:1: ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:335:2: rule__FirstAbstractRuleChild__ElementsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__FirstAbstractRuleChild__ElementsAssignment_2_in_rule__FirstAbstractRuleChild__Group__2646);
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

            pushFollow(FOLLOW_rule__FirstAbstractRuleChild__Group__3_in_rule__FirstAbstractRuleChild__Group__2658);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:347:1: rule__FirstAbstractRuleChild__Group__3 : ( ')' ) rule__FirstAbstractRuleChild__Group__4 ;
    public final void rule__FirstAbstractRuleChild__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:351:1: ( ( ')' ) rule__FirstAbstractRuleChild__Group__4 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:352:1: ( ')' ) rule__FirstAbstractRuleChild__Group__4
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:352:1: ( ')' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:353:1: ')'
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getRightParenthesisKeyword_3()); 
            match(input,14,FOLLOW_14_in_rule__FirstAbstractRuleChild__Group__3687); 
             after(grammarAccess.getFirstAbstractRuleChildAccess().getRightParenthesisKeyword_3()); 

            }

            pushFollow(FOLLOW_rule__FirstAbstractRuleChild__Group__4_in_rule__FirstAbstractRuleChild__Group__3697);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:367:1: rule__FirstAbstractRuleChild__Group__4 : ( ';' ) ;
    public final void rule__FirstAbstractRuleChild__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:371:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:372:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:372:1: ( ';' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:373:1: ';'
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getSemicolonKeyword_4()); 
            match(input,15,FOLLOW_15_in_rule__FirstAbstractRuleChild__Group__4726); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:396:1: rule__SecondAbstractRuleChild__Group__0 : ( ( rule__SecondAbstractRuleChild__NameAssignment_0 ) ) rule__SecondAbstractRuleChild__Group__1 ;
    public final void rule__SecondAbstractRuleChild__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:400:1: ( ( ( rule__SecondAbstractRuleChild__NameAssignment_0 ) ) rule__SecondAbstractRuleChild__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:401:1: ( ( rule__SecondAbstractRuleChild__NameAssignment_0 ) ) rule__SecondAbstractRuleChild__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:401:1: ( ( rule__SecondAbstractRuleChild__NameAssignment_0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:402:1: ( rule__SecondAbstractRuleChild__NameAssignment_0 )
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getNameAssignment_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:403:1: ( rule__SecondAbstractRuleChild__NameAssignment_0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:403:2: rule__SecondAbstractRuleChild__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__SecondAbstractRuleChild__NameAssignment_0_in_rule__SecondAbstractRuleChild__Group__0771);
            rule__SecondAbstractRuleChild__NameAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getSecondAbstractRuleChildAccess().getNameAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__SecondAbstractRuleChild__Group__1_in_rule__SecondAbstractRuleChild__Group__0780);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:414:1: rule__SecondAbstractRuleChild__Group__1 : ( 'rule' ) rule__SecondAbstractRuleChild__Group__2 ;
    public final void rule__SecondAbstractRuleChild__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:418:1: ( ( 'rule' ) rule__SecondAbstractRuleChild__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:419:1: ( 'rule' ) rule__SecondAbstractRuleChild__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:419:1: ( 'rule' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:420:1: 'rule'
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getRuleKeyword_1()); 
            match(input,16,FOLLOW_16_in_rule__SecondAbstractRuleChild__Group__1809); 
             after(grammarAccess.getSecondAbstractRuleChildAccess().getRuleKeyword_1()); 

            }

            pushFollow(FOLLOW_rule__SecondAbstractRuleChild__Group__2_in_rule__SecondAbstractRuleChild__Group__1819);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:434:1: rule__SecondAbstractRuleChild__Group__2 : ( ':' ) rule__SecondAbstractRuleChild__Group__3 ;
    public final void rule__SecondAbstractRuleChild__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:438:1: ( ( ':' ) rule__SecondAbstractRuleChild__Group__3 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:439:1: ( ':' ) rule__SecondAbstractRuleChild__Group__3
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:439:1: ( ':' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:440:1: ':'
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getColonKeyword_2()); 
            match(input,17,FOLLOW_17_in_rule__SecondAbstractRuleChild__Group__2848); 
             after(grammarAccess.getSecondAbstractRuleChildAccess().getColonKeyword_2()); 

            }

            pushFollow(FOLLOW_rule__SecondAbstractRuleChild__Group__3_in_rule__SecondAbstractRuleChild__Group__2858);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:454:1: rule__SecondAbstractRuleChild__Group__3 : ( ( rule__SecondAbstractRuleChild__RuleAssignment_3 ) ) rule__SecondAbstractRuleChild__Group__4 ;
    public final void rule__SecondAbstractRuleChild__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:458:1: ( ( ( rule__SecondAbstractRuleChild__RuleAssignment_3 ) ) rule__SecondAbstractRuleChild__Group__4 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:459:1: ( ( rule__SecondAbstractRuleChild__RuleAssignment_3 ) ) rule__SecondAbstractRuleChild__Group__4
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:459:1: ( ( rule__SecondAbstractRuleChild__RuleAssignment_3 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:460:1: ( rule__SecondAbstractRuleChild__RuleAssignment_3 )
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getRuleAssignment_3()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:461:1: ( rule__SecondAbstractRuleChild__RuleAssignment_3 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:461:2: rule__SecondAbstractRuleChild__RuleAssignment_3
            {
            pushFollow(FOLLOW_rule__SecondAbstractRuleChild__RuleAssignment_3_in_rule__SecondAbstractRuleChild__Group__3886);
            rule__SecondAbstractRuleChild__RuleAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getSecondAbstractRuleChildAccess().getRuleAssignment_3()); 

            }

            pushFollow(FOLLOW_rule__SecondAbstractRuleChild__Group__4_in_rule__SecondAbstractRuleChild__Group__3895);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:472:1: rule__SecondAbstractRuleChild__Group__4 : ( ';' ) ;
    public final void rule__SecondAbstractRuleChild__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:476:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:477:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:477:1: ( ';' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:478:1: ';'
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getSemicolonKeyword_4()); 
            match(input,15,FOLLOW_15_in_rule__SecondAbstractRuleChild__Group__4924); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:501:1: rule__Start__RulesAssignment_1 : ( ruleAbstractRule ) ;
    public final void rule__Start__RulesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:505:1: ( ( ruleAbstractRule ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:506:1: ( ruleAbstractRule )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:506:1: ( ruleAbstractRule )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:507:1: ruleAbstractRule
            {
             before(grammarAccess.getStartAccess().getRulesAbstractRuleParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleAbstractRule_in_rule__Start__RulesAssignment_1969);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:516:1: rule__FirstAbstractRuleChild__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__FirstAbstractRuleChild__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:520:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:521:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:521:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:522:1: RULE_ID
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FirstAbstractRuleChild__NameAssignment_01000); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:531:1: rule__FirstAbstractRuleChild__ElementsAssignment_2 : ( ruleAbstractRule ) ;
    public final void rule__FirstAbstractRuleChild__ElementsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:535:1: ( ( ruleAbstractRule ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:536:1: ( ruleAbstractRule )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:536:1: ( ruleAbstractRule )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:537:1: ruleAbstractRule
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getElementsAbstractRuleParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleAbstractRule_in_rule__FirstAbstractRuleChild__ElementsAssignment_21031);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:546:1: rule__SecondAbstractRuleChild__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__SecondAbstractRuleChild__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:550:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:551:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:551:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:552:1: RULE_ID
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SecondAbstractRuleChild__NameAssignment_01062); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:561:1: rule__SecondAbstractRuleChild__RuleAssignment_3 : ( ruleAbstractRuleCall ) ;
    public final void rule__SecondAbstractRuleChild__RuleAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:565:1: ( ( ruleAbstractRuleCall ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:566:1: ( ruleAbstractRuleCall )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:566:1: ( ruleAbstractRuleCall )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:567:1: ruleAbstractRuleCall
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getRuleAbstractRuleCallParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleAbstractRuleCall_in_rule__SecondAbstractRuleChild__RuleAssignment_31093);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:576:1: rule__AbstractRuleCall__RuleAssignment : ( ( RULE_ID ) ) ;
    public final void rule__AbstractRuleCall__RuleAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:580:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:581:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:581:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:582:1: ( RULE_ID )
            {
             before(grammarAccess.getAbstractRuleCallAccess().getRuleAbstractRuleCrossReference_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:583:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:584:1: RULE_ID
            {
             before(grammarAccess.getAbstractRuleCallAccess().getRuleAbstractRuleIDTerminalRuleCall_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__AbstractRuleCall__RuleAssignment1128); 
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
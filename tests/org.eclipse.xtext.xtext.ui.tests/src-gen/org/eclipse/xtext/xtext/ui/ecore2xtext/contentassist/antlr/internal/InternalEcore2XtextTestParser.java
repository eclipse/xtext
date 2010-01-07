package org.eclipse.xtext.xtext.ui.ecore2xtext.contentassist.antlr.internal; 

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
import org.eclipse.xtext.xtext.ui.ecore2xtext.services.Ecore2XtextTestGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalEcore2XtextTestParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'INT'", "'Root'", "'{'", "'}'", "'name'", "'classes'", "','", "'Concrete0'", "'Concrete1'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalEcore2XtextTestParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g"; }


     
     	private Ecore2XtextTestGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(Ecore2XtextTestGrammarAccess grammarAccess) {
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




    // $ANTLR start entryRuleRoot
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:60:1: entryRuleRoot : ruleRoot EOF ;
    public final void entryRuleRoot() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:61:1: ( ruleRoot EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:62:1: ruleRoot EOF
            {
             before(grammarAccess.getRootRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRoot_in_entryRuleRoot61);
            ruleRoot();
            _fsp--;

             after(grammarAccess.getRootRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRoot68); 

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
    // $ANTLR end entryRuleRoot


    // $ANTLR start ruleRoot
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:69:1: ruleRoot : ( ( rule__Root__Group__0 ) ) ;
    public final void ruleRoot() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:73:2: ( ( ( rule__Root__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:74:1: ( ( rule__Root__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:74:1: ( ( rule__Root__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:75:1: ( rule__Root__Group__0 )
            {
             before(grammarAccess.getRootAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:76:1: ( rule__Root__Group__0 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:76:2: rule__Root__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Root__Group__0_in_ruleRoot95);
            rule__Root__Group__0();
            _fsp--;


            }

             after(grammarAccess.getRootAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleRoot


    // $ANTLR start entryRuleAbstract
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:88:1: entryRuleAbstract : ruleAbstract EOF ;
    public final void entryRuleAbstract() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:89:1: ( ruleAbstract EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:90:1: ruleAbstract EOF
            {
             before(grammarAccess.getAbstractRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstract_in_entryRuleAbstract122);
            ruleAbstract();
            _fsp--;

             after(grammarAccess.getAbstractRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstract129); 

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
    // $ANTLR end entryRuleAbstract


    // $ANTLR start ruleAbstract
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:97:1: ruleAbstract : ( ( rule__Abstract__Alternatives ) ) ;
    public final void ruleAbstract() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:101:2: ( ( ( rule__Abstract__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:102:1: ( ( rule__Abstract__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:102:1: ( ( rule__Abstract__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:103:1: ( rule__Abstract__Alternatives )
            {
             before(grammarAccess.getAbstractAccess().getAlternatives()); 
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:104:1: ( rule__Abstract__Alternatives )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:104:2: rule__Abstract__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Abstract__Alternatives_in_ruleAbstract156);
            rule__Abstract__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getAbstractAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleAbstract


    // $ANTLR start entryRuleConcrete0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:116:1: entryRuleConcrete0 : ruleConcrete0 EOF ;
    public final void entryRuleConcrete0() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:117:1: ( ruleConcrete0 EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:118:1: ruleConcrete0 EOF
            {
             before(grammarAccess.getConcrete0Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleConcrete0_in_entryRuleConcrete0183);
            ruleConcrete0();
            _fsp--;

             after(grammarAccess.getConcrete0Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConcrete0190); 

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
    // $ANTLR end entryRuleConcrete0


    // $ANTLR start ruleConcrete0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:125:1: ruleConcrete0 : ( ( rule__Concrete0__Group__0 ) ) ;
    public final void ruleConcrete0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:129:2: ( ( ( rule__Concrete0__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:130:1: ( ( rule__Concrete0__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:130:1: ( ( rule__Concrete0__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:131:1: ( rule__Concrete0__Group__0 )
            {
             before(grammarAccess.getConcrete0Access().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:132:1: ( rule__Concrete0__Group__0 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:132:2: rule__Concrete0__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Concrete0__Group__0_in_ruleConcrete0217);
            rule__Concrete0__Group__0();
            _fsp--;


            }

             after(grammarAccess.getConcrete0Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleConcrete0


    // $ANTLR start entryRuleConcrete1
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:144:1: entryRuleConcrete1 : ruleConcrete1 EOF ;
    public final void entryRuleConcrete1() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:145:1: ( ruleConcrete1 EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:146:1: ruleConcrete1 EOF
            {
             before(grammarAccess.getConcrete1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleConcrete1_in_entryRuleConcrete1244);
            ruleConcrete1();
            _fsp--;

             after(grammarAccess.getConcrete1Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConcrete1251); 

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
    // $ANTLR end entryRuleConcrete1


    // $ANTLR start ruleConcrete1
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:153:1: ruleConcrete1 : ( ( rule__Concrete1__Group__0 ) ) ;
    public final void ruleConcrete1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:157:2: ( ( ( rule__Concrete1__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:158:1: ( ( rule__Concrete1__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:158:1: ( ( rule__Concrete1__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:159:1: ( rule__Concrete1__Group__0 )
            {
             before(grammarAccess.getConcrete1Access().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:160:1: ( rule__Concrete1__Group__0 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:160:2: rule__Concrete1__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Concrete1__Group__0_in_ruleConcrete1278);
            rule__Concrete1__Group__0();
            _fsp--;


            }

             after(grammarAccess.getConcrete1Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleConcrete1


    // $ANTLR start entryRuleINT0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:172:1: entryRuleINT0 : ruleINT0 EOF ;
    public final void entryRuleINT0() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:173:1: ( ruleINT0 EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:174:1: ruleINT0 EOF
            {
             before(grammarAccess.getINT0Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleINT0_in_entryRuleINT0305);
            ruleINT0();
            _fsp--;

             after(grammarAccess.getINT0Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleINT0312); 

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
    // $ANTLR end entryRuleINT0


    // $ANTLR start ruleINT0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:181:1: ruleINT0 : ( 'INT' ) ;
    public final void ruleINT0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:185:2: ( ( 'INT' ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:186:1: ( 'INT' )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:186:1: ( 'INT' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:187:1: 'INT'
            {
             before(grammarAccess.getINT0Access().getINTKeyword()); 
            match(input,11,FollowSets000.FOLLOW_11_in_ruleINT0340); 
             after(grammarAccess.getINT0Access().getINTKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleINT0


    // $ANTLR start entryRuleEString
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:202:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:203:1: ( ruleEString EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:204:1: ruleEString EOF
            {
             before(grammarAccess.getEStringRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_entryRuleEString368);
            ruleEString();
            _fsp--;

             after(grammarAccess.getEStringRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEString375); 

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
    // $ANTLR end entryRuleEString


    // $ANTLR start ruleEString
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:211:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:215:2: ( ( ( rule__EString__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:216:1: ( ( rule__EString__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:216:1: ( ( rule__EString__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:217:1: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:218:1: ( rule__EString__Alternatives )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:218:2: rule__EString__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__EString__Alternatives_in_ruleEString402);
            rule__EString__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getEStringAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleEString


    // $ANTLR start rule__Abstract__Alternatives
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:230:1: rule__Abstract__Alternatives : ( ( ruleConcrete0 ) | ( ruleConcrete1 ) );
    public final void rule__Abstract__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:234:1: ( ( ruleConcrete0 ) | ( ruleConcrete1 ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==18) ) {
                alt1=1;
            }
            else if ( (LA1_0==19) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("230:1: rule__Abstract__Alternatives : ( ( ruleConcrete0 ) | ( ruleConcrete1 ) );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:235:1: ( ruleConcrete0 )
                    {
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:235:1: ( ruleConcrete0 )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:236:1: ruleConcrete0
                    {
                     before(grammarAccess.getAbstractAccess().getConcrete0ParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleConcrete0_in_rule__Abstract__Alternatives438);
                    ruleConcrete0();
                    _fsp--;

                     after(grammarAccess.getAbstractAccess().getConcrete0ParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:241:6: ( ruleConcrete1 )
                    {
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:241:6: ( ruleConcrete1 )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:242:1: ruleConcrete1
                    {
                     before(grammarAccess.getAbstractAccess().getConcrete1ParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleConcrete1_in_rule__Abstract__Alternatives455);
                    ruleConcrete1();
                    _fsp--;

                     after(grammarAccess.getAbstractAccess().getConcrete1ParserRuleCall_1()); 

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
    // $ANTLR end rule__Abstract__Alternatives


    // $ANTLR start rule__EString__Alternatives
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:252:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:256:1: ( ( RULE_STRING ) | ( RULE_ID ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_STRING) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_ID) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("252:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:257:1: ( RULE_STRING )
                    {
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:257:1: ( RULE_STRING )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:258:1: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__EString__Alternatives487); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:263:6: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:263:6: ( RULE_ID )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:264:1: RULE_ID
                    {
                     before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EString__Alternatives504); 
                     after(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 

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
    // $ANTLR end rule__EString__Alternatives


    // $ANTLR start rule__Root__Group__0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:276:1: rule__Root__Group__0 : ( () ) rule__Root__Group__1 ;
    public final void rule__Root__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:280:1: ( ( () ) rule__Root__Group__1 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:281:1: ( () ) rule__Root__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:281:1: ( () )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:282:1: ()
            {
             before(grammarAccess.getRootAccess().getRootAction_0()); 
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:283:1: ()
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:285:1: 
            {
            }

             after(grammarAccess.getRootAccess().getRootAction_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group__1_in_rule__Root__Group__0548);
            rule__Root__Group__1();
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
    // $ANTLR end rule__Root__Group__0


    // $ANTLR start rule__Root__Group__1
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:296:1: rule__Root__Group__1 : ( 'Root' ) rule__Root__Group__2 ;
    public final void rule__Root__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:300:1: ( ( 'Root' ) rule__Root__Group__2 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:301:1: ( 'Root' ) rule__Root__Group__2
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:301:1: ( 'Root' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:302:1: 'Root'
            {
             before(grammarAccess.getRootAccess().getRootKeyword_1()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Root__Group__1577); 
             after(grammarAccess.getRootAccess().getRootKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group__2_in_rule__Root__Group__1587);
            rule__Root__Group__2();
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
    // $ANTLR end rule__Root__Group__1


    // $ANTLR start rule__Root__Group__2
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:316:1: rule__Root__Group__2 : ( '{' ) rule__Root__Group__3 ;
    public final void rule__Root__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:320:1: ( ( '{' ) rule__Root__Group__3 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:321:1: ( '{' ) rule__Root__Group__3
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:321:1: ( '{' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:322:1: '{'
            {
             before(grammarAccess.getRootAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Root__Group__2616); 
             after(grammarAccess.getRootAccess().getLeftCurlyBracketKeyword_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group__3_in_rule__Root__Group__2626);
            rule__Root__Group__3();
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
    // $ANTLR end rule__Root__Group__2


    // $ANTLR start rule__Root__Group__3
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:336:1: rule__Root__Group__3 : ( ( rule__Root__Group_3__0 )? ) rule__Root__Group__4 ;
    public final void rule__Root__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:340:1: ( ( ( rule__Root__Group_3__0 )? ) rule__Root__Group__4 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:341:1: ( ( rule__Root__Group_3__0 )? ) rule__Root__Group__4
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:341:1: ( ( rule__Root__Group_3__0 )? )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:342:1: ( rule__Root__Group_3__0 )?
            {
             before(grammarAccess.getRootAccess().getGroup_3()); 
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:343:1: ( rule__Root__Group_3__0 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==15) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:343:2: rule__Root__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Root__Group_3__0_in_rule__Root__Group__3654);
                    rule__Root__Group_3__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRootAccess().getGroup_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group__4_in_rule__Root__Group__3664);
            rule__Root__Group__4();
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
    // $ANTLR end rule__Root__Group__3


    // $ANTLR start rule__Root__Group__4
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:354:1: rule__Root__Group__4 : ( ( rule__Root__Group_4__0 )? ) rule__Root__Group__5 ;
    public final void rule__Root__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:358:1: ( ( ( rule__Root__Group_4__0 )? ) rule__Root__Group__5 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:359:1: ( ( rule__Root__Group_4__0 )? ) rule__Root__Group__5
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:359:1: ( ( rule__Root__Group_4__0 )? )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:360:1: ( rule__Root__Group_4__0 )?
            {
             before(grammarAccess.getRootAccess().getGroup_4()); 
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:361:1: ( rule__Root__Group_4__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:361:2: rule__Root__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Root__Group_4__0_in_rule__Root__Group__4692);
                    rule__Root__Group_4__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRootAccess().getGroup_4()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group__5_in_rule__Root__Group__4702);
            rule__Root__Group__5();
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
    // $ANTLR end rule__Root__Group__4


    // $ANTLR start rule__Root__Group__5
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:372:1: rule__Root__Group__5 : ( '}' ) ;
    public final void rule__Root__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:376:1: ( ( '}' ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:377:1: ( '}' )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:377:1: ( '}' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:378:1: '}'
            {
             before(grammarAccess.getRootAccess().getRightCurlyBracketKeyword_5()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Root__Group__5731); 
             after(grammarAccess.getRootAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Root__Group__5


    // $ANTLR start rule__Root__Group_3__0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:403:1: rule__Root__Group_3__0 : ( 'name' ) rule__Root__Group_3__1 ;
    public final void rule__Root__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:407:1: ( ( 'name' ) rule__Root__Group_3__1 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:408:1: ( 'name' ) rule__Root__Group_3__1
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:408:1: ( 'name' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:409:1: 'name'
            {
             before(grammarAccess.getRootAccess().getNameKeyword_3_0()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Root__Group_3__0779); 
             after(grammarAccess.getRootAccess().getNameKeyword_3_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group_3__1_in_rule__Root__Group_3__0789);
            rule__Root__Group_3__1();
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
    // $ANTLR end rule__Root__Group_3__0


    // $ANTLR start rule__Root__Group_3__1
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:423:1: rule__Root__Group_3__1 : ( ( rule__Root__NameAssignment_3_1 ) ) ;
    public final void rule__Root__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:427:1: ( ( ( rule__Root__NameAssignment_3_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:428:1: ( ( rule__Root__NameAssignment_3_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:428:1: ( ( rule__Root__NameAssignment_3_1 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:429:1: ( rule__Root__NameAssignment_3_1 )
            {
             before(grammarAccess.getRootAccess().getNameAssignment_3_1()); 
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:430:1: ( rule__Root__NameAssignment_3_1 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:430:2: rule__Root__NameAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Root__NameAssignment_3_1_in_rule__Root__Group_3__1817);
            rule__Root__NameAssignment_3_1();
            _fsp--;


            }

             after(grammarAccess.getRootAccess().getNameAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Root__Group_3__1


    // $ANTLR start rule__Root__Group_4__0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:444:1: rule__Root__Group_4__0 : ( 'classes' ) rule__Root__Group_4__1 ;
    public final void rule__Root__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:448:1: ( ( 'classes' ) rule__Root__Group_4__1 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:449:1: ( 'classes' ) rule__Root__Group_4__1
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:449:1: ( 'classes' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:450:1: 'classes'
            {
             before(grammarAccess.getRootAccess().getClassesKeyword_4_0()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Root__Group_4__0856); 
             after(grammarAccess.getRootAccess().getClassesKeyword_4_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group_4__1_in_rule__Root__Group_4__0866);
            rule__Root__Group_4__1();
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
    // $ANTLR end rule__Root__Group_4__0


    // $ANTLR start rule__Root__Group_4__1
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:464:1: rule__Root__Group_4__1 : ( '{' ) rule__Root__Group_4__2 ;
    public final void rule__Root__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:468:1: ( ( '{' ) rule__Root__Group_4__2 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:469:1: ( '{' ) rule__Root__Group_4__2
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:469:1: ( '{' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:470:1: '{'
            {
             before(grammarAccess.getRootAccess().getLeftCurlyBracketKeyword_4_1()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Root__Group_4__1895); 
             after(grammarAccess.getRootAccess().getLeftCurlyBracketKeyword_4_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group_4__2_in_rule__Root__Group_4__1905);
            rule__Root__Group_4__2();
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
    // $ANTLR end rule__Root__Group_4__1


    // $ANTLR start rule__Root__Group_4__2
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:484:1: rule__Root__Group_4__2 : ( ( rule__Root__ClassesAssignment_4_2 ) ) rule__Root__Group_4__3 ;
    public final void rule__Root__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:488:1: ( ( ( rule__Root__ClassesAssignment_4_2 ) ) rule__Root__Group_4__3 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:489:1: ( ( rule__Root__ClassesAssignment_4_2 ) ) rule__Root__Group_4__3
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:489:1: ( ( rule__Root__ClassesAssignment_4_2 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:490:1: ( rule__Root__ClassesAssignment_4_2 )
            {
             before(grammarAccess.getRootAccess().getClassesAssignment_4_2()); 
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:491:1: ( rule__Root__ClassesAssignment_4_2 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:491:2: rule__Root__ClassesAssignment_4_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Root__ClassesAssignment_4_2_in_rule__Root__Group_4__2933);
            rule__Root__ClassesAssignment_4_2();
            _fsp--;


            }

             after(grammarAccess.getRootAccess().getClassesAssignment_4_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group_4__3_in_rule__Root__Group_4__2942);
            rule__Root__Group_4__3();
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
    // $ANTLR end rule__Root__Group_4__2


    // $ANTLR start rule__Root__Group_4__3
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:502:1: rule__Root__Group_4__3 : ( ( rule__Root__Group_4_3__0 )* ) rule__Root__Group_4__4 ;
    public final void rule__Root__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:506:1: ( ( ( rule__Root__Group_4_3__0 )* ) rule__Root__Group_4__4 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:507:1: ( ( rule__Root__Group_4_3__0 )* ) rule__Root__Group_4__4
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:507:1: ( ( rule__Root__Group_4_3__0 )* )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:508:1: ( rule__Root__Group_4_3__0 )*
            {
             before(grammarAccess.getRootAccess().getGroup_4_3()); 
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:509:1: ( rule__Root__Group_4_3__0 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==17) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:509:2: rule__Root__Group_4_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Root__Group_4_3__0_in_rule__Root__Group_4__3970);
            	    rule__Root__Group_4_3__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getRootAccess().getGroup_4_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group_4__4_in_rule__Root__Group_4__3980);
            rule__Root__Group_4__4();
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
    // $ANTLR end rule__Root__Group_4__3


    // $ANTLR start rule__Root__Group_4__4
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:520:1: rule__Root__Group_4__4 : ( '}' ) ;
    public final void rule__Root__Group_4__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:524:1: ( ( '}' ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:525:1: ( '}' )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:525:1: ( '}' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:526:1: '}'
            {
             before(grammarAccess.getRootAccess().getRightCurlyBracketKeyword_4_4()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Root__Group_4__41009); 
             after(grammarAccess.getRootAccess().getRightCurlyBracketKeyword_4_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Root__Group_4__4


    // $ANTLR start rule__Root__Group_4_3__0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:549:1: rule__Root__Group_4_3__0 : ( ',' ) rule__Root__Group_4_3__1 ;
    public final void rule__Root__Group_4_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:553:1: ( ( ',' ) rule__Root__Group_4_3__1 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:554:1: ( ',' ) rule__Root__Group_4_3__1
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:554:1: ( ',' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:555:1: ','
            {
             before(grammarAccess.getRootAccess().getCommaKeyword_4_3_0()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__Root__Group_4_3__01055); 
             after(grammarAccess.getRootAccess().getCommaKeyword_4_3_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group_4_3__1_in_rule__Root__Group_4_3__01065);
            rule__Root__Group_4_3__1();
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
    // $ANTLR end rule__Root__Group_4_3__0


    // $ANTLR start rule__Root__Group_4_3__1
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:569:1: rule__Root__Group_4_3__1 : ( ( rule__Root__ClassesAssignment_4_3_1 ) ) ;
    public final void rule__Root__Group_4_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:573:1: ( ( ( rule__Root__ClassesAssignment_4_3_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:574:1: ( ( rule__Root__ClassesAssignment_4_3_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:574:1: ( ( rule__Root__ClassesAssignment_4_3_1 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:575:1: ( rule__Root__ClassesAssignment_4_3_1 )
            {
             before(grammarAccess.getRootAccess().getClassesAssignment_4_3_1()); 
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:576:1: ( rule__Root__ClassesAssignment_4_3_1 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:576:2: rule__Root__ClassesAssignment_4_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Root__ClassesAssignment_4_3_1_in_rule__Root__Group_4_3__11093);
            rule__Root__ClassesAssignment_4_3_1();
            _fsp--;


            }

             after(grammarAccess.getRootAccess().getClassesAssignment_4_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Root__Group_4_3__1


    // $ANTLR start rule__Concrete0__Group__0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:590:1: rule__Concrete0__Group__0 : ( () ) rule__Concrete0__Group__1 ;
    public final void rule__Concrete0__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:594:1: ( ( () ) rule__Concrete0__Group__1 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:595:1: ( () ) rule__Concrete0__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:595:1: ( () )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:596:1: ()
            {
             before(grammarAccess.getConcrete0Access().getConcrete0Action_0()); 
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:597:1: ()
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:599:1: 
            {
            }

             after(grammarAccess.getConcrete0Access().getConcrete0Action_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Concrete0__Group__1_in_rule__Concrete0__Group__01141);
            rule__Concrete0__Group__1();
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
    // $ANTLR end rule__Concrete0__Group__0


    // $ANTLR start rule__Concrete0__Group__1
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:610:1: rule__Concrete0__Group__1 : ( 'Concrete0' ) rule__Concrete0__Group__2 ;
    public final void rule__Concrete0__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:614:1: ( ( 'Concrete0' ) rule__Concrete0__Group__2 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:615:1: ( 'Concrete0' ) rule__Concrete0__Group__2
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:615:1: ( 'Concrete0' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:616:1: 'Concrete0'
            {
             before(grammarAccess.getConcrete0Access().getConcrete0Keyword_1()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Concrete0__Group__11170); 
             after(grammarAccess.getConcrete0Access().getConcrete0Keyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Concrete0__Group__2_in_rule__Concrete0__Group__11180);
            rule__Concrete0__Group__2();
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
    // $ANTLR end rule__Concrete0__Group__1


    // $ANTLR start rule__Concrete0__Group__2
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:630:1: rule__Concrete0__Group__2 : ( ( rule__Concrete0__NameAssignment_2 ) ) ;
    public final void rule__Concrete0__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:634:1: ( ( ( rule__Concrete0__NameAssignment_2 ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:635:1: ( ( rule__Concrete0__NameAssignment_2 ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:635:1: ( ( rule__Concrete0__NameAssignment_2 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:636:1: ( rule__Concrete0__NameAssignment_2 )
            {
             before(grammarAccess.getConcrete0Access().getNameAssignment_2()); 
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:637:1: ( rule__Concrete0__NameAssignment_2 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:637:2: rule__Concrete0__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Concrete0__NameAssignment_2_in_rule__Concrete0__Group__21208);
            rule__Concrete0__NameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getConcrete0Access().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Concrete0__Group__2


    // $ANTLR start rule__Concrete1__Group__0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:653:1: rule__Concrete1__Group__0 : ( () ) rule__Concrete1__Group__1 ;
    public final void rule__Concrete1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:657:1: ( ( () ) rule__Concrete1__Group__1 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:658:1: ( () ) rule__Concrete1__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:658:1: ( () )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:659:1: ()
            {
             before(grammarAccess.getConcrete1Access().getConcrete1Action_0()); 
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:660:1: ()
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:662:1: 
            {
            }

             after(grammarAccess.getConcrete1Access().getConcrete1Action_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Concrete1__Group__1_in_rule__Concrete1__Group__01258);
            rule__Concrete1__Group__1();
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
    // $ANTLR end rule__Concrete1__Group__0


    // $ANTLR start rule__Concrete1__Group__1
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:673:1: rule__Concrete1__Group__1 : ( 'Concrete1' ) rule__Concrete1__Group__2 ;
    public final void rule__Concrete1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:677:1: ( ( 'Concrete1' ) rule__Concrete1__Group__2 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:678:1: ( 'Concrete1' ) rule__Concrete1__Group__2
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:678:1: ( 'Concrete1' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:679:1: 'Concrete1'
            {
             before(grammarAccess.getConcrete1Access().getConcrete1Keyword_1()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Concrete1__Group__11287); 
             after(grammarAccess.getConcrete1Access().getConcrete1Keyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Concrete1__Group__2_in_rule__Concrete1__Group__11297);
            rule__Concrete1__Group__2();
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
    // $ANTLR end rule__Concrete1__Group__1


    // $ANTLR start rule__Concrete1__Group__2
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:693:1: rule__Concrete1__Group__2 : ( ( rule__Concrete1__NameAssignment_2 ) ) ;
    public final void rule__Concrete1__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:697:1: ( ( ( rule__Concrete1__NameAssignment_2 ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:698:1: ( ( rule__Concrete1__NameAssignment_2 ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:698:1: ( ( rule__Concrete1__NameAssignment_2 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:699:1: ( rule__Concrete1__NameAssignment_2 )
            {
             before(grammarAccess.getConcrete1Access().getNameAssignment_2()); 
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:700:1: ( rule__Concrete1__NameAssignment_2 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:700:2: rule__Concrete1__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Concrete1__NameAssignment_2_in_rule__Concrete1__Group__21325);
            rule__Concrete1__NameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getConcrete1Access().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Concrete1__Group__2


    // $ANTLR start rule__Root__NameAssignment_3_1
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:716:1: rule__Root__NameAssignment_3_1 : ( ruleINT0 ) ;
    public final void rule__Root__NameAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:720:1: ( ( ruleINT0 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:721:1: ( ruleINT0 )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:721:1: ( ruleINT0 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:722:1: ruleINT0
            {
             before(grammarAccess.getRootAccess().getNameINT0ParserRuleCall_3_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleINT0_in_rule__Root__NameAssignment_3_11365);
            ruleINT0();
            _fsp--;

             after(grammarAccess.getRootAccess().getNameINT0ParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Root__NameAssignment_3_1


    // $ANTLR start rule__Root__ClassesAssignment_4_2
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:731:1: rule__Root__ClassesAssignment_4_2 : ( ruleAbstract ) ;
    public final void rule__Root__ClassesAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:735:1: ( ( ruleAbstract ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:736:1: ( ruleAbstract )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:736:1: ( ruleAbstract )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:737:1: ruleAbstract
            {
             before(grammarAccess.getRootAccess().getClassesAbstractParserRuleCall_4_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstract_in_rule__Root__ClassesAssignment_4_21396);
            ruleAbstract();
            _fsp--;

             after(grammarAccess.getRootAccess().getClassesAbstractParserRuleCall_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Root__ClassesAssignment_4_2


    // $ANTLR start rule__Root__ClassesAssignment_4_3_1
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:746:1: rule__Root__ClassesAssignment_4_3_1 : ( ruleAbstract ) ;
    public final void rule__Root__ClassesAssignment_4_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:750:1: ( ( ruleAbstract ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:751:1: ( ruleAbstract )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:751:1: ( ruleAbstract )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:752:1: ruleAbstract
            {
             before(grammarAccess.getRootAccess().getClassesAbstractParserRuleCall_4_3_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstract_in_rule__Root__ClassesAssignment_4_3_11427);
            ruleAbstract();
            _fsp--;

             after(grammarAccess.getRootAccess().getClassesAbstractParserRuleCall_4_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Root__ClassesAssignment_4_3_1


    // $ANTLR start rule__Concrete0__NameAssignment_2
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:761:1: rule__Concrete0__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__Concrete0__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:765:1: ( ( ruleEString ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:766:1: ( ruleEString )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:766:1: ( ruleEString )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:767:1: ruleEString
            {
             before(grammarAccess.getConcrete0Access().getNameEStringParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__Concrete0__NameAssignment_21458);
            ruleEString();
            _fsp--;

             after(grammarAccess.getConcrete0Access().getNameEStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Concrete0__NameAssignment_2


    // $ANTLR start rule__Concrete1__NameAssignment_2
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:776:1: rule__Concrete1__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__Concrete1__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:780:1: ( ( ruleEString ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:781:1: ( ruleEString )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:781:1: ( ruleEString )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g:782:1: ruleEString
            {
             before(grammarAccess.getConcrete1Access().getNameEStringParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__Concrete1__NameAssignment_21489);
            ruleEString();
            _fsp--;

             after(grammarAccess.getConcrete1Access().getNameEStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Concrete1__NameAssignment_2


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRoot68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Group__0_in_ruleRoot95 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstract_in_entryRuleAbstract122 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstract129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Abstract__Alternatives_in_ruleAbstract156 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete0_in_entryRuleConcrete0183 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConcrete0190 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Concrete0__Group__0_in_ruleConcrete0217 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete1_in_entryRuleConcrete1244 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConcrete1251 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Concrete1__Group__0_in_ruleConcrete1278 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleINT0_in_entryRuleINT0305 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleINT0312 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleINT0340 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_entryRuleEString368 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEString375 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EString__Alternatives_in_ruleEString402 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete0_in_rule__Abstract__Alternatives438 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete1_in_rule__Abstract__Alternatives455 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__EString__Alternatives487 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EString__Alternatives504 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Group__1_in_rule__Root__Group__0548 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Root__Group__1577 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__Root__Group__2_in_rule__Root__Group__1587 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Root__Group__2616 = new BitSet(new long[]{0x000000000001C000L});
        public static final BitSet FOLLOW_rule__Root__Group__3_in_rule__Root__Group__2626 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Group_3__0_in_rule__Root__Group__3654 = new BitSet(new long[]{0x0000000000014000L});
        public static final BitSet FOLLOW_rule__Root__Group__4_in_rule__Root__Group__3664 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Group_4__0_in_rule__Root__Group__4692 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__Root__Group__5_in_rule__Root__Group__4702 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Root__Group__5731 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Root__Group_3__0779 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__Root__Group_3__1_in_rule__Root__Group_3__0789 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__NameAssignment_3_1_in_rule__Root__Group_3__1817 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Root__Group_4__0856 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__Root__Group_4__1_in_rule__Root__Group_4__0866 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Root__Group_4__1895 = new BitSet(new long[]{0x00000000000C0000L});
        public static final BitSet FOLLOW_rule__Root__Group_4__2_in_rule__Root__Group_4__1905 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__ClassesAssignment_4_2_in_rule__Root__Group_4__2933 = new BitSet(new long[]{0x0000000000024000L});
        public static final BitSet FOLLOW_rule__Root__Group_4__3_in_rule__Root__Group_4__2942 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Group_4_3__0_in_rule__Root__Group_4__3970 = new BitSet(new long[]{0x0000000000024000L});
        public static final BitSet FOLLOW_rule__Root__Group_4__4_in_rule__Root__Group_4__3980 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Root__Group_4__41009 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Root__Group_4_3__01055 = new BitSet(new long[]{0x00000000000C0000L});
        public static final BitSet FOLLOW_rule__Root__Group_4_3__1_in_rule__Root__Group_4_3__01065 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__ClassesAssignment_4_3_1_in_rule__Root__Group_4_3__11093 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Concrete0__Group__1_in_rule__Concrete0__Group__01141 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Concrete0__Group__11170 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__Concrete0__Group__2_in_rule__Concrete0__Group__11180 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Concrete0__NameAssignment_2_in_rule__Concrete0__Group__21208 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Concrete1__Group__1_in_rule__Concrete1__Group__01258 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Concrete1__Group__11287 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__Concrete1__Group__2_in_rule__Concrete1__Group__11297 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Concrete1__NameAssignment_2_in_rule__Concrete1__Group__21325 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleINT0_in_rule__Root__NameAssignment_3_11365 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstract_in_rule__Root__ClassesAssignment_4_21396 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstract_in_rule__Root__ClassesAssignment_4_3_11427 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__Concrete0__NameAssignment_21458 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__Concrete1__NameAssignment_21489 = new BitSet(new long[]{0x0000000000000002L});
    }


}
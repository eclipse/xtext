package org.eclipse.xtext.xtext.ui.ecore2xtext.ui.contentassist.antlr.internal; 

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
import org.eclipse.xtext.xtext.ui.ecore2xtext.services.Ecore2XtextTestGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalEcore2XtextTestParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'INT'", "'Root'", "'{'", "'}'", "'classes'", "','", "'concrete0'", "'Concrete0'", "'Concrete1'", "'DiamondInheritance'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalEcore2XtextTestParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g"; }


     
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:61:1: entryRuleRoot : ruleRoot EOF ;
    public final void entryRuleRoot() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:62:1: ( ruleRoot EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:63:1: ruleRoot EOF
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:70:1: ruleRoot : ( ( rule__Root__Group__0 ) ) ;
    public final void ruleRoot() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:74:2: ( ( ( rule__Root__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:75:1: ( ( rule__Root__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:75:1: ( ( rule__Root__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:76:1: ( rule__Root__Group__0 )
            {
             before(grammarAccess.getRootAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:77:1: ( rule__Root__Group__0 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:77:2: rule__Root__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Root__Group__0_in_ruleRoot94);
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:89:1: entryRuleAbstract : ruleAbstract EOF ;
    public final void entryRuleAbstract() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:90:1: ( ruleAbstract EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:91:1: ruleAbstract EOF
            {
             before(grammarAccess.getAbstractRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstract_in_entryRuleAbstract121);
            ruleAbstract();
            _fsp--;

             after(grammarAccess.getAbstractRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstract128); 

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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:98:1: ruleAbstract : ( ( rule__Abstract__Alternatives ) ) ;
    public final void ruleAbstract() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:102:2: ( ( ( rule__Abstract__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:103:1: ( ( rule__Abstract__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:103:1: ( ( rule__Abstract__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:104:1: ( rule__Abstract__Alternatives )
            {
             before(grammarAccess.getAbstractAccess().getAlternatives()); 
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:105:1: ( rule__Abstract__Alternatives )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:105:2: rule__Abstract__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Abstract__Alternatives_in_ruleAbstract154);
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:117:1: entryRuleConcrete0 : ruleConcrete0 EOF ;
    public final void entryRuleConcrete0() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:118:1: ( ruleConcrete0 EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:119:1: ruleConcrete0 EOF
            {
             before(grammarAccess.getConcrete0Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleConcrete0_in_entryRuleConcrete0181);
            ruleConcrete0();
            _fsp--;

             after(grammarAccess.getConcrete0Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConcrete0188); 

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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:126:1: ruleConcrete0 : ( ( rule__Concrete0__Alternatives ) ) ;
    public final void ruleConcrete0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:130:2: ( ( ( rule__Concrete0__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:131:1: ( ( rule__Concrete0__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:131:1: ( ( rule__Concrete0__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:132:1: ( rule__Concrete0__Alternatives )
            {
             before(grammarAccess.getConcrete0Access().getAlternatives()); 
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:133:1: ( rule__Concrete0__Alternatives )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:133:2: rule__Concrete0__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Concrete0__Alternatives_in_ruleConcrete0214);
            rule__Concrete0__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getConcrete0Access().getAlternatives()); 

            }


            }

        }
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


    // $ANTLR start entryRuleINT0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:145:1: entryRuleINT0 : ruleINT0 EOF ;
    public final void entryRuleINT0() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:146:1: ( ruleINT0 EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:147:1: ruleINT0 EOF
            {
             before(grammarAccess.getINT0Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleINT0_in_entryRuleINT0241);
            ruleINT0();
            _fsp--;

             after(grammarAccess.getINT0Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleINT0248); 

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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:154:1: ruleINT0 : ( 'INT' ) ;
    public final void ruleINT0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:158:2: ( ( 'INT' ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:159:1: ( 'INT' )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:159:1: ( 'INT' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:160:1: 'INT'
            {
             before(grammarAccess.getINT0Access().getINTKeyword()); 
            match(input,11,FollowSets000.FOLLOW_11_in_ruleINT0275); 
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


    // $ANTLR start entryRuleConcrete0_Impl
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:175:1: entryRuleConcrete0_Impl : ruleConcrete0_Impl EOF ;
    public final void entryRuleConcrete0_Impl() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:176:1: ( ruleConcrete0_Impl EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:177:1: ruleConcrete0_Impl EOF
            {
             before(grammarAccess.getConcrete0_ImplRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleConcrete0_Impl_in_entryRuleConcrete0_Impl303);
            ruleConcrete0_Impl();
            _fsp--;

             after(grammarAccess.getConcrete0_ImplRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConcrete0_Impl310); 

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
    // $ANTLR end entryRuleConcrete0_Impl


    // $ANTLR start ruleConcrete0_Impl
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:184:1: ruleConcrete0_Impl : ( ( rule__Concrete0_Impl__Group__0 ) ) ;
    public final void ruleConcrete0_Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:188:2: ( ( ( rule__Concrete0_Impl__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:189:1: ( ( rule__Concrete0_Impl__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:189:1: ( ( rule__Concrete0_Impl__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:190:1: ( rule__Concrete0_Impl__Group__0 )
            {
             before(grammarAccess.getConcrete0_ImplAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:191:1: ( rule__Concrete0_Impl__Group__0 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:191:2: rule__Concrete0_Impl__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Concrete0_Impl__Group__0_in_ruleConcrete0_Impl336);
            rule__Concrete0_Impl__Group__0();
            _fsp--;


            }

             after(grammarAccess.getConcrete0_ImplAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleConcrete0_Impl


    // $ANTLR start entryRuleEString
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:203:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:204:1: ( ruleEString EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:205:1: ruleEString EOF
            {
             before(grammarAccess.getEStringRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_entryRuleEString363);
            ruleEString();
            _fsp--;

             after(grammarAccess.getEStringRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEString370); 

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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:212:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:216:2: ( ( ( rule__EString__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:217:1: ( ( rule__EString__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:217:1: ( ( rule__EString__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:218:1: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:219:1: ( rule__EString__Alternatives )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:219:2: rule__EString__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__EString__Alternatives_in_ruleEString396);
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


    // $ANTLR start entryRuleConcrete1_Impl
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:231:1: entryRuleConcrete1_Impl : ruleConcrete1_Impl EOF ;
    public final void entryRuleConcrete1_Impl() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:232:1: ( ruleConcrete1_Impl EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:233:1: ruleConcrete1_Impl EOF
            {
             before(grammarAccess.getConcrete1_ImplRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleConcrete1_Impl_in_entryRuleConcrete1_Impl423);
            ruleConcrete1_Impl();
            _fsp--;

             after(grammarAccess.getConcrete1_ImplRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConcrete1_Impl430); 

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
    // $ANTLR end entryRuleConcrete1_Impl


    // $ANTLR start ruleConcrete1_Impl
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:240:1: ruleConcrete1_Impl : ( ( rule__Concrete1_Impl__Group__0 ) ) ;
    public final void ruleConcrete1_Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:244:2: ( ( ( rule__Concrete1_Impl__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:245:1: ( ( rule__Concrete1_Impl__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:245:1: ( ( rule__Concrete1_Impl__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:246:1: ( rule__Concrete1_Impl__Group__0 )
            {
             before(grammarAccess.getConcrete1_ImplAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:247:1: ( rule__Concrete1_Impl__Group__0 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:247:2: rule__Concrete1_Impl__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Concrete1_Impl__Group__0_in_ruleConcrete1_Impl456);
            rule__Concrete1_Impl__Group__0();
            _fsp--;


            }

             after(grammarAccess.getConcrete1_ImplAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleConcrete1_Impl


    // $ANTLR start entryRuleDiamondInheritance
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:259:1: entryRuleDiamondInheritance : ruleDiamondInheritance EOF ;
    public final void entryRuleDiamondInheritance() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:260:1: ( ruleDiamondInheritance EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:261:1: ruleDiamondInheritance EOF
            {
             before(grammarAccess.getDiamondInheritanceRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleDiamondInheritance_in_entryRuleDiamondInheritance483);
            ruleDiamondInheritance();
            _fsp--;

             after(grammarAccess.getDiamondInheritanceRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDiamondInheritance490); 

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
    // $ANTLR end entryRuleDiamondInheritance


    // $ANTLR start ruleDiamondInheritance
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:268:1: ruleDiamondInheritance : ( ( rule__DiamondInheritance__Group__0 ) ) ;
    public final void ruleDiamondInheritance() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:272:2: ( ( ( rule__DiamondInheritance__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:273:1: ( ( rule__DiamondInheritance__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:273:1: ( ( rule__DiamondInheritance__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:274:1: ( rule__DiamondInheritance__Group__0 )
            {
             before(grammarAccess.getDiamondInheritanceAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:275:1: ( rule__DiamondInheritance__Group__0 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:275:2: rule__DiamondInheritance__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__DiamondInheritance__Group__0_in_ruleDiamondInheritance516);
            rule__DiamondInheritance__Group__0();
            _fsp--;


            }

             after(grammarAccess.getDiamondInheritanceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleDiamondInheritance


    // $ANTLR start rule__Abstract__Alternatives
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:287:1: rule__Abstract__Alternatives : ( ( ruleConcrete0_Impl ) | ( ruleConcrete1_Impl ) | ( ruleDiamondInheritance ) );
    public final void rule__Abstract__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:291:1: ( ( ruleConcrete0_Impl ) | ( ruleConcrete1_Impl ) | ( ruleDiamondInheritance ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt1=1;
                }
                break;
            case 19:
                {
                alt1=2;
                }
                break;
            case 20:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("287:1: rule__Abstract__Alternatives : ( ( ruleConcrete0_Impl ) | ( ruleConcrete1_Impl ) | ( ruleDiamondInheritance ) );", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:292:1: ( ruleConcrete0_Impl )
                    {
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:292:1: ( ruleConcrete0_Impl )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:293:1: ruleConcrete0_Impl
                    {
                     before(grammarAccess.getAbstractAccess().getConcrete0_ImplParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleConcrete0_Impl_in_rule__Abstract__Alternatives552);
                    ruleConcrete0_Impl();
                    _fsp--;

                     after(grammarAccess.getAbstractAccess().getConcrete0_ImplParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:298:6: ( ruleConcrete1_Impl )
                    {
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:298:6: ( ruleConcrete1_Impl )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:299:1: ruleConcrete1_Impl
                    {
                     before(grammarAccess.getAbstractAccess().getConcrete1_ImplParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleConcrete1_Impl_in_rule__Abstract__Alternatives569);
                    ruleConcrete1_Impl();
                    _fsp--;

                     after(grammarAccess.getAbstractAccess().getConcrete1_ImplParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:304:6: ( ruleDiamondInheritance )
                    {
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:304:6: ( ruleDiamondInheritance )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:305:1: ruleDiamondInheritance
                    {
                     before(grammarAccess.getAbstractAccess().getDiamondInheritanceParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_ruleDiamondInheritance_in_rule__Abstract__Alternatives586);
                    ruleDiamondInheritance();
                    _fsp--;

                     after(grammarAccess.getAbstractAccess().getDiamondInheritanceParserRuleCall_2()); 

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


    // $ANTLR start rule__Concrete0__Alternatives
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:315:1: rule__Concrete0__Alternatives : ( ( ruleConcrete0_Impl ) | ( ruleDiamondInheritance ) );
    public final void rule__Concrete0__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:319:1: ( ( ruleConcrete0_Impl ) | ( ruleDiamondInheritance ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==18) ) {
                alt2=1;
            }
            else if ( (LA2_0==20) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("315:1: rule__Concrete0__Alternatives : ( ( ruleConcrete0_Impl ) | ( ruleDiamondInheritance ) );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:320:1: ( ruleConcrete0_Impl )
                    {
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:320:1: ( ruleConcrete0_Impl )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:321:1: ruleConcrete0_Impl
                    {
                     before(grammarAccess.getConcrete0Access().getConcrete0_ImplParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleConcrete0_Impl_in_rule__Concrete0__Alternatives618);
                    ruleConcrete0_Impl();
                    _fsp--;

                     after(grammarAccess.getConcrete0Access().getConcrete0_ImplParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:326:6: ( ruleDiamondInheritance )
                    {
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:326:6: ( ruleDiamondInheritance )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:327:1: ruleDiamondInheritance
                    {
                     before(grammarAccess.getConcrete0Access().getDiamondInheritanceParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleDiamondInheritance_in_rule__Concrete0__Alternatives635);
                    ruleDiamondInheritance();
                    _fsp--;

                     after(grammarAccess.getConcrete0Access().getDiamondInheritanceParserRuleCall_1()); 

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
    // $ANTLR end rule__Concrete0__Alternatives


    // $ANTLR start rule__EString__Alternatives
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:337:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:341:1: ( ( RULE_STRING ) | ( RULE_ID ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_STRING) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_ID) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("337:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:342:1: ( RULE_STRING )
                    {
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:342:1: ( RULE_STRING )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:343:1: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__EString__Alternatives667); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:348:6: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:348:6: ( RULE_ID )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:349:1: RULE_ID
                    {
                     before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EString__Alternatives684); 
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:361:1: rule__Root__Group__0 : rule__Root__Group__0__Impl rule__Root__Group__1 ;
    public final void rule__Root__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:365:1: ( rule__Root__Group__0__Impl rule__Root__Group__1 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:366:2: rule__Root__Group__0__Impl rule__Root__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Root__Group__0__Impl_in_rule__Root__Group__0714);
            rule__Root__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group__1_in_rule__Root__Group__0717);
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


    // $ANTLR start rule__Root__Group__0__Impl
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:373:1: rule__Root__Group__0__Impl : ( () ) ;
    public final void rule__Root__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:377:1: ( ( () ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:378:1: ( () )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:378:1: ( () )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:379:1: ()
            {
             before(grammarAccess.getRootAccess().getRootAction_0()); 
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:380:1: ()
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:382:1: 
            {
            }

             after(grammarAccess.getRootAccess().getRootAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Root__Group__0__Impl


    // $ANTLR start rule__Root__Group__1
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:392:1: rule__Root__Group__1 : rule__Root__Group__1__Impl rule__Root__Group__2 ;
    public final void rule__Root__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:396:1: ( rule__Root__Group__1__Impl rule__Root__Group__2 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:397:2: rule__Root__Group__1__Impl rule__Root__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Root__Group__1__Impl_in_rule__Root__Group__1775);
            rule__Root__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group__2_in_rule__Root__Group__1778);
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


    // $ANTLR start rule__Root__Group__1__Impl
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:404:1: rule__Root__Group__1__Impl : ( 'Root' ) ;
    public final void rule__Root__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:408:1: ( ( 'Root' ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:409:1: ( 'Root' )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:409:1: ( 'Root' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:410:1: 'Root'
            {
             before(grammarAccess.getRootAccess().getRootKeyword_1()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Root__Group__1__Impl806); 
             after(grammarAccess.getRootAccess().getRootKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Root__Group__1__Impl


    // $ANTLR start rule__Root__Group__2
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:423:1: rule__Root__Group__2 : rule__Root__Group__2__Impl rule__Root__Group__3 ;
    public final void rule__Root__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:427:1: ( rule__Root__Group__2__Impl rule__Root__Group__3 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:428:2: rule__Root__Group__2__Impl rule__Root__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Root__Group__2__Impl_in_rule__Root__Group__2837);
            rule__Root__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group__3_in_rule__Root__Group__2840);
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


    // $ANTLR start rule__Root__Group__2__Impl
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:435:1: rule__Root__Group__2__Impl : ( ( rule__Root__NameAssignment_2 ) ) ;
    public final void rule__Root__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:439:1: ( ( ( rule__Root__NameAssignment_2 ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:440:1: ( ( rule__Root__NameAssignment_2 ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:440:1: ( ( rule__Root__NameAssignment_2 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:441:1: ( rule__Root__NameAssignment_2 )
            {
             before(grammarAccess.getRootAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:442:1: ( rule__Root__NameAssignment_2 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:442:2: rule__Root__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Root__NameAssignment_2_in_rule__Root__Group__2__Impl867);
            rule__Root__NameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getRootAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Root__Group__2__Impl


    // $ANTLR start rule__Root__Group__3
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:452:1: rule__Root__Group__3 : rule__Root__Group__3__Impl rule__Root__Group__4 ;
    public final void rule__Root__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:456:1: ( rule__Root__Group__3__Impl rule__Root__Group__4 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:457:2: rule__Root__Group__3__Impl rule__Root__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Root__Group__3__Impl_in_rule__Root__Group__3897);
            rule__Root__Group__3__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group__4_in_rule__Root__Group__3900);
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


    // $ANTLR start rule__Root__Group__3__Impl
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:464:1: rule__Root__Group__3__Impl : ( '{' ) ;
    public final void rule__Root__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:468:1: ( ( '{' ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:469:1: ( '{' )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:469:1: ( '{' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:470:1: '{'
            {
             before(grammarAccess.getRootAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Root__Group__3__Impl928); 
             after(grammarAccess.getRootAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Root__Group__3__Impl


    // $ANTLR start rule__Root__Group__4
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:483:1: rule__Root__Group__4 : rule__Root__Group__4__Impl rule__Root__Group__5 ;
    public final void rule__Root__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:487:1: ( rule__Root__Group__4__Impl rule__Root__Group__5 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:488:2: rule__Root__Group__4__Impl rule__Root__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Root__Group__4__Impl_in_rule__Root__Group__4959);
            rule__Root__Group__4__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group__5_in_rule__Root__Group__4962);
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


    // $ANTLR start rule__Root__Group__4__Impl
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:495:1: rule__Root__Group__4__Impl : ( ( rule__Root__Group_4__0 )? ) ;
    public final void rule__Root__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:499:1: ( ( ( rule__Root__Group_4__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:500:1: ( ( rule__Root__Group_4__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:500:1: ( ( rule__Root__Group_4__0 )? )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:501:1: ( rule__Root__Group_4__0 )?
            {
             before(grammarAccess.getRootAccess().getGroup_4()); 
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:502:1: ( rule__Root__Group_4__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:502:2: rule__Root__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Root__Group_4__0_in_rule__Root__Group__4__Impl989);
                    rule__Root__Group_4__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRootAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Root__Group__4__Impl


    // $ANTLR start rule__Root__Group__5
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:512:1: rule__Root__Group__5 : rule__Root__Group__5__Impl rule__Root__Group__6 ;
    public final void rule__Root__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:516:1: ( rule__Root__Group__5__Impl rule__Root__Group__6 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:517:2: rule__Root__Group__5__Impl rule__Root__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__Root__Group__5__Impl_in_rule__Root__Group__51020);
            rule__Root__Group__5__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group__6_in_rule__Root__Group__51023);
            rule__Root__Group__6();
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
    // $ANTLR end rule__Root__Group__5


    // $ANTLR start rule__Root__Group__5__Impl
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:524:1: rule__Root__Group__5__Impl : ( ( rule__Root__Group_5__0 )? ) ;
    public final void rule__Root__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:528:1: ( ( ( rule__Root__Group_5__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:529:1: ( ( rule__Root__Group_5__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:529:1: ( ( rule__Root__Group_5__0 )? )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:530:1: ( rule__Root__Group_5__0 )?
            {
             before(grammarAccess.getRootAccess().getGroup_5()); 
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:531:1: ( rule__Root__Group_5__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:531:2: rule__Root__Group_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Root__Group_5__0_in_rule__Root__Group__5__Impl1050);
                    rule__Root__Group_5__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRootAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Root__Group__5__Impl


    // $ANTLR start rule__Root__Group__6
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:541:1: rule__Root__Group__6 : rule__Root__Group__6__Impl ;
    public final void rule__Root__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:545:1: ( rule__Root__Group__6__Impl )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:546:2: rule__Root__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Root__Group__6__Impl_in_rule__Root__Group__61081);
            rule__Root__Group__6__Impl();
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
    // $ANTLR end rule__Root__Group__6


    // $ANTLR start rule__Root__Group__6__Impl
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:552:1: rule__Root__Group__6__Impl : ( '}' ) ;
    public final void rule__Root__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:556:1: ( ( '}' ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:557:1: ( '}' )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:557:1: ( '}' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:558:1: '}'
            {
             before(grammarAccess.getRootAccess().getRightCurlyBracketKeyword_6()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Root__Group__6__Impl1109); 
             after(grammarAccess.getRootAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Root__Group__6__Impl


    // $ANTLR start rule__Root__Group_4__0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:585:1: rule__Root__Group_4__0 : rule__Root__Group_4__0__Impl rule__Root__Group_4__1 ;
    public final void rule__Root__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:589:1: ( rule__Root__Group_4__0__Impl rule__Root__Group_4__1 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:590:2: rule__Root__Group_4__0__Impl rule__Root__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Root__Group_4__0__Impl_in_rule__Root__Group_4__01154);
            rule__Root__Group_4__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group_4__1_in_rule__Root__Group_4__01157);
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


    // $ANTLR start rule__Root__Group_4__0__Impl
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:597:1: rule__Root__Group_4__0__Impl : ( 'classes' ) ;
    public final void rule__Root__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:601:1: ( ( 'classes' ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:602:1: ( 'classes' )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:602:1: ( 'classes' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:603:1: 'classes'
            {
             before(grammarAccess.getRootAccess().getClassesKeyword_4_0()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Root__Group_4__0__Impl1185); 
             after(grammarAccess.getRootAccess().getClassesKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Root__Group_4__0__Impl


    // $ANTLR start rule__Root__Group_4__1
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:616:1: rule__Root__Group_4__1 : rule__Root__Group_4__1__Impl rule__Root__Group_4__2 ;
    public final void rule__Root__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:620:1: ( rule__Root__Group_4__1__Impl rule__Root__Group_4__2 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:621:2: rule__Root__Group_4__1__Impl rule__Root__Group_4__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Root__Group_4__1__Impl_in_rule__Root__Group_4__11216);
            rule__Root__Group_4__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group_4__2_in_rule__Root__Group_4__11219);
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


    // $ANTLR start rule__Root__Group_4__1__Impl
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:628:1: rule__Root__Group_4__1__Impl : ( '{' ) ;
    public final void rule__Root__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:632:1: ( ( '{' ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:633:1: ( '{' )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:633:1: ( '{' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:634:1: '{'
            {
             before(grammarAccess.getRootAccess().getLeftCurlyBracketKeyword_4_1()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Root__Group_4__1__Impl1247); 
             after(grammarAccess.getRootAccess().getLeftCurlyBracketKeyword_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Root__Group_4__1__Impl


    // $ANTLR start rule__Root__Group_4__2
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:647:1: rule__Root__Group_4__2 : rule__Root__Group_4__2__Impl rule__Root__Group_4__3 ;
    public final void rule__Root__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:651:1: ( rule__Root__Group_4__2__Impl rule__Root__Group_4__3 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:652:2: rule__Root__Group_4__2__Impl rule__Root__Group_4__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Root__Group_4__2__Impl_in_rule__Root__Group_4__21278);
            rule__Root__Group_4__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group_4__3_in_rule__Root__Group_4__21281);
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


    // $ANTLR start rule__Root__Group_4__2__Impl
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:659:1: rule__Root__Group_4__2__Impl : ( ( rule__Root__ClassesAssignment_4_2 ) ) ;
    public final void rule__Root__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:663:1: ( ( ( rule__Root__ClassesAssignment_4_2 ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:664:1: ( ( rule__Root__ClassesAssignment_4_2 ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:664:1: ( ( rule__Root__ClassesAssignment_4_2 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:665:1: ( rule__Root__ClassesAssignment_4_2 )
            {
             before(grammarAccess.getRootAccess().getClassesAssignment_4_2()); 
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:666:1: ( rule__Root__ClassesAssignment_4_2 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:666:2: rule__Root__ClassesAssignment_4_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Root__ClassesAssignment_4_2_in_rule__Root__Group_4__2__Impl1308);
            rule__Root__ClassesAssignment_4_2();
            _fsp--;


            }

             after(grammarAccess.getRootAccess().getClassesAssignment_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Root__Group_4__2__Impl


    // $ANTLR start rule__Root__Group_4__3
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:676:1: rule__Root__Group_4__3 : rule__Root__Group_4__3__Impl rule__Root__Group_4__4 ;
    public final void rule__Root__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:680:1: ( rule__Root__Group_4__3__Impl rule__Root__Group_4__4 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:681:2: rule__Root__Group_4__3__Impl rule__Root__Group_4__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Root__Group_4__3__Impl_in_rule__Root__Group_4__31338);
            rule__Root__Group_4__3__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group_4__4_in_rule__Root__Group_4__31341);
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


    // $ANTLR start rule__Root__Group_4__3__Impl
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:688:1: rule__Root__Group_4__3__Impl : ( ( rule__Root__Group_4_3__0 )* ) ;
    public final void rule__Root__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:692:1: ( ( ( rule__Root__Group_4_3__0 )* ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:693:1: ( ( rule__Root__Group_4_3__0 )* )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:693:1: ( ( rule__Root__Group_4_3__0 )* )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:694:1: ( rule__Root__Group_4_3__0 )*
            {
             before(grammarAccess.getRootAccess().getGroup_4_3()); 
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:695:1: ( rule__Root__Group_4_3__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==16) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:695:2: rule__Root__Group_4_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Root__Group_4_3__0_in_rule__Root__Group_4__3__Impl1368);
            	    rule__Root__Group_4_3__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getRootAccess().getGroup_4_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Root__Group_4__3__Impl


    // $ANTLR start rule__Root__Group_4__4
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:705:1: rule__Root__Group_4__4 : rule__Root__Group_4__4__Impl ;
    public final void rule__Root__Group_4__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:709:1: ( rule__Root__Group_4__4__Impl )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:710:2: rule__Root__Group_4__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Root__Group_4__4__Impl_in_rule__Root__Group_4__41399);
            rule__Root__Group_4__4__Impl();
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
    // $ANTLR end rule__Root__Group_4__4


    // $ANTLR start rule__Root__Group_4__4__Impl
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:716:1: rule__Root__Group_4__4__Impl : ( '}' ) ;
    public final void rule__Root__Group_4__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:720:1: ( ( '}' ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:721:1: ( '}' )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:721:1: ( '}' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:722:1: '}'
            {
             before(grammarAccess.getRootAccess().getRightCurlyBracketKeyword_4_4()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Root__Group_4__4__Impl1427); 
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
    // $ANTLR end rule__Root__Group_4__4__Impl


    // $ANTLR start rule__Root__Group_4_3__0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:745:1: rule__Root__Group_4_3__0 : rule__Root__Group_4_3__0__Impl rule__Root__Group_4_3__1 ;
    public final void rule__Root__Group_4_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:749:1: ( rule__Root__Group_4_3__0__Impl rule__Root__Group_4_3__1 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:750:2: rule__Root__Group_4_3__0__Impl rule__Root__Group_4_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Root__Group_4_3__0__Impl_in_rule__Root__Group_4_3__01468);
            rule__Root__Group_4_3__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group_4_3__1_in_rule__Root__Group_4_3__01471);
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


    // $ANTLR start rule__Root__Group_4_3__0__Impl
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:757:1: rule__Root__Group_4_3__0__Impl : ( ',' ) ;
    public final void rule__Root__Group_4_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:761:1: ( ( ',' ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:762:1: ( ',' )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:762:1: ( ',' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:763:1: ','
            {
             before(grammarAccess.getRootAccess().getCommaKeyword_4_3_0()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Root__Group_4_3__0__Impl1499); 
             after(grammarAccess.getRootAccess().getCommaKeyword_4_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Root__Group_4_3__0__Impl


    // $ANTLR start rule__Root__Group_4_3__1
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:776:1: rule__Root__Group_4_3__1 : rule__Root__Group_4_3__1__Impl ;
    public final void rule__Root__Group_4_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:780:1: ( rule__Root__Group_4_3__1__Impl )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:781:2: rule__Root__Group_4_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Root__Group_4_3__1__Impl_in_rule__Root__Group_4_3__11530);
            rule__Root__Group_4_3__1__Impl();
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
    // $ANTLR end rule__Root__Group_4_3__1


    // $ANTLR start rule__Root__Group_4_3__1__Impl
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:787:1: rule__Root__Group_4_3__1__Impl : ( ( rule__Root__ClassesAssignment_4_3_1 ) ) ;
    public final void rule__Root__Group_4_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:791:1: ( ( ( rule__Root__ClassesAssignment_4_3_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:792:1: ( ( rule__Root__ClassesAssignment_4_3_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:792:1: ( ( rule__Root__ClassesAssignment_4_3_1 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:793:1: ( rule__Root__ClassesAssignment_4_3_1 )
            {
             before(grammarAccess.getRootAccess().getClassesAssignment_4_3_1()); 
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:794:1: ( rule__Root__ClassesAssignment_4_3_1 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:794:2: rule__Root__ClassesAssignment_4_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Root__ClassesAssignment_4_3_1_in_rule__Root__Group_4_3__1__Impl1557);
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
    // $ANTLR end rule__Root__Group_4_3__1__Impl


    // $ANTLR start rule__Root__Group_5__0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:808:1: rule__Root__Group_5__0 : rule__Root__Group_5__0__Impl rule__Root__Group_5__1 ;
    public final void rule__Root__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:812:1: ( rule__Root__Group_5__0__Impl rule__Root__Group_5__1 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:813:2: rule__Root__Group_5__0__Impl rule__Root__Group_5__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Root__Group_5__0__Impl_in_rule__Root__Group_5__01591);
            rule__Root__Group_5__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group_5__1_in_rule__Root__Group_5__01594);
            rule__Root__Group_5__1();
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
    // $ANTLR end rule__Root__Group_5__0


    // $ANTLR start rule__Root__Group_5__0__Impl
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:820:1: rule__Root__Group_5__0__Impl : ( 'concrete0' ) ;
    public final void rule__Root__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:824:1: ( ( 'concrete0' ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:825:1: ( 'concrete0' )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:825:1: ( 'concrete0' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:826:1: 'concrete0'
            {
             before(grammarAccess.getRootAccess().getConcrete0Keyword_5_0()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__Root__Group_5__0__Impl1622); 
             after(grammarAccess.getRootAccess().getConcrete0Keyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Root__Group_5__0__Impl


    // $ANTLR start rule__Root__Group_5__1
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:839:1: rule__Root__Group_5__1 : rule__Root__Group_5__1__Impl ;
    public final void rule__Root__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:843:1: ( rule__Root__Group_5__1__Impl )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:844:2: rule__Root__Group_5__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Root__Group_5__1__Impl_in_rule__Root__Group_5__11653);
            rule__Root__Group_5__1__Impl();
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
    // $ANTLR end rule__Root__Group_5__1


    // $ANTLR start rule__Root__Group_5__1__Impl
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:850:1: rule__Root__Group_5__1__Impl : ( ( rule__Root__Concrete0Assignment_5_1 ) ) ;
    public final void rule__Root__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:854:1: ( ( ( rule__Root__Concrete0Assignment_5_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:855:1: ( ( rule__Root__Concrete0Assignment_5_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:855:1: ( ( rule__Root__Concrete0Assignment_5_1 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:856:1: ( rule__Root__Concrete0Assignment_5_1 )
            {
             before(grammarAccess.getRootAccess().getConcrete0Assignment_5_1()); 
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:857:1: ( rule__Root__Concrete0Assignment_5_1 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:857:2: rule__Root__Concrete0Assignment_5_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Root__Concrete0Assignment_5_1_in_rule__Root__Group_5__1__Impl1680);
            rule__Root__Concrete0Assignment_5_1();
            _fsp--;


            }

             after(grammarAccess.getRootAccess().getConcrete0Assignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Root__Group_5__1__Impl


    // $ANTLR start rule__Concrete0_Impl__Group__0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:871:1: rule__Concrete0_Impl__Group__0 : rule__Concrete0_Impl__Group__0__Impl rule__Concrete0_Impl__Group__1 ;
    public final void rule__Concrete0_Impl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:875:1: ( rule__Concrete0_Impl__Group__0__Impl rule__Concrete0_Impl__Group__1 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:876:2: rule__Concrete0_Impl__Group__0__Impl rule__Concrete0_Impl__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Concrete0_Impl__Group__0__Impl_in_rule__Concrete0_Impl__Group__01714);
            rule__Concrete0_Impl__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Concrete0_Impl__Group__1_in_rule__Concrete0_Impl__Group__01717);
            rule__Concrete0_Impl__Group__1();
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
    // $ANTLR end rule__Concrete0_Impl__Group__0


    // $ANTLR start rule__Concrete0_Impl__Group__0__Impl
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:883:1: rule__Concrete0_Impl__Group__0__Impl : ( () ) ;
    public final void rule__Concrete0_Impl__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:887:1: ( ( () ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:888:1: ( () )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:888:1: ( () )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:889:1: ()
            {
             before(grammarAccess.getConcrete0_ImplAccess().getConcrete0Action_0()); 
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:890:1: ()
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:892:1: 
            {
            }

             after(grammarAccess.getConcrete0_ImplAccess().getConcrete0Action_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Concrete0_Impl__Group__0__Impl


    // $ANTLR start rule__Concrete0_Impl__Group__1
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:902:1: rule__Concrete0_Impl__Group__1 : rule__Concrete0_Impl__Group__1__Impl rule__Concrete0_Impl__Group__2 ;
    public final void rule__Concrete0_Impl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:906:1: ( rule__Concrete0_Impl__Group__1__Impl rule__Concrete0_Impl__Group__2 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:907:2: rule__Concrete0_Impl__Group__1__Impl rule__Concrete0_Impl__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Concrete0_Impl__Group__1__Impl_in_rule__Concrete0_Impl__Group__11775);
            rule__Concrete0_Impl__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Concrete0_Impl__Group__2_in_rule__Concrete0_Impl__Group__11778);
            rule__Concrete0_Impl__Group__2();
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
    // $ANTLR end rule__Concrete0_Impl__Group__1


    // $ANTLR start rule__Concrete0_Impl__Group__1__Impl
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:914:1: rule__Concrete0_Impl__Group__1__Impl : ( 'Concrete0' ) ;
    public final void rule__Concrete0_Impl__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:918:1: ( ( 'Concrete0' ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:919:1: ( 'Concrete0' )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:919:1: ( 'Concrete0' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:920:1: 'Concrete0'
            {
             before(grammarAccess.getConcrete0_ImplAccess().getConcrete0Keyword_1()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Concrete0_Impl__Group__1__Impl1806); 
             after(grammarAccess.getConcrete0_ImplAccess().getConcrete0Keyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Concrete0_Impl__Group__1__Impl


    // $ANTLR start rule__Concrete0_Impl__Group__2
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:933:1: rule__Concrete0_Impl__Group__2 : rule__Concrete0_Impl__Group__2__Impl ;
    public final void rule__Concrete0_Impl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:937:1: ( rule__Concrete0_Impl__Group__2__Impl )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:938:2: rule__Concrete0_Impl__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Concrete0_Impl__Group__2__Impl_in_rule__Concrete0_Impl__Group__21837);
            rule__Concrete0_Impl__Group__2__Impl();
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
    // $ANTLR end rule__Concrete0_Impl__Group__2


    // $ANTLR start rule__Concrete0_Impl__Group__2__Impl
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:944:1: rule__Concrete0_Impl__Group__2__Impl : ( ( rule__Concrete0_Impl__NameAssignment_2 ) ) ;
    public final void rule__Concrete0_Impl__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:948:1: ( ( ( rule__Concrete0_Impl__NameAssignment_2 ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:949:1: ( ( rule__Concrete0_Impl__NameAssignment_2 ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:949:1: ( ( rule__Concrete0_Impl__NameAssignment_2 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:950:1: ( rule__Concrete0_Impl__NameAssignment_2 )
            {
             before(grammarAccess.getConcrete0_ImplAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:951:1: ( rule__Concrete0_Impl__NameAssignment_2 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:951:2: rule__Concrete0_Impl__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Concrete0_Impl__NameAssignment_2_in_rule__Concrete0_Impl__Group__2__Impl1864);
            rule__Concrete0_Impl__NameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getConcrete0_ImplAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Concrete0_Impl__Group__2__Impl


    // $ANTLR start rule__Concrete1_Impl__Group__0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:967:1: rule__Concrete1_Impl__Group__0 : rule__Concrete1_Impl__Group__0__Impl rule__Concrete1_Impl__Group__1 ;
    public final void rule__Concrete1_Impl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:971:1: ( rule__Concrete1_Impl__Group__0__Impl rule__Concrete1_Impl__Group__1 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:972:2: rule__Concrete1_Impl__Group__0__Impl rule__Concrete1_Impl__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Concrete1_Impl__Group__0__Impl_in_rule__Concrete1_Impl__Group__01900);
            rule__Concrete1_Impl__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Concrete1_Impl__Group__1_in_rule__Concrete1_Impl__Group__01903);
            rule__Concrete1_Impl__Group__1();
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
    // $ANTLR end rule__Concrete1_Impl__Group__0


    // $ANTLR start rule__Concrete1_Impl__Group__0__Impl
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:979:1: rule__Concrete1_Impl__Group__0__Impl : ( () ) ;
    public final void rule__Concrete1_Impl__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:983:1: ( ( () ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:984:1: ( () )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:984:1: ( () )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:985:1: ()
            {
             before(grammarAccess.getConcrete1_ImplAccess().getConcrete1Action_0()); 
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:986:1: ()
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:988:1: 
            {
            }

             after(grammarAccess.getConcrete1_ImplAccess().getConcrete1Action_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Concrete1_Impl__Group__0__Impl


    // $ANTLR start rule__Concrete1_Impl__Group__1
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:998:1: rule__Concrete1_Impl__Group__1 : rule__Concrete1_Impl__Group__1__Impl rule__Concrete1_Impl__Group__2 ;
    public final void rule__Concrete1_Impl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1002:1: ( rule__Concrete1_Impl__Group__1__Impl rule__Concrete1_Impl__Group__2 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1003:2: rule__Concrete1_Impl__Group__1__Impl rule__Concrete1_Impl__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Concrete1_Impl__Group__1__Impl_in_rule__Concrete1_Impl__Group__11961);
            rule__Concrete1_Impl__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Concrete1_Impl__Group__2_in_rule__Concrete1_Impl__Group__11964);
            rule__Concrete1_Impl__Group__2();
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
    // $ANTLR end rule__Concrete1_Impl__Group__1


    // $ANTLR start rule__Concrete1_Impl__Group__1__Impl
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1010:1: rule__Concrete1_Impl__Group__1__Impl : ( 'Concrete1' ) ;
    public final void rule__Concrete1_Impl__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1014:1: ( ( 'Concrete1' ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1015:1: ( 'Concrete1' )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1015:1: ( 'Concrete1' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1016:1: 'Concrete1'
            {
             before(grammarAccess.getConcrete1_ImplAccess().getConcrete1Keyword_1()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Concrete1_Impl__Group__1__Impl1992); 
             after(grammarAccess.getConcrete1_ImplAccess().getConcrete1Keyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Concrete1_Impl__Group__1__Impl


    // $ANTLR start rule__Concrete1_Impl__Group__2
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1029:1: rule__Concrete1_Impl__Group__2 : rule__Concrete1_Impl__Group__2__Impl ;
    public final void rule__Concrete1_Impl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1033:1: ( rule__Concrete1_Impl__Group__2__Impl )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1034:2: rule__Concrete1_Impl__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Concrete1_Impl__Group__2__Impl_in_rule__Concrete1_Impl__Group__22023);
            rule__Concrete1_Impl__Group__2__Impl();
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
    // $ANTLR end rule__Concrete1_Impl__Group__2


    // $ANTLR start rule__Concrete1_Impl__Group__2__Impl
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1040:1: rule__Concrete1_Impl__Group__2__Impl : ( ( rule__Concrete1_Impl__NameAssignment_2 ) ) ;
    public final void rule__Concrete1_Impl__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1044:1: ( ( ( rule__Concrete1_Impl__NameAssignment_2 ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1045:1: ( ( rule__Concrete1_Impl__NameAssignment_2 ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1045:1: ( ( rule__Concrete1_Impl__NameAssignment_2 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1046:1: ( rule__Concrete1_Impl__NameAssignment_2 )
            {
             before(grammarAccess.getConcrete1_ImplAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1047:1: ( rule__Concrete1_Impl__NameAssignment_2 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1047:2: rule__Concrete1_Impl__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Concrete1_Impl__NameAssignment_2_in_rule__Concrete1_Impl__Group__2__Impl2050);
            rule__Concrete1_Impl__NameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getConcrete1_ImplAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Concrete1_Impl__Group__2__Impl


    // $ANTLR start rule__DiamondInheritance__Group__0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1063:1: rule__DiamondInheritance__Group__0 : rule__DiamondInheritance__Group__0__Impl rule__DiamondInheritance__Group__1 ;
    public final void rule__DiamondInheritance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1067:1: ( rule__DiamondInheritance__Group__0__Impl rule__DiamondInheritance__Group__1 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1068:2: rule__DiamondInheritance__Group__0__Impl rule__DiamondInheritance__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__DiamondInheritance__Group__0__Impl_in_rule__DiamondInheritance__Group__02086);
            rule__DiamondInheritance__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__DiamondInheritance__Group__1_in_rule__DiamondInheritance__Group__02089);
            rule__DiamondInheritance__Group__1();
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
    // $ANTLR end rule__DiamondInheritance__Group__0


    // $ANTLR start rule__DiamondInheritance__Group__0__Impl
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1075:1: rule__DiamondInheritance__Group__0__Impl : ( () ) ;
    public final void rule__DiamondInheritance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1079:1: ( ( () ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1080:1: ( () )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1080:1: ( () )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1081:1: ()
            {
             before(grammarAccess.getDiamondInheritanceAccess().getDiamondInheritanceAction_0()); 
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1082:1: ()
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1084:1: 
            {
            }

             after(grammarAccess.getDiamondInheritanceAccess().getDiamondInheritanceAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__DiamondInheritance__Group__0__Impl


    // $ANTLR start rule__DiamondInheritance__Group__1
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1094:1: rule__DiamondInheritance__Group__1 : rule__DiamondInheritance__Group__1__Impl rule__DiamondInheritance__Group__2 ;
    public final void rule__DiamondInheritance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1098:1: ( rule__DiamondInheritance__Group__1__Impl rule__DiamondInheritance__Group__2 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1099:2: rule__DiamondInheritance__Group__1__Impl rule__DiamondInheritance__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__DiamondInheritance__Group__1__Impl_in_rule__DiamondInheritance__Group__12147);
            rule__DiamondInheritance__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__DiamondInheritance__Group__2_in_rule__DiamondInheritance__Group__12150);
            rule__DiamondInheritance__Group__2();
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
    // $ANTLR end rule__DiamondInheritance__Group__1


    // $ANTLR start rule__DiamondInheritance__Group__1__Impl
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1106:1: rule__DiamondInheritance__Group__1__Impl : ( 'DiamondInheritance' ) ;
    public final void rule__DiamondInheritance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1110:1: ( ( 'DiamondInheritance' ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1111:1: ( 'DiamondInheritance' )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1111:1: ( 'DiamondInheritance' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1112:1: 'DiamondInheritance'
            {
             before(grammarAccess.getDiamondInheritanceAccess().getDiamondInheritanceKeyword_1()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__DiamondInheritance__Group__1__Impl2178); 
             after(grammarAccess.getDiamondInheritanceAccess().getDiamondInheritanceKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__DiamondInheritance__Group__1__Impl


    // $ANTLR start rule__DiamondInheritance__Group__2
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1125:1: rule__DiamondInheritance__Group__2 : rule__DiamondInheritance__Group__2__Impl ;
    public final void rule__DiamondInheritance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1129:1: ( rule__DiamondInheritance__Group__2__Impl )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1130:2: rule__DiamondInheritance__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__DiamondInheritance__Group__2__Impl_in_rule__DiamondInheritance__Group__22209);
            rule__DiamondInheritance__Group__2__Impl();
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
    // $ANTLR end rule__DiamondInheritance__Group__2


    // $ANTLR start rule__DiamondInheritance__Group__2__Impl
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1136:1: rule__DiamondInheritance__Group__2__Impl : ( ( rule__DiamondInheritance__NameAssignment_2 ) ) ;
    public final void rule__DiamondInheritance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1140:1: ( ( ( rule__DiamondInheritance__NameAssignment_2 ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1141:1: ( ( rule__DiamondInheritance__NameAssignment_2 ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1141:1: ( ( rule__DiamondInheritance__NameAssignment_2 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1142:1: ( rule__DiamondInheritance__NameAssignment_2 )
            {
             before(grammarAccess.getDiamondInheritanceAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1143:1: ( rule__DiamondInheritance__NameAssignment_2 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1143:2: rule__DiamondInheritance__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__DiamondInheritance__NameAssignment_2_in_rule__DiamondInheritance__Group__2__Impl2236);
            rule__DiamondInheritance__NameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getDiamondInheritanceAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__DiamondInheritance__Group__2__Impl


    // $ANTLR start rule__Root__NameAssignment_2
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1160:1: rule__Root__NameAssignment_2 : ( ruleINT0 ) ;
    public final void rule__Root__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1164:1: ( ( ruleINT0 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1165:1: ( ruleINT0 )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1165:1: ( ruleINT0 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1166:1: ruleINT0
            {
             before(grammarAccess.getRootAccess().getNameINT0ParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleINT0_in_rule__Root__NameAssignment_22277);
            ruleINT0();
            _fsp--;

             after(grammarAccess.getRootAccess().getNameINT0ParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Root__NameAssignment_2


    // $ANTLR start rule__Root__ClassesAssignment_4_2
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1175:1: rule__Root__ClassesAssignment_4_2 : ( ruleAbstract ) ;
    public final void rule__Root__ClassesAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1179:1: ( ( ruleAbstract ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1180:1: ( ruleAbstract )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1180:1: ( ruleAbstract )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1181:1: ruleAbstract
            {
             before(grammarAccess.getRootAccess().getClassesAbstractParserRuleCall_4_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstract_in_rule__Root__ClassesAssignment_4_22308);
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1190:1: rule__Root__ClassesAssignment_4_3_1 : ( ruleAbstract ) ;
    public final void rule__Root__ClassesAssignment_4_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1194:1: ( ( ruleAbstract ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1195:1: ( ruleAbstract )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1195:1: ( ruleAbstract )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1196:1: ruleAbstract
            {
             before(grammarAccess.getRootAccess().getClassesAbstractParserRuleCall_4_3_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstract_in_rule__Root__ClassesAssignment_4_3_12339);
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


    // $ANTLR start rule__Root__Concrete0Assignment_5_1
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1205:1: rule__Root__Concrete0Assignment_5_1 : ( ruleConcrete0 ) ;
    public final void rule__Root__Concrete0Assignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1209:1: ( ( ruleConcrete0 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1210:1: ( ruleConcrete0 )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1210:1: ( ruleConcrete0 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1211:1: ruleConcrete0
            {
             before(grammarAccess.getRootAccess().getConcrete0Concrete0ParserRuleCall_5_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleConcrete0_in_rule__Root__Concrete0Assignment_5_12370);
            ruleConcrete0();
            _fsp--;

             after(grammarAccess.getRootAccess().getConcrete0Concrete0ParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Root__Concrete0Assignment_5_1


    // $ANTLR start rule__Concrete0_Impl__NameAssignment_2
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1220:1: rule__Concrete0_Impl__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__Concrete0_Impl__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1224:1: ( ( ruleEString ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1225:1: ( ruleEString )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1225:1: ( ruleEString )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1226:1: ruleEString
            {
             before(grammarAccess.getConcrete0_ImplAccess().getNameEStringParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__Concrete0_Impl__NameAssignment_22401);
            ruleEString();
            _fsp--;

             after(grammarAccess.getConcrete0_ImplAccess().getNameEStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Concrete0_Impl__NameAssignment_2


    // $ANTLR start rule__Concrete1_Impl__NameAssignment_2
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1235:1: rule__Concrete1_Impl__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__Concrete1_Impl__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1239:1: ( ( ruleEString ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1240:1: ( ruleEString )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1240:1: ( ruleEString )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1241:1: ruleEString
            {
             before(grammarAccess.getConcrete1_ImplAccess().getNameEStringParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__Concrete1_Impl__NameAssignment_22432);
            ruleEString();
            _fsp--;

             after(grammarAccess.getConcrete1_ImplAccess().getNameEStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Concrete1_Impl__NameAssignment_2


    // $ANTLR start rule__DiamondInheritance__NameAssignment_2
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1250:1: rule__DiamondInheritance__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__DiamondInheritance__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1254:1: ( ( ruleEString ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1255:1: ( ruleEString )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1255:1: ( ruleEString )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:1256:1: ruleEString
            {
             before(grammarAccess.getDiamondInheritanceAccess().getNameEStringParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__DiamondInheritance__NameAssignment_22463);
            ruleEString();
            _fsp--;

             after(grammarAccess.getDiamondInheritanceAccess().getNameEStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__DiamondInheritance__NameAssignment_2


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRoot68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Group__0_in_ruleRoot94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstract_in_entryRuleAbstract121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstract128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Abstract__Alternatives_in_ruleAbstract154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete0_in_entryRuleConcrete0181 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConcrete0188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Concrete0__Alternatives_in_ruleConcrete0214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleINT0_in_entryRuleINT0241 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleINT0248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleINT0275 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete0_Impl_in_entryRuleConcrete0_Impl303 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConcrete0_Impl310 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Concrete0_Impl__Group__0_in_ruleConcrete0_Impl336 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_entryRuleEString363 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEString370 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EString__Alternatives_in_ruleEString396 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete1_Impl_in_entryRuleConcrete1_Impl423 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConcrete1_Impl430 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Concrete1_Impl__Group__0_in_ruleConcrete1_Impl456 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDiamondInheritance_in_entryRuleDiamondInheritance483 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDiamondInheritance490 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DiamondInheritance__Group__0_in_ruleDiamondInheritance516 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete0_Impl_in_rule__Abstract__Alternatives552 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete1_Impl_in_rule__Abstract__Alternatives569 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDiamondInheritance_in_rule__Abstract__Alternatives586 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete0_Impl_in_rule__Concrete0__Alternatives618 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDiamondInheritance_in_rule__Concrete0__Alternatives635 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__EString__Alternatives667 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EString__Alternatives684 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Group__0__Impl_in_rule__Root__Group__0714 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rule__Root__Group__1_in_rule__Root__Group__0717 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Group__1__Impl_in_rule__Root__Group__1775 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__Root__Group__2_in_rule__Root__Group__1778 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Root__Group__1__Impl806 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Group__2__Impl_in_rule__Root__Group__2837 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__Root__Group__3_in_rule__Root__Group__2840 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__NameAssignment_2_in_rule__Root__Group__2__Impl867 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Group__3__Impl_in_rule__Root__Group__3897 = new BitSet(new long[]{0x000000000002C000L});
        public static final BitSet FOLLOW_rule__Root__Group__4_in_rule__Root__Group__3900 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Root__Group__3__Impl928 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Group__4__Impl_in_rule__Root__Group__4959 = new BitSet(new long[]{0x0000000000024000L});
        public static final BitSet FOLLOW_rule__Root__Group__5_in_rule__Root__Group__4962 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Group_4__0_in_rule__Root__Group__4__Impl989 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Group__5__Impl_in_rule__Root__Group__51020 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__Root__Group__6_in_rule__Root__Group__51023 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Group_5__0_in_rule__Root__Group__5__Impl1050 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Group__6__Impl_in_rule__Root__Group__61081 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Root__Group__6__Impl1109 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Group_4__0__Impl_in_rule__Root__Group_4__01154 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__Root__Group_4__1_in_rule__Root__Group_4__01157 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Root__Group_4__0__Impl1185 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Group_4__1__Impl_in_rule__Root__Group_4__11216 = new BitSet(new long[]{0x00000000001C0000L});
        public static final BitSet FOLLOW_rule__Root__Group_4__2_in_rule__Root__Group_4__11219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Root__Group_4__1__Impl1247 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Group_4__2__Impl_in_rule__Root__Group_4__21278 = new BitSet(new long[]{0x0000000000014000L});
        public static final BitSet FOLLOW_rule__Root__Group_4__3_in_rule__Root__Group_4__21281 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__ClassesAssignment_4_2_in_rule__Root__Group_4__2__Impl1308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Group_4__3__Impl_in_rule__Root__Group_4__31338 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__Root__Group_4__4_in_rule__Root__Group_4__31341 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Group_4_3__0_in_rule__Root__Group_4__3__Impl1368 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_rule__Root__Group_4__4__Impl_in_rule__Root__Group_4__41399 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Root__Group_4__4__Impl1427 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Group_4_3__0__Impl_in_rule__Root__Group_4_3__01468 = new BitSet(new long[]{0x00000000001C0000L});
        public static final BitSet FOLLOW_rule__Root__Group_4_3__1_in_rule__Root__Group_4_3__01471 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Root__Group_4_3__0__Impl1499 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Group_4_3__1__Impl_in_rule__Root__Group_4_3__11530 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__ClassesAssignment_4_3_1_in_rule__Root__Group_4_3__1__Impl1557 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Group_5__0__Impl_in_rule__Root__Group_5__01591 = new BitSet(new long[]{0x0000000000140000L});
        public static final BitSet FOLLOW_rule__Root__Group_5__1_in_rule__Root__Group_5__01594 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Root__Group_5__0__Impl1622 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Group_5__1__Impl_in_rule__Root__Group_5__11653 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Concrete0Assignment_5_1_in_rule__Root__Group_5__1__Impl1680 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Concrete0_Impl__Group__0__Impl_in_rule__Concrete0_Impl__Group__01714 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__Concrete0_Impl__Group__1_in_rule__Concrete0_Impl__Group__01717 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Concrete0_Impl__Group__1__Impl_in_rule__Concrete0_Impl__Group__11775 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__Concrete0_Impl__Group__2_in_rule__Concrete0_Impl__Group__11778 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Concrete0_Impl__Group__1__Impl1806 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Concrete0_Impl__Group__2__Impl_in_rule__Concrete0_Impl__Group__21837 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Concrete0_Impl__NameAssignment_2_in_rule__Concrete0_Impl__Group__2__Impl1864 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Concrete1_Impl__Group__0__Impl_in_rule__Concrete1_Impl__Group__01900 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__Concrete1_Impl__Group__1_in_rule__Concrete1_Impl__Group__01903 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Concrete1_Impl__Group__1__Impl_in_rule__Concrete1_Impl__Group__11961 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__Concrete1_Impl__Group__2_in_rule__Concrete1_Impl__Group__11964 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Concrete1_Impl__Group__1__Impl1992 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Concrete1_Impl__Group__2__Impl_in_rule__Concrete1_Impl__Group__22023 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Concrete1_Impl__NameAssignment_2_in_rule__Concrete1_Impl__Group__2__Impl2050 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DiamondInheritance__Group__0__Impl_in_rule__DiamondInheritance__Group__02086 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__DiamondInheritance__Group__1_in_rule__DiamondInheritance__Group__02089 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DiamondInheritance__Group__1__Impl_in_rule__DiamondInheritance__Group__12147 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__DiamondInheritance__Group__2_in_rule__DiamondInheritance__Group__12150 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__DiamondInheritance__Group__1__Impl2178 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DiamondInheritance__Group__2__Impl_in_rule__DiamondInheritance__Group__22209 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DiamondInheritance__NameAssignment_2_in_rule__DiamondInheritance__Group__2__Impl2236 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleINT0_in_rule__Root__NameAssignment_22277 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstract_in_rule__Root__ClassesAssignment_4_22308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstract_in_rule__Root__ClassesAssignment_4_3_12339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete0_in_rule__Root__Concrete0Assignment_5_12370 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__Concrete0_Impl__NameAssignment_22401 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__Concrete1_Impl__NameAssignment_22432 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__DiamondInheritance__NameAssignment_22463 = new BitSet(new long[]{0x0000000000000002L});
    }


}
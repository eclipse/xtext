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
import org.eclipse.xtext.xtext.ui.ecore2xtext.services.Ecore2XtextTestGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class InternalEcore2XtextTestParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'INT'", "'Root'", "'{'", "'}'", "'classes'", "','", "'Concrete0'", "'Concrete1'", "'DiamondInheritance'"
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
            ruleMemo = new HashMap[52+1];
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
            if ( backtracking==0 ) {
               before(grammarAccess.getRootRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleRoot_in_entryRuleRoot67);
            ruleRoot();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getRootRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRoot74); if (failed) return ;

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
            if ( backtracking==0 ) {
               before(grammarAccess.getRootAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:77:1: ( rule__Root__Group__0 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:77:2: rule__Root__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Root__Group__0_in_ruleRoot100);
            rule__Root__Group__0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getRootAccess().getGroup()); 
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
    // $ANTLR end ruleRoot


    // $ANTLR start entryRuleAbstract
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:89:1: entryRuleAbstract : ruleAbstract EOF ;
    public final void entryRuleAbstract() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:90:1: ( ruleAbstract EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:91:1: ruleAbstract EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAbstractRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAbstract_in_entryRuleAbstract127);
            ruleAbstract();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getAbstractRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstract134); if (failed) return ;

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
            if ( backtracking==0 ) {
               before(grammarAccess.getAbstractAccess().getAlternatives()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:105:1: ( rule__Abstract__Alternatives )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:105:2: rule__Abstract__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Abstract__Alternatives_in_ruleAbstract160);
            rule__Abstract__Alternatives();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getAbstractAccess().getAlternatives()); 
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
    // $ANTLR end ruleAbstract


    // $ANTLR start entryRuleINT0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:117:1: entryRuleINT0 : ruleINT0 EOF ;
    public final void entryRuleINT0() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:118:1: ( ruleINT0 EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:119:1: ruleINT0 EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getINT0Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleINT0_in_entryRuleINT0187);
            ruleINT0();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getINT0Rule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleINT0194); if (failed) return ;

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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:126:1: ruleINT0 : ( 'INT' ) ;
    public final void ruleINT0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:130:2: ( ( 'INT' ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:131:1: ( 'INT' )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:131:1: ( 'INT' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:132:1: 'INT'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getINT0Access().getINTKeyword()); 
            }
            match(input,11,FollowSets000.FOLLOW_11_in_ruleINT0221); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getINT0Access().getINTKeyword()); 
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
    // $ANTLR end ruleINT0


    // $ANTLR start entryRuleEString
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:147:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:148:1: ( ruleEString EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:149:1: ruleEString EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getEStringRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_entryRuleEString249);
            ruleEString();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getEStringRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEString256); if (failed) return ;

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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:156:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:160:2: ( ( ( rule__EString__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:161:1: ( ( rule__EString__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:161:1: ( ( rule__EString__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:162:1: ( rule__EString__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getEStringAccess().getAlternatives()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:163:1: ( rule__EString__Alternatives )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:163:2: rule__EString__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__EString__Alternatives_in_ruleEString282);
            rule__EString__Alternatives();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getEStringAccess().getAlternatives()); 
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
    // $ANTLR end ruleEString


    // $ANTLR start entryRuleConcrete0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:175:1: entryRuleConcrete0 : ruleConcrete0 EOF ;
    public final void entryRuleConcrete0() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:176:1: ( ruleConcrete0 EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:177:1: ruleConcrete0 EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getConcrete0Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleConcrete0_in_entryRuleConcrete0309);
            ruleConcrete0();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getConcrete0Rule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConcrete0316); if (failed) return ;

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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:184:1: ruleConcrete0 : ( ( rule__Concrete0__Alternatives ) ) ;
    public final void ruleConcrete0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:188:2: ( ( ( rule__Concrete0__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:189:1: ( ( rule__Concrete0__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:189:1: ( ( rule__Concrete0__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:190:1: ( rule__Concrete0__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getConcrete0Access().getAlternatives()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:191:1: ( rule__Concrete0__Alternatives )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:191:2: rule__Concrete0__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Concrete0__Alternatives_in_ruleConcrete0342);
            rule__Concrete0__Alternatives();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getConcrete0Access().getAlternatives()); 
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
    // $ANTLR end ruleConcrete0


    // $ANTLR start entryRuleConcrete1
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:203:1: entryRuleConcrete1 : ruleConcrete1 EOF ;
    public final void entryRuleConcrete1() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:204:1: ( ruleConcrete1 EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:205:1: ruleConcrete1 EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getConcrete1Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleConcrete1_in_entryRuleConcrete1369);
            ruleConcrete1();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getConcrete1Rule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConcrete1376); if (failed) return ;

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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:212:1: ruleConcrete1 : ( ( rule__Concrete1__Alternatives ) ) ;
    public final void ruleConcrete1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:216:2: ( ( ( rule__Concrete1__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:217:1: ( ( rule__Concrete1__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:217:1: ( ( rule__Concrete1__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:218:1: ( rule__Concrete1__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getConcrete1Access().getAlternatives()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:219:1: ( rule__Concrete1__Alternatives )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:219:2: rule__Concrete1__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Concrete1__Alternatives_in_ruleConcrete1402);
            rule__Concrete1__Alternatives();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getConcrete1Access().getAlternatives()); 
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
    // $ANTLR end ruleConcrete1


    // $ANTLR start entryRuleDiamondInheritance
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:231:1: entryRuleDiamondInheritance : ruleDiamondInheritance EOF ;
    public final void entryRuleDiamondInheritance() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:232:1: ( ruleDiamondInheritance EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:233:1: ruleDiamondInheritance EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getDiamondInheritanceRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleDiamondInheritance_in_entryRuleDiamondInheritance429);
            ruleDiamondInheritance();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getDiamondInheritanceRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDiamondInheritance436); if (failed) return ;

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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:240:1: ruleDiamondInheritance : ( ( rule__DiamondInheritance__Group__0 ) ) ;
    public final void ruleDiamondInheritance() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:244:2: ( ( ( rule__DiamondInheritance__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:245:1: ( ( rule__DiamondInheritance__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:245:1: ( ( rule__DiamondInheritance__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:246:1: ( rule__DiamondInheritance__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getDiamondInheritanceAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:247:1: ( rule__DiamondInheritance__Group__0 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:247:2: rule__DiamondInheritance__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__DiamondInheritance__Group__0_in_ruleDiamondInheritance462);
            rule__DiamondInheritance__Group__0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getDiamondInheritanceAccess().getGroup()); 
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
    // $ANTLR end ruleDiamondInheritance


    // $ANTLR start rule__Abstract__Alternatives
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:259:1: rule__Abstract__Alternatives : ( ( ruleConcrete0 ) | ( ruleConcrete1 ) );
    public final void rule__Abstract__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:263:1: ( ( ruleConcrete0 ) | ( ruleConcrete1 ) )
            int alt1=2;
            switch ( input.LA(1) ) {
            case 19:
                {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==RULE_STRING) ) {
                    int LA1_4 = input.LA(3);

                    if ( (synpred1()) ) {
                        alt1=1;
                    }
                    else if ( (true) ) {
                        alt1=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("259:1: rule__Abstract__Alternatives : ( ( ruleConcrete0 ) | ( ruleConcrete1 ) );", 1, 4, input);

                        throw nvae;
                    }
                }
                else if ( (LA1_1==RULE_ID) ) {
                    int LA1_5 = input.LA(3);

                    if ( (synpred1()) ) {
                        alt1=1;
                    }
                    else if ( (true) ) {
                        alt1=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("259:1: rule__Abstract__Alternatives : ( ( ruleConcrete0 ) | ( ruleConcrete1 ) );", 1, 5, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("259:1: rule__Abstract__Alternatives : ( ( ruleConcrete0 ) | ( ruleConcrete1 ) );", 1, 1, input);

                    throw nvae;
                }
                }
                break;
            case 17:
                {
                alt1=1;
                }
                break;
            case 18:
                {
                alt1=2;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("259:1: rule__Abstract__Alternatives : ( ( ruleConcrete0 ) | ( ruleConcrete1 ) );", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:264:1: ( ruleConcrete0 )
                    {
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:264:1: ( ruleConcrete0 )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:265:1: ruleConcrete0
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getAbstractAccess().getConcrete0ParserRuleCall_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConcrete0_in_rule__Abstract__Alternatives498);
                    ruleConcrete0();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getAbstractAccess().getConcrete0ParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:270:6: ( ruleConcrete1 )
                    {
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:270:6: ( ruleConcrete1 )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:271:1: ruleConcrete1
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getAbstractAccess().getConcrete1ParserRuleCall_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConcrete1_in_rule__Abstract__Alternatives515);
                    ruleConcrete1();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getAbstractAccess().getConcrete1ParserRuleCall_1()); 
                    }

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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:281:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:285:1: ( ( RULE_STRING ) | ( RULE_ID ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_STRING) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_ID) ) {
                alt2=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("281:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:286:1: ( RULE_STRING )
                    {
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:286:1: ( RULE_STRING )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:287:1: RULE_STRING
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    }
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__EString__Alternatives547); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:292:6: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:292:6: ( RULE_ID )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:293:1: RULE_ID
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    }
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EString__Alternatives564); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    }

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


    // $ANTLR start rule__Concrete0__Alternatives
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:303:1: rule__Concrete0__Alternatives : ( ( ruleDiamondInheritance ) | ( ( rule__Concrete0__Group_1__0 ) ) );
    public final void rule__Concrete0__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:307:1: ( ( ruleDiamondInheritance ) | ( ( rule__Concrete0__Group_1__0 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==19) ) {
                alt3=1;
            }
            else if ( (LA3_0==17) ) {
                alt3=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("303:1: rule__Concrete0__Alternatives : ( ( ruleDiamondInheritance ) | ( ( rule__Concrete0__Group_1__0 ) ) );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:308:1: ( ruleDiamondInheritance )
                    {
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:308:1: ( ruleDiamondInheritance )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:309:1: ruleDiamondInheritance
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getConcrete0Access().getDiamondInheritanceParserRuleCall_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleDiamondInheritance_in_rule__Concrete0__Alternatives596);
                    ruleDiamondInheritance();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getConcrete0Access().getDiamondInheritanceParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:314:6: ( ( rule__Concrete0__Group_1__0 ) )
                    {
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:314:6: ( ( rule__Concrete0__Group_1__0 ) )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:315:1: ( rule__Concrete0__Group_1__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getConcrete0Access().getGroup_1()); 
                    }
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:316:1: ( rule__Concrete0__Group_1__0 )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:316:2: rule__Concrete0__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Concrete0__Group_1__0_in_rule__Concrete0__Alternatives613);
                    rule__Concrete0__Group_1__0();
                    _fsp--;
                    if (failed) return ;

                    }

                    if ( backtracking==0 ) {
                       after(grammarAccess.getConcrete0Access().getGroup_1()); 
                    }

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


    // $ANTLR start rule__Concrete1__Alternatives
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:325:1: rule__Concrete1__Alternatives : ( ( ruleDiamondInheritance ) | ( ( rule__Concrete1__Group_1__0 ) ) );
    public final void rule__Concrete1__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:329:1: ( ( ruleDiamondInheritance ) | ( ( rule__Concrete1__Group_1__0 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==19) ) {
                alt4=1;
            }
            else if ( (LA4_0==18) ) {
                alt4=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("325:1: rule__Concrete1__Alternatives : ( ( ruleDiamondInheritance ) | ( ( rule__Concrete1__Group_1__0 ) ) );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:330:1: ( ruleDiamondInheritance )
                    {
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:330:1: ( ruleDiamondInheritance )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:331:1: ruleDiamondInheritance
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getConcrete1Access().getDiamondInheritanceParserRuleCall_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleDiamondInheritance_in_rule__Concrete1__Alternatives646);
                    ruleDiamondInheritance();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getConcrete1Access().getDiamondInheritanceParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:336:6: ( ( rule__Concrete1__Group_1__0 ) )
                    {
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:336:6: ( ( rule__Concrete1__Group_1__0 ) )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:337:1: ( rule__Concrete1__Group_1__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getConcrete1Access().getGroup_1()); 
                    }
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:338:1: ( rule__Concrete1__Group_1__0 )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:338:2: rule__Concrete1__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Concrete1__Group_1__0_in_rule__Concrete1__Alternatives663);
                    rule__Concrete1__Group_1__0();
                    _fsp--;
                    if (failed) return ;

                    }

                    if ( backtracking==0 ) {
                       after(grammarAccess.getConcrete1Access().getGroup_1()); 
                    }

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
    // $ANTLR end rule__Concrete1__Alternatives


    // $ANTLR start rule__Root__Group__0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:349:1: rule__Root__Group__0 : ( () ) rule__Root__Group__1 ;
    public final void rule__Root__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:353:1: ( ( () ) rule__Root__Group__1 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:354:1: ( () ) rule__Root__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:354:1: ( () )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:355:1: ()
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRootAccess().getRootAction_0()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:356:1: ()
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:358:1: 
            {
            }

            if ( backtracking==0 ) {
               after(grammarAccess.getRootAccess().getRootAction_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group__1_in_rule__Root__Group__0708);
            rule__Root__Group__1();
            _fsp--;
            if (failed) return ;

            }

        }
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:369:1: rule__Root__Group__1 : ( 'Root' ) rule__Root__Group__2 ;
    public final void rule__Root__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:373:1: ( ( 'Root' ) rule__Root__Group__2 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:374:1: ( 'Root' ) rule__Root__Group__2
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:374:1: ( 'Root' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:375:1: 'Root'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRootAccess().getRootKeyword_1()); 
            }
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Root__Group__1737); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getRootAccess().getRootKeyword_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group__2_in_rule__Root__Group__1747);
            rule__Root__Group__2();
            _fsp--;
            if (failed) return ;

            }

        }
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:389:1: rule__Root__Group__2 : ( ( rule__Root__NameAssignment_2 ) ) rule__Root__Group__3 ;
    public final void rule__Root__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:393:1: ( ( ( rule__Root__NameAssignment_2 ) ) rule__Root__Group__3 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:394:1: ( ( rule__Root__NameAssignment_2 ) ) rule__Root__Group__3
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:394:1: ( ( rule__Root__NameAssignment_2 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:395:1: ( rule__Root__NameAssignment_2 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRootAccess().getNameAssignment_2()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:396:1: ( rule__Root__NameAssignment_2 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:396:2: rule__Root__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Root__NameAssignment_2_in_rule__Root__Group__2775);
            rule__Root__NameAssignment_2();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getRootAccess().getNameAssignment_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group__3_in_rule__Root__Group__2784);
            rule__Root__Group__3();
            _fsp--;
            if (failed) return ;

            }

        }
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:407:1: rule__Root__Group__3 : ( '{' ) rule__Root__Group__4 ;
    public final void rule__Root__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:411:1: ( ( '{' ) rule__Root__Group__4 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:412:1: ( '{' ) rule__Root__Group__4
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:412:1: ( '{' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:413:1: '{'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRootAccess().getLeftCurlyBracketKeyword_3()); 
            }
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Root__Group__3813); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getRootAccess().getLeftCurlyBracketKeyword_3()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group__4_in_rule__Root__Group__3823);
            rule__Root__Group__4();
            _fsp--;
            if (failed) return ;

            }

        }
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:427:1: rule__Root__Group__4 : ( ( rule__Root__Group_4__0 )? ) rule__Root__Group__5 ;
    public final void rule__Root__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:431:1: ( ( ( rule__Root__Group_4__0 )? ) rule__Root__Group__5 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:432:1: ( ( rule__Root__Group_4__0 )? ) rule__Root__Group__5
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:432:1: ( ( rule__Root__Group_4__0 )? )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:433:1: ( rule__Root__Group_4__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRootAccess().getGroup_4()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:434:1: ( rule__Root__Group_4__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:434:2: rule__Root__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Root__Group_4__0_in_rule__Root__Group__4851);
                    rule__Root__Group_4__0();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getRootAccess().getGroup_4()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group__5_in_rule__Root__Group__4861);
            rule__Root__Group__5();
            _fsp--;
            if (failed) return ;

            }

        }
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:445:1: rule__Root__Group__5 : ( '}' ) ;
    public final void rule__Root__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:449:1: ( ( '}' ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:450:1: ( '}' )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:450:1: ( '}' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:451:1: '}'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRootAccess().getRightCurlyBracketKeyword_5()); 
            }
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Root__Group__5890); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getRootAccess().getRightCurlyBracketKeyword_5()); 
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
    // $ANTLR end rule__Root__Group__5


    // $ANTLR start rule__Root__Group_4__0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:476:1: rule__Root__Group_4__0 : ( 'classes' ) rule__Root__Group_4__1 ;
    public final void rule__Root__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:480:1: ( ( 'classes' ) rule__Root__Group_4__1 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:481:1: ( 'classes' ) rule__Root__Group_4__1
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:481:1: ( 'classes' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:482:1: 'classes'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRootAccess().getClassesKeyword_4_0()); 
            }
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Root__Group_4__0938); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getRootAccess().getClassesKeyword_4_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group_4__1_in_rule__Root__Group_4__0948);
            rule__Root__Group_4__1();
            _fsp--;
            if (failed) return ;

            }

        }
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:496:1: rule__Root__Group_4__1 : ( '{' ) rule__Root__Group_4__2 ;
    public final void rule__Root__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:500:1: ( ( '{' ) rule__Root__Group_4__2 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:501:1: ( '{' ) rule__Root__Group_4__2
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:501:1: ( '{' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:502:1: '{'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRootAccess().getLeftCurlyBracketKeyword_4_1()); 
            }
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Root__Group_4__1977); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getRootAccess().getLeftCurlyBracketKeyword_4_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group_4__2_in_rule__Root__Group_4__1987);
            rule__Root__Group_4__2();
            _fsp--;
            if (failed) return ;

            }

        }
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:516:1: rule__Root__Group_4__2 : ( ( rule__Root__ClassesAssignment_4_2 ) ) rule__Root__Group_4__3 ;
    public final void rule__Root__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:520:1: ( ( ( rule__Root__ClassesAssignment_4_2 ) ) rule__Root__Group_4__3 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:521:1: ( ( rule__Root__ClassesAssignment_4_2 ) ) rule__Root__Group_4__3
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:521:1: ( ( rule__Root__ClassesAssignment_4_2 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:522:1: ( rule__Root__ClassesAssignment_4_2 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRootAccess().getClassesAssignment_4_2()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:523:1: ( rule__Root__ClassesAssignment_4_2 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:523:2: rule__Root__ClassesAssignment_4_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Root__ClassesAssignment_4_2_in_rule__Root__Group_4__21015);
            rule__Root__ClassesAssignment_4_2();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getRootAccess().getClassesAssignment_4_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group_4__3_in_rule__Root__Group_4__21024);
            rule__Root__Group_4__3();
            _fsp--;
            if (failed) return ;

            }

        }
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:534:1: rule__Root__Group_4__3 : ( ( rule__Root__Group_4_3__0 )* ) rule__Root__Group_4__4 ;
    public final void rule__Root__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:538:1: ( ( ( rule__Root__Group_4_3__0 )* ) rule__Root__Group_4__4 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:539:1: ( ( rule__Root__Group_4_3__0 )* ) rule__Root__Group_4__4
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:539:1: ( ( rule__Root__Group_4_3__0 )* )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:540:1: ( rule__Root__Group_4_3__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRootAccess().getGroup_4_3()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:541:1: ( rule__Root__Group_4_3__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==16) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:541:2: rule__Root__Group_4_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Root__Group_4_3__0_in_rule__Root__Group_4__31052);
            	    rule__Root__Group_4_3__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getRootAccess().getGroup_4_3()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group_4__4_in_rule__Root__Group_4__31062);
            rule__Root__Group_4__4();
            _fsp--;
            if (failed) return ;

            }

        }
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:552:1: rule__Root__Group_4__4 : ( '}' ) ;
    public final void rule__Root__Group_4__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:556:1: ( ( '}' ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:557:1: ( '}' )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:557:1: ( '}' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:558:1: '}'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRootAccess().getRightCurlyBracketKeyword_4_4()); 
            }
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Root__Group_4__41091); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getRootAccess().getRightCurlyBracketKeyword_4_4()); 
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
    // $ANTLR end rule__Root__Group_4__4


    // $ANTLR start rule__Root__Group_4_3__0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:581:1: rule__Root__Group_4_3__0 : ( ',' ) rule__Root__Group_4_3__1 ;
    public final void rule__Root__Group_4_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:585:1: ( ( ',' ) rule__Root__Group_4_3__1 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:586:1: ( ',' ) rule__Root__Group_4_3__1
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:586:1: ( ',' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:587:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRootAccess().getCommaKeyword_4_3_0()); 
            }
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Root__Group_4_3__01137); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getRootAccess().getCommaKeyword_4_3_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group_4_3__1_in_rule__Root__Group_4_3__01147);
            rule__Root__Group_4_3__1();
            _fsp--;
            if (failed) return ;

            }

        }
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:601:1: rule__Root__Group_4_3__1 : ( ( rule__Root__ClassesAssignment_4_3_1 ) ) ;
    public final void rule__Root__Group_4_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:605:1: ( ( ( rule__Root__ClassesAssignment_4_3_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:606:1: ( ( rule__Root__ClassesAssignment_4_3_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:606:1: ( ( rule__Root__ClassesAssignment_4_3_1 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:607:1: ( rule__Root__ClassesAssignment_4_3_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRootAccess().getClassesAssignment_4_3_1()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:608:1: ( rule__Root__ClassesAssignment_4_3_1 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:608:2: rule__Root__ClassesAssignment_4_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Root__ClassesAssignment_4_3_1_in_rule__Root__Group_4_3__11175);
            rule__Root__ClassesAssignment_4_3_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getRootAccess().getClassesAssignment_4_3_1()); 
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
    // $ANTLR end rule__Root__Group_4_3__1


    // $ANTLR start rule__Concrete0__Group_1__0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:622:1: rule__Concrete0__Group_1__0 : ( () ) rule__Concrete0__Group_1__1 ;
    public final void rule__Concrete0__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:626:1: ( ( () ) rule__Concrete0__Group_1__1 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:627:1: ( () ) rule__Concrete0__Group_1__1
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:627:1: ( () )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:628:1: ()
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getConcrete0Access().getConcrete0Action_1_0()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:629:1: ()
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:631:1: 
            {
            }

            if ( backtracking==0 ) {
               after(grammarAccess.getConcrete0Access().getConcrete0Action_1_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Concrete0__Group_1__1_in_rule__Concrete0__Group_1__01223);
            rule__Concrete0__Group_1__1();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Concrete0__Group_1__0


    // $ANTLR start rule__Concrete0__Group_1__1
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:642:1: rule__Concrete0__Group_1__1 : ( 'Concrete0' ) rule__Concrete0__Group_1__2 ;
    public final void rule__Concrete0__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:646:1: ( ( 'Concrete0' ) rule__Concrete0__Group_1__2 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:647:1: ( 'Concrete0' ) rule__Concrete0__Group_1__2
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:647:1: ( 'Concrete0' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:648:1: 'Concrete0'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getConcrete0Access().getConcrete0Keyword_1_1()); 
            }
            match(input,17,FollowSets000.FOLLOW_17_in_rule__Concrete0__Group_1__11252); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getConcrete0Access().getConcrete0Keyword_1_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Concrete0__Group_1__2_in_rule__Concrete0__Group_1__11262);
            rule__Concrete0__Group_1__2();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Concrete0__Group_1__1


    // $ANTLR start rule__Concrete0__Group_1__2
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:662:1: rule__Concrete0__Group_1__2 : ( ( rule__Concrete0__NameAssignment_1_2 ) ) ;
    public final void rule__Concrete0__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:666:1: ( ( ( rule__Concrete0__NameAssignment_1_2 ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:667:1: ( ( rule__Concrete0__NameAssignment_1_2 ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:667:1: ( ( rule__Concrete0__NameAssignment_1_2 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:668:1: ( rule__Concrete0__NameAssignment_1_2 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getConcrete0Access().getNameAssignment_1_2()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:669:1: ( rule__Concrete0__NameAssignment_1_2 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:669:2: rule__Concrete0__NameAssignment_1_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Concrete0__NameAssignment_1_2_in_rule__Concrete0__Group_1__21290);
            rule__Concrete0__NameAssignment_1_2();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getConcrete0Access().getNameAssignment_1_2()); 
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
    // $ANTLR end rule__Concrete0__Group_1__2


    // $ANTLR start rule__Concrete1__Group_1__0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:685:1: rule__Concrete1__Group_1__0 : ( () ) rule__Concrete1__Group_1__1 ;
    public final void rule__Concrete1__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:689:1: ( ( () ) rule__Concrete1__Group_1__1 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:690:1: ( () ) rule__Concrete1__Group_1__1
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:690:1: ( () )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:691:1: ()
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getConcrete1Access().getConcrete1Action_1_0()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:692:1: ()
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:694:1: 
            {
            }

            if ( backtracking==0 ) {
               after(grammarAccess.getConcrete1Access().getConcrete1Action_1_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Concrete1__Group_1__1_in_rule__Concrete1__Group_1__01340);
            rule__Concrete1__Group_1__1();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Concrete1__Group_1__0


    // $ANTLR start rule__Concrete1__Group_1__1
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:705:1: rule__Concrete1__Group_1__1 : ( 'Concrete1' ) rule__Concrete1__Group_1__2 ;
    public final void rule__Concrete1__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:709:1: ( ( 'Concrete1' ) rule__Concrete1__Group_1__2 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:710:1: ( 'Concrete1' ) rule__Concrete1__Group_1__2
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:710:1: ( 'Concrete1' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:711:1: 'Concrete1'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getConcrete1Access().getConcrete1Keyword_1_1()); 
            }
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Concrete1__Group_1__11369); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getConcrete1Access().getConcrete1Keyword_1_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Concrete1__Group_1__2_in_rule__Concrete1__Group_1__11379);
            rule__Concrete1__Group_1__2();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Concrete1__Group_1__1


    // $ANTLR start rule__Concrete1__Group_1__2
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:725:1: rule__Concrete1__Group_1__2 : ( ( rule__Concrete1__NameAssignment_1_2 ) ) ;
    public final void rule__Concrete1__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:729:1: ( ( ( rule__Concrete1__NameAssignment_1_2 ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:730:1: ( ( rule__Concrete1__NameAssignment_1_2 ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:730:1: ( ( rule__Concrete1__NameAssignment_1_2 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:731:1: ( rule__Concrete1__NameAssignment_1_2 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getConcrete1Access().getNameAssignment_1_2()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:732:1: ( rule__Concrete1__NameAssignment_1_2 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:732:2: rule__Concrete1__NameAssignment_1_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Concrete1__NameAssignment_1_2_in_rule__Concrete1__Group_1__21407);
            rule__Concrete1__NameAssignment_1_2();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getConcrete1Access().getNameAssignment_1_2()); 
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
    // $ANTLR end rule__Concrete1__Group_1__2


    // $ANTLR start rule__DiamondInheritance__Group__0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:748:1: rule__DiamondInheritance__Group__0 : ( () ) rule__DiamondInheritance__Group__1 ;
    public final void rule__DiamondInheritance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:752:1: ( ( () ) rule__DiamondInheritance__Group__1 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:753:1: ( () ) rule__DiamondInheritance__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:753:1: ( () )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:754:1: ()
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getDiamondInheritanceAccess().getDiamondInheritanceAction_0()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:755:1: ()
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:757:1: 
            {
            }

            if ( backtracking==0 ) {
               after(grammarAccess.getDiamondInheritanceAccess().getDiamondInheritanceAction_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__DiamondInheritance__Group__1_in_rule__DiamondInheritance__Group__01457);
            rule__DiamondInheritance__Group__1();
            _fsp--;
            if (failed) return ;

            }

        }
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


    // $ANTLR start rule__DiamondInheritance__Group__1
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:768:1: rule__DiamondInheritance__Group__1 : ( 'DiamondInheritance' ) rule__DiamondInheritance__Group__2 ;
    public final void rule__DiamondInheritance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:772:1: ( ( 'DiamondInheritance' ) rule__DiamondInheritance__Group__2 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:773:1: ( 'DiamondInheritance' ) rule__DiamondInheritance__Group__2
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:773:1: ( 'DiamondInheritance' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:774:1: 'DiamondInheritance'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getDiamondInheritanceAccess().getDiamondInheritanceKeyword_1()); 
            }
            match(input,19,FollowSets000.FOLLOW_19_in_rule__DiamondInheritance__Group__11486); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getDiamondInheritanceAccess().getDiamondInheritanceKeyword_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__DiamondInheritance__Group__2_in_rule__DiamondInheritance__Group__11496);
            rule__DiamondInheritance__Group__2();
            _fsp--;
            if (failed) return ;

            }

        }
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


    // $ANTLR start rule__DiamondInheritance__Group__2
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:788:1: rule__DiamondInheritance__Group__2 : ( ( rule__DiamondInheritance__NameAssignment_2 ) ) ;
    public final void rule__DiamondInheritance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:792:1: ( ( ( rule__DiamondInheritance__NameAssignment_2 ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:793:1: ( ( rule__DiamondInheritance__NameAssignment_2 ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:793:1: ( ( rule__DiamondInheritance__NameAssignment_2 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:794:1: ( rule__DiamondInheritance__NameAssignment_2 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getDiamondInheritanceAccess().getNameAssignment_2()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:795:1: ( rule__DiamondInheritance__NameAssignment_2 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:795:2: rule__DiamondInheritance__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__DiamondInheritance__NameAssignment_2_in_rule__DiamondInheritance__Group__21524);
            rule__DiamondInheritance__NameAssignment_2();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getDiamondInheritanceAccess().getNameAssignment_2()); 
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
    // $ANTLR end rule__DiamondInheritance__Group__2


    // $ANTLR start rule__Root__NameAssignment_2
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:812:1: rule__Root__NameAssignment_2 : ( ruleINT0 ) ;
    public final void rule__Root__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:816:1: ( ( ruleINT0 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:817:1: ( ruleINT0 )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:817:1: ( ruleINT0 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:818:1: ruleINT0
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRootAccess().getNameINT0ParserRuleCall_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleINT0_in_rule__Root__NameAssignment_21565);
            ruleINT0();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getRootAccess().getNameINT0ParserRuleCall_2_0()); 
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
    // $ANTLR end rule__Root__NameAssignment_2


    // $ANTLR start rule__Root__ClassesAssignment_4_2
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:827:1: rule__Root__ClassesAssignment_4_2 : ( ruleAbstract ) ;
    public final void rule__Root__ClassesAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:831:1: ( ( ruleAbstract ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:832:1: ( ruleAbstract )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:832:1: ( ruleAbstract )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:833:1: ruleAbstract
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRootAccess().getClassesAbstractParserRuleCall_4_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAbstract_in_rule__Root__ClassesAssignment_4_21596);
            ruleAbstract();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getRootAccess().getClassesAbstractParserRuleCall_4_2_0()); 
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
    // $ANTLR end rule__Root__ClassesAssignment_4_2


    // $ANTLR start rule__Root__ClassesAssignment_4_3_1
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:842:1: rule__Root__ClassesAssignment_4_3_1 : ( ruleAbstract ) ;
    public final void rule__Root__ClassesAssignment_4_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:846:1: ( ( ruleAbstract ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:847:1: ( ruleAbstract )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:847:1: ( ruleAbstract )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:848:1: ruleAbstract
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRootAccess().getClassesAbstractParserRuleCall_4_3_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAbstract_in_rule__Root__ClassesAssignment_4_3_11627);
            ruleAbstract();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getRootAccess().getClassesAbstractParserRuleCall_4_3_1_0()); 
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
    // $ANTLR end rule__Root__ClassesAssignment_4_3_1


    // $ANTLR start rule__Concrete0__NameAssignment_1_2
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:857:1: rule__Concrete0__NameAssignment_1_2 : ( ruleEString ) ;
    public final void rule__Concrete0__NameAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:861:1: ( ( ruleEString ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:862:1: ( ruleEString )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:862:1: ( ruleEString )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:863:1: ruleEString
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getConcrete0Access().getNameEStringParserRuleCall_1_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__Concrete0__NameAssignment_1_21658);
            ruleEString();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getConcrete0Access().getNameEStringParserRuleCall_1_2_0()); 
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
    // $ANTLR end rule__Concrete0__NameAssignment_1_2


    // $ANTLR start rule__Concrete1__NameAssignment_1_2
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:872:1: rule__Concrete1__NameAssignment_1_2 : ( ruleEString ) ;
    public final void rule__Concrete1__NameAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:876:1: ( ( ruleEString ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:877:1: ( ruleEString )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:877:1: ( ruleEString )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:878:1: ruleEString
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getConcrete1Access().getNameEStringParserRuleCall_1_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__Concrete1__NameAssignment_1_21689);
            ruleEString();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getConcrete1Access().getNameEStringParserRuleCall_1_2_0()); 
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
    // $ANTLR end rule__Concrete1__NameAssignment_1_2


    // $ANTLR start rule__DiamondInheritance__NameAssignment_2
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:887:1: rule__DiamondInheritance__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__DiamondInheritance__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:891:1: ( ( ruleEString ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:892:1: ( ruleEString )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:892:1: ( ruleEString )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:893:1: ruleEString
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getDiamondInheritanceAccess().getNameEStringParserRuleCall_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__DiamondInheritance__NameAssignment_21720);
            ruleEString();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getDiamondInheritanceAccess().getNameEStringParserRuleCall_2_0()); 
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
    // $ANTLR end rule__DiamondInheritance__NameAssignment_2

    // $ANTLR start synpred1
    public final void synpred1_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:264:1: ( ( ruleConcrete0 ) )
        // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:264:1: ( ruleConcrete0 )
        {
        // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:264:1: ( ruleConcrete0 )
        // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:265:1: ruleConcrete0
        {
        if ( backtracking==0 ) {
           before(grammarAccess.getAbstractAccess().getConcrete0ParserRuleCall_0()); 
        }
        pushFollow(FollowSets000.FOLLOW_ruleConcrete0_in_synpred1498);
        ruleConcrete0();
        _fsp--;
        if (failed) return ;

        }


        }
    }
    // $ANTLR end synpred1

    public final boolean synpred1() {
        backtracking++;
        int start = input.mark();
        try {
            synpred1_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot67 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRoot74 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Group__0_in_ruleRoot100 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstract_in_entryRuleAbstract127 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstract134 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Abstract__Alternatives_in_ruleAbstract160 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleINT0_in_entryRuleINT0187 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleINT0194 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleINT0221 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_entryRuleEString249 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEString256 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EString__Alternatives_in_ruleEString282 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete0_in_entryRuleConcrete0309 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConcrete0316 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Concrete0__Alternatives_in_ruleConcrete0342 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete1_in_entryRuleConcrete1369 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConcrete1376 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Concrete1__Alternatives_in_ruleConcrete1402 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDiamondInheritance_in_entryRuleDiamondInheritance429 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDiamondInheritance436 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DiamondInheritance__Group__0_in_ruleDiamondInheritance462 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete0_in_rule__Abstract__Alternatives498 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete1_in_rule__Abstract__Alternatives515 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__EString__Alternatives547 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EString__Alternatives564 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDiamondInheritance_in_rule__Concrete0__Alternatives596 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Concrete0__Group_1__0_in_rule__Concrete0__Alternatives613 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDiamondInheritance_in_rule__Concrete1__Alternatives646 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Concrete1__Group_1__0_in_rule__Concrete1__Alternatives663 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Group__1_in_rule__Root__Group__0708 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Root__Group__1737 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__Root__Group__2_in_rule__Root__Group__1747 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__NameAssignment_2_in_rule__Root__Group__2775 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__Root__Group__3_in_rule__Root__Group__2784 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Root__Group__3813 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_rule__Root__Group__4_in_rule__Root__Group__3823 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Group_4__0_in_rule__Root__Group__4851 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__Root__Group__5_in_rule__Root__Group__4861 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Root__Group__5890 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Root__Group_4__0938 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__Root__Group_4__1_in_rule__Root__Group_4__0948 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Root__Group_4__1977 = new BitSet(new long[]{0x00000000000E0000L});
        public static final BitSet FOLLOW_rule__Root__Group_4__2_in_rule__Root__Group_4__1987 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__ClassesAssignment_4_2_in_rule__Root__Group_4__21015 = new BitSet(new long[]{0x0000000000014000L});
        public static final BitSet FOLLOW_rule__Root__Group_4__3_in_rule__Root__Group_4__21024 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Group_4_3__0_in_rule__Root__Group_4__31052 = new BitSet(new long[]{0x0000000000014000L});
        public static final BitSet FOLLOW_rule__Root__Group_4__4_in_rule__Root__Group_4__31062 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Root__Group_4__41091 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Root__Group_4_3__01137 = new BitSet(new long[]{0x00000000000E0000L});
        public static final BitSet FOLLOW_rule__Root__Group_4_3__1_in_rule__Root__Group_4_3__01147 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__ClassesAssignment_4_3_1_in_rule__Root__Group_4_3__11175 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Concrete0__Group_1__1_in_rule__Concrete0__Group_1__01223 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Concrete0__Group_1__11252 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__Concrete0__Group_1__2_in_rule__Concrete0__Group_1__11262 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Concrete0__NameAssignment_1_2_in_rule__Concrete0__Group_1__21290 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Concrete1__Group_1__1_in_rule__Concrete1__Group_1__01340 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Concrete1__Group_1__11369 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__Concrete1__Group_1__2_in_rule__Concrete1__Group_1__11379 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Concrete1__NameAssignment_1_2_in_rule__Concrete1__Group_1__21407 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DiamondInheritance__Group__1_in_rule__DiamondInheritance__Group__01457 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__DiamondInheritance__Group__11486 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__DiamondInheritance__Group__2_in_rule__DiamondInheritance__Group__11496 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DiamondInheritance__NameAssignment_2_in_rule__DiamondInheritance__Group__21524 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleINT0_in_rule__Root__NameAssignment_21565 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstract_in_rule__Root__ClassesAssignment_4_21596 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstract_in_rule__Root__ClassesAssignment_4_3_11627 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__Concrete0__NameAssignment_1_21658 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__Concrete1__NameAssignment_1_21689 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__DiamondInheritance__NameAssignment_21720 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete0_in_synpred1498 = new BitSet(new long[]{0x0000000000000002L});
    }


}
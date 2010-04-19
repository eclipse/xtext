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
import java.util.Map;
import java.util.HashMap;
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
            ruleMemo = new HashMap[58+1];
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:62:1: entryRuleRoot : ruleRoot EOF ;
    public final void entryRuleRoot() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:63:1: ( ruleRoot EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:64:1: ruleRoot EOF
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:71:1: ruleRoot : ( ( rule__Root__Group__0 ) ) ;
    public final void ruleRoot() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:75:2: ( ( ( rule__Root__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:76:1: ( ( rule__Root__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:76:1: ( ( rule__Root__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:77:1: ( rule__Root__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRootAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:78:1: ( rule__Root__Group__0 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:78:2: rule__Root__Group__0
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:90:1: entryRuleAbstract : ruleAbstract EOF ;
    public final void entryRuleAbstract() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:91:1: ( ruleAbstract EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:92:1: ruleAbstract EOF
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:99:1: ruleAbstract : ( ( rule__Abstract__Alternatives ) ) ;
    public final void ruleAbstract() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:103:2: ( ( ( rule__Abstract__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:104:1: ( ( rule__Abstract__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:104:1: ( ( rule__Abstract__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:105:1: ( rule__Abstract__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAbstractAccess().getAlternatives()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:106:1: ( rule__Abstract__Alternatives )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:106:2: rule__Abstract__Alternatives
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


    // $ANTLR start entryRuleConcrete0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:118:1: entryRuleConcrete0 : ruleConcrete0 EOF ;
    public final void entryRuleConcrete0() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:119:1: ( ruleConcrete0 EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:120:1: ruleConcrete0 EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getConcrete0Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleConcrete0_in_entryRuleConcrete0187);
            ruleConcrete0();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getConcrete0Rule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConcrete0194); if (failed) return ;

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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:127:1: ruleConcrete0 : ( ( rule__Concrete0__Alternatives ) ) ;
    public final void ruleConcrete0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:131:2: ( ( ( rule__Concrete0__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:132:1: ( ( rule__Concrete0__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:132:1: ( ( rule__Concrete0__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:133:1: ( rule__Concrete0__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getConcrete0Access().getAlternatives()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:134:1: ( rule__Concrete0__Alternatives )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:134:2: rule__Concrete0__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Concrete0__Alternatives_in_ruleConcrete0220);
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


    // $ANTLR start entryRuleINT0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:146:1: entryRuleINT0 : ruleINT0 EOF ;
    public final void entryRuleINT0() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:147:1: ( ruleINT0 EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:148:1: ruleINT0 EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getINT0Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleINT0_in_entryRuleINT0247);
            ruleINT0();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getINT0Rule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleINT0254); if (failed) return ;

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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:155:1: ruleINT0 : ( 'INT' ) ;
    public final void ruleINT0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:159:2: ( ( 'INT' ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:160:1: ( 'INT' )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:160:1: ( 'INT' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:161:1: 'INT'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getINT0Access().getINTKeyword()); 
            }
            match(input,11,FollowSets000.FOLLOW_11_in_ruleINT0281); if (failed) return ;
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


    // $ANTLR start entryRuleConcrete0_Impl
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:176:1: entryRuleConcrete0_Impl : ruleConcrete0_Impl EOF ;
    public final void entryRuleConcrete0_Impl() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:177:1: ( ruleConcrete0_Impl EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:178:1: ruleConcrete0_Impl EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getConcrete0_ImplRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleConcrete0_Impl_in_entryRuleConcrete0_Impl309);
            ruleConcrete0_Impl();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getConcrete0_ImplRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConcrete0_Impl316); if (failed) return ;

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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:185:1: ruleConcrete0_Impl : ( ( rule__Concrete0_Impl__Group__0 ) ) ;
    public final void ruleConcrete0_Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:189:2: ( ( ( rule__Concrete0_Impl__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:190:1: ( ( rule__Concrete0_Impl__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:190:1: ( ( rule__Concrete0_Impl__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:191:1: ( rule__Concrete0_Impl__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getConcrete0_ImplAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:192:1: ( rule__Concrete0_Impl__Group__0 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:192:2: rule__Concrete0_Impl__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Concrete0_Impl__Group__0_in_ruleConcrete0_Impl342);
            rule__Concrete0_Impl__Group__0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getConcrete0_ImplAccess().getGroup()); 
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
    // $ANTLR end ruleConcrete0_Impl


    // $ANTLR start entryRuleEString
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:204:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:205:1: ( ruleEString EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:206:1: ruleEString EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getEStringRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_entryRuleEString369);
            ruleEString();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getEStringRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEString376); if (failed) return ;

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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:213:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:217:2: ( ( ( rule__EString__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:218:1: ( ( rule__EString__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:218:1: ( ( rule__EString__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:219:1: ( rule__EString__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getEStringAccess().getAlternatives()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:220:1: ( rule__EString__Alternatives )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:220:2: rule__EString__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__EString__Alternatives_in_ruleEString402);
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


    // $ANTLR start entryRuleConcrete1_Impl
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:232:1: entryRuleConcrete1_Impl : ruleConcrete1_Impl EOF ;
    public final void entryRuleConcrete1_Impl() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:233:1: ( ruleConcrete1_Impl EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:234:1: ruleConcrete1_Impl EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getConcrete1_ImplRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleConcrete1_Impl_in_entryRuleConcrete1_Impl429);
            ruleConcrete1_Impl();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getConcrete1_ImplRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConcrete1_Impl436); if (failed) return ;

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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:241:1: ruleConcrete1_Impl : ( ( rule__Concrete1_Impl__Group__0 ) ) ;
    public final void ruleConcrete1_Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:245:2: ( ( ( rule__Concrete1_Impl__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:246:1: ( ( rule__Concrete1_Impl__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:246:1: ( ( rule__Concrete1_Impl__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:247:1: ( rule__Concrete1_Impl__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getConcrete1_ImplAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:248:1: ( rule__Concrete1_Impl__Group__0 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:248:2: rule__Concrete1_Impl__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Concrete1_Impl__Group__0_in_ruleConcrete1_Impl462);
            rule__Concrete1_Impl__Group__0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getConcrete1_ImplAccess().getGroup()); 
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
    // $ANTLR end ruleConcrete1_Impl


    // $ANTLR start entryRuleDiamondInheritance
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:260:1: entryRuleDiamondInheritance : ruleDiamondInheritance EOF ;
    public final void entryRuleDiamondInheritance() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:261:1: ( ruleDiamondInheritance EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:262:1: ruleDiamondInheritance EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getDiamondInheritanceRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleDiamondInheritance_in_entryRuleDiamondInheritance489);
            ruleDiamondInheritance();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getDiamondInheritanceRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDiamondInheritance496); if (failed) return ;

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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:269:1: ruleDiamondInheritance : ( ( rule__DiamondInheritance__Group__0 ) ) ;
    public final void ruleDiamondInheritance() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:273:2: ( ( ( rule__DiamondInheritance__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:274:1: ( ( rule__DiamondInheritance__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:274:1: ( ( rule__DiamondInheritance__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:275:1: ( rule__DiamondInheritance__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getDiamondInheritanceAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:276:1: ( rule__DiamondInheritance__Group__0 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:276:2: rule__DiamondInheritance__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__DiamondInheritance__Group__0_in_ruleDiamondInheritance522);
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:288:1: rule__Abstract__Alternatives : ( ( ruleConcrete0_Impl ) | ( ruleConcrete1_Impl ) | ( ruleDiamondInheritance ) );
    public final void rule__Abstract__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:292:1: ( ( ruleConcrete0_Impl ) | ( ruleConcrete1_Impl ) | ( ruleDiamondInheritance ) )
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
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("288:1: rule__Abstract__Alternatives : ( ( ruleConcrete0_Impl ) | ( ruleConcrete1_Impl ) | ( ruleDiamondInheritance ) );", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:293:1: ( ruleConcrete0_Impl )
                    {
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:293:1: ( ruleConcrete0_Impl )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:294:1: ruleConcrete0_Impl
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getAbstractAccess().getConcrete0_ImplParserRuleCall_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConcrete0_Impl_in_rule__Abstract__Alternatives558);
                    ruleConcrete0_Impl();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getAbstractAccess().getConcrete0_ImplParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:299:6: ( ruleConcrete1_Impl )
                    {
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:299:6: ( ruleConcrete1_Impl )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:300:1: ruleConcrete1_Impl
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getAbstractAccess().getConcrete1_ImplParserRuleCall_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConcrete1_Impl_in_rule__Abstract__Alternatives575);
                    ruleConcrete1_Impl();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getAbstractAccess().getConcrete1_ImplParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:305:6: ( ruleDiamondInheritance )
                    {
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:305:6: ( ruleDiamondInheritance )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:306:1: ruleDiamondInheritance
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getAbstractAccess().getDiamondInheritanceParserRuleCall_2()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleDiamondInheritance_in_rule__Abstract__Alternatives592);
                    ruleDiamondInheritance();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getAbstractAccess().getDiamondInheritanceParserRuleCall_2()); 
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


    // $ANTLR start rule__Concrete0__Alternatives
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:316:1: rule__Concrete0__Alternatives : ( ( ruleConcrete0_Impl ) | ( ruleDiamondInheritance ) );
    public final void rule__Concrete0__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:320:1: ( ( ruleConcrete0_Impl ) | ( ruleDiamondInheritance ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==18) ) {
                alt2=1;
            }
            else if ( (LA2_0==20) ) {
                alt2=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("316:1: rule__Concrete0__Alternatives : ( ( ruleConcrete0_Impl ) | ( ruleDiamondInheritance ) );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:321:1: ( ruleConcrete0_Impl )
                    {
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:321:1: ( ruleConcrete0_Impl )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:322:1: ruleConcrete0_Impl
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getConcrete0Access().getConcrete0_ImplParserRuleCall_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConcrete0_Impl_in_rule__Concrete0__Alternatives624);
                    ruleConcrete0_Impl();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getConcrete0Access().getConcrete0_ImplParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:327:6: ( ruleDiamondInheritance )
                    {
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:327:6: ( ruleDiamondInheritance )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:328:1: ruleDiamondInheritance
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getConcrete0Access().getDiamondInheritanceParserRuleCall_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleDiamondInheritance_in_rule__Concrete0__Alternatives641);
                    ruleDiamondInheritance();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getConcrete0Access().getDiamondInheritanceParserRuleCall_1()); 
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


    // $ANTLR start rule__EString__Alternatives
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:338:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:342:1: ( ( RULE_STRING ) | ( RULE_ID ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_STRING) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_ID) ) {
                alt3=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("338:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:343:1: ( RULE_STRING )
                    {
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:343:1: ( RULE_STRING )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:344:1: RULE_STRING
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    }
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__EString__Alternatives673); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:349:6: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:349:6: ( RULE_ID )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:350:1: RULE_ID
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    }
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EString__Alternatives690); if (failed) return ;
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


    // $ANTLR start rule__Root__Group__0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:362:1: rule__Root__Group__0 : ( () ) rule__Root__Group__1 ;
    public final void rule__Root__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:366:1: ( ( () ) rule__Root__Group__1 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:367:1: ( () ) rule__Root__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:367:1: ( () )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:368:1: ()
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRootAccess().getRootAction_0()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:369:1: ()
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:371:1: 
            {
            }

            if ( backtracking==0 ) {
               after(grammarAccess.getRootAccess().getRootAction_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group__1_in_rule__Root__Group__0734);
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:382:1: rule__Root__Group__1 : ( 'Root' ) rule__Root__Group__2 ;
    public final void rule__Root__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:386:1: ( ( 'Root' ) rule__Root__Group__2 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:387:1: ( 'Root' ) rule__Root__Group__2
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:387:1: ( 'Root' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:388:1: 'Root'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRootAccess().getRootKeyword_1()); 
            }
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Root__Group__1763); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getRootAccess().getRootKeyword_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group__2_in_rule__Root__Group__1773);
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:402:1: rule__Root__Group__2 : ( ( rule__Root__NameAssignment_2 ) ) rule__Root__Group__3 ;
    public final void rule__Root__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:406:1: ( ( ( rule__Root__NameAssignment_2 ) ) rule__Root__Group__3 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:407:1: ( ( rule__Root__NameAssignment_2 ) ) rule__Root__Group__3
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:407:1: ( ( rule__Root__NameAssignment_2 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:408:1: ( rule__Root__NameAssignment_2 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRootAccess().getNameAssignment_2()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:409:1: ( rule__Root__NameAssignment_2 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:409:2: rule__Root__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Root__NameAssignment_2_in_rule__Root__Group__2801);
            rule__Root__NameAssignment_2();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getRootAccess().getNameAssignment_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group__3_in_rule__Root__Group__2810);
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:420:1: rule__Root__Group__3 : ( '{' ) rule__Root__Group__4 ;
    public final void rule__Root__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:424:1: ( ( '{' ) rule__Root__Group__4 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:425:1: ( '{' ) rule__Root__Group__4
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:425:1: ( '{' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:426:1: '{'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRootAccess().getLeftCurlyBracketKeyword_3()); 
            }
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Root__Group__3839); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getRootAccess().getLeftCurlyBracketKeyword_3()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group__4_in_rule__Root__Group__3849);
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:440:1: rule__Root__Group__4 : ( ( rule__Root__Group_4__0 )? ) rule__Root__Group__5 ;
    public final void rule__Root__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:444:1: ( ( ( rule__Root__Group_4__0 )? ) rule__Root__Group__5 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:445:1: ( ( rule__Root__Group_4__0 )? ) rule__Root__Group__5
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:445:1: ( ( rule__Root__Group_4__0 )? )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:446:1: ( rule__Root__Group_4__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRootAccess().getGroup_4()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:447:1: ( rule__Root__Group_4__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:447:2: rule__Root__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Root__Group_4__0_in_rule__Root__Group__4877);
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

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group__5_in_rule__Root__Group__4887);
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:458:1: rule__Root__Group__5 : ( ( rule__Root__Group_5__0 )? ) rule__Root__Group__6 ;
    public final void rule__Root__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:462:1: ( ( ( rule__Root__Group_5__0 )? ) rule__Root__Group__6 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:463:1: ( ( rule__Root__Group_5__0 )? ) rule__Root__Group__6
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:463:1: ( ( rule__Root__Group_5__0 )? )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:464:1: ( rule__Root__Group_5__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRootAccess().getGroup_5()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:465:1: ( rule__Root__Group_5__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:465:2: rule__Root__Group_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Root__Group_5__0_in_rule__Root__Group__5915);
                    rule__Root__Group_5__0();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getRootAccess().getGroup_5()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group__6_in_rule__Root__Group__5925);
            rule__Root__Group__6();
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
    // $ANTLR end rule__Root__Group__5


    // $ANTLR start rule__Root__Group__6
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:476:1: rule__Root__Group__6 : ( '}' ) ;
    public final void rule__Root__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:480:1: ( ( '}' ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:481:1: ( '}' )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:481:1: ( '}' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:482:1: '}'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRootAccess().getRightCurlyBracketKeyword_6()); 
            }
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Root__Group__6954); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getRootAccess().getRightCurlyBracketKeyword_6()); 
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
    // $ANTLR end rule__Root__Group__6


    // $ANTLR start rule__Root__Group_4__0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:509:1: rule__Root__Group_4__0 : ( 'classes' ) rule__Root__Group_4__1 ;
    public final void rule__Root__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:513:1: ( ( 'classes' ) rule__Root__Group_4__1 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:514:1: ( 'classes' ) rule__Root__Group_4__1
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:514:1: ( 'classes' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:515:1: 'classes'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRootAccess().getClassesKeyword_4_0()); 
            }
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Root__Group_4__01004); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getRootAccess().getClassesKeyword_4_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group_4__1_in_rule__Root__Group_4__01014);
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:529:1: rule__Root__Group_4__1 : ( '{' ) rule__Root__Group_4__2 ;
    public final void rule__Root__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:533:1: ( ( '{' ) rule__Root__Group_4__2 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:534:1: ( '{' ) rule__Root__Group_4__2
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:534:1: ( '{' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:535:1: '{'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRootAccess().getLeftCurlyBracketKeyword_4_1()); 
            }
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Root__Group_4__11043); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getRootAccess().getLeftCurlyBracketKeyword_4_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group_4__2_in_rule__Root__Group_4__11053);
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:549:1: rule__Root__Group_4__2 : ( ( rule__Root__ClassesAssignment_4_2 ) ) rule__Root__Group_4__3 ;
    public final void rule__Root__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:553:1: ( ( ( rule__Root__ClassesAssignment_4_2 ) ) rule__Root__Group_4__3 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:554:1: ( ( rule__Root__ClassesAssignment_4_2 ) ) rule__Root__Group_4__3
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:554:1: ( ( rule__Root__ClassesAssignment_4_2 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:555:1: ( rule__Root__ClassesAssignment_4_2 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRootAccess().getClassesAssignment_4_2()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:556:1: ( rule__Root__ClassesAssignment_4_2 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:556:2: rule__Root__ClassesAssignment_4_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Root__ClassesAssignment_4_2_in_rule__Root__Group_4__21081);
            rule__Root__ClassesAssignment_4_2();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getRootAccess().getClassesAssignment_4_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group_4__3_in_rule__Root__Group_4__21090);
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:567:1: rule__Root__Group_4__3 : ( ( rule__Root__Group_4_3__0 )* ) rule__Root__Group_4__4 ;
    public final void rule__Root__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:571:1: ( ( ( rule__Root__Group_4_3__0 )* ) rule__Root__Group_4__4 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:572:1: ( ( rule__Root__Group_4_3__0 )* ) rule__Root__Group_4__4
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:572:1: ( ( rule__Root__Group_4_3__0 )* )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:573:1: ( rule__Root__Group_4_3__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRootAccess().getGroup_4_3()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:574:1: ( rule__Root__Group_4_3__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==16) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:574:2: rule__Root__Group_4_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Root__Group_4_3__0_in_rule__Root__Group_4__31118);
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

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group_4__4_in_rule__Root__Group_4__31128);
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:585:1: rule__Root__Group_4__4 : ( '}' ) ;
    public final void rule__Root__Group_4__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:589:1: ( ( '}' ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:590:1: ( '}' )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:590:1: ( '}' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:591:1: '}'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRootAccess().getRightCurlyBracketKeyword_4_4()); 
            }
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Root__Group_4__41157); if (failed) return ;
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:614:1: rule__Root__Group_4_3__0 : ( ',' ) rule__Root__Group_4_3__1 ;
    public final void rule__Root__Group_4_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:618:1: ( ( ',' ) rule__Root__Group_4_3__1 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:619:1: ( ',' ) rule__Root__Group_4_3__1
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:619:1: ( ',' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:620:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRootAccess().getCommaKeyword_4_3_0()); 
            }
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Root__Group_4_3__01203); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getRootAccess().getCommaKeyword_4_3_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group_4_3__1_in_rule__Root__Group_4_3__01213);
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:634:1: rule__Root__Group_4_3__1 : ( ( rule__Root__ClassesAssignment_4_3_1 ) ) ;
    public final void rule__Root__Group_4_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:638:1: ( ( ( rule__Root__ClassesAssignment_4_3_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:639:1: ( ( rule__Root__ClassesAssignment_4_3_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:639:1: ( ( rule__Root__ClassesAssignment_4_3_1 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:640:1: ( rule__Root__ClassesAssignment_4_3_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRootAccess().getClassesAssignment_4_3_1()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:641:1: ( rule__Root__ClassesAssignment_4_3_1 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:641:2: rule__Root__ClassesAssignment_4_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Root__ClassesAssignment_4_3_1_in_rule__Root__Group_4_3__11241);
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


    // $ANTLR start rule__Root__Group_5__0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:655:1: rule__Root__Group_5__0 : ( 'concrete0' ) rule__Root__Group_5__1 ;
    public final void rule__Root__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:659:1: ( ( 'concrete0' ) rule__Root__Group_5__1 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:660:1: ( 'concrete0' ) rule__Root__Group_5__1
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:660:1: ( 'concrete0' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:661:1: 'concrete0'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRootAccess().getConcrete0Keyword_5_0()); 
            }
            match(input,17,FollowSets000.FOLLOW_17_in_rule__Root__Group_5__01280); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getRootAccess().getConcrete0Keyword_5_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group_5__1_in_rule__Root__Group_5__01290);
            rule__Root__Group_5__1();
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
    // $ANTLR end rule__Root__Group_5__0


    // $ANTLR start rule__Root__Group_5__1
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:675:1: rule__Root__Group_5__1 : ( ( rule__Root__Concrete0Assignment_5_1 ) ) ;
    public final void rule__Root__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:679:1: ( ( ( rule__Root__Concrete0Assignment_5_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:680:1: ( ( rule__Root__Concrete0Assignment_5_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:680:1: ( ( rule__Root__Concrete0Assignment_5_1 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:681:1: ( rule__Root__Concrete0Assignment_5_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRootAccess().getConcrete0Assignment_5_1()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:682:1: ( rule__Root__Concrete0Assignment_5_1 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:682:2: rule__Root__Concrete0Assignment_5_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Root__Concrete0Assignment_5_1_in_rule__Root__Group_5__11318);
            rule__Root__Concrete0Assignment_5_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getRootAccess().getConcrete0Assignment_5_1()); 
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
    // $ANTLR end rule__Root__Group_5__1


    // $ANTLR start rule__Concrete0_Impl__Group__0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:696:1: rule__Concrete0_Impl__Group__0 : ( () ) rule__Concrete0_Impl__Group__1 ;
    public final void rule__Concrete0_Impl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:700:1: ( ( () ) rule__Concrete0_Impl__Group__1 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:701:1: ( () ) rule__Concrete0_Impl__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:701:1: ( () )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:702:1: ()
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getConcrete0_ImplAccess().getConcrete0Action_0()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:703:1: ()
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:705:1: 
            {
            }

            if ( backtracking==0 ) {
               after(grammarAccess.getConcrete0_ImplAccess().getConcrete0Action_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Concrete0_Impl__Group__1_in_rule__Concrete0_Impl__Group__01366);
            rule__Concrete0_Impl__Group__1();
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
    // $ANTLR end rule__Concrete0_Impl__Group__0


    // $ANTLR start rule__Concrete0_Impl__Group__1
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:716:1: rule__Concrete0_Impl__Group__1 : ( 'Concrete0' ) rule__Concrete0_Impl__Group__2 ;
    public final void rule__Concrete0_Impl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:720:1: ( ( 'Concrete0' ) rule__Concrete0_Impl__Group__2 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:721:1: ( 'Concrete0' ) rule__Concrete0_Impl__Group__2
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:721:1: ( 'Concrete0' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:722:1: 'Concrete0'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getConcrete0_ImplAccess().getConcrete0Keyword_1()); 
            }
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Concrete0_Impl__Group__11395); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getConcrete0_ImplAccess().getConcrete0Keyword_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Concrete0_Impl__Group__2_in_rule__Concrete0_Impl__Group__11405);
            rule__Concrete0_Impl__Group__2();
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
    // $ANTLR end rule__Concrete0_Impl__Group__1


    // $ANTLR start rule__Concrete0_Impl__Group__2
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:736:1: rule__Concrete0_Impl__Group__2 : ( ( rule__Concrete0_Impl__NameAssignment_2 ) ) ;
    public final void rule__Concrete0_Impl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:740:1: ( ( ( rule__Concrete0_Impl__NameAssignment_2 ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:741:1: ( ( rule__Concrete0_Impl__NameAssignment_2 ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:741:1: ( ( rule__Concrete0_Impl__NameAssignment_2 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:742:1: ( rule__Concrete0_Impl__NameAssignment_2 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getConcrete0_ImplAccess().getNameAssignment_2()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:743:1: ( rule__Concrete0_Impl__NameAssignment_2 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:743:2: rule__Concrete0_Impl__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Concrete0_Impl__NameAssignment_2_in_rule__Concrete0_Impl__Group__21433);
            rule__Concrete0_Impl__NameAssignment_2();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getConcrete0_ImplAccess().getNameAssignment_2()); 
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
    // $ANTLR end rule__Concrete0_Impl__Group__2


    // $ANTLR start rule__Concrete1_Impl__Group__0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:759:1: rule__Concrete1_Impl__Group__0 : ( () ) rule__Concrete1_Impl__Group__1 ;
    public final void rule__Concrete1_Impl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:763:1: ( ( () ) rule__Concrete1_Impl__Group__1 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:764:1: ( () ) rule__Concrete1_Impl__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:764:1: ( () )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:765:1: ()
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getConcrete1_ImplAccess().getConcrete1Action_0()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:766:1: ()
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:768:1: 
            {
            }

            if ( backtracking==0 ) {
               after(grammarAccess.getConcrete1_ImplAccess().getConcrete1Action_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Concrete1_Impl__Group__1_in_rule__Concrete1_Impl__Group__01483);
            rule__Concrete1_Impl__Group__1();
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
    // $ANTLR end rule__Concrete1_Impl__Group__0


    // $ANTLR start rule__Concrete1_Impl__Group__1
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:779:1: rule__Concrete1_Impl__Group__1 : ( 'Concrete1' ) rule__Concrete1_Impl__Group__2 ;
    public final void rule__Concrete1_Impl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:783:1: ( ( 'Concrete1' ) rule__Concrete1_Impl__Group__2 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:784:1: ( 'Concrete1' ) rule__Concrete1_Impl__Group__2
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:784:1: ( 'Concrete1' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:785:1: 'Concrete1'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getConcrete1_ImplAccess().getConcrete1Keyword_1()); 
            }
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Concrete1_Impl__Group__11512); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getConcrete1_ImplAccess().getConcrete1Keyword_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Concrete1_Impl__Group__2_in_rule__Concrete1_Impl__Group__11522);
            rule__Concrete1_Impl__Group__2();
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
    // $ANTLR end rule__Concrete1_Impl__Group__1


    // $ANTLR start rule__Concrete1_Impl__Group__2
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:799:1: rule__Concrete1_Impl__Group__2 : ( ( rule__Concrete1_Impl__NameAssignment_2 ) ) ;
    public final void rule__Concrete1_Impl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:803:1: ( ( ( rule__Concrete1_Impl__NameAssignment_2 ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:804:1: ( ( rule__Concrete1_Impl__NameAssignment_2 ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:804:1: ( ( rule__Concrete1_Impl__NameAssignment_2 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:805:1: ( rule__Concrete1_Impl__NameAssignment_2 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getConcrete1_ImplAccess().getNameAssignment_2()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:806:1: ( rule__Concrete1_Impl__NameAssignment_2 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:806:2: rule__Concrete1_Impl__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Concrete1_Impl__NameAssignment_2_in_rule__Concrete1_Impl__Group__21550);
            rule__Concrete1_Impl__NameAssignment_2();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getConcrete1_ImplAccess().getNameAssignment_2()); 
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
    // $ANTLR end rule__Concrete1_Impl__Group__2


    // $ANTLR start rule__DiamondInheritance__Group__0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:822:1: rule__DiamondInheritance__Group__0 : ( () ) rule__DiamondInheritance__Group__1 ;
    public final void rule__DiamondInheritance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:826:1: ( ( () ) rule__DiamondInheritance__Group__1 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:827:1: ( () ) rule__DiamondInheritance__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:827:1: ( () )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:828:1: ()
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getDiamondInheritanceAccess().getDiamondInheritanceAction_0()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:829:1: ()
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:831:1: 
            {
            }

            if ( backtracking==0 ) {
               after(grammarAccess.getDiamondInheritanceAccess().getDiamondInheritanceAction_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__DiamondInheritance__Group__1_in_rule__DiamondInheritance__Group__01600);
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:842:1: rule__DiamondInheritance__Group__1 : ( 'DiamondInheritance' ) rule__DiamondInheritance__Group__2 ;
    public final void rule__DiamondInheritance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:846:1: ( ( 'DiamondInheritance' ) rule__DiamondInheritance__Group__2 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:847:1: ( 'DiamondInheritance' ) rule__DiamondInheritance__Group__2
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:847:1: ( 'DiamondInheritance' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:848:1: 'DiamondInheritance'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getDiamondInheritanceAccess().getDiamondInheritanceKeyword_1()); 
            }
            match(input,20,FollowSets000.FOLLOW_20_in_rule__DiamondInheritance__Group__11629); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getDiamondInheritanceAccess().getDiamondInheritanceKeyword_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__DiamondInheritance__Group__2_in_rule__DiamondInheritance__Group__11639);
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:862:1: rule__DiamondInheritance__Group__2 : ( ( rule__DiamondInheritance__NameAssignment_2 ) ) ;
    public final void rule__DiamondInheritance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:866:1: ( ( ( rule__DiamondInheritance__NameAssignment_2 ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:867:1: ( ( rule__DiamondInheritance__NameAssignment_2 ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:867:1: ( ( rule__DiamondInheritance__NameAssignment_2 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:868:1: ( rule__DiamondInheritance__NameAssignment_2 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getDiamondInheritanceAccess().getNameAssignment_2()); 
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:869:1: ( rule__DiamondInheritance__NameAssignment_2 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:869:2: rule__DiamondInheritance__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__DiamondInheritance__NameAssignment_2_in_rule__DiamondInheritance__Group__21667);
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:886:1: rule__Root__NameAssignment_2 : ( ruleINT0 ) ;
    public final void rule__Root__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:890:1: ( ( ruleINT0 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:891:1: ( ruleINT0 )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:891:1: ( ruleINT0 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:892:1: ruleINT0
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRootAccess().getNameINT0ParserRuleCall_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleINT0_in_rule__Root__NameAssignment_21708);
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:901:1: rule__Root__ClassesAssignment_4_2 : ( ruleAbstract ) ;
    public final void rule__Root__ClassesAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:905:1: ( ( ruleAbstract ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:906:1: ( ruleAbstract )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:906:1: ( ruleAbstract )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:907:1: ruleAbstract
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRootAccess().getClassesAbstractParserRuleCall_4_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAbstract_in_rule__Root__ClassesAssignment_4_21739);
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:916:1: rule__Root__ClassesAssignment_4_3_1 : ( ruleAbstract ) ;
    public final void rule__Root__ClassesAssignment_4_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:920:1: ( ( ruleAbstract ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:921:1: ( ruleAbstract )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:921:1: ( ruleAbstract )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:922:1: ruleAbstract
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRootAccess().getClassesAbstractParserRuleCall_4_3_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAbstract_in_rule__Root__ClassesAssignment_4_3_11770);
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


    // $ANTLR start rule__Root__Concrete0Assignment_5_1
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:931:1: rule__Root__Concrete0Assignment_5_1 : ( ruleConcrete0 ) ;
    public final void rule__Root__Concrete0Assignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:935:1: ( ( ruleConcrete0 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:936:1: ( ruleConcrete0 )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:936:1: ( ruleConcrete0 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:937:1: ruleConcrete0
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRootAccess().getConcrete0Concrete0ParserRuleCall_5_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleConcrete0_in_rule__Root__Concrete0Assignment_5_11801);
            ruleConcrete0();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getRootAccess().getConcrete0Concrete0ParserRuleCall_5_1_0()); 
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
    // $ANTLR end rule__Root__Concrete0Assignment_5_1


    // $ANTLR start rule__Concrete0_Impl__NameAssignment_2
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:946:1: rule__Concrete0_Impl__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__Concrete0_Impl__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:950:1: ( ( ruleEString ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:951:1: ( ruleEString )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:951:1: ( ruleEString )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:952:1: ruleEString
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getConcrete0_ImplAccess().getNameEStringParserRuleCall_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__Concrete0_Impl__NameAssignment_21832);
            ruleEString();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getConcrete0_ImplAccess().getNameEStringParserRuleCall_2_0()); 
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
    // $ANTLR end rule__Concrete0_Impl__NameAssignment_2


    // $ANTLR start rule__Concrete1_Impl__NameAssignment_2
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:961:1: rule__Concrete1_Impl__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__Concrete1_Impl__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:965:1: ( ( ruleEString ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:966:1: ( ruleEString )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:966:1: ( ruleEString )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:967:1: ruleEString
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getConcrete1_ImplAccess().getNameEStringParserRuleCall_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__Concrete1_Impl__NameAssignment_21863);
            ruleEString();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getConcrete1_ImplAccess().getNameEStringParserRuleCall_2_0()); 
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
    // $ANTLR end rule__Concrete1_Impl__NameAssignment_2


    // $ANTLR start rule__DiamondInheritance__NameAssignment_2
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:976:1: rule__DiamondInheritance__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__DiamondInheritance__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:980:1: ( ( ruleEString ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:981:1: ( ruleEString )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:981:1: ( ruleEString )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g:982:1: ruleEString
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getDiamondInheritanceAccess().getNameEStringParserRuleCall_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__DiamondInheritance__NameAssignment_21894);
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


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot67 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRoot74 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Group__0_in_ruleRoot100 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstract_in_entryRuleAbstract127 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstract134 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Abstract__Alternatives_in_ruleAbstract160 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete0_in_entryRuleConcrete0187 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConcrete0194 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Concrete0__Alternatives_in_ruleConcrete0220 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleINT0_in_entryRuleINT0247 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleINT0254 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleINT0281 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete0_Impl_in_entryRuleConcrete0_Impl309 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConcrete0_Impl316 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Concrete0_Impl__Group__0_in_ruleConcrete0_Impl342 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_entryRuleEString369 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEString376 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EString__Alternatives_in_ruleEString402 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete1_Impl_in_entryRuleConcrete1_Impl429 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConcrete1_Impl436 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Concrete1_Impl__Group__0_in_ruleConcrete1_Impl462 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDiamondInheritance_in_entryRuleDiamondInheritance489 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDiamondInheritance496 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DiamondInheritance__Group__0_in_ruleDiamondInheritance522 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete0_Impl_in_rule__Abstract__Alternatives558 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete1_Impl_in_rule__Abstract__Alternatives575 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDiamondInheritance_in_rule__Abstract__Alternatives592 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete0_Impl_in_rule__Concrete0__Alternatives624 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDiamondInheritance_in_rule__Concrete0__Alternatives641 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__EString__Alternatives673 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EString__Alternatives690 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Group__1_in_rule__Root__Group__0734 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Root__Group__1763 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__Root__Group__2_in_rule__Root__Group__1773 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__NameAssignment_2_in_rule__Root__Group__2801 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__Root__Group__3_in_rule__Root__Group__2810 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Root__Group__3839 = new BitSet(new long[]{0x000000000002C000L});
        public static final BitSet FOLLOW_rule__Root__Group__4_in_rule__Root__Group__3849 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Group_4__0_in_rule__Root__Group__4877 = new BitSet(new long[]{0x0000000000024000L});
        public static final BitSet FOLLOW_rule__Root__Group__5_in_rule__Root__Group__4887 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Group_5__0_in_rule__Root__Group__5915 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__Root__Group__6_in_rule__Root__Group__5925 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Root__Group__6954 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Root__Group_4__01004 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__Root__Group_4__1_in_rule__Root__Group_4__01014 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Root__Group_4__11043 = new BitSet(new long[]{0x00000000001C0000L});
        public static final BitSet FOLLOW_rule__Root__Group_4__2_in_rule__Root__Group_4__11053 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__ClassesAssignment_4_2_in_rule__Root__Group_4__21081 = new BitSet(new long[]{0x0000000000014000L});
        public static final BitSet FOLLOW_rule__Root__Group_4__3_in_rule__Root__Group_4__21090 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Group_4_3__0_in_rule__Root__Group_4__31118 = new BitSet(new long[]{0x0000000000014000L});
        public static final BitSet FOLLOW_rule__Root__Group_4__4_in_rule__Root__Group_4__31128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Root__Group_4__41157 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Root__Group_4_3__01203 = new BitSet(new long[]{0x00000000001C0000L});
        public static final BitSet FOLLOW_rule__Root__Group_4_3__1_in_rule__Root__Group_4_3__01213 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__ClassesAssignment_4_3_1_in_rule__Root__Group_4_3__11241 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Root__Group_5__01280 = new BitSet(new long[]{0x0000000000140000L});
        public static final BitSet FOLLOW_rule__Root__Group_5__1_in_rule__Root__Group_5__01290 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Concrete0Assignment_5_1_in_rule__Root__Group_5__11318 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Concrete0_Impl__Group__1_in_rule__Concrete0_Impl__Group__01366 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Concrete0_Impl__Group__11395 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__Concrete0_Impl__Group__2_in_rule__Concrete0_Impl__Group__11405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Concrete0_Impl__NameAssignment_2_in_rule__Concrete0_Impl__Group__21433 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Concrete1_Impl__Group__1_in_rule__Concrete1_Impl__Group__01483 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Concrete1_Impl__Group__11512 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__Concrete1_Impl__Group__2_in_rule__Concrete1_Impl__Group__11522 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Concrete1_Impl__NameAssignment_2_in_rule__Concrete1_Impl__Group__21550 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DiamondInheritance__Group__1_in_rule__DiamondInheritance__Group__01600 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__DiamondInheritance__Group__11629 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__DiamondInheritance__Group__2_in_rule__DiamondInheritance__Group__11639 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DiamondInheritance__NameAssignment_2_in_rule__DiamondInheritance__Group__21667 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleINT0_in_rule__Root__NameAssignment_21708 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstract_in_rule__Root__ClassesAssignment_4_21739 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstract_in_rule__Root__ClassesAssignment_4_3_11770 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete0_in_rule__Root__Concrete0Assignment_5_11801 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__Concrete0_Impl__NameAssignment_21832 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__Concrete1_Impl__NameAssignment_21863 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__DiamondInheritance__NameAssignment_21894 = new BitSet(new long[]{0x0000000000000002L});
    }


}
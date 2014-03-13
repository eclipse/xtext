package org.eclipse.xtext.ui.tests.editor.contentassist.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug381381TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug381381TestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'FIELD-NAME-TO-VARIABLE'", "','", "'SCREEN'", "'='", "'('", "')'", "'VAR'", "'TYPE'", "'REPLACE'"
    };
    public static final int T__19=19;
    public static final int RULE_ID=5;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=4;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalBug381381TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug381381TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug381381TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g"; }


     
     	private Bug381381TestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(Bug381381TestLanguageGrammarAccess grammarAccess) {
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




    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:61:1: ( ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:62:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel61);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel68); 

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:69:1: ruleModel : ( ( rule__Model__StmtAssignment ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:73:2: ( ( ( rule__Model__StmtAssignment ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:74:1: ( ( rule__Model__StmtAssignment ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:74:1: ( ( rule__Model__StmtAssignment ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:75:1: ( rule__Model__StmtAssignment )
            {
             before(grammarAccess.getModelAccess().getStmtAssignment()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:76:1: ( rule__Model__StmtAssignment )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:76:2: rule__Model__StmtAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__StmtAssignment_in_ruleModel94);
            rule__Model__StmtAssignment();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getStmtAssignment()); 

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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleCopyFieldNameToVariableStmt"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:88:1: entryRuleCopyFieldNameToVariableStmt : ruleCopyFieldNameToVariableStmt EOF ;
    public final void entryRuleCopyFieldNameToVariableStmt() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:89:1: ( ruleCopyFieldNameToVariableStmt EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:90:1: ruleCopyFieldNameToVariableStmt EOF
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCopyFieldNameToVariableStmt_in_entryRuleCopyFieldNameToVariableStmt121);
            ruleCopyFieldNameToVariableStmt();

            state._fsp--;

             after(grammarAccess.getCopyFieldNameToVariableStmtRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCopyFieldNameToVariableStmt128); 

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
    // $ANTLR end "entryRuleCopyFieldNameToVariableStmt"


    // $ANTLR start "ruleCopyFieldNameToVariableStmt"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:97:1: ruleCopyFieldNameToVariableStmt : ( ( rule__CopyFieldNameToVariableStmt__Group__0 ) ) ;
    public final void ruleCopyFieldNameToVariableStmt() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:101:2: ( ( ( rule__CopyFieldNameToVariableStmt__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:102:1: ( ( rule__CopyFieldNameToVariableStmt__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:102:1: ( ( rule__CopyFieldNameToVariableStmt__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:103:1: ( rule__CopyFieldNameToVariableStmt__Group__0 )
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:104:1: ( rule__CopyFieldNameToVariableStmt__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:104:2: rule__CopyFieldNameToVariableStmt__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__Group__0_in_ruleCopyFieldNameToVariableStmt154);
            rule__CopyFieldNameToVariableStmt__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCopyFieldNameToVariableStmtAccess().getGroup()); 

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
    // $ANTLR end "ruleCopyFieldNameToVariableStmt"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:118:1: rule__CopyFieldNameToVariableStmt__Group__0 : rule__CopyFieldNameToVariableStmt__Group__0__Impl rule__CopyFieldNameToVariableStmt__Group__1 ;
    public final void rule__CopyFieldNameToVariableStmt__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:122:1: ( rule__CopyFieldNameToVariableStmt__Group__0__Impl rule__CopyFieldNameToVariableStmt__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:123:2: rule__CopyFieldNameToVariableStmt__Group__0__Impl rule__CopyFieldNameToVariableStmt__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__Group__0__Impl_in_rule__CopyFieldNameToVariableStmt__Group__0188);
            rule__CopyFieldNameToVariableStmt__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__Group__1_in_rule__CopyFieldNameToVariableStmt__Group__0191);
            rule__CopyFieldNameToVariableStmt__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__Group__0"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__Group__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:130:1: rule__CopyFieldNameToVariableStmt__Group__0__Impl : ( 'FIELD-NAME-TO-VARIABLE' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:134:1: ( ( 'FIELD-NAME-TO-VARIABLE' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:135:1: ( 'FIELD-NAME-TO-VARIABLE' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:135:1: ( 'FIELD-NAME-TO-VARIABLE' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:136:1: 'FIELD-NAME-TO-VARIABLE'
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getFIELDNAMETOVARIABLEKeyword_0()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__CopyFieldNameToVariableStmt__Group__0__Impl219); 
             after(grammarAccess.getCopyFieldNameToVariableStmtAccess().getFIELDNAMETOVARIABLEKeyword_0()); 

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
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__Group__0__Impl"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:149:1: rule__CopyFieldNameToVariableStmt__Group__1 : rule__CopyFieldNameToVariableStmt__Group__1__Impl ;
    public final void rule__CopyFieldNameToVariableStmt__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:153:1: ( rule__CopyFieldNameToVariableStmt__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:154:2: rule__CopyFieldNameToVariableStmt__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__Group__1__Impl_in_rule__CopyFieldNameToVariableStmt__Group__1250);
            rule__CopyFieldNameToVariableStmt__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__Group__1"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__Group__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:160:1: rule__CopyFieldNameToVariableStmt__Group__1__Impl : ( ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1 ) ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:164:1: ( ( ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:165:1: ( ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:165:1: ( ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:166:1: ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1 )
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:167:1: ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:167:2: rule__CopyFieldNameToVariableStmt__UnorderedGroup_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__UnorderedGroup_1_in_rule__CopyFieldNameToVariableStmt__Group__1__Impl277);
            rule__CopyFieldNameToVariableStmt__UnorderedGroup_1();

            state._fsp--;


            }

             after(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1()); 

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
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__Group__1__Impl"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__Group_1_0__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:181:1: rule__CopyFieldNameToVariableStmt__Group_1_0__0 : rule__CopyFieldNameToVariableStmt__Group_1_0__0__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__1 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:185:1: ( rule__CopyFieldNameToVariableStmt__Group_1_0__0__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:186:2: rule__CopyFieldNameToVariableStmt__Group_1_0__0__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_0__0__Impl_in_rule__CopyFieldNameToVariableStmt__Group_1_0__0311);
            rule__CopyFieldNameToVariableStmt__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_0__1_in_rule__CopyFieldNameToVariableStmt__Group_1_0__0314);
            rule__CopyFieldNameToVariableStmt__Group_1_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__Group_1_0__0"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__Group_1_0__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:193:1: rule__CopyFieldNameToVariableStmt__Group_1_0__0__Impl : ( ',' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:197:1: ( ( ',' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:198:1: ( ',' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:198:1: ( ',' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:199:1: ','
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getCommaKeyword_1_0_0()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__CopyFieldNameToVariableStmt__Group_1_0__0__Impl342); 
             after(grammarAccess.getCopyFieldNameToVariableStmtAccess().getCommaKeyword_1_0_0()); 

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
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__Group_1_0__0__Impl"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__Group_1_0__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:212:1: rule__CopyFieldNameToVariableStmt__Group_1_0__1 : rule__CopyFieldNameToVariableStmt__Group_1_0__1__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__2 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:216:1: ( rule__CopyFieldNameToVariableStmt__Group_1_0__1__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:217:2: rule__CopyFieldNameToVariableStmt__Group_1_0__1__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_0__1__Impl_in_rule__CopyFieldNameToVariableStmt__Group_1_0__1373);
            rule__CopyFieldNameToVariableStmt__Group_1_0__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_0__2_in_rule__CopyFieldNameToVariableStmt__Group_1_0__1376);
            rule__CopyFieldNameToVariableStmt__Group_1_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__Group_1_0__1"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__Group_1_0__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:224:1: rule__CopyFieldNameToVariableStmt__Group_1_0__1__Impl : ( 'SCREEN' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:228:1: ( ( 'SCREEN' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:229:1: ( 'SCREEN' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:229:1: ( 'SCREEN' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:230:1: 'SCREEN'
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getSCREENKeyword_1_0_1()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__CopyFieldNameToVariableStmt__Group_1_0__1__Impl404); 
             after(grammarAccess.getCopyFieldNameToVariableStmtAccess().getSCREENKeyword_1_0_1()); 

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
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__Group_1_0__1__Impl"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__Group_1_0__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:243:1: rule__CopyFieldNameToVariableStmt__Group_1_0__2 : rule__CopyFieldNameToVariableStmt__Group_1_0__2__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__3 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:247:1: ( rule__CopyFieldNameToVariableStmt__Group_1_0__2__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:248:2: rule__CopyFieldNameToVariableStmt__Group_1_0__2__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_0__2__Impl_in_rule__CopyFieldNameToVariableStmt__Group_1_0__2435);
            rule__CopyFieldNameToVariableStmt__Group_1_0__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_0__3_in_rule__CopyFieldNameToVariableStmt__Group_1_0__2438);
            rule__CopyFieldNameToVariableStmt__Group_1_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__Group_1_0__2"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__Group_1_0__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:255:1: rule__CopyFieldNameToVariableStmt__Group_1_0__2__Impl : ( '=' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:259:1: ( ( '=' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:260:1: ( '=' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:260:1: ( '=' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:261:1: '='
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getEqualsSignKeyword_1_0_2()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__CopyFieldNameToVariableStmt__Group_1_0__2__Impl466); 
             after(grammarAccess.getCopyFieldNameToVariableStmtAccess().getEqualsSignKeyword_1_0_2()); 

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
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__Group_1_0__2__Impl"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__Group_1_0__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:274:1: rule__CopyFieldNameToVariableStmt__Group_1_0__3 : rule__CopyFieldNameToVariableStmt__Group_1_0__3__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__4 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:278:1: ( rule__CopyFieldNameToVariableStmt__Group_1_0__3__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:279:2: rule__CopyFieldNameToVariableStmt__Group_1_0__3__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_0__3__Impl_in_rule__CopyFieldNameToVariableStmt__Group_1_0__3497);
            rule__CopyFieldNameToVariableStmt__Group_1_0__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_0__4_in_rule__CopyFieldNameToVariableStmt__Group_1_0__3500);
            rule__CopyFieldNameToVariableStmt__Group_1_0__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__Group_1_0__3"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__Group_1_0__3__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:286:1: rule__CopyFieldNameToVariableStmt__Group_1_0__3__Impl : ( '(' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:290:1: ( ( '(' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:291:1: ( '(' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:291:1: ( '(' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:292:1: '('
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getLeftParenthesisKeyword_1_0_3()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__CopyFieldNameToVariableStmt__Group_1_0__3__Impl528); 
             after(grammarAccess.getCopyFieldNameToVariableStmtAccess().getLeftParenthesisKeyword_1_0_3()); 

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
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__Group_1_0__3__Impl"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__Group_1_0__4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:305:1: rule__CopyFieldNameToVariableStmt__Group_1_0__4 : rule__CopyFieldNameToVariableStmt__Group_1_0__4__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__5 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:309:1: ( rule__CopyFieldNameToVariableStmt__Group_1_0__4__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:310:2: rule__CopyFieldNameToVariableStmt__Group_1_0__4__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_0__4__Impl_in_rule__CopyFieldNameToVariableStmt__Group_1_0__4559);
            rule__CopyFieldNameToVariableStmt__Group_1_0__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_0__5_in_rule__CopyFieldNameToVariableStmt__Group_1_0__4562);
            rule__CopyFieldNameToVariableStmt__Group_1_0__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__Group_1_0__4"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__Group_1_0__4__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:317:1: rule__CopyFieldNameToVariableStmt__Group_1_0__4__Impl : ( ( rule__CopyFieldNameToVariableStmt__LineAssignment_1_0_4 ) ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:321:1: ( ( ( rule__CopyFieldNameToVariableStmt__LineAssignment_1_0_4 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:322:1: ( ( rule__CopyFieldNameToVariableStmt__LineAssignment_1_0_4 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:322:1: ( ( rule__CopyFieldNameToVariableStmt__LineAssignment_1_0_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:323:1: ( rule__CopyFieldNameToVariableStmt__LineAssignment_1_0_4 )
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getLineAssignment_1_0_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:324:1: ( rule__CopyFieldNameToVariableStmt__LineAssignment_1_0_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:324:2: rule__CopyFieldNameToVariableStmt__LineAssignment_1_0_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__LineAssignment_1_0_4_in_rule__CopyFieldNameToVariableStmt__Group_1_0__4__Impl589);
            rule__CopyFieldNameToVariableStmt__LineAssignment_1_0_4();

            state._fsp--;


            }

             after(grammarAccess.getCopyFieldNameToVariableStmtAccess().getLineAssignment_1_0_4()); 

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
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__Group_1_0__4__Impl"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__Group_1_0__5"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:334:1: rule__CopyFieldNameToVariableStmt__Group_1_0__5 : rule__CopyFieldNameToVariableStmt__Group_1_0__5__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__6 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:338:1: ( rule__CopyFieldNameToVariableStmt__Group_1_0__5__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__6 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:339:2: rule__CopyFieldNameToVariableStmt__Group_1_0__5__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_0__5__Impl_in_rule__CopyFieldNameToVariableStmt__Group_1_0__5619);
            rule__CopyFieldNameToVariableStmt__Group_1_0__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_0__6_in_rule__CopyFieldNameToVariableStmt__Group_1_0__5622);
            rule__CopyFieldNameToVariableStmt__Group_1_0__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__Group_1_0__5"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__Group_1_0__5__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:346:1: rule__CopyFieldNameToVariableStmt__Group_1_0__5__Impl : ( ',' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:350:1: ( ( ',' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:351:1: ( ',' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:351:1: ( ',' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:352:1: ','
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getCommaKeyword_1_0_5()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__CopyFieldNameToVariableStmt__Group_1_0__5__Impl650); 
             after(grammarAccess.getCopyFieldNameToVariableStmtAccess().getCommaKeyword_1_0_5()); 

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
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__Group_1_0__5__Impl"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__Group_1_0__6"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:365:1: rule__CopyFieldNameToVariableStmt__Group_1_0__6 : rule__CopyFieldNameToVariableStmt__Group_1_0__6__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__7 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:369:1: ( rule__CopyFieldNameToVariableStmt__Group_1_0__6__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__7 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:370:2: rule__CopyFieldNameToVariableStmt__Group_1_0__6__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_0__6__Impl_in_rule__CopyFieldNameToVariableStmt__Group_1_0__6681);
            rule__CopyFieldNameToVariableStmt__Group_1_0__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_0__7_in_rule__CopyFieldNameToVariableStmt__Group_1_0__6684);
            rule__CopyFieldNameToVariableStmt__Group_1_0__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__Group_1_0__6"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__Group_1_0__6__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:377:1: rule__CopyFieldNameToVariableStmt__Group_1_0__6__Impl : ( ( rule__CopyFieldNameToVariableStmt__ColumnAssignment_1_0_6 ) ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:381:1: ( ( ( rule__CopyFieldNameToVariableStmt__ColumnAssignment_1_0_6 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:382:1: ( ( rule__CopyFieldNameToVariableStmt__ColumnAssignment_1_0_6 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:382:1: ( ( rule__CopyFieldNameToVariableStmt__ColumnAssignment_1_0_6 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:383:1: ( rule__CopyFieldNameToVariableStmt__ColumnAssignment_1_0_6 )
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getColumnAssignment_1_0_6()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:384:1: ( rule__CopyFieldNameToVariableStmt__ColumnAssignment_1_0_6 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:384:2: rule__CopyFieldNameToVariableStmt__ColumnAssignment_1_0_6
            {
            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__ColumnAssignment_1_0_6_in_rule__CopyFieldNameToVariableStmt__Group_1_0__6__Impl711);
            rule__CopyFieldNameToVariableStmt__ColumnAssignment_1_0_6();

            state._fsp--;


            }

             after(grammarAccess.getCopyFieldNameToVariableStmtAccess().getColumnAssignment_1_0_6()); 

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
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__Group_1_0__6__Impl"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__Group_1_0__7"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:394:1: rule__CopyFieldNameToVariableStmt__Group_1_0__7 : rule__CopyFieldNameToVariableStmt__Group_1_0__7__Impl ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:398:1: ( rule__CopyFieldNameToVariableStmt__Group_1_0__7__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:399:2: rule__CopyFieldNameToVariableStmt__Group_1_0__7__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_0__7__Impl_in_rule__CopyFieldNameToVariableStmt__Group_1_0__7741);
            rule__CopyFieldNameToVariableStmt__Group_1_0__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__Group_1_0__7"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__Group_1_0__7__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:405:1: rule__CopyFieldNameToVariableStmt__Group_1_0__7__Impl : ( ')' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:409:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:410:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:410:1: ( ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:411:1: ')'
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getRightParenthesisKeyword_1_0_7()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__CopyFieldNameToVariableStmt__Group_1_0__7__Impl769); 
             after(grammarAccess.getCopyFieldNameToVariableStmtAccess().getRightParenthesisKeyword_1_0_7()); 

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
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__Group_1_0__7__Impl"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__Group_1_1__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:440:1: rule__CopyFieldNameToVariableStmt__Group_1_1__0 : rule__CopyFieldNameToVariableStmt__Group_1_1__0__Impl rule__CopyFieldNameToVariableStmt__Group_1_1__1 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:444:1: ( rule__CopyFieldNameToVariableStmt__Group_1_1__0__Impl rule__CopyFieldNameToVariableStmt__Group_1_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:445:2: rule__CopyFieldNameToVariableStmt__Group_1_1__0__Impl rule__CopyFieldNameToVariableStmt__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_1__0__Impl_in_rule__CopyFieldNameToVariableStmt__Group_1_1__0816);
            rule__CopyFieldNameToVariableStmt__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_1__1_in_rule__CopyFieldNameToVariableStmt__Group_1_1__0819);
            rule__CopyFieldNameToVariableStmt__Group_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__Group_1_1__0"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__Group_1_1__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:452:1: rule__CopyFieldNameToVariableStmt__Group_1_1__0__Impl : ( ',' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:456:1: ( ( ',' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:457:1: ( ',' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:457:1: ( ',' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:458:1: ','
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getCommaKeyword_1_1_0()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__CopyFieldNameToVariableStmt__Group_1_1__0__Impl847); 
             after(grammarAccess.getCopyFieldNameToVariableStmtAccess().getCommaKeyword_1_1_0()); 

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
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__Group_1_1__0__Impl"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__Group_1_1__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:471:1: rule__CopyFieldNameToVariableStmt__Group_1_1__1 : rule__CopyFieldNameToVariableStmt__Group_1_1__1__Impl rule__CopyFieldNameToVariableStmt__Group_1_1__2 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:475:1: ( rule__CopyFieldNameToVariableStmt__Group_1_1__1__Impl rule__CopyFieldNameToVariableStmt__Group_1_1__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:476:2: rule__CopyFieldNameToVariableStmt__Group_1_1__1__Impl rule__CopyFieldNameToVariableStmt__Group_1_1__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_1__1__Impl_in_rule__CopyFieldNameToVariableStmt__Group_1_1__1878);
            rule__CopyFieldNameToVariableStmt__Group_1_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_1__2_in_rule__CopyFieldNameToVariableStmt__Group_1_1__1881);
            rule__CopyFieldNameToVariableStmt__Group_1_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__Group_1_1__1"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__Group_1_1__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:483:1: rule__CopyFieldNameToVariableStmt__Group_1_1__1__Impl : ( 'VAR' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:487:1: ( ( 'VAR' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:488:1: ( 'VAR' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:488:1: ( 'VAR' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:489:1: 'VAR'
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getVARKeyword_1_1_1()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__CopyFieldNameToVariableStmt__Group_1_1__1__Impl909); 
             after(grammarAccess.getCopyFieldNameToVariableStmtAccess().getVARKeyword_1_1_1()); 

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
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__Group_1_1__1__Impl"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__Group_1_1__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:502:1: rule__CopyFieldNameToVariableStmt__Group_1_1__2 : rule__CopyFieldNameToVariableStmt__Group_1_1__2__Impl rule__CopyFieldNameToVariableStmt__Group_1_1__3 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:506:1: ( rule__CopyFieldNameToVariableStmt__Group_1_1__2__Impl rule__CopyFieldNameToVariableStmt__Group_1_1__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:507:2: rule__CopyFieldNameToVariableStmt__Group_1_1__2__Impl rule__CopyFieldNameToVariableStmt__Group_1_1__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_1__2__Impl_in_rule__CopyFieldNameToVariableStmt__Group_1_1__2940);
            rule__CopyFieldNameToVariableStmt__Group_1_1__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_1__3_in_rule__CopyFieldNameToVariableStmt__Group_1_1__2943);
            rule__CopyFieldNameToVariableStmt__Group_1_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__Group_1_1__2"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__Group_1_1__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:514:1: rule__CopyFieldNameToVariableStmt__Group_1_1__2__Impl : ( '=' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:518:1: ( ( '=' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:519:1: ( '=' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:519:1: ( '=' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:520:1: '='
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getEqualsSignKeyword_1_1_2()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__CopyFieldNameToVariableStmt__Group_1_1__2__Impl971); 
             after(grammarAccess.getCopyFieldNameToVariableStmtAccess().getEqualsSignKeyword_1_1_2()); 

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
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__Group_1_1__2__Impl"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__Group_1_1__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:533:1: rule__CopyFieldNameToVariableStmt__Group_1_1__3 : rule__CopyFieldNameToVariableStmt__Group_1_1__3__Impl ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:537:1: ( rule__CopyFieldNameToVariableStmt__Group_1_1__3__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:538:2: rule__CopyFieldNameToVariableStmt__Group_1_1__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_1__3__Impl_in_rule__CopyFieldNameToVariableStmt__Group_1_1__31002);
            rule__CopyFieldNameToVariableStmt__Group_1_1__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__Group_1_1__3"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__Group_1_1__3__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:544:1: rule__CopyFieldNameToVariableStmt__Group_1_1__3__Impl : ( ( rule__CopyFieldNameToVariableStmt__NameAssignment_1_1_3 ) ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:548:1: ( ( ( rule__CopyFieldNameToVariableStmt__NameAssignment_1_1_3 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:549:1: ( ( rule__CopyFieldNameToVariableStmt__NameAssignment_1_1_3 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:549:1: ( ( rule__CopyFieldNameToVariableStmt__NameAssignment_1_1_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:550:1: ( rule__CopyFieldNameToVariableStmt__NameAssignment_1_1_3 )
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getNameAssignment_1_1_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:551:1: ( rule__CopyFieldNameToVariableStmt__NameAssignment_1_1_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:551:2: rule__CopyFieldNameToVariableStmt__NameAssignment_1_1_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__NameAssignment_1_1_3_in_rule__CopyFieldNameToVariableStmt__Group_1_1__3__Impl1029);
            rule__CopyFieldNameToVariableStmt__NameAssignment_1_1_3();

            state._fsp--;


            }

             after(grammarAccess.getCopyFieldNameToVariableStmtAccess().getNameAssignment_1_1_3()); 

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
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__Group_1_1__3__Impl"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__Group_1_2__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:569:1: rule__CopyFieldNameToVariableStmt__Group_1_2__0 : rule__CopyFieldNameToVariableStmt__Group_1_2__0__Impl rule__CopyFieldNameToVariableStmt__Group_1_2__1 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:573:1: ( rule__CopyFieldNameToVariableStmt__Group_1_2__0__Impl rule__CopyFieldNameToVariableStmt__Group_1_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:574:2: rule__CopyFieldNameToVariableStmt__Group_1_2__0__Impl rule__CopyFieldNameToVariableStmt__Group_1_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_2__0__Impl_in_rule__CopyFieldNameToVariableStmt__Group_1_2__01067);
            rule__CopyFieldNameToVariableStmt__Group_1_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_2__1_in_rule__CopyFieldNameToVariableStmt__Group_1_2__01070);
            rule__CopyFieldNameToVariableStmt__Group_1_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__Group_1_2__0"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__Group_1_2__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:581:1: rule__CopyFieldNameToVariableStmt__Group_1_2__0__Impl : ( ',' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:585:1: ( ( ',' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:586:1: ( ',' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:586:1: ( ',' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:587:1: ','
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getCommaKeyword_1_2_0()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__CopyFieldNameToVariableStmt__Group_1_2__0__Impl1098); 
             after(grammarAccess.getCopyFieldNameToVariableStmtAccess().getCommaKeyword_1_2_0()); 

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
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__Group_1_2__0__Impl"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__Group_1_2__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:600:1: rule__CopyFieldNameToVariableStmt__Group_1_2__1 : rule__CopyFieldNameToVariableStmt__Group_1_2__1__Impl rule__CopyFieldNameToVariableStmt__Group_1_2__2 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:604:1: ( rule__CopyFieldNameToVariableStmt__Group_1_2__1__Impl rule__CopyFieldNameToVariableStmt__Group_1_2__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:605:2: rule__CopyFieldNameToVariableStmt__Group_1_2__1__Impl rule__CopyFieldNameToVariableStmt__Group_1_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_2__1__Impl_in_rule__CopyFieldNameToVariableStmt__Group_1_2__11129);
            rule__CopyFieldNameToVariableStmt__Group_1_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_2__2_in_rule__CopyFieldNameToVariableStmt__Group_1_2__11132);
            rule__CopyFieldNameToVariableStmt__Group_1_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__Group_1_2__1"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__Group_1_2__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:612:1: rule__CopyFieldNameToVariableStmt__Group_1_2__1__Impl : ( 'TYPE' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:616:1: ( ( 'TYPE' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:617:1: ( 'TYPE' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:617:1: ( 'TYPE' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:618:1: 'TYPE'
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getTYPEKeyword_1_2_1()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__CopyFieldNameToVariableStmt__Group_1_2__1__Impl1160); 
             after(grammarAccess.getCopyFieldNameToVariableStmtAccess().getTYPEKeyword_1_2_1()); 

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
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__Group_1_2__1__Impl"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__Group_1_2__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:631:1: rule__CopyFieldNameToVariableStmt__Group_1_2__2 : rule__CopyFieldNameToVariableStmt__Group_1_2__2__Impl rule__CopyFieldNameToVariableStmt__Group_1_2__3 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:635:1: ( rule__CopyFieldNameToVariableStmt__Group_1_2__2__Impl rule__CopyFieldNameToVariableStmt__Group_1_2__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:636:2: rule__CopyFieldNameToVariableStmt__Group_1_2__2__Impl rule__CopyFieldNameToVariableStmt__Group_1_2__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_2__2__Impl_in_rule__CopyFieldNameToVariableStmt__Group_1_2__21191);
            rule__CopyFieldNameToVariableStmt__Group_1_2__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_2__3_in_rule__CopyFieldNameToVariableStmt__Group_1_2__21194);
            rule__CopyFieldNameToVariableStmt__Group_1_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__Group_1_2__2"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__Group_1_2__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:643:1: rule__CopyFieldNameToVariableStmt__Group_1_2__2__Impl : ( '=' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:647:1: ( ( '=' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:648:1: ( '=' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:648:1: ( '=' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:649:1: '='
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getEqualsSignKeyword_1_2_2()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__CopyFieldNameToVariableStmt__Group_1_2__2__Impl1222); 
             after(grammarAccess.getCopyFieldNameToVariableStmtAccess().getEqualsSignKeyword_1_2_2()); 

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
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__Group_1_2__2__Impl"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__Group_1_2__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:662:1: rule__CopyFieldNameToVariableStmt__Group_1_2__3 : rule__CopyFieldNameToVariableStmt__Group_1_2__3__Impl ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:666:1: ( rule__CopyFieldNameToVariableStmt__Group_1_2__3__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:667:2: rule__CopyFieldNameToVariableStmt__Group_1_2__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_2__3__Impl_in_rule__CopyFieldNameToVariableStmt__Group_1_2__31253);
            rule__CopyFieldNameToVariableStmt__Group_1_2__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__Group_1_2__3"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__Group_1_2__3__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:673:1: rule__CopyFieldNameToVariableStmt__Group_1_2__3__Impl : ( 'REPLACE' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:677:1: ( ( 'REPLACE' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:678:1: ( 'REPLACE' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:678:1: ( 'REPLACE' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:679:1: 'REPLACE'
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getREPLACEKeyword_1_2_3()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__CopyFieldNameToVariableStmt__Group_1_2__3__Impl1281); 
             after(grammarAccess.getCopyFieldNameToVariableStmtAccess().getREPLACEKeyword_1_2_3()); 

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
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__Group_1_2__3__Impl"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__UnorderedGroup_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:701:1: rule__CopyFieldNameToVariableStmt__UnorderedGroup_1 : rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__0 {...}?;
    public final void rule__CopyFieldNameToVariableStmt__UnorderedGroup_1() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1());
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:706:1: ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__0 {...}?)
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:707:2: rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__0 {...}?
            {
            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__0_in_rule__CopyFieldNameToVariableStmt__UnorderedGroup_11321);
            rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__0();

            state._fsp--;

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1()) ) {
                throw new FailedPredicateException(input, "rule__CopyFieldNameToVariableStmt__UnorderedGroup_1", "getUnorderedGroupHelper().canLeave(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1())");
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__UnorderedGroup_1"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:718:1: rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl : ( ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_2__0 ) ) ) ) ) ;
    public final void rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:723:1: ( ( ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_2__0 ) ) ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:724:3: ( ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_2__0 ) ) ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:724:3: ( ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_2__0 ) ) ) ) )
            int alt1=3;
            int LA1_0 = input.LA(1);

            if ( LA1_0 ==12 && ( getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 0) || getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 1) || getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 2) ) ) {
                int LA1_1 = input.LA(2);

                if ( LA1_1 ==13 && getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 0) ) {
                    alt1=1;
                }
                else if ( LA1_1 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 1) ) {
                    alt1=2;
                }
                else if ( LA1_1 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 2) ) {
                    alt1=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:726:4: ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_0__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:726:4: ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_0__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:727:5: {...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 0) ) {
                        throw new FailedPredicateException(input, "rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 0)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:727:124: ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_0__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:728:6: ( ( rule__CopyFieldNameToVariableStmt__Group_1_0__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:734:6: ( ( rule__CopyFieldNameToVariableStmt__Group_1_0__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:736:7: ( rule__CopyFieldNameToVariableStmt__Group_1_0__0 )
                    {
                     before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getGroup_1_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:737:7: ( rule__CopyFieldNameToVariableStmt__Group_1_0__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:737:8: rule__CopyFieldNameToVariableStmt__Group_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_0__0_in_rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl1410);
                    rule__CopyFieldNameToVariableStmt__Group_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getCopyFieldNameToVariableStmtAccess().getGroup_1_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:743:4: ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_1__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:743:4: ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_1__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:744:5: {...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 1) ) {
                        throw new FailedPredicateException(input, "rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 1)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:744:124: ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_1__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:745:6: ( ( rule__CopyFieldNameToVariableStmt__Group_1_1__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:751:6: ( ( rule__CopyFieldNameToVariableStmt__Group_1_1__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:753:7: ( rule__CopyFieldNameToVariableStmt__Group_1_1__0 )
                    {
                     before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getGroup_1_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:754:7: ( rule__CopyFieldNameToVariableStmt__Group_1_1__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:754:8: rule__CopyFieldNameToVariableStmt__Group_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_1__0_in_rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl1501);
                    rule__CopyFieldNameToVariableStmt__Group_1_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getCopyFieldNameToVariableStmtAccess().getGroup_1_1()); 

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:760:4: ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_2__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:760:4: ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_2__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:761:5: {...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_2__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 2) ) {
                        throw new FailedPredicateException(input, "rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 2)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:761:124: ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_2__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:762:6: ( ( rule__CopyFieldNameToVariableStmt__Group_1_2__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 2);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:768:6: ( ( rule__CopyFieldNameToVariableStmt__Group_1_2__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:770:7: ( rule__CopyFieldNameToVariableStmt__Group_1_2__0 )
                    {
                     before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getGroup_1_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:771:7: ( rule__CopyFieldNameToVariableStmt__Group_1_2__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:771:8: rule__CopyFieldNameToVariableStmt__Group_1_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_2__0_in_rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl1592);
                    rule__CopyFieldNameToVariableStmt__Group_1_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getCopyFieldNameToVariableStmtAccess().getGroup_1_2()); 

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:786:1: rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__0 : rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__1 )? ;
    public final void rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:790:1: ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__1 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:791:2: rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl_in_rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__01651);
            rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl();

            state._fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:792:2: ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__1 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( LA2_0 ==12 && ( getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 0) || getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 1) || getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 2) ) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:792:2: rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__1_in_rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__01654);
                    rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__1();

                    state._fsp--;


                    }
                    break;

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
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__0"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:799:1: rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__1 : rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__2 )? ;
    public final void rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:803:1: ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:804:2: rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__2 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl_in_rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__11679);
            rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl();

            state._fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:805:2: ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__2 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( LA3_0 ==12 && ( getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 0) || getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 1) || getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 2) ) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:805:2: rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__2_in_rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__11682);
                    rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__2();

                    state._fsp--;


                    }
                    break;

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
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__1"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:812:1: rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__2 : rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl ;
    public final void rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:816:1: ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:817:2: rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl_in_rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__21707);
            rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__2"


    // $ANTLR start "rule__Model__StmtAssignment"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:830:1: rule__Model__StmtAssignment : ( ruleCopyFieldNameToVariableStmt ) ;
    public final void rule__Model__StmtAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:834:1: ( ( ruleCopyFieldNameToVariableStmt ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:835:1: ( ruleCopyFieldNameToVariableStmt )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:835:1: ( ruleCopyFieldNameToVariableStmt )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:836:1: ruleCopyFieldNameToVariableStmt
            {
             before(grammarAccess.getModelAccess().getStmtCopyFieldNameToVariableStmtParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleCopyFieldNameToVariableStmt_in_rule__Model__StmtAssignment1741);
            ruleCopyFieldNameToVariableStmt();

            state._fsp--;

             after(grammarAccess.getModelAccess().getStmtCopyFieldNameToVariableStmtParserRuleCall_0()); 

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
    // $ANTLR end "rule__Model__StmtAssignment"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__LineAssignment_1_0_4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:845:1: rule__CopyFieldNameToVariableStmt__LineAssignment_1_0_4 : ( RULE_INT ) ;
    public final void rule__CopyFieldNameToVariableStmt__LineAssignment_1_0_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:849:1: ( ( RULE_INT ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:850:1: ( RULE_INT )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:850:1: ( RULE_INT )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:851:1: RULE_INT
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getLineINTTerminalRuleCall_1_0_4_0()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__CopyFieldNameToVariableStmt__LineAssignment_1_0_41772); 
             after(grammarAccess.getCopyFieldNameToVariableStmtAccess().getLineINTTerminalRuleCall_1_0_4_0()); 

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
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__LineAssignment_1_0_4"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__ColumnAssignment_1_0_6"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:860:1: rule__CopyFieldNameToVariableStmt__ColumnAssignment_1_0_6 : ( RULE_INT ) ;
    public final void rule__CopyFieldNameToVariableStmt__ColumnAssignment_1_0_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:864:1: ( ( RULE_INT ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:865:1: ( RULE_INT )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:865:1: ( RULE_INT )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:866:1: RULE_INT
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getColumnINTTerminalRuleCall_1_0_6_0()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__CopyFieldNameToVariableStmt__ColumnAssignment_1_0_61803); 
             after(grammarAccess.getCopyFieldNameToVariableStmtAccess().getColumnINTTerminalRuleCall_1_0_6_0()); 

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
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__ColumnAssignment_1_0_6"


    // $ANTLR start "rule__CopyFieldNameToVariableStmt__NameAssignment_1_1_3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:875:1: rule__CopyFieldNameToVariableStmt__NameAssignment_1_1_3 : ( RULE_ID ) ;
    public final void rule__CopyFieldNameToVariableStmt__NameAssignment_1_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:879:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:880:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:880:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug381381TestLanguage.g:881:1: RULE_ID
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getNameIDTerminalRuleCall_1_1_3_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__CopyFieldNameToVariableStmt__NameAssignment_1_1_31834); 
             after(grammarAccess.getCopyFieldNameToVariableStmtAccess().getNameIDTerminalRuleCall_1_1_3_0()); 

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
    // $ANTLR end "rule__CopyFieldNameToVariableStmt__NameAssignment_1_1_3"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__StmtAssignment_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCopyFieldNameToVariableStmt_in_entryRuleCopyFieldNameToVariableStmt121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCopyFieldNameToVariableStmt128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__Group__0_in_ruleCopyFieldNameToVariableStmt154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__Group__0__Impl_in_rule__CopyFieldNameToVariableStmt__Group__0188 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__Group__1_in_rule__CopyFieldNameToVariableStmt__Group__0191 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__CopyFieldNameToVariableStmt__Group__0__Impl219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__Group__1__Impl_in_rule__CopyFieldNameToVariableStmt__Group__1250 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__UnorderedGroup_1_in_rule__CopyFieldNameToVariableStmt__Group__1__Impl277 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_0__0__Impl_in_rule__CopyFieldNameToVariableStmt__Group_1_0__0311 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_0__1_in_rule__CopyFieldNameToVariableStmt__Group_1_0__0314 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__CopyFieldNameToVariableStmt__Group_1_0__0__Impl342 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_0__1__Impl_in_rule__CopyFieldNameToVariableStmt__Group_1_0__1373 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_0__2_in_rule__CopyFieldNameToVariableStmt__Group_1_0__1376 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__CopyFieldNameToVariableStmt__Group_1_0__1__Impl404 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_0__2__Impl_in_rule__CopyFieldNameToVariableStmt__Group_1_0__2435 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_0__3_in_rule__CopyFieldNameToVariableStmt__Group_1_0__2438 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__CopyFieldNameToVariableStmt__Group_1_0__2__Impl466 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_0__3__Impl_in_rule__CopyFieldNameToVariableStmt__Group_1_0__3497 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_0__4_in_rule__CopyFieldNameToVariableStmt__Group_1_0__3500 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__CopyFieldNameToVariableStmt__Group_1_0__3__Impl528 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_0__4__Impl_in_rule__CopyFieldNameToVariableStmt__Group_1_0__4559 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_0__5_in_rule__CopyFieldNameToVariableStmt__Group_1_0__4562 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__LineAssignment_1_0_4_in_rule__CopyFieldNameToVariableStmt__Group_1_0__4__Impl589 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_0__5__Impl_in_rule__CopyFieldNameToVariableStmt__Group_1_0__5619 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_0__6_in_rule__CopyFieldNameToVariableStmt__Group_1_0__5622 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__CopyFieldNameToVariableStmt__Group_1_0__5__Impl650 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_0__6__Impl_in_rule__CopyFieldNameToVariableStmt__Group_1_0__6681 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_0__7_in_rule__CopyFieldNameToVariableStmt__Group_1_0__6684 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__ColumnAssignment_1_0_6_in_rule__CopyFieldNameToVariableStmt__Group_1_0__6__Impl711 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_0__7__Impl_in_rule__CopyFieldNameToVariableStmt__Group_1_0__7741 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__CopyFieldNameToVariableStmt__Group_1_0__7__Impl769 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_1__0__Impl_in_rule__CopyFieldNameToVariableStmt__Group_1_1__0816 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_1__1_in_rule__CopyFieldNameToVariableStmt__Group_1_1__0819 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__CopyFieldNameToVariableStmt__Group_1_1__0__Impl847 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_1__1__Impl_in_rule__CopyFieldNameToVariableStmt__Group_1_1__1878 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_1__2_in_rule__CopyFieldNameToVariableStmt__Group_1_1__1881 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__CopyFieldNameToVariableStmt__Group_1_1__1__Impl909 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_1__2__Impl_in_rule__CopyFieldNameToVariableStmt__Group_1_1__2940 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_1__3_in_rule__CopyFieldNameToVariableStmt__Group_1_1__2943 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__CopyFieldNameToVariableStmt__Group_1_1__2__Impl971 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_1__3__Impl_in_rule__CopyFieldNameToVariableStmt__Group_1_1__31002 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__NameAssignment_1_1_3_in_rule__CopyFieldNameToVariableStmt__Group_1_1__3__Impl1029 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_2__0__Impl_in_rule__CopyFieldNameToVariableStmt__Group_1_2__01067 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_2__1_in_rule__CopyFieldNameToVariableStmt__Group_1_2__01070 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__CopyFieldNameToVariableStmt__Group_1_2__0__Impl1098 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_2__1__Impl_in_rule__CopyFieldNameToVariableStmt__Group_1_2__11129 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_2__2_in_rule__CopyFieldNameToVariableStmt__Group_1_2__11132 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__CopyFieldNameToVariableStmt__Group_1_2__1__Impl1160 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_2__2__Impl_in_rule__CopyFieldNameToVariableStmt__Group_1_2__21191 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_2__3_in_rule__CopyFieldNameToVariableStmt__Group_1_2__21194 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__CopyFieldNameToVariableStmt__Group_1_2__2__Impl1222 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_2__3__Impl_in_rule__CopyFieldNameToVariableStmt__Group_1_2__31253 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__CopyFieldNameToVariableStmt__Group_1_2__3__Impl1281 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__0_in_rule__CopyFieldNameToVariableStmt__UnorderedGroup_11321 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_0__0_in_rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl1410 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_1__0_in_rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl1501 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__Group_1_2__0_in_rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl1592 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl_in_rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__01651 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__1_in_rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__01654 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl_in_rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__11679 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__2_in_rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__11682 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl_in_rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__21707 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCopyFieldNameToVariableStmt_in_rule__Model__StmtAssignment1741 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__CopyFieldNameToVariableStmt__LineAssignment_1_0_41772 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__CopyFieldNameToVariableStmt__ColumnAssignment_1_0_61803 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__CopyFieldNameToVariableStmt__NameAssignment_1_1_31834 = new BitSet(new long[]{0x0000000000000002L});
    }


}